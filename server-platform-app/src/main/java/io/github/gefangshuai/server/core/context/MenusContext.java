package io.github.gefangshuai.server.core.context;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * 对应：classpath:config/menus.yml
 * Created by gefangshuai on 2015/11/11.
 */
@ConfigurationProperties(prefix = "app.menus", locations = "classpath:config/menus.yml")
public class MenusContext {
    public static final String MENUS_CONTEXT_KEY = "menus_context";

    private List<Menu> administratorMenus;
    private List<Menu> restaurantMenus;

    public List<Menu> getAdministratorMenus() {
        return administratorMenus;
    }

    public void setAdministratorMenus(List<Menu> administratorMenus) {
        this.administratorMenus = administratorMenus;
    }

    public List<Menu> getRestaurantMenus() {
        return restaurantMenus;
    }

    public void setRestaurantMenus(List<Menu> restaurantMenus) {
        this.restaurantMenus = restaurantMenus;
    }
}

