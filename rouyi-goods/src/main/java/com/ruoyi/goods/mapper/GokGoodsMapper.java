package com.ruoyi.goods.mapper;

import com.ruoyi.goods.domain.GokGoods;

import java.util.List;

/**
 * 商品Mapper接口
 *
 * @author ruoyi
 * @date 2020-11-20
 */
public interface GokGoodsMapper
{
    /**
     * 查询商品
     *
     * @param id 商品ID
     * @return 商品
     */
    public GokGoods selectGokGoodsById(Long id);

    /**
     * 查询商品列表
     *
     * @param gokGoods 商品
     * @return 商品集合
     */
    public List<GokGoods> selectGokGoodsList(GokGoods gokGoods);

    /**
     * 新增商品
     *
     * @param gokGoods 商品
     * @return 结果
     */
    public int insertGokGoods(GokGoods gokGoods);

    /**
     * 修改商品
     *
     * @param gokGoods 商品
     * @return 结果
     */
    public int updateGokGoods(GokGoods gokGoods);

    /**
     * 删除商品
     *
     * @param id 商品ID
     * @return 结果
     */
    public int deleteGokGoodsById(Long id);

    /**
     * 批量删除商品
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGokGoodsByIds(String[] ids);
}
