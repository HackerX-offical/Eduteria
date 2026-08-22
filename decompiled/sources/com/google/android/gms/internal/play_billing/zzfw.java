package com.google.android.gms.internal.play_billing;

import androidx.work.WorkInfo;
import java.io.IOException;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzfw extends zzfz {
    private final byte[] zzb;
    private final int zzc;
    private int zzd;

    zzfw(byte[] bArr, int i, int i2) {
        super(null);
        int length = bArr.length;
        if (((length - i2) | i2) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i2)));
        }
        this.zzb = bArr;
        this.zzd = 0;
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfz
    public final int zza() {
        return this.zzc - this.zzd;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfz
    public final void zzd(int i, boolean z) throws IOException {
        zzt(i << 3);
        zzb(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfz
    public final void zze(int i, zzfs zzfsVar) throws IOException {
        zzt((i << 3) | 2);
        zzt(zzfsVar.zzd());
        zzfsVar.zzg(this);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfz
    public final void zzf(int i, int i2) throws IOException {
        zzt((i << 3) | 5);
        zzg(i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfz
    public final void zzg(int i) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i2 = this.zzd;
            int i3 = i2 + 1;
            this.zzd = i3;
            bArr[i2] = (byte) (i & 255);
            int i4 = i2 + 2;
            this.zzd = i4;
            bArr[i3] = (byte) ((i >> 8) & 255);
            int i5 = i2 + 3;
            this.zzd = i5;
            bArr[i4] = (byte) ((i >> 16) & 255);
            this.zzd = i2 + 4;
            bArr[i5] = (byte) ((i >> 24) & 255);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzfx(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e2);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfz
    public final void zzh(int i, long j) throws IOException {
        zzt((i << 3) | 1);
        zzi(j);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfz
    public final void zzi(long j) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i = this.zzd;
            int i2 = i + 1;
            this.zzd = i2;
            bArr[i] = (byte) (((int) j) & 255);
            int i3 = i + 2;
            this.zzd = i3;
            bArr[i2] = (byte) (((int) (j >> 8)) & 255);
            int i4 = i + 3;
            this.zzd = i4;
            bArr[i3] = (byte) (((int) (j >> 16)) & 255);
            int i5 = i + 4;
            this.zzd = i5;
            bArr[i4] = (byte) (((int) (j >> 24)) & 255);
            int i6 = i + 5;
            this.zzd = i6;
            bArr[i5] = (byte) (((int) (j >> 32)) & 255);
            int i7 = i + 6;
            this.zzd = i7;
            bArr[i6] = (byte) (((int) (j >> 40)) & 255);
            int i8 = i + 7;
            this.zzd = i8;
            bArr[i7] = (byte) (((int) (j >> 48)) & 255);
            this.zzd = i + 8;
            bArr[i8] = (byte) (((int) (j >> 56)) & 255);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzfx(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e2);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfz
    public final void zzj(int i, int i2) throws IOException {
        zzt(i << 3);
        zzk(i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfz
    public final void zzk(int i) throws IOException {
        if (i >= 0) {
            zzt(i);
        } else {
            zzv(i);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfz
    public final void zzl(byte[] bArr, int i, int i2) throws IOException {
        zzc(bArr, 0, i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfz
    final void zzm(int i, zzhu zzhuVar, zzif zzifVar) throws IOException {
        zzt((i << 3) | 2);
        zzt(((zzfd) zzhuVar).zze(zzifVar));
        zzifVar.zzi(zzhuVar, this.zza);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfz
    public final void zzn(int i, zzhu zzhuVar) throws IOException {
        zzt(11);
        zzs(2, i);
        zzt(26);
        zzt(zzhuVar.zzk());
        zzhuVar.zzJ(this);
        zzt(12);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfz
    public final void zzo(int i, zzfs zzfsVar) throws IOException {
        zzt(11);
        zzs(2, i);
        zze(3, zzfsVar);
        zzt(12);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfz
    public final void zzp(int i, String str) throws IOException {
        zzt((i << 3) | 2);
        zzq(str);
    }

    public final void zzq(String str) throws IOException {
        int i = this.zzd;
        try {
            int iZzz = zzz(str.length() * 3);
            int iZzz2 = zzz(str.length());
            if (iZzz2 != iZzz) {
                zzt(zzjb.zzc(str));
                byte[] bArr = this.zzb;
                int i2 = this.zzd;
                this.zzd = zzjb.zzb(str, bArr, i2, this.zzc - i2);
                return;
            }
            int i3 = i + iZzz2;
            this.zzd = i3;
            int iZzb = zzjb.zzb(str, this.zzb, i3, this.zzc - i3);
            this.zzd = i;
            zzt((iZzb - i) - iZzz2);
            this.zzd = iZzb;
        } catch (zzja e2) {
            this.zzd = i;
            zzC(str, e2);
        } catch (IndexOutOfBoundsException e3) {
            throw new zzfx(e3);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfz
    public final void zzr(int i, int i2) throws IOException {
        zzt((i << 3) | i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfz
    public final void zzs(int i, int i2) throws IOException {
        zzt(i << 3);
        zzt(i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfz
    public final void zzu(int i, long j) throws IOException {
        zzt(i << 3);
        zzv(j);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfz
    public final void zzb(byte b2) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i = this.zzd;
            this.zzd = i + 1;
            bArr[i] = b2;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzfx(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e2);
        }
    }

    public final void zzc(byte[] bArr, int i, int i2) throws IOException {
        try {
            System.arraycopy(bArr, 0, this.zzb, this.zzd, i2);
            this.zzd += i2;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzfx(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), Integer.valueOf(i2)), e2);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfz
    public final void zzt(int i) throws IOException {
        while ((i & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT) != 0) {
            try {
                byte[] bArr = this.zzb;
                int i2 = this.zzd;
                this.zzd = i2 + 1;
                bArr[i2] = (byte) ((i | 128) & 255);
                i >>>= 7;
            } catch (IndexOutOfBoundsException e2) {
                throw new zzfx(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e2);
            }
        }
        byte[] bArr2 = this.zzb;
        int i3 = this.zzd;
        this.zzd = i3 + 1;
        bArr2[i3] = (byte) i;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfz
    public final void zzv(long j) throws IOException {
        if (!zzfz.zzc || this.zzc - this.zzd < 10) {
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr = this.zzb;
                    int i = this.zzd;
                    this.zzd = i + 1;
                    bArr[i] = (byte) ((((int) j) | 128) & 255);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zzfx(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e2);
                }
            }
            byte[] bArr2 = this.zzb;
            int i2 = this.zzd;
            this.zzd = i2 + 1;
            bArr2[i2] = (byte) j;
            return;
        }
        while (true) {
            int i3 = (int) j;
            if ((j & (-128)) == 0) {
                byte[] bArr3 = this.zzb;
                int i4 = this.zzd;
                this.zzd = i4 + 1;
                zziy.zzn(bArr3, i4, (byte) i3);
                return;
            }
            byte[] bArr4 = this.zzb;
            int i5 = this.zzd;
            this.zzd = i5 + 1;
            zziy.zzn(bArr4, i5, (byte) ((i3 | 128) & 255));
            j >>>= 7;
        }
    }
}
