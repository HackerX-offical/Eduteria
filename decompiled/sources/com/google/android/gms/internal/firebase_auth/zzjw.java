package com.google.android.gms.internal.firebase_auth;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzjw {
    private static final zzju zza = zzc();
    private static final zzju zzb = new zzjx();

    static zzju zza() {
        return zza;
    }

    static zzju zzb() {
        return zzb;
    }

    private static zzju zzc() {
        try {
            return (zzju) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
