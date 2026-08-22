package com.google.android.play.core.splitinstall;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.play:feature-delivery@@2.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzr {
    private static final AtomicReference zza = new AtomicReference(null);

    static zzq zza() {
        return (zzq) zza.get();
    }

    public static void zzb(zzq zzqVar) {
        AtomicReference atomicReference = zza;
        while (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, zzqVar) && atomicReference.get() == null) {
        }
    }
}
