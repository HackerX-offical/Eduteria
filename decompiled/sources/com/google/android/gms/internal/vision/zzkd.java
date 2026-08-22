package com.google.android.gms.internal.vision;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
final class zzkd implements zzkl {
    private zzkl[] zza;

    zzkd(zzkl... zzklVarArr) {
        this.zza = zzklVarArr;
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final boolean zza(Class<?> cls) {
        for (zzkl zzklVar : this.zza) {
            if (zzklVar.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final zzki zzb(Class<?> cls) {
        for (zzkl zzklVar : this.zza) {
            if (zzklVar.zza(cls)) {
                return zzklVar.zzb(cls);
            }
        }
        String strValueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(strValueOf.length() != 0 ? "No factory is available for message type: ".concat(strValueOf) : new String("No factory is available for message type: "));
    }
}
