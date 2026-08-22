package com.google.firebase.auth.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzaw implements Executor {
    private static zzaw zza = new zzaw();
    private Handler zzb = new com.google.android.gms.internal.firebase_auth.zzj(Looper.getMainLooper());

    private zzaw() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.zzb.post(runnable);
    }

    public static zzaw zza() {
        return zza;
    }
}
