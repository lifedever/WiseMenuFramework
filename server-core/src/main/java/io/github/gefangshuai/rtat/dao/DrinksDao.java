package io.github.gefangshuai.rtat.dao;

import io.github.gefangshuai.rtat.model.*;
import io.github.gefangshuai.server.core.persistence.CoreDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * Created by gefangshuai on 2015/11/13.
 */
public interface DrinksDao extends CoreDao<Drinks, Long> {
    Page<Drinks> findByRestaurantAndNameLike(Restaurant restaurant, String name, Pageable pageable);

    Page<Drinks> findByRestaurantAndDrinksTypeAndNameLike(Restaurant restaurant, DrinksType drinksType, String name, Pageable page);

    List<Drinks> findByPublishedAndRestaurantAndDrinksType(boolean published, Restaurant restaurant, DrinksType drinksType);

    List<Drinks> findByPublishedAndRestaurant(boolean b, Restaurant restaurant);

    @Query("from Drinks where id in (:ids)")
    List<Drinks> findByIds(@Param("ids") Long[] ids);
}
