package com.google.android.gms.internal.vision;

import java.util.AbstractMap;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
final class zzeu<K, V> extends zzee<Map.Entry<K, V>> {
    private final /* synthetic */ zzer zza;

    zzeu(zzer zzerVar) {
        this.zza = zzerVar;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final boolean zzf() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.zzd;
    }

    @Override // java.util.List
    public final /* synthetic */ Object get(int i) {
        zzde.zza(i, this.zza.zzd);
        int i2 = i * 2;
        return new AbstractMap.SimpleImmutableEntry(this.zza.zzb[i2], this.zza.zzb[i2 + 1]);
    }
}
