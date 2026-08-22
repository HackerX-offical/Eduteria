package com.appnew.android.home.model;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExtraVideoType.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\r\"\u0004\b\u001a\u0010\u000f¨\u0006*"}, d2 = {"Lcom/appnew/android/home/model/ExtraParams;", "Ljava/io/Serializable;", "demoPercent", "", "videoTypeFile", "videotoken", "feedbackVideo", "floatingNumber", "vodChat", "isLimited", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDemoPercent", "()Ljava/lang/String;", "setDemoPercent", "(Ljava/lang/String;)V", "getVideoTypeFile", "setVideoTypeFile", "getVideotoken", "setVideotoken", "getFeedbackVideo", "setFeedbackVideo", "getFloatingNumber", "setFloatingNumber", "getVodChat", "setVodChat", "setLimited", "component1", "component2", "component3", "component4", "component5", "component6", "component7", Constants.COPY_TYPE, "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ExtraParams implements Serializable {
    public static final int $stable = 8;

    @SerializedName("demo_percent")
    private String demoPercent;

    @SerializedName("feedback_video")
    private String feedbackVideo;

    @SerializedName("floating_number")
    private String floatingNumber;

    @SerializedName("is_limited")
    private String isLimited;

    @SerializedName("video_type_file")
    private String videoTypeFile;

    @SerializedName("videotoken")
    private String videotoken;

    @SerializedName("vod_chat")
    private String vodChat;

    public ExtraParams() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ ExtraParams copy$default(ExtraParams extraParams, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = extraParams.demoPercent;
        }
        if ((i & 2) != 0) {
            str2 = extraParams.videoTypeFile;
        }
        if ((i & 4) != 0) {
            str3 = extraParams.videotoken;
        }
        if ((i & 8) != 0) {
            str4 = extraParams.feedbackVideo;
        }
        if ((i & 16) != 0) {
            str5 = extraParams.floatingNumber;
        }
        if ((i & 32) != 0) {
            str6 = extraParams.vodChat;
        }
        if ((i & 64) != 0) {
            str7 = extraParams.isLimited;
        }
        String str8 = str6;
        String str9 = str7;
        String str10 = str5;
        String str11 = str3;
        return extraParams.copy(str, str2, str11, str4, str10, str8, str9);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDemoPercent() {
        return this.demoPercent;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getVideoTypeFile() {
        return this.videoTypeFile;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getVideotoken() {
        return this.videotoken;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getFeedbackVideo() {
        return this.feedbackVideo;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getFloatingNumber() {
        return this.floatingNumber;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getVodChat() {
        return this.vodChat;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getIsLimited() {
        return this.isLimited;
    }

    public final ExtraParams copy(String demoPercent, String videoTypeFile, String videotoken, String feedbackVideo, String floatingNumber, String vodChat, String isLimited) {
        return new ExtraParams(demoPercent, videoTypeFile, videotoken, feedbackVideo, floatingNumber, vodChat, isLimited);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExtraParams)) {
            return false;
        }
        ExtraParams extraParams = (ExtraParams) other;
        return Intrinsics.areEqual(this.demoPercent, extraParams.demoPercent) && Intrinsics.areEqual(this.videoTypeFile, extraParams.videoTypeFile) && Intrinsics.areEqual(this.videotoken, extraParams.videotoken) && Intrinsics.areEqual(this.feedbackVideo, extraParams.feedbackVideo) && Intrinsics.areEqual(this.floatingNumber, extraParams.floatingNumber) && Intrinsics.areEqual(this.vodChat, extraParams.vodChat) && Intrinsics.areEqual(this.isLimited, extraParams.isLimited);
    }

    public int hashCode() {
        String str = this.demoPercent;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.videoTypeFile;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.videotoken;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.feedbackVideo;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.floatingNumber;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.vodChat;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.isLimited;
        return iHashCode6 + (str7 != null ? str7.hashCode() : 0);
    }

    public String toString() {
        return "ExtraParams(demoPercent=" + this.demoPercent + ", videoTypeFile=" + this.videoTypeFile + ", videotoken=" + this.videotoken + ", feedbackVideo=" + this.feedbackVideo + ", floatingNumber=" + this.floatingNumber + ", vodChat=" + this.vodChat + ", isLimited=" + this.isLimited + ")";
    }

    public ExtraParams(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.demoPercent = str;
        this.videoTypeFile = str2;
        this.videotoken = str3;
        this.feedbackVideo = str4;
        this.floatingNumber = str5;
        this.vodChat = str6;
        this.isLimited = str7;
    }

    public /* synthetic */ ExtraParams(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7);
    }

    public final String getDemoPercent() {
        return this.demoPercent;
    }

    public final void setDemoPercent(String str) {
        this.demoPercent = str;
    }

    public final String getVideoTypeFile() {
        return this.videoTypeFile;
    }

    public final void setVideoTypeFile(String str) {
        this.videoTypeFile = str;
    }

    public final String getVideotoken() {
        return this.videotoken;
    }

    public final void setVideotoken(String str) {
        this.videotoken = str;
    }

    public final String getFeedbackVideo() {
        return this.feedbackVideo;
    }

    public final void setFeedbackVideo(String str) {
        this.feedbackVideo = str;
    }

    public final String getFloatingNumber() {
        return this.floatingNumber;
    }

    public final void setFloatingNumber(String str) {
        this.floatingNumber = str;
    }

    public final String getVodChat() {
        return this.vodChat;
    }

    public final void setVodChat(String str) {
        this.vodChat = str;
    }

    public final String isLimited() {
        return this.isLimited;
    }

    public final void setLimited(String str) {
        this.isLimited = str;
    }
}
