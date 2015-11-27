package io.github.gefangshuai.server;

import io.github.gefangshuai.permission.model.User;
import io.github.gefangshuai.permission.service.UserService;
import io.github.gefangshuai.server.core.config.Menu;
import io.github.gefangshuai.server.core.utils.FlashMessageUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.subject.Subject;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by gefangshuai on 2015/11/6.
 */
@Controller
public class IndexController{
    @Resource
    private UserService userService;

    /**
     * 首页
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String greeting(Model model, HttpServletRequest request) {
        return "index";
    }

    /**
     * 注册页面
     */
    @RequestMapping("/create")
    @RequiresGuest
    public String createAccount(Model model){
        return "account/createAccount";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return "redirect:/";
        }
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(RedirectAttributes redirectAttributes){
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return "redirect:/";
        } else {
            User user = userService.findByUsername((String) subject.getPrincipal());
            if (user == null) {
                FlashMessageUtils.error(redirectAttributes, "用户不存在！");
            }else{
                FlashMessageUtils.error(redirectAttributes, "用户名或密码错误！");
            }
            return "redirect:/login";
        }
    }

    @RequestMapping("/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "redirect:/login";
    }

    @RequestMapping("/404")
    public String error404() {
        return "error/404";
    }

    @RequestMapping("/forbidden")
    public String forbidden(){
        return "error/403";
    }

    @RequestMapping("/500")
    public String error500(){
        return "error/500";
    }
}
