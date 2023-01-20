package com.gcc.entity;

import java.io.Serializable;

/**
 * (TbDept)实体类
 *
 * @author makejava
 * @since 2023-01-19 18:00:33
 */
public class TbDept implements Serializable {
    private static final long serialVersionUID = 723483706820839986L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 部门名称
     */
    private String deptName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

}

