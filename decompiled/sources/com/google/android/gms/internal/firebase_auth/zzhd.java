package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
class zzhd extends zzhe {
    protected final byte[] zzb;

    zzhd(byte[] bArr) {
        bArr.getClass();
        this.zzb = bArr;
    }

    protected int zze() {
        return 0;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgt
    public byte zza(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgt
    byte zzb(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgt
    public int zza() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgt
    public final zzgt zza(int i, int i2) {
        int iZzb = zzb(0, i2, zza());
        if (iZzb == 0) {
            return zzgt.zza;
        }
        return new zzha(this.zzb, zze(), iZzb);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgt
    final void zza(zzgu zzguVar) throws IOException {
        zzguVar.zza(this.zzb, zze(), zza());
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgt
    protected final String zza(Charset charset) {
        return new String(this.zzb, zze(), zza(), charset);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgt
    public final boolean zzc() {
        int iZze = zze();
        return zzlg.zza(this.zzb, iZze, zza() + iZze);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgt
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgt) || zza() != ((zzgt) obj).zza()) {
            return false;
        }
        if (zza() == 0) {
            return true;
        }
        if (obj instanceof zzhd) {
            zzhd zzhdVar = (zzhd) obj;
            int iZzd = zzd();
            int iZzd2 = zzhdVar.zzd();
            if (iZzd == 0 || iZzd2 == 0 || iZzd == iZzd2) {
                return zza(zzhdVar, 0, zza());
            }
            return false;
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhe
    final boolean zza(zzgt zzgtVar, int i, int i2) {
        if (i2 > zzgtVar.zza()) {
            throw new IllegalArgumentException(new StringBuilder(40).append("Length too large: ").append(i2).append(zza()).toString());
        }
        if (i2 > zzgtVar.zza()) {
            throw new IllegalArgumentException(new StringBuilder(59).append("Ran off end of other: 0, ").append(i2).append(", ").append(zzgtVar.zza()).toString());
        }
        if (zzgtVar instanceof zzhd) {
            zzhd zzhdVar = (zzhd) zzgtVar;
            byte[] bArr = this.zzb;
            byte[] bArr2 = zzhdVar.zzb;
            int iZze = zze() + i2;
            int iZze2 = zze();
            int iZze3 = zzhdVar.zze();
            while (iZze2 < iZze) {
                if (bArr[iZze2] != bArr2[iZze3]) {
                    return false;
                }
                iZze2++;
                iZze3++;
            }
            return true;
        }
        return zzgtVar.zza(0, i2).equals(zza(0, i2));
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgt
    protected final int zza(int i, int i2, int i3) {
        return zzig.zza(i, this.zzb, zze(), i3);
    }
}
