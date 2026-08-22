package com.appnew.android.Model;

import com.appnew.android.Utils.Const;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.razorpay.CheckoutConstants;

/* JADX INFO: loaded from: classes6.dex */
public class VideoResData {

    @SerializedName("allow_comments")
    @Expose
    private String allowComments;

    @SerializedName("author_name")
    @Expose
    private String authorName;

    @SerializedName("comments")
    @Expose
    private String comments;

    @SerializedName(Const.CREATION_TIME)
    @Expose
    private String creationTime;

    @SerializedName(FirebaseAnalytics.Param.END_DATE)
    @Expose
    private String endDate;

    @SerializedName("featured")
    @Expose
    private String featured;

    @SerializedName("for_dams")
    @Expose
    private String forDams;

    @SerializedName("for_non_dams")
    @Expose
    private String forNonDams;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("initial_view")
    @Expose
    private String initialView;

    @SerializedName("is_like")
    @Expose
    private String isLike;

    @SerializedName("is_new")
    @Expose
    private String isNew;

    @SerializedName("is_viewed")
    @Expose
    private String isViewed;

    @SerializedName("likes")
    @Expose
    private String likes;

    @SerializedName(Const.CAT_ID)
    @Expose
    private String mainCat;

    @SerializedName("screen_tag")
    @Expose
    private String screenTag;

    @SerializedName(FirebaseAnalytics.Param.START_DATE)
    @Expose
    private String startDate;

    @SerializedName("state")
    @Expose
    private String state;

    @SerializedName(Const.SUB_CAT)
    @Expose
    private String subCat;

    @SerializedName("tags")
    @Expose
    private String tags;

    @SerializedName("thumbnail_url")
    @Expose
    private String thumbnailUrl;

    @SerializedName(CheckoutConstants.URL)
    @Expose
    private String uRL;

    @SerializedName("video_desc")
    @Expose
    private String videoDesc;

    @SerializedName("video_title")
    @Expose
    private String videoTitle;

    @SerializedName(Const.VIDEO_TYPE)
    @Expose
    private String videoType;

    @SerializedName(Const.VIEWS)
    @Expose
    private String views;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVideoTitle() {
        return this.videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoType() {
        return this.videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    public String getURL() {
        return this.uRL;
    }

    public void setURL(String uRL) {
        this.uRL = uRL;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getVideoDesc() {
        return this.videoDesc;
    }

    public void setVideoDesc(String videoDesc) {
        this.videoDesc = videoDesc;
    }

    public String getMainCat() {
        return this.mainCat;
    }

    public void setMainCat(String mainCat) {
        this.mainCat = mainCat;
    }

    public String getSubCat() {
        return this.subCat;
    }

    public void setSubCat(String subCat) {
        this.subCat = subCat;
    }

    public String getTags() {
        return this.tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getInitialView() {
        return this.initialView;
    }

    public void setInitialView(String initialView) {
        this.initialView = initialView;
    }

    public String getScreenTag() {
        return this.screenTag;
    }

    public void setScreenTag(String screenTag) {
        this.screenTag = screenTag;
    }

    public String getFeatured() {
        return this.featured;
    }

    public void setFeatured(String featured) {
        this.featured = featured;
    }

    public String getAllowComments() {
        return this.allowComments;
    }

    public void setAllowComments(String allowComments) {
        this.allowComments = allowComments;
    }

    public String getIsNew() {
        return this.isNew;
    }

    public void setIsNew(String isNew) {
        this.isNew = isNew;
    }

    public String getForDams() {
        return this.forDams;
    }

    public void setForDams(String forDams) {
        this.forDams = forDams;
    }

    public String getForNonDams() {
        return this.forNonDams;
    }

    public void setForNonDams(String forNonDams) {
        this.forNonDams = forNonDams;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getViews() {
        return this.views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getLikes() {
        return this.likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getCreationTime() {
        return this.creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIsLike() {
        return this.isLike;
    }

    public void setIsLike(String isLike) {
        this.isLike = isLike;
    }

    public String getIsViewed() {
        return this.isViewed;
    }

    public void setIsViewed(String isViewed) {
        this.isViewed = isViewed;
    }
}
