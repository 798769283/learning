package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.LQuestionCategory;
import com.ruoyi.system.mapper.LQuestionCategoryMapper;
import com.ruoyi.system.service.ILQuestionCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 考题类别（按班级划分）Service业务层处理
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
@Service("questionCategory")
public class LQuestionCategoryServiceImpl implements ILQuestionCategoryService 
{
    @Autowired
    private LQuestionCategoryMapper lQuestionCategoryMapper;

    /**
     * 查询考题类别（按班级划分）
     * 
     * @param id 考题类别（按班级划分）ID
     * @return 考题类别（按班级划分）
     */
    @Override
    public LQuestionCategory selectLQuestionCategoryById(Long id)
    {
        return lQuestionCategoryMapper.selectLQuestionCategoryById(id);
    }

    /**
     * 查询考题类别（按班级划分）列表
     * 
     * @param lQuestionCategory 考题类别（按班级划分）
     * @return 考题类别（按班级划分）
     */
    @Override
    public List<LQuestionCategory> selectLQuestionCategoryList(LQuestionCategory lQuestionCategory)
    {
        return lQuestionCategoryMapper.selectLQuestionCategoryList(lQuestionCategory);
    }

    /**
     * 新增考题类别（按班级划分）
     * 
     * @param lQuestionCategory 考题类别（按班级划分）
     * @return 结果
     */
    @Override
    public int insertLQuestionCategory(LQuestionCategory lQuestionCategory)
    {
        return lQuestionCategoryMapper.insertLQuestionCategory(lQuestionCategory);
    }

    /**
     * 修改考题类别（按班级划分）
     * 
     * @param lQuestionCategory 考题类别（按班级划分）
     * @return 结果
     */
    @Override
    public int updateLQuestionCategory(LQuestionCategory lQuestionCategory)
    {
        return lQuestionCategoryMapper.updateLQuestionCategory(lQuestionCategory);
    }

    /**
     * 删除考题类别（按班级划分）对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLQuestionCategoryByIds(String ids)
    {
        return lQuestionCategoryMapper.deleteLQuestionCategoryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除考题类别（按班级划分）信息
     * 
     * @param id 考题类别（按班级划分）ID
     * @return 结果
     */
    @Override
    public int deleteLQuestionCategoryById(Long id)
    {
        return lQuestionCategoryMapper.deleteLQuestionCategoryById(id);
    }
}
