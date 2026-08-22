package com.clevertap.android.sdk.inapp.images.repo;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileResourcesRepoImpl.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/clevertap/android/sdk/inapp/images/repo/DownloadTriggerResult;", "", "successfulUrls", "", "", "failureUrls", "allSuccessful", "", "<init>", "(Ljava/util/List;Ljava/util/List;Z)V", "getSuccessfulUrls", "()Ljava/util/List;", "getFailureUrls", "getAllSuccessful", "()Z", "component1", "component2", "component3", Constants.COPY_TYPE, "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class DownloadTriggerResult {
    private final boolean allSuccessful;
    private final List<String> failureUrls;
    private final List<String> successfulUrls;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DownloadTriggerResult copy$default(DownloadTriggerResult downloadTriggerResult, List list, List list2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            list = downloadTriggerResult.successfulUrls;
        }
        if ((i & 2) != 0) {
            list2 = downloadTriggerResult.failureUrls;
        }
        if ((i & 4) != 0) {
            z = downloadTriggerResult.allSuccessful;
        }
        return downloadTriggerResult.copy(list, list2, z);
    }

    public final List<String> component1() {
        return this.successfulUrls;
    }

    public final List<String> component2() {
        return this.failureUrls;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getAllSuccessful() {
        return this.allSuccessful;
    }

    public final DownloadTriggerResult copy(List<String> successfulUrls, List<String> failureUrls, boolean allSuccessful) {
        Intrinsics.checkNotNullParameter(successfulUrls, "successfulUrls");
        Intrinsics.checkNotNullParameter(failureUrls, "failureUrls");
        return new DownloadTriggerResult(successfulUrls, failureUrls, allSuccessful);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadTriggerResult)) {
            return false;
        }
        DownloadTriggerResult downloadTriggerResult = (DownloadTriggerResult) other;
        return Intrinsics.areEqual(this.successfulUrls, downloadTriggerResult.successfulUrls) && Intrinsics.areEqual(this.failureUrls, downloadTriggerResult.failureUrls) && this.allSuccessful == downloadTriggerResult.allSuccessful;
    }

    public int hashCode() {
        return (((this.successfulUrls.hashCode() * 31) + this.failureUrls.hashCode()) * 31) + Boolean.hashCode(this.allSuccessful);
    }

    public String toString() {
        return "DownloadTriggerResult(successfulUrls=" + this.successfulUrls + ", failureUrls=" + this.failureUrls + ", allSuccessful=" + this.allSuccessful + ')';
    }

    public DownloadTriggerResult(List<String> successfulUrls, List<String> failureUrls, boolean z) {
        Intrinsics.checkNotNullParameter(successfulUrls, "successfulUrls");
        Intrinsics.checkNotNullParameter(failureUrls, "failureUrls");
        this.successfulUrls = successfulUrls;
        this.failureUrls = failureUrls;
        this.allSuccessful = z;
    }

    public final List<String> getSuccessfulUrls() {
        return this.successfulUrls;
    }

    public final List<String> getFailureUrls() {
        return this.failureUrls;
    }

    public final boolean getAllSuccessful() {
        return this.allSuccessful;
    }
}
