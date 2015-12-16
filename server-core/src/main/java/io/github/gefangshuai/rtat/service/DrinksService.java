package io.github.gefangshuai.rtat.service;

import io.github.gefangshuai.rtat.dao.DrinksDao;
import io.github.gefangshuai.rtat.dao.FoodDao;
import io.github.gefangshuai.rtat.model.*;
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
public class DrinksService extends CoreService<Drinks, Long>{

    private DrinksDao drinksDao;

    @Resource
    public void setDrinksDao(DrinksDao drinksDao) {
        this.drinksDao = drinksDao;
        super.coreDao = drinksDao;
    }

    public Page<Drinks> findByRestaurantAndNameLike(Restaurant restaurant, String name, Pageable page) {
        return drinksDao.findByRestaurantAndNameLike(restaurant, name, page);
    }

    public Page<Drinks> findByRestaurantAndDrinksTypeAndNameLike(Restaurant restaurant, DrinksType drinksType, String name, Pageable page){
        return drinksDao.findByRestaurantAndDrinksTypeAndNameLike(restaurant, drinksType, name, page);
    }

    public List<Drinks> findPublishedByRestaurantAndType(Restaurant restaurant, DrinksType drinksType) {
        return drinksDao.findByPublishedAndRestaurantAndDrinksType(true, restaurant, drinksType);
    }
}
