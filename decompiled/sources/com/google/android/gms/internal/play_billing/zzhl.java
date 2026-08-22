package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzhl implements zzhs {
    private final zzhs[] zza;

    zzhl(zzhs... zzhsVarArr) {
        this.zza = zzhsVarArr;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhs
    public final zzhr zzb(Class cls) {
        for (int i = 0; i < 2; i++) {
            zzhs zzhsVar = this.zza[i];
            if (zzhsVar.zzc(cls)) {
                return zzhsVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(String.valueOf(cls.getName())));
    }

    @Override // com.google.android.gms.internal.play_billing.zzhs
    public final boolean zzc(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (this.zza[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
