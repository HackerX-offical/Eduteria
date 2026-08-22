package com.google.firebase.auth.api.internal;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzfa implements Runnable {
    private final /* synthetic */ zzez zza;
    private final /* synthetic */ zzeu zzb;

    zzfa(zzeu zzeuVar, zzez zzezVar) {
        this.zzb = zzeuVar;
        this.zza = zzezVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzb.zza.zzi) {
            if (!this.zzb.zza.zzi.isEmpty()) {
                this.zza.zza(this.zzb.zza.zzi.get(0), new Object[0]);
            }
        }
    }
}
