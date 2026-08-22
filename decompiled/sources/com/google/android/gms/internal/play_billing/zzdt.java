package com.google.android.gms.internal.play_billing;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzdt extends zzdv {
    public static zzec zza(Object obj) {
        return new zzdw(obj);
    }

    public static zzec zzb(zzec zzecVar, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return zzecVar.isDone() ? zzecVar : zzen.zzs(zzecVar, 28500L, timeUnit, scheduledExecutorService);
    }

    public static void zzc(zzec zzecVar, zzdr zzdrVar, Executor executor) {
        zzecVar.zzl(new zzds(zzecVar, zzdrVar), executor);
    }
}
