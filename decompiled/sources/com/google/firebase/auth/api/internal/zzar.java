package com.google.firebase.auth.api.internal;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzar {
    private final zzdx zza;
    private final zzek zzb;

    public zzar(zzdx zzdxVar, zzek zzekVar) {
        this.zza = zzdxVar;
        this.zzb = zzekVar;
    }

    final boolean zza() {
        return this.zza.zza().booleanValue() && this.zzb.zza(this.zza.zzd());
    }

    final boolean zzb() {
        return this.zza.zzb().booleanValue() && this.zzb.zzb(this.zza.zzc());
    }
}
