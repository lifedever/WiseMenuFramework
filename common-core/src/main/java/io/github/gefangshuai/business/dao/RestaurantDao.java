package io.github.gefangshuai.business.dao;

import io.github.gefangshuai.business.model.Restaurant;
import io.github.gefangshuai.core.dao.CoreDao;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by gefangshuai on 2015/11/9.
 */
public interface RestaurantDao extends CoreDao<Restaurant, Long> {

    @Query("select r from Restaurant r where r.user.username = ?1")
    Restaurant findByUsername(String username);
}
