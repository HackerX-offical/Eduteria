package com.appnew.android.Notification.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.NotificationModel.Datum;
import com.appnew.android.Model.NotificationModel.NotificationdataModel;
import com.appnew.android.Notification.Adapter.NotificationAdapter;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.GenericUtils;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class Notification extends Fragment implements NetworkCall.MyNetworkCallBack {
    private NestedScrollView nestedScrollView;
    private NetworkCall networkCall;
    NotificationAdapter notificationAdapter;
    NotificationdataModel notificationdata;
    List<Datum> notificationlist;
    private RecyclerView notificationrecyceler;
    ProgressBar paginationLoader;
    private SwipeRefreshLayout pullToReferesh;
    boolean status;
    private int mPage = 1;
    private boolean loading = false;
    private boolean isPaginationAvailable = true;

    public static Notification newInstance(String param1, String param2) {
        Notification notification = new Notification();
        notification.setArguments(new Bundle());
        return notification;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.notificationlist == null) {
            this.notificationlist = new ArrayList();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notification, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.notificationrecyceler = (RecyclerView) view.findViewById(R.id.notification);
        this.pullToReferesh = (SwipeRefreshLayout) view.findViewById(R.id.pullto_referesh);
        this.nestedScrollView = (NestedScrollView) view.findViewById(R.id.nested_scroll);
        this.paginationLoader = (ProgressBar) view.findViewById(R.id.progressBar);
        this.networkCall = new NetworkCall(this, getContext());
        if (this.notificationlist.size() == 0) {
            hit_api_for_notificationdata(true);
        } else {
            this.notificationrecyceler.setVisibility(0);
            NotificationAdapter notificationAdapter = new NotificationAdapter(getActivity(), this.notificationlist);
            this.notificationAdapter = notificationAdapter;
            this.notificationrecyceler.setAdapter(notificationAdapter);
            this.notificationAdapter.setNestedScrollView(this.nestedScrollView);
        }
        this.pullToReferesh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.appnew.android.Notification.Fragment.Notification$$ExternalSyntheticLambda0
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                this.f$0.lambda$onViewCreated$0();
            }
        });
        this.nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.appnew.android.Notification.Fragment.Notification$$ExternalSyntheticLambda1
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
        hit_api_for_notificationdata(true);
        this.pullToReferesh.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$1(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        if (nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1) == null || i2 < nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1).getMeasuredHeight() - nestedScrollView.getMeasuredHeight() || i2 <= i4 || !this.loading || !this.isPaginationAvailable) {
            return;
        }
        this.paginationLoader.setVisibility(0);
        this.mPage++;
        this.status = true;
        hit_api_for_notificationdata(false);
    }

    private void hit_api_for_notificationdata(boolean showProgress) {
        this.networkCall.NetworkAPICall(API.get_notification_data, "", showProgress, false);
    }

    public void initialState() {
        this.mPage = 1;
        this.loading = true;
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals(API.get_notification_data)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setPage("" + this.mPage);
        return service.getNotification(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals(API.get_notification_data)) {
            try {
                if (jsonstring.getString("status").equalsIgnoreCase("true")) {
                    this.isPaginationAvailable = true;
                    ProgressBar progressBar = this.paginationLoader;
                    if (progressBar != null && progressBar.isShown()) {
                        this.paginationLoader.setVisibility(8);
                    }
                    if (this.status) {
                        NotificationdataModel notificationdataModel = (NotificationdataModel) new Gson().fromJson(jsonstring.toString(), NotificationdataModel.class);
                        this.notificationdata = notificationdataModel;
                        if (notificationdataModel.getData() != null) {
                            int size = this.notificationdata.getData().size();
                            if (this.notificationdata.getData().size() > 0) {
                                this.notificationlist.addAll(this.notificationdata.getData());
                                this.notificationAdapter.notifyItemRangeInserted(this.notificationlist.size() - 1, this.notificationlist.size() - size);
                                return;
                            }
                            return;
                        }
                        Toast.makeText(getContext(), R.string.no_data_found, 0).show();
                        return;
                    }
                    initialState();
                    List<Datum> list = this.notificationlist;
                    if (list != null && list.size() != 0) {
                        this.notificationlist.clear();
                    }
                    NotificationdataModel notificationdataModel2 = (NotificationdataModel) new Gson().fromJson(jsonstring.toString(), NotificationdataModel.class);
                    this.notificationdata = notificationdataModel2;
                    if (notificationdataModel2.getData() != null) {
                        this.notificationlist.addAll(this.notificationdata.getData());
                        if (this.notificationlist.size() > 0) {
                            NotificationAdapter notificationAdapter = new NotificationAdapter(getActivity(), this.notificationlist);
                            this.notificationAdapter = notificationAdapter;
                            this.notificationrecyceler.setAdapter(notificationAdapter);
                            this.notificationAdapter.setNestedScrollView(this.nestedScrollView);
                            return;
                        }
                        return;
                    }
                    Toast.makeText(getContext(), R.string.no_data_found, 0).show();
                    return;
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
        ProgressBar progressBar = this.paginationLoader;
        if (progressBar == null || !progressBar.isShown()) {
            return;
        }
        this.paginationLoader.setVisibility(8);
    }
}
