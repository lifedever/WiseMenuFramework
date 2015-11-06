package io.github.gefangshuai.permission.model;

import io.github.gefangshuai.constant.StatusEnum;

import javax.persistence.*;

/**
 * 系统核心用户表
 * Created by gefangshuai on 2015/11/3.
 */
@Entity
@Table(name = "users")
public class User {
    private long id;
    private String username;
    private String mobile;
    private Role role;
    private String password;
    private StatusEnum status;

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
}
