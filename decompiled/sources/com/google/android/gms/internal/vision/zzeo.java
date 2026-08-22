package com.google.android.gms.internal.vision;

import java.util.NoSuchElementException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
final class zzeo<T> extends zzfa<T> {
    private boolean zza;
    private final /* synthetic */ Object zzb;

    zzeo(Object obj) {
        this.zzb = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.zza;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (this.zza) {
            throw new NoSuchElementException();
        }
        this.zza = true;
        return (T) this.zzb;
    }
}
