package com.appnew.android.LiveTest.Fragment;

import android.os.Bundle;
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
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class UpcomingTest extends Fragment implements NetworkCall.MyNetworkCallBack {
    Button backBtn;
    LiveTest livetest;
    List<LiveTestData> livetestupcoming;
    private NestedScrollView nestedScrollView;
    NetworkCall networkCall;
    RelativeLayout no_data_found_RL;
    ProgressBar paginationLoader;
    private SwipeRefreshLayout pullToReferesh;
    boolean status;
    Testclassadapter testclassadapter;
    Long time;
    private RecyclerView upcomingrecycler;
    private View view;
    boolean state = false;
    boolean visibilty_status = false;
    private int mPage = 1;
    private boolean loading = false;
    private boolean isPaginationAvailable = true;

    public static UpcomingTest newInstance(String param1, String param2) {
        UpcomingTest upcomingTest = new UpcomingTest();
        upcomingTest.setArguments(new Bundle());
        return upcomingTest;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.livetestupcoming == null) {
            this.livetestupcoming = new ArrayList();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_upcoming, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.state = SharedPreference.getInstance().getBoolean("upcoming_state");
        this.upcomingrecycler = (RecyclerView) view.findViewById(R.id.upcomingrecycler);
        this.networkCall = new NetworkCall(this, getContext());
        this.pullToReferesh = (SwipeRefreshLayout) view.findViewById(R.id.pullto_referesh);
        this.nestedScrollView = (NestedScrollView) view.findViewById(R.id.nested_scroll);
        this.paginationLoader = (ProgressBar) view.findViewById(R.id.progressBar);
        this.no_data_found_RL = (RelativeLayout) view.findViewById(R.id.no_data_found_RL);
        Button button = (Button) view.findViewById(R.id.backBtn);
        this.backBtn = button;
        button.setVisibility(8);
        if (this.livetestupcoming.size() == 0 || this.state) {
            Helper.showProgressDialog(getActivity());
            hit_api_for_data(true);
            SharedPreference.getInstance().putBoolean("upcoming_state ", false);
        } else {
            this.no_data_found_RL.setVisibility(8);
            this.upcomingrecycler.setVisibility(0);
            Testclassadapter testclassadapter = new Testclassadapter(getActivity(), this.livetestupcoming, false, this.time);
            this.testclassadapter = testclassadapter;
            this.upcomingrecycler.setAdapter(testclassadapter);
        }
        this.pullToReferesh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.appnew.android.LiveTest.Fragment.UpcomingTest.1
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                UpcomingTest.this.initialState();
                UpcomingTest.this.status = false;
                UpcomingTest.this.visibilty_status = false;
                Helper.showProgressDialog(UpcomingTest.this.getActivity());
                UpcomingTest.this.hit_api_for_data(true);
                UpcomingTest.this.pullToReferesh.setRefreshing(false);
            }
        });
        this.nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.appnew.android.LiveTest.Fragment.UpcomingTest.2
            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (v.getChildAt(v.getChildCount() - 1) == null || scrollY < v.getChildAt(v.getChildCount() - 1).getMeasuredHeight() - v.getMeasuredHeight() || scrollY <= oldScrollY || !UpcomingTest.this.loading || !UpcomingTest.this.isPaginationAvailable) {
                    return;
                }
                UpcomingTest.this.paginationLoader.setVisibility(0);
                UpcomingTest.this.mPage++;
                UpcomingTest.this.status = true;
                UpcomingTest.this.hit_api_for_data(true);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (Constants.REFRESHPAGE.equals("true")) {
            Constants.REFRESHPAGE = "false";
            hit_api_for_data(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    public void initialState() {
        this.mPage = 1;
        this.loading = true;
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals(API.get_testclasses_data)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setPage("" + this.mPage);
        encryptionData.setType("1");
        return service.getLiveTestsData(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals(API.get_testclasses_data)) {
            try {
                Helper.dismissProgressDialog();
                if (jsonstring.getString("status").equalsIgnoreCase("true")) {
                    this.time = Long.valueOf(jsonstring.optLong("time"));
                    this.isPaginationAvailable = true;
                    ProgressBar progressBar = this.paginationLoader;
                    if (progressBar != null && progressBar.isShown()) {
                        this.paginationLoader.setVisibility(8);
                    }
                    if (this.status) {
                        LiveTest liveTest = (LiveTest) new Gson().fromJson(jsonstring.toString(), LiveTest.class);
                        this.livetest = liveTest;
                        if (liveTest.getData() != null) {
                            this.livetestupcoming.size();
                            if (this.livetestupcoming.size() > 0) {
                                this.livetestupcoming.addAll(this.livetest.getData());
                                this.testclassadapter.notifyDataSetChanged();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    initialState();
                    List<LiveTestData> list = this.livetestupcoming;
                    if (list != null && list.size() != 0) {
                        this.livetestupcoming.clear();
                    }
                    LiveTest liveTest2 = (LiveTest) new Gson().fromJson(jsonstring.toString(), LiveTest.class);
                    this.livetest = liveTest2;
                    if (liveTest2.getData() != null) {
                        this.livetestupcoming.addAll(this.livetest.getData());
                        if (this.livetestupcoming.size() > 0) {
                            this.no_data_found_RL.setVisibility(8);
                            this.upcomingrecycler.setVisibility(0);
                            Testclassadapter testclassadapter = new Testclassadapter(getActivity(), this.livetestupcoming, false, this.time);
                            this.testclassadapter = testclassadapter;
                            testclassadapter.setOnTestTimerExpiredListener(new Testclassadapter.OnTestTimerExpiredListener() { // from class: com.appnew.android.LiveTest.Fragment.UpcomingTest$$ExternalSyntheticLambda0
                                @Override // com.appnew.android.LiveTest.Adapter.Testclassadapter.OnTestTimerExpiredListener
                                public final void onTimerExpired() {
                                    this.f$0.lambda$SuccessCallBack$0();
                                }
                            });
                            this.testclassadapter.setOnTestEndedListener(new Testclassadapter.OnTestEndedListener() { // from class: com.appnew.android.LiveTest.Fragment.UpcomingTest$$ExternalSyntheticLambda1
                                @Override // com.appnew.android.LiveTest.Adapter.Testclassadapter.OnTestEndedListener
                                public final void onTestEnded() {
                                    this.f$0.lambda$SuccessCallBack$1();
                                }
                            });
                            this.upcomingrecycler.setAdapter(this.testclassadapter);
                            return;
                        }
                        this.livetestupcoming.clear();
                        this.upcomingrecycler.setVisibility(8);
                        this.no_data_found_RL.setVisibility(0);
                        return;
                    }
                    this.livetestupcoming.clear();
                    this.upcomingrecycler.setVisibility(8);
                    this.no_data_found_RL.setVisibility(0);
                    return;
                }
                if (!this.status) {
                    this.livetestupcoming.clear();
                    this.no_data_found_RL.setVisibility(0);
                    this.upcomingrecycler.setVisibility(8);
                }
                this.isPaginationAvailable = false;
                ProgressBar progressBar2 = this.paginationLoader;
                if (progressBar2 != null && progressBar2.isShown()) {
                    this.paginationLoader.setVisibility(8);
                }
                if (GenericUtils.isEmpty(jsonstring.getString("auth_code")) && LivetestActivity.view_pager.getCurrentItem() != 1) {
                    return;
                }
                RetrofitResponse.GetApiData(getContext(), jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$SuccessCallBack$0() {
        if (getActivity() instanceof LivetestActivity) {
            ((LivetestActivity) getActivity()).refreshOnTimerExpiry();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$SuccessCallBack$1() {
        if (getActivity() instanceof LivetestActivity) {
            ((LivetestActivity) getActivity()).refreshOnTestEnded();
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        Helper.dismissProgressDialog();
        apitype.hashCode();
        if (apitype.equals(API.get_testclasses_data)) {
            ProgressBar progressBar = this.paginationLoader;
            if (progressBar != null && progressBar.isShown()) {
                this.paginationLoader.setVisibility(8);
            }
            RecyclerView recyclerView = this.upcomingrecycler;
            if (recyclerView == null || this.no_data_found_RL == null) {
                return;
            }
            recyclerView.setVisibility(8);
            this.no_data_found_RL.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hit_api_for_data(boolean showProgress) {
        this.networkCall.NetworkAPICall(API.get_testclasses_data, "", showProgress, false);
    }

    public void chnagevisiblity(boolean visibilty_status) {
        this.visibilty_status = visibilty_status;
    }

    public void UpcomingListUpdate(boolean state1) {
        SharedPreference.getInstance().putBoolean("upcoming_state", state1);
    }

    public void refresh_data() {
        initialState();
        this.status = false;
        this.visibilty_status = false;
        hit_api_for_data(true);
    }
}
