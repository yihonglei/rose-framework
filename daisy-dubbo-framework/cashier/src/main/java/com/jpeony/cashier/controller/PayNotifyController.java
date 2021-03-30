package com.jpeony.cashier.controller;

import com.alibaba.fastjson.JSON;
import com.jpeony.pay.PayCoreService;
import com.jpeony.pay.dto.PaymentNotifyRequest;
import com.jpeony.pay.dto.PaymentNotifyResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

@Slf4j
@RestController
public class PayNotifyController {

    @Reference(timeout = 3000)
    private PayCoreService payCoreService;

    /**
     * 支付宝支付结果异步通知
     */
    @PostMapping("/pay/alipayNotify")
    public String doAliPay(HttpServletRequest httpServletRequest) {
        return commonAliDo("ali_pay", httpServletRequest);
    }

    /**
     * 微信支付异步返回通知
     */
    @RequestMapping("/pay/wechatPayNotify")
    public String doWeChantPay(HttpServletRequest httpServletRequest) {
        return commonWeChatDo("wechat_pay", httpServletRequest);
    }

    /**
     * 支付宝退款异步返回
     */
    @PostMapping("/refund/aliRefundNotify")
    public String doAliRefund(HttpServletRequest httpServletRequest) {
        return commonAliDo("ali_refund", httpServletRequest);
    }

    /**
     * 微信退款异步返回
     */
    @PostMapping("/refund/wechatRefundNotify")
    public String doWechatRefund(HttpServletRequest httpServletRequest) {
        return commonWeChatDo("wechat_refund", httpServletRequest);
    }

    /**
     * 支付宝异步通知返回解析
     */
    private String commonAliDo(String channel, HttpServletRequest httpServletRequest) {
        Map<String, String[]> map = httpServletRequest.getParameterMap();
        PaymentNotifyRequest paymentNotifyRequest = new PaymentNotifyRequest();
        paymentNotifyRequest.setPayChannel(channel);
        paymentNotifyRequest.setResultMap(map);
        PaymentNotifyResponse paymentNotifyResponse = payCoreService.paymentResultNotify(paymentNotifyRequest);
        return paymentNotifyResponse.getResult();
    }

    /**
     * 微信异步通知返回解析
     */
    private String commonWeChatDo(String channel, HttpServletRequest httpServletRequest) {
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = null;
        InputStream inputStream = null;
        try {
            inputStream = httpServletRequest.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String a;
            while ((a = bufferedReader.readLine()) != null) {
                stringBuffer.append(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null == bufferedReader) {
                try {
                    inputStream.close();
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        PaymentNotifyRequest paymentNotifyRequest = new PaymentNotifyRequest();
        paymentNotifyRequest.setPayChannel(channel);
        paymentNotifyRequest.setXml(stringBuffer.toString());
        PaymentNotifyResponse paymentNotifyResponse = payCoreService.paymentResultNotify(paymentNotifyRequest);
        return "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
    }
}
