package com.easebuzz.payment.kit;

import adapters.PWEDiscountCodeListAdapter;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import clientRequestsApi.RetroAPI;
import com.appnew.android.Utils.Const;
import datamodels.DiscountCodeDataModel;
import datamodels.PWEStaticDataModel;
import helper.ToStringConverterFactory;
import java.util.ArrayList;
import listeners.PWEDiscountListener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: classes7.dex */
public class PWEDiscountHelper {
    private String EndPointUrl;
    private String access_key;
    public Button applyCouponCode;
    private Context context;
    private PWEDiscountListener discountCodeListener;
    public Dialog discountCodePopup;
    private String discount_type;
    public EditText editCouponCode;
    public PWEGeneralHelper generalHelper;
    private ImageView imageApplyDiscount;
    private ImageView imageAvailableDiscount;
    public LinearLayout linearNoDiscountCodes;
    private String mode_selected_for_discount;
    public PayAmountHelper pamtHelper;
    public PWEPaymentInfoHandler paymentInfoHandler;
    private ProgressDialog progressDialog;
    private TextView tvDiscountCodeApplyError;
    public String txn_id;
    public View viewDiscountDivider;
    public String discount_code = "";
    public String bank_wallet_name = "";
    private String bin_number = "";
    String card_id = "";
    String bankCode = "";
    String upiVA = "";

    public PWEDiscountHelper(Context context, String str, String str2) {
        this.txn_id = "";
        this.context = context;
        this.paymentInfoHandler = new PWEPaymentInfoHandler(this.context);
        this.pamtHelper = new PayAmountHelper(context);
        this.generalHelper = new PWEGeneralHelper(context);
        ProgressDialog progressDialog = new ProgressDialog(this.context, R.style.PweProgressDialogTheme);
        this.progressDialog = progressDialog;
        progressDialog.setMessage("Please wait...");
        this.progressDialog.setCancelable(false);
        if (this.paymentInfoHandler.getPaymentMode().equals(Const.TEST)) {
            this.EndPointUrl = PWEStaticDataModel.REST_BASE_URL_TEST + "/webservice/";
        } else {
            this.EndPointUrl = PWEStaticDataModel.REST_BASE_URL + "/webservice/";
        }
        this.access_key = this.paymentInfoHandler.getMerchantAccessKey();
        this.mode_selected_for_discount = str;
        this.txn_id = this.paymentInfoHandler.getMerchantTxnId();
    }

