package com.appnew.android.Theme;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.UserAttendanceModel.UserAttendanceMain;
import com.appnew.android.Theme.Adapter.UserAttendanceAdapter;
import com.appnew.android.Theme.Adapter.UserAttendanceTableAdapter;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.databinding.ActivityUserAttendanceBinding;
import com.eduteria.app.app.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: UserAttendanceActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\b\u0010-\u001a\u00020*H\u0002J\u0010\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u000200H\u0002J\u0010\u00101\u001a\u00020*2\u0006\u00102\u001a\u00020!H\u0002J(\u00103\u001a\n\u0012\u0004\u0012\u00020!\u0018\u0001042\u0006\u00105\u001a\u00020!2\u0006\u00106\u001a\u00020!2\u0006\u00107\u001a\u000208H\u0016J(\u00109\u001a\u00020*2\u0006\u0010:\u001a\u00020;2\u0006\u00105\u001a\u00020!2\u0006\u00106\u001a\u00020!2\u0006\u0010<\u001a\u000200H\u0016J \u0010=\u001a\u00020*2\u0006\u0010:\u001a\u00020!2\u0006\u00105\u001a\u00020!2\u0006\u00106\u001a\u00020!H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%¨\u0006>"}, d2 = {"Lcom/appnew/android/Theme/UserAttendanceActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "<init>", "()V", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "binding", "Lcom/appnew/android/databinding/ActivityUserAttendanceBinding;", "getBinding", "()Lcom/appnew/android/databinding/ActivityUserAttendanceBinding;", "setBinding", "(Lcom/appnew/android/databinding/ActivityUserAttendanceBinding;)V", "myCalendar", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "getMyCalendar", "()Ljava/util/Calendar;", "Ljava/util/Calendar;", "startDate", "Landroid/widget/EditText;", "getStartDate", "()Landroid/widget/EditText;", "setStartDate", "(Landroid/widget/EditText;)V", "endDate", "getEndDate", "setEndDate", "startDateString", "", "getStartDateString", "()Ljava/lang/String;", "setStartDateString", "(Ljava/lang/String;)V", "endDateString", "getEndDateString", "setEndDateString", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "dateFilter", "getAttendance", "b", "", "updateLabel", "state", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "ErrorCallBack", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserAttendanceActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack {
    public static final int $stable = 8;
    private ActivityUserAttendanceBinding binding;
    private EditText endDate;
    private NetworkCall networkCall;
    private EditText startDate;
    private final Calendar myCalendar = Calendar.getInstance();
    private String startDateString = "";
    private String endDateString = "";

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        Intrinsics.checkNotNullParameter(jsonstring, "jsonstring");
        Intrinsics.checkNotNullParameter(apitype, "apitype");
        Intrinsics.checkNotNullParameter(typeApi, "typeApi");
    }

    public final NetworkCall getNetworkCall() {
        return this.networkCall;
    }

    public final void setNetworkCall(NetworkCall networkCall) {
        this.networkCall = networkCall;
    }

    public final ActivityUserAttendanceBinding getBinding() {
        return this.binding;
    }

    public final void setBinding(ActivityUserAttendanceBinding activityUserAttendanceBinding) {
        this.binding = activityUserAttendanceBinding;
    }

    public final Calendar getMyCalendar() {
        return this.myCalendar;
    }

    public final EditText getStartDate() {
        return this.startDate;
    }

    public final void setStartDate(EditText editText) {
        this.startDate = editText;
    }

    public final EditText getEndDate() {
        return this.endDate;
    }

    public final void setEndDate(EditText editText) {
        this.endDate = editText;
    }

    public final String getStartDateString() {
        return this.startDateString;
    }

    public final void setStartDateString(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.startDateString = str;
    }

    public final String getEndDateString() {
        return this.endDateString;
    }

    public final void setEndDateString(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.endDateString = str;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUserAttendanceBinding activityUserAttendanceBindingInflate = ActivityUserAttendanceBinding.inflate(getLayoutInflater());
        this.binding = activityUserAttendanceBindingInflate;
        Intrinsics.checkNotNull(activityUserAttendanceBindingInflate);
        setContentView(activityUserAttendanceBindingInflate.getRoot());
        UserAttendanceActivity userAttendanceActivity = this;
        this.networkCall = new NetworkCall(this, userAttendanceActivity);
        ActivityUserAttendanceBinding activityUserAttendanceBinding = this.binding;
        Intrinsics.checkNotNull(activityUserAttendanceBinding);
        activityUserAttendanceBinding.attendanceRecyclerView.setLayoutManager(new LinearLayoutManager(userAttendanceActivity));
        ActivityUserAttendanceBinding activityUserAttendanceBinding2 = this.binding;
        Intrinsics.checkNotNull(activityUserAttendanceBinding2);
        ImageView imageView = activityUserAttendanceBinding2.dateRange;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        NetworkCall networkCall = this.networkCall;
        Intrinsics.checkNotNull(networkCall);
        networkCall.NetworkAPICall(API.GET_USER_ATTENDANCE_REPORT, "", true, false);
        ActivityUserAttendanceBinding activityUserAttendanceBinding3 = this.binding;
        Intrinsics.checkNotNull(activityUserAttendanceBinding3);
        activityUserAttendanceBinding3.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.UserAttendanceActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.finish();
            }
        });
        ActivityUserAttendanceBinding activityUserAttendanceBinding4 = this.binding;
        Intrinsics.checkNotNull(activityUserAttendanceBinding4);
        ImageView imageView2 = activityUserAttendanceBinding4.dateRange;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.UserAttendanceActivity$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.dateFilter();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dateFilter() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this, R.style.BottomSheetDialog);
        bottomSheetDialog.requestWindowFeature(1);
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        bottomSheetDialog.setContentView(R.layout.date_pick_dialog);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ImageView imageView = (ImageView) bottomSheetDialog.findViewById(R.id.cross);
        this.startDate = (EditText) bottomSheetDialog.findViewById(R.id.startDate);
        this.endDate = (EditText) bottomSheetDialog.findViewById(R.id.endDate);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.UserAttendanceActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    bottomSheetDialog.dismiss();
                }
            });
        }
        final DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.appnew.android.Theme.UserAttendanceActivity$$ExternalSyntheticLambda1
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                UserAttendanceActivity.dateFilter$lambda$4(this.f$0, objectRef, datePicker, i, i2, i3);
            }
        };
        EditText editText = this.startDate;
        if (editText != null) {
            editText.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.UserAttendanceActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserAttendanceActivity.dateFilter$lambda$5(objectRef, this, onDateSetListener, view);
                }
            });
        }
        EditText editText2 = this.endDate;
        if (editText2 != null) {
            editText2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.UserAttendanceActivity$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserAttendanceActivity.dateFilter$lambda$6(objectRef, this, onDateSetListener, view);
                }
            });
        }
        Button button = (Button) bottomSheetDialog.findViewById(R.id.submitFilter);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.UserAttendanceActivity$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserAttendanceActivity.dateFilter$lambda$7(this.f$0, bottomSheetDialog, view);
                }
            });
        }
        bottomSheetDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void dateFilter$lambda$4(UserAttendanceActivity userAttendanceActivity, Ref.ObjectRef objectRef, DatePicker datePicker, int i, int i2, int i3) {
        userAttendanceActivity.myCalendar.set(1, i);
        userAttendanceActivity.myCalendar.set(2, i2);
        userAttendanceActivity.myCalendar.set(5, i3);
        String str = (String) objectRef.element;
        if (str != null) {
            userAttendanceActivity.updateLabel(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dateFilter$lambda$5(Ref.ObjectRef objectRef, UserAttendanceActivity userAttendanceActivity, DatePickerDialog.OnDateSetListener onDateSetListener, View view) {
        objectRef.element = "1";
        new DatePickerDialog(userAttendanceActivity, onDateSetListener, userAttendanceActivity.myCalendar.get(1), userAttendanceActivity.myCalendar.get(2), userAttendanceActivity.myCalendar.get(5)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dateFilter$lambda$6(Ref.ObjectRef objectRef, UserAttendanceActivity userAttendanceActivity, DatePickerDialog.OnDateSetListener onDateSetListener, View view) {
        objectRef.element = "2";
        new DatePickerDialog(userAttendanceActivity, onDateSetListener, userAttendanceActivity.myCalendar.get(1), userAttendanceActivity.myCalendar.get(2), userAttendanceActivity.myCalendar.get(5)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dateFilter$lambda$7(UserAttendanceActivity userAttendanceActivity, BottomSheetDialog bottomSheetDialog, View view) {
        UserAttendanceActivity userAttendanceActivity2 = userAttendanceActivity;
        if (Helper.isConnected(userAttendanceActivity2)) {
            EditText editText = userAttendanceActivity.startDate;
            if (!String.valueOf(editText != null ? editText.getText() : null).equals(null)) {
                EditText editText2 = userAttendanceActivity.startDate;
                if (!String.valueOf(editText2 != null ? editText2.getText() : null).equals("")) {
                    EditText editText3 = userAttendanceActivity.endDate;
                    if (!String.valueOf(editText3 != null ? editText3.getText() : null).equals(null)) {
                        EditText editText4 = userAttendanceActivity.endDate;
                        if (!String.valueOf(editText4 != null ? editText4.getText() : null).equals("")) {
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            EditText editText5 = userAttendanceActivity.startDate;
                            Date date = simpleDateFormat.parse(String.valueOf(editText5 != null ? editText5.getText() : null));
                            EditText editText6 = userAttendanceActivity.endDate;
                            if (simpleDateFormat.parse(String.valueOf(editText6 != null ? editText6.getText() : null)).compareTo(date) >= 0) {
                                bottomSheetDialog.dismiss();
                                EditText editText7 = userAttendanceActivity.startDate;
                                userAttendanceActivity.startDateString = String.valueOf(editText7 != null ? editText7.getText() : null);
                                EditText editText8 = userAttendanceActivity.endDate;
                                userAttendanceActivity.endDateString = String.valueOf(editText8 != null ? editText8.getText() : null);
                                userAttendanceActivity.getAttendance(true);
                                return;
                            }
                            Toast.makeText(userAttendanceActivity2, "Please select valid end date", 0).show();
                            return;
                        }
                    }
                    Toast.makeText(userAttendanceActivity2, userAttendanceActivity.getResources().getString(R.string.please_select_end_date), 0).show();
                    return;
                }
            }
            Toast.makeText(userAttendanceActivity2, userAttendanceActivity.getResources().getString(R.string.please_select_start_date), 0).show();
            return;
        }
        Helper.showInternetToast(userAttendanceActivity2);
    }

    private final void getAttendance(boolean b2) {
        NetworkCall networkCall = this.networkCall;
        Intrinsics.checkNotNull(networkCall);
        networkCall.NetworkAPICall(API.GET_USER_ATTENDANCE_REPORT, "", true, false);
    }

    private final void updateLabel(String state) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        if (state.equals("1")) {
            EditText editText = this.startDate;
            if (editText != null) {
                editText.setText(simpleDateFormat.format(this.myCalendar.getTime()));
                return;
            }
            return;
        }
        EditText editText2 = this.endDate;
        if (editText2 != null) {
            editText2.setText(simpleDateFormat.format(this.myCalendar.getTime()));
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        Intrinsics.checkNotNullParameter(apitype, "apitype");
        Intrinsics.checkNotNullParameter(typeApi, "typeApi");
        Intrinsics.checkNotNullParameter(service, "service");
        if (Intrinsics.areEqual(apitype, API.GET_USER_ATTENDANCE_REPORT)) {
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setUser_id(MakeMyExam.getUserId());
            String str = this.startDateString;
            if (str == null) {
                str = "";
            }
            encryptionData.setStart_date(str);
            String str2 = this.endDateString;
            encryptionData.setEnd_date(str2 != null ? str2 : "");
            return service.GET_USER_ATTENDANCE_REPORT(AES.encrypt(new Gson().toJson(encryptionData)));
        }
        if (!Intrinsics.areEqual(apitype, API.GET_USER_ATTENDANCE)) {
            return null;
        }
        EncryptionData encryptionData2 = new EncryptionData();
        encryptionData2.setUser_id(MakeMyExam.getUserId());
        return service.GET_USER_ATTENDANCE(AES.encrypt(new Gson().toJson(encryptionData2)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonstring, "jsonstring");
        Intrinsics.checkNotNullParameter(apitype, "apitype");
        Intrinsics.checkNotNullParameter(typeApi, "typeApi");
        if (!Intrinsics.areEqual(apitype, API.GET_USER_ATTENDANCE_REPORT)) {
            if (Intrinsics.areEqual(apitype, API.GET_USER_ATTENDANCE) && jsonstring.optBoolean("status") && jsonstring.getJSONArray("data").length() > 0) {
                UserAttendanceMain userAttendanceMain = (UserAttendanceMain) new Gson().fromJson(jsonstring.toString(), UserAttendanceMain.class);
                SharedPreference.getInstance().setUserAttendance(userAttendanceMain);
                ActivityUserAttendanceBinding activityUserAttendanceBinding = this.binding;
                Intrinsics.checkNotNull(activityUserAttendanceBinding);
                activityUserAttendanceBinding.attendanceRecyclerView.setAdapter(new UserAttendanceAdapter(this, userAttendanceMain.getData()));
                return;
            }
            return;
        }
        if (jsonstring.optBoolean("status")) {
            if (jsonstring.getJSONArray("data").length() > 0) {
                ActivityUserAttendanceBinding activityUserAttendanceBinding2 = this.binding;
                Intrinsics.checkNotNull(activityUserAttendanceBinding2);
                activityUserAttendanceBinding2.attendanceSheetHead.setVisibility(0);
                UserAttendanceMain userAttendanceMain2 = (UserAttendanceMain) new Gson().fromJson(jsonstring.toString(), UserAttendanceMain.class);
                ActivityUserAttendanceBinding activityUserAttendanceBinding3 = this.binding;
                Intrinsics.checkNotNull(activityUserAttendanceBinding3);
                activityUserAttendanceBinding3.attendanceRecyclerView.setVisibility(0);
                SharedPreference.getInstance().setUserAttendance(userAttendanceMain2);
                ActivityUserAttendanceBinding activityUserAttendanceBinding4 = this.binding;
                Intrinsics.checkNotNull(activityUserAttendanceBinding4);
                activityUserAttendanceBinding4.attendanceRecyclerView.setAdapter(new UserAttendanceTableAdapter(this, userAttendanceMain2.getData()));
                ActivityUserAttendanceBinding activityUserAttendanceBinding5 = this.binding;
                Intrinsics.checkNotNull(activityUserAttendanceBinding5);
                activityUserAttendanceBinding5.noDataFoundRL.setVisibility(8);
                return;
            }
            ActivityUserAttendanceBinding activityUserAttendanceBinding6 = this.binding;
            Intrinsics.checkNotNull(activityUserAttendanceBinding6);
            activityUserAttendanceBinding6.noDataFoundRL.setVisibility(0);
            ActivityUserAttendanceBinding activityUserAttendanceBinding7 = this.binding;
            Intrinsics.checkNotNull(activityUserAttendanceBinding7);
            activityUserAttendanceBinding7.attendanceSheetHead.setVisibility(8);
            return;
        }
        ActivityUserAttendanceBinding activityUserAttendanceBinding8 = this.binding;
        Intrinsics.checkNotNull(activityUserAttendanceBinding8);
        activityUserAttendanceBinding8.attendanceRecyclerView.setVisibility(8);
        ActivityUserAttendanceBinding activityUserAttendanceBinding9 = this.binding;
        Intrinsics.checkNotNull(activityUserAttendanceBinding9);
        activityUserAttendanceBinding9.attendanceSheetHead.setVisibility(8);
        ActivityUserAttendanceBinding activityUserAttendanceBinding10 = this.binding;
        Intrinsics.checkNotNull(activityUserAttendanceBinding10);
        activityUserAttendanceBinding10.noDataFoundRL.setVisibility(0);
    }
}
