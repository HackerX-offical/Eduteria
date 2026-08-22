package com.appnew.android.testmodule.model;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class TestSection implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    private int indexOf;

    @SerializedName("is_partial_marking")
    @Expose
    private String isPartialMarking;

    @SerializedName("is_topic_enabled")
    @Expose
    private String is_topic_enabled;

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

    @SerializedName("no_of_questions")
    private String noOfQuestion;

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

    @SerializedName("section_aliase")
    @Expose
    private String section_aliase;

    @SerializedName(Const.TIME_REMAIN)
    @Expose
    private String time_remain;

    @SerializedName("topic_alias")
    @Expose
    private String topic_alias;

    @SerializedName(Const.TOPIC_ID)
    @Expose
    private String topic_id;

    @SerializedName("topic_name")
    @Expose
    private String topic_name;

    @SerializedName("total_no_of_attempts")
    @Expose
    private String total_no_of_attempts;

    @SerializedName("total_no_of_attempts_by_section_type")
    @Expose
    private String total_no_of_attempts_by_section_type;

    public String getSection_aliase() {
        return this.section_aliase;
    }

    public void setSection_aliase(String section_aliase) {
        this.section_aliase = section_aliase;
    }

    public String getTime_remain() {
        return this.time_remain;
    }

    public void setTime_remain(String time_remain) {
        this.time_remain = time_remain;
    }

    public String getTotal_no_of_attempts() {
        return this.total_no_of_attempts;
    }

    public void setTotal_no_of_attempts(String total_no_of_attempts) {
        this.total_no_of_attempts = total_no_of_attempts;
    }

    public String getTotal_no_of_attempts_by_section_type() {
        return this.total_no_of_attempts_by_section_type;
    }

    public void setTotal_no_of_attempts_by_section_type(String total_no_of_attempts_by_section_type) {
        this.total_no_of_attempts_by_section_type = total_no_of_attempts_by_section_type;
    }

    public int getIndexOf() {
        return this.indexOf;
    }

    public void setIndexOf(int indexOf) {
        this.indexOf = indexOf;
    }

    public void setIndex(int indexOf) {
        this.indexOf = indexOf;
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

    public String getIsPartialMarking() {
        return this.isPartialMarking;
    }

    public void setIsPartialMarking(String isPartialMarking) {
        this.isPartialMarking = isPartialMarking;
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

    public String getNoOfQuestion() {
        return this.noOfQuestion;
    }

    public void setNoOfQuestion(String noOfQuestion) {
        this.noOfQuestion = noOfQuestion;
    }

    public String getTopic_id() {
        return this.topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public String getIs_topic_enabled() {
        return this.is_topic_enabled;
    }

    public void setIs_topic_enabled(String is_topic_enabled) {
        this.is_topic_enabled = is_topic_enabled;
    }

    public String getTopic_name() {
        return this.topic_name;
    }

    public void setTopic_name(String topic_name) {
        this.topic_name = topic_name;
    }

    public String getTopic_alias() {
        return this.topic_alias;
    }

    public void setTopic_alias(String topic_alias) {
        this.topic_alias = topic_alias;
    }
}
