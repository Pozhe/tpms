package com.txzhe.entity.menu;

import java.io.Serializable;
import java.util.List;

public class MenuDTO implements Serializable{
    private String id;
    private String name;
    private String url;
    private String icon;
    private Integer parent;
    private Integer state;
    private String roleName;
    private List<MenuDTO> submenu;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<MenuDTO> getSubmenu() {
        return submenu;
    }

    public void setSubmenu(List<MenuDTO> submenu) {
        this.submenu = submenu;
    }
}
