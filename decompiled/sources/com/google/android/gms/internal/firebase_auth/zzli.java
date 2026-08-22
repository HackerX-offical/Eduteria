package com.google.android.gms.internal.firebase_auth;

import com.google.common.base.Ascii;
import okio.Utf8;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzli {
    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzd(byte b2) {
        return b2 >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zze(byte b2) {
        return b2 < -32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzf(byte b2) {
        return b2 < -16;
    }

    private static boolean zzg(byte b2) {
        return b2 > -65;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzb(byte b2, char[] cArr, int i) {
        cArr[i] = (char) b2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzb(byte b2, byte b3, char[] cArr, int i) throws zzip {
        if (b2 < -62 || zzg(b3)) {
            throw zzip.zzi();
        }
        cArr[i] = (char) (((b2 & Ascii.US) << 6) | (b3 & Utf8.REPLACEMENT_BYTE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzb(byte b2, byte b3, byte b4, char[] cArr, int i) throws zzip {
        if (zzg(b3) || ((b2 == -32 && b3 < -96) || ((b2 == -19 && b3 >= -96) || zzg(b4)))) {
            throw zzip.zzi();
        }
        cArr[i] = (char) (((b2 & Ascii.SI) << 12) | ((b3 & Utf8.REPLACEMENT_BYTE) << 6) | (b4 & Utf8.REPLACEMENT_BYTE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzb(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i) throws zzip {
        if (zzg(b3) || (((b2 << Ascii.FS) + (b3 + 112)) >> 30) != 0 || zzg(b4) || zzg(b5)) {
            throw zzip.zzi();
        }
        int i2 = ((b2 & 7) << 18) | ((b3 & Utf8.REPLACEMENT_BYTE) << 12) | ((b4 & Utf8.REPLACEMENT_BYTE) << 6) | (b5 & Utf8.REPLACEMENT_BYTE);
        cArr[i] = (char) ((i2 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
        cArr[i + 1] = (char) ((i2 & 1023) + Utf8.LOG_SURROGATE_HEADER);
    }
}
