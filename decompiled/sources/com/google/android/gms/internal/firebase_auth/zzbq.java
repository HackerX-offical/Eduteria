package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzbq<K> extends zzbn<K> {
    private final transient zzbl<K, ?> zza;
    private final transient zzbg<K> zzb;

    zzbq(zzbl<K, ?> zzblVar, zzbg<K> zzbgVar) {
        this.zza = zzblVar;
        this.zzb = zzbgVar;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzbh
    /* JADX INFO: renamed from: zzb */
    public final zzbv<K> iterator() {
        return (zzbv) zzc().iterator();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzbh
    final int zza(Object[] objArr, int i) {
        return zzc().zza(objArr, i);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzbn, com.google.android.gms.internal.firebase_auth.zzbh
    public final zzbg<K> zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzbh, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(@NullableDecl Object obj) {
        return this.zza.get(obj) != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzbn, com.google.android.gms.internal.firebase_auth.zzbh, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
