package com.razorpay;

/* JADX INFO: loaded from: classes9.dex */
public interface PaymentResultWithDataListener {
    void onPaymentError(int i, String str, PaymentData paymentData);

    void onPaymentSuccess(String str, PaymentData paymentData);
}
