package com.gcc.config.shiro;

import lombok.AllArgsConstructor;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author: lzhen
 * @since: 2023/1/20 19:47
 * @description: shiro能识别的令牌对象
 */
@AllArgsConstructor
public class OAuth2Token implements AuthenticationToken {
    private String token;

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
