package com.clevertap.android.sdk.db;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DelayedLegacyInAppDAO.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/clevertap/android/sdk/db/DelayedLegacyInAppData;", "", Column.INAPP_ID, "", "delay", "", "inAppData", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getInAppId", "()Ljava/lang/String;", "getDelay", "()I", "getInAppData", "component1", "component2", "component3", Constants.COPY_TYPE, "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class DelayedLegacyInAppData {
    private final int delay;
    private final String inAppData;
    private final String inAppId;

    public static /* synthetic */ DelayedLegacyInAppData copy$default(DelayedLegacyInAppData delayedLegacyInAppData, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = delayedLegacyInAppData.inAppId;
        }
        if ((i2 & 2) != 0) {
            i = delayedLegacyInAppData.delay;
        }
        if ((i2 & 4) != 0) {
            str2 = delayedLegacyInAppData.inAppData;
        }
        return delayedLegacyInAppData.copy(str, i, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getInAppId() {
        return this.inAppId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getDelay() {
        return this.delay;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getInAppData() {
        return this.inAppData;
    }

    public final DelayedLegacyInAppData copy(String inAppId, int delay, String inAppData) {
        Intrinsics.checkNotNullParameter(inAppId, "inAppId");
        Intrinsics.checkNotNullParameter(inAppData, "inAppData");
        return new DelayedLegacyInAppData(inAppId, delay, inAppData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DelayedLegacyInAppData)) {
            return false;
        }
        DelayedLegacyInAppData delayedLegacyInAppData = (DelayedLegacyInAppData) other;
        return Intrinsics.areEqual(this.inAppId, delayedLegacyInAppData.inAppId) && this.delay == delayedLegacyInAppData.delay && Intrinsics.areEqual(this.inAppData, delayedLegacyInAppData.inAppData);
    }

    public int hashCode() {
        return (((this.inAppId.hashCode() * 31) + Integer.hashCode(this.delay)) * 31) + this.inAppData.hashCode();
    }

    public String toString() {
        return "DelayedLegacyInAppData(inAppId=" + this.inAppId + ", delay=" + this.delay + ", inAppData=" + this.inAppData + ')';
    }

    public DelayedLegacyInAppData(String inAppId, int i, String inAppData) {
        Intrinsics.checkNotNullParameter(inAppId, "inAppId");
        Intrinsics.checkNotNullParameter(inAppData, "inAppData");
        this.inAppId = inAppId;
        this.delay = i;
        this.inAppData = inAppData;
    }

    public final String getInAppId() {
        return this.inAppId;
    }

    public final int getDelay() {
        return this.delay;
    }

    public final String getInAppData() {
        return this.inAppData;
    }
}
