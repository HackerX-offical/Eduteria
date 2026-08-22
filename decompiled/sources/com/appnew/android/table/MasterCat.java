package com.appnew.android.table;

/* JADX INFO: loaded from: classes6.dex */
public class MasterCat {
    private String app_hide;
    private int auto_id;
    private String cat;
    private String id;
    private boolean isSelected = false;
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

    public String getCat() {
        return this.cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getApp_hide() {
        return this.app_hide;
    }

    public void setApp_hide(String app_hide) {
        this.app_hide = app_hide;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean selected) {
        this.isSelected = selected;
    }
}
