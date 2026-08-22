package com.appnew.android.sme.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.MainFragment;
import com.appnew.android.databinding.FragmentStudentListBinding;
import com.appnew.android.sme.Adapter.StudentListAdapter;
import com.appnew.android.sme.SmeStudentListModel;
import com.appnew.android.sme.SmeStudentModel;
import com.google.gson.Gson;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: StudentListFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J.\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010\u001f2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\"\u001a\u0004\u0018\u00010 2\u0006\u0010#\u001a\u00020$H\u0016J,\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020*2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\"\u001a\u0004\u0018\u00010 2\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020\u0015H\u0002J&\u0010.\u001a\u00020\u00152\b\u0010/\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\"\u001a\u0004\u0018\u00010 H\u0016J\b\u00100\u001a\u00020\u0015H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u000e\u0012\b\u0012\u00060\fR\u00020\r\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/appnew/android/sme/Fragment/StudentListFragment;", "Lcom/appnew/android/Utils/Network/MainFragment;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/FragmentStudentListBinding;", "getBinding$app_EDUTERIARelease", "()Lcom/appnew/android/databinding/FragmentStudentListBinding;", "setBinding$app_EDUTERIARelease", "(Lcom/appnew/android/databinding/FragmentStudentListBinding;)V", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/sme/Adapter/StudentListAdapter$ViewHolder;", "Lcom/appnew/android/sme/Adapter/StudentListAdapter;", "smeStudentRecycler", "Landroidx/recyclerview/widget/RecyclerView;", "getSmeStudentRecycler", "()Landroidx/recyclerview/widget/RecyclerView;", "setSmeStudentRecycler", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "getAPIB", "Lretrofit2/Call;", "", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "responseSmeData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/appnew/android/sme/SmeStudentListModel;", "SuccessCallBack", "jsonObject", "Lorg/json/JSONObject;", "showprogress", "", "setStudentList", "ErrorCallBack", "jsonstring", "getStudentData", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StudentListFragment extends MainFragment {
    public static final int $stable = 8;
    private RecyclerView.Adapter<StudentListAdapter.ViewHolder> adapter;
    private FragmentStudentListBinding binding;
    private final MutableLiveData<SmeStudentListModel> responseSmeData = new MutableLiveData<>();
    private RecyclerView smeStudentRecycler;

    /* JADX INFO: renamed from: getBinding$app_EDUTERIARelease, reason: from getter */
    public final FragmentStudentListBinding getBinding() {
        return this.binding;
    }

    public final void setBinding$app_EDUTERIARelease(FragmentStudentListBinding fragmentStudentListBinding) {
        this.binding = fragmentStudentListBinding;
    }

    public final RecyclerView getSmeStudentRecycler() {
        return this.smeStudentRecycler;
    }

    public final void setSmeStudentRecycler(RecyclerView recyclerView) {
        this.smeStudentRecycler = recyclerView;
    }

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.binding = FragmentStudentListBinding.inflate(inflater, container, false);
        getStudentData();
        FragmentStudentListBinding fragmentStudentListBinding = this.binding;
        RecyclerView recyclerView = fragmentStudentListBinding != null ? fragmentStudentListBinding.studentListRecycler : null;
        this.smeStudentRecycler = recyclerView;
        Intrinsics.checkNotNull(recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView recyclerView2 = this.smeStudentRecycler;
        Intrinsics.checkNotNull(recyclerView2);
        recyclerView2.setHasFixedSize(true);
        FragmentStudentListBinding fragmentStudentListBinding2 = this.binding;
        Intrinsics.checkNotNull(fragmentStudentListBinding2);
        return fragmentStudentListBinding2.getRoot();
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        Intrinsics.checkNotNullParameter(service, "service");
        if (!Intrinsics.areEqual(apitype, API.API_DOUBT_USER_LIST)) {
            return null;
        }
        AES.encrypt(new Gson().toJson(new EncryptionData()));
        return service.getStudentList();
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void SuccessCallBack(JSONObject jsonObject, String apitype, String typeApi, boolean showprogress) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        if (Intrinsics.areEqual(apitype, API.API_DOUBT_USER_LIST)) {
            try {
                if (Intrinsics.areEqual(jsonObject.optString("status"), "true")) {
                    this.responseSmeData.setValue((SmeStudentListModel) new Gson().fromJson(jsonObject.toString(), SmeStudentListModel.class));
                    setStudentList();
                }
            } catch (Exception e2) {
                ErrorCallBack(e2.getMessage() + " : " + e2.getLocalizedMessage(), apitype, typeApi);
                e2.printStackTrace();
            }
        }
    }

    private final void setStudentList() {
        SmeStudentListModel value = this.responseSmeData.getValue();
        List<SmeStudentModel> data = value != null ? value.getData() : null;
        Intrinsics.checkNotNull(data);
        this.adapter = new StudentListAdapter(data, new Function0() { // from class: com.appnew.android.sme.Fragment.StudentListFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        });
        RecyclerView recyclerView = this.smeStudentRecycler;
        Intrinsics.checkNotNull(recyclerView);
        recyclerView.setAdapter(this.adapter);
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        Intrinsics.areEqual(apitype, API.API_DOUBT_USER_LIST);
    }

    private final void getStudentData() {
        NetworkAPICall(API.API_DOUBT_USER_LIST, "", true, false, false);
    }
}
