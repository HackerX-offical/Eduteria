package com.appnew.android.Model;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PaymentCredentialsResponse.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JO\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/appnew/android/Model/WorldLine;", "", "mode", "", "secret", "mid", "metaName", "status", "android_deviceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMode", "()Ljava/lang/String;", "getSecret", "getMid", "getMetaName", "getStatus", "getAndroid_deviceId", "component1", "component2", "component3", "component4", "component5", "component6", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class WorldLine {
    public static final int $stable = 0;

    @SerializedName("android_deviceId")
    private final String android_deviceId;

    @SerializedName("meta_name")
    private final String metaName;

    @SerializedName("mid")
    private final String mid;

    @SerializedName("mode")
    private final String mode;

    @SerializedName("secret")
    private final String secret;

    @SerializedName("status")
    private final String status;

    public WorldLine() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ WorldLine copy$default(WorldLine worldLine, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = worldLine.mode;
        }
        if ((i & 2) != 0) {
            str2 = worldLine.secret;
        }
        if ((i & 4) != 0) {
            str3 = worldLine.mid;
        }
        if ((i & 8) != 0) {
            str4 = worldLine.metaName;
        }
        if ((i & 16) != 0) {
            str5 = worldLine.status;
        }
        if ((i & 32) != 0) {
            str6 = worldLine.android_deviceId;
        }
        String str7 = str5;
        String str8 = str6;
        return worldLine.copy(str, str2, str3, str4, str7, str8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSecret() {
        return this.secret;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMid() {
        return this.mid;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMetaName() {
        return this.metaName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getAndroid_deviceId() {
        return this.android_deviceId;
    }

    public final WorldLine copy(String mode, String secret, String mid, String metaName, String status, String android_deviceId) {
        Intrinsics.checkNotNullParameter(metaName, "metaName");
        return new WorldLine(mode, secret, mid, metaName, status, android_deviceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WorldLine)) {
            return false;
        }
        WorldLine worldLine = (WorldLine) other;
        return Intrinsics.areEqual(this.mode, worldLine.mode) && Intrinsics.areEqual(this.secret, worldLine.secret) && Intrinsics.areEqual(this.mid, worldLine.mid) && Intrinsics.areEqual(this.metaName, worldLine.metaName) && Intrinsics.areEqual(this.status, worldLine.status) && Intrinsics.areEqual(this.android_deviceId, worldLine.android_deviceId);
    }

    public int hashCode() {
        String str = this.mode;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.secret;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.mid;
        int iHashCode3 = (((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.metaName.hashCode()) * 31;
        String str4 = this.status;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.android_deviceId;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "WorldLine(mode=" + this.mode + ", secret=" + this.secret + ", mid=" + this.mid + ", metaName=" + this.metaName + ", status=" + this.status + ", android_deviceId=" + this.android_deviceId + ")";
    }

    public WorldLine(String str, String str2, String str3, String metaName, String str4, String str5) {
        Intrinsics.checkNotNullParameter(metaName, "metaName");
        this.mode = str;
        this.secret = str2;
        this.mid = str3;
        this.metaName = metaName;
        this.status = str4;
        this.android_deviceId = str5;
    }

    public final String getMode() {
        return this.mode;
    }

    public final String getSecret() {
        return this.secret;
    }

    public final String getMid() {
        return this.mid;
    }

    public final String getMetaName() {
        return this.metaName;
    }

    public /* synthetic */ WorldLine(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6);
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getAndroid_deviceId() {
        return this.android_deviceId;
    }
}
