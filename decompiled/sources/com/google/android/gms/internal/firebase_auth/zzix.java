package com.google.android.gms.internal.firebase_auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzix extends zzgp<String> implements zziw, RandomAccess {
    private static final zzix zza;
    private static final zziw zzb;
    private final List<Object> zzc;

    public zzix() {
        this(10);
    }

    public zzix(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    private zzix(ArrayList<Object> arrayList) {
        this.zzc = arrayList;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc.size();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgp, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgp, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzc();
        if (collection instanceof zziw) {
            collection = ((zziw) collection).zzb();
        }
        boolean zAddAll = this.zzc.addAll(i, collection);
        this.modCount++;
        return zAddAll;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgp, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zzc();
        this.zzc.clear();
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zziw
    public final void zza(zzgt zzgtVar) {
        zzc();
        this.zzc.add(zzgtVar);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zziw
    public final Object zzb(int i) {
        return this.zzc.get(i);
    }

    private static String zza(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzgt) {
            return ((zzgt) obj).zzb();
        }
        return zzig.zzb((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zziw
    public final List<?> zzb() {
        return Collections.unmodifiableList(this.zzc);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zziw
    public final zziw b_() {
        return zza() ? new zzlc(this) : this;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgp, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        zzc();
        return zza(this.zzc.set(i, (String) obj));
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgp, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgp, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgp, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgp, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzc();
        Object objRemove = this.zzc.remove(i);
        this.modCount++;
        return zza(objRemove);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgp, com.google.android.gms.internal.firebase_auth.zzim
    public final /* bridge */ /* synthetic */ boolean zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgp, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zzc();
        this.zzc.add(i, (String) obj);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgp, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgp, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgp, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzim
    public final /* synthetic */ zzim zza(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.zzc);
        return new zzix((ArrayList<Object>) arrayList);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzc.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzgt) {
            zzgt zzgtVar = (zzgt) obj;
            String strZzb = zzgtVar.zzb();
            if (zzgtVar.zzc()) {
                this.zzc.set(i, strZzb);
            }
            return strZzb;
        }
        byte[] bArr = (byte[]) obj;
        String strZzb2 = zzig.zzb(bArr);
        if (zzig.zza(bArr)) {
            this.zzc.set(i, strZzb2);
        }
        return strZzb2;
    }

    static {
        zzix zzixVar = new zzix();
        zza = zzixVar;
        zzixVar.c_();
        zzb = zzixVar;
    }
}
