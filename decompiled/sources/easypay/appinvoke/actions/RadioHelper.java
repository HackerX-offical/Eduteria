package easypay.appinvoke.actions;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import easypay.appinvoke.utils.Log;
import java.util.Map;
import paytm.assist.easypay.easypay.appinvoke.R;

/* JADX INFO: loaded from: classes9.dex */
public class RadioHelper {
    Map<String, String> action;
    Activity activity;
    CheckBox cbNoOtp;
    CheckBox cbSendOtp;
    String fields;
    EasypayBrowserFragment fragment;
    String inputKey;
    String mUrl;
    WebView webview;
    String radio_one = "0";
    String radio_two = "1";
    BroadcastReceiver customEventReceiver = new BroadcastReceiver() { // from class: easypay.appinvoke.actions.RadioHelper.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bundle extras;
            extras = intent.getExtras();
            String string = extras.getString("eventName");
            string.hashCode();
            switch (string) {
                case "submit":
                    RadioHelper.this.injectSelection();
                    break;
                case "selectRadioOption":
                    RadioHelper.this.selectOption(extras.getString("data0"));
                    break;
                case "activateRadioHelper":
                    RadioHelper.this.activate();
                    RadioHelper.this.fragment.logEvent(AppSettingsData.STATUS_ACTIVATED, RadioHelper.this.action.get("id"));
                    break;
            }
        }
    };

    public void activate() {
    }

    public RadioHelper(Activity activity, WebView webView, EasypayBrowserFragment easypayBrowserFragment, Map<String, String> map) {
        this.activity = activity;
        this.fragment = easypayBrowserFragment;
        this.action = map;
        this.webview = webView;
        IntentFilter intentFilter = new IntentFilter("com.paytm.com.paytm.pgsdk.easypay.appinvoke.CUSTOM_EVENT");
        this.mUrl = webView.getUrl();
        this.activity.registerReceiver(this.customEventReceiver, intentFilter);
        this.activity.runOnUiThread(new Runnable() { // from class: easypay.appinvoke.actions.RadioHelper.2
            @Override // java.lang.Runnable
            public void run() {
            }
        });
        this.action.get("fields");
        Log.d("radiohelper", "inside radiohelper constructor");
        this.cbNoOtp = (CheckBox) easypayBrowserFragment.getView().findViewById(R.id.cb_do_not_send_otp);
        this.cbSendOtp = (CheckBox) easypayBrowserFragment.getView().findViewById(R.id.cb_send_otp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void injectSelection() {
        if (this.cbSendOtp.isChecked()) {
            injectJs("0");
        }
        if (this.cbNoOtp.isChecked()) {
            injectJs("1");
        }
    }

    private void injectJs(String str) {
        this.webview.getSettings().setJavaScriptEnabled(true);
        this.webview.getSettings().setDomStorageEnabled(true);
        this.webview.loadUrl("javascript:(function (){(function (){return document.passwdForm.otpDestinationOption[" + str + "].checked=true ;})();return pwdBaseOtpChannelSelected(1); })();");
        this.webview.setWebViewClient(new WebViewClient() { // from class: easypay.appinvoke.actions.RadioHelper.3
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str2) {
                return super.shouldOverrideUrlLoading(webView, str2);
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str2, Bitmap bitmap) {
                super.onPageStarted(webView, str2, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str2) {
                if (!TextUtils.isEmpty(RadioHelper.this.mUrl) && !str2.equals(RadioHelper.this.mUrl)) {
                    RadioHelper.this.activity.runOnUiThread(new Runnable() { // from class: easypay.appinvoke.actions.RadioHelper.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                        }
                    });
                }
                super.onPageFinished(webView, str2);
            }
        });
    }

    public void selectOption(String str) {
        String str2;
        if (str.equals("1")) {
            str2 = this.action.get("value1");
            this.fragment.logEvent("selectedOption1", this.action.get("id"));
        } else {
            str2 = this.action.get("value2");
            this.fragment.logEvent("selectedOption2", this.action.get("id"));
        }
        this.webview.loadUrl("javascript:" + ("if(typeof(autoSelectRadio) != 'undefined'){autoSelectRadio('" + str2 + "');}"));
    }

    public void reset() {
        BroadcastReceiver broadcastReceiver;
        try {
            Activity activity = this.activity;
            if (activity == null || (broadcastReceiver = this.customEventReceiver) == null) {
                return;
            }
            activity.unregisterReceiver(broadcastReceiver);
        } catch (Exception unused) {
        }
    }
}
