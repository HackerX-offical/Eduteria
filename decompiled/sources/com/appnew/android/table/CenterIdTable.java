package com.appnew.android.table;

/* JADX INFO: loaded from: classes6.dex */
public class CenterIdTable {
    private String center_id;
    private String center_name;
    private int id;
    private String user_id;

    public String getCenter_id() {
        return this.center_id;
    }

    public void setCenter_id(String center_id) {
        this.center_id = center_id;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCenter_name() {
        return this.center_name;
    }

    public void setCenter_name(String center_name) {
        this.center_name = center_name;
    }

    public CenterIdTable(String center_id, String user_id, String center_name) {
        this.center_id = center_id;
        this.user_id = user_id;
        this.center_name = center_name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
