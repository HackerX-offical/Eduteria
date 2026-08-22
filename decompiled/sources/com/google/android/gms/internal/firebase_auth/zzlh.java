package com.google.android.gms.internal.firebase_auth;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
abstract class zzlh {
    zzlh() {
    }

    abstract int zza(int i, byte[] bArr, int i2, int i3);

    abstract int zza(CharSequence charSequence, byte[] bArr, int i, int i2);

    abstract String zzb(byte[] bArr, int i, int i2) throws zzip;

    final boolean zza(byte[] bArr, int i, int i2) {
        return zza(0, bArr, i, i2) == 0;
    }
}
