package com.ruoyi.web.controller.learning;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.LStudent;
import com.ruoyi.system.service.ILStudentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 学生Controller
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
@Controller
@RequestMapping("/system/student")
public class LStudentController extends BaseController
{
    private String prefix = "learning/student";

    @Autowired
    private ILStudentService lStudentService;

    @RequiresPermissions("system:student:view")
    @GetMapping()
    public String student()
    {
        return prefix + "/student";
    }

    /**
     * 查询学生列表
     */
    @RequiresPermissions("system:student:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LStudent lStudent)
    {
        startPage();
        List<LStudent> list = lStudentService.selectLStudentList(lStudent);
        return getDataTable(list);
    }

    /**
     * 导出学生列表
     */
    @RequiresPermissions("system:student:export")
    @Log(title = "学生", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LStudent lStudent)
    {
        List<LStudent> list = lStudentService.selectLStudentList(lStudent);
        ExcelUtil<LStudent> util = new ExcelUtil<LStudent>(LStudent.class);
        return util.exportExcel(list, "student");
    }

    /**
     * 新增学生
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存学生
     */
    @RequiresPermissions("system:student:add")
    @Log(title = "学生", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LStudent lStudent)
    {
        return toAjax(lStudentService.insertLStudent(lStudent));
    }

    /**
     * 修改学生
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        LStudent lStudent = lStudentService.selectLStudentById(id);
        mmap.put("lStudent", lStudent);
        return prefix + "/edit";
    }

    /**
     * 修改保存学生
     */
    @RequiresPermissions("system:student:edit")
    @Log(title = "学生", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LStudent lStudent)
    {
        return toAjax(lStudentService.updateLStudent(lStudent));
    }

    /**
     * 删除学生
     */
    @RequiresPermissions("system:student:remove")
    @Log(title = "学生", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(lStudentService.deleteLStudentByIds(ids));
    }
}
