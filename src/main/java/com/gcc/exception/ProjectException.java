package com.gcc.exception;

import cn.hutool.http.HttpStatus;
import com.gcc.common.ExceptionEnum;

/**
 * @author: lzhen
 * @since: 2022/11/1 17:37
 * @description: 自定义异常
 */
public class ProjectException extends RuntimeException {
    /**
     * 状态码
     */
    private final Integer code;
    /**
     * 信息
     */
    private final String msg;

    public ProjectException(ExceptionEnum exceptionEnum) {
        this.code = exceptionEnum.getCode();
        this.msg = exceptionEnum.getMsg();
    }

    public ProjectException(String msg) {
        this.code = HttpStatus.HTTP_INTERNAL_ERROR;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
