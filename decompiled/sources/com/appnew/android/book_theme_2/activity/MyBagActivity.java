package com.appnew.android.book_theme_2.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import com.appnew.android.Courses.Fragment.SingleStudy;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.ExtensionFunctions.XtensionFunctionKt;
import com.appnew.android.Model.BillDesk;
import com.appnew.android.Model.BottomSetting;
import com.appnew.android.Model.Ccav;
import com.appnew.android.Model.EaseBuzz;
import com.appnew.android.Model.Extras;
import com.appnew.android.Model.FonePay;
import com.appnew.android.Model.Paytm;
import com.appnew.android.Model.Rzp;
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
import com.appnew.android.book_theme_2.adapter.BagCartAdapter;
import com.appnew.android.book_theme_2.models.CartItemBook;
import com.appnew.android.book_theme_2.models.CartItemBookData;
import com.appnew.android.book_theme_2.models.Cartdata;
import com.appnew.android.databinding.ActivityMyBagBinding;
import com.eduteria.app.app.R;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.razorpay.Checkout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: MyBagActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010GH\u0014J\u0010\u0010H\u001a\u00020E2\u0006\u0010I\u001a\u00020\rH\u0002J\u001a\u0010J\u001a\u00020E2\u0006\u0010K\u001a\u00020\n2\b\u0010L\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010M\u001a\u00020EH\u0002J0\u0010N\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010O2\b\u0010P\u001a\u0004\u0018\u00010\n2\b\u0010Q\u001a\u0004\u0018\u00010\n2\b\u0010R\u001a\u0004\u0018\u00010SH\u0016J.\u0010T\u001a\u00020E2\b\u0010U\u001a\u0004\u0018\u00010V2\b\u0010P\u001a\u0004\u0018\u00010\n2\b\u0010Q\u001a\u0004\u0018\u00010\n2\u0006\u0010W\u001a\u00020\rH\u0016J&\u0010X\u001a\u00020E2\b\u0010U\u001a\u0004\u0018\u00010\n2\b\u0010P\u001a\u0004\u0018\u00010\n2\b\u0010Q\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010Y\u001a\u00020EH\u0002J\u001c\u0010Z\u001a\u00020E2\b\u0010[\u001a\u0004\u0018\u00010\n2\b\u0010\\\u001a\u0004\u0018\u00010VH\u0016J\b\u0010]\u001a\u00020EH\u0016J\u0018\u0010^\u001a\u00020E2\u0006\u0010\\\u001a\u00020V2\u0006\u0010[\u001a\u00020\nH\u0002J\b\u0010_\u001a\u00020`H\u0002J\u0010\u0010a\u001a\u00020E2\u0006\u0010b\u001a\u00020\nH\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR#\u0010\u001f\u001a\n !*\u0004\u0018\u00010 0 8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001e\u001a\u0004\b\"\u0010#R\u001c\u0010%\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\u001c\u0010-\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)R\u001a\u00100\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010'\"\u0004\b2\u0010)R\u000e\u00103\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00105\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010'\"\u0004\b7\u0010)R\u001a\u00108\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010'\"\u0004\b:\u0010)R\u001a\u0010;\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010'\"\u0004\b=\u0010)R\u001a\u0010>\u001a\u00020?X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C¨\u0006c"}, d2 = {"Lcom/appnew/android/book_theme_2/activity/MyBagActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "Lcom/appnew/android/Utils/PaymentTypeCheck;", "<init>", "()V", "cartList", "", "Lcom/appnew/android/book_theme_2/models/Cartdata;", "deleteItem", "", "coursePrice", "isfailure", "", "courseId", "bottomSetting", "Lcom/appnew/android/Model/BottomSetting;", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "binding", "Lcom/appnew/android/databinding/ActivityMyBagBinding;", "getBinding", "()Lcom/appnew/android/databinding/ActivityMyBagBinding;", "setBinding", "(Lcom/appnew/android/databinding/ActivityMyBagBinding;)V", "bagItemAdapter", "Lcom/appnew/android/book_theme_2/adapter/BagCartAdapter;", "getBagItemAdapter", "()Lcom/appnew/android/book_theme_2/adapter/BagCartAdapter;", "bagItemAdapter$delegate", "Lkotlin/Lazy;", "myDBClass", "Lcom/appnew/android/Room/UtkashRoom;", "kotlin.jvm.PlatformType", "getMyDBClass", "()Lcom/appnew/android/Room/UtkashRoom;", "myDBClass$delegate", "rid", "getRid", "()Ljava/lang/String;", "setRid", "(Ljava/lang/String;)V", "amt", "getAmt", "setAmt", "scd", "getScd", "setScd", "enc_val", "getEnc_val", "setEnc_val", "txnToken", "pre_txtid", "pos_txn_id", "getPos_txn_id", "setPos_txn_id", "price1", "getPrice1", "setPrice1", "calculatedTax", "getCalculatedTax", "setCalculatedTax", "paymentViewModel", "Lcom/appnew/android/Payment/PaymentViewModel;", "getPaymentViewModel", "()Lcom/appnew/android/Payment/PaymentViewModel;", "setPaymentViewModel", "(Lcom/appnew/android/Payment/PaymentViewModel;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "hitApiCartList", "showProgress", "API_INIT_PAYMENT", FirebaseAnalytics.Param.PRICE, "id", "initPaymentGateway", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "ErrorCallBack", "OnPaymentError", "onPaymentType", "mode", "data", "onPaymentTypeCancel", "paymentGateways", "calculateAmount", "", "launch_RazorPayPaymentGateway", "key", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MyBagActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack, PaymentTypeCheck {
    public static final int $stable = 8;
    public ActivityMyBagBinding binding;
    private BottomSetting bottomSetting;
    private boolean isfailure;
    private NetworkCall networkCall;
    public PaymentViewModel paymentViewModel;
    private List<Cartdata> cartList = new ArrayList();
    private String deleteItem = "";
    private String coursePrice = "";
    private String courseId = "";

    /* JADX INFO: renamed from: bagItemAdapter$delegate, reason: from kotlin metadata */
    private final Lazy bagItemAdapter = LazyKt.lazy(new Function0() { // from class: com.appnew.android.book_theme_2.activity.MyBagActivity$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MyBagActivity.bagItemAdapter_delegate$lambda$1(this.f$0);
        }
    });

    /* JADX INFO: renamed from: myDBClass$delegate, reason: from kotlin metadata */
    private final Lazy myDBClass = LazyKt.lazy(new Function0() { // from class: com.appnew.android.book_theme_2.activity.MyBagActivity$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MyBagActivity.myDBClass_delegate$lambda$2(this.f$0);
        }
    });
    private String rid = "";
    private String amt = "";
    private String scd = "";
    private String enc_val = "";
    private String txnToken = "";
    private String pre_txtid = "";
    private String pos_txn_id = "";
    private String price1 = "";
    private String calculatedTax = "";

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    public final ActivityMyBagBinding getBinding() {
        ActivityMyBagBinding activityMyBagBinding = this.binding;
        if (activityMyBagBinding != null) {
            return activityMyBagBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(ActivityMyBagBinding activityMyBagBinding) {
        Intrinsics.checkNotNullParameter(activityMyBagBinding, "<set-?>");
        this.binding = activityMyBagBinding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BagCartAdapter getBagItemAdapter() {
        return (BagCartAdapter) this.bagItemAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BagCartAdapter bagItemAdapter_delegate$lambda$1(final MyBagActivity myBagActivity) {
        return new BagCartAdapter(new ArrayList(), new Function1() { // from class: com.appnew.android.book_theme_2.activity.MyBagActivity$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MyBagActivity.bagItemAdapter_delegate$lambda$1$lambda$0(this.f$0, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bagItemAdapter_delegate$lambda$1$lambda$0(MyBagActivity myBagActivity, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        myBagActivity.deleteItem = it;
        NetworkCall networkCall = myBagActivity.networkCall;
        if (networkCall == null) {
            Intrinsics.throwUninitializedPropertyAccessException("networkCall");
            networkCall = null;
        }
        networkCall.NetworkAPICall(API.COURSE_REMOVE_ITEM, "", false, false);
        return Unit.INSTANCE;
    }

    public final UtkashRoom getMyDBClass() {
        return (UtkashRoom) this.myDBClass.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UtkashRoom myDBClass_delegate$lambda$2(MyBagActivity myBagActivity) {
        return UtkashRoom.getAppDatabase(myBagActivity);
    }

    public final String getRid() {
        return this.rid;
    }

    public final void setRid(String str) {
        this.rid = str;
    }

    public final String getAmt() {
        return this.amt;
    }

    public final void setAmt(String str) {
        this.amt = str;
    }

    public final String getScd() {
        return this.scd;
    }

    public final void setScd(String str) {
        this.scd = str;
    }

    public final String getEnc_val() {
        return this.enc_val;
    }

    public final void setEnc_val(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.enc_val = str;
    }

    public final String getPos_txn_id() {
        return this.pos_txn_id;
    }

    public final void setPos_txn_id(String str) {
        this.pos_txn_id = str;
    }

    public final String getPrice1() {
        return this.price1;
    }

    public final void setPrice1(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.price1 = str;
    }

    public final String getCalculatedTax() {
        return this.calculatedTax;
    }

    public final void setCalculatedTax(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.calculatedTax = str;
    }

    public final PaymentViewModel getPaymentViewModel() {
        PaymentViewModel paymentViewModel = this.paymentViewModel;
        if (paymentViewModel != null) {
            return paymentViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("paymentViewModel");
        return null;
    }

    public final void setPaymentViewModel(PaymentViewModel paymentViewModel) {
        Intrinsics.checkNotNullParameter(paymentViewModel, "<set-?>");
        this.paymentViewModel = paymentViewModel;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyBagActivity myBagActivity = this;
        Helper.setSystemBarLight(myBagActivity);
        MyBagActivity myBagActivity2 = this;
        getWindow().setStatusBarColor(ContextCompat.getColor(myBagActivity2, R.color.yellow_light));
        setBinding((ActivityMyBagBinding) DataBindingUtil.setContentView(myBagActivity, R.layout.activity_my_bag));
        Helper.enableScreenShot(myBagActivity);
        this.networkCall = new NetworkCall(this, myBagActivity2);
        getBinding().recyclerViewId.setAdapter(getBagItemAdapter());
        if (getIntent() != null) {
            getBinding().bagTextId.setText(getResources().getString(R.string.my_cart));
        }
        if (getMyDBClass().getthemeSettingdao().is_setting_exit()) {
            this.bottomSetting = (BottomSetting) new Gson().fromJson(getMyDBClass().getthemeSettingdao().data().getBottom(), BottomSetting.class);
        }
        hitApiCartList(true);
        getBinding().backButton.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.book_theme_2.activity.MyBagActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MyBagActivity.onCreate$lambda$3(this.f$0);
            }
        }));
        getBinding().placeOrderId.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.book_theme_2.activity.MyBagActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MyBagActivity.onCreate$lambda$4(this.f$0);
            }
        }));
        initPaymentGateway();
        getBinding().searchId.addTextChangedListener(new TextWatcher() { // from class: com.appnew.android.book_theme_2.activity.MyBagActivity.onCreate.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s == null || s.length() <= 0) {
                    MyBagActivity.this.getBagItemAdapter().updateData(MyBagActivity.this.cartList);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (Cartdata cartdata : MyBagActivity.this.cartList) {
                    String courseName = cartdata.getCourseName();
                    Locale locale = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                    String lowerCase = courseName.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    if (StringsKt.contains((CharSequence) lowerCase, s, true)) {
                        arrayList.add(cartdata);
                    }
                }
                MyBagActivity.this.getBagItemAdapter().updateData(arrayList);
                MyBagActivity.this.getBinding().executePendingBindings();
                MyBagActivity.this.getBinding().recyclerViewId.setAdapter(MyBagActivity.this.getBagItemAdapter());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$3(MyBagActivity myBagActivity) {
        myBagActivity.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$4(MyBagActivity myBagActivity) {
        MyBagActivity myBagActivity2 = myBagActivity;
        if (!Helper.isNetworkConnected(myBagActivity2)) {
            Helper.showInternetToast(myBagActivity2);
            return Unit.INSTANCE;
        }
        if (StringsKt.equals(MakeMyExam.getUserId(), "0", true)) {
            return Unit.INSTANCE;
        }
        myBagActivity.API_INIT_PAYMENT(myBagActivity.coursePrice, myBagActivity.courseId);
        return Unit.INSTANCE;
    }

    private final void hitApiCartList(boolean showProgress) {
        MyBagActivity myBagActivity = this;
        if (!Helper.isNetworkConnected(myBagActivity)) {
            Helper.showInternetToast(myBagActivity);
            getBinding().recyclerViewId.setVisibility(8);
            RelativeLayout relativeLayout = getBinding().noDataFoundRL;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
                return;
            }
            return;
        }
        getBinding().recyclerViewId.setVisibility(0);
        RelativeLayout relativeLayout2 = getBinding().noDataFoundRL;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
        Helper.showProgressDialog(myBagActivity);
        NetworkCall networkCall = this.networkCall;
        if (networkCall == null) {
            Intrinsics.throwUninitializedPropertyAccessException("networkCall");
            networkCall = null;
        }
        networkCall.NetworkAPICall(API.COURSE_SHOW_CART, "", showProgress, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x01a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void API_INIT_PAYMENT(java.lang.String r22, java.lang.String r23) {
        /*
            Method dump skipped, instruction units count: 793
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.book_theme_2.activity.MyBagActivity.API_INIT_PAYMENT(java.lang.String, java.lang.String):void");
    }

    private final void initPaymentGateway() {
        setPaymentViewModel((PaymentViewModel) new ViewModelProvider(this).get(PaymentViewModel.class));
        getPaymentViewModel().initPaymentGateway(this, new PaymentGatewayListener() { // from class: com.appnew.android.book_theme_2.activity.MyBagActivity.initPaymentGateway.1
            @Override // com.appnew.android.Payment.PaymentGatewayListener
            public void onSuccessEsewa(String productId, String totalAmount, String referenceId, String scdId) {
                Intrinsics.checkNotNullParameter(productId, "productId");
                Intrinsics.checkNotNullParameter(totalAmount, "totalAmount");
                Intrinsics.checkNotNullParameter(referenceId, "referenceId");
                Intrinsics.checkNotNullParameter(scdId, "scdId");
                MyBagActivity.this.setPos_txn_id(productId);
                MyBagActivity.this.setAmt(totalAmount);
                MyBagActivity.this.setRid(referenceId);
                MyBagActivity.this.setScd(scdId);
                NetworkCall networkCall = MyBagActivity.this.networkCall;
                if (networkCall == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("networkCall");
                    networkCall = null;
                }
                networkCall.NetworkAPICall(API.int_payment, "", true, false);
            }

            @Override // com.appnew.android.Payment.PaymentGatewayListener
            public void onSuccess(String posTxnId) {
                MyBagActivity.this.setPos_txn_id(posTxnId);
                NetworkCall networkCall = MyBagActivity.this.networkCall;
                if (networkCall == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("networkCall");
                    networkCall = null;
                }
                networkCall.NetworkAPICall(API.int_payment, "", true, false);
            }

            @Override // com.appnew.android.Payment.PaymentGatewayListener
            public void onFailed(boolean isFailure) {
                MyBagActivity.this.OnPaymentError();
            }
        }, this.courseId);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        if (apitype != null) {
            switch (apitype.hashCode()) {
                case -1410705383:
                    if (apitype.equals(API.COURSE_SHOW_CART)) {
                        AES.encrypt(new Gson().toJson(new EncryptionData()));
                        cartItems = service != null ? service.getCartItems() : null;
                        Intrinsics.checkNotNull(cartItems);
                    }
                    break;
                case 1334579443:
                    if (apitype.equals(API.COURSE_CART_COUNT)) {
                        AES.encrypt(new Gson().toJson(new EncryptionData()));
                        cartItems = service != null ? service.getCartCount() : null;
                        Intrinsics.checkNotNull(cartItems);
                        return cartItems;
                    }
                    break;
                case 1397369619:
                    if (apitype.equals(API.COURSE_REMOVE_ITEM)) {
                        EncryptionData encryptionData = new EncryptionData();
                        encryptionData.setItem_id(this.deleteItem);
                        this.deleteItem = "";
                        String strEncrypt = AES.encrypt(new Gson().toJson(encryptionData));
                        if (service != null) {
                            return service.getRemoveItem(strEncrypt);
                        }
                        return null;
                    }
                    break;
                case 2002393681:
                    if (apitype.equals(API.int_payment)) {
                        Extras extras = new Extras();
                        extras.setCourse_id(this.courseId);
                        if (this.isfailure) {
                            EncryptionData encryptionData2 = new EncryptionData();
                            encryptionData2.setType("6");
                            encryptionData2.setCourse_id(this.courseId);
                            encryptionData2.setParent_id("");
                            encryptionData2.setPre_transaction_id(this.pre_txtid);
                            encryptionData2.setTransaction_status("2");
                            encryptionData2.setPost_transaction_id("");
                            encryptionData2.setExtras(extras);
                            String strEncrypt2 = AES.encrypt(new Gson().toJson(encryptionData2));
                            if (service != null) {
                                return service.int_payment(strEncrypt2);
                            }
                            return null;
                        }
                        if (StringsKt.equals$default(this.pos_txn_id, "", false, 2, null)) {
                            EncryptionData encryptionData3 = new EncryptionData();
                            encryptionData3.setType("5");
                            encryptionData3.setCourse_bulk(this.courseId);
                            encryptionData3.setExtras(extras);
                            encryptionData3.setCourse_price(this.price1);
                            encryptionData3.setParent_id("");
                            encryptionData3.setTax(this.calculatedTax);
                            encryptionData3.setPay_via(getPaymentViewModel().getPayVia());
                            encryptionData3.setCoupon_applied("0");
                            String strEncrypt3 = AES.encrypt(new Gson().toJson(encryptionData3));
                            if (service != null) {
                                return service.int_payment(strEncrypt3);
                            }
                            return null;
                        }
                        EncryptionData encryptionData4 = new EncryptionData();
                        encryptionData4.setType("6");
                        encryptionData4.setCourse_id(this.courseId);
                        encryptionData4.setExtras(extras);
                        encryptionData4.setParent_id("");
                        encryptionData4.setPre_transaction_id(this.pre_txtid);
                        encryptionData4.setTransaction_status("1");
                        encryptionData4.setPost_transaction_id(this.pos_txn_id);
                        encryptionData4.setRid(this.rid);
                        encryptionData4.setScd(this.scd);
                        encryptionData4.setPid(this.pos_txn_id);
                        encryptionData4.setAmt(this.amt);
                        encryptionData4.setOrder_id(this.pos_txn_id);
                        String strEncrypt4 = AES.encrypt(new Gson().toJson(encryptionData4));
                        if (service != null) {
                            return service.int_payment(strEncrypt4);
                        }
                        return null;
                    }
                    break;
            }
        }
        return cartItems;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) {
        if (apitype != null) {
            String string = "";
            NetworkCall networkCall = null;
            try {
                switch (apitype.hashCode()) {
                    case -1410705383:
                        if (apitype.equals(API.COURSE_SHOW_CART)) {
                            try {
                                Helper.dismissProgressDialog();
                                if (!StringsKt.equals$default(jsonstring != null ? jsonstring.getString("status") : null, "true", false, 2, null)) {
                                    getBinding().recyclerViewId.setVisibility(8);
                                    RelativeLayout relativeLayout = getBinding().noDataFoundRL;
                                    if (relativeLayout != null) {
                                        relativeLayout.setVisibility(0);
                                    }
                                    getBinding().cartItemCoupon.setVisibility(8);
                                    getBinding().placeOrderId.setVisibility(8);
                                    break;
                                } else {
                                    CartItemBook cartItemBook = (CartItemBook) new Gson().fromJson(String.valueOf(jsonstring), CartItemBook.class);
                                    if (cartItemBook.getData() != null && !cartItemBook.getData().getCartdata().isEmpty()) {
                                        getBagItemAdapter().updateData(CollectionsKt.toMutableList((Collection) cartItemBook.getData().getCartdata()));
                                        this.cartList = CollectionsKt.toMutableList((Collection) cartItemBook.getData().getCartdata());
                                        getBinding().totalProductId.setText("Total Products (" + getBagItemAdapter().getItemCount() + " Items)");
                                        CartItemBookData data = cartItemBook != null ? cartItemBook.getData() : null;
                                        Intrinsics.checkNotNull(data);
                                        this.coursePrice = String.valueOf(Float.parseFloat(data.getTotal()));
                                        break;
                                    }
                                }
                            } catch (Exception unused) {
                                getBinding().recyclerViewId.setVisibility(8);
                                RelativeLayout relativeLayout2 = getBinding().noDataFoundRL;
                                if (relativeLayout2 != null) {
                                    relativeLayout2.setVisibility(0);
                                }
                                getBinding().cartItemCoupon.setVisibility(8);
                                getBinding().placeOrderId.setVisibility(8);
                                return;
                            }
                        }
                        break;
                    case 1334579443:
                        if (apitype.equals(API.COURSE_CART_COUNT)) {
                            if (!Intrinsics.areEqual(jsonstring != null ? jsonstring.optString("status") : null, "true")) {
                                if ((jsonstring != null ? jsonstring.optString("auth_code") : null) != null) {
                                    StringsKt.equals(jsonstring.optString("auth_code"), Const.EXPIRY_AUTH_CODE, true);
                                }
                            } else if (jsonstring.has("data")) {
                                String string2 = jsonstring.getJSONObject("data").getString("total_count");
                                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                                SharedPreference.getInstance().putInt(Const.CART_COUNT, Integer.parseInt(string2));
                            }
                            break;
                        }
                        break;
                    case 1397369619:
                        if (apitype.equals(API.COURSE_REMOVE_ITEM)) {
                            try {
                                Helper.dismissProgressDialog();
                                if (StringsKt.equals$default(jsonstring != null ? jsonstring.getString("status") : null, "true", false, 2, null)) {
                                    XtensionFunctionKt.showSmallLengthToast(this, "Course Remove");
                                    NetworkCall networkCall2 = this.networkCall;
                                    if (networkCall2 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("networkCall");
                                    } else {
                                        networkCall = networkCall2;
                                    }
                                    networkCall.NetworkAPICall(API.COURSE_CART_COUNT, "", true, false);
                                    hitApiCartList(false);
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                return;
                            }
                            break;
                        }
                        break;
                    case 2002393681:
                        if (apitype.equals(API.int_payment)) {
                            if (jsonstring == null || !jsonstring.optBoolean("status")) {
                                if (this.isfailure) {
                                    this.isfailure = false;
                                    this.pos_txn_id = "";
                                }
                                MyBagActivity myBagActivity = this;
                                if (jsonstring != null && jsonstring.has("auth_code")) {
                                    string = jsonstring != null ? jsonstring.getString("auth_code") : null;
                                }
                                RetrofitResponse.GetApiData(myBagActivity, string, jsonstring != null ? jsonstring.getString("message") : null, false);
                            } else if (this.isfailure) {
                                this.isfailure = false;
                                this.pos_txn_id = "";
                            } else if (!StringsKt.equals$default(this.pos_txn_id, "", false, 2, null)) {
                                if (!SingleStudy.parentCourseId.equals("")) {
                                    UtkashRoom.getAppDatabase(MakeMyExam.getAppContext()).getCourseDetaildata().deletecoursedetail(SingleStudy.parentCourseId, MakeMyExam.userId);
                                }
                                if (jsonstring.optString("message") != null) {
                                    Toast.makeText(this, jsonstring.optString("message"), 0).show();
                                }
                                Helper.gotoActivity(this, (Class<?>) DashboardActivityTheme1.class);
                                finishAffinity();
                            } else {
                                JSONObject jSONObject = jsonstring.getJSONObject("data");
                                PaymentViewModel paymentViewModel = getPaymentViewModel();
                                if (!StringsKt.equals$default(paymentViewModel != null ? paymentViewModel.getPayVia() : null, "3", false, 2, null)) {
                                    PaymentViewModel paymentViewModel2 = getPaymentViewModel();
                                    if (!StringsKt.equals$default(paymentViewModel2 != null ? paymentViewModel2.getPayVia() : null, "6", false, 2, null)) {
                                        PaymentViewModel paymentViewModel3 = getPaymentViewModel();
                                        if (!StringsKt.equals$default(paymentViewModel3 != null ? paymentViewModel3.getPayVia() : null, "7", false, 2, null)) {
                                            PaymentViewModel paymentViewModel4 = getPaymentViewModel();
                                            Intrinsics.checkNotNull(paymentViewModel4);
                                            if (!paymentViewModel4.getPayVia().equals("8")) {
                                                PaymentViewModel paymentViewModel5 = getPaymentViewModel();
                                                Intrinsics.checkNotNull(paymentViewModel5);
                                                if (!paymentViewModel5.getPayVia().equals("9")) {
                                                    PaymentViewModel paymentViewModel6 = getPaymentViewModel();
                                                    Intrinsics.checkNotNull(paymentViewModel6);
                                                    if (paymentViewModel6.getPayVia().equals("11")) {
                                                        Intrinsics.checkNotNull(jSONObject);
                                                        paymentGateways(jSONObject, Credentials.BILLDESK);
                                                    }
                                                } else {
                                                    Intrinsics.checkNotNull(jSONObject);
                                                    paymentGateways(jSONObject, Credentials.EASEBUZZ);
                                                }
                                            } else {
                                                Intrinsics.checkNotNull(jSONObject);
                                                paymentGateways(jSONObject, Credentials.FONEPAY);
                                            }
                                        } else {
                                            Intrinsics.checkNotNull(jSONObject);
                                            paymentGateways(jSONObject, Credentials.CCAV);
                                        }
                                    } else {
                                        Intrinsics.checkNotNull(jSONObject);
                                        paymentGateways(jSONObject, Credentials.PAYTM);
                                    }
                                } else {
                                    Intrinsics.checkNotNull(jSONObject);
                                    paymentGateways(jSONObject, Credentials.RZP);
                                }
                            }
                            break;
                        }
                        break;
                }
            } catch (Exception unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void OnPaymentError() {
        try {
            this.isfailure = true;
            NetworkCall networkCall = this.networkCall;
            if (networkCall == null) {
                Intrinsics.throwUninitializedPropertyAccessException("networkCall");
                networkCall = null;
            }
            networkCall.NetworkAPICall(API.int_payment, "", true, false);
        } catch (Exception e2) {
            Log.e("onPaymentError -> ", "Exception: " + e2.getLocalizedMessage());
        }
    }

    @Override // com.appnew.android.Utils.PaymentTypeCheck
    public void onPaymentType(String mode, JSONObject data) {
        PaymentViewModel paymentViewModel;
        PaymentViewModel paymentViewModel2;
        PaymentViewModel paymentViewModel3;
        MyBagActivity myBagActivity = this;
        String stringPreference = PreferencesUtil.INSTANCE.getStringPreference(myBagActivity, Credentials.RZP);
        String stringPreference2 = PreferencesUtil.INSTANCE.getStringPreference(myBagActivity, Credentials.PAYTM);
        String stringPreference3 = PreferencesUtil.INSTANCE.getStringPreference(myBagActivity, Credentials.CCAV);
        String stringPreference4 = PreferencesUtil.INSTANCE.getStringPreference(myBagActivity, Credentials.FONEPAY);
        String stringPreference5 = PreferencesUtil.INSTANCE.getStringPreference(myBagActivity, Credentials.EASEBUZZ);
        String stringPreference6 = PreferencesUtil.INSTANCE.getStringPreference(myBagActivity, Credentials.BILLDESK);
        if (StringsKt.equals(mode, Credentials.RZP, true)) {
            if (stringPreference != null && stringPreference.length() != 0 && (paymentViewModel3 = getPaymentViewModel()) != null) {
                paymentViewModel3.setPayVia("3");
            }
        } else if (StringsKt.equals(mode, Credentials.PAYTM, true)) {
            if (stringPreference2 != null && stringPreference2.length() != 0 && (paymentViewModel2 = getPaymentViewModel()) != null) {
                paymentViewModel2.setPayVia("6");
            }
        } else if (StringsKt.equals(mode, Credentials.CCAV, true)) {
            if (stringPreference3 != null && stringPreference3.length() != 0 && (paymentViewModel = getPaymentViewModel()) != null) {
                paymentViewModel.setPayVia("7");
            }
        } else if (Intrinsics.areEqual(mode, Credentials.FONEPAY)) {
            if (stringPreference4 != null && stringPreference4.length() != 0) {
                PaymentViewModel paymentViewModel4 = getPaymentViewModel();
                Intrinsics.checkNotNull(paymentViewModel4);
                paymentViewModel4.setPayVia("8");
            }
        } else if (Intrinsics.areEqual(mode, Credentials.EASEBUZZ)) {
            if (stringPreference5 != null && stringPreference5.length() != 0) {
                PaymentViewModel paymentViewModel5 = getPaymentViewModel();
                Intrinsics.checkNotNull(paymentViewModel5);
                paymentViewModel5.setPayVia("9");
            }
        } else if (Intrinsics.areEqual(mode, Credentials.BILLDESK) && stringPreference6 != null && stringPreference6.length() != 0) {
            PaymentViewModel paymentViewModel6 = getPaymentViewModel();
            Intrinsics.checkNotNull(paymentViewModel6);
            paymentViewModel6.setPayVia("11");
        }
        NetworkCall networkCall = null;
        String strOptString = data != null ? data.optString(FirebaseAnalytics.Param.PRICE) : null;
        Intrinsics.checkNotNull(strOptString);
        this.price1 = strOptString;
        NetworkCall networkCall2 = this.networkCall;
        if (networkCall2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("networkCall");
        } else {
            networkCall = networkCall2;
        }
        networkCall.NetworkAPICall(API.int_payment, "", true, false);
    }

    @Override // com.appnew.android.Utils.PaymentTypeCheck
    public void onPaymentTypeCancel() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    private final void paymentGateways(JSONObject data, String mode) {
        try {
            this.pre_txtid = data.optString(Const.COURSE_INIT_PAYMENT_TOKEN);
            String stringPreference = PreferencesUtil.INSTANCE.getStringPreference(this, Credentials.RZP);
            String stringPreference2 = PreferencesUtil.INSTANCE.getStringPreference(this, Credentials.PAYTM);
            String stringPreference3 = PreferencesUtil.INSTANCE.getStringPreference(this, Credentials.CCAV);
            String stringPreference4 = PreferencesUtil.INSTANCE.getStringPreference(this, Credentials.FONEPAY);
            String stringPreference5 = PreferencesUtil.INSTANCE.getStringPreference(this, Credentials.EASEBUZZ);
            String stringPreference6 = PreferencesUtil.INSTANCE.getStringPreference(this, Credentials.BILLDESK);
            if (StringsKt.equals(mode, Credentials.RZP, true)) {
                if (stringPreference == null || stringPreference.length() == 0) {
                    return;
                }
                String key = ((Rzp) new Gson().fromJson(stringPreference, Rzp.class)).getKey();
                Intrinsics.checkNotNull(key);
                launch_RazorPayPaymentGateway(key);
                return;
            }
            if (StringsKt.equals(mode, Credentials.PAYTM, true)) {
                if (stringPreference2 == null || stringPreference2.length() == 0) {
                    return;
                }
                Paytm paytm2 = (Paytm) new Gson().fromJson(stringPreference2, Paytm.class);
                this.txnToken = data.optString("txnToken");
                PaymentViewModel paymentViewModel = getPaymentViewModel();
                Intrinsics.checkNotNull(paymentViewModel);
                String str = this.pre_txtid;
                int iCalculateAmount = calculateAmount();
                String str2 = this.txnToken;
                String secret = paytm2.getSecret();
                Intrinsics.checkNotNull(secret);
                String url = paytm2.getUrl();
                Intrinsics.checkNotNull(url);
                paymentViewModel.launchPaytmPaymentGateway(str, iCalculateAmount, str2, secret, url);
                return;
            }
            if (StringsKt.equals(mode, Credentials.CCAV, true)) {
                if (stringPreference3 == null || stringPreference3.length() == 0) {
                    return;
                }
                Ccav ccav = (Ccav) new Gson().fromJson(stringPreference3, Ccav.class);
                this.enc_val = data.optString("txnToken");
                PaymentViewModel paymentViewModel2 = getPaymentViewModel();
                Intrinsics.checkNotNull(paymentViewModel2);
                String str3 = this.pre_txtid;
                int iCalculateAmount2 = calculateAmount();
                String str4 = this.enc_val;
                String secret2 = ccav.getSecret();
                Intrinsics.checkNotNull(secret2);
                String redirect_url = ccav.getRedirect_url();
                Intrinsics.checkNotNull(redirect_url);
                String cancel_url = ccav.getCancel_url();
                Intrinsics.checkNotNull(cancel_url);
                String android_url = ccav.getAndroid_url();
                Intrinsics.checkNotNull(android_url);
                paymentViewModel2.launchCcAvenuePaymentGateway(str3, iCalculateAmount2, str4, secret2, redirect_url, cancel_url, android_url);
                return;
            }
            if (Intrinsics.areEqual(mode, Credentials.FONEPAY)) {
                if (stringPreference4 == null || stringPreference4.length() == 0) {
                    return;
                }
                FonePay fonePay = (FonePay) new Gson().fromJson(stringPreference4, FonePay.class);
                if ((fonePay != null ? fonePay.getStatus() : null) == null || !StringsKt.equals(fonePay.getStatus(), "1", true)) {
                    return;
                }
                String strOptString = data.optString("txnToken");
                PaymentViewModel paymentViewModel3 = getPaymentViewModel();
                Intrinsics.checkNotNull(paymentViewModel3);
                Intrinsics.checkNotNull(strOptString);
                paymentViewModel3.launchFonePayPaymentGateway(strOptString, calculateAmount());
                return;
            }
            if (Intrinsics.areEqual(mode, Credentials.EASEBUZZ)) {
                if (stringPreference5 == null || stringPreference5.length() == 0) {
                    return;
                }
                EaseBuzz easeBuzz = (EaseBuzz) new Gson().fromJson(stringPreference5, EaseBuzz.class);
                if ((easeBuzz != null ? easeBuzz.getStatus() : null) == null || !StringsKt.equals(easeBuzz.getStatus(), "1", true)) {
                    return;
                }
                String strOptString2 = data.optString("txnToken");
                PaymentViewModel paymentViewModel4 = getPaymentViewModel();
                Intrinsics.checkNotNull(paymentViewModel4);
                Intrinsics.checkNotNull(strOptString2);
                int iCalculateAmount3 = calculateAmount();
                String mode2 = easeBuzz.getMode();
                Intrinsics.checkNotNull(mode2);
                paymentViewModel4.launchEaseBuzzPaymentGateway(strOptString2, iCalculateAmount3, mode2);
                return;
            }
            if (!Intrinsics.areEqual(mode, Credentials.BILLDESK) || stringPreference6 == null || stringPreference6.length() == 0) {
                return;
            }
            BillDesk billDesk = (BillDesk) new Gson().fromJson(stringPreference6, BillDesk.class);
            if ((billDesk != null ? billDesk.getStatus() : null) == null || !StringsKt.equals(billDesk.getStatus(), "1", true)) {
                return;
            }
            String strOptString3 = data.optString("txnToken");
            PaymentViewModel paymentViewModel5 = getPaymentViewModel();
            Intrinsics.checkNotNull(paymentViewModel5);
            Intrinsics.checkNotNull(strOptString3);
            paymentViewModel5.launchBillDeskPaymentGateway(strOptString3, calculateAmount());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final int calculateAmount() {
        return Math.round(Float.parseFloat(this.price1));
    }

    private final void launch_RazorPayPaymentGateway(String key) {
        Checkout checkout = new Checkout();
        checkout.setKeyID(key);
        checkout.setImage(R.mipmap.ic_launcher);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", getResources().getString(R.string.payment_gateway_name));
            jSONObject.put("theme.color", ContextCompat.getColor(this, R.color.theme_and_header_color));
            jSONObject.put(FirebaseAnalytics.Param.CURRENCY, "INR");
            jSONObject.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.jpg");
            jSONObject.put("order_id", this.pre_txtid);
            jSONObject.put("amount", Math.round(Float.parseFloat(this.price1) * 100));
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
}
