package com.gcc.service.impl;

import com.gcc.entity.TbCheckin;
import com.gcc.mapper.TbCheckinDao;
import com.gcc.service.TbCheckinService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 签到表(TbCheckin)表服务实现类
 *
 * @author makejava
 * @since 2023-01-19 18:00:33
 */
@Service("tbCheckinService")
public class TbCheckinServiceImpl implements TbCheckinService {
    @Resource
    private TbCheckinDao tbCheckinDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbCheckin queryById(Integer id) {
        return this.tbCheckinDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tbCheckin 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbCheckin> queryByPage(TbCheckin tbCheckin, PageRequest pageRequest) {
        long total = this.tbCheckinDao.count(tbCheckin);
        return new PageImpl<>(this.tbCheckinDao.queryAllByLimit(tbCheckin, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbCheckin 实例对象
     * @return 实例对象
     */
    @Override
    public TbCheckin insert(TbCheckin tbCheckin) {
        this.tbCheckinDao.insert(tbCheckin);
        return tbCheckin;
    }

    /**
     * 修改数据
     *
     * @param tbCheckin 实例对象
     * @return 实例对象
     */
    @Override
    public TbCheckin update(TbCheckin tbCheckin) {
        this.tbCheckinDao.update(tbCheckin);
        return this.queryById(tbCheckin.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tbCheckinDao.deleteById(id) > 0;
    }
}
