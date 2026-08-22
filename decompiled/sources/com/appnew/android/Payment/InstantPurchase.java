package com.appnew.android.Payment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Insets;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.Editable;
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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
import com.appnew.android.Coupon.Adapter.CouponPurchaseAdapter;
import com.appnew.android.Coupon.Models.CoursesCoupon;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.Courses.Adapter.AddressAdapter;
import com.appnew.android.Courses.Fragment.SingleStudy;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.Address;
import com.appnew.android.Model.AddressMaster;
import com.appnew.android.Model.BillDesk;
import com.appnew.android.Model.BottomSetting;
import com.appnew.android.Model.COURSEDETAIL.CourseDetail;
import com.appnew.android.Model.COURSEDETAIL.CourseDetailData;
import com.appnew.android.Model.COURSEDETAIL.Data;
import com.appnew.android.Model.Ccav;
import com.appnew.android.Model.EaseBuzz;
import com.appnew.android.Model.EasyPay;
import com.appnew.android.Model.FonePay;
import com.appnew.android.Model.LeftMenu;
import com.appnew.android.Model.Paytm;
import com.appnew.android.Model.QRPaymentData;
import com.appnew.android.Model.Rzp;
import com.appnew.android.Model.TxnTokenData;
import com.appnew.android.Payment.InstantPurchase;
import com.appnew.android.Payment.easy_pay.EasyPayCheckout;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Attention;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.DialogUtils;
import com.appnew.android.Utils.GenericUtils;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.PaymentTypeCheck;
import com.appnew.android.Utils.Render;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.UpdateProfileDialogUtils;
import com.appnew.android.Webview.WebViewActivty;
import com.appnew.android.databinding.InstantPurchaseLayoutBinding;
import com.appnew.android.home.Constants;
import com.appnew.android.pojo.Userinfo.StatesCities.StatesCities;
import com.appnew.android.pojo.Userinfo.StatesCities.StatesCitiesData;
import com.appnew.android.table.ThemeSettings;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.eduteria.app.app.R;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.textfield.TextInputLayout;
import com.google.common.collect.ImmutableList;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.paytm.pgsdk.PaytmConstants;
import com.razorpay.PaymentResultListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: InstantPurchase.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000æ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b8\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000 à\u00032\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0004à\u0003á\u0003B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010½\u0001\u001a\u00030¾\u00012\b\u0010¿\u0001\u001a\u00030¶\u00012\b\u0010À\u0001\u001a\u00030¶\u00012\n\u0010Á\u0001\u001a\u0005\u0018\u00010Â\u0001H\u0016J\u0016\u0010Ã\u0001\u001a\u00030¾\u00012\n\u0010Ä\u0001\u001a\u0005\u0018\u00010Å\u0001H\u0016J\u0016\u0010Æ\u0001\u001a\u00030Ç\u00012\n\u0010Ä\u0001\u001a\u0005\u0018\u00010Å\u0001H\u0016J,\u0010È\u0001\u001a\u00030É\u00012\b\u0010Ê\u0001\u001a\u00030Ë\u00012\n\u0010Ì\u0001\u001a\u0005\u0018\u00010Í\u00012\n\u0010Ä\u0001\u001a\u0005\u0018\u00010Å\u0001H\u0016J \u0010Î\u0001\u001a\u00030¾\u00012\b\u0010Ï\u0001\u001a\u00030É\u00012\n\u0010Ä\u0001\u001a\u0005\u0018\u00010Å\u0001H\u0016J\b\u0010Ð\u0001\u001a\u00030¾\u0001J\n\u0010Ñ\u0001\u001a\u00030¾\u0001H\u0003J\n\u0010Ò\u0001\u001a\u00030¾\u0001H\u0003J\b\u0010Ó\u0001\u001a\u00030¾\u0001J\n\u0010Ô\u0001\u001a\u00030¾\u0001H\u0002J\u0007\u0010Õ\u0001\u001a\u00020\u0015J\u0007\u0010Ö\u0001\u001a\u00020\u0015J\u0007\u0010×\u0001\u001a\u00020\u0015J\u0007\u0010Ø\u0001\u001a\u00020\u0015J\u0013\u0010Ù\u0001\u001a\u00030¾\u00012\u0007\u0010Ú\u0001\u001a\u00020\u0015H\u0003J\u0013\u0010Û\u0001\u001a\u00030¾\u00012\u0007\u0010Ü\u0001\u001a\u00020\u0015H\u0003J\n\u0010Ý\u0001\u001a\u00030¾\u0001H\u0002J\u0011\u0010Þ\u0001\u001a\u00030¾\u00012\u0007\u0010Ü\u0001\u001a\u00020\u0015J\b\u0010ß\u0001\u001a\u00030¾\u0001J\u0014\u0010à\u0001\u001a\u00030¾\u00012\n\u0010á\u0001\u001a\u0005\u0018\u00010â\u0001J\u0016\u0010ã\u0001\u001a\u00030¾\u00012\n\u0010ä\u0001\u001a\u0005\u0018\u00010â\u0001H\u0016J\u0013\u0010å\u0001\u001a\u00030¾\u00012\u0007\u0010æ\u0001\u001a\u00020BH\u0002J\n\u0010ç\u0001\u001a\u00030¶\u0001H\u0002J\u001d\u0010è\u0001\u001a\u00030¾\u00012\b\u0010Á\u0001\u001a\u00030é\u00012\u0007\u0010ê\u0001\u001a\u00020BH\u0002J\n\u0010ë\u0001\u001a\u00030¾\u0001H\u0002J\n\u0010ì\u0001\u001a\u00030¾\u0001H\u0002J\t\u0010í\u0001\u001a\u00020BH\u0002J\t\u0010î\u0001\u001a\u00020BH\u0002J\t\u0010ï\u0001\u001a\u00020BH\u0002J\n\u0010ð\u0001\u001a\u00030¾\u0001H\u0002J\n\u0010ñ\u0001\u001a\u00030¾\u0001H\u0002J!\u0010ò\u0001\u001a\u00030¾\u00012\t\u0010ê\u0001\u001a\u0004\u0018\u00010B2\n\u0010Á\u0001\u001a\u0005\u0018\u00010é\u0001H\u0016J\n\u0010ó\u0001\u001a\u00030¾\u0001H\u0016J\u0012\u0010ä\u0002\u001a\u00030¾\u00012\b\u0010º\u0002\u001a\u00030»\u0002J\u0014\u0010å\u0002\u001a\u00030¾\u00012\b\u0010æ\u0002\u001a\u00030Ç\u0001H\u0002J\u0013\u0010ç\u0002\u001a\u00020\u00152\n\u0010è\u0002\u001a\u0005\u0018\u00010â\u0001J\n\u0010å\u0002\u001a\u00030¾\u0001H\u0002J\u001c\u0010é\u0002\u001a\u00030¾\u00012\b\u0010ê\u0002\u001a\u00030Ç\u00012\b\u0010º\u0002\u001a\u00030»\u0002J\n\u0010ë\u0002\u001a\u00030¾\u0001H\u0002J\u001b\u0010ì\u0002\u001a\u00030¾\u00012\u0007\u0010í\u0002\u001a\u00020B2\b\u0010î\u0002\u001a\u00030Á\u0002J\u0011\u0010ï\u0002\u001a\u00030¾\u00012\u0007\u0010í\u0002\u001a\u00020BJ\u001c\u0010ð\u0002\u001a\u00030¾\u00012\u0007\u0010ñ\u0002\u001a\u00020B2\u0007\u0010í\u0002\u001a\u00020BH\u0002J\u001b\u0010ò\u0002\u001a\u00030¾\u00012\u0007\u0010í\u0002\u001a\u00020B2\b\u0010ó\u0002\u001a\u00030Þ\u0002J7\u0010ô\u0002\u001a\u00030¾\u00012\u0019\u0010õ\u0002\u001a\u0014\u0012\u0005\u0012\u00030»\u00020wj\t\u0012\u0005\u0012\u00030»\u0002`y2\b\u0010ö\u0002\u001a\u00030¨\u00022\b\u0010÷\u0002\u001a\u00030¶\u0001J\u001e\u0010ø\u0002\u001a\u00030¾\u00012\b\u0010ù\u0002\u001a\u00030Ç\u00012\b\u0010º\u0002\u001a\u00030»\u0002H\u0016J9\u0010ú\u0002\u001a\u00030¾\u00012\u0019\u0010û\u0002\u001a\u0014\u0012\u0005\u0012\u00030»\u00020wj\t\u0012\u0005\u0012\u00030»\u0002`y2\b\u0010§\u0002\u001a\u00030¨\u00022\b\u0010ü\u0002\u001a\u00030¶\u0001H\u0016J\n\u0010ý\u0002\u001a\u00030¾\u0001H\u0002J\n\u0010þ\u0002\u001a\u00030¾\u0001H\u0002J\u0011\u0010þ\u0002\u001a\u00030¾\u00012\u0007\u0010\u0085\u0002\u001a\u00020\u0015J\n\u0010ÿ\u0002\u001a\u00030¾\u0001H\u0002J\n\u0010\u0080\u0003\u001a\u00030¾\u0001H\u0002J4\u0010\u0081\u0003\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010B\u0018\u00010\u0082\u00032\t\u0010\u0083\u0003\u001a\u0004\u0018\u00010B2\t\u0010\u0084\u0003\u001a\u0004\u0018\u00010B2\b\u0010\u0085\u0003\u001a\u00030\u0086\u0003H\u0016J/\u0010\u0087\u0003\u001a\u00030¾\u00012\b\u0010\u0088\u0003\u001a\u00030é\u00012\u0007\u0010\u0083\u0003\u001a\u00020B2\u0007\u0010\u0084\u0003\u001a\u00020B2\u0007\u0010\u0089\u0003\u001a\u00020\u0015H\u0016J+\u0010\u008a\u0003\u001a\u00030¾\u00012\t\u0010\u008b\u0003\u001a\u0004\u0018\u00010B2\t\u0010\u0083\u0003\u001a\u0004\u0018\u00010B2\t\u0010\u0084\u0003\u001a\u0004\u0018\u00010BH\u0016J\b\u0010\u0098\u0003\u001a\u00030¾\u0001J\b\u0010\u0099\u0003\u001a\u00030¾\u0001J6\u0010\u009a\u0003\u001a\u00030¾\u00012\u0007\u0010¤\u0001\u001a\u00020B2\b\u0010\u009b\u0003\u001a\u00030¶\u00012\u0007\u0010§\u0001\u001a\u00020B2\u0007\u0010\u009c\u0003\u001a\u00020B2\u0007\u0010\u009d\u0003\u001a\u00020BJH\u0010\u009e\u0003\u001a\u00030¾\u00012\u0007\u0010¤\u0001\u001a\u00020B2\b\u0010\u009b\u0003\u001a\u00030¶\u00012\u0007\u0010ª\u0001\u001a\u00020B2\u0007\u0010\u009f\u0003\u001a\u00020B2\u0007\u0010 \u0003\u001a\u00020B2\u0007\u0010¡\u0003\u001a\u00020B2\u0007\u0010¢\u0003\u001a\u00020BJ\u001b\u0010£\u0003\u001a\u00030¾\u00012\u0007\u0010¤\u0001\u001a\u00020B2\b\u0010\u009b\u0003\u001a\u00030¶\u0001JO\u0010¤\u0003\u001a\u00030¾\u00012\b\u0010Á\u0001\u001a\u00030é\u00012\u0007\u0010¥\u0003\u001a\u00020\u00152\u0007\u0010¤\u0001\u001a\u00020B2\u0007\u0010\u009b\u0003\u001a\u00020\u00172\u000b\b\u0002\u0010\u0084\u0001\u001a\u0004\u0018\u00010x2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;2\u0007\u0010¦\u0003\u001a\u00020BJ\u001b\u0010§\u0003\u001a\u00030¾\u00012\u0007\u0010¨\u0003\u001a\u00020B2\b\u0010\u009b\u0003\u001a\u00030¶\u0001J$\u0010©\u0003\u001a\u00030¾\u00012\u0007\u0010\u009f\u0003\u001a\u00020B2\b\u0010\u009b\u0003\u001a\u00030¶\u00012\u0007\u0010ê\u0001\u001a\u00020BJ\u001b\u0010ª\u0003\u001a\u00030¾\u00012\u0007\u0010§\u0001\u001a\u00020B2\b\u0010\u009b\u0003\u001a\u00030¶\u0001J\u001b\u0010«\u0003\u001a\u00030¾\u00012\u0007\u0010¬\u0003\u001a\u00020B2\b\u0010\u009b\u0003\u001a\u00030¶\u0001J\b\u0010³\u0003\u001a\u00030¾\u0001J\u0013\u0010´\u0003\u001a\u00030¾\u00012\t\u0010µ\u0003\u001a\u0004\u0018\u00010BJ\u001d\u0010¶\u0003\u001a\u00030¾\u00012\b\u0010·\u0003\u001a\u00030¶\u00012\t\u0010µ\u0003\u001a\u0004\u0018\u00010BJ,\u0010¸\u0003\u001a\u00030¾\u00012\u0007\u0010¹\u0003\u001a\u00020B2\u0007\u0010º\u0003\u001a\u00020B2\u0007\u0010»\u0003\u001a\u00020B2\u0007\u0010¼\u0003\u001a\u00020BJ\u0013\u0010½\u0003\u001a\u00030¾\u00012\t\u0010¾\u0003\u001a\u0004\u0018\u00010BJ\u0011\u0010¿\u0003\u001a\u00030¾\u00012\u0007\u0010À\u0003\u001a\u00020\u0015J\u0012\u0010Ç\u0003\u001a\u00030¾\u00012\b\u0010Á\u0001\u001a\u00030é\u0001J\b\u0010È\u0003\u001a\u00030¶\u0001J\b\u0010É\u0003\u001a\u00030¶\u0001J\b\u0010Ì\u0003\u001a\u00030¾\u0001J\u0014\u0010Õ\u0003\u001a\u00030¾\u00012\n\u0010ù\u0002\u001a\u0005\u0018\u00010Ç\u0001J\b\u0010Ö\u0003\u001a\u00030¾\u0001J\b\u0010×\u0003\u001a\u00030¾\u0001J\b\u0010Ø\u0003\u001a\u00030¾\u0001J\n\u0010Ù\u0003\u001a\u00030¾\u0001H\u0016J\b\u0010Ú\u0003\u001a\u00030¾\u0001J6\u0010Û\u0003\u001a\u00030¾\u00012\b\u0010ù\u0002\u001a\u00030Ç\u00012\u0007\u0010Ü\u0003\u001a\u00020B2\u0007\u0010Ý\u0003\u001a\u00020B2\u0007\u0010Þ\u0003\u001a\u00020B2\u0007\u0010¤\u0002\u001a\u00020BJ\b\u0010ß\u0003\u001a\u00030¾\u0001R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u000205X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u00010;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u000e\u0010@\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010E\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001c\u0010J\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010G\"\u0004\bL\u0010IR\u001c\u0010M\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010G\"\u0004\bN\u0010IR\u001a\u0010O\u001a\u00020PX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001c\u0010U\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010G\"\u0004\bW\u0010IR\u001c\u0010X\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010G\"\u0004\bZ\u0010IR\u001c\u0010[\u001a\u0004\u0018\u00010\\X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u001a\u0010a\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010G\"\u0004\bc\u0010IR\u001a\u0010d\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010G\"\u0004\bf\u0010IR\u001a\u0010g\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010G\"\u0004\bi\u0010IR\u001a\u0010j\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010G\"\u0004\bl\u0010IR\u001a\u0010m\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010G\"\u0004\bo\u0010IR\u001a\u0010p\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u001a\u0010t\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010q\"\u0004\bu\u0010sR*\u0010v\u001a\u0012\u0012\u0004\u0012\u00020x0wj\b\u0012\u0004\u0012\u00020x`yX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R+\u0010~\u001a\u0012\u0012\u0004\u0012\u00020x0wj\b\u0012\u0004\u0012\u00020x`yX\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u0010{\"\u0005\b\u0080\u0001\u0010}R-\u0010\u0081\u0001\u001a\u0012\u0012\u0004\u0012\u00020x0wj\b\u0012\u0004\u0012\u00020x`yX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010{\"\u0005\b\u0083\u0001\u0010}R\u001f\u0010\u0084\u0001\u001a\u00020xX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001d\u0010\u0089\u0001\u001a\u00020BX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u0010G\"\u0005\b\u008b\u0001\u0010IR\u001d\u0010\u008c\u0001\u001a\u00020BX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0001\u0010G\"\u0005\b\u008e\u0001\u0010IR\u001d\u0010\u008f\u0001\u001a\u00020PX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010R\"\u0005\b\u0091\u0001\u0010TR\u001f\u0010\u0092\u0001\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010G\"\u0005\b\u0094\u0001\u0010IR\u001d\u0010\u0095\u0001\u001a\u00020BX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0001\u0010G\"\u0005\b\u0097\u0001\u0010IR\u001f\u0010\u0098\u0001\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0099\u0001\u0010G\"\u0005\b\u009a\u0001\u0010IR\u001f\u0010\u009b\u0001\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009c\u0001\u0010G\"\u0005\b\u009d\u0001\u0010IR\u001f\u0010\u009e\u0001\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009f\u0001\u0010G\"\u0005\b \u0001\u0010IR\u001f\u0010¡\u0001\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¢\u0001\u0010G\"\u0005\b£\u0001\u0010IR\u001f\u0010¤\u0001\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¥\u0001\u0010G\"\u0005\b¦\u0001\u0010IR\u001d\u0010§\u0001\u001a\u00020BX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¨\u0001\u0010G\"\u0005\b©\u0001\u0010IR\u001d\u0010ª\u0001\u001a\u00020BX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b«\u0001\u0010G\"\u0005\b¬\u0001\u0010IR\u001d\u0010\u00ad\u0001\u001a\u00020\u0015X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b®\u0001\u0010q\"\u0005\b¯\u0001\u0010sR\u000f\u0010°\u0001\u001a\u00020BX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010±\u0001\u001a\u0005\u0018\u00010²\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010³\u0001\u001a\u00020\u0015X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b³\u0001\u0010q\"\u0005\b´\u0001\u0010sR \u0010µ\u0001\u001a\u00030¶\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b·\u0001\u0010¸\u0001\"\u0006\b¹\u0001\u0010º\u0001R\u0010\u0010»\u0001\u001a\u00030¼\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010ô\u0001\u001a\u00020\u0015X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bõ\u0001\u0010q\"\u0005\bö\u0001\u0010sR\u001d\u0010÷\u0001\u001a\u00020\u0015X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b÷\u0001\u0010q\"\u0005\bø\u0001\u0010sR\u001f\u0010ù\u0001\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bú\u0001\u0010G\"\u0005\bû\u0001\u0010IR\u001d\u0010ü\u0001\u001a\u00020BX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bý\u0001\u0010G\"\u0005\bþ\u0001\u0010IR\u001d\u0010ÿ\u0001\u001a\u00020BX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0002\u0010G\"\u0005\b\u0081\u0002\u0010IR\u001d\u0010\u0082\u0002\u001a\u00020BX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0002\u0010G\"\u0005\b\u0084\u0002\u0010IR\u001d\u0010\u0085\u0002\u001a\u00020\u0015X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0002\u0010q\"\u0005\b\u0086\u0002\u0010sR\u001d\u0010\u0087\u0002\u001a\u00020BX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0002\u0010G\"\u0005\b\u0089\u0002\u0010IR\"\u0010\u008a\u0002\u001a\u0005\u0018\u00010\u008b\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008c\u0002\u0010\u008d\u0002\"\u0006\b\u008e\u0002\u0010\u008f\u0002R\"\u0010\u0090\u0002\u001a\u0005\u0018\u00010\u008b\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0091\u0002\u0010\u008d\u0002\"\u0006\b\u0092\u0002\u0010\u008f\u0002R\"\u0010\u0093\u0002\u001a\u0005\u0018\u00010\u0094\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0095\u0002\u0010\u0096\u0002\"\u0006\b\u0097\u0002\u0010\u0098\u0002R\"\u0010\u0099\u0002\u001a\u0005\u0018\u00010Ç\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009a\u0002\u0010\u009b\u0002\"\u0006\b\u009c\u0002\u0010\u009d\u0002R\"\u0010\u009e\u0002\u001a\u0005\u0018\u00010\u009f\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b \u0002\u0010¡\u0002\"\u0006\b¢\u0002\u0010£\u0002R\u001f\u0010¤\u0002\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¥\u0002\u0010G\"\u0005\b¦\u0002\u0010IR\"\u0010§\u0002\u001a\u0005\u0018\u00010¨\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b©\u0002\u0010ª\u0002\"\u0006\b«\u0002\u0010¬\u0002R\u001d\u0010\u00ad\u0002\u001a\u00020BX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b®\u0002\u0010G\"\u0005\b¯\u0002\u0010IR \u0010°\u0002\u001a\u00030¶\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b±\u0002\u0010¸\u0001\"\u0006\b²\u0002\u0010º\u0001R\"\u0010³\u0002\u001a\u0005\u0018\u00010\u009f\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b´\u0002\u0010¡\u0002\"\u0006\bµ\u0002\u0010£\u0002R\u001d\u0010¶\u0002\u001a\u00020\u0015X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¶\u0002\u0010q\"\u0005\b·\u0002\u0010sR\u001d\u0010¸\u0002\u001a\u00020\u0015X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¸\u0002\u0010q\"\u0005\b¹\u0002\u0010sR\"\u0010º\u0002\u001a\u0005\u0018\u00010»\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¼\u0002\u0010½\u0002\"\u0006\b¾\u0002\u0010¿\u0002R\"\u0010À\u0002\u001a\u0005\u0018\u00010Á\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÂ\u0002\u0010Ã\u0002\"\u0006\bÄ\u0002\u0010Å\u0002R\"\u0010Æ\u0002\u001a\u0005\u0018\u00010Á\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÇ\u0002\u0010Ã\u0002\"\u0006\bÈ\u0002\u0010Å\u0002R\"\u0010É\u0002\u001a\u0005\u0018\u00010\u0094\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÊ\u0002\u0010\u0096\u0002\"\u0006\bË\u0002\u0010\u0098\u0002R\"\u0010Ì\u0002\u001a\u0005\u0018\u00010Í\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÎ\u0002\u0010Ï\u0002\"\u0006\bÐ\u0002\u0010Ñ\u0002R\"\u0010Ò\u0002\u001a\u0005\u0018\u00010â\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÓ\u0002\u0010Ô\u0002\"\u0006\bÕ\u0002\u0010Ö\u0002R\"\u0010×\u0002\u001a\u0005\u0018\u00010Ø\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÙ\u0002\u0010Ú\u0002\"\u0006\bÛ\u0002\u0010Ü\u0002R/\u0010Ý\u0002\u001a\u0014\u0012\u0005\u0012\u00030Þ\u00020wj\t\u0012\u0005\u0012\u00030Þ\u0002`yX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bß\u0002\u0010{\"\u0005\bà\u0002\u0010}R/\u0010á\u0002\u001a\u0014\u0012\u0005\u0012\u00030»\u00020wj\t\u0012\u0005\u0012\u00030»\u0002`yX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bâ\u0002\u0010{\"\u0005\bã\u0002\u0010}R\u0019\u0010\u008c\u0003\u001a\f\u0012\u0005\u0012\u00030Â\u0001\u0018\u00010\u008d\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u008e\u0003\u001a\f\u0012\u0005\u0012\u00030Â\u0001\u0018\u00010\u008d\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u008f\u0003\u001a\f\u0012\u0005\u0012\u00030Â\u0001\u0018\u00010\u008d\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0090\u0003\u001a\f\u0012\u0005\u0012\u00030Â\u0001\u0018\u00010\u008d\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0091\u0003\u001a\f\u0012\u0005\u0012\u00030Â\u0001\u0018\u00010\u008d\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0092\u0003\u001a\f\u0012\u0005\u0012\u00030Â\u0001\u0018\u00010\u008d\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0093\u0003\u001a\f\u0012\u0005\u0012\u00030Â\u0001\u0018\u00010\u008d\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0094\u0003\u001a\f\u0012\u0005\u0012\u00030Â\u0001\u0018\u00010\u008d\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0095\u0003\u001a\u00020BX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0003\u0010G\"\u0005\b\u0097\u0003\u0010IR+\u0010\u00ad\u0003\u001a\r ®\u0003*\u0005\u0018\u00010\u0086\u00030\u0086\u00038BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b±\u0003\u0010²\u0003\u001a\u0006\b¯\u0003\u0010°\u0003R\"\u0010Á\u0003\u001a\u0005\u0018\u00010Â\u0003X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÃ\u0003\u0010Ä\u0003\"\u0006\bÅ\u0003\u0010Æ\u0003R\u0012\u0010Ê\u0003\u001a\u0005\u0018\u00010Ë\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Í\u0003\u001a\u0005\u0018\u00010Î\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010Ï\u0003\u001a\u0005\u0018\u00010Ð\u0003X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÑ\u0003\u0010Ò\u0003\"\u0006\bÓ\u0003\u0010Ô\u0003¨\u0006â\u0003"}, d2 = {"Lcom/appnew/android/Payment/InstantPurchase;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "Lcom/appnew/android/Payment/OnCouponClicked;", "Lcom/appnew/android/Payment/OnAddressAddDeleteClicked;", "Lcom/appnew/android/Utils/PaymentTypeCheck;", "<init>", "()V", "paymentGatewayListener", "Lcom/appnew/android/Payment/PaymentGatewayListener;", "getPaymentGatewayListener", "()Lcom/appnew/android/Payment/PaymentGatewayListener;", "setPaymentGatewayListener", "(Lcom/appnew/android/Payment/PaymentGatewayListener;)V", "payeResultListener", "Lcom/razorpay/PaymentResultListener;", "getPayeResultListener", "()Lcom/razorpay/PaymentResultListener;", "setPayeResultListener", "(Lcom/razorpay/PaymentResultListener;)V", "fromDashboard", "", "mLastClickTime", "", "getMLastClickTime", "()J", "setMLastClickTime", "(J)V", "myDBClass", "Lcom/appnew/android/Room/UtkashRoom;", "getMyDBClass", "()Lcom/appnew/android/Room/UtkashRoom;", "setMyDBClass", "(Lcom/appnew/android/Room/UtkashRoom;)V", "themeSettings", "Lcom/appnew/android/table/ThemeSettings;", "getThemeSettings", "()Lcom/appnew/android/table/ThemeSettings;", "setThemeSettings", "(Lcom/appnew/android/table/ThemeSettings;)V", "bottomSetting", "Lcom/appnew/android/Model/BottomSetting;", "getBottomSetting", "()Lcom/appnew/android/Model/BottomSetting;", "setBottomSetting", "(Lcom/appnew/android/Model/BottomSetting;)V", "leftMenu", "Lcom/appnew/android/Model/LeftMenu;", "getLeftMenu", "()Lcom/appnew/android/Model/LeftMenu;", "setLeftMenu", "(Lcom/appnew/android/Model/LeftMenu;)V", "binding", "Lcom/appnew/android/databinding/InstantPurchaseLayoutBinding;", "getBinding", "()Lcom/appnew/android/databinding/InstantPurchaseLayoutBinding;", "setBinding", "(Lcom/appnew/android/databinding/InstantPurchaseLayoutBinding;)V", "courseDetail", "Lcom/appnew/android/Model/COURSEDETAIL/CourseDetail;", "getCourseDetail", "()Lcom/appnew/android/Model/COURSEDETAIL/CourseDetail;", "setCourseDetail", "(Lcom/appnew/android/Model/COURSEDETAIL/CourseDetail;)V", "is_load_form", "test_data", "", "test_id", "test_mode", Const.COMBO_ID, "getCombo_id", "()Ljava/lang/String;", "setCombo_id", "(Ljava/lang/String;)V", "mainCourseId", "getMainCourseId", "setMainCourseId", "isBook", "setBook", "deliveryCharge", "", "getDeliveryCharge", "()F", "setDeliveryCharge", "(F)V", "quantityOfBooks", "getQuantityOfBooks", "setQuantityOfBooks", "parentCourseId", "getParentCourseId", "setParentCourseId", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "appliedCouponCode", "getAppliedCouponCode", "setAppliedCouponCode", "appliedCouponCodeId", "getAppliedCouponCodeId", "setAppliedCouponCodeId", "selectedCouponId", "getSelectedCouponId", "setSelectedCouponId", "secondCouponCode", "getSecondCouponCode", "setSecondCouponCode", "paymentModeValue", "getPaymentModeValue", "setPaymentModeValue", "isCouponGiven", "()Z", "setCouponGiven", "(Z)V", "isSelfCoupon", "setSelfCoupon", "selfCouponArrayList", "Ljava/util/ArrayList;", "Lcom/appnew/android/Coupon/Models/CoursesCoupon;", "Lkotlin/collections/ArrayList;", "getSelfCouponArrayList", "()Ljava/util/ArrayList;", "setSelfCouponArrayList", "(Ljava/util/ArrayList;)V", "preCouponArrayList", "getPreCouponArrayList", "setPreCouponArrayList", "coursesCouponArrayList", "getCoursesCouponArrayList", "setCoursesCouponArrayList", "coursesCoupon", "getCoursesCoupon", "()Lcom/appnew/android/Coupon/Models/CoursesCoupon;", "setCoursesCoupon", "(Lcom/appnew/android/Coupon/Models/CoursesCoupon;)V", FirebaseAnalytics.Param.PRICE, "getPrice", "setPrice", "tax", "getTax", "setTax", "toPayAmount", "getToPayAmount", "setToPayAmount", "course_id", "getCourse_id", "setCourse_id", "coupon_applied", "getCoupon_applied", "setCoupon_applied", "rid", "getRid", "setRid", "amt", "getAmt", "setAmt", "scd", "getScd", "setScd", "pos_txn_id", "getPos_txn_id", "setPos_txn_id", "pre_txtid", "getPre_txtid", "setPre_txtid", "txnToken", "getTxnToken", "setTxnToken", "enc_val", "getEnc_val", "setEnc_val", "isfailure", "getIsfailure", "setIsfailure", "product_id", "billingClient", "Lcom/android/billingclient/api/BillingClient;", "isPayViaQR", "setPayViaQR", "stopValidationOnCoupon", "", "getStopValidationOnCoupon", "()I", "setStopValidationOnCoupon", "(I)V", "purchasesUpdatedListener", "Lcom/android/billingclient/api/PurchasesUpdatedListener;", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "handlePaymnetbuttonClick", "setRefundRelatedData", "setTermRelatedData", "setImageViewWidth", "setCourseImage", "isComboBook", "isShowAddress", "isComboBookAddress", "isSinglePrefillAvailable", "setPurchaseDataWithCoupon", "isAfterCouponApply", "priceUpdate", "isCouponApplied", "setGstAndDeliveryTxt", "manageCouponUI", "checkAvailableCoupons", "manageCouponApply", "coupon_edt", "Landroid/widget/EditText;", "onCouponClicked", "couponEdit", "showMessage", "message", "calculateAmount", "paymentGateways", "Lorg/json/JSONObject;", "mode", "callPaymentMode", "handlePaymentError", "callApiIntPayment", "callApiIntPaymentOnFailure", "callApiIntPaymentOnSuccess", "success_dailog", "callServiceForInvoice", "onPaymentType", "onPaymentTypeCancel", "haveAddress", "getHaveAddress", "setHaveAddress", "isDefault", "setDefault", "stateindex", "getStateindex", "setStateindex", "cityindex", "getCityindex", "setCityindex", "SelectedStateid", "getSelectedStateid", "setSelectedStateid", "SelectedCityid", "getSelectedCityid", "setSelectedCityid", "isFirstTime", "setFirstTime", "clicktype", "getClicktype", "setClicktype", "statesTV", "Landroid/widget/TextView;", "getStatesTV", "()Landroid/widget/TextView;", "setStatesTV", "(Landroid/widget/TextView;)V", "districtTV", "getDistrictTV", "setDistrictTV", "recyclerViewSavedAddress", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerViewSavedAddress", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerViewSavedAddress", "(Landroidx/recyclerview/widget/RecyclerView;)V", "dialogGettingSavedAddress", "getDialogGettingSavedAddress", "()Landroid/app/Dialog;", "setDialogGettingSavedAddress", "(Landroid/app/Dialog;)V", "address1", "Lcom/appnew/android/Model/Address;", "getAddress1", "()Lcom/appnew/android/Model/Address;", "setAddress1", "(Lcom/appnew/android/Model/Address;)V", "addressJson", "getAddressJson", "setAddressJson", "addressAdapter", "Lcom/appnew/android/Courses/Adapter/AddressAdapter;", "getAddressAdapter", "()Lcom/appnew/android/Courses/Adapter/AddressAdapter;", "setAddressAdapter", "(Lcom/appnew/android/Courses/Adapter/AddressAdapter;)V", "addressId", "getAddressId", "setAddressId", "addressPosition", "getAddressPosition", "setAddressPosition", "address", "getAddress", "setAddress", "isAddressEdited", "setAddressEdited", "isWantToUpdate", "setWantToUpdate", "addressMaster", "Lcom/appnew/android/Model/AddressMaster;", "getAddressMaster", "()Lcom/appnew/android/Model/AddressMaster;", "setAddressMaster", "(Lcom/appnew/android/Model/AddressMaster;)V", "states", "Lcom/appnew/android/pojo/Userinfo/StatesCities/StatesCities;", "getStates", "()Lcom/appnew/android/pojo/Userinfo/StatesCities/StatesCities;", "setStates", "(Lcom/appnew/android/pojo/Userinfo/StatesCities/StatesCities;)V", "cities", "getCities", "setCities", "searchRecyclerview", "getSearchRecyclerview", "setSearchRecyclerview", "stateCityAdapter", "Lcom/appnew/android/Payment/InstantPurchase$StateCityAdapter;", "getStateCityAdapter", "()Lcom/appnew/android/Payment/InstantPurchase$StateCityAdapter;", "setStateCityAdapter", "(Lcom/appnew/android/Payment/InstantPurchase$StateCityAdapter;)V", "etSearch", "getEtSearch", "()Landroid/widget/EditText;", "setEtSearch", "(Landroid/widget/EditText;)V", "ivClearSearch", "Landroid/widget/ImageView;", "getIvClearSearch", "()Landroid/widget/ImageView;", "setIvClearSearch", "(Landroid/widget/ImageView;)V", "statesCitiesArrayList", "Lcom/appnew/android/pojo/Userinfo/StatesCities/StatesCitiesData;", "getStatesCitiesArrayList", "setStatesCitiesArrayList", "addressListMaster", "getAddressListMaster", "setAddressListMaster", "getAddressDetail", "addressDailog", "leftOverDialog", "numberValidation", "mobileNumberEditText", "addressDailogInner", "innerDialog", "getSavedAddressDailog", "filterList", "searchType", "countryArrayList", "textWatcher", "filter", "text", "onStateCityClick", UserDataStore.COUNTRY, "deleteAddress", "addressMasterListNew", "addressAdapterNew", "addressPositionNew", "onAddAddressClicked", "dialog", "onDeleteAddressClicked", "addressMasterList", "adapterPosition", "hit_api_to_get_state", "hitApiForGettingAddress", "hitApiForSavingAddress", "hit_api_to_get_city", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonobject", "showprogress", "ErrorCallBack", "jsonstring", "resultLauncherPaytm", "Landroidx/activity/result/ActivityResultLauncher;", "resultLauncherCCAvenue", "resultLauncherFonePay", "resultLauncherEaseBuzz", "resultLauncherESewa", "resultLauncherBillDesk", "resultLauncherWorldLine", "resultLauncherEasyPay", "payVia", "getPayVia", "setPayVia", "initPaymentGateway", "registers", "launchPaytmPaymentGateway", "amount", "mid", "url", "launchCcAvenuePaymentGateway", "access_code", "redirect_url", "cancel_url", "post_url", "launchESewaPaymentGateway", "launchRazorPayPaymentGateway", "withCouponLayout", "razorpayKey", "launchFonePayPaymentGateway", "fonePayUrl", "launchEaseBuzzPaymentGateway", "launchBillDeskPaymentGateway", "launchEasyPayPaymentGateway", "easyPayUrl", "webService", "kotlin.jvm.PlatformType", "getWebService", "()Lcom/appnew/android/Utils/Network/APIInterface;", "webService$delegate", "Lkotlin/Lazy;", "getPaymentCredentials", "onPaymentSuccess", CmcdData.Factory.STREAMING_FORMAT_SS, "onPaymentError", CmcdData.Factory.OBJECT_TYPE_INIT_SEGMENT, "onSuccessEsewa", "productId", "totalAmount", "referenceId", "scdId", "onSuccess", "posTxnId", "onFailed", "isFailure", "txnTokenData", "Lcom/appnew/android/Model/TxnTokenData;", "getTxnTokenData", "()Lcom/appnew/android/Model/TxnTokenData;", "setTxnTokenData", "(Lcom/appnew/android/Model/TxnTokenData;)V", "manageQRPayment", "getDeviceWidthWithInsets", "getDeviceHeightWithInsets", "countDownTimer", "Landroid/os/CountDownTimer;", "openQRCode", "mFirebaseDatabaseReferenceQRPay", "Lcom/google/firebase/database/DatabaseReference;", "qrPayValueEventListener", "Lcom/google/firebase/database/ValueEventListener;", "getQrPayValueEventListener", "()Lcom/google/firebase/database/ValueEventListener;", "setQrPayValueEventListener", "(Lcom/google/firebase/database/ValueEventListener;)V", "qrPaymentCallback", "enableScreenshot", "hideKeyboard", "closePaymentDialog", "dismiss", "showUpdateStatePopup", "submitUpdateStateData", "submitType", "stateId", "districtId", "finishPayment", "Companion", "StateCityAdapter", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InstantPurchase extends BottomSheetDialogFragment implements NetworkCall.MyNetworkCallBack, OnCouponClicked, OnAddressAddDeleteClicked, PaymentTypeCheck {
    private Address address;
    private Address address1;
    private AddressAdapter addressAdapter;
    private String addressJson;
    private AddressMaster addressMaster;
    private int addressPosition;
    private String amt;
    private BillingClient billingClient;
    public InstantPurchaseLayoutBinding binding;
    private BottomSetting bottomSetting;
    private StatesCities cities;
    private CountDownTimer countDownTimer;
    private CourseDetail courseDetail;
    private float deliveryCharge;
    private Dialog dialogGettingSavedAddress;
    private TextView districtTV;
    private EditText etSearch;
    private boolean fromDashboard;
    private boolean haveAddress;
    private boolean isAddressEdited;
    private boolean isCouponGiven;
    private boolean isDefault;
    private boolean isFirstTime;
    private boolean isPayViaQR;
    private boolean isSelfCoupon;
    private boolean is_load_form;
    private boolean isfailure;
    private ImageView ivClearSearch;
    private LeftMenu leftMenu;
    private DatabaseReference mFirebaseDatabaseReferenceQRPay;
    private long mLastClickTime;
    private UtkashRoom myDBClass;
    private NetworkCall networkCall;
    private PaymentResultListener payeResultListener;
    private PaymentGatewayListener paymentGatewayListener;
    private ValueEventListener qrPayValueEventListener;
    private RecyclerView recyclerViewSavedAddress;
    private ActivityResultLauncher<Intent> resultLauncherBillDesk;
    private ActivityResultLauncher<Intent> resultLauncherCCAvenue;
    private ActivityResultLauncher<Intent> resultLauncherESewa;
    private ActivityResultLauncher<Intent> resultLauncherEaseBuzz;
    private ActivityResultLauncher<Intent> resultLauncherEasyPay;
    private ActivityResultLauncher<Intent> resultLauncherFonePay;
    private ActivityResultLauncher<Intent> resultLauncherPaytm;
    private ActivityResultLauncher<Intent> resultLauncherWorldLine;
    private String rid;
    private RecyclerView searchRecyclerview;
    private StateCityAdapter stateCityAdapter;
    private StatesCities states;
    private TextView statesTV;
    private int stopValidationOnCoupon;
    private ThemeSettings themeSettings;
    private float toPayAmount;
    private TxnTokenData txnTokenData;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private String test_data = "";
    private String test_id = "";
    private String test_mode = "";
    private String combo_id = "";
    private String mainCourseId = "";
    private String isBook = "";
    private String quantityOfBooks = "1";
    private String parentCourseId = "";
    private String appliedCouponCode = "";
    private String appliedCouponCodeId = "";
    private String selectedCouponId = "";
    private String secondCouponCode = "";
    private String paymentModeValue = "0";
    private ArrayList<CoursesCoupon> selfCouponArrayList = new ArrayList<>();
    private ArrayList<CoursesCoupon> preCouponArrayList = new ArrayList<>();
    private ArrayList<CoursesCoupon> coursesCouponArrayList = new ArrayList<>();
    private CoursesCoupon coursesCoupon = new CoursesCoupon();
    private String price = "";
    private String tax = "";
    private String course_id = "";
    private String coupon_applied = "0";
    private String scd = "";
    private String pos_txn_id = "";
    private String pre_txtid = "";
    private String txnToken = "";
    private String enc_val = "";
    private String product_id = "";
    private final PurchasesUpdatedListener purchasesUpdatedListener = new PurchasesUpdatedListener() { // from class: com.appnew.android.Payment.InstantPurchase$$ExternalSyntheticLambda0
        @Override // com.android.billingclient.api.PurchasesUpdatedListener
        public final void onPurchasesUpdated(BillingResult billingResult, List list) {
            InstantPurchase.purchasesUpdatedListener$lambda$1(this.f$0, billingResult, list);
        }
    };
    private String stateindex = "";
    private String cityindex = "";
    private String SelectedStateid = "";
    private String SelectedCityid = "";
    private String clicktype = "";
    private String addressId = "";
    private boolean isWantToUpdate = true;
    private ArrayList<StatesCitiesData> statesCitiesArrayList = new ArrayList<>();
    private ArrayList<AddressMaster> addressListMaster = new ArrayList<>();
    private String payVia = "3";

    /* JADX INFO: renamed from: webService$delegate, reason: from kotlin metadata */
    private final Lazy webService = LazyKt.lazy(new Function0() { // from class: com.appnew.android.Payment.InstantPurchase$$ExternalSyntheticLambda11
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return InstantPurchase.webService_delegate$lambda$124();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteAddress$lambda$111() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openQRCode$lambda$128$lambda$127() {
    }

    @Override // com.appnew.android.Utils.PaymentTypeCheck
    public void onPaymentTypeCancel() {
    }

    public final PaymentGatewayListener getPaymentGatewayListener() {
        return this.paymentGatewayListener;
    }

    public final void setPaymentGatewayListener(PaymentGatewayListener paymentGatewayListener) {
        this.paymentGatewayListener = paymentGatewayListener;
    }

    public final PaymentResultListener getPayeResultListener() {
        return this.payeResultListener;
    }

    public final void setPayeResultListener(PaymentResultListener paymentResultListener) {
        this.payeResultListener = paymentResultListener;
    }

    /* JADX INFO: compiled from: InstantPurchase.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, d2 = {"Lcom/appnew/android/Payment/InstantPurchase$Companion;", "", "<init>", "()V", "newInstance", "Lcom/appnew/android/Payment/InstantPurchase;", "paymentGatewayListener", "Lcom/appnew/android/Payment/PaymentGatewayListener;", "paymentResultListener", "Lcom/razorpay/PaymentResultListener;", "fromDashboard", "", "args", "Landroid/os/Bundle;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final InstantPurchase newInstance(PaymentGatewayListener paymentGatewayListener, PaymentResultListener paymentResultListener, boolean fromDashboard, Bundle args) {
            Intrinsics.checkNotNullParameter(paymentGatewayListener, "paymentGatewayListener");
            Intrinsics.checkNotNullParameter(paymentResultListener, "paymentResultListener");
            Intrinsics.checkNotNullParameter(args, "args");
            InstantPurchase instantPurchase = new InstantPurchase();
            instantPurchase.setArguments(args);
            instantPurchase.setPaymentGatewayListener(paymentGatewayListener);
            instantPurchase.setPayeResultListener(paymentResultListener);
            instantPurchase.fromDashboard = fromDashboard;
            return instantPurchase;
        }
    }

    public final long getMLastClickTime() {
        return this.mLastClickTime;
    }

    public final void setMLastClickTime(long j) {
        this.mLastClickTime = j;
    }

    public final UtkashRoom getMyDBClass() {
        return this.myDBClass;
    }

    public final void setMyDBClass(UtkashRoom utkashRoom) {
        this.myDBClass = utkashRoom;
    }

    public final ThemeSettings getThemeSettings() {
        return this.themeSettings;
    }

    public final void setThemeSettings(ThemeSettings themeSettings) {
        this.themeSettings = themeSettings;
    }

    public final BottomSetting getBottomSetting() {
        return this.bottomSetting;
    }

    public final void setBottomSetting(BottomSetting bottomSetting) {
        this.bottomSetting = bottomSetting;
    }

    public final LeftMenu getLeftMenu() {
        return this.leftMenu;
    }

    public final void setLeftMenu(LeftMenu leftMenu) {
        this.leftMenu = leftMenu;
    }

    public final InstantPurchaseLayoutBinding getBinding() {
        InstantPurchaseLayoutBinding instantPurchaseLayoutBinding = this.binding;
        if (instantPurchaseLayoutBinding != null) {
            return instantPurchaseLayoutBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(InstantPurchaseLayoutBinding instantPurchaseLayoutBinding) {
        Intrinsics.checkNotNullParameter(instantPurchaseLayoutBinding, "<set-?>");
        this.binding = instantPurchaseLayoutBinding;
    }

    public final CourseDetail getCourseDetail() {
        return this.courseDetail;
    }

    public final void setCourseDetail(CourseDetail courseDetail) {
        this.courseDetail = courseDetail;
    }

    public final String getCombo_id() {
        return this.combo_id;
    }

    public final void setCombo_id(String str) {
        this.combo_id = str;
    }

    public final String getMainCourseId() {
        return this.mainCourseId;
    }

    public final void setMainCourseId(String str) {
        this.mainCourseId = str;
    }

    /* JADX INFO: renamed from: isBook, reason: from getter */
    public final String getIsBook() {
        return this.isBook;
    }

    public final void setBook(String str) {
        this.isBook = str;
    }

    public final float getDeliveryCharge() {
        return this.deliveryCharge;
    }

    public final void setDeliveryCharge(float f2) {
        this.deliveryCharge = f2;
    }

    public final String getQuantityOfBooks() {
        return this.quantityOfBooks;
    }

    public final void setQuantityOfBooks(String str) {
        this.quantityOfBooks = str;
    }

    public final String getParentCourseId() {
        return this.parentCourseId;
    }

    public final void setParentCourseId(String str) {
        this.parentCourseId = str;
    }

    public final NetworkCall getNetworkCall() {
        return this.networkCall;
    }

    public final void setNetworkCall(NetworkCall networkCall) {
        this.networkCall = networkCall;
    }

    public final String getAppliedCouponCode() {
        return this.appliedCouponCode;
    }

    public final void setAppliedCouponCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appliedCouponCode = str;
    }

    public final String getAppliedCouponCodeId() {
        return this.appliedCouponCodeId;
    }

    public final void setAppliedCouponCodeId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appliedCouponCodeId = str;
    }

    public final String getSelectedCouponId() {
        return this.selectedCouponId;
    }

    public final void setSelectedCouponId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.selectedCouponId = str;
    }

    public final String getSecondCouponCode() {
        return this.secondCouponCode;
    }

    public final void setSecondCouponCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.secondCouponCode = str;
    }

    public final String getPaymentModeValue() {
        return this.paymentModeValue;
    }

    public final void setPaymentModeValue(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.paymentModeValue = str;
    }

    /* JADX INFO: renamed from: isCouponGiven, reason: from getter */
    public final boolean getIsCouponGiven() {
        return this.isCouponGiven;
    }

    public final void setCouponGiven(boolean z) {
        this.isCouponGiven = z;
    }

    /* JADX INFO: renamed from: isSelfCoupon, reason: from getter */
    public final boolean getIsSelfCoupon() {
        return this.isSelfCoupon;
    }

    public final void setSelfCoupon(boolean z) {
        this.isSelfCoupon = z;
    }

    public final ArrayList<CoursesCoupon> getSelfCouponArrayList() {
        return this.selfCouponArrayList;
    }

    public final void setSelfCouponArrayList(ArrayList<CoursesCoupon> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.selfCouponArrayList = arrayList;
    }

    public final ArrayList<CoursesCoupon> getPreCouponArrayList() {
        return this.preCouponArrayList;
    }

    public final void setPreCouponArrayList(ArrayList<CoursesCoupon> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.preCouponArrayList = arrayList;
    }

    public final ArrayList<CoursesCoupon> getCoursesCouponArrayList() {
        return this.coursesCouponArrayList;
    }

    public final void setCoursesCouponArrayList(ArrayList<CoursesCoupon> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.coursesCouponArrayList = arrayList;
    }

    public final CoursesCoupon getCoursesCoupon() {
        return this.coursesCoupon;
    }

    public final void setCoursesCoupon(CoursesCoupon coursesCoupon) {
        Intrinsics.checkNotNullParameter(coursesCoupon, "<set-?>");
        this.coursesCoupon = coursesCoupon;
    }

    public final String getPrice() {
        return this.price;
    }

    public final void setPrice(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.price = str;
    }

    public final String getTax() {
        return this.tax;
    }

    public final void setTax(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tax = str;
    }

    public final float getToPayAmount() {
        return this.toPayAmount;
    }

    public final void setToPayAmount(float f2) {
        this.toPayAmount = f2;
    }

    public final String getCourse_id() {
        return this.course_id;
    }

    public final void setCourse_id(String str) {
        this.course_id = str;
    }

    public final String getCoupon_applied() {
        return this.coupon_applied;
    }

    public final void setCoupon_applied(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.coupon_applied = str;
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

    public final String getPos_txn_id() {
        return this.pos_txn_id;
    }

    public final void setPos_txn_id(String str) {
        this.pos_txn_id = str;
    }

    public final String getPre_txtid() {
        return this.pre_txtid;
    }

    public final void setPre_txtid(String str) {
        this.pre_txtid = str;
    }

    public final String getTxnToken() {
        return this.txnToken;
    }

    public final void setTxnToken(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.txnToken = str;
    }

    public final String getEnc_val() {
        return this.enc_val;
    }

    public final void setEnc_val(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.enc_val = str;
    }

    public final boolean getIsfailure() {
        return this.isfailure;
    }

    public final void setIsfailure(boolean z) {
        this.isfailure = z;
    }

    /* JADX INFO: renamed from: isPayViaQR, reason: from getter */
    public final boolean getIsPayViaQR() {
        return this.isPayViaQR;
    }

    public final void setPayViaQR(boolean z) {
        this.isPayViaQR = z;
    }

    public final int getStopValidationOnCoupon() {
        return this.stopValidationOnCoupon;
    }

    public final void setStopValidationOnCoupon(int i) {
        this.stopValidationOnCoupon = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void purchasesUpdatedListener$lambda$1(final InstantPurchase instantPurchase, BillingResult billingResult, List list) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        if (billingResult.getResponseCode() == 0 && list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ConsumeParams consumeParamsBuild = ConsumeParams.newBuilder().setPurchaseToken(((Purchase) it.next()).getPurchaseToken()).build();
                Intrinsics.checkNotNullExpressionValue(consumeParamsBuild, "build(...)");
                ConsumeResponseListener consumeResponseListener = new ConsumeResponseListener() { // from class: com.appnew.android.Payment.InstantPurchase$$ExternalSyntheticLambda51
                    @Override // com.android.billingclient.api.ConsumeResponseListener
                    public final void onConsumeResponse(BillingResult billingResult2, String str) {
                        InstantPurchase.purchasesUpdatedListener$lambda$1$lambda$0(this.f$0, billingResult2, str);
                    }
                };
                BillingClient billingClient = instantPurchase.billingClient;
                Intrinsics.checkNotNull(billingClient);
                billingClient.consumeAsync(consumeParamsBuild, consumeResponseListener);
            }
            return;
        }
        if (billingResult.getResponseCode() == 1) {
            String debugMessage = billingResult.getDebugMessage();
            Intrinsics.checkNotNullExpressionValue(debugMessage, "getDebugMessage(...)");
            if (debugMessage.length() == 0) {
                return;
            }
            Helper.showToast(instantPurchase.getActivity(), billingResult.getDebugMessage(), 1);
            return;
        }
        String debugMessage2 = billingResult.getDebugMessage();
        Intrinsics.checkNotNullExpressionValue(debugMessage2, "getDebugMessage(...)");
        if (debugMessage2.length() == 0) {
            return;
        }
        Helper.showToast(instantPurchase.getActivity(), billingResult.getDebugMessage(), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void purchasesUpdatedListener$lambda$1$lambda$0(InstantPurchase instantPurchase, BillingResult billingResult, String purchaseToken) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        if (billingResult.getResponseCode() == 0) {
            System.out.println((Object) "SUCCESSFULLY consumed PURCHASE");
            Log.d("kundan", "SUCCESSFULLY consumed PURCHASE");
            NetworkCall networkCall = instantPurchase.networkCall;
            Intrinsics.checkNotNull(networkCall);
            networkCall.NetworkAPICall(API.IN_APP_PURCHASE, "", true, false);
            return;
        }
        Log.d("kundan", "FAILED TO consume:");
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2121 && data != null && data.hasExtra("status")) {
            showMessage("Respo " + data.getStringExtra("status") + " " + data.getStringExtra("msg"));
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        super.onCreate(savedInstanceState);
        setStyle(0, R.style.BottomSheetDialogStyle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.courseDetail = arguments.containsKey(Const.SINGLE_STUDY) ? (CourseDetail) arguments.getSerializable(Const.SINGLE_STUDY) : new CourseDetail();
            this.is_load_form = arguments.containsKey("is_load_form") ? arguments.getBoolean("is_load_form", true) : true;
            String str = "";
            if (!arguments.containsKey("test_mode") || (string = arguments.getString("test_mode", "")) == null) {
                string = "";
            }
            this.test_mode = string;
            if (!arguments.containsKey("test_data") || (string2 = arguments.getString("test_data", "")) == null) {
                string2 = "";
            }
            this.test_data = string2;
            if (!arguments.containsKey("test_id") || (string3 = arguments.getString("test_id", "")) == null) {
                string3 = "";
            }
            this.test_id = string3;
            if (!arguments.containsKey("parentCourseId") || (string4 = arguments.getString("parentCourseId", "")) == null) {
                string4 = "";
            }
            this.parentCourseId = string4;
            String str2 = "0";
            if (arguments.containsKey(Const.IS_BOOK) && (string8 = arguments.getString(Const.IS_BOOK, "0")) != null) {
                str2 = string8;
            }
            this.isBook = str2;
            String str3 = "1";
            if (arguments.containsKey("quantityOfBooks") && (string7 = arguments.getString("quantityOfBooks", "1")) != null) {
                str3 = string7;
            }
            this.quantityOfBooks = str3;
            if (!arguments.containsKey(Const.COMBO_ID) || (string5 = arguments.getString(Const.COMBO_ID, "")) == null) {
                string5 = "";
            }
            this.combo_id = string5;
            if (arguments.containsKey("mainCourseId") && (string6 = arguments.getString("mainCourseId", "")) != null) {
                str = string6;
            }
            this.mainCourseId = str;
        }
        registers();
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(dialogOnCreateDialog, "onCreateDialog(...)");
        dialogOnCreateDialog.setCanceledOnTouchOutside(false);
        dialogOnCreateDialog.setCancelable(false);
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        setBinding(InstantPurchaseLayoutBinding.inflate(inflater, container, false));
        RelativeLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01ce  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onViewCreated(final android.view.View r6, android.os.Bundle r7) {
        /*
            Method dump skipped, instruction units count: 573
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Payment.InstantPurchase.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$5(View view, DialogInterface dialogInterface) {
        Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        if (((BottomSheetDialog) dialogInterface).findViewById(R.id.design_bottom_sheet) != null) {
            Object parent = view.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
            BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from((View) parent);
            Intrinsics.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "from(...)");
            bottomSheetBehaviorFrom.setPeekHeight(view.getHeight());
            bottomSheetBehaviorFrom.setState(3);
            bottomSheetBehaviorFrom.setDraggable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$6(InstantPurchase instantPurchase, View view) {
        if (SystemClock.elapsedRealtime() - instantPurchase.mLastClickTime < 1000) {
            return;
        }
        instantPurchase.mLastClickTime = SystemClock.elapsedRealtime();
        instantPurchase.setPurchaseDataWithCoupon(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$9(InstantPurchase instantPurchase, View view) {
        if (instantPurchase.haveAddress) {
            instantPurchase.getSavedAddressDailog();
        } else {
            instantPurchase.addressDailog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$10(InstantPurchase instantPurchase, View view) {
        if (SystemClock.elapsedRealtime() - instantPurchase.mLastClickTime < 1000) {
            return;
        }
        instantPurchase.mLastClickTime = SystemClock.elapsedRealtime();
        if (!Helper.isConnected(instantPurchase.getActivity())) {
            String string = instantPurchase.getResources().getString(R.string.internet_error_message);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            instantPurchase.showMessage(string);
            return;
        }
        if (StringsKt.equals(MakeMyExam.getUserId(), "0", true)) {
            instantPurchase.showMessage("Invalid user!");
            return;
        }
        LeftMenu leftMenu = instantPurchase.leftMenu;
        Intrinsics.checkNotNull(leftMenu);
        if (StringsKt.equals(leftMenu.getPayment_privacy(), "1", true)) {
            if (!instantPurchase.getBinding().termsCheck.isChecked()) {
                String string2 = instantPurchase.getResources().getString(R.string.please_select_refund_policy);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                instantPurchase.showMessage(string2);
                return;
            }
        } else {
            BottomSetting bottomSetting = instantPurchase.bottomSetting;
            Intrinsics.checkNotNull(bottomSetting);
            if (StringsKt.equals(bottomSetting.getInvoice_tnc(), "1", true) && !instantPurchase.getBinding().termsCheck.isChecked()) {
                String string3 = instantPurchase.getResources().getString(R.string.please_select_terms_and_conditions);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                instantPurchase.showMessage(string3);
                return;
            }
        }
        instantPurchase.isPayViaQR = true;
        instantPurchase.handlePaymnetbuttonClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$11(InstantPurchase instantPurchase, View view) {
        if (SystemClock.elapsedRealtime() - instantPurchase.mLastClickTime < 1000) {
            return;
        }
        instantPurchase.mLastClickTime = SystemClock.elapsedRealtime();
        if (!Helper.isConnected(instantPurchase.getActivity())) {
            String string = instantPurchase.getResources().getString(R.string.internet_error_message);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            instantPurchase.showMessage(string);
            return;
        }
        if (StringsKt.equals(MakeMyExam.getUserId(), "0", true)) {
            instantPurchase.showMessage("Invalid user!");
            return;
        }
        LeftMenu leftMenu = instantPurchase.leftMenu;
        Intrinsics.checkNotNull(leftMenu);
        if (StringsKt.equals(leftMenu.getPayment_privacy(), "1", true)) {
            if (!instantPurchase.getBinding().termsCheck.isChecked()) {
                String string2 = instantPurchase.getResources().getString(R.string.please_select_refund_policy);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                instantPurchase.showMessage(string2);
                return;
            }
        } else {
            BottomSetting bottomSetting = instantPurchase.bottomSetting;
            Intrinsics.checkNotNull(bottomSetting);
            if (StringsKt.equals(bottomSetting.getInvoice_tnc(), "1", true) && !instantPurchase.getBinding().termsCheck.isChecked()) {
                String string3 = instantPurchase.getResources().getString(R.string.please_select_terms_and_conditions);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                instantPurchase.showMessage(string3);
                return;
            }
        }
        instantPurchase.isPayViaQR = false;
        instantPurchase.handlePaymnetbuttonClick();
    }

    public final void handlePaymnetbuttonClick() {
        if (!TextUtils.isEmpty(SharedPreference.getInstance().getString("in_release")) && StringsKt.equals(SharedPreference.getInstance().getString("in_release"), "1", true)) {
            NetworkCall networkCall = this.networkCall;
            Intrinsics.checkNotNull(networkCall);
            networkCall.NetworkAPICall(API.GET_PRODUCT_ID, "", true, false);
            return;
        }
        if (!TextUtils.isEmpty(SharedPreference.getInstance().getString("in_release_user")) && StringsKt.equals(SharedPreference.getInstance().getString("in_release_user"), SharedPreference.getInstance().getLoggedInUser().getId(), true)) {
            NetworkCall networkCall2 = this.networkCall;
            Intrinsics.checkNotNull(networkCall2);
            networkCall2.NetworkAPICall(API.GET_PRODUCT_ID, "", true, false);
            return;
        }
        if (StringsKt.equals(this.isBook, "1", true) || isComboBook()) {
            if (!GenericUtils.isEmpty(this.addressJson) && this.address1 != null) {
                if (StringsKt.equals(getBinding().payOnline.getText().toString(), getResources().getString(R.string.pay_online), true)) {
                    callPaymentMode();
                    return;
                }
                NetworkCall networkCall3 = this.networkCall;
                Intrinsics.checkNotNull(networkCall3);
                networkCall3.NetworkAPICall("https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction", "", true, false);
                return;
            }
            String string = getResources().getString(R.string.please_add_address_first);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            showMessage(string);
            return;
        }
        if (StringsKt.equals(getBinding().payOnline.getText().toString(), getResources().getString(R.string.pay_online), true)) {
            callPaymentMode();
            return;
        }
        NetworkCall networkCall4 = this.networkCall;
        Intrinsics.checkNotNull(networkCall4);
        networkCall4.NetworkAPICall("https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction", "", true, false);
    }

    private final void setRefundRelatedData() {
        getBinding().termCondTV.setText(getResources().getString(R.string.before_making_payment_you_agree_to_our) + "\n" + getResources().getString(R.string.refund_policy));
        SpannableString spannableString = new SpannableString(getBinding().termCondTV.getText().toString());
        spannableString.setSpan(new ClickableSpan() { // from class: com.appnew.android.Payment.InstantPurchase$setRefundRelatedData$clickableSpan$1
            @Override // android.text.style.ClickableSpan
            public void onClick(View textView) {
                Intrinsics.checkNotNullParameter(textView, "textView");
                Intent intent = new Intent(this.this$0.requireActivity(), (Class<?>) WebViewActivty.class);
                intent.putExtra("type", "Refund Policy");
                intent.putExtra("url", API.PRIVACY_POLICY_REFUND_URL);
                Helper.gotoActivity(intent, this.this$0.requireActivity());
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                Intrinsics.checkNotNullParameter(ds, "ds");
                super.updateDrawState(ds);
                ds.setUnderlineText(true);
                ds.setColor(ContextCompat.getColor(this.this$0.requireActivity(), R.color.colorPrimary));
            }
        }, getBinding().termCondTV.getText().toString().length() - 13, getBinding().termCondTV.getText().toString().length(), 33);
        spannableString.setSpan(new UnderlineSpan(), getBinding().termCondTV.getText().toString().length() - 13, getBinding().termCondTV.getText().toString().length(), 0);
        spannableString.setSpan(new StyleSpan(1), getBinding().termCondTV.getText().toString().length() - 13, getBinding().termCondTV.getText().toString().length(), 0);
        getBinding().termCondTV.setText(spannableString);
        getBinding().termCondTV.setMovementMethod(LinkMovementMethod.getInstance());
        getBinding().termCondTV.setHighlightColor(0);
    }

    private final void setTermRelatedData() {
        getBinding().termCondTV.setText(getResources().getString(R.string.before_making_payment_you_agree_to_our) + "\n" + getResources().getString(R.string.terms_amp_conditions));
        SpannableString spannableString = new SpannableString(getBinding().termCondTV.getText().toString());
        spannableString.setSpan(new ClickableSpan() { // from class: com.appnew.android.Payment.InstantPurchase$setTermRelatedData$clickableSpan$1
            @Override // android.text.style.ClickableSpan
            public void onClick(View textView) {
                Intrinsics.checkNotNullParameter(textView, "textView");
                Intent intent = new Intent(this.this$0.requireActivity(), (Class<?>) WebViewActivty.class);
                intent.putExtra("type", "Terms of Service");
                intent.putExtra("url", API.TERMS_AND_CONDITIONS);
                Helper.gotoActivity(intent, this.this$0.requireActivity());
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                Intrinsics.checkNotNullParameter(ds, "ds");
                super.updateDrawState(ds);
                ds.setUnderlineText(true);
                ds.setColor(ContextCompat.getColor(this.this$0.requireActivity(), R.color.colorPrimary));
            }
        }, getBinding().termCondTV.getText().toString().length() - 18, getBinding().termCondTV.getText().toString().length(), 33);
        spannableString.setSpan(new UnderlineSpan(), getBinding().termCondTV.getText().toString().length() - 18, getBinding().termCondTV.getText().toString().length(), 0);
        spannableString.setSpan(new StyleSpan(1), getBinding().termCondTV.getText().toString().length() - 18, getBinding().termCondTV.getText().toString().length(), 0);
        getBinding().termCondTV.setText(spannableString);
        getBinding().termCondTV.setMovementMethod(LinkMovementMethod.getInstance());
        getBinding().termCondTV.setHighlightColor(0);
    }

    public final void setImageViewWidth() {
        int i = (int) (120 * getResources().getDisplayMetrics().density);
        ViewGroup.LayoutParams layoutParams = getBinding().imageView.getLayoutParams();
        layoutParams.width = i;
        getBinding().imageView.setLayoutParams(layoutParams);
    }

    private final void setCourseImage() {
        Data data;
        CourseDetailData courseDetail;
        Data data2;
        CourseDetailData courseDetail2;
        Data data3;
        CourseDetailData courseDetail3;
        Data data4;
        CourseDetailData courseDetail4;
        setImageViewWidth();
        if (StringsKt.equals$default(this.isBook, "1", false, 2, null)) {
            CourseDetail courseDetail5 = this.courseDetail;
            if (!TextUtils.isEmpty((courseDetail5 == null || (data4 = courseDetail5.getData()) == null || (courseDetail4 = data4.getCourseDetail()) == null) ? null : courseDetail4.getCover_image())) {
                FragmentActivity activity = getActivity();
                CourseDetail courseDetail6 = this.courseDetail;
                String cover_image = (courseDetail6 == null || (data3 = courseDetail6.getData()) == null || (courseDetail3 = data3.getCourseDetail()) == null) ? null : courseDetail3.getCover_image();
                Resources resources = getResources();
                FragmentActivity activity2 = getActivity();
                Helper.setThumbnailImage(activity, cover_image, ResourcesCompat.getDrawable(resources, R.mipmap.book_placeholder, activity2 != null ? activity2.getTheme() : null), getBinding().imageView);
                return;
            }
            getBinding().imageView.setImageResource(R.mipmap.book_placeholder);
            return;
        }
        CourseDetail courseDetail7 = this.courseDetail;
        if (!TextUtils.isEmpty((courseDetail7 == null || (data2 = courseDetail7.getData()) == null || (courseDetail2 = data2.getCourseDetail()) == null) ? null : courseDetail2.getDescHeaderImage())) {
            FragmentActivity activity3 = getActivity();
            CourseDetail courseDetail8 = this.courseDetail;
            String descHeaderImage = (courseDetail8 == null || (data = courseDetail8.getData()) == null || (courseDetail = data.getCourseDetail()) == null) ? null : courseDetail.getDescHeaderImage();
            Resources resources2 = getResources();
            FragmentActivity activity4 = getActivity();
            Helper.setThumbnailImage(activity3, descHeaderImage, ResourcesCompat.getDrawable(resources2, R.mipmap.placeholder_course, activity4 != null ? activity4.getTheme() : null), getBinding().imageView);
            return;
        }
        getBinding().imageView.setImageResource(R.mipmap.placeholder_course);
    }

    public final boolean isComboBook() {
        return isComboBookAddress() && !Helper.isAddressShowAfter();
    }

    public final boolean isShowAddress() {
        return isComboBookAddress() && Helper.isAddressShowAfter();
    }

    public final boolean isComboBookAddress() {
        Data data;
        CourseDetailData courseDetail;
        Data data2;
        CourseDetailData courseDetail2;
        Data data3;
        CourseDetail courseDetail3 = this.courseDetail;
        if (courseDetail3 == null) {
            return false;
        }
        Intrinsics.checkNotNull(courseDetail3);
        if (courseDetail3.getData() == null) {
            return false;
        }
        CourseDetail courseDetail4 = this.courseDetail;
        String combo_has_book = null;
        if (((courseDetail4 == null || (data3 = courseDetail4.getData()) == null) ? null : data3.getCourseDetail()) == null) {
            return false;
        }
        CourseDetail courseDetail5 = this.courseDetail;
        if (TextUtils.isEmpty((courseDetail5 == null || (data2 = courseDetail5.getData()) == null || (courseDetail2 = data2.getCourseDetail()) == null) ? null : courseDetail2.getCombo_has_book())) {
            return false;
        }
        CourseDetail courseDetail6 = this.courseDetail;
        if (courseDetail6 != null && (data = courseDetail6.getData()) != null && (courseDetail = data.getCourseDetail()) != null) {
            combo_has_book = courseDetail.getCombo_has_book();
        }
        return StringsKt.equals(combo_has_book, "1", true) && StringsKt.equals(this.isBook, "0", true);
    }

    public final boolean isSinglePrefillAvailable() {
        return !this.coursesCouponArrayList.isEmpty() && this.coursesCouponArrayList.size() == 1 && StringsKt.equals(this.coursesCouponArrayList.get(0).getCoupon().getTarget_type(), "2", true);
    }

    private final void setPurchaseDataWithCoupon(boolean isAfterCouponApply) {
        if (isAfterCouponApply) {
            TextView textView = getBinding().couponCodeApplied;
            String coupon_title = this.coursesCoupon.getCoupon().getCoupon_title();
            Intrinsics.checkNotNullExpressionValue(coupon_title, "getCoupon_title(...)");
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String upperCase = coupon_title.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            textView.setText(upperCase + " Applied");
            TextView textView2 = getBinding().taxValue1;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String discount = this.coursesCoupon.getDiscount();
            Intrinsics.checkNotNullExpressionValue(discount, "getDiscount(...)");
            String str = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(Float.parseFloat(discount))}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            textView2.setText("You are saving ₹" + str);
        }
        priceUpdate(isAfterCouponApply);
        manageCouponUI(isAfterCouponApply);
    }

    private final void priceUpdate(boolean isCouponApplied) {
        float f2;
        Data data;
        CourseDetailData courseDetail;
        Data data2;
        CourseDetailData courseDetail2;
        Data data3;
        CourseDetailData courseDetail3;
        Data data4;
        CourseDetailData courseDetail4;
        CourseDetail courseDetail5 = this.courseDetail;
        String tax = null;
        String mrp = (courseDetail5 == null || (data4 = courseDetail5.getData()) == null || (courseDetail4 = data4.getCourseDetail()) == null) ? null : courseDetail4.getMrp();
        Intrinsics.checkNotNull(mrp);
        float f3 = Float.parseFloat(mrp);
        CourseDetail courseDetail6 = this.courseDetail;
        String tax2 = (courseDetail6 == null || (data3 = courseDetail6.getData()) == null || (courseDetail3 = data3.getCourseDetail()) == null) ? null : courseDetail3.getTax();
        Intrinsics.checkNotNull(tax2);
        float f4 = f3 + Float.parseFloat(tax2);
        if (isCouponApplied) {
            String final_mrp = this.coursesCoupon.getFinal_mrp();
            Intrinsics.checkNotNullExpressionValue(final_mrp, "getFinal_mrp(...)");
            f2 = Float.parseFloat(final_mrp);
        } else {
            f2 = f4;
        }
        CourseDetail courseDetail7 = this.courseDetail;
        String mrp2 = (courseDetail7 == null || (data2 = courseDetail7.getData()) == null || (courseDetail2 = data2.getCourseDetail()) == null) ? null : courseDetail2.getMrp();
        Intrinsics.checkNotNull(mrp2);
        this.price = new StringBuilder().append(Float.parseFloat(mrp2)).toString();
        CourseDetail courseDetail8 = this.courseDetail;
        if (courseDetail8 != null && (data = courseDetail8.getData()) != null && (courseDetail = data.getCourseDetail()) != null) {
            tax = courseDetail.getTax();
        }
        Intrinsics.checkNotNull(tax);
        this.tax = new StringBuilder().append(Float.parseFloat(tax)).toString();
        this.toPayAmount = f2 + this.deliveryCharge;
        setGstAndDeliveryTxt();
        TextView textView = getBinding().totalPriceValue1;
        String str = Constants.currencyType;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str2 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(f4)}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        textView.setText(str + str2);
        if (this.toPayAmount > 0.0f) {
            TextView textView2 = getBinding().txtGrandTotalValue1;
            String str3 = Constants.currencyType;
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String str4 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(this.toPayAmount)}, 1));
            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
            textView2.setText(str3 + str4);
            return;
        }
        TextView textView3 = getBinding().txtGrandTotalValue1;
        String str5 = Constants.currencyType;
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
        String str6 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(0.0f)}, 1));
        Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
        textView3.setText(str5 + str6);
    }

    private final void setGstAndDeliveryTxt() {
        getBinding().gstCoursePrice.setText("(" + Constants.gstIncludedText + ")");
        if (this.deliveryCharge == 0.0f) {
            getBinding().gstFinalPrice.setVisibility(8);
            return;
        }
        getBinding().gstFinalPrice.setVisibility(0);
        getBinding().gstFinalPrice.setText("Include delivery charges (" + Constants.currencyType + this.deliveryCharge + ")");
    }

    public final void manageCouponUI(boolean isCouponApplied) {
        Resources resources;
        Resources resources2;
        if (isSinglePrefillAvailable()) {
            getBinding().couponAppliedCV.setVisibility(0);
            getBinding().viewAllCouponRL.setVisibility(8);
            getBinding().remove.setVisibility(8);
        } else if (!this.coursesCouponArrayList.isEmpty()) {
            if (isCouponApplied) {
                getBinding().couponAppliedCV.setVisibility(0);
                getBinding().haveCouponTV.setVisibility(8);
                getBinding().viewAllCouponRL.setVisibility(8);
                getBinding().remove.setVisibility(0);
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    Render render = new Render(activity);
                    Attention attention = new Attention();
                    CardView couponAppliedCV = getBinding().couponAppliedCV;
                    Intrinsics.checkNotNullExpressionValue(couponAppliedCV, "couponAppliedCV");
                    render.setAnimation(attention.Tada(couponAppliedCV));
                    render.setDuration(2000L);
                    render.start();
                }
            } else {
                getBinding().couponAppliedCV.setVisibility(8);
                getBinding().haveCouponTV.setVisibility(0);
                getBinding().viewAllCouponRL.setVisibility(0);
            }
            checkAvailableCoupons();
        } else {
            getBinding().couponAppliedCV.setVisibility(8);
            getBinding().viewAllCouponRL.setVisibility(8);
        }
        String string = null;
        if (this.toPayAmount > 0.0f) {
            if (Helper.enableQRCode()) {
                getBinding().openQR.setVisibility(0);
            } else {
                getBinding().openQR.setVisibility(8);
            }
            TextView textView = getBinding().payOnline;
            FragmentActivity activity2 = getActivity();
            if (activity2 != null && (resources2 = activity2.getResources()) != null) {
                string = resources2.getString(R.string.pay_online);
            }
            textView.setText(string);
            return;
        }
        getBinding().openQR.setVisibility(8);
        TextView textView2 = getBinding().payOnline;
        FragmentActivity activity3 = getActivity();
        if (activity3 != null && (resources = activity3.getResources()) != null) {
            string = resources.getString(R.string.open_in_my_lib);
        }
        textView2.setText(string);
    }

    public final void checkAvailableCoupons() {
        try {
            if (!getBinding().couponAppliedCV.isShown()) {
                this.selectedCouponId = "";
            }
            if (!this.selfCouponArrayList.isEmpty()) {
                getBinding().editCouponRl.setVisibility(0);
            } else {
                getBinding().editCouponRl.setVisibility(8);
            }
            if (!this.preCouponArrayList.isEmpty()) {
                getBinding().recyclerCoupons.setVisibility(0);
            } else {
                getBinding().recyclerCoupons.setVisibility(8);
            }
            if (getBinding().recyclerCoupons.isShown()) {
                getBinding().view3.setVisibility(0);
            } else {
                getBinding().view3.setVisibility(8);
            }
            if (this.isSelfCoupon) {
                getBinding().couponEdt.setText(this.selectedCouponId);
            }
            if (!this.preCouponArrayList.isEmpty()) {
                Iterator<CoursesCoupon> it = this.preCouponArrayList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    CoursesCoupon next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    CoursesCoupon coursesCoupon = next;
                    coursesCoupon.setIs_select(StringsKt.equals(coursesCoupon.getCoupon().getId(), this.selectedCouponId, true));
                }
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.Payment.InstantPurchase$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        InstantPurchase.checkAvailableCoupons$lambda$13(this.f$0);
                    }
                }, 100L);
            }
            getBinding().applyCoupon.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.InstantPurchase$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InstantPurchase.checkAvailableCoupons$lambda$14(this.f$0, view);
                }
            });
        } catch (Exception e2) {
            Log.d("TAGINSTANTPURCHASE", "Error: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkAvailableCoupons$lambda$13(InstantPurchase instantPurchase) {
        instantPurchase.getBinding().recyclerCoupons.setLayoutManager(new LinearLayoutManager(instantPurchase.getContext(), 1, false));
        instantPurchase.getBinding().recyclerCoupons.setNestedScrollingEnabled(false);
        instantPurchase.getBinding().recyclerCoupons.setAdapter(new CouponPurchaseAdapter(instantPurchase.getContext(), instantPurchase.preCouponArrayList, instantPurchase.getBinding().couponEdt, instantPurchase));
        instantPurchase.getBinding().recyclerCoupons.scheduleLayoutAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkAvailableCoupons$lambda$14(InstantPurchase instantPurchase, View view) {
        if (instantPurchase.getBinding().couponEdt != null && !TextUtils.isEmpty(instantPurchase.getBinding().couponEdt.getText().toString())) {
            instantPurchase.manageCouponApply(instantPurchase.getBinding().couponEdt);
        } else {
            instantPurchase.showMessage("Please enter coupon code");
        }
    }

    public final void manageCouponApply(EditText coupon_edt) {
        String string;
        boolean z;
        String string2;
        if (coupon_edt != null && !TextUtils.isEmpty(coupon_edt.getText().toString())) {
            int size = this.selfCouponArrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z = true;
                    string = "";
                    break;
                } else {
                    if (StringsKt.equals(this.selfCouponArrayList.get(i).getCoupon().getCoupon_title(), coupon_edt.getText().toString(), true)) {
                        string = new StringBuilder().append(i).toString();
                        this.isSelfCoupon = true;
                        z = true;
                        break;
                    }
                    i++;
                }
            }
        } else {
            int size2 = this.preCouponArrayList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size2) {
                    string = "";
                    break;
                } else {
                    if (this.preCouponArrayList.get(i2).isIs_select()) {
                        string = new StringBuilder().append(i2).toString();
                        this.isSelfCoupon = false;
                        break;
                    }
                    i2++;
                }
            }
            z = false;
        }
        if (StringsKt.equals(string, "", true) && this.stopValidationOnCoupon != 1) {
            if (this.isSelfCoupon || z) {
                string2 = "Please enter valid coupon code";
            } else {
                string2 = getResources().getString(R.string.select_any_coupon);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            }
            showMessage(string2);
            return;
        }
        hideKeyboard();
        if (this.stopValidationOnCoupon != 1) {
            if (this.isSelfCoupon) {
                CoursesCoupon coursesCoupon = this.selfCouponArrayList.get(Integer.parseInt(string));
                this.coursesCoupon = coursesCoupon;
                this.selectedCouponId = coursesCoupon.getCoupon().getCoupon_title();
            } else {
                CoursesCoupon coursesCoupon2 = this.preCouponArrayList.get(Integer.parseInt(string));
                this.coursesCoupon = coursesCoupon2;
                this.selectedCouponId = coursesCoupon2.getCoupon().getId();
            }
            this.appliedCouponCode = this.coursesCoupon.getCoupon().getCoupon_title();
            this.appliedCouponCodeId = this.coursesCoupon.getCoupon().getId();
        } else {
            this.appliedCouponCode = String.valueOf(coupon_edt != null ? coupon_edt.getText() : null);
            this.appliedCouponCodeId = String.valueOf(this.stopValidationOnCoupon);
        }
        NetworkCall networkCall = this.networkCall;
        Intrinsics.checkNotNull(networkCall);
        networkCall.NetworkAPICall(API.verifyCoupon, "", true, false);
    }

    @Override // com.appnew.android.Payment.OnCouponClicked
    public void onCouponClicked(EditText couponEdit) {
        manageCouponApply(getBinding().couponEdt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showMessage(final String message) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.appnew.android.Payment.InstantPurchase$$ExternalSyntheticLambda19
                @Override // java.lang.Runnable
                public final void run() {
                    InstantPurchase.showMessage$lambda$15(message, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showMessage$lambda$15(String str, InstantPurchase instantPurchase) {
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Toast.makeText(instantPurchase.getActivity(), str2, 0).show();
    }

    private final int calculateAmount() {
        return Math.round(this.toPayAmount);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void paymentGateways(JSONObject data, String mode) {
        try {
            this.pre_txtid = data.optString(Const.COURSE_INIT_PAYMENT_TOKEN);
            PreferencesUtil preferencesUtil = PreferencesUtil.INSTANCE;
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
            String stringPreference = preferencesUtil.getStringPreference(fragmentActivityRequireActivity, Credentials.RZP);
            PreferencesUtil preferencesUtil2 = PreferencesUtil.INSTANCE;
            FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity2, "requireActivity(...)");
            String stringPreference2 = preferencesUtil2.getStringPreference(fragmentActivityRequireActivity2, Credentials.PAYTM);
            PreferencesUtil preferencesUtil3 = PreferencesUtil.INSTANCE;
            FragmentActivity fragmentActivityRequireActivity3 = requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity3, "requireActivity(...)");
            String stringPreference3 = preferencesUtil3.getStringPreference(fragmentActivityRequireActivity3, Credentials.CCAV);
            PreferencesUtil preferencesUtil4 = PreferencesUtil.INSTANCE;
            FragmentActivity fragmentActivityRequireActivity4 = requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity4, "requireActivity(...)");
            String stringPreference4 = preferencesUtil4.getStringPreference(fragmentActivityRequireActivity4, Credentials.FONEPAY);
            PreferencesUtil preferencesUtil5 = PreferencesUtil.INSTANCE;
            FragmentActivity fragmentActivityRequireActivity5 = requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity5, "requireActivity(...)");
            String stringPreference5 = preferencesUtil5.getStringPreference(fragmentActivityRequireActivity5, Credentials.EASEBUZZ);
            PreferencesUtil preferencesUtil6 = PreferencesUtil.INSTANCE;
            FragmentActivity fragmentActivityRequireActivity6 = requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity6, "requireActivity(...)");
            String stringPreference6 = preferencesUtil6.getStringPreference(fragmentActivityRequireActivity6, Credentials.BILLDESK);
            PreferencesUtil preferencesUtil7 = PreferencesUtil.INSTANCE;
            FragmentActivity fragmentActivityRequireActivity7 = requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity7, "requireActivity(...)");
            String stringPreference7 = preferencesUtil7.getStringPreference(fragmentActivityRequireActivity7, Credentials.EASYPAY);
            switch (mode.hashCode()) {
                case -1246478010:
                    if (mode.equals(Credentials.EASYPAY) && stringPreference7 != null && stringPreference7.length() != 0) {
                        EasyPay easyPay = (EasyPay) new Gson().fromJson(stringPreference7, EasyPay.class);
                        if ((easyPay != null ? easyPay.getStatus() : null) != null && StringsKt.equals(easyPay.getStatus(), "1", true)) {
                            String strOptString = data.optString("txnToken");
                            Intrinsics.checkNotNull(strOptString);
                            launchEasyPayPaymentGateway(strOptString, calculateAmount());
                            break;
                        }
                    }
                    break;
                case -4980799:
                    if (mode.equals(Credentials.EASEBUZZ) && stringPreference5 != null && stringPreference5.length() != 0) {
                        EaseBuzz easeBuzz = (EaseBuzz) new Gson().fromJson(stringPreference5, EaseBuzz.class);
                        if ((easeBuzz != null ? easeBuzz.getStatus() : null) != null && StringsKt.equals(easeBuzz.getStatus(), "1", true)) {
                            String strOptString2 = data.optString("txnToken");
                            Intrinsics.checkNotNull(strOptString2);
                            int iCalculateAmount = calculateAmount();
                            String mode2 = easeBuzz.getMode();
                            Intrinsics.checkNotNull(mode2);
                            launchEaseBuzzPaymentGateway(strOptString2, iCalculateAmount, mode2);
                            break;
                        }
                    }
                    break;
                case 81672:
                    if (mode.equals(Credentials.RZP) && stringPreference != null && stringPreference.length() != 0) {
                        Rzp rzp = (Rzp) new Gson().fromJson(stringPreference, Rzp.class);
                        if ((rzp != null ? rzp.getStatus() : null) != null && StringsKt.equals(rzp.getStatus(), "1", true)) {
                            boolean zIsShown = getBinding().couponAppliedCV.isShown();
                            String str = this.pre_txtid;
                            Intrinsics.checkNotNull(str);
                            long jCalculateAmount = calculateAmount();
                            CoursesCoupon coursesCoupon = this.coursesCoupon;
                            CourseDetail courseDetail = this.courseDetail;
                            String key = rzp.getKey();
                            Intrinsics.checkNotNull(key);
                            launchRazorPayPaymentGateway(data, zIsShown, str, jCalculateAmount, coursesCoupon, courseDetail, key);
                            break;
                        }
                    }
                    break;
                case 2062485:
                    if (mode.equals(Credentials.CCAV) && stringPreference3 != null && stringPreference3.length() != 0) {
                        Ccav ccav = (Ccav) new Gson().fromJson(stringPreference3, Ccav.class);
                        if ((ccav != null ? ccav.getStatus() : null) != null && StringsKt.equals(ccav.getStatus(), "1", true)) {
                            this.enc_val = data.optString("txnToken");
                            String str2 = this.pre_txtid;
                            Intrinsics.checkNotNull(str2);
                            int iCalculateAmount2 = calculateAmount();
                            String str3 = this.enc_val;
                            String secret = ccav.getSecret();
                            Intrinsics.checkNotNull(secret);
                            String redirect_url = ccav.getRedirect_url();
                            Intrinsics.checkNotNull(redirect_url);
                            String cancel_url = ccav.getCancel_url();
                            Intrinsics.checkNotNull(cancel_url);
                            String android_url = ccav.getAndroid_url();
                            Intrinsics.checkNotNull(android_url);
                            launchCcAvenuePaymentGateway(str2, iCalculateAmount2, str3, secret, redirect_url, cancel_url, android_url);
                            break;
                        }
                    }
                    break;
                case 36620360:
                    if (mode.equals(Credentials.FONEPAY) && stringPreference4 != null && stringPreference4.length() != 0) {
                        FonePay fonePay = (FonePay) new Gson().fromJson(stringPreference4, FonePay.class);
                        if ((fonePay != null ? fonePay.getStatus() : null) != null && StringsKt.equals(fonePay.getStatus(), "1", true)) {
                            String strOptString3 = data.optString("txnToken");
                            Intrinsics.checkNotNull(strOptString3);
                            launchFonePayPaymentGateway(strOptString3, calculateAmount());
                            break;
                        }
                    }
                    break;
                case 75906305:
                    if (mode.equals(Credentials.PAYTM) && stringPreference2 != null && stringPreference2.length() != 0) {
                        Paytm paytm2 = (Paytm) new Gson().fromJson(stringPreference2, Paytm.class);
                        if ((paytm2 != null ? paytm2.getStatus() : null) != null && StringsKt.equals(paytm2.getStatus(), "1", true)) {
                            this.txnToken = data.optString("txnToken");
                            String str4 = this.pre_txtid;
                            Intrinsics.checkNotNull(str4);
                            int iCalculateAmount3 = calculateAmount();
                            String str5 = this.txnToken;
                            String secret2 = paytm2.getSecret();
                            Intrinsics.checkNotNull(secret2);
                            String url = paytm2.getUrl();
                            Intrinsics.checkNotNull(url);
                            launchPaytmPaymentGateway(str4, iCalculateAmount3, str5, secret2, url);
                            break;
                        }
                    }
                    break;
                case 1672722208:
                    if (mode.equals(Credentials.BILLDESK) && stringPreference6 != null && stringPreference6.length() != 0) {
                        BillDesk billDesk = (BillDesk) new Gson().fromJson(stringPreference6, BillDesk.class);
                        if ((billDesk != null ? billDesk.getStatus() : null) != null && StringsKt.equals(billDesk.getStatus(), "1", true)) {
                            String strOptString4 = data.optString("txnToken");
                            Intrinsics.checkNotNull(strOptString4);
                            launchBillDeskPaymentGateway(strOptString4, calculateAmount());
                            break;
                        }
                    }
                    break;
            }
        } catch (Exception e2) {
            Log.d("TAGINSTANTPURCHASE", "Error: " + e2.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:190:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00fb A[Catch: Exception -> 0x03ff, TryCatch #0 {Exception -> 0x03ff, blocks: (B:3:0x0015, B:6:0x008c, B:9:0x0097, B:11:0x00aa, B:14:0x00b3, B:16:0x00be, B:20:0x00e2, B:23:0x00ec, B:25:0x00fb, B:28:0x0104, B:30:0x010f, B:32:0x012a, B:35:0x0134, B:37:0x0143, B:40:0x014c, B:42:0x0156, B:44:0x0171, B:47:0x017b, B:49:0x018a, B:52:0x0193, B:54:0x019d, B:56:0x01b8, B:59:0x01c2, B:61:0x01d1, B:64:0x01da, B:66:0x01e4, B:68:0x01ff, B:71:0x020a, B:73:0x021b, B:76:0x0224, B:78:0x022e, B:82:0x0256, B:85:0x0261, B:87:0x0272, B:89:0x0278, B:91:0x0282, B:94:0x02a4, B:96:0x02b0, B:98:0x02be, B:100:0x02c5, B:102:0x02d9, B:103:0x02dd, B:105:0x02e2, B:109:0x02ec), top: B:201:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0143 A[Catch: Exception -> 0x03ff, TryCatch #0 {Exception -> 0x03ff, blocks: (B:3:0x0015, B:6:0x008c, B:9:0x0097, B:11:0x00aa, B:14:0x00b3, B:16:0x00be, B:20:0x00e2, B:23:0x00ec, B:25:0x00fb, B:28:0x0104, B:30:0x010f, B:32:0x012a, B:35:0x0134, B:37:0x0143, B:40:0x014c, B:42:0x0156, B:44:0x0171, B:47:0x017b, B:49:0x018a, B:52:0x0193, B:54:0x019d, B:56:0x01b8, B:59:0x01c2, B:61:0x01d1, B:64:0x01da, B:66:0x01e4, B:68:0x01ff, B:71:0x020a, B:73:0x021b, B:76:0x0224, B:78:0x022e, B:82:0x0256, B:85:0x0261, B:87:0x0272, B:89:0x0278, B:91:0x0282, B:94:0x02a4, B:96:0x02b0, B:98:0x02be, B:100:0x02c5, B:102:0x02d9, B:103:0x02dd, B:105:0x02e2, B:109:0x02ec), top: B:201:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x018a A[Catch: Exception -> 0x03ff, TryCatch #0 {Exception -> 0x03ff, blocks: (B:3:0x0015, B:6:0x008c, B:9:0x0097, B:11:0x00aa, B:14:0x00b3, B:16:0x00be, B:20:0x00e2, B:23:0x00ec, B:25:0x00fb, B:28:0x0104, B:30:0x010f, B:32:0x012a, B:35:0x0134, B:37:0x0143, B:40:0x014c, B:42:0x0156, B:44:0x0171, B:47:0x017b, B:49:0x018a, B:52:0x0193, B:54:0x019d, B:56:0x01b8, B:59:0x01c2, B:61:0x01d1, B:64:0x01da, B:66:0x01e4, B:68:0x01ff, B:71:0x020a, B:73:0x021b, B:76:0x0224, B:78:0x022e, B:82:0x0256, B:85:0x0261, B:87:0x0272, B:89:0x0278, B:91:0x0282, B:94:0x02a4, B:96:0x02b0, B:98:0x02be, B:100:0x02c5, B:102:0x02d9, B:103:0x02dd, B:105:0x02e2, B:109:0x02ec), top: B:201:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01d1 A[Catch: Exception -> 0x03ff, TryCatch #0 {Exception -> 0x03ff, blocks: (B:3:0x0015, B:6:0x008c, B:9:0x0097, B:11:0x00aa, B:14:0x00b3, B:16:0x00be, B:20:0x00e2, B:23:0x00ec, B:25:0x00fb, B:28:0x0104, B:30:0x010f, B:32:0x012a, B:35:0x0134, B:37:0x0143, B:40:0x014c, B:42:0x0156, B:44:0x0171, B:47:0x017b, B:49:0x018a, B:52:0x0193, B:54:0x019d, B:56:0x01b8, B:59:0x01c2, B:61:0x01d1, B:64:0x01da, B:66:0x01e4, B:68:0x01ff, B:71:0x020a, B:73:0x021b, B:76:0x0224, B:78:0x022e, B:82:0x0256, B:85:0x0261, B:87:0x0272, B:89:0x0278, B:91:0x0282, B:94:0x02a4, B:96:0x02b0, B:98:0x02be, B:100:0x02c5, B:102:0x02d9, B:103:0x02dd, B:105:0x02e2, B:109:0x02ec), top: B:201:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0250 A[PHI: r20
      0x0250: PHI (r20v3 java.lang.String) = (r20v2 java.lang.String), (r20v5 java.lang.String), (r20v2 java.lang.String) binds: [B:67:0x01fd, B:79:0x024e, B:70:0x0209] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0256 A[Catch: Exception -> 0x03ff, TryCatch #0 {Exception -> 0x03ff, blocks: (B:3:0x0015, B:6:0x008c, B:9:0x0097, B:11:0x00aa, B:14:0x00b3, B:16:0x00be, B:20:0x00e2, B:23:0x00ec, B:25:0x00fb, B:28:0x0104, B:30:0x010f, B:32:0x012a, B:35:0x0134, B:37:0x0143, B:40:0x014c, B:42:0x0156, B:44:0x0171, B:47:0x017b, B:49:0x018a, B:52:0x0193, B:54:0x019d, B:56:0x01b8, B:59:0x01c2, B:61:0x01d1, B:64:0x01da, B:66:0x01e4, B:68:0x01ff, B:71:0x020a, B:73:0x021b, B:76:0x0224, B:78:0x022e, B:82:0x0256, B:85:0x0261, B:87:0x0272, B:89:0x0278, B:91:0x0282, B:94:0x02a4, B:96:0x02b0, B:98:0x02be, B:100:0x02c5, B:102:0x02d9, B:103:0x02dd, B:105:0x02e2, B:109:0x02ec), top: B:201:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02a2 A[PHI: r19
      0x02a2: PHI (r19v3 java.lang.String) = (r19v2 java.lang.String), (r19v5 java.lang.String), (r19v2 java.lang.String) binds: [B:81:0x0254, B:92:0x02a0, B:84:0x0260] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02b0 A[Catch: Exception -> 0x03ff, TryCatch #0 {Exception -> 0x03ff, blocks: (B:3:0x0015, B:6:0x008c, B:9:0x0097, B:11:0x00aa, B:14:0x00b3, B:16:0x00be, B:20:0x00e2, B:23:0x00ec, B:25:0x00fb, B:28:0x0104, B:30:0x010f, B:32:0x012a, B:35:0x0134, B:37:0x0143, B:40:0x014c, B:42:0x0156, B:44:0x0171, B:47:0x017b, B:49:0x018a, B:52:0x0193, B:54:0x019d, B:56:0x01b8, B:59:0x01c2, B:61:0x01d1, B:64:0x01da, B:66:0x01e4, B:68:0x01ff, B:71:0x020a, B:73:0x021b, B:76:0x0224, B:78:0x022e, B:82:0x0256, B:85:0x0261, B:87:0x0272, B:89:0x0278, B:91:0x0282, B:94:0x02a4, B:96:0x02b0, B:98:0x02be, B:100:0x02c5, B:102:0x02d9, B:103:0x02dd, B:105:0x02e2, B:109:0x02ec), top: B:201:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02be A[Catch: Exception -> 0x03ff, TryCatch #0 {Exception -> 0x03ff, blocks: (B:3:0x0015, B:6:0x008c, B:9:0x0097, B:11:0x00aa, B:14:0x00b3, B:16:0x00be, B:20:0x00e2, B:23:0x00ec, B:25:0x00fb, B:28:0x0104, B:30:0x010f, B:32:0x012a, B:35:0x0134, B:37:0x0143, B:40:0x014c, B:42:0x0156, B:44:0x0171, B:47:0x017b, B:49:0x018a, B:52:0x0193, B:54:0x019d, B:56:0x01b8, B:59:0x01c2, B:61:0x01d1, B:64:0x01da, B:66:0x01e4, B:68:0x01ff, B:71:0x020a, B:73:0x021b, B:76:0x0224, B:78:0x022e, B:82:0x0256, B:85:0x0261, B:87:0x0272, B:89:0x0278, B:91:0x0282, B:94:0x02a4, B:96:0x02b0, B:98:0x02be, B:100:0x02c5, B:102:0x02d9, B:103:0x02dd, B:105:0x02e2, B:109:0x02ec), top: B:201:0x0015 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void callPaymentMode() {
        /*
            Method dump skipped, instruction units count: 1082
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Payment.InstantPurchase.callPaymentMode():void");
    }

    private final void handlePaymentError() {
        try {
            this.isfailure = true;
            NetworkCall networkCall = this.networkCall;
            Intrinsics.checkNotNull(networkCall);
            networkCall.NetworkAPICall(API.int_payment, "", true, false);
        } catch (Exception e2) {
            Log.d("TAGINSTANTPURCHASE", "Error: " + e2.getMessage());
        }
    }

    private final String callApiIntPayment() {
        Data data;
        CourseDetailData courseDetail;
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setType("1");
        encryptionData.setParent_id(SingleStudy.parentCourseId);
        encryptionData.setTest_id(this.test_id);
        if (getBinding().couponAppliedCV.isShown()) {
            encryptionData.setCourse_id(this.coursesCoupon.getId());
            encryptionData.setCoupon_applied(this.appliedCouponCodeId);
            encryptionData.setExternal_coupon(this.secondCouponCode);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String mrp = this.coursesCoupon.getMrp();
            Intrinsics.checkNotNullExpressionValue(mrp, "getMrp(...)");
            String str = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(Float.parseFloat(mrp))}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            encryptionData.setCourse_price(str);
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String tax = this.coursesCoupon.getTax();
            Intrinsics.checkNotNullExpressionValue(tax, "getTax(...)");
            String str2 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(Float.parseFloat(tax))}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            encryptionData.setTax(str2);
        } else {
            CourseDetail courseDetail2 = this.courseDetail;
            encryptionData.setCourse_id((courseDetail2 == null || (data = courseDetail2.getData()) == null || (courseDetail = data.getCourseDetail()) == null) ? null : courseDetail.getId());
            encryptionData.setCoupon_applied(this.coupon_applied);
            encryptionData.setCourse_price(this.price);
            encryptionData.setTax(this.tax);
        }
        encryptionData.setPay_via(this.payVia);
        encryptionData.setQuantity(this.quantityOfBooks);
        String str3 = this.addressJson;
        if (str3 != null) {
            encryptionData.setAddress(str3);
        } else {
            encryptionData.setAddress("");
        }
        encryptionData.setDelivery_charge(String.valueOf(this.deliveryCharge));
        String strEncrypt = AES.encrypt(new Gson().toJson(encryptionData));
        Intrinsics.checkNotNullExpressionValue(strEncrypt, "encrypt(...)");
        return strEncrypt;
    }

    private final String callApiIntPaymentOnFailure() {
        Data data;
        CourseDetailData courseDetail;
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setType("2");
        encryptionData.setParent_id(SingleStudy.parentCourseId);
        encryptionData.setPre_transaction_id(this.pre_txtid);
        encryptionData.setTransaction_status("2");
        encryptionData.setPost_transaction_id("");
        encryptionData.setQuantity(this.quantityOfBooks);
        encryptionData.setTest_id(this.test_id);
        if (getBinding().couponAppliedCV.isShown()) {
            encryptionData.setCourse_id(this.coursesCoupon.getId());
            encryptionData.setCoupon_applied(this.coursesCoupon.getCoupon().getId());
        } else {
            CourseDetail courseDetail2 = this.courseDetail;
            encryptionData.setCourse_id((courseDetail2 == null || (data = courseDetail2.getData()) == null || (courseDetail = data.getCourseDetail()) == null) ? null : courseDetail.getId());
            encryptionData.setCoupon_applied(this.coupon_applied);
        }
        String str = this.addressJson;
        if (str != null) {
            encryptionData.setAddress(str);
        } else {
            encryptionData.setAddress("");
        }
        String strEncrypt = AES.encrypt(new Gson().toJson(encryptionData));
        Intrinsics.checkNotNullExpressionValue(strEncrypt, "encrypt(...)");
        return strEncrypt;
    }

    private final String callApiIntPaymentOnSuccess() {
        Data data;
        CourseDetailData courseDetail;
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setType("2");
        encryptionData.setTest_id(this.test_id);
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
        if (getBinding().couponAppliedCV.isShown()) {
            encryptionData.setCourse_id(this.coursesCoupon.getId());
        } else {
            CourseDetail courseDetail2 = this.courseDetail;
            encryptionData.setCourse_id((courseDetail2 == null || (data = courseDetail2.getData()) == null || (courseDetail = data.getCourseDetail()) == null) ? null : courseDetail.getId());
        }
        String str = this.addressJson;
        if (str != null) {
            encryptionData.setAddress(str);
        } else {
            encryptionData.setAddress("");
        }
        String strEncrypt = AES.encrypt(new Gson().toJson(encryptionData));
        Intrinsics.checkNotNullExpressionValue(strEncrypt, "encrypt(...)");
        return strEncrypt;
    }

    private final void success_dailog() {
        int i;
        Data data;
        CourseDetailData courseDetail;
        Data data2;
        CourseDetailData courseDetail2;
        Window window;
        Window window2;
        Window window3;
        Window window4;
        Window window5;
        try {
            if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
                return;
            }
            this.mLastClickTime = SystemClock.elapsedRealtime();
            FragmentActivity activity = getActivity();
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                Context context = getContext();
                final Dialog dialog = context != null ? new Dialog(context) : null;
                if (dialog != null) {
                    dialog.requestWindowFeature(1);
                }
                if (dialog != null) {
                    dialog.setContentView(R.layout.success_dialog);
                }
                if (dialog != null && (window5 = dialog.getWindow()) != null) {
                    window5.setSoftInputMode(16);
                }
                FragmentActivity activity2 = getActivity();
                if (activity2 != null && (window4 = activity2.getWindow()) != null) {
                    window4.setSoftInputMode(3);
                }
                if (dialog != null && (window3 = dialog.getWindow()) != null) {
                    window3.setBackgroundDrawable(new ColorDrawable(0));
                }
                int i2 = (int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.9d);
                if (dialog != null && (window2 = dialog.getWindow()) != null) {
                    window2.setLayout(i2, -2);
                }
                if (dialog != null && (window = dialog.getWindow()) != null) {
                    window.setGravity(17);
                }
                if (dialog != null) {
                    dialog.setCancelable(false);
                }
                if (dialog != null) {
                    dialog.setCanceledOnTouchOutside(false);
                }
                TextInputLayout textInputLayout = dialog != null ? (TextInputLayout) dialog.findViewById(R.id.cvrBookName) : null;
                TextInputLayout textInputLayout2 = dialog != null ? (TextInputLayout) dialog.findViewById(R.id.cvrCourseName) : null;
                EditText editText = dialog != null ? (EditText) dialog.findViewById(R.id.et_order_id) : null;
                EditText editText2 = dialog != null ? (EditText) dialog.findViewById(R.id.et_transaction_id) : null;
                TextView textView = dialog != null ? (TextView) dialog.findViewById(R.id.course_name) : null;
                TextView textView2 = dialog != null ? (TextView) dialog.findViewById(R.id.book_name) : null;
                LinearLayout linearLayout = dialog != null ? (LinearLayout) dialog.findViewById(R.id.transactionLL) : null;
                LinearLayout linearLayout2 = dialog != null ? (LinearLayout) dialog.findViewById(R.id.admitCardLL) : null;
                if (editText != null) {
                    editText.setText(this.pre_txtid);
                }
                if (editText2 != null) {
                    editText2.setText(this.pos_txn_id);
                }
                if (textView != null) {
                    CourseDetail courseDetail3 = this.courseDetail;
                    textView.setText((courseDetail3 == null || (data2 = courseDetail3.getData()) == null || (courseDetail2 = data2.getCourseDetail()) == null) ? null : courseDetail2.getTitle());
                }
                if (textView2 != null) {
                    CourseDetail courseDetail4 = this.courseDetail;
                    textView2.setText((courseDetail4 == null || (data = courseDetail4.getData()) == null || (courseDetail = data.getCourseDetail()) == null) ? null : courseDetail.getTitle());
                }
                Button button = dialog != null ? (Button) dialog.findViewById(R.id.btn_my_course) : null;
                final String str = this.test_mode;
                if (Intrinsics.areEqual(this.isBook, "1")) {
                    if (button != null) {
                        button.setText(getResources().getString(R.string.go_to_home_page));
                    }
                    if (textInputLayout2 != null) {
                        textInputLayout2.setVisibility(8);
                    }
                    if (textInputLayout != null) {
                        textInputLayout.setVisibility(0);
                    }
                } else if (StringsKt.equals(this.isBook, "3", true)) {
                    if (textInputLayout2 != null) {
                        textInputLayout2.setVisibility(0);
                    }
                    if (textInputLayout != null) {
                        i = 8;
                        textInputLayout.setVisibility(8);
                    } else {
                        i = 8;
                    }
                    if (linearLayout != null) {
                        linearLayout.setVisibility(i);
                    }
                    if (linearLayout2 != null) {
                        linearLayout2.setVisibility(0);
                    }
                    if (StringsKt.equals(str, "1", true)) {
                        if (button != null) {
                            button.setText(getResources().getString(R.string.go_to_purchase_list));
                        }
                    } else if (button != null) {
                        button.setText(getResources().getString(R.string.go_to_home_page));
                    }
                } else {
                    if (button != null) {
                        button.setText(getResources().getString(R.string.go_to_course));
                    }
                    if (textInputLayout2 != null) {
                        textInputLayout2.setVisibility(0);
                    }
                    if (textInputLayout != null) {
                        textInputLayout.setVisibility(8);
                    }
                }
                try {
                    if (CourseActivity.getInstance() != null) {
                        CourseActivity.getInstance().finish();
                    }
                } catch (Exception e2) {
                    Log.d("TAGINSTANTPURCHASE", "Error: " + e2.getMessage());
                }
                if (button != null) {
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.InstantPurchase$$ExternalSyntheticLambda2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            InstantPurchase.success_dailog$lambda$17(this.f$0, str, dialog, view);
                        }
                    });
                }
                if (!activity.isFinishing() && !activity.isDestroyed() && dialog != null) {
                    dialog.show();
                }
                if (dialog != null) {
                    dialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.appnew.android.Payment.InstantPurchase$$ExternalSyntheticLambda3
                        @Override // android.content.DialogInterface.OnCancelListener
                        public final void onCancel(DialogInterface dialogInterface) {
                            InstantPurchase.success_dailog$lambda$18(dialog, dialogInterface);
                        }
                    });
                }
            }
        } catch (Exception e3) {
            Log.d("TAGINSTANTPURCHASE", "Error: " + e3.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:49:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void success_dailog$lambda$17(com.appnew.android.Payment.InstantPurchase r5, java.lang.String r6, android.app.Dialog r7, android.view.View r8) {
        /*
            Method dump skipped, instruction units count: 418
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Payment.InstantPurchase.success_dailog$lambda$17(com.appnew.android.Payment.InstantPurchase, java.lang.String, android.app.Dialog, android.view.View):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void success_dailog$lambda$18(Dialog dialog, DialogInterface dialogInterface) {
        dialog.dismiss();
        dialog.cancel();
    }

    private final void callServiceForInvoice() {
        NetworkCall networkCall = this.networkCall;
        Intrinsics.checkNotNull(networkCall);
        networkCall.NetworkAPICall(API.GET_ADMIT_CARD_URL, "", true, false);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.appnew.android.Utils.PaymentTypeCheck
    public void onPaymentType(String mode, JSONObject data) {
        PreferencesUtil preferencesUtil = PreferencesUtil.INSTANCE;
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        String stringPreference = preferencesUtil.getStringPreference(fragmentActivityRequireActivity, Credentials.RZP);
        PreferencesUtil preferencesUtil2 = PreferencesUtil.INSTANCE;
        FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity2, "requireActivity(...)");
        String stringPreference2 = preferencesUtil2.getStringPreference(fragmentActivityRequireActivity2, Credentials.PAYTM);
        PreferencesUtil preferencesUtil3 = PreferencesUtil.INSTANCE;
        FragmentActivity fragmentActivityRequireActivity3 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity3, "requireActivity(...)");
        String stringPreference3 = preferencesUtil3.getStringPreference(fragmentActivityRequireActivity3, Credentials.CCAV);
        PreferencesUtil preferencesUtil4 = PreferencesUtil.INSTANCE;
        FragmentActivity fragmentActivityRequireActivity4 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity4, "requireActivity(...)");
        String stringPreference4 = preferencesUtil4.getStringPreference(fragmentActivityRequireActivity4, Credentials.FONEPAY);
        PreferencesUtil preferencesUtil5 = PreferencesUtil.INSTANCE;
        FragmentActivity fragmentActivityRequireActivity5 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity5, "requireActivity(...)");
        String stringPreference5 = preferencesUtil5.getStringPreference(fragmentActivityRequireActivity5, Credentials.EASEBUZZ);
        PreferencesUtil preferencesUtil6 = PreferencesUtil.INSTANCE;
        FragmentActivity fragmentActivityRequireActivity6 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity6, "requireActivity(...)");
        String stringPreference6 = preferencesUtil6.getStringPreference(fragmentActivityRequireActivity6, Credentials.BILLDESK);
        PreferencesUtil preferencesUtil7 = PreferencesUtil.INSTANCE;
        FragmentActivity fragmentActivityRequireActivity7 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity7, "requireActivity(...)");
        String stringPreference7 = preferencesUtil7.getStringPreference(fragmentActivityRequireActivity7, Credentials.EASYPAY);
        if (mode != null) {
            switch (mode.hashCode()) {
                case -1246478010:
                    if (mode.equals(Credentials.EASYPAY) && stringPreference7 != null && stringPreference7.length() != 0) {
                        this.payVia = this.isPayViaQR ? "18" : "13";
                    }
                    break;
                case -4980799:
                    if (mode.equals(Credentials.EASEBUZZ) && stringPreference5 != null && stringPreference5.length() != 0) {
                        this.payVia = this.isPayViaQR ? "15" : "9";
                    }
                    break;
                case 81672:
                    if (mode.equals(Credentials.RZP) && stringPreference != null && stringPreference.length() != 0) {
                        this.payVia = this.isPayViaQR ? "14" : "3";
                    }
                    break;
                case 2062485:
                    if (mode.equals(Credentials.CCAV) && stringPreference3 != null && stringPreference3.length() != 0) {
                        this.payVia = this.isPayViaQR ? "22" : "7";
                    }
                    break;
                case 36620360:
                    if (mode.equals(Credentials.FONEPAY) && stringPreference4 != null && stringPreference4.length() != 0) {
                        this.payVia = this.isPayViaQR ? "23" : "8";
                    }
                    break;
                case 75906305:
                    if (mode.equals(Credentials.PAYTM) && stringPreference2 != null && stringPreference2.length() != 0) {
                        this.payVia = this.isPayViaQR ? "21" : "6";
                    }
                    break;
                case 1672722208:
                    if (mode.equals(Credentials.BILLDESK) && stringPreference6 != null && stringPreference6.length() != 0) {
                        this.payVia = this.isPayViaQR ? "24" : "11";
                    }
                    break;
            }
        }
        NetworkCall networkCall = this.networkCall;
        Intrinsics.checkNotNull(networkCall);
        networkCall.NetworkAPICall(API.int_payment, "", true, false);
    }

    public final boolean getHaveAddress() {
        return this.haveAddress;
    }

    public final void setHaveAddress(boolean z) {
        this.haveAddress = z;
    }

    /* JADX INFO: renamed from: isDefault, reason: from getter */
    public final boolean getIsDefault() {
        return this.isDefault;
    }

    public final void setDefault(boolean z) {
        this.isDefault = z;
    }

    public final String getStateindex() {
        return this.stateindex;
    }

    public final void setStateindex(String str) {
        this.stateindex = str;
    }

    public final String getCityindex() {
        return this.cityindex;
    }

    public final void setCityindex(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cityindex = str;
    }

    public final String getSelectedStateid() {
        return this.SelectedStateid;
    }

    public final void setSelectedStateid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.SelectedStateid = str;
    }

    public final String getSelectedCityid() {
        return this.SelectedCityid;
    }

    public final void setSelectedCityid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.SelectedCityid = str;
    }

    /* JADX INFO: renamed from: isFirstTime, reason: from getter */
    public final boolean getIsFirstTime() {
        return this.isFirstTime;
    }

    public final void setFirstTime(boolean z) {
        this.isFirstTime = z;
    }

    public final String getClicktype() {
        return this.clicktype;
    }

    public final void setClicktype(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.clicktype = str;
    }

    public final TextView getStatesTV() {
        return this.statesTV;
    }

    public final void setStatesTV(TextView textView) {
        this.statesTV = textView;
    }

    public final TextView getDistrictTV() {
        return this.districtTV;
    }

    public final void setDistrictTV(TextView textView) {
        this.districtTV = textView;
    }

    public final RecyclerView getRecyclerViewSavedAddress() {
        return this.recyclerViewSavedAddress;
    }

    public final void setRecyclerViewSavedAddress(RecyclerView recyclerView) {
        this.recyclerViewSavedAddress = recyclerView;
    }

    public final Dialog getDialogGettingSavedAddress() {
        return this.dialogGettingSavedAddress;
    }

    public final void setDialogGettingSavedAddress(Dialog dialog) {
        this.dialogGettingSavedAddress = dialog;
    }

    public final Address getAddress1() {
        return this.address1;
    }

    public final void setAddress1(Address address) {
        this.address1 = address;
    }

    public final String getAddressJson() {
        return this.addressJson;
    }

    public final void setAddressJson(String str) {
        this.addressJson = str;
    }

    public final AddressAdapter getAddressAdapter() {
        return this.addressAdapter;
    }

    public final void setAddressAdapter(AddressAdapter addressAdapter) {
        this.addressAdapter = addressAdapter;
    }

    public final String getAddressId() {
        return this.addressId;
    }

    public final void setAddressId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.addressId = str;
    }

    public final int getAddressPosition() {
        return this.addressPosition;
    }

    public final void setAddressPosition(int i) {
        this.addressPosition = i;
    }

    public final Address getAddress() {
        return this.address;
    }

    public final void setAddress(Address address) {
        this.address = address;
    }

    /* JADX INFO: renamed from: isAddressEdited, reason: from getter */
    public final boolean getIsAddressEdited() {
        return this.isAddressEdited;
    }

    public final void setAddressEdited(boolean z) {
        this.isAddressEdited = z;
    }

    /* JADX INFO: renamed from: isWantToUpdate, reason: from getter */
    public final boolean getIsWantToUpdate() {
        return this.isWantToUpdate;
    }

    public final void setWantToUpdate(boolean z) {
        this.isWantToUpdate = z;
    }

    public final AddressMaster getAddressMaster() {
        return this.addressMaster;
    }

    public final void setAddressMaster(AddressMaster addressMaster) {
        this.addressMaster = addressMaster;
    }

    public final StatesCities getStates() {
        return this.states;
    }

    public final void setStates(StatesCities statesCities) {
        this.states = statesCities;
    }

    public final StatesCities getCities() {
        return this.cities;
    }

    public final void setCities(StatesCities statesCities) {
        this.cities = statesCities;
    }

    public final RecyclerView getSearchRecyclerview() {
        return this.searchRecyclerview;
    }

    public final void setSearchRecyclerview(RecyclerView recyclerView) {
        this.searchRecyclerview = recyclerView;
    }

    public final StateCityAdapter getStateCityAdapter() {
        return this.stateCityAdapter;
    }

    public final void setStateCityAdapter(StateCityAdapter stateCityAdapter) {
        this.stateCityAdapter = stateCityAdapter;
    }

    public final EditText getEtSearch() {
        return this.etSearch;
    }

    public final void setEtSearch(EditText editText) {
        this.etSearch = editText;
    }

    public final ImageView getIvClearSearch() {
        return this.ivClearSearch;
    }

    public final void setIvClearSearch(ImageView imageView) {
        this.ivClearSearch = imageView;
    }

    public final ArrayList<StatesCitiesData> getStatesCitiesArrayList() {
        return this.statesCitiesArrayList;
    }

    public final void setStatesCitiesArrayList(ArrayList<StatesCitiesData> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.statesCitiesArrayList = arrayList;
    }

    public final ArrayList<AddressMaster> getAddressListMaster() {
        return this.addressListMaster;
    }

    public final void setAddressListMaster(ArrayList<AddressMaster> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.addressListMaster = arrayList;
    }

    public final void getAddressDetail(AddressMaster addressMaster) {
        Intrinsics.checkNotNullParameter(addressMaster, "addressMaster");
        this.addressMaster = addressMaster;
        this.address1 = (Address) new Gson().fromJson(addressMaster.getAddress(), Address.class);
        this.addressJson = addressMaster.getAddress();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.appnew.android.Payment.InstantPurchase$$ExternalSyntheticLambda20
                @Override // java.lang.Runnable
                public final void run() {
                    InstantPurchase.getAddressDetail$lambda$19(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAddressDetail$lambda$19(InstantPurchase instantPurchase) {
        instantPurchase.getBinding().addedAddressLL.setVisibility(0);
        instantPurchase.getBinding().addressCV.setVisibility(0);
        instantPurchase.getBinding().addAddressBtn.setVisibility(0);
        instantPurchase.getBinding().addAddressBtn.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(instantPurchase.requireActivity(), R.drawable.outline_edit_address), (Drawable) null, (Drawable) null, (Drawable) null);
        instantPurchase.getBinding().addAddressBtn.setText("CHANGE ADDRESS");
        TextView textView = instantPurchase.getBinding().addedAddressTV;
        Address address = instantPurchase.address1;
        String address2 = address != null ? address.getAddress() : null;
        Address address3 = instantPurchase.address1;
        String city = address3 != null ? address3.getCity() : null;
        Address address4 = instantPurchase.address1;
        String state = address4 != null ? address4.getState() : null;
        Address address5 = instantPurchase.address1;
        textView.setText(address2 + ",\n" + city + "\n" + state + ",\n" + (address5 != null ? address5.getPincode() : null));
        TextView textView2 = instantPurchase.getBinding().nameAddressTv;
        Address address6 = instantPurchase.address1;
        textView2.setText(address6 != null ? address6.getName() : null);
        TextView textView3 = instantPurchase.getBinding().mobileNumber;
        Address address7 = instantPurchase.address1;
        textView3.setText(address7 != null ? address7.getMainMobileNumber() : null);
        Address address8 = instantPurchase.address1;
        if ((address8 != null ? address8.getAlternateMobileNumber() : null) != null) {
            Address address9 = instantPurchase.address1;
            if (!TextUtils.isEmpty(address9 != null ? address9.getAlternateMobileNumber() : null)) {
                instantPurchase.getBinding().mobileNumberAlternate.setVisibility(0);
                TextView textView4 = instantPurchase.getBinding().mobileNumberAlternate;
                Address address10 = instantPurchase.address1;
                textView4.setText(address10 != null ? address10.getAlternateMobileNumber() : null);
                return;
            }
        }
        instantPurchase.getBinding().mobileNumberAlternate.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004a A[Catch: Exception -> 0x0223, TryCatch #1 {Exception -> 0x0223, blocks: (B:3:0x0008, B:6:0x0017, B:8:0x0028, B:10:0x002c, B:12:0x003b, B:13:0x004a, B:14:0x004f, B:16:0x0055, B:20:0x0063, B:22:0x0068, B:24:0x006d, B:26:0x0075, B:29:0x0082, B:32:0x0090, B:36:0x009e, B:38:0x00a3, B:40:0x00aa, B:42:0x00b3, B:44:0x00bd, B:46:0x00c6, B:48:0x00d6, B:51:0x00e3, B:54:0x00f0, B:57:0x00fd, B:60:0x010a, B:62:0x0115, B:64:0x0119, B:66:0x0124, B:68:0x0128, B:71:0x0135, B:74:0x0142, B:77:0x014f, B:80:0x0160, B:81:0x0168, B:83:0x016c, B:85:0x0172, B:91:0x0188, B:93:0x0191, B:98:0x019e, B:100:0x01a3, B:102:0x01b6, B:103:0x01c7, B:105:0x01cb, B:106:0x01d3, B:108:0x01d7, B:110:0x01e1, B:111:0x01ee, B:116:0x0209, B:113:0x0202), top: B:124:0x0008, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void addressDailog(final android.app.Dialog r19) {
        /*
            Method dump skipped, instruction units count: 569
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Payment.InstantPurchase.addressDailog(android.app.Dialog):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addressDailog$lambda$21(Dialog dialog, View view) {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addressDailog$lambda$23(InstantPurchase instantPurchase, View view) {
        List<StatesCitiesData> data;
        StatesCities statesCities = instantPurchase.states;
        if (statesCities == null || (statesCities != null && (data = statesCities.getData()) != null && data.size() == 0)) {
            String string = instantPurchase.getResources().getString(R.string.no_state_available);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            instantPurchase.showMessage(string);
        } else {
            instantPurchase.clicktype = "1";
            StatesCities statesCities2 = instantPurchase.states;
            Intrinsics.checkNotNull(statesCities2);
            instantPurchase.filterList("1", statesCities2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addressDailog$lambda$24(InstantPurchase instantPurchase, View view) {
        List<StatesCitiesData> data;
        StatesCities statesCities = instantPurchase.cities;
        if (statesCities == null || (statesCities != null && (data = statesCities.getData()) != null && data.size() == 0)) {
            String string = instantPurchase.getResources().getString(R.string.please_select_state_first);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            instantPurchase.showMessage(string);
        } else {
            instantPurchase.clicktype = "2";
            StatesCities statesCities2 = instantPurchase.cities;
            Intrinsics.checkNotNull(statesCities2);
            instantPurchase.filterList("2", statesCities2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence addressDailog$lambda$25(EditText editText, CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (!Intrinsics.areEqual(charSequence, "")) {
            if (!new Regex("[0-9]+").matches(charSequence.toString())) {
                return "";
            }
            if (String.valueOf(editText != null ? editText.getText() : null).length() > 5) {
                return "";
            }
        }
        return charSequence;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addressDailog$lambda$46(EditText editText, InstantPurchase instantPurchase, EditText editText2, EditText editText3, EditText editText4, EditText editText5, EditText editText6, EditText editText7, CheckBox checkBox, Dialog dialog, Dialog dialog2, View view) {
        Editable text;
        if (editText != null) {
            try {
                text = editText.getText();
            } catch (Exception e2) {
                Log.d("TAGINSTANTPURCHASE", "Error: " + e2.getMessage());
                return;
            }
        } else {
            text = null;
        }
        String strValueOf = String.valueOf(text);
        boolean z = true;
        int length = strValueOf.length() - 1;
        int i = 0;
        boolean z2 = false;
        while (i <= length) {
            boolean z3 = Intrinsics.compare((int) strValueOf.charAt(!z2 ? i : length), 32) <= 0;
            if (z2) {
                if (!z3) {
                    break;
                } else {
                    length--;
                }
            } else if (z3) {
                i++;
            } else {
                z2 = true;
            }
        }
        if (TextUtils.isEmpty(strValueOf.subSequence(i, length + 1).toString())) {
            String string = instantPurchase.getResources().getString(R.string.name_field_is_required);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            instantPurchase.showMessage(string);
            Unit unit = Unit.INSTANCE;
            return;
        }
        String strValueOf2 = String.valueOf(editText2 != null ? editText2.getText() : null);
        int length2 = strValueOf2.length() - 1;
        int i2 = 0;
        boolean z4 = false;
        while (i2 <= length2) {
            boolean z5 = Intrinsics.compare((int) strValueOf2.charAt(!z4 ? i2 : length2), 32) <= 0;
            if (z4) {
                if (!z5) {
                    break;
                } else {
                    length2--;
                }
            } else if (z5) {
                i2++;
            } else {
                z4 = true;
            }
        }
        if (TextUtils.isEmpty(strValueOf2.subSequence(i2, length2 + 1).toString())) {
            String string2 = instantPurchase.getResources().getString(R.string.mobile_field_is_required);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            instantPurchase.showMessage(string2);
            Unit unit2 = Unit.INSTANCE;
            return;
        }
        String strValueOf3 = String.valueOf(editText2 != null ? editText2.getText() : null);
        int length3 = strValueOf3.length() - 1;
        int i3 = 0;
        boolean z6 = false;
        while (i3 <= length3) {
            boolean z7 = Intrinsics.compare((int) strValueOf3.charAt(!z6 ? i3 : length3), 32) <= 0;
            if (z6) {
                if (!z7) {
                    break;
                } else {
                    length3--;
                }
            } else if (z7) {
                i3++;
            } else {
                z6 = true;
            }
        }
        if (Helper.isInValidIndianMobile(strValueOf3.subSequence(i3, length3 + 1).toString())) {
            String string3 = instantPurchase.getResources().getString(R.string.this_number_is_invalid);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            instantPurchase.showMessage(string3);
            Unit unit3 = Unit.INSTANCE;
            return;
        }
        String strValueOf4 = String.valueOf(editText3 != null ? editText3.getText() : null);
        int length4 = strValueOf4.length() - 1;
        int i4 = 0;
        boolean z8 = false;
        while (i4 <= length4) {
            boolean z9 = Intrinsics.compare((int) strValueOf4.charAt(!z8 ? i4 : length4), 32) <= 0;
            if (z8) {
                if (!z9) {
                    break;
                } else {
                    length4--;
                }
            } else if (z9) {
                i4++;
            } else {
                z8 = true;
            }
        }
        if (TextUtils.isEmpty(strValueOf4.subSequence(i4, length4 + 1).toString())) {
            String string4 = instantPurchase.getResources().getString(R.string.address_field_is_required);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            instantPurchase.showMessage(string4);
            Unit unit4 = Unit.INSTANCE;
            return;
        }
        String strValueOf5 = String.valueOf(editText3 != null ? editText3.getText() : null);
        int length5 = strValueOf5.length() - 1;
        int i5 = 0;
        boolean z10 = false;
        while (i5 <= length5) {
            boolean z11 = Intrinsics.compare((int) strValueOf5.charAt(!z10 ? i5 : length5), 32) <= 0;
            if (z10) {
                if (!z11) {
                    break;
                } else {
                    length5--;
                }
            } else if (z11) {
                i5++;
            } else {
                z10 = true;
            }
        }
        if (strValueOf5.subSequence(i5, length5 + 1).toString().length() <= 5) {
            String string5 = instantPurchase.getResources().getString(R.string.enter_valid_address);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            instantPurchase.showMessage(string5);
            Unit unit5 = Unit.INSTANCE;
            return;
        }
        TextView textView = instantPurchase.statesTV;
        String strValueOf6 = String.valueOf(textView != null ? textView.getText() : null);
        int length6 = strValueOf6.length() - 1;
        int i6 = 0;
        boolean z12 = false;
        while (i6 <= length6) {
            boolean z13 = Intrinsics.compare((int) strValueOf6.charAt(!z12 ? i6 : length6), 32) <= 0;
            if (z12) {
                if (!z13) {
                    break;
                } else {
                    length6--;
                }
            } else if (z13) {
                i6++;
            } else {
                z12 = true;
            }
        }
        if (TextUtils.isEmpty(strValueOf6.subSequence(i6, length6 + 1).toString())) {
            String string6 = instantPurchase.getResources().getString(R.string.state_field_is_required);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            instantPurchase.showMessage(string6);
            Unit unit6 = Unit.INSTANCE;
            return;
        }
        TextView textView2 = instantPurchase.districtTV;
        String strValueOf7 = String.valueOf(textView2 != null ? textView2.getText() : null);
        int length7 = strValueOf7.length() - 1;
        int i7 = 0;
        boolean z14 = false;
        while (i7 <= length7) {
            boolean z15 = Intrinsics.compare((int) strValueOf7.charAt(!z14 ? i7 : length7), 32) <= 0;
            if (z14) {
                if (!z15) {
                    break;
                } else {
                    length7--;
                }
            } else if (z15) {
                i7++;
            } else {
                z14 = true;
            }
        }
        if (TextUtils.isEmpty(strValueOf7.subSequence(i7, length7 + 1).toString())) {
            String string7 = instantPurchase.getResources().getString(R.string.district_field_is_required);
            Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
            instantPurchase.showMessage(string7);
            Unit unit7 = Unit.INSTANCE;
            return;
        }
        String strValueOf8 = String.valueOf(editText4 != null ? editText4.getText() : null);
        int length8 = strValueOf8.length() - 1;
        int i8 = 0;
        boolean z16 = false;
        while (i8 <= length8) {
            boolean z17 = Intrinsics.compare((int) strValueOf8.charAt(!z16 ? i8 : length8), 32) <= 0;
            if (z16) {
                if (!z17) {
                    break;
                } else {
                    length8--;
                }
            } else if (z17) {
                i8++;
            } else {
                z16 = true;
            }
        }
        if (TextUtils.isEmpty(strValueOf8.subSequence(i8, length8 + 1).toString())) {
            String string8 = instantPurchase.getResources().getString(R.string.city_field_is_required);
            Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
            instantPurchase.showMessage(string8);
            Unit unit8 = Unit.INSTANCE;
            return;
        }
        String strValueOf9 = String.valueOf(editText5 != null ? editText5.getText() : null);
        int length9 = strValueOf9.length() - 1;
        int i9 = 0;
        boolean z18 = false;
        while (i9 <= length9) {
            boolean z19 = Intrinsics.compare((int) strValueOf9.charAt(!z18 ? i9 : length9), 32) <= 0;
            if (z18) {
                if (!z19) {
                    break;
                } else {
                    length9--;
                }
            } else if (z19) {
                i9++;
            } else {
                z18 = true;
            }
        }
        if (!TextUtils.isEmpty(strValueOf9.subSequence(i9, length9 + 1).toString())) {
            if (String.valueOf(editText5 != null ? editText5.getText() : null).length() >= 6) {
                if (!StringsKt.startsWith$default(String.valueOf(editText5 != null ? editText5.getText() : null), "0", false, 2, (Object) null)) {
                    if (String.valueOf(editText2 != null ? editText2.getText() : null).length() == 0) {
                        String string9 = instantPurchase.getResources().getString(R.string.mobile_field_is_required);
                        Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
                        instantPurchase.showMessage(string9);
                        Unit unit9 = Unit.INSTANCE;
                        return;
                    }
                    if (!instantPurchase.numberValidation(editText2)) {
                        String string10 = instantPurchase.getResources().getString(R.string.mobile_number_should_be_at_least_10_digits);
                        Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
                        instantPurchase.showMessage(string10);
                        Unit unit10 = Unit.INSTANCE;
                        return;
                    }
                    if (String.valueOf(editText6 != null ? editText6.getText() : null).length() == 0) {
                        String string11 = instantPurchase.getResources().getString(R.string.mobile_field_is_required);
                        Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
                        instantPurchase.showMessage(string11);
                        Unit unit11 = Unit.INSTANCE;
                        return;
                    }
                    if (!instantPurchase.numberValidation(editText6)) {
                        String string12 = instantPurchase.getResources().getString(R.string.mobile_number_should_be_at_least_10_digits);
                        Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
                        instantPurchase.showMessage(string12);
                        Unit unit12 = Unit.INSTANCE;
                        return;
                    }
                    String strValueOf10 = String.valueOf(editText6 != null ? editText6.getText() : null);
                    int length10 = strValueOf10.length() - 1;
                    int i10 = 0;
                    boolean z20 = false;
                    while (i10 <= length10) {
                        boolean z21 = Intrinsics.compare((int) strValueOf10.charAt(!z20 ? i10 : length10), 32) <= 0;
                        if (z20) {
                            if (!z21) {
                                break;
                            } else {
                                length10--;
                            }
                        } else if (z21) {
                            i10++;
                        } else {
                            z20 = true;
                        }
                    }
                    String string13 = strValueOf10.subSequence(i10, length10 + 1).toString();
                    String strValueOf11 = String.valueOf(editText2 != null ? editText2.getText() : null);
                    int length11 = strValueOf11.length() - 1;
                    int i11 = 0;
                    boolean z22 = false;
                    while (i11 <= length11) {
                        boolean z23 = Intrinsics.compare((int) strValueOf11.charAt(!z22 ? i11 : length11), 32) <= 0;
                        if (z22) {
                            if (!z23) {
                                break;
                            } else {
                                length11--;
                            }
                        } else if (z23) {
                            i11++;
                        } else {
                            z22 = true;
                        }
                    }
                    if (Helper.NotBeSameAlternateMobileNumber(string13, strValueOf11.subSequence(i11, length11 + 1).toString())) {
                        String string14 = instantPurchase.getResources().getString(R.string.change_alternate_number);
                        Intrinsics.checkNotNullExpressionValue(string14, "getString(...)");
                        instantPurchase.showMessage(string14);
                        Unit unit13 = Unit.INSTANCE;
                        return;
                    }
                    String strValueOf12 = String.valueOf(editText != null ? editText.getText() : null);
                    int length12 = strValueOf12.length() - 1;
                    int i12 = 0;
                    boolean z24 = false;
                    while (i12 <= length12) {
                        boolean z25 = Intrinsics.compare((int) strValueOf12.charAt(!z24 ? i12 : length12), 32) <= 0;
                        if (z24) {
                            if (!z25) {
                                break;
                            } else {
                                length12--;
                            }
                        } else if (z25) {
                            i12++;
                        } else {
                            z24 = true;
                        }
                    }
                    String string15 = strValueOf12.subSequence(i12, length12 + 1).toString();
                    String strValueOf13 = String.valueOf(editText3 != null ? editText3.getText() : null);
                    int length13 = strValueOf13.length() - 1;
                    int i13 = 0;
                    boolean z26 = false;
                    while (i13 <= length13) {
                        boolean z27 = Intrinsics.compare((int) strValueOf13.charAt(!z26 ? i13 : length13), 32) <= 0;
                        if (z26) {
                            if (!z27) {
                                break;
                            } else {
                                length13--;
                            }
                        } else if (z27) {
                            i13++;
                        } else {
                            z26 = true;
                        }
                    }
                    String string16 = strValueOf13.subSequence(i13, length13 + 1).toString();
                    String strValueOf14 = String.valueOf(editText2 != null ? editText2.getText() : null);
                    int length14 = strValueOf14.length() - 1;
                    int i14 = 0;
                    boolean z28 = false;
                    while (i14 <= length14) {
                        boolean z29 = Intrinsics.compare((int) strValueOf14.charAt(!z28 ? i14 : length14), 32) <= 0;
                        if (z28) {
                            if (!z29) {
                                break;
                            } else {
                                length14--;
                            }
                        } else if (z29) {
                            i14++;
                        } else {
                            z28 = true;
                        }
                    }
                    String string17 = strValueOf14.subSequence(i14, length14 + 1).toString();
                    String strValueOf15 = String.valueOf(editText6 != null ? editText6.getText() : null);
                    int length15 = strValueOf15.length() - 1;
                    int i15 = 0;
                    boolean z30 = false;
                    while (i15 <= length15) {
                        boolean z31 = Intrinsics.compare((int) strValueOf15.charAt(!z30 ? i15 : length15), 32) <= 0;
                        if (z30) {
                            if (!z31) {
                                break;
                            } else {
                                length15--;
                            }
                        } else if (z31) {
                            i15++;
                        } else {
                            z30 = true;
                        }
                    }
                    String string18 = strValueOf15.subSequence(i15, length15 + 1).toString();
                    TextView textView3 = instantPurchase.statesTV;
                    String strValueOf16 = String.valueOf(textView3 != null ? textView3.getText() : null);
                    int length16 = strValueOf16.length() - 1;
                    int i16 = 0;
                    boolean z32 = false;
                    while (i16 <= length16) {
                        boolean z33 = Intrinsics.compare((int) strValueOf16.charAt(!z32 ? i16 : length16), 32) <= 0;
                        if (z32) {
                            if (!z33) {
                                break;
                            } else {
                                length16--;
                            }
                        } else if (z33) {
                            i16++;
                        } else {
                            z32 = true;
                        }
                    }
                    String string19 = strValueOf16.subSequence(i16, length16 + 1).toString();
                    TextView textView4 = instantPurchase.districtTV;
                    String strValueOf17 = String.valueOf(textView4 != null ? textView4.getText() : null);
                    int length17 = strValueOf17.length() - 1;
                    int i17 = 0;
                    boolean z34 = false;
                    while (i17 <= length17) {
                        boolean z35 = Intrinsics.compare((int) strValueOf17.charAt(!z34 ? i17 : length17), 32) <= 0;
                        if (z34) {
                            if (!z35) {
                                break;
                            } else {
                                length17--;
                            }
                        } else if (z35) {
                            i17++;
                        } else {
                            z34 = true;
                        }
                    }
                    String string20 = strValueOf17.subSequence(i17, length17 + 1).toString();
                    String strValueOf18 = String.valueOf(editText4 != null ? editText4.getText() : null);
                    int length18 = strValueOf18.length() - 1;
                    int i18 = 0;
                    boolean z36 = false;
                    while (i18 <= length18) {
                        boolean z37 = Intrinsics.compare((int) strValueOf18.charAt(!z36 ? i18 : length18), 32) <= 0;
                        if (z36) {
                            if (!z37) {
                                break;
                            } else {
                                length18--;
                            }
                        } else if (z37) {
                            i18++;
                        } else {
                            z36 = true;
                        }
                    }
                    String string21 = strValueOf18.subSequence(i18, length18 + 1).toString();
                    String strValueOf19 = String.valueOf(editText5 != null ? editText5.getText() : null);
                    int length19 = strValueOf19.length() - 1;
                    int i19 = 0;
                    boolean z38 = false;
                    while (i19 <= length19) {
                        boolean z39 = Intrinsics.compare((int) strValueOf19.charAt(!z38 ? i19 : length19), 32) <= 0;
                        if (z38) {
                            if (!z39) {
                                break;
                            } else {
                                length19--;
                            }
                        } else if (z39) {
                            i19++;
                        } else {
                            z38 = true;
                        }
                    }
                    String string22 = strValueOf19.subSequence(i19, length19 + 1).toString();
                    String strValueOf20 = String.valueOf(editText7 != null ? editText7.getText() : null);
                    int length20 = strValueOf20.length() - 1;
                    int i20 = 0;
                    boolean z40 = false;
                    while (i20 <= length20) {
                        boolean z41 = Intrinsics.compare((int) strValueOf20.charAt(!z40 ? i20 : length20), 32) <= 0;
                        if (z40) {
                            if (!z41) {
                                break;
                            } else {
                                length20--;
                            }
                        } else if (z41) {
                            i20++;
                        } else {
                            z40 = true;
                        }
                    }
                    String string23 = strValueOf20.subSequence(i20, length20 + 1).toString();
                    if (checkBox == null || !checkBox.isChecked()) {
                        z = false;
                    }
                    instantPurchase.isDefault = z;
                    instantPurchase.address1 = new Address(string15, string16, string19, string21, string17, string18, string22, string23, string20, instantPurchase.SelectedStateid);
                    instantPurchase.addressJson = new Gson().toJson(instantPurchase.address1);
                    instantPurchase.isAddressEdited = false;
                    instantPurchase.isWantToUpdate = instantPurchase.isDefault;
                    instantPurchase.hitApiForSavingAddress();
                    dialog.dismiss();
                    if (dialog2 != null) {
                        dialog2.dismiss();
                        Unit unit14 = Unit.INSTANCE;
                        return;
                    }
                    return;
                }
            }
        }
        String string24 = instantPurchase.getResources().getString(R.string.enter_valid_pin_code);
        Intrinsics.checkNotNullExpressionValue(string24, "getString(...)");
        instantPurchase.showMessage(string24);
        Unit unit15 = Unit.INSTANCE;
    }

    public final boolean numberValidation(EditText mobileNumberEditText) {
        String strValueOf = String.valueOf(mobileNumberEditText != null ? mobileNumberEditText.getText() : null);
        int length = strValueOf.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) strValueOf.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String string = strValueOf.subSequence(i, length + 1).toString();
        String str = string;
        if (TextUtils.isDigitsOnly(str)) {
            if (TextUtils.isEmpty(str)) {
                Intrinsics.checkNotNull(mobileNumberEditText);
                return Helper.DataNotValid(mobileNumberEditText, getActivity());
            }
            if (!Patterns.PHONE.matcher(str).matches() || string.length() != 10) {
                Intrinsics.checkNotNull(mobileNumberEditText);
                return Helper.DataNotValid(mobileNumberEditText, 2, getActivity());
            }
            if (Helper.isInValidIndianMobile(string)) {
                Intrinsics.checkNotNull(mobileNumberEditText);
                return Helper.DataNotValid(mobileNumberEditText, 2, getActivity());
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x020c A[Catch: Exception -> 0x01ac, TryCatch #0 {Exception -> 0x01ac, blocks: (B:93:0x0181, B:95:0x0187, B:100:0x0194, B:106:0x01a3, B:110:0x01b0, B:111:0x01c1, B:113:0x01c5, B:116:0x01cb, B:119:0x01d3, B:121:0x01d7, B:123:0x01dd, B:126:0x01e7, B:128:0x01eb, B:130:0x01f1, B:134:0x020c, B:136:0x0210, B:138:0x0216, B:139:0x021b, B:141:0x021f, B:143:0x0223, B:145:0x0229, B:146:0x022e, B:148:0x0232, B:150:0x0238, B:152:0x023c, B:154:0x0240, B:156:0x0246, B:157:0x024b, B:159:0x024f, B:161:0x0253, B:163:0x0259, B:165:0x0260, B:167:0x0264, B:169:0x026a, B:171:0x0271, B:173:0x0275, B:175:0x027b, B:176:0x0280, B:178:0x0284, B:181:0x028c, B:183:0x0290, B:185:0x0296, B:188:0x02a0, B:190:0x02a4, B:192:0x02aa, B:196:0x02c5, B:198:0x02c9, B:200:0x02cf, B:202:0x02d6, B:204:0x02da, B:206:0x02e0, B:194:0x02b2, B:132:0x01f9, B:207:0x02ea, B:209:0x02ee, B:210:0x02f6, B:212:0x02fa, B:214:0x0304, B:215:0x0311, B:220:0x032a, B:217:0x0323), top: B:231:0x0181, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x021f A[Catch: Exception -> 0x01ac, TryCatch #0 {Exception -> 0x01ac, blocks: (B:93:0x0181, B:95:0x0187, B:100:0x0194, B:106:0x01a3, B:110:0x01b0, B:111:0x01c1, B:113:0x01c5, B:116:0x01cb, B:119:0x01d3, B:121:0x01d7, B:123:0x01dd, B:126:0x01e7, B:128:0x01eb, B:130:0x01f1, B:134:0x020c, B:136:0x0210, B:138:0x0216, B:139:0x021b, B:141:0x021f, B:143:0x0223, B:145:0x0229, B:146:0x022e, B:148:0x0232, B:150:0x0238, B:152:0x023c, B:154:0x0240, B:156:0x0246, B:157:0x024b, B:159:0x024f, B:161:0x0253, B:163:0x0259, B:165:0x0260, B:167:0x0264, B:169:0x026a, B:171:0x0271, B:173:0x0275, B:175:0x027b, B:176:0x0280, B:178:0x0284, B:181:0x028c, B:183:0x0290, B:185:0x0296, B:188:0x02a0, B:190:0x02a4, B:192:0x02aa, B:196:0x02c5, B:198:0x02c9, B:200:0x02cf, B:202:0x02d6, B:204:0x02da, B:206:0x02e0, B:194:0x02b2, B:132:0x01f9, B:207:0x02ea, B:209:0x02ee, B:210:0x02f6, B:212:0x02fa, B:214:0x0304, B:215:0x0311, B:220:0x032a, B:217:0x0323), top: B:231:0x0181, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0232 A[Catch: Exception -> 0x01ac, TryCatch #0 {Exception -> 0x01ac, blocks: (B:93:0x0181, B:95:0x0187, B:100:0x0194, B:106:0x01a3, B:110:0x01b0, B:111:0x01c1, B:113:0x01c5, B:116:0x01cb, B:119:0x01d3, B:121:0x01d7, B:123:0x01dd, B:126:0x01e7, B:128:0x01eb, B:130:0x01f1, B:134:0x020c, B:136:0x0210, B:138:0x0216, B:139:0x021b, B:141:0x021f, B:143:0x0223, B:145:0x0229, B:146:0x022e, B:148:0x0232, B:150:0x0238, B:152:0x023c, B:154:0x0240, B:156:0x0246, B:157:0x024b, B:159:0x024f, B:161:0x0253, B:163:0x0259, B:165:0x0260, B:167:0x0264, B:169:0x026a, B:171:0x0271, B:173:0x0275, B:175:0x027b, B:176:0x0280, B:178:0x0284, B:181:0x028c, B:183:0x0290, B:185:0x0296, B:188:0x02a0, B:190:0x02a4, B:192:0x02aa, B:196:0x02c5, B:198:0x02c9, B:200:0x02cf, B:202:0x02d6, B:204:0x02da, B:206:0x02e0, B:194:0x02b2, B:132:0x01f9, B:207:0x02ea, B:209:0x02ee, B:210:0x02f6, B:212:0x02fa, B:214:0x0304, B:215:0x0311, B:220:0x032a, B:217:0x0323), top: B:231:0x0181, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c A[Catch: Exception -> 0x0348, TryCatch #3 {Exception -> 0x0348, blocks: (B:3:0x0008, B:6:0x0017, B:8:0x0028, B:11:0x002e, B:13:0x003d, B:14:0x004c, B:15:0x0051, B:17:0x0057, B:21:0x0065, B:23:0x006a, B:25:0x006f, B:27:0x0077, B:30:0x0084, B:33:0x0092, B:37:0x00a0, B:39:0x00a5, B:41:0x00ac, B:43:0x00b5, B:45:0x00bf, B:47:0x00c8, B:49:0x00d8, B:52:0x00e5, B:55:0x00f2, B:58:0x00ff, B:61:0x010c, B:63:0x0117, B:65:0x011b, B:67:0x0126, B:69:0x012a, B:72:0x0137, B:75:0x0144, B:78:0x0151, B:80:0x0160, B:84:0x016a), top: B:236:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x023c A[Catch: Exception -> 0x01ac, TryCatch #0 {Exception -> 0x01ac, blocks: (B:93:0x0181, B:95:0x0187, B:100:0x0194, B:106:0x01a3, B:110:0x01b0, B:111:0x01c1, B:113:0x01c5, B:116:0x01cb, B:119:0x01d3, B:121:0x01d7, B:123:0x01dd, B:126:0x01e7, B:128:0x01eb, B:130:0x01f1, B:134:0x020c, B:136:0x0210, B:138:0x0216, B:139:0x021b, B:141:0x021f, B:143:0x0223, B:145:0x0229, B:146:0x022e, B:148:0x0232, B:150:0x0238, B:152:0x023c, B:154:0x0240, B:156:0x0246, B:157:0x024b, B:159:0x024f, B:161:0x0253, B:163:0x0259, B:165:0x0260, B:167:0x0264, B:169:0x026a, B:171:0x0271, B:173:0x0275, B:175:0x027b, B:176:0x0280, B:178:0x0284, B:181:0x028c, B:183:0x0290, B:185:0x0296, B:188:0x02a0, B:190:0x02a4, B:192:0x02aa, B:196:0x02c5, B:198:0x02c9, B:200:0x02cf, B:202:0x02d6, B:204:0x02da, B:206:0x02e0, B:194:0x02b2, B:132:0x01f9, B:207:0x02ea, B:209:0x02ee, B:210:0x02f6, B:212:0x02fa, B:214:0x0304, B:215:0x0311, B:220:0x032a, B:217:0x0323), top: B:231:0x0181, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x024f A[Catch: Exception -> 0x01ac, TryCatch #0 {Exception -> 0x01ac, blocks: (B:93:0x0181, B:95:0x0187, B:100:0x0194, B:106:0x01a3, B:110:0x01b0, B:111:0x01c1, B:113:0x01c5, B:116:0x01cb, B:119:0x01d3, B:121:0x01d7, B:123:0x01dd, B:126:0x01e7, B:128:0x01eb, B:130:0x01f1, B:134:0x020c, B:136:0x0210, B:138:0x0216, B:139:0x021b, B:141:0x021f, B:143:0x0223, B:145:0x0229, B:146:0x022e, B:148:0x0232, B:150:0x0238, B:152:0x023c, B:154:0x0240, B:156:0x0246, B:157:0x024b, B:159:0x024f, B:161:0x0253, B:163:0x0259, B:165:0x0260, B:167:0x0264, B:169:0x026a, B:171:0x0271, B:173:0x0275, B:175:0x027b, B:176:0x0280, B:178:0x0284, B:181:0x028c, B:183:0x0290, B:185:0x0296, B:188:0x02a0, B:190:0x02a4, B:192:0x02aa, B:196:0x02c5, B:198:0x02c9, B:200:0x02cf, B:202:0x02d6, B:204:0x02da, B:206:0x02e0, B:194:0x02b2, B:132:0x01f9, B:207:0x02ea, B:209:0x02ee, B:210:0x02f6, B:212:0x02fa, B:214:0x0304, B:215:0x0311, B:220:0x032a, B:217:0x0323), top: B:231:0x0181, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0260 A[Catch: Exception -> 0x01ac, TryCatch #0 {Exception -> 0x01ac, blocks: (B:93:0x0181, B:95:0x0187, B:100:0x0194, B:106:0x01a3, B:110:0x01b0, B:111:0x01c1, B:113:0x01c5, B:116:0x01cb, B:119:0x01d3, B:121:0x01d7, B:123:0x01dd, B:126:0x01e7, B:128:0x01eb, B:130:0x01f1, B:134:0x020c, B:136:0x0210, B:138:0x0216, B:139:0x021b, B:141:0x021f, B:143:0x0223, B:145:0x0229, B:146:0x022e, B:148:0x0232, B:150:0x0238, B:152:0x023c, B:154:0x0240, B:156:0x0246, B:157:0x024b, B:159:0x024f, B:161:0x0253, B:163:0x0259, B:165:0x0260, B:167:0x0264, B:169:0x026a, B:171:0x0271, B:173:0x0275, B:175:0x027b, B:176:0x0280, B:178:0x0284, B:181:0x028c, B:183:0x0290, B:185:0x0296, B:188:0x02a0, B:190:0x02a4, B:192:0x02aa, B:196:0x02c5, B:198:0x02c9, B:200:0x02cf, B:202:0x02d6, B:204:0x02da, B:206:0x02e0, B:194:0x02b2, B:132:0x01f9, B:207:0x02ea, B:209:0x02ee, B:210:0x02f6, B:212:0x02fa, B:214:0x0304, B:215:0x0311, B:220:0x032a, B:217:0x0323), top: B:231:0x0181, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0271 A[Catch: Exception -> 0x01ac, TryCatch #0 {Exception -> 0x01ac, blocks: (B:93:0x0181, B:95:0x0187, B:100:0x0194, B:106:0x01a3, B:110:0x01b0, B:111:0x01c1, B:113:0x01c5, B:116:0x01cb, B:119:0x01d3, B:121:0x01d7, B:123:0x01dd, B:126:0x01e7, B:128:0x01eb, B:130:0x01f1, B:134:0x020c, B:136:0x0210, B:138:0x0216, B:139:0x021b, B:141:0x021f, B:143:0x0223, B:145:0x0229, B:146:0x022e, B:148:0x0232, B:150:0x0238, B:152:0x023c, B:154:0x0240, B:156:0x0246, B:157:0x024b, B:159:0x024f, B:161:0x0253, B:163:0x0259, B:165:0x0260, B:167:0x0264, B:169:0x026a, B:171:0x0271, B:173:0x0275, B:175:0x027b, B:176:0x0280, B:178:0x0284, B:181:0x028c, B:183:0x0290, B:185:0x0296, B:188:0x02a0, B:190:0x02a4, B:192:0x02aa, B:196:0x02c5, B:198:0x02c9, B:200:0x02cf, B:202:0x02d6, B:204:0x02da, B:206:0x02e0, B:194:0x02b2, B:132:0x01f9, B:207:0x02ea, B:209:0x02ee, B:210:0x02f6, B:212:0x02fa, B:214:0x0304, B:215:0x0311, B:220:0x032a, B:217:0x0323), top: B:231:0x0181, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0284 A[Catch: Exception -> 0x01ac, TryCatch #0 {Exception -> 0x01ac, blocks: (B:93:0x0181, B:95:0x0187, B:100:0x0194, B:106:0x01a3, B:110:0x01b0, B:111:0x01c1, B:113:0x01c5, B:116:0x01cb, B:119:0x01d3, B:121:0x01d7, B:123:0x01dd, B:126:0x01e7, B:128:0x01eb, B:130:0x01f1, B:134:0x020c, B:136:0x0210, B:138:0x0216, B:139:0x021b, B:141:0x021f, B:143:0x0223, B:145:0x0229, B:146:0x022e, B:148:0x0232, B:150:0x0238, B:152:0x023c, B:154:0x0240, B:156:0x0246, B:157:0x024b, B:159:0x024f, B:161:0x0253, B:163:0x0259, B:165:0x0260, B:167:0x0264, B:169:0x026a, B:171:0x0271, B:173:0x0275, B:175:0x027b, B:176:0x0280, B:178:0x0284, B:181:0x028c, B:183:0x0290, B:185:0x0296, B:188:0x02a0, B:190:0x02a4, B:192:0x02aa, B:196:0x02c5, B:198:0x02c9, B:200:0x02cf, B:202:0x02d6, B:204:0x02da, B:206:0x02e0, B:194:0x02b2, B:132:0x01f9, B:207:0x02ea, B:209:0x02ee, B:210:0x02f6, B:212:0x02fa, B:214:0x0304, B:215:0x0311, B:220:0x032a, B:217:0x0323), top: B:231:0x0181, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x028c A[Catch: Exception -> 0x01ac, TryCatch #0 {Exception -> 0x01ac, blocks: (B:93:0x0181, B:95:0x0187, B:100:0x0194, B:106:0x01a3, B:110:0x01b0, B:111:0x01c1, B:113:0x01c5, B:116:0x01cb, B:119:0x01d3, B:121:0x01d7, B:123:0x01dd, B:126:0x01e7, B:128:0x01eb, B:130:0x01f1, B:134:0x020c, B:136:0x0210, B:138:0x0216, B:139:0x021b, B:141:0x021f, B:143:0x0223, B:145:0x0229, B:146:0x022e, B:148:0x0232, B:150:0x0238, B:152:0x023c, B:154:0x0240, B:156:0x0246, B:157:0x024b, B:159:0x024f, B:161:0x0253, B:163:0x0259, B:165:0x0260, B:167:0x0264, B:169:0x026a, B:171:0x0271, B:173:0x0275, B:175:0x027b, B:176:0x0280, B:178:0x0284, B:181:0x028c, B:183:0x0290, B:185:0x0296, B:188:0x02a0, B:190:0x02a4, B:192:0x02aa, B:196:0x02c5, B:198:0x02c9, B:200:0x02cf, B:202:0x02d6, B:204:0x02da, B:206:0x02e0, B:194:0x02b2, B:132:0x01f9, B:207:0x02ea, B:209:0x02ee, B:210:0x02f6, B:212:0x02fa, B:214:0x0304, B:215:0x0311, B:220:0x032a, B:217:0x0323), top: B:231:0x0181, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x02c5 A[Catch: Exception -> 0x01ac, TryCatch #0 {Exception -> 0x01ac, blocks: (B:93:0x0181, B:95:0x0187, B:100:0x0194, B:106:0x01a3, B:110:0x01b0, B:111:0x01c1, B:113:0x01c5, B:116:0x01cb, B:119:0x01d3, B:121:0x01d7, B:123:0x01dd, B:126:0x01e7, B:128:0x01eb, B:130:0x01f1, B:134:0x020c, B:136:0x0210, B:138:0x0216, B:139:0x021b, B:141:0x021f, B:143:0x0223, B:145:0x0229, B:146:0x022e, B:148:0x0232, B:150:0x0238, B:152:0x023c, B:154:0x0240, B:156:0x0246, B:157:0x024b, B:159:0x024f, B:161:0x0253, B:163:0x0259, B:165:0x0260, B:167:0x0264, B:169:0x026a, B:171:0x0271, B:173:0x0275, B:175:0x027b, B:176:0x0280, B:178:0x0284, B:181:0x028c, B:183:0x0290, B:185:0x0296, B:188:0x02a0, B:190:0x02a4, B:192:0x02aa, B:196:0x02c5, B:198:0x02c9, B:200:0x02cf, B:202:0x02d6, B:204:0x02da, B:206:0x02e0, B:194:0x02b2, B:132:0x01f9, B:207:0x02ea, B:209:0x02ee, B:210:0x02f6, B:212:0x02fa, B:214:0x0304, B:215:0x0311, B:220:0x032a, B:217:0x0323), top: B:231:0x0181, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02d6 A[Catch: Exception -> 0x01ac, TryCatch #0 {Exception -> 0x01ac, blocks: (B:93:0x0181, B:95:0x0187, B:100:0x0194, B:106:0x01a3, B:110:0x01b0, B:111:0x01c1, B:113:0x01c5, B:116:0x01cb, B:119:0x01d3, B:121:0x01d7, B:123:0x01dd, B:126:0x01e7, B:128:0x01eb, B:130:0x01f1, B:134:0x020c, B:136:0x0210, B:138:0x0216, B:139:0x021b, B:141:0x021f, B:143:0x0223, B:145:0x0229, B:146:0x022e, B:148:0x0232, B:150:0x0238, B:152:0x023c, B:154:0x0240, B:156:0x0246, B:157:0x024b, B:159:0x024f, B:161:0x0253, B:163:0x0259, B:165:0x0260, B:167:0x0264, B:169:0x026a, B:171:0x0271, B:173:0x0275, B:175:0x027b, B:176:0x0280, B:178:0x0284, B:181:0x028c, B:183:0x0290, B:185:0x0296, B:188:0x02a0, B:190:0x02a4, B:192:0x02aa, B:196:0x02c5, B:198:0x02c9, B:200:0x02cf, B:202:0x02d6, B:204:0x02da, B:206:0x02e0, B:194:0x02b2, B:132:0x01f9, B:207:0x02ea, B:209:0x02ee, B:210:0x02f6, B:212:0x02fa, B:214:0x0304, B:215:0x0311, B:220:0x032a, B:217:0x0323), top: B:231:0x0181, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void addressDailog() {
        /*
            Method dump skipped, instruction units count: 863
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Payment.InstantPurchase.addressDailog():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addressDailog$lambda$50(Dialog dialog, View view) {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addressDailog$lambda$51(InstantPurchase instantPurchase, View view) {
        List<StatesCitiesData> data;
        StatesCities statesCities = instantPurchase.states;
        if (statesCities == null || (statesCities != null && (data = statesCities.getData()) != null && data.size() == 0)) {
            String string = instantPurchase.getResources().getString(R.string.no_state_available);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            instantPurchase.showMessage(string);
        } else {
            instantPurchase.clicktype = "1";
            StatesCities statesCities2 = instantPurchase.states;
            Intrinsics.checkNotNull(statesCities2);
            instantPurchase.filterList("1", statesCities2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addressDailog$lambda$52(InstantPurchase instantPurchase, View view) {
        List<StatesCitiesData> data;
        StatesCities statesCities = instantPurchase.cities;
        if (statesCities == null || (statesCities != null && (data = statesCities.getData()) != null && data.size() == 0)) {
            String string = instantPurchase.getResources().getString(R.string.please_select_state_first);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            instantPurchase.showMessage(string);
        } else {
            instantPurchase.clicktype = "2";
            StatesCities statesCities2 = instantPurchase.cities;
            Intrinsics.checkNotNull(statesCities2);
            instantPurchase.filterList("2", statesCities2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence addressDailog$lambda$53(EditText editText, CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (!Intrinsics.areEqual(charSequence, "")) {
            if (!new Regex("[0-9]+").matches(charSequence.toString())) {
                return "";
            }
            if (String.valueOf(editText != null ? editText.getText() : null).length() > 5) {
                return "";
            }
        }
        return charSequence;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addressDailog$lambda$74(EditText editText, InstantPurchase instantPurchase, EditText editText2, EditText editText3, EditText editText4, EditText editText5, EditText editText6, EditText editText7, CheckBox checkBox, Dialog dialog, View view) {
        Editable text;
        if (editText != null) {
            try {
                text = editText.getText();
            } catch (Exception e2) {
                Log.d("TAGINSTANTPURCHASE", "Error: " + e2.getMessage());
                return;
            }
        } else {
            text = null;
        }
        String strValueOf = String.valueOf(text);
        boolean z = true;
        int length = strValueOf.length() - 1;
        int i = 0;
        boolean z2 = false;
        while (i <= length) {
            boolean z3 = Intrinsics.compare((int) strValueOf.charAt(!z2 ? i : length), 32) <= 0;
            if (z2) {
                if (!z3) {
                    break;
                } else {
                    length--;
                }
            } else if (z3) {
                i++;
            } else {
                z2 = true;
            }
        }
        if (TextUtils.isEmpty(strValueOf.subSequence(i, length + 1).toString())) {
            String string = instantPurchase.getResources().getString(R.string.name_field_is_required);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            instantPurchase.showMessage(string);
            Unit unit = Unit.INSTANCE;
            return;
        }
        String strValueOf2 = String.valueOf(editText2 != null ? editText2.getText() : null);
        int length2 = strValueOf2.length() - 1;
        int i2 = 0;
        boolean z4 = false;
        while (i2 <= length2) {
            boolean z5 = Intrinsics.compare((int) strValueOf2.charAt(!z4 ? i2 : length2), 32) <= 0;
            if (z4) {
                if (!z5) {
                    break;
                } else {
                    length2--;
                }
            } else if (z5) {
                i2++;
            } else {
                z4 = true;
            }
        }
        if (TextUtils.isEmpty(strValueOf2.subSequence(i2, length2 + 1).toString())) {
            String string2 = instantPurchase.getResources().getString(R.string.mobile_field_is_required);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            instantPurchase.showMessage(string2);
            Unit unit2 = Unit.INSTANCE;
            return;
        }
        String strValueOf3 = String.valueOf(editText2 != null ? editText2.getText() : null);
        int length3 = strValueOf3.length() - 1;
        int i3 = 0;
        boolean z6 = false;
        while (i3 <= length3) {
            boolean z7 = Intrinsics.compare((int) strValueOf3.charAt(!z6 ? i3 : length3), 32) <= 0;
            if (z6) {
                if (!z7) {
                    break;
                } else {
                    length3--;
                }
            } else if (z7) {
                i3++;
            } else {
                z6 = true;
            }
        }
        if (Helper.isInValidIndianMobile(strValueOf3.subSequence(i3, length3 + 1).toString())) {
            String string3 = instantPurchase.getResources().getString(R.string.this_number_is_invalid);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            instantPurchase.showMessage(string3);
            Unit unit3 = Unit.INSTANCE;
            return;
        }
        String strValueOf4 = String.valueOf(editText3 != null ? editText3.getText() : null);
        int length4 = strValueOf4.length() - 1;
        int i4 = 0;
        boolean z8 = false;
        while (i4 <= length4) {
            boolean z9 = Intrinsics.compare((int) strValueOf4.charAt(!z8 ? i4 : length4), 32) <= 0;
            if (z8) {
                if (!z9) {
                    break;
                } else {
                    length4--;
                }
            } else if (z9) {
                i4++;
            } else {
                z8 = true;
            }
        }
        if (TextUtils.isEmpty(strValueOf4.subSequence(i4, length4 + 1).toString())) {
            String string4 = instantPurchase.getResources().getString(R.string.address_field_is_required);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            instantPurchase.showMessage(string4);
            Unit unit4 = Unit.INSTANCE;
            return;
        }
        String strValueOf5 = String.valueOf(editText3 != null ? editText3.getText() : null);
        int length5 = strValueOf5.length() - 1;
        int i5 = 0;
        boolean z10 = false;
        while (i5 <= length5) {
            boolean z11 = Intrinsics.compare((int) strValueOf5.charAt(!z10 ? i5 : length5), 32) <= 0;
            if (z10) {
                if (!z11) {
                    break;
                } else {
                    length5--;
                }
            } else if (z11) {
                i5++;
            } else {
                z10 = true;
            }
        }
        if (strValueOf5.subSequence(i5, length5 + 1).toString().length() <= 5) {
            String string5 = instantPurchase.getResources().getString(R.string.enter_valid_address);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            instantPurchase.showMessage(string5);
            Unit unit5 = Unit.INSTANCE;
            return;
        }
        TextView textView = instantPurchase.statesTV;
        String strValueOf6 = String.valueOf(textView != null ? textView.getText() : null);
        int length6 = strValueOf6.length() - 1;
        int i6 = 0;
        boolean z12 = false;
        while (i6 <= length6) {
            boolean z13 = Intrinsics.compare((int) strValueOf6.charAt(!z12 ? i6 : length6), 32) <= 0;
            if (z12) {
                if (!z13) {
                    break;
                } else {
                    length6--;
                }
            } else if (z13) {
                i6++;
            } else {
                z12 = true;
            }
        }
        if (TextUtils.isEmpty(strValueOf6.subSequence(i6, length6 + 1).toString())) {
            String string6 = instantPurchase.getResources().getString(R.string.state_field_is_required);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            instantPurchase.showMessage(string6);
            Unit unit6 = Unit.INSTANCE;
            return;
        }
        TextView textView2 = instantPurchase.districtTV;
        String strValueOf7 = String.valueOf(textView2 != null ? textView2.getText() : null);
        int length7 = strValueOf7.length() - 1;
        int i7 = 0;
        boolean z14 = false;
        while (i7 <= length7) {
            boolean z15 = Intrinsics.compare((int) strValueOf7.charAt(!z14 ? i7 : length7), 32) <= 0;
            if (z14) {
                if (!z15) {
                    break;
                } else {
                    length7--;
                }
            } else if (z15) {
                i7++;
            } else {
                z14 = true;
            }
        }
        if (TextUtils.isEmpty(strValueOf7.subSequence(i7, length7 + 1).toString())) {
            String string7 = instantPurchase.getResources().getString(R.string.district_field_is_required);
            Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
            instantPurchase.showMessage(string7);
            Unit unit7 = Unit.INSTANCE;
            return;
        }
        String strValueOf8 = String.valueOf(editText4 != null ? editText4.getText() : null);
        int length8 = strValueOf8.length() - 1;
        int i8 = 0;
        boolean z16 = false;
        while (i8 <= length8) {
            boolean z17 = Intrinsics.compare((int) strValueOf8.charAt(!z16 ? i8 : length8), 32) <= 0;
            if (z16) {
                if (!z17) {
                    break;
                } else {
                    length8--;
                }
            } else if (z17) {
                i8++;
            } else {
                z16 = true;
            }
        }
        if (TextUtils.isEmpty(strValueOf8.subSequence(i8, length8 + 1).toString())) {
            String string8 = instantPurchase.getResources().getString(R.string.city_field_is_required);
            Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
            instantPurchase.showMessage(string8);
            Unit unit8 = Unit.INSTANCE;
            return;
        }
        String strValueOf9 = String.valueOf(editText5 != null ? editText5.getText() : null);
        int length9 = strValueOf9.length() - 1;
        int i9 = 0;
        boolean z18 = false;
        while (i9 <= length9) {
            boolean z19 = Intrinsics.compare((int) strValueOf9.charAt(!z18 ? i9 : length9), 32) <= 0;
            if (z18) {
                if (!z19) {
                    break;
                } else {
                    length9--;
                }
            } else if (z19) {
                i9++;
            } else {
                z18 = true;
            }
        }
        if (!TextUtils.isEmpty(strValueOf9.subSequence(i9, length9 + 1).toString())) {
            if (String.valueOf(editText5 != null ? editText5.getText() : null).length() >= 6) {
                if (!StringsKt.startsWith$default(String.valueOf(editText5 != null ? editText5.getText() : null), "0", false, 2, (Object) null)) {
                    if (String.valueOf(editText2 != null ? editText2.getText() : null).length() == 0) {
                        String string9 = instantPurchase.getResources().getString(R.string.mobile_field_is_required);
                        Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
                        instantPurchase.showMessage(string9);
                        Unit unit9 = Unit.INSTANCE;
                        return;
                    }
                    if (!instantPurchase.numberValidation(editText2)) {
                        String string10 = instantPurchase.getResources().getString(R.string.mobile_number_should_be_at_least_10_digits);
                        Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
                        instantPurchase.showMessage(string10);
                        Unit unit10 = Unit.INSTANCE;
                        return;
                    }
                    if (String.valueOf(editText6 != null ? editText6.getText() : null).length() == 0) {
                        String string11 = instantPurchase.getResources().getString(R.string.mobile_field_is_required);
                        Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
                        instantPurchase.showMessage(string11);
                        Unit unit11 = Unit.INSTANCE;
                        return;
                    }
                    if (!instantPurchase.numberValidation(editText6)) {
                        String string12 = instantPurchase.getResources().getString(R.string.mobile_number_should_be_at_least_10_digits);
                        Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
                        instantPurchase.showMessage(string12);
                        Unit unit12 = Unit.INSTANCE;
                        return;
                    }
                    String strValueOf10 = String.valueOf(editText6 != null ? editText6.getText() : null);
                    int length10 = strValueOf10.length() - 1;
                    int i10 = 0;
                    boolean z20 = false;
                    while (i10 <= length10) {
                        boolean z21 = Intrinsics.compare((int) strValueOf10.charAt(!z20 ? i10 : length10), 32) <= 0;
                        if (z20) {
                            if (!z21) {
                                break;
                            } else {
                                length10--;
                            }
                        } else if (z21) {
                            i10++;
                        } else {
                            z20 = true;
                        }
                    }
                    String string13 = strValueOf10.subSequence(i10, length10 + 1).toString();
                    String strValueOf11 = String.valueOf(editText2 != null ? editText2.getText() : null);
                    int length11 = strValueOf11.length() - 1;
                    int i11 = 0;
                    boolean z22 = false;
                    while (i11 <= length11) {
                        boolean z23 = Intrinsics.compare((int) strValueOf11.charAt(!z22 ? i11 : length11), 32) <= 0;
                        if (z22) {
                            if (!z23) {
                                break;
                            } else {
                                length11--;
                            }
                        } else if (z23) {
                            i11++;
                        } else {
                            z22 = true;
                        }
                    }
                    if (Helper.NotBeSameAlternateMobileNumber(string13, strValueOf11.subSequence(i11, length11 + 1).toString())) {
                        String string14 = instantPurchase.getResources().getString(R.string.change_alternate_number);
                        Intrinsics.checkNotNullExpressionValue(string14, "getString(...)");
                        instantPurchase.showMessage(string14);
                        Unit unit13 = Unit.INSTANCE;
                        return;
                    }
                    String strValueOf12 = String.valueOf(editText != null ? editText.getText() : null);
                    int length12 = strValueOf12.length() - 1;
                    int i12 = 0;
                    boolean z24 = false;
                    while (i12 <= length12) {
                        boolean z25 = Intrinsics.compare((int) strValueOf12.charAt(!z24 ? i12 : length12), 32) <= 0;
                        if (z24) {
                            if (!z25) {
                                break;
                            } else {
                                length12--;
                            }
                        } else if (z25) {
                            i12++;
                        } else {
                            z24 = true;
                        }
                    }
                    String string15 = strValueOf12.subSequence(i12, length12 + 1).toString();
                    String strValueOf13 = String.valueOf(editText3 != null ? editText3.getText() : null);
                    int length13 = strValueOf13.length() - 1;
                    int i13 = 0;
                    boolean z26 = false;
                    while (i13 <= length13) {
                        boolean z27 = Intrinsics.compare((int) strValueOf13.charAt(!z26 ? i13 : length13), 32) <= 0;
                        if (z26) {
                            if (!z27) {
                                break;
                            } else {
                                length13--;
                            }
                        } else if (z27) {
                            i13++;
                        } else {
                            z26 = true;
                        }
                    }
                    String string16 = strValueOf13.subSequence(i13, length13 + 1).toString();
                    String strValueOf14 = String.valueOf(editText2 != null ? editText2.getText() : null);
                    int length14 = strValueOf14.length() - 1;
                    int i14 = 0;
                    boolean z28 = false;
                    while (i14 <= length14) {
                        boolean z29 = Intrinsics.compare((int) strValueOf14.charAt(!z28 ? i14 : length14), 32) <= 0;
                        if (z28) {
                            if (!z29) {
                                break;
                            } else {
                                length14--;
                            }
                        } else if (z29) {
                            i14++;
                        } else {
                            z28 = true;
                        }
                    }
                    String string17 = strValueOf14.subSequence(i14, length14 + 1).toString();
                    String strValueOf15 = String.valueOf(editText6 != null ? editText6.getText() : null);
                    int length15 = strValueOf15.length() - 1;
                    int i15 = 0;
                    boolean z30 = false;
                    while (i15 <= length15) {
                        boolean z31 = Intrinsics.compare((int) strValueOf15.charAt(!z30 ? i15 : length15), 32) <= 0;
                        if (z30) {
                            if (!z31) {
                                break;
                            } else {
                                length15--;
                            }
                        } else if (z31) {
                            i15++;
                        } else {
                            z30 = true;
                        }
                    }
                    String string18 = strValueOf15.subSequence(i15, length15 + 1).toString();
                    TextView textView3 = instantPurchase.statesTV;
                    String strValueOf16 = String.valueOf(textView3 != null ? textView3.getText() : null);
                    int length16 = strValueOf16.length() - 1;
                    int i16 = 0;
                    boolean z32 = false;
                    while (i16 <= length16) {
                        boolean z33 = Intrinsics.compare((int) strValueOf16.charAt(!z32 ? i16 : length16), 32) <= 0;
                        if (z32) {
                            if (!z33) {
                                break;
                            } else {
                                length16--;
                            }
                        } else if (z33) {
                            i16++;
                        } else {
                            z32 = true;
                        }
                    }
                    String string19 = strValueOf16.subSequence(i16, length16 + 1).toString();
                    TextView textView4 = instantPurchase.districtTV;
                    String strValueOf17 = String.valueOf(textView4 != null ? textView4.getText() : null);
                    int length17 = strValueOf17.length() - 1;
                    int i17 = 0;
                    boolean z34 = false;
                    while (i17 <= length17) {
                        boolean z35 = Intrinsics.compare((int) strValueOf17.charAt(!z34 ? i17 : length17), 32) <= 0;
                        if (z34) {
                            if (!z35) {
                                break;
                            } else {
                                length17--;
                            }
                        } else if (z35) {
                            i17++;
                        } else {
                            z34 = true;
                        }
                    }
                    String string20 = strValueOf17.subSequence(i17, length17 + 1).toString();
                    String strValueOf18 = String.valueOf(editText4 != null ? editText4.getText() : null);
                    int length18 = strValueOf18.length() - 1;
                    int i18 = 0;
                    boolean z36 = false;
                    while (i18 <= length18) {
                        boolean z37 = Intrinsics.compare((int) strValueOf18.charAt(!z36 ? i18 : length18), 32) <= 0;
                        if (z36) {
                            if (!z37) {
                                break;
                            } else {
                                length18--;
                            }
                        } else if (z37) {
                            i18++;
                        } else {
                            z36 = true;
                        }
                    }
                    String string21 = strValueOf18.subSequence(i18, length18 + 1).toString();
                    String strValueOf19 = String.valueOf(editText5 != null ? editText5.getText() : null);
                    int length19 = strValueOf19.length() - 1;
                    int i19 = 0;
                    boolean z38 = false;
                    while (i19 <= length19) {
                        boolean z39 = Intrinsics.compare((int) strValueOf19.charAt(!z38 ? i19 : length19), 32) <= 0;
                        if (z38) {
                            if (!z39) {
                                break;
                            } else {
                                length19--;
                            }
                        } else if (z39) {
                            i19++;
                        } else {
                            z38 = true;
                        }
                    }
                    String string22 = strValueOf19.subSequence(i19, length19 + 1).toString();
                    String strValueOf20 = String.valueOf(editText7 != null ? editText7.getText() : null);
                    int length20 = strValueOf20.length() - 1;
                    int i20 = 0;
                    boolean z40 = false;
                    while (i20 <= length20) {
                        boolean z41 = Intrinsics.compare((int) strValueOf20.charAt(!z40 ? i20 : length20), 32) <= 0;
                        if (z40) {
                            if (!z41) {
                                break;
                            } else {
                                length20--;
                            }
                        } else if (z41) {
                            i20++;
                        } else {
                            z40 = true;
                        }
                    }
                    String string23 = strValueOf20.subSequence(i20, length20 + 1).toString();
                    if (checkBox == null || !checkBox.isChecked()) {
                        z = false;
                    }
                    instantPurchase.isDefault = z;
                    instantPurchase.address1 = new Address(string15, string16, string19, string21, string17, string18, string22, string23, string20, instantPurchase.SelectedStateid);
                    instantPurchase.addressJson = new Gson().toJson(instantPurchase.address1);
                    instantPurchase.isAddressEdited = instantPurchase.haveAddress;
                    instantPurchase.hitApiForSavingAddress();
                    if (dialog != null) {
                        dialog.dismiss();
                        Unit unit14 = Unit.INSTANCE;
                        return;
                    }
                    return;
                }
            }
        }
        String string24 = instantPurchase.getResources().getString(R.string.enter_valid_pin_code);
        Intrinsics.checkNotNullExpressionValue(string24, "getString(...)");
        instantPurchase.showMessage(string24);
        Unit unit15 = Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x022f A[Catch: Exception -> 0x036c, TryCatch #0 {Exception -> 0x036c, blocks: (B:3:0x0016, B:6:0x0025, B:9:0x0038, B:11:0x003e, B:19:0x006b, B:21:0x0071, B:25:0x007f, B:27:0x0084, B:29:0x0089, B:31:0x0091, B:34:0x009e, B:37:0x00ac, B:41:0x00ba, B:43:0x00bf, B:45:0x00c6, B:47:0x00cf, B:49:0x00d9, B:51:0x00e2, B:53:0x00f2, B:56:0x00ff, B:59:0x010c, B:62:0x0119, B:65:0x0126, B:67:0x0131, B:69:0x0135, B:71:0x0140, B:73:0x0144, B:76:0x0151, B:79:0x0162, B:82:0x016f, B:85:0x0180, B:86:0x0188, B:88:0x018c, B:90:0x0192, B:95:0x01a4, B:97:0x01af, B:102:0x01bc, B:105:0x01c4, B:106:0x01d5, B:109:0x01ee, B:112:0x01f6, B:114:0x01fa, B:116:0x0200, B:119:0x020a, B:121:0x020e, B:123:0x0214, B:127:0x022f, B:129:0x0233, B:131:0x0239, B:132:0x023e, B:134:0x0242, B:136:0x0246, B:138:0x024c, B:139:0x0251, B:141:0x0255, B:143:0x025b, B:145:0x025f, B:147:0x0263, B:149:0x0269, B:150:0x026e, B:152:0x0272, B:154:0x0276, B:156:0x027c, B:158:0x0283, B:160:0x0287, B:162:0x028d, B:164:0x0294, B:166:0x0298, B:168:0x029e, B:169:0x02a3, B:171:0x02a7, B:174:0x02af, B:176:0x02b3, B:178:0x02b9, B:181:0x02c3, B:183:0x02c7, B:185:0x02cd, B:189:0x02e8, B:191:0x02ec, B:193:0x02f5, B:195:0x02fe, B:187:0x02d5, B:125:0x021c, B:196:0x030c, B:198:0x0310, B:199:0x0318, B:201:0x031c, B:203:0x0326, B:204:0x0333, B:209:0x0352, B:13:0x0044, B:15:0x0048, B:17:0x0057, B:18:0x0066, B:206:0x034b), top: B:215:0x0016, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0242 A[Catch: Exception -> 0x036c, TryCatch #0 {Exception -> 0x036c, blocks: (B:3:0x0016, B:6:0x0025, B:9:0x0038, B:11:0x003e, B:19:0x006b, B:21:0x0071, B:25:0x007f, B:27:0x0084, B:29:0x0089, B:31:0x0091, B:34:0x009e, B:37:0x00ac, B:41:0x00ba, B:43:0x00bf, B:45:0x00c6, B:47:0x00cf, B:49:0x00d9, B:51:0x00e2, B:53:0x00f2, B:56:0x00ff, B:59:0x010c, B:62:0x0119, B:65:0x0126, B:67:0x0131, B:69:0x0135, B:71:0x0140, B:73:0x0144, B:76:0x0151, B:79:0x0162, B:82:0x016f, B:85:0x0180, B:86:0x0188, B:88:0x018c, B:90:0x0192, B:95:0x01a4, B:97:0x01af, B:102:0x01bc, B:105:0x01c4, B:106:0x01d5, B:109:0x01ee, B:112:0x01f6, B:114:0x01fa, B:116:0x0200, B:119:0x020a, B:121:0x020e, B:123:0x0214, B:127:0x022f, B:129:0x0233, B:131:0x0239, B:132:0x023e, B:134:0x0242, B:136:0x0246, B:138:0x024c, B:139:0x0251, B:141:0x0255, B:143:0x025b, B:145:0x025f, B:147:0x0263, B:149:0x0269, B:150:0x026e, B:152:0x0272, B:154:0x0276, B:156:0x027c, B:158:0x0283, B:160:0x0287, B:162:0x028d, B:164:0x0294, B:166:0x0298, B:168:0x029e, B:169:0x02a3, B:171:0x02a7, B:174:0x02af, B:176:0x02b3, B:178:0x02b9, B:181:0x02c3, B:183:0x02c7, B:185:0x02cd, B:189:0x02e8, B:191:0x02ec, B:193:0x02f5, B:195:0x02fe, B:187:0x02d5, B:125:0x021c, B:196:0x030c, B:198:0x0310, B:199:0x0318, B:201:0x031c, B:203:0x0326, B:204:0x0333, B:209:0x0352, B:13:0x0044, B:15:0x0048, B:17:0x0057, B:18:0x0066, B:206:0x034b), top: B:215:0x0016, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0255 A[Catch: Exception -> 0x036c, TryCatch #0 {Exception -> 0x036c, blocks: (B:3:0x0016, B:6:0x0025, B:9:0x0038, B:11:0x003e, B:19:0x006b, B:21:0x0071, B:25:0x007f, B:27:0x0084, B:29:0x0089, B:31:0x0091, B:34:0x009e, B:37:0x00ac, B:41:0x00ba, B:43:0x00bf, B:45:0x00c6, B:47:0x00cf, B:49:0x00d9, B:51:0x00e2, B:53:0x00f2, B:56:0x00ff, B:59:0x010c, B:62:0x0119, B:65:0x0126, B:67:0x0131, B:69:0x0135, B:71:0x0140, B:73:0x0144, B:76:0x0151, B:79:0x0162, B:82:0x016f, B:85:0x0180, B:86:0x0188, B:88:0x018c, B:90:0x0192, B:95:0x01a4, B:97:0x01af, B:102:0x01bc, B:105:0x01c4, B:106:0x01d5, B:109:0x01ee, B:112:0x01f6, B:114:0x01fa, B:116:0x0200, B:119:0x020a, B:121:0x020e, B:123:0x0214, B:127:0x022f, B:129:0x0233, B:131:0x0239, B:132:0x023e, B:134:0x0242, B:136:0x0246, B:138:0x024c, B:139:0x0251, B:141:0x0255, B:143:0x025b, B:145:0x025f, B:147:0x0263, B:149:0x0269, B:150:0x026e, B:152:0x0272, B:154:0x0276, B:156:0x027c, B:158:0x0283, B:160:0x0287, B:162:0x028d, B:164:0x0294, B:166:0x0298, B:168:0x029e, B:169:0x02a3, B:171:0x02a7, B:174:0x02af, B:176:0x02b3, B:178:0x02b9, B:181:0x02c3, B:183:0x02c7, B:185:0x02cd, B:189:0x02e8, B:191:0x02ec, B:193:0x02f5, B:195:0x02fe, B:187:0x02d5, B:125:0x021c, B:196:0x030c, B:198:0x0310, B:199:0x0318, B:201:0x031c, B:203:0x0326, B:204:0x0333, B:209:0x0352, B:13:0x0044, B:15:0x0048, B:17:0x0057, B:18:0x0066, B:206:0x034b), top: B:215:0x0016, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x025f A[Catch: Exception -> 0x036c, TryCatch #0 {Exception -> 0x036c, blocks: (B:3:0x0016, B:6:0x0025, B:9:0x0038, B:11:0x003e, B:19:0x006b, B:21:0x0071, B:25:0x007f, B:27:0x0084, B:29:0x0089, B:31:0x0091, B:34:0x009e, B:37:0x00ac, B:41:0x00ba, B:43:0x00bf, B:45:0x00c6, B:47:0x00cf, B:49:0x00d9, B:51:0x00e2, B:53:0x00f2, B:56:0x00ff, B:59:0x010c, B:62:0x0119, B:65:0x0126, B:67:0x0131, B:69:0x0135, B:71:0x0140, B:73:0x0144, B:76:0x0151, B:79:0x0162, B:82:0x016f, B:85:0x0180, B:86:0x0188, B:88:0x018c, B:90:0x0192, B:95:0x01a4, B:97:0x01af, B:102:0x01bc, B:105:0x01c4, B:106:0x01d5, B:109:0x01ee, B:112:0x01f6, B:114:0x01fa, B:116:0x0200, B:119:0x020a, B:121:0x020e, B:123:0x0214, B:127:0x022f, B:129:0x0233, B:131:0x0239, B:132:0x023e, B:134:0x0242, B:136:0x0246, B:138:0x024c, B:139:0x0251, B:141:0x0255, B:143:0x025b, B:145:0x025f, B:147:0x0263, B:149:0x0269, B:150:0x026e, B:152:0x0272, B:154:0x0276, B:156:0x027c, B:158:0x0283, B:160:0x0287, B:162:0x028d, B:164:0x0294, B:166:0x0298, B:168:0x029e, B:169:0x02a3, B:171:0x02a7, B:174:0x02af, B:176:0x02b3, B:178:0x02b9, B:181:0x02c3, B:183:0x02c7, B:185:0x02cd, B:189:0x02e8, B:191:0x02ec, B:193:0x02f5, B:195:0x02fe, B:187:0x02d5, B:125:0x021c, B:196:0x030c, B:198:0x0310, B:199:0x0318, B:201:0x031c, B:203:0x0326, B:204:0x0333, B:209:0x0352, B:13:0x0044, B:15:0x0048, B:17:0x0057, B:18:0x0066, B:206:0x034b), top: B:215:0x0016, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0272 A[Catch: Exception -> 0x036c, TryCatch #0 {Exception -> 0x036c, blocks: (B:3:0x0016, B:6:0x0025, B:9:0x0038, B:11:0x003e, B:19:0x006b, B:21:0x0071, B:25:0x007f, B:27:0x0084, B:29:0x0089, B:31:0x0091, B:34:0x009e, B:37:0x00ac, B:41:0x00ba, B:43:0x00bf, B:45:0x00c6, B:47:0x00cf, B:49:0x00d9, B:51:0x00e2, B:53:0x00f2, B:56:0x00ff, B:59:0x010c, B:62:0x0119, B:65:0x0126, B:67:0x0131, B:69:0x0135, B:71:0x0140, B:73:0x0144, B:76:0x0151, B:79:0x0162, B:82:0x016f, B:85:0x0180, B:86:0x0188, B:88:0x018c, B:90:0x0192, B:95:0x01a4, B:97:0x01af, B:102:0x01bc, B:105:0x01c4, B:106:0x01d5, B:109:0x01ee, B:112:0x01f6, B:114:0x01fa, B:116:0x0200, B:119:0x020a, B:121:0x020e, B:123:0x0214, B:127:0x022f, B:129:0x0233, B:131:0x0239, B:132:0x023e, B:134:0x0242, B:136:0x0246, B:138:0x024c, B:139:0x0251, B:141:0x0255, B:143:0x025b, B:145:0x025f, B:147:0x0263, B:149:0x0269, B:150:0x026e, B:152:0x0272, B:154:0x0276, B:156:0x027c, B:158:0x0283, B:160:0x0287, B:162:0x028d, B:164:0x0294, B:166:0x0298, B:168:0x029e, B:169:0x02a3, B:171:0x02a7, B:174:0x02af, B:176:0x02b3, B:178:0x02b9, B:181:0x02c3, B:183:0x02c7, B:185:0x02cd, B:189:0x02e8, B:191:0x02ec, B:193:0x02f5, B:195:0x02fe, B:187:0x02d5, B:125:0x021c, B:196:0x030c, B:198:0x0310, B:199:0x0318, B:201:0x031c, B:203:0x0326, B:204:0x0333, B:209:0x0352, B:13:0x0044, B:15:0x0048, B:17:0x0057, B:18:0x0066, B:206:0x034b), top: B:215:0x0016, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0283 A[Catch: Exception -> 0x036c, TryCatch #0 {Exception -> 0x036c, blocks: (B:3:0x0016, B:6:0x0025, B:9:0x0038, B:11:0x003e, B:19:0x006b, B:21:0x0071, B:25:0x007f, B:27:0x0084, B:29:0x0089, B:31:0x0091, B:34:0x009e, B:37:0x00ac, B:41:0x00ba, B:43:0x00bf, B:45:0x00c6, B:47:0x00cf, B:49:0x00d9, B:51:0x00e2, B:53:0x00f2, B:56:0x00ff, B:59:0x010c, B:62:0x0119, B:65:0x0126, B:67:0x0131, B:69:0x0135, B:71:0x0140, B:73:0x0144, B:76:0x0151, B:79:0x0162, B:82:0x016f, B:85:0x0180, B:86:0x0188, B:88:0x018c, B:90:0x0192, B:95:0x01a4, B:97:0x01af, B:102:0x01bc, B:105:0x01c4, B:106:0x01d5, B:109:0x01ee, B:112:0x01f6, B:114:0x01fa, B:116:0x0200, B:119:0x020a, B:121:0x020e, B:123:0x0214, B:127:0x022f, B:129:0x0233, B:131:0x0239, B:132:0x023e, B:134:0x0242, B:136:0x0246, B:138:0x024c, B:139:0x0251, B:141:0x0255, B:143:0x025b, B:145:0x025f, B:147:0x0263, B:149:0x0269, B:150:0x026e, B:152:0x0272, B:154:0x0276, B:156:0x027c, B:158:0x0283, B:160:0x0287, B:162:0x028d, B:164:0x0294, B:166:0x0298, B:168:0x029e, B:169:0x02a3, B:171:0x02a7, B:174:0x02af, B:176:0x02b3, B:178:0x02b9, B:181:0x02c3, B:183:0x02c7, B:185:0x02cd, B:189:0x02e8, B:191:0x02ec, B:193:0x02f5, B:195:0x02fe, B:187:0x02d5, B:125:0x021c, B:196:0x030c, B:198:0x0310, B:199:0x0318, B:201:0x031c, B:203:0x0326, B:204:0x0333, B:209:0x0352, B:13:0x0044, B:15:0x0048, B:17:0x0057, B:18:0x0066, B:206:0x034b), top: B:215:0x0016, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0294 A[Catch: Exception -> 0x036c, TryCatch #0 {Exception -> 0x036c, blocks: (B:3:0x0016, B:6:0x0025, B:9:0x0038, B:11:0x003e, B:19:0x006b, B:21:0x0071, B:25:0x007f, B:27:0x0084, B:29:0x0089, B:31:0x0091, B:34:0x009e, B:37:0x00ac, B:41:0x00ba, B:43:0x00bf, B:45:0x00c6, B:47:0x00cf, B:49:0x00d9, B:51:0x00e2, B:53:0x00f2, B:56:0x00ff, B:59:0x010c, B:62:0x0119, B:65:0x0126, B:67:0x0131, B:69:0x0135, B:71:0x0140, B:73:0x0144, B:76:0x0151, B:79:0x0162, B:82:0x016f, B:85:0x0180, B:86:0x0188, B:88:0x018c, B:90:0x0192, B:95:0x01a4, B:97:0x01af, B:102:0x01bc, B:105:0x01c4, B:106:0x01d5, B:109:0x01ee, B:112:0x01f6, B:114:0x01fa, B:116:0x0200, B:119:0x020a, B:121:0x020e, B:123:0x0214, B:127:0x022f, B:129:0x0233, B:131:0x0239, B:132:0x023e, B:134:0x0242, B:136:0x0246, B:138:0x024c, B:139:0x0251, B:141:0x0255, B:143:0x025b, B:145:0x025f, B:147:0x0263, B:149:0x0269, B:150:0x026e, B:152:0x0272, B:154:0x0276, B:156:0x027c, B:158:0x0283, B:160:0x0287, B:162:0x028d, B:164:0x0294, B:166:0x0298, B:168:0x029e, B:169:0x02a3, B:171:0x02a7, B:174:0x02af, B:176:0x02b3, B:178:0x02b9, B:181:0x02c3, B:183:0x02c7, B:185:0x02cd, B:189:0x02e8, B:191:0x02ec, B:193:0x02f5, B:195:0x02fe, B:187:0x02d5, B:125:0x021c, B:196:0x030c, B:198:0x0310, B:199:0x0318, B:201:0x031c, B:203:0x0326, B:204:0x0333, B:209:0x0352, B:13:0x0044, B:15:0x0048, B:17:0x0057, B:18:0x0066, B:206:0x034b), top: B:215:0x0016, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02a7 A[Catch: Exception -> 0x036c, TryCatch #0 {Exception -> 0x036c, blocks: (B:3:0x0016, B:6:0x0025, B:9:0x0038, B:11:0x003e, B:19:0x006b, B:21:0x0071, B:25:0x007f, B:27:0x0084, B:29:0x0089, B:31:0x0091, B:34:0x009e, B:37:0x00ac, B:41:0x00ba, B:43:0x00bf, B:45:0x00c6, B:47:0x00cf, B:49:0x00d9, B:51:0x00e2, B:53:0x00f2, B:56:0x00ff, B:59:0x010c, B:62:0x0119, B:65:0x0126, B:67:0x0131, B:69:0x0135, B:71:0x0140, B:73:0x0144, B:76:0x0151, B:79:0x0162, B:82:0x016f, B:85:0x0180, B:86:0x0188, B:88:0x018c, B:90:0x0192, B:95:0x01a4, B:97:0x01af, B:102:0x01bc, B:105:0x01c4, B:106:0x01d5, B:109:0x01ee, B:112:0x01f6, B:114:0x01fa, B:116:0x0200, B:119:0x020a, B:121:0x020e, B:123:0x0214, B:127:0x022f, B:129:0x0233, B:131:0x0239, B:132:0x023e, B:134:0x0242, B:136:0x0246, B:138:0x024c, B:139:0x0251, B:141:0x0255, B:143:0x025b, B:145:0x025f, B:147:0x0263, B:149:0x0269, B:150:0x026e, B:152:0x0272, B:154:0x0276, B:156:0x027c, B:158:0x0283, B:160:0x0287, B:162:0x028d, B:164:0x0294, B:166:0x0298, B:168:0x029e, B:169:0x02a3, B:171:0x02a7, B:174:0x02af, B:176:0x02b3, B:178:0x02b9, B:181:0x02c3, B:183:0x02c7, B:185:0x02cd, B:189:0x02e8, B:191:0x02ec, B:193:0x02f5, B:195:0x02fe, B:187:0x02d5, B:125:0x021c, B:196:0x030c, B:198:0x0310, B:199:0x0318, B:201:0x031c, B:203:0x0326, B:204:0x0333, B:209:0x0352, B:13:0x0044, B:15:0x0048, B:17:0x0057, B:18:0x0066, B:206:0x034b), top: B:215:0x0016, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02af A[Catch: Exception -> 0x036c, TryCatch #0 {Exception -> 0x036c, blocks: (B:3:0x0016, B:6:0x0025, B:9:0x0038, B:11:0x003e, B:19:0x006b, B:21:0x0071, B:25:0x007f, B:27:0x0084, B:29:0x0089, B:31:0x0091, B:34:0x009e, B:37:0x00ac, B:41:0x00ba, B:43:0x00bf, B:45:0x00c6, B:47:0x00cf, B:49:0x00d9, B:51:0x00e2, B:53:0x00f2, B:56:0x00ff, B:59:0x010c, B:62:0x0119, B:65:0x0126, B:67:0x0131, B:69:0x0135, B:71:0x0140, B:73:0x0144, B:76:0x0151, B:79:0x0162, B:82:0x016f, B:85:0x0180, B:86:0x0188, B:88:0x018c, B:90:0x0192, B:95:0x01a4, B:97:0x01af, B:102:0x01bc, B:105:0x01c4, B:106:0x01d5, B:109:0x01ee, B:112:0x01f6, B:114:0x01fa, B:116:0x0200, B:119:0x020a, B:121:0x020e, B:123:0x0214, B:127:0x022f, B:129:0x0233, B:131:0x0239, B:132:0x023e, B:134:0x0242, B:136:0x0246, B:138:0x024c, B:139:0x0251, B:141:0x0255, B:143:0x025b, B:145:0x025f, B:147:0x0263, B:149:0x0269, B:150:0x026e, B:152:0x0272, B:154:0x0276, B:156:0x027c, B:158:0x0283, B:160:0x0287, B:162:0x028d, B:164:0x0294, B:166:0x0298, B:168:0x029e, B:169:0x02a3, B:171:0x02a7, B:174:0x02af, B:176:0x02b3, B:178:0x02b9, B:181:0x02c3, B:183:0x02c7, B:185:0x02cd, B:189:0x02e8, B:191:0x02ec, B:193:0x02f5, B:195:0x02fe, B:187:0x02d5, B:125:0x021c, B:196:0x030c, B:198:0x0310, B:199:0x0318, B:201:0x031c, B:203:0x0326, B:204:0x0333, B:209:0x0352, B:13:0x0044, B:15:0x0048, B:17:0x0057, B:18:0x0066, B:206:0x034b), top: B:215:0x0016, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x02e8 A[Catch: Exception -> 0x036c, TryCatch #0 {Exception -> 0x036c, blocks: (B:3:0x0016, B:6:0x0025, B:9:0x0038, B:11:0x003e, B:19:0x006b, B:21:0x0071, B:25:0x007f, B:27:0x0084, B:29:0x0089, B:31:0x0091, B:34:0x009e, B:37:0x00ac, B:41:0x00ba, B:43:0x00bf, B:45:0x00c6, B:47:0x00cf, B:49:0x00d9, B:51:0x00e2, B:53:0x00f2, B:56:0x00ff, B:59:0x010c, B:62:0x0119, B:65:0x0126, B:67:0x0131, B:69:0x0135, B:71:0x0140, B:73:0x0144, B:76:0x0151, B:79:0x0162, B:82:0x016f, B:85:0x0180, B:86:0x0188, B:88:0x018c, B:90:0x0192, B:95:0x01a4, B:97:0x01af, B:102:0x01bc, B:105:0x01c4, B:106:0x01d5, B:109:0x01ee, B:112:0x01f6, B:114:0x01fa, B:116:0x0200, B:119:0x020a, B:121:0x020e, B:123:0x0214, B:127:0x022f, B:129:0x0233, B:131:0x0239, B:132:0x023e, B:134:0x0242, B:136:0x0246, B:138:0x024c, B:139:0x0251, B:141:0x0255, B:143:0x025b, B:145:0x025f, B:147:0x0263, B:149:0x0269, B:150:0x026e, B:152:0x0272, B:154:0x0276, B:156:0x027c, B:158:0x0283, B:160:0x0287, B:162:0x028d, B:164:0x0294, B:166:0x0298, B:168:0x029e, B:169:0x02a3, B:171:0x02a7, B:174:0x02af, B:176:0x02b3, B:178:0x02b9, B:181:0x02c3, B:183:0x02c7, B:185:0x02cd, B:189:0x02e8, B:191:0x02ec, B:193:0x02f5, B:195:0x02fe, B:187:0x02d5, B:125:0x021c, B:196:0x030c, B:198:0x0310, B:199:0x0318, B:201:0x031c, B:203:0x0326, B:204:0x0333, B:209:0x0352, B:13:0x0044, B:15:0x0048, B:17:0x0057, B:18:0x0066, B:206:0x034b), top: B:215:0x0016, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066 A[Catch: Exception -> 0x036c, TryCatch #0 {Exception -> 0x036c, blocks: (B:3:0x0016, B:6:0x0025, B:9:0x0038, B:11:0x003e, B:19:0x006b, B:21:0x0071, B:25:0x007f, B:27:0x0084, B:29:0x0089, B:31:0x0091, B:34:0x009e, B:37:0x00ac, B:41:0x00ba, B:43:0x00bf, B:45:0x00c6, B:47:0x00cf, B:49:0x00d9, B:51:0x00e2, B:53:0x00f2, B:56:0x00ff, B:59:0x010c, B:62:0x0119, B:65:0x0126, B:67:0x0131, B:69:0x0135, B:71:0x0140, B:73:0x0144, B:76:0x0151, B:79:0x0162, B:82:0x016f, B:85:0x0180, B:86:0x0188, B:88:0x018c, B:90:0x0192, B:95:0x01a4, B:97:0x01af, B:102:0x01bc, B:105:0x01c4, B:106:0x01d5, B:109:0x01ee, B:112:0x01f6, B:114:0x01fa, B:116:0x0200, B:119:0x020a, B:121:0x020e, B:123:0x0214, B:127:0x022f, B:129:0x0233, B:131:0x0239, B:132:0x023e, B:134:0x0242, B:136:0x0246, B:138:0x024c, B:139:0x0251, B:141:0x0255, B:143:0x025b, B:145:0x025f, B:147:0x0263, B:149:0x0269, B:150:0x026e, B:152:0x0272, B:154:0x0276, B:156:0x027c, B:158:0x0283, B:160:0x0287, B:162:0x028d, B:164:0x0294, B:166:0x0298, B:168:0x029e, B:169:0x02a3, B:171:0x02a7, B:174:0x02af, B:176:0x02b3, B:178:0x02b9, B:181:0x02c3, B:183:0x02c7, B:185:0x02cd, B:189:0x02e8, B:191:0x02ec, B:193:0x02f5, B:195:0x02fe, B:187:0x02d5, B:125:0x021c, B:196:0x030c, B:198:0x0310, B:199:0x0318, B:201:0x031c, B:203:0x0326, B:204:0x0333, B:209:0x0352, B:13:0x0044, B:15:0x0048, B:17:0x0057, B:18:0x0066, B:206:0x034b), top: B:215:0x0016, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x02fe A[Catch: Exception -> 0x036c, TryCatch #0 {Exception -> 0x036c, blocks: (B:3:0x0016, B:6:0x0025, B:9:0x0038, B:11:0x003e, B:19:0x006b, B:21:0x0071, B:25:0x007f, B:27:0x0084, B:29:0x0089, B:31:0x0091, B:34:0x009e, B:37:0x00ac, B:41:0x00ba, B:43:0x00bf, B:45:0x00c6, B:47:0x00cf, B:49:0x00d9, B:51:0x00e2, B:53:0x00f2, B:56:0x00ff, B:59:0x010c, B:62:0x0119, B:65:0x0126, B:67:0x0131, B:69:0x0135, B:71:0x0140, B:73:0x0144, B:76:0x0151, B:79:0x0162, B:82:0x016f, B:85:0x0180, B:86:0x0188, B:88:0x018c, B:90:0x0192, B:95:0x01a4, B:97:0x01af, B:102:0x01bc, B:105:0x01c4, B:106:0x01d5, B:109:0x01ee, B:112:0x01f6, B:114:0x01fa, B:116:0x0200, B:119:0x020a, B:121:0x020e, B:123:0x0214, B:127:0x022f, B:129:0x0233, B:131:0x0239, B:132:0x023e, B:134:0x0242, B:136:0x0246, B:138:0x024c, B:139:0x0251, B:141:0x0255, B:143:0x025b, B:145:0x025f, B:147:0x0263, B:149:0x0269, B:150:0x026e, B:152:0x0272, B:154:0x0276, B:156:0x027c, B:158:0x0283, B:160:0x0287, B:162:0x028d, B:164:0x0294, B:166:0x0298, B:168:0x029e, B:169:0x02a3, B:171:0x02a7, B:174:0x02af, B:176:0x02b3, B:178:0x02b9, B:181:0x02c3, B:183:0x02c7, B:185:0x02cd, B:189:0x02e8, B:191:0x02ec, B:193:0x02f5, B:195:0x02fe, B:187:0x02d5, B:125:0x021c, B:196:0x030c, B:198:0x0310, B:199:0x0318, B:201:0x031c, B:203:0x0326, B:204:0x0333, B:209:0x0352, B:13:0x0044, B:15:0x0048, B:17:0x0057, B:18:0x0066, B:206:0x034b), top: B:215:0x0016, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void addressDailogInner(final android.app.Dialog r20, com.appnew.android.Model.AddressMaster r21) {
        /*
            Method dump skipped, instruction units count: 898
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Payment.InstantPurchase.addressDailogInner(android.app.Dialog, com.appnew.android.Model.AddressMaster):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addressDailogInner$lambda$76(Dialog dialog, View view) {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addressDailogInner$lambda$78(InstantPurchase instantPurchase, View view) {
        List<StatesCitiesData> data;
        StatesCities statesCities = instantPurchase.states;
        if (statesCities == null || (statesCities != null && (data = statesCities.getData()) != null && data.size() == 0)) {
            String string = instantPurchase.getResources().getString(R.string.no_state_available);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            instantPurchase.showMessage(string);
        } else {
            instantPurchase.clicktype = "1";
            StatesCities statesCities2 = instantPurchase.states;
            Intrinsics.checkNotNull(statesCities2);
            instantPurchase.filterList("1", statesCities2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addressDailogInner$lambda$79(InstantPurchase instantPurchase, View view) {
        List<StatesCitiesData> data;
        StatesCities statesCities = instantPurchase.cities;
        if (statesCities == null || (statesCities != null && (data = statesCities.getData()) != null && data.size() == 0)) {
            String string = instantPurchase.getResources().getString(R.string.please_select_state_first);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            instantPurchase.showMessage(string);
        } else {
            instantPurchase.clicktype = "2";
            StatesCities statesCities2 = instantPurchase.cities;
            Intrinsics.checkNotNull(statesCities2);
            instantPurchase.filterList("2", statesCities2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence addressDailogInner$lambda$80(EditText editText, CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (!Intrinsics.areEqual(charSequence, "")) {
            if (!new Regex("[0-9]+").matches(charSequence.toString())) {
                return "";
            }
            if (String.valueOf(editText != null ? editText.getText() : null).length() > 5) {
                return "";
            }
        }
        return charSequence;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addressDailogInner$lambda$101(EditText editText, InstantPurchase instantPurchase, EditText editText2, EditText editText3, EditText editText4, EditText editText5, EditText editText6, EditText editText7, CheckBox checkBox, Dialog dialog, Dialog dialog2, View view) {
        Editable text;
        if (editText != null) {
            try {
                text = editText.getText();
            } catch (Exception e2) {
                Log.d("TAGINSTANTPURCHASE", "Error: " + e2.getMessage());
                return;
            }
        } else {
            text = null;
        }
        String strValueOf = String.valueOf(text);
        int length = strValueOf.length() - 1;
        boolean z = false;
        int i = 0;
        boolean z2 = false;
        while (i <= length) {
            boolean z3 = Intrinsics.compare((int) strValueOf.charAt(!z2 ? i : length), 32) <= 0;
            if (z2) {
                if (!z3) {
                    break;
                } else {
                    length--;
                }
            } else if (z3) {
                i++;
            } else {
                z2 = true;
            }
        }
        if (TextUtils.isEmpty(strValueOf.subSequence(i, length + 1).toString())) {
            String string = instantPurchase.getResources().getString(R.string.name_field_is_required);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            instantPurchase.showMessage(string);
            Unit unit = Unit.INSTANCE;
            return;
        }
        String strValueOf2 = String.valueOf(editText2 != null ? editText2.getText() : null);
        int length2 = strValueOf2.length() - 1;
        int i2 = 0;
        boolean z4 = false;
        while (i2 <= length2) {
            boolean z5 = Intrinsics.compare((int) strValueOf2.charAt(!z4 ? i2 : length2), 32) <= 0;
            if (z4) {
                if (!z5) {
                    break;
                } else {
                    length2--;
                }
            } else if (z5) {
                i2++;
            } else {
                z4 = true;
            }
        }
        if (TextUtils.isEmpty(strValueOf2.subSequence(i2, length2 + 1).toString())) {
            String string2 = instantPurchase.getResources().getString(R.string.mobile_field_is_required);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            instantPurchase.showMessage(string2);
            Unit unit2 = Unit.INSTANCE;
            return;
        }
        String strValueOf3 = String.valueOf(editText2 != null ? editText2.getText() : null);
        int length3 = strValueOf3.length() - 1;
        int i3 = 0;
        boolean z6 = false;
        while (i3 <= length3) {
            boolean z7 = Intrinsics.compare((int) strValueOf3.charAt(!z6 ? i3 : length3), 32) <= 0;
            if (z6) {
                if (!z7) {
                    break;
                } else {
                    length3--;
                }
            } else if (z7) {
                i3++;
            } else {
                z6 = true;
            }
        }
        if (Helper.isInValidIndianMobile(strValueOf3.subSequence(i3, length3 + 1).toString())) {
            String string3 = instantPurchase.getResources().getString(R.string.this_number_is_invalid);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            instantPurchase.showMessage(string3);
            Unit unit3 = Unit.INSTANCE;
            return;
        }
        String strValueOf4 = String.valueOf(editText3 != null ? editText3.getText() : null);
        int length4 = strValueOf4.length() - 1;
        int i4 = 0;
        boolean z8 = false;
        while (i4 <= length4) {
            boolean z9 = Intrinsics.compare((int) strValueOf4.charAt(!z8 ? i4 : length4), 32) <= 0;
            if (z8) {
                if (!z9) {
                    break;
                } else {
                    length4--;
                }
            } else if (z9) {
                i4++;
            } else {
                z8 = true;
            }
        }
        if (TextUtils.isEmpty(strValueOf4.subSequence(i4, length4 + 1).toString())) {
            String string4 = instantPurchase.getResources().getString(R.string.address_field_is_required);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            instantPurchase.showMessage(string4);
            Unit unit4 = Unit.INSTANCE;
            return;
        }
        String strValueOf5 = String.valueOf(editText3 != null ? editText3.getText() : null);
        int length5 = strValueOf5.length() - 1;
        int i5 = 0;
        boolean z10 = false;
        while (i5 <= length5) {
            boolean z11 = Intrinsics.compare((int) strValueOf5.charAt(!z10 ? i5 : length5), 32) <= 0;
            if (z10) {
                if (!z11) {
                    break;
                } else {
                    length5--;
                }
            } else if (z11) {
                i5++;
            } else {
                z10 = true;
            }
        }
        if (strValueOf5.subSequence(i5, length5 + 1).toString().length() <= 5) {
            String string5 = instantPurchase.getResources().getString(R.string.enter_valid_address);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            instantPurchase.showMessage(string5);
            Unit unit5 = Unit.INSTANCE;
            return;
        }
        TextView textView = instantPurchase.statesTV;
        String strValueOf6 = String.valueOf(textView != null ? textView.getText() : null);
        int length6 = strValueOf6.length() - 1;
        int i6 = 0;
        boolean z12 = false;
        while (i6 <= length6) {
            boolean z13 = Intrinsics.compare((int) strValueOf6.charAt(!z12 ? i6 : length6), 32) <= 0;
            if (z12) {
                if (!z13) {
                    break;
                } else {
                    length6--;
                }
            } else if (z13) {
                i6++;
            } else {
                z12 = true;
            }
        }
        if (TextUtils.isEmpty(strValueOf6.subSequence(i6, length6 + 1).toString())) {
            String string6 = instantPurchase.getResources().getString(R.string.state_field_is_required);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            instantPurchase.showMessage(string6);
            Unit unit6 = Unit.INSTANCE;
            return;
        }
        TextView textView2 = instantPurchase.districtTV;
        String strValueOf7 = String.valueOf(textView2 != null ? textView2.getText() : null);
        int length7 = strValueOf7.length() - 1;
        int i7 = 0;
        boolean z14 = false;
        while (i7 <= length7) {
            boolean z15 = Intrinsics.compare((int) strValueOf7.charAt(!z14 ? i7 : length7), 32) <= 0;
            if (z14) {
                if (!z15) {
                    break;
                } else {
                    length7--;
                }
            } else if (z15) {
                i7++;
            } else {
                z14 = true;
            }
        }
        if (TextUtils.isEmpty(strValueOf7.subSequence(i7, length7 + 1).toString())) {
            String string7 = instantPurchase.getResources().getString(R.string.district_field_is_required);
            Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
            instantPurchase.showMessage(string7);
            Unit unit7 = Unit.INSTANCE;
            return;
        }
        String strValueOf8 = String.valueOf(editText4 != null ? editText4.getText() : null);
        int length8 = strValueOf8.length() - 1;
        int i8 = 0;
        boolean z16 = false;
        while (i8 <= length8) {
            boolean z17 = Intrinsics.compare((int) strValueOf8.charAt(!z16 ? i8 : length8), 32) <= 0;
            if (z16) {
                if (!z17) {
                    break;
                } else {
                    length8--;
                }
            } else if (z17) {
                i8++;
            } else {
                z16 = true;
            }
        }
        if (TextUtils.isEmpty(strValueOf8.subSequence(i8, length8 + 1).toString())) {
            String string8 = instantPurchase.getResources().getString(R.string.city_field_is_required);
            Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
            instantPurchase.showMessage(string8);
            Unit unit8 = Unit.INSTANCE;
            return;
        }
        String strValueOf9 = String.valueOf(editText5 != null ? editText5.getText() : null);
        int length9 = strValueOf9.length() - 1;
        int i9 = 0;
        boolean z18 = false;
        while (i9 <= length9) {
            boolean z19 = Intrinsics.compare((int) strValueOf9.charAt(!z18 ? i9 : length9), 32) <= 0;
            if (z18) {
                if (!z19) {
                    break;
                } else {
                    length9--;
                }
            } else if (z19) {
                i9++;
            } else {
                z18 = true;
            }
        }
        if (!TextUtils.isEmpty(strValueOf9.subSequence(i9, length9 + 1).toString())) {
            if (String.valueOf(editText5 != null ? editText5.getText() : null).length() >= 6) {
                if (!StringsKt.startsWith$default(String.valueOf(editText5 != null ? editText5.getText() : null), "0", false, 2, (Object) null)) {
                    if (String.valueOf(editText2 != null ? editText2.getText() : null).length() == 0) {
                        String string9 = instantPurchase.getResources().getString(R.string.mobile_field_is_required);
                        Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
                        instantPurchase.showMessage(string9);
                        Unit unit9 = Unit.INSTANCE;
                        return;
                    }
                    if (!instantPurchase.numberValidation(editText2)) {
                        String string10 = instantPurchase.getResources().getString(R.string.mobile_number_should_be_at_least_10_digits);
                        Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
                        instantPurchase.showMessage(string10);
                        Unit unit10 = Unit.INSTANCE;
                        return;
                    }
                    if (String.valueOf(editText6 != null ? editText6.getText() : null).length() == 0) {
                        String string11 = instantPurchase.getResources().getString(R.string.mobile_field_is_required);
                        Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
                        instantPurchase.showMessage(string11);
                        Unit unit11 = Unit.INSTANCE;
                        return;
                    }
                    if (!instantPurchase.numberValidation(editText6)) {
                        String string12 = instantPurchase.getResources().getString(R.string.mobile_number_should_be_at_least_10_digits);
                        Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
                        instantPurchase.showMessage(string12);
                        Unit unit12 = Unit.INSTANCE;
                        return;
                    }
                    String strValueOf10 = String.valueOf(editText6 != null ? editText6.getText() : null);
                    int length10 = strValueOf10.length() - 1;
                    int i10 = 0;
                    boolean z20 = false;
                    while (i10 <= length10) {
                        boolean z21 = Intrinsics.compare((int) strValueOf10.charAt(!z20 ? i10 : length10), 32) <= 0;
                        if (z20) {
                            if (!z21) {
                                break;
                            } else {
                                length10--;
                            }
                        } else if (z21) {
                            i10++;
                        } else {
                            z20 = true;
                        }
                    }
                    String string13 = strValueOf10.subSequence(i10, length10 + 1).toString();
                    String strValueOf11 = String.valueOf(editText2 != null ? editText2.getText() : null);
                    int length11 = strValueOf11.length() - 1;
                    int i11 = 0;
                    boolean z22 = false;
                    while (i11 <= length11) {
                        boolean z23 = Intrinsics.compare((int) strValueOf11.charAt(!z22 ? i11 : length11), 32) <= 0;
                        if (z22) {
                            if (!z23) {
                                break;
                            } else {
                                length11--;
                            }
                        } else if (z23) {
                            i11++;
                        } else {
                            z22 = true;
                        }
                    }
                    if (Helper.NotBeSameAlternateMobileNumber(string13, strValueOf11.subSequence(i11, length11 + 1).toString())) {
                        String string14 = instantPurchase.getResources().getString(R.string.change_alternate_number);
                        Intrinsics.checkNotNullExpressionValue(string14, "getString(...)");
                        instantPurchase.showMessage(string14);
                        Unit unit13 = Unit.INSTANCE;
                        return;
                    }
                    String strValueOf12 = String.valueOf(editText != null ? editText.getText() : null);
                    int length12 = strValueOf12.length() - 1;
                    int i12 = 0;
                    boolean z24 = false;
                    while (i12 <= length12) {
                        boolean z25 = Intrinsics.compare((int) strValueOf12.charAt(!z24 ? i12 : length12), 32) <= 0;
                        if (z24) {
                            if (!z25) {
                                break;
                            } else {
                                length12--;
                            }
                        } else if (z25) {
                            i12++;
                        } else {
                            z24 = true;
                        }
                    }
                    String string15 = strValueOf12.subSequence(i12, length12 + 1).toString();
                    String strValueOf13 = String.valueOf(editText3 != null ? editText3.getText() : null);
                    int length13 = strValueOf13.length() - 1;
                    int i13 = 0;
                    boolean z26 = false;
                    while (i13 <= length13) {
                        boolean z27 = Intrinsics.compare((int) strValueOf13.charAt(!z26 ? i13 : length13), 32) <= 0;
                        if (z26) {
                            if (!z27) {
                                break;
                            } else {
                                length13--;
                            }
                        } else if (z27) {
                            i13++;
                        } else {
                            z26 = true;
                        }
                    }
                    String string16 = strValueOf13.subSequence(i13, length13 + 1).toString();
                    String strValueOf14 = String.valueOf(editText2 != null ? editText2.getText() : null);
                    int length14 = strValueOf14.length() - 1;
                    int i14 = 0;
                    boolean z28 = false;
                    while (i14 <= length14) {
                        boolean z29 = Intrinsics.compare((int) strValueOf14.charAt(!z28 ? i14 : length14), 32) <= 0;
                        if (z28) {
                            if (!z29) {
                                break;
                            } else {
                                length14--;
                            }
                        } else if (z29) {
                            i14++;
                        } else {
                            z28 = true;
                        }
                    }
                    String string17 = strValueOf14.subSequence(i14, length14 + 1).toString();
                    String strValueOf15 = String.valueOf(editText6 != null ? editText6.getText() : null);
                    int length15 = strValueOf15.length() - 1;
                    int i15 = 0;
                    boolean z30 = false;
                    while (i15 <= length15) {
                        boolean z31 = Intrinsics.compare((int) strValueOf15.charAt(!z30 ? i15 : length15), 32) <= 0;
                        if (z30) {
                            if (!z31) {
                                break;
                            } else {
                                length15--;
                            }
                        } else if (z31) {
                            i15++;
                        } else {
                            z30 = true;
                        }
                    }
                    String string18 = strValueOf15.subSequence(i15, length15 + 1).toString();
                    TextView textView3 = instantPurchase.statesTV;
                    String strValueOf16 = String.valueOf(textView3 != null ? textView3.getText() : null);
                    int length16 = strValueOf16.length() - 1;
                    int i16 = 0;
                    boolean z32 = false;
                    while (i16 <= length16) {
                        boolean z33 = Intrinsics.compare((int) strValueOf16.charAt(!z32 ? i16 : length16), 32) <= 0;
                        if (z32) {
                            if (!z33) {
                                break;
                            } else {
                                length16--;
                            }
                        } else if (z33) {
                            i16++;
                        } else {
                            z32 = true;
                        }
                    }
                    String string19 = strValueOf16.subSequence(i16, length16 + 1).toString();
                    TextView textView4 = instantPurchase.districtTV;
                    String strValueOf17 = String.valueOf(textView4 != null ? textView4.getText() : null);
                    int length17 = strValueOf17.length() - 1;
                    int i17 = 0;
                    boolean z34 = false;
                    while (i17 <= length17) {
                        boolean z35 = Intrinsics.compare((int) strValueOf17.charAt(!z34 ? i17 : length17), 32) <= 0;
                        if (z34) {
                            if (!z35) {
                                break;
                            } else {
                                length17--;
                            }
                        } else if (z35) {
                            i17++;
                        } else {
                            z34 = true;
                        }
                    }
                    String string20 = strValueOf17.subSequence(i17, length17 + 1).toString();
                    String strValueOf18 = String.valueOf(editText4 != null ? editText4.getText() : null);
                    int length18 = strValueOf18.length() - 1;
                    int i18 = 0;
                    boolean z36 = false;
                    while (i18 <= length18) {
                        boolean z37 = Intrinsics.compare((int) strValueOf18.charAt(!z36 ? i18 : length18), 32) <= 0;
                        if (z36) {
                            if (!z37) {
                                break;
                            } else {
                                length18--;
                            }
                        } else if (z37) {
                            i18++;
                        } else {
                            z36 = true;
                        }
                    }
                    String string21 = strValueOf18.subSequence(i18, length18 + 1).toString();
                    String strValueOf19 = String.valueOf(editText5 != null ? editText5.getText() : null);
                    int length19 = strValueOf19.length() - 1;
                    int i19 = 0;
                    boolean z38 = false;
                    while (i19 <= length19) {
                        boolean z39 = Intrinsics.compare((int) strValueOf19.charAt(!z38 ? i19 : length19), 32) <= 0;
                        if (z38) {
                            if (!z39) {
                                break;
                            } else {
                                length19--;
                            }
                        } else if (z39) {
                            i19++;
                        } else {
                            z38 = true;
                        }
                    }
                    String string22 = strValueOf19.subSequence(i19, length19 + 1).toString();
                    String strValueOf20 = String.valueOf(editText7 != null ? editText7.getText() : null);
                    int length20 = strValueOf20.length() - 1;
                    int i20 = 0;
                    boolean z40 = false;
                    while (i20 <= length20) {
                        boolean z41 = Intrinsics.compare((int) strValueOf20.charAt(!z40 ? i20 : length20), 32) <= 0;
                        if (z40) {
                            if (!z41) {
                                break;
                            } else {
                                length20--;
                            }
                        } else if (z41) {
                            i20++;
                        } else {
                            z40 = true;
                        }
                    }
                    String string23 = strValueOf20.subSequence(i20, length20 + 1).toString();
                    if (checkBox != null && checkBox.isChecked()) {
                        z = true;
                    }
                    instantPurchase.isDefault = z;
                    instantPurchase.address1 = new Address(string15, string16, string19, string21, string17, string18, string22, string23, string20, instantPurchase.SelectedStateid);
                    instantPurchase.addressJson = new Gson().toJson(instantPurchase.address1);
                    instantPurchase.isAddressEdited = true;
                    dialog.dismiss();
                    instantPurchase.hitApiForSavingAddress();
                    if (dialog2 != null) {
                        dialog2.dismiss();
                        Unit unit14 = Unit.INSTANCE;
                        return;
                    }
                    return;
                }
            }
        }
        String string24 = instantPurchase.getResources().getString(R.string.enter_valid_pin_code);
        Intrinsics.checkNotNullExpressionValue(string24, "getString(...)");
        instantPurchase.showMessage(string24);
        Unit unit15 = Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v3, types: [kotlin.Unit] */
    private final void getSavedAddressDailog() {
        StatesCities statesCities;
        List<StatesCitiesData> data;
        String str = "TAGINSTANTPURCHASE";
        try {
        } catch (Exception e2) {
            Log.d(str, "Error: " + e2.getMessage());
        }
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        StatesCities statesCities2 = this.cities;
        if (statesCities2 != null) {
            if ((statesCities2 != null ? statesCities2.getData() : null) != null && (statesCities = this.cities) != null && (data = statesCities.getData()) != null) {
                data.clear();
            }
        }
        Context context = getContext();
        Dialog dialog = context != null ? new Dialog(context, R.style.address) : null;
        this.dialogGettingSavedAddress = dialog;
        if (dialog != null) {
            dialog.setCancelable(true);
        }
        Dialog dialog2 = this.dialogGettingSavedAddress;
        if (dialog2 != null) {
            dialog2.requestWindowFeature(1);
        }
        Dialog dialog3 = this.dialogGettingSavedAddress;
        if (dialog3 != null) {
            dialog3.setContentView(R.layout.add_address_layout_theme_2);
        }
        Dialog dialog4 = this.dialogGettingSavedAddress;
        RelativeLayout relativeLayout = dialog4 != null ? (RelativeLayout) dialog4.findViewById(R.id.subRL) : null;
        Dialog dialog5 = this.dialogGettingSavedAddress;
        RelativeLayout relativeLayout2 = dialog5 != null ? (RelativeLayout) dialog5.findViewById(R.id.addAddressLayout) : null;
        if (relativeLayout2 != null) {
            relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.InstantPurchase$$ExternalSyntheticLambda45
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InstantPurchase.getSavedAddressDailog$lambda$103(this.f$0, view);
                }
            });
        }
        Dialog dialog6 = this.dialogGettingSavedAddress;
        ScrollView scrollView = dialog6 != null ? (ScrollView) dialog6.findViewById(R.id.main_rl) : null;
        if (scrollView != null) {
            scrollView.setVisibility(8);
        }
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        Dialog dialog7 = this.dialogGettingSavedAddress;
        View viewFindViewById = dialog7 != null ? dialog7.findViewById(R.id.saveAddress) : null;
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.Button");
        Button button = (Button) viewFindViewById;
        Dialog dialog8 = this.dialogGettingSavedAddress;
        View viewFindViewById2 = dialog8 != null ? dialog8.findViewById(R.id.toolbarTitleTV) : null;
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) viewFindViewById2).setText("Select Address");
        Dialog dialog9 = this.dialogGettingSavedAddress;
        EditText editText = dialog9 != null ? (EditText) dialog9.findViewById(R.id.nameTV) : null;
        Dialog dialog10 = this.dialogGettingSavedAddress;
        this.recyclerViewSavedAddress = dialog10 != null ? (RecyclerView) dialog10.findViewById(R.id.recyclerViewSavedAddress) : null;
        Dialog dialog11 = this.dialogGettingSavedAddress;
        this.statesTV = dialog11 != null ? (TextView) dialog11.findViewById(R.id.stateTV) : null;
        Dialog dialog12 = this.dialogGettingSavedAddress;
        this.districtTV = dialog12 != null ? (TextView) dialog12.findViewById(R.id.districtTV) : null;
        Dialog dialog13 = this.dialogGettingSavedAddress;
        ImageView imageView = dialog13 != null ? (ImageView) dialog13.findViewById(R.id.image_back) : null;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.InstantPurchase$$ExternalSyntheticLambda46
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InstantPurchase.getSavedAddressDailog$lambda$104(this.f$0, view);
                }
            });
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.InstantPurchase$$ExternalSyntheticLambda47
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InstantPurchase.getSavedAddressDailog$lambda$105(this.f$0, view);
            }
        });
        LeftMenu leftMenu = this.leftMenu;
        if (leftMenu != null) {
            String disable_name_edit = leftMenu.getDisable_name_edit();
            String string = disable_name_edit != null ? StringsKt.trim((CharSequence) disable_name_edit).toString() : null;
            if (string == null) {
                string = "";
            }
            if (editText != null) {
                editText.setEnabled(StringsKt.equals(string, "0", true) || string.length() == 0);
            }
        }
        if (editText != null) {
            editText.setText(SharedPreference.getInstance().getLoggedInUser().getName());
        }
        if (StringsKt.equals(this.isBook, "1", true) || isComboBook()) {
            this.isFirstTime = false;
            hitApiForGettingAddress();
        }
        try {
            Dialog dialog14 = this.dialogGettingSavedAddress;
            if (dialog14 != null) {
                dialog14.show();
                str = Unit.INSTANCE;
                return;
            }
            return;
        } catch (Exception e3) {
            Integer.valueOf(Log.d("TAGINSTANTPURCHASE", "Error: " + e3.getMessage()));
            return;
        }
        Log.d(str, "Error: " + e2.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSavedAddressDailog$lambda$103(InstantPurchase instantPurchase, View view) {
        Dialog dialog = instantPurchase.dialogGettingSavedAddress;
        Intrinsics.checkNotNull(dialog);
        instantPurchase.addressDailog(dialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSavedAddressDailog$lambda$104(InstantPurchase instantPurchase, View view) {
        Dialog dialog = instantPurchase.dialogGettingSavedAddress;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSavedAddressDailog$lambda$105(InstantPurchase instantPurchase, View view) {
        Dialog dialog = instantPurchase.dialogGettingSavedAddress;
        if (dialog != null) {
            dialog.dismiss();
        }
        Iterator<AddressMaster> it = instantPurchase.addressListMaster.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            AddressMaster next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            AddressMaster addressMaster = next;
            if (addressMaster.isChecked()) {
                instantPurchase.addressMaster = addressMaster;
            }
        }
        AddressMaster addressMaster2 = instantPurchase.addressMaster;
        Intrinsics.checkNotNull(addressMaster2);
        instantPurchase.getAddressDetail(addressMaster2);
    }

    public final void filterList(String searchType, StatesCities countryArrayList) {
        EditText editText;
        Window window;
        WindowManager.LayoutParams attributes;
        Window window2;
        Intrinsics.checkNotNullParameter(searchType, "searchType");
        Intrinsics.checkNotNullParameter(countryArrayList, "countryArrayList");
        Context context = getContext();
        final Dialog dialog = context != null ? new Dialog(context) : null;
        if (dialog != null) {
            dialog.requestWindowFeature(1);
        }
        if (dialog != null && (window2 = dialog.getWindow()) != null) {
            window2.setBackgroundDrawable(new ColorDrawable(0));
        }
        if (dialog != null && (window = dialog.getWindow()) != null && (attributes = window.getAttributes()) != null) {
            attributes.windowAnimations = R.style.DialogTheme;
        }
        if (dialog != null) {
            dialog.setContentView(R.layout.state_city_dialog);
        }
        if (dialog != null) {
            dialog.setCancelable(true);
        }
        this.etSearch = dialog != null ? (EditText) dialog.findViewById(R.id.et_search) : null;
        if (StringsKt.equals(searchType, "1", true)) {
            EditText editText2 = this.etSearch;
            if (editText2 != null) {
                editText2.setHint(getResources().getString(R.string.search_state));
            }
        } else if (StringsKt.equals(searchType, "2", true)) {
            EditText editText3 = this.etSearch;
            if (editText3 != null) {
                editText3.setHint(getResources().getString(R.string.search_district));
            }
        } else if (StringsKt.equals(searchType, "3", true) && (editText = this.etSearch) != null) {
            editText.setHint(getResources().getString(R.string.search_country));
        }
        this.ivClearSearch = dialog != null ? (ImageView) dialog.findViewById(R.id.iv_clear_search) : null;
        TextView textView = dialog != null ? (TextView) dialog.findViewById(R.id.tv_cancel) : null;
        ImageView imageView = this.ivClearSearch;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.InstantPurchase$$ExternalSyntheticLambda52
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InstantPurchase.filterList$lambda$108(this.f$0, view);
                }
            });
        }
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.InstantPurchase$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InstantPurchase.filterList$lambda$109(dialog, view);
                }
            });
        }
        RecyclerView recyclerView = dialog != null ? (RecyclerView) dialog.findViewById(R.id.search_recyclerview) : null;
        this.searchRecyclerview = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
        }
        RecyclerView recyclerView2 = this.searchRecyclerview;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        List<StatesCitiesData> data = countryArrayList.getData();
        Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
        StateCityAdapter stateCityAdapter = new StateCityAdapter(fragmentActivityRequireActivity, data, searchType, dialog, new AnonymousClass3(this));
        this.stateCityAdapter = stateCityAdapter;
        RecyclerView recyclerView3 = this.searchRecyclerview;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(stateCityAdapter);
        }
        textWatcher(searchType);
        if (dialog != null) {
            dialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void filterList$lambda$108(InstantPurchase instantPurchase, View view) {
        EditText editText = instantPurchase.etSearch;
        if (editText != null) {
            editText.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void filterList$lambda$109(Dialog dialog, View view) {
        if (dialog != null) {
            dialog.cancel();
        }
    }

    /* JADX INFO: renamed from: com.appnew.android.Payment.InstantPurchase$filterList$3, reason: invalid class name */
    /* JADX INFO: compiled from: InstantPurchase.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function2<String, StatesCitiesData, Unit> {
        AnonymousClass3(Object obj) {
            super(2, obj, InstantPurchase.class, "onStateCityClick", "onStateCityClick(Ljava/lang/String;Lcom/appnew/android/pojo/Userinfo/StatesCities/StatesCitiesData;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(String str, StatesCitiesData statesCitiesData) {
            invoke2(str, statesCitiesData);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String p0, StatesCitiesData p1) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            ((InstantPurchase) this.receiver).onStateCityClick(p0, p1);
        }
    }

    public final void textWatcher(final String searchType) {
        Intrinsics.checkNotNullParameter(searchType, "searchType");
        EditText editText = this.etSearch;
        Intrinsics.checkNotNull(editText);
        editText.addTextChangedListener(new TextWatcher() { // from class: com.appnew.android.Payment.InstantPurchase.textWatcher.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Intrinsics.checkNotNullParameter(charSequence, "charSequence");
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Intrinsics.checkNotNullParameter(charSequence, "charSequence");
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                Intrinsics.checkNotNullParameter(editable, "editable");
                if (editable.length() > 0) {
                    ImageView ivClearSearch = InstantPurchase.this.getIvClearSearch();
                    Intrinsics.checkNotNull(ivClearSearch);
                    ivClearSearch.setVisibility(0);
                } else {
                    ImageView ivClearSearch2 = InstantPurchase.this.getIvClearSearch();
                    Intrinsics.checkNotNull(ivClearSearch2);
                    ivClearSearch2.setVisibility(8);
                }
                InstantPurchase.this.filter(editable.toString(), searchType);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void filter(String text, String searchType) {
        this.statesCitiesArrayList.clear();
        if (StringsKt.equals(searchType, "1", true)) {
            StatesCities statesCities = this.states;
            Intrinsics.checkNotNull(statesCities);
            for (StatesCitiesData statesCitiesData : statesCities.getData()) {
                String name = statesCitiesData.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                String lowerCase = name.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                Locale locale2 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
                String lowerCase2 = text.toLowerCase(locale2);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) lowerCase2, false, 2, (Object) null)) {
                    this.statesCitiesArrayList.add(statesCitiesData);
                }
            }
        } else if (StringsKt.equals(searchType, "2", true)) {
            StatesCities statesCities2 = this.cities;
            Intrinsics.checkNotNull(statesCities2);
            for (StatesCitiesData statesCitiesData2 : statesCities2.getData()) {
                String name2 = statesCitiesData2.getName();
                Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                Locale locale3 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale3, "getDefault(...)");
                String lowerCase3 = name2.toLowerCase(locale3);
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                Locale locale4 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale4, "getDefault(...)");
                String lowerCase4 = text.toLowerCase(locale4);
                Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                if (StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) lowerCase4, false, 2, (Object) null)) {
                    this.statesCitiesArrayList.add(statesCitiesData2);
                }
            }
        }
        if (!this.statesCitiesArrayList.isEmpty()) {
            RecyclerView recyclerView = this.searchRecyclerview;
            Intrinsics.checkNotNull(recyclerView);
            recyclerView.setVisibility(0);
            StateCityAdapter stateCityAdapter = this.stateCityAdapter;
            Intrinsics.checkNotNull(stateCityAdapter);
            stateCityAdapter.filterCountryList(this.statesCitiesArrayList);
            return;
        }
        RecyclerView recyclerView2 = this.searchRecyclerview;
        Intrinsics.checkNotNull(recyclerView2);
        recyclerView2.setVisibility(4);
    }

    /* JADX INFO: compiled from: InstantPurchase.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u000e\u0012\n\u0012\b\u0018\u00010\u0002R\u00020\u00000\u0001:\u0001/BI\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\u001c\u0010*\u001a\u00020\u000e2\n\u0010+\u001a\u00060\u0002R\u00020\u00002\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010,\u001a\u00020)H\u0016J\u0014\u0010-\u001a\u00020\u000e2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R,\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e0\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u00060"}, d2 = {"Lcom/appnew/android/Payment/InstantPurchase$StateCityAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/Payment/InstantPurchase$StateCityAdapter$MyViewHolder;", "context", "Landroid/content/Context;", "countryArrayList", "", "Lcom/appnew/android/pojo/Userinfo/StatesCities/StatesCitiesData;", "searchType", "", "searchDialog", "Landroid/app/Dialog;", "onStateCityClick", "Lkotlin/Function2;", "", "<init>", "(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;Landroid/app/Dialog;Lkotlin/jvm/functions/Function2;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getCountryArrayList", "()Ljava/util/List;", "setCountryArrayList", "(Ljava/util/List;)V", "getSearchType", "()Ljava/lang/String;", "setSearchType", "(Ljava/lang/String;)V", "getSearchDialog", "()Landroid/app/Dialog;", "setSearchDialog", "(Landroid/app/Dialog;)V", "getOnStateCityClick", "()Lkotlin/jvm/functions/Function2;", "setOnStateCityClick", "(Lkotlin/jvm/functions/Function2;)V", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", CmcdData.Factory.OBJECT_TYPE_INIT_SEGMENT, "", "onBindViewHolder", "myViewHolder", "getItemCount", "filterCountryList", "newCountryArrayList", "MyViewHolder", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class StateCityAdapter extends RecyclerView.Adapter<MyViewHolder> {
        public static final int $stable = 8;
        private Context context;
        private List<? extends StatesCitiesData> countryArrayList;
        private Function2<? super String, ? super StatesCitiesData, Unit> onStateCityClick;
        private Dialog searchDialog;
        private String searchType;

        public final Context getContext() {
            return this.context;
        }

        public final void setContext(Context context) {
            Intrinsics.checkNotNullParameter(context, "<set-?>");
            this.context = context;
        }

        public final List<StatesCitiesData> getCountryArrayList() {
            return this.countryArrayList;
        }

        public final void setCountryArrayList(List<? extends StatesCitiesData> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.countryArrayList = list;
        }

        public final String getSearchType() {
            return this.searchType;
        }

        public final void setSearchType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.searchType = str;
        }

        public final Dialog getSearchDialog() {
            return this.searchDialog;
        }

        public final void setSearchDialog(Dialog dialog) {
            this.searchDialog = dialog;
        }

        public final Function2<String, StatesCitiesData, Unit> getOnStateCityClick() {
            return this.onStateCityClick;
        }

        public final void setOnStateCityClick(Function2<? super String, ? super StatesCitiesData, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "<set-?>");
            this.onStateCityClick = function2;
        }

        public StateCityAdapter(Context context, List<? extends StatesCitiesData> countryArrayList, String searchType, Dialog dialog, Function2<? super String, ? super StatesCitiesData, Unit> onStateCityClick) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(countryArrayList, "countryArrayList");
            Intrinsics.checkNotNullParameter(searchType, "searchType");
            Intrinsics.checkNotNullParameter(onStateCityClick, "onStateCityClick");
            this.context = context;
            this.countryArrayList = countryArrayList;
            this.searchType = searchType;
            this.searchDialog = dialog;
            this.onStateCityClick = onStateCityClick;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.state_city_dialog_adapter_item, viewGroup, false);
            Intrinsics.checkNotNull(viewInflate);
            return new MyViewHolder(this, viewInflate);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
            Intrinsics.checkNotNullParameter(myViewHolder, "myViewHolder");
            final StatesCitiesData statesCitiesData = this.countryArrayList.get(i);
            myViewHolder.getTvName().setText(statesCitiesData.getName());
            myViewHolder.getTvName().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.InstantPurchase$StateCityAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InstantPurchase.StateCityAdapter.onBindViewHolder$lambda$0(this.f$0, statesCitiesData, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public static final void onBindViewHolder$lambda$0(StateCityAdapter stateCityAdapter, StatesCitiesData statesCitiesData, View view) {
            Dialog dialog = stateCityAdapter.searchDialog;
            if (dialog != null) {
                Intrinsics.checkNotNull(dialog);
                dialog.dismiss();
            }
            String str = stateCityAdapter.searchType;
            switch (str.hashCode()) {
                case 49:
                    if (str.equals("1")) {
                        stateCityAdapter.onStateCityClick.invoke(stateCityAdapter.searchType, statesCitiesData);
                        break;
                    }
                    break;
                case 50:
                    if (str.equals("2")) {
                        stateCityAdapter.onStateCityClick.invoke(stateCityAdapter.searchType, statesCitiesData);
                        break;
                    }
                    break;
                case 51:
                    if (str.equals("3")) {
                        stateCityAdapter.onStateCityClick.invoke(stateCityAdapter.searchType, statesCitiesData);
                        break;
                    }
                    break;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.countryArrayList.size();
        }

        public final void filterCountryList(List<? extends StatesCitiesData> newCountryArrayList) {
            Intrinsics.checkNotNullParameter(newCountryArrayList, "newCountryArrayList");
            this.countryArrayList = newCountryArrayList;
            notifyDataSetChanged();
        }

        /* JADX INFO: compiled from: InstantPurchase.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/appnew/android/Payment/InstantPurchase$StateCityAdapter$MyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/appnew/android/Payment/InstantPurchase$StateCityAdapter;Landroid/view/View;)V", "tvName", "Landroid/widget/TextView;", "getTvName", "()Landroid/widget/TextView;", "setTvName", "(Landroid/widget/TextView;)V", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public final class MyViewHolder extends RecyclerView.ViewHolder {
            final /* synthetic */ StateCityAdapter this$0;
            private TextView tvName;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public MyViewHolder(StateCityAdapter stateCityAdapter, View itemView) {
                super(itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.this$0 = stateCityAdapter;
                View viewFindViewById = itemView.findViewById(R.id.nameTv);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                this.tvName = (TextView) viewFindViewById;
            }

            public final TextView getTvName() {
                return this.tvName;
            }

            public final void setTvName(TextView textView) {
                Intrinsics.checkNotNullParameter(textView, "<set-?>");
                this.tvName = textView;
            }
        }
    }

    public final void onStateCityClick(String searchType, StatesCitiesData country) {
        Intrinsics.checkNotNullParameter(searchType, "searchType");
        Intrinsics.checkNotNullParameter(country, "country");
        if (StringsKt.equals(searchType, "1", true)) {
            StatesCities statesCities = this.states;
            Intrinsics.checkNotNull(statesCities);
            for (StatesCitiesData statesCitiesData : statesCities.getData()) {
                if (Intrinsics.areEqual(statesCitiesData.getName(), country.getName())) {
                    this.stateindex = country.getName();
                    this.SelectedStateid = statesCitiesData.getId();
                    TextView textView = this.statesTV;
                    Intrinsics.checkNotNull(textView);
                    textView.setText(country.getName());
                    TextView textView2 = this.districtTV;
                    Intrinsics.checkNotNull(textView2);
                    textView2.setText("");
                    hit_api_to_get_city();
                    return;
                }
            }
            return;
        }
        if (StringsKt.equals(searchType, "2", true)) {
            StatesCities statesCities2 = this.cities;
            Intrinsics.checkNotNull(statesCities2);
            for (StatesCitiesData statesCitiesData2 : statesCities2.getData()) {
                if (Intrinsics.areEqual(statesCitiesData2.getName(), country.getName())) {
                    this.cityindex = country.getName();
                    this.SelectedCityid = statesCitiesData2.getId();
                    TextView textView3 = this.districtTV;
                    Intrinsics.checkNotNull(textView3);
                    textView3.setText(country.getName());
                    return;
                }
            }
        }
    }

    public final void deleteAddress(final ArrayList<AddressMaster> addressMasterListNew, final AddressAdapter addressAdapterNew, final int addressPositionNew) {
        Intrinsics.checkNotNullParameter(addressMasterListNew, "addressMasterListNew");
        Intrinsics.checkNotNullParameter(addressAdapterNew, "addressAdapterNew");
        DialogUtils.makeDialog(getActivity(), "Delete", "Are you sure?", getResources().getString(R.string.yes), getResources().getString(R.string.no), true, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Payment.InstantPurchase$$ExternalSyntheticLambda42
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
            public final void onOKClick() {
                InstantPurchase.deleteAddress$lambda$110(addressMasterListNew, addressPositionNew, this, addressAdapterNew);
            }
        }, new DialogUtils.onDialogUtilsCancelClick() { // from class: com.appnew.android.Payment.InstantPurchase$$ExternalSyntheticLambda43
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsCancelClick
            public final void onCancelClick() {
                InstantPurchase.deleteAddress$lambda$111();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteAddress$lambda$110(ArrayList arrayList, int i, InstantPurchase instantPurchase, AddressAdapter addressAdapter) {
        Object obj = arrayList.get(i);
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        instantPurchase.addressAdapter = addressAdapter;
        instantPurchase.addressListMaster = arrayList;
        instantPurchase.addressId = ((AddressMaster) obj).getId();
        instantPurchase.addressPosition = i;
        NetworkCall networkCall = instantPurchase.networkCall;
        Intrinsics.checkNotNull(networkCall);
        networkCall.NetworkAPICall(API.DELETE_USER_ADDRESS, "", false, false);
    }

    @Override // com.appnew.android.Payment.OnAddressAddDeleteClicked
    public void onAddAddressClicked(Dialog dialog, AddressMaster addressMaster) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(addressMaster, "addressMaster");
        addressDailogInner(dialog, addressMaster);
    }

    @Override // com.appnew.android.Payment.OnAddressAddDeleteClicked
    public void onDeleteAddressClicked(ArrayList<AddressMaster> addressMasterList, AddressAdapter addressAdapter, int adapterPosition) {
        Intrinsics.checkNotNullParameter(addressMasterList, "addressMasterList");
        Intrinsics.checkNotNullParameter(addressAdapter, "addressAdapter");
        deleteAddress(addressMasterList, addressAdapter, adapterPosition);
    }

    private final void hit_api_to_get_state() {
        NetworkCall networkCall = this.networkCall;
        Intrinsics.checkNotNull(networkCall);
        networkCall.NetworkAPICall(API.API_STATE, "", false, false);
    }

    private final void hitApiForGettingAddress() {
        NetworkCall networkCall = this.networkCall;
        Intrinsics.checkNotNull(networkCall);
        networkCall.NetworkAPICall(API.GET_USER_ADDRESS, "", false, false);
    }

    public final void hitApiForGettingAddress(boolean isFirstTime) {
        this.isFirstTime = isFirstTime;
        NetworkCall networkCall = this.networkCall;
        Intrinsics.checkNotNull(networkCall);
        networkCall.NetworkAPICall(API.GET_USER_ADDRESS, "", false, false);
    }

    private final void hitApiForSavingAddress() {
        NetworkCall networkCall = this.networkCall;
        Intrinsics.checkNotNull(networkCall);
        networkCall.NetworkAPICall(API.SAVE_USER_ADDRESS, "", false, false);
    }

    private final void hit_api_to_get_city() {
        NetworkCall networkCall = this.networkCall;
        Intrinsics.checkNotNull(networkCall);
        networkCall.NetworkAPICall(API.API_CITY, "", false, false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        Data data;
        CourseDetailData courseDetail;
        Data data2;
        CourseDetailData courseDetail2;
        Data data3;
        CourseDetailData courseDetail3;
        Data data4;
        CourseDetailData courseDetail4;
        Data data5;
        CourseDetailData courseDetail5;
        Intrinsics.checkNotNullParameter(service, "service");
        String id = null;
        if (apitype != null) {
            switch (apitype.hashCode()) {
                case -1913965346:
                    if (apitype.equals(API.verifyCoupon)) {
                        EncryptionData encryptionData = new EncryptionData();
                        CourseDetail courseDetail6 = this.courseDetail;
                        if (courseDetail6 != null && (data = courseDetail6.getData()) != null && (courseDetail = data.getCourseDetail()) != null) {
                            id = courseDetail.getId();
                        }
                        encryptionData.setCourse_id(id);
                        encryptionData.setCoupon_code(this.appliedCouponCode);
                        encryptionData.setExternal_coupon(this.secondCouponCode);
                        encryptionData.setPayment_mode(this.paymentModeValue);
                        String json = new Gson().toJson(encryptionData);
                        Log.d("TAGverifyCoupon", "Param: " + json);
                        return service.verifyCoupon(AES.encrypt(json));
                    }
                    break;
                case -1421483953:
                    if (apitype.equals(API.GET_PRODUCT_ID)) {
                        EncryptionData encryptionData2 = new EncryptionData();
                        CourseDetail courseDetail7 = this.courseDetail;
                        if (courseDetail7 != null && (data2 = courseDetail7.getData()) != null && (courseDetail2 = data2.getCourseDetail()) != null) {
                            id = courseDetail2.getId();
                        }
                        encryptionData2.setCourse_id(id);
                        return service.GET_PRODUCT_ID(AES.encrypt(new Gson().toJson(encryptionData2)));
                    }
                    break;
                case -1273565488:
                    if (apitype.equals(API.DELETE_USER_ADDRESS)) {
                        EncryptionData encryptionData3 = new EncryptionData();
                        encryptionData3.setAddress(this.addressJson);
                        encryptionData3.setId(this.addressId);
                        return service.DELETE_USER_ADDRESS(AES.encrypt(new Gson().toJson(encryptionData3)));
                    }
                    break;
                case -1064760819:
                    if (apitype.equals(API.GET_USER_ADDRESS)) {
                        return service.GET_USER_ADDRESS(AES.encrypt(new Gson().toJson(new EncryptionData())));
                    }
                    break;
                case -787266248:
                    if (apitype.equals(API.API_CITY)) {
                        EncryptionData encryptionData4 = new EncryptionData();
                        encryptionData4.setState_id(this.SelectedStateid);
                        return service.GetCity(AES.encrypt(new Gson().toJson(encryptionData4)));
                    }
                    break;
                case -435982236:
                    if (apitype.equals(API.GET_COUPON_OVER_COURSE)) {
                        EncryptionData encryptionData5 = new EncryptionData();
                        CourseDetail courseDetail8 = this.courseDetail;
                        if (courseDetail8 != null && (data3 = courseDetail8.getData()) != null && (courseDetail3 = data3.getCourseDetail()) != null) {
                            id = courseDetail3.getId();
                        }
                        encryptionData5.setCourse_id(id);
                        encryptionData5.setParent_id(SingleStudy.parentCourseId);
                        return service.GET_COUPON_OVER_COURSE(AES.encrypt(new Gson().toJson(encryptionData5)));
                    }
                    break;
                case -319596559:
                    if (apitype.equals(API.API_STATE)) {
                        EncryptionData encryptionData6 = new EncryptionData();
                        encryptionData6.setCountry_id("");
                        return service.GetState(AES.encrypt(new Gson().toJson(encryptionData6)));
                    }
                    break;
                case -185124491:
                    if (apitype.equals(API.IN_APP_PURCHASE)) {
                        EncryptionData encryptionData7 = new EncryptionData();
                        CourseDetail courseDetail9 = this.courseDetail;
                        encryptionData7.setCourse_id((courseDetail9 == null || (data5 = courseDetail9.getData()) == null || (courseDetail5 = data5.getCourseDetail()) == null) ? null : courseDetail5.getId());
                        CourseDetail courseDetail10 = this.courseDetail;
                        if (courseDetail10 != null && (data4 = courseDetail10.getData()) != null && (courseDetail4 = data4.getCourseDetail()) != null) {
                            id = courseDetail4.getMrp();
                        }
                        encryptionData7.setCourse_price(id);
                        encryptionData7.setProduct_id(this.product_id);
                        return service.IN_APP_PURCHASE(AES.encrypt(new Gson().toJson(encryptionData7)));
                    }
                    break;
                case 114126311:
                    if (apitype.equals("https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction")) {
                        if (getBinding().couponAppliedCV.isShown()) {
                            EncryptionData encryptionData8 = new EncryptionData();
                            encryptionData8.setCourse_id(this.coursesCoupon.getId());
                            encryptionData8.setCoupon_applied(this.coursesCoupon.getCoupon().getId());
                            encryptionData8.setParent_id("0");
                            return service.free_transaction(AES.encrypt(new Gson().toJson(encryptionData8)));
                        }
                        EncryptionData encryptionData9 = new EncryptionData();
                        CourseDetail courseDetail11 = this.courseDetail;
                        Intrinsics.checkNotNull(courseDetail11);
                        encryptionData9.setCourse_id(courseDetail11.getData().getCourseDetail().getId());
                        encryptionData9.setCoupon_applied(this.coupon_applied);
                        encryptionData9.setParent_id(SingleStudy.parentCourseId);
                        return service.free_transaction(AES.encrypt(new Gson().toJson(encryptionData9)));
                    }
                    break;
                case 1334579443:
                    if (apitype.equals(API.COURSE_CART_COUNT)) {
                        EncryptionData encryptionData10 = new EncryptionData();
                        encryptionData10.setUser_id(SharedPreference.getInstance().getLoggedInUser().getId());
                        return service.getCartCount(AES.encrypt(new Gson().toJson(encryptionData10)));
                    }
                    break;
                case 1741920054:
                    if (apitype.equals(API.GET_ADMIT_CARD_URL)) {
                        EncryptionData encryptionData11 = new EncryptionData();
                        encryptionData11.setTxn_id(this.pos_txn_id);
                        return service.getAdmitCardUrl(AES.encrypt(new Gson().toJson(encryptionData11)));
                    }
                    break;
                case 1878529854:
                    if (apitype.equals(API.SAVE_USER_ADDRESS)) {
                        EncryptionData encryptionData12 = new EncryptionData();
                        encryptionData12.setAddress(this.addressJson);
                        if (this.isAddressEdited) {
                            AddressMaster addressMaster = this.addressMaster;
                            Intrinsics.checkNotNull(addressMaster);
                            encryptionData12.setId(addressMaster.getId());
                        }
                        encryptionData12.setIs_default(this.isDefault ? "1" : "0");
                        return service.SAVE_USER_ADDRESS(AES.encrypt(new Gson().toJson(encryptionData12)));
                    }
                    break;
                case 2002393681:
                    if (apitype.equals(API.int_payment)) {
                        return this.isfailure ? service.int_payment(callApiIntPaymentOnFailure()) : StringsKt.equals(this.pos_txn_id, "", true) ? service.int_payment(callApiIntPayment()) : service.int_payment(callApiIntPaymentOnSuccess());
                    }
                    break;
            }
        }
        return null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:197:0x048e  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x067b  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x07fc  */
    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void SuccessCallBack(org.json.JSONObject r20, java.lang.String r21, java.lang.String r22, boolean r23) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 2726
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Payment.InstantPurchase.SuccessCallBack(org.json.JSONObject, java.lang.String, java.lang.String, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SuccessCallBack$lambda$112(InstantPurchase instantPurchase) {
        Iterator<AddressMaster> it = instantPurchase.addressListMaster.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        boolean z = false;
        while (it.hasNext()) {
            AddressMaster next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            AddressMaster addressMaster = next;
            if (StringsKt.equals(addressMaster.getIs_default(), "1", true)) {
                addressMaster.setChecked(true);
                instantPurchase.getAddressDetail(addressMaster);
                z = true;
            }
        }
        if (z) {
            return;
        }
        instantPurchase.addressListMaster.get(0).setChecked(true);
        AddressMaster addressMaster2 = instantPurchase.addressListMaster.get(0);
        Intrinsics.checkNotNullExpressionValue(addressMaster2, "get(...)");
        instantPurchase.getAddressDetail(addressMaster2);
    }

    /* JADX INFO: renamed from: com.appnew.android.Payment.InstantPurchase$SuccessCallBack$2, reason: invalid class name */
    /* JADX INFO: compiled from: InstantPurchase.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/appnew/android/Payment/InstantPurchase$SuccessCallBack$2", "Lcom/android/billingclient/api/BillingClientStateListener;", InAppPurchaseConstants.METHOD_ON_BILLING_SETUP_FINISHED, "", "billingResult", "Lcom/android/billingclient/api/BillingResult;", InAppPurchaseConstants.METHOD_ON_BILLING_SERVICE_DISCONNECTED, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass2 implements BillingClientStateListener {
        @Override // com.android.billingclient.api.BillingClientStateListener
        public void onBillingServiceDisconnected() {
        }

        AnonymousClass2() {
        }

        @Override // com.android.billingclient.api.BillingClientStateListener
        public void onBillingSetupFinished(BillingResult billingResult) {
            Intrinsics.checkNotNullParameter(billingResult, "billingResult");
            if (billingResult.getResponseCode() == 0) {
                QueryProductDetailsParams queryProductDetailsParamsBuild = QueryProductDetailsParams.newBuilder().setProductList(ImmutableList.of(QueryProductDetailsParams.Product.newBuilder().setProductId(InstantPurchase.this.product_id).setProductType("inapp").build())).build();
                Intrinsics.checkNotNullExpressionValue(queryProductDetailsParamsBuild, "build(...)");
                BillingClient billingClient = InstantPurchase.this.billingClient;
                if (billingClient != null) {
                    final InstantPurchase instantPurchase = InstantPurchase.this;
                    billingClient.queryProductDetailsAsync(queryProductDetailsParamsBuild, new ProductDetailsResponseListener() { // from class: com.appnew.android.Payment.InstantPurchase$SuccessCallBack$2$$ExternalSyntheticLambda0
                        @Override // com.android.billingclient.api.ProductDetailsResponseListener
                        public final void onProductDetailsResponse(BillingResult billingResult2, List list) {
                            InstantPurchase.AnonymousClass2.onBillingSetupFinished$lambda$0(instantPurchase, billingResult2, list);
                        }
                    });
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBillingSetupFinished$lambda$0(InstantPurchase instantPurchase, BillingResult billingResult, List productDetailsList) {
            Intrinsics.checkNotNullParameter(billingResult, "billingResult");
            Intrinsics.checkNotNullParameter(productDetailsList, "productDetailsList");
            Iterator it = productDetailsList.iterator();
            while (it.hasNext()) {
                ProductDetails productDetails = (ProductDetails) it.next();
                BillingFlowParams.ProductDetailsParams.Builder builderNewBuilder = BillingFlowParams.ProductDetailsParams.newBuilder();
                Intrinsics.checkNotNull(productDetails);
                BillingFlowParams billingFlowParamsBuild = BillingFlowParams.newBuilder().setProductDetailsParamsList(ImmutableList.of(builderNewBuilder.setProductDetails(productDetails).build())).build();
                Intrinsics.checkNotNullExpressionValue(billingFlowParamsBuild, "build(...)");
                BillingClient billingClient = instantPurchase.billingClient;
                if (billingClient != null) {
                    billingClient.launchBillingFlow(instantPurchase.requireActivity(), billingFlowParamsBuild);
                }
            }
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        if (jsonstring != null) {
            showMessage(jsonstring);
        }
    }

    public final String getPayVia() {
        return this.payVia;
    }

    public final void setPayVia(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.payVia = str;
    }

    public final void initPaymentGateway() {
        PreferencesUtil preferencesUtil = PreferencesUtil.INSTANCE;
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        preferencesUtil.removeAllCredentials(fragmentActivityRequireActivity);
        getPaymentCredentials();
    }

    public final void registers() {
        this.resultLauncherPaytm = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.Payment.InstantPurchase$$ExternalSyntheticLambda21
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                InstantPurchase.registers$lambda$114(this.f$0, (ActivityResult) obj);
            }
        });
        this.resultLauncherCCAvenue = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.Payment.InstantPurchase$$ExternalSyntheticLambda23
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                InstantPurchase.registers$lambda$115(this.f$0, (ActivityResult) obj);
            }
        });
        this.resultLauncherESewa = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.Payment.InstantPurchase$$ExternalSyntheticLambda24
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                InstantPurchase.registers$lambda$116(this.f$0, (ActivityResult) obj);
            }
        });
        this.resultLauncherFonePay = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.Payment.InstantPurchase$$ExternalSyntheticLambda25
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                InstantPurchase.registers$lambda$118(this.f$0, (ActivityResult) obj);
            }
        });
        this.resultLauncherEaseBuzz = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.Payment.InstantPurchase$$ExternalSyntheticLambda26
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                InstantPurchase.registers$lambda$119(this.f$0, (ActivityResult) obj);
            }
        });
        this.resultLauncherBillDesk = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.Payment.InstantPurchase$$ExternalSyntheticLambda27
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                InstantPurchase.registers$lambda$120(this.f$0, (ActivityResult) obj);
            }
        });
        this.resultLauncherWorldLine = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.Payment.InstantPurchase$$ExternalSyntheticLambda28
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                Intrinsics.checkNotNullParameter((ActivityResult) obj, "result");
            }
        });
        this.resultLauncherEasyPay = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.Payment.InstantPurchase$$ExternalSyntheticLambda29
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                InstantPurchase.registers$lambda$123(this.f$0, (ActivityResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registers$lambda$114(InstantPurchase instantPurchase, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == 100) {
            Intent data = result.getData();
            if ((data != null ? data.getStringExtra(PaytmConstants.TRANSACTION_ID) : null) != null) {
                Intent data2 = result.getData();
                String stringExtra = data2 != null ? data2.getStringExtra(PaytmConstants.TRANSACTION_ID) : null;
                PaymentGatewayListener paymentGatewayListener = instantPurchase.paymentGatewayListener;
                if (paymentGatewayListener != null) {
                    paymentGatewayListener.onSuccess(stringExtra);
                    return;
                }
                return;
            }
            return;
        }
        if (result.getResultCode() == 101) {
            try {
                PaymentGatewayListener paymentGatewayListener2 = instantPurchase.paymentGatewayListener;
                if (paymentGatewayListener2 != null) {
                    paymentGatewayListener2.onFailed(true);
                }
            } catch (Exception e2) {
                Log.d("TAGINSTANTPURCHASE", "Error: " + e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registers$lambda$115(InstantPurchase instantPurchase, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            Intent data = result.getData();
            String stringExtra = data != null ? data.getStringExtra("result") : null;
            if (stringExtra == null || stringExtra.length() <= 0) {
                return;
            }
            new InstantPurchase$registers$2$1(stringExtra, instantPurchase).start();
            return;
        }
        try {
            PaymentGatewayListener paymentGatewayListener = instantPurchase.paymentGatewayListener;
            if (paymentGatewayListener != null) {
                paymentGatewayListener.onFailed(true);
                Unit unit = Unit.INSTANCE;
            }
        } catch (Exception e2) {
            Integer.valueOf(Log.d("TAGINSTANTPURCHASE", "Error: " + e2.getMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registers$lambda$116(InstantPurchase instantPurchase, ActivityResult result) {
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
                PaymentGatewayListener paymentGatewayListener = instantPurchase.paymentGatewayListener;
                if (paymentGatewayListener != null) {
                    Intrinsics.checkNotNull(string);
                    Intrinsics.checkNotNull(string2);
                    Intrinsics.checkNotNull(string3);
                    paymentGatewayListener.onSuccessEsewa(string, string2, string3, str);
                    Unit unit = Unit.INSTANCE;
                    return;
                }
                return;
            } catch (JSONException e2) {
                e2.printStackTrace();
                Unit unit2 = Unit.INSTANCE;
                return;
            }
        }
        try {
            PaymentGatewayListener paymentGatewayListener2 = instantPurchase.paymentGatewayListener;
            if (paymentGatewayListener2 != null) {
                paymentGatewayListener2.onFailed(true);
                Unit unit3 = Unit.INSTANCE;
            }
        } catch (Exception e3) {
            Integer.valueOf(Log.d("TAGINSTANTPURCHASE", "Error: " + e3.getMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registers$lambda$118(final InstantPurchase instantPurchase, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            Intent data = result.getData();
            String stringExtra = data != null ? data.getStringExtra("status") : null;
            Intent data2 = result.getData();
            final String stringExtra2 = data2 != null ? data2.getStringExtra("post_txn_id") : null;
            if (StringsKt.equals$default(stringExtra, "true", false, 2, null)) {
                FragmentActivity activity = instantPurchase.getActivity();
                if (activity != null) {
                    activity.runOnUiThread(new Runnable() { // from class: com.appnew.android.Payment.InstantPurchase$$ExternalSyntheticLambda50
                        @Override // java.lang.Runnable
                        public final void run() {
                            InstantPurchase.registers$lambda$118$lambda$117(this.f$0, stringExtra2);
                        }
                    });
                    return;
                }
                return;
            }
            try {
                PaymentGatewayListener paymentGatewayListener = instantPurchase.paymentGatewayListener;
                if (paymentGatewayListener != null) {
                    paymentGatewayListener.onFailed(true);
                    Unit unit = Unit.INSTANCE;
                    return;
                }
                return;
            } catch (Exception e2) {
                Integer.valueOf(Log.d("TAGINSTANTPURCHASE", "Error: " + e2.getMessage()));
                return;
            }
        }
        try {
            PaymentGatewayListener paymentGatewayListener2 = instantPurchase.paymentGatewayListener;
            if (paymentGatewayListener2 != null) {
                paymentGatewayListener2.onFailed(true);
                Unit unit2 = Unit.INSTANCE;
            }
        } catch (Exception e3) {
            Integer.valueOf(Log.d("TAGINSTANTPURCHASE", "Error: " + e3.getMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registers$lambda$118$lambda$117(InstantPurchase instantPurchase, String str) {
        PaymentGatewayListener paymentGatewayListener = instantPurchase.paymentGatewayListener;
        if (paymentGatewayListener != null) {
            paymentGatewayListener.onSuccess(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registers$lambda$119(InstantPurchase instantPurchase, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == 100) {
            Intent data = result.getData();
            if ((data != null ? data.getStringExtra(PaytmConstants.TRANSACTION_ID) : null) != null) {
                Intent data2 = result.getData();
                String stringExtra = data2 != null ? data2.getStringExtra(PaytmConstants.TRANSACTION_ID) : null;
                PaymentGatewayListener paymentGatewayListener = instantPurchase.paymentGatewayListener;
                if (paymentGatewayListener != null) {
                    paymentGatewayListener.onSuccess(stringExtra);
                    return;
                }
                return;
            }
            return;
        }
        if (result.getResultCode() == 101) {
            try {
                PaymentGatewayListener paymentGatewayListener2 = instantPurchase.paymentGatewayListener;
                if (paymentGatewayListener2 != null) {
                    paymentGatewayListener2.onFailed(true);
                }
            } catch (Exception e2) {
                Log.d("TAGINSTANTPURCHASE", "Error: " + e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registers$lambda$120(InstantPurchase instantPurchase, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        try {
            String string = SharedPreference.getInstance().getString("paymentResult");
            List listSplit$default = string != null ? StringsKt.split$default((CharSequence) string, new String[]{"|"}, false, 0, 6, (Object) null) : null;
            String str = listSplit$default != null ? (String) listSplit$default.get(2) : null;
            if (StringsKt.equals(listSplit$default != null ? (String) listSplit$default.get(14) : null, "0300", true)) {
                PaymentGatewayListener paymentGatewayListener = instantPurchase.paymentGatewayListener;
                if (paymentGatewayListener != null) {
                    paymentGatewayListener.onSuccess(str);
                }
            } else {
                try {
                    PaymentGatewayListener paymentGatewayListener2 = instantPurchase.paymentGatewayListener;
                    if (paymentGatewayListener2 != null) {
                        paymentGatewayListener2.onFailed(true);
                        Unit unit = Unit.INSTANCE;
                    }
                } catch (Exception e2) {
                    Integer.valueOf(Log.d("TAGINSTANTPURCHASE", "Error: " + e2.getMessage()));
                }
            }
        } catch (Exception e3) {
            Log.d("TAGINSTANTPURCHASE", "Error: " + e3.getMessage());
        }
        SharedPreference.getInstance().remove("paymentResult");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registers$lambda$123(final InstantPurchase instantPurchase, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            Intent data = result.getData();
            String stringExtra = data != null ? data.getStringExtra("status") : null;
            Intent data2 = result.getData();
            final String stringExtra2 = data2 != null ? data2.getStringExtra("post_txn_id") : null;
            if (StringsKt.equals$default(stringExtra, "true", false, 2, null)) {
                FragmentActivity activity = instantPurchase.getActivity();
                if (activity != null) {
                    activity.runOnUiThread(new Runnable() { // from class: com.appnew.android.Payment.InstantPurchase$$ExternalSyntheticLambda6
                        @Override // java.lang.Runnable
                        public final void run() {
                            InstantPurchase.registers$lambda$123$lambda$122(this.f$0, stringExtra2);
                        }
                    });
                    return;
                }
                return;
            }
            try {
                PaymentGatewayListener paymentGatewayListener = instantPurchase.paymentGatewayListener;
                if (paymentGatewayListener != null) {
                    paymentGatewayListener.onFailed(true);
                    Unit unit = Unit.INSTANCE;
                    return;
                }
                return;
            } catch (Exception e2) {
                Integer.valueOf(Log.d("TAGINSTANTPURCHASE", "Error: " + e2.getMessage()));
                return;
            }
        }
        try {
            PaymentGatewayListener paymentGatewayListener2 = instantPurchase.paymentGatewayListener;
            if (paymentGatewayListener2 != null) {
                paymentGatewayListener2.onFailed(true);
                Unit unit2 = Unit.INSTANCE;
            }
        } catch (Exception e3) {
            Integer.valueOf(Log.d("TAGINSTANTPURCHASE", "Error: " + e3.getMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registers$lambda$123$lambda$122(InstantPurchase instantPurchase, String str) {
        PaymentGatewayListener paymentGatewayListener = instantPurchase.paymentGatewayListener;
        if (paymentGatewayListener != null) {
            paymentGatewayListener.onSuccess(str);
        }
    }

    public final void launchPaytmPaymentGateway(String pre_txtid, int amount, String txnToken, String mid, String url) {
        Resources resources;
        Intrinsics.checkNotNullParameter(pre_txtid, "pre_txtid");
        Intrinsics.checkNotNullParameter(txnToken, "txnToken");
        Intrinsics.checkNotNullParameter(mid, "mid");
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            Intent intent = new Intent(getActivity(), Class.forName("com.example.paytm_gateway.PaytmPaymentActivity"));
            FragmentActivity activity = getActivity();
            intent.putExtra("name", (activity == null || (resources = activity.getResources()) == null) ? null : resources.getString(R.string.payment_gateway_name));
            intent.putExtra("pre_txtid", pre_txtid);
            intent.putExtra("amount", amount);
            intent.putExtra("txnToken", txnToken);
            intent.putExtra("mid", mid);
            intent.putExtra("url", url);
            ActivityResultLauncher<Intent> activityResultLauncher = this.resultLauncherPaytm;
            if (activityResultLauncher != null) {
                activityResultLauncher.launch(intent);
            }
        } catch (Exception e2) {
            Log.d("TAGINSTANTPURCHASE", "Error: " + e2.getMessage());
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
            Intent intent = new Intent(getActivity(), Class.forName("com.yaman.cc_avanue_gateway.activity.CCAvenueActivity"));
            FragmentActivity activity = getActivity();
            intent.putExtra("name", (activity == null || (resources = activity.getResources()) == null) ? null : resources.getString(R.string.payment_gateway_name));
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
        } catch (Exception e2) {
            Log.d("TAGINSTANTPURCHASE", "Error: " + e2.getMessage());
        }
    }

    public final void launchESewaPaymentGateway(String pre_txtid, int amount) {
        Resources resources;
        Intrinsics.checkNotNullParameter(pre_txtid, "pre_txtid");
        try {
            Intent intent = new Intent(getActivity(), Class.forName("com.yaman.esewa_payment_gateway.EsewaPaymentActivity"));
            FragmentActivity activity = getActivity();
            intent.putExtra("name", (activity == null || (resources = activity.getResources()) == null) ? null : resources.getString(R.string.payment_gateway_name));
            intent.putExtra("pre_txtid", pre_txtid);
            intent.putExtra("amount", amount);
            ActivityResultLauncher<Intent> activityResultLauncher = this.resultLauncherESewa;
            if (activityResultLauncher != null) {
                activityResultLauncher.launch(intent);
            }
        } catch (Exception e2) {
            Log.d("TAGINSTANTPURCHASE", "Error: " + e2.getMessage());
        }
    }

    public static /* synthetic */ void launchRazorPayPaymentGateway$default(InstantPurchase instantPurchase, JSONObject jSONObject, boolean z, String str, long j, CoursesCoupon coursesCoupon, CourseDetail courseDetail, String str2, int i, Object obj) {
        if ((i & 16) != 0) {
            coursesCoupon = null;
        }
        if ((i & 32) != 0) {
            courseDetail = null;
        }
        instantPurchase.launchRazorPayPaymentGateway(jSONObject, z, str, j, coursesCoupon, courseDetail, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x008b A[Catch: Exception -> 0x0139, TryCatch #0 {Exception -> 0x0139, blocks: (B:5:0x0058, B:7:0x005e, B:9:0x0066, B:12:0x0076, B:14:0x008b, B:16:0x0092, B:18:0x009b, B:22:0x00a7, B:24:0x00c8, B:25:0x00cc, B:27:0x00d7, B:29:0x00dd, B:31:0x00ed, B:30:0x00e3, B:20:0x00a0), top: B:73:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009b A[Catch: Exception -> 0x0139, TryCatch #0 {Exception -> 0x0139, blocks: (B:5:0x0058, B:7:0x005e, B:9:0x0066, B:12:0x0076, B:14:0x008b, B:16:0x0092, B:18:0x009b, B:22:0x00a7, B:24:0x00c8, B:25:0x00cc, B:27:0x00d7, B:29:0x00dd, B:31:0x00ed, B:30:0x00e3, B:20:0x00a0), top: B:73:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c8 A[Catch: Exception -> 0x0139, TryCatch #0 {Exception -> 0x0139, blocks: (B:5:0x0058, B:7:0x005e, B:9:0x0066, B:12:0x0076, B:14:0x008b, B:16:0x0092, B:18:0x009b, B:22:0x00a7, B:24:0x00c8, B:25:0x00cc, B:27:0x00d7, B:29:0x00dd, B:31:0x00ed, B:30:0x00e3, B:20:0x00a0), top: B:73:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e3 A[Catch: Exception -> 0x0139, TryCatch #0 {Exception -> 0x0139, blocks: (B:5:0x0058, B:7:0x005e, B:9:0x0066, B:12:0x0076, B:14:0x008b, B:16:0x0092, B:18:0x009b, B:22:0x00a7, B:24:0x00c8, B:25:0x00cc, B:27:0x00d7, B:29:0x00dd, B:31:0x00ed, B:30:0x00e3, B:20:0x00a0), top: B:73:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01c5 A[Catch: Exception -> 0x0267, TryCatch #1 {Exception -> 0x0267, blocks: (B:36:0x0176, B:38:0x017c, B:40:0x0184, B:43:0x0194, B:45:0x01a9, B:47:0x01af, B:49:0x01b5, B:51:0x01bc, B:53:0x01c5, B:61:0x01dd, B:63:0x01fe, B:65:0x0204, B:67:0x020a, B:68:0x020e, B:55:0x01ca, B:57:0x01d0, B:59:0x01d6), top: B:75:0x0176 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void launchRazorPayPaymentGateway(org.json.JSONObject r29, boolean r30, java.lang.String r31, long r32, com.appnew.android.Coupon.Models.CoursesCoupon r34, com.appnew.android.Model.COURSEDETAIL.CourseDetail r35, java.lang.String r36) {
        /*
            Method dump skipped, instruction units count: 645
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Payment.InstantPurchase.launchRazorPayPaymentGateway(org.json.JSONObject, boolean, java.lang.String, long, com.appnew.android.Coupon.Models.CoursesCoupon, com.appnew.android.Model.COURSEDETAIL.CourseDetail, java.lang.String):void");
    }

    public final void launchFonePayPaymentGateway(String fonePayUrl, int amount) {
        Resources resources;
        Intrinsics.checkNotNullParameter(fonePayUrl, "fonePayUrl");
        Intent intent = new Intent(getActivity(), Class.forName("com.appnew.android.fonepay.FonePayCheckout"));
        FragmentActivity activity = getActivity();
        intent.putExtra("name", (activity == null || (resources = activity.getResources()) == null) ? null : resources.getString(R.string.payment_gateway_name));
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
        Intent intent = new Intent(getActivity(), Class.forName("com.example.easybuzz_payment_gateway.EaseBuzzPaymentActivity"));
        FragmentActivity activity = getActivity();
        intent.putExtra("name", (activity == null || (resources = activity.getResources()) == null) ? null : resources.getString(R.string.payment_gateway_name));
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
        Intent intent = new Intent(getActivity(), Class.forName("com.appnew.android.Payment.billdesk_payment_gateway.BillDeskPaymentScreen"));
        FragmentActivity activity = getActivity();
        intent.putExtra("name", (activity == null || (resources = activity.getResources()) == null) ? null : resources.getString(R.string.payment_gateway_name));
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
        Intent intent = new Intent(getActivity(), (Class<?>) EasyPayCheckout.class);
        FragmentActivity activity = getActivity();
        intent.putExtra("name", (activity == null || (resources = activity.getResources()) == null) ? null : resources.getString(R.string.payment_gateway_name));
        intent.putExtra("amount", amount);
        intent.putExtra("easyPayUrl", easyPayUrl);
        ActivityResultLauncher<Intent> activityResultLauncher = this.resultLauncherEasyPay;
        if (activityResultLauncher != null) {
            activityResultLauncher.launch(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final APIInterface getWebService() {
        return (APIInterface) this.webService.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final APIInterface webService_delegate$lambda$124() {
        return (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
    }

    /* JADX INFO: renamed from: com.appnew.android.Payment.InstantPurchase$getPaymentCredentials$1, reason: invalid class name */
    /* JADX INFO: compiled from: InstantPurchase.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.Payment.InstantPurchase$getPaymentCredentials$1", f = "InstantPurchase.kt", i = {}, l = {3381}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return InstantPurchase.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0099 A[Catch: Exception -> 0x0028, TRY_LEAVE, TryCatch #0 {Exception -> 0x0028, blocks: (B:5:0x0022, B:17:0x006b, B:19:0x006f, B:21:0x0099, B:12:0x0037, B:14:0x005f), top: B:165:0x001e }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r24) {
            /*
                Method dump skipped, instruction units count: 861
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Payment.InstantPurchase.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void getPaymentCredentials() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), Dispatchers.getIO(), null, new AnonymousClass1(null), 2, null);
    }

    public final void onPaymentSuccess(String s) {
        this.pos_txn_id = s;
        NetworkCall networkCall = this.networkCall;
        Intrinsics.checkNotNull(networkCall);
        networkCall.NetworkAPICall(API.int_payment, "", true, false);
    }

    public final void onPaymentError(int i, String s) {
        handlePaymentError();
    }

    public final void onSuccessEsewa(String productId, String totalAmount, String referenceId, String scdId) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(totalAmount, "totalAmount");
        Intrinsics.checkNotNullParameter(referenceId, "referenceId");
        Intrinsics.checkNotNullParameter(scdId, "scdId");
        this.pos_txn_id = productId;
        this.amt = totalAmount;
        this.rid = referenceId;
        this.scd = scdId;
        NetworkCall networkCall = this.networkCall;
        if (networkCall != null) {
            networkCall.NetworkAPICall(API.int_payment, "", true, false);
        }
    }

    public final void onSuccess(String posTxnId) {
        this.pos_txn_id = posTxnId;
        NetworkCall networkCall = this.networkCall;
        if (networkCall != null) {
            networkCall.NetworkAPICall(API.int_payment, "", true, false);
        }
    }

    public final void onFailed(boolean isFailure) {
        handlePaymentError();
    }

    public final TxnTokenData getTxnTokenData() {
        return this.txnTokenData;
    }

    public final void setTxnTokenData(TxnTokenData txnTokenData) {
        this.txnTokenData = txnTokenData;
    }

    public final void manageQRPayment(JSONObject data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.pre_txtid = data.optString(Const.COURSE_INIT_PAYMENT_TOKEN);
        this.txnToken = data.optString("txnToken");
        TxnTokenData txnTokenData = (TxnTokenData) new Gson().fromJson(this.txnToken, TxnTokenData.class);
        this.txnTokenData = txnTokenData;
        if (txnTokenData == null) {
            showMessage("QR data not found!");
            return;
        }
        if (TextUtils.isEmpty(txnTokenData != null ? txnTokenData.getImage_url() : null)) {
            showMessage("QR image not found!");
            return;
        }
        TxnTokenData txnTokenData2 = this.txnTokenData;
        if (!TextUtils.isEmpty(txnTokenData2 != null ? txnTokenData2.getCreated_at() : null)) {
            TxnTokenData txnTokenData3 = this.txnTokenData;
            if (!TextUtils.isEmpty(txnTokenData3 != null ? txnTokenData3.getClose_by() : null)) {
                if (TextUtils.isEmpty(this.pre_txtid)) {
                    showMessage("Transaction id not found!");
                    return;
                } else {
                    openQRCode();
                    return;
                }
            }
        }
        showMessage("Payment duration not valid!");
    }

    public final int getDeviceWidthWithInsets() {
        Context context = getContext();
        Object systemService = context != null ? context.getSystemService("window") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager windowManager = (WindowManager) systemService;
        if (Build.VERSION.SDK_INT >= 30) {
            WindowInsets windowInsets = windowManager.getCurrentWindowMetrics().getWindowInsets();
            Intrinsics.checkNotNullExpressionValue(windowInsets, "getWindowInsets(...)");
            Insets insets = windowInsets.getInsets(WindowInsets.Type.systemBars());
            Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
            return (windowManager.getCurrentWindowMetrics().getBounds().width() - insets.left) - insets.right;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public final int getDeviceHeightWithInsets() {
        Context context = getContext();
        Object systemService = context != null ? context.getSystemService("window") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager windowManager = (WindowManager) systemService;
        if (Build.VERSION.SDK_INT >= 30) {
            WindowInsets windowInsets = windowManager.getCurrentWindowMetrics().getWindowInsets();
            Intrinsics.checkNotNullExpressionValue(windowInsets, "getWindowInsets(...)");
            Insets insets = windowInsets.getInsets(WindowInsets.Type.systemBars());
            Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
            return (windowManager.getCurrentWindowMetrics().getBounds().height() - insets.top) - insets.bottom;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public final void openQRCode() {
        final Dialog dialog;
        final RelativeLayout relativeLayout;
        final LinearLayout linearLayout;
        ImageView imageView;
        final ImageView imageView2;
        final TextView textView;
        RequestBuilder<Bitmap> requestBuilderAsBitmap;
        TxnTokenData txnTokenData;
        Window window;
        try {
            Context context = getContext();
            dialog = context != null ? new Dialog(context) : null;
            if (dialog != null) {
                dialog.setContentView(R.layout.dialog_qr_payment);
            }
            if (dialog != null) {
                dialog.setCancelable(false);
            }
            if (dialog != null && (window = dialog.getWindow()) != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            relativeLayout = dialog != null ? (RelativeLayout) dialog.findViewById(R.id.mainQRRL) : null;
            linearLayout = dialog != null ? (LinearLayout) dialog.findViewById(R.id.qrLoader) : null;
            imageView = dialog != null ? (ImageView) dialog.findViewById(R.id.iv_close) : null;
            imageView2 = dialog != null ? (ImageView) dialog.findViewById(R.id.iv_qr_image) : null;
            textView = dialog != null ? (TextView) dialog.findViewById(R.id.time) : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            requestBuilderAsBitmap = Glide.with(this).asBitmap();
            txnTokenData = this.txnTokenData;
        } catch (Exception e2) {
            e = e2;
        }
        try {
            requestBuilderAsBitmap.load(txnTokenData != null ? txnTokenData.getImage_url() : null).timeout(10000).into(new CustomTarget<Bitmap>() { // from class: com.appnew.android.Payment.InstantPurchase.openQRCode.1
                @Override // com.bumptech.glide.request.target.Target
                public void onLoadCleared(Drawable placeholder) {
                }

                @Override // com.bumptech.glide.request.target.Target
                public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                    onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                }

                /* JADX WARN: Type inference failed for: r0v3, types: [com.appnew.android.Payment.InstantPurchase$openQRCode$1$onResourceReady$1$1] */
                public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                    Intrinsics.checkNotNullParameter(resource, "resource");
                    final InstantPurchase instantPurchase = InstantPurchase.this;
                    LinearLayout linearLayout2 = linearLayout;
                    final Dialog dialog2 = dialog;
                    ImageView imageView3 = imageView2;
                    RelativeLayout relativeLayout2 = relativeLayout;
                    final TextView textView2 = textView;
                    instantPurchase.enableScreenshot();
                    if (linearLayout2 != null) {
                        linearLayout2.setVisibility(8);
                    }
                    instantPurchase.qrPaymentCallback(dialog2);
                    if (imageView3 != null) {
                        imageView3.setImageBitmap(resource);
                    }
                    ViewGroup.LayoutParams layoutParams = relativeLayout2 != null ? relativeLayout2.getLayoutParams() : null;
                    if (layoutParams != null) {
                        layoutParams.width = imageView3 != null ? imageView3.getWidth() : instantPurchase.getDeviceWidthWithInsets() - (instantPurchase.getDeviceWidthWithInsets() / 4);
                    }
                    if (layoutParams != null) {
                        layoutParams.height = imageView3 != null ? imageView3.getHeight() : instantPurchase.getDeviceHeightWithInsets() - (instantPurchase.getDeviceHeightWithInsets() / 10);
                    }
                    if (relativeLayout2 != null) {
                        relativeLayout2.setLayoutParams(layoutParams);
                    }
                    TxnTokenData txnTokenData2 = instantPurchase.getTxnTokenData();
                    String close_by = txnTokenData2 != null ? txnTokenData2.getClose_by() : null;
                    Intrinsics.checkNotNull(close_by);
                    long j = 1000;
                    long j2 = Long.parseLong(close_by) * j;
                    TxnTokenData txnTokenData3 = instantPurchase.getTxnTokenData();
                    String created_at = txnTokenData3 != null ? txnTokenData3.getCreated_at() : null;
                    Intrinsics.checkNotNull(created_at);
                    final long j3 = j2 - (Long.parseLong(created_at) * j);
                    instantPurchase.countDownTimer = new CountDownTimer(j3) { // from class: com.appnew.android.Payment.InstantPurchase$openQRCode$1$onResourceReady$1$1
                        @Override // android.os.CountDownTimer
                        public void onTick(long millisUntilFinished) {
                            long minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished);
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % ((long) 60);
                            TextView textView3 = textView2;
                            if (textView3 != null) {
                                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                                String str = String.format(Locale.getDefault(), "%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(minutes), Long.valueOf(seconds)}, 2));
                                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                                textView3.setText(str);
                            }
                            if (millisUntilFinished <= 30000 && millisUntilFinished > 0) {
                                TextView textView4 = textView2;
                                if (textView4 != null) {
                                    textView4.setBackgroundTintList(ContextCompat.getColorStateList(instantPurchase.requireActivity(), R.color.md_amber_A400));
                                    return;
                                }
                                return;
                            }
                            if (millisUntilFinished <= 120000 && millisUntilFinished > 30000) {
                                TextView textView5 = textView2;
                                if (textView5 != null) {
                                    textView5.setBackgroundTintList(ContextCompat.getColorStateList(instantPurchase.requireActivity(), R.color.rewards_color));
                                    return;
                                }
                                return;
                            }
                            TextView textView6 = textView2;
                            if (textView6 != null) {
                                textView6.setBackgroundTintList(ContextCompat.getColorStateList(instantPurchase.requireActivity(), R.color.md_lime_500));
                            }
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TextView textView3 = textView2;
                            if (textView3 != null) {
                                textView3.setText("Expired");
                            }
                            instantPurchase.showMessage("QR Expired");
                            Dialog dialog3 = dialog2;
                            if (dialog3 != null) {
                                dialog3.dismiss();
                            }
                        }
                    }.start();
                }

                @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
                public void onLoadFailed(Drawable errorDrawable) {
                    InstantPurchase.this.showMessage("Invalid QR code!");
                    Dialog dialog2 = dialog;
                    if (dialog2 != null) {
                        dialog2.dismiss();
                    }
                }
            });
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.InstantPurchase$$ExternalSyntheticLambda32
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        InstantPurchase.openQRCode$lambda$128(this.f$0, dialog, view);
                    }
                });
            }
            if (dialog != null) {
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.appnew.android.Payment.InstantPurchase$$ExternalSyntheticLambda34
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        InstantPurchase.openQRCode$lambda$129(this.f$0, dialogInterface);
                    }
                });
            }
            if (dialog != null) {
                dialog.show();
            }
        } catch (Exception e3) {
            e = e3;
            Log.d("TAGINSTANTPURCHASE", "Error: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openQRCode$lambda$128(InstantPurchase instantPurchase, final Dialog dialog, View view) {
        DialogUtils.makeDialog(instantPurchase.requireActivity(), "", "Are you sure want to close!", instantPurchase.getResources().getString(R.string.confirm), instantPurchase.getResources().getString(R.string.cancel), true, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Payment.InstantPurchase$$ExternalSyntheticLambda30
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
            public final void onOKClick() {
                InstantPurchase.openQRCode$lambda$128$lambda$126(dialog);
            }
        }, new DialogUtils.onDialogUtilsCancelClick() { // from class: com.appnew.android.Payment.InstantPurchase$$ExternalSyntheticLambda31
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsCancelClick
            public final void onCancelClick() {
                InstantPurchase.openQRCode$lambda$128$lambda$127();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openQRCode$lambda$128$lambda$126(Dialog dialog) {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openQRCode$lambda$129(InstantPurchase instantPurchase, DialogInterface dialogInterface) {
        ValueEventListener valueEventListener;
        DatabaseReference databaseReference = instantPurchase.mFirebaseDatabaseReferenceQRPay;
        if (databaseReference != null && (valueEventListener = instantPurchase.qrPayValueEventListener) != null) {
            if (databaseReference != null) {
                Intrinsics.checkNotNull(valueEventListener);
                databaseReference.removeEventListener(valueEventListener);
            }
            Log.d("TAGINSTANTPURCHASE", "removefirebaseDatabaseReferenceQRPay");
        }
        CountDownTimer countDownTimer = instantPurchase.countDownTimer;
        if (countDownTimer == null || countDownTimer == null) {
            return;
        }
        countDownTimer.cancel();
    }

    public final ValueEventListener getQrPayValueEventListener() {
        return this.qrPayValueEventListener;
    }

    public final void setQrPayValueEventListener(ValueEventListener valueEventListener) {
        this.qrPayValueEventListener = valueEventListener;
    }

    public final void qrPaymentCallback(final Dialog dialog) {
        String str = this.pre_txtid;
        Log.d("TAGINSTANTPURCHASE", "pre_txtid: " + str);
        this.mFirebaseDatabaseReferenceQRPay = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/qrcode_payment_status/" + str);
        this.qrPayValueEventListener = new ValueEventListener() { // from class: com.appnew.android.Payment.InstantPurchase.qrPaymentCallback.1
            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot dataSnapshot) {
                String string;
                Intrinsics.checkNotNullParameter(dataSnapshot, "dataSnapshot");
                try {
                    if (dataSnapshot.getValue() == null) {
                        Log.d("TAGINSTANTPURCHASE", "noData: " + dataSnapshot.getValue());
                        return;
                    }
                    Log.d("TAGINSTANTPURCHASE", "onDataChange: " + dataSnapshot.getValue());
                    if (dataSnapshot.getValue() != null) {
                        QRPaymentData qRPaymentData = (QRPaymentData) dataSnapshot.getValue(QRPaymentData.class);
                        Long transaction_status = qRPaymentData != null ? qRPaymentData.getTransaction_status() : null;
                        if (transaction_status == null || (string = transaction_status.toString()) == null) {
                            string = "0";
                        }
                        if (qRPaymentData == null || TextUtils.isEmpty(String.valueOf(qRPaymentData.getPre_transaction_id())) || TextUtils.isEmpty(String.valueOf(qRPaymentData.getPost_transaction_id())) || !string.equals("1")) {
                            return;
                        }
                        InstantPurchase.this.setPre_txtid(String.valueOf(qRPaymentData.getPre_transaction_id()));
                        InstantPurchase.this.setPos_txn_id(String.valueOf(qRPaymentData.getPost_transaction_id()));
                        NetworkCall networkCall = InstantPurchase.this.getNetworkCall();
                        Intrinsics.checkNotNull(networkCall);
                        networkCall.NetworkAPICall(API.int_payment, "", true, false);
                        Dialog dialog2 = dialog;
                        if (dialog2 == null || !dialog2.isShowing()) {
                            return;
                        }
                        dialog.dismiss();
                    }
                } catch (Exception e2) {
                    Log.d("TAGINSTANTPURCHASE", "Error: " + e2.getMessage());
                }
            }
        };
        DatabaseReference databaseReference = this.mFirebaseDatabaseReferenceQRPay;
        Intrinsics.checkNotNull(databaseReference);
        ValueEventListener valueEventListener = this.qrPayValueEventListener;
        Intrinsics.checkNotNull(valueEventListener);
        databaseReference.addValueEventListener(valueEventListener);
    }

    public final void enableScreenshot() {
        Window window;
        FragmentActivity activity = getActivity();
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        window.clearFlags(8192);
    }

    public final void hideKeyboard() {
        View rootView;
        try {
            Dialog dialog = getDialog();
            if (dialog == null || (rootView = dialog.getCurrentFocus()) == null) {
                View view = getView();
                rootView = view != null ? view.getRootView() : null;
            }
            if (rootView != null) {
                Context context = getContext();
                InputMethodManager inputMethodManager = (InputMethodManager) (context != null ? context.getSystemService("input_method") : null);
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(rootView.getWindowToken(), 0);
                }
            }
        } catch (Exception e2) {
            Log.d("TAGINSTANTPURCHASE", "Error: " + e2.getMessage());
        }
    }

    public final void closePaymentDialog() {
        try {
            getBinding().cancelBox.performClick();
        } catch (Exception e2) {
            Log.d("TAGINSTANTPURCHASE", "Error: " + e2.getMessage());
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public void dismiss() {
        hideKeyboard();
        Helper.enableScreenShot(requireActivity());
        super.dismiss();
    }

    public final void showUpdateStatePopup() {
        Log.d("TAGAddressModule", "IsShowAddress: " + isShowAddress() + "-> comboHasBook: " + isComboBookAddress() + " - isPurchase: " + Helper.isAddressShowAfter());
        UpdateProfileDialogUtils.makeDialogForStateUpdate(requireActivity(), isShowAddress(), new UpdateProfileDialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Payment.InstantPurchase.showUpdateStatePopup.1
            @Override // com.appnew.android.Utils.UpdateProfileDialogUtils.onDialogUtilsOkClick
            public void onOKClick(Dialog dialog, String submitType, String stateId, String districtId, String addressJson) {
                Intrinsics.checkNotNullParameter(dialog, "dialog");
                Intrinsics.checkNotNullParameter(submitType, "submitType");
                Intrinsics.checkNotNullParameter(stateId, "stateId");
                Intrinsics.checkNotNullParameter(districtId, "districtId");
                Intrinsics.checkNotNullParameter(addressJson, "addressJson");
                try {
                    if (SystemClock.elapsedRealtime() - InstantPurchase.this.getMLastClickTime() < 1000) {
                        return;
                    }
                    InstantPurchase.this.setMLastClickTime(SystemClock.elapsedRealtime());
                    if (!Intrinsics.areEqual(submitType, "1") && !Intrinsics.areEqual(submitType, "2")) {
                        dialog.dismiss();
                        InstantPurchase.this.finishPayment();
                        return;
                    }
                    InstantPurchase.this.submitUpdateStateData(dialog, submitType, stateId, districtId, addressJson);
                } catch (Exception e2) {
                    Log.d("Dialog", "makeDialog: " + e2.getMessage());
                }
            }
        });
    }

    public final void submitUpdateStateData(final Dialog dialog, String submitType, final String stateId, final String districtId, String addressJson) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(submitType, "submitType");
        Intrinsics.checkNotNullParameter(stateId, "stateId");
        Intrinsics.checkNotNullParameter(districtId, "districtId");
        Intrinsics.checkNotNullParameter(addressJson, "addressJson");
        if (Helper.isNetworkConnected(requireActivity())) {
            Helper.showProgressDialog(requireActivity());
            APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
            EncryptionData encryptionData = new EncryptionData();
            if (Intrinsics.areEqual(submitType, "1")) {
                encryptionData.setState(stateId);
            } else {
                encryptionData.setState(stateId);
                encryptionData.setAddress(addressJson);
            }
            Call<String> callUpdateprofile = aPIInterface.updateprofile(AES.encrypt(new Gson().toJson(encryptionData)));
            if (callUpdateprofile == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            callUpdateprofile.enqueue(new Callback<String>() { // from class: com.appnew.android.Payment.InstantPurchase.submitUpdateStateData.1
                @Override // retrofit2.Callback
                public void onResponse(Call<String> call, Response<String> response) {
                    Helper.dismissProgressDialog();
                    try {
                        Intrinsics.checkNotNull(response);
                        if (response.body() != null) {
                            JSONObject jSONObject = new JSONObject(AES.decrypt(response.body(), AES.generatekeyAPI(), AES.generateVectorAPI()));
                            com.appnew.android.pojo.Userinfo.Data loggedInUser = SharedPreference.getInstance().getLoggedInUser();
                            loggedInUser.setState(stateId);
                            loggedInUser.setCity(districtId);
                            SharedPreference.getInstance().setLoggedInUserr(loggedInUser);
                            Toast.makeText(this.requireActivity(), jSONObject.getString("message"), 1).show();
                            dialog.dismiss();
                            this.finishPayment();
                        }
                    } catch (Exception e2) {
                        Log.d("Dialog", "onResponse: " + e2.getMessage());
                    }
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<String> call, Throwable t) {
                    Helper.dismissProgressDialog();
                    Toast.makeText(this.requireActivity(), this.getResources().getString(R.string.something_went_wrong), 1).show();
                }
            });
            return;
        }
        Toast.makeText(requireActivity(), getResources().getString(R.string.Retry_with_Internet_connection), 1).show();
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void finishPayment() {
        /*
            Method dump skipped, instruction units count: 387
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Payment.InstantPurchase.finishPayment():void");
    }
}
