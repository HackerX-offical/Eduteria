package com.google.android.gms.internal.firebase_auth;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzp;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzgg implements com.google.firebase.auth.api.internal.zzfk<zzp.zzx> {
    private boolean zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private boolean zzg;

    private zzgg() {
    }

    public static zzgg zza(String str, String str2, boolean z) {
        zzgg zzggVar = new zzgg();
        zzggVar.zza = false;
        zzggVar.zzc = Preconditions.checkNotEmpty(str);
        zzggVar.zzd = Preconditions.checkNotEmpty(str2);
        zzggVar.zzg = z;
        return zzggVar;
    }

    public static zzgg zzb(String str, String str2, boolean z) {
        zzgg zzggVar = new zzgg();
        zzggVar.zza = false;
        zzggVar.zzb = Preconditions.checkNotEmpty(str);
        zzggVar.zze = Preconditions.checkNotEmpty(str2);
        zzggVar.zzg = z;
        return zzggVar;
    }

    public final void zza(String str) {
        this.zzf = str;
    }

    @Override // com.google.firebase.auth.api.internal.zzfk
    public final /* synthetic */ zzjp zza() {
        zzp.zzx.zza zzaVarZza = zzp.zzx.zza();
        if (!TextUtils.isEmpty(this.zze)) {
            zzaVarZza.zzd(this.zze).zzb(this.zzb);
        } else {
            zzaVarZza.zza(this.zzc).zzc(this.zzd);
        }
        String str = this.zzf;
        if (str != null) {
            zzaVarZza.zze(str);
        }
        if (!this.zzg) {
            zzaVarZza.zza(zzaa.REAUTH);
        }
        return (zzp.zzx) ((zzie) zzaVarZza.zzf());
    }
}
