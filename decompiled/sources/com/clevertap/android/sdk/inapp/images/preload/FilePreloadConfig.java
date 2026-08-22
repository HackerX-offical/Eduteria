package com.clevertap.android.sdk.inapp.images.preload;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import cz.msebera.android.httpclient.client.config.CookieSpecs;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FilePreloadConfig.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/clevertap/android/sdk/inapp/images/preload/FilePreloadConfig;", "", "parallelDownloads", "", "<init>", "(I)V", "getParallelDownloads", "()I", "component1", Constants.COPY_TYPE, "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class FilePreloadConfig {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int DEFAULT_PARALLEL_DOWNLOAD = 4;
    private final int parallelDownloads;

    public static /* synthetic */ FilePreloadConfig copy$default(FilePreloadConfig filePreloadConfig, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = filePreloadConfig.parallelDownloads;
        }
        return filePreloadConfig.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getParallelDownloads() {
        return this.parallelDownloads;
    }

    public final FilePreloadConfig copy(int parallelDownloads) {
        return new FilePreloadConfig(parallelDownloads);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FilePreloadConfig) && this.parallelDownloads == ((FilePreloadConfig) other).parallelDownloads;
    }

    public int hashCode() {
        return Integer.hashCode(this.parallelDownloads);
    }

    public String toString() {
        return "FilePreloadConfig(parallelDownloads=" + this.parallelDownloads + ')';
    }

    public FilePreloadConfig(int i) {
        this.parallelDownloads = i;
    }

    public final int getParallelDownloads() {
        return this.parallelDownloads;
    }

    /* JADX INFO: compiled from: FilePreloadConfig.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/clevertap/android/sdk/inapp/images/preload/FilePreloadConfig$Companion;", "", "<init>", "()V", "DEFAULT_PARALLEL_DOWNLOAD", "", CookieSpecs.DEFAULT, "Lcom/clevertap/android/sdk/inapp/images/preload/FilePreloadConfig;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: default, reason: not valid java name */
        public final FilePreloadConfig m11914default() {
            return new FilePreloadConfig(4);
        }
    }
}
