package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.LAnnouncement;

/**
 * 公告Mapper接口
 * 
 * @author HuTianba
 * @date 2020-04-28
 */
public interface LAnnouncementMapper 
{
    /**
     * 查询公告
     * 
     * @param id 公告ID
     * @return 公告
     */
    public LAnnouncement selectLAnnouncementById(Long id);

    /**
     * 查询公告列表
     * 
     * @param lAnnouncement 公告
     * @return 公告集合
     */
    public List<LAnnouncement> selectLAnnouncementList(LAnnouncement lAnnouncement);

    /**
     * 新增公告
     * 
     * @param lAnnouncement 公告
     * @return 结果
     */
    public int insertLAnnouncement(LAnnouncement lAnnouncement);

    /**
     * 修改公告
     * 
     * @param lAnnouncement 公告
     * @return 结果
     */
    public int updateLAnnouncement(LAnnouncement lAnnouncement);

    /**
     * 删除公告
     * 
     * @param id 公告ID
     * @return 结果
     */
    public int deleteLAnnouncementById(Long id);

    /**
     * 批量删除公告
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLAnnouncementByIds(String[] ids);
}
