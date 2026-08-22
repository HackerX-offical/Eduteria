package com.appnew.android.Login.Activity;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.appnew.android.BuildConfig;
import com.appnew.android.ExtensionFunctions.XtensionFunctionKt;
import com.appnew.android.FacebookEventLogger;
import com.appnew.android.Login.Fragment.Login;
import com.appnew.android.Login.Fragment.LoginWithOtpFragment;
import com.appnew.android.Login.Fragment.SignUp;
import com.appnew.android.Login.Fragment.otpverification;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.CustomContextWrapper;
import com.appnew.android.Utils.DialogUtils;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.LinkDialog;
import com.appnew.android.Utils.MyLocation;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.MainFragment;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Progress;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.cleverTap.AnalyticHelper;
import com.appnew.android.databinding.ActivitySignInBinding;
import com.appnew.android.home.Constants;
import com.clevertap.android.sdk.PushPermissionHandler;
import com.eduteria.app.app.R;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.tv9news.utils.helpers.AnalyticEvents;
import com.tv9news.utils.helpers.AnalyticsConstants;
import cz.msebera.android.httpclient.util.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: SignInActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0005\b\u0007\u0018\u0000 \u0094\u00012\u00020\u00012\u00020\u0002:\u0004\u0093\u0001\u0094\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010`\u001a\u00020a2\b\u0010b\u001a\u0004\u0018\u00010cH\u0014J\b\u0010d\u001a\u00020aH\u0002J\b\u0010e\u001a\u00020aH\u0014J\b\u0010f\u001a\u00020aH\u0002J&\u0010g\u001a\b\u0012\u0004\u0012\u00020B0h2\u0006\u0010i\u001a\u00020B2\u0006\u0010j\u001a\u00020B2\u0006\u0010k\u001a\u00020lH\u0016J(\u0010m\u001a\u00020a2\u0006\u0010n\u001a\u00020o2\u0006\u0010i\u001a\u00020B2\u0006\u0010j\u001a\u00020B2\u0006\u0010p\u001a\u00020@H\u0016J \u0010q\u001a\u00020a2\u0006\u0010r\u001a\u00020B2\u0006\u0010i\u001a\u00020B2\u0006\u0010j\u001a\u00020BH\u0016J\b\u0010s\u001a\u00020aH\u0016J\b\u0010t\u001a\u00020aH\u0016J\"\u0010u\u001a\u00020a2\u0006\u0010v\u001a\u00020D2\u0006\u0010w\u001a\u00020D2\b\u0010x\u001a\u0004\u0018\u00010yH\u0014J\u0010\u0010z\u001a\u00020a2\u0006\u0010{\u001a\u000205H\u0014J\u0006\u0010|\u001a\u00020aJ\u0006\u0010}\u001a\u00020aJ\u000e\u0010~\u001a\u00020a2\u0006\u0010\u007f\u001a\u00020@J\t\u0010\u0080\u0001\u001a\u00020aH\u0016J\t\u0010\u0081\u0001\u001a\u00020aH\u0014J\u0007\u0010\u0082\u0001\u001a\u00020aJ\t\u0010\u0085\u0001\u001a\u00020aH\u0002J\t\u0010\u0089\u0001\u001a\u00020@H\u0002J\u0007\u0010\u008a\u0001\u001a\u00020aJ\t\u0010\u008b\u0001\u001a\u00020@H\u0002J\u0007\u0010\u008c\u0001\u001a\u00020aJ0\u0010\u008d\u0001\u001a\u00020a2\u0006\u0010v\u001a\u00020D2\r\u0010\u008e\u0001\u001a\b\u0012\u0004\u0012\u00020B0\u001e2\b\u0010\u008f\u0001\u001a\u00030\u0090\u0001H\u0016¢\u0006\u0003\u0010\u0091\u0001J\u0011\u0010\u0092\u0001\u001a\u00020a2\u0006\u0010C\u001a\u00020BH\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0018\u00010\u0012R\u00020\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001a\"\u0004\b3\u0010\u001cR\u001c\u00104\u001a\u0004\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0011\u0010:\u001a\u0002058F¢\u0006\u0006\u001a\u0004\b;\u00107R\u001c\u0010<\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001a\"\u0004\b>\u0010\u001cR\u000e\u0010?\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010C\u001a\u00020D8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010E\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010F\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010G\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010H\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001c\u0010I\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0014\u0010N\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010O\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010P\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010Q\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010R\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010S\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010T\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010K\"\u0004\bV\u0010MR\u001a\u0010W\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010K\"\u0004\bY\u0010MR\u001a\u0010Z\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010K\"\u0004\b\\\u0010MR\u0014\u0010]\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010^\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010_\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0083\u0001\u001a\u00030\u0084\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0086\u0001\u001a\u00020a8F¢\u0006\b\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001¨\u0006\u0095\u0001"}, d2 = {"Lcom/appnew/android/Login/Activity/SignInActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/ActivitySignInBinding;", "getBinding", "()Lcom/appnew/android/databinding/ActivitySignInBinding;", "setBinding", "(Lcom/appnew/android/databinding/ActivitySignInBinding;)V", "mprogress", "Lcom/appnew/android/Utils/Progress;", "getMprogress", "()Lcom/appnew/android/Utils/Progress;", "setMprogress", "(Lcom/appnew/android/Utils/Progress;)V", "adapter", "Lcom/appnew/android/Login/Activity/SignInActivity$ViewPagerAdapter;", "getAdapter", "()Lcom/appnew/android/Login/Activity/SignInActivity$ViewPagerAdapter;", "setAdapter", "(Lcom/appnew/android/Login/Activity/SignInActivity$ViewPagerAdapter;)V", "tabLinearLayout", "Landroid/widget/LinearLayout;", "getTabLinearLayout", "()Landroid/widget/LinearLayout;", "setTabLinearLayout", "(Landroid/widget/LinearLayout;)V", "Titles", "", "", "getTitles", "()[Ljava/lang/CharSequence;", "setTitles", "([Ljava/lang/CharSequence;)V", "[Ljava/lang/CharSequence;", "d", "Lcom/appnew/android/Utils/LinkDialog;", "getD", "()Lcom/appnew/android/Utils/LinkDialog;", "setD", "(Lcom/appnew/android/Utils/LinkDialog;)V", "NC", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNC", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNC", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "signInUpLayout", "getSignInUpLayout", "setSignInUpLayout", "_context", "Landroid/content/Context;", "get_context", "()Landroid/content/Context;", "set_context", "(Landroid/content/Context;)V", "activity", "getActivity", "examPrepLayerRV", "getExamPrepLayerRV", "setExamPrepLayerRV", "idDenied", "", "loginMessage", "", Const.NOTIFICATION_CODE, "", "message", "title", "url", Const.MESSAGE_TARGET, "type", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "shareType", "post_id", Const.BANNER_ID, "course_id", "fieldid", "topicid", "testid", "getTestid", "setTestid", "testname", "getTestname", "setTestname", "testquestion", "getTestquestion", "setTestquestion", "tiletype", "tileid", "revertapi", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "mobileVerify", "onStart", "signInCallMethod", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonObject", "Lorg/json/JSONObject;", "showprogress", "ErrorCallBack", "jsonstring", "onDestroy", "onBackPressed", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "attachBaseContext", "newBase", "signUpClick", "signInClick", "setSignInUpLayoutVisibility", "visibility", "onPause", "onResume", "enableLocation", "mLastClickTime1", "", "buildAlertMessageNoGps", "location", "getLocation", "()Lkotlin/Unit;", "checkStoragePerm", "requestStoragePermission", "checkLocationPerm", "requestLocationPermission", "onRequestPermissionsResult", "permissions", "grantResults", "", "(I[Ljava/lang/String;[I)V", "pushEventForPushNotification", "ViewPagerAdapter", "Companion", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SignInActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack {
    private static final int LOCATION_REQUEST_CODE = 3;
    private static final int STORAGE_REQUEST_CODE = 2;
    private static final String TAG = "SignInActivity";
    private static boolean onBackPressClicked;
    private NetworkCall NC;
    private Context _context;
    private ViewPagerAdapter adapter;
    public ActivitySignInBinding binding;
    private LinkDialog d;
    private LinearLayout examPrepLayerRV;
    private boolean idDenied;
    private String loginMessage;
    private long mLastClickTime1;
    private Progress mprogress;
    public int notification_code;
    private LinearLayout signInUpLayout;
    private LinearLayout tabLinearLayout;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private CharSequence[] Titles = {"Sign Up", "Log In"};
    public String message = "";
    public String title = "";
    public String url = "";
    public String message_target = "";
    private String type = "";
    public String shareType = "";
    public String post_id = "";
    public String banner_id = "";
    public String course_id = "";
    public String fieldid = "";
    public String topicid = "";
    private String testid = "";
    private String testname = "";
    private String testquestion = "";
    public String tiletype = "";
    public String tileid = "";
    public String revertapi = "";

    public final ActivitySignInBinding getBinding() {
        ActivitySignInBinding activitySignInBinding = this.binding;
        if (activitySignInBinding != null) {
            return activitySignInBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(ActivitySignInBinding activitySignInBinding) {
        Intrinsics.checkNotNullParameter(activitySignInBinding, "<set-?>");
        this.binding = activitySignInBinding;
    }

    public final Progress getMprogress() {
        return this.mprogress;
    }

    public final void setMprogress(Progress progress) {
        this.mprogress = progress;
    }

    public final ViewPagerAdapter getAdapter() {
        return this.adapter;
    }

    public final void setAdapter(ViewPagerAdapter viewPagerAdapter) {
        this.adapter = viewPagerAdapter;
    }

    public final LinearLayout getTabLinearLayout() {
        return this.tabLinearLayout;
    }

    public final void setTabLinearLayout(LinearLayout linearLayout) {
        this.tabLinearLayout = linearLayout;
    }

    public final CharSequence[] getTitles() {
        return this.Titles;
    }

    public final void setTitles(CharSequence[] charSequenceArr) {
        Intrinsics.checkNotNullParameter(charSequenceArr, "<set-?>");
        this.Titles = charSequenceArr;
    }

    public final LinkDialog getD() {
        return this.d;
    }

    public final void setD(LinkDialog linkDialog) {
        this.d = linkDialog;
    }

    public final NetworkCall getNC() {
        return this.NC;
    }

    public final void setNC(NetworkCall networkCall) {
        this.NC = networkCall;
    }

    public final LinearLayout getSignInUpLayout() {
        return this.signInUpLayout;
    }

    public final void setSignInUpLayout(LinearLayout linearLayout) {
        this.signInUpLayout = linearLayout;
    }

    public final Context get_context() {
        return this._context;
    }

    public final void set_context(Context context) {
        this._context = context;
    }

    public final Context getActivity() {
        Context context = this._context;
        Intrinsics.checkNotNull(context);
        return context;
    }

    public final LinearLayout getExamPrepLayerRV() {
        return this.examPrepLayerRV;
    }

    public final void setExamPrepLayerRV(LinearLayout linearLayout) {
        this.examPrepLayerRV = linearLayout;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final String getTestid() {
        return this.testid;
    }

    public final void setTestid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.testid = str;
    }

    public final String getTestname() {
        return this.testname;
    }

    public final void setTestname(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.testname = str;
    }

    public final String getTestquestion() {
        return this.testquestion;
    }

    public final void setTestquestion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.testquestion = str;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        TextView textView;
        EdgeToEdge.enable$default(this, null, null, 3, null);
        setBinding(ActivitySignInBinding.inflate(getLayoutInflater()));
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(0);
        SignInActivity signInActivity = this;
        Helper.setSystemBarLight(signInActivity);
        Helper.enableScreenShot(signInActivity);
        setContentView(getBinding().getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().getRoot(), new OnApplyWindowInsetsListener() { // from class: com.appnew.android.Login.Activity.SignInActivity$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return SignInActivity.onCreate$lambda$0(this.f$0, view, windowInsetsCompat);
            }
        });
        Helper.setLoginImage(signInActivity, getBinding().loginImage);
        SignInActivity signInActivity2 = this;
        this._context = signInActivity2;
        if (StringsKt.equals(BuildConfig.FLAVOR, "eylinx", true)) {
            int i = (int) ((30 * getBinding().getRoot().getContext().getResources().getDisplayMetrics().density) + 0.5f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.setMargins(i, 0, i, 0);
            getBinding().loginImage.setLayoutParams(layoutParams);
            getBinding().loginImage.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        getWindow().clearFlags(1024);
        getBinding().loginLL.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) ((((getResources().getConfiguration().screenLayout & 15) == 3 ? 350 : (getResources().getConfiguration().screenLayout & 15) == 4 ? 450 : 250) * getResources().getDisplayMetrics().density) + 0.5f)));
        if (getIntent() != null) {
            int intExtra = getIntent().getIntExtra(Const.NOTIFICATION_CODE, 0);
            this.notification_code = intExtra;
            if (intExtra != 0) {
                pushEventForPushNotification(new StringBuilder().append(intExtra).toString());
            }
            this.course_id = getIntent().getStringExtra("course_id");
            this.fieldid = getIntent().getStringExtra("file_id");
            this.topicid = getIntent().getStringExtra(Const.TOPIC_ID);
            this.tiletype = getIntent().getStringExtra(Const.TILE_TYPE);
            this.tileid = getIntent().getStringExtra("tile_id");
            this.revertapi = getIntent().getStringExtra(Const.REVERT_API);
            this.title = getIntent().getStringExtra("title");
            this.message_target = getIntent().getStringExtra(TypedValues.AttributesType.S_TARGET);
            this.url = getIntent().getStringExtra("url");
            this.message = getIntent().getStringExtra("description");
            this.type = getIntent().getStringExtra("type");
            this.shareType = getIntent().getStringExtra(Const.SHARE_TYPE);
            this.post_id = getIntent().getStringExtra("post_id");
            this.banner_id = getIntent().getStringExtra(Const.BANNER_ID);
        }
        Progress progress = new Progress(signInActivity2);
        this.mprogress = progress;
        Intrinsics.checkNotNull(progress);
        progress.setCancelable(false);
        Helper.logUser(signInActivity);
        NetworkCall networkCall = new NetworkCall(this, signInActivity2);
        this.NC = networkCall;
        Intrinsics.checkNotNull(networkCall);
        networkCall.NetworkAPICall(API.API_GET_APP_VERSION, "", false, false);
        this.d = new LinkDialog(signInActivity2);
        if (StringsKt.equals(BuildConfig.FLAVOR, "Testink", true) || StringsKt.equals(BuildConfig.FLAVOR, "thinkssc", true)) {
            if (Build.VERSION.SDK_INT >= 33) {
                Dexter.withContext(signInActivity2).withPermissions("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", PushPermissionHandler.ANDROID_PERMISSION_STRING).withListener(new MultiplePermissionsListener() { // from class: com.appnew.android.Login.Activity.SignInActivity.onCreate.2
                    @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        Intrinsics.checkNotNullParameter(report, "report");
                        if (StringsKt.equals(BuildConfig.FLAVOR, "Testink", true) && StringsKt.equals(BuildConfig.FLAVOR, "thinkssc", true)) {
                            return;
                        }
                        SignInActivity.this.getLocation();
                    }

                    @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        Intrinsics.checkNotNull(token);
                        token.continuePermissionRequest();
                    }
                }).check();
            } else {
                Dexter.withContext(signInActivity2).withPermissions("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE").withListener(new MultiplePermissionsListener() { // from class: com.appnew.android.Login.Activity.SignInActivity.onCreate.3
                    @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        Intrinsics.checkNotNullParameter(report, "report");
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new SignInActivity$onCreate$3$onPermissionsChecked$1(SignInActivity.this, null), 3, null);
                    }

                    @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        Intrinsics.checkNotNull(token);
                        token.continuePermissionRequest();
                    }
                }).check();
            }
        } else if (Build.VERSION.SDK_INT >= 33) {
            Dexter.withContext(signInActivity2).withPermissions("android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", PushPermissionHandler.ANDROID_PERMISSION_STRING).withListener(new MultiplePermissionsListener() { // from class: com.appnew.android.Login.Activity.SignInActivity.onCreate.4
                @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
                public void onPermissionsChecked(MultiplePermissionsReport report) {
                    Intrinsics.checkNotNullParameter(report, "report");
                    if (StringsKt.equals(BuildConfig.FLAVOR, "Testink", true) && StringsKt.equals(BuildConfig.FLAVOR, "thinkssc", true)) {
                        return;
                    }
                    SignInActivity.this.getLocation();
                }

                @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
                public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                    Intrinsics.checkNotNull(token);
                    token.continuePermissionRequest();
                }
            }).check();
        } else {
            Dexter.withContext(signInActivity2).withPermissions("android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE").withListener(new MultiplePermissionsListener() { // from class: com.appnew.android.Login.Activity.SignInActivity.onCreate.5
                @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
                public void onPermissionsChecked(MultiplePermissionsReport report) {
                    Intrinsics.checkNotNullParameter(report, "report");
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new SignInActivity$onCreate$5$onPermissionsChecked$1(SignInActivity.this, null), 3, null);
                }

                @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
                public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                    Intrinsics.checkNotNull(token);
                    token.continuePermissionRequest();
                }
            }).check();
        }
        if (SharedPreference.getInstance().getString(Const.HIDE_SIGNUP).equals("1")) {
            getBinding().signInUpLayout.setVisibility(8);
            TextView textView2 = getBinding().loginMessage;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            RelativeLayout relativeLayout = getBinding().LoginRL;
            Intrinsics.checkNotNull(relativeLayout);
            relativeLayout.setVisibility(0);
        }
        this.examPrepLayerRV = (LinearLayout) findViewById(R.id.activity_sign_in);
        View viewFindViewById = findViewById(R.id.fourFragmentLayout);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.tabLinearLayout = (LinearLayout) viewFindViewById;
        if (SharedPreference.getInstance().getString(Const.LOGIN_MESSAGE).equals("1") && (textView = getBinding().loginMessage) != null) {
            textView.setVisibility(0);
        }
        getBinding().signInTextView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Login.Activity.SignInActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SignInActivity.onCreate$lambda$1(this.f$0, view);
            }
        });
        getBinding().signUpTextView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Login.Activity.SignInActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SignInActivity.onCreate$lambda$2(this.f$0, view);
            }
        });
        if (SharedPreference.getInstance().getString(Const.OTP_LOGIN).equals("1") || StringsKt.equals(SharedPreference.getInstance().getString(Const.GOVERNMENET_ID), "1", true)) {
            mobileVerify();
        } else {
            signInCallMethod();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat onCreate$lambda$0(SignInActivity signInActivity, View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
        v.setPadding(insets2.left, 0, insets2.right, insets2.bottom);
        signInActivity.getBinding().loginLL.setPadding(signInActivity.getBinding().loginLL.getPaddingLeft(), insets2.top, signInActivity.getBinding().loginLL.getPaddingRight(), signInActivity.getBinding().loginLL.getPaddingBottom());
        return insets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(SignInActivity signInActivity, View view) {
        if (SharedPreference.getInstance().getString(Const.LOGIN_MESSAGE).equals("1")) {
            TextView textView = signInActivity.getBinding().loginMessage;
            if (textView != null) {
                textView.setVisibility(0);
            }
        } else {
            TextView textView2 = signInActivity.getBinding().loginMessage;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        }
        signInActivity.signInClick();
        signInActivity.getSupportFragmentManager().beginTransaction().replace(R.id.fourFragmentLayout, new Login()).commit();
        SignInActivity signInActivity2 = signInActivity;
        FacebookEventLogger.logLoginScreen(signInActivity2);
        FacebookEventLogger.logFBLoginButtonCreate(signInActivity2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(SignInActivity signInActivity, View view) {
        TextView textView = signInActivity.getBinding().loginMessage;
        if (textView != null) {
            textView.setVisibility(8);
        }
        signInActivity.signUpClick();
        signInActivity.getSupportFragmentManager().beginTransaction().replace(R.id.fourFragmentLayout, new SignUp()).commit();
        FacebookEventLogger.logRegistrationScreen(signInActivity);
    }

    private final void mobileVerify() {
        setSignInUpLayoutVisibility(false);
        getSupportFragmentManager().beginTransaction().replace(R.id.fourFragmentLayout, LoginWithOtpFragment.INSTANCE.newInstance()).commit();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
    }

    private final void signInCallMethod() {
        if (Intrinsics.areEqual(this.type, Const.SIGNUP)) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fourFragmentLayout, new SignUp()).commit();
        } else if (Intrinsics.areEqual(this.type, Const.SIGNIN)) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fourFragmentLayout, new Login()).commit();
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        Intrinsics.checkNotNullParameter(apitype, "apitype");
        Intrinsics.checkNotNullParameter(typeApi, "typeApi");
        Intrinsics.checkNotNullParameter(service, "service");
        return Intrinsics.areEqual(apitype, API.API_GET_APP_VERSION) ? service.getAppVersion() : service.getAppVersion();
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonObject, String apitype, String typeApi, boolean showprogress) throws JSONException {
        int i;
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(apitype, "apitype");
        Intrinsics.checkNotNullParameter(typeApi, "typeApi");
        if (Intrinsics.areEqual(apitype, API.API_GET_APP_VERSION)) {
            if (Intrinsics.areEqual(jsonObject.optString("status"), "true")) {
                JSONObject jSONObject = jsonObject.getJSONObject("data");
                String strOptString = jSONObject.optString("version");
                String strOptString2 = jSONObject.optString("min_version");
                String strOptString3 = jSONObject.optString("force_update");
                String strOptString4 = jSONObject.optString("break_from");
                String strOptString5 = jSONObject.optString("break_to");
                Intrinsics.checkNotNull(strOptString);
                int i2 = Integer.parseInt(strOptString);
                if (TextUtils.isEmpty(strOptString2)) {
                    i = 0;
                } else {
                    Intrinsics.checkNotNull(strOptString2);
                    i = Integer.parseInt(strOptString2);
                }
                Intrinsics.checkNotNull(strOptString4);
                if (Long.parseLong(strOptString4) < System.currentTimeMillis()) {
                    Intrinsics.checkNotNull(strOptString5);
                    if (Long.parseLong(strOptString5) > System.currentTimeMillis()) {
                        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.app.Activity");
                        Helper.getMaintanaceDialog(this, strOptString4, strOptString5);
                        return;
                    }
                }
                if (StringsKt.equals(strOptString3, "0", true)) {
                    if (StringsKt.equals(Helper.isvisible, "0", true)) {
                        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.app.Activity");
                        SignInActivity signInActivity = this;
                        if (i2 > Helper.getVersionCode(signInActivity) || Helper.getVersionCode(signInActivity) < i) {
                            if (Helper.getVersionCode(signInActivity) < i) {
                                strOptString3 = "1";
                            }
                            Helper.getVersionUpdateDialog(signInActivity, strOptString3);
                            return;
                        }
                        return;
                    }
                    return;
                }
                Helper.isvisible = "0";
                Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.app.Activity");
                SignInActivity signInActivity2 = this;
                if (i2 > Helper.getVersionCode(signInActivity2) || Helper.getVersionCode(signInActivity2) < i) {
                    if (Helper.getVersionCode(signInActivity2) < i) {
                        strOptString3 = "1";
                    }
                    Helper.getVersionUpdateDialog(signInActivity2, strOptString3);
                    return;
                }
                return;
            }
            System.out.println((Object) "");
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        Intrinsics.checkNotNullParameter(jsonstring, "jsonstring");
        Intrinsics.checkNotNullParameter(apitype, "apitype");
        Intrinsics.checkNotNullParameter(typeApi, "typeApi");
        Toast.makeText(this, jsonstring, 0).show();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (getSupportFragmentManager().findFragmentById(R.id.fourFragmentLayout) instanceof Login) {
            Bundle extras = getIntent().getExtras();
            Intrinsics.checkNotNull(extras);
            if (Intrinsics.areEqual(extras.getString(Const.OPEN_WITH), Const.GUEST_OPEN)) {
                finish();
                return;
            }
            if (Constants.forLiveClass) {
                finish();
                return;
            }
            Intent intent = new Intent(this, (Class<?>) LoginCatActivity.class);
            intent.putExtra(Const.FRAG_TYPE, Const.CHANGELANGUAGE);
            intent.setFlags(268468224);
            startActivity(intent);
            finish();
            Helper.activityAnimation(this);
            return;
        }
        if (getSupportFragmentManager().findFragmentById(R.id.fourFragmentLayout) instanceof SignUp) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fourFragmentLayout, new Login()).commit();
            signInClick();
            if (SharedPreference.getInstance().getString(Const.LOGIN_MESSAGE).equals("1")) {
                getBinding().loginMessage.setVisibility(0);
            }
            FacebookEventLogger.logLoginScreen(this);
            return;
        }
        if (getSupportFragmentManager().findFragmentById(R.id.fourFragmentLayout) instanceof LoginWithOtpFragment) {
            finish();
            return;
        }
        getSupportFragmentManager().popBackStack();
        if (onBackPressClicked) {
            setSignInUpLayoutVisibility(false);
        } else {
            setSignInUpLayoutVisibility(true);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Fragment fragmentFindFragmentById = getSupportFragmentManager().findFragmentById(R.id.fourFragmentLayout);
        if ((fragmentFindFragmentById instanceof SignUp) || (fragmentFindFragmentById instanceof otpverification) || (fragmentFindFragmentById instanceof Login)) {
            ((MainFragment) fragmentFindFragmentById).onActivityResult(requestCode, resultCode, data);
        }
    }

    /* JADX INFO: compiled from: SignInActivity.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/appnew/android/Login/Activity/SignInActivity$ViewPagerAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "manager", "Landroidx/fragment/app/FragmentManager;", "pager", "Landroidx/viewpager/widget/ViewPager;", "<init>", "(Lcom/appnew/android/Login/Activity/SignInActivity;Landroidx/fragment/app/FragmentManager;Landroidx/viewpager/widget/ViewPager;)V", "getPager", "()Landroidx/viewpager/widget/ViewPager;", "setPager", "(Landroidx/viewpager/widget/ViewPager;)V", "mFragmentList", "", "Landroidx/fragment/app/Fragment;", "mFragmentTitleList", "", "getItem", Const.POSITION, "", "getCount", "getPageTitle", "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList;
        private final List<String> mFragmentTitleList;
        private ViewPager pager;
        final /* synthetic */ SignInActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewPagerAdapter(SignInActivity signInActivity, FragmentManager fragmentManager, ViewPager pager) {
            super(fragmentManager);
            Intrinsics.checkNotNullParameter(pager, "pager");
            this.this$0 = signInActivity;
            Intrinsics.checkNotNull(fragmentManager);
            this.pager = pager;
            this.mFragmentList = new ArrayList();
            this.mFragmentTitleList = new ArrayList();
        }

        public final ViewPager getPager() {
            return this.pager;
        }

        public final void setPager(ViewPager viewPager) {
            Intrinsics.checkNotNullParameter(viewPager, "<set-?>");
            this.pager = viewPager;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int position) {
            return this.mFragmentList.get(position);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.mFragmentList.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int position) {
            return this.mFragmentTitleList.get(position);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context newBase) {
        Intrinsics.checkNotNullParameter(newBase, "newBase");
        super.attachBaseContext(CustomContextWrapper.wrap(newBase, SharedPreference.getInstance().getString(Const.APP_LANGUAGE)));
    }

    public final void signUpClick() {
        ActivitySignInBinding binding = getBinding();
        TextView signUpTextView = binding.signUpTextView;
        Intrinsics.checkNotNullExpressionValue(signUpTextView, "signUpTextView");
        XtensionFunctionKt.textColour(signUpTextView, R.color.whiteApp);
        SignInActivity signInActivity = this;
        binding.signUpTextView.setBackground(ContextCompat.getDrawable(signInActivity, R.drawable.round_black_bg));
        TextView signInTextView = binding.signInTextView;
        Intrinsics.checkNotNullExpressionValue(signInTextView, "signInTextView");
        XtensionFunctionKt.textColour(signInTextView, R.color.black_overlay);
        binding.signInTextView.setBackground(ContextCompat.getDrawable(signInActivity, R.drawable.round_white_bg));
        setSignInUpLayoutVisibility(true);
    }

    public final void signInClick() {
        ActivitySignInBinding binding = getBinding();
        TextView signInTextView = binding.signInTextView;
        Intrinsics.checkNotNullExpressionValue(signInTextView, "signInTextView");
        XtensionFunctionKt.textColour(signInTextView, R.color.whiteApp);
        SignInActivity signInActivity = this;
        binding.signInTextView.setBackground(ContextCompat.getDrawable(signInActivity, R.drawable.round_black_bg));
        TextView signUpTextView = binding.signUpTextView;
        Intrinsics.checkNotNullExpressionValue(signUpTextView, "signUpTextView");
        XtensionFunctionKt.textColour(signUpTextView, R.color.black_overlay);
        binding.signUpTextView.setBackground(ContextCompat.getDrawable(signInActivity, R.drawable.round_white_bg));
        setSignInUpLayoutVisibility(true);
    }

    public final void setSignInUpLayoutVisibility(boolean visibility) {
        if (visibility) {
            LinearLayout signInUpLayout = getBinding().signInUpLayout;
            Intrinsics.checkNotNullExpressionValue(signInUpLayout, "signInUpLayout");
            XtensionFunctionKt.visible(signInUpLayout);
        } else {
            LinearLayout signInUpLayout2 = getBinding().signInUpLayout;
            Intrinsics.checkNotNullExpressionValue(signInUpLayout2, "signInUpLayout");
            XtensionFunctionKt.gone(signInUpLayout2);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        String simpleName = getClass().getSimpleName();
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME, simpleName);
        FacebookEventLogger.logEvent(this, "Screen_Viewed", bundle);
    }

    public final void enableLocation() {
        if (!checkLocationPerm()) {
            if (this.idDenied) {
                return;
            }
            requestLocationPermission();
            return;
        }
        getLocation();
    }

    private final void buildAlertMessageNoGps() {
        try {
            String string = getActivity().getResources().getString(R.string.your_gps_seems_to_be_disabled_do_you_want_to_enable_it);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            DialogUtils.makeDialog(this, getActivity().getResources().getString(R.string.app_name), string, getActivity().getResources().getString(R.string.allow), getActivity().getResources().getString(R.string.dont_allow), false, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Login.Activity.SignInActivity$$ExternalSyntheticLambda3
                @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
                public final void onOKClick() {
                    SignInActivity.buildAlertMessageNoGps$lambda$6(this.f$0);
                }
            }, new DialogUtils.onDialogUtilsCancelClick() { // from class: com.appnew.android.Login.Activity.SignInActivity$$ExternalSyntheticLambda4
                @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsCancelClick
                public final void onCancelClick() {
                    SignInActivity.buildAlertMessageNoGps$lambda$7(this.f$0);
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buildAlertMessageNoGps$lambda$6(SignInActivity signInActivity) {
        if (SystemClock.elapsedRealtime() - signInActivity.mLastClickTime1 < 1000) {
            return;
        }
        signInActivity.mLastClickTime1 = SystemClock.elapsedRealtime();
        signInActivity.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buildAlertMessageNoGps$lambda$7(SignInActivity signInActivity) {
        if (SystemClock.elapsedRealtime() - signInActivity.mLastClickTime1 < 1000) {
            return;
        }
        signInActivity.mLastClickTime1 = SystemClock.elapsedRealtime();
    }

    public final Unit getLocation() {
        Object systemService = getSystemService("location");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        LocationManager locationManager = (LocationManager) systemService;
        if (!locationManager.isProviderEnabled("gps") && !locationManager.isProviderEnabled("network")) {
            buildAlertMessageNoGps();
        } else {
            Object systemService2 = getApplicationContext().getSystemService(com.clevertap.android.sdk.Constants.CLTAP_CONNECTED_TO_WIFI);
            Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.net.wifi.WifiManager");
            new MyLocation().getLocation(this, new MyLocation.LocationResult() { // from class: com.appnew.android.Login.Activity.SignInActivity$location$locationResult$1
                @Override // com.appnew.android.Utils.MyLocation.LocationResult
                public void gotLocation(Location location) {
                    Double dValueOf = location != null ? Double.valueOf(location.getLatitude()) : null;
                    Double dValueOf2 = location != null ? Double.valueOf(location.getLongitude()) : null;
                    SharedPreference.getInstance().putString(Const.LOCATION_LAT, new StringBuilder().append(dValueOf).toString());
                    SharedPreference.getInstance().putString(Const.LOCATION_LNG, new StringBuilder().append(dValueOf2).toString());
                }
            });
        }
        return Unit.INSTANCE;
    }

    private final boolean checkStoragePerm() {
        SignInActivity signInActivity = this;
        return ContextCompat.checkSelfPermission(signInActivity, "android.permission.READ_EXTERNAL_STORAGE") == 0 && ContextCompat.checkSelfPermission(signInActivity, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public final void requestStoragePermission() {
        if (shouldShowRequestPermissionRationale("android.permission.READ_EXTERNAL_STORAGE") || shouldShowRequestPermissionRationale("android.permission.WRITE_EXTERNAL_STORAGE")) {
            requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 2);
        } else {
            requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 2);
        }
    }

    private final boolean checkLocationPerm() {
        SignInActivity signInActivity = this;
        return ContextCompat.checkSelfPermission(signInActivity, "android.permission.ACCESS_FINE_LOCATION") == 0 && ContextCompat.checkSelfPermission(signInActivity, "android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    public final void requestLocationPermission() {
        if (shouldShowRequestPermissionRationale("android.permission.ACCESS_FINE_LOCATION") || shouldShowRequestPermissionRationale("android.permission.ACCESS_COARSE_LOCATION")) {
            requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 3);
        } else {
            requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 3);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /* JADX INFO: compiled from: SignInActivity.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/appnew/android/Login/Activity/SignInActivity$Companion;", "", "<init>", "()V", "TAG", "", "onBackPressClicked", "", "getOnBackPressClicked", "()Z", "setOnBackPressClicked", "(Z)V", "STORAGE_REQUEST_CODE", "", "LOCATION_REQUEST_CODE", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getOnBackPressClicked() {
            return SignInActivity.onBackPressClicked;
        }

        public final void setOnBackPressClicked(boolean z) {
            SignInActivity.onBackPressClicked = z;
        }
    }

    private final void pushEventForPushNotification(String notification_code) {
        HashMap<String, Object> map = new HashMap<>();
        HashMap<String, Object> map2 = map;
        map2.put("user_id", AnalyticHelper.INSTANCE.getUserId());
        if (android.text.TextUtils.isEmpty(notification_code)) {
            notification_code = "NA";
        }
        map2.put(AnalyticsConstants.push_preview, notification_code);
        map2.put("action_type", "notification_clicked");
        AnalyticEvents.INSTANCE.pushEvents(this, AnalyticsConstants.PUSH_NOTIFICATION, map);
    }
}
