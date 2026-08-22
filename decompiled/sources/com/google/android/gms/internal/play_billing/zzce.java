package com.google.android.gms.internal.play_billing;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzce extends zzcd implements NavigableSet, zzdc {
    final transient Comparator zza;

    @CheckForNull
    transient zzce zzb;

    zzce(Comparator comparator) {
        this.zza = comparator;
    }

    static zzcz zzq(Comparator comparator) {
        if (zzck.zza.equals(comparator)) {
            return zzcz.zzc;
        }
        int i = zzbw.zzd;
        return new zzcz(zzcs.zza, comparator);
    }

    @Deprecated
    public final void addFirst(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void addLast(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.SortedSet, com.google.android.gms.internal.play_billing.zzdc
    public final Comparator comparator() {
        return this.zza;
    }

    @Override // java.util.NavigableSet
    public final /* bridge */ /* synthetic */ NavigableSet descendingSet() {
        zzce zzceVar = this.zzb;
        if (zzceVar != null) {
            return zzceVar;
        }
        zzce zzceVarZzl = zzl();
        this.zzb = zzceVarZzl;
        zzceVarZzl.zzb = this;
        return zzceVarZzl;
    }

    @Override // java.util.SortedSet
    public Object first() {
        return iterator().next();
    }

    public final Object getFirst() {
        return first();
    }

    public final Object getLast() {
        return last();
    }

    @Override // java.util.SortedSet
    public Object last() {
        return descendingIterator().next();
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    @Deprecated
    public final Object pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    @Deprecated
    public final Object pollLast() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Object removeFirst() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Object removeLast() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public final /* bridge */ /* synthetic */ SortedSet subSet(Object obj, Object obj2) {
        return subSet(obj, true, obj2, false);
    }

    @Override // com.google.android.gms.internal.play_billing.zzcd, com.google.android.gms.internal.play_billing.zzbr, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zze */
    public abstract zzde iterator();

    abstract zzce zzl();

    abstract zzce zzm(Object obj, boolean z);

    abstract zzce zzo(Object obj, boolean z, Object obj2, boolean z2);

    abstract zzce zzp(Object obj, boolean z);

    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: zzr */
    public abstract zzde descendingIterator();

    @Override // java.util.NavigableSet, java.util.SortedSet
    public final /* synthetic */ SortedSet headSet(Object obj) {
        obj.getClass();
        return zzm(obj, false);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public final /* synthetic */ SortedSet tailSet(Object obj) {
        obj.getClass();
        return zzp(obj, true);
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public Object ceiling(Object obj) {
        obj.getClass();
        return zzcf.zza(zzp(obj, true), null);
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public Object floor(Object obj) {
        obj.getClass();
        return zzci.zza(zzm(obj, true).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public Object higher(Object obj) {
        obj.getClass();
        return zzcf.zza(zzp(obj, false), null);
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public Object lower(Object obj) {
        obj.getClass();
        return zzci.zza(zzm(obj, false).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet
    public final /* synthetic */ NavigableSet headSet(Object obj, boolean z) {
        obj.getClass();
        return zzm(obj, z);
    }

    @Override // java.util.NavigableSet
    public final /* synthetic */ NavigableSet tailSet(Object obj, boolean z) {
        obj.getClass();
        return zzp(obj, z);
    }

    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: zzn, reason: merged with bridge method [inline-methods] */
    public final zzce subSet(Object obj, boolean z, Object obj2, boolean z2) {
        obj.getClass();
        obj2.getClass();
        if (this.zza.compare(obj, obj2) <= 0) {
            return zzo(obj, z, obj2, z2);
        }
        throw new IllegalArgumentException();
    }
}
