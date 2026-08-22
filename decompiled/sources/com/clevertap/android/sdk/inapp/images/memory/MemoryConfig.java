package com.clevertap.android.sdk.inapp.images.memory;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MemoryConfig.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/clevertap/android/sdk/inapp/images/memory/MemoryConfig;", "", "minInMemorySizeKB", "", "optimistic", "maxDiskSizeKB", "diskDirectory", "Ljava/io/File;", "<init>", "(JJJLjava/io/File;)V", "getMinInMemorySizeKB", "()J", "getOptimistic", "getMaxDiskSizeKB", "getDiskDirectory", "()Ljava/io/File;", "component1", "component2", "component3", "component4", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class MemoryConfig {
    private final File diskDirectory;
    private final long maxDiskSizeKB;
    private final long minInMemorySizeKB;
    private final long optimistic;

    public static /* synthetic */ MemoryConfig copy$default(MemoryConfig memoryConfig, long j, long j2, long j3, File file, int i, Object obj) {
        if ((i & 1) != 0) {
            j = memoryConfig.minInMemorySizeKB;
        }
        long j4 = j;
        if ((i & 2) != 0) {
            j2 = memoryConfig.optimistic;
        }
        long j5 = j2;
        if ((i & 4) != 0) {
            j3 = memoryConfig.maxDiskSizeKB;
        }
        long j6 = j3;
        if ((i & 8) != 0) {
            file = memoryConfig.diskDirectory;
        }
        return memoryConfig.copy(j4, j5, j6, file);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getMinInMemorySizeKB() {
        return this.minInMemorySizeKB;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getOptimistic() {
        return this.optimistic;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getMaxDiskSizeKB() {
        return this.maxDiskSizeKB;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final File getDiskDirectory() {
        return this.diskDirectory;
    }

    public final MemoryConfig copy(long minInMemorySizeKB, long optimistic, long maxDiskSizeKB, File diskDirectory) {
        Intrinsics.checkNotNullParameter(diskDirectory, "diskDirectory");
        return new MemoryConfig(minInMemorySizeKB, optimistic, maxDiskSizeKB, diskDirectory);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemoryConfig)) {
            return false;
        }
        MemoryConfig memoryConfig = (MemoryConfig) other;
        return this.minInMemorySizeKB == memoryConfig.minInMemorySizeKB && this.optimistic == memoryConfig.optimistic && this.maxDiskSizeKB == memoryConfig.maxDiskSizeKB && Intrinsics.areEqual(this.diskDirectory, memoryConfig.diskDirectory);
    }

    public int hashCode() {
        return (((((Long.hashCode(this.minInMemorySizeKB) * 31) + Long.hashCode(this.optimistic)) * 31) + Long.hashCode(this.maxDiskSizeKB)) * 31) + this.diskDirectory.hashCode();
    }

    public String toString() {
        return "MemoryConfig(minInMemorySizeKB=" + this.minInMemorySizeKB + ", optimistic=" + this.optimistic + ", maxDiskSizeKB=" + this.maxDiskSizeKB + ", diskDirectory=" + this.diskDirectory + ')';
    }

    public MemoryConfig(long j, long j2, long j3, File diskDirectory) {
        Intrinsics.checkNotNullParameter(diskDirectory, "diskDirectory");
        this.minInMemorySizeKB = j;
        this.optimistic = j2;
        this.maxDiskSizeKB = j3;
        this.diskDirectory = diskDirectory;
    }

    public final long getMinInMemorySizeKB() {
        return this.minInMemorySizeKB;
    }

    public final long getOptimistic() {
        return this.optimistic;
    }

    public final long getMaxDiskSizeKB() {
        return this.maxDiskSizeKB;
    }

    public final File getDiskDirectory() {
        return this.diskDirectory;
    }
}
