package io.github.gefangshuai.server.rtat.controller;

import io.github.gefangshuai.rtat.model.Food;
import io.github.gefangshuai.rtat.service.FoodService;
import io.github.gefangshuai.server.core.config.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gefangshuai on 2015/11/13.
 */
@Menu("foods-list")
@Controller
@RequestMapping("/rtat/foods")
public class FoodController {

    @Resource
    private FoodService foodService;

    @RequestMapping
    public String index(Model model){
        List<Food> foods = foodService.findAll();
        model.addAttribute("foods", foods);
        return "rtat/foods/list";
    }


}
