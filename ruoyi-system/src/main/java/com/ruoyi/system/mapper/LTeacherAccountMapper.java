package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.LTeacherAccount;

import java.util.List;

/**
 * 老师账户Mapper接口
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
public interface LTeacherAccountMapper 
{
    /**
     * 查询老师账户
     * 
     * @param id 老师账户ID
     * @return 老师账户
     */
    public LTeacherAccount selectLTeacherAccountById(Long id);

    /**
     * 查询老师账户列表
     * 
     * @param lTeacherAccount 老师账户
     * @return 老师账户集合
     */
    public List<LTeacherAccount> selectLTeacherAccountList(LTeacherAccount lTeacherAccount);

    /**
     * 新增老师账户
     * 
     * @param lTeacherAccount 老师账户
     * @return 结果
     */
    public int insertLTeacherAccount(LTeacherAccount lTeacherAccount);

    /**
     * 修改老师账户
     * 
     * @param lTeacherAccount 老师账户
     * @return 结果
     */
    public int updateLTeacherAccount(LTeacherAccount lTeacherAccount);

    /**
     * 删除老师账户
     * 
     * @param id 老师账户ID
     * @return 结果
     */
    public int deleteLTeacherAccountById(Long id);

    /**
     * 批量删除老师账户
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLTeacherAccountByIds(String[] ids);

    /**
     * 根据用户姓名查找
     * @param username
     * @return
     */
    public LTeacherAccount selectLTeacherAccountByNmae(String username);

    /**
     * 根据教师号查找
     * @param teacherId
     * @return
     */
    public LTeacherAccount selectLTeacherAccountByTeacherId(String teacherId);

}
