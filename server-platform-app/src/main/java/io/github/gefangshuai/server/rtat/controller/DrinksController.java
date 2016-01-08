package io.github.gefangshuai.server.rtat.controller;

import io.github.gefangshuai.ext.annotation.Menu;
import io.github.gefangshuai.ext.utils.FlashMessageUtils;
import io.github.gefangshuai.rtat.model.Drinks;
import io.github.gefangshuai.rtat.model.DrinksType;
import io.github.gefangshuai.rtat.model.Restaurant;
import io.github.gefangshuai.rtat.service.DrinksService;
import io.github.gefangshuai.rtat.service.DrinksTypeService;
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
@Menu("drinks-list")
@Controller
@RequestMapping("/rtat/drinks")
public class DrinksController {

    @Resource
    private DrinksService drinksService;
    @Resource
    private DrinksTypeService drinksTypeService;

    @Resource
    private AppConfigContext appConfigContext;

    @RequestMapping
    public String index(@RequestParam(value = "page", defaultValue = "1") int page, String key, Long typeId, Model model) {
        PageRequest pageRequest = new PageRequest(page, appConfigContext.getRtatFoodspageSize(), new Sort(Sort.Direction.DESC, "published", "id"));
        Restaurant restaurant = ModelBeanUtils.getCurrentRestaurant();

        Page<Drinks> recordPage;
        if (typeId == null || typeId == 0) {
            recordPage = drinksService.findByRestaurantAndNameLike(restaurant, QueryUtils.getLike(key), pageRequest);
        } else {
            DrinksType drinksType = drinksTypeService.findOne(typeId);
            model.addAttribute("currentType", drinksType);
            recordPage = drinksService.findByRestaurantAndDrinksTypeAndNameLike(restaurant, drinksType, QueryUtils.getLike(key), pageRequest);
        }
        List<DrinksType> drinksTypes = drinksTypeService.findByRestaurant(restaurant);

        model.addAttribute("recordPage", recordPage);
        model.addAttribute("drinksTypes", drinksTypes);
        model.addAttribute("key", key);
        return "rtat/drinks/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        drinksService.delete(id);
        FlashMessageUtils.success(redirectAttributes, "删除成功！");
        return "redirect:/rtat/drinks";
    }
}
