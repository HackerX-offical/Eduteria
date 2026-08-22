package com.google.android.gms.internal.firebase_auth;

import java.util.List;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzbi<E> extends zzbg<E> {
    private final transient int zza;
    private final transient int zzb;
    private final /* synthetic */ zzbg zzc;

    zzbi(zzbg zzbgVar, int i, int i2) {
        this.zzc = zzbgVar;
        this.zza = i;
        this.zzb = i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzbh
    final Object[] zzd() {
        return this.zzc.zzd();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzbh
    final int zze() {
        return this.zzc.zze() + this.zza;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzbh
    final int zzf() {
        return this.zzc.zze() + this.zza + this.zzb;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzav.zza(i, this.zzb);
        return this.zzc.get(i + this.zza);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzbg
    /* JADX INFO: renamed from: zza */
    public final zzbg<E> subList(int i, int i2) {
        zzav.zza(i, i2, this.zzb);
        zzbg zzbgVar = this.zzc;
        int i3 = this.zza;
        return (zzbg) zzbgVar.subList(i + i3, i2 + i3);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzbg, java.util.List
    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}
