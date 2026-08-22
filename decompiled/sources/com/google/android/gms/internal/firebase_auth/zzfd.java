package com.google.android.gms.internal.firebase_auth;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final /* synthetic */ class zzfd {
    static final /* synthetic */ int[] zza;

    static {
        int[] iArr = new int[zzgk.values().length];
        zza = iArr;
        try {
            iArr[zzgk.PASSWORD_RESET.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            zza[zzgk.VERIFY_EMAIL.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            zza[zzgk.EMAIL_SIGNIN.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            zza[zzgk.VERIFY_AND_CHANGE_EMAIL.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
