package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
abstract class zzkx<T, B> {
    zzkx() {
    }

    abstract B zza();

    abstract T zza(B b2);

    abstract void zza(B b2, int i, int i2);

    abstract void zza(B b2, int i, long j);

    abstract void zza(B b2, int i, zzgt zzgtVar);

    abstract void zza(B b2, int i, T t);

    abstract void zza(T t, zzlu zzluVar) throws IOException;

    abstract void zza(Object obj, T t);

    abstract boolean zza(zzkc zzkcVar);

    abstract T zzb(Object obj);

    abstract void zzb(B b2, int i, long j);

    abstract void zzb(T t, zzlu zzluVar) throws IOException;

    abstract void zzb(Object obj, B b2);

    abstract B zzc(Object obj);

    abstract T zzc(T t, T t2);

    abstract void zzd(Object obj);

    abstract int zze(T t);

    abstract int zzf(T t);

    final boolean zza(B b2, zzkc zzkcVar) throws IOException {
        int iZzb = zzkcVar.zzb();
        int i = iZzb >>> 3;
        int i2 = iZzb & 7;
        if (i2 == 0) {
            zza(b2, i, zzkcVar.zzg());
            return true;
        }
        if (i2 == 1) {
            zzb(b2, i, zzkcVar.zzi());
            return true;
        }
        if (i2 == 2) {
            zza((Object) b2, i, zzkcVar.zzn());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw zzip.zzf();
            }
            zza((Object) b2, i, zzkcVar.zzj());
            return true;
        }
        B bZza = zza();
        int i3 = 4 | (i << 3);
        while (zzkcVar.zza() != Integer.MAX_VALUE && zza((Object) bZza, zzkcVar)) {
        }
        if (i3 != zzkcVar.zzb()) {
            throw zzip.zze();
        }
        zza(b2, i, zza(bZza));
        return true;
    }
}
