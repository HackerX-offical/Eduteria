package com.appnew.android.Model.Courses;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class CoursesData implements Serializable {
    private CourseCategory category_info;
    private ArrayList<Course> course_list;

    public CourseCategory getCategory_info() {
        return this.category_info;
    }

    public void setCategory_info(CourseCategory category_info) {
        this.category_info = category_info;
    }

    public ArrayList<Course> getCourse_list() {
        return this.course_list;
    }

    public void setCourse_list(ArrayList<Course> course_list) {
        this.course_list = course_list;
    }
}
