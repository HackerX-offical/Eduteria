package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzko<K, V> implements Iterator<Map.Entry<K, V>> {
    private int zza;
    private boolean zzb;
    private Iterator<Map.Entry<K, V>> zzc;
    private final /* synthetic */ zzkg zzd;

    private zzko(zzkg zzkgVar) {
        this.zzd = zzkgVar;
        this.zza = -1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza + 1 < this.zzd.zzb.size() || (!this.zzd.zzc.isEmpty() && zza().hasNext());
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzb) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzb = false;
        this.zzd.zzf();
        if (this.zza < this.zzd.zzb.size()) {
            zzkg zzkgVar = this.zzd;
            int i = this.zza;
            this.zza = i - 1;
            zzkgVar.zzc(i);
            return;
        }
        zza().remove();
    }

    private final Iterator<Map.Entry<K, V>> zza() {
        if (this.zzc == null) {
            this.zzc = this.zzd.zzc.entrySet().iterator();
        }
        return this.zzc;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        this.zzb = true;
        int i = this.zza + 1;
        this.zza = i;
        if (i >= this.zzd.zzb.size()) {
            return zza().next();
        }
        return (Map.Entry) this.zzd.zzb.get(this.zza);
    }

    /* synthetic */ zzko(zzkg zzkgVar, zzkj zzkjVar) {
        this(zzkgVar);
    }
}
