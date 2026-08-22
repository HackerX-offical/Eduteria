package com.appnew.android.Login.Fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.appnew.android.BuildConfig;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.EncryptionModel.LocationInfo;
import com.appnew.android.Login.Activity.SignInActivity;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.MainFragment;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.firebaseToken.FCMTokenHelper;
import com.appnew.android.Utils.firebaseToken.UserInfo;
import com.appnew.android.databinding.FragmentLoginWithOtpBinding;
import com.appnew.android.feeds.ExtensionFucationKt;
import com.appnew.android.pojo.Userinfo.Data;
import com.eduteria.app.app.R;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;
import com.hbb20.CountryCodePicker;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import retrofit2.Call;

/* JADX INFO: compiled from: LoginWithOtpFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u009b\u00012\u00020\u0001:\u0002\u009b\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010]\u001a\u00020^2\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J&\u0010a\u001a\u0004\u0018\u00010b2\u0006\u0010c\u001a\u00020d2\b\u0010e\u001a\u0004\u0018\u00010f2\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J\u001a\u0010g\u001a\u00020^2\u0006\u0010h\u001a\u00020b2\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J\u0010\u0010o\u001a\u00020^2\u0006\u0010p\u001a\u00020qH\u0002J\u001a\u0010r\u001a\u00020^2\b\u0010p\u001a\u0004\u0018\u00010q2\u0006\u0010s\u001a\u00020\u0013H\u0002J\b\u0010t\u001a\u00020^H\u0002J\b\u0010u\u001a\u00020^H\u0002J\b\u0010v\u001a\u00020^H\u0002J/\u0010~\u001a\u00020\u001e2\t\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u00012\r\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020\u00130x2\u0007\u0010\u0082\u0001\u001a\u00020W¢\u0006\u0003\u0010\u0083\u0001J&\u0010\u0085\u0001\u001a\u00020^2\u0007\u0010\u007f\u001a\u00030\u0080\u00012\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00132\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0013J$\u0010\u0088\u0001\u001a\u00020^2\u0019\u0010\u0089\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00130\u008a\u0001j\t\u0012\u0004\u0012\u00020\u0013`\u008b\u0001H\u0002J\t\u0010\u008c\u0001\u001a\u00020^H\u0002J\t\u0010\u008d\u0001\u001a\u00020^H\u0002J,\u0010\u008e\u0001\u001a\t\u0012\u0004\u0012\u00020\u00130\u008f\u00012\u0007\u0010\u0090\u0001\u001a\u00020\u00132\u0007\u0010\u0091\u0001\u001a\u00020\u00132\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0016J.\u0010\u0094\u0001\u001a\u00020^2\b\u0010\u0095\u0001\u001a\u00030\u0096\u00012\u0007\u0010\u0090\u0001\u001a\u00020\u00132\u0007\u0010\u0091\u0001\u001a\u00020\u00132\u0007\u0010\u0097\u0001\u001a\u00020\u001eH\u0016J$\u0010\u0098\u0001\u001a\u00020^2\u0007\u0010\u0099\u0001\u001a\u00020\u00132\u0007\u0010\u0090\u0001\u001a\u00020\u00132\u0007\u0010\u0091\u0001\u001a\u00020\u0013H\u0016J\t\u0010\u009a\u0001\u001a\u00020^H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020!X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0015\"\u0004\b(\u0010\u0017R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00100\"\u0004\b5\u00102R\u001c\u00106\u001a\u0004\u0018\u000107X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010<\u001a\u0004\u0018\u000107X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00109\"\u0004\b>\u0010;R\u001c\u0010?\u001a\u0004\u0018\u00010@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010E\u001a\u0004\u0018\u00010FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010K\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u00100\"\u0004\bL\u00102R\u001c\u0010M\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0015\"\u0004\bO\u0010\u0017R\u001c\u0010P\u001a\u0004\u0018\u00010QX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001a\u0010V\u001a\u00020WX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u000e\u0010\\\u001a\u00020WX\u0082D¢\u0006\u0002\n\u0000R\u001f\u0010i\u001a\u0010\u0012\f\u0012\n l*\u0004\u0018\u00010k0k0j¢\u0006\b\n\u0000\u001a\u0004\bm\u0010nR\"\u0010w\u001a\b\u0012\u0004\u0012\u00020\u00130xX\u0086\u000e¢\u0006\u0010\n\u0002\u0010}\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R)\u0010\u0084\u0001\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0013 l*\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010x0x0jX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u009c\u0001"}, d2 = {"Lcom/appnew/android/Login/Fragment/LoginWithOtpFragment;", "Lcom/appnew/android/Utils/Network/MainFragment;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/FragmentLoginWithOtpBinding;", "getBinding", "()Lcom/appnew/android/databinding/FragmentLoginWithOtpBinding;", "setBinding", "(Lcom/appnew/android/databinding/FragmentLoginWithOtpBinding;)V", "googleApiClient", "Lcom/google/android/gms/common/api/GoogleApiClient;", "mphonenumberET", "Landroid/widget/EditText;", "getMphonenumberET", "()Landroid/widget/EditText;", "setMphonenumberET", "(Landroid/widget/EditText;)V", "phone", "", "getPhone", "()Ljava/lang/String;", "setPhone", "(Ljava/lang/String;)V", "c_code", "getC_code", "setC_code", "loginBtn", "Landroid/widget/Button;", "isphone", "", "isChangePass", "user", "Lcom/appnew/android/pojo/Userinfo/Data;", "getUser", "()Lcom/appnew/android/pojo/Userinfo/Data;", "setUser", "(Lcom/appnew/android/pojo/Userinfo/Data;)V", "deviceTokenNew", "getDeviceTokenNew", "setDeviceTokenNew", "iv_back", "Landroid/widget/ImageView;", "getIv_back", "()Landroid/widget/ImageView;", "setIv_back", "(Landroid/widget/ImageView;)V", "is_show_email", "()Z", "set_show_email", "(Z)V", UserDataStore.COUNTRY, "getCountry", "setCountry", "flagRL", "Landroid/widget/RelativeLayout;", "getFlagRL", "()Landroid/widget/RelativeLayout;", "setFlagRL", "(Landroid/widget/RelativeLayout;)V", "flagCountryLL", "getFlagCountryLL", "setFlagCountryLL", "cpp", "Lcom/hbb20/CountryCodePicker;", "getCpp", "()Lcom/hbb20/CountryCodePicker;", "setCpp", "(Lcom/hbb20/CountryCodePicker;)V", "countryFlag", "Landroid/graphics/drawable/Drawable;", "getCountryFlag", "()Landroid/graphics/drawable/Drawable;", "setCountryFlag", "(Landroid/graphics/drawable/Drawable;)V", "isSocialLoginAttempt", "setSocialLoginAttempt", "registration_id", "getRegistration_id", "setRegistration_id", "utkashRoom", "Lcom/appnew/android/Room/UtkashRoom;", "getUtkashRoom", "()Lcom/appnew/android/Room/UtkashRoom;", "setUtkashRoom", "(Lcom/appnew/android/Room/UtkashRoom;)V", "requestCode", "", "getRequestCode", "()I", "setRequestCode", "(I)V", "RC_SIGN_IN", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "otpLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "getOtpLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "handleDeviceTokenBeforeSignIn", "result", "Lcom/google/android/gms/auth/api/signin/GoogleSignInResult;", "handleSignInResult", "token", "hitApiLoginAuthentication", "getMobileNumber", "checkPermissionDone", "permissionsRequired", "", "getPermissionsRequired", "()[Ljava/lang/String;", "setPermissionsRequired", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "checkPermissions", "context", "Landroid/app/Activity;", "permissions", "permissionRequestCode", "(Landroid/app/Activity;[Ljava/lang/String;I)Z", "activityResultLauncher", "showPermissionDialog", "title", "msg", "showPopupDialog", "strings", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "verificationMobileId", "CheckValidationNew", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonObject", "Lorg/json/JSONObject;", "showprogress", "ErrorCallBack", "jsonstring", "handleDeviceToken", "Companion", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoginWithOtpFragment extends MainFragment {
    private final ActivityResultLauncher<String[]> activityResultLauncher;
    public FragmentLoginWithOtpBinding binding;
    private String c_code;
    private boolean country;
    private Drawable countryFlag;
    private CountryCodePicker cpp;
    private RelativeLayout flagCountryLL;
    private RelativeLayout flagRL;
    private GoogleApiClient googleApiClient;
    private boolean isChangePass;
    private boolean isSocialLoginAttempt;
    private boolean is_show_email;
    private boolean isphone;
    private ImageView iv_back;
    private Button loginBtn;
    private EditText mphonenumberET;
    private final ActivityResultLauncher<Intent> otpLauncher;
    private String[] permissionsRequired;
    private String phone;
    private String registration_id;
    public Data user;
    private UtkashRoom utkashRoom;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private String deviceTokenNew = "";
    private int requestCode = -1;
    private final int RC_SIGN_IN = 1;

    @JvmStatic
    public static final LoginWithOtpFragment newInstance() {
        return INSTANCE.newInstance();
    }

    public LoginWithOtpFragment() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.Login.Fragment.LoginWithOtpFragment$$ExternalSyntheticLambda7
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                LoginWithOtpFragment.otpLauncher$lambda$10(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.otpLauncher = activityResultLauncherRegisterForActivityResult;
        this.permissionsRequired = new String[]{"android.permission.READ_PHONE_STATE", "android.permission.READ_PHONE_NUMBERS"};
        ActivityResultLauncher<String[]> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback() { // from class: com.appnew.android.Login.Fragment.LoginWithOtpFragment$$ExternalSyntheticLambda8
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                LoginWithOtpFragment.activityResultLauncher$lambda$15(this.f$0, (Map) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(...)");
        this.activityResultLauncher = activityResultLauncherRegisterForActivityResult2;
    }

    public final FragmentLoginWithOtpBinding getBinding() {
        FragmentLoginWithOtpBinding fragmentLoginWithOtpBinding = this.binding;
        if (fragmentLoginWithOtpBinding != null) {
            return fragmentLoginWithOtpBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(FragmentLoginWithOtpBinding fragmentLoginWithOtpBinding) {
        Intrinsics.checkNotNullParameter(fragmentLoginWithOtpBinding, "<set-?>");
        this.binding = fragmentLoginWithOtpBinding;
    }

    public final EditText getMphonenumberET() {
        return this.mphonenumberET;
    }

    public final void setMphonenumberET(EditText editText) {
        this.mphonenumberET = editText;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final void setPhone(String str) {
        this.phone = str;
    }

    public final String getC_code() {
        return this.c_code;
    }

    public final void setC_code(String str) {
        this.c_code = str;
    }

    public final Data getUser() {
        Data data = this.user;
        if (data != null) {
            return data;
        }
        Intrinsics.throwUninitializedPropertyAccessException("user");
        return null;
    }

    public final void setUser(Data data) {
        Intrinsics.checkNotNullParameter(data, "<set-?>");
        this.user = data;
    }

    public final String getDeviceTokenNew() {
        return this.deviceTokenNew;
    }

    public final void setDeviceTokenNew(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deviceTokenNew = str;
    }

    public final ImageView getIv_back() {
        return this.iv_back;
    }

    public final void setIv_back(ImageView imageView) {
        this.iv_back = imageView;
    }

    /* JADX INFO: renamed from: is_show_email, reason: from getter */
    public final boolean getIs_show_email() {
        return this.is_show_email;
    }

    public final void set_show_email(boolean z) {
        this.is_show_email = z;
    }

    public final boolean getCountry() {
        return this.country;
    }

    public final void setCountry(boolean z) {
        this.country = z;
    }

    public final RelativeLayout getFlagRL() {
        return this.flagRL;
    }

    public final void setFlagRL(RelativeLayout relativeLayout) {
        this.flagRL = relativeLayout;
    }

    public final RelativeLayout getFlagCountryLL() {
        return this.flagCountryLL;
    }

    public final void setFlagCountryLL(RelativeLayout relativeLayout) {
        this.flagCountryLL = relativeLayout;
    }

    public final CountryCodePicker getCpp() {
        return this.cpp;
    }

    public final void setCpp(CountryCodePicker countryCodePicker) {
        this.cpp = countryCodePicker;
    }

    public final Drawable getCountryFlag() {
        return this.countryFlag;
    }

    public final void setCountryFlag(Drawable drawable) {
        this.countryFlag = drawable;
    }

    /* JADX INFO: renamed from: isSocialLoginAttempt, reason: from getter */
    public final boolean getIsSocialLoginAttempt() {
        return this.isSocialLoginAttempt;
    }

    public final void setSocialLoginAttempt(boolean z) {
        this.isSocialLoginAttempt = z;
    }

    public final String getRegistration_id() {
        return this.registration_id;
    }

    public final void setRegistration_id(String str) {
        this.registration_id = str;
    }

    public final UtkashRoom getUtkashRoom() {
        return this.utkashRoom;
    }

    public final void setUtkashRoom(UtkashRoom utkashRoom) {
        this.utkashRoom = utkashRoom;
    }

    public final int getRequestCode() {
        return this.requestCode;
    }

    public final void setRequestCode(int i) {
        this.requestCode = i;
    }

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getArguments();
        this.activity = getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        setBinding(FragmentLoginWithOtpBinding.inflate(inflater, container, false));
        return getBinding().getRoot();
    }

    /* JADX INFO: compiled from: LoginWithOtpFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/appnew/android/Login/Fragment/LoginWithOtpFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/appnew/android/Login/Fragment/LoginWithOtpFragment;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final LoginWithOtpFragment newInstance() {
            LoginWithOtpFragment loginWithOtpFragment = new LoginWithOtpFragment();
            loginWithOtpFragment.setArguments(new Bundle());
            return loginWithOtpFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUser(Data.getInstance());
        this.activity = requireActivity();
        this.utkashRoom = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        this.deviceTokenNew = SharedPreference.getInstance().getString(Const.DEVICE_TOKEN);
        if (StringsKt.equals(SharedPreference.getInstance().getString(Const.GOVERNMENET_ID), "1", true)) {
            LinearLayout linearLayout = getBinding().mobileVerifyLL;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            LinearLayout linearLayout2 = getBinding().verifyIdLL;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
        } else {
            LinearLayout linearLayout3 = getBinding().mobileVerifyLL;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(0);
            }
            LinearLayout linearLayout4 = getBinding().verifyIdLL;
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(8);
            }
        }
        if (StringsKt.equals(SharedPreference.getInstance().getString(Const.IS_GOOGLE_LOGIN_ENABLE), "1", true)) {
            LinearLayout linearLayout5 = getBinding().loginOptionLL;
            if (linearLayout5 != null) {
                linearLayout5.setVisibility(0);
            }
        } else {
            LinearLayout linearLayout6 = getBinding().loginOptionLL;
            if (linearLayout6 != null) {
                linearLayout6.setVisibility(8);
            }
        }
        getMobileNumber();
        View viewFindViewById = view.findViewById(R.id.et_email);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.EditText");
        this.mphonenumberET = (EditText) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.loginBtn);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.Button");
        this.loginBtn = (Button) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.flagRL);
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.flagRL = (RelativeLayout) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.flagCountryLL);
        Intrinsics.checkNotNull(viewFindViewById4, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.flagCountryLL = (RelativeLayout) viewFindViewById4;
        View viewFindViewById5 = view.findViewById(R.id.countryDropDown);
        Intrinsics.checkNotNull(viewFindViewById5, "null cannot be cast to non-null type com.hbb20.CountryCodePicker");
        this.cpp = (CountryCodePicker) viewFindViewById5;
        this.is_show_email = StringsKt.equals(SharedPreference.getInstance().getString(Const.EMAIL_SHOW), "1", true);
        String string = requireContext().getString(R.string.app_name);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        getBinding().welcomeTV.setText("Welcome to " + string);
        if (SharedPreference.getInstance().getString("user_define_id") != null && !TextUtils.isEmpty(SharedPreference.getInstance().getString("user_define_id"))) {
            getBinding().verifyIdET.setText(SharedPreference.getInstance().getString("user_define_id"));
        }
        if (this.country) {
            RelativeLayout relativeLayout = this.flagCountryLL;
            Intrinsics.checkNotNull(relativeLayout);
            relativeLayout.setVisibility(0);
            RelativeLayout relativeLayout2 = this.flagRL;
            Intrinsics.checkNotNull(relativeLayout2);
            relativeLayout2.setVisibility(8);
        } else {
            RelativeLayout relativeLayout3 = this.flagCountryLL;
            Intrinsics.checkNotNull(relativeLayout3);
            relativeLayout3.setVisibility(8);
            RelativeLayout relativeLayout4 = this.flagRL;
            Intrinsics.checkNotNull(relativeLayout4);
            relativeLayout4.setVisibility(0);
            EditText editText = this.mphonenumberET;
            Intrinsics.checkNotNull(editText);
            editText.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(10)});
        }
        CountryCodePicker countryCodePicker = this.cpp;
        Intrinsics.checkNotNull(countryCodePicker);
        EditText editText2 = this.mphonenumberET;
        Intrinsics.checkNotNull(editText2);
        countryCodePicker.registerCarrierNumberEditText(editText2);
        if (this.isChangePass) {
            EditText editText3 = this.mphonenumberET;
            Intrinsics.checkNotNull(editText3);
            editText3.setEnabled(false);
            EditText editText4 = this.mphonenumberET;
            Intrinsics.checkNotNull(editText4);
            editText4.setFocusable(false);
            EditText editText5 = this.mphonenumberET;
            Intrinsics.checkNotNull(editText5);
            editText5.setText(SharedPreference.getInstance().getLoggedInUser().getMobile());
            if (this.country) {
                String cCode = SharedPreference.getInstance().getLoggedInUser().getCCode();
                CountryCodePicker countryCodePicker2 = this.cpp;
                Intrinsics.checkNotNull(countryCodePicker2);
                countryCodePicker2.setCcpClickable(false);
                CountryCodePicker countryCodePicker3 = this.cpp;
                Intrinsics.checkNotNull(countryCodePicker3);
                countryCodePicker3.setCountryForPhoneCode(Helper.converToIntCountryCode(cCode));
            }
        }
        if (SharedPreference.getInstance().getString(Const.CONTACTUS_MOBILE1) != null && !SharedPreference.getInstance().getString(Const.CONTACTUS_MOBILE1).equals("")) {
            getBinding().contactNumber.setText(SharedPreference.getInstance().getString(Const.CONTACTUS_MOBILE1));
        } else if (SharedPreference.getInstance().getString(Const.CONTACTUS_MOBILE2) != null && !SharedPreference.getInstance().getString(Const.CONTACTUS_MOBILE2).equals("")) {
            getBinding().contactNumber.setText(SharedPreference.getInstance().getString(Const.CONTACTUS_MOBILE2));
        } else {
            LinearLayout linearLayout7 = getBinding().contactUsLinear;
            if (linearLayout7 != null) {
                linearLayout7.setVisibility(8);
            }
        }
        if (StringsKt.equals(BuildConfig.FLAVOR, "sme", true)) {
            LinearLayout linearLayout8 = getBinding().termAndConditionRel;
            if (linearLayout8 != null) {
                linearLayout8.getVisibility();
            }
        } else {
            LinearLayout linearLayout9 = getBinding().termAndConditionRel;
            if (linearLayout9 != null) {
                linearLayout9.getVisibility();
            }
        }
        Button button = this.loginBtn;
        Intrinsics.checkNotNull(button);
        button.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Login.Fragment.LoginWithOtpFragment$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LoginWithOtpFragment.onViewCreated$lambda$1(this.f$0);
            }
        }));
        TextView textView = getBinding().tvTermAndCondition;
        Intrinsics.checkNotNull(textView);
        textView.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Login.Fragment.LoginWithOtpFragment$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LoginWithOtpFragment.onViewCreated$lambda$2(this.f$0);
            }
        }));
        Button button2 = getBinding().loginBtn2;
        Intrinsics.checkNotNull(button2);
        button2.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Login.Fragment.LoginWithOtpFragment$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LoginWithOtpFragment.onViewCreated$lambda$3(this.f$0);
            }
        }));
        Button button3 = getBinding().attendanceIn;
        Intrinsics.checkNotNull(button3);
        button3.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Login.Fragment.LoginWithOtpFragment$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LoginWithOtpFragment.onViewCreated$lambda$4(this.f$0);
            }
        }));
        TextView textView2 = getBinding().contactNumber;
        Intrinsics.checkNotNull(textView2);
        textView2.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Login.Fragment.LoginWithOtpFragment$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LoginWithOtpFragment.onViewCreated$lambda$5(this.f$0);
            }
        }));
        GoogleSignInOptions googleSignInOptionsBuild = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().requestProfile().build();
        Intrinsics.checkNotNullExpressionValue(googleSignInOptionsBuild, "build(...)");
        this.googleApiClient = new GoogleApiClient.Builder(this.activity).addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptionsBuild).build();
        Context context = getContext();
        Helper.mGoogleSignInClient = context != null ? GoogleSignIn.getClient(context, googleSignInOptionsBuild) : null;
        Helper.mGoogleSignInClient.signOut();
        LinearLayout linearLayout10 = getBinding().googleLL;
        if (linearLayout10 != null) {
            linearLayout10.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Login.Fragment.LoginWithOtpFragment$$ExternalSyntheticLambda17
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LoginWithOtpFragment.onViewCreated$lambda$7(this.f$0, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$1(LoginWithOtpFragment loginWithOtpFragment) {
        loginWithOtpFragment.CheckValidationNew();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$2(LoginWithOtpFragment loginWithOtpFragment) {
        loginWithOtpFragment.requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fourFragmentLayout, CommonWebViewFragment.newInstance(API.TERMS_AND_CONDITIONS, false)).addToBackStack(null).commit();
        SignInActivity.INSTANCE.setOnBackPressClicked(true);
        FragmentActivity activity = loginWithOtpFragment.getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.appnew.android.Login.Activity.SignInActivity");
        ((SignInActivity) activity).setSignInUpLayoutVisibility(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$3(LoginWithOtpFragment loginWithOtpFragment) {
        loginWithOtpFragment.verificationMobileId();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$4(LoginWithOtpFragment loginWithOtpFragment) {
        loginWithOtpFragment.verificationMobileId();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$5(LoginWithOtpFragment loginWithOtpFragment) {
        String string;
        String[] strArr = new String[1];
        if (SharedPreference.getInstance().getString(Const.CONTACTUS_MOBILE1) != null && !SharedPreference.getInstance().getString(Const.CONTACTUS_MOBILE1).equals("")) {
            string = SharedPreference.getInstance().getString(Const.CONTACTUS_MOBILE1);
        } else {
            string = (SharedPreference.getInstance().getString(Const.CONTACTUS_MOBILE2) == null || SharedPreference.getInstance().getString(Const.CONTACTUS_MOBILE2).equals("")) ? "" : SharedPreference.getInstance().getString(Const.CONTACTUS_MOBILE2);
        }
        if (string != null && !StringsKt.equals(string, "", true)) {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + string));
            Context context = loginWithOtpFragment.getContext();
            if (context != null) {
                context.startActivity(intent);
            }
        } else {
            Toast.makeText(loginWithOtpFragment.getContext(), "Mobile Number not exist from backend", 0);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$7(LoginWithOtpFragment loginWithOtpFragment, View view) {
        GoogleSignInApi googleSignInApi = Auth.GoogleSignInApi;
        GoogleApiClient googleApiClient = loginWithOtpFragment.googleApiClient;
        Intrinsics.checkNotNull(googleApiClient);
        Intent signInIntent = googleSignInApi.getSignInIntent(googleApiClient);
        Intrinsics.checkNotNullExpressionValue(signInIntent, "getSignInIntent(...)");
        loginWithOtpFragment.otpLauncher.launch(signInIntent);
        loginWithOtpFragment.requestCode = loginWithOtpFragment.RC_SIGN_IN;
    }

    public final ActivityResultLauncher<Intent> getOtpLauncher() {
        return this.otpLauncher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void otpLauncher$lambda$10(LoginWithOtpFragment loginWithOtpFragment, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getResultCode() == -1 && it.getData() != null && loginWithOtpFragment.requestCode == loginWithOtpFragment.RC_SIGN_IN) {
            GoogleSignInApi googleSignInApi = Auth.GoogleSignInApi;
            Intent data = it.getData();
            Intrinsics.checkNotNull(data);
            GoogleSignInResult signInResultFromIntent = googleSignInApi.getSignInResultFromIntent(data);
            if (signInResultFromIntent != null) {
                loginWithOtpFragment.handleDeviceTokenBeforeSignIn(signInResultFromIntent);
            }
        }
    }

    private final void handleDeviceTokenBeforeSignIn(final GoogleSignInResult result) {
        if (result != null && result.isSuccess()) {
            GoogleSignInAccount signInAccount = result.getSignInAccount();
            UserInfo userInfo = new UserInfo("", signInAccount != null ? signInAccount.getEmail() : null, "");
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
            FCMTokenHelper.getValidFCMToken(fragmentActivityRequireActivity, userInfo, new Function1() { // from class: com.appnew.android.Login.Fragment.LoginWithOtpFragment$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LoginWithOtpFragment.handleDeviceTokenBeforeSignIn$lambda$11(this.f$0, result, (String) obj);
                }
            }, new Function1() { // from class: com.appnew.android.Login.Fragment.LoginWithOtpFragment$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LoginWithOtpFragment.handleDeviceTokenBeforeSignIn$lambda$12(this.f$0, (Exception) obj);
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
    public static final Unit handleDeviceTokenBeforeSignIn$lambda$11(LoginWithOtpFragment loginWithOtpFragment, GoogleSignInResult googleSignInResult, String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        loginWithOtpFragment.handleSignInResult(googleSignInResult, token);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleDeviceTokenBeforeSignIn$lambda$12(LoginWithOtpFragment loginWithOtpFragment, Exception exc) {
        Toast.makeText(loginWithOtpFragment.requireActivity(), "Could not fetch device token", 0).show();
        return Unit.INSTANCE;
    }

    private final void handleSignInResult(GoogleSignInResult result, String token) {
        if (result != null && result.isSuccess()) {
            GoogleSignInAccount signInAccount = result.getSignInAccount();
            Data user = getUser();
            Intrinsics.checkNotNull(user);
            user.setEmail(signInAccount != null ? signInAccount.getEmail() : null);
            Data user2 = getUser();
            Intrinsics.checkNotNull(user2);
            user2.setName(signInAccount != null ? signInAccount.getDisplayName() : null);
            Data user3 = getUser();
            Intrinsics.checkNotNull(user3);
            user3.setProfilePicture(String.valueOf(signInAccount != null ? signInAccount.getPhotoUrl() : null));
            Data user4 = getUser();
            Intrinsics.checkNotNull(user4);
            user4.setSocial_tokken(signInAccount != null ? signInAccount.getId() : null);
            Data user5 = getUser();
            Intrinsics.checkNotNull(user5);
            user5.setIs_social("1");
            Data user6 = getUser();
            Intrinsics.checkNotNull(user6);
            user6.setSocial_type("1");
            this.deviceTokenNew = token;
            Data user7 = getUser();
            Intrinsics.checkNotNull(user7);
            user7.setDevice_tokken(token);
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

    private final void hitApiLoginAuthentication() {
        NetworkAPICall(API.API_USER_LOGIN_AUTHENTICATION, "", true, false, false);
    }

    private final void getMobileNumber() {
        String[] strArr;
        if (Build.VERSION.SDK_INT >= 33) {
            strArr = this.permissionsRequired;
        } else {
            strArr = this.permissionsRequired;
        }
        if (checkPermissions(this.activity, strArr, 101)) {
            checkPermissionDone();
        }
    }

    private final void checkPermissionDone() {
        SubscriptionManager subscriptionManagerFrom = SubscriptionManager.from(requireContext());
        if (ActivityCompat.checkSelfPermission(requireContext(), "android.permission.READ_PHONE_STATE") != 0) {
            return;
        }
        List<SubscriptionInfo> activeSubscriptionInfoList = subscriptionManagerFrom.getActiveSubscriptionInfoList();
        final ArrayList arrayList = new ArrayList();
        if (activeSubscriptionInfoList != null) {
            for (SubscriptionInfo subscriptionInfo : activeSubscriptionInfoList) {
                String number = subscriptionInfo.getNumber();
                Helper.logPrinter("mPhoneNumber", "d", (number + " " + subscriptionInfo.getCountryIso()), "");
                if (number != null) {
                    String str = number;
                    if (!TextUtils.isEmpty(str) && (StringsKt.contains$default((CharSequence) str, (CharSequence) MqttTopic.SINGLE_LEVEL_WILDCARD, false, 2, (Object) null) || StringsKt.startsWith$default(number, "91", false, 2, (Object) null))) {
                        if (number.length() > 10) {
                            String strSubstring = number.substring(number.length() - 10);
                            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                            arrayList.add(strSubstring);
                        }
                    }
                }
            }
        }
        new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.Login.Fragment.LoginWithOtpFragment$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                LoginWithOtpFragment.checkPermissionDone$lambda$13(arrayList, this);
            }
        }, 1000L);
        Helper.logPrinter("mPhoneNumber", "d", new StringBuilder().append(arrayList).toString(), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkPermissionDone$lambda$13(ArrayList arrayList, LoginWithOtpFragment loginWithOtpFragment) {
        if (arrayList.size() > 0) {
            loginWithOtpFragment.showPopupDialog(arrayList);
        }
    }

    public final String[] getPermissionsRequired() {
        return this.permissionsRequired;
    }

    public final void setPermissionsRequired(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        this.permissionsRequired = strArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final boolean checkPermissions(Activity context, String[] permissions, int permissionRequestCode) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        ArrayList arrayList = new ArrayList();
        for (String str : permissions) {
            if (ContextCompat.checkSelfPermission(requireContext(), str) != 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return true;
        }
        this.activityResultLauncher.launch(arrayList.toArray(new String[0]));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void activityResultLauncher$lambda$15(LoginWithOtpFragment loginWithOtpFragment, Map permissions) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Set<Map.Entry> setEntrySet = permissions.entrySet();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10));
        for (Map.Entry entry : setEntrySet) {
            String str = (String) entry.getKey();
            if (((Boolean) entry.getValue()).booleanValue() && StringsKt.equals(str, "android.permission.READ_PHONE_NUMBERS", true)) {
                loginWithOtpFragment.checkPermissionDone();
            }
            arrayList.add(Unit.INSTANCE);
        }
    }

    public final void showPermissionDialog(final Activity context, String title, String msg) {
        Intrinsics.checkNotNullParameter(context, "context");
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.appnew.android.Login.Fragment.LoginWithOtpFragment$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LoginWithOtpFragment.showPermissionDialog$lambda$16(context, dialogInterface, i);
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPermissionDialog$lambda$16(Activity activity, DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        Uri uriFromParts = Uri.fromParts(AnalyticsConstants.PACKAGE, activity.getPackageName(), null);
        Intrinsics.checkNotNullExpressionValue(uriFromParts, "fromParts(...)");
        intent.setData(uriFromParts);
        intent.addFlags(268435456);
        activity.startActivity(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, android.app.Dialog] */
    /* JADX WARN: Type inference failed for: r5v2, types: [T, android.view.View] */
    /* JADX WARN: Type inference failed for: r8v2, types: [T, android.view.View] */
    private final void showPopupDialog(ArrayList<String> strings) {
        try {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = new Dialog(requireActivity(), R.style.PauseDialog);
            ((Dialog) objectRef.element).requestWindowFeature(1);
            ((Dialog) objectRef.element).setCancelable(true);
            ((Dialog) objectRef.element).setContentView(R.layout.number_popup_dialog);
            LinearLayout linearLayout = (LinearLayout) ((Dialog) objectRef.element).findViewById(R.id.numberPopup_LinerLayout1);
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = ((Dialog) objectRef.element).findViewById(R.id.phone_number);
            LinearLayout linearLayout2 = (LinearLayout) ((Dialog) objectRef.element).findViewById(R.id.numberPopup_LinerLayout2);
            final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            objectRef3.element = ((Dialog) objectRef.element).findViewById(R.id.phone_number2);
            if (!strings.isEmpty() && strings.size() == 1) {
                linearLayout.setVisibility(0);
                ((TextView) objectRef2.element).setText(strings.get(0));
                linearLayout2.setVisibility(8);
            } else if (!strings.isEmpty() && strings.size() == 2) {
                linearLayout.setVisibility(0);
                ((TextView) objectRef2.element).setText(strings.get(0));
                linearLayout2.setVisibility(0);
                ((TextView) objectRef3.element).setText(strings.get(1));
            } else if (!strings.isEmpty() && strings.size() > 2) {
                linearLayout.setVisibility(0);
                ((TextView) objectRef2.element).setText(strings.get(0));
                linearLayout2.setVisibility(0);
                ((TextView) objectRef3.element).setText(strings.get(1));
            } else {
                linearLayout.setVisibility(8);
                linearLayout2.setVisibility(8);
            }
            ((LinearLayout) ((Dialog) objectRef.element).findViewById(R.id.numberPopup_LinerLayout1)).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Login.Fragment.LoginWithOtpFragment$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LoginWithOtpFragment.showPopupDialog$lambda$17(objectRef, this, objectRef2, view);
                }
            });
            ((LinearLayout) ((Dialog) objectRef.element).findViewById(R.id.numberPopup_LinerLayout2)).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Login.Fragment.LoginWithOtpFragment$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LoginWithOtpFragment.showPopupDialog$lambda$18(objectRef, this, objectRef3, view);
                }
            });
            ((Dialog) objectRef.element).show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void showPopupDialog$lambda$17(Ref.ObjectRef objectRef, LoginWithOtpFragment loginWithOtpFragment, Ref.ObjectRef objectRef2, View view) {
        ((Dialog) objectRef.element).dismiss();
        loginWithOtpFragment.getBinding().etEmail.setText(((TextView) objectRef2.element).getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void showPopupDialog$lambda$18(Ref.ObjectRef objectRef, LoginWithOtpFragment loginWithOtpFragment, Ref.ObjectRef objectRef2, View view) {
        ((Dialog) objectRef.element).dismiss();
        loginWithOtpFragment.getBinding().etEmail.setText(((TextView) objectRef2.element).getText());
    }

    private final void verificationMobileId() {
        EditText editText = getBinding().verifyIdET;
        if (!StringsKt.equals(String.valueOf(editText != null ? editText.getText() : null), "", true)) {
            EditText editText2 = getBinding().verifyIdET;
            if (String.valueOf(editText2 != null ? editText2.getText() : null).length() > 4) {
                this.isSocialLoginAttempt = false;
                EditText editText3 = getBinding().verifyIdET;
                this.registration_id = String.valueOf(editText3 != null ? editText3.getText() : null);
                NetworkAPICall(API.API_USER_LOGIN_AUTHENTICATION, "", true, false, false);
                return;
            }
        }
        Toast.makeText(this.activity, "Please enter a Valid Id", 0).show();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void CheckValidationNew() {
        /*
            Method dump skipped, instruction units count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Login.Fragment.LoginWithOtpFragment.CheckValidationNew():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckValidationNew$lambda$19(LoginWithOtpFragment loginWithOtpFragment, String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        loginWithOtpFragment.deviceTokenNew = token;
        loginWithOtpFragment.NetworkAPICall(API.API_SEND_OTP_VERIFICATION, "", true, false, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckValidationNew$lambda$20(LoginWithOtpFragment loginWithOtpFragment, Exception exc) {
        Toast.makeText(loginWithOtpFragment.requireActivity(), "Could not fetch device token", 0).show();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.appnew.android.Utils.Network.MainFragment
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        Intrinsics.checkNotNullParameter(apitype, "apitype");
        Intrinsics.checkNotNullParameter(typeApi, "typeApi");
        Intrinsics.checkNotNullParameter(service, "service");
        switch (apitype.hashCode()) {
            case -1812137532:
                if (apitype.equals(API.API_SEND_OTP_VERIFICATION)) {
                    EncryptionData encryptionData = new EncryptionData();
                    EditText editText = this.mphonenumberET;
                    encryptionData.setMobile(String.valueOf(editText != null ? editText.getText() : null));
                    encryptionData.setOtp("");
                    encryptionData.setIs_registration("1");
                    encryptionData.setResend("0");
                    encryptionData.setDevice_token(this.deviceTokenNew);
                    return service.getOtpVerification(AES.encrypt(new Gson().toJson(encryptionData)));
                }
                break;
            case -129172072:
                if (apitype.equals(API.API_USER_LOGIN_AUTHENTICATION)) {
                    EncryptionData encryptionData2 = new EncryptionData();
                    if (this.isSocialLoginAttempt) {
                        encryptionData2.setEmail(getUser().getEmail());
                        encryptionData2.setName(getUser().getName());
                        encryptionData2.profile_picture = getUser().getProfilePicture();
                        encryptionData2.setSocial_type("1");
                        encryptionData2.setSocial_token(getUser().getSocial_tokken());
                        Data user = getUser();
                        Intrinsics.checkNotNull(user);
                        user.setDevice_tokken(this.deviceTokenNew);
                        encryptionData2.setDevice_tokken(this.deviceTokenNew);
                        encryptionData2.setPassword("");
                    } else {
                        encryptionData2.setMobile(this.registration_id);
                        encryptionData2.setDevice_tokken(this.deviceTokenNew);
                        encryptionData2.setPassword(this.registration_id);
                        encryptionData2.setC_code(this.c_code);
                        encryptionData2.setRegistration_id(this.registration_id);
                    }
                    encryptionData2.setDevice_id(Settings.Secure.getString(requireActivity().getContentResolver(), "android_id"));
                    encryptionData2.setIs_social(getUser().getIs_social());
                    LocationInfo locationInfo = new LocationInfo();
                    locationInfo.setLat(TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.LOCATION_LAT)) ? "N/A" : SharedPreference.getInstance().getString(Const.LOCATION_LAT));
                    locationInfo.setLng(TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.LOCATION_LNG)) ? "N/A" : SharedPreference.getInstance().getString(Const.LOCATION_LNG));
                    locationInfo.setIp("");
                    locationInfo.setManufacturer(TextUtils.isEmpty(Build.MANUFACTURER) ? "N/A" : Build.MANUFACTURER);
                    locationInfo.setDevice_model(TextUtils.isEmpty(Build.MODEL) ? "N/A" : Build.MODEL);
                    locationInfo.setOs_version(TextUtils.isEmpty(Build.VERSION.RELEASE) ? "N/A" : Build.VERSION.RELEASE);
                    encryptionData2.setLocation(locationInfo);
                    return service.userLoginAuthentication(AES.encrypt(new Gson().toJson(encryptionData2)));
                }
                break;
            case 1631865:
                if (apitype.equals(API.get_my_profile)) {
                    EncryptionData encryptionData3 = new EncryptionData();
                    encryptionData3.setMobile(encryptionData3.getRegistration_id());
                    encryptionData3.setDevice_id(Settings.Secure.getString(requireActivity().getContentResolver(), "android_id"));
                    encryptionData3.setPassword(encryptionData3.getRegistration_id());
                    encryptionData3.setIs_social("0");
                    return service.userProfile(AES.encrypt(new Gson().toJson(encryptionData3)));
                }
                break;
            case 971560770:
                if (apitype.equals(API.API_USER_VERIFICATION)) {
                    EncryptionData encryptionData4 = new EncryptionData();
                    EditText editText2 = getBinding().verifyIdET;
                    encryptionData4.setMobile(String.valueOf(editText2 != null ? editText2.getText() : null));
                    return service.getUserVerification(AES.encrypt(new Gson().toJson(encryptionData4)));
                }
                break;
        }
        return service.getOtpVerification("");
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x061d, code lost:
    
        if (r2.booleanValue() == false) goto L105;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.appnew.android.Utils.Network.MainFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void SuccessCallBack(org.json.JSONObject r19, java.lang.String r20, java.lang.String r21, boolean r22) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 2336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Login.Fragment.LoginWithOtpFragment.SuccessCallBack(org.json.JSONObject, java.lang.String, java.lang.String, boolean):void");
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        Intrinsics.checkNotNullParameter(jsonstring, "jsonstring");
        Intrinsics.checkNotNullParameter(apitype, "apitype");
        Intrinsics.checkNotNullParameter(typeApi, "typeApi");
        int iHashCode = apitype.hashCode();
        if (iHashCode == -1812137532) {
            if (apitype.equals(API.API_SEND_OTP_VERIFICATION)) {
                Toast.makeText(this.activity, jsonstring, 0).show();
                return;
            }
            return;
        }
        if (iHashCode != -129172072) {
            if (iHashCode != 1631865 || !apitype.equals(API.get_my_profile)) {
                return;
            }
        } else if (!apitype.equals(API.API_USER_LOGIN_AUTHENTICATION)) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        ExtensionFucationKt.showToast(contextRequireContext, jsonstring);
    }

    private final void handleDeviceToken() {
        new Data();
        Data loggedInUser = SharedPreference.getInstance().getLoggedInUser();
        UserInfo userInfo = new UserInfo(loggedInUser.getId(), loggedInUser.getEmail(), loggedInUser.getMobile());
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        if (!userInfo.isSameUser(FCMTokenHelper.getUserInfo(fragmentActivityRequireActivity))) {
            FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity2, "requireActivity(...)");
            FCMTokenHelper.getValidFCMToken(fragmentActivityRequireActivity2, userInfo, new Function1() { // from class: com.appnew.android.Login.Fragment.LoginWithOtpFragment$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LoginWithOtpFragment.handleDeviceToken$lambda$29(this.f$0, (String) obj);
                }
            }, new Function1() { // from class: com.appnew.android.Login.Fragment.LoginWithOtpFragment$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LoginWithOtpFragment.handleDeviceToken$lambda$30(this.f$0, (Exception) obj);
                }
            });
        } else {
            FragmentActivity fragmentActivityRequireActivity3 = requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity3, "requireActivity(...)");
            this.deviceTokenNew = String.valueOf(FCMTokenHelper.getSavedToken(fragmentActivityRequireActivity3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleDeviceToken$lambda$29(LoginWithOtpFragment loginWithOtpFragment, String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        loginWithOtpFragment.deviceTokenNew = token;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleDeviceToken$lambda$30(LoginWithOtpFragment loginWithOtpFragment, Exception exc) {
        Toast.makeText(loginWithOtpFragment.requireActivity(), "Could not fetch device token", 0).show();
        return Unit.INSTANCE;
    }
}
