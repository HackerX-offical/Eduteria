package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzp;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzfc implements com.google.firebase.auth.api.internal.zzdz<zzfc, zzp.zzi> {
    @Override // com.google.firebase.auth.api.internal.zzdz
    public final zzjz<zzp.zzi> zza() {
        return zzp.zzi.zza();
    }

    @Override // com.google.firebase.auth.api.internal.zzdz
    public final /* synthetic */ com.google.firebase.auth.api.internal.zzdz zza(zzjp zzjpVar) {
        if (zzjpVar instanceof zzp.zzi) {
            return this;
        }
        throw new IllegalArgumentException("The passed proto must be an instance of GetOobConfirmationCodeResponse.");
    }
}
