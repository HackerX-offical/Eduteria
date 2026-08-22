package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public class zzhf {
    protected volatile zzhu zza;
    private volatile zzfs zzb;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzhf)) {
            return false;
        }
        zzhf zzhfVar = (zzhf) obj;
        zzhu zzhuVar = this.zza;
        zzhu zzhuVar2 = zzhfVar.zza;
        if (zzhuVar == null && zzhuVar2 == null) {
            return zzb().equals(zzhfVar.zzb());
        }
        if (zzhuVar != null && zzhuVar2 != null) {
            return zzhuVar.equals(zzhuVar2);
        }
        if (zzhuVar != null) {
            zzhfVar.zzd(zzhuVar.zzi());
            return zzhuVar.equals(zzhfVar.zza);
        }
        zzd(zzhuVar2.zzi());
        return this.zza.equals(zzhuVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzb != null) {
            return ((zzfq) this.zzb).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzk();
        }
        return 0;
    }

    public final zzfs zzb() {
        if (this.zzb != null) {
            return this.zzb;
        }
        synchronized (this) {
            if (this.zzb != null) {
                return this.zzb;
            }
            if (this.zza == null) {
                this.zzb = zzfs.zzb;
            } else {
                this.zzb = this.zza.zzf();
            }
            return this.zzb;
        }
    }

    public final zzhu zzc(zzhu zzhuVar) {
        zzhu zzhuVar2 = this.zza;
        this.zzb = null;
        this.zza = zzhuVar;
        return zzhuVar2;
    }

    protected final void zzd(zzhu zzhuVar) {
        if (this.zza != null) {
            return;
        }
        synchronized (this) {
            if (this.zza != null) {
                return;
            }
            try {
                this.zza = zzhuVar;
                this.zzb = zzfs.zzb;
            } catch (zzgz unused) {
                this.zza = zzhuVar;
                this.zzb = zzfs.zzb;
            }
        }
    }
}
