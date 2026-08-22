package com.appnew.android.Model.Courses;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class PopupCourse implements Serializable {
    private String course;
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourse() {
        return this.course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
