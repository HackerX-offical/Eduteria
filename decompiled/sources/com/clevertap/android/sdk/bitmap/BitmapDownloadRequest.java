package com.clevertap.android.sdk.bitmap;

import android.content.Context;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BitmapDownloadRequest.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\"\b\u0086\b\u0018\u00002\u00020\u0001BI\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J\t\u0010)\u001a\u00020\rHÆ\u0003JK\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010+\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\rHÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006/"}, d2 = {"Lcom/clevertap/android/sdk/bitmap/BitmapDownloadRequest;", "", "bitmapPath", "", "fallbackToAppIcon", "", "context", "Landroid/content/Context;", "instanceConfig", "Lcom/clevertap/android/sdk/CleverTapInstanceConfig;", "downloadTimeLimitInMillis", "", "downloadSizeLimitInBytes", "", "<init>", "(Ljava/lang/String;ZLandroid/content/Context;Lcom/clevertap/android/sdk/CleverTapInstanceConfig;JI)V", "getBitmapPath", "()Ljava/lang/String;", "setBitmapPath", "(Ljava/lang/String;)V", "getFallbackToAppIcon", "()Z", "setFallbackToAppIcon", "(Z)V", "getContext", "()Landroid/content/Context;", "getInstanceConfig", "()Lcom/clevertap/android/sdk/CleverTapInstanceConfig;", "getDownloadTimeLimitInMillis", "()J", "setDownloadTimeLimitInMillis", "(J)V", "getDownloadSizeLimitInBytes", "()I", "setDownloadSizeLimitInBytes", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", Constants.COPY_TYPE, "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class BitmapDownloadRequest {
    private String bitmapPath;
    private final Context context;
    private int downloadSizeLimitInBytes;
    private long downloadTimeLimitInMillis;
    private boolean fallbackToAppIcon;
    private final CleverTapInstanceConfig instanceConfig;

    public BitmapDownloadRequest(String str) {
        this(str, false, null, null, 0L, 0, 62, null);
    }

    public BitmapDownloadRequest(String str, boolean z) {
        this(str, z, null, null, 0L, 0, 60, null);
    }

    public BitmapDownloadRequest(String str, boolean z, Context context) {
        this(str, z, context, null, 0L, 0, 56, null);
    }

    public BitmapDownloadRequest(String str, boolean z, Context context, CleverTapInstanceConfig cleverTapInstanceConfig) {
        this(str, z, context, cleverTapInstanceConfig, 0L, 0, 48, null);
    }

    public BitmapDownloadRequest(String str, boolean z, Context context, CleverTapInstanceConfig cleverTapInstanceConfig, long j) {
        this(str, z, context, cleverTapInstanceConfig, j, 0, 32, null);
    }

    public static /* synthetic */ BitmapDownloadRequest copy$default(BitmapDownloadRequest bitmapDownloadRequest, String str, boolean z, Context context, CleverTapInstanceConfig cleverTapInstanceConfig, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = bitmapDownloadRequest.bitmapPath;
        }
        if ((i2 & 2) != 0) {
            z = bitmapDownloadRequest.fallbackToAppIcon;
        }
        if ((i2 & 4) != 0) {
            context = bitmapDownloadRequest.context;
        }
        if ((i2 & 8) != 0) {
            cleverTapInstanceConfig = bitmapDownloadRequest.instanceConfig;
        }
        if ((i2 & 16) != 0) {
            j = bitmapDownloadRequest.downloadTimeLimitInMillis;
        }
        if ((i2 & 32) != 0) {
            i = bitmapDownloadRequest.downloadSizeLimitInBytes;
        }
        int i3 = i;
        long j2 = j;
        return bitmapDownloadRequest.copy(str, z, context, cleverTapInstanceConfig, j2, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBitmapPath() {
        return this.bitmapPath;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getFallbackToAppIcon() {
        return this.fallbackToAppIcon;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final CleverTapInstanceConfig getInstanceConfig() {
        return this.instanceConfig;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getDownloadTimeLimitInMillis() {
        return this.downloadTimeLimitInMillis;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getDownloadSizeLimitInBytes() {
        return this.downloadSizeLimitInBytes;
    }

    public final BitmapDownloadRequest copy(String bitmapPath, boolean fallbackToAppIcon, Context context, CleverTapInstanceConfig instanceConfig, long downloadTimeLimitInMillis, int downloadSizeLimitInBytes) {
        return new BitmapDownloadRequest(bitmapPath, fallbackToAppIcon, context, instanceConfig, downloadTimeLimitInMillis, downloadSizeLimitInBytes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BitmapDownloadRequest)) {
            return false;
        }
        BitmapDownloadRequest bitmapDownloadRequest = (BitmapDownloadRequest) other;
        return Intrinsics.areEqual(this.bitmapPath, bitmapDownloadRequest.bitmapPath) && this.fallbackToAppIcon == bitmapDownloadRequest.fallbackToAppIcon && Intrinsics.areEqual(this.context, bitmapDownloadRequest.context) && Intrinsics.areEqual(this.instanceConfig, bitmapDownloadRequest.instanceConfig) && this.downloadTimeLimitInMillis == bitmapDownloadRequest.downloadTimeLimitInMillis && this.downloadSizeLimitInBytes == bitmapDownloadRequest.downloadSizeLimitInBytes;
    }

    public int hashCode() {
        String str = this.bitmapPath;
        int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + Boolean.hashCode(this.fallbackToAppIcon)) * 31;
        Context context = this.context;
        int iHashCode2 = (iHashCode + (context == null ? 0 : context.hashCode())) * 31;
        CleverTapInstanceConfig cleverTapInstanceConfig = this.instanceConfig;
        return ((((iHashCode2 + (cleverTapInstanceConfig != null ? cleverTapInstanceConfig.hashCode() : 0)) * 31) + Long.hashCode(this.downloadTimeLimitInMillis)) * 31) + Integer.hashCode(this.downloadSizeLimitInBytes);
    }

    public String toString() {
        return "BitmapDownloadRequest(bitmapPath=" + this.bitmapPath + ", fallbackToAppIcon=" + this.fallbackToAppIcon + ", context=" + this.context + ", instanceConfig=" + this.instanceConfig + ", downloadTimeLimitInMillis=" + this.downloadTimeLimitInMillis + ", downloadSizeLimitInBytes=" + this.downloadSizeLimitInBytes + ')';
    }

    public BitmapDownloadRequest(String str, boolean z, Context context, CleverTapInstanceConfig cleverTapInstanceConfig, long j, int i) {
        this.bitmapPath = str;
        this.fallbackToAppIcon = z;
        this.context = context;
        this.instanceConfig = cleverTapInstanceConfig;
        this.downloadTimeLimitInMillis = j;
        this.downloadSizeLimitInBytes = i;
    }

    public /* synthetic */ BitmapDownloadRequest(String str, boolean z, Context context, CleverTapInstanceConfig cleverTapInstanceConfig, long j, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? null : context, (i2 & 8) == 0 ? cleverTapInstanceConfig : null, (i2 & 16) != 0 ? -1L : j, (i2 & 32) != 0 ? -1 : i);
    }

    public final String getBitmapPath() {
        return this.bitmapPath;
    }

    public final void setBitmapPath(String str) {
        this.bitmapPath = str;
    }

    public final boolean getFallbackToAppIcon() {
        return this.fallbackToAppIcon;
    }

    public final void setFallbackToAppIcon(boolean z) {
        this.fallbackToAppIcon = z;
    }

    public final Context getContext() {
        return this.context;
    }

    public final CleverTapInstanceConfig getInstanceConfig() {
        return this.instanceConfig;
    }

    public final long getDownloadTimeLimitInMillis() {
        return this.downloadTimeLimitInMillis;
    }

    public final void setDownloadTimeLimitInMillis(long j) {
        this.downloadTimeLimitInMillis = j;
    }

    public final int getDownloadSizeLimitInBytes() {
        return this.downloadSizeLimitInBytes;
    }

    public final void setDownloadSizeLimitInBytes(int i) {
        this.downloadSizeLimitInBytes = i;
    }
}
