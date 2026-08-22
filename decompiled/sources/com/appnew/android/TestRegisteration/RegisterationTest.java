package com.appnew.android.TestRegisteration;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
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
import android.view.ViewTreeObserver;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.COURSEDETAIL.CourseDetail;
import com.appnew.android.Model.CenterDataModel;
import com.appnew.android.Model.CentersData;
import com.appnew.android.Model.ClassStateAndCenterList;
import com.appnew.android.Model.Class_center;
import com.appnew.android.Model.Courses.Lists;
import com.appnew.android.Model.LeftMenu;
import com.appnew.android.Model.MediaFile;
import com.appnew.android.Model.StudentClass.StudentClassModel;
import com.appnew.android.Payment.PurchaseActivity;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.TestRegisteration.TimeSlotAdapter;
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
import com.appnew.android.databinding.ActivityRegisterationTestBinding;
import com.appnew.android.pojo.Userinfo.StatesCities.StatesCities;
import com.appnew.android.pojo.Userinfo.StatesCities.StatesCitiesData;
import com.appnew.android.table.ThemeSettings;
import com.bumptech.glide.Glide;
import com.canhub.cropper.CropImageContract;
import com.canhub.cropper.CropImageContractOptions;
import com.canhub.cropper.CropImageView;
import com.eduteria.app.app.R;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.paytm.pgsdk.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class RegisterationTest extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener, AmazonCallBack, TakeImageClass.imagefromcropper, NetworkCall.MyNetworkCallBack, TimeSlotAdapter.onButtonClicked {
    public static RegisterationTest instance;
    private Context activity;
    ActivityRegisterationTestBinding binding;
    private Calendar calendar;
    private CenterDataModel centerDataModel;
    StatesCities cities;
    StatesCities citiesPermanent;
    private CourseDetail courseDetail;
    EditText etSearch;
    ImageView ivClearSearch;
    LeftMenu leftMenu;
    public ArrayList<AppPermissionsRunTime.MyPermissionConstants> myPermissionConstantsArrayList;
    NetworkCall networkCall;
    private s3ImageUploading s3IU;
    RecyclerView searchRecyclerview;
    StateCityAdapter stateCityAdapter;
    StatesCities states;
    private String testCenterStrScr;
    private JSONArray testJsonArray;
    StatesCities center_states = new StatesCities();
    StatesCities test_states = new StatesCities();
    StatesCities test_cities = new StatesCities();
    StatesCities citiesTest = new StatesCities();
    String str_imgTypeClick = "";
    private int requestCode = -1;
    UtkashRoom utkashRoom = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
    public final int REQUEST_CODE_PERMISSION_MULTIPLE = 123;
    List<String> genderList = new ArrayList();
    List<String> studentForm = new ArrayList();
    List<String> casteList = new ArrayList();
    List<String> presentClass = new ArrayList();
    List<String> stream = new ArrayList();
    List<String> bloodGroups = new ArrayList();
    List<String> testCenter = new ArrayList();
    private String clicktype1 = "";
    String gender = "";
    private String caste = "";
    private int test_position = 0;
    String profilepic = "";
    String stateindex = "";
    String stateindexPermanent = "";
    String cityindex = "";
    String cityindexPermanent = "";
    String cityindexTest = "";
    String test_cityindexTest = "";
    private String SelectedStateid = "";
    private String SelectedStateidPermanent = "";
    private String SelectedCityid = "";
    private String SelectedCityidPermanent = "";
    private String SelectedCountryid = "";
    private String clicktype = "";
    private String time_selected = "";
    private String courseId = "";
    private String stateindexTest = "";
    private String test_stateindexTest = "";
    private String SelectedStateidTest = "";
    private String test_SelectedStateidTest = "";
    private String SelectedCityidTest = "";
    private String test_SelectedCityidTest = "";
    private String class_center_id = "";
    ArrayList<Class_center> centerArrayList = new ArrayList<>();
    private ArrayList<Class_center.Test_Center> testCenterList = new ArrayList<>();
    private String test_center_id = "";
    private String testId = "";
    private String end_date = "";
    private String start_date = "";
    private String startDate = "";
    private String endDate = "";
    ArrayList<JSONObject> testArrayList = new ArrayList<>();
    private boolean is_offline_test = true;
    private boolean is_offline_available = false;
    private boolean is_online_available = false;
    ArrayList<Lists> test_list = new ArrayList<>();
    private String test_id = "";
    private String test_name = "";
    private String price = "";
    private String tax_rate = "0";
    private String is_gst = "0";
    ArrayList<ClassStateAndCenterList> class_centerArrayList = new ArrayList<>();
    ArrayList<ClassStateAndCenterList> test_centerArrayList = new ArrayList<>();
    private boolean isCheckedWhatsapp = true;
    private String cat_type = "";
    boolean isKeyboardShowing = false;
    private ActivityResultLauncher<CropImageContractOptions> cropImage = registerForActivityResult(new CropImageContract(), new ActivityResultCallback() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda46
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.f$0.lambda$new$50((CropImageView.CropResult) obj);
        }
    });
    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda47
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.f$0.lambda$new$51((ActivityResult) obj);
        }
    });
    ArrayList<StatesCitiesData> statesCitiesArrayList = new ArrayList<>();

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    @Override // com.appnew.android.Utils.imagecropper.TakeImageClass.imagefromcropper
    public void imagePath(String str) {
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
            this.etSearch.setHint(this.activity.getResources().getString(R.string.search_city));
        } else if (searchType.equalsIgnoreCase("3")) {
            this.etSearch.setHint(this.activity.getResources().getString(R.string.search_state));
        } else if (searchType.equalsIgnoreCase("4")) {
            this.etSearch.setHint(this.activity.getResources().getString(R.string.search_city));
        } else if (searchType.equalsIgnoreCase("5")) {
            this.etSearch.setHint(this.activity.getResources().getString(R.string.search_state));
        } else if (searchType.equalsIgnoreCase("6")) {
            this.etSearch.setHint(this.activity.getResources().getString(R.string.search_city));
        } else if (searchType.equalsIgnoreCase("7")) {
            this.etSearch.setHint(this.activity.getResources().getString(R.string.search_state));
        } else if (searchType.equalsIgnoreCase("8")) {
            this.etSearch.setHint(this.activity.getResources().getString(R.string.search_city));
        }
        this.ivClearSearch = (ImageView) dialog.findViewById(R.id.iv_clear_search);
        TextView textView = (TextView) dialog.findViewById(R.id.tv_cancel);
        this.ivClearSearch.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$filterList$0(view);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda22
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
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialog2) {
                RegisterationTest.this.binding.fragmentTestSignInFormFour.stateET.setClickable(true);
                RegisterationTest.this.binding.fragmentTestSignInFormThree.stateRL.setClickable(true);
                RegisterationTest.this.binding.fragmentTestSignInFormThree.testStateRL.setClickable(true);
                RegisterationTest.this.binding.fragmentTestSignInFormThree.testCityRL.setClickable(true);
                RegisterationTest.this.binding.fragmentTestSignInFormFour.permanentStateET.setClickable(true);
                RegisterationTest.this.binding.fragmentTestSignInFormFour.cityET.setClickable(true);
                RegisterationTest.this.binding.fragmentTestSignInFormFour.permanentCityET.setClickable(true);
                RegisterationTest.this.binding.fragmentTestSignInFormThree.cityRL.setClickable(true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$filterList$0(View view) {
        this.etSearch.setText("");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        instance = null;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRegisterationTestBinding activityRegisterationTestBindingInflate = ActivityRegisterationTestBinding.inflate(getLayoutInflater());
        this.binding = activityRegisterationTestBindingInflate;
        setContentView(activityRegisterationTestBindingInflate.getRoot());
        instance = this;
        this.activity = this;
        this.networkCall = new NetworkCall(this, this);
        this.calendar = Calendar.getInstance();
        CourseDetail courseDetail = (CourseDetail) getIntent().getSerializableExtra(Const.SINGLE_STUDY);
        this.courseDetail = courseDetail;
        this.courseId = courseDetail != null ? courseDetail.getData().getCourseDetail().getId() : "";
        CourseDetail courseDetail2 = this.courseDetail;
        this.cat_type = courseDetail2 != null ? courseDetail2.getData().getCourseDetail().getCat_type() : "";
        String stringExtra = getIntent().getStringExtra("test_data");
        this.test_id = getIntent().getStringExtra("test_id");
        try {
            if (TextUtils.isEmpty(stringExtra)) {
                this.testJsonArray = new JSONArray();
            } else {
                this.testJsonArray = new JSONArray(stringExtra);
            }
        } catch (JSONException e2) {
            Log.d(Constants.EVENT_ACTION_ERROR, e2.toString());
        }
        if (this.utkashRoom.getthemeSettingdao().is_setting_exit()) {
            ThemeSettings themeSettingsData = this.utkashRoom.getthemeSettingdao().data();
            if (themeSettingsData.getLeft_menu() != null) {
                this.leftMenu = (LeftMenu) new Gson().fromJson(themeSettingsData.getLeft_menu(), LeftMenu.class);
            }
        }
        LeftMenu leftMenu = this.leftMenu;
        if (leftMenu != null) {
            if (leftMenu.getDisable_name_edit().equalsIgnoreCase("0") || this.leftMenu.getDisable_name_edit().equalsIgnoreCase("")) {
                this.binding.fragmentTestSignInForm.nameTV.setEnabled(true);
            } else {
                this.binding.fragmentTestSignInForm.nameTV.setEnabled(false);
            }
        }
        adjust();
        initViews();
    }

    void onKeyboardVisibilityChanged(boolean opened) {
        if (opened) {
            this.binding.fragmentTestSignInForm.llBottom.setVisibility(8);
            this.binding.fragmentTestSignInFormTwo.llBottom.setVisibility(8);
            this.binding.fragmentTestSignInFormFour.llBottom.setVisibility(8);
        } else {
            this.binding.fragmentTestSignInForm.llBottom.setVisibility(0);
            this.binding.fragmentTestSignInFormTwo.llBottom.setVisibility(0);
            this.binding.fragmentTestSignInFormFour.llBottom.setVisibility(0);
        }
    }

    private void adjust() {
        this.binding.registrationLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                RegisterationTest.this.binding.registrationLayout.getWindowVisibleDisplayFrame(new Rect());
                if (r1 - r0.bottom > ((double) RegisterationTest.this.binding.registrationLayout.getRootView().getHeight()) * 0.15d) {
                    if (RegisterationTest.this.isKeyboardShowing) {
                        return;
                    }
                    RegisterationTest.this.isKeyboardShowing = true;
                    RegisterationTest.this.onKeyboardVisibilityChanged(true);
                    return;
                }
                if (RegisterationTest.this.isKeyboardShowing) {
                    RegisterationTest.this.isKeyboardShowing = false;
                    RegisterationTest.this.onKeyboardVisibilityChanged(false);
                }
            }
        });
    }

    private void initViews() {
        this.binding.fragmentTestSignInFormThree.ivBack.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda33
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$2(view);
            }
        });
        this.binding.fragmentTestSignInFormThree.testSlotRV.setHasFixedSize(true);
        this.binding.fragmentTestSignInFormThree.testSlotRV.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.binding.fragmentTestSignInFormThree.testSlotRV.setNestedScrollingEnabled(false);
        this.binding.fragmentTestSignInFormThree.testSlotRV.setVisibility(0);
        if (!this.cat_type.equalsIgnoreCase("5") && this.testJsonArray != null) {
            for (int i = 0; i < this.testJsonArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = this.testJsonArray.optJSONObject(i);
                if (jSONObjectOptJSONObject.optString("id").equalsIgnoreCase(this.test_id)) {
                    this.test_position = i;
                    if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has(Const.TEST_TYPE)) {
                        this.is_offline_test = jSONObjectOptJSONObject.optString(Const.TEST_TYPE).equalsIgnoreCase("1");
                    } else {
                        this.is_offline_test = false;
                    }
                }
                if (jSONObjectOptJSONObject.optString(Const.TEST_TYPE).equalsIgnoreCase("1")) {
                    this.is_offline_available = true;
                } else {
                    this.is_online_available = true;
                }
            }
            boolean z = this.is_offline_available;
            if (z && !this.is_online_available) {
                this.binding.fragmentTestSignInFormThree.rbOffline.setVisibility(8);
                this.binding.fragmentTestSignInFormThree.rbOnline.setVisibility(8);
            } else if (!z && this.is_online_available) {
                this.binding.fragmentTestSignInFormThree.rbOffline.setVisibility(8);
                this.binding.fragmentTestSignInFormThree.rbOnline.setVisibility(8);
            } else if (z && this.is_online_available) {
                this.binding.fragmentTestSignInFormThree.rbOffline.setClickable(true);
                this.binding.fragmentTestSignInFormThree.rbOnline.setClickable(true);
            }
            if (this.is_offline_test) {
                this.binding.fragmentTestSignInFormThree.rbOffline.setChecked(true);
                this.is_offline_test = true;
                this.binding.fragmentTestSignInFormThree.llCenterDetail.setVisibility(0);
                this.binding.fragmentTestSignInFormThree.llTestCenter.setVisibility(0);
                this.binding.fragmentTestSignInFormThree.testCenterTV.setText("");
                this.binding.fragmentTestSignInFormThree.classroomCenetrTV.setText("");
                this.testId = "";
                this.test_name = "";
                this.centerArrayList.clear();
                this.testCenterList.clear();
                this.class_center_id = "";
                this.test_center_id = "";
                CenterDataModel centerDataModel = this.centerDataModel;
                if (centerDataModel == null || centerDataModel.getData() == null) {
                    hit_api_to_centerData();
                }
            } else {
                this.binding.fragmentTestSignInFormThree.rbOnline.setChecked(true);
                this.binding.fragmentTestSignInFormThree.llCenterDetail.setVisibility(0);
                this.binding.fragmentTestSignInFormThree.llTestCenter.setVisibility(8);
                this.binding.fragmentTestSignInFormThree.testCenterTV.setText("");
                this.binding.fragmentTestSignInFormThree.classroomCenetrTV.setText("");
                this.testId = "";
                this.test_name = "";
                this.centerArrayList.clear();
                this.class_center_id = "";
                this.test_center_id = "0";
                CenterDataModel centerDataModel2 = this.centerDataModel;
                if (centerDataModel2 == null || centerDataModel2.getData() == null) {
                    hit_api_to_centerData();
                }
            }
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < this.testJsonArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject2 = this.testJsonArray.optJSONObject(i2);
                if (this.is_offline_test) {
                    if (jSONObjectOptJSONObject2.optString(Const.TEST_TYPE).equalsIgnoreCase("1")) {
                        jSONArray.put(jSONObjectOptJSONObject2);
                    }
                } else if (!jSONObjectOptJSONObject2.optString(Const.TEST_TYPE).equalsIgnoreCase("1")) {
                    jSONArray.put(jSONObjectOptJSONObject2);
                }
            }
            this.binding.fragmentTestSignInFormThree.testSlotRV.setAdapter(new TimeSlotAdapter(this, jSONArray, this, this.test_id));
        }
        if (this.cat_type.equalsIgnoreCase("5")) {
            this.binding.fragmentTestSignInFormThree.svMain.setVisibility(8);
            this.binding.fragmentTestSignInForm.svMain.setVisibility(0);
            this.binding.fragmentTestSignInForm.previousBtn.setVisibility(8);
            this.binding.fragmentTestSignInForm.viewBottom.setVisibility(8);
            this.binding.fragmentTestSignInForm.llBottomPrice.setVisibility(0);
            this.binding.fragmentTestSignInForm.paymentStepProgress.setVisibility(8);
            this.binding.fragmentTestSignInForm.paymentStepProgress1.setVisibility(0);
            this.binding.fragmentTestSignInFormTwo.paymentStepProgress.setVisibility(8);
            this.binding.fragmentTestSignInFormTwo.paymentStepProgress1.setVisibility(0);
            this.binding.fragmentTestSignInFormFour.paymentStepProgress.setVisibility(8);
            this.binding.fragmentTestSignInFormFour.paymentStepProgress1.setVisibility(0);
            CourseDetail courseDetail = this.courseDetail;
            if (courseDetail != null && courseDetail.getData() != null && this.courseDetail.getData().getCourseDetail() != null) {
                this.price = this.courseDetail.getData().getCourseDetail().getMrp();
                this.is_gst = this.courseDetail.getData().getCourseDetail().getIs_gst();
                this.tax_rate = this.courseDetail.getData().getCourseDetail().getTax();
                this.time_selected = "";
                this.binding.fragmentTestSignInForm.pricetext.setText(String.format("%s %s %s", com.appnew.android.home.Constants.currencyType, "" + String.format("%.2f", Double.valueOf(Double.parseDouble(this.price) + Double.parseDouble(this.tax_rate))), "/-"));
                String str = this.is_gst;
                if (str != null && !str.equalsIgnoreCase("")) {
                    if (this.is_gst.equalsIgnoreCase("0")) {
                        this.binding.fragmentTestSignInForm.gstTeg.setText(getResources().getString(R.string.include_gst_new));
                    } else {
                        this.binding.fragmentTestSignInForm.gstTeg.setText(getResources().getString(R.string.exclude_gst_new));
                        this.binding.fragmentTestSignInForm.pricetext.setText(String.format("%s %s %s", com.appnew.android.home.Constants.currencyType, "" + ((int) Float.parseFloat(this.price)), "/-"));
                    }
                } else {
                    this.binding.fragmentTestSignInForm.gstTeg.setText("N/A");
                }
            } else {
                this.binding.fragmentTestSignInForm.llBottomPrice.setVisibility(4);
            }
        }
        this.binding.fragmentTestSignInFormThree.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest.3
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) RegisterationTest.this.findViewById(checkedId);
                if (radioButton.getId() == R.id.rb_online) {
                    RegisterationTest.this.is_offline_test = false;
                    RegisterationTest.this.resetCenterData();
                    RegisterationTest.this.binding.fragmentTestSignInFormThree.llCenterDetail.setVisibility(0);
                    RegisterationTest.this.binding.fragmentTestSignInFormThree.llTestCenter.setVisibility(8);
                    RegisterationTest.this.testId = "";
                    RegisterationTest.this.test_name = "";
                    RegisterationTest.this.centerArrayList.clear();
                    RegisterationTest.this.class_center_id = "";
                    RegisterationTest.this.test_center_id = "0";
                    if (RegisterationTest.this.centerDataModel == null || RegisterationTest.this.centerDataModel.getData() == null) {
                        RegisterationTest.this.hit_api_to_centerData();
                    }
                } else {
                    RegisterationTest.this.is_offline_test = true;
                    RegisterationTest.this.resetCenterData();
                    RegisterationTest.this.binding.fragmentTestSignInFormThree.llCenterDetail.setVisibility(0);
                    RegisterationTest.this.binding.fragmentTestSignInFormThree.llTestCenter.setVisibility(0);
                    RegisterationTest.this.testId = "";
                    RegisterationTest.this.test_name = "";
                    RegisterationTest.this.centerArrayList.clear();
                    RegisterationTest.this.testCenterList.clear();
                    RegisterationTest.this.class_center_id = "";
                    RegisterationTest.this.test_center_id = "";
                    if (RegisterationTest.this.centerDataModel == null || RegisterationTest.this.centerDataModel.getData() == null) {
                        RegisterationTest.this.hit_api_to_centerData();
                    }
                }
                radioButton.setChecked(true);
                JSONArray jSONArray2 = new JSONArray();
                for (int i3 = 0; i3 < RegisterationTest.this.testJsonArray.length(); i3++) {
                    JSONObject jSONObjectOptJSONObject3 = RegisterationTest.this.testJsonArray.optJSONObject(i3);
                    if (RegisterationTest.this.is_offline_test) {
                        if (jSONObjectOptJSONObject3.optString(Const.TEST_TYPE).equalsIgnoreCase("1")) {
                            jSONArray2.put(jSONObjectOptJSONObject3);
                        }
                    } else if (!jSONObjectOptJSONObject3.optString(Const.TEST_TYPE).equalsIgnoreCase("1")) {
                        jSONArray2.put(jSONObjectOptJSONObject3);
                    }
                }
                RegisterationTest registerationTest = RegisterationTest.this;
                RegisterationTest.this.binding.fragmentTestSignInFormThree.testSlotRV.setAdapter(new TimeSlotAdapter(registerationTest, jSONArray2, registerationTest, ""));
            }
        });
        this.binding.fragmentTestSignInFormTwo.ivBack.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$3(view);
            }
        });
        this.binding.fragmentTestSignInForm.ivBack.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$4(view);
            }
        });
        this.binding.fragmentTestSignInFormFour.ivBack.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda29
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$5(view);
            }
        });
        this.binding.fragmentTestSignInFormThree.buyNowBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda39
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$6(view);
            }
        });
        this.binding.fragmentTestSignInFormTwo.buyNowBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$7(view);
            }
        });
        this.binding.fragmentTestSignInForm.buyNowBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda41
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$8(view);
            }
        });
        this.binding.fragmentTestSignInFormFour.buyNowBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda42
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$9(view);
            }
        });
        this.binding.fragmentTestSignInForm.previousBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda43
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$10(view);
            }
        });
        this.binding.fragmentTestSignInFormTwo.previousBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda45
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$11(view);
            }
        });
        this.binding.fragmentTestSignInFormFour.previousBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda44
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$12(view);
            }
        });
        this.binding.fragmentTestSignInForm.dobRl.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda48
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$13(view);
            }
        });
        this.binding.fragmentTestSignInForm.dobTV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda49
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$14(view);
            }
        });
        this.binding.fragmentTestSignInForm.downArrowIV1.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda50
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$15(view);
            }
        });
        this.binding.fragmentTestSignInForm.downarrowGenderIV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda51
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$16(view);
            }
        });
        this.binding.fragmentTestSignInForm.genderSpinner.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda52
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$17(view);
            }
        });
        this.binding.fragmentTestSignInForm.Gender.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$18(view);
            }
        });
        this.binding.fragmentTestSignInForm.downarrowbloodGroupIV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$19(view);
            }
        });
        this.binding.fragmentTestSignInForm.bloodGroupSpinner.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$20(view);
            }
        });
        this.binding.fragmentTestSignInForm.BloodGroup.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$21(view);
            }
        });
        this.binding.fragmentTestSignInForm.casteSpinner.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$22(view);
            }
        });
        this.binding.fragmentTestSignInForm.Caste.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$23(view);
            }
        });
        this.binding.fragmentTestSignInForm.downarrowCasteIV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$24(view);
            }
        });
        this.binding.fragmentTestSignInForm.studentFormTextView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$25(view);
            }
        });
        this.binding.fragmentTestSignInForm.naraynaRelative.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$26(view);
            }
        });
        this.binding.fragmentTestSignInForm.selectStudentDropDown.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$27(view);
            }
        });
        this.binding.fragmentTestSignInForm.presentClassRelative.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$28(view);
            }
        });
        this.binding.fragmentTestSignInForm.presentClassTextView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$29(view);
            }
        });
        this.binding.fragmentTestSignInForm.presentClassDropDown.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$30(view);
            }
        });
        this.binding.fragmentTestSignInForm.rlChooshPhoto.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$31(view);
            }
        });
        this.binding.fragmentTestSignInFormThree.stateRL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$32(view);
            }
        });
        this.binding.fragmentTestSignInFormThree.classroomRL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$33(view);
            }
        });
        this.binding.fragmentTestSignInFormThree.classroomCenetrTV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$34(view);
            }
        });
        this.binding.fragmentTestSignInFormThree.downarrowClassroomIV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$35(view);
            }
        });
        this.binding.fragmentTestSignInFormThree.testCenterRL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$36(view);
            }
        });
        this.binding.fragmentTestSignInFormThree.testCenterTV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$37(view);
            }
        });
        this.binding.fragmentTestSignInFormThree.downarrowTestCenterIV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda25
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$38(view);
            }
        });
        this.binding.fragmentTestSignInFormThree.testRL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda26
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$39(view);
            }
        });
        this.binding.fragmentTestSignInFormThree.scholorshipTestTV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda27
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$40(view);
            }
        });
        this.binding.fragmentTestSignInFormThree.downarrowTestIV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$41(view);
            }
        });
        this.binding.fragmentTestSignInFormFour.stateET.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda30
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$42(view);
            }
        });
        this.binding.fragmentTestSignInFormThree.stateRL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda31
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$43(view);
            }
        });
        this.binding.fragmentTestSignInFormThree.testStateRL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda32
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$44(view);
            }
        });
        this.binding.fragmentTestSignInFormThree.testCityRL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$45(view);
            }
        });
        this.binding.fragmentTestSignInFormFour.permanentStateET.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda35
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$46(view);
            }
        });
        this.binding.fragmentTestSignInFormFour.cityET.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda36
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$47(view);
            }
        });
        this.binding.fragmentTestSignInFormFour.permanentCityET.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda37
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$48(view);
            }
        });
        this.binding.fragmentTestSignInFormThree.cityRL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda38
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$49(view);
            }
        });
        this.binding.fragmentTestSignInForm.nameTV.setFilters(new InputFilter[]{new InputFilter() { // from class: com.appnew.android.TestRegisteration.RegisterationTest.4
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int start, int end, Spanned dest, int dstart, int dend) {
                return (charSequence.equals("") || charSequence.toString().matches("[a-z A-Z ]+")) ? charSequence : "";
            }
        }});
        this.binding.fragmentTestSignInFormTwo.fatherNameET.setFilters(new InputFilter[]{new InputFilter() { // from class: com.appnew.android.TestRegisteration.RegisterationTest.5
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int start, int end, Spanned dest, int dstart, int dend) {
                return (charSequence.equals("") || charSequence.toString().matches("[a-z A-Z ]+")) ? charSequence : "";
            }
        }});
        this.binding.fragmentTestSignInFormTwo.motherNameET.setFilters(new InputFilter[]{new InputFilter() { // from class: com.appnew.android.TestRegisteration.RegisterationTest.6
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int start, int end, Spanned dest, int dstart, int dend) {
                return (charSequence.equals("") || charSequence.toString().matches("[a-z A-Z ]+")) ? charSequence : "";
            }
        }});
        this.binding.fragmentTestSignInForm.checkboxWhatsaap.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest.7
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                RegisterationTest.this.isCheckedWhatsapp = true;
                if (isChecked) {
                    RegisterationTest.this.binding.fragmentTestSignInForm.tvWhattsappHint.setVisibility(8);
                    RegisterationTest.this.binding.fragmentTestSignInForm.whattspNumberTv.setVisibility(8);
                    RegisterationTest.this.binding.fragmentTestSignInForm.whattspNumberTv.setText(RegisterationTest.this.binding.fragmentTestSignInForm.mobileTV.getText().toString());
                } else {
                    RegisterationTest.this.binding.fragmentTestSignInForm.tvWhattsappHint.setVisibility(0);
                    RegisterationTest.this.binding.fragmentTestSignInForm.whattspNumberTv.setVisibility(0);
                    RegisterationTest.this.binding.fragmentTestSignInForm.whattspNumberTv.setText("");
                }
            }
        });
        this.binding.fragmentTestSignInFormFour.pinCodeET.addTextChangedListener(new TextWatcher() { // from class: com.appnew.android.TestRegisteration.RegisterationTest.8
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (RegisterationTest.this.binding.fragmentTestSignInFormFour.checkboxAddress.isChecked()) {
                    RegisterationTest.this.binding.fragmentTestSignInFormFour.permanentPinCodeET.setText(RegisterationTest.this.binding.fragmentTestSignInFormFour.pinCodeET.getText().toString());
                }
            }
        });
        this.binding.fragmentTestSignInFormFour.streetAddressET.addTextChangedListener(new TextWatcher() { // from class: com.appnew.android.TestRegisteration.RegisterationTest.9
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (RegisterationTest.this.binding.fragmentTestSignInFormFour.checkboxAddress.isChecked()) {
                    RegisterationTest.this.binding.fragmentTestSignInFormFour.permanentStreetAddressET.setText(RegisterationTest.this.binding.fragmentTestSignInFormFour.streetAddressET.getText().toString());
                }
            }
        });
        this.binding.fragmentTestSignInForm.emailTV.setText(SharedPreference.getInstance().getLoggedInUser().getEmail());
        this.binding.fragmentTestSignInForm.mobileTV.setText(SharedPreference.getInstance().getLoggedInUser().getMobile());
        this.binding.fragmentTestSignInFormFour.checkboxAddress.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest.10
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    RegisterationTest registerationTest = RegisterationTest.this;
                    registerationTest.citiesPermanent = registerationTest.cities;
                    RegisterationTest registerationTest2 = RegisterationTest.this;
                    registerationTest2.cityindexPermanent = registerationTest2.cityindex;
                    RegisterationTest.this.binding.fragmentTestSignInFormFour.permanentStreetAddressET.setText(RegisterationTest.this.binding.fragmentTestSignInFormFour.streetAddressET.getText().toString());
                    RegisterationTest.this.binding.fragmentTestSignInFormFour.permanentCityET.setText(RegisterationTest.this.binding.fragmentTestSignInFormFour.cityET.getText().toString());
                    RegisterationTest.this.binding.fragmentTestSignInFormFour.permanentStateET.setText(RegisterationTest.this.binding.fragmentTestSignInFormFour.stateET.getText().toString());
                    RegisterationTest.this.binding.fragmentTestSignInFormFour.permanentPinCodeET.setText(RegisterationTest.this.binding.fragmentTestSignInFormFour.pinCodeET.getText().toString());
                    RegisterationTest.this.binding.fragmentTestSignInFormFour.permanentStreetAddressET.setEnabled(false);
                    RegisterationTest.this.binding.fragmentTestSignInFormFour.permanentCityET.setEnabled(false);
                    RegisterationTest.this.binding.fragmentTestSignInFormFour.permanentStateET.setEnabled(false);
                    RegisterationTest.this.binding.fragmentTestSignInFormFour.permanentPinCodeET.setEnabled(false);
                    RegisterationTest.this.binding.fragmentTestSignInFormFour.permanentStreetAddressET.setClickable(false);
                    RegisterationTest.this.binding.fragmentTestSignInFormFour.permanentCityET.setClickable(false);
                    RegisterationTest.this.binding.fragmentTestSignInFormFour.permanentStateET.setClickable(false);
                    RegisterationTest.this.binding.fragmentTestSignInFormFour.permanentPinCodeET.setClickable(false);
                    return;
                }
                RegisterationTest.this.binding.fragmentTestSignInFormFour.permanentStreetAddressET.setEnabled(true);
                RegisterationTest.this.binding.fragmentTestSignInFormFour.permanentCityET.setEnabled(true);
                RegisterationTest.this.binding.fragmentTestSignInFormFour.permanentStateET.setEnabled(true);
                RegisterationTest.this.binding.fragmentTestSignInFormFour.permanentPinCodeET.setEnabled(true);
                RegisterationTest.this.binding.fragmentTestSignInFormFour.permanentStreetAddressET.setClickable(true);
                RegisterationTest.this.binding.fragmentTestSignInFormFour.permanentCityET.setClickable(true);
                RegisterationTest.this.binding.fragmentTestSignInFormFour.permanentStateET.setClickable(true);
                RegisterationTest.this.binding.fragmentTestSignInFormFour.permanentPinCodeET.setClickable(true);
                RegisterationTest.this.cityindexPermanent = "";
                RegisterationTest.this.stateindexPermanent = "";
                RegisterationTest.this.SelectedStateidPermanent = "";
                RegisterationTest.this.SelectedCityidPermanent = "";
                RegisterationTest.this.binding.fragmentTestSignInFormFour.permanentStateET.setText("");
                RegisterationTest.this.binding.fragmentTestSignInFormFour.permanentCityET.setText("");
                RegisterationTest.this.binding.fragmentTestSignInFormFour.permanentPinCodeET.setText("");
                RegisterationTest.this.binding.fragmentTestSignInFormFour.permanentStreetAddressET.setText("");
            }
        });
        this.binding.fragmentTestSignInForm.nameTV.setText(SharedPreference.getInstance().getLoggedInUser().getName());
        if (SharedPreference.getInstance().getTestUser() == null || SharedPreference.getInstance().getTestUser().getMobile() == null || TextUtils.isEmpty(SharedPreference.getInstance().getTestUser().getMobile())) {
            return;
        }
        EncryptionData testUser = SharedPreference.getInstance().getTestUser();
        this.binding.fragmentTestSignInForm.nameTV.setText(testUser.getName());
        this.binding.fragmentTestSignInForm.emailTV.setText(testUser.getEmail());
        this.binding.fragmentTestSignInForm.dobTV.setText(testUser.getDob());
        this.binding.fragmentTestSignInForm.genderSpinner.setText(testUser.getGender());
        this.binding.fragmentTestSignInForm.mobileTV.setText(testUser.getMobile());
        this.binding.fragmentTestSignInForm.whattspNumberTv.setText(testUser.getWhatsapp_no());
        this.binding.fragmentTestSignInForm.bloodGroupSpinner.setText(testUser.getBlood_group());
        this.binding.fragmentTestSignInForm.casteSpinner.setText(testUser.getCategory());
        this.binding.fragmentTestSignInForm.aadharTV.setText(testUser.getAadhar_no());
        this.binding.fragmentTestSignInForm.studentFormTextView.setText(testUser.getNr_student());
        this.binding.fragmentTestSignInForm.lastStudentIdTv.setText(testUser.getNr_id());
        this.binding.fragmentTestSignInForm.lastStudentIdTv.setText(testUser.getNr_id());
        this.binding.fragmentTestSignInForm.presentClassTextView.setText(testUser.getP_class());
        this.binding.fragmentTestSignInForm.lastSchoolNameTV.setText(testUser.getC_l_s_name());
        this.binding.fragmentTestSignInFormTwo.fatherNameET.setText(testUser.getFather_name());
        this.binding.fragmentTestSignInFormTwo.fatherContectET.setText(testUser.getF_mobile_no());
        this.binding.fragmentTestSignInFormTwo.fatherOccupationET.setText(testUser.getF_occupation());
        this.binding.fragmentTestSignInFormTwo.motherNameET.setText(testUser.getMother_name());
        this.binding.fragmentTestSignInFormTwo.motherContactET.setText(testUser.getM_mobile_no() != null ? testUser.getM_mobile_no() : "");
        this.binding.fragmentTestSignInFormTwo.motherOccupationET.setText(testUser.getM_occupation());
        this.binding.fragmentTestSignInFormFour.streetAddressET.setText(testUser.getAddress());
        this.binding.fragmentTestSignInFormFour.cityET.setText(testUser.getCity());
        this.binding.fragmentTestSignInFormFour.stateET.setText(testUser.getState());
        this.binding.fragmentTestSignInFormFour.pinCodeET.setText(testUser.getPincode());
        this.binding.fragmentTestSignInFormFour.permanentStreetAddressET.setText(testUser.getP_address());
        this.binding.fragmentTestSignInFormFour.permanentCityET.setText(testUser.getP_city());
        this.binding.fragmentTestSignInFormFour.permanentStateET.setText(testUser.getP_state());
        this.binding.fragmentTestSignInFormFour.permanentPinCodeET.setText(testUser.getP_pincode());
        this.binding.fragmentTestSignInFormFour.checkboxAddress.setChecked(testUser.getIs_address_same_permanent().equalsIgnoreCase("1"));
        this.binding.fragmentTestSignInForm.checkboxWhatsaap.setChecked(testUser.getIs_same_whatsapp_no().equalsIgnoreCase("1"));
        this.isCheckedWhatsapp = true;
        if (testUser.getIs_same_whatsapp_no().equalsIgnoreCase("0")) {
            this.binding.fragmentTestSignInForm.tvWhattsappHint.setVisibility(0);
            this.binding.fragmentTestSignInForm.whattspNumberTv.setVisibility(0);
        } else {
            this.binding.fragmentTestSignInForm.tvWhattsappHint.setVisibility(8);
            this.binding.fragmentTestSignInForm.whattspNumberTv.setVisibility(8);
        }
        this.profilepic = testUser.getImage();
        this.caste = testUser.getCategory();
        Glide.with((FragmentActivity) this).load(testUser.getImage()).placeholder(com.appnew.android.R.drawable.user_profile).error(com.appnew.android.R.drawable.user_profile).into(this.binding.fragmentTestSignInForm.profileImage);
        if (testUser.getNr_id() != null && !TextUtils.isEmpty(testUser.getNr_id())) {
            this.binding.fragmentTestSignInForm.tvStudentIdHint.setVisibility(0);
            this.binding.fragmentTestSignInForm.lastStudentIdTv.setVisibility(0);
        } else {
            this.binding.fragmentTestSignInForm.tvStudentIdHint.setVisibility(8);
            this.binding.fragmentTestSignInForm.lastStudentIdTv.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$2(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$3(View view) {
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$4(View view) {
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$5(View view) {
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$6(View view) {
        Helper.hideKeyboard(this);
        if (checkValidationForFormThree()) {
            this.binding.fragmentTestSignInForm.svMain.setVisibility(0);
            this.binding.fragmentTestSignInFormTwo.svMain.setVisibility(8);
            this.binding.fragmentTestSignInFormFour.svMain.setVisibility(8);
            this.binding.fragmentTestSignInFormThree.svMain.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$7(View view) {
        Helper.hideKeyboard(this);
        if (checkValidationForFormTwo()) {
            StatesCities statesCities = this.states;
            if (statesCities == null || statesCities.getData() == null || this.states.getData().size() == 0) {
                hit_api_to_get_state();
            }
            this.binding.fragmentTestSignInForm.svMain.setVisibility(8);
            this.binding.fragmentTestSignInFormTwo.svMain.setVisibility(8);
            this.binding.fragmentTestSignInFormFour.svMain.setVisibility(0);
            this.binding.fragmentTestSignInFormThree.svMain.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$8(View view) {
        Helper.hideKeyboard(this);
        if (checkValidationForFormOne()) {
            this.binding.fragmentTestSignInForm.svMain.setVisibility(8);
            this.binding.fragmentTestSignInFormTwo.svMain.setVisibility(0);
            this.binding.fragmentTestSignInFormThree.svMain.setVisibility(8);
            this.binding.fragmentTestSignInFormFour.svMain.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$9(View view) {
        Helper.hideKeyboard(this);
        if (checkValidationForFormFour()) {
            hit_api_to_set_data();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$10(View view) {
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$11(View view) {
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$12(View view) {
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$13(View view) {
        openDatePickerDialog(this, this.binding.fragmentTestSignInForm.dobTV, this.calendar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$14(View view) {
        openDatePickerDialog(this, this.binding.fragmentTestSignInForm.dobTV, this.calendar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$15(View view) {
        openDatePickerDialog(this, this.binding.fragmentTestSignInForm.dobTV, this.calendar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$16(View view) {
        selectGender();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$17(View view) {
        selectGender();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$18(View view) {
        selectGender();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$19(View view) {
        selectBloodGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$20(View view) {
        selectBloodGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$21(View view) {
        selectBloodGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$22(View view) {
        selectCast();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$23(View view) {
        selectCast();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$24(View view) {
        selectCast();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$25(View view) {
        selectStudentForm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$26(View view) {
        selectStudentForm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$27(View view) {
        selectStudentForm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$28(View view) {
        selectPresentClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$29(View view) {
        selectPresentClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$30(View view) {
        selectPresentClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$31(View view) {
        checkStoragePermission();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$32(View view) {
        selectClassRoomCenter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$33(View view) {
        selectClassRoomCenter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$34(View view) {
        selectClassRoomCenter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$35(View view) {
        selectClassRoomCenter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$36(View view) {
        selectTestCenter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$37(View view) {
        selectTestCenter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$38(View view) {
        selectTestCenter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$39(View view) {
        selectStream();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$40(View view) {
        selectStream();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$41(View view) {
        selectStream();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$42(View view) {
        Helper.hideKeyboard(this);
        StatesCities statesCities = this.states;
        if (statesCities == null || statesCities.getData().size() == 0) {
            Context context = this.activity;
            Toast.makeText(context, context.getResources().getString(R.string.no_state_available), 0).show();
        } else {
            this.binding.fragmentTestSignInFormFour.stateET.setClickable(false);
            this.clicktype = "1";
            filterList("1", this.states);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$43(View view) {
        Helper.hideKeyboard(this);
        ArrayList<ClassStateAndCenterList> arrayList = this.class_centerArrayList;
        if (arrayList == null || arrayList.size() == 0) {
            Context context = this.activity;
            Toast.makeText(context, context.getResources().getString(R.string.no_state_available), 0).show();
            return;
        }
        this.binding.fragmentTestSignInFormThree.stateRL.setClickable(false);
        this.clicktype = "5";
        ArrayList arrayList2 = new ArrayList();
        for (ClassStateAndCenterList classStateAndCenterList : this.class_centerArrayList) {
            StatesCitiesData statesCitiesData = new StatesCitiesData();
            statesCitiesData.setId(classStateAndCenterList.getId());
            statesCitiesData.setName(classStateAndCenterList.getName());
            statesCitiesData.setShortname(classStateAndCenterList.getName());
            arrayList2.add(statesCitiesData);
        }
        this.center_states.setData(arrayList2);
        filterList(this.clicktype, this.center_states);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$44(View view) {
        Helper.hideKeyboard(this);
        ArrayList<ClassStateAndCenterList> arrayList = this.test_centerArrayList;
        if (arrayList == null || arrayList.size() == 0) {
            Context context = this.activity;
            Toast.makeText(context, context.getResources().getString(R.string.no_state_available), 0).show();
            return;
        }
        this.binding.fragmentTestSignInFormThree.testStateRL.setClickable(false);
        this.clicktype = "7";
        ArrayList arrayList2 = new ArrayList();
        for (ClassStateAndCenterList classStateAndCenterList : this.test_centerArrayList) {
            StatesCitiesData statesCitiesData = new StatesCitiesData();
            statesCitiesData.setId(classStateAndCenterList.getId());
            statesCitiesData.setName(classStateAndCenterList.getName());
            statesCitiesData.setShortname(classStateAndCenterList.getName());
            arrayList2.add(statesCitiesData);
        }
        this.test_states.setData(arrayList2);
        filterList(this.clicktype, this.test_states);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$45(View view) {
        Helper.hideKeyboard(this);
        String str = this.test_SelectedStateidTest;
        if (str == null || TextUtils.isEmpty(str)) {
            Toast.makeText(this.activity, "Please select state first", 0).show();
            return;
        }
        this.clicktype = "8";
        for (ClassStateAndCenterList classStateAndCenterList : this.test_centerArrayList) {
            if (classStateAndCenterList.getId().equalsIgnoreCase(this.test_SelectedStateidTest)) {
                this.binding.fragmentTestSignInFormThree.testCityRL.setClickable(false);
                ArrayList arrayList = new ArrayList();
                for (ClassStateAndCenterList.CityAndCenter cityAndCenter : classStateAndCenterList.getCity()) {
                    StatesCitiesData statesCitiesData = new StatesCitiesData();
                    statesCitiesData.setId(cityAndCenter.getId());
                    statesCitiesData.setName(cityAndCenter.getName());
                    statesCitiesData.setShortname(cityAndCenter.getName());
                    arrayList.add(statesCitiesData);
                }
                this.test_cities.setData(arrayList);
                filterList(this.clicktype, this.test_cities);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$46(View view) {
        Helper.hideKeyboard(this);
        StatesCities statesCities = this.states;
        if (statesCities == null || statesCities.getData().size() == 0) {
            Context context = this.activity;
            Toast.makeText(context, context.getResources().getString(R.string.no_state_available), 0).show();
        } else {
            this.binding.fragmentTestSignInFormFour.permanentStateET.setClickable(false);
            this.clicktype = "3";
            filterList("3", this.states);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$47(View view) {
        Helper.hideKeyboard(this);
        StatesCities statesCities = this.cities;
        if (statesCities == null || statesCities.getData().size() == 0) {
            Toast.makeText(this.activity, "Please select state first", 0).show();
            return;
        }
        this.binding.fragmentTestSignInFormFour.cityET.setClickable(false);
        this.clicktype = "2";
        filterList("2", this.cities);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$48(View view) {
        Helper.hideKeyboard(this);
        StatesCities statesCities = this.citiesPermanent;
        if (statesCities == null || statesCities.getData().size() == 0) {
            Toast.makeText(this.activity, "Please select state first", 0).show();
            return;
        }
        this.binding.fragmentTestSignInFormFour.permanentCityET.setClickable(false);
        this.clicktype = "4";
        filterList("4", this.citiesPermanent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$49(View view) {
        Helper.hideKeyboard(this);
        String str = this.SelectedStateidTest;
        if (str == null || TextUtils.isEmpty(str)) {
            Toast.makeText(this.activity, "Please select state first", 0).show();
            return;
        }
        this.clicktype = "6";
        for (ClassStateAndCenterList classStateAndCenterList : this.class_centerArrayList) {
            if (classStateAndCenterList.getId().equalsIgnoreCase(this.SelectedStateidTest)) {
                this.binding.fragmentTestSignInFormThree.cityRL.setClickable(false);
                ArrayList arrayList = new ArrayList();
                for (ClassStateAndCenterList.CityAndCenter cityAndCenter : classStateAndCenterList.getCity()) {
                    StatesCitiesData statesCitiesData = new StatesCitiesData();
                    statesCitiesData.setId(cityAndCenter.getId());
                    statesCitiesData.setName(cityAndCenter.getName());
                    statesCitiesData.setShortname(cityAndCenter.getName());
                    arrayList.add(statesCitiesData);
                }
                this.citiesTest.setData(arrayList);
                filterList(this.clicktype, this.citiesTest);
                return;
            }
        }
    }

    private void selectStream() {
        Helper.hideKeyboard(this);
        if (!Helper.isNetworkConnected(this.activity)) {
            Helper.showInternetToast(this.activity);
            return;
        }
        PopupMenu popupMenu = new PopupMenu(this, this.binding.fragmentTestSignInFormThree.testRL, 3);
        this.stream.clear();
        this.stream.add("NEET");
        this.stream.add("Foundation");
        this.stream.add("JEE");
        Iterator<String> it = this.stream.iterator();
        while (it.hasNext()) {
            popupMenu.getMenu().add(it.next());
        }
        this.clicktype1 = "9";
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetCenterData() {
        this.cityindexTest = "";
        this.binding.fragmentTestSignInFormThree.classroomCenetrTV.setText("");
        this.binding.fragmentTestSignInFormThree.testCenterTV.setText("");
        this.centerArrayList.clear();
        this.class_center_id = "";
        this.stateindexTest = "";
        this.SelectedStateidTest = "";
        this.binding.fragmentTestSignInFormThree.stateET.setText("");
        this.binding.fragmentTestSignInFormThree.cityET.setText("");
        this.SelectedCityidTest = "";
        this.binding.fragmentTestSignInFormThree.testStateET.setText("");
        this.binding.fragmentTestSignInFormThree.testCityET.setText("");
        this.test_SelectedCityidTest = "";
        this.test_SelectedStateidTest = "";
        this.test_cityindexTest = "";
        this.test_stateindexTest = "";
    }

    private boolean checkValidationForFormThree() {
        if (!Helper.isNullChek(this.class_center_id)) {
            Toast.makeText(this.activity, "Please select classroom center address", 0).show();
            return false;
        }
        if (!Helper.isNullChek(this.test_center_id)) {
            Toast.makeText(this.activity, "Please select test center address", 0).show();
            return false;
        }
        if (Helper.isNullChek(this.time_selected)) {
            return true;
        }
        Toast.makeText(this.activity, "Please select test time slot", 0).show();
        return false;
    }

    private boolean checkValidationForFormTwo() {
        if (TextUtils.isEmpty(this.binding.fragmentTestSignInFormTwo.fatherNameET.getText().toString().trim())) {
            this.binding.fragmentTestSignInFormTwo.fatherNameET.requestFocus();
            Toast.makeText(this.activity, "Please enter father's name", 0).show();
            return false;
        }
        if (!Helper.isNullChek(this.binding.fragmentTestSignInFormTwo.fatherContectET.getText().toString().trim())) {
            this.binding.fragmentTestSignInFormTwo.fatherContectET.requestFocus();
            Toast.makeText(this.activity, "Please enter parent's mobile 1", 0).show();
            return false;
        }
        if (!Helper.checkMobileNumber(this.binding.fragmentTestSignInFormTwo.fatherContectET.getText().toString()) || this.binding.fragmentTestSignInFormTwo.fatherContectET.getText().toString().startsWith("0") || this.binding.fragmentTestSignInFormTwo.fatherContectET.getText().toString().startsWith("1") || this.binding.fragmentTestSignInFormTwo.fatherContectET.getText().toString().trim().length() != 10) {
            this.binding.fragmentTestSignInFormTwo.fatherContectET.requestFocus();
            Toast.makeText(this.activity, "Invalid mobile number", 0).show();
            return false;
        }
        if (!Helper.isNullChek(this.binding.fragmentTestSignInFormTwo.motherNameET.getText().toString().trim())) {
            this.binding.fragmentTestSignInFormTwo.motherNameET.requestFocus();
            Toast.makeText(this.activity, "Please enter mother's name", 0).show();
            return false;
        }
        if ((TextUtils.isEmpty(this.binding.fragmentTestSignInFormTwo.motherContactET.getText().toString().trim()) || Helper.checkMobileNumber(this.binding.fragmentTestSignInFormTwo.motherContactET.getText().toString())) && !this.binding.fragmentTestSignInFormTwo.motherContactET.getText().toString().startsWith("0") && !this.binding.fragmentTestSignInFormTwo.motherContactET.getText().toString().startsWith("1") && (TextUtils.isEmpty(this.binding.fragmentTestSignInFormTwo.motherContactET.getText().toString().trim()) || this.binding.fragmentTestSignInFormTwo.motherContactET.getText().toString().trim().length() == 10)) {
            return true;
        }
        this.binding.fragmentTestSignInFormTwo.motherContactET.requestFocus();
        Toast.makeText(this.activity, "Invalid mobile number", 0).show();
        return false;
    }

    private boolean checkValidationForFormFour() {
        if (TextUtils.isEmpty(this.binding.fragmentTestSignInFormFour.streetAddressET.getText().toString())) {
            Toast.makeText(this.activity, "Please enter street address", 0).show();
            this.binding.fragmentTestSignInFormFour.streetAddressET.requestFocus();
            return false;
        }
        if (!Helper.isNullChek(this.binding.fragmentTestSignInFormFour.stateET.getText().toString().trim())) {
            Toast.makeText(this.activity, "Please select state", 0).show();
            return false;
        }
        if (!Helper.isNullChek(this.binding.fragmentTestSignInFormFour.cityET.getText().toString().trim())) {
            Toast.makeText(this.activity, "Please select city", 0).show();
            return false;
        }
        if (!Helper.isNullChek(this.binding.fragmentTestSignInFormFour.pinCodeET.getText().toString().trim())) {
            Toast.makeText(this.activity, "Please enter pin code", 0).show();
            return false;
        }
        if (this.binding.fragmentTestSignInFormFour.pinCodeET.getText().toString().length() != 6 || this.binding.fragmentTestSignInFormFour.pinCodeET.getText().toString().startsWith("0")) {
            this.binding.fragmentTestSignInFormFour.pinCodeET.requestFocus();
            Toast.makeText(this.activity, "Invalid pin code", 0).show();
            return false;
        }
        if (!Helper.isNullChek(this.binding.fragmentTestSignInFormFour.permanentStreetAddressET.getText().toString().trim())) {
            Toast.makeText(this.activity, "Please enter street address", 0).show();
            return false;
        }
        if (!Helper.isNullChek(this.binding.fragmentTestSignInFormFour.permanentStateET.getText().toString().trim())) {
            Toast.makeText(this.activity, "Please select state", 0).show();
            return false;
        }
        if (!Helper.isNullChek(this.binding.fragmentTestSignInFormFour.permanentCityET.getText().toString().trim())) {
            Toast.makeText(this.activity, "Please select city", 0).show();
            return false;
        }
        if (!Helper.isNullChek(this.binding.fragmentTestSignInFormFour.permanentPinCodeET.getText().toString().trim())) {
            Toast.makeText(this.activity, "Please enter pin code", 0).show();
            this.binding.fragmentTestSignInFormFour.permanentPinCodeET.requestFocus();
            return false;
        }
        if (this.binding.fragmentTestSignInFormFour.permanentPinCodeET.getText().toString().length() == 6) {
            return true;
        }
        this.binding.fragmentTestSignInFormFour.permanentPinCodeET.requestFocus();
        Toast.makeText(this.activity, "Invalid pin code", 0).show();
        return false;
    }

    private boolean checkValidationForFormOne() {
        if (TextUtils.isEmpty(this.binding.fragmentTestSignInForm.nameTV.getText().toString().trim())) {
            this.binding.fragmentTestSignInForm.nameTV.requestFocus();
            Toast.makeText(this.activity, "Please enter name", 0).show();
            return false;
        }
        if (!Helper.isNullChek(this.binding.fragmentTestSignInForm.emailTV.getText().toString().trim())) {
            this.binding.fragmentTestSignInForm.emailTV.requestFocus();
            Toast.makeText(this.activity, "Please enter email", 0).show();
            return false;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(this.binding.fragmentTestSignInForm.emailTV.getText().toString().trim()).matches()) {
            this.binding.fragmentTestSignInForm.emailTV.requestFocus();
            Toast.makeText(this.activity, "Invalid email", 0).show();
            return false;
        }
        if (!Helper.isNullChek(this.binding.fragmentTestSignInForm.mobileTV.getText().toString().trim())) {
            this.binding.fragmentTestSignInForm.mobileTV.requestFocus();
            Toast.makeText(this.activity, "Please enter mobile number", 0).show();
            return false;
        }
        if (this.binding.fragmentTestSignInForm.mobileTV.getText().toString().startsWith("0") || this.binding.fragmentTestSignInForm.mobileTV.getText().toString().startsWith("1") || this.binding.fragmentTestSignInForm.mobileTV.getText().toString().trim().length() != 10) {
            this.binding.fragmentTestSignInForm.mobileTV.requestFocus();
            Toast.makeText(this.activity, "Invalid mobile number", 0).show();
            return false;
        }
        if (!this.isCheckedWhatsapp) {
            Toast.makeText(this.activity, "Please confirm whatsapp number is same as mobile number or not?", 0).show();
            return false;
        }
        if (!Helper.isNullChek(this.binding.fragmentTestSignInForm.whattspNumberTv.getText().toString().trim())) {
            this.binding.fragmentTestSignInForm.whattspNumberTv.requestFocus();
            Toast.makeText(this.activity, "Please enter whatsapp number", 0).show();
            return false;
        }
        if (this.binding.fragmentTestSignInForm.whattspNumberTv.getText().toString().startsWith("0") || this.binding.fragmentTestSignInForm.whattspNumberTv.getText().toString().startsWith("1") || this.binding.fragmentTestSignInForm.whattspNumberTv.getText().toString().trim().length() != 10) {
            this.binding.fragmentTestSignInForm.whattspNumberTv.requestFocus();
            Toast.makeText(this.activity, "Invalid whatsapp number", 0).show();
            return false;
        }
        if (!Helper.isNullChek(this.binding.fragmentTestSignInForm.dobTV.getText().toString().trim())) {
            Toast.makeText(this.activity, "Please select DOB", 0).show();
            return false;
        }
        if (!Helper.isNullChek(this.binding.fragmentTestSignInForm.genderSpinner.getText().toString().trim())) {
            Toast.makeText(this.activity, "Please select gender", 0).show();
            return false;
        }
        if (!Helper.isNullChek(this.binding.fragmentTestSignInForm.casteSpinner.getText().toString().trim())) {
            Toast.makeText(this.activity, "Please select category", 0).show();
            return false;
        }
        if (!Helper.isNullChek(this.binding.fragmentTestSignInForm.aadharTV.getText().toString().trim())) {
            this.binding.fragmentTestSignInForm.aadharTV.requestFocus();
            Toast.makeText(this.activity, "Please enter aadhaar number", 0).show();
            return false;
        }
        if (!Helper.isValidAadhaarNumber(this.binding.fragmentTestSignInForm.aadharTV.getText().toString().trim())) {
            this.binding.fragmentTestSignInForm.aadharTV.requestFocus();
            Toast.makeText(this.activity, "Invalid aadhaar number", 0).show();
            return false;
        }
        if (!Helper.isNullChek(this.binding.fragmentTestSignInForm.studentFormTextView.getText().toString().trim())) {
            Toast.makeText(this.activity, "Are you ex student of narayana", 0).show();
            return false;
        }
        if (this.binding.fragmentTestSignInForm.studentFormTextView.getText().toString().equalsIgnoreCase("Yes") && !Helper.isNullChek(this.binding.fragmentTestSignInForm.lastStudentIdTv.getText().toString().trim())) {
            Toast.makeText(this.activity, "Please enter student id", 0).show();
            return false;
        }
        if (!Helper.isNullChek(this.binding.fragmentTestSignInForm.presentClassTextView.getText().toString())) {
            Toast.makeText(this.activity, "Please select current class", 0).show();
            return false;
        }
        if (!Helper.isNullChek(this.binding.fragmentTestSignInForm.lastSchoolNameTV.getText().toString())) {
            this.binding.fragmentTestSignInForm.lastSchoolNameTV.requestFocus();
            Toast.makeText(this.activity, "Please enter current/last school name", 0).show();
            return false;
        }
        if (Helper.isNullChek(this.profilepic)) {
            return true;
        }
        Toast.makeText(this.activity, "Please upload profile photo", 0).show();
        return false;
    }

    public void openDatePickerDialog(Context context, final TextView dobTV, final Calendar c2) {
        Helper.hideKeyboard(this);
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest.11
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                dobTV.setText(new StringBuilder().append(dayOfMonth).append(MqttTopic.TOPIC_LEVEL_SEPARATOR).append(monthOfYear + 1).append(MqttTopic.TOPIC_LEVEL_SEPARATOR).append(year).append(" "));
                c2.set(1, year);
                c2.set(2, monthOfYear);
                c2.set(5, dayOfMonth);
                Helper.enableErrorInTextview(RegisterationTest.this.binding.fragmentTestSignInForm.tvDobError, null);
            }
        }, c2.get(1), c2.get(2), c2.get(5));
        Calendar calendar = Calendar.getInstance();
        calendar.add(1, -8);
        datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());
        datePickerDialog.show();
    }

    private void selectStudentForm() {
        Helper.hideKeyboard(this);
        if (!Helper.isNetworkConnected(this.activity)) {
            Helper.showInternetToast(this.activity);
            return;
        }
        PopupMenu popupMenu = new PopupMenu(this, this.binding.fragmentTestSignInForm.naraynaRelative, 3);
        this.studentForm.clear();
        this.studentForm.add("Yes");
        this.studentForm.add("No");
        Iterator<String> it = this.studentForm.iterator();
        while (it.hasNext()) {
            popupMenu.getMenu().add(it.next());
        }
        this.clicktype1 = "3";
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }

    private void selectGender() {
        Helper.hideKeyboard(this);
        if (!Helper.isNetworkConnected(this.activity)) {
            Helper.showInternetToast(this.activity);
            return;
        }
        PopupMenu popupMenu = new PopupMenu(this, this.binding.fragmentTestSignInForm.Gender, 3);
        this.genderList.clear();
        this.genderList.add("Male");
        this.genderList.add("Female");
        this.genderList.add("Other");
        Iterator<String> it = this.genderList.iterator();
        while (it.hasNext()) {
            popupMenu.getMenu().add(it.next());
        }
        this.clicktype1 = "1";
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }

    private void selectCast() {
        Helper.hideKeyboard(this);
        if (!Helper.isNetworkConnected(this.activity)) {
            Helper.showInternetToast(this.activity);
            return;
        }
        PopupMenu popupMenu = new PopupMenu(this, this.binding.fragmentTestSignInForm.Caste, 3);
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

    private void selectPresentClass() {
        Helper.hideKeyboard(this);
        if (!Helper.isNetworkConnected(this.activity)) {
            Helper.showInternetToast(this.activity);
            return;
        }
        PopupMenu popupMenu = new PopupMenu(this, this.binding.fragmentTestSignInForm.presentClassRelative, 3);
        this.presentClass.clear();
        if (SharedPreference.getInstance().getString("Student_List") != null || !SharedPreference.getInstance().getString("Student_List").equalsIgnoreCase("")) {
            StudentClassModel studentClassModel = (StudentClassModel) new Gson().fromJson(SharedPreference.getInstance().getString("Student_List"), StudentClassModel.class);
            if (studentClassModel.getData().size() > 0) {
                for (int i = 0; i < studentClassModel.getData().size(); i++) {
                    this.presentClass.add(studentClassModel.getData().get(i).getClassX());
                }
            }
        }
        Iterator<String> it = this.presentClass.iterator();
        while (it.hasNext()) {
            popupMenu.getMenu().add(it.next());
        }
        this.clicktype1 = "4";
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }

    private void selectBloodGroup() {
        Helper.hideKeyboard(this);
        if (!Helper.isNetworkConnected(this.activity)) {
            Helper.showInternetToast(this.activity);
            return;
        }
        PopupMenu popupMenu = new PopupMenu(this, this.binding.fragmentTestSignInForm.BloodGroup, 3);
        this.bloodGroups.clear();
        this.bloodGroups.add("A+");
        this.bloodGroups.add("A-");
        this.bloodGroups.add("B+");
        this.bloodGroups.add("B-");
        this.bloodGroups.add("O+");
        this.bloodGroups.add("O-");
        this.bloodGroups.add("AB+");
        this.bloodGroups.add("AB-");
        Iterator<String> it = this.bloodGroups.iterator();
        while (it.hasNext()) {
            popupMenu.getMenu().add(it.next());
        }
        this.clicktype1 = "5";
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }

    private void selectClassRoomCenter() {
        Helper.hideKeyboard(this);
        if (!Helper.isNetworkConnected(this.activity)) {
            Helper.showInternetToast(this.activity);
            return;
        }
        if (TextUtils.isEmpty(this.SelectedStateidTest)) {
            Toast.makeText(this.activity, "Select State First", 0).show();
            return;
        }
        if (TextUtils.isEmpty(this.SelectedCityidTest)) {
            Toast.makeText(this.activity, "Select City First", 0).show();
            return;
        }
        if (this.centerArrayList.size() == 1) {
            if (TextUtils.isEmpty(this.class_center_id)) {
                this.binding.fragmentTestSignInFormThree.classroomCenetrTV.setText(this.centerArrayList.get(0).getName());
                this.class_center_id = this.centerArrayList.get(0).getClass_center_id();
                if (!this.is_offline_test) {
                    this.test_center_id = "0";
                }
                ArrayList arrayList = new ArrayList();
                for (ClassStateAndCenterList classStateAndCenterList : this.test_centerArrayList) {
                    StatesCitiesData statesCitiesData = new StatesCitiesData();
                    statesCitiesData.setId(classStateAndCenterList.getId());
                    statesCitiesData.setName(classStateAndCenterList.getName());
                    statesCitiesData.setShortname(classStateAndCenterList.getName());
                    arrayList.add(statesCitiesData);
                }
                this.test_states.setData(arrayList);
                return;
            }
            return;
        }
        PopupMenu popupMenu = new PopupMenu(this, this.binding.fragmentTestSignInFormThree.classroomRL, 3);
        Iterator<Class_center> it = this.centerArrayList.iterator();
        while (it.hasNext()) {
            popupMenu.getMenu().add(it.next().getName());
        }
        this.clicktype1 = "6";
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }

    private void selectTestCenter() {
        Helper.hideKeyboard(this);
        if (!Helper.isNetworkConnected(this.activity)) {
            Helper.showInternetToast(this.activity);
            return;
        }
        if (TextUtils.isEmpty(this.test_SelectedStateidTest)) {
            Toast.makeText(this.activity, "Select State First", 0).show();
            return;
        }
        if (TextUtils.isEmpty(this.test_SelectedCityidTest)) {
            Toast.makeText(this.activity, "Select City First", 0).show();
            return;
        }
        PopupMenu popupMenu = new PopupMenu(this, this.binding.fragmentTestSignInFormThree.testCenterRL, 3);
        if (this.testCenterList.size() == 1) {
            if (this.test_center_id.equalsIgnoreCase(this.testCenterList.get(0).getTest_center_id())) {
                return;
            }
            this.binding.fragmentTestSignInFormThree.testCenterTV.setText(this.testCenterList.get(0).getName());
            this.test_center_id = this.testCenterList.get(0).getTest_center_id();
            this.binding.fragmentTestSignInFormThree.rlCenterAddress.setVisibility(0);
            this.binding.fragmentTestSignInFormThree.tvTestCenterAdd.setVisibility(0);
            if (!TextUtils.isEmpty(this.testCenterList.get(0).getLocation())) {
                this.binding.fragmentTestSignInFormThree.testCenterAddressTV.setText(this.testCenterList.get(0).getAddress() + "\n" + this.testCenterList.get(0).getLocation());
            } else {
                this.binding.fragmentTestSignInFormThree.testCenterAddressTV.setText(this.testCenterList.get(0).getAddress());
            }
            hit_api_to_check_slot();
            return;
        }
        Iterator<Class_center.Test_Center> it = this.testCenterList.iterator();
        while (it.hasNext()) {
            popupMenu.getMenu().add(it.next().getName());
        }
        this.clicktype1 = "7";
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }

    @Override // android.widget.PopupMenu.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        if (this.clicktype1.equalsIgnoreCase("1")) {
            for (String str : this.genderList) {
                if (str.equalsIgnoreCase(menuItem.getTitle().toString())) {
                    this.binding.fragmentTestSignInForm.genderSpinner.setText(str);
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
                    this.binding.fragmentTestSignInForm.casteSpinner.setText(str2);
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
        if (this.clicktype1.equalsIgnoreCase("3")) {
            for (String str3 : this.studentForm) {
                if (str3.equalsIgnoreCase(menuItem.getTitle().toString())) {
                    this.binding.fragmentTestSignInForm.studentFormTextView.setText(str3);
                    if (str3.equalsIgnoreCase("Yes")) {
                        this.binding.fragmentTestSignInForm.tvStudentIdHint.setVisibility(0);
                        this.binding.fragmentTestSignInForm.lastStudentIdTv.setVisibility(0);
                    } else {
                        this.binding.fragmentTestSignInForm.tvStudentIdHint.setVisibility(8);
                        this.binding.fragmentTestSignInForm.lastStudentIdTv.setVisibility(8);
                        this.binding.fragmentTestSignInForm.lastStudentIdTv.setText("");
                    }
                }
            }
        }
        if (this.clicktype1.equalsIgnoreCase("9")) {
            for (String str4 : this.stream) {
                if (str4.equalsIgnoreCase(menuItem.getTitle().toString())) {
                    this.binding.fragmentTestSignInFormThree.scholorshipTestTV.setText(str4);
                }
            }
        }
        if (this.clicktype1.equalsIgnoreCase("4")) {
            for (String str5 : this.presentClass) {
                if (str5.equalsIgnoreCase(menuItem.getTitle().toString())) {
                    this.binding.fragmentTestSignInForm.presentClassTextView.setText(str5);
                }
            }
        }
        if (this.clicktype1.equalsIgnoreCase("5")) {
            for (String str6 : this.bloodGroups) {
                if (str6.equalsIgnoreCase(menuItem.getTitle().toString())) {
                    this.binding.fragmentTestSignInForm.bloodGroupSpinner.setText(str6);
                }
            }
        }
        if (this.clicktype1.equalsIgnoreCase("6")) {
            for (Class_center class_center : this.centerArrayList) {
                if (class_center.getName().equalsIgnoreCase(menuItem.getTitle().toString())) {
                    this.binding.fragmentTestSignInFormThree.classroomCenetrTV.setText(class_center.getName());
                    this.class_center_id = class_center.getClass_center_id();
                    if (!this.is_offline_test) {
                        this.test_center_id = "0";
                    }
                    ArrayList arrayList = new ArrayList();
                    for (ClassStateAndCenterList classStateAndCenterList : this.test_centerArrayList) {
                        StatesCitiesData statesCitiesData = new StatesCitiesData();
                        statesCitiesData.setId(classStateAndCenterList.getId());
                        statesCitiesData.setName(classStateAndCenterList.getName());
                        statesCitiesData.setShortname(classStateAndCenterList.getName());
                        arrayList.add(statesCitiesData);
                    }
                    this.test_states.setData(arrayList);
                }
            }
        }
        if (this.clicktype1.equalsIgnoreCase("7")) {
            for (Class_center.Test_Center test_Center : this.testCenterList) {
                if (test_Center.getName().equalsIgnoreCase(menuItem.getTitle().toString())) {
                    this.binding.fragmentTestSignInFormThree.testCenterTV.setText(test_Center.getName());
                    this.test_center_id = test_Center.getTest_center_id();
                    this.binding.fragmentTestSignInFormThree.rlCenterAddress.setVisibility(0);
                    this.binding.fragmentTestSignInFormThree.tvTestCenterAdd.setVisibility(0);
                    this.binding.fragmentTestSignInFormThree.testCenterAddressTV.setText(test_Center.getAddress());
                    hit_api_to_check_slot();
                }
            }
        }
        return false;
    }

    private void checkStoragePermission() {
        Dexter.withContext(this).withPermissions("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA").withListener(new MultiplePermissionsListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest.12
            @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                RegisterationTest.this.imgClick();
            }

            @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                token.continuePermissionRequest();
            }
        }).check();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$50(CropImageView.CropResult cropResult) {
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
    public /* synthetic */ void lambda$new$51(ActivityResult activityResult) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void imgClick() {
        final CharSequence[] charSequenceArr = {getResources().getString(R.string.take_photo), getResources().getString(R.string.choose_from_gallery), getResources().getString(R.string.cancel)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.add_photo));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$imgClick$52(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$imgClick$52(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
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

    @Override // com.appnew.android.Utils.AmazonUpload.AmazonCallBack
    public void onS3UploadData(ArrayList<MediaFile> images) {
        if (images == null || images.isEmpty()) {
            return;
        }
        this.profilepic = images.get(0).getFile();
        Glide.with((FragmentActivity) this).load(this.profilepic).placeholder(com.appnew.android.R.drawable.user_profile).error(com.appnew.android.R.drawable.user_profile).into(this.binding.fragmentTestSignInForm.profileImage);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        switch (apitype) {
            case "data_model/post/check_seat_availavlity":
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setTest_center_id(this.test_center_id);
                encryptionData.setTest_id(this.test_id);
                return service.getSeatAvailability(AES.encrypt(new Gson().toJson(encryptionData)));
            case "https://appapi.videocrypt.in/index.php/data_model/master_hit/get_cities":
                EncryptionData encryptionData2 = new EncryptionData();
                encryptionData2.setState_id(this.clicktype.equalsIgnoreCase("3") ? this.SelectedStateidPermanent : this.clicktype.equalsIgnoreCase("5") ? this.SelectedStateidTest : this.clicktype.equalsIgnoreCase("7") ? this.test_SelectedStateidTest : this.SelectedStateid);
                return service.GetCity(AES.encrypt(new Gson().toJson(encryptionData2)));
            case "https://appapi.videocrypt.in/index.php/data_model/master_hit/get_states":
                EncryptionData encryptionData3 = new EncryptionData();
                if (!TextUtils.isEmpty(this.SelectedCountryid)) {
                    encryptionData3.setCountry_id(this.SelectedCountryid);
                }
                return service.GetState(AES.encrypt(new Gson().toJson(encryptionData3)));
            case "data_model/post/center_lists":
                EncryptionData encryptionData4 = new EncryptionData();
                encryptionData4.setTest_id(this.test_id);
                return service.getCenterList(AES.encrypt(new Gson().toJson(encryptionData4)));
            default:
                return null;
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        switch (apitype) {
            case "data_model/post/add_scholarship_form":
                if (jsonstring.getBoolean("status")) {
                    Intent intent = new Intent(this.activity, (Class<?>) PurchaseActivity.class);
                    intent.putExtra(Const.SINGLE_STUDY, (CourseDetail) getIntent().getSerializableExtra(Const.SINGLE_STUDY));
                    intent.putExtra("is_load_form", false);
                    intent.putExtra(Const.IS_BOOK, getIntent().getStringExtra(Const.IS_BOOK));
                    intent.putExtra(Const.DELIVERY_CHARGE, getIntent().getStringExtra(Const.DELIVERY_CHARGE));
                    Helper.gotoActivity(intent, this);
                    finish();
                    break;
                } else {
                    Toast.makeText(this, jsonstring.getString("message").toString(), 0).show();
                    break;
                }
                break;
            case "data_model/post/check_seat_availavlity":
                if (!jsonstring.getBoolean("status")) {
                    Toast.makeText(this, jsonstring.getString("message").toString(), 0).show();
                    this.binding.fragmentTestSignInFormThree.testCenterTV.setText("");
                    this.binding.fragmentTestSignInFormThree.testCenterAddressTV.setText("");
                    this.binding.fragmentTestSignInFormThree.rlCenterAddress.setVisibility(8);
                    this.binding.fragmentTestSignInFormThree.tvTestCenterAdd.setVisibility(8);
                    this.test_center_id = "";
                    if (this.testCenterList.size() == 1) {
                        this.testCenterList.clear();
                        this.test_SelectedCityidTest = "";
                        this.test_cityindexTest = "";
                        this.binding.fragmentTestSignInFormThree.testCityET.setText("");
                    }
                    break;
                }
                break;
            case "https://appapi.videocrypt.in/index.php/data_model/master_hit/get_cities":
                if (jsonstring.getBoolean("status")) {
                    if (this.clicktype.equalsIgnoreCase("3")) {
                        this.citiesPermanent = (StatesCities) new Gson().fromJson(jsonstring.toString(), StatesCities.class);
                    } else if (this.clicktype.equalsIgnoreCase("5")) {
                        this.citiesTest = (StatesCities) new Gson().fromJson(jsonstring.toString(), StatesCities.class);
                    } else if (this.clicktype.equalsIgnoreCase("7")) {
                        this.test_cities = (StatesCities) new Gson().fromJson(jsonstring.toString(), StatesCities.class);
                    } else {
                        this.cities = (StatesCities) new Gson().fromJson(jsonstring.toString(), StatesCities.class);
                    }
                    break;
                }
                break;
            case "https://appapi.videocrypt.in/index.php/data_model/master_hit/get_states":
                if (jsonstring.getBoolean("status")) {
                    this.states = (StatesCities) new Gson().fromJson(jsonstring.toString(), StatesCities.class);
                    break;
                }
                break;
            case "data_model/post/center_lists":
                if (jsonstring.getBoolean("status")) {
                    try {
                        CenterDataModel centerDataModel = (CenterDataModel) new Gson().fromJson(jsonstring.toString(), CenterDataModel.class);
                        this.centerDataModel = centerDataModel;
                        if (centerDataModel != null && centerDataModel.getData() != null) {
                            this.class_centerArrayList = this.centerDataModel.getData().getClass_center();
                            this.test_centerArrayList = this.centerDataModel.getData().getTest_center();
                            break;
                        }
                    } catch (Exception unused) {
                        return;
                    }
                } else {
                    Toast.makeText(this, jsonstring.getString("message").toString(), 0).show();
                    break;
                }
                break;
        }
    }

    @Override // com.appnew.android.TestRegisteration.TimeSlotAdapter.onButtonClicked
    public void onTitleClicked(JSONObject jsonObject, String timeSelected) {
        this.testId = jsonObject.optString("id");
        this.test_name = jsonObject.optString("test_series_name");
        this.price = jsonObject.optString(FirebaseAnalytics.Param.PRICE);
        this.is_gst = jsonObject.optString("is_gst");
        String strOptString = jsonObject.optString("tax_rate");
        this.tax_rate = strOptString;
        this.time_selected = timeSelected;
        if (strOptString != null && !TextUtils.isEmpty(strOptString) && !this.tax_rate.equalsIgnoreCase("0")) {
            this.binding.fragmentTestSignInFormThree.pricetext.setText(String.format("%s %s %s", com.appnew.android.home.Constants.currencyType, "" + String.format("%.2f", Double.valueOf(Double.parseDouble(this.price) + Double.parseDouble(this.tax_rate))), "/-"));
            this.binding.fragmentTestSignInFormThree.gstTeg.setText(getResources().getString(R.string.include_gst_new));
        } else {
            this.binding.fragmentTestSignInFormThree.pricetext.setText(String.format("%s %s %s", com.appnew.android.home.Constants.currencyType, "" + String.format("%.2f", Double.valueOf(Double.parseDouble(this.price))), "/-"));
        }
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
            myViewHolder.tvName.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterationTest$StateCityAdapter$$ExternalSyntheticLambda0
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
                    RegisterationTest.this.onStateCityClick(this.searchType, statesCitiesData);
                    break;
                case "2":
                    RegisterationTest.this.onStateCityClick(this.searchType, statesCitiesData);
                    break;
                case "3":
                    RegisterationTest.this.onStateCityClick(this.searchType, statesCitiesData);
                    break;
                case "4":
                    RegisterationTest.this.onStateCityClick(this.searchType, statesCitiesData);
                    break;
                case "5":
                    RegisterationTest.this.onStateCityClick(this.searchType, statesCitiesData);
                    break;
                case "6":
                    RegisterationTest.this.onStateCityClick(this.searchType, statesCitiesData);
                    break;
                case "7":
                    RegisterationTest.this.onStateCityClick(this.searchType, statesCitiesData);
                    break;
                case "8":
                    RegisterationTest.this.onStateCityClick(this.searchType, statesCitiesData);
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

    public void textWatcher(final String searchType) {
        this.etSearch.addTextChangedListener(new TextWatcher() { // from class: com.appnew.android.TestRegisteration.RegisterationTest.13
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    RegisterationTest.this.ivClearSearch.setVisibility(0);
                } else {
                    RegisterationTest.this.ivClearSearch.setVisibility(8);
                }
                RegisterationTest.this.filter(editable.toString(), searchType);
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
        } else if (searchType.equalsIgnoreCase("3")) {
            for (StatesCitiesData statesCitiesData2 : this.states.getData()) {
                if (statesCitiesData2.getName().toLowerCase().contains(text.toLowerCase())) {
                    this.statesCitiesArrayList.add(statesCitiesData2);
                }
            }
        } else if (searchType.equalsIgnoreCase("2")) {
            for (StatesCitiesData statesCitiesData3 : this.cities.getData()) {
                if (statesCitiesData3.getName().toLowerCase().contains(text.toLowerCase())) {
                    this.statesCitiesArrayList.add(statesCitiesData3);
                }
            }
        } else if (searchType.equalsIgnoreCase("4")) {
            for (StatesCitiesData statesCitiesData4 : this.citiesPermanent.getData()) {
                if (statesCitiesData4.getName().toLowerCase().contains(text.toLowerCase())) {
                    this.statesCitiesArrayList.add(statesCitiesData4);
                }
            }
        } else if (searchType.equalsIgnoreCase("5")) {
            for (StatesCitiesData statesCitiesData5 : this.center_states.getData()) {
                if (statesCitiesData5.getName().toLowerCase().contains(text.toLowerCase())) {
                    this.statesCitiesArrayList.add(statesCitiesData5);
                }
            }
        } else if (searchType.equalsIgnoreCase("6")) {
            for (StatesCitiesData statesCitiesData6 : this.citiesTest.getData()) {
                if (statesCitiesData6.getName().toLowerCase().contains(text.toLowerCase())) {
                    this.statesCitiesArrayList.add(statesCitiesData6);
                }
            }
        } else if (searchType.equalsIgnoreCase("7")) {
            for (StatesCitiesData statesCitiesData7 : this.test_states.getData()) {
                if (statesCitiesData7.getName().toLowerCase().contains(text.toLowerCase())) {
                    this.statesCitiesArrayList.add(statesCitiesData7);
                }
            }
        } else if (searchType.equalsIgnoreCase("8")) {
            for (StatesCitiesData statesCitiesData8 : this.test_cities.getData()) {
                if (statesCitiesData8.getName().toLowerCase().contains(text.toLowerCase())) {
                    this.statesCitiesArrayList.add(statesCitiesData8);
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
                    this.cityindex = "";
                    this.SelectedStateid = statesCitiesData.getId();
                    this.binding.fragmentTestSignInFormFour.pinCodeET.setText("");
                    this.binding.fragmentTestSignInFormFour.stateET.setText(country.getName());
                    this.binding.fragmentTestSignInFormFour.cityET.setText("");
                    this.SelectedCityid = "";
                    hit_api_to_get_city();
                    if (this.binding.fragmentTestSignInFormFour.checkboxAddress.isChecked()) {
                        changePermanentAddress();
                        return;
                    }
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
                    this.binding.fragmentTestSignInFormFour.pinCodeET.setText("");
                    this.binding.fragmentTestSignInFormFour.cityET.setText(country.getName());
                    if (this.binding.fragmentTestSignInFormFour.checkboxAddress.isChecked()) {
                        changePermanentAddress();
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (searchType.equalsIgnoreCase("3")) {
            if (country.getName().equals(this.stateindexPermanent)) {
                return;
            }
            for (StatesCitiesData statesCitiesData3 : this.states.getData()) {
                if (statesCitiesData3.getName().equals(country.getName())) {
                    this.cityindexPermanent = "";
                    this.stateindexPermanent = country.getName();
                    this.SelectedStateidPermanent = statesCitiesData3.getId();
                    this.binding.fragmentTestSignInFormFour.permanentStateET.setText(country.getName());
                    this.binding.fragmentTestSignInFormFour.permanentCityET.setText("");
                    this.SelectedCityidPermanent = "";
                    this.binding.fragmentTestSignInFormFour.permanentPinCodeET.setText("");
                    hit_api_to_get_city();
                    return;
                }
            }
            return;
        }
        if (searchType.equalsIgnoreCase("4")) {
            if (country.getName().equals(this.cityindexPermanent)) {
                return;
            }
            for (StatesCitiesData statesCitiesData4 : this.citiesPermanent.getData()) {
                if (statesCitiesData4.getName().equals(country.getName())) {
                    this.cityindexPermanent = country.getName();
                    this.SelectedCityidPermanent = statesCitiesData4.getId();
                    this.binding.fragmentTestSignInFormFour.permanentCityET.setText(country.getName());
                    this.binding.fragmentTestSignInFormFour.permanentPinCodeET.setText("");
                    return;
                }
            }
            return;
        }
        if (searchType.equalsIgnoreCase("6")) {
            if (country.getName().equals(this.cityindexTest)) {
                return;
            }
            for (StatesCitiesData statesCitiesData5 : this.citiesTest.getData()) {
                if (statesCitiesData5.getName().equals(country.getName())) {
                    this.binding.fragmentTestSignInFormThree.classroomCenetrTV.setText("");
                    this.centerArrayList.clear();
                    this.class_center_id = "";
                    this.cityindexTest = country.getName();
                    this.SelectedCityidTest = statesCitiesData5.getId();
                    this.binding.fragmentTestSignInFormThree.cityET.setText(country.getName());
                    Iterator<ClassStateAndCenterList> it = this.class_centerArrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ClassStateAndCenterList next = it.next();
                        if (next.getId().equalsIgnoreCase(this.SelectedStateidTest)) {
                            ArrayList<ClassStateAndCenterList.CityAndCenter> city = next.getCity();
                            this.centerArrayList.clear();
                            Iterator<ClassStateAndCenterList.CityAndCenter> it2 = city.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                ClassStateAndCenterList.CityAndCenter next2 = it2.next();
                                if (next2.getId().equalsIgnoreCase(this.SelectedCityidTest)) {
                                    for (CentersData centersData : next2.getCenters()) {
                                        Class_center class_center = new Class_center();
                                        class_center.setAddress(centersData.getAddress());
                                        class_center.setCity(centersData.getCity());
                                        class_center.setClass_center_id(centersData.getId());
                                        class_center.setLocation(centersData.getLocation());
                                        class_center.setName(centersData.getName());
                                        class_center.setState(centersData.getState());
                                        this.centerArrayList.add(class_center);
                                    }
                                }
                            }
                        }
                    }
                    if (this.centerArrayList.size() == 1) {
                        selectClassRoomCenter();
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (searchType.equalsIgnoreCase("5")) {
            if (country.getName().equals(this.stateindexTest)) {
                return;
            }
            for (StatesCitiesData statesCitiesData6 : this.center_states.getData()) {
                if (statesCitiesData6.getName().equals(country.getName())) {
                    this.binding.fragmentTestSignInFormThree.classroomCenetrTV.setText("");
                    this.binding.fragmentTestSignInFormThree.cityET.setText("");
                    this.centerArrayList.clear();
                    this.class_center_id = "";
                    this.SelectedCityidTest = "";
                    this.cityindexTest = "";
                    this.stateindexTest = country.getName();
                    this.SelectedStateidTest = statesCitiesData6.getId();
                    this.binding.fragmentTestSignInFormThree.stateET.setText(country.getName());
                    return;
                }
            }
            return;
        }
        if (searchType.equalsIgnoreCase("7")) {
            if (country.getName().equals(this.test_stateindexTest)) {
                return;
            }
            for (StatesCitiesData statesCitiesData7 : this.test_states.getData()) {
                if (statesCitiesData7.getName().equals(country.getName())) {
                    this.binding.fragmentTestSignInFormThree.testCenterTV.setText("");
                    this.binding.fragmentTestSignInFormThree.testCityET.setText("");
                    this.testCenterList.clear();
                    this.test_center_id = "";
                    this.test_stateindexTest = country.getName();
                    this.test_SelectedStateidTest = statesCitiesData7.getId();
                    this.binding.fragmentTestSignInFormThree.testStateET.setText(country.getName());
                    this.binding.fragmentTestSignInFormThree.testCenterTV.setText("");
                    this.binding.fragmentTestSignInFormThree.testCenterAddressTV.setText("");
                    this.binding.fragmentTestSignInFormThree.testCityET.setText("");
                    this.binding.fragmentTestSignInFormThree.rlCenterAddress.setVisibility(8);
                    this.binding.fragmentTestSignInFormThree.tvTestCenterAdd.setVisibility(8);
                    this.test_SelectedCityidTest = "";
                    this.test_cityindexTest = "";
                    return;
                }
            }
            return;
        }
        if (!searchType.equalsIgnoreCase("8") || country.getName().equals(this.test_cityindexTest)) {
            return;
        }
        for (StatesCitiesData statesCitiesData8 : this.test_cities.getData()) {
            if (statesCitiesData8.getName().equals(country.getName())) {
                this.binding.fragmentTestSignInFormThree.testCenterTV.setText("");
                this.binding.fragmentTestSignInFormThree.testCenterAddressTV.setText("");
                this.binding.fragmentTestSignInFormThree.rlCenterAddress.setVisibility(8);
                this.binding.fragmentTestSignInFormThree.tvTestCenterAdd.setVisibility(8);
                this.testCenterList.clear();
                this.test_center_id = "";
                this.test_cityindexTest = country.getName();
                this.test_SelectedCityidTest = statesCitiesData8.getId();
                this.binding.fragmentTestSignInFormThree.testCityET.setText(country.getName());
                Iterator<ClassStateAndCenterList> it3 = this.test_centerArrayList.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    ClassStateAndCenterList next3 = it3.next();
                    if (next3.getId().equalsIgnoreCase(this.test_SelectedStateidTest)) {
                        ArrayList<ClassStateAndCenterList.CityAndCenter> city2 = next3.getCity();
                        this.testCenterList.clear();
                        Iterator<ClassStateAndCenterList.CityAndCenter> it4 = city2.iterator();
                        while (true) {
                            if (!it4.hasNext()) {
                                break;
                            }
                            ClassStateAndCenterList.CityAndCenter next4 = it4.next();
                            if (next4.getId().equalsIgnoreCase(this.test_SelectedCityidTest)) {
                                for (CentersData centersData2 : next4.getCenters()) {
                                    Class_center.Test_Center test_Center = new Class_center.Test_Center();
                                    test_Center.setAddress(centersData2.getAddress());
                                    test_Center.setClass_center(this.class_center_id);
                                    test_Center.setTest_center_id(centersData2.getId());
                                    test_Center.setLocation(centersData2.getLocation());
                                    test_Center.setName(centersData2.getName());
                                    this.testCenterList.add(test_Center);
                                }
                            }
                        }
                    }
                }
                if (this.testCenterList.size() == 1) {
                    selectTestCenter();
                    return;
                }
                return;
            }
        }
    }

    private void hit_api_to_get_state() {
        this.networkCall.NetworkAPICall(API.API_STATE, "", true, false);
    }

    private void hit_api_to_get_city() {
        this.networkCall.NetworkAPICall(API.API_CITY, "", true, false);
    }

    private void hit_api_to_set_data() {
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setName(this.binding.fragmentTestSignInForm.nameTV.getText().toString().trim());
        encryptionData.setEmail(this.binding.fragmentTestSignInForm.emailTV.getText().toString().trim());
        encryptionData.setDob(this.binding.fragmentTestSignInForm.dobTV.getText().toString().trim());
        encryptionData.setMobile(this.binding.fragmentTestSignInForm.mobileTV.getText().toString().trim());
        encryptionData.setGender(this.binding.fragmentTestSignInForm.genderSpinner.getText().toString().trim());
        encryptionData.setBlood_group(this.binding.fragmentTestSignInForm.bloodGroupSpinner.getText().toString().trim());
        encryptionData.setNr_id(this.binding.fragmentTestSignInForm.lastStudentIdTv.getText().toString().trim());
        encryptionData.setCategory(this.caste);
        encryptionData.setAadhar_no(this.binding.fragmentTestSignInForm.aadharTV.getText().toString().trim());
        encryptionData.setNr_student(this.binding.fragmentTestSignInForm.studentFormTextView.getText().toString().trim());
        encryptionData.setP_class(this.binding.fragmentTestSignInForm.presentClassTextView.getText().toString().trim());
        encryptionData.setC_l_s_name(this.binding.fragmentTestSignInForm.lastSchoolNameTV.getText().toString().trim());
        encryptionData.setFather_name(this.binding.fragmentTestSignInFormTwo.fatherNameET.getText().toString().trim());
        encryptionData.setF_mobile_no(this.binding.fragmentTestSignInFormTwo.fatherContectET.getText().toString().trim());
        encryptionData.setF_occupation(this.binding.fragmentTestSignInFormTwo.fatherOccupationET.getText().toString().trim());
        encryptionData.setMother_name(this.binding.fragmentTestSignInFormTwo.motherNameET.getText().toString().trim());
        encryptionData.setM_mobile_no(this.binding.fragmentTestSignInFormTwo.motherContactET.getText().toString().trim());
        encryptionData.setM_occupation(this.binding.fragmentTestSignInFormTwo.motherOccupationET.getText().toString().trim());
        encryptionData.setAddress(this.binding.fragmentTestSignInFormFour.streetAddressET.getText().toString().trim());
        encryptionData.setCity(this.binding.fragmentTestSignInFormFour.cityET.getText().toString().trim());
        encryptionData.setState(this.binding.fragmentTestSignInFormFour.stateET.getText().toString().trim());
        encryptionData.setPincode(this.binding.fragmentTestSignInFormFour.pinCodeET.getText().toString().trim());
        encryptionData.setP_address(this.binding.fragmentTestSignInFormFour.permanentStreetAddressET.getText().toString().trim());
        encryptionData.setP_city(this.binding.fragmentTestSignInFormFour.permanentCityET.getText().toString().trim());
        encryptionData.setP_state(this.binding.fragmentTestSignInFormFour.permanentStateET.getText().toString().trim());
        encryptionData.setP_pincode(this.binding.fragmentTestSignInFormFour.permanentPinCodeET.getText().toString().trim());
        encryptionData.setStream(this.binding.fragmentTestSignInFormThree.scholorshipTestTV.getText().toString().trim());
        encryptionData.setWhatsapp_no(this.binding.fragmentTestSignInForm.whattspNumberTv.getText().toString().trim());
        encryptionData.setImage(this.profilepic);
        encryptionData.setUser_id(MakeMyExam.getUserId());
        encryptionData.setIs_address_same_permanent(this.binding.fragmentTestSignInFormFour.checkboxAddress.isChecked() ? "1" : "0");
        encryptionData.setIs_same_whatsapp_no(this.binding.fragmentTestSignInForm.checkboxWhatsaap.isChecked() ? "1" : "0");
        SharedPreference.getInstance().setTestUser(encryptionData);
        if (this.cat_type.equalsIgnoreCase("5")) {
            encryptionData.setCourse_price(this.price);
            encryptionData.setTest_mode("");
            encryptionData.setTest_center("0");
            encryptionData.setTest_name("");
            encryptionData.setCenter_address("");
            encryptionData.setTest_center_id("0");
            encryptionData.setClass_center_id("0");
            encryptionData.setC_center("0");
            encryptionData.setTest_date("0");
            encryptionData.setCourse_id(this.courseId);
            encryptionData.setTest_id("0");
            encryptionData.setCenter_state("");
            encryptionData.setCenter_city("");
            encryptionData.setTest_state("");
            encryptionData.setTest_city("");
        } else {
            encryptionData.setCourse_price(this.price);
            encryptionData.setTest_mode(this.is_offline_test ? "1" : "0");
            encryptionData.setTest_center(this.test_center_id);
            encryptionData.setTest_name(this.test_name);
            encryptionData.setCenter_address(this.binding.fragmentTestSignInFormThree.testCenterAddressTV.getText().toString());
            encryptionData.setTest_center_id(this.binding.fragmentTestSignInFormThree.testCenterTV.getText().toString());
            encryptionData.setClass_center_id(this.binding.fragmentTestSignInFormThree.classroomCenetrTV.getText().toString());
            encryptionData.setC_center(this.class_center_id);
            encryptionData.setTest_date(this.time_selected);
            encryptionData.setCourse_id(this.courseId);
            encryptionData.setTest_id(this.testId);
            encryptionData.setCenter_state(this.stateindexTest);
            encryptionData.setCenter_city(this.cityindexTest);
            encryptionData.setTest_state(this.test_stateindexTest);
            encryptionData.setTest_city(this.test_cityindexTest);
        }
        Intent intent = new Intent(this.activity, (Class<?>) RegisterPreview.class);
        CourseDetail courseDetail = (CourseDetail) getIntent().getSerializableExtra(Const.SINGLE_STUDY);
        courseDetail.getData().getCourseDetail().setMrp(encryptionData.getCourse_price());
        courseDetail.getData().getCourseDetail().setTax(this.tax_rate);
        courseDetail.getData().getCourseDetail().setIs_gst(this.is_gst);
        intent.putExtra("form_data", encryptionData);
        intent.putExtra(Const.SINGLE_STUDY, courseDetail);
        intent.putExtra("is_load_form", false);
        intent.putExtra(Const.IS_BOOK, getIntent().getStringExtra(Const.IS_BOOK));
        intent.putExtra(Const.DELIVERY_CHARGE, getIntent().getStringExtra(Const.DELIVERY_CHARGE));
        startActivity(intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.binding.fragmentTestSignInFormThree.svMain.getVisibility() == 0) {
            super.onBackPressed();
            return;
        }
        if (this.binding.fragmentTestSignInFormTwo.svMain.getVisibility() == 0) {
            Helper.hideKeyboard(this);
            this.binding.fragmentTestSignInForm.svMain.setVisibility(0);
            this.binding.fragmentTestSignInFormTwo.svMain.setVisibility(8);
            this.binding.fragmentTestSignInFormThree.svMain.setVisibility(8);
            this.binding.fragmentTestSignInFormFour.svMain.setVisibility(8);
            return;
        }
        if (this.binding.fragmentTestSignInFormFour.svMain.getVisibility() == 0) {
            Helper.hideKeyboard(this);
            this.binding.fragmentTestSignInForm.svMain.setVisibility(8);
            this.binding.fragmentTestSignInFormFour.svMain.setVisibility(8);
            this.binding.fragmentTestSignInFormTwo.svMain.setVisibility(0);
            this.binding.fragmentTestSignInFormThree.svMain.setVisibility(8);
            return;
        }
        if (this.binding.fragmentTestSignInForm.svMain.getVisibility() == 0) {
            if (this.cat_type.equalsIgnoreCase("5")) {
                super.onBackPressed();
                return;
            }
            Helper.hideKeyboard(this);
            this.binding.fragmentTestSignInForm.svMain.setVisibility(8);
            this.binding.fragmentTestSignInFormFour.svMain.setVisibility(8);
            this.binding.fragmentTestSignInFormTwo.svMain.setVisibility(8);
            this.binding.fragmentTestSignInFormThree.svMain.setVisibility(0);
        }
    }

    private void changePermanentAddress() {
        this.citiesPermanent = this.cities;
        this.cityindexPermanent = this.cityindex;
        this.stateindexPermanent = this.stateindex;
        this.binding.fragmentTestSignInFormFour.permanentStreetAddressET.setText(this.binding.fragmentTestSignInFormFour.streetAddressET.getText().toString());
        this.binding.fragmentTestSignInFormFour.permanentCityET.setText(this.binding.fragmentTestSignInFormFour.cityET.getText().toString());
        this.binding.fragmentTestSignInFormFour.permanentStateET.setText(this.binding.fragmentTestSignInFormFour.stateET.getText().toString());
        this.binding.fragmentTestSignInFormFour.permanentPinCodeET.setText(this.binding.fragmentTestSignInFormFour.pinCodeET.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hit_api_to_centerData() {
        if (this.cat_type.equalsIgnoreCase("5")) {
            return;
        }
        this.networkCall.NetworkAPICall(API.API_CNETER_LIST, "", true, false);
    }

    private void hit_api_to_check_slot() {
        this.networkCall.NetworkAPICall(API.API_SEAT_AVAILABILITY, "", true, false);
    }
}
