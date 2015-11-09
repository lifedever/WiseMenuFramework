package io.github.gefangshuai;

import io.github.gefangshuai.business.model.Restaurant;
import io.github.gefangshuai.business.service.RestaurantService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by gefangshuai on 2015/11/6.
 */
@Controller
public class IndexController{

    /**
     * 首页
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String greeting(Model model, HttpSession session) {

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

    @RequestMapping(value = "/login")
    public String login() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return "redirect:/";
        } else {
            return "login";
        }
    }

    @RequestMapping("logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "redirect:/login";
    }


    @RequestMapping("/404")
    public String error404() {
        return "error/404";
    }
}
