package com.ruoyi.web.controller.dto;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.web.controller.dto
 * @ClassName: 用户
 * @Author: 胡天霸
 * @Date: 2020/5/1 14:30
 * @Version: 1.0
 */
public class UserDTO extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 用户姓名
     */
    private String username;
    /**
     * 用于类型
     */
    private String userType;
    /**
     * 用户Id
     */
    private String id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
