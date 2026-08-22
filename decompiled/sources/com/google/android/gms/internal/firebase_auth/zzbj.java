package com.google.android.gms.internal.firebase_auth;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzbj<E> extends zzbc<E> {
    private final zzbg<E> zza;

    zzbj(zzbg<E> zzbgVar, int i) {
        super(zzbgVar.size(), i);
        this.zza = zzbgVar;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzbc
    protected final E zza(int i) {
        return this.zza.get(i);
    }
}
