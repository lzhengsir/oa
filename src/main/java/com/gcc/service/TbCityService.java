package com.gcc.service;

import com.gcc.entity.TbCity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 疫情城市列表(TbCity)表服务接口
 *
 * @author makejava
 * @since 2023-01-19 18:00:33
 */
public interface TbCityService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbCity queryById(Integer id);

    /**
     * 分页查询
     *
     * @param tbCity 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TbCity> queryByPage(TbCity tbCity, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbCity 实例对象
     * @return 实例对象
     */
    TbCity insert(TbCity tbCity);

    /**
     * 修改数据
     *
     * @param tbCity 实例对象
     * @return 实例对象
     */
    TbCity update(TbCity tbCity);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
