package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzie;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzif implements zzjm {
    private static final zzif zza = new zzif();

    private zzif() {
    }

    public static zzif zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzjm
    public final boolean zza(Class<?> cls) {
        return zzie.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzjm
    public final zzjn zzb(Class<?> cls) {
        if (!zzie.class.isAssignableFrom(cls)) {
            String strValueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(strValueOf.length() != 0 ? "Unsupported message type: ".concat(strValueOf) : new String("Unsupported message type: "));
        }
        try {
            return (zzjn) zzie.zza(cls.asSubclass(zzie.class)).zza(zzie.zze.zzc, (Object) null, (Object) null);
        } catch (Exception e2) {
            String strValueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(strValueOf2.length() != 0 ? "Unable to get message info for ".concat(strValueOf2) : new String("Unable to get message info for "), e2);
        }
    }
}
