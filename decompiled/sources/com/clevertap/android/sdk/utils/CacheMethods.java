package com.clevertap.android.sdk.utils;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: Cache.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0002\u0010\bJ\u0017\u0010\t\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0005\u001a\u00020\u0006H&¢\u0006\u0002\u0010\nJ\u0017\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0005\u001a\u00020\u0006H&¢\u0006\u0002\u0010\nJ\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u0004H&¨\u0006\u000f"}, d2 = {"Lcom/clevertap/android/sdk/utils/CacheMethods;", ExifInterface.GPS_DIRECTION_TRUE, "", "add", "", "key", "", "value", "(Ljava/lang/String;Ljava/lang/Object;)Z", "get", "(Ljava/lang/String;)Ljava/lang/Object;", "remove", "empty", "", "isEmpty", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface CacheMethods<T> {
    boolean add(String key, T value);

    void empty();

    T get(String key);

    boolean isEmpty();

    T remove(String key);
}
