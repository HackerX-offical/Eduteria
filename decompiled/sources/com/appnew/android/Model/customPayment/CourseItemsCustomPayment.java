package com.appnew.android.Model.customPayment;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class CourseItemsCustomPayment implements Serializable {

    @SerializedName("course_learner")
    private String courseLearner;

    @SerializedName("course_rating_count")
    private String courseRatingCount;

    @SerializedName("course_review_count")
    private String courseReviewCount;

    @SerializedName("course_sp")
    private String courseSp;

    @SerializedName("cover_image")
    private String coverImage;

    @SerializedName(Const.DELIVERY_CHARGE)
    private String deliveryCharge;

    @SerializedName("desc_header_image")
    private String descHeaderImage;

    @SerializedName("description")
    private String description;

    @SerializedName("gst")
    private String gst;

    @SerializedName("id")
    private String id;

    @SerializedName(Const.IS_COMBO)
    private String isCombo;

    @SerializedName("lang_id")
    private String langId;

    @SerializedName("mrp")
    private String mrp;

    @SerializedName(Const.SUBJECT_ID)
    private String subjectId;

    @SerializedName("title")
    private String title;

    @SerializedName("validity")
    private String validity;

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectId() {
        return this.subjectId;
    }

    public void setCourseReviewCount(String courseReviewCount) {
        this.courseReviewCount = courseReviewCount;
    }

    public String getCourseReviewCount() {
        return this.courseReviewCount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    public String getGst() {
        return this.gst;
    }

    public void setLangId(String langId) {
        this.langId = langId;
    }

    public String getLangId() {
        return this.langId;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public String getMrp() {
        return this.mrp;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setDescHeaderImage(String descHeaderImage) {
        this.descHeaderImage = descHeaderImage;
    }

    public String getDescHeaderImage() {
        return this.descHeaderImage;
    }

    public void setIsCombo(String isCombo) {
        this.isCombo = isCombo;
    }

    public String getIsCombo() {
        return this.isCombo;
    }

    public void setDeliveryCharge(String deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public String getDeliveryCharge() {
        return this.deliveryCharge;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getCoverImage() {
        return this.coverImage;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getValidity() {
        return this.validity;
    }

    public void setCourseLearner(String courseLearner) {
        this.courseLearner = courseLearner;
    }

    public String getCourseLearner() {
        return this.courseLearner;
    }

    public void setCourseRatingCount(String courseRatingCount) {
        this.courseRatingCount = courseRatingCount;
    }

    public String getCourseRatingCount() {
        return this.courseRatingCount;
    }

    public void setCourseSp(String courseSp) {
        this.courseSp = courseSp;
    }

    public String getCourseSp() {
        return this.courseSp;
    }
}
