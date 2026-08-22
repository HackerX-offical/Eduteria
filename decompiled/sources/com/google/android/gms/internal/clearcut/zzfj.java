package com.google.android.gms.internal.clearcut;

import androidx.window.core.layout.WindowSizeClass;
import com.csvreader.CsvReader;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes8.dex */
final class zzfj extends zzfg {
    zzfj() {
    }

    private static int zza(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            return zzff.zzam(i);
        }
        if (i2 == 1) {
            return zzff.zzp(i, zzfd.zza(bArr, j));
        }
        if (i2 == 2) {
            return zzff.zzd(i, zzfd.zza(bArr, j), zzfd.zza(bArr, j + 1));
        }
        throw new AssertionError();
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0061, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008f, code lost:
    
        return -1;
     */
    @Override // com.google.android.gms.internal.clearcut.zzfg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final int zzb(int r16, byte[] r17, int r18, int r19) {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzfj.zzb(int, byte[], int, int):int");
    }

    @Override // com.google.android.gms.internal.clearcut.zzfg
    final int zzb(CharSequence charSequence, byte[] bArr, int i, int i2) {
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
            zzfd.zza(bArr, j4, (byte) cCharAt);
            i4++;
            j4 = 1 + j4;
        }
        if (i4 == length) {
            return (int) j4;
        }
        while (i4 < length) {
            char cCharAt2 = charSequence.charAt(i4);
            if (cCharAt2 < 128 && j4 < j5) {
                zzfd.zza(bArr, j4, (byte) cCharAt2);
                j3 = j5;
                j2 = j;
                j4 += j;
            } else if (cCharAt2 >= 2048 || j4 > j5 - 2) {
                j2 = j;
                if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || j4 > j5 - 3) {
                    j3 = j5;
                    if (j4 > j3 - 4) {
                        if (55296 > cCharAt2 || cCharAt2 > 57343 || ((i3 = i4 + 1) != length && Character.isSurrogatePair(cCharAt2, charSequence.charAt(i3)))) {
                            throw new ArrayIndexOutOfBoundsException(new StringBuilder(46).append("Failed writing ").append(cCharAt2).append(" at index ").append(j4).toString());
                        }
                        throw new zzfi(i4, length);
                    }
                    int i5 = i4 + 1;
                    if (i5 != length) {
                        char cCharAt3 = charSequence.charAt(i5);
                        if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                            int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                            zzfd.zza(bArr, j4, (byte) ((codePoint >>> 18) | 240));
                            zzfd.zza(bArr, j4 + j2, (byte) (((codePoint >>> 12) & 63) | 128));
                            long j6 = j4 + 3;
                            zzfd.zza(bArr, j4 + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                            j4 += 4;
                            zzfd.zza(bArr, j6, (byte) ((codePoint & 63) | 128));
                            i4 = i5;
                        } else {
                            i4 = i5;
                        }
                    }
                    throw new zzfi(i4 - 1, length);
                }
                zzfd.zza(bArr, j4, (byte) ((cCharAt2 >>> CsvReader.Letters.FORM_FEED) | WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND));
                long j7 = j4 + 2;
                j3 = j5;
                zzfd.zza(bArr, j4 + j2, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                j4 += 3;
                zzfd.zza(bArr, j7, (byte) ((cCharAt2 & '?') | 128));
            } else {
                j2 = j;
                long j8 = j4 + j2;
                zzfd.zza(bArr, j4, (byte) ((cCharAt2 >>> 6) | 960));
                j4 += 2;
                zzfd.zza(bArr, j8, (byte) ((cCharAt2 & '?') | 128));
                j3 = j5;
            }
            i4++;
            j = j2;
            j5 = j3;
        }
        return (int) j4;
    }

    @Override // com.google.android.gms.internal.clearcut.zzfg
    final void zzb(CharSequence charSequence, ByteBuffer byteBuffer) {
        long j;
        char c2;
        long j2;
        long j3;
        long j4;
        long j5;
        int i;
        char c3;
        char cCharAt;
        long jZzb = zzfd.zzb(byteBuffer);
        long jPosition = ((long) byteBuffer.position()) + jZzb;
        long jLimit = ((long) byteBuffer.limit()) + jZzb;
        int length = charSequence.length();
        if (length > jLimit - jPosition) {
            throw new ArrayIndexOutOfBoundsException(new StringBuilder(37).append("Failed writing ").append(charSequence.charAt(length - 1)).append(" at index ").append(byteBuffer.limit()).toString());
        }
        int i2 = 0;
        while (true) {
            j = 1;
            c2 = 128;
            if (i2 >= length || (cCharAt = charSequence.charAt(i2)) >= 128) {
                break;
            }
            zzfd.zza(jPosition, (byte) cCharAt);
            i2++;
            jPosition = 1 + jPosition;
        }
        if (i2 == length) {
            j2 = jPosition - jZzb;
        } else {
            while (i2 < length) {
                char cCharAt2 = charSequence.charAt(i2);
                if (cCharAt2 >= c2 || jPosition >= jLimit) {
                    j3 = j;
                    if (cCharAt2 < 2048 && jPosition <= jLimit - 2) {
                        long j6 = jPosition + j3;
                        zzfd.zza(jPosition, (byte) ((cCharAt2 >>> 6) | 960));
                        jPosition += 2;
                        zzfd.zza(j6, (byte) ((cCharAt2 & '?') | 128));
                        j4 = jZzb;
                        j5 = jLimit;
                    } else {
                        if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || jPosition > jLimit - 3) {
                            j4 = jZzb;
                            j5 = jLimit;
                            if (jPosition > j5 - 4) {
                                if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i = i2 + 1) == length || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i)))) {
                                    throw new zzfi(i2, length);
                                }
                                throw new ArrayIndexOutOfBoundsException(new StringBuilder(46).append("Failed writing ").append(cCharAt2).append(" at index ").append(jPosition).toString());
                            }
                            int i3 = i2 + 1;
                            if (i3 != length) {
                                char cCharAt3 = charSequence.charAt(i3);
                                if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                    int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                    zzfd.zza(jPosition, (byte) ((codePoint >>> 18) | 240));
                                    c3 = 128;
                                    zzfd.zza(jPosition + j3, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j7 = jPosition + 3;
                                    zzfd.zza(jPosition + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                    jPosition += 4;
                                    zzfd.zza(j7, (byte) ((codePoint & 63) | 128));
                                    i2 = i3;
                                } else {
                                    i2 = i3;
                                }
                            }
                            throw new zzfi(i2 - 1, length);
                        }
                        zzfd.zza(jPosition, (byte) ((cCharAt2 >>> CsvReader.Letters.FORM_FEED) | WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND));
                        j4 = jZzb;
                        long j8 = jPosition + 2;
                        j5 = jLimit;
                        zzfd.zza(jPosition + j3, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                        jPosition += 3;
                        zzfd.zza(j8, (byte) ((cCharAt2 & '?') | 128));
                    }
                    c3 = 128;
                } else {
                    zzfd.zza(jPosition, (byte) cCharAt2);
                    j4 = jZzb;
                    j5 = jLimit;
                    c3 = c2;
                    jPosition += j;
                    j3 = j;
                }
                i2++;
                c2 = c3;
                j = j3;
                jZzb = j4;
                jLimit = j5;
            }
            j2 = jPosition - jZzb;
        }
        byteBuffer.position((int) j2);
    }
}
