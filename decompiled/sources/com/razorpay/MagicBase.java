package com.razorpay;

import android.app.Activity;
import android.content.Context;
import android.webkit.WebView;
import com.appnew.android.Utils.Const;
import com.facebook.internal.ServerProtocol;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
class MagicBase implements SmsAgentInterface {
    String lastSms;
    MagicData magicData;
    String merchantKey;
    SmsAgent smsAgent;
    WebView webView;
    boolean hasOtpPermission = false;
    boolean isMagicEnabled = false;
    boolean jsInsertedInCurrentPage = false;
    Context context = this.context;
    Context context = this.context;

    public void onProgressChanged(int i) {
    }

    MagicBase(Activity activity, WebView webView) {
        this.webView = webView;
        SmsAgent smsAgentInstance = SmsAgent.getSmsAgentInstance();
        this.smsAgent = smsAgentInstance;
        smsAgentInstance.registerForCallbacks(this);
        MagicData magicData = new MagicData(activity);
        this.magicData = magicData;
        magicData.checkForUpdates();
    }

    public void onPageFinished(WebView webView, String str) {
        if (this.jsInsertedInCurrentPage) {
            return;
        }
        try {
            JSONObject magicSettings = ConfigCheckout.getInstance().getMagicSettings();
            magicSettings.put("merchant_key", this.merchantKey);
            magicSettings.put("otp_permission", this.hasOtpPermission);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", ConfigCheckout.SDK_TYPE);
            jSONObject.put(Const.VERSION_CODE, ConfigCheckout.SDK_VERSION_CODE);
            magicSettings.put(ServerProtocol.DIALOG_PARAM_SDK_VERSION, jSONObject);
            injectJs("window.__rzp_options = " + magicSettings.toString());
        } catch (Exception e2) {
            Logger.e("Unable to load magic settings", e2);
        }
        injectJs(this.magicData.getMagicJs());
        String str2 = this.lastSms;
        if (str2 != null) {
            injectJs(String.format("Magic.elfBridge.setSms(%s)", str2));
            this.lastSms = null;
        }
        this.jsInsertedInCurrentPage = true;
    }

    public void onPageStarted(WebView webView, String str) {
        this.jsInsertedInCurrentPage = false;
    }

    public void paymentFlowEnd() {
        this.smsAgent.deregisterForCallbacks(this);
        this.smsAgent.removeSMSBroadcastReceiver((Activity) this.context);
    }

    private void injectJs(String str) {
        this.webView.loadUrl(String.format("javascript: %s", str));
    }

    @Override // com.razorpay.SmsAgentInterface
    public void postSms(String str, String str2) {
        if (this.isMagicEnabled) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("sender", str);
                jSONObject.put("message", str2);
                this.lastSms = jSONObject.toString();
                injectJs(String.format("Magic.elfBridge.setSms(%s)", jSONObject.toString()));
            } catch (Exception e2) {
                Logger.e("Exception", e2);
            }
        }
    }

    void setMagicEnabled(boolean z) {
        this.isMagicEnabled = z;
    }

    @Override // com.razorpay.SmsAgentInterface
    public void setSmsPermission(boolean z) {
        this.hasOtpPermission = z;
    }
}
