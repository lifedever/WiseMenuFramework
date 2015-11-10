package io.github.gefangshuai.server.account.controller;

import io.github.gefangshuai.business.model.Restaurant;
import io.github.gefangshuai.business.service.RestaurantService;
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
    private RestaurantService restaurantService;

    /**
     * 保存注册
     */
    @RequestMapping("save")
    public String saveAccount(Restaurant restaurant, String confirm_password) {
        if (!confirm_password.equals(restaurant.getUser().getPassword())) {
            return "/create";
        }
        restaurantService.save(restaurant);
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
