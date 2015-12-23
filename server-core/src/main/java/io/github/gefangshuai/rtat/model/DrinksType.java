package io.github.gefangshuai.rtat.model;

import com.fasterxml.jackson.annotation.JsonView;
import io.github.gefangshuai.rtat.model.listener.FoodAndDrinksPersistentListener;
import io.github.gefangshuai.server.core.persistence.CoreModel;
import io.github.gefangshuai.utils.CustomJsonView;

import javax.persistence.*;

/**
 * Created by gefangshuai on 2015/11/13.
 */
@Entity
@Table(name = "b_drinks_type")
@EntityListeners({FoodAndDrinksPersistentListener.class})
public class DrinksType extends CoreModel {
    @JsonView(CustomJsonView.RestJsonView.class)
    private String name;
    private int orderNumber;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public String toString() {
        return name;
    }
}
