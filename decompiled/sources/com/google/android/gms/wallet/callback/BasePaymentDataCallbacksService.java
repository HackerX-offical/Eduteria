package com.google.android.gms.wallet.callback;

import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.wallet.PaymentData;

/* JADX INFO: compiled from: com.google.android.gms:play-services-wallet@@18.1.3 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class BasePaymentDataCallbacksService extends zzd {
    protected abstract BasePaymentDataCallbacks createPaymentDataCallbacks();

    @Override // com.google.android.gms.wallet.callback.zzd, android.app.Service
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override // com.google.android.gms.wallet.callback.zzd, android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.google.android.gms.wallet.callback.zzd
    protected final void onRunTask(String str, CallbackInput callbackInput, OnCompleteListener<CallbackOutput> onCompleteListener) {
        if (callbackInput.getCallbackType() == 0) {
            throw new IllegalStateException("Callback Types must be set");
        }
        BasePaymentDataCallbacks basePaymentDataCallbacksCreatePaymentDataCallbacks = createPaymentDataCallbacks();
        if (callbackInput.getCallbackType() == 1) {
            basePaymentDataCallbacksCreatePaymentDataCallbacks.onPaymentAuthorized((PaymentData) callbackInput.deserializeRequest(PaymentData.CREATOR), new zze(onCompleteListener));
        } else {
            if (callbackInput.getCallbackType() != 2) {
                throw new IllegalStateException("Unknown Callback Types");
            }
            basePaymentDataCallbacksCreatePaymentDataCallbacks.onPaymentDataChanged((IntermediatePaymentData) callbackInput.deserializeRequest(IntermediatePaymentData.CREATOR), new zzf(onCompleteListener));
        }
    }
}
