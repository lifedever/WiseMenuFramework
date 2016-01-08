package io.github.gefangshuai.server.rtat.controller;

import io.github.gefangshuai.ext.annotation.Menu;
import io.github.gefangshuai.ext.utils.FlashMessageUtils;
import io.github.gefangshuai.rtat.model.FoodType;
import io.github.gefangshuai.rtat.service.FoodTypeService;
import io.github.gefangshuai.server.utils.ModelBeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;

/**
 * Created by gefangshuai on 2015/11/30.
 */
@Controller
@Menu("foods-type")
@RequestMapping("/rtat/foods/type")
public class FoodTypeController {
    @Resource
    private FoodTypeService foodTypeService;

    @RequestMapping
    public String index(Model model){
        model.addAttribute("foodTypes", foodTypeService.findByRestaurant(ModelBeanUtils.getCurrentRestaurant()));
        return "/rtat/foods/type/index";
    }

    @RequestMapping("/save")
    public String saveFoodType(FoodType foodType, RedirectAttributes redirectAttributes){
        foodTypeService.saveFoodType(foodType);
        FlashMessageUtils.success(redirectAttributes, "分类添加成功!");
        return "redirect:/rtat/foods/type";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable long id, RedirectAttributes redirectAttributes){
        try {
            foodTypeService.delete(id);
            FlashMessageUtils.success(redirectAttributes, "分类删除成功!");
        } catch (Exception e) {
            FlashMessageUtils.error(redirectAttributes, "该分类下有记录，无法删除!");
        }
        return "redirect:/rtat/foods/type";
    }

    @RequestMapping("/order/{sid}-{tid}")
    public String changeOrder(@PathVariable long sid, @PathVariable long tid){
        foodTypeService.changeOrder(sid, tid);
        return "redirect:/rtat/foods/type";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable long id, String name, RedirectAttributes redirectAttributes){
        FoodType foodType = foodTypeService.findOne(id);
        foodType.setName(name);
        foodTypeService.save(foodType);
        FlashMessageUtils.success(redirectAttributes, "修改成功!");
        return "redirect:/rtat/foods/type";
    }
}
