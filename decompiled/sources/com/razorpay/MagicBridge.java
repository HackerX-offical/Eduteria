package com.razorpay;

import android.webkit.JavascriptInterface;

/* JADX INFO: loaded from: classes9.dex */
public class MagicBridge {
    private CheckoutInteractor interactor;

    MagicBridge(CheckoutInteractor checkoutInteractor) {
        this.interactor = checkoutInteractor;
    }

    @JavascriptInterface
    public final void relay(String str) {
        this.interactor.sendDataToWebView(1, str);
    }
}
