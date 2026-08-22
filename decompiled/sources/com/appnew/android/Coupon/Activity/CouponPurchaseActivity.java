package com.appnew.android.Coupon.Activity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.appnew.android.Coupon.Models.CoursesCoupon;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.FacebookEventLogger;
import com.appnew.android.Model.BillDesk;
import com.appnew.android.Model.Ccav;
import com.appnew.android.Model.EaseBuzz;
import com.appnew.android.Model.EasyPay;
import com.appnew.android.Model.FonePay;
import com.appnew.android.Model.Paytm;
import com.appnew.android.Model.Rzp;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Payment.Credentials;
import com.appnew.android.Payment.PaymentGatewayListener;
import com.appnew.android.Payment.PaymentViewModel;
import com.appnew.android.Payment.PreferencesUtil;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.PaymentTypeCheck;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.UpdateProfileDialogUtils;
import com.appnew.android.cleverTap.AnalyticHelper;
import com.appnew.android.pojo.Userinfo.Data;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.eduteria.app.app.R;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.gson.Gson;
import com.makeramen.roundedimageview.RoundedImageView;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;
import com.tv9news.utils.helpers.AnalyticEvents;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes6.dex */
public class CouponPurchaseActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack, PaymentTypeCheck, PaymentResultListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    String amt;
    TextView coupon_applied;
    TextView coursenameTV;
    CoursesCoupon coursesCoupon;
    String discount;
    String id;
    RoundedImageView imageIV;
    ImageView img_back;
    long mLastClickTime_frame5;
    NetworkCall networkCall;
    PaymentViewModel paymentViewModel;
    Button procceed;
    String rid;
    TextView tax_value;
    RelativeLayout taxes_layout;
    TextView txtAmountValue;
    TextView txtGrandTotalValue;
    TextView txtPriceValue;
    TextView txtPricesValue;
    TextView txtTaxValue;
    TextView validityTV;
    String pos_txn_id = "";
    String pre_txtid = "";
    String tx_status = "0";
    String scd = "";
    boolean isfailure = false;
    private String txnToken = "";
    String enc_val = "";
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
        setContentView(R.layout.activity_coupon_purchase);
        this.networkCall = new NetworkCall(this, this);
        getIntentData();
        initViews();
        PaymentViewModel paymentViewModel = (PaymentViewModel) new ViewModelProvider(this).get(PaymentViewModel.class);
        this.paymentViewModel = paymentViewModel;
        paymentViewModel.initPaymentGateway(this, new PaymentGatewayListener() { // from class: com.appnew.android.Coupon.Activity.CouponPurchaseActivity.1
            @Override // com.appnew.android.Payment.PaymentGatewayListener
            public void onSuccessEsewa(String productId, String totalAmount, String referenceId, String scdId) {
                CouponPurchaseActivity.this.pos_txn_id = productId;
                CouponPurchaseActivity.this.amt = totalAmount;
                CouponPurchaseActivity.this.rid = referenceId;
                CouponPurchaseActivity.this.scd = scdId;
                CouponPurchaseActivity.this.networkCall.NetworkAPICall(API.int_payment, "", true, false);
            }

            @Override // com.appnew.android.Payment.PaymentGatewayListener
            public void onSuccess(String posTxnId) {
                CouponPurchaseActivity.this.pos_txn_id = posTxnId;
                CouponPurchaseActivity.this.networkCall.NetworkAPICall(API.int_payment, "", true, false);
            }

            @Override // com.appnew.android.Payment.PaymentGatewayListener
            public void onFailed(boolean isFailure) {
                CouponPurchaseActivity.this.OnPaymentError();
            }
        }, this.coursesCoupon.getId());
    }

    private void getIntentData() {
        if (getIntent() == null || !getIntent().hasExtra(Const.COURSE_DATA)) {
            return;
        }
        this.coursesCoupon = (CoursesCoupon) getIntent().getSerializableExtra(Const.COURSE_DATA);
        this.discount = getIntent().getStringExtra("discount");
        this.id = getIntent().getStringExtra("id");
    }

    private void initViews() {
        this.imageIV = (RoundedImageView) findViewById(R.id.imageIV);
        this.coursenameTV = (TextView) findViewById(R.id.coursenameTV);
        this.txtPriceValue = (TextView) findViewById(R.id.txtPriceValue);
        this.txtGrandTotalValue = (TextView) findViewById(R.id.txtGrandTotalValue);
        this.coupon_applied = (TextView) findViewById(R.id.coupon_applied);
        this.tax_value = (TextView) findViewById(R.id.tax_value);
        this.procceed = (Button) findViewById(R.id.procceed);
        this.img_back = (ImageView) findViewById(R.id.image_back);
        this.txtTaxValue = (TextView) findViewById(R.id.txtTaxValue);
        this.validityTV = (TextView) findViewById(R.id.validityTV);
        this.txtAmountValue = (TextView) findViewById(R.id.txtAmountValue);
        this.txtPricesValue = (TextView) findViewById(R.id.txtPricesValue);
        this.taxes_layout = (RelativeLayout) findViewById(R.id.taxes_layout);
        View viewFindViewById = findViewById(R.id.root);
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        if (Build.VERSION.SDK_INT == 36) {
            EdgeToEdgeHelperOld.applyHeaderWithToolbar(this, getWindow(), viewFindViewById, toolbar);
        }
        Glide.with((FragmentActivity) this).load(this.coursesCoupon.getCover_image()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.course_placeholder).error(R.mipmap.course_placeholder)).into(this.imageIV);
        this.coursenameTV.setText(this.coursesCoupon.getTitle());
        this.validityTV.setText(getResources().getString(R.string.validity_) + this.coursesCoupon.getValidity());
        if (!this.discount.contains("INR")) {
            this.coupon_applied.setText(getResources().getString(R.string.coupon_applied_) + this.discount.split(" ")[0] + " " + this.discount.split(" ")[1] + ")");
        } else {
            this.coupon_applied.setText(getResources().getString(R.string.coupon_applied_) + this.discount + ")");
        }
        this.tax_value.setText("- ₹ " + Float.parseFloat(this.coursesCoupon.getDiscount()));
        float f2 = Float.parseFloat(this.coursesCoupon.getMrp()) + Float.parseFloat(this.coursesCoupon.getTax());
        float f3 = Float.parseFloat(this.coursesCoupon.getDiscount()) + f2;
        this.txtPriceValue.setText("₹ " + f3);
        this.txtAmountValue.setText("₹ " + f2);
        if (Float.parseFloat(this.coursesCoupon.getDiscount()) >= f3) {
            this.txtPricesValue.setText("₹ 0");
            this.txtTaxValue.setText("₹ 0");
            this.txtGrandTotalValue.setText("₹ 0");
            this.taxes_layout.setVisibility(8);
        } else {
            this.txtTaxValue.setText("+ ₹ " + Float.parseFloat(this.coursesCoupon.getTax()));
            if (TextUtils.isEmpty(this.coursesCoupon.getTax()) || this.coursesCoupon.getTax().equalsIgnoreCase("0") || this.coursesCoupon.getTax().equalsIgnoreCase(IdManager.DEFAULT_VERSION_NAME)) {
                this.taxes_layout.setVisibility(8);
            } else {
                this.taxes_layout.setVisibility(0);
            }
            this.txtPricesValue.setText("₹ " + Float.parseFloat(this.coursesCoupon.getMrp()));
            this.txtGrandTotalValue.setText("₹ " + Float.parseFloat(this.coursesCoupon.getFinal_mrp()));
        }
        if (((int) Float.parseFloat(this.coursesCoupon.getFinal_mrp())) <= 0) {
            this.procceed.setText(getResources().getString(R.string.open_in_my_lib));
        } else {
            this.procceed.setText(getResources().getString(R.string.proceed));
        }
        this.procceed.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Coupon.Activity.CouponPurchaseActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$initViews$0();
            }
        }));
        this.img_back.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Coupon.Activity.CouponPurchaseActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$initViews$1();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0253 A[Catch: Exception -> 0x0314, TryCatch #1 {Exception -> 0x0314, blocks: (B:10:0x004b, B:13:0x0073, B:15:0x0079, B:17:0x008c, B:19:0x0092, B:21:0x009c, B:24:0x00b8, B:26:0x00be, B:28:0x00cd, B:30:0x00d3, B:32:0x00dd, B:34:0x00f4, B:36:0x00fa, B:38:0x0109, B:40:0x010f, B:42:0x0119, B:44:0x0130, B:46:0x0136, B:48:0x0145, B:50:0x014b, B:52:0x0155, B:54:0x016c, B:56:0x0172, B:58:0x0181, B:60:0x0187, B:62:0x0191, B:65:0x01b1, B:67:0x01b7, B:69:0x01ca, B:71:0x01d0, B:73:0x01da, B:78:0x01fd, B:80:0x0203, B:82:0x0216, B:84:0x021c, B:86:0x0226, B:89:0x0247, B:91:0x0253, B:92:0x0258, B:94:0x025e, B:97:0x0275, B:99:0x027b, B:136:0x0308, B:100:0x0284, B:103:0x028c, B:105:0x0292, B:106:0x029b, B:109:0x02a3, B:111:0x02a9, B:112:0x02b1, B:115:0x02b9, B:117:0x02bf, B:118:0x02c7, B:121:0x02cf, B:123:0x02d5, B:124:0x02dd, B:127:0x02e5, B:129:0x02eb, B:130:0x02f3, B:133:0x02fb, B:135:0x0301), top: B:147:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0258 A[Catch: Exception -> 0x0314, TryCatch #1 {Exception -> 0x0314, blocks: (B:10:0x004b, B:13:0x0073, B:15:0x0079, B:17:0x008c, B:19:0x0092, B:21:0x009c, B:24:0x00b8, B:26:0x00be, B:28:0x00cd, B:30:0x00d3, B:32:0x00dd, B:34:0x00f4, B:36:0x00fa, B:38:0x0109, B:40:0x010f, B:42:0x0119, B:44:0x0130, B:46:0x0136, B:48:0x0145, B:50:0x014b, B:52:0x0155, B:54:0x016c, B:56:0x0172, B:58:0x0181, B:60:0x0187, B:62:0x0191, B:65:0x01b1, B:67:0x01b7, B:69:0x01ca, B:71:0x01d0, B:73:0x01da, B:78:0x01fd, B:80:0x0203, B:82:0x0216, B:84:0x021c, B:86:0x0226, B:89:0x0247, B:91:0x0253, B:92:0x0258, B:94:0x025e, B:97:0x0275, B:99:0x027b, B:136:0x0308, B:100:0x0284, B:103:0x028c, B:105:0x0292, B:106:0x029b, B:109:0x02a3, B:111:0x02a9, B:112:0x02b1, B:115:0x02b9, B:117:0x02bf, B:118:0x02c7, B:121:0x02cf, B:123:0x02d5, B:124:0x02dd, B:127:0x02e5, B:129:0x02eb, B:130:0x02f3, B:133:0x02fb, B:135:0x0301), top: B:147:0x004b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ kotlin.Unit lambda$initViews$0() {
        /*
            Method dump skipped, instruction units count: 810
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Coupon.Activity.CouponPurchaseActivity.lambda$initViews$0():kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$initViews$1() {
        finish();
        return null;
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

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (apitype.equals("https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction")) {
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setCourse_id(this.coursesCoupon.getId());
            encryptionData.setCoupon_applied(this.id);
            encryptionData.setParent_id("0");
            return service.free_transaction(AES.encrypt(new Gson().toJson(encryptionData)));
        }
        if (!apitype.equals(API.int_payment)) {
            return null;
        }
        if (this.isfailure) {
            EncryptionData encryptionData2 = new EncryptionData();
            encryptionData2.setType("2");
            encryptionData2.setCourse_id(this.coursesCoupon.getId());
            encryptionData2.setParent_id("0");
            encryptionData2.setPre_transaction_id(this.pre_txtid);
            encryptionData2.setTransaction_status("2");
            encryptionData2.setPost_transaction_id("");
            encryptionData2.setCoupon_applied(this.id);
            return service.int_payment(AES.encrypt(new Gson().toJson(encryptionData2)));
        }
        if (this.pos_txn_id.equalsIgnoreCase("")) {
            EncryptionData encryptionData3 = new EncryptionData();
            encryptionData3.setType("1");
            encryptionData3.setCourse_id(this.coursesCoupon.getId());
            encryptionData3.setCourse_price("" + Float.parseFloat(this.coursesCoupon.getMrp()));
            encryptionData3.setParent_id("0");
            encryptionData3.setTax("" + Float.parseFloat(this.coursesCoupon.getTax()));
            encryptionData3.setPay_via(this.paymentViewModel.getPayVia());
            encryptionData3.setCoupon_applied(this.id);
            return service.int_payment(AES.encrypt(new Gson().toJson(encryptionData3)));
        }
        EncryptionData encryptionData4 = new EncryptionData();
        encryptionData4.setType("2");
        encryptionData4.setCourse_id(this.coursesCoupon.getId());
        encryptionData4.setParent_id("0");
        encryptionData4.setPre_transaction_id(this.pre_txtid);
        encryptionData4.setTransaction_status("1");
        encryptionData4.setPost_transaction_id(this.pos_txn_id);
        encryptionData4.setRid(this.rid);
        encryptionData4.setScd(this.scd);
        encryptionData4.setPid(this.pos_txn_id);
        encryptionData4.setAmt(this.amt);
        encryptionData4.setOrder_id(this.pos_txn_id);
        return service.int_payment(AES.encrypt(new Gson().toJson(encryptionData4)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonobject, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals("https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction")) {
            try {
                if (jsonobject.optString("status").equals("true")) {
                    Toast.makeText(this, "" + jsonobject.optString("message"), 0).show();
                    if (!this.coursesCoupon.getId().equalsIgnoreCase("")) {
                        UtkashRoom.getAppDatabase(MakeMyExam.getAppContext()).getCourseDetaildata().deletecoursedetail(this.coursesCoupon.getId(), MakeMyExam.userId);
                    }
                    pushEventForFreeCourse();
                    logBuyNowFreeEvent(this, this.coursesCoupon.getTitle());
                    Intent intent = new Intent(this, (Class<?>) CourseActivity.class);
                    intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent.putExtra(Const.ISMOVED, "Success");
                    intent.putExtra(Const.COURSE_ID_MAIN, this.coursesCoupon.getId());
                    intent.putExtra(Const.COURSE_PARENT_ID, "");
                    intent.putExtra(Const.IS_COMBO, false);
                    intent.putExtra(AnalyticsConstants.course_name, this.coursesCoupon.getTitle());
                    intent.setFlags(67108864);
                    Helper.gotoActivity_finish(intent, this);
                    return;
                }
                Toast.makeText(this, "" + jsonobject.optString("message"), 0).show();
                RetrofitResponse.GetApiData(this, jsonobject.has("auth_code") ? jsonobject.getString("auth_code") : "", jsonobject.getString("message"), false);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (apitype.equals(API.int_payment)) {
            try {
                if (jsonobject.optString("status").equals("true")) {
                    if (this.isfailure) {
                        this.isfailure = false;
                        this.pos_txn_id = "";
                        return;
                    }
                    if (this.pos_txn_id.equalsIgnoreCase("")) {
                        JSONObject jSONObject = jsonobject.getJSONObject("data");
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
                        }
                        if (this.paymentViewModel.getPayVia().equalsIgnoreCase("9")) {
                            paymentGateways(jSONObject, Credentials.EASEBUZZ);
                            return;
                        } else if (this.paymentViewModel.getPayVia().equalsIgnoreCase("11")) {
                            paymentGateways(jSONObject, Credentials.BILLDESK);
                            return;
                        } else {
                            if (this.paymentViewModel.getPayVia().equalsIgnoreCase("13")) {
                                paymentGateways(jSONObject, Credentials.EASYPAY);
                                return;
                            }
                            return;
                        }
                    }
                    if (!this.coursesCoupon.getId().equalsIgnoreCase("")) {
                        UtkashRoom.getAppDatabase(MakeMyExam.getAppContext()).getCourseDetaildata().deletecoursedetail(this.coursesCoupon.getId(), MakeMyExam.userId);
                    }
                    FacebookEventLogger.logPurchased(this);
                    logBuySuccessEvent(this, this.coursesCoupon.getTitle());
                    FacebookEventLogger.logSignUp(this);
                    if (Helper.isNewLoginFlow()) {
                        showUpdateStatePopup();
                    } else {
                        success_dailog();
                    }
                    Toast.makeText(this, "" + jsonobject.optString("message"), 0).show();
                    return;
                }
                if (this.isfailure) {
                    this.isfailure = false;
                    this.pos_txn_id = "";
                }
                RetrofitResponse.GetApiData(this, jsonobject.has("auth_code") ? jsonobject.getString("auth_code") : "", jsonobject.getString("message"), false);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private void paymentGateways(JSONObject data, String mode) {
        EasyPay easyPay;
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
            String stringPreference4 = PreferencesUtil.INSTANCE.getStringPreference(this, Credentials.FONEPAY);
            String stringPreference5 = PreferencesUtil.INSTANCE.getStringPreference(this, Credentials.EASEBUZZ);
            String stringPreference6 = PreferencesUtil.INSTANCE.getStringPreference(this, Credentials.BILLDESK);
            String stringPreference7 = PreferencesUtil.INSTANCE.getStringPreference(this, Credentials.EASYPAY);
            if (mode.equals(Credentials.RZP)) {
                if (stringPreference == null || stringPreference.isEmpty() || (rzp = (Rzp) new Gson().fromJson(stringPreference, Rzp.class)) == null || rzp.getStatus() == null || !rzp.getStatus().equalsIgnoreCase("1")) {
                    return;
                }
                launch_paymentGateway(rzp.getKey());
                return;
            }
            if (mode.equals(Credentials.PAYTM)) {
                if (stringPreference2 == null || stringPreference2.isEmpty() || (paytm2 = (Paytm) new Gson().fromJson(stringPreference2, Paytm.class)) == null || paytm2.getStatus() == null || !paytm2.getStatus().equalsIgnoreCase("1")) {
                    return;
                }
                this.txnToken = data.optString("txnToken");
                this.paymentViewModel.launchPaytmPaymentGateway(this.pre_txtid, calculateAmount(), this.txnToken, paytm2.getSecret(), paytm2.getUrl());
                return;
            }
            if (mode.equals(Credentials.CCAV)) {
                if (stringPreference3 == null || stringPreference3.isEmpty() || (ccav = (Ccav) new Gson().fromJson(stringPreference3, Ccav.class)) == null || ccav.getStatus() == null || !ccav.getStatus().equalsIgnoreCase("1")) {
                    return;
                }
                this.enc_val = data.optString("txnToken");
                this.paymentViewModel.launchCcAvenuePaymentGateway(this.pre_txtid, calculateAmount(), this.enc_val, ccav.getSecret(), ccav.getRedirect_url(), ccav.getCancel_url(), ccav.getAndroid_url());
                return;
            }
            if (mode.equals(Credentials.FONEPAY)) {
                if (stringPreference4 == null || stringPreference4.isEmpty() || (fonePay = (FonePay) new Gson().fromJson(stringPreference4, FonePay.class)) == null || fonePay.getStatus() == null || !fonePay.getStatus().equalsIgnoreCase("1")) {
                    return;
                }
                this.paymentViewModel.launchFonePayPaymentGateway(data.optString("txnToken"), calculateAmount());
                return;
            }
            if (mode.equals(Credentials.EASEBUZZ)) {
                if (stringPreference5 == null || stringPreference5.isEmpty() || (easeBuzz = (EaseBuzz) new Gson().fromJson(stringPreference5, EaseBuzz.class)) == null || easeBuzz.getStatus() == null || !easeBuzz.getStatus().equalsIgnoreCase("1")) {
                    return;
                }
                this.paymentViewModel.launchEaseBuzzPaymentGateway(data.optString("txnToken"), calculateAmount(), easeBuzz.getMode());
                return;
            }
            if (mode.equals(Credentials.BILLDESK)) {
                if (stringPreference6 == null || stringPreference6.isEmpty() || (billDesk = (BillDesk) new Gson().fromJson(stringPreference6, BillDesk.class)) == null || billDesk.getStatus() == null || !billDesk.getStatus().equalsIgnoreCase("1")) {
                    return;
                }
                this.paymentViewModel.launchBillDeskPaymentGateway(data.optString("txnToken"), calculateAmount());
                return;
            }
            if (!mode.equals(Credentials.EASYPAY) || stringPreference7 == null || stringPreference7.isEmpty() || (easyPay = (EasyPay) new Gson().fromJson(stringPreference7, EasyPay.class)) == null || easyPay.getStatus() == null || !easyPay.getStatus().equalsIgnoreCase("1")) {
                return;
            }
            this.paymentViewModel.launchEasyPayPaymentGateway(data.optString("txnToken"), calculateAmount());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void launch_paymentGateway(String key) {
        Checkout checkout = new Checkout();
        checkout.setKeyID(key);
        checkout.setImage(R.mipmap.ic_launcher);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", getResources().getString(R.string.payment_gateway_name));
            jSONObject.put("theme.color", ContextCompat.getColor(this, R.color.theme_and_header_color));
            jSONObject.put("description", this.coursesCoupon.getTitle() + " #(" + this.coursesCoupon.getId() + ")");
            jSONObject.put(FirebaseAnalytics.Param.CURRENCY, "INR");
            jSONObject.put("image", this.coursesCoupon.getCover_image());
            jSONObject.put("order_id", this.pre_txtid);
            jSONObject.put("amount", Math.round(Float.valueOf(Float.parseFloat(this.coursesCoupon.getFinal_mrp())).floatValue() * 100.0f));
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
            e2.printStackTrace();
        }
    }

    private int calculateAmount() {
        return Math.round(Float.parseFloat(this.coursesCoupon.getMrp()));
    }

    public void logBuySuccessEvent(Context context, String bookTitle) {
        String loggedInUserInfo = Helper.getLoggedInUserInfo(context);
        Bundle bundle = new Bundle();
        bundle.putString("userInfo", loggedInUserInfo);
        bundle.putString("bookType", "paid");
        bundle.putString("bookName", bookTitle);
        FacebookEventLogger.logEvent(context, "BuyPaidBook", bundle);
    }

    public void logBuyNowFreeEvent(Context context, String bookTitle) {
        String loggedInUserInfo = Helper.getLoggedInUserInfo(context);
        Bundle bundle = new Bundle();
        bundle.putString("userInfo", loggedInUserInfo);
        bundle.putString("bookType", "free");
        bundle.putString("bookName", bookTitle);
        FacebookEventLogger.logEvent(context, "BuyFreeBook", bundle);
    }

    private void success_dailog() {
        try {
            if (SystemClock.elapsedRealtime() - this.mLastClickTime_frame5 < 1000) {
                return;
            }
            this.mLastClickTime_frame5 = SystemClock.elapsedRealtime();
            final Dialog dialog = new Dialog(this);
            dialog.requestWindowFeature(1);
            dialog.setContentView(R.layout.success_dialog);
            dialog.getWindow().setSoftInputMode(16);
            getWindow().setSoftInputMode(3);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.getWindow().setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.9d), -2);
            dialog.getWindow().setGravity(17);
            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);
            EditText editText = (EditText) dialog.findViewById(R.id.et_order_id);
            EditText editText2 = (EditText) dialog.findViewById(R.id.et_transaction_id);
            TextView textView = (TextView) dialog.findViewById(R.id.course_name);
            editText.setText(this.pre_txtid);
            editText2.setText(this.pos_txn_id);
            textView.setText(this.coursesCoupon.getTitle());
            ((Button) dialog.findViewById(R.id.btn_my_course)).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Coupon.Activity.CouponPurchaseActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$success_dailog$2(view);
                }
            });
            dialog.show();
            dialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.appnew.android.Coupon.Activity.CouponPurchaseActivity$$ExternalSyntheticLambda3
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    CouponPurchaseActivity.lambda$success_dailog$3(dialog, dialogInterface);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$success_dailog$2(View view) {
        Intent intent = new Intent(this, (Class<?>) CourseActivity.class);
        intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
        intent.putExtra(Const.ISMOVED, "Success");
        intent.putExtra(Const.COURSE_ID_MAIN, this.coursesCoupon.getId());
        intent.putExtra(Const.COURSE_PARENT_ID, "");
        intent.putExtra(Const.IS_COMBO, false);
        intent.putExtra(AnalyticsConstants.course_name, this.coursesCoupon.getTitle());
        intent.setFlags(67108864);
        Helper.gotoActivity_finish(intent, this);
    }

    static /* synthetic */ void lambda$success_dailog$3(Dialog dialog, DialogInterface dialogInterface) {
        dialog.dismiss();
        dialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OnPaymentError() {
        try {
            this.isfailure = true;
            this.networkCall.NetworkAPICall(API.int_payment, "", true, false);
        } catch (Exception unused) {
        }
    }

    @Override // com.appnew.android.Utils.PaymentTypeCheck
    public void onPaymentType(String mode, JSONObject data) {
        String stringPreference = PreferencesUtil.INSTANCE.getStringPreference(this, Credentials.RZP);
        String stringPreference2 = PreferencesUtil.INSTANCE.getStringPreference(this, Credentials.PAYTM);
        String stringPreference3 = PreferencesUtil.INSTANCE.getStringPreference(this, Credentials.CCAV);
        String stringPreference4 = PreferencesUtil.INSTANCE.getStringPreference(this, Credentials.FONEPAY);
        String stringPreference5 = PreferencesUtil.INSTANCE.getStringPreference(this, Credentials.EASEBUZZ);
        String stringPreference6 = PreferencesUtil.INSTANCE.getStringPreference(this, Credentials.BILLDESK);
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

    private void pushEventForFreeCourse() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_id", AnalyticHelper.INSTANCE.getUserId());
        map.put(AnalyticsConstants.user_name, AnalyticHelper.INSTANCE.getUserName());
        map.put("course_id", this.coursesCoupon.getId());
        map.put(AnalyticsConstants.course_name, this.coursesCoupon.getTitle());
        AnalyticEvents.INSTANCE.pushEvents(this, AnalyticsConstants.FREE_USER, map);
    }

    public void showUpdateStatePopup() {
        UpdateProfileDialogUtils.makeDialogForStateUpdate(this, false, new UpdateProfileDialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Coupon.Activity.CouponPurchaseActivity.2
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
                    com.appnew.android.Coupon.Activity.CouponPurchaseActivity r2 = com.appnew.android.Coupon.Activity.CouponPurchaseActivity.this     // Catch: java.lang.Exception -> L4b
                    long r2 = r2.mLastClickTime     // Catch: java.lang.Exception -> L4b
                    long r0 = r0 - r2
                    r2 = 1000(0x3e8, double:4.94E-321)
                    int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r0 >= 0) goto L10
                    return
                L10:
                    com.appnew.android.Coupon.Activity.CouponPurchaseActivity r0 = com.appnew.android.Coupon.Activity.CouponPurchaseActivity.this     // Catch: java.lang.Exception -> L4b
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
                    com.appnew.android.Coupon.Activity.CouponPurchaseActivity r1 = com.appnew.android.Coupon.Activity.CouponPurchaseActivity.this     // Catch: java.lang.Exception -> L4b
                    r2 = r8
                    r3 = r9
                    r4 = r10
                    r5 = r11
                    r6 = r12
                    r1.submitUpdateStateData(r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L4b
                    return
                L42:
                    r2.dismiss()     // Catch: java.lang.Exception -> L4b
                    com.appnew.android.Coupon.Activity.CouponPurchaseActivity r8 = com.appnew.android.Coupon.Activity.CouponPurchaseActivity.this     // Catch: java.lang.Exception -> L4b
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
                throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Coupon.Activity.CouponPurchaseActivity.AnonymousClass2.onOKClick(android.app.Dialog, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
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
            aPIInterface.updateprofile(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new Callback<String>() { // from class: com.appnew.android.Coupon.Activity.CouponPurchaseActivity.3
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
                            Toast.makeText(CouponPurchaseActivity.this, jSONObject.getString("message"), 1).show();
                            dialog.dismiss();
                            CouponPurchaseActivity.this.finishPayment();
                        }
                    } catch (Exception e2) {
                        Log.d("Dialog", "onResponse: " + e2.getMessage());
                    }
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<String> call, Throwable t) {
                    Helper.dismissProgressDialog();
                    CouponPurchaseActivity couponPurchaseActivity = CouponPurchaseActivity.this;
                    Toast.makeText(couponPurchaseActivity, couponPurchaseActivity.getResources().getString(R.string.something_went_wrong), 1).show();
                }
            });
            return;
        }
        Toast.makeText(this, getResources().getString(R.string.Retry_with_Internet_connection), 1).show();
    }

    public void finishPayment() {
        Intent intent = new Intent(this, (Class<?>) CourseActivity.class);
        intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
        intent.putExtra(Const.ISMOVED, "Success");
        intent.putExtra(Const.COURSE_ID_MAIN, this.coursesCoupon.getId());
        intent.putExtra(Const.COURSE_PARENT_ID, "");
        intent.putExtra(Const.IS_COMBO, false);
        intent.putExtra(AnalyticsConstants.course_name, this.coursesCoupon.getTitle());
        intent.setFlags(67108864);
        Helper.gotoActivity_finish(intent, this);
    }
}
