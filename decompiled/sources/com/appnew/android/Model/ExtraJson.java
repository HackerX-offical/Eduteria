package com.appnew.android.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class ExtraJson implements Serializable {

    @SerializedName("home_screen")
    @Expose
    private String home_screen;

    @SerializedName("is_live")
    @Expose
    private String is_live;

    @SerializedName("is_new")
    @Expose
    private String is_new;

    @SerializedName("is_trending")
    @Expose
    private String is_trending;

    @SerializedName("sold_out")
    @Expose
    private String sold_out;

    public String getIs_new() {
        return this.is_new;
    }

    public void setIs_new(String is_new) {
        this.is_new = is_new;
    }

    public String getIs_trending() {
        return this.is_trending;
    }

    public void setIs_trending(String is_trending) {
        this.is_trending = is_trending;
    }

    public String getSold_out() {
        return this.sold_out;
    }

    public void setSold_out(String sold_out) {
        this.sold_out = sold_out;
    }

    public String getIs_live() {
        return this.is_live;
    }

    public void setIs_live(String is_live) {
        this.is_live = is_live;
    }

    public String getHome_screen() {
        return this.home_screen;
    }

    public void setHome_screen(String home_screen) {
        this.home_screen = home_screen;
    }

    public ExtraJson(String home_screen, String is_new) {
        this.is_new = is_new;
        this.home_screen = home_screen;
    }

    public ExtraJson(String home_screen, String is_new, String is_live) {
        this.is_new = is_new;
        this.home_screen = home_screen;
        this.is_live = is_live;
    }
}
