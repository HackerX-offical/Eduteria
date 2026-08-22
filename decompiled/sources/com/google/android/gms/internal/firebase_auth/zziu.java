package com.google.android.gms.internal.firebase_auth;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public class zziu {
    private static final zzhr zza = zzhr.zza();
    private zzgt zzb;
    private volatile zzjp zzc;
    private volatile zzgt zzd;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zziu)) {
            return false;
        }
        zziu zziuVar = (zziu) obj;
        zzjp zzjpVar = this.zzc;
        zzjp zzjpVar2 = zziuVar.zzc;
        if (zzjpVar == null && zzjpVar2 == null) {
            return zzc().equals(zziuVar.zzc());
        }
        if (zzjpVar != null && zzjpVar2 != null) {
            return zzjpVar.equals(zzjpVar2);
        }
        if (zzjpVar != null) {
            return zzjpVar.equals(zziuVar.zzb(zzjpVar.zzag()));
        }
        return zzb(zzjpVar2.zzag()).equals(zzjpVar2);
    }

    private final zzjp zzb(zzjp zzjpVar) {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    try {
                        this.zzc = zzjpVar;
                        this.zzd = zzgt.zza;
                    } catch (zzip unused) {
                        this.zzc = zzjpVar;
                        this.zzd = zzgt.zza;
                    }
                }
            }
        }
        return this.zzc;
    }

    public final zzjp zza(zzjp zzjpVar) {
        zzjp zzjpVar2 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzjpVar;
        return zzjpVar2;
    }

    public final int zzb() {
        if (this.zzd != null) {
            return this.zzd.zza();
        }
        if (this.zzc != null) {
            return this.zzc.zzab();
        }
        return 0;
    }

    public final zzgt zzc() {
        if (this.zzd != null) {
            return this.zzd;
        }
        synchronized (this) {
            if (this.zzd != null) {
                return this.zzd;
            }
            if (this.zzc == null) {
                this.zzd = zzgt.zza;
            } else {
                this.zzd = this.zzc.zzw();
            }
            return this.zzd;
        }
    }
}
