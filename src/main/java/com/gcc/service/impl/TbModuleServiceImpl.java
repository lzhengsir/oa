package com.gcc.service.impl;

import com.gcc.entity.TbModule;
import com.gcc.mapper.TbModuleDao;
import com.gcc.service.TbModuleService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 模块资源表(TbModule)表服务实现类
 *
 * @author makejava
 * @since 2023-01-19 18:00:33
 */
@Service("tbModuleService")
public class TbModuleServiceImpl implements TbModuleService {
    @Resource
    private TbModuleDao tbModuleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbModule queryById(Integer id) {
        return this.tbModuleDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tbModule 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbModule> queryByPage(TbModule tbModule, PageRequest pageRequest) {
        long total = this.tbModuleDao.count(tbModule);
        return new PageImpl<>(this.tbModuleDao.queryAllByLimit(tbModule, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbModule 实例对象
     * @return 实例对象
     */
    @Override
    public TbModule insert(TbModule tbModule) {
        this.tbModuleDao.insert(tbModule);
        return tbModule;
    }

    /**
     * 修改数据
     *
     * @param tbModule 实例对象
     * @return 实例对象
     */
    @Override
    public TbModule update(TbModule tbModule) {
        this.tbModuleDao.update(tbModule);
        return this.queryById(tbModule.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tbModuleDao.deleteById(id) > 0;
    }
}
