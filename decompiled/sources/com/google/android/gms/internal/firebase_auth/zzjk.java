package com.google.android.gms.internal.firebase_auth;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzjk {
    private static final zzji zza = zzc();
    private static final zzji zzb = new zzjl();

    static zzji zza() {
        return zza;
    }

    static zzji zzb() {
        return zzb;
    }

    private static zzji zzc() {
        try {
            return (zzji) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
