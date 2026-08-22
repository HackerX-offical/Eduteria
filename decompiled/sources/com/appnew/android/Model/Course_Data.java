package com.appnew.android.Model;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class Course_Data implements Serializable {
    private Categoryinfo category_info;
    private ArrayList<Courselist> course_list;

    public Categoryinfo getCategory_info() {
        return this.category_info;
    }

    public void setCategory_info(Categoryinfo category_info) {
        this.category_info = category_info;
    }

    public ArrayList<Courselist> getCourse_list() {
        return this.course_list;
    }

    public void setCourse_list(ArrayList<Courselist> course_list) {
        this.course_list = course_list;
    }

    public Course_Data(Categoryinfo category_info) {
        this.category_info = category_info;
    }
}
