package com.razorpay;

import android.webkit.WebView;

/* JADX INFO: loaded from: classes9.dex */
interface AddOnPresenter {
    void onPageFinished(int i, WebView webView, String str);

    void onPageStarted(int i, WebView webView, String str);

    void onProgressChanges(int i, int i2);
}
