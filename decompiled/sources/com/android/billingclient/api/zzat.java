package com.android.billingclient.api;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzat implements Callable {
    final /* synthetic */ String zza;
    final /* synthetic */ PurchasesResponseListener zzb;
    final /* synthetic */ BillingClientImpl zzc;

    zzat(BillingClientImpl billingClientImpl, String str, PurchasesResponseListener purchasesResponseListener) {
        this.zza = str;
        this.zzb = purchasesResponseListener;
        this.zzc = billingClientImpl;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzcu zzcuVarZzaR = this.zzc.zzaR(this.zza, 9);
        if (zzcuVarZzaR.zzb() != null) {
            this.zzb.onQueryPurchasesResponse(zzcuVarZzaR.zza(), zzcuVarZzaR.zzb());
            return null;
        }
        this.zzb.onQueryPurchasesResponse(zzcuVarZzaR.zza(), com.google.android.gms.internal.play_billing.zzbw.zzl());
        return null;
    }
}
