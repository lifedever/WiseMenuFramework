package io.github.gefangshuai.permission.model;

/**
 * 角色
 * Created by gefangshuai on 2015/11/6.
 */
public enum Role {
    ADMINISTRATOR("administrator", "系统管理员", "/dashboard"),
    RESTAURANT("restaurant", "经营者", "/dashboard"),
    CONSUMER("consumer", "消费者", "/");

    private String name;
    private String title;
    private String homeUrl = "/";

    Role(String name, String title, String homeUrl) {
        this.name = name;
        this.title = title;
        this.homeUrl = homeUrl;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getHomeUrl() {
        return homeUrl;
    }
}
