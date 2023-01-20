package com.gcc.service;

import com.gcc.entity.TbDept;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (TbDept)表服务接口
 *
 * @author makejava
 * @since 2023-01-19 18:00:33
 */
public interface TbDeptService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbDept queryById(Integer id);

    /**
     * 分页查询
     *
     * @param tbDept 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TbDept> queryByPage(TbDept tbDept, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbDept 实例对象
     * @return 实例对象
     */
    TbDept insert(TbDept tbDept);

    /**
     * 修改数据
     *
     * @param tbDept 实例对象
     * @return 实例对象
     */
    TbDept update(TbDept tbDept);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
