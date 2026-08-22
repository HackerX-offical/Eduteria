package com.google.android.gms.vision.clearcut;

import com.google.android.gms.internal.vision.zzfi;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
final class zza implements Runnable {
    private final /* synthetic */ int zza;
    private final /* synthetic */ zzfi.zzo zzb;
    private final /* synthetic */ DynamiteClearcutLogger zzc;

    zza(DynamiteClearcutLogger dynamiteClearcutLogger, int i, zzfi.zzo zzoVar) {
        this.zzc = dynamiteClearcutLogger;
        this.zza = i;
        this.zzb = zzoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zzc.zza(this.zza, this.zzb);
    }
}
