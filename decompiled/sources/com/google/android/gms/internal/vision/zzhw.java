package com.google.android.gms.internal.vision;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
final class zzhw extends zzid {
    private final int zzc;
    private final int zzd;

    zzhw(byte[] bArr, int i, int i2) {
        super(bArr);
        zzb(i, i + i2, bArr.length);
        this.zzc = i;
        this.zzd = i2;
    }

    @Override // com.google.android.gms.internal.vision.zzid, com.google.android.gms.internal.vision.zzht
    public final byte zza(int i) {
        int iZza = zza();
        if (((iZza - (i + 1)) | i) >= 0) {
            return this.zzb[this.zzc + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(new StringBuilder(22).append("Index < 0: ").append(i).toString());
        }
        throw new ArrayIndexOutOfBoundsException(new StringBuilder(40).append("Index > length: ").append(i).append(", ").append(iZza).toString());
    }

    @Override // com.google.android.gms.internal.vision.zzid, com.google.android.gms.internal.vision.zzht
    final byte zzb(int i) {
        return this.zzb[this.zzc + i];
    }

    @Override // com.google.android.gms.internal.vision.zzid, com.google.android.gms.internal.vision.zzht
    public final int zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.vision.zzid
    protected final int zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.vision.zzid, com.google.android.gms.internal.vision.zzht
    protected final void zza(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzb, zze(), bArr, 0, i3);
    }
}
