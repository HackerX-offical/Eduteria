package com.paytm.pgsdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.http.SslError;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import com.appnew.android.Utils.Service.SmsBroadcastReceiver;
import com.google.gson.Gson;
import com.paytm.pgsdk.model.ProcessTransactionInfo;
import easypay.appinvoke.actions.EasypayBrowserFragment;
import easypay.appinvoke.listeners.AppCallbacks;
import easypay.appinvoke.listeners.WebClientListener;
import easypay.appinvoke.manager.EasypayWebViewClient;
import easypay.appinvoke.manager.PaytmAssist;
import easypay.appinvoke.utils.AssistLogs;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes9.dex */
public class PaytmPGActivity extends AppCompatActivity implements WebClientListener, AppCallbacks {
    public static final int REQUEST_CODE_UPI_APP = 105;
    private static final int SMS_CONSENT_REQUEST = 2;
    private static final String UI_INITIALIZATION_ERROR_OCCURED = "Some error occured while initializing UI of Payment Gateway Activity";
    private static final int mAssistId = 101;
    private static final int mwebVId = 121;
    private boolean isAssistEnabled;
    private Activity mActivity;
    public volatile FrameLayout mAssistLayout;
    private Context mContext;
    private Dialog mDlg;
    private String mId;
    private volatile Bundle mParams;
    private PaytmAssist mPaytmAssist;
    protected volatile ProgressBar mProgress;
    private volatile PaytmWebView mWV;
    private boolean mbHideHeader;
    private boolean mbSendAllChecksumResponseParametersToPGServer;
    private EasypayWebViewClient mwebViewClient;
    private BroadcastReceiver myReceiver;
    private String orderId;

    @Override // easypay.appinvoke.listeners.WebClientListener
    public void WcshouldInterceptRequest(WebView webView, String str) {
    }

    @Override // easypay.appinvoke.listeners.WebClientListener
    public boolean WcshouldOverrideUrlLoading(WebView webView, Object obj) {
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected synchronized void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        if (bundle != null) {
            if (PaytmPGService.getService() != null && PaytmPGService.getService().getmPaymentTransactionCallback() != null) {
                PaytmPGService.getService().getmPaymentTransactionCallback().onErrorProceed("Please retry with valid parameters");
            }
            finish();
        }
        if (this.isAssistEnabled && ActivityCompat.checkSelfPermission(this, "android.permission.RECEIVE_SMS") == 0 && ActivityCompat.checkSelfPermission(this, "android.permission.READ_SMS") == 0) {
            startReadingSMS();
        }
        if (initUI()) {
            this.mContext = this;
            startTransaction();
        } else {
            finish();
            PaytmPaymentTransactionCallback paytmPaymentTransactionCallback = PaytmPGService.getService().getmPaymentTransactionCallback();
            if (paytmPaymentTransactionCallback != null) {
                paytmPaymentTransactionCallback.someUIErrorOccurred(UI_INITIALIZATION_ERROR_OCCURED);
            }
        }
    }

