package easypay.appinvoke.actions;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.SmsMessage;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.appnew.android.Utils.Service.SmsBroadcastReceiver;
import com.clevertap.android.sdk.Constants;
import easypay.appinvoke.listeners.WebClientListener;
import easypay.appinvoke.manager.EasypayWebViewClient;
import easypay.appinvoke.manager.PaytmAssist;
import easypay.appinvoke.utils.Log;
import java.util.Map;
import java.util.Timer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import paytm.assist.easypay.easypay.appinvoke.R;

/* JADX INFO: loaded from: classes9.dex */
public class OtpHelper implements WebClientListener {
    private Map<String, String> action;
    private Activity activity;
    private EditText autoFillerHelperEditText;
    private EditText editTextOtp;
    private String fields;
    private EasypayBrowserFragment fragment;
    public boolean isElementFired;
    private boolean isEventRegsitered;
    private boolean isIntermediateclicked;
    private boolean isOtpdetcted;
    private Boolean isSmsRegsitered;
    private String javascrip;
    private String mMsgKeywords;
    private String mMsgSender;
    private TextView mOTPHint;
    private String mOTPText;
    private Timer otpReceiveTimer;
    private Timer otpTimer;
    private TextWatcher txtWatcher;
    private WebView webview;
    private Boolean isReceiverBinded = false;
    private int injectCount = 0;
    public BroadcastReceiver myreceiver = new BroadcastReceiver() { // from class: easypay.appinvoke.actions.OtpHelper.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bundle extras;
            try {
                if (!intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED") || (extras = intent.getExtras()) == null) {
                    return;
                }
                Object[] objArr = (Object[]) extras.get(SmsBroadcastReceiver.SMS_BUNDLE);
                SmsMessage[] smsMessageArr = objArr != null ? new SmsMessage[objArr.length] : null;
                if (smsMessageArr != null) {
                    for (int i = 0; i < smsMessageArr.length; i++) {
                        SmsMessage smsMessageCreateFromPdu = SmsMessage.createFromPdu((byte[]) objArr[i]);
                        smsMessageArr[i] = smsMessageCreateFromPdu;
                        OtpHelper.this.checkSms(smsMessageArr[i].getMessageBody(), smsMessageCreateFromPdu.getOriginatingAddress());
                    }
                }
            } catch (Exception unused) {
            }
        }
    };
    BroadcastReceiver customEventReceiver = new BroadcastReceiver() { // from class: easypay.appinvoke.actions.OtpHelper.2
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                String string = intent.getExtras().getString("eventName");
                if (string != null) {
                    switch (string.hashCode()) {
                        case -51042937:
                            if (string.equals("focusOtpField")) {
                                ((InputMethodManager) OtpHelper.this.activity.getSystemService("input_method")).showSoftInput(OtpHelper.this.autoFillerHelperEditText, 1);
                            }
                            break;
                        case 853955742:
                            if (string.equals("approveOtp")) {
                                OtpHelper.this.approveOtp();
                            }
                            break;
                        case 1392020230:
                            if (string.equals("activateOtpHelper")) {
                                OtpHelper.this.activateOtpHelper();
                            }
                            break;
                        case 2018704624:
                            if (string.equals("resendOtp")) {
                                OtpHelper.this.resendOtp();
                                OtpHelper.this.fragment.logEvent("resendOTP", (String) OtpHelper.this.action.get("id"));
                            }
                            break;
                    }
                }
            } catch (Exception unused) {
            }
        }
    };
    public EasypayWebViewClient mwebViewClient = PaytmAssist.getAssistInstance().getWebClientInstance();
    private GAEventManager mAnalyticsManager = PaytmAssist.getAssistInstance().getmAnalyticsManager();

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

    public void toggleButtons(Boolean bool) {
    }

    public OtpHelper(Activity activity, WebView webView, EasypayBrowserFragment easypayBrowserFragment, Map<String, String> map, String str, String str2, String str3, EasypayWebViewClient easypayWebViewClient) {
        this.activity = activity;
        this.fragment = easypayBrowserFragment;
        this.mMsgSender = str;
        this.mMsgKeywords = str3;
        this.action = map;
        this.webview = webView;
        try {
            EditText editText = this.editTextOtp;
            if (editText != null) {
                editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: easypay.appinvoke.actions.OtpHelper.3
                    @Override // android.view.View.OnFocusChangeListener
                    public void onFocusChange(View view, boolean z) {
                        if (z) {
                            OtpHelper.this.editTextOtp.setHint("");
                        } else {
                            OtpHelper.this.editTextOtp.setHint("Enter OTP");
                        }
                    }
                });
                View currentFocus = this.fragment.getActivity().getCurrentFocus();
                InputMethodManager inputMethodManager = (InputMethodManager) this.fragment.getActivity().getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                }
            }
        } catch (NullPointerException unused) {
        }
        if (easypayWebViewClient != null) {
            easypayWebViewClient.addAssistWebClientListener(this);
        }
        try {
            this.activity.registerReceiver(this.customEventReceiver, new IntentFilter("com.paytm.com.paytm.pgsdk.easypay.appinvoke.CUSTOM_EVENT"));
            this.isEventRegsitered = true;
        } catch (Exception unused2) {
        }
        if (this.webview != null) {
            this.javascrip = "javascript:";
            this.javascrip += " document.addEventListener(\"DOMContentLoaded\", Android.sendEvent('FIRE ELEMENT', 0, 0), false);";
            new Handler().postDelayed(new Runnable() { // from class: easypay.appinvoke.actions.OtpHelper.4
                @Override // java.lang.Runnable
                public void run() {
                    OtpHelper.this.webview.post(new Runnable() { // from class: easypay.appinvoke.actions.OtpHelper.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            OtpHelper.this.webview.evaluateJavascript(OtpHelper.this.javascrip, new ValueCallback<String>() { // from class: easypay.appinvoke.actions.OtpHelper.4.1.1
                                @Override // android.webkit.ValueCallback
                                public void onReceiveValue(String str4) {
                                }
                            });
                        }
                    });
                }
            }, 20L);
        }
    }

    public void fireElemntJs() {
        this.isElementFired = true;
        this.fields = this.action.get("fields");
        this.javascrip += this.action.get("functionStart") + (this.fields + "var a = fields; if(a.length&&!(fields[0].offsetParent == null)){Android.sendEvent('activateOtpHelper', 0, 0); var aa=a; autoFillOtp=function(value){ aa[0].value = value; }; }") + "if(fields.length){ fields[0].addEventListener('input', function(e){Android.logTempData(this.value)});}" + this.action.get("functionEnd");
        new Handler().postDelayed(new Runnable() { // from class: easypay.appinvoke.actions.OtpHelper.5
            @Override // java.lang.Runnable
            public void run() {
                OtpHelper.this.webview.post(new Runnable() { // from class: easypay.appinvoke.actions.OtpHelper.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        OtpHelper.this.webview.evaluateJavascript(OtpHelper.this.javascrip, new ValueCallback<String>() { // from class: easypay.appinvoke.actions.OtpHelper.5.1.1
                            @Override // android.webkit.ValueCallback
                            public void onReceiveValue(String str) {
                            }
                        });
                    }
                });
            }
        }, 20L);
    }

    public void activateOtpHelper() {
        this.activity.runOnUiThread(new Runnable() { // from class: easypay.appinvoke.actions.OtpHelper.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    OtpHelper.this.fragment.toggleView(R.id.otpHelper, true);
                } catch (Exception unused) {
                }
            }
        });
        Activity activity = this.activity;
        if (activity == null && activity.isFinishing()) {
            return;
        }
        TextWatcher textWatcher = new TextWatcher() { // from class: easypay.appinvoke.actions.OtpHelper.7
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String string = editable.toString();
                Boolean.valueOf(string.length() > 5);
                OtpHelper.this.webview.loadUrl((("javascript:" + ((String) OtpHelper.this.action.get("functionStart"))) + (OtpHelper.this.fields + "if(fields.length){fields[0].value='" + string + "';};")) + ((String) OtpHelper.this.action.get("functionEnd")));
            }
        };
        this.txtWatcher = textWatcher;
        try {
            EditText editText = this.editTextOtp;
            if (editText != null) {
                editText.addTextChangedListener(textWatcher);
                new Handler().postDelayed(new Runnable() { // from class: easypay.appinvoke.actions.OtpHelper.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (OtpHelper.this.activity != null) {
                            OtpHelper.this.activity.runOnUiThread(new Runnable() { // from class: easypay.appinvoke.actions.OtpHelper.8.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    OtpHelper.this.editTextOtp.setHint("Enter OTP");
                                    if (TextUtils.isEmpty(OtpHelper.this.editTextOtp.getText())) {
                                        OtpHelper.this.mOTPHint.setText("Message not detected,Enter OTP Manually");
                                    }
                                }
                            });
                        }
                    }
                }, 10000L);
            }
            checkSMSAlreadyExist(this.activity);
            if (!this.isSmsRegsitered.booleanValue()) {
                this.isSmsRegsitered = Boolean.valueOf(smsBroadCastRegsitered());
            }
        } catch (Exception unused) {
        }
        this.isReceiverBinded = true;
    }

    private boolean smsBroadCastRegsitered() {
        if (!PaytmAssist.isEasyPayEnabled) {
            return false;
        }
        this.activity.registerReceiver(this.myreceiver, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
        return true;
    }

    private boolean checkSMSSender(String str) {
        if (TextUtils.isEmpty(this.mMsgSender)) {
            return true;
        }
        String[] strArrSplit = this.mMsgSender.split(Constants.SEPARATOR_COMMA);
        if (strArrSplit.length > 0) {
            for (String str2 : strArrSplit) {
                if (str != null && str.toLowerCase().contains(str2.toLowerCase())) {
                    GAEventManager gAEventManager = this.mAnalyticsManager;
                    if (gAEventManager != null) {
                        gAEventManager.smsSenderName(str2.toUpperCase());
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkSMSKeywords(String str) {
        if (TextUtils.isEmpty(this.mMsgKeywords)) {
            return true;
        }
        String[] strArrSplit = this.mMsgKeywords.split(Constants.SEPARATOR_COMMA);
        if (strArrSplit.length > 0) {
            String strReplaceAll = str.replaceAll(" ", "").replaceAll("-", "");
            for (String str2 : strArrSplit) {
                if (strReplaceAll != null && strReplaceAll.toLowerCase().contains(str2.toLowerCase())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void checkSms(String str, String str2) {
        if (checkSMSSender(str2) && checkSMSKeywords(str)) {
            Pattern patternCompile = Pattern.compile("\\b\\d{6}\\b");
            Pattern patternCompile2 = Pattern.compile("\\b\\d{4}\\b");
            Pattern patternCompile3 = Pattern.compile("(|^)\\d{8}");
            Matcher matcher = patternCompile.matcher(str);
            patternCompile2.matcher(str);
            patternCompile3.matcher(str);
            if (matcher.find()) {
                Timer timer = this.otpTimer;
                if (timer != null) {
                    timer.cancel();
                }
                this.action.put("receivedOtp", matcher.group(0));
                this.activity.runOnUiThread(new Runnable() { // from class: easypay.appinvoke.actions.OtpHelper.9
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            String str3 = (String) OtpHelper.this.action.get("receivedOtp");
                            OtpHelper.this.isOtpdetcted = true;
                            if (OtpHelper.this.mAnalyticsManager != null) {
                                OtpHelper.this.mAnalyticsManager.onReadOTPByPaytmAssist(true);
                            }
                            OtpHelper.this.mOTPHint.setText("OTP detected, press submit to continue");
                            if (OtpHelper.this.mOTPHint != null) {
                                OtpHelper.this.editTextOtp.setText(str3);
                                OtpHelper.this.editTextOtp.setSelection(str3.length());
                                OtpHelper.this.editTextOtp.setTypeface(null, 1);
                            }
                            OtpHelper.this.webview.evaluateJavascript("javascript:" + ("autoFillOtp('" + str3 + "');"), new ValueCallback<String>() { // from class: easypay.appinvoke.actions.OtpHelper.9.1
                                @Override // android.webkit.ValueCallback
                                public void onReceiveValue(String str4) {
                                }
                            });
                        } catch (NullPointerException | Exception unused) {
                        }
                    }
                });
            }
        }
    }

    public void approveOtp() {
        String str;
        GAEventManager gAEventManager = this.mAnalyticsManager;
        if (gAEventManager != null) {
            gAEventManager.onSubmitOtpPaytmAssist(true);
        }
        if (this.action.get("action").equals("otphelper")) {
            str = "javascript:Android.showLog('approve otp- '+ typeof(autoSubmitForm));autoSubmitForm();";
        } else if (this.action.get("submitJs") != null) {
            str = "javascript:" + this.action.get("submitJs");
            this.fragment.isNbOtpFired = false;
        } else {
            str = this.action.get("customjs") != null ? "javascript:" + this.action.get("customjs") : "javascript:";
        }
        this.webview.evaluateJavascript(str, null);
        this.isIntermediateclicked = !this.action.get("bank").equals("sbi-nb");
    }

    public void logTempData(String str) {
        this.mOTPText = str;
        this.activity.runOnUiThread(new Runnable() { // from class: easypay.appinvoke.actions.OtpHelper.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (TextUtils.isEmpty(OtpHelper.this.mOTPText)) {
                        return;
                    }
                    OtpHelper.this.editTextOtp.setText(OtpHelper.this.mOTPText);
                    OtpHelper.this.editTextOtp.setSelection(OtpHelper.this.editTextOtp.getText().length());
                } catch (NullPointerException unused) {
                }
            }
        });
    }

    public void resendOtp() {
        this.webview.loadUrl("javascript:Android.showLog('resend otp- '+ typeof(autoResendOtp));autoResendOtp();");
        toggleButtons(true);
    }

    public void reset() {
        TextView textView;
        this.fragment.toggleView(R.id.otpHelper, false);
        toggleButtons(true);
        try {
            Activity activity = this.activity;
            if (activity == null || (textView = this.mOTPHint) == null) {
                return;
            }
            textView.setText(activity.getString(R.string.wait_otp));
        } catch (Exception e2) {
            Log.e("kanish", "exception" + e2.getStackTrace());
        }
    }

    private void checkSMSAlreadyExist(Activity activity) {
        if (activity != null) {
            try {
                Cursor cursorQuery = activity.getContentResolver().query(Uri.parse("content://sms/inbox"), null, "date>=?", new String[]{EasypayWebViewClient.smsTrackingTime + ""}, null);
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        checkSms(cursorQuery.getString(cursorQuery.getColumnIndex("body")), cursorQuery.getString(cursorQuery.getColumnIndex("address")));
                    }
                }
            } catch (NullPointerException unused) {
            }
        }
    }

    @Override // easypay.appinvoke.listeners.WebClientListener
    public void OnWcPageFinish(WebView webView, String str) {
        Log.e("otphelper", "otp helper Wc page finish" + str);
        if (this.isIntermediateclicked) {
            this.activity.runOnUiThread(new Runnable() { // from class: easypay.appinvoke.actions.OtpHelper.11
                @Override // java.lang.Runnable
                public void run() {
                    OtpHelper.this.fragment.toggleView(R.id.otpHelper, false);
                }
            });
        }
    }
}
