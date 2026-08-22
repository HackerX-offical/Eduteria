package com.appnew.android.Payment;

import android.content.Intent;
import android.content.res.Resources;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.appnew.android.Coupon.Models.CoursesCoupon;
import com.appnew.android.Courses.Fragment.SingleStudy;
import com.appnew.android.Model.COURSEDETAIL.CourseDetail;
import com.appnew.android.Model.COURSEDETAIL.CourseDetailData;
import com.appnew.android.Model.COURSEDETAIL.Data;
import com.appnew.android.Payment.easy_pay.EasyPayCheckout;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.SharedPreference;
import com.eduteria.app.app.R;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.paytm.pgsdk.PaytmConstants;
import com.razorpay.Checkout;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PaymentViewModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001f\u001a\u00020 J\u001e\u0010!\u001a\u00020 2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010$\u001a\u00020 2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010%\u001a\u00020 2\u0006\u0010\"\u001a\u00020#J.\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007J>\u0010-\u001a\u00020 2\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020)2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0007J\u0016\u00103\u001a\u00020 2\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020)JF\u00104\u001a\u00020 2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u0002092\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010>\u001a\u00020\u0007J\u0016\u0010?\u001a\u00020 2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010(\u001a\u00020)J\u001e\u0010A\u001a\u00020 2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010(\u001a\u00020)2\u0006\u0010B\u001a\u00020\u0007J\u0016\u0010C\u001a\u00020 2\u0006\u0010*\u001a\u00020\u00072\u0006\u0010(\u001a\u00020)J\u0016\u0010D\u001a\u00020 2\u0006\u0010E\u001a\u00020\u00072\u0006\u0010(\u001a\u00020)J\b\u0010F\u001a\u00020 H\u0014R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R#\u0010\u0018\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c¨\u0006G"}, d2 = {"Lcom/appnew/android/Payment/PaymentViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "course_id", "", "resultLauncherPaytm", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "resultLauncherCCAvenue", "resultLauncherFonePay", "resultLauncherEaseBuzz", "resultLauncherESewa", "resultLauncherBillDesk", "resultLauncherWorldLine", "resultLauncherEasyPay", "payVia", "getPayVia", "()Ljava/lang/String;", "setPayVia", "(Ljava/lang/String;)V", "TAG", "webService", "Lcom/appnew/android/Utils/Network/APIInterface;", "kotlin.jvm.PlatformType", "getWebService", "()Lcom/appnew/android/Utils/Network/APIInterface;", "webService$delegate", "Lkotlin/Lazy;", "getPaymentCredentials", "", "initPaymentGateway", "paymentGatewayListener", "Lcom/appnew/android/Payment/PaymentGatewayListener;", "setCourseId", "registers", "launchPaytmPaymentGateway", "pre_txtid", "amount", "", "txnToken", "mid", "url", "launchCcAvenuePaymentGateway", "enc_val", "access_code", "redirect_url", "cancel_url", "post_url", "launchESewaPaymentGateway", "launchRazorPayPaymentGateway", "data", "Lorg/json/JSONObject;", "withCouponLayout", "", "", "coursesCoupon", "Lcom/appnew/android/Coupon/Models/CoursesCoupon;", "courseDetail", "Lcom/appnew/android/Model/COURSEDETAIL/CourseDetail;", "razorpayKey", "launchFonePayPaymentGateway", "fonePayUrl", "launchEaseBuzzPaymentGateway", "mode", "launchBillDeskPaymentGateway", "launchEasyPayPaymentGateway", "easyPayUrl", "onCleared", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PaymentViewModel extends ViewModel {
    public static final int $stable = 8;
    private AppCompatActivity activity;
    private ActivityResultLauncher<Intent> resultLauncherBillDesk;
    private ActivityResultLauncher<Intent> resultLauncherCCAvenue;
    private ActivityResultLauncher<Intent> resultLauncherESewa;
    private ActivityResultLauncher<Intent> resultLauncherEaseBuzz;
    private ActivityResultLauncher<Intent> resultLauncherEasyPay;
    private ActivityResultLauncher<Intent> resultLauncherFonePay;
    private ActivityResultLauncher<Intent> resultLauncherPaytm;
    private ActivityResultLauncher<Intent> resultLauncherWorldLine;
    private String course_id = "";
    private String payVia = "3";
    private final String TAG = "PaymentViewModel";

    /* JADX INFO: renamed from: webService$delegate, reason: from kotlin metadata */
    private final Lazy webService = LazyKt.lazy(new Function0() { // from class: com.appnew.android.Payment.PaymentViewModel$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return PaymentViewModel.webService_delegate$lambda$0();
        }
    });

    public final String getPayVia() {
        return this.payVia;
    }

    public final void setPayVia(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.payVia = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final APIInterface getWebService() {
        return (APIInterface) this.webService.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final APIInterface webService_delegate$lambda$0() {
        return (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
    }

    /* JADX INFO: renamed from: com.appnew.android.Payment.PaymentViewModel$getPaymentCredentials$1, reason: invalid class name */
    /* JADX INFO: compiled from: PaymentViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.Payment.PaymentViewModel$getPaymentCredentials$1", f = "PaymentViewModel.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaymentViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x00ab A[Catch: Exception -> 0x0376, TryCatch #0 {Exception -> 0x0376, blocks: (B:5:0x0022, B:15:0x0067, B:17:0x006b, B:19:0x00ab, B:21:0x00c1, B:23:0x00c7, B:25:0x00d5, B:27:0x00db, B:29:0x00e9, B:31:0x00ef, B:33:0x00fd, B:35:0x0103, B:37:0x0113, B:39:0x0119, B:41:0x0129, B:43:0x012f, B:45:0x013f, B:47:0x0145, B:49:0x0155, B:51:0x015b, B:53:0x016b, B:55:0x0171, B:58:0x018c, B:60:0x0192, B:62:0x0198, B:64:0x01af, B:66:0x01b5, B:68:0x01bb, B:70:0x01c8, B:72:0x01ce, B:74:0x01d4, B:76:0x01e9, B:78:0x01ef, B:79:0x01f2, B:81:0x01ff, B:83:0x0205, B:85:0x020b, B:87:0x0220, B:89:0x0226, B:90:0x0229, B:92:0x0236, B:94:0x023c, B:96:0x0242, B:98:0x0257, B:100:0x025d, B:101:0x0260, B:103:0x026d, B:105:0x0273, B:107:0x0279, B:109:0x028e, B:111:0x0294, B:112:0x0297, B:114:0x02a4, B:116:0x02aa, B:118:0x02b0, B:120:0x02c5, B:122:0x02cb, B:123:0x02ce, B:125:0x02db, B:127:0x02e1, B:129:0x02e7, B:131:0x02fc, B:133:0x0302, B:134:0x0305, B:136:0x0312, B:138:0x0318, B:140:0x031e, B:142:0x0333, B:144:0x0339, B:145:0x033c, B:147:0x0349, B:149:0x034f, B:151:0x0355, B:153:0x036a, B:155:0x0370, B:156:0x0373, B:10:0x0033, B:12:0x005b), top: B:161:0x001e }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r23) {
            /*
                Method dump skipped, instruction units count: 889
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Payment.PaymentViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void getPaymentCredentials() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(null), 2, null);
    }

    public final void initPaymentGateway(AppCompatActivity activity, PaymentGatewayListener paymentGatewayListener, String course_id) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(paymentGatewayListener, "paymentGatewayListener");
        Intrinsics.checkNotNullParameter(course_id, "course_id");
        this.activity = activity;
        this.course_id = course_id;
        PreferencesUtil.INSTANCE.removeAllCredentials(activity);
        registers(paymentGatewayListener);
    }

    public final void setCourseId(String course_id) {
        Intrinsics.checkNotNullParameter(course_id, "course_id");
        this.course_id = course_id;
        getPaymentCredentials();
    }

    public final void registers(final PaymentGatewayListener paymentGatewayListener) {
        Intrinsics.checkNotNullParameter(paymentGatewayListener, "paymentGatewayListener");
        AppCompatActivity appCompatActivity = this.activity;
        this.resultLauncherPaytm = appCompatActivity != null ? appCompatActivity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.Payment.PaymentViewModel$$ExternalSyntheticLambda2
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PaymentViewModel.registers$lambda$1(paymentGatewayListener, (ActivityResult) obj);
            }
        }) : null;
        AppCompatActivity appCompatActivity2 = this.activity;
        this.resultLauncherCCAvenue = appCompatActivity2 != null ? appCompatActivity2.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.Payment.PaymentViewModel$$ExternalSyntheticLambda3
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PaymentViewModel.registers$lambda$2(paymentGatewayListener, this, (ActivityResult) obj);
            }
        }) : null;
        AppCompatActivity appCompatActivity3 = this.activity;
        this.resultLauncherESewa = appCompatActivity3 != null ? appCompatActivity3.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.Payment.PaymentViewModel$$ExternalSyntheticLambda4
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PaymentViewModel.registers$lambda$3(paymentGatewayListener, (ActivityResult) obj);
            }
        }) : null;
        AppCompatActivity appCompatActivity4 = this.activity;
        this.resultLauncherFonePay = appCompatActivity4 != null ? appCompatActivity4.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.Payment.PaymentViewModel$$ExternalSyntheticLambda5
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PaymentViewModel.registers$lambda$5(this.f$0, paymentGatewayListener, (ActivityResult) obj);
            }
        }) : null;
        AppCompatActivity appCompatActivity5 = this.activity;
        this.resultLauncherEaseBuzz = appCompatActivity5 != null ? appCompatActivity5.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.Payment.PaymentViewModel$$ExternalSyntheticLambda6
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PaymentViewModel.registers$lambda$6(paymentGatewayListener, (ActivityResult) obj);
            }
        }) : null;
        AppCompatActivity appCompatActivity6 = this.activity;
        this.resultLauncherBillDesk = appCompatActivity6 != null ? appCompatActivity6.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.Payment.PaymentViewModel$$ExternalSyntheticLambda7
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PaymentViewModel.registers$lambda$7(paymentGatewayListener, (ActivityResult) obj);
            }
        }) : null;
        AppCompatActivity appCompatActivity7 = this.activity;
        this.resultLauncherWorldLine = appCompatActivity7 != null ? appCompatActivity7.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.Payment.PaymentViewModel$$ExternalSyntheticLambda8
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                Intrinsics.checkNotNullParameter((ActivityResult) obj, "result");
            }
        }) : null;
        AppCompatActivity appCompatActivity8 = this.activity;
        this.resultLauncherEasyPay = appCompatActivity8 != null ? appCompatActivity8.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.Payment.PaymentViewModel$$ExternalSyntheticLambda9
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PaymentViewModel.registers$lambda$10(this.f$0, paymentGatewayListener, (ActivityResult) obj);
            }
        }) : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registers$lambda$1(PaymentGatewayListener paymentGatewayListener, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == 100) {
            Intent data = result.getData();
            if ((data != null ? data.getStringExtra(PaytmConstants.TRANSACTION_ID) : null) != null) {
                Intent data2 = result.getData();
                paymentGatewayListener.onSuccess(data2 != null ? data2.getStringExtra(PaytmConstants.TRANSACTION_ID) : null);
                return;
            }
            return;
        }
        if (result.getResultCode() == 101) {
            try {
                paymentGatewayListener.onFailed(true);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registers$lambda$2(PaymentGatewayListener paymentGatewayListener, PaymentViewModel paymentViewModel, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            Intent data = result.getData();
            String stringExtra = data != null ? data.getStringExtra("result") : null;
            if (stringExtra == null || stringExtra.length() <= 0) {
                return;
            }
            new PaymentViewModel$registers$2$1(stringExtra, paymentViewModel, paymentGatewayListener).start();
            return;
        }
        try {
            paymentGatewayListener.onFailed(true);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registers$lambda$3(PaymentGatewayListener paymentGatewayListener, ActivityResult result) {
        String str;
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == 10011) {
            try {
                Intent data = result.getData();
                String stringExtra = data != null ? data.getStringExtra("result") : null;
                Intrinsics.checkNotNull(stringExtra);
                JSONObject jSONObject = new JSONObject(stringExtra);
                String string = jSONObject.getString("productId");
                String string2 = jSONObject.getString("totalAmount");
                String string3 = jSONObject.getJSONObject("transactionDetails").getString("referenceId");
                if (StringsKt.equals(jSONObject.getString("environment"), Const.TEST, true)) {
                    str = "EPAYTEST";
                } else {
                    str = "NP-ES-SRAADVISORY";
                }
                Intrinsics.checkNotNull(string);
                Intrinsics.checkNotNull(string2);
                Intrinsics.checkNotNull(string3);
                paymentGatewayListener.onSuccessEsewa(string, string2, string3, str);
                return;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return;
            }
        }
        try {
            paymentGatewayListener.onFailed(true);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registers$lambda$5(PaymentViewModel paymentViewModel, final PaymentGatewayListener paymentGatewayListener, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        try {
            if (result.getResultCode() == -1) {
                Intent data = result.getData();
                String stringExtra = data != null ? data.getStringExtra("status") : null;
                Intent data2 = result.getData();
                final String stringExtra2 = data2 != null ? data2.getStringExtra("post_txn_id") : null;
                if (StringsKt.equals$default(stringExtra, "true", false, 2, null)) {
                    AppCompatActivity appCompatActivity = paymentViewModel.activity;
                    if (appCompatActivity != null) {
                        appCompatActivity.runOnUiThread(new Runnable() { // from class: com.appnew.android.Payment.PaymentViewModel$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                paymentGatewayListener.onSuccess(stringExtra2);
                            }
                        });
                        return;
                    }
                    return;
                }
                paymentGatewayListener.onFailed(true);
                return;
            }
            paymentGatewayListener.onFailed(true);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registers$lambda$6(PaymentGatewayListener paymentGatewayListener, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == 100) {
            Intent data = result.getData();
            if ((data != null ? data.getStringExtra(PaytmConstants.TRANSACTION_ID) : null) != null) {
                Intent data2 = result.getData();
                paymentGatewayListener.onSuccess(data2 != null ? data2.getStringExtra(PaytmConstants.TRANSACTION_ID) : null);
                return;
            }
            return;
        }
        if (result.getResultCode() == 101) {
            try {
                paymentGatewayListener.onFailed(true);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registers$lambda$7(PaymentGatewayListener paymentGatewayListener, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        try {
            String string = SharedPreference.getInstance().getString("paymentResult");
            List listSplit$default = string != null ? StringsKt.split$default((CharSequence) string, new String[]{"|"}, false, 0, 6, (Object) null) : null;
            String str = listSplit$default != null ? (String) listSplit$default.get(2) : null;
            if (StringsKt.equals(listSplit$default != null ? (String) listSplit$default.get(14) : null, "0300", true)) {
                paymentGatewayListener.onSuccess(str);
            } else {
                try {
                    paymentGatewayListener.onFailed(true);
                } catch (Exception unused) {
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        SharedPreference.getInstance().remove("paymentResult");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registers$lambda$10(PaymentViewModel paymentViewModel, final PaymentGatewayListener paymentGatewayListener, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        try {
            if (result.getResultCode() == -1) {
                Intent data = result.getData();
                String stringExtra = data != null ? data.getStringExtra("status") : null;
                Intent data2 = result.getData();
                final String stringExtra2 = data2 != null ? data2.getStringExtra("post_txn_id") : null;
                if (StringsKt.equals$default(stringExtra, "true", false, 2, null)) {
                    AppCompatActivity appCompatActivity = paymentViewModel.activity;
                    if (appCompatActivity != null) {
                        appCompatActivity.runOnUiThread(new Runnable() { // from class: com.appnew.android.Payment.PaymentViewModel$$ExternalSyntheticLambda10
                            @Override // java.lang.Runnable
                            public final void run() {
                                paymentGatewayListener.onSuccess(stringExtra2);
                            }
                        });
                        return;
                    }
                    return;
                }
                paymentGatewayListener.onFailed(true);
                return;
            }
            paymentGatewayListener.onFailed(true);
        } catch (Exception unused) {
        }
    }

    public final void launchPaytmPaymentGateway(String pre_txtid, int amount, String txnToken, String mid, String url) {
        Resources resources;
        Intrinsics.checkNotNullParameter(pre_txtid, "pre_txtid");
        Intrinsics.checkNotNullParameter(txnToken, "txnToken");
        Intrinsics.checkNotNullParameter(mid, "mid");
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            Intent intent = new Intent(this.activity, Class.forName("com.example.paytm_gateway.PaytmPaymentActivity"));
            AppCompatActivity appCompatActivity = this.activity;
            intent.putExtra("name", (appCompatActivity == null || (resources = appCompatActivity.getResources()) == null) ? null : resources.getString(R.string.payment_gateway_name));
            intent.putExtra("pre_txtid", pre_txtid);
            intent.putExtra("amount", amount);
            intent.putExtra("txnToken", txnToken);
            intent.putExtra("mid", mid);
            intent.putExtra("url", url);
            ActivityResultLauncher<Intent> activityResultLauncher = this.resultLauncherPaytm;
            if (activityResultLauncher != null) {
                activityResultLauncher.launch(intent);
            }
        } catch (Exception unused) {
        }
    }

    public final void launchCcAvenuePaymentGateway(String pre_txtid, int amount, String enc_val, String access_code, String redirect_url, String cancel_url, String post_url) {
        Resources resources;
        Intrinsics.checkNotNullParameter(pre_txtid, "pre_txtid");
        Intrinsics.checkNotNullParameter(enc_val, "enc_val");
        Intrinsics.checkNotNullParameter(access_code, "access_code");
        Intrinsics.checkNotNullParameter(redirect_url, "redirect_url");
        Intrinsics.checkNotNullParameter(cancel_url, "cancel_url");
        Intrinsics.checkNotNullParameter(post_url, "post_url");
        try {
            Intent intent = new Intent(this.activity, Class.forName("com.yaman.cc_avanue_gateway.activity.CCAvenueActivity"));
            AppCompatActivity appCompatActivity = this.activity;
            intent.putExtra("name", (appCompatActivity == null || (resources = appCompatActivity.getResources()) == null) ? null : resources.getString(R.string.payment_gateway_name));
            intent.putExtra("amount", amount);
            intent.putExtra("order_id", pre_txtid);
            intent.putExtra("enc_val", enc_val);
            intent.putExtra("access_code", access_code);
            intent.putExtra("redirect_url", redirect_url);
            intent.putExtra("cancel_url", cancel_url);
            intent.putExtra("post_url", post_url);
            ActivityResultLauncher<Intent> activityResultLauncher = this.resultLauncherCCAvenue;
            if (activityResultLauncher != null) {
                activityResultLauncher.launch(intent);
            }
        } catch (Exception unused) {
        }
    }

    public final void launchESewaPaymentGateway(String pre_txtid, int amount) {
        Resources resources;
        Intrinsics.checkNotNullParameter(pre_txtid, "pre_txtid");
        try {
            Intent intent = new Intent(this.activity, Class.forName("com.yaman.esewa_payment_gateway.EsewaPaymentActivity"));
            AppCompatActivity appCompatActivity = this.activity;
            intent.putExtra("name", (appCompatActivity == null || (resources = appCompatActivity.getResources()) == null) ? null : resources.getString(R.string.payment_gateway_name));
            intent.putExtra("pre_txtid", pre_txtid);
            intent.putExtra("amount", amount);
            ActivityResultLauncher<Intent> activityResultLauncher = this.resultLauncherESewa;
            if (activityResultLauncher != null) {
                activityResultLauncher.launch(intent);
            }
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ void launchRazorPayPaymentGateway$default(PaymentViewModel paymentViewModel, JSONObject jSONObject, boolean z, String str, long j, CoursesCoupon coursesCoupon, CourseDetail courseDetail, String str2, int i, Object obj) {
        if ((i & 16) != 0) {
            coursesCoupon = null;
        }
        if ((i & 32) != 0) {
            courseDetail = null;
        }
        paymentViewModel.launchRazorPayPaymentGateway(jSONObject, z, str, j, coursesCoupon, courseDetail, str2);
    }

    public final void launchRazorPayPaymentGateway(JSONObject data, boolean withCouponLayout, String pre_txtid, long amount, CoursesCoupon coursesCoupon, CourseDetail courseDetail, String razorpayKey) {
        String id;
        Data data2;
        CourseDetailData courseDetail2;
        Data data3;
        CourseDetailData courseDetail3;
        Data data4;
        CourseDetailData courseDetail4;
        Resources resources;
        String id2;
        Resources resources2;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(pre_txtid, "pre_txtid");
        Intrinsics.checkNotNullParameter(razorpayKey, "razorpayKey");
        try {
            if (withCouponLayout) {
                Checkout checkout = new Checkout();
                checkout.setKeyID(razorpayKey);
                checkout.setImage(R.mipmap.ic_launcher);
                JSONObject jSONObject = new JSONObject();
                AppCompatActivity appCompatActivity = this.activity;
                jSONObject.put("name", (appCompatActivity == null || (resources2 = appCompatActivity.getResources()) == null) ? null : resources2.getString(R.string.payment_gateway_name));
                AppCompatActivity appCompatActivity2 = this.activity;
                Intrinsics.checkNotNull(appCompatActivity2);
                jSONObject.put("theme.color", ContextCompat.getColor(appCompatActivity2, R.color.theme_and_header_color));
                String title = coursesCoupon != null ? coursesCoupon.getTitle() : null;
                if (StringsKt.equals(SingleStudy.parentCourseId, "", true)) {
                    id2 = coursesCoupon != null ? coursesCoupon.getId() : null;
                } else {
                    id2 = SingleStudy.parentCourseId;
                }
                jSONObject.put("description", title + " #(" + id2 + ")");
                jSONObject.put(FirebaseAnalytics.Param.CURRENCY, "INR");
                jSONObject.put("image", coursesCoupon != null ? coursesCoupon.getCover_image() : null);
                if (data.has("is_subscription") && data.getBoolean("is_subscription")) {
                    jSONObject.put("subscription_id", pre_txtid);
                } else {
                    jSONObject.put("order_id", pre_txtid);
                    jSONObject.put("amount", amount);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("email", "true");
                jSONObject2.put("contact", "true");
                jSONObject.put("readonly", jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("email", SharedPreference.getInstance().getLoggedInUser().getEmail());
                jSONObject3.put("contact", SharedPreference.getInstance().getLoggedInUser().getMobile());
                jSONObject.put("prefill", jSONObject3);
                checkout.open(this.activity, jSONObject);
                return;
            }
            Checkout checkout2 = new Checkout();
            checkout2.setKeyID(razorpayKey);
            checkout2.setImage(R.mipmap.ic_launcher);
            JSONObject jSONObject4 = new JSONObject();
            AppCompatActivity appCompatActivity3 = this.activity;
            jSONObject4.put("name", (appCompatActivity3 == null || (resources = appCompatActivity3.getResources()) == null) ? null : resources.getString(R.string.payment_gateway_name));
            AppCompatActivity appCompatActivity4 = this.activity;
            Intrinsics.checkNotNull(appCompatActivity4);
            jSONObject4.put("theme.color", ContextCompat.getColor(appCompatActivity4, R.color.theme_and_header_color));
            String title2 = (courseDetail == null || (data4 = courseDetail.getData()) == null || (courseDetail4 = data4.getCourseDetail()) == null) ? null : courseDetail4.getTitle();
            if (StringsKt.equals(SingleStudy.parentCourseId, "", true)) {
                id = (courseDetail == null || (data2 = courseDetail.getData()) == null || (courseDetail2 = data2.getCourseDetail()) == null) ? null : courseDetail2.getId();
            } else {
                id = SingleStudy.parentCourseId;
            }
            jSONObject4.put("description", title2 + " #(" + id + ")");
            jSONObject4.put(FirebaseAnalytics.Param.CURRENCY, "INR");
            if (courseDetail != null && (data3 = courseDetail.getData()) != null && (courseDetail3 = data3.getCourseDetail()) != null) {
                descHeaderImage = courseDetail3.getDescHeaderImage();
            }
            jSONObject4.put("image", descHeaderImage);
            if (data.has("is_subscription") && data.getBoolean("is_subscription")) {
                jSONObject4.put("subscription_id", pre_txtid);
            } else {
                jSONObject4.put("order_id", pre_txtid);
                jSONObject4.put("amount", amount);
            }
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("email", "true");
            jSONObject5.put("contact", "true");
            jSONObject4.put("readonly", jSONObject5);
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("email", SharedPreference.getInstance().getLoggedInUser().getEmail());
            jSONObject6.put("contact", SharedPreference.getInstance().getLoggedInUser().getMobile());
            jSONObject4.put("prefill", jSONObject6);
            checkout2.open(this.activity, jSONObject4);
        } catch (Exception unused) {
        }
    }

    public final void launchFonePayPaymentGateway(String fonePayUrl, int amount) {
        Resources resources;
        Intrinsics.checkNotNullParameter(fonePayUrl, "fonePayUrl");
        Intent intent = new Intent(this.activity, Class.forName("com.appnew.android.fonepay.FonePayCheckout"));
        AppCompatActivity appCompatActivity = this.activity;
        intent.putExtra("name", (appCompatActivity == null || (resources = appCompatActivity.getResources()) == null) ? null : resources.getString(R.string.payment_gateway_name));
        intent.putExtra("amount", amount);
        intent.putExtra("fonePayUrl", fonePayUrl);
        intent.putExtra("url", fonePayUrl);
        ActivityResultLauncher<Intent> activityResultLauncher = this.resultLauncherFonePay;
        if (activityResultLauncher != null) {
            activityResultLauncher.launch(intent);
        }
    }

    public final void launchEaseBuzzPaymentGateway(String access_code, int amount, String mode) {
        Resources resources;
        Intrinsics.checkNotNullParameter(access_code, "access_code");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intent intent = new Intent(this.activity, Class.forName("com.example.easybuzz_payment_gateway.EaseBuzzPaymentActivity"));
        AppCompatActivity appCompatActivity = this.activity;
        intent.putExtra("name", (appCompatActivity == null || (resources = appCompatActivity.getResources()) == null) ? null : resources.getString(R.string.payment_gateway_name));
        intent.putExtra("amount", amount);
        intent.putExtra("mode", mode);
        intent.putExtra("access_code", access_code);
        ActivityResultLauncher<Intent> activityResultLauncher = this.resultLauncherEaseBuzz;
        if (activityResultLauncher != null) {
            activityResultLauncher.launch(intent);
        }
    }

    public final void launchBillDeskPaymentGateway(String txnToken, int amount) {
        Resources resources;
        Intrinsics.checkNotNullParameter(txnToken, "txnToken");
        Intent intent = new Intent(this.activity, Class.forName("com.appnew.android.Payment.billdesk_payment_gateway.BillDeskPaymentScreen"));
        AppCompatActivity appCompatActivity = this.activity;
        intent.putExtra("name", (appCompatActivity == null || (resources = appCompatActivity.getResources()) == null) ? null : resources.getString(R.string.payment_gateway_name));
        intent.putExtra("amount", amount);
        intent.putExtra("txnToken", txnToken);
        ActivityResultLauncher<Intent> activityResultLauncher = this.resultLauncherBillDesk;
        if (activityResultLauncher != null) {
            activityResultLauncher.launch(intent);
        }
    }

    public final void launchEasyPayPaymentGateway(String easyPayUrl, int amount) {
        Resources resources;
        Intrinsics.checkNotNullParameter(easyPayUrl, "easyPayUrl");
        Intent intent = new Intent(this.activity, (Class<?>) EasyPayCheckout.class);
        AppCompatActivity appCompatActivity = this.activity;
        intent.putExtra("name", (appCompatActivity == null || (resources = appCompatActivity.getResources()) == null) ? null : resources.getString(R.string.payment_gateway_name));
        intent.putExtra("amount", amount);
        intent.putExtra("easyPayUrl", easyPayUrl);
        ActivityResultLauncher<Intent> activityResultLauncher = this.resultLauncherEasyPay;
        if (activityResultLauncher != null) {
            activityResultLauncher.launch(intent);
        }
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.activity = null;
    }
}