    private synchronized boolean initUI() {
        try {
            if (getIntent() != null) {
                this.mbHideHeader = getIntent().getBooleanExtra("HIDE_HEADER", false);
                this.mbSendAllChecksumResponseParametersToPGServer = getIntent().getBooleanExtra("SEND_ALL_CHECKSUM_RESPONSE_PARAMETERS_TO_PG_SERVER", false);
                this.mId = getIntent().getStringExtra("mid");
                this.orderId = getIntent().getStringExtra("orderId");
                this.isAssistEnabled = getIntent().getBooleanExtra(Constants.IS_ENABLE_ASSIST, true);
                PaytmUtility.debugLog("Assist Enabled");
            }
            PaytmUtility.debugLog("Hide Header " + this.mbHideHeader);
            PaytmUtility.debugLog("Initializing the UI of Transaction Page...");
            RelativeLayout relativeLayout = new RelativeLayout(this);
            RelativeLayout relativeLayout2 = new RelativeLayout(this);
            relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            relativeLayout2.setId(1);
            relativeLayout2.setBackgroundColor(Color.parseColor("#bdbdbd"));
            Button button = new Button(this, null, android.R.attr.buttonStyleSmall);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(15);
            layoutParams.leftMargin = (int) (getResources().getDisplayMetrics().density * 5.0f);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.paytm.pgsdk.PaytmPGActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PaytmUtility.debugLog("User pressed back button which is present in Header Bar.");
                    PaytmPGActivity.this.cancelTransaction();
                }
            });
            button.setLayoutParams(layoutParams);
            button.setText("Cancel");
            TextView textView = new TextView(this);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(13);
            textView.setLayoutParams(layoutParams2);
            textView.setTextColor(-16777216);
            textView.setText("Paytm Payments");
            relativeLayout2.addView(button);
            relativeLayout2.addView(textView);
            RelativeLayout relativeLayout3 = new RelativeLayout(this);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams3.addRule(3, relativeLayout2.getId());
            relativeLayout3.setLayoutParams(layoutParams3);
            this.mWV = new PaytmWebView(this, this.mParams);
            this.mPaytmAssist = PaytmAssist.getAssistInstance();
            this.mAssistLayout = new FrameLayout(this, null);
            this.mWV.setVisibility(8);
            this.mWV.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.mProgress = new ProgressBar(this, null, android.R.attr.progressBarStyleSmall);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(13);
            this.mProgress.setLayoutParams(layoutParams4);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams5.addRule(12);
            this.mAssistLayout.setId(101);
            this.mAssistLayout.setLayoutParams(layoutParams5);
            relativeLayout3.addView(this.mWV);
            relativeLayout3.addView(this.mAssistLayout);
            relativeLayout.addView(relativeLayout2);
            relativeLayout.addView(relativeLayout3);
            if (this.mbHideHeader) {
                relativeLayout2.setVisibility(8);
            }
            setContentView(relativeLayout);
            startAssist();
            PaytmUtility.debugLog("Initialized UI of Transaction Page.");
        } catch (Exception e2) {
            AnalyticsManager.getInstance().logErrorEvent(Constants.FLOW_TYPE_REDIRECTION, e2.getMessage());
            PaytmUtility.debugLog("Some exception occurred while initializing UI.");
            PaytmUtility.printStackTrace(e2);
            return false;
        }
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected synchronized void onDestroy() {
        PaytmAssist paytmAssist;
        BroadcastReceiver broadcastReceiver;
        try {
            if (this.isAssistEnabled && (broadcastReceiver = this.myReceiver) != null) {
                unregisterReceiver(broadcastReceiver);
            }
            PaytmPGService.getService().stopService();
            PaytmPaymentRepository.onDestroy();
            paytmAssist = this.mPaytmAssist;
        } catch (Exception e2) {
            AnalyticsManager.getInstance().logErrorEvent(Constants.FLOW_TYPE_REDIRECTION, e2.getMessage());
            PaytmPGService.getService().stopService();
            PaytmUtility.debugLog("Some exception occurred while destroying the PaytmPGActivity.");
            PaytmUtility.printStackTrace(e2);
        }
        if (paytmAssist != null) {
            paytmAssist.removeAssist();
            super.onDestroy();
            AnalyticsManager.destroyInstance();
        } else {
            super.onDestroy();
            AnalyticsManager.destroyInstance();
        }
    }

    private void startAssist() {
        PaytmPGActivity paytmPGActivity;
        if (TextUtils.isEmpty(this.mId) || TextUtils.isEmpty(this.orderId)) {
            paytmPGActivity = this;
        } else {
            paytmPGActivity = this;
            this.mPaytmAssist.startConfigAssist(paytmPGActivity, Boolean.valueOf(this.isAssistEnabled), Boolean.valueOf(this.isAssistEnabled), Integer.valueOf(this.mAssistLayout.getId()), this.mWV, this, this.orderId, this.mId);
            paytmPGActivity.mWV.setWebCLientCallBacks();
            paytmPGActivity.mPaytmAssist.startAssist();
        }
        EasypayWebViewClient webClientInstance = paytmPGActivity.mPaytmAssist.getWebClientInstance();
        paytmPGActivity.mwebViewClient = webClientInstance;
        if (webClientInstance != null) {
            PaytmUtility.debugLog("EasyPayWebView Client:mwebViewClient");
            paytmPGActivity.mwebViewClient.addAssistWebClientListener(this);
        } else {
            PaytmUtility.debugLog("EasyPayWebView Client:mwebViewClient Null");
        }
    }

    private synchronized void startTransaction() {
        PaytmUtility.debugLog("Starting the Process...");
        this.mActivity = (Activity) this.mContext;
        if (getIntent() != null && getIntent().getBundleExtra("Parameters") != null) {
            this.mParams = getIntent().getBundleExtra("Parameters");
            if (this.mParams != null && this.mParams.size() > 0) {
                if (PaytmPGService.getService() != null && this.mWV != null) {
                    this.mWV.setId(121);
                    this.mWV.setVisibility(0);
                    this.mWV.postUrl(PaytmPGService.getService().mPGURL, PaytmUtility.getURLEncodedStringFromBundle(this.mParams).getBytes());
                    this.mWV.requestFocus(130);
                    if (PaytmPGService.getService().mOrder == null || PaytmPGService.getService().mOrder.getRequestParamMap() == null) {
                        PaytmPaymentTransactionCallback paytmPaymentTransactionCallback = PaytmPGService.getService().getmPaymentTransactionCallback();
                        if (paytmPaymentTransactionCallback != null) {
                            paytmPaymentTransactionCallback.onTransactionCancel("Transaction failed due to invaild parameters", null);
                        }
                        finish();
                    } else if (PaytmPGService.getService().mOrder.getRequestParamMap().get("prenotificationurl") != null) {
                        Intent intent = new Intent(getApplicationContext(), (Class<?>) IntentServicePreNotification.class);
                        intent.putExtra("url", PaytmPGService.getService().mOrder.getRequestParamMap().get("prenotificationurl"));
                        getApplicationContext().startService(intent);
                    }
                } else if (this.mWV == null) {
                    PaytmPaymentTransactionCallback paytmPaymentTransactionCallback2 = PaytmPGService.getService().getmPaymentTransactionCallback();
                    if (paytmPaymentTransactionCallback2 != null) {
                        paytmPaymentTransactionCallback2.onTransactionCancel(Constants.ERROR_TXN_FAILED_NULL, null);
                    }
                    finish();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cancelTransaction() {
        PaytmUtility.debugLog("Displaying Confirmation Dialog");
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.CancelDialogeTheme);
        builder.setTitle("Cancel Transaction");
        builder.setMessage("Are you sure you want to cancel transaction");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: com.paytm.pgsdk.PaytmPGActivity.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PaytmPGActivity.this.closeOrderApi();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: com.paytm.pgsdk.PaytmPGActivity.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    if (PaytmPGActivity.this.mDlg == null || !PaytmPGActivity.this.mDlg.isShowing()) {
                        return;
                    }
                    PaytmPGActivity.this.mDlg.dismiss();
                } catch (Exception e2) {
                    PaytmUtility.printStackTrace(e2);
                }
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        this.mDlg = alertDialogCreate;
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeOrderApi() {
        PaytmPaymentRepository.getInstance().makeCloseOrderApi(new ApiCallback<ProcessTransactionInfo>() { // from class: com.paytm.pgsdk.PaytmPGActivity.4
            @Override // com.paytm.pgsdk.ApiCallback
            public void onError() {
                PaytmPGService.getService().getmPaymentTransactionCallback().onTransactionResponse(null);
                PaytmPGActivity.this.finish();
            }

            @Override // com.paytm.pgsdk.ApiCallback
            public void onSuccess(final ProcessTransactionInfo processTransactionInfo) {
                final PaytmPaymentTransactionCallback paytmPaymentTransactionCallback = PaytmPGService.getService().getmPaymentTransactionCallback();
                try {
                    if (processTransactionInfo.getBody().getTxnInfo() != null) {
                        PaytmPGActivity.this.runOnUiThread(new Runnable() { // from class: com.paytm.pgsdk.PaytmPGActivity.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                paytmPaymentTransactionCallback.onTransactionResponse(PaytmUtility.getBundleFromString(new Gson().toJson(processTransactionInfo.getBody().getTxnInfo())));
                            }
                        });
                    } else {
                        paytmPaymentTransactionCallback.onTransactionResponse(null);
                    }
                } catch (Exception unused) {
                    paytmPaymentTransactionCallback.onTransactionResponse(null);
                }
                PaytmPGActivity.this.finish();
            }
        });
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        cancelTransaction();
    }

    @Override // easypay.appinvoke.listeners.WebClientListener
    public void OnWcPageFinish(WebView webView, String str) {
        PaytmUtility.debugLog("Pg Activity:OnWcPageFinish");
    }

    @Override // easypay.appinvoke.listeners.WebClientListener
    public void OnWcPageStart(WebView webView, String str, Bitmap bitmap) {
        PaytmUtility.debugLog("Pg Activity:OnWcPageStart");
    }

    @Override // easypay.appinvoke.listeners.WebClientListener
    public void OnWcSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        PaytmUtility.debugLog("Pg Activity:OnWcSslError");
    }

    @Override // easypay.appinvoke.listeners.AppCallbacks
    public void smsReceivedCallback(String str) {
        PaytmUtility.debugLog("SMS received:" + str);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 105) {
            return;
        }
        String str = "javascript:window.upiIntent.intentAppClosed(" + i2 + ");";
        this.mWV.loadUrl(str);
        PaytmUtility.debugLog("Js for acknowldgement" + str);
    }

    private void setOtpHelperCallBack(String str) {
        EasypayBrowserFragment easypayBrowserFragment = (EasypayBrowserFragment) getSupportFragmentManager().findFragmentById(101);
        if (easypayBrowserFragment == null || easypayBrowserFragment.getCurrentNewOtpHelper() == null) {
            return;
        }
        PaytmAssist.getAssistInstance().registerSMSCallBack(easypayBrowserFragment.getCurrentNewOtpHelper());
        PaytmAssist.getAssistInstance().setAppSMSCallback(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillOtpOnWebPage(String str) {
        this.mWV.loadUrl("javascript:if(document.getElementById('inp')){document.getElementById('inp').focus();setTimeout(function(){document.getElementById('inp').value='" + str + "'},0);}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String parseOneTimeCode(String str) {
        if (str != null && !str.isEmpty()) {
            Matcher matcher = Pattern.compile("\\d{6}").matcher(str);
            if (matcher.find()) {
                Matcher matcher2 = Pattern.compile("\\d{6}").matcher(matcher.group(0));
                if (matcher2.find()) {
                    String strGroup = matcher2.group(0);
                    AssistLogs.printLog("OTP found: " + strGroup, this);
                    return strGroup;
                }
            }
            return "";
        }
        AssistLogs.printLog("Message received is either null or empty", this);
        return "";
    }

    private void startReadingSMS() {
        this.myReceiver = new BroadcastReceiver() { // from class: com.paytm.pgsdk.PaytmPGActivity.5
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                try {
                    AssistLogs.printLog("Otp message received", this);
                    if (intent == null || intent.getAction() == null || !intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
                        return;
                    }
                    String str = "";
                    for (SmsMessage smsMessage : Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
                        str = str + smsMessage.getMessageBody();
                        AssistLogs.printLog("Calling checkSms from broadcast receiver", this);
                        PaytmPGActivity.this.fillOtpOnWebPage(PaytmPGActivity.this.parseOneTimeCode(str));
                    }
                } catch (Exception e2) {
                    AnalyticsManager.getInstance().logErrorEvent(Constants.FLOW_TYPE_REDIRECTION, e2.getMessage());
                    e2.printStackTrace();
                    AssistLogs.printLog("EXCEPTION", e2);
                }
            }
        };
        registerReceiver(this.myReceiver, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
    }

    private boolean isEasyPayFragmentAdded() {
        if (getSupportFragmentManager().findFragmentById(101) != null) {
            return getSupportFragmentManager().findFragmentById(101).isAdded();
        }
        return false;
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
                        smsMessageCreateFromPdu.getOriginatingAddress();
                        fillOtpOnWebPage(parseOneTimeCode(smsMessageArr[i].getMessageBody()));
                    }
                }
            } catch (Exception e2) {
                AnalyticsManager.getInstance().logErrorEvent(Constants.FLOW_TYPE_REDIRECTION, e2.getMessage());
                e2.printStackTrace();
                AssistLogs.printLog("EXCEPTION", e2);
            }
        }
    }
}
