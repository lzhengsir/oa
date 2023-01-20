package com.gcc.service;

import com.gcc.entity.TbFaceModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (TbFaceModel)表服务接口
 *
 * @author makejava
 * @since 2023-01-19 18:00:33
 */
public interface TbFaceModelService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbFaceModel queryById(Integer id);

    /**
     * 分页查询
     *
     * @param tbFaceModel 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TbFaceModel> queryByPage(TbFaceModel tbFaceModel, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbFaceModel 实例对象
     * @return 实例对象
     */
    TbFaceModel insert(TbFaceModel tbFaceModel);

    /**
     * 修改数据
     *
     * @param tbFaceModel 实例对象
     * @return 实例对象
     */
    TbFaceModel update(TbFaceModel tbFaceModel);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
