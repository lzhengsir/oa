package com.gcc.config.shiro;

import org.springframework.stereotype.Component;

/**
 * @author: lzhen
 * @since: 2023/1/20 23:28
 * @description: 保存令牌，用于校验是否需要刷新
 */
@Component
public class ThreadLocalTokenHolder {
    private final ThreadLocal<String> TOKEN = new ThreadLocal<>();

    public void setToken(String token) {
        TOKEN.set(token);
    }

    public String getToken() {
        return TOKEN.get();
    }

    public void clear() {
        TOKEN.remove();
    }
}
