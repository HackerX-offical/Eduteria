package com.android.billingclient.api;

import android.os.Bundle;
import android.os.RemoteException;
import org.json.JSONException;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbc extends com.google.android.gms.internal.play_billing.zzh {
    final ExternalOfferReportingDetailsListener zza;
    final zzch zzb;
    final int zzc;

    /* synthetic */ zzbc(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener, zzch zzchVar, int i, zzbl zzblVar) {
        this.zza = externalOfferReportingDetailsListener;
        this.zzb = zzchVar;
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.play_billing.zzi
    public final void zza(Bundle bundle) throws RemoteException {
        if (bundle == null) {
            this.zzb.zzb(zzcg.zzb(95, 24, zzcj.zzk), this.zzc);
            this.zza.onExternalOfferReportingDetailsResponse(zzcj.zzk, null);
            return;
        }
        int iZzb = com.google.android.gms.internal.play_billing.zze.zzb(bundle, "BillingClient");
        BillingResult billingResultZza = zzcj.zza(iZzb, com.google.android.gms.internal.play_billing.zze.zzh(bundle, "BillingClient"));
        if (iZzb != 0) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "createExternalOfferReportingDetailsAsync() failed. Response code: " + iZzb);
            this.zzb.zzb(zzcg.zzb(23, 24, billingResultZza), this.zzc);
            this.zza.onExternalOfferReportingDetailsResponse(billingResultZza, null);
            return;
        }
        try {
            this.zza.onExternalOfferReportingDetailsResponse(billingResultZza, new ExternalOfferReportingDetails(bundle.getString("CREATE_EXTERNAL_PAYMENT_REPORTING_DETAILS")));
        } catch (JSONException e2) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "Error when parsing invalid external offer reporting details. \n Exception: ", e2);
            this.zzb.zzb(zzcg.zzb(104, 24, zzcj.zzk), this.zzc);
            this.zza.onExternalOfferReportingDetailsResponse(zzcj.zzk, null);
        }
    }
}
