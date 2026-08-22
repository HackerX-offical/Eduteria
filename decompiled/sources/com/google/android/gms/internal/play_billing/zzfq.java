package com.google.android.gms.internal.play_billing;

import java.io.IOException;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
class zzfq extends zzfp {
    protected final byte[] zza;

    zzfq(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfs
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfs) || zzd() != ((zzfs) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzfq)) {
            return obj.equals(this);
        }
        zzfq zzfqVar = (zzfq) obj;
        int iZzi = zzi();
        int iZzi2 = zzfqVar.zzi();
        if (iZzi != 0 && iZzi2 != 0 && iZzi != iZzi2) {
            return false;
        }
        int iZzd = zzd();
        if (iZzd > zzfqVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + iZzd + zzd());
        }
        if (iZzd > zzfqVar.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + iZzd + ", " + zzfqVar.zzd());
        }
        if (!(zzfqVar instanceof zzfq)) {
            return zzfqVar.zzf(0, iZzd).equals(zzf(0, iZzd));
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzfqVar.zza;
        zzfqVar.zzc();
        int i = 0;
        int i2 = 0;
        while (i < iZzd) {
            if (bArr[i] != bArr2[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfs
    public byte zza(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.play_billing.zzfs
    byte zzb(int i) {
        return this.zza[i];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfs
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfs
    protected final int zze(int i, int i2, int i3) {
        return zzgx.zzb(i, this.zza, 0, i3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfs
    public final zzfs zzf(int i, int i2) {
        int iZzh = zzh(0, i2, zzd());
        return iZzh == 0 ? zzfs.zzb : new zzfn(this.zza, 0, iZzh);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfs
    final void zzg(zzfk zzfkVar) throws IOException {
        ((zzfw) zzfkVar).zzc(this.zza, 0, zzd());
    }
}
