package com.gcc.service.impl;

import com.gcc.entity.SysConfig;
import com.gcc.mapper.SysConfigDao;
import com.gcc.service.SysConfigService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (SysConfig)表服务实现类
 *
 * @author makejava
 * @since 2023-01-19 18:00:32
 */
@Service("sysConfigService")
public class SysConfigServiceImpl implements SysConfigService {
    @Resource
    private SysConfigDao sysConfigDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysConfig queryById(Integer id) {
        return this.sysConfigDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param sysConfig 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<SysConfig> queryByPage(SysConfig sysConfig, PageRequest pageRequest) {
        long total = this.sysConfigDao.count(sysConfig);
        return new PageImpl<>(this.sysConfigDao.queryAllByLimit(sysConfig, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param sysConfig 实例对象
     * @return 实例对象
     */
    @Override
    public SysConfig insert(SysConfig sysConfig) {
        this.sysConfigDao.insert(sysConfig);
        return sysConfig;
    }

    /**
     * 修改数据
     *
     * @param sysConfig 实例对象
     * @return 实例对象
     */
    @Override
    public SysConfig update(SysConfig sysConfig) {
        this.sysConfigDao.update(sysConfig);
        return this.queryById(sysConfig.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.sysConfigDao.deleteById(id) > 0;
    }
}
