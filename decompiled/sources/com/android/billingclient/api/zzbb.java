package com.android.billingclient.api;

import android.os.Bundle;
import android.os.RemoteException;
import org.json.JSONException;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbb extends com.google.android.gms.internal.play_billing.zzf {
    final AlternativeBillingOnlyReportingDetailsListener zza;
    final zzch zzb;
    final int zzc;

    /* synthetic */ zzbb(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener, zzch zzchVar, int i, zzbl zzblVar) {
        this.zza = alternativeBillingOnlyReportingDetailsListener;
        this.zzb = zzchVar;
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.play_billing.zzg
    public final void zza(Bundle bundle) throws RemoteException {
        if (bundle == null) {
            this.zzb.zzb(zzcg.zzb(71, 15, zzcj.zzk), this.zzc);
            this.zza.onAlternativeBillingOnlyTokenResponse(zzcj.zzk, null);
            return;
        }
        int iZzb = com.google.android.gms.internal.play_billing.zze.zzb(bundle, "BillingClient");
        BillingResult billingResultZza = zzcj.zza(iZzb, com.google.android.gms.internal.play_billing.zze.zzh(bundle, "BillingClient"));
        if (iZzb != 0) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "createAlternativeBillingOnlyReportingDetailsAsync() failed. Response code: " + iZzb);
            this.zzb.zzb(zzcg.zzb(23, 15, billingResultZza), this.zzc);
            this.zza.onAlternativeBillingOnlyTokenResponse(billingResultZza, null);
            return;
        }
        try {
            this.zza.onAlternativeBillingOnlyTokenResponse(billingResultZza, new AlternativeBillingOnlyReportingDetails(bundle.getString("CREATE_ALTERNATIVE_BILLING_ONLY_REPORTING_DETAILS")));
        } catch (JSONException e2) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "Error when parsing invalid alternative billing only reporting details. \n Exception: ", e2);
            this.zzb.zzb(zzcg.zzb(72, 15, zzcj.zzk), this.zzc);
            this.zza.onAlternativeBillingOnlyTokenResponse(zzcj.zzk, null);
        }
    }
}
