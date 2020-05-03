package com.ruoyi.web.controller.learning;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.LStudentAccount;
import com.ruoyi.system.service.ILStudentAccountService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 学生账户Controller
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
@Controller
@RequestMapping("/system/student/account")
public class LStudentAccountController extends BaseController
{
    private String prefix = "learning/student_account";

    @Autowired
    private ILStudentAccountService lStudentAccountService;

    @RequiresPermissions("system:student:account:view")
    @GetMapping()
    public String account()
    {
        return prefix + "/account";
    }

    /**
     * 查询学生账户列表
     */
    @RequiresPermissions("system:student:account:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LStudentAccount lStudentAccount)
    {
        startPage();
        List<LStudentAccount> list = lStudentAccountService.selectLStudentAccountList(lStudentAccount);
        return getDataTable(list);
    }

    /**
     * 导出学生账户列表
     */
    @RequiresPermissions("system:student:account:export")
    @Log(title = "学生账户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LStudentAccount lStudentAccount)
    {
        List<LStudentAccount> list = lStudentAccountService.selectLStudentAccountList(lStudentAccount);
        ExcelUtil<LStudentAccount> util = new ExcelUtil<LStudentAccount>(LStudentAccount.class);
        return util.exportExcel(list, "account");
    }

    /**
     * 新增学生账户
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存学生账户
     */
    @RequiresPermissions("system:student:account:add")
    @Log(title = "学生账户", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LStudentAccount lStudentAccount)
    {
        return toAjax(lStudentAccountService.insertLStudentAccount(lStudentAccount));
    }

    /**
     * 修改学生账户
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        LStudentAccount lStudentAccount = lStudentAccountService.selectLStudentAccountById(id);
        mmap.put("lStudentAccount", lStudentAccount);
        return prefix + "/edit";
    }

    /**
     * 修改保存学生账户
     */
    @RequiresPermissions("system:student:account:edit")
    @Log(title = "学生账户", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LStudentAccount lStudentAccount)
    {
        return toAjax(lStudentAccountService.updateLStudentAccount(lStudentAccount));
    }

    /**
     * 删除学生账户
     */
    @RequiresPermissions("system:student:account:remove")
    @Log(title = "学生账户", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(lStudentAccountService.deleteLStudentAccountByIds(ids));
    }
}
