package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzfs;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzy implements zzfd<com.google.android.gms.internal.firebase_auth.zzeu> {
    private final /* synthetic */ zzfd zza;
    private final /* synthetic */ com.google.android.gms.internal.firebase_auth.zzff zzb;
    private final /* synthetic */ zzv zzc;

    zzy(zzv zzvVar, zzfd zzfdVar, com.google.android.gms.internal.firebase_auth.zzff zzffVar) {
        this.zzc = zzvVar;
        this.zza = zzfdVar;
        this.zzb = zzffVar;
    }

    @Override // com.google.firebase.auth.api.internal.zzfe
    public final void zza(String str) {
        this.zzc.zzb.zza(com.google.firebase.auth.internal.zzy.zza(str));
    }

    @Override // com.google.firebase.auth.api.internal.zzfd
    public final /* synthetic */ void zza(com.google.android.gms.internal.firebase_auth.zzeu zzeuVar) {
        List<com.google.android.gms.internal.firebase_auth.zzew> listZzb = zzeuVar.zzb();
        if (listZzb == null || listZzb.isEmpty()) {
            this.zza.zza("No users.");
            return;
        }
        com.google.android.gms.internal.firebase_auth.zzew zzewVar = listZzb.get(0);
        zzfs zzfsVar = new zzfs();
        zzfsVar.zzb(this.zzb.zzd()).zzg(this.zzc.zza);
        this.zzc.zzc.zza(this.zzc.zzb, this.zzb, zzewVar, zzfsVar, this.zza);
    }
}
