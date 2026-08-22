package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzis {
    private static final zzis zza = new zzis(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzis() {
        this(0, new int[8], new Object[8], true);
    }

    private zzis(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzis zzc() {
        return zza;
    }

    static zzis zze(zzis zzisVar, zzis zzisVar2) {
        int i = zzisVar.zzb + zzisVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzisVar.zzc, i);
        System.arraycopy(zzisVar2.zzc, 0, iArrCopyOf, zzisVar.zzb, zzisVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzisVar.zzd, i);
        System.arraycopy(zzisVar2.zzd, 0, objArrCopyOf, zzisVar.zzb, zzisVar2.zzb);
        return new zzis(i, iArrCopyOf, objArrCopyOf, true);
    }

    static zzis zzf() {
        return new zzis(0, new int[8], new Object[8], true);
    }

    private final void zzm(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i2 = this.zzb;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzis)) {
            return false;
        }
        zzis zzisVar = (zzis) obj;
        int i = this.zzb;
        if (i == zzisVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzisVar.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzisVar.zzd;
                    int i3 = this.zzb;
                    for (int i4 = 0; i4 < i3; i4++) {
                        if (objArr[i4].equals(objArr2[i4])) {
                        }
                    }
                    return true;
                }
                if (iArr[i2] != iArr2[i2]) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = i + 527;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = ((i2 * 31) + i3) * 31;
        Object[] objArr = this.zzd;
        int i6 = this.zzb;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }

    public final int zza() {
        int iZzz;
        int iZzA;
        int iZzz2;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = this.zzc[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 != 0) {
                if (i6 == 1) {
                    ((Long) this.zzd[i3]).longValue();
                    iZzz2 = zzfz.zzz(i5 << 3) + 8;
                } else if (i6 == 2) {
                    int i7 = i5 << 3;
                    zzfs zzfsVar = (zzfs) this.zzd[i3];
                    int iZzz3 = zzfz.zzz(i7);
                    int iZzd = zzfsVar.zzd();
                    iZzz2 = iZzz3 + zzfz.zzz(iZzd) + iZzd;
                } else if (i6 == 3) {
                    int iZzz4 = zzfz.zzz(i5 << 3);
                    iZzz = iZzz4 + iZzz4;
                    iZzA = ((zzis) this.zzd[i3]).zza();
                } else {
                    if (i6 != 5) {
                        throw new IllegalStateException(new zzgy("Protocol message tag had invalid wire type."));
                    }
                    ((Integer) this.zzd[i3]).intValue();
                    iZzz2 = zzfz.zzz(i5 << 3) + 4;
                }
                i2 += iZzz2;
            } else {
                int i8 = i5 << 3;
                long jLongValue = ((Long) this.zzd[i3]).longValue();
                iZzz = zzfz.zzz(i8);
                iZzA = zzfz.zzA(jLongValue);
            }
            iZzz2 = iZzz + iZzA;
            i2 += iZzz2;
        }
        this.zze = i2;
        return i2;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iZzz = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            int i3 = this.zzc[i2] >>> 3;
            zzfs zzfsVar = (zzfs) this.zzd[i2];
            int iZzz2 = zzfz.zzz(8);
            int iZzz3 = zzfz.zzz(16) + zzfz.zzz(i3);
            int iZzz4 = zzfz.zzz(24);
            int iZzd = zzfsVar.zzd();
            iZzz += iZzz2 + iZzz2 + iZzz3 + iZzz4 + zzfz.zzz(iZzd) + iZzd;
        }
        this.zze = iZzz;
        return iZzz;
    }

    final zzis zzd(zzis zzisVar) {
        if (zzisVar.equals(zza)) {
            return this;
        }
        zzg();
        int i = this.zzb + zzisVar.zzb;
        zzm(i);
        System.arraycopy(zzisVar.zzc, 0, this.zzc, this.zzb, zzisVar.zzb);
        System.arraycopy(zzisVar.zzd, 0, this.zzd, this.zzb, zzisVar.zzb);
        this.zzb = i;
        return this;
    }

    final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    final void zzi(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzhw.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    final void zzj(int i, Object obj) {
        zzg();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    final void zzk(zzje zzjeVar) throws IOException {
        for (int i = 0; i < this.zzb; i++) {
            zzjeVar.zzw(this.zzc[i] >>> 3, this.zzd[i]);
        }
    }

    public final void zzl(zzje zzjeVar) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zzjeVar.zzt(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zzjeVar.zzm(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zzjeVar.zzd(i4, (zzfs) obj);
                } else if (i3 == 3) {
                    zzjeVar.zzF(i4);
                    ((zzis) obj).zzl(zzjeVar);
                    zzjeVar.zzh(i4);
                } else {
                    if (i3 != 5) {
                        throw new RuntimeException(new zzgy("Protocol message tag had invalid wire type."));
                    }
                    zzjeVar.zzk(i4, ((Integer) obj).intValue());
                }
            }
        }
    }
}
