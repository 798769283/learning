package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.LTeacher;
import com.ruoyi.system.mapper.LTeacherMapper;
import com.ruoyi.system.service.ILTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 老师Service业务层处理
 * 
 * @author HuTianba
 * @date 2020-04-29
 */
@Service
public class LTeacherServiceImpl implements ILTeacherService 
{
    @Autowired
    private LTeacherMapper lTeacherMapper;

    /**
     * 查询老师
     * 
     * @param id 老师ID
     * @return 老师
     */
    @Override
    public LTeacher selectLTeacherById(Long id)
    {
        return lTeacherMapper.selectLTeacherById(id);
    }

    /**
     * 查询老师列表
     * 
     * @param lTeacher 老师
     * @return 老师
     */
    @Override
    public List<LTeacher> selectLTeacherList(LTeacher lTeacher)
    {
        return lTeacherMapper.selectLTeacherList(lTeacher);
    }

    /**
     * 新增老师
     * 
     * @param lTeacher 老师
     * @return 结果
     */
    @Override
    public int insertLTeacher(LTeacher lTeacher)
    {
        return lTeacherMapper.insertLTeacher(lTeacher);
    }

    /**
     * 修改老师
     * 
     * @param lTeacher 老师
     * @return 结果
     */
    @Override
    public int updateLTeacher(LTeacher lTeacher)
    {
        return lTeacherMapper.updateLTeacher(lTeacher);
    }

    /**
     * 删除老师对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLTeacherByIds(String ids)
    {
        return lTeacherMapper.deleteLTeacherByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除老师信息
     * 
     * @param id 老师ID
     * @return 结果
     */
    @Override
    public int deleteLTeacherById(Long id)
    {
        return lTeacherMapper.deleteLTeacherById(id);
    }

    /**
     * 查询老师
     *
     * @param tearcherId 教师号
     * @return 老师
     */
    @Override
    public LTeacher selectLTeacherByTearcherId(String tearcherId) {
        return lTeacherMapper.selectLTeacherByTearcherId(tearcherId);
    }
}
