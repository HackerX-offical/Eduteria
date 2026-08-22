package com.google.android.gms.internal.firebase_auth;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzah extends zzai {
    private final char zza = '.';

    zzah(char c2) {
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzaf
    public final boolean zza(char c2) {
        return c2 == this.zza;
    }

    public final String toString() {
        String strZzc = zzaf.zzc(this.zza);
        return new StringBuilder(String.valueOf(strZzc).length() + 18).append("CharMatcher.is('").append(strZzc).append("')").toString();
    }
}
