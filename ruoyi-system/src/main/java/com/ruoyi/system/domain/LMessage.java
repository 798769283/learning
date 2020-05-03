package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 会话对象 l_message
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
public class LMessage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 发送人的Id */
    @Excel(name = "发送人的Id")
    private String fromId;

    /** 接收人的Id */
    @Excel(name = "接收人的Id")
    private String toId;

    /** 会话iD */
    @Excel(name = "会话iD")
    private String conversationId;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 0-未读;1-已读;2-删除 */
    @Excel(name = "0-未读;1-已读;2-删除")
    private Long status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setFromId(String fromId) 
    {
        this.fromId = fromId;
    }

    public String getFromId() 
    {
        return fromId;
    }
    public void setToId(String toId) 
    {
        this.toId = toId;
    }

    public String getToId() 
    {
        return toId;
    }
    public void setConversationId(String conversationId) 
    {
        this.conversationId = conversationId;
    }

    public String getConversationId() 
    {
        return conversationId;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("fromId", getFromId())
            .append("toId", getToId())
            .append("conversationId", getConversationId())
            .append("content", getContent())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .toString();
    }
}
