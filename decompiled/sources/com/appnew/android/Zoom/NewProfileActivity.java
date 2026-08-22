package com.appnew.android.Zoom;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.cardview.widget.CardView;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Cart.Activity.RewardActivity;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.LeftMenu;
import com.appnew.android.Model.MediaFile;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.AmazonUpload.AmazonCallBack;
import com.appnew.android.Utils.AmazonUpload.s3ImageUploading;
import com.appnew.android.Utils.AppPermissionsRunTime;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.imagecropper.TakeImageClass;
import com.appnew.android.pojo.Userinfo.Data;
import com.appnew.android.pojo.Userinfo.StatesCities.StatesCities;
import com.appnew.android.pojo.Userinfo.StatesCities.StatesCitiesData;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.canhub.cropper.CropImageContract;
import com.canhub.cropper.CropImageContractOptions;
import com.canhub.cropper.CropImageView;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import com.hbb20.CountryCodePicker;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.tv9news.utils.helpers.AnalyticEvents;
import de.hdodenhof.circleimageview.CircleImageView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class NewProfileActivity extends AppCompatActivity implements AmazonCallBack, TakeImageClass.imagefromcropper, NetworkCall.MyNetworkCallBack, View.OnClickListener, PopupMenu.OnMenuItemClickListener {
    RelativeLayout City;
    RelativeLayout State;
    EditText aadhar_card_TextV;
    EditText alternate_number_TextV;
    TextView caste_category_TextV;
    TextView change_pass;
    StatesCities cities;
    CountryCodePicker cpp;
    Data data;
    TextView date_of_birth_Text;
    TextView districtSpinner;
    ImageView downarrowIV;
    ImageView downarrowIV2;
    EditText education_qualification_TextV;
    EditText emailTV;
    EditText etSearch;
    EditText et_phone;
    EditText etdistrictSpinner;
    RelativeLayout flagCountryLL;
    RelativeLayout flagRL;
    TextView gender_Text;
    EditText gstnTV;
    EditText guardian_name_Text;
    EditText guardian_number_Text;
    ImageView image_back;
    ImageView ivClearSearch;
    public ArrayList<AppPermissionsRunTime.MyPermissionConstants> myPermissionConstantsArrayList;
    EditText nameTV;
    NetworkCall networkCall;
    TextView ph_status_TextV;
    EditText pin_code_Text;
    CircleImageView profileImage;
    String profileMenu;
    CardView rewardCart;
    RelativeLayout rlGSTIN;
    private s3ImageUploading s3IU;
    RecyclerView searchRecyclerview;
    StateCityAdapter stateCityAdapter;
    TextView stateSpinner;
    StatesCities states;
    Button submit;
    RelativeLayout uploadImg;
    EditText user_address_Text;
    String str_imgTypeClick = "";
    public final int REQUEST_CODE_PERMISSION_MULTIPLE = 123;
    String clicktype = "";
    String genderState = "0";
    String stateindex = "";
    String cityindex = "";
    String SelectedStateid = "";
    String SelectedCityid = "";
    String profilepic = "";
    String firsttime = "1";
    private boolean country = false;
    private int requestCode = -1;
    String[] genderArray = {"Male", "Female", "Other"};
    String[] ph_Array = {"Yes", "No"};
    String[] cast_Array = {"GEN", "OBC", "SC", "ST", "Others"};
    final Calendar myCalendar = Calendar.getInstance();
    private boolean isShowState = true;
    private boolean isGSTIN = false;
    UtkashRoom utkashRoom = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
    private ActivityResultLauncher<CropImageContractOptions> cropImage = registerForActivityResult(new CropImageContract(), new ActivityResultCallback() { // from class: com.appnew.android.Zoom.NewProfileActivity$$ExternalSyntheticLambda0
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.f$0.lambda$new$5((CropImageView.CropResult) obj);
        }
    });
    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.Zoom.NewProfileActivity$$ExternalSyntheticLambda1
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.f$0.lambda$new$6((ActivityResult) obj);
        }
    });
    ArrayList<StatesCitiesData> statesCitiesArrayList = new ArrayList<>();

    @Override // com.appnew.android.Utils.imagecropper.TakeImageClass.imagefromcropper
    public void imagePath(String str) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.enableScreenShot(this);
        setContentView(R.layout.activity_new_profile);
        this.nameTV = (EditText) findViewById(R.id.nameTV);
        this.user_address_Text = (EditText) findViewById(R.id.user_address_Text);
        this.pin_code_Text = (EditText) findViewById(R.id.pin_code_Text);
        this.date_of_birth_Text = (TextView) findViewById(R.id.date_of_birth_Text);
        this.gender_Text = (TextView) findViewById(R.id.gender_Text);
        this.guardian_name_Text = (EditText) findViewById(R.id.guardian_name_Text);
        this.guardian_number_Text = (EditText) findViewById(R.id.guardian_number_Text);
        this.education_qualification_TextV = (EditText) findViewById(R.id.education_qualification_TextV);
        this.aadhar_card_TextV = (EditText) findViewById(R.id.aadhar_card_TextV);
        this.ph_status_TextV = (TextView) findViewById(R.id.ph_status_TextV);
        this.alternate_number_TextV = (EditText) findViewById(R.id.alternate_number_TextV);
        this.caste_category_TextV = (TextView) findViewById(R.id.caste_category_TextV);
        this.emailTV = (EditText) findViewById(R.id.emailTV);
        this.et_phone = (EditText) findViewById(R.id.et_phone);
        this.stateSpinner = (TextView) findViewById(R.id.stateSpinner);
        this.change_pass = (TextView) findViewById(R.id.change_pass);
        this.districtSpinner = (TextView) findViewById(R.id.districtSpinner);
        this.etdistrictSpinner = (EditText) findViewById(R.id.etdistrictSpinner);
        this.profileImage = (CircleImageView) findViewById(R.id.profileImage);
        this.uploadImg = (RelativeLayout) findViewById(R.id.uploadImg);
        this.image_back = (ImageView) findViewById(R.id.image_back);
        this.downarrowIV = (ImageView) findViewById(R.id.downarrowIV);
        this.downarrowIV2 = (ImageView) findViewById(R.id.downarrowIV2);
        this.submit = (Button) findViewById(R.id.submit);
        this.City = (RelativeLayout) findViewById(R.id.city);
        this.State = (RelativeLayout) findViewById(R.id.State);
        this.flagRL = (RelativeLayout) findViewById(R.id.flagRL);
        this.flagCountryLL = (RelativeLayout) findViewById(R.id.flagCountryLL);
        this.cpp = (CountryCodePicker) findViewById(R.id.countryDropDown);
        this.rewardCart = (CardView) findViewById(R.id.rewardCart);
        this.rlGSTIN = (RelativeLayout) findViewById(R.id.rlGSTIN);
        this.gstnTV = (EditText) findViewById(R.id.gstnTV);
        this.isShowState = !SharedPreference.getInstance().getString(Const.HIDE_CITY_STATE).equalsIgnoreCase("1");
        this.isGSTIN = SharedPreference.getInstance().getString(Const.IS_GSTIN).equalsIgnoreCase("1");
        if (SharedPreference.getInstance().getString(Const.COUNTRY_SHOW).equalsIgnoreCase("1")) {
            this.country = true;
        }
        if (this.country) {
            this.flagRL.setVisibility(8);
            this.flagCountryLL.setVisibility(0);
            this.districtSpinner.setVisibility(8);
            this.downarrowIV2.setVisibility(4);
            this.etdistrictSpinner.setVisibility(0);
            this.cpp.setCcpClickable(false);
            if (!TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.C_NAME_CODE))) {
                this.cpp.setCountryForNameCode(SharedPreference.getInstance().getString(Const.C_NAME_CODE));
            } else {
                this.cpp.setCountryForPhoneCode(Helper.converToIntCountryCode(this.data.getCCode()));
            }
        } else {
            this.flagRL.setVisibility(0);
            this.flagCountryLL.setVisibility(8);
            this.districtSpinner.setVisibility(0);
            this.downarrowIV2.setVisibility(0);
            this.etdistrictSpinner.setVisibility(8);
        }
        if (((LeftMenu) new Gson().fromJson(this.utkashRoom.getthemeSettingdao().data().getLeft_menu(), LeftMenu.class)).getReward().equalsIgnoreCase("1")) {
            this.rewardCart.setVisibility(0);
            this.rewardCart.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.NewProfileActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    NewProfileActivity.this.startActivity(new Intent(NewProfileActivity.this.getApplicationContext(), (Class<?>) RewardActivity.class));
                }
            });
        } else {
            this.rewardCart.setVisibility(8);
        }
        this.State.setOnClickListener(this);
        this.City.setOnClickListener(this);
        this.stateSpinner.setOnClickListener(this);
        this.districtSpinner.setOnClickListener(this);
        this.networkCall = new NetworkCall(this, this);
        Data loggedInUser = SharedPreference.getInstance().getLoggedInUser();
        this.data = loggedInUser;
        if (loggedInUser.getName() != null) {
            this.nameTV.setText(this.data.getName());
        }
        if (this.data.getAddress() != null) {
            this.user_address_Text.setText(this.data.getAddress());
        }
        if (this.data.getPin_code() != null) {
            this.pin_code_Text.setText(this.data.getPin_code());
        }
        if (this.data.getDate_of_birth() != null) {
            this.date_of_birth_Text.setText(this.data.getDate_of_birth());
        }
        if (this.data.getGender() != null) {
            if (this.data.getGender().equals("0")) {
                this.gender_Text.setText("Male");
            } else if (this.data.getGender().equals("1")) {
                this.gender_Text.setText("Female");
            } else if (this.data.getGender().equals("2")) {
                this.gender_Text.setText("Other");
            } else {
                this.gender_Text.setText(this.data.getGender());
            }
        }
        if (this.data.getGuardian_name() != null) {
            this.guardian_name_Text.setText(this.data.getGuardian_name());
        }
        if (this.data.getGuardian_number() != null) {
            this.guardian_number_Text.setText(this.data.getGuardian_number());
        }
        if (this.data.getEducation_qualification() != null) {
            this.education_qualification_TextV.setText(this.data.getEducation_qualification());
        }
        if (this.data.getPh_status() != null) {
            this.ph_status_TextV.setText(this.data.getPh_status());
        }
        if (this.data.getAadhar_card() != null) {
            this.alternate_number_TextV.setText(this.data.getAlternate_number());
        }
        if (this.data.getCaste_category() != null) {
            this.caste_category_TextV.setText(this.data.getCaste_category());
        }
        if (this.data.getAadhar_card() != null) {
            this.aadhar_card_TextV.setText(this.data.getAadhar_card());
        }
        if (this.data.getEmail() != null) {
            this.emailTV.setText(this.data.getEmail());
        }
        if (this.data.getGstin() != null) {
            this.gstnTV.setText(this.data.getGstin());
        }
        this.emailTV.setEnabled(false);
        if (this.data.getMobile() != null) {
            this.et_phone.setText(this.data.getMobile());
        }
        this.et_phone.setEnabled(false);
        this.submit.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.NewProfileActivity$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$0();
            }
        }));
        this.image_back.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.NewProfileActivity$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$1();
            }
        }));
        this.uploadImg.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.NewProfileActivity$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$2();
            }
        }));
        if (this.isShowState) {
            this.State.setVisibility(0);
            this.City.setVisibility(0);
        } else {
            this.State.setVisibility(8);
            this.City.setVisibility(8);
        }
        if (this.isGSTIN) {
            this.rlGSTIN.setVisibility(0);
        } else {
            this.rlGSTIN.setVisibility(8);
        }
        this.change_pass.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.NewProfileActivity$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$3();
            }
        }));
        hit_api_to_get_state();
        if (this.data.getState() != null) {
            this.stateSpinner.setText(this.data.getState());
        }
        if (this.data.getCity() != null) {
            this.districtSpinner.setText(this.data.getCity());
            this.etdistrictSpinner.setText(this.data.getCity());
        }
        if (this.data.getProfilePicture() != null) {
            this.profilepic = this.data.getProfilePicture();
            Glide.with((FragmentActivity) this).load(this.profilepic).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.course_placeholder)).into(this.profileImage);
        }
        this.gender_Text.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.NewProfileActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                NewProfileActivity.this.popupFunction();
            }
        });
        this.ph_status_TextV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.NewProfileActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                NewProfileActivity.this.popupFunction1();
            }
        });
        this.caste_category_TextV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.NewProfileActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                NewProfileActivity.this.popupFunction2();
            }
        });
        final DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.appnew.android.Zoom.NewProfileActivity.5
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public void onDateSet(DatePicker view, int year, int month, int day) {
                NewProfileActivity.this.myCalendar.set(1, year);
                NewProfileActivity.this.myCalendar.set(2, month);
                NewProfileActivity.this.myCalendar.set(5, day);
                NewProfileActivity.this.updateLabel();
            }
        };
        this.date_of_birth_Text.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.NewProfileActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                NewProfileActivity newProfileActivity = NewProfileActivity.this;
                new DatePickerDialog(newProfileActivity, onDateSetListener, newProfileActivity.myCalendar.get(1), NewProfileActivity.this.myCalendar.get(2), NewProfileActivity.this.myCalendar.get(5)).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$0() {
        checkvalidation();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$1() {
        finish();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$2() {
        checkStoragePermission();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$3() {
        Intent intent = new Intent(this, Helper.setLoginCatActivity());
        intent.putExtra(Const.FRAG_TYPE, Const.FORGETPASSWORD);
        intent.putExtra(Const.RESET_PASS, true);
        intent.putExtra(Const.IS_CHANGE_PASS, true);
        startActivity(intent);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLabel() {
        this.date_of_birth_Text.setText(new SimpleDateFormat("dd/MM/yyyy", Locale.US).format(this.myCalendar.getTime()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void popupFunction() {
        this.profileMenu = "1";
        PopupMenu popupMenu = new PopupMenu(this, this.gender_Text, 3);
        for (int i = 0; i < this.genderArray.length; i++) {
            popupMenu.getMenu().add(this.genderArray[i]);
        }
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void popupFunction1() {
        this.profileMenu = "2";
        PopupMenu popupMenu = new PopupMenu(this, this.ph_status_TextV, 3);
        for (int i = 0; i < this.ph_Array.length; i++) {
            popupMenu.getMenu().add(this.ph_Array[i]);
        }
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void popupFunction2() {
        this.profileMenu = "3";
        PopupMenu popupMenu = new PopupMenu(this, this.caste_category_TextV, 3);
        for (int i = 0; i < this.cast_Array.length; i++) {
            popupMenu.getMenu().add(this.cast_Array[i]);
        }
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }

    private void checkvalidation() {
        if (!Helper.isStringValid(this.nameTV.getText().toString().trim())) {
            Toast.makeText(this, "name is not valid", 0).show();
            return;
        }
        if (!Helper.isStringValid(this.user_address_Text.getText().toString().trim())) {
            Toast.makeText(this, "Address is not valid", 0).show();
            return;
        }
        if (!Helper.isPinCodeValid(this.pin_code_Text.getText().toString().trim())) {
            Toast.makeText(this, "Pin Code is not valid", 0).show();
            return;
        }
        if (!Helper.isStringValid(this.date_of_birth_Text.getText().toString().trim())) {
            Toast.makeText(this, "Date Of Birth", 0).show();
            return;
        }
        if (!Helper.isStringValid(this.gender_Text.getText().toString().trim())) {
            Toast.makeText(this, "Please Insert Gender", 0).show();
            return;
        }
        if (!Helper.isStringValid(this.guardian_name_Text.getText().toString().trim())) {
            Toast.makeText(this, "Guardian name", 0).show();
            return;
        }
        if (!Helper.checkMobileNumber(this.guardian_number_Text.getText().toString().trim())) {
            Toast.makeText(this, "Guardian Contact  Number", 0).show();
            return;
        }
        if (!Helper.isStringValid(this.education_qualification_TextV.getText().toString().trim())) {
            Toast.makeText(this, "Education Qualification is not valid", 0).show();
            return;
        }
        if (!Helper.isStringValid(this.ph_status_TextV.getText().toString().trim())) {
            Toast.makeText(this, "PH is not valid", 0).show();
            return;
        }
        if (!Helper.checkMobileNumber(this.alternate_number_TextV.getText().toString().trim())) {
            Toast.makeText(this, "Alternate number", 0).show();
            return;
        }
        if (!Helper.isStringValid(this.caste_category_TextV.getText().toString().trim())) {
            Toast.makeText(this, "Cast is not valid", 0).show();
            return;
        }
        if (!Helper.isAdharValid(this.aadhar_card_TextV.getText().toString().trim())) {
            Toast.makeText(this, "Aadhar is not valid", 0).show();
            return;
        }
        if (!Helper.isStringValid(this.emailTV.getText().toString().trim())) {
            Toast.makeText(this, "email is not valid", 0).show();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(this.emailTV.getText().toString().trim()).matches()) {
            Toast.makeText(this, "email is not valid", 0).show();
            return;
        }
        if (this.isShowState && !Helper.isStringValid(this.stateSpinner.getText().toString())) {
            Toast.makeText(this, getResources().getString(R.string.please_select_state), 0).show();
            return;
        }
        String string = (this.districtSpinner.getVisibility() == 0 ? this.districtSpinner.getText() : this.etdistrictSpinner.getText()).toString();
        if (this.isShowState && (!Helper.isStringValid(string) || string.equalsIgnoreCase("District"))) {
            if (this.etdistrictSpinner.getVisibility() == 0) {
                Toast.makeText(this, "Please enter district", 0).show();
                return;
            } else {
                Toast.makeText(this, "Please select district", 0).show();
                return;
            }
        }
        if (this.isGSTIN && !TextUtils.isEmpty(this.gstnTV.getText().toString()) && !Helper.isValidGSTNo(this.gstnTV.getText().toString())) {
            Toast.makeText(this, getResources().getString(R.string.please_add_valid_gstin), 0).show();
        } else {
            hit_api_to_update_profile();
        }
    }

    private void hit_api_to_update_profile() {
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
            case "https://appapi.videocrypt.in/index.php/data_model/master_hit/get_cities":
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setState_id(this.SelectedStateid);
                return service.GetCity(AES.encrypt(new Gson().toJson(encryptionData)));
            case "https://appapi.videocrypt.in/index.php/data_model/master_hit/get_states":
                EncryptionData encryptionData2 = new EncryptionData();
                encryptionData2.setUser_id(MakeMyExam.getUserId());
                return service.GetState(AES.encrypt(new Gson().toJson(encryptionData2)));
            case "https://appapi.videocrypt.in/index.php/data_model/users/update_profile":
                EncryptionData encryptionData3 = new EncryptionData();
                encryptionData3.setName(this.nameTV.getText().toString());
                encryptionData3.setProfile_picture(this.profilepic);
                encryptionData3.setState(this.stateSpinner.getText().toString());
                encryptionData3.setCity((this.districtSpinner.getVisibility() == 0 ? this.districtSpinner.getText() : this.etdistrictSpinner.getText()).toString());
                encryptionData3.setAddress(this.user_address_Text.getText().toString());
                encryptionData3.setPin_code(this.pin_code_Text.getText().toString());
                encryptionData3.setDate_of_birth(this.date_of_birth_Text.getText().toString());
                encryptionData3.setGender(this.genderState);
                encryptionData3.setGstin(this.gstnTV.getText().toString());
                encryptionData3.setGuardian_name(this.guardian_name_Text.getText().toString());
                encryptionData3.setGuardian_number(this.guardian_number_Text.getText().toString());
                encryptionData3.setEducation_qualification(this.education_qualification_TextV.getText().toString());
                encryptionData3.setAadhar_card(this.aadhar_card_TextV.getText().toString());
                encryptionData3.setPh_status(this.ph_status_TextV.getText().toString());
                encryptionData3.setAlternate_number(this.alternate_number_TextV.getText().toString());
                encryptionData3.setCaste_category(this.caste_category_TextV.getText().toString());
                return service.updateprofile(AES.encrypt(new Gson().toJson(encryptionData3)));
            default:
                return null;
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        switch (apitype) {
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
                    } else {
                        this.districtSpinner.setVisibility(8);
                        this.downarrowIV2.setVisibility(4);
                        this.etdistrictSpinner.setVisibility(0);
                    }
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
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
            case "https://appapi.videocrypt.in/index.php/data_model/users/update_profile":
                try {
                    if (jsonstring.getBoolean("status")) {
                        this.data.setProfilePicture(this.profilepic);
                        this.data.setName(this.nameTV.getText().toString().trim());
                        this.data.setAddress(this.user_address_Text.getText().toString().trim());
                        this.data.setPin_code(this.pin_code_Text.getText().toString().trim());
                        this.data.setDate_of_birth(this.date_of_birth_Text.getText().toString().trim());
                        this.data.setGender(this.gender_Text.getText().toString().trim());
                        this.data.setGuardian_name(this.guardian_name_Text.getText().toString().trim());
                        this.data.setGuardian_number(this.guardian_number_Text.getText().toString().trim());
                        this.data.setEducation_qualification(this.education_qualification_TextV.getText().toString().trim());
                        this.data.setAadhar_card(this.aadhar_card_TextV.getText().toString().trim());
                        this.data.setPh_status(this.ph_status_TextV.getText().toString().trim());
                        this.data.setGstin(this.gstnTV.getText().toString().trim());
                        this.data.setAlternate_number(this.alternate_number_TextV.getText().toString().trim());
                        this.data.setCaste_category(this.caste_category_TextV.getText().toString().trim());
                        this.data.setState(this.stateSpinner.getText().toString().trim());
                        this.data.setCity((this.districtSpinner.getVisibility() == 0 ? this.districtSpinner.getText() : this.etdistrictSpinner.getText()).toString().trim());
                        SharedPreference.getInstance().setLoggedInUserr(this.data);
                        AnalyticEvents.INSTANCE.addUpdateCleverTapUser(this, true);
                        Toast.makeText(this, "Profile updated", 0).show();
                        finish();
                    } else {
                        Toast.makeText(this, "" + jsonstring.getString("message"), 0).show();
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
                Toast.makeText(this, jsonstring, 0).show();
                break;
        }
    }

    private void checkStoragePermission() {
        Dexter.withContext(this).withPermissions("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA").withListener(new MultiplePermissionsListener() { // from class: com.appnew.android.Zoom.NewProfileActivity.7
            @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                NewProfileActivity.this.imgClick();
            }

            @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                token.continuePermissionRequest();
            }
        }).check();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void imgClick() {
        final CharSequence[] charSequenceArr = {"Take Photo", "Choose from Gallery", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Photo!");
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: com.appnew.android.Zoom.NewProfileActivity$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$imgClick$4(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$imgClick$4(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals("Take Photo")) {
            try {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                Uri uriForFile = FileProvider.getUriForFile(this, "com.eduteria.app.app.provider", new File(getFilesDir(), "temp_image.jpg"));
                this.str_imgTypeClick = "PhotoCameraRequest";
                intent.putExtra("output", uriForFile);
                this.someActivityResultLauncher.launch(intent);
                this.requestCode = 10000;
                return;
            } catch (Exception unused) {
                return;
            }
        }
        if (charSequenceArr[i].equals("Choose from Gallery")) {
            Intent intent2 = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            Uri uriForFile2 = FileProvider.getUriForFile(this, "com.eduteria.app.app.provider", new File(getFilesDir(), "temp_gallery.jpg"));
            this.str_imgTypeClick = "PhotoGalleryRequest";
            intent2.putExtra("output", uriForFile2);
            this.someActivityResultLauncher.launch(intent2);
            this.requestCode = 20000;
            return;
        }
        if (charSequenceArr[i].equals("Cancel")) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$5(CropImageView.CropResult cropResult) {
        if (cropResult.isSuccessful()) {
            if (this.str_imgTypeClick.equalsIgnoreCase("PhotoCameraRequest")) {
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), cropResult.getUriContent());
                    String str = getFilesDir() + "/Utkarsh/ProfileImage/";
                    new File(str).mkdirs();
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(str + File.separator + (SharedPreference.getInstance().getLoggedInUser().getId() + "_" + Calendar.getInstance().getTimeInMillis() + ".jpg")));
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 30, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    this.s3IU = new s3ImageUploading("", "vc-10000386-38616500102/166/application/profile/", this, this, null);
                    ArrayList arrayList = new ArrayList();
                    MediaFile mediaFile = new MediaFile();
                    mediaFile.setFile_type("image");
                    mediaFile.setImage(bitmap);
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
                    String str2 = getFilesDir() + "/utkarsh/ProfileImage/";
                    new File(str2).mkdirs();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str2 + File.separator + (SharedPreference.getInstance().getLoggedInUser().getId() + "_" + Calendar.getInstance().getTimeInMillis() + ".jpg")));
                    bitmap2.compress(Bitmap.CompressFormat.JPEG, 30, fileOutputStream2);
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    this.s3IU = new s3ImageUploading("", "vc-10000386-38616500102/166/application/profile/", this, this, null);
                    ArrayList arrayList2 = new ArrayList();
                    MediaFile mediaFile2 = new MediaFile();
                    mediaFile2.setFile_type("image");
                    mediaFile2.setImage(bitmap2);
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
    public /* synthetic */ void lambda$new$6(ActivityResult activityResult) {
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.State /* 2131361927 */:
            case R.id.stateSpinner /* 2131365469 */:
                StatesCities statesCities = this.states;
                if (statesCities == null || statesCities.getData().size() == 0) {
                    Toast.makeText(this, "No State available", 0).show();
                } else {
                    this.clicktype = "1";
                    filterList("1", this.states);
                }
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
                            Toast.makeText(this, "Please select State First", 0).show();
                        }
                    }
                } else {
                    this.clicktype = "2";
                    filterList("2", this.cities);
                }
                break;
        }
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
            this.etSearch.setHint("Search State");
        } else if (searchType.equalsIgnoreCase("2")) {
            this.etSearch.setHint("Search District");
        }
        this.ivClearSearch = (ImageView) dialog.findViewById(R.id.iv_clear_search);
        TextView textView = (TextView) dialog.findViewById(R.id.tv_cancel);
        this.ivClearSearch.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.NewProfileActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$filterList$7(view);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.NewProfileActivity$$ExternalSyntheticLambda3
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
    public /* synthetic */ void lambda$filterList$7(View view) {
        this.etSearch.setText("");
    }

    public void textWatcher(final String searchType) {
        this.etSearch.addTextChangedListener(new TextWatcher() { // from class: com.appnew.android.Zoom.NewProfileActivity.8
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    NewProfileActivity.this.ivClearSearch.setVisibility(0);
                } else {
                    NewProfileActivity.this.ivClearSearch.setVisibility(8);
                }
                NewProfileActivity.this.filter(editable.toString(), searchType);
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
                    this.districtSpinner.setText("District");
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

    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem item) {
        if (this.profileMenu.equalsIgnoreCase("1")) {
            this.gender_Text.setText(item.getTitle());
            if (item.getTitle().equals("Male")) {
                this.genderState = "0";
            } else if (item.getTitle().equals("Female")) {
                this.genderState = "1";
            } else {
                this.genderState = "2";
            }
        } else if (this.profileMenu.equalsIgnoreCase("2")) {
            this.ph_status_TextV.setText(item.getTitle());
        }
        if (!this.profileMenu.equalsIgnoreCase("3")) {
            return false;
        }
        this.caste_category_TextV.setText(item.getTitle());
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
            myViewHolder.tvName.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.NewProfileActivity$StateCityAdapter$$ExternalSyntheticLambda0
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
                NewProfileActivity.this.onStateCityClick(this.searchType, statesCitiesData);
            } else if (str.equals("2")) {
                NewProfileActivity.this.onStateCityClick(this.searchType, statesCitiesData);
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
}
