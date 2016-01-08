package io.github.gefangshuai.rtat.dao;

import io.github.gefangshuai.ext.persistence.CoreDao;
import io.github.gefangshuai.rtat.model.DrinksType;
import io.github.gefangshuai.rtat.model.Restaurant;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by gefangshuai on 2015/11/13.
 */
public interface DrinksTypeDao extends CoreDao<DrinksType, Long> {
    List<DrinksType> findByRestaurantOrderByOrderNumberAsc(Restaurant restaurant);

    @Query("select max(orderNumber) from DrinksType")
    Integer findMaxOrderNumber();
}
