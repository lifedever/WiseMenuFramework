package io.github.gefangshuai.rtat.model;

import com.fasterxml.jackson.annotation.JsonView;
import io.github.gefangshuai.ext.persistence.CoreModel;
import io.github.gefangshuai.rtat.model.listener.FoodAndDrinksPersistentListener;
import io.github.gefangshuai.utils.CustomJsonView;
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
    @JsonView(CustomJsonView.RestJsonView.class)
    private String name;    // 名字

    @JsonView(CustomJsonView.RestJsonView.class)
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private double price;   // 价格
    private String imagePath;   // 图片地址
    private String thumbPath;   // 缩略图地址

    @JsonView(CustomJsonView.RestJsonView.class)
    private String flavor;      // 口味
    @JsonView(CustomJsonView.RestJsonView.class)
    private String materials;   // 用料
    @JsonView(CustomJsonView.RestJsonView.class)
    private String memo;        // 描述
    @JsonView(CustomJsonView.RestJsonView.class)
    private boolean hot = true;   // 是否热菜
    @JsonView(CustomJsonView.RestJsonView.class)
    private boolean meat = true;  // 是否荤菜
    @JsonView(CustomJsonView.RestJsonView.class)
    private boolean muslim = false;    // 是否清真
    private boolean published = false;  // 是否发布

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

    public String getThumbPath() {
        return thumbPath;
    }

    public void setThumbPath(String thumbPath) {
        this.thumbPath = thumbPath;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }
}
