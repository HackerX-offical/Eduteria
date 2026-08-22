package com.google.android.gms.internal.play_billing;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzeg extends zzdp implements ScheduledFuture, zzec {
    private final ScheduledFuture zza;

    public zzeg(zzec zzecVar, ScheduledFuture scheduledFuture) {
        super(zzecVar);
        this.zza = scheduledFuture;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdo, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        boolean zCancel = zzb().cancel(z);
        if (zCancel) {
            this.zza.cancel(z);
        }
        return zCancel;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Delayed delayed) {
        return this.zza.compareTo(delayed);
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return this.zza.getDelay(timeUnit);
    }
}
