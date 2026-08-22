package com.appnew.android.Profile;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
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
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.BuildConfig;
import com.appnew.android.Cart.Activity.RewardActivity;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.DivisionModel.DivisionModel;
import com.appnew.android.Model.DivisionModel.SubDivision;
import com.appnew.android.Model.LeftMenu;
import com.appnew.android.Model.MediaFile;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.AmazonUpload.AmazonCallBack;
import com.appnew.android.Utils.AmazonUpload.s3ImageUploading;
import com.appnew.android.Utils.AppPermissionsRunTime;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.imagecropper.TakeImageClass;
import com.appnew.android.base.ChangeLanguageActivity;
import com.appnew.android.pojo.Userinfo.Data;
import com.appnew.android.pojo.Userinfo.Languages;
import com.appnew.android.pojo.Userinfo.LanguagesData;
import com.appnew.android.pojo.Userinfo.StatesCities.StatesCities;
import com.appnew.android.pojo.Userinfo.StatesCities.StatesCitiesData;
import com.appnew.android.table.ThemeSettings;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.canhub.cropper.CropImageContract;
import com.canhub.cropper.CropImageContractOptions;
import com.canhub.cropper.CropImageView;
import com.eduteria.app.app.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.hbb20.CountryCodePicker;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.tv9news.utils.helpers.AnalyticEvents;
import de.hdodenhof.circleimageview.CircleImageView;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class ProfileActivity extends AppCompatActivity implements AmazonCallBack, TakeImageClass.imagefromcropper, NetworkCall.MyNetworkCallBack, View.OnClickListener, PopupMenu.OnMenuItemClickListener {
    RelativeLayout Caste;
    RelativeLayout City;
    RelativeLayout Gender;
    RelativeLayout Language;
    RelativeLayout State;
    EditText addressTV;
    EditText alternateNumberTV;
    BottomSheetDialog bottomSheetDialog;
    String caste;
    List<String> casteList;
    TextView casteSpinner;
    RelativeLayout caste_rl;
    private boolean changeContact;
    private LinearLayoutCompat changeLanguage;
    TextView changeNumber;
    TextView change_pass;
    StatesCities cities;
    String clicktype1;
    private boolean country;
    CountryCodePicker cpp;
    private ActivityResultLauncher<CropImageContractOptions> cropImage;
    Data data;
    TextView districtSpinner;
    ImageView downarrowCasteIV;
    ImageView downarrowGenderIV;
    ImageView downarrowIV;
    ImageView downarrowIV2;
    ImageView downarrowLanguageIV;
    private ImageView downarrowstudent_catType;
    private ImageView downarrowstudent_class;
    EditText emailTV;
    EditText etSearch;
    EditText etSearchLanguage;
    EditText et_phone;
    EditText etdistrictSpinner;
    EditText expertTV;
    EditText fatherNameTV;
    RelativeLayout father_rl;
    RelativeLayout flagCountryLL;
    RelativeLayout flagRL;
    String gender;
    List<String> genderList;
    TextView genderSpinner;
    RelativeLayout gender_rl;
    EditText govId;
    private boolean governmenetId;
    EditText gstnTV;
    ImageView image_back;
    ImageView imagelanguage;
    private boolean isAddressShow;
    private boolean isAlternateNumberShow;
    private boolean isCasteShow;
    Boolean isExpert;
    private boolean isFatherNameShow;
    private boolean isGSTIN;
    private boolean isGenderShow;
    private boolean isLanguageShow;
    private boolean isPhotoUpload;
    private boolean isPinCodeShow;
    Boolean isProfileTeacher;
    private boolean isShowState;
    private boolean isShowStudentClass;
    private boolean isTenthMarksheetUpload;
    ImageView ivClearSearch;
    ImageView ivClearSearchLanguage;
    LanguageAdapter languageAdapter;
    CardView languageCard;
    String languageId;
    RecyclerView languageRecyclerview;
    TextView languageSpinner;
    ArrayList<Languages> languages;
    LanguagesData languagesData;
    LeftMenu leftMenu;
    CircleImageView marksheetImage;
    private RelativeLayout mentorLay;
    String mobileNumber;
    RelativeLayout mobileNumberRL;
    public ArrayList<AppPermissionsRunTime.MyPermissionConstants> myPermissionConstantsArrayList;
    EditText nameMentorProfile;
    EditText nameTV;
    NetworkCall networkCall;
    String otp;
    RelativeLayout password_relative;
    EditText pincodeTV;
    List<String> presentCategory;
    List<String> presentClass;
    CircleImageView profileImage;
    TextView profileRating_text;
    RelativeLayout relativeGovtID;
    RelativeLayout relativeRollNo;
    CardView rewardCart;
    RelativeLayout rlGSTIN;
    private RelativeLayout rl_student_catType;
    private RelativeLayout rl_student_class;
    EditText rollNoET;
    private boolean rollNumber;
    private s3ImageUploading s3IU;
    RecyclerView searchRecyclerview;
    private String selectedDivisionName;
    ActivityResultLauncher<Intent> someActivityResultLauncher;
    StateCityAdapter stateCityAdapter;
    TextView stateSpinner;
    StatesCities states;
    ArrayList<StatesCitiesData> statesCitiesArrayList;
    private TextView student_catType_Spinner;
    private TextView student_class_Spinner;
    Button submit;
    ThemeSettings themeSettings;
    private TextView tv_student_catType_Error;
    private TextView tv_student_class_Error;
    RelativeLayout uploadImg;
    RelativeLayout uploadTenth;
    UtkashRoom utkashRoom;
    String str_imgTypeClick = "";
    public final int REQUEST_CODE_PERMISSION_MULTIPLE = 123;
    private int requestCode = -1;
    String clicktype = "";
    String stateindex = "";
    String cityindex = "";
    String SelectedStateid = "";
    String SelectedCityid = "";
    String profilepic = "";
    String marksheetPic = "";
    String firsttime = "1";
    boolean verify = false;

    @Override // com.appnew.android.Utils.imagecropper.TakeImageClass.imagefromcropper
    public void imagePath(String str) {
    }

    public ProfileActivity() {
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        this.utkashRoom = appDatabase;
        this.themeSettings = appDatabase.getthemeSettingdao().data();
        this.country = false;
        this.isShowState = true;
        this.isGSTIN = false;
        this.isExpert = false;
        this.isProfileTeacher = false;
        this.isShowStudentClass = false;
        this.isGenderShow = false;
        this.isCasteShow = false;
        this.isAddressShow = false;
        this.isFatherNameShow = false;
        this.isAlternateNumberShow = false;
        this.isPhotoUpload = false;
        this.isTenthMarksheetUpload = true;
        this.isPinCodeShow = true;
        this.isLanguageShow = true;
        this.changeContact = true;
        this.governmenetId = false;
        this.rollNumber = false;
        this.presentClass = new ArrayList();
        this.presentCategory = new ArrayList();
        this.cropImage = registerForActivityResult(new CropImageContract(), new ActivityResultCallback() { // from class: com.appnew.android.Profile.ProfileActivity$$ExternalSyntheticLambda1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                this.f$0.lambda$new$11((CropImageView.CropResult) obj);
            }
        });
        this.someActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.Profile.ProfileActivity$$ExternalSyntheticLambda2
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                this.f$0.lambda$new$12((ActivityResult) obj);
            }
        });
        this.genderList = new ArrayList();
        this.casteList = new ArrayList();
        this.clicktype1 = "";
        this.statesCitiesArrayList = new ArrayList<>();
        this.languages = new ArrayList<>();
        this.languageId = "";
        this.gender = "";
        this.caste = "";
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.activity_profile);
        this.networkCall = new NetworkCall(this, this);
        hit_api_to_get_language();
        setViewIds();
        setClickListeners();
        if (this.utkashRoom.getthemeSettingdao().is_setting_exit()) {
            ThemeSettings themeSettingsData = this.utkashRoom.getthemeSettingdao().data();
            if (themeSettingsData.getLeft_menu() != null) {
                this.leftMenu = (LeftMenu) new Gson().fromJson(themeSettingsData.getLeft_menu(), LeftMenu.class);
            }
        }
        this.data = SharedPreference.getInstance().getLoggedInUser();
        this.isExpert = Boolean.valueOf(Helper.checkProfilePermission(Const.IS_EXPERT));
        this.isProfileTeacher = Boolean.valueOf(Helper.checkProfilePermission(Const.PROFILE_TEACHER));
        this.isShowStudentClass = Helper.checkProfilePermission(Const.SHOW_STUDENT_CLASS);
        this.isGSTIN = Helper.checkProfilePermission(Const.IS_GSTIN);
        this.isGenderShow = Helper.checkProfilePermission(Const.GENDER_SHOW);
        this.isCasteShow = Helper.checkProfilePermission(Const.CASTE_SHOW);
        this.isFatherNameShow = Helper.checkProfilePermission(Const.FATHER_SHOW);
        this.isAddressShow = Helper.checkProfilePermission(Const.ADDRESS_SHOW);
        this.isAlternateNumberShow = Helper.checkProfilePermission(Const.ALTERNATE_SHOW);
        this.isPhotoUpload = true;
        this.isTenthMarksheetUpload = Helper.checkProfilePermission(Const.MARKSHEET_SHOW);
        this.isPinCodeShow = Helper.checkProfilePermission(Const.PIN_CODE_SHOW);
        this.isLanguageShow = Helper.checkProfilePermission(Const.LANG_SHOW);
        this.changeContact = Helper.checkProfilePermission(Const.CHANGE_CONTACT);
        this.governmenetId = Helper.checkProfilePermission(Const.GOVERNMENET_ID);
        this.rollNumber = Helper.checkProfilePermission(Const.SHOW_ROLL_NUMBER);
        this.country = Helper.checkProfilePermission(Const.COUNTRY_SHOW);
        this.isShowState = true;
        this.uploadTenth.setVisibility(this.isTenthMarksheetUpload ? 0 : 8);
        this.uploadImg.setVisibility(this.isPhotoUpload ? 0 : 8);
        this.relativeRollNo.setVisibility(this.rollNumber ? 0 : 8);
        this.relativeGovtID.setVisibility(this.governmenetId ? 0 : 8);
        this.changeNumber.setVisibility(this.changeContact ? 0 : 8);
        this.gender_rl.setVisibility(this.isGenderShow ? 0 : 8);
        this.father_rl.setVisibility(this.isFatherNameShow ? 0 : 8);
        this.caste_rl.setVisibility(this.isCasteShow ? 0 : 8);
        this.alternateNumberTV.setVisibility(this.isAlternateNumberShow ? 0 : 8);
        this.addressTV.setVisibility(this.isAddressShow ? 0 : 8);
        this.Language.setVisibility(this.isLanguageShow ? 0 : 8);
        this.pincodeTV.setVisibility(this.isPinCodeShow ? 0 : 8);
        this.rlGSTIN.setVisibility(this.isGSTIN ? 0 : 8);
        if (this.isShowState) {
            this.State.setVisibility(0);
            this.City.setVisibility(0);
        } else {
            this.State.setVisibility(8);
            this.City.setVisibility(8);
        }
        classDivision();
        checkExpert();
        if (this.leftMenu != null) {
            LeftMenu leftMenu = (LeftMenu) new Gson().fromJson(this.themeSettings.getLeft_menu(), LeftMenu.class);
            this.leftMenu = leftMenu;
            if (leftMenu.getReward().equalsIgnoreCase("1")) {
                this.rewardCart.setVisibility(0);
            }
        }
        if (this.country) {
            this.districtSpinner.setVisibility(8);
            this.downarrowIV2.setVisibility(4);
            this.etdistrictSpinner.setVisibility(0);
            this.flagRL.setVisibility(8);
            this.flagCountryLL.setVisibility(0);
            this.cpp.setCcpClickable(false);
            if (!TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.C_NAME_CODE))) {
                this.cpp.setCountryForNameCode(SharedPreference.getInstance().getString(Const.C_NAME_CODE));
            } else {
                this.cpp.setCountryForPhoneCode(Helper.converToIntCountryCode(this.data.getCCode()));
            }
        } else {
            this.districtSpinner.setVisibility(0);
            this.downarrowIV2.setVisibility(0);
            this.etdistrictSpinner.setVisibility(8);
            this.flagRL.setVisibility(0);
            this.flagCountryLL.setVisibility(8);
        }
        LeftMenu leftMenu2 = this.leftMenu;
        if (leftMenu2 != null) {
            if (leftMenu2.getDisable_name_edit().equalsIgnoreCase("0") || this.leftMenu.getDisable_name_edit().equalsIgnoreCase("")) {
                this.nameTV.setEnabled(true);
            } else {
                this.nameTV.setEnabled(false);
            }
        }
        if (!TextUtils.isEmpty(this.data.getRoll_no())) {
            this.rollNoET.setText(this.data.getRoll_no());
        }
        if (!TextUtils.isEmpty(this.data.getName())) {
            this.nameTV.setText(this.data.getName());
        }
        if (!TextUtils.isEmpty(this.data.getRegistration_id())) {
            this.govId.setText(this.data.getRegistration_id());
        }
        if (!TextUtils.isEmpty(this.data.getEmail())) {
            this.emailTV.setText(this.data.getEmail());
        }
        if (!TextUtils.isEmpty(this.data.getGstin())) {
            this.gstnTV.setText(this.data.getGstin());
        }
        if (!TextUtils.isEmpty(this.data.getAlternate_number())) {
            this.alternateNumberTV.setText(this.data.getAlternate_number());
        }
        if (!TextUtils.isEmpty(this.data.getFather_name())) {
            this.fatherNameTV.setText(this.data.getFather_name());
        }
        if (!TextUtils.isEmpty(this.data.getPin_code())) {
            this.pincodeTV.setText(this.data.getPin_code());
        }
        if (!TextUtils.isEmpty(this.data.getAddress())) {
            this.addressTV.setText(this.data.getAddress());
        }
        if (!TextUtils.isEmpty(this.data.getMobile())) {
            this.et_phone.setText(this.data.getMobile());
        }
        if (this.isShowStudentClass) {
            if (this.data.getDivision() != null && this.rl_student_catType.getVisibility() == 0) {
                this.student_catType_Spinner.setText(!TextUtils.isEmpty(this.data.getDivision()) ? this.data.getDivision() : "N/A");
            }
            if (this.data.getStudent_class() != null) {
                this.student_class_Spinner.setText(TextUtils.isEmpty(this.data.getStudent_class()) ? "N/A" : this.data.getStudent_class());
            }
        }
        if (this.isProfileTeacher.booleanValue()) {
            this.nameMentorProfile.setEnabled(false);
            if (this.data.getUser_mentor() != null && !this.data.getUser_mentor().isEmpty()) {
                this.nameMentorProfile.setText(this.data.getUser_mentor());
                this.mentorLay.setVisibility(0);
            }
        }
        if (this.data.getGender() != null) {
            String gender = this.data.getGender();
            gender.hashCode();
            switch (gender) {
                case "0":
                    this.genderSpinner.setText("Male");
                    this.gender = "0";
                    break;
                case "1":
                    this.genderSpinner.setText("Female");
                    this.gender = "1";
                    break;
                case "2":
                    this.genderSpinner.setText("Other");
                    this.gender = "2";
                    break;
            }
        }
        if (this.data.getCaste_category() != null) {
            String caste_category = this.data.getCaste_category();
            caste_category.hashCode();
            switch (caste_category) {
                case "SC":
                    this.casteSpinner.setText("SC");
                    this.caste = "SC";
                    break;
                case "ST":
                    this.casteSpinner.setText("ST");
                    this.caste = "ST";
                    break;
                case "GEN":
                    this.casteSpinner.setText("General");
                    this.caste = "GEN";
                    break;
                case "OBC":
                    this.casteSpinner.setText("OBC");
                    this.caste = "OBC";
                    break;
                case "Other":
                    this.casteSpinner.setText("Other");
                    this.caste = "Other";
                    break;
            }
        }
        mobileNumberVerification();
        hit_api_to_get_state();
        if (!TextUtils.isEmpty(this.data.getState())) {
            this.stateSpinner.setText(this.data.getState());
        }
        if (!TextUtils.isEmpty(this.data.getCity())) {
            this.districtSpinner.setText(this.data.getCity());
            this.etdistrictSpinner.setText(this.data.getCity());
        }
        if (!TextUtils.isEmpty(this.data.getProfilePicture())) {
            this.profilepic = this.data.getProfilePicture();
            Glide.with((FragmentActivity) this).load(this.profilepic).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.course_placeholder)).into(this.profileImage);
        }
        if (this.data.getProof_marksheet() != null) {
            this.marksheetPic = this.data.getProof_marksheet();
            Glide.with((FragmentActivity) this).load(this.marksheetPic).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.course_placeholder)).into(this.marksheetImage);
        }
        this.submit.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Profile.ProfileActivity$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$0();
            }
        }));
        this.rewardCart.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Profile.ProfileActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.image_back.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Profile.ProfileActivity$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$2();
            }
        }));
        this.uploadImg.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Profile.ProfileActivity$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$3();
            }
        }));
        this.change_pass.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Profile.ProfileActivity$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$4();
            }
        }));
        this.changeNumber.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Profile.ProfileActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, Helper.setLoginCatActivity());
                intent.putExtra(Const.FRAG_TYPE, Const.FORGETPASSWORD);
                intent.putExtra(Const.RESET_PASS, false);
                intent.putExtra(Const.IS_CHANGE_PASS, false);
                Helper.gotoActivity(intent, ProfileActivity.this);
            }
        });
        manageLeadingSpaces();
        this.et_phone.setFilters(new InputFilter[]{new InputFilter.LengthFilter(15), new DigitsKeyListener(false, true)});
        if (Helper.checkProfilePermission(Const.OTP_LOGIN)) {
            this.password_relative.setVisibility(8);
            this.emailTV.setEnabled(true);
        } else {
            if (getIntent().getExtras() != null && getIntent().getExtras().getBoolean("hide_password")) {
                this.password_relative.setVisibility(8);
            } else {
                this.password_relative.setVisibility(0);
            }
            if (getIntent().getExtras() != null && getIntent().getExtras().getBoolean("email_enable")) {
                this.emailTV.setEnabled(true);
            } else {
                this.emailTV.setEnabled(false);
            }
        }
        this.et_phone.setEnabled(false);
        EditText editText = this.emailTV;
        if (editText != null && editText.getVisibility() == 0 && TextUtils.isEmpty(this.emailTV.getText().toString().trim())) {
            this.emailTV.setEnabled(true);
        } else {
            this.emailTV.setEnabled(false);
        }
        EditText editText2 = this.et_phone;
        if (editText2 != null && editText2.getVisibility() == 0 && TextUtils.isEmpty(this.et_phone.getText().toString().trim())) {
            this.et_phone.setEnabled(true);
        } else {
            this.et_phone.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$0() {
        if (this.isExpert.booleanValue()) {
            checkExpertValidation();
            return null;
        }
        checkvalidation();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        startActivity(new Intent(getApplicationContext(), (Class<?>) RewardActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$2() {
        finish();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$3() {
        checkStoragePermission();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$4() {
        Intent intent = new Intent(this, Helper.setLoginCatActivity());
        intent.putExtra(Const.FRAG_TYPE, Const.FORGETPASSWORD);
        intent.putExtra(Const.RESET_PASS, true);
        intent.putExtra(Const.IS_CHANGE_PASS, true);
        startActivity(intent);
        return null;
    }

    private void manageLeadingSpaces() {
        Helper.preventLeadingSpaces(this.govId);
        Helper.preventLeadingSpaces(this.rollNoET);
        Helper.preventLeadingSpaces(this.nameTV);
        Helper.preventLeadingSpaces(this.fatherNameTV);
        Helper.preventLeadingSpaces(this.emailTV);
        Helper.preventLeadingSpaces(this.expertTV);
        Helper.preventLeadingSpaces(this.et_phone);
        Helper.preventLeadingSpaces(this.alternateNumberTV);
        Helper.preventLeadingSpaces(this.nameMentorProfile);
        Helper.preventLeadingSpaces(this.etdistrictSpinner);
        Helper.preventLeadingSpaces(this.addressTV);
        Helper.preventLeadingSpaces(this.pincodeTV);
        Helper.preventLeadingSpaces(this.gstnTV);
    }

    private void classDivision() {
        if (this.isShowStudentClass && !getDivisionList().isEmpty()) {
            this.rl_student_class.setVisibility(0);
            toggleViewVisibility(this.rl_student_catType);
            this.student_class_Spinner.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Profile.ProfileActivity$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$classDivision$5(view);
                }
            });
            this.downarrowstudent_class.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Profile.ProfileActivity$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$classDivision$6(view);
                }
            });
            this.rl_student_class.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Profile.ProfileActivity$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$classDivision$7(view);
                }
            });
            this.rl_student_catType.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Profile.ProfileActivity$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$classDivision$8(view);
                }
            });
            this.student_catType_Spinner.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Profile.ProfileActivity$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$classDivision$9(view);
                }
            });
            return;
        }
        this.rl_student_class.setVisibility(8);
        this.rl_student_catType.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$classDivision$5(View view) {
        selectPresentClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$classDivision$6(View view) {
        selectPresentClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$classDivision$7(View view) {
        selectPresentClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$classDivision$8(View view) {
        selectPresentCatType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$classDivision$9(View view) {
        selectPresentCatType();
    }

    private void setClickListeners() {
        this.State.setOnClickListener(this);
        this.City.setOnClickListener(this);
        this.stateSpinner.setOnClickListener(this);
        this.districtSpinner.setOnClickListener(this);
        this.Caste.setOnClickListener(this);
        this.casteSpinner.setOnClickListener(this);
        this.downarrowCasteIV.setOnClickListener(this);
        this.Gender.setOnClickListener(this);
        this.genderSpinner.setOnClickListener(this);
        this.downarrowGenderIV.setOnClickListener(this);
        this.Language.setOnClickListener(this);
        this.languageSpinner.setOnClickListener(this);
        this.downarrowLanguageIV.setOnClickListener(this);
        this.imagelanguage.setOnClickListener(this);
        this.changeLanguage.setOnClickListener(this);
    }

    private void setViewIds() {
        this.relativeGovtID = (RelativeLayout) findViewById(R.id.relativeGovtID);
        this.relativeRollNo = (RelativeLayout) findViewById(R.id.relativeRollNo);
        this.rollNoET = (EditText) findViewById(R.id.rollNoET);
        this.changeNumber = (TextView) findViewById(R.id.changeNumber);
        this.nameTV = (EditText) findViewById(R.id.nameTV);
        this.govId = (EditText) findViewById(R.id.govId);
        this.uploadTenth = (RelativeLayout) findViewById(R.id.uploadTenth);
        this.father_rl = (RelativeLayout) findViewById(R.id.father_rl);
        this.caste_rl = (RelativeLayout) findViewById(R.id.caste_rl);
        this.gender_rl = (RelativeLayout) findViewById(R.id.gender_rl);
        this.Language = (RelativeLayout) findViewById(R.id.Language);
        this.pincodeTV = (EditText) findViewById(R.id.pincodeTV);
        this.marksheetImage = (CircleImageView) findViewById(R.id.marksheetImage);
        this.fatherNameTV = (EditText) findViewById(R.id.fatherNameTV);
        this.casteSpinner = (TextView) findViewById(R.id.casteSpinner);
        this.genderSpinner = (TextView) findViewById(R.id.genderSpinner);
        this.languageSpinner = (TextView) findViewById(R.id.languageSpinner);
        this.downarrowCasteIV = (ImageView) findViewById(R.id.downarrowCasteIV);
        this.downarrowGenderIV = (ImageView) findViewById(R.id.downarrowGenderIV);
        this.downarrowLanguageIV = (ImageView) findViewById(R.id.downarrowLanguageIV);
        this.imagelanguage = (ImageView) findViewById(R.id.imagelanguage);
        this.alternateNumberTV = (EditText) findViewById(R.id.alternateNumberTV);
        this.addressTV = (EditText) findViewById(R.id.addressTV);
        this.emailTV = (EditText) findViewById(R.id.emailTV);
        this.expertTV = (EditText) findViewById(R.id.expertTV);
        this.et_phone = (EditText) findViewById(R.id.et_phone);
        this.mobileNumberRL = (RelativeLayout) findViewById(R.id.mobileNumberRL);
        this.stateSpinner = (TextView) findViewById(R.id.stateSpinner);
        this.change_pass = (TextView) findViewById(R.id.change_pass);
        this.districtSpinner = (TextView) findViewById(R.id.districtSpinner);
        this.etdistrictSpinner = (EditText) findViewById(R.id.etdistrictSpinner);
        this.profileImage = (CircleImageView) findViewById(R.id.profileImage);
        this.uploadImg = (RelativeLayout) findViewById(R.id.uploadImg);
        this.changeLanguage = (LinearLayoutCompat) findViewById(R.id.changeLanguage);
        this.Gender = (RelativeLayout) findViewById(R.id.Gender);
        this.Caste = (RelativeLayout) findViewById(R.id.Caste);
        this.profileRating_text = (TextView) findViewById(R.id.profileRating_text);
        this.image_back = (ImageView) findViewById(R.id.image_back);
        this.downarrowIV = (ImageView) findViewById(R.id.downarrowIV);
        this.downarrowIV2 = (ImageView) findViewById(R.id.downarrowIV2);
        this.submit = (Button) findViewById(R.id.submit);
        this.City = (RelativeLayout) findViewById(R.id.city);
        this.password_relative = (RelativeLayout) findViewById(R.id.password_relative);
        this.State = (RelativeLayout) findViewById(R.id.State);
        this.flagRL = (RelativeLayout) findViewById(R.id.flagRL);
        this.flagCountryLL = (RelativeLayout) findViewById(R.id.flagCountryLL);
        this.cpp = (CountryCodePicker) findViewById(R.id.countryDropDown);
        this.rewardCart = (CardView) findViewById(R.id.rewardCart);
        this.rlGSTIN = (RelativeLayout) findViewById(R.id.rlGSTIN);
        this.gstnTV = (EditText) findViewById(R.id.gstnTV);
        this.languageCard = (CardView) findViewById(R.id.languageCard);
        this.rl_student_class = (RelativeLayout) findViewById(R.id.rl_student_class);
        this.student_class_Spinner = (TextView) findViewById(R.id.student_class_Spinner);
        this.downarrowstudent_class = (ImageView) findViewById(R.id.downarrowstudent_class);
        this.tv_student_class_Error = (TextView) findViewById(R.id.tv_student_class_Error);
        this.rl_student_catType = (RelativeLayout) findViewById(R.id.rl_student_catType);
        this.student_catType_Spinner = (TextView) findViewById(R.id.student_catType_Spinner);
        this.downarrowstudent_catType = (ImageView) findViewById(R.id.downarrowstudent_catType);
        this.tv_student_catType_Error = (TextView) findViewById(R.id.tv_student_catType_Error);
        this.mentorLay = (RelativeLayout) findViewById(R.id.mentorLay);
        this.nameMentorProfile = (EditText) findViewById(R.id.nameMentorProfile);
        View viewFindViewById = findViewById(R.id.root);
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        if (Build.VERSION.SDK_INT == 36) {
            EdgeToEdgeHelperOld.applyHeaderWithToolbar(this, getWindow(), viewFindViewById, toolbar);
        }
    }

    private void mobileNumberVerification() {
        if (getIntent().getExtras() == null || !getIntent().getExtras().getBoolean("mobile_enable")) {
            return;
        }
        this.mobileNumberRL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Profile.ProfileActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ProfileActivity.this.bottomSheetDialog = new BottomSheetDialog(ProfileActivity.this, R.style.DialogStyle);
                View viewInflate = LayoutInflater.from(ProfileActivity.this.getApplicationContext()).inflate(R.layout.bottom_sheet_mobile_verification, (ViewGroup) null);
                ProfileActivity.this.bottomSheetDialog.setCancelable(false);
                ImageView imageView = (ImageView) viewInflate.findViewById(R.id.cancelDialog);
                CardView cardView = (CardView) viewInflate.findViewById(R.id.submitNumber);
                CardView cardView2 = (CardView) viewInflate.findViewById(R.id.clearNumber);
                final EditText editText = (EditText) viewInflate.findViewById(R.id.mobileNumberEditText);
                cardView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Profile.ProfileActivity.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v2) {
                        boolean zDataNotValid;
                        boolean z = true;
                        if (ProfileActivity.this.verify) {
                            try {
                                ProfileActivity.this.otp = editText.getText().toString().trim();
                                if (ProfileActivity.this.otp != null && !ProfileActivity.this.otp.equalsIgnoreCase("")) {
                                    if (Integer.parseInt(ProfileActivity.this.otp) > 3 && Integer.parseInt(ProfileActivity.this.otp) < 7) {
                                        ProfileActivity.this.bottomSheetDialog.dismiss();
                                    }
                                } else {
                                    editText.setHint("Enter Your OTP");
                                    Toast.makeText(ProfileActivity.this, "Please enter valid OTP", 0).show();
                                    z = false;
                                }
                            } catch (Exception e2) {
                                Log.e("Otp Error", e2.getMessage());
                            }
                        } else {
                            try {
                                ProfileActivity.this.mobileNumber = editText.getText().toString().trim();
                                if (TextUtils.isDigitsOnly(ProfileActivity.this.mobileNumber)) {
                                    if (!ProfileActivity.this.country && TextUtils.isEmpty(ProfileActivity.this.mobileNumber)) {
                                        zDataNotValid = Helper.DataNotValid(editText, ProfileActivity.this);
                                    } else if (!ProfileActivity.this.country && (!Patterns.PHONE.matcher(ProfileActivity.this.mobileNumber).matches() || ProfileActivity.this.mobileNumber.length() != 10)) {
                                        zDataNotValid = Helper.DataNotValid(editText, 2, ProfileActivity.this);
                                    } else if (!ProfileActivity.this.country && Helper.isInValidIndianMobile(ProfileActivity.this.mobileNumber)) {
                                        zDataNotValid = Helper.DataNotValid(editText, 2, ProfileActivity.this);
                                    } else if (ProfileActivity.this.country && !ProfileActivity.this.cpp.isValidFullNumber()) {
                                        zDataNotValid = Helper.DataNotValid(editText, 2, ProfileActivity.this);
                                    }
                                    z = zDataNotValid;
                                }
                            } catch (Exception e3) {
                                Log.e("Mobile Error", e3.getMessage());
                            }
                        }
                        if (z) {
                            ProfileActivity.this.networkCall.NetworkAPICall(API.API_SEND_OTP_VERIFICATION, "", false, false);
                            editText.setHint("Enter Your OTP");
                            Helper.setTextLimit(editText, 6);
                            editText.setText("");
                        }
                    }
                });
                cardView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Profile.ProfileActivity.2.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v2) {
                        editText.setText("");
                    }
                });
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Profile.ProfileActivity.2.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v2) {
                        ProfileActivity.this.verify = false;
                        ProfileActivity.this.bottomSheetDialog.dismiss();
                    }
                });
                ProfileActivity.this.bottomSheetDialog.setContentView(viewInflate);
                ProfileActivity.this.bottomSheetDialog.show();
            }
        });
    }

    private void checkExpert() {
        if (this.isExpert.booleanValue()) {
            this.State.setVisibility(8);
            this.City.setVisibility(8);
            this.password_relative.setVisibility(8);
            this.rlGSTIN.setVisibility(8);
            if (BuildConfig.FLAVOR.equalsIgnoreCase("Narayana")) {
                this.profileRating_text.setVisibility(8);
                this.emailTV.setVisibility(0);
                this.expertTV.setVisibility(8);
            } else {
                this.expertTV.setVisibility(0);
                this.profileRating_text.setVisibility(0);
                this.emailTV.setVisibility(8);
            }
        }
    }

    private void checkExpertValidation() {
        if (!Helper.isStringValid(this.nameTV.getText().toString().trim())) {
            Toast.makeText(this, getResources().getString(R.string.name_is_not_valid), 0).show();
        } else {
            hit_api_to_update_profile();
        }
    }

    private void checkvalidation() {
        if (!Helper.isStringValid(this.nameTV.getText().toString().trim())) {
            Toast.makeText(this, getResources().getString(R.string.name_is_not_valid), 0).show();
            return;
        }
        if (getIntent().getExtras() != null && getIntent().getExtras().getBoolean("mentor_enable") && !Helper.isStringValid(this.nameMentorProfile.getText().toString().trim())) {
            Toast.makeText(this, getResources().getString(R.string.mentor_field_is_required), 0).show();
            return;
        }
        if (!Helper.isStringValid(this.emailTV.getText().toString().trim())) {
            Toast.makeText(this, getResources().getString(R.string.email_is_not_valid), 0).show();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(this.emailTV.getText().toString().trim()).matches()) {
            Toast.makeText(this, getResources().getString(R.string.email_is_not_valid), 0).show();
            return;
        }
        if (getIntent().getExtras() != null && getIntent().getExtras().getBoolean("mobile_enable") && !Helper.checkMobileNumber(this.et_phone.getText().toString().trim())) {
            Toast.makeText(this, getResources().getString(R.string.please_enter_valid_mobile_number), 0).show();
            return;
        }
        EditText editText = this.et_phone;
        if (editText != null && !TextUtils.isEmpty(editText.getText().toString()) && !Helper.checkMobileNumber(this.et_phone.getText().toString().trim())) {
            Toast.makeText(this, getResources().getString(R.string.please_enter_valid_mobile_number), 0).show();
            return;
        }
        if (this.isShowState && !Helper.isStringValid(this.stateSpinner.getText().toString())) {
            Toast.makeText(this, getResources().getString(R.string.please_select_state), 0).show();
            return;
        }
        String string = (this.districtSpinner.getVisibility() == 0 ? this.districtSpinner.getText() : this.etdistrictSpinner.getText()).toString();
        if (this.isShowState && (!Helper.isStringValid(string) || string.equalsIgnoreCase(getResources().getString(R.string.district)))) {
            if (this.etdistrictSpinner.getVisibility() == 0) {
                Toast.makeText(this, getResources().getString(R.string.please_enter_district), 0).show();
                return;
            } else {
                Toast.makeText(this, getResources().getString(R.string.please_select_district), 0).show();
                return;
            }
        }
        if (this.isGSTIN && !TextUtils.isEmpty(this.gstnTV.getText().toString()) && !Helper.isValidGSTNo(this.gstnTV.getText().toString())) {
            Toast.makeText(this, getResources().getString(R.string.please_add_valid_gstin), 0).show();
            return;
        }
        if (this.isShowStudentClass) {
            if (this.rl_student_catType.getVisibility() == 0 && TextUtils.isEmpty(this.student_catType_Spinner.getText().toString().trim())) {
                Helper.enableErrorInTextview(this.tv_student_catType_Error, "Please select Division");
                return;
            } else if (TextUtils.isEmpty(this.student_class_Spinner.getText().toString().trim())) {
                Helper.enableErrorInTextview(this.tv_student_class_Error, "Please select class");
                return;
            }
        }
        hit_api_to_update_profile();
    }

    private void hit_api_to_get_language() {
        this.networkCall.NetworkAPICall(API.get_languages, "", false, false);
    }

    private void hit_api_to_update_profile() {
        Helper.showProgressDialog(this);
        this.networkCall.NetworkAPICall(API.update_profile, "", false, false);
    }

    @Override // com.appnew.android.Utils.AmazonUpload.AmazonCallBack
    public void onS3UploadData(ArrayList<MediaFile> images) {
        if (images == null || images.isEmpty()) {
            return;
        }
        this.profilepic = images.get(0).getFile();
        Glide.with((FragmentActivity) this).load(images.get(0).getFile()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.course_placeholder)).into(this.profileImage);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        switch (apitype) {
            case "https://appapi.videocrypt.in/index.php/data_model/users/send_verification_otp":
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setMobile(this.mobileNumber);
                encryptionData.setIs_registration("1");
                encryptionData.setResend("0");
                encryptionData.setC_code(this.data.getCCode());
                if (this.verify) {
                    encryptionData.setOtp(this.otp);
                }
                return service.getOtpVerification(AES.encrypt(new Gson().toJson(encryptionData)));
            case "https://appapi.videocrypt.in/index.php/data_model/master_hit/get_cities":
                EncryptionData encryptionData2 = new EncryptionData();
                encryptionData2.setState_id(this.SelectedStateid);
                return service.GetCity(AES.encrypt(new Gson().toJson(encryptionData2)));
            case "https://appapi.videocrypt.in/index.php/data_model/master_hit/get_states":
                EncryptionData encryptionData3 = new EncryptionData();
                encryptionData3.setUser_id(MakeMyExam.getUserId());
                if (!TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.C_ID))) {
                    encryptionData3.setCountry_id(SharedPreference.getInstance().getString(Const.C_ID));
                }
                return service.GetState(AES.encrypt(new Gson().toJson(encryptionData3)));
            case "https://appapi.videocrypt.in/index.php/data_model/master_hit/get_languages":
                return service.GetLanguage(AES.encrypt(new Gson().toJson(new EncryptionData())));
            case "https://appapi.videocrypt.in/index.php/data_model/users/update_profile":
                EncryptionData encryptionData4 = new EncryptionData();
                encryptionData4.setName(this.nameTV.getText().toString());
                encryptionData4.setMobile(this.et_phone.getText().toString().trim());
                encryptionData4.setC_code(TextUtils.isEmpty(this.data.getCCode()) ? "+91" : this.data.getCCode());
                if (!this.emailTV.getText().toString().equalsIgnoreCase(SharedPreference.getInstance().getLoggedInUser().getEmail())) {
                    encryptionData4.setEmail(this.emailTV.getText().toString());
                }
                if (this.rollNumber) {
                    encryptionData4.setRoll_no(this.rollNoET.getText().toString().trim());
                }
                if (this.isProfileTeacher.booleanValue()) {
                    encryptionData4.setUser_mentor(this.nameMentorProfile.getText().toString());
                }
                if (this.isFatherNameShow) {
                    encryptionData4.setFather_name(this.fatherNameTV.getText().toString());
                }
                if (this.isAlternateNumberShow) {
                    encryptionData4.setAlternate_number(this.alternateNumberTV.getText().toString());
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
                    encryptionData4.setProof_marksheet(this.marksheetPic);
                }
                if (this.isLanguageShow) {
                    encryptionData4.setLang(this.languageId);
                }
                if (this.isPinCodeShow) {
                    encryptionData4.setPin_code(this.pincodeTV.getText().toString());
                }
                if (this.isGSTIN) {
                    encryptionData4.setGstin(this.gstnTV.getText().toString());
                }
                if (this.isPhotoUpload) {
                    encryptionData4.setProfile_picture(this.profilepic);
                }
                if (this.isShowState) {
                    encryptionData4.setState(this.stateSpinner.getText().toString());
                    encryptionData4.setCity((this.districtSpinner.getVisibility() == 0 ? this.districtSpinner.getText() : this.etdistrictSpinner.getText()).toString());
                }
                if (this.isShowStudentClass) {
                    encryptionData4.setDivision(getDivisionIdByTitle(this.student_catType_Spinner.getText().toString().trim()));
                    encryptionData4.setSub_division(getSubDivisionIdByTitle(this.student_catType_Spinner.getText().toString().trim(), this.student_class_Spinner.getText().toString().trim()));
                }
                return service.updateprofile(AES.encrypt(new Gson().toJson(encryptionData4)));
            default:
                return null;
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        switch (apitype) {
            case "https://appapi.videocrypt.in/index.php/data_model/users/send_verification_otp":
                if (jsonstring.optString("status").equals("true")) {
                    if (this.verify) {
                        this.data = SharedPreference.getInstance().getLoggedInUser();
                        this.et_phone.setText(this.mobileNumber);
                        this.bottomSheetDialog.dismiss();
                        this.mobileNumberRL.setClickable(false);
                    } else {
                        Toast.makeText(this, jsonstring.optString("message"), 0).show();
                        this.verify = true;
                    }
                    break;
                } else {
                    Toast.makeText(this, jsonstring.optString("message"), 0).show();
                    RetrofitResponse.GetApiData(this, jsonstring.optString("auth_code"), jsonstring.optString("message"), false);
                    break;
                }
                break;
            case "https://appapi.videocrypt.in/index.php/data_model/master_hit/get_cities":
                try {
                    if (jsonstring.getBoolean("status")) {
                        StatesCities statesCities = (StatesCities) new Gson().fromJson(jsonstring.toString(), StatesCities.class);
                        this.cities = statesCities;
                        if (statesCities.getData().size() > 0) {
                            this.districtSpinner.setVisibility(0);
                            this.downarrowIV2.setVisibility(0);
                            this.etdistrictSpinner.setVisibility(8);
                            if (this.firsttime.equalsIgnoreCase("1")) {
                                this.clicktype = "2";
                                filterList("2", this.cities);
                                this.firsttime = "0";
                            }
                        } else {
                            this.districtSpinner.setVisibility(8);
                            this.downarrowIV2.setVisibility(4);
                            this.etdistrictSpinner.setVisibility(0);
                        }
                    } else if (jsonstring.optString("message").equalsIgnoreCase("Cities Not Found")) {
                        this.districtSpinner.setVisibility(8);
                        this.downarrowIV2.setVisibility(4);
                        this.etdistrictSpinner.setVisibility(0);
                    }
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
                break;
            case "https://appapi.videocrypt.in/index.php/data_model/master_hit/get_states":
                try {
                    if (jsonstring.getBoolean("status")) {
                        this.states = (StatesCities) new Gson().fromJson(jsonstring.toString(), StatesCities.class);
                    }
                    break;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
                break;
            case "https://appapi.videocrypt.in/index.php/data_model/master_hit/get_languages":
                if (jsonstring.getBoolean("status")) {
                    this.languagesData = (LanguagesData) new Gson().fromJson(jsonstring.toString(), LanguagesData.class);
                }
                LanguagesData languagesData = this.languagesData;
                if (languagesData != null && !languagesData.getData().isEmpty()) {
                    for (Languages languages : this.languagesData.getData()) {
                        if (this.data.getLang() != null && languages.getId().equalsIgnoreCase(this.data.getLang())) {
                            this.languageSpinner.setText(languages.getLanguage());
                            this.languageId = languages.getId();
                        }
                    }
                    break;
                }
                break;
            case "https://appapi.videocrypt.in/index.php/data_model/users/update_profile":
                Helper.dismissProgressDialog();
                try {
                    if (jsonstring.getBoolean("status")) {
                        this.data.setName(this.nameTV.getText().toString().trim());
                        this.data.setMobile(this.et_phone.getText().toString().trim());
                        Data data = this.data;
                        data.setC_code(TextUtils.isEmpty(data.getCCode()) ? "+91" : this.data.getCCode());
                        if (!this.emailTV.getText().toString().equalsIgnoreCase(SharedPreference.getInstance().getLoggedInUser().getEmail())) {
                            this.data.setEmail(this.emailTV.getText().toString());
                        }
                        if (this.rollNumber) {
                            this.data.setRoll_no(this.rollNoET.getText().toString().trim());
                        }
                        if (this.isProfileTeacher.booleanValue()) {
                            this.data.setUser_mentor(this.nameMentorProfile.getText().toString());
                        }
                        if (this.isPhotoUpload) {
                            this.data.setProfilePicture(this.profilepic);
                        }
                        if (this.isFatherNameShow) {
                            this.data.setFather_name(this.fatherNameTV.getText().toString());
                        }
                        if (this.isAlternateNumberShow) {
                            this.data.setAlternate_number(this.alternateNumberTV.getText().toString());
                        }
                        if (this.isGenderShow) {
                            this.data.setGender(this.gender);
                        }
                        if (this.isCasteShow) {
                            this.data.setCaste_category(this.caste);
                        }
                        if (this.isAddressShow) {
                            this.data.setAddress(this.addressTV.getText().toString());
                        }
                        if (this.isTenthMarksheetUpload) {
                            this.data.setProof_marksheet(this.marksheetPic);
                        }
                        if (this.isLanguageShow) {
                            this.data.setLang(this.languageId);
                        }
                        if (this.isPinCodeShow) {
                            this.data.setPin_code(this.pincodeTV.getText().toString());
                        }
                        if (this.isGSTIN) {
                            this.data.setGstin(this.gstnTV.getText().toString());
                        }
                        if (this.isShowState) {
                            this.data.setState(this.stateSpinner.getText().toString());
                            this.data.setCity((this.districtSpinner.getVisibility() == 0 ? this.districtSpinner.getText() : this.etdistrictSpinner.getText()).toString());
                        }
                        if (this.isShowStudentClass) {
                            this.data.setDivision(this.student_catType_Spinner.getText().toString().trim());
                            this.data.setStudent_class(this.student_class_Spinner.getText().toString().trim());
                            SharedPreference.getInstance().putString(Const.GET_DIVISION, getDivisionIdByTitle(this.student_catType_Spinner.getText().toString().trim()));
                            SharedPreference.getInstance().putString(Const.GET_SUB_DIVISION, getSubDivisionIdByTitle(this.student_catType_Spinner.getText().toString().trim(), this.student_class_Spinner.getText().toString().trim()));
                        }
                        SharedPreference.getInstance().setLoggedInUserr(this.data);
                        AnalyticEvents.INSTANCE.addUpdateCleverTapUser(this, true);
                        Toast.makeText(this, getResources().getString(R.string.profile_updated), 0).show();
                        finish();
                    } else {
                        Toast.makeText(this, "" + jsonstring.getString("message"), 0).show();
                        finish();
                    }
                    break;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
                break;
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        apitype.hashCode();
        switch (apitype) {
            case "https://appapi.videocrypt.in/index.php/data_model/master_hit/get_cities":
            case "https://appapi.videocrypt.in/index.php/data_model/master_hit/get_states":
            case "https://appapi.videocrypt.in/index.php/data_model/users/update_profile":
                Helper.dismissProgressDialog();
                Toast.makeText(this, jsonstring, 0).show();
                break;
        }
    }

    private void checkStoragePermission() {
        Dexter.withContext(this).withPermissions("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA").withListener(new MultiplePermissionsListener() { // from class: com.appnew.android.Profile.ProfileActivity.3
            @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                ProfileActivity.this.imgClick();
            }

            @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                token.continuePermissionRequest();
            }
        }).check();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void imgClick() {
        final CharSequence[] charSequenceArr = {getResources().getString(R.string.take_photo), getResources().getString(R.string.choose_from_gallery), getResources().getString(R.string.cancel)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.add_photo));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: com.appnew.android.Profile.ProfileActivity$$ExternalSyntheticLambda14
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$imgClick$10(charSequenceArr, dialogInterface, i);
            }
        });
        if (isFinishing() || isDestroyed()) {
            return;
        }
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$imgClick$10(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals(getResources().getString(R.string.take_photo))) {
            try {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                Uri uriForFile = FileProvider.getUriForFile(this, "com.eduteria.app.app.provider", new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "temp_image.jpg"));
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
            Uri uriForFile2 = FileProvider.getUriForFile(this, "com.eduteria.app.app.provider", new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "temp_gallery.jpg"));
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

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$11(CropImageView.CropResult cropResult) {
        if (cropResult.isSuccessful()) {
            if (this.str_imgTypeClick.equalsIgnoreCase("PhotoCameraRequest")) {
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), cropResult.getUriContent());
                    new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES) + "/Utkarsh/ProfileImage/").mkdirs();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream);
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    this.s3IU = new s3ImageUploading("", "vc-10000386-38616500102/166/application/profile/", this, this, null);
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
                    Bitmap bitmap2 = MediaStore.Images.Media.getBitmap(getContentResolver(), cropResult.getUriContent());
                    new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES) + "/utkarsh/ProfileImage/").mkdirs();
                    String str = SharedPreference.getInstance().getLoggedInUser().getId() + "_" + Calendar.getInstance().getTimeInMillis() + ".jpg";
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    bitmap2.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream2);
                    Bitmap bitmapDecodeStream2 = BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream2.toByteArray()));
                    byteArrayOutputStream2.flush();
                    byteArrayOutputStream2.close();
                    this.s3IU = new s3ImageUploading("", "vc-10000386-38616500102/166/application/profile/", this, this, null);
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
    public /* synthetic */ void lambda$new$12(ActivityResult activityResult) {
        if (activityResult.getResultCode() == -1) {
            int i = this.requestCode;
            if (i != 10000) {
                if (i == 20000) {
                    try {
                        this.cropImage.launch(new CropImageContractOptions(activityResult.getData().getData(), Helper.cropImageOptions(this)));
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                return;
            }
            try {
                File file = new File(String.valueOf(getExternalFilesDir(Environment.DIRECTORY_PICTURES)));
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
                this.cropImage.launch(new CropImageContractOptions(FileProvider.getUriForFile(this, "com.eduteria.app.app.provider", file), Helper.cropImageOptions(this)));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private void hit_api_to_get_state() {
        this.networkCall.NetworkAPICall(API.API_STATE, "", false, false);
    }

    private void hit_api_to_get_city() {
        if (this.country) {
            return;
        }
        this.networkCall.NetworkAPICall(API.API_CITY, "", false, false);
    }

    public void filterListLanguage(String searchType, LanguagesData languagesData) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
        dialog.setContentView(R.layout.item_language_dialog);
        dialog.setCancelable(true);
        EditText editText = (EditText) dialog.findViewById(R.id.et_search);
        this.etSearchLanguage = editText;
        editText.setHint(getResources().getString(R.string.search_language));
        this.ivClearSearchLanguage = (ImageView) dialog.findViewById(R.id.iv_clear_search);
        TextView textView = (TextView) dialog.findViewById(R.id.tv_cancel);
        this.ivClearSearchLanguage.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Profile.ProfileActivity$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$filterListLanguage$13(view);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Profile.ProfileActivity$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.cancel();
            }
        });
        RecyclerView recyclerView = (RecyclerView) dialog.findViewById(R.id.search_recyclerview);
        this.languageRecyclerview = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.languageRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        LanguageAdapter languageAdapter = new LanguageAdapter(this, languagesData.getData(), dialog);
        this.languageAdapter = languageAdapter;
        this.languageRecyclerview.setAdapter(languageAdapter);
        textWatcherLanguage(searchType);
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$filterListLanguage$13(View view) {
        this.etSearchLanguage.setText("");
    }

    public void textWatcherLanguage(final String searchType) {
        this.etSearchLanguage.addTextChangedListener(new TextWatcher() { // from class: com.appnew.android.Profile.ProfileActivity.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    ProfileActivity.this.ivClearSearchLanguage.setVisibility(0);
                } else {
                    ProfileActivity.this.ivClearSearchLanguage.setVisibility(8);
                }
                ProfileActivity.this.filterLanguage(editable.toString(), searchType);
            }
        });
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
            holder.tvName.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Profile.ProfileActivity$LanguageAdapter$$ExternalSyntheticLambda0
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
            ProfileActivity.this.languageSpinner.setText(languages.getLanguage());
            ProfileActivity.this.languageId = languages.getId();
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Caste /* 2131361806 */:
            case R.id.casteSpinner /* 2131362484 */:
            case R.id.downarrowCasteIV /* 2131363003 */:
                if (!Helper.isNetworkConnected(this)) {
                    Helper.showInternetToast(this);
                } else {
                    PopupMenu popupMenu = new PopupMenu(this, this.Caste, 3);
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
                if (!Helper.isNetworkConnected(this)) {
                    Helper.showInternetToast(this);
                } else {
                    PopupMenu popupMenu2 = new PopupMenu(this, this.Gender, 3);
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
                    Toast.makeText(this, getResources().getString(R.string.no_language_available), 0).show();
                } else {
                    this.clicktype = "1";
                    filterListLanguage("1", this.languagesData);
                }
                break;
            case R.id.State /* 2131361927 */:
            case R.id.stateSpinner /* 2131365469 */:
                StatesCities statesCities = this.states;
                if (statesCities == null || statesCities.getData().size() == 0) {
                    Toast.makeText(this, getResources().getString(R.string.no_state_available), 0).show();
                } else {
                    this.clicktype = "1";
                    filterList("1", this.states);
                }
                break;
            case R.id.changeLanguage /* 2131362525 */:
                startActivity(new Intent(this, (Class<?>) ChangeLanguageActivity.class));
                finish();
                break;
            case R.id.city /* 2131362567 */:
            case R.id.districtSpinner /* 2131362954 */:
                StatesCities statesCities2 = this.cities;
                if (statesCities2 == null || statesCities2.getData().size() == 0) {
                    StatesCities statesCities3 = this.states;
                    if (statesCities3 != null) {
                        if (statesCities3.getData().size() > 0) {
                            for (StatesCitiesData statesCitiesData : this.states.getData()) {
                                if (this.data.getState().equalsIgnoreCase(statesCitiesData.getName())) {
                                    this.firsttime = "1";
                                    this.SelectedStateid = statesCitiesData.getId();
                                    hit_api_to_get_city();
                                }
                            }
                        } else {
                            Toast.makeText(this, getResources().getString(R.string.please_select_state_first), 0).show();
                        }
                    }
                } else {
                    this.clicktype = "2";
                    filterList("2", this.cities);
                }
                break;
        }
    }

    public void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Resources resources = getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        resources.updateConfiguration(configuration, displayMetrics);
        Locale.setDefault(locale);
        onConfigurationChanged(configuration);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    public void filterList(String searchType, StatesCities countryArrayList) {
        final Dialog dialog = new Dialog(this);
        ((Window) Objects.requireNonNull(dialog.getWindow())).setBackgroundDrawableResource(R.color.transparent_background);
        dialog.getWindow().requestFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
        dialog.setContentView(R.layout.state_city_dialog);
        dialog.setCancelable(true);
        this.etSearch = (EditText) dialog.findViewById(R.id.et_search);
        if (searchType.equalsIgnoreCase("1")) {
            this.etSearch.setHint(getResources().getString(R.string.search_state));
        } else if (searchType.equalsIgnoreCase("2")) {
            this.etSearch.setHint(getResources().getString(R.string.search_district));
        }
        this.ivClearSearch = (ImageView) dialog.findViewById(R.id.iv_clear_search);
        TextView textView = (TextView) dialog.findViewById(R.id.tv_cancel);
        this.ivClearSearch.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Profile.ProfileActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$filterList$15(view);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Profile.ProfileActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.cancel();
            }
        });
        RecyclerView recyclerView = (RecyclerView) dialog.findViewById(R.id.search_recyclerview);
        this.searchRecyclerview = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.searchRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        StateCityAdapter stateCityAdapter = new StateCityAdapter(this, countryArrayList.getData(), searchType, dialog);
        this.stateCityAdapter = stateCityAdapter;
        this.searchRecyclerview.setAdapter(stateCityAdapter);
        textWatcher(searchType);
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$filterList$15(View view) {
        this.etSearch.setText("");
    }

    public void textWatcher(final String searchType) {
        this.etSearch.addTextChangedListener(new TextWatcher() { // from class: com.appnew.android.Profile.ProfileActivity.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    ProfileActivity.this.ivClearSearch.setVisibility(0);
                } else {
                    ProfileActivity.this.ivClearSearch.setVisibility(8);
                }
                ProfileActivity.this.filter(editable.toString(), searchType);
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
        }
        if (!this.statesCitiesArrayList.isEmpty()) {
            this.searchRecyclerview.setVisibility(0);
            this.stateCityAdapter.filterCountryList(this.statesCitiesArrayList);
        } else {
            this.searchRecyclerview.setVisibility(4);
        }
    }

    public void onStateCityClick(String searchType, StatesCitiesData country) {
        if (searchType.equalsIgnoreCase("1")) {
            if (country.getName().equals(this.stateindex)) {
                return;
            }
            for (StatesCitiesData statesCitiesData : this.states.getData()) {
                if (statesCitiesData.getName().equals(country.getName())) {
                    this.stateindex = country.getName();
                    this.SelectedStateid = statesCitiesData.getId();
                    this.stateSpinner.setText(country.getName());
                    this.firsttime = "0";
                    this.districtSpinner.setText(getResources().getString(R.string.district));
                    this.etdistrictSpinner.setText("");
                    hit_api_to_get_city();
                    return;
                }
            }
            return;
        }
        if (!searchType.equalsIgnoreCase("2") || country.getName().equals(this.cityindex)) {
            return;
        }
        for (StatesCitiesData statesCitiesData2 : this.cities.getData()) {
            if (statesCitiesData2.getName().equals(country.getName())) {
                this.cityindex = country.getName();
                this.SelectedCityid = statesCitiesData2.getId();
                this.districtSpinner.setText(country.getName());
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
        if (this.clicktype1.equalsIgnoreCase("4")) {
            for (String str3 : this.presentClass) {
                if (str3.equalsIgnoreCase(menuItem.getTitle().toString())) {
                    this.student_class_Spinner.setText(str3);
                    Helper.enableErrorInTextview(this.tv_student_class_Error, null);
                }
            }
        }
        if (this.clicktype1.equalsIgnoreCase("5")) {
            for (String str4 : this.presentCategory) {
                if (str4.equalsIgnoreCase(menuItem.getTitle().toString())) {
                    this.student_catType_Spinner.setText(str4);
                    Helper.enableErrorInTextview(this.tv_student_catType_Error, null);
                    this.selectedDivisionName = str4;
                    this.student_class_Spinner.setText("");
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
            myViewHolder.tvName.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Profile.ProfileActivity$StateCityAdapter$$ExternalSyntheticLambda0
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
            if (str.equals("1")) {
                ProfileActivity.this.onStateCityClick(this.searchType, statesCitiesData);
            } else if (str.equals("2")) {
                ProfileActivity.this.onStateCityClick(this.searchType, statesCitiesData);
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

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if ("1".equalsIgnoreCase("7")) {
            finish();
        }
    }

    private void selectPresentClass() {
        Helper.hideKeyboard(this);
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return;
        }
        if (this.rl_student_catType.getVisibility() == 0 && !Helper.isNullChek(this.student_catType_Spinner.getText().toString().trim())) {
            Helper.enableErrorInTextview(this.tv_student_catType_Error, "Please select Division");
            return;
        }
        PopupMenu popupMenu = new PopupMenu(this, this.student_class_Spinner, 3);
        this.presentClass.clear();
        if (this.selectedDivisionName == null) {
            this.selectedDivisionName = this.student_catType_Spinner.getText().toString();
        }
        List<String> subDivisionTitlesForDivision = getSubDivisionTitlesForDivision(this.selectedDivisionName);
        this.presentClass = subDivisionTitlesForDivision;
        Iterator<String> it = subDivisionTitlesForDivision.iterator();
        while (it.hasNext()) {
            popupMenu.getMenu().add(it.next());
        }
        this.clicktype1 = "4";
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }

    private void selectPresentCatType() {
        Helper.hideKeyboard(this);
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return;
        }
        PopupMenu popupMenu = new PopupMenu(this, this.student_catType_Spinner, 3);
        this.presentCategory.clear();
        List<String> divisionList = getDivisionList();
        this.presentCategory = divisionList;
        Iterator<String> it = divisionList.iterator();
        while (it.hasNext()) {
            popupMenu.getMenu().add(it.next());
        }
        this.clicktype1 = "5";
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }

    private void toggleViewVisibility(RelativeLayout myView) {
        List<String> divisionList = getDivisionList();
        if (divisionList != null && divisionList.size() == 1) {
            this.selectedDivisionName = divisionList.get(0);
            myView.setVisibility(8);
        } else {
            myView.setVisibility(0);
        }
    }

    private List<String> getDivisionList() {
        ArrayList arrayList = new ArrayList();
        try {
            String string = SharedPreference.getInstance().getString(Const.DIVISION);
            if (!TextUtils.isEmpty(string)) {
                List<DivisionModel> list = (List) new Gson().fromJson(string, new TypeToken<List<DivisionModel>>() { // from class: com.appnew.android.Profile.ProfileActivity.6
                }.getType());
                if (list != null) {
                    for (DivisionModel divisionModel : list) {
                        if (divisionModel != null && divisionModel.getTitle() != null) {
                            arrayList.add(divisionModel.getTitle());
                        }
                    }
                }
            }
            return arrayList;
        } catch (JsonSyntaxException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004b, code lost:
    
        if (r2.getSub_divisions() == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004d, code lost:
    
        r4 = r2.getSub_divisions().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0059, code lost:
    
        if (r4.hasNext() == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005b, code lost:
    
        r1 = r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0061, code lost:
    
        if (r1 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0063, code lost:
    
        r0.add(r1.getTitle());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.List<java.lang.String> getSubDivisionTitlesForDivision(java.lang.String r4) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.appnew.android.Utils.SharedPreference r1 = com.appnew.android.Utils.SharedPreference.getInstance()     // Catch: com.google.gson.JsonSyntaxException -> L6c
            java.lang.String r2 = "division"
            java.lang.String r1 = r1.getString(r2)     // Catch: com.google.gson.JsonSyntaxException -> L6c
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: com.google.gson.JsonSyntaxException -> L6c
            if (r2 != 0) goto L6b
            com.appnew.android.Profile.ProfileActivity$7 r2 = new com.appnew.android.Profile.ProfileActivity$7     // Catch: com.google.gson.JsonSyntaxException -> L6c
            r2.<init>()     // Catch: com.google.gson.JsonSyntaxException -> L6c
            java.lang.reflect.Type r2 = r2.getType()     // Catch: com.google.gson.JsonSyntaxException -> L6c
            com.google.gson.Gson r3 = new com.google.gson.Gson     // Catch: com.google.gson.JsonSyntaxException -> L6c
            r3.<init>()     // Catch: com.google.gson.JsonSyntaxException -> L6c
            java.lang.Object r1 = r3.fromJson(r1, r2)     // Catch: com.google.gson.JsonSyntaxException -> L6c
            java.util.List r1 = (java.util.List) r1     // Catch: com.google.gson.JsonSyntaxException -> L6c
            if (r1 == 0) goto L6b
            java.util.Iterator r1 = r1.iterator()     // Catch: com.google.gson.JsonSyntaxException -> L6c
        L2f:
            boolean r2 = r1.hasNext()     // Catch: com.google.gson.JsonSyntaxException -> L6c
            if (r2 == 0) goto L6b
            java.lang.Object r2 = r1.next()     // Catch: com.google.gson.JsonSyntaxException -> L6c
            com.appnew.android.Model.DivisionModel.DivisionModel r2 = (com.appnew.android.Model.DivisionModel.DivisionModel) r2     // Catch: com.google.gson.JsonSyntaxException -> L6c
            if (r2 == 0) goto L2f
            java.lang.String r3 = r2.getTitle()     // Catch: com.google.gson.JsonSyntaxException -> L6c
            boolean r3 = r4.equalsIgnoreCase(r3)     // Catch: com.google.gson.JsonSyntaxException -> L6c
            if (r3 == 0) goto L2f
            java.util.ArrayList r4 = r2.getSub_divisions()     // Catch: com.google.gson.JsonSyntaxException -> L6c
            if (r4 == 0) goto L6b
            java.util.ArrayList r4 = r2.getSub_divisions()     // Catch: com.google.gson.JsonSyntaxException -> L6c
            java.util.Iterator r4 = r4.iterator()     // Catch: com.google.gson.JsonSyntaxException -> L6c
        L55:
            boolean r1 = r4.hasNext()     // Catch: com.google.gson.JsonSyntaxException -> L6c
            if (r1 == 0) goto L6b
            java.lang.Object r1 = r4.next()     // Catch: com.google.gson.JsonSyntaxException -> L6c
            com.appnew.android.Model.DivisionModel.SubDivision r1 = (com.appnew.android.Model.DivisionModel.SubDivision) r1     // Catch: com.google.gson.JsonSyntaxException -> L6c
            if (r1 == 0) goto L55
            java.lang.String r1 = r1.getTitle()     // Catch: com.google.gson.JsonSyntaxException -> L6c
            r0.add(r1)     // Catch: com.google.gson.JsonSyntaxException -> L6c
            goto L55
        L6b:
            return r0
        L6c:
            r4 = move-exception
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Profile.ProfileActivity.getSubDivisionTitlesForDivision(java.lang.String):java.util.List");
    }

    public String getDivisionIdByTitle(String title) {
        try {
            String string = SharedPreference.getInstance().getString(Const.DIVISION);
            if (!TextUtils.isEmpty(string)) {
                List<DivisionModel> list = (List) new Gson().fromJson(string, new TypeToken<List<DivisionModel>>() { // from class: com.appnew.android.Profile.ProfileActivity.8
                }.getType());
                if (list != null && !list.isEmpty()) {
                    for (DivisionModel divisionModel : list) {
                        if (!TextUtils.isEmpty(divisionModel.getTitle()) && divisionModel.getTitle().equalsIgnoreCase(title)) {
                            return divisionModel.getId();
                        }
                    }
                    return "0";
                }
                return "0";
            }
            return "0";
        } catch (JsonSyntaxException e2) {
            e2.printStackTrace();
            return "0";
        }
    }

    public String getSubDivisionIdByTitle(String selectedDivision, String title) {
        try {
            String string = SharedPreference.getInstance().getString(Const.DIVISION);
            if (!TextUtils.isEmpty(string)) {
                List<DivisionModel> list = (List) new Gson().fromJson(string, new TypeToken<List<DivisionModel>>() { // from class: com.appnew.android.Profile.ProfileActivity.9
                }.getType());
                if (list != null && !list.isEmpty()) {
                    for (DivisionModel divisionModel : list) {
                        if (divisionModel != null && !TextUtils.isEmpty(selectedDivision) && selectedDivision.equalsIgnoreCase(divisionModel.getTitle()) && divisionModel.getSub_divisions() != null && !divisionModel.getSub_divisions().isEmpty()) {
                            for (SubDivision subDivision : divisionModel.getSub_divisions()) {
                                if (!TextUtils.isEmpty(subDivision.getTitle()) && subDivision.getTitle().equalsIgnoreCase(title)) {
                                    return subDivision.getId();
                                }
                            }
                        }
                    }
                    return "0";
                }
                return "0";
            }
            return "0";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "0";
        }
    }

    public String getDivisionTitleById(String divId) {
        try {
            String string = SharedPreference.getInstance().getString(Const.DIVISION);
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(divId)) {
                List<DivisionModel> list = (List) new Gson().fromJson(string, new TypeToken<List<DivisionModel>>() { // from class: com.appnew.android.Profile.ProfileActivity.10
                }.getType());
                if (list != null && !list.isEmpty()) {
                    for (DivisionModel divisionModel : list) {
                        if (!TextUtils.isEmpty(divisionModel.getId()) && divisionModel.getId().equalsIgnoreCase(divId)) {
                            return divisionModel.getTitle();
                        }
                    }
                    return "N/A";
                }
                return "N/A";
            }
            return "N/A";
        } catch (JsonSyntaxException e2) {
            e2.printStackTrace();
            return "N/A";
        }
    }

    public String getSubDivisionTitleById(String subDivId, String divId) {
        try {
            String string = SharedPreference.getInstance().getString(Const.DIVISION);
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(subDivId) && !TextUtils.isEmpty(divId)) {
                List<DivisionModel> list = (List) new Gson().fromJson(string, new TypeToken<List<DivisionModel>>() { // from class: com.appnew.android.Profile.ProfileActivity.11
                }.getType());
                if (list != null && !list.isEmpty()) {
                    for (DivisionModel divisionModel : list) {
                        if (divisionModel != null && !TextUtils.isEmpty(subDivId) && subDivId.equalsIgnoreCase(divisionModel.getId()) && divisionModel.getSub_divisions() != null && !divisionModel.getSub_divisions().isEmpty()) {
                            for (SubDivision subDivision : divisionModel.getSub_divisions()) {
                                if (!TextUtils.isEmpty(subDivision.getId()) && subDivision.getId().equalsIgnoreCase(divId)) {
                                    return subDivision.getTitle();
                                }
                            }
                        }
                    }
                    return "N/A";
                }
                return "N/A";
            }
            return "N/A";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "N/A";
        }
    }
}
