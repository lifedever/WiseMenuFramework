package io.github.gefangshuai.rtat.model.listener;

import io.github.gefangshuai.constant.SessionConstant;
import io.github.gefangshuai.rtat.model.Restaurant;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.SecurityUtils;

import javax.persistence.PrePersist;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by gefangshuai on 2015/11/13.
 */
public class FoodAndDrinksPersistentListener {

    @PrePersist
    public void persistObj(Object object){
        Restaurant restaurant = (Restaurant) SecurityUtils.getSubject().getSession().getAttribute(SessionConstant.RESTAURANT_KEY);
        try {
            BeanUtils.setProperty(object, "restaurant", restaurant);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
