package io.github.gefangshuai.permission.model;

import io.github.gefangshuai.constant.StatusEnum;
import io.github.gefangshuai.server.core.persistence.CoreModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * 系统核心用户表
 * Created by gefangshuai on 2015/11/3.
 */
@Entity
@Table(name = "p_users")
public class User extends CoreModel {

    @NotNull
    private String username;        // 登陆名称
    @NotNull
    private String mobile;          // 注册手机号
    private Role role;              // 角色
    @NotNull
    private String password;        // 密码
    private String salt;            // 密码盐值

    private StatusEnum status;      // 有效状态

    public User() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
