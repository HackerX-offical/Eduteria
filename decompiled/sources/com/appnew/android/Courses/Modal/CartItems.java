package com.appnew.android.Courses.Modal;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class CartItems implements Serializable {
    private String course_id;
    private String user_id;

    public CartItems(String user_id, String course_id) {
        this.user_id = user_id;
        this.course_id = course_id;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCourse_id() {
        return this.course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }
}
