package com.google.android.gms.internal.firebase_auth;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzhu {
    private static final zzht<?> zza = new zzhv();
    private static final zzht<?> zzb = zzc();

    private static zzht<?> zzc() {
        try {
            return (zzht) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static zzht<?> zza() {
        return zza;
    }

    static zzht<?> zzb() {
        zzht<?> zzhtVar = zzb;
        if (zzhtVar != null) {
            return zzhtVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
