package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 资料对象 l_material
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
public class LMaterial extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 资料名称 */
    @Excel(name = "资料名称")
    private String name;

    /** 介绍 */
    @Excel(name = "介绍")
    private String introduction;

    /** $column.columnComment */
    @Excel(name = "介绍")
    private String fileUrl;

    /** 0-资料，1-作业，2-视频 */
    @Excel(name = "0-资料，1-作业，2-视频")
    private Integer status;

    /** 所属专业的资料 */
    @Excel(name = "所属专业的资料")
    private Long dId;

    /** 创建者 */
    @Excel(name = "创建者")
    private String createBy;

    @Override
    public String getCreateBy() {
        return createBy;
    }

    @Override
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setIntroduction(String introduction) 
    {
        this.introduction = introduction;
    }

    public String getIntroduction() 
    {
        return introduction;
    }
    public void setFileUrl(String fileUrl) 
    {
        this.fileUrl = fileUrl;
    }

    public String getFileUrl() 
    {
        return fileUrl;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }

    public Long getdId() {
        return dId;
    }

    public void setdId(Long dId) {
        this.dId = dId;
    }

    @Override
    public String toString() {
        return "LMaterial{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", introduction='" + introduction + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                ", status=" + status +
                ", dId=" + dId +
                ", createBy='" + createBy + '\'' +
                '}';
    }
}
