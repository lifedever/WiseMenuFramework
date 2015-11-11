package io.github.gefangshuai.server.core.context;

import io.github.gefangshuai.permission.model.Role;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by gefangshuai on 2015/11/11.
 */
public class GlobalParamsInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = Logger.getLogger(GlobalParamsInterceptor.class);
    @Resource
    private MenusContext menusContext;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        if (SecurityUtils.getSubject().hasRole(Role.ADMINISTRATOR.getName())) {
            request.setAttribute(MenusContext.MENUS_CONTEXT_KEY, menusContext.getAdministratorMenus());
        }
        if (SecurityUtils.getSubject().hasRole(Role.RESTAURANT.getName())) {
            request.setAttribute(MenusContext.MENUS_CONTEXT_KEY, menusContext.getAdministratorMenus());
        }

        logger.debug("----ServletPath: " + request.getServletPath() + "----");
        super.postHandle(request, response, handler, modelAndView);
    }
}
