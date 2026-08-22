package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzjh<K, V> {
    static <K, V> void zza(zzho zzhoVar, zzjg<K, V> zzjgVar, K k, V v) throws IOException {
        zzhx.zza(zzhoVar, zzjgVar.zza, 1, k);
        zzhx.zza(zzhoVar, zzjgVar.zzc, 2, v);
    }

    static <K, V> int zza(zzjg<K, V> zzjgVar, K k, V v) {
        return zzhx.zza(zzjgVar.zza, 1, k) + zzhx.zza(zzjgVar.zzc, 2, v);
    }
}
