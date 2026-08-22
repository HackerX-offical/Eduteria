package com.appnew.android.loginRevamp.Activity;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.appnew.android.BuildConfig;
import com.appnew.android.FacebookEventLogger;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.CustomContextWrapper;
import com.appnew.android.Utils.DialogUtils;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.LinkDialog;
import com.appnew.android.Utils.MyLocation;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Progress;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.cleverTap.AnalyticHelper;
import com.appnew.android.databinding.ActivitySignInNewBinding;
import com.appnew.android.home.Constants;
import com.appnew.android.loginRevamp.Fragment.LoginFragmentNew;
import com.appnew.android.loginRevamp.Fragment.otpverificationnew;
import com.clevertap.android.sdk.PushPermissionHandler;
import com.eduteria.app.app.R;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: SignInNewActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\b\u0007\u0018\u0000 \u0080\u00012\u00020\u00012\u00020\u0002:\u0003\u007f\u0080\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010Q\u001a\u00020R2\b\u0010S\u001a\u0004\u0018\u00010TH\u0014J\u0006\u0010U\u001a\u00020RJ\b\u0010V\u001a\u00020RH\u0014J&\u0010W\u001a\b\u0012\u0004\u0012\u0002060X2\u0006\u0010Y\u001a\u0002062\u0006\u0010Z\u001a\u0002062\u0006\u0010[\u001a\u00020\\H\u0016J(\u0010]\u001a\u00020R2\u0006\u0010^\u001a\u00020_2\u0006\u0010Y\u001a\u0002062\u0006\u0010Z\u001a\u0002062\u0006\u0010`\u001a\u000202H\u0016J \u0010a\u001a\u00020R2\u0006\u0010b\u001a\u0002062\u0006\u0010Y\u001a\u0002062\u0006\u0010Z\u001a\u000206H\u0016J\b\u0010c\u001a\u00020RH\u0016J\"\u0010d\u001a\u00020R2\u0006\u0010e\u001a\u0002042\u0006\u0010f\u001a\u0002042\b\u0010g\u001a\u0004\u0018\u00010hH\u0014J\u0010\u0010i\u001a\u00020R2\u0006\u0010j\u001a\u00020*H\u0014J\b\u0010k\u001a\u00020RH\u0016J\b\u0010l\u001a\u00020RH\u0014J\u0006\u0010m\u001a\u00020RJ\b\u0010p\u001a\u00020RH\u0002J\b\u0010t\u001a\u000202H\u0002J\u0006\u0010u\u001a\u00020RJ\b\u0010v\u001a\u000202H\u0002J\u0006\u0010w\u001a\u00020RJ+\u0010x\u001a\u00020R2\u0006\u0010e\u001a\u0002042\f\u0010y\u001a\b\u0012\u0004\u0012\u0002060z2\u0006\u0010{\u001a\u00020|H\u0016¢\u0006\u0002\u0010}J\u0010\u0010~\u001a\u00020R2\u0006\u00103\u001a\u000206H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0018\u00010\u0012R\u00020\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0011\u0010/\u001a\u00020*8F¢\u0006\u0006\u001a\u0004\b0\u0010,R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00103\u001a\u0002048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00107\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001c\u0010:\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0014\u0010?\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010A\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010B\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010C\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010D\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010E\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010<\"\u0004\bG\u0010>R\u001a\u0010H\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010<\"\u0004\bJ\u0010>R\u001a\u0010K\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010<\"\u0004\bM\u0010>R\u0014\u0010N\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010O\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010P\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020oX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010q\u001a\u00020R8F¢\u0006\u0006\u001a\u0004\br\u0010s¨\u0006\u0081\u0001"}, d2 = {"Lcom/appnew/android/loginRevamp/Activity/SignInNewActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/ActivitySignInNewBinding;", "getBinding", "()Lcom/appnew/android/databinding/ActivitySignInNewBinding;", "setBinding", "(Lcom/appnew/android/databinding/ActivitySignInNewBinding;)V", "mprogress", "Lcom/appnew/android/Utils/Progress;", "getMprogress", "()Lcom/appnew/android/Utils/Progress;", "setMprogress", "(Lcom/appnew/android/Utils/Progress;)V", "adapter", "Lcom/appnew/android/loginRevamp/Activity/SignInNewActivity$ViewPagerAdapter;", "getAdapter", "()Lcom/appnew/android/loginRevamp/Activity/SignInNewActivity$ViewPagerAdapter;", "setAdapter", "(Lcom/appnew/android/loginRevamp/Activity/SignInNewActivity$ViewPagerAdapter;)V", "tabLinearLayout", "Landroid/widget/LinearLayout;", "getTabLinearLayout", "()Landroid/widget/LinearLayout;", "setTabLinearLayout", "(Landroid/widget/LinearLayout;)V", "d", "Lcom/appnew/android/Utils/LinkDialog;", "getD", "()Lcom/appnew/android/Utils/LinkDialog;", "setD", "(Lcom/appnew/android/Utils/LinkDialog;)V", "NC", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNC", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNC", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "activity", "getActivity", "idDenied", "", Const.NOTIFICATION_CODE, "", "message", "", "title", "url", Const.MESSAGE_TARGET, "type", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "shareType", "post_id", Const.BANNER_ID, "course_id", "fieldid", "topicid", "testid", "getTestid", "setTestid", "testname", "getTestname", "setTestname", "testquestion", "getTestquestion", "setTestquestion", "tiletype", "tileid", "revertapi", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "mobileVerify", "onStart", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonObject", "Lorg/json/JSONObject;", "showprogress", "ErrorCallBack", "jsonstring", "onDestroy", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "attachBaseContext", "newBase", "onPause", "onResume", "enableLocation", "mLastClickTime1", "", "buildAlertMessageNoGps", "location", "getLocation", "()Lkotlin/Unit;", "checkStoragePerm", "requestStoragePermission", "checkLocationPerm", "requestLocationPermission", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "pushEventForPushNotification", "ViewPagerAdapter", "Companion", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SignInNewActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack {
    private static final int LOCATION_REQUEST_CODE = 3;
    private static final int STORAGE_REQUEST_CODE = 2;
    private static final String TAG = "SignInActivity";
    private NetworkCall NC;
    private ViewPagerAdapter adapter;
    public ActivitySignInNewBinding binding;
    private Context context;
    private LinkDialog d;
    private boolean idDenied;
    private long mLastClickTime1;
    private Progress mprogress;
    public int notification_code;
    private LinearLayout tabLinearLayout;
    public static final int $stable = 8;
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

    public final ActivitySignInNewBinding getBinding() {
        ActivitySignInNewBinding activitySignInNewBinding = this.binding;
        if (activitySignInNewBinding != null) {
            return activitySignInNewBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(ActivitySignInNewBinding activitySignInNewBinding) {
        Intrinsics.checkNotNullParameter(activitySignInNewBinding, "<set-?>");
        this.binding = activitySignInNewBinding;
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

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context) {
        this.context = context;
    }

    public final Context getActivity() {
        Context context = this.context;
        Intrinsics.checkNotNull(context);
        return context;
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
        setBinding(ActivitySignInNewBinding.inflate(getLayoutInflater()));
        super.onCreate(savedInstanceState);
        SignInNewActivity signInNewActivity = this;
        Helper.setSystemBarLight(signInNewActivity);
        Helper.enableScreenShot(signInNewActivity);
        setContentView(getBinding().getRoot());
        SignInNewActivity signInNewActivity2 = this;
        this.context = signInNewActivity2;
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback() { // from class: com.appnew.android.loginRevamp.Activity.SignInNewActivity.onCreate.1
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                handleBackPressed();
            }

            private final void handleBackPressed() {
                Fragment fragmentFindFragmentById = SignInNewActivity.this.getSupportFragmentManager().findFragmentById(R.id.fourFragmentLayout);
                if (fragmentFindFragmentById instanceof LoginFragmentNew) {
                    if (Intrinsics.areEqual(((LoginFragmentNew) fragmentFindFragmentById).getIsUserRegistered(), "1")) {
                        SignInNewActivity.this.mobileVerify();
                        FacebookEventLogger.logLoginScreen(SignInNewActivity.this);
                        return;
                    } else {
                        SignInNewActivity.this.finish();
                        return;
                    }
                }
                SignInNewActivity.this.getSupportFragmentManager().popBackStack();
            }
        });
        if (Build.VERSION.SDK_INT == 36) {
            Window window = getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
            LinearLayout root = getBinding().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            EdgeToEdgeHelperOld.applyInsets(signInNewActivity2, window, root, false, null);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linMain);
            LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.fourFragmentLayout);
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.weight = 3.0f;
            linearLayout.setLayoutParams(layoutParams2);
            ViewGroup.LayoutParams layoutParams3 = linearLayout2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
            layoutParams4.weight = 7.0f;
            linearLayout2.setLayoutParams(layoutParams4);
        }
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
        Progress progress = new Progress(signInNewActivity2);
        this.mprogress = progress;
        Intrinsics.checkNotNull(progress);
        progress.setCancelable(false);
        Helper.logUser(signInNewActivity);
        NetworkCall networkCall = new NetworkCall(this, signInNewActivity2);
        this.NC = networkCall;
        Intrinsics.checkNotNull(networkCall);
        networkCall.NetworkAPICall(API.API_GET_APP_VERSION, "", false, false);
        this.d = new LinkDialog(signInNewActivity2);
        if (StringsKt.equals(BuildConfig.FLAVOR, "Testink", true) || StringsKt.equals(BuildConfig.FLAVOR, "thinkssc", true)) {
            if (Build.VERSION.SDK_INT >= 33) {
                Dexter.withContext(signInNewActivity2).withPermissions("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", PushPermissionHandler.ANDROID_PERMISSION_STRING).withListener(new MultiplePermissionsListener() { // from class: com.appnew.android.loginRevamp.Activity.SignInNewActivity.onCreate.2
                    @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        Intrinsics.checkNotNullParameter(report, "report");
                        if (StringsKt.equals(BuildConfig.FLAVOR, "Testink", true) && StringsKt.equals(BuildConfig.FLAVOR, "thinkssc", true)) {
                            return;
                        }
                        SignInNewActivity.this.getLocation();
                    }

                    @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        Intrinsics.checkNotNull(token);
                        token.continuePermissionRequest();
                    }
                }).check();
            } else {
                Dexter.withContext(signInNewActivity2).withPermissions("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE").withListener(new MultiplePermissionsListener() { // from class: com.appnew.android.loginRevamp.Activity.SignInNewActivity.onCreate.3
                    @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        Intrinsics.checkNotNullParameter(report, "report");
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new SignInNewActivity$onCreate$3$onPermissionsChecked$1(SignInNewActivity.this, null), 3, null);
                    }

                    @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        Intrinsics.checkNotNull(token);
                        token.continuePermissionRequest();
                    }
                }).check();
            }
        } else if (Build.VERSION.SDK_INT >= 33) {
            Dexter.withContext(signInNewActivity2).withPermissions("android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", PushPermissionHandler.ANDROID_PERMISSION_STRING).withListener(new MultiplePermissionsListener() { // from class: com.appnew.android.loginRevamp.Activity.SignInNewActivity.onCreate.4
                @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
                public void onPermissionsChecked(MultiplePermissionsReport report) {
                    Intrinsics.checkNotNullParameter(report, "report");
                    if (StringsKt.equals(BuildConfig.FLAVOR, "Testink", true) && StringsKt.equals(BuildConfig.FLAVOR, "thinkssc", true)) {
                        return;
                    }
                    SignInNewActivity.this.getLocation();
                }

                @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
                public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                    Intrinsics.checkNotNull(token);
                    token.continuePermissionRequest();
                }
            }).check();
        } else {
            Dexter.withContext(signInNewActivity2).withPermissions("android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE").withListener(new MultiplePermissionsListener() { // from class: com.appnew.android.loginRevamp.Activity.SignInNewActivity.onCreate.5
                @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
                public void onPermissionsChecked(MultiplePermissionsReport report) {
                    Intrinsics.checkNotNullParameter(report, "report");
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new SignInNewActivity$onCreate$5$onPermissionsChecked$1(SignInNewActivity.this, null), 3, null);
                }

                @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
                public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                    Intrinsics.checkNotNull(token);
                    token.continuePermissionRequest();
                }
            }).check();
        }
        View viewFindViewById = findViewById(R.id.fourFragmentLayout);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.tabLinearLayout = (LinearLayout) viewFindViewById;
        mobileVerify();
    }

    public final void mobileVerify() {
        try {
            getSupportFragmentManager().beginTransaction().replace(R.id.fourFragmentLayout, new LoginFragmentNew()).commitAllowingStateLoss();
            FacebookEventLogger.logLoginScreen(this);
        } catch (Exception e2) {
            Log.d("SignInNewActivity", "Error: " + e2.getMessage());
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
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
                        SignInNewActivity signInNewActivity = this;
                        if (i2 > Helper.getVersionCode(signInNewActivity) || Helper.getVersionCode(signInNewActivity) < i) {
                            if (Helper.getVersionCode(signInNewActivity) < i) {
                                strOptString3 = "1";
                            }
                            Helper.getVersionUpdateDialog(signInNewActivity, strOptString3);
                            return;
                        }
                        return;
                    }
                    return;
                }
                Helper.isvisible = "0";
                Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.app.Activity");
                SignInNewActivity signInNewActivity2 = this;
                if (i2 > Helper.getVersionCode(signInNewActivity2) || Helper.getVersionCode(signInNewActivity2) < i) {
                    if (Helper.getVersionCode(signInNewActivity2) < i) {
                        strOptString3 = "1";
                    }
                    Helper.getVersionUpdateDialog(signInNewActivity2, strOptString3);
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
        Constants.LAST_MOBILE_NUMBER = "";
        Constants.LAST_EMAIL_ID = "";
        Constants.isEmailDefault = false;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Fragment fragmentFindFragmentById = getSupportFragmentManager().findFragmentById(R.id.fourFragmentLayout);
        if (fragmentFindFragmentById instanceof otpverificationnew) {
            ((otpverificationnew) fragmentFindFragmentById).onActivityResult(requestCode, resultCode, data);
        }
    }

    /* JADX INFO: compiled from: SignInNewActivity.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/appnew/android/loginRevamp/Activity/SignInNewActivity$ViewPagerAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "manager", "Landroidx/fragment/app/FragmentManager;", "pager", "Landroidx/viewpager/widget/ViewPager;", "<init>", "(Lcom/appnew/android/loginRevamp/Activity/SignInNewActivity;Landroidx/fragment/app/FragmentManager;Landroidx/viewpager/widget/ViewPager;)V", "getPager", "()Landroidx/viewpager/widget/ViewPager;", "setPager", "(Landroidx/viewpager/widget/ViewPager;)V", "mFragmentList", "", "Landroidx/fragment/app/Fragment;", "mFragmentTitleList", "", "getItem", Const.POSITION, "", "getCount", "getPageTitle", "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList;
        private final List<String> mFragmentTitleList;
        private ViewPager pager;
        final /* synthetic */ SignInNewActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewPagerAdapter(SignInNewActivity signInNewActivity, FragmentManager fragmentManager, ViewPager pager) {
            super(fragmentManager);
            Intrinsics.checkNotNullParameter(pager, "pager");
            this.this$0 = signInNewActivity;
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

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
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
            DialogUtils.makeDialog(this, getActivity().getResources().getString(R.string.app_name), string, getActivity().getResources().getString(R.string.allow), getActivity().getResources().getString(R.string.dont_allow), false, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.loginRevamp.Activity.SignInNewActivity$$ExternalSyntheticLambda0
                @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
                public final void onOKClick() {
                    SignInNewActivity.buildAlertMessageNoGps$lambda$0(this.f$0);
                }
            }, new DialogUtils.onDialogUtilsCancelClick() { // from class: com.appnew.android.loginRevamp.Activity.SignInNewActivity$$ExternalSyntheticLambda1
                @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsCancelClick
                public final void onCancelClick() {
                    SignInNewActivity.buildAlertMessageNoGps$lambda$1(this.f$0);
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buildAlertMessageNoGps$lambda$0(SignInNewActivity signInNewActivity) {
        if (SystemClock.elapsedRealtime() - signInNewActivity.mLastClickTime1 < 1000) {
            return;
        }
        signInNewActivity.mLastClickTime1 = SystemClock.elapsedRealtime();
        signInNewActivity.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buildAlertMessageNoGps$lambda$1(SignInNewActivity signInNewActivity) {
        if (SystemClock.elapsedRealtime() - signInNewActivity.mLastClickTime1 < 1000) {
            return;
        }
        signInNewActivity.mLastClickTime1 = SystemClock.elapsedRealtime();
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
            new MyLocation().getLocation(this, new MyLocation.LocationResult() { // from class: com.appnew.android.loginRevamp.Activity.SignInNewActivity$location$locationResult$1
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
        SignInNewActivity signInNewActivity = this;
        return ContextCompat.checkSelfPermission(signInNewActivity, "android.permission.READ_EXTERNAL_STORAGE") == 0 && ContextCompat.checkSelfPermission(signInNewActivity, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public final void requestStoragePermission() {
        if (shouldShowRequestPermissionRationale("android.permission.READ_EXTERNAL_STORAGE") || shouldShowRequestPermissionRationale("android.permission.WRITE_EXTERNAL_STORAGE")) {
            requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 2);
        } else {
            requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 2);
        }
    }

    private final boolean checkLocationPerm() {
        SignInNewActivity signInNewActivity = this;
        return ContextCompat.checkSelfPermission(signInNewActivity, "android.permission.ACCESS_FINE_LOCATION") == 0 && ContextCompat.checkSelfPermission(signInNewActivity, "android.permission.ACCESS_COARSE_LOCATION") == 0;
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
