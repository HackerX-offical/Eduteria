package com.appnew.android.helpChat;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
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
import com.appnew.android.helpChat.adapter.ChatAdapter;
import com.appnew.android.helpChat.model.ChatQuery;
import com.appnew.android.helpChat.model.HelpSupportChatModel;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class HelpChatActivity extends AppCompatActivity implements View.OnClickListener, NetworkCall.MyNetworkCallBack {
    ChatAdapter chatAdapter;
    HelpSupportChatModel.DataBean chatData;
    ArrayList<ChatQuery> chat_list;
    EditText message;
    NetworkCall networkCall;
    TextView queryTV;
    RecyclerView recyclerView;
    ImageView send_message;
    LinearLayout sending_layout;
    CourseDetail singleStudy;
    String message_txt = "";
    public String quiry_id = "";
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
        setContentView(R.layout.help_chat);
        this.networkCall = new NetworkCall(this, this);
        if (getIntent().getExtras() != null) {
            this.chatData = (HelpSupportChatModel.DataBean) getIntent().getSerializableExtra("querySelect");
            this.isCourse = getIntent().getExtras().getBoolean("isCourse");
            this.singleStudy = (CourseDetail) ((Bundle) Objects.requireNonNull(getIntent().getExtras())).getSerializable("courseDetail");
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.myProgress_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(com.appnew.android.R.drawable.arrow_back_black);
        initView();
        checkQuiryDecision();
    }

    private void initView() {
        this.sending_layout = (LinearLayout) findViewById(R.id.sending_layout);
        this.queryTV = (TextView) findViewById(R.id.queryTV);
        this.send_message = (ImageView) findViewById(R.id.send_message);
        this.message = (EditText) findViewById(R.id.help_chat_txt);
        this.recyclerView = (RecyclerView) findViewById(R.id.chat_list);
        this.send_message.setOnClickListener(this);
        if (this.isCourse) {
            CourseDetail courseDetail = this.singleStudy;
            if (courseDetail != null && courseDetail.getData() != null && this.singleStudy.getData().getCourseDetail() != null && !TextUtils.isEmpty(this.singleStudy.getData().getCourseDetail().getTitle())) {
                this.courseId = this.singleStudy.getData().getCourseDetail().getId();
            } else {
                this.courseId = "0";
            }
        }
        if (this.chatData.getClose_date().equalsIgnoreCase("0")) {
            this.recyclerView.setPadding(0, 0, 0, Helper.getValueInDP(this, 56));
            this.sending_layout.setVisibility(0);
        } else {
            this.recyclerView.setPadding(0, 0, 0, 0);
            this.sending_layout.setVisibility(8);
        }
        String str = "N/A";
        if (!TextUtils.isEmpty(this.chatData.getTime())) {
            try {
                str = this.chatAdapter.getdate(String.valueOf(Long.parseLong(this.chatData.getTime()) * 1000));
            } catch (Exception unused) {
            }
        }
        this.queryTV.setText(this.chatData.getDescription() + "\n" + str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() != R.id.send_message) {
            return;
        }
        String string = this.message.getText().toString();
        this.message_txt = string;
        if (!string.isEmpty()) {
            sendQuirey();
        } else {
            Toast.makeText(this, getResources().getString(R.string.please_enter_some_text), 0).show();
        }
    }

    private void sendQuirey() {
        this.networkCall.NetworkAPICall(API.GET_SUBMIT_QUIRES_REPLIES, "", true, false);
    }

    private void checkQuiryDecision() {
        this.networkCall.NetworkAPICall(API.GET_QUIRES_REPLIES, "", true, false);
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

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (apitype.equals(API.GET_SUBMIT_QUIRES_REPLIES)) {
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setQuery_id(this.chatData.getId());
            encryptionData.setText(this.message_txt);
            encryptionData.setCourse_id(this.courseId);
            return service.sendSupportQuiry(AES.encrypt(new Gson().toJson(encryptionData)));
        }
        if (!apitype.equals(API.GET_QUIRES_REPLIES)) {
            return null;
        }
        EncryptionData encryptionData2 = new EncryptionData();
        encryptionData2.setQuery_id(this.chatData.getId());
        encryptionData2.setCourse_id(this.courseId);
        return service.getQuiresReply(AES.encrypt(new Gson().toJson(encryptionData2)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals(API.GET_SUBMIT_QUIRES_REPLIES)) {
            if (jsonstring.optString("status").equals("true")) {
                this.message.setText("");
                Helper.closeKeyboard(this);
                checkQuiryDecision();
                return;
            } else {
                if (jsonstring.has("auth_code")) {
                    RetrofitResponse.GetApiData(this, jsonstring.optString("auth_code"), jsonstring.optString("message"), false);
                    return;
                }
                return;
            }
        }
        if (apitype.equals(API.GET_QUIRES_REPLIES)) {
            if (jsonstring.optString("status").equals("true")) {
                this.chat_list = new ArrayList<>();
                Gson gson = new Gson();
                JSONArray jSONArrayOptJSONArray = jsonstring.optJSONArray("data");
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    this.chat_list.add((ChatQuery) gson.fromJson(jSONArrayOptJSONArray.optJSONObject(i).toString(), ChatQuery.class));
                }
                ChatAdapter chatAdapter = new ChatAdapter(this.chat_list);
                this.chatAdapter = chatAdapter;
                this.recyclerView.setAdapter(chatAdapter);
                return;
            }
            if (jsonstring.has("auth_code")) {
                RetrofitResponse.GetApiData(this, jsonstring.optString("auth_code"), jsonstring.optString("message"), false);
            }
        }
    }
}
