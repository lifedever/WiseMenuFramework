package io.github.gefangshuai;

import io.github.gefangshuai.business.model.Restaurant;
import io.github.gefangshuai.permission.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gefangshuai on 2015/11/6.
 */
@Controller
public class IndexController{

    @RequestMapping("/")
    public String greeting(Model model) {
        return "index";
    }

    /**
     * 注册页面
     */
    @RequestMapping("/create")
    @RequiresGuest
    public String createAccount(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "createAccount";
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
