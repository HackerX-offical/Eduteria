package com.google.android.gms.internal.firebase_auth;

import androidx.work.WorkInfo;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzhk extends zzhf {
    private final InputStream zze;
    private final byte[] zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private zzhj zzm;

    private zzhk(InputStream inputStream, int i) {
        super();
        this.zzl = Integer.MAX_VALUE;
        this.zzm = null;
        zzig.zza(inputStream, "input");
        this.zze = inputStream;
        this.zzf = new byte[i];
        this.zzg = 0;
        this.zzi = 0;
        this.zzk = 0;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhf
    public final int zza() throws IOException {
        if (zzt()) {
            this.zzj = 0;
            return 0;
        }
        int iZzv = zzv();
        this.zzj = iZzv;
        if ((iZzv >>> 3) != 0) {
            return iZzv;
        }
        throw zzip.zzd();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhf
    public final void zza(int i) throws zzip {
        if (this.zzj != i) {
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
                    byte[] bArr = this.zzf;
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
            zzj(8);
            return true;
        }
        if (i2 == 2) {
            zzj(zzv());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 == 5) {
                zzj(4);
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
            String str = new String(this.zzf, this.zzi, iZzv, zzig.zza);
            this.zzi += iZzv;
            return str;
        }
        if (iZzv == 0) {
            return "";
        }
        if (iZzv <= this.zzg) {
            zzf(iZzv);
            String str2 = new String(this.zzf, this.zzi, iZzv, zzig.zza);
            this.zzi += iZzv;
            return str2;
        }
        return new String(zza(iZzv, false), zzig.zza);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhf
    public final String zzk() throws IOException {
        byte[] bArrZza;
        int iZzv = zzv();
        int i = this.zzi;
        int i2 = this.zzg;
        if (iZzv <= i2 - i && iZzv > 0) {
            bArrZza = this.zzf;
            this.zzi = i + iZzv;
        } else {
            if (iZzv == 0) {
                return "";
            }
            i = 0;
            if (iZzv <= i2) {
                zzf(iZzv);
                bArrZza = this.zzf;
                this.zzi = iZzv;
            } else {
                bArrZza = zza(iZzv, false);
            }
        }
        return zzlg.zzb(bArrZza, i, iZzv);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhf
    public final zzgt zzl() throws IOException {
        int iZzv = zzv();
        int i = this.zzg;
        int i2 = this.zzi;
        if (iZzv <= i - i2 && iZzv > 0) {
            zzgt zzgtVarZza = zzgt.zza(this.zzf, i2, iZzv);
            this.zzi += iZzv;
            return zzgtVarZza;
        }
        if (iZzv == 0) {
            return zzgt.zza;
        }
        byte[] bArrZzh = zzh(iZzv);
        if (bArrZzh != null) {
            return zzgt.zza(bArrZzh);
        }
        int i3 = this.zzi;
        int i4 = this.zzg;
        int length = i4 - i3;
        this.zzk += i4;
        this.zzi = 0;
        this.zzg = 0;
        List<byte[]> listZzi = zzi(iZzv - length);
        byte[] bArr = new byte[iZzv];
        System.arraycopy(this.zzf, i3, bArr, 0, length);
        for (byte[] bArr2 : listZzi) {
            System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
            length += bArr2.length;
        }
        return zzgt.zzb(bArr);
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
            byte[] bArr = this.zzf;
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
            byte[] bArr = this.zzf;
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
            zzf(4);
            i = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private final long zzy() throws IOException {
        int i = this.zzi;
        if (this.zzg - i < 8) {
            zzf(8);
            i = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhf
    public final int zzc(int i) throws zzip {
        if (i < 0) {
            throw zzip.zzb();
        }
        int i2 = i + this.zzk + this.zzi;
        int i3 = this.zzl;
        if (i2 > i3) {
            throw zzip.zza();
        }
        this.zzl = i2;
        zzz();
        return i3;
    }

    private final void zzz() {
        int i = this.zzg + this.zzh;
        this.zzg = i;
        int i2 = this.zzk + i;
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
        return this.zzi == this.zzg && !zzg(1);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhf
    public final int zzu() {
        return this.zzk + this.zzi;
    }

    private final void zzf(int i) throws IOException {
        if (zzg(i)) {
            return;
        }
        if (i > (this.zzc - this.zzk) - this.zzi) {
            throw zzip.zzg();
        }
        throw zzip.zza();
    }

    private final boolean zzg(int i) throws IOException {
        while (this.zzi + i > this.zzg) {
            int i2 = this.zzc;
            int i3 = this.zzk;
            int i4 = this.zzi;
            if (i > (i2 - i3) - i4 || i3 + i4 + i > this.zzl) {
                return false;
            }
            if (i4 > 0) {
                int i5 = this.zzg;
                if (i5 > i4) {
                    byte[] bArr = this.zzf;
                    System.arraycopy(bArr, i4, bArr, 0, i5 - i4);
                }
                this.zzk += i4;
                this.zzg -= i4;
                this.zzi = 0;
            }
            InputStream inputStream = this.zze;
            byte[] bArr2 = this.zzf;
            int i6 = this.zzg;
            int i7 = inputStream.read(bArr2, i6, Math.min(bArr2.length - i6, (this.zzc - this.zzk) - this.zzg));
            if (i7 == 0 || i7 < -1 || i7 > this.zzf.length) {
                String strValueOf = String.valueOf(this.zze.getClass());
                throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf).length() + 91).append(strValueOf).append("#read(byte[]) returned invalid result: ").append(i7).append("\nThe InputStream implementation is buggy.").toString());
            }
            if (i7 <= 0) {
                return false;
            }
            this.zzg += i7;
            zzz();
            if (this.zzg >= i) {
                return true;
            }
        }
        throw new IllegalStateException(new StringBuilder(77).append("refillBuffer() called when ").append(i).append(" bytes were already available in buffer").toString());
    }

    private final byte zzaa() throws IOException {
        if (this.zzi == this.zzg) {
            zzf(1);
        }
        byte[] bArr = this.zzf;
        int i = this.zzi;
        this.zzi = i + 1;
        return bArr[i];
    }

    private final byte[] zza(int i, boolean z) throws IOException {
        byte[] bArrZzh = zzh(i);
        if (bArrZzh != null) {
            return bArrZzh;
        }
        int i2 = this.zzi;
        int i3 = this.zzg;
        int length = i3 - i2;
        this.zzk += i3;
        this.zzi = 0;
        this.zzg = 0;
        List<byte[]> listZzi = zzi(i - length);
        byte[] bArr = new byte[i];
        System.arraycopy(this.zzf, i2, bArr, 0, length);
        for (byte[] bArr2 : listZzi) {
            System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
            length += bArr2.length;
        }
        return bArr;
    }

    private final byte[] zzh(int i) throws IOException {
        if (i == 0) {
            return zzig.zzb;
        }
        if (i < 0) {
            throw zzip.zzb();
        }
        int i2 = this.zzk + this.zzi + i;
        if (i2 - this.zzc > 0) {
            throw zzip.zzg();
        }
        int i3 = this.zzl;
        if (i2 > i3) {
            zzj((i3 - this.zzk) - this.zzi);
            throw zzip.zza();
        }
        int i4 = this.zzg - this.zzi;
        int i5 = i - i4;
        if (i5 >= 4096 && i5 > this.zze.available()) {
            return null;
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.zzf, this.zzi, bArr, 0, i4);
        this.zzk += this.zzg;
        this.zzi = 0;
        this.zzg = 0;
        while (i4 < i) {
            int i6 = this.zze.read(bArr, i4, i - i4);
            if (i6 == -1) {
                throw zzip.zza();
            }
            this.zzk += i6;
            i4 += i6;
        }
        return bArr;
    }

    private final List<byte[]> zzi(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int iMin = Math.min(i, 4096);
            byte[] bArr = new byte[iMin];
            int i2 = 0;
            while (i2 < iMin) {
                int i3 = this.zze.read(bArr, i2, iMin - i2);
                if (i3 == -1) {
                    throw zzip.zza();
                }
                this.zzk += i3;
                i2 += i3;
            }
            i -= iMin;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzj(int i) throws IOException {
        int i2 = this.zzg;
        int i3 = this.zzi;
        if (i <= i2 - i3 && i >= 0) {
            this.zzi = i3 + i;
            return;
        }
        if (i < 0) {
            throw zzip.zzb();
        }
        int i4 = this.zzk;
        int i5 = i4 + i3 + i;
        int i6 = this.zzl;
        if (i5 > i6) {
            zzj((i6 - i4) - i3);
            throw zzip.zza();
        }
        this.zzk = i4 + i3;
        int i7 = i2 - i3;
        this.zzg = 0;
        this.zzi = 0;
        while (i7 < i) {
            try {
                long j = i - i7;
                long jSkip = this.zze.skip(j);
                if (jSkip >= 0 && jSkip <= j) {
                    if (jSkip == 0) {
                        break;
                    } else {
                        i7 += (int) jSkip;
                    }
                } else {
                    String strValueOf = String.valueOf(this.zze.getClass());
                    throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf).length() + 92).append(strValueOf).append("#skip returned invalid result: ").append(jSkip).append("\nThe InputStream implementation is buggy.").toString());
                }
            } finally {
                this.zzk += i7;
                zzz();
            }
        }
        if (i7 >= i) {
            return;
        }
        int i8 = this.zzg;
        int i9 = i8 - this.zzi;
        this.zzi = i8;
        zzf(1);
        while (true) {
            int i10 = i - i9;
            int i11 = this.zzg;
            if (i10 > i11) {
                i9 += i11;
                this.zzi = i11;
                zzf(1);
            } else {
                this.zzi = i10;
                return;
            }
        }
    }
}
