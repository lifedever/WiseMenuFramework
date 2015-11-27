package io.github.gefangshuai.rtat.service;

import io.github.gefangshuai.rtat.dao.FoodDao;
import io.github.gefangshuai.rtat.model.Food;
import io.github.gefangshuai.server.core.persistence.CoreService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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
}
