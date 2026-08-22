package com.appnew.android.table;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class MasteAllCatTable implements Serializable {
    private String app_hide;
    private int auto_id;
    private String bg_color;
    private List<Subjectfilter> filters;
    private String font_color;
    private String id;
    private String image;
    private String master_type;
    private String name;
    private String parent_id;
    private String user_id;

    public int getAuto_id() {
        return this.auto_id;
    }

    public void setAuto_id(int auto_id) {
        this.auto_id = auto_id;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent_id() {
        return this.parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getMaster_type() {
        return this.master_type;
    }

    public void setMaster_type(String master_type) {
        this.master_type = master_type;
    }

    public String getFont_color() {
        return this.font_color;
    }

    public void setFont_color(String font_color) {
        this.font_color = font_color;
    }

    public String getBg_color() {
        return this.bg_color;
    }

    public void setBg_color(String bg_color) {
        this.bg_color = bg_color;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public List<Subjectfilter> getFilters() {
        return this.filters;
    }

    public void setFilters(List<Subjectfilter> filters) {
        this.filters = filters;
    }

    public String getApp_hide() {
        return this.app_hide;
    }

    public void setApp_hide(String app_hide) {
        this.app_hide = app_hide;
    }
}
