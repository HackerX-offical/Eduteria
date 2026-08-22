package com.appnew.android.Zoom.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.ExtensionFunctions.XtensionFunctionKt;
import com.appnew.android.Model.ZoomModel.CourseReviewDetail;
import com.appnew.android.Model.ZoomModel.ReviewData;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Zoom.Adapter.ReviewListAdapter;
import com.appnew.android.databinding.ActivityRattingBinding;
import com.eduteria.app.app.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.Gson;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: RattingActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H\u0014J\b\u00107\u001a\u000204H\u0002J\u0010\u00108\u001a\u0002042\u0006\u00109\u001a\u00020:H\u0002J\u0010\u0010;\u001a\u0002042\u0006\u00109\u001a\u00020:H\u0002J*\u0010<\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010=2\u0006\u0010>\u001a\u00020\u00112\u0006\u0010?\u001a\u00020\u00112\u0006\u0010@\u001a\u00020AH\u0016J,\u0010B\u001a\u0002042\u0006\u0010C\u001a\u00020D2\b\u0010>\u001a\u0004\u0018\u00010\u00112\b\u0010?\u001a\u0004\u0018\u00010\u00112\u0006\u0010E\u001a\u00020:H\u0016J&\u0010F\u001a\u0002042\b\u0010C\u001a\u0004\u0018\u00010\u00112\b\u0010>\u001a\u0004\u0018\u00010\u00112\b\u0010?\u001a\u0004\u0018\u00010\u0011H\u0016J \u0010G\u001a\u0002042\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR.\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020 \u0018\u00010\u001fj\n\u0012\u0004\u0012\u00020 \u0018\u0001`!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010.\"\u0004\b2\u00100¨\u0006H"}, d2 = {"Lcom/appnew/android/Zoom/Activity/RattingActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/ActivityRattingBinding;", "getBinding", "()Lcom/appnew/android/databinding/ActivityRattingBinding;", "setBinding", "(Lcom/appnew/android/databinding/ActivityRattingBinding;)V", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "reviewListAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/Zoom/Adapter/ReviewListAdapter$ViewHolder;", "courseId", "", "paginationLoader", "Landroid/widget/ProgressBar;", "getPaginationLoader", "()Landroid/widget/ProgressBar;", "setPaginationLoader", "(Landroid/widget/ProgressBar;)V", "courseReviewDetail", "Lcom/appnew/android/Model/ZoomModel/CourseReviewDetail;", "getCourseReviewDetail", "()Lcom/appnew/android/Model/ZoomModel/CourseReviewDetail;", "setCourseReviewDetail", "(Lcom/appnew/android/Model/ZoomModel/CourseReviewDetail;)V", "courseReviewArray", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/ZoomModel/ReviewData;", "Lkotlin/collections/ArrayList;", "getCourseReviewArray", "()Ljava/util/ArrayList;", "setCourseReviewArray", "(Ljava/util/ArrayList;)V", "ratingComment", "Landroid/widget/EditText;", "getRatingComment", "()Landroid/widget/EditText;", "setRatingComment", "(Landroid/widget/EditText;)V", Const.RATINGS, "getRating", "()Ljava/lang/String;", "setRating", "(Ljava/lang/String;)V", "is_purchased", "set_purchased", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "showdialoguser", "sendRating", "showProgress", "", "getCourseReviewList", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "ErrorCallBack", "setAdapter", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RattingActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack {
    public static final int $stable = 8;
    public ActivityRattingBinding binding;
    private String courseId;
    private ArrayList<ReviewData> courseReviewArray;
    private CourseReviewDetail courseReviewDetail;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar paginationLoader;
    private EditText ratingComment;
    private RecyclerView.Adapter<ReviewListAdapter.ViewHolder> reviewListAdapter;
    private String rating = "";
    private String is_purchased = "";

    public final ActivityRattingBinding getBinding() {
        ActivityRattingBinding activityRattingBinding = this.binding;
        if (activityRattingBinding != null) {
            return activityRattingBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(ActivityRattingBinding activityRattingBinding) {
        Intrinsics.checkNotNullParameter(activityRattingBinding, "<set-?>");
        this.binding = activityRattingBinding;
    }

    public final ProgressBar getPaginationLoader() {
        return this.paginationLoader;
    }

    public final void setPaginationLoader(ProgressBar progressBar) {
        this.paginationLoader = progressBar;
    }

    public final CourseReviewDetail getCourseReviewDetail() {
        return this.courseReviewDetail;
    }

    public final void setCourseReviewDetail(CourseReviewDetail courseReviewDetail) {
        this.courseReviewDetail = courseReviewDetail;
    }

    public final ArrayList<ReviewData> getCourseReviewArray() {
        return this.courseReviewArray;
    }

    public final void setCourseReviewArray(ArrayList<ReviewData> arrayList) {
        this.courseReviewArray = arrayList;
    }

    public final EditText getRatingComment() {
        return this.ratingComment;
    }

    public final void setRatingComment(EditText editText) {
        this.ratingComment = editText;
    }

    public final String getRating() {
        return this.rating;
    }

    public final void setRating(String str) {
        this.rating = str;
    }

    /* JADX INFO: renamed from: is_purchased, reason: from getter */
    public final String getIs_purchased() {
        return this.is_purchased;
    }

    public final void set_purchased(String str) {
        this.is_purchased = str;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RattingActivity rattingActivity = this;
        Helper.setSystemBarLight(rattingActivity);
        setBinding(ActivityRattingBinding.inflate(getLayoutInflater()));
        setContentView(getBinding().getRoot());
        Helper.enableScreenShot(rattingActivity);
        RattingActivity rattingActivity2 = this;
        AllDoubtsFragmentKt.setNetworkCall(new NetworkCall(this, rattingActivity2));
        this.courseReviewArray = new ArrayList<>();
        if (getIntent() != null) {
            getBinding().toolbarTitleTV.setText(getResources().getString(R.string.course_review));
            this.courseId = getIntent().getStringExtra("courseId");
            this.is_purchased = getIntent().getStringExtra("is_purchased");
        }
        getCourseReviewList(false);
        this.layoutManager = new LinearLayoutManager(rattingActivity2);
        getBinding().courseReviewRecycler.setLayoutManager(this.layoutManager);
        getBinding().rattingImageBack.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Activity.RattingActivity$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RattingActivity.onCreate$lambda$0(this.f$0);
            }
        }));
        getBinding().sendRating.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Activity.RattingActivity$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RattingActivity.onCreate$lambda$1(this.f$0);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(RattingActivity rattingActivity) {
        rattingActivity.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$1(RattingActivity rattingActivity) {
        rattingActivity.showdialoguser();
        return Unit.INSTANCE;
    }

    private final void showdialoguser() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this, R.style.DialogStyle);
        bottomSheetDialog.requestWindowFeature(1);
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(R.layout.custom_rating_dialog);
        EditText editText = (EditText) bottomSheetDialog.findViewById(R.id.ratingComment);
        this.ratingComment = editText;
        Helper.setTextLimit(editText, 300);
        final RatingBar ratingBar = (RatingBar) bottomSheetDialog.findViewById(R.id.sendCourseRating);
        ImageView imageView = (ImageView) bottomSheetDialog.findViewById(R.id.cross);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Activity.RattingActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    bottomSheetDialog.dismiss();
                }
            });
        }
        Button button = (Button) bottomSheetDialog.findViewById(R.id.submitRating);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Activity.RattingActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RattingActivity.showdialoguser$lambda$3(this.f$0, ratingBar, bottomSheetDialog, view);
                }
            });
        }
        bottomSheetDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showdialoguser$lambda$3(RattingActivity rattingActivity, RatingBar ratingBar, BottomSheetDialog bottomSheetDialog, View view) {
        rattingActivity.rating = String.valueOf(ratingBar != null ? Float.valueOf(ratingBar.getRating()) : null);
        if (Intrinsics.areEqual(ratingBar != null ? Float.valueOf(ratingBar.getRating()) : null, 0.0f)) {
            Toast.makeText(rattingActivity, rattingActivity.getResources().getString(R.string.course_rating), 0).show();
            return;
        }
        EditText editText = rattingActivity.ratingComment;
        if (!String.valueOf(editText != null ? editText.getText() : null).equals(null)) {
            EditText editText2 = rattingActivity.ratingComment;
            if (!String.valueOf(editText2 != null ? editText2.getText() : null).equals("")) {
                bottomSheetDialog.dismiss();
                rattingActivity.sendRating(false);
                return;
            }
        }
        Toast.makeText(rattingActivity, rattingActivity.getResources().getString(R.string.please_insert_comment), 0).show();
    }

    private final void sendRating(boolean showProgress) {
        Helper.showProgressDialog(this);
        NetworkCall networkCall = AllDoubtsFragmentKt.getNetworkCall();
        if (networkCall != null) {
            networkCall.NetworkAPICall(API.POST_COURSE_REVIEW, "", showProgress, false);
        }
    }

    private final void getCourseReviewList(boolean showProgress) {
        RattingActivity rattingActivity = this;
        if (!Helper.isNetworkConnected(rattingActivity)) {
            Helper.showInternetToast(rattingActivity);
            RecyclerView recyclerView = getBinding().courseReviewRecycler;
            Intrinsics.checkNotNull(recyclerView);
            recyclerView.setVisibility(8);
            RelativeLayout relativeLayout = getBinding().noDataFoundRL;
            Intrinsics.checkNotNull(relativeLayout);
            relativeLayout.setVisibility(0);
            return;
        }
        getBinding().courseReviewRecycler.setVisibility(0);
        getBinding().noDataFoundRL.setVisibility(8);
        Helper.showProgressDialog(rattingActivity);
        NetworkCall networkCall = AllDoubtsFragmentKt.getNetworkCall();
        if (networkCall != null) {
            networkCall.NetworkAPICall(API.COURSE_REVIEW_LIST, "", showProgress, false);
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        Intrinsics.checkNotNullParameter(apitype, "apitype");
        Intrinsics.checkNotNullParameter(typeApi, "typeApi");
        Intrinsics.checkNotNullParameter(service, "service");
        if (Intrinsics.areEqual(apitype, API.COURSE_REVIEW_LIST)) {
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setCourse_id(this.courseId);
            return service.getCourseReviewList(AES.encrypt(new Gson().toJson(encryptionData)));
        }
        if (!Intrinsics.areEqual(apitype, API.POST_COURSE_REVIEW)) {
            return null;
        }
        EncryptionData encryptionData2 = new EncryptionData();
        encryptionData2.setCourse_id(this.courseId);
        encryptionData2.setRating(this.rating);
        EditText editText = this.ratingComment;
        encryptionData2.setMessage(String.valueOf(editText != null ? editText.getText() : null));
        return service.postCourseReview(AES.encrypt(new Gson().toJson(encryptionData2)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) {
        Intrinsics.checkNotNullParameter(jsonstring, "jsonstring");
        if (Intrinsics.areEqual(apitype, API.COURSE_REVIEW_LIST)) {
            try {
                Helper.dismissProgressDialog();
                ArrayList<ReviewData> arrayList = this.courseReviewArray;
                if (arrayList != null) {
                    arrayList.clear();
                }
                if (jsonstring.getString("status").equals("true")) {
                    CourseReviewDetail courseReviewDetail = (CourseReviewDetail) new Gson().fromJson(jsonstring.toString(), CourseReviewDetail.class);
                    this.courseReviewDetail = courseReviewDetail;
                    Intrinsics.checkNotNull(courseReviewDetail);
                    if (courseReviewDetail.getData() != null) {
                        CourseReviewDetail courseReviewDetail2 = this.courseReviewDetail;
                        Intrinsics.checkNotNull(courseReviewDetail2);
                        int size = courseReviewDetail2.getData().size();
                        if (1 <= size) {
                            int i = 1;
                            while (true) {
                                CourseReviewDetail courseReviewDetail3 = this.courseReviewDetail;
                                Intrinsics.checkNotNull(courseReviewDetail3);
                                if (courseReviewDetail3.getData().get(i - 1).getId().equals(SharedPreference.getInstance().getLoggedInUser().getId())) {
                                    getBinding().sendRating.setVisibility(8);
                                    break;
                                }
                                getBinding().sendRating.setVisibility(0);
                                if (i == size) {
                                    break;
                                } else {
                                    i++;
                                }
                            }
                        }
                        ArrayList<ReviewData> arrayList2 = this.courseReviewArray;
                        if (arrayList2 != null) {
                            CourseReviewDetail courseReviewDetail4 = this.courseReviewDetail;
                            Intrinsics.checkNotNull(courseReviewDetail4);
                            arrayList2.addAll(courseReviewDetail4.getData());
                        }
                        ArrayList<ReviewData> arrayList3 = this.courseReviewArray;
                        if (arrayList3 != null) {
                            setAdapter(arrayList3);
                        }
                        getBinding().courseReviewRecycler.setVisibility(0);
                        getBinding().noDataFoundRL.setVisibility(8);
                    } else {
                        getBinding().courseReviewRecycler.setVisibility(8);
                        getBinding().noDataFoundRL.setVisibility(0);
                    }
                } else {
                    getBinding().courseReviewRecycler.setVisibility(8);
                    getBinding().noDataFoundRL.setVisibility(0);
                    getBinding().sendRating.setVisibility(0);
                }
                String str = this.is_purchased;
                if (str == null || !StringsKt.equals(str, "1", true)) {
                    return;
                }
                getBinding().sendRating.setVisibility(8);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (Intrinsics.areEqual(apitype, API.POST_COURSE_REVIEW)) {
            try {
                Helper.dismissProgressDialog();
                if (jsonstring.getString("status").equals("true")) {
                    String string = jsonstring.getString("message");
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    XtensionFunctionKt.showSmallLengthToast(this, string);
                    getCourseReviewList(false);
                    return;
                }
                String string2 = jsonstring.getString("message");
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                XtensionFunctionKt.showSmallLengthToast(this, string2);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        ProgressBar progressBar;
        if (Intrinsics.areEqual(apitype, API.API_GET_DOUBT_REPLY)) {
            ProgressBar progressBar2 = this.paginationLoader;
            if (progressBar2 != null) {
                Intrinsics.checkNotNull(progressBar2);
                if (progressBar2.isShown()) {
                    ProgressBar progressBar3 = this.paginationLoader;
                    Intrinsics.checkNotNull(progressBar3);
                    progressBar3.setVisibility(8);
                    RecyclerView recyclerView = getBinding().courseReviewRecycler;
                    Intrinsics.checkNotNull(recyclerView);
                    recyclerView.setVisibility(8);
                    RelativeLayout relativeLayout = getBinding().noDataFoundRL;
                    Intrinsics.checkNotNull(relativeLayout);
                    relativeLayout.setVisibility(0);
                    return;
                }
                return;
            }
            return;
        }
        if (!Intrinsics.areEqual(apitype, API.POST_COURSE_REVIEW) || (progressBar = this.paginationLoader) == null) {
            return;
        }
        Intrinsics.checkNotNull(progressBar);
        if (progressBar.isShown()) {
            ProgressBar progressBar4 = this.paginationLoader;
            Intrinsics.checkNotNull(progressBar4);
            progressBar4.setVisibility(8);
        }
    }

    private final void setAdapter(ArrayList<ReviewData> courseReviewDetail) {
        this.reviewListAdapter = new ReviewListAdapter(courseReviewDetail, this);
        getBinding().courseReviewRecycler.setAdapter(this.reviewListAdapter);
    }
}
