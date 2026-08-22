package com.google.android.gms.internal.play_billing;

import java.io.Serializable;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzcp extends zzcq implements Serializable {
    public static final /* synthetic */ int zzc = 0;
    private static final zzcp zzd = new zzcp(zzbl.zzb, zzbj.zzb);
    final zzbm zza;
    final zzbm zzb;

    private zzcp(zzbm zzbmVar, zzbm zzbmVar2) {
        this.zza = zzbmVar;
        this.zzb = zzbmVar2;
        if (zzbmVar.compareTo(zzbmVar2) > 0 || zzbmVar == zzbj.zzb || zzbmVar2 == zzbl.zzb) {
            throw new IllegalArgumentException("Invalid range: ".concat(zze(zzbmVar, zzbmVar2)));
        }
    }

    public static zzcp zza() {
        return zzd;
    }

    private static String zze(zzbm zzbmVar, zzbm zzbmVar2) {
        StringBuilder sb = new StringBuilder(16);
        zzbmVar.zzc(sb);
        sb.append("..");
        zzbmVar2.zzd(sb);
        return sb.toString();
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzcp) {
            zzcp zzcpVar = (zzcp) obj;
            if (this.zza.equals(zzcpVar.zza) && this.zzb.equals(zzcpVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.zza.hashCode() * 31) + this.zzb.hashCode();
    }

    public final String toString() {
        return zze(this.zza, this.zzb);
    }

    public final zzcp zzb(zzcp zzcpVar) {
        int iZza = this.zza.compareTo(zzcpVar.zza);
        int iZza2 = this.zzb.compareTo(zzcpVar.zzb);
        if (iZza >= 0 && iZza2 <= 0) {
            return this;
        }
        if (iZza <= 0 && iZza2 >= 0) {
            return zzcpVar;
        }
        zzbm zzbmVar = iZza >= 0 ? this.zza : zzcpVar.zza;
        zzbm zzbmVar2 = iZza2 <= 0 ? this.zzb : zzcpVar.zzb;
        zzam.zzd(zzbmVar.compareTo(zzbmVar2) <= 0, "intersection is undefined for disconnected ranges %s and %s", this, zzcpVar);
        return new zzcp(zzbmVar, zzbmVar2);
    }

    public final zzcp zzc(zzcp zzcpVar) {
        int iZza = this.zza.compareTo(zzcpVar.zza);
        int iZza2 = this.zzb.compareTo(zzcpVar.zzb);
        if (iZza <= 0 && iZza2 >= 0) {
            return this;
        }
        if (iZza >= 0 && iZza2 <= 0) {
            return zzcpVar;
        }
        zzbm zzbmVar = iZza <= 0 ? this.zza : zzcpVar.zza;
        if (iZza2 >= 0) {
            zzcpVar = this;
        }
        return new zzcp(zzbmVar, zzcpVar.zzb);
    }

    public final boolean zzd() {
        return this.zza.equals(this.zzb);
    }
}
