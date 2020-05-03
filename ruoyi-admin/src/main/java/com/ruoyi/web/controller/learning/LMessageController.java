package com.ruoyi.web.controller.learning;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.LMessage;
import com.ruoyi.system.service.ILMessageService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 会话Controller
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
@Controller
@RequestMapping("/system/message")
public class LMessageController extends BaseController
{
    private String prefix = "learning/message";

    @Autowired
    private ILMessageService lMessageService;

    @RequiresPermissions("system:message:view")
    @GetMapping()
    public String message()
    {
        return prefix + "/message";
    }

    /**
     * 查询会话列表
     */
    @RequiresPermissions("system:message:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LMessage lMessage)
    {
        startPage();
        List<LMessage> list = lMessageService.selectLMessageList(lMessage);
        return getDataTable(list);
    }

    /**
     * 导出会话列表
     */
    @RequiresPermissions("system:message:export")
    @Log(title = "会话", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LMessage lMessage)
    {
        List<LMessage> list = lMessageService.selectLMessageList(lMessage);
        ExcelUtil<LMessage> util = new ExcelUtil<LMessage>(LMessage.class);
        return util.exportExcel(list, "message");
    }

    /**
     * 新增会话
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存会话
     */
    @RequiresPermissions("system:message:add")
    @Log(title = "会话", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LMessage lMessage)
    {
        return toAjax(lMessageService.insertLMessage(lMessage));
    }

    /**
     * 修改会话
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        LMessage lMessage = lMessageService.selectLMessageById(id);
        mmap.put("lMessage", lMessage);
        return prefix + "/edit";
    }

    /**
     * 修改保存会话
     */
    @RequiresPermissions("system:message:edit")
    @Log(title = "会话", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LMessage lMessage)
    {
        return toAjax(lMessageService.updateLMessage(lMessage));
    }

    /**
     * 删除会话
     */
    @RequiresPermissions("system:message:remove")
    @Log(title = "会话", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(lMessageService.deleteLMessageByIds(ids));
    }
}
