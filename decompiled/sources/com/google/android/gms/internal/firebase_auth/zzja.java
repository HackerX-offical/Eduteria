package com.google.android.gms.internal.firebase_auth;

import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzja extends zziz {
    private zzja() {
        super();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zziz
    final <L> List<L> zza(Object obj, long j) {
        zzim zzimVarZzc = zzc(obj, j);
        if (zzimVarZzc.zza()) {
            return zzimVarZzc;
        }
        int size = zzimVarZzc.size();
        zzim zzimVarZza = zzimVarZzc.zza(size == 0 ? 10 : size << 1);
        zzld.zza(obj, j, zzimVarZza);
        return zzimVarZza;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zziz
    final void zzb(Object obj, long j) {
        zzc(obj, j).c_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.firebase_auth.zzim] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.google.android.gms.internal.firebase_auth.zzim, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3 */
    @Override // com.google.android.gms.internal.firebase_auth.zziz
    final <E> void zza(Object obj, Object obj2, long j) {
        zzim zzimVarZzc = zzc(obj, j);
        ?? Zzc = zzc(obj2, j);
        int size = zzimVarZzc.size();
        int size2 = Zzc.size();
        ?? r0 = zzimVarZzc;
        r0 = zzimVarZzc;
        if (size > 0 && size2 > 0) {
            boolean zZza = zzimVarZzc.zza();
            ?? Zza = zzimVarZzc;
            if (!zZza) {
                Zza = zzimVarZzc.zza(size2 + size);
            }
            Zza.addAll(Zzc);
            r0 = Zza;
        }
        if (size > 0) {
            Zzc = r0;
        }
        zzld.zza(obj, j, (Object) Zzc);
    }

    private static <E> zzim<E> zzc(Object obj, long j) {
        return (zzim) zzld.zzf(obj, j);
    }
}
