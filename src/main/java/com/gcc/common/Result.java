package com.gcc.common;

import cn.hutool.http.HttpStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @className: Result
 * @author: lzheng
 * @date: 2022/8/6 17:18
 * @description:
 */
@NoArgsConstructor
@ToString
@Data
public class Result implements Serializable {
    private static final long serialVersionUID = -7349865073557573353L;
    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 令牌
     */
    private String token;

    /**
     * 返回数据
     */
    private Map<String, Object> data = new HashMap<>();


    public static Result ok() {
        Result r = new Result();
        r.code = HttpStatus.HTTP_OK;
        r.message = "成功";
        return r;
    }

    public static Result error() {
        Result r = new Result();
        r.code = HttpStatus.HTTP_INTERNAL_ERROR;
        r.message = "失败";
        return r;
    }

    public Result message(String message) {
        this.message = message;
        return this;
    }

    public Result code(Integer code) {
        this.code = code;
        return this;
    }

    public Result token(String token) {
        this.token = token;
        return this;
    }

    public Result data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public Result data(Map<String, Object> map) {
        this.data = map;
        return this;
    }
}
