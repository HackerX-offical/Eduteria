package com.paytm.pgsdk;

/* JADX INFO: loaded from: classes9.dex */
public class SaveReferences {
    private static SaveReferences keepCallbackReference;
    private boolean isProduction;
    private PaytmPaymentTransactionCallback paytmPaymentTransactionCallback;

    private SaveReferences() {
    }

    public static synchronized SaveReferences getInstance() {
        if (keepCallbackReference == null) {
            keepCallbackReference = new SaveReferences();
        }
        return keepCallbackReference;
    }

    public PaytmPaymentTransactionCallback getPaytmPaymentTransactionCallback() {
        return this.paytmPaymentTransactionCallback;
    }

    public void setPaytmPaymentTransactionCallback(PaytmPaymentTransactionCallback paytmPaymentTransactionCallback) {
        this.paytmPaymentTransactionCallback = paytmPaymentTransactionCallback;
    }

    public boolean isProduction() {
        return this.isProduction;
    }

    public void setProduction(boolean z) {
        this.isProduction = z;
    }
}
