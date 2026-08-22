package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzfs;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzp implements zzfd<com.google.android.gms.internal.firebase_auth.zzff> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzdu zzc;
    private final /* synthetic */ zza zzd;

    zzp(zza zzaVar, String str, String str2, zzdu zzduVar) {
        this.zzd = zzaVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzduVar;
    }

    @Override // com.google.firebase.auth.api.internal.zzfe
    public final void zza(String str) {
        this.zzc.zza(com.google.firebase.auth.internal.zzy.zza(str));
    }

    @Override // com.google.firebase.auth.api.internal.zzfd
    public final /* synthetic */ void zza(com.google.android.gms.internal.firebase_auth.zzff zzffVar) {
        com.google.android.gms.internal.firebase_auth.zzff zzffVar2 = zzffVar;
        zzfs zzfsVar = new zzfs();
        zzfsVar.zzb(zzffVar2.zzd()).zzc(this.zza).zzd(this.zzb);
        this.zzd.zza(this.zzc, zzffVar2, zzfsVar, this);
    }
}
