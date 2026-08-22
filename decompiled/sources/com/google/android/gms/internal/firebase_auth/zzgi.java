package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzp;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzgi implements com.google.firebase.auth.api.internal.zzdz<zzgi, zzp.zzy> {
    private String zza;
    private String zzb;
    private long zzc;
    private String zzd;
    private boolean zze;
    private String zzf;
    private String zzg;
    private long zzh;
    private String zzi;

    public final String zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final long zzd() {
        return this.zzc;
    }

    public final boolean zze() {
        return this.zze;
    }

    public final String zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zzi;
    }

    @Override // com.google.firebase.auth.api.internal.zzdz
    public final zzjz<zzp.zzy> zza() {
        return zzp.zzy.zzj();
    }

    @Override // com.google.firebase.auth.api.internal.zzdz
    public final /* synthetic */ com.google.firebase.auth.api.internal.zzdz zza(zzjp zzjpVar) {
        if (!(zzjpVar instanceof zzp.zzy)) {
            throw new IllegalArgumentException("The passed proto must be an instance of verifyPhoneNumberResponse.");
        }
        zzp.zzy zzyVar = (zzp.zzy) zzjpVar;
        this.zza = Strings.emptyToNull(zzyVar.zza());
        this.zzb = Strings.emptyToNull(zzyVar.zzb());
        this.zzc = zzyVar.zzc();
        this.zzd = Strings.emptyToNull(zzyVar.zzd());
        this.zze = zzyVar.zze();
        this.zzf = Strings.emptyToNull(zzyVar.zzf());
        this.zzg = Strings.emptyToNull(zzyVar.zzg());
        this.zzh = zzyVar.zzh();
        this.zzi = zzyVar.zzi();
        return this;
    }
}
