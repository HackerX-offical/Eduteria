package com.appnew.android.home.model.bannerHomeData;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class BannerData implements Serializable {

    @SerializedName("banner_title")
    @Expose
    private String bannerTitle;

    @SerializedName("button_text")
    @Expose
    private String buttonText;

    @SerializedName("course_link")
    @Expose
    private String courseLink;

    @SerializedName(Const.CREATION_TIME)
    @Expose
    private String creationTime;

    @SerializedName("feed_type")
    @Expose
    private String feedType;

    @SerializedName("from_date")
    @Expose
    private String fromDate;

    @SerializedName("hit_count")
    @Expose
    private String hitCount;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("image_link")
    @Expose
    private String imageLink;

    @SerializedName("link_level")
    @Expose
    private String linkLevel;

    @SerializedName("priority")
    @Expose
    private String priority;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("stude_type_detail")
    @Expose
    private String studeTypeDetail;

    @SerializedName(Const.STUDY_TYPE)
    @Expose
    private String studyType;

    @SerializedName("text")
    @Expose
    private String text;

    @SerializedName("to_date")
    @Expose
    private String toDate;

    @SerializedName("type_link")
    @Expose
    private String typeLink;

    @SerializedName("web_link")
    @Expose
    private String webLink;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageLink() {
        return this.imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getWebLink() {
        return this.webLink;
    }

    public void setWebLink(String webLink) {
        this.webLink = webLink;
    }

    public String getCourseLink() {
        return this.courseLink;
    }

    public void setCourseLink(String courseLink) {
        this.courseLink = courseLink;
    }

    public String getStudyType() {
        return this.studyType;
    }

    public void setStudyType(String studyType) {
        this.studyType = studyType;
    }

    public String getStudeTypeDetail() {
        return this.studeTypeDetail;
    }

    public void setStudeTypeDetail(String studeTypeDetail) {
        this.studeTypeDetail = studeTypeDetail;
    }

    public String getFeedType() {
        return this.feedType;
    }

    public void setFeedType(String feedType) {
        this.feedType = feedType;
    }

    public String getLinkLevel() {
        return this.linkLevel;
    }

    public void setLinkLevel(String linkLevel) {
        this.linkLevel = linkLevel;
    }

    public String getTypeLink() {
        return this.typeLink;
    }

    public void setTypeLink(String typeLink) {
        this.typeLink = typeLink;
    }

    public String getButtonText() {
        return this.buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreationTime() {
        return this.creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getFromDate() {
        return this.fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return this.toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getBannerTitle() {
        return this.bannerTitle;
    }

    public void setBannerTitle(String bannerTitle) {
        this.bannerTitle = bannerTitle;
    }

    public String getHitCount() {
        return this.hitCount;
    }

    public void setHitCount(String hitCount) {
        this.hitCount = hitCount;
    }

    public String getPriority() {
        return this.priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
