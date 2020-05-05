package com.ruoyi.web.controller.learning;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.exception.user.UserNotExistsException;
import com.ruoyi.system.domain.LMessage;
import com.ruoyi.system.domain.LStudentAccount;
import com.ruoyi.system.domain.LTeacherAccount;
import com.ruoyi.system.service.ILMessageService;
import com.ruoyi.system.service.ILStudentAccountService;
import com.ruoyi.system.service.ILTeacherAccountService;
import com.ruoyi.web.controller.dto.MessageDTO;
import com.ruoyi.web.controller.dto.PageDTO;
import com.ruoyi.web.controller.dto.UserDTO;
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
 * @ClassName: 师生互动
 * @Author: 胡天霸
 * @Date: 2020/4/30 14:54
 * @Version: 1.0
 */
@Controller
@RequestMapping("/learning")
public class InteractiveController extends BaseController {

    private static final String prefix = "learning/theme/";

    @Autowired
    private ILMessageService messageService;

    @Autowired
    private ILStudentAccountService studentAccountService;

    @Autowired
    private ILTeacherAccountService teacherAccountService;

    /**
     *  私信页
     * @param model
     * @return
     */
    @GetMapping("/interactive/{countSize}")
    public String getInteractive(Model model, @PathVariable(name = "countSize") int countSize) {
        // 先从session中取出用户
        UserDTO userDTO = (UserDTO) getRequest().getSession().getAttribute("user");
        //判断是否为空
        if (userDTO == null) {
            throw new UserNotExistsException();
        }
        // 分页--- 按会话ID(当前用户ID)匹配，再按时间倒叙排序
        PageHelper.startPage(countSize, 6, "create_time desc");
        List<LMessage> messagesList = messageService.selectMessageList(userDTO.getId());
        // 获取分页参数
        PageInfo<LMessage> info = new PageInfo<>(messagesList);
        // 2. 分装分页对象返回前端
        PageDTO pageDTO = new PageDTO();
        pageDTO.setCurrentSize(info.getPageNum());
        pageDTO.setPages(info.getPages());
        // 得到消息列表
        Map<String, Object> messageList = getMessageList(messagesList, userDTO);
        // 返回数据模型
        model.addAttribute("messagesList", messageList.get("messagesList"));
        model.addAttribute("totalUnreadMessage", messageList.get("totalUnreadMessage"));
        model.addAttribute("pageDTO", pageDTO);
        return prefix + "interactive";

    }


    /**
     * 返回消息模型。因为老师和学生有重复。所以抽取出来
     * @param messagesList
     * @param userDTO
     * @return
     */
    private Map<String, Object> getMessageList(List<LMessage> messagesList, UserDTO userDTO){
        Map<String, Object> map = new HashMap<>();
        // 创建消息DTO集合
        List<MessageDTO> messageDTOList = new ArrayList<>();
        // 创建总未读消息变量
        int totalUnreadMessage= messageService.totalUnreadMessage(userDTO.getId());
        // 遍历发送人信息
        for (LMessage message : messagesList) {
            // 创建UserDTO
            UserDTO userDTO1 = new UserDTO();
            // 根据消息用户ID查询指定用户
            String userId =message.getFromId().equals(userDTO.getId())? message.getToId() : message.getFromId();
            // 判断用户ID，获取用户信息
            if ("学生".equals(userDTO.getUserType())){
                LTeacherAccount lTeacherAccount = teacherAccountService.selectLTeacherAccountByTeacherId(userId);
                userDTO1.setUsername(lTeacherAccount.getUsername());
            }else if ("老师".equals(userDTO.getUserType())){
                LStudentAccount lStudentAccount = studentAccountService.selectLStudentAccountByStudentId(userId);
                userDTO1.setUsername(lStudentAccount.getName());
            }
            // 根据查询到的消息会话id和当前用户ID 查询未读消息 --- 要排除是否是当前用户发送的
            int sumUnreadMessage = 0;
            if (!message.getFromId().equals(userDTO.getId())){
                Integer integer = messageService.sumUnreadMessage(userDTO.getId(), message.getConversationId());
                if (integer!=null){
                    sumUnreadMessage = integer;
                }
            }
            // 查询所有消息总和，按当前会话ID；
            int totalMessage = 0;
            Integer integer = messageService.totalMessage(message.getConversationId());
            if (integer!=null){
                totalMessage =  integer;
            }
            // 创建消息DTO
            MessageDTO messageDTO = new MessageDTO();
            // 存入最新消息以及用户信息
            messageDTO.setConversationId(message.getConversationId());
            messageDTO.setTotalMessage(totalMessage);
            messageDTO.setlMessage(message);
            messageDTO.setUserDTO(userDTO1);
            messageDTO.setUnreadSum(sumUnreadMessage);
            messageDTOList.add(messageDTO);
        }
        map.put("messagesList", messageDTOList);
        map.put("totalUnreadMessage", totalUnreadMessage);
        return map;
    }


