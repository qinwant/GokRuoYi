package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.GokOrder;
import com.ruoyi.system.mapper.GokOrderMapper;
import com.ruoyi.system.service.IGokOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单Service业务层处理
 *
 * @author ruoyi
 * @date 2020-11-16
 */
@Service
public class GokOrderServiceImpl implements IGokOrderService
{
    @Autowired
    private GokOrderMapper gokOrderMapper;

    /**
     * 查询订单
     *
     * @param id 订单ID
     * @return 订单
     */
    @Override
    public GokOrder selectGokOrderById(Long id)
    {
        return gokOrderMapper.selectGokOrderById(id);
    }

    /**
     * 查询订单列表
     *
     * @param gokOrder 订单
     * @return 订单
     */
    @Override
    public List<GokOrder> selectGokOrderList(GokOrder gokOrder)
    {
        return gokOrderMapper.selectGokOrderList(gokOrder);
    }

    /**
     * 新增订单
     *
     * @param gokOrder 订单
     * @return 结果
     */
    @Override
    public int insertGokOrder(GokOrder gokOrder)
    {
        return gokOrderMapper.insertGokOrder(gokOrder);
    }

    /**
     * 修改订单
     *
     * @param gokOrder 订单
     * @return 结果
     */
    @Override
    public int updateGokOrder(GokOrder gokOrder)
    {
        return gokOrderMapper.updateGokOrder(gokOrder);
    }

    /**
     * 删除订单对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGokOrderByIds(String ids)
    {
        return gokOrderMapper.deleteGokOrderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除订单信息
     *
     * @param id 订单ID
     * @return 结果
     */
    @Override
    public int deleteGokOrderById(Long id)
    {
        return gokOrderMapper.deleteGokOrderById(id);
    }
}
