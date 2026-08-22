package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzfs;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzw implements zzfd<com.google.android.gms.internal.firebase_auth.zzff> {
    private final /* synthetic */ zzdu zza;
    private final /* synthetic */ zza zzb;

    zzw(zza zzaVar, zzdu zzduVar) {
        this.zzb = zzaVar;
        this.zza = zzduVar;
    }

    @Override // com.google.firebase.auth.api.internal.zzfe
    public final void zza(String str) {
        this.zza.zza(com.google.firebase.auth.internal.zzy.zza(str));
    }

    @Override // com.google.firebase.auth.api.internal.zzfd
    public final /* synthetic */ void zza(com.google.android.gms.internal.firebase_auth.zzff zzffVar) {
        com.google.android.gms.internal.firebase_auth.zzff zzffVar2 = zzffVar;
        zzfs zzfsVar = new zzfs();
        zzfsVar.zzb(zzffVar2.zzd()).zzc(null).zzd(null);
        this.zzb.zza(this.zza, zzffVar2, zzfsVar, this);
    }
}
