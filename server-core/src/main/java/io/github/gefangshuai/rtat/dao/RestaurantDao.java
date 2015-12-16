package io.github.gefangshuai.rtat.dao;

import io.github.gefangshuai.constant.StatusEnum;
import io.github.gefangshuai.rtat.model.Restaurant;
import io.github.gefangshuai.server.core.persistence.CoreDao;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by gefangshuai on 2015/11/9.
 */
public interface RestaurantDao extends CoreDao<Restaurant, Long> {

    @Query("select r from Restaurant r where r.user.username = ?1")
    Restaurant findByUsername(String username);

    List<Restaurant> findByOpeningAndStatus(boolean opening, StatusEnum status);
}
