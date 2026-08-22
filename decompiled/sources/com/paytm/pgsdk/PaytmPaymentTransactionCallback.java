package com.paytm.pgsdk;

import android.os.Bundle;

/* JADX INFO: loaded from: classes9.dex */
public interface PaytmPaymentTransactionCallback {
    void clientAuthenticationFailed(String str);

    void networkNotAvailable();

    void onBackPressedCancelTransaction();

    void onErrorLoadingWebPage(int i, String str, String str2);

    void onErrorProceed(String str);

    void onTransactionCancel(String str, Bundle bundle);

    void onTransactionResponse(Bundle bundle);

    void someUIErrorOccurred(String str);
}
