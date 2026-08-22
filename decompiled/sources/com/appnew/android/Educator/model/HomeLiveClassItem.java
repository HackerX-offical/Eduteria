package com.appnew.android.Educator.model;

/* JADX INFO: loaded from: classes6.dex */
public class HomeLiveClassItem {
    int home_courseImage;
    String home_courseName;
    String home_eduName;
    String home_liveDate;
    String home_subCourseName;

    public HomeLiveClassItem(int home_courseImage, String home_courseName, String home_subCourseName, String home_liveDate, String home_eduName) {
        this.home_courseImage = home_courseImage;
        this.home_courseName = home_courseName;
        this.home_subCourseName = home_subCourseName;
        this.home_liveDate = home_liveDate;
        this.home_eduName = home_eduName;
    }

    public int getHome_courseImage() {
        return this.home_courseImage;
    }

    public void setHome_courseImage(int home_courseImage) {
        this.home_courseImage = home_courseImage;
    }

    public String getHome_courseName() {
        return this.home_courseName;
    }

    public void setHome_courseName(String home_courseName) {
        this.home_courseName = home_courseName;
    }

    public String getHome_subCourseName() {
        return this.home_subCourseName;
    }

    public void setHome_subCourseName(String home_subCourseName) {
        this.home_subCourseName = home_subCourseName;
    }

    public String getHome_liveDate() {
        return this.home_liveDate;
    }

    public void setHome_liveDate(String home_liveDate) {
        this.home_liveDate = home_liveDate;
    }

    public String getHome_eduName() {
        return this.home_eduName;
    }

    public void setHome_eduName(String home_eduName) {
        this.home_eduName = home_eduName;
    }
}
