package io.github.gefangshuai.server.admin.controller;

import io.github.gefangshuai.ext.annotation.Menu;
import io.github.gefangshuai.rtat.model.Restaurant;
import io.github.gefangshuai.rtat.service.RestaurantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gefangshuai on 2015/12/3.
 */
@Menu("admin-restaurants")
@Controller
@RequestMapping("/admin/restaurants")
public class AdminRestaurantController {
    @Resource
    private RestaurantService restaurantService;

    @RequestMapping
    public String index(Model model){
        List<Restaurant> restaurants = restaurantService.findAll();
        model.addAttribute("restaurants", restaurants);
        return "/admin/restaurant/index";
    }
}
