package com.appnew.android.home.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class Data {

    @SerializedName("bottom_menu")
    @Expose
    private List<Menu> bottomMenu;

    @SerializedName("left_menu")
    @Expose
    private List<Menu> leftMenu;

    @SerializedName("top_menu")
    @Expose
    private List<Menu> topMenu;

    public List<Menu> getTopMenu() {
        return this.topMenu;
    }

    public List<Menu> getBottomMenu() {
        return this.bottomMenu;
    }

    public List<Menu> getLeftMenu() {
        return this.leftMenu;
    }
}
