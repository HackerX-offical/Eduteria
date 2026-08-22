package com.razorpay;

import android.webkit.JavascriptInterface;

/* JADX INFO: loaded from: classes9.dex */
class CheckoutBridge {
    private String integratedPlugin;
    CheckoutInteractor interactor;
    private boolean isRegistered = true;
    private int webViewType;

    interface WebViewSafeCheckCallback {
        void secure();

        void unSecure();
    }

    CheckoutBridge(CheckoutInteractor checkoutInteractor, int i) {
        this.interactor = checkoutInteractor;
        this.webViewType = i;
    }

    @JavascriptInterface
    public final void onload() {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("CheckoutBridge", "onload", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            isWebViewSafeOnUI(new WebViewSafeCheckCallback() { // from class: com.razorpay.CheckoutBridge.1
                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void unSecure() {
                }

                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void secure() {
                    CheckoutBridge.this.interactor.onLoad();
                }
            });
            AnalyticsUtil.logCheckoutFunctionExit("CheckoutBridge", "onload", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
        }
    }

    @JavascriptInterface
    public void invokePopup(final String str) {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("CheckoutBridge", "invokePopup", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            this.interactor.invokePopup(str);
            isWebViewSafeOnUI(new WebViewSafeCheckCallback() { // from class: com.razorpay.CheckoutBridge.2
                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void unSecure() {
                }

                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void secure() {
                    CheckoutBridge.this.interactor.invokePopup(str);
                }
            });
            AnalyticsUtil.logCheckoutFunctionExit("CheckoutBridge", "invokePopup", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
        }
    }

    @JavascriptInterface
    public void onCheckoutBackPress() {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("CheckoutBridge", "onCheckoutBackPress", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            isWebViewSafeOnUI(new WebViewSafeCheckCallback() { // from class: com.razorpay.CheckoutBridge.3
                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void unSecure() {
                }

                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void secure() {
                    CheckoutBridge.this.interactor.onCheckoutBackPress();
                }
            });
            AnalyticsUtil.logCheckoutFunctionExit("CheckoutBridge", "onCheckoutBackPress", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
        }
    }

    @JavascriptInterface
    public final void setAppToken(final String str) {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("CheckoutBridge", "setAppToken", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            this.interactor.setAppToken(str);
            isWebViewSafeOnUI(new WebViewSafeCheckCallback() { // from class: com.razorpay.CheckoutBridge.4
                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void unSecure() {
                }

                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void secure() {
                    CheckoutBridge.this.interactor.setAppToken(str);
                }
            });
            AnalyticsUtil.logCheckoutFunctionExit("CheckoutBridge", "setAppToken", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
        }
    }

    @JavascriptInterface
    public final void getDownloadFileString(final String str, final String str2, final String str3) {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("CheckoutBridge", "getDownloadFileString", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            isWebViewSafeOnUI(new WebViewSafeCheckCallback() { // from class: com.razorpay.CheckoutBridge.5
                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void unSecure() {
                }

                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void secure() {
                    CheckoutBridge.this.interactor.getDownloadFileString(str2, str, str3);
                }
            });
            AnalyticsUtil.logCheckoutFunctionExit("CheckoutBridge", "getDownloadFileString", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
        }
    }

    @JavascriptInterface
    public final void setDeviceToken(final String str) {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("CheckoutBridge", "setDeviceToken", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            isWebViewSafeOnUI(new WebViewSafeCheckCallback() { // from class: com.razorpay.CheckoutBridge.6
                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void unSecure() {
                }

                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void secure() {
                    CheckoutBridge.this.interactor.setDeviceToken(str);
                }
            });
            AnalyticsUtil.logCheckoutFunctionExit("CheckoutBridge", "setDeviceToken", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
        }
    }

    @JavascriptInterface
    public final void callNativeIntent(final String str) {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("CheckoutBridge", "callNativeIntent(String)", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            isWebViewSafeOnUI(new WebViewSafeCheckCallback() { // from class: com.razorpay.CheckoutBridge.7
                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void unSecure() {
                }

                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void secure() {
                    CheckoutBridge.this.interactor.callNativeIntent(str, null);
                }
            });
            AnalyticsUtil.logCheckoutFunctionExit("CheckoutBridge", "callNativeIntent(String)", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
        }
    }

    @JavascriptInterface
    public final void callNativeIntent(final String str, final String str2) {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("CheckoutBridge", "callNativeIntent(String,String)", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            isWebViewSafeOnUI(new WebViewSafeCheckCallback() { // from class: com.razorpay.CheckoutBridge.8
                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void unSecure() {
                }

                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void secure() {
                    CheckoutBridge.this.interactor.callNativeIntent(str, str2);
                }
            });
            AnalyticsUtil.logCheckoutFunctionExit("CheckoutBridge", "callNativeIntent(String,String)", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
        }
    }

    @JavascriptInterface
    public final void setPaymentID(final String str) {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("CheckoutBridge", "setPaymentID", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            isWebViewSafeOnUI(new WebViewSafeCheckCallback() { // from class: com.razorpay.CheckoutBridge.9
                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void unSecure() {
                }

                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void secure() {
                    CheckoutBridge.this.interactor.setPaymentID(str);
                }
            });
            AnalyticsUtil.logCheckoutFunctionExit("CheckoutBridge", "setPaymentID", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
        }
    }

    @JavascriptInterface
    public final void setMerchantOptions(final String str) {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("CheckoutBridge", "setMerchantOptions", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            isWebViewSafeOnUI(new WebViewSafeCheckCallback() { // from class: com.razorpay.CheckoutBridge.10
                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void unSecure() {
                }

                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void secure() {
                    CheckoutBridge.this.interactor.setMerchantOptions(str);
                }
            });
            AnalyticsUtil.logCheckoutFunctionExit("CheckoutBridge", "setMerchantOptions", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
        }
    }

    @JavascriptInterface
    public final void onsubmit(final String str) {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("CheckoutBridge", "onsubmit", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            isWebViewSafeOnUI(new WebViewSafeCheckCallback() { // from class: com.razorpay.CheckoutBridge.11
                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void unSecure() {
                }

                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void secure() {
                    CheckoutBridge.this.interactor.onSubmit(str);
                }
            });
            AnalyticsUtil.logCheckoutFunctionExit("CheckoutBridge", "onsubmit", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
        }
    }

    @JavascriptInterface
    public final void onfault(final String str) {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("CheckoutBridge", "onfault", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            isWebViewSafeOnUI(new WebViewSafeCheckCallback() { // from class: com.razorpay.CheckoutBridge.12
                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void unSecure() {
                }

                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void secure() {
                    CheckoutBridge.this.interactor.onFault(str);
                }
            });
            AnalyticsUtil.logCheckoutFunctionExit("CheckoutBridge", "onfault", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
        }
    }

    @JavascriptInterface
    public final void oncomplete(final String str) {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("CheckoutBridge", "oncomplete", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            isWebViewSafeOnUI(new WebViewSafeCheckCallback() { // from class: com.razorpay.CheckoutBridge.13
                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void unSecure() {
                }

                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void secure() {
                    CheckoutBridge.this.interactor.onComplete(str);
                }
            });
            AnalyticsUtil.logCheckoutFunctionExit("CheckoutBridge", "oncomplete", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
        }
    }

    @JavascriptInterface
    public final void setDimensions(final int i, final int i2) {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("CheckoutBridge", "setDimensions", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            isWebViewSafeOnUI(new WebViewSafeCheckCallback() { // from class: com.razorpay.CheckoutBridge.14
                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void unSecure() {
                }

                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void secure() {
                    CheckoutBridge.this.interactor.setDimensions(i, i2);
                }
            });
            AnalyticsUtil.logCheckoutFunctionExit("CheckoutBridge", "setDimensions", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
        }
    }

    @JavascriptInterface
    public final void ondismiss() {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("CheckoutBridge", "ondismiss", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            isWebViewSafeOnUI(new WebViewSafeCheckCallback() { // from class: com.razorpay.CheckoutBridge.15
                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void unSecure() {
                }

                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void secure() {
                    CheckoutBridge.this.interactor.onDismiss();
                }
            });
            AnalyticsUtil.logCheckoutFunctionExit("CheckoutBridge", "ondismiss", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
        }
    }

    @JavascriptInterface
    public final void ondismiss(final String str) {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("CheckoutBridge", "ondismiss(String)", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            isWebViewSafeOnUI(new WebViewSafeCheckCallback() { // from class: com.razorpay.CheckoutBridge.16
                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void unSecure() {
                }

                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void secure() {
                    CheckoutBridge.this.interactor.onDismiss(str);
                }
            });
            AnalyticsUtil.logCheckoutFunctionExit("CheckoutBridge", "ondismiss(String)", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
        }
    }

    @JavascriptInterface
    public final void requestExtraAnalyticsData() {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("CheckoutBridge", "requestExtraAnalyticsData", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            isWebViewSafeOnUI(new WebViewSafeCheckCallback() { // from class: com.razorpay.CheckoutBridge.17
                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void unSecure() {
                }

                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void secure() {
                    CheckoutBridge.this.interactor.requestExtraAnalyticsData();
                }
            });
            AnalyticsUtil.logCheckoutFunctionExit("CheckoutBridge", "requestExtraAnalyticsData", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
        }
    }

    @JavascriptInterface
    public final void onerror(final String str) {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("CheckoutBridge", "onerror", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            isWebViewSafeOnUI(new WebViewSafeCheckCallback() { // from class: com.razorpay.CheckoutBridge.18
                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void unSecure() {
                }

                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void secure() {
                    CheckoutBridge.this.interactor.onError(str);
                }
            });
            AnalyticsUtil.logCheckoutFunctionExit("CheckoutBridge", "onerror", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
        }
    }

    @JavascriptInterface
    public final boolean isUserRegisteredOnUPI(final String str) {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("CheckoutBridge", "isUserRegisteredOnUPI", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            isWebViewSafe(new WebViewSafeCheckCallback() { // from class: com.razorpay.CheckoutBridge.19
                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void unSecure() {
                }

                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void secure() {
                    CheckoutBridge checkoutBridge = CheckoutBridge.this;
                    checkoutBridge.isRegistered = checkoutBridge.interactor.isUserRegisteredOnUPI(str);
                }
            });
            AnalyticsUtil.logCheckoutFunctionExit("CheckoutBridge", "isUserRegisteredOnUPI", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            return this.isRegistered;
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
            return false;
        }
    }

    @JavascriptInterface
    public final boolean isUserRegistered(final String str) {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("CheckoutBridge", "isUserRegistered", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            isWebViewSafe(new WebViewSafeCheckCallback() { // from class: com.razorpay.CheckoutBridge.20
                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void unSecure() {
                }

                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void secure() {
                    CheckoutBridge checkoutBridge = CheckoutBridge.this;
                    checkoutBridge.isRegistered = checkoutBridge.interactor.isUserRegistered(str);
                }
            });
            AnalyticsUtil.logCheckoutFunctionExit("CheckoutBridge", "isUserRegistered", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            return this.isRegistered;
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
            return false;
        }
    }

    @JavascriptInterface
    public final void relay(final String str) {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("CheckoutBridge", "relay", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            isWebViewSafeOnUI(new WebViewSafeCheckCallback() { // from class: com.razorpay.CheckoutBridge.21
                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void unSecure() {
                }

                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void secure() {
                    CheckoutBridge.this.interactor.sendDataToWebView(2, str);
                }
            });
            AnalyticsUtil.logCheckoutFunctionExit("CheckoutBridge", "relay", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
        }
    }

    @JavascriptInterface
    public final void toast(final String str, final int i) {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("CheckoutBridge", "toast", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            isWebViewSafeOnUI(new WebViewSafeCheckCallback() { // from class: com.razorpay.CheckoutBridge.22
                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void unSecure() {
                }

                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void secure() {
                    CheckoutBridge.this.interactor.toast(str, i);
                }
            });
            AnalyticsUtil.logCheckoutFunctionExit("CheckoutBridge", "toast", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
        }
    }

    @JavascriptInterface
    public final void showAlertDialog(final String str, final String str2, final String str3) {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("CheckoutBridge", "showAlertDialog", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            isWebViewSafeOnUI(new WebViewSafeCheckCallback() { // from class: com.razorpay.CheckoutBridge.23
                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void unSecure() {
                }

                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void secure() {
                    CheckoutBridge.this.interactor.showAlertDialog(str, str2, str3);
                }
            });
            AnalyticsUtil.logCheckoutFunctionExit("CheckoutBridge", "showAlertDialog", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
        }
    }

    @JavascriptInterface
    public final String getSdkPlugins() {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("CheckoutBridge", "getSdkPlugins", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            isWebViewSafe(new WebViewSafeCheckCallback() { // from class: com.razorpay.CheckoutBridge.24
                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void unSecure() {
                }

                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void secure() {
                    CheckoutBridge checkoutBridge = CheckoutBridge.this;
                    checkoutBridge.integratedPlugin = checkoutBridge.interactor.getSdkPlugins();
                }
            });
            AnalyticsUtil.logCheckoutFunctionExit("CheckoutBridge", "getSdkPlugins", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            return this.integratedPlugin;
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
            return null;
        }
    }

    void isWebViewSafeOnUI(WebViewSafeCheckCallback webViewSafeCheckCallback) {
        this.interactor.isWebViewSafeOnUI(this.webViewType, webViewSafeCheckCallback);
    }

    void isWebViewSafe(WebViewSafeCheckCallback webViewSafeCheckCallback) {
        this.interactor.isWebViewSafe(this.webViewType, webViewSafeCheckCallback);
    }

    @JavascriptInterface
    public final void onCheckoutRendered() {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("CheckoutBridge", "onCheckoutRendered", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            isWebViewSafe(new WebViewSafeCheckCallback() { // from class: com.razorpay.CheckoutBridge.25
                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void unSecure() {
                }

                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void secure() {
                    CheckoutBridge.this.interactor.onCheckoutRendered();
                }
            });
            AnalyticsUtil.logCheckoutFunctionExit("CheckoutBridge", "onCheckoutRendered", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
        }
    }

    @JavascriptInterface
    public final void getPdfString(final String str, final String str2) {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("CheckoutBridge", "getPdfString", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            isWebViewSafe(new WebViewSafeCheckCallback() { // from class: com.razorpay.CheckoutBridge.26
                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void unSecure() {
                }

                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void secure() {
                    CheckoutBridge.this.interactor.getPdfString(str, str2);
                }
            });
            AnalyticsUtil.logCheckoutFunctionExit("CheckoutBridge", "getPdfString", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
        }
    }

    @JavascriptInterface
    public final void registerSmsListener() {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("CheckoutBridge", "registerSmsListener", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            isWebViewSafe(new WebViewSafeCheckCallback() { // from class: com.razorpay.CheckoutBridge.27
                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void unSecure() {
                }

                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void secure() {
                    CheckoutBridge.this.interactor.registerSmsListener();
                }
            });
            AnalyticsUtil.logCheckoutFunctionExit("CheckoutBridge", "registerSmsListener", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
        }
    }

    @JavascriptInterface
    public final void unregisterSmsListener() {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("CheckoutBridge", "unregisterSmsListener", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            isWebViewSafe(new WebViewSafeCheckCallback() { // from class: com.razorpay.CheckoutBridge.28
                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void unSecure() {
                }

                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void secure() {
                    CheckoutBridge.this.interactor.unregisterSmsListener();
                }
            });
            AnalyticsUtil.logCheckoutFunctionExit("CheckoutBridge", "unregisterSmsListener", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
        }
    }

    @JavascriptInterface
    public final String getGPayFOPs(final String str) {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("CheckoutBridge", "getGPayFOPs", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            final String[] strArr = {null};
            isWebViewSafe(new WebViewSafeCheckCallback() { // from class: com.razorpay.CheckoutBridge.29
                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void unSecure() {
                }

                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void secure() {
                    strArr[0] = CheckoutBridge.this.interactor.getGPayFOPs(Double.valueOf(Double.parseDouble(str)));
                    AnalyticsUtil.trackEvent(AnalyticsEvent.GPAY_IN_A_BOX_GET_PAYMENT_FOPS_COMPLETED);
                }
            });
            AnalyticsUtil.logCheckoutFunctionExit("CheckoutBridge", "getGPayFOPs", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            return strArr[0];
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
            return null;
        }
    }

    @JavascriptInterface
    public final void setAttributes(String str) {
        this.interactor.setAttributes(str);
    }

    @JavascriptInterface
    public final void triggerPhoneNumberHintApi() {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("CheckoutBridge", "triggerPhoneNumberHintApi", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            AnalyticsUtil.trackEvent(AnalyticsEvent.PHONE_NUMBER_HINT_TRIGGERED);
            isWebViewSafe(new WebViewSafeCheckCallback() { // from class: com.razorpay.CheckoutBridge.30
                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void unSecure() {
                }

                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void secure() {
                    CheckoutBridge.this.interactor.triggerPhoneNumberHintApi();
                }
            });
            AnalyticsUtil.logCheckoutFunctionExit("CheckoutBridge", "triggerPhoneNumberHintApi", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
        }
    }

    @JavascriptInterface
    public final void onmerchantevent(final String str) {
        isWebViewSafeOnUI(new WebViewSafeCheckCallback() { // from class: com.razorpay.CheckoutBridge.31
            @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
            public void unSecure() {
            }

            @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
            public void secure() {
                CheckoutBridge.this.interactor.onEvent(str);
            }
        });
    }

    @JavascriptInterface
    public final void onrequestaction(final String str) {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("CheckoutBridge", "onrequestaction", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            isWebViewSafeOnUI(new WebViewSafeCheckCallback() { // from class: com.razorpay.CheckoutBridge.32
                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void unSecure() {
                }

                @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
                public void secure() {
                    CheckoutBridge.this.interactor.onRequestAction(str);
                }
            });
            AnalyticsUtil.logCheckoutFunctionExit("CheckoutBridge", "onrequestaction", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
        }
    }

    @JavascriptInterface
    public final void registerNfcScanner() {
        isWebViewSafe(new WebViewSafeCheckCallback() { // from class: com.razorpay.CheckoutBridge.33
            @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
            public void unSecure() {
            }

            @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
            public void secure() {
                CheckoutBridge.this.interactor.triggerNfcCardScanner();
            }
        });
    }

    @JavascriptInterface
    public final void unregisterNfcScanner() {
        isWebViewSafe(new WebViewSafeCheckCallback() { // from class: com.razorpay.CheckoutBridge.34
            @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
            public void unSecure() {
            }

            @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
            public void secure() {
                CheckoutBridge.this.interactor.unregisterNfcScanner();
            }
        });
    }

    @JavascriptInterface
    public final void redirectToNfcSettings() {
        isWebViewSafe(new WebViewSafeCheckCallback() { // from class: com.razorpay.CheckoutBridge.35
            @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
            public void unSecure() {
            }

            @Override // com.razorpay.CheckoutBridge.WebViewSafeCheckCallback
            public void secure() {
                CheckoutBridge.this.interactor.redirectToNfcSettings();
            }
        });
    }
}
