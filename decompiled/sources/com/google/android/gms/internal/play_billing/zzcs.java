package com.google.android.gms.internal.play_billing;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzcs extends zzbw {
    static final zzbw zza = new zzcs(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzcs(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzam.zza(i, this.zzc, FirebaseAnalytics.Param.INDEX);
        return Objects.requireNonNull(this.zzb[i]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbw, com.google.android.gms.internal.play_billing.zzbr
    final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbr
    final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbr
    final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbr
    final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbr
    final Object[] zzg() {
        return this.zzb;
    }
}
