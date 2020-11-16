package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.GokOrder;

/**
 * 订单Mapper接口
 * 
 * @author kingwan
 * @date 2020-11-16
 */
public interface GokOrderMapper 
{
    /**
     * 查询订单
     * 
     * @param id 订单ID
     * @return 订单
     */
    public GokOrder selectGokOrderById(Long id);

    /**
     * 查询订单列表
     * 
     * @param gokOrder 订单
     * @return 订单集合
     */
    public List<GokOrder> selectGokOrderList(GokOrder gokOrder);

    /**
     * 新增订单
     * 
     * @param gokOrder 订单
     * @return 结果
     */
    public int insertGokOrder(GokOrder gokOrder);

    /**
     * 修改订单
     * 
     * @param gokOrder 订单
     * @return 结果
     */
    public int updateGokOrder(GokOrder gokOrder);

    /**
     * 删除订单
     * 
     * @param id 订单ID
     * @return 结果
     */
    public int deleteGokOrderById(Long id);

    /**
     * 批量删除订单
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGokOrderByIds(String[] ids);
}
