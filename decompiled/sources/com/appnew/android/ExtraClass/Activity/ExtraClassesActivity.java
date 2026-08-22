package com.appnew.android.ExtraClass.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.ExtraClass.Fragment.ExtraLiveFragment;
import com.appnew.android.ExtraClass.adapters.ExtraClassVPAdapter;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.databinding.ActivityExtraClassesBinding;
import com.appnew.android.home.model.ExtraVideoType;
import com.eduteria.app.app.R;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: ExtraClassesActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J.\u0010#\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010\f2\b\u0010&\u001a\u0004\u0018\u00010\f2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J.\u0010)\u001a\u00020 2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010%\u001a\u0004\u0018\u00010\f2\b\u0010&\u001a\u0004\u0018\u00010\f2\u0006\u0010,\u001a\u00020-H\u0016J&\u0010.\u001a\u00020 2\b\u0010/\u001a\u0004\u0018\u00010\f2\b\u0010%\u001a\u0004\u0018\u00010\f2\b\u0010&\u001a\u0004\u0018\u00010\fH\u0016J\b\u00100\u001a\u00020 H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001aX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u00061"}, d2 = {"Lcom/appnew/android/ExtraClass/Activity/ExtraClassesActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/ActivityExtraClassesBinding;", "getBinding", "()Lcom/appnew/android/databinding/ActivityExtraClassesBinding;", "setBinding", "(Lcom/appnew/android/databinding/ActivityExtraClassesBinding;)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "videoTypeArrayList", "Ljava/util/ArrayList;", "Lcom/appnew/android/home/model/ExtraVideoType;", "Lkotlin/collections/ArrayList;", "getVideoTypeArrayList", "()Ljava/util/ArrayList;", "setVideoTypeArrayList", "(Ljava/util/ArrayList;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonObject", "Lorg/json/JSONObject;", "showprogress", "", "ErrorCallBack", "jsonstring", "onBackPressed", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExtraClassesActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack {
    public static final int $stable = 8;
    public ActivityExtraClassesBinding binding;
    private NetworkCall networkCall;
    private String title;
    public ArrayList<ExtraVideoType> videoTypeArrayList;

    public final ActivityExtraClassesBinding getBinding() {
        ActivityExtraClassesBinding activityExtraClassesBinding = this.binding;
        if (activityExtraClassesBinding != null) {
            return activityExtraClassesBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(ActivityExtraClassesBinding activityExtraClassesBinding) {
        Intrinsics.checkNotNullParameter(activityExtraClassesBinding, "<set-?>");
        this.binding = activityExtraClassesBinding;
    }

    @Override // android.app.Activity
    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final NetworkCall getNetworkCall() {
        return this.networkCall;
    }

    public final void setNetworkCall(NetworkCall networkCall) {
        this.networkCall = networkCall;
    }

    public final ArrayList<ExtraVideoType> getVideoTypeArrayList() {
        ArrayList<ExtraVideoType> arrayList = this.videoTypeArrayList;
        if (arrayList != null) {
            return arrayList;
        }
        Intrinsics.throwUninitializedPropertyAccessException("videoTypeArrayList");
        return null;
    }

    public final void setVideoTypeArrayList(ArrayList<ExtraVideoType> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.videoTypeArrayList = arrayList;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        setBinding(ActivityExtraClassesBinding.inflate(getLayoutInflater()));
        setContentView(getBinding().getRoot());
        setVideoTypeArrayList(new ArrayList<>());
        if (getIntent() != null) {
            this.title = getIntent().getStringExtra("title");
        }
        getBinding().toolbarTitleTV.setText(this.title);
        getBinding().imageBack.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.ExtraClass.Activity.ExtraClassesActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.onBackPressed();
            }
        });
        NetworkCall networkCall = new NetworkCall(this, this);
        this.networkCall = networkCall;
        Intrinsics.checkNotNull(networkCall);
        networkCall.NetworkAPICall(API.API_GET_EXTRA_CLASS_DATA, "", true, false);
        TabLayout tabLayout = getBinding().tabLayoutEC;
        Intrinsics.checkNotNull(tabLayout);
        TabLayout tabLayout2 = getBinding().tabLayoutEC;
        Intrinsics.checkNotNull(tabLayout2);
        tabLayout.addTab(tabLayout2.newTab().setText(getResources().getString(R.string.live)));
        TabLayout tabLayout3 = getBinding().tabLayoutEC;
        Intrinsics.checkNotNull(tabLayout3);
        TabLayout tabLayout4 = getBinding().tabLayoutEC;
        Intrinsics.checkNotNull(tabLayout4);
        tabLayout3.addTab(tabLayout4.newTab().setText(getResources().getString(R.string.vod)));
        TabLayout tabLayout5 = getBinding().tabLayoutEC;
        Intrinsics.checkNotNull(tabLayout5);
        tabLayout5.setTabGravity(0);
        ViewPager viewPager = getBinding().viewPagerEC;
        Intrinsics.checkNotNull(viewPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(getBinding().tabLayoutEC));
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager.beginTransaction(), "beginTransaction(...)");
        new ExtraLiveFragment();
        TabLayout tabLayout6 = getBinding().tabLayoutEC;
        Intrinsics.checkNotNull(tabLayout6);
        tabLayout6.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.appnew.android.ExtraClass.Activity.ExtraClassesActivity.onCreate.2
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
                Intrinsics.checkNotNullParameter(tab, "tab");
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                Intrinsics.checkNotNullParameter(tab, "tab");
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                Intrinsics.checkNotNullParameter(tab, "tab");
                ViewPager viewPager2 = ExtraClassesActivity.this.getBinding().viewPagerEC;
                Intrinsics.checkNotNull(viewPager2);
                viewPager2.setCurrentItem(tab.getPosition());
            }
        });
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        if (!Intrinsics.areEqual(apitype, API.API_GET_EXTRA_CLASS_DATA)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setUser_id(SharedPreference.getInstance().getLoggedInUser().getId());
        String strEncrypt = AES.encrypt(new Gson().toJson(encryptionData));
        Intrinsics.checkNotNull(service);
        return service.getExtraClassData(strEncrypt);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonObject, String apitype, String typeApi, boolean showprogress) {
        if (Intrinsics.areEqual(apitype, API.API_GET_EXTRA_CLASS_DATA)) {
            try {
                Intrinsics.checkNotNull(jsonObject);
                if (Intrinsics.areEqual(jsonObject.optString("status"), "true")) {
                    JSONArray jSONArray = jsonObject.getJSONArray("data");
                    Intrinsics.checkNotNullExpressionValue(jSONArray, "getJSONArray(...)");
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        Object objFromJson = new Gson().fromJson(jSONArray.get(i).toString(), (Class<Object>) ExtraVideoType.class);
                        Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
                        getVideoTypeArrayList().add((ExtraVideoType) objFromJson);
                    }
                }
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                TabLayout tabLayout = getBinding().tabLayoutEC;
                Intrinsics.checkNotNull(tabLayout);
                ExtraClassVPAdapter extraClassVPAdapter = new ExtraClassVPAdapter(this, supportFragmentManager, tabLayout.getTabCount(), getVideoTypeArrayList());
                ViewPager viewPager = getBinding().viewPagerEC;
                Intrinsics.checkNotNull(viewPager);
                viewPager.setAdapter(extraClassVPAdapter);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        Toast.makeText(this, jsonstring, 0).show();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }
}
