package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzjb;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
final class zzjc implements zzkl {
    private static final zzjc zza = new zzjc();

    private zzjc() {
    }

    public static zzjc zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final boolean zza(Class<?> cls) {
        return zzjb.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final zzki zzb(Class<?> cls) {
        if (!zzjb.class.isAssignableFrom(cls)) {
            String strValueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(strValueOf.length() != 0 ? "Unsupported message type: ".concat(strValueOf) : new String("Unsupported message type: "));
        }
        try {
            return (zzki) zzjb.zza(cls.asSubclass(zzjb.class)).zza(zzjb.zzg.zzc, (Object) null, (Object) null);
        } catch (Exception e2) {
            String strValueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(strValueOf2.length() != 0 ? "Unable to get message info for ".concat(strValueOf2) : new String("Unable to get message info for "), e2);
        }
    }
}
