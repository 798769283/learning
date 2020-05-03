package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生账户对象 l_student_account
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
public class LStudentAccount extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 学号 */
    @Excel(name = "学号")
    private String studentId;

    /** $column.columnComment */
    @Excel(name = "学号")
    private String name;

    /** $column.columnComment */
    @Excel(name = "学号")
    private String password;

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
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("studentId", getStudentId())
            .append("name", getName())
            .append("password", getPassword())
            .toString();
    }
}
