package com.android.billingclient.api;

import java.util.List;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcu {
    private final List zza;
    private final BillingResult zzb;

    public zzcu(BillingResult billingResult, List list) {
        this.zza = list;
        this.zzb = billingResult;
    }

    public final BillingResult zza() {
        return this.zzb;
    }

    public final List zzb() {
        return this.zza;
    }
}
