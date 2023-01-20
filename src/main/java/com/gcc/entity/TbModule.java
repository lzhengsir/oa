package com.gcc.entity;

import java.io.Serializable;

/**
 * 模块资源表(TbModule)实体类
 *
 * @author makejava
 * @since 2023-01-19 18:00:33
 */
public class TbModule implements Serializable {
    private static final long serialVersionUID = -32342551958842418L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 模块编号
     */
    private String moduleCode;
    /**
     * 模块名称
     */
    private String moduleName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

}

