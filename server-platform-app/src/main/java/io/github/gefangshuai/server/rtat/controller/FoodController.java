package io.github.gefangshuai.server.rtat.controller;

import io.github.gefangshuai.rtat.model.Food;
import io.github.gefangshuai.rtat.service.FoodService;
import io.github.gefangshuai.server.core.config.Menu;
import io.github.gefangshuai.server.core.utils.FlashMessageUtils;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        List<Food> foods = foodService.findAll(new Sort(Sort.Direction.DESC, "id"));
        model.addAttribute("foods", foods);
        return "rtat/foods/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes){
        foodService.delete(id);
        FlashMessageUtils.success(redirectAttributes, "删除成功！");
        return "redirect:/rtat/foods";
    }
}
