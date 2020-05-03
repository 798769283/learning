package com.ruoyi.web.controller.learning;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.system.domain.LQuestionCategory;
import com.ruoyi.system.service.impl.LQuestionCategoryServiceImpl;
import com.ruoyi.system.service.impl.LQuestionsServiceImpl;
import com.ruoyi.web.controller.dto.PageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.web.controller.learning
 * @ClassName: 在线自测
 * @Author: 胡天霸
 * @Date: 2020/4/30 14:51
 * @Version: 1.0
 */
@RequestMapping("learning")
@Controller
public class OnlineTestController extends BaseController {
    private static final String prefix = "learning/theme/";

    @Autowired
    private LQuestionsServiceImpl questionsService;

    @Autowired
    private LQuestionCategoryServiceImpl questionCategoryService;

    /**
     * 获取考题列表
     * @return
     */
    @GetMapping("/lookQuestions")
    public String getLookQuestions(Model model){
        Map<String, Object> map = selectMaterials(1);
        model.addAttribute("questionCategories", map.get("questionCategories"));
        model.addAttribute("pageDTO", map.get("pageDTO"));
        return prefix+"lookQuestions";
    }

    /**
     *  异步加载考题列表
     * @param currentSize 当前页
     *
     * @param url 返回的路径
     * @return
     */
    @PostMapping("/lookQuestions/asynGetQuestions")
    public String asynGetQuestions(Model model, int currentSize, String url){
        Map<String, Object> map = selectMaterials(currentSize);
        model.addAttribute("materialsList", map.get("materials"));
        model.addAttribute("pageDTO", map.get("pageDTO"));
        return prefix+url;
    }

    /**
     * 抽取首页菜单公共资料分页代码
     *
     * @param currentSize 当前页
     * @return
     */
    private Map<String, Object> selectMaterials(int currentSize){
        Map<String, Object> map = new HashMap<>();
        // 1. 分页 按时间降序
        PageHelper.startPage(currentSize, 5);
        List<LQuestionCategory> lQuestionCategories = questionCategoryService.selectLQuestionCategoryList(new LQuestionCategory());
        // 2. 设置查询类型 0-资料，1-作业，2-视频
        PageInfo<LQuestionCategory> info = new PageInfo<>(lQuestionCategories);
        // 2. 分装分页对象返回前端
        PageDTO pageDTO = new PageDTO();
        pageDTO.setCurrentSize(info.getPageNum());
        pageDTO.setPages(info.getPages());
        map.put("questionCategories", lQuestionCategories);
        map.put("pageDTO", pageDTO);
        return map;
    }

    /**
     * 在线自测页
     * @return
     */
    @GetMapping("/onlineTest/{id}")
    public String getOnlineTest(Model model, @PathVariable String id){
        return prefix+"onlineTest";
    }

    /**
     *  页面加载完获取考题
     * @return
     */
    @GetMapping("/getQuestions")
    @ResponseBody
    public List getQuestions(){
        List<Object> list = new ArrayList();
        return list;
    }
}
