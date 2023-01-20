package com.gcc.mapper;

import com.gcc.entity.TbHolidays;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 节假日表(TbHolidays)表数据库访问层
 *
 * @author makejava
 * @since 2023-01-19 18:00:33
 */
public interface TbHolidaysDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbHolidays queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param tbHolidays 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TbHolidays> queryAllByLimit(TbHolidays tbHolidays, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tbHolidays 查询条件
     * @return 总行数
     */
    long count(TbHolidays tbHolidays);

    /**
     * 新增数据
     *
     * @param tbHolidays 实例对象
     * @return 影响行数
     */
    int insert(TbHolidays tbHolidays);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbHolidays> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbHolidays> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbHolidays> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TbHolidays> entities);

    /**
     * 修改数据
     *
     * @param tbHolidays 实例对象
     * @return 影响行数
     */
    int update(TbHolidays tbHolidays);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

