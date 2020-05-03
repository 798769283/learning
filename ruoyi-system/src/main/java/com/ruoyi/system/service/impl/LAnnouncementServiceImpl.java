package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.LAnnouncementMapper;
import com.ruoyi.system.domain.LAnnouncement;
import com.ruoyi.system.service.ILAnnouncementService;
import com.ruoyi.common.core.text.Convert;

/**
 * 公告Service业务层处理
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
@Service
public class LAnnouncementServiceImpl implements ILAnnouncementService 
{
    @Autowired
    private LAnnouncementMapper lAnnouncementMapper;

    /**
     * 查询公告
     * 
     * @param id 公告ID
     * @return 公告
     */
    @Override
    public LAnnouncement selectLAnnouncementById(Long id)
    {
        return lAnnouncementMapper.selectLAnnouncementById(id);
    }

    /**
     * 查询公告列表
     * 
     * @param lAnnouncement 公告
     * @return 公告
     */
    @Override
    public List<LAnnouncement> selectLAnnouncementList(LAnnouncement lAnnouncement)
    {
        return lAnnouncementMapper.selectLAnnouncementList(lAnnouncement);
    }

    /**
     * 新增公告
     * 
     * @param lAnnouncement 公告
     * @return 结果
     */
    @Override
    public int insertLAnnouncement(LAnnouncement lAnnouncement)
    {
        lAnnouncement.setCreateTime(DateUtils.getNowDate());
        return lAnnouncementMapper.insertLAnnouncement(lAnnouncement);
    }

    /**
     * 修改公告
     * 
     * @param lAnnouncement 公告
     * @return 结果
     */
    @Override
    public int updateLAnnouncement(LAnnouncement lAnnouncement)
    {
        return lAnnouncementMapper.updateLAnnouncement(lAnnouncement);
    }

    /**
     * 删除公告对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLAnnouncementByIds(String ids)
    {
        return lAnnouncementMapper.deleteLAnnouncementByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除公告信息
     * 
     * @param id 公告ID
     * @return 结果
     */
    @Override
    public int deleteLAnnouncementById(Long id)
    {
        return lAnnouncementMapper.deleteLAnnouncementById(id);
    }
}
