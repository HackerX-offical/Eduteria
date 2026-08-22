package com.appnew.android.feeds.dataclass;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Json.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jw\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u000204HÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0011\"\u0004\b!\u0010\u0013R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013¨\u00066"}, d2 = {"Lcom/appnew/android/feeds/dataclass/Json;", "", "attempt_index", "", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "", "Lcom/appnew/android/feeds/dataclass/Option;", "right_ans", "total_attempt", "state", "time_in_mins", "total_questions", "test_series_name", "view_type", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAttempt_index", "()Ljava/lang/String;", "setAttempt_index", "(Ljava/lang/String;)V", "getOptions", "()Ljava/util/List;", "setOptions", "(Ljava/util/List;)V", "getRight_ans", "setRight_ans", "getTotal_attempt", "setTotal_attempt", "getState", "setState", "getTime_in_mins", "setTime_in_mins", "getTotal_questions", "setTotal_questions", "getTest_series_name", "setTest_series_name", "getView_type", "setView_type", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Json {
    public static final int $stable = 8;
    private String attempt_index;
    private List<Option> options;
    private String right_ans;
    private String state;
    private String test_series_name;
    private String time_in_mins;
    private String total_attempt;
    private String total_questions;
    private String view_type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Json copy$default(Json json, String str, List list, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, Object obj) {
        if ((i & 1) != 0) {
            str = json.attempt_index;
        }
        if ((i & 2) != 0) {
            list = json.options;
        }
        if ((i & 4) != 0) {
            str2 = json.right_ans;
        }
        if ((i & 8) != 0) {
            str3 = json.total_attempt;
        }
        if ((i & 16) != 0) {
            str4 = json.state;
        }
        if ((i & 32) != 0) {
            str5 = json.time_in_mins;
        }
        if ((i & 64) != 0) {
            str6 = json.total_questions;
        }
        if ((i & 128) != 0) {
            str7 = json.test_series_name;
        }
        if ((i & 256) != 0) {
            str8 = json.view_type;
        }
        String str9 = str7;
        String str10 = str8;
        String str11 = str5;
        String str12 = str6;
        String str13 = str4;
        String str14 = str2;
        return json.copy(str, list, str14, str3, str13, str11, str12, str9, str10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAttempt_index() {
        return this.attempt_index;
    }

    public final List<Option> component2() {
        return this.options;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRight_ans() {
        return this.right_ans;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTotal_attempt() {
        return this.total_attempt;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getTime_in_mins() {
        return this.time_in_mins;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getTotal_questions() {
        return this.total_questions;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getTest_series_name() {
        return this.test_series_name;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getView_type() {
        return this.view_type;
    }

    public final Json copy(String attempt_index, List<Option> options, String right_ans, String total_attempt, String state, String time_in_mins, String total_questions, String test_series_name, String view_type) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(right_ans, "right_ans");
        return new Json(attempt_index, options, right_ans, total_attempt, state, time_in_mins, total_questions, test_series_name, view_type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Json)) {
            return false;
        }
        Json json = (Json) other;
        return Intrinsics.areEqual(this.attempt_index, json.attempt_index) && Intrinsics.areEqual(this.options, json.options) && Intrinsics.areEqual(this.right_ans, json.right_ans) && Intrinsics.areEqual(this.total_attempt, json.total_attempt) && Intrinsics.areEqual(this.state, json.state) && Intrinsics.areEqual(this.time_in_mins, json.time_in_mins) && Intrinsics.areEqual(this.total_questions, json.total_questions) && Intrinsics.areEqual(this.test_series_name, json.test_series_name) && Intrinsics.areEqual(this.view_type, json.view_type);
    }

    public int hashCode() {
        String str = this.attempt_index;
        int iHashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.options.hashCode()) * 31) + this.right_ans.hashCode()) * 31;
        String str2 = this.total_attempt;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.state;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.time_in_mins;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.total_questions;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.test_series_name;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.view_type;
        return iHashCode6 + (str7 != null ? str7.hashCode() : 0);
    }

    public String toString() {
        return "Json(attempt_index=" + this.attempt_index + ", options=" + this.options + ", right_ans=" + this.right_ans + ", total_attempt=" + this.total_attempt + ", state=" + this.state + ", time_in_mins=" + this.time_in_mins + ", total_questions=" + this.total_questions + ", test_series_name=" + this.test_series_name + ", view_type=" + this.view_type + ")";
    }

    public Json(String str, List<Option> options, String right_ans, String str2, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(right_ans, "right_ans");
        this.attempt_index = str;
        this.options = options;
        this.right_ans = right_ans;
        this.total_attempt = str2;
        this.state = str3;
        this.time_in_mins = str4;
        this.total_questions = str5;
        this.test_series_name = str6;
        this.view_type = str7;
    }

    public final String getAttempt_index() {
        return this.attempt_index;
    }

    public final void setAttempt_index(String str) {
        this.attempt_index = str;
    }

    public final List<Option> getOptions() {
        return this.options;
    }

    public final void setOptions(List<Option> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.options = list;
    }

    public final String getRight_ans() {
        return this.right_ans;
    }

    public final void setRight_ans(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.right_ans = str;
    }

    public final String getTotal_attempt() {
        return this.total_attempt;
    }

    public final void setTotal_attempt(String str) {
        this.total_attempt = str;
    }

    public final String getState() {
        return this.state;
    }

    public final void setState(String str) {
        this.state = str;
    }

    public final String getTime_in_mins() {
        return this.time_in_mins;
    }

    public final void setTime_in_mins(String str) {
        this.time_in_mins = str;
    }

    public final String getTotal_questions() {
        return this.total_questions;
    }

    public final void setTotal_questions(String str) {
        this.total_questions = str;
    }

    public final String getTest_series_name() {
        return this.test_series_name;
    }

    public final void setTest_series_name(String str) {
        this.test_series_name = str;
    }

    public final String getView_type() {
        return this.view_type;
    }

    public final void setView_type(String str) {
        this.view_type = str;
    }
}
