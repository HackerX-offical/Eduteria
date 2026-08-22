package com.clevertap.android.sdk.inapp.store.preference;

import com.clevertap.android.sdk.store.preference.ICTPreference;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileStore.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000eJ\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/clevertap/android/sdk/inapp/store/preference/FileStore;", "", "ctPreference", "Lcom/clevertap/android/sdk/store/preference/ICTPreference;", "<init>", "(Lcom/clevertap/android/sdk/store/preference/ICTPreference;)V", "saveFileUrl", "", "url", "", "expiry", "", "clearFileUrl", "getAllFileUrls", "", "expiryForUrl", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FileStore {
    private final ICTPreference ctPreference;

    public FileStore(ICTPreference ctPreference) {
        Intrinsics.checkNotNullParameter(ctPreference, "ctPreference");
        this.ctPreference = ctPreference;
    }

    public final void saveFileUrl(String url, long expiry) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.ctPreference.writeLong(url, expiry);
    }

    public final void clearFileUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.ctPreference.remove(url);
    }

    public final Set<String> getAllFileUrls() {
        Set<String> setKeySet;
        Map<String, ?> all = this.ctPreference.readAll();
        return (all == null || (setKeySet = all.keySet()) == null) ? SetsKt.emptySet() : setKeySet;
    }

    public final long expiryForUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return this.ctPreference.readLong(url, 0L);
    }
}
