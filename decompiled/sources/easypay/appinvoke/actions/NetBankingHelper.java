package easypay.appinvoke.actions;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import easypay.appinvoke.listeners.WebClientListener;
import easypay.appinvoke.manager.Constants;
import easypay.appinvoke.manager.EasypayWebViewClient;
import easypay.appinvoke.manager.PaytmAssist;
import easypay.appinvoke.utils.AssistLogs;
import java.util.HashMap;
import java.util.Map;
import paytm.assist.easypay.easypay.appinvoke.R;

/* JADX INFO: loaded from: classes9.dex */
public class NetBankingHelper implements WebClientListener {
    private Map<String, String> action;
    private Activity activity;
    private Button btSubmit;
    private EditText editText;
    private EditText etPassWord;
    private CheckBox etUserName;
    private String fields;
    private EasypayBrowserFragment fragment;
    private TextView imgShow;
    String injeJS;
    public boolean isNbWatcherInjected;
    public boolean isSubmitClicked;
    EasypayWebViewClient mwebViewClient;
    private String submitButtonID;
    private TextWatcher txtWatcher;
    private WebView webview;
    private String tempData = "";
    private Boolean passwordShown = false;
    private String password = "";
    private String passwordBtnText = "";
    BroadcastReceiver customEventReceiver = new BroadcastReceiver() { // from class: easypay.appinvoke.actions.NetBankingHelper.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String string;
            Bundle extras = intent.getExtras();
            if (extras == null || (string = extras.getString("eventName")) == null) {
                return;
            }
            string.hashCode();
            switch (string) {
                case "activatePasswordHelper":
                    NetBankingHelper.this.activate(extras.getString("data0"));
                    NetBankingHelper.this.fragment.logEvent(AppSettingsData.STATUS_ACTIVATED, (String) NetBankingHelper.this.action.get("id"));
                    break;
                case "nbLoginSubmit":
                    NetBankingHelper.this.loginMaker();
                    NetBankingHelper netBankingHelper = NetBankingHelper.this;
                    netBankingHelper.InputListenerJs((String) netBankingHelper.action.get("submitLogin"), "submitLogin");
                    break;
                case "activateNetBankingHelper":
                    NetBankingHelper.this.activate(extras.getString("data0"));
                    NetBankingHelper.this.fragment.logEvent(AppSettingsData.STATUS_ACTIVATED, (String) NetBankingHelper.this.action.get("id"));
                    break;
                case "confirmhelper":
                    NetBankingHelper.this.confirmFlow();
                    break;
                case "nbConfirmSubmit":
                    NetBankingHelper.this.confirInjector();
                    break;
                case "userIdInputHelper":
                    NetBankingHelper.this.fragment.logEvent("negtbanking userid", (String) NetBankingHelper.this.action.get("id"));
                    break;
                case "submitPassword":
                    NetBankingHelper.this.submitPassword();
                    break;
            }
        }
    };

    @Override // easypay.appinvoke.listeners.WebClientListener
    public void OnWcPageStart(WebView webView, String str, Bitmap bitmap) {
    }

    @Override // easypay.appinvoke.listeners.WebClientListener
    public void OnWcSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
    }

    @Override // easypay.appinvoke.listeners.WebClientListener
    public void WcshouldInterceptRequest(WebView webView, String str) {
    }

    @Override // easypay.appinvoke.listeners.WebClientListener
    public boolean WcshouldOverrideUrlLoading(WebView webView, Object obj) {
        return false;
    }

    public NetBankingHelper(Activity activity, WebView webView, EasypayBrowserFragment easypayBrowserFragment, Map<String, String> map, EasypayWebViewClient easypayWebViewClient) {
        PaytmAssist.getAssistInstance().getmAnalyticsManager().isNetBanking(true);
        this.activity = activity;
        this.fragment = easypayBrowserFragment;
        this.action = map;
        this.webview = webView;
        this.mwebViewClient = PaytmAssist.getAssistInstance().getWebClientInstance();
        try {
            this.activity.registerReceiver(this.customEventReceiver, new IntentFilter("com.paytm.com.paytm.pgsdk.easypay.appinvoke.CUSTOM_EVENT"));
        } catch (Exception e2) {
            e2.printStackTrace();
            AssistLogs.printLog("EXCEPTION", e2);
        }
        this.injeJS = "javascript:";
        if (easypayWebViewClient != null) {
            easypayWebViewClient.addAssistWebClientListener(this);
        }
        try {
            this.fields = this.action.get("fields");
            CheckBox checkBox = (CheckBox) this.activity.findViewById(R.id.cb_nb_userId);
            this.etUserName = checkBox;
            checkBox.setButtonDrawable(R.drawable.ic_checkbox_selected);
            this.etPassWord = (EditText) this.activity.findViewById(R.id.et_nb_password);
            this.btSubmit = (Button) this.activity.findViewById(R.id.nb_bt_submit);
            this.imgShow = (TextView) this.activity.findViewById(R.id.img_pwd_show);
            this.injeJS += this.action.get("functionStart") + this.fields + "else{Android.sendEvent('activateNetBankingHelper', true, 0);}" + this.action.get("functionEnd");
            this.webview.post(new Runnable() { // from class: easypay.appinvoke.actions.NetBankingHelper.2
                @Override // java.lang.Runnable
                public void run() {
                    NetBankingHelper.this.webview.evaluateJavascript(NetBankingHelper.this.injeJS, new ValueCallback<String>() { // from class: easypay.appinvoke.actions.NetBankingHelper.2.1
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str) {
                        }
                    });
                }
            });
        } catch (NullPointerException unused) {
        }
        this.txtWatcher = new TextWatcher() { // from class: easypay.appinvoke.actions.NetBankingHelper.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void confirInjector() {
        Handler handler = new Handler();
        if (TextUtils.isEmpty(this.action.get("confirmJs"))) {
            return;
        }
        handler.postDelayed(new Runnable() { // from class: easypay.appinvoke.actions.NetBankingHelper.4
            @Override // java.lang.Runnable
            public void run() {
                NetBankingHelper.this.webview.evaluateJavascript("javascript:(function() { try {" + ((String) NetBankingHelper.this.action.get("confirmJs")) + "}catch(e){Android.showLog('net banking confirm page error');}}());", new ValueCallback<String>() { // from class: easypay.appinvoke.actions.NetBankingHelper.4.1
                    @Override // android.webkit.ValueCallback
                    public void onReceiveValue(String str) {
                    }
                });
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void confirmFlow() {
        hideSeekViews();
    }

    private void hideSeekViews() {
        try {
            this.activity.findViewById(R.id.layout_netbanking).setVisibility(0);
            this.etUserName.setVisibility(8);
            this.etPassWord.setVisibility(8);
            this.imgShow.setVisibility(8);
            this.btSubmit.setVisibility(8);
        } catch (NullPointerException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String loginMaker() {
        return "Android.NbWatcher(login_submkitted,check url);";
    }

    private void injectUserId(CheckBox checkBox) {
        if (checkBox != null) {
            checkBox.addTextChangedListener(new TextWatcher() { // from class: easypay.appinvoke.actions.NetBankingHelper.5
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void InputListenerJs(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (this.action.get("bank").equals("hdfc-nb")) {
            sb.append("javascript:");
            sb.append(str);
            sb.append(str2);
        } else {
            sb.append("javascript:(function() { try {");
            sb.append(str);
            sb.append(str2);
            sb.append("}catch(e){Android.showLog('not found -Net Banking js Injection');}}());");
        }
        this.webview.getSettings().setDomStorageEnabled(true);
        this.webview.getSettings().setJavaScriptEnabled(true);
        this.isNbWatcherInjected = true;
        this.webview.evaluateJavascript(sb.toString(), new ValueCallback<String>() { // from class: easypay.appinvoke.actions.NetBankingHelper.6
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(String str3) {
            }
        });
        if (str2.equals("submitLogin")) {
            this.fragment.passwordViewer("", 3);
            this.isSubmitClicked = true;
        }
    }

    private void nextPageChecker() {
        final String str = this.action.get("url");
        final int length = str.length();
        new Handler().postDelayed(new Runnable() { // from class: easypay.appinvoke.actions.NetBankingHelper.7
            @Override // java.lang.Runnable
            public void run() {
                String strSubstring = NetBankingHelper.this.webview.getUrl().substring(0, length);
                StringBuilder sb = new StringBuilder("javascript:(function() { try {");
                if (!((String) NetBankingHelper.this.action.get("selectorType")).equals("name")) {
                    if (((String) NetBankingHelper.this.action.get("selectorType")).equals("id")) {
                        sb.append("var x=document.getElementById('");
                    }
                } else {
                    sb.append("var x=document.getElementsByName('");
                }
                if (!TextUtils.isEmpty((CharSequence) NetBankingHelper.this.action.get("nextelement"))) {
                    sb.append((String) NetBankingHelper.this.action.get("nextelement"));
                } else {
                    sb.append((String) NetBankingHelper.this.action.get("selector"));
                }
                sb.append("');if(x!=null){Android.NbWatcher(1,2)}else{Android.NbWatcher(1,4)}}catch(e){Android.showLog('not found -Net Banking js Injection');}}());");
                NetBankingHelper.this.webview.evaluateJavascript(sb.toString(), new ValueCallback<String>() { // from class: easypay.appinvoke.actions.NetBankingHelper.7.1
                    @Override // android.webkit.ValueCallback
                    public void onReceiveValue(String str2) {
                    }
                });
                if (strSubstring.equals(str)) {
                    return;
                }
                NetBankingHelper.this.fragment.toggleView(R.id.layout_netbanking, false);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitPassword() {
        this.webview.loadUrl("javascript:" + (("(function(){l=document.getElementsByName('" + this.submitButtonID) + "');e=document.createEvent('HTMLEvents');e.initEvent('click',true,true);l[0].dispatchEvent(e);})()"));
        activate("false");
    }

    public void activate(String str) {
        if (str.equals("true")) {
            this.activity.runOnUiThread(new Runnable() { // from class: easypay.appinvoke.actions.NetBankingHelper.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        NetBankingHelper.this.fragment.toggleView(R.id.layout_netbanking, true);
                        PaytmAssist.getAssistInstance().getmAnalyticsManager().isNetBankingInvoked(true);
                        PaytmAssist.getAssistInstance().getmAnalyticsManager().NbUrl(NetBankingHelper.this.webview.getUrl());
                        NetBankingHelper.this.tabdetect();
                        NetBankingHelper netBankingHelper = NetBankingHelper.this;
                        netBankingHelper.autofillUserId((String) netBankingHelper.action.get("userNameInject"));
                        NetBankingHelper.this.injectElementSelector();
                        NetBankingHelper netBankingHelper2 = NetBankingHelper.this;
                        netBankingHelper2.InputListenerJs((String) netBankingHelper2.action.get("userInputjs"), (String) NetBankingHelper.this.action.get("passwordInputJs"));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        AssistLogs.printLog("EXCEPTION", e2);
                    }
                }
            });
        } else {
            this.tempData = "";
            this.activity.runOnUiThread(new Runnable() { // from class: easypay.appinvoke.actions.NetBankingHelper.9
                @Override // java.lang.Runnable
                public void run() {
                    NetBankingHelper.this.setPassword();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tabdetect() {
        StringBuilder sb = new StringBuilder("javascript:(function() { try {");
        if (!TextUtils.isEmpty(this.action.get("istabpage"))) {
            sb.append(this.action.get("uwtabdetect"));
        }
        sb.append("}catch(e){Android.showLog('not found -could not inject user name');}}());");
        this.webview.getSettings().setDomStorageEnabled(true);
        this.webview.getSettings().setJavaScriptEnabled(true);
        this.isNbWatcherInjected = true;
        this.webview.evaluateJavascript(sb.toString(), new ValueCallback<String>() { // from class: easypay.appinvoke.actions.NetBankingHelper.10
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(String str) {
            }
        });
        wPageDetect();
    }

    private void wPageDetect() {
        if (this.webview != null) {
            StringBuilder sb = new StringBuilder("javascript:(function() { try {");
            if (!TextUtils.isEmpty(this.action.get("istabpage"))) {
                sb.append(this.action.get("wtabdetect"));
            }
            sb.append("}catch(e){Android.showLog('not found -could not inject user name');}}());");
            this.webview.getSettings().setDomStorageEnabled(true);
            this.webview.getSettings().setJavaScriptEnabled(true);
            this.isNbWatcherInjected = true;
            this.webview.evaluateJavascript(sb.toString(), new ValueCallback<String>() { // from class: easypay.appinvoke.actions.NetBankingHelper.11
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(String str) {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void injectElementSelector() {
        StringBuilder sb = new StringBuilder("javascript:(function() { try {");
        if (!TextUtils.isEmpty(this.action.get("activeInputJS"))) {
            sb.append(this.action.get("activeInputJS"));
        }
        sb.append("}catch(e){Android.showLog('not found -could not inject user name');}}());");
        this.webview.getSettings().setDomStorageEnabled(true);
        this.webview.getSettings().setJavaScriptEnabled(true);
        this.isNbWatcherInjected = true;
        this.webview.evaluateJavascript(sb.toString(), new ValueCallback<String>() { // from class: easypay.appinvoke.actions.NetBankingHelper.12
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(String str) {
            }
        });
        injectPwAcSelector();
    }

    private void injectPwAcSelector() {
        StringBuilder sb = new StringBuilder("javascript:(function() { try {");
        if (!TextUtils.isEmpty(this.action.get("activepwjs"))) {
            sb.append(this.action.get("activepwjs"));
        }
        sb.append("}catch(e){Android.showLog('not found -could not inject user name');}}());");
        this.webview.getSettings().setDomStorageEnabled(true);
        this.webview.getSettings().setJavaScriptEnabled(true);
        this.isNbWatcherInjected = true;
        this.webview.evaluateJavascript(sb.toString(), new ValueCallback<String>() { // from class: easypay.appinvoke.actions.NetBankingHelper.13
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void autofillUserId(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences sharedPreferences = this.activity.getApplicationContext().getSharedPreferences(Constants.BANKPREF, 0);
        String str2 = "";
        if (sharedPreferences != null) {
            HashMap map = (HashMap) new Gson().fromJson(sharedPreferences.getString(Constants.USER_ID_NET_BANK_KEY, ""), new TypeToken<HashMap<String, String>>() { // from class: easypay.appinvoke.actions.NetBankingHelper.14
            }.getType());
            if (map == null || !map.containsKey(this.action.get("bank"))) {
                return;
            }
            str2 = "'" + ((String) map.get(this.action.get("bank"))) + "'";
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.webview.getSettings().setDomStorageEnabled(true);
        this.webview.getSettings().setJavaScriptEnabled(true);
        this.isNbWatcherInjected = true;
        this.webview.evaluateJavascript("javascript:(function() { try {" + str + str2 + "}catch(e){Android.showLog('not found -could not inject user name');}}());", new ValueCallback<String>() { // from class: easypay.appinvoke.actions.NetBankingHelper.15
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(String str3) {
            }
        });
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
        this.activity.runOnUiThread(new Runnable() { // from class: easypay.appinvoke.actions.NetBankingHelper.16
            @Override // java.lang.Runnable
            public void run() {
            }
        });
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
            AssistLogs.printLog("EXCEPTION", e2);
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

    @Override // easypay.appinvoke.listeners.WebClientListener
    public void OnWcPageFinish(WebView webView, String str) {
        if (this.isSubmitClicked && (TextUtils.isEmpty(this.action.get("nextsburl")) || str.contains(this.action.get("nextsburl")))) {
            nextPageChecker();
            this.isSubmitClicked = false;
        }
        if (!str.contains(this.action.get("url"))) {
            EasypayBrowserFragment easypayBrowserFragment = this.fragment;
            if (easypayBrowserFragment != null) {
                easypayBrowserFragment.passwordViewer("", 3);
                return;
            }
            return;
        }
        EasypayBrowserFragment easypayBrowserFragment2 = this.fragment;
        if (easypayBrowserFragment2 != null) {
            easypayBrowserFragment2.passwordViewer("", 4);
        }
    }

    private void getuserName(String str) {
        StringBuilder sb = new StringBuilder("javascript:(function() { try {var y=");
        if (this.action.get("selectorType").equals("id")) {
            sb.append("document.getElementById('");
        } else if (this.action.get("selectorType").equals("name")) {
            sb.append("document.getElementsByName('");
        }
        sb.append(str);
        sb.append("').value;Android.NbWatcher(y,99)}catch(e){Android.showLog('not found -Net Banking js Injection');}}());");
        this.webview.getSettings().setDomStorageEnabled(true);
        this.webview.getSettings().setJavaScriptEnabled(true);
        this.isNbWatcherInjected = true;
        this.webview.evaluateJavascript(sb.toString(), new ValueCallback<String>() { // from class: easypay.appinvoke.actions.NetBankingHelper.17
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(String str2) {
            }
        });
    }
}
