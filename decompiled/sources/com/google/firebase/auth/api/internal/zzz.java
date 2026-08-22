package com.google.firebase.auth.api.internal;

import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzz implements zzfd<com.google.android.gms.internal.firebase_auth.zzeu> {
    private final /* synthetic */ zzfd zza;
    private final /* synthetic */ com.google.android.gms.internal.firebase_auth.zzff zzb;
    private final /* synthetic */ zzaa zzc;

    zzz(zzaa zzaaVar, zzfd zzfdVar, com.google.android.gms.internal.firebase_auth.zzff zzffVar) {
        this.zzc = zzaaVar;
        this.zza = zzfdVar;
        this.zzb = zzffVar;
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
            this.zzc.zza.zza(this.zzb, listZzb.get(0));
        }
    }
}
