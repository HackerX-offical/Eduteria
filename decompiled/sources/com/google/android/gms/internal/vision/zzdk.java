package com.google.android.gms.internal.vision;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
final class zzdk<T> implements zzdf<T> {
    private volatile zzdf<T> zza;
    private volatile boolean zzb;

    @NullableDecl
    private T zzc;

    zzdk(zzdf<T> zzdfVar) {
        this.zza = (zzdf) zzde.zza(zzdfVar);
    }

    @Override // com.google.android.gms.internal.vision.zzdf
    public final T zza() {
        if (!this.zzb) {
            synchronized (this) {
                if (!this.zzb) {
                    T tZza = this.zza.zza();
                    this.zzc = tZza;
                    this.zzb = true;
                    this.zza = null;
                    return tZza;
                }
            }
        }
        return this.zzc;
    }

    public final String toString() {
        Object string = this.zza;
        if (string == null) {
            String strValueOf = String.valueOf(this.zzc);
            string = new StringBuilder(String.valueOf(strValueOf).length() + 25).append("<supplier that returned ").append(strValueOf).append(">").toString();
        }
        String strValueOf2 = String.valueOf(string);
        return new StringBuilder(String.valueOf(strValueOf2).length() + 19).append("Suppliers.memoize(").append(strValueOf2).append(")").toString();
    }
}
