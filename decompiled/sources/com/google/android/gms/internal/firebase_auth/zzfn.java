package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzp;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzfn implements com.google.firebase.auth.api.internal.zzfk<zzp.zzj> {
    private final String zza;
    private final String zzb;
    private final String zzc;

    public zzfn(String str, String str2, String str3) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = str2;
        this.zzc = str3;
    }

    @Override // com.google.firebase.auth.api.internal.zzfk
    public final /* synthetic */ zzjp zza() {
        zzp.zzj.zza zzaVarZza = zzp.zzj.zza().zza(this.zza);
        String str = this.zzb;
        if (str != null) {
            zzaVarZza.zzb(str);
        }
        String str2 = this.zzc;
        if (str2 != null) {
            zzaVarZza.zzc(str2);
        }
        return (zzp.zzj) ((zzie) zzaVarZza.zzf());
    }
}
