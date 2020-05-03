package com.ruoyi.web.controller.learning;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.LQuestions;
import com.ruoyi.system.service.ILQuestionsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 考题Controller
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
@Controller
@RequestMapping("/system/questions")
public class LQuestionsController extends BaseController
{
    private String prefix = "learning/questions";

    @Autowired
    private ILQuestionsService lQuestionsService;

    @RequiresPermissions("system:questions:view")
    @GetMapping()
    public String questions()
    {
        return prefix + "/questions";
    }

    /**
     * 查询考题列表
     */
    @RequiresPermissions("system:questions:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LQuestions lQuestions)
    {
        startPage();
        List<LQuestions> list = lQuestionsService.selectLQuestionsList(lQuestions);
        return getDataTable(list);
    }

    /**
     * 导出考题列表
     */
    @RequiresPermissions("system:questions:export")
    @Log(title = "考题", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LQuestions lQuestions)
    {
        List<LQuestions> list = lQuestionsService.selectLQuestionsList(lQuestions);
        ExcelUtil<LQuestions> util = new ExcelUtil<LQuestions>(LQuestions.class);
        return util.exportExcel(list, "questions");
    }

    /**
     * 新增考题
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存考题
     */
    @RequiresPermissions("system:questions:add")
    @Log(title = "考题", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LQuestions lQuestions)
    {
        return toAjax(lQuestionsService.insertLQuestions(lQuestions));
    }

    /**
     * 修改考题
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        LQuestions lQuestions = lQuestionsService.selectLQuestionsById(id);
        mmap.put("lQuestions", lQuestions);
        return prefix + "/edit";
    }

    /**
     * 修改保存考题
     */
    @RequiresPermissions("system:questions:edit")
    @Log(title = "考题", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LQuestions lQuestions)
    {
        return toAjax(lQuestionsService.updateLQuestions(lQuestions));
    }

    /**
     * 删除考题
     */
    @RequiresPermissions("system:questions:remove")
    @Log(title = "考题", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(lQuestionsService.deleteLQuestionsByIds(ids));
    }
}
