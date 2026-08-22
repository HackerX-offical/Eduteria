package com.appnew.android.Model.TestseriesBase;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class Section implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("marks_per_question")
    @Expose
    private String marksPerQuestion;

    @SerializedName("no_of_questions")
    @Expose
    private String noOfQuestions;

    @SerializedName("section_id")
    @Expose
    private String sectionId;

    @SerializedName("section_timing")
    @Expose
    private String sectionTiming;

    @SerializedName("section_title")
    @Expose
    private String sectionTitle;

    @SerializedName(Const.TESTSERIES_ID)
    @Expose
    private String testSeriesId;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSectionTitle() {
        return this.sectionTitle;
    }

    public void setSectionTitle(String sectionTitle) {
        this.sectionTitle = sectionTitle;
    }

    public String getTestSeriesId() {
        return this.testSeriesId;
    }

    public void setTestSeriesId(String testSeriesId) {
        this.testSeriesId = testSeriesId;
    }

    public String getSectionId() {
        return this.sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getNoOfQuestions() {
        return this.noOfQuestions;
    }

    public void setNoOfQuestions(String noOfQuestions) {
        this.noOfQuestions = noOfQuestions;
    }

    public String getSectionTiming() {
        return this.sectionTiming;
    }

    public void setSectionTiming(String sectionTiming) {
        this.sectionTiming = sectionTiming;
    }

    public String getMarksPerQuestion() {
        return this.marksPerQuestion;
    }

    public void setMarksPerQuestion(String marksPerQuestion) {
        this.marksPerQuestion = marksPerQuestion;
    }
}
