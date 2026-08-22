package com.appnew.android.Login.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.NotificationCompat;
import androidx.core.net.MailTo;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.EncryptionModel.LocationInfo;
import com.appnew.android.ExtensionFunctions.XtensionFunctionKt;
import com.appnew.android.Login.Activity.LoginCatActivity;
import com.appnew.android.Model.User;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.EmojiFilter;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.MainFragment;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.firebaseToken.FCMTokenHelper;
import com.appnew.android.Utils.firebaseToken.UserInfo;
import com.appnew.android.databinding.IbtFragmentLoginBinding;
import com.appnew.android.feeds.ExtensionFucationKt;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;
import com.hbb20.CountryCodePicker;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import retrofit2.Call;

/* JADX INFO: compiled from: Login.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J$\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\b\u0010S\u001a\u0004\u0018\u00010T2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\b\u0010U\u001a\u00020LH\u0016J\u001a\u0010V\u001a\u00020L2\u0006\u0010W\u001a\u00020P2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\b\u0010X\u001a\u00020LH\u0002J\u000e\u0010Y\u001a\u00020L2\u0006\u0010Z\u001a\u000205J\u0010\u0010[\u001a\u00020L2\u0006\u0010\\\u001a\u000205H\u0002J\b\u0010c\u001a\u00020LH\u0002J&\u0010d\u001a\b\u0012\u0004\u0012\u00020\u000b0e2\u0006\u0010f\u001a\u00020\u000b2\u0006\u0010g\u001a\u00020\u000b2\u0006\u0010h\u001a\u00020iH\u0016J(\u0010j\u001a\u00020L2\u0006\u0010k\u001a\u00020l2\u0006\u0010f\u001a\u00020\u000b2\u0006\u0010g\u001a\u00020\u000b2\u0006\u0010m\u001a\u000205H\u0016J \u0010n\u001a\u00020L2\u0006\u0010o\u001a\u00020\u000b2\u0006\u0010f\u001a\u00020\u000b2\u0006\u0010g\u001a\u00020\u000bH\u0016J\"\u0010p\u001a\u00020L2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010q\u001a\u00020\u001f2\b\u0010r\u001a\u0004\u0018\u00010_H\u0016J\u0012\u0010s\u001a\u00020L2\b\u0010t\u001a\u0004\u0018\u00010uH\u0002J\u0010\u0010v\u001a\u00020L2\u0006\u0010t\u001a\u00020uH\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000fR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\r\"\u0004\b,\u0010\u000fR\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u000e\u00103\u001a\u00020\u001fX\u0082D¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00106\"\u0004\b:\u00108R\u001a\u0010;\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00106\"\u0004\b<\u00108R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010?\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u00106\"\u0004\bA\u00108R\u001a\u0010B\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\r\"\u0004\bD\u0010\u000fR\u001a\u0010E\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u00106\"\u0004\bG\u00108R\u001a\u0010H\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\r\"\u0004\bJ\u0010\u000fR\u001f\u0010]\u001a\u0010\u0012\f\u0012\n `*\u0004\u0018\u00010_0_0^¢\u0006\b\n\u0000\u001a\u0004\ba\u0010b¨\u0006w"}, d2 = {"Lcom/appnew/android/Login/Fragment/Login;", "Lcom/appnew/android/Utils/Network/MainFragment;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/IbtFragmentLoginBinding;", "getBinding", "()Lcom/appnew/android/databinding/IbtFragmentLoginBinding;", "setBinding", "(Lcom/appnew/android/databinding/IbtFragmentLoginBinding;)V", Const.MOBILE, "", "getMobile", "()Ljava/lang/String;", "setMobile", "(Ljava/lang/String;)V", "rollNumber", "getRollNumber", "setRollNumber", "password", "getPassword", "setPassword", "socialToken", "getSocialToken", "setSocialToken", Constants.DEVICE_ID_TAG, "getDeviceId", "setDeviceId", "isSocial", "setSocial", "requestCode", "", "getRequestCode", "()I", "setRequestCode", "(I)V", "user", "Lcom/appnew/android/Model/User;", "getUser", "()Lcom/appnew/android/Model/User;", "setUser", "(Lcom/appnew/android/Model/User;)V", "socialType", "getSocialType", "setSocialType", "utkashRoom", "Lcom/appnew/android/Room/UtkashRoom;", "getUtkashRoom", "()Lcom/appnew/android/Room/UtkashRoom;", "setUtkashRoom", "(Lcom/appnew/android/Room/UtkashRoom;)V", "RC_SIGN_IN", Const.IS_GOOGLE_LOGIN_ENABLE, "", "()Z", "set_google_login_enable", "(Z)V", "is_show_email", "set_show_email", "isSocialLoginAttempt", "setSocialLoginAttempt", "googleApiClient", "Lcom/google/android/gms/common/api/GoogleApiClient;", "numberValidateStatus", "getNumberValidateStatus", "setNumberValidateStatus", "c_code", "getC_code", "setC_code", UserDataStore.COUNTRY, "getCountry", "setCountry", "deviceTokenNew", "getDeviceTokenNew", "setDeviceTokenNew", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onResume", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "showEmailOrMobile", "CheckValidation", "isGuest", "callLoginAPi", "isDataValid", "otpLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "getOtpLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "hitApiLoginAuthentication", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonObject", "Lorg/json/JSONObject;", "showprogress", "ErrorCallBack", "jsonstring", "onActivityResult", "resultCode", "data", "handleSignInResult", "result", "Lcom/google/android/gms/auth/api/signin/GoogleSignInResult;", "handleDeviceTokenBeforeSignIn", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Login extends MainFragment {
    public static final int $stable = 8;
    public IbtFragmentLoginBinding binding;
    public String c_code;
    private boolean country;
    private String deviceId;
    private GoogleApiClient googleApiClient;
    private String isSocial;
    private boolean isSocialLoginAttempt;
    private boolean is_google_login_enable;
    private boolean is_show_email;
    private boolean numberValidateStatus;
    private final ActivityResultLauncher<Intent> otpLauncher;
    private String password;
    private String socialType;
    private User user;
    private UtkashRoom utkashRoom;
    private String mobile = "";
    private String rollNumber = "";
    private String socialToken = "12345678";
    private int requestCode = -1;
    private final int RC_SIGN_IN = 1;
    private String deviceTokenNew = "";

    public Login() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.Login.Fragment.Login$$ExternalSyntheticLambda1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                Login.otpLauncher$lambda$19(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.otpLauncher = activityResultLauncherRegisterForActivityResult;
    }

    public final IbtFragmentLoginBinding getBinding() {
        IbtFragmentLoginBinding ibtFragmentLoginBinding = this.binding;
        if (ibtFragmentLoginBinding != null) {
            return ibtFragmentLoginBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(IbtFragmentLoginBinding ibtFragmentLoginBinding) {
        Intrinsics.checkNotNullParameter(ibtFragmentLoginBinding, "<set-?>");
        this.binding = ibtFragmentLoginBinding;
    }

    public final String getMobile() {
        return this.mobile;
    }

    public final void setMobile(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mobile = str;
    }

    public final String getRollNumber() {
        return this.rollNumber;
    }

    public final void setRollNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rollNumber = str;
    }

    public final String getPassword() {
        return this.password;
    }

    public final void setPassword(String str) {
        this.password = str;
    }

    public final String getSocialToken() {
        return this.socialToken;
    }

    public final void setSocialToken(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.socialToken = str;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final void setDeviceId(String str) {
        this.deviceId = str;
    }

    /* JADX INFO: renamed from: isSocial, reason: from getter */
    public final String getIsSocial() {
        return this.isSocial;
    }

    public final void setSocial(String str) {
        this.isSocial = str;
    }

    public final int getRequestCode() {
        return this.requestCode;
    }

    public final void setRequestCode(int i) {
        this.requestCode = i;
    }

    public final User getUser() {
        return this.user;
    }

    public final void setUser(User user) {
        this.user = user;
    }

    public final String getSocialType() {
        return this.socialType;
    }

    public final void setSocialType(String str) {
        this.socialType = str;
    }

    public final UtkashRoom getUtkashRoom() {
        return this.utkashRoom;
    }

    public final void setUtkashRoom(UtkashRoom utkashRoom) {
        this.utkashRoom = utkashRoom;
    }

    /* JADX INFO: renamed from: is_google_login_enable, reason: from getter */
    public final boolean getIs_google_login_enable() {
        return this.is_google_login_enable;
    }

    public final void set_google_login_enable(boolean z) {
        this.is_google_login_enable = z;
    }

    /* JADX INFO: renamed from: is_show_email, reason: from getter */
    public final boolean getIs_show_email() {
        return this.is_show_email;
    }

    public final void set_show_email(boolean z) {
        this.is_show_email = z;
    }

    /* JADX INFO: renamed from: isSocialLoginAttempt, reason: from getter */
    public final boolean getIsSocialLoginAttempt() {
        return this.isSocialLoginAttempt;
    }

    public final void setSocialLoginAttempt(boolean z) {
        this.isSocialLoginAttempt = z;
    }

    public final boolean getNumberValidateStatus() {
        return this.numberValidateStatus;
    }

    public final void setNumberValidateStatus(boolean z) {
        this.numberValidateStatus = z;
    }

    public final String getC_code() {
        String str = this.c_code;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("c_code");
        return null;
    }

    public final void setC_code(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.c_code = str;
    }

    public final boolean getCountry() {
        return this.country;
    }

    public final void setCountry(boolean z) {
        this.country = z;
    }

    public final String getDeviceTokenNew() {
        return this.deviceTokenNew;
    }

    public final void setDeviceTokenNew(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deviceTokenNew = str;
    }

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.activity = getActivity();
        this.utkashRoom = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        this.is_google_login_enable = StringsKt.equals(SharedPreference.getInstance().getString(Const.IS_GOOGLE_LOGIN_ENABLE), "1", true);
        this.is_show_email = StringsKt.equals(SharedPreference.getInstance().getString(Const.EMAIL_SHOW), "1", true);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        setBinding(IbtFragmentLoginBinding.inflate(inflater, container, false));
        NestedScrollView root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.activity = getActivity();
        getBinding().etRollNumber.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(20)});
        Window window = requireActivity().getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        if (SharedPreference.getInstance().getString(Const.SHOW_ROLL_NUMBER) != null && StringsKt.equals(SharedPreference.getInstance().getString(Const.SHOW_ROLL_NUMBER), "1", true)) {
            EditText editText = getBinding().etRollNumber;
            if (editText != null) {
                editText.setVisibility(0);
            }
        } else {
            EditText editText2 = getBinding().etRollNumber;
            if (editText2 != null) {
                editText2.setVisibility(8);
            }
        }
        this.deviceId = Settings.Secure.getString(this.activity.getContentResolver(), "android_id");
        getBinding().etPassword.setFilters(EmojiFilter.getFilter());
        getBinding().etPassword.setFilters(new InputFilter[]{new InputFilter() { // from class: com.appnew.android.Login.Fragment.Login$$ExternalSyntheticLambda0
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                return Login.onViewCreated$lambda$1(charSequence, i, i2, spanned, i3, i4);
            }
        }});
        this.user = User.newInstance();
        getBinding().loginBtn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Login.Fragment.Login$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Login.onViewCreated$lambda$2(this.f$0);
            }
        }));
        getBinding().forgetpasswordTV.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Login.Fragment.Login$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Login.onViewCreated$lambda$3(this.f$0);
            }
        }));
        GoogleSignInOptions googleSignInOptionsBuild = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().requestProfile().build();
        Intrinsics.checkNotNullExpressionValue(googleSignInOptionsBuild, "build(...)");
        this.googleApiClient = new GoogleApiClient.Builder(this.activity).addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptionsBuild).build();
        Context context = getContext();
        Helper.mGoogleSignInClient = context != null ? GoogleSignIn.getClient(context, googleSignInOptionsBuild) : null;
        Helper.mGoogleSignInClient.signOut();
        if (this.is_google_login_enable) {
            RelativeLayout rlGoogleSignin = getBinding().rlGoogleSignin;
            Intrinsics.checkNotNullExpressionValue(rlGoogleSignin, "rlGoogleSignin");
            XtensionFunctionKt.visible(rlGoogleSignin);
            if (this.is_show_email) {
                TextView loginUsingTV = getBinding().loginUsingTV;
                Intrinsics.checkNotNullExpressionValue(loginUsingTV, "loginUsingTV");
                XtensionFunctionKt.visible(loginUsingTV);
                TextView tvOr = getBinding().tvOr;
                Intrinsics.checkNotNullExpressionValue(tvOr, "tvOr");
                XtensionFunctionKt.visible(tvOr);
            }
        }
        if (this.is_show_email) {
            TextView loginUsingTV2 = getBinding().loginUsingTV;
            Intrinsics.checkNotNullExpressionValue(loginUsingTV2, "loginUsingTV");
            XtensionFunctionKt.visible(loginUsingTV2);
        }
        getBinding().rlGoogleSignin.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Login.Fragment.Login$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Login.onViewCreated$lambda$11(this.f$0, view2);
            }
        });
        getBinding().loginUsingTV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Login.Fragment.Login$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.showEmailOrMobile();
            }
        });
        if (Intrinsics.areEqual(SharedPreference.getInstance().getString(Const.COUNTRY_SHOW), "1")) {
            this.country = true;
        }
        if (this.country) {
            RelativeLayout flagRL = getBinding().flagRL;
            Intrinsics.checkNotNullExpressionValue(flagRL, "flagRL");
            XtensionFunctionKt.gone(flagRL);
            RelativeLayout flagCountryLL = getBinding().flagCountryLL;
            Intrinsics.checkNotNullExpressionValue(flagCountryLL, "flagCountryLL");
            XtensionFunctionKt.visible(flagCountryLL);
        } else {
            RelativeLayout flagRL2 = getBinding().flagRL;
            Intrinsics.checkNotNullExpressionValue(flagRL2, "flagRL");
            XtensionFunctionKt.visible(flagRL2);
            RelativeLayout flagCountryLL2 = getBinding().flagCountryLL;
            Intrinsics.checkNotNullExpressionValue(flagCountryLL2, "flagCountryLL");
            XtensionFunctionKt.gone(flagCountryLL2);
            getBinding().etEmail.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(10)});
        }
        getBinding().countryDropDown.registerCarrierNumberEditText(getBinding().etEmail);
        ImageView imageView = getBinding().ivFacebook;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Login.Fragment.Login$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Login.onViewCreated$lambda$13(view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence onViewCreated$lambda$1(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) throws IOException {
        String string = charSequence.toString();
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < string.length(); i5++) {
            char cCharAt = string.charAt(i5);
            if (!CharsKt.isWhitespace(cCharAt)) {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$2(Login login) {
        login.socialType = "0";
        login.isSocial = "0";
        login.CheckValidation(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$3(Login login) {
        Intent intent = new Intent(login.activity, (Class<?>) LoginCatActivity.class);
        intent.putExtra(Const.FRAG_TYPE, Const.FORGETPASSWORD);
        intent.putExtra(Const.RESET_PASS, false);
        intent.putExtra(Const.IS_CHANGE_PASS, false);
        Helper.gotoActivity(intent, login.activity);
        return Unit.INSTANCE;
    }

    private static final void onViewCreated$lambda$7(String str, Login login, View view) {
        String str2 = "https://api.whatsapp.com/send?phone=" + str;
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str2));
            intent.setPackage("com.whatsapp");
            FragmentActivity activity = login.getActivity();
            if ((activity != null ? intent.resolveActivity(activity.getPackageManager()) : null) != null) {
                login.startActivity(intent);
            } else {
                Toast.makeText(login.getContext(), "WhatsApp is not installed", 0).show();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            Toast.makeText(login.getContext(), "An error occurred", 0).show();
        }
    }

    private static final void onViewCreated$lambda$10(Login login, String str, View view) {
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse(MailTo.MAILTO_SCHEME));
        intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
        intent.putExtra("android.intent.extra.SUBJECT", "Subject Here");
        intent.putExtra("android.intent.extra.TEXT", "Body of the email goes here.");
        try {
            login.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
            Toast.makeText(login.getContext(), "An error occurred", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$11(Login login, View view) {
        GoogleSignInApi googleSignInApi = Auth.GoogleSignInApi;
        GoogleApiClient googleApiClient = login.googleApiClient;
        Intrinsics.checkNotNull(googleApiClient);
        Intent signInIntent = googleSignInApi.getSignInIntent(googleApiClient);
        Intrinsics.checkNotNullExpressionValue(signInIntent, "getSignInIntent(...)");
        login.otpLauncher.launch(signInIntent);
        login.requestCode = login.RC_SIGN_IN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$13(View view) {
        LoginManager.INSTANCE.getInstance().registerCallback(CallbackManager.Factory.create(), new FacebookCallback<LoginResult>() { // from class: com.appnew.android.Login.Fragment.Login$onViewCreated$9$1
            @Override // com.facebook.FacebookCallback
            public void onSuccess(LoginResult loginResult) {
                Intrinsics.checkNotNullParameter(loginResult, "loginResult");
                Log.e("onSuccess", new StringBuilder().append(loginResult).toString());
            }

            @Override // com.facebook.FacebookCallback
            public void onCancel() {
                Log.e("onCancel", "");
            }

            @Override // com.facebook.FacebookCallback
            public void onError(FacebookException exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                Log.e("onError", "");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEmailOrMobile() {
        if (StringsKt.contentEquals(getBinding().loginUsingTV.getText(), "Login using email")) {
            EditText emailTV = getBinding().emailTV;
            Intrinsics.checkNotNullExpressionValue(emailTV, "emailTV");
            XtensionFunctionKt.visible(emailTV);
            this.mobile = Helper.GetText(getBinding().etPassword);
            getBinding().etEmail.setEnabled(false);
            getBinding().emailTV.setEnabled(true);
            RelativeLayout mobileRL = getBinding().mobileRL;
            Intrinsics.checkNotNullExpressionValue(mobileRL, "mobileRL");
            XtensionFunctionKt.gone(mobileRL);
            getBinding().loginUsingTV.setText("Login with mobile number");
            return;
        }
        if (StringsKt.contentEquals(getBinding().loginUsingTV.getText(), "Login with mobile number")) {
            EditText emailTV2 = getBinding().emailTV;
            Intrinsics.checkNotNullExpressionValue(emailTV2, "emailTV");
            XtensionFunctionKt.gone(emailTV2);
            getBinding().etEmail.setEnabled(true);
            getBinding().emailTV.setEnabled(false);
            RelativeLayout mobileRL2 = getBinding().mobileRL;
            Intrinsics.checkNotNullExpressionValue(mobileRL2, "mobileRL");
            XtensionFunctionKt.visible(mobileRL2);
            getBinding().loginUsingTV.setText("Login using email");
            this.mobile = Helper.GetText(getBinding().emailTV);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void CheckValidation(boolean r12) {
        /*
            Method dump skipped, instruction units count: 878
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Login.Fragment.Login.CheckValidation(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckValidation$lambda$15(Login login, Ref.BooleanRef booleanRef, String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        Activity activity = login.activity;
        if (activity != null) {
            Helper.showProgressDialog(activity);
        }
        login.deviceTokenNew = token;
        login.callLoginAPi(booleanRef.element);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckValidation$lambda$16(Login login, Exception exc) {
        Toast.makeText(login.requireActivity(), "Could not fetch device token", 0).show();
        return Unit.INSTANCE;
    }

    private final void callLoginAPi(boolean isDataValid) {
        Helper.dismissProgressDialog();
        if (this.country) {
            CountryCodePicker countryCodePicker = getBinding().countryDropDown;
            Intrinsics.checkNotNull(countryCodePicker);
            setC_code(countryCodePicker.getSelectedCountryCodeWithPlus());
        } else {
            setC_code("+91");
        }
        if (this.deviceId == null) {
            this.deviceId = Settings.Secure.getString(this.activity.getContentResolver(), "android_id");
        }
        User user = this.user;
        Intrinsics.checkNotNull(user);
        user.setEmail(this.mobile);
        User user2 = this.user;
        Intrinsics.checkNotNull(user2);
        user2.setMobile(this.mobile);
        User user3 = this.user;
        Intrinsics.checkNotNull(user3);
        user3.setPassword(this.password);
        User user4 = this.user;
        Intrinsics.checkNotNull(user4);
        user4.setIs_social(this.isSocial);
        User user5 = this.user;
        Intrinsics.checkNotNull(user5);
        user5.setSocial_type(this.socialType);
        User user6 = this.user;
        Intrinsics.checkNotNull(user6);
        user6.setSocial_tokken(this.socialToken);
        User user7 = this.user;
        Intrinsics.checkNotNull(user7);
        user7.setDevice_type("1");
        User user8 = this.user;
        Intrinsics.checkNotNull(user8);
        user8.setDevice_tokken(this.deviceTokenNew);
        SharedPreference.getInstance().setLoggedInUser(this.user);
        Helper.hideKeyboard(this.activity);
        Helper.logPrinter("d", Const.DEVICE_TOKEN, this.deviceTokenNew, "");
        this.isSocialLoginAttempt = false;
        hitApiLoginAuthentication();
    }

    public final ActivityResultLauncher<Intent> getOtpLauncher() {
        return this.otpLauncher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void otpLauncher$lambda$19(Login login, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getResultCode() == -1 && it.getData() != null && login.requestCode == login.RC_SIGN_IN) {
            GoogleSignInApi googleSignInApi = Auth.GoogleSignInApi;
            Intent data = it.getData();
            Intrinsics.checkNotNull(data);
            GoogleSignInResult signInResultFromIntent = googleSignInApi.getSignInResultFromIntent(data);
            if (signInResultFromIntent != null) {
                login.handleDeviceTokenBeforeSignIn(signInResultFromIntent);
            }
        }
    }

    private final void hitApiLoginAuthentication() {
        NetworkAPICall(API.API_USER_LOGIN_AUTHENTICATION, "", true, false, false);
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        Intrinsics.checkNotNullParameter(apitype, "apitype");
        Intrinsics.checkNotNullParameter(typeApi, "typeApi");
        Intrinsics.checkNotNullParameter(service, "service");
        if (Intrinsics.areEqual(apitype, API.API_USER_LOGIN_AUTHENTICATION)) {
            EncryptionData encryptionData = new EncryptionData();
            if (this.isSocialLoginAttempt) {
                User user = this.user;
                Intrinsics.checkNotNull(user);
                encryptionData.setEmail(user.getEmail());
                encryptionData.setSocial_type("1");
                User user2 = this.user;
                Intrinsics.checkNotNull(user2);
                encryptionData.setSocial_token(user2.getSocial_tokken());
                User user3 = this.user;
                Intrinsics.checkNotNull(user3);
                user3.setDevice_tokken(this.deviceTokenNew);
                User user4 = this.user;
                Intrinsics.checkNotNull(user4);
                encryptionData.setDevice_tokken(user4.getDevice_tokken());
                encryptionData.setPassword("");
            } else {
                encryptionData.setMobile(this.mobile);
                User user5 = this.user;
                Intrinsics.checkNotNull(user5);
                encryptionData.setDevice_tokken(user5.getDevice_tokken());
                encryptionData.setPassword(this.password);
                encryptionData.setC_code(getC_code());
                if (SharedPreference.getInstance().getString(Const.SHOW_ROLL_NUMBER) != null && StringsKt.equals(SharedPreference.getInstance().getString(Const.SHOW_ROLL_NUMBER), "1", true)) {
                    encryptionData.setRegistration_id(this.rollNumber);
                }
            }
            encryptionData.setDevice_id(this.deviceId);
            User user6 = this.user;
            Intrinsics.checkNotNull(user6);
            encryptionData.setIs_social(user6.getIs_social());
            LocationInfo locationInfo = new LocationInfo();
            locationInfo.setLat(TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.LOCATION_LAT)) ? "N/A" : SharedPreference.getInstance().getString(Const.LOCATION_LAT));
            locationInfo.setLng(TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.LOCATION_LNG)) ? "N/A" : SharedPreference.getInstance().getString(Const.LOCATION_LNG));
            locationInfo.setIp("");
            locationInfo.setManufacturer(TextUtils.isEmpty(Build.MANUFACTURER) ? "N/A" : Build.MANUFACTURER);
            locationInfo.setDevice_model(TextUtils.isEmpty(Build.MODEL) ? "N/A" : Build.MODEL);
            locationInfo.setOs_version(TextUtils.isEmpty(Build.VERSION.RELEASE) ? "N/A" : Build.VERSION.RELEASE);
            encryptionData.setLocation(locationInfo);
            return service.userLoginAuthentication(AES.encrypt(new Gson().toJson(encryptionData)));
        }
        if (Intrinsics.areEqual(apitype, API.get_my_profile)) {
            EncryptionData encryptionData2 = new EncryptionData();
            encryptionData2.setMobile(encryptionData2.getMobile());
            encryptionData2.setDevice_id(this.deviceId);
            encryptionData2.setPassword(encryptionData2.getPassword());
            User user7 = this.user;
            Intrinsics.checkNotNull(user7);
            encryptionData2.setIs_social(user7.getIs_social());
            return service.userProfile(AES.encrypt(new Gson().toJson(encryptionData2)));
        }
        return service.userProfile("profiledoseStrScr");
    }

    /* JADX WARN: Code restructure failed: missing block: B:121:0x06f2, code lost:
    
        if (r13.booleanValue() == false) goto L122;
     */
    @Override // com.appnew.android.Utils.Network.MainFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void SuccessCallBack(org.json.JSONObject r21, java.lang.String r22, java.lang.String r23, boolean r24) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 2234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Login.Fragment.Login.SuccessCallBack(org.json.JSONObject, java.lang.String, java.lang.String, boolean):void");
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        Intrinsics.checkNotNullParameter(jsonstring, "jsonstring");
        Intrinsics.checkNotNullParameter(apitype, "apitype");
        Intrinsics.checkNotNullParameter(typeApi, "typeApi");
        try {
            if (!Intrinsics.areEqual(apitype, API.get_my_profile) && !Intrinsics.areEqual(apitype, API.API_USER_LOGIN_AUTHENTICATION)) {
                return;
            }
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
            ExtensionFucationKt.showToast(fragmentActivityRequireActivity, jsonstring);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == this.RC_SIGN_IN) {
            GoogleSignInResult signInResultFromIntent = data != null ? Auth.GoogleSignInApi.getSignInResultFromIntent(data) : null;
            if (signInResultFromIntent != null) {
                handleDeviceTokenBeforeSignIn(signInResultFromIntent);
            }
        }
    }

    private final void handleSignInResult(GoogleSignInResult result) {
        if (result != null && result.isSuccess()) {
            GoogleSignInAccount signInAccount = result.getSignInAccount();
            User user = this.user;
            Intrinsics.checkNotNull(user);
            user.setEmail(signInAccount != null ? signInAccount.getEmail() : null);
            User user2 = this.user;
            Intrinsics.checkNotNull(user2);
            user2.setSocial_tokken(signInAccount != null ? signInAccount.getId() : null);
            User user3 = this.user;
            Intrinsics.checkNotNull(user3);
            user3.setIs_social("1");
            User user4 = this.user;
            Intrinsics.checkNotNull(user4);
            user4.setSocial_type("1");
            User user5 = this.user;
            Intrinsics.checkNotNull(user5);
            user5.setName(signInAccount != null ? signInAccount.getDisplayName() : null);
            User user6 = this.user;
            Intrinsics.checkNotNull(user6);
            user6.setProfile_picture(String.valueOf(signInAccount != null ? signInAccount.getPhotoUrl() : null));
            this.isSocialLoginAttempt = true;
            hitApiLoginAuthentication();
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        String string = getResources().getString(R.string.sign_in_cancel);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        ExtensionFucationKt.showToastLong(contextRequireContext, string);
    }

    private final void handleDeviceTokenBeforeSignIn(final GoogleSignInResult result) {
        if (result != null && result.isSuccess()) {
            GoogleSignInAccount signInAccount = result.getSignInAccount();
            UserInfo userInfo = new UserInfo("", signInAccount != null ? signInAccount.getEmail() : null, "");
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
            FCMTokenHelper.getValidFCMToken(fragmentActivityRequireActivity, userInfo, new Function1() { // from class: com.appnew.android.Login.Fragment.Login$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Login.handleDeviceTokenBeforeSignIn$lambda$30(this.f$0, result, (String) obj);
                }
            }, new Function1() { // from class: com.appnew.android.Login.Fragment.Login$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Login.handleDeviceTokenBeforeSignIn$lambda$31(this.f$0, (Exception) obj);
                }
            });
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        String string = getResources().getString(R.string.sign_in_cancel);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        ExtensionFucationKt.showToastLong(contextRequireContext, string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleDeviceTokenBeforeSignIn$lambda$30(Login login, GoogleSignInResult googleSignInResult, String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        login.deviceTokenNew = token;
        login.handleSignInResult(googleSignInResult);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleDeviceTokenBeforeSignIn$lambda$31(Login login, Exception exc) {
        Toast.makeText(login.requireActivity(), "Could not fetch device token", 0).show();
        return Unit.INSTANCE;
    }
}
