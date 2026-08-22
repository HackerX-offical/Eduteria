package org.bouncycastle.pqc.crypto.gmss.util;

import org.bouncycastle.crypto.Digest;

/* JADX INFO: loaded from: classes10.dex */
public class WinternitzOTSVerify {
    private Digest messDigestOTS;
    private int w;

    public WinternitzOTSVerify(Digest digest, int i) {
        this.w = i;
        this.messDigestOTS = digest;
    }

    public byte[] Verify(byte[] bArr, byte[] bArr2) {
        int i;
        int i2;
        int i3;
        int i4;
        int digestSize = this.messDigestOTS.getDigestSize();
        byte[] bArr3 = new byte[digestSize];
        int i5 = 0;
        this.messDigestOTS.update(bArr, 0, bArr.length);
        int digestSize2 = this.messDigestOTS.getDigestSize();
        byte[] bArr4 = new byte[digestSize2];
        this.messDigestOTS.doFinal(bArr4, 0);
        int i6 = digestSize << 3;
        int i7 = this.w;
        int i8 = ((i7 - 1) + i6) / i7;
        boolean z = true;
        int log = getLog((i8 << i7) + 1);
        int i9 = this.w;
        int i10 = ((((log + i9) - 1) / i9) + i8) * digestSize;
        if (i10 != bArr2.length) {
            return null;
        }
        byte[] bArr5 = new byte[i10];
        int i11 = 8;
        if (8 % i9 == 0) {
            int i12 = 8 / i9;
            int i13 = (1 << i9) - 1;
            byte[] bArr6 = new byte[digestSize];
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            while (i14 < digestSize2) {
                while (i5 < i12) {
                    int i17 = bArr4[i14] & i13;
                    i15 += i17;
                    int i18 = digestSize2;
                    int i19 = i16 * digestSize;
                    byte[] bArr7 = bArr4;
                    System.arraycopy(bArr2, i19, bArr6, 0, digestSize);
                    int i20 = i17;
                    while (i20 < i13) {
                        this.messDigestOTS.update(bArr6, 0, bArr6.length);
                        bArr6 = new byte[this.messDigestOTS.getDigestSize()];
                        this.messDigestOTS.doFinal(bArr6, 0);
                        i20++;
                        i5 = i5;
                        i8 = i8;
                    }
                    System.arraycopy(bArr6, 0, bArr5, i19, digestSize);
                    bArr7[i14] = (byte) (bArr7[i14] >>> this.w);
                    i16++;
                    i5++;
                    digestSize2 = i18;
                    bArr4 = bArr7;
                    i8 = i8;
                }
                i14++;
                i5 = 0;
            }
            int i21 = (i8 << this.w) - i15;
            int i22 = 0;
            while (i22 < log) {
                int i23 = i16 * digestSize;
                System.arraycopy(bArr2, i23, bArr6, 0, digestSize);
                for (int i24 = i21 & i13; i24 < i13; i24++) {
                    this.messDigestOTS.update(bArr6, 0, bArr6.length);
                    bArr6 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr6, 0);
                }
                System.arraycopy(bArr6, 0, bArr5, i23, digestSize);
                int i25 = this.w;
                i21 >>>= i25;
                i16++;
                i22 += i25;
            }
        } else if (i9 < 8) {
            int i26 = digestSize / i9;
            int i27 = (1 << i9) - 1;
            byte[] bArr8 = new byte[digestSize];
            int i28 = 0;
            int i29 = 0;
            int i30 = 0;
            int i31 = 0;
            while (true) {
                boolean z2 = z;
                if (i28 >= i26) {
                    break;
                }
                long j = 0;
                for (int i32 = 0; i32 < this.w; i32++) {
                    j ^= (long) ((bArr4[i29] & 255) << (i32 << 3));
                    i29++;
                }
                int i33 = 0;
                while (i33 < i11) {
                    int i34 = (int) (j & ((long) i27));
                    i30 += i34;
                    int i35 = i31 * digestSize;
                    int i36 = i11;
                    System.arraycopy(bArr2, i35, bArr8, 0, digestSize);
                    while (true) {
                        i4 = i26;
                        if (i34 < i27) {
                            this.messDigestOTS.update(bArr8, 0, bArr8.length);
                            bArr8 = new byte[this.messDigestOTS.getDigestSize()];
                            this.messDigestOTS.doFinal(bArr8, 0);
                            i34++;
                            i26 = i4;
                            i28 = i28;
                        }
                    }
                    System.arraycopy(bArr8, 0, bArr5, i35, digestSize);
                    j >>>= this.w;
                    i31++;
                    i33++;
                    i11 = i36;
                    i26 = i4;
                }
                i28++;
                z = z2;
            }
            int i37 = digestSize % this.w;
            int i38 = 0;
            long j2 = 0;
            while (i38 < i37) {
                j2 ^= (long) ((bArr4[i29] & 255) << (i38 << 3));
                i29++;
                i38++;
                bArr8 = bArr8;
            }
            int i39 = i37 << 3;
            int i40 = 0;
            while (i40 < i39) {
                int i41 = (int) (((long) i27) & j2);
                i30 += i41;
                int i42 = i31 * digestSize;
                System.arraycopy(bArr2, i42, bArr8, 0, digestSize);
                while (true) {
                    i3 = i39;
                    if (i41 < i27) {
                        this.messDigestOTS.update(bArr8, 0, bArr8.length);
                        bArr8 = new byte[this.messDigestOTS.getDigestSize()];
                        this.messDigestOTS.doFinal(bArr8, 0);
                        i41++;
                        i39 = i3;
                        i40 = i40;
                    }
                }
                System.arraycopy(bArr8, 0, bArr5, i42, digestSize);
                int i43 = this.w;
                j2 >>>= i43;
                i31++;
                i40 += i43;
                i39 = i3;
            }
            int i44 = (i8 << this.w) - i30;
            int i45 = 0;
            while (i45 < log) {
                int i46 = i31 * digestSize;
                System.arraycopy(bArr2, i46, bArr8, 0, digestSize);
                for (int i47 = i44 & i27; i47 < i27; i47++) {
                    this.messDigestOTS.update(bArr8, 0, bArr8.length);
                    bArr8 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr8, 0);
                }
                System.arraycopy(bArr8, 0, bArr5, i46, digestSize);
                int i48 = this.w;
                i44 >>>= i48;
                i31++;
                i45 += i48;
            }
        } else if (i9 < 57) {
            int i49 = i6 - i9;
            int i50 = (1 << i9) - 1;
            byte[] bArr9 = new byte[digestSize];
            int i51 = 0;
            int i52 = 0;
            int i53 = 0;
            while (i53 <= i49) {
                int i54 = i53 >>> 3;
                int i55 = i53 % 8;
                i53 += this.w;
                int i56 = (i53 + 7) >>> 3;
                int i57 = 0;
                long j3 = 0;
                while (true) {
                    i2 = i49;
                    if (i54 >= i56) {
                        break;
                    }
                    j3 ^= (long) ((bArr4[i54] & 255) << (i57 << 3));
                    i57++;
                    i54++;
                    i49 = i2;
                    i52 = i52;
                }
                int i58 = i52;
                long j4 = i50;
                long j5 = (j3 >>> i55) & j4;
                i51 = (int) (((long) i51) + j5);
                int i59 = i58 * digestSize;
                System.arraycopy(bArr2, i59, bArr9, 0, digestSize);
                while (j5 < j4) {
                    this.messDigestOTS.update(bArr9, 0, bArr9.length);
                    bArr9 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr9, 0);
                    j5++;
                }
                System.arraycopy(bArr9, 0, bArr5, i59, digestSize);
                i52 = i58 + 1;
                i49 = i2;
            }
            int i60 = i52;
            int i61 = i53 >>> 3;
            if (i61 < digestSize) {
                int i62 = i53 % 8;
                int i63 = 0;
                long j6 = 0;
                while (i61 < digestSize) {
                    j6 ^= (long) ((bArr4[i61] & 255) << (i63 << 3));
                    i63++;
                    i61++;
                }
                long j7 = j6 >>> i62;
                long j8 = i50;
                long j9 = j7 & j8;
                i51 = (int) (((long) i51) + j9);
                int i64 = i60 * digestSize;
                System.arraycopy(bArr2, i64, bArr9, 0, digestSize);
                while (j9 < j8) {
                    this.messDigestOTS.update(bArr9, 0, bArr9.length);
                    bArr9 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr9, 0);
                    j9++;
                    i51 = i51;
                }
                System.arraycopy(bArr9, 0, bArr5, i64, digestSize);
                i = i60 + 1;
            } else {
                i = i60;
            }
            int i65 = (i8 << this.w) - i51;
            int i66 = 0;
            while (i66 < log) {
                long j10 = i65 & i50;
                int i67 = i * digestSize;
                System.arraycopy(bArr2, i67, bArr9, 0, digestSize);
                while (j10 < i50) {
                    this.messDigestOTS.update(bArr9, 0, bArr9.length);
                    bArr9 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr9, 0);
                    j10++;
                    i50 = i50;
                }
                System.arraycopy(bArr9, 0, bArr5, i67, digestSize);
                int i68 = this.w;
                i65 >>>= i68;
                i++;
                i66 += i68;
                i50 = i50;
            }
        }
        byte[] bArr10 = new byte[digestSize];
        this.messDigestOTS.update(bArr5, 0, i10);
        byte[] bArr11 = new byte[this.messDigestOTS.getDigestSize()];
        this.messDigestOTS.doFinal(bArr11, 0);
        return bArr11;
    }

    public int getLog(int i) {
        int i2 = 1;
        int i3 = 2;
        while (i3 < i) {
            i3 <<= 1;
            i2++;
        }
        return i2;
    }

    public int getSignatureLength() {
        int digestSize = this.messDigestOTS.getDigestSize();
        int i = this.w;
        int i2 = ((digestSize << 3) + (i - 1)) / i;
        int log = getLog((i2 << i) + 1);
        return digestSize * (i2 + (((log + r3) - 1) / this.w));
    }
}
