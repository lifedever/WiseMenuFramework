package io.github.gefangshuai.server.config.context;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by gefangshuai on 2015/11/11.
 */
public class GlobalParamsInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = Logger.getLogger(GlobalParamsInterceptor.class);

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.debug("----ServletPath: " + request.getServletPath() + "----");
        super.postHandle(request, response, handler, modelAndView);
    }
}
