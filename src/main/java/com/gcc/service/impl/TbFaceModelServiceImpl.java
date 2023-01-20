package com.gcc.service.impl;

import com.gcc.entity.TbFaceModel;
import com.gcc.mapper.TbFaceModelDao;
import com.gcc.service.TbFaceModelService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (TbFaceModel)表服务实现类
 *
 * @author makejava
 * @since 2023-01-19 18:00:33
 */
@Service("tbFaceModelService")
public class TbFaceModelServiceImpl implements TbFaceModelService {
    @Resource
    private TbFaceModelDao tbFaceModelDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbFaceModel queryById(Integer id) {
        return this.tbFaceModelDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tbFaceModel 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbFaceModel> queryByPage(TbFaceModel tbFaceModel, PageRequest pageRequest) {
        long total = this.tbFaceModelDao.count(tbFaceModel);
        return new PageImpl<>(this.tbFaceModelDao.queryAllByLimit(tbFaceModel, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbFaceModel 实例对象
     * @return 实例对象
     */
    @Override
    public TbFaceModel insert(TbFaceModel tbFaceModel) {
        this.tbFaceModelDao.insert(tbFaceModel);
        return tbFaceModel;
    }

    /**
     * 修改数据
     *
     * @param tbFaceModel 实例对象
     * @return 实例对象
     */
    @Override
    public TbFaceModel update(TbFaceModel tbFaceModel) {
        this.tbFaceModelDao.update(tbFaceModel);
        return this.queryById(tbFaceModel.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tbFaceModelDao.deleteById(id) > 0;
    }
}
