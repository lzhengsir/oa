package com.gcc.entity;

import java.io.Serializable;

/**
 * 行为表(TbAction)实体类
 *
 * @author makejava
 * @since 2023-01-19 18:00:33
 */
public class TbAction implements Serializable {
    private static final long serialVersionUID = 600527471394370755L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 行为编号
     */
    private String actionCode;
    /**
     * 行为名称
     */
    private String actionName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

}

