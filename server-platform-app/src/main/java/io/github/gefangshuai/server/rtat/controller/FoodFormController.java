package io.github.gefangshuai.server.rtat.controller;

import io.github.gefangshuai.business.model.Food;
import io.github.gefangshuai.business.service.FoodService;
import io.github.gefangshuai.server.core.config.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by gefangshuai on 2015/11/16.
 */
@Controller
@Menu("foods-list")
@RequestMapping("/rtat/foods")
public class FoodFormController {
    @Resource
    private FoodService foodService;

    @ModelAttribute
    public Food getFoodModel(@PathVariable Long id){
        Food food;
        if (id == null || id == 0) {
            food = new Food();
        }else{
            food = foodService.findOne(id);
        }
        return food;
    }

    @RequestMapping("/add/{id}")
    public String addFood(@ModelAttribute Food food){
        return "rtat/foods/form";
    }
}
