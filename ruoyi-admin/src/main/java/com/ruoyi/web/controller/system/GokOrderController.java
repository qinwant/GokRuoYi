package com.ruoyi.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.GokOrder;
import com.ruoyi.system.service.IGokOrderService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单Controller
 *
 * @author kingwan
 * @date 2020-11-16
 */
@Controller
@RequestMapping("/system/order")
public class GokOrderController extends BaseController
{
    private String prefix = "system/order";

    @Autowired
    private IGokOrderService gokOrderService;

    @RequiresPermissions("system:order:view")
    @GetMapping()
    public String order()
    {
        return prefix + "/order";
    }

    /**
     * 查询订单列表
     */
    @RequiresPermissions("system:order:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GokOrder gokOrder)
    {
        startPage();
        List<GokOrder> list = gokOrderService.selectGokOrderList(gokOrder);
        return getDataTable(list);
    }

    /**
     * 导出订单列表
     */
    @RequiresPermissions("system:order:export")
    @Log(title = "订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GokOrder gokOrder)
    {
        List<GokOrder> list = gokOrderService.selectGokOrderList(gokOrder);
        ExcelUtil<GokOrder> util = new ExcelUtil<GokOrder>(GokOrder.class);
        return util.exportExcel(list, "order");
    }

    /**
     * 新增订单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存订单
     */
    @RequiresPermissions("system:order:add")
    @Log(title = "订单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GokOrder gokOrder)
    {
        return toAjax(gokOrderService.insertGokOrder(gokOrder));
    }

    /**
     * 修改订单
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        GokOrder gokOrder = gokOrderService.selectGokOrderById(id);
        mmap.put("gokOrder", gokOrder);
        return prefix + "/edit";
    }

    /**
     * 修改保存订单
     */
    @RequiresPermissions("system:order:edit")
    @Log(title = "订单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GokOrder gokOrder)
    {
        return toAjax(gokOrderService.updateGokOrder(gokOrder));
    }

    /**
     * 删除订单
     */
    @RequiresPermissions("system:order:remove")
    @Log(title = "订单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(gokOrderService.deleteGokOrderByIds(ids));
    }
}
