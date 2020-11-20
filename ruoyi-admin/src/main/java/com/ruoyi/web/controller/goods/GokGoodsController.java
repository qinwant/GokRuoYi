package com.ruoyi.web.controller.goods;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.goods.domain.GokGoods;
import com.ruoyi.goods.service.IGokGoodsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 商品Controller
 *
 * @author ruoyi
 * @date 2020-11-20
 */
@Controller
@RequestMapping("/goods/goods")
public class GokGoodsController extends BaseController
{
    private String prefix = "goods/goods";

    @Autowired
    private IGokGoodsService gokGoodsService;

    @RequiresPermissions("goods:goods:view")
    @GetMapping()
    public String goods()
    {
        return prefix + "/goods";
    }

    /**
     * 查询商品列表
     */
    @RequiresPermissions("goods:goods:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GokGoods gokGoods)
    {
        startPage();
        List<GokGoods> list = gokGoodsService.selectGokGoodsList(gokGoods);
        return getDataTable(list);
    }

    /**
     * 导出商品列表
     */
    @RequiresPermissions("goods:goods:export")
    @Log(title = "商品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GokGoods gokGoods)
    {
        List<GokGoods> list = gokGoodsService.selectGokGoodsList(gokGoods);
        ExcelUtil<GokGoods> util = new ExcelUtil<GokGoods>(GokGoods.class);
        return util.exportExcel(list, "goods");
    }

    /**
     *导入商品
     * kingwan
     */
    @Log(title = "商品", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<GokGoods> util = new ExcelUtil<GokGoods>(GokGoods.class);
        List<GokGoods> goodList = util.importExcel(file.getInputStream());
//        String operName = ShiroUtils.getSysUser().getLoginName();
//        String message = gokGoodsService.importGoods(goodList, updateSupport, operName);
        String message = gokGoodsService.importGoods(goodList, updateSupport);
        return AjaxResult.success(message);
    }


    /**
     * 新增商品
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商品
     */
    @RequiresPermissions("goods:goods:add")
    @Log(title = "商品", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GokGoods gokGoods)
    {
        return toAjax(gokGoodsService.insertGokGoods(gokGoods));
    }

    /**
     * 修改商品
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        GokGoods gokGoods = gokGoodsService.selectGokGoodsById(id);
        mmap.put("gokGoods", gokGoods);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品
     */
    @RequiresPermissions("goods:goods:edit")
    @Log(title = "商品", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GokGoods gokGoods)
    {
        return toAjax(gokGoodsService.updateGokGoods(gokGoods));
    }

    /**
     * 删除商品
     */
    @RequiresPermissions("goods:goods:remove")
    @Log(title = "商品", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(gokGoodsService.deleteGokGoodsByIds(ids));
    }
}
