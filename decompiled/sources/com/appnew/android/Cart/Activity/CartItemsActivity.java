package com.appnew.android.Cart.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.BuildConfig;
import com.appnew.android.Cart.Adapter.CartItemAdapter;
import com.appnew.android.Cart.Interface.CartItemClick;
import com.appnew.android.Courses.Fragment.SingleStudy;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.BillDesk;
import com.appnew.android.Model.BottomSetting;
import com.appnew.android.Model.CartModel.CartData;
import com.appnew.android.Model.CartModel.CartItemDetail;
import com.appnew.android.Model.CartModel.CartItemModel;
import com.appnew.android.Model.CartModel.CourseLisDetail;
import com.appnew.android.Model.CartModel.Data;
import com.appnew.android.Model.Ccav;
import com.appnew.android.Model.Extras;
import com.appnew.android.Model.FonePay;
import com.appnew.android.Model.LeftMenu;
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
import com.appnew.android.Webview.WebViewActivty;
import com.appnew.android.Zoom.Activity.AllDoubtsFragmentKt;
import com.appnew.android.databinding.ActivityCartItemsBinding;
import com.appnew.android.table.ThemeSettings;
import com.eduteria.app.app.R;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: CartItemsActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010}\u001a\u00020~2\t\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u0001H\u0014J&\u0010\u0081\u0001\u001a\u00020~2\u0007\u0010\u0082\u0001\u001a\u00020\u00152\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u00152\u0007\u0010\u0084\u0001\u001a\u00020\u0015H\u0002J\u0012\u0010\u0085\u0001\u001a\u00020~2\u0007\u0010\u0086\u0001\u001a\u00020OH\u0002J4\u0010\u0087\u0001\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0088\u00012\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u00152\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00152\b\u0010\u008b\u0001\u001a\u00030\u008c\u0001H\u0016J2\u0010\u008d\u0001\u001a\u00020~2\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u00152\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00152\u0007\u0010\u0090\u0001\u001a\u00020OH\u0017J*\u0010\u0091\u0001\u001a\u00020~2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u00152\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u00152\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0015H\u0016J\u001c\u0010\u0092\u0001\u001a\u00020~2\b\u0010\u0093\u0001\u001a\u00030\u008f\u00012\u0007\u0010\u0094\u0001\u001a\u00020\u0015H\u0002J\n\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u0002J\"\u0010\u0097\u0001\u001a\u00020~2\u0017\u0010\u0098\u0001\u001a\u0012\u0012\u0004\u0012\u00020*0)j\b\u0012\u0004\u0012\u00020*`+H\u0002J\u0012\u0010\u0099\u0001\u001a\u00020~2\u0007\u0010\u009a\u0001\u001a\u00020\u0015H\u0002J\u0012\u0010\u009b\u0001\u001a\u00020~2\u0007\u0010\u009c\u0001\u001a\u00020\u0015H\u0016J\u001e\u0010\u009d\u0001\u001a\u00020~2\b\u0010\u009e\u0001\u001a\u00030\u0096\u00012\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0015H\u0016J\t\u0010\u009f\u0001\u001a\u00020~H\u0002J\t\u0010 \u0001\u001a\u00020~H\u0002J\t\u0010¡\u0001\u001a\u00020~H\u0002J\u001e\u0010¢\u0001\u001a\u00020~2\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u00152\b\u0010\u0093\u0001\u001a\u00030\u008f\u0001H\u0016J\t\u0010£\u0001\u001a\u00020~H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R.\u0010(\u001a\u0016\u0012\u0004\u0012\u00020*\u0018\u00010)j\n\u0012\u0004\u0012\u00020*\u0018\u0001`+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u00105\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00102\"\u0004\b=\u00104R\u001a\u0010>\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u00102\"\u0004\b@\u00104R\u000e\u0010A\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010B\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u00102\"\u0004\bD\u00104R\u001c\u0010E\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u00102\"\u0004\bG\u00104R\u001c\u0010H\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u00102\"\u0004\bJ\u00104R\u001c\u0010K\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u00102\"\u0004\bM\u00104R\u001a\u0010N\u001a\u00020OX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001a\u0010T\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u00102\"\u0004\bV\u00104R\u001a\u0010W\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u00102\"\u0004\bY\u00104R\u001c\u0010Z\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u00102\"\u0004\b\\\u00104R\u001c\u0010]\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u00102\"\u0004\b_\u00104R\u001c\u0010`\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u00102\"\u0004\bb\u00104R\u000e\u0010c\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010e\u001a\u00020fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u001a\u0010k\u001a\u00020lX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u001a\u0010q\u001a\u00020rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u001c\u0010w\u001a\u0004\u0018\u00010xX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010z\"\u0004\b{\u0010|¨\u0006¤\u0001"}, d2 = {"Lcom/appnew/android/Cart/Activity/CartItemsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "Lcom/razorpay/PaymentResultListener;", "Lcom/appnew/android/Utils/PaymentTypeCheck;", "<init>", "()V", "leftMenu", "Lcom/appnew/android/Model/LeftMenu;", "binding", "Lcom/appnew/android/databinding/ActivityCartItemsBinding;", "getBinding", "()Lcom/appnew/android/databinding/ActivityCartItemsBinding;", "setBinding", "(Lcom/appnew/android/databinding/ActivityCartItemsBinding;)V", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "cartItemAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/Cart/Adapter/CartItemAdapter$ViewHolder;", "courseId", "", "paginationLoader", "Landroid/widget/ProgressBar;", "getPaginationLoader", "()Landroid/widget/ProgressBar;", "setPaginationLoader", "(Landroid/widget/ProgressBar;)V", "cartItemDetail", "Lcom/appnew/android/Model/CartModel/CartItemDetail;", "getCartItemDetail", "()Lcom/appnew/android/Model/CartModel/CartItemDetail;", "setCartItemDetail", "(Lcom/appnew/android/Model/CartModel/CartItemDetail;)V", "courseLisDetail", "Lcom/appnew/android/Model/CartModel/CourseLisDetail;", "getCourseLisDetail", "()Lcom/appnew/android/Model/CartModel/CourseLisDetail;", "setCourseLisDetail", "(Lcom/appnew/android/Model/CartModel/CourseLisDetail;)V", "cartItemModelArray", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/CartModel/CartItemModel;", "Lkotlin/collections/ArrayList;", "getCartItemModelArray", "()Ljava/util/ArrayList;", "setCartItemModelArray", "(Ljava/util/ArrayList;)V", Const.RATINGS, "getRating", "()Ljava/lang/String;", "setRating", "(Ljava/lang/String;)V", "itemClickListener", "Lcom/appnew/android/Cart/Interface/CartItemClick;", "getItemClickListener", "()Lcom/appnew/android/Cart/Interface/CartItemClick;", "setItemClickListener", "(Lcom/appnew/android/Cart/Interface/CartItemClick;)V", "maincouseid", "getMaincouseid", "setMaincouseid", "calculatedTax", "getCalculatedTax", "setCalculatedTax", "txnToken", "enc_val", "getEnc_val", "setEnc_val", "rid", "getRid", "setRid", "amt", "getAmt", "setAmt", "scd", "getScd", "setScd", "isfailure", "", "getIsfailure", "()Z", "setIsfailure", "(Z)V", "coursePrice", "getCoursePrice", "setCoursePrice", "price1", "getPrice1", "setPrice1", "id1", "getId1", "setId1", "remark1", "getRemark1", "setRemark1", "pos_txn_id", "getPos_txn_id", "setPos_txn_id", "pre_txtid", "tx_status", "bottomSetting", "Lcom/appnew/android/Model/BottomSetting;", "getBottomSetting", "()Lcom/appnew/android/Model/BottomSetting;", "setBottomSetting", "(Lcom/appnew/android/Model/BottomSetting;)V", "themeSettings", "Lcom/appnew/android/table/ThemeSettings;", "getThemeSettings", "()Lcom/appnew/android/table/ThemeSettings;", "setThemeSettings", "(Lcom/appnew/android/table/ThemeSettings;)V", "myDBClass", "Lcom/appnew/android/Room/UtkashRoom;", "getMyDBClass", "()Lcom/appnew/android/Room/UtkashRoom;", "setMyDBClass", "(Lcom/appnew/android/Room/UtkashRoom;)V", "paymentViewModel", "Lcom/appnew/android/Payment/PaymentViewModel;", "getPaymentViewModel", "()Lcom/appnew/android/Payment/PaymentViewModel;", "setPaymentViewModel", "(Lcom/appnew/android/Payment/PaymentViewModel;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "API_INIT_PAYMENT", FirebaseAnalytics.Param.PRICE, "id", "remark", "getCartList", "showProgress", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "ErrorCallBack", "paymentGateways", "data", "mode", "calculateAmount", "", "setAdapter", "courseReviewDetail", "launch_RazorPayPaymentGateway", "key", "onPaymentSuccess", CmcdData.Factory.STREAMING_FORMAT_SS, "onPaymentError", CmcdData.Factory.OBJECT_TYPE_INIT_SEGMENT, "setRefundRelatedData", "setTermRelatedData", "OnPaymentError", "onPaymentType", "onPaymentTypeCancel", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CartItemsActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack, PaymentResultListener, PaymentTypeCheck {
    public static final int $stable = 8;
    public ActivityCartItemsBinding binding;
    public BottomSetting bottomSetting;
    private RecyclerView.Adapter<CartItemAdapter.ViewHolder> cartItemAdapter;
    private CartItemDetail cartItemDetail;
    private ArrayList<CartItemModel> cartItemModelArray;
    private CourseLisDetail courseLisDetail;
    private boolean isfailure;
    private CartItemClick itemClickListener;
    private RecyclerView.LayoutManager layoutManager;
    private LeftMenu leftMenu;
    public UtkashRoom myDBClass;
    private ProgressBar paginationLoader;
    private PaymentViewModel paymentViewModel;
    public ThemeSettings themeSettings;
    private String courseId = "";
    private String rating = "";
    private String maincouseid = "";
    private String calculatedTax = "";
    private String txnToken = "";
    private String enc_val = "";
    private String rid = "";
    private String amt = "";
    private String scd = "";
    private String coursePrice = "";
    private String price1 = "";
    private String id1 = "";
    private String remark1 = "";
    private String pos_txn_id = "";
    private String pre_txtid = "";
    private String tx_status = "0";

    @Override // com.appnew.android.Utils.PaymentTypeCheck
    public void onPaymentTypeCancel() {
    }

    public final ActivityCartItemsBinding getBinding() {
        ActivityCartItemsBinding activityCartItemsBinding = this.binding;
        if (activityCartItemsBinding != null) {
            return activityCartItemsBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(ActivityCartItemsBinding activityCartItemsBinding) {
        Intrinsics.checkNotNullParameter(activityCartItemsBinding, "<set-?>");
        this.binding = activityCartItemsBinding;
    }

    public final ProgressBar getPaginationLoader() {
        return this.paginationLoader;
    }

    public final void setPaginationLoader(ProgressBar progressBar) {
        this.paginationLoader = progressBar;
    }

    public final CartItemDetail getCartItemDetail() {
        return this.cartItemDetail;
    }

    public final void setCartItemDetail(CartItemDetail cartItemDetail) {
        this.cartItemDetail = cartItemDetail;
    }

    public final CourseLisDetail getCourseLisDetail() {
        return this.courseLisDetail;
    }

    public final void setCourseLisDetail(CourseLisDetail courseLisDetail) {
        this.courseLisDetail = courseLisDetail;
    }

    public final ArrayList<CartItemModel> getCartItemModelArray() {
        return this.cartItemModelArray;
    }

    public final void setCartItemModelArray(ArrayList<CartItemModel> arrayList) {
        this.cartItemModelArray = arrayList;
    }

    public final String getRating() {
        return this.rating;
    }

    public final void setRating(String str) {
        this.rating = str;
    }

    public final CartItemClick getItemClickListener() {
        return this.itemClickListener;
    }

    public final void setItemClickListener(CartItemClick cartItemClick) {
        this.itemClickListener = cartItemClick;
    }

    public final String getMaincouseid() {
        return this.maincouseid;
    }

    public final void setMaincouseid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.maincouseid = str;
    }

    public final String getCalculatedTax() {
        return this.calculatedTax;
    }

    public final void setCalculatedTax(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.calculatedTax = str;
    }

    public final String getEnc_val() {
        return this.enc_val;
    }

    public final void setEnc_val(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.enc_val = str;
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

    public final boolean getIsfailure() {
        return this.isfailure;
    }

    public final void setIsfailure(boolean z) {
        this.isfailure = z;
    }

    public final String getCoursePrice() {
        return this.coursePrice;
    }

    public final void setCoursePrice(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.coursePrice = str;
    }

    public final String getPrice1() {
        return this.price1;
    }

    public final void setPrice1(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.price1 = str;
    }

    public final String getId1() {
        return this.id1;
    }

    public final void setId1(String str) {
        this.id1 = str;
    }

    public final String getRemark1() {
        return this.remark1;
    }

    public final void setRemark1(String str) {
        this.remark1 = str;
    }

    public final String getPos_txn_id() {
        return this.pos_txn_id;
    }

    public final void setPos_txn_id(String str) {
        this.pos_txn_id = str;
    }

    public final BottomSetting getBottomSetting() {
        BottomSetting bottomSetting = this.bottomSetting;
        if (bottomSetting != null) {
            return bottomSetting;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bottomSetting");
        return null;
    }

    public final void setBottomSetting(BottomSetting bottomSetting) {
        Intrinsics.checkNotNullParameter(bottomSetting, "<set-?>");
        this.bottomSetting = bottomSetting;
    }

    public final ThemeSettings getThemeSettings() {
        ThemeSettings themeSettings = this.themeSettings;
        if (themeSettings != null) {
            return themeSettings;
        }
        Intrinsics.throwUninitializedPropertyAccessException("themeSettings");
        return null;
    }

    public final void setThemeSettings(ThemeSettings themeSettings) {
        Intrinsics.checkNotNullParameter(themeSettings, "<set-?>");
        this.themeSettings = themeSettings;
    }

    public final UtkashRoom getMyDBClass() {
        UtkashRoom utkashRoom = this.myDBClass;
        if (utkashRoom != null) {
            return utkashRoom;
        }
        Intrinsics.throwUninitializedPropertyAccessException("myDBClass");
        return null;
    }

    public final void setMyDBClass(UtkashRoom utkashRoom) {
        Intrinsics.checkNotNullParameter(utkashRoom, "<set-?>");
        this.myDBClass = utkashRoom;
    }

    public final PaymentViewModel getPaymentViewModel() {
        return this.paymentViewModel;
    }

    public final void setPaymentViewModel(PaymentViewModel paymentViewModel) {
        this.paymentViewModel = paymentViewModel;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CartItemsActivity cartItemsActivity = this;
        Helper.setSystemBarLight(cartItemsActivity);
        setBinding(ActivityCartItemsBinding.inflate(getLayoutInflater()));
        setContentView(getBinding().getRoot());
        CartItemsActivity cartItemsActivity2 = this;
        setMyDBClass(UtkashRoom.getAppDatabase(cartItemsActivity2));
        Helper.enableScreenShot(cartItemsActivity);
        AllDoubtsFragmentKt.setNetworkCall(new NetworkCall(this, cartItemsActivity2));
        this.cartItemModelArray = new ArrayList<>();
        if (getIntent() != null) {
            getBinding().toolbarTitleTV.setText(getResources().getString(R.string.my_cart));
        }
        if (this.myDBClass != null && getMyDBClass().getthemeSettingdao().is_setting_exit()) {
            setThemeSettings(getMyDBClass().getthemeSettingdao().data());
            setBottomSetting((BottomSetting) new Gson().fromJson(getThemeSettings().getBottom(), BottomSetting.class));
        }
        if (this.bottomSetting != null && StringsKt.equals(getBottomSetting().getInvoice_tnc(), "1", true)) {
            getBinding().checkTncRL.setVisibility(0);
        }
        getCartList(false);
        this.layoutManager = new LinearLayoutManager(cartItemsActivity2);
        getBinding().cartItemsRecycler.setLayoutManager(this.layoutManager);
        getBinding().cartItemsImageBack.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Cart.Activity.CartItemsActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CartItemsActivity.onCreate$lambda$0(this.f$0);
            }
        }));
        this.itemClickListener = new CartItemClick() { // from class: com.appnew.android.Cart.Activity.CartItemsActivity.onCreate.2
            @Override // com.appnew.android.Cart.Interface.CartItemClick
            public void onClick(boolean state) {
                NetworkCall networkCall = AllDoubtsFragmentKt.getNetworkCall();
                Intrinsics.checkNotNull(networkCall);
                networkCall.NetworkAPICall(API.COURSE_CART_COUNT, "", true, false);
                CartItemsActivity.this.getCartList(false);
            }
        };
        getBinding().payNowText.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Cart.Activity.CartItemsActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CartItemsActivity.onCreate$lambda$1(this.f$0);
            }
        }));
        PaymentViewModel paymentViewModel = (PaymentViewModel) new ViewModelProvider(this).get(PaymentViewModel.class);
        this.paymentViewModel = paymentViewModel;
        if (paymentViewModel != null) {
            paymentViewModel.initPaymentGateway(this, new PaymentGatewayListener() { // from class: com.appnew.android.Cart.Activity.CartItemsActivity.onCreate.4
                @Override // com.appnew.android.Payment.PaymentGatewayListener
                public void onSuccessEsewa(String productId, String totalAmount, String referenceId, String scdId) {
                    Intrinsics.checkNotNullParameter(productId, "productId");
                    Intrinsics.checkNotNullParameter(totalAmount, "totalAmount");
                    Intrinsics.checkNotNullParameter(referenceId, "referenceId");
                    Intrinsics.checkNotNullParameter(scdId, "scdId");
                    CartItemsActivity.this.setPos_txn_id(productId);
                    CartItemsActivity.this.setAmt(totalAmount);
                    CartItemsActivity.this.setRid(referenceId);
                    CartItemsActivity.this.setScd(scdId);
                    NetworkCall networkCall = AllDoubtsFragmentKt.getNetworkCall();
                    if (networkCall != null) {
                        networkCall.NetworkAPICall(API.int_payment, "", true, false);
                    }
                }

                @Override // com.appnew.android.Payment.PaymentGatewayListener
                public void onSuccess(String posTxnId) {
                    CartItemsActivity.this.setPos_txn_id(posTxnId);
                    NetworkCall networkCall = AllDoubtsFragmentKt.getNetworkCall();
                    if (networkCall != null) {
                        networkCall.NetworkAPICall(API.int_payment, "", true, false);
                    }
                }

                @Override // com.appnew.android.Payment.PaymentGatewayListener
                public void onFailed(boolean isFailure) {
                    CartItemsActivity.this.OnPaymentError();
                }
            }, this.courseId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(CartItemsActivity cartItemsActivity) {
        cartItemsActivity.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$1(CartItemsActivity cartItemsActivity) {
        if (cartItemsActivity.getBottomSetting().getInvoice_tnc().equals("1")) {
            if (cartItemsActivity.getBinding().termsCheck.isChecked()) {
                CartItemsActivity cartItemsActivity2 = cartItemsActivity;
                if (!Helper.isNetworkConnected(cartItemsActivity2)) {
                    Helper.showInternetToast(cartItemsActivity2);
                    return Unit.INSTANCE;
                }
                if (StringsKt.equals(MakeMyExam.getUserId(), "0", true)) {
                    return Unit.INSTANCE;
                }
                cartItemsActivity.API_INIT_PAYMENT(cartItemsActivity.coursePrice, cartItemsActivity.courseId, "");
            } else {
                Toast.makeText(cartItemsActivity, cartItemsActivity.getResources().getString(R.string.please_select_terms_and_conditions), 0).show();
            }
        } else {
            CartItemsActivity cartItemsActivity3 = cartItemsActivity;
            if (!Helper.isNetworkConnected(cartItemsActivity3)) {
                Helper.showInternetToast(cartItemsActivity3);
                return Unit.INSTANCE;
            }
            if (StringsKt.equals(MakeMyExam.getUserId(), "0", true)) {
                return Unit.INSTANCE;
            }
            cartItemsActivity.API_INIT_PAYMENT(cartItemsActivity.coursePrice, cartItemsActivity.courseId, "");
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0287 A[Catch: Exception -> 0x0398, TryCatch #0 {Exception -> 0x0398, blocks: (B:3:0x0015, B:6:0x0064, B:9:0x006f, B:11:0x0080, B:13:0x0086, B:15:0x0091, B:18:0x00ab, B:21:0x00b5, B:23:0x00c4, B:25:0x00ca, B:27:0x00d5, B:29:0x00ec, B:32:0x00f6, B:34:0x0105, B:37:0x010d, B:39:0x0118, B:41:0x012f, B:44:0x0139, B:46:0x0148, B:49:0x0150, B:51:0x015a, B:53:0x0171, B:56:0x017b, B:58:0x018a, B:61:0x0192, B:63:0x019c, B:66:0x01bc, B:69:0x01c7, B:71:0x01da, B:74:0x01e2, B:76:0x01ec, B:81:0x020f, B:84:0x021a, B:86:0x022d, B:89:0x0235, B:91:0x023f, B:94:0x0260, B:96:0x0287, B:98:0x0291, B:100:0x0298, B:103:0x02b5, B:106:0x02c1, B:108:0x02c5, B:155:0x0383, B:157:0x038f, B:109:0x02cc, B:112:0x02d5, B:115:0x02e1, B:117:0x02e5, B:118:0x02ec, B:121:0x02f5, B:124:0x0301, B:126:0x0305, B:127:0x030c, B:130:0x0314, B:133:0x031f, B:134:0x032a, B:137:0x0332, B:140:0x033d, B:141:0x0348, B:144:0x0350, B:147:0x035b, B:148:0x0366, B:151:0x036e, B:154:0x0379), top: B:162:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0291 A[Catch: Exception -> 0x0398, TryCatch #0 {Exception -> 0x0398, blocks: (B:3:0x0015, B:6:0x0064, B:9:0x006f, B:11:0x0080, B:13:0x0086, B:15:0x0091, B:18:0x00ab, B:21:0x00b5, B:23:0x00c4, B:25:0x00ca, B:27:0x00d5, B:29:0x00ec, B:32:0x00f6, B:34:0x0105, B:37:0x010d, B:39:0x0118, B:41:0x012f, B:44:0x0139, B:46:0x0148, B:49:0x0150, B:51:0x015a, B:53:0x0171, B:56:0x017b, B:58:0x018a, B:61:0x0192, B:63:0x019c, B:66:0x01bc, B:69:0x01c7, B:71:0x01da, B:74:0x01e2, B:76:0x01ec, B:81:0x020f, B:84:0x021a, B:86:0x022d, B:89:0x0235, B:91:0x023f, B:94:0x0260, B:96:0x0287, B:98:0x0291, B:100:0x0298, B:103:0x02b5, B:106:0x02c1, B:108:0x02c5, B:155:0x0383, B:157:0x038f, B:109:0x02cc, B:112:0x02d5, B:115:0x02e1, B:117:0x02e5, B:118:0x02ec, B:121:0x02f5, B:124:0x0301, B:126:0x0305, B:127:0x030c, B:130:0x0314, B:133:0x031f, B:134:0x032a, B:137:0x0332, B:140:0x033d, B:141:0x0348, B:144:0x0350, B:147:0x035b, B:148:0x0366, B:151:0x036e, B:154:0x0379), top: B:162:0x0015 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void API_INIT_PAYMENT(java.lang.String r25, java.lang.String r26, java.lang.String r27) {
        /*
            Method dump skipped, instruction units count: 925
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Cart.Activity.CartItemsActivity.API_INIT_PAYMENT(java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getCartList(boolean showProgress) {
        CartItemsActivity cartItemsActivity = this;
        if (!Helper.isNetworkConnected(cartItemsActivity)) {
            Helper.showInternetToast(cartItemsActivity);
            getBinding().cartItemsRecycler.setVisibility(8);
            getBinding().noDataFoundRL.setVisibility(0);
            return;
        }
        getBinding().cartItemsRecycler.setVisibility(0);
        getBinding().noDataFoundRL.setVisibility(8);
        Helper.showProgressDialog(cartItemsActivity);
        NetworkCall networkCall = AllDoubtsFragmentKt.getNetworkCall();
        if (networkCall != null) {
            networkCall.NetworkAPICall(API.COURSE_SHOW_CART, "", showProgress, false);
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        Intrinsics.checkNotNullParameter(service, "service");
        if (apitype != null) {
            int iHashCode = apitype.hashCode();
            if (iHashCode != -1410705383) {
                if (iHashCode != 1334579443) {
                    if (iHashCode == 2002393681 && apitype.equals(API.int_payment)) {
                        Extras extras = new Extras();
                        extras.setCourse_id(this.courseId);
                        extras.setRemark(this.remark1);
                        if (this.isfailure) {
                            EncryptionData encryptionData = new EncryptionData();
                            encryptionData.setType("6");
                            encryptionData.setCourse_id(this.courseId);
                            encryptionData.setParent_id("");
                            encryptionData.setPre_transaction_id(this.pre_txtid);
                            encryptionData.setTransaction_status("2");
                            encryptionData.setPost_transaction_id("");
                            encryptionData.setExtras(extras);
                            return service.int_payment(AES.encrypt(new Gson().toJson(encryptionData)));
                        }
                        if (StringsKt.equals$default(this.pos_txn_id, "", false, 2, null)) {
                            EncryptionData encryptionData2 = new EncryptionData();
                            encryptionData2.setType("5");
                            encryptionData2.setCourse_bulk(this.courseId);
                            encryptionData2.setExtras(extras);
                            encryptionData2.setCourse_price(this.price1);
                            encryptionData2.setParent_id("");
                            encryptionData2.setTax(this.calculatedTax);
                            PaymentViewModel paymentViewModel = this.paymentViewModel;
                            encryptionData2.setPay_via(paymentViewModel != null ? paymentViewModel.getPayVia() : null);
                            encryptionData2.setCoupon_applied("0");
                            return service.int_payment(AES.encrypt(new Gson().toJson(encryptionData2)));
                        }
                        EncryptionData encryptionData3 = new EncryptionData();
                        encryptionData3.setType("6");
                        encryptionData3.setCourse_id(this.courseId);
                        encryptionData3.setExtras(extras);
                        encryptionData3.setParent_id("");
                        encryptionData3.setPre_transaction_id(this.pre_txtid);
                        encryptionData3.setTransaction_status("1");
                        encryptionData3.setPost_transaction_id(this.pos_txn_id);
                        encryptionData3.setRid(this.rid);
                        encryptionData3.setScd(this.scd);
                        encryptionData3.setPid(this.pos_txn_id);
                        encryptionData3.setAmt(this.amt);
                        encryptionData3.setOrder_id(this.pos_txn_id);
                        return service.int_payment(AES.encrypt(new Gson().toJson(encryptionData3)));
                    }
                } else if (apitype.equals(API.COURSE_CART_COUNT)) {
                    EncryptionData encryptionData4 = new EncryptionData();
                    encryptionData4.setCourse_id(this.courseId);
                    AES.encrypt(new Gson().toJson(encryptionData4));
                    return service.getCartCount();
                }
            } else if (apitype.equals(API.COURSE_SHOW_CART)) {
                EncryptionData encryptionData5 = new EncryptionData();
                encryptionData5.setCourse_id(this.courseId);
                AES.encrypt(new Gson().toJson(encryptionData5));
                return service.getCartItems();
            }
        }
        return null;
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) {
        Data data;
        CartData data2;
        Intrinsics.checkNotNullParameter(jsonstring, "jsonstring");
        if (apitype != null) {
            int iHashCode = apitype.hashCode();
            if (iHashCode == -1410705383) {
                if (apitype.equals(API.COURSE_SHOW_CART)) {
                    try {
                        Helper.dismissProgressDialog();
                        ArrayList<CartItemModel> arrayList = this.cartItemModelArray;
                        if (arrayList != null) {
                            arrayList.clear();
                        }
                        if (jsonstring.getString("status").equals("true")) {
                            this.cartItemDetail = (CartItemDetail) new Gson().fromJson(jsonstring.toString(), CartItemDetail.class);
                            CourseLisDetail courseLisDetail = (CourseLisDetail) new Gson().fromJson(jsonstring.toString(), CourseLisDetail.class);
                            this.courseLisDetail = courseLisDetail;
                            if (((courseLisDetail == null || (data2 = courseLisDetail.getData()) == null) ? null : data2.getCartdata()) != null) {
                                Gson gson = new Gson();
                                CourseLisDetail courseLisDetail2 = this.courseLisDetail;
                                Intrinsics.checkNotNull(courseLisDetail2);
                                this.courseId = gson.toJsonTree(courseLisDetail2.getData().getCartdata()).toString();
                            }
                            CartItemDetail cartItemDetail = this.cartItemDetail;
                            if (((cartItemDetail == null || (data = cartItemDetail.getData()) == null) ? null : data.getCartdata()) != null) {
                                ArrayList<CartItemModel> arrayList2 = this.cartItemModelArray;
                                if (arrayList2 != null) {
                                    CartItemDetail cartItemDetail2 = this.cartItemDetail;
                                    Intrinsics.checkNotNull(cartItemDetail2);
                                    arrayList2.addAll(cartItemDetail2.getData().getCartdata());
                                }
                                ArrayList<CartItemModel> arrayList3 = this.cartItemModelArray;
                                if (arrayList3 != null) {
                                    setAdapter(arrayList3);
                                }
                                TextView textView = getBinding().cartItemQuantity;
                                if (textView != null) {
                                    CartItemDetail cartItemDetail3 = this.cartItemDetail;
                                    Data data3 = cartItemDetail3 != null ? cartItemDetail3.getData() : null;
                                    Intrinsics.checkNotNull(data3);
                                    textView.setText(String.valueOf(data3.getCartdata().size()));
                                }
                                TextView textView2 = getBinding().cartItemPrice;
                                if (textView2 != null) {
                                    String string = getResources().getString(R.string.rs);
                                    CartItemDetail cartItemDetail4 = this.cartItemDetail;
                                    Data data4 = cartItemDetail4 != null ? cartItemDetail4.getData() : null;
                                    Intrinsics.checkNotNull(data4);
                                    textView2.setText(string + data4.getTotal() + "/-");
                                }
                                CartItemDetail cartItemDetail5 = this.cartItemDetail;
                                Data data5 = cartItemDetail5 != null ? cartItemDetail5.getData() : null;
                                Intrinsics.checkNotNull(data5);
                                String total = data5.getTotal();
                                Intrinsics.checkNotNullExpressionValue(total, "getTotal(...)");
                                this.coursePrice = String.valueOf(Float.parseFloat(total));
                                UtkashRoom appDatabase = UtkashRoom.getAppDatabase(this);
                                if (appDatabase.getthemeSettingdao().is_setting_exit()) {
                                    LeftMenu leftMenu = (LeftMenu) new Gson().fromJson(appDatabase.getthemeSettingdao().data().getLeft_menu(), LeftMenu.class);
                                    if (!TextUtils.isEmpty(leftMenu.getPayment_privacy()) && StringsKt.equals(leftMenu.getPayment_privacy(), "0", true)) {
                                        setTermRelatedData();
                                        return;
                                    } else {
                                        setRefundRelatedData();
                                        return;
                                    }
                                }
                                return;
                            }
                            getBinding().cartItemsRecycler.setVisibility(8);
                            getBinding().noDataFoundRL.setVisibility(0);
                            getBinding().cartItemCoupon.setVisibility(8);
                            getBinding().selectAddressCard.setVisibility(8);
                            getBinding().checkTncRL.setVisibility(8);
                            getBinding().payNowText.setVisibility(8);
                            return;
                        }
                        getBinding().cartItemsRecycler.setVisibility(8);
                        getBinding().noDataFoundRL.setVisibility(0);
                        getBinding().cartItemCoupon.setVisibility(8);
                        getBinding().selectAddressCard.setVisibility(8);
                        getBinding().checkTncRL.setVisibility(8);
                        getBinding().payNowText.setVisibility(8);
                        return;
                    } catch (Exception unused) {
                        getBinding().cartItemsRecycler.setVisibility(8);
                        getBinding().noDataFoundRL.setVisibility(0);
                        getBinding().cartItemCoupon.setVisibility(8);
                        getBinding().selectAddressCard.setVisibility(8);
                        getBinding().checkTncRL.setVisibility(8);
                        getBinding().payNowText.setVisibility(8);
                        return;
                    }
                }
                return;
            }
            if (iHashCode == 1334579443) {
                if (apitype.equals(API.COURSE_CART_COUNT)) {
                    try {
                        if (Intrinsics.areEqual(jsonstring.optString("status"), "true")) {
                            if (jsonstring.has("data")) {
                                String string2 = jsonstring.getJSONObject("data").getString("total_count");
                                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                                SharedPreference.getInstance().putInt(Const.CART_COUNT, Integer.parseInt(string2));
                                return;
                            }
                            return;
                        }
                        if (jsonstring.optString("auth_code") != null) {
                            StringsKt.equals(jsonstring.optString("auth_code"), Const.EXPIRY_AUTH_CODE, true);
                            return;
                        }
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                return;
            }
            if (iHashCode == 2002393681 && apitype.equals(API.int_payment)) {
                try {
                    if (jsonstring.optBoolean("status")) {
                        if (this.isfailure) {
                            this.isfailure = false;
                            this.pos_txn_id = "";
                            return;
                        }
                        if (StringsKt.equals$default(this.pos_txn_id, "", false, 2, null)) {
                            JSONObject jSONObject = jsonstring.getJSONObject("data");
                            PaymentViewModel paymentViewModel = this.paymentViewModel;
                            if (StringsKt.equals$default(paymentViewModel != null ? paymentViewModel.getPayVia() : null, "3", false, 2, null)) {
                                Intrinsics.checkNotNull(jSONObject);
                                paymentGateways(jSONObject, Credentials.RZP);
                                return;
                            }
                            PaymentViewModel paymentViewModel2 = this.paymentViewModel;
                            if (StringsKt.equals$default(paymentViewModel2 != null ? paymentViewModel2.getPayVia() : null, "6", false, 2, null)) {
                                Intrinsics.checkNotNull(jSONObject);
                                paymentGateways(jSONObject, Credentials.PAYTM);
                                return;
                            }
                            PaymentViewModel paymentViewModel3 = this.paymentViewModel;
                            if (StringsKt.equals$default(paymentViewModel3 != null ? paymentViewModel3.getPayVia() : null, "7", false, 2, null)) {
                                Intrinsics.checkNotNull(jSONObject);
                                paymentGateways(jSONObject, Credentials.CCAV);
                                return;
                            }
                            PaymentViewModel paymentViewModel4 = this.paymentViewModel;
                            Intrinsics.checkNotNull(paymentViewModel4);
                            if (paymentViewModel4.getPayVia().equals("8")) {
                                Intrinsics.checkNotNull(jSONObject);
                                paymentGateways(jSONObject, Credentials.FONEPAY);
                                return;
                            }
                            PaymentViewModel paymentViewModel5 = this.paymentViewModel;
                            Intrinsics.checkNotNull(paymentViewModel5);
                            if (paymentViewModel5.getPayVia().equals("9")) {
                                Intrinsics.checkNotNull(jSONObject);
                                paymentGateways(jSONObject, Credentials.EASEBUZZ);
                                return;
                            }
                            PaymentViewModel paymentViewModel6 = this.paymentViewModel;
                            Intrinsics.checkNotNull(paymentViewModel6);
                            if (paymentViewModel6.getPayVia().equals("11")) {
                                Intrinsics.checkNotNull(jSONObject);
                                paymentGateways(jSONObject, Credentials.BILLDESK);
                                return;
                            }
                            PaymentViewModel paymentViewModel7 = this.paymentViewModel;
                            Intrinsics.checkNotNull(paymentViewModel7);
                            if (paymentViewModel7.getPayVia().equals("13")) {
                                Intrinsics.checkNotNull(jSONObject);
                                paymentGateways(jSONObject, Credentials.EASYPAY);
                                return;
                            }
                            return;
                        }
                        if (!SingleStudy.parentCourseId.equals("")) {
                            UtkashRoom.getAppDatabase(MakeMyExam.getAppContext()).getCourseDetaildata().deletecoursedetail(SingleStudy.parentCourseId, MakeMyExam.userId);
                        }
                        if (jsonstring.optString("message") != null) {
                            Toast.makeText(this, jsonstring.optString("message"), 0).show();
                        }
                        Helper.gotoActivity(this, (Class<?>) DashboardActivityTheme1.class);
                        finishAffinity();
                        return;
                    }
                    if (this.isfailure) {
                        this.isfailure = false;
                        this.pos_txn_id = "";
                    }
                    RetrofitResponse.GetApiData(this, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
                } catch (Exception unused2) {
                }
            }
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        if (Intrinsics.areEqual(apitype, API.COURSE_SHOW_CART)) {
            try {
                ProgressBar progressBar = this.paginationLoader;
                if (progressBar != null) {
                    Intrinsics.checkNotNull(progressBar);
                    if (progressBar.isShown()) {
                        ProgressBar progressBar2 = this.paginationLoader;
                        if (progressBar2 != null) {
                            progressBar2.setVisibility(8);
                        }
                        getBinding().cartItemsRecycler.setVisibility(8);
                        getBinding().noDataFoundRL.setVisibility(0);
                    }
                }
                Helper.dismissProgressDialog();
            } catch (Exception unused) {
            }
        }
    }

    private final void paymentGateways(JSONObject data, String mode) {
        try {
            this.pre_txtid = data.optString(Const.COURSE_INIT_PAYMENT_TOKEN);
            String stringPreference = PreferencesUtil.INSTANCE.getStringPreference(this, Credentials.RZP);
            String stringPreference2 = PreferencesUtil.INSTANCE.getStringPreference(this, Credentials.PAYTM);
            String stringPreference3 = PreferencesUtil.INSTANCE.getStringPreference(this, Credentials.CCAV);
            String stringPreference4 = PreferencesUtil.INSTANCE.getStringPreference(this, Credentials.FONEPAY);
            PreferencesUtil.INSTANCE.getStringPreference(this, Credentials.EASEBUZZ);
            String stringPreference5 = PreferencesUtil.INSTANCE.getStringPreference(this, Credentials.BILLDESK);
            String stringPreference6 = PreferencesUtil.INSTANCE.getStringPreference(this, Credentials.EASYPAY);
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
                PaymentViewModel paymentViewModel = this.paymentViewModel;
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
                PaymentViewModel paymentViewModel2 = this.paymentViewModel;
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
                PaymentViewModel paymentViewModel3 = this.paymentViewModel;
                Intrinsics.checkNotNull(paymentViewModel3);
                Intrinsics.checkNotNull(strOptString);
                paymentViewModel3.launchFonePayPaymentGateway(strOptString, calculateAmount());
                return;
            }
            if (Intrinsics.areEqual(mode, Credentials.BILLDESK)) {
                if (stringPreference5 == null || stringPreference5.length() == 0) {
                    return;
                }
                BillDesk billDesk = (BillDesk) new Gson().fromJson(stringPreference5, BillDesk.class);
                if ((billDesk != null ? billDesk.getStatus() : null) == null || !StringsKt.equals(billDesk.getStatus(), "1", true)) {
                    return;
                }
                String strOptString2 = data.optString("txnToken");
                PaymentViewModel paymentViewModel4 = this.paymentViewModel;
                Intrinsics.checkNotNull(paymentViewModel4);
                Intrinsics.checkNotNull(strOptString2);
                paymentViewModel4.launchBillDeskPaymentGateway(strOptString2, calculateAmount());
                return;
            }
            if (!Intrinsics.areEqual(mode, Credentials.EASYPAY) || stringPreference6 == null || stringPreference6.length() == 0) {
                return;
            }
            BillDesk billDesk2 = (BillDesk) new Gson().fromJson(stringPreference6, BillDesk.class);
            if ((billDesk2 != null ? billDesk2.getStatus() : null) == null || !StringsKt.equals(billDesk2.getStatus(), "1", true)) {
                return;
            }
            String strOptString3 = data.optString("txnToken");
            PaymentViewModel paymentViewModel5 = this.paymentViewModel;
            Intrinsics.checkNotNull(paymentViewModel5);
            Intrinsics.checkNotNull(strOptString3);
            paymentViewModel5.launchEasyPayPaymentGateway(strOptString3, calculateAmount());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final int calculateAmount() {
        return Math.round(Float.parseFloat(this.price1));
    }

    private final void setAdapter(ArrayList<CartItemModel> courseReviewDetail) {
        CartItemClick cartItemClick = this.itemClickListener;
        this.cartItemAdapter = cartItemClick != null ? new CartItemAdapter(courseReviewDetail, this, cartItemClick) : null;
        getBinding().cartItemsRecycler.setAdapter(this.cartItemAdapter);
        getBinding().selectAddressCard.setVisibility(0);
        if (this.bottomSetting != null && StringsKt.equals(getBottomSetting().getInvoice_tnc(), "1", true)) {
            getBinding().checkTncRL.setVisibility(0);
        }
        getBinding().payNowText.setVisibility(0);
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

    @Override // com.razorpay.PaymentResultListener
    public void onPaymentSuccess(String s) {
        Intrinsics.checkNotNullParameter(s, "s");
        this.pos_txn_id = s;
        NetworkCall networkCall = AllDoubtsFragmentKt.getNetworkCall();
        Intrinsics.checkNotNull(networkCall);
        networkCall.NetworkAPICall(API.int_payment, "", true, false);
    }

    @Override // com.razorpay.PaymentResultListener
    public void onPaymentError(int i, String s) {
        OnPaymentError();
    }

    private final void setRefundRelatedData() {
        getBinding().termCondTV.setText(getResources().getString(R.string.before_making_payment_you_agree_to_our) + " \n" + getResources().getString(R.string.refund_policy));
        SpannableString spannableString = new SpannableString(getBinding().termCondTV.getText().toString());
        spannableString.setSpan(new ClickableSpan() { // from class: com.appnew.android.Cart.Activity.CartItemsActivity$setRefundRelatedData$clickableSpan$1
            @Override // android.text.style.ClickableSpan
            public void onClick(View textView) {
                Intrinsics.checkNotNullParameter(textView, "textView");
                Intent intent = new Intent(this.this$0.getApplicationContext(), (Class<?>) WebViewActivty.class);
                intent.putExtra("type", "Refund Policy");
                intent.putExtra("url", API.PRIVACY_POLICY_REFUND_URL);
                Helper.gotoActivity(intent, this.this$0);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                Intrinsics.checkNotNullParameter(ds, "ds");
                super.updateDrawState(ds);
                ds.setUnderlineText(true);
            }
        }, getBinding().termCondTV.getText().toString().length() - 13, getBinding().termCondTV.getText().toString().length(), 33);
        spannableString.setSpan(new UnderlineSpan(), getBinding().termCondTV.getText().toString().length() - 13, getBinding().termCondTV.getText().toString().length(), 0);
        spannableString.setSpan(new StyleSpan(1), getBinding().termCondTV.getText().toString().length() - 13, getBinding().termCondTV.getText().toString().length(), 0);
        getBinding().termCondTV.setText(spannableString);
        getBinding().termCondTV.setMovementMethod(LinkMovementMethod.getInstance());
        getBinding().termCondTV.setHighlightColor(0);
    }

    private final void setTermRelatedData() {
        getBinding().termCondTV.setText(getResources().getString(R.string.before_making_payment_you_agree_to_our) + " \n" + getResources().getString(R.string.terms_amp_conditions));
        SpannableString spannableString = new SpannableString(getBinding().termCondTV.getText().toString());
        spannableString.setSpan(new ClickableSpan() { // from class: com.appnew.android.Cart.Activity.CartItemsActivity$setTermRelatedData$clickableSpan$1
            @Override // android.text.style.ClickableSpan
            public void onClick(View textView) {
                Intrinsics.checkNotNullParameter(textView, "textView");
                Intent intent = new Intent(this.this$0, (Class<?>) WebViewActivty.class);
                intent.putExtra("type", "Terms of Service");
                intent.putExtra("url", API.TERMS_AND_CONDITIONS);
                Helper.gotoActivity(intent, this.this$0);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                Intrinsics.checkNotNullParameter(ds, "ds");
                super.updateDrawState(ds);
                ds.setUnderlineText(true);
            }
        }, getBinding().termCondTV.getText().toString().length() - 18, getBinding().termCondTV.getText().toString().length(), 33);
        spannableString.setSpan(new UnderlineSpan(), getBinding().termCondTV.getText().toString().length() - 18, getBinding().termCondTV.getText().toString().length(), 0);
        spannableString.setSpan(new StyleSpan(1), getBinding().termCondTV.getText().toString().length() - 18, getBinding().termCondTV.getText().toString().length(), 0);
        getBinding().termCondTV.setText(spannableString);
        getBinding().termCondTV.setMovementMethod(LinkMovementMethod.getInstance());
        getBinding().termCondTV.setHighlightColor(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void OnPaymentError() {
        try {
            this.isfailure = true;
            NetworkCall networkCall = AllDoubtsFragmentKt.getNetworkCall();
            Intrinsics.checkNotNull(networkCall);
            networkCall.NetworkAPICall(API.int_payment, "", true, false);
            if (StringsKt.equals(BuildConfig.FLAVOR, "mahendra", true)) {
                NetworkCall networkCall2 = AllDoubtsFragmentKt.getNetworkCall();
                Intrinsics.checkNotNull(networkCall2);
                networkCall2.NetworkAPICall(API.COURSE_ADD_TO_CART, "", false, false);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.appnew.android.Utils.PaymentTypeCheck
    public void onPaymentType(String mode, JSONObject data) {
        PaymentViewModel paymentViewModel;
        PaymentViewModel paymentViewModel2;
        PaymentViewModel paymentViewModel3;
        Intrinsics.checkNotNullParameter(data, "data");
        CartItemsActivity cartItemsActivity = this;
        String stringPreference = PreferencesUtil.INSTANCE.getStringPreference(cartItemsActivity, Credentials.RZP);
        String stringPreference2 = PreferencesUtil.INSTANCE.getStringPreference(cartItemsActivity, Credentials.PAYTM);
        String stringPreference3 = PreferencesUtil.INSTANCE.getStringPreference(cartItemsActivity, Credentials.CCAV);
        String stringPreference4 = PreferencesUtil.INSTANCE.getStringPreference(cartItemsActivity, Credentials.FONEPAY);
        String stringPreference5 = PreferencesUtil.INSTANCE.getStringPreference(cartItemsActivity, Credentials.EASEBUZZ);
        String stringPreference6 = PreferencesUtil.INSTANCE.getStringPreference(cartItemsActivity, Credentials.BILLDESK);
        String stringPreference7 = PreferencesUtil.INSTANCE.getStringPreference(cartItemsActivity, Credentials.EASYPAY);
        if (StringsKt.equals(mode, Credentials.RZP, true)) {
            if (stringPreference != null && stringPreference.length() != 0 && (paymentViewModel3 = this.paymentViewModel) != null) {
                paymentViewModel3.setPayVia("3");
            }
        } else if (StringsKt.equals(mode, Credentials.PAYTM, true)) {
            if (stringPreference2 != null && stringPreference2.length() != 0 && (paymentViewModel2 = this.paymentViewModel) != null) {
                paymentViewModel2.setPayVia("6");
            }
        } else if (StringsKt.equals(mode, Credentials.CCAV, true)) {
            if (stringPreference3 != null && stringPreference3.length() != 0 && (paymentViewModel = this.paymentViewModel) != null) {
                paymentViewModel.setPayVia("7");
            }
        } else if (Intrinsics.areEqual(mode, Credentials.FONEPAY)) {
            if (stringPreference4 != null && stringPreference4.length() != 0) {
                PaymentViewModel paymentViewModel4 = this.paymentViewModel;
                Intrinsics.checkNotNull(paymentViewModel4);
                paymentViewModel4.setPayVia("8");
            }
        } else if (Intrinsics.areEqual(mode, Credentials.EASEBUZZ)) {
            if (stringPreference5 != null && stringPreference5.length() != 0) {
                PaymentViewModel paymentViewModel5 = this.paymentViewModel;
                Intrinsics.checkNotNull(paymentViewModel5);
                paymentViewModel5.setPayVia("9");
            }
        } else if (Intrinsics.areEqual(mode, Credentials.BILLDESK)) {
            if (stringPreference6 != null && stringPreference6.length() != 0) {
                PaymentViewModel paymentViewModel6 = this.paymentViewModel;
                Intrinsics.checkNotNull(paymentViewModel6);
                paymentViewModel6.setPayVia("11");
            }
        } else if (Intrinsics.areEqual(mode, Credentials.EASYPAY) && stringPreference7 != null && stringPreference7.length() != 0) {
            PaymentViewModel paymentViewModel7 = this.paymentViewModel;
            Intrinsics.checkNotNull(paymentViewModel7);
            paymentViewModel7.setPayVia("13");
        }
        this.price1 = data.optString(FirebaseAnalytics.Param.PRICE);
        this.id1 = data.optString("id");
        this.remark1 = data.optString("remark");
        NetworkCall networkCall = AllDoubtsFragmentKt.getNetworkCall();
        if (networkCall != null) {
            networkCall.NetworkAPICall(API.int_payment, "", true, false);
        }
    }
}
