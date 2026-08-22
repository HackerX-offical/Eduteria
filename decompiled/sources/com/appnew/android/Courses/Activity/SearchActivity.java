package com.appnew.android.Courses.Activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.BottomSetting;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Payment.PaymentGatewayListener;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.home.adapters.TileDataAdapter;
import com.appnew.android.home.model.CourseResponse;
import com.appnew.android.home.model.Search.RecentData;
import com.appnew.android.home.model.Search.RecentList;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import com.paytm.pgsdk.Constants;
import com.razorpay.PaymentResultListener;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class SearchActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack, PaymentGatewayListener, PaymentResultListener {
    ArrayAdapter<String> adapter;
    private BottomSetting bottomSetting;
    ImageView clearIV;
    ImageView errorLL;
    AutoCompleteTextView et_search;
    ImageView imageBack;
    NetworkCall networkCall;
    TextView no_data_found;
    RecyclerView searchListRV;
    TileDataAdapter tileDataAdapter;
    UtkashRoom utkashRoom;
    private int pagecount = 1;
    int count = 0;
    String contentType_id = "";
    String allsubcatindex_id = "";
    ArrayList<Courselist> courselists = new ArrayList<>();

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.enableScreenShot(this);
        setContentView(R.layout.activity_search);
        this.utkashRoom = UtkashRoom.getAppDatabase(this);
        this.networkCall = new NetworkCall(this, this);
        this.imageBack = (ImageView) findViewById(R.id.imageBack);
        this.clearIV = (ImageView) findViewById(R.id.clearIV);
        this.et_search = (AutoCompleteTextView) findViewById(R.id.et_search);
        this.searchListRV = (RecyclerView) findViewById(R.id.searchListRV);
        this.errorLL = (ImageView) findViewById(R.id.no_data);
        this.no_data_found = (TextView) findViewById(R.id.no_data_found);
        View viewFindViewById = findViewById(R.id.root);
        if (Build.VERSION.SDK_INT == 36) {
            EdgeToEdgeHelperOld.applyInsets(this, getWindow(), viewFindViewById, false, null);
        }
        this.searchListRV.setVisibility(8);
        this.errorLL.setVisibility(0);
        if (getIntent() != null) {
            this.contentType_id = getIntent().getStringExtra("couse_type");
            this.allsubcatindex_id = getIntent().getStringExtra("allsubcatindex");
        }
        this.adapter = new ArrayAdapter<>(this, R.layout.item_view, getRecentList());
        this.et_search.setThreshold(1);
        this.et_search.setAdapter(this.adapter);
        this.et_search.setOnKeyListener(new View.OnKeyListener() { // from class: com.appnew.android.Courses.Activity.SearchActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                return this.f$0.lambda$onCreate$0(view, i, keyEvent);
            }
        });
        this.clearIV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.SearchActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SearchActivity.this.et_search.setText("");
            }
        });
        this.imageBack.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.SearchActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SearchActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreate$0(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || i != 66) {
            return false;
        }
        if (this.et_search.getText().toString().trim().equalsIgnoreCase("")) {
            this.no_data_found.setVisibility(8);
            Toast.makeText(this, getResources().getString(R.string.please_enter_search_value), 0).show();
            return true;
        }
        setRecentList(this.et_search.getText().toString());
        getCourseData();
        Helper.hideSoftKeyboard(this);
        return true;
    }

    private void getCourseData() {
        this.networkCall.NetworkAPICall(API.get_courses, "", true, false);
    }

    public ArrayList<String> getRecentList() {
        ArrayList<RecentData> recentList;
        ArrayList<String> arrayList = new ArrayList<>();
        if (SharedPreference.getInstance().getRecentData() != null && (recentList = SharedPreference.getInstance().getRecentData().getRecentList()) != null && recentList.size() > 0) {
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
                if (recentList != null && recentList.size() > 0) {
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
        } catch (Exception unused) {
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals(API.get_courses)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setCourse_type(this.contentType_id);
        encryptionData.setSub_cat(this.allsubcatindex_id);
        encryptionData.setPage("1");
        encryptionData.setSearch(this.et_search.getText().toString().trim());
        return service.get_courses(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        int size;
        apitype.hashCode();
        if (apitype.equals(API.get_courses)) {
            try {
                if (jsonstring.optString("status").equals("true")) {
                    CourseResponse courseResponse = (CourseResponse) new Gson().fromJson(jsonstring.toString(), CourseResponse.class);
                    if (courseResponse.getData().size() > 0) {
                        this.searchListRV.setVisibility(0);
                        this.errorLL.setVisibility(8);
                        this.no_data_found.setVisibility(8);
                        if (courseResponse.getData().size() > 0) {
                            if (this.pagecount == 1) {
                                ArrayList<Courselist> arrayList = new ArrayList<>();
                                this.courselists = arrayList;
                                arrayList.addAll(courseResponse.getData());
                                new ArrayList();
                                ArrayList<Courselist> arrayListRemoveDuplicates = removeDuplicates(this.courselists);
                                this.courselists.clear();
                                if ("1".equalsIgnoreCase("5")) {
                                    for (Courselist courselist : arrayListRemoveDuplicates) {
                                        if (courselist.getExtra_json().getHome_screen().equalsIgnoreCase("1")) {
                                            this.courselists.add(courselist);
                                        }
                                    }
                                } else {
                                    this.courselists.addAll(arrayListRemoveDuplicates);
                                }
                                size = 0;
                            } else {
                                size = this.courselists.size();
                                this.courselists.addAll(courseResponse.getData());
                                new ArrayList();
                                ArrayList<Courselist> arrayListRemoveDuplicates2 = removeDuplicates(this.courselists);
                                this.courselists.clear();
                                if ("1".equalsIgnoreCase("5")) {
                                    for (Courselist courselist2 : arrayListRemoveDuplicates2) {
                                        if (courselist2.getExtra_json().getHome_screen().equalsIgnoreCase("1")) {
                                            this.courselists.add(courselist2);
                                        }
                                    }
                                } else {
                                    this.courselists.addAll(arrayListRemoveDuplicates2);
                                }
                            }
                            if (this.pagecount == 1) {
                                if ("1".equals("7")) {
                                    this.tileDataAdapter = new TileDataAdapter(this, this.courselists, "", this, this);
                                    this.searchListRV.setLayoutManager(new LinearLayoutManager(this));
                                    this.searchListRV.setAdapter(this.tileDataAdapter);
                                    this.searchListRV.setNestedScrollingEnabled(false);
                                    return;
                                }
                                if (this.utkashRoom.getthemeSettingdao().is_setting_exit()) {
                                    this.bottomSetting = (BottomSetting) new Gson().fromJson(this.utkashRoom.getthemeSettingdao().data().getBottom(), BottomSetting.class);
                                }
                                this.tileDataAdapter = new TileDataAdapter(this, this.courselists, "0", this, this);
                                BottomSetting bottomSetting = this.bottomSetting;
                                if (bottomSetting != null && bottomSetting.getLayout_type() != null && this.bottomSetting.getLayout_type().equals("1")) {
                                    this.searchListRV.setLayoutManager(new GridLayoutManager((Context) this, 2, 1, false));
                                    this.searchListRV.setLayoutParams(new RelativeLayout.LayoutParams(-2, -1));
                                } else {
                                    this.searchListRV.setLayoutManager(new LinearLayoutManager(this));
                                }
                                this.searchListRV.setAdapter(this.tileDataAdapter);
                                this.searchListRV.setNestedScrollingEnabled(false);
                                return;
                            }
                            this.tileDataAdapter.notifyItemRangeInserted(size - 1, this.courselists.size() - size);
                            return;
                        }
                        ArrayList<Courselist> arrayList2 = this.courselists;
                        if (arrayList2 == null || this.pagecount != 1) {
                            return;
                        }
                        arrayList2.clear();
                        this.searchListRV.setVisibility(8);
                        this.errorLL.setVisibility(0);
                        this.no_data_found.setVisibility(0);
                        return;
                    }
                    ArrayList<Courselist> arrayList3 = this.courselists;
                    if (arrayList3 == null || this.pagecount != 1) {
                        return;
                    }
                    arrayList3.clear();
                    this.searchListRV.setVisibility(8);
                    this.errorLL.setVisibility(0);
                    this.no_data_found.setVisibility(0);
                    return;
                }
                ArrayList<Courselist> arrayList4 = this.courselists;
                if (arrayList4 != null && this.pagecount == 1) {
                    arrayList4.clear();
                    this.searchListRV.setVisibility(8);
                    this.errorLL.setVisibility(0);
                    this.no_data_found.setVisibility(0);
                }
                int i = this.count;
                if (i == 0) {
                    this.count = i + 1;
                    RetrofitResponse.GetApiData(this, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
                }
            } catch (Exception e2) {
                Log.e(Constants.EVENT_ACTION_ERROR, "SuccessCallBack: " + e2.getLocalizedMessage());
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

    @Override // com.razorpay.PaymentResultListener
    public void onPaymentSuccess(String s) {
        TileDataAdapter tileDataAdapter = this.tileDataAdapter;
        if (tileDataAdapter != null) {
            tileDataAdapter.onPaymentSuccess(s);
        }
    }

    @Override // com.razorpay.PaymentResultListener
    public void onPaymentError(int i, String s) {
        TileDataAdapter tileDataAdapter = this.tileDataAdapter;
        if (tileDataAdapter != null) {
            tileDataAdapter.onPaymentError(i, s);
        }
    }

    @Override // com.appnew.android.Payment.PaymentGatewayListener
    public void onSuccess(String posTxnId) {
        TileDataAdapter tileDataAdapter = this.tileDataAdapter;
        if (tileDataAdapter != null) {
            tileDataAdapter.onSuccess(posTxnId);
        }
    }

    @Override // com.appnew.android.Payment.PaymentGatewayListener
    public void onSuccessEsewa(String productId, String totalAmount, String referenceId, String scdId) {
        TileDataAdapter tileDataAdapter = this.tileDataAdapter;
        if (tileDataAdapter != null) {
            tileDataAdapter.onSuccessEsewa(productId, totalAmount, referenceId, scdId);
        }
    }

    @Override // com.appnew.android.Payment.PaymentGatewayListener
    public void onFailed(boolean isFailure) {
        TileDataAdapter tileDataAdapter = this.tileDataAdapter;
        if (tileDataAdapter != null) {
            tileDataAdapter.onFailed(isFailure);
        }
    }
}
