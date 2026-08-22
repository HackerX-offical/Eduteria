package com.easebuzz.payment.kit;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import clientRequestsApi.RetroAPI;
import com.amazonaws.services.s3.internal.Constants;
import com.appnew.android.Utils.Const;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.material.timepicker.TimeModel;
import com.google.firebase.crashlytics.internal.common.IdManager;
import datamodels.CouponDataModel;
import datamodels.DiscountCodeDataModel;
import datamodels.PWEPaymentOptionDataModel;
import datamodels.PWEStaticDataModel;
import helper.PWECustomComponentHelper;
import helper.PWETimerHelper;
import helper.ToStringConverterFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import listeners.KeyBoardListener;
import listeners.PWEDiscountListener;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: classes7.dex */
public class PWECouponsActivity extends AppCompatActivity {
    private static int retry_cancel_count;
    private AlertDialog alertDialog_;
    private Button btnApplyCashbackLayout;
    private Button btnCancelTransaction;
    private Button btnFailedTransaction;
    private Button btnViewAndApplyDiscount;
    private Button buttonResetAppliedDiscount;
    private JSONObject customOptionsObject;
    private PWEDiscountHelper discountCodeHelper;
    private FragmentManager fManager;
    private PWEGeneralHelper generalHelper;
    public ImageView imageDiscountIcon;
    public ImageView imageDiscountIcon2;
    private ImageView imgClearAppliedDiscount;
    private ImageView imgMerchantLogo;
    private Map initiateReqParametersJsonObj;
    private ImageView ivCloseMessage;
    public KeyBoardListener kbl;
    public LinearLayout linearAppliedDiscountCodeHolder;
    private LinearLayout linearApplyCashbackBtnLayout;
    private LinearLayout linearApplyCashbackLayout;
    public LinearLayout linearApplyDiscountCodeHolder;
    private LinearLayout linearCashbackLayout;
    public LinearLayout linearConvFeeWithDiscountHolder;
    private LinearLayout linearDiscountCodeHolder;
    public LinearLayout linearDiscountedAmountHolder;
    private LinearLayout linearFragmentHolderParent;
    private LinearLayout linearGoBackLayout;
    private ImageButton linearGoBackLayoutBtn;
    private LinearLayout linearOpenMessage;
    private LinearLayout linearPayAmountSection1;
    private LinearLayout linearPayAmountSection2;
    private LinearLayout linearRootFooter;
    private LinearLayout linearRootHeader;
    private View messageBottomSheet;
    private CoordinatorLayout msgContainerLayout;
    private PayAmountHelper payAmtHelper;
    private PWEPaymentInfoHandler paymentInfoHandler;
    private JSONArray paymentOptionData;
    private PWEMessageCardPageHelper pweCardPageMessageHelper;
    private PWECustomComponentHelper pweCustomComponentHelper;
    public Dialog pweLoader;
    private ScrollView scrollViewContainer;
    private CouponDataModel selectedCouponModel;
    private BroadcastReceiver timerBroadCastReciever;
    private PWETimerHelper transactionTimerHelper;
    private TextView tvAllowedCashbackWorth;
    public TextView tvAppliedDiscountCode;
    public TextView tvAppliedDiscountType;
    public TextView tvAvailableCodesCount;
    private TextView tvConvFeeHeader1;
    private TextView tvConvFeeHeader2;
    public TextView tvConvFeeWithDiscount;
    public TextView tvDiscountAmount;
    public TextView tvDiscountedAmount;
    private TextView tvInitialAmountToPay1;
    private TextView tvInitialAmountToPay2;
    private TextView tvMerchantName;
    private TextView tvResetAppliedDiscount;
    private TextView tvSelectedCouponsCount;
    private TextView tvSessionTime;
    private TextView tvShortMessage;
    private TextView tvTotalAmountPayable;
    private TextView tvViewAndApplyDiscount;
    private AlertDialog userCancelAlertDialog;
    public View viewDiscountDivider;
    private WebView wvMessageDescription;
    public String bin_number = "";
    public String bank_wallet_name = "";
    public String card_id = "";
    private ArrayList<DiscountCodeDataModel> discount_list = new ArrayList<>();
    public String discount_validation_error = "";
    private String merchantTrxnId = "";
    private String merchantTrxnAmount = IdManager.DEFAULT_VERSION_NAME;
    private String client_error = "";
    private String client_error_description = "";
    private String EndPointUrl = "";
    private String access_key = "";
    private Fragment fragment = null;
    private Bundle instanceState = null;
    private FragmentTransaction fTransaction = null;
    private int BANK_PAGE_REDIRECTION_REQUEST_CODE = 111;
    private boolean showLogo = false;
    private String logoUrl = "";
    private boolean isAccesskey = true;
    private ActivityResultLauncher<Intent> pweBankPageActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: com.easebuzz.payment.kit.PWECouponsActivity.1
        @Override // androidx.activity.result.ActivityResultCallback
        public void onActivityResult(ActivityResult activityResult) {
            Intent data = activityResult.getData();
            if (data != null) {
                PWECouponsActivity.this.sendResponseToMerchant(data.getStringExtra("result"), data.getStringExtra("payment_response"), 0);
                return;
            }
            PWECouponsActivity.this.sendFailedResponseMerchant("Payment failed", PWEStaticDataModel.TRXN_FAILED_MONEY_DEDUCTED, "payment_failed");
        }
    });

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.instanceState = bundle;
        super.onCreate(bundle);
        setContentView(R.layout.activity_pwecoupons_new);
        PWEStaticDataModel.PWE_MODE_SELECTED = "paymentoption";
        PWEStaticDataModel.SELECTED_COUPON_COUNT = 0;
        this.transactionTimerHelper = new PWETimerHelper(this);
        this.paymentInfoHandler = new PWEPaymentInfoHandler(this);
        this.generalHelper = new PWEGeneralHelper(this);
        this.pweCustomComponentHelper = new PWECustomComponentHelper(this);
        this.pweCardPageMessageHelper = new PWEMessageCardPageHelper(this);
        this.payAmtHelper = new PayAmountHelper(this);
        PWEStaticHelper.PWE_CURRENT_TRXN_STATUS = PWEStaticDataModel.PWE_STATUS_PRE_INITIATED;
        setDeviceType();
        this.merchantTrxnAmount = IdManager.DEFAULT_VERSION_NAME;
        this.merchantTrxnId = "";
        PWEStaticDataModel.IS_APP_MINIMIZE = 0;
        this.paymentInfoHandler.setSelectedCashbackCouponCount(PWEStaticDataModel.SELECTED_COUPON_COUNT);
        this.fManager = getSupportFragmentManager();
        if (this.instanceState != null) {
            PWEStaticDataModel.IS_APP_REINITIALIZED = true;
            restoreMainState();
        } else {
            PWEStaticDataModel.IS_APP_REINITIALIZED = false;
        }
        initViews();
        this.generalHelper.disableScreenRecording(this);
        PWEStaticDataModel.CUSTOMER_PHONE = "";
        retry_cancel_count = 0;
        if (!PWEStaticDataModel.IS_APP_REINITIALIZED) {
            resetTrxnPreferences();
        }
        this.isAccesskey = getIntent().hasExtra(Const.ZOOM_ACCESS_KEY);
        getParameters();
        if (this.paymentInfoHandler.getPaymentMode().equals(Const.TEST)) {
            this.btnFailedTransaction.setVisibility(0);
        } else {
            this.btnFailedTransaction.setVisibility(8);
        }
        this.EndPointUrl = this.generalHelper.getAPIBaseURL();
        if (PWEStaticDataModel.IS_APP_REINITIALIZED) {
            PWEStaticHelper.PWE_CURRENT_TRXN_STATUS = this.paymentInfoHandler.getPweLastTransactionStatus();
            if (PWEStaticHelper.PWE_CURRENT_TRXN_STATUS.equals(PWEStaticDataModel.PWE_STATUS_INITIATED)) {
                setBasicInfo();
                return;
            }
            return;
        }
        if (validatePaymentParameters()) {
            if (this.isAccesskey) {
                initiatePayment2();
                return;
            } else {
                initiatePayment();
                return;
            }
        }
        showErrorDialog(this.client_error, this.client_error_description, PWEStaticDataModel.TXN_ERROR_RETRY_FAILED_CODE);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    private void setDeviceType() {
        int currentModeType = ((UiModeManager) getSystemService("uimode")).getCurrentModeType();
        if (currentModeType == 4) {
            this.paymentInfoHandler.setPWEDeviceType("TV");
            PWEStaticDataModel.PWE_CURRENT_DEVICE_TYPE = "TV";
        } else if (currentModeType == 1) {
            this.paymentInfoHandler.setPWEDeviceType("NORMAL");
            PWEStaticDataModel.PWE_CURRENT_DEVICE_TYPE = "NORMAL";
        } else {
            this.paymentInfoHandler.setPWEDeviceType("NORMAL");
            PWEStaticDataModel.PWE_CURRENT_DEVICE_TYPE = "NORMAL";
        }
    }

    private void initViews() {
        this.pweLoader = this.pweCustomComponentHelper.getPWELoader(this, PWEStaticDataModel.PWE_LOADER_STYLE);
        this.tvShortMessage = (TextView) findViewById(R.id.txt_short_message);
        this.linearOpenMessage = (LinearLayout) findViewById(R.id.linear_open_msg);
        this.messageBottomSheet = findViewById(R.id.linear_card_page_msg_bottom_sheet);
        this.msgContainerLayout = (CoordinatorLayout) findViewById(R.id.clayout_card_page_msg_container);
        this.ivCloseMessage = (ImageView) findViewById(R.id.img_close_message);
        this.wvMessageDescription = (WebView) findViewById(R.id.webview_message_description);
        this.ivCloseMessage.animate().scaleX(0.0f).scaleY(0.0f).setDuration(0L).start();
        this.pweCardPageMessageHelper.initializeMessageLayoutNew(this.linearOpenMessage, this.tvShortMessage, this.messageBottomSheet, this.msgContainerLayout, this.ivCloseMessage, this.wvMessageDescription);
        this.tvMerchantName = (TextView) findViewById(R.id.text_merchant_name);
        this.imgMerchantLogo = (ImageView) findViewById(R.id.image_merchant_logo);
        this.linearGoBackLayoutBtn = (ImageButton) findViewById(R.id.linear_go_back_img_btn);
        this.linearGoBackLayout = (LinearLayout) findViewById(R.id.linear_go_back);
        this.tvViewAndApplyDiscount = (TextView) findViewById(R.id.text_apply_discount_forward);
        Button button = (Button) findViewById(R.id.btn_apply_discount_forward);
        this.btnViewAndApplyDiscount = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWECouponsActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PWECouponsActivity.this.openDiscountView();
            }
        });
        TextView textView = (TextView) findViewById(R.id.text_reset_applied_discount_code);
        this.tvResetAppliedDiscount = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWECouponsActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PWECouponsActivity.this.openDiscountView();
            }
        });
        Button button2 = (Button) findViewById(R.id.btn_reset_applied_discount_code);
        this.buttonResetAppliedDiscount = button2;
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWECouponsActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PWECouponsActivity.this.openDiscountView();
            }
        });
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            this.linearGoBackLayoutBtn.setFocusable(true);
            this.linearGoBackLayoutBtn.requestFocus();
            this.linearGoBackLayoutBtn.setVisibility(0);
            this.linearGoBackLayout.setVisibility(8);
            this.tvViewAndApplyDiscount.setVisibility(8);
            this.btnViewAndApplyDiscount.setVisibility(0);
            this.tvResetAppliedDiscount.setVisibility(8);
            this.buttonResetAppliedDiscount.setVisibility(0);
        } else {
            this.linearGoBackLayoutBtn.setVisibility(8);
            this.linearGoBackLayout.setVisibility(0);
            this.tvViewAndApplyDiscount.setVisibility(0);
            this.btnViewAndApplyDiscount.setVisibility(8);
            this.tvResetAppliedDiscount.setVisibility(0);
            this.buttonResetAppliedDiscount.setVisibility(8);
        }
        this.linearGoBackLayout.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWECouponsActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PWECouponsActivity.this.generalHelper.hideKeyboard(PWECouponsActivity.this, view);
                PWECouponsActivity.this.onBackPressed();
            }
        });
        this.linearGoBackLayoutBtn.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWECouponsActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PWECouponsActivity.this.onBackPressed();
            }
        });
        this.generalHelper.initMerchantNameTextView(this.tvMerchantName);
        this.generalHelper.setPWEMerchantName(this.showLogo, this.imgMerchantLogo, this.logoUrl);
        this.tvSessionTime = (TextView) findViewById(R.id.text_session_time);
        this.tvInitialAmountToPay2 = (TextView) findViewById(R.id.text_payble_amt_pay_options2);
        this.tvConvFeeHeader2 = (TextView) findViewById(R.id.txt_conv_fee2);
        this.tvInitialAmountToPay1 = (TextView) findViewById(R.id.text_payble_amt_pay_options1);
        this.tvConvFeeHeader1 = (TextView) findViewById(R.id.txt_conv_fee1);
        this.scrollViewContainer = (ScrollView) findViewById(R.id.scrollview_container);
        this.linearApplyCashbackLayout = (LinearLayout) findViewById(R.id.linear_apply_cashback_holder);
        this.linearApplyCashbackBtnLayout = (LinearLayout) findViewById(R.id.linear_apply_cashback_btn_holder);
        this.btnApplyCashbackLayout = (Button) findViewById(R.id.linear_apply_cashback_btn_tv);
        this.linearCashbackLayout = (LinearLayout) findViewById(R.id.linear_cashback_holder);
        hideApplyCashbackBtn();
        this.btnApplyCashbackLayout.setVisibility(8);
        this.linearApplyCashbackLayout.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWECouponsActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PWECouponsActivity.this.showMode("CASHBACK_COUPONS");
            }
        });
        this.btnApplyCashbackLayout.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWECouponsActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PWECouponsActivity.this.showMode("CASHBACK_COUPONS");
            }
        });
        this.linearPayAmountSection2 = (LinearLayout) findViewById(R.id.linear_payamount_section2);
        this.linearPayAmountSection1 = (LinearLayout) findViewById(R.id.linear_payamount_section1);
        this.tvAllowedCashbackWorth = (TextView) findViewById(R.id.txt_cashback_allowed_worth);
        this.tvSelectedCouponsCount = (TextView) findViewById(R.id.txt_selected_coupon_count);
        this.tvAllowedCashbackWorth.setText("" + getApplicationContext().getString(R.string.rupees) + IdManager.DEFAULT_VERSION_NAME);
        Button button3 = (Button) findViewById(R.id.button_cancel_transaction);
        this.btnCancelTransaction = button3;
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWECouponsActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PWECouponsActivity.this.generalHelper.hideKeyboard(PWECouponsActivity.this, view);
                PWECouponsActivity.this.cancelTransaction();
            }
        });
        this.btnFailedTransaction = (Button) findViewById(R.id.button_failed_transaction);
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            this.btnApplyCashbackLayout.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.pwe_android_tv_text_button));
            this.linearGoBackLayoutBtn.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.pwe_android_tv_text_button));
            this.btnCancelTransaction.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.pwe_android_tv_text_button));
            this.btnFailedTransaction.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.pwe_android_tv_text_button));
            this.btnViewAndApplyDiscount.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.pwe_android_tv_text_button));
            this.buttonResetAppliedDiscount.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.pwe_android_tv_text_button));
        }
        this.btnFailedTransaction.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWECouponsActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PWECouponsActivity.this.showUserConfirmationDialog("Fail Transaction", "Do you really want to make the transaction failure?", "", 3, "CANCEL_TRANSACTION", "", -1);
            }
        });
        this.linearRootFooter = (LinearLayout) findViewById(R.id.linear_root_footer);
        this.linearRootHeader = (LinearLayout) findViewById(R.id.linear_root_header);
        this.linearFragmentHolderParent = (LinearLayout) findViewById(R.id.linear_fragment_holder_parent);
        this.linearAppliedDiscountCodeHolder = (LinearLayout) findViewById(R.id.linear_applied_discount_code_holder);
        this.linearApplyDiscountCodeHolder = (LinearLayout) findViewById(R.id.linear_apply_discount_holder);
        this.viewDiscountDivider = findViewById(R.id.view_divider_discount_code);
        this.tvAvailableCodesCount = (TextView) findViewById(R.id.text_available_discount_count);
        this.tvAppliedDiscountCode = (TextView) findViewById(R.id.text_applied_discount_code);
        this.tvAppliedDiscountType = (TextView) findViewById(R.id.text_applied_discount_type);
        this.tvDiscountAmount = (TextView) findViewById(R.id.text_discount_amount);
        ImageView imageView = (ImageView) findViewById(R.id.img_clear_applied_discount);
        this.imgClearAppliedDiscount = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWECouponsActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PWECouponsActivity.this.resetDiscountCode();
            }
        });
        this.linearApplyDiscountCodeHolder.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWECouponsActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PWECouponsActivity.this.generalHelper.hideKeyboard(PWECouponsActivity.this, view);
                PWECouponsActivity.this.openDiscountView();
            }
        });
        this.imageDiscountIcon = (ImageView) findViewById(R.id.img_discount_icon1);
        this.imageDiscountIcon2 = (ImageView) findViewById(R.id.img_discount_icon2);
        this.generalHelper.setImageToImageView("", this.imageDiscountIcon, PWEStaticDataModel.PWEDefaultDiscountIcon);
        this.generalHelper.setImageToImageView("", this.imageDiscountIcon2, PWEStaticDataModel.PWEDefaultDiscountIcon);
        this.linearDiscountCodeHolder = (LinearLayout) findViewById(R.id.linear_discount_code_holder);
        this.tvDiscountedAmount = (TextView) findViewById(R.id.text_discounted_amount);
        this.tvConvFeeWithDiscount = (TextView) findViewById(R.id.text_discounted_conv_fee);
        this.linearDiscountedAmountHolder = (LinearLayout) findViewById(R.id.linear_discounted_amount_holder);
        this.linearConvFeeWithDiscountHolder = (LinearLayout) findViewById(R.id.linear_discounted_conv_fee_holder);
        this.tvTotalAmountPayable = (TextView) findViewById(R.id.text_total_payment_amount);
        this.scrollViewContainer.setOnTouchListener(new View.OnTouchListener() { // from class: com.easebuzz.payment.kit.PWECouponsActivity.13
            float y0 = 0.0f;
            float y1 = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 2) {
                    if (PWECouponsActivity.this.paymentInfoHandler.getShowMessageFlag()) {
                        PWECouponsActivity.this.linearOpenMessage.setVisibility(0);
                    } else {
                        PWECouponsActivity.this.linearOpenMessage.setVisibility(8);
                    }
                } else {
                    this.y0 = motionEvent.getY();
                    PWECouponsActivity.this.linearOpenMessage.setVisibility(8);
                    this.y1 = motionEvent.getY();
                }
                return false;
            }
        });
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    private void restoreMainState() {
        try {
            JSONObject jSONObject = new JSONObject(this.paymentInfoHandler.getPweMainState());
            this.logoUrl = jSONObject.optString("logoURL", "");
            this.showLogo = jSONObject.optBoolean("showLogo", false);
        } catch (Error | JSONException | Exception unused) {
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("logoURL", this.logoUrl);
            jSONObject.put("showLogo", this.showLogo);
            this.paymentInfoHandler.setPweMainState(jSONObject.toString());
            this.paymentInfoHandler.setPweLastTransactionStatus(PWEStaticHelper.PWE_CURRENT_TRXN_STATUS);
            this.paymentInfoHandler.setIsMinimize(true);
        } catch (JSONException | Exception unused) {
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        this.paymentInfoHandler.setIsMinimize(false);
        if (this.paymentInfoHandler.IsTxnSessionExpire()) {
            setTimoutResult();
        }
        try {
            BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.easebuzz.payment.kit.PWECouponsActivity.14
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    PWECouponsActivity.this.updateRemainingTime(intent.getBooleanExtra("is_session_expired", false));
                }
            };
            this.timerBroadCastReciever = broadcastReceiver;
            registerReceiver(broadcastReceiver, new IntentFilter("pwe_timer_broad_cast"));
        } catch (Error | Exception unused) {
        }
        this.scrollViewContainer.smoothScrollTo(0, 0);
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRemainingTime(boolean z) {
        if (z) {
            if (this.paymentInfoHandler.IsMinimize()) {
                return;
            }
            setTimoutResult();
        } else {
            final String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(PWEStaticDataModel.TXN_SESSION_UPDATED_MINUTES));
            final String str2 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(PWEStaticDataModel.TXN_SESSION_UPDATED_SECONDS));
            runOnUiThread(new Runnable() { // from class: com.easebuzz.payment.kit.PWECouponsActivity.15
                @Override // java.lang.Runnable
                public void run() {
                    PWECouponsActivity.this.tvSessionTime.setText(" " + str + ":" + str2 + " ");
                }
            });
        }
    }

    private void initiatePayment() {
        showPWELoader();
        ((RetroAPI) new Retrofit.Builder().baseUrl(this.EndPointUrl).addConverterFactory(new ToStringConverterFactory()).callFactory(this.generalHelper.getRetrofitConnectionFactory()).build().create(RetroAPI.class)).initiatePayment(this.initiateReqParametersJsonObj).enqueue(new Callback<String>() { // from class: com.easebuzz.payment.kit.PWECouponsActivity.16
            @Override // retrofit2.Callback
            public void onResponse(Call<String> call, Response<String> response) {
                try {
                    PWECouponsActivity.this.handleInitiatePayment(response.body().toString());
                    PWECouponsActivity.this.hidePWELoader();
                } catch (Exception unused) {
                    PWECouponsActivity.this.showErrorDialog(PWEStaticDataModel.SERVER_ERROR_STR, PWEStaticDataModel.ERROR_DESC_STR, PWEStaticDataModel.TXN_ERROR_SERVER_ERROR_CODE);
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<String> call, Throwable th) {
                PWECouponsActivity.this.hidePWELoader();
                PWECouponsActivity.this.showErrorDialog(PWEStaticDataModel.SERVER_ERROR_STR, PWEStaticDataModel.ERROR_DESC_STR, PWEStaticDataModel.TXN_ERROR_SERVER_ERROR_CODE);
            }
        });
    }

    private void initiatePayment2() {
        showPWELoader();
        ((RetroAPI) new Retrofit.Builder().baseUrl(this.EndPointUrl).addConverterFactory(new ToStringConverterFactory()).callFactory(this.generalHelper.getRetrofitConnectionFactory()).build().create(RetroAPI.class)).initiatePaymentByAccessKey(this.initiateReqParametersJsonObj).enqueue(new Callback<String>() { // from class: com.easebuzz.payment.kit.PWECouponsActivity.17
            @Override // retrofit2.Callback
            public void onResponse(Call<String> call, Response<String> response) {
                try {
                    PWECouponsActivity.this.handleInitiatePayment(response.body().toString());
                    PWECouponsActivity.this.hidePWELoader();
                } catch (Exception unused) {
                    PWECouponsActivity.this.showErrorDialog(PWEStaticDataModel.SERVER_ERROR_STR, PWEStaticDataModel.ERROR_DESC_STR, PWEStaticDataModel.TXN_ERROR_SERVER_ERROR_CODE);
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<String> call, Throwable th) {
                PWECouponsActivity.this.hidePWELoader();
                PWECouponsActivity.this.showErrorDialog(PWEStaticDataModel.SERVER_ERROR_STR, PWEStaticDataModel.ERROR_DESC_STR, PWEStaticDataModel.TXN_ERROR_SERVER_ERROR_CODE);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleInitiatePayment(String str) {
        double d2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("status");
            if (jSONObject.has("public_key")) {
                PWEStaticDataModel.public_key_for_rsa = jSONObject.getString("public_key");
            }
            if (string.equals("true")) {
                if (PWEStaticDataModel.PWE_SDK_TYPE.equals(PWEStaticDataModel.PWE_SDK_TYPE)) {
                    try {
                        this.paymentInfoHandler.setPWEMerchantPkg(getCallingActivity().getPackageName());
                    } catch (Error | Exception unused) {
                    }
                } else {
                    this.paymentInfoHandler.setPWEMerchantPkg("NA");
                }
                PWEStaticHelper.PWE_CURRENT_TRXN_STATUS = PWEStaticDataModel.PWE_STATUS_INITIATED;
                this.paymentInfoHandler.setPweLastTransactionStatus(PWEStaticHelper.PWE_CURRENT_TRXN_STATUS);
                startSessionTimer();
                this.paymentOptionData = new JSONArray();
                this.paymentInfoHandler.setCardTypsExpJson(jSONObject.optString("card_validations"));
                new ArrayList();
                this.paymentInfoHandler.setMerchantName(jSONObject.optString("domain", "Pay With Easebuzz"));
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                String strOptString = jSONObject2.optString(Const.ZOOM_ACCESS_KEY, "");
                this.access_key = strOptString;
                this.paymentInfoHandler.setMerchantAccessKey(strOptString);
                this.paymentInfoHandler.setCustomerPhone(jSONObject2.optString("customer_phone", ""));
                String strOptString2 = jSONObject2.optString("txnid", "");
                this.merchantTrxnId = strOptString2;
                this.paymentInfoHandler.setMerchantTxnId(strOptString2);
                String str2 = String.format("%.2f", Double.valueOf(jSONObject2.optDouble("amount", 0.0d)));
                this.merchantTrxnAmount = str2;
                this.paymentInfoHandler.setPayAmountStr(str2);
                this.paymentInfoHandler.setTxnCurrentTime(jSONObject2.getString("current_time"));
                this.paymentInfoHandler.setAutoOtpJURL(jSONObject.optString("auto_otp_js", ""));
                this.paymentInfoHandler.setAutoOtpRegEx(jSONObject.optString("auto_otp_reg_ex", ""));
                this.paymentInfoHandler.setAutoOtpExtraData(jSONObject.optString("auto_otp_extra_data", ""));
                this.paymentInfoHandler.setPWEAutoOtpSafePkg(jSONObject.optString("auto_otp_safe_pkg", "com.google.android.gms"));
                this.paymentInfoHandler.setPWEAutoOtpSafeClass(jSONObject.optString("auto_otp_safe_cls", PWEStaticDataModel.PWE_SDK_SAFE_CLASS));
                try {
                    String strOptString3 = jSONObject2.optString("logo", "");
                    try {
                        if (this.customOptionsObject.optBoolean("view_logo") && !strOptString3.trim().isEmpty() && !strOptString3.equals(Constants.NULL_VERSION_ID)) {
                            this.tvMerchantName.setVisibility(8);
                            this.imgMerchantLogo.setVisibility(0);
                            d2 = 0.0d;
                            this.generalHelper.setImageToImageView(strOptString3, this.imgMerchantLogo, PWEStaticDataModel.PWEDefaultPlaceholder);
                        } else {
                            d2 = 0.0d;
                            this.tvMerchantName.setVisibility(0);
                            this.imgMerchantLogo.setVisibility(8);
                        }
                    } catch (Exception unused2) {
                        this.tvMerchantName.setVisibility(0);
                        this.imgMerchantLogo.setVisibility(8);
                    }
                } catch (Exception unused3) {
                    d2 = 0.0d;
                }
                String strOptString4 = jSONObject2.optString("logo", "");
                this.logoUrl = strOptString4;
                this.paymentInfoHandler.setPWEMerchantLogoURL(strOptString4);
                try {
                    if (this.customOptionsObject.optBoolean("view_logo", false) && !this.logoUrl.trim().isEmpty() && !this.logoUrl.equals(Constants.NULL_VERSION_ID)) {
                        this.showLogo = true;
                    }
                } catch (Error | Exception unused4) {
                }
                this.generalHelper.setPWEMerchantName(this.showLogo, this.imgMerchantLogo, this.logoUrl);
                this.paymentInfoHandler.setSavedCards(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                this.paymentInfoHandler.setIsSavedCard(0);
                if (jSONObject2.optInt("enable_save_card", 0) == 1) {
                    try {
                        this.paymentInfoHandler.setIsSavedCard(1);
                        String strOptString5 = jSONObject2.optString("customer_cards", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                        this.paymentInfoHandler.setSavedCards(strOptString5);
                        if (new JSONArray(strOptString5).length() > 0) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("payment_option_name", PWEStaticDataModel.PAYOPT_SAVED_CARD_NAME);
                            jSONObject3.put("payment_option_key", PWEStaticDataModel.PAYOPT_SAVED_CARD_CODE);
                            jSONObject3.put("display_name", PWEStaticDataModel.PAYOPT_SAVED_CARD_DISPLAY_NAME);
                            jSONObject3.put("display_icon", PWEStaticDataModel.PWEDefaultSavedCardIcon);
                            jSONObject3.put("display_note", PWEStaticDataModel.PAYOPT_SAVED_CARD_NOTE);
                            this.paymentOptionData.put(jSONObject3);
                        }
                    } catch (Exception unused5) {
                    }
                }
                if (jSONObject2.optInt("enable_debit", 0) == 1) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("payment_option_name", PWEStaticDataModel.PAYOPT_DEBITCARD_NAME);
                    jSONObject4.put("payment_option_key", PWEStaticDataModel.PAYOPT_DEBITCARD_CODE);
                    jSONObject4.put("display_name", PWEStaticDataModel.PAYOPT_DEBITCARD_DISPLAY_NAME);
                    jSONObject4.put("display_icon", PWEStaticDataModel.PWEDefaultDebitCardIcon);
                    jSONObject4.put("display_note", PWEStaticDataModel.PAYOPT_DEBITCARD_NOTE);
                    this.paymentOptionData.put(jSONObject4);
                }
                if (jSONObject2.optInt("enable_credit", 0) == 1) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("payment_option_name", PWEStaticDataModel.PAYOPT_CREDITCARD_NAME);
                    jSONObject5.put("payment_option_key", PWEStaticDataModel.PAYOPT_CREDITCARD_CODE);
                    jSONObject5.put("display_name", PWEStaticDataModel.PAYOPT_CREDITCARD_DISPLAY_NAME);
                    jSONObject5.put("display_note", PWEStaticDataModel.PAYOPT_CREDITCARD_NOTE);
                    jSONObject5.put("display_icon", PWEStaticDataModel.PWEDefaultCreditCardIcon);
                    this.paymentOptionData.put(jSONObject5);
                }
                if (jSONObject2.optInt("enable_net_banking", 0) == 1) {
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("payment_option_name", PWEStaticDataModel.PAYOPT_NETBANK_NAME);
                    jSONObject6.put("payment_option_key", PWEStaticDataModel.PAYOPT_NETBANK_CODE);
                    jSONObject6.put("display_name", PWEStaticDataModel.PAYOPT_NETBANK_DISPLAY_NAME);
                    jSONObject6.put("display_note", PWEStaticDataModel.PAYOPT_NETBANK_NOTE);
                    jSONObject6.put("display_icon", PWEStaticDataModel.PWEDefaultNetBankIcon);
                    this.paymentOptionData.put(jSONObject6);
                }
                if (jSONObject2.optInt("enable_cash_card", 0) == 1) {
                    JSONObject jSONObject7 = new JSONObject();
                    jSONObject7.put("payment_option_name", PWEStaticDataModel.PAYOPT_WALLET_NAME);
                    jSONObject7.put("payment_option_key", PWEStaticDataModel.PAYOPT_WALLET_CODE);
                    jSONObject7.put("display_name", PWEStaticDataModel.PAYOPT_WALLET_DISPLAY_NAME);
                    jSONObject7.put("display_note", PWEStaticDataModel.PAYOPT_WALLET_NOTE);
                    jSONObject7.put("display_icon", PWEStaticDataModel.PWEDefaultWalletIcon);
                    this.paymentOptionData.put(jSONObject7);
                }
                if (jSONObject2.optInt("enable_atm_pin", 0) == 1) {
                    JSONObject jSONObject8 = new JSONObject();
                    jSONObject8.put("payment_option_name", PWEStaticDataModel.PAYOPT_DEBIT_ATM_NAME);
                    jSONObject8.put("payment_option_key", PWEStaticDataModel.PAYOPT_DEBIT_ATM_CODE);
                    jSONObject8.put("display_name", PWEStaticDataModel.PAYOPT_DEBIT_ATM_DISPLAY_NAME);
                    jSONObject8.put("display_note", PWEStaticDataModel.PAYOPT_DEBIT_ATM_NOTE);
                    jSONObject8.put("display_icon", PWEStaticDataModel.PWEDefaultDebitAtmIcon);
                    this.paymentOptionData.put(jSONObject8);
                }
                if (jSONObject2.optInt("enable_upi", 0) == 1) {
                    JSONObject jSONObject9 = new JSONObject();
                    jSONObject9.put("payment_option_name", PWEStaticDataModel.PAYOPT_UPI_NAME);
                    jSONObject9.put("payment_option_key", PWEStaticDataModel.PAYOPT_UPI_CODE);
                    jSONObject9.put("display_name", PWEStaticDataModel.PAYOPT_UPI_DISPLAY_NAME);
                    jSONObject9.put("display_note", PWEStaticDataModel.PAYOPT_UPI_NOTE);
                    jSONObject9.put("display_icon", PWEStaticDataModel.PWEDefaultUPIIcon);
                    this.paymentOptionData.put(jSONObject9);
                }
                if (jSONObject2.optInt("enable_auto_debit_upi", 0) == 1) {
                    JSONObject jSONObject10 = new JSONObject();
                    jSONObject10.put("payment_option_name", PWEStaticDataModel.UPI_AUTODEBIT_NAME);
                    jSONObject10.put("payment_option_key", PWEStaticDataModel.UPI_AUTODEBIT_CODE);
                    jSONObject10.put("display_name", PWEStaticDataModel.UPI_AUTODEBIT_DISPLAY_NAME);
                    jSONObject10.put("display_note", PWEStaticDataModel.UPI_AUTODEBIT_NOTE);
                    jSONObject10.put("display_icon", PWEStaticDataModel.PWEDefaultUPIIcon);
                    this.paymentOptionData.put(jSONObject10);
                }
                if (jSONObject2.optInt("enable_emi", 0) == 1) {
                    JSONObject jSONObject11 = new JSONObject();
                    jSONObject11.put("payment_option_name", PWEStaticDataModel.EMI_NAME);
                    jSONObject11.put("payment_option_key", "emi");
                    jSONObject11.put("display_name", PWEStaticDataModel.EMI_DISPLAY_NAME);
                    jSONObject11.put("display_note", PWEStaticDataModel.EMI_DISPLAY_NOTE);
                    jSONObject11.put("display_icon", PWEStaticDataModel.PWEDefaultEMIIcon);
                    this.paymentOptionData.put(jSONObject11);
                }
                if (jSONObject2.optInt("enable_ola_money", 0) == 1) {
                    JSONObject jSONObject12 = new JSONObject();
                    jSONObject12.put("payment_option_name", PWEStaticDataModel.OLA_MONEY_NAME);
                    jSONObject12.put("payment_option_key", PWEStaticDataModel.OLA_MONEY_CODE);
                    jSONObject12.put("display_name", PWEStaticDataModel.OLA_MONEY_DISPLAY_NAME);
                    jSONObject12.put("display_note", PWEStaticDataModel.OLA_MONEY_NOTE);
                    jSONObject12.put("display_icon", PWEStaticDataModel.PWEDefaultOLAIcon);
                    this.paymentOptionData.put(jSONObject12);
                }
                if (jSONObject2.optInt("enable_enach", 0) == 1) {
                    JSONObject jSONObject13 = new JSONObject();
                    jSONObject13.put("payment_option_name", PWEStaticDataModel.PAYOPT_ENACH_NAME);
                    jSONObject13.put("payment_option_key", PWEStaticDataModel.PAYOPT_ENACH_CODE);
                    jSONObject13.put("display_name", PWEStaticDataModel.PAYOPT_ENACH_DISPLAY_NAME);
                    jSONObject13.put("display_note", PWEStaticDataModel.PAYOPT_ENACH_NOTE);
                    jSONObject13.put("display_icon", PWEStaticDataModel.PWEDefaultENACHIcon);
                    this.paymentOptionData.put(jSONObject13);
                }
                if (jSONObject.optJSONObject("enach_mobile_config") != null) {
                    this.paymentInfoHandler.setEnachNotSupportableAndroidOsVersion(jSONObject.optJSONObject("enach_mobile_config").optInt("disabled_below_android_api_version", 0));
                }
                if (jSONObject2.optInt("enable_simpl", 0) == 1 || jSONObject2.optBoolean("enable_simpl")) {
                    JSONObject jSONObject14 = new JSONObject();
                    jSONObject14.put("payment_option_name", PWEStaticDataModel.SIMPL_NAME);
                    jSONObject14.put("payment_option_key", PWEStaticDataModel.SIMPL_CODE);
                    jSONObject14.put("display_name", PWEStaticDataModel.SIMPL_DISPLAY_NAME);
                    jSONObject14.put("display_note", PWEStaticDataModel.SIMPL_NOTE);
                    jSONObject14.put("display_icon", PWEStaticDataModel.PWEDefaultSIMPLIcon);
                    this.paymentOptionData.put(jSONObject14);
                }
                PWEStaticDataModel.MAX_IMPS_AMOUNT_LIMIT = Double.valueOf(jSONObject2.optDouble("insta_collect_imps_limit", 500000.0d));
                if (jSONObject2.optInt("enable_insta_collect", 0) == 1) {
                    JSONObject jSONObject15 = new JSONObject();
                    if (Double.parseDouble(this.merchantTrxnAmount) > PWEStaticDataModel.MAX_IMPS_AMOUNT_LIMIT.doubleValue()) {
                        PWEStaticDataModel.INSTA_COLLECT_DISPLAY_NAME = "NEFT/RTGS";
                        PWEStaticDataModel.INSTA_COLLECT_NOTE = "Pay with NEFT/RTGS";
                    } else {
                        PWEStaticDataModel.INSTA_COLLECT_DISPLAY_NAME = "IMPS/NEFT/RTGS";
                        PWEStaticDataModel.INSTA_COLLECT_NOTE = "Pay with IMPS/NEFT/RTGS";
                    }
                    jSONObject15.put("payment_option_name", PWEStaticDataModel.INSTA_COLLECT_NAME);
                    jSONObject15.put("payment_option_key", PWEStaticDataModel.INSTA_COLLECT_CODE);
                    jSONObject15.put("display_name", PWEStaticDataModel.INSTA_COLLECT_DISPLAY_NAME);
                    jSONObject15.put("display_note", PWEStaticDataModel.INSTA_COLLECT_NOTE);
                    jSONObject15.put("display_icon", PWEStaticDataModel.PWEDefaultNetBankIcon);
                    this.paymentOptionData.put(jSONObject15);
                }
                this.paymentInfoHandler.setEnabledPaymentOptionList(this.paymentOptionData.toString());
                this.paymentInfoHandler.setIsDiscountCouponEnabled(jSONObject2.optInt("enable_discount_code", 0) == 1);
                this.paymentInfoHandler.setDiscountCodeListDetails(jSONObject2.optString("discount_code_list", ""));
                this.paymentInfoHandler.setIsDirectDebitEnabled(jSONObject2.optInt("enable_direct_debit", 0));
                this.paymentInfoHandler.setDirectDebitNote(jSONObject2.optString("direct_debit_note", ""));
                this.paymentInfoHandler.setPayUpiAddressVisibilityFlag(jSONObject2.optInt("upi_collect_req", 0) == 1);
                this.paymentInfoHandler.setPayUpiQrVisibilityFlag(jSONObject2.optInt("upi_qr_status", 1) == 1);
                try {
                    JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("card_page_messages");
                    this.paymentInfoHandler.setDebitCardNoteMessage(jSONObjectOptJSONObject.optString(PWEStaticDataModel.PAYOPT_DEBITCARD_NAME));
                    this.paymentInfoHandler.setCreditCardNoteMessage(jSONObjectOptJSONObject.optString(PWEStaticDataModel.PAYOPT_CREDITCARD_NAME));
                    this.paymentInfoHandler.setNetBankingNoteMessage(jSONObjectOptJSONObject.optString(PWEStaticDataModel.PAYOPT_NETBANK_NAME));
                    this.paymentInfoHandler.setEmiNoteMessage(jSONObjectOptJSONObject.optString(PWEStaticDataModel.EMI_NAME));
                    this.paymentInfoHandler.setWalletNoteMessage(jSONObjectOptJSONObject.optString(PWEStaticDataModel.PAYOPT_WALLET_NAME));
                    this.paymentInfoHandler.setInstacollectNoteMessage(jSONObjectOptJSONObject.optString(PWEStaticDataModel.INSTA_COLLECT_NAME));
                    this.paymentInfoHandler.setOlaMoneyNoteMessage(jSONObjectOptJSONObject.optString(PWEStaticDataModel.OLA_MONEY_NAME));
                    this.paymentInfoHandler.setPayLaterNoteMessage(jSONObjectOptJSONObject.optString(PWEStaticDataModel.SIMPL_NAME));
                    this.paymentInfoHandler.setAutodebitUpiNoteMessage(jSONObjectOptJSONObject.optString(PWEStaticDataModel.UPI_AUTODEBIT_NAME));
                    this.paymentInfoHandler.setEnachNoteMessage(jSONObjectOptJSONObject.optString(PWEStaticDataModel.PAYOPT_ENACH_NAME));
                    this.paymentInfoHandler.setUpiLimitNoteMessage(jSONObjectOptJSONObject.optString(PWEStaticDataModel.PAYOPT_UPI_NAME));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.paymentInfoHandler.setCancelResons("");
                this.paymentInfoHandler.setIsCReasonEabled(0);
                if (jSONObject2.optInt("is_cancellation_reason_enabled", 0) == 1) {
                    String strOptString6 = jSONObject2.optString("cancellation_reasons", "");
                    try {
                        this.paymentInfoHandler.setCancelResons(strOptString6);
                        String strReplace = strOptString6.replace(com.clevertap.android.sdk.Constants.AES_PREFIX, "").replace(com.clevertap.android.sdk.Constants.AES_SUFFIX, "").replace("\"", "");
                        if (!strReplace.isEmpty() && !strReplace.equals("")) {
                            this.paymentInfoHandler.setIsCReasonEabled(1);
                        }
                    } catch (Exception unused6) {
                    }
                }
                this.paymentInfoHandler.setCustomerSurchargeDetails("");
                this.paymentInfoHandler.setIsCustomerSurcharge(0);
                if (jSONObject2.optBoolean("is_tdr_on_customer", false)) {
                    try {
                        String strOptString7 = jSONObject2.optString("possible_tdr", "");
                        this.paymentInfoHandler.setCustomerSurchargeDetails(strOptString7);
                        String strReplace2 = strOptString7.replace(com.clevertap.android.sdk.Constants.AES_PREFIX, "").replace(com.clevertap.android.sdk.Constants.AES_SUFFIX, "").replace("\"", "");
                        if (!strReplace2.isEmpty() && !strReplace2.equals("")) {
                            this.paymentInfoHandler.setIsCustomerSurcharge(1);
                        }
                    } catch (Exception unused7) {
                    }
                }
                this.paymentInfoHandler.setCashBackPercentage(jSONObject2.optInt("cashback_percentage", 0));
                this.paymentInfoHandler.setSelectedCashbackWorth(String.format("%.2f", Double.valueOf(d2)));
                this.paymentInfoHandler.setIsPaperBaseEnabled(jSONObject2.optInt("enable_nach_paper_base", 0));
                this.paymentInfoHandler.setTxnInitiateTime(jSONObject2.optString("start_time", ""));
                this.paymentInfoHandler.setBankCodeString(jSONObject.optString("bankcodes", ""));
                this.paymentInfoHandler.setUpiListString(jSONObject.optString("upi_configurations", ""));
                int iOptInt = jSONObject2.optInt("isCoupon", 0);
                this.paymentInfoHandler.setIsCashbackCouponEnabled(iOptInt);
                if (iOptInt == 1) {
                    try {
                        this.paymentInfoHandler.setCashbackCouponsData(jSONObject.optString("coupons", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI));
                    } catch (Exception unused8) {
                        this.paymentInfoHandler.setIsCashbackCouponEnabled(0);
                    }
                }
                this.paymentInfoHandler.saveMessage(jSONObject2.optString("card_page_messages", ""));
                setBasicInfo();
                return;
            }
            String strOptString8 = jSONObject.optString("error_status");
            if (strOptString8.equals("retry")) {
                showErrorDialog(jSONObject.optString("msg_desc", "Transaction dropped"), jSONObject.optString("msg", PWEStaticDataModel.ERROR_DESC_STR), PWEStaticDataModel.TXN_ERROR_RETRY_FAILED_CODE);
                return;
            }
            if (strOptString8.equals(com.paytm.pgsdk.Constants.EVENT_LABEL_FAIL)) {
                showErrorDialog(jSONObject.optString("msg_desc", "Transaction failed"), jSONObject.optString("msg", PWEStaticDataModel.ERROR_DESC_STR), PWEStaticDataModel.TXN_ERROR_RETRY_FAILED_CODE);
                return;
            }
            if (!strOptString8.equals("error") && !strOptString8.equals("noretry")) {
                showErrorDialog(jSONObject.optString("msg_desc", "Transaction failed"), jSONObject.optString("msg", PWEStaticDataModel.ERROR_DESC_STR), PWEStaticDataModel.TXN_ERROR_RETRY_FAILED_CODE);
                return;
            }
            showErrorDialog(jSONObject.optString("msg_desc", "Transaction failed"), jSONObject.optString("msg", PWEStaticDataModel.ERROR_DESC_STR), PWEStaticDataModel.TXN_ERROR_NO_RETRY_CODE);
        } catch (JSONException unused9) {
            showErrorDialog(PWEStaticDataModel.SERVER_ERROR_STR, PWEStaticDataModel.ERROR_DESC_STR, PWEStaticDataModel.TXN_ERROR_SERVER_ERROR_CODE);
        }
    }

    private void setBasicInfo() {
        try {
            this.generalHelper.setPWEMerchantName(this.showLogo, this.imgMerchantLogo, this.logoUrl);
            PWEStaticDataModel.ALLOWED_COUPON_WORTH = Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf((Double.parseDouble(this.merchantTrxnAmount) / 100.0d) * ((double) this.paymentInfoHandler.getCashbackPercentage())))));
            this.tvAllowedCashbackWorth.setText("" + getApplicationContext().getString(R.string.rupees) + PWEStaticDataModel.ALLOWED_COUPON_WORTH);
            this.pweCardPageMessageHelper.showMessage("global");
            JSONArray jSONArray = new JSONArray(this.paymentInfoHandler.getEnabledPaymentOptionList());
            this.paymentOptionData = jSONArray;
            if (jSONArray.length() > 1) {
                showMode("PAY_OPTIONS");
            } else if (this.paymentOptionData.length() == 1) {
                PWEPaymentOptionDataModel pWEPaymentOptionDataModel = new PWEPaymentOptionDataModel();
                try {
                    JSONObject jSONObject = this.paymentOptionData.getJSONObject(0);
                    pWEPaymentOptionDataModel.setPayment_option_name(jSONObject.optString("payment_option_name", ""));
                    pWEPaymentOptionDataModel.setPayment_option_key(jSONObject.optString("payment_option_key", ""));
                    pWEPaymentOptionDataModel.setDisplay_name(jSONObject.optString("display_name", ""));
                    pWEPaymentOptionDataModel.setDisplay_note(jSONObject.optString("display_note", ""));
                    pWEPaymentOptionDataModel.setDisplay_icon(jSONObject.optInt("display_icon", PWEStaticDataModel.PWEDefaultBankPaymentIcon));
                } catch (JSONException unused) {
                }
                selectPaymentMode(pWEPaymentOptionDataModel);
            } else {
                sendFailedResponseMerchant(PWEStaticDataModel.SERVER_ERROR_STR, PWEStaticDataModel.NO_PAYMENT_OPTION_ENABLED, PWEStaticDataModel.TXN_ERROR_TXN_NOT_ALLOWED_CODE);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            sendFailedResponseMerchant(PWEStaticDataModel.SERVER_ERROR_STR, PWEStaticDataModel.SERVER_ERROR_STR, PWEStaticDataModel.TXN_ERROR_TXN_NOT_ALLOWED_CODE);
        }
    }

    protected void selectPaymentMode(PWEPaymentOptionDataModel pWEPaymentOptionDataModel) {
        this.paymentInfoHandler.setSelectedPaymentOption(pWEPaymentOptionDataModel.getPayment_option_name());
        showMode(this.paymentInfoHandler.getSelectedPaymentOption());
    }

    protected void showMode(String str) {
        try {
            this.scrollViewContainer.smoothScrollTo(0, 0);
            if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
                this.linearGoBackLayoutBtn.requestFocus();
            }
            if (!str.equals("PROCESS_PAYMENT") && !str.equals("CANCELLATION_REASONS") && !str.equals("coupondetailsview")) {
                this.payAmtHelper.resetAppliedCouponFlag(false, "", "", "");
            }
            this.fragment = null;
            if (str.equals("PAY_OPTIONS")) {
                this.paymentInfoHandler.setDiscountVisibilityFlag(false);
                setProcessPaymentLayout(false);
                PWEStaticDataModel.PWE_MODE_SELECTED = "paymentoption";
                this.fragment = new PWEPaymentOptionsFragment();
            } else if (str.equals("CASHBACK_COUPONS")) {
                this.paymentInfoHandler.setDiscountVisibilityFlag(false);
                PWEStaticDataModel.PWE_MODE_SELECTED = "cashbackcoupons";
                this.fragment = new PWECouponsFragment();
            } else if (str.equals(PWEStaticDataModel.PAYOPT_DEBITCARD_NAME)) {
                this.paymentInfoHandler.setDiscountVisibilityFlag(true);
                PWEStaticDataModel.PWE_MODE_SELECTED = "debitcard";
                this.fragment = new PWEDebitCreditFragment();
                this.paymentInfoHandler.setSelectedPaymentOption(str);
            } else if (str.equals(PWEStaticDataModel.PAYOPT_CREDITCARD_NAME)) {
                this.paymentInfoHandler.setDiscountVisibilityFlag(true);
                PWEStaticDataModel.PWE_MODE_SELECTED = "creditcard";
                this.fragment = new PWEDebitCreditFragment();
                this.paymentInfoHandler.setSelectedPaymentOption(str);
            } else if (str.equals(PWEStaticDataModel.PAYOPT_SAVED_CARD_NAME)) {
                this.paymentInfoHandler.setDiscountVisibilityFlag(true);
                PWEStaticDataModel.PWE_MODE_SELECTED = "savedcard";
                this.fragment = new PWESavedCardFragment();
                this.paymentInfoHandler.setSelectedPaymentOption(str);
            } else if (str.equals(PWEStaticDataModel.PAYOPT_DEBIT_ATM_NAME)) {
                this.paymentInfoHandler.setDiscountVisibilityFlag(false);
                PWEStaticDataModel.PWE_MODE_SELECTED = "debitatm";
                this.fragment = new PWEDebitAtmFragment();
                this.paymentInfoHandler.setSelectedPaymentOption(str);
            } else if (str.equals(PWEStaticDataModel.PAYOPT_WALLET_NAME)) {
                this.paymentInfoHandler.setDiscountVisibilityFlag(true);
                PWEStaticDataModel.PWE_MODE_SELECTED = "cashcard";
                this.fragment = new PWEWalletFragment();
                this.paymentInfoHandler.setSelectedPaymentOption(str);
            } else if (str.equals(PWEStaticDataModel.OLA_MONEY_NAME)) {
                this.paymentInfoHandler.setDiscountVisibilityFlag(false);
                PWEStaticDataModel.PWE_MODE_SELECTED = "ola";
                this.fragment = new PWEOlaFragment();
                this.paymentInfoHandler.setSelectedPaymentOption(str);
            } else if (str.equals(PWEStaticDataModel.EMI_NAME)) {
                this.paymentInfoHandler.setDiscountVisibilityFlag(false);
                PWEStaticDataModel.PWE_MODE_SELECTED = "emi";
                this.fragment = new PWEEmiFragment();
                this.paymentInfoHandler.setSelectedPaymentOption(str);
            } else if (str.equals(PWEStaticDataModel.PAYOPT_UPI_NAME)) {
                this.paymentInfoHandler.setDiscountVisibilityFlag(true);
                PWEStaticDataModel.PWE_MODE_SELECTED = PWEStaticDataModel.PAYOPT_UPI_CODE;
                this.fragment = new PWEUpiFragment();
                this.paymentInfoHandler.setSelectedPaymentOption(str);
            } else if (str.equals(PWEStaticDataModel.PAYOPT_NETBANK_NAME)) {
                this.paymentInfoHandler.setDiscountVisibilityFlag(true);
                PWEStaticDataModel.PWE_MODE_SELECTED = "netbanking";
                this.fragment = new PWENetbankingFragment();
                this.paymentInfoHandler.setSelectedPaymentOption(str);
            } else if (str.equals("PROCESS_PAYMENT")) {
                PWEStaticDataModel.PWE_MODE_SELECTED = "processpayment";
            } else if (str.equals("CANCELLATION_REASONS")) {
                this.btnCancelTransaction.setVisibility(8);
                setDiscountCodeVisibiliy("hide");
                disableCashback();
                this.fragment = new PWECancellationReasonFragment();
            } else if (str.equals(PWEStaticDataModel.PAYOPT_ENACH_NAME)) {
                if (checkDeviceSupportForEnach()) {
                    this.paymentInfoHandler.setDiscountVisibilityFlag(true);
                    PWEStaticDataModel.PWE_MODE_SELECTED = PWEStaticDataModel.PAYOPT_ENACH_CODE;
                    this.fragment = new PWEEnachFragment();
                    this.paymentInfoHandler.setSelectedPaymentOption(str);
                } else {
                    this.generalHelper.showPweToast("Enach is not supported on your current Android OS Version and below, Upgrade Android OS Version");
                }
            } else if (str.equals("coupondetailsview")) {
                this.paymentInfoHandler.setDiscountVisibilityFlag(false);
                PWEStaticDataModel.PWE_MODE_SELECTED = "cashbackcoupondetails";
                this.fragment = new PWECouponsDetailsFragment();
                this.paymentInfoHandler.setSelectedPaymentOption(str);
            } else if (str.equals(PWEStaticDataModel.SIMPL_NAME)) {
                this.paymentInfoHandler.setDiscountVisibilityFlag(false);
                PWEStaticDataModel.PWE_MODE_SELECTED = PWEStaticDataModel.SIMPL_CODE;
                this.fragment = new PWESimplFragment();
                this.paymentInfoHandler.setSelectedPaymentOption(str);
            } else if (str.equals(PWEStaticDataModel.UPI_AUTODEBIT_NAME)) {
                this.paymentInfoHandler.setDiscountVisibilityFlag(false);
                PWEStaticDataModel.PWE_MODE_SELECTED = PWEStaticDataModel.UPI_AUTODEBIT_CODE;
                this.fragment = new PWEUpiFragment();
                this.paymentInfoHandler.setSelectedPaymentOption(str);
            } else if (str.equals(PWEStaticDataModel.INSTA_COLLECT_NAME)) {
                this.paymentInfoHandler.setDiscountVisibilityFlag(false);
                PWEStaticDataModel.PWE_MODE_SELECTED = PWEStaticDataModel.INSTA_COLLECT_CODE;
                this.fragment = new PWEInstaCollectFragment();
                this.paymentInfoHandler.setSelectedPaymentOption(str);
            }
            setPaymentMethodCommonInfo(str);
            if (!str.equals("PROCESS_PAYMENT") && !str.equals("CANCELLATION_REASONS")) {
                setCustomerPaymentInfo();
            }
            if (str.equals("PROCESS_PAYMENT")) {
                this.pweCardPageMessageHelper.showMessage(str);
            } else if (str.equals("PAY_OPTIONS") || str.equals("CASHBACK_COUPONS")) {
                this.pweCardPageMessageHelper.showMessage("global");
            } else {
                this.pweCardPageMessageHelper.showMessage(str);
            }
            if (str.equals("PROCESS_PAYMENT")) {
                this.pweBankPageActivityResultLauncher.launch(new Intent(this, (Class<?>) PWEBankPageActivity.class));
            } else {
                if (this.fragment != null) {
                    FragmentTransaction fragmentTransactionBeginTransaction = this.fManager.beginTransaction();
                    this.fTransaction = fragmentTransactionBeginTransaction;
                    fragmentTransactionBeginTransaction.addToBackStack(str);
                    this.fTransaction.replace(R.id.linear_fragment_holder, this.fragment);
                    this.fTransaction.commit();
                    return;
                }
                this.generalHelper.showPweToast("Something Went Wrong : PWE01");
            }
        } catch (Error | Exception unused) {
        }
    }

    private void disableCashback() {
        hideApplyCashbackBtn();
        this.linearCashbackLayout.setVisibility(8);
        this.linearPayAmountSection1.setVisibility(8);
        this.linearPayAmountSection2.setVisibility(0);
    }

    private void enableCashback() {
        if (this.paymentInfoHandler.getIsCashbackCouponEnabled() == 1) {
            if (PWEStaticDataModel.PWE_MODE_SELECTED.equals("cashbackcoupons") || PWEStaticDataModel.PWE_MODE_SELECTED.equals("cashbackcoupondetails")) {
                this.linearPayAmountSection1.setVisibility(8);
                this.linearPayAmountSection2.setVisibility(0);
                hideApplyCashbackBtn();
                this.linearCashbackLayout.setVisibility(0);
                return;
            }
            this.linearPayAmountSection1.setVisibility(0);
            this.linearPayAmountSection2.setVisibility(8);
            showApplyCashbackBtn();
            this.linearCashbackLayout.setVisibility(8);
        }
    }

    protected void cancelTransaction() {
        if ((this.fManager.findFragmentById(R.id.linear_fragment_holder) instanceof PWEUpiFragment) && PWEStaticHelper.PWE_CURRENT_TRXN_STATUS.equals(PWEStaticDataModel.PWE_STATUS_PENDING)) {
            showUserConfirmationDialog("Cancel Transaction", "Do you really want to cancel the transaction ?", "", 1, "CANCEL_UPI_TRANSACTION", "", -1);
        } else if (this.paymentInfoHandler.getIsCReasonEabled() == 0) {
            showUserConfirmationDialog("Cancel Transaction", "Do you really want to cancel the transaction ?", "", 1, "CANCEL_TRANSACTION", "", -1);
        } else {
            showMode("CANCELLATION_REASONS");
        }
    }

    private void resetTrxnPreferences() {
        this.paymentInfoHandler.setGpayEligibilityCheckFlag(false);
        this.paymentInfoHandler.setPweUpiSaveState("{}");
        this.paymentInfoHandler.setMerchantAccessKey("");
        this.paymentInfoHandler.setIsEnableGpay(0);
        this.paymentInfoHandler.setMerchantName("");
        this.paymentInfoHandler.setIsMinimize(false);
        this.paymentInfoHandler.setIsTxnSessionExpire(false);
        this.paymentInfoHandler.setIsTxnTimerStopped(false);
        this.paymentInfoHandler.setSelectedCouponIdList(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        this.paymentInfoHandler.setEnabledPaymentOptionList(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        this.payAmtHelper.resetAppliedCouponFlag(false, "", "", "");
        this.paymentInfoHandler.setPayAmountStr(IdManager.DEFAULT_VERSION_NAME);
        this.paymentInfoHandler.setIsCustomerSurcharge(0);
        this.paymentInfoHandler.setCustomerSurchargeDetails("");
        this.paymentInfoHandler.setDiscountVisibilityFlag(false);
        this.tvSelectedCouponsCount.setText("" + PWEStaticDataModel.SELECTED_COUPON_COUNT + " ");
        resetBankInfo();
        this.paymentInfoHandler.setMerchantTxnId("");
        this.paymentInfoHandler.setPweLastTransactionStatus("");
        this.paymentInfoHandler.setPWEMerchantLogoURL("");
        this.paymentInfoHandler.setPweMainState("{}");
    }

    private void resetBankInfo() {
        this.paymentInfoHandler.setSelectedBankName("");
        this.paymentInfoHandler.setSelectedOtherBankName("");
        this.paymentInfoHandler.setSelectedBankCode("");
        this.paymentInfoHandler.setSelectedCardNumber("");
        this.paymentInfoHandler.setSelectedNameOnCard("");
        this.paymentInfoHandler.setSelectedExpDate("");
        this.paymentInfoHandler.setSelectedCardType("");
        this.paymentInfoHandler.setSelectedCVVString("");
        this.paymentInfoHandler.setNoCVVFlag("");
        this.paymentInfoHandler.setSelectedCardID("");
        this.paymentInfoHandler.setSelectedSavedCardCvv("");
        this.paymentInfoHandler.setSelectedSavedCardFlag("");
        this.paymentInfoHandler.setSelectedEMIDict("");
        this.paymentInfoHandler.setPWEEnachAccountNumber("");
        this.paymentInfoHandler.setPWEEnachAccountHolderName("");
        this.paymentInfoHandler.setPWEEnachAccountType("");
        this.paymentInfoHandler.setPWESimplEligibleData("");
        this.paymentInfoHandler.setPWESimplPayLaterAppName("");
    }

    private void getParameters() {
        if (PWEStaticDataModel.IS_APP_REINITIALIZED) {
            return;
        }
        Bundle extras = getIntent().getExtras();
        this.client_error = "Invalid Parameters";
        try {
            this.initiateReqParametersJsonObj = new HashMap();
            for (String str : extras.keySet()) {
                Object obj = extras.get(str);
                String name = obj.getClass().getName();
                if (str.equals("custom_options")) {
                    this.customOptionsObject = new JSONObject(String.valueOf(obj));
                } else if (name.toLowerCase().contains("double")) {
                    this.initiateReqParametersJsonObj.put(str, Double.valueOf(extras.getDouble(str, 0.0d)));
                } else if (name.toLowerCase().contains(TypedValues.Custom.S_INT)) {
                    this.initiateReqParametersJsonObj.put(str, Integer.valueOf(extras.getInt(str)));
                } else if (name.toLowerCase().contains(TypedValues.Custom.S_FLOAT)) {
                    this.initiateReqParametersJsonObj.put(str, Float.valueOf(extras.getFloat(str)));
                } else if (name.toLowerCase().contains("short")) {
                    this.initiateReqParametersJsonObj.put(str, Short.valueOf(extras.getShort(str)));
                } else if (name.toLowerCase().contains("long")) {
                    this.initiateReqParametersJsonObj.put(str, Long.valueOf(extras.getLong(str)));
                } else {
                    this.initiateReqParametersJsonObj.put(str, extras.getString(str, "").trim());
                }
            }
            if (!this.isAccesskey) {
                this.initiateReqParametersJsonObj.put("isMobile", 1);
            }
            this.initiateReqParametersJsonObj.put("android_os_version", Build.VERSION.RELEASE);
            this.initiateReqParametersJsonObj.put("android_sdk_version", "v1_02_25");
            this.paymentInfoHandler.setPaymentMode(this.initiateReqParametersJsonObj.get("pay_mode").toString());
        } catch (Error e2) {
            String str2 = "Unable to parse parameters : " + e2.getMessage();
            this.client_error_description = str2;
            showErrorDialog(this.client_error, str2, PWEStaticDataModel.TXN_ERROR_RETRY_FAILED_CODE);
        } catch (NullPointerException unused) {
            this.client_error_description = "null value is not allowed in any parameter";
            showErrorDialog(this.client_error, "null value is not allowed in any parameter", PWEStaticDataModel.TXN_ERROR_RETRY_FAILED_CODE);
        } catch (Exception e3) {
            String str3 = "Unable to parse parameters : " + e3.getMessage();
            this.client_error_description = str3;
            showErrorDialog(this.client_error, str3, PWEStaticDataModel.TXN_ERROR_RETRY_FAILED_CODE);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:(2:127|13)|(14:18|119|24|(10:29|(1:33)|124|39|(20:44|(1:48)|133|54|(1:58)|59|131|64|(2:68|72)|117|73|(2:77|81)|125|82|(2:86|90)|120|91|(2:95|99)|(2:115|101)|104)|49|53|133|54|(25:56|58|59|131|64|(1:66)|68|72|117|73|(1:75)|77|81|125|82|(1:84)|86|90|120|91|(1:93)|95|99|(0)|104)(0))|34|38|124|39|(3:41|44|(5:46|48|133|54|(0)(0))(0))|49|53|133|54|(0)(0))|19|23|119|24|(3:26|29|(10:31|33|124|39|(0)|49|53|133|54|(0)(0))(0))|34|38|124|39|(0)|49|53|133|54|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(18:127|13|(14:18|119|24|(10:29|(1:33)|124|39|(20:44|(1:48)|133|54|(1:58)|59|131|64|(2:68|72)|117|73|(2:77|81)|125|82|(2:86|90)|120|91|(2:95|99)|(2:115|101)|104)|49|53|133|54|(25:56|58|59|131|64|(1:66)|68|72|117|73|(1:75)|77|81|125|82|(1:84)|86|90|120|91|(1:93)|95|99|(0)|104)(0))|34|38|124|39|(3:41|44|(5:46|48|133|54|(0)(0))(0))|49|53|133|54|(0)(0))|19|23|119|24|(3:26|29|(10:31|33|124|39|(0)|49|53|133|54|(0)(0))(0))|34|38|124|39|(0)|49|53|133|54|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x011a, code lost:
    
        r17.client_error_description += "Transaction Id,";
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0130, code lost:
    
        r17.client_error_description += "Transaction Id,";
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x018d, code lost:
    
        r17.client_error_description += " Amount,";
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x01a3, code lost:
    
        r17.client_error_description += " Amount,";
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01e6, code lost:
    
        r17.client_error_description += " Phone,";
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01fc, code lost:
    
        r17.client_error_description += " Phone,";
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0211, code lost:
    
        r9 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x037c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0101 A[Catch: Error -> 0x011a, Exception -> 0x0130, TryCatch #20 {Error -> 0x011a, Exception -> 0x0130, blocks: (B:24:0x00d7, B:26:0x00ea, B:29:0x00f1, B:31:0x00f9, B:33:0x0101, B:34:0x0104), top: B:119:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0154 A[Catch: Error -> 0x018d, Exception -> 0x01a3, TryCatch #17 {Error -> 0x018d, Exception -> 0x01a3, blocks: (B:39:0x0146, B:41:0x0154, B:44:0x015f, B:46:0x0163, B:48:0x016b, B:49:0x0177), top: B:124:0x0146 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x016b A[Catch: Error -> 0x018d, Exception -> 0x01a3, TryCatch #17 {Error -> 0x018d, Exception -> 0x01a3, blocks: (B:39:0x0146, B:41:0x0154, B:44:0x015f, B:46:0x0163, B:48:0x016b, B:49:0x0177), top: B:124:0x0146 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01c7 A[Catch: Error -> 0x01e6, Exception -> 0x01fc, TryCatch #12 {Error -> 0x01e6, Exception -> 0x01fc, blocks: (B:54:0x01b9, B:56:0x01c7, B:59:0x01e3, B:58:0x01cd), top: B:133:0x01b9 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01cd A[Catch: Error -> 0x01e6, Exception -> 0x01fc, TryCatch #12 {Error -> 0x01e6, Exception -> 0x01fc, blocks: (B:54:0x01b9, B:56:0x01c7, B:59:0x01e3, B:58:0x01cd), top: B:133:0x01b9 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean validatePaymentParameters() {
        /*
            Method dump skipped, instruction units count: 1006
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easebuzz.payment.kit.PWECouponsActivity.validatePaymentParameters():boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0177 A[Catch: Exception -> 0x029b, TryCatch #0 {Exception -> 0x029b, blocks: (B:3:0x000a, B:6:0x0045, B:8:0x004d, B:10:0x0078, B:14:0x0129, B:16:0x0177, B:18:0x01e3, B:20:0x0213, B:22:0x024e, B:21:0x0220, B:17:0x0184, B:11:0x00d0, B:12:0x00fa), top: B:27:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0184 A[Catch: Exception -> 0x029b, TryCatch #0 {Exception -> 0x029b, blocks: (B:3:0x000a, B:6:0x0045, B:8:0x004d, B:10:0x0078, B:14:0x0129, B:16:0x0177, B:18:0x01e3, B:20:0x0213, B:22:0x024e, B:21:0x0220, B:17:0x0184, B:11:0x00d0, B:12:0x00fa), top: B:27:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0213 A[Catch: Exception -> 0x029b, TryCatch #0 {Exception -> 0x029b, blocks: (B:3:0x000a, B:6:0x0045, B:8:0x004d, B:10:0x0078, B:14:0x0129, B:16:0x0177, B:18:0x01e3, B:20:0x0213, B:22:0x024e, B:21:0x0220, B:17:0x0184, B:11:0x00d0, B:12:0x00fa), top: B:27:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0220 A[Catch: Exception -> 0x029b, TryCatch #0 {Exception -> 0x029b, blocks: (B:3:0x000a, B:6:0x0045, B:8:0x004d, B:10:0x0078, B:14:0x0129, B:16:0x0177, B:18:0x01e3, B:20:0x0213, B:22:0x024e, B:21:0x0220, B:17:0x0184, B:11:0x00d0, B:12:0x00fa), top: B:27:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void setCustomerPaymentInfo() {
        /*
            Method dump skipped, instruction units count: 672
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easebuzz.payment.kit.PWECouponsActivity.setCustomerPaymentInfo():void");
    }

    private void hideApplyCashbackBtn() {
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            this.btnApplyCashbackLayout.setVisibility(8);
            this.linearApplyCashbackBtnLayout.setVisibility(8);
        } else {
            this.linearApplyCashbackLayout.setVisibility(8);
        }
    }

    private void showApplyCashbackBtn() {
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            this.btnApplyCashbackLayout.setVisibility(0);
            this.linearApplyCashbackBtnLayout.setVisibility(0);
        } else {
            this.linearApplyCashbackLayout.setVisibility(0);
        }
    }

    private void setCashbackCouponsLayout(String str) {
        hideApplyCashbackBtn();
        this.linearCashbackLayout.setVisibility(8);
        this.linearPayAmountSection1.setVisibility(8);
        this.linearPayAmountSection2.setVisibility(0);
        if (this.paymentInfoHandler.getIsCashbackCouponEnabled() == 1) {
            if (PWEStaticDataModel.PWE_MODE_SELECTED.equals("paymentoption")) {
                this.linearPayAmountSection1.setVisibility(0);
                this.linearPayAmountSection2.setVisibility(8);
                showApplyCashbackBtn();
                this.linearCashbackLayout.setVisibility(8);
            } else if (PWEStaticDataModel.PWE_MODE_SELECTED.equals("cashbackcoupons")) {
                this.linearPayAmountSection1.setVisibility(8);
                this.linearPayAmountSection2.setVisibility(0);
                hideApplyCashbackBtn();
                this.linearCashbackLayout.setVisibility(0);
            }
            if (!str.equals("BACK_PRESSED") || (this.fManager.findFragmentById(R.id.linear_fragment_holder) instanceof PWEPaymentOptionsFragment)) {
                return;
            }
            this.linearPayAmountSection1.setVisibility(0);
            this.linearPayAmountSection2.setVisibility(8);
            showApplyCashbackBtn();
            this.linearCashbackLayout.setVisibility(8);
        }
    }

    protected void updateSelectedCashBackData() {
        this.tvSelectedCouponsCount.setText("" + PWEStaticDataModel.SELECTED_COUPON_COUNT + " ");
    }

    protected void showErrorDialog(final String str, final String str2, final String str3) {
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
        button2.setVisibility(4);
        try {
            AlertDialog alertDialogCreate = builder.create();
            this.alertDialog_ = alertDialogCreate;
            alertDialogCreate.show();
        } catch (Exception unused) {
            sendFailedResponseMerchant(PWEStaticDataModel.SERVER_ERROR_STR, PWEStaticDataModel.ERROR_DESC_STR, PWEStaticDataModel.TXN_ERROR_SERVER_ERROR_CODE);
        }
        textView.setText(str);
        textView2.setText(str2);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWECouponsActivity.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PWECouponsActivity.this.sendFailedResponseMerchant(str, str2, str3);
                PWECouponsActivity.this.alertDialog_.dismiss();
            }
        });
    }

    protected void showUserConfirmationDialog(String str, String str2, final String str3, final int i, final String str4, final String str5, final int i2) {
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
        button.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWECouponsActivity.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (str4.equals("DELETED_SAVE_CARD")) {
                    Fragment fragmentFindFragmentById = PWECouponsActivity.this.fManager.findFragmentById(R.id.linear_fragment_holder);
                    PWECouponsActivity.this.btnCancelTransaction.setVisibility(0);
                    if (fragmentFindFragmentById instanceof PWESavedCardFragment) {
                        ((PWESavedCardFragment) fragmentFindFragmentById).deleteSavedCard(str5, i2);
                    }
                } else if (str4.equals("CANCEL_UPI_TRANSACTION")) {
                    Fragment fragmentFindFragmentById2 = PWECouponsActivity.this.fManager.findFragmentById(R.id.linear_fragment_holder);
                    if (fragmentFindFragmentById2 instanceof PWEUpiFragment) {
                        ((PWEUpiFragment) fragmentFindFragmentById2).cancelUPIRequest();
                    }
                } else if (PWECouponsActivity.retry_cancel_count < 2) {
                    PWECouponsActivity.this.sendUserCancelRequest(str3, i);
                } else if (PWECouponsActivity.retry_cancel_count == 4) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("error", PWEStaticDataModel.BANK_BACK_PRESSED_STR);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    PWECouponsActivity.this.sendResponseToMerchant(PWEStaticDataModel.TXN_BANK_BACK_PRESSED_CODE, jSONObject.toString(), 0);
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("error", "This transaction is dropped because weak internet connection.");
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                    PWECouponsActivity.this.sendResponseToMerchant(PWEStaticDataModel.TXN_USERCANCELLED_CODE, jSONObject2.toString(), 0);
                }
                PWECouponsActivity.this.userCancelAlertDialog.dismiss();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWECouponsActivity.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PWECouponsActivity.this.userCancelAlertDialog.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendUserCancelRequest(final String str, final int i) {
        this.access_key = this.paymentInfoHandler.getMerchantAccessKey();
        showPWELoader();
        ((RetroAPI) new Retrofit.Builder().baseUrl(this.EndPointUrl).addConverterFactory(new ToStringConverterFactory()).callFactory(this.generalHelper.getRetrofitConnectionFactory()).build().create(RetroAPI.class)).userCancelRequest(this.access_key, i, str).enqueue(new Callback<String>() { // from class: com.easebuzz.payment.kit.PWECouponsActivity.21
            @Override // retrofit2.Callback
            public void onResponse(Call<String> call, Response<String> response) {
                try {
                    PWECouponsActivity.this.hidePWELoader();
                    PWECouponsActivity.this.handleUserCancelResponse(response.body().toString());
                } catch (Exception unused) {
                    PWECouponsActivity.this.generalHelper.showPweToast("Please try again.");
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<String> call, Throwable th) {
                try {
                    PWECouponsActivity.this.hidePWELoader();
                    PWECouponsActivity.retry_cancel_count++;
                    if (PWECouponsActivity.retry_cancel_count <= 2) {
                        if (PWECouponsActivity.retry_cancel_count == 1) {
                            PWECouponsActivity.this.showUserConfirmationDialog("Cancel Transaction", "Please try again", str, i, "CANCEL_TRANSACTION", "", -1);
                        }
                        if (PWECouponsActivity.retry_cancel_count == 2) {
                            PWECouponsActivity.this.showUserConfirmationDialog(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, Const.NO_INTERNET, str, i, "CANCEL_TRANSACTION", "", -1);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUserCancelResponse(String str) {
        String string;
        try {
            string = new JSONObject(str).getString("final_response");
        } catch (JSONException e2) {
            e2.printStackTrace();
            string = "";
        }
        sendResponseToMerchant(PWEStaticDataModel.TXN_USERCANCELLED_CODE, string, 0);
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

    protected void sendResponseToMerchant(String str, String str2, int i) {
        this.paymentInfoHandler.setMerchantTxnId("");
        this.paymentInfoHandler.setMerchantAccessKey("");
        this.paymentInfoHandler.setPweLastTransactionStatus("");
        PWEStaticHelper.PWE_CURRENT_TRXN_STATUS = "";
        stopSessionTimer();
        Intent intent = new Intent();
        intent.putExtra("result", str);
        intent.putExtra("payment_response", str2);
        setResult(i, intent);
        finish();
    }

    protected void setTimoutResult() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error", "Transaction timeout.");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        sendResponseToMerchant(PWEStaticDataModel.TXN_TIMEOUT_CODE, jSONObject.toString(), 0);
    }

    protected void startSessionTimer() {
        this.transactionTimerHelper.initiateSessionTime();
        this.transactionTimerHelper.updateTransactionSessionTime();
    }

    protected void stopSessionTimer() {
        this.paymentInfoHandler.setIsTxnTimerStopped(true);
        this.transactionTimerHelper.stopGenericSessionTimer();
    }

    protected void submitPayment(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22) {
        String selectedPaymentOption = this.paymentInfoHandler.getSelectedPaymentOption();
        String[] strArr = {PWEStaticDataModel.PAYOPT_DEBITCARD_NAME, PWEStaticDataModel.PAYOPT_CREDITCARD_NAME, PWEStaticDataModel.PAYOPT_DEBIT_ATM_NAME, PWEStaticDataModel.PAYOPT_SAVED_CARD_NAME, PWEStaticDataModel.PAYOPT_NETBANK_NAME, PWEStaticDataModel.EMI_NAME, PWEStaticDataModel.OLA_MONEY_NAME, PWEStaticDataModel.PAYOPT_WALLET_NAME, PWEStaticDataModel.PAYOPT_ENACH_NAME, PWEStaticDataModel.SIMPL_NAME};
        KeyBoardListener keyBoardListener = new KeyBoardListener();
        this.kbl = keyBoardListener;
        keyBoardListener.hideKeyboard(this);
        if (Arrays.asList(strArr).contains(selectedPaymentOption)) {
            this.paymentInfoHandler.setSelectedBankName(str);
            this.paymentInfoHandler.setSelectedOtherBankName(str2);
            this.paymentInfoHandler.setSelectedBankCode(str3);
            if (validateData(str4) && validateData(str5) && validateData(str6) && validateData(str8) && validateData(str14) && validateData(str15) && validateData(str16) && validateData(str17) && validateData(str18) && validateData(str19) && validateData(str20)) {
                this.paymentInfoHandler.setSelectedCardNumber(str4);
                this.paymentInfoHandler.setSelectedNameOnCard(str5);
                this.paymentInfoHandler.setSelectedExpDate(str6);
                this.paymentInfoHandler.setSelectedCardType(str7);
                this.paymentInfoHandler.setSelectedCVVString(str8);
                this.paymentInfoHandler.setNoCVVFlag(str9);
                this.paymentInfoHandler.setSelectedCardID(str10);
                this.paymentInfoHandler.setSelectedSavedCardCvv(str11);
                this.paymentInfoHandler.setSelectedSavedCardFlag(str12);
                this.paymentInfoHandler.setSelectedEMIDict(str13);
                this.paymentInfoHandler.setPWEEnachAccountNumber(str14);
                this.paymentInfoHandler.setPWEEnachAccountHolderName(str15);
                this.paymentInfoHandler.setPWEEnachAccountType(str16);
                this.paymentInfoHandler.setPWEEnachIFSCCode(str17);
                this.paymentInfoHandler.setPWEEnachAuthMode(str18);
                this.paymentInfoHandler.setPWEEnachBankName(str19);
                this.paymentInfoHandler.setPWEEnachBankCode(str20);
                this.paymentInfoHandler.setPWESimplEligibleData(str21);
                this.paymentInfoHandler.setPWESimplPayLaterAppName(str22);
                showMode("PROCESS_PAYMENT");
                return;
            }
            this.generalHelper.showPweToast(PWEStaticDataModel.INVALID_DATA);
            return;
        }
        this.generalHelper.showPweToast("Invalid Payment option");
    }

    private boolean validateData(String str) {
        return str.isEmpty() || !Pattern.compile(PWEStaticDataModel.INPUT_SCRIPT_REGEX, 2).matcher(str).find();
    }

    protected void openDiscountView() {
        JSONObject jSONObjectValidateDiscountCodeOuter;
        try {
            String selectedPaymentOption = this.paymentInfoHandler.getSelectedPaymentOption();
            Fragment fragmentFindFragmentById = this.fManager.findFragmentById(R.id.linear_fragment_holder);
            if (selectedPaymentOption.equals(PWEStaticDataModel.PAYOPT_CREDITCARD_NAME) || selectedPaymentOption.equals(PWEStaticDataModel.PAYOPT_DEBITCARD_NAME)) {
                jSONObjectValidateDiscountCodeOuter = ((PWEDebitCreditFragment) fragmentFindFragmentById).validateDiscountCodeOuter(this.discount_list, this.discountCodeHelper);
            } else if (selectedPaymentOption.equals(PWEStaticDataModel.PAYOPT_WALLET_NAME)) {
                jSONObjectValidateDiscountCodeOuter = ((PWEWalletFragment) fragmentFindFragmentById).validateDiscountCodeOuter(this.discount_list, this.discountCodeHelper);
            } else if (selectedPaymentOption.equals(PWEStaticDataModel.PAYOPT_SAVED_CARD_NAME)) {
                jSONObjectValidateDiscountCodeOuter = ((PWESavedCardFragment) fragmentFindFragmentById).validateDiscountCodeOuter(this.discount_list, this.discountCodeHelper);
            } else if (selectedPaymentOption.equals(PWEStaticDataModel.PAYOPT_UPI_NAME)) {
                jSONObjectValidateDiscountCodeOuter = ((PWEUpiFragment) fragmentFindFragmentById).validateDiscountCodeOuter(this.discount_list, this.discountCodeHelper);
            } else if (selectedPaymentOption.equals(PWEStaticDataModel.PAYOPT_NETBANK_NAME)) {
                ((PWENetbankingFragment) fragmentFindFragmentById).setBankCode();
                jSONObjectValidateDiscountCodeOuter = ((PWENetbankingFragment) fragmentFindFragmentById).validateDiscountCodeOuter(this.discount_list, this.discountCodeHelper);
            } else {
                jSONObjectValidateDiscountCodeOuter = null;
            }
            if (jSONObjectValidateDiscountCodeOuter.optBoolean("status", false)) {
                this.bin_number = jSONObjectValidateDiscountCodeOuter.optString("bin_number", "");
                this.card_id = jSONObjectValidateDiscountCodeOuter.optString("card_id", "");
                this.discountCodeHelper.openBottomSheetApplyCoupon(this);
                return;
            }
            this.generalHelper.showPweToast(jSONObjectValidateDiscountCodeOuter.optString("toast_error_message", "Error occured"));
        } catch (Error e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    protected void setProcessPaymentLayout(boolean z) {
        try {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.linearFragmentHolderParent.getLayoutParams();
            if (z) {
                layoutParams.setMargins(10, 10, 10, 10);
                this.linearFragmentHolderParent.setLayoutParams(layoutParams);
                this.linearRootHeader.setVisibility(8);
                this.linearRootFooter.setVisibility(8);
                return;
            }
            this.linearRootHeader.setVisibility(0);
            this.linearRootFooter.setVisibility(0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    protected PWEDiscountHelper getDiscountHelper() {
        return this.discountCodeHelper;
    }

    protected void setPaymentMethodCommonInfo(String str) {
        PWEDiscountHelper pWEDiscountHelper = new PWEDiscountHelper(this, str, PWEStaticDataModel.PWE_MODE_SELECTED);
        this.discountCodeHelper = pWEDiscountHelper;
        this.discount_list = pWEDiscountHelper.getDiscountCodeList(str);
        this.discountCodeHelper.setDiscountCodeListener(new PWEDiscountListener() { // from class: com.easebuzz.payment.kit.PWECouponsActivity.22
            @Override // listeners.PWEDiscountListener
            public void applySelectedDiscountCode(DiscountCodeDataModel discountCodeDataModel, int i) {
            }

            @Override // listeners.PWEDiscountListener
            public JSONObject validateApplyDiscount(String str2) {
                return PWECouponsActivity.this.validateApplyDiscountCode(str2);
            }

            @Override // listeners.PWEDiscountListener
            public void setBasicPaymentInfo() {
                PWECouponsActivity.this.setCustomerPaymentInfo();
            }
        });
    }

    protected JSONObject validateApplyDiscountCode(String str) {
        boolean z;
        this.discount_validation_error = "";
        JSONObject jSONObject = new JSONObject();
        try {
            String strTrim = str.trim();
            boolean z2 = false;
            if (strTrim == null || strTrim.isEmpty() || strTrim.equals("")) {
                this.discount_validation_error = "Please enter valid discount code";
                z = false;
            } else {
                z = true;
            }
            String merchantTxnId = this.paymentInfoHandler.getMerchantTxnId();
            if (merchantTxnId == null || merchantTxnId.isEmpty() || merchantTxnId.equals("")) {
                this.discount_validation_error = "Invalid transaction id";
            } else {
                z2 = z;
            }
            jSONObject.put("status", z2);
            jSONObject.put("bin_number", this.bin_number);
            jSONObject.put("bank_wallet_name", this.bank_wallet_name);
            jSONObject.put("card_id", this.card_id);
            jSONObject.put("error_message", this.discount_validation_error);
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return jSONObject;
        }
    }

    protected void resetDiscountCode() {
        this.payAmtHelper.resetAppliedCouponFlag(false, "", "", "");
        setCustomerPaymentInfo();
    }

    protected void setDiscountCodeVisibiliy(String str) {
        this.linearDiscountCodeHolder.setVisibility(8);
        if (this.paymentInfoHandler.getIsDiscountCouponEnabled() && this.paymentInfoHandler.getDiscountVisibilityFlag() && str.toLowerCase().equals("show")) {
            this.linearDiscountCodeHolder.setVisibility(0);
            setPaymentMethodCommonInfo(this.paymentInfoHandler.getSelectedPaymentOption());
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        PWECouponsActivity pWECouponsActivity;
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            this.linearGoBackLayoutBtn.requestFocus();
        }
        Fragment fragmentFindFragmentById = this.fManager.findFragmentById(R.id.linear_fragment_holder);
        this.btnCancelTransaction.setVisibility(0);
        if (fragmentFindFragmentById instanceof PWEPaymentOptionsFragment) {
            cancelTransaction();
            return;
        }
        if (fragmentFindFragmentById instanceof PWECancellationReasonFragment) {
            this.btnCancelTransaction.setVisibility(0);
            setDiscountCodeVisibiliy("show");
            if (PWEStaticDataModel.PWE_MODE_SELECTED.equals("paymentoption") || PWEStaticDataModel.PWE_MODE_SELECTED.equals("cashbackcoupons")) {
                this.pweCardPageMessageHelper.showMessage("global");
                enableCashback();
            } else {
                this.pweCardPageMessageHelper.showMessage(this.paymentInfoHandler.getSelectedPaymentOption());
            }
            super.onBackPressed();
            return;
        }
        if (fragmentFindFragmentById instanceof PWECouponsDetailsFragment) {
            PWEStaticDataModel.PWE_MODE_SELECTED = "cashbackcoupons";
            enableCashback();
            setSelectedCouponModel(null);
            super.onBackPressed();
            return;
        }
        if (fragmentFindFragmentById instanceof PWEUpiFragment) {
            if (PWEStaticHelper.PWE_CURRENT_TRXN_STATUS.equals(PWEStaticDataModel.PWE_STATUS_PENDING)) {
                pWECouponsActivity = this;
                pWECouponsActivity.showUserConfirmationDialog("Cancel Transaction", "Do you really want to cancel the transaction ?", "", 1, "CANCEL_UPI_TRANSACTION", "", -1);
            } else {
                pWECouponsActivity = this;
                pWECouponsActivity.discountCodeHelper.setUpiVA("");
                resetDiscountCode();
                setDiscountCodeVisibiliy("hide");
                super.onBackPressed();
                showMode("PAY_OPTIONS");
            }
            pWECouponsActivity.pweCardPageMessageHelper.closeMessage();
            return;
        }
        showMode("PAY_OPTIONS");
        this.pweCardPageMessageHelper.closeMessage();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        PWEStaticDataModel.IS_APP_REINITIALIZED = false;
        PWEStaticHelper.PWE_CURRENT_TRXN_STATUS = "";
        resetTrxnPreferences();
        try {
            hidePWELoader();
        } catch (Error | Exception unused) {
        }
        try {
            unregisterReceiver(this.timerBroadCastReciever);
        } catch (Error | Exception unused2) {
        }
        super.onDestroy();
    }

    protected void showPWELoader() {
        Dialog dialog = this.pweLoader;
        if (dialog != null) {
            dialog.show();
        }
    }

    protected void hidePWELoader() {
        Dialog dialog = this.pweLoader;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.pweLoader.dismiss();
    }

    protected void removeMode(String str) {
        this.fManager.popBackStack();
    }

    private boolean checkDeviceSupportForEnach() {
        return Build.VERSION.SDK_INT >= this.paymentInfoHandler.getEnachNotSupportableAndroidOsVersion();
    }

    public CouponDataModel getSelectedCouponModel() {
        return this.selectedCouponModel;
    }

    public void setSelectedCouponModel(CouponDataModel couponDataModel) {
        this.selectedCouponModel = couponDataModel;
    }
}
