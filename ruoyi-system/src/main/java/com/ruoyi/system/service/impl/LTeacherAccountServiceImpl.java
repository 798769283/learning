package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.LTeacherAccount;
import com.ruoyi.system.mapper.LTeacherAccountMapper;
import com.ruoyi.system.service.ILTeacherAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 老师账户Service业务层处理
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
@Service
public class LTeacherAccountServiceImpl implements ILTeacherAccountService 
{
    @Autowired
    private LTeacherAccountMapper lTeacherAccountMapper;

    /**
     * 查询老师账户
     * 
     * @param id 老师账户ID
     * @return 老师账户
     */
    @Override
    public LTeacherAccount selectLTeacherAccountById(Long id)
    {
        return lTeacherAccountMapper.selectLTeacherAccountById(id);
    }


    /**
     * 查询老师账户列表
     * 
     * @param lTeacherAccount 老师账户
     * @return 老师账户
     */
    @Override
    public List<LTeacherAccount> selectLTeacherAccountList(LTeacherAccount lTeacherAccount)
    {
        return lTeacherAccountMapper.selectLTeacherAccountList(lTeacherAccount);
    }

    /**
     * 新增老师账户
     * 
     * @param lTeacherAccount 老师账户
     * @return 结果
     */
    @Override
    public int insertLTeacherAccount(LTeacherAccount lTeacherAccount)
    {
        return lTeacherAccountMapper.insertLTeacherAccount(lTeacherAccount);
    }

    /**
     * 修改老师账户
     * 
     * @param lTeacherAccount 老师账户
     * @return 结果
     */
    @Override
    public int updateLTeacherAccount(LTeacherAccount lTeacherAccount)
    {
        return lTeacherAccountMapper.updateLTeacherAccount(lTeacherAccount);
    }

    /**
     * 删除老师账户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLTeacherAccountByIds(String ids)
    {
        return lTeacherAccountMapper.deleteLTeacherAccountByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除老师账户信息
     * 
     * @param id 老师账户ID
     * @return 结果
     */
    @Override
    public int deleteLTeacherAccountById(Long id)
    {
        return lTeacherAccountMapper.deleteLTeacherAccountById(id);
    }

    /**
     *  根据用户姓名查找
     * @param username
     * @return
     */
    @Override
    public LTeacherAccount selectLTeacherAccountByname(String username) {
        return lTeacherAccountMapper.selectLTeacherAccountByNmae(username);
    }

    @Override
    public LTeacherAccount selectLTeacherAccountByTeacherId(String teacherId) {
        return lTeacherAccountMapper.selectLTeacherAccountByTeacherId(teacherId);
    }
}
