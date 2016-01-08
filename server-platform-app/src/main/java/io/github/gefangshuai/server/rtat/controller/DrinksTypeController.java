package io.github.gefangshuai.server.rtat.controller;

import io.github.gefangshuai.ext.annotation.Menu;
import io.github.gefangshuai.ext.utils.FlashMessageUtils;
import io.github.gefangshuai.rtat.model.DrinksType;
import io.github.gefangshuai.rtat.service.DrinksTypeService;
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
@Menu("drinks-type")
@RequestMapping("/rtat/drinks/type")
public class DrinksTypeController {
    @Resource
    private DrinksTypeService drinksTypeService;

    @RequestMapping
    public String index(Model model){
        model.addAttribute("drinksTypes", drinksTypeService.findByRestaurant(ModelBeanUtils.getCurrentRestaurant()));
        return "/rtat/drinks/type/index";
    }

    @RequestMapping("/save")
    public String saveFoodType(DrinksType drinksType, RedirectAttributes redirectAttributes){
        drinksTypeService.saveDrinksType(drinksType);
        FlashMessageUtils.success(redirectAttributes, "分类添加成功!");
        return "redirect:/rtat/drinks/type";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable long id, RedirectAttributes redirectAttributes){
        drinksTypeService.delete(id);
        FlashMessageUtils.success(redirectAttributes, "分类删除成功!");
        return "redirect:/rtat/drinks/type";
    }

    @RequestMapping("/order/{sid}-{tid}")
    public String changeOrder(@PathVariable long sid, @PathVariable long tid){
        drinksTypeService.changeOrder(sid, tid);
        return "redirect:/rtat/drinks/type";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable long id, String name, RedirectAttributes redirectAttributes){
        DrinksType drinksType = drinksTypeService.findOne(id);
        drinksType.setName(name);
        drinksTypeService.save(drinksType);
        FlashMessageUtils.success(redirectAttributes, "修改成功!");
        return "redirect:/rtat/drinks/type";
    }
}
