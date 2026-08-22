package com.google.android.play.core.appupdate.internal;

/* JADX INFO: compiled from: com.google.android.play:app-update@@2.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzad implements zzaf {
    private static final Object zza = new Object();
    private volatile zzaf zzb;
    private volatile Object zzc = zza;

    private zzad(zzaf zzafVar) {
        this.zzb = zzafVar;
    }

    public static zzaf zzb(zzaf zzafVar) {
        zzafVar.getClass();
        return zzafVar instanceof zzad ? zzafVar : new zzad(zzafVar);
    }

    @Override // com.google.android.play.core.appupdate.internal.zzaf
    public final Object zza() {
        Object objZza;
        Object obj = this.zzc;
        Object obj2 = zza;
        if (obj != obj2) {
            return obj;
        }
        synchronized (this) {
            objZza = this.zzc;
            if (objZza == obj2) {
                objZza = this.zzb.zza();
                Object obj3 = this.zzc;
                if (obj3 != obj2 && obj3 != objZza) {
                    throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + objZza + ". This is likely due to a circular dependency.");
                }
                this.zzc = objZza;
                this.zzb = null;
            }
        }
        return objZza;
    }
}
