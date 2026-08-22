package com.pallycon.widevine.model;

import androidx.media3.datasource.cache.Cache;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/pallycon/widevine/model/PallyConFileInformation;", "", "downloadedFileSize", "", "downloadedFileCache", "Landroidx/media3/datasource/cache/Cache;", "downloadedFileDirectory", "Ljava/io/File;", "(JLandroidx/media3/datasource/cache/Cache;Ljava/io/File;)V", "getDownloadedFileCache", "()Landroidx/media3/datasource/cache/Cache;", "getDownloadedFileDirectory", "()Ljava/io/File;", "getDownloadedFileSize", "()J", "component1", "component2", "component3", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "widevine_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class PallyConFileInformation {
    private final Cache downloadedFileCache;
    private final File downloadedFileDirectory;
    private final long downloadedFileSize;

    public PallyConFileInformation(long j, Cache cache, File file) {
        this.downloadedFileSize = j;
        this.downloadedFileCache = cache;
        this.downloadedFileDirectory = file;
    }

    public static /* synthetic */ PallyConFileInformation copy$default(PallyConFileInformation pallyConFileInformation, long j, Cache cache, File file, int i, Object obj) {
        if ((i & 1) != 0) {
            j = pallyConFileInformation.downloadedFileSize;
        }
        if ((i & 2) != 0) {
            cache = pallyConFileInformation.downloadedFileCache;
        }
        if ((i & 4) != 0) {
            file = pallyConFileInformation.downloadedFileDirectory;
        }
        return pallyConFileInformation.copy(j, cache, file);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getDownloadedFileSize() {
        return this.downloadedFileSize;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Cache getDownloadedFileCache() {
        return this.downloadedFileCache;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final File getDownloadedFileDirectory() {
        return this.downloadedFileDirectory;
    }

    public final PallyConFileInformation copy(long downloadedFileSize, Cache downloadedFileCache, File downloadedFileDirectory) {
        return new PallyConFileInformation(downloadedFileSize, downloadedFileCache, downloadedFileDirectory);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PallyConFileInformation)) {
            return false;
        }
        PallyConFileInformation pallyConFileInformation = (PallyConFileInformation) other;
        return this.downloadedFileSize == pallyConFileInformation.downloadedFileSize && Intrinsics.areEqual(this.downloadedFileCache, pallyConFileInformation.downloadedFileCache) && Intrinsics.areEqual(this.downloadedFileDirectory, pallyConFileInformation.downloadedFileDirectory);
    }

    public final Cache getDownloadedFileCache() {
        return this.downloadedFileCache;
    }

    public final File getDownloadedFileDirectory() {
        return this.downloadedFileDirectory;
    }

    public final long getDownloadedFileSize() {
        return this.downloadedFileSize;
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.downloadedFileSize) * 31;
        Cache cache = this.downloadedFileCache;
        int iHashCode2 = (iHashCode + (cache == null ? 0 : cache.hashCode())) * 31;
        File file = this.downloadedFileDirectory;
        return iHashCode2 + (file != null ? file.hashCode() : 0);
    }

    public String toString() {
        return "PallyConFileInformation(downloadedFileSize=" + this.downloadedFileSize + ", downloadedFileCache=" + this.downloadedFileCache + ", downloadedFileDirectory=" + this.downloadedFileDirectory + ')';
    }
}
