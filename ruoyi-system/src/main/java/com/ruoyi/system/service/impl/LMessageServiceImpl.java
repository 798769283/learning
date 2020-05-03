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
}
