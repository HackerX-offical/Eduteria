package com.google.firebase.auth.api.internal;

import android.content.Context;
import com.google.android.gms.internal.firebase_auth.zzfy;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzu implements zzfd<com.google.android.gms.internal.firebase_auth.zzff> {
    final /* synthetic */ zzdu zza;
    final /* synthetic */ zza zzb;
    private final /* synthetic */ zzfy zzc;

    zzu(zza zzaVar, zzfy zzfyVar, zzdu zzduVar) {
        this.zzb = zzaVar;
        this.zzc = zzfyVar;
        this.zza = zzduVar;
    }

    @Override // com.google.firebase.auth.api.internal.zzfe
    public final void zza(String str) {
        this.zza.zza(com.google.firebase.auth.internal.zzy.zza(str));
    }

    @Override // com.google.firebase.auth.api.internal.zzfd
    public final /* synthetic */ void zza(com.google.android.gms.internal.firebase_auth.zzff zzffVar) {
        com.google.android.gms.internal.firebase_auth.zzff zzffVar2 = zzffVar;
        if (this.zzb.zzc.zza()) {
            this.zzc.zzc(true);
        }
        this.zzc.zza(zzffVar2.zzd());
        this.zzb.zzb.zza((Context) null, this.zzc, new zzt(this, this));
    }
}
