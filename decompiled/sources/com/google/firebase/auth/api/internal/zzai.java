package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzfs;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzai implements zzfd<com.google.android.gms.internal.firebase_auth.zzff> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzdu zzb;
    private final /* synthetic */ zza zzc;

    zzai(zza zzaVar, String str, zzdu zzduVar) {
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
        zzfs zzfsVar = new zzfs();
        zzfsVar.zzb(zzffVar2.zzd()).zzc(this.zza);
        this.zzc.zza(this.zzb, zzffVar2, zzfsVar, this);
    }
}
