package com.razorpay;

import android.webkit.JavascriptInterface;
import com.razorpay.CheckoutBridge;
import java.util.HashMap;

/* JADX INFO: loaded from: classes9.dex */
public class PluginCheckoutBridge extends CheckoutBridge {
    private final PluginCheckoutInteractor pluginCheckoutInteractor;

    @Override // com.razorpay.CheckoutBridge
    @JavascriptInterface
    public /* bridge */ /* synthetic */ void invokePopup(String str) {
        super.invokePopup(str);
    }

    @Override // com.razorpay.CheckoutBridge
    @JavascriptInterface
    public /* bridge */ /* synthetic */ void onCheckoutBackPress() {
        super.onCheckoutBackPress();
    }

    PluginCheckoutBridge(PluginCheckoutInteractor pluginCheckoutInteractor, int i) {
        super(pluginCheckoutInteractor, i);
        this.pluginCheckoutInteractor = pluginCheckoutInteractor;
    }

    @JavascriptInterface
    public void processPayment(final String str) {
        HashMap map = new HashMap();
        map.put("data", str);
        AnalyticsUtil.trackEvent(AnalyticsEvent.CHECKOUT_PLUGIN_PROCESS_PAYMENT_CALLED, AnalyticsUtil.getJSONResponse(map));
        super.isWebViewSafeOnUI(new CheckoutBridge.WebViewSafeCheckCallback() { // from class: com.razorpay.PluginCheckoutBridge.1
            @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
            public void unSecure() {
            }

            @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
            public void secure() {
                PluginCheckoutBridge.this.pluginCheckoutInteractor.processPayment(str);
            }
        });
    }

    @JavascriptInterface
    public void triggerExternalSdkFunc(final String str) {
        super.isWebViewSafeOnUI(new CheckoutBridge.WebViewSafeCheckCallback() { // from class: com.razorpay.PluginCheckoutBridge.2
            @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
            public void unSecure() {
            }

            @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
            public void secure() {
                PluginCheckoutBridge.this.pluginCheckoutInteractor.triggerExternalSdkFunc(str);
            }
        });
    }
}
