package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzeo;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzac implements zzfd<com.google.android.gms.internal.firebase_auth.zzff> {
    final /* synthetic */ zzdu zza;
    private final /* synthetic */ zza zzb;

    zzac(zza zzaVar, zzdu zzduVar) {
        this.zzb = zzaVar;
        this.zza = zzduVar;
    }

    @Override // com.google.firebase.auth.api.internal.zzfe
    public final void zza(String str) {
        this.zza.zza(com.google.firebase.auth.internal.zzy.zza(str));
    }

    @Override // com.google.firebase.auth.api.internal.zzfd
    public final /* synthetic */ void zza(com.google.android.gms.internal.firebase_auth.zzff zzffVar) {
        this.zzb.zzb.zza(new zzeo(zzffVar.zzd()), new zzab(this, this));
    }
}
