package com.easebuzz.payment.kit;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import com.amazonaws.services.s3.util.Mimetypes;
import com.appnew.android.Utils.Const;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import custom_ui_components.loader.PWELoaderFactory;
import cz.msebera.android.httpclient.protocol.HTTP;
import datamodels.PWEStaticDataModel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlinx.coroutines.DebugKt;
import listeners.PWEOtpListener;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class PWEBankPageActivity extends AppCompatActivity {
    private static final int SMS_CONSENT_REQUEST = 2;
    public Dialog bottom_sheet_auto_otp;
    private Button btn_close_otp_popup;
    private Button btn_confirm_otp;
    private PWEGeneralHelper generalHelper;
    private boolean isRedirected;
    private LinearLayout linear_copy_otp;
    ProgressBar mProgress;
    private Handler otpHandler;
    private RelativeLayout otpProgressBarHolder;
    private Timer otpTimer;
    private TimerTask otpTimerTask;
    private PWEPaymentInfoHandler paymentInfoHandler;
    public PWESMSUserConsentReceiver pweSMSConsentReceiver;
    TextView textPStatus;
    private TextView tv_bank_otp;
    private TextView tv_time_to_submit_otp;
    private AlertDialog userCancelAlertDialog;
    private WebView webviewProcessPayment;
    private String selected_coupon_id_list = "";
    private String access_key = "";
    private String paymentoption = "";
    private String bankname = "";
    private String card_num = "";
    private String name_on_card = "";
    private String cardType = "";
    private String emi_dict = "";
    private String exp_date = "";
    private String otherbankname = "";
    private String userAgent = "";
    private String device = "";
    private String no_cvv_flag = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
    private String cvv_string = "";
    private String coupon_code = "";
    private String bank_code = "";
    private String save_card_flag = "";
    private String card_id = "";
    private String saved_card_cvv = "";
    private String pwe_action = "";
    private String enachActNo = "";
    private String enachActHolder = "";
    private String enachActType = "";
    private String simpl_eligible_data = "";
    private String pay_later_appName = "";
    private String enachAuthMode = "";
    private String enachBankName = "";
    private String enachBankCode = "";
    private String enachIFSCCode = "";
    private Bundle instance_state = null;
    private boolean otp_received_flag = false;
    public int otp_rem_timer_count = 10;
    public int check_otp_existance_break_count = 5;
    public String otp_message = "NA";
    public String otp_code = "NA";
    public boolean import_script_called = false;
    private String otp_js_url = "";
    private String auto_otp_reg_ex = "";
    private boolean auto_otp_flag = false;
    int pStatus = 0;
    public String javascring = "";
    private boolean is_js_loaded_from_reader = false;
    private String otp_submit_current_step = "first_step_submit";
    private String pwe_otp_extra_data = "";
    private boolean check_if_auto_otp = false;
    final Handler otpProgressHandler = new Handler();
    private ActivityResultLauncher<Intent> pweSMSResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.1
        @Override // androidx.activity.result.ActivityResultCallback
        public void onActivityResult(ActivityResult activityResult) {
            Intent data = activityResult.getData();
            if (data != null) {
                try {
                    if (!PWEBankPageActivity.this.auto_otp_flag || PWEBankPageActivity.this.otp_received_flag) {
                        return;
                    }
                    PWEBankPageActivity.this.otp_received_flag = true;
                    PWEBankPageActivity.this.otp_message = data.getStringExtra(SmsRetriever.EXTRA_SMS_MESSAGE);
                } catch (Exception unused) {
                }
            }
        }
    });

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.instance_state = bundle;
        super.onCreate(bundle);
        setContentView(R.layout.activity_p_w_e_process_payment);
        this.paymentInfoHandler = new PWEPaymentInfoHandler(this);
        this.generalHelper = new PWEGeneralHelper(this);
        PWEStaticHelper.PWE_CURRENT_TRXN_STATUS = PWEStaticDataModel.PWE_STATUS_PENDING;
        this.paymentInfoHandler.setPweLastTransactionStatus(PWEStaticHelper.PWE_CURRENT_TRXN_STATUS);
        this.paymentInfoHandler.setIsTxnSessionExpire(false);
        this.selected_coupon_id_list = this.paymentInfoHandler.getSelectedCouponIdList();
        this.access_key = this.paymentInfoHandler.getMerchantAccessKey();
        this.paymentoption = this.paymentInfoHandler.getSelectedPaymentOption();
        this.bankname = this.paymentInfoHandler.getSelectedBankName();
        this.userAgent = "userAgent";
        this.device = DeviceRequestsHelper.DEVICE_INFO_DEVICE;
        this.card_num = this.paymentInfoHandler.getSelectedCardNumber();
        this.name_on_card = this.paymentInfoHandler.getSelectedNameOnCard();
        this.cardType = this.paymentInfoHandler.getSelectedCardType();
        this.exp_date = this.paymentInfoHandler.getSelectedExpDate();
        this.no_cvv_flag = this.paymentInfoHandler.getNoCVVFlag();
        this.save_card_flag = this.paymentInfoHandler.getSelectedSavedCardFlag();
        this.card_id = this.paymentInfoHandler.getSelectedCardID();
        this.saved_card_cvv = this.paymentInfoHandler.getSelectedSavedCardCvv();
        this.otherbankname = this.paymentInfoHandler.getSelectedOtherBankName();
        this.cvv_string = this.paymentInfoHandler.getSelectedCVVString();
        this.emi_dict = this.paymentInfoHandler.getSelectedEMIDict();
        this.bank_code = this.paymentInfoHandler.getSelectedbankCode();
        this.coupon_code = this.paymentInfoHandler.getAppliedDiscountCouponCode();
        this.enachActNo = this.paymentInfoHandler.getPWEEnachAccountNumber();
        this.enachActHolder = this.paymentInfoHandler.getPWEEnachAccountHolderName();
        this.enachActType = this.paymentInfoHandler.getPWEEnachAccountType();
        this.enachAuthMode = this.paymentInfoHandler.getPWEEnachAuthMode();
        this.enachBankName = this.paymentInfoHandler.getPWEEnachBankName();
        this.enachBankCode = this.paymentInfoHandler.getPWEEnachBankCode();
        this.enachIFSCCode = this.paymentInfoHandler.getPWEEnachIFSCCode();
        this.simpl_eligible_data = this.paymentInfoHandler.getPWESimplEligibleData();
        this.pay_later_appName = this.paymentInfoHandler.getPWESimplPayLaterAppName();
        removeCookies();
        this.otp_js_url = this.generalHelper.validateJS(this.paymentInfoHandler.getAutoOtpJURL());
        this.auto_otp_reg_ex = this.paymentInfoHandler.getAutoOtpRegEx();
        String autoOtpExtraData = this.paymentInfoHandler.getAutoOtpExtraData();
        this.pwe_otp_extra_data = autoOtpExtraData;
        this.check_if_auto_otp = this.generalHelper.checkAutoOtpEnableForMode(autoOtpExtraData, this.paymentoption, this.bank_code);
        this.otp_received_flag = false;
        this.otp_rem_timer_count = 15;
        this.check_otp_existance_break_count = 8;
        PWESMSUserConsentReceiver pWESMSUserConsentReceiver = new PWESMSUserConsentReceiver();
        this.pweSMSConsentReceiver = pWESMSUserConsentReceiver;
        pWESMSUserConsentReceiver.setPweOtpListener(new PWEOtpListener() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.2
            @Override // listeners.PWEOtpListener
            public void otpSMSReceived(Intent intent) {
                try {
                    if (SmsRetriever.SMS_RETRIEVED_ACTION.equals(intent.getAction())) {
                        Bundle extras = intent.getExtras();
                        if (((Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS")).getStatusCode() == 0 && PWEBankPageActivity.this.getCallingActivity().getPackageName().equals(PWEBankPageActivity.this.paymentInfoHandler.getPWEMerchantPkg())) {
                            Intent intent2 = (Intent) extras.getParcelable(SmsRetriever.EXTRA_CONSENT_INTENT);
                            int flags = intent2.getFlags();
                            intent2.removeFlags(1);
                            intent2.removeFlags(2);
                            if (flags == 0) {
                                ComponentName componentNameResolveActivity = intent2.resolveActivity(PWEBankPageActivity.this.getPackageManager());
                                String packageName = componentNameResolveActivity.getPackageName();
                                String className = componentNameResolveActivity.getClassName();
                                if (packageName.equals(PWEBankPageActivity.this.paymentInfoHandler.getPWEAutoOtpSafePkg()) && className.equals(PWEBankPageActivity.this.paymentInfoHandler.getPWEAutoOtpSafeClass())) {
                                    PWEBankPageActivity.this.pweSMSResultLauncher.launch(intent2);
                                }
                            }
                        }
                    }
                } catch (ActivityNotFoundException | Error | Exception unused) {
                }
            }
        });
        initViews();
        if (this.otp_js_url.equals("") || this.auto_otp_reg_ex.equals("") || !this.check_if_auto_otp) {
            return;
        }
        this.auto_otp_flag = true;
        this.otp_submit_current_step = "first_step_submit";
        new getOptJSString().execute(new String[0]);
        initializePWEOtp();
    }

    private void initViews() {
        WebView webView = (WebView) findViewById(R.id.webview_process_payment);
        this.webviewProcessPayment = webView;
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setMixedContentMode(0);
        settings.setCacheMode(2);
        settings.setSupportMultipleWindows(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        this.webviewProcessPayment.setLayerType(2, null);
        this.webviewProcessPayment.setWebViewClient(new PWEWebViewClient());
        this.webviewProcessPayment.addJavascriptInterface(new PWEPaymentStatus(), "PwePayStatus");
        if (this.paymentInfoHandler.getPaymentMode().equals(Const.TEST)) {
            this.pwe_action = "" + PWEStaticDataModel.REST_BASE_URL_TEST + "/webservice/submitInitiatePayment";
        } else {
            this.pwe_action = "" + PWEStaticDataModel.REST_BASE_URL + "/webservice/submitInitiatePayment";
        }
        String autoSubmitFormFromAssets = getAutoSubmitFormFromAssets();
        WebView.setWebContentsDebuggingEnabled(false);
        Bundle bundle = this.instance_state;
        if (bundle != null) {
            this.webviewProcessPayment.restoreState(bundle);
        } else {
            this.webviewProcessPayment.loadData(autoSubmitFormFromAssets, Mimetypes.MIMETYPE_HTML, "UTF-8");
        }
        this.webviewProcessPayment.setOnTouchListener(new View.OnTouchListener() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                PWEBankPageActivity.this.webviewProcessPayment.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
    }

    void initializePWEOtp() {
        try {
            Task<Void> taskStartSmsUserConsent = SmsRetriever.getClient((Activity) this).startSmsUserConsent(null);
            taskStartSmsUserConsent.addOnSuccessListener(new OnSuccessListener<Void>() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.4
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public void onSuccess(Void r3) {
                    try {
                        IntentFilter intentFilter = new IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION);
                        PWEBankPageActivity pWEBankPageActivity = PWEBankPageActivity.this;
                        pWEBankPageActivity.registerReceiver(pWEBankPageActivity.pweSMSConsentReceiver, intentFilter);
                    } catch (Error | Exception unused) {
                    }
                }
            });
            taskStartSmsUserConsent.addOnFailureListener(new OnFailureListener() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.5
                @Override // com.google.android.gms.tasks.OnFailureListener
                public void onFailure(Exception exc) {
                    PWEBankPageActivity.this.auto_otp_flag = false;
                }
            });
        } catch (Exception unused) {
            this.auto_otp_flag = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initializeOTPView(String str) {
        try {
            final String str2 = "Submitting the OTP, Please wait....";
            if (str.equals("READY")) {
                runOnUiThread(new Runnable() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        PWEBankPageActivity.this.tv_time_to_submit_otp.setText(str2);
                        PWEBankPageActivity.this.otpProgressBarHolder.setVisibility(8);
                        PWEBankPageActivity.this.textPStatus.setVisibility(8);
                        PWEBankPageActivity.this.btn_confirm_otp.setVisibility(8);
                        PWEBankPageActivity.this.btn_close_otp_popup.setText(HTTP.CONN_CLOSE);
                        PWEBankPageActivity.this.btn_close_otp_popup.setVisibility(0);
                    }
                });
            } else if (str.equals("PROCEED")) {
                runOnUiThread(new Runnable() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.7
                    @Override // java.lang.Runnable
                    public void run() {
                        PWEBankPageActivity.this.tv_time_to_submit_otp.setText(str2);
                        PWEBankPageActivity.this.otpProgressBarHolder.setVisibility(0);
                        PWEBankPageActivity.this.textPStatus.setVisibility(0);
                        PWEBankPageActivity.this.btn_confirm_otp.setVisibility(0);
                        PWEBankPageActivity.this.btn_close_otp_popup.setText("Cancel");
                        PWEBankPageActivity.this.btn_close_otp_popup.setVisibility(0);
                    }
                });
            } else {
                final String str3 = "Copy OTP and close the popup.";
                runOnUiThread(new Runnable() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.8
                    @Override // java.lang.Runnable
                    public void run() {
                        PWEBankPageActivity.this.tv_time_to_submit_otp.setText(str3);
                        PWEBankPageActivity.this.otpProgressBarHolder.setVisibility(8);
                        PWEBankPageActivity.this.textPStatus.setVisibility(8);
                        PWEBankPageActivity.this.btn_confirm_otp.setVisibility(8);
                        PWEBankPageActivity.this.btn_close_otp_popup.setText(HTTP.CONN_CLOSE);
                        PWEBankPageActivity.this.btn_close_otp_popup.setVisibility(0);
                    }
                });
            }
        } catch (Error | Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pweApproveOtpFailed(String str) {
        try {
            final String str2 = "Sorry,  we are unable to fill OTP, Copy OTP and Submit.";
            if (!str.equals("FIRST") && !str.equals("SECOND") && !str.equals("THIRD")) {
                str2 = "Sorry,  we are unable to submit OTP, Copy OTP and Submit.";
                if (!str.equals("FOUR") && !str.equals("FIVE") && !str.equals("SIXTH")) {
                    if (!str.equals("SEVENTH")) {
                        str2 = "Copy OTP";
                    } else {
                        str2 = "Sorry,  We are unable to submit OTP, Submit manually";
                    }
                }
            }
            runOnUiThread(new Runnable() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    if (PWEBankPageActivity.this.otpTimer != null) {
                        PWEBankPageActivity.this.otpTimer.cancel();
                    }
                    PWEBankPageActivity.this.tv_time_to_submit_otp.setText(str2);
                    PWEBankPageActivity.this.otpProgressBarHolder.setVisibility(8);
                    PWEBankPageActivity.this.textPStatus.setVisibility(8);
                    PWEBankPageActivity.this.btn_confirm_otp.setVisibility(8);
                    PWEBankPageActivity.this.btn_close_otp_popup.setText(HTTP.CONN_CLOSE);
                    PWEBankPageActivity.this.btn_close_otp_popup.setVisibility(0);
                }
            });
        } catch (Error unused) {
        } catch (Exception unused2) {
            dismissAutoOtpSheet();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void findOTPSubmitField() {
        try {
            this.webviewProcessPayment.post(new Runnable() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.10
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        PWEBankPageActivity.this.webviewProcessPayment.evaluateJavascript("try{ pwe_find_submit_field(); } catch(error){ PwePayStatus.pweExceptionFound(error);};", new ValueCallback<String>() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.10.1
                            @Override // android.webkit.ValueCallback
                            public void onReceiveValue(String str) {
                            }
                        });
                    } catch (Exception unused) {
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    public void dismissAutoOtpSheet() {
        try {
            Dialog dialog = this.bottom_sheet_auto_otp;
            if (dialog != null) {
                dialog.dismiss();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startOtpTimer() {
        try {
            this.otpHandler = new Handler();
            this.otpTimer = new Timer();
            AnonymousClass11 anonymousClass11 = new AnonymousClass11();
            this.otpTimerTask = anonymousClass11;
            this.otpTimer.scheduleAtFixedRate(anonymousClass11, 0L, 1000L);
        } catch (Exception unused) {
            dismissAutoOtpSheet();
        }
    }

    /* JADX INFO: renamed from: com.easebuzz.payment.kit.PWEBankPageActivity$11, reason: invalid class name */
    class AnonymousClass11 extends TimerTask {
        AnonymousClass11() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            PWEBankPageActivity.this.otpHandler.post(new Runnable() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.11.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        PWEBankPageActivity.this.runOnUiThread(new Runnable() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.11.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (PWEBankPageActivity.this.otp_rem_timer_count <= 0) {
                                    if (PWEBankPageActivity.this.auto_otp_flag) {
                                        PWEBankPageActivity.this.submitPWEOTP();
                                    }
                                    PWEBankPageActivity.this.otpTimer.cancel();
                                    return;
                                }
                                PWEBankPageActivity.this.tv_time_to_submit_otp.setText(Html.fromHtml("OTP will be submitted automatically in <b>" + String.valueOf(PWEBankPageActivity.this.otp_rem_timer_count) + "s</b> "));
                                PWEBankPageActivity.this.textPStatus.setText("" + PWEBankPageActivity.this.otp_rem_timer_count + "s\nLeft");
                                PWEBankPageActivity.this.otp_rem_timer_count--;
                                if (PWEBankPageActivity.this.otp_rem_timer_count == PWEBankPageActivity.this.check_otp_existance_break_count) {
                                    PWEBankPageActivity.this.checkExistanceOfOTP();
                                }
                            }
                        });
                    } catch (Error | Exception unused) {
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkExistanceOfOTP() {
        this.webviewProcessPayment.post(new Runnable() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.12
            @Override // java.lang.Runnable
            public void run() {
                try {
                    PWEBankPageActivity.this.webviewProcessPayment.evaluateJavascript("try { pwe_check_otp_exists_in_field(); } catch(error){ PwePayStatus.pweExceptionFound(error);};", new ValueCallback<String>() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.12.1
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str) {
                        }
                    });
                } catch (Exception unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pweFillOtp(String str) {
        final String str2 = "try { pwe_fill_otp('" + str + "'); } catch(error){ PwePayStatus.pweExceptionFound(error);};";
        this.webviewProcessPayment.post(new Runnable() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.13
            @Override // java.lang.Runnable
            public void run() {
                try {
                    PWEBankPageActivity.this.webviewProcessPayment.evaluateJavascript(str2, new ValueCallback<String>() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.13.1
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str3) {
                        }
                    });
                } catch (Exception unused) {
                }
            }
        });
    }

    void setCircularProgressBar() {
        Drawable drawable = getResources().getDrawable(R.drawable.pwe_custom_progressbar);
        this.mProgress.setProgress(0);
        this.mProgress.setSecondaryProgress(100);
        this.mProgress.setMax(100);
        this.mProgress.setProgressDrawable(drawable);
        new Thread(new Runnable() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.14
            @Override // java.lang.Runnable
            public void run() {
                while (PWEBankPageActivity.this.pStatus < 100) {
                    PWEBankPageActivity.this.pStatus++;
                    PWEBankPageActivity.this.otpProgressHandler.post(new Runnable() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.14.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PWEBankPageActivity.this.mProgress.setProgress(PWEBankPageActivity.this.pStatus);
                        }
                    });
                    try {
                        Thread.sleep(170L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void openApproveOtpPopup(final String str) {
        try {
            View viewInflate = getLayoutInflater().inflate(R.layout.bottom_sheet_approve_otp, (ViewGroup) null);
            Dialog dialog = new Dialog(this, R.style.MaterialDialogSheet);
            this.bottom_sheet_auto_otp = dialog;
            dialog.setContentView(viewInflate);
            this.bottom_sheet_auto_otp.setCancelable(true);
            this.bottom_sheet_auto_otp.getWindow().setLayout(-1, -2);
            this.btn_confirm_otp = (Button) viewInflate.findViewById(R.id.btn_confirm_otp);
            this.btn_close_otp_popup = (Button) viewInflate.findViewById(R.id.btn_close_otp_popup);
            this.linear_copy_otp = (LinearLayout) viewInflate.findViewById(R.id.copy_otp_close_popup);
            PWELoaderFactory.create(PWEStaticDataModel.PWE_LOADER_STYLE).setColor(getResources().getColor(R.color.pwe_loader_color));
            TextView textView = (TextView) viewInflate.findViewById(R.id.txt_bnk_otp);
            this.tv_bank_otp = textView;
            textView.setText(str);
            this.tv_time_to_submit_otp = (TextView) viewInflate.findViewById(R.id.txt_rem_submit_time);
            this.otpProgressBarHolder = (RelativeLayout) viewInflate.findViewById(R.id.progress_bar_holder);
            this.mProgress = (ProgressBar) viewInflate.findViewById(R.id.circularProgressbar);
            this.textPStatus = (TextView) viewInflate.findViewById(R.id.textPStatus);
            this.bottom_sheet_auto_otp.getWindow().setGravity(80);
            this.bottom_sheet_auto_otp.setCancelable(false);
            initializeOTPView("READY");
            this.btn_confirm_otp.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PWEBankPageActivity.this.auto_otp_flag) {
                        PWEBankPageActivity.this.submitPWEOTP();
                    }
                    PWEBankPageActivity.this.dismissAutoOtpSheet();
                }
            });
            this.btn_close_otp_popup.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        if (PWEBankPageActivity.this.otpTimer != null) {
                            PWEBankPageActivity.this.otpTimer.cancel();
                        }
                        PWEBankPageActivity.this.dismissAutoOtpSheet();
                    } catch (Exception unused) {
                    }
                }
            });
            this.linear_copy_otp.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ((ClipboardManager) PWEBankPageActivity.this.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Copy", "" + str));
                    PWEBankPageActivity.this.generalHelper.showPweToast("OTP Copied");
                }
            });
            this.bottom_sheet_auto_otp.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public class getOptJSString extends AsyncTask<String, Void, String> {
        @Override // android.os.AsyncTask
        protected void onPreExecute() {
        }

        public getOptJSString() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(String... strArr) {
            BufferedReader bufferedReader;
            StringBuilder sb = new StringBuilder();
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new URL(PWEBankPageActivity.this.otp_js_url).openConnection().getInputStream()));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line + "\n");
                PWEBankPageActivity.this.javascring = sb.toString();
                return null;
            }
            bufferedReader.close();
            PWEBankPageActivity.this.javascring = sb.toString();
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void find_and_submit_otp() {
        final Handler handler = new Handler();
        final Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.18
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                handler.post(new Runnable() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PWEBankPageActivity.this.otp_message.equals("NA") || PWEBankPageActivity.this.import_script_called) {
                            return;
                        }
                        PWEBankPageActivity.this.parsePWEOTP();
                        timer.cancel();
                    }
                });
            }
        }, 0L, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parsePWEOTP() {
        try {
            this.otp_message = this.otp_message.replace("  ", " ");
            Matcher matcher = Pattern.compile(this.auto_otp_reg_ex).matcher(this.otp_message);
            while (matcher.find()) {
                this.otp_code = matcher.group(0);
            }
            if (this.otp_code.equals("NA") || this.import_script_called) {
                return;
            }
            this.import_script_called = true;
            importAutoOtpScript();
            openApproveOtpPopup(this.otp_code);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitPWEOTP() {
        try {
            this.webviewProcessPayment.post(new Runnable() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.19
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        PWEBankPageActivity.this.webviewProcessPayment.evaluateJavascript("try { pwe_submit_otp('" + PWEBankPageActivity.this.otp_submit_current_step + "'); } catch(error){ PwePayStatus.pweExceptionFound(error);};", new ValueCallback<String>() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.19.1
                            @Override // android.webkit.ValueCallback
                            public void onReceiveValue(String str) {
                            }
                        });
                    } catch (Exception unused) {
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    private void importAutoOtpScript() {
        this.webviewProcessPayment.evaluateJavascript(((("javascript:var otpjs = document.createElement(\"script\");otpjs.src='" + this.otp_js_url + "';") + "otpjs.onload=function(){PwePayStatus.OTPPWEJsLoaded();};") + "otpjs.onerror=function(){PwePayStatus.OTPPWEJsNotLoaded();};") + "document.body.appendChild(otpjs);", new ValueCallback<String>() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.20
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void importAutoOtpScript2() {
        final String str = "javascript:" + this.javascring;
        this.is_js_loaded_from_reader = true;
        try {
            runOnUiThread(new Runnable() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.21
                @Override // java.lang.Runnable
                public void run() {
                    PWEBankPageActivity.this.webviewProcessPayment.evaluateJavascript(str, new ValueCallback<String>() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.21.1
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                        }
                    });
                }
            });
        } catch (Error | Exception unused) {
        }
    }

    public void loadedPweJsFromFile() {
        final String str = "try { pwe_check_for_otp_field('" + this.paymentoption + "', '" + this.bank_code + "', '" + this.pwe_otp_extra_data + "'); } catch(error){ PwePayStatus.pweExceptionFound(error);};";
        this.webviewProcessPayment.post(new Runnable() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.22
            @Override // java.lang.Runnable
            public void run() {
                try {
                    PWEBankPageActivity.this.webviewProcessPayment.evaluateJavascript(str, new ValueCallback<String>() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.22.1
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                        }
                    });
                } catch (Exception unused) {
                }
            }
        });
    }

    protected void showUserConfirmationDialog(String str, String str2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View viewInflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.pwe_error_dialog, (ViewGroup) null);
        builder.setView(viewInflate);
        builder.setCancelable(false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.text_error_title);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.text_error_desc);
        Button button = (Button) viewInflate.findViewById(R.id.btn_alert_ok);
        Button button2 = (Button) viewInflate.findViewById(R.id.btn_alert_cancel);
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            button.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.pwe_android_tv_button));
            button2.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.pwe_android_tv_button));
        }
        try {
            AlertDialog alertDialogCreate = builder.create();
            this.userCancelAlertDialog = alertDialogCreate;
            alertDialogCreate.show();
        } catch (Exception unused) {
            sendFailedResponseMerchant(PWEStaticDataModel.SERVER_ERROR_STR, PWEStaticDataModel.ERROR_DESC_STR, PWEStaticDataModel.TXN_ERROR_SERVER_ERROR_CODE);
        }
        textView.setText(str);
        textView2.setText(str2);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("error", PWEStaticDataModel.BANK_BACK_PRESSED_STR);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                PWEBankPageActivity.this.sendResponseToMerchant(PWEStaticDataModel.TXN_BANK_BACK_PRESSED_CODE, jSONObject.toString(), 0);
                PWEBankPageActivity.this.userCancelAlertDialog.dismiss();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PWEBankPageActivity.this.userCancelAlertDialog.dismiss();
            }
        });
    }

    public void removeCookies() {
        CookieManager.getInstance().removeAllCookie();
    }

    private String getAutoSubmitFormFromAssets() {
        String str = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getAssets().open("pwe-auto-submit.html")));
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    str = str + line;
                } else {
                    bufferedReader.close();
                    return str;
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public class PWEPaymentStatus {
        public PWEPaymentStatus() {
        }

        @JavascriptInterface
        public void onResponse(final String str) {
            try {
                final JSONObject jSONObject = new JSONObject(str);
                final String string = jSONObject.getString(Const.FLAG);
                PWEBankPageActivity.this.runOnUiThread(new Runnable() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.PWEPaymentStatus.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String string2;
                        if (string.equals("1")) {
                            try {
                                String string3 = jSONObject.getString("error_status");
                                String strOptString = jSONObject.optString("msg", "Transaction failed");
                                String strOptString2 = jSONObject.optString("msg_desc", PWEStaticDataModel.ERROR_DESC_STR);
                                if (string3.equals("cardvalidation")) {
                                    return;
                                }
                                PWEBankPageActivity.this.sendFailedResponseMerchant(strOptString, strOptString2, PWEStaticDataModel.TXN_ERROR_TXN_NOT_ALLOWED_CODE);
                                return;
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                return;
                            }
                        }
                        try {
                            string2 = jSONObject.getString("status");
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            string2 = "";
                        }
                        if (string2.equals("success")) {
                            PWEBankPageActivity.this.sendResponseToMerchant(PWEStaticDataModel.TXN_SUCCESS_CODE, str, -1);
                        } else {
                            PWEBankPageActivity.this.sendResponseToMerchant("payment_failed", str, 0);
                        }
                    }
                });
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }

        @JavascriptInterface
        public String getPweAction() {
            return PWEBankPageActivity.this.pwe_action;
        }

        @JavascriptInterface
        public String getAccessKeyFromApp() {
            return PWEBankPageActivity.this.access_key;
        }

        @JavascriptInterface
        public String getSavedCardIdFromApp() {
            return PWEBankPageActivity.this.card_id;
        }

        @JavascriptInterface
        public String getPaymentOptionFromApp() {
            return PWEBankPageActivity.this.paymentoption;
        }

        @JavascriptInterface
        public String getCheckBoxDebitFromAPP() {
            return PWEBankPageActivity.this.no_cvv_flag;
        }

        @JavascriptInterface
        public String getBankNameFromApp() {
            return PWEBankPageActivity.this.bankname;
        }

        @JavascriptInterface
        public String getCardNumFromApp() {
            return PWEBankPageActivity.this.card_num;
        }

        @JavascriptInterface
        public String getNameOnCardFromApp() {
            return PWEBankPageActivity.this.name_on_card;
        }

        @JavascriptInterface
        public String getCardTypeFromApp() {
            return PWEBankPageActivity.this.cardType;
        }

        @JavascriptInterface
        public String getExpDateFromApp() {
            return PWEBankPageActivity.this.exp_date;
        }

        @JavascriptInterface
        public String getSelectedCouponFromApp() {
            return "" + PWEBankPageActivity.this.selected_coupon_id_list;
        }

        @JavascriptInterface
        public String getOtherBankNameFromApp() {
            return PWEBankPageActivity.this.otherbankname;
        }

        @JavascriptInterface
        public String getCVVFromApp() {
            return PWEBankPageActivity.this.cvv_string;
        }

        @JavascriptInterface
        public String getSavedCardCVVFromApp() {
            return PWEBankPageActivity.this.saved_card_cvv;
        }

        @JavascriptInterface
        public String getUserAgentFromApp() {
            return PWEBankPageActivity.this.userAgent;
        }

        @JavascriptInterface
        public String getDeviceFromApp() {
            return PWEBankPageActivity.this.device;
        }

        @JavascriptInterface
        public String getCheckBoxCardDetailFromApp() {
            return PWEBankPageActivity.this.save_card_flag;
        }

        @JavascriptInterface
        public String getEMIDictFromApp() {
            return PWEBankPageActivity.this.emi_dict;
        }

        @JavascriptInterface
        public String getDiscountCodeFromApp() {
            return PWEBankPageActivity.this.coupon_code;
        }

        @JavascriptInterface
        public String getisMobileFromApp() {
            return "1";
        }

        @JavascriptInterface
        public String getBankCodeFromApp() {
            return PWEBankPageActivity.this.bank_code;
        }

        @JavascriptInterface
        public String getEnachActNoFromApp() {
            return PWEBankPageActivity.this.enachActNo;
        }

        @JavascriptInterface
        public String getEnachActHolderNameFromApp() {
            return PWEBankPageActivity.this.enachActHolder;
        }

        @JavascriptInterface
        public String getEnachActTypeFromApp() {
            return PWEBankPageActivity.this.enachActType;
        }

        @JavascriptInterface
        public String getEnachAuthModeFromApp() {
            return PWEBankPageActivity.this.enachAuthMode;
        }

        @JavascriptInterface
        public String getEnachBankNameFromApp() {
            return PWEBankPageActivity.this.enachBankName;
        }

        @JavascriptInterface
        public String getEnachBankCodeFromApp() {
            return PWEBankPageActivity.this.enachBankCode;
        }

        @JavascriptInterface
        public String getEnachIFSCFromApp() {
            return PWEBankPageActivity.this.enachIFSCCode;
        }

        @JavascriptInterface
        public void OTPPWEJsLoaded() {
            if (PWEBankPageActivity.this.auto_otp_flag) {
                final String str = "try { pwe_check_for_otp_field('" + PWEBankPageActivity.this.paymentoption + "', '" + PWEBankPageActivity.this.bank_code + "', '" + PWEBankPageActivity.this.pwe_otp_extra_data + "'); } catch(error){ PwePayStatus.pweExceptionFound(error);};";
                PWEBankPageActivity.this.webviewProcessPayment.post(new Runnable() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.PWEPaymentStatus.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            PWEBankPageActivity.this.webviewProcessPayment.evaluateJavascript(str, new ValueCallback<String>() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.PWEPaymentStatus.2.1
                                @Override // android.webkit.ValueCallback
                                public void onReceiveValue(String str2) {
                                }
                            });
                        } catch (Exception unused) {
                        }
                    }
                });
            } else {
                PWEBankPageActivity.this.pweApproveOtpFailed("FIRST");
            }
        }

        @JavascriptInterface
        public void OTPPWEJsNotLoaded() {
            if (PWEBankPageActivity.this.auto_otp_flag) {
                PWEBankPageActivity.this.importAutoOtpScript2();
            } else {
                PWEBankPageActivity.this.pweApproveOtpFailed("FIRST");
            }
        }

        @JavascriptInterface
        public void pweSrptLoaded() {
            if (PWEBankPageActivity.this.auto_otp_flag) {
                if (PWEBankPageActivity.this.is_js_loaded_from_reader) {
                    PWEBankPageActivity.this.loadedPweJsFromFile();
                    return;
                }
                return;
            }
            PWEBankPageActivity.this.pweApproveOtpFailed("FIRST");
        }

        @JavascriptInterface
        public void pweExceptionFound(String str) {
            PWEBankPageActivity.this.auto_otp_flag = false;
            PWEBankPageActivity.this.pweApproveOtpFailed("FIRST");
        }

        @JavascriptInterface
        public void pweApproveOtpStep2(int i) {
            if (!PWEBankPageActivity.this.auto_otp_flag) {
                PWEBankPageActivity.this.pweApproveOtpFailed("SECOND");
                return;
            }
            if (i != 1 && i != PWEBankPageActivity.this.otp_code.length()) {
                PWEBankPageActivity.this.pweApproveOtpFailed("SECOND");
                return;
            }
            PWEBankPageActivity.this.setCircularProgressBar();
            PWEBankPageActivity.this.initializeOTPView("PROCEED");
            PWEBankPageActivity pWEBankPageActivity = PWEBankPageActivity.this;
            pWEBankPageActivity.pweFillOtp(pWEBankPageActivity.otp_code);
        }

        @JavascriptInterface
        public void pweApproveOtpStep3(boolean z) {
            try {
                if (!PWEBankPageActivity.this.auto_otp_flag) {
                    PWEBankPageActivity.this.pweApproveOtpFailed("THIRD");
                } else if (z) {
                    PWEBankPageActivity.this.findOTPSubmitField();
                } else {
                    PWEBankPageActivity.this.pweApproveOtpFailed("THIRD");
                }
            } catch (Exception unused) {
                PWEBankPageActivity.this.pweApproveOtpFailed("THIRD");
            }
        }

        @JavascriptInterface
        public void pweApproveOtpStep5(boolean z, String str) {
            if (!PWEBankPageActivity.this.otp_submit_current_step.equals("second_step_submit") || z) {
                PWEBankPageActivity.this.otp_submit_current_step = str;
                try {
                    if (PWEBankPageActivity.this.auto_otp_flag) {
                        if (z || !PWEBankPageActivity.this.otp_submit_current_step.equals("second_step_submit")) {
                            if (!z && PWEBankPageActivity.this.otp_submit_current_step.equals(Const.COMPLETED)) {
                                PWEBankPageActivity.this.pweApproveOtpFailed("FIVE");
                                return;
                            } else {
                                PWEBankPageActivity.this.dismissAutoOtpSheet();
                                return;
                            }
                        }
                        new Handler().postDelayed(new Runnable() { // from class: com.easebuzz.payment.kit.PWEBankPageActivity.PWEPaymentStatus.3
                            @Override // java.lang.Runnable
                            public void run() {
                                PWEBankPageActivity.this.findOTPSubmitField();
                            }
                        }, 4000L);
                        return;
                    }
                    PWEBankPageActivity.this.pweApproveOtpFailed("FIVE");
                    return;
                } catch (Exception unused) {
                    PWEBankPageActivity.this.pweApproveOtpFailed("FIVE");
                    return;
                }
            }
            PWEBankPageActivity.this.otp_submit_current_step = str;
            PWEBankPageActivity.this.pweApproveOtpFailed("SEVENTH");
        }

        @JavascriptInterface
        public void pweApproveOtpStep4(boolean z) {
            try {
                if (!PWEBankPageActivity.this.auto_otp_flag) {
                    PWEBankPageActivity.this.pweApproveOtpFailed("FOUR");
                    return;
                }
                if (z) {
                    if (PWEBankPageActivity.this.otp_submit_current_step.equals("first_step_submit")) {
                        PWEBankPageActivity.this.startOtpTimer();
                        return;
                    }
                    if (PWEBankPageActivity.this.otp_submit_current_step.equals("second_step_submit")) {
                        if (PWEBankPageActivity.this.auto_otp_flag) {
                            PWEBankPageActivity.this.submitPWEOTP();
                            return;
                        } else {
                            PWEBankPageActivity.this.pweApproveOtpFailed("FOUR");
                            return;
                        }
                    }
                    PWEBankPageActivity.this.pweApproveOtpFailed("FOUR");
                    return;
                }
                PWEBankPageActivity.this.pweApproveOtpFailed("FOUR");
            } catch (Exception unused) {
                PWEBankPageActivity.this.pweApproveOtpFailed("FOUR");
            }
        }

        @JavascriptInterface
        public void pweOtpExistsSign(boolean z) {
            if (z) {
                try {
                    if (PWEBankPageActivity.this.auto_otp_flag) {
                        return;
                    }
                } catch (Exception unused) {
                    PWEBankPageActivity.this.pweApproveOtpFailed("SIXTH");
                    return;
                }
            }
            PWEBankPageActivity.this.pweApproveOtpFailed("SIXTH");
        }

        @JavascriptInterface
        public String getSimplEligibilityDataFromApp() {
            return PWEBankPageActivity.this.simpl_eligible_data;
        }

        @JavascriptInterface
        public String getSimplPayLaterAppNameFromApp() {
            return PWEBankPageActivity.this.pay_later_appName;
        }
    }

    protected void sendFailedResponseMerchant(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error", str);
            jSONObject.put("error_msg", str2);
        } catch (JSONException unused) {
        }
        sendResponseToMerchant(str3, jSONObject.toString(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendResponseToMerchant(String str, String str2, int i) {
        Intent intent = new Intent();
        intent.putExtra("result", str);
        intent.putExtra("payment_response", str2);
        setResult(i, intent);
        finish();
    }

    private class PWEWebViewClient extends WebViewClient {
        private PWEWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            PWEBankPageActivity.this.isRedirected = true;
            return false;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            boolean unused = PWEBankPageActivity.this.isRedirected;
            PWEBankPageActivity.this.isRedirected = false;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            boolean unused = PWEBankPageActivity.this.isRedirected;
            super.onPageFinished(webView, str);
            if (PWEBankPageActivity.this.auto_otp_flag) {
                PWEBankPageActivity.this.find_and_submit_otp();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        this.webviewProcessPayment.saveState(bundle);
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        this.paymentInfoHandler.setPweLastTransactionStatus(PWEStaticHelper.PWE_CURRENT_TRXN_STATUS);
        super.onPause();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        try {
            if (this.auto_otp_flag) {
                unregisterReceiver(this.pweSMSConsentReceiver);
            }
            this.bottom_sheet_auto_otp.dismiss();
        } catch (Exception unused) {
        }
        super.onDestroy();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        showUserConfirmationDialog("Cancel Transaction", "Do you really want to cancel this transaction ?");
    }
}
