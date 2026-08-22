package com.clevertap.android.sdk.utils;

import com.clevertap.android.sdk.ILogger;
import com.clevertap.android.sdk.inapp.images.repo.FileResourcesRepoImplKt;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DiskMemory.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bBH\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012#\b\u0002\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\nJ\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\nJ\u0006\u0010\u0019\u001a\u00020\u0013J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\n0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/clevertap/android/sdk/utils/DiskMemory;", "", "directory", "Ljava/io/File;", "maxFileSizeKb", "", "logger", "Lcom/clevertap/android/sdk/ILogger;", "hashFunction", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "key", "<init>", "(Ljava/io/File;ILcom/clevertap/android/sdk/ILogger;Lkotlin/jvm/functions/Function1;)V", "getHashFunction$clevertap_core_release", "()Lkotlin/jvm/functions/Function1;", "add", "", "value", "", "addAndReturnFileInstance", "get", "remove", "empty", "fetchFile", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DiskMemory {
    private static final String FILE_PREFIX = "CT_FILE";
    private final File directory;
    private final Function1<String, String> hashFunction;
    private final ILogger logger;
    private final int maxFileSizeKb;

    /* JADX WARN: Multi-variable type inference failed */
    public DiskMemory(File directory, int i, ILogger iLogger, Function1<? super String, String> hashFunction) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(hashFunction, "hashFunction");
        this.directory = directory;
        this.maxFileSizeKb = i;
        this.logger = iLogger;
        this.hashFunction = hashFunction;
    }

    public /* synthetic */ DiskMemory(File file, int i, ILogger iLogger, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, i, (i2 & 4) != 0 ? null : iLogger, (i2 & 8) != 0 ? UrlHashGenerator.INSTANCE.hash() : function1);
    }

    public final Function1<String, String> getHashFunction$clevertap_core_release() {
        return this.hashFunction;
    }

    public final boolean add(String key, byte[] value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            addAndReturnFileInstance(key, value);
            return true;
        } catch (Exception e2) {
            ILogger iLogger = this.logger;
            if (iLogger == null) {
                return false;
            }
            iLogger.verbose("Error while adding file to disk. Key: " + key + ", Value Size: " + value.length + " bytes", e2);
            return false;
        }
    }

    public final File addAndReturnFileInstance(String key, byte[] value) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        if (CacheKt.sizeInKb(value) > this.maxFileSizeKb) {
            remove(key);
            throw new IllegalArgumentException("File size exceeds the maximum limit of " + this.maxFileSizeKb);
        }
        File fileFetchFile = fetchFile(key);
        if (fileFetchFile.exists()) {
            fileFetchFile.delete();
        }
        File fileFetchFile2 = fetchFile(key);
        ILogger iLogger = this.logger;
        if (iLogger != null) {
            iLogger.verbose(FileResourcesRepoImplKt.TAG_FILE_DOWNLOAD, "mapped file path - " + fileFetchFile2.getAbsoluteFile() + " to key - " + key);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(fileFetchFile2);
        fileOutputStream.write(value);
        fileOutputStream.close();
        return fileFetchFile2;
    }

    public final File get(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        File fileFetchFile = fetchFile(key);
        if (fileFetchFile.exists()) {
            return fileFetchFile;
        }
        return null;
    }

    public final boolean remove(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        File fileFetchFile = fetchFile(key);
        if (!fileFetchFile.exists()) {
            return false;
        }
        fileFetchFile.delete();
        return true;
    }

    public final boolean empty() {
        return FilesKt.deleteRecursively(this.directory);
    }

    private final File fetchFile(String key) {
        return new File(this.directory + "/CT_FILE_" + this.hashFunction.invoke(key));
    }
}
