package com.gcc.mapper;

import com.gcc.entity.TbCheckin;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 签到表(TbCheckin)表数据库访问层
 *
 * @author makejava
 * @since 2023-01-19 18:00:33
 */
public interface TbCheckinDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbCheckin queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param tbCheckin 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TbCheckin> queryAllByLimit(TbCheckin tbCheckin, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tbCheckin 查询条件
     * @return 总行数
     */
    long count(TbCheckin tbCheckin);

    /**
     * 新增数据
     *
     * @param tbCheckin 实例对象
     * @return 影响行数
     */
    int insert(TbCheckin tbCheckin);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbCheckin> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbCheckin> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbCheckin> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TbCheckin> entities);

    /**
     * 修改数据
     *
     * @param tbCheckin 实例对象
     * @return 影响行数
     */
    int update(TbCheckin tbCheckin);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

