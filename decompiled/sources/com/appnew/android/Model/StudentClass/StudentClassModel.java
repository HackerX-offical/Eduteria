package com.appnew.android.Model.StudentClass;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StudentClassModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b(\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010+\u001a\u00020\bHÆ\u0003J\t\u0010,\u001a\u00020\bHÆ\u0003J\t\u0010-\u001a\u00020\u000bHÆ\u0003J\t\u0010.\u001a\u00020\rHÆ\u0003J\t\u0010/\u001a\u00020\bHÆ\u0003JU\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\bHÆ\u0001J\u0013\u00101\u001a\u00020\r2\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\bHÖ\u0001J\t\u00104\u001a\u00020\u000bHÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001c¨\u00065"}, d2 = {"Lcom/appnew/android/Model/StudentClass/StudentClassModel;", "", "cdTime", "", "data", "", "Lcom/appnew/android/Model/StudentClass/Data;", "interval", "", Constants.KEY_LIMIT, "message", "", "status", "", "time", "<init>", "(JLjava/util/List;IILjava/lang/String;ZI)V", "getCdTime", "()J", "setCdTime", "(J)V", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "getInterval", "()I", "setInterval", "(I)V", "getLimit", "setLimit", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getStatus", "()Z", "setStatus", "(Z)V", "getTime", "setTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", Constants.COPY_TYPE, "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class StudentClassModel {
    public static final int $stable = 8;

    @SerializedName("cd_time")
    private long cdTime;

    @SerializedName("data")
    private List<Data> data;

    @SerializedName("interval")
    private int interval;

    @SerializedName(Constants.KEY_LIMIT)
    private int limit;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private boolean status;

    @SerializedName("time")
    private int time;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StudentClassModel copy$default(StudentClassModel studentClassModel, long j, List list, int i, int i2, String str, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            j = studentClassModel.cdTime;
        }
        long j2 = j;
        if ((i4 & 2) != 0) {
            list = studentClassModel.data;
        }
        List list2 = list;
        if ((i4 & 4) != 0) {
            i = studentClassModel.interval;
        }
        int i5 = i;
        if ((i4 & 8) != 0) {
            i2 = studentClassModel.limit;
        }
        int i6 = i2;
        if ((i4 & 16) != 0) {
            str = studentClassModel.message;
        }
        return studentClassModel.copy(j2, list2, i5, i6, str, (i4 & 32) != 0 ? studentClassModel.status : z, (i4 & 64) != 0 ? studentClassModel.time : i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getCdTime() {
        return this.cdTime;
    }

    public final List<Data> component2() {
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

    public final StudentClassModel copy(long cdTime, List<Data> data, int interval, int limit, String message, boolean status, int time) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(message, "message");
        return new StudentClassModel(cdTime, data, interval, limit, message, status, time);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StudentClassModel)) {
            return false;
        }
        StudentClassModel studentClassModel = (StudentClassModel) other;
        return this.cdTime == studentClassModel.cdTime && Intrinsics.areEqual(this.data, studentClassModel.data) && this.interval == studentClassModel.interval && this.limit == studentClassModel.limit && Intrinsics.areEqual(this.message, studentClassModel.message) && this.status == studentClassModel.status && this.time == studentClassModel.time;
    }

    public int hashCode() {
        return (((((((((((Long.hashCode(this.cdTime) * 31) + this.data.hashCode()) * 31) + Integer.hashCode(this.interval)) * 31) + Integer.hashCode(this.limit)) * 31) + this.message.hashCode()) * 31) + Boolean.hashCode(this.status)) * 31) + Integer.hashCode(this.time);
    }

    public String toString() {
        return "StudentClassModel(cdTime=" + this.cdTime + ", data=" + this.data + ", interval=" + this.interval + ", limit=" + this.limit + ", message=" + this.message + ", status=" + this.status + ", time=" + this.time + ")";
    }

    public StudentClassModel(long j, List<Data> data, int i, int i2, String message, boolean z, int i3) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(message, "message");
        this.cdTime = j;
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

    public final void setCdTime(long j) {
        this.cdTime = j;
    }

    public final List<Data> getData() {
        return this.data;
    }

    public final void setData(List<Data> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.data = list;
    }

    public final int getInterval() {
        return this.interval;
    }

    public final void setInterval(int i) {
        this.interval = i;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final void setLimit(int i) {
        this.limit = i;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.message = str;
    }

    public final boolean getStatus() {
        return this.status;
    }

    public final void setStatus(boolean z) {
        this.status = z;
    }

    public final int getTime() {
        return this.time;
    }

    public final void setTime(int i) {
        this.time = i;
    }
}
