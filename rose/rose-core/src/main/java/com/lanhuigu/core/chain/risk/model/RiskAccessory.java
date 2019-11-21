package com.lanhuigu.core.chain.risk.model;

import com.lanhuigu.common.pojo.vo.RiskVO;
import lombok.Data;

/**
 * 过滤需要的资源
 *
 * @author yihonglei
 * @date 2019/10/31 4:49 PM
 */
@Data
public class RiskAccessory<T> {
    /**
     * 上下文
     */
    private RiskContext riskContext;
    /**
     * 返回结果
     */
    private RiskVO riskVO;

    public RiskAccessory() {
        riskVO = new RiskVO();
    }
}