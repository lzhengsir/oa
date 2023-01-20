package com.gcc.service;

import com.gcc.entity.SysConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (SysConfig)表服务接口
 *
 * @author makejava
 * @since 2023-01-19 18:00:32
 */
public interface SysConfigService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysConfig queryById(Integer id);

    /**
     * 分页查询
     *
     * @param sysConfig 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<SysConfig> queryByPage(SysConfig sysConfig, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param sysConfig 实例对象
     * @return 实例对象
     */
    SysConfig insert(SysConfig sysConfig);

    /**
     * 修改数据
     *
     * @param sysConfig 实例对象
     * @return 实例对象
     */
    SysConfig update(SysConfig sysConfig);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
