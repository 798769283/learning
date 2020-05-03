package com.ruoyi.web.controller.learning;

import com.ruoyi.common.core.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.web.controller.learning
 * @ClassName: 师生互动
 * @Author: 胡天霸
 * @Date: 2020/4/30 14:54
 * @Version: 1.0
 */
@Controller
@RequestMapping("/learning")
public class InteractiveController extends BaseController {

    private static final String prefix = "learning/theme/";

    /**
     *  私信页
     * @param model
     * @return
     */
    @GetMapping("/interactive")
    public String getInteractive(Model model){
        return prefix+"interactive";
    }

    /**
     * 私信详情页
     * @param id
     * @return
     */
    @GetMapping("/interactiveDetail/{id}")
    public String getInteractiveDetail(@PathVariable("id") String id){
        return prefix+"interactiveDetail";
    }
}
