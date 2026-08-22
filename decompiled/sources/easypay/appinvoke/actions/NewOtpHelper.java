package easypay.appinvoke.actions;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.appnew.android.Utils.Service.SmsBroadcastReceiver;
import com.google.gson.Gson;
import easypay.appinvoke.entity.AssistMetaData;
import easypay.appinvoke.entity.Operation;
import easypay.appinvoke.listeners.AppCallbacks;
import easypay.appinvoke.listeners.JavaScriptCallBacks;
import easypay.appinvoke.listeners.WebClientListener;
import easypay.appinvoke.manager.Constants;
import easypay.appinvoke.manager.EasypayWebViewClient;
import easypay.appinvoke.manager.PaytmAssist;
import easypay.appinvoke.utils.AssistLogs;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import paytm.assist.easypay.easypay.appinvoke.R;

/* JADX INFO: loaded from: classes9.dex */
public class NewOtpHelper implements WebClientListener, JavaScriptCallBacks, TextWatcher, AppCallbacks {
    private Activity activity;
    private Operation fillerFromCodeOperation;
    private EasypayBrowserFragment fragment;
    private boolean hasSmsBroadReceived;
    private boolean isOtpDetected;
    private boolean isOtpSubmitted;
    private GAEventManager mAnalyticsManager;
    private boolean mIsAutoSubmitDisable;
    private String mReceivedOtp;
    private EasypayWebViewClient mWebViewClient;
    private WebView webview;
    private HashMap<String, Operation> opMap = new HashMap<>();
    private int count = 0;
    private final BroadcastReceiver myReceiver = new BroadcastReceiver() { // from class: easypay.appinvoke.actions.NewOtpHelper.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                AssistLogs.printLog("Otp message received", this);
                if (intent != null) {
                    if (intent.getAction() != null) {
                        NewOtpHelper.this.hasSmsBroadReceived = true;
                    }
                    if (intent.getAction() == null || !intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
                        return;
                    }
                    String str = "";
                    for (SmsMessage smsMessage : Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
                        String displayOriginatingAddress = smsMessage.getDisplayOriginatingAddress();
                        str = str + smsMessage.getMessageBody();
                        AssistLogs.printLog("Calling checkSms from broadcast receiver", this);
                        NewOtpHelper.this.checkSms(str, displayOriginatingAddress);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                AssistLogs.printLog("EXCEPTION", e2);
            }
        }
    };
    private boolean isOtpViaWeb = false;

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

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    NewOtpHelper(Activity activity, WebView webView, EasypayBrowserFragment easypayBrowserFragment, EasypayWebViewClient easypayWebViewClient) {
        if (activity != null) {
            try {
                this.activity = activity;
                this.fragment = easypayBrowserFragment;
                this.webview = webView;
                if (easypayWebViewClient == null) {
                    this.mWebViewClient = PaytmAssist.getAssistInstance().getWebClientInstance();
                } else {
                    this.mWebViewClient = easypayWebViewClient;
                }
                PaytmAssist.getAssistInstance().getEasyPayHelper().addJsCallListener(this);
                this.mAnalyticsManager = PaytmAssist.getAssistInstance().getmAnalyticsManager();
                PaytmAssist.getAssistInstance().registerSMSCallBack(this);
            } catch (Exception e2) {
                e2.printStackTrace();
                AssistLogs.printLog("EXCEPTION", e2);
            }
            EasypayWebViewClient easypayWebViewClient2 = this.mWebViewClient;
            if (easypayWebViewClient2 != null) {
                easypayWebViewClient2.addAssistWebClientListener(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getDataFromSmsBundle(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            try {
                Object[] objArr = (Object[]) extras.get(SmsBroadcastReceiver.SMS_BUNDLE);
                SmsMessage[] smsMessageArr = objArr != null ? new SmsMessage[objArr.length] : null;
                if (smsMessageArr != null) {
                    for (int i = 0; i < smsMessageArr.length; i++) {
                        SmsMessage smsMessageCreateFromPdu = SmsMessage.createFromPdu((byte[]) objArr[i]);
                        smsMessageArr[i] = smsMessageCreateFromPdu;
                        checkSms(smsMessageArr[i].getMessageBody(), smsMessageCreateFromPdu.getOriginatingAddress());
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                AssistLogs.printLog("EXCEPTION", e2);
            }
        }
    }

    public void setMap(HashMap<String, Operation> map) {
        this.opMap = map;
        smsBroadCastRegistered();
        setTextWatcher(this.opMap.get(Constants.FILLER_FROM_CODE));
    }

    private void showLog(final String str) {
        try {
            Activity activity = this.activity;
            if (activity != null) {
                activity.runOnUiThread(new Runnable() { // from class: easypay.appinvoke.actions.NewOtpHelper.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (NewOtpHelper.this.fragment == null || !NewOtpHelper.this.fragment.isResumed()) {
                            return;
                        }
                        AssistLogs.printLog("Show Log Called :Minimizing Assist:Reason = " + str, this);
                        NewOtpHelper.this.fragment.removeAssist();
                    }
                });
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            AssistLogs.printLog("EXCEPTION", e2);
        }
    }

    private void successEvent(final int i) {
        this.activity.runOnUiThread(new Runnable() { // from class: easypay.appinvoke.actions.NewOtpHelper.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AssistLogs.printLog("insideSuccessEvent : Event value passed = " + i, this);
                    NewOtpHelper.this.activateOtpHelper();
                    if (ContextCompat.checkSelfPermission(NewOtpHelper.this.activity, "android.permission.READ_SMS") == 0) {
                        if (NewOtpHelper.this.opMap.get(Constants.READ_OTP) == null) {
                            AssistLogs.printLog("Reading existing messages.", this);
                            if (!NewOtpHelper.this.isOtpSubmitted) {
                                NewOtpHelper newOtpHelper = NewOtpHelper.this;
                                newOtpHelper.checkSMSAlreadyExist(newOtpHelper.activity);
                            }
                        } else {
                            AssistLogs.printLog("Reading current message.", this);
                            NewOtpHelper.this.doAction(Constants.READ_OTP);
                        }
                    }
                    NewOtpHelper.this.doAction(Constants.SUBMIT_BTN);
                    NewOtpHelper.this.doAction(Constants.FILLER_FROM_CODE);
                    NewOtpHelper.this.doAction(Constants.RESEND_BTN);
                } catch (Exception e2) {
                    AssistLogs.printLog("Any Exception in OTP Flow" + e2.getMessage(), this);
                    e2.printStackTrace();
                    AssistLogs.printLog("EXCEPTION", e2);
                }
            }
        });
    }

    void doAction(String str) {
        Operation operation = this.opMap.get(str);
        if (operation == null || TextUtils.isEmpty(operation.getActionMetadata())) {
            return;
        }
        str.hashCode();
        if (str.equals(Constants.READ_OTP)) {
            checkSMSAlreadyExist(this.activity);
            return;
        }
        if (str.equals(Constants.FILLER_FROM_WEB)) {
            AssistLogs.printLog("New otphelper:FILLER_FROM_WEB", this);
            String jsTemplate = operation.getJsTemplate();
            if (this.webview == null || TextUtils.isEmpty(jsTemplate)) {
                return;
            }
            this.webview.evaluateJavascript(jsTemplate, new ValueCallback<String>() { // from class: easypay.appinvoke.actions.NewOtpHelper.4
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(String str2) {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireOtpNotDetectedAction() {
        try {
            EasypayBrowserFragment easypayBrowserFragment = this.fragment;
            if (easypayBrowserFragment != null && easypayBrowserFragment.isVisible() && this.fragment.isAdded() && this.fragment.getUserVisibleHint()) {
                this.fragment.setDetectionStatusText(this.activity.getString(R.string.otp_could_not_detcted));
                GAEventManager gAEventManager = this.mAnalyticsManager;
                if (gAEventManager != null) {
                    gAEventManager.onsmsDetected(false);
                }
                this.fragment.otpSubmitButtonState();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            AssistLogs.printLog("EXCEPTION", e2);
        }
    }

    /* JADX INFO: renamed from: easypay.appinvoke.actions.NewOtpHelper$5, reason: invalid class name */
    class AnonymousClass5 implements Runnable {
        AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (NewOtpHelper.this.fragment == null || !NewOtpHelper.this.fragment.isAdded()) {
                    return;
                }
                AssistLogs.printLog("Activating otphelper", this);
                NewOtpHelper.this.fragment.setDetectionStatusText(NewOtpHelper.this.activity.getString(R.string.waiting_for_otp_label, new Object[]{PaytmAssist.getAssistInstance().geTxnBank()}));
                NewOtpHelper.this.fragment.toggleView(R.id.otpHelper, true);
                new Handler().postDelayed(new Runnable() { // from class: easypay.appinvoke.actions.NewOtpHelper.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (NewOtpHelper.this.activity != null) {
                            NewOtpHelper.this.activity.runOnUiThread(new Runnable() { // from class: easypay.appinvoke.actions.NewOtpHelper.5.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (NewOtpHelper.this.activity != null) {
                                        AssistLogs.printLog("About to fire OTP not detcted ", this);
                                        if (NewOtpHelper.this.activity.isFinishing() || !NewOtpHelper.this.fragment.isAdded() || NewOtpHelper.this.hasSmsBroadReceived) {
                                            return;
                                        }
                                        AssistLogs.printLog("OTP not detcted ", this);
                                        NewOtpHelper.this.fireOtpNotDetectedAction();
                                    }
                                }
                            });
                        }
                    }
                }, 10000L);
            } catch (Exception e2) {
                e2.printStackTrace();
                AssistLogs.printLog("EXCEPTION", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void activateOtpHelper() {
        try {
            Activity activity = this.activity;
            if (activity != null) {
                activity.runOnUiThread(new AnonymousClass5());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            AssistLogs.printLog("EXCEPTION", e2);
        }
    }

    private void setTextWatcher(Operation operation) {
        try {
            EasypayBrowserFragment easypayBrowserFragment = this.fragment;
            if (easypayBrowserFragment != null && easypayBrowserFragment.isVisible() && this.fragment.isAdded()) {
                this.fillerFromCodeOperation = operation;
                if (this.fragment.mInputPassCode != null) {
                    AssistLogs.printLog("Text Watcher", this);
                    this.fragment.mInputPassCode.addTextChangedListener(this);
                    this.fragment.mInputPassCode.setTag(operation);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            AssistLogs.printLog("EXCEPTION", e2);
        }
    }

    void submitOTP(Operation operation) {
        if (PaytmAssist.getAssistInstance().isFragmentPaused() || this.fragment.isHideAssistClicked) {
            return;
        }
        try {
            if (operation == null) {
                GAEventManager gAEventManager = this.mAnalyticsManager;
                if (gAEventManager != null) {
                    gAEventManager.onSubmitOtpPaytmAssist(false);
                    return;
                }
                return;
            }
            String jsTemplate = operation.getJsTemplate();
            GAEventManager gAEventManager2 = this.mAnalyticsManager;
            if (gAEventManager2 != null) {
                gAEventManager2.onSubmitOtpPaytmAssist(true);
            }
            this.webview.evaluateJavascript(jsTemplate, new ValueCallback<String>() { // from class: easypay.appinvoke.actions.NewOtpHelper.6
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(String str) {
                }
            });
            this.isOtpSubmitted = true;
        } catch (Exception e2) {
            e2.printStackTrace();
            AssistLogs.printLog("EXCEPTION", e2);
        }
    }

    private void fillOtpOnWebView(String str, String str2, String str3) {
        AssistLogs.printLog("Filler from Code " + str3, this);
        String strReplace = str2.replace(str, str3);
        AssistLogs.printLog("Filler from Code " + strReplace, this);
        WebView webView = this.webview;
        if (webView != null) {
            webView.loadUrl(strReplace);
        }
    }

    private void fillOtpOnAssist() {
        try {
            AssistLogs.printLog("After Sms :fill otp on assist:isAssistVisible" + this.fragment.isAssistVisible, this);
            if (this.activity != null && this.fragment.isAdded() && this.fragment.isAssistVisible) {
                this.activity.runOnUiThread(new Runnable() { // from class: easypay.appinvoke.actions.NewOtpHelper.7
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            NewOtpHelper.this.fragment.setDetectionStatusText(NewOtpHelper.this.activity.getString(R.string.otp_detected));
                            NewOtpHelper.this.isOtpDetected = true;
                            if (NewOtpHelper.this.fragment.mInputPassCode != null) {
                                NewOtpHelper.this.fragment.mInputPassCode.setText(NewOtpHelper.this.mReceivedOtp);
                                if (NewOtpHelper.this.mAnalyticsManager != null) {
                                    NewOtpHelper.this.mAnalyticsManager.isAutoFillSuccess(true);
                                }
                            }
                            NewOtpHelper.this.fragment.setOtpDetectedTimer(NewOtpHelper.this.mIsAutoSubmitDisable);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            AssistLogs.printLog("EXCEPTION", e2);
                        }
                    }
                });
                return;
            }
            GAEventManager gAEventManager = this.mAnalyticsManager;
            if (gAEventManager != null) {
                gAEventManager.isAutoFillSuccess(false);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            AssistLogs.printLog("EXCEPTION", e2);
        }
    }

    private void smsBroadCastRegistered() {
        if (PaytmAssist.isEasyPayEnabled) {
            if (!hasReadSmsPermission()) {
                requestReadAndSendSmsPermission();
            }
            this.activity.registerReceiver(this.myReceiver, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkSms(String str, String str2) {
        this.count++;
        AssistLogs.printLog("Check sms called: " + this.count + " time", this);
        AssistLogs.printLog("Message received: " + str + "\n From:" + str2, this);
        Matcher matcher = Pattern.compile("\\d{6}").matcher(str);
        if (matcher.find()) {
            Matcher matcher2 = Pattern.compile("\\d{6}").matcher(matcher.group(0));
            if (matcher2.find()) {
                String strGroup = matcher2.group(0);
                this.mReceivedOtp = strGroup;
                if (this.isOtpViaWeb) {
                    fillOtpViaWeb(strGroup);
                }
                AssistLogs.printLog("OTP found: " + this.mReceivedOtp, this);
                this.hasSmsBroadReceived = true;
                GAEventManager gAEventManager = this.mAnalyticsManager;
                if (gAEventManager != null) {
                    gAEventManager.onReadOTPByPaytmAssist(true);
                    this.mAnalyticsManager.onsmsDetected(true);
                }
                fillOtpOnAssist();
                return;
            }
            fireOtpNotDetectedAction();
            return;
        }
        GAEventManager gAEventManager2 = this.mAnalyticsManager;
        if (gAEventManager2 != null) {
            gAEventManager2.onReadOTPByPaytmAssist(false);
        }
    }

    private void fillOtpViaWeb(String str) {
        JSONObject jSONObject;
        if ((this.fragment.mInputPassCode != null ? this.fragment.mInputPassCode.getTag() : null) != null) {
            Operation operation = (Operation) this.fragment.mInputPassCode.getTag();
            try {
                jSONObject = new JSONObject(operation.getActionMetadata());
            } catch (JSONException e2) {
                e2.printStackTrace();
                AssistLogs.printLog("EXCEPTION", e2);
                jSONObject = null;
            }
            fillOtpOnWebView(((AssistMetaData) new Gson().fromJson(jSONObject != null ? jSONObject.toString() : null, AssistMetaData.class)).getJsField(), operation.getJsTemplate(), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkSMSAlreadyExist(Activity activity) {
        if (activity != null) {
            try {
                Cursor cursorQuery = activity.getContentResolver().query(Telephony.Sms.Inbox.CONTENT_URI, null, "date>=?", new String[]{EasypayWebViewClient.smsTrackingTime + ""}, null);
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        checkSms(cursorQuery.getString(cursorQuery.getColumnIndex("body")), cursorQuery.getString(cursorQuery.getColumnIndex("address")));
                    }
                } else {
                    AssistLogs.printLog("cursor is null", this);
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                    return;
                }
                return;
            } catch (NullPointerException e2) {
                e2.printStackTrace();
                AssistLogs.printLog("EXCEPTION", e2);
                return;
            }
        }
        AssistLogs.printLog("activity is null", this);
    }

    @Override // easypay.appinvoke.listeners.WebClientListener
    public void OnWcPageFinish(WebView webView, String str) {
        try {
            if (this.activity == null || this.fragment == null || !str.contains("transactionStatus")) {
                return;
            }
            this.activity.runOnUiThread(new Runnable() { // from class: easypay.appinvoke.actions.NewOtpHelper.8
                @Override // java.lang.Runnable
                public void run() {
                    EasypayWebViewClient.smsTrackingTime = System.currentTimeMillis();
                    NewOtpHelper.this.fragment.clearOtpFields();
                    NewOtpHelper.this.fragment.toggleView(R.id.otpHelper, false);
                }
            });
        } catch (Exception e2) {
            AssistLogs.printLog("EXCEPTION", e2);
        }
    }

    private boolean hasReadSmsPermission() {
        return ContextCompat.checkSelfPermission(this.activity, "android.permission.READ_SMS") == 0 && ContextCompat.checkSelfPermission(this.activity, "android.permission.RECEIVE_SMS") == 0;
    }

    private void requestReadAndSendSmsPermission() {
        try {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this.activity, "android.permission.READ_SMS")) {
                return;
            }
            ActivityCompat.requestPermissions(this.activity, new String[]{"android.permission.READ_SMS", "android.permission.RECEIVE_SMS"}, 102);
        } catch (Exception unused) {
        }
    }

    @Override // easypay.appinvoke.listeners.JavaScriptCallBacks
    public void uiCallBack(String str, String str2, int i) {
        try {
            if (i == 158) {
                EasypayBrowserFragment easypayBrowserFragment = this.fragment;
                if (easypayBrowserFragment != null) {
                    easypayBrowserFragment.clearOtpFields();
                    return;
                }
                return;
            }
            if (i == 201) {
                this.isOtpViaWeb = true;
                return;
            }
            if (i == 221) {
                EasypayBrowserFragment easypayBrowserFragment2 = this.fragment;
                if (easypayBrowserFragment2 != null) {
                    easypayBrowserFragment2.minimizeAssist();
                    return;
                }
                return;
            }
            if (i == 222) {
                EasypayBrowserFragment easypayBrowserFragment3 = this.fragment;
                if (easypayBrowserFragment3 != null) {
                    easypayBrowserFragment3.maximizeAssist();
                    return;
                }
                return;
            }
            switch (i) {
                case 107:
                    AssistLogs.printLog("Success Event called", this);
                    successEvent(i);
                    break;
                case 108:
                    passwordInputDataChange(str2);
                    break;
                case 109:
                    showLog(str2);
                    break;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // easypay.appinvoke.listeners.JavaScriptCallBacks
    public void helperCallBack(String str, String str2, int i) {
        if (i == 300) {
            try {
                this.mIsAutoSubmitDisable = true;
            } catch (Exception e2) {
                e2.printStackTrace();
                AssistLogs.printLog("EXCEPTION", e2);
            }
        }
    }

    void passwordInputDataChange(String str) {
        EasypayBrowserFragment easypayBrowserFragment;
        if (this.activity == null || (easypayBrowserFragment = this.fragment) == null || !easypayBrowserFragment.isAdded()) {
            return;
        }
        this.mReceivedOtp = str;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        JSONObject jSONObject;
        GAEventManager gAEventManager;
        GAEventManager gAEventManager2;
        if (this.fillerFromCodeOperation != null) {
            try {
                String string = editable.toString();
                AssistLogs.printLog("Text Change:" + string, this);
                try {
                    if (string.length() > 5) {
                        if (!this.isOtpDetected && (gAEventManager2 = this.mAnalyticsManager) != null) {
                            gAEventManager2.onOTPManuallyEntered(true);
                        }
                        if (this.isOtpDetected && this.fragment.mInputPassCode != null) {
                            this.fragment.mInputPassCode.setTypeface(null, 1);
                        }
                        if (!this.isOtpDetected && (gAEventManager = this.mAnalyticsManager) != null) {
                            gAEventManager.onOTPManuallyEntered(true);
                        }
                    } else if (this.fragment.mInputPassCode != null) {
                        this.fragment.mInputPassCode.setTypeface(null, 0);
                    }
                    if (this.fragment.mInputPassCode != null) {
                        Operation operation = (Operation) this.fragment.mInputPassCode.getTag();
                        try {
                            jSONObject = new JSONObject(operation.getActionMetadata());
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            jSONObject = null;
                        }
                        fillOtpOnWebView(((AssistMetaData) new Gson().fromJson(jSONObject != null ? jSONObject.toString() : null, AssistMetaData.class)).getJsField(), operation.getJsTemplate(), string);
                    }
                } catch (NullPointerException e3) {
                    e3.printStackTrace();
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    @Override // easypay.appinvoke.listeners.AppCallbacks
    public void smsReceivedCallback(String str) {
        checkSms(str, "na");
    }

    void unregisterBroadcastReceiver() {
        Activity activity = this.activity;
        if (activity != null) {
            activity.unregisterReceiver(this.myReceiver);
        }
    }
}
