package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzds implements Runnable {
    final Future zza;
    final zzdr zzb;

    zzds(Future future, zzdr zzdrVar) {
        this.zza = future;
        this.zzb = zzdrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        Throwable thZza;
        Object obj2 = this.zza;
        if ((obj2 instanceof zzeq) && (thZza = zzer.zza((zzeq) obj2)) != null) {
            this.zzb.zza(thZza);
            return;
        }
        try {
            Future future = this.zza;
            if (!future.isDone()) {
                throw new IllegalStateException(zzan.zza("Future was expected to be done: %s", future));
            }
            boolean z = false;
            while (true) {
                try {
                    obj = future.get();
                    break;
                } catch (InterruptedException unused) {
                    z = true;
                } catch (Throwable th) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            this.zzb.zzb(obj);
        } catch (ExecutionException e2) {
            this.zzb.zza(e2.getCause());
        } catch (Throwable th2) {
            this.zzb.zza(th2);
        }
    }

    public final String toString() {
        zzai zzaiVarZza = zzak.zza(this);
        zzaiVarZza.zza(this.zzb);
        return zzaiVarZza.toString();
    }
}
