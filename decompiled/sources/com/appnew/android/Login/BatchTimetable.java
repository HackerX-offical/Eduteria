package com.appnew.android.Login;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BatchTimetable.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b-\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003Jm\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u000204HÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R\u001e\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012¨\u00066"}, d2 = {"Lcom/appnew/android/Login/BatchTimetable;", "", "appId", "", "batch", "date", SDKConstants.PARAM_END_TIME, "id", "startTime", "status", "teacher", "teacherCode", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "getBatch", "setBatch", "getDate", "setDate", "getEndTime", "setEndTime", "getId", "setId", "getStartTime", "setStartTime", "getStatus", "setStatus", "getTeacher", "setTeacher", "getTeacherCode", "setTeacherCode", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class BatchTimetable {
    public static final int $stable = 8;

    @SerializedName("app_id")
    private String appId;

    @SerializedName("batch")
    private String batch;

    @SerializedName("date")
    private String date;

    @SerializedName(SDKConstants.PARAM_TOURNAMENTS_END_TIME)
    private String endTime;

    @SerializedName("id")
    private String id;

    @SerializedName("start_time")
    private String startTime;

    @SerializedName("status")
    private String status;

    @SerializedName("teacher")
    private String teacher;

    @SerializedName("teacher_code")
    private String teacherCode;

    @SerializedName("title")
    private String title;

    public static /* synthetic */ BatchTimetable copy$default(BatchTimetable batchTimetable, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, Object obj) {
        if ((i & 1) != 0) {
            str = batchTimetable.appId;
        }
        if ((i & 2) != 0) {
            str2 = batchTimetable.batch;
        }
        if ((i & 4) != 0) {
            str3 = batchTimetable.date;
        }
        if ((i & 8) != 0) {
            str4 = batchTimetable.endTime;
        }
        if ((i & 16) != 0) {
            str5 = batchTimetable.id;
        }
        if ((i & 32) != 0) {
            str6 = batchTimetable.startTime;
        }
        if ((i & 64) != 0) {
            str7 = batchTimetable.status;
        }
        if ((i & 128) != 0) {
            str8 = batchTimetable.teacher;
        }
        if ((i & 256) != 0) {
            str9 = batchTimetable.teacherCode;
        }
        if ((i & 512) != 0) {
            str10 = batchTimetable.title;
        }
        String str11 = str9;
        String str12 = str10;
        String str13 = str7;
        String str14 = str8;
        String str15 = str5;
        String str16 = str6;
        return batchTimetable.copy(str, str2, str3, str4, str15, str16, str13, str14, str11, str12);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getBatch() {
        return this.batch;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getEndTime() {
        return this.endTime;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getStartTime() {
        return this.startTime;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getTeacher() {
        return this.teacher;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getTeacherCode() {
        return this.teacherCode;
    }

    public final BatchTimetable copy(String appId, String batch, String date, String endTime, String id, String startTime, String status, String teacher, String teacherCode, String title) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(batch, "batch");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(teacher, "teacher");
        Intrinsics.checkNotNullParameter(teacherCode, "teacherCode");
        Intrinsics.checkNotNullParameter(title, "title");
        return new BatchTimetable(appId, batch, date, endTime, id, startTime, status, teacher, teacherCode, title);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BatchTimetable)) {
            return false;
        }
        BatchTimetable batchTimetable = (BatchTimetable) other;
        return Intrinsics.areEqual(this.appId, batchTimetable.appId) && Intrinsics.areEqual(this.batch, batchTimetable.batch) && Intrinsics.areEqual(this.date, batchTimetable.date) && Intrinsics.areEqual(this.endTime, batchTimetable.endTime) && Intrinsics.areEqual(this.id, batchTimetable.id) && Intrinsics.areEqual(this.startTime, batchTimetable.startTime) && Intrinsics.areEqual(this.status, batchTimetable.status) && Intrinsics.areEqual(this.teacher, batchTimetable.teacher) && Intrinsics.areEqual(this.teacherCode, batchTimetable.teacherCode) && Intrinsics.areEqual(this.title, batchTimetable.title);
    }

    public int hashCode() {
        return (((((((((((((((((this.appId.hashCode() * 31) + this.batch.hashCode()) * 31) + this.date.hashCode()) * 31) + this.endTime.hashCode()) * 31) + this.id.hashCode()) * 31) + this.startTime.hashCode()) * 31) + this.status.hashCode()) * 31) + this.teacher.hashCode()) * 31) + this.teacherCode.hashCode()) * 31) + this.title.hashCode();
    }

    public String toString() {
        return "BatchTimetable(appId=" + this.appId + ", batch=" + this.batch + ", date=" + this.date + ", endTime=" + this.endTime + ", id=" + this.id + ", startTime=" + this.startTime + ", status=" + this.status + ", teacher=" + this.teacher + ", teacherCode=" + this.teacherCode + ", title=" + this.title + ")";
    }

    public BatchTimetable(String appId, String batch, String date, String endTime, String id, String startTime, String status, String teacher, String teacherCode, String title) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(batch, "batch");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(teacher, "teacher");
        Intrinsics.checkNotNullParameter(teacherCode, "teacherCode");
        Intrinsics.checkNotNullParameter(title, "title");
        this.appId = appId;
        this.batch = batch;
        this.date = date;
        this.endTime = endTime;
        this.id = id;
        this.startTime = startTime;
        this.status = status;
        this.teacher = teacher;
        this.teacherCode = teacherCode;
        this.title = title;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final void setAppId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appId = str;
    }

    public final String getBatch() {
        return this.batch;
    }

    public final void setBatch(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.batch = str;
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.date = str;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final void setEndTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.endTime = str;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final void setStartTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.startTime = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.status = str;
    }

    public final String getTeacher() {
        return this.teacher;
    }

    public final void setTeacher(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.teacher = str;
    }

    public final String getTeacherCode() {
        return this.teacherCode;
    }

    public final void setTeacherCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.teacherCode = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }
}