    /**
     * 私信详情页
     * @param conversationId 会话ID
     * @return
     */
    @GetMapping(value = {"/interactiveDetail/{conversationId}/{countSize}","/interactiveDetail/{conversationId}"})
    public String getInteractiveDetail(Model model, @PathVariable("conversationId") String conversationId, @PathVariable(required=false) Integer countSize) {
        if (countSize==null){
            countSize=1;
        }
        PageHelper.startPage(countSize,6,"create_time desc");
        List<LMessage> lMessages = messageService.selectMessageByConversationIdList(conversationId);
        // 先从session中取出用户
        UserDTO userDTO = (UserDTO) getRequest().getSession().getAttribute("user");
        // 根据消息用户ID查询指定用户
        String userId =lMessages.get(0).getFromId().equals(userDTO.getId())? lMessages.get(0).getToId() : lMessages.get(0).getFromId();
        // 创建用户名变量
        String username ="";
        if ("学生".equals(userDTO.getUserType())){
            LTeacherAccount lTeacherAccount = teacherAccountService.selectLTeacherAccountByTeacherId(userId);
            username = lTeacherAccount.getUsername();
        }else if ("老师".equals(userDTO.getUserType())){
            LStudentAccount lStudentAccount = studentAccountService.selectLStudentAccountByStudentId(userId);
            username = lStudentAccount.getName();
        }
        // 获取分页参数
        PageInfo<LMessage> info = new PageInfo<>(lMessages);
        // 封装分页对象返回前端
        PageDTO pageDTO = new PageDTO();
        pageDTO.setCurrentSize(info.getPageNum());
        pageDTO.setPages(info.getPages());
        // 改变未读消息---已读
        messageService.updateMeesageStatus(userDTO.getId(), "1", lMessages.get(0).getConversationId());
        model.addAttribute("username", username);
        model.addAttribute("userId", userId);
        model.addAttribute("conversationId", conversationId);
        model.addAttribute("messageList", lMessages);
        model.addAttribute("pageDTO", pageDTO);
        return prefix+"interactive-detail";
    }

    /**
     * 获取全部用户信息 用于发送信息时候选择用户
     * @param model
     * @return
     */
    @GetMapping("/getUserNames")
    public String getUserNames(Model model){
        UserDTO user = (UserDTO) getRequest().getSession().getAttribute("user");
        List<UserDTO> userDTOList = new ArrayList<>();
        if ("学生".equals(user.getUserType())){
            List<LTeacherAccount> lTeacherAccounts = teacherAccountService.selectLTeacherAccountList(new LTeacherAccount());
            for (LTeacherAccount lTeacherAccount:lTeacherAccounts){
                UserDTO userDTO = new UserDTO();
                userDTO.setUsername(lTeacherAccount.getUsername());
                userDTO.setId(lTeacherAccount.getTeacherId());
                userDTOList.add(userDTO);
            }
        }else if ("老师".equals(user.getUserType())){
            List<LStudentAccount> lStudentAccounts = studentAccountService.selectLStudentAccountList(new LStudentAccount());
            for (LStudentAccount lStudentAccount : lStudentAccounts){
                UserDTO userDTO = new UserDTO();
                userDTO.setUsername(lStudentAccount.getName());
                userDTO.setId(lStudentAccount.getStudentId());
                userDTOList.add(userDTO);
            }
        }
        model.addAttribute("userList", userDTOList);
        return prefix+"interactive::interactive";
    }

    /**
     * 发送信息
     * @param userid
     * @param content
     * @return
     */
    @PostMapping("/sendMessage")
    @ResponseBody
    public AjaxResult sendMessage(String userid, String content){
        UserDTO user = (UserDTO) getRequest().getSession().getAttribute("user");
        // 创建消息对象
        LMessage lMessage = new LMessage();
        lMessage.setFromId(user.getId());
        lMessage.setToId(userid);
        lMessage.setContent(content);
        String conversationId = user.getUserType().equals("学生") ? userid+"_"+user.getId() : user.getId()+"_"+userid;
        lMessage.setConversationId(conversationId);
        lMessage.setStatus((long) 0);
        int i = messageService.insertLMessage(lMessage);
        if (i>0){
            // 改变消息状态
            messageService.updateMeesageStatus(user.getId(), "1", conversationId);
            return  success("发送成功");
        }
        return  error("发送失败");
    }
}
