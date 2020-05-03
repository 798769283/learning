package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.LStudent;
import com.ruoyi.system.mapper.LStudentMapper;
import com.ruoyi.system.service.ILStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学生Service业务层处理
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
@Service
public class LStudentServiceImpl implements ILStudentService 
{
    @Autowired
    private LStudentMapper lStudentMapper;

    /**
     * 查询学生
     * 
     * @param id 学生ID
     * @return 学生
     */
    @Override
    public LStudent selectLStudentById(Long id)
    {
        return lStudentMapper.selectLStudentById(id);
    }

    /**
     * 查询学生列表
     * 
     * @param lStudent 学生
     * @return 学生
     */
    @Override
    public List<LStudent> selectLStudentList(LStudent lStudent)
    {
        return lStudentMapper.selectLStudentList(lStudent);
    }

    /**
     * 新增学生
     * 
     * @param lStudent 学生
     * @return 结果
     */
    @Override
    public int insertLStudent(LStudent lStudent)
    {
        return lStudentMapper.insertLStudent(lStudent);
    }

    /**
     * 修改学生
     * 
     * @param lStudent 学生
     * @return 结果
     */
    @Override
    public int updateLStudent(LStudent lStudent)
    {
        return lStudentMapper.updateLStudent(lStudent);
    }

    /**
     * 删除学生对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLStudentByIds(String ids)
    {
        return lStudentMapper.deleteLStudentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学生信息
     * 
     * @param id 学生ID
     * @return 结果
     */
    @Override
    public int deleteLStudentById(Long id)
    {
        return lStudentMapper.deleteLStudentById(id);
    }


    /**
     * 查询学生
     *
     * @param studentId 学生号
     * @return 学生
     */
    @Override
    public LStudent selectLStudentByStudentId(String studentId) {
        return lStudentMapper.selectLStudentByStudentId(studentId);
    }
}
