package com.appnew.android.CourseChat;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.CourseChat.CoursesListActivity;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Model.ZoomModel.CurrentAffairData;
import com.appnew.android.Model.ZoomModel.CurrentAffairDetail;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Zoom.Activity.GroupChatActivityFirebase;
import com.appnew.android.databinding.ActivityCoursesListBinding;
import com.appnew.android.home.model.MyCourse;
import com.bumptech.glide.Glide;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Message;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: CoursesListActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001EB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105H\u0014J.\u00106\u001a\f\u0012\u0006\u0012\u0004\u0018\u000108\u0018\u0001072\b\u00109\u001a\u0004\u0018\u0001082\b\u0010:\u001a\u0004\u0018\u0001082\u0006\u0010;\u001a\u00020<H\u0016J.\u0010=\u001a\u0002032\b\u0010>\u001a\u0004\u0018\u00010?2\b\u00109\u001a\u0004\u0018\u0001082\b\u0010:\u001a\u0004\u0018\u0001082\u0006\u0010@\u001a\u00020AH\u0016J&\u0010B\u001a\u0002032\b\u0010>\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u0001082\b\u0010:\u001a\u0004\u0018\u000108H\u0016J \u0010C\u001a\u0002032\u0016\u0010D\u001a\u0012\u0012\u0004\u0012\u00020.0\u001ej\b\u0012\u0004\u0012\u00020.` H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR.\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001ej\n\u0012\u0004\u0012\u00020\u001f\u0018\u0001` X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\"\"\u0004\b0\u0010$R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020.0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/appnew/android/CourseChat/CoursesListActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/ActivityCoursesListBinding;", "getBinding", "()Lcom/appnew/android/databinding/ActivityCoursesListBinding;", "setBinding", "(Lcom/appnew/android/databinding/ActivityCoursesListBinding;)V", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "paginationLoader", "Landroid/widget/ProgressBar;", "getPaginationLoader", "()Landroid/widget/ProgressBar;", "setPaginationLoader", "(Landroid/widget/ProgressBar;)V", "currentAffairDetail", "Lcom/appnew/android/Model/ZoomModel/CurrentAffairDetail;", "getCurrentAffairDetail", "()Lcom/appnew/android/Model/ZoomModel/CurrentAffairDetail;", "setCurrentAffairDetail", "(Lcom/appnew/android/Model/ZoomModel/CurrentAffairDetail;)V", "currentAffairArray", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/ZoomModel/CurrentAffairData;", "Lkotlin/collections/ArrayList;", "getCurrentAffairArray", "()Ljava/util/ArrayList;", "setCurrentAffairArray", "(Ljava/util/ArrayList;)V", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "coursesListAdapter", "Lcom/appnew/android/CourseChat/CoursesListActivity$CourseSelectionAdapter;", "myCourse", "Lcom/appnew/android/home/model/MyCourse;", "no_data_found_RL", "Landroid/widget/RelativeLayout;", Const.COURSE_LIST, "Lcom/appnew/android/Model/Courselist;", "getCourse_list", "setCourse_list", "noteDataArrayList", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getAPIB", "Lretrofit2/Call;", "", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "", "ErrorCallBack", "setAdapter", Const.COURSESLIST, "CourseSelectionAdapter", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CoursesListActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack {
    public static final int $stable = 8;
    public ActivityCoursesListBinding binding;
    private CourseSelectionAdapter coursesListAdapter;
    private CurrentAffairDetail currentAffairDetail;
    private RecyclerView.LayoutManager layoutManager;
    private MyCourse myCourse;
    private NetworkCall networkCall;
    private RelativeLayout no_data_found_RL;
    private ProgressBar paginationLoader;
    private ArrayList<CurrentAffairData> currentAffairArray = new ArrayList<>();
    private ArrayList<Courselist> course_list = new ArrayList<>();
    private final ArrayList<Courselist> noteDataArrayList = new ArrayList<>();

    public final ActivityCoursesListBinding getBinding() {
        ActivityCoursesListBinding activityCoursesListBinding = this.binding;
        if (activityCoursesListBinding != null) {
            return activityCoursesListBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(ActivityCoursesListBinding activityCoursesListBinding) {
        Intrinsics.checkNotNullParameter(activityCoursesListBinding, "<set-?>");
        this.binding = activityCoursesListBinding;
    }

    public final NetworkCall getNetworkCall() {
        return this.networkCall;
    }

    public final void setNetworkCall(NetworkCall networkCall) {
        this.networkCall = networkCall;
    }

    public final ProgressBar getPaginationLoader() {
        return this.paginationLoader;
    }

    public final void setPaginationLoader(ProgressBar progressBar) {
        this.paginationLoader = progressBar;
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

    public final ArrayList<Courselist> getCourse_list() {
        return this.course_list;
    }

    public final void setCourse_list(ArrayList<Courselist> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.course_list = arrayList;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBinding(ActivityCoursesListBinding.inflate(getLayoutInflater()));
        setContentView(getBinding().getRoot());
        if (Build.VERSION.SDK_INT == 36) {
            Window window = getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
            RelativeLayout root = getBinding().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            Toolbar mainToolbar = getBinding().mainToolbar;
            Intrinsics.checkNotNullExpressionValue(mainToolbar, "mainToolbar");
            EdgeToEdgeHelperOld.applyHeaderWithToolbar(this, window, root, mainToolbar);
        }
        this.no_data_found_RL = (RelativeLayout) findViewById(R.id.no_data_found_RL);
        CoursesListActivity coursesListActivity = this;
        this.networkCall = new NetworkCall(this, coursesListActivity);
        this.layoutManager = new LinearLayoutManager(coursesListActivity);
        getBinding().recyclerCourseList.setLayoutManager(this.layoutManager);
        getBinding().imageBack.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.CourseChat.CoursesListActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onBackPressed();
            }
        });
        NetworkCall networkCall = this.networkCall;
        if (networkCall != null) {
            networkCall.NetworkAPICall(API.get_my_courses, "", false, false);
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        Intrinsics.checkNotNullParameter(service, "service");
        if (!Intrinsics.areEqual(apitype, API.get_my_courses)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setIs_paid("1");
        return service.get_my_courses(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) {
        String string;
        if (Intrinsics.areEqual(apitype, API.get_my_courses)) {
            try {
                Intrinsics.checkNotNull(jsonstring);
                if (Intrinsics.areEqual(jsonstring.optString("status"), "true")) {
                    MyCourse myCourse = (MyCourse) new Gson().fromJson(jsonstring.toString(), MyCourse.class);
                    this.myCourse = myCourse;
                    Intrinsics.checkNotNull(myCourse);
                    if (myCourse.getData().size() > 0) {
                        ArrayList<Courselist> arrayList = new ArrayList<>();
                        this.course_list = arrayList;
                        MyCourse myCourse2 = this.myCourse;
                        Intrinsics.checkNotNull(myCourse2);
                        arrayList.addAll(myCourse2.getData());
                        if (this.course_list.size() > 0) {
                            RelativeLayout relativeLayout = this.no_data_found_RL;
                            if (relativeLayout != null) {
                                relativeLayout.setVisibility(8);
                            }
                            getBinding().recyclerCourseList.setVisibility(0);
                            setAdapter(this.course_list);
                            return;
                        }
                        RelativeLayout relativeLayout2 = this.no_data_found_RL;
                        if (relativeLayout2 != null) {
                            relativeLayout2.setVisibility(0);
                        }
                        getBinding().recyclerCourseList.setVisibility(8);
                        return;
                    }
                    return;
                }
                RelativeLayout relativeLayout3 = this.no_data_found_RL;
                if (relativeLayout3 != null) {
                    relativeLayout3.setVisibility(0);
                }
                getBinding().recyclerCourseList.setVisibility(8);
                CoursesListActivity coursesListActivity = this;
                if (jsonstring.has("auth_code")) {
                    string = jsonstring.getString("auth_code");
                } else {
                    string = "";
                }
                RetrofitResponse.GetApiData(coursesListActivity, string, jsonstring.getString("message"), false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    private final void setAdapter(ArrayList<Courselist> courseList) {
        this.coursesListAdapter = new CourseSelectionAdapter(courseList, this);
        getBinding().recyclerCourseList.setAdapter(this.coursesListAdapter);
    }

    /* JADX INFO: compiled from: CoursesListActivity.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001dB'\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001c\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u001c\u0010\u0019\u001a\u00020\u001a2\n\u0010\u001b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0017H\u0016R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/appnew/android/CourseChat/CoursesListActivity$CourseSelectionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/CourseChat/CoursesListActivity$CourseSelectionAdapter$SubjectItemHolder;", "myNotesArrayList", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/Courselist;", "Lkotlin/collections/ArrayList;", "context", "Landroid/content/Context;", "<init>", "(Ljava/util/ArrayList;Landroid/content/Context;)V", "getMyNotesArrayList", "()Ljava/util/ArrayList;", "setMyNotesArrayList", "(Ljava/util/ArrayList;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", Const.POSITION, "SubjectItemHolder", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CourseSelectionAdapter extends RecyclerView.Adapter<SubjectItemHolder> {
        public static final int $stable = 8;
        private Context context;
        private ArrayList<Courselist> myNotesArrayList;

        public final Context getContext() {
            return this.context;
        }

        public final ArrayList<Courselist> getMyNotesArrayList() {
            return this.myNotesArrayList;
        }

        public final void setContext(Context context) {
            Intrinsics.checkNotNullParameter(context, "<set-?>");
            this.context = context;
        }

        public final void setMyNotesArrayList(ArrayList<Courselist> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.myNotesArrayList = arrayList;
        }

        public CourseSelectionAdapter(ArrayList<Courselist> myNotesArrayList, Context context) {
            Intrinsics.checkNotNullParameter(myNotesArrayList, "myNotesArrayList");
            Intrinsics.checkNotNullParameter(context, "context");
            this.myNotesArrayList = myNotesArrayList;
            this.context = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public SubjectItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.purchase_history_adapter, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new SubjectItemHolder(this, viewInflate);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.myNotesArrayList.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(SubjectItemHolder holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.setSingleFAQData(this.myNotesArrayList, position);
        }

        /* JADX INFO: compiled from: CoursesListActivity.kt */
        @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\u000e\u001a\u00020\u000f2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/appnew/android/CourseChat/CoursesListActivity$CourseSelectionAdapter$SubjectItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/appnew/android/CourseChat/CoursesListActivity$CourseSelectionAdapter;Landroid/view/View;)V", "imageCourse", "Landroid/widget/ImageView;", "forwardIVNew", "txtTitle", "Landroid/widget/TextView;", "emiTxt", "cvrNewUi", "Landroidx/cardview/widget/CardView;", "setSingleFAQData", "", "courseDetails", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/Courselist;", "Lkotlin/collections/ArrayList;", Constants.INAPP_POSITION, "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public final class SubjectItemHolder extends RecyclerView.ViewHolder {
            private final CardView cvrNewUi;
            private final TextView emiTxt;
            private final ImageView forwardIVNew;
            private final ImageView imageCourse;
            final /* synthetic */ CourseSelectionAdapter this$0;
            private final TextView txtTitle;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SubjectItemHolder(CourseSelectionAdapter courseSelectionAdapter, View itemView) {
                super(itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.this$0 = courseSelectionAdapter;
                this.imageCourse = (ImageView) itemView.findViewById(R.id.imageCourse);
                this.forwardIVNew = (ImageView) itemView.findViewById(R.id.forwardIVNew);
                this.txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
                this.emiTxt = (TextView) itemView.findViewById(R.id.emiTxt);
                this.cvrNewUi = (CardView) itemView.findViewById(R.id.cvrNewUi);
            }

            public final void setSingleFAQData(ArrayList<Courselist> courseDetails, int pos) {
                Intrinsics.checkNotNullParameter(courseDetails, "courseDetails");
                Courselist courselist = courseDetails.get(pos);
                Intrinsics.checkNotNullExpressionValue(courselist, "get(...)");
                final Courselist courselist2 = courselist;
                this.emiTxt.setVisibility(8);
                this.forwardIVNew.setVisibility(8);
                this.txtTitle.setText((pos + 1) + ". " + courselist2.getTitle());
                Glide.with(this.this$0.getContext()).load(courselist2.getDescHeaderImage()).placeholder(R.mipmap.placeholder_course).into(this.imageCourse);
                CardView cardView = this.cvrNewUi;
                final CourseSelectionAdapter courseSelectionAdapter = this.this$0;
                cardView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.CourseChat.CoursesListActivity$CourseSelectionAdapter$SubjectItemHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CoursesListActivity.CourseSelectionAdapter.SubjectItemHolder.setSingleFAQData$lambda$0(courseSelectionAdapter, courselist2, view);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void setSingleFAQData$lambda$0(CourseSelectionAdapter courseSelectionAdapter, Courselist courselist, View view) {
                Intent intent = new Intent(courseSelectionAdapter.getContext(), (Class<?>) GroupChatActivityFirebase.class);
                intent.putExtra("Chat_type", "0");
                intent.putExtra("Chat_node", courselist.getId() + "_166");
                courseSelectionAdapter.getContext().startActivity(intent);
            }
        }
    }
}
