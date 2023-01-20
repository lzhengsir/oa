package com.gcc.service;

import com.gcc.entity.TbWorkday;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (TbWorkday)表服务接口
 *
 * @author makejava
 * @since 2023-01-19 18:00:34
 */
public interface TbWorkdayService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbWorkday queryById(Integer id);

    /**
     * 分页查询
     *
     * @param tbWorkday 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TbWorkday> queryByPage(TbWorkday tbWorkday, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbWorkday 实例对象
     * @return 实例对象
     */
    TbWorkday insert(TbWorkday tbWorkday);

    /**
     * 修改数据
     *
     * @param tbWorkday 实例对象
     * @return 实例对象
     */
    TbWorkday update(TbWorkday tbWorkday);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
