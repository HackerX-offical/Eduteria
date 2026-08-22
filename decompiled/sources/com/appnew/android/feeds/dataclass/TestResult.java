package com.appnew.android.feeds.dataclass;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.appnew.android.Courses.Activity.QuizActivity;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TestResult.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0000J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006$"}, d2 = {"Lcom/appnew/android/feeds/dataclass/TestResult;", "", "attempts", "", "course_id", "id", "image", "state", "test_series_name", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAttempts", "()Ljava/lang/String;", "getCourse_id", "getId", "getImage", "getState", "getTest_series_name", "click", "", "v", "Landroid/view/View;", "testresultdata", "component1", "component2", "component3", "component4", "component5", "component6", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class TestResult {
    public static final int $stable = 0;
    private final String attempts;
    private final String course_id;
    private final String id;
    private final String image;
    private final String state;
    private final String test_series_name;

    public static /* synthetic */ TestResult copy$default(TestResult testResult, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = testResult.attempts;
        }
        if ((i & 2) != 0) {
            str2 = testResult.course_id;
        }
        if ((i & 4) != 0) {
            str3 = testResult.id;
        }
        if ((i & 8) != 0) {
            str4 = testResult.image;
        }
        if ((i & 16) != 0) {
            str5 = testResult.state;
        }
        if ((i & 32) != 0) {
            str6 = testResult.test_series_name;
        }
        String str7 = str5;
        String str8 = str6;
        return testResult.copy(str, str2, str3, str4, str7, str8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAttempts() {
        return this.attempts;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCourse_id() {
        return this.course_id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getTest_series_name() {
        return this.test_series_name;
    }

    public final TestResult copy(String attempts, String course_id, String id, String image, String state, String test_series_name) {
        Intrinsics.checkNotNullParameter(attempts, "attempts");
        Intrinsics.checkNotNullParameter(course_id, "course_id");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(test_series_name, "test_series_name");
        return new TestResult(attempts, course_id, id, image, state, test_series_name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TestResult)) {
            return false;
        }
        TestResult testResult = (TestResult) other;
        return Intrinsics.areEqual(this.attempts, testResult.attempts) && Intrinsics.areEqual(this.course_id, testResult.course_id) && Intrinsics.areEqual(this.id, testResult.id) && Intrinsics.areEqual(this.image, testResult.image) && Intrinsics.areEqual(this.state, testResult.state) && Intrinsics.areEqual(this.test_series_name, testResult.test_series_name);
    }

    public int hashCode() {
        return (((((((((this.attempts.hashCode() * 31) + this.course_id.hashCode()) * 31) + this.id.hashCode()) * 31) + this.image.hashCode()) * 31) + this.state.hashCode()) * 31) + this.test_series_name.hashCode();
    }

    public String toString() {
        return "TestResult(attempts=" + this.attempts + ", course_id=" + this.course_id + ", id=" + this.id + ", image=" + this.image + ", state=" + this.state + ", test_series_name=" + this.test_series_name + ")";
    }

    public TestResult(String attempts, String course_id, String id, String image, String state, String test_series_name) {
        Intrinsics.checkNotNullParameter(attempts, "attempts");
        Intrinsics.checkNotNullParameter(course_id, "course_id");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(test_series_name, "test_series_name");
        this.attempts = attempts;
        this.course_id = course_id;
        this.id = id;
        this.image = image;
        this.state = state;
        this.test_series_name = test_series_name;
    }

    public final String getAttempts() {
        return this.attempts;
    }

    public final String getCourse_id() {
        return this.course_id;
    }

    public final String getId() {
        return this.id;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getState() {
        return this.state;
    }

    public final String getTest_series_name() {
        return this.test_series_name;
    }

    public final void click(View v, TestResult testresultdata) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(testresultdata, "testresultdata");
        if (Intrinsics.areEqual(testresultdata.state, "1")) {
            Intent intent = new Intent(v.getContext(), (Class<?>) QuizActivity.class);
            intent.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
            intent.putExtra("status", testresultdata.id);
            intent.putExtra("name", testresultdata.test_series_name);
            intent.putExtra("first_attempt", "1");
            Context context = v.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            Helper.gotoActivity(intent, (Activity) context);
            return;
        }
        Intent intent2 = new Intent(v.getContext(), (Class<?>) QuizActivity.class);
        intent2.putExtra(Const.FRAG_TYPE, "leader_board");
        intent2.putExtra("status", testresultdata.id);
        intent2.putExtra("name", testresultdata.test_series_name);
        Context context2 = v.getContext();
        Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
        Helper.gotoActivity(intent2, (Activity) context2);
    }
}
