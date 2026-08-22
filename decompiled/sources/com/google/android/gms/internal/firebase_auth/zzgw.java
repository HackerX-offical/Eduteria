package com.google.android.gms.internal.firebase_auth;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzgw extends zzgy {
    private int zza = 0;
    private final int zzb;
    private final /* synthetic */ zzgt zzc;

    zzgw(zzgt zzgtVar) {
        this.zzc = zzgtVar;
        this.zzb = zzgtVar.zza();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza < this.zzb;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhc
    public final byte zza() {
        int i = this.zza;
        if (i >= this.zzb) {
            throw new NoSuchElementException();
        }
        this.zza = i + 1;
        return this.zzc.zzb(i);
    }
}
