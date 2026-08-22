package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzga;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzx implements zzfd<zzga> {
    private final /* synthetic */ zzdu zza;
    private final /* synthetic */ zza zzb;

    zzx(zza zzaVar, zzdu zzduVar) {
        this.zzb = zzaVar;
        this.zza = zzduVar;
    }

    @Override // com.google.firebase.auth.api.internal.zzfe
    public final void zza(String str) {
        this.zza.zza(com.google.firebase.auth.internal.zzy.zza(str));
    }

    @Override // com.google.firebase.auth.api.internal.zzfd
    public final /* synthetic */ void zza(zzga zzgaVar) {
        zzga zzgaVar2 = zzgaVar;
        if (!zzgaVar2.zzo()) {
            this.zzb.zza(zzgaVar2, this.zza, this);
        } else if (this.zzb.zzc.zzb()) {
            this.zza.zza(new com.google.android.gms.internal.firebase_auth.zzej(zzgaVar2.zzn(), zzgaVar2.zzm(), zzgaVar2.zzp()));
        } else {
            zza.zza.e("Need to do multi-factor auth, but SDK does not support it.", new Object[0]);
            zza("REQUIRES_SECOND_FACTOR_AUTH");
        }
    }
}
