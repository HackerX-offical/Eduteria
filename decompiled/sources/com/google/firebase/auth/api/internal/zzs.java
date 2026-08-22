package com.google.firebase.auth.api.internal;

import android.content.Context;
import com.google.android.gms.internal.firebase_auth.zzgg;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzs implements zzfd<com.google.android.gms.internal.firebase_auth.zzff> {
    final /* synthetic */ zzdu zza;
    final /* synthetic */ zza zzb;
    private final /* synthetic */ zzgg zzc;
    private final /* synthetic */ Context zzd = null;

    zzs(zza zzaVar, zzgg zzggVar, Context context, zzdu zzduVar) {
        this.zzb = zzaVar;
        this.zzc = zzggVar;
        this.zza = zzduVar;
    }

    @Override // com.google.firebase.auth.api.internal.zzfe
    public final void zza(String str) {
        this.zza.zza(com.google.firebase.auth.internal.zzy.zza(str));
    }

    @Override // com.google.firebase.auth.api.internal.zzfd
    public final /* synthetic */ void zza(com.google.android.gms.internal.firebase_auth.zzff zzffVar) {
        this.zzc.zza(zzffVar.zzd());
        this.zzb.zzb.zza(this.zzd, this.zzc, new zzr(this, this));
    }
}
