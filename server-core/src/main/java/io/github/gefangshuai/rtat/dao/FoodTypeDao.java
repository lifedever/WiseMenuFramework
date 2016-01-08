package io.github.gefangshuai.rtat.dao;

import io.github.gefangshuai.ext.persistence.CoreDao;
import io.github.gefangshuai.rtat.model.FoodType;
import io.github.gefangshuai.rtat.model.Restaurant;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by gefangshuai on 2015/11/13.
 */
public interface FoodTypeDao extends CoreDao<FoodType, Long> {
    List<FoodType> findByRestaurantOrderByOrderNumberAsc(Restaurant restaurant);

    @Query("select max(orderNumber) from FoodType")
    Integer findMaxOrderNumber();
}
