package com.appnew.android.table;

/* JADX INFO: loaded from: classes6.dex */
public class TestResumeTable {
    private String courseDescription;
    private String courseName;
    private int id;
    private int lastPosition;
    private String remaining_time;
    private String user_id;

    public String getRemaining_time() {
        return this.remaining_time;
    }

    public void setRemaining_time(String remaining_time) {
        this.remaining_time = remaining_time;
    }

    public int getLastPosition() {
        return this.lastPosition;
    }

    public void setLastPosition(int lastPosition) {
        this.lastPosition = lastPosition;
    }

    public TestResumeTable(String user_id, String courseName, int lastPosition, String remaining_time, String courseDescription) {
        this.user_id = user_id;
        this.courseName = courseName;
        this.lastPosition = lastPosition;
        this.remaining_time = remaining_time;
        this.courseDescription = courseDescription;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCourseDescription() {
        return this.courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
