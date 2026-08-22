package com.google.android.gms.internal.firebase_auth;

import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
abstract class zziz {
    private static final zziz zza;
    private static final zziz zzb;

    private zziz() {
    }

    abstract <L> List<L> zza(Object obj, long j);

    abstract <L> void zza(Object obj, Object obj2, long j);

    abstract void zzb(Object obj, long j);

    static zziz zza() {
        return zza;
    }

    static zziz zzb() {
        return zzb;
    }

    static {
        zziy zziyVar = null;
        zza = new zzjb();
        zzb = new zzja();
    }
}
