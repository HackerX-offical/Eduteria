package easypay.appinvoke.actions;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.webkit.WebView;
import android.widget.EditText;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class PasswordHelper {
    private Map<String, String> action;
    private Activity activity;
    private EditText editText;
    private String fields;
    private EasypayBrowserFragment fragment;
    private String submitButtonID;
    private final TextWatcher txtWatcher;
    private WebView webview;
    private String tempData = "";
    private Boolean passwordShown = false;
    private String password = "";
    private String passwordBtnText = "";
    BroadcastReceiver customEventReceiver = new BroadcastReceiver() { // from class: easypay.appinvoke.actions.PasswordHelper.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bundle extras;
            extras = intent.getExtras();
            String string = extras.getString("eventName");
            string.hashCode();
            switch (string) {
                case "activatePasswordHelper":
                    PasswordHelper.this.activate(extras.getString("data0"));
                    PasswordHelper.this.fragment.logEvent(AppSettingsData.STATUS_ACTIVATED, (String) PasswordHelper.this.action.get("id"));
                    break;
                case "togglePassword":
                    PasswordHelper.this.togglePassword();
                    PasswordHelper.this.fragment.logEvent("togglePassword", (String) PasswordHelper.this.action.get("id"));
                    break;
                case "submitPassword":
                    PasswordHelper.this.submitPassword();
                    break;
            }
        }
    };

    private void showKeyboard() {
    }

    public void activate(String str) {
    }

    public PasswordHelper(Activity activity, WebView webView, EasypayBrowserFragment easypayBrowserFragment, Map<String, String> map, String str) {
        this.activity = activity;
        this.fragment = easypayBrowserFragment;
        this.action = map;
        this.webview = webView;
        this.submitButtonID = str;
        this.activity.registerReceiver(this.customEventReceiver, new IntentFilter("com.paytm.com.paytm.pgsdk.easypay.appinvoke.CUSTOM_EVENT"));
        this.fields = this.action.get("fields");
        webView.loadUrl("javascript:" + this.action.get("functionStart") + this.fields + (this.fields + "var a=fields; for(var i=0;i<a.length;i++){if(a[i].type=='password'){a[i].blur();Android.showLog(\"input type is password\");a[i].addEventListener('input', function(e){Android.logTempData(this.value)}); a[i].addEventListener('focus', function(){Android.sendEvent('activatePasswordHelper', true, 0);Android.logTempData(this.value);});}}") + this.action.get("functionEnd"));
        TextWatcher textWatcher = new TextWatcher() { // from class: easypay.appinvoke.actions.PasswordHelper.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PasswordHelper.this.tempData = "";
                PasswordHelper.this.webview.loadUrl((("javascript:" + ((String) PasswordHelper.this.action.get("functionStart"))) + (PasswordHelper.this.fields + "if(fields.length){fields[0].value='';};")) + ((String) PasswordHelper.this.action.get("functionEnd")));
            }
        };
        this.txtWatcher = textWatcher;
        this.editText.addTextChangedListener(textWatcher);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitPassword() {
        this.webview.loadUrl("javascript:" + (("(function(){l=document.getElementsByName('" + this.submitButtonID) + "');e=document.createEvent('HTMLEvents');e.initEvent('click',true,true);l[0].dispatchEvent(e);})()"));
        activate("false");
    }

    public void togglePassword() {
        this.passwordShown = Boolean.valueOf(!this.passwordShown.booleanValue());
        setPassword();
    }

    public void setPassword() {
        if (this.passwordShown.booleanValue()) {
            this.editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            this.password = this.tempData;
            this.passwordBtnText = "Hide";
        } else {
            this.editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.passwordBtnText = "Show";
        }
    }

    public void logTempData(String str) {
        this.tempData = str;
        setPassword();
    }

    public void reset() {
        try {
            BroadcastReceiver broadcastReceiver = this.customEventReceiver;
            if (broadcastReceiver != null) {
                this.activity.unregisterReceiver(broadcastReceiver);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.editText.setText("");
    }

    public void unregisterEvent() {
        BroadcastReceiver broadcastReceiver;
        Activity activity = this.activity;
        if (activity == null || (broadcastReceiver = this.customEventReceiver) == null) {
            return;
        }
        activity.unregisterReceiver(broadcastReceiver);
    }
}
