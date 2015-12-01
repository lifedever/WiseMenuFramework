package io.github.gefangshuai.rtat.dao;

import io.github.gefangshuai.rtat.model.FoodType;
import io.github.gefangshuai.rtat.model.Restaurant;
import io.github.gefangshuai.server.core.persistence.CoreDao;
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
