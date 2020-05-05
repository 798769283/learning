package com.ruoyi.web.controller.learning;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.LAnnouncement;
import com.ruoyi.system.domain.LMaterial;
import com.ruoyi.system.domain.LTeacher;
import com.ruoyi.system.service.ILAnnouncementService;
import com.ruoyi.system.service.ILMaterialService;
import com.ruoyi.system.service.ILTeacherService;
import com.ruoyi.web.controller.dto.PageDTO;
import com.ruoyi.web.controller.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private ILTeacherService teacherService;

    private static final String prefix = "learning/theme/";

    /**
     * 首页
     *
     * @param model
     * @return
     */
    @GetMapping({"/",""})
    public String getIndex(Model model){
        UserDTO user = (UserDTO) getRequest().getSession().getAttribute("user");
        // 根据用户加载菜单
        String main = "learning/main";
        if (user != null){
            if ("老师".equals(user.getUserType())){
                main = "learning/main2/1";
            }
        }
        // 1. 加载最新文章
        PageHelper.startPage(1, 5, "create_time desc");
        List<LAnnouncement> lAnnouncements = announcementService.selectLAnnouncementList(new LAnnouncement());
        model.addAttribute("announcementList",lAnnouncements);
        model.addAttribute("main", main);
        return prefix+"index";
    }

    /**
     * 学生菜单页
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

    @GetMapping("/main2/{countSize}")
    public String getMain2(Model model,  @PathVariable int countSize){
        PageHelper.startPage(countSize, 5, "create_time desc");
        // 资料类型数组
        String [] statusList ={"资料","作业","视频"};
        // 取出当前用户
        UserDTO user = (UserDTO) getRequest().getSession().getAttribute("user");
        LMaterial lMaterial = new LMaterial();
        // 按老师id查找上传的资料。
        lMaterial.setCreateBy(user.getId());
        List<LMaterial> lMaterials = materialService.selectLMaterialList(lMaterial);

        // 分装分页对象返回前端
        PageInfo<LMaterial> info = new PageInfo<>(lMaterials);
        PageDTO pageDTO = new PageDTO();
        pageDTO.setCurrentSize(info.getPageNum());
        pageDTO.setPages(info.getPages());

        // 存入数据模型
        model.addAttribute("materials", lMaterials);
        model.addAttribute("pageDTO", pageDTO);
        model.addAttribute("statusList", statusList);
        return prefix+"main2";
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

    /**
     * 上传资料
     * @param lMaterial
     * @return
     */
    @PostMapping("/uploadMaterial")
    @ResponseBody
    public AjaxResult uploadMaterial(LMaterial lMaterial){
        UserDTO user = (UserDTO) getRequest().getSession().getAttribute("user");
        LTeacher lTeacher = teacherService.selectLTeacherByTearcherId(user.getId());
        lMaterial.setdId(lTeacher.getdId());
        lMaterial.setCreateBy(user.getId());
        System.out.println(lMaterial.toString());
        int i = materialService.insertLMaterial(lMaterial);
        if (i>0){
            return success("上传成功");
        }
        return error("上传失败");
    }

}
