package com.appnew.android.LiveTest.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.LiveTest.Activity.LivetestActivity;
import com.appnew.android.LiveTest.Adapter.Testclassadapter;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.GenericUtils;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.home.Constants;
import com.appnew.android.home.livetest.LiveTest;
import com.appnew.android.home.livetest.LiveTestData;
import com.eduteria.app.app.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class Ongoing extends Fragment implements NetworkCall.MyNetworkCallBack {
    Button backBtn;
    List<LiveTestData> liveTestData;
    LiveTest livetest;
    private NestedScrollView nestedScrollView;
    NetworkCall networkCall;
    RelativeLayout no_data_found_RL;
    private RecyclerView ongoingrecycler;
    ProgressBar paginationLoader;
    private SwipeRefreshLayout pullToReferesh;
    boolean status;
    Testclassadapter testclassadapter;
    Long time;
    boolean visibilty_status;
    boolean state = false;
    private int mPage = 1;
    private boolean loading = false;
    private boolean isPaginationAvailable = true;
    private boolean hitApi = true;
    private Handler endDateHandler = new Handler(Looper.getMainLooper());
    private Runnable endDateRunnable = null;
    private int pageSize = -1;

    public static Ongoing newInstance(String param1, String param2) {
        Ongoing ongoing = new Ongoing();
        new Bundle();
        return ongoing;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.networkCall = new NetworkCall(this, requireContext());
        if (this.liveTestData == null) {
            this.liveTestData = new ArrayList();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ongoing, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.state = SharedPreference.getInstance().getBoolean("state");
        this.ongoingrecycler = (RecyclerView) view.findViewById(R.id.ongoingrecycler);
        this.pullToReferesh = (SwipeRefreshLayout) view.findViewById(R.id.pullto_referesh);
        this.nestedScrollView = (NestedScrollView) view.findViewById(R.id.nested_scroll);
        this.paginationLoader = (ProgressBar) view.findViewById(R.id.progressBar);
        this.no_data_found_RL = (RelativeLayout) view.findViewById(R.id.no_data_found_RL);
        Button button = (Button) view.findViewById(R.id.backBtn);
        this.backBtn = button;
        button.setVisibility(8);
        this.ongoingrecycler.setNestedScrollingEnabled(false);
        this.ongoingrecycler.setHasFixedSize(false);
        if (this.liveTestData.size() == 0 || this.state) {
            this.hitApi = false;
            Helper.showProgressDialog(getActivity());
            hit_api_for_data(true);
            SharedPreference.getInstance().putBoolean("state", false);
        } else {
            this.no_data_found_RL.setVisibility(8);
            this.ongoingrecycler.setVisibility(0);
            Testclassadapter testclassadapter = new Testclassadapter(getActivity(), this.liveTestData, true, this.time);
            this.testclassadapter = testclassadapter;
            this.ongoingrecycler.setAdapter(testclassadapter);
        }
        this.pullToReferesh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.appnew.android.LiveTest.Fragment.Ongoing$$ExternalSyntheticLambda5
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                this.f$0.lambda$onViewCreated$0();
            }
        });
        this.nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.appnew.android.LiveTest.Fragment.Ongoing$$ExternalSyntheticLambda6
            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public final void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                this.f$0.lambda$onViewCreated$1(nestedScrollView, i, i2, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$0() {
        this.hitApi = false;
        initialState();
        this.pageSize = -1;
        this.status = false;
        this.visibilty_status = true;
        Helper.showProgressDialog(getActivity());
        this.ongoingrecycler.setVisibility(8);
        hit_api_for_data(true);
        this.pullToReferesh.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$1(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        if (nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1) == null || i2 < nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1).getMeasuredHeight() - nestedScrollView.getMeasuredHeight() || i2 <= i4 || this.loading || !this.isPaginationAvailable) {
            return;
        }
        this.hitApi = false;
        ProgressBar progressBar = this.paginationLoader;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        this.loading = true;
        this.mPage++;
        this.status = true;
        hit_api_for_data(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Runnable runnable = this.endDateRunnable;
        if (runnable != null) {
            this.endDateHandler.removeCallbacks(runnable);
            this.endDateRunnable = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        String string;
        super.onResume();
        if (Constants.REFRESHPAGE.equals("true")) {
            this.hitApi = false;
            Constants.REFRESHPAGE = "false";
            hit_api_for_data(true);
        }
        if (getView() == null || (string = SharedPreference.getInstance().getString("DEFERRED_RESULT_MSG")) == null || string.isEmpty()) {
            return;
        }
        Snackbar.make(getView(), string, 0).show();
        SharedPreference.getInstance().remove("DEFERRED_RESULT_MSG");
    }

    public void initialState() {
        this.mPage = 1;
        this.loading = false;
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals(API.get_testclasses_data)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setPage("" + this.mPage);
        encryptionData.setType("0");
        return service.getLiveTestsData(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        if (apitype.equals(API.get_testclasses_data)) {
            try {
                this.hitApi = true;
                Helper.dismissProgressDialog();
                if (jsonstring.getString("status").equalsIgnoreCase("true")) {
                    this.time = Long.valueOf(jsonstring.optLong("time"));
                    this.isPaginationAvailable = true;
                    ProgressBar progressBar = this.paginationLoader;
                    if (progressBar != null && progressBar.isShown()) {
                        this.paginationLoader.setVisibility(8);
                    }
                    if (this.pageSize <= 0) {
                        if (jsonstring.has("per_page")) {
                            this.pageSize = jsonstring.optInt("per_page");
                        } else if (jsonstring.has("page_size")) {
                            this.pageSize = jsonstring.optInt("page_size");
                        } else if (jsonstring.has("perpage")) {
                            this.pageSize = jsonstring.optInt("perpage");
                        } else if (jsonstring.has("perPage")) {
                            this.pageSize = jsonstring.optInt("perPage");
                        }
                        if (this.pageSize <= 0) {
                            this.pageSize = -1;
                        }
                    }
                    LiveTest liveTest = (LiveTest) new Gson().fromJson(jsonstring.toString(), LiveTest.class);
                    this.livetest = liveTest;
                    final List<LiveTestData> data = liveTest.getData() != null ? this.livetest.getData() : null;
                    if (this.pageSize == -1 && data != null) {
                        this.pageSize = data.size();
                    }
                    if (this.status) {
                        if (data != null && data.size() > 0) {
                            final int size = this.liveTestData.size();
                            this.liveTestData.addAll(data);
                            if (getActivity() != null) {
                                getActivity().runOnUiThread(new Runnable() { // from class: com.appnew.android.LiveTest.Fragment.Ongoing$$ExternalSyntheticLambda2
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f$0.lambda$SuccessCallBack$4(data, size);
                                    }
                                });
                            }
                            if (this.pageSize > 0) {
                                this.isPaginationAvailable = data.size() >= this.pageSize;
                            } else {
                                this.isPaginationAvailable = data.size() > 0;
                            }
                        } else {
                            this.isPaginationAvailable = false;
                            this.loading = false;
                            ProgressBar progressBar2 = this.paginationLoader;
                            if (progressBar2 != null) {
                                progressBar2.setVisibility(8);
                            }
                        }
                    } else {
                        initialState();
                        this.liveTestData.clear();
                        if (data != null && data.size() > 0) {
                            this.liveTestData.addAll(data);
                            this.no_data_found_RL.setVisibility(8);
                            this.ongoingrecycler.setVisibility(0);
                            Testclassadapter testclassadapter = new Testclassadapter(getActivity(), this.liveTestData, true, this.time);
                            this.testclassadapter = testclassadapter;
                            this.ongoingrecycler.setAdapter(testclassadapter);
                            scheduleNextTestEndTimer();
                            if (this.pageSize > 0) {
                                this.isPaginationAvailable = data.size() >= this.pageSize;
                            } else {
                                this.isPaginationAvailable = data.size() > 0;
                            }
                        } else {
                            this.liveTestData.clear();
                            this.no_data_found_RL.setVisibility(0);
                            this.ongoingrecycler.setVisibility(8);
                            this.isPaginationAvailable = false;
                        }
                    }
                } else {
                    if (!this.status) {
                        this.no_data_found_RL.setVisibility(0);
                        this.ongoingrecycler.setVisibility(8);
                        this.liveTestData.clear();
                    }
                    this.isPaginationAvailable = false;
                    ProgressBar progressBar3 = this.paginationLoader;
                    if (progressBar3 != null && progressBar3.isShown()) {
                        this.paginationLoader.setVisibility(8);
                    }
                    if (!GenericUtils.isEmpty(jsonstring.getString("auth_code"))) {
                        RetrofitResponse.GetApiData(getContext(), jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
                    }
                }
            } catch (Exception e2) {
                this.hitApi = true;
                e2.printStackTrace();
            } finally {
                this.loading = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$SuccessCallBack$4(List list, int i) {
        Testclassadapter testclassadapter = this.testclassadapter;
        if (testclassadapter == null) {
            Testclassadapter testclassadapter2 = new Testclassadapter(getActivity(), this.liveTestData, true, this.time);
            this.testclassadapter = testclassadapter2;
            testclassadapter2.setOnTestEndedListener(new Testclassadapter.OnTestEndedListener() { // from class: com.appnew.android.LiveTest.Fragment.Ongoing$$ExternalSyntheticLambda0
                @Override // com.appnew.android.LiveTest.Adapter.Testclassadapter.OnTestEndedListener
                public final void onTestEnded() {
                    this.f$0.lambda$SuccessCallBack$2();
                }
            });
            this.testclassadapter.setOnTestTimerExpiredListener(new Testclassadapter.OnTestTimerExpiredListener() { // from class: com.appnew.android.LiveTest.Fragment.Ongoing$$ExternalSyntheticLambda1
                @Override // com.appnew.android.LiveTest.Adapter.Testclassadapter.OnTestTimerExpiredListener
                public final void onTimerExpired() {
                    this.f$0.lambda$SuccessCallBack$3();
                }
            });
            this.ongoingrecycler.setAdapter(this.testclassadapter);
            scheduleNextTestEndTimer();
        } else {
            try {
                try {
                    testclassadapter.addItems(list);
                    scheduleNextTestEndTimer();
                } catch (Throwable unused) {
                    this.testclassadapter.notifyDataSetChanged();
                }
            } catch (Throwable unused2) {
                this.testclassadapter.notifyItemRangeInserted(i, list.size());
            }
        }
        ProgressBar progressBar = this.paginationLoader;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$SuccessCallBack$2() {
        if (getActivity() instanceof LivetestActivity) {
            ((LivetestActivity) getActivity()).refreshOnTestEnded();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$SuccessCallBack$3() {
        if (getActivity() instanceof LivetestActivity) {
            ((LivetestActivity) getActivity()).refreshOnTimerExpiry();
        }
    }

    private void scheduleNextTestEndTimer() {
        Runnable runnable = this.endDateRunnable;
        if (runnable != null) {
            this.endDateHandler.removeCallbacks(runnable);
            this.endDateRunnable = null;
        }
        List<LiveTestData> list = this.liveTestData;
        if (list == null || list.isEmpty()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = Long.MAX_VALUE;
        for (LiveTestData liveTestData : this.liveTestData) {
            try {
                if (liveTestData.getEndDate() != null && !liveTestData.getEndDate().isEmpty()) {
                    long j2 = Long.parseLong(liveTestData.getEndDate()) * 1000;
                    if (j2 > jCurrentTimeMillis && j2 < j) {
                        j = j2;
                    }
                }
            } catch (NumberFormatException unused) {
                Log.e("Ongoing", "Failed to parse endDate: " + liveTestData.getEndDate());
            }
        }
        if (j == Long.MAX_VALUE) {
            return;
        }
        long j3 = j - jCurrentTimeMillis;
        Runnable runnable2 = new Runnable() { // from class: com.appnew.android.LiveTest.Fragment.Ongoing$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$scheduleNextTestEndTimer$5();
            }
        };
        this.endDateRunnable = runnable2;
        this.endDateHandler.postDelayed(runnable2, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$scheduleNextTestEndTimer$5() {
        if (!isAdded() || getActivity() == null) {
            return;
        }
        this.hitApi = false;
        initialState();
        this.pageSize = -1;
        this.status = false;
        this.visibilty_status = true;
        hit_api_for_data(true);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        Helper.dismissProgressDialog();
        apitype.hashCode();
        if (apitype.equals(API.get_testclasses_data)) {
            this.hitApi = true;
            ProgressBar progressBar = this.paginationLoader;
            if (progressBar != null && progressBar.isShown()) {
                this.paginationLoader.setVisibility(8);
            }
            this.loading = false;
            RecyclerView recyclerView = this.ongoingrecycler;
            if (recyclerView == null || this.no_data_found_RL == null) {
                return;
            }
            recyclerView.setVisibility(8);
            this.no_data_found_RL.setVisibility(0);
        }
    }

    private void hit_api_for_data(boolean showProgress) {
        if (this.networkCall == null) {
            this.networkCall = new NetworkCall(this, requireContext());
        }
        this.networkCall.NetworkAPICall(API.get_testclasses_data, "", showProgress, false);
    }

    public void chnagevisiblity(boolean visibilty_status) {
        this.visibilty_status = visibilty_status;
        if (this.testclassadapter != null) {
            requireActivity().runOnUiThread(new Runnable() { // from class: com.appnew.android.LiveTest.Fragment.Ongoing$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$chnagevisiblity$6();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$chnagevisiblity$6() {
        this.testclassadapter.notifyDataSetChanged();
    }

    public void updateList(boolean state1) {
        SharedPreference.getInstance().putBoolean("state", state1);
    }

    public void refresh_data() {
        this.hitApi = false;
        initialState();
        this.pageSize = -1;
        this.status = false;
        this.visibilty_status = true;
        hit_api_for_data(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            requireFragmentManager().beginTransaction().detach(this).attach(this).commit();
        }
    }
}
