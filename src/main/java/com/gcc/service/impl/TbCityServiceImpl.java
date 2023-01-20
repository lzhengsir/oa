package com.gcc.service.impl;

import com.gcc.entity.TbCity;
import com.gcc.mapper.TbCityDao;
import com.gcc.service.TbCityService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 疫情城市列表(TbCity)表服务实现类
 *
 * @author makejava
 * @since 2023-01-19 18:00:33
 */
@Service("tbCityService")
public class TbCityServiceImpl implements TbCityService {
    @Resource
    private TbCityDao tbCityDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbCity queryById(Integer id) {
        return this.tbCityDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tbCity 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbCity> queryByPage(TbCity tbCity, PageRequest pageRequest) {
        long total = this.tbCityDao.count(tbCity);
        return new PageImpl<>(this.tbCityDao.queryAllByLimit(tbCity, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbCity 实例对象
     * @return 实例对象
     */
    @Override
    public TbCity insert(TbCity tbCity) {
        this.tbCityDao.insert(tbCity);
        return tbCity;
    }

    /**
     * 修改数据
     *
     * @param tbCity 实例对象
     * @return 实例对象
     */
    @Override
    public TbCity update(TbCity tbCity) {
        this.tbCityDao.update(tbCity);
        return this.queryById(tbCity.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tbCityDao.deleteById(id) > 0;
    }
}
