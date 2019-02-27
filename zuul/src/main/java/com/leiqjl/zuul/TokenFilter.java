package com.leiqjl.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

public class TokenFilter extends ZuulFilter {
    /**
     *  四种类型：pre,routing,error,post
     *  pre：主要用在路由映射的阶段是寻找路由映射表的
     *  routing:具体的路由转发过滤器是在routing路由器，具体的请求转发的时候会调用
     *  error:一旦前面的过滤器出错了，会调用error过滤器。
     *  post:当routing，error运行完后才会调用该过滤器，是在最后阶段的
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("token");
        if (Objects.isNull(token)) {
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            context.setResponseBody("unAuthrized");
            return null;
        }
        return null;
    }
}
