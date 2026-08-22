package com.appnew.android.sme.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.MainFragment;
import com.appnew.android.databinding.FragmentStudentDoubtListBinding;
import com.appnew.android.sme.Adapter.SmeDoubtAdapter;
import com.appnew.android.sme.Data;
import com.appnew.android.sme.Doubt;
import com.appnew.android.sme.StudentDoubtListModel;
import com.google.gson.Gson;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: StudentDoubtListFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J&\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J.\u00105\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u0001062\b\u00107\u001a\u0004\u0018\u00010\u001d2\b\u00108\u001a\u0004\u0018\u00010\u001d2\u0006\u00109\u001a\u00020:H\u0016J,\u0010;\u001a\u00020)2\u0006\u0010<\u001a\u00020=2\b\u00107\u001a\u0004\u0018\u00010\u001d2\b\u00108\u001a\u0004\u0018\u00010\u001d2\u0006\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020)H\u0002J&\u0010A\u001a\u00020)2\b\u0010B\u001a\u0004\u0018\u00010\u001d2\b\u00107\u001a\u0004\u0018\u00010\u001d2\b\u00108\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010C\u001a\u00020)H\u0002J\u0012\u0010D\u001a\u00020?2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\b\u0010G\u001a\u00020)H\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001c\u0010%\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020403X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/appnew/android/sme/Fragment/StudentDoubtListFragment;", "Lcom/appnew/android/Utils/Network/MainFragment;", "Landroidx/appcompat/widget/PopupMenu$OnMenuItemClickListener;", "<init>", "()V", "doubtList", "", "Lcom/appnew/android/sme/Doubt;", "binding", "Lcom/appnew/android/databinding/FragmentStudentDoubtListBinding;", "getBinding", "()Lcom/appnew/android/databinding/FragmentStudentDoubtListBinding;", "setBinding", "(Lcom/appnew/android/databinding/FragmentStudentDoubtListBinding;)V", "adapter", "Lcom/appnew/android/sme/Adapter/SmeDoubtAdapter;", "studentDoubtRecycler", "Landroidx/recyclerview/widget/RecyclerView;", "getStudentDoubtRecycler", "()Landroidx/recyclerview/widget/RecyclerView;", "setStudentDoubtRecycler", "(Landroidx/recyclerview/widget/RecyclerView;)V", "filterOne", "Landroid/widget/TextView;", "getFilterOne", "()Landroid/widget/TextView;", "setFilterOne", "(Landroid/widget/TextView;)V", "clicktype", "", "getClicktype", "()Ljava/lang/String;", "setClicktype", "(Ljava/lang/String;)V", "subjectId", "getSubjectId", "setSubjectId", "userId", "getUserId", "setUserId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "studentDoubtLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/appnew/android/sme/StudentDoubtListModel;", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonObject", "Lorg/json/JSONObject;", "showprogress", "", "setStudentDoubtList", "ErrorCallBack", "jsonstring", "getStudentDoubt", "onMenuItemClick", "item", "Landroid/view/MenuItem;", "onResume", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StudentDoubtListFragment extends MainFragment implements PopupMenu.OnMenuItemClickListener {
    public static final int $stable = 8;
    private SmeDoubtAdapter adapter;
    public FragmentStudentDoubtListBinding binding;
    private List<Doubt> doubtList;
    public TextView filterOne;
    private RecyclerView studentDoubtRecycler;
    private String subjectId;
    private String userId;
    private String clicktype = "";
    private MutableLiveData<StudentDoubtListModel> studentDoubtLiveData = new MutableLiveData<>();

    public final FragmentStudentDoubtListBinding getBinding() {
        FragmentStudentDoubtListBinding fragmentStudentDoubtListBinding = this.binding;
        if (fragmentStudentDoubtListBinding != null) {
            return fragmentStudentDoubtListBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(FragmentStudentDoubtListBinding fragmentStudentDoubtListBinding) {
        Intrinsics.checkNotNullParameter(fragmentStudentDoubtListBinding, "<set-?>");
        this.binding = fragmentStudentDoubtListBinding;
    }

    public final RecyclerView getStudentDoubtRecycler() {
        return this.studentDoubtRecycler;
    }

    public final void setStudentDoubtRecycler(RecyclerView recyclerView) {
        this.studentDoubtRecycler = recyclerView;
    }

    public final TextView getFilterOne() {
        TextView textView = this.filterOne;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("filterOne");
        return null;
    }

    public final void setFilterOne(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.filterOne = textView;
    }

    public final String getClicktype() {
        return this.clicktype;
    }

    public final void setClicktype(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.clicktype = str;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final void setSubjectId(String str) {
        this.subjectId = str;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        setBinding(FragmentStudentDoubtListBinding.inflate(getLayoutInflater(), container, false));
        getStudentDoubt();
        this.studentDoubtRecycler = getBinding().studentDoubtRecycler;
        TextView textView = getBinding().filterOne;
        Intrinsics.checkNotNull(textView);
        setFilterOne(textView);
        RecyclerView recyclerView = this.studentDoubtRecycler;
        Intrinsics.checkNotNull(recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView recyclerView2 = this.studentDoubtRecycler;
        Intrinsics.checkNotNull(recyclerView2);
        recyclerView2.setHasFixedSize(true);
        RelativeLayout relativeLayout = getBinding().filterOneClick;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        RelativeLayout relativeLayout2 = getBinding().filterOneClick;
        if (relativeLayout2 != null) {
            relativeLayout2.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.sme.Fragment.StudentDoubtListFragment$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StudentDoubtListFragment.onCreateView$lambda$0(this.f$0);
                }
            }));
        }
        return getBinding().getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0(StudentDoubtListFragment studentDoubtListFragment) {
        if (!Helper.isNetworkConnected(studentDoubtListFragment.activity)) {
            Helper.showInternetToast(studentDoubtListFragment.activity);
            return Unit.INSTANCE;
        }
        PopupMenu popupMenu = new PopupMenu(studentDoubtListFragment.requireActivity(), studentDoubtListFragment.getFilterOne(), 3);
        StudentDoubtListModel value = studentDoubtListFragment.studentDoubtLiveData.getValue();
        List<Data> data = value != null ? value.getData() : null;
        Intrinsics.checkNotNull(data);
        Iterator<Data> it = data.iterator();
        while (it.hasNext()) {
            popupMenu.getMenu().add(it.next().getSubjectName());
        }
        studentDoubtListFragment.clicktype = "2";
        popupMenu.setOnMenuItemClickListener(studentDoubtListFragment);
        popupMenu.show();
        return Unit.INSTANCE;
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        Intrinsics.checkNotNullParameter(service, "service");
        if (!Intrinsics.areEqual(apitype, API.API_DOUBT_DOUBT_LIST)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setUser_id(this.userId);
        return service.getStudentDoubtList(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void SuccessCallBack(JSONObject jsonObject, String apitype, String typeApi, boolean showprogress) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        if (Intrinsics.areEqual(apitype, API.API_DOUBT_DOUBT_LIST)) {
            try {
                if (Intrinsics.areEqual(jsonObject.optString("status"), "true")) {
                    this.studentDoubtLiveData.setValue((StudentDoubtListModel) new Gson().fromJson(jsonObject.toString(), StudentDoubtListModel.class));
                    setStudentDoubtList();
                }
            } catch (Exception e2) {
                ErrorCallBack(e2.getMessage() + " : " + e2.getLocalizedMessage(), apitype, typeApi);
                e2.printStackTrace();
            }
        }
    }

    private final void setStudentDoubtList() {
        String subjectName;
        String id;
        List<Data> data;
        Data data2;
        List<Data> data3;
        Data data4;
        List<Data> data5;
        Data data6;
        List<Data> data7;
        StudentDoubtListModel value = this.studentDoubtLiveData.getValue();
        if (((value == null || (data7 = value.getData()) == null) ? 0 : data7.size()) > 0) {
            RelativeLayout relativeLayout = getBinding().filterOneClick;
            Intrinsics.checkNotNull(relativeLayout);
            relativeLayout.setVisibility(0);
            TextView filterOne = getFilterOne();
            StudentDoubtListModel value2 = this.studentDoubtLiveData.getValue();
            if (value2 == null || (data5 = value2.getData()) == null || (data6 = data5.get(0)) == null || (subjectName = data6.getSubjectName()) == null) {
                subjectName = "";
            }
            filterOne.setText(subjectName);
            StudentDoubtListModel value3 = this.studentDoubtLiveData.getValue();
            if (value3 == null || (data3 = value3.getData()) == null || (data4 = data3.get(0)) == null || (id = data4.getId()) == null) {
                id = "0";
            }
            this.subjectId = id;
            StudentDoubtListModel value4 = this.studentDoubtLiveData.getValue();
            SmeDoubtAdapter smeDoubtAdapter = null;
            List<Doubt> doubts = (value4 == null || (data = value4.getData()) == null || (data2 = data.get(0)) == null) ? null : data2.getDoubts();
            this.doubtList = doubts;
            if (doubts != null) {
                FragmentActivity fragmentActivityRequireActivity = requireActivity();
                Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
                smeDoubtAdapter = new SmeDoubtAdapter(doubts, fragmentActivityRequireActivity, "SME");
            }
            this.adapter = smeDoubtAdapter;
            RecyclerView recyclerView = this.studentDoubtRecycler;
            Intrinsics.checkNotNull(recyclerView);
            recyclerView.setAdapter(this.adapter);
        }
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        Intrinsics.areEqual(apitype, API.API_DOUBT_DOUBT_LIST);
    }

    private final void getStudentDoubt() {
        Bundle arguments = getArguments();
        this.userId = arguments != null ? arguments.getString("user_id") : null;
        NetworkAPICall(API.API_DOUBT_DOUBT_LIST, "", false, false, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem item) {
        List<Data> data;
        Data data2;
        if (StringsKt.equals(this.clicktype, "2", true)) {
            TextView filterOne = getFilterOne();
            Intrinsics.checkNotNull(item);
            filterOne.setText(item.getTitle());
            CharSequence title = item.getTitle();
            Intrinsics.checkNotNull(title);
            if (!title.equals("All")) {
                StudentDoubtListModel value = this.studentDoubtLiveData.getValue();
                doubts = value != null ? value.getData() : null;
                Intrinsics.checkNotNull(doubts);
                Iterator it = doubts.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Data data3 = (Data) it.next();
                    if (StringsKt.equals(data3.getSubjectName(), String.valueOf(item.getTitle()), true)) {
                        List<Doubt> doubts = data3.getDoubts();
                        this.doubtList = doubts;
                        SmeDoubtAdapter smeDoubtAdapter = this.adapter;
                        if (smeDoubtAdapter != null) {
                            smeDoubtAdapter.setData(doubts);
                        }
                    }
                }
            } else {
                StudentDoubtListModel value2 = this.studentDoubtLiveData.getValue();
                if (value2 != null && (data = value2.getData()) != null && (data2 = data.get(0)) != null) {
                    doubts = data2.getDoubts();
                }
                this.doubtList = doubts;
                SmeDoubtAdapter smeDoubtAdapter2 = this.adapter;
                if (smeDoubtAdapter2 != 0) {
                    smeDoubtAdapter2.setData(doubts);
                }
            }
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }
}
