package com.google.android.gms.internal.firebase_auth;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzbt extends zzbg<Object> {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    zzbt(Object[] objArr, int i, int i2) {
        this.zza = objArr;
        this.zzb = i;
        this.zzc = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzav.zza(i, this.zzc);
        return this.zza[(i * 2) + this.zzb];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }
}
