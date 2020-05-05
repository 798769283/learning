package com.ruoyi.web.controller.learning;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.LStudent;
import com.ruoyi.system.domain.LStudentAccount;
import com.ruoyi.system.domain.LTeacher;
import com.ruoyi.system.domain.LTeacherAccount;
import com.ruoyi.system.service.ILStudentAccountService;
import com.ruoyi.system.service.ILStudentService;
import com.ruoyi.system.service.ILTeacherAccountService;
import com.ruoyi.system.service.ILTeacherService;
import com.ruoyi.web.controller.dto.RegisterDTO;
import com.ruoyi.web.controller.dto.UserDTO;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.web.controller.learning
 * @ClassName: 用户
 * @Author: 胡天霸
 * @Date: 2020/4/30 19:53
 * @Version: 1.0
 */
@Controller
@RequestMapping("/learning")
public class UserController  extends BaseController {

    @Autowired
    private ILStudentAccountService studentAccountService;

    @Autowired
    private ILTeacherAccountService teacherAccountService;

    @Autowired
    private ILStudentService studentService;

    @Autowired
    private ILTeacherService teacherService;

    /**
     * 登陆方法
     * 根据userType判断登陆的用户类型 0-老师，1-学生
     * @param username
     * @param password
     * @param userType
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public AjaxResult Login( String username, String password, String userType){

        //1. 判断账户或密码是否为空
        if (StringUtils.isEmpty(username)||StringUtils.isEmpty(password)){
            return error("用户名或者密码为空");
        }
        //2. 判断登陆类型 0-为老师，1-为学生
        if ("0".equals(userType))
        {
            LTeacherAccount teacherAccount = new LTeacherAccount();
            teacherAccount.setUsername(username);
            teacherAccount.setPassword(DigestUtils.md5Hex(password));
            LTeacherAccount lTeacherAccount = teacherAccountService
                    .selectLTeacherAccountList(teacherAccount).get(0);

            // 如果为null就是没有查到
            if (lTeacherAccount==null)
            {
                return error("账户或密码错误！");
            }
            // 存入用户
            SessionSetUser(lTeacherAccount.getUsername(),"老师",lTeacherAccount.getTeacherId());
        }else if("1".equals(userType))
        {
            LStudentAccount studentAccount = new LStudentAccount();
            studentAccount.setName(username);
            studentAccount.setPassword(DigestUtils.md5Hex(password));
            List<LStudentAccount> lStudentAccounts = studentAccountService
                    .selectLStudentAccountList(studentAccount);

            // 如果为null就是没有查到
            if (lStudentAccounts.size()==0)
            {
                return error("账户或密码错误！");
            }
            LStudentAccount lStudentAccount = lStudentAccounts.get(0);
            // 存入用户
            SessionSetUser(lStudentAccount.getName(), "学生", lStudentAccount.getStudentId());
        }
        return success("登录成功");
    }

    /**
     *  把用户存入session
     * @param username
     * @param userType
     * @param id
     */
    private void SessionSetUser(String username, String userType, String id){
        // 把用户存入session
        UserDTO userDTO = new UserDTO();
        userDTO.setId(id);
        userDTO.setUsername(username);
        userDTO.setUserType(userType);
        getRequest().getSession().setAttribute("user", userDTO);
    }

    /**
     *  异步判断用户是否登录
     * @return
     */
    @GetMapping("/judgeUser")
    @ResponseBody
    public AjaxResult judgeUser(){
        Object user = getRequest().getSession().getAttribute("user");
        if (user==null){
            return error("您没有登录，请登录后再操作！");
        }
        return success();
    }

    /**
     * 注册
     * @param registerDTO
     * @return
     */
    @PostMapping("/register")
    @ResponseBody
    public AjaxResult Register( @RequestBody RegisterDTO registerDTO){

        // 1. 判断注册类型 0-老师 1-学生
        if ("0".equals(registerDTO.getUserType()))
        {
            LTeacherAccount lTeacherAccount = new LTeacherAccount();
            // 加密密码
            lTeacherAccount.setPassword(DigestUtils.md5Hex(registerDTO.getPassword()));
            lTeacherAccount.setTeacherId(registerDTO.getId());
            lTeacherAccount.setUsername(registerDTO.getUsername());
            teacherAccountService.insertLTeacherAccount(lTeacherAccount);

            return success("注册成功");
        }else if ("1".equals(registerDTO.getUserType()))
        {
            LStudentAccount lStudentAccount = new LStudentAccount();
            // 加密密码
            lStudentAccount.setPassword(DigestUtils.md5Hex(registerDTO.getPassword()));
            lStudentAccount.setStudentId(registerDTO.getId());
            lStudentAccount.setName(registerDTO.getUsername());
            studentAccountService.insertLStudentAccount(lStudentAccount);

            return success("注册成功");
        }
        return error("注册失败");
    }

    /**
     * 用户退出
     *
     * @return
     */
    @GetMapping("/signOut")
    @ResponseBody
    public AjaxResult SignOut(){
        // 判断一下session是否有这个用户
        if (getRequest().getSession().getAttribute("user")!=null){
            getRequest().getSession().removeAttribute("user");
            return success("退出成功");
        }
        return error();
    }

    /**
     * 异步校验用户 判断用户名是否重复-学号或教师号是否存在
     * @param username
     * @param id
     * @return
     */
    @PostMapping("user/checkedUser")
    @ResponseBody
    public Boolean CheckedUser( String username, String id, String userType){

        // 1. 如果用户名不为空
        if (StringUtils.isNotEmpty(username))
        {
            // 1.2. 判断用户类型 0-为老师 1-为学生
            if ("0".equals(userType))
            {
                // 1.2.1 查询教师用户名是否存在
                LTeacherAccount lTeacherAccount = teacherAccountService.selectLTeacherAccountByname(username);
                if (lTeacherAccount == null) //不存在
                {
                    return true;
                }
            } else if ("1".equals(userType))
            {
                // 1.2.2 查询学生用户名是否存在
                LStudentAccount lStudentAccount = studentAccountService.selectLStudentAccountByName(username);
                if (lStudentAccount == null)  //不存在
                {
                    return true;
                }
            }
        }

        // 2.0 如果id（教师号-学生好）不为空
        if (StringUtils.isNotEmpty(id))
        {
            // 2.1 判断用户类型 0-为老师 1-为学生
            if ("0".equals(userType))
            {
                // 2.1.1 查询教师号是否已被注册
                LTeacherAccount lTeacherAccount = teacherAccountService.selectLTeacherAccountByTeacherId(id);
                if (lTeacherAccount!=null) //存在
                {
                    return false;
                }
                // 2.1.2 查询教师号是否存在
                LTeacher lTeacher = teacherService.selectLTeacherByTearcherId(id);
                if (lTeacher == null){ //不存在
                    return false;
                }
                return true;
            } else if ("1".equals(userType))
            {
                // 2.2.1 查询学生号是否被注册
                LStudentAccount lStudentAccount = studentAccountService.selectLStudentAccountByStudentId(id);
                if (lStudentAccount != null) //存在
                {
                    return false;
                }
                // 2.2.2 查询学生号是否存在
                LStudent lStudent = studentService.selectLStudentByStudentId(id);
                if (lStudent==null)  //不存在
                {
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}
