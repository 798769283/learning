package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.LClass;

/**
 * 班级Mapper接口
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
public interface LClassMapper 
{
    /**
     * 查询班级
     * 
     * @param id 班级ID
     * @return 班级
     */
    public LClass selectLClassById(Long id);

    /**
     * 查询班级列表
     * 
     * @param lClass 班级
     * @return 班级集合
     */
    public List<LClass> selectLClassList(LClass lClass);

    /**
     * 新增班级
     * 
     * @param lClass 班级
     * @return 结果
     */
    public int insertLClass(LClass lClass);

    /**
     * 修改班级
     * 
     * @param lClass 班级
     * @return 结果
     */
    public int updateLClass(LClass lClass);

    /**
     * 删除班级
     * 
     * @param id 班级ID
     * @return 结果
     */
    public int deleteLClassById(Long id);

    /**
     * 批量删除班级
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLClassByIds(String[] ids);
}
