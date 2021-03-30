package com.jpeony.order.biz.factory;

import com.jpeony.order.biz.handler.*;
import com.jpeony.order.biz.context.CreateOrderContext;
import com.jpeony.order.biz.context.TransHandlerContext;
import com.jpeony.order.biz.convert.CreateOrderConvert;
import com.jpeony.order.biz.convert.TransConvert;
import com.jpeony.order.dto.CreateOrderRequest;
import com.jpeony.order.biz.handler.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 构建订单处理链
 */
@Slf4j
@Service
public class OrderProcessPipelineFactory extends AbstranctTransPipelineFactory<CreateOrderRequest> {

    @Autowired
    private InitOrderHandler initOrderHandler;
    @Autowired
    private ValidateHandler validateHandler;
    @Autowired
    private LogisticalHandler logisticalHandler;
    @Autowired
    private ClearCartItemHandler clearCartItemHandler;
    @Autowired
    private SubStockHandler subStockHandler;
    @Autowired
    private SendMessageHandler sendMessageHandler;

    @Override
    protected TransHandlerContext createContext() {
        CreateOrderContext createOrderContext = new CreateOrderContext();
        return createOrderContext;
    }

    @Override
    protected void doBuild(TransPipeline pipeline) {
        pipeline.addLast(validateHandler);
        pipeline.addLast(subStockHandler);
        pipeline.addLast(initOrderHandler);
        pipeline.addLast(logisticalHandler);
        pipeline.addLast(clearCartItemHandler);
        pipeline.addLast(sendMessageHandler);
    }

    @Override
    protected TransConvert createConvert() { //构建转换器
        return new CreateOrderConvert();
    }
}
