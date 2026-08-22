package com.appnew.android.Model.Noticeboard;

import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Data.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b-\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003Jm\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u000204HÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R\u001e\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012¨\u00066"}, d2 = {"Lcom/appnew/android/Model/Noticeboard/Data;", "", "appId", "", "centerId", "creationTime", "id", "link", "modifiedOn", "status", "text", "title", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "getCenterId", "setCenterId", "getCreationTime", "setCreationTime", "getId", "setId", "getLink", "setLink", "getModifiedOn", "setModifiedOn", "getStatus", "setStatus", "getText", "setText", "getTitle", "setTitle", "getType", "setType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Data {
    public static final int $stable = 8;

    @SerializedName("app_id")
    private String appId;

    @SerializedName("center_id")
    private String centerId;

    @SerializedName(Const.CREATION_TIME)
    private String creationTime;

    @SerializedName("id")
    private String id;

    @SerializedName("link")
    private String link;

    @SerializedName("modified_on")
    private String modifiedOn;

    @SerializedName("status")
    private String status;

    @SerializedName("text")
    private String text;

    @SerializedName("title")
    private String title;

    @SerializedName("type")
    private String type;

    public static /* synthetic */ Data copy$default(Data data, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, Object obj) {
        if ((i & 1) != 0) {
            str = data.appId;
        }
        if ((i & 2) != 0) {
            str2 = data.centerId;
        }
        if ((i & 4) != 0) {
            str3 = data.creationTime;
        }
        if ((i & 8) != 0) {
            str4 = data.id;
        }
        if ((i & 16) != 0) {
            str5 = data.link;
        }
        if ((i & 32) != 0) {
            str6 = data.modifiedOn;
        }
        if ((i & 64) != 0) {
            str7 = data.status;
        }
        if ((i & 128) != 0) {
            str8 = data.text;
        }
        if ((i & 256) != 0) {
            str9 = data.title;
        }
        if ((i & 512) != 0) {
            str10 = data.type;
        }
        String str11 = str9;
        String str12 = str10;
        String str13 = str7;
        String str14 = str8;
        String str15 = str5;
        String str16 = str6;
        return data.copy(str, str2, str3, str4, str15, str16, str13, str14, str11, str12);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCenterId() {
        return this.centerId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCreationTime() {
        return this.creationTime;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLink() {
        return this.link;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getModifiedOn() {
        return this.modifiedOn;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final Data copy(String appId, String centerId, String creationTime, String id, String link, String modifiedOn, String status, String text, String title, String type) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(centerId, "centerId");
        Intrinsics.checkNotNullParameter(creationTime, "creationTime");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(modifiedOn, "modifiedOn");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(type, "type");
        return new Data(appId, centerId, creationTime, id, link, modifiedOn, status, text, title, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Data)) {
            return false;
        }
        Data data = (Data) other;
        return Intrinsics.areEqual(this.appId, data.appId) && Intrinsics.areEqual(this.centerId, data.centerId) && Intrinsics.areEqual(this.creationTime, data.creationTime) && Intrinsics.areEqual(this.id, data.id) && Intrinsics.areEqual(this.link, data.link) && Intrinsics.areEqual(this.modifiedOn, data.modifiedOn) && Intrinsics.areEqual(this.status, data.status) && Intrinsics.areEqual(this.text, data.text) && Intrinsics.areEqual(this.title, data.title) && Intrinsics.areEqual(this.type, data.type);
    }

    public int hashCode() {
        return (((((((((((((((((this.appId.hashCode() * 31) + this.centerId.hashCode()) * 31) + this.creationTime.hashCode()) * 31) + this.id.hashCode()) * 31) + this.link.hashCode()) * 31) + this.modifiedOn.hashCode()) * 31) + this.status.hashCode()) * 31) + this.text.hashCode()) * 31) + this.title.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "Data(appId=" + this.appId + ", centerId=" + this.centerId + ", creationTime=" + this.creationTime + ", id=" + this.id + ", link=" + this.link + ", modifiedOn=" + this.modifiedOn + ", status=" + this.status + ", text=" + this.text + ", title=" + this.title + ", type=" + this.type + ")";
    }

    public Data(String appId, String centerId, String creationTime, String id, String link, String modifiedOn, String status, String text, String title, String type) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(centerId, "centerId");
        Intrinsics.checkNotNullParameter(creationTime, "creationTime");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(modifiedOn, "modifiedOn");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(type, "type");
        this.appId = appId;
        this.centerId = centerId;
        this.creationTime = creationTime;
        this.id = id;
        this.link = link;
        this.modifiedOn = modifiedOn;
        this.status = status;
        this.text = text;
        this.title = title;
        this.type = type;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final void setAppId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appId = str;
    }

    public final String getCenterId() {
        return this.centerId;
    }

    public final void setCenterId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.centerId = str;
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

    public final String getLink() {
        return this.link;
    }

    public final void setLink(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.link = str;
    }

    public final String getModifiedOn() {
        return this.modifiedOn;
    }

    public final void setModifiedOn(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.modifiedOn = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.status = str;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }
}
