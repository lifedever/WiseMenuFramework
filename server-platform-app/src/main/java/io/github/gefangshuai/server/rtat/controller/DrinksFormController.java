package io.github.gefangshuai.server.rtat.controller;

import io.github.gefangshuai.ext.annotation.Menu;
import io.github.gefangshuai.ext.utils.FlashMessageUtils;
import io.github.gefangshuai.rtat.model.Drinks;
import io.github.gefangshuai.rtat.model.DrinksType;
import io.github.gefangshuai.rtat.service.DrinksService;
import io.github.gefangshuai.rtat.service.DrinksTypeService;
import io.github.gefangshuai.server.config.context.AppConfigContext;
import io.github.gefangshuai.server.utils.ModelBeanUtils;
import io.github.gefangshuai.utils.StoreUtils;
import io.github.gefangshuai.utils.WebUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * Created by gefangshuai on 2015/11/16.
 */
@Controller
@Menu("drinks-list")
@RequestMapping("/rtat/drinks")
public class DrinksFormController {
    @Resource
    private DrinksService drinksService;
    @Resource
    private DrinksTypeService drinksTypeService;

    @Resource
    private AppConfigContext appConfigContext;

    @ModelAttribute("drinks")
    public Drinks getFoodModel(@PathVariable Long id) {
        Drinks drinks;
        if (id == null || id == 0) {
            drinks = new Drinks();
            drinks.setId(0l);
        } else {
            drinks = drinksService.findOne(id);
        }

        return drinks;
    }

    @RequestMapping("/edit/{id}")
    public String editDrinks(@ModelAttribute Drinks drinks, Long typeId, Model model, RedirectAttributes redirectAttributes) {
        if (drinks == null) {
            FlashMessageUtils.error(redirectAttributes, "相关酒水不存在！");
            return "redirect:/rtat/drinks";
        }
        if (drinks.getId() == 0 && typeId != null) {
            drinks.setDrinksType(drinksTypeService.findOne(typeId));
        }

        List<DrinksType> drinksTypes = drinksTypeService.findByRestaurant(ModelBeanUtils.getCurrentRestaurant());
        model.addAttribute("drinksTypes", drinksTypes);
        model.addAttribute("drinks", drinks);
        return "rtat/drinks/form";
    }

    @RequestMapping(value = "/save/{id}", method = RequestMethod.POST)
    public String saveDrinks(@ModelAttribute Drinks drinks, Long typeId, double xText, double yText, double widthText, double heightText, MultipartFile file) {
        if (file != null && file.getSize() > 0) {
            try {
                String relativePath = StoreUtils.storeCutFileWithThumbAndCompress(
                        appConfigContext.getGraphicsMagickHome(),
                        appConfigContext.getStorePath(),
                        StoreUtils.getExtension(file.getOriginalFilename()),
                        file.getInputStream(),
                        (int) xText,
                        (int) yText,
                        (int) widthText,
                        (int) heightText,
                        120, 100
                );
                drinks.setThumbPath(StoreUtils.getThumbPath(relativePath));
                drinks.setImagePath(relativePath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (typeId != null) {
            drinks.setDrinksType(drinksTypeService.findOne(typeId));
        }
        drinksService.save(drinks);
        return "redirect:/rtat/drinks";
    }

    @RequestMapping("/published/{id}/{published}")
    public String published(@ModelAttribute Drinks drinks, @PathVariable boolean published){
        drinks.setPublished(published);
        drinksService.save(drinks);
        return "redirect:/rtat/drinks";
    }
    @RequestMapping("/img/{id}")
    public ResponseEntity<byte[]> loadImage(@ModelAttribute Drinks drinks) throws IOException {
        return WebUtils.loadImage(appConfigContext.getStorePath() + drinks.getImagePath());
    }

    @RequestMapping("/img/{id}/thumb")
    public ResponseEntity<byte[]> loadImageThumb(@ModelAttribute Drinks drinks) throws IOException {
        return WebUtils.loadImage(appConfigContext.getStorePath() + drinks.getThumbPath());
    }
}
