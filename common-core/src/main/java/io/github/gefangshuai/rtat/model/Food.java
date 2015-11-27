package io.github.gefangshuai.rtat.model;

import io.github.gefangshuai.rtat.model.listener.FoodAndDrinksPersistentListener;
import io.github.gefangshuai.server.core.persistence.CoreModel;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;

/**
 * 菜品表
 * Created by gefangshuai on 2015/11/13.
 */
@Entity
@Table(name = "b_foods")
@EntityListeners({FoodAndDrinksPersistentListener.class})
public class Food extends CoreModel {
    private String name;    // 名字

    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private double price;   // 价格
    private String imagePath;   // 图片地址
    private String flavor;      // 口味
    private String materials;   // 用料
    private String memo;        // 描述
    private boolean hot = true;   // 是否热菜
    private boolean meat = true;  // 是否荤菜
    private boolean muslim = true;    // 是否清真

    @ManyToOne
    @JoinColumn(name = "food_type_id")
    private FoodType foodType;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public boolean isHot() {
        return hot;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
    }

    public boolean isMeat() {
        return meat;
    }

    public void setMeat(boolean meat) {
        this.meat = meat;
    }

    public boolean isMuslim() {
        return muslim;
    }

    public void setMuslim(boolean muslim) {
        this.muslim = muslim;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
