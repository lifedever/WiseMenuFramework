package io.github.gefangshuai.account.controller;

import io.github.gefangshuai.business.model.Restaurant;
import io.github.gefangshuai.business.service.RestaurantService;
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
     * 补充信息
     */
    @RequestMapping("additional")
    public String additionalRestaurant(){
        return "account/restaurantInfoModal";
    }


    /**
     * 忘记密码
     */
    @RequestMapping("forgot")
    public String forgotPassword() {
        return null;
    }
}
