package com.ruoyi.goods.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.goods.domain.GokGoods;
import com.ruoyi.goods.mapper.GokGoodsMapper;
import com.ruoyi.goods.service.IGokGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品Service业务层处理
 *
 * @author ruoyi
 * @date 2020-11-20
 */
@Service
public class GokGoodsServiceImpl implements IGokGoodsService
{
    @Autowired
    private GokGoodsMapper gokGoodsMapper;

    /**
     * 查询商品
     *
     * @param id 商品ID
     * @return 商品
     */
    @Override
    public GokGoods selectGokGoodsById(Long id)
    {
        return gokGoodsMapper.selectGokGoodsById(id);
    }

    /**
     * 查询商品列表
     *
     * @param gokGoods 商品
     * @return 商品
     */
    @Override
    public List<GokGoods> selectGokGoodsList(GokGoods gokGoods)
    {
        return gokGoodsMapper.selectGokGoodsList(gokGoods);
    }

    /**
     * 新增商品
     *
     * @param gokGoods 商品
     * @return 结果
     */
    @Override
    public int insertGokGoods(GokGoods gokGoods)
    {
        return gokGoodsMapper.insertGokGoods(gokGoods);
    }

    /**
     * 修改商品
     *
     * @param gokGoods 商品
     * @return 结果
     */
    @Override
    public int updateGokGoods(GokGoods gokGoods)
    {
        return gokGoodsMapper.updateGokGoods(gokGoods);
    }

    /**
     * 删除商品对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGokGoodsByIds(String ids)
    {
        return gokGoodsMapper.deleteGokGoodsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品信息
     *
     * @param id 商品ID
     * @return 结果
     */
    @Override
    public int deleteGokGoodsById(Long id)
    {
        return gokGoodsMapper.deleteGokGoodsById(id);
    }

    /**
     * 导入商品数据
     */
    @Override
    public String importGoods(List<GokGoods> goodList, Boolean isUpdateSupport) {
        if (StringUtils.isNull(goodList) || goodList.size() == 0)
        {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (GokGoods good : goodList)
        {
            try
            {
                // 验证是否存在这个用户
                GokGoods g = gokGoodsMapper.selectGokGoodsById(good.getId());
                if (StringUtils.isNull(g))
                {
                    this.insertGokGoods(good);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、商品 " + good.getGoodName() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    this.updateGokGoods(good);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、商品 " + good.getGoodName() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、商品 " + good.getGoodName() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、商品 " + good.getGoodName() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new BusinessException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}
