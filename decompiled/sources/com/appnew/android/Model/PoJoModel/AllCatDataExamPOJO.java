package com.appnew.android.Model.PoJoModel;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class AllCatDataExamPOJO implements Serializable {
    private String course_type;
    private String main_cat;
    private String study_type;
    private String sub_cat;

    public AllCatDataExamPOJO(String course_type, String main_cat, String sub_cat, String study_type) {
        this.course_type = course_type;
        this.main_cat = main_cat;
        this.sub_cat = sub_cat;
        this.study_type = study_type;
    }

    public String getCourse_type() {
        return this.course_type;
    }

    public void setCourse_type(String course_type) {
        this.course_type = course_type;
    }

    public String getMain_cat() {
        return this.main_cat;
    }

    public void setMain_cat(String main_cat) {
        this.main_cat = main_cat;
    }

    public String getSub_cat() {
        return this.sub_cat;
    }

    public void setSub_cat(String sub_cat) {
        this.sub_cat = sub_cat;
    }

    public String getStudy_type() {
        return this.study_type;
    }

    public void setStudy_type(String study_type) {
        this.study_type = study_type;
    }
}
