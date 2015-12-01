package io.github.gefangshuai.server.rtat.controller;

import io.github.gefangshuai.rtat.model.Food;
import io.github.gefangshuai.rtat.service.FoodService;
import io.github.gefangshuai.server.core.config.Menu;
import io.github.gefangshuai.server.core.context.AppConfigContext;
import io.github.gefangshuai.server.core.utils.FlashMessageUtils;
import io.github.gefangshuai.server.core.utils.QueryUtils;
import io.github.gefangshuai.server.utils.ModelBeanUtils;
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
    private AppConfigContext appConfigContext;

    @RequestMapping
    public String index(@RequestParam(value = "page", defaultValue = "1") int page, String key, Model model) {
        PageRequest pageRequest = new PageRequest(page, appConfigContext.getRtatFoodspageSize(), new Sort(Sort.Direction.DESC, "id"));
        Page<Food> recordPage = foodService.findByRestaurantAndNameLike(ModelBeanUtils.getCurrentRestaurant(), QueryUtils.getLike(key), pageRequest);
        model.addAttribute("recordPage", recordPage);
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
