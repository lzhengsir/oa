package com.gcc.entity;

import java.io.Serializable;

/**
 * 角色表(TbRole)实体类
 *
 * @author makejava
 * @since 2023-01-19 18:00:34
 */
public class TbRole implements Serializable {
    private static final long serialVersionUID = -34339824320942490L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 权限集合
     */
    private Object permissions;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Object getPermissions() {
        return permissions;
    }

    public void setPermissions(Object permissions) {
        this.permissions = permissions;
    }

}

