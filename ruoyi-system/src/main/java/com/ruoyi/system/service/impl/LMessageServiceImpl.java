package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.LMessage;
import com.ruoyi.system.mapper.LMessageMapper;
import com.ruoyi.system.service.ILMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会话Service业务层处理
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
@Service
public class LMessageServiceImpl implements ILMessageService 
{
    @Autowired
    private LMessageMapper lMessageMapper;

    /**
     * 查询会话
     * 
     * @param id 会话ID
     * @return 会话
     */
    @Override
    public LMessage selectLMessageById(Long id)
    {
        return lMessageMapper.selectLMessageById(id);
    }

    /**
     * 查询会话列表
     * 
     * @param lMessage 会话
     * @return 会话
     */
    @Override
    public List<LMessage> selectLMessageList(LMessage lMessage)
    {
        return lMessageMapper.selectLMessageList(lMessage);
    }

    /**
     * 新增会话
     * 
     * @param lMessage 会话
     * @return 结果
     */
    @Override
    public int insertLMessage(LMessage lMessage)
    {
        lMessage.setCreateTime(DateUtils.getNowDate());
        return lMessageMapper.insertLMessage(lMessage);
    }

    /**
     * 修改会话
     * 
     * @param lMessage 会话
     * @return 结果
     */
    @Override
    public int updateLMessage(LMessage lMessage)
    {
        return lMessageMapper.updateLMessage(lMessage);
    }

    /**
     * 删除会话对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLMessageByIds(String ids)
    {
        return lMessageMapper.deleteLMessageByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除会话信息
     * 
     * @param id 会话ID
     * @return 结果
     */
    @Override
    public int deleteLMessageById(Long id)
    {
        return lMessageMapper.deleteLMessageById(id);
    }

    /**
     * 查询当前用户私信列表
     * @param userId 接收人的ID
     * @return
     */
    @Override
    public List<LMessage> selectMessageList(String userId) {
        return lMessageMapper.selectMessageList(userId);
    }

    /**
     * 查询当前用户未读信息
     * @param userId
     * @param conversationId
     * @return
     */
    @Override
    public Integer sumUnreadMessage(String userId, String conversationId) {
        return lMessageMapper.sumUnreadMessage(userId, conversationId);
    }

    /**
     *  查询当前会话全部消息总和
     *  @param conversationId 会话id
     * @return
     */
    @Override
    public Integer totalMessage(String conversationId) {
        return lMessageMapper.totalMessage(conversationId);
    }

    /**
     * 查看当前会话全部消息详情
     * @param conversationId
     * @return
     */
    @Override
    public List<LMessage> selectMessageByConversationIdList(String conversationId) {
        return lMessageMapper.selectMessageByConversationIdList(conversationId);
    }

    /**
     * 查看当前用户全部未读消息记录
     * @param userId
     * @return
     */
    @Override
    public Integer totalUnreadMessage(String userId) {
        return lMessageMapper.totalUnreadMessage(userId);
    }

    /**
     *  改变消息状态
     * @param userId 用户id
     * @param status 消息状态
     * @param conversationId 会话ID
     * @return
     */
    @Override
    public int updateMeesageStatus(String userId, String status, String conversationId) {
        return lMessageMapper.updateMeesageStatus(userId, status, conversationId);
    }
}
