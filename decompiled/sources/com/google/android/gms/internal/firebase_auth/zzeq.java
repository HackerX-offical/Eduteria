package com.google.android.gms.internal.firebase_auth;

import android.text.TextUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzeq implements com.google.firebase.auth.api.internal.zzdz<zzeq, zzp.zze> {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private boolean zze;
    private long zzf;
    private List<zzfh> zzg;
    private String zzh;

    public final String zzb() {
        return this.zzc;
    }

    public final String zzc() {
        return this.zzd;
    }

    public final boolean zzd() {
        return this.zze;
    }

    public final long zze() {
        return this.zzf;
    }

    public final List<zzfh> zzf() {
        return this.zzg;
    }

    public final String zzg() {
        return this.zzh;
    }

    public final boolean zzh() {
        return !TextUtils.isEmpty(this.zzh);
    }

    @Override // com.google.firebase.auth.api.internal.zzdz
    public final zzjz<zzp.zze> zza() {
        return zzp.zze.zzi();
    }

    @Override // com.google.firebase.auth.api.internal.zzdz
    public final /* synthetic */ com.google.firebase.auth.api.internal.zzdz zza(zzjp zzjpVar) {
        if (!(zzjpVar instanceof zzp.zze)) {
            throw new IllegalArgumentException("The passed proto must be an instance of EmailLinkSigninResponse.");
        }
        zzp.zze zzeVar = (zzp.zze) zzjpVar;
        this.zza = Strings.emptyToNull(zzeVar.zze());
        this.zzb = Strings.emptyToNull(zzeVar.zzb());
        this.zzc = Strings.emptyToNull(zzeVar.zza());
        this.zzd = Strings.emptyToNull(zzeVar.zzc());
        this.zze = zzeVar.zzf();
        this.zzf = zzeVar.zzd();
        this.zzg = new ArrayList();
        Iterator<zzr> it = zzeVar.zzh().iterator();
        while (it.hasNext()) {
            this.zzg.add(zzfh.zza(it.next()));
        }
        this.zzh = zzeVar.zzg();
        return this;
    }
}
