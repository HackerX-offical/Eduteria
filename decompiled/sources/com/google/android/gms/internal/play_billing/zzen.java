package com.google.android.gms.internal.play_billing;

import com.clevertap.android.sdk.Constants;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzen extends zzdm {

    @CheckForNull
    private zzec zzc;

    @CheckForNull
    private ScheduledFuture zzd;

    static zzec zzs(zzec zzecVar, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzen zzenVar = new zzen(zzecVar);
        zzek zzekVar = new zzek(zzenVar);
        zzenVar.zzd = scheduledExecutorService.schedule(zzekVar, 28500L, timeUnit);
        zzecVar.zzl(zzekVar, zzdl.INSTANCE);
        return zzenVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdg
    @CheckForNull
    protected final String zzf() {
        zzec zzecVar = this.zzc;
        ScheduledFuture scheduledFuture = this.zzd;
        if (zzecVar == null) {
            return null;
        }
        String str = "inputFuture=[" + zzecVar.toString() + Constants.AES_SUFFIX;
        if (scheduledFuture == null) {
            return str;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return str;
        }
        return str + ", remaining delay=[" + delay + " ms]";
    }

    @Override // com.google.android.gms.internal.play_billing.zzdg
    protected final void zzm() {
        zzec zzecVar = this.zzc;
        if ((zzecVar != null) & isCancelled()) {
            zzecVar.cancel(zzq());
        }
        ScheduledFuture scheduledFuture = this.zzd;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zzc = null;
        this.zzd = null;
    }

    private zzen(zzec zzecVar) {
        zzecVar.getClass();
        this.zzc = zzecVar;
    }
}
