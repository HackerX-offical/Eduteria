package com.google.android.gms.internal.play_billing;

import com.clevertap.android.sdk.Constants;
import com.google.android.gms.internal.play_billing.zzdg;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzeh extends zzdg.zzi implements Runnable {
    private final Runnable zzc;

    @Override // com.google.android.gms.internal.play_billing.zzdg
    protected final String zzf() {
        return "task=[" + this.zzc.toString() + Constants.AES_SUFFIX;
    }

    public zzeh(Runnable runnable) {
        runnable.getClass();
        this.zzc = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzc.run();
        } catch (Throwable th) {
            zzo(th);
            throw th;
        }
    }
}
