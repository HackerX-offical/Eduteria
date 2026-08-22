package com.appnew.android.testmodule.model;

import com.appnew.android.Model.PrizeCourselist;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class Prize {
    public ArrayList<PrizeCourselist> courses;
    String physical;

    public String getPhysical() {
        return this.physical;
    }

    public void setPhysical(String physical) {
        this.physical = physical;
    }

    public ArrayList<PrizeCourselist> getCourses() {
        return this.courses;
    }

    public void setCourses(ArrayList<PrizeCourselist> courses) {
        this.courses = courses;
    }
}
