package com.ruoyi.web.controller.learning;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.LTeacher;
import com.ruoyi.system.service.ILTeacherService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 老师Controller
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
@Controller
@RequestMapping("/system/teacher")
public class LTeacherController extends BaseController
{
    private String prefix = "learning/teacher";

    @Autowired
    private ILTeacherService lTeacherService;

    @RequiresPermissions("system:teacher:view")
    @GetMapping()
    public String teacher()
    {
        return prefix + "/teacher";
    }

    /**
     * 查询老师列表
     */
    @RequiresPermissions("system:teacher:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LTeacher lTeacher)
    {
        startPage();
        List<LTeacher> list = lTeacherService.selectLTeacherList(lTeacher);
        return getDataTable(list);
    }

    /**
     * 导出老师列表
     */
    @RequiresPermissions("system:teacher:export")
    @Log(title = "老师", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LTeacher lTeacher)
    {
        List<LTeacher> list = lTeacherService.selectLTeacherList(lTeacher);
        ExcelUtil<LTeacher> util = new ExcelUtil<LTeacher>(LTeacher.class);
        return util.exportExcel(list, "teacher");
    }

    /**
     * 新增老师
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存老师
     */
    @RequiresPermissions("system:teacher:add")
    @Log(title = "老师", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LTeacher lTeacher)
    {
        return toAjax(lTeacherService.insertLTeacher(lTeacher));
    }

    /**
     * 修改老师
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        LTeacher lTeacher = lTeacherService.selectLTeacherById(id);
        mmap.put("lTeacher", lTeacher);
        return prefix + "/edit";
    }

    /**
     * 修改保存老师
     */
    @RequiresPermissions("system:teacher:edit")
    @Log(title = "老师", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LTeacher lTeacher)
    {
        return toAjax(lTeacherService.updateLTeacher(lTeacher));
    }

    /**
     * 删除老师
     */
    @RequiresPermissions("system:teacher:remove")
    @Log(title = "老师", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(lTeacherService.deleteLTeacherByIds(ids));
    }
}
