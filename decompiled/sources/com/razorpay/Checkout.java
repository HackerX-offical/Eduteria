package com.razorpay;

import android.app.Activity;
import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.facebook.internal.AnalyticsEvents;
import com.razorpay.AnalyticsProperty;
import com.razorpay.OpinionatedSoln;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class Checkout extends Fragment {
    static final String EVENT_CALLBACK_DNE = "dne";
    static final String EVENT_CALLBACK_THREW_ERROR = "threw_error";
    static final int EXTERNAL_WALLET = 4;
    public static final int INCOMPATIBLE_PLUGIN = 7;
    static final int INTEGRATION_ONE = 1;
    static final int INTEGRATION_THREE = 3;
    static final int INTEGRATION_TWO = 2;
    public static final int INVALID_OPTIONS = 3;
    public static final int MAGICX_REQUEST_CODE = 98001;
    public static final int MAGICX_RESPONSE_CODE = 99002;
    public static final int NETWORK_ERROR = 2;
    public static final int PAYMENT_CANCELED = 0;
    static final int PAYMENT_SUCCESS = 1;
    public static final int RZP_REQUEST_CODE = 62442;
    public static final int TLS_ERROR = 6;
    public static final int WEBVIEW_CREATION_FAILED = 8;
    public static volatile boolean isPreloadTriggered = false;
    private static PaymentData paymentData;
    private static Class<? extends Activity> sAddressWalletUpdateActivityClass;
    private static WeakReference<EventCallback> sEventCallback;
    private static long sPreloadAbortDuration;
    private static long sPreloadCompleteDuration;
    private static boolean sPreloadFailed;
    private static WebView sPreloadView;
    private static ArrayList<String> sSubscribedAnalyticsEvents;
    private int checkoutImage;
    private boolean disableFullScreen;
    private boolean isMethodOverridden;
    private String key;
    private Activity merchantActivity;
    private String merchantClassName;
    private JSONObject options;
    public UpiTurboCheckout upiTurbo;
    boolean isGlobalConfigLoaded = false;
    private PaymentResultListener paymentResultListenerFromClass = null;
    private PaymentResultWithDataListener paymentResultWithDataListenerFromClass = null;
    private ExternalWalletListener externalWalletListenerFromClass = null;

    public Checkout() {
        trackEvent(AnalyticsEvent.CHECKOUT_INITIALIZED, "timestamp", Long.valueOf(System.currentTimeMillis()));
    }

    public static Checkout getInstance(Context context) {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("Checkout", "getInstance", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            if (ConfigCheckout.getInstance().getPrefetchEnabled().booleanValue()) {
                CheckoutCacheManager.getInstance().startPrefetch(context);
            }
            if (ConfigCheckout.getInstance().getPreloadEnabled().booleanValue()) {
                preload(context);
            }
            trackEvent(AnalyticsEvent.CHECKOUT_INITIALIZED_GET_INSTANCE, "timestamp", Long.valueOf(System.currentTimeMillis()));
            AnalyticsUtil.logCheckoutFunctionExit("Checkout", "getInstance", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            return new Checkout();
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
            return new Checkout();
        }
    }

    public static class Builder {
        private Activity activity;
        private int builderCheckoutImage;
        private boolean builderDisableFullScreen;
        private String builderKey;
        private String color;
        private ArrayList<String> subscribedAnalyticsEvents = null;

        public Builder(Activity activity) {
            this.activity = activity;
        }

        public Builder() {
        }

        public Builder setKeyId(String str) {
            this.builderKey = str;
            return this;
        }

        public Builder setImage(int i) {
            this.builderCheckoutImage = i;
            return this;
        }

        public Builder disableFullscreen(boolean z) {
            this.builderDisableFullScreen = z;
            return this;
        }

        public Builder setColor(String str) {
            this.color = str;
            return this;
        }

        public Builder subscribeToAnalyticsEvents(ArrayList<String> arrayList) {
            this.subscribedAnalyticsEvents = arrayList;
            return this;
        }

        public Checkout build() {
            Checkout checkout = new Checkout();
            checkout.setFullScreenDisable(this.builderDisableFullScreen);
            checkout.setImage(this.builderCheckoutImage);
            String str = this.color;
            if (str != null) {
                checkout.setUpiTurbo(this.activity, str);
            } else {
                checkout.setUpiTurbo(this.activity);
            }
            String str2 = this.builderKey;
            if (str2 != null) {
                checkout.setKeyID(str2);
            }
            ArrayList<String> arrayList = this.subscribedAnalyticsEvents;
            if (arrayList != null) {
                checkout.setSubscribedAnalyticsEvents(arrayList);
            }
            return checkout;
        }
    }

    @Deprecated
    public final void setPublicKey(String str) {
        this.key = str;
    }

    public final Checkout upiTurbo(Activity activity) {
        this.upiTurbo = new UpiTurboCheckout(activity, "", null, null);
        return this;
    }

    public final void setHostedOptimizerConfig(JSONObject jSONObject) {
        this.isGlobalConfigLoaded = true;
        GlobalUrlConfig.initiate(jSONObject);
    }

    public final void setImage(int i) {
        this.checkoutImage = i;
    }

    public final void setUpiTurbo(Activity activity) {
        this.upiTurbo = new UpiTurboCheckout(activity, "", null, null);
    }

    public final void setUpiTurbo(Activity activity, String str) {
        this.upiTurbo = new UpiTurboCheckout(activity, "", str, null);
    }

    public final void setKeyID(String str) {
        setPublicKey(str);
        BaseUtils.apiKey = str;
    }

    public void setEventCallback(EventCallback eventCallback) {
        sEventCallback = eventCallback != null ? new WeakReference<>(eventCallback) : null;
    }

    static EventCallback getEventCallback() {
        WeakReference<EventCallback> weakReference = sEventCallback;
        if (weakReference == null) {
            return null;
        }
        EventCallback eventCallback = weakReference.get();
        if (eventCallback == null) {
            sEventCallback = null;
        }
        return eventCallback;
    }

    void setSubscribedAnalyticsEvents(ArrayList<String> arrayList) {
        sSubscribedAnalyticsEvents = arrayList;
    }

    static ArrayList<String> getSubscribedAnalyticsEvents() {
        return sSubscribedAnalyticsEvents;
    }

    public static void setAddressWalletUpdateHandler(Class<? extends Activity> cls) {
        sAddressWalletUpdateActivityClass = cls;
    }

    static Class<? extends Activity> getAddressWalletUpdateActivityClass() {
        return sAddressWalletUpdateActivityClass;
    }

    public final void setFullScreenDisable(boolean z) {
        this.disableFullScreen = z;
    }

    public final void open(final Activity activity, final JSONObject jSONObject) {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("Checkout", "open", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            if (OpinionatedSoln.INSTANCE.getBuildConfigValue(activity, "DEBUG") != null && !OpinionatedSoln.INSTANCE.getAlertShownForStatus() && !this.isGlobalConfigLoaded) {
                sdkCheckIntegrationInternal(activity, new OpinionatedSoln.DismissCallback() { // from class: com.razorpay.Checkout.1
                    @Override // com.razorpay.OpinionatedSoln.DismissCallback
                    public void alertDismissed() {
                        Checkout.this.openInternal(activity, jSONObject);
                    }
                });
            } else {
                openInternal(activity, jSONObject);
            }
            AnalyticsUtil.logCheckoutFunctionExit("Checkout", "open", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openInternal(Activity activity, JSONObject jSONObject) {
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("Checkout", "openInternal", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            if (TextUtils.isEmpty(this.key)) {
                this.key = BaseUtils.getKeyId(activity);
            } else {
                BaseUtils.apiKey = this.key;
            }
            ConfigCheckout.getAdvertisingIdFromUtil(activity);
            if (TextUtils.isEmpty(this.key)) {
                throw new RuntimeException("Please set your Razorpay API key in AndroidManifest.xml");
            }
            if (jSONObject == null || jSONObject.length() == 0) {
                throw new RuntimeException("Checkout options cannot be null or empty");
            }
            try {
                jSONObject.put("key", this.key);
            } catch (JSONException e2) {
                AnalyticsUtil.reportError(e2.getMessage(), "S2", e2.getMessage());
            }
            abortPreloadIfRequired(this.merchantActivity);
            this.options = jSONObject;
            this.merchantClassName = activity.getClass().getName();
            this.merchantActivity = activity;
            try {
                activity.getFragmentManager().beginTransaction().add(this, (String) null).commitAllowingStateLoss();
            } catch (IllegalStateException e3) {
                AnalyticsUtil.reportError("Checkout", "S2", e3.getMessage());
            }
            AnalyticsUtil.logCheckoutFunctionExit("Checkout", "openInternal", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
        } catch (Exception e4) {
            AnalyticsUtil.reportCaughtException(e4);
        }
    }

    static void trackEvent(AnalyticsEvent analyticsEvent, String str, Object obj) {
        HashMap map = new HashMap();
        map.put(str, obj);
        AnalyticsUtil.trackEvent(analyticsEvent, map);
    }

    public static void preload(Context context) {
        isPreloadTriggered = true;
        try {
            AnalyticsUtil.logCheckoutFunctionEntry("Checkout", "preload", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            trackEvent(AnalyticsEvent.CHECKOUT_PRELOAD_STARTED, "timestamp", Long.valueOf(System.currentTimeMillis()));
            sPreloadCompleteDuration = 0L;
            sPreloadAbortDuration = 0L;
            sPreloadFailed = false;
            Context applicationContext = context.getApplicationContext();
            try {
                WebView webView = new WebView(applicationContext);
                sPreloadView = webView;
                BaseUtils.setWebViewSettings(applicationContext, webView, false);
                sPreloadView.setWebViewClient(new WebViewClient() { // from class: com.razorpay.Checkout.2
                    long pageStartAt;

                    @Override // android.webkit.WebViewClient
                    public void onPageStarted(WebView webView2, String str, Bitmap bitmap) {
                        this.pageStartAt = System.nanoTime();
                        if (Checkout.sPreloadView != null) {
                            Checkout.sPreloadView.setTag(Long.valueOf(this.pageStartAt));
                            Logger.d("Preload started!");
                        } else {
                            Checkout.trackEvent(AnalyticsEvent.WEB_VIEW_UNEXPECTED_NULL, "error_location", "Checkout->Preload()->onPageStarted");
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView2, int i, String str, String str2) {
                        Logger.d("onReceivedError OLD while pre-loading!");
                        Checkout.failPreload();
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                        super.onReceivedError(webView2, webResourceRequest, webResourceError);
                        Logger.d("onReceivedError NEW while pre-loading!");
                        Checkout.failPreload();
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView2, String str) {
                        long jNanoTime = System.nanoTime();
                        if (!Checkout.sPreloadFailed) {
                            long unused = Checkout.sPreloadCompleteDuration = jNanoTime - this.pageStartAt;
                            Checkout.trackEvent(AnalyticsEvent.CHECKOUT_PRELOAD_COMPLETED, "timestamp", Long.valueOf(System.currentTimeMillis()));
                            Logger.d("Preload finished in " + BaseUtils.nanoTimeToSecondsString(Checkout.sPreloadCompleteDuration, 2) + " sec.");
                        }
                        Checkout.destroyPreloadView();
                    }
                });
                sPreloadView.setWebChromeClient(new WebChromeClient() { // from class: com.razorpay.Checkout.3
                    @Override // android.webkit.WebChromeClient
                    public void onProgressChanged(WebView webView2, int i) {
                        Logger.d("Preload progress: " + i);
                    }
                });
                sPreloadView.loadUrl("https://api.razorpay.com/v1/checkout/public");
                AnalyticsUtil.logCheckoutFunctionExit("Checkout", "preload", ConfigCheckout.getInstance().isVerboseLoggingEnabled());
            } catch (Throwable th) {
                AnalyticsUtil.reportCaughtException(th);
                trackEvent(AnalyticsEvent.CHECKOUT_PRELOAD_FAILED, "timestamp", Long.valueOf(System.currentTimeMillis()));
                sPreloadFailed = true;
            }
        } catch (Exception e2) {
            AnalyticsUtil.reportCaughtException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void failPreload() {
        trackEvent(AnalyticsEvent.CHECKOUT_PRELOAD_FAILED, "timestamp", Long.valueOf(System.currentTimeMillis()));
        sPreloadFailed = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void destroyPreloadView() {
        try {
            sPreloadView.stopLoading();
        } catch (Exception unused) {
        }
        sPreloadView = null;
    }

    private void abortPreloadIfRequired(Activity activity) {
        long jNanoTime = System.nanoTime();
        try {
            WebView webView = sPreloadView;
            if (webView != null) {
                sPreloadAbortDuration = jNanoTime - ((Long) webView.getTag()).longValue();
                StorageBridge storageBridge = new StorageBridge(activity);
                if (storageBridge.getString(BaseConstants.PRE_FETCHED_ACCOUNTS) == null) {
                    storageBridge.setString(BaseConstants.USE_PRE_FETECHED_ACCOUNTS, "false");
                }
                Logger.d("Preload aborted in " + BaseUtils.nanoTimeToSecondsString(sPreloadAbortDuration, 2) + " sec.");
                trackEvent(AnalyticsEvent.CHECKOUT_PRELOAD_ABORTED, "timestamp", Long.valueOf(System.currentTimeMillis()));
            }
        } catch (Exception unused) {
        }
        destroyPreloadView();
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.options != null) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(getActivity().getPackageName(), "com.razorpay.CheckoutActivity"));
            long j = sPreloadCompleteDuration;
            if (j > 0) {
                intent.putExtra("PRELOAD_COMPLETE_DURATION", j);
            } else {
                long j2 = sPreloadAbortDuration;
                if (j2 > 0) {
                    intent.putExtra("PRELOAD_ABORT_DURATION", j2);
                }
            }
            intent.putExtra("OPTIONS", this.options.toString());
            intent.putExtra("IMAGE", this.checkoutImage);
            intent.putExtra(CheckoutConstants.DISABLE_FULL_SCREEN, this.disableFullScreen);
            this.options = null;
            startActivityForResult(intent, RZP_REQUEST_CODE);
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 62442) {
            return;
        }
        if (this.merchantActivity == null) {
            this.merchantActivity = getActivity();
        }
        this.merchantClassName = this.merchantActivity.getClass().getName();
        String paymentResult = getPaymentResult(intent);
        if (paymentResult == null || TextUtils.isEmpty(paymentResult)) {
            paymentResult = BaseUtils.getGenericPaymentErrorResponse("Payment Error", BaseUtils.getInstance().getMetadata());
        } else if (paymentResult.contains(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED) && !paymentResult.contains("error")) {
            paymentResult = BaseUtils.getPaymentCancelledResponse(BaseUtils.getInstance().getMetadata());
        }
        trackOnActivityResultEvent(i2, paymentResult);
        createPaymentData(this.merchantActivity, paymentResult);
        if (i2 == 1) {
            handleOnSuccess();
        } else if (i2 == 4) {
            handleExternalWalletSelected();
        } else {
            handleOnError(i2, paymentResult);
        }
        try {
            getActivity().getFragmentManager().beginTransaction().remove(this).commit();
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S1", e2.getMessage());
        }
    }

    private void handleExternalWalletSelected() {
        ExternalWalletListener externalWalletListener = this.externalWalletListenerFromClass;
        if (externalWalletListener != null) {
            externalWalletListener.onExternalWalletSelected(paymentData.getExternalWallet(), paymentData);
            return;
        }
        if (getActivity() instanceof ExternalWalletListener) {
            try {
                ExternalWalletListener externalWalletListener2 = (ExternalWalletListener) getActivity();
                String externalWallet = paymentData.getExternalWallet();
                if (TextUtils.isEmpty(externalWallet)) {
                    return;
                }
                externalWalletListener2.onExternalWalletSelected(externalWallet, paymentData);
                AnalyticsUtil.trackEvent(AnalyticsEvent.MERCHANT_EXTERNAL_WALLET_SELECTED_CALLED);
                AnalyticsUtil.postData();
                return;
            } catch (Exception e2) {
                handleMerchantCallbackError(this.merchantActivity, 4, EVENT_CALLBACK_THREW_ERROR, e2);
                return;
            }
        }
        handleMerchantCallbackError(this.merchantActivity, 4, EVENT_CALLBACK_DNE, new Exception());
    }

    private void handleOnError(int i, String str) {
        this.isMethodOverridden = true;
        onError(i, str);
        if (this.isMethodOverridden) {
            trackIntegrationType(i, 1);
        }
    }

    private void handleOnSuccess() {
        String paymentId = paymentData.getPaymentId();
        if (paymentId != null) {
            this.isMethodOverridden = true;
            onSuccess(paymentId);
        }
        if (this.isMethodOverridden) {
            trackIntegrationType(1, 1);
        }
    }

    public void onSuccess(String str) {
        this.isMethodOverridden = false;
        if (handleOnSuccessViaInterface(str)) {
            return;
        }
        handleOnSuccessViaReflection(str);
    }

    public void onError(int i, String str) {
        this.isMethodOverridden = false;
        if (handleOnErrorViaInterface(i, str)) {
            return;
        }
        handleOnErrorViaReflection(i, str);
    }

    private void handleOnErrorViaReflection(int i, String str) {
        Method merchantClassMethod;
        try {
            merchantClassMethod = getMerchantClassMethod("onPaymentError", Integer.TYPE, String.class);
        } catch (Exception e2) {
            handleMerchantCallbackError(this.merchantActivity, i, EVENT_CALLBACK_DNE, e2);
            merchantClassMethod = null;
        }
        try {
            invokeMethod(merchantClassMethod, Integer.valueOf(i), str);
            trackIntegrationType(i, 2);
        } catch (Exception e3) {
            handleMerchantCallbackError(this.merchantActivity, i, EVENT_CALLBACK_THREW_ERROR, e3);
        }
    }

    private boolean handleOnErrorViaInterface(int i, String str) {
        PaymentResultListener paymentResultListener = this.paymentResultListenerFromClass;
        if (paymentResultListener != null) {
            paymentResultListener.onPaymentError(i, str);
            return true;
        }
        if (getActivity() instanceof PaymentResultListener) {
            try {
                ((PaymentResultListener) getActivity()).onPaymentError(i, str);
                trackIntegrationType(i, 3);
            } catch (Exception e2) {
                handleMerchantCallbackError(this.merchantActivity, i, EVENT_CALLBACK_THREW_ERROR, e2);
            }
            return true;
        }
        PaymentResultWithDataListener paymentResultWithDataListener = this.paymentResultWithDataListenerFromClass;
        if (paymentResultWithDataListener != null) {
            paymentResultWithDataListener.onPaymentError(i, str, paymentData);
            return true;
        }
        if (!(getActivity() instanceof PaymentResultWithDataListener)) {
            return false;
        }
        try {
            ((PaymentResultWithDataListener) getActivity()).onPaymentError(i, str, paymentData);
            trackIntegrationType(i, 3);
        } catch (Exception e3) {
            handleMerchantCallbackError(this.merchantActivity, i, EVENT_CALLBACK_THREW_ERROR, e3);
        }
        return true;
    }

    private boolean handleOnSuccessViaInterface(String str) {
        PaymentResultListener paymentResultListener = this.paymentResultListenerFromClass;
        if (paymentResultListener != null) {
            paymentResultListener.onPaymentSuccess(str);
            return true;
        }
        if (getActivity() instanceof PaymentResultListener) {
            try {
                ((PaymentResultListener) getActivity()).onPaymentSuccess(str);
                trackIntegrationType(1, 3);
            } catch (Exception e2) {
                handleMerchantCallbackError(this.merchantActivity, 1, EVENT_CALLBACK_THREW_ERROR, e2);
            }
            return true;
        }
        PaymentResultWithDataListener paymentResultWithDataListener = this.paymentResultWithDataListenerFromClass;
        if (paymentResultWithDataListener != null) {
            paymentResultWithDataListener.onPaymentSuccess(str, paymentData);
            return true;
        }
        if (!(getActivity() instanceof PaymentResultWithDataListener)) {
            return false;
        }
        try {
            ((PaymentResultWithDataListener) getActivity()).onPaymentSuccess(str, paymentData);
            trackIntegrationType(1, 3);
        } catch (Exception e3) {
            handleMerchantCallbackError(this.merchantActivity, 1, EVENT_CALLBACK_THREW_ERROR, e3);
        }
        return true;
    }

    private void handleOnSuccessViaReflection(String str) {
        Method merchantClassMethod;
        try {
            merchantClassMethod = getMerchantClassMethod("onPaymentSuccess", String.class);
        } catch (Exception e2) {
            handleMerchantCallbackError(this.merchantActivity, 1, EVENT_CALLBACK_DNE, e2);
            merchantClassMethod = null;
        }
        try {
            invokeMethod(merchantClassMethod, str);
            trackIntegrationType(1, 2);
        } catch (Exception e3) {
            handleMerchantCallbackError(this.merchantActivity, 1, EVENT_CALLBACK_THREW_ERROR, e3);
        }
    }

    private void invokeMethod(Method method, Object... objArr) throws Exception {
        if (method == null) {
            return;
        }
        method.invoke(this.merchantActivity, objArr);
    }

    private Method getMerchantClassMethod(String str, Class... clsArr) throws Exception {
        return Class.forName(this.merchantClassName).getMethod(str, clsArr);
    }

    private static void trackIntegrationType(int i, int i2) {
        try {
            HashMap map = new HashMap();
            map.put("integration_type", Integer.toString(i2));
            if (i == 1) {
                AnalyticsUtil.trackEvent(AnalyticsEvent.MERCHANT_ON_SUCCESS_CALLED, AnalyticsUtil.getJSONResponse(map));
            } else {
                AnalyticsUtil.trackEvent(AnalyticsEvent.MERCHANT_ON_ERROR_CALLED, AnalyticsUtil.getJSONResponse(map));
            }
            AnalyticsUtil.postData();
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S2", e2.getMessage());
        }
    }

    private static void trackOnActivityResultEvent(int i, String str) {
        try {
            AnalyticsUtil.addProperty("onActivityResult result", new AnalyticsProperty(str, AnalyticsProperty.Scope.ORDER));
            AnalyticsUtil.addProperty("onActivityResult resultCode", new AnalyticsProperty(String.valueOf(i), AnalyticsProperty.Scope.ORDER));
            if (i == 1) {
                AnalyticsUtil.trackEvent(AnalyticsEvent.CALLING_ON_SUCCESS);
            } else if (i == 4) {
                AnalyticsUtil.trackEvent(AnalyticsEvent.CALLING_EXTERNAL_WALLET_SELECTED);
            } else {
                AnalyticsUtil.trackEvent(AnalyticsEvent.CALLING_ON_ERROR);
            }
            AnalyticsUtil.postData();
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S2", e2.getMessage());
        }
    }

    private static void handleMerchantCallbackError(Activity activity, int i, String str, Exception exc) {
        String str2;
        String str3;
        if (i == 1) {
            str2 = "onPaymentSuccess";
            str3 = "success";
        } else if (i == 4) {
            str2 = "onExternalWalletSelected";
            str3 = "redirected";
        } else {
            str2 = "onPaymentError";
            str3 = "error";
        }
        try {
            HashMap map = new HashMap();
            map.put("event_details", exc.getMessage());
            map.put("event_type", exc.getMessage());
            map.put(com.tv9news.utils.helpers.AnalyticsConstants.payment_status, str3);
            AnalyticsUtil.trackEvent(AnalyticsEvent.HANDOVER_ERROR, AnalyticsUtil.getJSONResponse(map));
            AnalyticsUtil.postData();
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S0", e2.getMessage());
        }
        if (BaseUtils.isMerchantAppDebuggable(activity)) {
            if (!str.equals(EVENT_CALLBACK_DNE)) {
                if (str.equals(EVENT_CALLBACK_THREW_ERROR)) {
                    Toast.makeText(activity, "Your " + str2 + " method is throwing an error. Wrap the entire code of the method inside a try catch.", 0).show();
                }
            } else if (i == 4) {
                Toast.makeText(activity, "Error: ExternalWalletListener probably not implemented in your activity", 0).show();
            } else {
                Toast.makeText(activity, "Error: " + str2 + " probably not implemented in your activity", 0).show();
            }
        }
    }

    private static void createPaymentData(Activity activity, String str) {
        PaymentData paymentData2 = new PaymentData();
        paymentData = paymentData2;
        paymentData2.setUserContact(CheckoutUtils.getUserContact(activity));
        paymentData.setUserEmail(CheckoutUtils.getUserEmail(activity));
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optJSONObject("error") != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("error", jSONObject.getJSONObject("error"));
                JSONObject jSONObject3 = jSONObject.getJSONObject("error").getJSONObject("metadata");
                if (jSONObject3.has("payment_id")) {
                    paymentData.setPaymentId(jSONObject3.getString("payment_id"));
                }
                if (jSONObject3.has("order_id")) {
                    paymentData.setOrderId(jSONObject3.getString("order_id"));
                }
                paymentData.setData(jSONObject2);
            } else {
                paymentData.setData(jSONObject);
            }
            if (jSONObject.has("razorpay_payment_id")) {
                paymentData.setPaymentId(jSONObject.getString("razorpay_payment_id"));
            }
            if (jSONObject.has("razorpay_order_id")) {
                paymentData.setOrderId(jSONObject.getString("razorpay_order_id"));
            }
            if (jSONObject.has("razorpay_signature")) {
                paymentData.setSignature(jSONObject.getString("razorpay_signature"));
            }
            if (jSONObject.has("external_wallet")) {
                paymentData.setExternalWallet(jSONObject.getString("external_wallet"));
            }
        } catch (JSONException e2) {
            JSONObject jSONObject4 = new JSONObject();
            JSONObject jSONObject5 = new JSONObject();
            try {
                jSONObject5.put("code", "RESPONSE");
                jSONObject5.put("description", str);
                jSONObject4.put("error", jSONObject5);
            } catch (JSONException unused) {
            }
            AnalyticsUtil.reportError(e2.getMessage(), "S2", e2.getMessage());
        }
    }

    @Deprecated
    public static void handleActivityResult(Activity activity, int i, int i2, Intent intent, PaymentResultWithDataListener paymentResultWithDataListener, ExternalWalletListener externalWalletListener) {
        if (i != 62442) {
            return;
        }
        String paymentResult = getPaymentResult(intent);
        if (paymentResult == null || TextUtils.isEmpty(paymentResult)) {
            paymentResult = BaseUtils.getGenericPaymentErrorResponse("Payment Error", BaseUtils.getInstance().getMetadata());
        } else if (paymentResult.contains(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED) && !paymentResult.contains("error")) {
            paymentResult = BaseUtils.getPaymentCancelledResponse(BaseUtils.getInstance().getMetadata());
        }
        trackOnActivityResultEvent(i2, paymentResult);
        createPaymentData(activity, paymentResult);
        if (i2 == 1) {
            try {
                paymentResultWithDataListener.onPaymentSuccess(paymentData.getPaymentId(), paymentData);
                return;
            } catch (Exception e2) {
                handleMerchantCallbackError(activity, i2, EVENT_CALLBACK_THREW_ERROR, e2);
                return;
            }
        }
        if (i2 != 4) {
            try {
                paymentResultWithDataListener.onPaymentError(i2, paymentResult, paymentData);
                return;
            } catch (Exception e3) {
                handleMerchantCallbackError(activity, i2, EVENT_CALLBACK_THREW_ERROR, e3);
                return;
            }
        }
        if (externalWalletListener != null) {
            try {
                externalWalletListener.onExternalWalletSelected(paymentData.getExternalWallet(), paymentData);
            } catch (Exception e4) {
                handleMerchantCallbackError(activity, i2, EVENT_CALLBACK_THREW_ERROR, e4);
            }
        }
    }

    public void merchantActivityResult(Activity activity, int i, int i2, Intent intent, PaymentResultWithDataListener paymentResultWithDataListener, ExternalWalletListener externalWalletListener) {
        this.merchantActivity = activity;
        this.paymentResultWithDataListenerFromClass = paymentResultWithDataListener;
        this.externalWalletListenerFromClass = externalWalletListener;
        onActivityResult(i, i2, intent);
    }

    public void merchantActivityResult(Activity activity, int i, int i2, Intent intent, PaymentResultListener paymentResultListener, ExternalWalletListener externalWalletListener) {
        this.merchantActivity = activity;
        this.paymentResultListenerFromClass = paymentResultListener;
        this.externalWalletListenerFromClass = externalWalletListener;
        onActivityResult(i, i2, intent);
    }

    public static void clearUserData(Context context) {
        CheckoutUtils.clearUserData(context);
    }

    private static String getPaymentResult(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null) {
            return null;
        }
        return extras.getString("RESULT");
    }

    public static void sdkCheckIntegration(Activity activity) {
        OpinionatedSoln.INSTANCE.integrationStatusCheck(activity);
    }

    private void sdkCheckIntegrationInternal(Activity activity, OpinionatedSoln.DismissCallback dismissCallback) {
        OpinionatedSoln.INSTANCE.integrationStatusCheck(activity, dismissCallback);
    }

    public String builderTest() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", this.key);
            jSONObject.put("image", this.checkoutImage);
            jSONObject.put("disableFullScreen", this.disableFullScreen);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }
}
