package com.google.android.gms.internal.vision;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
final class zzex<E> extends zzej<E> {
    private final transient E zza;
    private transient int zzb;

    zzex(E e2) {
        this.zza = (E) zzde.zza(e2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    final boolean zzf() {
        return false;
    }

    zzex(E e2, int i) {
        this.zza = e2;
        this.zzb = i;
    }

    @Override // com.google.android.gms.internal.vision.zzeb, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zza.equals(obj);
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    /* JADX INFO: renamed from: zza */
    public final zzfa<E> iterator() {
        return new zzeo(this.zza);
    }

    @Override // com.google.android.gms.internal.vision.zzej
    final zzee<E> zzh() {
        return zzee.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    final int zza(Object[] objArr, int i) {
        objArr[i] = this.zza;
        return i + 1;
    }

    @Override // com.google.android.gms.internal.vision.zzej, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i = this.zzb;
        if (i != 0) {
            return i;
        }
        int iHashCode = this.zza.hashCode();
        this.zzb = iHashCode;
        return iHashCode;
    }

    @Override // com.google.android.gms.internal.vision.zzej
    final boolean zzg() {
        return this.zzb != 0;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        String string = this.zza.toString();
        return new StringBuilder(String.valueOf(string).length() + 2).append('[').append(string).append(']').toString();
    }

    @Override // com.google.android.gms.internal.vision.zzej, com.google.android.gms.internal.vision.zzeb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
