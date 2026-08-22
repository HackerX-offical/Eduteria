package com.razorpay;

/* JADX INFO: loaded from: classes9.dex */
public interface PluginCheckoutInteractor extends CheckoutInteractor {
    void processPayment(String str);

    void sendExternalSdkResponse(String str);

    void triggerExternalSdkFunc(String str);
}
