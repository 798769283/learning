package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.LMessage;

/**
 * 会话Service接口
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
public interface ILMessageService 
{
    /**
     * 查询会话
     * 
     * @param id 会话ID
     * @return 会话
     */
    public LMessage selectLMessageById(Long id);

    /**
     * 查询会话列表
     * 
     * @param lMessage 会话
     * @return 会话集合
     */
    public List<LMessage> selectLMessageList(LMessage lMessage);

    /**
     * 新增会话
     * 
     * @param lMessage 会话
     * @return 结果
     */
    public int insertLMessage(LMessage lMessage);

    /**
     * 修改会话
     * 
     * @param lMessage 会话
     * @return 结果
     */
    public int updateLMessage(LMessage lMessage);

    /**
     * 批量删除会话
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLMessageByIds(String ids);

    /**
     * 删除会话信息
     * 
     * @param id 会话ID
     * @return 结果
     */
    public int deleteLMessageById(Long id);
}
