package com.google.android.gms.internal.firebase_auth;

import java.util.AbstractMap;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzbr<K, V> extends zzbg<Map.Entry<K, V>> {
    private final /* synthetic */ zzbo zza;

    zzbr(zzbo zzboVar) {
        this.zza = zzboVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.zzd;
    }

    @Override // java.util.List
    public final /* synthetic */ Object get(int i) {
        zzav.zza(i, this.zza.zzd);
        int i2 = i * 2;
        return new AbstractMap.SimpleImmutableEntry(this.zza.zzb[i2], this.zza.zzb[i2 + 1]);
    }
}
