package com.razorpay;

import com.razorpay.CheckoutBridge;

/* JADX INFO: loaded from: classes9.dex */
interface CheckoutInteractor {
    void callNativeIntent(String str, String str2);

    void checkSmsPermission();

    void getDownloadFileString(String str, String str2, String str3);

    String getGPayFOPs(Double d2);

    void getPdfString(String str, String str2);

    String getSdkPlugins();

    void invokePopup(String str);

    boolean isUserRegistered(String str);

    boolean isUserRegisteredOnUPI(String str);

    void isWebViewSafe(int i, CheckoutBridge.WebViewSafeCheckCallback webViewSafeCheckCallback);

    void isWebViewSafeOnUI(int i, CheckoutBridge.WebViewSafeCheckCallback webViewSafeCheckCallback);

    void onCheckoutBackPress();

    void onCheckoutRendered();

    void onComplete(String str);

    void onDismiss();

    void onDismiss(String str);

    void onError(String str);

    void onEvent(String str);

    void onFault(String str);

    void onLoad();

    void onRequestAction(String str);

    void onSubmit(String str);

    void redirectToNfcSettings();

    void registerSmsListener();

    void relay(String str);

    void requestExtraAnalyticsData();

    void requestOtpPermission();

    void sendDataToWebView(int i, String str);

    void setAppToken(String str);

    void setAttributes(String str);

    void setDeviceToken(String str);

    void setDimensions(int i, int i2);

    void setMerchantOptions(String str);

    void setPaymentID(String str);

    void showAlertDialog(String str, String str2, String str3);

    void toast(String str, int i);

    void triggerNfcCardScanner();

    void triggerPhoneNumberHintApi();

    void unregisterNfcScanner();

    void unregisterSmsListener();
}
