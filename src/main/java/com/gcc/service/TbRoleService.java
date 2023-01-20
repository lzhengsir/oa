package com.gcc.service;

import com.gcc.entity.TbRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 角色表(TbRole)表服务接口
 *
 * @author makejava
 * @since 2023-01-19 18:00:34
 */
public interface TbRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbRole queryById(Integer id);

    /**
     * 分页查询
     *
     * @param tbRole 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TbRole> queryByPage(TbRole tbRole, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbRole 实例对象
     * @return 实例对象
     */
    TbRole insert(TbRole tbRole);

    /**
     * 修改数据
     *
     * @param tbRole 实例对象
     * @return 实例对象
     */
    TbRole update(TbRole tbRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
