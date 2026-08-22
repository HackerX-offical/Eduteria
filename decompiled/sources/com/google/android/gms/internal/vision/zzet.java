package com.google.android.gms.internal.vision;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
final class zzet<K> extends zzej<K> {
    private final transient zzef<K, ?> zza;
    private final transient zzee<K> zzb;

    zzet(zzef<K, ?> zzefVar, zzee<K> zzeeVar) {
        this.zza = zzefVar;
        this.zzb = zzeeVar;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    final boolean zzf() {
        return true;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    /* JADX INFO: renamed from: zza */
    public final zzfa<K> iterator() {
        return (zzfa) zze().iterator();
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    final int zza(Object[] objArr, int i) {
        return zze().zza(objArr, i);
    }

    @Override // com.google.android.gms.internal.vision.zzej, com.google.android.gms.internal.vision.zzeb
    public final zzee<K> zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.vision.zzeb, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@NullableDecl Object obj) {
        return this.zza.get(obj) != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.vision.zzej, com.google.android.gms.internal.vision.zzeb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
