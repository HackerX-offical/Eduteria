package com.appnew.android.LiveClass.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.LiveClass.Adapter.Liveclassadapter;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.GenericUtils;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.NonScrollRecyclerView;
import com.appnew.android.home.liveclasses.Datum;
import com.appnew.android.home.liveclasses.LiveClassesData;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class Upcoming extends Fragment implements NetworkCall.MyNetworkCallBack {
    Button backBtn;
    LiveClassesData liveClasses;
    Liveclassadapter liveclassadapter;
    ArrayList<Datum> livevideocompleted;
    private NestedScrollView nestedScrollView;
    NetworkCall networkCall;
    RelativeLayout no_data_found_RL;
    ProgressBar paginationLoader;
    private SwipeRefreshLayout pullToReferesh;
    boolean status;
    Long time;
    private NonScrollRecyclerView upcomingrecycler;
    private View view;
    private int mPage = 1;
    private boolean loading = false;
    boolean isPaginationAvailable = true;

    public static Upcoming newInstance(String param1, String param2) {
        Upcoming upcoming = new Upcoming();
        upcoming.setArguments(new Bundle());
        return upcoming;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.livevideocompleted == null) {
            this.livevideocompleted = new ArrayList<>();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_upcoming, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.upcomingrecycler = (NonScrollRecyclerView) view.findViewById(R.id.upcomingrecycler);
        this.networkCall = new NetworkCall(this, getContext());
        this.pullToReferesh = (SwipeRefreshLayout) view.findViewById(R.id.pullto_referesh);
        this.nestedScrollView = (NestedScrollView) view.findViewById(R.id.nested_scroll);
        this.paginationLoader = (ProgressBar) view.findViewById(R.id.progressBar);
        this.no_data_found_RL = (RelativeLayout) view.findViewById(R.id.no_data_found_RL);
        Button button = (Button) view.findViewById(R.id.backBtn);
        this.backBtn = button;
        button.setVisibility(8);
        if (this.livevideocompleted.size() == 0) {
            Helper.showProgressDialog(getActivity());
            hit_api_for_data(false);
        } else {
            this.no_data_found_RL.setVisibility(8);
            this.upcomingrecycler.setVisibility(0);
            Liveclassadapter liveclassadapter = new Liveclassadapter(getActivity(), this.livevideocompleted, this.time);
            this.liveclassadapter = liveclassadapter;
            this.upcomingrecycler.setAdapter(liveclassadapter);
        }
        this.pullToReferesh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.appnew.android.LiveClass.Fragment.Upcoming.1
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                Upcoming.this.initialState();
                Upcoming.this.status = false;
                Helper.showProgressDialog(Upcoming.this.getActivity());
                Upcoming.this.livevideocompleted = new ArrayList<>();
                Upcoming.this.hit_api_for_data(false);
                Upcoming.this.pullToReferesh.setRefreshing(false);
            }
        });
        this.nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.appnew.android.LiveClass.Fragment.Upcoming.2
            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (v.getChildAt(v.getChildCount() - 1) == null || scrollY < v.getChildAt(v.getChildCount() - 1).getMeasuredHeight() - v.getMeasuredHeight() || scrollY <= oldScrollY || !Upcoming.this.loading || !Upcoming.this.isPaginationAvailable) {
                    return;
                }
                Upcoming.this.paginationLoader.setVisibility(0);
                Upcoming.this.mPage++;
                Upcoming.this.status = true;
                Upcoming.this.hit_api_for_data(false);
            }
        });
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals(API.get_liveclasses_data)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setPage("" + this.mPage);
        encryptionData.setType("1");
        return service.getLiveClassesData(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals(API.get_liveclasses_data)) {
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
                        LiveClassesData liveClassesData = (LiveClassesData) new Gson().fromJson(jsonstring.toString(), LiveClassesData.class);
                        this.liveClasses = liveClassesData;
                        if (liveClassesData.getData() != null) {
                            int size = this.livevideocompleted.size();
                            if (this.livevideocompleted.size() > 0) {
                                this.livevideocompleted.addAll(this.liveClasses.getData());
                                this.liveclassadapter.notifyItemRangeInserted(size, this.livevideocompleted.size() - size);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    initialState();
                    ArrayList<Datum> arrayList = this.livevideocompleted;
                    if (arrayList != null && arrayList.size() != 0) {
                        this.livevideocompleted.clear();
                    }
                    LiveClassesData liveClassesData2 = (LiveClassesData) new Gson().fromJson(jsonstring.toString(), LiveClassesData.class);
                    this.liveClasses = liveClassesData2;
                    if (liveClassesData2.getData() != null) {
                        this.livevideocompleted.addAll(this.liveClasses.getData());
                        if (this.livevideocompleted.size() > 0) {
                            this.no_data_found_RL.setVisibility(8);
                            this.upcomingrecycler.setVisibility(0);
                            Liveclassadapter liveclassadapter = new Liveclassadapter(getActivity(), this.livevideocompleted, this.time);
                            this.liveclassadapter = liveclassadapter;
                            this.upcomingrecycler.setAdapter(liveclassadapter);
                            return;
                        }
                        this.no_data_found_RL.setVisibility(0);
                        this.upcomingrecycler.setVisibility(8);
                        return;
                    }
                    this.no_data_found_RL.setVisibility(0);
                    this.upcomingrecycler.setVisibility(8);
                    return;
                }
                if (!this.status) {
                    this.no_data_found_RL.setVisibility(0);
                    this.upcomingrecycler.setVisibility(8);
                }
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
        apitype.hashCode();
        if (apitype.equals(API.get_liveclasses_data)) {
            ProgressBar progressBar = this.paginationLoader;
            if (progressBar != null && progressBar.isShown()) {
                this.paginationLoader.setVisibility(8);
            }
            NonScrollRecyclerView nonScrollRecyclerView = this.upcomingrecycler;
            if (nonScrollRecyclerView == null || this.no_data_found_RL == null) {
                return;
            }
            nonScrollRecyclerView.setVisibility(8);
            this.no_data_found_RL.setVisibility(0);
        }
    }

    public void initialState() {
        this.mPage = 1;
        this.loading = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hit_api_for_data(boolean showProgress) {
        this.networkCall.NetworkAPICall(API.get_liveclasses_data, "", showProgress, false);
    }

    public void refresh_data() {
        initialState();
        this.status = false;
        hit_api_for_data(true);
    }

    public void checkVideoId(String number, LiveClasses liveClassFragment) {
        LiveClassesData liveClassesData = this.liveClasses;
        if (liveClassesData == null || liveClassesData.getData() == null || this.liveClasses.getData().size() <= 0) {
            return;
        }
        int i = 0;
        for (Datum datum : this.liveClasses.getData()) {
            if (datum.getId().equalsIgnoreCase(number)) {
                refresh_data();
                liveClassFragment.updateApi();
                this.liveClasses.getData().remove(i);
                if (getContext() != null) {
                    Toast.makeText(getContext(), (datum.getTitle().length() >= 15 ? datum.getTitle().substring(0, 15) : datum.getTitle()) + ". Class is live...", 0).show();
                }
                Liveclassadapter liveclassadapter = this.liveclassadapter;
                if (liveclassadapter != null) {
                    liveclassadapter.removeItem(i);
                }
                if (this.liveClasses.getData().size() == 0) {
                    this.no_data_found_RL.setVisibility(0);
                    this.upcomingrecycler.setVisibility(8);
                    return;
                }
                return;
            }
            i++;
        }
    }
}
