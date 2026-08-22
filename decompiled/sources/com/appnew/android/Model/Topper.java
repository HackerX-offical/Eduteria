package com.appnew.android.Model;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Topper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003JY\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006&"}, d2 = {"Lcom/appnew/android/Model/Topper;", "Ljava/io/Serializable;", "total_attempted", "", "accuracy", "time_taken_seconds", "test_series_marks", "best_score", "user_id", "increase_marks", "hide_topper", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTotal_attempted", "()Ljava/lang/String;", "getAccuracy", "getTime_taken_seconds", "getTest_series_marks", "getBest_score", "getUser_id", "getIncrease_marks", "getHide_topper", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", Constants.COPY_TYPE, "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Topper implements Serializable {
    public static final int $stable = 0;

    @SerializedName("accuracy")
    private final String accuracy;

    @SerializedName("best_score")
    private final String best_score;

    @SerializedName("hide_topper")
    private final String hide_topper;

    @SerializedName("increase_marks")
    private final String increase_marks;

    @SerializedName("test_series_marks")
    private final String test_series_marks;

    @SerializedName("time_taken_seconds")
    private final String time_taken_seconds;

    @SerializedName("total_attempted")
    private final String total_attempted;

    @SerializedName("user_id")
    private final String user_id;

    public static /* synthetic */ Topper copy$default(Topper topper, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, Object obj) {
        if ((i & 1) != 0) {
            str = topper.total_attempted;
        }
        if ((i & 2) != 0) {
            str2 = topper.accuracy;
        }
        if ((i & 4) != 0) {
            str3 = topper.time_taken_seconds;
        }
        if ((i & 8) != 0) {
            str4 = topper.test_series_marks;
        }
        if ((i & 16) != 0) {
            str5 = topper.best_score;
        }
        if ((i & 32) != 0) {
            str6 = topper.user_id;
        }
        if ((i & 64) != 0) {
            str7 = topper.increase_marks;
        }
        if ((i & 128) != 0) {
            str8 = topper.hide_topper;
        }
        String str9 = str7;
        String str10 = str8;
        String str11 = str5;
        String str12 = str6;
        return topper.copy(str, str2, str3, str4, str11, str12, str9, str10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTotal_attempted() {
        return this.total_attempted;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAccuracy() {
        return this.accuracy;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTime_taken_seconds() {
        return this.time_taken_seconds;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTest_series_marks() {
        return this.test_series_marks;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getBest_score() {
        return this.best_score;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getUser_id() {
        return this.user_id;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getIncrease_marks() {
        return this.increase_marks;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getHide_topper() {
        return this.hide_topper;
    }

    public final Topper copy(String total_attempted, String accuracy, String time_taken_seconds, String test_series_marks, String best_score, String user_id, String increase_marks, String hide_topper) {
        Intrinsics.checkNotNullParameter(total_attempted, "total_attempted");
        Intrinsics.checkNotNullParameter(accuracy, "accuracy");
        Intrinsics.checkNotNullParameter(time_taken_seconds, "time_taken_seconds");
        Intrinsics.checkNotNullParameter(test_series_marks, "test_series_marks");
        Intrinsics.checkNotNullParameter(best_score, "best_score");
        Intrinsics.checkNotNullParameter(user_id, "user_id");
        Intrinsics.checkNotNullParameter(increase_marks, "increase_marks");
        Intrinsics.checkNotNullParameter(hide_topper, "hide_topper");
        return new Topper(total_attempted, accuracy, time_taken_seconds, test_series_marks, best_score, user_id, increase_marks, hide_topper);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Topper)) {
            return false;
        }
        Topper topper = (Topper) other;
        return Intrinsics.areEqual(this.total_attempted, topper.total_attempted) && Intrinsics.areEqual(this.accuracy, topper.accuracy) && Intrinsics.areEqual(this.time_taken_seconds, topper.time_taken_seconds) && Intrinsics.areEqual(this.test_series_marks, topper.test_series_marks) && Intrinsics.areEqual(this.best_score, topper.best_score) && Intrinsics.areEqual(this.user_id, topper.user_id) && Intrinsics.areEqual(this.increase_marks, topper.increase_marks) && Intrinsics.areEqual(this.hide_topper, topper.hide_topper);
    }

    public int hashCode() {
        return (((((((((((((this.total_attempted.hashCode() * 31) + this.accuracy.hashCode()) * 31) + this.time_taken_seconds.hashCode()) * 31) + this.test_series_marks.hashCode()) * 31) + this.best_score.hashCode()) * 31) + this.user_id.hashCode()) * 31) + this.increase_marks.hashCode()) * 31) + this.hide_topper.hashCode();
    }

    public String toString() {
        return "Topper(total_attempted=" + this.total_attempted + ", accuracy=" + this.accuracy + ", time_taken_seconds=" + this.time_taken_seconds + ", test_series_marks=" + this.test_series_marks + ", best_score=" + this.best_score + ", user_id=" + this.user_id + ", increase_marks=" + this.increase_marks + ", hide_topper=" + this.hide_topper + ")";
    }

    public Topper(String total_attempted, String accuracy, String time_taken_seconds, String test_series_marks, String best_score, String user_id, String increase_marks, String hide_topper) {
        Intrinsics.checkNotNullParameter(total_attempted, "total_attempted");
        Intrinsics.checkNotNullParameter(accuracy, "accuracy");
        Intrinsics.checkNotNullParameter(time_taken_seconds, "time_taken_seconds");
        Intrinsics.checkNotNullParameter(test_series_marks, "test_series_marks");
        Intrinsics.checkNotNullParameter(best_score, "best_score");
        Intrinsics.checkNotNullParameter(user_id, "user_id");
        Intrinsics.checkNotNullParameter(increase_marks, "increase_marks");
        Intrinsics.checkNotNullParameter(hide_topper, "hide_topper");
        this.total_attempted = total_attempted;
        this.accuracy = accuracy;
        this.time_taken_seconds = time_taken_seconds;
        this.test_series_marks = test_series_marks;
        this.best_score = best_score;
        this.user_id = user_id;
        this.increase_marks = increase_marks;
        this.hide_topper = hide_topper;
    }

    public final String getTotal_attempted() {
        return this.total_attempted;
    }

    public final String getAccuracy() {
        return this.accuracy;
    }

    public final String getTime_taken_seconds() {
        return this.time_taken_seconds;
    }

    public final String getTest_series_marks() {
        return this.test_series_marks;
    }

    public final String getBest_score() {
        return this.best_score;
    }

    public final String getUser_id() {
        return this.user_id;
    }

    public final String getIncrease_marks() {
        return this.increase_marks;
    }

    public final String getHide_topper() {
        return this.hide_topper;
    }
}
