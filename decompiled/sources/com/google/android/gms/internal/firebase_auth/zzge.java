package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzp;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzge implements com.google.firebase.auth.api.internal.zzfk<zzp.zzv> {
    private String zza;
    private String zzb;
    private final String zzc;
    private boolean zzd = true;

    public zzge(String str, String str2, String str3) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = Preconditions.checkNotEmpty(str2);
        this.zzc = str3;
    }

    @Override // com.google.firebase.auth.api.internal.zzfk
    public final /* synthetic */ zzjp zza() {
        zzp.zzv.zza zzaVarZza = zzp.zzv.zza().zza(this.zza).zzb(this.zzb).zza(this.zzd);
        String str = this.zzc;
        if (str != null) {
            zzaVarZza.zzc(str);
        }
        return (zzp.zzv) ((zzie) zzaVarZza.zzf());
    }
}
