package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzfs;
import com.google.firebase.auth.UserProfileChangeRequest;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzaf implements zzfd<com.google.android.gms.internal.firebase_auth.zzff> {
    private final /* synthetic */ UserProfileChangeRequest zza;
    private final /* synthetic */ zzdu zzb;
    private final /* synthetic */ zza zzc;

    zzaf(zza zzaVar, UserProfileChangeRequest userProfileChangeRequest, zzdu zzduVar) {
        this.zzc = zzaVar;
        this.zza = userProfileChangeRequest;
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
        zzfsVar.zzb(zzffVar2.zzd());
        if (this.zza.zzb() || this.zza.getDisplayName() != null) {
            zzfsVar.zze(this.zza.getDisplayName());
        }
        if (this.zza.zzc() || this.zza.getPhotoUri() != null) {
            zzfsVar.zzf(this.zza.zza());
        }
        this.zzc.zza(this.zzb, zzffVar2, zzfsVar, this);
    }
}
