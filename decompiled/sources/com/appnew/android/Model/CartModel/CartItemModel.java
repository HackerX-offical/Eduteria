package com.appnew.android.Model.CartModel;

import com.appnew.android.Utils.Const;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class CartItemModel implements Serializable {

    @SerializedName("app_id")
    @Expose
    private String appId;

    @SerializedName("avg_rating")
    @Expose
    private String avgRating;

    @SerializedName("course_id")
    @Expose
    private String courseId;

    @SerializedName(AnalyticsConstants.course_name)
    @Expose
    private String courseName;

    @SerializedName(Const.COURSE_PRICE)
    @Expose
    private String coursePrice;

    @SerializedName("cover_image")
    @Expose
    private String coverImage;

    @SerializedName(Const.CREATION_TIME)
    @Expose
    private String creationTime;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName(FirebaseAnalytics.Param.QUANTITY)
    @Expose
    private String quantity;

    @SerializedName("tax")
    @Expose
    private String tax;

    @SerializedName("total_price")
    @Expose
    private String totalPrice;

    @SerializedName("user_id")
    @Expose
    private String userId;

    @SerializedName("user_rated")
    @Expose
    private String user_rated;

    @SerializedName("validity")
    @Expose
    private String validity;

    public String getValidity() {
        return this.validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getUser_rated() {
        return this.user_rated;
    }

    public void setUser_rated(String user_rated) {
        this.user_rated = user_rated;
    }

    public String getTax() {
        return this.tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getCourseId() {
        return this.courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getQuantity() {
        return this.quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getCoursePrice() {
        return this.coursePrice;
    }

    public void setCoursePrice(String coursePrice) {
        this.coursePrice = coursePrice;
    }

    public String getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCreationTime() {
        return this.creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getCoverImage() {
        return this.coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getAvgRating() {
        return this.avgRating;
    }

    public void setAvgRating(String avgRating) {
        this.avgRating = avgRating;
    }
}
