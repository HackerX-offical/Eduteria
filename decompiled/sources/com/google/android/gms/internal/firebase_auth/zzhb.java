package com.google.android.gms.internal.firebase_auth;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzhb {
    private final zzho zza;
    private final byte[] zzb;

    private zzhb(int i) {
        byte[] bArr = new byte[i];
        this.zzb = bArr;
        this.zza = zzho.zza(bArr);
    }

    public final zzgt zza() {
        this.zza.zzb();
        return new zzhd(this.zzb);
    }

    public final zzho zzb() {
        return this.zza;
    }

    /* synthetic */ zzhb(int i, zzgw zzgwVar) {
        this(i);
    }
}
