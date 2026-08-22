package com.appnew.android.TeacherTimeTable;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.TeacherTimeTable.BatchTimetable;
import com.appnew.android.Model.TeacherTimeTable.TeacherTimeTableModel;
import com.appnew.android.Model.TimeTable.Data;
import com.appnew.android.Model.TimeTable.TimeTableModel;
import com.appnew.android.Model.ZoomModel.CurrentAffairDataModel;
import com.appnew.android.TeacherTimeTable.Adapter.TeacherTimeTableAdapter;
import com.appnew.android.TeacherTimeTable.Interface.DateItemClick;
import com.appnew.android.Theme.Adapter.DateTableAdapter;
import com.appnew.android.Theme.Adapter.TimeTableDateAdapter;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Zoom.ItemClickListener;
import com.appnew.android.databinding.ActivityTimeTableBinding;
import com.clevertap.android.sdk.Constants;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: TimeTableActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J.\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00162\b\u0010 \u001a\u0004\u0018\u00010\u00162\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J.\u0010#\u001a\u00020\u001a2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00162\b\u0010 \u001a\u0004\u0018\u00010\u00162\u0006\u0010&\u001a\u00020'H\u0016J&\u0010(\u001a\u00020\u001a2\b\u0010$\u001a\u0004\u0018\u00010\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\u00162\b\u0010 \u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+H\u0002J*\u0010,\u001a\u00020\u001a2\u0016\u0010-\u001a\u0012\u0012\u0004\u0012\u00020/0.j\b\u0012\u0004\u0012\u00020/`02\b\u0010 \u001a\u0004\u0018\u00010\u0016H\u0002J0\u00101\u001a\u00020\u001a2\u0016\u00102\u001a\u0012\u0012\u0004\u0012\u0002030.j\b\u0012\u0004\u0012\u000203`02\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0016J\u0010\u00108\u001a\u00020\u001a2\u0006\u00104\u001a\u00020\u0016H\u0016J\u0016\u00109\u001a\u00020\u001a2\f\u00104\u001a\b\u0012\u0004\u0012\u00020;0:H\u0016J(\u00101\u001a\u00020\u001a2\u0016\u00102\u001a\u0012\u0012\u0004\u0012\u00020/0.j\b\u0012\u0004\u0012\u00020/`02\u0006\u00104\u001a\u000205H\u0016J\u0010\u0010<\u001a\u00020\u001a2\u0006\u0010=\u001a\u000205H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006>"}, d2 = {"Lcom/appnew/android/TeacherTimeTable/TimeTableActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "Lcom/appnew/android/TeacherTimeTable/Interface/DateItemClick;", "Lcom/appnew/android/Zoom/ItemClickListener;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/ActivityTimeTableBinding;", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "sharedPreferences", "Landroid/content/SharedPreferences;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "setSharedPreferences", "(Landroid/content/SharedPreferences;)V", "themeKey", "", "getThemeKey", "()Ljava/lang/String;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "", "ErrorCallBack", "setTimeTableAdapter", "teacherTimeTableModel", "Lcom/appnew/android/Model/TeacherTimeTable/TeacherTimeTableModel;", "setTimeTableData", "list", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/TimeTable/Data;", "Lkotlin/collections/ArrayList;", "onClickTimeTableDate", "data", "Lcom/appnew/android/Model/TeacherTimeTable/BatchTimetable;", Const.POSITION, "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onClick", "onClickCurrentAffair", "", "Lcom/appnew/android/Model/ZoomModel/CurrentAffairDataModel;", "getPosition", Constants.INAPP_POSITION, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TimeTableActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack, DateItemClick, ItemClickListener {
    public static final int $stable = 8;
    private ActivityTimeTableBinding binding;
    private NetworkCall networkCall;
    public SharedPreferences sharedPreferences;
    private final String themeKey = "currentTheme";

    public final NetworkCall getNetworkCall() {
        return this.networkCall;
    }

    public final void setNetworkCall(NetworkCall networkCall) {
        this.networkCall = networkCall;
    }

    public final SharedPreferences getSharedPreferences() {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
        return null;
    }

    public final void setSharedPreferences(SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<set-?>");
        this.sharedPreferences = sharedPreferences;
    }

    public final String getThemeKey() {
        return this.themeKey;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTimeTableBinding activityTimeTableBindingInflate = ActivityTimeTableBinding.inflate(getLayoutInflater());
        this.binding = activityTimeTableBindingInflate;
        ActivityTimeTableBinding activityTimeTableBinding = null;
        if (activityTimeTableBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTimeTableBindingInflate = null;
        }
        setContentView(activityTimeTableBindingInflate.getRoot());
        ActivityTimeTableBinding activityTimeTableBinding2 = this.binding;
        if (activityTimeTableBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTimeTableBinding = activityTimeTableBinding2;
        }
        activityTimeTableBinding.currentAffairImageBack.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TeacherTimeTable.TimeTableActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.finish();
            }
        });
        TimeTableActivity timeTableActivity = this;
        this.networkCall = new NetworkCall(this, timeTableActivity);
        Helper.showProgressDialog(timeTableActivity);
        NetworkCall networkCall = this.networkCall;
        if (networkCall != null) {
            networkCall.NetworkAPICall(API.API_TIME_TABLE, "", true, false);
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        if (Intrinsics.areEqual(apitype, API.API_TEACHER_TIME_TABLE)) {
            String strEncrypt = AES.encrypt(new Gson().toJson(new EncryptionData()));
            if (service != null) {
                return service.getTeacherTimeTable(strEncrypt);
            }
            return null;
        }
        if (Intrinsics.areEqual(apitype, API.API_TIME_TABLE)) {
            String strEncrypt2 = AES.encrypt(new Gson().toJson(new EncryptionData()));
            if (service != null) {
                return service.getTimeTable(strEncrypt2);
            }
        }
        return null;
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) {
        ActivityTimeTableBinding activityTimeTableBinding = null;
        try {
            if (Intrinsics.areEqual(apitype, API.API_TEACHER_TIME_TABLE)) {
                Helper.dismissProgressDialog();
                if (StringsKt.equals$default(jsonstring != null ? jsonstring.getString("status") : null, "true", false, 2, null)) {
                    ActivityTimeTableBinding activityTimeTableBinding2 = this.binding;
                    if (activityTimeTableBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityTimeTableBinding = activityTimeTableBinding2;
                    }
                    activityTimeTableBinding.teacherTimeTableLayout.setVisibility(0);
                    Object objFromJson = new Gson().fromJson(String.valueOf(jsonstring), (Class<Object>) TeacherTimeTableModel.class);
                    Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
                    setTimeTableAdapter((TeacherTimeTableModel) objFromJson);
                    return;
                }
                ActivityTimeTableBinding activityTimeTableBinding3 = this.binding;
                if (activityTimeTableBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityTimeTableBinding = activityTimeTableBinding3;
                }
                activityTimeTableBinding.teacherTimeTableLayout.setVisibility(8);
                return;
            }
            if (Intrinsics.areEqual(apitype, API.API_TIME_TABLE)) {
                Helper.dismissProgressDialog();
                if (Intrinsics.areEqual(jsonstring != null ? jsonstring.optString("status") : null, "true")) {
                    ActivityTimeTableBinding activityTimeTableBinding4 = this.binding;
                    if (activityTimeTableBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityTimeTableBinding4 = null;
                    }
                    activityTimeTableBinding4.teacherTimeTableLayout.setVisibility(0);
                    ActivityTimeTableBinding activityTimeTableBinding5 = this.binding;
                    if (activityTimeTableBinding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityTimeTableBinding = activityTimeTableBinding5;
                    }
                    activityTimeTableBinding.noDataFoundRL.setVisibility(8);
                    if (jsonstring.has("data")) {
                        Object objFromJson2 = new Gson().fromJson(jsonstring.toString(), (Class<Object>) TimeTableModel.class);
                        Intrinsics.checkNotNullExpressionValue(objFromJson2, "fromJson(...)");
                        setTimeTableData(((TimeTableModel) objFromJson2).getData(), typeApi);
                        return;
                    }
                    return;
                }
                ActivityTimeTableBinding activityTimeTableBinding6 = this.binding;
                if (activityTimeTableBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityTimeTableBinding6 = null;
                }
                activityTimeTableBinding6.noDataFoundRL.setVisibility(0);
                ActivityTimeTableBinding activityTimeTableBinding7 = this.binding;
                if (activityTimeTableBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityTimeTableBinding = activityTimeTableBinding7;
                }
                activityTimeTableBinding.teacherTimeTableLayout.setVisibility(8);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    private final void setTimeTableAdapter(TeacherTimeTableModel teacherTimeTableModel) {
        TeacherTimeTableAdapter teacherTimeTableAdapter = new TeacherTimeTableAdapter(teacherTimeTableModel.getData(), this);
        ActivityTimeTableBinding activityTimeTableBinding = this.binding;
        ActivityTimeTableBinding activityTimeTableBinding2 = null;
        if (activityTimeTableBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTimeTableBinding = null;
        }
        activityTimeTableBinding.batchRecycler.setLayoutManager(new LinearLayoutManager(this));
        ActivityTimeTableBinding activityTimeTableBinding3 = this.binding;
        if (activityTimeTableBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTimeTableBinding3 = null;
        }
        activityTimeTableBinding3.batchRecycler.setAdapter(teacherTimeTableAdapter);
        ActivityTimeTableBinding activityTimeTableBinding4 = this.binding;
        if (activityTimeTableBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTimeTableBinding2 = activityTimeTableBinding4;
        }
        activityTimeTableBinding2.batchRecycler.setNestedScrollingEnabled(false);
    }

    private final void setTimeTableData(ArrayList<Data> list, String typeApi) {
        ArrayList arrayList = new ArrayList();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList<Data> arrayList2 = list;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(list.get(i).getDate());
        }
        linkedHashSet.addAll(arrayList);
        arrayList.clear();
        arrayList.addAll(linkedHashSet);
        TimeTableActivity timeTableActivity = this;
        DateTableAdapter dateTableAdapter = new DateTableAdapter(arrayList, list, timeTableActivity, this);
        ActivityTimeTableBinding activityTimeTableBinding = this.binding;
        ActivityTimeTableBinding activityTimeTableBinding2 = null;
        if (activityTimeTableBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTimeTableBinding = null;
        }
        TimeTableActivity timeTableActivity2 = this;
        activityTimeTableBinding.DateTableRecycler.setLayoutManager(new LinearLayoutManager(timeTableActivity2, 0, false));
        ActivityTimeTableBinding activityTimeTableBinding3 = this.binding;
        if (activityTimeTableBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTimeTableBinding3 = null;
        }
        activityTimeTableBinding3.DateTableRecycler.setAdapter(dateTableAdapter);
        ActivityTimeTableBinding activityTimeTableBinding4 = this.binding;
        if (activityTimeTableBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTimeTableBinding4 = null;
        }
        activityTimeTableBinding4.DateTableRecycler.setNestedScrollingEnabled(false);
        ArrayList arrayList3 = new ArrayList();
        int size2 = arrayList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (Intrinsics.areEqual(list.get(0).getDate(), list.get(i2).getDate())) {
                arrayList3.add(list.get(i2));
            }
        }
        TimeTableDateAdapter timeTableDateAdapter = new TimeTableDateAdapter(arrayList3, timeTableActivity);
        ActivityTimeTableBinding activityTimeTableBinding5 = this.binding;
        if (activityTimeTableBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTimeTableBinding5 = null;
        }
        activityTimeTableBinding5.timeTableRecycler.setLayoutManager(new LinearLayoutManager(timeTableActivity2));
        ActivityTimeTableBinding activityTimeTableBinding6 = this.binding;
        if (activityTimeTableBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTimeTableBinding6 = null;
        }
        activityTimeTableBinding6.timeTableRecycler.setAdapter(timeTableDateAdapter);
        ActivityTimeTableBinding activityTimeTableBinding7 = this.binding;
        if (activityTimeTableBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTimeTableBinding2 = activityTimeTableBinding7;
        }
        activityTimeTableBinding2.timeTableRecycler.setNestedScrollingEnabled(false);
    }

    @Override // com.appnew.android.TeacherTimeTable.Interface.DateItemClick
    public void onClickTimeTableDate(ArrayList<BatchTimetable> data, int position, RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.appnew.android.Zoom.ItemClickListener
    public void onClick(String position) {
        Intrinsics.checkNotNullParameter(position, "position");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.appnew.android.Zoom.ItemClickListener
    public void onClickCurrentAffair(List<CurrentAffairDataModel> position) {
        Intrinsics.checkNotNullParameter(position, "position");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.appnew.android.Zoom.ItemClickListener
    public void onClickTimeTableDate(ArrayList<Data> data, int position) {
        Intrinsics.checkNotNullParameter(data, "data");
        TimeTableDateAdapter timeTableDateAdapter = new TimeTableDateAdapter(data, this);
        ActivityTimeTableBinding activityTimeTableBinding = this.binding;
        ActivityTimeTableBinding activityTimeTableBinding2 = null;
        if (activityTimeTableBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTimeTableBinding = null;
        }
        activityTimeTableBinding.timeTableRecycler.setLayoutManager(new LinearLayoutManager(this));
        ActivityTimeTableBinding activityTimeTableBinding3 = this.binding;
        if (activityTimeTableBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTimeTableBinding3 = null;
        }
        activityTimeTableBinding3.timeTableRecycler.setAdapter(timeTableDateAdapter);
        ActivityTimeTableBinding activityTimeTableBinding4 = this.binding;
        if (activityTimeTableBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTimeTableBinding2 = activityTimeTableBinding4;
        }
        activityTimeTableBinding2.timeTableRecycler.setNestedScrollingEnabled(false);
    }

    @Override // com.appnew.android.Zoom.ItemClickListener
    public void getPosition(int pos) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
