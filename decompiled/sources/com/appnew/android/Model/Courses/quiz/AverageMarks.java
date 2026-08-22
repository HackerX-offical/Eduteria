package com.appnew.android.Model.Courses.quiz;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class AverageMarks implements Serializable {
    private String avg_correct;
    private String avg_incorrect;
    private String avg_marks;
    private String avg_non_attempt;
    private String avg_time;

    public String getAvg_time() {
        return this.avg_time;
    }

    public void setAvg_time(String avg_time) {
        this.avg_time = avg_time;
    }

    public String getAvg_correct() {
        return this.avg_correct;
    }

    public void setAvg_correct(String avg_correct) {
        this.avg_correct = avg_correct;
    }

    public String getAvg_incorrect() {
        return this.avg_incorrect;
    }

    public void setAvg_incorrect(String avg_incorrect) {
        this.avg_incorrect = avg_incorrect;
    }

    public String getAvg_non_attempt() {
        return this.avg_non_attempt;
    }

    public void setAvg_non_attempt(String avg_non_attempt) {
        this.avg_non_attempt = avg_non_attempt;
    }

    public String getAvg_marks() {
        return this.avg_marks;
    }

    public void setAvg_marks(String avg_marks) {
        this.avg_marks = avg_marks;
    }
}
