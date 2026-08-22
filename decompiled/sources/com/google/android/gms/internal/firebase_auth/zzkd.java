package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzie;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzkd implements zzjn {
    private final zzjp zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    zzkd(zzjp zzjpVar, String str, Object[] objArr) {
        this.zza = zzjpVar;
        this.zzb = str;
        this.zzc = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.zzd = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char cCharAt2 = str.charAt(i3);
            if (cCharAt2 < 55296) {
                this.zzd = i | (cCharAt2 << i2);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            }
        }
    }

    final String zzd() {
        return this.zzb;
    }

    final Object[] zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzjn
    public final zzjp zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzjn
    public final int zza() {
        return (this.zzd & 1) == 1 ? zzie.zze.zzh : zzie.zze.zzi;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzjn
    public final boolean zzb() {
        return (this.zzd & 2) == 2;
    }
}
