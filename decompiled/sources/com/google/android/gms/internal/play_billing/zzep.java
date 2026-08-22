package com.google.android.gms.internal.play_billing;

import com.clevertap.android.sdk.Constants;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzep extends zzdm implements RunnableFuture {

    @CheckForNull
    private volatile zzea zzc;

    zzep(Callable callable) {
        this.zzc = new zzeo(this, callable);
    }

    static zzep zzr(Runnable runnable, Object obj) {
        return new zzep(Executors.callable(runnable, obj));
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        zzea zzeaVar = this.zzc;
        if (zzeaVar != null) {
            zzeaVar.run();
        }
        this.zzc = null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdg
    @CheckForNull
    protected final String zzf() {
        zzea zzeaVar = this.zzc;
        if (zzeaVar == null) {
            return super.zzf();
        }
        return "task=[" + zzeaVar.toString() + Constants.AES_SUFFIX;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdg
    protected final void zzm() {
        zzea zzeaVar;
        if (zzq() && (zzeaVar = this.zzc) != null) {
            zzeaVar.zze();
        }
        this.zzc = null;
    }
}
