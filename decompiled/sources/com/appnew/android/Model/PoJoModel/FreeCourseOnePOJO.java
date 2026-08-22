package com.appnew.android.Model.PoJoModel;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class FreeCourseOnePOJO implements Serializable {
    private String course_id;

    public FreeCourseOnePOJO(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_id() {
        return this.course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }
}
