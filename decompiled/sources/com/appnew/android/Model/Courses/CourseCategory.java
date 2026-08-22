package com.appnew.android.Model.Courses;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class CourseCategory implements Serializable {
    private String app_view_type;
    private String id;
    private String name;
    private String parent_fk;
    private String position;

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public String getApp_view_type() {
        return this.app_view_type;
    }

    public void setApp_view_type(String app_view_type) {
        this.app_view_type = app_view_type;
    }

    public String getParent_fk() {
        return this.parent_fk;
    }

    public void setParent_fk(String parent_fk) {
        this.parent_fk = parent_fk;
    }
}
