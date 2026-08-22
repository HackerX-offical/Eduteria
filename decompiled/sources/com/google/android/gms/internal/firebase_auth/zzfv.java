package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzp;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzfv implements com.google.firebase.auth.api.internal.zzdz<zzfv, zzp.zzo> {
    private String zza;
    private String zzb;
    private Boolean zzc;
    private String zzd;
    private String zze;
    private zzfl zzf;
    private String zzg;
    private String zzh;
    private long zzi;

    public final String zzb() {
        return this.zzg;
    }

    public final String zzc() {
        return this.zzh;
    }

    public final long zzd() {
        return this.zzi;
    }

    public final String zze() {
        return this.zza;
    }

    public final List<zzfj> zzf() {
        zzfl zzflVar = this.zzf;
        if (zzflVar != null) {
            return zzflVar.zza();
        }
        return null;
    }

    @Override // com.google.firebase.auth.api.internal.zzdz
    public final zzjz<zzp.zzo> zza() {
        return zzp.zzo.zzj();
    }

    @Override // com.google.firebase.auth.api.internal.zzdz
    public final /* synthetic */ com.google.firebase.auth.api.internal.zzdz zza(zzjp zzjpVar) {
        if (!(zzjpVar instanceof zzp.zzo)) {
            throw new IllegalArgumentException("The passed proto must be an instance of SetAccountInfoResponse.");
        }
        zzp.zzo zzoVar = (zzp.zzo) zzjpVar;
        this.zza = Strings.emptyToNull(zzoVar.zza());
        this.zzb = Strings.emptyToNull(zzoVar.zzh());
        this.zzc = Boolean.valueOf(zzoVar.zzi());
        this.zzd = Strings.emptyToNull(zzoVar.zzb());
        this.zze = Strings.emptyToNull(zzoVar.zze());
        this.zzf = zzfl.zza(zzoVar.zzd());
        this.zzg = Strings.emptyToNull(zzoVar.zzc());
        this.zzh = Strings.emptyToNull(zzoVar.zzf());
        this.zzi = zzoVar.zzg();
        return this;
    }
}
