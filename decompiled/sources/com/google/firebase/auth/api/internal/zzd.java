package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzer;
import com.google.firebase.auth.EmailAuthCredential;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzd implements zzfd<com.google.android.gms.internal.firebase_auth.zzff> {
    private final /* synthetic */ EmailAuthCredential zza;
    private final /* synthetic */ zzdu zzb;
    private final /* synthetic */ zza zzc;

    zzd(zza zzaVar, EmailAuthCredential emailAuthCredential, zzdu zzduVar) {
        this.zzc = zzaVar;
        this.zza = emailAuthCredential;
        this.zzb = zzduVar;
    }

    @Override // com.google.firebase.auth.api.internal.zzfe
    public final void zza(String str) {
        this.zzb.zza(com.google.firebase.auth.internal.zzy.zza(str));
    }

    @Override // com.google.firebase.auth.api.internal.zzfd
    public final /* synthetic */ void zza(com.google.android.gms.internal.firebase_auth.zzff zzffVar) {
        this.zzc.zza(new zzer(this.zza, zzffVar.zzd()), this.zzb);
    }
}
