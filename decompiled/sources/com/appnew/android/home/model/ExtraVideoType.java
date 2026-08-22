package com.appnew.android.home.model;

import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExtraVideoType.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bH\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0091\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010R\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u0093\u0002\u0010c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÆ\u0001J\u0013\u0010d\u001a\u00020e2\b\u0010f\u001a\u0004\u0018\u00010gHÖ\u0003J\t\u0010h\u001a\u00020iHÖ\u0001J\t\u0010j\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010 \"\u0004\b'\u0010\"R.\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010 \"\u0004\b-\u0010\"R \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010 \"\u0004\b/\u0010\"R \u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010 \"\u0004\b1\u0010\"R \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010 \"\u0004\b3\u0010\"R \u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010 \"\u0004\b4\u0010\"R \u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010 \"\u0004\b6\u0010\"R \u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010 \"\u0004\b8\u0010\"R \u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010 \"\u0004\b:\u0010\"R \u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010 \"\u0004\b<\u0010\"R \u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010 \"\u0004\b>\u0010\"R \u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010 \"\u0004\b@\u0010\"R \u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010 \"\u0004\bA\u0010\"R \u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010 \"\u0004\bC\u0010\"R \u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010 \"\u0004\bE\u0010\"R \u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR \u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010M¨\u0006k"}, d2 = {"Lcom/appnew/android/home/model/ExtraVideoType;", "Ljava/io/Serializable;", "title", "", "id", "vdcId", "isDrm", "bitrateUrls", "Ljava/util/ArrayList;", "Lcom/appnew/android/home/model/BitrateUrls;", "Lkotlin/collections/ArrayList;", "startDate", "fileType", "videoType", "fileUrl", "isDownload", "thumbnailUrl", "description", "videoLength", "chatNode", "liveStatus", "openInApp", "isChatLocked", "multiplayer", "remainingTime", "extraParams", "Lcom/appnew/android/home/model/ExtraParams;", "payload", "Lcom/appnew/android/home/model/Payload;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/appnew/android/home/model/ExtraParams;Lcom/appnew/android/home/model/Payload;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getId", "setId", "getVdcId", "setVdcId", "setDrm", "getBitrateUrls", "()Ljava/util/ArrayList;", "setBitrateUrls", "(Ljava/util/ArrayList;)V", "getStartDate", "setStartDate", "getFileType", "setFileType", "getVideoType", "setVideoType", "getFileUrl", "setFileUrl", "setDownload", "getThumbnailUrl", "setThumbnailUrl", "getDescription", "setDescription", "getVideoLength", "setVideoLength", "getChatNode", "setChatNode", "getLiveStatus", "setLiveStatus", "getOpenInApp", "setOpenInApp", "setChatLocked", "getMultiplayer", "setMultiplayer", "getRemainingTime", "setRemainingTime", "getExtraParams", "()Lcom/appnew/android/home/model/ExtraParams;", "setExtraParams", "(Lcom/appnew/android/home/model/ExtraParams;)V", "getPayload", "()Lcom/appnew/android/home/model/Payload;", "setPayload", "(Lcom/appnew/android/home/model/Payload;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", Constants.COPY_TYPE, "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ExtraVideoType implements Serializable {
    public static final int $stable = 8;

    @SerializedName("bitrate_urls")
    private ArrayList<BitrateUrls> bitrateUrls;

    @SerializedName("chat_node")
    private String chatNode;

    @SerializedName("description")
    private String description;

    @SerializedName("extra_params")
    private ExtraParams extraParams;

    @SerializedName("file_type")
    private String fileType;

    @SerializedName("file_url")
    private String fileUrl;

    @SerializedName("id")
    private String id;

    @SerializedName("is_chat_locked")
    private String isChatLocked;

    @SerializedName(Const.IS_DOWNLOAD)
    private String isDownload;

    @SerializedName("is_drm")
    private String isDrm;

    @SerializedName("live_status")
    private String liveStatus;

    @SerializedName("multiplayer")
    private String multiplayer;

    @SerializedName("open_in_app")
    private String openInApp;

    @SerializedName("payload")
    private Payload payload;

    @SerializedName(Const.remaining_time)
    private String remainingTime;

    @SerializedName(FirebaseAnalytics.Param.START_DATE)
    private String startDate;

    @SerializedName("thumbnail_url")
    private String thumbnailUrl;

    @SerializedName("title")
    private String title;

    @SerializedName("vdc_id")
    private String vdcId;

    @SerializedName("video_length")
    private String videoLength;

    @SerializedName(Const.VIDEO_TYPE)
    private String videoType;

    public ExtraVideoType() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExtraVideoType copy$default(ExtraVideoType extraVideoType, String str, String str2, String str3, String str4, ArrayList arrayList, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, ExtraParams extraParams, Payload payload, int i, Object obj) {
        Payload payload2;
        ExtraParams extraParams2;
        String str19 = (i & 1) != 0 ? extraVideoType.title : str;
        String str20 = (i & 2) != 0 ? extraVideoType.id : str2;
        String str21 = (i & 4) != 0 ? extraVideoType.vdcId : str3;
        String str22 = (i & 8) != 0 ? extraVideoType.isDrm : str4;
        ArrayList arrayList2 = (i & 16) != 0 ? extraVideoType.bitrateUrls : arrayList;
        String str23 = (i & 32) != 0 ? extraVideoType.startDate : str5;
        String str24 = (i & 64) != 0 ? extraVideoType.fileType : str6;
        String str25 = (i & 128) != 0 ? extraVideoType.videoType : str7;
        String str26 = (i & 256) != 0 ? extraVideoType.fileUrl : str8;
        String str27 = (i & 512) != 0 ? extraVideoType.isDownload : str9;
        String str28 = (i & 1024) != 0 ? extraVideoType.thumbnailUrl : str10;
        String str29 = (i & 2048) != 0 ? extraVideoType.description : str11;
        String str30 = (i & 4096) != 0 ? extraVideoType.videoLength : str12;
        String str31 = (i & 8192) != 0 ? extraVideoType.chatNode : str13;
        String str32 = str19;
        String str33 = (i & 16384) != 0 ? extraVideoType.liveStatus : str14;
        String str34 = (i & 32768) != 0 ? extraVideoType.openInApp : str15;
        String str35 = (i & 65536) != 0 ? extraVideoType.isChatLocked : str16;
        String str36 = (i & 131072) != 0 ? extraVideoType.multiplayer : str17;
        String str37 = (i & 262144) != 0 ? extraVideoType.remainingTime : str18;
        ExtraParams extraParams3 = (i & 524288) != 0 ? extraVideoType.extraParams : extraParams;
        if ((i & 1048576) != 0) {
            extraParams2 = extraParams3;
            payload2 = extraVideoType.payload;
        } else {
            payload2 = payload;
            extraParams2 = extraParams3;
        }
        return extraVideoType.copy(str32, str20, str21, str22, arrayList2, str23, str24, str25, str26, str27, str28, str29, str30, str31, str33, str34, str35, str36, str37, extraParams2, payload2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getIsDownload() {
        return this.isDownload;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getVideoLength() {
        return this.videoLength;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getChatNode() {
        return this.chatNode;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getLiveStatus() {
        return this.liveStatus;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getOpenInApp() {
        return this.openInApp;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getIsChatLocked() {
        return this.isChatLocked;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getMultiplayer() {
        return this.multiplayer;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getRemainingTime() {
        return this.remainingTime;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final ExtraParams getExtraParams() {
        return this.extraParams;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final Payload getPayload() {
        return this.payload;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getVdcId() {
        return this.vdcId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getIsDrm() {
        return this.isDrm;
    }

    public final ArrayList<BitrateUrls> component5() {
        return this.bitrateUrls;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getStartDate() {
        return this.startDate;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getFileType() {
        return this.fileType;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getVideoType() {
        return this.videoType;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getFileUrl() {
        return this.fileUrl;
    }

    public final ExtraVideoType copy(String title, String id, String vdcId, String isDrm, ArrayList<BitrateUrls> bitrateUrls, String startDate, String fileType, String videoType, String fileUrl, String isDownload, String thumbnailUrl, String description, String videoLength, String chatNode, String liveStatus, String openInApp, String isChatLocked, String multiplayer, String remainingTime, ExtraParams extraParams, Payload payload) {
        Intrinsics.checkNotNullParameter(bitrateUrls, "bitrateUrls");
        return new ExtraVideoType(title, id, vdcId, isDrm, bitrateUrls, startDate, fileType, videoType, fileUrl, isDownload, thumbnailUrl, description, videoLength, chatNode, liveStatus, openInApp, isChatLocked, multiplayer, remainingTime, extraParams, payload);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExtraVideoType)) {
            return false;
        }
        ExtraVideoType extraVideoType = (ExtraVideoType) other;
        return Intrinsics.areEqual(this.title, extraVideoType.title) && Intrinsics.areEqual(this.id, extraVideoType.id) && Intrinsics.areEqual(this.vdcId, extraVideoType.vdcId) && Intrinsics.areEqual(this.isDrm, extraVideoType.isDrm) && Intrinsics.areEqual(this.bitrateUrls, extraVideoType.bitrateUrls) && Intrinsics.areEqual(this.startDate, extraVideoType.startDate) && Intrinsics.areEqual(this.fileType, extraVideoType.fileType) && Intrinsics.areEqual(this.videoType, extraVideoType.videoType) && Intrinsics.areEqual(this.fileUrl, extraVideoType.fileUrl) && Intrinsics.areEqual(this.isDownload, extraVideoType.isDownload) && Intrinsics.areEqual(this.thumbnailUrl, extraVideoType.thumbnailUrl) && Intrinsics.areEqual(this.description, extraVideoType.description) && Intrinsics.areEqual(this.videoLength, extraVideoType.videoLength) && Intrinsics.areEqual(this.chatNode, extraVideoType.chatNode) && Intrinsics.areEqual(this.liveStatus, extraVideoType.liveStatus) && Intrinsics.areEqual(this.openInApp, extraVideoType.openInApp) && Intrinsics.areEqual(this.isChatLocked, extraVideoType.isChatLocked) && Intrinsics.areEqual(this.multiplayer, extraVideoType.multiplayer) && Intrinsics.areEqual(this.remainingTime, extraVideoType.remainingTime) && Intrinsics.areEqual(this.extraParams, extraVideoType.extraParams) && Intrinsics.areEqual(this.payload, extraVideoType.payload);
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.id;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.vdcId;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.isDrm;
        int iHashCode4 = (((iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.bitrateUrls.hashCode()) * 31;
        String str5 = this.startDate;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.fileType;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.videoType;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.fileUrl;
        int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.isDownload;
        int iHashCode9 = (iHashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.thumbnailUrl;
        int iHashCode10 = (iHashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.description;
        int iHashCode11 = (iHashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.videoLength;
        int iHashCode12 = (iHashCode11 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.chatNode;
        int iHashCode13 = (iHashCode12 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.liveStatus;
        int iHashCode14 = (iHashCode13 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.openInApp;
        int iHashCode15 = (iHashCode14 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.isChatLocked;
        int iHashCode16 = (iHashCode15 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.multiplayer;
        int iHashCode17 = (iHashCode16 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.remainingTime;
        int iHashCode18 = (iHashCode17 + (str18 == null ? 0 : str18.hashCode())) * 31;
        ExtraParams extraParams = this.extraParams;
        int iHashCode19 = (iHashCode18 + (extraParams == null ? 0 : extraParams.hashCode())) * 31;
        Payload payload = this.payload;
        return iHashCode19 + (payload != null ? payload.hashCode() : 0);
    }

    public String toString() {
        return "ExtraVideoType(title=" + this.title + ", id=" + this.id + ", vdcId=" + this.vdcId + ", isDrm=" + this.isDrm + ", bitrateUrls=" + this.bitrateUrls + ", startDate=" + this.startDate + ", fileType=" + this.fileType + ", videoType=" + this.videoType + ", fileUrl=" + this.fileUrl + ", isDownload=" + this.isDownload + ", thumbnailUrl=" + this.thumbnailUrl + ", description=" + this.description + ", videoLength=" + this.videoLength + ", chatNode=" + this.chatNode + ", liveStatus=" + this.liveStatus + ", openInApp=" + this.openInApp + ", isChatLocked=" + this.isChatLocked + ", multiplayer=" + this.multiplayer + ", remainingTime=" + this.remainingTime + ", extraParams=" + this.extraParams + ", payload=" + this.payload + ")";
    }

    public ExtraVideoType(String str, String str2, String str3, String str4, ArrayList<BitrateUrls> bitrateUrls, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, ExtraParams extraParams, Payload payload) {
        Intrinsics.checkNotNullParameter(bitrateUrls, "bitrateUrls");
        this.title = str;
        this.id = str2;
        this.vdcId = str3;
        this.isDrm = str4;
        this.bitrateUrls = bitrateUrls;
        this.startDate = str5;
        this.fileType = str6;
        this.videoType = str7;
        this.fileUrl = str8;
        this.isDownload = str9;
        this.thumbnailUrl = str10;
        this.description = str11;
        this.videoLength = str12;
        this.chatNode = str13;
        this.liveStatus = str14;
        this.openInApp = str15;
        this.isChatLocked = str16;
        this.multiplayer = str17;
        this.remainingTime = str18;
        this.extraParams = extraParams;
        this.payload = payload;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getVdcId() {
        return this.vdcId;
    }

    public final void setVdcId(String str) {
        this.vdcId = str;
    }

    public final String isDrm() {
        return this.isDrm;
    }

    public final void setDrm(String str) {
        this.isDrm = str;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ ExtraVideoType(java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.util.ArrayList r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.lang.String r43, java.lang.String r44, java.lang.String r45, java.lang.String r46, java.lang.String r47, java.lang.String r48, java.lang.String r49, com.appnew.android.home.model.ExtraParams r50, com.appnew.android.home.model.Payload r51, int r52, kotlin.jvm.internal.DefaultConstructorMarker r53) {
        /*
            Method dump skipped, instruction units count: 333
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.home.model.ExtraVideoType.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.ArrayList, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.appnew.android.home.model.ExtraParams, com.appnew.android.home.model.Payload, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final ArrayList<BitrateUrls> getBitrateUrls() {
        return this.bitrateUrls;
    }

    public final void setBitrateUrls(ArrayList<BitrateUrls> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.bitrateUrls = arrayList;
    }

    public final String getStartDate() {
        return this.startDate;
    }

    public final void setStartDate(String str) {
        this.startDate = str;
    }

    public final String getFileType() {
        return this.fileType;
    }

    public final void setFileType(String str) {
        this.fileType = str;
    }

    public final String getVideoType() {
        return this.videoType;
    }

    public final void setVideoType(String str) {
        this.videoType = str;
    }

    public final String getFileUrl() {
        return this.fileUrl;
    }

    public final void setFileUrl(String str) {
        this.fileUrl = str;
    }

    public final String isDownload() {
        return this.isDownload;
    }

    public final void setDownload(String str) {
        this.isDownload = str;
    }

    public final String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public final void setThumbnailUrl(String str) {
        this.thumbnailUrl = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final String getVideoLength() {
        return this.videoLength;
    }

    public final void setVideoLength(String str) {
        this.videoLength = str;
    }

    public final String getChatNode() {
        return this.chatNode;
    }

    public final void setChatNode(String str) {
        this.chatNode = str;
    }

    public final String getLiveStatus() {
        return this.liveStatus;
    }

    public final void setLiveStatus(String str) {
        this.liveStatus = str;
    }

    public final String getOpenInApp() {
        return this.openInApp;
    }

    public final void setOpenInApp(String str) {
        this.openInApp = str;
    }

    public final String isChatLocked() {
        return this.isChatLocked;
    }

    public final void setChatLocked(String str) {
        this.isChatLocked = str;
    }

    public final String getMultiplayer() {
        return this.multiplayer;
    }

    public final void setMultiplayer(String str) {
        this.multiplayer = str;
    }

    public final String getRemainingTime() {
        return this.remainingTime;
    }

    public final void setRemainingTime(String str) {
        this.remainingTime = str;
    }

    public final ExtraParams getExtraParams() {
        return this.extraParams;
    }

    public final void setExtraParams(ExtraParams extraParams) {
        this.extraParams = extraParams;
    }

    public final Payload getPayload() {
        return this.payload;
    }

    public final void setPayload(Payload payload) {
        this.payload = payload;
    }
}
