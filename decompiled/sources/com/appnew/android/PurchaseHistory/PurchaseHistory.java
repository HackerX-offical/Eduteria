package com.appnew.android.PurchaseHistory;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.PurchaseHistoryModel;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Payment.PaymentGatewayListener;
import com.appnew.android.Payment.PaymentViewModel;
import com.appnew.android.PurchaseHistory.adapter.PurchaseHistoryAdapter;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.AppPermissionsRunTime;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.GenericUtils;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import com.razorpay.PaymentResultListener;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class PurchaseHistory extends AppCompatActivity implements NetworkCall.MyNetworkCallBack, PaymentResultListener {
    Button backBtn;
    private ImageView image_back;
    public ArrayList<AppPermissionsRunTime.MyPermissionConstants> myPermissionConstantsArrayList;
    private NestedScrollView nestedScrollView;
    NetworkCall networkCall;
    RelativeLayout no_data_found_RL;
    ProgressBar paginationLoader;
    PaymentViewModel paymentViewModel;
    PurchaseHistoryModel pucPurchaseHistoryModel;
    private SwipeRefreshLayout pullToReferesh;
    PurchaseHistoryAdapter purchaseHistoryAdapter;
    RecyclerView purchase_history;
    int server_time;
    boolean status;
    TextView toolbarTitleTV;
    ArrayList<PurchaseHistoryModel.Data> history_list = new ArrayList<>();
    private int mPage = 1;
    private boolean loading = false;
    public final int REQUEST_CODE_PERMISSION_MULTIPLE = 123;
    private boolean isPaginationAvailable = true;
    private String type = "1";

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        Exception exc;
        PurchaseHistory purchaseHistory;
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.purchase_history_activity);
        try {
            PaymentViewModel paymentViewModel = (PaymentViewModel) new ViewModelProvider(this).get(PaymentViewModel.class);
            this.paymentViewModel = paymentViewModel;
            paymentViewModel.initPaymentGateway(this, new PaymentGatewayListener() { // from class: com.appnew.android.PurchaseHistory.PurchaseHistory.1
                @Override // com.appnew.android.Payment.PaymentGatewayListener
                public void onSuccessEsewa(String productId, String totalAmount, String referenceId, String scdId) {
                    PurchaseHistory.this.purchaseHistoryAdapter.onSuccessEsewa(productId, totalAmount, referenceId, scdId);
                    PurchaseHistory.this.networkCall.NetworkAPICall(API.int_payment, "", true, false);
                }

                @Override // com.appnew.android.Payment.PaymentGatewayListener
                public void onSuccess(String posTxnId) {
                    PurchaseHistory.this.purchaseHistoryAdapter.onSuccess(posTxnId);
                    PurchaseHistory.this.networkCall.NetworkAPICall(API.int_payment, "", true, false);
                }

                @Override // com.appnew.android.Payment.PaymentGatewayListener
                public void onFailed(boolean isFailure) {
                    PurchaseHistory.this.purchaseHistoryAdapter.onFailure("");
                }
            }, "");
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(67108864);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
            this.toolbarTitleTV = (TextView) findViewById(R.id.toolbarTitleTV);
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.purchase_history);
            this.purchase_history = recyclerView;
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            this.purchase_history.setNestedScrollingEnabled(false);
            this.image_back = (ImageView) findViewById(R.id.image_back);
            this.networkCall = new NetworkCall(this, this);
            this.pullToReferesh = (SwipeRefreshLayout) findViewById(R.id.pullto_referesh);
            this.nestedScrollView = (NestedScrollView) findViewById(R.id.nested_scroll);
            this.paginationLoader = (ProgressBar) findViewById(R.id.progressBar);
            this.no_data_found_RL = (RelativeLayout) findViewById(R.id.no_data_found_RL);
            this.backBtn = (Button) findViewById(R.id.backBtn);
            View viewFindViewById = findViewById(R.id.root);
            Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
            if (Build.VERSION.SDK_INT == 36) {
                try {
                    EdgeToEdgeHelperOld.applyHeaderWithToolbar(this, getWindow(), viewFindViewById, toolbar);
                } catch (Exception e2) {
                    exc = e2;
                    exc.printStackTrace();
                    return;
                }
            }
            if (getIntent().hasExtra("type")) {
                this.type = getIntent().getStringExtra("type");
            }
            if (this.history_list.size() == 0) {
                if (this.type.equalsIgnoreCase("1")) {
                    hit_api_for_data(true);
                } else {
                    hit_api_for_data_book_listing(true);
                }
                purchaseHistory = this;
            } else {
                this.no_data_found_RL.setVisibility(8);
                this.purchase_history.setVisibility(0);
                purchaseHistory = this;
                try {
                    PurchaseHistoryAdapter purchaseHistoryAdapter = new PurchaseHistoryAdapter(purchaseHistory, this.history_list, this.server_time, this.paymentViewModel, this.type);
                    purchaseHistory.purchaseHistoryAdapter = purchaseHistoryAdapter;
                    purchaseHistory.purchase_history.setAdapter(purchaseHistoryAdapter);
                } catch (Exception e3) {
                    e = e3;
                    exc = e;
                    exc.printStackTrace();
                    return;
                }
            }
            purchaseHistory.pullToReferesh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.appnew.android.PurchaseHistory.PurchaseHistory$$ExternalSyntheticLambda2
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    this.f$0.lambda$onCreate$0();
                }
            });
            purchaseHistory.nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.appnew.android.PurchaseHistory.PurchaseHistory$$ExternalSyntheticLambda3
                @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
                public final void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                    this.f$0.lambda$onCreate$1(nestedScrollView, i, i2, i3, i4);
                }
            });
            if (purchaseHistory.type.equalsIgnoreCase("1")) {
                purchaseHistory.toolbarTitleTV.setText(getString(R.string.purchase_history));
            } else {
                purchaseHistory.toolbarTitleTV.setText(getString(R.string.book_purchase_history));
            }
            setClicks();
        } catch (Exception e4) {
            e = e4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0() {
        initialState();
        this.status = false;
        if (this.type.equalsIgnoreCase("1")) {
            hit_api_for_data(true);
        } else {
            hit_api_for_data_book_listing(true);
        }
        this.pullToReferesh.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        if (nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1) == null || i2 < nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1).getMeasuredHeight() - nestedScrollView.getMeasuredHeight() || i2 <= i4 || !this.loading || !this.isPaginationAvailable) {
            return;
        }
        this.paginationLoader.setVisibility(0);
        this.mPage++;
        this.status = true;
        if (this.type.equalsIgnoreCase("1")) {
            hit_api_for_data(false);
        } else {
            hit_api_for_data_book_listing(false);
        }
    }

    private void setClicks() {
        this.image_back.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.PurchaseHistory.PurchaseHistory$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$2();
            }
        }));
        this.backBtn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.PurchaseHistory.PurchaseHistory$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$3();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$2() {
        finish();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$3() {
        finish();
        return null;
    }

    public void refreshdata() {
        initialState();
        this.status = false;
        if (this.type.equalsIgnoreCase("1")) {
            hit_api_for_data(false);
        } else {
            hit_api_for_data_book_listing(false);
        }
    }

    private void hit_api_for_data(boolean showProgress) {
        this.networkCall.NetworkAPICall(API.get_my_orders, "", showProgress, false);
    }

    private void hit_api_for_data_book_listing(boolean showProgress) {
        this.networkCall.NetworkAPICall(API.get_book_orders, "", showProgress, false);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (apitype.equals(API.get_my_orders)) {
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setPage("" + this.mPage);
            encryptionData.setType("0");
            return service.get_my_orders(AES.encrypt(new Gson().toJson(encryptionData)));
        }
        if (!apitype.equals(API.get_book_orders)) {
            return null;
        }
        EncryptionData encryptionData2 = new EncryptionData();
        encryptionData2.setPage("" + this.mPage);
        return service.get_book_orders(AES.encrypt(new Gson().toJson(encryptionData2)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals(API.get_my_orders)) {
            try {
                if (jsonstring.getString("status").equalsIgnoreCase("true")) {
                    this.server_time = Integer.parseInt(jsonstring.optString("time"));
                    this.isPaginationAvailable = true;
                    if (this.status) {
                        PurchaseHistoryModel purchaseHistoryModel = (PurchaseHistoryModel) new Gson().fromJson(jsonstring.toString(), PurchaseHistoryModel.class);
                        this.pucPurchaseHistoryModel = purchaseHistoryModel;
                        if (purchaseHistoryModel.getData() != null) {
                            int size = this.history_list.size();
                            if (this.history_list.size() > 0) {
                                this.history_list.addAll(this.pucPurchaseHistoryModel.getData());
                                this.purchaseHistoryAdapter.change_time(this.server_time);
                                this.purchaseHistoryAdapter.notifyItemRangeInserted(this.history_list.size() - 1, this.history_list.size() - size);
                            }
                        }
                    } else {
                        initialState();
                        this.pucPurchaseHistoryModel = (PurchaseHistoryModel) new Gson().fromJson(jsonstring.toString(), PurchaseHistoryModel.class);
                        ArrayList<PurchaseHistoryModel.Data> arrayList = this.history_list;
                        if (arrayList != null && arrayList.size() != 0) {
                            this.history_list.clear();
                        }
                        if (this.pucPurchaseHistoryModel.getData() != null) {
                            this.history_list.addAll(this.pucPurchaseHistoryModel.getData());
                            if (this.history_list.size() > 0) {
                                this.no_data_found_RL.setVisibility(8);
                                this.purchase_history.setVisibility(0);
                                PurchaseHistoryAdapter purchaseHistoryAdapter = new PurchaseHistoryAdapter(this, this.history_list, this.server_time, this.paymentViewModel, this.type);
                                this.purchaseHistoryAdapter = purchaseHistoryAdapter;
                                this.purchase_history.setAdapter(purchaseHistoryAdapter);
                                this.purchaseHistoryAdapter.notifyDataSetChanged();
                            } else {
                                this.no_data_found_RL.setVisibility(0);
                                this.purchase_history.setVisibility(8);
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
                int i = Integer.parseInt(jsonstring.optString("time"));
                this.server_time = i;
                PurchaseHistoryAdapter purchaseHistoryAdapter2 = this.purchaseHistoryAdapter;
                if (purchaseHistoryAdapter2 != null) {
                    purchaseHistoryAdapter2.change_time(i);
                }
                this.isPaginationAvailable = false;
                ProgressBar progressBar2 = this.paginationLoader;
                if (progressBar2 != null && progressBar2.isShown()) {
                    this.paginationLoader.setVisibility(8);
                }
                if (!this.status || !jsonstring.getString("message").equalsIgnoreCase("No Course Found.")) {
                    this.no_data_found_RL.setVisibility(0);
                    this.purchase_history.setVisibility(8);
                }
                if (!jsonstring.has("auth_code") || GenericUtils.isEmpty(jsonstring.getString("auth_code"))) {
                    return;
                }
                RetrofitResponse.GetApiData(this, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
                return;
            } catch (Exception unused) {
                return;
            }
        }
        if (apitype.equals(API.get_book_orders)) {
            try {
                if (jsonstring.getString("status").equalsIgnoreCase("true")) {
                    this.server_time = Integer.parseInt(jsonstring.optString("time"));
                    this.isPaginationAvailable = true;
                    if (this.status) {
                        PurchaseHistoryModel purchaseHistoryModel2 = (PurchaseHistoryModel) new Gson().fromJson(jsonstring.toString(), PurchaseHistoryModel.class);
                        this.pucPurchaseHistoryModel = purchaseHistoryModel2;
                        if (purchaseHistoryModel2.getData() != null) {
                            int size2 = this.history_list.size();
                            if (this.history_list.size() > 0) {
                                this.history_list.addAll(this.pucPurchaseHistoryModel.getData());
                                this.purchaseHistoryAdapter.change_time(this.server_time);
                                this.purchaseHistoryAdapter.notifyItemRangeInserted(this.history_list.size() - 1, this.history_list.size() - size2);
                            }
                        }
                    } else {
                        initialState();
                        this.pucPurchaseHistoryModel = (PurchaseHistoryModel) new Gson().fromJson(jsonstring.toString(), PurchaseHistoryModel.class);
                        ArrayList<PurchaseHistoryModel.Data> arrayList2 = this.history_list;
                        if (arrayList2 != null && arrayList2.size() != 0) {
                            this.history_list.clear();
                        }
                        if (this.pucPurchaseHistoryModel.getData() != null) {
                            this.history_list.addAll(this.pucPurchaseHistoryModel.getData());
                            if (this.history_list.size() > 0) {
                                this.no_data_found_RL.setVisibility(8);
                                this.purchase_history.setVisibility(0);
                                PurchaseHistoryAdapter purchaseHistoryAdapter3 = new PurchaseHistoryAdapter(this, this.history_list, this.server_time, this.paymentViewModel, this.type);
                                this.purchaseHistoryAdapter = purchaseHistoryAdapter3;
                                this.purchase_history.setAdapter(purchaseHistoryAdapter3);
                                this.purchaseHistoryAdapter.notifyDataSetChanged();
                            } else {
                                this.no_data_found_RL.setVisibility(0);
                                this.purchase_history.setVisibility(8);
                            }
                        } else {
                            Toast.makeText(this, getResources().getString(R.string.data_not_found), 0).show();
                        }
                    }
                    ProgressBar progressBar3 = this.paginationLoader;
                    if (progressBar3 == null || !progressBar3.isShown()) {
                        return;
                    }
                    this.paginationLoader.setVisibility(8);
                    return;
                }
                int time_server = (int) MakeMyExam.getTime_server();
                this.server_time = time_server;
                PurchaseHistoryAdapter purchaseHistoryAdapter4 = this.purchaseHistoryAdapter;
                if (purchaseHistoryAdapter4 != null) {
                    purchaseHistoryAdapter4.change_time(time_server);
                }
                this.isPaginationAvailable = false;
                ProgressBar progressBar4 = this.paginationLoader;
                if (progressBar4 != null && progressBar4.isShown()) {
                    this.paginationLoader.setVisibility(8);
                }
                if (!this.status || !jsonstring.getString("message").equalsIgnoreCase("Data Not Found")) {
                    this.no_data_found_RL.setVisibility(0);
                    this.purchase_history.setVisibility(8);
                }
                if (!jsonstring.has("auth_code") || GenericUtils.isEmpty(jsonstring.getString("auth_code"))) {
                    return;
                }
                RetrofitResponse.GetApiData(this, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void initialState() {
        this.mPage = 1;
        this.loading = true;
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        ProgressBar progressBar;
        apitype.hashCode();
        if (apitype.equals(API.get_my_orders) && (progressBar = this.paginationLoader) != null && progressBar.isShown()) {
            this.paginationLoader.setVisibility(8);
        }
    }

    @Override // com.razorpay.PaymentResultListener
    public void onPaymentSuccess(String s) {
        try {
            this.purchaseHistoryAdapter.onSuccessListner.onSuccess(s);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.razorpay.PaymentResultListener
    public void onPaymentError(int i, String s) {
        try {
            this.purchaseHistoryAdapter.onSuccessListner.onFailure("" + i + "~!@#$%^&" + s);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Toast.makeText(this, "" + s, 0).show();
    }
}
