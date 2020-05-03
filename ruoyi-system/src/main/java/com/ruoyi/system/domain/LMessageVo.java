package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.domain
 * @ClassName: LMessageVo
 * @Author: 胡天霸
 * @Date: 2020/4/29 16:21
 * @Version: 1.0
 */
public class LMessageVo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
