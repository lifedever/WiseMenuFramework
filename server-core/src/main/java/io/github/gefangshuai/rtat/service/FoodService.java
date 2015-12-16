package io.github.gefangshuai.rtat.service;

import io.github.gefangshuai.rtat.dao.FoodDao;
import io.github.gefangshuai.rtat.model.Food;
import io.github.gefangshuai.rtat.model.FoodType;
import io.github.gefangshuai.rtat.model.Restaurant;
import io.github.gefangshuai.server.core.persistence.CoreService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gefangshuai on 2015/11/13.
 */
@Service
@Transactional(readOnly = true)
public class FoodService extends CoreService<Food, Long>{

    private FoodDao foodDao;

    @Resource
    public void setFoodDao(FoodDao foodDao) {
        this.foodDao = foodDao;
        super.coreDao = foodDao;
    }

    public List<Food> findPublishedByRestaurantAndType(Restaurant restaurant, FoodType foodType){
        return foodDao.findByPublishedAndRestaurantAndFoodType(true, restaurant, foodType);
    }

    /**
     * 根据餐厅和名称查询
     * @param restaurant 餐馆
     * @param name 菜品
     * @param page 分页
     * @return
     */
    public Page<Food> findByRestaurantAndNameLike(Restaurant restaurant, String name, Pageable page) {
        return foodDao.findByRestaurantAndNameLike(restaurant, name, page);
    }

    /**
     * 根据餐厅、分类和名称查询
     * @param restaurant 餐馆
     * @param foodType 分类
     * @param name 名称
     * @param page 分页
     * @return
     */
    public Page<Food> findByRestaurantAndFoodTypeAndNameLike(Restaurant restaurant, FoodType foodType, String name, Pageable page){
        return foodDao.findByRestaurantAndFoodTypeAndNameLike(restaurant, foodType, name, page);
    }
}
