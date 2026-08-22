package com.google.android.gms.internal.play_billing;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.stream.Collector;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzbw extends zzbr implements List, RandomAccess {
    private static final zzdf zza = new zzbt(zzcs.zza, 0);
    public static final /* synthetic */ int zzd = 0;

    zzbw() {
    }

    static zzbw zzj(Object[] objArr, int i) {
        return i == 0 ? zzcs.zza : new zzcs(objArr, i);
    }

    public static zzbw zzk(Collection collection) {
        if (!(collection instanceof zzbr)) {
            Object[] array = collection.toArray();
            int length = array.length;
            zzcl.zzb(array, length);
            return zzj(array, length);
        }
        zzbw zzbwVarZzd = ((zzbr) collection).zzd();
        if (!zzbwVarZzd.zzf()) {
            return zzbwVarZzd;
        }
        Object[] array2 = zzbwVarZzd.toArray();
        return zzj(array2, array2.length);
    }

    public static zzbw zzl() {
        return zzcs.zza;
    }

    public static zzbw zzm(Object obj) {
        Object[] objArr = {obj};
        zzcl.zzb(objArr, 1);
        return zzj(objArr, 1);
    }

    public static Collector zzo() {
        return zzbd.zza();
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.play_billing.zzbr, java.util.AbstractCollection, java.util.Collection
    public boolean contains(@CheckForNull Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        if (list instanceof RandomAccess) {
            for (int i = 0; i < size; i++) {
                if (!zzal.zza(get(i), list.get(i))) {
                    return false;
                }
            }
            return true;
        }
        Iterator it = iterator();
        Iterator it2 = list.iterator();
        while (it.hasNext()) {
            if (!it2.hasNext() || !zzal.zza(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int iHashCode = 1;
        for (int i = 0; i < size; i++) {
            iHashCode = (iHashCode * 31) + get(i).hashCode();
        }
        return iHashCode;
    }

    public int indexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbr, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    public int lastIndexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    @Deprecated
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.play_billing.zzbr
    int zza(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i2] = get(i2);
        }
        return size;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbr
    @Deprecated
    public final zzbw zzd() {
        return this;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbr
    /* JADX INFO: renamed from: zze */
    public final zzde iterator() {
        return listIterator(0);
    }

    public zzbw zzh() {
        return size() <= 1 ? this : new zzbu(this);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public zzbw subList(int i, int i2) {
        zzam.zze(i, i2, size());
        int i3 = i2 - i;
        return i3 == size() ? this : i3 == 0 ? zzcs.zza : new zzbv(this, i, i3);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: zzn, reason: merged with bridge method [inline-methods] */
    public final zzdf listIterator(int i) {
        zzam.zzb(i, size(), FirebaseAnalytics.Param.INDEX);
        return isEmpty() ? zza : new zzbt(this, i);
    }
}
