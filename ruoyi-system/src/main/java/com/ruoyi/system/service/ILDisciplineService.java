package com.ruoyi.system.service;

import com.ruoyi.system.domain.LDiscipline;

import java.util.List;

/**
 * 专业课Service接口
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
public interface ILDisciplineService 
{
    /**
     * 查询专业课
     * 
     * @param id 专业课ID
     * @return 专业课
     */
    public LDiscipline selectLDisciplineById(Long id);

    /**
     * 查询专业课列表
     * 
     * @param lDiscipline 专业课
     * @return 专业课集合
     */
    public List<LDiscipline> selectLDisciplineList(LDiscipline lDiscipline);

    /**
     * 新增专业课
     * 
     * @param lDiscipline 专业课
     * @return 结果
     */
    public int insertLDiscipline(LDiscipline lDiscipline);

    /**
     * 修改专业课
     * 
     * @param lDiscipline 专业课
     * @return 结果
     */
    public int updateLDiscipline(LDiscipline lDiscipline);

    /**
     * 批量删除专业课
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLDisciplineByIds(String ids);

    /**
     * 删除专业课信息
     * 
     * @param id 专业课ID
     * @return 结果
     */
    public int deleteLDisciplineById(Long id);
}
