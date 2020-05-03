package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 班级对象 l_class
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
public class LClass extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 班级名字 */
    @Excel(name = "班级名字")
    private String name;

    /** 专业课Id */
    @Excel(name = "专业课Id")
    private Long dId;

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
    public void setdId(Long dId) 
    {
        this.dId = dId;
    }

    public Long getdId() 
    {
        return dId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("dId", getdId())
            .toString();
    }
}
