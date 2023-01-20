package com.gcc.service;

import com.gcc.entity.TbCheckin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 签到表(TbCheckin)表服务接口
 *
 * @author makejava
 * @since 2023-01-19 18:00:33
 */
public interface TbCheckinService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbCheckin queryById(Integer id);

    /**
     * 分页查询
     *
     * @param tbCheckin 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TbCheckin> queryByPage(TbCheckin tbCheckin, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbCheckin 实例对象
     * @return 实例对象
     */
    TbCheckin insert(TbCheckin tbCheckin);

    /**
     * 修改数据
     *
     * @param tbCheckin 实例对象
     * @return 实例对象
     */
    TbCheckin update(TbCheckin tbCheckin);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
