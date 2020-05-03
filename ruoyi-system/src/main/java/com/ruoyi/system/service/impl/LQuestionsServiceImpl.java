package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.LQuestionsMapper;
import com.ruoyi.system.domain.LQuestions;
import com.ruoyi.system.service.ILQuestionsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 考题Service业务层处理
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
@Service
public class LQuestionsServiceImpl implements ILQuestionsService 
{
    @Autowired
    private LQuestionsMapper lQuestionsMapper;

    /**
     * 查询考题
     * 
     * @param id 考题ID
     * @return 考题
     */
    @Override
    public LQuestions selectLQuestionsById(Long id)
    {
        return lQuestionsMapper.selectLQuestionsById(id);
    }

    /**
     * 查询考题列表
     * 
     * @param lQuestions 考题
     * @return 考题
     */
    @Override
    public List<LQuestions> selectLQuestionsList(LQuestions lQuestions)
    {
        return lQuestionsMapper.selectLQuestionsList(lQuestions);
    }

    /**
     * 新增考题
     * 
     * @param lQuestions 考题
     * @return 结果
     */
    @Override
    public int insertLQuestions(LQuestions lQuestions)
    {
        return lQuestionsMapper.insertLQuestions(lQuestions);
    }

    /**
     * 修改考题
     * 
     * @param lQuestions 考题
     * @return 结果
     */
    @Override
    public int updateLQuestions(LQuestions lQuestions)
    {
        return lQuestionsMapper.updateLQuestions(lQuestions);
    }

    /**
     * 删除考题对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLQuestionsByIds(String ids)
    {
        return lQuestionsMapper.deleteLQuestionsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除考题信息
     * 
     * @param id 考题ID
     * @return 结果
     */
    @Override
    public int deleteLQuestionsById(Long id)
    {
        return lQuestionsMapper.deleteLQuestionsById(id);
    }
}
