package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 考题对象 l_questions
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
public class LQuestions extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String name;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String optionA;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String optionB;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String optionC;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String optionD;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String optionE;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String optionF;

    /** 答案 */
    @Excel(name = "答案")
    private String answer;

    /** 分数 */
    @Excel(name = "分数")
    private Long fraction;

    /** 考题分类Id */
    @Excel(name = "考题分类Id")
    private Long qCId;

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
    public void setOptionA(String optionA) 
    {
        this.optionA = optionA;
    }

    public String getOptionA() 
    {
        return optionA;
    }
    public void setOptionB(String optionB) 
    {
        this.optionB = optionB;
    }

    public String getOptionB() 
    {
        return optionB;
    }
    public void setOptionC(String optionC) 
    {
        this.optionC = optionC;
    }

    public String getOptionC() 
    {
        return optionC;
    }
    public void setOptionD(String optionD) 
    {
        this.optionD = optionD;
    }

    public String getOptionD() 
    {
        return optionD;
    }
    public void setOptionE(String optionE) 
    {
        this.optionE = optionE;
    }

    public String getOptionE() 
    {
        return optionE;
    }
    public void setOptionF(String optionF) 
    {
        this.optionF = optionF;
    }

    public String getOptionF() 
    {
        return optionF;
    }
    public void setAnswer(String answer) 
    {
        this.answer = answer;
    }

    public String getAnswer() 
    {
        return answer;
    }
    public void setFraction(Long fraction) 
    {
        this.fraction = fraction;
    }

    public Long getFraction() 
    {
        return fraction;
    }


    public Long getqCId() {
        return qCId;
    }

    public void setqCId(Long qCId) {
        this.qCId = qCId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("optionA", getOptionA())
            .append("optionB", getOptionB())
            .append("optionC", getOptionC())
            .append("optionD", getOptionD())
            .append("optionE", getOptionE())
            .append("optionF", getOptionF())
            .append("answer", getAnswer())
            .append("fraction", getFraction())
            .toString();
    }
}
