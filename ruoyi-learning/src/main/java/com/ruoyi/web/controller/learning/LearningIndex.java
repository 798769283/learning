package com.ruoyi.web.controller.learning;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.system.domain.LAnnouncement;
import com.ruoyi.system.domain.LMaterial;
import com.ruoyi.system.service.ILAnnouncementService;
import com.ruoyi.system.service.ILMaterialService;
import com.ruoyi.web.controller.dto.PageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.web.controller.learning
 * @ClassName: 首页
 * @Author: 胡天霸
 * @Date: 2020/4/30 12:25
 * @Version: 1.0
 */
@Controller
@RequestMapping("/learning")
public class LearningIndex extends BaseController {

    @Autowired
    private ILMaterialService materialService;

    @Autowired
    private ILAnnouncementService announcementService;

    private static final String prefix = "learning/theme/";

    /**
     * 首页
     *
     * @param model
     * @return
     */
    @GetMapping({"/",""})
    public String getIndex(Model model){
        // 1. 加载最新文章
        PageHelper.startPage(1, 5, "create_time desc");
        List<LAnnouncement> lAnnouncements = announcementService.selectLAnnouncementList(new LAnnouncement());
        model.addAttribute("announcementList",lAnnouncements);
        return prefix+"index";
    }

    /**
     * 菜单页
     * @param model
     *
     * @return
     */
    @GetMapping("/main")
    public String getMain(Model model){
        /*// 1. 分页
        PageHelper.startPage(1, 5);
        LMaterial lMaterial = new LMaterial();
        // 2. 设置查询类型 1-作业
        lMaterial.setStatus(1);
        List<LMaterial> lMaterials = materialService.selectLMaterialList(lMaterial);
        PageInfo<LMaterial> info = new PageInfo<>(lMaterials);
        // 2. 分装分页对象返回前端
        PageDTO pageDTO = new PageDTO();
        pageDTO.setCurrentSize(info.getPageNum());
        pageDTO.setPages(info.getPages());
        model.addAttribute("materialsWork", lMaterials);
        model.addAttribute("pageDTOWork", pageDTO);*/

        // 1. 最新作业
        Map<String, Object> map = selectMaterials(1,1);
        model.addAttribute("materialsWork", map.get("materials"));
        model.addAttribute("pageDTOWork", map.get("pageDTO"));

        //2. 最新资料
        Map<String, Object> map1 = selectMaterials(0, 1);
        model.addAttribute("materialsList",map1.get("materials"));
        model.addAttribute("pageDTOMaterial",map1.get("pageDTO"));
        return prefix+"main";
    }

    /**
     * 抽取首页菜单公共资料分页代码
     * @param status 根据类型查找  0-资料，1-作业，2-视频
     * @param currentSize 当前页
     * @return
     */
    private Map<String, Object> selectMaterials(int status, int currentSize){
        Map<String, Object> map = new HashMap<>();
        // 1. 分页 按时间降序
        PageHelper.startPage(currentSize, 5, "create_time desc");
        LMaterial lMaterial = new LMaterial();
        // 2. 设置查询类型 0-资料，1-作业，2-视频
        lMaterial.setStatus(status);
        List<LMaterial> lMaterials = materialService.selectLMaterialList(lMaterial);
        PageInfo<LMaterial> info = new PageInfo<>(lMaterials);
        // 2. 分装分页对象返回前端
        PageDTO pageDTO = new PageDTO();
        pageDTO.setCurrentSize(info.getPageNum());
        pageDTO.setPages(info.getPages());
        map.put("materials", lMaterials);
        map.put("pageDTO", pageDTO);
        return map;
    }

    /**
     *  异步加载最新资料
     * @param currentSize 当前页
     * @param currentSize 当前页
     * @param url 返回的路径
     * @return
     */
    @PostMapping("/asynGetMaterial")
    public String asynGetMaterial(Model model, int currentSize, int type, String url){
        Map<String, Object> map = selectMaterials(type,currentSize);
        // 返回的对象名称
        String material="";
        String pageDTO="";
        if (0==type)
        {
            material = "materialsList";
            pageDTO  = "pageDTOMaterial";
        }else if (1==type)
        {
            material = "materialsWork";
            pageDTO  = "pageDTOWork";
        }
        model.addAttribute(material, map.get("materials"));
        model.addAttribute(pageDTO, map.get("pageDTO"));
        return prefix+url;
    }

    /**
     * 注册页面
     * @return
     */
    @GetMapping("/register")
    public String register(){
        return prefix+"register";
    }


}
