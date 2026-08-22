package com.appnew.android.testmodule.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.GenericUtils;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.home.Constants;
import com.appnew.android.testmodule.adapter.SubjectiveRankAdapter;
import com.appnew.android.testmodule.model.SubjectiveResultData;
import com.appnew.android.testmodule.model.TopRanker;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class RankFragement extends Fragment implements NetworkCall.MyNetworkCallBack {
    LinearLayoutManager linearLayoutManager;
    private NestedScrollView nestedScrollView;
    private NetworkCall networkCall;
    RelativeLayout no_data_found_RL;
    List<TopRanker> notificationlist;
    private RecyclerView notificationrecyceler;
    ProgressBar paginationLoader;
    private SwipeRefreshLayout pullToReferesh;
    boolean status;
    SubjectiveRankAdapter subjectiveRankAdapter;
    SubjectiveResultData subjectiveResultData;
    private int mPage = 1;
    private boolean loading = false;
    private boolean isPaginationAvailable = true;

    public static RankFragement newInstance(SubjectiveResultData notificationlist) {
        RankFragement rankFragement = new RankFragement();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Const.RANK, notificationlist);
        rankFragement.setArguments(bundle);
        return rankFragement;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.subjectiveResultData = (SubjectiveResultData) getArguments().getSerializable(Const.RANK);
        }
        if (this.notificationlist == null) {
            this.notificationlist = new ArrayList();
        }
        this.notificationlist.addAll(this.subjectiveResultData.getTopRankers());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragement_rank, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.notificationrecyceler = (RecyclerView) view.findViewById(R.id.notification);
        this.pullToReferesh = (SwipeRefreshLayout) view.findViewById(R.id.pullto_referesh);
        this.nestedScrollView = (NestedScrollView) view.findViewById(R.id.nested_scroll);
        this.paginationLoader = (ProgressBar) view.findViewById(R.id.progressBar);
        this.no_data_found_RL = (RelativeLayout) view.findViewById(R.id.no_data_found_RL);
        this.networkCall = new NetworkCall(this, getContext());
        if (this.notificationlist.size() == 0) {
            hit_api_for_rankdata(true);
        } else {
            this.notificationrecyceler.setVisibility(0);
            this.subjectiveRankAdapter = new SubjectiveRankAdapter(getActivity(), this.notificationlist);
            this.notificationrecyceler.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
            this.notificationrecyceler.setAdapter(this.subjectiveRankAdapter);
        }
        this.pullToReferesh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.appnew.android.testmodule.fragment.RankFragement.1
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                RankFragement.this.initialState();
                RankFragement.this.status = false;
                RankFragement.this.hit_api_for_rankdata(true);
                RankFragement.this.pullToReferesh.setRefreshing(false);
            }
        });
        this.nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.appnew.android.testmodule.fragment.RankFragement.2
            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (v.getChildAt(v.getChildCount() - 1) == null || scrollY < v.getChildAt(v.getChildCount() - 1).getMeasuredHeight() - v.getMeasuredHeight() || scrollY <= oldScrollY || !RankFragement.this.loading || !RankFragement.this.isPaginationAvailable) {
                    return;
                }
                RankFragement.this.paginationLoader.setVisibility(0);
                RankFragement.this.mPage++;
                RankFragement.this.status = true;
                RankFragement.this.hit_api_for_rankdata(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hit_api_for_rankdata(boolean showProgress) {
        this.networkCall.NetworkAPICall(API.API_subjective_result, "", showProgress, false);
    }

    public void initialState() {
        this.mPage = 1;
        this.loading = true;
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals(API.API_subjective_result)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setPage("" + this.mPage);
        encryptionData.setTest_id(Constants.SUB_TEST_ID);
        encryptionData.setUser_id(SharedPreference.getInstance().getLoggedInUser().getId());
        return service.API_subjective_result(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals(API.API_subjective_result)) {
            try {
                if (jsonstring.getString("status").equalsIgnoreCase("true")) {
                    this.isPaginationAvailable = true;
                    ProgressBar progressBar = this.paginationLoader;
                    if (progressBar != null && progressBar.isShown()) {
                        this.paginationLoader.setVisibility(8);
                    }
                    if (this.status) {
                        SubjectiveResultData subjectiveResultData = (SubjectiveResultData) new Gson().fromJson(((JSONObject) Objects.requireNonNull(jsonstring.optJSONObject("data"))).toString(), SubjectiveResultData.class);
                        this.subjectiveResultData = subjectiveResultData;
                        if (subjectiveResultData.getTopRankers() != null) {
                            this.no_data_found_RL.setVisibility(8);
                            int size = this.subjectiveResultData.getTopRankers().size();
                            if (this.subjectiveResultData.getTopRankers().size() > 0) {
                                this.notificationlist.addAll(this.subjectiveResultData.getTopRankers());
                                this.subjectiveRankAdapter.notifyItemRangeInserted(this.notificationlist.size() - 1, this.notificationlist.size() - size);
                                return;
                            }
                            return;
                        }
                        this.no_data_found_RL.setVisibility(0);
                        Toast.makeText(getContext(), getActivity().getResources().getString(R.string.no_data_found), 0).show();
                        return;
                    }
                    initialState();
                    List<TopRanker> list = this.notificationlist;
                    if (list != null && list.size() != 0) {
                        this.notificationlist.clear();
                    }
                    SubjectiveResultData subjectiveResultData2 = (SubjectiveResultData) new Gson().fromJson(((JSONObject) Objects.requireNonNull(jsonstring.optJSONObject("data"))).toString(), SubjectiveResultData.class);
                    this.subjectiveResultData = subjectiveResultData2;
                    if (subjectiveResultData2.getTopRankers() != null) {
                        this.notificationlist.addAll(this.subjectiveResultData.getTopRankers());
                        if (this.notificationlist.size() > 0) {
                            this.subjectiveRankAdapter = new SubjectiveRankAdapter(getActivity(), this.notificationlist);
                            this.notificationrecyceler.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
                            this.notificationrecyceler.setAdapter(this.subjectiveRankAdapter);
                            return;
                        }
                        return;
                    }
                    Toast.makeText(getContext(), getActivity().getResources().getString(R.string.no_data_found), 0).show();
                    return;
                }
                this.no_data_found_RL.setVisibility(0);
                this.isPaginationAvailable = false;
                ProgressBar progressBar2 = this.paginationLoader;
                if (progressBar2 != null && progressBar2.isShown()) {
                    this.paginationLoader.setVisibility(8);
                }
                if (GenericUtils.isEmpty(jsonstring.getString("auth_code"))) {
                    return;
                }
                RetrofitResponse.GetApiData(getContext(), jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        ProgressBar progressBar = this.paginationLoader;
        if (progressBar == null || !progressBar.isShown()) {
            return;
        }
        this.paginationLoader.setVisibility(8);
    }
}
