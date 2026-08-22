package com.appnew.android.testmodule.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class TestSectionInst implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("marks_per_question")
    @Expose
    private String marksPerQuestion;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("name_2")
    @Expose
    private String name2;

    @SerializedName("negative_marks")
    @Expose
    private String negativeMarks;

    @SerializedName("section_id")
    @Expose
    private String sectionId;

    @SerializedName("section_part")
    @Expose
    private String sectionPart;

    @SerializedName("section_timing")
    @Expose
    private String sectionTiming;

    @SerializedName("section_aliase")
    @Expose
    private String section_aliase;

    @SerializedName("total_no_of_attempts")
    @Expose
    private String totalNumOfAttempts;

    @SerializedName("total_questions")
    @Expose
    private String totalQuestions;

    public String getSection_aliase() {
        return this.section_aliase;
    }

    public void setSection_aliase(String section_aliase) {
        this.section_aliase = section_aliase;
    }

    public TestSectionInst(String id, String sectionId, String sectionPart, String sectionTiming, String name, String name2, String marksPerQuestion, String negativeMarks, String totalQuestions, String totalNumOfAttempts) {
        this.id = id;
        this.sectionId = sectionId;
        this.sectionPart = sectionPart;
        this.sectionTiming = sectionTiming;
        this.name = name;
        this.name2 = name2;
        this.marksPerQuestion = marksPerQuestion;
        this.negativeMarks = negativeMarks;
        this.totalQuestions = totalQuestions;
        this.totalNumOfAttempts = totalNumOfAttempts;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSectionId() {
        return this.sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionPart() {
        return this.sectionPart;
    }

    public void setSectionPart(String sectionPart) {
        this.sectionPart = sectionPart;
    }

    public String getSectionTiming() {
        return this.sectionTiming;
    }

    public void setSectionTiming(String sectionTiming) {
        this.sectionTiming = sectionTiming;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName2() {
        return this.name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getMarksPerQuestion() {
        return this.marksPerQuestion;
    }

    public void setMarksPerQuestion(String marksPerQuestion) {
        this.marksPerQuestion = marksPerQuestion;
    }

    public String getNegativeMarks() {
        return this.negativeMarks;
    }

    public void setNegativeMarks(String negativeMarks) {
        this.negativeMarks = negativeMarks;
    }

    public String getTotalQuestions() {
        return this.totalQuestions;
    }

    public void setTotalQuestions(String totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public String getTotalNumOfAttempts() {
        return this.totalNumOfAttempts;
    }

    public void setTotalNumOfAttempts(String totalNumOfAttempts) {
        this.totalNumOfAttempts = totalNumOfAttempts;
    }
}
