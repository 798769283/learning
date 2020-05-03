package com.ruoyi.system.service;

import com.ruoyi.system.domain.LTeacher;

import java.util.List;

/**
 * 老师Service接口
 * 
 * @author HuTianba
 * @date 2020-04-29
 */
public interface ILTeacherService 
{
    /**
     * 查询老师
     * 
     * @param id 老师ID
     * @return 老师
     */
    public LTeacher selectLTeacherById(Long id);

    /**
     * 查询老师列表
     * 
     * @param lTeacher 老师
     * @return 老师集合
     */
    public List<LTeacher> selectLTeacherList(LTeacher lTeacher);

    /**
     * 新增老师
     * 
     * @param lTeacher 老师
     * @return 结果
     */
    public int insertLTeacher(LTeacher lTeacher);

    /**
     * 修改老师
     * 
     * @param lTeacher 老师
     * @return 结果
     */
    public int updateLTeacher(LTeacher lTeacher);

    /**
     * 批量删除老师
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLTeacherByIds(String ids);

    /**
     * 删除老师信息
     * 
     * @param id 老师ID
     * @return 结果
     */
    public int deleteLTeacherById(Long id);

    /**
     * 查询老师
     *
     * @param tearcherId 教师号
     * @return 老师
     */
    public LTeacher selectLTeacherByTearcherId(String tearcherId);
}
