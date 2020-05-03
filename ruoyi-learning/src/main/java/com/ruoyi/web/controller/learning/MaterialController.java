package com.ruoyi.web.controller.learning;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.system.domain.LAnnouncement;
import com.ruoyi.system.domain.LMaterial;
import com.ruoyi.system.service.impl.LAnnouncementServiceImpl;
import com.ruoyi.system.service.impl.LMaterialServiceImpl;
import com.ruoyi.web.controller.dto.PageDTO;
import com.ruoyi.web.controller.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.web.controller.learning
 * @ClassName: 资料页面
 * @Author: 胡天霸
 * @Date: 2020/4/30 14:41
 * @Version: 1.0
 */
@RequestMapping("/learning")
@Controller
public class MaterialController extends BaseController {

    @Autowired
    private LAnnouncementServiceImpl announcementService;

    @Autowired
    private LMaterialServiceImpl materialService;

    @Autowired
    private WordService asposeWordService;

    private static final String prefix = "learning/theme/";

    /**
     *  资料--作业下载页面
     * @param model
     * @param materiaType 下载资料类型 0-资料，1-作业，2-视频
     * @return
     */
    @GetMapping("/download/{materiaType}")
    public String Getdownload(Model model, @PathVariable int materiaType){
        Map<String, Object> map = selectMaterials(materiaType, 1);
        model.addAttribute("materialsList", map.get("materials"));
        model.addAttribute("pageDTO", map.get("pageDTO"));
        String title="";
        if (0==materiaType)
        {
            title="资料列表";
        }else if (1==materiaType)
        {
            title="作业列表";
        }else if (2==materiaType)
        {
            title="视频列表";
        }
        model.addAttribute("title", title);
        return prefix+"download";
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
     * 查看资料
     * @param  id
     * @return
     *
     */
    @GetMapping("/materialLook/{id}")
    public String MaterialLook(Model model, @PathVariable("id") Long id) throws Exception {
        LMaterial lMaterial = materialService.selectLMaterialById(id);
        Integer status = lMaterial.getStatus();
        // 面包屑
        String [] breadCrumb = new String[3];
        if (status==0)
        {
            breadCrumb[0] = "资料列表";
            breadCrumb[1] = "资料查看";
        } else if (status==1)
        {
            breadCrumb[0] = "作业列表";
            breadCrumb[1] = "作业查看";
        } else if (status==2) //如果资料为视频，那么直接跳到视频页
        {
            breadCrumb[0] = "视频列表";
            breadCrumb[1] = "视频查看";
            model.addAttribute("breadCrumb", breadCrumb);
            model.addAttribute("material", lMaterial);
            return prefix+"video";
        }
        // 获取文件全路径
        String fileUrl     = lMaterial.getFileUrl();
        // 文件后缀名
        String substring   = fileUrl.substring(fileUrl.lastIndexOf("."));
        // 文件夹
        String dir         = fileUrl.substring(fileUrl.lastIndexOf("/")-11);
        // 文件绝对路径 --- 已经去掉了后缀
        String url        = Global.getUploadPath()+dir.substring(0,dir.lastIndexOf("."));
        // 判定是否是docx后缀
        if (substring.equals(".docx")){
            // 在判断文件之前是否被转换了
            File filePdf = new File(fileUrl+".pdf");
            if (filePdf.exists()){
                lMaterial.setFileUrl(fileUrl.substring(0,fileUrl.lastIndexOf("."))+".pdf");
                model.addAttribute("breadCrumb", breadCrumb);
                model.addAttribute("material", lMaterial);
                return prefix+"lookOver";
            }
            // 上传文件路径
            String filePath = Global.getUploadPath();
            File file = ResourceUtils.getFile(filePath+dir);
            File outFile = new File(url+".pdf");
            asposeWordService.word2pdf(file.getAbsolutePath(),outFile.getAbsolutePath());
            lMaterial.setFileUrl(fileUrl.substring(0,fileUrl.lastIndexOf("."))+".pdf");
            model.addAttribute("breadCrumb", breadCrumb);
            model.addAttribute("material", lMaterial);
            return prefix+"lookOver";
        }
        breadCrumb[2]="目前只支持PDF+WORD文档在线预览";
        model.addAttribute("breadCrumb", breadCrumb);
        model.addAttribute("material", lMaterial);
        return prefix+"lookOver";
    }

    /**
     *  异步加载资料
     * @param currentSize 当前页
     * @param currentSize 当前页
     * @param url 返回的路径
     * @return
     */
    @PostMapping("/download/asynGetMaterial")
    public String asynGetMaterial(Model model, int currentSize, int type, String url){
        Map<String, Object> map = selectMaterials(type,currentSize);
        model.addAttribute("materialsList", map.get("materials"));
        model.addAttribute("pageDTO", map.get("pageDTO"));
        return prefix+url;
    }


    /**
     * 查看视频类资料
     * @param id
     * @return
     */
    @GetMapping("/videoLook/{id}")
    public String videoLook(@PathVariable("id") String id){
        return prefix+"video";
    }

    /**
     * 查看公告
     * @param id
     * @return
     */
    @GetMapping("/article/{id}")
    public String article(Model model, @PathVariable Long id){
        PageHelper.startPage(1, 5, "create_time desc");
        LAnnouncement lAnnouncement = announcementService.selectLAnnouncementById(id);
        model.addAttribute("announcement",lAnnouncement);
        return prefix+"article";
    }

}
