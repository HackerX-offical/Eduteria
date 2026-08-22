package com.appnew.android.table;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class CourseTypeMasterTable implements Serializable {
    private int auto_id;
    private String bg_color;
    private String cat_type;
    private String course_id;
    private String description;
    private String display_type;
    private String font_color;
    private String icon;
    private String id;
    private String master_category_id;
    private String name;
    private String sec_bg_color;
    private String sec_color;
    private String sub_cat_id;
    private String user_id;
    private String view_type;
    private String weblink_url;

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

    public String getDisplay_type() {
        return this.display_type;
    }

    public void setDisplay_type(String display_type) {
        this.display_type = display_type;
    }

    public void setView_type(String view_type) {
        this.view_type = view_type;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSec_color() {
        return this.sec_color;
    }

    public void setSec_color(String sec_color) {
        this.sec_color = sec_color;
    }

    public String getSec_bg_color() {
        return this.sec_bg_color;
    }

    public void setSec_bg_color(String sec_bg_color) {
        this.sec_bg_color = sec_bg_color;
    }

    public String getView_type() {
        return this.view_type;
    }

    public String getCourse_id() {
        return this.course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
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

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCat_type() {
        return this.cat_type;
    }

    public void setCat_type(String cat_type) {
        this.cat_type = cat_type;
    }

    public String getMaster_category_id() {
        return this.master_category_id;
    }

    public void setMaster_category_id(String master_category_id) {
        this.master_category_id = master_category_id;
    }

    public String getWeblink_url() {
        return this.weblink_url;
    }

    public void setWeblink_url(String weblink_url) {
        this.weblink_url = weblink_url;
    }

    public String getSub_cat_id() {
        return this.sub_cat_id;
    }

    public void setSub_cat_id(String sub_cat_id) {
        this.sub_cat_id = sub_cat_id;
    }
}
