package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
final class zzer<K, V> extends zzej<Map.Entry<K, V>> {
    private final transient zzef<K, V> zza;
    private final transient Object[] zzb;
    private final transient int zzc = 0;
    private final transient int zzd;

    zzer(zzef<K, V> zzefVar, Object[] objArr, int i, int i2) {
        this.zza = zzefVar;
        this.zzb = objArr;
        this.zzd = i2;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    final boolean zzf() {
        return true;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    /* JADX INFO: renamed from: zza */
    public final zzfa<Map.Entry<K, V>> iterator() {
        return (zzfa) zze().iterator();
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    final int zza(Object[] objArr, int i) {
        return zze().zza(objArr, i);
    }

    @Override // com.google.android.gms.internal.vision.zzej
    final zzee<Map.Entry<K, V>> zzh() {
        return new zzeu(this);
    }

    @Override // com.google.android.gms.internal.vision.zzeb, java.util.AbstractCollection, java.util.Collection
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

    @Override // com.google.android.gms.internal.vision.zzej, com.google.android.gms.internal.vision.zzeb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
