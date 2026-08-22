package com.android.billingclient.api;

import android.content.Context;
import android.content.IntentFilter;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzn {
    private final Context zza;
    private final PurchasesUpdatedListener zzb;
    private final zzb zzc;
    private final UserChoiceBillingListener zzd;
    private final zzch zze;
    private final zzm zzf = new zzm(this, true);
    private final zzm zzg = new zzm(this, false);
    private boolean zzh;

    zzn(Context context, PurchasesUpdatedListener purchasesUpdatedListener, zzco zzcoVar, zzb zzbVar, UserChoiceBillingListener userChoiceBillingListener, zzch zzchVar) {
        this.zza = context;
        this.zzb = purchasesUpdatedListener;
        this.zzc = zzbVar;
        this.zzd = userChoiceBillingListener;
        this.zze = zzchVar;
    }

    final PurchasesUpdatedListener zzd() {
        return this.zzb;
    }

    final void zzf() {
        this.zzf.zzc(this.zza);
        this.zzg.zzc(this.zza);
    }

    final void zzg(boolean z) {
        IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
        IntentFilter intentFilter2 = new IntentFilter("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intentFilter2.addAction("com.android.vending.billing.ALTERNATIVE_BILLING");
        this.zzh = z;
        this.zzg.zza(this.zza, intentFilter2);
        if (this.zzh) {
            this.zzf.zzb(this.zza, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST");
        } else {
            this.zzf.zza(this.zza, intentFilter);
        }
    }
}
