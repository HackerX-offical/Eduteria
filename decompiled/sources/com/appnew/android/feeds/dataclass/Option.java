package com.appnew.android.feeds.dataclass;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Option.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/appnew/android/feeds/dataclass/Option;", "", "attempt_count", "", "option", "attempt_index", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAttempt_count", "()Ljava/lang/String;", "setAttempt_count", "(Ljava/lang/String;)V", "getOption", "setOption", "getAttempt_index", "setAttempt_index", "component1", "component2", "component3", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Option {
    public static final int $stable = 8;
    private String attempt_count;
    private String attempt_index;
    private String option;

    public static /* synthetic */ Option copy$default(Option option, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = option.attempt_count;
        }
        if ((i & 2) != 0) {
            str2 = option.option;
        }
        if ((i & 4) != 0) {
            str3 = option.attempt_index;
        }
        return option.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAttempt_count() {
        return this.attempt_count;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getOption() {
        return this.option;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAttempt_index() {
        return this.attempt_index;
    }

    public final Option copy(String attempt_count, String option, String attempt_index) {
        Intrinsics.checkNotNullParameter(attempt_count, "attempt_count");
        Intrinsics.checkNotNullParameter(option, "option");
        return new Option(attempt_count, option, attempt_index);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Option)) {
            return false;
        }
        Option option = (Option) other;
        return Intrinsics.areEqual(this.attempt_count, option.attempt_count) && Intrinsics.areEqual(this.option, option.option) && Intrinsics.areEqual(this.attempt_index, option.attempt_index);
    }

    public int hashCode() {
        int iHashCode = ((this.attempt_count.hashCode() * 31) + this.option.hashCode()) * 31;
        String str = this.attempt_index;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "Option(attempt_count=" + this.attempt_count + ", option=" + this.option + ", attempt_index=" + this.attempt_index + ")";
    }

    public Option(String attempt_count, String option, String str) {
        Intrinsics.checkNotNullParameter(attempt_count, "attempt_count");
        Intrinsics.checkNotNullParameter(option, "option");
        this.attempt_count = attempt_count;
        this.option = option;
        this.attempt_index = str;
    }

    public final String getAttempt_count() {
        return this.attempt_count;
    }

    public final void setAttempt_count(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.attempt_count = str;
    }

    public final String getOption() {
        return this.option;
    }

    public final void setOption(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.option = str;
    }

    public final String getAttempt_index() {
        return this.attempt_index;
    }

    public final void setAttempt_index(String str) {
        this.attempt_index = str;
    }
}
