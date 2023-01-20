package com.gcc.service.impl;

import com.gcc.entity.TbAction;
import com.gcc.mapper.TbActionDao;
import com.gcc.service.TbActionService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 行为表(TbAction)表服务实现类
 *
 * @author makejava
 * @since 2023-01-19 18:00:33
 */
@Service("tbActionService")
public class TbActionServiceImpl implements TbActionService {
    @Resource
    private TbActionDao tbActionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbAction queryById(Integer id) {
        return this.tbActionDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tbAction 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbAction> queryByPage(TbAction tbAction, PageRequest pageRequest) {
        long total = this.tbActionDao.count(tbAction);
        return new PageImpl<>(this.tbActionDao.queryAllByLimit(tbAction, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tbAction 实例对象
     * @return 实例对象
     */
    @Override
    public TbAction insert(TbAction tbAction) {
        this.tbActionDao.insert(tbAction);
        return tbAction;
    }

    /**
     * 修改数据
     *
     * @param tbAction 实例对象
     * @return 实例对象
     */
    @Override
    public TbAction update(TbAction tbAction) {
        this.tbActionDao.update(tbAction);
        return this.queryById(tbAction.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tbActionDao.deleteById(id) > 0;
    }
}
