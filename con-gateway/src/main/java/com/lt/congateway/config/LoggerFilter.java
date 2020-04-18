package com.lt.congateway.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tong.luo
 * @description LoggerFilter
 * @date 2020/4/18 23:33
 */
@Component
public class LoggerFilter extends ZuulFilter {
    private static Logger logger = LoggerFactory.getLogger(LoggerFilter.class);

    /**
     * 过滤器的类型。可选值有：
     * pre - 前置过滤
     * route - 路由后过滤
     * error - 异常过滤
     * post - 远程服务调用后过滤
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 同种类的过滤器的执行顺序。
     * 按照返回值的自然升序执行。
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 返回boolean类型。代表当前filter是否生效。
     * 默认值为false。
     * 返回true代表开启filter。
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * run方法就是过滤器的具体逻辑。
     * return 可以返回任意的对象，当前实现忽略。（spring-cloud-zuul官方解释）
     * 直接返回null即可。
     */
    @Override
    public Object run() throws ZuulException {
        // 通过zuul，获取请求上下文
        RequestContext rc = RequestContext.getCurrentContext();
        HttpServletRequest request = rc.getRequest();

        // 可以记录日志、鉴权，给维护人员记录提供定位协助、统计性能
        logger.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        logger.info("zuul拦截--请求前验证---auth："+accessToken);
//        if (accessToken == null) {
//            logger.warn("token is empty");
//            rc.setSendZuulResponse(false);
//            rc.setResponseStatusCode(401);
//            try {
//                rc.getResponse().getWriter().write("token is empty");
//            } catch (Exception e) {
//            }
//
//            return null;
//        }
        String auth = request.getParameter("auth");
        //TODO 此处可以做日志记录
        logger.info("zuul拦截--请求前验证---auth："+auth);

        //成功的情况
//        if (StringUtils.isNotBlank(auth)){
//            rc.setSendZuulResponse(true); //对请求进行路由
//            rc.setResponseStatusCode(200);
//            rc.set("isSuccess", true);
//        }else {
//            //失败的情况
//            UniVerResponse res = new UniVerResponse();
//            res.beFalse3("zuul拦截--请求前验证---没有auth登录验证",UniVerResponse.ERROR_BUSINESS);
//
//            rc.setSendZuulResponse(false); //不对请求进行路由
//            rc.setResponseStatusCode(res.getCode());//设置返回状态码
//            rc.setResponseBody(JSON.toJSONString(res));//设置返回响应体
//            rc.set("isSuccess", false);
//            rc.getResponse().setContentType("application/json;charset=UTF-8");//设置返回响应体格式，可能会乱码
//
//        }
        logger.info("ok");

        return null;
    }
}
