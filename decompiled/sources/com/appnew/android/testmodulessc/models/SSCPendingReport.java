package com.appnew.android.testmodulessc.models;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SSCPendingReport.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/appnew/android/testmodulessc/models/SSCPendingReport;", "", "optionId", "", "feedback", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getOptionId", "()Ljava/lang/String;", "getFeedback", "component1", "component2", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class SSCPendingReport {
    public static final int $stable = 0;
    private final String feedback;
    private final String optionId;

    public static /* synthetic */ SSCPendingReport copy$default(SSCPendingReport sSCPendingReport, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sSCPendingReport.optionId;
        }
        if ((i & 2) != 0) {
            str2 = sSCPendingReport.feedback;
        }
        return sSCPendingReport.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOptionId() {
        return this.optionId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFeedback() {
        return this.feedback;
    }

    public final SSCPendingReport copy(String optionId, String feedback) {
        Intrinsics.checkNotNullParameter(optionId, "optionId");
        Intrinsics.checkNotNullParameter(feedback, "feedback");
        return new SSCPendingReport(optionId, feedback);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SSCPendingReport)) {
            return false;
        }
        SSCPendingReport sSCPendingReport = (SSCPendingReport) other;
        return Intrinsics.areEqual(this.optionId, sSCPendingReport.optionId) && Intrinsics.areEqual(this.feedback, sSCPendingReport.feedback);
    }

    public int hashCode() {
        return (this.optionId.hashCode() * 31) + this.feedback.hashCode();
    }

    public String toString() {
        return "SSCPendingReport(optionId=" + this.optionId + ", feedback=" + this.feedback + ")";
    }

    public SSCPendingReport(String optionId, String feedback) {
        Intrinsics.checkNotNullParameter(optionId, "optionId");
        Intrinsics.checkNotNullParameter(feedback, "feedback");
        this.optionId = optionId;
        this.feedback = feedback;
    }

    public final String getOptionId() {
        return this.optionId;
    }

    public final String getFeedback() {
        return this.feedback;
    }
}
