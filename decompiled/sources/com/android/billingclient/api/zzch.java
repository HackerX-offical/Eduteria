package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzjh;
import com.google.android.gms.internal.play_billing.zzjl;
import com.google.android.gms.internal.play_billing.zzjt;
import com.google.android.gms.internal.play_billing.zzjv;
import com.google.android.gms.internal.play_billing.zzks;
import com.google.android.gms.internal.play_billing.zzkw;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes4.dex */
interface zzch {
    public static final /* synthetic */ int zza = 0;

    static {
        com.google.android.gms.internal.play_billing.zzbz.zzc("com.android.vending.billing.PURCHASES_UPDATED", zzjv.PURCHASES_UPDATED_ACTION, "com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED", zzjv.LOCAL_PURCHASES_UPDATED_ACTION, "com.android.vending.billing.ALTERNATIVE_BILLING", zzjv.ALTERNATIVE_BILLING_ACTION);
    }

    void zza(zzjh zzjhVar);

    void zzb(zzjh zzjhVar, int i);

    void zzc(zzjl zzjlVar);

    void zzd(zzjl zzjlVar, int i);

    void zze(zzjt zzjtVar);

    void zzf(zzks zzksVar);

    void zzg(zzkw zzkwVar);
}
