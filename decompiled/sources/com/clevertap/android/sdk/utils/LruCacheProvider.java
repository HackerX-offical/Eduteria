package com.clevertap.android.sdk.utils;

import android.util.LruCache;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;

/* JADX INFO: compiled from: Cache.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00070\u0005\"\b\b\u0000\u0010\u0007*\u00020\u00012\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/clevertap/android/sdk/utils/LruCacheProvider;", "", "<init>", "()V", "provide", "Landroid/util/LruCache;", "", ExifInterface.GPS_DIRECTION_TRUE, SDKConstants.PARAM_CONTEXT_MAX_SIZE, "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LruCacheProvider {
    public static final LruCacheProvider INSTANCE = new LruCacheProvider();

    private LruCacheProvider() {
    }

    public final <T> LruCache<String, T> provide(final int maxSize) {
        return new LruCache<String, T>(maxSize) { // from class: com.clevertap.android.sdk.utils.LruCacheProvider$provide$$inlined$lruCache$default$1
            @Override // android.util.LruCache
            protected T create(String key) {
                return null;
            }

            @Override // android.util.LruCache
            protected void entryRemoved(boolean evicted, String key, T oldValue, T newValue) {
            }

            @Override // android.util.LruCache
            protected int sizeOf(String key, T value) {
                return CacheKt.sizeInKb(value);
            }
        };
    }
}
