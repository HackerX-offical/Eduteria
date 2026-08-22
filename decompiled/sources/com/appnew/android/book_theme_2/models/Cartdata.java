package com.appnew.android.book_theme_2.models;

import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import com.tv9news.utils.helpers.AnalyticsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CartItemBook.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b:\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0010HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J©\u0001\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0003HÆ\u0001J\u0013\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010M\u001a\u00020\u0010HÖ\u0001J\t\u0010N\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0017\"\u0004\b'\u0010\u0019R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0017\"\u0004\b(\u0010\u0019R\u001e\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0017\"\u0004\b*\u0010\u0019R\u001e\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0017\"\u0004\b,\u0010\u0019R\u001e\u0010\u000e\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0017\"\u0004\b.\u0010\u0019R\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001e\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0017\"\u0004\b4\u0010\u0019R\u001e\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0017\"\u0004\b6\u0010\u0019R\u001e\u0010\u0013\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0017\"\u0004\b8\u0010\u0019¨\u0006O"}, d2 = {"Lcom/appnew/android/book_theme_2/models/Cartdata;", "", "appId", "", "avgRating", "courseId", "courseName", "coursePrice", "coverImage", "creationTime", "id", "isGst", FirebaseAnalytics.Param.QUANTITY, "tax", "taxRate", "totalPrice", "", "userId", "userRated", "validity", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "getAvgRating", "setAvgRating", "getCourseId", "setCourseId", "getCourseName", "setCourseName", "getCoursePrice", "setCoursePrice", "getCoverImage", "setCoverImage", "getCreationTime", "setCreationTime", "getId", "setId", "setGst", "getQuantity", "setQuantity", "getTax", "setTax", "getTaxRate", "setTaxRate", "getTotalPrice", "()I", "setTotalPrice", "(I)V", "getUserId", "setUserId", "getUserRated", "setUserRated", "getValidity", "setValidity", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", Constants.COPY_TYPE, "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Cartdata {
    public static final int $stable = 8;

    @SerializedName("app_id")
    private String appId;

    @SerializedName("avg_rating")
    private String avgRating;

    @SerializedName("course_id")
    private String courseId;

    @SerializedName(AnalyticsConstants.course_name)
    private String courseName;

    @SerializedName(Const.COURSE_PRICE)
    private String coursePrice;

    @SerializedName("cover_image")
    private String coverImage;

    @SerializedName(Const.CREATION_TIME)
    private String creationTime;

    @SerializedName("id")
    private String id;

    @SerializedName("is_gst")
    private String isGst;

    @SerializedName(FirebaseAnalytics.Param.QUANTITY)
    private String quantity;

    @SerializedName("tax")
    private String tax;

    @SerializedName("tax_rate")
    private String taxRate;

    @SerializedName("total_price")
    private int totalPrice;

    @SerializedName("user_id")
    private String userId;

    @SerializedName("user_rated")
    private String userRated;

    @SerializedName("validity")
    private String validity;

    public static /* synthetic */ Cartdata copy$default(Cartdata cartdata, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, int i, String str13, String str14, String str15, int i2, Object obj) {
        String str16 = (i2 & 1) != 0 ? cartdata.appId : str;
        return cartdata.copy(str16, (i2 & 2) != 0 ? cartdata.avgRating : str2, (i2 & 4) != 0 ? cartdata.courseId : str3, (i2 & 8) != 0 ? cartdata.courseName : str4, (i2 & 16) != 0 ? cartdata.coursePrice : str5, (i2 & 32) != 0 ? cartdata.coverImage : str6, (i2 & 64) != 0 ? cartdata.creationTime : str7, (i2 & 128) != 0 ? cartdata.id : str8, (i2 & 256) != 0 ? cartdata.isGst : str9, (i2 & 512) != 0 ? cartdata.quantity : str10, (i2 & 1024) != 0 ? cartdata.tax : str11, (i2 & 2048) != 0 ? cartdata.taxRate : str12, (i2 & 4096) != 0 ? cartdata.totalPrice : i, (i2 & 8192) != 0 ? cartdata.userId : str13, (i2 & 16384) != 0 ? cartdata.userRated : str14, (i2 & 32768) != 0 ? cartdata.validity : str15);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getQuantity() {
        return this.quantity;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getTax() {
        return this.tax;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getTaxRate() {
        return this.taxRate;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getTotalPrice() {
        return this.totalPrice;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getUserRated() {
        return this.userRated;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getValidity() {
        return this.validity;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAvgRating() {
        return this.avgRating;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCourseId() {
        return this.courseId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCourseName() {
        return this.courseName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getCoursePrice() {
        return this.coursePrice;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCoverImage() {
        return this.coverImage;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getCreationTime() {
        return this.creationTime;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getIsGst() {
        return this.isGst;
    }

    public final Cartdata copy(String appId, String avgRating, String courseId, String courseName, String coursePrice, String coverImage, String creationTime, String id, String isGst, String quantity, String tax, String taxRate, int totalPrice, String userId, String userRated, String validity) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(avgRating, "avgRating");
        Intrinsics.checkNotNullParameter(courseId, "courseId");
        Intrinsics.checkNotNullParameter(courseName, "courseName");
        Intrinsics.checkNotNullParameter(coursePrice, "coursePrice");
        Intrinsics.checkNotNullParameter(coverImage, "coverImage");
        Intrinsics.checkNotNullParameter(creationTime, "creationTime");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(isGst, "isGst");
        Intrinsics.checkNotNullParameter(quantity, "quantity");
        Intrinsics.checkNotNullParameter(tax, "tax");
        Intrinsics.checkNotNullParameter(taxRate, "taxRate");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(userRated, "userRated");
        Intrinsics.checkNotNullParameter(validity, "validity");
        return new Cartdata(appId, avgRating, courseId, courseName, coursePrice, coverImage, creationTime, id, isGst, quantity, tax, taxRate, totalPrice, userId, userRated, validity);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Cartdata)) {
            return false;
        }
        Cartdata cartdata = (Cartdata) other;
        return Intrinsics.areEqual(this.appId, cartdata.appId) && Intrinsics.areEqual(this.avgRating, cartdata.avgRating) && Intrinsics.areEqual(this.courseId, cartdata.courseId) && Intrinsics.areEqual(this.courseName, cartdata.courseName) && Intrinsics.areEqual(this.coursePrice, cartdata.coursePrice) && Intrinsics.areEqual(this.coverImage, cartdata.coverImage) && Intrinsics.areEqual(this.creationTime, cartdata.creationTime) && Intrinsics.areEqual(this.id, cartdata.id) && Intrinsics.areEqual(this.isGst, cartdata.isGst) && Intrinsics.areEqual(this.quantity, cartdata.quantity) && Intrinsics.areEqual(this.tax, cartdata.tax) && Intrinsics.areEqual(this.taxRate, cartdata.taxRate) && this.totalPrice == cartdata.totalPrice && Intrinsics.areEqual(this.userId, cartdata.userId) && Intrinsics.areEqual(this.userRated, cartdata.userRated) && Intrinsics.areEqual(this.validity, cartdata.validity);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((this.appId.hashCode() * 31) + this.avgRating.hashCode()) * 31) + this.courseId.hashCode()) * 31) + this.courseName.hashCode()) * 31) + this.coursePrice.hashCode()) * 31) + this.coverImage.hashCode()) * 31) + this.creationTime.hashCode()) * 31) + this.id.hashCode()) * 31) + this.isGst.hashCode()) * 31) + this.quantity.hashCode()) * 31) + this.tax.hashCode()) * 31) + this.taxRate.hashCode()) * 31) + Integer.hashCode(this.totalPrice)) * 31) + this.userId.hashCode()) * 31) + this.userRated.hashCode()) * 31) + this.validity.hashCode();
    }

    public String toString() {
        return "Cartdata(appId=" + this.appId + ", avgRating=" + this.avgRating + ", courseId=" + this.courseId + ", courseName=" + this.courseName + ", coursePrice=" + this.coursePrice + ", coverImage=" + this.coverImage + ", creationTime=" + this.creationTime + ", id=" + this.id + ", isGst=" + this.isGst + ", quantity=" + this.quantity + ", tax=" + this.tax + ", taxRate=" + this.taxRate + ", totalPrice=" + this.totalPrice + ", userId=" + this.userId + ", userRated=" + this.userRated + ", validity=" + this.validity + ")";
    }

    public Cartdata(String appId, String avgRating, String courseId, String courseName, String coursePrice, String coverImage, String creationTime, String id, String isGst, String quantity, String tax, String taxRate, int i, String userId, String userRated, String validity) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(avgRating, "avgRating");
        Intrinsics.checkNotNullParameter(courseId, "courseId");
        Intrinsics.checkNotNullParameter(courseName, "courseName");
        Intrinsics.checkNotNullParameter(coursePrice, "coursePrice");
        Intrinsics.checkNotNullParameter(coverImage, "coverImage");
        Intrinsics.checkNotNullParameter(creationTime, "creationTime");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(isGst, "isGst");
        Intrinsics.checkNotNullParameter(quantity, "quantity");
        Intrinsics.checkNotNullParameter(tax, "tax");
        Intrinsics.checkNotNullParameter(taxRate, "taxRate");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(userRated, "userRated");
        Intrinsics.checkNotNullParameter(validity, "validity");
        this.appId = appId;
        this.avgRating = avgRating;
        this.courseId = courseId;
        this.courseName = courseName;
        this.coursePrice = coursePrice;
        this.coverImage = coverImage;
        this.creationTime = creationTime;
        this.id = id;
        this.isGst = isGst;
        this.quantity = quantity;
        this.tax = tax;
        this.taxRate = taxRate;
        this.totalPrice = i;
        this.userId = userId;
        this.userRated = userRated;
        this.validity = validity;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final void setAppId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appId = str;
    }

    public final String getAvgRating() {
        return this.avgRating;
    }

    public final void setAvgRating(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.avgRating = str;
    }

    public final String getCourseId() {
        return this.courseId;
    }

    public final void setCourseId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.courseId = str;
    }

    public final String getCourseName() {
        return this.courseName;
    }

    public final void setCourseName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.courseName = str;
    }

    public final String getCoursePrice() {
        return this.coursePrice;
    }

    public final void setCoursePrice(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.coursePrice = str;
    }

    public final String getCoverImage() {
        return this.coverImage;
    }

    public final void setCoverImage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.coverImage = str;
    }

    public final String getCreationTime() {
        return this.creationTime;
    }

    public final void setCreationTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.creationTime = str;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final String isGst() {
        return this.isGst;
    }

    public final void setGst(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.isGst = str;
    }

    public final String getQuantity() {
        return this.quantity;
    }

    public final void setQuantity(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.quantity = str;
    }

    public final String getTax() {
        return this.tax;
    }

    public final void setTax(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tax = str;
    }

    public final String getTaxRate() {
        return this.taxRate;
    }

    public final void setTaxRate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.taxRate = str;
    }

    public final int getTotalPrice() {
        return this.totalPrice;
    }

    public final void setTotalPrice(int i) {
        this.totalPrice = i;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userId = str;
    }

    public final String getUserRated() {
        return this.userRated;
    }

    public final void setUserRated(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userRated = str;
    }

    public final String getValidity() {
        return this.validity;
    }

    public final void setValidity(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.validity = str;
    }
}
