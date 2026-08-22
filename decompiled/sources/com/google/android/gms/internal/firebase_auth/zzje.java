package com.google.android.gms.internal.firebase_auth;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzje implements zzjm {
    private zzjm[] zza;

    zzje(zzjm... zzjmVarArr) {
        this.zza = zzjmVarArr;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzjm
    public final boolean zza(Class<?> cls) {
        for (zzjm zzjmVar : this.zza) {
            if (zzjmVar.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzjm
    public final zzjn zzb(Class<?> cls) {
        for (zzjm zzjmVar : this.zza) {
            if (zzjmVar.zza(cls)) {
                return zzjmVar.zzb(cls);
            }
        }
        String strValueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(strValueOf.length() != 0 ? "No factory is available for message type: ".concat(strValueOf) : new String("No factory is available for message type: "));
    }
}
