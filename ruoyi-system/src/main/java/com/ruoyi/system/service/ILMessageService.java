package com.ruoyi.system.service;

import com.ruoyi.system.domain.LMessage;

import java.util.List;

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

    /**
     * 查询当前用户私信列表
     * @param userId 接收人的ID
     * @return
     */
    public List<LMessage> selectMessageList(String userId);

    /**
     * 查询当前用户未读信息
     * @param userId
     * @param conversationId
     * @return
     */
    public Integer sumUnreadMessage(String userId, String conversationId);

    /**
     *  查询当前会话全部消息总和
     *  @param conversationId 会话id
     * @return
     */
    public Integer totalMessage(String conversationId);

    /**
     * 查看当前会话全部消息详情
     * @param conversationId
     * @return
     */
    public List<LMessage> selectMessageByConversationIdList(String conversationId);

    /**
     * 查看当前用户全部未读消息记录
     * @param userId
     * @return
     */
    public Integer totalUnreadMessage(String userId);

    /**
     *  改变消息状态
     * @param userId 用户id
     * @param status 消息状态
     * @param conversationId 会话ID
     * @return
     */
    public int updateMeesageStatus(String userId, String status, String conversationId);
}
