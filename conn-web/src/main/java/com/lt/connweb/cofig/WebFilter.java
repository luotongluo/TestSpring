package com.lt.connweb.cofig;

import com.lt.connweb.enums.ResultCode;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author tong.luo
 * @description webFilter
 * 鉴权可以使用继承过滤器实现ZuulFilter进行实现
 * @date 2021/1/4 10:15
 */
@Component
public class WebFilter extends ZuulFilter {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 过滤器类型
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行顺序 数字越小，优先级越高
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断是否需要过滤
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return false;
    }

    /**
     * 过滤器拦截规则
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
//        String token = request.getHeader(JwtConstants.AUTH_HEADER);
        String token = "request.getHeader(JwtConstants.AUTH_HEADER)";
        String servletPath = request.getServletPath();
        //文档肯定是要放行的，其它需要放行的接口可以写在此处
        if (servletPath.contains("v2/api-docs") || servletPath.contains("user/admin/oauth")) {
            return null;
        }
        //token认证
        Object o = redisTemplate.opsForValue().get("token::cache:[" + token + "]");

        if (Objects.isNull(o) || !o.toString().startsWith("\"Bearer ")) {
            throw new ZuulException("非法请求", ResultCode.NO_PERMISSION.getCode(), "请先登录");
        }
        return null;
    }
}
