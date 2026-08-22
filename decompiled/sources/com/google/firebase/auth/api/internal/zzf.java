package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzfs;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzf implements zzfd<com.google.android.gms.internal.firebase_auth.zzeu> {
    private final /* synthetic */ zzfe zza;
    private final /* synthetic */ zzdu zzb;
    private final /* synthetic */ com.google.android.gms.internal.firebase_auth.zzff zzc;
    private final /* synthetic */ zzfs zzd;
    private final /* synthetic */ zza zze;

    zzf(zza zzaVar, zzfe zzfeVar, zzdu zzduVar, com.google.android.gms.internal.firebase_auth.zzff zzffVar, zzfs zzfsVar) {
        this.zze = zzaVar;
        this.zza = zzfeVar;
        this.zzb = zzduVar;
        this.zzc = zzffVar;
        this.zzd = zzfsVar;
    }

    @Override // com.google.firebase.auth.api.internal.zzfe
    public final void zza(String str) {
        this.zza.zza(str);
    }

    @Override // com.google.firebase.auth.api.internal.zzfd
    public final /* synthetic */ void zza(com.google.android.gms.internal.firebase_auth.zzeu zzeuVar) {
        List<com.google.android.gms.internal.firebase_auth.zzew> listZzb = zzeuVar.zzb();
        if (listZzb == null || listZzb.isEmpty()) {
            this.zza.zza("No users");
        } else {
            this.zze.zza(this.zzb, this.zzc, listZzb.get(0), this.zzd, this.zza);
        }
    }
}
