package com.appnew.android.TestRegisteration;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.TestReport;
import com.appnew.android.Model.TestReportData;
import com.appnew.android.TestRegisteration.adapter.TestReportAdapter;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Zoom.Activity.AllDoubtsFragmentKt;
import com.appnew.android.databinding.ActivityTestReportBinding;
import com.google.gson.Gson;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: TestReportActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\u0010\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020%H\u0002J,\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'2\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010*\u001a\u0004\u0018\u00010(2\u0006\u0010+\u001a\u00020,H\u0016J,\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020/2\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010*\u001a\u0004\u0018\u00010(2\u0006\u00100\u001a\u00020%H\u0016J&\u00101\u001a\u00020 2\b\u0010.\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010*\u001a\u0004\u0018\u00010(H\u0016J \u00102\u001a\u00020 2\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/appnew/android/TestRegisteration/TestReportActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/ActivityTestReportBinding;", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "testReportAdapter", "Lcom/appnew/android/TestRegisteration/adapter/TestReportAdapter;", "getTestReportAdapter", "()Lcom/appnew/android/TestRegisteration/adapter/TestReportAdapter;", "setTestReportAdapter", "(Lcom/appnew/android/TestRegisteration/adapter/TestReportAdapter;)V", "testReport", "Lcom/appnew/android/Model/TestReport;", "testReportArrayList", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/TestReportData;", "Lkotlin/collections/ArrayList;", "getTestReportArrayList", "()Ljava/util/ArrayList;", "setTestReportArrayList", "(Ljava/util/ArrayList;)V", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getTestReport", "showProgress", "", "getAPIB", "Lretrofit2/Call;", "", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "ErrorCallBack", "setAdapter", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TestReportActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack {
    public static final int $stable = 8;
    private ActivityTestReportBinding binding;
    private RecyclerView.LayoutManager layoutManager;
    private NetworkCall networkCall;
    private TestReport testReport;
    private TestReportAdapter testReportAdapter;
    private ArrayList<TestReportData> testReportArrayList = new ArrayList<>();

    public final NetworkCall getNetworkCall() {
        return this.networkCall;
    }

    public final void setNetworkCall(NetworkCall networkCall) {
        this.networkCall = networkCall;
    }

    public final TestReportAdapter getTestReportAdapter() {
        return this.testReportAdapter;
    }

    public final void setTestReportAdapter(TestReportAdapter testReportAdapter) {
        this.testReportAdapter = testReportAdapter;
    }

    public final ArrayList<TestReportData> getTestReportArrayList() {
        return this.testReportArrayList;
    }

    public final void setTestReportArrayList(ArrayList<TestReportData> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.testReportArrayList = arrayList;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTestReportBinding activityTestReportBindingInflate = ActivityTestReportBinding.inflate(getLayoutInflater());
        this.binding = activityTestReportBindingInflate;
        ActivityTestReportBinding activityTestReportBinding = null;
        if (activityTestReportBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestReportBindingInflate = null;
        }
        setContentView(activityTestReportBindingInflate.root);
        TestReportActivity testReportActivity = this;
        this.layoutManager = new LinearLayoutManager(testReportActivity);
        ActivityTestReportBinding activityTestReportBinding2 = this.binding;
        if (activityTestReportBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestReportBinding2 = null;
        }
        activityTestReportBinding2.TestReportRecycler.setLayoutManager(this.layoutManager);
        this.networkCall = new NetworkCall(this, testReportActivity);
        getTestReport(false);
        ActivityTestReportBinding activityTestReportBinding3 = this.binding;
        if (activityTestReportBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTestReportBinding = activityTestReportBinding3;
        }
        activityTestReportBinding.testReportBack.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TestRegisteration.TestReportActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onBackPressed();
            }
        });
    }

    private final void getTestReport(boolean showProgress) {
        NetworkCall networkCall = this.networkCall;
        if (networkCall != null) {
            networkCall.NetworkAPICall(API.API_TEST_REPORT_LIST, "", showProgress, false);
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        Intrinsics.checkNotNullParameter(service, "service");
        if (!Intrinsics.areEqual(apitype, API.API_TEST_REPORT_LIST)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setUser_id(SharedPreference.getInstance().getLoggedInUser().getId());
        return service.getTestReportList(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) {
        Intrinsics.checkNotNullParameter(jsonstring, "jsonstring");
        if (Intrinsics.areEqual(apitype, API.API_TEST_REPORT_LIST)) {
            try {
                if (jsonstring.getString("status").equals("true")) {
                    TestReport testReport = (TestReport) new Gson().fromJson(jsonstring.toString(), TestReport.class);
                    this.testReport = testReport;
                    if ((testReport != null ? testReport.getData() : null) != null) {
                        ArrayList<TestReportData> arrayList = this.testReportArrayList;
                        if (arrayList != null) {
                            arrayList.clear();
                        }
                        ArrayList<TestReportData> arrayList2 = this.testReportArrayList;
                        if (arrayList2 != null) {
                            TestReport testReport2 = this.testReport;
                            Intrinsics.checkNotNull(testReport2);
                            arrayList2.addAll(testReport2.getData());
                        }
                        setAdapter(this.testReportArrayList);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        if (!Intrinsics.areEqual(apitype, API.API_GET_USER_SUPPORT_CATEGORY) || AllDoubtsFragmentKt.getPaginationLoader() == null) {
            return;
        }
        ProgressBar paginationLoader = AllDoubtsFragmentKt.getPaginationLoader();
        Intrinsics.checkNotNull(paginationLoader);
        if (paginationLoader.isShown()) {
            ProgressBar paginationLoader2 = AllDoubtsFragmentKt.getPaginationLoader();
            Intrinsics.checkNotNull(paginationLoader2);
            paginationLoader2.setVisibility(8);
        }
    }

    private final void setAdapter(ArrayList<TestReportData> testReportArrayList) {
        this.testReportAdapter = new TestReportAdapter(testReportArrayList, this);
        ActivityTestReportBinding activityTestReportBinding = this.binding;
        if (activityTestReportBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTestReportBinding = null;
        }
        activityTestReportBinding.TestReportRecycler.setAdapter(this.testReportAdapter);
    }
}
