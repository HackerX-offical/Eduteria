package com.appnew.android.Educator;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Educator.adpter.EducatorAdapter;
import com.appnew.android.Educator.fragment.AboutEdFragment;
import com.appnew.android.Educator.fragment.CoursesClassesFragment;
import com.appnew.android.Educator.model.EducatorItem;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Model.Educator.EducatorModel;
import com.appnew.android.Model.Educator.LabelItem;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.home.model.CourseResponse;
import com.bumptech.glide.Glide;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class EducatorsActivity extends AppCompatActivity implements EducatorAdapter.ItemOnClickListener, NetworkCall.MyNetworkCallBack {
    private static final String TAG = "EducatorsActivity";
    private EducatorAdapter educatorAdapter;
    TextView educatorExperienceTV;
    EducatorModel educatorModel;
    TextView educatorNameTV;
    CircleImageView educatorPicIV;
    private RecyclerView educatorRecyclerView;
    String exp;
    FragmentTransaction fragmentTransaction;
    String id;
    String image;
    ImageView image_back;
    Toolbar main_toolbar;
    NetworkCall networkCall;
    RelativeLayout no_data_found_RL;
    TextView toolbarTitleTV;
    String username;
    ArrayList<Courselist> courselists = new ArrayList<>();
    private ArrayList<EducatorItem> educatorItemList = new ArrayList<>();
    String course_ids = "";

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educators);
        getLayoutIds();
        this.networkCall = new NetworkCall(this, this);
        Intent intent = getIntent();
        if (intent != null) {
            this.id = intent.getStringExtra("educator_id");
            this.username = intent.getStringExtra("educator_name");
            this.image = intent.getStringExtra("educator_image");
            this.exp = intent.getStringExtra("educator_exp");
            this.educatorNameTV.setText(this.username);
            this.educatorExperienceTV.setText(this.exp);
            Glide.with((FragmentActivity) this).load(this.image).placeholder(R.drawable.user_pic).error(R.drawable.user_pic).into(this.educatorPicIV);
        }
        this.image_back.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Educator.EducatorsActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                EducatorsActivity.this.finish();
            }
        });
        this.main_toolbar.setBackgroundColor(getResources().getColor(R.color.whiteApp));
        this.toolbarTitleTV.setTextColor(ContextCompat.getColor(this, R.color.black));
        this.image_back.setColorFilter(ContextCompat.getColor(this, R.color.black));
        this.networkCall.NetworkAPICall(API.get_educators_list, "", true, false);
    }

    private void getLayoutIds() {
        this.toolbarTitleTV = (TextView) findViewById(R.id.toolbarTitleTV);
        this.image_back = (ImageView) findViewById(R.id.image_back);
        this.main_toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        this.educatorNameTV = (TextView) findViewById(R.id.educatorNameTV);
        this.educatorPicIV = (CircleImageView) findViewById(R.id.educatorPicIV);
        this.educatorExperienceTV = (TextView) findViewById(R.id.educatorExperienceTV);
        this.educatorRecyclerView = (RecyclerView) findViewById(R.id.educatorRecyclerView);
        this.no_data_found_RL = (RelativeLayout) findViewById(R.id.no_data_found_RL);
        View viewFindViewById = findViewById(R.id.main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        if (Build.VERSION.SDK_INT == 36) {
            EdgeToEdgeHelperOld.applyHeaderWithToolbar(this, getWindow(), viewFindViewById, toolbar);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override // com.appnew.android.Educator.adpter.EducatorAdapter.ItemOnClickListener
    public void onLabelClick(View view, int position, LabelItem labelItem) {
        Fragment fragmentNewInstance;
        String key = labelItem.getKey();
        key.hashCode();
        switch (key) {
            case "paid_live_classes":
                fragmentNewInstance = CoursesClassesFragment.newInstance("live_classes", this.educatorModel.getData().getPaidLiveClasses().getData(), this.courselists, this.id);
                break;
            case "basic_details":
                fragmentNewInstance = AboutEdFragment.newInstance(this.educatorModel.getData().getBasicDetails().getData().getAboutUser());
                break;
            case "free_live_classes":
                fragmentNewInstance = CoursesClassesFragment.newInstance("free_classes", this.educatorModel.getData().getFreeLiveClasses().getData(), this.courselists, this.id);
                break;
            case "courses":
                fragmentNewInstance = CoursesClassesFragment.newInstance(Const.COURSES, this.educatorModel.getData().getFreeLiveClasses().getData(), this.courselists, this.id);
                break;
            default:
                fragmentNewInstance = new AboutEdFragment();
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, fragmentNewInstance).commit();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (apitype.equals(API.get_educators_list)) {
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setEducator_id(this.id);
            encryptionData.setType("0");
            return service.getEducatorDetails(AES.encrypt(new Gson().toJson(encryptionData)));
        }
        if (!apitype.equals(API.get_courses)) {
            return null;
        }
        EncryptionData encryptionData2 = new EncryptionData();
        encryptionData2.setCourse_type("0");
        encryptionData2.setCourse_ids(this.course_ids);
        encryptionData2.setSub_cat("1");
        encryptionData2.setMain_cat("0");
        encryptionData2.setLang("0");
        encryptionData2.setPage("1");
        encryptionData2.setIs_paid("");
        return service.get_courses(AES.encrypt(new Gson().toJson(encryptionData2)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonObject, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals(API.get_educators_list)) {
            if (jsonObject.optString("status").equals("true")) {
                EducatorModel educatorModel = (EducatorModel) new Gson().fromJson(jsonObject.toString(), EducatorModel.class);
                this.educatorModel = educatorModel;
                setEducatorData(educatorModel);
                getCourses(this.educatorModel.getData().getBasicDetails().getData().getCourseIds());
                this.no_data_found_RL.setVisibility(8);
                return;
            }
            this.no_data_found_RL.setVisibility(0);
            return;
        }
        if (apitype.equals(API.get_courses)) {
            try {
                if (jsonObject.optString("status").equals("true")) {
                    CourseResponse courseResponse = (CourseResponse) new Gson().fromJson(jsonObject.toString(), CourseResponse.class);
                    if (courseResponse.getData() == null || courseResponse.getData().size() <= 0) {
                        return;
                    }
                    this.courselists.addAll(courseResponse.getData());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void getCourses(String courseId) {
        this.course_ids = courseId;
        if (TextUtils.isEmpty(courseId)) {
            return;
        }
        this.networkCall.NetworkAPICall(API.get_courses, "", true, false);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        apitype.hashCode();
        if (apitype.equals(API.get_educators_list)) {
            Log.e(TAG, "ErrorCallBack: " + jsonstring);
        }
    }

    private void setEducatorData(EducatorModel educatorsModel) {
        AboutEdFragment aboutEdFragment = new AboutEdFragment();
        Bundle bundle = new Bundle();
        bundle.putString("educator_abouts", educatorsModel.getData().getBasicDetails().getData().getAboutUser());
        aboutEdFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, aboutEdFragment).commit();
        EducatorAdapter educatorAdapter = this.educatorAdapter;
        if (educatorAdapter == null) {
            this.educatorAdapter = new EducatorAdapter(this, educatorsModel.getData().getLabel(), this);
            this.educatorRecyclerView.setLayoutManager(new LinearLayoutManager(this, 0, false));
            this.educatorRecyclerView.setHasFixedSize(true);
            this.educatorRecyclerView.setAdapter(this.educatorAdapter);
            return;
        }
        educatorAdapter.notifyDataSetChanged();
    }
}
