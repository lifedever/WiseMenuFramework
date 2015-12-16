package io.github.gefangshuai.rtat.service;

import io.github.gefangshuai.rtat.dao.DrinksTypeDao;
import io.github.gefangshuai.rtat.dao.FoodTypeDao;
import io.github.gefangshuai.rtat.model.DrinksType;
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
public class DrinksTypeService extends CoreService<DrinksType, Long>{
    private DrinksTypeDao drinksTypeDao;

    @Resource
    public void setDrinksTypeDao(DrinksTypeDao drinksTypeDao) {
        this.drinksTypeDao = drinksTypeDao;
        super.coreDao = drinksTypeDao;
    }

    public List<DrinksType> findByRestaurant(Restaurant restaurant) {
        return drinksTypeDao.findByRestaurantOrderByOrderNumberAsc(restaurant);
    }

    @Transactional
    public DrinksType saveDrinksType(DrinksType drinksType){
        Integer orderNumber = drinksTypeDao.findMaxOrderNumber();
        if (orderNumber == null) {
            orderNumber = 0;
        }
        drinksType.setOrderNumber(orderNumber + 1);
        return drinksTypeDao.save(drinksType);
    }

    @Transactional
    public void changeOrder(long sid, long tid) {
        DrinksType sType = drinksTypeDao.findOne(sid);
        DrinksType tType = drinksTypeDao.findOne(tid);
        int tempOrderNumber = sType.getOrderNumber();
        sType.setOrderNumber(tType.getOrderNumber());
        tType.setOrderNumber(tempOrderNumber);
    }
}
