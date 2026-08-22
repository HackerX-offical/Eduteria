package com.android.billingclient.api;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.android.billingclient.api.BillingResult;
import com.google.android.gms.internal.play_billing.zzjo;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaw extends ResultReceiver {
    final /* synthetic */ AlternativeBillingOnlyInformationDialogListener zza;
    final /* synthetic */ BillingClientImpl zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzaw(BillingClientImpl billingClientImpl, Handler handler, AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener) {
        super(handler);
        this.zza = alternativeBillingOnlyInformationDialogListener;
        this.zzb = billingClientImpl;
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
        builderNewBuilder.setResponseCode(i);
        if (i != 0) {
            if (bundle == null) {
                this.zzb.zzbc(this.zza, zzcj.zzk, 73, null);
                return;
            } else {
                builderNewBuilder.setDebugMessage(com.google.android.gms.internal.play_billing.zze.zzh(bundle, "BillingClient"));
                int i2 = bundle.getInt("INTERNAL_LOG_ERROR_REASON");
                this.zzb.zzaF(zzcg.zzc(i2 != 0 ? zzjo.zza(i2) : 23, 16, builderNewBuilder.build(), bundle.getString("INTERNAL_LOG_ERROR_ADDITIONAL_DETAILS")));
            }
        }
        this.zza.onAlternativeBillingOnlyInformationDialogResponse(builderNewBuilder.build());
    }
}
