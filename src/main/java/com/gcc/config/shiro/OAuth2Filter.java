package com.gcc.config.shiro;

import cn.hutool.http.HttpStatus;
import com.auth0.jwt.exceptions.TokenExpiredException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author: lzhen
 * @since: 2023/1/21 15:51
 * @description: @Scope("prototype")是为了防止ThreadLocal存放数据异常
 */
@Component
@Scope("prototype")
public class OAuth2Filter extends AuthenticatingFilter {

    @Resource
    private ThreadLocalTokenHolder tokenHolder;
    @Resource
    private JwtUtils jwtUtils;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    @Value("${lzhengsir.jwt.cache-expire}")
    private Integer cacheExpire;


    /**
     * 获取token
     *
     * @param servletRequest
     * @param servletResponse
     * @return
     * @throws Exception
     */
    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getHeader("token");
        return StringUtils.isEmpty(token) ? null : new OAuth2Token(token);
    }

    /**
     * 是否允许访问后端接口，true允许访问则不走shiro，false拒绝访问则走shiro的认证与授权
     *
     * @param request
     * @param response
     * @param mappedValue
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        //如果是options请求，则不拦截
        HttpServletRequest req = (HttpServletRequest) request;
        return req.getMethod().equals(RequestMethod.OPTIONS.name());
    }

    /**
     * isAccessAllowed返回false则被调用
     *
     * @param servletRequest
     * @param servletResponse
     * @return true代表shiro放行，false代表shiro拦截了这次请求，将无法访问
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        //允许跨域
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setHeader("Access-Control-Allow-Origin", req.getHeader("Origin"));
        //被shiro拦截住了之后，需要检验请求是否带有token，并且校验token是否过期
        tokenHolder.clear();
        //获取token
        String token = req.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            resp.setStatus(HttpStatus.HTTP_UNAUTHORIZED);
            resp.getWriter().print("请先认证");
            return false;
        }
        //如果持有token，则校验token是否过期
        try {
            jwtUtils.verifierToken(token);
        } catch (TokenExpiredException e) {
            //如果token过期，则校验redis中的token是否过期
            if (Boolean.TRUE.equals(redisTemplate.hasKey(token))) {
                redisTemplate.delete(token);
                //获取用户id
                int userId = jwtUtils.getUserId(token);
                token = jwtUtils.createToken(userId);
                redisTemplate.boundValueOps(token).set(userId, cacheExpire, TimeUnit.DAYS);
                tokenHolder.setToken(token);
            } else {
                //需要重新登录
                resp.setStatus(HttpStatus.HTTP_UNAUTHORIZED);
                resp.getWriter().print("请先认证");
                return false;
            }
        } catch (Exception e) {
            //令牌识别错误
            resp.setStatus(HttpStatus.HTTP_UNAUTHORIZED);
            resp.getWriter().print("请先认证");
            return false;
        }
        //执行OAuth2Realm的授权和认证
        return executeLogin(servletRequest, servletResponse);
    }

    /**
     * executeLogin返回false时被调用
     *
     * @param token
     * @param e
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setHeader("Access-Control-Allow-Origin", req.getHeader("Origin"));
        resp.setStatus(HttpStatus.HTTP_UNAUTHORIZED);
        try {
            resp.getWriter().print(e.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
