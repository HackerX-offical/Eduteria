package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzgc;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzl implements zzfd<zzgc> {
    private final /* synthetic */ zzdu zza;
    private final /* synthetic */ zza zzb;

    zzl(zza zzaVar, zzdu zzduVar) {
        this.zzb = zzaVar;
        this.zza = zzduVar;
    }

    @Override // com.google.firebase.auth.api.internal.zzfe
    public final void zza(String str) {
        this.zza.zza(com.google.firebase.auth.internal.zzy.zza(str));
    }

    @Override // com.google.firebase.auth.api.internal.zzfd
    public final /* synthetic */ void zza(zzgc zzgcVar) {
        zzgc zzgcVar2 = zzgcVar;
        this.zzb.zza(new com.google.android.gms.internal.firebase_auth.zzff(zzgcVar2.zzc(), zzgcVar2.zzb(), Long.valueOf(zzgcVar2.zzd()), "Bearer"), null, null, Boolean.valueOf(zzgcVar2.zze()), null, this.zza, this);
    }
}
