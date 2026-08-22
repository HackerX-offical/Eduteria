package com.android.billingclient.api;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzau implements Callable {
    final /* synthetic */ String zza;
    final /* synthetic */ PurchaseHistoryResponseListener zzb;
    final /* synthetic */ BillingClientImpl zzc;

    zzau(BillingClientImpl billingClientImpl, String str, PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        this.zza = str;
        this.zzb = purchaseHistoryResponseListener;
        this.zzc = billingClientImpl;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzbk zzbkVarZzay = this.zzc.zzay(this.zza);
        this.zzb.onPurchaseHistoryResponse(zzbkVarZzay.zza(), zzbkVarZzay.zzb());
        return null;
    }
}
