package com.gcc.service.impl;

import com.gcc.entity.TbDept;
import com.gcc.mapper.TbDeptDao;
import com.gcc.service.TbDeptService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (TbDept)表服务实现类
 *
 * @author makejava
 * @since 2023-01-19 18:00:33
 */
@Service("tbDeptService")
public class TbDeptServiceImpl implements TbDeptService {
    @Resource
    private TbDeptDao tbDeptDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbDept queryById(Integer id) {
        return this.tbDeptDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tbDept 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbDept> queryByPage(TbDept tbDept, PageRequest pageRequest) {
        long total = this.tbDeptDao.count(tbDept);
        return new PageImpl<>(this.tbDeptDao.queryAllByLimit(tbDept, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbDept 实例对象
     * @return 实例对象
     */
    @Override
    public TbDept insert(TbDept tbDept) {
        this.tbDeptDao.insert(tbDept);
        return tbDept;
    }

    /**
     * 修改数据
     *
     * @param tbDept 实例对象
     * @return 实例对象
     */
    @Override
    public TbDept update(TbDept tbDept) {
        this.tbDeptDao.update(tbDept);
        return this.queryById(tbDept.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tbDeptDao.deleteById(id) > 0;
    }
}
