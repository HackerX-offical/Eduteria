package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzhz;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
abstract class zzht<T extends zzhz<T>> {
    zzht() {
    }

    abstract int zza(Map.Entry<?, ?> entry);

    abstract zzhx<T> zza(Object obj);

    abstract Object zza(zzhr zzhrVar, zzjp zzjpVar, int i);

    abstract <UT, UB> UB zza(zzkc zzkcVar, Object obj, zzhr zzhrVar, zzhx<T> zzhxVar, UB ub, zzkx<UT, UB> zzkxVar) throws IOException;

    abstract void zza(zzgt zzgtVar, Object obj, zzhr zzhrVar, zzhx<T> zzhxVar) throws IOException;

    abstract void zza(zzkc zzkcVar, Object obj, zzhr zzhrVar, zzhx<T> zzhxVar) throws IOException;

    abstract void zza(zzlu zzluVar, Map.Entry<?, ?> entry) throws IOException;

    abstract boolean zza(zzjp zzjpVar);

    abstract zzhx<T> zzb(Object obj);

    abstract void zzc(Object obj);
}
