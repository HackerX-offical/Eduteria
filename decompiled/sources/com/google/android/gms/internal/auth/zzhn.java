package com.google.android.gms.internal.auth;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* JADX INFO: loaded from: classes8.dex */
final class zzhn {
    public static final /* synthetic */ int zza = 0;
    private static final zzhl zzb;

    static {
        if (zzhj.zzu() && zzhj.zzv()) {
            int i = zzds.zza;
        }
        zzb = new zzhm();
    }

    static /* bridge */ /* synthetic */ int zza(byte[] bArr, int i, int i2) {
        int i3 = i2 - i;
        byte b2 = bArr[i - 1];
        if (i3 == 0) {
            if (b2 > -12) {
                return -1;
            }
            return b2;
        }
        if (i3 == 1) {
            byte b3 = bArr[i];
            if (b2 > -12 || b3 > -65) {
                return -1;
            }
            return (b3 << 8) ^ b2;
        }
        if (i3 != 2) {
            throw new AssertionError();
        }
        byte b4 = bArr[i];
        byte b5 = bArr[i + 1];
        if (b2 > -12 || b4 > -65 || b5 > -65) {
            return -1;
        }
        return (b5 << 16) ^ ((b4 << 8) ^ b2);
    }

    static boolean zzb(byte[] bArr) {
        return zzb.zzb(bArr, 0, bArr.length);
    }

    static boolean zzc(byte[] bArr, int i, int i2) {
        return zzb.zzb(bArr, i, i2);
    }
}
