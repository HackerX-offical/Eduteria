package com.appnew.android.Zoom.Activity;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.TimeTable.Data;
import com.appnew.android.Model.ZoomModel.CurrentAffairData;
import com.appnew.android.Model.ZoomModel.CurrentAffairDataModel;
import com.appnew.android.Model.ZoomModel.CurrentAffairDetail;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Zoom.Adapter.CurrentAffairAdapter;
import com.appnew.android.Zoom.Adapter.CurrentAffairCategoryAdapter;
import com.appnew.android.Zoom.ItemClickListener;
import com.appnew.android.databinding.ActivityCurrentAffairBinding;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import retrofit2.Call;

/* JADX INFO: compiled from: CurrentAffairActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010Z\u001a\u00020[2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0014J\b\u0010^\u001a\u00020[H\u0002J\u0010\u0010_\u001a\u00020[2\u0006\u0010`\u001a\u00020JH\u0002J\u0010\u0010a\u001a\u00020[2\u0006\u0010b\u001a\u000208H\u0002J\u0006\u0010c\u001a\u00020[J\u0006\u0010d\u001a\u00020[J,\u0010e\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010f2\b\u0010g\u001a\u0004\u0018\u00010J2\b\u0010h\u001a\u0004\u0018\u00010J2\u0006\u0010i\u001a\u00020jH\u0016J,\u0010k\u001a\u00020[2\u0006\u0010l\u001a\u00020m2\b\u0010g\u001a\u0004\u0018\u00010J2\b\u0010h\u001a\u0004\u0018\u00010J2\u0006\u0010n\u001a\u000208H\u0016J&\u0010o\u001a\u00020[2\b\u0010l\u001a\u0004\u0018\u00010J2\b\u0010g\u001a\u0004\u0018\u00010J2\b\u0010h\u001a\u0004\u0018\u00010JH\u0016J\u0016\u0010p\u001a\u00020[2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020 0\u0019H\u0002J\u0016\u0010q\u001a\u00020[2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u0010\u0010r\u001a\u00020[2\u0006\u0010R\u001a\u00020JH\u0016J\u0016\u0010s\u001a\u00020[2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020 0tH\u0016J\u001e\u0010u\u001a\u00020[2\f\u0010v\u001a\b\u0012\u0004\u0012\u00020w0\u00192\u0006\u0010R\u001a\u000206H\u0016J\u0010\u0010S\u001a\u00020[2\u0006\u0010x\u001a\u000206H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010*\u001a\n ,*\u0004\u0018\u00010+0+¢\u0006\n\n\u0002\u0010/\u001a\u0004\b-\u0010.R\u001c\u00100\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u000e\u00105\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010;\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010@\u001a\u0004\u0018\u00010AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001c\u0010F\u001a\u0004\u0018\u00010AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010C\"\u0004\bH\u0010ER\u001a\u0010I\u001a\u00020JX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001a\u0010O\u001a\u00020JX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010L\"\u0004\bQ\u0010NR\u001a\u0010R\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001a\u0010W\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010=\"\u0004\bY\u0010?¨\u0006y"}, d2 = {"Lcom/appnew/android/Zoom/Activity/CurrentAffairActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "Lcom/appnew/android/Zoom/ItemClickListener;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/ActivityCurrentAffairBinding;", "getBinding", "()Lcom/appnew/android/databinding/ActivityCurrentAffairBinding;", "setBinding", "(Lcom/appnew/android/databinding/ActivityCurrentAffairBinding;)V", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "currentAffairDetail", "Lcom/appnew/android/Model/ZoomModel/CurrentAffairDetail;", "getCurrentAffairDetail", "()Lcom/appnew/android/Model/ZoomModel/CurrentAffairDetail;", "setCurrentAffairDetail", "(Lcom/appnew/android/Model/ZoomModel/CurrentAffairDetail;)V", "currentAffairArray", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/ZoomModel/CurrentAffairData;", "getCurrentAffairArray", "()Ljava/util/ArrayList;", "setCurrentAffairArray", "(Ljava/util/ArrayList;)V", "allCurrentAffairDataList", "Lcom/appnew/android/Model/ZoomModel/CurrentAffairDataModel;", "getAllCurrentAffairDataList", "setAllCurrentAffairDataList", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "layoutManager1", "customAdapter", "Lcom/appnew/android/Zoom/Adapter/CurrentAffairCategoryAdapter;", "currentAffairAdapter", "Lcom/appnew/android/Zoom/Adapter/CurrentAffairAdapter;", "myCalendar", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "getMyCalendar", "()Ljava/util/Calendar;", "Ljava/util/Calendar;", "itemClickListener", "getItemClickListener", "()Lcom/appnew/android/Zoom/ItemClickListener;", "setItemClickListener", "(Lcom/appnew/android/Zoom/ItemClickListener;)V", "mPage", "", "loading", "", "isPaginationAvailable", "pageItemLimit", "status", "getStatus", "()Z", "setStatus", "(Z)V", "startDate", "Landroid/widget/EditText;", "getStartDate", "()Landroid/widget/EditText;", "setStartDate", "(Landroid/widget/EditText;)V", "endDate", "getEndDate", "setEndDate", "startDateString", "", "getStartDateString", "()Ljava/lang/String;", "setStartDateString", "(Ljava/lang/String;)V", "endDateString", "getEndDateString", "setEndDateString", Const.POSITION, "getPosition", "()I", "setPosition", "(I)V", "filterClicked", "getFilterClicked", "setFilterClicked", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "showdialoguser", "updateLabel", "state", "getCurrentAffair", "showProgress", "initialState", "refresh_data", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "ErrorCallBack", "setAdapterListing", "setAdapter", "onClick", "onClickCurrentAffair", "", "onClickTimeTableDate", "data", "Lcom/appnew/android/Model/TimeTable/Data;", Constants.INAPP_POSITION, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CurrentAffairActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack, ItemClickListener {
    public static final int $stable = 8;
    public ActivityCurrentAffairBinding binding;
    private CurrentAffairAdapter currentAffairAdapter;
    private CurrentAffairDetail currentAffairDetail;
    private CurrentAffairCategoryAdapter customAdapter;
    private EditText endDate;
    private boolean filterClicked;
    private ItemClickListener itemClickListener;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.LayoutManager layoutManager1;
    private boolean loading;
    private NetworkCall networkCall;
    private int position;
    private EditText startDate;
    private boolean status;
    private ArrayList<CurrentAffairData> currentAffairArray = new ArrayList<>();
    private ArrayList<CurrentAffairDataModel> allCurrentAffairDataList = new ArrayList<>();
    private final Calendar myCalendar = Calendar.getInstance();
    private int mPage = 1;
    private boolean isPaginationAvailable = true;
    private int pageItemLimit = 20;
    private String startDateString = "";
    private String endDateString = "";

    @Override // com.appnew.android.Zoom.ItemClickListener
    public void onClick(String position) {
        Intrinsics.checkNotNullParameter(position, "position");
    }

    public final ActivityCurrentAffairBinding getBinding() {
        ActivityCurrentAffairBinding activityCurrentAffairBinding = this.binding;
        if (activityCurrentAffairBinding != null) {
            return activityCurrentAffairBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(ActivityCurrentAffairBinding activityCurrentAffairBinding) {
        Intrinsics.checkNotNullParameter(activityCurrentAffairBinding, "<set-?>");
        this.binding = activityCurrentAffairBinding;
    }

    public final NetworkCall getNetworkCall() {
        return this.networkCall;
    }

    public final void setNetworkCall(NetworkCall networkCall) {
        this.networkCall = networkCall;
    }

    public final CurrentAffairDetail getCurrentAffairDetail() {
        return this.currentAffairDetail;
    }

    public final void setCurrentAffairDetail(CurrentAffairDetail currentAffairDetail) {
        this.currentAffairDetail = currentAffairDetail;
    }

    public final ArrayList<CurrentAffairData> getCurrentAffairArray() {
        return this.currentAffairArray;
    }

    public final void setCurrentAffairArray(ArrayList<CurrentAffairData> arrayList) {
        this.currentAffairArray = arrayList;
    }

    public final ArrayList<CurrentAffairDataModel> getAllCurrentAffairDataList() {
        return this.allCurrentAffairDataList;
    }

    public final void setAllCurrentAffairDataList(ArrayList<CurrentAffairDataModel> arrayList) {
        this.allCurrentAffairDataList = arrayList;
    }

    public final Calendar getMyCalendar() {
        return this.myCalendar;
    }

    public final ItemClickListener getItemClickListener() {
        return this.itemClickListener;
    }

    public final void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public final boolean getStatus() {
        return this.status;
    }

    public final void setStatus(boolean z) {
        this.status = z;
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

    public final int getPosition() {
        return this.position;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    public final boolean getFilterClicked() {
        return this.filterClicked;
    }

    public final void setFilterClicked(boolean z) {
        this.filterClicked = z;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CurrentAffairActivity currentAffairActivity = this;
        Helper.setSystemBarLight(currentAffairActivity);
        setBinding(ActivityCurrentAffairBinding.inflate(getLayoutInflater()));
        setContentView(getBinding().getRoot());
        Helper.setSystemBarLight(currentAffairActivity);
        Helper.enableScreenShot(currentAffairActivity);
        if (Build.VERSION.SDK_INT == 36) {
            Window window = getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
            ConstraintLayout root = getBinding().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            Toolbar mainToolbar = getBinding().mainToolbar;
            Intrinsics.checkNotNullExpressionValue(mainToolbar, "mainToolbar");
            EdgeToEdgeHelperOld.applyHeaderWithToolbar(this, window, root, mainToolbar);
        }
        if (getIntent() != null) {
            getBinding().toolbarTitleTV.setText(getIntent().getStringExtra("title_key"));
        }
        CurrentAffairActivity currentAffairActivity2 = this;
        this.networkCall = new NetworkCall(this, currentAffairActivity2);
        getBinding().currentAffairImageBack.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Activity.CurrentAffairActivity$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CurrentAffairActivity.onCreate$lambda$0(this.f$0);
            }
        }));
        getBinding().dateFilter.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Activity.CurrentAffairActivity$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CurrentAffairActivity.onCreate$lambda$1(this.f$0);
            }
        }));
        this.layoutManager = new LinearLayoutManager(currentAffairActivity2, 0, false);
        getBinding().currentAffairCategoryRecycler.setLayoutManager(this.layoutManager);
        this.layoutManager1 = new LinearLayoutManager(currentAffairActivity2, 1, false);
        getBinding().currentAffairListRecycler.setLayoutManager(this.layoutManager1);
        ArrayList<CurrentAffairData> arrayList = this.currentAffairArray;
        if (arrayList != null && arrayList.isEmpty()) {
            getCurrentAffair(true);
        }
        ArrayList<CurrentAffairDataModel> arrayList2 = this.allCurrentAffairDataList;
        this.currentAffairAdapter = arrayList2 != null ? new CurrentAffairAdapter(arrayList2, currentAffairActivity2) : null;
        getBinding().currentAffairListRecycler.setAdapter(this.currentAffairAdapter);
        getBinding().currentAffairListRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.appnew.android.Zoom.Activity.CurrentAffairActivity.onCreate.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, dx, dy);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
                if (linearLayoutManager == null || dy <= 0) {
                    return;
                }
                int childCount = linearLayoutManager.getChildCount();
                int itemCount = linearLayoutManager.getItemCount();
                int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                ActivityCurrentAffairBinding binding = CurrentAffairActivity.this.getBinding();
                CurrentAffairActivity currentAffairActivity3 = CurrentAffairActivity.this;
                if (binding.paginationLoader == null || binding.paginationLoader.getVisibility() == 0 || !currentAffairActivity3.loading || !currentAffairActivity3.isPaginationAvailable || childCount + iFindFirstVisibleItemPosition < itemCount) {
                    return;
                }
                binding.paginationLoader.setVisibility(0);
                currentAffairActivity3.mPage++;
                currentAffairActivity3.setStatus(true);
                currentAffairActivity3.getCurrentAffair(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(CurrentAffairActivity currentAffairActivity) {
        currentAffairActivity.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$1(CurrentAffairActivity currentAffairActivity) {
        currentAffairActivity.showdialoguser();
        return Unit.INSTANCE;
    }

    private final void showdialoguser() {
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
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Activity.CurrentAffairActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    bottomSheetDialog.dismiss();
                }
            });
        }
        final DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.appnew.android.Zoom.Activity.CurrentAffairActivity$$ExternalSyntheticLambda1
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                CurrentAffairActivity.showdialoguser$lambda$5(this.f$0, objectRef, datePicker, i, i2, i3);
            }
        };
        EditText editText = this.startDate;
        if (editText != null) {
            editText.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Activity.CurrentAffairActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CurrentAffairActivity.showdialoguser$lambda$6(objectRef, this, onDateSetListener, view);
                }
            });
        }
        EditText editText2 = this.endDate;
        if (editText2 != null) {
            editText2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Activity.CurrentAffairActivity$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CurrentAffairActivity.showdialoguser$lambda$7(objectRef, this, onDateSetListener, view);
                }
            });
        }
        Button button = (Button) bottomSheetDialog.findViewById(R.id.submitFilter);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Activity.CurrentAffairActivity$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CurrentAffairActivity.showdialoguser$lambda$8(this.f$0, bottomSheetDialog, view);
                }
            });
        }
        bottomSheetDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void showdialoguser$lambda$5(CurrentAffairActivity currentAffairActivity, Ref.ObjectRef objectRef, DatePicker datePicker, int i, int i2, int i3) {
        currentAffairActivity.myCalendar.set(1, i);
        currentAffairActivity.myCalendar.set(2, i2);
        currentAffairActivity.myCalendar.set(5, i3);
        String str = (String) objectRef.element;
        if (str != null) {
            currentAffairActivity.updateLabel(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showdialoguser$lambda$6(Ref.ObjectRef objectRef, CurrentAffairActivity currentAffairActivity, DatePickerDialog.OnDateSetListener onDateSetListener, View view) {
        objectRef.element = "1";
        new DatePickerDialog(currentAffairActivity, onDateSetListener, currentAffairActivity.myCalendar.get(1), currentAffairActivity.myCalendar.get(2), currentAffairActivity.myCalendar.get(5)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showdialoguser$lambda$7(Ref.ObjectRef objectRef, CurrentAffairActivity currentAffairActivity, DatePickerDialog.OnDateSetListener onDateSetListener, View view) {
        objectRef.element = "2";
        new DatePickerDialog(currentAffairActivity, onDateSetListener, currentAffairActivity.myCalendar.get(1), currentAffairActivity.myCalendar.get(2), currentAffairActivity.myCalendar.get(5)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showdialoguser$lambda$8(CurrentAffairActivity currentAffairActivity, BottomSheetDialog bottomSheetDialog, View view) {
        CurrentAffairActivity currentAffairActivity2 = currentAffairActivity;
        if (Helper.isConnected(currentAffairActivity2)) {
            EditText editText = currentAffairActivity.startDate;
            if (!String.valueOf(editText != null ? editText.getText() : null).equals(null)) {
                EditText editText2 = currentAffairActivity.startDate;
                if (!String.valueOf(editText2 != null ? editText2.getText() : null).equals("")) {
                    EditText editText3 = currentAffairActivity.endDate;
                    if (!String.valueOf(editText3 != null ? editText3.getText() : null).equals(null)) {
                        EditText editText4 = currentAffairActivity.endDate;
                        if (!String.valueOf(editText4 != null ? editText4.getText() : null).equals("")) {
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                            EditText editText5 = currentAffairActivity.startDate;
                            Date date = simpleDateFormat.parse(String.valueOf(editText5 != null ? editText5.getText() : null));
                            EditText editText6 = currentAffairActivity.endDate;
                            if (simpleDateFormat.parse(String.valueOf(editText6 != null ? editText6.getText() : null)).compareTo(date) >= 0) {
                                bottomSheetDialog.dismiss();
                                EditText editText7 = currentAffairActivity.startDate;
                                currentAffairActivity.startDateString = String.valueOf(editText7 != null ? editText7.getText() : null);
                                EditText editText8 = currentAffairActivity.endDate;
                                currentAffairActivity.endDateString = String.valueOf(editText8 != null ? editText8.getText() : null);
                                currentAffairActivity.filterClicked = true;
                                currentAffairActivity.getCurrentAffair(true);
                                return;
                            }
                            Toast.makeText(currentAffairActivity2, "Please select valid end date", 0).show();
                            return;
                        }
                    }
                    Toast.makeText(currentAffairActivity2, currentAffairActivity.getResources().getString(R.string.please_select_date), 0).show();
                    return;
                }
            }
            Toast.makeText(currentAffairActivity2, currentAffairActivity.getResources().getString(R.string.please_select_date), 0).show();
            return;
        }
        Helper.showInternetToast(currentAffairActivity2);
    }

    private final void updateLabel(String state) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void getCurrentAffair(boolean showProgress) {
        NetworkCall networkCall = this.networkCall;
        if (networkCall != null) {
            networkCall.NetworkAPICall(API.API_GET_CURRENT_AFFAIR, "", showProgress, false);
        }
    }

    public final void initialState() {
        this.mPage = 1;
        this.loading = true;
    }

    public final void refresh_data() {
        initialState();
        getCurrentAffair(true);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        Intrinsics.checkNotNullParameter(service, "service");
        if (!Intrinsics.areEqual(apitype, API.API_GET_CURRENT_AFFAIR)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setCategory_id("");
        String str = this.startDateString;
        if (str == null) {
            str = "";
        }
        encryptionData.setStart_date(str);
        String str2 = this.endDateString;
        encryptionData.setEnd_date(str2 != null ? str2 : "");
        encryptionData.setPage(String.valueOf(this.mPage));
        return service.getCurrentAffair(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00bc  */
    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void SuccessCallBack(org.json.JSONObject r4, java.lang.String r5, java.lang.String r6, boolean r7) {
        /*
            Method dump skipped, instruction units count: 606
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Zoom.Activity.CurrentAffairActivity.SuccessCallBack(org.json.JSONObject, java.lang.String, java.lang.String, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SuccessCallBack$lambda$13(CurrentAffairActivity currentAffairActivity, DiffUtil.DiffResult diffResult) {
        CurrentAffairAdapter currentAffairAdapter = currentAffairActivity.currentAffairAdapter;
        if (currentAffairAdapter == null || diffResult == null) {
            return;
        }
        diffResult.dispatchUpdatesTo(currentAffairAdapter);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        if (Intrinsics.areEqual(apitype, API.API_GET_USER_SUPPORT_CATEGORY)) {
            ActivityCurrentAffairBinding binding = getBinding();
            if (binding.paginationLoader == null || !binding.paginationLoader.isShown()) {
                return;
            }
            binding.paginationLoader.setVisibility(8);
        }
    }

    private final void setAdapterListing(ArrayList<CurrentAffairDataModel> currentAffairArray) {
        this.currentAffairAdapter = new CurrentAffairAdapter(currentAffairArray, this);
        getBinding().currentAffairListRecycler.setAdapter(this.currentAffairAdapter);
    }

    private final void setAdapter(ArrayList<CurrentAffairData> currentAffairArray) {
        this.customAdapter = new CurrentAffairCategoryAdapter(currentAffairArray, this);
        getBinding().currentAffairCategoryRecycler.setAdapter(this.customAdapter);
        if (currentAffairArray.get(0).getData().size() == 0) {
            getBinding().currentAffairListRecycler.setVisibility(8);
            getBinding().noDataFoundRL.setVisibility(0);
        } else {
            getBinding().currentAffairListRecycler.setVisibility(0);
            getBinding().noDataFoundRL.setVisibility(8);
        }
        ArrayList<CurrentAffairDataModel> data = currentAffairArray.get(0).getData();
        Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
        setAdapterListing(data);
    }

    @Override // com.appnew.android.Zoom.ItemClickListener
    public void onClickCurrentAffair(List<CurrentAffairDataModel> position) {
        Intrinsics.checkNotNullParameter(position, "position");
        if (position.size() == 0) {
            getBinding().currentAffairListRecycler.setVisibility(8);
            getBinding().noDataFoundRL.setVisibility(0);
        } else {
            getBinding().currentAffairListRecycler.setVisibility(0);
            getBinding().noDataFoundRL.setVisibility(8);
        }
        setAdapterListing((ArrayList) position);
    }

    @Override // com.appnew.android.Zoom.ItemClickListener
    public void onClickTimeTableDate(ArrayList<Data> data, int position) {
        Intrinsics.checkNotNullParameter(data, "data");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.appnew.android.Zoom.ItemClickListener
    public void getPosition(int pos) {
        this.position = this.position;
    }
}
