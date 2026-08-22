package com.appnew.android.Zoom.Activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import com.appnew.android.BuildConfig;
import com.appnew.android.Courses.Activity.PdfDetailScreen;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.ZoomModel.CurrentAffairDataModel;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.databinding.ActivityCurrentAffairInfoBinding;
import com.bumptech.glide.Glide;
import com.clevertap.android.sdk.db.Column;
import com.eduteria.app.app.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: CurrentAffairInfoActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"H\u0002J.\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010\u00122\b\u0010&\u001a\u0004\u0018\u00010\u00122\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J.\u0010)\u001a\u00020\u001c2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010%\u001a\u0004\u0018\u00010\u00122\b\u0010&\u001a\u0004\u0018\u00010\u00122\u0006\u0010,\u001a\u00020-H\u0016J&\u0010.\u001a\u00020\u001c2\b\u0010*\u001a\u0004\u0018\u00010\u00122\b\u0010%\u001a\u0004\u0018\u00010\u00122\b\u0010&\u001a\u0004\u0018\u00010\u0012H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/appnew/android/Zoom/Activity/CurrentAffairInfoActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/ActivityCurrentAffairInfoBinding;", "getBinding", "()Lcom/appnew/android/databinding/ActivityCurrentAffairInfoBinding;", "setBinding", "(Lcom/appnew/android/databinding/ActivityCurrentAffairInfoBinding;)V", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "description", "", Column.CREATED_AT, "file_url", "id", "type", "text", "url", "webView", "Landroid/webkit/WebView;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setPdfView", "loadDescription", "data", "Lcom/appnew/android/Model/ZoomModel/CurrentAffairDataModel;", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "", "ErrorCallBack", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CurrentAffairInfoActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack {
    public static final int $stable = 8;
    public ActivityCurrentAffairInfoBinding binding;
    private String created_at;
    private String description;
    private String file_url;
    private String id;
    private NetworkCall networkCall;
    private String text;
    private String type;
    private String url;
    private WebView webView;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean loadDescription$lambda$3(View view) {
        return true;
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    public final ActivityCurrentAffairInfoBinding getBinding() {
        ActivityCurrentAffairInfoBinding activityCurrentAffairInfoBinding = this.binding;
        if (activityCurrentAffairInfoBinding != null) {
            return activityCurrentAffairInfoBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(ActivityCurrentAffairInfoBinding activityCurrentAffairInfoBinding) {
        Intrinsics.checkNotNullParameter(activityCurrentAffairInfoBinding, "<set-?>");
        this.binding = activityCurrentAffairInfoBinding;
    }

    public final NetworkCall getNetworkCall() {
        return this.networkCall;
    }

    public final void setNetworkCall(NetworkCall networkCall) {
        this.networkCall = networkCall;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CurrentAffairInfoActivity currentAffairInfoActivity = this;
        Helper.setSystemBarLight(currentAffairInfoActivity);
        setBinding(ActivityCurrentAffairInfoBinding.inflate(getLayoutInflater()));
        setContentView(getBinding().getRoot());
        Helper.enableScreenShot(currentAffairInfoActivity);
        if (Build.VERSION.SDK_INT == 36) {
            Window window = getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
            ConstraintLayout root = getBinding().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            Toolbar mainToolbar = getBinding().mainToolbar;
            Intrinsics.checkNotNullExpressionValue(mainToolbar, "mainToolbar");
            EdgeToEdgeHelperOld.applyHeaderWithToolbar(this, window, root, mainToolbar);
        }
        this.networkCall = new NetworkCall(this, this);
        this.webView = (WebView) findViewById(R.id.currentAffair_subject);
        if (getIntent() != null) {
            this.id = getIntent().getStringExtra("id");
            this.type = getIntent().getStringExtra("type");
            setTitle(getIntent().getStringExtra("title"));
            this.text = getIntent().getStringExtra("text");
            this.file_url = getIntent().getStringExtra("url");
            if (StringsKt.equals(this.type, Const.CURRENT_AFFAIR, true)) {
                NetworkCall networkCall = this.networkCall;
                if (networkCall != null) {
                    networkCall.NetworkAPICall(API.API_GET_CURRENT_AFFAIR_DETAILS, "", true, false);
                }
            } else if (StringsKt.equals(this.type, "notice_board", true)) {
                LinearLayout linearLayout = getBinding().currentAffairDetailsLL;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                LinearLayout linearLayout2 = getBinding().noticeBoardDetails;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
                FloatingActionButton floatingActionButton = getBinding().pdfFloating;
                if (floatingActionButton != null) {
                    floatingActionButton.setVisibility(0);
                }
                setPdfView();
                getBinding().toolbarTitleTV.setText("Notice Board");
                TextView textView = getBinding().titleNoticeBoard;
                if (textView != null) {
                    textView.setText(getTitle());
                }
                Helper.load(getBinding().webNoticeBoard, this.text);
            }
        }
        getBinding().currentAffairInfoBack.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Activity.CurrentAffairInfoActivity$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CurrentAffairInfoActivity.onCreate$lambda$0(this.f$0);
            }
        }));
        if (!StringsKt.equals(this.type, "notice_board", true)) {
            getBinding().scroll.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.appnew.android.Zoom.Activity.CurrentAffairInfoActivity$$ExternalSyntheticLambda3
                @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
                public final void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                    CurrentAffairInfoActivity.onCreate$lambda$1(this.f$0, nestedScrollView, i, i2, i3, i4);
                }
            });
        }
        if (StringsKt.equals(BuildConfig.FLAVOR, "ICSHomework", true)) {
            getBinding().currentAffairTittle.setTextColor(getColor(R.color.colorPrimary));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(CurrentAffairInfoActivity currentAffairInfoActivity) {
        currentAffairInfoActivity.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(CurrentAffairInfoActivity currentAffairInfoActivity, NestedScrollView v, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(v, "v");
        if (i2 > 0) {
            currentAffairInfoActivity.getBinding().pdfFloating.hide();
            return;
        }
        String str = currentAffairInfoActivity.file_url;
        if (str == null || StringsKt.equals$default(str, "", false, 2, null)) {
            return;
        }
        currentAffairInfoActivity.getBinding().pdfFloating.show();
    }

    private final void setPdfView() {
        String str = this.file_url;
        if (str != null && !StringsKt.equals$default(str, "", false, 2, null)) {
            getBinding().pdfFloating.setVisibility(0);
            getBinding().pdfFloating.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Activity.CurrentAffairInfoActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CurrentAffairInfoActivity.setPdfView$lambda$2(this.f$0, view);
                }
            });
        } else {
            getBinding().pdfFloating.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setPdfView$lambda$2(CurrentAffairInfoActivity currentAffairInfoActivity, View view) {
        CurrentAffairInfoActivity currentAffairInfoActivity2 = currentAffairInfoActivity;
        if (Helper.isNetworkConnected(currentAffairInfoActivity2)) {
            Intent intent = new Intent(currentAffairInfoActivity2, (Class<?>) PdfDetailScreen.class);
            intent.putExtra("title", currentAffairInfoActivity.id);
            intent.putExtra("url", currentAffairInfoActivity.file_url);
            intent.putExtra("pdf_name", currentAffairInfoActivity.getBinding().toolbarTitleTV.getText());
            intent.putExtra("type", "notice_board");
            intent.putExtra("course_id", currentAffairInfoActivity.id);
            intent.putExtra("save", false);
            intent.putExtra(Const.IS_DOWNLOAD, true);
            currentAffairInfoActivity.startActivity(intent);
            return;
        }
        Toast.makeText(currentAffairInfoActivity2, currentAffairInfoActivity.getResources().getString(R.string.no_internet_connection), 0).show();
    }

    private final void loadDescription(CurrentAffairDataModel data) {
        WebView webView = this.webView;
        WebView webView2 = null;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        webView.setBackgroundColor(0);
        WebView webView3 = this.webView;
        if (webView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView3 = null;
        }
        webView3.setHapticFeedbackEnabled(false);
        WebView webView4 = this.webView;
        if (webView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView4 = null;
        }
        webView4.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.appnew.android.Zoom.Activity.CurrentAffairInfoActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return CurrentAffairInfoActivity.loadDescription$lambda$3(view);
            }
        });
        WebView webView5 = this.webView;
        if (webView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView5 = null;
        }
        webView5.setLongClickable(false);
        String str = this.description;
        if (str == null || TextUtils.isEmpty(str)) {
            return;
        }
        CurrentAffairInfoActivity currentAffairInfoActivity = this;
        String htmlUpdatedDatas = Helper.getHtmlUpdatedDatas(data.getDescription());
        WebView webView6 = this.webView;
        if (webView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        } else {
            webView2 = webView6;
        }
        Helper.showWebDatas(currentAffairInfoActivity, htmlUpdatedDatas, webView2);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        if (Intrinsics.areEqual(apitype, API.API_GET_CURRENT_AFFAIR_DETAILS)) {
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setStart_date("");
            encryptionData.setEnd_date("");
            encryptionData.setId(this.id);
            String strEncrypt = AES.encrypt(new Gson().toJson(encryptionData));
            if (service != null) {
                return service.getCurrentAffairDetails(strEncrypt);
            }
        }
        return null;
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) {
        String string;
        if (Intrinsics.areEqual(apitype, API.API_GET_CURRENT_AFFAIR_DETAILS)) {
            if (jsonstring != null) {
                try {
                    string = jsonstring.getString("status");
                } catch (Exception unused) {
                    return;
                }
            } else {
                string = null;
            }
            if (StringsKt.equals$default(string, "true", false, 2, null)) {
                JSONArray jSONArray = jsonstring != null ? jsonstring.getJSONArray("data") : null;
                CurrentAffairDataModel currentAffairDataModel = (CurrentAffairDataModel) new Gson().fromJson(String.valueOf(jSONArray != null ? jSONArray.get(0) : null), CurrentAffairDataModel.class);
                getBinding().toolbarTitleTV.setText(currentAffairDataModel.getTitle());
                getBinding().toolbarTitleTV.setSelected(true);
                getBinding().currentAffairTittle.setText(currentAffairDataModel.getTitle() + " :");
                this.description = currentAffairDataModel.getDescription();
                this.created_at = currentAffairDataModel.getCreated_at();
                this.file_url = currentAffairDataModel.getFile_url();
                Intrinsics.checkNotNull(currentAffairDataModel);
                loadDescription(currentAffairDataModel);
                setPdfView();
                Intrinsics.checkNotNull(Glide.with((FragmentActivity) this).load(currentAffairDataModel.getImage()).placeholder(R.mipmap.square_placeholder).thumbnail(0.5f).into(getBinding().currentAffairImage));
                return;
            }
            getBinding().pdfFloating.setVisibility(8);
            RelativeLayout relativeLayout = getBinding().noDataFoundRL;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
        }
    }
}
