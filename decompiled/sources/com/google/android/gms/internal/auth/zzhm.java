package com.google.android.gms.internal.auth;

import com.google.common.base.Ascii;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* JADX INFO: loaded from: classes8.dex */
final class zzhm extends zzhl {
    zzhm() {
    }

    @Override // com.google.android.gms.internal.auth.zzhl
    final int zza(int i, byte[] bArr, int i2, int i3) {
        while (i2 < i3 && bArr[i2] >= 0) {
            i2++;
        }
        if (i2 >= i3) {
            return 0;
        }
        while (i2 < i3) {
            int i4 = i2 + 1;
            byte b2 = bArr[i2];
            if (b2 >= 0) {
                i2 = i4;
            } else {
                if (b2 < -32) {
                    if (i4 >= i3) {
                        return b2;
                    }
                    if (b2 >= -62) {
                        i2 += 2;
                        if (bArr[i4] > -65) {
                        }
                    }
                    return -1;
                }
                if (b2 >= -16) {
                    if (i4 >= i3 - 2) {
                        return zzhn.zza(bArr, i4, i3);
                    }
                    int i5 = i2 + 2;
                    byte b3 = bArr[i4];
                    if (b3 <= -65 && (((b2 << Ascii.FS) + (b3 + 112)) >> 30) == 0) {
                        int i6 = i2 + 3;
                        if (bArr[i5] <= -65) {
                            i2 += 4;
                            if (bArr[i6] > -65) {
                            }
                        }
                    }
                    return -1;
                }
                if (i4 >= i3 - 1) {
                    return zzhn.zza(bArr, i4, i3);
                }
                int i7 = i2 + 2;
                byte b4 = bArr[i4];
                if (b4 > -65 || (b2 == -32 && b4 < -96)) {
                    return -1;
                }
                if (b2 == -19 && b4 >= -96) {
                    return -1;
                }
                i2 += 3;
                if (bArr[i7] > -65) {
                    return -1;
                }
            }
        }
        return 0;
    }
}
