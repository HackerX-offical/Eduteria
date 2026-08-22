package com.appnew.android.helpChat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.COURSEDETAIL.CourseDetail;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.helpChat.adapter.HelpQueryRecyclerAdapter;
import com.appnew.android.helpChat.helper.OnQueryItemListener;
import com.appnew.android.helpChat.model.HelpSupportChatModel;
import com.eduteria.app.app.R;
import com.github.clans.fab.FloatingActionButton;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class HelpQueryActivity extends AppCompatActivity implements View.OnClickListener, OnQueryItemListener, NetworkCall.MyNetworkCallBack {
    HelpQueryRecyclerAdapter chatAdapter;
    FloatingActionButton floatingActionButton;
    NetworkCall networkCall;
    TextView queryTV;
    RecyclerView recyclerView;
    CourseDetail singleStudy;
    String message_txt = "";
    public String quiry_id = "";
    ArrayList<HelpSupportChatModel.DataBean> chat_list = new ArrayList<>();
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
        setContentView(R.layout.help_query);
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

    private void checkMyQuiry() {
        this.networkCall.NetworkAPICall(API.GET_MY_QUIRES, "", true, false);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        checkMyQuiry();
    }

    private void initView() {
        this.queryTV = (TextView) findViewById(R.id.queryTV);
        this.recyclerView = (RecyclerView) findViewById(R.id.chat_list);
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.floating_button);
        this.floatingActionButton = floatingActionButton;
        floatingActionButton.setOnClickListener(this);
        if (this.isCourse) {
            CourseDetail courseDetail = this.singleStudy;
            if (courseDetail != null && courseDetail.getData() != null && this.singleStudy.getData().getCourseDetail() != null && !TextUtils.isEmpty(this.singleStudy.getData().getCourseDetail().getTitle())) {
                this.courseId = this.singleStudy.getData().getCourseDetail().getId();
            } else {
                this.courseId = "0";
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() != R.id.floating_button) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) HelpSupportActivity.class);
        intent.putExtra("isCourse", this.isCourse);
        intent.putExtra("courseDetail", this.singleStudy);
        startActivity(intent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        Helper.backButtonClick(this);
        return true;
    }

    @Override // com.appnew.android.helpChat.helper.OnQueryItemListener
    public void onQueryItemClick(HelpSupportChatModel.DataBean myQuery) {
        Intent intent = new Intent(this, (Class<?>) HelpChatActivity.class);
        intent.putExtra("querySelect", myQuery);
        intent.putExtra("isCourse", this.isCourse);
        intent.putExtra("courseDetail", this.singleStudy);
        startActivity(intent);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals(API.GET_MY_QUIRES)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setPage("1");
        encryptionData.setCourse_id(this.courseId);
        return service.getMyHelpQuires(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals(API.GET_MY_QUIRES)) {
            if (jsonstring.optString("status").equals("true")) {
                this.chat_list = new ArrayList<>();
                Gson gson = new Gson();
                JSONArray jSONArrayOptJSONArray = jsonstring.optJSONArray("data");
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    this.chat_list.add((HelpSupportChatModel.DataBean) gson.fromJson(jSONArrayOptJSONArray.optJSONObject(i).toString(), HelpSupportChatModel.DataBean.class));
                }
                HelpQueryRecyclerAdapter helpQueryRecyclerAdapter = new HelpQueryRecyclerAdapter(this, this.chat_list);
                this.chatAdapter = helpQueryRecyclerAdapter;
                this.recyclerView.setAdapter(helpQueryRecyclerAdapter);
                return;
            }
            RetrofitResponse.GetApiData(this, jsonstring.optString("auth_code"), jsonstring.optString("message"), false);
        }
    }
}
