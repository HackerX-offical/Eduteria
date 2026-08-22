package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzbn<E> extends zzbh<E> implements Set<E> {

    @NullableDecl
    private transient zzbg<E> zza;

    zzbn() {
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        return zzbs.zza(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return zzbs.zza(this);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzbh
    public zzbg<E> zzc() {
        zzbg<E> zzbgVar = this.zza;
        if (zzbgVar != null) {
            return zzbgVar;
        }
        zzbg<E> zzbgVarZza = zza();
        this.zza = zzbgVarZza;
        return zzbgVarZza;
    }

    zzbg<E> zza() {
        return zzbg.zza(toArray());
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzbh, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
