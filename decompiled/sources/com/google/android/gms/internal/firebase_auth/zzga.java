package com.google.android.gms.internal.firebase_auth;

import android.text.TextUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzga implements com.google.firebase.auth.api.internal.zzdz<zzga, zzp.zzs> {
    private boolean zza;
    private boolean zzb;
    private String zzc;
    private String zzd;
    private long zze;
    private String zzf;
    private String zzg;
    private String zzh;
    private String zzi;
    private String zzj;
    private String zzk;
    private boolean zzl;
    private String zzm;
    private String zzn;
    private String zzo;
    private String zzp;
    private String zzq;
    private String zzr;
    private List<zzfh> zzs;
    private String zzt;

    public final boolean zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzg;
    }

    public final String zze() {
        return this.zzj;
    }

    public final String zzf() {
        return this.zzk;
    }

    public final String zzg() {
        return this.zzd;
    }

    public final long zzh() {
        return this.zze;
    }

    public final boolean zzi() {
        return this.zzl;
    }

    public final String zzj() {
        return this.zzp;
    }

    public final boolean zzk() {
        return this.zza || !TextUtils.isEmpty(this.zzp);
    }

    public final String zzl() {
        return this.zzr;
    }

    public final List<zzfh> zzm() {
        return this.zzs;
    }

    public final String zzn() {
        return this.zzt;
    }

    public final boolean zzo() {
        return !TextUtils.isEmpty(this.zzt);
    }

    public final com.google.firebase.auth.zzg zzp() {
        if (TextUtils.isEmpty(this.zzm) && TextUtils.isEmpty(this.zzn)) {
            return null;
        }
        return com.google.firebase.auth.zzg.zza(this.zzj, this.zzn, this.zzm, this.zzq, this.zzo);
    }

    @Override // com.google.firebase.auth.api.internal.zzdz
    public final zzjz<zzp.zzs> zza() {
        return zzp.zzs.zzu();
    }

    @Override // com.google.firebase.auth.api.internal.zzdz
    public final /* synthetic */ com.google.firebase.auth.api.internal.zzdz zza(zzjp zzjpVar) {
        if (!(zzjpVar instanceof zzp.zzs)) {
            throw new IllegalArgumentException("The passed proto must be an instance of VerifyAssertionResponse.");
        }
        zzp.zzs zzsVar = (zzp.zzs) zzjpVar;
        this.zza = zzsVar.zzg();
        this.zzb = zzsVar.zzi();
        this.zzc = Strings.emptyToNull(zzsVar.zzf());
        this.zzd = Strings.emptyToNull(zzsVar.zzk());
        this.zze = zzsVar.zzl();
        this.zzf = Strings.emptyToNull(zzsVar.zzd());
        this.zzg = Strings.emptyToNull(zzsVar.zzb());
        this.zzh = Strings.emptyToNull(zzsVar.zze());
        this.zzi = Strings.emptyToNull(zzsVar.zzc());
        this.zzj = Strings.emptyToNull(zzsVar.zza());
        this.zzk = Strings.emptyToNull(zzsVar.zzn());
        this.zzl = zzsVar.zzp();
        this.zzm = zzsVar.zzh();
        this.zzn = zzsVar.zzm();
        this.zzp = Strings.emptyToNull(zzsVar.zzo());
        this.zzq = Strings.emptyToNull(zzsVar.zzq());
        this.zzr = Strings.emptyToNull(zzsVar.zzr());
        this.zzs = new ArrayList();
        Iterator<zzr> it = zzsVar.zzt().iterator();
        while (it.hasNext()) {
            this.zzs.add(zzfh.zza(it.next()));
        }
        this.zzt = Strings.emptyToNull(zzsVar.zzs());
        this.zzo = Strings.emptyToNull(zzsVar.zzj());
        return this;
    }
}
