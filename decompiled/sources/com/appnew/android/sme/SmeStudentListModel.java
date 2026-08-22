package com.appnew.android.sme;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SmeStudentListModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001f\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0001HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\t\u0010%\u001a\u00020\fHÆ\u0003J\t\u0010&\u001a\u00020\u000eHÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J_\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001J\u0013\u0010)\u001a\u00020\u000e2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\tHÖ\u0001J\t\u0010,\u001a\u00020\fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u000f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019¨\u0006-"}, d2 = {"Lcom/appnew/android/sme/SmeStudentListModel;", "", "cdTime", "", "cdTimeTempUw", "data", "", "Lcom/appnew/android/sme/SmeStudentModel;", "interval", "", Constants.KEY_LIMIT, "message", "", "status", "", "time", "<init>", "(JLjava/lang/Object;Ljava/util/List;IILjava/lang/String;ZI)V", "getCdTime", "()J", "getCdTimeTempUw", "()Ljava/lang/Object;", "getData", "()Ljava/util/List;", "getInterval", "()I", "getLimit", "getMessage", "()Ljava/lang/String;", "getStatus", "()Z", "getTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", Constants.COPY_TYPE, "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class SmeStudentListModel {
    public static final int $stable = 8;

    @SerializedName("cd_time")
    private final long cdTime;

    @SerializedName("cd_time_temp_uw")
    private final Object cdTimeTempUw;

    @SerializedName("data")
    private final List<SmeStudentModel> data;

    @SerializedName("interval")
    private final int interval;

    @SerializedName(Constants.KEY_LIMIT)
    private final int limit;

    @SerializedName("message")
    private final String message;

    @SerializedName("status")
    private final boolean status;

    @SerializedName("time")
    private final int time;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SmeStudentListModel copy$default(SmeStudentListModel smeStudentListModel, long j, Object obj, List list, int i, int i2, String str, boolean z, int i3, int i4, Object obj2) {
        if ((i4 & 1) != 0) {
            j = smeStudentListModel.cdTime;
        }
        long j2 = j;
        if ((i4 & 2) != 0) {
            obj = smeStudentListModel.cdTimeTempUw;
        }
        Object obj3 = obj;
        if ((i4 & 4) != 0) {
            list = smeStudentListModel.data;
        }
        List list2 = list;
        if ((i4 & 8) != 0) {
            i = smeStudentListModel.interval;
        }
        return smeStudentListModel.copy(j2, obj3, list2, i, (i4 & 16) != 0 ? smeStudentListModel.limit : i2, (i4 & 32) != 0 ? smeStudentListModel.message : str, (i4 & 64) != 0 ? smeStudentListModel.status : z, (i4 & 128) != 0 ? smeStudentListModel.time : i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getCdTime() {
        return this.cdTime;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Object getCdTimeTempUw() {
        return this.cdTimeTempUw;
    }

    public final List<SmeStudentModel> component3() {
        return this.data;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getInterval() {
        return this.interval;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getLimit() {
        return this.limit;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getTime() {
        return this.time;
    }

    public final SmeStudentListModel copy(long cdTime, Object cdTimeTempUw, List<SmeStudentModel> data, int interval, int limit, String message, boolean status, int time) {
        Intrinsics.checkNotNullParameter(cdTimeTempUw, "cdTimeTempUw");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(message, "message");
        return new SmeStudentListModel(cdTime, cdTimeTempUw, data, interval, limit, message, status, time);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SmeStudentListModel)) {
            return false;
        }
        SmeStudentListModel smeStudentListModel = (SmeStudentListModel) other;
        return this.cdTime == smeStudentListModel.cdTime && Intrinsics.areEqual(this.cdTimeTempUw, smeStudentListModel.cdTimeTempUw) && Intrinsics.areEqual(this.data, smeStudentListModel.data) && this.interval == smeStudentListModel.interval && this.limit == smeStudentListModel.limit && Intrinsics.areEqual(this.message, smeStudentListModel.message) && this.status == smeStudentListModel.status && this.time == smeStudentListModel.time;
    }

    public int hashCode() {
        return (((((((((((((Long.hashCode(this.cdTime) * 31) + this.cdTimeTempUw.hashCode()) * 31) + this.data.hashCode()) * 31) + Integer.hashCode(this.interval)) * 31) + Integer.hashCode(this.limit)) * 31) + this.message.hashCode()) * 31) + Boolean.hashCode(this.status)) * 31) + Integer.hashCode(this.time);
    }

    public String toString() {
        return "SmeStudentListModel(cdTime=" + this.cdTime + ", cdTimeTempUw=" + this.cdTimeTempUw + ", data=" + this.data + ", interval=" + this.interval + ", limit=" + this.limit + ", message=" + this.message + ", status=" + this.status + ", time=" + this.time + ")";
    }

    public SmeStudentListModel(long j, Object cdTimeTempUw, List<SmeStudentModel> data, int i, int i2, String message, boolean z, int i3) {
        Intrinsics.checkNotNullParameter(cdTimeTempUw, "cdTimeTempUw");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(message, "message");
        this.cdTime = j;
        this.cdTimeTempUw = cdTimeTempUw;
        this.data = data;
        this.interval = i;
        this.limit = i2;
        this.message = message;
        this.status = z;
        this.time = i3;
    }

    public final long getCdTime() {
        return this.cdTime;
    }

    public final Object getCdTimeTempUw() {
        return this.cdTimeTempUw;
    }

    public final List<SmeStudentModel> getData() {
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
