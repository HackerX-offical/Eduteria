package com.easebuzz.payment.kit;

import adapters.PWEUpiIntentsAdapter;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.Html;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import clientRequestsApi.RetroAPI;
import com.amazonaws.services.s3.internal.Constants;
import com.appnew.android.Utils.Const;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import datamodels.PWEStaticDataModel;
import datamodels.PWEUPIOptionsDataModel;
import helper.ToStringConverterFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import listeners.KeyBoardListener;
import listeners.PWEUpiOptionListener;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.mozilla.classfile.ByteCode;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: classes7.dex */
public class PWEUpiFragment extends Fragment {
    private static int CANCEL_UPI_EXCEPT_COUNT_1 = 0;
    private static int CANCEL_UPI_EXCEPT_COUNT_2 = 0;
    private static int CANCEL_UPI_SERVER_ERROR_COUNT = 0;
    private static int TXN_CHECK_STATUS_EXCEPT_COUNT_1 = 0;
    private static int TXN_CHECK_STATUS_SERVER_COUNT_ERROR = 0;
    private static String selected_upi_payment_option = "";
    Activity activity;
    private Button btn_cancel_upi_request;
    private Button buttonPayUpi;
    private Map checkStatusParametersJsonObj;
    private TimerTask checkStatusTask;
    private PWECouponsActivity couponsActivity;
    private PWEDiscountHelper discountCodeHelper;
    private EditText edUpiAutodebitUsername;
    private EditText etUPIAddress;
    private PWEGeneralHelper generalHelper;
    private ExpandableHeightGridView gridUPIOptions;
    private PWEUpiIntentsAdapter intentUpiOptionAdapter;
    private ImageView ivSendRequest;
    public ImageView ivUPIQr;
    public KeyBoardListener keyBoardListener;
    LinearLayout linearNormalUPINoteHolder;
    private LinearLayout linearQrCodeHolder;
    LinearLayout linearScanQrHolder;
    private LinearLayout linearUPIIntentsHolder;
    private LinearLayout linearUpiAddressHolder;
    private LinearLayout linearUpiAutodebitAddHolder;
    private PWEPaymentInfoHandler paymentInfoHandler;
    public ProgressBar progressGeneratingQr;
    private ProgressBar progressUpiLoader;
    private Map submitInitiateParametersJsonObj;
    private TextView textUpiTypeLabel;
    private TextView tvPayUsingNote;
    private TextView tvPayUsingTitle;
    private TextView tvPayUsingUpiIdNote;
    private TextView tvPayUsingUpiIdTitle;
    private TextView tvUpiAddressAutodebitError;
    private TextView tvUpiAddressError;
    private TextView tvUpiLimitNoteMessage;
    private TextView tv_upi_req_text;
    public Dialog upiBottomSheetDialog;
    public Intent upiChooser;
    private View upiView;
    private ArrayList<PWEUPIOptionsDataModel> upi_options_list;
    private String EndPointUrl = "";
    private String upiVA = "";
    private String selectedUpiUsername = "";
    private String upi_request_message = "";
    private String selectedIntentUpiKey = "";
    private String selectedIntentUpiPkg = "";
    public String pwe_qr_link = "";
    private boolean openPaymentOption = true;
    private boolean isDeeplinkFlowCompleted = false;
    private boolean allowCancel = false;
    private boolean is_selected_upi_qr = false;
    private boolean is_check_status_timer_started = false;
    private boolean isCancellingUPIRequest = false;
    private final Handler checkStatusHandler = new Handler();
    private Timer checkStatusTimer = new Timer();
    private int selectedUpiPosition = -1;
    private String selectedUpiType = "";
    private boolean initialUPISelectionFlag = false;
    private int PWE_DEEPLINK_REQUEST_CODE = 4400;
    private String selected_payment_option = "";
    private ActivityResultLauncher<Intent> pweUpiResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: com.easebuzz.payment.kit.PWEUpiFragment.1
        @Override // androidx.activity.result.ActivityResultCallback
        public void onActivityResult(ActivityResult activityResult) {
            PWEUpiFragment.this.isDeeplinkFlowCompleted = true;
        }
    });

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.activity = getActivity();
        this.paymentInfoHandler = new PWEPaymentInfoHandler(getActivity());
        this.generalHelper = new PWEGeneralHelper(getActivity());
        Activity activity = this.activity;
        if (activity instanceof PWECouponsActivity) {
            this.couponsActivity = (PWECouponsActivity) activity;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.upiView = layoutInflater.inflate(R.layout.fragment_pwe_upi, viewGroup, false);
        FragmentActivity activity = getActivity();
        if (activity instanceof PWECouponsActivity) {
            this.couponsActivity = (PWECouponsActivity) activity;
        }
        this.selectedIntentUpiPkg = "";
        this.selectedIntentUpiKey = "";
        this.discountCodeHelper = this.couponsActivity.getDiscountHelper();
        this.initialUPISelectionFlag = false;
        this.selectedUpiType = "";
        CANCEL_UPI_EXCEPT_COUNT_1 = 0;
        this.is_selected_upi_qr = false;
        this.is_check_status_timer_started = false;
        this.openPaymentOption = true;
        this.isDeeplinkFlowCompleted = false;
        PWEStaticHelper.PWE_CURRENT_TRXN_STATUS = this.paymentInfoHandler.getPweLastTransactionStatus();
        this.allowCancel = false;
        this.EndPointUrl = this.generalHelper.getAPIBaseURL();
        this.selected_payment_option = this.paymentInfoHandler.getSelectedPaymentOption();
        initViews();
        if (this.selected_payment_option.equals(PWEStaticDataModel.PAYOPT_UPI_NAME)) {
            prepareUpiOptions();
            initializeUpiOptionAdapter();
            if (!this.paymentInfoHandler.getPayUpiQrVisibilityFlag()) {
                this.linearQrCodeHolder.setVisibility(8);
            }
        }
        if (PWEStaticDataModel.IS_APP_REINITIALIZED) {
            resumeUpiPayment("COMPLETE_RESUME");
        } else {
            resumeUpiPayment("PARTIAL_RESUME");
        }
        selectionUpiOption();
        return this.upiView;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00fb A[Catch: JSONException | Exception -> 0x0122, TryCatch #1 {JSONException | Exception -> 0x0122, blocks: (B:27:0x00f4, B:29:0x0119, B:28:0x00fb, B:31:0x011d), top: B:38:0x00d9 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void resumeUpiPayment(java.lang.String r13) {
        /*
            Method dump skipped, instruction units count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easebuzz.payment.kit.PWEUpiFragment.resumeUpiPayment(java.lang.String):void");
    }

    private void initViews() {
        this.gridUPIOptions = (ExpandableHeightGridView) this.upiView.findViewById(R.id.grid_upi_options);
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            this.gridUPIOptions.setSelector(getResources().getDrawable(R.drawable.pwe_gridview_item_selector));
        }
        this.textUpiTypeLabel = (TextView) this.upiView.findViewById(R.id.text_card_type_label);
        this.tvUpiAddressError = (TextView) this.upiView.findViewById(R.id.text_upi_address_error);
        this.etUPIAddress = (EditText) this.upiView.findViewById(R.id.edit_upi_username);
        this.tvPayUsingTitle = (TextView) this.upiView.findViewById(R.id.text_pay_using_title);
        this.tvPayUsingNote = (TextView) this.upiView.findViewById(R.id.text_pay_using_note);
        this.tvPayUsingUpiIdTitle = (TextView) this.upiView.findViewById(R.id.text_pay_using_upi_id_title);
        this.tvPayUsingUpiIdNote = (TextView) this.upiView.findViewById(R.id.text_pay_using_upiId_note);
        this.linearUpiAddressHolder = (LinearLayout) this.upiView.findViewById(R.id.linear_upi_address_holder);
        this.linearUPIIntentsHolder = (LinearLayout) this.upiView.findViewById(R.id.linear_upi_intents_holder);
        this.linearQrCodeHolder = (LinearLayout) this.upiView.findViewById(R.id.linear_upi_qr_holder);
        this.linearUpiAutodebitAddHolder = (LinearLayout) this.upiView.findViewById(R.id.linear_upi_autodebit_address_holder);
        this.tvUpiAddressAutodebitError = (TextView) this.upiView.findViewById(R.id.text_upi_address_autodebit_error);
        this.edUpiAutodebitUsername = (EditText) this.upiView.findViewById(R.id.edit_upi_autodebit_username);
        this.linearUPIIntentsHolder.setVisibility(8);
        if (this.selected_payment_option.equals(PWEStaticDataModel.UPI_AUTODEBIT_NAME)) {
            this.linearUPIIntentsHolder.setVisibility(8);
            this.linearQrCodeHolder.setVisibility(8);
            this.linearUpiAddressHolder.setVisibility(8);
            this.linearUpiAutodebitAddHolder.setVisibility(0);
            this.textUpiTypeLabel.setText(PWEStaticDataModel.UPI_AUTODEBIT_DISPLAY_NAME);
        } else {
            this.textUpiTypeLabel.setText(PWEStaticDataModel.PAYOPT_UPI_DISPLAY_NAME);
            this.linearUpiAutodebitAddHolder.setVisibility(8);
        }
        this.etUPIAddress.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.easebuzz.payment.kit.PWEUpiFragment.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!PWEUpiFragment.this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
                    if (!z || PWEUpiFragment.this.initialUPISelectionFlag) {
                        return;
                    }
                    PWEUpiFragment.this.selectedUpiType = "UPI_ID";
                    PWEUpiFragment.this.updateSelectedView(false, true, false, false, true);
                    return;
                }
                if (z) {
                    PWEUpiFragment.this.linearUpiAddressHolder.setBackground(PWEUpiFragment.this.getResources().getDrawable(R.drawable.pwe_android_tv_image_edit_text));
                } else if (PWEUpiFragment.this.selectedUpiType.equals("UPI_ID")) {
                    PWEUpiFragment.this.linearUpiAddressHolder.setBackground(PWEUpiFragment.this.getResources().getDrawable(R.drawable.pwe_selected_item_background));
                } else {
                    PWEUpiFragment.this.linearUpiAddressHolder.setBackground(PWEUpiFragment.this.getResources().getDrawable(R.drawable.pwe_custom_card_background));
                }
            }
        });
        this.edUpiAutodebitUsername.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.easebuzz.payment.kit.PWEUpiFragment.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                try {
                    if (!PWEUpiFragment.this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
                        if (!z || PWEUpiFragment.this.initialUPISelectionFlag) {
                            return;
                        }
                        PWEUpiFragment.this.selectedUpiType = "UPI_ID";
                        return;
                    }
                    if (z) {
                        PWEUpiFragment.this.linearUpiAutodebitAddHolder.setBackground(PWEUpiFragment.this.getResources().getDrawable(R.drawable.pwe_android_tv_image_edit_text));
                    } else if (PWEUpiFragment.this.selectedUpiType.equals("UPI_ID")) {
                        PWEUpiFragment.this.linearUpiAutodebitAddHolder.setBackground(PWEUpiFragment.this.getResources().getDrawable(R.drawable.pwe_selected_item_background));
                    } else {
                        PWEUpiFragment.this.linearUpiAutodebitAddHolder.setBackground(PWEUpiFragment.this.getResources().getDrawable(R.drawable.pwe_custom_card_background));
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
        this.linearUpiAddressHolder.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.easebuzz.payment.kit.PWEUpiFragment.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (PWEUpiFragment.this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
                    if (z) {
                        PWEUpiFragment.this.linearUpiAddressHolder.setBackground(PWEUpiFragment.this.getResources().getDrawable(R.drawable.pwe_android_tv_image_edit_text));
                    } else if (PWEUpiFragment.this.selectedUpiType.equals("UPI_ID")) {
                        PWEUpiFragment.this.linearUpiAddressHolder.setBackground(PWEUpiFragment.this.getResources().getDrawable(R.drawable.pwe_selected_item_background));
                    } else {
                        PWEUpiFragment.this.linearUpiAddressHolder.setBackground(PWEUpiFragment.this.getResources().getDrawable(R.drawable.pwe_custom_card_background));
                    }
                }
            }
        });
        this.linearUpiAutodebitAddHolder.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.easebuzz.payment.kit.PWEUpiFragment.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (PWEUpiFragment.this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
                    if (z) {
                        PWEUpiFragment.this.linearUpiAutodebitAddHolder.setBackground(PWEUpiFragment.this.getResources().getDrawable(R.drawable.pwe_android_tv_image_edit_text));
                    } else if (PWEUpiFragment.this.selectedUpiType.equals("UPI_ID")) {
                        PWEUpiFragment.this.linearUpiAutodebitAddHolder.setBackground(PWEUpiFragment.this.getResources().getDrawable(R.drawable.pwe_selected_item_background));
                    } else {
                        PWEUpiFragment.this.linearUpiAutodebitAddHolder.setBackground(PWEUpiFragment.this.getResources().getDrawable(R.drawable.pwe_custom_card_background));
                    }
                }
            }
        });
        this.linearQrCodeHolder.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.easebuzz.payment.kit.PWEUpiFragment.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (PWEUpiFragment.this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
                    if (z) {
                        PWEUpiFragment.this.linearQrCodeHolder.setBackground(PWEUpiFragment.this.getResources().getDrawable(R.drawable.pwe_android_tv_image_edit_text));
                    } else if (PWEUpiFragment.this.selectedUpiType.equals("UPI_QR")) {
                        PWEUpiFragment.this.linearQrCodeHolder.setBackground(PWEUpiFragment.this.getResources().getDrawable(R.drawable.pwe_selected_item_background));
                    } else {
                        PWEUpiFragment.this.linearQrCodeHolder.setBackground(PWEUpiFragment.this.getResources().getDrawable(R.drawable.pwe_custom_card_background));
                    }
                }
            }
        });
        this.keyBoardListener = new KeyBoardListener();
        this.buttonPayUpi = (Button) this.upiView.findViewById(R.id.button_proceed_for_payment);
        this.tvUpiLimitNoteMessage = (TextView) this.upiView.findViewById(R.id.text_note_message);
        if (this.selected_payment_option.equals(PWEStaticDataModel.PAYOPT_UPI_NAME)) {
            if (this.paymentInfoHandler.getUpiLimitNoteMessage().equals(Constants.NULL_VERSION_ID) || this.paymentInfoHandler.getUpiLimitNoteMessage().equals("")) {
                this.tvUpiLimitNoteMessage.setVisibility(8);
            } else {
                this.tvUpiLimitNoteMessage.setVisibility(0);
                this.tvUpiLimitNoteMessage.setText(Html.fromHtml(this.paymentInfoHandler.getUpiLimitNoteMessage()));
            }
        } else if (this.paymentInfoHandler.getAutodebitUpiNoteMessage().equals(Constants.NULL_VERSION_ID) || this.paymentInfoHandler.getAutodebitUpiNoteMessage().equals("")) {
            this.tvUpiLimitNoteMessage.setVisibility(8);
        } else {
            this.tvUpiLimitNoteMessage.setVisibility(0);
            this.tvUpiLimitNoteMessage.setText(Html.fromHtml(this.paymentInfoHandler.getAutodebitUpiNoteMessage()));
        }
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            this.buttonPayUpi.setBackground(getActivity().getResources().getDrawable(R.drawable.pwe_android_tv_button));
            this.generalHelper.changeButtonWidth(this.buttonPayUpi);
            this.etUPIAddress.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
        }
        this.buttonPayUpi.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWEUpiFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean zValidateAllFields;
                PWEUpiFragment.this.keyBoardListener.hideKeyboard(PWEUpiFragment.this.getActivity());
                if (PWEUpiFragment.this.selected_payment_option.equals(PWEStaticDataModel.PAYOPT_UPI_NAME)) {
                    PWEUpiFragment pWEUpiFragment = PWEUpiFragment.this;
                    zValidateAllFields = pWEUpiFragment.validateAllFields(pWEUpiFragment.tvUpiAddressError);
                } else {
                    PWEUpiFragment pWEUpiFragment2 = PWEUpiFragment.this;
                    zValidateAllFields = pWEUpiFragment2.validateAllFields(pWEUpiFragment2.tvUpiAddressAutodebitError);
                }
                if (zValidateAllFields && PWEUpiFragment.this.openPaymentOption) {
                    PWEUpiFragment.this.openPaymentOption = false;
                    PWEUpiFragment.this.openBottomUPI();
                }
            }
        });
        this.etUPIAddress.addTextChangedListener(new TextWatcher() { // from class: com.easebuzz.payment.kit.PWEUpiFragment.8
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                PWEUpiFragment.this.tvUpiAddressError.setText("");
                PWEUpiFragment.this.tvUpiAddressError.setVisibility(8);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String upiVA;
                if (PWEUpiFragment.this.paymentInfoHandler.getIsDiscountCouponApplied()) {
                    try {
                        upiVA = PWEUpiFragment.this.discountCodeHelper.getUpiVA();
                    } catch (Error | Exception unused) {
                        upiVA = "";
                    }
                    if (editable.toString().trim().equals(upiVA) || editable.toString().trim().equals(PWEUpiFragment.this.selectedUpiUsername)) {
                        return;
                    }
                    PWEUpiFragment.this.couponsActivity.resetDiscountCode();
                }
            }
        });
        this.generalHelper.pweDisableCopyAndPaste(this.etUPIAddress);
        this.linearUpiAddressHolder.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWEUpiFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PWEUpiFragment.this.selectedUpiType = "UPI_ID";
                PWEUpiFragment.this.linearUpiAddressHolder.requestFocus();
                PWEUpiFragment.this.updateSelectedView(false, true, false, false, true);
            }
        });
        this.linearQrCodeHolder.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWEUpiFragment.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PWEUpiFragment.this.clearUPIAddressFocus();
                PWEUpiFragment.this.linearQrCodeHolder.requestFocus();
                PWEUpiFragment.this.selectedUpiType = "UPI_QR";
                PWEUpiFragment.this.updateSelectedView(false, false, false, true, false);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        this.openPaymentOption = true;
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        JSONObject jSONObject = new JSONObject();
        if (this.selectedUpiType.equals("UPI_INTENT")) {
            this.upi_request_message = "Processing your request";
        }
        try {
            jSONObject.put("upi_paused", true);
            jSONObject.put("initialUPISelectionFlag", this.initialUPISelectionFlag);
            jSONObject.put("openPaymentOption", this.openPaymentOption);
            jSONObject.put("isDeeplinkFlowCompleted", this.isDeeplinkFlowCompleted);
            jSONObject.put("is_selected_upi_qr", this.is_selected_upi_qr);
            jSONObject.put("selected_upi_username", this.selectedUpiUsername);
            jSONObject.put("selected_upi_payment_option", selected_upi_payment_option);
            jSONObject.put("selectedIntentUpiKey", this.selectedIntentUpiKey);
            jSONObject.put("selectedIntentUpiPkg", this.selectedIntentUpiPkg);
            jSONObject.put("upi_request_message", this.upi_request_message);
            jSONObject.put("pwe_qr_link", this.pwe_qr_link);
            jSONObject.put("allowCancel", this.allowCancel);
            jSONObject.put("upiVA", this.upiVA);
            jSONObject.put("selected_upi_type", this.selectedUpiType);
            this.paymentInfoHandler.setPweUpiSaveState(jSONObject.toString());
            this.paymentInfoHandler.setPweLastTransactionStatus(PWEStaticHelper.PWE_CURRENT_TRXN_STATUS);
        } catch (JSONException | Exception unused) {
        }
        super.onPause();
    }

    private void selectionUpiOption() {
        int i;
        try {
            if (!PWEStaticHelper.PWE_CURRENT_TRXN_STATUS.equals(PWEStaticDataModel.PWE_STATUS_PENDING)) {
                if (this.selectedUpiType.equals("UPI_INTENT") && this.intentUpiOptionAdapter != null && this.upi_options_list.size() > 0 && (i = this.selectedUpiPosition) != -1 && i < this.upi_options_list.size()) {
                    PWEUPIOptionsDataModel pWEUPIOptionsDataModel = this.upi_options_list.get(this.selectedUpiPosition);
                    this.intentUpiOptionAdapter.setSelectedUpiOptionKey(pWEUPIOptionsDataModel.getKey());
                    this.selectedIntentUpiKey = pWEUPIOptionsDataModel.getKey();
                    this.selectedIntentUpiPkg = pWEUPIOptionsDataModel.getPkg_name();
                    this.intentUpiOptionAdapter.notifyDataSetChanged();
                    if (!this.paymentInfoHandler.getPayUpiAddressVisibilityFlag()) {
                        hideUpiAddressBar();
                    }
                } else {
                    try {
                        if (this.selectedUpiType.equals("UPI_QR")) {
                            updateSelectedView(false, false, false, true, false);
                            if (this.paymentInfoHandler.getPayUpiAddressVisibilityFlag()) {
                                return;
                            }
                            hideUpiAddressBar();
                            return;
                        }
                        updateUpiAddressView();
                    } catch (Exception unused) {
                    }
                }
            }
        } catch (Exception unused2) {
        }
    }

    private void updateUpiAddressView() {
        if (this.selected_payment_option.equals(PWEStaticDataModel.UPI_AUTODEBIT_NAME)) {
            this.selectedUpiType = "UPI_ID";
            this.initialUPISelectionFlag = true;
        } else {
            if (this.paymentInfoHandler.getPayUpiAddressVisibilityFlag()) {
                showUpiAddressBar();
                this.selectedUpiType = "UPI_ID";
                this.initialUPISelectionFlag = true;
                updateSelectedView(false, true, false, false, true);
                return;
            }
            hideUpiAddressBar();
            this.selectedUpiType = "UPI_QR";
            updateSelectedView(false, false, false, true, false);
        }
    }

    private void showUpiAddressBar() {
        this.linearUpiAddressHolder.setVisibility(0);
    }

    private void hideUpiAddressBar() {
        this.linearUpiAddressHolder.setVisibility(8);
        this.couponsActivity.setDiscountCodeVisibiliy("hide");
    }

    private void prepareUpiOptions() {
        try {
            this.upi_options_list = new ArrayList<>();
            JSONArray jSONArray = new JSONObject(this.paymentInfoHandler.getUpiListString()).getJSONArray("upi_deeplink_options");
            for (int i = 0; i < jSONArray.length(); i++) {
                PWEUPIOptionsDataModel pWEUPIOptionsDataModel = new PWEUPIOptionsDataModel();
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("deeplink_conf");
                boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean(StreamManagement.Enabled.ELEMENT, false);
                boolean zOptBoolean2 = jSONObjectOptJSONObject.optBoolean("enabled_android", false);
                if (zOptBoolean && zOptBoolean2) {
                    String strOptString = jSONObjectOptJSONObject.optString("pkg_name_android", "");
                    if (isPWEAppInstalled(strOptString)) {
                        pWEUPIOptionsDataModel.setImage(jSONObject.optString("image"));
                        pWEUPIOptionsDataModel.setKey(jSONObject.optString("key", ""));
                        pWEUPIOptionsDataModel.setLable(jSONObject.optString("label"));
                        pWEUPIOptionsDataModel.setShow_label(jSONObject.optBoolean("showLabel", false));
                        pWEUPIOptionsDataModel.setPkg_name(strOptString);
                        this.upi_options_list.add(pWEUPIOptionsDataModel);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private void initializeUpiOptionAdapter() {
        if (this.upi_options_list.size() > 0) {
            this.linearUPIIntentsHolder.setVisibility(0);
            PWEUpiIntentsAdapter pWEUpiIntentsAdapter = new PWEUpiIntentsAdapter(getActivity(), this.upi_options_list, this.paymentInfoHandler);
            this.intentUpiOptionAdapter = pWEUpiIntentsAdapter;
            this.gridUPIOptions.setAdapter((ListAdapter) pWEUpiIntentsAdapter);
            this.gridUPIOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.easebuzz.payment.kit.PWEUpiFragment.11
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (PWEUpiFragment.this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
                        PWEUpiFragment.this.intentUpiOptionAdapter.selectUpiOption(view, i);
                        PWEUpiFragment.this.intentUpiOptionAdapter.setSelectedUpiOptionKey(((PWEUPIOptionsDataModel) PWEUpiFragment.this.upi_options_list.get(i)).getKey());
                    }
                }
            });
            this.intentUpiOptionAdapter.setPWEUpiOptionListener(new PWEUpiOptionListener() { // from class: com.easebuzz.payment.kit.PWEUpiFragment.12
                @Override // listeners.PWEUpiOptionListener
                public void selectUPIOption(PWEUPIOptionsDataModel pWEUPIOptionsDataModel, int i) {
                    PWEUpiFragment.this.is_selected_upi_qr = true;
                    if (PWEUpiFragment.this.paymentInfoHandler.getIsDiscountCouponApplied() && PWEUpiFragment.this.selectedUpiPosition != i) {
                        PWEUpiFragment.this.couponsActivity.resetDiscountCode();
                    }
                    PWEUpiFragment.this.selectedUpiPosition = i;
                    PWEUpiFragment.this.selectedIntentUpiKey = pWEUPIOptionsDataModel.getKey();
                    PWEUpiFragment.this.selectedIntentUpiPkg = pWEUPIOptionsDataModel.getPkg_name();
                    PWEUpiFragment.this.tvUpiAddressError.setText("");
                    PWEUpiFragment.this.tvUpiAddressError.setVisibility(8);
                    PWEUpiFragment.this.selectedUpiType = "UPI_INTENT";
                    PWEUpiFragment.this.clearUPIAddressFocus();
                    PWEUpiFragment.this.updateSelectedView(true, false, false, false, false);
                    PWEUpiFragment.this.selectedUpiUsername = "";
                }
            });
            this.gridUPIOptions.setNumColumns(3);
            this.gridUPIOptions.setExpanded(true);
            return;
        }
        this.gridUPIOptions.setVisibility(8);
        this.linearUPIIntentsHolder.setVisibility(8);
        this.tvPayUsingTitle.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSelectedView(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.tvUpiAddressError.setText("");
        this.tvUpiAddressError.setVisibility(8);
        if (this.paymentInfoHandler.getIsDiscountCouponApplied() && !z2) {
            this.couponsActivity.resetDiscountCode();
        }
        this.is_selected_upi_qr = false;
        if (z5) {
            if (this.paymentInfoHandler.getIsDiscountCouponEnabled()) {
                this.couponsActivity.setDiscountCodeVisibiliy("show");
            }
        } else {
            this.couponsActivity.setDiscountCodeVisibiliy("hide");
        }
        if (z) {
            this.is_selected_upi_qr = true;
            this.selectedUpiUsername = "";
            PWEUpiIntentsAdapter pWEUpiIntentsAdapter = this.intentUpiOptionAdapter;
            if (pWEUpiIntentsAdapter != null) {
                pWEUpiIntentsAdapter.setSelectedUpiOptionKey(this.selectedIntentUpiKey);
            }
        } else if (z2) {
            PWEUpiIntentsAdapter pWEUpiIntentsAdapter2 = this.intentUpiOptionAdapter;
            if (pWEUpiIntentsAdapter2 != null) {
                pWEUpiIntentsAdapter2.setSelectedUpiOptionKey("");
            }
            requestUPIAddressFocus();
            this.selectedUpiPosition = -1;
            this.selectedIntentUpiKey = "";
            this.selectedIntentUpiPkg = "";
        } else if (z3) {
            PWEUpiIntentsAdapter pWEUpiIntentsAdapter3 = this.intentUpiOptionAdapter;
            if (pWEUpiIntentsAdapter3 != null) {
                pWEUpiIntentsAdapter3.setSelectedUpiOptionKey("");
            }
            this.selectedUpiPosition = -1;
            this.selectedUpiUsername = "";
            this.is_selected_upi_qr = true;
            this.selectedIntentUpiKey = "";
            this.selectedIntentUpiPkg = "";
        } else if (z4) {
            PWEUpiIntentsAdapter pWEUpiIntentsAdapter4 = this.intentUpiOptionAdapter;
            if (pWEUpiIntentsAdapter4 != null) {
                pWEUpiIntentsAdapter4.setSelectedUpiOptionKey("");
            }
            this.selectedUpiPosition = -1;
            this.selectedUpiUsername = "";
            this.is_selected_upi_qr = true;
            this.selectedIntentUpiKey = "";
            this.selectedIntentUpiPkg = "";
        }
        updateUI();
        this.initialUPISelectionFlag = false;
    }

    private void updateUI() {
        this.linearUpiAddressHolder.setBackground(getResources().getDrawable(R.drawable.pwe_custom_card_background));
        this.linearUPIIntentsHolder.setBackground(getResources().getDrawable(R.drawable.pwe_custom_card_background));
        this.linearQrCodeHolder.setBackground(getResources().getDrawable(R.drawable.pwe_custom_card_background));
        if (this.selectedUpiType.equals("UPI_ID")) {
            this.linearUpiAddressHolder.setBackground(getResources().getDrawable(R.drawable.pwe_selected_item_background));
        } else if (this.selectedUpiType.equals("UPI_QR")) {
            this.linearQrCodeHolder.setBackground(getResources().getDrawable(R.drawable.pwe_selected_item_background));
        } else {
            this.linearUpiAddressHolder.setBackground(getResources().getDrawable(R.drawable.pwe_custom_card_background));
            this.linearQrCodeHolder.setBackground(getResources().getDrawable(R.drawable.pwe_custom_card_background));
        }
    }

    public void openBottomUPI() {
        View viewInflate = getLayoutInflater().inflate(R.layout.bottom_sheet_upi, (ViewGroup) null);
        Dialog dialog = new Dialog(getActivity(), R.style.MaterialDialogSheet);
        this.upiBottomSheetDialog = dialog;
        dialog.setContentView(viewInflate);
        this.upiBottomSheetDialog.getWindow().setLayout(-1, -2);
        this.ivSendRequest = (ImageView) viewInflate.findViewById(R.id.image_upi_req);
        this.progressUpiLoader = (ProgressBar) viewInflate.findViewById(R.id.progress_upi_request);
        this.tv_upi_req_text = (TextView) viewInflate.findViewById(R.id.txt_upi_req);
        this.btn_cancel_upi_request = (Button) viewInflate.findViewById(R.id.button_cancel_upi_request);
        this.linearNormalUPINoteHolder = (LinearLayout) viewInflate.findViewById(R.id.linear_normal_upi_note_holder);
        this.linearScanQrHolder = (LinearLayout) viewInflate.findViewById(R.id.linear_pwe_scan_qr_holder);
        this.progressGeneratingQr = (ProgressBar) viewInflate.findViewById(R.id.progress_generating_qr);
        this.ivUPIQr = (ImageView) viewInflate.findViewById(R.id.image_upi_qr_code);
        this.upiBottomSheetDialog.getWindow().setGravity(80);
        this.upiBottomSheetDialog.setCancelable(false);
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            this.btn_cancel_upi_request.setBackground(getActivity().getResources().getDrawable(R.drawable.pwe_android_tv_text_button));
        }
        this.btn_cancel_upi_request.setVisibility(0);
        if (this.is_selected_upi_qr) {
            if (this.selectedUpiType.equals("UPI_QR")) {
                this.btn_cancel_upi_request.setVisibility(8);
                this.generalHelper.enableScreenRecording(getActivity());
            }
            this.linearScanQrHolder.setVisibility(0);
            this.linearNormalUPINoteHolder.setVisibility(8);
            this.progressGeneratingQr.setVisibility(0);
            this.ivUPIQr.setVisibility(8);
        } else {
            this.linearScanQrHolder.setVisibility(8);
            this.progressGeneratingQr.setVisibility(8);
            this.ivUPIQr.setVisibility(8);
            this.linearNormalUPINoteHolder.setVisibility(0);
        }
        this.btn_cancel_upi_request.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWEUpiFragment.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PWEUpiFragment.this.allowCancel) {
                    PWEUpiFragment.this.openPaymentOption = true;
                    PWEUpiFragment.this.isCancellingUPIRequest = true;
                    PWEUpiFragment.this.cancelUPIRequest();
                }
            }
        });
        this.upiBottomSheetDialog.show();
        this.upi_request_message = "Processing your request";
        this.tv_upi_req_text.setText("Processing your request");
        if (PWEStaticHelper.PWE_CURRENT_TRXN_STATUS.equals(PWEStaticDataModel.PWE_STATUS_PENDING)) {
            if (this.selectedUpiType.equals("UPI_QR")) {
                this.upiBottomSheetDialog.setCancelable(true);
                this.progressUpiLoader.setVisibility(8);
                this.progressGeneratingQr.setVisibility(8);
                this.upi_request_message = "Scan the QR Code on any UPI Application";
            }
            openUPIApps();
        } else {
            sendUpiRequest();
        }
        this.upiBottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.easebuzz.payment.kit.PWEUpiFragment.14
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                PWEUpiFragment.this.openPaymentOption = true;
                PWEUpiFragment.this.generalHelper.disableScreenRecording(PWEUpiFragment.this.getActivity());
            }
        });
    }

    private void sendUpiRequest() {
        if (this.selected_payment_option.equals(PWEStaticDataModel.PAYOPT_UPI_NAME)) {
            selected_upi_payment_option = PWEStaticDataModel.PAYOPT_UPI_NAME;
            this.upiVA = getCompleteUPIAddress(this.etUPIAddress);
        } else {
            selected_upi_payment_option = PWEStaticDataModel.UPI_AUTODEBIT_NAME;
            this.upiVA = getCompleteUPIAddress(this.edUpiAutodebitUsername);
        }
        if (this.selectedUpiType.equals("UPI_QR") || this.selectedUpiType.equals("UPI_INTENT")) {
            this.upiVA = "";
        }
        this.ivSendRequest.setVisibility(4);
        this.progressUpiLoader.setVisibility(0);
        processUPI();
    }

    private void processUPI() {
        getSubmitParameters();
        ((RetroAPI) new Retrofit.Builder().baseUrl(this.EndPointUrl).addConverterFactory(new ToStringConverterFactory()).callFactory(this.generalHelper.getRetrofitConnectionFactory()).build().create(RetroAPI.class)).submitInitiatePayment(this.submitInitiateParametersJsonObj).enqueue(new Callback<String>() { // from class: com.easebuzz.payment.kit.PWEUpiFragment.15
            @Override // retrofit2.Callback
            public void onResponse(Call<String> call, Response<String> response) {
                try {
                    PWEUpiFragment.this.handleSubmitInitiateUPI(response.body().toString());
                } catch (Exception unused) {
                    PWEUpiFragment.this.dismissUpiBottomSheet();
                    PWEUpiFragment.this.dismissCheckStatusTimer();
                    PWEUpiFragment.this.couponsActivity.sendFailedResponseMerchant(PWEStaticDataModel.SERVER_ERROR_STR, PWEStaticDataModel.ERROR_DESC_STR, PWEStaticDataModel.TXN_ERROR_SERVER_ERROR_CODE);
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<String> call, Throwable th) {
                PWEUpiFragment.this.openPaymentOption = true;
                PWEUpiFragment.this.generalHelper.showPweToast(PWEStaticDataModel.SERVER_ERROR_STR + ", Please try again");
                PWEUpiFragment.this.dismissUpiBottomSheet();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUPIAddressFocus() {
        this.etUPIAddress.setText("");
        this.etUPIAddress.setEnabled(false);
        this.etUPIAddress.setVisibility(8);
    }

    private void requestUPIAddressFocus() {
        this.etUPIAddress.setEnabled(true);
        this.etUPIAddress.setVisibility(0);
        this.etUPIAddress.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSubmitInitiateUPI(String str) {
        try {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optBoolean("status", false)) {
                    PWEStaticHelper.PWE_CURRENT_TRXN_STATUS = PWEStaticDataModel.PWE_STATUS_PENDING;
                    this.openPaymentOption = true;
                    String str2 = "Processing your request";
                    if (!this.selectedUpiType.equals("UPI_ID")) {
                        String strOptString = jSONObject.optString("qr_link", "");
                        this.pwe_qr_link = strOptString;
                        if (!strOptString.equals("")) {
                            if (this.selectedUpiType.equals("UPI_QR")) {
                                String strOptString2 = jSONObject.optString("message", "Processing your request");
                                this.upiBottomSheetDialog.setCancelable(true);
                                this.progressGeneratingQr.setVisibility(8);
                                str2 = strOptString2;
                            }
                            disableUpiIdLayouts();
                            openUPIApps();
                        } else {
                            this.couponsActivity.sendFailedResponseMerchant(PWEStaticDataModel.UPIQR_ERROR_STR, PWEStaticDataModel.UPIQR_DESC_STR, PWEStaticDataModel.TXN_ERROR_SERVER_ERROR_CODE);
                        }
                    } else {
                        str2 = "Please accept the payment on your UPI phone application";
                    }
                    this.upi_request_message = str2;
                    this.tv_upi_req_text.setText(str2);
                    this.ivSendRequest.setVisibility(8);
                    this.progressUpiLoader.setVisibility(0);
                    this.allowCancel = true;
                    if (this.paymentInfoHandler.getPaymentMode().equals(Const.TEST)) {
                        try {
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.easebuzz.payment.kit.PWEUpiFragment.16
                                @Override // java.lang.Runnable
                                public void run() {
                                    PWEUpiFragment.this.checkUPITransactionStatus();
                                }
                            }, 1500L);
                            return;
                        } catch (Error unused) {
                            checkUPITransactionStatus();
                            return;
                        } catch (Exception unused2) {
                            checkUPITransactionStatus();
                            return;
                        }
                    }
                    checkUPITransactionStatus();
                    return;
                }
                this.generalHelper.showPweToast(jSONObject.optString("error", "Please try other payment option."));
                dismissUpiBottomSheet();
            } catch (JSONException unused3) {
                dismissUpiBottomSheet();
                dismissCheckStatusTimer();
                this.couponsActivity.sendFailedResponseMerchant(PWEStaticDataModel.SERVER_ERROR_STR, PWEStaticDataModel.ERROR_DESC_STR, PWEStaticDataModel.TXN_ERROR_SERVER_ERROR_CODE);
            }
        } catch (Error unused4) {
            dismissCheckStatusTimer();
            dismissUpiBottomSheet();
            this.couponsActivity.sendFailedResponseMerchant(PWEStaticDataModel.SERVER_ERROR_STR, PWEStaticDataModel.ERROR_DESC_STR, PWEStaticDataModel.TXN_ERROR_SERVER_ERROR_CODE);
        } catch (Exception unused5) {
            dismissCheckStatusTimer();
            dismissUpiBottomSheet();
            this.couponsActivity.sendFailedResponseMerchant(PWEStaticDataModel.SERVER_ERROR_STR, PWEStaticDataModel.ERROR_DESC_STR, PWEStaticDataModel.TXN_ERROR_SERVER_ERROR_CODE);
        }
    }

    private void openUPIApps() {
        if (!this.paymentInfoHandler.getPaymentMode().equals(Const.TEST)) {
            openUPIAppsProd();
        } else {
            openUPIAppsSandbox();
        }
    }

    public void openUPIAppsSandbox() {
        if (this.selectedUpiType.equals("UPI_QR")) {
            openQrCode(this.pwe_qr_link);
        }
    }

    public void openUPIAppsProd() {
        if (this.selectedUpiType.equals("UPI_QR")) {
            openQrCode(this.pwe_qr_link);
            return;
        }
        if (!this.selectedUpiType.equals("UPI_INTENT") || this.isDeeplinkFlowCompleted) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(this.pwe_qr_link));
        if (!this.selectedIntentUpiPkg.equals("")) {
            intent.setPackage(this.selectedIntentUpiPkg);
        }
        try {
            Intent intentCreateChooser = Intent.createChooser(intent, "Pay with...");
            this.upiChooser = intentCreateChooser;
            if (intentCreateChooser.resolveActivity(getActivity().getPackageManager()) == null) {
                this.generalHelper.showPweToast("Oops, UPI Apps not available");
            } else {
                this.pweUpiResultLauncher.launch(this.upiChooser);
            }
        } catch (Exception unused) {
            this.generalHelper.showPweToast("Oops, UPI Apps not available");
        }
    }

    private void openQrCode(String str) {
        try {
            this.tv_upi_req_text.setText(this.upi_request_message);
            this.ivUPIQr.setVisibility(0);
            Bitmap bitmapGenerateQRCode = this.generalHelper.generateQRCode(str, ByteCode.DRETURN, ByteCode.DRETURN);
            if (bitmapGenerateQRCode != null) {
                this.ivUPIQr.setImageBitmap(bitmapGenerateQRCode);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void disableUpiIdLayouts() {
        this.tvPayUsingUpiIdTitle.setTextColor(getActivity().getResources().getColor(R.color.pwe_disable_text_color));
        this.tvPayUsingUpiIdNote.setTextColor(getActivity().getResources().getColor(R.color.pwe_disable_text_color));
        this.etUPIAddress.setHintTextColor(getActivity().getResources().getColor(R.color.pwe_disable_text_color));
        disableLayout(this.linearUpiAddressHolder);
    }

    private void disableLayout(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        viewGroup.setEnabled(false);
        for (int i = 0; i < childCount; i++) {
            if (viewGroup.getChildAt(i) instanceof ViewGroup) {
                disableLayout((ViewGroup) viewGroup.getChildAt(i));
            } else {
                viewGroup.getChildAt(i).setEnabled(false);
            }
        }
    }

    public String getCompleteUPIAddress(EditText editText) {
        String str = "";
        try {
            String string = editText.getText().toString();
            this.selectedUpiUsername = string;
            this.selectedUpiUsername = string.trim();
            str = "" + this.selectedUpiUsername;
            return str.trim();
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean validateAllFields(TextView textView) {
        EditText editText;
        boolean z = true;
        if (!this.selectedUpiType.equals("UPI_ID")) {
            return true;
        }
        if (this.selected_payment_option.equals(PWEStaticDataModel.PAYOPT_UPI_NAME)) {
            editText = this.etUPIAddress;
        } else {
            editText = this.edUpiAutodebitUsername;
        }
        String completeUPIAddress = getCompleteUPIAddress(editText);
        boolean z2 = false;
        if (completeUPIAddress == null || completeUPIAddress.isEmpty() || completeUPIAddress.equals("")) {
            textView.setText("Please enter UPI ID");
            textView.setVisibility(0);
        } else if (completeUPIAddress.contains("@")) {
            if (completeUPIAddress.startsWith("@")) {
                textView.setText("Please enter valid UPI ID");
                textView.setVisibility(0);
                z = false;
            }
            if (completeUPIAddress.endsWith("@")) {
                textView.setText("Please enter valid UPI ID");
                textView.setVisibility(0);
            } else {
                z2 = z;
            }
        } else {
            textView.setText("Please enter valid UPI ID");
            textView.setVisibility(0);
        }
        if (z2) {
            textView.setText("");
            textView.setVisibility(8);
        }
        return z2;
    }

    public void cancelUPIRequest() {
        this.couponsActivity.showPWELoader();
        this.ivSendRequest.setVisibility(0);
        this.progressUpiLoader.setVisibility(8);
        this.progressGeneratingQr.setVisibility(8);
        this.upi_request_message = "Cancelling upi payment";
        this.tv_upi_req_text.setText("Cancelling upi payment");
        ((RetroAPI) new Retrofit.Builder().baseUrl(this.generalHelper.getUPIAPIBaseURL()).addConverterFactory(new ToStringConverterFactory()).callFactory(this.generalHelper.getRetrofitConnectionFactory()).build().create(RetroAPI.class)).cancelUPIRequest(this.paymentInfoHandler.getMerchantAccessKey()).enqueue(new Callback<String>() { // from class: com.easebuzz.payment.kit.PWEUpiFragment.17
            @Override // retrofit2.Callback
            public void onResponse(Call<String> call, Response<String> response) {
                PWEUpiFragment.this.couponsActivity.hidePWELoader();
                try {
                    PWEUpiFragment.this.handleCancelUPIRequest(response.body().toString());
                } catch (Exception unused) {
                    PWEUpiFragment.CANCEL_UPI_EXCEPT_COUNT_1++;
                    if (PWEUpiFragment.CANCEL_UPI_EXCEPT_COUNT_1 <= 2) {
                        PWEUpiFragment.this.generalHelper.showPweToast("Please try again");
                    } else {
                        PWEUpiFragment.this.dismissCheckStatusTimer();
                        PWEUpiFragment.this.couponsActivity.sendFailedResponseMerchant(PWEStaticDataModel.BANK_BACK_PRESSED_STR, PWEStaticDataModel.ERROR_DESC_STR, PWEStaticDataModel.TXN_BANK_BACK_PRESSED_CODE);
                    }
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<String> call, Throwable th) {
                PWEUpiFragment.this.couponsActivity.hidePWELoader();
                PWEUpiFragment.CANCEL_UPI_SERVER_ERROR_COUNT++;
                if (PWEUpiFragment.CANCEL_UPI_SERVER_ERROR_COUNT <= 2) {
                    PWEUpiFragment.this.generalHelper.showPweToast("Please try again");
                } else {
                    PWEUpiFragment.this.dismissCheckStatusTimer();
                    PWEUpiFragment.this.couponsActivity.sendFailedResponseMerchant(PWEStaticDataModel.SERVER_ERROR_STR, PWEStaticDataModel.ERROR_DESC_STR, PWEStaticDataModel.TXN_ERROR_SERVER_ERROR_CODE);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCancelUPIRequest(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getString("status").equals("true")) {
                dismissUpiBottomSheet();
                onUPIResponse(jSONObject.getString("payment_response"));
                return;
            }
            int i = CANCEL_UPI_EXCEPT_COUNT_2 + 1;
            CANCEL_UPI_EXCEPT_COUNT_2 = i;
            if (i <= 2) {
                this.generalHelper.showPweToast("Please try again");
            } else {
                dismissCheckStatusTimer();
                this.couponsActivity.sendFailedResponseMerchant(PWEStaticDataModel.SERVER_ERROR_STR, PWEStaticDataModel.ERROR_DESC_STR, PWEStaticDataModel.TXN_ERROR_SERVER_ERROR_CODE);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            int i2 = CANCEL_UPI_EXCEPT_COUNT_2 + 1;
            CANCEL_UPI_EXCEPT_COUNT_2 = i2;
            if (i2 <= 3) {
                this.generalHelper.showPweToast("Please try again");
            } else {
                dismissCheckStatusTimer();
                this.couponsActivity.sendFailedResponseMerchant(PWEStaticDataModel.SERVER_ERROR_STR, PWEStaticDataModel.ERROR_DESC_STR, PWEStaticDataModel.TXN_ERROR_SERVER_ERROR_CODE);
            }
        }
    }

    public void onUPIResponse(final String str) {
        getActivity().runOnUiThread(new Runnable() { // from class: com.easebuzz.payment.kit.PWEUpiFragment.18
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String string = new JSONObject(str).getString("status");
                    if (PWEUpiFragment.this.checkStatusTimer != null) {
                        PWEUpiFragment.this.checkStatusTimer.cancel();
                    }
                    if (string.equals("success")) {
                        PWEUpiFragment.this.dismissCheckStatusTimer();
                        PWEUpiFragment.this.couponsActivity.sendResponseToMerchant(PWEStaticDataModel.TXN_SUCCESS_CODE, str, -1);
                    } else {
                        PWEUpiFragment.this.dismissCheckStatusTimer();
                        PWEUpiFragment.this.couponsActivity.sendResponseToMerchant("payment_failed", str, 0);
                    }
                } catch (Exception unused) {
                    PWEUpiFragment.this.dismissCheckStatusTimer();
                    PWEUpiFragment.this.couponsActivity.sendFailedResponseMerchant(PWEStaticDataModel.SERVER_ERROR_STR, PWEStaticDataModel.ERROR_DESC_STR, PWEStaticDataModel.TXN_ERROR_SERVER_ERROR_CODE);
                }
            }
        });
    }

    public void checkUPITransactionStatus() {
        getCheckUPIStatusParameters();
        ((RetroAPI) new Retrofit.Builder().baseUrl(this.generalHelper.getUPIAPIBaseURL()).addConverterFactory(new ToStringConverterFactory()).callFactory(this.generalHelper.getRetrofitConnectionFactory()).build().create(RetroAPI.class)).checkUPIStatus(this.checkStatusParametersJsonObj).enqueue(new Callback<String>() { // from class: com.easebuzz.payment.kit.PWEUpiFragment.19
            @Override // retrofit2.Callback
            public void onResponse(Call<String> call, Response<String> response) {
                if (response != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(response.body().toString());
                        if (jSONObject.getString("status").equals("false")) {
                            if (PWEUpiFragment.this.is_check_status_timer_started) {
                                return;
                            }
                            PWEUpiFragment.this.is_check_status_timer_started = true;
                            PWEUpiFragment.this.initiateCheckStatusTask();
                            return;
                        }
                        if (!jSONObject.getString("status").equals("true") || PWEUpiFragment.this.isCancellingUPIRequest) {
                            return;
                        }
                        PWEUpiFragment.this.dismissUpiBottomSheet();
                        PWEUpiFragment.this.onUPIResponse(jSONObject.getString("payment_response"));
                    } catch (Exception unused) {
                        PWEUpiFragment.TXN_CHECK_STATUS_EXCEPT_COUNT_1++;
                        if (PWEUpiFragment.TXN_CHECK_STATUS_EXCEPT_COUNT_1 <= 3) {
                            if (PWEUpiFragment.this.is_check_status_timer_started) {
                                return;
                            }
                            PWEUpiFragment.this.is_check_status_timer_started = true;
                            PWEUpiFragment.this.initiateCheckStatusTask();
                            return;
                        }
                        PWEUpiFragment.this.dismissCheckStatusTimer();
                        PWEUpiFragment.this.couponsActivity.sendFailedResponseMerchant(PWEStaticDataModel.SERVER_ERROR_STR, PWEStaticDataModel.ERROR_DESC_STR, PWEStaticDataModel.TXN_ERROR_SERVER_ERROR_CODE);
                    }
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<String> call, Throwable th) {
                PWEUpiFragment.TXN_CHECK_STATUS_SERVER_COUNT_ERROR++;
                if (PWEUpiFragment.TXN_CHECK_STATUS_SERVER_COUNT_ERROR <= 3) {
                    if (PWEUpiFragment.this.is_check_status_timer_started) {
                        return;
                    }
                    PWEUpiFragment.this.is_check_status_timer_started = true;
                    PWEUpiFragment.this.initiateCheckStatusTask();
                    return;
                }
                PWEUpiFragment.this.dismissCheckStatusTimer();
                PWEUpiFragment.this.couponsActivity.sendFailedResponseMerchant(PWEStaticDataModel.SERVER_ERROR_STR, PWEStaticDataModel.ERROR_DESC_STR, PWEStaticDataModel.TXN_ERROR_SERVER_ERROR_CODE);
            }
        });
    }

    public void initiateCheckStatusTask() {
        TimerTask timerTask = new TimerTask() { // from class: com.easebuzz.payment.kit.PWEUpiFragment.20
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                PWEUpiFragment.this.checkStatusHandler.post(new Runnable() { // from class: com.easebuzz.payment.kit.PWEUpiFragment.20.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PWEUpiFragment.this.new PerformBackgroundTask().execute(new String[0]);
                    }
                });
            }
        };
        this.checkStatusTask = timerTask;
        this.checkStatusTimer.scheduleAtFixedRate(timerTask, 0L, 3000L);
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

    public class PerformBackgroundTask extends AsyncTask<String, Void, String> {
        public PerformBackgroundTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(String... strArr) {
            PWEUpiFragment.this.checkUPITransactionStatus();
            return null;
        }
    }

    private void getCheckUPIStatusParameters() {
        HashMap map = new HashMap();
        this.checkStatusParametersJsonObj = map;
        try {
            map.put("paymentoption", selected_upi_payment_option);
            this.checkStatusParametersJsonObj.put(Const.ZOOM_ACCESS_KEY, this.paymentInfoHandler.getMerchantAccessKey());
            this.checkStatusParametersJsonObj.put("userAgent", "userAgent");
            this.checkStatusParametersJsonObj.put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, "android");
            this.checkStatusParametersJsonObj.put("ismobile", "1");
            this.checkStatusParametersJsonObj.put("discount_code", this.paymentInfoHandler.getAppliedDiscountCouponCode());
            this.checkStatusParametersJsonObj.put("upiVA", this.upiVA);
            this.checkStatusParametersJsonObj.put("selected_coupon", this.paymentInfoHandler.getSelectedCouponIdList());
        } catch (Error e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private void getSubmitParameters() {
        HashMap map = new HashMap();
        this.submitInitiateParametersJsonObj = map;
        try {
            map.put("paymentoption", selected_upi_payment_option);
            this.submitInitiateParametersJsonObj.put(Const.ZOOM_ACCESS_KEY, this.paymentInfoHandler.getMerchantAccessKey());
            this.submitInitiateParametersJsonObj.put("userAgent", "userAgent");
            this.submitInitiateParametersJsonObj.put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, "android");
            this.submitInitiateParametersJsonObj.put("ismobile", "1");
            this.submitInitiateParametersJsonObj.put("upiVA", this.upiVA);
            if (this.selected_payment_option.equals(PWEStaticDataModel.PAYOPT_UPI_NAME)) {
                this.submitInitiateParametersJsonObj.put("upiQR", Boolean.valueOf(this.is_selected_upi_qr));
                this.submitInitiateParametersJsonObj.put("selected_coupon", this.paymentInfoHandler.getSelectedCouponIdList());
                this.submitInitiateParametersJsonObj.put("discount_code", this.paymentInfoHandler.getAppliedDiscountCouponCode());
            }
        } catch (Error e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void dismissUpiBottomSheet() {
        try {
            Dialog dialog = this.upiBottomSheetDialog;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            this.upiBottomSheetDialog.dismiss();
        } catch (Error | Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject validateDiscountCodeOuter(java.util.ArrayList<datamodels.DiscountCodeDataModel> r7, com.easebuzz.payment.kit.PWEDiscountHelper r8) {
        /*
            r6 = this;
            r6.discountCodeHelper = r8
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            android.widget.EditText r0 = r6.etUPIAddress
            java.lang.String r0 = r6.getCompleteUPIAddress(r0)
            int r7 = r7.size()
            r1 = 0
            r2 = 1
            if (r7 >= r2) goto L18
            java.lang.String r7 = "Discount codes are not available for this payment mode"
            goto L49
        L18:
            java.lang.String r7 = "Please enter UPI ID before applying discount code"
            if (r0 != 0) goto L1d
            goto L49
        L1d:
            boolean r3 = r0.isEmpty()
            if (r3 != 0) goto L49
            java.lang.String r3 = ""
            boolean r4 = r0.equals(r3)
            if (r4 == 0) goto L2c
            goto L49
        L2c:
            java.lang.String r7 = "@"
            boolean r4 = r0.contains(r7)
            java.lang.String r5 = "Please enter valid UPI ID"
            if (r4 == 0) goto L48
            boolean r4 = r0.startsWith(r7)
            if (r4 == 0) goto L3d
            r3 = r5
        L3d:
            r2 = r2 ^ r4
            boolean r7 = r0.endsWith(r7)
            if (r7 == 0) goto L45
            goto L48
        L45:
            r1 = r2
            r7 = r3
            goto L49
        L48:
            r7 = r5
        L49:
            if (r1 == 0) goto L50
            com.easebuzz.payment.kit.PWEDiscountHelper r2 = r6.discountCodeHelper
            r2.setUpiVA(r0)
        L50:
            java.lang.String r0 = "status"
            r8.put(r0, r1)     // Catch: org.json.JSONException -> L5d
            java.lang.String r0 = "toast_error_message"
            r8.put(r0, r7)     // Catch: org.json.JSONException -> L5d
            return r8
        L5d:
            r7 = move-exception
            r7.printStackTrace()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easebuzz.payment.kit.PWEUpiFragment.validateDiscountCodeOuter(java.util.ArrayList, com.easebuzz.payment.kit.PWEDiscountHelper):org.json.JSONObject");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.paymentInfoHandler.setPweUpiSaveState("{}");
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    private boolean isPWEAppInstalled(String str) {
        try {
            getActivity().getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
