package com.appnew.android.UserHistory;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.ExtensionFunctions.XtensionFunctionKt;
import com.appnew.android.Model.contactUsForm.ItemConversation;
import com.appnew.android.Model.contactUsForm.ModelConversation;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.databinding.ActivityConversationReplyBinding;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: ConversationReplyActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\b\u0010&\u001a\u00020#H\u0002J.\u0010'\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010\f2\b\u0010*\u001a\u0004\u0018\u00010\f2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J.\u0010-\u001a\u00020#2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u0010)\u001a\u0004\u0018\u00010\f2\b\u0010*\u001a\u0004\u0018\u00010\f2\u0006\u00100\u001a\u000201H\u0016J&\u00102\u001a\u00020#2\b\u0010.\u001a\u0004\u0018\u00010\f2\b\u0010)\u001a\u0004\u0018\u00010\f2\b\u0010*\u001a\u0004\u0018\u00010\fH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000e\"\u0004\b!\u0010\u0010¨\u00063"}, d2 = {"Lcom/appnew/android/UserHistory/ConversationReplyActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/ActivityConversationReplyBinding;", "getBinding", "()Lcom/appnew/android/databinding/ActivityConversationReplyBinding;", "setBinding", "(Lcom/appnew/android/databinding/ActivityConversationReplyBinding;)V", "conversationId", "", "getConversationId", "()Ljava/lang/String;", "setConversationId", "(Ljava/lang/String;)V", "appId", "getAppId", "setAppId", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "list", "", "Lcom/appnew/android/Model/contactUsForm/ItemConversation;", "adapter", "Lcom/appnew/android/UserHistory/NoteAdapter;", "message", "getMessage", "setMessage", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "saveReply", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "", "ErrorCallBack", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConversationReplyActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack {
    public static final int $stable = 8;
    private NoteAdapter adapter;
    public String appId;
    public ActivityConversationReplyBinding binding;
    public String conversationId;
    private List<ItemConversation> list = new ArrayList();
    public String message;
    public NetworkCall networkCall;

    public final ActivityConversationReplyBinding getBinding() {
        ActivityConversationReplyBinding activityConversationReplyBinding = this.binding;
        if (activityConversationReplyBinding != null) {
            return activityConversationReplyBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(ActivityConversationReplyBinding activityConversationReplyBinding) {
        Intrinsics.checkNotNullParameter(activityConversationReplyBinding, "<set-?>");
        this.binding = activityConversationReplyBinding;
    }

    public final String getConversationId() {
        String str = this.conversationId;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("conversationId");
        return null;
    }

    public final void setConversationId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.conversationId = str;
    }

    public final String getAppId() {
        String str = this.appId;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("appId");
        return null;
    }

    public final void setAppId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appId = str;
    }

    public final NetworkCall getNetworkCall() {
        NetworkCall networkCall = this.networkCall;
        if (networkCall != null) {
            return networkCall;
        }
        Intrinsics.throwUninitializedPropertyAccessException("networkCall");
        return null;
    }

    public final void setNetworkCall(NetworkCall networkCall) {
        Intrinsics.checkNotNullParameter(networkCall, "<set-?>");
        this.networkCall = networkCall;
    }

    public final String getMessage() {
        String str = this.message;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("message");
        return null;
    }

    public final void setMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.message = str;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConversationReplyActivity conversationReplyActivity = this;
        Helper.setSystemBarLight(conversationReplyActivity);
        setBinding(ActivityConversationReplyBinding.inflate(getLayoutInflater()));
        setContentView(getBinding().getRoot());
        Helper.enableScreenShot(conversationReplyActivity);
        Intent intent = getIntent();
        setConversationId(String.valueOf(intent.getStringExtra(Const.CONTATUS_ID)));
        setAppId(String.valueOf(intent.getStringExtra(Const.APP_ID)));
        ConversationReplyActivity conversationReplyActivity2 = this;
        setNetworkCall(new NetworkCall(this, conversationReplyActivity2));
        getNetworkCall().NetworkAPICall(API.GET_CONTACT_US_REPLY_LIST_URL, "", true, false);
        getBinding().replyList.setLayoutManager(new LinearLayoutManager(conversationReplyActivity2, 1, true));
        getBinding().imageBack.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.UserHistory.ConversationReplyActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onBackPressed();
            }
        });
        getBinding().ivSend.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.UserHistory.ConversationReplyActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConversationReplyActivity.onCreate$lambda$2(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(ConversationReplyActivity conversationReplyActivity, View view) {
        Editable text = conversationReplyActivity.getBinding().etMessage.getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        conversationReplyActivity.setMessage(StringsKt.trim(text).toString());
        if (conversationReplyActivity.getMessage().length() != 0) {
            ConversationReplyActivity conversationReplyActivity2 = conversationReplyActivity;
            if (Helper.isNetworkConnected(conversationReplyActivity2)) {
                conversationReplyActivity.saveReply();
                return;
            } else {
                Helper.showInternetToast(conversationReplyActivity2);
                return;
            }
        }
        ConversationReplyActivity conversationReplyActivity3 = conversationReplyActivity;
        String string = conversationReplyActivity.getResources().getString(R.string.enter_your_message);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        XtensionFunctionKt.showSmallLengthToast(conversationReplyActivity3, string);
    }

    private final void saveReply() {
        getNetworkCall().NetworkAPICall(API.SAVE_CONTACT_US_LIST_URL, "", true, false);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        if (Intrinsics.areEqual(apitype, API.GET_CONTACT_US_REPLY_LIST_URL)) {
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setContact_us_id(getConversationId());
            String strEncrypt = AES.encrypt(new Gson().toJson(encryptionData));
            Intrinsics.checkNotNull(service);
            return service.getContactReplyList(strEncrypt);
        }
        if (!Intrinsics.areEqual(apitype, API.SAVE_CONTACT_US_LIST_URL)) {
            return null;
        }
        EncryptionData encryptionData2 = new EncryptionData();
        encryptionData2.setContact_us_id(getConversationId());
        encryptionData2.setMessage(getMessage());
        encryptionData2.setAppId(getAppId());
        encryptionData2.setReply_user_name(SharedPreference.getInstance().getLoggedInUser().getName());
        String strEncrypt2 = AES.encrypt(new Gson().toJson(encryptionData2));
        Intrinsics.checkNotNull(service);
        return service.saveContactReply(strEncrypt2);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) {
        if (Intrinsics.areEqual(apitype, API.GET_CONTACT_US_REPLY_LIST_URL)) {
            try {
                Intrinsics.checkNotNull(jsonstring);
                if (Intrinsics.areEqual(jsonstring.optString("status"), "true")) {
                    ModelConversation modelConversation = (ModelConversation) new Gson().fromJson(jsonstring.toString(), ModelConversation.class);
                    List<ItemConversation> data = modelConversation.getData();
                    if (data != null && !data.isEmpty()) {
                        getBinding().dataNotFoundLL.noDataFoundRL.setVisibility(8);
                        getBinding().replyList.setVisibility(0);
                        List<ItemConversation> data2 = modelConversation.getData();
                        Intrinsics.checkNotNull(data2, "null cannot be cast to non-null type kotlin.collections.MutableList<com.appnew.android.Model.contactUsForm.ItemConversation>");
                        List<ItemConversation> listAsMutableList = TypeIntrinsics.asMutableList(data2);
                        this.list = listAsMutableList;
                        CollectionsKt.reverse(listAsMutableList);
                        NoteAdapter noteAdapter = new NoteAdapter(this);
                        this.adapter = noteAdapter;
                        noteAdapter.submitList(this.list);
                        RecyclerView recyclerView = getBinding().replyList;
                        NoteAdapter noteAdapter2 = this.adapter;
                        if (noteAdapter2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adapter");
                            noteAdapter2 = null;
                        }
                        recyclerView.setAdapter(noteAdapter2);
                        return;
                    }
                    getBinding().dataNotFoundLL.noDataFoundRL.setVisibility(0);
                    getBinding().replyList.setVisibility(0);
                    return;
                }
                ErrorCallBack(jsonstring.getString("message"), apitype, typeApi);
                RetrofitResponse.GetApiData(this, jsonstring.getString("auth_code"), jsonstring.getString("message"), false);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (Intrinsics.areEqual(apitype, API.SAVE_CONTACT_US_LIST_URL)) {
            try {
                Intrinsics.checkNotNull(jsonstring);
                if (Intrinsics.areEqual(jsonstring.optString("status"), "true")) {
                    getBinding().etMessage.setText("");
                    String strOptString = jsonstring.optString("data");
                    Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                    XtensionFunctionKt.showLongLengthToast(this, strOptString);
                    getNetworkCall().NetworkAPICall(API.GET_CONTACT_US_REPLY_LIST_URL, "", true, false);
                    return;
                }
                ErrorCallBack(jsonstring.getString("message"), apitype, typeApi);
                RetrofitResponse.GetApiData(this, jsonstring.getString("auth_code"), jsonstring.getString("message"), false);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        String string = getResources().getString(R.string.something_went_wrong);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        XtensionFunctionKt.showSmallLengthToast(this, string);
    }
}
