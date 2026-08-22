package com.google.android.play.core.splitcompat;

import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.play:feature-delivery@@2.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzg implements zzl {
    final /* synthetic */ zzh zza;

    zzg(zzh zzhVar) {
        this.zza = zzhVar;
    }

    @Override // com.google.android.play.core.splitcompat.zzl
    public final void zza(zzm zzmVar, File file, boolean z) throws IOException {
        this.zza.zzb.add(file);
        if (z) {
            return;
        }
        this.zza.zzc.set(false);
    }
}
