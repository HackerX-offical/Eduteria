package com.appnew.android.Courses.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Adapter.ComboListAdapter;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.COURSEDETAIL.CourseDetail;
import com.appnew.android.Model.ComboCourseModel;
import com.appnew.android.Model.Courselist;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Payment.PurchaseActivity;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.GenericUtils;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class ComboListActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack, ComboListAdapter.onButtonClicked {
    Button backBtn;
    ComboCourseModel comboCourseModel;
    ComboListAdapter comboListAdapter;
    RecyclerView comboRV;
    private ImageView image_back;
    NetworkCall networkCall;
    RelativeLayout no_data_found_RL;
    ProgressBar paginationLoader;
    private ImageView searchIV;
    CourseDetail singleStudy;
    boolean status;
    public String title;
    TextView toolbarTitleTV;
    ArrayList<Courselist> courseDataArrayList = new ArrayList<>();
    int pageItemLimit = 20;
    private int mPage = 1;
    private boolean loading = false;
    private boolean isPaginationAvailable = true;
    public String isPurchased = "";

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.combo_list_activity);
        try {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(67108864);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
            this.image_back = (ImageView) findViewById(R.id.image_back);
            this.searchIV = (ImageView) findViewById(R.id.searchIV);
            this.paginationLoader = (ProgressBar) findViewById(R.id.progressBar);
            this.no_data_found_RL = (RelativeLayout) findViewById(R.id.no_data_found_RL);
            this.backBtn = (Button) findViewById(R.id.backBtn);
            this.toolbarTitleTV = (TextView) findViewById(R.id.toolbarTitleTV);
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.comboRV);
            this.comboRV = recyclerView;
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            this.comboRV.setHasFixedSize(true);
            this.networkCall = new NetworkCall(this, this);
            if (getIntent() != null) {
                this.singleStudy = (CourseDetail) getIntent().getSerializableExtra(Const.SINGLE_STUDY_DATA);
                this.title = getIntent().getStringExtra("title");
            }
            this.toolbarTitleTV.setText(this.title);
            CourseDetail courseDetail = this.singleStudy;
            if (courseDetail != null && courseDetail.getData().getCourseDetail() != null && !TextUtils.isEmpty(this.singleStudy.getData().getCourseDetail().getIsPurchased())) {
                this.isPurchased = this.singleStudy.getData().getCourseDetail().getIsPurchased();
            }
            if (this.courseDataArrayList.isEmpty()) {
                hit_api_for_data(true);
            } else {
                this.no_data_found_RL.setVisibility(8);
                this.comboRV.setVisibility(0);
                ComboListAdapter comboListAdapter = new ComboListAdapter(this, this.courseDataArrayList, this.isPurchased, this);
                this.comboListAdapter = comboListAdapter;
                this.comboRV.setAdapter(comboListAdapter);
            }
            this.comboRV.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.appnew.android.Courses.Activity.ComboListActivity.1
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView2, int dx, int dy) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView2.getLayoutManager();
                    if (linearLayoutManager == null || dy <= 0) {
                        return;
                    }
                    int childCount = linearLayoutManager.getChildCount();
                    int itemCount = linearLayoutManager.getItemCount();
                    int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                    if (ComboListActivity.this.paginationLoader == null || ComboListActivity.this.paginationLoader.isShown() || !ComboListActivity.this.loading || !ComboListActivity.this.isPaginationAvailable || childCount + iFindFirstVisibleItemPosition < itemCount) {
                        return;
                    }
                    ComboListActivity.this.paginationLoader.setVisibility(0);
                    ComboListActivity.this.mPage++;
                    ComboListActivity.this.status = true;
                    ComboListActivity.this.hit_api_for_data(false);
                }
            });
            setClicks();
        } catch (Exception e2) {
            Log.d("TAGCOMBOCOURSE", "onCreate: " + e2.getMessage());
        }
    }

    private void setClicks() {
        this.image_back.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Activity.ComboListActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$0();
            }
        }));
        this.backBtn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Activity.ComboListActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$1();
            }
        }));
        this.searchIV.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Activity.ComboListActivity$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$2();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$0() {
        finish();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$1() {
        finish();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$2() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Intent intent = new Intent(this, (Class<?>) ComboSearchActivity.class);
        intent.putExtra("title", this.title);
        intent.putExtra(Const.SINGLE_STUDY_DATA, this.singleStudy);
        Helper.gotoActivity(intent, this);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hit_api_for_data(boolean showProgress) {
        this.networkCall.NetworkAPICall(API.get_combo_course_list, "", showProgress, false);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals(API.get_combo_course_list)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setCourse_id(this.singleStudy.getData().getCourseDetail().getId());
        encryptionData.setSearch("");
        encryptionData.setPage("" + this.mPage);
        return service.get_combo_course_list(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(final JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals(API.get_combo_course_list)) {
            try {
                if (jsonstring.getString("status").equalsIgnoreCase("true")) {
                    if (this.status) {
                        runOnUiThread(new Runnable() { // from class: com.appnew.android.Courses.Activity.ComboListActivity$$ExternalSyntheticLambda3
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$SuccessCallBack$3(jsonstring);
                            }
                        });
                    } else {
                        initialState();
                        ComboCourseModel comboCourseModel = (ComboCourseModel) new Gson().fromJson(jsonstring.toString(), ComboCourseModel.class);
                        this.comboCourseModel = comboCourseModel;
                        this.isPaginationAvailable = (comboCourseModel == null || comboCourseModel.getData() == null || this.comboCourseModel.getData().size() < this.pageItemLimit) ? false : true;
                        ArrayList<Courselist> arrayList = this.courseDataArrayList;
                        if (arrayList != null && !arrayList.isEmpty()) {
                            this.courseDataArrayList.clear();
                        }
                        if (this.comboCourseModel.getData() != null) {
                            this.courseDataArrayList.addAll(this.comboCourseModel.getData());
                            if (!this.courseDataArrayList.isEmpty()) {
                                this.no_data_found_RL.setVisibility(8);
                                this.comboRV.setVisibility(0);
                                ComboListAdapter comboListAdapter = new ComboListAdapter(this, this.courseDataArrayList, this.isPurchased, this);
                                this.comboListAdapter = comboListAdapter;
                                this.comboRV.setAdapter(comboListAdapter);
                                this.comboListAdapter.notifyDataSetChanged();
                            } else {
                                this.no_data_found_RL.setVisibility(0);
                                this.comboRV.setVisibility(8);
                            }
                        } else {
                            Toast.makeText(this, getResources().getString(R.string.data_not_found), 0).show();
                        }
                    }
                    ProgressBar progressBar = this.paginationLoader;
                    if (progressBar == null || !progressBar.isShown()) {
                        return;
                    }
                    this.paginationLoader.setVisibility(8);
                    return;
                }
                this.isPaginationAvailable = false;
                ProgressBar progressBar2 = this.paginationLoader;
                if (progressBar2 != null && progressBar2.isShown()) {
                    this.paginationLoader.setVisibility(8);
                }
                if (!this.status || !jsonstring.getString("message").equalsIgnoreCase("No Course Found.")) {
                    this.no_data_found_RL.setVisibility(0);
                    this.comboRV.setVisibility(8);
                }
                if (!jsonstring.has("auth_code") || GenericUtils.isEmpty(jsonstring.getString("auth_code"))) {
                    return;
                }
                RetrofitResponse.GetApiData(this, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
            } catch (Exception e2) {
                Log.d("TAGCOMBOCOURSE", "SuccessCallBack: " + e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$SuccessCallBack$3(JSONObject jSONObject) {
        ComboCourseModel comboCourseModel = (ComboCourseModel) new Gson().fromJson(jSONObject.toString(), ComboCourseModel.class);
        this.comboCourseModel = comboCourseModel;
        this.isPaginationAvailable = (comboCourseModel == null || comboCourseModel.getData() == null || this.comboCourseModel.getData().size() < this.pageItemLimit) ? false : true;
        if (this.comboCourseModel.getData() != null) {
            int size = this.courseDataArrayList.size();
            if (this.courseDataArrayList.isEmpty()) {
                return;
            }
            this.courseDataArrayList.addAll(this.comboCourseModel.getData());
            this.comboListAdapter.notifyItemRangeInserted(this.courseDataArrayList.size() - 1, this.courseDataArrayList.size() - size);
        }
    }

    public void initialState() {
        this.mPage = 1;
        this.loading = true;
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        ProgressBar progressBar;
        if (apitype.equals(API.get_combo_course_list) && (progressBar = this.paginationLoader) != null && progressBar.isShown()) {
            this.paginationLoader.setVisibility(8);
        }
    }

    @Override // com.appnew.android.Courses.Adapter.ComboListAdapter.onButtonClicked
    public void onCourseClicked(int pos) {
        if (this.courseDataArrayList.get(pos).getIs_locked().equalsIgnoreCase("1")) {
            Intent intent = new Intent(this, (Class<?>) PurchaseActivity.class);
            intent.putExtra(Const.SINGLE_STUDY, this.singleStudy);
            intent.putExtra(Const.IS_BOOK, this.singleStudy.getData().getCourseDetail().getCat_type());
            intent.putExtra(Const.DELIVERY_CHARGE, this.singleStudy.getData().getCourseDetail().getDelivery_charge());
            Helper.gotoActivity(intent, this);
            return;
        }
        if (TextUtils.isEmpty(this.courseDataArrayList.get(pos).getMaintenanceText())) {
            Intent intent2 = new Intent(this, (Class<?>) CourseActivity.class);
            intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
            intent2.putExtra(Const.COURSE_ID_MAIN, this.courseDataArrayList.get(pos).getId());
            intent2.putExtra(Const.COURSE_PARENT_ID, this.singleStudy.getData().getCourseDetail().getId());
            intent2.putExtra(Const.CONTENT_TYPE_1, this.courseDataArrayList.get(pos).getContent_type());
            intent2.putExtra(Const.IS_COMBO, true);
            intent2.putExtra("valid_to", this.singleStudy.getData().getCourseDetail().getValid_to());
            intent2.putExtra(AnalyticsConstants.course_name, this.title);
            Helper.gotoActivity(intent2, this);
            return;
        }
        Helper.getCourseMaintanaceDialog(this, "", this.courseDataArrayList.get(pos).getMaintenanceText());
    }
}
