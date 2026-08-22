package com.google.android.gms.internal.vision;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
abstract class zzju {
    private static final zzju zza;
    private static final zzju zzb;

    private zzju() {
    }

    abstract <L> List<L> zza(Object obj, long j);

    abstract <L> void zza(Object obj, Object obj2, long j);

    abstract void zzb(Object obj, long j);

    static zzju zza() {
        return zza;
    }

    static zzju zzb() {
        return zzb;
    }

    static {
        zzjx zzjxVar = null;
        zza = new zzjw();
        zzb = new zzjz();
    }
}