    public ArrayList<DiscountCodeDataModel> getDiscountCodeList(String str) {
        ArrayList<DiscountCodeDataModel> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = new JSONArray(this.paymentInfoHandler.getDiscountCodeListDetails());
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString("payment_mode");
                if (str.equals(PWEStaticDataModel.PAYOPT_SAVED_CARD_NAME)) {
                    if (string.contains(PWEStaticDataModel.PAYOPT_CREDITCARD_NAME) || string.contains(PWEStaticDataModel.PAYOPT_DEBITCARD_NAME)) {
                        DiscountCodeDataModel discountCodeDataModel = new DiscountCodeDataModel();
                        discountCodeDataModel.setDiscount_code_id(jSONObject.getString("id"));
                        discountCodeDataModel.setDiscount_code(jSONObject.getString("discount_code"));
                        discountCodeDataModel.setDiscount_description(jSONObject.getString("description"));
                        discountCodeDataModel.setPayment_mode(jSONObject.getString("payment_mode"));
                        arrayList.add(discountCodeDataModel);
                    }
                } else if (string.contains(str)) {
                    DiscountCodeDataModel discountCodeDataModel2 = new DiscountCodeDataModel();
                    discountCodeDataModel2.setDiscount_code_id(jSONObject.getString("id"));
                    discountCodeDataModel2.setDiscount_code(jSONObject.getString("discount_code"));
                    discountCodeDataModel2.setDiscount_description(jSONObject.getString("description"));
                    discountCodeDataModel2.setPayment_mode(jSONObject.getString("payment_mode"));
                    arrayList.add(discountCodeDataModel2);
                }
            }
        } catch (Error | JSONException | Exception unused) {
        }
        return arrayList;
    }

    public void setDiscountCodeListener(PWEDiscountListener pWEDiscountListener) {
        this.discountCodeListener = pWEDiscountListener;
    }

    public void openBottomSheetApplyCoupon(Context context) {
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.pwe_bottom_sheet_apply_coupon, (ViewGroup) null);
        Dialog dialog = new Dialog(context, R.style.MaterialDialogSheetTop);
        this.discountCodePopup = dialog;
        dialog.setContentView(viewInflate);
        this.discountCodePopup.setCancelable(true);
        this.discountCodePopup.getWindow().setLayout(-1, -1);
        EditText editText = (EditText) viewInflate.findViewById(R.id.edit_discount_coupon_code);
        this.editCouponCode = editText;
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.easebuzz.payment.kit.PWEDiscountHelper.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (PWEDiscountHelper.this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
                    if (z) {
                        PWEDiscountHelper.this.editCouponCode.setBackground(PWEDiscountHelper.this.context.getResources().getDrawable(R.drawable.pwe_android_tv_image_edit_text));
                    } else {
                        PWEDiscountHelper.this.editCouponCode.setBackground(PWEDiscountHelper.this.context.getResources().getDrawable(R.drawable.custom_background_white));
                    }
                }
            }
        });
        this.generalHelper.pweDisableCopyAndPaste(this.editCouponCode);
        this.applyCouponCode = (Button) viewInflate.findViewById(R.id.btn_apply_discount_coupon_code);
        this.imageApplyDiscount = (ImageView) viewInflate.findViewById(R.id.img_apply_discount);
        this.imageAvailableDiscount = (ImageView) viewInflate.findViewById(R.id.img_available_discount);
        this.generalHelper.setImageToImageView("", this.imageApplyDiscount, PWEStaticDataModel.PWEDefaultDiscountIcon);
        this.generalHelper.setImageToImageView("", this.imageAvailableDiscount, PWEStaticDataModel.PWEDefaultDiscountIcon);
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            this.applyCouponCode.setBackground(this.context.getResources().getDrawable(R.drawable.pwe_android_tv_button));
        }
        disableApplyButton();
        this.viewDiscountDivider = viewInflate.findViewById(R.id.view_divider_discount_code);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.image_apply_discount_back);
        TextView textView = (TextView) viewInflate.findViewById(R.id.text_discount_code_apply_error);
        this.tvDiscountCodeApplyError = textView;
        textView.setVisibility(8);
        ListView listView = (ListView) viewInflate.findViewById(R.id.list_discount_codes);
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            listView.setSelector(this.context.getResources().getDrawable(R.drawable.pwe_listview_item_selector));
        }
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.linear_no_data_holder);
        this.linearNoDiscountCodes = linearLayout;
        linearLayout.setVisibility(8);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWEDiscountHelper.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PWEDiscountHelper.this.generalHelper.hideKeyboard(PWEDiscountHelper.this.context, view);
                if (PWEDiscountHelper.this.discountCodePopup == null || !PWEDiscountHelper.this.discountCodePopup.isShowing()) {
                    return;
                }
                PWEDiscountHelper.this.discountCodePopup.dismiss();
            }
        });
        ArrayList<DiscountCodeDataModel> discountCodeList = getDiscountCodeList(this.mode_selected_for_discount);
        if (discountCodeList.size() > 0) {
            this.linearNoDiscountCodes.setVisibility(8);
            PWEDiscountCodeListAdapter pWEDiscountCodeListAdapter = new PWEDiscountCodeListAdapter(context, discountCodeList, this.paymentInfoHandler);
            listView.setAdapter((ListAdapter) pWEDiscountCodeListAdapter);
            pWEDiscountCodeListAdapter.setDiscountCodeListener(new PWEDiscountListener() { // from class: com.easebuzz.payment.kit.PWEDiscountHelper.3
                @Override // listeners.PWEDiscountListener
                public void setBasicPaymentInfo() {
                }

                @Override // listeners.PWEDiscountListener
                public JSONObject validateApplyDiscount(String str) {
                    return null;
                }

                @Override // listeners.PWEDiscountListener
                public void applySelectedDiscountCode(DiscountCodeDataModel discountCodeDataModel, int i) {
                    try {
                        PWEDiscountHelper.this.discount_code = discountCodeDataModel.getDiscount_code();
                        JSONObject jSONObjectValidateApplyDiscount = PWEDiscountHelper.this.discountCodeListener.validateApplyDiscount(PWEDiscountHelper.this.discount_code);
                        if (!jSONObjectValidateApplyDiscount.getBoolean("status")) {
                            PWEDiscountHelper.this.tvDiscountCodeApplyError.setVisibility(0);
                            PWEDiscountHelper.this.tvDiscountCodeApplyError.setText(jSONObjectValidateApplyDiscount.getString("error_message"));
                            return;
                        }
                        PWEDiscountHelper.this.editCouponCode.setText(PWEDiscountHelper.this.discount_code);
                        PWEDiscountHelper.this.bin_number = jSONObjectValidateApplyDiscount.getString("bin_number");
                        PWEDiscountHelper.this.bank_wallet_name = jSONObjectValidateApplyDiscount.getString("bank_wallet_name");
                        PWEDiscountHelper.this.card_id = jSONObjectValidateApplyDiscount.getString("card_id");
                        PWEDiscountHelper.this.applyCoupon();
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            });
        } else {
            this.linearNoDiscountCodes.setVisibility(0);
            listView.setVisibility(8);
        }
        this.applyCouponCode.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWEDiscountHelper.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PWEDiscountHelper.this.generalHelper.hideKeyboard(PWEDiscountHelper.this.context, view);
                PWEDiscountHelper pWEDiscountHelper = PWEDiscountHelper.this;
                pWEDiscountHelper.discount_code = pWEDiscountHelper.editCouponCode.getText().toString();
                JSONObject jSONObjectValidateApplyDiscount = PWEDiscountHelper.this.discountCodeListener.validateApplyDiscount(PWEDiscountHelper.this.discount_code);
                try {
                    if (!jSONObjectValidateApplyDiscount.getBoolean("status")) {
                        PWEDiscountHelper.this.tvDiscountCodeApplyError.setVisibility(0);
                        PWEDiscountHelper.this.tvDiscountCodeApplyError.setText(jSONObjectValidateApplyDiscount.getString("error_message"));
                        return;
                    }
                    PWEDiscountHelper.this.bin_number = jSONObjectValidateApplyDiscount.getString("bin_number");
                    PWEDiscountHelper.this.bank_wallet_name = jSONObjectValidateApplyDiscount.getString("bank_wallet_name");
                    PWEDiscountHelper.this.card_id = jSONObjectValidateApplyDiscount.getString("card_id");
                    PWEDiscountHelper.this.applyCoupon();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        });
        this.editCouponCode.addTextChangedListener(new TextWatcher() { // from class: com.easebuzz.payment.kit.PWEDiscountHelper.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence.toString().isEmpty()) {
                    PWEDiscountHelper.this.disableApplyButton();
                } else {
                    PWEDiscountHelper.this.enableApplyButton();
                }
            }
        });
        this.discountCodePopup.getWindow().setGravity(48);
        this.discountCodePopup.setCancelable(true);
        this.discountCodePopup.show();
    }

    protected void disableApplyButton() {
        this.applyCouponCode.setEnabled(false);
        this.applyCouponCode.setTextColor(this.context.getResources().getColor(R.color.pwe_disable_button_color));
    }

    protected void enableApplyButton() {
        this.applyCouponCode.setEnabled(true);
        this.applyCouponCode.setTextColor(this.context.getResources().getColor(R.color.pwe_discount_apply_coupon_text));
    }

    protected void applyCoupon() {
        this.progressDialog.show();
        ((RetroAPI) new Retrofit.Builder().baseUrl(this.EndPointUrl).addConverterFactory(new ToStringConverterFactory()).build().create(RetroAPI.class)).applyCoupon(this.access_key, this.txn_id, this.mode_selected_for_discount, this.bin_number, this.bank_wallet_name, this.discount_code, this.card_id, getBankCode(), getUpiVA()).enqueue(new Callback<String>() { // from class: com.easebuzz.payment.kit.PWEDiscountHelper.6
            @Override // retrofit2.Callback
            public void onResponse(Call<String> call, Response<String> response) {
                if (PWEDiscountHelper.this.progressDialog != null) {
                    PWEDiscountHelper.this.progressDialog.dismiss();
                }
                try {
                    try {
                        JSONObject jSONObject = new JSONObject(response.body().toString());
                        if (jSONObject.getBoolean("status")) {
                            String string = jSONObject.getString("possible_tdr");
                            JSONObject jSONObject2 = new JSONObject(string).getJSONObject(PWEDiscountHelper.this.mode_selected_for_discount);
                            PWEDiscountHelper.this.discount_type = jSONObject2.getString("offer_type");
                            PWEDiscountHelper.this.pamtHelper.resetAppliedCouponFlag(true, string, PWEDiscountHelper.this.discount_code, PWEDiscountHelper.this.discount_type);
                            PWEDiscountHelper.this.tvDiscountCodeApplyError.setVisibility(8);
                            PWEDiscountHelper.this.showDiscountCodeResultDialog(jSONObject.getString("msg"));
                        } else {
                            String strOptString = "Can not apply discount";
                            if (jSONObject.has("error")) {
                                strOptString = jSONObject.optString("error", "Can not apply discount");
                            } else if (jSONObject.has("msg_desc")) {
                                strOptString = jSONObject.optString("msg_desc", "Can not apply discount");
                            }
                            PWEDiscountHelper.this.generalHelper.showPweToast(strOptString);
                            PWEDiscountHelper.this.tvDiscountCodeApplyError.setVisibility(0);
                            PWEDiscountHelper.this.tvDiscountCodeApplyError.setText(strOptString);
                        }
                        PWEDiscountHelper.this.disableApplyButton();
                    } catch (JSONException unused) {
                        PWEDiscountHelper.this.tvDiscountCodeApplyError.setVisibility(0);
                    }
                    PWEDiscountHelper.this.discountCodeListener.setBasicPaymentInfo();
                } catch (Exception unused2) {
                    PWEDiscountHelper.this.tvDiscountCodeApplyError.setVisibility(0);
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<String> call, Throwable th) {
                if (PWEDiscountHelper.this.progressDialog != null) {
                    PWEDiscountHelper.this.progressDialog.dismiss();
                }
                PWEDiscountHelper.this.generalHelper.showPweToast("Please try again");
                PWEDiscountHelper.this.enableApplyButton();
                PWEDiscountHelper.this.tvDiscountCodeApplyError.setVisibility(0);
                PWEDiscountHelper.this.tvDiscountCodeApplyError.setText("Please try again.");
            }
        });
    }

    protected void showDiscountCodeResultDialog(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        View viewInflate = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.pwe_custom_alert_dialog, (ViewGroup) null);
        builder.setView(viewInflate);
        builder.setCancelable(false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.text_alert_message);
        Button button = (Button) viewInflate.findViewById(R.id.btn_alert_ok);
        Button button2 = (Button) viewInflate.findViewById(R.id.btn_alert_cancel);
        button2.setVisibility(8);
        final AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.show();
        textView.setText(str);
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            button.setBackground(this.context.getResources().getDrawable(R.drawable.pwe_android_tv_button));
            button2.setBackground(this.context.getResources().getDrawable(R.drawable.pwe_android_tv_button));
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWEDiscountHelper.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PWEDiscountHelper.this.discountCodePopup != null && PWEDiscountHelper.this.discountCodePopup.isShowing()) {
                    PWEDiscountHelper.this.discountCodePopup.dismiss();
                }
                alertDialogCreate.dismiss();
            }
        });
    }

    protected String getBankCode() {
        return this.bankCode;
    }

    protected void setBankCode(String str) {
        this.bankCode = str;
    }

    protected String getUpiVA() {
        return this.upiVA;
    }

    protected void setUpiVA(String str) {
        this.upiVA = str;
    }
}
