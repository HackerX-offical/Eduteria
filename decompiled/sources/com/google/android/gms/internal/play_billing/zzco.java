package com.google.android.gms.internal.play_billing;

import java.io.Serializable;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzco extends zzcm implements Serializable {
    static final zzcm zza = new zzco();

    private zzco() {
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzcp zzcpVar = (zzcp) obj;
        zzcp zzcpVar2 = (zzcp) obj2;
        return zzbi.zzf().zzb(zzcpVar.zza, zzcpVar2.zza).zzb(zzcpVar.zzb, zzcpVar2.zzb).zza();
    }
}
