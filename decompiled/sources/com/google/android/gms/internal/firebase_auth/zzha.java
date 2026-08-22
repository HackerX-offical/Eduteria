package com.google.android.gms.internal.firebase_auth;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzha extends zzhd {
    private final int zzc;
    private final int zzd;

    zzha(byte[] bArr, int i, int i2) {
        super(bArr);
        zzb(i, i + i2, bArr.length);
        this.zzc = i;
        this.zzd = i2;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhd, com.google.android.gms.internal.firebase_auth.zzgt
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

    @Override // com.google.android.gms.internal.firebase_auth.zzhd, com.google.android.gms.internal.firebase_auth.zzgt
    final byte zzb(int i) {
        return this.zzb[this.zzc + i];
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhd, com.google.android.gms.internal.firebase_auth.zzgt
    public final int zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhd
    protected final int zze() {
        return this.zzc;
    }
}
