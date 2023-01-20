package com.gcc.service.impl;

import com.gcc.entity.TbMeeting;
import com.gcc.mapper.TbMeetingDao;
import com.gcc.service.TbMeetingService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 会议表(TbMeeting)表服务实现类
 *
 * @author makejava
 * @since 2023-01-19 18:00:33
 */
@Service("tbMeetingService")
public class TbMeetingServiceImpl implements TbMeetingService {
    @Resource
    private TbMeetingDao tbMeetingDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbMeeting queryById(Object id) {
        return this.tbMeetingDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tbMeeting 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbMeeting> queryByPage(TbMeeting tbMeeting, PageRequest pageRequest) {
        long total = this.tbMeetingDao.count(tbMeeting);
        return new PageImpl<>(this.tbMeetingDao.queryAllByLimit(tbMeeting, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbMeeting 实例对象
     * @return 实例对象
     */
    @Override
    public TbMeeting insert(TbMeeting tbMeeting) {
        this.tbMeetingDao.insert(tbMeeting);
        return tbMeeting;
    }

    /**
     * 修改数据
     *
     * @param tbMeeting 实例对象
     * @return 实例对象
     */
    @Override
    public TbMeeting update(TbMeeting tbMeeting) {
        this.tbMeetingDao.update(tbMeeting);
        return this.queryById(tbMeeting.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Object id) {
        return this.tbMeetingDao.deleteById(id) > 0;
    }
}
