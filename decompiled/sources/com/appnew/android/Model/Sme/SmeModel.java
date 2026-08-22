package com.appnew.android.Model.Sme;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SmeModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\t\u0010!\u001a\u00020\fHÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003JO\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001J\u0013\u0010$\u001a\u00020\f2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0007HÖ\u0001J\t\u0010'\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015¨\u0006("}, d2 = {"Lcom/appnew/android/Model/Sme/SmeModel;", "", "cd_time", "", "data", "Lcom/appnew/android/Model/Sme/Data;", "interval", "", Constants.KEY_LIMIT, "message", "", "status", "", "time", "<init>", "(JLcom/appnew/android/Model/Sme/Data;IILjava/lang/String;ZI)V", "getCd_time", "()J", "getData", "()Lcom/appnew/android/Model/Sme/Data;", "getInterval", "()I", "getLimit", "getMessage", "()Ljava/lang/String;", "getStatus", "()Z", "getTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", Constants.COPY_TYPE, "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class SmeModel {
    public static final int $stable = 0;
    private final long cd_time;
    private final Data data;
    private final int interval;
    private final int limit;
    private final String message;
    private final boolean status;
    private final int time;

    public static /* synthetic */ SmeModel copy$default(SmeModel smeModel, long j, Data data, int i, int i2, String str, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            j = smeModel.cd_time;
        }
        long j2 = j;
        if ((i4 & 2) != 0) {
            data = smeModel.data;
        }
        Data data2 = data;
        if ((i4 & 4) != 0) {
            i = smeModel.interval;
        }
        int i5 = i;
        if ((i4 & 8) != 0) {
            i2 = smeModel.limit;
        }
        int i6 = i2;
        if ((i4 & 16) != 0) {
            str = smeModel.message;
        }
        return smeModel.copy(j2, data2, i5, i6, str, (i4 & 32) != 0 ? smeModel.status : z, (i4 & 64) != 0 ? smeModel.time : i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getCd_time() {
        return this.cd_time;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Data getData() {
        return this.data;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getInterval() {
        return this.interval;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getLimit() {
        return this.limit;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getTime() {
        return this.time;
    }

    public final SmeModel copy(long cd_time, Data data, int interval, int limit, String message, boolean status, int time) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(message, "message");
        return new SmeModel(cd_time, data, interval, limit, message, status, time);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SmeModel)) {
            return false;
        }
        SmeModel smeModel = (SmeModel) other;
        return this.cd_time == smeModel.cd_time && Intrinsics.areEqual(this.data, smeModel.data) && this.interval == smeModel.interval && this.limit == smeModel.limit && Intrinsics.areEqual(this.message, smeModel.message) && this.status == smeModel.status && this.time == smeModel.time;
    }

    public int hashCode() {
        return (((((((((((Long.hashCode(this.cd_time) * 31) + this.data.hashCode()) * 31) + Integer.hashCode(this.interval)) * 31) + Integer.hashCode(this.limit)) * 31) + this.message.hashCode()) * 31) + Boolean.hashCode(this.status)) * 31) + Integer.hashCode(this.time);
    }

    public String toString() {
        return "SmeModel(cd_time=" + this.cd_time + ", data=" + this.data + ", interval=" + this.interval + ", limit=" + this.limit + ", message=" + this.message + ", status=" + this.status + ", time=" + this.time + ")";
    }

    public SmeModel(long j, Data data, int i, int i2, String message, boolean z, int i3) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(message, "message");
        this.cd_time = j;
        this.data = data;
        this.interval = i;
        this.limit = i2;
        this.message = message;
        this.status = z;
        this.time = i3;
    }

    public final long getCd_time() {
        return this.cd_time;
    }

    public final Data getData() {
        return this.data;
    }

    public final int getInterval() {
        return this.interval;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final String getMessage() {
        return this.message;
    }

    public final boolean getStatus() {
        return this.status;
    }

    public final int getTime() {
        return this.time;
    }
}
