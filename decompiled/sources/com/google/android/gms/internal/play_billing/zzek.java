package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzek implements Runnable {

    @CheckForNull
    zzen zza;

    zzek(zzen zzenVar) {
        this.zza = zzenVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzec zzecVar;
        zzen zzenVar = this.zza;
        if (zzenVar == null || (zzecVar = zzenVar.zzc) == null) {
            return;
        }
        this.zza = null;
        if (zzecVar.isDone()) {
            zzenVar.zzp(zzecVar);
            return;
        }
        try {
            ScheduledFuture scheduledFuture = zzenVar.zzd;
            zzenVar.zzd = null;
            String str = "Timed out";
            if (scheduledFuture != null) {
                try {
                    long jAbs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                    if (jAbs > 10) {
                        str = "Timed out (timeout delayed by " + jAbs + " ms after scheduled time)";
                    }
                } catch (Throwable th) {
                    zzenVar.zzo(new zzel(str, null));
                    throw th;
                }
            }
            zzenVar.zzo(new zzel(str + ": " + zzecVar.toString(), null));
        } finally {
            zzecVar.cancel(true);
        }
    }
}
