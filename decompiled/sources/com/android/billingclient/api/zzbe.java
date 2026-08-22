package com.android.billingclient.api;

import android.os.Bundle;
import android.os.RemoteException;
import com.android.billingclient.api.BillingResult;
import org.json.JSONException;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbe extends com.google.android.gms.internal.play_billing.zzl {
    final BillingConfigResponseListener zza;
    final zzch zzb;
    final int zzc;

    /* synthetic */ zzbe(BillingConfigResponseListener billingConfigResponseListener, zzch zzchVar, int i, zzbl zzblVar) {
        this.zza = billingConfigResponseListener;
        this.zzb = zzchVar;
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.play_billing.zzm
    public final void zza(Bundle bundle) throws RemoteException {
        if (bundle == null) {
            this.zzb.zzb(zzcg.zzb(63, 13, zzcj.zzk), this.zzc);
            this.zza.onBillingConfigResponse(zzcj.zzk, null);
            return;
        }
        int iZzb = com.google.android.gms.internal.play_billing.zze.zzb(bundle, "BillingClient");
        String strZzh = com.google.android.gms.internal.play_billing.zze.zzh(bundle, "BillingClient");
        BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
        builderNewBuilder.setResponseCode(iZzb);
        builderNewBuilder.setDebugMessage(strZzh);
        if (iZzb != 0) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "getBillingConfig() failed. Response code: " + iZzb);
            BillingResult billingResultBuild = builderNewBuilder.build();
            this.zzb.zzb(zzcg.zzb(23, 13, billingResultBuild), this.zzc);
            this.zza.onBillingConfigResponse(billingResultBuild, null);
            return;
        }
        if (!bundle.containsKey("BILLING_CONFIG")) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "getBillingConfig() returned a bundle with neither an error nor a billing config response");
            builderNewBuilder.setResponseCode(6);
            BillingResult billingResultBuild2 = builderNewBuilder.build();
            this.zzb.zzb(zzcg.zzb(64, 13, billingResultBuild2), this.zzc);
            this.zza.onBillingConfigResponse(billingResultBuild2, null);
            return;
        }
        try {
            this.zza.onBillingConfigResponse(builderNewBuilder.build(), new BillingConfig(bundle.getString("BILLING_CONFIG")));
        } catch (JSONException e2) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "Got a JSON exception trying to decode BillingConfig. \n Exception: ", e2);
            this.zzb.zzb(zzcg.zzb(65, 13, zzcj.zzk), this.zzc);
            this.zza.onBillingConfigResponse(zzcj.zzk, null);
        }
    }
}
