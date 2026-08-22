package com.clevertap.android.sdk.inapp.images.memory;

import androidx.exifinterface.media.ExifInterface;
import com.clevertap.android.sdk.utils.DiskMemory;
import com.clevertap.android.sdk.utils.InMemoryLruCache;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: compiled from: Memory.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001a\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u00050\u0004H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/clevertap/android/sdk/inapp/images/memory/Memory;", ExifInterface.GPS_DIRECTION_TRUE, "", "createInMemory", "Lcom/clevertap/android/sdk/utils/InMemoryLruCache;", "Lkotlin/Pair;", "Ljava/io/File;", "createDiskMemory", "Lcom/clevertap/android/sdk/utils/DiskMemory;", "inMemorySize", "", "freeInMemory", "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface Memory<T> {
    DiskMemory createDiskMemory();

    InMemoryLruCache<Pair<T, File>> createInMemory();

    void freeInMemory();

    int inMemorySize();
}
