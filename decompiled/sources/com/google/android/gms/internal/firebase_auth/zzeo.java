package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzp;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzeo implements com.google.firebase.auth.api.internal.zzfk<zzp.zzc> {
    private String zza;

    public zzeo(String str) {
        this.zza = Preconditions.checkNotEmpty(str);
    }

    @Override // com.google.firebase.auth.api.internal.zzfk
    public final /* synthetic */ zzjp zza() {
        return (zzp.zzc) ((zzie) zzp.zzc.zza().zza(this.zza).zzf());
    }
}
