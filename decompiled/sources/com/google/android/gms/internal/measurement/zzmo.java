package com.google.android.gms.internal.measurement;

import com.google.common.base.Ascii;
import okio.Utf8;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.1.2 */
/* JADX INFO: loaded from: classes8.dex */
final class zzmo {
    private static boolean zza(byte b2) {
        return b2 > -65;
    }

    static /* synthetic */ void zza(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i) throws zzkb {
        if (zza(b3) || (((b2 << Ascii.FS) + (b3 + 112)) >> 30) != 0 || zza(b4) || zza(b5)) {
            throw zzkb.zzd();
        }
        int i2 = ((b2 & 7) << 18) | ((b3 & Utf8.REPLACEMENT_BYTE) << 12) | ((b4 & Utf8.REPLACEMENT_BYTE) << 6) | (b5 & Utf8.REPLACEMENT_BYTE);
        cArr[i] = (char) ((i2 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
        cArr[i + 1] = (char) ((i2 & 1023) + Utf8.LOG_SURROGATE_HEADER);
    }

    static /* synthetic */ void zza(byte b2, char[] cArr, int i) {
        cArr[i] = (char) b2;
    }

    static /* synthetic */ void zza(byte b2, byte b3, byte b4, char[] cArr, int i) throws zzkb {
        if (zza(b3) || ((b2 == -32 && b3 < -96) || ((b2 == -19 && b3 >= -96) || zza(b4)))) {
            throw zzkb.zzd();
        }
        cArr[i] = (char) (((b2 & Ascii.SI) << 12) | ((b3 & Utf8.REPLACEMENT_BYTE) << 6) | (b4 & Utf8.REPLACEMENT_BYTE));
    }

    static /* synthetic */ void zza(byte b2, byte b3, char[] cArr, int i) throws zzkb {
        if (b2 < -62 || zza(b3)) {
            throw zzkb.zzd();
        }
        cArr[i] = (char) (((b2 & Ascii.US) << 6) | (b3 & Utf8.REPLACEMENT_BYTE));
    }
}
