package com.appnew.android.Zoom.Activity;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.ExtensionFunctions.XtensionFunctionKt;
import com.appnew.android.Model.ZoomModel.SuggestionData;
import com.appnew.android.Model.ZoomModel.SuggestionDetail;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.databinding.ActivitySuggestionNewBinding;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: Suggestion.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;H\u0014J\b\u0010<\u001a\u000209H\u0002J\b\u0010=\u001a\u000209H\u0002J,\u0010>\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010?2\b\u0010@\u001a\u0004\u0018\u00010 2\b\u0010A\u001a\u0004\u0018\u00010 2\u0006\u0010B\u001a\u00020CH\u0016J,\u0010D\u001a\u0002092\u0006\u0010E\u001a\u00020F2\b\u0010@\u001a\u0004\u0018\u00010 2\b\u0010A\u001a\u0004\u0018\u00010 2\u0006\u0010G\u001a\u00020HH\u0016J&\u0010I\u001a\u0002092\b\u0010E\u001a\u0004\u0018\u00010 2\b\u0010@\u001a\u0004\u0018\u00010 2\b\u0010A\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010J\u001a\u00020H2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\u001c\u0010(\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\u001c\u0010+\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\"\"\u0004\b-\u0010$R\u001c\u0010.\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\"\"\u0004\b0\u0010$R\"\u00101\u001a\b\u0012\u0004\u0012\u00020 02X\u0086\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006M"}, d2 = {"Lcom/appnew/android/Zoom/Activity/Suggestion;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroidx/appcompat/widget/PopupMenu$OnMenuItemClickListener;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/ActivitySuggestionNewBinding;", "getBinding", "()Lcom/appnew/android/databinding/ActivitySuggestionNewBinding;", "setBinding", "(Lcom/appnew/android/databinding/ActivitySuggestionNewBinding;)V", "paginationLoader", "Landroid/widget/ProgressBar;", "getPaginationLoader", "()Landroid/widget/ProgressBar;", "setPaginationLoader", "(Landroid/widget/ProgressBar;)V", "suggestionDetail", "Lcom/appnew/android/Model/ZoomModel/SuggestionDetail;", "getSuggestionDetail", "()Lcom/appnew/android/Model/ZoomModel/SuggestionDetail;", "setSuggestionDetail", "(Lcom/appnew/android/Model/ZoomModel/SuggestionDetail;)V", "suggestionDataArray", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/ZoomModel/SuggestionData;", "getSuggestionDataArray", "()Ljava/util/ArrayList;", "setSuggestionDataArray", "(Ljava/util/ArrayList;)V", "doubtposition", "", "getDoubtposition", "()Ljava/lang/String;", "setDoubtposition", "(Ljava/lang/String;)V", "category_id", "getCategory_id", "setCategory_id", "categoryType", "getCategoryType", "setCategoryType", "ratingValue", "getRatingValue", "setRatingValue", "message", "getMessage", "setMessage", Const.CATEGORY, "", "getCategory", "()[Ljava/lang/String;", "setCategory", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "spinnerFunction", "spinnerFunction1", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "", "ErrorCallBack", "onMenuItemClick", "item", "Landroid/view/MenuItem;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Suggestion extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener, NetworkCall.MyNetworkCallBack {
    public static final int $stable = 8;
    public ActivitySuggestionNewBinding binding;
    private String[] category = {"Suggestion", "Complaint"};
    private String categoryType;
    private String category_id;
    private String doubtposition;
    private String message;
    private ProgressBar paginationLoader;
    private String ratingValue;
    private ArrayList<SuggestionData> suggestionDataArray;
    private SuggestionDetail suggestionDetail;

    public final ActivitySuggestionNewBinding getBinding() {
        ActivitySuggestionNewBinding activitySuggestionNewBinding = this.binding;
        if (activitySuggestionNewBinding != null) {
            return activitySuggestionNewBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(ActivitySuggestionNewBinding activitySuggestionNewBinding) {
        Intrinsics.checkNotNullParameter(activitySuggestionNewBinding, "<set-?>");
        this.binding = activitySuggestionNewBinding;
    }

    public final ProgressBar getPaginationLoader() {
        return this.paginationLoader;
    }

    public final void setPaginationLoader(ProgressBar progressBar) {
        this.paginationLoader = progressBar;
    }

    public final SuggestionDetail getSuggestionDetail() {
        return this.suggestionDetail;
    }

    public final void setSuggestionDetail(SuggestionDetail suggestionDetail) {
        this.suggestionDetail = suggestionDetail;
    }

    public final ArrayList<SuggestionData> getSuggestionDataArray() {
        return this.suggestionDataArray;
    }

    public final void setSuggestionDataArray(ArrayList<SuggestionData> arrayList) {
        this.suggestionDataArray = arrayList;
    }

    public final String getDoubtposition() {
        return this.doubtposition;
    }

    public final void setDoubtposition(String str) {
        this.doubtposition = str;
    }

    public final String getCategory_id() {
        return this.category_id;
    }

    public final void setCategory_id(String str) {
        this.category_id = str;
    }

    public final String getCategoryType() {
        return this.categoryType;
    }

    public final void setCategoryType(String str) {
        this.categoryType = str;
    }

    public final String getRatingValue() {
        return this.ratingValue;
    }

    public final void setRatingValue(String str) {
        this.ratingValue = str;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final String[] getCategory() {
        return this.category;
    }

    public final void setCategory(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        this.category = strArr;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Suggestion suggestion = this;
        Helper.setSystemBarLight(suggestion);
        setBinding(ActivitySuggestionNewBinding.inflate(getLayoutInflater()));
        setContentView(getBinding().getRoot());
        Helper.enableScreenShot(suggestion);
        if (Build.VERSION.SDK_INT == 36) {
            Window window = getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
            ConstraintLayout root = getBinding().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            Toolbar mainToolbar = getBinding().mainToolbar;
            Intrinsics.checkNotNullExpressionValue(mainToolbar, "mainToolbar");
            EdgeToEdgeHelperOld.applyHeaderWithToolbar(this, window, root, mainToolbar);
        }
        AllDoubtsFragmentKt.setNetworkCall(new NetworkCall(this, this));
        this.suggestionDataArray = new ArrayList<>();
        getBinding().suggestionImageBack.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Activity.Suggestion$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Suggestion.onCreate$lambda$0(this.f$0);
            }
        }));
        if (getIntent() != null) {
            getBinding().toolbarTitleTV.setText(getIntent().getStringExtra("title_key"));
            if (getBinding().toolbarTitleTV.getText().equals(getResources().getString(R.string.feedback))) {
                getBinding().suggestionLl.setVisibility(0);
                getBinding().rl2.setVisibility(0);
                getBinding().submitRatting.setVisibility(0);
            } else if (getBinding().toolbarTitleTV.getText().equals(getResources().getString(R.string.suggestion))) {
                getBinding().relativeLayout.setVisibility(0);
                getBinding().relativeLayout1.setVisibility(0);
                this.categoryType = "0";
            } else if (getBinding().toolbarTitleTV.getText().equals(getResources().getString(R.string.complaint))) {
                getBinding().relativeLayout.setVisibility(0);
                getBinding().relativeLayout1.setVisibility(0);
                this.categoryType = "1";
            } else if (getBinding().toolbarTitleTV.getText().equals(getResources().getString(R.string.user_support))) {
                getBinding().relativeLayout.setVisibility(0);
                getBinding().relativeLayout0.setVisibility(0);
                getBinding().relativeLayout1.setVisibility(0);
                getBinding().SuggestionRL.setVisibility(0);
            }
        }
        spinnerFunction();
        spinnerFunction1();
        getBinding().submitSupport.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Activity.Suggestion$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Suggestion.onCreate$lambda$1(this.f$0, view);
            }
        });
        getBinding().submitRatting.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Activity.Suggestion$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Suggestion.onCreate$lambda$2(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(Suggestion suggestion) {
        suggestion.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(Suggestion suggestion, View view) {
        CharSequence text = suggestion.getBinding().supportText.getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        if (text.length() > 0) {
            CharSequence text2 = suggestion.getBinding().suggestionText.getText();
            Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
            if (text2.length() > 0) {
                Editable text3 = suggestion.getBinding().suggestionComment.getText();
                Intrinsics.checkNotNullExpressionValue(text3, "getText(...)");
                if (text3.length() > 0) {
                    Suggestion suggestion2 = suggestion;
                    if (Helper.isNetworkConnected(suggestion2)) {
                        NetworkCall networkCall = AllDoubtsFragmentKt.getNetworkCall();
                        if (networkCall != null) {
                            networkCall.NetworkAPICall(API.API_POST_USER_SUPPORT, "", false, false);
                            return;
                        }
                        return;
                    }
                    Helper.showInternetToast(suggestion2);
                    return;
                }
                Suggestion suggestion3 = suggestion;
                String string = suggestion.getResources().getString(R.string.please_insert_comment);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                XtensionFunctionKt.showSmallLengthToast(suggestion3, string);
                return;
            }
            Suggestion suggestion4 = suggestion;
            String string2 = suggestion.getString(R.string.please_select_category);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            XtensionFunctionKt.showSmallLengthToast(suggestion4, string2);
            return;
        }
        Suggestion suggestion5 = suggestion;
        String string3 = suggestion.getString(R.string.please_select_category);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        XtensionFunctionKt.showSmallLengthToast(suggestion5, string3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(Suggestion suggestion, View view) {
        suggestion.doubtposition = "0";
        if (suggestion.getBinding().ratting.getRating() != 0.0f) {
            Editable text = suggestion.getBinding().comment.getText();
            Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
            if (text.length() != 0) {
                NetworkCall networkCall = AllDoubtsFragmentKt.getNetworkCall();
                if (networkCall != null) {
                    networkCall.NetworkAPICall(API.API_POST_USER_SUPPORT, "", false, false);
                    return;
                }
                return;
            }
            Suggestion suggestion2 = suggestion;
            String string = suggestion.getResources().getString(R.string.please_insert_comment);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            XtensionFunctionKt.showSmallLengthToast(suggestion2, string);
            return;
        }
        Suggestion suggestion3 = suggestion;
        String string2 = suggestion.getResources().getString(R.string.please_insert_rating);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        XtensionFunctionKt.showSmallLengthToast(suggestion3, string2);
    }

    private final void spinnerFunction() {
        getBinding().supportText.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Activity.Suggestion$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Suggestion.spinnerFunction$lambda$3(this.f$0);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit spinnerFunction$lambda$3(Suggestion suggestion) {
        PopupMenu popupMenu = new PopupMenu(suggestion, suggestion.getBinding().supportText, 17);
        int length = suggestion.category.length;
        for (int i = 0; i < length; i++) {
            popupMenu.getMenu().add(suggestion.category[i]);
        }
        popupMenu.setOnMenuItemClickListener(suggestion);
        popupMenu.show();
        return Unit.INSTANCE;
    }

    private final void spinnerFunction1() {
        getBinding().suggestionText.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Activity.Suggestion$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Suggestion.spinnerFunction1$lambda$4(this.f$0);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit spinnerFunction1$lambda$4(Suggestion suggestion) {
        PopupMenu popupMenu = new PopupMenu(suggestion, suggestion.getBinding().suggestionText, 17);
        ArrayList<SuggestionData> arrayList = suggestion.suggestionDataArray;
        Intrinsics.checkNotNull(arrayList);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Menu menu = popupMenu.getMenu();
            ArrayList<SuggestionData> arrayList2 = suggestion.suggestionDataArray;
            Intrinsics.checkNotNull(arrayList2);
            menu.add(arrayList2.get(i).getName());
        }
        popupMenu.setOnMenuItemClickListener(suggestion);
        popupMenu.show();
        return Unit.INSTANCE;
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        Intrinsics.checkNotNullParameter(service, "service");
        if (Intrinsics.areEqual(apitype, API.API_GET_USER_SUPPORT_CATEGORY)) {
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setType(this.categoryType);
            return service.getSupportCategory(AES.encrypt(new Gson().toJson(encryptionData)));
        }
        if (!Intrinsics.areEqual(apitype, API.API_POST_USER_SUPPORT)) {
            return null;
        }
        EncryptionData encryptionData2 = new EncryptionData();
        encryptionData2.setType(this.doubtposition);
        encryptionData2.setStar_rating(String.valueOf(getBinding().ratting.getRating()));
        encryptionData2.setCategory_id(this.category_id);
        Editable text = getBinding().suggestionComment.getText();
        encryptionData2.setMessage(new StringBuilder().append((Object) text).append((Object) getBinding().comment.getText()).toString());
        return service.getPostSupport(AES.encrypt(new Gson().toJson(encryptionData2)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) {
        ArrayList<SuggestionData> arrayList;
        Intrinsics.checkNotNullParameter(jsonstring, "jsonstring");
        if (Intrinsics.areEqual(apitype, API.API_GET_USER_SUPPORT_CATEGORY)) {
            try {
                Helper.dismissProgressDialog();
                ArrayList<SuggestionData> arrayList2 = this.suggestionDataArray;
                if (arrayList2 != null) {
                    arrayList2.clear();
                }
                if (jsonstring.getString("status").equals("true")) {
                    SuggestionDetail suggestionDetail = (SuggestionDetail) new Gson().fromJson(jsonstring.toString(), SuggestionDetail.class);
                    this.suggestionDetail = suggestionDetail;
                    Intrinsics.checkNotNull(suggestionDetail);
                    if (suggestionDetail.getData() == null || (arrayList = this.suggestionDataArray) == null) {
                        return;
                    }
                    SuggestionDetail suggestionDetail2 = this.suggestionDetail;
                    Intrinsics.checkNotNull(suggestionDetail2);
                    arrayList.addAll(suggestionDetail2.getData());
                    return;
                }
                String string = jsonstring.getString("message");
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                XtensionFunctionKt.showSmallLengthToast(this, string);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (Intrinsics.areEqual(apitype, API.API_POST_USER_SUPPORT)) {
            try {
                Helper.dismissProgressDialog();
                if (StringsKt.equals(jsonstring.getString("status"), "true", true)) {
                    String string2 = jsonstring.getString("message");
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    XtensionFunctionKt.showSmallLengthToast(this, string2);
                    finish();
                    return;
                }
                String string3 = jsonstring.getString("message");
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                XtensionFunctionKt.showSmallLengthToast(this, string3);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        ProgressBar progressBar;
        if (Intrinsics.areEqual(apitype, API.API_GET_USER_SUPPORT_CATEGORY)) {
            ProgressBar progressBar2 = this.paginationLoader;
            if (progressBar2 != null) {
                Intrinsics.checkNotNull(progressBar2);
                if (progressBar2.isShown()) {
                    ProgressBar progressBar3 = this.paginationLoader;
                    Intrinsics.checkNotNull(progressBar3);
                    progressBar3.setVisibility(8);
                    return;
                }
                return;
            }
            return;
        }
        if (!Intrinsics.areEqual(apitype, API.API_POST_USER_SUPPORT) || (progressBar = this.paginationLoader) == null) {
            return;
        }
        Intrinsics.checkNotNull(progressBar);
        if (progressBar.isShown()) {
            ProgressBar progressBar4 = this.paginationLoader;
            Intrinsics.checkNotNull(progressBar4);
            progressBar4.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x007f  */
    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onMenuItemClick(android.view.MenuItem r7) {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Zoom.Activity.Suggestion.onMenuItemClick(android.view.MenuItem):boolean");
    }
}
