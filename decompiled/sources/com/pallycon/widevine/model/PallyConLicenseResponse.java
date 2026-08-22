package com.pallycon.widevine.model;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\t¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003JY\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\tHÆ\u0001J\u0013\u0010$\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\tHÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0016\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0016\u0010\r\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014¨\u0006("}, d2 = {"Lcom/pallycon/widevine/model/PallyConLicenseResponse;", "", "deviceInfo", "Lcom/pallycon/widevine/model/PallyConDeviceInfo;", "license", "", "persistent", "", "licenseDuration", "", "rentalDuration", "playbackDuration", "renewal", "renewalDuration", "(Lcom/pallycon/widevine/model/PallyConDeviceInfo;Ljava/lang/String;ZIIIZI)V", "getDeviceInfo", "()Lcom/pallycon/widevine/model/PallyConDeviceInfo;", "getLicense", "()Ljava/lang/String;", "getLicenseDuration", "()I", "getPersistent", "()Z", "getPlaybackDuration", "getRenewal", "getRenewalDuration", "getRentalDuration", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", Constants.COPY_TYPE, "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "widevine_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class PallyConLicenseResponse {

    @SerializedName("device_info")
    private final PallyConDeviceInfo deviceInfo;

    @SerializedName("license")
    private final String license;

    @SerializedName("license_duration")
    private final int licenseDuration;

    @SerializedName("persistent")
    private final boolean persistent;

    @SerializedName("playback_duration")
    private final int playbackDuration;

    @SerializedName("renewal")
    private final boolean renewal;

    @SerializedName("renewal_duration")
    private final int renewalDuration;

    @SerializedName("rental_duration")
    private final int rentalDuration;

    public PallyConLicenseResponse(PallyConDeviceInfo deviceInfo, String license, boolean z, int i, int i2, int i3, boolean z2, int i4) {
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(license, "license");
        this.deviceInfo = deviceInfo;
        this.license = license;
        this.persistent = z;
        this.licenseDuration = i;
        this.rentalDuration = i2;
        this.playbackDuration = i3;
        this.renewal = z2;
        this.renewalDuration = i4;
    }

    public static /* synthetic */ PallyConLicenseResponse copy$default(PallyConLicenseResponse pallyConLicenseResponse, PallyConDeviceInfo pallyConDeviceInfo, String str, boolean z, int i, int i2, int i3, boolean z2, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            pallyConDeviceInfo = pallyConLicenseResponse.deviceInfo;
        }
        if ((i5 & 2) != 0) {
            str = pallyConLicenseResponse.license;
        }
        if ((i5 & 4) != 0) {
            z = pallyConLicenseResponse.persistent;
        }
        if ((i5 & 8) != 0) {
            i = pallyConLicenseResponse.licenseDuration;
        }
        if ((i5 & 16) != 0) {
            i2 = pallyConLicenseResponse.rentalDuration;
        }
        if ((i5 & 32) != 0) {
            i3 = pallyConLicenseResponse.playbackDuration;
        }
        if ((i5 & 64) != 0) {
            z2 = pallyConLicenseResponse.renewal;
        }
        if ((i5 & 128) != 0) {
            i4 = pallyConLicenseResponse.renewalDuration;
        }
        boolean z3 = z2;
        int i6 = i4;
        int i7 = i2;
        int i8 = i3;
        return pallyConLicenseResponse.copy(pallyConDeviceInfo, str, z, i, i7, i8, z3, i6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PallyConDeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLicense() {
        return this.license;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getPersistent() {
        return this.persistent;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getLicenseDuration() {
        return this.licenseDuration;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getRentalDuration() {
        return this.rentalDuration;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getPlaybackDuration() {
        return this.playbackDuration;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getRenewal() {
        return this.renewal;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getRenewalDuration() {
        return this.renewalDuration;
    }

    public final PallyConLicenseResponse copy(PallyConDeviceInfo deviceInfo, String license, boolean persistent, int licenseDuration, int rentalDuration, int playbackDuration, boolean renewal, int renewalDuration) {
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(license, "license");
        return new PallyConLicenseResponse(deviceInfo, license, persistent, licenseDuration, rentalDuration, playbackDuration, renewal, renewalDuration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PallyConLicenseResponse)) {
            return false;
        }
        PallyConLicenseResponse pallyConLicenseResponse = (PallyConLicenseResponse) other;
        return Intrinsics.areEqual(this.deviceInfo, pallyConLicenseResponse.deviceInfo) && Intrinsics.areEqual(this.license, pallyConLicenseResponse.license) && this.persistent == pallyConLicenseResponse.persistent && this.licenseDuration == pallyConLicenseResponse.licenseDuration && this.rentalDuration == pallyConLicenseResponse.rentalDuration && this.playbackDuration == pallyConLicenseResponse.playbackDuration && this.renewal == pallyConLicenseResponse.renewal && this.renewalDuration == pallyConLicenseResponse.renewalDuration;
    }

    public final PallyConDeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public final String getLicense() {
        return this.license;
    }

    public final int getLicenseDuration() {
        return this.licenseDuration;
    }

    public final boolean getPersistent() {
        return this.persistent;
    }

    public final int getPlaybackDuration() {
        return this.playbackDuration;
    }

    public final boolean getRenewal() {
        return this.renewal;
    }

    public final int getRenewalDuration() {
        return this.renewalDuration;
    }

    public final int getRentalDuration() {
        return this.rentalDuration;
    }

    public int hashCode() {
        return (((((((((((((this.deviceInfo.hashCode() * 31) + this.license.hashCode()) * 31) + Boolean.hashCode(this.persistent)) * 31) + Integer.hashCode(this.licenseDuration)) * 31) + Integer.hashCode(this.rentalDuration)) * 31) + Integer.hashCode(this.playbackDuration)) * 31) + Boolean.hashCode(this.renewal)) * 31) + Integer.hashCode(this.renewalDuration);
    }

    public String toString() {
        return "PallyConLicenseResponse(deviceInfo=" + this.deviceInfo + ", license=" + this.license + ", persistent=" + this.persistent + ", licenseDuration=" + this.licenseDuration + ", rentalDuration=" + this.rentalDuration + ", playbackDuration=" + this.playbackDuration + ", renewal=" + this.renewal + ", renewalDuration=" + this.renewalDuration + ')';
    }
}
