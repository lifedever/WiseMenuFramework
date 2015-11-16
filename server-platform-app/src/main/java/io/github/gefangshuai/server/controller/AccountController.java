package io.github.gefangshuai.server.controller;

import io.github.gefangshuai.business.model.Restaurant;
import io.github.gefangshuai.business.service.RestaurantService;
import io.github.gefangshuai.constant.SessionConstant;
import io.github.gefangshuai.server.core.context.AppConfigContext;
import io.github.gefangshuai.server.core.utils.FlashMessageUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by gefangshuai on 2015/11/9.
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Resource
    private RestaurantService restaurantService;
    @Resource
    private AppConfigContext appConfigContext;

    /**
     * 保存注册
     */
    @RequestMapping("save")
    public String saveAccount(Restaurant restaurant, String confirm_password, RedirectAttributes redirectAttributes) {
        if (!confirm_password.equals(restaurant.getUser().getPassword())) {
            FlashMessageUtils.error(redirectAttributes, "两次密码输入不一致!");
            return "/create";
        }
        restaurantService.save(restaurant);
        FlashMessageUtils.success(redirectAttributes, "注册成功，请登录!");
        return "redirect:/login";
    }


    /**
     * 忘记密码
     */
    @RequestMapping("forgot")
    public String forgotPassword() {
        return null;
    }

    @RequestMapping("load/shopImage/{id}")
    public ResponseEntity<byte[]> loadShopImage(@PathVariable long id, HttpServletRequest request) throws IOException {
        Restaurant restaurant = (Restaurant) SecurityUtils.getSubject().getSession().getAttribute(SessionConstant.RESTAURANT_KEY);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        if (StringUtils.isBlank(restaurant.getImagePath())) {
            return null;
        } else {
            return new ResponseEntity<>(FileUtils.readFileToByteArray(new File(appConfigContext.getStorePath() + restaurant.getImagePath())),
                    headers, HttpStatus.CREATED);
        }
    }
}
