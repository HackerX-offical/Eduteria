package com.appnew.android.testmodule.model;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class TestSections implements Serializable {

    @SerializedName("accuracy")
    @Expose
    private Double accuracy;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("is_partial_marking")
    @Expose
    private String isPartialMarking;

    @SerializedName("manadatory_question")
    @Expose
    private String mandatory_question;

    @SerializedName("marks_per_question")
    @Expose
    private String marksPerQuestion;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("negative_marks")
    @Expose
    private String negativeMarks;

    @SerializedName("no_of_questions")
    @Expose
    private String noOfQuestions;

    @SerializedName("optional_question")
    @Expose
    private String optional_question;

    @SerializedName("right_answered")
    @Expose
    private Integer rightAnswered;

    @SerializedName("section_cutoff")
    @Expose
    private String sectionCutoff;

    @SerializedName("section_id")
    @Expose
    private String sectionId;

    @SerializedName("section_part")
    @Expose
    private String sectionPart;

    @SerializedName("section_timing")
    @Expose
    private String sectionTiming;

    @SerializedName("section_max_mark")
    @Expose
    private String section_max_mark;

    @SerializedName(Const.TIME_SPENT)
    @Expose
    private Integer timeSpent;

    @SerializedName("total_attempt")
    @Expose
    private Integer totalAttempt;

    @SerializedName("user_marks")
    @Expose
    private float userMarks;

    public String getSection_max_mark() {
        return this.section_max_mark;
    }

    public void setSection_max_mark(String section_max_mark) {
        this.section_max_mark = section_max_mark;
    }

    public String getMandatory_question() {
        return this.mandatory_question;
    }

    public void setMandatory_question(String mandatory_question) {
        this.mandatory_question = mandatory_question;
    }

    public String getOptional_question() {
        return this.optional_question;
    }

    public void setOptional_question(String optional_question) {
        this.optional_question = optional_question;
    }

    public float getUserMarks() {
        return this.userMarks;
    }

    public void setUserMarks(float userMarks) {
        this.userMarks = userMarks;
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

    public String getMarksPerQuestion() {
        return this.marksPerQuestion;
    }

    public void setMarksPerQuestion(String marksPerQuestion) {
        this.marksPerQuestion = marksPerQuestion;
    }

    public String getIsPartialMarking() {
        return this.isPartialMarking;
    }

    public void setIsPartialMarking(String isPartialMarking) {
        this.isPartialMarking = isPartialMarking;
    }

    public String getNoOfQuestions() {
        return this.noOfQuestions;
    }

    public void setNoOfQuestions(String noOfQuestions) {
        this.noOfQuestions = noOfQuestions;
    }

    public String getNegativeMarks() {
        return this.negativeMarks;
    }

    public void setNegativeMarks(String negativeMarks) {
        this.negativeMarks = negativeMarks;
    }

    public String getSectionCutoff() {
        return this.sectionCutoff;
    }

    public void setSectionCutoff(String sectionCutoff) {
        this.sectionCutoff = sectionCutoff;
    }

    public Integer getRightAnswered() {
        return this.rightAnswered;
    }

    public void setRightAnswered(Integer rightAnswered) {
        this.rightAnswered = rightAnswered;
    }

    public Integer getTotalAttempt() {
        return this.totalAttempt;
    }

    public void setTotalAttempt(Integer totalAttempt) {
        this.totalAttempt = totalAttempt;
    }

    public Integer getTimeSpent() {
        return this.timeSpent;
    }

    public void setTimeSpent(Integer timeSpent) {
        this.timeSpent = timeSpent;
    }

    public Double getAccuracy() {
        return this.accuracy;
    }

    public void setAccuracy(Double accuracy) {
        this.accuracy = accuracy;
    }
}
