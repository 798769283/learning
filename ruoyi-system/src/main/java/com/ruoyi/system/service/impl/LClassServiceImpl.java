package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.LClass;
import com.ruoyi.system.mapper.LClassMapper;
import com.ruoyi.system.service.ILClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 班级Service业务层处理
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
@Service("l_class")
public class LClassServiceImpl implements ILClassService 
{
    @Autowired
    private LClassMapper lClassMapper;

    /**
     * 查询班级
     * 
     * @param id 班级ID
     * @return 班级
     */
    @Override
    public LClass selectLClassById(Long id)
    {
        return lClassMapper.selectLClassById(id);
    }

    /**
     * 查询班级列表
     * 
     * @param lClass 班级
     * @return 班级
     */
    @Override
    public List<LClass> selectLClassList(LClass lClass)
    {
        return lClassMapper.selectLClassList(lClass);
    }

    /**
     * 新增班级
     * 
     * @param lClass 班级
     * @return 结果
     */
    @Override
    public int insertLClass(LClass lClass)
    {
        return lClassMapper.insertLClass(lClass);
    }

    /**
     * 修改班级
     * 
     * @param lClass 班级
     * @return 结果
     */
    @Override
    public int updateLClass(LClass lClass)
    {
        return lClassMapper.updateLClass(lClass);
    }

    /**
     * 删除班级对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLClassByIds(String ids)
    {
        return lClassMapper.deleteLClassByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除班级信息
     * 
     * @param id 班级ID
     * @return 结果
     */
    @Override
    public int deleteLClassById(Long id)
    {
        return lClassMapper.deleteLClassById(id);
    }
}
