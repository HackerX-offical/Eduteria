package com.appnew.android.loginRevamp.Fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.BuildConfig;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.EncryptionModel.LocationInfo;
import com.appnew.android.FacebookEventLogger;
import com.appnew.android.Intro.Activity.CategoryActivity;
import com.appnew.android.Intro.Activity.IntroActivity;
import com.appnew.android.Model.MediaFile;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Theme.DashboardActivityTheme1;
import com.appnew.android.Theme.DashboardActivityTheme2;
import com.appnew.android.Theme.DashboardActivityTheme3;
import com.appnew.android.Theme.DashboardActivityTheme4;
import com.appnew.android.Theme.DashboardActivityTheme5;
import com.appnew.android.Theme.DashboardActivityTheme7;
import com.appnew.android.Theme.DashboardActivityTheme8;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.AmazonUpload.AmazonCallBack;
import com.appnew.android.Utils.AmazonUpload.s3ImageUploading;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.EmojiFilter;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.MainFragment;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.firebaseToken.FCMTokenHelper;
import com.appnew.android.Utils.imagecropper.TakeImageClass;
import com.appnew.android.Utils.shortcuts.Shortsuts;
import com.appnew.android.cleverTap.AnalyticHelper;
import com.appnew.android.home.Activity.HomeActivity;
import com.appnew.android.home.Constants;
import com.appnew.android.loginRevamp.Activity.ChooseCourseNewActivity;
import com.appnew.android.pojo.Userinfo.Languages;
import com.appnew.android.pojo.Userinfo.LanguagesData;
import com.appnew.android.pojo.Userinfo.StatesCities.StatesCities;
import com.appnew.android.pojo.Userinfo.StatesCities.StatesCitiesData;
import com.appnew.android.pojo.Userinfo.UserData;
import com.appnew.android.table.APITABLE;
import com.appnew.android.table.PigibagTable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.canhub.cropper.CropImageContract;
import com.canhub.cropper.CropImageContractOptions;
import com.canhub.cropper.CropImageView;
import com.eduteria.app.app.R;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.tv9news.utils.helpers.AnalyticEvents;
import com.tv9news.utils.helpers.AnalyticsConstants;
import de.hdodenhof.circleimageview.CircleImageView;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class SignupFormNew extends MainFragment implements View.OnClickListener, AmazonCallBack, TakeImageClass.imagefromcropper, PopupMenu.OnMenuItemClickListener {
    RelativeLayout Caste;
    RelativeLayout City;
    RelativeLayout Gender;
    RelativeLayout Language;
    RelativeLayout State;
    EditText addressTV;
    EditText alternateMobileTV;
    String c_code;
    String c_name;
    String c_nameCode;
    Calendar calendar;
    TextView casteSpinner;
    TextView categorySpinner;
    private RelativeLayout categorySpinnerLayout;
    StatesCities cities;
    EditText confirmPasswordET;
    StatesCities countries;
    TextView countrySpinner;
    RelativeLayout countryTopRl;
    ImageView datePickerIV;
    String deviceId;
    String devicetoken;
    EditText districtSpinner;
    TextView districtSpinnerTV;
    TextView dobEt;
    RelativeLayout dobRl;
    RelativeLayout dobTopRl;
    ImageView downArrowIV1;
    ImageView downarrowCasteIV;
    ImageView downarrowGenderIV;
    ImageView downarrowIV;
    ImageView downarrowIV2;
    ImageView downarrowIV3;
    ImageView downarrowLanguageIV;
    EditText emailTV;
    EditText etSearch;
    EditText etSearchLanguage;
    EditText et_mobile;
    RelativeLayout expertRL;
    TextView expertSpinner;
    RelativeLayout expertTopRL;
    EditText fatherNameTV;
    byte[] flagArr;
    TextView genderSpinner;
    EditText gstinTV;
    ImageView imagecountry;
    ImageView imagelanguage;
    RelativeLayout imagelayout;
    ImageView imagestates;
    ImageView ivClearSearch;
    ImageView ivClearSearchLanguage;
    ImageView iv_back;
    LanguageAdapter languageAdapter;
    RecyclerView languageRecyclerview;
    TextView languageSpinner;
    LanguagesData languagesData;
    CircleImageView marksheetImage;
    RelativeLayout marksheet_rl;
    TextView marksheet_txt;
    RelativeLayout mobileRL;
    UtkashRoom myDBClass;
    EditText nameMentor;
    EditText nameTV;
    String otp;
    EditText passwordET;
    EditText pincodeTV;
    CircleImageView profileImage;
    TextView profile_pic_txt;
    RelativeLayout profile_rl;
    EditText rollNumberTV;
    private s3ImageUploading s3IU;
    RecyclerView searchRecyclerview;
    Button signupBtn;
    StateCityAdapter stateCityAdapter;
    TextView stateSpinner;
    StatesCities states;
    TextInputLayout til_confirm_password;
    TextInputLayout til_password;
    TextView tvCountryError;
    TextView tvDistrictError;
    TextView tvDobError;
    TextView tvExpertError;
    TextView tvStateError;
    TextView tv_casteError;
    TextView tv_categoryError;
    TextView tv_code;
    TextView tv_genderError;
    TextView tv_languageError;
    TextView tv_verify_email;
    RelativeLayout uploadImg;
    RelativeLayout uploadTenth;
    private UtkashRoom utkashRoom;
    Boolean isShowRollNumber = false;
    Boolean isProfileTeacher = false;
    Boolean show_dob = false;
    Boolean show_country = false;
    Boolean show_expert = false;
    boolean hidePassword = false;
    List<String> genderList = new ArrayList();
    List<String> casteList = new ArrayList();
    String clicktype = "";
    String clicktype1 = "";
    String gender = "";
    String caste = "";
    String stateindex = "";
    String cityindex = "";
    String categoryindex = "";
    String countryindex = "";
    String SelectedStateid = "";
    String SelectedCityid = "";
    String SelectedCountryid = "";
    String SelectedCategoryid = "";
    private int requestCode = -1;
    String str_imgTypeClick = "";
    String socialType = "0";
    String isSocial = "0";
    String profilepic = "";
    String marksheetpic = "";
    boolean isProfilePic = false;
    private boolean isGstin = false;
    private boolean isStateCityShow = true;
    StatesCities category = new StatesCities();
    private boolean isEmailLogin = false;
    private boolean isGenderShow = false;
    private boolean isEmailShow = false;
    private boolean isCasteShow = false;
    private boolean isAddressShow = false;
    private boolean isFatherNameShow = false;
    private boolean isAlternateNumberShow = false;
    private boolean isPhotoUpload = false;
    private boolean isTenthMarksheetUpload = false;
    private boolean isPinCodeShow = false;
    private boolean isLanguageShow = false;
    boolean isUpdate = false;
    boolean editTextEnable = false;
    boolean isPhone = false;
    private ActivityResultLauncher<CropImageContractOptions> cropImage = registerForActivityResult(new CropImageContract(), new ActivityResultCallback() { // from class: com.appnew.android.loginRevamp.Fragment.SignupFormNew$$ExternalSyntheticLambda0
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.f$0.lambda$new$4((CropImageView.CropResult) obj);
        }
    });
    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.loginRevamp.Fragment.SignupFormNew$$ExternalSyntheticLambda4
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.f$0.lambda$new$5((ActivityResult) obj);
        }
    });
    ArrayList<StatesCitiesData> statesCitiesArrayList = new ArrayList<>();
    ArrayList<Languages> languages = new ArrayList<>();
    String languageId = "";

    @Override // com.appnew.android.Utils.imagecropper.TakeImageClass.imagefromcropper
    public void imagePath(String str) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
    }

    public static SignupFormNew newInstance(String otp, String socialType, String isSocial, String c_code, String c_name, String c_nameCode, byte[] flagArr, boolean isUpdate, boolean isPhone) {
        SignupFormNew signupFormNew = new SignupFormNew();
        Bundle bundle = new Bundle();
        bundle.putString(Const.OTP, otp);
        bundle.putString(Const.SOCIAL_TYPE, socialType);
        bundle.putString(Const.IS_SOCIAL, isSocial);
        bundle.putString("c_code", c_code);
        bundle.putString(Const.C_NAME, c_name);
        bundle.putString(Const.C_NAME_CODE, c_nameCode);
        bundle.putByteArray(Const.C_FLAG, flagArr);
        bundle.putBoolean("isUpdate", isUpdate);
        bundle.putBoolean("isphone", isPhone);
        signupFormNew.setArguments(bundle);
        return signupFormNew;
    }

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.activity = getActivity();
        Helper.setStatusBarIconsLight(this.activity, this.activity.getWindow(), false);
        if (getArguments() != null) {
            if (getArguments().containsKey("isUpdate")) {
                this.isUpdate = getArguments().getBoolean("isUpdate");
            }
            if (getArguments().containsKey("isphone")) {
                this.isPhone = getArguments().getBoolean("isphone");
            }
            this.otp = getArguments().getString(Const.OTP);
            this.socialType = getArguments().getString(Const.SOCIAL_TYPE) != null ? getArguments().getString(Const.SOCIAL_TYPE) : "0";
            this.isSocial = getArguments().getString(Const.IS_SOCIAL) != null ? getArguments().getString(Const.IS_SOCIAL) : "0";
            this.c_code = getArguments().getString("c_code");
            this.c_name = getArguments().getString(Const.C_NAME);
            this.c_nameCode = getArguments().getString(Const.C_NAME_CODE);
            if (getArguments().getByteArray(Const.C_FLAG) != null) {
                this.flagArr = getArguments().getByteArray(Const.C_FLAG);
            }
        }
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(this.activity);
        this.myDBClass = appDatabase;
        this.utkashRoom = appDatabase;
        this.deviceId = Settings.Secure.getString(this.activity.getContentResolver(), "android_id");
        this.calendar = Calendar.getInstance();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_signup_form_new, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        SignupFormNew signupFormNew;
        super.onViewCreated(view, savedInstanceState);
        this.expertSpinner = (TextView) view.findViewById(R.id.expertSpinner);
        this.countrySpinner = (TextView) view.findViewById(R.id.countrySpinner);
        this.downarrowIV3 = (ImageView) view.findViewById(R.id.downarrowIV3);
        this.nameTV = (EditText) view.findViewById(R.id.nameTV);
        this.emailTV = (EditText) view.findViewById(R.id.emailTV);
        this.gstinTV = (EditText) view.findViewById(R.id.gstinTV);
        this.mobileRL = (RelativeLayout) view.findViewById(R.id.mobileRL);
        this.et_mobile = (EditText) view.findViewById(R.id.et_mobile);
        this.imagecountry = (ImageView) view.findViewById(R.id.imagecountry);
        this.passwordET = (EditText) view.findViewById(R.id.passwordET);
        this.til_password = (TextInputLayout) view.findViewById(R.id.til_password);
        this.marksheet_txt = (TextView) view.findViewById(R.id.marksheet_txt);
        this.profile_pic_txt = (TextView) view.findViewById(R.id.profile_pic_txt);
        this.dobTopRl = (RelativeLayout) view.findViewById(R.id.dobTopRl);
        this.expertTopRL = (RelativeLayout) view.findViewById(R.id.expertTopRL);
        this.countryTopRl = (RelativeLayout) view.findViewById(R.id.countryTopRl);
        this.til_confirm_password = (TextInputLayout) view.findViewById(R.id.til_confirm_password);
        this.stateSpinner = (TextView) view.findViewById(R.id.stateSpinner);
        this.categorySpinner = (TextView) view.findViewById(R.id.categorySpinner);
        this.expertRL = (RelativeLayout) view.findViewById(R.id.expertRL);
        this.iv_back = (ImageView) view.findViewById(R.id.iv_back);
        this.confirmPasswordET = (EditText) view.findViewById(R.id.confirmPasswordET);
        this.districtSpinner = (EditText) view.findViewById(R.id.districtSpinner);
        this.signupBtn = (Button) view.findViewById(R.id.signupBtn);
        this.City = (RelativeLayout) view.findViewById(R.id.city);
        this.State = (RelativeLayout) view.findViewById(R.id.State);
        this.downarrowIV = (ImageView) view.findViewById(R.id.downarrowIV);
        this.downarrowIV2 = (ImageView) view.findViewById(R.id.downarrowIV2);
        this.dobEt = (TextView) view.findViewById(R.id.dobTV);
        this.datePickerIV = (ImageView) view.findViewById(R.id.datePickerIV);
        this.imagestates = (ImageView) view.findViewById(R.id.imagestates);
        this.tv_code = (TextView) view.findViewById(R.id.tv_code);
        this.Gender = (RelativeLayout) view.findViewById(R.id.Gender);
        this.profile_rl = (RelativeLayout) view.findViewById(R.id.profile_rl);
        this.marksheet_rl = (RelativeLayout) view.findViewById(R.id.marksheet_rl);
        this.Caste = (RelativeLayout) view.findViewById(R.id.Caste);
        this.downarrowIV3 = (ImageView) view.findViewById(R.id.downarrowIV3);
        this.dobRl = (RelativeLayout) view.findViewById(R.id.dobRl);
        this.downArrowIV1 = (ImageView) view.findViewById(R.id.downArrowIV1);
        this.districtSpinnerTV = (TextView) view.findViewById(R.id.districtSpinnerTV);
        this.uploadImg = (RelativeLayout) view.findViewById(R.id.uploadImg);
        this.uploadTenth = (RelativeLayout) view.findViewById(R.id.uploadTenth);
        this.profileImage = (CircleImageView) view.findViewById(R.id.profileImage);
        this.marksheetImage = (CircleImageView) view.findViewById(R.id.marksheetImage);
        this.fatherNameTV = (EditText) view.findViewById(R.id.fatherNameTV);
        this.pincodeTV = (EditText) view.findViewById(R.id.pincodeTV);
        this.rollNumberTV = (EditText) view.findViewById(R.id.rollNumberTV);
        this.casteSpinner = (TextView) view.findViewById(R.id.casteSpinner);
        this.downarrowCasteIV = (ImageView) view.findViewById(R.id.downarrowCasteIV);
        this.tv_casteError = (TextView) view.findViewById(R.id.tv_casteError);
        this.genderSpinner = (TextView) view.findViewById(R.id.genderSpinner);
        this.downarrowGenderIV = (ImageView) view.findViewById(R.id.downarrowGenderIV);
        this.tv_genderError = (TextView) view.findViewById(R.id.tv_genderError);
        this.alternateMobileTV = (EditText) view.findViewById(R.id.alternateMobileTV);
        this.addressTV = (EditText) view.findViewById(R.id.addressTV);
        this.imagelayout = (RelativeLayout) view.findViewById(R.id.imagelayout);
        this.Language = (RelativeLayout) view.findViewById(R.id.Language);
        this.imagelanguage = (ImageView) view.findViewById(R.id.imagelanguage);
        this.languageSpinner = (TextView) view.findViewById(R.id.languageSpinner);
        this.downarrowLanguageIV = (ImageView) view.findViewById(R.id.downarrowLanguageIV);
        this.tv_languageError = (TextView) view.findViewById(R.id.tv_languageError);
        this.tv_verify_email = (TextView) view.findViewById(R.id.tv_verify_email);
        this.nameMentor = (EditText) view.findViewById(R.id.nameMentor);
        this.State.setOnClickListener(this);
        this.Caste.setOnClickListener(this);
        this.casteSpinner.setOnClickListener(this);
        this.downarrowCasteIV.setOnClickListener(this);
        this.Gender.setOnClickListener(this);
        this.genderSpinner.setOnClickListener(this);
        this.downarrowGenderIV.setOnClickListener(this);
        this.downarrowIV.setOnClickListener(this);
        this.City.setOnClickListener(this);
        this.dobRl.setOnClickListener(this);
        this.downArrowIV1.setOnClickListener(this);
        this.stateSpinner.setOnClickListener(this);
        this.categorySpinner.setOnClickListener(this);
        this.countrySpinner.setOnClickListener(this);
        this.expertRL.setOnClickListener(this);
        this.imagecountry.setOnClickListener(this);
        this.expertSpinner.setOnClickListener(this);
        this.datePickerIV.setOnClickListener(this);
        this.downarrowIV3.setOnClickListener(this);
        this.districtSpinnerTV.setOnClickListener(this);
        this.dobEt.setOnClickListener(this);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.categorySpinnerLayout);
        this.categorySpinnerLayout = relativeLayout;
        relativeLayout.setOnClickListener(this);
        this.Language.setOnClickListener(this);
        this.languageSpinner.setOnClickListener(this);
        this.downarrowLanguageIV.setOnClickListener(this);
        this.imagelanguage.setOnClickListener(this);
        this.uploadImg.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.loginRevamp.Fragment.SignupFormNew$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onViewCreated$0();
            }
        }));
        this.uploadTenth.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.loginRevamp.Fragment.SignupFormNew$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onViewCreated$1();
            }
        }));
        this.tvDobError = (TextView) view.findViewById(R.id.tv_dobError);
        this.tvExpertError = (TextView) view.findViewById(R.id.tv_expertError);
        this.tvCountryError = (TextView) view.findViewById(R.id.tv_countryError);
        this.tvStateError = (TextView) view.findViewById(R.id.tv_stateError);
        this.tvDistrictError = (TextView) view.findViewById(R.id.tv_districtError);
        this.tv_categoryError = (TextView) view.findViewById(R.id.tv_categoryError);
        this.isEmailShow = Helper.checkProfilePermission(Const.EMAIL_FORM_SHOW);
        this.isGenderShow = Helper.checkProfilePermission(Const.GENDER_SHOW);
        this.isCasteShow = Helper.checkProfilePermission(Const.CASTE_SHOW);
        this.isFatherNameShow = Helper.checkProfilePermission(Const.FATHER_SHOW);
        this.isAddressShow = Helper.checkProfilePermission(Const.ADDRESS_SHOW);
        this.isAlternateNumberShow = Helper.checkProfilePermission(Const.ALTERNATE_SHOW);
        this.isPhotoUpload = Helper.checkProfilePermission(Const.PHOTO_SHOW);
        this.isTenthMarksheetUpload = Helper.checkProfilePermission(Const.MARKSHEET_SHOW);
        this.isPinCodeShow = Helper.checkProfilePermission(Const.PIN_CODE_SHOW);
        this.isLanguageShow = Helper.checkProfilePermission(Const.LANG_SHOW);
        this.isGstin = Helper.checkProfilePermission(Const.IS_GSTIN);
        this.show_dob = Boolean.valueOf(Helper.checkProfilePermission(Const.DOB_SHOW));
        this.show_expert = Boolean.valueOf(Helper.checkProfilePermission(Const.EXPERT_SHOW));
        this.show_country = Boolean.valueOf(Helper.checkProfilePermission(Const.COUNTRY_SHOW));
        this.isProfileTeacher = Boolean.valueOf(Helper.checkProfilePermission(Const.PROFILE_TEACHER));
        this.isShowRollNumber = Boolean.valueOf(Helper.checkProfilePermission(Const.SHOW_ROLL_NUMBER));
        if (BuildConfig.FLAVOR.equalsIgnoreCase("DishaPublication")) {
            this.isStateCityShow = Helper.checkProfilePermission(Const.HIDE_CITY_STATE);
        } else {
            this.isStateCityShow = !Helper.checkProfilePermission(Const.HIDE_CITY_STATE);
        }
        this.isEmailLogin = !this.isPhone;
        this.editTextEnable = this.isProfileTeacher.booleanValue();
        this.passwordET.setFilters(EmojiFilter.getFilter());
        this.passwordET.setFilters(EmojiFilter.WhiteSpaceFilter());
        this.confirmPasswordET.setFilters(EmojiFilter.getFilter());
        this.confirmPasswordET.setFilters(EmojiFilter.WhiteSpaceFilter());
        byte[] bArr = this.flagArr;
        if (bArr != null && bArr.length > 0) {
            this.imagestates.setImageBitmap(Helper.getBitmapToByteArr(bArr));
        } else {
            this.imagestates.setImageResource(R.mipmap.flag);
        }
        String str = this.c_code;
        if (str != null && !str.equalsIgnoreCase("")) {
            this.tv_code.setText(this.c_code);
        } else {
            this.tv_code.setText("+91");
        }
        this.iv_back.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.loginRevamp.Fragment.SignupFormNew$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onViewCreated$2();
            }
        }));
        this.signupBtn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.loginRevamp.Fragment.SignupFormNew$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onViewCreated$3();
            }
        }));
        hit_api_to_get_language();
        if (this.show_country.booleanValue()) {
            hit_api_to_get_country();
        } else {
            hit_api_to_get_state();
        }
        if (this.isEmailShow) {
            this.emailTV.setVisibility(this.isEmailLogin ? 8 : 0);
        } else {
            this.emailTV.setVisibility(8);
        }
        if (this.isEmailLogin) {
            this.mobileRL.setVisibility(8);
            this.emailTV.setEnabled(false);
            this.emailTV.setText(Constants.MOBILE_NO);
        } else {
            this.mobileRL.setVisibility(8);
            this.et_mobile.setEnabled(false);
            this.et_mobile.setText(Constants.MOBILE_NO);
        }
        this.nameTV.setVisibility(8);
        this.nameTV.setText(Constants.G_NAME);
        this.nameTV.setFilters(new InputFilter[]{new InputFilter() { // from class: com.appnew.android.loginRevamp.Fragment.SignupFormNew.1
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int start, int end, Spanned dest, int dstart, int dend) {
                return (charSequence.equals("") || charSequence.toString().matches("[a-z A-Z ]+")) ? charSequence : "";
            }
        }});
        if (this.isSocial.equalsIgnoreCase("1") && this.socialType.equalsIgnoreCase("1")) {
            this.emailTV.setText(Constants.G_EMAIL);
            this.nameTV.setEnabled(false);
            this.emailTV.setEnabled(false);
            this.til_password.setVisibility(8);
            this.til_confirm_password.setVisibility(8);
        } else {
            this.til_password.setVisibility(0);
            this.til_confirm_password.setVisibility(0);
        }
        if (this.show_country.booleanValue()) {
            this.countryTopRl.setVisibility(8);
            this.districtSpinnerTV.setVisibility(8);
            this.districtSpinner.setVisibility(0);
            this.downarrowIV2.setVisibility(4);
        } else {
            this.countryTopRl.setVisibility(8);
            this.districtSpinnerTV.setVisibility(0);
            this.districtSpinner.setVisibility(8);
            this.downarrowIV2.setVisibility(0);
        }
        if (this.show_dob.booleanValue()) {
            this.dobTopRl.setVisibility(0);
        } else {
            this.dobTopRl.setVisibility(8);
        }
        if (this.isGstin) {
            this.gstinTV.setVisibility(0);
        } else {
            this.gstinTV.setVisibility(8);
        }
        if (this.show_expert.booleanValue()) {
            this.expertTopRL.setVisibility(0);
        } else {
            this.expertTopRL.setVisibility(8);
        }
        if (this.isStateCityShow) {
            this.State.setVisibility(0);
            this.City.setVisibility(0);
        } else {
            this.State.setVisibility(8);
            this.City.setVisibility(8);
        }
        if (Helper.checkProfilePermission(Const.OTP_LOGIN) || BuildConfig.FLAVOR.equalsIgnoreCase("upscguide")) {
            this.hidePassword = true;
            this.til_password.setVisibility(8);
            this.til_confirm_password.setVisibility(8);
        }
        if (BuildConfig.FLAVOR.equalsIgnoreCase("DishaPublication")) {
            this.categorySpinnerLayout.setVisibility(8);
            signupFormNew = this;
            signupFormNew.NetworkAPICall(API.API_STUDENT_CATEGORY, "", false, false, false);
        } else {
            signupFormNew = this;
        }
        if (signupFormNew.isGenderShow) {
            signupFormNew.Gender.setVisibility(0);
        } else {
            signupFormNew.Gender.setVisibility(8);
        }
        if (signupFormNew.isLanguageShow) {
            signupFormNew.Language.setVisibility(0);
        } else {
            signupFormNew.Language.setVisibility(8);
        }
        if (signupFormNew.isPinCodeShow) {
            signupFormNew.pincodeTV.setVisibility(0);
        } else {
            signupFormNew.pincodeTV.setVisibility(8);
        }
        if (signupFormNew.isFatherNameShow) {
            signupFormNew.fatherNameTV.setVisibility(0);
        } else {
            signupFormNew.fatherNameTV.setVisibility(8);
        }
        if (signupFormNew.isCasteShow) {
            signupFormNew.Caste.setVisibility(0);
        } else {
            signupFormNew.Caste.setVisibility(8);
        }
        if (signupFormNew.isAlternateNumberShow) {
            signupFormNew.alternateMobileTV.setVisibility(0);
        } else {
            signupFormNew.alternateMobileTV.setVisibility(8);
        }
        if (signupFormNew.isAddressShow) {
            signupFormNew.addressTV.setVisibility(0);
        } else {
            signupFormNew.addressTV.setVisibility(8);
        }
        if (signupFormNew.isTenthMarksheetUpload) {
            signupFormNew.marksheet_rl.setVisibility(0);
        } else {
            signupFormNew.marksheet_rl.setVisibility(8);
        }
        if (signupFormNew.isPhotoUpload) {
            signupFormNew.profile_rl.setVisibility(0);
        } else {
            signupFormNew.profile_rl.setVisibility(8);
        }
        if (BuildConfig.FLAVOR.equalsIgnoreCase("physicsgalaxy")) {
            signupFormNew.iv_back.setImageTintList(null);
        }
        if (BuildConfig.FLAVOR.equalsIgnoreCase("Narayana")) {
            signupFormNew.tv_verify_email.setVisibility(8);
        } else {
            signupFormNew.tv_verify_email.setVisibility(8);
        }
        if (signupFormNew.isShowRollNumber.booleanValue()) {
            signupFormNew.rollNumberTV.setVisibility(0);
        } else {
            signupFormNew.rollNumberTV.setVisibility(8);
        }
        if (signupFormNew.isProfileTeacher.booleanValue()) {
            signupFormNew.nameMentor.setVisibility(0);
        } else {
            signupFormNew.nameMentor.setVisibility(8);
        }
        manageLeadingSpaces();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onViewCreated$0() {
        this.isProfilePic = true;
        checkStoragePermission();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onViewCreated$1() {
        this.isProfilePic = false;
        checkStoragePermission();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onViewCreated$2() {
        this.activity.onBackPressed();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onViewCreated$3() {
        onButtonClick();
        return null;
    }

    private void manageLeadingSpaces() {
        Helper.preventLeadingSpaces(this.nameTV);
        Helper.preventLeadingSpaces(this.fatherNameTV);
        Helper.preventLeadingSpaces(this.emailTV);
        Helper.preventLeadingSpaces(this.et_mobile);
        Helper.preventLeadingSpaces(this.alternateMobileTV);
        Helper.preventLeadingSpaces(this.rollNumberTV);
        Helper.preventLeadingSpaces(this.nameMentor);
        Helper.preventLeadingSpaces(this.districtSpinner);
        Helper.preventLeadingSpaces(this.addressTV);
        Helper.preventLeadingSpaces(this.pincodeTV);
        Helper.preventLeadingSpaces(this.gstinTV);
        Helper.preventLeadingSpaces(this.passwordET);
        Helper.preventLeadingSpaces(this.confirmPasswordET);
    }

    private void callRegUpdateUserData() {
        Helper.hideKeyboard(this.activity);
        this.devicetoken = FCMTokenHelper.getSavedToken(requireActivity());
        if (this.isUpdate) {
            hitapiforUpdateProfile();
            return;
        }
        String loggedInUserInfo = Helper.getLoggedInUserInfo(this.activity);
        FacebookEventLogger.logUserRegistration(this.activity, loggedInUserInfo);
        FacebookEventLogger.logSignUpEvent(this.activity, "MobileNumber", loggedInUserInfo);
        hitapiforregistration();
    }

    private void hitapiforUpdateProfile() {
        NetworkAPICall(API.update_profile, "", true, false, false);
    }

    private void hitapiforregistration() {
        NetworkAPICall(API.API_REGISTER_USER, "", true, false, false);
    }

    private void checkStoragePermission() {
        Dexter.withContext(this.activity).withPermissions("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA").withListener(new MultiplePermissionsListener() { // from class: com.appnew.android.loginRevamp.Fragment.SignupFormNew.2
            @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                SignupFormNew.this.imgClick();
            }

            @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                token.continuePermissionRequest();
            }
        }).check();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$4(CropImageView.CropResult cropResult) {
        if (cropResult.isSuccessful()) {
            if (this.str_imgTypeClick.equalsIgnoreCase("PhotoCameraRequest")) {
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.activity.getContentResolver(), cropResult.getUriContent());
                    new File(this.activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES) + "/Utkarsh/ProfileImage/").mkdirs();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream);
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    this.s3IU = new s3ImageUploading("", "vc-10000386-38616500102/166/application/profile/", this.activity, this, null);
                    ArrayList arrayList = new ArrayList();
                    MediaFile mediaFile = new MediaFile();
                    mediaFile.setFile_type("image");
                    mediaFile.setImage(bitmapDecodeStream);
                    arrayList.add(mediaFile);
                    this.s3IU.execute(arrayList);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (this.str_imgTypeClick.equalsIgnoreCase("PhotoGalleryRequest")) {
                try {
                    Bitmap bitmap2 = MediaStore.Images.Media.getBitmap(this.activity.getContentResolver(), cropResult.getUriContent());
                    new File(this.activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES) + "/utkarsh/ProfileImage/").mkdirs();
                    String str = "166_" + Calendar.getInstance().getTimeInMillis() + ".jpg";
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    bitmap2.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream2);
                    Bitmap bitmapDecodeStream2 = BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream2.toByteArray()));
                    byteArrayOutputStream2.flush();
                    byteArrayOutputStream2.close();
                    this.s3IU = new s3ImageUploading("", "vc-10000386-38616500102/166/application/profile/", this.activity, this, null);
                    ArrayList arrayList2 = new ArrayList();
                    MediaFile mediaFile2 = new MediaFile();
                    mediaFile2.setFile_type("image");
                    mediaFile2.setImage(bitmapDecodeStream2);
                    arrayList2.add(mediaFile2);
                    this.s3IU.execute(arrayList2);
                    return;
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            return;
        }
        Log.d("TAGCropImage", "CropImage: " + cropResult.getError().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$5(ActivityResult activityResult) {
        if (activityResult.getResultCode() == -1) {
            int i = this.requestCode;
            if (i != 10000) {
                if (i == 20000) {
                    try {
                        this.cropImage.launch(new CropImageContractOptions(activityResult.getData().getData(), Helper.cropImageOptions(requireActivity())));
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                return;
            }
            try {
                File file = new File(String.valueOf(this.activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES)));
                File[] fileArrListFiles = file.listFiles();
                int length = fileArrListFiles.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    File file2 = fileArrListFiles[i2];
                    if (file2.getName().equals("temp_image.jpg")) {
                        file = file2;
                        break;
                    }
                    i2++;
                }
                this.cropImage.launch(new CropImageContractOptions(FileProvider.getUriForFile(this.activity, "com.eduteria.app.app.provider", file), Helper.cropImageOptions(requireActivity())));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void imgClick() {
        final CharSequence[] charSequenceArr = {getResources().getString(R.string.take_photo), getResources().getString(R.string.choose_from_gallery), getResources().getString(R.string.cancel)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.activity);
        builder.setTitle(getResources().getString(R.string.add_photo));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: com.appnew.android.loginRevamp.Fragment.SignupFormNew$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$imgClick$6(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$imgClick$6(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals(getResources().getString(R.string.take_photo))) {
            try {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                Uri uriForFile = FileProvider.getUriForFile(this.activity, "com.eduteria.app.app.provider", new File(this.activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "temp_image.jpg"));
                this.str_imgTypeClick = "PhotoCameraRequest";
                intent.putExtra("output", uriForFile);
                this.someActivityResultLauncher.launch(intent);
                this.requestCode = 10000;
                return;
            } catch (Exception unused) {
                return;
            }
        }
        if (charSequenceArr[i].equals(getResources().getString(R.string.choose_from_gallery))) {
            Intent intent2 = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            Uri uriForFile2 = FileProvider.getUriForFile(this.activity, "com.eduteria.app.app.provider", new File(this.activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "temp_gallery.jpg"));
            this.str_imgTypeClick = "PhotoGalleryRequest";
            intent2.putExtra("output", uriForFile2);
            this.someActivityResultLauncher.launch(intent2);
            this.requestCode = 20000;
            return;
        }
        if (charSequenceArr[i].equals(getResources().getString(R.string.cancel))) {
            dialogInterface.dismiss();
        }
    }

    private void checkGoogleSignInValidationNavin() {
        if (this.nameTV.getVisibility() == 0 && !Helper.isNullChek(this.nameTV.getText().toString().trim())) {
            this.nameTV.setError(this.activity.getResources().getString(R.string.name_field_is_required));
            this.nameTV.requestFocus();
            return;
        }
        if (this.isEmailShow && !Helper.isNullChek(this.emailTV.getText().toString().trim())) {
            this.emailTV.setError(this.activity.getResources().getString(R.string.email_field_is_required));
            this.emailTV.requestFocus();
            return;
        }
        if (this.isEmailShow && !Patterns.EMAIL_ADDRESS.matcher(this.emailTV.getText().toString().trim()).matches()) {
            this.emailTV.setError(this.activity.getResources().getString(R.string.email_is_not_valid));
            this.emailTV.requestFocus();
        } else if (this.isGstin && !TextUtils.isEmpty(this.gstinTV.getText().toString()) && !Helper.isValidGSTNo(this.gstinTV.getText().toString())) {
            Toast.makeText(this.activity, getResources().getString(R.string.please_add_valid_gstin), 0).show();
        } else {
            callRegUpdateUserData();
        }
    }

    private void hit_api_to_get_country() {
        NetworkAPICall(API.API_COUNTRY, "", false, false, false);
    }

    private void hit_api_to_get_state() {
        NetworkAPICall(API.API_STATE, "", false, false, false);
    }

    private void hit_api_to_get_language() {
        NetworkAPICall(API.get_languages, "", false, false, false);
    }

    private void hit_api_to_get_city() {
        if (this.show_country.booleanValue()) {
            return;
        }
        NetworkAPICall(API.API_CITY, "", true, false, false);
    }

    private void checkValidation() {
        if (this.nameTV.getVisibility() == 0 && !Helper.isNullChek(this.nameTV.getText().toString().trim())) {
            this.nameTV.setError(this.activity.getResources().getString(R.string.name_field_is_required));
            this.nameTV.requestFocus();
            return;
        }
        if (this.isEmailShow && !Helper.isNullChek(this.emailTV.getText().toString().trim())) {
            this.emailTV.setError(this.activity.getResources().getString(R.string.email_field_is_required));
            this.emailTV.requestFocus();
            return;
        }
        if (this.isEmailShow && !Patterns.EMAIL_ADDRESS.matcher(this.emailTV.getText().toString().trim()).matches()) {
            this.emailTV.setError(this.activity.getResources().getString(R.string.email_is_not_valid));
            this.emailTV.requestFocus();
            return;
        }
        if (this.isEmailShow && !Patterns.EMAIL_ADDRESS.matcher(this.emailTV.getText().toString().trim()).matches()) {
            this.emailTV.setError(this.activity.getResources().getString(R.string.email_is_not_valid));
            this.emailTV.requestFocus();
            return;
        }
        if (this.show_dob.booleanValue() && Helper.isNullChek(this.dobEt.getText().toString().trim()) && this.dobEt.getText().toString().equalsIgnoreCase(this.activity.getResources().getString(R.string.dob))) {
            Helper.enableErrorInTextview(this.tvDobError, this.activity.getResources().getString(R.string.please_select_dob));
            return;
        }
        if (this.isShowRollNumber.booleanValue() && !Helper.isNullChek(this.rollNumberTV.getText().toString().trim())) {
            this.rollNumberTV.setError("Please enter roll number");
            this.rollNumberTV.requestFocus();
            return;
        }
        if (this.show_expert.booleanValue() && Helper.isNullChek(this.expertSpinner.getText().toString().trim()) && this.expertSpinner.getText().toString().equalsIgnoreCase(this.activity.getResources().getString(R.string.professional_student))) {
            Helper.enableErrorInTextview(this.tvExpertError, this.activity.getResources().getString(R.string.please_select_professional_student));
            return;
        }
        if (this.isStateCityShow && Helper.isNullChek(this.stateSpinner.getText().toString().trim()) && this.stateSpinner.getText().toString().equalsIgnoreCase(this.activity.getResources().getString(R.string.state))) {
            Helper.enableErrorInTextview(this.tvStateError, this.activity.getResources().getString(R.string.please_select_state));
            return;
        }
        if (this.isStateCityShow && !this.show_country.booleanValue() && Helper.isNullChek(this.districtSpinnerTV.getText().toString().trim()) && this.districtSpinnerTV.getText().toString().equalsIgnoreCase(this.activity.getResources().getString(R.string.district))) {
            Helper.enableErrorInTextview(this.tvDistrictError, this.activity.getResources().getString(R.string.please_select_district));
            return;
        }
        if (this.isStateCityShow && this.show_country.booleanValue() && !Helper.isNullChek(this.districtSpinner.getText().toString().trim())) {
            this.districtSpinner.setError(this.activity.getResources().getString(R.string.please_enter_district));
            this.districtSpinner.requestFocus();
            return;
        }
        if (this.isGstin && !TextUtils.isEmpty(this.gstinTV.getText().toString()) && !Helper.isValidGSTNo(this.gstinTV.getText().toString())) {
            Toast.makeText(this.activity, getResources().getString(R.string.please_add_valid_gstin), 0).show();
            return;
        }
        if (this.isGenderShow && TextUtils.isEmpty(this.genderSpinner.getText().toString())) {
            this.tv_genderError.setError(this.activity.getResources().getString(R.string.gender_field_is_required));
            this.tv_genderError.requestFocus();
            return;
        }
        if (this.isCasteShow && TextUtils.isEmpty(this.casteSpinner.getText().toString())) {
            this.tv_casteError.setError(this.activity.getResources().getString(R.string.caste_field_is_required));
            this.tv_casteError.requestFocus();
            return;
        }
        if (this.isAddressShow && TextUtils.isEmpty(this.addressTV.getText().toString())) {
            this.addressTV.setError(this.activity.getResources().getString(R.string.address_field_is_required));
            this.addressTV.requestFocus();
            return;
        }
        if (this.isFatherNameShow && TextUtils.isEmpty(this.fatherNameTV.getText().toString())) {
            this.fatherNameTV.setFocusable(true);
            this.fatherNameTV.setError(this.activity.getResources().getString(R.string.father_field_is_required));
            this.fatherNameTV.requestFocus();
            return;
        }
        if (this.isLanguageShow && TextUtils.isEmpty(this.languageSpinner.getText().toString())) {
            this.tv_languageError.setFocusable(true);
            this.tv_languageError.setError(this.activity.getResources().getString(R.string.language_field_is_required));
            this.tv_languageError.requestFocus();
            return;
        }
        if (this.isPinCodeShow && TextUtils.isEmpty(this.pincodeTV.getText().toString())) {
            this.pincodeTV.setFocusable(true);
            this.pincodeTV.setError(this.activity.getResources().getString(R.string.pin_code_is_required));
            this.pincodeTV.requestFocus();
            return;
        }
        if (this.isPhotoUpload && TextUtils.isEmpty(this.profilepic)) {
            this.profile_pic_txt.setError(this.activity.getResources().getString(R.string.please_upload_profile_pic));
            this.profile_pic_txt.requestFocus();
            return;
        }
        if (this.isTenthMarksheetUpload && TextUtils.isEmpty(this.marksheetpic)) {
            this.marksheet_txt.setError(this.activity.getResources().getString(R.string.please_upload_marksheet));
            this.marksheet_txt.requestFocus();
            return;
        }
        if (this.hidePassword) {
            callRegUpdateUserData();
            return;
        }
        if (!Helper.isNullChek(this.passwordET.getText().toString().trim())) {
            Toast.makeText(this.activity, getResources().getString(R.string.password_field_is_required), 0).show();
            return;
        }
        if (this.passwordET.getText().length() < 8 || this.passwordET.getText().length() > 13) {
            Toast.makeText(this.activity, getResources().getString(R.string.password_must_vary_from_8_to_13_characters), 0).show();
            return;
        }
        if (!Helper.isNullChek(this.confirmPasswordET.getText().toString().trim())) {
            Toast.makeText(this.activity, getResources().getString(R.string.confirm_password_field_is_required), 0).show();
            return;
        }
        if (!this.passwordET.getText().toString().equals(this.confirmPasswordET.getText().toString().trim())) {
            Toast.makeText(this.activity, getResources().getString(R.string.password_and_confirm_password_not_matched), 0).show();
            return;
        }
        if (BuildConfig.FLAVOR.equalsIgnoreCase("DishaPublication") && !Helper.isValidPassword(this.passwordET.getText().toString())) {
            Toast.makeText(this.activity, getResources().getString(R.string.password_in_valid), 0).show();
            return;
        }
        if (BuildConfig.FLAVOR.equalsIgnoreCase("DishaPublication") && !Helper.isValidPassword(this.confirmPasswordET.getText().toString())) {
            Toast.makeText(this.activity, getResources().getString(R.string.password_in_valid), 0).show();
        } else if (this.editTextEnable && !Helper.isNullChek(this.nameMentor.getText().toString().trim())) {
            this.nameMentor.setError(this.activity.getResources().getString(R.string.mentor_field_is_required));
            this.nameMentor.requestFocus();
        } else {
            callRegUpdateUserData();
        }
    }

    private void checkValidationNavin() {
        if (this.nameTV.getVisibility() == 0 && !Helper.isNullChek(this.nameTV.getText().toString().trim())) {
            this.nameTV.setError(this.activity.getResources().getString(R.string.name_field_is_required));
            this.nameTV.requestFocus();
            return;
        }
        if (this.isEmailShow && !Helper.isNullChek(this.emailTV.getText().toString().trim())) {
            this.emailTV.setError(this.activity.getResources().getString(R.string.email_field_is_required));
            this.emailTV.requestFocus();
            return;
        }
        if (this.isEmailShow && !Patterns.EMAIL_ADDRESS.matcher(this.emailTV.getText().toString().trim()).matches()) {
            this.emailTV.setError(this.activity.getResources().getString(R.string.email_is_not_valid));
            this.emailTV.requestFocus();
            return;
        }
        if (this.isGstin && !TextUtils.isEmpty(this.gstinTV.getText().toString()) && !Helper.isValidGSTNo(this.gstinTV.getText().toString())) {
            Toast.makeText(this.activity, getResources().getString(R.string.please_add_valid_gstin), 0).show();
            return;
        }
        if (this.isShowRollNumber.booleanValue() && !Helper.isNullChek(this.rollNumberTV.getText().toString().trim())) {
            this.rollNumberTV.setError("Please enter roll number");
            this.rollNumberTV.requestFocus();
            return;
        }
        if (!Helper.isNullChek(this.passwordET.getText().toString().trim())) {
            Toast.makeText(this.activity, getResources().getString(R.string.password_field_is_required), 0).show();
            return;
        }
        if (this.passwordET.getText().length() < 8 || this.passwordET.getText().length() > 13) {
            Toast.makeText(this.activity, getResources().getString(R.string.password_must_vary_from_8_to_13_characters), 0).show();
            return;
        }
        if (!Helper.isNullChek(this.confirmPasswordET.getText().toString().trim())) {
            Toast.makeText(this.activity, getResources().getString(R.string.confirm_password_field_is_required), 0).show();
        } else if (!this.passwordET.getText().toString().equals(this.confirmPasswordET.getText().toString().trim())) {
            Toast.makeText(this.activity, getResources().getString(R.string.password_and_confirm_password_not_matched), 0).show();
        } else {
            callRegUpdateUserData();
        }
    }

    private void checkGoogleSignInValidation() {
        if (this.nameTV.getVisibility() == 0 && !Helper.isNullChek(this.nameTV.getText().toString().trim())) {
            this.nameTV.setError(this.activity.getResources().getString(R.string.name_field_is_required));
            this.nameTV.requestFocus();
            return;
        }
        if (this.isEmailShow && !Helper.isNullChek(this.emailTV.getText().toString().trim())) {
            this.emailTV.setError(this.activity.getResources().getString(R.string.email_field_is_required));
            this.emailTV.requestFocus();
            return;
        }
        if (this.isEmailShow && !Patterns.EMAIL_ADDRESS.matcher(this.emailTV.getText().toString().trim()).matches()) {
            this.emailTV.setError(this.activity.getResources().getString(R.string.email_is_not_valid));
            this.emailTV.requestFocus();
            return;
        }
        if (this.isShowRollNumber.booleanValue() && !Helper.isNullChek(this.rollNumberTV.getText().toString().trim())) {
            this.rollNumberTV.setError("Please enter roll number");
            this.rollNumberTV.requestFocus();
            return;
        }
        if (this.isStateCityShow && Helper.isNullChek(this.stateSpinner.getText().toString().trim()) && this.stateSpinner.getText().toString().equalsIgnoreCase(this.activity.getResources().getString(R.string.state))) {
            Helper.enableErrorInTextview(this.tvStateError, this.activity.getResources().getString(R.string.please_select_state));
            return;
        }
        if (this.isStateCityShow && !this.show_country.booleanValue() && Helper.isNullChek(this.districtSpinnerTV.getText().toString().trim()) && this.districtSpinnerTV.getText().toString().equalsIgnoreCase(this.activity.getResources().getString(R.string.district))) {
            Helper.enableErrorInTextview(this.tvDistrictError, this.activity.getResources().getString(R.string.please_select_district));
            return;
        }
        if (this.isStateCityShow && this.show_country.booleanValue() && !Helper.isNullChek(this.districtSpinner.getText().toString().trim())) {
            this.districtSpinner.setError(this.activity.getResources().getString(R.string.please_enter_district));
            this.districtSpinner.requestFocus();
        } else if (this.isGstin && !TextUtils.isEmpty(this.gstinTV.getText().toString()) && !Helper.isValidGSTNo(this.gstinTV.getText().toString())) {
            Toast.makeText(this.activity, getResources().getString(R.string.please_add_valid_gstin), 0).show();
        } else {
            callRegUpdateUserData();
        }
    }

    public void openDatePickerDialog(Context context, final TextView dobTV, final Calendar c2) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() { // from class: com.appnew.android.loginRevamp.Fragment.SignupFormNew.3
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                dobTV.setText(new StringBuilder().append(dayOfMonth).append(MqttTopic.TOPIC_LEVEL_SEPARATOR).append(monthOfYear + 1).append(MqttTopic.TOPIC_LEVEL_SEPARATOR).append(year).append(" "));
                c2.set(1, year);
                c2.set(2, monthOfYear);
                c2.set(5, dayOfMonth);
                Helper.enableErrorInTextview(SignupFormNew.this.tvDobError, null);
            }
        }, c2.get(1), c2.get(2), c2.get(5));
        datePickerDialog.getDatePicker().setMaxDate(Calendar.getInstance().getTimeInMillis());
        datePickerDialog.show();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.appnew.android.Utils.Network.MainFragment
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        byte b2 = -1;
        switch (apitype.hashCode()) {
            case -787266248:
                if (apitype.equals(API.API_CITY)) {
                    b2 = 0;
                }
                break;
            case -382410008:
                if (apitype.equals(API.API_STUDENT_CATEGORY)) {
                    b2 = 1;
                }
                break;
            case -319596559:
                if (apitype.equals(API.API_STATE)) {
                    b2 = 2;
                }
                break;
            case -261081325:
                if (apitype.equals(API.API_REGISTER_USER)) {
                    b2 = 3;
                }
                break;
            case -15853979:
                if (apitype.equals(API.API_COUNTRY)) {
                    b2 = 4;
                }
                break;
            case 1631865:
                if (apitype.equals(API.get_my_profile)) {
                    b2 = 5;
                }
                break;
            case 149836748:
                if (apitype.equals(API.get_languages)) {
                    b2 = 6;
                }
                break;
            case 1630777357:
                if (apitype.equals(API.update_profile)) {
                    b2 = 7;
                }
                break;
        }
        switch (b2) {
            case 0:
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setState_id(this.SelectedStateid);
                return service.GetCity(AES.encrypt(new Gson().toJson(encryptionData)));
            case 1:
                EncryptionData encryptionData2 = new EncryptionData();
                encryptionData2.setUser_id(MakeMyExam.getUserId());
                return service.GetStudentCategory(AES.encrypt(new Gson().toJson(encryptionData2)));
            case 2:
                EncryptionData encryptionData3 = new EncryptionData();
                if (!TextUtils.isEmpty(this.SelectedCountryid)) {
                    encryptionData3.setCountry_id(this.SelectedCountryid);
                }
                return service.GetState(AES.encrypt(new Gson().toJson(encryptionData3)));
            case 3:
                EncryptionData encryptionData4 = new EncryptionData();
                encryptionData4.setPassword(this.passwordET.getText().toString());
                encryptionData4.setName(this.nameTV.getVisibility() == 0 ? this.nameTV.getText().toString() : Constants.G_NAME);
                if (!this.isEmailLogin) {
                    encryptionData4.setEmail(this.emailTV.getVisibility() == 0 ? this.emailTV.getText().toString() : "");
                    encryptionData4.setMobile(this.et_mobile.getText().toString());
                } else {
                    encryptionData4.setEmail(this.emailTV.getText().toString());
                    encryptionData4.setMobile(this.et_mobile.getVisibility() == 0 ? this.et_mobile.getText().toString() : "");
                }
                if (this.isShowRollNumber.booleanValue()) {
                    encryptionData4.setRoll_no(this.rollNumberTV.getText().toString().trim());
                }
                if (this.isProfileTeacher.booleanValue()) {
                    encryptionData4.setUser_mentor(this.nameMentor.getText().toString());
                }
                if (this.isPhotoUpload) {
                    encryptionData4.setProfile_picture(this.profilepic);
                }
                if (this.isFatherNameShow) {
                    encryptionData4.setFather_name(this.fatherNameTV.getText().toString());
                }
                if (this.isAlternateNumberShow) {
                    encryptionData4.setAlternate_number(this.alternateMobileTV.getText().toString());
                }
                if (this.isGenderShow) {
                    encryptionData4.setGender(this.gender);
                }
                if (this.isCasteShow) {
                    encryptionData4.setCaste_category(this.caste);
                }
                if (this.isAddressShow) {
                    encryptionData4.setAddress(this.addressTV.getText().toString());
                }
                if (this.isTenthMarksheetUpload) {
                    encryptionData4.setProof_marksheet(this.marksheetpic);
                }
                if (this.isLanguageShow) {
                    encryptionData4.setLang(this.languageId);
                }
                if (this.isPinCodeShow) {
                    encryptionData4.setPin_code(this.pincodeTV.getText().toString());
                }
                boolean z = this.isGstin;
                if (z) {
                    encryptionData4.setGstin(z ? this.gstinTV.getText().toString() : "");
                }
                if (this.show_country.booleanValue()) {
                    encryptionData4.setCountry(this.show_country.booleanValue() ? this.countrySpinner.getText().toString() : "India");
                }
                boolean z2 = this.isStateCityShow;
                if (z2) {
                    encryptionData4.setState(z2 ? this.stateSpinner.getText().toString() : "");
                    encryptionData4.setCity(this.isStateCityShow ? this.districtSpinner.getText().toString() : "");
                }
                if (this.show_dob.booleanValue()) {
                    encryptionData4.setDate_of_birth(this.show_dob.booleanValue() ? this.dobEt.getText().toString() : "");
                }
                if (this.show_expert.booleanValue()) {
                    if (!TextUtils.isEmpty(this.expertSpinner.getText()) && this.expertSpinner.getText().toString().equalsIgnoreCase(this.activity.getResources().getString(R.string.professional))) {
                        encryptionData4.setIs_expert("1");
                    } else {
                        encryptionData4.setIs_expert("0");
                    }
                }
                encryptionData4.setStudent_category(this.categorySpinner.getText().toString());
                encryptionData4.setIs_social("0");
                encryptionData4.setDevice_id(this.deviceId);
                encryptionData4.setOtp(this.otp);
                encryptionData4.setC_code(this.c_code);
                encryptionData4.setDevice_tokken(this.devicetoken);
                encryptionData4.setSocial_type(this.socialType);
                encryptionData4.setIs_social(this.isSocial);
                encryptionData4.setSocial_token(SharedPreference.getInstance().getGoogleToken(Const.SOCIAL_TOKEN));
                LocationInfo locationInfo = new LocationInfo();
                locationInfo.setLat(TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.LOCATION_LAT)) ? "N/A" : SharedPreference.getInstance().getString(Const.LOCATION_LAT));
                locationInfo.setLng(TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.LOCATION_LNG)) ? "N/A" : SharedPreference.getInstance().getString(Const.LOCATION_LNG));
                locationInfo.setIp("");
                locationInfo.setManufacturer(TextUtils.isEmpty(Build.MANUFACTURER) ? "N/A" : Build.MANUFACTURER);
                locationInfo.setDevice_model(TextUtils.isEmpty(Build.MODEL) ? "N/A" : Build.MODEL);
                locationInfo.setOs_version(TextUtils.isEmpty(Build.VERSION.RELEASE) ? "N/A" : Build.VERSION.RELEASE);
                encryptionData4.setLocation(locationInfo);
                String json = new Gson().toJson(encryptionData4);
                Log.d("TAGUSERCHECK", "API_REGISTER_USER: " + json);
                return service.registerUser(AES.encrypt(json));
            case 4:
                EncryptionData encryptionData5 = new EncryptionData();
                encryptionData5.setUser_id(MakeMyExam.getUserId());
                return service.GetCountry(AES.encrypt(new Gson().toJson(encryptionData5)));
            case 5:
                EncryptionData encryptionData6 = new EncryptionData();
                if (!this.isEmailLogin) {
                    encryptionData6.setMobile(this.et_mobile.getText().toString());
                }
                encryptionData6.setDevice_id(this.deviceId);
                encryptionData6.setPassword(this.passwordET.getText().toString());
                encryptionData6.setIs_social("0");
                return service.userProfile(AES.encrypt(new Gson().toJson(encryptionData6)));
            case 6:
                return service.GetLanguage(AES.encrypt(new Gson().toJson(new EncryptionData())));
            case 7:
                EncryptionData encryptionData7 = new EncryptionData();
                encryptionData7.setName(this.nameTV.getVisibility() == 0 ? this.nameTV.getText().toString() : Constants.G_NAME);
                if (!this.isEmailLogin) {
                    encryptionData7.setEmail(this.emailTV.getVisibility() == 0 ? this.emailTV.getText().toString() : "");
                    encryptionData7.setMobile(this.et_mobile.getText().toString());
                } else {
                    encryptionData7.setEmail(this.emailTV.getText().toString());
                    encryptionData7.setMobile(this.et_mobile.getVisibility() == 0 ? this.et_mobile.getText().toString() : "");
                }
                if (this.isShowRollNumber.booleanValue()) {
                    encryptionData7.setRoll_no(this.rollNumberTV.getText().toString().trim());
                }
                if (this.isProfileTeacher.booleanValue()) {
                    encryptionData7.setUser_mentor(this.nameMentor.getText().toString());
                }
                if (this.isPhotoUpload) {
                    encryptionData7.setProfile_picture(this.profilepic);
                }
                if (this.isFatherNameShow) {
                    encryptionData7.setFather_name(this.fatherNameTV.getText().toString());
                }
                if (this.isAlternateNumberShow) {
                    encryptionData7.setAlternate_number(this.alternateMobileTV.getText().toString());
                }
                if (this.isGenderShow) {
                    encryptionData7.setGender(this.gender);
                }
                if (this.isCasteShow) {
                    encryptionData7.setCaste_category(this.caste);
                }
                if (this.isAddressShow) {
                    encryptionData7.setAddress(this.addressTV.getText().toString());
                }
                if (this.isTenthMarksheetUpload) {
                    encryptionData7.setProof_marksheet(this.marksheetpic);
                }
                if (this.isLanguageShow) {
                    encryptionData7.setLang(this.languageId);
                }
                if (this.isPinCodeShow) {
                    encryptionData7.setPin_code(this.pincodeTV.getText().toString());
                }
                boolean z3 = this.isGstin;
                if (z3) {
                    encryptionData7.setGstin(z3 ? this.gstinTV.getText().toString() : "");
                }
                if (this.show_country.booleanValue()) {
                    encryptionData7.setCountry(this.show_country.booleanValue() ? this.countrySpinner.getText().toString() : "India");
                }
                boolean z4 = this.isStateCityShow;
                if (z4) {
                    encryptionData7.setState(z4 ? this.stateSpinner.getText().toString() : "");
                    encryptionData7.setCity(this.isStateCityShow ? this.districtSpinner.getText().toString() : "");
                }
                if (this.show_dob.booleanValue()) {
                    encryptionData7.setDate_of_birth(this.show_dob.booleanValue() ? this.dobEt.getText().toString() : "");
                }
                if (this.show_expert.booleanValue()) {
                    if (!TextUtils.isEmpty(this.expertSpinner.getText()) && this.expertSpinner.getText().toString().equalsIgnoreCase(this.activity.getResources().getString(R.string.professional))) {
                        encryptionData7.setIs_expert("1");
                    } else {
                        encryptionData7.setIs_expert("0");
                    }
                }
                encryptionData7.setStudent_category(this.categorySpinner.getText().toString());
                encryptionData7.setIs_social("0");
                encryptionData7.setDevice_id(this.deviceId);
                encryptionData7.setOtp(this.otp);
                encryptionData7.setC_code(this.c_code);
                encryptionData7.setDevice_tokken(this.devicetoken);
                encryptionData7.setSocial_type(this.socialType);
                encryptionData7.setIs_social(this.isSocial);
                encryptionData7.setSocial_token(SharedPreference.getInstance().getGoogleToken(Const.SOCIAL_TOKEN));
                LocationInfo locationInfo2 = new LocationInfo();
                locationInfo2.setLat(TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.LOCATION_LAT)) ? "N/A" : SharedPreference.getInstance().getString(Const.LOCATION_LAT));
                locationInfo2.setLng(TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.LOCATION_LNG)) ? "N/A" : SharedPreference.getInstance().getString(Const.LOCATION_LNG));
                locationInfo2.setIp("");
                locationInfo2.setManufacturer(TextUtils.isEmpty(Build.MANUFACTURER) ? "N/A" : Build.MANUFACTURER);
                locationInfo2.setDevice_model(TextUtils.isEmpty(Build.MODEL) ? "N/A" : Build.MODEL);
                locationInfo2.setOs_version(TextUtils.isEmpty(Build.VERSION.RELEASE) ? "N/A" : Build.VERSION.RELEASE);
                encryptionData7.setLocation(locationInfo2);
                String json2 = new Gson().toJson(encryptionData7);
                Log.d("TAGUSERCHECK", "update_profile: " + json2);
                return service.updateprofile(AES.encrypt(json2));
            default:
                return null;
        }
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void SuccessCallBack(JSONObject jsonString, String apitype, String typeApi, boolean showprogress) throws JSONException {
        String loggedInUserInfo;
        Intent intent;
        apitype.hashCode();
        switch (apitype) {
            case "https://appapi.videocrypt.in/index.php/data_model/master_hit/get_cities":
                if (jsonString.getBoolean("status")) {
                    this.cities = (StatesCities) new Gson().fromJson(jsonString.toString(), StatesCities.class);
                    break;
                }
                break;
            case "https://appapi.videocrypt.in/index.php/data_model/master_hit/student_category":
                if (jsonString.getBoolean("status")) {
                    this.categorySpinner.setText(this.activity.getResources().getString(R.string.exam_preparation_for));
                    this.category = (StatesCities) new Gson().fromJson(jsonString.toString(), StatesCities.class);
                    break;
                }
                break;
            case "https://appapi.videocrypt.in/index.php/data_model/master_hit/get_states":
                if (jsonString.getBoolean("status")) {
                    this.states = (StatesCities) new Gson().fromJson(jsonString.toString(), StatesCities.class);
                    break;
                }
                break;
            case "https://appapi.videocrypt.in/index.php/data_model/users/registration":
                try {
                    Helper.logPrinter(this.activity.getLocalClassName(), "e", jsonString.toString(), "Message");
                    if (jsonString.optString("status").equals("true")) {
                        SharedPreference.getInstance().putString(Const.JWT, jsonString.getJSONObject("data").optString(Const.JWT));
                        NetworkAPICall(API.get_my_profile, "", false, false, false);
                    } else {
                        ErrorCallBack(jsonString.getString("message"), apitype, typeApi);
                    }
                    break;
                } catch (Exception e2) {
                    ErrorCallBack(e2.getMessage() + " : " + e2.getLocalizedMessage(), apitype, typeApi);
                    e2.printStackTrace();
                    return;
                }
                break;
            case "https://appapi.videocrypt.in/index.php/data_model/master_hit/get_countries":
                if (jsonString.getBoolean("status")) {
                    StatesCities statesCities = (StatesCities) new Gson().fromJson(jsonString.toString(), StatesCities.class);
                    this.countries = statesCities;
                    if (statesCities != null && statesCities.getData() != null) {
                        for (StatesCitiesData statesCitiesData : this.countries.getData()) {
                            if (this.c_nameCode.equalsIgnoreCase(statesCitiesData.getShortname())) {
                                this.SelectedCountryid = statesCitiesData.getId();
                                this.countrySpinner.setText(statesCitiesData.getName());
                                this.stateSpinner.setText(this.activity.getResources().getString(R.string.state));
                                this.districtSpinner.setText("");
                                this.districtSpinnerTV.setText(this.activity.getResources().getString(R.string.district));
                                hit_api_to_get_state();
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            case "https://appapi.videocrypt.in/index.php/data_model/users/get_my_profile":
                try {
                    if (jsonString.optString("status").equals("true")) {
                        FacebookEventLogger.logSignUp(this.activity);
                        Shortsuts.INSTANCE.updateShortcuts(this.activity);
                        SharedPreference.getInstance().putBoolean(Const.IS_USER_LOGGED_IN, true);
                        SharedPreference.getInstance().putBoolean(Const.IS_USER_REGISTRATION_DONE, true);
                        UserData userData = (UserData) new Gson().fromJson(jsonString.toString(), UserData.class);
                        MakeMyExam.setUserId(userData.getData().getId());
                        SharedPreference.getInstance().setLoggedInUserr(userData.getData());
                        AnalyticEvents.INSTANCE.addUpdateCleverTapUser(getContext(), false);
                        pushEvent();
                        SharedPreference.getInstance().putBoolean("showpopup", true);
                        SharedPreference.getInstance().putString(Const.C_NAME, this.c_name);
                        SharedPreference.getInstance().putString(Const.C_NAME_CODE, this.c_nameCode);
                        SharedPreference.getInstance().putString(Const.C_ID, this.SelectedCountryid);
                        new PigibagTable();
                        if (this.utkashRoom.getpigibag().getuserid() != null) {
                            PigibagTable pigibagTable = this.utkashRoom.getpigibag().getuserid();
                            Helper.clearappdata(this.activity);
                            pigibagTable.getUser_id().equalsIgnoreCase(MakeMyExam.userId);
                        }
                        if (jsonString.getJSONObject("data").getJSONObject("change_detector").getJSONObject("version_control").getJSONObject("permissions").has(Const.SHOW_STUDENT_CLASS)) {
                            SharedPreference.getInstance().putString(Const.SHOW_STUDENT_CLASS_ON_PROFILE, jsonString.getJSONObject("data").getJSONObject("change_detector").getJSONObject("version_control").getJSONObject("permissions").optString(Const.SHOW_STUDENT_CLASS));
                        }
                        if (jsonString.getJSONObject("data").has("change_detector")) {
                            try {
                                if (jsonString.getJSONObject("data").getJSONObject("change_detector").getJSONObject("master").has("ut_009") && !this.utkashRoom.getapidao().is_api_code_exits(MakeMyExam.userId, "ut_009")) {
                                    APITABLE apitable = new APITABLE();
                                    apitable.setApicode("ut_009");
                                    apitable.setApiname("master_content");
                                    apitable.setInterval("0");
                                    apitable.setUser_id(MakeMyExam.userId);
                                    apitable.setTimestamp(String.valueOf(jsonString.optLong("time")));
                                    apitable.setCdtimestamp("0");
                                    apitable.setVersion(jsonString.getJSONObject("data").getJSONObject("change_detector").getJSONObject("master").getString("ut_009"));
                                    this.utkashRoom.getapidao().addUser(apitable);
                                }
                                if (jsonString.getJSONObject("data").getJSONObject("change_detector").getJSONObject("master").has("ut_012") && !this.utkashRoom.getapidao().is_api_code_exits(MakeMyExam.userId, "ut_012")) {
                                    APITABLE apitable2 = new APITABLE();
                                    apitable2.setApicode("ut_012");
                                    apitable2.setApiname("get_my_courses");
                                    apitable2.setInterval("0");
                                    apitable2.setUser_id(MakeMyExam.userId);
                                    apitable2.setTimestamp(String.valueOf(jsonString.optLong("time")));
                                    apitable2.setCdtimestamp("0");
                                    apitable2.setVersion(jsonString.getJSONObject("data").getJSONObject("change_detector").getJSONObject("master").getString("ut_012"));
                                    this.utkashRoom.getapidao().addUser(apitable2);
                                }
                                if (jsonString.getJSONObject("data").getJSONObject("change_detector").getJSONObject("master").has("ut_010") && !this.utkashRoom.getapidao().is_api_code_exits(MakeMyExam.userId, "ut_010")) {
                                    APITABLE apitable3 = new APITABLE();
                                    apitable3.setApicode("ut_010");
                                    apitable3.setApiname("get_courses");
                                    apitable3.setInterval("0");
                                    apitable3.setUser_id(MakeMyExam.userId);
                                    apitable3.setTimestamp(String.valueOf(jsonString.optLong("time")));
                                    apitable3.setCdtimestamp("0");
                                    apitable3.setVersion(jsonString.getJSONObject("data").getJSONObject("change_detector").getJSONObject("master").getString("ut_010"));
                                    this.utkashRoom.getapidao().addUser(apitable3);
                                }
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                        Bundle bundle = new Bundle();
                        bundle.putString(AppEventsConstants.EVENT_PARAM_REGISTRATION_METHOD, "Mobile Number");
                        AppEventsLogger.newLogger(this.activity).logEvent(AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION, bundle);
                        FacebookEventLogger.logUserRegistration(requireContext(), Helper.getLoggedInUserInfo(requireContext()));
                        this.activity.finish();
                        SharedPreference.getInstance().putBoolean("show_feeds", true);
                        if ("1".equalsIgnoreCase("1")) {
                            if (Helper.checkProfilePermission(Const.PREFERENCE_SELECTION_TYPE)) {
                                intent = new Intent(this.activity, (Class<?>) IntroActivity.class);
                                intent.putExtra("is_preference_empty", true);
                                intent.putExtra("is_from_home", FirebaseAnalytics.Event.LOGIN);
                            } else {
                                if (SharedPreference.getInstance().getTestUser() != null && SharedPreference.getInstance().getTestUser().getMobile() != null && !SharedPreference.getInstance().getTestUser().getMobile().equalsIgnoreCase(userData.getData().getMobile())) {
                                    SharedPreference.getInstance().ClearTestUser();
                                }
                                intent = new Intent(this.activity, (Class<?>) DashboardActivityTheme1.class);
                            }
                        } else if ("1".equalsIgnoreCase("2")) {
                            if (BuildConfig.FLAVOR.equalsIgnoreCase("onlineSkillIndia") && (userData.getData().getIs_purchase() == null || !userData.getData().getIs_purchase().equalsIgnoreCase("1"))) {
                                intent = new Intent(this.activity, (Class<?>) ChooseCourseNewActivity.class);
                            } else {
                                intent = new Intent(this.activity, (Class<?>) DashboardActivityTheme2.class);
                            }
                        } else if ("1".equalsIgnoreCase("3")) {
                            if (BuildConfig.FLAVOR.equalsIgnoreCase("utkarsh")) {
                                intent = new Intent(this.activity, (Class<?>) HomeActivity.class);
                            } else {
                                intent = new Intent(this.activity, (Class<?>) DashboardActivityTheme3.class);
                            }
                        } else if ("1".equalsIgnoreCase("4")) {
                            intent = new Intent(this.activity, (Class<?>) DashboardActivityTheme4.class);
                        } else if ("1".equalsIgnoreCase("5")) {
                            intent = new Intent(this.activity, (Class<?>) DashboardActivityTheme5.class);
                        } else if ("1".equalsIgnoreCase("6")) {
                            intent = new Intent(this.activity, (Class<?>) DashboardActivityTheme7.class);
                        } else if (!"1".equalsIgnoreCase("7")) {
                            intent = null;
                        } else if (userData.getData() != null && userData.getData().getPreferences() != null && userData.getData().getPreferences().size() > 0) {
                            intent = new Intent(this.activity, (Class<?>) DashboardActivityTheme8.class);
                        } else {
                            intent = new Intent(this.activity, (Class<?>) CategoryActivity.class);
                            intent.putExtra("is_preference_empty", true);
                        }
                        intent.setFlags(268468224);
                        Helper.gotoActivity(intent, this.activity);
                    } else {
                        ErrorCallBack(jsonString.getString("message"), apitype, typeApi);
                    }
                    break;
                } catch (Exception e4) {
                    ErrorCallBack(e4.getMessage() + " : " + e4.getLocalizedMessage(), apitype, typeApi);
                    e4.printStackTrace();
                    return;
                }
                break;
            case "https://appapi.videocrypt.in/index.php/data_model/master_hit/get_languages":
                if (jsonString.getBoolean("status")) {
                    this.languagesData = (LanguagesData) new Gson().fromJson(jsonString.toString(), LanguagesData.class);
                    break;
                }
                break;
            case "https://appapi.videocrypt.in/index.php/data_model/users/update_profile":
                try {
                    Helper.logPrinter(this.activity.getLocalClassName(), "e", jsonString.toString(), "Message");
                    loggedInUserInfo = Helper.getLoggedInUserInfo(this.activity);
                    Helper.firebaseAnalytics(this.activity, loggedInUserInfo, "NA", "NA", "NA", "NA", "NA", "SignIn");
                    try {
                        if (jsonString.optString("status").equals("true")) {
                            NetworkAPICall(API.get_my_profile, "", false, false, false);
                        } else {
                            ErrorCallBack(jsonString.getString("message"), apitype, typeApi);
                        }
                    } catch (Exception e5) {
                        e = e5;
                        ErrorCallBack(e.getMessage() + loggedInUserInfo + e.getLocalizedMessage(), apitype, typeApi);
                        e.printStackTrace();
                        return;
                    }
                    break;
                } catch (Exception e6) {
                    e = e6;
                    loggedInUserInfo = " : ";
                }
                break;
        }
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        apitype.hashCode();
        switch (apitype) {
            case "https://appapi.videocrypt.in/index.php/data_model/master_hit/get_cities":
            case "https://appapi.videocrypt.in/index.php/data_model/master_hit/student_category":
            case "https://appapi.videocrypt.in/index.php/data_model/master_hit/get_states":
            case "https://appapi.videocrypt.in/index.php/data_model/users/registration":
            case "https://appapi.videocrypt.in/index.php/data_model/master_hit/get_countries":
            case "https://appapi.videocrypt.in/index.php/data_model/users/get_my_profile":
            case "https://appapi.videocrypt.in/index.php/data_model/users/update_profile":
                Toast.makeText(getContext(), jsonstring, 0).show();
                break;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Caste /* 2131361806 */:
            case R.id.casteSpinner /* 2131362484 */:
            case R.id.downarrowCasteIV /* 2131363003 */:
                if (!Helper.isNetworkConnected(this.activity)) {
                    Helper.showInternetToast(this.activity);
                } else {
                    PopupMenu popupMenu = new PopupMenu(requireActivity(), this.Caste, 3);
                    this.casteList.clear();
                    this.casteList.add("General");
                    this.casteList.add("SC");
                    this.casteList.add("ST");
                    this.casteList.add("OBC");
                    this.casteList.add("Other");
                    Iterator<String> it = this.casteList.iterator();
                    while (it.hasNext()) {
                        popupMenu.getMenu().add(it.next());
                    }
                    this.clicktype1 = "2";
                    popupMenu.setOnMenuItemClickListener(this);
                    popupMenu.show();
                }
                break;
            case R.id.Gender /* 2131361833 */:
            case R.id.genderSpinner /* 2131363417 */:
            case R.id.tv_genderError /* 2131366088 */:
                if (!Helper.isNetworkConnected(this.activity)) {
                    Helper.showInternetToast(this.activity);
                } else {
                    PopupMenu popupMenu2 = new PopupMenu(requireActivity(), this.Gender, 3);
                    this.genderList.clear();
                    this.genderList.add("Male");
                    this.genderList.add("Female");
                    this.genderList.add("Other");
                    Iterator<String> it2 = this.genderList.iterator();
                    while (it2.hasNext()) {
                        popupMenu2.getMenu().add(it2.next());
                    }
                    this.clicktype1 = "1";
                    popupMenu2.setOnMenuItemClickListener(this);
                    popupMenu2.show();
                }
                break;
            case R.id.Language /* 2131361852 */:
            case R.id.downarrowLanguageIV /* 2131363014 */:
            case R.id.languageSpinner /* 2131363838 */:
                LanguagesData languagesData = this.languagesData;
                if (languagesData == null || languagesData.getData().size() == 0) {
                    Toast.makeText(this.activity, this.activity.getResources().getString(R.string.no_language_available), 0).show();
                } else {
                    this.clicktype = "1";
                    filterListLanguage("1", this.languagesData);
                }
                break;
            case R.id.State /* 2131361927 */:
            case R.id.downarrowIV /* 2131363006 */:
            case R.id.stateSpinner /* 2131365469 */:
                StatesCities statesCities = this.states;
                if (statesCities == null || statesCities.getData().size() == 0) {
                    Toast.makeText(this.activity, this.activity.getResources().getString(R.string.no_state_available), 0).show();
                } else {
                    this.clicktype = "1";
                    filterList("1", this.states);
                }
                break;
            case R.id.categorySpinnerLayout /* 2131362492 */:
                StatesCities statesCities2 = this.category;
                if (statesCities2 == null || statesCities2.getData() == null || this.category.getData().size() == 0) {
                    Toast.makeText(this.activity, this.activity.getResources().getString(R.string.no_data_found), 0).show();
                } else {
                    this.clicktype = "4";
                    filterList("4", this.category);
                }
                break;
            case R.id.city /* 2131362567 */:
            case R.id.districtSpinner /* 2131362954 */:
                if (!this.show_country.booleanValue()) {
                    StatesCities statesCities3 = this.cities;
                    if (statesCities3 == null || statesCities3.getData().size() == 0) {
                        Toast.makeText(this.activity, this.activity.getResources().getString(R.string.please_select_state_first), 0).show();
                    } else {
                        this.clicktype = "2";
                        filterList("2", this.cities);
                    }
                }
                break;
            case R.id.datePickerIV /* 2131362857 */:
            case R.id.dobRl /* 2131362968 */:
            case R.id.dobTV /* 2131362969 */:
            case R.id.dobTopRl /* 2131362971 */:
            case R.id.downArrowIV1 /* 2131363001 */:
                openDatePickerDialog(this.activity, this.dobEt, this.calendar);
                break;
            case R.id.expertRL /* 2131363266 */:
            case R.id.expertSpinner /* 2131363267 */:
                selectExpert();
                break;
        }
    }

    public void filterList(String searchType, StatesCities countryArrayList) {
        final Dialog dialog = new Dialog(this.activity);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
        dialog.setContentView(R.layout.state_city_dialog);
        dialog.setCancelable(true);
        this.etSearch = (EditText) dialog.findViewById(R.id.et_search);
        if (searchType.equalsIgnoreCase("1")) {
            this.etSearch.setHint(this.activity.getResources().getString(R.string.search_state));
        } else if (searchType.equalsIgnoreCase("2")) {
            this.etSearch.setHint(this.activity.getResources().getString(R.string.search_district));
        } else if (searchType.equalsIgnoreCase("3")) {
            this.etSearch.setHint(this.activity.getResources().getString(R.string.search_country));
        } else if (searchType.equalsIgnoreCase("4")) {
            this.etSearch.setHint(this.activity.getResources().getString(R.string.exam_preparation_for));
        }
        this.ivClearSearch = (ImageView) dialog.findViewById(R.id.iv_clear_search);
        TextView textView = (TextView) dialog.findViewById(R.id.tv_cancel);
        this.ivClearSearch.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.loginRevamp.Fragment.SignupFormNew$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$filterList$7(view);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.loginRevamp.Fragment.SignupFormNew$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.cancel();
            }
        });
        RecyclerView recyclerView = (RecyclerView) dialog.findViewById(R.id.search_recyclerview);
        this.searchRecyclerview = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.searchRecyclerview.setLayoutManager(new LinearLayoutManager(this.activity));
        StateCityAdapter stateCityAdapter = new StateCityAdapter(this.activity, countryArrayList.getData(), searchType, dialog);
        this.stateCityAdapter = stateCityAdapter;
        this.searchRecyclerview.setAdapter(stateCityAdapter);
        textWatcher(searchType);
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$filterList$7(View view) {
        this.etSearch.setText("");
    }

    public void filterListLanguage(String searchType, LanguagesData languagesData) {
        final Dialog dialog = new Dialog(this.activity);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
        dialog.setContentView(R.layout.item_language_dialog);
        dialog.setCancelable(true);
        EditText editText = (EditText) dialog.findViewById(R.id.et_search);
        this.etSearchLanguage = editText;
        editText.setHint(this.activity.getResources().getString(R.string.search_language));
        this.ivClearSearchLanguage = (ImageView) dialog.findViewById(R.id.iv_clear_search);
        TextView textView = (TextView) dialog.findViewById(R.id.tv_cancel);
        this.ivClearSearchLanguage.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.loginRevamp.Fragment.SignupFormNew$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$filterListLanguage$9(view);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.loginRevamp.Fragment.SignupFormNew$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.cancel();
            }
        });
        RecyclerView recyclerView = (RecyclerView) dialog.findViewById(R.id.search_recyclerview);
        this.languageRecyclerview = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.languageRecyclerview.setLayoutManager(new LinearLayoutManager(this.activity));
        LanguageAdapter languageAdapter = new LanguageAdapter(this.activity, languagesData.getData(), dialog);
        this.languageAdapter = languageAdapter;
        this.languageRecyclerview.setAdapter(languageAdapter);
        textWatcherLanguage(searchType);
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$filterListLanguage$9(View view) {
        this.etSearchLanguage.setText("");
    }

    public void selectExpert() {
        final Dialog dialog = new Dialog(this.activity);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
        dialog.setContentView(R.layout.teacher_student_dialog);
        dialog.setCancelable(true);
        dialog.show();
        final TextView textView = (TextView) dialog.findViewById(R.id.stuTv);
        final TextView textView2 = (TextView) dialog.findViewById(R.id.teachTv);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.loginRevamp.Fragment.SignupFormNew$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$selectExpert$11(textView, dialog, view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.loginRevamp.Fragment.SignupFormNew$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$selectExpert$12(textView2, dialog, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectExpert$11(TextView textView, Dialog dialog, View view) {
        this.expertSpinner.setText(textView.getText().toString());
        dialog.dismiss();
        Helper.enableErrorInTextview(this.tvExpertError, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectExpert$12(TextView textView, Dialog dialog, View view) {
        this.expertSpinner.setText(textView.getText().toString());
        dialog.dismiss();
        Helper.enableErrorInTextview(this.tvExpertError, null);
    }

    public void textWatcher(final String searchType) {
        this.etSearch.addTextChangedListener(new TextWatcher() { // from class: com.appnew.android.loginRevamp.Fragment.SignupFormNew.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    SignupFormNew.this.ivClearSearch.setVisibility(0);
                } else {
                    SignupFormNew.this.ivClearSearch.setVisibility(8);
                }
                SignupFormNew.this.filter(editable.toString(), searchType);
            }
        });
    }

    public void textWatcherLanguage(final String searchType) {
        this.etSearchLanguage.addTextChangedListener(new TextWatcher() { // from class: com.appnew.android.loginRevamp.Fragment.SignupFormNew.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    SignupFormNew.this.ivClearSearchLanguage.setVisibility(0);
                } else {
                    SignupFormNew.this.ivClearSearchLanguage.setVisibility(8);
                }
                SignupFormNew.this.filterLanguage(editable.toString(), searchType);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void filter(String text, String searchType) {
        this.statesCitiesArrayList.clear();
        if (searchType.equalsIgnoreCase("1")) {
            for (StatesCitiesData statesCitiesData : this.states.getData()) {
                if (statesCitiesData.getName().toLowerCase().contains(text.toLowerCase())) {
                    this.statesCitiesArrayList.add(statesCitiesData);
                }
            }
        } else if (searchType.equalsIgnoreCase("2")) {
            for (StatesCitiesData statesCitiesData2 : this.cities.getData()) {
                if (statesCitiesData2.getName().toLowerCase().contains(text.toLowerCase())) {
                    this.statesCitiesArrayList.add(statesCitiesData2);
                }
            }
        } else if (searchType.equalsIgnoreCase("3")) {
            for (StatesCitiesData statesCitiesData3 : this.countries.getData()) {
                if (statesCitiesData3.getName().toLowerCase().contains(text.toLowerCase())) {
                    this.statesCitiesArrayList.add(statesCitiesData3);
                }
            }
        } else if (searchType.equalsIgnoreCase("4")) {
            for (StatesCitiesData statesCitiesData4 : this.category.getData()) {
                if (statesCitiesData4.getName().toLowerCase().contains(text.toLowerCase())) {
                    this.statesCitiesArrayList.add(statesCitiesData4);
                }
            }
        }
        if (!this.statesCitiesArrayList.isEmpty()) {
            this.searchRecyclerview.setVisibility(0);
            this.stateCityAdapter.filterCountryList(this.statesCitiesArrayList);
        } else {
            this.searchRecyclerview.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void filterLanguage(String text, String searchType) {
        this.languages.clear();
        for (Languages languages : this.languagesData.getData()) {
            if (languages.getLanguage().toLowerCase().contains(text.toLowerCase())) {
                this.languages.add(languages);
            }
        }
        if (!this.languages.isEmpty()) {
            this.languageRecyclerview.setVisibility(0);
            this.languageAdapter.filterLanguageList(this.languages);
        } else {
            this.languageRecyclerview.setVisibility(4);
        }
    }

    public void onStateCityClick(String searchType, StatesCitiesData country) {
        if (this.countryTopRl.getVisibility() == 0) {
            if (searchType.equalsIgnoreCase("3")) {
                if (country.getName().equals(this.countryindex)) {
                    return;
                }
                for (StatesCitiesData statesCitiesData : this.countries.getData()) {
                    if (statesCitiesData.getName().equals(country.getName())) {
                        this.countryindex = country.getName();
                        this.SelectedCountryid = statesCitiesData.getId();
                        this.countrySpinner.setText(country.getName());
                        this.stateSpinner.setText(this.activity.getResources().getString(R.string.state));
                        this.districtSpinner.setText("");
                        this.districtSpinnerTV.setText(this.activity.getResources().getString(R.string.district));
                        hit_api_to_get_state();
                        Helper.enableErrorInTextview(this.tvCountryError, null);
                        return;
                    }
                }
                return;
            }
            if (searchType.equalsIgnoreCase("2")) {
                if (country.getName().equals(this.cityindex)) {
                    return;
                }
                for (StatesCitiesData statesCitiesData2 : this.cities.getData()) {
                    if (statesCitiesData2.getName().equals(country.getName())) {
                        this.cityindex = country.getName();
                        this.SelectedCityid = statesCitiesData2.getId();
                        this.districtSpinner.setText(country.getName());
                        this.districtSpinnerTV.setText(country.getName());
                        Helper.enableErrorInTextview(this.tvDistrictError, null);
                        return;
                    }
                }
                return;
            }
            if (!searchType.equalsIgnoreCase("1") || country.getName().equals(this.stateindex)) {
                return;
            }
            for (StatesCitiesData statesCitiesData3 : this.states.getData()) {
                if (statesCitiesData3.getName().equals(country.getName())) {
                    this.stateindex = country.getName();
                    this.SelectedStateid = statesCitiesData3.getId();
                    this.stateSpinner.setText(country.getName());
                    this.districtSpinner.setText("");
                    this.districtSpinnerTV.setText(this.activity.getResources().getString(R.string.district));
                    hit_api_to_get_city();
                    Helper.enableErrorInTextview(this.tvStateError, null);
                    return;
                }
            }
            return;
        }
        if (searchType.equalsIgnoreCase("1")) {
            if (country.getName().equals(this.stateindex)) {
                return;
            }
            for (StatesCitiesData statesCitiesData4 : this.states.getData()) {
                if (statesCitiesData4.getName().equals(country.getName())) {
                    this.stateindex = country.getName();
                    this.SelectedStateid = statesCitiesData4.getId();
                    this.stateSpinner.setText(country.getName());
                    this.districtSpinner.setText("");
                    this.districtSpinnerTV.setText(this.activity.getResources().getString(R.string.district));
                    Helper.enableErrorInTextview(this.tvStateError, null);
                    hit_api_to_get_city();
                    return;
                }
            }
            return;
        }
        if (!searchType.equalsIgnoreCase("2") || country.getName().equals(this.cityindex)) {
            return;
        }
        for (StatesCitiesData statesCitiesData5 : this.cities.getData()) {
            if (statesCitiesData5.getName().equals(country.getName())) {
                this.cityindex = country.getName();
                this.SelectedCityid = statesCitiesData5.getId();
                this.districtSpinner.setText(country.getName());
                this.districtSpinnerTV.setText(country.getName());
                Helper.enableErrorInTextview(this.tvDistrictError, null);
                return;
            }
        }
    }

    @Override // com.appnew.android.Utils.AmazonUpload.AmazonCallBack
    public void onS3UploadData(ArrayList<MediaFile> images) {
        if (images == null || images.isEmpty()) {
            return;
        }
        if (this.isProfilePic) {
            this.profilepic = images.get(0).getFile();
            Glide.with(this.activity).load(images.get(0).getFile()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.course_placeholder)).into(this.profileImage);
        } else {
            this.marksheetpic = images.get(0).getFile();
            Glide.with(this.activity).load(images.get(0).getFile()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.course_placeholder)).into(this.marksheetImage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCategoryClick(String searchType, StatesCitiesData country) {
        if (!searchType.equalsIgnoreCase("4") || country.getName().equals(this.categoryindex)) {
            return;
        }
        for (StatesCitiesData statesCitiesData : this.category.getData()) {
            if (statesCitiesData.getName().equals(country.getName())) {
                this.categoryindex = country.getName();
                this.SelectedCategoryid = statesCitiesData.getId();
                this.categorySpinner.setText(country.getName());
                Helper.enableErrorInTextview(this.tv_categoryError, null);
                return;
            }
        }
    }

    @Override // android.widget.PopupMenu.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        if (this.clicktype1.equalsIgnoreCase("1")) {
            for (String str : this.genderList) {
                if (str.equalsIgnoreCase(menuItem.getTitle().toString())) {
                    this.genderSpinner.setText(str);
                    str.hashCode();
                    switch (str) {
                        case "Male":
                            this.gender = "0";
                            break;
                        case "Other":
                            this.gender = "2";
                            break;
                        case "Female":
                            this.gender = "1";
                            break;
                    }
                }
            }
        }
        if (this.clicktype1.equalsIgnoreCase("2")) {
            for (String str2 : this.casteList) {
                if (str2.equalsIgnoreCase(menuItem.getTitle().toString())) {
                    this.casteSpinner.setText(str2);
                    str2.hashCode();
                    switch (str2) {
                        case "SC":
                            this.caste = "SC";
                            break;
                        case "ST":
                            this.caste = "ST";
                            break;
                        case "OBC":
                            this.caste = "OBC";
                            break;
                        case "Other":
                            this.caste = "Other";
                            break;
                        case "General":
                            this.caste = "GEN";
                            break;
                    }
                }
            }
        }
        return false;
    }

    public class StateCityAdapter extends RecyclerView.Adapter<MyViewHolder> {
        Context context;
        List<StatesCitiesData> countryArrayList;
        Dialog searchDialog;
        String searchType;

        public StateCityAdapter(Context context, List<StatesCitiesData> countryArrayList, String searchType, Dialog searchDialog) {
            this.context = context;
            this.countryArrayList = countryArrayList;
            this.searchType = searchType;
            this.searchDialog = searchDialog;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new MyViewHolder(LayoutInflater.from(this.context).inflate(R.layout.state_city_dialog_adapter_item, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(MyViewHolder myViewHolder, final int i) {
            final StatesCitiesData statesCitiesData = this.countryArrayList.get(i);
            myViewHolder.tvName.setText(statesCitiesData.getName());
            myViewHolder.tvName.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.loginRevamp.Fragment.SignupFormNew$StateCityAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(statesCitiesData, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(StatesCitiesData statesCitiesData, View view) {
            Dialog dialog = this.searchDialog;
            if (dialog != null) {
                dialog.dismiss();
            }
            String str = this.searchType;
            str.hashCode();
            switch (str) {
                case "1":
                    SignupFormNew.this.onStateCityClick(this.searchType, statesCitiesData);
                    break;
                case "2":
                    SignupFormNew.this.onStateCityClick(this.searchType, statesCitiesData);
                    break;
                case "3":
                    SignupFormNew.this.onStateCityClick(this.searchType, statesCitiesData);
                    break;
                case "4":
                    SignupFormNew.this.onCategoryClick(this.searchType, statesCitiesData);
                    break;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.countryArrayList.size();
        }

        public void filterCountryList(List<StatesCitiesData> newCountryArrayList) {
            this.countryArrayList = newCountryArrayList;
            notifyDataSetChanged();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tvName;

            public MyViewHolder(View itemView) {
                super(itemView);
                this.tvName = (TextView) itemView.findViewById(R.id.nameTv);
            }
        }
    }

    public class LanguageAdapter extends RecyclerView.Adapter<MyViewHolder> {
        Context context;
        Dialog languageDialog;
        List<Languages> languagesData;

        public LanguageAdapter(Context context, List<Languages> languagesData, Dialog languageDialog) {
            this.context = context;
            this.languagesData = languagesData;
            this.languageDialog = languageDialog;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(LayoutInflater.from(this.context).inflate(R.layout.state_city_dialog_adapter_item, parent, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(MyViewHolder holder, int position) {
            final Languages languages = this.languagesData.get(position);
            holder.tvName.setText(languages.getLanguage());
            holder.tvName.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.loginRevamp.Fragment.SignupFormNew$LanguageAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(languages, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(Languages languages, View view) {
            if (this.languageDialog.isShowing()) {
                this.languageDialog.dismiss();
            }
            SignupFormNew.this.languageSpinner.setText(languages.getLanguage());
            SignupFormNew.this.languageId = languages.getId();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.languagesData.size();
        }

        public void filterLanguageList(ArrayList<Languages> newLanguagesData) {
            this.languagesData = newLanguagesData;
            notifyDataSetChanged();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tvName;

            public MyViewHolder(View itemView) {
                super(itemView);
                this.tvName = (TextView) itemView.findViewById(R.id.nameTv);
            }
        }
    }

    private void pushEvent() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("date", AnalyticHelper.INSTANCE.getCurrentDateTimeForEvent());
        map.put("user_id", AnalyticHelper.INSTANCE.getUserId());
        map.put(AnalyticsConstants.device_type, AnalyticHelper.INSTANCE.getDeviceType());
        map.put("action_type", "Signup");
        AnalyticEvents.INSTANCE.pushEvents(this.activity, AnalyticsConstants.USER_LOGIN, map);
    }

    private void onButtonClick() {
        Helper.dismissProgressDialog();
        if (this.isSocial.equalsIgnoreCase("1") && this.socialType.equalsIgnoreCase("1")) {
            if (BuildConfig.FLAVOR.equalsIgnoreCase("NavinClasses")) {
                checkGoogleSignInValidationNavin();
                return;
            } else {
                checkGoogleSignInValidation();
                return;
            }
        }
        if (BuildConfig.FLAVOR.equalsIgnoreCase("NavinClasses")) {
            checkValidationNavin();
        } else {
            checkValidation();
        }
    }
}
