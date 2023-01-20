package com.gcc.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 节假日表(TbHolidays)实体类
 *
 * @author makejava
 * @since 2023-01-19 18:00:33
 */
public class TbHolidays implements Serializable {
    private static final long serialVersionUID = 689352664369368917L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 日期
     */
    private Date date;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}

