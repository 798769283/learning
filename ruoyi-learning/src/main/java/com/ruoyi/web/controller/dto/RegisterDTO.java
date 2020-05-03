package com.ruoyi.web.controller.dto;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.web.controller.dto
 * @ClassName: 用户注册DTO
 * @Author: 胡天霸
 * @Date: 2020/4/30 18:18
 * @Version: 1.0
 */
public class RegisterDTO extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用于判断注册类型
     */
    private String userType;

    /**
     * 用户姓名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 学号或者教师号
     */
    private String id;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RegisterDTO{" +
                "userType='" + userType + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
