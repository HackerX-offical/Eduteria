package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzbt extends zzap {
    private final zzbw zza;

    zzbt(zzbw zzbwVar, int i) {
        super(zzbwVar.size(), i);
        this.zza = zzbwVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzap
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}
