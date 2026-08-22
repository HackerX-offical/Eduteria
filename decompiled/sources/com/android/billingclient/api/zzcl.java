package com.android.billingclient.api;

import android.content.Context;
import com.google.android.gms.internal.play_billing.zzjh;
import com.google.android.gms.internal.play_billing.zzjl;
import com.google.android.gms.internal.play_billing.zzjt;
import com.google.android.gms.internal.play_billing.zzka;
import com.google.android.gms.internal.play_billing.zzkc;
import com.google.android.gms.internal.play_billing.zzkk;
import com.google.android.gms.internal.play_billing.zzkm;
import com.google.android.gms.internal.play_billing.zzks;
import com.google.android.gms.internal.play_billing.zzkw;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcl implements zzch {
    private zzkc zzb;
    private final zzcn zzc;

    zzcl(Context context, zzkc zzkcVar) {
        this.zzc = new zzcn(context);
        this.zzb = zzkcVar;
    }

    @Override // com.android.billingclient.api.zzch
    public final void zza(zzjh zzjhVar) {
        if (zzjhVar == null) {
            return;
        }
        try {
            zzkk zzkkVarZzc = zzkm.zzc();
            zzkkVarZzc.zzo(this.zzb);
            zzkkVarZzc.zza(zzjhVar);
            this.zzc.zza((zzkm) zzkkVarZzc.zzf());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzch
    public final void zzb(zzjh zzjhVar, int i) {
        try {
            zzka zzkaVar = (zzka) this.zzb.zzn();
            zzkaVar.zza(i);
            this.zzb = (zzkc) zzkaVar.zzf();
            zza(zzjhVar);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzch
    public final void zzc(zzjl zzjlVar) {
        if (zzjlVar == null) {
            return;
        }
        try {
            zzkk zzkkVarZzc = zzkm.zzc();
            zzkkVarZzc.zzo(this.zzb);
            zzkkVarZzc.zzm(zzjlVar);
            this.zzc.zza((zzkm) zzkkVarZzc.zzf());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzch
    public final void zzd(zzjl zzjlVar, int i) {
        try {
            zzka zzkaVar = (zzka) this.zzb.zzn();
            zzkaVar.zza(i);
            this.zzb = (zzkc) zzkaVar.zzf();
            zzc(zzjlVar);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzch
    public final void zze(zzjt zzjtVar) {
        try {
            zzkk zzkkVarZzc = zzkm.zzc();
            zzkkVarZzc.zzo(this.zzb);
            zzkkVarZzc.zzn(zzjtVar);
            this.zzc.zza((zzkm) zzkkVarZzc.zzf());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzch
    public final void zzf(zzks zzksVar) {
        try {
            zzcn zzcnVar = this.zzc;
            zzkk zzkkVarZzc = zzkm.zzc();
            zzkkVarZzc.zzo(this.zzb);
            zzkkVarZzc.zzp(zzksVar);
            zzcnVar.zza((zzkm) zzkkVarZzc.zzf());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.zzch
    public final void zzg(zzkw zzkwVar) {
        if (zzkwVar == null) {
            return;
        }
        try {
            zzkk zzkkVarZzc = zzkm.zzc();
            zzkkVarZzc.zzo(this.zzb);
            zzkkVarZzc.zzq(zzkwVar);
            this.zzc.zza((zzkm) zzkkVarZzc.zzf());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingLogger", "Unable to log.", th);
        }
    }
}
