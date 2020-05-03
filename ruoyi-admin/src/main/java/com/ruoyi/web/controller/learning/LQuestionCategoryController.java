package com.ruoyi.web.controller.learning;

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
import com.ruoyi.system.domain.LQuestionCategory;
import com.ruoyi.system.service.ILQuestionCategoryService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 考题类别（按班级划分）Controller
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
@Controller
@RequestMapping("/system/category")
public class LQuestionCategoryController extends BaseController
{
    private String prefix = "learning/category";

    @Autowired
    private ILQuestionCategoryService lQuestionCategoryService;

    @RequiresPermissions("system:category:view")
    @GetMapping()
    public String category()
    {
        return prefix + "/category";
    }

    /**
     * 查询考题类别（按班级划分）列表
     */
    @RequiresPermissions("system:category:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LQuestionCategory lQuestionCategory)
    {
        startPage();
        List<LQuestionCategory> list = lQuestionCategoryService.selectLQuestionCategoryList(lQuestionCategory);
        return getDataTable(list);
    }

    /**
     * 导出考题类别（按班级划分）列表
     */
    @RequiresPermissions("system:category:export")
    @Log(title = "考题类别（按班级划分）", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LQuestionCategory lQuestionCategory)
    {
        List<LQuestionCategory> list = lQuestionCategoryService.selectLQuestionCategoryList(lQuestionCategory);
        ExcelUtil<LQuestionCategory> util = new ExcelUtil<LQuestionCategory>(LQuestionCategory.class);
        return util.exportExcel(list, "category");
    }

    /**
     * 新增考题类别（按班级划分）
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存考题类别（按班级划分）
     */
    @RequiresPermissions("system:category:add")
    @Log(title = "考题类别（按班级划分）", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LQuestionCategory lQuestionCategory)
    {
        return toAjax(lQuestionCategoryService.insertLQuestionCategory(lQuestionCategory));
    }

    /**
     * 修改考题类别（按班级划分）
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        LQuestionCategory lQuestionCategory = lQuestionCategoryService.selectLQuestionCategoryById(id);
        mmap.put("lQuestionCategory", lQuestionCategory);
        return prefix + "/edit";
    }

    /**
     * 修改保存考题类别（按班级划分）
     */
    @RequiresPermissions("system:category:edit")
    @Log(title = "考题类别（按班级划分）", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LQuestionCategory lQuestionCategory)
    {
        return toAjax(lQuestionCategoryService.updateLQuestionCategory(lQuestionCategory));
    }

    /**
     * 删除考题类别（按班级划分）
     */
    @RequiresPermissions("system:category:remove")
    @Log(title = "考题类别（按班级划分）", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(lQuestionCategoryService.deleteLQuestionCategoryByIds(ids));
    }
}
