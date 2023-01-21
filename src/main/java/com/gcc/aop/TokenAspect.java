package com.gcc.aop;

import com.gcc.common.Result;
import com.gcc.config.shiro.ThreadLocalTokenHolder;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @author: lzhen
 * @since: 2023/1/21 22:43
 * @description: 用于刷新令牌
 */
@Component
@Aspect
public class TokenAspect {
    @Resource
    private ThreadLocalTokenHolder tokenHolder;

    @Pointcut("execution(public * com.gcc.controller.*.*(..))")
    private void pointcut() {
    }

    @AfterReturning(value = "pointcut()", returning = "object")
    public void aspect(Object object) {
        if (object instanceof Result) {
            Result result = (Result) object;
            //检查ThreadLocal中是否有token
            String token = tokenHolder.getToken();
            if (!StringUtils.isEmpty(token)) {
                result.token(token);
                tokenHolder.clear();
            }
        }
    }
}
