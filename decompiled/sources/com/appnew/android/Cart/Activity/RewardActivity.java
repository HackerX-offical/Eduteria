package com.appnew.android.Cart.Activity;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Cart.Adapter.RewardListAdapter;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.ExtensionFunctions.XtensionFunctionKt;
import com.appnew.android.Model.CartModel.RewardModel;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.databinding.ActivityRewardBinding;
import com.google.gson.Gson;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: RewardActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0014J\u0010\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020+H\u0002J,\u0010,\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-2\b\u0010/\u001a\u0004\u0018\u00010.2\b\u00100\u001a\u0004\u0018\u00010.2\u0006\u00101\u001a\u000202H\u0016J,\u00103\u001a\u00020&2\u0006\u00104\u001a\u0002052\b\u0010/\u001a\u0004\u0018\u00010.2\b\u00100\u001a\u0004\u0018\u00010.2\u0006\u00106\u001a\u00020+H\u0017J&\u00107\u001a\u00020&2\b\u00104\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u00010.2\b\u00100\u001a\u0004\u0018\u00010.H\u0016J(\u00108\u001a\u00020&2\u001e\u00109\u001a\u001a\u0012\b\u0012\u00060\u001aR\u00020\u00130\u0019j\f\u0012\b\u0012\u00060\u001aR\u00020\u0013`\u001bH\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0018\u00010\u0012R\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R6\u0010\u0018\u001a\u001e\u0012\b\u0012\u00060\u001aR\u00020\u0013\u0018\u00010\u0019j\u000e\u0012\b\u0012\u00060\u001aR\u00020\u0013\u0018\u0001`\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/appnew/android/Cart/Activity/RewardActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/ActivityRewardBinding;", "getBinding", "()Lcom/appnew/android/databinding/ActivityRewardBinding;", "setBinding", "(Lcom/appnew/android/databinding/ActivityRewardBinding;)V", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "rewardModel", "Lcom/appnew/android/Model/CartModel/RewardModel$Root;", "Lcom/appnew/android/Model/CartModel/RewardModel;", "getRewardModel", "()Lcom/appnew/android/Model/CartModel/RewardModel$Root;", "setRewardModel", "(Lcom/appnew/android/Model/CartModel/RewardModel$Root;)V", "rewordArrayList", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/CartModel/RewardModel$RewardTxn;", "Lkotlin/collections/ArrayList;", "getRewordArrayList", "()Ljava/util/ArrayList;", "setRewordArrayList", "(Ljava/util/ArrayList;)V", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "rewardListAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/Cart/Adapter/RewardListAdapter$ViewHolder;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getRewardPoint", "showProgress", "", "getAPIB", "Lretrofit2/Call;", "", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "ErrorCallBack", "setAdapter", "rewardData", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RewardActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack {
    public static final int $stable = 8;
    public ActivityRewardBinding binding;
    private RecyclerView.LayoutManager layoutManager;
    private NetworkCall networkCall;
    private RecyclerView.Adapter<RewardListAdapter.ViewHolder> rewardListAdapter;
    private RewardModel.Root rewardModel;
    private ArrayList<RewardModel.RewardTxn> rewordArrayList;

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    public final ActivityRewardBinding getBinding() {
        ActivityRewardBinding activityRewardBinding = this.binding;
        if (activityRewardBinding != null) {
            return activityRewardBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(ActivityRewardBinding activityRewardBinding) {
        Intrinsics.checkNotNullParameter(activityRewardBinding, "<set-?>");
        this.binding = activityRewardBinding;
    }

    public final NetworkCall getNetworkCall() {
        return this.networkCall;
    }

    public final void setNetworkCall(NetworkCall networkCall) {
        this.networkCall = networkCall;
    }

    public final RewardModel.Root getRewardModel() {
        return this.rewardModel;
    }

    public final void setRewardModel(RewardModel.Root root) {
        this.rewardModel = root;
    }

    public final ArrayList<RewardModel.RewardTxn> getRewordArrayList() {
        return this.rewordArrayList;
    }

    public final void setRewordArrayList(ArrayList<RewardModel.RewardTxn> arrayList) {
        this.rewordArrayList = arrayList;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBinding(ActivityRewardBinding.inflate(getLayoutInflater()));
        setContentView(getBinding().getRoot());
        this.rewordArrayList = new ArrayList<>();
        getBinding().imageBack.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Cart.Activity.RewardActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RewardActivity.onCreate$lambda$0(this.f$0);
            }
        }));
        RewardActivity rewardActivity = this;
        this.networkCall = new NetworkCall(this, rewardActivity);
        this.layoutManager = new LinearLayoutManager(rewardActivity);
        getBinding().rewardRecyclerView.setLayoutManager(this.layoutManager);
        getRewardPoint(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(RewardActivity rewardActivity) {
        rewardActivity.finish();
        return Unit.INSTANCE;
    }

    private final void getRewardPoint(boolean showProgress) {
        Helper.showProgressDialog(this);
        NetworkCall networkCall = this.networkCall;
        if (networkCall != null) {
            networkCall.NetworkAPICall("https://appapi.videocrypt.in/index.php/data_model/users/get_reward_transaction", "", showProgress, false);
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        Intrinsics.checkNotNullParameter(service, "service");
        if (!Intrinsics.areEqual(apitype, "https://appapi.videocrypt.in/index.php/data_model/users/get_reward_transaction")) {
            return null;
        }
        return service.getRewardPointsNew(AES.encrypt(new Gson().toJson(new EncryptionData())));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonstring, "jsonstring");
        if (Intrinsics.areEqual(apitype, "https://appapi.videocrypt.in/index.php/data_model/users/get_reward_transaction")) {
            try {
                Helper.dismissProgressDialog();
                if (jsonstring.getString("status").equals("true")) {
                    RewardModel.Root root = (RewardModel.Root) new Gson().fromJson(jsonstring.toString(), RewardModel.Root.class);
                    this.rewardModel = root;
                    if (root != null) {
                        ArrayList<RewardModel.RewardTxn> arrayList = this.rewordArrayList;
                        if (arrayList != null) {
                            Intrinsics.checkNotNull(root);
                            arrayList.addAll(root.data.reward_txn);
                        }
                        ArrayList<RewardModel.RewardTxn> arrayList2 = this.rewordArrayList;
                        if (arrayList2 != null) {
                            setAdapter(arrayList2);
                        }
                    }
                    TextView textView = getBinding().rewardPoint;
                    if (textView != null) {
                        RewardModel.Root root2 = this.rewardModel;
                        Intrinsics.checkNotNull(root2);
                        textView.setText(root2.data.reward_total.count);
                    }
                    RelativeLayout relativeLayout = getBinding().noDataFoundRL;
                    Intrinsics.checkNotNull(relativeLayout);
                    relativeLayout.setVisibility(8);
                    return;
                }
                RelativeLayout relativeLayout2 = getBinding().noDataFoundRL;
                Intrinsics.checkNotNull(relativeLayout2);
                relativeLayout2.setVisibility(0);
                String string = jsonstring.getString("message");
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                XtensionFunctionKt.showSmallLengthToast(this, string);
            } catch (Exception unused) {
                String string2 = jsonstring.getString("message");
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                XtensionFunctionKt.showSmallLengthToast(this, string2);
            }
        }
    }

    private final void setAdapter(ArrayList<RewardModel.RewardTxn> rewardData) {
        this.rewardListAdapter = new RewardListAdapter(rewardData, this);
        getBinding().rewardRecyclerView.setAdapter(this.rewardListAdapter);
    }
}
