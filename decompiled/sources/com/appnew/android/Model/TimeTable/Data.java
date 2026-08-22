package com.appnew.android.Model.TimeTable;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.gson.annotations.SerializedName;
import com.tv9news.utils.helpers.AnalyticsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Data.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b=\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\u0095\u0001\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0003HÆ\u0001J\u0013\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010C\u001a\u00020DHÖ\u0001J\t\u0010E\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0014\"\u0004\b&\u0010\u0016R\u001e\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010\u0016R\u001e\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0014\"\u0004\b*\u0010\u0016R\u001e\u0010\u000e\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0014\"\u0004\b,\u0010\u0016R\u001e\u0010\u000f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0014\"\u0004\b.\u0010\u0016R\u001e\u0010\u0010\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0014\"\u0004\b0\u0010\u0016¨\u0006F"}, d2 = {"Lcom/appnew/android/Model/TimeTable/Data;", "", "batch", "", "date", SDKConstants.PARAM_END_TIME, "id", "startTime", "status", "app_id", "type", "teacher", "teacherCode", "title", "courseName", "testCenterName", "subjectName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBatch", "()Ljava/lang/String;", "setBatch", "(Ljava/lang/String;)V", "getDate", "setDate", "getEndTime", "setEndTime", "getId", "setId", "getStartTime", "setStartTime", "getStatus", "setStatus", "getApp_id", "setApp_id", "getType", "setType", "getTeacher", "setTeacher", "getTeacherCode", "setTeacherCode", "getTitle", "setTitle", "getCourseName", "setCourseName", "getTestCenterName", "setTestCenterName", "getSubjectName", "setSubjectName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Data {
    public static final int $stable = 8;

    @SerializedName("app_id")
    private String app_id;

    @SerializedName("batch")
    private String batch;

    @SerializedName(AnalyticsConstants.course_name)
    private String courseName;

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

    @SerializedName("subject_names")
    private String subjectName;

    @SerializedName("teacher")
    private String teacher;

    @SerializedName("teacher_code")
    private String teacherCode;

    @SerializedName("test_center_name")
    private String testCenterName;

    @SerializedName("title")
    private String title;

    @SerializedName("type")
    private String type;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBatch() {
        return this.batch;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getTeacherCode() {
        return this.teacherCode;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getCourseName() {
        return this.courseName;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getTestCenterName() {
        return this.testCenterName;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getSubjectName() {
        return this.subjectName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getEndTime() {
        return this.endTime;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getStartTime() {
        return this.startTime;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getApp_id() {
        return this.app_id;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getTeacher() {
        return this.teacher;
    }

    public final Data copy(String batch, String date, String endTime, String id, String startTime, String status, String app_id, String type, String teacher, String teacherCode, String title, String courseName, String testCenterName, String subjectName) {
        Intrinsics.checkNotNullParameter(batch, "batch");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(app_id, "app_id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(teacher, "teacher");
        Intrinsics.checkNotNullParameter(teacherCode, "teacherCode");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(courseName, "courseName");
        Intrinsics.checkNotNullParameter(testCenterName, "testCenterName");
        Intrinsics.checkNotNullParameter(subjectName, "subjectName");
        return new Data(batch, date, endTime, id, startTime, status, app_id, type, teacher, teacherCode, title, courseName, testCenterName, subjectName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Data)) {
            return false;
        }
        Data data = (Data) other;
        return Intrinsics.areEqual(this.batch, data.batch) && Intrinsics.areEqual(this.date, data.date) && Intrinsics.areEqual(this.endTime, data.endTime) && Intrinsics.areEqual(this.id, data.id) && Intrinsics.areEqual(this.startTime, data.startTime) && Intrinsics.areEqual(this.status, data.status) && Intrinsics.areEqual(this.app_id, data.app_id) && Intrinsics.areEqual(this.type, data.type) && Intrinsics.areEqual(this.teacher, data.teacher) && Intrinsics.areEqual(this.teacherCode, data.teacherCode) && Intrinsics.areEqual(this.title, data.title) && Intrinsics.areEqual(this.courseName, data.courseName) && Intrinsics.areEqual(this.testCenterName, data.testCenterName) && Intrinsics.areEqual(this.subjectName, data.subjectName);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((this.batch.hashCode() * 31) + this.date.hashCode()) * 31) + this.endTime.hashCode()) * 31) + this.id.hashCode()) * 31) + this.startTime.hashCode()) * 31) + this.status.hashCode()) * 31) + this.app_id.hashCode()) * 31) + this.type.hashCode()) * 31) + this.teacher.hashCode()) * 31) + this.teacherCode.hashCode()) * 31) + this.title.hashCode()) * 31) + this.courseName.hashCode()) * 31) + this.testCenterName.hashCode()) * 31) + this.subjectName.hashCode();
    }

    public String toString() {
        return "Data(batch=" + this.batch + ", date=" + this.date + ", endTime=" + this.endTime + ", id=" + this.id + ", startTime=" + this.startTime + ", status=" + this.status + ", app_id=" + this.app_id + ", type=" + this.type + ", teacher=" + this.teacher + ", teacherCode=" + this.teacherCode + ", title=" + this.title + ", courseName=" + this.courseName + ", testCenterName=" + this.testCenterName + ", subjectName=" + this.subjectName + ")";
    }

    public Data(String batch, String date, String endTime, String id, String startTime, String status, String app_id, String type, String teacher, String teacherCode, String title, String courseName, String testCenterName, String subjectName) {
        Intrinsics.checkNotNullParameter(batch, "batch");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(app_id, "app_id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(teacher, "teacher");
        Intrinsics.checkNotNullParameter(teacherCode, "teacherCode");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(courseName, "courseName");
        Intrinsics.checkNotNullParameter(testCenterName, "testCenterName");
        Intrinsics.checkNotNullParameter(subjectName, "subjectName");
        this.batch = batch;
        this.date = date;
        this.endTime = endTime;
        this.id = id;
        this.startTime = startTime;
        this.status = status;
        this.app_id = app_id;
        this.type = type;
        this.teacher = teacher;
        this.teacherCode = teacherCode;
        this.title = title;
        this.courseName = courseName;
        this.testCenterName = testCenterName;
        this.subjectName = subjectName;
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

    public final String getApp_id() {
        return this.app_id;
    }

    public final void setApp_id(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.app_id = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
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

    public final String getCourseName() {
        return this.courseName;
    }

    public final void setCourseName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.courseName = str;
    }

    public final String getTestCenterName() {
        return this.testCenterName;
    }

    public final void setTestCenterName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.testCenterName = str;
    }

    public final String getSubjectName() {
        return this.subjectName;
    }

    public final void setSubjectName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subjectName = str;
    }
}
