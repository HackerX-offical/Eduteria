package com.android.billingclient.api;

import android.os.Bundle;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbg extends com.google.android.gms.internal.play_billing.zzp {
    final AlternativeBillingOnlyAvailabilityListener zza;
    final zzch zzb;
    final int zzc;

    /* synthetic */ zzbg(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener, zzch zzchVar, int i, zzbl zzblVar) {
        this.zza = alternativeBillingOnlyAvailabilityListener;
        this.zzb = zzchVar;
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.play_billing.zzq
    public final void zza(Bundle bundle) throws RemoteException {
        if (bundle == null) {
            this.zzb.zzb(zzcg.zzb(67, 14, zzcj.zzk), this.zzc);
            this.zza.onAlternativeBillingOnlyAvailabilityResponse(zzcj.zzk);
            return;
        }
        int iZzb = com.google.android.gms.internal.play_billing.zze.zzb(bundle, "BillingClient");
        BillingResult billingResultZza = zzcj.zza(iZzb, com.google.android.gms.internal.play_billing.zze.zzh(bundle, "BillingClient"));
        if (iZzb != 0) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "isAlternativeBillingOnlyAvailableAsync() failed. Response code: " + iZzb);
            this.zzb.zzb(zzcg.zzb(23, 14, billingResultZza), this.zzc);
        }
        this.zza.onAlternativeBillingOnlyAvailabilityResponse(billingResultZza);
    }
}
