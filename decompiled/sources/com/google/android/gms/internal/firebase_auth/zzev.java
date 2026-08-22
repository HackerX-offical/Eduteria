package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzp;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzev implements com.google.firebase.auth.api.internal.zzfk<zzp.zzf> {
    private String zza;

    public zzev(String str) {
        this.zza = Preconditions.checkNotEmpty(str);
    }

    @Override // com.google.firebase.auth.api.internal.zzfk
    public final /* synthetic */ zzjp zza() {
        return (zzp.zzf) ((zzie) zzp.zzf.zza().zza(this.zza).zzf());
    }
}
