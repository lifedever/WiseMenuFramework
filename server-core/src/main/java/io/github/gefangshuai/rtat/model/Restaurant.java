package io.github.gefangshuai.rtat.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.gson.Gson;
import io.github.gefangshuai.constant.StatusEnum;
import io.github.gefangshuai.permission.model.User;
import io.github.gefangshuai.server.core.persistence.CoreModel;
import io.github.gefangshuai.utils.CustomJsonView;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.type.ClobType;
import org.springframework.data.annotation.Persistent;

import javax.persistence.*;
import java.util.List;

/**
 * 餐厅商铺表
 * Created by gefangshuai on 2015/11/9.
 */
@Entity
@Table(name = "b_restaurant")
public class Restaurant extends CoreModel{
    @JsonView(CustomJsonView.RestJsonView.class)
    private String name;            // 门店名称

    @ElementCollection(fetch = FetchType.EAGER)
    @JsonView(CustomJsonView.RestJsonView.class)
    private List<String> telNum;    // 联系方式，可以多个(前台页面暂时只支持一个)
    @JsonView(CustomJsonView.RestJsonView.class)
    private String province;        // 省
    @JsonView(CustomJsonView.RestJsonView.class)
    private String city;            // 市
    @JsonView(CustomJsonView.RestJsonView.class)
    private String district;        // 区
    @JsonView(CustomJsonView.RestJsonView.class)
    private String address;         // 详细地址

    @JsonView(CustomJsonView.RestJsonView.class)
    private String memo;            // 门店描述
    private String imagePath;       // 门店图片地址
    private String thumbImagePath;  // 缩略图地址

    @Lob
    private String image;           // 图片的Base64， 用于客户端显示

    private boolean opening = false;        // 营业中
    private StatusEnum status = StatusEnum.VALID; // 是否有效

    @OneToOne
    @JoinColumn(name = "userId")
    @Cascade(CascadeType.ALL)
    private User user;              // 对应用户表

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTelNum() {
        return telNum;
    }

    public void setTelNum(List<String> telNum) {
        this.telNum = telNum;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public boolean isOpening() {
        return opening;
    }

    public void setOpening(boolean opening) {
        this.opening = opening;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getThumbImagePath() {
        return thumbImagePath;
    }

    public void setThumbImagePath(String thumbImagePath) {
        this.thumbImagePath = thumbImagePath;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
