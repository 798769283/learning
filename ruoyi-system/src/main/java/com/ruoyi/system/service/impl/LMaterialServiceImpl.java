package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.LMaterial;
import com.ruoyi.system.mapper.LMaterialMapper;
import com.ruoyi.system.service.ILMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 资料Service业务层处理
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
@Service
public class LMaterialServiceImpl implements ILMaterialService 
{
    @Autowired
    private LMaterialMapper lMaterialMapper;

    /**
     * 查询资料
     * 
     * @param id 资料ID
     * @return 资料
     */
    @Override
    public LMaterial selectLMaterialById(Long id)
    {
        return lMaterialMapper.selectLMaterialById(id);
    }

    /**
     * 查询资料列表
     * 
     * @param lMaterial 资料
     * @return 资料
     */
    @Override
    public List<LMaterial> selectLMaterialList(LMaterial lMaterial)
    {
        return lMaterialMapper.selectLMaterialList(lMaterial);
    }

    /**
     * 新增资料
     * 
     * @param lMaterial 资料
     * @return 结果
     */
    @Override
    public int insertLMaterial(LMaterial lMaterial)
    {
        lMaterial.setCreateTime(DateUtils.getNowDate());
        return lMaterialMapper.insertLMaterial(lMaterial);
    }

    /**
     * 修改资料
     * 
     * @param lMaterial 资料
     * @return 结果
     */
    @Override
    public int updateLMaterial(LMaterial lMaterial)
    {
        return lMaterialMapper.updateLMaterial(lMaterial);
    }

    /**
     * 删除资料对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLMaterialByIds(String ids)
    {
        return lMaterialMapper.deleteLMaterialByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除资料信息
     * 
     * @param id 资料ID
     * @return 结果
     */
    @Override
    public int deleteLMaterialById(Long id)
    {
        return lMaterialMapper.deleteLMaterialById(id);
    }
}
