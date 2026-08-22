package com.pallycon.widevine.model;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/pallycon/widevine/model/PallyConDeviceInfo;", "", Constants.DEVICE_ID_TAG, "", "deviceModel", "osVersion", "sessionId", "isChromeCdm", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getDeviceId", "()Ljava/lang/String;", "getDeviceModel", "()Z", "getOsVersion", "getSessionId", "component1", "component2", "component3", "component4", "component5", Constants.COPY_TYPE, "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "widevine_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class PallyConDeviceInfo {

    @SerializedName("device_id")
    private final String deviceId;

    @SerializedName("device_model")
    private final String deviceModel;

    @SerializedName("is_chrome_cdm")
    private final boolean isChromeCdm;

    @SerializedName("os_version")
    private final String osVersion;

    @SerializedName("session_id")
    private final String sessionId;

    public PallyConDeviceInfo(String deviceId, String deviceModel, String osVersion, String sessionId, boolean z) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(deviceModel, "deviceModel");
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.deviceId = deviceId;
        this.deviceModel = deviceModel;
        this.osVersion = osVersion;
        this.sessionId = sessionId;
        this.isChromeCdm = z;
    }

    public static /* synthetic */ PallyConDeviceInfo copy$default(PallyConDeviceInfo pallyConDeviceInfo, String str, String str2, String str3, String str4, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pallyConDeviceInfo.deviceId;
        }
        if ((i & 2) != 0) {
            str2 = pallyConDeviceInfo.deviceModel;
        }
        if ((i & 4) != 0) {
            str3 = pallyConDeviceInfo.osVersion;
        }
        if ((i & 8) != 0) {
            str4 = pallyConDeviceInfo.sessionId;
        }
        if ((i & 16) != 0) {
            z = pallyConDeviceInfo.isChromeCdm;
        }
        boolean z2 = z;
        String str5 = str3;
        return pallyConDeviceInfo.copy(str, str2, str5, str4, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDeviceModel() {
        return this.deviceModel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getOsVersion() {
        return this.osVersion;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsChromeCdm() {
        return this.isChromeCdm;
    }

    public final PallyConDeviceInfo copy(String deviceId, String deviceModel, String osVersion, String sessionId, boolean isChromeCdm) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(deviceModel, "deviceModel");
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        return new PallyConDeviceInfo(deviceId, deviceModel, osVersion, sessionId, isChromeCdm);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PallyConDeviceInfo)) {
            return false;
        }
        PallyConDeviceInfo pallyConDeviceInfo = (PallyConDeviceInfo) other;
        return Intrinsics.areEqual(this.deviceId, pallyConDeviceInfo.deviceId) && Intrinsics.areEqual(this.deviceModel, pallyConDeviceInfo.deviceModel) && Intrinsics.areEqual(this.osVersion, pallyConDeviceInfo.osVersion) && Intrinsics.areEqual(this.sessionId, pallyConDeviceInfo.sessionId) && this.isChromeCdm == pallyConDeviceInfo.isChromeCdm;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getDeviceModel() {
        return this.deviceModel;
    }

    public final String getOsVersion() {
        return this.osVersion;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public int hashCode() {
        return (((((((this.deviceId.hashCode() * 31) + this.deviceModel.hashCode()) * 31) + this.osVersion.hashCode()) * 31) + this.sessionId.hashCode()) * 31) + Boolean.hashCode(this.isChromeCdm);
    }

    public final boolean isChromeCdm() {
        return this.isChromeCdm;
    }

    public String toString() {
        return "PallyConDeviceInfo(deviceId=" + this.deviceId + ", deviceModel=" + this.deviceModel + ", osVersion=" + this.osVersion + ", sessionId=" + this.sessionId + ", isChromeCdm=" + this.isChromeCdm + ')';
    }
}
