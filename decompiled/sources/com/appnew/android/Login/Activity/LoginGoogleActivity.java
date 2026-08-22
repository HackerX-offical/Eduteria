package com.appnew.android.Login.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.Settings;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.User;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.firebaseToken.FCMTokenHelper;
import com.appnew.android.home.Constants;
import com.eduteria.app.app.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.gson.Gson;
import com.hbb20.CountryCodePicker;
import de.hdodenhof.circleimageview.CircleImageView;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class LoginGoogleActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack, GoogleApiClient.OnConnectionFailedListener {
    public static Activity homeactivity;
    Button btn_submit;
    String c_code;
    Drawable countryFlag;
    CountryCodePicker cpp;
    EditText et_email;
    EditText et_mobile_number;
    EditText et_name;
    RelativeLayout flagCountryLL;
    RelativeLayout flagRL;
    private GoogleApiClient googleApiClient;
    private GoogleSignInOptions gso;
    String isSocial;
    CircleImageView iv_image;
    NetworkCall networkCall;
    String socialType;
    User user;
    UtkashRoom utkashRoom;
    String mobile = "";
    String deviceId = "";
    String socialToken = "";
    boolean country = false;
    private String c_name = "India";
    private String c_nameCode = "IN";
    String deviceTokenNew = "";

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public void onConnectionFailed(ConnectionResult connectionResult) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.activity_login_google);
        Helper.enableScreenShot(this);
        this.utkashRoom = UtkashRoom.getAppDatabase(this);
        Helper.setSystemBarLight(this);
        homeactivity = this;
        this.networkCall = new NetworkCall(this, this);
        this.deviceId = Settings.Secure.getString(getContentResolver(), "android_id");
        this.user = User.newInstance();
        this.et_name = (EditText) findViewById(R.id.et_name);
        this.et_email = (EditText) findViewById(R.id.et_email);
        this.et_mobile_number = (EditText) findViewById(R.id.et_mobile_number);
        this.btn_submit = (Button) findViewById(R.id.btn_submit);
        this.iv_image = (CircleImageView) findViewById(R.id.iv_image);
        this.flagRL = (RelativeLayout) findViewById(R.id.flagRL);
        this.flagCountryLL = (RelativeLayout) findViewById(R.id.flagCountryLL);
        this.cpp = (CountryCodePicker) findViewById(R.id.countryDropDown);
        if (SharedPreference.getInstance().getString(Const.COUNTRY_SHOW).equals("1")) {
            this.country = true;
        }
        if (this.country) {
            this.flagRL.setVisibility(8);
            this.flagCountryLL.setVisibility(0);
        } else {
            this.flagRL.setVisibility(0);
            this.flagCountryLL.setVisibility(8);
            this.et_mobile_number.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});
        }
        this.cpp.registerCarrierNumberEditText(this.et_mobile_number);
        if (getIntent().getExtras() != null) {
            this.socialType = getIntent().getExtras().getString(Const.SOCIAL_TYPE);
            this.isSocial = getIntent().getExtras().getString(Const.IS_SOCIAL);
        }
        this.gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        this.googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this, this).addApi(Auth.GOOGLE_SIGN_IN_API, this.gso).build();
        this.btn_submit.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Login.Activity.LoginGoogleActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        CheckValidation();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.googleApiClient.disconnect();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        OptionalPendingResult<GoogleSignInResult> optionalPendingResultSilentSignIn = Auth.GoogleSignInApi.silentSignIn(this.googleApiClient);
        if (optionalPendingResultSilentSignIn.isDone()) {
            lambda$onStart$1((GoogleSignInResult) optionalPendingResultSilentSignIn.get());
        } else {
            optionalPendingResultSilentSignIn.setResultCallback(new ResultCallback() { // from class: com.appnew.android.Login.Activity.LoginGoogleActivity$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.common.api.ResultCallback
                public final void onResult(Result result) {
                    this.f$0.lambda$onStart$1((GoogleSignInResult) result);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleSignInResult, reason: merged with bridge method [inline-methods] */
    public void lambda$onStart$1(GoogleSignInResult result) {
        if (result.isSuccess()) {
            GoogleSignInAccount signInAccount = result.getSignInAccount();
            this.et_email.setText(signInAccount.getEmail());
            this.et_name.setText(signInAccount.getDisplayName());
            this.socialToken = signInAccount.getId();
            SharedPreference.getInstance().putGoogleToken(Const.SOCIAL_TOKEN, this.socialToken);
            return;
        }
        gotoMainActivity();
    }

    private void gotoMainActivity() {
        startActivity(new Intent(this, Helper.setSignInActivity()));
    }

    public void CheckValidation() {
        boolean zDataNotValid;
        this.mobile = Helper.GetText(this.et_mobile_number);
        if (this.country) {
            this.c_code = this.cpp.getSelectedCountryCodeWithPlus();
            this.countryFlag = this.cpp.getImageViewFlag().getDrawable();
            this.c_nameCode = this.cpp.getSelectedCountryNameCode();
            this.c_name = this.cpp.getSelectedCountryEnglishName();
        } else {
            this.c_code = "+91";
            this.c_name = "India";
            this.c_nameCode = "IN";
        }
        if (TextUtils.isEmpty(this.mobile)) {
            zDataNotValid = Helper.DataNotValid(this.et_mobile_number, this);
        } else if (!this.country && (!Patterns.PHONE.matcher(this.mobile).matches() || this.mobile.length() != 10)) {
            zDataNotValid = Helper.DataNotValid(this.et_mobile_number, 2, this);
        } else if (!this.country && Helper.isInValidIndianMobile(this.mobile)) {
            zDataNotValid = Helper.DataNotValid(this.et_mobile_number, 2, this);
        } else {
            zDataNotValid = (this.cpp.isValidFullNumber() || !this.country) ? true : Helper.DataNotValid(this.et_mobile_number, 2, this);
        }
        if (zDataNotValid) {
            Helper.showProgressDialog(this);
            callApi(FCMTokenHelper.getSavedToken(this).toString());
        }
    }

    private void callApi(String token) {
        Helper.dismissProgressDialog();
        if (TextUtils.isEmpty(this.deviceId)) {
            this.deviceId = Settings.Secure.getString(getContentResolver(), "android_id");
        }
        this.user.setMobile(this.mobile);
        this.user.setC_code(this.c_code);
        this.user.setDevice_type("1");
        this.user.setDevice_tokken(token);
        SharedPreference.getInstance().setLoggedInUser(this.user);
        Helper.hideKeyboard(this);
        this.networkCall.NetworkAPICall(API.API_SEND_OTP_VERIFICATION, "", true, false);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
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
        return service.getOtpVerification(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonObject, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals(API.API_SEND_OTP_VERIFICATION)) {
            if (jsonObject.optString("status").equals("true")) {
                Constants.MOBILE_NO = SharedPreference.getInstance().getLoggedInUser().getMobile();
                Constants.G_NAME = this.et_name.getText().toString();
                Constants.G_EMAIL = this.et_email.getText().toString();
                if (this.country) {
                    Helper.GoToOtpVerificationActivity2(this, "", 7, Const.OTPVERIFICATION, false, this.socialType, this.isSocial, this.c_code, this.countryFlag, this.c_name, this.c_nameCode, false);
                    return;
                } else {
                    Helper.GoToOtpVerificationActivity1(this, "", 7, Const.OTPVERIFICATION, false, this.socialType, this.isSocial, false);
                    return;
                }
            }
            Toast.makeText(this, jsonObject.optString("message"), 0).show();
            RetrofitResponse.GetApiData(this, jsonObject.optString("auth_code"), jsonObject.optString("message"), false);
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        Toast.makeText(this, jsonstring, 0).show();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }
}
