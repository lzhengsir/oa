package com.gcc.service.impl;

import com.gcc.entity.TbRole;
import com.gcc.mapper.TbRoleDao;
import com.gcc.service.TbRoleService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 角色表(TbRole)表服务实现类
 *
 * @author makejava
 * @since 2023-01-19 18:00:34
 */
@Service("tbRoleService")
public class TbRoleServiceImpl implements TbRoleService {
    @Resource
    private TbRoleDao tbRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbRole queryById(Integer id) {
        return this.tbRoleDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tbRole 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbRole> queryByPage(TbRole tbRole, PageRequest pageRequest) {
        long total = this.tbRoleDao.count(tbRole);
        return new PageImpl<>(this.tbRoleDao.queryAllByLimit(tbRole, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbRole 实例对象
     * @return 实例对象
     */
    @Override
    public TbRole insert(TbRole tbRole) {
        this.tbRoleDao.insert(tbRole);
        return tbRole;
    }

    /**
     * 修改数据
     *
     * @param tbRole 实例对象
     * @return 实例对象
     */
    @Override
    public TbRole update(TbRole tbRole) {
        this.tbRoleDao.update(tbRole);
        return this.queryById(tbRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tbRoleDao.deleteById(id) > 0;
    }
}
