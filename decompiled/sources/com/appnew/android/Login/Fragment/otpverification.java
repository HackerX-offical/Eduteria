package com.appnew.android.Login.Fragment;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.appnew.android.BuildConfig;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.EncryptionModel.LocationInfo;
import com.appnew.android.ExtensionFunctions.XtensionFunctionKt;
import com.appnew.android.FacebookEventLogger;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Sms.SmsBroadcastReceiver;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.MainFragment;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.firebaseToken.FCMTokenHelper;
import com.appnew.android.cleverTap.AnalyticHelper;
import com.appnew.android.databinding.FragmentOtpverifcationBinding;
import com.appnew.android.pojo.Userinfo.Data;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.tv9news.utils.helpers.AnalyticEvents;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import retrofit2.Call;

/* JADX INFO: compiled from: otpverification.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 ³\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002³\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010k\u001a\u00020lH\u0016J\b\u0010m\u001a\u00020lH\u0016J\b\u0010n\u001a\u00020lH\u0016J\u0010\u0010o\u001a\u00020l2\b\u0010p\u001a\u0004\u0018\u00010qJ\u0012\u0010r\u001a\u00020l2\b\u0010s\u001a\u0004\u0018\u00010tH\u0016J$\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020x2\b\u0010y\u001a\u0004\u0018\u00010z2\b\u0010s\u001a\u0004\u0018\u00010tH\u0016J\b\u0010{\u001a\u00020lH\u0002J\u0006\u0010|\u001a\u00020lJ\u0012\u0010}\u001a\u00020\u000e2\b\u0010~\u001a\u0004\u0018\u00010\u000eH\u0002J\u001b\u0010\u007f\u001a\u00020l2\u0007\u0010\u0080\u0001\u001a\u00020v2\b\u0010s\u001a\u0004\u0018\u00010tH\u0016J,\u0010\u0081\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0\u0082\u00012\u0007\u0010\u0083\u0001\u001a\u00020\u000e2\u0007\u0010\u0084\u0001\u001a\u00020\u000e2\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0016J.\u0010\u0089\u0001\u001a\u00020l2\b\u0010\u008a\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u0083\u0001\u001a\u00020\u000e2\u0007\u0010\u0084\u0001\u001a\u00020\u000e2\u0007\u0010\u008c\u0001\u001a\u000207H\u0016J\t\u0010\u008d\u0001\u001a\u00020lH\u0002J$\u0010\u008e\u0001\u001a\u00020l2\u0007\u0010\u008f\u0001\u001a\u00020\u000e2\u0007\u0010\u0083\u0001\u001a\u00020\u000e2\u0007\u0010\u0084\u0001\u001a\u00020\u000eH\u0016J.\u0010\u0090\u0001\u001a\u00020l2\b\u0010\u0091\u0001\u001a\u00030\u0092\u00012\u0007\u0010\u0093\u0001\u001a\u00020%2\u0007\u0010\u0094\u0001\u001a\u00020%2\u0007\u0010\u0095\u0001\u001a\u00020%H\u0016J.\u0010\u0096\u0001\u001a\u00020l2\b\u0010\u0097\u0001\u001a\u00030\u0092\u00012\u0007\u0010\u0093\u0001\u001a\u00020%2\u0007\u0010\u0094\u0001\u001a\u00020%2\u0007\u0010\u0095\u0001\u001a\u00020%H\u0016J\t\u0010\u0098\u0001\u001a\u00020lH\u0002J\u0011\u0010\u0099\u0001\u001a\u00020l2\b\u0010p\u001a\u0004\u0018\u00010qJ\u0013\u0010\u009a\u0001\u001a\u00020l2\b\u0010\u009b\u0001\u001a\u00030\u009c\u0001H\u0016J\u001b\u0010\u009d\u0001\u001a\u00020l2\u0007\u0010\u0080\u0001\u001a\u00020v2\u0007\u0010\u009e\u0001\u001a\u000207H\u0016J%\u0010\u009f\u0001\u001a\u0002072\u0007\u0010\u0080\u0001\u001a\u00020v2\u0007\u0010 \u0001\u001a\u00020%2\b\u0010¡\u0001\u001a\u00030¢\u0001H\u0016J'\u0010£\u0001\u001a\u00020l2\u0007\u0010¤\u0001\u001a\u00020%2\u0007\u0010¥\u0001\u001a\u00020%2\n\u0010¦\u0001\u001a\u0005\u0018\u00010§\u0001H\u0016J\u0013\u0010¨\u0001\u001a\u00020l2\b\u0010~\u001a\u0004\u0018\u00010\u000eH\u0002J\u0007\u0010©\u0001\u001a\u00020lJ\t\u0010ª\u0001\u001a\u00020lH\u0002J\t\u0010±\u0001\u001a\u00020lH\u0016J\t\u0010²\u0001\u001a\u00020lH\u0002R\u001a\u0010\u0007\u001a\u00020\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u001a\u0010\u001c\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0012R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0010\"\u0004\b,\u0010\u0012R\u001c\u0010-\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0010\"\u0004\b/\u0010\u0012R\u001a\u00100\u001a\u000201X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u000e\u00106\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010:\u001a\u0004\u0018\u00010;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010@\u001a\u000207X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010E\u001a\u0004\u0018\u00010FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010K\u001a\u00020LX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001c\u0010Q\u001a\u0004\u0018\u00010RX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001c\u0010W\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u0010\"\u0004\bY\u0010\u0012R\u001c\u0010Z\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u0010\"\u0004\b[\u0010\u0012R\u001c\u0010\\\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u0010\"\u0004\b^\u0010\u0012R\u001c\u0010_\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u0010\"\u0004\ba\u0010\u0012R\u001c\u0010b\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\u0010\"\u0004\bd\u0010\u0012R\u001a\u0010e\u001a\u00020fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u001d\u0010\u0087\u0001\u001a\u000207X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010B\"\u0005\b\u0088\u0001\u0010DR'\u0010«\u0001\u001a\n\u0012\u0005\u0012\u00030§\u00010¬\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u00ad\u0001\u0010®\u0001\"\u0006\b¯\u0001\u0010°\u0001¨\u0006´\u0001"}, d2 = {"Lcom/appnew/android/Login/Fragment/otpverification;", "Lcom/appnew/android/Utils/Network/MainFragment;", "Landroid/view/View$OnFocusChangeListener;", "Landroid/view/View$OnKeyListener;", "Landroid/text/TextWatcher;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/FragmentOtpverifcationBinding;", "getBinding", "()Lcom/appnew/android/databinding/FragmentOtpverifcationBinding;", "setBinding", "(Lcom/appnew/android/databinding/FragmentOtpverifcationBinding;)V", Const.OTP, "", "getOtp", "()Ljava/lang/String;", "setOtp", "(Ljava/lang/String;)V", "LoginType", "getLoginType", "setLoginType", "otptext", "getOtptext", "setOtptext", SDKConstants.PARAM_USER_ID, "getUserID", "setUserID", "isReg", "setReg", "utkashRoom", "Lcom/appnew/android/Room/UtkashRoom;", "getUtkashRoom", "()Lcom/appnew/android/Room/UtkashRoom;", "setUtkashRoom", "(Lcom/appnew/android/Room/UtkashRoom;)V", "type", "", "getType", "()I", "setType", "(I)V", "deviceTokenNew", "getDeviceTokenNew", "setDeviceTokenNew", Constants.DEVICE_ID_TAG, "getDeviceId", "setDeviceId", "user", "Lcom/appnew/android/pojo/Userinfo/Data;", "getUser", "()Lcom/appnew/android/pojo/Userinfo/Data;", "setUser", "(Lcom/appnew/android/pojo/Userinfo/Data;)V", "resetPass", "", "isChangePass", "isphone", "broadcastReceiver", "Landroid/content/BroadcastReceiver;", "getBroadcastReceiver", "()Landroid/content/BroadcastReceiver;", "setBroadcastReceiver", "(Landroid/content/BroadcastReceiver;)V", "status", "getStatus", "()Z", "setStatus", "(Z)V", "countDownTimer", "Landroid/os/CountDownTimer;", "getCountDownTimer", "()Landroid/os/CountDownTimer;", "setCountDownTimer", "(Landroid/os/CountDownTimer;)V", "leftmillisUntilFinished", "", "getLeftmillisUntilFinished", "()J", "setLeftmillisUntilFinished", "(J)V", "smsBroadcastReceiver", "Lcom/appnew/android/Sms/SmsBroadcastReceiver;", "getSmsBroadcastReceiver", "()Lcom/appnew/android/Sms/SmsBroadcastReceiver;", "setSmsBroadcastReceiver", "(Lcom/appnew/android/Sms/SmsBroadcastReceiver;)V", "socialType", "getSocialType", "setSocialType", "isSocial", "setSocial", "c_code", "getC_code", "setC_code", Const.C_NAME, "getC_name", "setC_name", "c_nameCode", "getC_nameCode", "setC_nameCode", "flagArr", "", "getFlagArr", "()[B", "setFlagArr", "([B)V", "onResume", "", "onDestroy", "onStop", "hideSoftKeyboard", "editText", "Landroid/widget/EditText;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "startSmartUserConsent", "AutoReadMessage", "parseCode", "message", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "isResendOtp", "setResendOtp", "SuccessCallBack", "jsonObject", "Lorg/json/JSONObject;", "showprogress", "claerdata", "ErrorCallBack", "jsonstring", "beforeTextChanged", "charSequence", "", CmcdData.Factory.OBJECT_TYPE_INIT_SEGMENT, "i1", "i2", "onTextChanged", CmcdData.Factory.STREAMING_FORMAT_SS, "setPINListeners", "showSoftKeyboard", "afterTextChanged", "editable", "Landroid/text/Editable;", "onFocusChange", "hasFocus", "onKey", "keyCode", "keyEvent", "Landroid/view/KeyEvent;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "getOtpFromMessage", "setTimer", "registerBroadcastReceiver", "otplauncher", "Landroidx/activity/result/ActivityResultLauncher;", "getOtplauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "setOtplauncher", "(Landroidx/activity/result/ActivityResultLauncher;)V", "onStart", "pushEvent", "Companion", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class otpverification extends MainFragment implements View.OnFocusChangeListener, View.OnKeyListener, TextWatcher {
    private static final int REQ_USER_CONSENT = 200;
    public FragmentOtpverifcationBinding binding;
    private BroadcastReceiver broadcastReceiver;
    private String c_code;
    private String c_name;
    private String c_nameCode;
    private CountDownTimer countDownTimer;
    private String deviceId;
    public byte[] flagArr;
    private boolean isChangePass;
    private boolean isResendOtp;
    private String isSocial;
    private boolean isphone;
    private long leftmillisUntilFinished;
    private ActivityResultLauncher<Intent> otplauncher;
    private boolean resetPass;
    private String socialType;
    private boolean status;
    private int type;
    public Data user;
    private String userID;
    private UtkashRoom utkashRoom;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private String otp = "";
    private String LoginType = "";
    private String otptext = "";
    private String isReg = "0";
    private String deviceTokenNew = "";
    private SmsBroadcastReceiver smsBroadcastReceiver = new SmsBroadcastReceiver();

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        Intrinsics.checkNotNullParameter(jsonstring, "jsonstring");
        Intrinsics.checkNotNullParameter(apitype, "apitype");
        Intrinsics.checkNotNullParameter(typeApi, "typeApi");
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Intrinsics.checkNotNullParameter(editable, "editable");
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
    }

    public otpverification() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.Login.Fragment.otpverification$$ExternalSyntheticLambda1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                otpverification.otplauncher$lambda$31(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.otplauncher = activityResultLauncherRegisterForActivityResult;
    }

    public final FragmentOtpverifcationBinding getBinding() {
        FragmentOtpverifcationBinding fragmentOtpverifcationBinding = this.binding;
        if (fragmentOtpverifcationBinding != null) {
            return fragmentOtpverifcationBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(FragmentOtpverifcationBinding fragmentOtpverifcationBinding) {
        Intrinsics.checkNotNullParameter(fragmentOtpverifcationBinding, "<set-?>");
        this.binding = fragmentOtpverifcationBinding;
    }

    public final String getOtp() {
        return this.otp;
    }

    public final void setOtp(String str) {
        this.otp = str;
    }

    public final String getLoginType() {
        return this.LoginType;
    }

    public final void setLoginType(String str) {
        this.LoginType = str;
    }

    public final String getOtptext() {
        return this.otptext;
    }

    public final void setOtptext(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.otptext = str;
    }

    public final String getUserID() {
        return this.userID;
    }

    public final void setUserID(String str) {
        this.userID = str;
    }

    /* JADX INFO: renamed from: isReg, reason: from getter */
    public final String getIsReg() {
        return this.isReg;
    }

    public final void setReg(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.isReg = str;
    }

    public final UtkashRoom getUtkashRoom() {
        return this.utkashRoom;
    }

    public final void setUtkashRoom(UtkashRoom utkashRoom) {
        this.utkashRoom = utkashRoom;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
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

    public final BroadcastReceiver getBroadcastReceiver() {
        return this.broadcastReceiver;
    }

    public final void setBroadcastReceiver(BroadcastReceiver broadcastReceiver) {
        this.broadcastReceiver = broadcastReceiver;
    }

    public final boolean getStatus() {
        return this.status;
    }

    public final void setStatus(boolean z) {
        this.status = z;
    }

    public final CountDownTimer getCountDownTimer() {
        return this.countDownTimer;
    }

    public final void setCountDownTimer(CountDownTimer countDownTimer) {
        this.countDownTimer = countDownTimer;
    }

    public final long getLeftmillisUntilFinished() {
        return this.leftmillisUntilFinished;
    }

    public final void setLeftmillisUntilFinished(long j) {
        this.leftmillisUntilFinished = j;
    }

    public final SmsBroadcastReceiver getSmsBroadcastReceiver() {
        return this.smsBroadcastReceiver;
    }

    public final void setSmsBroadcastReceiver(SmsBroadcastReceiver smsBroadcastReceiver) {
        this.smsBroadcastReceiver = smsBroadcastReceiver;
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

    public final String getC_code() {
        return this.c_code;
    }

    public final void setC_code(String str) {
        this.c_code = str;
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

    public final byte[] getFlagArr() {
        byte[] bArr = this.flagArr;
        if (bArr != null) {
            return bArr;
        }
        Intrinsics.throwUninitializedPropertyAccessException("flagArr");
        return null;
    }

    public final void setFlagArr(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<set-?>");
        this.flagArr = bArr;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        Intrinsics.checkNotNull(appCompatActivity);
        ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
        Intrinsics.checkNotNull(supportActionBar);
        supportActionBar.hide();
        requireActivity().getWindow();
        if (SharedPreference.getInstance().getString(Const.AUTO_FILL_OTP).equals("1")) {
            FragmentOtpverifcationBinding binding = getBinding();
            binding.OPT1ET.setEnabled(false);
            binding.OPT2ET.setEnabled(false);
            binding.OPT3ET.setEnabled(false);
            binding.OPT4ET.setEnabled(false);
            binding.OPT5ET.setEnabled(false);
            binding.OPT6ET.setEnabled(false);
            binding.OPT1ET.setCursorVisible(false);
            return;
        }
        FragmentOtpverifcationBinding binding2 = getBinding();
        binding2.OPT1ET.setEnabled(true);
        binding2.OPT2ET.setEnabled(true);
        binding2.OPT3ET.setEnabled(true);
        binding2.OPT4ET.setEnabled(true);
        binding2.OPT5ET.setEnabled(true);
        binding2.OPT6ET.setEnabled(true);
        binding2.OPT1ET.setCursorVisible(true);
    }

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        try {
            if (this.smsBroadcastReceiver != null) {
                requireActivity().unregisterReceiver(this.smsBroadcastReceiver);
            }
        } catch (Exception e2) {
            Log.d("onStop", "onStop: " + e2.getMessage());
        }
        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        Intrinsics.checkNotNull(appCompatActivity);
        ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
        Intrinsics.checkNotNull(supportActionBar);
        supportActionBar.show();
        requireActivity().getWindow().getDecorView().setSystemUiVisibility(8192);
    }

    public final void hideSoftKeyboard(EditText editText) {
        if (editText == null) {
            return;
        }
        Object systemService = this.activity.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.activity = getActivity();
        this.utkashRoom = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        this.deviceId = Settings.Secure.getString(this.activity.getContentResolver(), "android_id");
        if (getArguments() != null) {
            this.otp = requireArguments().getString(Const.OTP);
            this.LoginType = requireArguments().getString(Const.LoginWithOtp);
            this.type = requireArguments().getInt("type");
            this.resetPass = requireArguments().getBoolean(Const.RESET_PASS);
            this.isChangePass = requireArguments().getBoolean(Const.IS_CHANGE_PASS);
            this.isphone = requireArguments().getBoolean("isphone");
            this.socialType = requireArguments().getString(Const.SOCIAL_TYPE);
            this.isSocial = requireArguments().getString(Const.IS_SOCIAL);
            this.c_code = requireArguments().getString("c_code");
            this.c_name = requireArguments().getString(Const.C_NAME);
            this.c_nameCode = requireArguments().getString(Const.C_NAME_CODE);
            if (requireArguments().getByteArray(Const.C_FLAG) != null) {
                byte[] byteArray = requireArguments().getByteArray(Const.C_FLAG);
                Intrinsics.checkNotNull(byteArray, "null cannot be cast to non-null type kotlin.ByteArray");
                setFlagArr(byteArray);
            }
        }
        startSmartUserConsent();
        if (StringsKt.equals$default(this.LoginType, Const.LoginWithOtp, false, 2, null)) {
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
            this.deviceTokenNew = String.valueOf(FCMTokenHelper.getSavedToken(fragmentActivityRequireActivity));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        setBinding(FragmentOtpverifcationBinding.inflate(inflater, container, false));
        NestedScrollView root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    private final void startSmartUserConsent() {
        SmsRetrieverClient client = SmsRetriever.getClient(this.activity);
        Intrinsics.checkNotNullExpressionValue(client, "getClient(...)");
        client.startSmsUserConsent(null);
    }

    public final void AutoReadMessage() {
        this.broadcastReceiver = new BroadcastReceiver() { // from class: com.appnew.android.Login.Fragment.otpverification.AutoReadMessage.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                Bundle extras = intent.getExtras();
                Intrinsics.checkNotNull(extras);
                String string = extras.getString("message");
                Helper.logPrinter(otpverification.this.activity.getLocalClassName(), "e", string, "Message");
                try {
                    Intrinsics.checkNotNull(string);
                    String string2 = otpverification.this.activity.getResources().getString(R.string.app_name);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    if (StringsKt.contains$default((CharSequence) string, (CharSequence) string2, false, 2, (Object) null)) {
                        otpverification otpverificationVar = otpverification.this;
                        otpverificationVar.setOtptext(otpverificationVar.parseCode(string));
                        Helper.logPrinter(otpverification.this.activity.getLocalClassName(), "e", otpverification.this.getOtptext(), "Message");
                        FragmentOtpverifcationBinding binding = otpverification.this.getBinding();
                        otpverification otpverificationVar2 = otpverification.this;
                        binding.pinHiddenEdittext.setText(otpverificationVar2.getOtptext());
                        binding.OPT1ET.setText(String.valueOf(otpverificationVar2.getOtptext().charAt(0)));
                        binding.OPT2ET.setText(String.valueOf(otpverificationVar2.getOtptext().charAt(1)));
                        binding.OPT3ET.setText(String.valueOf(otpverificationVar2.getOtptext().charAt(2)));
                        binding.OPT4ET.setText(String.valueOf(otpverificationVar2.getOtptext().charAt(3)));
                        binding.OPT5ET.setText(String.valueOf(otpverificationVar2.getOtptext().charAt(4)));
                        binding.OPT6ET.setText(String.valueOf(otpverificationVar2.getOtptext().charAt(5)));
                        binding.OPT1ET.setEnabled(false);
                        binding.OPT2ET.setEnabled(false);
                        binding.OPT3ET.setEnabled(false);
                        binding.OPT4ET.setEnabled(false);
                        binding.OPT5ET.setEnabled(false);
                        binding.OPT6ET.setEnabled(false);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        };
        requireActivity().registerReceiver(this.broadcastReceiver, new IntentFilter("broadCastOtp"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String parseCode(String message) {
        Matcher matcher = Pattern.compile("\\b\\d{6}\\b").matcher(message);
        String strGroup = "";
        while (matcher.find()) {
            strGroup = matcher.group(0);
        }
        return strGroup;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setPINListeners();
        getBinding().ivBack.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Login.Fragment.otpverification$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return otpverification.onViewCreated$lambda$2(this.f$0);
            }
        }));
        setUser(Data.getInstance());
        int i = this.type;
        if (i == 7) {
            str = "1";
        } else {
            str = "0";
        }
        this.isReg = str;
        if (i == 7) {
            this.isphone = true;
        }
        if (i == 2) {
            getBinding().verifyTextTV.setText("Verify number - " + SharedPreference.getInstance().getLoggedInUser().getMobile());
        } else {
            getBinding().verifyTextTV.setText("Verify number - " + SharedPreference.getInstance().getLoggedInUser().getMobile());
        }
        getBinding().verifyBtn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Login.Fragment.otpverification$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return otpverification.onViewCreated$lambda$4(this.f$0);
            }
        }));
        getBinding().resendotpTV.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Login.Fragment.otpverification$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return otpverification.onViewCreated$lambda$6(this.f$0);
            }
        }));
        getBinding().tvTimer.setPaintFlags(getBinding().tvTimer.getPaintFlags() | 8);
        setTimer();
        if (StringsKt.equals(BuildConfig.FLAVOR, "physicsgalaxy", true)) {
            getBinding().ivBack.setImageTintList(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$2(otpverification otpverificationVar) {
        otpverificationVar.activity.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$4(otpverification otpverificationVar) {
        String string = otpverificationVar.getBinding().pinHiddenEdittext.getText().toString();
        int length = string.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) string.charAt(!z ? i : length), 32) <= 0;
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
        String string2 = string.subSequence(i, length + 1).toString();
        otpverificationVar.otptext = string2;
        if (TextUtils.isEmpty(string2)) {
            FragmentActivity activity = otpverificationVar.getActivity();
            if (activity != null) {
                String string3 = otpverificationVar.getResources().getString(R.string.otp_field_is_required);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                XtensionFunctionKt.showSmallLengthToast(activity, string3);
            }
            return Unit.INSTANCE;
        }
        int i2 = otpverificationVar.type;
        if (i2 == 7) {
            otpverificationVar.userID = SharedPreference.getInstance().getLoggedInUser().getId();
            otpverificationVar.getUser().setMobile(com.appnew.android.home.Constants.MOBILE_NO);
        } else if (i2 == 2) {
            otpverificationVar.userID = SharedPreference.getInstance().getLoggedInUser().getId();
            otpverificationVar.getUser().setEmail(com.appnew.android.home.Constants.MOBILE_NO);
        }
        Helper.logPrinter(otpverificationVar.activity.getLocalClassName(), "e", "opt:  " + otpverificationVar.otptext, "Message");
        otpverificationVar.otp = otpverificationVar.otptext;
        Activity activity2 = otpverificationVar.activity;
        Intrinsics.checkNotNullExpressionValue(activity2, "activity");
        FacebookEventLogger.logOtpVerification(activity2);
        otpverificationVar.NetworkAPICall(API.API_SEND_OTP_VERIFICATION, "", true, false, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$6(otpverification otpverificationVar) {
        otpverification otpverificationVar2;
        FragmentOtpverifcationBinding binding = otpverificationVar.getBinding();
        binding.OPT1ET.getText().clear();
        binding.OPT2ET.getText().clear();
        binding.OPT3ET.getText().clear();
        binding.OPT4ET.getText().clear();
        binding.OPT5ET.getText().clear();
        binding.OPT6ET.getText().clear();
        binding.pinHiddenEdittext.getText().clear();
        binding.OPT1ET.setCursorVisible(true);
        binding.OPT2ET.setCursorVisible(false);
        binding.OPT3ET.setCursorVisible(false);
        binding.OPT4ET.setCursorVisible(false);
        binding.OPT5ET.setCursorVisible(false);
        binding.OPT6ET.setCursorVisible(false);
        otpverificationVar.setTimer();
        int i = otpverificationVar.type;
        if (i == 7) {
            otpverificationVar.userID = SharedPreference.getInstance().getLoggedInUser().getId();
            otpverificationVar.getUser().setMobile(com.appnew.android.home.Constants.MOBILE_NO);
            otpverificationVar.otp = "";
            Activity activity = otpverificationVar.activity;
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            FacebookEventLogger.logOtpSend(activity);
            otpverificationVar2 = otpverificationVar;
            otpverificationVar2.NetworkAPICall(API.API_SEND_OTP_VERIFICATION, "", true, false, false);
        } else {
            otpverificationVar2 = otpverificationVar;
            if (i == 2) {
                otpverificationVar2.userID = SharedPreference.getInstance().getLoggedInUser().getId();
                otpverificationVar2.getUser().setEmail(com.appnew.android.home.Constants.MOBILE_NO);
                otpverificationVar2.otp = "";
                Activity activity2 = otpverificationVar2.activity;
                Intrinsics.checkNotNullExpressionValue(activity2, "activity");
                FacebookEventLogger.logOtpSend(activity2);
                otpverificationVar2.NetworkAPICall(API.API_SEND_OTP_VERIFICATION, "", true, false, false);
            }
        }
        otpverificationVar2.startSmartUserConsent();
        return Unit.INSTANCE;
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        Intrinsics.checkNotNullParameter(apitype, "apitype");
        Intrinsics.checkNotNullParameter(typeApi, "typeApi");
        Intrinsics.checkNotNullParameter(service, "service");
        if (Intrinsics.areEqual(apitype, API.API_SEND_OTP_VERIFICATION)) {
            EncryptionData encryptionData = new EncryptionData();
            if (StringsKt.equals$default(this.LoginType, Const.LoginWithOtp, false, 2, null)) {
                String mobile = (this.isphone && !TextUtils.isEmpty(getUser().getMobile())) ? getUser().getMobile() : getUser().getEmail();
                encryptionData.setMobile(mobile);
                com.appnew.android.home.Constants.MOBILE_NO = getUser().getMobile();
                encryptionData.setIs_registration("1");
                encryptionData.setDevice_id(this.deviceId);
                encryptionData.setDevice_tokken(this.deviceTokenNew);
            } else {
                String mobile2 = (this.isphone && !TextUtils.isEmpty(getUser().getMobile())) ? getUser().getMobile() : getUser().getEmail();
                encryptionData.setMobile(mobile2);
                encryptionData.setIs_registration(this.isReg);
            }
            encryptionData.setOtp(this.otp);
            encryptionData.setC_code(this.c_code);
            encryptionData.setResend("1");
            LocationInfo locationInfo = new LocationInfo();
            locationInfo.setLat(TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.LOCATION_LAT)) ? "N/A" : SharedPreference.getInstance().getString(Const.LOCATION_LAT));
            locationInfo.setLng(TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.LOCATION_LNG)) ? "N/A" : SharedPreference.getInstance().getString(Const.LOCATION_LNG));
            locationInfo.setIp("");
            locationInfo.setManufacturer(TextUtils.isEmpty(Build.MANUFACTURER) ? "N/A" : Build.MANUFACTURER);
            locationInfo.setDevice_model(TextUtils.isEmpty(Build.MODEL) ? "N/A" : Build.MODEL);
            locationInfo.setOs_version(TextUtils.isEmpty(Build.VERSION.RELEASE) ? "N/A" : Build.VERSION.RELEASE);
            encryptionData.setLocation(locationInfo);
            return service.getOtpVerification(AES.encrypt(new Gson().toJson(encryptionData)));
        }
        if (Intrinsics.areEqual(apitype, API.get_my_profile)) {
            EncryptionData encryptionData2 = new EncryptionData();
            encryptionData2.setMobile(encryptionData2.getMobile());
            encryptionData2.setDevice_id(this.deviceId);
            encryptionData2.setPassword(encryptionData2.getPassword());
            encryptionData2.setIs_social(this.isSocial);
            return service.userProfile(AES.encrypt(new Gson().toJson(encryptionData2)));
        }
        return service.userProfile("userProfile");
    }

    /* JADX INFO: renamed from: isResendOtp, reason: from getter */
    public final boolean getIsResendOtp() {
        return this.isResendOtp;
    }

    public final void setResendOtp(boolean z) {
        this.isResendOtp = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x073f A[Catch: Exception -> 0x08c0, TryCatch #1 {Exception -> 0x08c0, blocks: (B:46:0x0270, B:48:0x027b, B:67:0x03db, B:88:0x0544, B:91:0x063f, B:93:0x0648, B:158:0x08a1, B:94:0x0662, B:96:0x066f, B:98:0x0679, B:100:0x0687, B:102:0x06a2, B:103:0x06a9, B:105:0x06b3, B:107:0x06e4, B:106:0x06cc, B:108:0x06eb, B:110:0x06f4, B:112:0x06fc, B:114:0x0706, B:116:0x070c, B:118:0x0712, B:120:0x071d, B:122:0x0726, B:124:0x0757, B:123:0x073f, B:125:0x075e, B:127:0x0767, B:129:0x0770, B:131:0x07a1, B:130:0x0789, B:132:0x07a8, B:134:0x07b1, B:135:0x07d0, B:138:0x07db, B:140:0x07e3, B:141:0x07ea, B:142:0x0809, B:144:0x0812, B:146:0x081a, B:147:0x0821, B:148:0x083f, B:150:0x0848, B:152:0x0850, B:153:0x0857, B:155:0x0865, B:157:0x089c, B:156:0x087e, B:68:0x03e0, B:87:0x0541, B:162:0x08ad, B:70:0x03ec, B:72:0x03fe, B:74:0x0415, B:75:0x045d, B:77:0x046f, B:79:0x0486, B:80:0x04ce, B:82:0x04e0, B:84:0x04f7, B:50:0x0285, B:52:0x0297, B:54:0x02ae, B:55:0x02f6, B:57:0x0308, B:59:0x031f, B:60:0x0367, B:62:0x0379, B:64:0x0390), top: B:176:0x01ce, inners: #0, #3 }] */
    @Override // com.appnew.android.Utils.Network.MainFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void SuccessCallBack(org.json.JSONObject r23, java.lang.String r24, java.lang.String r25, boolean r26) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 2283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Login.Fragment.otpverification.SuccessCallBack(org.json.JSONObject, java.lang.String, java.lang.String, boolean):void");
    }

    private final void claerdata() {
        this.activity.runOnUiThread(new Runnable() { // from class: com.appnew.android.Login.Fragment.otpverification$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                otpverification.claerdata$lambda$15(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void claerdata$lambda$15(otpverification otpverificationVar) {
        FragmentOtpverifcationBinding binding = otpverificationVar.getBinding();
        binding.pinHiddenEdittext.getText().clear();
        binding.OPT1ET.getText().clear();
        binding.OPT2ET.getText().clear();
        binding.OPT3ET.getText().clear();
        binding.OPT4ET.getText().clear();
        binding.OPT5ET.getText().clear();
        binding.OPT6ET.getText().clear();
        binding.pinHiddenEdittext.getText().clear();
        binding.OPT1ET.setEnabled(true);
        binding.OPT2ET.setEnabled(true);
        binding.OPT3ET.setEnabled(true);
        binding.OPT4ET.setEnabled(true);
        binding.OPT5ET.setEnabled(true);
        binding.OPT6ET.setEnabled(true);
        binding.OPT1ET.setCursorVisible(true);
        binding.OPT2ET.setCursorVisible(false);
        binding.OPT3ET.setCursorVisible(false);
        binding.OPT4ET.setCursorVisible(false);
        binding.OPT5ET.setCursorVisible(false);
        binding.OPT6ET.setCursorVisible(false);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s, int i, int i1, int i2) {
        Intrinsics.checkNotNullParameter(s, "s");
        if (s.length() == 0) {
            getBinding().OPT1ET.setText("");
            FragmentOtpverifcationBinding binding = getBinding();
            binding.OPT1ET.setCursorVisible(true);
            binding.OPT2ET.setCursorVisible(false);
            binding.OPT3ET.setCursorVisible(false);
            binding.OPT4ET.setCursorVisible(false);
            binding.OPT5ET.setCursorVisible(false);
            binding.OPT6ET.setCursorVisible(false);
            return;
        }
        if (s.length() == 1) {
            FragmentOtpverifcationBinding binding2 = getBinding();
            binding2.OPT1ET.setText(new StringBuilder().append(s.charAt(0)).toString());
            binding2.OPT2ET.setText("");
            binding2.OPT3ET.setText("");
            binding2.OPT4ET.setText("");
            binding2.OPT5ET.setText("");
            binding2.OPT6ET.setText("");
            FragmentOtpverifcationBinding binding3 = getBinding();
            binding3.OPT1ET.setCursorVisible(false);
            binding3.OPT2ET.setCursorVisible(true);
            binding3.OPT3ET.setCursorVisible(false);
            binding3.OPT4ET.setCursorVisible(false);
            binding3.OPT5ET.setCursorVisible(false);
            binding3.OPT6ET.setCursorVisible(false);
            return;
        }
        if (s.length() == 2) {
            FragmentOtpverifcationBinding binding4 = getBinding();
            binding4.OPT2ET.setText(new StringBuilder().append(s.charAt(1)).toString());
            binding4.OPT3ET.setText("");
            binding4.OPT4ET.setText("");
            binding4.OPT5ET.setText("");
            binding4.OPT6ET.setText("");
            FragmentOtpverifcationBinding binding5 = getBinding();
            binding5.OPT1ET.setCursorVisible(false);
            binding5.OPT2ET.setCursorVisible(false);
            binding5.OPT3ET.setCursorVisible(true);
            binding5.OPT4ET.setCursorVisible(false);
            binding5.OPT5ET.setCursorVisible(false);
            binding5.OPT6ET.setCursorVisible(false);
            return;
        }
        if (s.length() == 3) {
            FragmentOtpverifcationBinding binding6 = getBinding();
            binding6.OPT3ET.setText(new StringBuilder().append(s.charAt(2)).toString());
            binding6.OPT4ET.setText("");
            binding6.OPT5ET.setText("");
            binding6.OPT6ET.setText("");
            FragmentOtpverifcationBinding binding7 = getBinding();
            binding7.OPT1ET.setCursorVisible(false);
            binding7.OPT2ET.setCursorVisible(false);
            binding7.OPT3ET.setCursorVisible(false);
            binding7.OPT4ET.setCursorVisible(true);
            binding7.OPT5ET.setCursorVisible(false);
            binding7.OPT6ET.setCursorVisible(false);
            return;
        }
        if (s.length() == 4) {
            FragmentOtpverifcationBinding binding8 = getBinding();
            binding8.OPT4ET.setText(new StringBuilder().append(s.charAt(3)).toString());
            binding8.OPT5ET.setText("");
            binding8.OPT6ET.setText("");
            FragmentOtpverifcationBinding binding9 = getBinding();
            binding9.OPT1ET.setCursorVisible(false);
            binding9.OPT2ET.setCursorVisible(false);
            binding9.OPT3ET.setCursorVisible(false);
            binding9.OPT4ET.setCursorVisible(false);
            binding9.OPT5ET.setCursorVisible(true);
            binding9.OPT6ET.setCursorVisible(false);
            return;
        }
        if (s.length() == 5) {
            getBinding().OPT5ET.setText(new StringBuilder().append(s.charAt(4)).toString());
            getBinding().OPT6ET.setText("");
            FragmentOtpverifcationBinding binding10 = getBinding();
            binding10.OPT1ET.setCursorVisible(false);
            binding10.OPT2ET.setCursorVisible(false);
            binding10.OPT3ET.setCursorVisible(false);
            binding10.OPT4ET.setCursorVisible(false);
            binding10.OPT5ET.setCursorVisible(false);
            binding10.OPT6ET.setCursorVisible(true);
            return;
        }
        if (s.length() == 6) {
            getBinding().OPT6ET.setText(new StringBuilder().append(s.charAt(5)).toString());
            getBinding().OPT6ET.setCursorVisible(false);
            hideSoftKeyboard(getBinding().OPT6ET);
        }
    }

    private final void setPINListeners() {
        FragmentOtpverifcationBinding binding = getBinding();
        binding.pinHiddenEdittext.addTextChangedListener(this);
        otpverification otpverificationVar = this;
        binding.OPT1ET.setOnFocusChangeListener(otpverificationVar);
        binding.OPT2ET.setOnFocusChangeListener(otpverificationVar);
        binding.OPT3ET.setOnFocusChangeListener(otpverificationVar);
        binding.OPT4ET.setOnFocusChangeListener(otpverificationVar);
        binding.OPT5ET.setOnFocusChangeListener(otpverificationVar);
        binding.OPT6ET.setOnFocusChangeListener(otpverificationVar);
        otpverification otpverificationVar2 = this;
        binding.OPT1ET.setOnKeyListener(otpverificationVar2);
        binding.OPT2ET.setOnKeyListener(otpverificationVar2);
        binding.OPT3ET.setOnKeyListener(otpverificationVar2);
        binding.OPT4ET.setOnKeyListener(otpverificationVar2);
        binding.OPT5ET.setOnKeyListener(otpverificationVar2);
        binding.OPT6ET.setOnKeyListener(otpverificationVar2);
        binding.pinHiddenEdittext.setOnKeyListener(otpverificationVar2);
        binding.OPT1ET.setCursorVisible(true);
        binding.OPT2ET.setCursorVisible(false);
        binding.OPT3ET.setCursorVisible(false);
        binding.OPT4ET.setCursorVisible(false);
        binding.OPT5ET.setCursorVisible(false);
        binding.OPT6ET.setCursorVisible(false);
    }

    public final void showSoftKeyboard(EditText editText) {
        if (editText == null) {
            return;
        }
        Object systemService = this.activity.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 0);
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean hasFocus) {
        Intrinsics.checkNotNullParameter(view, "view");
        if ((Intrinsics.areEqual(view, getBinding().OPT1ET) || Intrinsics.areEqual(view, getBinding().OPT2ET) || Intrinsics.areEqual(view, getBinding().OPT3ET) || Intrinsics.areEqual(view, getBinding().OPT4ET) || Intrinsics.areEqual(view, getBinding().OPT5ET) || Intrinsics.areEqual(view, getBinding().OPT6ET)) && hasFocus) {
            INSTANCE.setFocus(getBinding().pinHiddenEdittext);
            showSoftKeyboard(getBinding().pinHiddenEdittext);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        if (keyEvent.getAction() == 0 && Intrinsics.areEqual(view, getBinding().pinHiddenEdittext) && keyCode == 67) {
            switch (getBinding().pinHiddenEdittext.getText().length()) {
                case 1:
                    getBinding().OPT1ET.setText("");
                    break;
                case 2:
                    getBinding().OPT2ET.setText("");
                    break;
                case 3:
                    getBinding().OPT3ET.setText("");
                    break;
                case 4:
                    getBinding().OPT4ET.setText("");
                    break;
                case 5:
                    getBinding().OPT5ET.setText("");
                    break;
                case 6:
                    getBinding().OPT6ET.setText("");
                    break;
            }
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 200) {
            if (resultCode == -1 && data != null) {
                String stringExtra = data.getStringExtra(SmsRetriever.EXTRA_SMS_MESSAGE);
                int i = this.type;
                if (i == 7 || i == 2) {
                    this.userID = SharedPreference.getInstance().getLoggedInUser().getId();
                    getUser().setMobile(com.appnew.android.home.Constants.MOBILE_NO);
                }
                getOtpFromMessage(stringExtra);
                return;
            }
            FragmentOtpverifcationBinding binding = getBinding();
            binding.OPT1ET.setEnabled(true);
            binding.OPT2ET.setEnabled(true);
            binding.OPT3ET.setEnabled(true);
            binding.OPT4ET.setEnabled(true);
            binding.OPT5ET.setEnabled(true);
            binding.OPT6ET.setEnabled(true);
        }
    }

    private final void getOtpFromMessage(String message) {
        if (message != null) {
            try {
                if (StringsKt.equals(message, "", true) || !Pattern.compile("(|^)\\d{6}").matcher(message).find()) {
                    return;
                }
                this.otptext = parseCode(message);
                Helper.logPrinter(this.activity.getLocalClassName(), "e", this.otptext, "Message");
                FragmentOtpverifcationBinding binding = getBinding();
                binding.pinHiddenEdittext.setText(this.otptext);
                binding.OPT1ET.setText(String.valueOf(this.otptext.charAt(0)));
                binding.OPT2ET.setText(String.valueOf(this.otptext.charAt(1)));
                binding.OPT3ET.setText(String.valueOf(this.otptext.charAt(2)));
                binding.OPT4ET.setText(String.valueOf(this.otptext.charAt(3)));
                binding.OPT5ET.setText(String.valueOf(this.otptext.charAt(4)));
                binding.OPT6ET.setText(String.valueOf(this.otptext.charAt(5)));
                binding.OPT1ET.setEnabled(true);
                binding.OPT2ET.setEnabled(true);
                binding.OPT3ET.setEnabled(true);
                binding.OPT4ET.setEnabled(true);
                binding.OPT5ET.setEnabled(true);
                binding.OPT6ET.setEnabled(true);
                this.otp = this.otptext;
                NetworkAPICall(API.API_SEND_OTP_VERIFICATION, "", true, false, false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void setTimer() {
        this.status = true;
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            Intrinsics.checkNotNull(countDownTimer);
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = new CountDownTimer() { // from class: com.appnew.android.Login.Fragment.otpverification.setTimer.1
            {
                super(60000L, 1000L);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                try {
                    FragmentOtpverifcationBinding binding = otpverification.this.getBinding();
                    TextView tvTimer = binding.tvTimer;
                    Intrinsics.checkNotNullExpressionValue(tvTimer, "tvTimer");
                    XtensionFunctionKt.visible(tvTimer);
                    TextView resendotpTV1 = binding.resendotpTV1;
                    Intrinsics.checkNotNullExpressionValue(resendotpTV1, "resendotpTV1");
                    XtensionFunctionKt.gone(resendotpTV1);
                    TextView resendotpTV = binding.resendotpTV;
                    Intrinsics.checkNotNullExpressionValue(resendotpTV, "resendotpTV");
                    XtensionFunctionKt.gone(resendotpTV);
                    TextView textView = binding.tvTimer;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String str = String.format("%d:%d", Arrays.copyOf(new Object[]{Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)))}, 2));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    textView.setText("0" + str);
                    otpverification.this.setLeftmillisUntilFinished(millisUntilFinished);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                try {
                    otpverification.this.setStatus(false);
                    FragmentOtpverifcationBinding binding = otpverification.this.getBinding();
                    binding.tvTimer.setText("");
                    TextView tvTimer = binding.tvTimer;
                    Intrinsics.checkNotNullExpressionValue(tvTimer, "tvTimer");
                    XtensionFunctionKt.gone(tvTimer);
                    TextView resendotpTV = binding.resendotpTV;
                    Intrinsics.checkNotNullExpressionValue(resendotpTV, "resendotpTV");
                    XtensionFunctionKt.visible(resendotpTV);
                    TextView resendotpTV1 = binding.resendotpTV1;
                    Intrinsics.checkNotNullExpressionValue(resendotpTV1, "resendotpTV1");
                    XtensionFunctionKt.visible(resendotpTV1);
                } catch (Exception e2) {
                    Helper.logPrinter(otpverification.this.activity.getLocalClassName(), "d", e2.getMessage(), "Message");
                }
            }
        };
        this.countDownTimer = countDownTimer2;
        countDownTimer2.start();
    }

    private final void registerBroadcastReceiver() {
        try {
            SmsBroadcastReceiver smsBroadcastReceiver = new SmsBroadcastReceiver();
            this.smsBroadcastReceiver = smsBroadcastReceiver;
            smsBroadcastReceiver.setSmsBroadcastReceiverListener(new SmsBroadcastReceiver.SmsBroadcastReceiverListener() { // from class: com.appnew.android.Login.Fragment.otpverification.registerBroadcastReceiver.1
                @Override // com.appnew.android.Sms.SmsBroadcastReceiver.SmsBroadcastReceiverListener
                public void onFailure() {
                }

                @Override // com.appnew.android.Sms.SmsBroadcastReceiver.SmsBroadcastReceiverListener
                public void onSuccess(Intent intent) {
                    if (intent != null) {
                        otpverification.this.getOtplauncher().launch(intent);
                    } else {
                        otpverification.this.getOtplauncher().launch(new Intent());
                    }
                }
            });
            IntentFilter intentFilter = new IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION);
            if (this.smsBroadcastReceiver != null) {
                ContextCompat.registerReceiver(requireActivity(), this.smsBroadcastReceiver, intentFilter, 2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final ActivityResultLauncher<Intent> getOtplauncher() {
        return this.otplauncher;
    }

    public final void setOtplauncher(ActivityResultLauncher<Intent> activityResultLauncher) {
        Intrinsics.checkNotNullParameter(activityResultLauncher, "<set-?>");
        this.otplauncher = activityResultLauncher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void otplauncher$lambda$31(otpverification otpverificationVar, ActivityResult result) {
        int i;
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            Intent data = result.getData();
            if (data != null) {
                String stringExtra = data.getStringExtra(SmsRetriever.EXTRA_SMS_MESSAGE);
                if (!StringsKt.equals$default(otpverificationVar.LoginType, Const.LoginWithOtp, false, 2, null) && ((i = otpverificationVar.type) == 7 || i == 2)) {
                    otpverificationVar.userID = SharedPreference.getInstance().getLoggedInUser().getId();
                    otpverificationVar.getUser().setMobile(com.appnew.android.home.Constants.MOBILE_NO);
                }
                otpverificationVar.getOtpFromMessage(stringExtra);
                return;
            }
            FragmentOtpverifcationBinding binding = otpverificationVar.getBinding();
            binding.OPT1ET.setEnabled(true);
            binding.OPT2ET.setEnabled(true);
            binding.OPT3ET.setEnabled(true);
            binding.OPT4ET.setEnabled(true);
            binding.OPT5ET.setEnabled(true);
            binding.OPT6ET.setEnabled(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        registerBroadcastReceiver();
    }

    /* JADX INFO: compiled from: otpverification.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jj\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\u0015Jb\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\u0015J0\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tJ\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/appnew/android/Login/Fragment/otpverification$Companion;", "", "<init>", "()V", "REQ_USER_CONSENT", "", "newInstance", "Lcom/appnew/android/Login/Fragment/otpverification;", Const.OTP, "", "type", "resetpass", "", "isChangePass", "isphone", "socialType", "isSocial", "c_code", Const.C_NAME, "c_nameCode", "flagArr", "", Const.LoginWithOtp, "setFocus", "", "editText", "Landroid/widget/EditText;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final otpverification newInstance(String otp, int type, boolean resetpass, boolean isChangePass, boolean isphone, String socialType, String isSocial, String c_code, String c_name, String c_nameCode, byte[] flagArr) {
            Intrinsics.checkNotNullParameter(flagArr, "flagArr");
            otpverification otpverificationVar = new otpverification();
            Bundle bundle = new Bundle();
            bundle.putString(Const.OTP, otp);
            bundle.putInt("type", type);
            bundle.putBoolean(Const.RESET_PASS, resetpass);
            bundle.putBoolean(Const.IS_CHANGE_PASS, isChangePass);
            bundle.putBoolean("isphone", isphone);
            bundle.putString(Const.SOCIAL_TYPE, socialType);
            bundle.putString(Const.IS_SOCIAL, isSocial);
            bundle.putString("c_code", c_code);
            bundle.putString(Const.C_NAME, c_name);
            bundle.putString(Const.C_NAME_CODE, c_nameCode);
            bundle.putByteArray(Const.C_FLAG, flagArr);
            otpverificationVar.setArguments(bundle);
            return otpverificationVar;
        }

        public final otpverification newInstance(String otp, int type, String LoginWithOtp, boolean isphone, String socialType, String isSocial, String c_code, String c_name, String c_nameCode, byte[] flagArr) {
            Intrinsics.checkNotNullParameter(LoginWithOtp, "LoginWithOtp");
            Intrinsics.checkNotNullParameter(flagArr, "flagArr");
            otpverification otpverificationVar = new otpverification();
            Bundle bundle = new Bundle();
            bundle.putString(Const.OTP, otp);
            bundle.putInt("type", type);
            bundle.putString(Const.LoginWithOtp, LoginWithOtp);
            bundle.putBoolean("isphone", isphone);
            bundle.putString(Const.SOCIAL_TYPE, socialType);
            bundle.putString(Const.IS_SOCIAL, isSocial);
            bundle.putString("c_code", c_code);
            bundle.putString(Const.C_NAME, c_name);
            bundle.putString(Const.C_NAME_CODE, c_nameCode);
            bundle.putByteArray(Const.C_FLAG, flagArr);
            otpverificationVar.setArguments(bundle);
            return otpverificationVar;
        }

        public final otpverification newInstance(String otp, int type, boolean isphone, String socialType, String isSocial) {
            Intrinsics.checkNotNullParameter(socialType, "socialType");
            Intrinsics.checkNotNullParameter(isSocial, "isSocial");
            otpverification otpverificationVar = new otpverification();
            Bundle bundle = new Bundle();
            bundle.putString(Const.OTP, otp);
            bundle.putInt("type", type);
            bundle.putBoolean("isphone", isphone);
            bundle.putString(Const.SOCIAL_TYPE, socialType);
            bundle.putString(Const.IS_SOCIAL, isSocial);
            otpverificationVar.setArguments(bundle);
            return otpverificationVar;
        }

        public final void setFocus(EditText editText) {
            if (editText == null) {
                return;
            }
            editText.setFocusable(true);
            editText.setFocusableInTouchMode(true);
            editText.requestFocus();
        }
    }

    private final void pushEvent() {
        HashMap<String, Object> map = new HashMap<>();
        HashMap<String, Object> map2 = map;
        map2.put("date", AnalyticHelper.INSTANCE.getCurrentDateTimeForEvent());
        map2.put("user_id", AnalyticHelper.INSTANCE.getUserId());
        map2.put(AnalyticsConstants.device_type, AnalyticHelper.INSTANCE.getDeviceType());
        map2.put("action_type", FirebaseAnalytics.Event.LOGIN);
        AnalyticEvents analyticEvents = AnalyticEvents.INSTANCE;
        Activity activity = this.activity;
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        analyticEvents.pushEvents(activity, AnalyticsConstants.USER_LOGIN, map);
    }
}
