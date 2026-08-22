package com.appnew.android.TestRegisteration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.COURSEDETAIL.CourseDetail;
import com.appnew.android.Payment.PurchaseActivity;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.DialogUtils;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.databinding.ActivityRegistrationPreviewBinding;
import com.bumptech.glide.Glide;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class RegisterPreview extends AppCompatActivity implements NetworkCall.MyNetworkCallBack {
    public static RegisterPreview instance;
    private RegisterPreview activity;
    ActivityRegistrationPreviewBinding binding;
    NetworkCall networkCall;
    private String test_id = "";
    private String test_mode = "";

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRegistrationPreviewBinding activityRegistrationPreviewBindingInflate = ActivityRegistrationPreviewBinding.inflate(getLayoutInflater());
        this.binding = activityRegistrationPreviewBindingInflate;
        setContentView(activityRegistrationPreviewBindingInflate.getRoot());
        this.activity = this;
        instance = this;
        this.networkCall = new NetworkCall(this, this);
        initViews();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        instance = null;
        super.onDestroy();
    }

    private void initViews() {
        EncryptionData encryptionData = (EncryptionData) getIntent().getSerializableExtra("form_data");
        this.test_mode = encryptionData.getTest_mode();
        this.binding.nameText1.setText(encryptionData.getName());
        this.binding.emailText1.setText(encryptionData.getEmail());
        this.binding.classRoom.setText(encryptionData.getClass_center_id());
        this.binding.testDateText.setText(encryptionData.getTest_date());
        this.binding.testCenterText.setText(encryptionData.getTest_center_id());
        this.binding.dobText.setText(encryptionData.getDob());
        this.binding.genderText.setText(encryptionData.getGender());
        this.binding.mobileText1.setText(encryptionData.getMobile());
        this.binding.whatsappTextTv.setText(encryptionData.getWhatsapp_no());
        this.binding.bloodGrpText.setText(!TextUtils.isEmpty(encryptionData.getBlood_group()) ? encryptionData.getBlood_group() : "NA");
        this.binding.categoryText.setText(encryptionData.getCategory());
        this.binding.adharTextId.setText(encryptionData.getAadhar_no());
        this.binding.studentText.setText(encryptionData.getNr_student());
        this.binding.studentIdTv.setText(encryptionData.getNr_id());
        this.binding.ClassNameText.setText(encryptionData.getP_class());
        this.binding.schoolText.setText(encryptionData.getC_l_s_name());
        this.binding.fatherText.setText(encryptionData.getFather_name());
        this.binding.fatherContactText.setText(encryptionData.getF_mobile_no());
        this.binding.fatherContactTextText.setText(!TextUtils.isEmpty(encryptionData.getF_occupation()) ? encryptionData.getF_occupation() : "NA");
        this.binding.motherText.setText(encryptionData.getMother_name());
        this.binding.motherContactText.setText(!TextUtils.isEmpty(encryptionData.getM_mobile_no()) ? encryptionData.getM_mobile_no() : "NA");
        this.binding.motherOccupationText.setText(TextUtils.isEmpty(encryptionData.getM_occupation()) ? "NA" : encryptionData.getM_occupation());
        this.binding.address.setText(encryptionData.getAddress());
        this.binding.city.setText(encryptionData.getCity());
        this.binding.state.setText(encryptionData.getState());
        this.binding.streamDivision.setText(encryptionData.getStream());
        this.binding.pincode.setText(encryptionData.getPincode());
        this.binding.addressTwo.setText(encryptionData.getP_address());
        this.binding.cityTwo.setText(encryptionData.getP_city());
        this.binding.stateTwo.setText(encryptionData.getP_state());
        this.binding.pincodeTwo.setText(encryptionData.getP_pincode());
        if (getIntent().hasExtra(Const.IS_BOOK) && getIntent().getStringExtra(Const.IS_BOOK).equalsIgnoreCase("5")) {
            this.binding.llTest.setVisibility(8);
        } else {
            this.binding.classState.setText(encryptionData.getCenter_state());
            this.binding.classCity.setText(encryptionData.getCenter_city());
            this.binding.testState.setText(encryptionData.getTest_state());
            this.binding.testCity.setText(encryptionData.getTest_city());
            this.binding.centerAdd.setText(encryptionData.getCenter_address());
            this.binding.testName.setText(encryptionData.getTest_name());
            this.binding.testMode.setText(encryptionData.getTest_mode().equalsIgnoreCase("1") ? "Offline" : "Online");
            if (encryptionData.getTest_mode().equalsIgnoreCase("1")) {
                this.binding.llCenterDetail.setVisibility(0);
            } else {
                this.binding.llCenterDetail.setVisibility(8);
            }
        }
        if (!TextUtils.isEmpty(encryptionData.getNr_id())) {
            this.binding.studentIdTv.setVisibility(0);
            this.binding.studentIdHint.setVisibility(0);
        } else {
            this.binding.studentIdTv.setVisibility(8);
            this.binding.studentIdHint.setVisibility(8);
        }
        Glide.with((FragmentActivity) this).load(encryptionData.getImage()).error(R.mipmap.square_placeholder).into(this.binding.presentClass);
        this.binding.buyNowBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterPreview$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$0(view);
            }
        });
        this.binding.ivBack.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.RegisterPreview$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initViews$1(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$0(View view) {
        hitApi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$1(View view) {
        finish();
    }

    private void hitApi() {
        if (((EncryptionData) getIntent().getSerializableExtra("form_data")).getMobile() != null) {
            this.networkCall.NetworkAPICall(API.API_SCOLORSHIP_FORM, "", true, false);
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals(API.API_SCOLORSHIP_FORM)) {
            return null;
        }
        EncryptionData encryptionData = (EncryptionData) getIntent().getSerializableExtra("form_data");
        this.test_id = encryptionData.getTest_id();
        encryptionData.setClass_center_id(null);
        encryptionData.setTest_center_id(null);
        encryptionData.setCenter_address(null);
        encryptionData.setTest_name(null);
        encryptionData.setTest_mode(null);
        encryptionData.setCourse_price(null);
        encryptionData.setCenter_city(null);
        encryptionData.setCenter_state(null);
        encryptionData.setTest_city(null);
        encryptionData.setTest_state(null);
        encryptionData.setIs_address_same_permanent(null);
        encryptionData.setIs_same_whatsapp_no(null);
        return service.setScholorshipData(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals(API.API_SCOLORSHIP_FORM)) {
            if (jsonstring.getBoolean("status")) {
                Intent intent = new Intent(this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, (CourseDetail) getIntent().getSerializableExtra(Const.SINGLE_STUDY));
                intent.putExtra("is_load_form", false);
                intent.putExtra("test_id", this.test_id);
                intent.putExtra("test_mode", this.test_mode);
                intent.putExtra(Const.IS_BOOK, getIntent().getStringExtra(Const.IS_BOOK));
                intent.putExtra(Const.DELIVERY_CHARGE, getIntent().getStringExtra(Const.DELIVERY_CHARGE));
                intent.setFlags(67108864);
                Helper.gotoActivity(intent, this);
                return;
            }
            getErrorDialog(this, "Registration Closed", jsonstring.getString("message").toString());
        }
    }

    public void getErrorDialog(final Activity ctx, final String title, final String message) {
        DialogUtils.makeSingleButtonDialog(this, title, message, getResources().getString(R.string.ok), false, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.TestRegisteration.RegisterPreview$$ExternalSyntheticLambda2
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
            public final void onOKClick() {
                this.f$0.lambda$getErrorDialog$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getErrorDialog$2() {
        try {
            if (RegisterationTest.instance != null) {
                RegisterationTest.instance.finish();
            }
            finish();
        } catch (Exception unused) {
        }
    }
}
