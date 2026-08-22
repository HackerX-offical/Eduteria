package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzp;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzfu implements com.google.firebase.auth.api.internal.zzfk<zzp.C0146zzp> {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;

    public zzfu(String str) {
        this.zzd = str;
    }

    public zzfu(String str, String str2, String str3, String str4) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = Preconditions.checkNotEmpty(str2);
        this.zzc = null;
        this.zzd = str4;
    }

    @Override // com.google.firebase.auth.api.internal.zzfk
    public final /* synthetic */ zzjp zza() {
        zzp.C0146zzp.zza zzaVarZza = zzp.C0146zzp.zza();
        String str = this.zza;
        if (str != null) {
            zzaVarZza.zza(str);
        }
        String str2 = this.zzb;
        if (str2 != null) {
            zzaVarZza.zzb(str2);
        }
        String str3 = this.zzd;
        if (str3 != null) {
            zzaVarZza.zzc(str3);
        }
        return (zzp.C0146zzp) ((zzie) zzaVarZza.zzf());
    }
}
