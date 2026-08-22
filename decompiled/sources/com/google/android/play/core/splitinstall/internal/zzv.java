package com.google.android.play.core.splitinstall.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.play:feature-delivery@@2.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzv implements Runnable {
    private final TaskCompletionSource zza;

    zzv() {
        this.zza = null;
    }

    public zzv(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            zzc();
        } catch (Exception e2) {
            zzb(e2);
        }
    }

    final TaskCompletionSource zza() {
        return this.zza;
    }

    public final void zzb(Exception exc) {
        TaskCompletionSource taskCompletionSource = this.zza;
        if (taskCompletionSource != null) {
            taskCompletionSource.trySetException(exc);
        }
    }

    protected abstract void zzc();
}
