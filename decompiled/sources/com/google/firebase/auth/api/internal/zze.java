package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzgh;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zze implements zzfd<zzgh> {
    private final /* synthetic */ zzdu zza;
    private final /* synthetic */ zza zzb;

    zze(zza zzaVar, zzdu zzduVar) {
        this.zzb = zzaVar;
        this.zza = zzduVar;
    }

    @Override // com.google.firebase.auth.api.internal.zzfe
    public final void zza(String str) {
        this.zza.zza(com.google.firebase.auth.internal.zzy.zza(str));
    }

    @Override // com.google.firebase.auth.api.internal.zzfd
    public final /* synthetic */ void zza(zzgh zzghVar) {
        zzgh zzghVar2 = zzghVar;
        if (!zzghVar2.zzg()) {
            this.zzb.zza(new com.google.android.gms.internal.firebase_auth.zzff(zzghVar2.zzc(), zzghVar2.zzb(), Long.valueOf(zzghVar2.zzd()), "Bearer"), null, null, false, null, this.zza, this);
        } else if (this.zzb.zzc.zzb()) {
            this.zza.zza(new com.google.android.gms.internal.firebase_auth.zzej(zzghVar2.zzf(), zzghVar2.zze(), null));
        } else {
            zza.zza.e("Need to do multi-factor auth, but SDK does not support it.", new Object[0]);
            zza("REQUIRES_SECOND_FACTOR_AUTH");
        }
    }
}
