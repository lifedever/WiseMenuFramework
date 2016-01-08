package io.github.gefangshuai.server.rtat.controller;

import io.github.gefangshuai.ext.annotation.Menu;
import io.github.gefangshuai.ext.utils.FlashMessageUtils;
import io.github.gefangshuai.rtat.model.Food;
import io.github.gefangshuai.rtat.model.FoodType;
import io.github.gefangshuai.rtat.model.Restaurant;
import io.github.gefangshuai.rtat.service.FoodService;
import io.github.gefangshuai.rtat.service.FoodTypeService;
import io.github.gefangshuai.server.config.context.AppConfigContext;
import io.github.gefangshuai.server.utils.ModelBeanUtils;
import io.github.gefangshuai.utils.QueryUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @Resource
    private FoodTypeService foodTypeService;

    @Resource
    private AppConfigContext appConfigContext;

    @RequestMapping
    public String index(@RequestParam(value = "page", defaultValue = "1") int page, String key, Long typeId, Model model) {
        PageRequest pageRequest = new PageRequest(page, appConfigContext.getRtatFoodspageSize(), new Sort(Sort.Direction.DESC, "published", "id"));
        Restaurant restaurant = ModelBeanUtils.getCurrentRestaurant();

        Page<Food> recordPage;
        if (typeId == null || typeId == 0) {
            recordPage = foodService.findByRestaurantAndNameLike(restaurant, QueryUtils.getLike(key), pageRequest);
        }else{
            FoodType foodType = foodTypeService.findOne(typeId);
            model.addAttribute("currentType", foodType);
            recordPage = foodService.findByRestaurantAndFoodTypeAndNameLike(restaurant,foodType, QueryUtils.getLike(key), pageRequest);
        }
        List<FoodType> foodTypes = foodTypeService.findByRestaurant(restaurant);

        model.addAttribute("recordPage", recordPage);
        model.addAttribute("foodTypes", foodTypes);
        model.addAttribute("key", key);
        return "rtat/foods/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        foodService.delete(id);
        FlashMessageUtils.success(redirectAttributes, "删除成功！");
        return "redirect:/rtat/foods";
    }
}
