package com.google.android.gms.internal.firebase_auth;

import androidx.window.core.layout.WindowSizeClass;
import com.csvreader.CsvReader;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzlm extends zzlh {
    zzlm() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0061, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008f, code lost:
    
        return -1;
     */
    @Override // com.google.android.gms.internal.firebase_auth.zzlh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final int zza(int r16, byte[] r17, int r18, int r19) {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzlm.zza(int, byte[], int, int):int");
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzlh
    final String zzb(byte[] bArr, int i, int i2) throws zzip {
        if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte bZza = zzld.zza(bArr, i);
            if (!zzli.zzd(bZza)) {
                break;
            }
            i++;
            zzli.zzb(bZza, cArr, i4);
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte bZza2 = zzld.zza(bArr, i);
            if (zzli.zzd(bZza2)) {
                int i7 = i5 + 1;
                zzli.zzb(bZza2, cArr, i5);
                while (i6 < i3) {
                    byte bZza3 = zzld.zza(bArr, i6);
                    if (!zzli.zzd(bZza3)) {
                        break;
                    }
                    i6++;
                    zzli.zzb(bZza3, cArr, i7);
                    i7++;
                }
                i5 = i7;
                i = i6;
            } else if (zzli.zze(bZza2)) {
                if (i6 >= i3) {
                    throw zzip.zzi();
                }
                i += 2;
                zzli.zzb(bZza2, zzld.zza(bArr, i6), cArr, i5);
                i5++;
            } else if (zzli.zzf(bZza2)) {
                if (i6 < i3 - 1) {
                    int i8 = i + 2;
                    i += 3;
                    zzli.zzb(bZza2, zzld.zza(bArr, i6), zzld.zza(bArr, i8), cArr, i5);
                    i5++;
                } else {
                    throw zzip.zzi();
                }
            } else {
                if (i6 >= i3 - 2) {
                    throw zzip.zzi();
                }
                byte bZza4 = zzld.zza(bArr, i6);
                int i9 = i + 3;
                byte bZza5 = zzld.zza(bArr, i + 2);
                i += 4;
                zzli.zzb(bZza2, bZza4, bZza5, zzld.zza(bArr, i9), cArr, i5);
                i5 += 2;
            }
        }
        return new String(cArr, 0, i5);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzlh
    final int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        long j;
        long j2;
        long j3;
        int i3;
        char cCharAt;
        long j4 = i;
        long j5 = ((long) i2) + j4;
        int length = charSequence.length();
        if (length > i2 || bArr.length - i2 < i) {
            throw new ArrayIndexOutOfBoundsException(new StringBuilder(37).append("Failed writing ").append(charSequence.charAt(length - 1)).append(" at index ").append(i + i2).toString());
        }
        int i4 = 0;
        while (true) {
            j = 1;
            if (i4 >= length || (cCharAt = charSequence.charAt(i4)) >= 128) {
                break;
            }
            zzld.zza(bArr, j4, (byte) cCharAt);
            i4++;
            j4 = 1 + j4;
        }
        if (i4 == length) {
            return (int) j4;
        }
        while (i4 < length) {
            char cCharAt2 = charSequence.charAt(i4);
            if (cCharAt2 < 128 && j4 < j5) {
                zzld.zza(bArr, j4, (byte) cCharAt2);
                j3 = j5;
                j2 = j;
                j4 += j;
            } else if (cCharAt2 >= 2048 || j4 > j5 - 2) {
                j2 = j;
                if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || j4 > j5 - 3) {
                    j3 = j5;
                    if (j4 <= j3 - 4) {
                        int i5 = i4 + 1;
                        if (i5 != length) {
                            char cCharAt3 = charSequence.charAt(i5);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                zzld.zza(bArr, j4, (byte) ((codePoint >>> 18) | 240));
                                zzld.zza(bArr, j4 + j2, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j6 = j4 + 3;
                                zzld.zza(bArr, j4 + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                j4 += 4;
                                zzld.zza(bArr, j6, (byte) ((codePoint & 63) | 128));
                                i4 = i5;
                            } else {
                                i4 = i5;
                            }
                        }
                        throw new zzlj(i4 - 1, length);
                    }
                    if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i3 = i4 + 1) == length || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i3)))) {
                        throw new zzlj(i4, length);
                    }
                    throw new ArrayIndexOutOfBoundsException(new StringBuilder(46).append("Failed writing ").append(cCharAt2).append(" at index ").append(j4).toString());
                }
                zzld.zza(bArr, j4, (byte) ((cCharAt2 >>> CsvReader.Letters.FORM_FEED) | WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND));
                long j7 = j4 + 2;
                j3 = j5;
                zzld.zza(bArr, j4 + j2, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                j4 += 3;
                zzld.zza(bArr, j7, (byte) ((cCharAt2 & '?') | 128));
            } else {
                j2 = j;
                long j8 = j4 + j2;
                zzld.zza(bArr, j4, (byte) ((cCharAt2 >>> 6) | 960));
                j4 += 2;
                zzld.zza(bArr, j8, (byte) ((cCharAt2 & '?') | 128));
                j3 = j5;
            }
            i4++;
            j = j2;
            j5 = j3;
        }
        return (int) j4;
    }

    private static int zza(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            return zzlg.zzb(i);
        }
        if (i2 == 1) {
            return zzlg.zzb(i, zzld.zza(bArr, j));
        }
        if (i2 == 2) {
            return zzlg.zzb(i, zzld.zza(bArr, j), zzld.zza(bArr, j + 1));
        }
        throw new AssertionError();
    }
}
