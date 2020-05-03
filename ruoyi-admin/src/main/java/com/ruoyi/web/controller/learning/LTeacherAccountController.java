package com.ruoyi.web.controller.learning;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.LTeacherAccount;
import com.ruoyi.system.service.ILTeacherAccountService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 老师账户Controller
 *
 * @author HuTianba
 * @date 2020-04-28
 */
@Controller
@RequestMapping("/system/teacher/account")
public class LTeacherAccountController extends BaseController
{
    private String prefix = "learning/teacher_account";

    @Autowired
    private ILTeacherAccountService lTeacherAccountService;

    @RequiresPermissions("system:teacher:account:view")
    @GetMapping()
    public String account()
    {
        return prefix + "/account";
    }

    /**
     * 查询老师账户列表
     */
    @RequiresPermissions("system:teacher:account:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LTeacherAccount lTeacherAccount)
    {
        startPage();
        List<LTeacherAccount> list = lTeacherAccountService.selectLTeacherAccountList(lTeacherAccount);
        return getDataTable(list);
    }

    /**
     * 导出老师账户列表
     */
    @RequiresPermissions("system:teacher:account:export")
    @Log(title = "老师账户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LTeacherAccount lTeacherAccount)
    {
        List<LTeacherAccount> list = lTeacherAccountService.selectLTeacherAccountList(lTeacherAccount);
        ExcelUtil<LTeacherAccount> util = new ExcelUtil<LTeacherAccount>(LTeacherAccount.class);
        return util.exportExcel(list, "account");
    }

    /**
     * 新增老师账户
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存老师账户
     */
    @RequiresPermissions("system:teacher:account:add")
    @Log(title = "老师账户", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LTeacherAccount lTeacherAccount)
    {
        return toAjax(lTeacherAccountService.insertLTeacherAccount(lTeacherAccount));
    }

    /**
     * 修改老师账户
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        LTeacherAccount lTeacherAccount = lTeacherAccountService.selectLTeacherAccountById(id);
        mmap.put("lTeacherAccount", lTeacherAccount);
        return prefix + "/edit";
    }

    /**
     * 修改保存老师账户
     */
    @RequiresPermissions("system:teacher:account:edit")
    @Log(title = "老师账户", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LTeacherAccount lTeacherAccount)
    {
        return toAjax(lTeacherAccountService.updateLTeacherAccount(lTeacherAccount));
    }

    /**
     * 删除老师账户
     */
    @RequiresPermissions("system:teacher:account:remove")
    @Log(title = "老师账户", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(lTeacherAccountService.deleteLTeacherAccountByIds(ids));
    }
}
