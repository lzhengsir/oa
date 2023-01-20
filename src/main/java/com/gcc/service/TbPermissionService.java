package com.gcc.service;

import com.gcc.entity.TbPermission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (TbPermission)表服务接口
 *
 * @author makejava
 * @since 2023-01-19 18:00:34
 */
public interface TbPermissionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbPermission queryById(Integer id);

    /**
     * 分页查询
     *
     * @param tbPermission 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TbPermission> queryByPage(TbPermission tbPermission, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbPermission 实例对象
     * @return 实例对象
     */
    TbPermission insert(TbPermission tbPermission);

    /**
     * 修改数据
     *
     * @param tbPermission 实例对象
     * @return 实例对象
     */
    TbPermission update(TbPermission tbPermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
