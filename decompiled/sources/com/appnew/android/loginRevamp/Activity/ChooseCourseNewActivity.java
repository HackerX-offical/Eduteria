package com.appnew.android.loginRevamp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Theme.DashboardActivityTheme2;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.cleverTap.AnalyticHelper;
import com.appnew.android.databinding.ActivityChooseCourseBinding;
import com.appnew.android.home.model.CourseResponse;
import com.appnew.android.loginRevamp.Adapter.CourseDataAdapterNew;
import com.appnew.android.pojo.Userinfo.Data;
import com.google.gson.Gson;
import com.tv9news.utils.helpers.AnalyticEvents;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class ChooseCourseNewActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack, CourseDataAdapterNew.ItemClicked {
    ActivityChooseCourseBinding binding;
    private Data data;
    NetworkCall networkCall;
    private CourseDataAdapterNew tileDataAdapter;
    private ArrayList<Courselist> courselists = new ArrayList<>();
    private String course_id = "";
    public boolean isChoosed = false;

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityChooseCourseBinding activityChooseCourseBindingInflate = ActivityChooseCourseBinding.inflate(getLayoutInflater());
        this.binding = activityChooseCourseBindingInflate;
        setContentView(activityChooseCourseBindingInflate.getRoot());
        this.networkCall = new NetworkCall(this, this);
        this.binding.courseListRV.setLayoutManager(new LinearLayoutManager(this));
        getCourseData();
        this.binding.signupBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.loginRevamp.Activity.ChooseCourseNewActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.binding.ivBack.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.loginRevamp.Activity.ChooseCourseNewActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        if (Helper.isNetworkConnected(this)) {
            this.networkCall.NetworkAPICall("https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction", "", true, false);
        } else {
            Helper.showInternetToast(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        onBackPressed();
    }

    private void getCourseData() {
        this.networkCall.NetworkAPICall(API.get_courses, "", true, false);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (apitype.equals("https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction")) {
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setCourse_id(this.course_id);
            encryptionData.setCoupon_applied("0");
            encryptionData.setParent_id(this.course_id);
            return service.free_transaction(AES.encrypt(new Gson().toJson(encryptionData)));
        }
        if (!apitype.equals(API.get_courses)) {
            return null;
        }
        EncryptionData encryptionData2 = new EncryptionData();
        encryptionData2.setCourse_type("0");
        encryptionData2.setType("All");
        encryptionData2.setSub_cat("1");
        encryptionData2.setMain_cat("0");
        encryptionData2.setPage("1");
        return service.get_courses(AES.encrypt(new Gson().toJson(encryptionData2)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonObject, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals("https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction")) {
            try {
                if (jsonObject.optString("status").equals("true")) {
                    pushEventForFreeCourse();
                    this.isChoosed = true;
                    startActivity(new Intent(this, (Class<?>) DashboardActivityTheme2.class).setFlags(268468224));
                    finish();
                    return;
                }
                Toast.makeText(this, "" + jsonObject.optString("message"), 0).show();
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (apitype.equals(API.get_courses)) {
            try {
                if (jsonObject.optString("status").equals("true")) {
                    CourseResponse courseResponse = (CourseResponse) new Gson().fromJson(jsonObject.toString(), CourseResponse.class);
                    if (courseResponse.getData().size() > 0) {
                        this.binding.courseListRV.setVisibility(0);
                        this.binding.noData.noDataFoundRL.setVisibility(8);
                        if (courseResponse.getData().size() > 0) {
                            this.courselists.clear();
                            this.courselists.addAll(courseResponse.getData());
                            new ArrayList();
                            ArrayList<Courselist> arrayListRemoveDuplicates = removeDuplicates(this.courselists);
                            this.courselists.clear();
                            this.courselists.addAll(arrayListRemoveDuplicates);
                            for (int i = 0; i < this.courselists.size(); i++) {
                                this.courselists.get(i).setViewType("0");
                            }
                            this.tileDataAdapter = new CourseDataAdapterNew(this, this.courselists, "", this);
                            this.binding.courseListRV.setAdapter(this.tileDataAdapter);
                            this.binding.courseListRV.setNestedScrollingEnabled(true);
                            return;
                        }
                        return;
                    }
                    this.binding.courseListRV.setVisibility(8);
                    this.binding.noData.noDataFoundRL.setVisibility(0);
                    return;
                }
                this.binding.courseListRV.setVisibility(8);
                this.binding.noData.noDataFoundRL.setVisibility(0);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public <Courselist> ArrayList<Courselist> removeDuplicates(ArrayList<Courselist> list) {
        ArrayList<Courselist> arrayList = new ArrayList<>();
        for (Courselist courselist : list) {
            if (!arrayList.isEmpty()) {
                int i = 0;
                while (true) {
                    if (i < arrayList.size()) {
                        if (arrayList.get(i).getId().equalsIgnoreCase(courselist.getId())) {
                            break;
                        }
                        i++;
                    } else {
                        arrayList.add(courselist);
                        break;
                    }
                }
            } else {
                arrayList.add(courselist);
            }
        }
        return arrayList;
    }

    @Override // com.appnew.android.loginRevamp.Adapter.CourseDataAdapterNew.ItemClicked
    public void onItemClicked(String courseId) {
        this.course_id = courseId;
        this.binding.signupBtn.setVisibility(0);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    private void pushEventForFreeCourse() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_id", AnalyticHelper.INSTANCE.getUserId());
        map.put(AnalyticsConstants.user_name, AnalyticHelper.INSTANCE.getUserName());
        map.put("course_id", this.course_id);
        map.put(AnalyticsConstants.course_name, "NA");
        AnalyticEvents.INSTANCE.pushEvents(this, AnalyticsConstants.FREE_USER, map);
    }
}
