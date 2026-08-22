package com.appnew.android.UserHistory;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.ExtensionFunctions.XtensionFunctionKt;
import com.appnew.android.Model.contactUsForm.ItemConversation;
import com.appnew.android.Model.contactUsForm.ModelConversation;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.databinding.ActivityViewConversationPageBinding;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: ViewConversationPage.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0015H\u0002J.\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u001e2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J.\u0010#\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u001e2\u0006\u0010&\u001a\u00020'H\u0016J&\u0010(\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u001eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/appnew/android/UserHistory/ViewConversationPage;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "<init>", "()V", "adapter", "Lcom/appnew/android/UserHistory/NoteAdapter;", "binding", "Lcom/appnew/android/databinding/ActivityViewConversationPageBinding;", "getBinding", "()Lcom/appnew/android/databinding/ActivityViewConversationPageBinding;", "setBinding", "(Lcom/appnew/android/databinding/ActivityViewConversationPageBinding;)V", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "list", "", "Lcom/appnew/android/Model/contactUsForm/ItemConversation;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNoteClicked", "itemConversation", "getAPIB", "Lretrofit2/Call;", "", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "", "ErrorCallBack", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ViewConversationPage extends AppCompatActivity implements NetworkCall.MyNetworkCallBack {
    public static final int $stable = 8;
    private NoteAdapter adapter;
    public ActivityViewConversationPageBinding binding;
    private List<ItemConversation> list = new ArrayList();
    public NetworkCall networkCall;

    private final void onNoteClicked(ItemConversation itemConversation) {
    }

    public final ActivityViewConversationPageBinding getBinding() {
        ActivityViewConversationPageBinding activityViewConversationPageBinding = this.binding;
        if (activityViewConversationPageBinding != null) {
            return activityViewConversationPageBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(ActivityViewConversationPageBinding activityViewConversationPageBinding) {
        Intrinsics.checkNotNullParameter(activityViewConversationPageBinding, "<set-?>");
        this.binding = activityViewConversationPageBinding;
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

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewConversationPage viewConversationPage = this;
        Helper.setSystemBarLight(viewConversationPage);
        Helper.enableScreenShot(viewConversationPage);
        setBinding(ActivityViewConversationPageBinding.inflate(getLayoutInflater()));
        setContentView(getBinding().getRoot());
        getBinding().toolbarTitleTV.setText(getResources().getString(R.string.conversations));
        getBinding().imageBack.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.UserHistory.ViewConversationPage$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onBackPressed();
            }
        });
        ViewConversationPage viewConversationPage2 = this;
        setNetworkCall(new NetworkCall(this, viewConversationPage2));
        getNetworkCall().NetworkAPICall(API.GET_CONTACT_US_LIST_URL, "", true, false);
        getBinding().noteList.setLayoutManager(new LinearLayoutManager(viewConversationPage2));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        if (!Intrinsics.areEqual(apitype, API.GET_CONTACT_US_LIST_URL) || service == null) {
            return null;
        }
        return service.getContactList();
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) {
        if (Intrinsics.areEqual(apitype, API.GET_CONTACT_US_LIST_URL)) {
            try {
                Intrinsics.checkNotNull(jsonstring);
                if (Intrinsics.areEqual(jsonstring.optString("status"), "true")) {
                    ModelConversation modelConversation = (ModelConversation) new Gson().fromJson(jsonstring.toString(), ModelConversation.class);
                    List<ItemConversation> data = modelConversation.getData();
                    if (data != null && !data.isEmpty()) {
                        getBinding().dataNotFoundLL.noDataFoundRL.setVisibility(8);
                        getBinding().noteList.setVisibility(0);
                        this.list = modelConversation.getData();
                        NoteAdapter noteAdapter = new NoteAdapter(this);
                        this.adapter = noteAdapter;
                        noteAdapter.submitList(this.list);
                        RecyclerView recyclerView = getBinding().noteList;
                        NoteAdapter noteAdapter2 = this.adapter;
                        if (noteAdapter2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adapter");
                            noteAdapter2 = null;
                        }
                        recyclerView.setAdapter(noteAdapter2);
                        return;
                    }
                    getBinding().dataNotFoundLL.noDataFoundRL.setVisibility(0);
                    getBinding().noteList.setVisibility(8);
                    return;
                }
                ErrorCallBack(jsonstring.getString("message"), apitype, typeApi);
                RetrofitResponse.GetApiData(this, jsonstring.getString("auth_code"), jsonstring.getString("message"), false);
            } catch (Exception e2) {
                e2.printStackTrace();
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
