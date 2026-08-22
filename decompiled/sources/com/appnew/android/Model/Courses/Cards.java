package com.appnew.android.Model.Courses;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class Cards implements Serializable {
    private String c_code;
    private String count;
    private String id;
    private String revert_api;
    private String tile_name;
    private String type;

    public Cards(String type) {
        this.type = type;
    }

    public Cards(String id, String tile_name, String c_code, String type, String revert_api, String count) {
        this.id = id;
        this.tile_name = tile_name;
        this.c_code = c_code;
        this.type = type;
        this.revert_api = revert_api;
        this.count = count;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTile_name() {
        return this.tile_name;
    }

    public void setTile_name(String tile_name) {
        this.tile_name = tile_name;
    }

    public String getC_code() {
        return this.c_code;
    }

    public void setC_code(String c_code) {
        this.c_code = c_code;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRevert_api() {
        return this.revert_api;
    }

    public void setRevert_api(String revert_api) {
        this.revert_api = revert_api;
    }

    public String getCount() {
        return this.count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
