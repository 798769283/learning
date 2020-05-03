package com.ruoyi.web.controller.learning;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.LClass;
import com.ruoyi.system.service.ILClassService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 班级Controller
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
@Controller
@RequestMapping("/system/class")
public class LClassController extends BaseController
{
    private String prefix = "learning/class";

    @Autowired
    private ILClassService lClassService;

    @RequiresPermissions("system:class:view")
    @GetMapping()
    public String lclass(){
        return prefix + "/class";
    }

    /**
     * 查询班级列表
     */
    @RequiresPermissions("system:class:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LClass lClass)
    {
        startPage();
        List<LClass> list = lClassService.selectLClassList(lClass);
        return getDataTable(list);
    }

    /**
     * 导出班级列表
     */
    @RequiresPermissions("system:class:export")
    @Log(title = "班级", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LClass lClass)
    {
        List<LClass> list = lClassService.selectLClassList(lClass);
        ExcelUtil<LClass> util = new ExcelUtil<LClass>(LClass.class);
        return util.exportExcel(list, "class");
    }

    /**
     * 新增班级
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存班级
     */
    @RequiresPermissions("system:class:add")
    @Log(title = "班级", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LClass lClass)
    {
        return toAjax(lClassService.insertLClass(lClass));
    }

    /**
     * 修改班级
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        LClass lClass = lClassService.selectLClassById(id);
        mmap.put("lClass", lClass);
        return prefix + "/edit";
    }

    /**
     * 修改保存班级
     */
    @RequiresPermissions("system:class:edit")
    @Log(title = "班级", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LClass lClass)
    {
        return toAjax(lClassService.updateLClass(lClass));
    }

    /**
     * 删除班级
     */
    @RequiresPermissions("system:class:remove")
    @Log(title = "班级", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(lClassService.deleteLClassByIds(ids));
    }
}
