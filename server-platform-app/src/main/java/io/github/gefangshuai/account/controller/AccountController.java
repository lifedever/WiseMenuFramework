package io.github.gefangshuai.account.controller;

import io.github.gefangshuai.constant.StatusEnum;
import io.github.gefangshuai.permission.model.Role;
import io.github.gefangshuai.permission.model.User;
import io.github.gefangshuai.permission.service.UserService;
import io.github.gefangshuai.utils.HashUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by gefangshuai on 2015/11/9.
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Resource
    private UserService userService;

    /**
     * 保存注册
     */
    @RequestMapping("save")
    public String saveAccount(User user, String confirm_password) {
        if (!confirm_password.equals(user.getPassword())) {
            return "/create";
        }
        userService.createUser(user, Role.RESTAURANT);
        return "redirect:/login";
    }

    /**
     * 忘记密码
     */
    @RequestMapping("forgot")
    public String forgotPassword() {
        return null;
    }
}
