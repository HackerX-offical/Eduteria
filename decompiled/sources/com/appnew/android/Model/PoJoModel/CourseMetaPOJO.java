package com.appnew.android.Model.PoJoModel;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class CourseMetaPOJO implements Serializable {
    private String course_id;
    private int page;
    private String study_type;
    private String tag_type;
    private String user_id;

    public CourseMetaPOJO(String user_id, String course_id, String study_type, String tag_type, int page) {
        this.user_id = user_id;
        this.course_id = course_id;
        this.study_type = study_type;
        this.tag_type = tag_type;
        this.page = page;
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

    public String getStudy_type() {
        return this.study_type;
    }

    public void setStudy_type(String study_type) {
        this.study_type = study_type;
    }

    public String getTag_type() {
        return this.tag_type;
    }

    public void setTag_type(String tag_type) {
        this.tag_type = tag_type;
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
