package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.LQuestionCategory;

/**
 * 考题类别（按班级划分）Mapper接口
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
public interface LQuestionCategoryMapper 
{
    /**
     * 查询考题类别（按班级划分）
     * 
     * @param id 考题类别（按班级划分）ID
     * @return 考题类别（按班级划分）
     */
    public LQuestionCategory selectLQuestionCategoryById(Long id);

    /**
     * 查询考题类别（按班级划分）列表
     * 
     * @param lQuestionCategory 考题类别（按班级划分）
     * @return 考题类别（按班级划分）集合
     */
    public List<LQuestionCategory> selectLQuestionCategoryList(LQuestionCategory lQuestionCategory);

    /**
     * 新增考题类别（按班级划分）
     * 
     * @param lQuestionCategory 考题类别（按班级划分）
     * @return 结果
     */
    public int insertLQuestionCategory(LQuestionCategory lQuestionCategory);

    /**
     * 修改考题类别（按班级划分）
     * 
     * @param lQuestionCategory 考题类别（按班级划分）
     * @return 结果
     */
    public int updateLQuestionCategory(LQuestionCategory lQuestionCategory);

    /**
     * 删除考题类别（按班级划分）
     * 
     * @param id 考题类别（按班级划分）ID
     * @return 结果
     */
    public int deleteLQuestionCategoryById(Long id);

    /**
     * 批量删除考题类别（按班级划分）
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLQuestionCategoryByIds(String[] ids);
}
