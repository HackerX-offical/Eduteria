package com.appnew.android.Courses.Activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Adapter.ComboListAdapter;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.COURSEDETAIL.CourseDetail;
import com.appnew.android.Model.ComboCourseModel;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Payment.PurchaseActivity;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.GenericUtils;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.home.model.Search.RecentData;
import com.appnew.android.home.model.Search.RecentList;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class ComboSearchActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack, ComboListAdapter.onButtonClicked {
    ArrayAdapter<String> adapter;
    Button backBtn;
    ImageView clearIV;
    ComboCourseModel comboCourseModel;
    ComboListAdapter comboListAdapter;
    AutoCompleteTextView et_search;
    ImageView imageBack;
    NetworkCall networkCall;
    RelativeLayout no_data_found_RL;
    ProgressBar paginationLoader;
    RecyclerView searchListRV;
    private Runnable searchRunnable;
    CourseDetail singleStudy;
    boolean status;
    public String title;
    ArrayList<Courselist> courseDataArrayList = new ArrayList<>();
    int pageItemLimit = 20;
    private int mPage = 1;
    private boolean loading = false;
    private boolean isPaginationAvailable = true;
    public String isPurchased = "";
    private Handler handler = new Handler();

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.enableScreenShot(this);
        setContentView(R.layout.activity_search_combo);
        this.networkCall = new NetworkCall(this, this);
        this.imageBack = (ImageView) findViewById(R.id.imageBack);
        this.clearIV = (ImageView) findViewById(R.id.clearIV);
        this.et_search = (AutoCompleteTextView) findViewById(R.id.et_search);
        this.paginationLoader = (ProgressBar) findViewById(R.id.progressBar);
        this.no_data_found_RL = (RelativeLayout) findViewById(R.id.no_data_found_RL);
        this.searchListRV = (RecyclerView) findViewById(R.id.searchListRV);
        View viewFindViewById = findViewById(R.id.root);
        if (Build.VERSION.SDK_INT == 36) {
            EdgeToEdgeHelperOld.applyInsets(this, getWindow(), viewFindViewById, false, null);
        }
        this.searchListRV.setLayoutManager(new LinearLayoutManager(this));
        this.searchListRV.setHasFixedSize(true);
        this.no_data_found_RL.setVisibility(0);
        this.searchListRV.setVisibility(8);
        if (getIntent() != null) {
            this.singleStudy = (CourseDetail) getIntent().getSerializableExtra(Const.SINGLE_STUDY_DATA);
            this.title = getIntent().getStringExtra("title");
        }
        CourseDetail courseDetail = this.singleStudy;
        if (courseDetail != null && courseDetail.getData().getCourseDetail() != null && !TextUtils.isEmpty(this.singleStudy.getData().getCourseDetail().getIsPurchased())) {
            this.isPurchased = this.singleStudy.getData().getCourseDetail().getIsPurchased();
        }
        this.adapter = new ArrayAdapter<>(this, R.layout.item_view, getRecentList());
        this.et_search.setThreshold(5);
        this.et_search.setAdapter(this.adapter);
        this.et_search.setOnKeyListener(new View.OnKeyListener() { // from class: com.appnew.android.Courses.Activity.ComboSearchActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                return this.f$0.lambda$onCreate$0(view, i, keyEvent);
            }
        });
        this.et_search.addTextChangedListener(new AnonymousClass1());
        this.searchListRV.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.appnew.android.Courses.Activity.ComboSearchActivity.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (linearLayoutManager == null || dy <= 0) {
                    return;
                }
                int childCount = linearLayoutManager.getChildCount();
                int itemCount = linearLayoutManager.getItemCount();
                int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                if (ComboSearchActivity.this.paginationLoader == null || ComboSearchActivity.this.paginationLoader.isShown() || !ComboSearchActivity.this.loading || !ComboSearchActivity.this.isPaginationAvailable || childCount + iFindFirstVisibleItemPosition < itemCount) {
                    return;
                }
                ComboSearchActivity.this.paginationLoader.setVisibility(0);
                ComboSearchActivity.this.mPage++;
                ComboSearchActivity.this.status = true;
                ComboSearchActivity.this.getCourseData(false);
            }
        });
        setClicks();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreate$0(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || i != 66) {
            return false;
        }
        if (this.et_search.getText().toString().trim().equalsIgnoreCase("")) {
            Toast.makeText(this, getResources().getString(R.string.please_enter_search_value), 0).show();
        } else {
            initialState();
            this.status = false;
            getCourseData(true);
            setRecentList(this.et_search.getText().toString());
            Helper.hideSoftKeyboard(this);
        }
        return true;
    }

    /* JADX INFO: renamed from: com.appnew.android.Courses.Activity.ComboSearchActivity$1, reason: invalid class name */
    class AnonymousClass1 implements TextWatcher {
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        AnonymousClass1() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(final CharSequence s, int start, int before, int count) {
            try {
                ComboSearchActivity.this.handler.removeCallbacks(ComboSearchActivity.this.searchRunnable);
                ComboSearchActivity.this.searchRunnable = new Runnable() { // from class: com.appnew.android.Courses.Activity.ComboSearchActivity$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onTextChanged$0(s);
                    }
                };
                ComboSearchActivity.this.handler.postDelayed(ComboSearchActivity.this.searchRunnable, 300L);
            } catch (Exception e2) {
                Log.d("TAGSEARCH", "onTextChanged: " + e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChanged$0(CharSequence charSequence) {
            if (TextUtils.isEmpty(charSequence.toString())) {
                return;
            }
            ComboSearchActivity.this.initialState();
            ComboSearchActivity.this.status = false;
            ComboSearchActivity.this.getCourseData(false);
            ComboSearchActivity comboSearchActivity = ComboSearchActivity.this;
            comboSearchActivity.setRecentList(comboSearchActivity.et_search.getText().toString());
        }
    }

    private void setClicks() {
        this.clearIV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.ComboSearchActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ComboSearchActivity.this.et_search.setText("");
                ComboSearchActivity.this.no_data_found_RL.setVisibility(0);
                ComboSearchActivity.this.searchListRV.setVisibility(8);
            }
        });
        this.imageBack.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.ComboSearchActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ComboSearchActivity.this.finish();
            }
        });
    }

    public ArrayList<String> getRecentList() {
        ArrayList<RecentData> recentList;
        ArrayList<String> arrayList = new ArrayList<>();
        if (SharedPreference.getInstance().getRecentData() != null && (recentList = SharedPreference.getInstance().getRecentData().getRecentList()) != null && !recentList.isEmpty()) {
            for (RecentData recentData : recentList) {
                if (recentData.getUserId().equalsIgnoreCase(SharedPreference.getInstance().getLoggedInUser().getId())) {
                    arrayList.add(recentData.getQueryData());
                }
            }
        }
        return arrayList;
    }

    public void setRecentList(String queryData) {
        try {
            if (TextUtils.isEmpty(queryData)) {
                return;
            }
            RecentData recentData = new RecentData(SharedPreference.getInstance().getLoggedInUser().getId(), queryData);
            if (SharedPreference.getInstance().getRecentData() != null) {
                ArrayList<RecentData> recentList = SharedPreference.getInstance().getRecentData().getRecentList();
                if (recentList != null && !recentList.isEmpty()) {
                    boolean z = false;
                    for (int i = 0; i < recentList.size(); i++) {
                        if (recentList.get(i).getUserId().equalsIgnoreCase(SharedPreference.getInstance().getLoggedInUser().getId()) && recentList.get(i).getQueryData().equalsIgnoreCase(queryData)) {
                            recentList.set(i, recentData);
                            z = true;
                        }
                    }
                    if (!z) {
                        recentList.add(recentData);
                        SharedPreference.getInstance().setRecentData(new RecentList(recentList));
                    } else {
                        SharedPreference.getInstance().setRecentData(new RecentList(recentList));
                    }
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(recentData);
                    SharedPreference.getInstance().setRecentData(new RecentList(arrayList));
                }
            } else {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(recentData);
                SharedPreference.getInstance().setRecentData(new RecentList(arrayList2));
            }
            this.adapter = new ArrayAdapter<>(this, R.layout.item_view, getRecentList());
            this.et_search.setThreshold(1);
            this.et_search.setAdapter(this.adapter);
            this.et_search.dismissDropDown();
        } catch (Exception e2) {
            Log.d("TAGCOMBOSEARCH", "setRecentList: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getCourseData(boolean showProgress) {
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
        encryptionData.setSearch(!TextUtils.isEmpty(this.et_search.getText().toString()) ? this.et_search.getText().toString().trim() : "");
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
                        runOnUiThread(new Runnable() { // from class: com.appnew.android.Courses.Activity.ComboSearchActivity$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$SuccessCallBack$1(jsonstring);
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
                                this.searchListRV.setVisibility(0);
                                ComboListAdapter comboListAdapter = new ComboListAdapter(this, this.courseDataArrayList, this.isPurchased, this);
                                this.comboListAdapter = comboListAdapter;
                                this.searchListRV.setAdapter(comboListAdapter);
                                this.comboListAdapter.notifyDataSetChanged();
                            } else {
                                this.no_data_found_RL.setVisibility(0);
                                this.searchListRV.setVisibility(8);
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
                    this.searchListRV.setVisibility(8);
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
    public /* synthetic */ void lambda$SuccessCallBack$1(JSONObject jSONObject) {
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
