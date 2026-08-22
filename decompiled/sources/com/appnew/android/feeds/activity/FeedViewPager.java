package com.appnew.android.feeds.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.databinding.ActivityFeedViewPagerBinding;
import com.appnew.android.feeds.adapters.FeedViewPagerAdapter;
import com.appnew.android.table.BannerListTable;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: FeedViewPager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J,\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001b0+2\b\u0010,\u001a\u0004\u0018\u00010\u001b2\b\u0010-\u001a\u0004\u0018\u00010\u001b2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J.\u00100\u001a\u00020'2\b\u00101\u001a\u0004\u0018\u0001022\b\u0010,\u001a\u0004\u0018\u00010\u001b2\b\u0010-\u001a\u0004\u0018\u00010\u001b2\u0006\u00103\u001a\u000204H\u0016J&\u00105\u001a\u00020'2\b\u00101\u001a\u0004\u0018\u00010\u001b2\b\u0010,\u001a\u0004\u0018\u00010\u001b2\b\u0010-\u001a\u0004\u0018\u00010\u001bH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u00066"}, d2 = {"Lcom/appnew/android/feeds/activity/FeedViewPager;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/ActivityFeedViewPagerBinding;", "getBinding", "()Lcom/appnew/android/databinding/ActivityFeedViewPagerBinding;", "setBinding", "(Lcom/appnew/android/databinding/ActivityFeedViewPagerBinding;)V", "bannerListTableList", "", "Lcom/appnew/android/table/BannerListTable;", "getBannerListTableList", "()Ljava/util/List;", "setBannerListTableList", "(Ljava/util/List;)V", "bannerListTableListUsable", "getBannerListTableListUsable", "utkashRoom", "Lcom/appnew/android/Room/UtkashRoom;", "getUtkashRoom", "()Lcom/appnew/android/Room/UtkashRoom;", "setUtkashRoom", "(Lcom/appnew/android/Room/UtkashRoom;)V", "bannerId", "", "getBannerId", "()Ljava/lang/String;", "setBannerId", "(Ljava/lang/String;)V", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "", "ErrorCallBack", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedViewPager extends AppCompatActivity implements NetworkCall.MyNetworkCallBack {
    public static final int $stable = 8;
    public String bannerId;
    public List<BannerListTable> bannerListTableList;
    private final List<BannerListTable> bannerListTableListUsable = new ArrayList();
    public ActivityFeedViewPagerBinding binding;
    public NetworkCall networkCall;
    public UtkashRoom utkashRoom;

    public final ActivityFeedViewPagerBinding getBinding() {
        ActivityFeedViewPagerBinding activityFeedViewPagerBinding = this.binding;
        if (activityFeedViewPagerBinding != null) {
            return activityFeedViewPagerBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(ActivityFeedViewPagerBinding activityFeedViewPagerBinding) {
        Intrinsics.checkNotNullParameter(activityFeedViewPagerBinding, "<set-?>");
        this.binding = activityFeedViewPagerBinding;
    }

    public final List<BannerListTable> getBannerListTableList() {
        List<BannerListTable> list = this.bannerListTableList;
        if (list != null) {
            return list;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bannerListTableList");
        return null;
    }

    public final void setBannerListTableList(List<BannerListTable> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.bannerListTableList = list;
    }

    public final List<BannerListTable> getBannerListTableListUsable() {
        return this.bannerListTableListUsable;
    }

    public final UtkashRoom getUtkashRoom() {
        UtkashRoom utkashRoom = this.utkashRoom;
        if (utkashRoom != null) {
            return utkashRoom;
        }
        Intrinsics.throwUninitializedPropertyAccessException("utkashRoom");
        return null;
    }

    public final void setUtkashRoom(UtkashRoom utkashRoom) {
        Intrinsics.checkNotNullParameter(utkashRoom, "<set-?>");
        this.utkashRoom = utkashRoom;
    }

    public final String getBannerId() {
        String str = this.bannerId;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bannerId");
        return null;
    }

    public final void setBannerId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bannerId = str;
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
        setBinding(ActivityFeedViewPagerBinding.inflate(getLayoutInflater()));
        setContentView(getBinding().getRoot());
        FeedViewPager feedViewPager = this;
        setUtkashRoom(UtkashRoom.getAppDatabase(feedViewPager));
        setNetworkCall(new NetworkCall(this, feedViewPager));
        Intent intent = getIntent();
        if (intent.hasExtra("bannerId")) {
            setBannerId(String.valueOf(intent.getStringExtra("bannerId")));
        }
        getNetworkCall().NetworkAPICall(API.BANNER_FEED, "", true, false);
        getBinding().backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.activity.FeedViewPager$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.finish();
            }
        });
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setId(getBannerId());
        String strEncrypt = AES.encrypt(new Gson().toJson(encryptionData));
        Intrinsics.checkNotNull(service);
        return service.getBannerFeed(strEncrypt);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) {
        Intrinsics.checkNotNull(jsonstring);
        if (jsonstring.optBoolean("status")) {
            if (jsonstring.has("data")) {
                this.bannerListTableListUsable.clear();
                Object objFromJson = new Gson().fromJson(jsonstring.optJSONObject("data").toString(), (Class<Object>) BannerListTable.class);
                Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
                this.bannerListTableListUsable.add((BannerListTable) objFromJson);
            }
            ActivityFeedViewPagerBinding binding = getBinding();
            FeedViewPager feedViewPager = this;
            binding.bannerSlider.setLayoutManager(new LinearLayoutManager(feedViewPager));
            binding.bannerSlider.setAdapter(new FeedViewPagerAdapter(feedViewPager, this, this.bannerListTableListUsable));
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
