package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.LStudentAccount;
import com.ruoyi.system.mapper.LStudentAccountMapper;
import com.ruoyi.system.service.ILStudentAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学生账户Service业务层处理
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
@Service("student_account")
public class LStudentAccountServiceImpl implements ILStudentAccountService 
{
    @Autowired
    private LStudentAccountMapper lStudentAccountMapper;

    /**
     * 查询学生账户
     * 
     * @param id 学生账户ID
     * @return 学生账户
     */
    @Override
    public LStudentAccount selectLStudentAccountById(Long id)
    {
        return lStudentAccountMapper.selectLStudentAccountById(id);
    }

    /**
     * 查询学生账户列表
     * 
     * @param lStudentAccount 学生账户
     * @return 学生账户
     */
    @Override
    public List<LStudentAccount> selectLStudentAccountList(LStudentAccount lStudentAccount)
    {
        return lStudentAccountMapper.selectLStudentAccountList(lStudentAccount);
    }

    /**
     * 新增学生账户
     * 
     * @param lStudentAccount 学生账户
     * @return 结果
     */
    @Override
    public int insertLStudentAccount(LStudentAccount lStudentAccount)
    {
        return lStudentAccountMapper.insertLStudentAccount(lStudentAccount);
    }

    /**
     * 修改学生账户
     * 
     * @param lStudentAccount 学生账户
     * @return 结果
     */
    @Override
    public int updateLStudentAccount(LStudentAccount lStudentAccount)
    {
        return lStudentAccountMapper.updateLStudentAccount(lStudentAccount);
    }

    /**
     * 删除学生账户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLStudentAccountByIds(String ids)
    {
        return lStudentAccountMapper.deleteLStudentAccountByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学生账户信息
     * 
     * @param id 学生账户ID
     * @return 结果
     */
    @Override
    public int deleteLStudentAccountById(Long id)
    {
        return lStudentAccountMapper.deleteLStudentAccountById(id);
    }

    /**
     * 查询学生账户
     *
     * @param username 用户姓名
     * @return 学生账户
     */
    @Override
    public LStudentAccount selectLStudentAccountByName(String username) {
        return lStudentAccountMapper.selectLStudentAccountByName(username);
    }

    /**
     * 查询学生
     *
     * @param studentId 学生号
     * @return 学生账户
     */
    @Override
    public LStudentAccount selectLStudentAccountByStudentId(String studentId) {
        return lStudentAccountMapper.selectLStudentAccountByStudentId(studentId);
    }
}
