package com.google.android.gms.internal.play_billing;

import com.google.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzfi {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    static int zza(byte[] bArr, int i, zzfh zzfhVar) throws zzgz {
        int iZzh = zzh(bArr, i, zzfhVar);
        int i2 = zzfhVar.zza;
        if (i2 < 0) {
            throw new zzgz("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 > bArr.length - iZzh) {
            throw new zzgz("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i2 == 0) {
            zzfhVar.zzc = zzfs.zzb;
            return iZzh;
        }
        zzfhVar.zzc = zzfs.zzj(bArr, iZzh, i2);
        return iZzh + i2;
    }

    static int zzb(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    static int zzc(zzif zzifVar, byte[] bArr, int i, int i2, int i3, zzfh zzfhVar) throws IOException {
        Object objZze = zzifVar.zze();
        int iZzl = zzl(objZze, zzifVar, bArr, i, i2, i3, zzfhVar);
        zzifVar.zzf(objZze);
        zzfhVar.zzc = objZze;
        return iZzl;
    }

    static int zzd(zzif zzifVar, byte[] bArr, int i, int i2, zzfh zzfhVar) throws IOException {
        Object objZze = zzifVar.zze();
        int iZzm = zzm(objZze, zzifVar, bArr, i, i2, zzfhVar);
        zzifVar.zzf(objZze);
        zzfhVar.zzc = objZze;
        return iZzm;
    }

    static int zze(zzif zzifVar, int i, byte[] bArr, int i2, int i3, zzgw zzgwVar, zzfh zzfhVar) throws IOException {
        int iZzd = zzd(zzifVar, bArr, i2, i3, zzfhVar);
        zzgwVar.add(zzfhVar.zzc);
        while (iZzd < i3) {
            int iZzh = zzh(bArr, iZzd, zzfhVar);
            if (i != zzfhVar.zza) {
                break;
            }
            iZzd = zzd(zzifVar, bArr, iZzh, i3, zzfhVar);
            zzgwVar.add(zzfhVar.zzc);
        }
        return iZzd;
    }

    static int zzf(byte[] bArr, int i, zzgw zzgwVar, zzfh zzfhVar) throws IOException {
        zzgt zzgtVar = (zzgt) zzgwVar;
        int iZzh = zzh(bArr, i, zzfhVar);
        int i2 = zzfhVar.zza + iZzh;
        while (iZzh < i2) {
            iZzh = zzh(bArr, iZzh, zzfhVar);
            zzgtVar.zzg(zzfhVar.zza);
        }
        if (iZzh == i2) {
            return iZzh;
        }
        throw new zzgz("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static int zzg(int i, byte[] bArr, int i2, int i3, zzis zzisVar, zzfh zzfhVar) throws zzgz {
        if ((i >>> 3) == 0) {
            throw new zzgz("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzk = zzk(bArr, i2, zzfhVar);
            zzisVar.zzj(i, Long.valueOf(zzfhVar.zzb));
            return iZzk;
        }
        if (i4 == 1) {
            zzisVar.zzj(i, Long.valueOf(zzn(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZzh = zzh(bArr, i2, zzfhVar);
            int i5 = zzfhVar.zza;
            if (i5 < 0) {
                throw new zzgz("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i5 > bArr.length - iZzh) {
                throw new zzgz("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i5 == 0) {
                zzisVar.zzj(i, zzfs.zzb);
            } else {
                zzisVar.zzj(i, zzfs.zzj(bArr, iZzh, i5));
            }
            return iZzh + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw new zzgz("Protocol message contained an invalid tag (zero).");
            }
            zzisVar.zzj(i, Integer.valueOf(zzb(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zzis zzisVarZzf = zzis.zzf();
        int i7 = zzfhVar.zze + 1;
        zzfhVar.zze = i7;
        zzo(i7);
        int i8 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iZzh2 = zzh(bArr, i2, zzfhVar);
            int i9 = zzfhVar.zza;
            if (i9 == i6) {
                i8 = i9;
                i2 = iZzh2;
                break;
            }
            i2 = zzg(i9, bArr, iZzh2, i3, zzisVarZzf, zzfhVar);
            i8 = i9;
        }
        zzfhVar.zze--;
        if (i2 > i3 || i8 != i6) {
            throw new zzgz("Failed to parse the message.");
        }
        zzisVar.zzj(i, zzisVarZzf);
        return i2;
    }

    static int zzh(byte[] bArr, int i, zzfh zzfhVar) {
        int i2 = i + 1;
        byte b2 = bArr[i];
        if (b2 < 0) {
            return zzi(b2, bArr, i2, zzfhVar);
        }
        zzfhVar.zza = b2;
        return i2;
    }

    static int zzi(int i, byte[] bArr, int i2, zzfh zzfhVar) {
        byte b2 = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b2 >= 0) {
            zzfhVar.zza = i4 | (b2 << 7);
            return i3;
        }
        int i5 = i4 | ((b2 & 127) << 7);
        int i6 = i2 + 2;
        byte b3 = bArr[i3];
        if (b3 >= 0) {
            zzfhVar.zza = i5 | (b3 << 14);
            return i6;
        }
        int i7 = i5 | ((b3 & 127) << 14);
        int i8 = i2 + 3;
        byte b4 = bArr[i6];
        if (b4 >= 0) {
            zzfhVar.zza = i7 | (b4 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b4 & 127) << 21);
        int i10 = i2 + 4;
        byte b5 = bArr[i8];
        if (b5 >= 0) {
            zzfhVar.zza = i9 | (b5 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b5 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzfhVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzj(int i, byte[] bArr, int i2, int i3, zzgw zzgwVar, zzfh zzfhVar) {
        zzgt zzgtVar = (zzgt) zzgwVar;
        int iZzh = zzh(bArr, i2, zzfhVar);
        zzgtVar.zzg(zzfhVar.zza);
        while (iZzh < i3) {
            int iZzh2 = zzh(bArr, iZzh, zzfhVar);
            if (i != zzfhVar.zza) {
                break;
            }
            iZzh = zzh(bArr, iZzh2, zzfhVar);
            zzgtVar.zzg(zzfhVar.zza);
        }
        return iZzh;
    }

    static int zzk(byte[] bArr, int i, zzfh zzfhVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzfhVar.zzb = j;
            return i2;
        }
        int i3 = i + 2;
        byte b2 = bArr[i2];
        long j2 = (j & 127) | (((long) (b2 & 127)) << 7);
        int i4 = 7;
        while (b2 < 0) {
            int i5 = i3 + 1;
            byte b3 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b3 & 127)) << i4;
            b2 = b3;
            i3 = i5;
        }
        zzfhVar.zzb = j2;
        return i3;
    }

    static int zzl(Object obj, zzif zzifVar, byte[] bArr, int i, int i2, int i3, zzfh zzfhVar) throws IOException {
        int i4 = zzfhVar.zze + 1;
        zzfhVar.zze = i4;
        zzo(i4);
        int iZzc = ((zzhx) zzifVar).zzc(obj, bArr, i, i2, i3, zzfhVar);
        zzfhVar.zze--;
        zzfhVar.zzc = obj;
        return iZzc;
    }

    static int zzm(Object obj, zzif zzifVar, byte[] bArr, int i, int i2, zzfh zzfhVar) throws IOException {
        int iZzi = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZzi = zzi(i3, bArr, iZzi, zzfhVar);
            i3 = zzfhVar.zza;
        }
        int i4 = iZzi;
        if (i3 < 0 || i3 > i2 - i4) {
            throw new zzgz("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i5 = zzfhVar.zze + 1;
        zzfhVar.zze = i5;
        zzo(i5);
        int i6 = i4 + i3;
        zzifVar.zzh(obj, bArr, i4, i6, zzfhVar);
        zzfhVar.zze--;
        zzfhVar.zzc = obj;
        return i6;
    }

    static long zzn(byte[] bArr, int i) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    private static void zzo(int i) throws zzgz {
        if (i >= zzb) {
            throw new zzgz("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
