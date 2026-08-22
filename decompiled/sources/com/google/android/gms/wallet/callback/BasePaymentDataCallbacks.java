package com.google.android.gms.wallet.callback;

import com.google.android.gms.wallet.PaymentData;

/* JADX INFO: compiled from: com.google.android.gms:play-services-wallet@@18.1.3 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class BasePaymentDataCallbacks {
    protected void onPaymentAuthorized(PaymentData paymentData, OnCompleteListener<PaymentAuthorizationResult> onCompleteListener) {
    }

    protected void onPaymentDataChanged(IntermediatePaymentData intermediatePaymentData, OnCompleteListener<PaymentDataRequestUpdate> onCompleteListener) {
    }
}
