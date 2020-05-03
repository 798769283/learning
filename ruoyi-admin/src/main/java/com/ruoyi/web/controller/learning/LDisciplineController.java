package com.ruoyi.web.controller.learning;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.LDiscipline;
import com.ruoyi.system.service.ILDisciplineService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 专业课Controller
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
@Controller
@RequestMapping("/system/discipline")
public class LDisciplineController extends BaseController
{
    private String prefix = "learning/discipline";

    @Autowired
    private ILDisciplineService lDisciplineService;

    @RequiresPermissions("system:discipline:view")
    @GetMapping()
    public String discipline()
    {
        return prefix + "/discipline";
    }

    /**
     * 查询专业课列表
     */
    @RequiresPermissions("system:discipline:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LDiscipline lDiscipline)
    {
        startPage();
        List<LDiscipline> list = lDisciplineService.selectLDisciplineList(lDiscipline);
        return getDataTable(list);
    }

    /**
     * 导出专业课列表
     */
    @RequiresPermissions("system:discipline:export")
    @Log(title = "专业课", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LDiscipline lDiscipline)
    {
        List<LDiscipline> list = lDisciplineService.selectLDisciplineList(lDiscipline);
        ExcelUtil<LDiscipline> util = new ExcelUtil<LDiscipline>(LDiscipline.class);
        return util.exportExcel(list, "discipline");
    }

    /**
     * 新增专业课
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存专业课
     */
    @RequiresPermissions("system:discipline:add")
    @Log(title = "专业课", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LDiscipline lDiscipline)
    {
        return toAjax(lDisciplineService.insertLDiscipline(lDiscipline));
    }

    /**
     * 修改专业课
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        LDiscipline lDiscipline = lDisciplineService.selectLDisciplineById(id);
        mmap.put("lDiscipline", lDiscipline);
        return prefix + "/edit";
    }

    /**
     * 修改保存专业课
     */
    @RequiresPermissions("system:discipline:edit")
    @Log(title = "专业课", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LDiscipline lDiscipline)
    {
        return toAjax(lDisciplineService.updateLDiscipline(lDiscipline));
    }

    /**
     * 删除专业课
     */
    @RequiresPermissions("system:discipline:remove")
    @Log(title = "专业课", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(lDisciplineService.deleteLDisciplineByIds(ids));
    }
}
