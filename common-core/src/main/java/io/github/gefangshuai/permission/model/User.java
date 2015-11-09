package io.github.gefangshuai.permission.model;

import io.github.gefangshuai.constant.StatusEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * 系统核心用户表
 * Created by gefangshuai on 2015/11/3.
 */
@Entity
@Table(name = "p_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
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


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
