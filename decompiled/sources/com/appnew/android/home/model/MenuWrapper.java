package com.appnew.android.home.model;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class MenuWrapper implements Serializable {
    private List<Menu> menuList;

    public MenuWrapper(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public List<Menu> getMenuList() {
        return this.menuList;
    }
}
