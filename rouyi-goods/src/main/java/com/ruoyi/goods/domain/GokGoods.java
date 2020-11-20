package com.ruoyi.goods.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品对象 gok_goods
 *
 * @author ruoyi
 * @date 2020-11-20
 */
public class GokGoods extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 商品编号 */
    @Excel(name = "商品编号")
    private String goodId;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String goodName;

    /** 商品价格 */
    @Excel(name = "商品价格")
    private BigDecimal goodPrice;

    /** 商品图片 */
    @Excel(name = "商品图片")
    private String goodImage;

    /** 商品生产日期 */
    @Excel(name = "商品生产日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date goodCreatedTime;

    /** 商品状态 */
    @Excel(name = "商品状态")
    private Long goodStatus;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setGoodId(String goodId)
    {
        this.goodId = goodId;
    }

    public String getGoodId()
    {
        return goodId;
    }
    public void setGoodName(String goodName)
    {
        this.goodName = goodName;
    }

    public String getGoodName()
    {
        return goodName;
    }
    public void setGoodPrice(BigDecimal goodPrice)
    {
        this.goodPrice = goodPrice;
    }

    public BigDecimal getGoodPrice()
    {
        return goodPrice;
    }
    public void setGoodImage(String goodImage)
    {
        this.goodImage = goodImage;
    }

    public String getGoodImage()
    {
        return goodImage;
    }
    public void setGoodCreatedTime(Date goodCreatedTime)
    {
        this.goodCreatedTime = goodCreatedTime;
    }

    public Date getGoodCreatedTime()
    {
        return goodCreatedTime;
    }
    public void setGoodStatus(Long goodStatus)
    {
        this.goodStatus = goodStatus;
    }

    public Long getGoodStatus()
    {
        return goodStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("goodId", getGoodId())
            .append("goodName", getGoodName())
            .append("goodPrice", getGoodPrice())
            .append("goodImage", getGoodImage())
            .append("goodCreatedTime", getGoodCreatedTime())
            .append("goodStatus", getGoodStatus())
            .toString();
    }
}
