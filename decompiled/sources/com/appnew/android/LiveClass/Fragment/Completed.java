package com.appnew.android.LiveClass.Fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.appnew.android.Download.Audio.AudioPlayerService;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.LiveClass.Adapter.Liveclassadapter;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.GenericUtils;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.NonScrollRecyclerView;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.home.Constants;
import com.appnew.android.home.liveclasses.Datum;
import com.appnew.android.home.liveclasses.LiveClassesData;
import com.eduteria.app.app.R;
import com.facebook.internal.NativeProtocol;
import com.google.gson.Gson;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class Completed extends Fragment implements NetworkCall.MyNetworkCallBack {
    Button backBtn;
    private NonScrollRecyclerView completedrecycler;
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
    private View view;
    private int mPage = 1;
    private boolean loading = false;
    private boolean isPaginationAvailable = true;
    private BroadcastReceiver audioServiceReceiver = new BroadcastReceiver() { // from class: com.appnew.android.LiveClass.Fragment.Completed.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean booleanExtra = intent.getBooleanExtra("result", false);
            intent.getStringExtra("resourceId");
            if (!booleanExtra || Completed.this.liveclassadapter == null) {
                return;
            }
            Completed.this.liveclassadapter.notifyDataSetChanged();
        }
    };

    public static Completed newInstance(String param1, String param2) {
        Completed completed = new Completed();
        completed.setArguments(new Bundle());
        return completed;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.livevideocompleted == null) {
            this.livevideocompleted = new ArrayList<>();
        }
        LocalBroadcastManager.getInstance(requireContext()).registerReceiver(this.audioServiceReceiver, new IntentFilter(AudioPlayerService.AUDIO_PLAYER_ACTION));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_completed, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.completedrecycler = (NonScrollRecyclerView) view.findViewById(R.id.completedrecycler);
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
            this.completedrecycler.setVisibility(0);
            Liveclassadapter liveclassadapter = new Liveclassadapter(getActivity(), this.livevideocompleted, this.time, Const.COMPLETED);
            this.liveclassadapter = liveclassadapter;
            this.completedrecycler.setAdapter(liveclassadapter);
        }
        this.pullToReferesh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.appnew.android.LiveClass.Fragment.Completed$$ExternalSyntheticLambda0
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                this.f$0.lambda$onViewCreated$0();
            }
        });
        this.nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.appnew.android.LiveClass.Fragment.Completed$$ExternalSyntheticLambda1
            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public final void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                this.f$0.lambda$onViewCreated$1(nestedScrollView, i, i2, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$0() {
        initialState();
        this.status = false;
        Helper.showProgressDialog(getActivity());
        this.livevideocompleted = new ArrayList<>();
        hit_api_for_data(false);
        this.pullToReferesh.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$1(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        if (nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1) == null || i2 < nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1).getMeasuredHeight() - nestedScrollView.getMeasuredHeight() || i2 <= i4 || !this.loading || !this.isPaginationAvailable) {
            return;
        }
        this.mPage++;
        this.status = true;
        hit_api_for_data(false);
    }

    public void initialState() {
        this.mPage = 1;
        this.loading = true;
    }

    public void updateApi() {
        hit_api_for_data(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        handleListenNow();
    }

    private void handleListenNow() {
        if (SharedPreference.getInstance().getString(Const.AUDIO_LISTEN).equalsIgnoreCase("1")) {
            if (AudioPlayerService.isAudioPlaying && !Constants.pos.equalsIgnoreCase("")) {
                Liveclassadapter liveclassadapter = this.liveclassadapter;
                if (liveclassadapter != null) {
                    liveclassadapter.notifyDataSetChanged();
                }
                Constants.pos = "";
                return;
            }
            if (Constants.pos.equalsIgnoreCase("")) {
                return;
            }
            Liveclassadapter liveclassadapter2 = this.liveclassadapter;
            if (liveclassadapter2 != null) {
                liveclassadapter2.notifyDataSetChanged();
            }
            Constants.pos = "";
        }
    }

    private void hit_api_for_data(boolean showProgress) {
        NetworkCall networkCall = this.networkCall;
        if (networkCall != null) {
            networkCall.NetworkAPICall(API.get_liveclasses_data, "", showProgress, false);
        } else {
            Log.e(NativeProtocol.ERROR_NETWORK_ERROR, "networkCall is null");
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals(API.get_liveclasses_data)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setPage("" + this.mPage);
        encryptionData.setType("2");
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
                    this.isPaginationAvailable = false;
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
                            this.completedrecycler.setVisibility(0);
                            Liveclassadapter liveclassadapter = new Liveclassadapter(getActivity(), this.livevideocompleted, this.time, Const.COMPLETED);
                            this.liveclassadapter = liveclassadapter;
                            this.completedrecycler.setAdapter(liveclassadapter);
                            return;
                        }
                        this.no_data_found_RL.setVisibility(0);
                        this.completedrecycler.setVisibility(8);
                        return;
                    }
                    this.no_data_found_RL.setVisibility(0);
                    this.completedrecycler.setVisibility(8);
                    return;
                }
                if (!this.status) {
                    this.no_data_found_RL.setVisibility(0);
                    this.completedrecycler.setVisibility(8);
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
                this.no_data_found_RL.setVisibility(0);
                this.completedrecycler.setVisibility(8);
                e2.printStackTrace();
            }
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        Helper.dismissProgressDialog();
        apitype.hashCode();
        if (apitype.equals(API.get_liveclasses_data)) {
            ProgressBar progressBar = this.paginationLoader;
            if (progressBar != null && progressBar.isShown()) {
                this.paginationLoader.setVisibility(8);
            }
            NonScrollRecyclerView nonScrollRecyclerView = this.completedrecycler;
            if (nonScrollRecyclerView == null || this.no_data_found_RL == null) {
                return;
            }
            nonScrollRecyclerView.setVisibility(8);
            this.no_data_found_RL.setVisibility(0);
        }
    }

    public void refresh_data() {
        initialState();
        this.status = false;
        hit_api_for_data(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(this.audioServiceReceiver);
    }
}
