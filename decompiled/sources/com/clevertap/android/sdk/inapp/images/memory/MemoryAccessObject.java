package com.clevertap.android.sdk.inapp.images.memory;

import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: compiled from: MemoryAccessObject.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007H&J+\u0010\b\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0001\u0010\t2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000bH&¢\u0006\u0002\u0010\fJ+\u0010\r\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0001\u0010\t2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000bH&¢\u0006\u0002\u0010\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004H&J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0013H&J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001e\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u0016"}, d2 = {"Lcom/clevertap/android/sdk/inapp/images/memory/MemoryAccessObject;", ExifInterface.GPS_DIRECTION_TRUE, "", "fetchInMemory", "Lkotlin/Pair;", "Ljava/io/File;", "key", "", "fetchInMemoryAndTransform", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "transformTo", "Lcom/clevertap/android/sdk/inapp/images/memory/MemoryDataTransformationType;", "(Ljava/lang/String;Lcom/clevertap/android/sdk/inapp/images/memory/MemoryDataTransformationType;)Ljava/lang/Object;", "fetchDiskMemoryAndTransform", "fetchDiskMemory", "saveInMemory", "", "data", "saveDiskMemory", "", "removeDiskMemory", "removeInMemory", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MemoryAccessObject<T> {
    File fetchDiskMemory(String key);

    <A> A fetchDiskMemoryAndTransform(String key, MemoryDataTransformationType<A> transformTo);

    Pair<T, File> fetchInMemory(String key);

    <A> A fetchInMemoryAndTransform(String key, MemoryDataTransformationType<A> transformTo);

    boolean removeDiskMemory(String key);

    Pair<T, File> removeInMemory(String key);

    File saveDiskMemory(String key, byte[] data);

    boolean saveInMemory(String key, Pair<? extends T, ? extends File> data);
}
