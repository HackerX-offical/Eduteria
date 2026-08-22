package com.google.android.gms.vision.clearcut;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzb {
    private final Object zzb = new Object();
    private long zzc = Long.MIN_VALUE;
    private final long zza = Math.round(30000.0d);

    public zzb(double d2) {
    }

    public final boolean zza() {
        synchronized (this.zzb) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.zzc + this.zza > jCurrentTimeMillis) {
                return false;
            }
            this.zzc = jCurrentTimeMillis;
            return true;
        }
    }
}
