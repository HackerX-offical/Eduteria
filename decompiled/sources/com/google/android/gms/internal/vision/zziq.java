package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zziw;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
abstract class zziq<T extends zziw<T>> {
    zziq() {
    }

    abstract int zza(Map.Entry<?, ?> entry);

    abstract zziu<T> zza(Object obj);

    abstract Object zza(zzio zzioVar, zzkk zzkkVar, int i);

    abstract <UT, UB> UB zza(zzld zzldVar, Object obj, zzio zzioVar, zziu<T> zziuVar, UB ub, zzlu<UT, UB> zzluVar) throws IOException;

    abstract void zza(zzht zzhtVar, Object obj, zzio zzioVar, zziu<T> zziuVar) throws IOException;

    abstract void zza(zzld zzldVar, Object obj, zzio zzioVar, zziu<T> zziuVar) throws IOException;

    abstract void zza(zzmr zzmrVar, Map.Entry<?, ?> entry) throws IOException;

    abstract boolean zza(zzkk zzkkVar);

    abstract zziu<T> zzb(Object obj);

    abstract void zzc(Object obj);
}
