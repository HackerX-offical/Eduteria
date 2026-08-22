package com.appnew.android.testmodule.model;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class CutOff implements Serializable {

    @SerializedName("right_answered")
    @Expose
    private Integer rightAnswered;

    @SerializedName("section_cutoff")
    @Expose
    private String sectionCutoff;

    @SerializedName("section_id")
    @Expose
    private String sectionId;

    @SerializedName("section_name")
    @Expose
    private String sectionName;

    @SerializedName(Const.TIME_SPENT)
    @Expose
    private Integer timeSpent;

    @SerializedName("total_attempt")
    @Expose
    private Integer totalAttempt;

    @SerializedName("user_marks")
    @Expose
    private float userMarks;

    public void setUserMarks(float userMarks) {
        this.userMarks = userMarks;
    }

    public String getSectionId() {
        return this.sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public Integer getTotalAttempt() {
        return this.totalAttempt;
    }

    public void setTotalAttempt(Integer totalAttempt) {
        this.totalAttempt = totalAttempt;
    }

    public Integer getRightAnswered() {
        return this.rightAnswered;
    }

    public void setRightAnswered(Integer rightAnswered) {
        this.rightAnswered = rightAnswered;
    }

    public Integer getTimeSpent() {
        return this.timeSpent;
    }

    public void setTimeSpent(Integer timeSpent) {
        this.timeSpent = timeSpent;
    }

    public String getSectionCutoff() {
        return this.sectionCutoff;
    }

    public void setSectionCutoff(String sectionCutoff) {
        this.sectionCutoff = sectionCutoff;
    }

    public String getSectionName() {
        return this.sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }
}
