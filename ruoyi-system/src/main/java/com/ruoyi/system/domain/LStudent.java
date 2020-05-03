package com.ruoyi.system.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生对象 l_student
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
public class LStudent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 学号 */
    @Excel(name = "学号")
    private String studentId;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String name;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 班级Id */
    @Excel(name = "班级Id")
    private Long cId;

    /** 入学时间 */
    @Excel(name = "入学时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startYear;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setStudentId(String studentId) 
    {
        this.studentId = studentId;
    }

    public String getStudentId() 
    {
        return studentId;
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
    public void setcId(Long cId) 
    {
        this.cId = cId;
    }

    public Long getcId() 
    {
        return cId;
    }
    public void setStartYear(Date startYear) 
    {
        this.startYear = startYear;
    }

    public Date getStartYear() 
    {
        return startYear;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("studentId", getStudentId())
            .append("name", getName())
            .append("sex", getSex())
            .append("cId", getcId())
            .append("startYear", getStartYear())
            .toString();
    }
}
