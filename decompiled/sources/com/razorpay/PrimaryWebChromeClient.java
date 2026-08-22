package com.razorpay;

import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import java.util.HashMap;

/* JADX INFO: loaded from: classes9.dex */
class PrimaryWebChromeClient extends WebChromeClient {
    CheckoutPresenter presenter;

    public PrimaryWebChromeClient(CheckoutPresenter checkoutPresenter) {
        this.presenter = checkoutPresenter;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        this.presenter.onProgressChanges(1, i);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage.messageLevel() != ConsoleMessage.MessageLevel.ERROR) {
            return false;
        }
        HashMap map = new HashMap();
        map.put("message", consoleMessage.message());
        map.put("source_id", consoleMessage.sourceId());
        map.put("line_number", String.valueOf(consoleMessage.lineNumber()));
        AnalyticsUtil.trackEvent(AnalyticsEvent.WEB_VIEW_JS_ERROR, AnalyticsUtil.getJSONResponse(map));
        Logger.e("Webview JS Error: " + consoleMessage.message());
        return false;
    }
}
