package com.google.android.gms.internal.firebase_auth;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzbm<E> extends zzbg<E> {
    static final zzbg<Object> zza = new zzbm(new Object[0], 0);
    private final transient Object[] zzb;
    private final transient int zzc;

    zzbm(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzbh
    final int zze() {
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzbh
    final Object[] zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzbh
    final int zzf() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzbg, com.google.android.gms.internal.firebase_auth.zzbh
    final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, i, this.zzc);
        return i + this.zzc;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzav.zza(i, this.zzc);
        return (E) this.zzb[i];
    }
}
