package com.google.firebase.auth.api.internal;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzv implements zzfd<com.google.android.gms.internal.firebase_auth.zzff> {
    final /* synthetic */ String zza;
    final /* synthetic */ zzdu zzb;
    final /* synthetic */ zza zzc;

    zzv(zza zzaVar, String str, zzdu zzduVar) {
        this.zzc = zzaVar;
        this.zza = str;
        this.zzb = zzduVar;
    }

    @Override // com.google.firebase.auth.api.internal.zzfe
    public final void zza(String str) {
        this.zzb.zza(com.google.firebase.auth.internal.zzy.zza(str));
    }

    @Override // com.google.firebase.auth.api.internal.zzfd
    public final /* synthetic */ void zza(com.google.android.gms.internal.firebase_auth.zzff zzffVar) {
        com.google.android.gms.internal.firebase_auth.zzff zzffVar2 = zzffVar;
        this.zzc.zzb.zza(new com.google.android.gms.internal.firebase_auth.zzev(zzffVar2.zzd()), new zzy(this, this, zzffVar2));
    }
}
