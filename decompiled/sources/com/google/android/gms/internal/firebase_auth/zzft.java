package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzp;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzft implements com.google.firebase.auth.api.internal.zzdz<zzft, zzp.zzm> {
    private String zza;

    public final String zzb() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.api.internal.zzdz
    public final zzjz<zzp.zzm> zza() {
        return zzp.zzm.zzb();
    }

    @Override // com.google.firebase.auth.api.internal.zzdz
    public final /* synthetic */ com.google.firebase.auth.api.internal.zzdz zza(zzjp zzjpVar) {
        if (!(zzjpVar instanceof zzp.zzm)) {
            throw new IllegalArgumentException("The passed proto must be an instance of SendVerificationCodeResponse.");
        }
        this.zza = ((zzp.zzm) zzjpVar).zza();
        return this;
    }
}
