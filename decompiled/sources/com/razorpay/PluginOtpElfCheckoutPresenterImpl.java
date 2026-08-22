package com.razorpay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.razorpay.BaseCheckoutActivity;
import com.razorpay.CheckoutBridge;
import com.razorpay.CheckoutPresenterImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jivesoftware.smackx.privacy.packet.PrivacyItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class PluginOtpElfCheckoutPresenterImpl extends OtpElfCheckoutPresenterImpl implements PluginCheckoutInteractor {
    private RzpPlugin extActiveRzpPluginInstance;
    private boolean isExtPluginFuncTriggered;
    private boolean isExtRzpPluginActive;
    private HashMap<String, String> pluginsMap;
    private final RzpInternalCallback rzpInternalCallback;

    @Override // com.razorpay.OtpElfCheckoutPresenterImpl, com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutPresenter
    public /* bridge */ /* synthetic */ void backPressed(Map map) {
        super.backPressed(map);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void callNativeIntent(String str, String str2) {
        super.callNativeIntent(str, str2);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void checkSmsPermission() {
        super.checkSmsPermission();
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutPresenter
    public /* bridge */ /* synthetic */ void cleanUpOnDestroy() {
        super.cleanUpOnDestroy();
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutPresenter
    public /* bridge */ /* synthetic */ void destroyActivity(int i, String str) {
        super.destroyActivity(i, str);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutPresenter
    public /* bridge */ /* synthetic */ void fetchCondfig() {
        super.fetchCondfig();
    }

    @Override // com.razorpay.CheckoutPresenterImpl
    public /* bridge */ /* synthetic */ void forwardEventToMerchant(String str) {
        super.forwardEventToMerchant(str);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutPresenter
    public /* bridge */ /* synthetic */ CheckoutOptions getCheckoutOptions() {
        return super.getCheckoutOptions();
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void getDownloadFileString(String str, String str2, String str3) {
        super.getDownloadFileString(str, str2, str3);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ String getGPayFOPs(Double d2) {
        return super.getGPayFOPs(d2);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void getPdfString(String str, String str2) {
        super.getPdfString(str, str2);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutPresenter
    public /* bridge */ /* synthetic */ String getProgressBarColor() {
        return super.getProgressBarColor();
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ String getSdkPlugins() {
        return super.getSdkPlugins();
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutPresenter
    public /* bridge */ /* synthetic */ List getWalletsWithAppToAppRedirection() {
        return super.getWalletsWithAppToAppRedirection();
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutPresenter
    public /* bridge */ /* synthetic */ void handleCardSaving() {
        super.handleCardSaving();
    }

    @Override // com.razorpay.CheckoutPresenterImpl
    public /* bridge */ /* synthetic */ void handleMerchantActivityResult(int i, Intent intent) {
        super.handleMerchantActivityResult(i, intent);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void invokePopup(String str) {
        super.invokePopup(str);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutPresenter
    public /* bridge */ /* synthetic */ boolean isAllowRotation() {
        return super.isAllowRotation();
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutPresenter
    public /* bridge */ /* synthetic */ boolean isMagicPresent() {
        return super.isMagicPresent();
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ boolean isUserRegistered(String str) {
        return super.isUserRegistered(str);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ boolean isUserRegisteredOnUPI(String str) {
        return super.isUserRegisteredOnUPI(str);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void isWebViewSafe(int i, CheckoutBridge.WebViewSafeCheckCallback webViewSafeCheckCallback) {
        super.isWebViewSafe(i, webViewSafeCheckCallback);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void isWebViewSafeOnUI(int i, CheckoutBridge.WebViewSafeCheckCallback webViewSafeCheckCallback) {
        super.isWebViewSafeOnUI(i, webViewSafeCheckCallback);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutPresenter
    public /* bridge */ /* synthetic */ void loadFetchedForm(String str, String str2) {
        super.loadFetchedForm(str, str2);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutPresenter
    public /* bridge */ /* synthetic */ void loadForm(String str) {
        super.loadForm(str);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void onCheckoutBackPress() {
        super.onCheckoutBackPress();
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void onCheckoutRendered() {
        super.onCheckoutRendered();
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void onComplete(String str) {
        super.onComplete(str);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void onDismiss() {
        super.onDismiss();
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void onDismiss(String str) {
        super.onDismiss(str);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void onError(String str) {
        super.onError(str);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void onEvent(String str) {
        super.onEvent(str);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void onFault(String str) {
        super.onFault(str);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void onLoad() {
        super.onLoad();
    }

    @Override // com.razorpay.OtpElfCheckoutPresenterImpl, com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutPresenter
    public /* bridge */ /* synthetic */ void onPageFinished(int i, WebView webView, String str) {
        super.onPageFinished(i, webView, str);
    }

    @Override // com.razorpay.OtpElfCheckoutPresenterImpl, com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutPresenter
    public /* bridge */ /* synthetic */ void onPageStarted(int i, WebView webView, String str) {
        super.onPageStarted(i, webView, str);
    }

    @Override // com.razorpay.OtpElfCheckoutPresenterImpl, com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutPresenter
    public /* bridge */ /* synthetic */ void onProgressChanges(int i, int i2) {
        super.onProgressChanges(i, i2);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void onRequestAction(String str) {
        super.onRequestAction(str);
    }

    @Override // com.razorpay.OtpElfCheckoutPresenterImpl, com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutPresenter
    public /* bridge */ /* synthetic */ void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutPresenter
    public /* bridge */ /* synthetic */ void onResumeTriggered() {
        super.onResumeTriggered();
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void onSubmit(String str) {
        super.onSubmit(str);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutPresenter
    public /* bridge */ /* synthetic */ void passPrefillToSegment() {
        super.passPrefillToSegment();
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void redirectToNfcSettings() {
        super.redirectToNfcSettings();
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void registerSmsListener() {
        super.registerSmsListener();
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void relay(String str) {
        super.relay(str);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void requestExtraAnalyticsData() {
        super.requestExtraAnalyticsData();
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void requestOtpPermission() {
        super.requestOtpPermission();
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutPresenter
    public /* bridge */ /* synthetic */ void saveInstanceState(Bundle bundle) {
        super.saveInstanceState(bundle);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void sendDataToWebView(int i, String str) {
        super.sendDataToWebView(i, str);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutPresenter
    public /* bridge */ /* synthetic */ void sendOtpPermissionCallback(boolean z) {
        super.sendOtpPermissionCallback(z);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void setAppToken(String str) {
        super.setAppToken(str);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void setAttributes(String str) {
        super.setAttributes(str);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutPresenter
    public /* bridge */ /* synthetic */ void setCheckoutLoadStartAt() {
        super.setCheckoutLoadStartAt();
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void setDeviceToken(String str) {
        super.setDeviceToken(str);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void setDimensions(int i, int i2) {
        super.setDimensions(i, i2);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutPresenter
    public /* bridge */ /* synthetic */ void setEventCallback(EventCallback eventCallback) {
        super.setEventCallback(eventCallback);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void setMerchantOptions(String str) {
        super.setMerchantOptions(str);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutPresenter
    public /* bridge */ /* synthetic */ boolean setOptions(Bundle bundle, boolean z) {
        return super.setOptions(bundle, z);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutPresenter
    public /* bridge */ /* synthetic */ void setOptionsWithDynamicUrl(Context context, Bundle bundle, boolean z, BaseCheckoutActivity.SetOptionsCallback setOptionsCallback) {
        super.setOptionsWithDynamicUrl(context, bundle, z, setOptionsCallback);
    }

    @Override // com.razorpay.OtpElfCheckoutPresenterImpl, com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void setPaymentID(String str) {
        super.setPaymentID(str);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutPresenter
    public /* bridge */ /* synthetic */ void setSubscribedAnalyticsEvents(ArrayList arrayList) {
        super.setSubscribedAnalyticsEvents(arrayList);
    }

    @Override // com.razorpay.OtpElfCheckoutPresenterImpl, com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutPresenter
    public /* bridge */ /* synthetic */ void setUpAddOn() {
        super.setUpAddOn();
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutPresenter
    public /* bridge */ /* synthetic */ boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void showAlertDialog(String str, String str2, String str3) {
        super.showAlertDialog(str, str2, str3);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutPresenter
    public /* bridge */ /* synthetic */ void showLoaderDialog(int i, String str) {
        super.showLoaderDialog(i, str);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutPresenter
    public /* bridge */ /* synthetic */ void showRetryDialog(int i, String str) {
        super.showRetryDialog(i, str);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void toast(String str, int i) {
        super.toast(str, i);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void triggerNfcCardScanner() {
        super.triggerNfcCardScanner();
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void triggerPhoneNumberHintApi() {
        super.triggerPhoneNumberHintApi();
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void unregisterNfcScanner() {
        super.unregisterNfcScanner();
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutPresenter
    public /* bridge */ /* synthetic */ void unregisterReceivers() {
        super.unregisterReceivers();
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutInteractor
    public /* bridge */ /* synthetic */ void unregisterSmsListener() {
        super.unregisterSmsListener();
    }

    public PluginOtpElfCheckoutPresenterImpl(Activity activity, CheckoutPresenterImpl.CheckoutView checkoutView, HashMap<String, String> map) {
        super(activity, checkoutView, map);
        this.isExtRzpPluginActive = false;
        this.isExtPluginFuncTriggered = false;
        this.rzpInternalCallback = new RzpInternalCallback() { // from class: com.razorpay.PluginOtpElfCheckoutPresenterImpl.1
            @Override // com.razorpay.RzpInternalCallback
            public void onPaymentSuccess(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("provider")) {
                        String string = jSONObject.getString("provider");
                        int iHashCode = string.hashCode();
                        if (iHashCode != -1307457359) {
                            if (iHashCode != -1048776318) {
                                if (iHashCode == 1839316877 && string.equals("UPI_TURBO")) {
                                    PluginOtpElfCheckoutPresenterImpl.this.sendExternalSdkResponse(jSONObject.toString());
                                }
                                PluginOtpElfCheckoutPresenterImpl.this.onComplete(jSONObject.toString());
                            } else {
                                if (string.equals("GOOGLE_PAY")) {
                                    PluginOtpElfCheckoutPresenterImpl.this.sendExternalSdkResponse(jSONObject.toString());
                                }
                                PluginOtpElfCheckoutPresenterImpl.this.onComplete(jSONObject.toString());
                            }
                        } else if (string.equals("GPAY_IN_A_BOX")) {
                            PluginOtpElfCheckoutPresenterImpl.this.sendExternalSdkResponse(jSONObject.toString());
                        } else {
                            PluginOtpElfCheckoutPresenterImpl.this.onComplete(jSONObject.toString());
                        }
                    }
                    AnalyticsUtil.trackEvent(AnalyticsEvent.CHECKOUT_PLUGIN_INTERNAL_CALLBACK_SUCCESS, AnalyticsUtil.getJSONResponse(str));
                } catch (JSONException unused) {
                    AnalyticsUtil.trackEvent(AnalyticsEvent.CHECKOUT_PLUGIN_INTERNAL_CALLBACK_ERROR);
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:19:0x0059, code lost:
            
                if (r0.equals("GPAY_IN_A_BOX") != false) goto L20;
             */
            @Override // com.razorpay.RzpInternalCallback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void onPaymentError(int r4, java.lang.String r5) {
                /*
                    r3 = this;
                    java.lang.String r0 = "provider"
                    java.util.HashMap r1 = new java.util.HashMap
                    r1.<init>()
                    java.lang.String r2 = "response"
                    r1.put(r2, r5)
                    java.lang.String r2 = "code"
                    java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                    r1.put(r2, r4)
                    com.razorpay.AnalyticsEvent r4 = com.razorpay.AnalyticsEvent.CHECKOUT_PLUGIN_INTERNAL_CALLBACK_ERROR
                    org.json.JSONObject r1 = com.razorpay.AnalyticsUtil.getJSONResponse(r1)
                    com.razorpay.AnalyticsUtil.trackEvent(r4, r1)
                    org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Exception -> L6f
                    r4.<init>(r5)     // Catch: java.lang.Exception -> L6f
                    boolean r1 = r4.has(r0)     // Catch: java.lang.Exception -> L6f
                    if (r1 == 0) goto L6e
                    java.lang.String r0 = r4.getString(r0)     // Catch: java.lang.Exception -> L6f
                    int r1 = r0.hashCode()     // Catch: java.lang.Exception -> L6f
                    r2 = -1307457359(0xffffffffb211c8b1, float:-8.485743E-9)
                    if (r1 == r2) goto L53
                    r2 = -1048776318(0xffffffffc17cf182, float:-15.808962)
                    if (r1 == r2) goto L4a
                    r2 = 1839316877(0x6da1bf8d, float:6.257332E27)
                    if (r1 == r2) goto L41
                    goto L65
                L41:
                    java.lang.String r1 = "UPI_TURBO"
                    boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L6f
                    if (r0 == 0) goto L65
                    goto L5b
                L4a:
                    java.lang.String r1 = "GOOGLE_PAY"
                    boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L6f
                    if (r0 == 0) goto L65
                    goto L5b
                L53:
                    java.lang.String r1 = "GPAY_IN_A_BOX"
                    boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L6f
                    if (r0 == 0) goto L65
                L5b:
                    com.razorpay.PluginOtpElfCheckoutPresenterImpl r0 = com.razorpay.PluginOtpElfCheckoutPresenterImpl.this     // Catch: java.lang.Exception -> L6f
                    java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L6f
                    r0.sendExternalSdkResponse(r4)     // Catch: java.lang.Exception -> L6f
                    return
                L65:
                    com.razorpay.PluginOtpElfCheckoutPresenterImpl r0 = com.razorpay.PluginOtpElfCheckoutPresenterImpl.this     // Catch: java.lang.Exception -> L6f
                    java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L6f
                    r0.onComplete(r4)     // Catch: java.lang.Exception -> L6f
                L6e:
                    return
                L6f:
                    com.razorpay.AnalyticsEvent r4 = com.razorpay.AnalyticsEvent.CHECKOUT_PLUGIN_INTERNAL_CALLBACK_ERROR_EXCEPTION
                    com.razorpay.AnalyticsUtil.trackEvent(r4)
                    com.razorpay.PluginOtpElfCheckoutPresenterImpl r4 = com.razorpay.PluginOtpElfCheckoutPresenterImpl.this
                    r4.onComplete(r5)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.razorpay.PluginOtpElfCheckoutPresenterImpl.AnonymousClass1.onPaymentError(int, java.lang.String):void");
            }
        };
        this.pluginsMap = map;
    }

    @Override // com.razorpay.PluginCheckoutInteractor
    public void triggerExternalSdkFunc(String str) {
        HashMap<String, String> map = this.pluginsMap;
        if (map == null || map.size() == 0) {
            return;
        }
        try {
            final JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("provider");
            if (string.hashCode() == 1839316877 && string.equals("UPI_TURBO") && jSONObject.getString("action").equalsIgnoreCase("LINK_NEW_ACCOUNT")) {
                AnalyticsUtil.trackEvent(AnalyticsEvent.TRIGGER_EXTERNAL_SDK_FUNC_LINK_CALLED);
                this.upiTurbo.linkNewUpiAccountCheckout(jSONObject.getJSONObject("data").optString("color"), jSONObject.getJSONObject("data").optString("amountInDisplayFormat"), new GenericPluginCallback() { // from class: com.razorpay.PluginOtpElfCheckoutPresenterImpl.2
                    @Override // com.razorpay.GenericPluginCallback
                    public void onSuccess(Object obj) {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("payload", obj);
                            jSONObject.put("data", jSONObject2);
                            PluginOtpElfCheckoutPresenterImpl.this.sendExternalSdkResponse(jSONObject.toString());
                        } catch (JSONException unused) {
                        }
                    }

                    @Override // com.razorpay.GenericPluginCallback
                    public void onError(JSONObject jSONObject2) {
                        try {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("error", jSONObject2);
                            jSONObject.put("data", jSONObject3);
                            PluginOtpElfCheckoutPresenterImpl.this.sendExternalSdkResponse(jSONObject.toString());
                        } catch (JSONException unused) {
                        }
                    }
                });
            }
        } catch (JSONException unused) {
        }
    }

    @Override // com.razorpay.PluginCheckoutInteractor
    public void processPayment(String str) {
        HashMap<String, String> map = this.pluginsMap;
        if (map == null || map.size() == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            HashMap map2 = new HashMap();
            map2.put("data", str);
            AnalyticsUtil.trackEvent(AnalyticsEvent.CHECKOUT_PLUGIN_CALLING_PROCESS_PAYMENT, AnalyticsUtil.getJSONResponse(map2));
            if (this.pluginsMap.containsKey("com.razorpay.plugin.googlepay_all") && this.pluginsMap.containsValue("com.razorpay.plugin.googlepay")) {
                this.pluginsMap.remove("com.razorpay.plugin.googlepay");
            }
            for (String str2 : this.pluginsMap.values()) {
                try {
                    RzpPlugin rzpPlugin = (RzpPlugin) RzpPlugin.class.getClassLoader().loadClass(str2).newInstance();
                    if (rzpPlugin.doesHandlePayload(this.merchantKey, jSONObject, this.activity)) {
                        this.isExtRzpPluginActive = true;
                        this.extActiveRzpPluginInstance = rzpPlugin;
                        if (str2.equalsIgnoreCase("com.razorpay.RazorpayTurbo")) {
                            JSONObject asJson = this.checkoutOptions.getAsJson();
                            asJson.put("apiResponse", jSONObject.getJSONObject("data").getJSONObject("apiResponse"));
                            asJson.put("upiAccount", jSONObject.getJSONObject("data").getJSONObject("upiAccount"));
                            asJson.put("apiPayload", jSONObject.getJSONObject("data").getJSONObject("apiPayload"));
                            rzpPlugin.processPayment(this.merchantKey, asJson, this.activity, this.rzpInternalCallback);
                        } else {
                            rzpPlugin.processPayment(this.merchantKey, jSONObject, this.activity, this.rzpInternalCallback);
                        }
                        return;
                    }
                    continue;
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | JSONException e2) {
                    AnalyticsUtil.reportError(getClass().getName(), "S0", e2.getLocalizedMessage());
                }
            }
        } catch (JSONException unused) {
            HashMap map3 = new HashMap();
            map3.put("data", str);
            AnalyticsUtil.trackEvent(AnalyticsEvent.CHECKOUT_PLUGIN_CALLING_PROCESS_PAYMENT_EXCEPTION, AnalyticsUtil.getJSONResponse(map3));
        }
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutPresenter
    public void sendExternalSdkResponse(String str) {
        AnalyticsUtil.trackEvent(AnalyticsEvent.SEND_EXTERNAL_SDK_RESPONSE);
        super.sendExternalSdkResponse(str);
    }

    @Override // com.razorpay.CheckoutPresenterImpl
    protected JSONObject getOptionsForHandleMessage() {
        JSONObject optionsForHandleMessage = super.getOptionsForHandleMessage();
        final JSONObject jSONObject = new JSONObject();
        try {
            boolean z = false;
            boolean z2 = false;
            for (final String str : this.pluginsMap.keySet()) {
                final int length = str.length();
                final int i = 20;
                String strSubstring = str.substring(20, length);
                int iHashCode = strSubstring.hashCode();
                if (iHashCode != -1863410739) {
                    if (iHashCode != 1474526159) {
                        if (iHashCode == 2134877489 && strSubstring.equals("googlepay_all")) {
                            try {
                                if (Class.forName("com.google.android.apps.nbu.paisa.inapp.client.api.PaymentsClient").newInstance() != null) {
                                    jSONObject.put("googlepay", true);
                                    z2 = true;
                                }
                            } catch (ClassNotFoundException unused) {
                                AnalyticsUtil.reportError(getClass().getName(), "S2", "GooglePay SDK is not included");
                            }
                        } else {
                            jSONObject.put(str.substring(20, length), true);
                        }
                    } else if (strSubstring.equals("googlepay")) {
                        jSONObject.put(str.substring(20, length), true);
                        z = true;
                    } else {
                        jSONObject.put(str.substring(20, length), true);
                    }
                } else if (strSubstring.equals("upi_turbo")) {
                    if (!this.isExtPluginFuncTriggered) {
                        this.isExtPluginFuncTriggered = true;
                        JSONObject jSONObject2 = this.integratedPluginsData;
                        if (jSONObject2.has("upiTurboData")) {
                            this.isExtPluginFuncTriggered = false;
                            Object obj = jSONObject2.get("upiTurboData");
                            if (obj instanceof JSONArray) {
                                jSONObject.put(str.substring(20, length), obj);
                            } else {
                                jSONObject.put(str.substring(20, length), new JSONArray());
                            }
                        } else {
                            this.upiTurbo.getLinkedUpiAccounts(new GenericPluginCallback() { // from class: com.razorpay.PluginOtpElfCheckoutPresenterImpl.3
                                @Override // com.razorpay.GenericPluginCallback
                                public void onSuccess(Object obj2) {
                                    try {
                                        PluginOtpElfCheckoutPresenterImpl.this.isExtPluginFuncTriggered = false;
                                        if (((JSONArray) obj2).length() == 0) {
                                            jSONObject.put(str.substring(i, length), new JSONArray());
                                        } else {
                                            jSONObject.put(str.substring(i, length), obj2);
                                        }
                                    } catch (JSONException unused2) {
                                    }
                                }

                                @Override // com.razorpay.GenericPluginCallback
                                public void onError(JSONObject jSONObject3) {
                                    try {
                                        PluginOtpElfCheckoutPresenterImpl.this.isExtPluginFuncTriggered = false;
                                        jSONObject.put(str.substring(i, length), new JSONArray());
                                    } catch (JSONException unused2) {
                                    }
                                }
                            }, null);
                        }
                    }
                } else {
                    jSONObject.put(str.substring(20, length), true);
                }
            }
            if (z && z2) {
                optionsForHandleMessage.put("googlepay_wrapper_version", PrivacyItem.SUBSCRIPTION_BOTH);
            } else if (z2) {
                optionsForHandleMessage.put("googlepay_wrapper_version", "2");
            }
            optionsForHandleMessage.put("external_sdks", jSONObject);
        } catch (Exception e2) {
            AnalyticsUtil.reportError(getClass().getName(), "S1", e2.getLocalizedMessage());
        }
        return optionsForHandleMessage;
    }

    @Override // com.razorpay.CheckoutPresenterImpl
    protected void onError(JSONObject jSONObject) {
        AnalyticsUtil.trackEvent(AnalyticsEvent.CHECKOUT_PLUGIN_ON_ERROR_CALLED, jSONObject);
        if (this.isExtRzpPluginActive) {
            this.view.loadUrl(1, String.format("javascript: window.onComplete(%s)", jSONObject.toString()));
            this.isExtRzpPluginActive = false;
            return;
        }
        super.onError(jSONObject);
    }

    @Override // com.razorpay.CheckoutPresenterImpl, com.razorpay.CheckoutPresenter
    public void onActivityResultReceived(int i, int i2, Intent intent) {
        if (this.isExtRzpPluginActive) {
            this.extActiveRzpPluginInstance.onActivityResult(this.merchantKey, i, i2, intent);
        } else {
            super.onActivityResultReceived(i, i2, intent);
        }
    }
}
