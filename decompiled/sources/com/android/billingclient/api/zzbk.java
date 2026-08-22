package com.android.billingclient.api;

import java.util.List;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbk {
    private final List zza;
    private final BillingResult zzb;

    zzbk(BillingResult billingResult, List list) {
        this.zza = list;
        this.zzb = billingResult;
    }

    final BillingResult zza() {
        return this.zzb;
    }

    final List zzb() {
        return this.zza;
    }
}
