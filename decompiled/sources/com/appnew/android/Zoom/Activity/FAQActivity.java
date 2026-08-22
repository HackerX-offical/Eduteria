package com.appnew.android.Zoom.Activity;

import android.os.Bundle;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.ExtensionFunctions.XtensionFunctionKt;
import com.appnew.android.Model.ZoomModel.FaqDetail;
import com.appnew.android.Model.ZoomModel.FaqModel;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Zoom.Adapter.RvAdapter;
import com.appnew.android.databinding.ActivityFaqactivityBinding;
import com.google.gson.Gson;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: FAQActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J,\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J,\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001b2\u0006\u0010#\u001a\u00020\u0018H\u0016J\u0016\u0010$\u001a\u00020\u00132\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J&\u0010%\u001a\u00020\u00132\b\u0010!\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001bH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/appnew/android/Zoom/Activity/FAQActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/ActivityFaqactivityBinding;", "getBinding", "()Lcom/appnew/android/databinding/ActivityFaqactivityBinding;", "setBinding", "(Lcom/appnew/android/databinding/ActivityFaqactivityBinding;)V", "faqModel", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/ZoomModel/FaqModel;", "faqDetail", "Lcom/appnew/android/Model/ZoomModel/FaqDetail;", "rvAdapter", "Lcom/appnew/android/Zoom/Adapter/RvAdapter;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getFAQ", "showProgress", "", "getAPIB", "Lretrofit2/Call;", "", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "setAdapter", "ErrorCallBack", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FAQActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack {
    public static final int $stable = 8;
    public ActivityFaqactivityBinding binding;
    private FaqDetail faqDetail;
    private ArrayList<FaqModel> faqModel = new ArrayList<>();
    private RvAdapter rvAdapter;

    public final ActivityFaqactivityBinding getBinding() {
        ActivityFaqactivityBinding activityFaqactivityBinding = this.binding;
        if (activityFaqactivityBinding != null) {
            return activityFaqactivityBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(ActivityFaqactivityBinding activityFaqactivityBinding) {
        Intrinsics.checkNotNullParameter(activityFaqactivityBinding, "<set-?>");
        this.binding = activityFaqactivityBinding;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FAQActivity fAQActivity = this;
        Helper.setSystemBarLight(fAQActivity);
        setBinding(ActivityFaqactivityBinding.inflate(getLayoutInflater()));
        setContentView(getBinding().getRoot());
        Helper.enableScreenShot(fAQActivity);
        if (getIntent() != null) {
            getBinding().faqTitleTV.setText(getIntent().getStringExtra("title_key"));
        }
        FAQActivity fAQActivity2 = this;
        Helper.showProgressDialog(fAQActivity2);
        AllDoubtsFragmentKt.setNetworkCall(new NetworkCall(this, fAQActivity2));
        getFAQ(false);
        getBinding().faqImageBack.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Activity.FAQActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FAQActivity.onCreate$lambda$0(this.f$0);
            }
        }));
        getBinding().rvList.setLayoutManager(new LinearLayoutManager(fAQActivity2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(FAQActivity fAQActivity) {
        fAQActivity.finish();
        return Unit.INSTANCE;
    }

    private final void getFAQ(boolean showProgress) {
        NetworkCall networkCall = AllDoubtsFragmentKt.getNetworkCall();
        if (networkCall != null) {
            networkCall.NetworkAPICall(API.API_GET_FAQ, "", showProgress, false);
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        Intrinsics.checkNotNullParameter(service, "service");
        if (!Intrinsics.areEqual(apitype, API.API_GET_FAQ)) {
            return null;
        }
        AES.encrypt(new Gson().toJson(new EncryptionData()));
        return service.getFAQ();
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) {
        Intrinsics.checkNotNullParameter(jsonstring, "jsonstring");
        if (Intrinsics.areEqual(apitype, API.API_GET_FAQ)) {
            try {
                Helper.dismissProgressDialog();
                if (jsonstring.getString("status").equals("true")) {
                    FaqDetail faqDetail = (FaqDetail) new Gson().fromJson(jsonstring.toString(), FaqDetail.class);
                    this.faqDetail = faqDetail;
                    Intrinsics.checkNotNull(faqDetail);
                    if (faqDetail.getData() != null) {
                        ArrayList<FaqModel> arrayList = this.faqModel;
                        if (arrayList != null) {
                            FaqDetail faqDetail2 = this.faqDetail;
                            Intrinsics.checkNotNull(faqDetail2);
                            arrayList.addAll(faqDetail2.getData());
                        }
                        setAdapter(this.faqModel);
                        return;
                    }
                    return;
                }
                getBinding().noDataFoundRL.setVisibility(0);
                String string = jsonstring.getString("message");
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                XtensionFunctionKt.showSmallLengthToast(this, string);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private final void setAdapter(ArrayList<FaqModel> faqModel) {
        this.rvAdapter = new RvAdapter(faqModel);
        RecyclerView recyclerView = getBinding().rvList;
        RvAdapter rvAdapter = this.rvAdapter;
        if (rvAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvAdapter");
            rvAdapter = null;
        }
        recyclerView.setAdapter(rvAdapter);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        if (!Intrinsics.areEqual(apitype, API.API_GET_FAQ) || AllDoubtsFragmentKt.getPaginationLoader() == null) {
            return;
        }
        ProgressBar paginationLoader = AllDoubtsFragmentKt.getPaginationLoader();
        Intrinsics.checkNotNull(paginationLoader);
        if (paginationLoader.isShown()) {
            getBinding().noDataFoundRL.setVisibility(0);
        }
    }
}
