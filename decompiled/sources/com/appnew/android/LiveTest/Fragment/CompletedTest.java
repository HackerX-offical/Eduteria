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
public class CompletedTest extends Fragment implements NetworkCall.MyNetworkCallBack {
    Button backBtn;
    private RecyclerView completedrecycler;
    LiveTest livetest;
    List<LiveTestData> livetestcompleted;
    private NestedScrollView nestedScrollView;
    NetworkCall networkCall;
    RelativeLayout no_data_found_RL;
    ProgressBar paginationLoader;
    private SwipeRefreshLayout pullToReferesh;
    boolean status;
    public Testclassadapter testclassadapter;
    Long time;
    private View view;
    boolean visibilty_status;
    private int mPage = 1;
    private boolean loading = false;
    private boolean isPaginationAvailable = true;

    public static CompletedTest newInstance(String param1, String param2) {
        CompletedTest completedTest = new CompletedTest();
        completedTest.setArguments(new Bundle());
        return completedTest;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.livetestcompleted == null) {
            this.livetestcompleted = new ArrayList();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_completed_test, container, false);
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
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.completedrecycler = (RecyclerView) view.findViewById(R.id.completedrecycler);
        this.networkCall = new NetworkCall(this, getContext());
        this.pullToReferesh = (SwipeRefreshLayout) view.findViewById(R.id.pullto_referesh);
        this.nestedScrollView = (NestedScrollView) view.findViewById(R.id.nested_scroll);
        this.paginationLoader = (ProgressBar) view.findViewById(R.id.progressBar);
        this.no_data_found_RL = (RelativeLayout) view.findViewById(R.id.no_data_found_RL);
        Button button = (Button) view.findViewById(R.id.backBtn);
        this.backBtn = button;
        button.setVisibility(8);
        Completed(true);
        if (this.livetestcompleted.size() == 0) {
            Helper.showProgressDialog(getActivity());
            hit_api_for_data(true);
        } else {
            this.no_data_found_RL.setVisibility(8);
            this.completedrecycler.setVisibility(0);
            Testclassadapter testclassadapter = new Testclassadapter(getActivity(), this.livetestcompleted, true, this.time);
            this.testclassadapter = testclassadapter;
            this.completedrecycler.setAdapter(testclassadapter);
        }
        this.pullToReferesh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.appnew.android.LiveTest.Fragment.CompletedTest$$ExternalSyntheticLambda0
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                this.f$0.lambda$onViewCreated$0();
            }
        });
        this.nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.appnew.android.LiveTest.Fragment.CompletedTest.1
            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (v.getChildAt(v.getChildCount() - 1) == null || scrollY < v.getChildAt(v.getChildCount() - 1).getMeasuredHeight() - v.getMeasuredHeight() || scrollY <= oldScrollY || !CompletedTest.this.loading || !CompletedTest.this.isPaginationAvailable) {
                    return;
                }
                CompletedTest.this.paginationLoader.setVisibility(0);
                CompletedTest.this.mPage++;
                CompletedTest.this.status = true;
                CompletedTest.this.hit_api_for_data(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$0() {
        initialState();
        this.status = false;
        this.visibilty_status = true;
        Helper.showProgressDialog(getActivity());
        hit_api_for_data(true);
        this.pullToReferesh.setRefreshing(false);
    }

    public void initialState() {
        this.mPage = 1;
        this.loading = true;
    }

    public void chnagevisiblity(boolean visibilty_status) {
        this.visibilty_status = visibilty_status;
        if (this.testclassadapter != null) {
            getActivity().runOnUiThread(new Runnable() { // from class: com.appnew.android.LiveTest.Fragment.CompletedTest$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$chnagevisiblity$1();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$chnagevisiblity$1() {
        this.testclassadapter.notifyDataSetChanged();
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals(API.get_testclasses_data)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setPage("" + this.mPage);
        encryptionData.setType("2");
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
                            this.livetestcompleted.size();
                            if (this.livetestcompleted.size() > 0) {
                                this.livetestcompleted.addAll(this.livetest.getData());
                                this.testclassadapter.notifyDataSetChanged();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    initialState();
                    List<LiveTestData> list = this.livetestcompleted;
                    if (list != null && list.size() != 0) {
                        this.livetestcompleted.clear();
                    }
                    LiveTest liveTest2 = (LiveTest) new Gson().fromJson(jsonstring.toString(), LiveTest.class);
                    this.livetest = liveTest2;
                    if (liveTest2.getData() != null) {
                        this.livetestcompleted.addAll(this.livetest.getData());
                        if (this.livetestcompleted.size() > 0) {
                            this.no_data_found_RL.setVisibility(8);
                            this.completedrecycler.setVisibility(0);
                            Testclassadapter testclassadapter = new Testclassadapter(getActivity(), this.livetestcompleted, true, this.time);
                            this.testclassadapter = testclassadapter;
                            this.completedrecycler.setAdapter(testclassadapter);
                            return;
                        }
                        this.livetestcompleted.clear();
                        this.completedrecycler.setVisibility(8);
                        this.no_data_found_RL.setVisibility(0);
                        return;
                    }
                    this.livetestcompleted.clear();
                    this.completedrecycler.setVisibility(8);
                    this.no_data_found_RL.setVisibility(0);
                    return;
                }
                if (!this.status) {
                    this.livetestcompleted.clear();
                    this.no_data_found_RL.setVisibility(0);
                    this.completedrecycler.setVisibility(8);
                }
                this.isPaginationAvailable = false;
                ProgressBar progressBar2 = this.paginationLoader;
                if (progressBar2 != null && progressBar2.isShown()) {
                    this.paginationLoader.setVisibility(8);
                }
                if (jsonstring.has("auth_code")) {
                    if (!GenericUtils.isEmpty(jsonstring.getString("auth_code")) || LivetestActivity.view_pager.getCurrentItem() == 2) {
                        RetrofitResponse.GetApiData(getContext(), jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
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
            RecyclerView recyclerView = this.completedrecycler;
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

    public void refresh_data() {
        initialState();
        this.status = false;
        this.visibilty_status = true;
        hit_api_for_data(true);
    }

    public void Completed(boolean state1) {
        SharedPreference.getInstance().putBoolean("completed_state", state1);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            requireFragmentManager().beginTransaction().detach(this).attach(this).commit();
        }
    }
}
