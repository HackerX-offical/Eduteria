package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzej {
    public static zzed zza(ExecutorService executorService) {
        return executorService instanceof zzed ? (zzed) executorService : executorService instanceof ScheduledExecutorService ? new zzei((ScheduledExecutorService) executorService) : new zzef(executorService);
    }

    public static zzee zzb(ScheduledExecutorService scheduledExecutorService) {
        return scheduledExecutorService instanceof zzee ? (zzee) scheduledExecutorService : new zzei(scheduledExecutorService);
    }
}
