package com.ruoyi.goods.service;

import com.ruoyi.goods.domain.GokGoods;

import java.util.List;

/**
 * 商品Service接口
 *
 * @author ruoyi
 * @date 2020-11-20
 */
public interface IGokGoodsService
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
     * 批量删除商品
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGokGoodsByIds(String ids);

    /**
     * 删除商品信息
     *
     * @param id 商品ID
     * @return 结果
     */
    public int deleteGokGoodsById(Long id);

    /**
     * 导入商品
     * @param userList
     * @param isUpdateSupport
     * @param operName
     * @return
     */
//    public String importGoods(List<GokGoods> userList, Boolean isUpdateSupport, String operName);
    public String importGoods(List<GokGoods> goodList, Boolean isUpdateSupport);
}
