package com.google.android.gms.internal.vision;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
abstract class zzdw<T> implements Iterator<T> {
    private int zza;
    private int zzb;
    private int zzc;
    private final /* synthetic */ zzdp zzd;

    private zzdw(zzdp zzdpVar) {
        this.zzd = zzdpVar;
        this.zza = zzdpVar.zzf;
        this.zzb = zzdpVar.zzd();
        this.zzc = -1;
    }

    abstract T zza(int i);

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.zzb >= 0;
    }

    @Override // java.util.Iterator
    public T next() {
        zza();
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.zzb;
        this.zzc = i;
        T tZza = zza(i);
        this.zzb = this.zzd.zza(this.zzb);
        return tZza;
    }

    @Override // java.util.Iterator
    public void remove() {
        zza();
        zzde.zzb(this.zzc >= 0, "no calls to next() since the last call to remove()");
        this.zza += 32;
        zzdp zzdpVar = this.zzd;
        zzdpVar.remove(zzdpVar.zzb[this.zzc]);
        this.zzb = zzdp.zzb(this.zzb, this.zzc);
        this.zzc = -1;
    }

    private final void zza() {
        if (this.zzd.zzf != this.zza) {
            throw new ConcurrentModificationException();
        }
    }

    /* synthetic */ zzdw(zzdp zzdpVar, zzds zzdsVar) {
        this(zzdpVar);
    }
}
