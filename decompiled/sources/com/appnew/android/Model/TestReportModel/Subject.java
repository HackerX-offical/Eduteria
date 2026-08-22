package com.appnew.android.Model.TestReportModel;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Subject.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\u000f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011HÆ\u0003J\u009b\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011HÆ\u0001J\u0013\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010G\u001a\u00020HHÖ\u0001J\t\u0010I\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u0018R\u001e\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u0018R\u001e\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0016\"\u0004\b,\u0010\u0018R\u001e\u0010\u000e\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0016\"\u0004\b.\u0010\u0018R\u001e\u0010\u000f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0016\"\u0004\b0\u0010\u0018R$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u0006J"}, d2 = {"Lcom/appnew/android/Model/TestReportModel/Subject;", "", "attempted", "", "avgMark", "correctCount", "id", "incorrectCount", "marks", "maxMark", "nonAttempt", "percentage", "percentile", "rank", "reportId", "subject", "leaderBoard", "", "Lcom/appnew/android/Model/TestReportModel/LeaderBoard;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAttempted", "()Ljava/lang/String;", "setAttempted", "(Ljava/lang/String;)V", "getAvgMark", "setAvgMark", "getCorrectCount", "setCorrectCount", "getId", "setId", "getIncorrectCount", "setIncorrectCount", "getMarks", "setMarks", "getMaxMark", "setMaxMark", "getNonAttempt", "setNonAttempt", "getPercentage", "setPercentage", "getPercentile", "setPercentile", "getRank", "setRank", "getReportId", "setReportId", "getSubject", "setSubject", "getLeaderBoard", "()Ljava/util/List;", "setLeaderBoard", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Subject {
    public static final int $stable = 8;

    @SerializedName("attempted")
    private String attempted;

    @SerializedName("avg_mark")
    private String avgMark;

    @SerializedName("correct_count")
    private String correctCount;

    @SerializedName("id")
    private String id;

    @SerializedName("incorrect_count")
    private String incorrectCount;

    @SerializedName("leader_board")
    private List<LeaderBoard> leaderBoard;

    @SerializedName("marks")
    private String marks;

    @SerializedName("max_mark")
    private String maxMark;

    @SerializedName("non_attempt")
    private String nonAttempt;

    @SerializedName("percentage")
    private String percentage;

    @SerializedName("percentile")
    private String percentile;

    @SerializedName("rank")
    private String rank;

    @SerializedName("report_id")
    private String reportId;

    @SerializedName("subject")
    private String subject;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAttempted() {
        return this.attempted;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getPercentile() {
        return this.percentile;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getRank() {
        return this.rank;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getReportId() {
        return this.reportId;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    public final List<LeaderBoard> component14() {
        return this.leaderBoard;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAvgMark() {
        return this.avgMark;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCorrectCount() {
        return this.correctCount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getIncorrectCount() {
        return this.incorrectCount;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getMarks() {
        return this.marks;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getMaxMark() {
        return this.maxMark;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getNonAttempt() {
        return this.nonAttempt;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getPercentage() {
        return this.percentage;
    }

    public final Subject copy(String attempted, String avgMark, String correctCount, String id, String incorrectCount, String marks, String maxMark, String nonAttempt, String percentage, String percentile, String rank, String reportId, String subject, List<LeaderBoard> leaderBoard) {
        Intrinsics.checkNotNullParameter(attempted, "attempted");
        Intrinsics.checkNotNullParameter(avgMark, "avgMark");
        Intrinsics.checkNotNullParameter(correctCount, "correctCount");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(incorrectCount, "incorrectCount");
        Intrinsics.checkNotNullParameter(marks, "marks");
        Intrinsics.checkNotNullParameter(maxMark, "maxMark");
        Intrinsics.checkNotNullParameter(nonAttempt, "nonAttempt");
        Intrinsics.checkNotNullParameter(percentage, "percentage");
        Intrinsics.checkNotNullParameter(percentile, "percentile");
        Intrinsics.checkNotNullParameter(rank, "rank");
        Intrinsics.checkNotNullParameter(reportId, "reportId");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(leaderBoard, "leaderBoard");
        return new Subject(attempted, avgMark, correctCount, id, incorrectCount, marks, maxMark, nonAttempt, percentage, percentile, rank, reportId, subject, leaderBoard);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Subject)) {
            return false;
        }
        Subject subject = (Subject) other;
        return Intrinsics.areEqual(this.attempted, subject.attempted) && Intrinsics.areEqual(this.avgMark, subject.avgMark) && Intrinsics.areEqual(this.correctCount, subject.correctCount) && Intrinsics.areEqual(this.id, subject.id) && Intrinsics.areEqual(this.incorrectCount, subject.incorrectCount) && Intrinsics.areEqual(this.marks, subject.marks) && Intrinsics.areEqual(this.maxMark, subject.maxMark) && Intrinsics.areEqual(this.nonAttempt, subject.nonAttempt) && Intrinsics.areEqual(this.percentage, subject.percentage) && Intrinsics.areEqual(this.percentile, subject.percentile) && Intrinsics.areEqual(this.rank, subject.rank) && Intrinsics.areEqual(this.reportId, subject.reportId) && Intrinsics.areEqual(this.subject, subject.subject) && Intrinsics.areEqual(this.leaderBoard, subject.leaderBoard);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((this.attempted.hashCode() * 31) + this.avgMark.hashCode()) * 31) + this.correctCount.hashCode()) * 31) + this.id.hashCode()) * 31) + this.incorrectCount.hashCode()) * 31) + this.marks.hashCode()) * 31) + this.maxMark.hashCode()) * 31) + this.nonAttempt.hashCode()) * 31) + this.percentage.hashCode()) * 31) + this.percentile.hashCode()) * 31) + this.rank.hashCode()) * 31) + this.reportId.hashCode()) * 31) + this.subject.hashCode()) * 31) + this.leaderBoard.hashCode();
    }

    public String toString() {
        return "Subject(attempted=" + this.attempted + ", avgMark=" + this.avgMark + ", correctCount=" + this.correctCount + ", id=" + this.id + ", incorrectCount=" + this.incorrectCount + ", marks=" + this.marks + ", maxMark=" + this.maxMark + ", nonAttempt=" + this.nonAttempt + ", percentage=" + this.percentage + ", percentile=" + this.percentile + ", rank=" + this.rank + ", reportId=" + this.reportId + ", subject=" + this.subject + ", leaderBoard=" + this.leaderBoard + ")";
    }

    public Subject(String attempted, String avgMark, String correctCount, String id, String incorrectCount, String marks, String maxMark, String nonAttempt, String percentage, String percentile, String rank, String reportId, String subject, List<LeaderBoard> leaderBoard) {
        Intrinsics.checkNotNullParameter(attempted, "attempted");
        Intrinsics.checkNotNullParameter(avgMark, "avgMark");
        Intrinsics.checkNotNullParameter(correctCount, "correctCount");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(incorrectCount, "incorrectCount");
        Intrinsics.checkNotNullParameter(marks, "marks");
        Intrinsics.checkNotNullParameter(maxMark, "maxMark");
        Intrinsics.checkNotNullParameter(nonAttempt, "nonAttempt");
        Intrinsics.checkNotNullParameter(percentage, "percentage");
        Intrinsics.checkNotNullParameter(percentile, "percentile");
        Intrinsics.checkNotNullParameter(rank, "rank");
        Intrinsics.checkNotNullParameter(reportId, "reportId");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(leaderBoard, "leaderBoard");
        this.attempted = attempted;
        this.avgMark = avgMark;
        this.correctCount = correctCount;
        this.id = id;
        this.incorrectCount = incorrectCount;
        this.marks = marks;
        this.maxMark = maxMark;
        this.nonAttempt = nonAttempt;
        this.percentage = percentage;
        this.percentile = percentile;
        this.rank = rank;
        this.reportId = reportId;
        this.subject = subject;
        this.leaderBoard = leaderBoard;
    }

    public final String getAttempted() {
        return this.attempted;
    }

    public final void setAttempted(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.attempted = str;
    }

    public final String getAvgMark() {
        return this.avgMark;
    }

    public final void setAvgMark(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.avgMark = str;
    }

    public final String getCorrectCount() {
        return this.correctCount;
    }

    public final void setCorrectCount(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.correctCount = str;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final String getIncorrectCount() {
        return this.incorrectCount;
    }

    public final void setIncorrectCount(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.incorrectCount = str;
    }

    public final String getMarks() {
        return this.marks;
    }

    public final void setMarks(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.marks = str;
    }

    public final String getMaxMark() {
        return this.maxMark;
    }

    public final void setMaxMark(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.maxMark = str;
    }

    public final String getNonAttempt() {
        return this.nonAttempt;
    }

    public final void setNonAttempt(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nonAttempt = str;
    }

    public final String getPercentage() {
        return this.percentage;
    }

    public final void setPercentage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.percentage = str;
    }

    public final String getPercentile() {
        return this.percentile;
    }

    public final void setPercentile(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.percentile = str;
    }

    public final String getRank() {
        return this.rank;
    }

    public final void setRank(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rank = str;
    }

    public final String getReportId() {
        return this.reportId;
    }

    public final void setReportId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.reportId = str;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final void setSubject(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subject = str;
    }

    public final List<LeaderBoard> getLeaderBoard() {
        return this.leaderBoard;
    }

    public final void setLeaderBoard(List<LeaderBoard> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.leaderBoard = list;
    }
}
