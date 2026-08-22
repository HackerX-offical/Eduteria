package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzbo<K, V> extends zzbn<Map.Entry<K, V>> {
    private final transient zzbl<K, V> zza;
    private final transient Object[] zzb;
    private final transient int zzc = 0;
    private final transient int zzd;

    zzbo(zzbl<K, V> zzblVar, Object[] objArr, int i, int i2) {
        this.zza = zzblVar;
        this.zzb = objArr;
        this.zzd = i2;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzbh
    /* JADX INFO: renamed from: zzb */
    public final zzbv<Map.Entry<K, V>> iterator() {
        return (zzbv) zzc().iterator();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzbh
    final int zza(Object[] objArr, int i) {
        return zzc().zza(objArr, i);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzbn
    final zzbg<Map.Entry<K, V>> zza() {
        return new zzbr(this);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzbh, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.zza.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzbn, com.google.android.gms.internal.firebase_auth.zzbh, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
