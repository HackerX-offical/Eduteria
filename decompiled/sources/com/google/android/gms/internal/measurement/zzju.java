package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.1.2 */
/* JADX INFO: loaded from: classes8.dex */
final class zzju implements zzkz {
    private static final zzju zza = new zzju();

    public static zzju zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzkz
    public final zzla zza(Class<?> cls) {
        if (!zzjt.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        try {
            return (zzla) zzjt.zza(cls.asSubclass(zzjt.class)).zza(zzjt.zze.zzc, (Object) null, (Object) null);
        } catch (Exception e2) {
            throw new RuntimeException("Unable to get message info for " + cls.getName(), e2);
        }
    }

    private zzju() {
    }

    @Override // com.google.android.gms.internal.measurement.zzkz
    public final boolean zzb(Class<?> cls) {
        return zzjt.class.isAssignableFrom(cls);
    }
}
