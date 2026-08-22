package com.pallycon.widevine.model;

import com.pallycon.widevine.exception.PallyConException;
import com.pallycon.widevine.exception.PallyConLicenseServerException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0013"}, d2 = {"Lcom/pallycon/widevine/model/PallyConEventListener;", "", "onCompleted", "", "contentData", "Lcom/pallycon/widevine/model/ContentData;", "onFailed", "e", "Lcom/pallycon/widevine/exception/PallyConException;", "Lcom/pallycon/widevine/exception/PallyConLicenseServerException;", "onPaused", "onProgress", "percent", "", "downloadedBytes", "", "onRemoved", "onRestarting", "onStopped", "widevine_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface PallyConEventListener {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onCompleted(PallyConEventListener pallyConEventListener, ContentData contentData) {
            Intrinsics.checkNotNullParameter(contentData, "contentData");
        }

        public static void onFailed(PallyConEventListener pallyConEventListener, ContentData contentData, PallyConException pallyConException) {
            Intrinsics.checkNotNullParameter(contentData, "contentData");
        }

        public static void onPaused(PallyConEventListener pallyConEventListener, ContentData contentData) {
            Intrinsics.checkNotNullParameter(contentData, "contentData");
        }

        public static void onProgress(PallyConEventListener pallyConEventListener, ContentData contentData, float f2, long j) {
            Intrinsics.checkNotNullParameter(contentData, "contentData");
        }

        public static void onRemoved(PallyConEventListener pallyConEventListener, ContentData contentData) {
            Intrinsics.checkNotNullParameter(contentData, "contentData");
        }

        public static void onRestarting(PallyConEventListener pallyConEventListener, ContentData contentData) {
            Intrinsics.checkNotNullParameter(contentData, "contentData");
        }

        public static void onStopped(PallyConEventListener pallyConEventListener, ContentData contentData) {
            Intrinsics.checkNotNullParameter(contentData, "contentData");
        }

        public static void onFailed(PallyConEventListener pallyConEventListener, ContentData contentData, PallyConLicenseServerException pallyConLicenseServerException) {
            Intrinsics.checkNotNullParameter(contentData, "contentData");
        }
    }

    void onCompleted(ContentData contentData);

    void onFailed(ContentData contentData, PallyConException e2);

    void onFailed(ContentData contentData, PallyConLicenseServerException e2);

    void onPaused(ContentData contentData);

    void onProgress(ContentData contentData, float percent, long downloadedBytes);

    void onRemoved(ContentData contentData);

    void onRestarting(ContentData contentData);

    void onStopped(ContentData contentData);
}
