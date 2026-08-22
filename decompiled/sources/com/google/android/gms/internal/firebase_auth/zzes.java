package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzlt;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzes implements com.google.firebase.auth.api.internal.zzfk<zzlt.zza> {
    private String zza = zzet.REFRESH_TOKEN.toString();
    private String zzb;

    public zzes(String str) {
        this.zzb = Preconditions.checkNotEmpty(str);
    }

    @Override // com.google.firebase.auth.api.internal.zzfk
    public final /* synthetic */ zzjp zza() {
        return (zzlt.zza) ((zzie) zzlt.zza.zza().zza(this.zza).zzb(this.zzb).zzf());
    }
}
