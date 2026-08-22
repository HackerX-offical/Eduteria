package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzbf extends zzbi {
    zzbf() {
        super(null);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbi
    public final int zza() {
        return 0;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbi
    public final zzbi zzb(Comparable comparable, Comparable comparable2) {
        int iCompareTo = comparable.compareTo(comparable2);
        return iCompareTo < 0 ? zzbi.zzb : iCompareTo > 0 ? zzbi.zzc : zzbi.zza;
    }
}
