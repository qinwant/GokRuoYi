package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 订单对象 gok_order
 *
 * @author ruoyi
 * @date 2020-11-16
 */
public class GokOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 订单号 */
    @Excel(name = "订单号")
    private String orderId;

    /** 订单内容 */
    @Excel(name = "订单内容")
    private String orderContent;

    /** 订单金额 */
    @Excel(name = "订单金额")
    private String orderAmount;

    /** 订单创建时间 */
    @Excel(name = "订单创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderCreateTime;

    /** 订单支付时间 */
    @Excel(name = "订单支付时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderPaidTime;

    /** 消费者id */
    @Excel(name = "消费者id")
    private Long userId;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    public String getOrderId()
    {
        return orderId;
    }
    public void setOrderContent(String orderContent)
    {
        this.orderContent = orderContent;
    }

    public String getOrderContent()
    {
        return orderContent;
    }
    public void setOrderAmount(String orderAmount)
    {
        this.orderAmount = orderAmount;
    }

    public String getOrderAmount()
    {
        return orderAmount;
    }
    public void setOrderCreateTime(Date orderCreateTime)
    {
        this.orderCreateTime = orderCreateTime;
    }

    public Date getOrderCreateTime()
    {
        return orderCreateTime;
    }
    public void setOrderPaidTime(Date orderPaidTime)
    {
        this.orderPaidTime = orderPaidTime;
    }

    public Date getOrderPaidTime()
    {
        return orderPaidTime;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderId", getOrderId())
            .append("orderContent", getOrderContent())
            .append("orderAmount", getOrderAmount())
            .append("orderCreateTime", getOrderCreateTime())
            .append("orderPaidTime", getOrderPaidTime())
            .append("userId", getUserId())
            .toString();
    }
}
