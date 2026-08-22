package com.appnew.android.Educator.model;

/* JADX INFO: loaded from: classes6.dex */
public class EducatorItem {
    private boolean isCourse;
    private boolean isLiveClass;
    String itemText;

    public EducatorItem(String itemText, boolean isCourse, boolean isLiveClass) {
        this.itemText = itemText;
        this.isCourse = isCourse;
        this.isLiveClass = isLiveClass;
    }

    public String getItemText() {
        return this.itemText;
    }

    public void setItemText(String itemText) {
        this.itemText = itemText;
    }

    public boolean isCourse() {
        return this.isCourse;
    }

    public void setCourse(boolean course) {
        this.isCourse = course;
    }

    public boolean isLiveClass() {
        return this.isLiveClass;
    }

    public void setLiveClass(boolean liveClass) {
        this.isLiveClass = liveClass;
    }
}
