package io.github.gefangshuai.server.core.context;

import java.util.List;

/**
 * Created by gefangshuai on 2015/11/11.
 */
public class Menu {
    private String title;
    private String url;
    private String icon;
    private String flag;    // 菜单标识，用于高亮显示菜单
    private List<Menu> subMenus;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<Menu> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<Menu> subMenus) {
        this.subMenus = subMenus;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
