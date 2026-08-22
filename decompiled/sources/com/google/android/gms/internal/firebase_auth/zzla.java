package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzie;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzla {
    private static final zzla zza = new zzla(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    public static zzla zza() {
        return zza;
    }

    static zzla zzb() {
        return new zzla();
    }

    static zzla zza(zzla zzlaVar, zzla zzlaVar2) {
        int i = zzlaVar.zzb + zzlaVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzlaVar.zzc, i);
        System.arraycopy(zzlaVar2.zzc, 0, iArrCopyOf, zzlaVar.zzb, zzlaVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzlaVar.zzd, i);
        System.arraycopy(zzlaVar2.zzd, 0, objArrCopyOf, zzlaVar.zzb, zzlaVar2.zzb);
        return new zzla(i, iArrCopyOf, objArrCopyOf, true);
    }

    private zzla() {
        this(0, new int[8], new Object[8], true);
    }

    private zzla(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public final void zzc() {
        this.zzf = false;
    }

    final void zza(zzlu zzluVar) throws IOException {
        if (zzluVar.zza() == zzie.zze.zzk) {
            for (int i = this.zzb - 1; i >= 0; i--) {
                zzluVar.zza(this.zzc[i] >>> 3, this.zzd[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzluVar.zza(this.zzc[i2] >>> 3, this.zzd[i2]);
        }
    }

    public final void zzb(zzlu zzluVar) throws IOException {
        if (this.zzb == 0) {
            return;
        }
        if (zzluVar.zza() == zzie.zze.zzj) {
            for (int i = 0; i < this.zzb; i++) {
                zza(this.zzc[i], this.zzd[i], zzluVar);
            }
            return;
        }
        for (int i2 = this.zzb - 1; i2 >= 0; i2--) {
            zza(this.zzc[i2], this.zzd[i2], zzluVar);
        }
    }

    private static void zza(int i, Object obj, zzlu zzluVar) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzluVar.zza(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 1) {
            zzluVar.zzd(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 2) {
            zzluVar.zza(i2, (zzgt) obj);
            return;
        }
        if (i3 != 3) {
            if (i3 == 5) {
                zzluVar.zzd(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzip.zzf());
        }
        if (zzluVar.zza() == zzie.zze.zzj) {
            zzluVar.zza(i2);
            ((zzla) obj).zzb(zzluVar);
            zzluVar.zzb(i2);
        } else {
            zzluVar.zzb(i2);
            ((zzla) obj).zzb(zzluVar);
            zzluVar.zza(i2);
        }
    }

    public final int zzd() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iZzd = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            iZzd += zzho.zzd(this.zzc[i2] >>> 3, (zzgt) this.zzd[i2]);
        }
        this.zze = iZzd;
        return iZzd;
    }

    public final int zze() {
        int iZze;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = this.zzc[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 == 0) {
                iZze = zzho.zze(i5, ((Long) this.zzd[i3]).longValue());
            } else if (i6 == 1) {
                iZze = zzho.zzg(i5, ((Long) this.zzd[i3]).longValue());
            } else if (i6 == 2) {
                iZze = zzho.zzc(i5, (zzgt) this.zzd[i3]);
            } else if (i6 == 3) {
                iZze = (zzho.zze(i5) << 1) + ((zzla) this.zzd[i3]).zze();
            } else if (i6 == 5) {
                iZze = zzho.zzi(i5, ((Integer) this.zzd[i3]).intValue());
            } else {
                throw new IllegalStateException(zzip.zzf());
            }
            i2 += iZze;
        }
        this.zze = i2;
        return i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzla)) {
            return false;
        }
        zzla zzlaVar = (zzla) obj;
        int i = this.zzb;
        if (i == zzlaVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzlaVar.zzc;
            int i2 = 0;
            while (true) {
                if (i2 < i) {
                    if (iArr[i2] != iArr2[i2]) {
                        break;
                    }
                    i2++;
                } else {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzlaVar.zzd;
                    int i3 = this.zzb;
                    for (int i4 = 0; i4 < i3; i4++) {
                        if (objArr[i4].equals(objArr2[i4])) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = (i2 + i3) * 31;
        Object[] objArr = this.zzd;
        int i6 = this.zzb;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }

    final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzjq.zza(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    final void zza(int i, Object obj) {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
        int i2 = this.zzb;
        int[] iArr = this.zzc;
        if (i2 == iArr.length) {
            int i3 = i2 + (i2 < 4 ? 8 : i2 >> 1);
            this.zzc = Arrays.copyOf(iArr, i3);
            this.zzd = Arrays.copyOf(this.zzd, i3);
        }
        int[] iArr2 = this.zzc;
        int i4 = this.zzb;
        iArr2[i4] = i;
        this.zzd[i4] = obj;
        this.zzb = i4 + 1;
    }
}
