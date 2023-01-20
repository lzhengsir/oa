package com.gcc.common;

import cn.hutool.http.HttpStatus;

/**
 * @author: lzhen
 * @since: 2022/11/1 17:39
 * @description:
 */
public enum ExceptionEnum {
    /**
     * 枚举异常信息
     */
    DATA_DATE_IS_NULL(HttpStatus.HTTP_INTERNAL_ERROR, "数据日期为空"),
    STRING_CONVERTER_FOR_OBJECT_FAILED(HttpStatus.HTTP_INTERNAL_ERROR, "字符串转换为对象失败"),
    MAGIC_VALUE_DATE_IS_NULL(HttpStatus.HTTP_INTERNAL_ERROR, "魔法值的标题为空"),
    HEADER_FORMAT_ERROR(HttpStatus.HTTP_INTERNAL_ERROR, "表头格式不正确"),
    WRITE_AS_JSON_STRING_FAILED(HttpStatus.HTTP_INTERNAL_ERROR, "转换为JSONString失败"),
    PLEASE_UPLOAD_EXCEL(HttpStatus.HTTP_INTERNAL_ERROR, "请上传excel文件"),
    SHORT_MESSAGE_ALREADY_EXIST(HttpStatus.HTTP_INTERNAL_ERROR, "短信验证码已存在"),
    INCLUSIVE_CITY_BANK_IMPORT_DATA_ERROR(HttpStatus.HTTP_INTERNAL_ERROR, "各市行普惠小微企业贷款业务情况表表数据导入失败"),
    INCLUSIVE_SAME_CITY_IMPORT_DATA_ERROR(HttpStatus.HTTP_INTERNAL_ERROR, "广州同城支行惠小为企业贷款业务情况表数据导入失败"),
    REMARKS_IMPORT_DATA_ERROR(HttpStatus.HTTP_INTERNAL_ERROR, "备注表数据导入失败"),
    UPLOAD_FAILED(HttpStatus.HTTP_INTERNAL_ERROR, "上传失败"),
    VERIFY_CODE_ERROR(HttpStatus.HTTP_INTERNAL_ERROR, "验证码错误"),
    ILLEGAL_OPERATION(HttpStatus.HTTP_INTERNAL_ERROR, "非法操作"),
    TWICE_PWD_NOT_SAME(HttpStatus.HTTP_INTERNAL_ERROR, "两次密码不一致"),
    USERNAME_OR_PWD_ERROR(HttpStatus.HTTP_INTERNAL_ERROR, "用户名密码错误");
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String msg;

    ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
