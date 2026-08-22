package com.google.android.gms.internal.vision;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
final class zzjz extends zzju {
    private zzjz() {
        super();
    }

    @Override // com.google.android.gms.internal.vision.zzju
    final <L> List<L> zza(Object obj, long j) {
        zzjl zzjlVarZzc = zzc(obj, j);
        if (zzjlVarZzc.zza()) {
            return zzjlVarZzc;
        }
        int size = zzjlVarZzc.size();
        zzjl zzjlVarZza = zzjlVarZzc.zza(size == 0 ? 10 : size << 1);
        zzma.zza(obj, j, zzjlVarZza);
        return zzjlVarZza;
    }

    @Override // com.google.android.gms.internal.vision.zzju
    final void zzb(Object obj, long j) {
        zzc(obj, j).zzb();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.vision.zzjl] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.google.android.gms.internal.vision.zzjl, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3 */
    @Override // com.google.android.gms.internal.vision.zzju
    final <E> void zza(Object obj, Object obj2, long j) {
        zzjl zzjlVarZzc = zzc(obj, j);
        ?? Zzc = zzc(obj2, j);
        int size = zzjlVarZzc.size();
        int size2 = Zzc.size();
        ?? r0 = zzjlVarZzc;
        r0 = zzjlVarZzc;
        if (size > 0 && size2 > 0) {
            boolean zZza = zzjlVarZzc.zza();
            ?? Zza = zzjlVarZzc;
            if (!zZza) {
                Zza = zzjlVarZzc.zza(size2 + size);
            }
            Zza.addAll(Zzc);
            r0 = Zza;
        }
        if (size > 0) {
            Zzc = r0;
        }
        zzma.zza(obj, j, (Object) Zzc);
    }

    private static <E> zzjl<E> zzc(Object obj, long j) {
        return (zzjl) zzma.zzf(obj, j);
    }
}
