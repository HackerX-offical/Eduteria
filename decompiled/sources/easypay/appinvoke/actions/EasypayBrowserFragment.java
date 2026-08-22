package easypay.appinvoke.actions;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.JsonReader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import easypay.appinvoke.entity.AssistDetailsResponse;
import easypay.appinvoke.entity.AssistUrlResponse;
import easypay.appinvoke.entity.Operation;
import easypay.appinvoke.listeners.WebClientListener;
import easypay.appinvoke.manager.Constants;
import easypay.appinvoke.manager.EasyPayHelper;
import easypay.appinvoke.manager.EasypayWebViewClient;
import easypay.appinvoke.manager.PaytmAssist;
import easypay.appinvoke.utils.AnalyticsService;
import easypay.appinvoke.utils.AssistLogs;
import easypay.appinvoke.utils.EasyPayConfigDownloader;
import easypay.appinvoke.widget.OtpEditText;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import paytm.assist.easypay.easypay.appinvoke.R;

/* JADX INFO: loaded from: classes9.dex */
public class EasypayBrowserFragment extends Fragment implements View.OnClickListener, WebClientListener, CompoundButton.OnCheckedChangeListener {
    private AppCompatActivity activity;
    private WebView browser;
    private CustomJsHelper currentCustomJsHelper;
    private NewOtpHelper currentNewOtpHelper;
    private OtpHelper currentOtpHelper;
    private PasswordHelper currentPasswordHelper;
    private ProceedHelper currentProceedHelper;
    private RadioHelper currentRadioHelper;
    private InputStream in;
    boolean isNbOtpFired;
    private Map<String, String> jsonActionMap;
    private LinearLayout ll_historic_id;
    private boolean mAllowEasyPay;
    private GAEventManager mAnalyticsManager;
    private ConstraintLayout mBottomContainer;
    private Button mBtnSubmitOtp;
    private String mCurrentUserId;
    private AssistDetailsResponse mDetailsResponse;
    private EasyPayHelper mEasyPayHelper;
    private ImageView mHideButton;
    OtpEditText mInputPassCode;
    private EditText mNBUserId;
    private Button mNbButton;
    private ImageButton mNbImageNext;
    private ImageButton mNbImagePrevious;
    private HashMap<String, Operation> mNbOpMapSearch;
    private EditText mNbPwd;
    private TextWatcher mNbUserIdWatcher;
    private CheckBox mNbUserName;
    private TextView mOtpTimer;
    private ImageView mPaytmAssistBanner;
    private ConstraintLayout mRootContainer;
    private ImageView mShowAssist;
    private TextView mTvOtpLabel;
    private TextView mTvTapToPause;
    private EasypayWebViewClient mWebViewClient;
    private NBHelper nbHelper;
    private TextView nbPwdViewer;
    private String nbUserId;
    private NetBankingHelper netBankingHelper;
    private LinearLayout netBankingLoginLayout;
    private RelativeLayout parentPanel;
    private StringBuilder pwdBuilder;
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor sharedPrefEditor;
    private SharedPreferences sharedPrefForEvents;
    private Long timeFinish;
    private Long timeStart;
    private CountDownTimer timer;
    private TextView tvIdOne;
    private TextView tvIdThree;
    private TextView tvIdTwo;
    private HashMap<String, Operation> opMap = new HashMap<>();
    private StringBuilder redirectUrl = new StringBuilder();
    boolean isHideAssistClicked = false;
    boolean isSaveIdChecked = true;
    public boolean isAssistVisible = false;
    private boolean isPaytmAssistOnOffEventSent = false;
    private boolean isSavePointer = true;
    private boolean isShow = true;
    private boolean isAssistNewFlow = false;
    private boolean mShowSuggestionBox = false;
    private String mEtCurrentText = "";
    int mLoaderCount = 0;
    private TextView[] historicTvArray = new TextView[3];
    private BroadcastReceiver downloadListener = new BroadcastReceiver() { // from class: easypay.appinvoke.actions.EasypayBrowserFragment.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (Constants.EASYPAY_ACTION_FILE_DOWNLOADED.equalsIgnoreCase(intent.getAction())) {
                EasypayBrowserFragment.this.loadConfigurationFromSharedPrefs();
            } else {
                EasypayBrowserFragment.this.loadConfiguration();
            }
        }
    };

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

    public static EasypayBrowserFragment newInstance() {
        Bundle bundle = new Bundle();
        EasypayBrowserFragment easypayBrowserFragment = new EasypayBrowserFragment();
        easypayBrowserFragment.setArguments(bundle);
        return easypayBrowserFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.easypay_browser_frag_revamp, viewGroup, false);
    }

    private void readPgData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.browser = PaytmAssist.getAssistInstance().getWebView();
            } catch (NullPointerException e2) {
                e2.printStackTrace();
                AssistLogs.printLog("EXCEPTION", e2);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        try {
            this.activity = (AppCompatActivity) getActivity();
            this.mWebViewClient = PaytmAssist.getAssistInstance().getWebClientInstance();
            readPgData(getArguments());
            this.redirectUrl.append("|");
            initOtpViews();
            this.mAnalyticsManager = PaytmAssist.getAssistInstance().getmAnalyticsManager();
            PaytmAssist.getAssistInstance().setFragmentResumed(false);
            PaytmAssist.getAssistInstance().setFragmentPaused(false);
            initNbViews();
            WebView webView = this.browser;
            if (webView != null) {
                webView.getSettings().setDomStorageEnabled(true);
                this.browser.getSettings().setJavaScriptEnabled(true);
                this.browser.getSettings().setMixedContentMode(0);
                WebView.setWebContentsDebuggingEnabled(true);
                this.mEasyPayHelper = PaytmAssist.getAssistInstance().getEasyPayHelper();
            }
            EasypayWebViewClient easypayWebViewClient = this.mWebViewClient;
            if (easypayWebViewClient != null) {
                easypayWebViewClient.addAssistWebClientListener(this);
            }
            this.nbHelper = new NBHelper(null, this.browser, this.activity, null);
            loadPrefs();
            IntentFilter intentFilter = new IntentFilter(Constants.EASYPAY_ACTION_OLD_FILE_DOWNLOADED);
            intentFilter.addAction(Constants.EASYPAY_ACTION_FILE_DOWNLOADED);
            try {
                this.activity.registerReceiver(this.downloadListener, intentFilter);
            } catch (Exception e2) {
                e2.printStackTrace();
                AssistLogs.printLog("EXCEPTION", e2);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            AssistLogs.printLog("EXCEPTION", e3);
        }
    }

    private void initNbViews() {
        this.netBankingLoginLayout = (LinearLayout) this.activity.findViewById(R.id.ll_nb_login);
        this.mNbUserName = (CheckBox) this.activity.findViewById(R.id.cb_nb_userId);
        this.mNbPwd = (EditText) this.activity.findViewById(R.id.et_nb_password);
        this.mNBUserId = (EditText) this.activity.findViewById(R.id.et_nb_userIdCustomerId);
        this.ll_historic_id = (LinearLayout) this.activity.findViewById(R.id.ll_nb_user_id_Selector);
        this.parentPanel = (RelativeLayout) this.activity.findViewById(R.id.parentPanel);
        this.mNbButton = (Button) this.activity.findViewById(R.id.nb_bt_submit);
        this.tvIdOne = (TextView) this.activity.findViewById(R.id.tv_user_id_one);
        this.tvIdTwo = (TextView) this.activity.findViewById(R.id.tv_user_id_two);
        this.tvIdThree = (TextView) this.activity.findViewById(R.id.tv_user_id_three);
        this.mNbImagePrevious = (ImageButton) this.activity.findViewById(R.id.nb_image_bt_previous);
        this.mNbImageNext = (ImageButton) this.activity.findViewById(R.id.nb_image_bt_next);
        this.nbPwdViewer = (TextView) this.activity.findViewById(R.id.img_pwd_show);
        this.pwdBuilder = new StringBuilder();
        this.mNbUserIdWatcher = new TextWatcher() { // from class: easypay.appinvoke.actions.EasypayBrowserFragment.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().equals(EasypayBrowserFragment.this.mCurrentUserId)) {
                    if (editable.toString().equals(EasypayBrowserFragment.this.mEtCurrentText)) {
                        EasypayBrowserFragment easypayBrowserFragment = EasypayBrowserFragment.this;
                        easypayBrowserFragment.setUIDCheck(easypayBrowserFragment.isSaveIdChecked);
                        return;
                    } else {
                        EasypayBrowserFragment.this.setUIDCheck(true);
                        EasypayBrowserFragment.this.toggleSavedUserIdTextView(true, editable.toString());
                        return;
                    }
                }
                EasypayBrowserFragment.this.setUIDCheck(false);
                EasypayBrowserFragment easypayBrowserFragment2 = EasypayBrowserFragment.this;
                easypayBrowserFragment2.toggleSavedUserIdTextView(false, easypayBrowserFragment2.mCurrentUserId);
            }
        };
        TextView[] textViewArr = this.historicTvArray;
        textViewArr[0] = this.tvIdOne;
        textViewArr[1] = this.tvIdTwo;
        textViewArr[2] = this.tvIdThree;
        this.mNbPwd.setText("");
        this.mNBUserId.setText("");
        this.mNbUserName.setOnCheckedChangeListener(this);
        this.mNbUserName.setButtonDrawable(R.drawable.ic_checkbox_selected);
        this.mNBUserId.addTextChangedListener(this.mNbUserIdWatcher);
        Drawable drawable = this.activity.getBaseContext().getResources().getDrawable(R.drawable.ic_show_passcode);
        drawable.setBounds(0, 0, 24, 24);
        this.nbPwdViewer.setCompoundDrawables(drawable, null, null, null);
    }

    private void initOtpViews() {
        this.mShowAssist = (ImageView) this.activity.findViewById(R.id.img_show_assist);
        this.mTvOtpLabel = (TextView) this.activity.findViewById(R.id.tv_detection_status);
        this.mHideButton = (ImageView) this.activity.findViewById(R.id.img_hide_assist);
        this.mInputPassCode = (OtpEditText) this.activity.findViewById(R.id.edit_text_otp);
        this.mOtpTimer = (TextView) this.activity.findViewById(R.id.tv_submit_otp_time);
        this.mTvTapToPause = (TextView) this.activity.findViewById(R.id.tv_tap_to_pause);
        this.mBtnSubmitOtp = (Button) this.activity.findViewById(R.id.btn_submit_otp);
        this.mRootContainer = (ConstraintLayout) this.activity.findViewById(R.id.cl_show_assist);
        this.mBottomContainer = (ConstraintLayout) this.activity.findViewById(R.id.cl_hide_assist);
        this.mPaytmAssistBanner = (ImageView) this.activity.findViewById(R.id.img_paytm_assist_banner);
    }

    private void loadPrefs() {
        AppCompatActivity appCompatActivity = this.activity;
        if (appCompatActivity != null) {
            this.sharedPref = appCompatActivity.getSharedPreferences("com.paytm.com.paytm.pgsdk.easypay.appinvoke.PREFERENCE_FILE_KEY", 0);
            this.sharedPrefForEvents = this.activity.getSharedPreferences("com.paytm.com.paytm.pgsdk.easypay.appinvoke.EVENTS_FILE", 0);
            bindClickHandler();
            Arrays.sort("kokookokok".toCharArray());
        }
    }

    private void bindClickHandler() {
        this.mHideButton.setOnClickListener(this);
        this.tvIdOne.setOnClickListener(this);
        this.tvIdTwo.setOnClickListener(this);
        this.tvIdThree.setOnClickListener(this);
        this.nbPwdViewer.setOnClickListener(this);
        this.mNbImageNext.setOnClickListener(this);
        this.mNbImagePrevious.setOnClickListener(this);
        this.mTvOtpLabel.setOnClickListener(this);
        this.mTvTapToPause.setOnClickListener(this);
        this.mBtnSubmitOtp.setOnClickListener(this);
        this.mNbUserName.setOnClickListener(this);
        this.mPaytmAssistBanner.setOnClickListener(this);
        this.mNbButton.setOnClickListener(this);
        this.mShowAssist.setOnClickListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        BroadcastReceiver broadcastReceiver;
        super.onDestroyView();
        try {
            if (this.timeStart != null && this.timeFinish != null) {
                String str = "" + this.timeStart + "";
                String str2 = "" + this.timeFinish + "";
                AssistLogs.printLog(str + str2 + " Check", this);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    this.mAnalyticsManager.onAcsUrlRequested(str);
                    this.mAnalyticsManager.onAcsUrlLoaded(str2);
                    this.mAnalyticsManager.onExtraInfo(PaytmAssist.getAssistInstance().getmEventMap());
                }
            } else if (!TextUtils.isEmpty("time not captured") && !TextUtils.isEmpty("time not captured")) {
                this.mAnalyticsManager.onAcsUrlRequested("time not captured");
                this.mAnalyticsManager.onAcsUrlLoaded("time not captured");
            }
            GAEventManager gAEventManager = this.mAnalyticsManager;
            if (gAEventManager != null) {
                gAEventManager.OnredirectUrls(this.redirectUrl);
                if (this.mAnalyticsManager.getEventMap() != null) {
                    Intent intent = new Intent(this.activity, (Class<?>) AnalyticsService.class);
                    intent.putExtra("data", this.mAnalyticsManager.getEventMap());
                    AnalyticsService.enqueueWork(this.activity.getBaseContext(), intent);
                }
            }
            PasswordHelper passwordHelper = this.currentPasswordHelper;
            if (passwordHelper != null) {
                passwordHelper.unregisterEvent();
            }
            AppCompatActivity appCompatActivity = this.activity;
            if (appCompatActivity != null && (broadcastReceiver = this.downloadListener) != null) {
                appCompatActivity.unregisterReceiver(broadcastReceiver);
            }
            if (this.activity != null) {
                OtpHelper otpHelper = this.currentOtpHelper;
                if (otpHelper != null) {
                    if (otpHelper.customEventReceiver != null) {
                        this.activity.unregisterReceiver(this.currentOtpHelper.customEventReceiver);
                    }
                    if (this.currentOtpHelper.myreceiver != null) {
                        this.activity.unregisterReceiver(this.currentOtpHelper.myreceiver);
                    }
                    if (this.currentOtpHelper.mwebViewClient != null) {
                        this.currentOtpHelper.mwebViewClient.removeAssistWebClientListener(this.currentOtpHelper);
                    }
                }
                NewOtpHelper newOtpHelper = this.currentNewOtpHelper;
                if (newOtpHelper != null) {
                    newOtpHelper.unregisterBroadcastReceiver();
                }
            }
            PaytmAssist.getAssistInstance().setFragmentResumed(false);
            PaytmAssist.getAssistInstance().setFragmentPaused(false);
        } catch (NullPointerException e2) {
            e2.printStackTrace();
            AssistLogs.printLog("EXCEPTION", e2);
        } catch (Exception e3) {
            e3.printStackTrace();
            AssistLogs.printLog("EXCEPTION", e3);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NBHelper nBHelper;
        try {
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        }
        if (view.getId() == R.id.img_hide_assist) {
            minimizeAssistView();
            return;
        }
        if (view.getId() == R.id.img_show_assist) {
            showAssistView();
            return;
        }
        if (view.getId() == R.id.img_paytm_assist_banner) {
            this.mShowAssist.performClick();
            return;
        }
        if (view.getId() == R.id.tv_detection_status) {
            this.mHideButton.performClick();
            return;
        }
        if (view.getId() == R.id.tv_user_id_one) {
            this.nbHelper.updateValueForAutoFill(this.tvIdOne.getText().toString());
            setCurrentUserId(this.tvIdOne.getText().toString());
            toggleSavedUserIdTextView(false, this.mCurrentUserId);
            return;
        }
        if (view.getId() == R.id.tv_user_id_two) {
            this.nbHelper.updateValueForAutoFill(this.tvIdTwo.getText().toString());
            setCurrentUserId(this.tvIdTwo.getText().toString());
            toggleSavedUserIdTextView(false, this.mCurrentUserId);
            return;
        }
        if (view.getId() == R.id.tv_user_id_three) {
            this.nbHelper.updateValueForAutoFill(this.tvIdThree.getText().toString());
            setCurrentUserId(this.tvIdThree.getText().toString());
            return;
        }
        if (view.getId() == R.id.nb_bt_submit) {
            if (this.isAssistNewFlow && (nBHelper = this.nbHelper) != null) {
                nBHelper.fireActions(Constants.SUBMIT_BTN, this.mNbOpMapSearch.get(Constants.SUBMIT_BTN));
                GAEventManager gAEventManager = this.mAnalyticsManager;
                if (gAEventManager != null) {
                    gAEventManager.isRememberUserIdChecked(this.isSaveIdChecked);
                    this.mAnalyticsManager.isShowPasswordClicked(!this.isShow);
                    this.mAnalyticsManager.isNbSubmitButtonClicked(true);
                    return;
                }
                return;
            }
            this.mNbPwd.setText("");
            return;
        }
        if (view.getId() == R.id.nb_image_bt_next) {
            this.nbHelper.fireActions(Constants.NEXT_BTN, this.mNbOpMapSearch.get(Constants.NEXT_BTN));
            return;
        }
        if (view.getId() == R.id.nb_image_bt_previous) {
            this.nbHelper.fireActions(Constants.PREVIOUS_BTN, this.mNbOpMapSearch.get(Constants.PREVIOUS_BTN));
            return;
        }
        if (view.getId() == R.id.tv_tap_to_pause) {
            try {
                PaytmAssist.getAssistInstance().getmEventMap().put("pauseBtnClicked", true);
                GAEventManager gAEventManager2 = this.mAnalyticsManager;
                if (gAEventManager2 != null) {
                    gAEventManager2.isPauseButtonTapped(true);
                }
                CountDownTimer countDownTimer = this.timer;
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
                otpSubmitButtonState();
                return;
            } catch (Exception e3) {
                e3.printStackTrace();
                AssistLogs.printLog("EXCEPTION", e3);
                return;
            }
        }
        if (view.getId() == R.id.btn_submit_otp) {
            GAEventManager gAEventManager3 = this.mAnalyticsManager;
            if (gAEventManager3 != null) {
                gAEventManager3.isSubmitButtonClicked(true, 1);
                this.mAnalyticsManager.isAutoSubmit(false);
            }
            CountDownTimer countDownTimer2 = this.timer;
            if (countDownTimer2 != null) {
                countDownTimer2.cancel();
            }
            startSubmission();
            return;
        }
        if (view.getId() == R.id.img_pwd_show) {
            try {
                PaytmAssist.getAssistInstance().getmEventMap().put("showPasswordClicked", Boolean.valueOf(this.isShow));
                if (this.isShow) {
                    Drawable drawable = this.activity.getBaseContext().getResources().getDrawable(R.drawable.ic_hide_passcode);
                    drawable.setBounds(0, 0, 24, 24);
                    this.nbPwdViewer.setCompoundDrawables(drawable, null, null, null);
                    this.nbPwdViewer.setText(getString(R.string.hide));
                    this.mNbPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    this.isShow = false;
                } else {
                    Drawable drawable2 = this.activity.getBaseContext().getResources().getDrawable(R.drawable.ic_show_passcode);
                    drawable2.setBounds(0, 0, 24, 24);
                    this.nbPwdViewer.setCompoundDrawables(drawable2, null, null, null);
                    this.nbPwdViewer.setText(getString(R.string.show));
                    this.mNbPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    EditText editText = this.mNbPwd;
                    editText.setSelection(editText.getText().length());
                    this.isShow = true;
                }
                return;
            } catch (Exception e4) {
                e4.printStackTrace();
                return;
            }
        }
        return;
        e2.printStackTrace();
    }

    private void showAssistView() {
        AppCompatActivity appCompatActivity = this.activity;
        if (appCompatActivity != null) {
            appCompatActivity.runOnUiThread(new Runnable() { // from class: easypay.appinvoke.actions.EasypayBrowserFragment.3
                @Override // java.lang.Runnable
                public void run() {
                    EasypayBrowserFragment.this.isHideAssistClicked = false;
                    EasypayBrowserFragment.this.mRootContainer.setVisibility(0);
                    EasypayBrowserFragment.this.mBottomContainer.setVisibility(8);
                    EasypayBrowserFragment.this.otpSubmitButtonState();
                }
            });
        }
    }

    private void minimizeAssistView() {
        AppCompatActivity appCompatActivity = this.activity;
        if (appCompatActivity != null) {
            appCompatActivity.runOnUiThread(new Runnable() { // from class: easypay.appinvoke.actions.EasypayBrowserFragment.4
                @Override // java.lang.Runnable
                public void run() {
                    EasypayBrowserFragment.this.isHideAssistClicked = true;
                    if (EasypayBrowserFragment.this.timer != null) {
                        EasypayBrowserFragment.this.timer.cancel();
                    }
                    EasypayBrowserFragment.this.mRootContainer.setVisibility(8);
                    EasypayBrowserFragment.this.mBottomContainer.setVisibility(0);
                    if (EasypayBrowserFragment.this.mAnalyticsManager != null) {
                        EasypayBrowserFragment.this.mAnalyticsManager.isAssistMinimized(true);
                    }
                }
            });
        }
    }

    void setCurrentUserId(String str) {
        setUIDCheck(false);
        this.mCurrentUserId = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSubmission() {
        AssistDetailsResponse assistDetailsResponse = this.mDetailsResponse;
        if (assistDetailsResponse == null || !this.isAssistVisible) {
            return;
        }
        if (Constants.EASYPAY_PAYTYPE_CREDIT_CARD.equalsIgnoreCase(assistDetailsResponse.getPayType()) || Constants.EASYPAY_PAYTYPE_DEBIT_CARD.equalsIgnoreCase(this.mDetailsResponse.getPayType())) {
            this.currentNewOtpHelper.submitOTP(this.opMap.get(Constants.SUBMIT_BTN));
        }
    }

    private void saveCustId(boolean z) {
        if (z) {
            SharedPreferences sharedPreferences = this.activity.getApplicationContext().getSharedPreferences(Constants.BANKPREF, 0);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            String str = this.jsonActionMap.get("bank");
            String string = sharedPreferences.getString(Constants.USER_ID_NET_BANK_KEY, "");
            if (!TextUtils.isEmpty(string)) {
                HashMap map = (HashMap) new Gson().fromJson(string, new TypeToken<HashMap<String, String>>() { // from class: easypay.appinvoke.actions.EasypayBrowserFragment.5
                }.getType());
                if (map == null || map.containsKey(str)) {
                    return;
                }
                map.put(str, this.nbUserId);
                editorEdit.putString(Constants.USER_ID_NET_BANK_KEY, new Gson().toJson(map));
                editorEdit.apply();
                return;
            }
            HashMap map2 = new HashMap();
            map2.put(str, this.nbUserId);
            editorEdit.putString(Constants.USER_ID_NET_BANK_KEY, new Gson().toJson(map2));
            editorEdit.apply();
        }
    }

    public void resetActions() {
        OtpHelper otpHelper = this.currentOtpHelper;
        if (otpHelper != null) {
            otpHelper.reset();
            this.currentOtpHelper = null;
        }
        ProceedHelper proceedHelper = this.currentProceedHelper;
        if (proceedHelper != null) {
            proceedHelper.reset();
            this.currentProceedHelper = null;
        }
        RadioHelper radioHelper = this.currentRadioHelper;
        if (radioHelper != null) {
            radioHelper.reset();
            this.currentRadioHelper = null;
        }
        PasswordHelper passwordHelper = this.currentPasswordHelper;
        if (passwordHelper != null) {
            passwordHelper.reset();
            this.currentPasswordHelper = null;
        }
        if (this.currentCustomJsHelper != null) {
            this.currentCustomJsHelper = null;
        }
    }

    public void checkAssistFlow(WebView webView, String str) {
        AppCompatActivity appCompatActivity = this.activity;
        if (appCompatActivity == null || appCompatActivity.isFinishing()) {
            return;
        }
        try {
            String string = this.activity.getSharedPreferences(Constants.EASYPAY_NEW_PREFERENCE_FILE, 0).getString("config", "");
            AssistLogs.printLog("in checkAssistFlow Config json:" + string, this);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            AssistDetailsResponse assistDetailsResponse = (AssistDetailsResponse) new Gson().fromJson(string, AssistDetailsResponse.class);
            this.mDetailsResponse = assistDetailsResponse;
            if (assistDetailsResponse != null) {
                if (assistDetailsResponse.getBank().equalsIgnoreCase(PaytmAssist.getAssistInstance().geTxnBank())) {
                    GAEventManager gAEventManager = this.mAnalyticsManager;
                    if (gAEventManager != null) {
                        gAEventManager.isBankEnabled(this.mDetailsResponse.getEnabled().booleanValue());
                    }
                    if (this.mDetailsResponse.getEnabled().booleanValue()) {
                        this.isAssistNewFlow = true;
                        assistNewFlow(webView, str, this.mDetailsResponse);
                        return;
                    } else {
                        GAEventManager gAEventManager2 = this.mAnalyticsManager;
                        if (gAEventManager2 != null) {
                            gAEventManager2.onOpenPaytmAssistURL(false);
                            return;
                        }
                        return;
                    }
                }
                AssistLogs.printLog("Config JSON picked from cache doesn't have same bank name", this);
                GAEventManager gAEventManager3 = this.mAnalyticsManager;
                if (gAEventManager3 != null) {
                    gAEventManager3.onOpenPaytmAssistURL(false);
                    return;
                }
                return;
            }
            AssistLogs.printLog("imDetail resoinse Null", this);
        } catch (Exception e2) {
            e2.printStackTrace();
            AssistLogs.printLog("EXCEPTION", e2);
        }
    }

    private void assistNewFlow(WebView webView, String str, AssistDetailsResponse assistDetailsResponse) {
        try {
            AssistLogs.printLog("In assistNewFlow():mdetailresponse=" + this.mDetailsResponse.getBank() + ":" + this.mDetailsResponse.getResponse(), this);
            if (this.mDetailsResponse != null) {
                this.opMap = new HashMap<>();
                ArrayList<AssistUrlResponse> response = assistDetailsResponse.getResponse();
                if (!assistDetailsResponse.getPayType().equalsIgnoreCase(Constants.EASYPAY_PAYTYPE_CREDIT_CARD) && !assistDetailsResponse.getPayType().equalsIgnoreCase(Constants.EASYPAY_PAYTYPE_DEBIT_CARD)) {
                    if (Constants.EASYPAY_PAYTYPE_NETBANKING.equalsIgnoreCase(assistDetailsResponse.getPayType())) {
                        loadActions(str, assistDetailsResponse);
                        return;
                    }
                    return;
                }
                SharedPreferences sharedPreferences = this.activity.getSharedPreferences("com.paytm.com.paytm.pgsdk.easypay.appinvoke.PREFERENCE_FILE_KEY", 0);
                this.sharedPref = sharedPreferences;
                this.mAllowEasyPay = sharedPreferences.getBoolean("enableEasyPay", false);
                if (!this.isPaytmAssistOnOffEventSent) {
                    this.isPaytmAssistOnOffEventSent = true;
                }
                for (AssistUrlResponse assistUrlResponse : response) {
                    if (containsBankUrl(assistUrlResponse.getUrl(), str)) {
                        GAEventManager gAEventManager = this.mAnalyticsManager;
                        if (gAEventManager != null) {
                            gAEventManager.assistAcsUrl(str);
                        }
                        ArrayList<Operation> operations = assistUrlResponse.getOperations();
                        if (operations != null && !operations.isEmpty()) {
                            for (Operation operation : operations) {
                                this.opMap.put(operation.getActionType(), operation);
                                AssistLogs.printLog("Operation type: " + operation.getActionType(), this);
                            }
                        }
                    }
                }
                if (this.currentNewOtpHelper == null) {
                    AssistLogs.printLog("making object newotphelper", this);
                    this.currentNewOtpHelper = new NewOtpHelper(this.activity, webView, this, this.mWebViewClient);
                }
                if (this.opMap.size() > 0) {
                    AssistLogs.printLog("Easypay browser fragment:fire do action-Filler from web ", this);
                    this.currentNewOtpHelper.setMap(this.opMap);
                    this.currentNewOtpHelper.doAction(Constants.FILLER_FROM_WEB);
                    return;
                }
                resetActions();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            AssistLogs.printLog("EXCEPTION", e2);
        }
    }

    private void loadActions(String str, AssistDetailsResponse assistDetailsResponse) {
        this.mNbOpMapSearch = new HashMap<>();
        for (AssistUrlResponse assistUrlResponse : assistDetailsResponse.getResponse()) {
            if (str.contains(assistUrlResponse.getUrl())) {
                GAEventManager gAEventManager = this.mAnalyticsManager;
                if (gAEventManager != null) {
                    gAEventManager.assistAcsUrl(str);
                }
                ArrayList<Operation> operations = assistUrlResponse.getOperations();
                if (operations != null && !operations.isEmpty()) {
                    for (Operation operation : operations) {
                        this.mNbOpMapSearch.put(operation.getActionType(), operation);
                    }
                    if (this.mNbOpMapSearch.size() > 0) {
                        this.nbHelper.startNbFeatures(this.mNbOpMapSearch, this.mDetailsResponse);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private boolean containsBankUrl(String str, String str2) {
        return str2.contains(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00e6, code lost:
    
        r20 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00eb, code lost:
    
        r20 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f9, code lost:
    
        r20 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0107, code lost:
    
        r20 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0114, code lost:
    
        r20 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0122, code lost:
    
        r20 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x012f, code lost:
    
        r20 = r6;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03c1 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e8 A[PHI: r20
      0x00e8: PHI (r20v12 java.lang.String) = 
      (r20v5 java.lang.String)
      (r20v6 java.lang.String)
      (r20v7 java.lang.String)
      (r20v8 java.lang.String)
      (r20v9 java.lang.String)
      (r20v10 java.lang.String)
      (r20v13 java.lang.String)
     binds: [B:59:0x0137, B:55:0x012a, B:51:0x011c, B:47:0x010f, B:43:0x0101, B:39:0x00f3, B:36:0x00e6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x020b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void doActions(android.webkit.WebView r23, java.lang.String r24, java.lang.String r25) {
        /*
            Method dump skipped, instruction units count: 1096
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: easypay.appinvoke.actions.EasypayBrowserFragment.doActions(android.webkit.WebView, java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadConfiguration() {
        try {
            ArrayList<Map<String, String>> jsonStream = readJsonStream("config");
            if (jsonStream == null || jsonStream.get(0) == null || jsonStream.get(0).get("ttl") == null) {
                return;
            }
            long j = Long.parseLong(jsonStream.get(0).get("ttl"));
            SharedPreferences.Editor editorEdit = this.activity.getSharedPreferences("com.paytm.com.paytm.pgsdk.easypay.appinvoke.PREFERENCE_FILE_KEY", 0).edit();
            this.sharedPrefEditor = editorEdit;
            editorEdit.putLong("easypay_configuration_ttl", j);
            this.sharedPrefEditor.apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadConfigurationFromSharedPrefs() {
        try {
            AssistDetailsResponse assistDetailsResponse = (AssistDetailsResponse) new Gson().fromJson(this.activity.getSharedPreferences(Constants.EASYPAY_NEW_PREFERENCE_FILE, 0).getString("config", ""), AssistDetailsResponse.class);
            this.mDetailsResponse = assistDetailsResponse;
            if (assistDetailsResponse != null) {
                Iterator<AssistUrlResponse> it = assistDetailsResponse.getResponse().iterator();
                while (it.hasNext()) {
                    if (containsBankUrl(it.next().getUrl(), this.browser.getUrl())) {
                        WebView webView = this.browser;
                        checkAssistFlow(webView, webView.getUrl());
                        return;
                    }
                }
            }
        } catch (Exception e2) {
            AssistLogs.printLog("EXCEPTION", e2);
        }
    }

    @JavascriptInterface
    public void sendBnkDtlToApp(String str) {
        HashMap map = (HashMap) new Gson().fromJson(str, new TypeToken<HashMap<String, String>>() { // from class: easypay.appinvoke.actions.EasypayBrowserFragment.6
        }.getType());
        Intent intent = new Intent(this.activity, (Class<?>) EasyPayConfigDownloader.class);
        intent.putExtra(Constants.EXTRA_BANK_REQ_JSON, str);
        EasyPayConfigDownloader.enqueueWork(this.activity.getBaseContext(), intent);
        String str2 = map.get(Constants.EXTRA_BANK_CODE) + "-" + map.get(Constants.EXTRA_BANK_PAYTYPE);
        PaytmAssist.getAssistInstance().setTxnBank(map.get(Constants.EXTRA_BANK_CODE).toString());
        PaytmAssist.getAssistInstance().setTxnPayType(map.get(Constants.EXTRA_BANK_PAYTYPE).toString().toLowerCase());
        String lowerCase = str2.toLowerCase();
        GAEventManager gAEventManager = this.mAnalyticsManager;
        if (gAEventManager != null) {
            gAEventManager.cardType(lowerCase);
            this.mAnalyticsManager.cardIssuer(lowerCase);
            if (lowerCase.contains("atm") || lowerCase.contains("idebit") || lowerCase.contains(Constants.EASYPAY_PAYTYPE_ATM) || lowerCase.contains("Idebit")) {
                this.mAnalyticsManager.onNonOTPRequest(true);
            }
        }
    }

    @JavascriptInterface
    public void NbWatcher(String str, String str2) {
        Map<String, String> map;
        if (str == null || str2 == null || (map = this.jsonActionMap) == null || map.get("passwordId") == null || this.jsonActionMap.get("url") == null || this.jsonActionMap.get("userId") == null || this.jsonActionMap.isEmpty()) {
            return;
        }
        try {
            this.isNbOtpFired = false;
            StringBuilder sb = this.pwdBuilder;
            sb.delete(0, sb.length());
            if (!str.equals("101") && !str.equals("1") && !str.equals("110")) {
                if (!str2.equals(this.jsonActionMap.get("userId"))) {
                    if (str2.equals(this.jsonActionMap.get("passwordId"))) {
                        this.pwdBuilder.append(str);
                        passwordViewer(str, 1);
                        return;
                    }
                    return;
                }
                this.nbUserId = str;
                passwordViewer(this.pwdBuilder.toString(), 0);
                return;
            }
            if (str.equals("1") && str2.equals("2")) {
                this.isNbOtpFired = true;
                saveCustId(this.isSavePointer);
                doActions(this.browser, this.jsonActionMap.get("url"), "nbotphelper");
                this.isNbOtpFired = false;
                return;
            }
            if (str.equals("1") && str2.equals("3")) {
                sendEvent("confirmhelper", "", "");
                saveCustId(this.isSavePointer);
                return;
            }
            if (str.equals("101")) {
                if (!str2.equals(this.jsonActionMap.get("userId"))) {
                    if (str2.equals(this.jsonActionMap.get("passwordId"))) {
                        passwordViewer("", 1);
                        return;
                    }
                    return;
                }
                passwordViewer(this.pwdBuilder.toString(), 0);
                return;
            }
            if (str.equals("110")) {
                if (str2.equals("0")) {
                    this.activity.runOnUiThread(new Runnable() { // from class: easypay.appinvoke.actions.EasypayBrowserFragment.7
                        @Override // java.lang.Runnable
                        public void run() {
                            EasypayBrowserFragment.this.passwordViewer("", 3);
                        }
                    });
                } else if (str2.equals("1")) {
                    this.activity.runOnUiThread(new Runnable() { // from class: easypay.appinvoke.actions.EasypayBrowserFragment.8
                        @Override // java.lang.Runnable
                        public void run() {
                            EasypayBrowserFragment.this.passwordViewer("", 4);
                        }
                    });
                }
            }
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        }
    }

    void passwordViewer(final String str, final int i) {
        this.activity.runOnUiThread(new Runnable() { // from class: easypay.appinvoke.actions.EasypayBrowserFragment.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    int i2 = i;
                    if (i2 == 1) {
                        EasypayBrowserFragment.this.netBankingLoginLayout.setVisibility(0);
                        if (EasypayBrowserFragment.this.mNbUserName.getVisibility() == 0) {
                            EasypayBrowserFragment.this.mNbUserName.setVisibility(8);
                            EasypayBrowserFragment easypayBrowserFragment = EasypayBrowserFragment.this;
                            easypayBrowserFragment.mEtCurrentText = easypayBrowserFragment.mNBUserId.getText().toString();
                        }
                        EasypayBrowserFragment.this.mNbPwd.setVisibility(0);
                        EasypayBrowserFragment.this.mNbImagePrevious.setVisibility(0);
                        EasypayBrowserFragment.this.mNbImageNext.setVisibility(8);
                        EasypayBrowserFragment.this.mNBUserId.setVisibility(8);
                        EasypayBrowserFragment.this.ll_historic_id.setVisibility(8);
                        if (EasypayBrowserFragment.this.mNbButton.getVisibility() != 0) {
                            EasypayBrowserFragment.this.mNbButton.setVisibility(0);
                        }
                        EasypayBrowserFragment.this.nbPwdViewer.setVisibility(0);
                        if (str == null) {
                            return;
                        }
                        EasypayBrowserFragment.this.mNbPwd.setText(str);
                        return;
                    }
                    if (i2 == 0) {
                        if (EasypayBrowserFragment.this.mNbPwd.getVisibility() == 0 || EasypayBrowserFragment.this.mNbPwd.getVisibility() == 4) {
                            EasypayBrowserFragment.this.mNbPwd.setVisibility(8);
                        }
                        if (EasypayBrowserFragment.this.nbPwdViewer.getVisibility() == 0 || EasypayBrowserFragment.this.nbPwdViewer.getVisibility() == 4) {
                            EasypayBrowserFragment.this.nbPwdViewer.setVisibility(8);
                        }
                        if (EasypayBrowserFragment.this.mNbUserName.getVisibility() == 0 || EasypayBrowserFragment.this.mNbUserName.getVisibility() == 4) {
                            EasypayBrowserFragment.this.mNbUserName.setVisibility(8);
                        }
                        if (EasypayBrowserFragment.this.mNbButton.getVisibility() == 0 || EasypayBrowserFragment.this.mNbButton.getVisibility() == 4) {
                            EasypayBrowserFragment.this.mNbButton.setVisibility(8);
                            return;
                        }
                        return;
                    }
                    if (i2 == 3) {
                        if (EasypayBrowserFragment.this.netBankingLoginLayout == null || EasypayBrowserFragment.this.mNbPwd == null) {
                            return;
                        }
                        EasypayBrowserFragment.this.mNbPwd.setText("");
                        return;
                    }
                    if (i2 == 4) {
                        if (EasypayBrowserFragment.this.netBankingLoginLayout != null) {
                            EasypayBrowserFragment.this.netBankingLoginLayout.setVisibility(0);
                        }
                    } else {
                        if (i2 != 5 || EasypayBrowserFragment.this.netBankingLoginLayout == null) {
                            return;
                        }
                        EasypayBrowserFragment.this.netBankingLoginLayout.setVisibility(8);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    AssistLogs.printLog("EXCEPTION", e2);
                }
            }
        });
    }

    @JavascriptInterface
    public void showLog(String str) {
        if (str.equals("not found -Net Banking js Injection")) {
            passwordViewer("", 0);
        } else {
            if (!str.equals("not found - 0") || TextUtils.isEmpty(PaytmAssist.getAssistInstance().getLastLoadedUrl())) {
                return;
            }
            doActions(this.browser, PaytmAssist.getAssistInstance().getLastLoadedUrl(), "");
        }
    }

    @JavascriptInterface
    public void logEvent(String str, String str2) {
        String str3 = str2 + "_" + str;
        int i = this.sharedPrefForEvents.getInt(str3, 0);
        SharedPreferences.Editor editorEdit = this.sharedPrefForEvents.edit();
        editorEdit.putInt(str3, i + 1);
        editorEdit.apply();
    }

    @JavascriptInterface
    public void sendEvent(String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setAction("com.paytm.com.paytm.pgsdk.easypay.appinvoke.CUSTOM_EVENT");
        intent.putExtra("eventName", str);
        intent.putExtra("data0", str2);
        intent.putExtra("data1", str3);
        this.activity.sendBroadcast(intent);
    }

    void toggleView(int i, Boolean bool) {
        try {
            View viewFindViewById = this.activity.findViewById(i);
            View viewFindViewById2 = this.activity.findViewById(R.id.parentPanel);
            int i2 = bool.booleanValue() ? 0 : 8;
            viewFindViewById2.setVisibility(i2);
            if (bool.booleanValue() && i == R.id.otpHelper) {
                GAEventManager gAEventManager = this.mAnalyticsManager;
                if (gAEventManager != null) {
                    gAEventManager.onOpenPaytmAssistURL(true);
                }
                viewFindViewById.setVisibility(i2);
                this.isAssistVisible = true;
                return;
            }
            if (!bool.booleanValue() && i == R.id.otpHelper) {
                GAEventManager gAEventManager2 = this.mAnalyticsManager;
                if (gAEventManager2 != null) {
                    gAEventManager2.onOpenPaytmAssistURL(false);
                }
                viewFindViewById.setVisibility(i2);
                return;
            }
            if (i == R.id.layout_netbanking && bool.booleanValue()) {
                PaytmAssist.getAssistInstance().getmEventMap().put("showPasswordClicked", Boolean.valueOf(this.isShow));
                GAEventManager gAEventManager3 = this.mAnalyticsManager;
                if (gAEventManager3 != null) {
                    gAEventManager3.isNetBankingInvoked(true);
                    this.mAnalyticsManager.onOpenPaytmAssistURL(true);
                }
                this.parentPanel.setBackgroundColor(0);
                ((RelativeLayout) viewFindViewById.findViewById(i)).setVisibility(0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            AssistLogs.printLog("EXCEPTION", e2);
        }
    }

    void hideNBPasswordShowCustIdView() {
        this.netBankingLoginLayout.setVisibility(0);
        this.mNbPwd.setVisibility(8);
        this.mNbImagePrevious.setVisibility(8);
        this.nbPwdViewer.setVisibility(8);
        this.mNbButton.setVisibility(8);
        this.mNbImageNext.setVisibility(0);
        this.mNbUserName.setVisibility(0);
        setUIDCheck(this.isSaveIdChecked);
        this.mNBUserId.setVisibility(0);
        if (this.mShowSuggestionBox) {
            this.ll_historic_id.setVisibility(0);
        } else {
            this.ll_historic_id.setVisibility(8);
        }
    }

    void hideNBCustIdShowPassword() {
        this.mNbPwd.setVisibility(0);
        this.mNbImagePrevious.setVisibility(0);
        this.nbPwdViewer.setVisibility(0);
        this.mNbButton.setVisibility(0);
        this.mNbImageNext.setVisibility(8);
        this.mNbUserName.setVisibility(8);
        this.isSaveIdChecked = this.mNbUserName.isChecked();
        this.mEtCurrentText = this.mNBUserId.getText().toString();
        this.mNBUserId.setVisibility(8);
        this.ll_historic_id.setVisibility(8);
    }

    void setUIdToTextView(String str) {
        this.mNBUserId.setText(str);
    }

    void setUIDCheck(boolean z) {
        this.mNbUserName.setChecked(z);
    }

    private ArrayList<Map<String, String>> getActions(String str) {
        ArrayList<Map<String, String>> arrayList = new ArrayList<>();
        try {
            this.mAllowEasyPay = this.sharedPref.getBoolean("enableEasyPay", false);
            return arrayList;
        } catch (Exception e2) {
            e2.printStackTrace();
            AssistLogs.printLog("EXCEPTION", e2);
            return arrayList;
        }
    }

    private ArrayList<Map<String, String>> readJsonStream(String str) throws Exception {
        try {
            File fileStreamPath = this.activity.getFileStreamPath("easypay_configuration.json");
            if (fileStreamPath != null && fileStreamPath.exists()) {
                this.in = this.activity.getApplicationContext().openFileInput("easypay_configuration.json");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        JsonReader jsonReader = new JsonReader(new InputStreamReader(this.in, StandardCharsets.UTF_8));
        try {
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    if (jsonReader.nextName().equals(str)) {
                        return readJSONArray(jsonReader);
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
                return readJSONArray(jsonReader);
            } catch (Exception e3) {
                e3.printStackTrace();
                jsonReader.close();
                return null;
            }
        } finally {
            jsonReader.close();
        }
    }

    private ArrayList<Map<String, String>> readJSONArray(JsonReader jsonReader) throws IOException {
        ArrayList<Map<String, String>> arrayList = new ArrayList<>();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(readObject(jsonReader));
        }
        return arrayList;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        PaytmAssist.getAssistInstance().setFragmentResumed(true);
        PaytmAssist.getAssistInstance().setFragmentPaused(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        PaytmAssist.getAssistInstance().setFragmentResumed(false);
        PaytmAssist.getAssistInstance().setFragmentPaused(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        otpSubmitButtonState();
    }

    private Map<String, String> readObject(JsonReader jsonReader) throws IOException {
        HashMap map = new HashMap();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            map.put(jsonReader.nextName(), jsonReader.nextString());
        }
        jsonReader.endObject();
        return map;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        EditText editText = this.mNBUserId;
        if (editText != null) {
            editText.removeTextChangedListener(this.mNbUserIdWatcher);
        }
        super.onDestroy();
    }

    @Override // easypay.appinvoke.listeners.WebClientListener
    public void OnWcPageFinish(WebView webView, String str) {
        this.timeFinish = Long.valueOf(System.currentTimeMillis());
        StringBuilder sb = this.redirectUrl;
        if (sb != null) {
            sb.append(str);
            this.redirectUrl.append("|");
        }
        loadConfigurationFromSharedPrefs();
    }

    @Override // easypay.appinvoke.listeners.WebClientListener
    public void OnWcPageStart(WebView webView, String str, Bitmap bitmap) {
        this.timeStart = Long.valueOf(System.currentTimeMillis());
        AssistLogs.printLog("Start Called :" + this.timeStart, this);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        CheckBox checkBox;
        this.isSaveIdChecked = z;
        if (z && (checkBox = this.mNbUserName) != null) {
            checkBox.setButtonDrawable(R.drawable.ic_checkbox_selected);
            this.isSavePointer = true;
            SharedPreferences.Editor editorEdit = this.activity.getSharedPreferences(Constants.BANKPREF, 0).edit();
            this.sharedPrefEditor = editorEdit;
            editorEdit.putString(Constants.USER_ID_NET_BANK_KEY, "abcd");
            this.sharedPrefEditor.apply();
            PaytmAssist.getAssistInstance().getmEventMap().put("rememberUserId", "Checked");
            return;
        }
        CheckBox checkBox2 = this.mNbUserName;
        if (checkBox2 != null) {
            checkBox2.setButtonDrawable(R.drawable.ic_checkbox_unselected);
            this.isSavePointer = false;
        }
        PaytmAssist.getAssistInstance().getmEventMap().put("rememberUserId", "UnChecked");
    }

    void onHelperAction(int i, Object obj) {
        if (isAdded() && i == 155) {
            this.currentNewOtpHelper = new NewOtpHelper(this.activity, this.browser, PaytmAssist.getAssistInstance().getFragment(), this.mWebViewClient);
            if (this.mNbOpMapSearch.size() > 0) {
                this.currentNewOtpHelper.setMap(this.mNbOpMapSearch);
                AssistLogs.printLog("NB OTP Flow Started" + obj, this);
                this.mEasyPayHelper.successEvent(107, "");
            }
        }
    }

    public NewOtpHelper getCurrentNewOtpHelper() {
        return this.currentNewOtpHelper;
    }

    void setDetectionStatusText(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mTvOtpLabel.setText(str);
    }

    void removeAssist() {
        RelativeLayout relativeLayout = this.parentPanel;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    public void minimizeAssist() {
        ImageView imageView = this.mHideButton;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        minimizeAssistView();
    }

    void maximizeAssist() {
        ImageView imageView = this.mShowAssist;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        showAssistView();
    }

    void toggleHistoricIds(int i, boolean z) {
        if (z) {
            this.ll_historic_id.setVisibility(0);
            for (int i2 = 0; i2 < 3; i2++) {
                if (i2 < i) {
                    if (this.historicTvArray[i2].getText().equals(this.mCurrentUserId)) {
                        this.historicTvArray[i2].setVisibility(8);
                    } else {
                        this.historicTvArray[i2].setVisibility(0);
                    }
                } else {
                    this.historicTvArray[i2].setVisibility(8);
                }
            }
            return;
        }
        this.ll_historic_id.setVisibility(8);
        for (int i3 = 0; i3 < i; i3++) {
            this.historicTvArray[i3].setVisibility(8);
        }
    }

    void setHistoricIdTexts(ArrayList<String> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            this.historicTvArray[(r0 - size) - 1].setText(arrayList.get(size));
            AssistLogs.printLog("" + arrayList.get(size) + " USER ID", this);
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [easypay.appinvoke.actions.EasypayBrowserFragment$10] */
    void setOtpDetectedTimer(boolean z) {
        Exception exc;
        final String string = getString(R.string.submit_time);
        AssistLogs.printLog("Timer called", this);
        try {
            CountDownTimer countDownTimer = this.timer;
            if (countDownTimer != null) {
                try {
                    countDownTimer.cancel();
                } catch (Exception e2) {
                    exc = e2;
                }
            }
            try {
                if (!z) {
                    enableAutosubmitUI();
                    this.timer = new CountDownTimer(8000L, 1000L) { // from class: easypay.appinvoke.actions.EasypayBrowserFragment.10
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            String str;
                            long j2 = j / 1000;
                            if (j2 > 1) {
                                str = string + " " + j2 + " seconds";
                            } else if (j2 == 1) {
                                str = string + " " + j2 + " second";
                            } else {
                                onFinish();
                                str = "";
                            }
                            EasypayBrowserFragment.this.mOtpTimer.setText(str);
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            EasypayBrowserFragment.this.startSubmission();
                            if (EasypayBrowserFragment.this.mAnalyticsManager != null) {
                                EasypayBrowserFragment.this.mAnalyticsManager.isAutoSubmit(true);
                                EasypayBrowserFragment.this.mAnalyticsManager.onOTPManuallyEntered(false);
                                EasypayBrowserFragment.this.mAnalyticsManager.isSubmitButtonClicked(false, 0);
                                EasypayBrowserFragment.this.mAnalyticsManager.isPauseButtonTapped(false);
                            }
                        }
                    }.start();
                    return;
                } else {
                    disableAutoSubmitUI();
                    return;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Exception e4) {
            e = e4;
        }
        exc = e;
        exc.printStackTrace();
        AssistLogs.printLog("EXCEPTION", exc);
    }

    private void disableAutoSubmitUI() {
        this.mTvTapToPause.setVisibility(8);
        this.mOtpTimer.setVisibility(8);
    }

    private void enableAutosubmitUI() {
        this.mTvTapToPause.setVisibility(0);
        this.mOtpTimer.setVisibility(0);
    }

    void otpSubmitButtonState() {
        this.mTvTapToPause.setVisibility(8);
        this.mOtpTimer.setVisibility(8);
    }

    void toggleSuggestionBox(boolean z) {
        this.mShowSuggestionBox = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleSavedUserIdTextView(boolean z, String str) {
        if (str == null) {
            str = this.mCurrentUserId;
        }
        int numberOfSavedId = this.nbHelper.getNumberOfSavedId();
        if (numberOfSavedId == 1) {
            if (z) {
                this.ll_historic_id.setVisibility(0);
                this.historicTvArray[0].setVisibility(0);
                this.historicTvArray[0].setText(this.mCurrentUserId);
            } else {
                this.ll_historic_id.setVisibility(8);
                this.historicTvArray[0].setVisibility(8);
            }
        } else if (numberOfSavedId > 1) {
            for (int i = 0; i < numberOfSavedId; i++) {
                if (this.historicTvArray[i].getText().equals(str)) {
                    this.historicTvArray[i].setVisibility(8);
                } else if (!this.historicTvArray[i].getText().equals("")) {
                    this.historicTvArray[i].setVisibility(0);
                }
            }
        }
        setUIDCheck(z);
    }

    void clearOtpFields() {
        this.mInputPassCode.setText("");
        setDetectionStatusText(this.activity.getString(R.string.waiting_for_otp_label, new Object[]{PaytmAssist.getAssistInstance().geTxnBank()}));
    }
}
