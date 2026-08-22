package com.appnew.android.Model.PoJoModel;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class RequestTwoPOJO implements Serializable {
    private String course_id;
    private String name;
    private String tile_id;

    public RequestTwoPOJO(String name, String course_id, String tile_id) {
        this.name = name;
        this.course_id = course_id;
        this.tile_id = tile_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse_id() {
        return this.course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getTile_id() {
        return this.tile_id;
    }

    public void setTile_id(String tile_id) {
        this.tile_id = tile_id;
    }
}
