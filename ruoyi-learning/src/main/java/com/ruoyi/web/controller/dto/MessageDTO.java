package com.ruoyi.web.controller.dto;

import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.system.domain.LMessage;

import java.util.List;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.web.controller.dto
 * @ClassName: 消息DTO
 * @Author: 胡天霸
 * @Date: 2020/5/3 21:29
 * @Version: 1.0
 */
public class MessageDTO extends BaseEntity {

    private static final long serialVersionUID = 1L;


    /**
     *  消息列表 详情页用
     */
    private List<LMessage> messageList;

    /**
     *  用户信息
     * @return
     */
    private UserDTO userDTO;

    /**
     * 会话 id
     */
    private String conversationId;
    /**
     *  私信页用
     * @return
     */
    private LMessage lMessage;

    /**
     * 未读信息
     *
     */
    private int unreadSum;

    /**
     *
     *  当前会话所有消息总和
     */
    private int totalMessage;

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public int getTotalMessage() {
        return totalMessage;
    }

    public void setTotalMessage(int totalMessage) {
        this.totalMessage = totalMessage;
    }

    public int getUnreadSum() {
        return unreadSum;
    }

    public void setUnreadSum(int unreadSum) {
        this.unreadSum = unreadSum;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public LMessage getlMessage() {
        return lMessage;
    }

    public void setlMessage(LMessage lMessage) {
        this.lMessage = lMessage;
    }

    public List<LMessage> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<LMessage> messageList) {
        this.messageList = messageList;
    }

    @Override
    public String toString() {
        return "MessageDTO{" +
                "messageList=" + messageList +
                ", userDTO=" + userDTO +
                ", lMessage=" + lMessage +
                '}';
    }
}
