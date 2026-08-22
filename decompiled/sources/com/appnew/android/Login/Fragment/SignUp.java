package com.appnew.android.Login.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.Settings;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Login.Activity.LoginGoogleActivity;
import com.appnew.android.Login.Activity.SignInActivity;
import com.appnew.android.Model.User;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.MainFragment;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.firebaseToken.FCMTokenHelper;
import com.appnew.android.Utils.firebaseToken.UserInfo;
import com.appnew.android.home.Constants;
import com.eduteria.app.app.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;
import com.hbb20.CountryCodePicker;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class SignUp extends MainFragment {
    Activity activity;
    LinearLayout bottom;
    String c_code;
    Drawable countryFlag;
    CountryCodePicker cpp;
    EditText et_mobile;
    private RelativeLayout flagCountryLL;
    private RelativeLayout flagRL;
    private GoogleApiClient googleApiClient;
    String isSocial;
    Button msignUpBtn;
    RelativeLayout rl_google_signin;
    String socialType;
    TextView tv_term_and_condition;
    User user;
    String mobile = "";
    String deviceId = "";
    private boolean country = false;
    private boolean isGoogleLogin = false;
    private int ACTION_GOOGLE_LOGIN = 5;
    int requestCode = -1;
    private String c_name = "India";
    private String c_nameCode = "IN";
    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.Login.Fragment.SignUp$$ExternalSyntheticLambda0
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.f$0.lambda$new$3((ActivityResult) obj);
        }
    });

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.activity = getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.signup_fragment, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Window window = getActivity().getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        this.country = SharedPreference.getInstance().getString(Const.COUNTRY_SHOW).equalsIgnoreCase("1");
        this.isGoogleLogin = SharedPreference.getInstance().getString(Const.IS_GOOGLE_LOGIN_ENABLE).equalsIgnoreCase("1");
        this.deviceId = Settings.Secure.getString(this.activity.getContentResolver(), "android_id");
        this.et_mobile = (EditText) view.findViewById(R.id.et_mobile);
        this.bottom = (LinearLayout) view.findViewById(R.id.bottom);
        this.tv_term_and_condition = (TextView) view.findViewById(R.id.tv_term_and_condition);
        this.msignUpBtn = (Button) view.findViewById(R.id.signupBtn);
        this.cpp = (CountryCodePicker) view.findViewById(R.id.countryDropDown);
        this.flagRL = (RelativeLayout) view.findViewById(R.id.flagRL);
        this.flagCountryLL = (RelativeLayout) view.findViewById(R.id.flagCountryLL);
        this.rl_google_signin = (RelativeLayout) view.findViewById(R.id.rl_google_signin);
        if (this.country) {
            this.flagCountryLL.setVisibility(0);
            this.flagRL.setVisibility(8);
        } else {
            this.flagCountryLL.setVisibility(8);
            this.flagRL.setVisibility(0);
            this.et_mobile.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});
        }
        if (this.isGoogleLogin) {
            this.rl_google_signin.setVisibility(8);
        } else {
            this.rl_google_signin.setVisibility(8);
        }
        this.user = User.newInstance();
        this.msignUpBtn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Login.Fragment.SignUp$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onViewCreated$0();
            }
        }));
        this.tv_term_and_condition.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Login.Fragment.SignUp$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onViewCreated$1();
            }
        }));
        this.cpp.registerCarrierNumberEditText(this.et_mobile);
        GoogleSignInOptions googleSignInOptionsBuild = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        this.googleApiClient = new GoogleApiClient.Builder(this.activity).addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptionsBuild).build();
        Helper.mGoogleSignInClient = GoogleSignIn.getClient(this.activity, googleSignInOptionsBuild);
        this.rl_google_signin.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Login.Fragment.SignUp$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$onViewCreated$2(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onViewCreated$0() {
        CheckValidation();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onViewCreated$1() {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fourFragmentLayout, CommonWebViewFragment.newInstance(API.TERMS_AND_CONDITIONS, false)).addToBackStack(null).commit();
        ((SignInActivity) getActivity()).setSignInUpLayoutVisibility(false);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$2(View view) {
        this.someActivityResultLauncher.launch(Auth.GoogleSignInApi.getSignInIntent(this.googleApiClient));
        this.requestCode = this.ACTION_GOOGLE_LOGIN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3(ActivityResult activityResult) {
        if (activityResult.getResultCode() == -1 && this.requestCode == this.ACTION_GOOGLE_LOGIN) {
            handleSignInResult(Auth.GoogleSignInApi.getSignInResultFromIntent(activityResult.getData()));
        }
    }

    public void CheckValidation() {
        boolean zDataNotValid;
        this.mobile = Helper.GetText(this.et_mobile);
        if (this.country) {
            this.c_code = this.cpp.getSelectedCountryCodeWithPlus();
            this.c_name = this.cpp.getSelectedCountryEnglishName();
            this.c_nameCode = this.cpp.getSelectedCountryNameCode();
            this.countryFlag = this.cpp.getImageViewFlag().getDrawable();
        } else {
            this.c_code = "+91";
            this.c_name = "India";
            this.c_nameCode = "IN";
        }
        if (TextUtils.isEmpty(this.mobile)) {
            zDataNotValid = Helper.DataNotValid(this.et_mobile, 6, this.activity);
        } else if (!this.country && (!Patterns.PHONE.matcher(this.mobile).matches() || this.mobile.length() != 10)) {
            zDataNotValid = Helper.DataNotValid(this.et_mobile, 2, this.activity);
        } else if (!this.country && Helper.isInValidIndianMobile(this.mobile)) {
            zDataNotValid = Helper.DataNotValid(this.et_mobile, 2, this.activity);
        } else {
            zDataNotValid = (this.cpp.isValidFullNumber() || !this.country) ? true : Helper.DataNotValid(this.et_mobile, 2, this.activity);
        }
        if (zDataNotValid) {
            handleDeviceToken();
        }
    }

    private void getDeviceTokenCallApi(String token) {
        Helper.dismissProgressDialog();
        if (TextUtils.isEmpty(this.deviceId)) {
            this.deviceId = Settings.Secure.getString(this.activity.getContentResolver(), "android_id");
        }
        this.user.setMobile(this.mobile);
        this.user.setC_code(this.c_code);
        this.user.setDevice_type("1");
        this.user.setDevice_tokken(token);
        SharedPreference.getInstance().setLoggedInUser(this.user);
        Helper.hideKeyboard(this.activity);
        NetworkAPICall(API.API_SEND_OTP_VERIFICATION, "", true, false, false);
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals(API.API_SEND_OTP_VERIFICATION)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setMobile(this.mobile);
        encryptionData.setOtp("");
        encryptionData.setIs_registration("1");
        encryptionData.setResend("0");
        encryptionData.setC_code(this.c_code);
        return service.getOtpVerification(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void SuccessCallBack(JSONObject jsonObject, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals(API.API_SEND_OTP_VERIFICATION)) {
            if (jsonObject.optString("status").equals("true")) {
                Constants.MOBILE_NO = SharedPreference.getInstance().getLoggedInUser().getMobile();
                this.socialType = "0";
                this.isSocial = "0";
                if (this.country) {
                    Helper.GoToOtpVerificationActivity2(this.activity, "", 7, Const.OTPVERIFICATION, false, "0", "0", this.c_code, this.countryFlag, this.c_name, this.c_nameCode, false);
                    return;
                } else {
                    Helper.GoToOtpVerificationActivity1(this.activity, "", 7, Const.OTPVERIFICATION, false, "0", "0", false);
                    return;
                }
            }
            Toast.makeText(this.activity, jsonObject.optString("message"), 0).show();
            RetrofitResponse.GetApiData(this.activity, jsonObject.optString("auth_code"), jsonObject.optString("message"), false);
        }
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        Toast.makeText(this.activity, jsonstring, 0).show();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == this.ACTION_GOOGLE_LOGIN) {
            handleSignInResult(Auth.GoogleSignInApi.getSignInResultFromIntent(data));
        }
    }

    private void handleSignInResult(GoogleSignInResult result) {
        if (result != null && result.isSuccess()) {
            Intent intent = new Intent(this.activity, (Class<?>) LoginGoogleActivity.class);
            intent.putExtra(Const.SOCIAL_TYPE, this.user.getSocial_type());
            intent.putExtra(Const.IS_SOCIAL, this.user.getIs_social());
            startActivity(intent);
            return;
        }
        Activity activity = this.activity;
        Toast.makeText(activity, activity.getResources().getString(R.string.sign_in_cancel), 1).show();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    private void handleDeviceToken() {
        UserInfo userInfo = new UserInfo("", "", this.et_mobile.getText().toString().trim());
        if (!userInfo.isSameUser(FCMTokenHelper.getUserInfo(requireActivity()))) {
            FCMTokenHelper.getValidFCMToken(requireActivity(), userInfo, new Function1() { // from class: com.appnew.android.Login.Fragment.SignUp$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return this.f$0.lambda$handleDeviceToken$4((String) obj);
                }
            }, new Function1() { // from class: com.appnew.android.Login.Fragment.SignUp$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return this.f$0.lambda$handleDeviceToken$5((Exception) obj);
                }
            });
        } else {
            getDeviceTokenCallApi(FCMTokenHelper.getSavedToken(requireActivity()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$handleDeviceToken$4(String str) {
        getDeviceTokenCallApi(str);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$handleDeviceToken$5(Exception exc) {
        Toast.makeText(requireActivity(), "Could not fetch device token", 0).show();
        return null;
    }
}
