package com.google.android.gms.internal.play_billing;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzdq extends zzdo implements zzec {
    protected zzdq() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzdo
    protected /* bridge */ /* synthetic */ Future zzb() {
        throw null;
    }

    protected abstract zzec zzc();

    @Override // com.google.android.gms.internal.play_billing.zzec
    public final void zzl(Runnable runnable, Executor executor) {
        zzc().zzl(runnable, executor);
    }
}
