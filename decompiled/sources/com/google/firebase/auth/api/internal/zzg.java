package com.google.firebase.auth.api.internal;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzg implements zzfd<com.google.android.gms.internal.firebase_auth.zzeq> {
    private final /* synthetic */ zzdu zza;
    private final /* synthetic */ zza zzb;

    zzg(zza zzaVar, zzdu zzduVar) {
        this.zzb = zzaVar;
        this.zza = zzduVar;
    }

    @Override // com.google.firebase.auth.api.internal.zzfe
    public final void zza(String str) {
        this.zza.zza(com.google.firebase.auth.internal.zzy.zza(str));
    }

    @Override // com.google.firebase.auth.api.internal.zzfd
    public final /* synthetic */ void zza(com.google.android.gms.internal.firebase_auth.zzeq zzeqVar) {
        com.google.android.gms.internal.firebase_auth.zzeq zzeqVar2 = zzeqVar;
        if (!zzeqVar2.zzh()) {
            this.zzb.zza(new com.google.android.gms.internal.firebase_auth.zzff(zzeqVar2.zzc(), zzeqVar2.zzb(), Long.valueOf(zzeqVar2.zze()), "Bearer"), null, null, Boolean.valueOf(zzeqVar2.zzd()), null, this.zza, this);
        } else if (this.zzb.zzc.zzb()) {
            this.zza.zza(new com.google.android.gms.internal.firebase_auth.zzej(zzeqVar2.zzg(), zzeqVar2.zzf(), null));
        } else {
            zza.zza.e("Need to do multi-factor auth, but either the SDK does not support it, or the flag is disabled.", new Object[0]);
            zza("REQUIRES_SECOND_FACTOR_AUTH");
        }
    }
}
