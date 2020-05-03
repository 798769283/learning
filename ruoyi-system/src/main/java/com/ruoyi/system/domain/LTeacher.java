package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 老师对象 l_teacher
 * 
 * @author HuTianba
 * @date 2020-04-29
 */
public class LTeacher extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 教师号 */
    @Excel(name = "教师号")
    private String teacherId;

    /** $column.columnComment */
    @Excel(name = "教师号")
    private String name;

    /** $column.columnComment */
    @Excel(name = "教师号")
    private String sex;

    /** $column.columnComment */
    @Excel(name = "教师号")
    private Integer age;

    /** 专业课id */
    @Excel(name = "专业课id")
    private Long dId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTeacherId(String teacherId) 
    {
        this.teacherId = teacherId;
    }

    public String getTeacherId() 
    {
        return teacherId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setAge(Integer age) 
    {
        this.age = age;
    }

    public Integer getAge() 
    {
        return age;
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
            .append("teacherId", getTeacherId())
            .append("name", getName())
            .append("sex", getSex())
            .append("age", getAge())
            .append("dId", getdId())
            .toString();
    }
}
