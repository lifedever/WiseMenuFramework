package io.github.gefangshuai.server.core.spring;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义全局拦截器
 * Created by gefangshuai on 2015/11/3.
 */
public class NavigationHandlerInterceptor extends HandlerInterceptorAdapter{
    Logger logger = Logger.getLogger(NavigationHandlerInterceptor.class);
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.debug("--- NavigationHandlerInterceptor  " + request.getServletPath() +" ! ---");

        super.postHandle(request, response, handler, modelAndView);
    }
}
