package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.LMaterial;

/**
 * 资料Service接口
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
public interface ILMaterialService 
{
    /**
     * 查询资料
     * 
     * @param id 资料ID
     * @return 资料
     */
    public LMaterial selectLMaterialById(Long id);

    /**
     * 查询资料列表
     * 
     * @param lMaterial 资料
     * @return 资料集合
     */
    public List<LMaterial> selectLMaterialList(LMaterial lMaterial);

    /**
     * 新增资料
     * 
     * @param lMaterial 资料
     * @return 结果
     */
    public int insertLMaterial(LMaterial lMaterial);

    /**
     * 修改资料
     * 
     * @param lMaterial 资料
     * @return 结果
     */
    public int updateLMaterial(LMaterial lMaterial);

    /**
     * 批量删除资料
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLMaterialByIds(String ids);

    /**
     * 删除资料信息
     * 
     * @param id 资料ID
     * @return 结果
     */
    public int deleteLMaterialById(Long id);
}
