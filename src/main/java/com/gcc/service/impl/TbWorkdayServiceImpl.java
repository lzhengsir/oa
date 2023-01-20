package com.gcc.service.impl;

import com.gcc.entity.TbWorkday;
import com.gcc.mapper.TbWorkdayDao;
import com.gcc.service.TbWorkdayService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (TbWorkday)表服务实现类
 *
 * @author makejava
 * @since 2023-01-19 18:00:34
 */
@Service("tbWorkdayService")
public class TbWorkdayServiceImpl implements TbWorkdayService {
    @Resource
    private TbWorkdayDao tbWorkdayDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbWorkday queryById(Integer id) {
        return this.tbWorkdayDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tbWorkday 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbWorkday> queryByPage(TbWorkday tbWorkday, PageRequest pageRequest) {
        long total = this.tbWorkdayDao.count(tbWorkday);
        return new PageImpl<>(this.tbWorkdayDao.queryAllByLimit(tbWorkday, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbWorkday 实例对象
     * @return 实例对象
     */
    @Override
    public TbWorkday insert(TbWorkday tbWorkday) {
        this.tbWorkdayDao.insert(tbWorkday);
        return tbWorkday;
    }

    /**
     * 修改数据
     *
     * @param tbWorkday 实例对象
     * @return 实例对象
     */
    @Override
    public TbWorkday update(TbWorkday tbWorkday) {
        this.tbWorkdayDao.update(tbWorkday);
        return this.queryById(tbWorkday.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tbWorkdayDao.deleteById(id) > 0;
    }
}
