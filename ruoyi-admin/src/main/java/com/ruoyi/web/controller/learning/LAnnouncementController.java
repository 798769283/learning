package com.ruoyi.web.controller.learning;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.LAnnouncement;
import com.ruoyi.system.service.ILAnnouncementService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 公告Controller
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
@Controller
@RequestMapping("/system/announcement")
public class LAnnouncementController extends BaseController
{
    private String prefix = "learning/announcement";

    @Autowired
    private ILAnnouncementService lAnnouncementService;

    @RequiresPermissions("system:announcement:view")
    @GetMapping()
    public String announcement()
    {
        return prefix + "/announcement";
    }

    /**
     * 查询公告列表
     */
    @RequiresPermissions("system:announcement:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LAnnouncement lAnnouncement)
    {
        startPage();
        List<LAnnouncement> list = lAnnouncementService.selectLAnnouncementList(lAnnouncement);
        return getDataTable(list);
    }

    /**
     * 导出公告列表
     */
    @RequiresPermissions("system:announcement:export")
    @Log(title = "公告", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LAnnouncement lAnnouncement)
    {
        List<LAnnouncement> list = lAnnouncementService.selectLAnnouncementList(lAnnouncement);
        ExcelUtil<LAnnouncement> util = new ExcelUtil<LAnnouncement>(LAnnouncement.class);
        return util.exportExcel(list, "announcement");
    }

    /**
     * 新增公告
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存公告
     */
    @RequiresPermissions("system:announcement:add")
    @Log(title = "公告", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LAnnouncement lAnnouncement)
    {
        return toAjax(lAnnouncementService.insertLAnnouncement(lAnnouncement));
    }

    /**
     * 修改公告
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        LAnnouncement lAnnouncement = lAnnouncementService.selectLAnnouncementById(id);
        mmap.put("lAnnouncement", lAnnouncement);
        return prefix + "/edit";
    }

    /**
     * 修改保存公告
     */
    @RequiresPermissions("system:announcement:edit")
    @Log(title = "公告", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LAnnouncement lAnnouncement)
    {
        return toAjax(lAnnouncementService.updateLAnnouncement(lAnnouncement));
    }

    /**
     * 删除公告
     */
    @RequiresPermissions("system:announcement:remove")
    @Log(title = "公告", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(lAnnouncementService.deleteLAnnouncementByIds(ids));
    }
}
