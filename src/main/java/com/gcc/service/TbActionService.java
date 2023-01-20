package com.gcc.service;

import com.gcc.entity.TbAction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 行为表(TbAction)表服务接口
 *
 * @author makejava
 * @since 2023-01-19 18:00:33
 */
public interface TbActionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbAction queryById(Integer id);

    /**
     * 分页查询
     *
     * @param tbAction 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TbAction> queryByPage(TbAction tbAction, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbAction 实例对象
     * @return 实例对象
     */
    TbAction insert(TbAction tbAction);

    /**
     * 修改数据
     *
     * @param tbAction 实例对象
     * @return 实例对象
     */
    TbAction update(TbAction tbAction);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
