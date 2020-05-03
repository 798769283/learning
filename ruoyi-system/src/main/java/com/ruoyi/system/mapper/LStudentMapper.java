package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.LStudent;

import java.util.List;

/**
 * 学生Mapper接口
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
public interface LStudentMapper 
{
    /**
     * 查询学生
     * 
     * @param id 学生ID
     * @return 学生
     */
    public LStudent selectLStudentById(Long id);

    /**
     * 查询学生列表
     * 
     * @param lStudent 学生
     * @return 学生集合
     */
    public List<LStudent> selectLStudentList(LStudent lStudent);

    /**
     * 新增学生
     * 
     * @param lStudent 学生
     * @return 结果
     */
    public int insertLStudent(LStudent lStudent);

    /**
     * 修改学生
     * 
     * @param lStudent 学生
     * @return 结果
     */
    public int updateLStudent(LStudent lStudent);

    /**
     * 删除学生
     * 
     * @param id 学生ID
     * @return 结果
     */
    public int deleteLStudentById(Long id);

    /**
     * 批量删除学生
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLStudentByIds(String[] ids);

    /**
     * 查询学生
     *
     * @param studentId 学生号
     * @return 学生
     */
    public LStudent selectLStudentByStudentId(String studentId);
}
