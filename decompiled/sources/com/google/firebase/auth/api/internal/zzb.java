package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzfx;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzb implements zzfd<zzfx> {
    private final /* synthetic */ zzdu zza;
    private final /* synthetic */ zza zzb;

    zzb(zza zzaVar, zzdu zzduVar) {
        this.zzb = zzaVar;
        this.zza = zzduVar;
    }

    @Override // com.google.firebase.auth.api.internal.zzfe
    public final void zza(String str) {
        this.zza.zza(com.google.firebase.auth.internal.zzy.zza(str));
    }

    @Override // com.google.firebase.auth.api.internal.zzfd
    public final /* synthetic */ void zza(zzfx zzfxVar) {
        zzfx zzfxVar2 = zzfxVar;
        this.zzb.zza(new com.google.android.gms.internal.firebase_auth.zzff(zzfxVar2.zzc(), zzfxVar2.zzb(), Long.valueOf(zzfxVar2.zzd()), "Bearer"), null, null, true, null, this.zza, this);
    }
}
