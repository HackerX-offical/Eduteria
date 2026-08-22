package com.google.android.gms.internal.play_billing;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzcz extends zzce {
    static final zzcz zzc;
    final transient zzbw zzd;

    static {
        int i = zzbw.zzd;
        zzc = new zzcz(zzcs.zza, zzck.zza);
    }

    zzcz(zzbw zzbwVar, Comparator comparator) {
        super(comparator);
        this.zzd = zzbwVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzce, java.util.NavigableSet
    @CheckForNull
    public final Object ceiling(Object obj) {
        zzbw zzbwVar = this.zzd;
        int iZzt = zzt(obj, true);
        if (iZzt == zzbwVar.size()) {
            return null;
        }
        return this.zzd.get(iZzt);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbr, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        if (obj != null) {
            try {
                if (Collections.binarySearch(this.zzd, obj, this.zza) >= 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        if (collection instanceof zzcj) {
            collection = ((zzcj) collection).zza();
        }
        if (!zzdd.zza(((zzce) this).zza, collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        zzdf zzdfVarListIterator = this.zzd.listIterator(0);
        Iterator it = collection.iterator();
        if (!zzdfVarListIterator.hasNext()) {
            return false;
        }
        Object next = it.next();
        E next2 = zzdfVarListIterator.next();
        while (true) {
            try {
                int iCompare = ((zzce) this).zza.compare(next2, next);
                if (iCompare >= 0) {
                    if (iCompare != 0) {
                        break;
                    }
                    if (!it.hasNext()) {
                        return true;
                    }
                    next = it.next();
                } else {
                    if (!zzdfVarListIterator.hasNext()) {
                        return false;
                    }
                    next2 = zzdfVarListIterator.next();
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.play_billing.zzcd, java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (this.zzd.size() != set.size()) {
            return false;
        }
        if (isEmpty()) {
            return true;
        }
        if (!zzdd.zza(this.zza, set)) {
            return containsAll(set);
        }
        Iterator it = set.iterator();
        try {
            zzdf zzdfVarListIterator = this.zzd.listIterator(0);
            while (zzdfVarListIterator.hasNext()) {
                E next = zzdfVarListIterator.next();
                Object next2 = it.next();
                if (next2 == null || ((zzce) this).zza.compare(next, next2) != 0) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NoSuchElementException unused) {
            return false;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzce, java.util.SortedSet
    public final Object first() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.zzd.get(0);
    }

    @Override // com.google.android.gms.internal.play_billing.zzce, java.util.NavigableSet
    @CheckForNull
    public final Object floor(Object obj) {
        int iZzs = zzs(obj, true) - 1;
        if (iZzs == -1) {
            return null;
        }
        return this.zzd.get(iZzs);
    }

    @Override // com.google.android.gms.internal.play_billing.zzce, java.util.NavigableSet
    @CheckForNull
    public final Object higher(Object obj) {
        zzbw zzbwVar = this.zzd;
        int iZzt = zzt(obj, false);
        if (iZzt == zzbwVar.size()) {
            return null;
        }
        return this.zzd.get(iZzt);
    }

    @Override // com.google.android.gms.internal.play_billing.zzce, com.google.android.gms.internal.play_billing.zzcd, com.google.android.gms.internal.play_billing.zzbr, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.zzd.listIterator(0);
    }

    @Override // com.google.android.gms.internal.play_billing.zzce, java.util.SortedSet
    public final Object last() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.zzd.get(r0.size() - 1);
    }

    @Override // com.google.android.gms.internal.play_billing.zzce, java.util.NavigableSet
    @CheckForNull
    public final Object lower(Object obj) {
        int iZzs = zzs(obj, false) - 1;
        if (iZzs == -1) {
            return null;
        }
        return this.zzd.get(iZzs);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzd.size();
    }

    @Override // com.google.android.gms.internal.play_billing.zzbr
    final int zza(Object[] objArr, int i) {
        return this.zzd.zza(objArr, 0);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbr
    final int zzb() {
        return this.zzd.zzb();
    }

    @Override // com.google.android.gms.internal.play_billing.zzbr
    final int zzc() {
        return this.zzd.zzc();
    }

    @Override // com.google.android.gms.internal.play_billing.zzcd, com.google.android.gms.internal.play_billing.zzbr
    public final zzbw zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.play_billing.zzce, com.google.android.gms.internal.play_billing.zzcd, com.google.android.gms.internal.play_billing.zzbr
    /* JADX INFO: renamed from: zze */
    public final zzde iterator() {
        return this.zzd.listIterator(0);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbr
    final boolean zzf() {
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbr
    @CheckForNull
    final Object[] zzg() {
        return this.zzd.zzg();
    }

    @Override // com.google.android.gms.internal.play_billing.zzce
    final zzce zzl() {
        Comparator comparatorReverseOrder = Collections.reverseOrder(this.zza);
        return isEmpty() ? zzq(comparatorReverseOrder) : new zzcz(this.zzd.zzh(), comparatorReverseOrder);
    }

    @Override // com.google.android.gms.internal.play_billing.zzce
    final zzce zzm(Object obj, boolean z) {
        return zzu(0, zzs(obj, z));
    }

    @Override // com.google.android.gms.internal.play_billing.zzce
    final zzce zzo(Object obj, boolean z, Object obj2, boolean z2) {
        return zzp(obj, z).zzm(obj2, z2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzce
    final zzce zzp(Object obj, boolean z) {
        return zzu(zzt(obj, z), this.zzd.size());
    }

    @Override // com.google.android.gms.internal.play_billing.zzce, java.util.NavigableSet
    /* JADX INFO: renamed from: zzr, reason: merged with bridge method [inline-methods] */
    public final zzde descendingIterator() {
        return this.zzd.zzh().listIterator(0);
    }

    final zzcz zzu(int i, int i2) {
        if (i == 0) {
            if (i2 == this.zzd.size()) {
                return this;
            }
            i = 0;
        }
        if (i >= i2) {
            return zzq(this.zza);
        }
        zzbw zzbwVar = this.zzd;
        return new zzcz(zzbwVar.subList(i, i2), this.zza);
    }

    final int zzs(Object obj, boolean z) {
        obj.getClass();
        int iBinarySearch = Collections.binarySearch(this.zzd, obj, ((zzce) this).zza);
        return iBinarySearch >= 0 ? z ? iBinarySearch + 1 : iBinarySearch : ~iBinarySearch;
    }

    final int zzt(Object obj, boolean z) {
        obj.getClass();
        int iBinarySearch = Collections.binarySearch(this.zzd, obj, ((zzce) this).zza);
        return iBinarySearch >= 0 ? z ? iBinarySearch : iBinarySearch + 1 : ~iBinarySearch;
    }
}
