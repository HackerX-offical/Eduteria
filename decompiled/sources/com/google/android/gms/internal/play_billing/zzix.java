package com.google.android.gms.internal.play_billing;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
abstract class zzix {
    final Unsafe zza;

    zzix(Unsafe unsafe) {
        this.zza = unsafe;
    }

    public abstract double zza(Object obj, long j);

    public abstract float zzb(Object obj, long j);

    public abstract void zzc(Object obj, long j, boolean z);

    public abstract void zzd(Object obj, long j, byte b2);

    public abstract void zze(Object obj, long j, double d2);

    public abstract void zzf(Object obj, long j, float f2);

    public abstract boolean zzg(Object obj, long j);
}
