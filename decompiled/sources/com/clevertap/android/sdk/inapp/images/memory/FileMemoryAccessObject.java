package com.clevertap.android.sdk.inapp.images.memory;

import androidx.exifinterface.media.ExifInterface;
import com.clevertap.android.sdk.ILogger;
import com.clevertap.android.sdk.inapp.images.memory.MemoryDataTransformationType;
import com.clevertap.android.sdk.inapp.images.repo.FileResourcesRepoImplKt;
import com.clevertap.android.sdk.utils.CTCaches;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileMemoryAccessObject.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\rH\u0016J+\u0010\u000e\u001a\u0004\u0018\u0001H\u000f\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0011H\u0016¢\u0006\u0002\u0010\u0012J+\u0010\u0013\u001a\u0004\u0018\u0001H\u000f\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0011H\u0016¢\u0006\u0002\u0010\u0012J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\rH\u0016J\u001e\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\rH\u0016J$\u0010\u001a\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/clevertap/android/sdk/inapp/images/memory/FileMemoryAccessObject;", "Lcom/clevertap/android/sdk/inapp/images/memory/MemoryAccessObject;", "", "ctCaches", "Lcom/clevertap/android/sdk/utils/CTCaches;", "logger", "Lcom/clevertap/android/sdk/ILogger;", "<init>", "(Lcom/clevertap/android/sdk/utils/CTCaches;Lcom/clevertap/android/sdk/ILogger;)V", "fetchInMemory", "Lkotlin/Pair;", "Ljava/io/File;", "key", "", "fetchInMemoryAndTransform", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "transformTo", "Lcom/clevertap/android/sdk/inapp/images/memory/MemoryDataTransformationType;", "(Ljava/lang/String;Lcom/clevertap/android/sdk/inapp/images/memory/MemoryDataTransformationType;)Ljava/lang/Object;", "fetchDiskMemoryAndTransform", "fetchDiskMemory", "saveDiskMemory", "data", "removeDiskMemory", "", "removeInMemory", "saveInMemory", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FileMemoryAccessObject implements MemoryAccessObject<byte[]> {
    private final CTCaches ctCaches;
    private final ILogger logger;

    public FileMemoryAccessObject(CTCaches ctCaches, ILogger iLogger) {
        Intrinsics.checkNotNullParameter(ctCaches, "ctCaches");
        this.ctCaches = ctCaches;
        this.logger = iLogger;
    }

    public /* synthetic */ FileMemoryAccessObject(CTCaches cTCaches, ILogger iLogger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(cTCaches, (i & 2) != 0 ? null : iLogger);
    }

    @Override // com.clevertap.android.sdk.inapp.images.memory.MemoryAccessObject
    public Pair<byte[], File> fetchInMemory(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.ctCaches.fileInMemory().get(key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.clevertap.android.sdk.inapp.images.memory.MemoryAccessObject
    public <A> A fetchInMemoryAndTransform(String key, MemoryDataTransformationType<A> transformTo) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(transformTo, "transformTo");
        Pair<byte[], File> pairFetchInMemory = fetchInMemory(key);
        if (pairFetchInMemory == null) {
            return null;
        }
        ILogger iLogger = this.logger;
        if (iLogger != null) {
            iLogger.verbose(FileResourcesRepoImplKt.TAG_FILE_DOWNLOAD, key + " data found in FILE in-memory");
        }
        if (Intrinsics.areEqual(transformTo, MemoryDataTransformationType.ToBitmap.INSTANCE)) {
            A a2 = (A) MemoryAccessObjectKt.getBytesToBitmap().invoke(pairFetchInMemory.getFirst());
            if (a2 == null) {
                return null;
            }
            return a2;
        }
        if (Intrinsics.areEqual(transformTo, MemoryDataTransformationType.ToByteArray.INSTANCE)) {
            A a3 = (A) pairFetchInMemory.getFirst();
            if (a3 == null) {
                return null;
            }
            return a3;
        }
        if (!Intrinsics.areEqual(transformTo, MemoryDataTransformationType.ToFile.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        A a4 = (A) pairFetchInMemory.getSecond();
        if (a4 == null) {
            return null;
        }
        return a4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.clevertap.android.sdk.inapp.images.memory.MemoryAccessObject
    public <A> A fetchDiskMemoryAndTransform(String key, MemoryDataTransformationType<A> transformTo) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(transformTo, "transformTo");
        A a2 = (A) fetchDiskMemory(key);
        if (a2 == null) {
            return null;
        }
        ILogger iLogger = this.logger;
        if (iLogger != null) {
            iLogger.verbose(FileResourcesRepoImplKt.TAG_FILE_DOWNLOAD, key + " data found in FILE disk memory");
        }
        A a3 = (A) MemoryAccessObjectKt.getFileToBytes().invoke(a2);
        if (a3 != null) {
            saveInMemory(key, new Pair<>(a3, a2));
        }
        if (Intrinsics.areEqual(transformTo, MemoryDataTransformationType.ToBitmap.INSTANCE)) {
            A a4 = (A) MemoryAccessObjectKt.getFileToBitmap().invoke(a2);
            if (a4 == null) {
                return null;
            }
            return a4;
        }
        if (Intrinsics.areEqual(transformTo, MemoryDataTransformationType.ToByteArray.INSTANCE)) {
            if (a3 instanceof Object) {
                return a3;
            }
            return null;
        }
        if (!Intrinsics.areEqual(transformTo, MemoryDataTransformationType.ToFile.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        if (a2 instanceof Object) {
            return a2;
        }
        return null;
    }

    @Override // com.clevertap.android.sdk.inapp.images.memory.MemoryAccessObject
    public File fetchDiskMemory(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        ILogger iLogger = this.logger;
        if (iLogger != null) {
            iLogger.verbose(FileResourcesRepoImplKt.TAG_FILE_DOWNLOAD, "FILE In-Memory cache miss for " + key + " data");
        }
        return this.ctCaches.fileDiskMemory().get(key);
    }

    @Override // com.clevertap.android.sdk.inapp.images.memory.MemoryAccessObject
    public File saveDiskMemory(String key, byte[] data) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(data, "data");
        return this.ctCaches.fileDiskMemory().addAndReturnFileInstance(key, data);
    }

    @Override // com.clevertap.android.sdk.inapp.images.memory.MemoryAccessObject
    public boolean removeDiskMemory(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        ILogger iLogger = this.logger;
        if (iLogger != null) {
            iLogger.verbose(FileResourcesRepoImplKt.TAG_FILE_DOWNLOAD, "If present, will remove " + key + " data from FILE disk-memory");
        }
        return this.ctCaches.fileDiskMemory().remove(key);
    }

    @Override // com.clevertap.android.sdk.inapp.images.memory.MemoryAccessObject
    public Pair<byte[], File> removeInMemory(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        ILogger iLogger = this.logger;
        if (iLogger != null) {
            iLogger.verbose(FileResourcesRepoImplKt.TAG_FILE_DOWNLOAD, "If present, will remove " + key + " data from FILE in-memory");
        }
        return this.ctCaches.fileInMemory().remove(key);
    }

    @Override // com.clevertap.android.sdk.inapp.images.memory.MemoryAccessObject
    public boolean saveInMemory(String key, Pair<? extends byte[], ? extends File> data) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(data, "data");
        ILogger iLogger = this.logger;
        if (iLogger != null) {
            iLogger.verbose(FileResourcesRepoImplKt.TAG_FILE_DOWNLOAD, "Saving " + key + " data in FILE in-memory");
        }
        return this.ctCaches.fileInMemory().add(key, data);
    }
}
