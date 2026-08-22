package com.google.android.gms.internal.firebase_auth;

import androidx.work.WorkInfo;
import com.google.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzhh extends zzhf {
    private final byte[] zze;
    private final boolean zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;

    private zzhh(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzl = Integer.MAX_VALUE;
        this.zze = bArr;
        this.zzg = i2 + i;
        this.zzi = i;
        this.zzj = i;
        this.zzf = z;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhf
    public final int zza() throws IOException {
        if (zzt()) {
            this.zzk = 0;
            return 0;
        }
        int iZzv = zzv();
        this.zzk = iZzv;
        if ((iZzv >>> 3) != 0) {
            return iZzv;
        }
        throw zzip.zzd();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhf
    public final void zza(int i) throws zzip {
        if (this.zzk != i) {
            throw zzip.zze();
        }
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhf
    public final boolean zzb(int i) throws IOException {
        int iZza;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.zzg - this.zzi >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.zze;
                    int i4 = this.zzi;
                    this.zzi = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzip.zzc();
            }
            while (i3 < 10) {
                if (zzaa() < 0) {
                    i3++;
                }
            }
            throw zzip.zzc();
            return true;
        }
        if (i2 == 1) {
            zzf(8);
            return true;
        }
        if (i2 == 2) {
            zzf(zzv());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 == 5) {
                zzf(4);
                return true;
            }
            throw zzip.zzf();
        }
        do {
            iZza = zza();
            if (iZza == 0) {
                break;
            }
        } while (zzb(iZza));
        zza(((i >>> 3) << 3) | 4);
        return true;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhf
    public final double zzb() throws IOException {
        return Double.longBitsToDouble(zzy());
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhf
    public final float zzc() throws IOException {
        return Float.intBitsToFloat(zzx());
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhf
    public final long zzd() throws IOException {
        return zzw();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhf
    public final long zze() throws IOException {
        return zzw();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhf
    public final int zzf() throws IOException {
        return zzv();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhf
    public final long zzg() throws IOException {
        return zzy();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhf
    public final int zzh() throws IOException {
        return zzx();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhf
    public final boolean zzi() throws IOException {
        return zzw() != 0;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhf
    public final String zzj() throws IOException {
        int iZzv = zzv();
        if (iZzv > 0 && iZzv <= this.zzg - this.zzi) {
            String str = new String(this.zze, this.zzi, iZzv, zzig.zza);
            this.zzi += iZzv;
            return str;
        }
        if (iZzv == 0) {
            return "";
        }
        if (iZzv < 0) {
            throw zzip.zzb();
        }
        throw zzip.zza();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhf
    public final String zzk() throws IOException {
        int iZzv = zzv();
        if (iZzv > 0) {
            int i = this.zzg;
            int i2 = this.zzi;
            if (iZzv <= i - i2) {
                String strZzb = zzlg.zzb(this.zze, i2, iZzv);
                this.zzi += iZzv;
                return strZzb;
            }
        }
        if (iZzv == 0) {
            return "";
        }
        if (iZzv <= 0) {
            throw zzip.zzb();
        }
        throw zzip.zza();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    @Override // com.google.android.gms.internal.firebase_auth.zzhf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.firebase_auth.zzgt zzl() throws java.io.IOException {
        /*
            r3 = this;
            int r0 = r3.zzv()
            if (r0 <= 0) goto L19
            int r1 = r3.zzg
            int r2 = r3.zzi
            int r1 = r1 - r2
            if (r0 > r1) goto L19
            byte[] r1 = r3.zze
            com.google.android.gms.internal.firebase_auth.zzgt r1 = com.google.android.gms.internal.firebase_auth.zzgt.zza(r1, r2, r0)
            int r2 = r3.zzi
            int r2 = r2 + r0
            r3.zzi = r2
            return r1
        L19:
            if (r0 != 0) goto L1e
            com.google.android.gms.internal.firebase_auth.zzgt r0 = com.google.android.gms.internal.firebase_auth.zzgt.zza
            return r0
        L1e:
            if (r0 <= 0) goto L31
            int r1 = r3.zzg
            int r2 = r3.zzi
            int r1 = r1 - r2
            if (r0 > r1) goto L31
            int r0 = r0 + r2
            r3.zzi = r0
            byte[] r1 = r3.zze
            byte[] r0 = java.util.Arrays.copyOfRange(r1, r2, r0)
            goto L37
        L31:
            if (r0 > 0) goto L41
            if (r0 != 0) goto L3c
            byte[] r0 = com.google.android.gms.internal.firebase_auth.zzig.zzb
        L37:
            com.google.android.gms.internal.firebase_auth.zzgt r0 = com.google.android.gms.internal.firebase_auth.zzgt.zzb(r0)
            return r0
        L3c:
            com.google.android.gms.internal.firebase_auth.zzip r0 = com.google.android.gms.internal.firebase_auth.zzip.zzb()
            throw r0
        L41:
            com.google.android.gms.internal.firebase_auth.zzip r0 = com.google.android.gms.internal.firebase_auth.zzip.zza()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzhh.zzl():com.google.android.gms.internal.firebase_auth.zzgt");
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhf
    public final int zzm() throws IOException {
        return zzv();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhf
    public final int zzn() throws IOException {
        return zzv();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhf
    public final int zzo() throws IOException {
        return zzx();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhf
    public final long zzp() throws IOException {
        return zzy();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhf
    public final int zzq() throws IOException {
        return zze(zzv());
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhf
    public final long zzr() throws IOException {
        return zza(zzw());
    }

    private final int zzv() throws IOException {
        int i;
        int i2 = this.zzi;
        int i3 = this.zzg;
        if (i3 != i2) {
            byte[] bArr = this.zze;
            int i4 = i2 + 1;
            byte b2 = bArr[i2];
            if (b2 >= 0) {
                this.zzi = i4;
                return b2;
            }
            if (i3 - i4 >= 9) {
                int i5 = i2 + 2;
                int i6 = (bArr[i4] << 7) ^ b2;
                if (i6 < 0) {
                    i = i6 ^ WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
                } else {
                    int i7 = i2 + 3;
                    int i8 = (bArr[i5] << 14) ^ i6;
                    if (i8 >= 0) {
                        i = i8 ^ 16256;
                    } else {
                        int i9 = i2 + 4;
                        int i10 = i8 ^ (bArr[i7] << Ascii.NAK);
                        if (i10 < 0) {
                            i = (-2080896) ^ i10;
                        } else {
                            i7 = i2 + 5;
                            byte b3 = bArr[i9];
                            int i11 = (i10 ^ (b3 << Ascii.FS)) ^ 266354560;
                            if (b3 < 0) {
                                i9 = i2 + 6;
                                if (bArr[i7] < 0) {
                                    i7 = i2 + 7;
                                    if (bArr[i9] < 0) {
                                        i9 = i2 + 8;
                                        if (bArr[i7] < 0) {
                                            i7 = i2 + 9;
                                            if (bArr[i9] < 0) {
                                                int i12 = i2 + 10;
                                                if (bArr[i7] >= 0) {
                                                    i5 = i12;
                                                    i = i11;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i11;
                            }
                            i = i11;
                        }
                        i5 = i9;
                    }
                    i5 = i7;
                }
                this.zzi = i5;
                return i;
            }
        }
        return (int) zzs();
    }

    private final long zzw() throws IOException {
        long j;
        long j2;
        long j3;
        int i = this.zzi;
        int i2 = this.zzg;
        if (i2 != i) {
            byte[] bArr = this.zze;
            int i3 = i + 1;
            byte b2 = bArr[i];
            if (b2 >= 0) {
                this.zzi = i3;
                return b2;
            }
            if (i2 - i3 >= 9) {
                int i4 = i + 2;
                int i5 = (bArr[i3] << 7) ^ b2;
                if (i5 < 0) {
                    j = i5 ^ WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
                } else {
                    int i6 = i + 3;
                    int i7 = (bArr[i4] << 14) ^ i5;
                    if (i7 >= 0) {
                        j = i7 ^ 16256;
                        i4 = i6;
                    } else {
                        int i8 = i + 4;
                        int i9 = i7 ^ (bArr[i6] << Ascii.NAK);
                        if (i9 < 0) {
                            long j4 = (-2080896) ^ i9;
                            i4 = i8;
                            j = j4;
                        } else {
                            long j5 = i9;
                            i4 = i + 5;
                            long j6 = j5 ^ (((long) bArr[i8]) << 28);
                            if (j6 >= 0) {
                                j3 = 266354560;
                            } else {
                                int i10 = i + 6;
                                long j7 = j6 ^ (((long) bArr[i4]) << 35);
                                if (j7 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    i4 = i + 7;
                                    j6 = j7 ^ (((long) bArr[i10]) << 42);
                                    if (j6 >= 0) {
                                        j3 = 4363953127296L;
                                    } else {
                                        i10 = i + 8;
                                        j7 = j6 ^ (((long) bArr[i4]) << 49);
                                        if (j7 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            i4 = i + 9;
                                            long j8 = (j7 ^ (((long) bArr[i10]) << 56)) ^ 71499008037633920L;
                                            if (j8 < 0) {
                                                int i11 = i + 10;
                                                if (bArr[i4] >= 0) {
                                                    i4 = i11;
                                                }
                                            }
                                            j = j8;
                                        }
                                    }
                                }
                                j = j7 ^ j2;
                                i4 = i10;
                            }
                            j = j6 ^ j3;
                        }
                    }
                }
                this.zzi = i4;
                return j;
            }
        }
        return zzs();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhf
    final long zzs() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte bZzaa = zzaa();
            j |= ((long) (bZzaa & 127)) << i;
            if ((bZzaa & 128) == 0) {
                return j;
            }
        }
        throw zzip.zzc();
    }

    private final int zzx() throws IOException {
        int i = this.zzi;
        if (this.zzg - i < 4) {
            throw zzip.zza();
        }
        byte[] bArr = this.zze;
        this.zzi = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private final long zzy() throws IOException {
        int i = this.zzi;
        if (this.zzg - i < 8) {
            throw zzip.zza();
        }
        byte[] bArr = this.zze;
        this.zzi = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhf
    public final int zzc(int i) throws zzip {
        if (i < 0) {
            throw zzip.zzb();
        }
        int iZzu = i + zzu();
        int i2 = this.zzl;
        if (iZzu > i2) {
            throw zzip.zza();
        }
        this.zzl = iZzu;
        zzz();
        return i2;
    }

    private final void zzz() {
        int i = this.zzg + this.zzh;
        this.zzg = i;
        int i2 = i - this.zzj;
        int i3 = this.zzl;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.zzh = i4;
            this.zzg = i - i4;
            return;
        }
        this.zzh = 0;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhf
    public final void zzd(int i) {
        this.zzl = i;
        zzz();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhf
    public final boolean zzt() throws IOException {
        return this.zzi == this.zzg;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhf
    public final int zzu() {
        return this.zzi - this.zzj;
    }

    private final byte zzaa() throws IOException {
        int i = this.zzi;
        if (i == this.zzg) {
            throw zzip.zza();
        }
        byte[] bArr = this.zze;
        this.zzi = i + 1;
        return bArr[i];
    }

    private final void zzf(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.zzg;
            int i3 = this.zzi;
            if (i <= i2 - i3) {
                this.zzi = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzip.zzb();
        }
        throw zzip.zza();
    }
}
