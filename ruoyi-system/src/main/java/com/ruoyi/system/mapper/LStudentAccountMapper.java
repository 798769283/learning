package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.LStudentAccount;

import java.util.List;

/**
 * 学生账户Mapper接口
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
public interface LStudentAccountMapper 
{
    /**
     * 查询学生账户
     * 
     * @param id 学生账户ID
     * @return 学生账户
     */
    public LStudentAccount selectLStudentAccountById(Long id);

    /**
     * 查询学生账户列表
     * 
     * @param lStudentAccount 学生账户
     * @return 学生账户集合
     */
    public List<LStudentAccount> selectLStudentAccountList(LStudentAccount lStudentAccount);

    /**
     * 新增学生账户
     * 
     * @param lStudentAccount 学生账户
     * @return 结果
     */
    public int insertLStudentAccount(LStudentAccount lStudentAccount);

    /**
     * 修改学生账户
     * 
     * @param lStudentAccount 学生账户
     * @return 结果
     */
    public int updateLStudentAccount(LStudentAccount lStudentAccount);

    /**
     * 删除学生账户
     * 
     * @param id 学生账户ID
     * @return 结果
     */
    public int deleteLStudentAccountById(Long id);

    /**
     * 批量删除学生账户
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLStudentAccountByIds(String[] ids);

    /**
     * 查询学生
     *
     * @param username 用户姓名
     * @return 学生账户
     */
    public LStudentAccount selectLStudentAccountByName(String username);

    /**
     * 查询学生
     *
     * @param studentId 学生号
     * @return 学生账户
     */
    public LStudentAccount selectLStudentAccountByStudentId(String studentId);
}
