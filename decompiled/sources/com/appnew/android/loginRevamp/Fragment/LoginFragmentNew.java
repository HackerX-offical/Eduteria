package com.appnew.android.loginRevamp.Fragment;

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
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.appnew.android.BuildConfig;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.EncryptionModel.LocationInfo;
import com.appnew.android.ExtensionFunctions.XtensionFunctionKt;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.LabeledEditText;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.MainFragment;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.firebaseToken.FCMTokenHelper;
import com.appnew.android.Utils.firebaseToken.UserInfo;
import com.appnew.android.databinding.ActivitySignInNewBinding;
import com.appnew.android.databinding.FragmentLoginWithOtpNewBinding;
import com.appnew.android.feeds.ExtensionFucationKt;
import com.appnew.android.loginRevamp.Activity.SignInNewActivity;
import com.appnew.android.pojo.Userinfo.Data;
import com.clevertap.android.sdk.Constants;
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
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: LoginFragmentNew.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010w\u001a\u00020x2\b\u0010y\u001a\u0004\u0018\u00010zH\u0016J'\u0010{\u001a\u0004\u0018\u00010|2\u0006\u0010}\u001a\u00020~2\t\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u00012\b\u0010y\u001a\u0004\u0018\u00010zH\u0016J\u001c\u0010\u0081\u0001\u001a\u00020x2\u0007\u0010\u0082\u0001\u001a\u00020|2\b\u0010y\u001a\u0004\u0018\u00010zH\u0016J\u0011\u0010\u0083\u0001\u001a\u00020x2\u0006\u0010\u0018\u001a\u00020&H\u0002J\t\u0010\u0084\u0001\u001a\u00020xH\u0002J\t\u0010\u0085\u0001\u001a\u00020xH\u0002J1\u0010\u008d\u0001\u001a\u00020&2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\u008f\u0001\u001a\t\u0012\u0004\u0012\u00020\u00110\u0087\u00012\u0007\u0010\u0090\u0001\u001a\u00020g¢\u0006\u0003\u0010\u0091\u0001J&\u0010\u0095\u0001\u001a\u00020x2\u0007\u0010\u008e\u0001\u001a\u00020\u000b2\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u00112\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0011J$\u0010\u0098\u0001\u001a\u00020x2\u0019\u0010\u0099\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00110\u009a\u0001j\t\u0012\u0004\u0012\u00020\u0011`\u009b\u0001H\u0002J\t\u0010\u009c\u0001\u001a\u00020xH\u0002J\u0007\u0010\u009d\u0001\u001a\u00020xJ\t\u0010\u009e\u0001\u001a\u00020xH\u0016J,\u0010\u009f\u0001\u001a\t\u0012\u0004\u0012\u00020\u00110 \u00012\u0007\u0010¡\u0001\u001a\u00020\u00112\u0007\u0010¢\u0001\u001a\u00020\u00112\b\u0010£\u0001\u001a\u00030¤\u0001H\u0016J.\u0010¥\u0001\u001a\u00020x2\b\u0010¦\u0001\u001a\u00030§\u00012\u0007\u0010¡\u0001\u001a\u00020\u00112\u0007\u0010¢\u0001\u001a\u00020\u00112\u0007\u0010¨\u0001\u001a\u00020&H\u0016J$\u0010©\u0001\u001a\u00020x2\u0007\u0010ª\u0001\u001a\u00020\u00112\u0007\u0010¡\u0001\u001a\u00020\u00112\u0007\u0010¢\u0001\u001a\u00020\u0011H\u0016J\u0015\u0010¯\u0001\u001a\u00020x2\n\u0010°\u0001\u001a\u0005\u0018\u00010±\u0001H\u0002J\t\u0010²\u0001\u001a\u00020xH\u0002J\t\u0010³\u0001\u001a\u00020xH\u0002J!\u0010´\u0001\u001a\u00020x2\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010b\u001a\u00020&H\u0002J\u0013\u0010µ\u0001\u001a\u00020x2\b\u0010¦\u0001\u001a\u00030§\u0001H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001a\u0010\u001f\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\u001c\u0010\"\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020)X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0013\"\u0004\b0\u0010\u0015R\u001c\u00101\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0013\"\u0004\b3\u0010\u0015R\u001c\u00104\u001a\u0004\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010;\"\u0004\b@\u0010=R\u001c\u0010A\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001c\u0010G\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0013\"\u0004\bI\u0010\u0015R\u001c\u0010J\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0013\"\u0004\bL\u0010\u0015R\u001c\u0010M\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0013\"\u0004\bO\u0010\u0015R\u001c\u0010P\u001a\u0004\u0018\u00010QX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001a\u0010V\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u0013\"\u0004\bW\u0010\u0015R\u001a\u0010X\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010;\"\u0004\bY\u0010=R\u001a\u0010Z\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u0013\"\u0004\b\\\u0010\u0015R\u001c\u0010]\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\u0013\"\u0004\b_\u0010\u0015R\u001c\u0010`\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u0013\"\u0004\ba\u0010\u0015R\u001a\u0010b\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010;\"\u0004\bc\u0010=R\u0010\u0010d\u001a\u0004\u0018\u00010eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010f\u001a\u00020gX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u000e\u0010l\u001a\u00020gX\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010m\u001a\u00020nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u001a\u0010s\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010;\"\u0004\bt\u0010=R\u001a\u0010u\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010;\"\u0004\bv\u0010=R)\u0010\u0086\u0001\u001a\t\u0012\u0004\u0012\u00020\u00110\u0087\u0001X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u008c\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R-\u0010\u0092\u0001\u001a \u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u0011 \u0094\u0001*\u000b\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0087\u00010\u0087\u00010\u0093\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010«\u0001\u001a\u0014\u0012\u000f\u0012\r \u0094\u0001*\u0005\u0018\u00010¬\u00010¬\u00010\u0093\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u00ad\u0001\u0010®\u0001¨\u0006¶\u0001"}, d2 = {"Lcom/appnew/android/loginRevamp/Fragment/LoginFragmentNew;", "Lcom/appnew/android/Utils/Network/MainFragment;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/FragmentLoginWithOtpNewBinding;", "getBinding", "()Lcom/appnew/android/databinding/FragmentLoginWithOtpNewBinding;", "setBinding", "(Lcom/appnew/android/databinding/FragmentLoginWithOtpNewBinding;)V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "email", "getEmail", "setEmail", "phone", "getPhone", "setPhone", "password", "getPassword", "setPassword", "rollNumber", "getRollNumber", "setRollNumber", "c_code", "getC_code", "setC_code", "isphone", "", "isChangePass", "user", "Lcom/appnew/android/pojo/Userinfo/Data;", "getUser", "()Lcom/appnew/android/pojo/Userinfo/Data;", "setUser", "(Lcom/appnew/android/pojo/Userinfo/Data;)V", "deviceTokenNew", "getDeviceTokenNew", "setDeviceTokenNew", Constants.DEVICE_ID_TAG, "getDeviceId", "setDeviceId", "iv_back", "Landroid/widget/ImageView;", "getIv_back", "()Landroid/widget/ImageView;", "setIv_back", "(Landroid/widget/ImageView;)V", "is_show_email", "()Z", "set_show_email", "(Z)V", UserDataStore.COUNTRY, "getCountry", "setCountry", "countryFlag", "Landroid/graphics/drawable/Drawable;", "getCountryFlag", "()Landroid/graphics/drawable/Drawable;", "setCountryFlag", "(Landroid/graphics/drawable/Drawable;)V", Const.C_NAME, "getC_name", "setC_name", "c_nameCode", "getC_nameCode", "setC_nameCode", "registration_id", "getRegistration_id", "setRegistration_id", "utkashRoom", "Lcom/appnew/android/Room/UtkashRoom;", "getUtkashRoom", "()Lcom/appnew/android/Room/UtkashRoom;", "setUtkashRoom", "(Lcom/appnew/android/Room/UtkashRoom;)V", "isUserRegistered", "setUserRegistered", Const.IS_GOOGLE_LOGIN_ENABLE, "set_google_login_enable", "socialToken", "getSocialToken", "setSocialToken", "socialType", "getSocialType", "setSocialType", "isSocial", "setSocial", "isSocialLoginAttempt", "setSocialLoginAttempt", "googleApiClient", "Lcom/google/android/gms/common/api/GoogleApiClient;", "requestCode", "", "getRequestCode", "()I", "setRequestCode", "(I)V", "RC_SIGN_IN", "mLastClickTime", "", "getMLastClickTime", "()J", "setMLastClickTime", "(J)V", "isForgetPassword", "setForgetPassword", "isDefaultEmail", "setDefaultEmail", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "showEmailOrMobile", "getMobileNumber", "checkPermissionDone", "permissionsRequired", "", "getPermissionsRequired", "()[Ljava/lang/String;", "setPermissionsRequired", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "checkPermissions", "context", "permissions", "permissionRequestCode", "(Landroid/app/Activity;[Ljava/lang/String;I)Z", "activityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "showPermissionDialog", "title", "msg", "showPopupDialog", "strings", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "verificationMobileId", "CheckValidation", "onResume", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonObject", "Lorg/json/JSONObject;", "showprogress", "ErrorCallBack", "jsonstring", "otpLauncher", "Landroid/content/Intent;", "getOtpLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "handleSignInResult", "result", "Lcom/google/android/gms/auth/api/signin/GoogleSignInResult;", "hitApiLoginAuthentication", "callLoginApi", "handleDeviceToken", "showStudentClass", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoginFragmentNew extends MainFragment {
    public static final int $stable = 8;
    private Activity activity;
    private final ActivityResultLauncher<String[]> activityResultLauncher;
    public FragmentLoginWithOtpNewBinding binding;
    private String c_code;
    private boolean country;
    private Drawable countryFlag;
    private String deviceId;
    private GoogleApiClient googleApiClient;
    private boolean isChangePass;
    private boolean isDefaultEmail;
    private boolean isForgetPassword;
    private boolean isSocialLoginAttempt;
    private boolean is_google_login_enable;
    private boolean is_show_email;
    private boolean isphone;
    private ImageView iv_back;
    private long mLastClickTime;
    private final ActivityResultLauncher<Intent> otpLauncher;
    private String registration_id;
    public Data user;
    private UtkashRoom utkashRoom;
    private String name = "";
    private String email = "";
    private String phone = "";
    private String password = "";
    private String rollNumber = "";
    private String deviceTokenNew = "";
    private String c_name = "India";
    private String c_nameCode = "IN";
    private String isUserRegistered = "0";
    private String socialToken = "12345678";
    private String socialType = "0";
    private String isSocial = "0";
    private int requestCode = -1;
    private final int RC_SIGN_IN = 1;
    private String[] permissionsRequired = {"android.permission.READ_PHONE_STATE", "android.permission.READ_PHONE_NUMBERS"};

    public LoginFragmentNew() {
        ActivityResultLauncher<String[]> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback() { // from class: com.appnew.android.loginRevamp.Fragment.LoginFragmentNew$$ExternalSyntheticLambda17
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                LoginFragmentNew.activityResultLauncher$lambda$13(this.f$0, (Map) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.activityResultLauncher = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.loginRevamp.Fragment.LoginFragmentNew$$ExternalSyntheticLambda18
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                LoginFragmentNew.otpLauncher$lambda$31(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(...)");
        this.otpLauncher = activityResultLauncherRegisterForActivityResult2;
    }

    public final FragmentLoginWithOtpNewBinding getBinding() {
        FragmentLoginWithOtpNewBinding fragmentLoginWithOtpNewBinding = this.binding;
        if (fragmentLoginWithOtpNewBinding != null) {
            return fragmentLoginWithOtpNewBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(FragmentLoginWithOtpNewBinding fragmentLoginWithOtpNewBinding) {
        Intrinsics.checkNotNullParameter(fragmentLoginWithOtpNewBinding, "<set-?>");
        this.binding = fragmentLoginWithOtpNewBinding;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final void setActivity(Activity activity) {
        this.activity = activity;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final String getEmail() {
        return this.email;
    }

    public final void setEmail(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.email = str;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final void setPhone(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.phone = str;
    }

    public final String getPassword() {
        return this.password;
    }

    public final void setPassword(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.password = str;
    }

    public final String getRollNumber() {
        return this.rollNumber;
    }

    public final void setRollNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rollNumber = str;
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

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final void setDeviceId(String str) {
        this.deviceId = str;
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

    public final Drawable getCountryFlag() {
        return this.countryFlag;
    }

    public final void setCountryFlag(Drawable drawable) {
        this.countryFlag = drawable;
    }

    public final String getC_name() {
        return this.c_name;
    }

    public final void setC_name(String str) {
        this.c_name = str;
    }

    public final String getC_nameCode() {
        return this.c_nameCode;
    }

    public final void setC_nameCode(String str) {
        this.c_nameCode = str;
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

    /* JADX INFO: renamed from: isUserRegistered, reason: from getter */
    public final String getIsUserRegistered() {
        return this.isUserRegistered;
    }

    public final void setUserRegistered(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.isUserRegistered = str;
    }

    /* JADX INFO: renamed from: is_google_login_enable, reason: from getter */
    public final boolean getIs_google_login_enable() {
        return this.is_google_login_enable;
    }

    public final void set_google_login_enable(boolean z) {
        this.is_google_login_enable = z;
    }

    public final String getSocialToken() {
        return this.socialToken;
    }

    public final void setSocialToken(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.socialToken = str;
    }

    public final String getSocialType() {
        return this.socialType;
    }

    public final void setSocialType(String str) {
        this.socialType = str;
    }

    /* JADX INFO: renamed from: isSocial, reason: from getter */
    public final String getIsSocial() {
        return this.isSocial;
    }

    public final void setSocial(String str) {
        this.isSocial = str;
    }

    /* JADX INFO: renamed from: isSocialLoginAttempt, reason: from getter */
    public final boolean getIsSocialLoginAttempt() {
        return this.isSocialLoginAttempt;
    }

    public final void setSocialLoginAttempt(boolean z) {
        this.isSocialLoginAttempt = z;
    }

    public final int getRequestCode() {
        return this.requestCode;
    }

    public final void setRequestCode(int i) {
        this.requestCode = i;
    }

    public final long getMLastClickTime() {
        return this.mLastClickTime;
    }

    public final void setMLastClickTime(long j) {
        this.mLastClickTime = j;
    }

    /* JADX INFO: renamed from: isForgetPassword, reason: from getter */
    public final boolean getIsForgetPassword() {
        return this.isForgetPassword;
    }

    public final void setForgetPassword(boolean z) {
        this.isForgetPassword = z;
    }

    /* JADX INFO: renamed from: isDefaultEmail, reason: from getter */
    public final boolean getIsDefaultEmail() {
        return this.isDefaultEmail;
    }

    public final void setDefaultEmail(boolean z) {
        this.isDefaultEmail = z;
    }

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        this.activity = fragmentActivityRequireActivity;
        Helper.setStatusBarIconsLight(fragmentActivityRequireActivity, fragmentActivityRequireActivity != null ? fragmentActivityRequireActivity.getWindow() : null, false);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        setBinding(FragmentLoginWithOtpNewBinding.inflate(inflater, container, false));
        return getBinding().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUser(Data.getInstance());
        this.utkashRoom = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        Helper.preventLeadingSpaces(getBinding().etName);
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
        if (SharedPreference.getInstance().getString(Const.SHOW_ROLL_NUMBER) != null && StringsKt.equals(SharedPreference.getInstance().getString(Const.SHOW_ROLL_NUMBER), "1", true)) {
            LabeledEditText labeledEditText = getBinding().etRollNumber;
            if (labeledEditText != null) {
                labeledEditText.setVisibility(0);
            }
        } else {
            LabeledEditText labeledEditText2 = getBinding().etRollNumber;
            if (labeledEditText2 != null) {
                labeledEditText2.setVisibility(8);
            }
        }
        getMobileNumber();
        Activity activity = this.activity;
        this.deviceId = Settings.Secure.getString(activity != null ? activity.getContentResolver() : null, "android_id");
        this.is_google_login_enable = StringsKt.equals(SharedPreference.getInstance().getString(Const.IS_GOOGLE_LOGIN_ENABLE), "1", true);
        this.is_show_email = StringsKt.equals(SharedPreference.getInstance().getString(Const.EMAIL_SHOW), "1", true);
        this.country = StringsKt.equals(SharedPreference.getInstance().getString(Const.COUNTRY_SHOW), "1", true);
        getBinding().etRollNumber.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(20)});
        Helper.removeEditTextWhiteSpace(getBinding().etEmail);
        Helper.removeEditTextWhiteSpace(getBinding().emailTV);
        Helper.removeEditTextWhiteSpace(getBinding().etPassword);
        GoogleSignInOptions googleSignInOptionsBuild = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        Intrinsics.checkNotNullExpressionValue(googleSignInOptionsBuild, "build(...)");
        this.googleApiClient = new GoogleApiClient.Builder(requireActivity()).addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptionsBuild).build();
        Context context = getContext();
        Helper.mGoogleSignInClient = context != null ? GoogleSignIn.getClient(context, googleSignInOptionsBuild) : null;
        Helper.mGoogleSignInClient.signOut();
        if (this.is_google_login_enable) {
            getBinding().googleLL.setVisibility(0);
        } else {
            getBinding().googleLL.setVisibility(8);
        }
        if (this.is_show_email || Helper.isDefaultEmail()) {
            getBinding().emailLL.setVisibility(0);
        } else {
            getBinding().emailLL.setVisibility(8);
        }
        if (getBinding().emailLL.getVisibility() == 0 || getBinding().googleLL.getVisibility() == 0) {
            getBinding().tvOr.setVisibility(0);
        } else {
            getBinding().tvOr.setVisibility(8);
        }
        if (getBinding().emailLL.getVisibility() == 0 && getBinding().googleLL.getVisibility() == 0) {
            getBinding().viewExtra.setVisibility(0);
        } else {
            getBinding().viewExtra.setVisibility(8);
        }
        if (SharedPreference.getInstance().getString("user_define_id") != null && !TextUtils.isEmpty(SharedPreference.getInstance().getString("user_define_id"))) {
            getBinding().verifyIdET.setText(SharedPreference.getInstance().getString("user_define_id"));
        }
        if (this.country) {
            getBinding().flagCountryLL.setVisibility(0);
            getBinding().flagRL.setVisibility(8);
        } else {
            getBinding().flagCountryLL.setVisibility(8);
            getBinding().flagRL.setVisibility(0);
            getBinding().etEmail.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(10)});
        }
        getBinding().countryDropDown.registerCarrierNumberEditText(getBinding().etEmail);
        if (this.country) {
            this.c_code = getBinding().countryDropDown.getSelectedCountryCodeWithPlus();
            this.countryFlag = getBinding().countryDropDown.getImageViewFlag().getDrawable();
        } else {
            this.c_code = "+91";
        }
        if (this.isChangePass) {
            getBinding().etEmail.setEnabled(false);
            getBinding().etEmail.setFocusable(false);
            getBinding().etEmail.setText(SharedPreference.getInstance().getLoggedInUser().getMobile());
            if (this.country) {
                String cCode = SharedPreference.getInstance().getLoggedInUser().getCCode();
                getBinding().countryDropDown.setCcpClickable(false);
                getBinding().countryDropDown.setCountryForPhoneCode(Helper.converToIntCountryCode(cCode));
            }
        }
        if (SharedPreference.getInstance().getString(Const.CONTACTUS_MOBILE1) != null && !SharedPreference.getInstance().getString(Const.CONTACTUS_MOBILE1).equals("")) {
            getBinding().contactNumber.setText(SharedPreference.getInstance().getString(Const.CONTACTUS_MOBILE1));
        } else if (SharedPreference.getInstance().getString(Const.CONTACTUS_MOBILE2) != null && !SharedPreference.getInstance().getString(Const.CONTACTUS_MOBILE2).equals("")) {
            getBinding().contactNumber.setText(SharedPreference.getInstance().getString(Const.CONTACTUS_MOBILE2));
        } else {
            LinearLayout linearLayout5 = getBinding().contactUsLinear;
            if (linearLayout5 != null) {
                linearLayout5.setVisibility(8);
            }
        }
        if (StringsKt.equals(BuildConfig.FLAVOR, "sme", true)) {
            LinearLayout linearLayout6 = getBinding().termAndConditionRel;
            if (linearLayout6 != null) {
                linearLayout6.getVisibility();
            }
        } else {
            LinearLayout linearLayout7 = getBinding().termAndConditionRel;
            if (linearLayout7 != null) {
                linearLayout7.getVisibility();
            }
        }
        getBinding().etEmail.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.appnew.android.loginRevamp.Fragment.LoginFragmentNew$$ExternalSyntheticLambda3
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return LoginFragmentNew.onViewCreated$lambda$1(this.f$0, textView, i, keyEvent);
            }
        });
        getBinding().googleLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.loginRevamp.Fragment.LoginFragmentNew$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LoginFragmentNew.onViewCreated$lambda$2(this.f$0, view2);
            }
        });
        getBinding().emailLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.loginRevamp.Fragment.LoginFragmentNew$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LoginFragmentNew.onViewCreated$lambda$3(this.f$0, view2);
            }
        });
        getBinding().loginBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.loginRevamp.Fragment.LoginFragmentNew$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LoginFragmentNew.onViewCreated$lambda$4(this.f$0, view2);
            }
        });
        getBinding().forgetpasswordTV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.loginRevamp.Fragment.LoginFragmentNew$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LoginFragmentNew.onViewCreated$lambda$5(this.f$0, view2);
            }
        });
        getBinding().tvTermAndCondition.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.loginRevamp.Fragment.LoginFragmentNew$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LoginFragmentNew.onViewCreated$lambda$6(this.f$0, view2);
            }
        });
        getBinding().loginBtn2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.loginRevamp.Fragment.LoginFragmentNew$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LoginFragmentNew.onViewCreated$lambda$7(this.f$0, view2);
            }
        });
        getBinding().attendanceIn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.loginRevamp.Fragment.LoginFragmentNew$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LoginFragmentNew.onViewCreated$lambda$8(this.f$0, view2);
            }
        });
        getBinding().contactNumber.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.loginRevamp.Fragment.LoginFragmentNew$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LoginFragmentNew.onViewCreated$lambda$9(this.f$0, view2);
            }
        });
        if (Helper.isDefaultEmail() || com.appnew.android.home.Constants.isEmailDefault) {
            showEmailOrMobile(true);
        } else {
            showEmailOrMobile(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$1(LoginFragmentNew loginFragmentNew, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6 || !loginFragmentNew.isUserRegistered.equals("0")) {
            return false;
        }
        loginFragmentNew.getBinding().loginBtn.performClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(LoginFragmentNew loginFragmentNew, View view) {
        if (SystemClock.elapsedRealtime() - loginFragmentNew.mLastClickTime < 1000) {
            return;
        }
        loginFragmentNew.mLastClickTime = SystemClock.elapsedRealtime();
        GoogleSignInApi googleSignInApi = Auth.GoogleSignInApi;
        GoogleApiClient googleApiClient = loginFragmentNew.googleApiClient;
        Intrinsics.checkNotNull(googleApiClient);
        Intent signInIntent = googleSignInApi.getSignInIntent(googleApiClient);
        Intrinsics.checkNotNullExpressionValue(signInIntent, "getSignInIntent(...)");
        loginFragmentNew.otpLauncher.launch(signInIntent);
        loginFragmentNew.requestCode = loginFragmentNew.RC_SIGN_IN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(LoginFragmentNew loginFragmentNew, View view) {
        if (SystemClock.elapsedRealtime() - loginFragmentNew.mLastClickTime < 1000) {
            return;
        }
        loginFragmentNew.mLastClickTime = SystemClock.elapsedRealtime();
        loginFragmentNew.showEmailOrMobile(loginFragmentNew.isDefaultEmail);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4(LoginFragmentNew loginFragmentNew, View view) {
        if (SystemClock.elapsedRealtime() - loginFragmentNew.mLastClickTime < 1000) {
            return;
        }
        loginFragmentNew.mLastClickTime = SystemClock.elapsedRealtime();
        loginFragmentNew.CheckValidation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$5(LoginFragmentNew loginFragmentNew, View view) {
        if (SystemClock.elapsedRealtime() - loginFragmentNew.mLastClickTime < 1000) {
            return;
        }
        loginFragmentNew.mLastClickTime = SystemClock.elapsedRealtime();
        loginFragmentNew.getUser().setEmail(loginFragmentNew.email);
        loginFragmentNew.getUser().setMobile(loginFragmentNew.phone);
        SharedPreference.getInstance().setLoggedInUserr(loginFragmentNew.getUser());
        Helper.hideKeyboard(loginFragmentNew.activity);
        loginFragmentNew.isForgetPassword = true;
        loginFragmentNew.handleDeviceToken(loginFragmentNew.email, loginFragmentNew.phone, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$6(LoginFragmentNew loginFragmentNew, View view) {
        if (SystemClock.elapsedRealtime() - loginFragmentNew.mLastClickTime < 1000) {
            return;
        }
        loginFragmentNew.mLastClickTime = SystemClock.elapsedRealtime();
        CommonWebViewFragmentNew commonWebViewFragmentNewNewInstance = CommonWebViewFragmentNew.INSTANCE.newInstance(API.TERMS_AND_CONDITIONS, false);
        Activity activity = loginFragmentNew.activity;
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        commonWebViewFragmentNewNewInstance.show(((AppCompatActivity) activity).getSupportFragmentManager(), commonWebViewFragmentNewNewInstance.getTag());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$7(LoginFragmentNew loginFragmentNew, View view) {
        if (SystemClock.elapsedRealtime() - loginFragmentNew.mLastClickTime < 1000) {
            return;
        }
        loginFragmentNew.mLastClickTime = SystemClock.elapsedRealtime();
        loginFragmentNew.verificationMobileId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$8(LoginFragmentNew loginFragmentNew, View view) {
        if (SystemClock.elapsedRealtime() - loginFragmentNew.mLastClickTime < 1000) {
            return;
        }
        loginFragmentNew.mLastClickTime = SystemClock.elapsedRealtime();
        loginFragmentNew.verificationMobileId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$9(LoginFragmentNew loginFragmentNew, View view) {
        String string;
        if (SystemClock.elapsedRealtime() - loginFragmentNew.mLastClickTime < 1000) {
            return;
        }
        loginFragmentNew.mLastClickTime = SystemClock.elapsedRealtime();
        String[] strArr = new String[1];
        if (SharedPreference.getInstance().getString(Const.CONTACTUS_MOBILE1) != null && !SharedPreference.getInstance().getString(Const.CONTACTUS_MOBILE1).equals("")) {
            string = SharedPreference.getInstance().getString(Const.CONTACTUS_MOBILE1);
        } else if (SharedPreference.getInstance().getString(Const.CONTACTUS_MOBILE2) == null || SharedPreference.getInstance().getString(Const.CONTACTUS_MOBILE2).equals("")) {
            string = "";
        } else {
            string = SharedPreference.getInstance().getString(Const.CONTACTUS_MOBILE2);
        }
        if (string != null && !StringsKt.equals(string, "", true)) {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + string));
            Context context = loginFragmentNew.getContext();
            if (context != null) {
                context.startActivity(intent);
                return;
            }
            return;
        }
        Toast.makeText(loginFragmentNew.getContext(), "Mobile Number not exist from backend", 0);
    }

    private final void showEmailOrMobile(final boolean setEmail) {
        Activity activity = this.activity;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.appnew.android.loginRevamp.Fragment.LoginFragmentNew$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    LoginFragmentNew.showEmailOrMobile$lambda$10(setEmail, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showEmailOrMobile$lambda$10(boolean z, LoginFragmentNew loginFragmentNew) {
        ActivitySignInNewBinding binding;
        TextView textView;
        ActivitySignInNewBinding binding2;
        TextView textView2;
        com.appnew.android.home.Constants.isEmailDefault = z;
        loginFragmentNew.getBinding().etEmail.getText().clear();
        loginFragmentNew.getBinding().etEmail.setHint(loginFragmentNew.getResources().getString(R.string.enter_mobile_number));
        Editable text = loginFragmentNew.getBinding().emailTV.getText();
        if (text != null) {
            text.clear();
        }
        loginFragmentNew.getBinding().emailTV.setHint(loginFragmentNew.getResources().getString(R.string.enter_email));
        loginFragmentNew.isDefaultEmail = !z;
        if (z) {
            LabeledEditText emailTV = loginFragmentNew.getBinding().emailTV;
            Intrinsics.checkNotNullExpressionValue(emailTV, "emailTV");
            XtensionFunctionKt.visible(emailTV);
            loginFragmentNew.getBinding().emailTV.setEnabled(true);
            loginFragmentNew.getBinding().etEmail.setEnabled(false);
            RelativeLayout mobileRL = loginFragmentNew.getBinding().mobileRL;
            Intrinsics.checkNotNullExpressionValue(mobileRL, "mobileRL");
            XtensionFunctionKt.gone(mobileRL);
            loginFragmentNew.getBinding().loginUsingIV.setImageDrawable(ContextCompat.getDrawable(loginFragmentNew.requireActivity(), R.drawable.ic_otp_sms_24));
            loginFragmentNew.getBinding().loginUsingTV.setText(loginFragmentNew.getResources().getString(R.string.login_with_mobile));
            SignInNewActivity signInNewActivity = (SignInNewActivity) loginFragmentNew.getActivity();
            if (signInNewActivity != null && (binding2 = signInNewActivity.getBinding()) != null && (textView2 = binding2.welcomeDesc) != null) {
                textView2.setText(loginFragmentNew.getResources().getString(R.string.register_with_email));
            }
            if (TextUtils.isEmpty(com.appnew.android.home.Constants.LAST_EMAIL_ID)) {
                return;
            }
            loginFragmentNew.getBinding().emailTV.setText(com.appnew.android.home.Constants.LAST_EMAIL_ID);
            return;
        }
        RelativeLayout mobileRL2 = loginFragmentNew.getBinding().mobileRL;
        Intrinsics.checkNotNullExpressionValue(mobileRL2, "mobileRL");
        XtensionFunctionKt.visible(mobileRL2);
        loginFragmentNew.getBinding().etEmail.setEnabled(true);
        loginFragmentNew.getBinding().emailTV.setEnabled(false);
        LabeledEditText emailTV2 = loginFragmentNew.getBinding().emailTV;
        Intrinsics.checkNotNullExpressionValue(emailTV2, "emailTV");
        XtensionFunctionKt.gone(emailTV2);
        loginFragmentNew.getBinding().loginUsingIV.setImageDrawable(ContextCompat.getDrawable(loginFragmentNew.requireActivity(), R.drawable.ic_email_dark_24dp));
        loginFragmentNew.getBinding().loginUsingTV.setText(loginFragmentNew.getResources().getString(R.string.login_with_email));
        SignInNewActivity signInNewActivity2 = (SignInNewActivity) loginFragmentNew.getActivity();
        if (signInNewActivity2 != null && (binding = signInNewActivity2.getBinding()) != null && (textView = binding.welcomeDesc) != null) {
            textView.setText(loginFragmentNew.getResources().getString(R.string.register_with_mobile));
        }
        if (TextUtils.isEmpty(com.appnew.android.home.Constants.LAST_MOBILE_NUMBER)) {
            return;
        }
        loginFragmentNew.getBinding().etEmail.setText(com.appnew.android.home.Constants.LAST_MOBILE_NUMBER);
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
        try {
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
                    if (number != null && !TextUtils.isEmpty(number) && (StringsKt.contains$default((CharSequence) number, (CharSequence) MqttTopic.SINGLE_LEVEL_WILDCARD, false, 2, (Object) null) || StringsKt.startsWith$default(number, "91", false, 2, (Object) null))) {
                        if (number.length() > 10) {
                            String strSubstring = number.substring(number.length() - 10);
                            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                            arrayList.add(strSubstring);
                        }
                    }
                }
            }
            new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.loginRevamp.Fragment.LoginFragmentNew$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    LoginFragmentNew.checkPermissionDone$lambda$11(arrayList, this);
                }
            }, 1000L);
            Helper.logPrinter("mPhoneNumber", "d", new StringBuilder().append(arrayList).toString(), "");
        } catch (Exception e2) {
            Log.d("TAGUSERCHECK", "checkPermissionDone: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkPermissionDone$lambda$11(ArrayList arrayList, LoginFragmentNew loginFragmentNew) {
        if (arrayList.size() > 0) {
            loginFragmentNew.showPopupDialog(arrayList);
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
    public static final void activityResultLauncher$lambda$13(LoginFragmentNew loginFragmentNew, Map permissions) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Set<Map.Entry> setEntrySet = permissions.entrySet();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10));
        for (Map.Entry entry : setEntrySet) {
            String str = (String) entry.getKey();
            if (((Boolean) entry.getValue()).booleanValue() && StringsKt.equals(str, "android.permission.READ_PHONE_NUMBERS", true)) {
                loginFragmentNew.checkPermissionDone();
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
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.appnew.android.loginRevamp.Fragment.LoginFragmentNew$$ExternalSyntheticLambda19
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LoginFragmentNew.showPermissionDialog$lambda$14(context, dialogInterface, i);
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPermissionDialog$lambda$14(Activity activity, DialogInterface dialogInterface, int i) {
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
            ((LinearLayout) ((Dialog) objectRef.element).findViewById(R.id.numberPopup_LinerLayout1)).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.loginRevamp.Fragment.LoginFragmentNew$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LoginFragmentNew.showPopupDialog$lambda$15(objectRef, this, objectRef2, view);
                }
            });
            ((LinearLayout) ((Dialog) objectRef.element).findViewById(R.id.numberPopup_LinerLayout2)).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.loginRevamp.Fragment.LoginFragmentNew$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LoginFragmentNew.showPopupDialog$lambda$16(objectRef, this, objectRef3, view);
                }
            });
            ((Dialog) objectRef.element).show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void showPopupDialog$lambda$15(Ref.ObjectRef objectRef, LoginFragmentNew loginFragmentNew, Ref.ObjectRef objectRef2, View view) {
        ((Dialog) objectRef.element).dismiss();
        loginFragmentNew.getBinding().etEmail.setText(((TextView) objectRef2.element).getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void showPopupDialog$lambda$16(Ref.ObjectRef objectRef, LoginFragmentNew loginFragmentNew, Ref.ObjectRef objectRef2, View view) {
        ((Dialog) objectRef.element).dismiss();
        loginFragmentNew.getBinding().etEmail.setText(((TextView) objectRef2.element).getText());
    }

    private final void verificationMobileId() {
        EditText editText = getBinding().verifyIdET;
        if (!StringsKt.equals(String.valueOf(editText != null ? editText.getText() : null), "", true)) {
            EditText editText2 = getBinding().verifyIdET;
            if (String.valueOf(editText2 != null ? editText2.getText() : null).length() > 4) {
                this.socialToken = "123456";
                this.isSocial = "0";
                this.socialType = "0";
                this.isSocialLoginAttempt = false;
                EditText editText3 = getBinding().verifyIdET;
                this.registration_id = String.valueOf(editText3 != null ? editText3.getText() : null);
                hitApiLoginAuthentication();
                return;
            }
        }
        Toast.makeText(this.activity, "Please enter a Valid Id", 0).show();
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x03cd, code lost:
    
        if ((r1.length() > 0) != false) goto L118;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x05a8  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0367  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void CheckValidation() {
        /*
            Method dump skipped, instruction units count: 1566
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.loginRevamp.Fragment.LoginFragmentNew.CheckValidation():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckValidation$lambda$17(LoginFragmentNew loginFragmentNew, String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        loginFragmentNew.deviceTokenNew = token;
        loginFragmentNew.callLoginApi();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckValidation$lambda$18(LoginFragmentNew loginFragmentNew, Exception exc) {
        Toast.makeText(loginFragmentNew.requireActivity(), "Could not fetch device token", 0).show();
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
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
                    encryptionData.setMobile(this.isphone ? this.phone : this.email);
                    encryptionData.setOtp("");
                    encryptionData.setIs_registration(this.isForgetPassword ? "0" : "1");
                    encryptionData.setResend("0");
                    if (!this.isForgetPassword) {
                        encryptionData.setDevice_token(this.deviceTokenNew);
                    }
                    return service.getOtpVerification(AES.encrypt(new Gson().toJson(encryptionData)));
                }
                break;
            case -129172072:
                if (apitype.equals(API.API_USER_LOGIN_AUTHENTICATION)) {
                    EncryptionData encryptionData2 = new EncryptionData();
                    if (this.isSocialLoginAttempt) {
                        encryptionData2.setMobile("");
                        encryptionData2.setEmail(this.email);
                        encryptionData2.setSocial_type(this.socialType);
                        encryptionData2.setSocial_token(this.socialToken);
                        encryptionData2.setDevice_tokken(this.deviceTokenNew);
                        encryptionData2.setPassword("");
                    } else {
                        if (SharedPreference.getInstance().getString(Const.OTP_LOGIN).equals("1")) {
                            encryptionData2.setMobile(this.registration_id);
                            encryptionData2.setPassword(this.registration_id);
                        } else {
                            encryptionData2.setMobile(this.isphone ? this.phone : this.email);
                            encryptionData2.setPassword(this.password);
                        }
                        if (SharedPreference.getInstance().getString(Const.SHOW_ROLL_NUMBER) == null || !StringsKt.equals(SharedPreference.getInstance().getString(Const.SHOW_ROLL_NUMBER), "1", true)) {
                            encryptionData2.setRegistration_id(this.registration_id);
                        } else {
                            encryptionData2.setRegistration_id(this.rollNumber);
                        }
                        encryptionData2.setDevice_tokken(this.deviceTokenNew);
                        encryptionData2.setC_code(this.c_code);
                    }
                    encryptionData2.setDevice_id(this.deviceId);
                    encryptionData2.setIs_social(this.isSocial);
                    LocationInfo locationInfo = new LocationInfo();
                    locationInfo.setLat(TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.LOCATION_LAT)) ? "N/A" : SharedPreference.getInstance().getString(Const.LOCATION_LAT));
                    locationInfo.setLng(TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.LOCATION_LNG)) ? "N/A" : SharedPreference.getInstance().getString(Const.LOCATION_LNG));
                    locationInfo.setIp("");
                    locationInfo.setManufacturer(TextUtils.isEmpty(Build.MANUFACTURER) ? "N/A" : Build.MANUFACTURER);
                    locationInfo.setDevice_model(TextUtils.isEmpty(Build.MODEL) ? "N/A" : Build.MODEL);
                    locationInfo.setOs_version(TextUtils.isEmpty(Build.VERSION.RELEASE) ? "N/A" : Build.VERSION.RELEASE);
                    encryptionData2.setLocation(locationInfo);
                    String json = new Gson().toJson(encryptionData2);
                    Log.d("TAGUSERCHECK", "LoginFragmentNew: " + json);
                    return service.userLoginAuthentication(AES.encrypt(json));
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
                    encryptionData4.setMobile(getBinding().verifyIdET.getText().toString());
                    return service.getUserVerification(AES.encrypt(new Gson().toJson(encryptionData4)));
                }
                break;
            case 1100726652:
                if (apitype.equals(API.user_check)) {
                    EncryptionData encryptionData5 = new EncryptionData();
                    encryptionData5.setEmail(this.email);
                    encryptionData5.setMobile(this.phone);
                    return service.userCheck(AES.encrypt(new Gson().toJson(encryptionData5)));
                }
                break;
        }
        return service.getOtpVerification("");
    }

    /* JADX WARN: Code restructure failed: missing block: B:128:0x0746, code lost:
    
        if (r2.booleanValue() == false) goto L129;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.appnew.android.Utils.Network.MainFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void SuccessCallBack(org.json.JSONObject r27, java.lang.String r28, java.lang.String r29, boolean r30) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 2772
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.loginRevamp.Fragment.LoginFragmentNew.SuccessCallBack(org.json.JSONObject, java.lang.String, java.lang.String, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SuccessCallBack$lambda$21(LoginFragmentNew loginFragmentNew) {
        SignInNewActivity signInNewActivity = (SignInNewActivity) loginFragmentNew.getActivity();
        if (signInNewActivity != null) {
            signInNewActivity.mobileVerify();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.appnew.android.Utils.Network.MainFragment
    public void ErrorCallBack(final String jsonstring, String apitype, String typeApi) {
        Activity activity;
        Intrinsics.checkNotNullParameter(jsonstring, "jsonstring");
        Intrinsics.checkNotNullParameter(apitype, "apitype");
        Intrinsics.checkNotNullParameter(typeApi, "typeApi");
        if (!isAdded() || isDetached() || getLifecycle().getState() == Lifecycle.State.DESTROYED) {
            return;
        }
        switch (apitype.hashCode()) {
            case -1812137532:
                if (!apitype.equals(API.API_SEND_OTP_VERIFICATION) || (activity = this.activity) == null) {
                    return;
                }
                activity.runOnUiThread(new Runnable() { // from class: com.appnew.android.loginRevamp.Fragment.LoginFragmentNew$$ExternalSyntheticLambda13
                    @Override // java.lang.Runnable
                    public final void run() {
                        LoginFragmentNew.ErrorCallBack$lambda$28(this.f$0, jsonstring);
                    }
                });
                return;
            case -129172072:
                if (!apitype.equals(API.API_USER_LOGIN_AUTHENTICATION)) {
                    return;
                }
                break;
            case 1631865:
                if (!apitype.equals(API.get_my_profile)) {
                    return;
                }
                break;
            case 1100726652:
                if (!apitype.equals(API.user_check)) {
                    return;
                }
                break;
            default:
                return;
        }
        Activity activity2 = this.activity;
        if (activity2 != null) {
            activity2.runOnUiThread(new Runnable() { // from class: com.appnew.android.loginRevamp.Fragment.LoginFragmentNew$$ExternalSyntheticLambda14
                @Override // java.lang.Runnable
                public final void run() {
                    LoginFragmentNew.ErrorCallBack$lambda$29(this.f$0, jsonstring);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ErrorCallBack$lambda$28(LoginFragmentNew loginFragmentNew, String str) {
        Toast.makeText(loginFragmentNew.requireContext(), str, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ErrorCallBack$lambda$29(LoginFragmentNew loginFragmentNew, String str) {
        Context context = loginFragmentNew.getContext();
        if (context != null) {
            ExtensionFucationKt.showToast(context, str);
        }
    }

    public final ActivityResultLauncher<Intent> getOtpLauncher() {
        return this.otpLauncher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void otpLauncher$lambda$31(LoginFragmentNew loginFragmentNew, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getResultCode() == -1 && it.getData() != null && loginFragmentNew.requestCode == loginFragmentNew.RC_SIGN_IN) {
            GoogleSignInApi googleSignInApi = Auth.GoogleSignInApi;
            Intent data = it.getData();
            Intrinsics.checkNotNull(data);
            loginFragmentNew.handleSignInResult(googleSignInApi.getSignInResultFromIntent(data));
        }
    }

    private final void handleSignInResult(GoogleSignInResult result) {
        if (result != null && result.isSuccess()) {
            GoogleSignInAccount signInAccount = result.getSignInAccount();
            this.socialToken = String.valueOf(signInAccount != null ? signInAccount.getId() : null);
            this.isSocial = "1";
            this.socialType = "1";
            this.name = String.valueOf(signInAccount != null ? signInAccount.getDisplayName() : null);
            this.email = String.valueOf(signInAccount != null ? signInAccount.getEmail() : null);
            this.phone = "";
            this.isSocialLoginAttempt = true;
            getUser().setName(this.name);
            getUser().setEmail(this.email);
            getUser().setMobile(this.phone);
            handleDeviceToken(this.email, this.phone, true);
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

    private final void callLoginApi() {
        Helper.dismissProgressDialog();
        if (this.country) {
            this.c_code = getBinding().countryDropDown.getSelectedCountryCodeWithPlus();
        } else {
            this.c_code = "+91";
        }
        getUser().setEmail(this.email);
        getUser().setMobile(this.phone);
        getUser().setPassword(this.password);
        getUser().setIs_social(this.isSocial);
        getUser().setSocial_type(this.socialType);
        getUser().setSocial_tokken(this.socialToken);
        getUser().setDevice_type("1");
        getUser().setDevice_tokken(this.deviceTokenNew);
        SharedPreference.getInstance().setLoggedInUserr(getUser());
        Helper.hideKeyboard(this.activity);
        this.isSocialLoginAttempt = false;
        hitApiLoginAuthentication();
    }

    private final void handleDeviceToken(String email, String phone, final boolean isSocialLoginAttempt) {
        UserInfo userInfo = new UserInfo("", email, phone);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        FCMTokenHelper.getValidFCMToken(fragmentActivityRequireActivity, userInfo, new Function1() { // from class: com.appnew.android.loginRevamp.Fragment.LoginFragmentNew$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LoginFragmentNew.handleDeviceToken$lambda$32(this.f$0, isSocialLoginAttempt, (String) obj);
            }
        }, new Function1() { // from class: com.appnew.android.loginRevamp.Fragment.LoginFragmentNew$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LoginFragmentNew.handleDeviceToken$lambda$33(this.f$0, (Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleDeviceToken$lambda$32(LoginFragmentNew loginFragmentNew, boolean z, String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        loginFragmentNew.deviceTokenNew = token;
        if (!z) {
            loginFragmentNew.NetworkAPICall(API.API_SEND_OTP_VERIFICATION, "", true, false, false);
        } else {
            loginFragmentNew.hitApiLoginAuthentication();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleDeviceToken$lambda$33(LoginFragmentNew loginFragmentNew, Exception exc) {
        Toast.makeText(loginFragmentNew.requireActivity(), "Could not fetch device token", 0).show();
        return Unit.INSTANCE;
    }

    private final void showStudentClass(JSONObject jsonObject) throws JSONException {
        JSONObject jSONObject = jsonObject.getJSONObject("data").getJSONObject("change_detector").getJSONObject("version_control").getJSONObject("permissions");
        if (jSONObject.has(Const.SHOW_STUDENT_CLASS)) {
            String strOptString = jSONObject.optString(Const.SHOW_STUDENT_CLASS);
            Log.e("New_Login_Flow", "login " + strOptString);
            SharedPreference.getInstance().putString(Const.SHOW_STUDENT_CLASS_ON_PROFILE, strOptString);
        }
    }
}
