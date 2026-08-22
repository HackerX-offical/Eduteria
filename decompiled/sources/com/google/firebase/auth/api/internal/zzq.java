package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzgi;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzq implements zzfd<zzgi> {
    private final /* synthetic */ zzdu zza;
    private final /* synthetic */ zza zzb;

    zzq(zza zzaVar, zzdu zzduVar) {
        this.zzb = zzaVar;
        this.zza = zzduVar;
    }

    @Override // com.google.firebase.auth.api.internal.zzfe
    public final void zza(String str) {
        this.zza.zza(com.google.firebase.auth.internal.zzy.zza(str));
    }

    @Override // com.google.firebase.auth.api.internal.zzfd
    public final /* synthetic */ void zza(zzgi zzgiVar) {
        zzgi zzgiVar2 = zzgiVar;
        this.zzb.zza(new com.google.android.gms.internal.firebase_auth.zzff(zzgiVar2.zzc(), zzgiVar2.zzb(), Long.valueOf(zzgiVar2.zzd()), "Bearer"), null, null, Boolean.valueOf(zzgiVar2.zze()), null, this.zza, this);
    }
}
