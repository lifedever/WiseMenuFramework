package io.github.gefangshuai.rtat.service;

import io.github.gefangshuai.rtat.dao.FoodTypeDao;
import io.github.gefangshuai.rtat.model.Food;
import io.github.gefangshuai.rtat.model.FoodType;
import io.github.gefangshuai.rtat.model.Restaurant;
import io.github.gefangshuai.server.core.persistence.CoreService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gefangshuai on 2015/11/13.
 */
@Service
@Transactional(readOnly = true)
public class FoodTypeService extends CoreService<FoodType, Long>{
    private FoodTypeDao foodTypeDao;

    @Resource
    public void setFoodTypeDao(FoodTypeDao foodTypeDao) {
        this.foodTypeDao = foodTypeDao;
        super.coreDao = foodTypeDao;
    }

    public List<FoodType> findByRestaurant(Restaurant restaurant) {
        return foodTypeDao.findByRestaurantOrderByOrderNumberAsc(restaurant);
    }

    @Transactional
    public FoodType saveFoodType(FoodType foodType){
        Integer orderNumber = foodTypeDao.findMaxOrderNumber();
        if (orderNumber == null) {
            orderNumber = 0;
        }
        foodType.setOrderNumber(orderNumber + 1);
        return foodTypeDao.save(foodType);
    }

    @Transactional
    public void changeOrder(long sid, long tid) {
        FoodType sType = foodTypeDao.findOne(sid);
        FoodType tType = foodTypeDao.findOne(tid);
        int tempOrderNumber = sType.getOrderNumber();
        sType.setOrderNumber(tType.getOrderNumber());
        tType.setOrderNumber(tempOrderNumber);
    }
}
