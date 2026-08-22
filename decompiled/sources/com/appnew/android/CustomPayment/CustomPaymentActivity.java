package com.appnew.android.CustomPayment;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import com.appnew.android.Courses.Fragment.SingleStudy;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.FacebookEventLogger;
import com.appnew.android.Model.BillDesk;
import com.appnew.android.Model.Ccav;
import com.appnew.android.Model.EaseBuzz;
import com.appnew.android.Model.Extras;
import com.appnew.android.Model.FonePay;
import com.appnew.android.Model.Paytm;
import com.appnew.android.Model.Rzp;
import com.appnew.android.Model.customPayment.CourseItemsCustomPayment;
import com.appnew.android.Model.customPayment.ModelCourseCustomPayment;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Payment.Credentials;
import com.appnew.android.Payment.PaymentGatewayListener;
import com.appnew.android.Payment.PaymentViewModel;
import com.appnew.android.Payment.PreferencesUtil;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Theme.DashboardActivityTheme1;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.PaymentTypeCheck;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.UpdateProfileDialogUtils;
import com.appnew.android.databinding.ActivityCustomPaymentBinding;
import com.appnew.android.databinding.DialogSearchableSpinnerBinding;
import com.appnew.android.pojo.Userinfo.Data;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes6.dex */
public class CustomPaymentActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack, PaymentTypeCheck, PaymentResultListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static String pre_transaction_id = "";
    static String razorkey = "";
    Activity activity;
    String amt;
    ActivityCustomPaymentBinding binding;
    private Dialog dialog;
    long mLastClickTime_frame5;
    NetworkCall networkCall;
    PaymentViewModel paymentViewModel;
    String rid;
    CourseItemsCustomPayment selected;
    private ArrayList<CourseItemsCustomPayment> arrayList = new ArrayList<>();
    private ArrayList<String> modelCourses = new ArrayList<>();
    private String course_id = "";
    String maincouseid = "";
    String calculatedTax = "";
    private String pre_txtid = "";
    boolean isfailure = false;
    String pos_txn_id = "";
    String tx_status = "0";
    String remark = "";
    String scd = "";
    private String price = "100";
    private String id = "";
    private String post_txt = "";
    long mLastClickTime = 0;

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    @Override // com.appnew.android.Utils.PaymentTypeCheck
    public void onPaymentTypeCancel() {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookEventLogger.logFbSdkInitialize(this);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        ActivityCustomPaymentBinding activityCustomPaymentBindingInflate = ActivityCustomPaymentBinding.inflate(getLayoutInflater());
        this.binding = activityCustomPaymentBindingInflate;
        setContentView(activityCustomPaymentBindingInflate.getRoot());
        this.activity = this;
        this.networkCall = new NetworkCall(this, this);
        PaymentViewModel paymentViewModel = (PaymentViewModel) new ViewModelProvider(this).get(PaymentViewModel.class);
        this.paymentViewModel = paymentViewModel;
        paymentViewModel.initPaymentGateway(this, new PaymentGatewayListener() { // from class: com.appnew.android.CustomPayment.CustomPaymentActivity.1
            @Override // com.appnew.android.Payment.PaymentGatewayListener
            public void onSuccessEsewa(String productId, String totalAmount, String referenceId, String scdId) {
                CustomPaymentActivity.this.pos_txn_id = productId;
                CustomPaymentActivity.this.amt = totalAmount;
                CustomPaymentActivity.this.rid = referenceId;
                CustomPaymentActivity.this.scd = scdId;
                CustomPaymentActivity.this.networkCall.NetworkAPICall(API.int_payment, "", true, false);
            }

            @Override // com.appnew.android.Payment.PaymentGatewayListener
            public void onSuccess(String posTxnId) {
                CustomPaymentActivity.this.pos_txn_id = posTxnId;
                CustomPaymentActivity.this.networkCall.NetworkAPICall(API.int_payment, "", true, false);
            }

            @Override // com.appnew.android.Payment.PaymentGatewayListener
            public void onFailed(boolean isFailure) {
                CustomPaymentActivity.this.OnPaymentError();
            }
        }, this.maincouseid);
        this.networkCall.NetworkAPICall(API.API_get_paid_course, "", true, false);
        this.binding.imageBack.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.CustomPayment.CustomPaymentActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$0();
            }
        }));
        if (getIntent() != null) {
            this.maincouseid = getIntent().getStringExtra("courseid");
        }
        this.binding.courseTxt.setOnClickListener(new AnonymousClass2());
        this.binding.buttonProceed.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.CustomPayment.CustomPaymentActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$0() {
        finish();
        return null;
    }

    /* JADX INFO: renamed from: com.appnew.android.CustomPayment.CustomPaymentActivity$2, reason: invalid class name */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            CustomPaymentActivity.this.dialog = new Dialog(CustomPaymentActivity.this);
            DialogSearchableSpinnerBinding dialogSearchableSpinnerBindingInflate = DialogSearchableSpinnerBinding.inflate(CustomPaymentActivity.this.getLayoutInflater());
            CustomPaymentActivity.this.dialog.setContentView(dialogSearchableSpinnerBindingInflate.getRoot());
            CustomPaymentActivity.this.dialog.getWindow().setLayout(ProgressIndicatorKt.SecondLineHeadDelay, 800);
            CustomPaymentActivity.this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            CustomPaymentActivity.this.dialog.show();
            CustomPaymentActivity customPaymentActivity = CustomPaymentActivity.this;
            final ArrayAdapter arrayAdapter = new ArrayAdapter(customPaymentActivity, R.layout.simple_list_item_1, customPaymentActivity.modelCourses);
            dialogSearchableSpinnerBindingInflate.listView.setAdapter((ListAdapter) arrayAdapter);
            dialogSearchableSpinnerBindingInflate.editText.addTextChangedListener(new TextWatcher() { // from class: com.appnew.android.CustomPayment.CustomPaymentActivity.2.1
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    arrayAdapter.getFilter().filter(s);
                }
            });
            dialogSearchableSpinnerBindingInflate.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.appnew.android.CustomPayment.CustomPaymentActivity$2$$ExternalSyntheticLambda0
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                    this.f$0.lambda$onClick$0(arrayAdapter, adapterView, view, i, j);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onClick$0(ArrayAdapter arrayAdapter, AdapterView adapterView, View view, int i, long j) {
            CustomPaymentActivity.this.binding.courseTxt.setText((CharSequence) arrayAdapter.getItem(i));
            CustomPaymentActivity customPaymentActivity = CustomPaymentActivity.this;
            customPaymentActivity.course_id = ((CourseItemsCustomPayment) customPaymentActivity.arrayList.get(i)).getId();
            CustomPaymentActivity customPaymentActivity2 = CustomPaymentActivity.this;
            customPaymentActivity2.selected = (CourseItemsCustomPayment) customPaymentActivity2.arrayList.get(i);
            CustomPaymentActivity.this.dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        if (!this.binding.amt.getText().toString().trim().isEmpty()) {
            if (!this.binding.courseTxt.getText().toString().trim().equalsIgnoreCase("Select Course")) {
                if (!this.binding.remark.getText().toString().trim().isEmpty()) {
                    API_INIT_PAYMENT(this.binding.amt.getText().toString().trim(), this.course_id, this.binding.remark.getText().toString().trim());
                    return;
                } else {
                    Helper.showToast(this.activity, "Please  write remarks!", 1);
                    return;
                }
            }
            Helper.showToast(this.activity, "Please select any course!", 1);
            return;
        }
        Helper.showToast(this.activity, "Please enter amount!", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OnPaymentError() {
        try {
            this.isfailure = true;
            this.networkCall.NetworkAPICall(API.int_payment, "", true, false);
        } catch (Exception unused) {
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (apitype.equals(API.API_get_paid_course)) {
            return service.getPaidCourse();
        }
        if (!apitype.equals(API.int_payment)) {
            return null;
        }
        Extras extras = new Extras();
        extras.setCourse_id(this.course_id);
        extras.setRemark(this.remark);
        if (this.isfailure) {
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setType("2");
            encryptionData.setCourse_id(this.maincouseid);
            encryptionData.setParent_id("");
            encryptionData.setPre_transaction_id(this.pre_txtid);
            encryptionData.setTransaction_status("2");
            encryptionData.setPost_transaction_id("");
            encryptionData.setExtras(extras);
            return service.int_payment(AES.encrypt(new Gson().toJson(encryptionData)));
        }
        if (this.pos_txn_id.equalsIgnoreCase("")) {
            EncryptionData encryptionData2 = new EncryptionData();
            encryptionData2.setType("1");
            encryptionData2.setCourse_id(this.maincouseid);
            encryptionData2.setExtras(extras);
            encryptionData2.setCourse_price(this.price);
            encryptionData2.setParent_id("");
            encryptionData2.setTax(this.calculatedTax);
            encryptionData2.setPay_via(this.paymentViewModel.getPayVia());
            encryptionData2.setCoupon_applied("0");
            return service.int_payment(AES.encrypt(new Gson().toJson(encryptionData2)));
        }
        EncryptionData encryptionData3 = new EncryptionData();
        encryptionData3.setType("2");
        encryptionData3.setCourse_id(this.maincouseid);
        encryptionData3.setExtras(extras);
        encryptionData3.setParent_id("");
        encryptionData3.setPre_transaction_id(this.pre_txtid);
        encryptionData3.setTransaction_status("1");
        encryptionData3.setPost_transaction_id(this.pos_txn_id);
        return service.int_payment(AES.encrypt(new Gson().toJson(encryptionData3)));
    }

    private void API_INIT_PAYMENT(String price, String id, String remark) {
        Ccav ccav;
        Paytm paytm2;
        Rzp rzp;
        this.price = price;
        this.id = id;
        this.remark = remark;
        this.calculatedTax = String.valueOf((Float.parseFloat(price) * 18.0f) / 100.0f);
        this.price = String.valueOf(Float.parseFloat(price) - Float.parseFloat(this.calculatedTax));
        NetworkCall networkCall = new NetworkCall(this, this);
        ArrayList arrayList = new ArrayList();
        try {
            String stringPreference = PreferencesUtil.INSTANCE.getStringPreference(this, Credentials.RZP);
            String stringPreference2 = PreferencesUtil.INSTANCE.getStringPreference(this, Credentials.PAYTM);
            String stringPreference3 = PreferencesUtil.INSTANCE.getStringPreference(this, Credentials.CCAV);
            if (stringPreference != null && !stringPreference.isEmpty() && (rzp = (Rzp) new Gson().fromJson(stringPreference, Rzp.class)) != null && rzp.getStatus() != null && rzp.getStatus().equalsIgnoreCase("1")) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("name", Credentials.RZP);
                jsonObject.addProperty("mode_name", getString(com.eduteria.app.app.R.string.razorpay));
                arrayList.add(jsonObject);
            }
            if (stringPreference2 != null && !stringPreference2.isEmpty() && (paytm2 = (Paytm) new Gson().fromJson(stringPreference2, Paytm.class)) != null && paytm2.getStatus() != null && paytm2.getStatus().equalsIgnoreCase("1")) {
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("name", Credentials.PAYTM);
                jsonObject2.addProperty("mode_name", getString(com.eduteria.app.app.R.string.f577paytm));
                arrayList.add(jsonObject2);
            }
            if (stringPreference3 != null && !stringPreference3.isEmpty() && (ccav = (Ccav) new Gson().fromJson(stringPreference3, Ccav.class)) != null && ccav.getStatus() != null && ccav.getStatus().equals("1")) {
                JsonObject jsonObject3 = new JsonObject();
                jsonObject3.addProperty("name", Credentials.CCAV);
                jsonObject3.addProperty("mode_name", getString(com.eduteria.app.app.R.string.ccavenue));
                arrayList.add(jsonObject3);
            }
            JSONObject jSONObject = new JSONObject();
            if (arrayList.size() > 1) {
                Helper.callPaymentTypeDialog(this, arrayList, this, jSONObject);
                return;
            }
            if (arrayList.size() == 1) {
                String asString = ((JsonObject) arrayList.get(0)).get("name").getAsString();
                if (asString.equals(Credentials.RZP)) {
                    if (stringPreference != null && !stringPreference.isEmpty()) {
                        this.paymentViewModel.setPayVia("3");
                    }
                } else if (asString.equals(Credentials.PAYTM)) {
                    if (stringPreference2 != null && !stringPreference2.isEmpty()) {
                        this.paymentViewModel.setPayVia("6");
                    }
                } else if (asString.equals(Credentials.CCAV) && stringPreference3 != null && !stringPreference3.isEmpty()) {
                    this.paymentViewModel.setPayVia("7");
                }
                networkCall.NetworkAPICall(API.int_payment, "", true, false);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.appnew.android.Utils.PaymentTypeCheck
    public void onPaymentType(String mode, JSONObject data) {
        String stringPreference = PreferencesUtil.INSTANCE.getStringPreference(this, Credentials.RZP);
        String stringPreference2 = PreferencesUtil.INSTANCE.getStringPreference(this, Credentials.PAYTM);
        String stringPreference3 = PreferencesUtil.INSTANCE.getStringPreference(this, Credentials.CCAV);
        String stringPreference4 = PreferencesUtil.INSTANCE.getStringPreference(this.activity, Credentials.FONEPAY);
        String stringPreference5 = PreferencesUtil.INSTANCE.getStringPreference(this.activity, Credentials.EASEBUZZ);
        String stringPreference6 = PreferencesUtil.INSTANCE.getStringPreference(this.activity, Credentials.BILLDESK);
        if (mode.equals(Credentials.RZP)) {
            if (stringPreference != null && !stringPreference.isEmpty()) {
                this.paymentViewModel.setPayVia("3");
            }
        } else if (mode.equals(Credentials.PAYTM)) {
            if (stringPreference2 != null && !stringPreference2.isEmpty()) {
                this.paymentViewModel.setPayVia("6");
            }
        } else if (mode.equals(Credentials.CCAV)) {
            if (stringPreference3 != null && !stringPreference3.isEmpty()) {
                this.paymentViewModel.setPayVia("7");
            }
        } else if (mode.equals(Credentials.FONEPAY)) {
            if (stringPreference4 != null && !stringPreference4.isEmpty()) {
                this.paymentViewModel.setPayVia("8");
            }
        } else if (mode.equals(Credentials.EASEBUZZ)) {
            if (stringPreference5 != null && !stringPreference5.isEmpty()) {
                this.paymentViewModel.setPayVia("9");
            }
        } else if (mode.equals(Credentials.BILLDESK) && stringPreference6 != null && !stringPreference6.isEmpty()) {
            this.paymentViewModel.setPayVia("11");
        }
        this.networkCall.NetworkAPICall(API.int_payment, "", true, false);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals(API.API_get_paid_course)) {
            if (jsonstring.optString("status").equals("true")) {
                ModelCourseCustomPayment modelCourseCustomPayment = (ModelCourseCustomPayment) new Gson().fromJson(jsonstring.toString(), ModelCourseCustomPayment.class);
                if (modelCourseCustomPayment.isStatus()) {
                    this.arrayList = (ArrayList) modelCourseCustomPayment.getCourses();
                } else {
                    Toast.makeText(this, "" + modelCourseCustomPayment.getMessage(), 0).show();
                }
                this.modelCourses.clear();
                Iterator<CourseItemsCustomPayment> it = this.arrayList.iterator();
                while (it.hasNext()) {
                    this.modelCourses.add(it.next().getTitle());
                }
                return;
            }
            ErrorCallBack(jsonstring.getString("message"), apitype, typeApi);
            RetrofitResponse.GetApiData(this.activity, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
            return;
        }
        if (apitype.equals(API.int_payment)) {
            try {
                if (jsonstring.optBoolean("status")) {
                    if (this.isfailure) {
                        this.isfailure = false;
                        this.pos_txn_id = "";
                        return;
                    }
                    if (this.pos_txn_id.equalsIgnoreCase("")) {
                        JSONObject jSONObject = jsonstring.getJSONObject("data");
                        if (this.paymentViewModel.getPayVia().equalsIgnoreCase("3")) {
                            paymentGateways(jSONObject, Credentials.RZP);
                            return;
                        }
                        if (this.paymentViewModel.getPayVia().equalsIgnoreCase("6")) {
                            paymentGateways(jSONObject, Credentials.PAYTM);
                            return;
                        }
                        if (this.paymentViewModel.getPayVia().equalsIgnoreCase("7")) {
                            paymentGateways(jSONObject, Credentials.CCAV);
                            return;
                        }
                        if (this.paymentViewModel.getPayVia().equalsIgnoreCase("8")) {
                            paymentGateways(jSONObject, Credentials.FONEPAY);
                            return;
                        } else if (this.paymentViewModel.getPayVia().equalsIgnoreCase("9")) {
                            paymentGateways(jSONObject, Credentials.EASEBUZZ);
                            return;
                        } else {
                            if (this.paymentViewModel.getPayVia().equalsIgnoreCase("11")) {
                                paymentGateways(jSONObject, Credentials.BILLDESK);
                                return;
                            }
                            return;
                        }
                    }
                    if (!SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                        UtkashRoom.getAppDatabase(MakeMyExam.getAppContext()).getCourseDetaildata().deletecoursedetail(SingleStudy.parentCourseId, MakeMyExam.userId);
                    } else if (!this.selected.getId().equalsIgnoreCase("")) {
                        UtkashRoom.getAppDatabase(MakeMyExam.getAppContext()).getCourseDetaildata().deletecoursedetail(this.selected.getId(), MakeMyExam.userId);
                    }
                    logBuySuccessEvent(this, this.selected.getTitle());
                    if (Helper.isNewLoginFlow()) {
                        showUpdateStatePopup();
                    } else {
                        success_dailog();
                    }
                    Toast.makeText(this, "" + jsonstring.optString("message"), 0).show();
                    return;
                }
                if (this.isfailure) {
                    this.isfailure = false;
                    this.pos_txn_id = "";
                }
                RetrofitResponse.GetApiData(this, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void paymentGateways(JSONObject data, String mode) {
        BillDesk billDesk;
        EaseBuzz easeBuzz;
        FonePay fonePay;
        Ccav ccav;
        Paytm paytm2;
        Rzp rzp;
        try {
            this.pre_txtid = data.optString(Const.COURSE_INIT_PAYMENT_TOKEN);
            String stringPreference = PreferencesUtil.INSTANCE.getStringPreference(this, Credentials.RZP);
            String stringPreference2 = PreferencesUtil.INSTANCE.getStringPreference(this, Credentials.PAYTM);
            String stringPreference3 = PreferencesUtil.INSTANCE.getStringPreference(this, Credentials.CCAV);
            String stringPreference4 = PreferencesUtil.INSTANCE.getStringPreference(this.activity, Credentials.FONEPAY);
            String stringPreference5 = PreferencesUtil.INSTANCE.getStringPreference(this.activity, Credentials.EASEBUZZ);
            String stringPreference6 = PreferencesUtil.INSTANCE.getStringPreference(this.activity, Credentials.BILLDESK);
            if (mode.equals(Credentials.RZP)) {
                if (stringPreference == null || stringPreference.isEmpty() || (rzp = (Rzp) new Gson().fromJson(stringPreference, Rzp.class)) == null || rzp.getStatus() == null || !rzp.getStatus().equalsIgnoreCase("1")) {
                    return;
                }
                razorkey = rzp.getKey();
                launch_paymentGateway();
                return;
            }
            if (mode.equals(Credentials.PAYTM)) {
                if (stringPreference2 == null || stringPreference2.isEmpty() || (paytm2 = (Paytm) new Gson().fromJson(stringPreference2, Paytm.class)) == null || paytm2.getStatus() == null || !paytm2.getStatus().equalsIgnoreCase("1")) {
                    return;
                }
                this.paymentViewModel.launchPaytmPaymentGateway(this.pre_txtid, Math.round(Float.parseFloat(this.price) + Float.parseFloat(this.calculatedTax)), data.optString("txnToken"), paytm2.getSecret(), paytm2.getUrl());
                return;
            }
            if (mode.equals(Credentials.CCAV)) {
                if (stringPreference3 == null || stringPreference3.isEmpty() || (ccav = (Ccav) new Gson().fromJson(stringPreference3, Ccav.class)) == null || ccav.getStatus() == null || !ccav.getStatus().equalsIgnoreCase("1")) {
                    return;
                }
                this.paymentViewModel.launchCcAvenuePaymentGateway(this.pre_txtid, Math.round(Float.parseFloat(this.price) + Float.parseFloat(this.calculatedTax)), data.optString("txnToken"), ccav.getSecret(), ccav.getRedirect_url(), ccav.getCancel_url(), ccav.getAndroid_url());
                return;
            }
            if (mode.equals(Credentials.FONEPAY)) {
                if (stringPreference4 == null || stringPreference4.isEmpty() || (fonePay = (FonePay) new Gson().fromJson(stringPreference4, FonePay.class)) == null || fonePay.getStatus() == null || !fonePay.getStatus().equalsIgnoreCase("1")) {
                    return;
                }
                this.paymentViewModel.launchFonePayPaymentGateway(data.optString("txnToken"), Math.round(Float.parseFloat(this.price) + Float.parseFloat(this.calculatedTax)));
                return;
            }
            if (mode.equals(Credentials.EASEBUZZ)) {
                if (stringPreference5 == null || stringPreference5.isEmpty() || (easeBuzz = (EaseBuzz) new Gson().fromJson(stringPreference5, EaseBuzz.class)) == null || easeBuzz.getStatus() == null || !easeBuzz.getStatus().equalsIgnoreCase("1")) {
                    return;
                }
                this.paymentViewModel.launchEaseBuzzPaymentGateway(data.optString("txnToken"), Math.round(Float.parseFloat(this.price) + Float.parseFloat(this.calculatedTax)), easeBuzz.getMode());
                return;
            }
            if (!mode.equals(Credentials.BILLDESK) || stringPreference6 == null || stringPreference6.isEmpty() || (billDesk = (BillDesk) new Gson().fromJson(stringPreference6, BillDesk.class)) == null || billDesk.getStatus() == null || !billDesk.getStatus().equalsIgnoreCase("1")) {
                return;
            }
            this.paymentViewModel.launchBillDeskPaymentGateway(data.optString("txnToken"), Math.round(Float.parseFloat(this.price) + Float.parseFloat(this.calculatedTax)));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void success_dailog() {
        try {
            if (SystemClock.elapsedRealtime() - this.mLastClickTime_frame5 < 1000) {
                return;
            }
            this.mLastClickTime_frame5 = SystemClock.elapsedRealtime();
            final Dialog dialog = new Dialog(this);
            dialog.requestWindowFeature(1);
            dialog.setContentView(com.eduteria.app.app.R.layout.success_dialog);
            dialog.getWindow().setSoftInputMode(16);
            getWindow().setSoftInputMode(3);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.getWindow().setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.9d), -2);
            dialog.getWindow().setGravity(17);
            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);
            EditText editText = (EditText) dialog.findViewById(com.eduteria.app.app.R.id.et_order_id);
            EditText editText2 = (EditText) dialog.findViewById(com.eduteria.app.app.R.id.et_transaction_id);
            TextView textView = (TextView) dialog.findViewById(com.eduteria.app.app.R.id.course_name);
            editText.setText(this.pre_txtid);
            editText2.setText(this.pos_txn_id);
            textView.setText(this.selected.getTitle());
            Button button = (Button) dialog.findViewById(com.eduteria.app.app.R.id.btn_my_course);
            button.setText(getResources().getString(com.eduteria.app.app.R.string.goto_home_page));
            button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.CustomPayment.CustomPaymentActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$success_dailog$2(view);
                }
            });
            dialog.show();
            dialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.appnew.android.CustomPayment.CustomPaymentActivity.3
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    dialog.dismiss();
                    dialog.cancel();
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$success_dailog$2(View view) {
        Intent intent = new Intent(this, (Class<?>) DashboardActivityTheme1.class);
        intent.setFlags(67141632);
        Helper.gotoActivity_finish(intent, this);
    }

    public void logBuySuccessEvent(Context context, String bookTitle) {
        String loggedInUserInfo = Helper.getLoggedInUserInfo(context);
        Bundle bundle = new Bundle();
        bundle.putString("user_info", loggedInUserInfo);
        bundle.putString("booktype", "paid");
        bundle.putString("bookname", bookTitle);
        FacebookEventLogger.logEvent(context, "BuyPaidBook", bundle);
    }

    private void launch_paymentGateway() {
        Checkout checkout = new Checkout();
        checkout.setKeyID(razorkey);
        checkout.setImage(com.eduteria.app.app.R.mipmap.ic_launcher);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", getString(com.eduteria.app.app.R.string.payment_gateway_name));
            jSONObject.put("theme.color", ContextCompat.getColor(this, com.eduteria.app.app.R.color.theme_and_header_color));
            jSONObject.put("description", this.selected.getTitle() + " #(" + (!SingleStudy.parentCourseId.equalsIgnoreCase("") ? SingleStudy.parentCourseId : this.course_id) + ")");
            jSONObject.put(FirebaseAnalytics.Param.CURRENCY, "INR");
            jSONObject.put("image", this.selected.getDescHeaderImage());
            jSONObject.put("order_id", this.pre_txtid);
            jSONObject.put("amount", Math.round((Float.parseFloat(this.price) + Float.parseFloat(this.calculatedTax)) * 100.0f));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("email", "true");
            jSONObject2.put("contact", "true");
            jSONObject.put("readonly", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("email", SharedPreference.getInstance().getLoggedInUser().getEmail());
            jSONObject3.put("contact", SharedPreference.getInstance().getLoggedInUser().getMobile());
            jSONObject.put("prefill", jSONObject3);
            checkout.open(this, jSONObject);
        } catch (Exception e2) {
            e2.toString();
        }
    }

    @Override // com.razorpay.PaymentResultListener
    public void onPaymentSuccess(String s) {
        this.pos_txn_id = s;
        this.networkCall.NetworkAPICall(API.int_payment, "", true, false);
    }

    @Override // com.razorpay.PaymentResultListener
    public void onPaymentError(int i, String s) {
        this.tx_status = "" + i;
        this.isfailure = true;
        this.networkCall.NetworkAPICall(API.int_payment, "", true, false);
    }

    public void showUpdateStatePopup() {
        UpdateProfileDialogUtils.makeDialogForStateUpdate(this, false, new UpdateProfileDialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.CustomPayment.CustomPaymentActivity.4
            /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
            
                if (r9.equals("1") != false) goto L15;
             */
            @Override // com.appnew.android.Utils.UpdateProfileDialogUtils.onDialogUtilsOkClick
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void onOKClick(android.app.Dialog r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12) {
                /*
                    r7 = this;
                    long r0 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Exception -> L4b
                    com.appnew.android.CustomPayment.CustomPaymentActivity r2 = com.appnew.android.CustomPayment.CustomPaymentActivity.this     // Catch: java.lang.Exception -> L4b
                    long r2 = r2.mLastClickTime     // Catch: java.lang.Exception -> L4b
                    long r0 = r0 - r2
                    r2 = 1000(0x3e8, double:4.94E-321)
                    int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r0 >= 0) goto L10
                    return
                L10:
                    com.appnew.android.CustomPayment.CustomPaymentActivity r0 = com.appnew.android.CustomPayment.CustomPaymentActivity.this     // Catch: java.lang.Exception -> L4b
                    long r1 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Exception -> L4b
                    r0.mLastClickTime = r1     // Catch: java.lang.Exception -> L4b
                    int r0 = r9.hashCode()     // Catch: java.lang.Exception -> L4b
                    r1 = 49
                    if (r0 == r1) goto L2f
                    r1 = 50
                    if (r0 == r1) goto L26
                L24:
                    r2 = r8
                    goto L42
                L26:
                    java.lang.String r0 = "2"
                    boolean r0 = r9.equals(r0)     // Catch: java.lang.Exception -> L4b
                    if (r0 == 0) goto L24
                    goto L37
                L2f:
                    java.lang.String r0 = "1"
                    boolean r0 = r9.equals(r0)     // Catch: java.lang.Exception -> L4b
                    if (r0 == 0) goto L24
                L37:
                    com.appnew.android.CustomPayment.CustomPaymentActivity r1 = com.appnew.android.CustomPayment.CustomPaymentActivity.this     // Catch: java.lang.Exception -> L4b
                    r2 = r8
                    r3 = r9
                    r4 = r10
                    r5 = r11
                    r6 = r12
                    r1.submitUpdateStateData(r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L4b
                    return
                L42:
                    r2.dismiss()     // Catch: java.lang.Exception -> L4b
                    com.appnew.android.CustomPayment.CustomPaymentActivity r8 = com.appnew.android.CustomPayment.CustomPaymentActivity.this     // Catch: java.lang.Exception -> L4b
                    r8.finishPayment()     // Catch: java.lang.Exception -> L4b
                    return
                L4b:
                    r0 = move-exception
                    r8 = r0
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder
                    java.lang.String r10 = "makeDialog: "
                    r9.<init>(r10)
                    java.lang.String r8 = r8.getMessage()
                    java.lang.StringBuilder r8 = r9.append(r8)
                    java.lang.String r8 = r8.toString()
                    java.lang.String r9 = "Dialog"
                    android.util.Log.d(r9, r8)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.CustomPayment.CustomPaymentActivity.AnonymousClass4.onOKClick(android.app.Dialog, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
            }
        });
    }

    public void submitUpdateStateData(final Dialog dialog, String submitType, final String stateId, final String districtId, String addressJson) {
        if (Helper.isNetworkConnected(this)) {
            Helper.showProgressDialog(this);
            APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
            EncryptionData encryptionData = new EncryptionData();
            if (submitType.equals("1")) {
                encryptionData.setState(stateId);
            } else {
                encryptionData.setState(stateId);
                encryptionData.setAddress(addressJson);
            }
            aPIInterface.updateprofile(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new Callback<String>() { // from class: com.appnew.android.CustomPayment.CustomPaymentActivity.5
                @Override // retrofit2.Callback
                public void onResponse(Call<String> call, Response<String> response) {
                    Helper.dismissProgressDialog();
                    try {
                        if (response.body() != null) {
                            JSONObject jSONObject = new JSONObject(AES.decrypt(response.body(), AES.generatekeyAPI(), AES.generateVectorAPI()));
                            Data loggedInUser = SharedPreference.getInstance().getLoggedInUser();
                            loggedInUser.setState(stateId);
                            loggedInUser.setCity(districtId);
                            SharedPreference.getInstance().setLoggedInUserr(loggedInUser);
                            Toast.makeText(CustomPaymentActivity.this, jSONObject.getString("message"), 1).show();
                            dialog.dismiss();
                            CustomPaymentActivity.this.finishPayment();
                        }
                    } catch (Exception e2) {
                        Log.d("Dialog", "onResponse: " + e2.getMessage());
                    }
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<String> call, Throwable t) {
                    Helper.dismissProgressDialog();
                    CustomPaymentActivity customPaymentActivity = CustomPaymentActivity.this;
                    Toast.makeText(customPaymentActivity, customPaymentActivity.getResources().getString(com.eduteria.app.app.R.string.something_went_wrong), 1).show();
                }
            });
            return;
        }
        Toast.makeText(this, getResources().getString(com.eduteria.app.app.R.string.Retry_with_Internet_connection), 1).show();
    }

    public void finishPayment() {
        Intent intent = new Intent(this, (Class<?>) DashboardActivityTheme1.class);
        intent.setFlags(67141632);
        Helper.gotoActivity_finish(intent, this);
    }
}
