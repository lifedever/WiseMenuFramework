package io.github.gefangshuai.permission.model;

import io.github.gefangshuai.constant.StatusEnum;
import io.github.gefangshuai.ext.shiro.bean.UserModel;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 系统核心用户表
 * Created by gefangshuai on 2015/11/3.
 */
@Entity
@Table(name = "p_users")
public class User extends UserModel {

    @NotNull
    private String mobile;          // 注册手机号
    private Role role;              // 角色

    private StatusEnum status;      // 有效状态

    public User() {

    }


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
