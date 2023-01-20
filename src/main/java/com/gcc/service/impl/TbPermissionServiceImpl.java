package com.gcc.service.impl;

import com.gcc.entity.TbPermission;
import com.gcc.mapper.TbPermissionDao;
import com.gcc.service.TbPermissionService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (TbPermission)表服务实现类
 *
 * @author makejava
 * @since 2023-01-19 18:00:34
 */
@Service("tbPermissionService")
public class TbPermissionServiceImpl implements TbPermissionService {
    @Resource
    private TbPermissionDao tbPermissionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbPermission queryById(Integer id) {
        return this.tbPermissionDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tbPermission 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbPermission> queryByPage(TbPermission tbPermission, PageRequest pageRequest) {
        long total = this.tbPermissionDao.count(tbPermission);
        return new PageImpl<>(this.tbPermissionDao.queryAllByLimit(tbPermission, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbPermission 实例对象
     * @return 实例对象
     */
    @Override
    public TbPermission insert(TbPermission tbPermission) {
        this.tbPermissionDao.insert(tbPermission);
        return tbPermission;
    }

    /**
     * 修改数据
     *
     * @param tbPermission 实例对象
     * @return 实例对象
     */
    @Override
    public TbPermission update(TbPermission tbPermission) {
        this.tbPermissionDao.update(tbPermission);
        return this.queryById(tbPermission.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tbPermissionDao.deleteById(id) > 0;
    }
}
