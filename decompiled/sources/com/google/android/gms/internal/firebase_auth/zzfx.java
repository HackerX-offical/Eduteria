package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzp;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzfx implements com.google.firebase.auth.api.internal.zzdz<zzfx, zzp.zzq> {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private long zze;

    public final String zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzd;
    }

    public final long zzd() {
        return this.zze;
    }

    @Override // com.google.firebase.auth.api.internal.zzdz
    public final zzjz<zzp.zzq> zza() {
        return zzp.zzq.zzf();
    }

    @Override // com.google.firebase.auth.api.internal.zzdz
    public final /* synthetic */ com.google.firebase.auth.api.internal.zzdz zza(zzjp zzjpVar) {
        if (!(zzjpVar instanceof zzp.zzq)) {
            throw new IllegalArgumentException("The passed proto must be an instance of SignUpNewUserResponse.");
        }
        zzp.zzq zzqVar = (zzp.zzq) zzjpVar;
        this.zza = Strings.emptyToNull(zzqVar.zza());
        this.zzb = Strings.emptyToNull(zzqVar.zzb());
        this.zzc = Strings.emptyToNull(zzqVar.zzc());
        this.zzd = Strings.emptyToNull(zzqVar.zzd());
        this.zze = zzqVar.zze();
        return this;
    }
}
