package com.gcc.mapper;

import com.gcc.entity.TbAction;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 行为表(TbAction)表数据库访问层
 *
 * @author makejava
 * @since 2023-01-19 18:00:33
 */
public interface TbActionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbAction queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param tbAction 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TbAction> queryAllByLimit(TbAction tbAction, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tbAction 查询条件
     * @return 总行数
     */
    long count(TbAction tbAction);

    /**
     * 新增数据
     *
     * @param tbAction 实例对象
     * @return 影响行数
     */
    int insert(TbAction tbAction);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbAction> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbAction> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbAction> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TbAction> entities);

    /**
     * 修改数据
     *
     * @param tbAction 实例对象
     * @return 影响行数
     */
    int update(TbAction tbAction);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

