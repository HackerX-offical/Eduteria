package com.appnew.android.Zoom.Activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ahmadnemati.clickablewebview.ClickableWebView;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.ZoomModel.OptionsModel;
import com.appnew.android.Model.ZoomModel.QuestionData;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Zoom.Adapter.OptionsAdapter;
import com.appnew.android.databinding.ActivityViewQuestionBinding;
import com.eduteria.app.app.R;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: ViewQuestionActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0015J\u0010\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020\u0013H\u0002J.\u0010*\u001a\u00020%2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u0016H\u0002J\u0018\u0010+\u001a\u00020%2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u0013H\u0002J \u0010-\u001a\u00020%2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0015j\b\u0012\u0004\u0012\u00020\u0018`\u0016H\u0002J.\u0010.\u001a\f\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010/2\b\u00101\u001a\u0004\u0018\u0001002\b\u00102\u001a\u0004\u0018\u0001002\u0006\u00103\u001a\u000204H\u0016J,\u00105\u001a\u00020%2\u0006\u00106\u001a\u0002072\b\u00101\u001a\u0004\u0018\u0001002\b\u00102\u001a\u0004\u0018\u0001002\u0006\u00108\u001a\u000209H\u0016J&\u0010:\u001a\u00020%2\b\u00106\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u0001002\b\u00102\u001a\u0004\u0018\u000100H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0015j\b\u0012\u0004\u0012\u00020\u0018`\u0016X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006;"}, d2 = {"Lcom/appnew/android/Zoom/Activity/ViewQuestionActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/ActivityViewQuestionBinding;", "getBinding", "()Lcom/appnew/android/databinding/ActivityViewQuestionBinding;", "setBinding", "(Lcom/appnew/android/databinding/ActivityViewQuestionBinding;)V", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "optionsAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/Zoom/Adapter/OptionsAdapter$ViewHolder;", "questionData", "Lcom/appnew/android/Model/ZoomModel/QuestionData;", "indexPosition", "", "questionList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "optionArray", "Lcom/appnew/android/Model/ZoomModel/OptionsModel;", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "currentPosition", "getCurrentPosition", "()I", "setCurrentPosition", "(I)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "showItem", FirebaseAnalytics.Param.INDEX, "setOptions", "setExplanationView", Const.POSITION, "setAdapter", "getAPIB", "Lretrofit2/Call;", "", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "", "ErrorCallBack", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ViewQuestionActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack {
    public static final int $stable = 8;
    public ActivityViewQuestionBinding binding;
    private int currentPosition;
    private int indexPosition;
    private RecyclerView.LayoutManager layoutManager;
    private NetworkCall networkCall;
    private ArrayList<OptionsModel> optionArray;
    private RecyclerView.Adapter<OptionsAdapter.ViewHolder> optionsAdapter;
    private QuestionData questionData;
    private ArrayList<QuestionData> questionList;

    public final ActivityViewQuestionBinding getBinding() {
        ActivityViewQuestionBinding activityViewQuestionBinding = this.binding;
        if (activityViewQuestionBinding != null) {
            return activityViewQuestionBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(ActivityViewQuestionBinding activityViewQuestionBinding) {
        Intrinsics.checkNotNullParameter(activityViewQuestionBinding, "<set-?>");
        this.binding = activityViewQuestionBinding;
    }

    public final NetworkCall getNetworkCall() {
        return this.networkCall;
    }

    public final void setNetworkCall(NetworkCall networkCall) {
        this.networkCall = networkCall;
    }

    public final int getCurrentPosition() {
        return this.currentPosition;
    }

    public final void setCurrentPosition(int i) {
        this.currentPosition = i;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewQuestionActivity viewQuestionActivity = this;
        Helper.setSystemBarLight(viewQuestionActivity);
        setBinding(ActivityViewQuestionBinding.inflate(getLayoutInflater()));
        setContentView(getBinding().getRoot());
        if (Build.VERSION.SDK_INT == 36) {
            Window window = getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
            ConstraintLayout root = getBinding().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            Toolbar mainToolbar = getBinding().mainToolbar;
            Intrinsics.checkNotNullExpressionValue(mainToolbar, "mainToolbar");
            EdgeToEdgeHelperOld.applyHeaderWithToolbar(this, window, root, mainToolbar);
        }
        Helper.enableScreenShot(viewQuestionActivity);
        this.networkCall = new NetworkCall(this, this);
        this.optionArray = new ArrayList<>();
        if (getIntent() != null) {
            getBinding().toolbarTitleTV.setText(getResources().getString(R.string.bookmark_question));
            this.currentPosition = getIntent().getIntExtra(Const.POSITION, 0);
            this.questionData = (QuestionData) getIntent().getSerializableExtra("data");
            this.questionList = (ArrayList) getIntent().getSerializableExtra("data_list");
        }
        getBinding().viewQuestionBack.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Activity.ViewQuestionActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ViewQuestionActivity.onCreate$lambda$0(this.f$0);
            }
        }));
        showItem(this.currentPosition);
        FrameLayout frameLayout = getBinding().btnNext;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Activity.ViewQuestionActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewQuestionActivity.onCreate$lambda$1(this.f$0, view);
                }
            });
        }
        FrameLayout frameLayout2 = getBinding().btnPrev;
        if (frameLayout2 != null) {
            frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Activity.ViewQuestionActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewQuestionActivity.onCreate$lambda$2(this.f$0, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(ViewQuestionActivity viewQuestionActivity) {
        viewQuestionActivity.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(ViewQuestionActivity viewQuestionActivity, View view) {
        int i = viewQuestionActivity.currentPosition;
        Intrinsics.checkNotNull(viewQuestionActivity.questionList);
        if (i < r0.size() - 1) {
            int i2 = viewQuestionActivity.currentPosition + 1;
            viewQuestionActivity.currentPosition = i2;
            viewQuestionActivity.showItem(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(ViewQuestionActivity viewQuestionActivity, View view) {
        int i = viewQuestionActivity.currentPosition;
        if (i > 0) {
            int i2 = i - 1;
            viewQuestionActivity.currentPosition = i2;
            viewQuestionActivity.showItem(i2);
        }
    }

    private static final void onCreate$lambda$3(ViewQuestionActivity viewQuestionActivity, View view) {
        viewQuestionActivity.getBinding().questionBookmark.setEnabled(false);
        NetworkCall networkCall = viewQuestionActivity.networkCall;
        Intrinsics.checkNotNull(networkCall);
        networkCall.NetworkAPICall(API.API_ADD_TO_BOOKMARK, "", true, false);
    }

    private final void showItem(int index) {
        this.indexPosition = index;
        FrameLayout frameLayout = getBinding().btnPrev;
        int i = R.drawable.background_bg_next;
        if (frameLayout != null) {
            frameLayout.setBackgroundResource(this.currentPosition > 0 ? R.drawable.background_bg_next : R.drawable.background_bg_prev);
        }
        FrameLayout frameLayout2 = getBinding().btnNext;
        if (frameLayout2 != null) {
            int i2 = this.currentPosition;
            Intrinsics.checkNotNull(this.questionList);
            if (i2 > r4.size() - 2) {
                i = R.drawable.background_bg_prev;
            }
            frameLayout2.setBackgroundResource(i);
        }
        ArrayList<QuestionData> arrayList = this.questionList;
        ArrayList<OptionsModel> arrayList2 = null;
        QuestionData questionData = arrayList != null ? arrayList.get(index) : null;
        ArrayList<OptionsModel> arrayList3 = this.optionArray;
        if (arrayList3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("optionArray");
        } else {
            arrayList2 = arrayList3;
        }
        setOptions(questionData, arrayList2);
        TextView textView = getBinding().tvQuestionnumber;
        String string = getResources().getString(R.string.question);
        ArrayList<QuestionData> arrayList4 = this.questionList;
        Intrinsics.checkNotNull(arrayList4);
        textView.setText(string + (index + 1) + " / " + arrayList4.size());
        FrameLayout frameLayout3 = getBinding().btnPrev;
        if (frameLayout3 != null) {
            frameLayout3.setEnabled(index > 0);
        }
        FrameLayout frameLayout4 = getBinding().btnNext;
        if (frameLayout4 != null) {
            ArrayList<QuestionData> arrayList5 = this.questionList;
            Intrinsics.checkNotNull(arrayList5);
            frameLayout4.setEnabled(index < arrayList5.size() - 1);
        }
    }

    private final void setOptions(QuestionData questionData, ArrayList<OptionsModel> optionArray) {
        String option_1;
        if (optionArray != null) {
            optionArray.clear();
        }
        Helper.testQuestionFont(getBinding().viewQuestion, this.indexPosition, questionData != null ? questionData.getQuestion() : null, "2");
        if ((questionData != null ? questionData.getOption_1() : null) != null || (questionData != null && (option_1 = questionData.getOption_1()) != null && option_1.length() == 0)) {
            Intrinsics.checkNotNull(optionArray);
            optionArray.add(new OptionsModel(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, questionData != null ? questionData.getOption_1() : null, questionData != null ? questionData.getAnswer() : null));
        }
        if ((questionData != null ? questionData.getOption_2() : null) != null) {
            Intrinsics.checkNotNull(questionData);
            String option_2 = questionData.getOption_2();
            Intrinsics.checkNotNullExpressionValue(option_2, "getOption_2(...)");
            if (!StringsKt.isBlank(option_2)) {
                Intrinsics.checkNotNull(optionArray);
                optionArray.add(new OptionsModel("B", questionData.getOption_2(), questionData.getAnswer()));
            }
        }
        if ((questionData != null ? questionData.getOption_3() : null) != null) {
            Intrinsics.checkNotNull(questionData);
            String option_3 = questionData.getOption_3();
            Intrinsics.checkNotNullExpressionValue(option_3, "getOption_3(...)");
            if (!StringsKt.isBlank(option_3)) {
                Intrinsics.checkNotNull(optionArray);
                optionArray.add(new OptionsModel("C", questionData.getOption_3(), questionData.getAnswer()));
            }
        }
        if ((questionData != null ? questionData.getOption_4() : null) != null) {
            Intrinsics.checkNotNull(questionData);
            String option_4 = questionData.getOption_4();
            Intrinsics.checkNotNullExpressionValue(option_4, "getOption_4(...)");
            if (!StringsKt.isBlank(option_4)) {
                Intrinsics.checkNotNull(optionArray);
                optionArray.add(new OptionsModel("D", questionData.getOption_4(), questionData.getAnswer()));
            }
        }
        if ((questionData != null ? questionData.getOption_5() : null) != null) {
            Intrinsics.checkNotNull(questionData);
            String option_5 = questionData.getOption_5();
            Intrinsics.checkNotNullExpressionValue(option_5, "getOption_5(...)");
            if (!StringsKt.isBlank(option_5)) {
                Intrinsics.checkNotNull(optionArray);
                optionArray.add(new OptionsModel(ExifInterface.LONGITUDE_EAST, questionData.getOption_5(), questionData.getAnswer()));
            }
        }
        if ((questionData != null ? questionData.getOption_6() : null) != null) {
            Intrinsics.checkNotNull(questionData);
            String option_6 = questionData.getOption_6();
            Intrinsics.checkNotNullExpressionValue(option_6, "getOption_6(...)");
            if (!StringsKt.isBlank(option_6)) {
                Intrinsics.checkNotNull(optionArray);
                optionArray.add(new OptionsModel("F", questionData.getOption_6(), questionData.getAnswer()));
            }
        }
        if ((questionData != null ? questionData.getOption_7() : null) != null) {
            Intrinsics.checkNotNull(questionData);
            String option_7 = questionData.getOption_7();
            Intrinsics.checkNotNullExpressionValue(option_7, "getOption_7(...)");
            if (!StringsKt.isBlank(option_7)) {
                Intrinsics.checkNotNull(optionArray);
                optionArray.add(new OptionsModel("G", questionData.getOption_7(), questionData.getAnswer()));
            }
        }
        if ((questionData != null ? questionData.getOption_8() : null) != null) {
            Intrinsics.checkNotNull(questionData);
            String option_8 = questionData.getOption_8();
            Intrinsics.checkNotNullExpressionValue(option_8, "getOption_8(...)");
            if (!StringsKt.isBlank(option_8)) {
                Intrinsics.checkNotNull(optionArray);
                optionArray.add(new OptionsModel("H", questionData.getOption_8(), questionData.getAnswer()));
            }
        }
        this.layoutManager = new LinearLayoutManager(this);
        RecyclerView recyclerView = getBinding().optionViewRecycler;
        Intrinsics.checkNotNull(recyclerView);
        recyclerView.setLayoutManager(this.layoutManager);
        if (StringsKt.equals(String.valueOf(questionData != null ? questionData.getQuestion_type() : null), "FIB", true)) {
            if (optionArray != null) {
                optionArray.clear();
            }
            Intrinsics.checkNotNull(optionArray);
            optionArray.add(new OptionsModel(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, questionData != null ? questionData.getAnswer() : null, "1"));
            setAdapter(optionArray);
        } else {
            Intrinsics.checkNotNull(optionArray);
            setAdapter(optionArray);
        }
        if (questionData != null) {
            setExplanationView(questionData, 0);
        }
    }

    private final void setExplanationView(QuestionData questionData, int position) {
        WebSettings settings;
        WebSettings settings2;
        String description = questionData.getDescription();
        Intrinsics.checkNotNullExpressionValue(description, "getDescription(...)");
        if (description.length() != 0) {
            String description2 = questionData.getDescription();
            LinearLayout linearLayout = getBinding().reviewExplanationLL;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            ClickableWebView clickableWebView = getBinding().reviewExplanationTV;
            if (clickableWebView != null) {
                clickableWebView.setBackgroundColor(0);
            }
            ClickableWebView clickableWebView2 = getBinding().reviewExplanationTV;
            if (clickableWebView2 != null) {
                clickableWebView2.setLayerType(2, null);
            }
            ClickableWebView clickableWebView3 = getBinding().reviewExplanationTV;
            if (clickableWebView3 != null && (settings2 = clickableWebView3.getSettings()) != null) {
                settings2.setJavaScriptEnabled(true);
            }
            ClickableWebView clickableWebView4 = getBinding().reviewExplanationTV;
            if (clickableWebView4 != null && (settings = clickableWebView4.getSettings()) != null) {
                settings.setJavaScriptEnabled(true);
            }
            Helper.testOptionFont(getBinding().reviewExplanationTV, description2, "2");
            return;
        }
        LinearLayout linearLayout2 = getBinding().reviewExplanationLL;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
    }

    private final void setAdapter(ArrayList<OptionsModel> optionArray) {
        this.optionsAdapter = new OptionsAdapter(optionArray, this);
        getBinding().optionViewRecycler.setAdapter(this.optionsAdapter);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        Intrinsics.checkNotNullParameter(service, "service");
        if (!Intrinsics.areEqual(apitype, API.API_ADD_TO_BOOKMARK)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setContent_type("0");
        QuestionData questionData = this.questionData;
        encryptionData.setContent_id(questionData != null ? questionData.getConfig_id() : null);
        encryptionData.setIs_unbookmarked("1");
        return service.addPdfBookMark(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) {
        Intrinsics.checkNotNullParameter(jsonstring, "jsonstring");
        if (Intrinsics.areEqual(apitype, API.API_ADD_TO_BOOKMARK)) {
            try {
                Helper.dismissProgressDialog();
                if (jsonstring.getString("status").equals("true")) {
                    getBinding().questionBookmark.setImageResource(R.mipmap.bookmark_unselected);
                    Toast.makeText(this, jsonstring.optString("message"), 0).show();
                } else {
                    Toast.makeText(this, jsonstring.optString("message"), 0).show();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
