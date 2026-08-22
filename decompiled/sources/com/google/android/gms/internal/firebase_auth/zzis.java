package com.google.android.gms.internal.firebase_auth;

import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzis<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zziq> zza;

    private zzis(Map.Entry<K, zziq> entry) {
        this.zza = entry;
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.zza.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.zza.getValue() == null) {
            return null;
        }
        return zziq.zza();
    }

    public final zziq zza() {
        return this.zza.getValue();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (!(obj instanceof zzjp)) {
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
        return this.zza.getValue().zza((zzjp) obj);
    }
}
