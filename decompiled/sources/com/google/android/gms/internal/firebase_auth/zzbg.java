package com.google.android.gms.internal.firebase_auth;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzbg<E> extends zzbh<E> implements List<E>, RandomAccess {
    private static final zzbu<Object> zza = new zzbj(zzbm.zza, 0);

    public static <E> zzbg<E> zza() {
        return (zzbg<E>) zzbm.zza;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzbh
    public final zzbg<E> zzc() {
        return this;
    }

    public static <E> zzbg<E> zza(E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9) {
        Object[] objArr = {e2, e3, e4, e5, e6, e7, e8, e9};
        for (int i = 0; i < 8; i++) {
            if (objArr[i] == null) {
                throw new NullPointerException(new StringBuilder(20).append("at index ").append(i).toString());
            }
        }
        return new zzbm(objArr, 8);
    }

    static <E> zzbg<E> zza(Object[] objArr) {
        int length = objArr.length;
        if (length == 0) {
            return (zzbg<E>) zzbm.zza;
        }
        return new zzbm(objArr, length);
    }

    zzbg() {
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzbh
    /* JADX INFO: renamed from: zzb */
    public final zzbv<E> iterator() {
        return (zzbu) listIterator();
    }

    @Override // java.util.List
    public int indexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        if (this instanceof RandomAccess) {
            int size = size();
            int i = 0;
            if (obj == null) {
                while (i < size) {
                    if (get(i) == null) {
                        return i;
                    }
                    i++;
                }
            } else {
                while (i < size) {
                    if (obj.equals(get(i))) {
                        return i;
                    }
                    i++;
                }
            }
            return -1;
        }
        ListIterator<E> listIterator = listIterator();
        while (listIterator.hasNext()) {
            if (zzap.zza(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public int lastIndexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        if (!(this instanceof RandomAccess)) {
            ListIterator<E> listIterator = listIterator(size());
            while (listIterator.hasPrevious()) {
                if (zzap.zza(obj, listIterator.previous())) {
                    return listIterator.nextIndex();
                }
            }
            return -1;
        }
        if (obj == null) {
            for (int size = size() - 1; size >= 0; size--) {
                if (get(size) == null) {
                    return size;
                }
            }
        } else {
            for (int size2 = size() - 1; size2 >= 0; size2--) {
                if (obj.equals(get(size2))) {
                    return size2;
                }
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzbh, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public zzbg<E> subList(int i, int i2) {
        zzav.zza(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return (zzbg<E>) zzbm.zza;
        }
        return new zzbi(this, i, i3);
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i, E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzbh
    int zza(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@NullableDecl Object obj) {
        if (obj == zzav.zza(this)) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if ((this instanceof RandomAccess) && (list instanceof RandomAccess)) {
                    for (int i = 0; i < size; i++) {
                        if (zzap.zza(get(i), list.get(i))) {
                        }
                    }
                    return true;
                }
                int size2 = size();
                Iterator<E> it = list.iterator();
                int i2 = 0;
                while (true) {
                    if (i2 < size2) {
                        if (!it.hasNext()) {
                            break;
                        }
                        E e2 = get(i2);
                        i2++;
                        if (!zzap.zza(e2, it.next())) {
                            break;
                        }
                    } else if (!it.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = ~(~((i * 31) + get(i2).hashCode()));
        }
        return i;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzbh, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.List
    public /* synthetic */ ListIterator listIterator(int i) {
        zzav.zzb(i, size());
        if (isEmpty()) {
            return zza;
        }
        return new zzbj(this, i);
    }

    @Override // java.util.List
    public /* synthetic */ ListIterator listIterator() {
        return (zzbu) listIterator(0);
    }
}
