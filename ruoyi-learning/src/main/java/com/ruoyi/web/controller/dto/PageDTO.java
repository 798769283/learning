package com.ruoyi.web.controller.dto;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.web.controller.dto
 * @ClassName: 分页
 * @Author: 胡天霸
 * @Date: 2020/5/1 17:38
 * @Version: 1.0
 */
public class PageDTO  extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 当前页
     */
    private int currentSize;

    /**
     * 总页数
     */
    private int pages;

    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
