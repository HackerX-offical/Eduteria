package com.appnew.android.Model.TeacherTimeTable;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TeacherTimeTableModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b(\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u0019\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\t\u0010,\u001a\u00020\tHÆ\u0003J\t\u0010-\u001a\u00020\tHÆ\u0003J\t\u0010.\u001a\u00020\fHÆ\u0003J\t\u0010/\u001a\u00020\u000eHÆ\u0003J\t\u00100\u001a\u00020\tHÆ\u0003J_\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001J\u0013\u00102\u001a\u00020\u000e2\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\tHÖ\u0001J\t\u00105\u001a\u00020\fHÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R.\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001d¨\u00066"}, d2 = {"Lcom/appnew/android/Model/TeacherTimeTable/TeacherTimeTableModel;", "", "cdTime", "", "data", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/TeacherTimeTable/Data;", "Lkotlin/collections/ArrayList;", "interval", "", Constants.KEY_LIMIT, "message", "", "status", "", "time", "<init>", "(JLjava/util/ArrayList;IILjava/lang/String;ZI)V", "getCdTime", "()J", "setCdTime", "(J)V", "getData", "()Ljava/util/ArrayList;", "setData", "(Ljava/util/ArrayList;)V", "getInterval", "()I", "setInterval", "(I)V", "getLimit", "setLimit", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getStatus", "()Z", "setStatus", "(Z)V", "getTime", "setTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", Constants.COPY_TYPE, "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class TeacherTimeTableModel {
    public static final int $stable = 8;

    @SerializedName("cd_time")
    private long cdTime;

    @SerializedName("data")
    private ArrayList<Data> data;

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
    public static /* synthetic */ TeacherTimeTableModel copy$default(TeacherTimeTableModel teacherTimeTableModel, long j, ArrayList arrayList, int i, int i2, String str, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            j = teacherTimeTableModel.cdTime;
        }
        long j2 = j;
        if ((i4 & 2) != 0) {
            arrayList = teacherTimeTableModel.data;
        }
        ArrayList arrayList2 = arrayList;
        if ((i4 & 4) != 0) {
            i = teacherTimeTableModel.interval;
        }
        int i5 = i;
        if ((i4 & 8) != 0) {
            i2 = teacherTimeTableModel.limit;
        }
        int i6 = i2;
        if ((i4 & 16) != 0) {
            str = teacherTimeTableModel.message;
        }
        return teacherTimeTableModel.copy(j2, arrayList2, i5, i6, str, (i4 & 32) != 0 ? teacherTimeTableModel.status : z, (i4 & 64) != 0 ? teacherTimeTableModel.time : i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getCdTime() {
        return this.cdTime;
    }

    public final ArrayList<Data> component2() {
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

    public final TeacherTimeTableModel copy(long cdTime, ArrayList<Data> data, int interval, int limit, String message, boolean status, int time) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(message, "message");
        return new TeacherTimeTableModel(cdTime, data, interval, limit, message, status, time);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TeacherTimeTableModel)) {
            return false;
        }
        TeacherTimeTableModel teacherTimeTableModel = (TeacherTimeTableModel) other;
        return this.cdTime == teacherTimeTableModel.cdTime && Intrinsics.areEqual(this.data, teacherTimeTableModel.data) && this.interval == teacherTimeTableModel.interval && this.limit == teacherTimeTableModel.limit && Intrinsics.areEqual(this.message, teacherTimeTableModel.message) && this.status == teacherTimeTableModel.status && this.time == teacherTimeTableModel.time;
    }

    public int hashCode() {
        return (((((((((((Long.hashCode(this.cdTime) * 31) + this.data.hashCode()) * 31) + Integer.hashCode(this.interval)) * 31) + Integer.hashCode(this.limit)) * 31) + this.message.hashCode()) * 31) + Boolean.hashCode(this.status)) * 31) + Integer.hashCode(this.time);
    }

    public String toString() {
        return "TeacherTimeTableModel(cdTime=" + this.cdTime + ", data=" + this.data + ", interval=" + this.interval + ", limit=" + this.limit + ", message=" + this.message + ", status=" + this.status + ", time=" + this.time + ")";
    }

    public TeacherTimeTableModel(long j, ArrayList<Data> data, int i, int i2, String message, boolean z, int i3) {
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

    public final ArrayList<Data> getData() {
        return this.data;
    }

    public final void setData(ArrayList<Data> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.data = arrayList;
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
