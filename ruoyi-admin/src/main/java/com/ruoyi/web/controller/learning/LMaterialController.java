package com.ruoyi.web.controller.learning;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.LMaterial;
import com.ruoyi.system.service.ILMaterialService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 资料Controller
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
@Controller
@RequestMapping("/system/material")
public class LMaterialController extends BaseController
{
    private String prefix = "learning/material";

    @Autowired
    private ILMaterialService lMaterialService;

    @RequiresPermissions("system:material:view")
    @GetMapping()
    public String material()
    {
        return prefix + "/material";
    }

    /**
     * 查询资料列表
     */
    @RequiresPermissions("system:material:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LMaterial lMaterial)
    {
        startPage();
        List<LMaterial> list = lMaterialService.selectLMaterialList(lMaterial);
        return getDataTable(list);
    }

    /**
     * 导出资料列表
     */
    @RequiresPermissions("system:material:export")
    @Log(title = "资料", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LMaterial lMaterial)
    {
        List<LMaterial> list = lMaterialService.selectLMaterialList(lMaterial);
        ExcelUtil<LMaterial> util = new ExcelUtil<LMaterial>(LMaterial.class);
        return util.exportExcel(list, "material");
    }

    /**
     * 新增资料
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存资料
     */
    @RequiresPermissions("system:material:add")
    @Log(title = "资料", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LMaterial lMaterial)
    {
        return toAjax(lMaterialService.insertLMaterial(lMaterial));
    }

    /**
     * 修改资料
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        LMaterial lMaterial = lMaterialService.selectLMaterialById(id);
        mmap.put("lMaterial", lMaterial);
        return prefix + "/edit";
    }

    /**
     * 修改保存资料
     */
    @RequiresPermissions("system:material:edit")
    @Log(title = "资料", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LMaterial lMaterial)
    {
        return toAjax(lMaterialService.updateLMaterial(lMaterial));
    }

    /**
     * 删除资料
     */
    @RequiresPermissions("system:material:remove")
    @Log(title = "资料", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(lMaterialService.deleteLMaterialByIds(ids));
    }
}
