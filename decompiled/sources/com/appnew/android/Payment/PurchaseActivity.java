package com.appnew.android.Payment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Patterns;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amazonaws.services.s3.util.Mimetypes;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeParams;
import com.android.billingclient.api.ConsumeResponseListener;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.ProductDetailsResponseListener;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsParams;
import com.android.billingclient.api.SkuDetailsResponseListener;
import com.appnew.android.BuildConfig;
import com.appnew.android.Coupon.Adapter.CouponPurchaseAdapter;
import com.appnew.android.Coupon.Models.Available;
import com.appnew.android.Coupon.Models.CouponPojo;
import com.appnew.android.Coupon.Models.CoursesCoupon;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.Courses.Activity.PdfDetailScreen;
import com.appnew.android.Courses.Adapter.AddressAdapter;
import com.appnew.android.Courses.Fragment.SingleStudy;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.FacebookEventLogger;
import com.appnew.android.Model.Address;
import com.appnew.android.Model.AddressMaster;
import com.appnew.android.Model.BillDesk;
import com.appnew.android.Model.BottomSetting;
import com.appnew.android.Model.COURSEDETAIL.Author;
import com.appnew.android.Model.COURSEDETAIL.CourseDetail;
import com.appnew.android.Model.COURSEDETAIL.CourseDetailData;
import com.appnew.android.Model.COURSEDETAIL.TilesItem;
import com.appnew.android.Model.Ccav;
import com.appnew.android.Model.CommonEmiPlanModel;
import com.appnew.android.Model.Courses.AmountDescription;
import com.appnew.android.Model.Courses.InstallmentResponse;
import com.appnew.android.Model.EaseBuzz;
import com.appnew.android.Model.EasyPay;
import com.appnew.android.Model.FonePay;
import com.appnew.android.Model.LeftMenu;
import com.appnew.android.Model.Paytm;
import com.appnew.android.Model.QRPaymentData;
import com.appnew.android.Model.Rzp;
import com.appnew.android.Model.TxnTokenData;
import com.appnew.android.Model.subscription.SubscriptionAllData;
import com.appnew.android.Model.subscription.SubscriptionDataItem;
import com.appnew.android.Model.subscription.SubscriptionMetaItem;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Payment.SubscriptionPlanAdapter;
import com.appnew.android.Profile.ProfileActivity;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.TestRegisteration.RegisterationTest;
import com.appnew.android.Theme.DashboardActivityTheme1;
import com.appnew.android.Theme.DashboardActivityTheme2;
import com.appnew.android.Theme.DashboardActivityTheme7;
import com.appnew.android.Theme.DashboardActivityTheme8;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.DialogUtils;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.GenericUtils;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.PaymentTypeCheck;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.UpdateProfileDialogUtils;
import com.appnew.android.Webview.WebViewActivty;
import com.appnew.android.cleverTap.AnalyticHelper;
import com.appnew.android.folder.model.ExamCenter;
import com.appnew.android.home.Constants;
import com.appnew.android.pojo.Userinfo.Data;
import com.appnew.android.pojo.Userinfo.StatesCities.StatesCities;
import com.appnew.android.pojo.Userinfo.StatesCities.StatesCitiesData;
import com.appnew.android.table.CourseDetailTable;
import com.appnew.android.table.ThemeSettings;
import com.appnew.android.table.UserWiseCourseTable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.eduteria.app.app.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textfield.TextInputLayout;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.makeramen.roundedimageview.RoundedImageView;
import com.razorpay.PaymentResultListener;
import com.tv9news.utils.helpers.AnalyticEvents;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jivesoftware.smack.sasl.packet.SaslNonza;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes6.dex */
public class PurchaseActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack, PaymentResultListener, PaymentTypeCheck, IOnViewDetailsClick, ItemClickListener, PopupMenu.OnMenuItemClickListener, OnCouponClicked, OnAddressAddDeleteClicked, SubscriptionPlanAdapter.OnPlanClickListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static String inapp_billing_product_id_number_1 = "special_recorded_package_14903";
    public static String inapp_billing_product_id_number_2 = "special_recorded_section_14904";
    public static String inapp_billing_product_id_number_3 = "special_recorded_section_14910";
    public static String inapp_billing_product_id_number_4 = "special_recorded_section_14909";
    String SelectedCityid;
    String SelectedStateid;
    private SkuDetails SkuDetails;
    private Activity activity;
    MainAdapter adapter;
    TextView addAddress;
    Button addAddressBtn;
    LinearLayout addedAddressLL;
    TextView addedAddressTV;
    Address address;
    Address address1;
    AddressAdapter addressAdapter;
    RelativeLayout addressCV;
    String addressId;
    String addressJson;
    ArrayList<AddressMaster> addressListMaster;
    AddressMaster addressMaster;
    int addressPosition;
    String amt;
    String appliedCouponCode;
    String appliedCouponCodeId;
    RelativeLayout apply_couponCvr;
    ArrayList<String> arrayList;
    private BillingClient billingClient;
    TextView book_coupon_applied;
    BottomSetting bottomSetting;
    Dialog bottomSheetDialogExamCenter;
    RelativeLayout center_applied_rl;
    RelativeLayout cgstLayout;
    RelativeLayout cgstLayoutCoupon;
    TextView cgstValue;
    TextView cgstValueCoupon;
    RelativeLayout checkTncRL;
    RelativeLayout choose_center_rl;
    TextView choose_center_text;
    StatesCities cities;
    String cityindex;
    ImageView clear_exam_center;
    ImageView clear_referral_code;
    String clicktype;
    String combo_id;
    private CountDownTimer countDownTimer;
    String couponCode;
    CardView couponLayout;
    TextView coupon_applied_extra;
    RelativeLayout coupon_applied_rl;
    TextView coupon_code_applied;
    CourseDetail courseDetail;
    CourseDetail courseDetail1;
    CourseDetailTable courseDetailTable;
    TextView coursenameEmi;
    TextView coursenameTV;
    TextView coursenameTV1;
    CoursesCoupon coursesCoupon;
    CardView coverEmiPaymentBtn;
    CardView coverOneTimePaymentBtn;
    CardView cvrImage;
    Data data;
    RelativeLayout deliveryChargeRL;
    RelativeLayout deliveryChargeRL2;
    TextView deliveryChargeTV;
    TextView deliveryChargeTV2;
    TextView deliveryId;
    TextView deliveryId1;
    Dialog dialogGettingSavedAddress;
    TextView display_exam_center;
    TextView display_referral_code;
    TextView districtTV;
    RelativeLayout dummycoupon_layout;
    ImageView editAddressIV;
    LinearLayoutCompat emiPayBtnCvr;
    String emiPriceToSend;
    RecyclerView emiRecyclerList;
    RelativeLayout emiTypeLayout;
    TextView emi_scholarshipCouponTV;
    String enc_val;
    EditText etSearch;
    CouponPurchaseAdapter extendAdapter;
    RelativeLayout extraCouponLayout;
    Double finalAmt;
    String finalPriceValue;
    String finalTaxValue;
    TextView gstTv;
    ImageView imEmiPayment;
    ImageView imOneTimePayment;
    ImageView imageCourse;
    RoundedImageView imageIV;
    ImageView img_back;
    Double installmentFirstPrice;
    RelativeLayout installmentInfo;
    RelativeLayout installmentInfo1;
    RelativeLayout installmentTB;
    boolean isAddressEdited;
    boolean isDefault;
    boolean isFirstTime;
    private boolean isInApp;
    boolean isPayViaQR;
    boolean isSelfCoupon;
    boolean isWantToUpdate;
    private boolean is_load_form;
    ImageView ivClearSearch;
    RelativeLayout layout_course;
    LeftMenu leftMenu;
    LinearLayout ll_emi_scholorship_discount;
    LinearLayout ll_scholorship_discount;
    private DatabaseReference mFirebaseDatabaseReferenceQRPay;
    long mLastClickTime;
    long mLastClickTime_frame5;
    String mainCourseId;
    Toolbar main_toolbar;
    TextView mobileNumber;
    TextView mobileNumberAlternate;
    public UtkashRoom myDBClass;
    TextView nameAddressTv;
    NetworkCall networkCall;
    TextView noOfQuantity;
    TextView noOfQuantityInCaseCoupon;
    LinearLayoutCompat oneTimePayBtnCvr;
    Button openQR;
    String paymentAttemptValue;
    String paymentMetaValue;
    String paymentModeValue;
    PaymentViewModel paymentViewModel;
    String payment_mode;
    String planId;
    ArrayList<CoursesCoupon> preCouponArrayList;
    private TextView priceTxtCourse;
    Button procceed;
    private String product_id;
    private final PurchasesUpdatedListener purchasesUpdatedListener;
    private ValueEventListener qrPayValueEventListener;
    RelativeLayout quantityLayout;
    RelativeLayout quantityMainLayout;
    RecyclerView recyclerViewSavedAddress;
    TextView referral_code;
    RelativeLayout referral_rl;
    ImageView remove;
    String rid;
    String scd;
    TextView scholarshipCouponTV;
    RecyclerView searchRecyclerview;
    String secondCouponCode;
    String selectedCouponId;
    ArrayList<CoursesCoupon> selfCouponArrayList;
    RelativeLayout sgstLayout;
    RelativeLayout sgstLayoutCoupon;
    TextView sgstValue;
    TextView sgstValueCoupon;
    StateCityAdapter stateCityAdapter;
    String stateindex;
    StatesCities states;
    ArrayList<StatesCitiesData> statesCitiesArrayList;
    TextView statesTV;
    private Integer stopValidationOnCoupon;
    private SubscriptionAllData subscriptionAllData;
    TextView subscriptionBenefits;
    WebView subscriptionDescription;
    SubscriptionPlanAdapter subscriptionPlanAdapter;
    RecyclerView subscriptionPlanRecycler;
    RelativeLayout subscriptionRelativeLayout;
    LinearLayoutCompat subscriptionSectionId;
    ArrayList<SubscriptionMetaItem> subscriptionValidityList;
    ArrayList<SubscriptionMetaItem> subscriptionValidityListForDeliveryMethod;
    TextView subscription_amount;
    String subscription_code;
    RelativeLayout taxLayout;
    LinearLayoutCompat tax_layout;
    RelativeLayout tax_layout1;
    TextView tax_value;
    TextView tax_value1;
    TextView tax_value2;
    RelativeLayout taxes_layout;
    TextView termCondTV;
    CheckBox terms_check;
    ThemeSettings themeSettings;
    private TextView titleTxtCourse;
    TextView toolbarTitleTV;
    TextView totalPrice;
    TextView totalPrice1;
    TextView totalPriceValue;
    TextView totalPriceValue1;
    RelativeLayout total_amount_layout1;
    RelativeLayout total_layout;
    private String txnToken;
    private TxnTokenData txnTokenData;
    TextView txtAmountValue;
    TextView txtEmiPayment;
    TextView txtGrandTotalValue;
    TextView txtGrandTotalValue1;
    TextView txtInstallmentValue;
    TextView txtOnetimePayment;
    TextView txtPricesValue1;
    TextView txtTaxValue1;
    private TextView txtValidityCourse;
    TextView validityId;
    TextView validityTV;
    TextView view_plan_tv;
    BottomSheetDialog watchlist;
    RelativeLayout withCouponLayout;
    RelativeLayout withoutCouponLayout;
    boolean isCouponGiven = false;
    String is_trial = "";
    String productdata = "";
    String isBook = "";
    String deliveryCharge = "";
    String tax = "";
    String price = "";
    boolean hassCourseDetail = false;
    String is_gst = "";
    String content_type = "";
    String coupon_applied = "0";
    String pos_txn_id = "";
    String pre_txtid = "";
    String tx_status = "0";
    String fonePayKey = "";
    boolean isfailure = false;
    ArrayList<CoursesCoupon> coursesCouponArrayList = new ArrayList<>();
    ArrayList<CoursesCoupon> coursesCouponArrayListMultiple = new ArrayList<>();
    Boolean gstShow = false;
    float ttlAmtCouponCase = 0.0f;
    boolean haveAddress = false;
    String quantityOfBooks = "1";
    int exam_center_position = -1;
    boolean isEmiSelected = false;
    boolean hideExternalForEMI = false;
    int emiTypePos = 0;

    static /* synthetic */ void lambda$onCreate$4(View view) {
    }

    static /* synthetic */ void lambda$onCreate$5(View view) {
    }

    static /* synthetic */ void lambda$openQRCode$49() {
    }

    @Override // com.appnew.android.Utils.PaymentTypeCheck
    public void onPaymentTypeCancel() {
    }

    public PurchaseActivity() {
        Double dValueOf = Double.valueOf(0.0d);
        this.installmentFirstPrice = dValueOf;
        this.finalPriceValue = "";
        this.planId = "";
        this.finalAmt = dValueOf;
        this.paymentModeValue = "0";
        this.paymentMetaValue = "";
        this.emiPriceToSend = "";
        this.finalTaxValue = "";
        this.subscription_code = "";
        this.paymentAttemptValue = "0";
        this.txnToken = "";
        this.enc_val = "";
        this.scd = "";
        this.subscriptionValidityListForDeliveryMethod = new ArrayList<>();
        this.subscriptionValidityList = new ArrayList<>();
        this.combo_id = "";
        this.mainCourseId = "";
        this.addressListMaster = new ArrayList<>();
        this.isInApp = false;
        this.stopValidationOnCoupon = null;
        this.isPayViaQR = false;
        this.addressId = "";
        this.clicktype = "";
        this.isAddressEdited = false;
        this.isWantToUpdate = true;
        this.isDefault = false;
        this.selectedCouponId = "";
        this.isSelfCoupon = false;
        this.selfCouponArrayList = new ArrayList<>();
        this.preCouponArrayList = new ArrayList<>();
        this.mLastClickTime = 0L;
        this.appliedCouponCode = "";
        this.appliedCouponCodeId = "";
        this.statesCitiesArrayList = new ArrayList<>();
        this.stateindex = "";
        this.cityindex = "";
        this.SelectedStateid = "";
        this.SelectedCityid = "";
        this.isFirstTime = false;
        this.secondCouponCode = "";
        this.product_id = "";
        this.purchasesUpdatedListener = new PurchasesUpdatedListener() { // from class: com.appnew.android.Payment.PurchaseActivity.19
            @Override // com.android.billingclient.api.PurchasesUpdatedListener
            public void onPurchasesUpdated(BillingResult billingResult, List<Purchase> purchases) {
                if (billingResult.getResponseCode() == 0 && purchases != null) {
                    Log.d(SaslNonza.Response.ELEMENT, "result SuccessFull");
                    for (Purchase purchase : purchases) {
                        Log.d(SaslNonza.Response.ELEMENT, "" + purchase.isAcknowledged());
                        PurchaseActivity.this.billingClient.consumeAsync(ConsumeParams.newBuilder().setPurchaseToken(purchase.getPurchaseToken()).build(), new ConsumeResponseListener() { // from class: com.appnew.android.Payment.PurchaseActivity.19.1
                            @Override // com.android.billingclient.api.ConsumeResponseListener
                            public void onConsumeResponse(BillingResult billingResult2, String purchaseToken) {
                                if (billingResult2.getResponseCode() == 0 && purchaseToken != null) {
                                    System.out.println("SUCCESSFULLY consumed PURCHASE");
                                    Log.d(SaslNonza.Response.ELEMENT, "SUCCESSFULLY consumed PURCHASE");
                                    PurchaseActivity.this.networkCall.NetworkAPICall(API.IN_APP_PURCHASE, "", true, false);
                                    return;
                                }
                                Log.d(SaslNonza.Response.ELEMENT, "FAILED TO consume:");
                            }
                        });
                    }
                    return;
                }
                if (billingResult.getResponseCode() == 1) {
                    if (billingResult.getDebugMessage().isEmpty()) {
                        return;
                    }
                    Helper.showToast(PurchaseActivity.this.activity, "" + billingResult.getDebugMessage(), 1);
                } else {
                    if (billingResult.getDebugMessage().isEmpty()) {
                        return;
                    }
                    Helper.showToast(PurchaseActivity.this.activity, "" + billingResult.getDebugMessage(), 1);
                }
            }
        };
        this.txnTokenData = null;
        this.mFirebaseDatabaseReferenceQRPay = null;
        this.qrPayValueEventListener = null;
        this.countDownTimer = null;
    }

    public CourseDetail getCourseDetail() {
        return (CourseDetail) new Gson().fromJson(SharedPreference.getInstance().getString(Const.SINGLE_STUDY), CourseDetail.class);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        LeftMenu leftMenu;
        boolean z;
        BottomSetting bottomSetting;
        UtkashRoom utkashRoom;
        super.onCreate(savedInstanceState);
        FacebookEventLogger.logFbSdkInitialize(this);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.activity_purchase);
        this.networkCall = new NetworkCall(this, this);
        View viewFindViewById = findViewById(R.id.root);
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        if (Build.VERSION.SDK_INT == 36) {
            EdgeToEdgeHelperOld.applyHeaderWithToolbar(this, getWindow(), viewFindViewById, toolbar);
        }
        this.activity = this;
        this.myDBClass = UtkashRoom.getAppDatabase(this);
        this.is_load_form = getIntent().getBooleanExtra("is_load_form", true);
        if (((CourseDetail) getIntent().getSerializableExtra(Const.SINGLE_STUDY)) != null) {
            this.courseDetail1 = (CourseDetail) getIntent().getSerializableExtra(Const.SINGLE_STUDY);
        } else {
            this.courseDetail1 = getCourseDetail();
        }
        if (getIntent().getStringExtra("payment_mode") != null && !getIntent().getStringExtra("payment_mode").equalsIgnoreCase("")) {
            this.payment_mode = getIntent().getStringExtra("payment_mode");
            this.is_trial = getIntent().getStringExtra("is_trial");
            String str = this.payment_mode;
            if (str != null && str.equalsIgnoreCase("3")) {
                findViewById(R.id.paymentDetailsLL).setVisibility(8);
                findViewById(R.id.subscriptionPlanLL).setVisibility(0);
                setSubscriptionTypes();
            } else {
                findViewById(R.id.paymentDetailsLL).setVisibility(0);
                findViewById(R.id.subscriptionPlanLL).setVisibility(8);
            }
        }
        CourseDetail courseDetail = this.courseDetail1;
        if (courseDetail != null && courseDetail.getData().getCourseDetail().getCat_type().equalsIgnoreCase("3") && this.is_load_form && getIntent().hasExtra("test_data")) {
            Intent intent = new Intent(this.activity, (Class<?>) RegisterationTest.class);
            intent.putExtra(Const.SINGLE_STUDY, this.courseDetail1);
            intent.putExtra("test_data", getIntent().getStringExtra("test_data"));
            intent.putExtra("test_id", getIntent().getStringExtra("test_id"));
            intent.putExtra(Const.IS_BOOK, getIntent().getStringExtra(Const.IS_BOOK));
            intent.putExtra(Const.DELIVERY_CHARGE, getIntent().getStringExtra(Const.DELIVERY_CHARGE));
            Helper.gotoActivity(intent, this);
            finish();
        } else {
            if (getIntent().hasExtra(Const.SINGLE_STUDY)) {
                this.hassCourseDetail = true;
                this.courseDetail = (CourseDetail) getIntent().getSerializableExtra(Const.SINGLE_STUDY);
            } else {
                CourseDetail courseDetail2 = this.courseDetail1;
                if (courseDetail2 != null) {
                    this.hassCourseDetail = true;
                    this.courseDetail = courseDetail2;
                } else {
                    this.hassCourseDetail = false;
                }
            }
            Log.d("TAGCOURSEDATA", "courseDetail: " + (this.courseDetail != null ? new Gson().toJson(this.courseDetail) : "empty"));
            if (getIntent().hasExtra("quantityOfBooks")) {
                this.quantityOfBooks = getIntent().getStringExtra("quantityOfBooks");
            } else {
                this.quantityOfBooks = "1";
            }
            if (getIntent().getStringExtra(Const.DELIVERY_CHARGE) != null && !TextUtils.isEmpty(getIntent().getStringExtra(Const.DELIVERY_CHARGE))) {
                this.deliveryCharge = getIntent().getStringExtra(Const.DELIVERY_CHARGE);
            } else {
                this.deliveryCharge = "0";
            }
            if (getIntent().getStringExtra(Const.IS_BOOK) != null) {
                this.isBook = getIntent().getStringExtra(Const.IS_BOOK);
            } else {
                this.isBook = "0";
            }
            UtkashRoom utkashRoom2 = this.myDBClass;
            if (utkashRoom2 != null && utkashRoom2.getthemeSettingdao().is_setting_exit()) {
                this.themeSettings = this.myDBClass.getthemeSettingdao().data();
                this.bottomSetting = (BottomSetting) new Gson().fromJson(this.themeSettings.getBottom(), BottomSetting.class);
                this.leftMenu = (LeftMenu) new Gson().fromJson(this.themeSettings.getLeft_menu(), LeftMenu.class);
            }
            setIds();
            bookTypeUI(this.imageIV, this.coursenameTV, this.coursenameTV1, this.validityTV);
            PaymentViewModel paymentViewModel = (PaymentViewModel) new ViewModelProvider(this).get(PaymentViewModel.class);
            this.paymentViewModel = paymentViewModel;
            paymentViewModel.initPaymentGateway(this, new PaymentGatewayListener() { // from class: com.appnew.android.Payment.PurchaseActivity.1
                @Override // com.appnew.android.Payment.PaymentGatewayListener
                public void onSuccessEsewa(String productId, String totalAmount, String referenceId, String scdId) {
                    PurchaseActivity.this.pos_txn_id = productId;
                    PurchaseActivity.this.amt = totalAmount;
                    PurchaseActivity.this.rid = referenceId;
                    PurchaseActivity.this.scd = scdId;
                    PurchaseActivity.this.networkCall.NetworkAPICall(API.int_payment, "", true, false);
                }

                @Override // com.appnew.android.Payment.PaymentGatewayListener
                public void onSuccess(String posTxnId) {
                    PurchaseActivity.this.pos_txn_id = posTxnId;
                    PurchaseActivity.this.networkCall.NetworkAPICall(API.int_payment, "", true, false);
                }

                @Override // com.appnew.android.Payment.PaymentGatewayListener
                public void onFailed(boolean isFailure) {
                    PurchaseActivity.this.OnPaymentError();
                }
            }, "");
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(67108864);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
            manageQRButton();
            this.gstTv.setText(Constants.gstText);
            this.arrayList = new ArrayList<>();
            if (BuildConfig.FLAVOR.equalsIgnoreCase("NavinClasses")) {
                if (MakeMyExam.isDeliveryAddressNeeded) {
                    this.isBook = "1";
                } else {
                    this.isBook = "0";
                }
            }
            if (this.isBook.equals("1")) {
                this.toolbarTitleTV.setText(getResources().getString(R.string.book_invoice));
                this.totalPrice.setText(getResources().getString(R.string.book_price));
            } else if (this.isBook.equals("3")) {
                this.toolbarTitleTV.setText(getResources().getString(R.string.course_invoice));
                this.totalPrice.setText(getResources().getString(R.string.registration_fee));
            } else if (this.isBook.equals("0")) {
                this.toolbarTitleTV.setText(getResources().getString(R.string.course_invoice));
                this.totalPrice.setText(getResources().getString(R.string.total_price));
            }
            TextView textView = this.deliveryChargeTV;
            StringBuilder sbAppend = new StringBuilder().append(Constants.currencyType).append(" ");
            String str2 = this.deliveryCharge;
            textView.setText(sbAppend.append((str2 == null || TextUtils.isEmpty(str2)) ? "" : String.format("%.2f", Float.valueOf(Float.parseFloat(this.deliveryCharge)))).toString());
            TextView textView2 = this.deliveryChargeTV2;
            StringBuilder sbAppend2 = new StringBuilder().append(Constants.currencyType).append(" ");
            String str3 = this.deliveryCharge;
            textView2.setText(sbAppend2.append((str3 == null || TextUtils.isEmpty(str3)) ? "" : String.format("%.2f", Float.valueOf(Float.parseFloat(this.deliveryCharge)))).toString());
            if (this.leftMenu == null && (utkashRoom = this.myDBClass) != null && utkashRoom.getthemeSettingdao().is_setting_exit()) {
                this.themeSettings = this.myDBClass.getthemeSettingdao().data();
                this.leftMenu = (LeftMenu) new Gson().fromJson(this.themeSettings.getLeft_menu(), LeftMenu.class);
            }
            LeftMenu leftMenu2 = this.leftMenu;
            if (leftMenu2 == null || ((!TextUtils.isEmpty(leftMenu2.getPayment_privacy()) && this.leftMenu.getPayment_privacy().equalsIgnoreCase("0")) || !Helper.isShowShareButton(this.leftMenu))) {
                setTermRelatedData();
            } else {
                setRefundRelatedData();
            }
            if ((SharedPreference.getInstance().getString("in_release").equalsIgnoreCase("0") && (bottomSetting = this.bottomSetting) != null && bottomSetting.getInvoice_tnc().equals("1")) || ((leftMenu = this.leftMenu) != null && !TextUtils.isEmpty(leftMenu.getPayment_privacy()) && this.leftMenu.getPayment_privacy().equalsIgnoreCase("1"))) {
                this.checkTncRL.setVisibility(0);
            }
            if (SharedPreference.getInstance().getString(Const.IS_IGST).equalsIgnoreCase("1")) {
                this.gstShow = true;
            }
            this.dummycoupon_layout.setVisibility(8);
            if (this.hassCourseDetail) {
                this.is_gst = this.courseDetail.getData().getCourseDetail().getIs_gst();
                CourseDetail courseDetail3 = this.courseDetail;
                if (courseDetail3 != null && courseDetail3.getData() != null) {
                    this.paymentViewModel.setCourseId(this.courseDetail.getData().getCourseDetail().getId());
                    this.networkCall.NetworkAPICall(API.GET_COUPON_OVER_COURSE, "", true, false);
                    if (!TextUtils.isEmpty(this.courseDetail.getData().getCourseDetail().getCat_type()) && this.courseDetail.getData().getCourseDetail().getCat_type().equalsIgnoreCase("1")) {
                        if (!TextUtils.isEmpty(this.courseDetail.getData().getCourseDetail().getCover_image())) {
                            Helper.setThumbnailImage(this, this.courseDetail.getData().getCourseDetail().getCover_image(), getDrawable(R.mipmap.square_placeholder), this.imageIV);
                        } else {
                            this.imageIV.setImageResource(R.mipmap.square_placeholder);
                        }
                    } else if (!TextUtils.isEmpty(this.courseDetail.getData().getCourseDetail().getDescHeaderImage())) {
                        Helper.setThumbnailImage(this.activity, this.courseDetail.getData().getCourseDetail().getDescHeaderImage(), this.activity.getResources().getDrawable(R.mipmap.placeholder_course), this.imageIV);
                    } else {
                        this.imageIV.setImageResource(R.mipmap.placeholder_course);
                    }
                    if (SharedPreference.getInstance().getUserCoupon() != null && SharedPreference.getInstance().getUserCoupon().getAvailable() != null) {
                        CouponPojo userCoupon = SharedPreference.getInstance().getUserCoupon();
                        if (userCoupon == null || userCoupon.getAvailable() == null || userCoupon.getAvailable().size() <= 0) {
                            z = false;
                        } else {
                            z = false;
                            for (Available available : userCoupon.getAvailable()) {
                                if (available.getCourses().size() > 0) {
                                    Iterator<CoursesCoupon> it = available.getCourses().iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            if (this.courseDetail.getData().getCourseDetail().getId().equalsIgnoreCase(it.next().getId()) && Long.parseLong(available.getEnd()) * 1000 > Calendar.getInstance().getTimeInMillis()) {
                                                String coupon_value = available.getCoupon_value();
                                                if (available.getCoupon_type().equalsIgnoreCase("1")) {
                                                    this.scholarshipCouponTV.setText(this.activity.getResources().getString(R.string.rupees) + coupon_value + " Scholarship is applied.");
                                                    this.emi_scholarshipCouponTV.setText(this.activity.getResources().getString(R.string.rupees) + coupon_value + " Scholarship is applied.");
                                                } else {
                                                    this.scholarshipCouponTV.setText(coupon_value + "% Scholarship is applied.");
                                                    this.emi_scholarshipCouponTV.setText(coupon_value + "% Scholarship is applied.");
                                                }
                                                z = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (z) {
                            this.ll_scholorship_discount.setVisibility(0);
                            this.ll_emi_scholorship_discount.setVisibility(0);
                        } else {
                            this.ll_scholorship_discount.setVisibility(8);
                            this.ll_emi_scholorship_discount.setVisibility(8);
                        }
                    } else {
                        this.ll_scholorship_discount.setVisibility(8);
                        this.ll_emi_scholorship_discount.setVisibility(8);
                    }
                    Helper.setThumbnailImage(this, this.courseDetail.getData().getCourseDetail().getCover_image(), getDrawable(R.drawable.book_logo), this.imageCourse);
                    this.coursenameTV.setText(this.courseDetail.getData().getCourseDetail().getTitle());
                    if (!GenericUtils.isEmpty(this.courseDetail.getData().getCourseDetail().getAuthor().getTitle()) && !this.courseDetail.getData().getCourseDetail().getAuthor().getTitle().equalsIgnoreCase("Utkarsh classes")) {
                        this.coursenameEmi.setText(this.activity.getResources().getString(R.string.by) + this.courseDetail.getData().getCourseDetail().getAuthor().getTitle());
                        this.coursenameTV1.setText(this.activity.getResources().getString(R.string.by) + this.courseDetail.getData().getCourseDetail().getAuthor().getTitle());
                    } else {
                        this.coursenameEmi.setText(this.activity.getResources().getString(R.string.by) + this.activity.getResources().getString(R.string.app_name));
                        this.coursenameTV1.setText(this.activity.getResources().getString(R.string.by) + this.activity.getResources().getString(R.string.app_name));
                    }
                    this.titleTxtCourse.setText(this.courseDetail.getData().getCourseDetail().getTitle());
                    this.apply_couponCvr.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda27
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return this.f$0.lambda$onCreate$0();
                        }
                    }));
                    this.remove.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda28
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$onCreate$1(view);
                        }
                    });
                }
                CourseDetail courseDetail4 = this.courseDetail;
                if (courseDetail4 != null && courseDetail4.getData().getCourseDetail().getInstallment() != null && !this.courseDetail.getData().getCourseDetail().getInstallment().equalsIgnoreCase("")) {
                    try {
                        this.courseDetail.getData().setInstalment((InstallmentResponse) new Gson().fromJson(this.courseDetail.getData().getCourseDetail().getInstallment(), InstallmentResponse.class));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                loadDataAsPerSubscriptions();
            } else {
                SingleStudy.parentCourseId = "";
                this.combo_id = getIntent().getStringExtra(Const.COMBO_ID);
                this.mainCourseId = getIntent().getStringExtra("mainCourseId");
                if (this.myDBClass.getCourseDetaildata() != null) {
                    String str4 = this.combo_id;
                    if (str4 != null && str4.isEmpty()) {
                        SingleStudy.parentCourseId = this.mainCourseId;
                    }
                    if (!this.myDBClass.getCourseDetaildata().isRecordExistsUserId(MakeMyExam.userId, SingleStudy.parentCourseId + "_" + this.mainCourseId)) {
                        this.networkCall.NetworkAPICall(API.CourseDetail_JS, "", true, false);
                        com.appnew.android.Utils.PreferencesUtil.INSTANCE.setStringPreference(this, Const.COURSE_DETAIL_JS, "0");
                    } else if (com.appnew.android.Utils.PreferencesUtil.INSTANCE.getStringPreference(this, Const.COURSE_DETAIL_JS).equalsIgnoreCase("1")) {
                        this.myDBClass.getCourseDetaildata().deletecoursedetail(SingleStudy.parentCourseId, MakeMyExam.userId);
                        this.networkCall.NetworkAPICall(API.CourseDetail_JS, "", true, false);
                        com.appnew.android.Utils.PreferencesUtil.INSTANCE.setStringPreference(this, Const.COURSE_DETAIL_JS, "0");
                    } else {
                        com.appnew.android.Utils.PreferencesUtil.INSTANCE.setStringPreference(this, Const.COURSE_DETAIL_JS, "0");
                        List<CourseDetailTable> list = this.myDBClass.getCourseDetaildata().getcoursedetail(SingleStudy.parentCourseId + "_" + this.mainCourseId, MakeMyExam.userId);
                        CourseDetailData courseDetailData = new CourseDetailData();
                        if (list.size() > 0) {
                            courseDetailData.setTitle(list.get(0).getCourse_title());
                            courseDetailData.setCourseSp(list.get(0).getCourse_sp());
                            Author author = new Author();
                            author.setTitle(list.get(0).getAuthor_title());
                            courseDetailData.setAuthor(author);
                            courseDetailData.setMrp(list.get(0).getMrp());
                            courseDetailData.setTax(list.get(0).getTax());
                            courseDetailData.setValidity(list.get(0).getValidity());
                            courseDetailData.setId(list.get(0).getCourse_id().split("_")[1]);
                            courseDetailData.setCourseSp(list.get(0).getCourse_sp());
                            courseDetailData.setCover_image(list.get(0).getCover_image());
                            courseDetailData.setDescHeaderImage(list.get(0).getDesc_header_image());
                            courseDetailData.setIsPurchased(list.get(0).getIs_purchased());
                            courseDetailData.setViewType(list.get(0).getView_type());
                            courseDetailData.setIs_combo(list.get(0).getIs_combo());
                            courseDetailData.setExternal_coupon_off(list.get(0).getExternal_coupon_off());
                            courseDetailData.setSkip_payment(list.get(0).getSkip_payment());
                            courseDetailData.setCat_type(list.get(0).getCat_type());
                            courseDetailData.setDelivery_charge(list.get(0).getDelivery_charge());
                            courseDetailData.setIs_activated(list.get(0).getIs_activated());
                            courseDetailData.setToken_activation(list.get(0).getToken_activation());
                            courseDetailData.setTxn_id(list.get(0).getTxn_id());
                            courseDetailData.setInstallment(list.get(0).getInstallment());
                            courseDetailData.setIs_gst(list.get(0).getIs_gst());
                            courseDetailData.setDisplay_locked(list.get(0).getDisplay_locked());
                            courseDetailData.setCombo_has_book(list.get(0).getCombo_has_book());
                            this.content_type = list.get(0).getContent_type();
                            this.courseDetail = new CourseDetail();
                            com.appnew.android.Model.COURSEDETAIL.Data data = new com.appnew.android.Model.COURSEDETAIL.Data();
                            data.setCourseDetail(courseDetailData);
                            if (list.size() > 0 && list.get(0) != null && list.get(0).getSubscription_all_data() != null && !list.get(0).getSubscription_all_data().isEmpty()) {
                                data.setSubscriptionAllData((SubscriptionAllData) new Gson().fromJson(list.get(0).getSubscription_all_data(), SubscriptionAllData.class));
                            }
                            ArrayList<TilesItem> arrayList = new ArrayList();
                            for (int i = 0; i < list.size(); i++) {
                                arrayList.add(new TilesItem(list.get(i).getTile_revert(), list.get(i).getTile_title(), list.get(i).getTile_id(), list.get(i).getType(), list.get(i).getTile_meta(), list.get(i).getSet_as_demo(), list.get(i).getThumbnail()));
                            }
                            if (BuildConfig.FLAVOR.equalsIgnoreCase("targetonapp")) {
                                ArrayList arrayList2 = new ArrayList();
                                for (TilesItem tilesItem : arrayList) {
                                    if (!tilesItem.getType().equalsIgnoreCase("content")) {
                                        arrayList2.add(tilesItem);
                                    }
                                }
                                arrayList.clear();
                                arrayList.addAll(arrayList2);
                            }
                            data.setTiles(arrayList);
                            this.courseDetail.setData(data);
                            setCourseRelatedData();
                        } else {
                            this.myDBClass.getCourseDetaildata().deletecoursedetail(SingleStudy.parentCourseId, MakeMyExam.userId);
                            this.networkCall.NetworkAPICall(API.CourseDetail_JS, "", true, false);
                        }
                    }
                }
            }
            this.tax_layout1.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda29
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onCreate$2(view);
                }
            });
            this.book_coupon_applied.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda30
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onCreate$3(view);
                }
            });
            this.totalPrice.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda31
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PurchaseActivity.lambda$onCreate$4(view);
                }
            });
            this.totalPrice1.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda32
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PurchaseActivity.lambda$onCreate$5(view);
                }
            });
            if (this.hassCourseDetail) {
                if (this.courseDetail.getData().getCourseDetail().getValidity() != null && (this.courseDetail.getData().getCourseDetail().getValidity().equals("0") || this.courseDetail.getData().getCourseDetail().getValidity().equalsIgnoreCase("0 Days") || this.courseDetail.getData().getCourseDetail().getValidity().equals("-1") || this.courseDetail.getData().getCourseDetail().getValidity().equalsIgnoreCase("-1 Days"))) {
                    this.validityTV.setVisibility(8);
                    this.txtValidityCourse.setVisibility(8);
                } else {
                    this.validityTV.setVisibility(0);
                    this.txtValidityCourse.setVisibility(0);
                    String validity = this.courseDetail.getData().getCourseDetail().getValidity();
                    if (!validity.equalsIgnoreCase("")) {
                        this.txtValidityCourse.setText(validity);
                    } else {
                        this.txtValidityCourse.setText("N/A");
                    }
                }
                if (this.isBook.equalsIgnoreCase("1")) {
                    this.addAddressBtn.setVisibility(0);
                    this.deliveryChargeRL.setVisibility(0);
                    this.deliveryChargeRL2.setVisibility(0);
                } else if (this.isBook.equalsIgnoreCase("0")) {
                    if (isComboBook()) {
                        this.addAddressBtn.setVisibility(0);
                        this.deliveryChargeRL.setVisibility(8);
                        this.deliveryChargeRL2.setVisibility(8);
                    } else {
                        this.addAddressBtn.setVisibility(8);
                        this.deliveryChargeRL.setVisibility(8);
                        this.deliveryChargeRL2.setVisibility(8);
                    }
                }
                this.emiRecyclerList.setHasFixedSize(true);
                this.emiRecyclerList.setLayoutManager(new LinearLayoutManager(this));
                setClicks();
            }
            if (this.isBook.equalsIgnoreCase("1") || isComboBook()) {
                hitApiForGettingAddress(true);
            } else {
                this.addressCV.setVisibility(8);
            }
            if (this.isBook.equalsIgnoreCase("1")) {
                this.quantityLayout.setVisibility(0);
                this.quantityMainLayout.setVisibility(0);
                this.noOfQuantity.setText(String.valueOf(this.quantityOfBooks));
            } else {
                this.quantityLayout.setVisibility(8);
                this.quantityMainLayout.setVisibility(8);
            }
            if ("1".equalsIgnoreCase("6")) {
                this.img_back.setColorFilter(ContextCompat.getColor(this, R.color.whie), PorterDuff.Mode.MULTIPLY);
                this.procceed.setTextColor(ContextCompat.getColor(this, R.color.whie));
            }
        }
        if (!"1".equalsIgnoreCase("2")) {
            this.img_back.setColorFilter(ContextCompat.getColor(this, R.color.whiteApp), PorterDuff.Mode.SRC_IN);
            this.toolbarTitleTV.setTextColor(ContextCompat.getColor(this, R.color.whiteApp));
            this.procceed.setTextColor(ContextCompat.getColor(this, R.color.whiteApp));
        }
        if (SharedPreference.getInstance().getString(Const.BOOK_QUANTITY).equalsIgnoreCase("0")) {
            this.quantityLayout.setVisibility(8);
            this.quantityMainLayout.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$0() {
        lambda$onCreate$2(this);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        Intent intent = this.activity.getIntent();
        this.activity.finish();
        this.activity.startActivity(intent);
        this.activity.overridePendingTransition(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(View view) {
        openApplyCouponDialogBoxBook();
    }

    private void setSubscriptionTypes() {
        this.procceed = (Button) findViewById(R.id.procceed);
        TextView textView = (TextView) findViewById(R.id.toolbarTitleTV);
        this.toolbarTitleTV = textView;
        textView.setText(R.string.subscription_plan);
        this.procceed.setText("Try for " + this.courseDetail1.getData().getCourseDetail().getValidity() + " in ₹" + this.courseDetail1.getData().getCourseDetail().getCourseSp().split("\\.")[0]);
        manageQRButton();
        this.subscriptionPlanRecycler = (RecyclerView) findViewById(R.id.subscriptionPlanRecycler);
        this.subscriptionDescription = (WebView) findViewById(R.id.subscriptionDescription);
        this.subscriptionBenefits = (TextView) findViewById(R.id.subscriptionBenefits);
        this.subscriptionRelativeLayout = (RelativeLayout) findViewById(R.id.subscriptionRelativeLayout);
        TextView textView2 = (TextView) findViewById(R.id.subscription_amount);
        this.subscription_amount = textView2;
        textView2.setText(this.courseDetail1.getData().getCourseDetail().getCourseSp().split("\\.")[0]);
        this.subscriptionPlanRecycler.setLayoutManager(new LinearLayoutManager(this));
        SubscriptionPlanAdapter subscriptionPlanAdapter = new SubscriptionPlanAdapter(this, (SubscriptionDataItem[]) this.courseDetail1.getData().getSubscriptionAllData().getSubscriptionData().toArray(new SubscriptionDataItem[0]), this);
        this.subscriptionPlanAdapter = subscriptionPlanAdapter;
        this.subscriptionPlanRecycler.setAdapter(subscriptionPlanAdapter);
    }

    private void openTotalPriceInfo(View anchorView) {
        try {
            final PopupWindow popupWindow = new PopupWindow(((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.price_info_layout, (ViewGroup) null), -2, -2, true);
            popupWindow.setFocusable(true);
            popupWindow.showAsDropDown(anchorView, 0, 0, 48);
            popupWindow.setAnimationStyle(R.style.DialogTheme);
            new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.Payment.PurchaseActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    popupWindow.dismiss();
                }
            }, 2000L);
        } catch (Exception e2) {
            Log.d("TAGPRICEINFO", "openTotalPriceInfo: " + e2.getMessage());
        }
    }

    private void setCourseRelatedData() {
        boolean z;
        try {
            this.is_gst = this.courseDetail.getData().getCourseDetail().getIs_gst();
            CourseDetail courseDetail = this.courseDetail;
            if (courseDetail != null && courseDetail.getData() != null) {
                this.paymentViewModel.setCourseId(this.courseDetail.getData().getCourseDetail().getId());
                this.networkCall.NetworkAPICall(API.GET_COUPON_OVER_COURSE, "", true, false);
                if (!TextUtils.isEmpty(this.courseDetail.getData().getCourseDetail().getCat_type()) && this.courseDetail.getData().getCourseDetail().getCat_type().equalsIgnoreCase("1")) {
                    if (!TextUtils.isEmpty(this.courseDetail.getData().getCourseDetail().getCover_image())) {
                        Helper.setThumbnailImage(this, this.courseDetail.getData().getCourseDetail().getCover_image(), getDrawable(R.mipmap.square_placeholder), this.imageIV);
                    } else {
                        this.imageIV.setImageResource(R.mipmap.square_placeholder);
                    }
                } else if (!TextUtils.isEmpty(this.courseDetail.getData().getCourseDetail().getDescHeaderImage())) {
                    Helper.setThumbnailImage(this.activity, this.courseDetail.getData().getCourseDetail().getDescHeaderImage(), this.activity.getResources().getDrawable(R.mipmap.placeholder_course), this.imageIV);
                } else {
                    this.imageIV.setImageResource(R.mipmap.placeholder_course);
                }
                if (SharedPreference.getInstance().getUserCoupon() != null && SharedPreference.getInstance().getUserCoupon().getAvailable() != null) {
                    CouponPojo userCoupon = SharedPreference.getInstance().getUserCoupon();
                    if (userCoupon == null || userCoupon.getAvailable() == null || userCoupon.getAvailable().size() <= 0) {
                        z = false;
                    } else {
                        z = false;
                        for (Available available : userCoupon.getAvailable()) {
                            if (available.getCourses().size() > 0) {
                                Iterator<CoursesCoupon> it = available.getCourses().iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        if (this.courseDetail.getData().getCourseDetail().getId().equalsIgnoreCase(it.next().getId()) && Long.parseLong(available.getEnd()) * 1000 > Calendar.getInstance().getTimeInMillis()) {
                                            String coupon_value = available.getCoupon_value();
                                            if (available.getCoupon_type().equalsIgnoreCase("1")) {
                                                this.scholarshipCouponTV.setText(this.activity.getResources().getString(R.string.rupees) + coupon_value + " Scholarship is applied.");
                                                this.emi_scholarshipCouponTV.setText(this.activity.getResources().getString(R.string.rupees) + coupon_value + " Scholarship is applied.");
                                            } else {
                                                this.scholarshipCouponTV.setText(coupon_value + "% Scholarship is applied.");
                                                this.emi_scholarshipCouponTV.setText(coupon_value + "% Scholarship is applied.");
                                            }
                                            z = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (z) {
                        this.ll_scholorship_discount.setVisibility(0);
                        this.ll_emi_scholorship_discount.setVisibility(0);
                    } else {
                        this.ll_scholorship_discount.setVisibility(8);
                        this.ll_emi_scholorship_discount.setVisibility(8);
                    }
                } else {
                    this.ll_scholorship_discount.setVisibility(8);
                    this.ll_emi_scholorship_discount.setVisibility(8);
                }
                Helper.setThumbnailImage(this, this.courseDetail.getData().getCourseDetail().getCover_image(), getDrawable(R.drawable.placeholder), this.imageCourse);
                this.coursenameTV.setText(this.courseDetail.getData().getCourseDetail().getTitle());
                if (!GenericUtils.isEmpty(this.courseDetail.getData().getCourseDetail().getAuthor().getTitle()) && !this.courseDetail.getData().getCourseDetail().getAuthor().getTitle().equalsIgnoreCase("Utkarsh classes")) {
                    this.coursenameEmi.setText(this.activity.getResources().getString(R.string.by) + this.courseDetail.getData().getCourseDetail().getAuthor().getTitle());
                    this.coursenameTV1.setText(this.activity.getResources().getString(R.string.by) + this.courseDetail.getData().getCourseDetail().getAuthor().getTitle());
                } else {
                    this.coursenameEmi.setText(this.activity.getResources().getString(R.string.by) + this.activity.getResources().getString(R.string.app_name));
                    this.coursenameTV1.setText(this.activity.getResources().getString(R.string.by) + this.activity.getResources().getString(R.string.app_name));
                }
                this.titleTxtCourse.setText(this.courseDetail.getData().getCourseDetail().getTitle());
                this.apply_couponCvr.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$setCourseRelatedData$6();
                    }
                }));
                this.remove.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setCourseRelatedData$7(view);
                    }
                });
            }
            CourseDetail courseDetail2 = this.courseDetail;
            if (courseDetail2 != null && courseDetail2.getData().getCourseDetail().getInstallment() != null && !this.courseDetail.getData().getCourseDetail().getInstallment().equalsIgnoreCase("")) {
                try {
                    this.courseDetail.getData().setInstalment((InstallmentResponse) new Gson().fromJson(this.courseDetail.getData().getCourseDetail().getInstallment(), InstallmentResponse.class));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            loadDataAsPerSubscriptions();
            if (this.courseDetail.getData().getCourseDetail().getValidity() != null && (this.courseDetail.getData().getCourseDetail().getValidity().equals("0") || this.courseDetail.getData().getCourseDetail().getValidity().equalsIgnoreCase("0 Days") || this.courseDetail.getData().getCourseDetail().getValidity().equals("-1") || this.courseDetail.getData().getCourseDetail().getValidity().equalsIgnoreCase("-1 Days"))) {
                this.validityTV.setVisibility(8);
                this.txtValidityCourse.setVisibility(8);
            } else {
                this.validityTV.setVisibility(0);
                this.txtValidityCourse.setVisibility(0);
                String validity = this.courseDetail.getData().getCourseDetail().getValidity();
                if (!validity.equalsIgnoreCase("")) {
                    this.txtValidityCourse.setText(validity);
                } else {
                    this.txtValidityCourse.setText("N/A");
                }
            }
            if (this.isBook.equalsIgnoreCase("1")) {
                this.addAddressBtn.setVisibility(0);
                this.deliveryChargeRL.setVisibility(0);
                this.deliveryChargeRL2.setVisibility(0);
            } else if (this.isBook.equalsIgnoreCase("0")) {
                if (isComboBook()) {
                    this.addAddressBtn.setVisibility(0);
                    this.deliveryChargeRL.setVisibility(8);
                    this.deliveryChargeRL2.setVisibility(8);
                } else {
                    this.addAddressBtn.setVisibility(8);
                    this.deliveryChargeRL.setVisibility(8);
                    this.deliveryChargeRL2.setVisibility(8);
                }
            }
            this.emiRecyclerList.setHasFixedSize(true);
            this.emiRecyclerList.setLayoutManager(new LinearLayoutManager(this));
            setClicks();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setCourseRelatedData$6() {
        lambda$onCreate$2(this);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setCourseRelatedData$7(View view) {
        Intent intent = this.activity.getIntent();
        this.activity.finish();
        this.activity.startActivity(intent);
        this.activity.overridePendingTransition(0, 0);
    }

    private void openApplyReferralDialogBox() {
        final Dialog dialog = new Dialog(this, R.style.BottomSheetDialog);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(R.layout.bottom_sheet_referral);
        dialog.getWindow().setLayout(-1, -2);
        final EditText editText = (EditText) dialog.findViewById(R.id.coupon_edt);
        TextView textView = (TextView) dialog.findViewById(R.id.cancel);
        TextView textView2 = (TextView) dialog.findViewById(R.id.apply);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$openApplyReferralDialogBox$9(editText, dialog, view);
            }
        });
        this.clear_referral_code.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$openApplyReferralDialogBox$10(view);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openApplyReferralDialogBox$9(EditText editText, Dialog dialog, View view) {
        if (!TextUtils.isEmpty(editText.getText().toString())) {
            this.coupon_applied_rl.setVisibility(0);
            this.clear_referral_code.setVisibility(0);
            this.display_referral_code.setText(editText.getText().toString());
            this.appliedCouponCode = editText.getText().toString();
            this.networkCall.NetworkAPICall(API.verifyCoupon, "", true, false);
            dialog.dismiss();
            return;
        }
        Toast.makeText(this, "Please Enter Coupon Code", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openApplyReferralDialogBox$10(View view) {
        this.appliedCouponCode = "";
        this.coupon_applied_rl.setVisibility(8);
        this.clear_referral_code.setVisibility(8);
    }

    private void openApplyExamCenterDialogBox(List<ExamCenter> examCenters) {
        Dialog dialog = new Dialog(this, R.style.BottomSheetDialog);
        this.bottomSheetDialogExamCenter = dialog;
        dialog.requestWindowFeature(1);
        this.bottomSheetDialogExamCenter.setCancelable(true);
        this.bottomSheetDialogExamCenter.setCanceledOnTouchOutside(true);
        this.bottomSheetDialogExamCenter.setContentView(R.layout.bottom_sheet_exam_center);
        this.bottomSheetDialogExamCenter.getWindow().setLayout(-1, -2);
        RecyclerView recyclerView = (RecyclerView) this.bottomSheetDialogExamCenter.findViewById(R.id.recycler_center);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ChooseCenterRecycler(this, examCenters));
        this.bottomSheetDialogExamCenter.show();
    }

    public void changeLayoutExamCenter(String displayExamCenter) {
        this.bottomSheetDialogExamCenter.dismiss();
        this.clear_exam_center.setVisibility(0);
        this.center_applied_rl.setVisibility(0);
        this.display_exam_center.setText(displayExamCenter);
        this.clear_exam_center.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda49
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$changeLayoutExamCenter$11(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$changeLayoutExamCenter$11(View view) {
        this.exam_center_position = -1;
        this.clear_exam_center.setVisibility(8);
        this.center_applied_rl.setVisibility(8);
    }

    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem item) {
        float f2;
        float f3;
        if (this.clicktype.equalsIgnoreCase("2")) {
            for (SubscriptionMetaItem subscriptionMetaItem : this.subscriptionValidityListForDeliveryMethod) {
                if (subscriptionMetaItem.getPlanTitle().equalsIgnoreCase(item.getTitle().toString())) {
                    this.deliveryId.setText(subscriptionMetaItem.getPlanTitle());
                    this.subscriptionValidityList.clear();
                    this.validityId.setText(getString(R.string.select_validity));
                    this.txtGrandTotalValue.setText(String.format("", new Object[0]));
                    this.totalPriceValue.setText(String.format("", new Object[0]));
                    this.tax_value.setText(String.format("", new Object[0]));
                    this.courseDetail.getData().getCourseDetail().setMrp("");
                    this.courseDetail.getData().getCourseDetail().setTax("");
                    if (MakeMyExam.isDeliveryAddressNeeded) {
                        f2 = Float.parseFloat(subscriptionMetaItem.getPrice()) + Float.parseFloat(subscriptionMetaItem.getTax());
                        f3 = Float.parseFloat(subscriptionMetaItem.getDelivery_charge_subscription());
                    } else {
                        f2 = Float.parseFloat(subscriptionMetaItem.getPrice());
                        f3 = Float.parseFloat(subscriptionMetaItem.getTax());
                    }
                    this.validityId.setText(subscriptionMetaItem.getValidityMy());
                    this.txtGrandTotalValue.setText(String.format("%s %s", getResources().getString(R.string.rs), String.format("%.2f", Float.valueOf(f2 + f3))));
                    this.totalPriceValue.setText(String.format("%s %s", getResources().getString(R.string.rs), String.format("%.2f", Float.valueOf(Float.parseFloat(subscriptionMetaItem.getPrice())))));
                    this.tax_value.setText(String.format("%s %s", getResources().getString(R.string.rs), String.format("%.2f", Float.valueOf(Float.parseFloat(subscriptionMetaItem.getTax())))));
                    this.courseDetail.getData().getCourseDetail().setMrp(subscriptionMetaItem.getPrice());
                    this.courseDetail.getData().getCourseDetail().setTax(subscriptionMetaItem.getTax());
                    this.courseDetail.getData().getSubscriptionAllData().setPlanId(subscriptionMetaItem.getSubscriptionId());
                    if (!this.courseDetail.getData().getCourseDetail().getMrp().isEmpty()) {
                        priceUpdate(Float.parseFloat(this.courseDetail.getData().getCourseDetail().getMrp()) + Float.parseFloat(this.courseDetail.getData().getCourseDetail().getTax()));
                    }
                    if (subscriptionMetaItem.getDelivery_charge_subscription().equalsIgnoreCase("0")) {
                        MakeMyExam.isDeliveryAddressNeeded = false;
                        this.deliveryCharge = "";
                    } else {
                        MakeMyExam.isDeliveryAddressNeeded = true;
                        this.deliveryCharge = subscriptionMetaItem.getDelivery_charge_subscription();
                    }
                }
            }
        } else if (this.clicktype.equalsIgnoreCase("3")) {
            for (SubscriptionMetaItem subscriptionMetaItem2 : this.subscriptionValidityList) {
                if (subscriptionMetaItem2.getValidityMy().equalsIgnoreCase(item.getTitle().toString())) {
                    this.validityId.setText(subscriptionMetaItem2.getValidityMy());
                    this.txtGrandTotalValue.setText(String.format("%s %s", getResources().getString(R.string.rs), String.format("%.2f", Float.valueOf(Float.parseFloat(subscriptionMetaItem2.getPrice())))));
                    this.totalPriceValue.setText(String.format("%s %s", getResources().getString(R.string.rs), String.format("%.2f", Float.valueOf(Float.parseFloat(subscriptionMetaItem2.getPrice())))));
                    this.tax_value.setText(String.format("%s %s", getResources().getString(R.string.rs), String.format("%.2f", Float.valueOf(Float.parseFloat(subscriptionMetaItem2.getTax())))));
                    this.courseDetail.getData().getCourseDetail().setMrp(subscriptionMetaItem2.getPrice());
                    this.courseDetail.getData().getCourseDetail().setTax(subscriptionMetaItem2.getTax());
                    this.courseDetail.getData().getSubscriptionAllData().setPlanId(subscriptionMetaItem2.getSubscriptionId());
                    if (!this.courseDetail.getData().getCourseDetail().getMrp().isEmpty()) {
                        priceUpdate(Float.parseFloat(this.courseDetail.getData().getCourseDetail().getMrp()) + Float.parseFloat(this.courseDetail.getData().getCourseDetail().getTax()));
                    }
                }
            }
        } else if (this.clicktype.equalsIgnoreCase("1")) {
            for (SubscriptionMetaItem subscriptionMetaItem3 : this.subscriptionAllData.getSubscriptionMeta()) {
                if (subscriptionMetaItem3.getPlateformsName().equalsIgnoreCase(item.getTitle().toString())) {
                    this.deliveryId1.setText(subscriptionMetaItem3.getPlateformsName());
                    this.subscriptionValidityListForDeliveryMethod.clear();
                    this.subscriptionValidityList.clear();
                    this.validityId.setText(getString(R.string.select_validity));
                    this.deliveryId.setText(getString(R.string.select_your_subscription_plan));
                    this.txtGrandTotalValue.setText(String.format("", new Object[0]));
                    this.totalPriceValue.setText(String.format("", new Object[0]));
                    this.tax_value.setText(String.format("", new Object[0]));
                    this.courseDetail.getData().getCourseDetail().setMrp("");
                    this.courseDetail.getData().getCourseDetail().setTax("");
                    for (SubscriptionMetaItem subscriptionMetaItem4 : this.subscriptionAllData.getSubscriptionMeta()) {
                        if (subscriptionMetaItem4.getPlateformsName().equalsIgnoreCase(subscriptionMetaItem3.getPlateformsName())) {
                            this.subscriptionValidityListForDeliveryMethod.add(subscriptionMetaItem4);
                        }
                    }
                }
            }
        }
        return false;
    }

    public void setDataForSaveAddress(AddressMaster addressMaster) {
        this.addressMaster = addressMaster;
    }

    public void deleteAddress(final ArrayList<AddressMaster> addressMasterList, final AddressAdapter addressAdapter, final int addressPosition) {
        DialogUtils.makeDialog(this, "Delete", "Are you sure?", getResources().getString(R.string.yes), getResources().getString(R.string.no), true, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Payment.PurchaseActivity.3
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
            public void onOKClick() {
                AddressMaster addressMaster = (AddressMaster) addressMasterList.get(addressPosition);
                PurchaseActivity.this.addressAdapter = addressAdapter;
                PurchaseActivity.this.addressListMaster = addressMasterList;
                PurchaseActivity.this.addressId = addressMaster.getId();
                PurchaseActivity.this.addressPosition = addressPosition;
                PurchaseActivity.this.networkCall.NetworkAPICall(API.DELETE_USER_ADDRESS, "", false, false);
            }
        }, new DialogUtils.onDialogUtilsCancelClick() { // from class: com.appnew.android.Payment.PurchaseActivity.4
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsCancelClick
            public void onCancelClick() {
            }
        });
    }

    @Override // com.appnew.android.Payment.OnAddressAddDeleteClicked
    public void onAddAddressClicked(Dialog dialog, AddressMaster addressMaster) {
        addressDailogInner(dialog, addressMaster);
    }

    @Override // com.appnew.android.Payment.OnAddressAddDeleteClicked
    public void onDeleteAddressClicked(ArrayList<AddressMaster> addressMasterList, AddressAdapter addressAdapter, int adapterPosition) {
        deleteAddress(addressMasterList, addressAdapter, adapterPosition);
    }

    @Override // com.appnew.android.Payment.SubscriptionPlanAdapter.OnPlanClickListener
    public void onPlanClick(SubscriptionDataItem item) {
        this.planId = item.getId();
        this.subscriptionDescription.setVisibility(0);
        this.subscriptionBenefits.setVisibility(0);
        this.subscriptionDescription.getSettings().setJavaScriptEnabled(true);
        this.subscriptionDescription.loadDataWithBaseURL(null, item.getDescription(), Mimetypes.MIMETYPE_HTML, "utf-8", null);
    }

    public class ChooseCenterRecycler extends RecyclerView.Adapter<ViewHolder> {
        Context context;
        List<ExamCenter> examCenters;

        public ChooseCenterRecycler(Context context, List<ExamCenter> examCenters) {
            this.context = context;
            this.examCenters = examCenters;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.item_exam_center, parent, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(ViewHolder holder, final int position) {
            final ExamCenter examCenter = this.examCenters.get(position);
            if (examCenter.isChecked()) {
                holder.check_box.setChecked(true);
            } else {
                holder.check_box.setChecked(false);
            }
            holder.exam_center_text.setText(examCenter.getName());
            holder.main_rl.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$ChooseCenterRecycler$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(position, examCenter, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(int i, ExamCenter examCenter, View view) {
            PurchaseActivity.this.exam_center_position = i;
            ((PurchaseActivity) this.context).changeLayoutExamCenter(examCenter.getName());
            int i2 = 0;
            while (i2 < this.examCenters.size()) {
                this.examCenters.get(i2).setChecked(i2 == i);
                i2++;
            }
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.examCenters.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            CheckBox check_box;
            TextView exam_center_text;
            RelativeLayout main_rl;

            public ViewHolder(View itemView) {
                super(itemView);
                this.exam_center_text = (TextView) itemView.findViewById(R.id.exam_center_text);
                this.check_box = (CheckBox) itemView.findViewById(R.id.check_box);
                this.main_rl = (RelativeLayout) itemView.findViewById(R.id.main_rl);
            }
        }
    }

    private void setIds() {
        this.scholarshipCouponTV = (TextView) findViewById(R.id.scholarshipCouponTV);
        this.emi_scholarshipCouponTV = (TextView) findViewById(R.id.emi_scholarshipCouponTV);
        this.ll_scholorship_discount = (LinearLayout) findViewById(R.id.ll_scholorship_discount);
        this.ll_emi_scholorship_discount = (LinearLayout) findViewById(R.id.ll_emi_scholorship_discount);
        this.emiPayBtnCvr = (LinearLayoutCompat) findViewById(R.id.emiPayBtnCvr);
        this.referral_rl = (RelativeLayout) findViewById(R.id.referral_rl);
        this.view_plan_tv = (TextView) findViewById(R.id.view_plan_tv);
        this.coupon_applied_rl = (RelativeLayout) findViewById(R.id.coupon_applied_rl);
        this.choose_center_rl = (RelativeLayout) findViewById(R.id.choose_center_rl);
        this.center_applied_rl = (RelativeLayout) findViewById(R.id.center_applied_rl);
        this.referral_code = (TextView) findViewById(R.id.referral_code);
        this.display_referral_code = (TextView) findViewById(R.id.display_referral_code);
        this.choose_center_text = (TextView) findViewById(R.id.choose_center_text);
        this.display_exam_center = (TextView) findViewById(R.id.display_exam_center);
        this.clear_referral_code = (ImageView) findViewById(R.id.clear_referral_code);
        this.clear_exam_center = (ImageView) findViewById(R.id.clear_exam_center);
        this.subscriptionSectionId = (LinearLayoutCompat) findViewById(R.id.subscriptionSectionId);
        this.deliveryId1 = (TextView) findViewById(R.id.deliveryId1);
        this.validityId = (TextView) findViewById(R.id.validityId);
        this.deliveryId = (TextView) findViewById(R.id.deliveryId);
        this.book_coupon_applied = (TextView) findViewById(R.id.book_coupon_applied);
        this.tax_layout1 = (RelativeLayout) findViewById(R.id.tax_layout1);
        this.referral_code.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda52
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setIds$12(view);
            }
        });
        this.view_plan_tv.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda53
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setIds$13(view);
            }
        });
        this.choose_center_text.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda54
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setIds$14(view);
            }
        });
        this.txtEmiPayment = (TextView) findViewById(R.id.txtEmiPayment);
        this.txtOnetimePayment = (TextView) findViewById(R.id.txtOnetimePayment);
        this.layout_course = (RelativeLayout) findViewById(R.id.layout_course);
        this.emiTypeLayout = (RelativeLayout) findViewById(R.id.emiTypeLayout);
        this.txtValidityCourse = (TextView) findViewById(R.id.txtValidityCourse);
        this.total_layout = (RelativeLayout) findViewById(R.id.total_layout);
        this.titleTxtCourse = (TextView) findViewById(R.id.titleTxtCourse);
        this.priceTxtCourse = (TextView) findViewById(R.id.priceTxtCourse);
        this.imageCourse = (ImageView) findViewById(R.id.imageCourse);
        this.cvrImage = (CardView) findViewById(R.id.cvrImage);
        this.imEmiPayment = (ImageView) findViewById(R.id.imEmiPayment);
        this.imOneTimePayment = (ImageView) findViewById(R.id.imOneTimePayment);
        this.coverEmiPaymentBtn = (CardView) findViewById(R.id.coverEmiPaymentBtn);
        this.coverOneTimePaymentBtn = (CardView) findViewById(R.id.coverOneTimePaymentBtn);
        this.installmentInfo = (RelativeLayout) findViewById(R.id.installmentInfo);
        this.installmentInfo1 = (RelativeLayout) findViewById(R.id.installmentInfo1);
        this.installmentTB = (RelativeLayout) findViewById(R.id.installmentTB);
        this.txtInstallmentValue = (TextView) findViewById(R.id.txtInstallmentValue);
        this.emiRecyclerList = (RecyclerView) findViewById(R.id.emiRecyclerList);
        this.tax_layout = (LinearLayoutCompat) findViewById(R.id.tax_layout);
        this.gstTv = (TextView) findViewById(R.id.gstTv);
        this.oneTimePayBtnCvr = (LinearLayoutCompat) findViewById(R.id.oneTimePayBtnCvr);
        this.imageIV = (RoundedImageView) findViewById(R.id.imageIV);
        this.tax_value = (TextView) findViewById(R.id.tax_value);
        this.validityTV = (TextView) findViewById(R.id.validityTV);
        this.quantityMainLayout = (RelativeLayout) findViewById(R.id.quantityMainLayout);
        this.quantityLayout = (RelativeLayout) findViewById(R.id.quantityLayout);
        this.noOfQuantity = (TextView) findViewById(R.id.noOfQuantity1);
        this.noOfQuantityInCaseCoupon = (TextView) findViewById(R.id.noOfQuantity);
        this.tax_value1 = (TextView) findViewById(R.id.tax_value1);
        this.txtAmountValue = (TextView) findViewById(R.id.txtAmountValue);
        this.txtPricesValue1 = (TextView) findViewById(R.id.txtPricesValue);
        this.totalPriceValue1 = (TextView) findViewById(R.id.totalPriceValue1);
        this.termCondTV = (TextView) findViewById(R.id.termCondTV);
        this.txtTaxValue1 = (TextView) findViewById(R.id.txtTaxValue);
        this.sgstValueCoupon = (TextView) findViewById(R.id.sgstValueCoupon);
        this.cgstValueCoupon = (TextView) findViewById(R.id.cgstValueCoupon);
        this.txtGrandTotalValue1 = (TextView) findViewById(R.id.txtGrandTotalValue1);
        this.img_back = (ImageView) findViewById(R.id.image_back);
        this.main_toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        this.terms_check = (CheckBox) findViewById(R.id.terms_check);
        this.checkTncRL = (RelativeLayout) findViewById(R.id.checkTncRL);
        this.coupon_applied_extra = (TextView) findViewById(R.id.coupon_applied_extra);
        this.tax_value2 = (TextView) findViewById(R.id.tax_value2);
        this.taxLayout = (RelativeLayout) findViewById(R.id.taxLayout);
        this.cgstLayout = (RelativeLayout) findViewById(R.id.cgstLayout);
        this.cgstLayoutCoupon = (RelativeLayout) findViewById(R.id.cgstLayoutCoupon);
        this.sgstLayout = (RelativeLayout) findViewById(R.id.sgstLayout);
        this.sgstLayoutCoupon = (RelativeLayout) findViewById(R.id.sgstLayoutCoupon);
        this.taxes_layout = (RelativeLayout) findViewById(R.id.taxes_layout);
        this.cgstValue = (TextView) findViewById(R.id.cgstValue);
        this.sgstValue = (TextView) findViewById(R.id.sgstValue);
        this.txtGrandTotalValue = (TextView) findViewById(R.id.txtGrandTotalValue);
        this.coursenameTV = (TextView) findViewById(R.id.coursenameTV);
        this.coupon_code_applied = (TextView) findViewById(R.id.coupon_code_applied);
        this.coursenameTV1 = (TextView) findViewById(R.id.coursenameTV1);
        this.coursenameEmi = (TextView) findViewById(R.id.coursenameEmi);
        this.openQR = (Button) findViewById(R.id.openQR);
        this.procceed = (Button) findViewById(R.id.procceed);
        this.totalPrice = (TextView) findViewById(R.id.totalPrice);
        this.totalPrice1 = (TextView) findViewById(R.id.totalPrice1);
        this.totalPriceValue = (TextView) findViewById(R.id.totalPriceValue);
        this.apply_couponCvr = (RelativeLayout) findViewById(R.id.apply_couponCvr);
        this.remove = (ImageView) findViewById(R.id.remove);
        this.withCouponLayout = (RelativeLayout) findViewById(R.id.withCouponLayout);
        this.total_amount_layout1 = (RelativeLayout) findViewById(R.id.total_amount_layout1);
        this.extraCouponLayout = (RelativeLayout) findViewById(R.id.extraCouponLayout);
        this.withoutCouponLayout = (RelativeLayout) findViewById(R.id.withoutCouponLayout);
        this.dummycoupon_layout = (RelativeLayout) findViewById(R.id.dummycoupon_layout);
        this.couponLayout = (CardView) findViewById(R.id.couponLayout);
        this.addressCV = (RelativeLayout) findViewById(R.id.addressCV);
        this.addAddressBtn = (Button) findViewById(R.id.addAddressBtn);
        this.addedAddressLL = (LinearLayout) findViewById(R.id.addedAddressLL);
        this.addedAddressTV = (TextView) findViewById(R.id.addedAddressTV);
        this.nameAddressTv = (TextView) findViewById(R.id.nameAddressTv);
        this.mobileNumber = (TextView) findViewById(R.id.mobileNumber);
        this.mobileNumberAlternate = (TextView) findViewById(R.id.mobileNumberAlternate);
        this.editAddressIV = (ImageView) findViewById(R.id.editAddressIV);
        this.deliveryChargeRL = (RelativeLayout) findViewById(R.id.deliveryChargeRL);
        this.deliveryChargeTV = (TextView) findViewById(R.id.deliveryChargeTV);
        this.deliveryChargeRL2 = (RelativeLayout) findViewById(R.id.deliveryChargeRL2);
        this.deliveryChargeTV2 = (TextView) findViewById(R.id.deliveryChargeTV2);
        this.toolbarTitleTV = (TextView) findViewById(R.id.toolbarTitleTV);
        if (SharedPreference.getInstance().getString(Const.NEED_BASED_TEST) != null && !TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.NEED_BASED_TEST)) && SharedPreference.getInstance().getString(Const.NEED_BASED_TEST).equalsIgnoreCase("1")) {
            this.referral_rl.setVisibility(0);
        } else {
            this.referral_rl.setVisibility(8);
        }
        BottomSetting bottomSetting = this.bottomSetting;
        if (bottomSetting != null && bottomSetting.getLayout_type() != null && this.bottomSetting.getLayout_type().equals("1") && !"1".equalsIgnoreCase("6")) {
            ((ConstraintLayout.LayoutParams) this.imageIV.getLayoutParams()).dimensionRatio = "1:1";
        }
        setThumbRatio(this.cvrImage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setIds$12(View view) {
        openApplyReferralDialogBox();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setIds$13(View view) {
        MainAdapter mainAdapter = this.adapter;
        if (mainAdapter == null || mainAdapter.arrayList == null || this.adapter.arrayList.size() <= 0) {
            return;
        }
        onViewDetailsClick(this.adapter.selectedPosition, this.adapter.arrayList.get(this.adapter.selectedPosition), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setIds$14(View view) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ExamCenter("nnbdshdsbjk", false));
        arrayList.add(new ExamCenter("nmbjhbjjbkj", false));
        arrayList.add(new ExamCenter("kjnjkbkjbjk", false));
        arrayList.add(new ExamCenter("kkjjkbjkbjn", false));
        arrayList.add(new ExamCenter("jkkjbjkbbkj", false));
        arrayList.add(new ExamCenter("lknklnknkln", false));
        arrayList.add(new ExamCenter("llknklklnkk", false));
        arrayList.add(new ExamCenter("jknjknkjkjj", false));
        if (this.exam_center_position != -1) {
            int i = 0;
            while (i < arrayList.size()) {
                arrayList.get(i).setChecked(i == this.exam_center_position);
                i++;
            }
        }
        openApplyExamCenterDialogBox(arrayList);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (Helper.isNewLoginFlow() || Helper.isHideProfilePop()) {
            return;
        }
        if (SharedPreference.getInstance().getLoggedInUser() == null || SharedPreference.getInstance().getLoggedInUser().getState() == null || SharedPreference.getInstance().getLoggedInUser().getCity() == null || SharedPreference.getInstance().getLoggedInUser().getName() == null || SharedPreference.getInstance().getLoggedInUser().getEmail() == null || SharedPreference.getInstance().getLoggedInUser().getMobile() == null || TextUtils.isEmpty(SharedPreference.getInstance().getLoggedInUser().getName()) || TextUtils.isEmpty(SharedPreference.getInstance().getLoggedInUser().getEmail()) || TextUtils.isEmpty(SharedPreference.getInstance().getLoggedInUser().getMobile()) || TextUtils.isEmpty(SharedPreference.getInstance().getLoggedInUser().getState()) || TextUtils.isEmpty(SharedPreference.getInstance().getLoggedInUser().getCity())) {
            DialogUtils.makeDialog(this, "Profile is not updated", "Please Update your profile", getResources().getString(R.string.yes), getResources().getString(R.string.no), false, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda13
                @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
                public final void onOKClick() {
                    this.f$0.lambda$onResume$15();
                }
            }, new DialogUtils.onDialogUtilsCancelClick() { // from class: com.appnew.android.Payment.PurchaseActivity.5
                @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsCancelClick
                public void onCancelClick() {
                    PurchaseActivity.this.finish();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$15() {
        if (Helper.isConnected(this)) {
            Intent intent = new Intent(this, (Class<?>) ProfileActivity.class);
            intent.putExtra("email_enable", true);
            intent.putExtra("mobile_enable", true);
            intent.putExtra("hide_password", true);
            startActivity(intent);
            overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
            return;
        }
        Toast.makeText(this, getResources().getString(R.string.no_internet_connection), 0).show();
    }

    private void setClicks() {
        this.oneTimePayBtnCvr.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda38
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setClicks$16(view);
            }
        });
        this.emiPayBtnCvr.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda39
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setClicks$17(view);
            }
        });
        this.editAddressIV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setClicks$18(view);
            }
        });
        this.addAddressBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda41
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setClicks$19(view);
            }
        });
        this.img_back.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda42
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setClicks$20(view);
            }
        });
        this.procceed.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda43
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$21();
            }
        }));
        this.openQR.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda45
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$22();
            }
        }));
        this.deliveryId1.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda46
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setClicks$23(view);
            }
        });
        this.deliveryId.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda47
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setClicks$24(view);
            }
        });
        this.validityId.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda48
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setClicks$25(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setClicks$16(View view) {
        this.isEmiSelected = false;
        playWithBgColorOneTimePayment();
        loadDataAsPerCouponEmi(this.withCouponLayout.isShown());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setClicks$17(View view) {
        this.isEmiSelected = true;
        playWithBgColorEMIPayment();
        loadDataAsPerCouponEmi(this.withCouponLayout.isShown());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setClicks$18(View view) {
        addressDailog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setClicks$19(View view) {
        if (this.haveAddress) {
            getSavedAddressDailog();
        } else {
            addressDailog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setClicks$20(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$21() {
        if (!Helper.isConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        if (MakeMyExam.getUserId().equalsIgnoreCase("0")) {
            return null;
        }
        String str = this.payment_mode;
        if (str != null && str.equalsIgnoreCase("3") && this.planId == null) {
            Toast.makeText(this.activity, "Please select subscription plan.", 0).show();
            return null;
        }
        LeftMenu leftMenu = this.leftMenu;
        if (leftMenu != null && !TextUtils.isEmpty(leftMenu.getPayment_privacy()) && this.leftMenu.getPayment_privacy().equalsIgnoreCase("1")) {
            if (!this.terms_check.isChecked()) {
                Toast.makeText(this, getResources().getString(R.string.please_select_refund_policy), 0).show();
                return null;
            }
        } else {
            BottomSetting bottomSetting = this.bottomSetting;
            if (bottomSetting != null && !TextUtils.isEmpty(bottomSetting.getInvoice_tnc()) && this.bottomSetting.getInvoice_tnc().equalsIgnoreCase("1") && !this.terms_check.isChecked()) {
                Toast.makeText(this, getResources().getString(R.string.please_select_terms_and_conditions), 0).show();
                return null;
            }
        }
        this.isPayViaQR = false;
        handlePaymnetbuttonClick();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$22() {
        if (!Helper.isConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        if (MakeMyExam.getUserId().equalsIgnoreCase("0")) {
            return null;
        }
        String str = this.payment_mode;
        if (str != null && str.equalsIgnoreCase("3") && this.planId == null) {
            Toast.makeText(this.activity, "Please select subscription plan.", 0).show();
            return null;
        }
        LeftMenu leftMenu = this.leftMenu;
        if (leftMenu != null && !TextUtils.isEmpty(leftMenu.getPayment_privacy()) && this.leftMenu.getPayment_privacy().equalsIgnoreCase("1")) {
            if (!this.terms_check.isChecked()) {
                Toast.makeText(this, getResources().getString(R.string.please_select_refund_policy), 0).show();
                return null;
            }
        } else {
            BottomSetting bottomSetting = this.bottomSetting;
            if (bottomSetting != null && !TextUtils.isEmpty(bottomSetting.getInvoice_tnc()) && this.bottomSetting.getInvoice_tnc().equalsIgnoreCase("1") && !this.terms_check.isChecked()) {
                Toast.makeText(this, getResources().getString(R.string.please_select_terms_and_conditions), 0).show();
                return null;
            }
        }
        this.isPayViaQR = true;
        handlePaymnetbuttonClick();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setClicks$23(View view) {
        if (!Helper.isNetworkConnected(this.activity)) {
            Helper.showInternetToast(this.activity);
            return;
        }
        PopupMenu popupMenu = new PopupMenu(this.activity, this.deliveryId1, GravityCompat.START);
        ArrayList arrayList = new ArrayList();
        for (SubscriptionMetaItem subscriptionMetaItem : this.subscriptionAllData.getSubscriptionMeta()) {
            if (!arrayList.contains(subscriptionMetaItem.getPlateformsName())) {
                arrayList.add(subscriptionMetaItem.getPlateformsName());
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            popupMenu.getMenu().add((String) it.next());
        }
        this.clicktype = "1";
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setClicks$24(View view) {
        ArrayList<SubscriptionMetaItem> arrayList = this.subscriptionValidityListForDeliveryMethod;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (!Helper.isNetworkConnected(this.activity)) {
                Helper.showInternetToast(this.activity);
                return;
            }
            PopupMenu popupMenu = new PopupMenu(this.activity, this.deliveryId, GravityCompat.START);
            Iterator<SubscriptionMetaItem> it = this.subscriptionValidityListForDeliveryMethod.iterator();
            while (it.hasNext()) {
                popupMenu.getMenu().add(it.next().getPlanTitle());
            }
            this.clicktype = "2";
            popupMenu.setOnMenuItemClickListener(this);
            popupMenu.show();
            return;
        }
        Toast.makeText(this, "Select Deliver Method", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setClicks$25(View view) {
        SubscriptionAllData subscriptionAllData = this.subscriptionAllData;
        if (subscriptionAllData == null || subscriptionAllData.getSubscriptionMeta() == null) {
            return;
        }
        if (!this.subscriptionValidityList.isEmpty()) {
            if (!Helper.isNetworkConnected(this.activity)) {
                Helper.showInternetToast(this.activity);
                return;
            }
            PopupMenu popupMenu = new PopupMenu(this.activity, this.validityId, GravityCompat.START);
            Iterator<SubscriptionMetaItem> it = this.subscriptionValidityList.iterator();
            while (it.hasNext()) {
                popupMenu.getMenu().add(it.next().getValidityMy());
            }
            this.clicktype = "3";
            popupMenu.setOnMenuItemClickListener(this);
            popupMenu.show();
            return;
        }
        Toast.makeText(this, "Please Select Plan.", 0).show();
    }

    private void handlePaymnetbuttonClick() {
        if (!TextUtils.isEmpty(SharedPreference.getInstance().getString("in_release")) && SharedPreference.getInstance().getString("in_release").equalsIgnoreCase("1")) {
            this.networkCall.NetworkAPICall(API.GET_PRODUCT_ID, "", true, false);
            return;
        }
        if (!TextUtils.isEmpty(SharedPreference.getInstance().getString("in_release_user")) && SharedPreference.getInstance().getString("in_release_user").equalsIgnoreCase(SharedPreference.getInstance().getLoggedInUser().getId())) {
            this.networkCall.NetworkAPICall(API.GET_PRODUCT_ID, "", true, false);
            return;
        }
        BottomSetting bottomSetting = this.bottomSetting;
        if (bottomSetting != null && bottomSetting.getInvoice_tnc().equals("1")) {
            String str = this.payment_mode;
            if (str != null && str.equalsIgnoreCase("3")) {
                if (this.isBook.equalsIgnoreCase("1") || isComboBook()) {
                    if (!GenericUtils.isEmpty(this.addressJson) && this.address1 != null) {
                        callPaymentMode();
                        return;
                    } else {
                        Toast.makeText(this, getResources().getString(R.string.please_add_address_first), 0).show();
                        return;
                    }
                }
                callPaymentMode();
                return;
            }
            if (this.procceed.getText().toString().equalsIgnoreCase("Proceed")) {
                if (this.isBook.equalsIgnoreCase("1") || isComboBook()) {
                    if (!GenericUtils.isEmpty(this.addressJson) && this.address1 != null) {
                        callPaymentMode();
                        return;
                    } else {
                        Toast.makeText(this, getResources().getString(R.string.please_add_address_first), 0).show();
                        return;
                    }
                }
                callPaymentMode();
                return;
            }
            this.networkCall.NetworkAPICall("https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction", "", true, false);
            return;
        }
        if (this.procceed.getText().toString().equalsIgnoreCase("Proceed")) {
            if (this.isBook.equalsIgnoreCase("1") || isComboBook()) {
                if (!GenericUtils.isEmpty(this.addressJson) && this.address1 != null) {
                    callPaymentMode();
                    return;
                } else {
                    Toast.makeText(this, getResources().getString(R.string.please_add_address_first), 0).show();
                    return;
                }
            }
            callPaymentMode();
            return;
        }
        String str2 = this.payment_mode;
        if (str2 != null && str2.equalsIgnoreCase("3")) {
            if (this.isBook.equalsIgnoreCase("1") || isComboBook()) {
                if (!GenericUtils.isEmpty(this.addressJson) && this.address1 != null) {
                    callPaymentMode();
                    return;
                } else {
                    Toast.makeText(this, getResources().getString(R.string.please_add_address_first), 0).show();
                    return;
                }
            }
            callPaymentMode();
            return;
        }
        this.networkCall.NetworkAPICall("https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction", "", true, false);
    }

    private void loadDataAsPerEmiOrNot() {
        CourseDetail courseDetail = this.courseDetail;
        if (courseDetail != null && courseDetail.getData() != null && this.courseDetail.getData().getInstalment() != null && !GenericUtils.isListEmpty(this.courseDetail.getData().getInstalment().getInstallment()) && this.courseDetail.getData().getInstalment().getPayment_mode() != null) {
            String payment_mode = this.courseDetail.getData().getInstalment().getPayment_mode();
            payment_mode.hashCode();
            switch (payment_mode) {
                case "0":
                    this.hideExternalForEMI = false;
                    this.layout_course.setVisibility(8);
                    this.emiTypeLayout.setVisibility(0);
                    this.coverOneTimePaymentBtn.setVisibility(0);
                    this.coverEmiPaymentBtn.setVisibility(8);
                    this.emiRecyclerList.setVisibility(8);
                    this.oneTimePayBtnCvr.performClick();
                    break;
                case "1":
                    this.hideExternalForEMI = true;
                    this.layout_course.setVisibility(8);
                    this.emiTypeLayout.setVisibility(0);
                    this.coverOneTimePaymentBtn.setVisibility(8);
                    this.coverEmiPaymentBtn.setVisibility(0);
                    this.emiRecyclerList.setVisibility(0);
                    this.emiPayBtnCvr.performClick();
                    break;
                case "2":
                    this.hideExternalForEMI = true;
                    this.layout_course.setVisibility(8);
                    this.emiTypeLayout.setVisibility(0);
                    this.oneTimePayBtnCvr.performClick();
                    break;
            }
        } else {
            this.hideExternalForEMI = false;
            this.layout_course.setVisibility(0);
            this.emiTypeLayout.setVisibility(8);
            this.oneTimePayBtnCvr.performClick();
        }
        checkExternalCoupon();
    }

    private void playWithBgColorOneTimePayment() {
        this.oneTimePayBtnCvr.setBackground(getResources().getDrawable(R.drawable.round_grey_background_normal));
        this.txtOnetimePayment.setTextColor(getResources().getColor(R.color.colorPrimary));
        this.imOneTimePayment.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimary)));
        this.imEmiPayment.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.gray_light)));
        this.emiPayBtnCvr.setBackground(getResources().getDrawable(R.drawable.round_grey_background));
        this.txtEmiPayment.setTextColor(getResources().getColor(R.color.black));
        this.emiRecyclerList.setVisibility(8);
        this.paymentModeValue = "0";
        this.installmentInfo1.setVisibility(8);
        this.installmentInfo.setVisibility(8);
        this.installmentTB.setVisibility(8);
        this.total_layout.setVisibility(0);
        this.tax_layout.setVisibility(0);
        this.view_plan_tv.setVisibility(8);
        priceUpdate(Float.parseFloat(this.courseDetail.getData().getCourseDetail().getMrp()) + Float.parseFloat(this.courseDetail.getData().getCourseDetail().getTax()));
    }

    private void playWithBgColorEMIPayment() {
        this.oneTimePayBtnCvr.setBackground(getResources().getDrawable(R.drawable.round_grey_background));
        this.txtOnetimePayment.setTextColor(getResources().getColor(R.color.black));
        this.emiPayBtnCvr.setBackground(getResources().getDrawable(R.drawable.round_grey_background_normal));
        this.imEmiPayment.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimary)));
        this.imOneTimePayment.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.gray_light)));
        this.txtEmiPayment.setTextColor(getResources().getColor(R.color.colorPrimary));
        this.paymentModeValue = "1";
        this.installmentInfo1.setVisibility(0);
        this.installmentInfo.setVisibility(0);
        this.installmentTB.setVisibility(0);
        this.emiRecyclerList.setVisibility(0);
        this.view_plan_tv.setVisibility(8);
        this.arrayList.clear();
        if (!GenericUtils.isListEmpty(this.courseDetail.getData().getInstalment().getInstallment())) {
            for (int i = 0; i < this.courseDetail.getData().getInstalment().getInstallment().size(); i++) {
                this.arrayList.add(this.courseDetail.getData().getInstalment().getInstallment().get(i).getName());
            }
        }
        MainAdapter mainAdapter = new MainAdapter(this.arrayList, this.emiTypePos, new ItemClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda0
            @Override // com.appnew.android.Payment.ItemClickListener
            public final void onClick(String str, int i2) {
                this.f$0.onClick(str, i2);
            }
        }, new IOnViewDetailsClick() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda11
            @Override // com.appnew.android.Payment.IOnViewDetailsClick
            public final void onViewDetailsClick(int i2, String str, boolean z) {
                this.f$0.onViewDetailsClick(i2, str, z);
            }
        });
        this.adapter = mainAdapter;
        this.emiRecyclerList.setAdapter(mainAdapter);
        this.total_layout.setVisibility(0);
    }

    private void calculateInstallmentPrice(int position) {
        Double dValueOf = Double.valueOf(Double.parseDouble(this.courseDetail.getData().getInstalment().getInstallment().get(position).getAmountDescription().getPayment().get(0)) + Double.parseDouble(this.courseDetail.getData().getInstalment().getInstallment().get(position).getAmountDescription().getTax().get(0)));
        Double dValueOf2 = Double.valueOf(Double.parseDouble(this.courseDetail.getData().getInstalment().getInstallment().get(position).getAmountDescription().getTax().get(0)));
        this.installmentFirstPrice = dValueOf;
        this.finalPriceValue = this.courseDetail.getData().getInstalment().getInstallment().get(position).getAmountDescription().getTotal_amount().get(0);
        this.emiPriceToSend = this.courseDetail.getData().getInstalment().getInstallment().get(position).getAmountDescription().getPayment().get(0);
        this.finalTaxValue = String.valueOf(dValueOf2);
        this.tax_layout.setVisibility(0);
        this.paymentMetaValue = new Gson().toJson(this.courseDetail.getData().getInstalment().getInstallment().get(position));
        this.subscription_code = this.courseDetail.getData().getInstalment().getInstallment().get(position).getAmountDescription().getSubscription_code();
        this.planId = this.courseDetail.getData().getInstalment().getInstallment().get(position).getId();
        Double dValueOf3 = Double.valueOf(dValueOf2.doubleValue() / 2.0d);
        Double dValueOf4 = Double.valueOf(0.0d);
        for (int i = 0; i < this.courseDetail.getData().getInstalment().getInstallment().get(position).getAmountDescription().getTotal_amount().size(); i++) {
            dValueOf4 = Double.valueOf(dValueOf4.doubleValue() + Double.parseDouble(this.courseDetail.getData().getInstalment().getInstallment().get(position).getAmountDescription().getTotal_amount().get(i)));
        }
        this.finalAmt = dValueOf4;
        ((TextView) Objects.requireNonNull(this.txtInstallmentValue)).setText(String.format("%s %s", getResources().getString(R.string.rs), String.format("%.2f", Float.valueOf(Float.parseFloat(this.courseDetail.getData().getInstalment().getInstallment().get(position).getAmountDescription().getPayment().get(0))))));
        ((TextView) Objects.requireNonNull(this.txtPricesValue1)).setText(String.format("%s %s", getResources().getString(R.string.rs), String.format("%.2f", Float.valueOf(Float.parseFloat(this.courseDetail.getData().getInstalment().getInstallment().get(position).getAmountDescription().getPayment().get(0))))));
        ((TextView) Objects.requireNonNull(this.tax_value)).setText(String.format("%s %s", getResources().getString(R.string.rs), String.format("%.2f", Float.valueOf(Float.parseFloat(this.courseDetail.getData().getInstalment().getInstallment().get(position).getAmountDescription().getTax().get(0))))));
        ((TextView) Objects.requireNonNull(this.txtTaxValue1)).setText(String.format("%s %s", getResources().getString(R.string.rs), String.format("%.2f", Float.valueOf(Float.parseFloat(this.courseDetail.getData().getInstalment().getInstallment().get(position).getAmountDescription().getTax().get(0))))));
        ((TextView) Objects.requireNonNull(this.txtGrandTotalValue)).setText(String.format("%s %s", getResources().getString(R.string.rs), String.format("%.2f", this.installmentFirstPrice)));
        ((TextView) Objects.requireNonNull(this.txtGrandTotalValue1)).setText(String.format("%s %s", getResources().getString(R.string.rs), String.format("%.2f", this.installmentFirstPrice)));
        ((TextView) Objects.requireNonNull(this.sgstValue)).setText(Constants.currencyType + " " + String.format("%.2f", dValueOf3));
        ((TextView) Objects.requireNonNull(this.cgstValue)).setText(Constants.currencyType + " " + String.format("%.2f", dValueOf3));
        ((TextView) Objects.requireNonNull(this.sgstValueCoupon)).setText(Constants.currencyType + " " + String.format("%.2f", dValueOf3));
        ((TextView) Objects.requireNonNull(this.cgstValueCoupon)).setText(Constants.currencyType + " " + String.format("%.2f", dValueOf3));
        ((TextView) Objects.requireNonNull(this.totalPriceValue)).setText(Constants.currencyType + " " + String.format("%.2f", this.finalAmt));
        ((TextView) Objects.requireNonNull(this.totalPriceValue1)).setText(Constants.currencyType + " " + String.format("%.2f", this.finalAmt));
        ((TextView) Objects.requireNonNull(this.priceTxtCourse)).setText(Constants.currencyType + " " + String.format("%.2f", this.finalAmt));
    }

    public void getAddressDetail(AddressMaster addressMaster) {
        this.addressMaster = addressMaster;
        this.address1 = (Address) new Gson().fromJson(addressMaster.getAddress(), Address.class);
        this.addressJson = addressMaster.getAddress();
        runOnUiThread(new Runnable() { // from class: com.appnew.android.Payment.PurchaseActivity.6
            @Override // java.lang.Runnable
            public void run() {
                PurchaseActivity.this.addedAddressLL.setVisibility(0);
                PurchaseActivity.this.addressCV.setVisibility(0);
                PurchaseActivity.this.addAddressBtn.setVisibility(0);
                PurchaseActivity.this.addAddressBtn.setBackground(PurchaseActivity.this.getResources().getDrawable(R.drawable.common_round_corners_button_drawable));
                PurchaseActivity.this.addAddressBtn.setText("CHANGE ADDRESS");
                PurchaseActivity.this.addAddressBtn.setTextColor(ResourcesCompat.getColor(PurchaseActivity.this.getResources(), R.color.whie, PurchaseActivity.this.getTheme()));
                PurchaseActivity.this.addedAddressTV.setText(PurchaseActivity.this.address1.getAddress() + ",\n" + PurchaseActivity.this.address1.getCity() + "\n" + PurchaseActivity.this.address1.getState() + ",\n" + PurchaseActivity.this.address1.getPincode());
                PurchaseActivity.this.nameAddressTv.setText(PurchaseActivity.this.address1.getName());
                PurchaseActivity.this.mobileNumber.setText(PurchaseActivity.this.address1.getMainMobileNumber());
                if (PurchaseActivity.this.address1.getAlternateMobileNumber() != null && !TextUtils.isEmpty(PurchaseActivity.this.address1.getAlternateMobileNumber())) {
                    PurchaseActivity.this.mobileNumberAlternate.setVisibility(0);
                    PurchaseActivity.this.mobileNumberAlternate.setText(PurchaseActivity.this.address1.getAlternateMobileNumber());
                } else {
                    PurchaseActivity.this.mobileNumberAlternate.setVisibility(8);
                }
            }
        });
    }

    private void addressDailog(final Dialog leftOverDialog) {
        try {
            if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
                return;
            }
            this.mLastClickTime = SystemClock.elapsedRealtime();
            this.stateindex = "";
            this.cityindex = "";
            hit_api_to_get_state();
            if (this.cities == null) {
                if (this.address1.getStateId() != null) {
                    this.SelectedStateid = this.address1.getStateId();
                    hit_api_to_get_city();
                } else {
                    Toast.makeText(this.activity, "Please Change State...", 0).show();
                }
            }
            final Dialog dialog = new Dialog(this, R.style.address);
            dialog.setCancelable(true);
            dialog.requestWindowFeature(1);
            dialog.setContentView(R.layout.add_address_layout_theme_2);
            RelativeLayout relativeLayout = (RelativeLayout) dialog.findViewById(R.id.subRL);
            final CheckBox checkBox = (CheckBox) dialog.findViewById(R.id.setAsDefaultCheckBox);
            ScrollView scrollView = (ScrollView) dialog.findViewById(R.id.main_rl);
            if (scrollView != null) {
                scrollView.setVisibility(0);
            }
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            Button button = (Button) dialog.findViewById(R.id.submit);
            ((TextView) dialog.findViewById(R.id.toolbarTitleTV)).setText("Add Address");
            final EditText editText = (EditText) dialog.findViewById(R.id.nameTV);
            final EditText editText2 = (EditText) dialog.findViewById(R.id.fullAddressTV);
            final EditText editText3 = (EditText) dialog.findViewById(R.id.mobileTV);
            final EditText editText4 = (EditText) dialog.findViewById(R.id.alternateMobileTV);
            this.statesTV = (TextView) dialog.findViewById(R.id.stateTV);
            this.districtTV = (TextView) dialog.findViewById(R.id.districtTV);
            final EditText editText5 = (EditText) dialog.findViewById(R.id.cityTV);
            final EditText editText6 = (EditText) dialog.findViewById(R.id.pincodeTV);
            final EditText editText7 = (EditText) dialog.findViewById(R.id.orderNotesTV);
            ((ImageView) dialog.findViewById(R.id.image_back)).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            editText.setText(SharedPreference.getInstance().getLoggedInUser().getName());
            editText3.setText(SharedPreference.getInstance().getLoggedInUser().getMobile());
            if (!editText.getText().toString().isEmpty()) {
                editText.setTextColor(getResources().getColor(R.color.bd_label_text));
                LeftMenu leftMenu = this.leftMenu;
                if (leftMenu != null) {
                    editText.setEnabled(leftMenu.getDisable_name_edit().equalsIgnoreCase("0") || this.leftMenu.getDisable_name_edit().equalsIgnoreCase(""));
                }
            }
            if (!editText3.getText().toString().isEmpty()) {
                editText3.setTextColor(getResources().getColor(R.color.bd_label_text));
                editText3.setEnabled(false);
            }
            this.statesTV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$addressDailog$27(view);
                }
            });
            this.districtTV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$addressDailog$28(view);
                }
            });
            editText6.setFilters(new InputFilter[]{new InputFilter() { // from class: com.appnew.android.Payment.PurchaseActivity.7
                @Override // android.text.InputFilter
                public CharSequence filter(CharSequence charSequence, int start, int end, Spanned dest, int dstart, int dend) {
                    return (!charSequence.equals("") && (!charSequence.toString().matches("[0-9]+") || editText6.getText().toString().length() > 5)) ? "" : charSequence;
                }
            }});
            button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$addressDailog$29(editText, editText3, editText2, editText5, editText6, editText4, editText7, checkBox, leftOverDialog, dialog, view);
                }
            });
            View viewFindViewById = dialog.findViewById(R.id.dialog_root);
            View viewFindViewById2 = dialog.findViewById(R.id.main_toolbar);
            Window window = dialog.getWindow();
            if (Build.VERSION.SDK_INT == 36 && window != null && viewFindViewById != null && viewFindViewById2 != null) {
                EdgeToEdgeHelperOld.applyDialogHeaderInsets(window, viewFindViewById, viewFindViewById2);
            }
            dialog.show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addressDailog$27(View view) {
        StatesCities statesCities = this.states;
        if (statesCities == null || statesCities.getData().size() == 0) {
            Activity activity = this.activity;
            Toast.makeText(activity, activity.getResources().getString(R.string.no_state_available), 0).show();
        } else {
            this.clicktype = "1";
            filterList("1", this.states);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addressDailog$28(View view) {
        StatesCities statesCities = this.cities;
        if (statesCities == null || statesCities.getData().size() == 0) {
            Activity activity = this.activity;
            Toast.makeText(activity, activity.getResources().getString(R.string.please_select_state_first), 0).show();
        } else {
            this.clicktype = "2";
            filterList("2", this.cities);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addressDailog$29(EditText editText, EditText editText2, EditText editText3, EditText editText4, EditText editText5, EditText editText6, EditText editText7, CheckBox checkBox, Dialog dialog, Dialog dialog2, View view) {
        EditText editText8;
        try {
            if (TextUtils.isEmpty(editText.getText().toString().trim())) {
                Toast.makeText(this, getResources().getString(R.string.name_field_is_required), 0).show();
                return;
            }
            if (TextUtils.isEmpty(editText2.getText().toString().trim())) {
                Toast.makeText(this, getResources().getString(R.string.mobile_field_is_required), 0).show();
                return;
            }
            if (Helper.isInValidIndianMobile(editText2.getText().toString().trim())) {
                Toast.makeText(this, getResources().getString(R.string.this_number_is_invalid), 0).show();
                return;
            }
            if (TextUtils.isEmpty(editText3.getText().toString().trim())) {
                Toast.makeText(this, getResources().getString(R.string.address_field_is_required), 0).show();
                return;
            }
            if (editText3.getText().toString().trim().length() <= 5) {
                Toast.makeText(this, getResources().getString(R.string.enter_valid_address), 0).show();
                return;
            }
            if (TextUtils.isEmpty(this.statesTV.getText().toString().trim())) {
                Toast.makeText(this, getResources().getString(R.string.state_field_is_required), 0).show();
                return;
            }
            if (TextUtils.isEmpty(this.districtTV.getText().toString().trim())) {
                Toast.makeText(this, getResources().getString(R.string.district_field_is_required), 0).show();
                return;
            }
            if (TextUtils.isEmpty(editText4.getText().toString().trim())) {
                Toast.makeText(this, getResources().getString(R.string.city_field_is_required), 0).show();
                return;
            }
            if (!TextUtils.isEmpty(editText5.getText().toString().trim()) && editText5.getText().length() >= 6 && !editText5.getText().toString().startsWith("0")) {
                if (editText2.getText().toString().isEmpty()) {
                    Toast.makeText(this, getResources().getString(R.string.mobile_field_is_required), 0).show();
                    return;
                }
                if (editText2.getText().toString().isEmpty()) {
                    Toast.makeText(this, getResources().getString(R.string.mobile_field_is_required), 0).show();
                    return;
                }
                if (!numberValidation(editText2)) {
                    Toast.makeText(this, getResources().getString(R.string.mobile_number_should_be_at_least_10_digits), 0).show();
                    return;
                }
                boolean z = true;
                if (editText6.getText().length() >= 1) {
                    editText8 = editText6;
                    if (!numberValidation(editText8)) {
                        return;
                    }
                } else {
                    editText8 = editText6;
                }
                if (Helper.NotBeSameAlternateMobileNumber(editText8.getText().toString().trim(), editText2.getText().toString().trim())) {
                    Toast.makeText(this, getResources().getString(R.string.change_alternate_number), 0).show();
                    return;
                }
                String strTrim = editText.getText().toString().trim();
                String strTrim2 = editText3.getText().toString().trim();
                String strTrim3 = editText2.getText().toString().trim();
                String strTrim4 = editText8.getText().toString().trim();
                String strTrim5 = this.statesTV.getText().toString().trim();
                String strTrim6 = this.districtTV.getText().toString().trim();
                String strTrim7 = editText4.getText().toString().trim();
                String strTrim8 = editText5.getText().toString().trim();
                String strTrim9 = editText7.getText().toString().trim();
                if (checkBox == null || !checkBox.isChecked()) {
                    z = false;
                }
                this.isDefault = z;
                this.address1 = new Address(strTrim, strTrim2, strTrim5, strTrim7, strTrim3, strTrim4, strTrim8, strTrim9, strTrim6, this.SelectedStateid);
                this.addressJson = new Gson().toJson(this.address1);
                this.isAddressEdited = false;
                this.isWantToUpdate = this.isDefault;
                hitApiForSavingAddress();
                dialog.dismiss();
                dialog2.dismiss();
                return;
            }
            Toast.makeText(this, getResources().getString(R.string.enter_valid_pin_code), 0).show();
        } catch (Exception unused) {
        }
    }

    public boolean numberValidation(EditText mobileNumberEditText) {
        String strTrim = mobileNumberEditText.getText().toString().trim();
        if (!TextUtils.isDigitsOnly(strTrim)) {
            return true;
        }
        if (TextUtils.isEmpty(strTrim)) {
            return Helper.DataNotValid(mobileNumberEditText, this);
        }
        if (!Patterns.PHONE.matcher(strTrim).matches() || strTrim.length() != 10) {
            return Helper.DataNotValid(mobileNumberEditText, 2, this);
        }
        if (Helper.isInValidIndianMobile(strTrim)) {
            return Helper.DataNotValid(mobileNumberEditText, 2, this);
        }
        return true;
    }

    private void addressDailog() {
        Address address;
        try {
            if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
                return;
            }
            this.mLastClickTime = SystemClock.elapsedRealtime();
            this.stateindex = "";
            this.cityindex = "";
            hit_api_to_get_state();
            if (this.cities == null && (address = this.address1) != null) {
                if (address.getStateId() != null) {
                    this.SelectedStateid = this.address1.getStateId();
                    hit_api_to_get_city();
                } else {
                    Toast.makeText(this.activity, "Please Change State...", 0).show();
                }
            }
            final Dialog dialog = new Dialog(this, R.style.address);
            dialog.setCancelable(true);
            dialog.requestWindowFeature(1);
            dialog.setContentView(R.layout.add_address_layout_theme_2);
            RelativeLayout relativeLayout = (RelativeLayout) dialog.findViewById(R.id.subRL);
            final CheckBox checkBox = (CheckBox) dialog.findViewById(R.id.setAsDefaultCheckBox);
            ScrollView scrollView = (ScrollView) dialog.findViewById(R.id.main_rl);
            if (scrollView != null) {
                scrollView.setVisibility(0);
            }
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            Button button = (Button) dialog.findViewById(R.id.submit);
            ((TextView) dialog.findViewById(R.id.toolbarTitleTV)).setText("Add Address");
            final EditText editText = (EditText) dialog.findViewById(R.id.nameTV);
            final EditText editText2 = (EditText) dialog.findViewById(R.id.fullAddressTV);
            final EditText editText3 = (EditText) dialog.findViewById(R.id.mobileTV);
            final EditText editText4 = (EditText) dialog.findViewById(R.id.alternateMobileTV);
            this.statesTV = (TextView) dialog.findViewById(R.id.stateTV);
            this.districtTV = (TextView) dialog.findViewById(R.id.districtTV);
            final EditText editText5 = (EditText) dialog.findViewById(R.id.cityTV);
            final EditText editText6 = (EditText) dialog.findViewById(R.id.pincodeTV);
            final EditText editText7 = (EditText) dialog.findViewById(R.id.orderNotesTV);
            ((ImageView) dialog.findViewById(R.id.image_back)).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda23
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            editText.setText(SharedPreference.getInstance().getLoggedInUser().getName());
            editText3.setText(SharedPreference.getInstance().getLoggedInUser().getMobile());
            if (!editText.getText().toString().isEmpty()) {
                editText.setTextColor(getResources().getColor(R.color.bd_label_text));
                LeftMenu leftMenu = this.leftMenu;
                if (leftMenu != null) {
                    editText.setEnabled(leftMenu.getDisable_name_edit().equalsIgnoreCase("0") || this.leftMenu.getDisable_name_edit().equalsIgnoreCase(""));
                }
            }
            if (!editText3.getText().toString().isEmpty()) {
                editText3.setTextColor(getResources().getColor(R.color.bd_label_text));
                editText3.setEnabled(false);
            }
            Address address2 = this.address1;
            if (address2 != null && this.addressMaster != null) {
                if (address2.getName() == null || TextUtils.isEmpty(this.address1.getName())) {
                    editText.setText(SharedPreference.getInstance().getLoggedInUser().getName());
                } else {
                    editText.setText(this.address1.getName());
                }
                editText2.setText(this.address1.getAddress());
                this.statesTV.setText(this.address1.getState());
                this.stateindex = this.address1.getState();
                editText5.setText(this.address1.getCity());
                this.districtTV.setText(this.address1.getDistrict());
                editText6.setText(this.address1.getPincode());
                editText7.setText(this.address1.getOrderNotes());
                editText4.setText(this.address1.getAlternateMobileNumber());
                if (checkBox != null) {
                    checkBox.setChecked(this.addressMaster.getIs_default().equalsIgnoreCase("1"));
                }
            }
            this.statesTV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda24
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$addressDailog$31(view);
                }
            });
            this.districtTV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda25
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$addressDailog$32(view);
                }
            });
            editText6.setFilters(new InputFilter[]{new InputFilter() { // from class: com.appnew.android.Payment.PurchaseActivity.8
                @Override // android.text.InputFilter
                public CharSequence filter(CharSequence charSequence, int start, int end, Spanned dest, int dstart, int dend) {
                    return (!charSequence.equals("") && (!charSequence.toString().matches("[0-9]+") || editText6.getText().toString().length() > 5)) ? "" : charSequence;
                }
            }});
            button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda26
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$addressDailog$33(editText, editText3, editText2, editText5, editText6, editText4, editText7, checkBox, dialog, view);
                }
            });
            View viewFindViewById = dialog.findViewById(R.id.dialog_root);
            View viewFindViewById2 = dialog.findViewById(R.id.main_toolbar);
            Window window = dialog.getWindow();
            if (Build.VERSION.SDK_INT == 36 && window != null && viewFindViewById != null && viewFindViewById2 != null) {
                EdgeToEdgeHelperOld.applyDialogHeaderInsets(window, viewFindViewById, viewFindViewById2);
            }
            try {
                dialog.show();
            } catch (Exception e2) {
                Log.d("Dialog", "makeDialog: " + e2.getMessage());
            }
        } catch (Exception e3) {
            Log.d("Dialog", "main: " + e3.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addressDailog$31(View view) {
        StatesCities statesCities = this.states;
        if (statesCities == null || statesCities.getData().size() == 0) {
            Activity activity = this.activity;
            Toast.makeText(activity, activity.getResources().getString(R.string.no_state_available), 0).show();
        } else {
            this.clicktype = "1";
            filterList("1", this.states);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addressDailog$32(View view) {
        StatesCities statesCities = this.cities;
        if (statesCities == null || statesCities.getData().size() == 0) {
            Activity activity = this.activity;
            Toast.makeText(activity, activity.getResources().getString(R.string.please_select_state_first), 0).show();
        } else {
            this.clicktype = "2";
            filterList("2", this.cities);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addressDailog$33(EditText editText, EditText editText2, EditText editText3, EditText editText4, EditText editText5, EditText editText6, EditText editText7, CheckBox checkBox, Dialog dialog, View view) {
        EditText editText8;
        try {
            if (TextUtils.isEmpty(editText.getText().toString().trim())) {
                Toast.makeText(this, getResources().getString(R.string.name_field_is_required), 0).show();
                return;
            }
            if (TextUtils.isEmpty(editText2.getText().toString().trim())) {
                Toast.makeText(this, getResources().getString(R.string.mobile_field_is_required), 0).show();
                return;
            }
            if (Helper.isInValidIndianMobile(editText2.getText().toString().trim())) {
                Toast.makeText(this, getResources().getString(R.string.this_number_is_invalid), 0).show();
                return;
            }
            if (TextUtils.isEmpty(editText3.getText().toString().trim())) {
                Toast.makeText(this, getResources().getString(R.string.address_field_is_required), 0).show();
                return;
            }
            if (editText3.getText().toString().trim().length() <= 5) {
                Toast.makeText(this, getResources().getString(R.string.enter_valid_address), 0).show();
                return;
            }
            if (TextUtils.isEmpty(this.statesTV.getText().toString().trim())) {
                Toast.makeText(this, getResources().getString(R.string.state_field_is_required), 0).show();
                return;
            }
            if (TextUtils.isEmpty(this.districtTV.getText().toString().trim())) {
                Toast.makeText(this, getResources().getString(R.string.district_field_is_required), 0).show();
                return;
            }
            if (TextUtils.isEmpty(editText4.getText().toString().trim())) {
                Toast.makeText(this, getResources().getString(R.string.city_field_is_required), 0).show();
                return;
            }
            if (!TextUtils.isEmpty(editText5.getText().toString().trim()) && editText5.getText().length() >= 6 && !editText5.getText().toString().startsWith("0")) {
                if (editText2.getText().toString().isEmpty()) {
                    Toast.makeText(this, getResources().getString(R.string.mobile_field_is_required), 0).show();
                    return;
                }
                if (editText2.getText().toString().isEmpty()) {
                    Toast.makeText(this, getResources().getString(R.string.mobile_field_is_required), 0).show();
                    return;
                }
                if (!numberValidation(editText2)) {
                    Toast.makeText(this, getResources().getString(R.string.mobile_number_should_be_at_least_10_digits), 0).show();
                    return;
                }
                if (editText6.getText().length() >= 1) {
                    editText8 = editText6;
                    if (!numberValidation(editText8)) {
                        return;
                    }
                } else {
                    editText8 = editText6;
                }
                if (Helper.NotBeSameAlternateMobileNumber(editText8.getText().toString().trim(), editText2.getText().toString().trim())) {
                    Toast.makeText(this, getResources().getString(R.string.change_alternate_number), 0).show();
                    return;
                }
                String strTrim = editText.getText().toString().trim();
                String strTrim2 = editText3.getText().toString().trim();
                String strTrim3 = editText2.getText().toString().trim();
                String strTrim4 = editText8.getText().toString().trim();
                String strTrim5 = this.statesTV.getText().toString().trim();
                String strTrim6 = this.districtTV.getText().toString().trim();
                String strTrim7 = editText4.getText().toString().trim();
                String strTrim8 = editText5.getText().toString().trim();
                String strTrim9 = editText7.getText().toString().trim();
                this.isDefault = checkBox != null && checkBox.isChecked();
                this.address1 = new Address(strTrim, strTrim2, strTrim5, strTrim7, strTrim3, strTrim4, strTrim8, strTrim9, strTrim6, this.SelectedStateid);
                this.addressJson = new Gson().toJson(this.address1);
                if (!this.haveAddress) {
                    this.isAddressEdited = false;
                } else {
                    this.isAddressEdited = true;
                }
                hitApiForSavingAddress();
                dialog.dismiss();
                return;
            }
            Toast.makeText(this, getResources().getString(R.string.enter_valid_pin_code), 0).show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void addressDailogInner(final Dialog innerDialog, AddressMaster addressMaster) {
        try {
            if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
                return;
            }
            this.mLastClickTime = SystemClock.elapsedRealtime();
            this.stateindex = "";
            this.cityindex = "";
            hit_api_to_get_state();
            StatesCities statesCities = this.cities;
            if (statesCities == null || statesCities.getData().size() == 0) {
                if (this.address1.getStateId() != null) {
                    this.SelectedStateid = this.address1.getStateId();
                    hit_api_to_get_city();
                } else {
                    Toast.makeText(this.activity, "Please Change State...", 0).show();
                }
            }
            final Dialog dialog = new Dialog(this, R.style.address);
            dialog.setCancelable(true);
            dialog.requestWindowFeature(1);
            dialog.setContentView(R.layout.add_address_layout_theme_2);
            RelativeLayout relativeLayout = (RelativeLayout) dialog.findViewById(R.id.subRL);
            final CheckBox checkBox = (CheckBox) dialog.findViewById(R.id.setAsDefaultCheckBox);
            ScrollView scrollView = (ScrollView) dialog.findViewById(R.id.main_rl);
            if (scrollView != null) {
                scrollView.setVisibility(0);
            }
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            Button button = (Button) dialog.findViewById(R.id.submit);
            ((TextView) dialog.findViewById(R.id.toolbarTitleTV)).setText("Add Address");
            final EditText editText = (EditText) dialog.findViewById(R.id.nameTV);
            final EditText editText2 = (EditText) dialog.findViewById(R.id.fullAddressTV);
            final EditText editText3 = (EditText) dialog.findViewById(R.id.mobileTV);
            final EditText editText4 = (EditText) dialog.findViewById(R.id.alternateMobileTV);
            this.statesTV = (TextView) dialog.findViewById(R.id.stateTV);
            this.districtTV = (TextView) dialog.findViewById(R.id.districtTV);
            final EditText editText5 = (EditText) dialog.findViewById(R.id.cityTV);
            final EditText editText6 = (EditText) dialog.findViewById(R.id.pincodeTV);
            final EditText editText7 = (EditText) dialog.findViewById(R.id.orderNotesTV);
            ((ImageView) dialog.findViewById(R.id.image_back)).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            editText.setText(SharedPreference.getInstance().getLoggedInUser().getName());
            editText3.setText(SharedPreference.getInstance().getLoggedInUser().getMobile());
            if (!editText.getText().toString().isEmpty()) {
                editText.setTextColor(getResources().getColor(R.color.bd_label_text));
                LeftMenu leftMenu = this.leftMenu;
                if (leftMenu != null) {
                    editText.setEnabled(leftMenu.getDisable_name_edit().equalsIgnoreCase("0") || this.leftMenu.getDisable_name_edit().equalsIgnoreCase(""));
                }
            }
            if (!editText3.getText().toString().isEmpty()) {
                editText3.setTextColor(getResources().getColor(R.color.bd_label_text));
                editText3.setEnabled(false);
            }
            Address address = (Address) new Gson().fromJson(addressMaster.getAddress(), Address.class);
            this.address1 = address;
            this.addressMaster = addressMaster;
            if (address != null && addressMaster != null) {
                if (address.getName() != null && !TextUtils.isEmpty(this.address1.getName())) {
                    editText.setText(this.address1.getName());
                } else {
                    editText.setText(SharedPreference.getInstance().getLoggedInUser().getName());
                }
                editText2.setText(this.address1.getAddress());
                this.statesTV.setText(this.address1.getState());
                this.stateindex = this.address1.getState();
                editText5.setText(this.address1.getCity());
                this.districtTV.setText(this.address1.getDistrict());
                editText6.setText(this.address1.getPincode());
                editText7.setText(this.address1.getOrderNotes());
                editText4.setText(this.address1.getAlternateMobileNumber());
                if (checkBox != null) {
                    checkBox.setChecked(addressMaster.getIs_default().equalsIgnoreCase("1"));
                }
            }
            this.statesTV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda15
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$addressDailogInner$35(view);
                }
            });
            this.districtTV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda16
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$addressDailogInner$36(view);
                }
            });
            editText6.setFilters(new InputFilter[]{new InputFilter() { // from class: com.appnew.android.Payment.PurchaseActivity.9
                @Override // android.text.InputFilter
                public CharSequence filter(CharSequence charSequence, int start, int end, Spanned dest, int dstart, int dend) {
                    return (!charSequence.equals("") && (!charSequence.toString().matches("[0-9]+") || editText6.getText().toString().length() > 5)) ? "" : charSequence;
                }
            }});
            button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda17
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$addressDailogInner$37(editText, editText3, editText2, editText5, editText6, editText4, editText7, checkBox, innerDialog, dialog, view);
                }
            });
            View viewFindViewById = dialog.findViewById(R.id.dialog_root);
            View viewFindViewById2 = dialog.findViewById(R.id.main_toolbar);
            Window window = dialog.getWindow();
            if (Build.VERSION.SDK_INT == 36 && window != null && viewFindViewById != null && viewFindViewById2 != null) {
                EdgeToEdgeHelperOld.applyDialogHeaderInsets(window, viewFindViewById, viewFindViewById2);
            }
            dialog.show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addressDailogInner$35(View view) {
        StatesCities statesCities = this.states;
        if (statesCities == null || statesCities.getData().size() == 0) {
            Activity activity = this.activity;
            Toast.makeText(activity, activity.getResources().getString(R.string.no_state_available), 0).show();
        } else {
            this.clicktype = "1";
            filterList("1", this.states);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addressDailogInner$36(View view) {
        StatesCities statesCities = this.cities;
        if (statesCities == null || statesCities.getData().size() == 0) {
            Activity activity = this.activity;
            Toast.makeText(activity, activity.getResources().getString(R.string.please_select_state_first), 0).show();
        } else {
            this.clicktype = "2";
            filterList("2", this.cities);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addressDailogInner$37(EditText editText, EditText editText2, EditText editText3, EditText editText4, EditText editText5, EditText editText6, EditText editText7, CheckBox checkBox, Dialog dialog, Dialog dialog2, View view) {
        EditText editText8;
        try {
            boolean z = false;
            if (TextUtils.isEmpty(editText.getText().toString().trim())) {
                Toast.makeText(this, getResources().getString(R.string.name_field_is_required), 0).show();
                return;
            }
            if (TextUtils.isEmpty(editText2.getText().toString().trim())) {
                Toast.makeText(this, getResources().getString(R.string.mobile_field_is_required), 0).show();
                return;
            }
            if (Helper.isInValidIndianMobile(editText2.getText().toString().trim())) {
                Toast.makeText(this, getResources().getString(R.string.this_number_is_invalid), 0).show();
                return;
            }
            if (TextUtils.isEmpty(editText3.getText().toString().trim())) {
                Toast.makeText(this, getResources().getString(R.string.address_field_is_required), 0).show();
                return;
            }
            if (editText3.getText().toString().trim().length() <= 5) {
                Toast.makeText(this, getResources().getString(R.string.enter_valid_address), 0).show();
                return;
            }
            if (TextUtils.isEmpty(this.statesTV.getText().toString().trim())) {
                Toast.makeText(this, getResources().getString(R.string.state_field_is_required), 0).show();
                return;
            }
            if (TextUtils.isEmpty(this.districtTV.getText().toString().trim())) {
                Toast.makeText(this, getResources().getString(R.string.district_field_is_required), 0).show();
                return;
            }
            if (TextUtils.isEmpty(editText4.getText().toString().trim())) {
                Toast.makeText(this, getResources().getString(R.string.city_field_is_required), 0).show();
                return;
            }
            if (!TextUtils.isEmpty(editText5.getText().toString().trim()) && editText5.getText().length() >= 6 && !editText5.getText().toString().startsWith("0")) {
                if (editText2.getText().toString().isEmpty()) {
                    Toast.makeText(this, getResources().getString(R.string.mobile_field_is_required), 0).show();
                    return;
                }
                if (editText2.getText().toString().isEmpty()) {
                    Toast.makeText(this, getResources().getString(R.string.mobile_field_is_required), 0).show();
                    return;
                }
                if (!numberValidation(editText2)) {
                    Toast.makeText(this, getResources().getString(R.string.mobile_number_should_be_at_least_10_digits), 0).show();
                    return;
                }
                if (editText6.getText().length() >= 1) {
                    editText8 = editText6;
                    if (!numberValidation(editText8)) {
                        return;
                    }
                } else {
                    editText8 = editText6;
                }
                if (Helper.NotBeSameAlternateMobileNumber(editText8.getText().toString().trim(), editText2.getText().toString().trim())) {
                    Toast.makeText(this, getResources().getString(R.string.change_alternate_number), 0).show();
                    return;
                }
                String strTrim = editText.getText().toString().trim();
                String strTrim2 = editText3.getText().toString().trim();
                String strTrim3 = editText2.getText().toString().trim();
                String strTrim4 = editText8.getText().toString().trim();
                String strTrim5 = this.statesTV.getText().toString().trim();
                String strTrim6 = this.districtTV.getText().toString().trim();
                String strTrim7 = editText4.getText().toString().trim();
                String strTrim8 = editText5.getText().toString().trim();
                String strTrim9 = editText7.getText().toString().trim();
                if (checkBox != null && checkBox.isChecked()) {
                    z = true;
                }
                this.isDefault = z;
                this.address1 = new Address(strTrim, strTrim2, strTrim5, strTrim7, strTrim3, strTrim4, strTrim8, strTrim9, strTrim6, this.SelectedStateid);
                this.addressJson = new Gson().toJson(this.address1);
                this.isAddressEdited = true;
                dialog.dismiss();
                hitApiForSavingAddress();
                dialog2.dismiss();
                return;
            }
            Toast.makeText(this, getResources().getString(R.string.enter_valid_pin_code), 0).show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void getSavedAddressDailog() {
        try {
            if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
                return;
            }
            this.mLastClickTime = SystemClock.elapsedRealtime();
            StatesCities statesCities = this.cities;
            if (statesCities != null && statesCities.getData() != null) {
                this.cities.getData().clear();
            }
            Dialog dialog = new Dialog(this, R.style.address);
            this.dialogGettingSavedAddress = dialog;
            boolean z = true;
            dialog.setCancelable(true);
            this.dialogGettingSavedAddress.requestWindowFeature(1);
            this.dialogGettingSavedAddress.setContentView(R.layout.add_address_layout_theme_2);
            RelativeLayout relativeLayout = (RelativeLayout) this.dialogGettingSavedAddress.findViewById(R.id.subRL);
            RelativeLayout relativeLayout2 = (RelativeLayout) this.dialogGettingSavedAddress.findViewById(R.id.addAddressLayout);
            if (relativeLayout2 != null) {
                relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda19
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$getSavedAddressDailog$38(view);
                    }
                });
            }
            ScrollView scrollView = (ScrollView) this.dialogGettingSavedAddress.findViewById(R.id.main_rl);
            if (scrollView != null) {
                scrollView.setVisibility(8);
            }
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            Button button = (Button) this.dialogGettingSavedAddress.findViewById(R.id.saveAddress);
            ((TextView) this.dialogGettingSavedAddress.findViewById(R.id.toolbarTitleTV)).setText("Select Address");
            EditText editText = (EditText) this.dialogGettingSavedAddress.findViewById(R.id.nameTV);
            this.recyclerViewSavedAddress = (RecyclerView) this.dialogGettingSavedAddress.findViewById(R.id.recyclerViewSavedAddress);
            this.statesTV = (TextView) this.dialogGettingSavedAddress.findViewById(R.id.stateTV);
            this.districtTV = (TextView) this.dialogGettingSavedAddress.findViewById(R.id.districtTV);
            ImageView imageView = (ImageView) this.dialogGettingSavedAddress.findViewById(R.id.image_back);
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda20
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$getSavedAddressDailog$39(view);
                    }
                });
            }
            if (button != null) {
                button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda21
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$getSavedAddressDailog$40(view);
                    }
                });
            }
            if (editText != null) {
                editText.setText(SharedPreference.getInstance().getLoggedInUser().getName());
                LeftMenu leftMenu = this.leftMenu;
                if (leftMenu != null) {
                    if (!leftMenu.getDisable_name_edit().equalsIgnoreCase("0") && !this.leftMenu.getDisable_name_edit().equalsIgnoreCase("")) {
                        z = false;
                    }
                    editText.setEnabled(z);
                }
            }
            if (this.isBook.equalsIgnoreCase("1") || isComboBook()) {
                this.isFirstTime = false;
                hitApiForGettingAddress();
            }
            View viewFindViewById = this.dialogGettingSavedAddress.findViewById(R.id.dialog_root);
            View viewFindViewById2 = this.dialogGettingSavedAddress.findViewById(R.id.main_toolbar);
            Window window = this.dialogGettingSavedAddress.getWindow();
            if (Build.VERSION.SDK_INT == 36 && window != null && viewFindViewById != null && viewFindViewById2 != null) {
                EdgeToEdgeHelperOld.applyDialogHeaderInsets(window, viewFindViewById, viewFindViewById2);
            }
            try {
                this.dialogGettingSavedAddress.show();
            } catch (Exception unused) {
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getSavedAddressDailog$38(View view) {
        addressDailog(this.dialogGettingSavedAddress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getSavedAddressDailog$39(View view) {
        this.dialogGettingSavedAddress.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getSavedAddressDailog$40(View view) {
        this.dialogGettingSavedAddress.dismiss();
        for (AddressMaster addressMaster : this.addressListMaster) {
            if (addressMaster.isChecked()) {
                this.addressMaster = addressMaster;
            }
        }
        getAddressDetail(this.addressMaster);
    }

    @Override // com.appnew.android.Payment.OnCouponClicked
    public void onCouponClicked(EditText coupon_edt) {
        manageCouponApply(coupon_edt);
    }

    private void getselfAndPreCoupon() {
        this.selfCouponArrayList.clear();
        this.preCouponArrayList.clear();
        for (CoursesCoupon coursesCoupon : this.coursesCouponArrayListMultiple) {
            coursesCoupon.setIs_select(false);
            if (coursesCoupon.getCoupon().getTarget_type().equalsIgnoreCase("1")) {
                this.selfCouponArrayList.add(coursesCoupon);
            } else if (coursesCoupon.getCoupon().getTarget_type().equalsIgnoreCase("2")) {
                this.preCouponArrayList.add(coursesCoupon);
            }
        }
    }

    /* JADX INFO: renamed from: openwatchlist_dailog_resource, reason: merged with bridge method [inline-methods] */
    public void lambda$onCreate$2(Context context) {
        try {
            if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
                return;
            }
            this.mLastClickTime = SystemClock.elapsedRealtime();
            ArrayList<CoursesCoupon> arrayList = this.coursesCouponArrayList;
            if (arrayList != null && arrayList.size() == 1 && this.coursesCouponArrayList.get(0).getCoupon().getTarget_type().equalsIgnoreCase("2")) {
                return;
            }
            ArrayList<CoursesCoupon> arrayList2 = this.coursesCouponArrayListMultiple;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                if (this.withoutCouponLayout.isShown()) {
                    this.selectedCouponId = "";
                }
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.videosheetDialogTheme);
                this.watchlist = bottomSheetDialog;
                bottomSheetDialog.setContentView(R.layout.choose_coupun_layout);
                ((Window) Objects.requireNonNull(this.watchlist.getWindow())).getAttributes().windowAnimations = R.style.PauseDialogAnimation;
                this.watchlist.setCancelable(true);
                ImageView imageView = (ImageView) this.watchlist.findViewById(R.id.ibt_single_vd_iv);
                TextView textView = (TextView) this.watchlist.findViewById(R.id.view2);
                TextView textView2 = (TextView) this.watchlist.findViewById(R.id.view3);
                RelativeLayout relativeLayout = (RelativeLayout) this.watchlist.findViewById(R.id.editCouponRl);
                final EditText editText = (EditText) this.watchlist.findViewById(R.id.coupon_edt);
                TextView textView3 = (TextView) this.watchlist.findViewById(R.id.apply_coupon);
                TextView textView4 = (TextView) this.watchlist.findViewById(R.id.cname);
                ImageView imageView2 = (ImageView) this.watchlist.findViewById(R.id.cancel_coupon);
                RecyclerView recyclerView = (RecyclerView) this.watchlist.findViewById(R.id.recycler_view_validy);
                ((TextView) Objects.requireNonNull(textView4)).setText(this.courseDetail.getData().getCourseDetail().getTitle());
                ((TextView) Objects.requireNonNull(textView)).setText(getResources().getString(R.string.have_a_coupon));
                if (imageView != null) {
                    Helper.setThumbnailImage(this, this.courseDetail.getData().getCourseDetail().getCover_image(), getDrawable(R.drawable.book_logo), imageView);
                }
                if (!this.selfCouponArrayList.isEmpty() && !this.preCouponArrayList.isEmpty()) {
                    ((TextView) Objects.requireNonNull(textView2)).setVisibility(0);
                } else {
                    ((TextView) Objects.requireNonNull(textView2)).setVisibility(8);
                }
                if (!this.selfCouponArrayList.isEmpty()) {
                    ((RelativeLayout) Objects.requireNonNull(relativeLayout)).setVisibility(0);
                } else {
                    ((RelativeLayout) Objects.requireNonNull(relativeLayout)).setVisibility(8);
                }
                if (!this.preCouponArrayList.isEmpty()) {
                    ((RecyclerView) Objects.requireNonNull(recyclerView)).setVisibility(0);
                } else {
                    ((RecyclerView) Objects.requireNonNull(recyclerView)).setVisibility(8);
                }
                if (this.isSelfCoupon) {
                    editText.setText(this.selectedCouponId);
                }
                editText.addTextChangedListener(new TextWatcher() { // from class: com.appnew.android.Payment.PurchaseActivity.10
                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable editable) {
                    }

                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                    }
                });
                if (!this.preCouponArrayList.isEmpty()) {
                    for (CoursesCoupon coursesCoupon : this.preCouponArrayList) {
                        coursesCoupon.setIs_select(coursesCoupon.getCoupon().getId().equalsIgnoreCase(this.selectedCouponId));
                    }
                    this.extendAdapter = new CouponPurchaseAdapter(context, this.preCouponArrayList, editText, this);
                    ((RecyclerView) Objects.requireNonNull(recyclerView)).setLayoutManager(new LinearLayoutManager(context, 1, false));
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setAdapter(this.extendAdapter);
                    recyclerView.scheduleLayoutAnimation();
                }
                if (!this.watchlist.isShowing()) {
                    this.watchlist.show();
                }
                ((ImageView) Objects.requireNonNull(imageView2)).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda36
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$openwatchlist_dailog_resource$41(view);
                    }
                });
                ((TextView) Objects.requireNonNull(textView3)).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda37
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$openwatchlist_dailog_resource$42(editText, view);
                    }
                });
                return;
            }
            Toast.makeText(this, "Coupon Not Available", 0).show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openwatchlist_dailog_resource$41(View view) {
        dismissCalculatorDialog(this.watchlist);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openwatchlist_dailog_resource$42(EditText editText, View view) {
        if (editText != null && !TextUtils.isEmpty(editText.getText().toString())) {
            manageCouponApply(editText);
        } else {
            Toast.makeText(this, "Please enter coupon code", 0).show();
        }
    }

    void manageCouponApply(EditText coupon_edt) {
        String str;
        boolean z;
        if (coupon_edt == null || TextUtils.isEmpty(coupon_edt.getText().toString())) {
            int i = 0;
            while (true) {
                if (i >= this.preCouponArrayList.size()) {
                    str = "";
                    break;
                } else {
                    if (this.preCouponArrayList.get(i).isIs_select()) {
                        str = "" + i;
                        this.isSelfCoupon = false;
                        break;
                    }
                    i++;
                }
            }
            z = false;
        } else {
            int i2 = 0;
            while (true) {
                if (i2 >= this.selfCouponArrayList.size()) {
                    str = "";
                    break;
                } else {
                    if (this.selfCouponArrayList.get(i2).getCoupon().getCoupon_title().equalsIgnoreCase(coupon_edt.getText().toString())) {
                        str = "" + i2;
                        this.isSelfCoupon = true;
                        break;
                    }
                    i2++;
                }
            }
            z = true;
        }
        if (BuildConfig.FLAVOR.equals("exampur") && this.preCouponArrayList.size() < 0) {
            this.appliedCouponCode = coupon_edt.getText().toString();
            this.networkCall.NetworkAPICall(API.verifyCoupon, "", true, false);
            return;
        }
        if (str.equalsIgnoreCase("") && this.stopValidationOnCoupon.intValue() != 1) {
            Toast.makeText(this, (this.isSelfCoupon || z) ? "Please enter valid coupon code" : getResources().getString(R.string.select_any_coupon), 0).show();
            return;
        }
        dismissCalculatorDialog(this.watchlist);
        if (this.stopValidationOnCoupon.intValue() != 1) {
            if (this.isSelfCoupon) {
                CoursesCoupon coursesCoupon = this.selfCouponArrayList.get(Integer.parseInt(str));
                this.coursesCoupon = coursesCoupon;
                this.selectedCouponId = coursesCoupon.getCoupon().getCoupon_title();
            } else {
                CoursesCoupon coursesCoupon2 = this.preCouponArrayList.get(Integer.parseInt(str));
                this.coursesCoupon = coursesCoupon2;
                this.selectedCouponId = coursesCoupon2.getCoupon().getId();
            }
            this.appliedCouponCode = this.coursesCoupon.getCoupon().getCoupon_title();
            this.appliedCouponCodeId = this.coursesCoupon.getCoupon().getId();
        } else {
            this.appliedCouponCode = coupon_edt.getText().toString();
            this.appliedCouponCodeId = String.valueOf(this.stopValidationOnCoupon);
        }
        this.networkCall.NetworkAPICall(API.verifyCoupon, "", true, false);
    }

    private void priceUpdate(float total_amount) {
        if (((int) total_amount) <= 0) {
            this.procceed.setText(getResources().getString(R.string.open_in_my_lib));
            this.price = "0";
            this.tax = "0";
            this.tax_value.setText(getResources().getString(R.string.free_));
            this.cgstValue.setText(getResources().getString(R.string.free_));
            this.sgstValue.setText(getResources().getString(R.string.free_));
            this.txtGrandTotalValue.setText(getResources().getString(R.string.free_));
            this.totalPriceValue.setText(getResources().getString(R.string.free_));
            logBuyPreviewEvent(this, this.courseDetail.getData().getCourseDetail().getTitle(), "free");
        } else {
            String str = this.payment_mode;
            if (str != null && str.equalsIgnoreCase("3")) {
                this.toolbarTitleTV.setText(R.string.subscription_plan);
                this.paymentModeValue = this.payment_mode;
                String str2 = this.is_trial;
                if (str2 != null && str2.equalsIgnoreCase("1")) {
                    this.procceed.setText(getResources().getString(R.string.proceed));
                } else {
                    this.procceed.setText("Try for " + this.courseDetail1.getData().getCourseDetail().getValidity() + " in  ₹" + this.courseDetail1.getData().getCourseDetail().getCourseSp().split("\\.")[0]);
                }
            } else {
                this.procceed.setText(getResources().getString(R.string.proceed));
            }
            this.price = "" + Float.parseFloat(this.courseDetail.getData().getCourseDetail().getMrp());
            this.tax = "" + Float.parseFloat(this.courseDetail.getData().getCourseDetail().getTax());
            if (this.isEmiSelected) {
                calculateInstallmentPrice(this.emiTypePos);
            } else {
                this.totalPriceValue.setText(Constants.currencyType + " " + String.format("%.2f", Float.valueOf(Float.parseFloat(this.courseDetail.getData().getCourseDetail().getMrp()))));
                this.tax_value.setText(Constants.currencyType + " " + String.format("%.2f", Float.valueOf(Float.parseFloat(this.courseDetail.getData().getCourseDetail().getTax()))));
                float f2 = Float.parseFloat(this.courseDetail.getData().getCourseDetail().getTax()) / 2.0f;
                this.sgstValue.setText(Constants.currencyType + " " + String.format("%.2f", Float.valueOf(f2)));
                this.cgstValue.setText(Constants.currencyType + " " + String.format("%.2f", Float.valueOf(f2)));
                if (this.isBook.equals("1")) {
                    this.txtGrandTotalValue.setText(Constants.currencyType + " " + String.format("%.2f", Float.valueOf(Float.parseFloat(this.courseDetail.getData().getCourseDetail().getDelivery_charge()) + total_amount)));
                } else {
                    this.txtGrandTotalValue.setText(Constants.currencyType + " " + String.format("%.2f", Float.valueOf(total_amount)));
                }
                this.priceTxtCourse.setText(Constants.currencyType + " " + String.format("%.2f", Float.valueOf(total_amount)));
            }
            logBuyPreviewEvent(this, this.courseDetail.getData().getCourseDetail().getTitle(), "paid");
        }
        manageQRButton();
        if (TextUtils.isEmpty(this.tax) || this.tax.equalsIgnoreCase("0") || this.tax.equalsIgnoreCase(IdManager.DEFAULT_VERSION_NAME)) {
            this.taxLayout.setVisibility(8);
            this.taxes_layout.setVisibility(8);
            this.sgstLayout.setVisibility(8);
            this.sgstLayoutCoupon.setVisibility(8);
            this.cgstLayout.setVisibility(8);
            this.cgstLayoutCoupon.setVisibility(8);
            return;
        }
        if (this.gstShow.booleanValue()) {
            this.taxLayout.setVisibility(8);
            this.taxes_layout.setVisibility(8);
            this.sgstLayout.setVisibility(0);
            this.sgstLayoutCoupon.setVisibility(0);
            this.cgstLayout.setVisibility(0);
            this.cgstLayoutCoupon.setVisibility(0);
            return;
        }
        this.taxLayout.setVisibility(0);
        this.taxes_layout.setVisibility(0);
        this.sgstLayout.setVisibility(8);
        this.sgstLayoutCoupon.setVisibility(8);
        this.cgstLayout.setVisibility(8);
        this.cgstLayoutCoupon.setVisibility(8);
    }

    private void dismissCalculatorDialog(Dialog watchlist) {
        if (watchlist == null || !watchlist.isShowing()) {
            return;
        }
        watchlist.dismiss();
        watchlist.cancel();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        byte b2 = -1;
        switch (apitype.hashCode()) {
            case -1913965346:
                if (apitype.equals(API.verifyCoupon)) {
                    b2 = 0;
                }
                break;
            case -1421483953:
                if (apitype.equals(API.GET_PRODUCT_ID)) {
                    b2 = 1;
                }
                break;
            case -1273565488:
                if (apitype.equals(API.DELETE_USER_ADDRESS)) {
                    b2 = 2;
                }
                break;
            case -1064760819:
                if (apitype.equals(API.GET_USER_ADDRESS)) {
                    b2 = 3;
                }
                break;
            case -787266248:
                if (apitype.equals(API.API_CITY)) {
                    b2 = 4;
                }
                break;
            case -435982236:
                if (apitype.equals(API.GET_COUPON_OVER_COURSE)) {
                    b2 = 5;
                }
                break;
            case -319596559:
                if (apitype.equals(API.API_STATE)) {
                    b2 = 6;
                }
                break;
            case -185124491:
                if (apitype.equals(API.IN_APP_PURCHASE)) {
                    b2 = 7;
                }
                break;
            case 114126311:
                if (apitype.equals("https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction")) {
                    b2 = 8;
                }
                break;
            case 750643905:
                if (apitype.equals(API.CourseDetail_JS)) {
                    b2 = 9;
                }
                break;
            case 1141454656:
                if (apitype.equals(API.COURSE_ADD_TO_CART)) {
                    b2 = 10;
                }
                break;
            case 1334579443:
                if (apitype.equals(API.COURSE_CART_COUNT)) {
                    b2 = 11;
                }
                break;
            case 1377054835:
                if (apitype.equals("https://appapi.videocrypt.in/index.php/data_model/payment/apply_coupon")) {
                    b2 = 12;
                }
                break;
            case 1741920054:
                if (apitype.equals(API.GET_ADMIT_CARD_URL)) {
                    b2 = 13;
                }
                break;
            case 1878529854:
                if (apitype.equals(API.SAVE_USER_ADDRESS)) {
                    b2 = 14;
                }
                break;
            case 2002393681:
                if (apitype.equals(API.int_payment)) {
                    b2 = Ascii.SI;
                }
                break;
        }
        switch (b2) {
            case 0:
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setCourse_id(this.courseDetail.getData().getCourseDetail().getId());
                encryptionData.setCoupon_code(this.appliedCouponCode);
                encryptionData.setExternal_coupon(this.secondCouponCode);
                encryptionData.setPayment_mode(this.paymentModeValue);
                if (this.courseDetail.getData().getCourseDetail().getCat_type().equalsIgnoreCase("1")) {
                    encryptionData.setQuantity(this.quantityOfBooks);
                }
                String json = new Gson().toJson(encryptionData);
                Log.d("TAGverifyCoupon", "Param: " + json);
                return service.verifyCoupon(AES.encrypt(json));
            case 1:
                EncryptionData encryptionData2 = new EncryptionData();
                encryptionData2.setCourse_id(this.courseDetail.getData().getCourseDetail().getId());
                return service.GET_PRODUCT_ID(AES.encrypt(new Gson().toJson(encryptionData2)));
            case 2:
                EncryptionData encryptionData3 = new EncryptionData();
                encryptionData3.setAddress(this.addressJson);
                encryptionData3.setId(this.addressId);
                return service.DELETE_USER_ADDRESS(AES.encrypt(new Gson().toJson(encryptionData3)));
            case 3:
                return service.GET_USER_ADDRESS(AES.encrypt(new Gson().toJson(new EncryptionData())));
            case 4:
                EncryptionData encryptionData4 = new EncryptionData();
                encryptionData4.setState_id(this.SelectedStateid);
                return service.GetCity(AES.encrypt(new Gson().toJson(encryptionData4)));
            case 5:
                EncryptionData encryptionData5 = new EncryptionData();
                encryptionData5.setCourse_id(this.courseDetail.getData().getCourseDetail().getId());
                encryptionData5.setParent_id(SingleStudy.parentCourseId);
                if (this.courseDetail.getData().getCourseDetail().getCat_type().equalsIgnoreCase("1")) {
                    encryptionData5.setQuantity(this.quantityOfBooks);
                }
                return service.GET_COUPON_OVER_COURSE(AES.encrypt(new Gson().toJson(encryptionData5)));
            case 6:
                EncryptionData encryptionData6 = new EncryptionData();
                encryptionData6.setCountry_id("");
                return service.GetState(AES.encrypt(new Gson().toJson(encryptionData6)));
            case 7:
                EncryptionData encryptionData7 = new EncryptionData();
                encryptionData7.setCourse_id(this.courseDetail.getData().getCourseDetail().getId());
                encryptionData7.setCourse_price(this.courseDetail.getData().getCourseDetail().getMrp());
                encryptionData7.setProduct_id(this.product_id);
                return service.IN_APP_PURCHASE(AES.encrypt(new Gson().toJson(encryptionData7)));
            case 8:
                if (this.withCouponLayout.isShown()) {
                    EncryptionData encryptionData8 = new EncryptionData();
                    encryptionData8.setCourse_id(this.coursesCoupon.getId());
                    encryptionData8.setCoupon_applied(this.coursesCoupon.getCoupon().getId());
                    encryptionData8.setParent_id("0");
                    return service.free_transaction(AES.encrypt(new Gson().toJson(encryptionData8)));
                }
                EncryptionData encryptionData9 = new EncryptionData();
                encryptionData9.setCourse_id(this.courseDetail.getData().getCourseDetail().getId());
                encryptionData9.setCoupon_applied(this.coupon_applied);
                encryptionData9.setParent_id(SingleStudy.parentCourseId);
                return service.free_transaction(AES.encrypt(new Gson().toJson(encryptionData9)));
            case 9:
                EncryptionData encryptionData10 = new EncryptionData();
                encryptionData10.setCourse_id(this.mainCourseId);
                encryptionData10.setParent_id(SingleStudy.parentCourseId);
                return service.getCourseData(AES.encrypt(new Gson().toJson(encryptionData10)));
            case 10:
                EncryptionData encryptionData11 = new EncryptionData();
                encryptionData11.setCourse_id(this.courseDetail.getData().getCourseDetail().getId());
                encryptionData11.setCourse_name(this.courseDetail.getData().getCourseDetail().getTitle());
                encryptionData11.setQuantity("1");
                encryptionData11.setCourse_price(String.format("%.2f", Float.valueOf(Float.parseFloat(this.courseDetail.getData().getCourseDetail().getMrp()))));
                return service.addItemInCart(AES.encrypt(new Gson().toJson(encryptionData11)));
            case 11:
                EncryptionData encryptionData12 = new EncryptionData();
                encryptionData12.setUser_id(SharedPreference.getInstance().getLoggedInUser().getId());
                return service.getCartCount(AES.encrypt(new Gson().toJson(encryptionData12)));
            case 12:
                EncryptionData encryptionData13 = new EncryptionData();
                encryptionData13.setCourse_id(this.courseDetail.getData().getCourseDetail().getId());
                encryptionData13.setCoupon_code(this.couponCode);
                encryptionData13.setParent_id(SingleStudy.parentCourseId);
                return service.apply_coupon(AES.encrypt(new Gson().toJson(encryptionData13)));
            case 13:
                EncryptionData encryptionData14 = new EncryptionData();
                encryptionData14.setTxn_id(this.pos_txn_id);
                return service.getAdmitCardUrl(AES.encrypt(new Gson().toJson(encryptionData14)));
            case 14:
                EncryptionData encryptionData15 = new EncryptionData();
                encryptionData15.setAddress(this.addressJson);
                if (this.isAddressEdited) {
                    encryptionData15.setId(this.addressMaster.getId());
                }
                encryptionData15.setIs_default(this.isDefault ? "1" : "0");
                return service.SAVE_USER_ADDRESS(AES.encrypt(new Gson().toJson(encryptionData15)));
            case 15:
                if (this.isfailure) {
                    return service.int_payment(callApiIntPaymentOnFailure());
                }
                if (this.pos_txn_id.equalsIgnoreCase("")) {
                    return service.int_payment(callApiIntPayment());
                }
                return service.int_payment(callApiIntPaymentOnSuccess());
            default:
                return null;
        }
    }

    private String callApiIntPayment() {
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setType("1");
        encryptionData.setParent_id(SingleStudy.parentCourseId);
        encryptionData.setTest_id(getIntent().hasExtra("test_id") ? getIntent().getStringExtra("test_id") : "");
        if (this.withCouponLayout.isShown()) {
            encryptionData.setCourse_id(this.coursesCoupon.getId());
            encryptionData.setCoupon_applied(this.appliedCouponCodeId);
            encryptionData.setExternal_coupon(this.secondCouponCode);
            if (this.paymentModeValue.equals("1")) {
                encryptionData.setCourse_price(String.valueOf(Float.parseFloat(this.emiPriceToSend)));
                encryptionData.setTax(String.valueOf(Float.parseFloat(this.finalTaxValue)));
                encryptionData.setPayment_meta(this.paymentMetaValue);
                encryptionData.setAttempt(String.valueOf(Integer.parseInt(this.paymentAttemptValue) + 1));
                encryptionData.setSubscription_code(this.subscription_code);
                encryptionData.setPayment_for("1");
                encryptionData.setPlan_id(this.planId);
                encryptionData.setPayment_mode("1");
            } else if (this.paymentModeValue.equals("3")) {
                encryptionData.setPlan_id(this.planId);
                encryptionData.setPayment_mode("3");
                encryptionData.setCourse_price(String.format("%.2f", Float.valueOf(Float.parseFloat(this.coursesCoupon.getMrp()))));
                encryptionData.setTax(String.format("%.2f", Float.valueOf(Float.parseFloat(this.coursesCoupon.getTax()))));
            } else {
                encryptionData.setCourse_price(String.format("%.2f", Float.valueOf(Float.parseFloat(this.coursesCoupon.getMrp()))));
                encryptionData.setTax(String.format("%.2f", Float.valueOf(Float.parseFloat(this.coursesCoupon.getTax()))));
            }
        } else {
            encryptionData.setCourse_id(this.courseDetail.getData().getCourseDetail().getId());
            encryptionData.setCoupon_applied(this.coupon_applied);
            if (this.paymentModeValue.equals("1")) {
                encryptionData.setCourse_price(String.valueOf(Float.parseFloat(this.emiPriceToSend)));
                encryptionData.setTax(String.valueOf(Float.parseFloat(this.finalTaxValue)));
                encryptionData.setPayment_meta(this.paymentMetaValue);
                encryptionData.setAttempt(String.valueOf(Integer.parseInt(this.paymentAttemptValue) + 1));
                encryptionData.setSubscription_code(this.subscription_code);
                encryptionData.setPayment_for("1");
                encryptionData.setPlan_id(this.planId);
                encryptionData.setPayment_mode("1");
            } else if (this.paymentModeValue.equals("3")) {
                encryptionData.setPlan_id(this.planId);
                encryptionData.setIs_trial(this.is_trial);
                encryptionData.setCourse_price(this.price);
                encryptionData.setTax(this.tax);
                encryptionData.setPayment_mode("3");
            } else {
                encryptionData.setCourse_price(this.price);
                encryptionData.setTax(this.tax);
            }
        }
        encryptionData.setPay_via(this.paymentViewModel.getPayVia());
        encryptionData.setQuantity(this.quantityOfBooks);
        String str = this.addressJson;
        if (str != null) {
            encryptionData.setAddress(str);
        } else {
            encryptionData.setAddress("");
        }
        if (this.isBook.equals("1")) {
            encryptionData.setDelivery_charge(this.deliveryCharge);
        } else {
            encryptionData.setDelivery_charge("0");
        }
        String json = new Gson().toJson(encryptionData);
        this.productdata = json;
        return AES.encrypt(json);
    }

    private void getProductData(String pre_transaction_id, String payment_type, String event_type) {
        try {
            JSONObject jSONObject = new JSONObject(this.productdata);
            Helper.firebaseAnalytics(this, this.courseDetail.getData().getCourseDetail().getTitle(), String.valueOf(Double.valueOf(jSONObject.getString(Const.COURSE_PRICE)).doubleValue() + Double.valueOf(jSONObject.getString(Const.COURSE_PRICE)).doubleValue()), jSONObject.getString("tax"), pre_transaction_id, this.courseDetail.getData().getCourseDetail().getId(), payment_type, event_type);
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    private String callApiIntPaymentOnFailure() {
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setType("2");
        encryptionData.setParent_id(SingleStudy.parentCourseId);
        encryptionData.setPre_transaction_id(this.pre_txtid);
        encryptionData.setTransaction_status("2");
        encryptionData.setPost_transaction_id("");
        encryptionData.setQuantity(this.quantityOfBooks);
        encryptionData.setTest_id(getIntent().hasExtra("test_id") ? getIntent().getStringExtra("test_id") : "");
        if (this.withCouponLayout.isShown()) {
            encryptionData.setCourse_id(this.coursesCoupon.getId());
            encryptionData.setCoupon_applied(this.coursesCoupon.getCoupon().getId());
        } else {
            encryptionData.setCourse_id(this.courseDetail.getData().getCourseDetail().getId());
            encryptionData.setCoupon_applied(this.coupon_applied);
        }
        String str = this.addressJson;
        if (str != null) {
            encryptionData.setAddress(str);
        } else {
            encryptionData.setAddress("");
        }
        return AES.encrypt(new Gson().toJson(encryptionData));
    }

    private String callApiIntPaymentOnSuccess() {
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setType("2");
        encryptionData.setTest_id(getIntent().hasExtra("test_id") ? getIntent().getStringExtra("test_id") : "");
        encryptionData.setParent_id(SingleStudy.parentCourseId);
        encryptionData.setPre_transaction_id(this.pre_txtid);
        encryptionData.setTransaction_status("1");
        encryptionData.setPost_transaction_id(this.pos_txn_id);
        encryptionData.setRid(this.rid);
        encryptionData.setScd(this.scd);
        encryptionData.setPid(this.pos_txn_id);
        encryptionData.setAmt(this.amt);
        encryptionData.setOrder_id(this.pos_txn_id);
        encryptionData.setQuantity(this.quantityOfBooks);
        if (this.withCouponLayout.isShown()) {
            encryptionData.setCourse_id(this.coursesCoupon.getId());
        } else {
            encryptionData.setCourse_id(this.courseDetail.getData().getCourseDetail().getId());
        }
        String str = this.addressJson;
        if (str != null) {
            encryptionData.setAddress(str);
        } else {
            encryptionData.setAddress("");
        }
        return AES.encrypt(new Gson().toJson(encryptionData));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonobject, String apitype, String typeApi, boolean showprogress) throws JSONException {
        int i;
        boolean z;
        String str;
        String str2;
        apitype.hashCode();
        byte b2 = -1;
        switch (apitype.hashCode()) {
            case -1913965346:
                if (apitype.equals(API.verifyCoupon)) {
                    b2 = 0;
                }
                break;
            case -1421483953:
                if (apitype.equals(API.GET_PRODUCT_ID)) {
                    b2 = 1;
                }
                break;
            case -1273565488:
                if (apitype.equals(API.DELETE_USER_ADDRESS)) {
                    b2 = 2;
                }
                break;
            case -1064760819:
                if (apitype.equals(API.GET_USER_ADDRESS)) {
                    b2 = 3;
                }
                break;
            case -787266248:
                if (apitype.equals(API.API_CITY)) {
                    b2 = 4;
                }
                break;
            case -435982236:
                if (apitype.equals(API.GET_COUPON_OVER_COURSE)) {
                    b2 = 5;
                }
                break;
            case -319596559:
                if (apitype.equals(API.API_STATE)) {
                    b2 = 6;
                }
                break;
            case -185124491:
                if (apitype.equals(API.IN_APP_PURCHASE)) {
                    b2 = 7;
                }
                break;
            case 114126311:
                if (apitype.equals("https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction")) {
                    b2 = 8;
                }
                break;
            case 750643905:
                if (apitype.equals(API.CourseDetail_JS)) {
                    b2 = 9;
                }
                break;
            case 1141454656:
                if (apitype.equals(API.COURSE_ADD_TO_CART)) {
                    b2 = 10;
                }
                break;
            case 1334579443:
                if (apitype.equals(API.COURSE_CART_COUNT)) {
                    b2 = 11;
                }
                break;
            case 1377054835:
                if (apitype.equals("https://appapi.videocrypt.in/index.php/data_model/payment/apply_coupon")) {
                    b2 = 12;
                }
                break;
            case 1741920054:
                if (apitype.equals(API.GET_ADMIT_CARD_URL)) {
                    b2 = 13;
                }
                break;
            case 1878529854:
                if (apitype.equals(API.SAVE_USER_ADDRESS)) {
                    b2 = 14;
                }
                break;
            case 2002393681:
                if (apitype.equals(API.int_payment)) {
                    b2 = Ascii.SI;
                }
                break;
        }
        try {
            switch (b2) {
                case 0:
                    Log.d("TAGverifyCoupon", "verifyCoupon: " + jsonobject.toString());
                    if (jsonobject.optBoolean("status")) {
                        if (jsonobject.optJSONArray("data").length() > 0 && jsonobject.optJSONArray("data").optJSONObject(0).has(FirebaseAnalytics.Param.COUPON)) {
                            this.coursesCouponArrayList.clear();
                            CoursesCoupon coursesCoupon = (CoursesCoupon) new Gson().fromJson(jsonobject.optJSONArray("data").opt(0).toString(), CoursesCoupon.class);
                            this.coursesCoupon = coursesCoupon;
                            this.coursesCouponArrayList.add(coursesCoupon);
                            loadDataAsPerCouponEmi(true);
                            pushEventForCoupon(this.coursesCoupon);
                            if (this.coursesCouponArrayList.get(0).getInstallment() != null && this.coursesCouponArrayList.get(0).getInstallment().size() <= 0) {
                                this.coverEmiPaymentBtn.setVisibility(8);
                            } else {
                                this.coverEmiPaymentBtn.setVisibility(0);
                            }
                            break;
                        }
                    } else {
                        Toast.makeText(this, jsonobject.optString("message"), 0).show();
                        break;
                    }
                    break;
                case 1:
                    if (jsonobject.optBoolean("status") && jsonobject.has("data") && jsonobject.optJSONObject("data").has("course_code") && jsonobject.optJSONObject("data").optString("course_code") != null && !TextUtils.isEmpty(jsonobject.optJSONObject("data").optString("course_code"))) {
                        this.product_id = jsonobject.optJSONObject("data").optString("course_code");
                        BillingClient billingClientBuild = BillingClient.newBuilder(this).setListener(this.purchasesUpdatedListener).enablePendingPurchases().build();
                        this.billingClient = billingClientBuild;
                        if (!billingClientBuild.isReady()) {
                            this.billingClient.startConnection(new BillingClientStateListener() { // from class: com.appnew.android.Payment.PurchaseActivity.11
                                @Override // com.android.billingclient.api.BillingClientStateListener
                                public void onBillingServiceDisconnected() {
                                }

                                @Override // com.android.billingclient.api.BillingClientStateListener
                                public void onBillingSetupFinished(BillingResult billingResult) {
                                    if (billingResult.getResponseCode() == 0) {
                                        PurchaseActivity.this.billingClient.queryProductDetailsAsync(QueryProductDetailsParams.newBuilder().setProductList(ImmutableList.of(QueryProductDetailsParams.Product.newBuilder().setProductId(PurchaseActivity.this.product_id).setProductType("inapp").build())).build(), new ProductDetailsResponseListener() { // from class: com.appnew.android.Payment.PurchaseActivity.11.1
                                            @Override // com.android.billingclient.api.ProductDetailsResponseListener
                                            public void onProductDetailsResponse(BillingResult billingResult2, List<ProductDetails> productDetailsList) {
                                                Iterator<ProductDetails> it = productDetailsList.iterator();
                                                while (it.hasNext()) {
                                                    PurchaseActivity.this.billingClient.launchBillingFlow(PurchaseActivity.this.activity, BillingFlowParams.newBuilder().setProductDetailsParamsList(ImmutableList.of(BillingFlowParams.ProductDetailsParams.newBuilder().setProductDetails(it.next()).build())).build());
                                                }
                                            }
                                        });
                                    }
                                }
                            });
                        }
                    }
                    Log.d(SaslNonza.Response.ELEMENT, jsonobject.toString());
                    break;
                case 2:
                    if (jsonobject.optBoolean("status")) {
                        for (int i2 = 0; i2 < this.addressListMaster.size(); i2++) {
                            if (this.addressListMaster.get(i2).getId().equalsIgnoreCase(this.addressId)) {
                                this.addressListMaster.remove(i2);
                            }
                        }
                        if (this.addressListMaster.size() > 0) {
                            this.addressAdapter.setList(this.addressListMaster);
                            getAddressDetail(this.addressListMaster.get(0));
                        } else {
                            this.addressAdapter.setList(new ArrayList<>());
                            this.address1 = null;
                            this.addressJson = null;
                            this.addedAddressLL.setVisibility(8);
                            this.addressCV.setVisibility(8);
                            this.addAddressBtn.setTextColor(ResourcesCompat.getColor(getResources(), R.color.whie, getTheme()));
                            this.addAddressBtn.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.common_round_corners_button_drawable, getTheme()));
                            this.addAddressBtn.setText("Add ADDRESS");
                            this.haveAddress = false;
                        }
                    }
                    break;
                case 3:
                    if (jsonobject.getBoolean("status")) {
                        this.addedAddressLL.setVisibility(0);
                        this.addressCV.setVisibility(0);
                        this.addAddressBtn.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.common_round_corners_button_drawable, getTheme()));
                        this.addAddressBtn.setTextColor(ResourcesCompat.getColor(getResources(), R.color.whie, getTheme()));
                        this.addAddressBtn.setText("CHANGE ADDRESS");
                        JSONArray jSONArrayOptJSONArray = jsonobject.optJSONArray("data");
                        if (jSONArrayOptJSONArray.length() > 0) {
                            this.addressListMaster.clear();
                            for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                                AddressMaster addressMaster = (AddressMaster) new Gson().fromJson(jSONArrayOptJSONArray.opt(i3).toString(), AddressMaster.class);
                                if (this.addressMaster != null && addressMaster.getId().equalsIgnoreCase(this.addressMaster.getId())) {
                                    addressMaster.setChecked(true);
                                } else {
                                    addressMaster.setChecked(false);
                                }
                                this.addressListMaster.add(addressMaster);
                            }
                            this.haveAddress = true;
                            if (this.isFirstTime) {
                                AsyncTask.execute(new Runnable() { // from class: com.appnew.android.Payment.PurchaseActivity.12
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        boolean z2 = false;
                                        for (AddressMaster addressMaster2 : PurchaseActivity.this.addressListMaster) {
                                            if (addressMaster2.getIs_default().equalsIgnoreCase("1")) {
                                                addressMaster2.setChecked(true);
                                                PurchaseActivity.this.getAddressDetail(addressMaster2);
                                                z2 = true;
                                            }
                                        }
                                        if (z2) {
                                            return;
                                        }
                                        PurchaseActivity.this.addressListMaster.get(0).setChecked(true);
                                        PurchaseActivity purchaseActivity = PurchaseActivity.this;
                                        purchaseActivity.getAddressDetail(purchaseActivity.addressListMaster.get(0));
                                    }
                                });
                            } else {
                                this.recyclerViewSavedAddress.setLayoutManager(new LinearLayoutManager(this));
                                this.recyclerViewSavedAddress.setAdapter(new AddressAdapter(this, this.dialogGettingSavedAddress, this.addressListMaster, this));
                            }
                        } else {
                            this.addedAddressLL.setVisibility(8);
                            this.addressCV.setVisibility(8);
                            if ("1".equalsIgnoreCase("6")) {
                                this.addAddressBtn.setTextColor(ResourcesCompat.getColor(getResources(), R.color.whie, getTheme()));
                            } else {
                                this.addAddressBtn.setTextColor(ResourcesCompat.getColor(getResources(), R.color.whie, getTheme()));
                            }
                            this.addAddressBtn.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.common_round_corners_button_drawable, getTheme()));
                            this.addAddressBtn.setText("Add ADDRESS");
                            this.haveAddress = false;
                        }
                    } else {
                        this.addedAddressLL.setVisibility(8);
                        this.addressCV.setVisibility(8);
                        if ("1".equalsIgnoreCase("6")) {
                            this.addAddressBtn.setTextColor(ResourcesCompat.getColor(getResources(), R.color.whie, getTheme()));
                        } else {
                            this.addAddressBtn.setTextColor(ResourcesCompat.getColor(getResources(), R.color.whie, getTheme()));
                        }
                        this.addAddressBtn.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.common_round_corners_button_drawable, getTheme()));
                        this.addAddressBtn.setText("Add ADDRESS");
                        this.haveAddress = false;
                    }
                    break;
                case 4:
                    if (jsonobject.optBoolean("status")) {
                        this.cities = (StatesCities) new Gson().fromJson(jsonobject.toString(), StatesCities.class);
                    }
                    break;
                case 5:
                    Log.d("TAGverifyCoupon", "GET_COUPON_OVER_COURSE: " + jsonobject.toString());
                    if (jsonobject.optString("status").equals("true")) {
                        this.isCouponGiven = true;
                        Gson gson = new Gson();
                        this.coursesCouponArrayList.clear();
                        JSONArray jSONArrayOptJSONArray2 = jsonobject.optJSONArray("data");
                        for (int i4 = 0; i4 < ((JSONArray) Objects.requireNonNull(jSONArrayOptJSONArray2)).length(); i4++) {
                            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray2.optJSONObject(i4);
                            if (jSONObjectOptJSONObject != null) {
                                if (isCouponBlank(jSONObjectOptJSONObject.opt(FirebaseAnalytics.Param.COUPON)) && this.courseDetail.getData().getCourseDetail().getCat_type().equalsIgnoreCase("1")) {
                                    CoursesCoupon coursesCoupon2 = (CoursesCoupon) gson.fromJson(jSONObjectOptJSONObject.toString(), CoursesCoupon.class);
                                    updateCourseDetail(this.courseDetail1.getData().getCourseDetail(), coursesCoupon2);
                                    updateCourseDetail(this.courseDetail.getData().getCourseDetail(), coursesCoupon2);
                                    if (!this.courseDetail.getData().getCourseDetail().getMrp().isEmpty()) {
                                        priceUpdate(Float.parseFloat(this.courseDetail.getData().getCourseDetail().getMrp()) + Float.parseFloat(this.courseDetail.getData().getCourseDetail().getTax()));
                                    }
                                } else {
                                    this.coursesCouponArrayList.add((CoursesCoupon) gson.fromJson(jSONObjectOptJSONObject.toString(), CoursesCoupon.class));
                                    ArrayList<CoursesCoupon> arrayList = this.coursesCouponArrayList;
                                    CoursesCoupon coursesCoupon3 = (arrayList == null || arrayList.isEmpty()) ? null : this.coursesCouponArrayList.get(0);
                                    if (coursesCoupon3 != null && coursesCoupon3.getStopValidationOnCoupon() != null && coursesCoupon3.getStopValidationOnCoupon().equals(1)) {
                                        this.stopValidationOnCoupon = coursesCoupon3.getStopValidationOnCoupon();
                                        i = 0;
                                    } else {
                                        i = 0;
                                        this.stopValidationOnCoupon = 0;
                                    }
                                    ArrayList<CoursesCoupon> arrayList2 = this.coursesCouponArrayList;
                                    if (arrayList2 != null && arrayList2.size() == 1 && this.coursesCouponArrayList.get(i).getCoupon().getTarget_type().equalsIgnoreCase("2")) {
                                        this.appliedCouponCode = this.coursesCouponArrayList.get(i).getCoupon().getCoupon_title();
                                        String id = this.coursesCouponArrayList.get(i).getCoupon().getId();
                                        this.appliedCouponCodeId = id;
                                        this.selectedCouponId = id;
                                        this.remove.setVisibility(8);
                                    }
                                    this.coursesCouponArrayListMultiple.clear();
                                    this.coursesCouponArrayListMultiple.addAll(this.coursesCouponArrayList);
                                    getselfAndPreCoupon();
                                    loadDataAsPerEmiOrNot();
                                }
                            }
                        }
                    } else {
                        this.isCouponGiven = false;
                        if (!jsonobject.has("auth_code")) {
                            loadDataAsPerEmiOrNot();
                        } else {
                            RetrofitResponse.GetApiData(this, jsonobject.has("auth_code") ? jsonobject.getString("auth_code") : "", jsonobject.getString("message"), false);
                        }
                    }
                    break;
                case 6:
                    if (jsonobject.optBoolean("status")) {
                        this.states = (StatesCities) new Gson().fromJson(jsonobject.toString(), StatesCities.class);
                    }
                    break;
                case 7:
                    if (jsonobject.optBoolean("status")) {
                        if (!SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                            UtkashRoom.getAppDatabase(MakeMyExam.getAppContext()).getCourseDetaildata().deletecoursedetail(SingleStudy.parentCourseId, MakeMyExam.userId);
                        } else if (!this.courseDetail.getData().getCourseDetail().getId().equalsIgnoreCase("")) {
                            UtkashRoom.getAppDatabase(MakeMyExam.getAppContext()).getCourseDetaildata().deletecoursedetail(this.courseDetail.getData().getCourseDetail().getId(), MakeMyExam.userId);
                        }
                        logBuySuccessEvent(this, this.courseDetail.getData().getCourseDetail().getTitle());
                        if (Helper.isNewLoginFlow()) {
                            showUpdateStatePopup();
                        } else {
                            success_dailog();
                        }
                        Toast.makeText(this, "" + jsonobject.optString("message"), 0).show();
                    }
                    Log.d(SaslNonza.Response.ELEMENT, jsonobject.toString());
                    break;
                case 8:
                    try {
                        if (jsonobject.optString("status").equals("true")) {
                            Toast.makeText(this, "" + jsonobject.optString("message"), 0).show();
                            pushEventForFreeCourse();
                            if (!SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                                UtkashRoom.getAppDatabase(MakeMyExam.getAppContext()).getCourseDetaildata().deletecoursedetail(SingleStudy.parentCourseId, MakeMyExam.userId);
                            } else if (!this.courseDetail.getData().getCourseDetail().getId().equalsIgnoreCase("")) {
                                UtkashRoom.getAppDatabase(MakeMyExam.getAppContext()).getCourseDetaildata().deletecoursedetail(this.courseDetail.getData().getCourseDetail().getId(), MakeMyExam.userId);
                            }
                            logBuyNowFreeEvent(this, this.courseDetail.getData().getCourseDetail().getTitle());
                            Iterator<TilesItem> it = this.courseDetail.getData().getTiles().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z = false;
                                } else if (it.next().getType().equalsIgnoreCase(Const.COMBO)) {
                                    z = true;
                                }
                            }
                            Intent intent = new Intent(this, (Class<?>) CourseActivity.class);
                            intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                            intent.putExtra(Const.COURSE_ID_MAIN, !SingleStudy.parentCourseId.equalsIgnoreCase("") ? SingleStudy.parentCourseId : this.courseDetail.getData().getCourseDetail().getId());
                            intent.putExtra(Const.COURSE_PARENT_ID, "");
                            intent.putExtra(Const.IS_COMBO, false);
                            if (z) {
                                intent.putExtra(Const.COMBO_ID, "");
                            }
                            intent.putExtra(AnalyticsConstants.course_name, this.courseDetail.getData().getCourseDetail().getTitle());
                            intent.setFlags(67108864);
                            Helper.gotoActivity_finish(intent, this);
                        } else {
                            Toast.makeText(this.activity, "" + jsonobject.optString("message"), 0).show();
                            RetrofitResponse.GetApiData(this, jsonobject.has("auth_code") ? jsonobject.getString("auth_code") : "", jsonobject.getString("message"), false);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                    break;
                case 9:
                    if (jsonobject.optString("status").equals("true")) {
                        JSONObject jSONObjectOptJSONObject2 = jsonobject.optJSONObject("data");
                        String str3 = Const.COURSE_DETAIL;
                        if (jSONObjectOptJSONObject2.has(Const.COURSE_DETAIL) && jSONObjectOptJSONObject2.optJSONObject(Const.COURSE_DETAIL).has("content_type")) {
                            this.content_type = jSONObjectOptJSONObject2.optJSONObject(Const.COURSE_DETAIL).optString("content_type");
                        }
                        String strOptString = (jSONObjectOptJSONObject2.has(Const.COURSE_DETAIL) && jSONObjectOptJSONObject2.optJSONObject(Const.COURSE_DETAIL).has("is_purchased")) ? jSONObjectOptJSONObject2.optJSONObject(Const.COURSE_DETAIL).optString("is_purchased") : "0";
                        SharedPreference.getInstance().putString(Const.IS_IGST, jSONObjectOptJSONObject2.optString(Const.IS_IGST));
                        if (!this.myDBClass.getuserwisecourse().is_api_code_exits(MakeMyExam.userId, jSONObjectOptJSONObject2.getJSONObject(Const.COURSE_DETAIL).getString("id"))) {
                            UserWiseCourseTable userWiseCourseTable = new UserWiseCourseTable();
                            userWiseCourseTable.setUserid(MakeMyExam.userId);
                            userWiseCourseTable.setCode("ut_011");
                            userWiseCourseTable.setVersion("0.000");
                            userWiseCourseTable.setExp(String.valueOf(MakeMyExam.getTime_server()));
                            userWiseCourseTable.setMeta_id(jSONObjectOptJSONObject2.getJSONObject(Const.COURSE_DETAIL).getString("id"));
                            this.myDBClass.getuserwisecourse().addUser(userWiseCourseTable);
                        }
                        String str4 = "data";
                        String str5 = "";
                        if (!this.myDBClass.getCourseDetaildata().isRecordExistsUserId(MakeMyExam.userId, SingleStudy.parentCourseId + "_" + jSONObjectOptJSONObject2.getJSONObject(Const.COURSE_DETAIL).getString("id"))) {
                            for (int i5 = 0; i5 < jSONObjectOptJSONObject2.getJSONArray("tiles").length(); i5++) {
                                if ("1".equalsIgnoreCase("7")) {
                                    if (!Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject2, i5, "tile_name").equalsIgnoreCase("content")) {
                                        setData(jSONObjectOptJSONObject2, jsonobject, i5);
                                    }
                                } else {
                                    String str6 = this.content_type;
                                    if (str6 != null && !TextUtils.isEmpty(str6) && this.content_type.equalsIgnoreCase("1")) {
                                        if (!Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject2, i5, "tile_name").equalsIgnoreCase("content")) {
                                            setData(jSONObjectOptJSONObject2, jsonobject, i5);
                                        }
                                    } else if (strOptString.equalsIgnoreCase("0")) {
                                        if ("1".equalsIgnoreCase("6")) {
                                            setData(jSONObjectOptJSONObject2, jsonobject, i5);
                                        } else if (!Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject2, i5, "tile_name").equalsIgnoreCase("content")) {
                                            setData(jSONObjectOptJSONObject2, jsonobject, i5);
                                        }
                                    } else {
                                        setData(jSONObjectOptJSONObject2, jsonobject, i5);
                                    }
                                }
                            }
                        }
                        List<CourseDetailTable> list = this.myDBClass.getCourseDetaildata().getcoursedetail(SingleStudy.parentCourseId + "_" + this.mainCourseId, MakeMyExam.userId);
                        if (list != null && list.size() > 0) {
                            CourseDetailData courseDetailData = new CourseDetailData();
                            courseDetailData.setTitle(list.get(0).getCourse_title());
                            courseDetailData.setCourseSp(list.get(0).getCourse_sp());
                            Author author = new Author();
                            author.setTitle(list.get(0).getAuthor_title());
                            courseDetailData.setAuthor(author);
                            courseDetailData.setMrp(list.get(0).getMrp());
                            courseDetailData.setTax(list.get(0).getTax());
                            courseDetailData.setValidity(list.get(0).getValidity());
                            courseDetailData.setId(list.get(0).getCourse_id().split("_")[1]);
                            courseDetailData.setCourseSp(list.get(0).getCourse_sp());
                            courseDetailData.setCover_image(list.get(0).getCover_image());
                            courseDetailData.setDescHeaderImage(list.get(0).getDesc_header_image());
                            courseDetailData.setIsPurchased(list.get(0).getIs_purchased());
                            courseDetailData.setIsPurchased(list.get(0).getIs_purchased());
                            courseDetailData.setViewType(list.get(0).getView_type());
                            courseDetailData.setIs_combo(list.get(0).getIs_combo());
                            courseDetailData.setExternal_coupon_off(list.get(0).getExternal_coupon_off());
                            courseDetailData.setSkip_payment(list.get(0).getSkip_payment());
                            courseDetailData.setCat_type(list.get(0).getCat_type());
                            courseDetailData.setDelivery_charge(list.get(0).getDelivery_charge());
                            courseDetailData.setIs_activated(list.get(0).getIs_activated());
                            courseDetailData.setToken_activation(list.get(0).getToken_activation());
                            courseDetailData.setTxn_id(list.get(0).getTxn_id());
                            courseDetailData.setInstallment(list.get(0).getInstallment());
                            courseDetailData.setIs_gst(list.get(0).getIs_gst());
                            courseDetailData.setDisplay_locked(list.get(0).getDisplay_locked());
                            courseDetailData.setCombo_has_book(list.get(0).getCombo_has_book());
                            this.courseDetail = new CourseDetail();
                            com.appnew.android.Model.COURSEDETAIL.Data data = new com.appnew.android.Model.COURSEDETAIL.Data();
                            data.setCourseDetail(courseDetailData);
                            if (list.size() > 0 && list.get(0) != null && list.get(0).getSubscription_all_data() != null && !list.get(0).getSubscription_all_data().isEmpty()) {
                                data.setSubscriptionAllData((SubscriptionAllData) new Gson().fromJson(list.get(0).getSubscription_all_data(), SubscriptionAllData.class));
                            }
                            ArrayList<TilesItem> arrayList3 = new ArrayList();
                            for (int i6 = 0; i6 < list.size(); i6++) {
                                arrayList3.add(new TilesItem(list.get(i6).getTile_revert(), list.get(i6).getTile_title(), list.get(i6).getTile_id(), list.get(i6).getType(), list.get(i6).getTile_meta(), list.get(i6).getSet_as_demo(), list.get(i6).getThumbnail()));
                            }
                            if (BuildConfig.FLAVOR.equalsIgnoreCase("targetonapp")) {
                                ArrayList arrayList4 = new ArrayList();
                                for (TilesItem tilesItem : arrayList3) {
                                    if (!tilesItem.getType().equalsIgnoreCase("content")) {
                                        arrayList4.add(tilesItem);
                                    }
                                }
                                arrayList3.clear();
                                arrayList3.addAll(arrayList4);
                            }
                            data.setTiles(arrayList3);
                            this.courseDetail.setData(data);
                            setCourseRelatedData();
                        } else {
                            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.has(Const.COURSE_DETAIL) ? jSONObjectOptJSONObject2.optJSONObject(Const.COURSE_DETAIL) : null;
                            if (jSONObjectOptJSONObject3 != null && jSONObjectOptJSONObject3.has("cover_image")) {
                                jSONObjectOptJSONObject3.optString("cover_image");
                            }
                            if (jSONObjectOptJSONObject3 != null && jSONObjectOptJSONObject3.has("cat_type")) {
                                jSONObjectOptJSONObject3.optString("cat_type");
                            }
                            String str7 = "desc_header_image";
                            if (jSONObjectOptJSONObject3 != null && jSONObjectOptJSONObject3.has("desc_header_image")) {
                                jSONObjectOptJSONObject3.optString("desc_header_image");
                            }
                            if (jSONObjectOptJSONObject3 != null && jSONObjectOptJSONObject3.has("title")) {
                                jSONObjectOptJSONObject3.optString("title");
                            }
                            if (jSONObjectOptJSONObject3 != null && jSONObjectOptJSONObject3.has("validity")) {
                                jSONObjectOptJSONObject3.optString("validity");
                            }
                            JSONObject jSONObjectOptJSONObject4 = (jSONObjectOptJSONObject3 == null || !jSONObjectOptJSONObject3.has("desc_header_image")) ? null : jSONObjectOptJSONObject3.optJSONObject("desc_header_image");
                            if (jSONObjectOptJSONObject4 != null && jSONObjectOptJSONObject4.has("title")) {
                                jSONObjectOptJSONObject4.optString("title");
                            }
                            if (jSONObjectOptJSONObject2.has(Const.COURSE_DETAIL)) {
                                ArrayList arrayList5 = new ArrayList();
                                int i7 = 0;
                                while (i7 < jSONObjectOptJSONObject2.getJSONArray("tiles").length()) {
                                    CourseDetailTable courseDetailTable = new CourseDetailTable();
                                    courseDetailTable.setCourse_title(jSONObjectOptJSONObject2.getJSONObject(str3).getString("title"));
                                    List<CourseDetailTable> list2 = list;
                                    courseDetailTable.setCourse_id(SingleStudy.parentCourseId + "_" + jSONObjectOptJSONObject2.getJSONObject(str3).getString("id"));
                                    courseDetailTable.setCover_image(jSONObjectOptJSONObject2.getJSONObject(str3).getString("cover_image"));
                                    courseDetailTable.setDesc_header_image(jSONObjectOptJSONObject2.getJSONObject(str3).getString(str7));
                                    courseDetailTable.setMrp(jSONObjectOptJSONObject2.getJSONObject(str3).getString("mrp"));
                                    courseDetailTable.setCourse_sp(jSONObjectOptJSONObject2.getJSONObject(str3).getString("course_sp"));
                                    courseDetailTable.setValidity(jSONObjectOptJSONObject2.getJSONObject(str3).getString("validity"));
                                    courseDetailTable.setIs_purchased(jSONObjectOptJSONObject2.getJSONObject(str3).getString("is_purchased"));
                                    courseDetailTable.setIs_activated(jSONObjectOptJSONObject2.getJSONObject(str3).getString("is_activated"));
                                    courseDetailTable.setToken_activation(jSONObjectOptJSONObject2.getJSONObject(str3).getString("token_activation"));
                                    courseDetailTable.setTax(jSONObjectOptJSONObject2.getJSONObject(str3).getString("tax"));
                                    courseDetailTable.setView_type(jSONObjectOptJSONObject2.getJSONObject(str3).getString("view_type"));
                                    courseDetailTable.setIs_combo(jSONObjectOptJSONObject2.getJSONObject(str3).getString(Const.IS_COMBO));
                                    if (jSONObjectOptJSONObject2.getJSONObject(str3).has("external_coupon_off") && !TextUtils.isEmpty(jSONObjectOptJSONObject2.getJSONObject(str3).getString("external_coupon_off"))) {
                                        courseDetailTable.setExternal_coupon_off(jSONObjectOptJSONObject2.getJSONObject(str3).getString("external_coupon_off"));
                                        str = str5;
                                    } else {
                                        str = str5;
                                        courseDetailTable.setExternal_coupon_off(str);
                                    }
                                    String str8 = str7;
                                    courseDetailTable.setAuthor_title(jSONObjectOptJSONObject2.getJSONObject(str3).getJSONObject("author").getString("title"));
                                    courseDetailTable.setTile_id(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject2, i7, "id"));
                                    courseDetailTable.setTile_meta(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject2, i7, "meta"));
                                    courseDetailTable.setUser_id(MakeMyExam.userId);
                                    courseDetailTable.setContent_type(this.content_type);
                                    if (jSONObjectOptJSONObject2.getJSONArray("tiles").getJSONObject(i7).has("thumbnail")) {
                                        courseDetailTable.setThumbnail(jSONObjectOptJSONObject2.getJSONArray("tiles").getJSONObject(i7).getString("thumbnail"));
                                    }
                                    courseDetailTable.setTile_revert(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject2, i7, Const.REVERT_API));
                                    courseDetailTable.setTile_title(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject2, i7, "tile_name"));
                                    courseDetailTable.setSet_as_demo(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject2, i7, "set_as_demo"));
                                    courseDetailTable.setType(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject2, i7, "type"));
                                    courseDetailTable.setInstallment(jSONObjectOptJSONObject2.getJSONObject("instalment").toString());
                                    courseDetailTable.setIs_gst(jSONObjectOptJSONObject2.getJSONObject(str3).getString("is_gst"));
                                    if (jSONObjectOptJSONObject2.getJSONObject(str3).has("avg_rating") && !TextUtils.isEmpty(jSONObjectOptJSONObject2.getJSONObject(str3).getString("avg_rating"))) {
                                        courseDetailTable.setAvg_rating(jSONObjectOptJSONObject2.getJSONObject(str3).getString("avg_rating"));
                                    } else {
                                        courseDetailTable.setAvg_rating(str);
                                    }
                                    if (jSONObjectOptJSONObject2.getJSONObject(str3).has("user_rated") && !TextUtils.isEmpty(jSONObjectOptJSONObject2.getJSONObject(str3).getString("user_rated"))) {
                                        courseDetailTable.setUser_rated(jSONObjectOptJSONObject2.getJSONObject(str3).getString("user_rated"));
                                    } else {
                                        courseDetailTable.setUser_rated(str);
                                    }
                                    if (jSONObjectOptJSONObject2.getJSONObject(str3).has("stocks") && !TextUtils.isEmpty(jSONObjectOptJSONObject2.getJSONObject(str3).getString("stocks"))) {
                                        courseDetailTable.setStocks(jSONObjectOptJSONObject2.getJSONObject(str3).getString("stocks"));
                                    } else {
                                        courseDetailTable.setStocks(str);
                                    }
                                    if (jSONObjectOptJSONObject2.getJSONObject(str3).getString("skip_payment") != null) {
                                        courseDetailTable.setSkip_payment(jSONObjectOptJSONObject2.getJSONObject(str3).getString("skip_payment"));
                                    } else {
                                        courseDetailTable.setSkip_payment("1");
                                    }
                                    if (jSONObjectOptJSONObject2.getJSONObject(str3).getString("cat_type") != null) {
                                        courseDetailTable.setCat_type(jSONObjectOptJSONObject2.getJSONObject(str3).getString("cat_type"));
                                    } else {
                                        courseDetailTable.setCat_type(str);
                                    }
                                    if (jSONObjectOptJSONObject2.getJSONObject(str3).getString(Const.DELIVERY_CHARGE) != null) {
                                        courseDetailTable.setDelivery_charge(jSONObjectOptJSONObject2.getJSONObject(str3).getString(Const.DELIVERY_CHARGE));
                                    } else {
                                        courseDetailTable.setDelivery_charge("0");
                                    }
                                    courseDetailTable.setTxn_id(jSONObjectOptJSONObject2.getJSONObject(str3).getString("txn_id"));
                                    if (jSONObjectOptJSONObject2.getJSONObject(str3).has("combo_has_book") && !TextUtils.isEmpty(jSONObjectOptJSONObject2.getJSONObject(str3).getString("combo_has_book"))) {
                                        courseDetailTable.setCombo_has_book(jSONObjectOptJSONObject2.getJSONObject(str3).getString("combo_has_book"));
                                    } else {
                                        courseDetailTable.setCombo_has_book("0");
                                    }
                                    String str9 = str4;
                                    JSONObject jSONObject = jSONObjectOptJSONObject2;
                                    if (jsonobject.optJSONObject(str9).optJSONObject("subscription_all_data") != null) {
                                        str2 = str3;
                                        courseDetailTable.setSubscription_all_data(new Gson().toJson((SubscriptionAllData) new Gson().fromJson(jsonobject.optJSONObject(str9).optJSONObject("subscription_all_data").toString(), SubscriptionAllData.class)));
                                    } else {
                                        str2 = str3;
                                    }
                                    arrayList5.add(courseDetailTable);
                                    i7++;
                                    str5 = str;
                                    str4 = str9;
                                    jSONObjectOptJSONObject2 = jSONObject;
                                    str3 = str2;
                                    list = list2;
                                    str7 = str8;
                                }
                                List<CourseDetailTable> list3 = list;
                                if (arrayList5.size() > 0) {
                                    CourseDetailData courseDetailData2 = new CourseDetailData();
                                    courseDetailData2.setTitle(((CourseDetailTable) arrayList5.get(0)).getCourse_title());
                                    courseDetailData2.setCourseSp(((CourseDetailTable) arrayList5.get(0)).getCourse_sp());
                                    Author author2 = new Author();
                                    author2.setTitle(((CourseDetailTable) arrayList5.get(0)).getAuthor_title());
                                    courseDetailData2.setAuthor(author2);
                                    courseDetailData2.setMrp(((CourseDetailTable) arrayList5.get(0)).getMrp());
                                    courseDetailData2.setTax(((CourseDetailTable) arrayList5.get(0)).getTax());
                                    courseDetailData2.setValidity(((CourseDetailTable) arrayList5.get(0)).getValidity());
                                    courseDetailData2.setId(((CourseDetailTable) arrayList5.get(0)).getCourse_id().split("_")[1]);
                                    courseDetailData2.setCourseSp(((CourseDetailTable) arrayList5.get(0)).getCourse_sp());
                                    courseDetailData2.setCover_image(((CourseDetailTable) arrayList5.get(0)).getCover_image());
                                    courseDetailData2.setDescHeaderImage(((CourseDetailTable) arrayList5.get(0)).getDesc_header_image());
                                    courseDetailData2.setIsPurchased(((CourseDetailTable) arrayList5.get(0)).getIs_purchased());
                                    courseDetailData2.setViewType(((CourseDetailTable) arrayList5.get(0)).getView_type());
                                    courseDetailData2.setIs_combo(((CourseDetailTable) arrayList5.get(0)).getIs_combo());
                                    courseDetailData2.setAvg_rating(((CourseDetailTable) arrayList5.get(0)).getAvg_rating());
                                    courseDetailData2.setUser_rated(((CourseDetailTable) arrayList5.get(0)).getUser_rated());
                                    courseDetailData2.setStocks(((CourseDetailTable) arrayList5.get(0)).getStocks());
                                    courseDetailData2.setSkip_payment(((CourseDetailTable) arrayList5.get(0)).getSkip_payment());
                                    courseDetailData2.setCat_type(((CourseDetailTable) arrayList5.get(0)).getCat_type());
                                    courseDetailData2.setExternal_coupon_off(((CourseDetailTable) arrayList5.get(0)).getExternal_coupon_off());
                                    courseDetailData2.setDelivery_charge(((CourseDetailTable) arrayList5.get(0)).getDelivery_charge());
                                    courseDetailData2.setIs_activated(((CourseDetailTable) arrayList5.get(0)).getIs_activated());
                                    courseDetailData2.setToken_activation(((CourseDetailTable) arrayList5.get(0)).getToken_activation());
                                    courseDetailData2.setTxn_id(((CourseDetailTable) arrayList5.get(0)).getTxn_id());
                                    courseDetailData2.setInstallment(((CourseDetailTable) arrayList5.get(0)).getInstallment());
                                    courseDetailData2.setIs_gst(((CourseDetailTable) arrayList5.get(0)).getIs_gst());
                                    courseDetailData2.setDisplay_locked(((CourseDetailTable) arrayList5.get(0)).getDisplay_locked());
                                    courseDetailData2.setCombo_has_book(((CourseDetailTable) arrayList5.get(0)).getCombo_has_book());
                                    this.courseDetail = new CourseDetail();
                                    com.appnew.android.Model.COURSEDETAIL.Data data2 = new com.appnew.android.Model.COURSEDETAIL.Data();
                                    data2.setCourseDetail(courseDetailData2);
                                    if (list3.size() > 0 && list3.get(0) != null && list3.get(0).getSubscription_all_data() != null && !list3.get(0).getSubscription_all_data().isEmpty()) {
                                        data2.setSubscriptionAllData((SubscriptionAllData) new Gson().fromJson(list3.get(0).getSubscription_all_data(), SubscriptionAllData.class));
                                    }
                                    this.courseDetail.setData(data2);
                                    setCourseRelatedData();
                                }
                            }
                        }
                    } else {
                        RetrofitResponse.GetApiData(this.activity, jsonobject.optString("auth_code"), jsonobject.optString("message"), false);
                    }
                    break;
                case 10:
                    try {
                        if (jsonobject.getString("status").equalsIgnoreCase("true")) {
                            Toast.makeText(this.activity, "" + jsonobject.getString("message"), 0).show();
                            this.networkCall.NetworkAPICall(API.COURSE_CART_COUNT, "", true, false);
                        } else {
                            Toast.makeText(this.activity, jsonobject.getString("message"), 0).show();
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                    break;
                case 11:
                    if (jsonobject.optString("status").equals("true")) {
                        if (jsonobject.has("data")) {
                            SharedPreference.getInstance().putInt(Const.CART_COUNT, Integer.parseInt(jsonobject.getJSONObject("data").getString("total_count")));
                        }
                    } else if (jsonobject.optString("auth_code") != null) {
                        jsonobject.optString("auth_code").equalsIgnoreCase(Const.EXPIRY_AUTH_CODE);
                    }
                    break;
                case 12:
                    try {
                        if (jsonobject.optString("status").equals("true")) {
                            JSONObject jSONObject2 = jsonobject.getJSONObject("data");
                            this.coupon_applied = jSONObject2.optString("id");
                            if (jSONObject2.optString("coupon_type").equalsIgnoreCase("1")) {
                                flat_percentage(jSONObject2.optString("coupon_value"), this.couponCode);
                            } else if (jSONObject2.optString("coupon_type").equalsIgnoreCase("2")) {
                                percentage_calculate(jSONObject2.optString("coupon_value"));
                            }
                        } else if (jsonobject.has("auth_code")) {
                            RetrofitResponse.GetApiData(this, jsonobject.has("auth_code") ? jsonobject.getString("auth_code") : "", jsonobject.getString("message"), false);
                        } else {
                            ErrorCallBack(jsonobject.getString("message"), apitype, typeApi);
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        return;
                    }
                    break;
                case 13:
                    if (jsonobject.optString("status").equals("true")) {
                        String strOptString2 = jsonobject.optString("data");
                        if (strOptString2 == null && strOptString2.equals("")) {
                            Intent intent2 = new Intent(this, (Class<?>) DashboardActivityTheme1.class);
                            intent2.setFlags(67141632);
                            Helper.gotoActivity_finish(intent2, this);
                        }
                        Intent intent3 = new Intent(this, (Class<?>) PdfDetailScreen.class);
                        intent3.putExtra("url", strOptString2);
                        intent3.putExtra("title", this.courseDetail.getData().getCourseDetail().getTitle());
                        intent3.putExtra("pdf_name", "Admit Card");
                        intent3.putExtra("cat_type", "3");
                        intent3.putExtra("course_id", this.courseDetail.getData().getCourseDetail().getId());
                        intent3.putExtra("save", false);
                        intent3.putExtra("download_file", false);
                        intent3.putExtra(Const.IS_DOWNLOAD, true);
                        intent3.putExtra("backPressed", "1");
                        intent3.setFlags(67141632);
                        Helper.gotoActivity(intent3, this);
                        finishAffinity();
                    } else {
                        Intent intent4 = new Intent(this, (Class<?>) DashboardActivityTheme1.class);
                        intent4.setFlags(67141632);
                        Helper.gotoActivity_finish(intent4, this);
                    }
                    break;
                case 14:
                    if (jsonobject.optBoolean("status")) {
                        if (this.isWantToUpdate) {
                            this.isFirstTime = true;
                            this.haveAddress = true;
                            hitApiForGettingAddress();
                        } else {
                            getAddressDetail(new AddressMaster(this.addressJson, jsonobject.optJSONObject("data").getString("address_id"), "0", false));
                        }
                    }
                    break;
                case 15:
                    if (jsonobject.optString("status").equals("true")) {
                        if (this.isfailure) {
                            pushEventForPaymentFailed(jsonobject.has("message") ? jsonobject.getString("message") : "NA");
                            this.isfailure = false;
                            this.pos_txn_id = "";
                        } else if (this.pos_txn_id.equalsIgnoreCase("")) {
                            pushEventForPaymentInitialize();
                            JSONObject jSONObject3 = jsonobject.getJSONObject("data");
                            getProductData(jSONObject3.getString(Const.COURSE_INIT_PAYMENT_TOKEN), this.paymentViewModel.getPayVia(), "Purchase");
                            if (this.paymentViewModel.getPayVia().equalsIgnoreCase("3")) {
                                paymentGateways(jSONObject3, Credentials.RZP);
                            } else if (this.paymentViewModel.getPayVia().equalsIgnoreCase("6")) {
                                paymentGateways(jSONObject3, Credentials.PAYTM);
                            } else if (this.paymentViewModel.getPayVia().equalsIgnoreCase("7")) {
                                paymentGateways(jSONObject3, Credentials.CCAV);
                            } else if (this.paymentViewModel.getPayVia().equalsIgnoreCase("8")) {
                                paymentGateways(jSONObject3, Credentials.FONEPAY);
                            } else if (this.paymentViewModel.getPayVia().equalsIgnoreCase("9")) {
                                paymentGateways(jSONObject3, Credentials.EASEBUZZ);
                            } else if (this.paymentViewModel.getPayVia().equalsIgnoreCase("11")) {
                                paymentGateways(jSONObject3, Credentials.BILLDESK);
                            } else if (this.paymentViewModel.getPayVia().equalsIgnoreCase("13")) {
                                paymentGateways(jSONObject3, Credentials.EASYPAY);
                            } else if (this.paymentViewModel.getPayVia().equalsIgnoreCase("14") || this.paymentViewModel.getPayVia().equalsIgnoreCase("15") || this.paymentViewModel.getPayVia().equalsIgnoreCase("21") || this.paymentViewModel.getPayVia().equalsIgnoreCase("22") || this.paymentViewModel.getPayVia().equalsIgnoreCase("23") || this.paymentViewModel.getPayVia().equalsIgnoreCase("24") || this.paymentViewModel.getPayVia().equalsIgnoreCase("18")) {
                                manageQRPayment(jSONObject3);
                            }
                        } else {
                            getProductData(this.pre_txtid, this.paymentViewModel.getPayVia(), "Purchase_Completed");
                            getProductData(this.pre_txtid, this.paymentViewModel.getPayVia(), "CourseDetails");
                            pushEventForPaymentSuccess();
                            FacebookEventLogger.logPurchased(this.activity);
                            if (!SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                                UtkashRoom.getAppDatabase(MakeMyExam.getAppContext()).getCourseDetaildata().deletecoursedetail(SingleStudy.parentCourseId, MakeMyExam.userId);
                            } else if (!this.courseDetail.getData().getCourseDetail().getId().equalsIgnoreCase("")) {
                                UtkashRoom.getAppDatabase(MakeMyExam.getAppContext()).getCourseDetaildata().deletecoursedetail(this.courseDetail.getData().getCourseDetail().getId(), MakeMyExam.userId);
                            }
                            UtkashRoom.getAppDatabase(MakeMyExam.getAppContext()).getHomeApiStatusdata().deletedata();
                            this.networkCall.NetworkAPICall(API.COURSE_CART_COUNT, "", true, false);
                            logBuySuccessEvent(this, this.courseDetail.getData().getCourseDetail().getTitle());
                            if (Helper.isNewLoginFlow()) {
                                showUpdateStatePopup();
                            } else {
                                success_dailog();
                            }
                            Toast.makeText(this, "" + jsonobject.optString("message"), 0).show();
                        }
                    } else {
                        if (this.isfailure) {
                            pushEventForPaymentFailed(jsonobject.has("message") ? jsonobject.getString("message") : "NA");
                            this.isfailure = false;
                            this.pos_txn_id = "";
                        }
                        Toast.makeText(this.activity, jsonobject.optString("message"), 0).show();
                        RetrofitResponse.GetApiData(this, jsonobject.has("auth_code") ? jsonobject.getString("auth_code") : "", jsonobject.getString("message"), false);
                    }
                    break;
            }
        } catch (Exception unused) {
        }
    }

    private void checkExternalCoupon() {
        CourseDetail courseDetail = this.courseDetail;
        if (courseDetail != null && courseDetail.getData() != null && this.courseDetail.getData().getCourseDetail() != null && this.courseDetail.getData().getCourseDetail().getExternal_coupon_off() != null && !TextUtils.isEmpty(this.courseDetail.getData().getCourseDetail().getExternal_coupon_off()) && this.courseDetail.getData().getCourseDetail().getExternal_coupon_off().equalsIgnoreCase("1")) {
            this.book_coupon_applied.setVisibility(this.hideExternalForEMI ? 8 : 0);
        } else {
            this.book_coupon_applied.setVisibility(8);
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
            String stringPreference = PreferencesUtil.INSTANCE.getStringPreference(this.activity, Credentials.RZP);
            String stringPreference2 = PreferencesUtil.INSTANCE.getStringPreference(this.activity, Credentials.PAYTM);
            String stringPreference3 = PreferencesUtil.INSTANCE.getStringPreference(this.activity, Credentials.CCAV);
            String stringPreference4 = PreferencesUtil.INSTANCE.getStringPreference(this.activity, Credentials.FONEPAY);
            String stringPreference5 = PreferencesUtil.INSTANCE.getStringPreference(this.activity, Credentials.EASEBUZZ);
            String stringPreference6 = PreferencesUtil.INSTANCE.getStringPreference(this.activity, Credentials.BILLDESK);
            String stringPreference7 = PreferencesUtil.INSTANCE.getStringPreference(this.activity, Credentials.EASYPAY);
            if (mode.equals(Credentials.RZP)) {
                if (stringPreference == null || stringPreference.isEmpty() || (rzp = (Rzp) new Gson().fromJson(stringPreference, Rzp.class)) == null || rzp.getStatus() == null || !rzp.getStatus().equalsIgnoreCase("1")) {
                    return;
                }
                this.paymentViewModel.launchRazorPayPaymentGateway(data, this.withCouponLayout.isShown(), this.pre_txtid, calculateAmount(), this.coursesCoupon, this.courseDetail, rzp.getKey());
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

    private void loadDataAsPerSubscriptions() {
        CourseDetail courseDetail = this.courseDetail;
        if (courseDetail != null && courseDetail.getData().getSubscriptionAllData() != null) {
            if (this.courseDetail.getData().getSubscriptionAllData().getPaymentMode() == null || !this.courseDetail.getData().getSubscriptionAllData().getPaymentMode().equalsIgnoreCase("3")) {
                return;
            }
            this.paymentModeValue = "3";
            this.planId = this.courseDetail.getData().getSubscriptionAllData().getPlanId();
            setSubscriptionData();
            return;
        }
        loadDataAsPerEmiOrNot();
    }

    private void loadDataAsPerCouponEmi(boolean isAfterCouponApply) {
        if (isAfterCouponApply) {
            setWithCouponData();
            return;
        }
        ArrayList<CoursesCoupon> arrayList = this.coursesCouponArrayList;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (this.coursesCouponArrayList.size() > 1 && this.coursesCouponArrayList.get(0).getCoupon().getTarget_type().equalsIgnoreCase("2")) {
                setWithoutCouponData();
                return;
            } else if (!this.coursesCouponArrayList.isEmpty() && this.coursesCouponArrayList.get(0).getCoupon().getTarget_type().equalsIgnoreCase("1")) {
                setWithoutCouponData();
                return;
            } else {
                setWithCouponData();
                return;
            }
        }
        setWithoutCouponData();
    }

    private void setWithCouponData() {
        String str;
        this.withCouponLayout.setVisibility(0);
        this.dummycoupon_layout.setVisibility(8);
        this.withoutCouponLayout.setVisibility(8);
        CoursesCoupon coursesCoupon = (CoursesCoupon) ((ArrayList) Objects.requireNonNull(this.coursesCouponArrayList)).get(0);
        this.coursesCoupon = coursesCoupon;
        if (coursesCoupon != null && coursesCoupon.getInstallment() != null && !this.coursesCoupon.getInstallment().isEmpty()) {
            this.courseDetail.getData().getInstalment().setInstallment(this.coursesCoupon.getInstallment());
        }
        if (((CoursesCoupon) Objects.requireNonNull(this.coursesCoupon)).getCoupon().getCoupon_type().equalsIgnoreCase("1")) {
            if (SharedPreference.getInstance().getString(Const.SHOW_SCHOLARSHIP_APPLIED).equalsIgnoreCase("1")) {
                this.coupon_code_applied.setText(this.coursesCoupon.getCoupon().getCoupon_title().toUpperCase() + " Applied");
            } else {
                this.coupon_applied_extra.setText(getResources().getString(R.string.coupon_applied_extra_) + this.secondCouponCode + ")");
                this.coupon_code_applied.setText(this.coursesCoupon.getCoupon().getCoupon_title().toUpperCase() + " Applied");
            }
        } else if (SharedPreference.getInstance().getString(Const.SHOW_SCHOLARSHIP_APPLIED).equalsIgnoreCase("1")) {
            this.coupon_code_applied.setText(this.coursesCoupon.getCoupon().getCoupon_title().toUpperCase() + " Applied");
        } else {
            this.coupon_applied_extra.setText(getResources().getString(R.string.coupon_applied_extra_) + this.secondCouponCode + ")");
            this.coupon_code_applied.setText(this.coursesCoupon.getCoupon().getCoupon_title().toUpperCase() + " Applied");
        }
        if (this.coursesCoupon.getValidity().contains(":")) {
            str = "Valid till: " + this.coursesCoupon.getValidity().split(":")[1];
        } else {
            str = this.activity.getResources().getString(R.string.validity_) + this.coursesCoupon.getValidity();
        }
        this.validityTV.setText(str);
        this.tax_value1.setText("You are saving ₹ " + String.format("%.2f", Float.valueOf(Float.parseFloat(this.coursesCoupon.getDiscount()))));
        this.txtAmountValue.setText("- ₹ " + String.format("%.2f", Float.valueOf(Float.parseFloat(this.coursesCoupon.getDiscount()))));
        if (this.isBook.equals("1") && !TextUtils.isEmpty(this.coursesCoupon.getMrp())) {
            this.noOfQuantityInCaseCoupon.setText(String.valueOf(this.quantityOfBooks));
            this.totalPriceValue1.setText("₹ " + String.format("%.2f", Float.valueOf(Float.parseFloat(this.coursesCoupon.getMrp()))));
        } else {
            this.totalPriceValue1.setText("₹ " + String.format("%.2f", Float.valueOf(Float.parseFloat(this.courseDetail.getData().getCourseDetail().getMrp()))));
        }
        if (this.coursesCoupon.getExternal_coupon_off() != null && !TextUtils.isEmpty(this.coursesCoupon.getExternal_coupon_off()) && !this.coursesCoupon.getExternal_coupon_off().equalsIgnoreCase("0") && !this.coursesCoupon.getExternal_coupon_off().equalsIgnoreCase(IdManager.DEFAULT_VERSION_NAME) && !this.coursesCoupon.getExternal_coupon_off().equalsIgnoreCase("0.00")) {
            handleExternalData(this.coursesCoupon.getExternal_coupon_remark() != null ? this.coursesCoupon.getExternal_coupon_remark() : "");
            this.tax_value2.setText("- ₹ " + String.format("%.2f", Float.valueOf(Float.parseFloat(this.coursesCoupon.getExternal_coupon_off()))));
            if (this.isEmiSelected) {
                calculateInstallmentPrice(this.emiTypePos);
            } else {
                float f2 = Float.parseFloat(this.coursesCoupon.getMrp());
                float f3 = Float.parseFloat(this.coursesCoupon.getTax());
                float f4 = Float.parseFloat(this.coursesCoupon.getDiscount());
                float f5 = f3 + f2 + f4;
                float f6 = f2 + f4;
                if (this.is_gst.equalsIgnoreCase("0")) {
                    this.priceTxtCourse.setText("₹ " + String.format("%.2f", Float.valueOf(f5)));
                } else {
                    this.priceTxtCourse.setText("₹ " + String.format("%.2f", Float.valueOf(f6)));
                }
                if (Float.parseFloat(this.coursesCoupon.getDiscount()) >= f5) {
                    this.txtPricesValue1.setText("₹ 0.00");
                    this.txtTaxValue1.setText("₹ 0.00");
                    this.cgstValueCoupon.setText("₹ 0.00");
                    this.sgstValueCoupon.setText("₹ 0.00");
                    this.txtGrandTotalValue1.setText("₹ 0.00");
                } else {
                    this.txtTaxValue1.setText("+ ₹ " + String.format("%.2f", Float.valueOf(Float.parseFloat(this.coursesCoupon.getTax()))));
                    this.cgstValueCoupon.setText("+ ₹ " + String.format("%.2f", Float.valueOf(Float.parseFloat(this.coursesCoupon.getTax()) / 2.0f)));
                    this.sgstValueCoupon.setText("+ ₹ " + String.format("%.2f", Float.valueOf(Float.parseFloat(this.coursesCoupon.getTax()) / 2.0f)));
                    this.txtPricesValue1.setText("₹ " + String.format("%.2f", Float.valueOf(Float.parseFloat(this.coursesCoupon.getMrp()))));
                    if (this.isBook.equals("1") && this.courseDetail.getData().getCourseDetail().getDelivery_charge() != null) {
                        this.txtGrandTotalValue1.setText("₹ " + String.format("%.2f", Float.valueOf(Float.parseFloat(this.coursesCoupon.getFinal_mrp()) + Float.parseFloat(this.courseDetail.getData().getCourseDetail().getDelivery_charge()))));
                    } else {
                        this.txtGrandTotalValue1.setText("₹ " + String.format("%.2f", Float.valueOf(Float.parseFloat(this.coursesCoupon.getFinal_mrp()))));
                    }
                }
            }
        } else {
            this.extraCouponLayout.setVisibility(8);
            this.total_amount_layout1.setVisibility(0);
            if (this.isEmiSelected) {
                calculateInstallmentPrice(this.emiTypePos);
            } else {
                float f7 = Float.parseFloat(this.coursesCoupon.getMrp());
                float f8 = Float.parseFloat(this.coursesCoupon.getTax());
                float f9 = Float.parseFloat(this.coursesCoupon.getDiscount());
                float f10 = f8 + f7 + f9;
                float f11 = f7 + f9;
                if (this.is_gst.equalsIgnoreCase("0")) {
                    this.priceTxtCourse.setText("₹ " + String.format("%.2f", Float.valueOf(f10)));
                } else {
                    this.priceTxtCourse.setText("₹ " + String.format("%.2f", Float.valueOf(f11)));
                }
                if (Float.parseFloat(this.coursesCoupon.getDiscount()) >= f10) {
                    this.txtPricesValue1.setText("₹ 0.00");
                    this.txtTaxValue1.setText("₹ 0.00");
                    this.cgstValueCoupon.setText("₹ 0.00");
                    this.sgstValueCoupon.setText("₹ 0.00");
                    this.txtGrandTotalValue1.setText("₹ 0.00");
                    this.taxLayout.setVisibility(8);
                    this.taxes_layout.setVisibility(8);
                    this.sgstLayout.setVisibility(8);
                    this.sgstLayoutCoupon.setVisibility(8);
                    this.cgstLayout.setVisibility(8);
                    this.cgstLayoutCoupon.setVisibility(8);
                } else {
                    this.txtTaxValue1.setText("+ ₹ " + String.format("%.2f", Float.valueOf(Float.parseFloat(this.coursesCoupon.getTax()))));
                    this.cgstValueCoupon.setText("+ ₹ " + String.format("%.2f", Float.valueOf(Float.parseFloat(this.coursesCoupon.getTax()) / 2.0f)));
                    this.sgstValueCoupon.setText("+ ₹ " + String.format("%.2f", Float.valueOf(Float.parseFloat(this.coursesCoupon.getTax()) / 2.0f)));
                    this.txtPricesValue1.setText("₹ " + String.format("%.2f", Float.valueOf(Float.parseFloat(this.coursesCoupon.getMrp()))));
                    if (this.isBook.equals("1") && this.courseDetail.getData().getCourseDetail().getDelivery_charge() != null) {
                        this.txtGrandTotalValue1.setText("₹ " + String.format("%.2f", Float.valueOf(Float.parseFloat(this.coursesCoupon.getFinal_mrp()) + Float.parseFloat(this.courseDetail.getData().getCourseDetail().getDelivery_charge()))));
                    } else {
                        this.txtGrandTotalValue1.setText("₹ " + String.format("%.2f", Float.valueOf(Float.parseFloat(this.coursesCoupon.getFinal_mrp()))));
                    }
                }
            }
        }
        if (this.coursesCoupon.getTax() != null && !TextUtils.isEmpty(this.coursesCoupon.getTax()) && Float.parseFloat(this.coursesCoupon.getTax()) > 0.0f) {
            if (this.gstShow.booleanValue()) {
                this.taxLayout.setVisibility(8);
                this.taxes_layout.setVisibility(8);
                this.sgstLayout.setVisibility(0);
                this.sgstLayoutCoupon.setVisibility(0);
                this.cgstLayout.setVisibility(0);
                this.cgstLayoutCoupon.setVisibility(0);
            } else {
                this.taxLayout.setVisibility(0);
                this.taxes_layout.setVisibility(0);
                this.sgstLayout.setVisibility(8);
                this.sgstLayoutCoupon.setVisibility(8);
                this.cgstLayout.setVisibility(8);
                this.cgstLayoutCoupon.setVisibility(8);
            }
        } else {
            this.taxLayout.setVisibility(8);
            this.taxes_layout.setVisibility(8);
            this.sgstLayout.setVisibility(8);
            this.sgstLayoutCoupon.setVisibility(8);
            this.cgstLayout.setVisibility(8);
            this.cgstLayoutCoupon.setVisibility(8);
        }
        if (((int) Float.parseFloat(this.coursesCoupon.getFinal_mrp())) <= 0) {
            this.procceed.setText(getResources().getString(R.string.open_in_my_lib));
        } else {
            this.procceed.setText(getResources().getString(R.string.proceed));
        }
        manageQRButton();
    }

    private void setWithoutCouponData() {
        String str;
        this.withCouponLayout.setVisibility(8);
        this.withoutCouponLayout.setVisibility(0);
        this.dummycoupon_layout.setVisibility(this.isCouponGiven ? 0 : 8);
        if (this.courseDetail.getData().getCourseDetail().getValidity().contains(":")) {
            str = "Valid till: " + this.courseDetail.getData().getCourseDetail().getValidity().split(":")[1];
        } else {
            str = this.activity.getResources().getString(R.string.validity_) + this.courseDetail.getData().getCourseDetail().getValidity();
        }
        this.validityTV.setText(str);
        priceUpdate(Float.parseFloat(this.courseDetail.getData().getCourseDetail().getMrp()) + Float.parseFloat(this.courseDetail.getData().getCourseDetail().getTax()));
    }

    private void percentage_calculate(String coupondis) {
        CourseDetail courseDetail = this.courseDetail;
        if (courseDetail == null || courseDetail.getData() == null) {
            return;
        }
        if (Integer.parseInt(coupondis) >= 100) {
            this.procceed.setText(getResources().getString(R.string.open_in_my_lib));
            this.price = "0";
            this.tax = "0";
            this.tax_value.setText(getResources().getString(R.string.free_));
            this.cgstValue.setText(getResources().getString(R.string.free_));
            this.sgstValue.setText(getResources().getString(R.string.free_));
            this.txtGrandTotalValue.setText(getResources().getString(R.string.free_));
            this.totalPriceValue.setText(getResources().getString(R.string.free_));
            if (TextUtils.isEmpty(this.tax) || this.tax.equalsIgnoreCase("0") || this.tax.equalsIgnoreCase(IdManager.DEFAULT_VERSION_NAME)) {
                this.taxLayout.setVisibility(8);
                this.taxes_layout.setVisibility(8);
                this.sgstLayout.setVisibility(8);
                this.sgstLayoutCoupon.setVisibility(8);
                this.cgstLayout.setVisibility(8);
                this.cgstLayoutCoupon.setVisibility(8);
            } else if (this.gstShow.booleanValue()) {
                this.taxLayout.setVisibility(8);
                this.taxes_layout.setVisibility(8);
                this.sgstLayout.setVisibility(0);
                this.sgstLayoutCoupon.setVisibility(0);
                this.cgstLayout.setVisibility(0);
                this.cgstLayoutCoupon.setVisibility(0);
            } else {
                this.taxLayout.setVisibility(0);
                this.taxes_layout.setVisibility(0);
                this.sgstLayout.setVisibility(8);
                this.sgstLayoutCoupon.setVisibility(8);
                this.cgstLayout.setVisibility(8);
                this.cgstLayoutCoupon.setVisibility(8);
            }
        } else {
            this.procceed.setText(getResources().getString(R.string.proceed));
            float f2 = Float.parseFloat(this.courseDetail.getData().getCourseDetail().getMrp()) + Float.parseFloat(this.courseDetail.getData().getCourseDetail().getTax());
            float f3 = f2 - Float.parseFloat(String.valueOf((Double.parseDouble(String.valueOf(f2)) / 100.0d) * ((double) Integer.parseInt(coupondis))));
            double d2 = Double.parseDouble(new DecimalFormat("##.#").format(0.18f * f3));
            this.tax = String.valueOf(d2);
            this.price = String.valueOf(((double) f3) - d2);
            this.totalPriceValue.setText(Constants.currencyType + " " + String.format("%.2f", Float.valueOf(Float.parseFloat(this.courseDetail.getData().getCourseDetail().getMrp()))));
            this.tax_value.setText(Constants.currencyType + " " + String.format("%.2f", Float.valueOf(Float.parseFloat(this.tax))));
            double d3 = d2 / 2.0d;
            this.sgstValue.setText(Constants.currencyType + " " + String.format("%.2f", Double.valueOf(d3)));
            this.cgstValue.setText(Constants.currencyType + " " + String.format("%.2f", Double.valueOf(d3)));
            this.txtGrandTotalValue.setText(Constants.currencyType + " " + String.format("%.2f", Float.valueOf(f3)));
            if (TextUtils.isEmpty(this.tax) || this.tax.equalsIgnoreCase("0") || this.tax.equalsIgnoreCase(IdManager.DEFAULT_VERSION_NAME)) {
                this.taxLayout.setVisibility(8);
                this.taxes_layout.setVisibility(8);
                this.sgstLayout.setVisibility(8);
                this.sgstLayoutCoupon.setVisibility(8);
                this.cgstLayout.setVisibility(8);
                this.cgstLayoutCoupon.setVisibility(8);
            } else if (this.gstShow.booleanValue()) {
                this.taxLayout.setVisibility(8);
                this.taxes_layout.setVisibility(8);
                this.sgstLayout.setVisibility(0);
                this.sgstLayoutCoupon.setVisibility(0);
                this.cgstLayout.setVisibility(0);
                this.cgstLayoutCoupon.setVisibility(0);
            } else {
                this.taxLayout.setVisibility(0);
                this.taxes_layout.setVisibility(0);
                this.sgstLayout.setVisibility(8);
                this.sgstLayoutCoupon.setVisibility(8);
                this.cgstLayout.setVisibility(8);
                this.cgstLayoutCoupon.setVisibility(8);
            }
        }
        manageQRButton();
    }

    private void flat_percentage(String coupon_amount, String couponCode) {
        CourseDetail courseDetail = this.courseDetail;
        if (courseDetail != null && courseDetail.getData() != null) {
            this.procceed.setText(getResources().getString(R.string.proceed));
            float f2 = Float.parseFloat(this.courseDetail.getData().getCourseDetail().getMrp()) + Float.parseFloat(this.courseDetail.getData().getCourseDetail().getTax());
            if (Integer.parseInt(coupon_amount) >= f2) {
                this.price = "0";
                this.tax = "0";
                this.procceed.setText(getResources().getString(R.string.open_in_my_lib));
                this.tax_value.setText(getResources().getString(R.string.free_));
                this.cgstValue.setText(getResources().getString(R.string.free_));
                this.sgstValue.setText(getResources().getString(R.string.free_));
                this.txtGrandTotalValue.setText(getResources().getString(R.string.free_));
                this.totalPriceValue.setText(getResources().getString(R.string.free_));
                if (TextUtils.isEmpty(this.tax) || this.tax.equalsIgnoreCase("0") || this.tax.equalsIgnoreCase(IdManager.DEFAULT_VERSION_NAME)) {
                    this.taxLayout.setVisibility(8);
                    this.taxes_layout.setVisibility(8);
                    this.sgstLayout.setVisibility(8);
                    this.sgstLayoutCoupon.setVisibility(8);
                    this.cgstLayout.setVisibility(8);
                    this.cgstLayoutCoupon.setVisibility(8);
                } else if (this.gstShow.booleanValue()) {
                    this.taxLayout.setVisibility(8);
                    this.taxes_layout.setVisibility(8);
                    this.sgstLayout.setVisibility(0);
                    this.sgstLayoutCoupon.setVisibility(0);
                    this.cgstLayout.setVisibility(0);
                    this.cgstLayoutCoupon.setVisibility(0);
                } else {
                    this.taxLayout.setVisibility(0);
                    this.taxes_layout.setVisibility(0);
                    this.sgstLayout.setVisibility(8);
                    this.sgstLayoutCoupon.setVisibility(8);
                    this.cgstLayout.setVisibility(8);
                    this.cgstLayoutCoupon.setVisibility(8);
                }
            } else if (f2 > Integer.parseInt(coupon_amount)) {
                float f3 = f2 - Float.parseFloat(coupon_amount);
                double d2 = Double.parseDouble(new DecimalFormat("##.#").format(0.18f * f3));
                this.tax = String.valueOf(d2);
                this.price = String.valueOf(((double) f3) - d2);
                this.totalPriceValue.setText(Constants.currencyType + " " + String.format("%.2f", Float.valueOf(Float.parseFloat(this.courseDetail.getData().getCourseDetail().getMrp()))));
                this.tax_value.setText(Constants.currencyType + " " + String.format("%.2f", Double.valueOf(d2)));
                double d3 = d2 / 2.0d;
                this.sgstValue.setText(Constants.currencyType + " " + String.format("%.2f", Double.valueOf(d3)));
                this.cgstValue.setText(Constants.currencyType + " " + String.format("%.2f", Double.valueOf(d3)));
                this.txtGrandTotalValue.setText(Constants.currencyType + " " + String.format("%.2f", Float.valueOf(f3)));
                if (TextUtils.isEmpty(this.tax) || this.tax.equalsIgnoreCase("0") || this.tax.equalsIgnoreCase(IdManager.DEFAULT_VERSION_NAME)) {
                    this.taxLayout.setVisibility(8);
                    this.taxes_layout.setVisibility(8);
                    this.sgstLayout.setVisibility(8);
                    this.sgstLayoutCoupon.setVisibility(8);
                    this.cgstLayout.setVisibility(8);
                    this.cgstLayoutCoupon.setVisibility(8);
                } else if (this.gstShow.booleanValue()) {
                    this.taxLayout.setVisibility(8);
                    this.taxes_layout.setVisibility(8);
                    this.sgstLayout.setVisibility(0);
                    this.sgstLayoutCoupon.setVisibility(0);
                    this.cgstLayout.setVisibility(0);
                    this.cgstLayoutCoupon.setVisibility(0);
                } else {
                    this.taxLayout.setVisibility(0);
                    this.taxes_layout.setVisibility(0);
                    this.sgstLayout.setVisibility(8);
                    this.sgstLayoutCoupon.setVisibility(8);
                    this.cgstLayout.setVisibility(8);
                    this.cgstLayoutCoupon.setVisibility(8);
                }
            }
        }
        manageQRButton();
    }

    private int calculateAmount() {
        float f2;
        float f3;
        float f4;
        if (this.withCouponLayout.isShown()) {
            if (this.isEmiSelected) {
                f4 = Float.parseFloat(this.emiPriceToSend) + Float.parseFloat(this.finalTaxValue);
            } else {
                f4 = Float.parseFloat(this.coursesCoupon.getFinal_mrp());
            }
            if (this.isBook.equals("1")) {
                f4 += Float.parseFloat(this.deliveryCharge);
            }
            return Math.round(f4);
        }
        if (this.isEmiSelected) {
            f2 = Float.parseFloat(this.emiPriceToSend);
            f3 = Float.parseFloat(this.finalTaxValue);
        } else {
            f2 = Float.parseFloat(this.price);
            f3 = Float.parseFloat(this.tax);
        }
        float f5 = f2 + f3;
        if (this.isBook.equals("1")) {
            f5 += Float.parseFloat(this.deliveryCharge);
        }
        return Math.round(f5);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        Toast.makeText(this, "" + jsonstring, 0).show();
    }

    @Override // com.razorpay.PaymentResultListener
    public void onPaymentSuccess(String s) {
        this.pos_txn_id = s;
        this.networkCall.NetworkAPICall(API.int_payment, "", true, false);
    }

    @Override // com.razorpay.PaymentResultListener
    public void onPaymentError(int i, String s) {
        OnPaymentError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OnPaymentError() {
        try {
            this.isfailure = true;
            this.networkCall.NetworkAPICall(API.int_payment, "", true, false);
            if (BuildConfig.FLAVOR.equalsIgnoreCase("mahendra")) {
                this.networkCall.NetworkAPICall(API.COURSE_ADD_TO_CART, "", false, false);
            }
        } catch (Exception unused) {
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
            dialog.setContentView(R.layout.success_dialog);
            dialog.getWindow().setSoftInputMode(16);
            getWindow().setSoftInputMode(3);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.getWindow().setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.9d), -2);
            dialog.getWindow().setGravity(17);
            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);
            TextInputLayout textInputLayout = (TextInputLayout) dialog.findViewById(R.id.cvrBookName);
            TextInputLayout textInputLayout2 = (TextInputLayout) dialog.findViewById(R.id.cvrCourseName);
            EditText editText = (EditText) dialog.findViewById(R.id.et_order_id);
            EditText editText2 = (EditText) dialog.findViewById(R.id.et_transaction_id);
            TextView textView = (TextView) dialog.findViewById(R.id.course_name);
            TextView textView2 = (TextView) dialog.findViewById(R.id.book_name);
            LinearLayout linearLayout = (LinearLayout) dialog.findViewById(R.id.transactionLL);
            LinearLayout linearLayout2 = (LinearLayout) dialog.findViewById(R.id.admitCardLL);
            editText.setText(this.pre_txtid);
            editText2.setText(this.pos_txn_id);
            textView.setText(this.courseDetail.getData().getCourseDetail().getTitle());
            textView2.setText(this.courseDetail.getData().getCourseDetail().getTitle());
            Button button = (Button) dialog.findViewById(R.id.btn_my_course);
            final String stringExtra = getIntent().hasExtra("test_mode") ? getIntent().getStringExtra("test_mode") : "";
            if (this.isBook.equals("1")) {
                button.setText(getResources().getString(R.string.go_to_home_page));
                textInputLayout2.setVisibility(8);
                textInputLayout.setVisibility(0);
            } else if (this.isBook.equalsIgnoreCase("3")) {
                textInputLayout2.setVisibility(0);
                textInputLayout.setVisibility(8);
                linearLayout.setVisibility(8);
                linearLayout2.setVisibility(0);
                if (stringExtra.equalsIgnoreCase("1")) {
                    button.setText(getResources().getString(R.string.go_to_purchase_list));
                } else {
                    button.setText(getResources().getString(R.string.go_to_home_page));
                }
            } else {
                button.setText(getResources().getString(R.string.go_to_course));
                textInputLayout2.setVisibility(0);
                textInputLayout.setVisibility(8);
            }
            try {
                if (CourseActivity.getInstance() != null) {
                    CourseActivity.getInstance().finish();
                }
            } catch (Exception unused) {
            }
            button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda44
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$success_dailog$43(stringExtra, view);
                }
            });
            dialog.show();
            dialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.appnew.android.Payment.PurchaseActivity.13
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    dialog.dismiss();
                    dialog.cancel();
                }
            });
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$success_dailog$43(String str, View view) {
        boolean z;
        Intent intent;
        if (!Helper.isConnected(this)) {
            Helper.showInternetToast(this);
            return;
        }
        if (this.isBook.equalsIgnoreCase("3")) {
            if (str.equalsIgnoreCase("1")) {
                callServiceForInvoice();
                return;
            } else {
                Helper.gotoActivity(new Intent(this, (Class<?>) DashboardActivityTheme1.class), this);
                finishAffinity();
                return;
            }
        }
        if (this.isBook.equals("1")) {
            if ("1".equalsIgnoreCase("7")) {
                intent = new Intent(this, (Class<?>) DashboardActivityTheme8.class);
            } else if ("1".equalsIgnoreCase("2")) {
                intent = new Intent(this, (Class<?>) DashboardActivityTheme2.class);
            } else if ("1".equalsIgnoreCase("6")) {
                intent = new Intent(this, (Class<?>) DashboardActivityTheme7.class);
            } else {
                intent = new Intent(this, (Class<?>) DashboardActivityTheme1.class);
            }
            intent.setFlags(67141632);
            Helper.gotoActivity(intent, this);
            return;
        }
        CourseDetail courseDetail = this.courseDetail;
        if (courseDetail == null || courseDetail.getData() == null || this.courseDetail.getData().getTiles() == null) {
            z = false;
        } else {
            Iterator<TilesItem> it = this.courseDetail.getData().getTiles().iterator();
            z = false;
            while (it.hasNext()) {
                if (it.next().getType().equalsIgnoreCase(Const.COMBO)) {
                    z = true;
                }
            }
        }
        Intent intent2 = new Intent(this, (Class<?>) CourseActivity.class);
        intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
        intent2.putExtra(Const.COURSE_ID_MAIN, !SingleStudy.parentCourseId.equalsIgnoreCase("") ? SingleStudy.parentCourseId : this.courseDetail.getData().getCourseDetail().getId());
        intent2.putExtra(Const.COURSE_PARENT_ID, "");
        intent2.putExtra(Const.IS_COMBO, false);
        if (!z) {
            intent2.putExtra(Const.COMBO_ID, "");
        }
        intent2.putExtra(AnalyticsConstants.course_name, this.courseDetail.getData().getCourseDetail().getTitle());
        intent2.setFlags(67108864);
        Helper.gotoActivity_finish(intent2, this);
    }

    private void callServiceForInvoice() {
        this.networkCall.NetworkAPICall(API.GET_ADMIT_CARD_URL, "", true, false);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        Helper.enableScreenShot(this);
        super.onDestroy();
    }

    public void logBuyNowFreeEvent(Context context, String bookTitle) {
        String loggedInUserInfo = Helper.getLoggedInUserInfo(context);
        Bundle bundle = new Bundle();
        if (loggedInUserInfo == null) {
            loggedInUserInfo = "unknown_user";
        }
        bundle.putString("user_info", loggedInUserInfo);
        bundle.putString("booktype", "free");
        if (bookTitle == null) {
            bookTitle = "unknown_book";
        }
        bundle.putString("bookname", bookTitle);
        FacebookEventLogger.logEvent(context, "BuyFreeBook", bundle);
    }

    public void logBuySuccessEvent(Context context, String bookTitle) {
        String loggedInUserInfo = Helper.getLoggedInUserInfo(context);
        Bundle bundle = new Bundle();
        if (loggedInUserInfo == null) {
            loggedInUserInfo = "unknown_user";
        }
        bundle.putString("user_info", loggedInUserInfo);
        bundle.putString("booktype", "paid");
        if (bookTitle == null) {
            bookTitle = "unknown_book";
        }
        bundle.putString("bookname", bookTitle);
        FacebookEventLogger.logEvent(context, "BuyPaidBook", bundle);
    }

    public void logBuyPreviewEvent(Context context, String bookTitle, String bookType) {
        String loggedInUserInfo = Helper.getLoggedInUserInfo(context);
        Bundle bundle = new Bundle();
        if (loggedInUserInfo == null) {
            loggedInUserInfo = "unknown_user";
        }
        bundle.putString("user_info", loggedInUserInfo);
        bundle.putString("booktype", bookType);
        if (bookTitle == null) {
            bookTitle = "unknown_book";
        }
        bundle.putString("bookname", bookTitle);
        FacebookEventLogger.logEvent(context, "BookPreview", bundle);
    }

    private void setRefundRelatedData() {
        this.termCondTV.setText(getResources().getString(R.string.before_making_payment_you_agree_to_our) + " \n" + getResources().getString(R.string.refund_policy));
        SpannableString spannableString = new SpannableString(this.termCondTV.getText().toString());
        spannableString.setSpan(new ClickableSpan() { // from class: com.appnew.android.Payment.PurchaseActivity.14
            @Override // android.text.style.ClickableSpan
            public void onClick(View textView) {
                Intent intent = new Intent(PurchaseActivity.this, (Class<?>) WebViewActivty.class);
                intent.putExtra("type", "Refund Policy");
                intent.putExtra("url", API.PRIVACY_POLICY_REFUND_URL);
                Helper.gotoActivity(intent, PurchaseActivity.this);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(true);
            }
        }, this.termCondTV.getText().toString().length() - 13, this.termCondTV.getText().toString().length(), 33);
        spannableString.setSpan(new UnderlineSpan(), this.termCondTV.getText().toString().length() - 13, this.termCondTV.getText().toString().length(), 0);
        spannableString.setSpan(new StyleSpan(1), this.termCondTV.getText().toString().length() - 13, this.termCondTV.getText().toString().length(), 0);
        this.termCondTV.setText(spannableString);
        this.termCondTV.setMovementMethod(LinkMovementMethod.getInstance());
        this.termCondTV.setHighlightColor(0);
    }

    private void setTermRelatedData() {
        this.termCondTV.setText(getResources().getString(R.string.before_making_payment_you_agree_to_our) + " \n" + getResources().getString(R.string.terms_amp_conditions));
        SpannableString spannableString = new SpannableString(this.termCondTV.getText().toString());
        spannableString.setSpan(new ClickableSpan() { // from class: com.appnew.android.Payment.PurchaseActivity.15
            @Override // android.text.style.ClickableSpan
            public void onClick(View textView) {
                Intent intent = new Intent(PurchaseActivity.this, (Class<?>) WebViewActivty.class);
                intent.putExtra("type", "Terms of Service");
                intent.putExtra("url", API.TERMS_AND_CONDITIONS);
                Helper.gotoActivity(intent, PurchaseActivity.this);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(true);
            }
        }, this.termCondTV.getText().toString().length() - 18, this.termCondTV.getText().toString().length(), 33);
        spannableString.setSpan(new UnderlineSpan(), this.termCondTV.getText().toString().length() - 18, this.termCondTV.getText().toString().length(), 0);
        spannableString.setSpan(new StyleSpan(1), this.termCondTV.getText().toString().length() - 18, this.termCondTV.getText().toString().length(), 0);
        this.termCondTV.setText(spannableString);
        this.termCondTV.setMovementMethod(LinkMovementMethod.getInstance());
        this.termCondTV.setHighlightColor(0);
    }

    @Override // com.appnew.android.Payment.IOnViewDetailsClick
    public void onViewDetailsClick(int position, String ttl, boolean isQRPay) {
        openAlertDialog(position, ttl);
    }

    @Override // com.appnew.android.Payment.ItemClickListener
    public void onClick(String s, int position) {
        this.emiRecyclerList.post(new Runnable() { // from class: com.appnew.android.Payment.PurchaseActivity.16
            @Override // java.lang.Runnable
            public void run() {
                PurchaseActivity.this.adapter.notifyDataSetChanged();
            }
        });
        this.emiTypePos = position;
        calculateInstallmentPrice(position);
    }

    private void openAlertDialog(int position, String ttl) {
        List<String> arrayList = new ArrayList<>();
        List<String> arrayList2 = new ArrayList<>();
        List<String> arrayList3 = new ArrayList<>();
        List<String> arrayList4 = new ArrayList<>();
        if (!GenericUtils.isListEmpty(this.courseDetail.getData().getInstalment().getInstallment()) && this.courseDetail.getData().getInstalment().getInstallment().get(position) != null && this.courseDetail.getData().getInstalment().getInstallment().get(position).getAmountDescription() != null && this.courseDetail.getData().getInstalment().getInstallment().get(position).getAmountDescription().getCycle() != null && !this.courseDetail.getData().getInstalment().getInstallment().get(position).getAmountDescription().getCycle().isEmpty()) {
            arrayList = ((AmountDescription) Objects.requireNonNull(this.courseDetail.getData().getInstalment().getInstallment().get(position).getAmountDescription())).getCycle();
        }
        if (!GenericUtils.isListEmpty(this.courseDetail.getData().getInstalment().getInstallment()) && this.courseDetail.getData().getInstalment().getInstallment().get(position) != null && this.courseDetail.getData().getInstalment().getInstallment().get(position).getAmountDescription() != null && this.courseDetail.getData().getInstalment().getInstallment().get(position).getAmountDescription().getPayment() != null && !this.courseDetail.getData().getInstalment().getInstallment().get(position).getAmountDescription().getPayment().isEmpty()) {
            arrayList2 = ((AmountDescription) Objects.requireNonNull(this.courseDetail.getData().getInstalment().getInstallment().get(position).getAmountDescription())).getPayment();
        }
        if (!GenericUtils.isListEmpty(this.courseDetail.getData().getInstalment().getInstallment()) && this.courseDetail.getData().getInstalment().getInstallment().get(position) != null && this.courseDetail.getData().getInstalment().getInstallment().get(position).getAmountDescription() != null && this.courseDetail.getData().getInstalment().getInstallment().get(position).getAmountDescription().getTax() != null && !this.courseDetail.getData().getInstalment().getInstallment().get(position).getAmountDescription().getTax().isEmpty()) {
            arrayList3 = ((AmountDescription) Objects.requireNonNull(this.courseDetail.getData().getInstalment().getInstallment().get(position).getAmountDescription())).getTax();
        }
        if (!GenericUtils.isListEmpty(this.courseDetail.getData().getInstalment().getInstallment()) && this.courseDetail.getData().getInstalment().getInstallment().get(position) != null && this.courseDetail.getData().getInstalment().getInstallment().get(position).getAmountDescription() != null && this.courseDetail.getData().getInstalment().getInstallment().get(position).getAmountDescription().getCycle_dates_ms() != null && !this.courseDetail.getData().getInstalment().getInstallment().get(position).getAmountDescription().getCycle_dates_ms().isEmpty()) {
            arrayList4 = ((AmountDescription) Objects.requireNonNull(this.courseDetail.getData().getInstalment().getInstallment().get(position).getAmountDescription())).getCycle_dates_ms();
        }
        CommonEmiPlanModel commonEmiPlanModel = new CommonEmiPlanModel(arrayList, arrayList2, arrayList3, arrayList4);
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this, R.style.videosheetDialogTheme);
        bottomSheetDialog.setContentView(R.layout.dialog_installment_broucher);
        ((Window) Objects.requireNonNull(bottomSheetDialog.getWindow())).getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        bottomSheetDialog.show();
        RecyclerView recyclerView = (RecyclerView) bottomSheetDialog.findViewById(R.id.installmentRecyclerView);
        ImageView imageView = (ImageView) bottomSheetDialog.findViewById(R.id.backBtn);
        ((TextView) bottomSheetDialog.findViewById(R.id.titleTxt)).setText(ttl);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bottomSheetDialog.cancel();
            }
        });
        if (recyclerView != null) {
            ((RecyclerView) Objects.requireNonNull(recyclerView)).setLayoutManager(new LinearLayoutManager(this));
            AdapterInstallmentDetails adapterInstallmentDetails = new AdapterInstallmentDetails(commonEmiPlanModel);
            recyclerView.setAdapter(adapterInstallmentDetails);
            adapterInstallmentDetails.notifyDataSetChanged();
        }
    }

    public void filterList(String searchType, StatesCities countryArrayList) {
        final Dialog dialog = new Dialog(this.activity);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
        dialog.setContentView(R.layout.state_city_dialog);
        dialog.setCancelable(true);
        this.etSearch = (EditText) dialog.findViewById(R.id.et_search);
        if (searchType.equalsIgnoreCase("1")) {
            this.etSearch.setHint(this.activity.getResources().getString(R.string.search_state));
        } else if (searchType.equalsIgnoreCase("2")) {
            this.etSearch.setHint(this.activity.getResources().getString(R.string.search_district));
        } else if (searchType.equalsIgnoreCase("3")) {
            this.etSearch.setHint(this.activity.getResources().getString(R.string.search_country));
        }
        this.ivClearSearch = (ImageView) dialog.findViewById(R.id.iv_clear_search);
        TextView textView = (TextView) dialog.findViewById(R.id.tv_cancel);
        this.ivClearSearch.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$filterList$45(view);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda35
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.cancel();
            }
        });
        RecyclerView recyclerView = (RecyclerView) dialog.findViewById(R.id.search_recyclerview);
        this.searchRecyclerview = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.searchRecyclerview.setLayoutManager(new LinearLayoutManager(this.activity));
        StateCityAdapter stateCityAdapter = new StateCityAdapter(this.activity, countryArrayList.getData(), searchType, dialog);
        this.stateCityAdapter = stateCityAdapter;
        this.searchRecyclerview.setAdapter(stateCityAdapter);
        textWatcher(searchType);
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$filterList$45(View view) {
        this.etSearch.setText("");
    }

    public void textWatcher(final String searchType) {
        this.etSearch.addTextChangedListener(new TextWatcher() { // from class: com.appnew.android.Payment.PurchaseActivity.17
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    PurchaseActivity.this.ivClearSearch.setVisibility(0);
                } else {
                    PurchaseActivity.this.ivClearSearch.setVisibility(8);
                }
                PurchaseActivity.this.filter(editable.toString(), searchType);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void filter(String text, String searchType) {
        this.statesCitiesArrayList.clear();
        if (searchType.equalsIgnoreCase("1")) {
            for (StatesCitiesData statesCitiesData : this.states.getData()) {
                if (statesCitiesData.getName().toLowerCase().contains(text.toLowerCase())) {
                    this.statesCitiesArrayList.add(statesCitiesData);
                }
            }
        } else if (searchType.equalsIgnoreCase("2")) {
            for (StatesCitiesData statesCitiesData2 : this.cities.getData()) {
                if (statesCitiesData2.getName().toLowerCase().contains(text.toLowerCase())) {
                    this.statesCitiesArrayList.add(statesCitiesData2);
                }
            }
        }
        if (!this.statesCitiesArrayList.isEmpty()) {
            this.searchRecyclerview.setVisibility(0);
            this.stateCityAdapter.filterCountryList(this.statesCitiesArrayList);
        } else {
            this.searchRecyclerview.setVisibility(4);
        }
    }

    @Override // com.appnew.android.Utils.PaymentTypeCheck
    public void onPaymentType(String mode, JSONObject data) {
        String stringPreference = PreferencesUtil.INSTANCE.getStringPreference(this.activity, Credentials.RZP);
        String stringPreference2 = PreferencesUtil.INSTANCE.getStringPreference(this.activity, Credentials.PAYTM);
        String stringPreference3 = PreferencesUtil.INSTANCE.getStringPreference(this.activity, Credentials.CCAV);
        String stringPreference4 = PreferencesUtil.INSTANCE.getStringPreference(this.activity, Credentials.FONEPAY);
        String stringPreference5 = PreferencesUtil.INSTANCE.getStringPreference(this.activity, Credentials.EASEBUZZ);
        String stringPreference6 = PreferencesUtil.INSTANCE.getStringPreference(this.activity, Credentials.BILLDESK);
        String stringPreference7 = PreferencesUtil.INSTANCE.getStringPreference(this.activity, Credentials.EASYPAY);
        if (mode.equals(Credentials.RZP)) {
            if (stringPreference != null && !stringPreference.isEmpty()) {
                this.paymentViewModel.setPayVia(this.isPayViaQR ? "14" : "3");
            }
        } else if (mode.equals(Credentials.PAYTM)) {
            if (stringPreference2 != null && !stringPreference2.isEmpty()) {
                this.paymentViewModel.setPayVia(this.isPayViaQR ? "21" : "6");
            }
        } else if (mode.equals(Credentials.CCAV)) {
            if (stringPreference3 != null && !stringPreference3.isEmpty()) {
                this.paymentViewModel.setPayVia(this.isPayViaQR ? "22" : "7");
            }
        } else if (mode.equals(Credentials.FONEPAY)) {
            if (stringPreference4 != null && !stringPreference4.isEmpty()) {
                this.paymentViewModel.setPayVia(this.isPayViaQR ? "23" : "8");
            }
        } else if (mode.equals(Credentials.EASEBUZZ)) {
            if (stringPreference5 != null && !stringPreference5.isEmpty()) {
                this.paymentViewModel.setPayVia(this.isPayViaQR ? "15" : "9");
            }
        } else if (mode.equals(Credentials.BILLDESK)) {
            if (stringPreference6 != null && !stringPreference6.isEmpty()) {
                this.paymentViewModel.setPayVia(this.isPayViaQR ? "24" : "11");
            }
        } else if (mode.equals(Credentials.EASYPAY) && stringPreference7 != null && !stringPreference7.isEmpty()) {
            this.paymentViewModel.setPayVia(this.isPayViaQR ? "18" : "13");
        }
        this.networkCall.NetworkAPICall(API.int_payment, "", true, false);
    }

    public class StateCityAdapter extends RecyclerView.Adapter<MyViewHolder> {
        Context context;
        List<StatesCitiesData> countryArrayList;
        Dialog searchDialog;
        String searchType;

        public StateCityAdapter(Context context, List<StatesCitiesData> countryArrayList, String searchType, Dialog searchDialog) {
            this.context = context;
            this.countryArrayList = countryArrayList;
            this.searchType = searchType;
            this.searchDialog = searchDialog;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new MyViewHolder(LayoutInflater.from(this.context).inflate(R.layout.state_city_dialog_adapter_item, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(MyViewHolder myViewHolder, final int i) {
            final StatesCitiesData statesCitiesData = this.countryArrayList.get(i);
            myViewHolder.tvName.setText(statesCitiesData.getName());
            myViewHolder.tvName.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$StateCityAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(statesCitiesData, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(StatesCitiesData statesCitiesData, View view) {
            Dialog dialog = this.searchDialog;
            if (dialog != null) {
                dialog.dismiss();
            }
            String str = this.searchType;
            str.hashCode();
            switch (str) {
                case "1":
                    PurchaseActivity.this.onStateCityClick(this.searchType, statesCitiesData);
                    break;
                case "2":
                    PurchaseActivity.this.onStateCityClick(this.searchType, statesCitiesData);
                    break;
                case "3":
                    PurchaseActivity.this.onStateCityClick(this.searchType, statesCitiesData);
                    break;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.countryArrayList.size();
        }

        public void filterCountryList(List<StatesCitiesData> newCountryArrayList) {
            this.countryArrayList = newCountryArrayList;
            notifyDataSetChanged();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tvName;

            public MyViewHolder(View itemView) {
                super(itemView);
                this.tvName = (TextView) itemView.findViewById(R.id.nameTv);
            }
        }
    }

    private void hit_api_to_get_state() {
        this.networkCall.NetworkAPICall(API.API_STATE, "", false, false);
    }

    private void hitApiForGettingAddress() {
        this.networkCall.NetworkAPICall(API.GET_USER_ADDRESS, "", false, false);
    }

    public void hitApiForGettingAddress(boolean isFirstTime) {
        this.isFirstTime = isFirstTime;
        this.networkCall.NetworkAPICall(API.GET_USER_ADDRESS, "", false, false);
    }

    private void hitApiForSavingAddress() {
        this.networkCall.NetworkAPICall(API.SAVE_USER_ADDRESS, "", false, false);
    }

    private void hit_api_to_get_city() {
        this.networkCall.NetworkAPICall(API.API_CITY, "", false, false);
    }

    public void onStateCityClick(String searchType, StatesCitiesData country) {
        if (searchType.equalsIgnoreCase("1")) {
            for (StatesCitiesData statesCitiesData : this.states.getData()) {
                if (statesCitiesData.getName().equals(country.getName())) {
                    this.stateindex = country.getName();
                    this.SelectedStateid = statesCitiesData.getId();
                    this.statesTV.setText(country.getName());
                    this.districtTV.setText("");
                    hit_api_to_get_city();
                    return;
                }
            }
            return;
        }
        if (searchType.equalsIgnoreCase("2")) {
            for (StatesCitiesData statesCitiesData2 : this.cities.getData()) {
                if (statesCitiesData2.getName().equals(country.getName())) {
                    this.cityindex = country.getName();
                    this.SelectedCityid = statesCitiesData2.getId();
                    this.districtTV.setText(country.getName());
                    return;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0225 A[PHI: r20
      0x0225: PHI (r20v3 java.lang.String) = (r20v2 java.lang.String), (r20v2 java.lang.String), (r20v5 java.lang.String) binds: [B:64:0x01dc, B:66:0x01e2, B:74:0x0223] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0270 A[PHI: r19
      0x0270: PHI (r19v1 java.lang.String) = (r19v0 java.lang.String), (r19v0 java.lang.String), (r19v3 java.lang.String) binds: [B:76:0x0229, B:78:0x022f, B:86:0x026e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x027e A[Catch: Exception -> 0x037f, TryCatch #0 {Exception -> 0x037f, blocks: (B:9:0x004a, B:12:0x0092, B:14:0x0098, B:16:0x00ab, B:18:0x00b1, B:20:0x00bb, B:24:0x00dd, B:26:0x00e3, B:28:0x00f2, B:30:0x00f8, B:32:0x0102, B:34:0x011b, B:36:0x0121, B:38:0x0130, B:40:0x0136, B:42:0x0140, B:44:0x0159, B:46:0x015f, B:48:0x016e, B:50:0x0174, B:52:0x017e, B:54:0x0197, B:56:0x019d, B:58:0x01ac, B:60:0x01b2, B:62:0x01bc, B:65:0x01de, B:67:0x01e4, B:69:0x01f5, B:71:0x01fb, B:73:0x0205, B:77:0x022b, B:79:0x0231, B:81:0x0242, B:83:0x0248, B:85:0x0252, B:88:0x0272, B:90:0x027e, B:92:0x0284, B:94:0x028a, B:97:0x02a1, B:99:0x02a7, B:103:0x02b2, B:164:0x0366, B:104:0x02b7, B:107:0x02bf, B:109:0x02c5, B:113:0x02d0, B:114:0x02d5, B:117:0x02dd, B:119:0x02e3, B:123:0x02ee, B:124:0x02f3, B:127:0x02fb, B:129:0x0301, B:133:0x030c, B:134:0x0310, B:137:0x0318, B:139:0x031e, B:143:0x0329, B:144:0x032d, B:147:0x0335, B:149:0x033b, B:153:0x0346, B:154:0x034a, B:157:0x0352, B:159:0x0358, B:163:0x0363, B:166:0x0371), top: B:171:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0284 A[Catch: Exception -> 0x037f, TryCatch #0 {Exception -> 0x037f, blocks: (B:9:0x004a, B:12:0x0092, B:14:0x0098, B:16:0x00ab, B:18:0x00b1, B:20:0x00bb, B:24:0x00dd, B:26:0x00e3, B:28:0x00f2, B:30:0x00f8, B:32:0x0102, B:34:0x011b, B:36:0x0121, B:38:0x0130, B:40:0x0136, B:42:0x0140, B:44:0x0159, B:46:0x015f, B:48:0x016e, B:50:0x0174, B:52:0x017e, B:54:0x0197, B:56:0x019d, B:58:0x01ac, B:60:0x01b2, B:62:0x01bc, B:65:0x01de, B:67:0x01e4, B:69:0x01f5, B:71:0x01fb, B:73:0x0205, B:77:0x022b, B:79:0x0231, B:81:0x0242, B:83:0x0248, B:85:0x0252, B:88:0x0272, B:90:0x027e, B:92:0x0284, B:94:0x028a, B:97:0x02a1, B:99:0x02a7, B:103:0x02b2, B:164:0x0366, B:104:0x02b7, B:107:0x02bf, B:109:0x02c5, B:113:0x02d0, B:114:0x02d5, B:117:0x02dd, B:119:0x02e3, B:123:0x02ee, B:124:0x02f3, B:127:0x02fb, B:129:0x0301, B:133:0x030c, B:134:0x0310, B:137:0x0318, B:139:0x031e, B:143:0x0329, B:144:0x032d, B:147:0x0335, B:149:0x033b, B:153:0x0346, B:154:0x034a, B:157:0x0352, B:159:0x0358, B:163:0x0363, B:166:0x0371), top: B:171:0x004a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void callPaymentMode() {
        /*
            Method dump skipped, instruction units count: 900
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Payment.PurchaseActivity.callPaymentMode():void");
    }

    private void openApplyCouponDialogBoxBook() {
        try {
            final Dialog dialog = new Dialog(this, R.style.BottomSheetDialog);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(true);
            dialog.setContentView(R.layout.bottom_sheet_coupon);
            dialog.getWindow().setLayout(-1, -2);
            final EditText editText = (EditText) dialog.findViewById(R.id.coupon_edt);
            TextView textView = (TextView) dialog.findViewById(R.id.cancel);
            TextView textView2 = (TextView) dialog.findViewById(R.id.apply);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda50
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda51
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$openApplyCouponDialogBoxBook$48(editText, dialog, view);
                }
            });
            dialog.show();
        } catch (Exception e2) {
            Log.d("TAGEXTERNALBOX", "openApplyCouponDialogBoxBook: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openApplyCouponDialogBoxBook$48(EditText editText, Dialog dialog, View view) {
        if (!TextUtils.isEmpty(editText.getText().toString())) {
            dialog.dismiss();
            this.secondCouponCode = editText.getText().toString();
            this.networkCall.NetworkAPICall(API.verifyCoupon, "", true, false);
            return;
        }
        Toast.makeText(this, "Please Enter Coupon Code", 0).show();
    }

    private void setSubscriptionData() {
        CourseDetail courseDetail = this.courseDetail;
        if (courseDetail == null || courseDetail.getData() == null || this.courseDetail.getData().getCourseDetail() == null || !this.courseDetail.getData().getCourseDetail().getIsPurchased().equalsIgnoreCase("0") || this.courseDetail.getData().getSubscriptionAllData() == null) {
            return;
        }
        SubscriptionAllData subscriptionAllData = this.courseDetail.getData().getSubscriptionAllData();
        this.subscriptionAllData = subscriptionAllData;
        if (subscriptionAllData != null && subscriptionAllData.getSubscriptionMeta() != null && !this.subscriptionAllData.getSubscriptionMeta().isEmpty()) {
            this.deliveryId1.setText(getString(R.string.select_delivery_method));
            this.deliveryId.setText(getString(R.string.select_your_subscription_plan));
            this.validityId.setText(getString(R.string.select_validity));
            this.txtGrandTotalValue.setText(String.format("%s %s", getResources().getString(R.string.rs), String.format("%.2f", Float.valueOf(Float.parseFloat(this.courseDetail.getData().getCourseDetail().getMrp()) + Float.parseFloat(this.courseDetail.getData().getCourseDetail().getTax())))));
            this.tax_value.setText(String.format("%s %s", getResources().getString(R.string.rs), String.format("%.2f", Float.valueOf(Float.parseFloat(this.courseDetail.getData().getCourseDetail().getTax())))));
            this.subscriptionSectionId.setVisibility(0);
            return;
        }
        this.subscriptionSectionId.setVisibility(8);
    }

    private void setThumbRatio(CardView rlThum) {
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        ViewGroup.LayoutParams layoutParams = rlThum.getLayoutParams();
        BottomSetting bottomSetting = this.bottomSetting;
        if (bottomSetting == null || bottomSetting.getLayout_type() == null || !this.bottomSetting.getLayout_type().equals("1")) {
            return;
        }
        layoutParams.height = (int) (Helper.grideHeight * displayMetrics.scaledDensity);
        layoutParams.width = (int) (Helper.grideWidth * displayMetrics.scaledDensity);
        rlThum.setLayoutParams(layoutParams);
    }

    private boolean setThumbAccordingRatio() {
        BottomSetting bottomSetting = this.bottomSetting;
        return (bottomSetting == null || bottomSetting.getLayout_type() == null || !this.bottomSetting.getLayout_type().equals("1")) ? false : true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2121 && data != null && data.hasExtra("status")) {
            Toast.makeText(this.activity, "Respo " + data.getStringExtra("status") + " " + data.getStringExtra("msg"), 0).show();
        }
    }

    private void setData(JSONObject jsonObject, JSONObject jsonobject, int i) throws JSONException {
        CourseDetailTable courseDetailTable = new CourseDetailTable();
        courseDetailTable.setCourse_title(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("title"));
        courseDetailTable.setCourse_id(SingleStudy.parentCourseId + "_" + jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("id"));
        courseDetailTable.setCover_image(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("cover_image"));
        courseDetailTable.setDesc_header_image(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("desc_header_image"));
        courseDetailTable.setMrp(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("mrp"));
        courseDetailTable.setCourse_sp(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("course_sp"));
        courseDetailTable.setValidity(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("validity"));
        courseDetailTable.setIs_purchased(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("is_purchased"));
        courseDetailTable.setIs_activated(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("is_activated"));
        courseDetailTable.setToken_activation(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("token_activation"));
        courseDetailTable.setTransaction_status(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString(Const.TRANSACTION_STATUS));
        courseDetailTable.setTax(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("tax"));
        courseDetailTable.setView_type(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("view_type"));
        courseDetailTable.setIs_combo(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString(Const.IS_COMBO));
        if (jsonObject.getJSONObject(Const.COURSE_DETAIL).has("external_coupon_off") && !TextUtils.isEmpty(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("external_coupon_off"))) {
            courseDetailTable.setExternal_coupon_off(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("external_coupon_off"));
        } else {
            courseDetailTable.setExternal_coupon_off("");
        }
        courseDetailTable.setAuthor_title(jsonObject.getJSONObject(Const.COURSE_DETAIL).getJSONObject("author").getString("title"));
        courseDetailTable.setTile_id(Helper.checkAndGetCourseTileData(jsonObject, i, "id"));
        courseDetailTable.setTile_meta(Helper.checkAndGetCourseTileData(jsonObject, i, "meta"));
        courseDetailTable.setUser_id(MakeMyExam.userId);
        courseDetailTable.setContent_type(this.content_type);
        if (jsonObject.getJSONArray("tiles").getJSONObject(i).has("thumbnail")) {
            courseDetailTable.setThumbnail(jsonObject.getJSONArray("tiles").getJSONObject(i).getString("thumbnail"));
        }
        courseDetailTable.setTile_revert(Helper.checkAndGetCourseTileData(jsonObject, i, Const.REVERT_API));
        courseDetailTable.setTile_title(Helper.checkAndGetCourseTileData(jsonObject, i, "tile_name"));
        courseDetailTable.setType(Helper.checkAndGetCourseTileData(jsonObject, i, "type"));
        courseDetailTable.setSet_as_demo(Helper.checkAndGetCourseTileData(jsonObject, i, "set_as_demo"));
        courseDetailTable.setInstallment(jsonObject.getJSONObject("instalment").toString());
        courseDetailTable.setDisplay_locked(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("display_locked"));
        courseDetailTable.setIs_gst(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("is_gst"));
        if (jsonObject.getJSONObject(Const.COURSE_DETAIL).has("avg_rating") && !TextUtils.isEmpty(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("avg_rating"))) {
            courseDetailTable.setAvg_rating(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("avg_rating"));
        } else {
            courseDetailTable.setAvg_rating("");
        }
        if (jsonObject.getJSONObject(Const.COURSE_DETAIL).has("user_rated") && !TextUtils.isEmpty(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("user_rated"))) {
            courseDetailTable.setUser_rated(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("user_rated"));
        } else {
            courseDetailTable.setUser_rated("");
        }
        if (jsonObject.getJSONObject(Const.COURSE_DETAIL).has("stocks") && !TextUtils.isEmpty(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("stocks"))) {
            courseDetailTable.setStocks(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("stocks"));
        } else {
            courseDetailTable.setStocks("");
        }
        if (jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("skip_payment") != null) {
            courseDetailTable.setSkip_payment(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("skip_payment"));
        } else {
            courseDetailTable.setSkip_payment("1");
        }
        if (jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("cat_type") != null) {
            courseDetailTable.setCat_type(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("cat_type"));
        } else {
            courseDetailTable.setCat_type("");
        }
        if (jsonObject.getJSONObject(Const.COURSE_DETAIL).getString(Const.DELIVERY_CHARGE) != null) {
            courseDetailTable.setDelivery_charge(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString(Const.DELIVERY_CHARGE));
        } else {
            courseDetailTable.setDelivery_charge("0");
        }
        courseDetailTable.setTxn_id(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("txn_id"));
        if (jsonObject.getJSONObject(Const.COURSE_DETAIL).has("combo_has_book") && !TextUtils.isEmpty(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("combo_has_book"))) {
            courseDetailTable.setCombo_has_book(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("combo_has_book"));
        } else {
            courseDetailTable.setCombo_has_book("0");
        }
        if (jsonobject.optJSONObject("data").optJSONObject("subscription_all_data") != null) {
            courseDetailTable.setSubscription_all_data(new Gson().toJson((SubscriptionAllData) new Gson().fromJson(jsonobject.optJSONObject("data").optJSONObject("subscription_all_data").toString(), SubscriptionAllData.class)));
        }
        this.myDBClass.getCourseDetaildata().addCoursedetail(courseDetailTable);
    }

    private void querySkuDetails() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(inapp_billing_product_id_number_1);
        arrayList.add(inapp_billing_product_id_number_2);
        this.billingClient.querySkuDetailsAsync(SkuDetailsParams.newBuilder().setSkusList(arrayList).setType("inapp").build(), new SkuDetailsResponseListener() { // from class: com.appnew.android.Payment.PurchaseActivity.18
            @Override // com.android.billingclient.api.SkuDetailsResponseListener
            public void onSkuDetailsResponse(BillingResult billingResult, List<SkuDetails> skuDetailsList) {
                if (billingResult.getResponseCode() != 0 || skuDetailsList == null || skuDetailsList.size() <= 0) {
                    return;
                }
                PurchaseActivity.this.SkuDetails = skuDetailsList.get(0);
            }
        });
    }

    boolean isComboBook() {
        return isComboBookAddress() && !Helper.isAddressShowAfter();
    }

    boolean isShowAddress() {
        return isComboBookAddress() && Helper.isAddressShowAfter();
    }

    boolean isComboBookAddress() {
        CourseDetail courseDetail = this.courseDetail;
        return (courseDetail == null || courseDetail.getData() == null || this.courseDetail.getData().getCourseDetail() == null || TextUtils.isEmpty(this.courseDetail.getData().getCourseDetail().getCombo_has_book()) || !this.courseDetail.getData().getCourseDetail().getCombo_has_book().equalsIgnoreCase("1") || !this.isBook.equalsIgnoreCase("0")) ? false : true;
    }

    public void handleExternalData(String externalCouponRemark) {
        try {
            if (externalCouponRemark.equalsIgnoreCase("1")) {
                this.extraCouponLayout.setVisibility(8);
                this.couponLayout.setVisibility(0);
                this.dummycoupon_layout.setVisibility(0);
                this.appliedCouponCode = this.coursesCouponArrayList.get(0).getCoupon().getCoupon_title();
                this.appliedCouponCodeId = this.coursesCouponArrayList.get(0).getCoupon().getId();
                return;
            }
            if (externalCouponRemark.equalsIgnoreCase("0")) {
                this.extraCouponLayout.setVisibility(0);
                this.book_coupon_applied.setVisibility(8);
                this.couponLayout.setVisibility(8);
                this.dummycoupon_layout.setVisibility(8);
                return;
            }
            if (externalCouponRemark.equalsIgnoreCase("2")) {
                this.extraCouponLayout.setVisibility(0);
                this.book_coupon_applied.setVisibility(8);
                this.couponLayout.setVisibility(0);
                this.dummycoupon_layout.setVisibility(0);
                this.appliedCouponCode = this.coursesCouponArrayList.get(0).getCoupon().getCoupon_title();
                this.appliedCouponCodeId = this.coursesCouponArrayList.get(0).getCoupon().getId();
                return;
            }
            this.extraCouponLayout.setVisibility(8);
            Toast.makeText(this.activity, "" + externalCouponRemark, 0).show();
        } catch (Exception e2) {
            Log.d("TAGEXTERNALDATA", "handleExternalData: " + e2.getMessage());
        }
    }

    private void pushEventForCoupon(CoursesCoupon coursesCoupon) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_id", AnalyticHelper.INSTANCE.getUserId());
        map.put(AnalyticsConstants.coupon_amount, coursesCoupon.getDiscount());
        map.put(AnalyticsConstants.course_name, this.courseDetail.getData().getCourseDetail().getTitle());
        map.put("course_id", this.courseDetail.getData().getCourseDetail().getId());
        map.put("coupon_code", coursesCoupon.getCoupon().getCoupon_title());
        AnalyticEvents.INSTANCE.pushEvents(this, "coupon_applied", map);
    }

    private void pushEventForPaymentInitialize() {
        PaymentViewModel paymentViewModel = this.paymentViewModel;
        String payVia = (paymentViewModel == null || TextUtils.isEmpty(paymentViewModel.getPayVia())) ? "NA" : this.paymentViewModel.getPayVia();
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_id", AnalyticHelper.INSTANCE.getUserId());
        map.put(AnalyticsConstants.user_name, AnalyticHelper.INSTANCE.getUserName());
        map.put(AnalyticsConstants.user_mobile, AnalyticHelper.INSTANCE.getUserMobile());
        map.put(AnalyticsConstants.course_name, this.courseDetail.getData().getCourseDetail().getTitle());
        map.put("transaction_id", TextUtils.isEmpty(this.pre_txtid) ? "NA" : this.pre_txtid);
        map.put(AnalyticsConstants.payment_method, payVia);
        map.put(AnalyticsConstants.payment_amount, "" + calculateAmount());
        AnalyticEvents.INSTANCE.pushEvents(this, AnalyticsConstants.PAYMENT_INITIALIZE, map);
    }

    private void pushEventForPaymentSuccess() {
        PaymentViewModel paymentViewModel = this.paymentViewModel;
        String payVia = (paymentViewModel == null || TextUtils.isEmpty(paymentViewModel.getPayVia())) ? "NA" : this.paymentViewModel.getPayVia();
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_id", AnalyticHelper.INSTANCE.getUserId());
        map.put(AnalyticsConstants.user_name, AnalyticHelper.INSTANCE.getUserName());
        map.put(AnalyticsConstants.user_mobile, AnalyticHelper.INSTANCE.getUserMobile());
        map.put(AnalyticsConstants.course_name, this.courseDetail.getData().getCourseDetail().getTitle());
        map.put("transaction_id", TextUtils.isEmpty(this.pos_txn_id) ? "NA" : this.pos_txn_id);
        map.put(AnalyticsConstants.payment_method, payVia);
        map.put(AnalyticsConstants.payment_amount, "" + calculateAmount());
        AnalyticEvents.INSTANCE.pushEvents(this, AnalyticsConstants.PAYMENT_CAPTURED, map);
    }

    private void pushEventForPaymentFailed(String errorCode) {
        PaymentViewModel paymentViewModel = this.paymentViewModel;
        String str = "NA";
        String payVia = (paymentViewModel == null || TextUtils.isEmpty(paymentViewModel.getPayVia())) ? "NA" : this.paymentViewModel.getPayVia();
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_id", AnalyticHelper.INSTANCE.getUserId());
        map.put(AnalyticsConstants.user_name, AnalyticHelper.INSTANCE.getUserName());
        map.put(AnalyticsConstants.user_mobile, AnalyticHelper.INSTANCE.getUserMobile());
        if (TextUtils.isEmpty(errorCode)) {
            errorCode = "NA";
        }
        map.put("error_code", errorCode);
        if (!TextUtils.isEmpty(this.pos_txn_id)) {
            str = this.pos_txn_id;
        } else if (!TextUtils.isEmpty(this.pre_txtid)) {
            str = this.pre_txtid;
        }
        map.put("transaction_id", str);
        map.put(AnalyticsConstants.payment_method, payVia);
        map.put(AnalyticsConstants.payment_amount, "" + calculateAmount());
        AnalyticEvents.INSTANCE.pushEvents(this, "payment_failed", map);
    }

    private void pushEventForFreeCourse() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_id", AnalyticHelper.INSTANCE.getUserId());
        map.put(AnalyticsConstants.user_name, AnalyticHelper.INSTANCE.getUserName());
        map.put("course_id", this.courseDetail.getData().getCourseDetail().getId());
        map.put(AnalyticsConstants.course_name, this.courseDetail.getData().getCourseDetail().getTitle());
        AnalyticEvents.INSTANCE.pushEvents(this, AnalyticsConstants.FREE_USER, map);
    }

    private void bookTypeUI(RoundedImageView imageIV, TextView courseNameTV, TextView courseNameTV1, TextView validityTV) {
        if (this.isBook.equalsIgnoreCase("1")) {
            imageIV.setVisibility(0);
            setLayoutParams(findViewById(R.id.layout_course), -1, -2, 0, 0, 0, 0);
            setRelativeLayoutParams(findViewById(R.id.imageIV_count), dpToPx(110), dpToPx(150), 20, dpToPx(25), dpToPx(30), 0, dpToPx(25));
            setRelativeLayoutParams(imageIV, dpToPx(110), dpToPx(150), 13, 0, 0, 0, 0);
            imageIV.setCornerRadius(10.0f, 10.0f, 10.0f, 10.0f);
            setTextViewParams(courseNameTV, R.id.imageIV_count, 6, dpToPx(8), dpToPx(35), dpToPx(18), 0);
            setTextViewParams(courseNameTV1, R.id.imageIV_count, R.id.coursenameTV, dpToPx(8), dpToPx(5), dpToPx(18), 0);
            setTextViewParams(validityTV, R.id.imageIV_count, R.id.coursenameTV1, dpToPx(8), dpToPx(5), dpToPx(18), 0);
            setTextViewParams(findViewById(R.id.ll_scholorship_discount), R.id.imageIV_count, R.id.validityTV, dpToPx(8), dpToPx(5), dpToPx(18), 0);
        }
    }

    private int dpToPx(int dp) {
        return (int) (dp * getResources().getDisplayMetrics().density);
    }

    private void setLayoutParams(View view, int width, int height, int left, int top, int right, int bottom) {
        view.setLayoutParams(new LinearLayoutCompat.LayoutParams(width, height));
        view.setPadding(left, top, right, bottom);
        view.requestLayout();
    }

    private void setRelativeLayoutParams(View view, int width, int height, int rule, int left, int top, int right, int bottom) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, height);
        layoutParams.addRule(rule);
        layoutParams.setMargins(left, top, right, bottom);
        view.setLayoutParams(layoutParams);
        view.requestLayout();
    }

    private void setTextViewParams(View view, int anchor, int below, int left, int top, int right, int bottom) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(17, anchor);
        if (below != 6) {
            layoutParams.addRule(3, below);
        }
        layoutParams.setMargins(left, top, right, bottom);
        view.setLayoutParams(layoutParams);
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            textView.setGravity(GravityCompat.START);
            textView.setMaxLines(Integer.MAX_VALUE);
        }
    }

    public void showUpdateStatePopup() {
        Log.d("TAGAddressModule", "IsShowAddress: " + isShowAddress() + "-> comboHasBook: " + isComboBookAddress() + " - isPurchase: " + Helper.isAddressShowAfter());
        UpdateProfileDialogUtils.makeDialogForStateUpdate(this, isShowAddress(), new UpdateProfileDialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Payment.PurchaseActivity.20
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
                    com.appnew.android.Payment.PurchaseActivity r2 = com.appnew.android.Payment.PurchaseActivity.this     // Catch: java.lang.Exception -> L4b
                    long r2 = r2.mLastClickTime     // Catch: java.lang.Exception -> L4b
                    long r0 = r0 - r2
                    r2 = 1000(0x3e8, double:4.94E-321)
                    int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r0 >= 0) goto L10
                    return
                L10:
                    com.appnew.android.Payment.PurchaseActivity r0 = com.appnew.android.Payment.PurchaseActivity.this     // Catch: java.lang.Exception -> L4b
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
                    com.appnew.android.Payment.PurchaseActivity r1 = com.appnew.android.Payment.PurchaseActivity.this     // Catch: java.lang.Exception -> L4b
                    r2 = r8
                    r3 = r9
                    r4 = r10
                    r5 = r11
                    r6 = r12
                    r1.submitUpdateStateData(r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L4b
                    return
                L42:
                    r2.dismiss()     // Catch: java.lang.Exception -> L4b
                    com.appnew.android.Payment.PurchaseActivity r8 = com.appnew.android.Payment.PurchaseActivity.this     // Catch: java.lang.Exception -> L4b
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
                throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Payment.PurchaseActivity.AnonymousClass20.onOKClick(android.app.Dialog, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
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
            aPIInterface.updateprofile(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new Callback<String>() { // from class: com.appnew.android.Payment.PurchaseActivity.21
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
                            Toast.makeText(PurchaseActivity.this, jSONObject.getString("message"), 1).show();
                            dialog.dismiss();
                            PurchaseActivity.this.finishPayment();
                        }
                    } catch (Exception e2) {
                        Log.d("Dialog", "onResponse: " + e2.getMessage());
                    }
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<String> call, Throwable t) {
                    Helper.dismissProgressDialog();
                    PurchaseActivity purchaseActivity = PurchaseActivity.this;
                    Toast.makeText(purchaseActivity, purchaseActivity.getResources().getString(R.string.something_went_wrong), 1).show();
                }
            });
            return;
        }
        Toast.makeText(this, getResources().getString(R.string.Retry_with_Internet_connection), 1).show();
    }

    public void finishPayment() {
        boolean z;
        Intent intent;
        String stringExtra = getIntent().hasExtra("test_mode") ? getIntent().getStringExtra("test_mode") : "";
        if (this.isBook.equalsIgnoreCase("3")) {
            if (stringExtra.equalsIgnoreCase("1")) {
                callServiceForInvoice();
                return;
            } else {
                Helper.gotoActivity(new Intent(this, (Class<?>) DashboardActivityTheme1.class), this);
                finishAffinity();
                return;
            }
        }
        if (this.isBook.equals("1")) {
            if ("1".equalsIgnoreCase("7")) {
                intent = new Intent(this, (Class<?>) DashboardActivityTheme8.class);
            } else if ("1".equalsIgnoreCase("2")) {
                intent = new Intent(this, (Class<?>) DashboardActivityTheme2.class);
            } else if ("1".equalsIgnoreCase("6")) {
                intent = new Intent(this, (Class<?>) DashboardActivityTheme7.class);
            } else {
                intent = new Intent(this, (Class<?>) DashboardActivityTheme1.class);
            }
            intent.setFlags(67141632);
            Helper.gotoActivity(intent, this);
            return;
        }
        CourseDetail courseDetail = this.courseDetail;
        if (courseDetail == null || courseDetail.getData() == null || this.courseDetail.getData().getTiles() == null) {
            z = false;
        } else {
            Iterator<TilesItem> it = this.courseDetail.getData().getTiles().iterator();
            z = false;
            while (it.hasNext()) {
                if (it.next().getType().equalsIgnoreCase(Const.COMBO)) {
                    z = true;
                }
            }
        }
        Intent intent2 = new Intent(this, (Class<?>) CourseActivity.class);
        intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
        intent2.putExtra(Const.COURSE_ID_MAIN, !SingleStudy.parentCourseId.equalsIgnoreCase("") ? SingleStudy.parentCourseId : this.courseDetail.getData().getCourseDetail().getId());
        intent2.putExtra(Const.COURSE_PARENT_ID, "");
        intent2.putExtra(Const.IS_COMBO, false);
        if (!z) {
            intent2.putExtra(Const.COMBO_ID, "");
        }
        intent2.putExtra(AnalyticsConstants.course_name, this.courseDetail.getData().getCourseDetail().getTitle());
        intent2.setFlags(67108864);
        Helper.gotoActivity_finish(intent2, this);
    }

    public void manageQRPayment(JSONObject data) {
        this.pre_txtid = data.optString(Const.COURSE_INIT_PAYMENT_TOKEN, "");
        this.txnToken = data.optString("txnToken", "");
        try {
            this.txnTokenData = (TxnTokenData) new Gson().fromJson(this.txnToken, TxnTokenData.class);
        } catch (Exception unused) {
            this.txnTokenData = null;
        }
        TxnTokenData txnTokenData = this.txnTokenData;
        if (txnTokenData == null) {
            showMessage("QR data not found!");
            return;
        }
        if (TextUtils.isEmpty(txnTokenData.getImage_url())) {
            showMessage("QR image not found!");
            return;
        }
        if (TextUtils.isEmpty(this.txnTokenData.getCreated_at()) || TextUtils.isEmpty(this.txnTokenData.getClose_by())) {
            showMessage("Payment duration not valid!");
        } else if (TextUtils.isEmpty(this.pre_txtid)) {
            showMessage("Transaction id not found!");
        } else {
            openQRCode();
        }
    }

    public int getDeviceWidthWithInsets() {
        try {
            WindowManager windowManager = (WindowManager) getSystemService("window");
            if (Build.VERSION.SDK_INT >= 30) {
                Insets insets = windowManager.getCurrentWindowMetrics().getWindowInsets().getInsets(WindowInsets.Type.systemBars());
                return (windowManager.getCurrentWindowMetrics().getBounds().width() - insets.left) - insets.right;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (windowManager != null && windowManager.getDefaultDisplay() != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            return displayMetrics.widthPixels;
        } catch (Exception unused) {
            return 720;
        }
    }

    public int getDeviceHeightWithInsets() {
        try {
            WindowManager windowManager = (WindowManager) getSystemService("window");
            if (Build.VERSION.SDK_INT >= 30) {
                Insets insets = windowManager.getCurrentWindowMetrics().getWindowInsets().getInsets(WindowInsets.Type.systemBars());
                return (windowManager.getCurrentWindowMetrics().getBounds().height() - insets.top) - insets.bottom;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (windowManager != null && windowManager.getDefaultDisplay() != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            return displayMetrics.heightPixels;
        } catch (Exception unused) {
            return 1280;
        }
    }

    public void openQRCode() {
        final Dialog dialog;
        final RelativeLayout relativeLayout;
        final LinearLayout linearLayout;
        ImageView imageView;
        final ImageView imageView2;
        final TextView textView;
        try {
            dialog = new Dialog(this);
            dialog.setContentView(R.layout.dialog_qr_payment);
            dialog.setCancelable(false);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            relativeLayout = (RelativeLayout) dialog.findViewById(R.id.mainQRRL);
            linearLayout = (LinearLayout) dialog.findViewById(R.id.qrLoader);
            imageView = (ImageView) dialog.findViewById(R.id.iv_close);
            imageView2 = (ImageView) dialog.findViewById(R.id.iv_qr_image);
            textView = (TextView) dialog.findViewById(R.id.time);
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            Glide.with((FragmentActivity) this).asBitmap().load(this.txnTokenData.getImage_url()).timeout(10000).into(new CustomTarget<Bitmap>() { // from class: com.appnew.android.Payment.PurchaseActivity.22
                @Override // com.bumptech.glide.request.target.Target
                public void onLoadCleared(Drawable placeholder) {
                }

                @Override // com.bumptech.glide.request.target.Target
                public /* bridge */ /* synthetic */ void onResourceReady(Object resource, Transition transition) {
                    onResourceReady((Bitmap) resource, (Transition<? super Bitmap>) transition);
                }

                /* JADX WARN: Type inference failed for: r4v0, types: [com.appnew.android.Payment.PurchaseActivity$22$1] */
                public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                    PurchaseActivity.this.enableScreenshot();
                    LinearLayout linearLayout2 = linearLayout;
                    if (linearLayout2 != null) {
                        linearLayout2.setVisibility(8);
                    }
                    PurchaseActivity.this.qrPaymentCallback(dialog);
                    ImageView imageView3 = imageView2;
                    if (imageView3 != null) {
                        imageView3.setImageBitmap(resource);
                    }
                    RelativeLayout relativeLayout2 = relativeLayout;
                    if (relativeLayout2 != null && imageView2 != null) {
                        ViewGroup.LayoutParams layoutParams = relativeLayout2.getLayoutParams();
                        layoutParams.width = imageView2.getWidth() > 0 ? imageView2.getWidth() : PurchaseActivity.this.getDeviceWidthWithInsets() - (PurchaseActivity.this.getDeviceWidthWithInsets() / 4);
                        layoutParams.height = imageView2.getHeight() > 0 ? imageView2.getHeight() : PurchaseActivity.this.getDeviceHeightWithInsets() - (PurchaseActivity.this.getDeviceHeightWithInsets() / 10);
                        relativeLayout.setLayoutParams(layoutParams);
                    }
                    try {
                        PurchaseActivity.this.countDownTimer = new CountDownTimer((Long.parseLong(PurchaseActivity.this.txnTokenData.getClose_by()) * 1000) - (Long.parseLong(PurchaseActivity.this.txnTokenData.getCreated_at()) * 1000), 1000L) { // from class: com.appnew.android.Payment.PurchaseActivity.22.1
                            @Override // android.os.CountDownTimer
                            public void onTick(long millisUntilFinished) {
                                if (textView != null) {
                                    textView.setText(String.format(Locale.getDefault(), "%02d:%02d", Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60)));
                                    if (millisUntilFinished <= 30000) {
                                        textView.setBackgroundTintList(ContextCompat.getColorStateList(PurchaseActivity.this, R.color.md_amber_A400));
                                    } else if (millisUntilFinished <= 120000) {
                                        textView.setBackgroundTintList(ContextCompat.getColorStateList(PurchaseActivity.this, R.color.rewards_color));
                                    } else {
                                        textView.setBackgroundTintList(ContextCompat.getColorStateList(PurchaseActivity.this, R.color.md_lime_500));
                                    }
                                }
                            }

                            @Override // android.os.CountDownTimer
                            public void onFinish() {
                                if (textView != null) {
                                    textView.setText("Expired");
                                }
                                PurchaseActivity.this.showMessage("QR Expired");
                                dialog.dismiss();
                            }
                        }.start();
                    } catch (Exception unused) {
                        PurchaseActivity.this.showMessage("Invalid QR timing");
                        dialog.dismiss();
                    }
                }

                @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
                public void onLoadFailed(Drawable errorDrawable) {
                    PurchaseActivity.this.showMessage("Invalid QR code!");
                    dialog.dismiss();
                }
            });
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda10
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$openQRCode$50(dialog, view);
                    }
                });
            }
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda12
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    this.f$0.lambda$openQRCode$51(dialogInterface);
                }
            });
            dialog.show();
        } catch (Exception e3) {
            e = e3;
            Log.d("TAGINSTANTPURCHASE", "Error: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openQRCode$50(final Dialog dialog, View view) {
        Activity activity = this.activity;
        String string = getResources().getString(R.string.confirm);
        String string2 = getResources().getString(R.string.cancel);
        Objects.requireNonNull(dialog);
        DialogUtils.makeDialog(activity, "", "Are you sure want to close!", string, string2, true, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda22
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
            public final void onOKClick() {
                dialog.dismiss();
            }
        }, new DialogUtils.onDialogUtilsCancelClick() { // from class: com.appnew.android.Payment.PurchaseActivity$$ExternalSyntheticLambda33
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsCancelClick
            public final void onCancelClick() {
                PurchaseActivity.lambda$openQRCode$49();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openQRCode$51(DialogInterface dialogInterface) {
        ValueEventListener valueEventListener;
        DatabaseReference databaseReference = this.mFirebaseDatabaseReferenceQRPay;
        if (databaseReference != null && (valueEventListener = this.qrPayValueEventListener) != null) {
            databaseReference.removeEventListener(valueEventListener);
        }
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void qrPaymentCallback(final Dialog dialog) {
        if (TextUtils.isEmpty(this.pre_txtid)) {
            return;
        }
        this.mFirebaseDatabaseReferenceQRPay = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/qrcode_payment_status/" + this.pre_txtid);
        ValueEventListener valueEventListener = new ValueEventListener() { // from class: com.appnew.android.Payment.PurchaseActivity.23
            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError error) {
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot snapshot) {
                QRPaymentData qRPaymentData;
                try {
                    if (snapshot.getValue() == null || (qRPaymentData = (QRPaymentData) snapshot.getValue(QRPaymentData.class)) == null || TextUtils.isEmpty(qRPaymentData.getPre_transaction_id()) || TextUtils.isEmpty(qRPaymentData.getPost_transaction_id()) || !"1".equals(String.valueOf(qRPaymentData.getTransaction_status()))) {
                        return;
                    }
                    PurchaseActivity.this.pre_txtid = qRPaymentData.getPre_transaction_id();
                    PurchaseActivity.this.pos_txn_id = qRPaymentData.getPost_transaction_id();
                    PurchaseActivity.this.networkCall.NetworkAPICall(API.int_payment, "", true, false);
                    if (dialog.isShowing()) {
                        dialog.dismiss();
                    }
                } catch (Exception e2) {
                    Log.d("TAGINSTANTPURCHASE", "Error: " + e2.getMessage());
                }
            }
        };
        this.qrPayValueEventListener = valueEventListener;
        this.mFirebaseDatabaseReferenceQRPay.addValueEventListener(valueEventListener);
    }

    public void enableScreenshot() {
        Activity activity = this.activity;
        if (activity != null) {
            activity.getWindow().clearFlags(8192);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMessage(String msg) {
        Toast.makeText(this, msg, 0).show();
    }

    private void manageQRButton() {
        if (this.openQR != null) {
            try {
                if (this.procceed.getText().toString().equalsIgnoreCase("Proceed")) {
                    if (Helper.enableQRCode()) {
                        this.openQR.setVisibility(0);
                        return;
                    } else {
                        this.openQR.setVisibility(8);
                        return;
                    }
                }
                this.openQR.setVisibility(8);
            } catch (Exception unused) {
                this.openQR.setVisibility(8);
            }
        }
    }

    private boolean isCouponBlank(Object couponValue) {
        JSONObject jSONObject;
        return !(couponValue instanceof JSONObject) || (jSONObject = (JSONObject) couponValue) == null || jSONObject.length() == 0;
    }

    private void updateCourseDetail(CourseDetailData target, CoursesCoupon source) {
        target.setCover_image(source.getCover_image());
        target.setIs_gst(source.getIs_gst());
        target.setTax_rate(source.getTax_rate());
        target.setCourseSp(source.getCourse_sp());
        target.setMrp(source.getMrp());
        target.setValidity(source.getValidity());
        target.setTax(source.getTax());
    }
}
