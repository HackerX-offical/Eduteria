package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzjf;
import com.google.android.gms.internal.play_billing.zzjh;
import com.google.android.gms.internal.play_billing.zzjj;
import com.google.android.gms.internal.play_billing.zzjl;
import com.google.android.gms.internal.play_billing.zzjm;
import com.google.android.gms.internal.play_billing.zzjq;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class zzcg {
    public static final /* synthetic */ int zza = 0;

    static {
        int i = zzch.zza;
    }

    public static String zza(Exception exc) {
        if (exc == null) {
            return null;
        }
        String str = exc.getClass().getSimpleName() + ":" + com.google.android.gms.internal.play_billing.zzan.zzb(exc.getMessage());
        int i = com.google.android.gms.internal.play_billing.zze.zza;
        return str.length() <= 40 ? str : str.substring(0, 40);
    }

    public static zzjh zzb(int i, int i2, BillingResult billingResult) {
        try {
            zzjf zzjfVarZzc = zzjh.zzc();
            zzjm zzjmVarZzc = zzjq.zzc();
            zzjmVarZzc.zzn(billingResult.getResponseCode());
            zzjmVarZzc.zzm(billingResult.getDebugMessage());
            zzjmVarZzc.zzo(i);
            zzjfVarZzc.zza(zzjmVarZzc);
            zzjfVarZzc.zzn(i2);
            return (zzjh) zzjfVarZzc.zzf();
        } catch (Exception e2) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingLogger", "Unable to create logging payload", e2);
            return null;
        }
    }

    public static zzjh zzc(int i, int i2, BillingResult billingResult, String str) {
        try {
            zzjm zzjmVarZzc = zzjq.zzc();
            zzjmVarZzc.zzn(billingResult.getResponseCode());
            zzjmVarZzc.zzm(billingResult.getDebugMessage());
            zzjmVarZzc.zzo(i);
            if (str != null) {
                zzjmVarZzc.zza(str);
            }
            zzjf zzjfVarZzc = zzjh.zzc();
            zzjfVarZzc.zza(zzjmVarZzc);
            zzjfVarZzc.zzn(i2);
            return (zzjh) zzjfVarZzc.zzf();
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingLogger", "Unable to create logging payload", th);
            return null;
        }
    }

    public static zzjl zzd(int i) {
        try {
            zzjj zzjjVarZzc = zzjl.zzc();
            zzjjVarZzc.zzn(i);
            return (zzjl) zzjjVarZzc.zzf();
        } catch (Exception e2) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingLogger", "Unable to create logging payload", e2);
            return null;
        }
    }
}
