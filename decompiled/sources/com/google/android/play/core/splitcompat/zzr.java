package com.google.android.play.core.splitcompat;

import android.util.Log;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.play:feature-delivery@@2.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzr implements Runnable {
    final /* synthetic */ Set zza;
    final /* synthetic */ SplitCompat zzb;

    zzr(SplitCompat splitCompat, Set set) {
        this.zzb = splitCompat;
        this.zza = set;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzb.zzg(this.zza);
        } catch (Exception e2) {
            Log.e("SplitCompat", "Failed to remove from splitcompat storage split that is already installed", e2);
        }
    }
}
