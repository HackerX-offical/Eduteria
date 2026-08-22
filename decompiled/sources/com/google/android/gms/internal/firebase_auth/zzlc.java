package com.google.android.gms.internal.firebase_auth;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzlc extends AbstractList<String> implements zziw, RandomAccess {
    private final zziw zza;

    public zzlc(zziw zziwVar) {
        this.zza = zziwVar;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zziw
    public final zziw b_() {
        return this;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zziw
    public final Object zzb(int i) {
        return this.zza.zzb(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zziw
    public final void zza(zzgt zzgtVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i) {
        return new zzlb(this, i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new zzle(this);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zziw
    public final List<?> zzb() {
        return this.zza.zzb();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return (String) this.zza.get(i);
    }
}
