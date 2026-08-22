package com.appnew.android.TeacherTimeTable.Activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.StudentModel.StudentModel;
import com.appnew.android.TeacherTimeTable.Adapter.StudentBatchListAdapter;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.databinding.ActivityStudentListBinding;
import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: StudentListActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J.\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J.\u0010\"\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020)H\u0002J&\u0010*\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006+"}, d2 = {"Lcom/appnew/android/TeacherTimeTable/Activity/StudentListActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/ActivityStudentListBinding;", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "id", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "setSharedPreferences", "(Landroid/content/SharedPreferences;)V", "themeKey", "getThemeKey", "()Ljava/lang/String;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "", "setTimeTableAdapter", "studentModel", "Lcom/appnew/android/Model/StudentModel/StudentModel;", "ErrorCallBack", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StudentListActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack {
    public static final int $stable = 8;
    private ActivityStudentListBinding binding;
    private String id;
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
        setSharedPreferences(getSharedPreferences("ThemePref", 0));
        ActivityStudentListBinding activityStudentListBindingInflate = ActivityStudentListBinding.inflate(getLayoutInflater());
        this.binding = activityStudentListBindingInflate;
        ActivityStudentListBinding activityStudentListBinding = null;
        if (activityStudentListBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityStudentListBindingInflate = null;
        }
        setContentView(activityStudentListBindingInflate.getRoot());
        ActivityStudentListBinding activityStudentListBinding2 = this.binding;
        if (activityStudentListBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityStudentListBinding = activityStudentListBinding2;
        }
        activityStudentListBinding.currentAffairImageBack.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TeacherTimeTable.Activity.StudentListActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.finish();
            }
        });
        StudentListActivity studentListActivity = this;
        this.networkCall = new NetworkCall(this, studentListActivity);
        if (getIntent() != null) {
            this.id = getIntent().getStringExtra("id");
            Helper.showProgressDialog(studentListActivity);
            NetworkCall networkCall = this.networkCall;
            if (networkCall != null) {
                networkCall.NetworkAPICall(API.API_BATCH_STUDENT_LIST, "", true, false);
            }
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        if (Intrinsics.areEqual(apitype, API.API_BATCH_STUDENT_LIST)) {
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setBatch_id(this.id);
            String strEncrypt = AES.encrypt(new Gson().toJson(encryptionData));
            if (service != null) {
                return service.getBatchList(strEncrypt);
            }
        }
        return null;
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) {
        if (Intrinsics.areEqual(apitype, API.API_BATCH_STUDENT_LIST)) {
            try {
                Helper.dismissProgressDialog();
                ActivityStudentListBinding activityStudentListBinding = this.binding;
                ActivityStudentListBinding activityStudentListBinding2 = null;
                if (activityStudentListBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityStudentListBinding = null;
                }
                activityStudentListBinding.noDataFoundRL.setVisibility(8);
                if (StringsKt.equals$default(jsonstring != null ? jsonstring.getString("status") : null, "true", false, 2, null)) {
                    Object objFromJson = new Gson().fromJson(String.valueOf(jsonstring), (Class<Object>) StudentModel.class);
                    Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
                    setTimeTableAdapter((StudentModel) objFromJson);
                } else {
                    ActivityStudentListBinding activityStudentListBinding3 = this.binding;
                    if (activityStudentListBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityStudentListBinding2 = activityStudentListBinding3;
                    }
                    activityStudentListBinding2.noDataFoundRL.setVisibility(0);
                }
            } catch (Exception unused) {
            }
        }
    }

    private final void setTimeTableAdapter(StudentModel studentModel) {
        StudentBatchListAdapter studentBatchListAdapter = new StudentBatchListAdapter(studentModel.getData(), this);
        ActivityStudentListBinding activityStudentListBinding = this.binding;
        ActivityStudentListBinding activityStudentListBinding2 = null;
        if (activityStudentListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityStudentListBinding = null;
        }
        activityStudentListBinding.StudentBatchList.setLayoutManager(new LinearLayoutManager(this));
        ActivityStudentListBinding activityStudentListBinding3 = this.binding;
        if (activityStudentListBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityStudentListBinding3 = null;
        }
        activityStudentListBinding3.StudentBatchList.setAdapter(studentBatchListAdapter);
        ActivityStudentListBinding activityStudentListBinding4 = this.binding;
        if (activityStudentListBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityStudentListBinding2 = activityStudentListBinding4;
        }
        activityStudentListBinding2.StudentBatchList.setNestedScrollingEnabled(false);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
