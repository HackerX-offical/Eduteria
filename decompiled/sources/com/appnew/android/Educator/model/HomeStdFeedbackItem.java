package com.appnew.android.Educator.model;

/* JADX INFO: loaded from: classes6.dex */
public class HomeStdFeedbackItem {
    public String feedbackText;
    public int teacherImage;
    public String teacherName;

    public HomeStdFeedbackItem(String feedbackText, String teacherName, int teacherImage) {
        this.feedbackText = feedbackText;
        this.teacherName = teacherName;
        this.teacherImage = teacherImage;
    }

    public String getFeedbackText() {
        return this.feedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    public String getTeacherName() {
        return this.teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getTeacherImage() {
        return this.teacherImage;
    }

    public void setTeacherImage(int teacherImage) {
        this.teacherImage = teacherImage;
    }
}
