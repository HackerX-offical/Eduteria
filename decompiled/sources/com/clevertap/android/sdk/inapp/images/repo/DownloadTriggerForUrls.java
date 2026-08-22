package com.clevertap.android.sdk.inapp.images.repo;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileResourcesRepoImpl.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/clevertap/android/sdk/inapp/images/repo/DownloadTriggerForUrls;", "", "urls", "", "", "callback", "Lkotlin/Function0;", "", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;)V", "getUrls", "()Ljava/util/List;", "getCallback", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class DownloadTriggerForUrls {
    private final Function0<Unit> callback;
    private final List<String> urls;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DownloadTriggerForUrls copy$default(DownloadTriggerForUrls downloadTriggerForUrls, List list, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            list = downloadTriggerForUrls.urls;
        }
        if ((i & 2) != 0) {
            function0 = downloadTriggerForUrls.callback;
        }
        return downloadTriggerForUrls.copy(list, function0);
    }

    public final List<String> component1() {
        return this.urls;
    }

    public final Function0<Unit> component2() {
        return this.callback;
    }

    public final DownloadTriggerForUrls copy(List<String> urls, Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(urls, "urls");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return new DownloadTriggerForUrls(urls, callback);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadTriggerForUrls)) {
            return false;
        }
        DownloadTriggerForUrls downloadTriggerForUrls = (DownloadTriggerForUrls) other;
        return Intrinsics.areEqual(this.urls, downloadTriggerForUrls.urls) && Intrinsics.areEqual(this.callback, downloadTriggerForUrls.callback);
    }

    public int hashCode() {
        return (this.urls.hashCode() * 31) + this.callback.hashCode();
    }

    public String toString() {
        return "DownloadTriggerForUrls(urls=" + this.urls + ", callback=" + this.callback + ')';
    }

    public DownloadTriggerForUrls(List<String> urls, Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(urls, "urls");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.urls = urls;
        this.callback = callback;
    }

    public final List<String> getUrls() {
        return this.urls;
    }

    public final Function0<Unit> getCallback() {
        return this.callback;
    }
}
