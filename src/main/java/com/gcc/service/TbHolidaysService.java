package com.gcc.service;

import com.gcc.entity.TbHolidays;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 节假日表(TbHolidays)表服务接口
 *
 * @author makejava
 * @since 2023-01-19 18:00:33
 */
public interface TbHolidaysService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbHolidays queryById(Integer id);

    /**
     * 分页查询
     *
     * @param tbHolidays 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TbHolidays> queryByPage(TbHolidays tbHolidays, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbHolidays 实例对象
     * @return 实例对象
     */
    TbHolidays insert(TbHolidays tbHolidays);

    /**
     * 修改数据
     *
     * @param tbHolidays 实例对象
     * @return 实例对象
     */
    TbHolidays update(TbHolidays tbHolidays);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
