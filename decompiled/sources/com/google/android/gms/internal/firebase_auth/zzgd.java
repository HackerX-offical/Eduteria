package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzp;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzgd implements com.google.firebase.auth.api.internal.zzfk<zzp.zzt> {
    private String zza;
    private String zzb;

    public zzgd(String str, String str2) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = str2;
    }

    @Override // com.google.firebase.auth.api.internal.zzfk
    public final /* synthetic */ zzjp zza() {
        zzp.zzt.zza zzaVarZza = zzp.zzt.zza().zza(this.zza).zza(true);
        String str = this.zzb;
        if (str != null) {
            zzaVarZza.zzb(str);
        }
        return (zzp.zzt) ((zzie) zzaVarZza.zzf());
    }
}
