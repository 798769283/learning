package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.LQuestions;

/**
 * 考题Service接口
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
public interface ILQuestionsService 
{
    /**
     * 查询考题
     * 
     * @param id 考题ID
     * @return 考题
     */
    public LQuestions selectLQuestionsById(Long id);

    /**
     * 查询考题列表
     * 
     * @param lQuestions 考题
     * @return 考题集合
     */
    public List<LQuestions> selectLQuestionsList(LQuestions lQuestions);

    /**
     * 新增考题
     * 
     * @param lQuestions 考题
     * @return 结果
     */
    public int insertLQuestions(LQuestions lQuestions);

    /**
     * 修改考题
     * 
     * @param lQuestions 考题
     * @return 结果
     */
    public int updateLQuestions(LQuestions lQuestions);

    /**
     * 批量删除考题
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLQuestionsByIds(String ids);

    /**
     * 删除考题信息
     * 
     * @param id 考题ID
     * @return 结果
     */
    public int deleteLQuestionsById(Long id);
}
