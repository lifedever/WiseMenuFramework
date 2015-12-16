package io.github.gefangshuai.rtat.model;

import io.github.gefangshuai.rtat.model.listener.FoodAndDrinksPersistentListener;
import io.github.gefangshuai.server.core.persistence.CoreModel;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;

/**
 * Created by gefangshuai on 2015/11/13.
 */
@Entity
@Table(name = "b_drinks")
@EntityListeners({FoodAndDrinksPersistentListener.class})
public class Drinks extends CoreModel {
    private String name;    // 名字

    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private double price;   // 价格
    private String imagePath;   // 图片地址
    private String thumbPath;   // 缩略图地址

    private String memo;        // 描述
    private boolean alcohol = false;   // 是否含有酒精
    private boolean hot = false;  // 是否加热
    private boolean frozen = false;    // 是否冰镇
    private boolean published = false;  // 是否发布

    @ManyToOne
    @JoinColumn(name = "drinks_type_id")
    private DrinksType drinksType;

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

    public String getThumbPath() {
        return thumbPath;
    }

    public void setThumbPath(String thumbPath) {
        this.thumbPath = thumbPath;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public boolean isAlcohol() {
        return alcohol;
    }

    public void setAlcohol(boolean alcohol) {
        this.alcohol = alcohol;
    }

    public boolean isHot() {
        return hot;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    public DrinksType getDrinksType() {
        return drinksType;
    }

    public void setDrinksType(DrinksType drinksType) {
        this.drinksType = drinksType;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }
}
