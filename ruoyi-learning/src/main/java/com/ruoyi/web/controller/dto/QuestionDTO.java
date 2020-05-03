package com.ruoyi.web.controller.dto;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.web.controller.dto
 * @ClassName: 考题
 * @Author: 胡天霸
 * @Date: 2020/5/3 10:32
 * @Version: 1.0
 */
public class QuestionDTO {

    /**
     * 题目Id
     */
    private Long questionId;

    /**
     * 题目标题
     */
    private String questionTitle;

    /**
     *  题目选项
     */
    private String questionItems;

    /**
     * 答案
     */
    private String questionAnswer;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionItems() {
        return questionItems;
    }

    public void setQuestionItems(String questionItems) {
        this.questionItems = questionItems;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    @Override
    public String toString() {
        return "QuestionDTO{" +
                "questionId=" + questionId +
                ", questionTitle='" + questionTitle + '\'' +
                ", questionItems='" + questionItems + '\'' +
                ", questionAnswer='" + questionAnswer + '\'' +
                '}';
    }
}
