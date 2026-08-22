package com.razorpay;

import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes9.dex */
class SecondaryWebChromeClient extends WebChromeClient {
    CheckoutPresenter presenter;

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return false;
    }

    public SecondaryWebChromeClient(CheckoutPresenter checkoutPresenter) {
        this.presenter = checkoutPresenter;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        this.presenter.onProgressChanges(2, i);
    }
}
