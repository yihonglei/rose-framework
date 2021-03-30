package com.jpeony.coupon.dal.entitys;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_sale_coupon_code")
public class SaleCouponCode implements Serializable {
    @Id
    private Long id;

    /**
     * 优惠码
     */
    private String code;

    /**
     * 优惠券id
     */
    @Column(name = "coupon_id")
    private Long couponId;

    /**
     * 0 未领取 1 已领取未使用 2 冻结中 3 已使用 4 已过期
     */
    private Byte status;

    @Column(name = "user_id")
    private Long userId;

    /**
     * 关联的订单id
     */
    @Column(name = "order_id")
    private Long orderId;

    /**
     * 使用时间
     */
    @Column(name = "consume_time")
    private Date consumeTime;

    private Date created;

    private Date updated;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取优惠码
     *
     * @return code - 优惠码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置优惠码
     *
     * @param code 优惠码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取优惠券id
     *
     * @return coupon_id - 优惠券id
     */
    public Long getCouponId() {
        return couponId;
    }

    /**
     * 设置优惠券id
     */
    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    /**
     * 获取0 未领取 1 已领取未使用 2 冻结中 3 已使用 4 已过期
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置0 未领取 1 已领取未使用 2 冻结中 3 已使用 4 已过期
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取关联的订单id
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * 设置关联的订单id
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取使用时间
     */
    public Date getConsumeTime() {
        return consumeTime;
    }

    /**
     * 设置使用时间
     */
    public void setConsumeTime(Date consumeTime) {
        this.consumeTime = consumeTime;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }
    
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}