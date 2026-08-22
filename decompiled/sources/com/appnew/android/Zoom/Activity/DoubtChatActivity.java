package com.appnew.android.Zoom.Activity;

import android.os.Build;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.ExtensionFunctions.XtensionFunctionKt;
import com.appnew.android.Model.ZoomModel.DoubtData;
import com.appnew.android.Model.ZoomModel.ReplyModel;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Zoom.Adapter.DoubtChatAdapter;
import com.appnew.android.databinding.ActivityDoubtChatBinding;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: DoubtChatActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100H\u0015J\b\u00101\u001a\u00020.H\u0002J\b\u00102\u001a\u00020.H\u0002J\u0010\u00103\u001a\u00020.2\u0006\u00104\u001a\u00020)H\u0002J\b\u00105\u001a\u00020.H\u0002J\u0010\u00106\u001a\u00020.2\u0006\u00104\u001a\u00020)H\u0002J,\u00107\u001a\n\u0012\u0004\u0012\u00020#\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010#2\b\u0010:\u001a\u0004\u0018\u00010#2\u0006\u0010;\u001a\u00020<H\u0016J,\u0010=\u001a\u00020.2\u0006\u0010>\u001a\u00020?2\b\u00109\u001a\u0004\u0018\u00010#2\b\u0010:\u001a\u0004\u0018\u00010#2\u0006\u0010@\u001a\u00020)H\u0016J&\u0010A\u001a\u00020.2\b\u0010>\u001a\u0004\u0018\u00010#2\b\u00109\u001a\u0004\u0018\u00010#2\b\u0010:\u001a\u0004\u0018\u00010#H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010*\"\u0004\b+\u0010,¨\u0006B"}, d2 = {"Lcom/appnew/android/Zoom/Activity/DoubtChatActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/ActivityDoubtChatBinding;", "getBinding", "()Lcom/appnew/android/databinding/ActivityDoubtChatBinding;", "setBinding", "(Lcom/appnew/android/databinding/ActivityDoubtChatBinding;)V", "layoutManager1", "Landroidx/recyclerview/widget/LinearLayoutManager;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/Zoom/Adapter/DoubtChatAdapter$ViewHolder;", "doubtData", "Lcom/appnew/android/Model/ZoomModel/DoubtData;", "getDoubtData", "()Lcom/appnew/android/Model/ZoomModel/DoubtData;", "setDoubtData", "(Lcom/appnew/android/Model/ZoomModel/DoubtData;)V", "replyModel", "Lcom/appnew/android/Model/ZoomModel/ReplyModel;", "getReplyModel", "()Lcom/appnew/android/Model/ZoomModel/ReplyModel;", "setReplyModel", "(Lcom/appnew/android/Model/ZoomModel/ReplyModel;)V", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "doubtType", "", "getDoubtType", "()Ljava/lang/String;", "setDoubtType", "(Ljava/lang/String;)V", "isDialogShown", "", "()Z", "setDialogShown", "(Z)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupKeyboardInsets", "setClicks", "sendChat", "showProgress", "getChatData", "resolveStatus", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "ErrorCallBack", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubtChatActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack {
    public static final int $stable = 8;
    private RecyclerView.Adapter<DoubtChatAdapter.ViewHolder> adapter;
    public ActivityDoubtChatBinding binding;
    private DoubtData doubtData;
    private String doubtType;
    private boolean isDialogShown;
    private LinearLayoutManager layoutManager1;
    private NetworkCall networkCall;
    private ReplyModel replyModel;

    public final ActivityDoubtChatBinding getBinding() {
        ActivityDoubtChatBinding activityDoubtChatBinding = this.binding;
        if (activityDoubtChatBinding != null) {
            return activityDoubtChatBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(ActivityDoubtChatBinding activityDoubtChatBinding) {
        Intrinsics.checkNotNullParameter(activityDoubtChatBinding, "<set-?>");
        this.binding = activityDoubtChatBinding;
    }

    public final DoubtData getDoubtData() {
        return this.doubtData;
    }

    public final void setDoubtData(DoubtData doubtData) {
        this.doubtData = doubtData;
    }

    public final ReplyModel getReplyModel() {
        return this.replyModel;
    }

    public final void setReplyModel(ReplyModel replyModel) {
        this.replyModel = replyModel;
    }

    public final NetworkCall getNetworkCall() {
        return this.networkCall;
    }

    public final void setNetworkCall(NetworkCall networkCall) {
        this.networkCall = networkCall;
    }

    public final String getDoubtType() {
        return this.doubtType;
    }

    public final void setDoubtType(String str) {
        this.doubtType = str;
    }

    /* JADX INFO: renamed from: isDialogShown, reason: from getter */
    public final boolean getIsDialogShown() {
        return this.isDialogShown;
    }

    public final void setDialogShown(boolean z) {
        this.isDialogShown = z;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DoubtChatActivity doubtChatActivity = this;
        Helper.setSystemBarLight(doubtChatActivity);
        setBinding(ActivityDoubtChatBinding.inflate(getLayoutInflater()));
        setContentView(getBinding().getRoot());
        Helper.enableScreenShot(doubtChatActivity);
        if (Build.VERSION.SDK_INT == 36) {
            DoubtChatActivity doubtChatActivity2 = this;
            Window window = getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
            RelativeLayout root = getBinding().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            Toolbar mainToolbar = getBinding().mainToolbar;
            Intrinsics.checkNotNullExpressionValue(mainToolbar, "mainToolbar");
            EdgeToEdgeHelperOld.applyHeaderWithToolbar(doubtChatActivity2, window, root, mainToolbar);
            WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
            getWindow().setStatusBarColor(ContextCompat.getColor(doubtChatActivity2, R.color.colorPrimary));
            setupKeyboardInsets();
        }
        DoubtChatActivity doubtChatActivity3 = this;
        this.networkCall = new NetworkCall(this, doubtChatActivity3);
        if (getIntent() != null) {
            getBinding().toolbarTitleTV.setText(getResources().getString(R.string.doubt_chat));
            this.doubtData = (DoubtData) getIntent().getSerializableExtra("data");
            this.doubtType = getIntent().getStringExtra("doubtType");
            TextView textView = getBinding().doubtSubject;
            DoubtData doubtData = this.doubtData;
            textView.setText(doubtData != null ? doubtData.getSubject_name() : null);
            TextView textView2 = getBinding().doubtMessage;
            String string = getResources().getString(R.string.your_doubt);
            DoubtData doubtData2 = this.doubtData;
            textView2.setText(string + (doubtData2 != null ? doubtData2.getDoubt_message() : null));
        }
        getBinding().doubtMessage.setMovementMethod(new ScrollingMovementMethod());
        if (StringsKt.equals$default(this.doubtType, "all_doubt", false, 2, null)) {
            getBinding().linearLayoutChat.setVisibility(8);
            getBinding().doubtResolved.setVisibility(8);
            getBinding().doubtUnResolved.setVisibility(8);
        } else {
            DoubtData doubtData3 = this.doubtData;
            if (StringsKt.equals$default(doubtData3 != null ? doubtData3.getIs_complete() : null, "1", false, 2, null)) {
                getBinding().doubtResolved.setVisibility(8);
                getBinding().linearLayoutChat.setVisibility(8);
                getBinding().doubtUnResolved.setVisibility(0);
            } else {
                DoubtData doubtData4 = this.doubtData;
                if (StringsKt.equals$default(doubtData4 != null ? doubtData4.getIs_complete() : null, "0", false, 2, null)) {
                    getBinding().doubtResolved.setVisibility(0);
                    getBinding().linearLayoutChat.setVisibility(0);
                    getBinding().doubtUnResolved.setVisibility(8);
                }
            }
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(doubtChatActivity3);
        linearLayoutManager.setStackFromEnd(true);
        this.layoutManager1 = linearLayoutManager;
        getBinding().doubtReplyRecycler.setLayoutManager(this.layoutManager1);
        DoubtData doubtData5 = this.doubtData;
        Intrinsics.checkNotNull(doubtData5);
        this.adapter = new DoubtChatAdapter(doubtData5.getReply(), doubtChatActivity3);
        getBinding().doubtReplyRecycler.setAdapter(this.adapter);
        getChatData();
        setClicks();
    }

    private final void setupKeyboardInsets() {
        final Ref.IntRef intRef = new Ref.IntRef();
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().getRoot(), new OnApplyWindowInsetsListener() { // from class: com.appnew.android.Zoom.Activity.DoubtChatActivity$$ExternalSyntheticLambda3
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return DoubtChatActivity.setupKeyboardInsets$lambda$2(this.f$0, intRef, view, windowInsetsCompat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat setupKeyboardInsets$lambda$2(final DoubtChatActivity doubtChatActivity, Ref.IntRef intRef, View view, WindowInsetsCompat windowInsets) {
        DoubtData doubtData;
        ArrayList<ReplyModel> reply;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        Insets insets = windowInsets.getInsets(WindowInsetsCompat.Type.ime());
        Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
        Insets insets2 = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
        ViewGroup.LayoutParams layoutParams = doubtChatActivity.getBinding().mainToolbar.getLayoutParams();
        layoutParams.height = ((int) (56 * doubtChatActivity.getResources().getDisplayMetrics().density)) + insets2.top;
        doubtChatActivity.getBinding().mainToolbar.setLayoutParams(layoutParams);
        doubtChatActivity.getBinding().mainToolbar.setPadding(0, insets2.top, 0, 0);
        ViewGroup.LayoutParams layoutParams2 = doubtChatActivity.getBinding().linearLayoutChat.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
        int i = (int) (16 * doubtChatActivity.getResources().getDisplayMetrics().density);
        marginLayoutParams.bottomMargin = (insets.bottom > 0 ? insets.bottom : insets2.bottom) + i;
        marginLayoutParams.leftMargin = i;
        marginLayoutParams.rightMargin = i;
        doubtChatActivity.getBinding().linearLayoutChat.setLayoutParams(marginLayoutParams);
        if (insets.bottom > 0 && intRef.element == 0 && (doubtData = doubtChatActivity.doubtData) != null && (reply = doubtData.getReply()) != null && (!reply.isEmpty())) {
            doubtChatActivity.getBinding().doubtReplyRecycler.postDelayed(new Runnable() { // from class: com.appnew.android.Zoom.Activity.DoubtChatActivity$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    DoubtChatActivity.setupKeyboardInsets$lambda$2$lambda$1(this.f$0);
                }
            }, 100L);
        }
        intRef.element = insets.bottom;
        return windowInsets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupKeyboardInsets$lambda$2$lambda$1(DoubtChatActivity doubtChatActivity) {
        LinearLayoutManager linearLayoutManager = doubtChatActivity.layoutManager1;
        if (linearLayoutManager != null) {
            Intrinsics.checkNotNull(doubtChatActivity.doubtData);
            linearLayoutManager.scrollToPosition(r1.getReply().size() - 1);
        }
    }

    private final void setClicks() {
        getBinding().doubtChatBack.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Activity.DoubtChatActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DoubtChatActivity.setClicks$lambda$3(this.f$0);
            }
        }));
        getBinding().ivSend.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Activity.DoubtChatActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DoubtChatActivity.setClicks$lambda$4(this.f$0);
            }
        }));
        getBinding().doubtResolved.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Activity.DoubtChatActivity$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DoubtChatActivity.setClicks$lambda$5(this.f$0);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClicks$lambda$3(DoubtChatActivity doubtChatActivity) {
        doubtChatActivity.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClicks$lambda$4(DoubtChatActivity doubtChatActivity) {
        if (doubtChatActivity.getBinding().etMessage.getText().toString().length() == 0 || doubtChatActivity.getBinding().etMessage.getText().toString().equals("") || StringsKt.replace$default(doubtChatActivity.getBinding().etMessage.getText().toString(), " ", "", false, 4, (Object) null).length() == 0) {
            DoubtChatActivity doubtChatActivity2 = doubtChatActivity;
            String string = doubtChatActivity.getResources().getString(R.string.type_message);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            XtensionFunctionKt.showSmallLengthToast(doubtChatActivity2, string);
        } else {
            DoubtChatActivity doubtChatActivity3 = doubtChatActivity;
            if (Helper.isNetworkConnected(doubtChatActivity3)) {
                doubtChatActivity.sendChat(false);
            } else {
                Helper.showInternetToast(doubtChatActivity3);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClicks$lambda$5(DoubtChatActivity doubtChatActivity) {
        DoubtChatActivity doubtChatActivity2 = doubtChatActivity;
        if (Helper.isNetworkConnected(doubtChatActivity2)) {
            doubtChatActivity.resolveStatus(false);
        } else {
            Helper.showInternetToast(doubtChatActivity2);
        }
        return Unit.INSTANCE;
    }

    private final void sendChat(boolean showProgress) {
        NetworkCall networkCall = this.networkCall;
        if (networkCall != null) {
            networkCall.NetworkAPICall(API.API_GET_DOUBT_REPLY, "", showProgress, false);
        }
    }

    private final void getChatData() {
        DoubtData doubtData = this.doubtData;
        Intrinsics.checkNotNull(doubtData);
        this.adapter = new DoubtChatAdapter(doubtData.getReply(), this);
        getBinding().doubtReplyRecycler.setAdapter(this.adapter);
        LinearLayoutManager linearLayoutManager = this.layoutManager1;
        if (linearLayoutManager != null) {
            Intrinsics.checkNotNull(this.doubtData);
            linearLayoutManager.scrollToPosition(r1.getReply().size() - 1);
        }
    }

    private final void resolveStatus(boolean showProgress) {
        NetworkCall networkCall = this.networkCall;
        if (networkCall != null) {
            networkCall.NetworkAPICall(API.API_GET_DOUBT_RESOLVE_STATUS, "", showProgress, false);
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        Intrinsics.checkNotNullParameter(service, "service");
        if (Intrinsics.areEqual(apitype, API.API_GET_DOUBT_REPLY)) {
            EncryptionData encryptionData = new EncryptionData();
            DoubtData doubtData = this.doubtData;
            encryptionData.setDoubt_id(doubtData != null ? doubtData.getDoubt_id() : null);
            EditText editText = getBinding().etMessage;
            Intrinsics.checkNotNull(editText);
            encryptionData.setMessage(StringsKt.trim((CharSequence) editText.getText().toString()).toString());
            return service.doubtReply(AES.encrypt(new Gson().toJson(encryptionData)));
        }
        if (!Intrinsics.areEqual(apitype, API.API_GET_DOUBT_RESOLVE_STATUS)) {
            return null;
        }
        EncryptionData encryptionData2 = new EncryptionData();
        DoubtData doubtData2 = this.doubtData;
        encryptionData2.setDoubt_id(doubtData2 != null ? doubtData2.getDoubt_id() : null);
        return service.doubtResolveStatus(AES.encrypt(new Gson().toJson(encryptionData2)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) {
        Intrinsics.checkNotNullParameter(jsonstring, "jsonstring");
        if (Intrinsics.areEqual(apitype, API.API_GET_DOUBT_REPLY)) {
            try {
                Helper.dismissProgressDialog();
                if (jsonstring.getString("status").equals("true")) {
                    ReplyModel replyModel = new ReplyModel();
                    this.replyModel = replyModel;
                    EditText editText = getBinding().etMessage;
                    Intrinsics.checkNotNull(editText);
                    replyModel.setReply(editText.getText().toString());
                    ReplyModel replyModel2 = this.replyModel;
                    if (replyModel2 != null) {
                        replyModel2.setCreated_at(jsonstring.optString("time"));
                    }
                    ReplyModel replyModel3 = this.replyModel;
                    if (replyModel3 != null) {
                        replyModel3.setIs_admin("0");
                    }
                    DoubtData doubtData = this.doubtData;
                    Intrinsics.checkNotNull(doubtData);
                    ArrayList<ReplyModel> reply = doubtData.getReply();
                    DoubtData doubtData2 = this.doubtData;
                    Intrinsics.checkNotNull(doubtData2);
                    reply.add(doubtData2.getReply().size(), this.replyModel);
                    getChatData();
                    EditText editText2 = getBinding().etMessage;
                    Intrinsics.checkNotNull(editText2);
                    editText2.getText().clear();
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
        if (Intrinsics.areEqual(apitype, API.API_GET_DOUBT_RESOLVE_STATUS)) {
            try {
                Helper.dismissProgressDialog();
                if (jsonstring.getString("status").equals("true")) {
                    String string2 = jsonstring.getString("message");
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    XtensionFunctionKt.showSmallLengthToast(this, string2);
                    getBinding().doubtResolved.setVisibility(8);
                    CardView cardView = getBinding().linearLayoutChat;
                    Intrinsics.checkNotNull(cardView);
                    cardView.setVisibility(8);
                    getBinding().doubtUnResolved.setVisibility(0);
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
        if (!Intrinsics.areEqual(apitype, API.API_GET_DOUBT_REPLY) || AllDoubtsFragmentKt.getPaginationLoader() == null) {
            return;
        }
        ProgressBar paginationLoader = AllDoubtsFragmentKt.getPaginationLoader();
        Intrinsics.checkNotNull(paginationLoader);
        if (paginationLoader.isShown()) {
            ProgressBar paginationLoader2 = AllDoubtsFragmentKt.getPaginationLoader();
            Intrinsics.checkNotNull(paginationLoader2);
            paginationLoader2.setVisibility(8);
        }
    }
}
