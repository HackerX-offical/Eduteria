package com.google.android.play.core.splitinstall.internal;

import android.util.Log;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.play:feature-delivery@@2.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzaj implements Runnable {
    final /* synthetic */ List zza;
    final /* synthetic */ com.google.android.play.core.splitinstall.zzf zzb;
    final /* synthetic */ zzak zzc;

    zzaj(zzak zzakVar, List list, com.google.android.play.core.splitinstall.zzf zzfVar) {
        this.zzc = zzakVar;
        this.zza = list;
        this.zzb = zzfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.zzc.zzc.zzb(this.zza)) {
                zzak.zzc(this.zzc, this.zzb);
            } else {
                zzak.zzb(this.zzc, this.zza, this.zzb);
            }
        } catch (Exception e2) {
            Log.e("SplitCompat", "Error checking verified files.", e2);
            this.zzb.zzb(-11);
        }
    }
}
