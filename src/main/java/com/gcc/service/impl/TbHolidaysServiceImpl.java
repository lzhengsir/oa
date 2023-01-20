package com.gcc.service.impl;

import com.gcc.entity.TbHolidays;
import com.gcc.mapper.TbHolidaysDao;
import com.gcc.service.TbHolidaysService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 节假日表(TbHolidays)表服务实现类
 *
 * @author makejava
 * @since 2023-01-19 18:00:33
 */
@Service("tbHolidaysService")
public class TbHolidaysServiceImpl implements TbHolidaysService {
    @Resource
    private TbHolidaysDao tbHolidaysDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbHolidays queryById(Integer id) {
        return this.tbHolidaysDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tbHolidays 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbHolidays> queryByPage(TbHolidays tbHolidays, PageRequest pageRequest) {
        long total = this.tbHolidaysDao.count(tbHolidays);
        return new PageImpl<>(this.tbHolidaysDao.queryAllByLimit(tbHolidays, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbHolidays 实例对象
     * @return 实例对象
     */
    @Override
    public TbHolidays insert(TbHolidays tbHolidays) {
        this.tbHolidaysDao.insert(tbHolidays);
        return tbHolidays;
    }

    /**
     * 修改数据
     *
     * @param tbHolidays 实例对象
     * @return 实例对象
     */
    @Override
    public TbHolidays update(TbHolidays tbHolidays) {
        this.tbHolidaysDao.update(tbHolidays);
        return this.queryById(tbHolidays.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tbHolidaysDao.deleteById(id) > 0;
    }
}
