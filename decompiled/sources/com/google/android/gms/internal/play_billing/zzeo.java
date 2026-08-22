package com.google.android.gms.internal.play_billing;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzeo extends zzea {
    final /* synthetic */ zzep zza;
    private final Callable zzb;

    zzeo(zzep zzepVar, Callable callable) {
        this.zza = zzepVar;
        callable.getClass();
        this.zzb = callable;
    }

    @Override // com.google.android.gms.internal.play_billing.zzea
    final Object zza() throws Exception {
        return this.zzb.call();
    }

    @Override // com.google.android.gms.internal.play_billing.zzea
    final String zzb() {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.play_billing.zzea
    final void zzc(Throwable th) {
        this.zza.zzo(th);
    }

    @Override // com.google.android.gms.internal.play_billing.zzea
    final void zzd(Object obj) {
        this.zza.zzn(obj);
    }

    @Override // com.google.android.gms.internal.play_billing.zzea
    final boolean zzf() {
        return this.zza.isDone();
    }
}
