package com.easebuzz.payment.kit;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import clientRequestsApi.RetroAPI;
import com.amazonaws.services.s3.internal.Constants;
import com.amazonaws.services.s3.util.Mimetypes;
import com.appnew.android.Utils.Const;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.login.widget.ToolTipPopup;
import datamodels.PWEStaticDataModel;
import helper.ToStringConverterFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: classes7.dex */
public class PWEInstaCollectFragment extends Fragment {
    private Activity activity;
    private Button btnCancelTransaction;
    private Button btnGenerateAccountNumber;
    private Button btnSendDetails;
    private CheckBox cbEmail;
    private CheckBox cbSms;
    private CheckBox cbWhatsapp;
    private TimerTask checkStatusTask;
    private PWECouponsActivity couponsActivity;
    private PWEGeneralHelper generalHelper;
    public Dialog instaCollcetBottomSheetDialog;
    private View instaCollectView;
    private boolean isRedirected;
    private LinearLayout linearInstaCollectViewLayout;
    private LinearLayout linearTransactionButtonsLayout;
    public Dialog mwssageDialog;
    private PWEPaymentInfoHandler paymentInfoHandler;
    private TimerTask responseTimerTask;
    private Map submitInitiateParametersJsonObj;
    private Timer timerResponse;
    private TextView tvAccountNumber;
    private TextView tvBeneficiaryName;
    private TextView tvErrorMsg;
    private TextView tvIfscCode;
    private TextView tvInstaCollectErrorMsg;
    private TextView tvInstaCollectLabel;
    private TextView tvInstaCollectText;
    private TextView tvInstaNoteMessage;
    private TextView tvResponseMsg;
    private WebView webviewProcessInstaPayment;
    private final Handler checkStatusHandler = new Handler();
    private Timer checkStatusTimer = new Timer();
    private String payUsingText = "Pay using IMPS, NEFT, or RTGS";
    private String beneficiaryActivateText = "IMPS/NEFT/RTGS";
    private String pwe_action = "";
    private boolean is_check_status_timer_started = false;
    private Bundle instance_state = null;
    private String selected_payment_option = "";
    private String account_number = "";
    private String ifsc_code = "";
    private String merchant_name = "";
    private String EndPointUrl = "";
    private int redirectTime = 10;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        this.instance_state = bundle;
        super.onCreate(bundle);
        this.timerResponse = new Timer();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.instaCollectView = layoutInflater.inflate(R.layout.fragment_pwe_insta_collect, viewGroup, false);
        this.paymentInfoHandler = new PWEPaymentInfoHandler(getActivity());
        this.generalHelper = new PWEGeneralHelper(getActivity());
        this.tvInstaCollectLabel = (TextView) this.instaCollectView.findViewById(R.id.text_insta_collect_label);
        this.tvInstaCollectText = (TextView) this.instaCollectView.findViewById(R.id.text_insta_collect_text);
        this.tvInstaCollectErrorMsg = (TextView) this.instaCollectView.findViewById(R.id.text_insta_collect_error);
        Button button = (Button) this.instaCollectView.findViewById(R.id.button_proceed_for_payment);
        this.btnGenerateAccountNumber = button;
        button.setText("Generate Account Number");
        this.tvInstaNoteMessage = (TextView) this.instaCollectView.findViewById(R.id.text_note_message);
        if (this.paymentInfoHandler.getInstacollectNoteMessage().equals(Constants.NULL_VERSION_ID) || this.paymentInfoHandler.getInstacollectNoteMessage().equals("")) {
            this.tvInstaNoteMessage.setVisibility(8);
        } else {
            this.tvInstaNoteMessage.setVisibility(0);
            this.tvInstaNoteMessage.setText(Html.fromHtml(this.paymentInfoHandler.getInstacollectNoteMessage()));
        }
        FragmentActivity activity = getActivity();
        this.activity = activity;
        if (activity instanceof PWECouponsActivity) {
            this.couponsActivity = (PWECouponsActivity) activity;
        }
        this.selected_payment_option = PWEStaticDataModel.INSTA_COLLECT_NAME;
        this.merchant_name = this.paymentInfoHandler.getMerchantName();
        if (Double.parseDouble(this.paymentInfoHandler.getPayAmountStr()) > PWEStaticDataModel.MAX_IMPS_AMOUNT_LIMIT.doubleValue()) {
            this.payUsingText = "Pay using NEFT, or RTGS";
            this.beneficiaryActivateText = "NEFT/RTGS";
        }
        this.selected_payment_option = this.paymentInfoHandler.getSelectedPaymentOption();
        this.submitInitiateParametersJsonObj = new HashMap();
        this.EndPointUrl = this.generalHelper.getAPIBaseURL();
        this.tvInstaCollectLabel.setText(this.payUsingText);
        this.tvInstaCollectText.setText("• Go to your net banking web portal or mobile application.\n\n• Add above mentioned Account Number & IFSC as beneficiary.\n\n• Once the beneficiary is activated, you can make " + this.beneficiaryActivateText + " transaction to added beneficiary.\n\n• This account number is unique for this transaction and please do not share or make additional payments to this account.");
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            this.btnGenerateAccountNumber.setBackground(getActivity().getResources().getDrawable(R.drawable.pwe_android_tv_button));
            this.generalHelper.changeButtonWidth(this.btnGenerateAccountNumber);
        }
        this.btnGenerateAccountNumber.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWEInstaCollectFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PWEInstaCollectFragment.this.couponsActivity.showPWELoader();
                PWEInstaCollectFragment.this.tvInstaCollectErrorMsg.setVisibility(8);
                PWEInstaCollectFragment.this.tvInstaCollectErrorMsg.setText("");
                PWEInstaCollectFragment.this.generateAccountNumber();
            }
        });
        return this.instaCollectView;
    }

    public void openBottomInstaCollectDialog() {
        View viewInflate = getLayoutInflater().inflate(R.layout.pwe_insta_collect_dialog, (ViewGroup) null);
        Dialog dialog = new Dialog(getActivity(), R.style.MaterialDialogSheet);
        this.instaCollcetBottomSheetDialog = dialog;
        dialog.setContentView(viewInflate);
        this.instaCollcetBottomSheetDialog.getWindow().setLayout(-1, -2);
        this.tvBeneficiaryName = (TextView) viewInflate.findViewById(R.id.text_beneficiary_name);
        this.tvAccountNumber = (TextView) viewInflate.findViewById(R.id.text_account_number);
        this.tvIfscCode = (TextView) viewInflate.findViewById(R.id.text_ifsc_code);
        this.tvErrorMsg = (TextView) viewInflate.findViewById(R.id.text_error_msg);
        this.cbWhatsapp = (CheckBox) viewInflate.findViewById(R.id.cb_Whatsapp);
        this.cbSms = (CheckBox) viewInflate.findViewById(R.id.cb_sms);
        this.cbEmail = (CheckBox) viewInflate.findViewById(R.id.cb_email);
        this.btnSendDetails = (Button) viewInflate.findViewById(R.id.btn_send_details);
        this.btnCancelTransaction = (Button) viewInflate.findViewById(R.id.btn_cancel_transaction);
        this.linearTransactionButtonsLayout = (LinearLayout) viewInflate.findViewById(R.id.linear_transactions_button_layout);
        this.linearInstaCollectViewLayout = (LinearLayout) viewInflate.findViewById(R.id.linear_insta_collect_layout);
        this.webviewProcessInstaPayment = (WebView) viewInflate.findViewById(R.id.webview_process_insta_payment);
        this.instaCollcetBottomSheetDialog.getWindow().setGravity(80);
        this.instaCollcetBottomSheetDialog.setCancelable(false);
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            this.btnSendDetails.setBackground(getActivity().getResources().getDrawable(R.drawable.pwe_android_tv_button));
            this.btnCancelTransaction.setBackground(getActivity().getResources().getDrawable(R.drawable.pwe_android_tv_button));
            this.generalHelper.changeButtonWidth(this.btnGenerateAccountNumber);
        }
        this.instaCollcetBottomSheetDialog.show();
        this.btnSendDetails.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWEInstaCollectFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PWEInstaCollectFragment.this.cbWhatsapp.isChecked() || PWEInstaCollectFragment.this.cbEmail.isChecked() || PWEInstaCollectFragment.this.cbSms.isChecked()) {
                    PWEInstaCollectFragment.this.tvErrorMsg.setVisibility(8);
                    PWEInstaCollectFragment.this.dismissInstaCollectBottomSheet();
                    PWEInstaCollectFragment.this.openMessageDialog();
                    PWEInstaCollectFragment.this.startInstaCollectRequestTimer();
                    return;
                }
                PWEInstaCollectFragment.this.tvErrorMsg.setVisibility(0);
                PWEInstaCollectFragment.this.tvErrorMsg.setText("Please select notification option to send details");
            }
        });
        this.btnCancelTransaction.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWEInstaCollectFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PWEInstaCollectFragment.this.couponsActivity.showPWELoader();
                PWEInstaCollectFragment.this.cancelInstaCollectRequest();
                PWEInstaCollectFragment.this.dismissInstaCollectBottomSheet();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openMessageDialog() {
        View viewInflate = getLayoutInflater().inflate(R.layout.pwe_custom_message_dialog, (ViewGroup) null);
        Dialog dialog = new Dialog(getActivity());
        this.mwssageDialog = dialog;
        dialog.setContentView(viewInflate);
        TextView textView = (TextView) viewInflate.findViewById(R.id.text_response_msg);
        this.tvResponseMsg = textView;
        textView.setVisibility(0);
        this.mwssageDialog.getWindow().setLayout(-1, -2);
        this.mwssageDialog.setCancelable(false);
        this.mwssageDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.mwssageDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitInstaCollectForm() {
        WebSettings settings = this.webviewProcessInstaPayment.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setMixedContentMode(0);
        settings.setCacheMode(2);
        settings.setSupportMultipleWindows(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        this.webviewProcessInstaPayment.setLayerType(2, null);
        this.webviewProcessInstaPayment.setWebViewClient(new PWEWebViewClient());
        this.webviewProcessInstaPayment.addJavascriptInterface(new PWEPaymentStatus(), "PwePayStatus");
        if (this.paymentInfoHandler.getPaymentMode().equals(Const.TEST)) {
            this.pwe_action = "" + PWEStaticDataModel.REST_BASE_URL_TEST + "/response/insta";
        } else {
            this.pwe_action = "" + PWEStaticDataModel.REST_BASE_URL + "/response/insta";
        }
        String autoSubmitFormFromAssets = getAutoSubmitFormFromAssets();
        WebView.setWebContentsDebuggingEnabled(false);
        Bundle bundle = this.instance_state;
        if (bundle != null) {
            this.webviewProcessInstaPayment.restoreState(bundle);
        } else {
            this.webviewProcessInstaPayment.loadData(autoSubmitFormFromAssets, Mimetypes.MIMETYPE_HTML, "UTF-8");
        }
        this.webviewProcessInstaPayment.setOnTouchListener(new View.OnTouchListener() { // from class: com.easebuzz.payment.kit.PWEInstaCollectFragment.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                PWEInstaCollectFragment.this.webviewProcessInstaPayment.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void generateAccountNumber() {
        getSubmitInstaCollectParameters();
        ((RetroAPI) new Retrofit.Builder().baseUrl(this.EndPointUrl).addConverterFactory(new ToStringConverterFactory()).callFactory(this.generalHelper.getRetrofitConnectionFactory()).build().create(RetroAPI.class)).submitInitiatePayment(this.submitInitiateParametersJsonObj).enqueue(new Callback<String>() { // from class: com.easebuzz.payment.kit.PWEInstaCollectFragment.5
            @Override // retrofit2.Callback
            public void onResponse(Call<String> call, Response<String> response) {
                try {
                    PWEInstaCollectFragment.this.couponsActivity.hidePWELoader();
                    PWEInstaCollectFragment.this.handleGenrateAccountNumber(response.body().toString());
                } catch (Exception unused) {
                    PWEInstaCollectFragment.this.couponsActivity.sendFailedResponseMerchant(PWEStaticDataModel.SERVER_ERROR_STR, PWEStaticDataModel.ERROR_DESC_STR, PWEStaticDataModel.TXN_ERROR_SERVER_ERROR_CODE);
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<String> call, Throwable th) {
                PWEInstaCollectFragment.this.couponsActivity.hidePWELoader();
                PWEInstaCollectFragment.this.generalHelper.showPweToast(PWEStaticDataModel.SERVER_ERROR_STR + ", Please try again");
                PWEInstaCollectFragment.this.dismissInstaCollectBottomSheet();
            }
        });
    }

    private void getSubmitInstaCollectParameters() {
        try {
            this.submitInitiateParametersJsonObj.put("paymentoption", this.selected_payment_option);
            this.submitInitiateParametersJsonObj.put(Const.ZOOM_ACCESS_KEY, this.paymentInfoHandler.getMerchantAccessKey());
            this.submitInitiateParametersJsonObj.put("selected_coupon", this.paymentInfoHandler.getSelectedCouponIdList());
            this.submitInitiateParametersJsonObj.put("userAgent", "userAgent");
            this.submitInitiateParametersJsonObj.put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, "android");
            this.submitInitiateParametersJsonObj.put("ismobile", "1");
            this.submitInitiateParametersJsonObj.put("is_auto_submit", true);
            CheckBox checkBox = this.cbWhatsapp;
            if (checkBox != null) {
                this.submitInitiateParametersJsonObj.put("insta_whatsapp", Boolean.valueOf(checkBox.isChecked()));
            }
            CheckBox checkBox2 = this.cbSms;
            if (checkBox2 != null) {
                this.submitInitiateParametersJsonObj.put("insta_sms", Boolean.valueOf(checkBox2.isChecked()));
            }
            CheckBox checkBox3 = this.cbEmail;
            if (checkBox3 != null) {
                this.submitInitiateParametersJsonObj.put("insta_email", Boolean.valueOf(checkBox3.isChecked()));
            }
            this.submitInitiateParametersJsonObj.put("insta_account_number", this.account_number);
            this.submitInitiateParametersJsonObj.put("insta_ifsc", this.ifsc_code);
            this.submitInitiateParametersJsonObj.put("merchant_name", this.merchant_name);
        } catch (Error e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleGenrateAccountNumber(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optBoolean("status", false)) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data").optJSONObject("data").optJSONObject("transaction_order").optJSONObject("virtual_account");
                if (jSONObjectOptJSONObject != null) {
                    this.account_number = jSONObjectOptJSONObject.optString("account_number", "");
                    this.ifsc_code = jSONObjectOptJSONObject.optString("ifsc", "");
                    openBottomInstaCollectDialog();
                    this.tvBeneficiaryName.setText(this.merchant_name);
                    this.tvAccountNumber.setText(this.account_number);
                    this.tvIfscCode.setText(this.ifsc_code);
                    checkInstaCollectTransactionStatus();
                    return;
                }
                this.generalHelper.showPweToast(PWEStaticDataModel.SERVER_ERROR_STR + ", Please try again");
                return;
            }
            String strOptString = jSONObject.optString("error", "Please try other payment option.");
            this.tvInstaCollectErrorMsg.setVisibility(0);
            this.tvInstaCollectErrorMsg.setText(strOptString);
            dismissInstaCollectBottomSheet();
        } catch (Exception unused) {
            this.couponsActivity.sendFailedResponseMerchant(PWEStaticDataModel.SERVER_ERROR_STR, PWEStaticDataModel.ERROR_DESC_STR, PWEStaticDataModel.TXN_ERROR_SERVER_ERROR_CODE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelInstaCollectRequest() {
        getSubmitInstaCollectParameters();
        ((RetroAPI) new Retrofit.Builder().baseUrl(this.generalHelper.getUPIAPIBaseURL()).addConverterFactory(new ToStringConverterFactory()).callFactory(this.generalHelper.getRetrofitConnectionFactory()).build().create(RetroAPI.class)).cancelInstaCollectRequest(this.submitInitiateParametersJsonObj).enqueue(new Callback<String>() { // from class: com.easebuzz.payment.kit.PWEInstaCollectFragment.6
            @Override // retrofit2.Callback
            public void onResponse(Call<String> call, Response<String> response) {
                try {
                    PWEInstaCollectFragment.this.couponsActivity.hidePWELoader();
                    PWEInstaCollectFragment.this.handleCancelInstaCollectRequest(response.body().toString());
                } catch (Exception unused) {
                    PWEInstaCollectFragment.this.couponsActivity.sendFailedResponseMerchant(PWEStaticDataModel.SERVER_ERROR_STR, PWEStaticDataModel.ERROR_DESC_STR, PWEStaticDataModel.TXN_ERROR_SERVER_ERROR_CODE);
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<String> call, Throwable th) {
                PWEInstaCollectFragment.this.couponsActivity.hidePWELoader();
                PWEInstaCollectFragment.this.dismissInstaCollectBottomSheet();
                PWEInstaCollectFragment.this.dismissCheckStatusTimer();
                PWEInstaCollectFragment.this.couponsActivity.sendFailedResponseMerchant(PWEStaticDataModel.SERVER_ERROR_STR, PWEStaticDataModel.ERROR_DESC_STR, PWEStaticDataModel.TXN_ERROR_SERVER_ERROR_CODE);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCancelInstaCollectRequest(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optBoolean("status", false)) {
                String string = jSONObject.getString("payment_response");
                dismissCheckStatusTimer();
                this.couponsActivity.sendResponseToMerchant(PWEStaticDataModel.TXN_USERCANCELLED_CODE, string, 0);
            } else {
                this.generalHelper.showPweToast(jSONObject.optString("error", "Please try other payment option."));
                dismissCheckStatusTimer();
                dismissInstaCollectBottomSheet();
            }
        } catch (Exception unused) {
            dismissCheckStatusTimer();
            this.couponsActivity.sendFailedResponseMerchant(PWEStaticDataModel.SERVER_ERROR_STR, PWEStaticDataModel.ERROR_DESC_STR, PWEStaticDataModel.TXN_ERROR_SERVER_ERROR_CODE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkInstaCollectTransactionStatus() {
        getSubmitInstaCollectParameters();
        ((RetroAPI) new Retrofit.Builder().baseUrl(this.generalHelper.getUPIAPIBaseURL()).addConverterFactory(new ToStringConverterFactory()).callFactory(this.generalHelper.getRetrofitConnectionFactory()).build().create(RetroAPI.class)).checkInstaCollectStatus(this.submitInitiateParametersJsonObj).enqueue(new Callback<String>() { // from class: com.easebuzz.payment.kit.PWEInstaCollectFragment.7
            @Override // retrofit2.Callback
            public void onResponse(Call<String> call, Response<String> response) {
                if (response != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(response.body().toString());
                        if (jSONObject.getString("status").equals("false")) {
                            if (PWEInstaCollectFragment.this.is_check_status_timer_started) {
                                return;
                            }
                            PWEInstaCollectFragment.this.is_check_status_timer_started = true;
                            PWEInstaCollectFragment.this.initiateCheckStatusTask();
                            return;
                        }
                        if (jSONObject.getString("status").equals("true")) {
                            PWEInstaCollectFragment.this.submitInstaCollectForm();
                        }
                    } catch (Exception unused) {
                        PWEInstaCollectFragment.this.couponsActivity.sendFailedResponseMerchant(PWEStaticDataModel.SERVER_ERROR_STR, PWEStaticDataModel.ERROR_DESC_STR, PWEStaticDataModel.TXN_ERROR_SERVER_ERROR_CODE);
                    }
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<String> call, Throwable th) {
                if (!PWEInstaCollectFragment.this.is_check_status_timer_started) {
                    PWEInstaCollectFragment.this.is_check_status_timer_started = true;
                    PWEInstaCollectFragment.this.initiateCheckStatusTask();
                } else {
                    PWEInstaCollectFragment.this.dismissCheckStatusTimer();
                    PWEInstaCollectFragment.this.couponsActivity.sendFailedResponseMerchant(PWEStaticDataModel.SERVER_ERROR_STR, PWEStaticDataModel.ERROR_DESC_STR, PWEStaticDataModel.TXN_ERROR_SERVER_ERROR_CODE);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initiateCheckStatusTask() {
        TimerTask timerTask = new TimerTask() { // from class: com.easebuzz.payment.kit.PWEInstaCollectFragment.8
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                PWEInstaCollectFragment.this.checkStatusHandler.post(new Runnable() { // from class: com.easebuzz.payment.kit.PWEInstaCollectFragment.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        new PerformBackgroundStatusTask().execute(new String[0]);
                    }
                });
            }
        };
        this.checkStatusTask = timerTask;
        this.checkStatusTimer.scheduleAtFixedRate(timerTask, 0L, ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME);
    }

    private class PerformBackgroundStatusTask extends AsyncTask<String, Void, String> {
        private PerformBackgroundStatusTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(String... strArr) {
            PWEInstaCollectFragment.this.checkInstaCollectTransactionStatus();
            return null;
        }
    }

    public void dismissCheckStatusTimer() {
        try {
            Timer timer = this.checkStatusTimer;
            if (timer != null) {
                timer.cancel();
            }
        } catch (Error | Exception unused) {
        }
    }

    public void dismissInstaCollectBottomSheet() {
        try {
            Dialog dialog = this.instaCollcetBottomSheetDialog;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            this.instaCollcetBottomSheetDialog.dismiss();
        } catch (Error | Exception unused) {
        }
    }

    public void dismissMessageDialog() {
        try {
            Dialog dialog = this.mwssageDialog;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            this.mwssageDialog.dismiss();
        } catch (Error | Exception unused) {
        }
    }

    private String getAutoSubmitFormFromAssets() {
        String str = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.couponsActivity.getAssets().open("pwe_insta_collect_auto_submit.html")));
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
                PWEInstaCollectFragment.this.couponsActivity.runOnUiThread(new Runnable() { // from class: com.easebuzz.payment.kit.PWEInstaCollectFragment.PWEPaymentStatus.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String string2;
                        PWEInstaCollectFragment.this.dismissInstaCollectBottomSheet();
                        PWEInstaCollectFragment.this.dismissMessageDialog();
                        if (string.equals("1")) {
                            try {
                                PWEInstaCollectFragment.this.dismissCheckStatusTimer();
                                String string3 = jSONObject.getString("error_status");
                                String strOptString = jSONObject.optString("msg", "Transaction failed");
                                String strOptString2 = jSONObject.optString("msg_desc", PWEStaticDataModel.ERROR_DESC_STR);
                                if (string3.equals("cardvalidation")) {
                                    return;
                                }
                                PWEInstaCollectFragment.this.couponsActivity.sendFailedResponseMerchant(strOptString, strOptString2, PWEStaticDataModel.TXN_ERROR_TXN_NOT_ALLOWED_CODE);
                                return;
                            } catch (Exception unused) {
                                PWEInstaCollectFragment.this.dismissCheckStatusTimer();
                                PWEInstaCollectFragment.this.couponsActivity.sendFailedResponseMerchant(PWEStaticDataModel.SERVER_ERROR_STR, PWEStaticDataModel.ERROR_DESC_STR, PWEStaticDataModel.TXN_ERROR_SERVER_ERROR_CODE);
                                return;
                            }
                        }
                        try {
                            string2 = jSONObject.getString("status");
                        } catch (Exception unused2) {
                            PWEInstaCollectFragment.this.dismissCheckStatusTimer();
                            PWEInstaCollectFragment.this.couponsActivity.sendFailedResponseMerchant(PWEStaticDataModel.SERVER_ERROR_STR, PWEStaticDataModel.ERROR_DESC_STR, PWEStaticDataModel.TXN_ERROR_SERVER_ERROR_CODE);
                            string2 = "";
                        }
                        PWEInstaCollectFragment.this.dismissCheckStatusTimer();
                        if (string2.equals("success")) {
                            PWEInstaCollectFragment.this.couponsActivity.sendResponseToMerchant(PWEStaticDataModel.TXN_SUCCESS_CODE, str, -1);
                        } else if (string2.equals(PWEStaticDataModel.PWE_STATUS_PENDING)) {
                            PWEInstaCollectFragment.this.couponsActivity.sendResponseToMerchant(PWEStaticDataModel.TXN_PENDING_CODE, str, -1);
                        } else {
                            PWEInstaCollectFragment.this.couponsActivity.sendResponseToMerchant("payment_failed", str, 0);
                        }
                    }
                });
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }

        @JavascriptInterface
        public String getPweAction() {
            return PWEInstaCollectFragment.this.pwe_action;
        }

        @JavascriptInterface
        public String getAccessKeyFromApp() {
            return PWEInstaCollectFragment.this.paymentInfoHandler.getMerchantAccessKey();
        }

        @JavascriptInterface
        public String getPaymentOptionFromApp() {
            return PWEInstaCollectFragment.this.selected_payment_option;
        }

        @JavascriptInterface
        public String getSelectedCouponFromApp() {
            return "" + PWEInstaCollectFragment.this.paymentInfoHandler.getSelectedCouponIdList();
        }

        @JavascriptInterface
        public String getUserAgentFromApp() {
            return PWEInstaCollectFragment.this.submitInitiateParametersJsonObj.get("userAgent").toString();
        }

        @JavascriptInterface
        public String getDeviceFromApp() {
            return PWEInstaCollectFragment.this.submitInitiateParametersJsonObj.get(DeviceRequestsHelper.DEVICE_INFO_DEVICE).toString();
        }

        @JavascriptInterface
        public String getIsAutoDebitFromApp() {
            return PWEInstaCollectFragment.this.submitInitiateParametersJsonObj.get("is_auto_submit").toString();
        }

        @JavascriptInterface
        public String getIsInstaWhatsappFromApp() {
            return PWEInstaCollectFragment.this.submitInitiateParametersJsonObj.get("insta_whatsapp").toString();
        }

        @JavascriptInterface
        public String getIsInstaSmsFromApp() {
            return PWEInstaCollectFragment.this.submitInitiateParametersJsonObj.get("insta_sms").toString();
        }

        @JavascriptInterface
        public String getIsInstaEmailFromApp() {
            return "" + PWEInstaCollectFragment.this.submitInitiateParametersJsonObj.get("insta_email").toString();
        }

        @JavascriptInterface
        public String getIsInstaAccountNoFromApp() {
            return PWEInstaCollectFragment.this.submitInitiateParametersJsonObj.get("insta_account_number").toString();
        }

        @JavascriptInterface
        public String getIsInstaIfscFromApp() {
            return PWEInstaCollectFragment.this.submitInitiateParametersJsonObj.get("insta_ifsc").toString();
        }

        @JavascriptInterface
        public String getIsMerchantNameFromApp() {
            return PWEInstaCollectFragment.this.submitInitiateParametersJsonObj.get("merchant_name").toString();
        }

        @JavascriptInterface
        public String getisMobileFromApp() {
            return "1";
        }
    }

    private class PWEWebViewClient extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return false;
        }

        private PWEWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            PWEInstaCollectFragment.this.isRedirected = false;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startInstaCollectRequestTimer() {
        this.tvResponseMsg.setVisibility(0);
        TimerTask timerTask = new TimerTask() { // from class: com.easebuzz.payment.kit.PWEInstaCollectFragment.9
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (PWEInstaCollectFragment.this.redirectTime > 0) {
                    PWEInstaCollectFragment pWEInstaCollectFragment = PWEInstaCollectFragment.this;
                    pWEInstaCollectFragment.redirectTime--;
                    PWEInstaCollectFragment.this.couponsActivity.runOnUiThread(new Runnable() { // from class: com.easebuzz.payment.kit.PWEInstaCollectFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PWEInstaCollectFragment.this.tvResponseMsg.setText("We are expecting your payment by few hours, You should be automatically redirecting into app in " + PWEInstaCollectFragment.this.redirectTime + " secounds.");
                        }
                    });
                }
                if (PWEInstaCollectFragment.this.redirectTime == 3) {
                    PWEInstaCollectFragment.this.couponsActivity.runOnUiThread(new Runnable() { // from class: com.easebuzz.payment.kit.PWEInstaCollectFragment.9.2
                        @Override // java.lang.Runnable
                        public void run() {
                            PWEInstaCollectFragment.this.submitInstaCollectForm();
                        }
                    });
                }
            }
        };
        this.responseTimerTask = timerTask;
        this.timerResponse.scheduleAtFixedRate(timerTask, 0L, 1000L);
    }
}
