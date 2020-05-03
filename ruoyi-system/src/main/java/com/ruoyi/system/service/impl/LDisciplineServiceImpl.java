package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.LDiscipline;
import com.ruoyi.system.mapper.LDisciplineMapper;
import com.ruoyi.system.service.ILDisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 专业课Service业务层处理
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
@Service("discipline")
public class LDisciplineServiceImpl implements ILDisciplineService 
{
    @Autowired
    private LDisciplineMapper lDisciplineMapper;

    /**
     * 查询专业课
     * 
     * @param id 专业课ID
     * @return 专业课
     */
    @Override
    public LDiscipline selectLDisciplineById(Long id)
    {
        return lDisciplineMapper.selectLDisciplineById(id);
    }

    /**
     * 查询专业课列表
     * 
     * @param lDiscipline 专业课
     * @return 专业课
     */
    @Override
    public List<LDiscipline> selectLDisciplineList(LDiscipline lDiscipline)
    {
        return lDisciplineMapper.selectLDisciplineList(lDiscipline);
    }

    /**
     * 新增专业课
     * 
     * @param lDiscipline 专业课
     * @return 结果
     */
    @Override
    public int insertLDiscipline(LDiscipline lDiscipline)
    {
        return lDisciplineMapper.insertLDiscipline(lDiscipline);
    }

    /**
     * 修改专业课
     * 
     * @param lDiscipline 专业课
     * @return 结果
     */
    @Override
    public int updateLDiscipline(LDiscipline lDiscipline)
    {
        return lDisciplineMapper.updateLDiscipline(lDiscipline);
    }

    /**
     * 删除专业课对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLDisciplineByIds(String ids)
    {
        return lDisciplineMapper.deleteLDisciplineByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除专业课信息
     * 
     * @param id 专业课ID
     * @return 结果
     */
    @Override
    public int deleteLDisciplineById(Long id)
    {
        return lDisciplineMapper.deleteLDisciplineById(id);
    }
}
