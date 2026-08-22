package com.razorpay;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.pm.PackageManager;
import android.os.Build;
import android.view.inputmethod.InputMethodManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;
import com.appnew.android.Utils.Const;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.razorpay.AnalyticsProperty;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class RzpAssist implements SmsAgentInterface {
    private Activity activity;
    private OtpElfData elfData;
    String lastSms;
    private String merchantKey;
    String message;
    private long pageStartTime;
    private String paymentId;
    private String sdkType;
    private String sdkVersion;
    private int sdkVersionCode;
    String sender;
    private SmsAgent smsAgent;
    private WebView webview;
    private boolean hasOtpPermission = false;
    private String lastURL = "";
    private String currentLoadingUrl = "";
    private boolean isMagic = false;
    private boolean isRazorpayOtpReceived = false;
    private JSONObject otpElfPreferences = new JSONObject();
    private JSONObject paymentData = new JSONObject();
    private boolean isRzpAssistEnabled = false;
    private boolean otpRead = false;
    private boolean jsInsertedInCurrentPage = false;

    public RzpAssist(String str, Activity activity, WebView webView, String str2, int i, String str3) {
        this.sdkType = "standalone";
        if (CoreConfig.getInstance().isOTPElfEnabled().booleanValue()) {
            if (str == null || str.isEmpty()) {
                throw new RuntimeException("merchantKey cannot be null or empty");
            }
            this.sdkType = str2;
            this.sdkVersionCode = i;
            this.sdkVersion = str3;
            if (str2.equals("standalone") || str2.equalsIgnoreCase("standard") || str2.equalsIgnoreCase("custom")) {
                AnalyticsUtil.setup(activity, str, str2, i, str3);
            }
            this.webview = webView;
            this.merchantKey = str;
            this.activity = activity;
            OtpElfData otpElfData = new OtpElfData(activity);
            this.elfData = otpElfData;
            otpElfData.checkForUpdates();
            setup();
            AnalyticsUtil.addProperty("OTPElf Version", new AnalyticsProperty(BaseUtils.getLocalVersion(activity, OtpElfData.versionKey), AnalyticsProperty.Scope.ORDER));
        }
    }

    private void setup() {
        SmsAgent smsAgentInstance = SmsAgent.getSmsAgentInstance();
        this.smsAgent = smsAgentInstance;
        smsAgentInstance.registerForCallbacks(this);
        this.smsAgent.takeActionsIfPermissionsAreGranted(this.activity);
        this.webview.addJavascriptInterface(this, "OTPElfBridge");
        this.webview.getSettings().setUseWideViewPort(true);
    }

    final void enableMagic() {
        this.isMagic = true;
    }

    final void setPaymentData(JSONObject jSONObject) {
        this.paymentData = jSONObject;
    }

    public final void setOtpElfPreferences(JSONObject jSONObject) {
        this.otpElfPreferences = jSONObject;
    }

    public final void onPageFinished(WebView webView, String str) {
        AnalyticsUtil.trackPageLoadEnd(str, System.nanoTime() - this.pageStartTime);
        this.lastURL = str;
        this.currentLoadingUrl = "";
        if (CoreConfig.getInstance().isOTPElfEnabled().booleanValue() && !this.jsInsertedInCurrentPage) {
            handleJsInsertion();
            this.jsInsertedInCurrentPage = true;
        }
    }

    private void handleJsInsertion() {
        try {
            JSONObject oTPElfSettings = CoreConfig.getInstance().getOTPElfSettings();
            oTPElfSettings.put("merchant_key", this.merchantKey);
            oTPElfSettings.put("otp_permission", this.hasOtpPermission);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", this.sdkType);
            jSONObject.put("version", this.sdkVersion);
            jSONObject.put("platform", "android");
            jSONObject.put("framework", AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE);
            jSONObject.put("name", this.sdkType + "_android_native");
            oTPElfSettings.put(ServerProtocol.DIALOG_PARAM_SDK_VERSION, jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            if (!this.isMagic) {
                jSONObject2.put("type", "rzpassist");
                jSONObject2.put(Const.VERSION_CODE, ResourceUtils.getRzpAssistVersionCode());
            } else {
                jSONObject2.put("type", "magic");
                jSONObject2.put(Const.VERSION_CODE, ResourceUtils.getMagicVersionCode());
            }
            oTPElfSettings.put("plugin", jSONObject2);
            oTPElfSettings.put("payment_data", this.paymentData);
            oTPElfSettings.put("preferences", this.otpElfPreferences);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("package_name", this.activity.getApplicationContext().getPackageName());
            PackageManager packageManager = this.activity.getPackageManager();
            jSONObject3.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, AnalyticsUtil.returnUndefinedIfNull(packageManager.getPackageInfo(this.activity.getPackageName(), 0).applicationInfo.loadLabel(packageManager)));
            jSONObject3.put("platform", "mobile_sdk");
            jSONObject3.put("os", "android");
            jSONObject3.put("os_version", Build.VERSION.RELEASE);
            jSONObject3.put("data_network_type", BaseUtils.getDataNetworkType(this.activity).getNetworkTypeName());
            jSONObject3.put("framework", AnalyticsUtil.getFramework());
            jSONObject3.put("library", "standard");
            jSONObject3.put(ServerProtocol.DIALOG_PARAM_SDK_VERSION, jSONObject);
            oTPElfSettings.put("metadata", jSONObject3);
            injectJs("window.__rzp_options = " + oTPElfSettings.toString());
        } catch (Exception unused) {
        }
        injectJs(this.elfData.getOtpElfJs());
        AnalyticsUtil.trackEvent(AnalyticsEvent.OTPELF_INJECTED);
        String str = this.lastSms;
        if (str != null) {
            injectJs(String.format("OTPElf.showOTP('%s','%s')", str, this.sender));
            this.lastSms = null;
        }
    }

    public final void onProgressChanged(int i) {
        CoreConfig.getInstance().isOTPElfEnabled().booleanValue();
    }

    public final void onPageStarted(WebView webView, String str) {
        AnalyticsUtil.trackPageLoadStart(str);
        this.pageStartTime = System.nanoTime();
        this.currentLoadingUrl = str;
        this.jsInsertedInCurrentPage = false;
    }

    public final void paymentFlowEnd() {
        if (this.sdkType.equals("standalone")) {
            AnalyticsUtil.postData();
        }
        if (CoreConfig.getInstance().isOTPElfEnabled().booleanValue()) {
            this.smsAgent.removeSMSBroadcastReceiver(this.activity);
            this.smsAgent.deregisterForCallbacks(this);
        }
    }

    @Override // com.razorpay.SmsAgentInterface
    public final void postSms(String str, String str2) {
        if (this.isRzpAssistEnabled) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("sender", str);
                jSONObject.put("message", str2);
                this.sender = str;
                this.message = str2;
                this.lastSms = jSONObject.toString();
                injectJs(String.format("OTPElf.showOTP('%s','%s')", str2, str));
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.razorpay.SmsAgentInterface
    public final void setSmsPermission(boolean z) {
        setOTPEnabled(z);
    }

    final void setPaymentId(String str) {
        this.paymentId = str;
    }

    private void postStatsToAPI() {
        try {
            String strConstructBasicAuth = BaseUtils.constructBasicAuth(this.merchantKey);
            HashMap map = new HashMap();
            map.put("Authorization", "Basic " + strConstructBasicAuth);
            map.put("Content-Type", "application/json");
            if (this.paymentId == null) {
                return;
            }
            Owl.post("https://api.razorpay.com/v1/payments/" + this.paymentId + "/metadata", AutoOtpUtils.createStatsPayload(this.otpRead).toString(), map, new Callback() { // from class: com.razorpay.RzpAssist.1
                @Override // com.razorpay.Callback
                public void run(ResponseObject responseObject) {
                    responseObject.getResponseResult();
                }
            });
        } catch (Exception e2) {
            AnalyticsUtil.reportError("RzpAssist", "S0", e2.getMessage());
        }
    }

    private void injectJs(String str) {
        this.webview.loadUrl(String.format("javascript: %s", str));
    }

    final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.smsAgent.handleRequestPermissionsResult(this.activity, i, strArr, iArr);
    }

    final String getLastLoadedUrl() {
        return this.lastURL;
    }

    final String getCurrentLoadingUrl() {
        return this.currentLoadingUrl;
    }

    public final void reset() {
        postStatsToAPI();
        this.lastURL = "";
        this.currentLoadingUrl = "";
        this.otpRead = false;
    }

    final boolean isRazorpayOtpReceived() {
        return this.isRazorpayOtpReceived;
    }

    final void setOTPEnabled(boolean z) {
        this.hasOtpPermission = z;
        AnalyticsUtil.addProperty("otp_autoreading_access", new AnalyticsProperty(z, AnalyticsProperty.Scope.ORDER));
    }

    final void setRzpAssistEnabled(boolean z) {
        this.isRzpAssistEnabled = z;
    }

    @JavascriptInterface
    public final void setUseWideViewPort(final boolean z) {
        this.activity.runOnUiThread(new Runnable() { // from class: com.razorpay.RzpAssist.2
            @Override // java.lang.Runnable
            public void run() {
                RzpAssist.this.webview.getSettings().setUseWideViewPort(z);
            }
        });
    }

    @JavascriptInterface
    public final void openKeyboard() {
        this.activity.runOnUiThread(new Runnable() { // from class: com.razorpay.RzpAssist.3
            @Override // java.lang.Runnable
            public void run() {
                ((InputMethodManager) RzpAssist.this.activity.getSystemService("input_method")).showSoftInput(RzpAssist.this.webview, 0);
            }
        });
    }

    @JavascriptInterface
    public final void toast(final String str) {
        this.activity.runOnUiThread(new Runnable() { // from class: com.razorpay.RzpAssist.4
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(RzpAssist.this.activity, str, 1).show();
            }
        });
    }

    @JavascriptInterface
    public final void trackEvent(String str, String str2) {
        try {
            AnalyticsEvent analyticsEvent = AnalyticsEvent.JS_EVENT;
            analyticsEvent.setEventName(str);
            AnalyticsUtil.trackEvent(analyticsEvent, new JSONObject(str2));
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public final void trackEvent(String str) {
        AnalyticsEvent analyticsEvent = AnalyticsEvent.JS_EVENT;
        analyticsEvent.setEventName(str);
        AnalyticsUtil.trackEvent(analyticsEvent);
    }

    @JavascriptInterface
    public final void onOtpParsed(final String str) {
        this.activity.runOnUiThread(new Runnable() { // from class: com.razorpay.RzpAssist.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    OTP otp = new OTP(jSONObject.getString(Const.OTP), jSONObject.getString("sender"), jSONObject.getString("bank"));
                    HashMap map = new HashMap();
                    map.put("sender", otp.getSender());
                    if (otp.getSender().contains("RZRPAY")) {
                        RzpAssist.this.isRazorpayOtpReceived = true;
                        map.put("razorpay_otp", Boolean.TRUE);
                    } else {
                        map.put("razorpay_otp", Boolean.FALSE);
                        RzpAssist.this.otpRead = true;
                        AnalyticsUtil.addProperty("payment_otp_received", new AnalyticsProperty(true, AnalyticsProperty.Scope.PAYMENT));
                    }
                    AnalyticsUtil.trackEvent(AnalyticsEvent.OTP_RECEIVED, AnalyticsUtil.getJSONResponse(map));
                } catch (Exception unused) {
                }
            }
        });
    }

    @JavascriptInterface
    public final void copyToClipboard(String str) {
        ((ClipboardManager) this.activity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("rzp_clip_data", str));
    }
}
