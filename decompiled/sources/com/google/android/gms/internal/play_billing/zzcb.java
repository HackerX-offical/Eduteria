package com.google.android.gms.internal.play_billing;

import java.io.Serializable;
import java.util.Set;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzcb extends zzaq implements Serializable {
    private static final zzcb zza;
    private static final zzcb zzb;
    private final transient zzbw zzc;

    static {
        int i = zzbw.zzd;
        zza = new zzcb(zzcs.zza);
        zzb = new zzcb(zzbw.zzm(zzcp.zza()));
    }

    zzcb(zzbw zzbwVar) {
        this.zzc = zzbwVar;
    }

    static zzcb zza() {
        return zzb;
    }

    public static zzcb zzb() {
        return zza;
    }

    @Override // com.google.android.gms.internal.play_billing.zzcr
    public final /* bridge */ /* synthetic */ Set zzc() {
        return this.zzc.isEmpty() ? zzcy.zza : new zzcz(this.zzc, zzco.zza);
    }
}
