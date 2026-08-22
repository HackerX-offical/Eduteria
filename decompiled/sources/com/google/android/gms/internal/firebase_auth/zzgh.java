package com.google.android.gms.internal.firebase_auth;

import android.text.TextUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzgh implements com.google.firebase.auth.api.internal.zzdz<zzgh, zzp.zzw> {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private long zzg;
    private List<zzfh> zzh;
    private String zzi;

    public final String zzb() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zzf;
    }

    public final long zzd() {
        return this.zzg;
    }

    public final List<zzfh> zze() {
        return this.zzh;
    }

    public final String zzf() {
        return this.zzi;
    }

    public final boolean zzg() {
        return !TextUtils.isEmpty(this.zzi);
    }

    @Override // com.google.firebase.auth.api.internal.zzdz
    public final zzjz<zzp.zzw> zza() {
        return zzp.zzw.zzj();
    }

    @Override // com.google.firebase.auth.api.internal.zzdz
    public final /* synthetic */ com.google.firebase.auth.api.internal.zzdz zza(zzjp zzjpVar) {
        if (!(zzjpVar instanceof zzp.zzw)) {
            throw new IllegalArgumentException("The passed proto must be an instance of VerifyPasswordResponse.");
        }
        zzp.zzw zzwVar = (zzp.zzw) zzjpVar;
        this.zza = Strings.emptyToNull(zzwVar.zza());
        this.zzb = Strings.emptyToNull(zzwVar.zzb());
        this.zzc = Strings.emptyToNull(zzwVar.zzc());
        this.zzd = Strings.emptyToNull(zzwVar.zzd());
        this.zze = Strings.emptyToNull(zzwVar.zze());
        this.zzf = Strings.emptyToNull(zzwVar.zzf());
        this.zzg = zzwVar.zzg();
        this.zzh = new ArrayList();
        Iterator<zzr> it = zzwVar.zzi().iterator();
        while (it.hasNext()) {
            this.zzh.add(zzfh.zza(it.next()));
        }
        this.zzi = zzwVar.zzh();
        return this;
    }
}
