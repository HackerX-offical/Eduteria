package com.appnew.android.helpChat;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.Toolbar;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.COURSEDETAIL.CourseDetail;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class HelpSupportActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack {
    ArrayAdapter<String> arrayAdapter;
    String category;
    String comment;
    EditText comment_et;
    Activity context;
    TextView courseIdTxt;
    RelativeLayout courseRL;
    AppCompatSpinner feedtype;
    NetworkCall networkCall;
    CourseDetail singleStudy;
    Button submitBtn;
    EditText title;
    String titleStr;
    String title_txt;
    String typestr;
    String[] type = {"Select Type", "Suggestion", "Complaint", "Query", "Other"};
    boolean isCourse = false;
    String courseId = "0";

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        this.context = this;
        setContentView(R.layout.activity_help_support);
        this.networkCall = new NetworkCall(this, this);
        if (getIntent().getExtras() != null) {
            this.isCourse = getIntent().getExtras().getBoolean("isCourse");
            this.singleStudy = (CourseDetail) ((Bundle) Objects.requireNonNull(getIntent().getExtras())).getSerializable("courseDetail");
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.myProgress_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(com.appnew.android.R.drawable.arrow_back_black);
        initView();
    }

    private void initView() {
        this.courseRL = (RelativeLayout) findViewById(R.id.courseRL);
        this.courseIdTxt = (TextView) findViewById(R.id.courseIdTxt);
        this.feedtype = (AppCompatSpinner) findViewById(R.id.feedtype);
        this.title = (EditText) findViewById(R.id.title);
        this.comment_et = (EditText) findViewById(R.id.comment_et);
        this.submitBtn = (Button) findViewById(R.id.submitBtn);
        if (this.isCourse) {
            this.courseRL.setVisibility(0);
            CourseDetail courseDetail = this.singleStudy;
            if (courseDetail != null && courseDetail.getData() != null && this.singleStudy.getData().getCourseDetail() != null && !TextUtils.isEmpty(this.singleStudy.getData().getCourseDetail().getTitle())) {
                this.courseIdTxt.setText(this.singleStudy.getData().getCourseDetail().getTitle());
                this.courseId = this.singleStudy.getData().getCourseDetail().getId();
            } else {
                this.courseIdTxt.setText(this.context.getResources().getString(R.string.n_a));
                this.courseId = "0";
            }
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this.context, R.layout.item_view, this.type);
        this.arrayAdapter = arrayAdapter;
        this.feedtype.setAdapter((SpinnerAdapter) arrayAdapter);
        this.submitBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.helpChat.HelpSupportActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int selectedItemPosition = HelpSupportActivity.this.feedtype.getSelectedItemPosition();
                HelpSupportActivity helpSupportActivity = HelpSupportActivity.this;
                helpSupportActivity.comment = helpSupportActivity.comment_et.getText().toString().trim();
                HelpSupportActivity helpSupportActivity2 = HelpSupportActivity.this;
                helpSupportActivity2.typestr = helpSupportActivity2.type[selectedItemPosition];
                if (HelpSupportActivity.this.typestr.equals("Select Type")) {
                    Toast.makeText(HelpSupportActivity.this.context, HelpSupportActivity.this.context.getResources().getString(R.string.please_select_type), 0).show();
                    return;
                }
                if (HelpSupportActivity.this.comment.equals("")) {
                    Toast.makeText(HelpSupportActivity.this.context, HelpSupportActivity.this.getResources().getString(R.string.please_fill_text_box), 0).show();
                    return;
                }
                HelpSupportActivity helpSupportActivity3 = HelpSupportActivity.this;
                helpSupportActivity3.title_txt = helpSupportActivity3.title.getText().toString();
                if (!HelpSupportActivity.this.comment.isEmpty() && !HelpSupportActivity.this.title_txt.isEmpty() && !HelpSupportActivity.this.comment.isEmpty()) {
                    HelpSupportActivity helpSupportActivity4 = HelpSupportActivity.this;
                    helpSupportActivity4.networkcallForSubmitquery(helpSupportActivity4.title_txt, HelpSupportActivity.this.type[HelpSupportActivity.this.feedtype.getSelectedItemPosition()]);
                } else {
                    HelpSupportActivity helpSupportActivity5 = HelpSupportActivity.this;
                    Toast.makeText(helpSupportActivity5, helpSupportActivity5.getResources().getString(R.string.all_field_is_mandatory), 0).show();
                }
            }
        });
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals(API.GET_MY_QUIRES)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setCategory(this.category);
        encryptionData.setTitle(this.comment);
        encryptionData.setDescription(this.titleStr);
        encryptionData.setCourse_id(this.courseId);
        return service.submitHelpQuires(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals(API.GET_MY_QUIRES)) {
            if (jsonstring.optString("status").equals("true")) {
                this.feedtype.setSelection(0);
                this.title.setText("");
                this.comment_et.setText("");
                Toast.makeText(this, jsonstring.optString("message"), 0).show();
                return;
            }
            RetrofitResponse.GetApiData(this, jsonstring.optString("auth_code"), jsonstring.optString("message"), false);
        }
    }

    public void networkcallForSubmitquery(String titles, String quiry_type) {
        this.category = quiry_type;
        this.titleStr = titles;
        this.networkCall.NetworkAPICall(API.GET_MY_QUIRES, "", true, false);
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        Helper.backButtonClick(this);
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }
}
