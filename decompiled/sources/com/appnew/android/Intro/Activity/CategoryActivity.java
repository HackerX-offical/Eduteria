package com.appnew.android.Intro.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.app.NotificationCompat;
import com.appnew.android.BuildConfig;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Theme.DashboardActivityTheme1;
import com.appnew.android.Theme.DashboardActivityTheme2;
import com.appnew.android.Theme.DashboardActivityTheme3;
import com.appnew.android.Theme.DashboardActivityTheme4;
import com.appnew.android.Theme.DashboardActivityTheme5;
import com.appnew.android.Theme.DashboardActivityTheme7;
import com.appnew.android.Theme.DashboardActivityTheme8;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.databinding.ActivityCategoryBinding;
import com.appnew.android.feeds.ExtensionFucationKt;
import com.appnew.android.pojo.Userinfo.Data;
import com.appnew.android.table.APITABLE;
import com.appnew.android.table.MasteAllCatTable;
import com.appnew.android.table.MasterCat;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: CategoryActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010W\u001a\u00020X2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0014J\b\u0010[\u001a\u00020XH\u0002J\u0006\u0010\\\u001a\u00020XJ.\u0010]\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010^2\b\u0010_\u001a\u0004\u0018\u00010\u00132\b\u0010`\u001a\u0004\u0018\u00010\u00132\u0006\u0010a\u001a\u00020bH\u0016J.\u0010c\u001a\u00020X2\b\u0010d\u001a\u0004\u0018\u00010e2\b\u0010_\u001a\u0004\u0018\u00010\u00132\b\u0010`\u001a\u0004\u0018\u00010\u00132\u0006\u0010f\u001a\u00020SH\u0016J&\u0010g\u001a\u00020X2\b\u0010h\u001a\u0004\u0018\u00010\u00132\b\u0010_\u001a\u0004\u0018\u00010\u00132\b\u0010`\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010i\u001a\u00020S2\b\u0010j\u001a\u0004\u0018\u00010kH\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R!\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R\u001a\u0010&\u001a\u00020'X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R*\u0010,\u001a\u0012\u0012\u0004\u0012\u00020-0\u0018j\b\u0012\u0004\u0012\u00020-`\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001c\"\u0004\b/\u00100R\u001e\u00101\u001a\u0012\u0012\u0004\u0012\u00020-0\u0018j\b\u0012\u0004\u0012\u00020-`\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00102\u001a\u0012\u0012\u0004\u0012\u00020-0\u0018j\b\u0012\u0004\u0012\u00020-`\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00103\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0014\"\u0004\b5\u0010\u0016R\u001a\u00106\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0014\"\u0004\b8\u0010\u0016R\u001a\u00109\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0014\"\u0004\b;\u0010\u0016R\u001a\u0010<\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0014\"\u0004\b>\u0010\u0016R\u001a\u0010?\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0014\"\u0004\bA\u0010\u0016R\u001a\u0010B\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0014\"\u0004\bD\u0010\u0016R\u001a\u0010E\u001a\u00020FX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR*\u0010K\u001a\u0012\u0012\u0004\u0012\u00020L0\u0018j\b\u0012\u0004\u0012\u00020L`\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u001c\"\u0004\bN\u00100R*\u0010O\u001a\u0012\u0012\u0004\u0012\u00020L0\u0018j\b\u0012\u0004\u0012\u00020L`\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u001c\"\u0004\bQ\u00100R\u001a\u0010R\u001a\u00020SX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010T\"\u0004\bU\u0010V¨\u0006l"}, d2 = {"Lcom/appnew/android/Intro/Activity/CategoryActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "Landroidx/appcompat/widget/PopupMenu$OnMenuItemClickListener;", "<init>", "()V", "popUp", "Landroid/widget/PopupWindow;", "getPopUp", "()Landroid/widget/PopupWindow;", "setPopUp", "(Landroid/widget/PopupWindow;)V", "data", "Lcom/appnew/android/pojo/Userinfo/Data;", "getData", "()Lcom/appnew/android/pojo/Userinfo/Data;", "setData", "(Lcom/appnew/android/pojo/Userinfo/Data;)V", "is_lang", "", "()Ljava/lang/String;", "set_lang", "(Ljava/lang/String;)V", "prefencelist", "Ljava/util/ArrayList;", "Lcom/appnew/android/pojo/Userinfo/Data$Preferences;", "Lkotlin/collections/ArrayList;", "getPrefencelist", "()Ljava/util/ArrayList;", "utkashRoom", "Lcom/appnew/android/Room/UtkashRoom;", "getUtkashRoom", "()Lcom/appnew/android/Room/UtkashRoom;", "setUtkashRoom", "(Lcom/appnew/android/Room/UtkashRoom;)V", "subids", "getSubids", "setSubids", "binding", "Lcom/appnew/android/databinding/ActivityCategoryBinding;", "getBinding", "()Lcom/appnew/android/databinding/ActivityCategoryBinding;", "setBinding", "(Lcom/appnew/android/databinding/ActivityCategoryBinding;)V", "masterAllCatTables", "Lcom/appnew/android/table/MasteAllCatTable;", "getMasterAllCatTables", "setMasterAllCatTables", "(Ljava/util/ArrayList;)V", "selected_master_cat", "selectedsub_all_cat", "mastercatid", "getMastercatid", "setMastercatid", "mastercatname", "getMastercatname", "setMastercatname", "allcatindex", "getAllcatindex", "setAllcatindex", "allcatindex_id", "getAllcatindex_id", "setAllcatindex_id", "allsubcatindex", "getAllsubcatindex", "setAllsubcatindex", "allsubcatindex_id", "getAllsubcatindex_id", "setAllsubcatindex_id", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "mastercatlist", "Lcom/appnew/android/table/MasterCat;", "getMastercatlist", "setMastercatlist", "temporaryCatList", "getTemporaryCatList", "setTemporaryCatList", "isFromEmptyPreference", "", "()Z", "setFromEmptyPreference", "(Z)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "updatePreferenceName", "hit_api_master_data", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonObject", "Lorg/json/JSONObject;", "showprogress", "ErrorCallBack", "jsonstring", "onMenuItemClick", "item", "Landroid/view/MenuItem;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CategoryActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack, PopupMenu.OnMenuItemClickListener {
    public static final int $stable = 8;
    public ActivityCategoryBinding binding;
    private Data data;
    private boolean isFromEmptyPreference;
    public NetworkCall networkCall;
    private PopupWindow popUp;
    private UtkashRoom utkashRoom;
    private String is_lang = "";
    private final ArrayList<Data.Preferences> prefencelist = new ArrayList<>();
    private String subids = "";
    private ArrayList<MasteAllCatTable> masterAllCatTables = new ArrayList<>();
    private ArrayList<MasteAllCatTable> selected_master_cat = new ArrayList<>();
    private ArrayList<MasteAllCatTable> selectedsub_all_cat = new ArrayList<>();
    private String mastercatid = "";
    private String mastercatname = "";
    private String allcatindex = "";
    private String allcatindex_id = "";
    private String allsubcatindex = "";
    private String allsubcatindex_id = "";
    private ArrayList<MasterCat> mastercatlist = new ArrayList<>();
    private ArrayList<MasterCat> temporaryCatList = new ArrayList<>();

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    public final PopupWindow getPopUp() {
        return this.popUp;
    }

    public final void setPopUp(PopupWindow popupWindow) {
        this.popUp = popupWindow;
    }

    public final Data getData() {
        return this.data;
    }

    public final void setData(Data data) {
        this.data = data;
    }

    /* JADX INFO: renamed from: is_lang, reason: from getter */
    public final String getIs_lang() {
        return this.is_lang;
    }

    public final void set_lang(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.is_lang = str;
    }

    public final ArrayList<Data.Preferences> getPrefencelist() {
        return this.prefencelist;
    }

    public final UtkashRoom getUtkashRoom() {
        return this.utkashRoom;
    }

    public final void setUtkashRoom(UtkashRoom utkashRoom) {
        this.utkashRoom = utkashRoom;
    }

    public final String getSubids() {
        return this.subids;
    }

    public final void setSubids(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subids = str;
    }

    public final ActivityCategoryBinding getBinding() {
        ActivityCategoryBinding activityCategoryBinding = this.binding;
        if (activityCategoryBinding != null) {
            return activityCategoryBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(ActivityCategoryBinding activityCategoryBinding) {
        Intrinsics.checkNotNullParameter(activityCategoryBinding, "<set-?>");
        this.binding = activityCategoryBinding;
    }

    public final ArrayList<MasteAllCatTable> getMasterAllCatTables() {
        return this.masterAllCatTables;
    }

    public final void setMasterAllCatTables(ArrayList<MasteAllCatTable> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.masterAllCatTables = arrayList;
    }

    public final String getMastercatid() {
        return this.mastercatid;
    }

    public final void setMastercatid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mastercatid = str;
    }

    public final String getMastercatname() {
        return this.mastercatname;
    }

    public final void setMastercatname(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mastercatname = str;
    }

    public final String getAllcatindex() {
        return this.allcatindex;
    }

    public final void setAllcatindex(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.allcatindex = str;
    }

    public final String getAllcatindex_id() {
        return this.allcatindex_id;
    }

    public final void setAllcatindex_id(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.allcatindex_id = str;
    }

    public final String getAllsubcatindex() {
        return this.allsubcatindex;
    }

    public final void setAllsubcatindex(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.allsubcatindex = str;
    }

    public final String getAllsubcatindex_id() {
        return this.allsubcatindex_id;
    }

    public final void setAllsubcatindex_id(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.allsubcatindex_id = str;
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

    public final ArrayList<MasterCat> getMastercatlist() {
        return this.mastercatlist;
    }

    public final void setMastercatlist(ArrayList<MasterCat> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.mastercatlist = arrayList;
    }

    public final ArrayList<MasterCat> getTemporaryCatList() {
        return this.temporaryCatList;
    }

    public final void setTemporaryCatList(ArrayList<MasterCat> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.temporaryCatList = arrayList;
    }

    /* JADX INFO: renamed from: isFromEmptyPreference, reason: from getter */
    public final boolean getIsFromEmptyPreference() {
        return this.isFromEmptyPreference;
    }

    public final void setFromEmptyPreference(boolean z) {
        this.isFromEmptyPreference = z;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBinding(ActivityCategoryBinding.inflate(getLayoutInflater()));
        Intent intent = getIntent();
        if (intent.hasExtra("is_preference_empty")) {
            this.isFromEmptyPreference = intent.getBooleanExtra("is_preference_empty", false);
        }
        setContentView(getBinding().getRoot());
        CategoryActivity categoryActivity = this;
        this.utkashRoom = UtkashRoom.getAppDatabase(categoryActivity);
        setNetworkCall(new NetworkCall(this, categoryActivity));
        hit_api_master_data();
        getBinding().titleinnerRL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Intro.Activity.CategoryActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CategoryActivity.onCreate$lambda$1(this.f$0, view);
            }
        });
        getBinding().nextLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Intro.Activity.CategoryActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CategoryActivity.onCreate$lambda$2(this.f$0, view);
            }
        });
        if (StringsKt.equals("1", "7", true)) {
            if (this.isFromEmptyPreference) {
                getBinding().textViewUP.setText(getResources().getString(R.string.lets_begin));
            } else {
                getBinding().textViewUP.setText(getResources().getString(R.string.update_preference));
            }
        }
        if (StringsKt.equals("1", "1", true) && StringsKt.equals(BuildConfig.FLAVOR, "DishaPublication", true)) {
            if (this.isFromEmptyPreference) {
                getBinding().textViewUP.setText(getResources().getString(R.string.lets_begin));
            } else {
                getBinding().textViewUP.setText(getResources().getString(R.string.update_preference));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(CategoryActivity categoryActivity, View view) {
        CategoryActivity categoryActivity2 = categoryActivity;
        if (!Helper.isNetworkConnected(categoryActivity2)) {
            Helper.showInternetToast(categoryActivity2);
            return;
        }
        PopupMenu popupMenu = new PopupMenu(categoryActivity2, categoryActivity.getBinding().toolbartitleTV, 3);
        int size = categoryActivity.temporaryCatList.size();
        for (int i = 0; i < size; i++) {
            popupMenu.getMenu().add(categoryActivity.temporaryCatList.get(i).getCat());
        }
        popupMenu.setOnMenuItemClickListener(categoryActivity);
        popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(CategoryActivity categoryActivity, View view) {
        if (!TextUtils.isEmpty(categoryActivity.subids)) {
            categoryActivity.getNetworkCall().NetworkAPICall(API.update_preference, "", true, false);
        } else {
            ExtensionFucationKt.showToast(categoryActivity, "Please Select Courses");
        }
    }

    private final void updatePreferenceName() {
        String string = SharedPreference.getInstance().getString("sub_cat_ids");
        int size = this.temporaryCatList.size();
        for (int i = 0; i < size; i++) {
            if (this.temporaryCatList.get(i).getId().equals(string)) {
                getBinding().toolbartitleTV.setText(this.temporaryCatList.get(i).getCat());
            }
        }
    }

    public final void hit_api_master_data() {
        getNetworkCall().NetworkAPICall(API.master_content, "", true, false);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        Intrinsics.checkNotNullParameter(service, "service");
        if (Intrinsics.areEqual(apitype, API.master_content)) {
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setUser_id(MakeMyExam.getUserId());
            return service.master_content(AES.encrypt(new Gson().toJson(encryptionData)));
        }
        if (!Intrinsics.areEqual(apitype, API.update_preference)) {
            return null;
        }
        EncryptionData encryptionData2 = new EncryptionData();
        encryptionData2.setSub_cat_ids(this.subids);
        encryptionData2.setLang("0");
        return service.update_preference(AES.encrypt(new Gson().toJson(encryptionData2)));
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x02a0 -> B:88:0x02ea). Please report as a decompilation issue!!! */
    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonObject, String apitype, String typeApi, boolean showprogress) {
        Intent intent;
        JSONArray jSONArrayOptJSONArray;
        if (Intrinsics.areEqual(apitype, API.update_preference)) {
            try {
                Intrinsics.checkNotNull(jsonObject);
                if (Intrinsics.areEqual(jsonObject.optString("status"), "true")) {
                    if (StringsKt.equals("1", "1", true)) {
                        intent = new Intent(this, (Class<?>) DashboardActivityTheme1.class);
                    } else if (StringsKt.equals("1", "2", true)) {
                        intent = new Intent(this, (Class<?>) DashboardActivityTheme2.class);
                    } else if (StringsKt.equals("1", "3", true)) {
                        intent = new Intent(this, (Class<?>) DashboardActivityTheme3.class);
                    } else if (StringsKt.equals("1", "4", true)) {
                        intent = new Intent(this, (Class<?>) DashboardActivityTheme4.class);
                    } else if (StringsKt.equals("1", "5", true)) {
                        intent = new Intent(this, (Class<?>) DashboardActivityTheme5.class);
                    } else if (StringsKt.equals("1", "6", true)) {
                        intent = new Intent(this, (Class<?>) DashboardActivityTheme7.class);
                    } else if (StringsKt.equals("1", "7", true)) {
                        intent = new Intent(this, (Class<?>) DashboardActivityTheme8.class);
                    } else {
                        intent = new Intent(this, (Class<?>) DashboardActivityTheme8.class);
                    }
                    intent.setFlags(268468224);
                    Bundle bundle = new Bundle();
                    this.data = SharedPreference.getInstance().getLoggedInUser();
                    SharedPreference.getInstance().putString("sub_cat_ids", this.mastercatid);
                    Data data = this.data;
                    if (data != null) {
                        data.setPreferences(this.prefencelist);
                    }
                    Data data2 = this.data;
                    if (data2 != null) {
                        data2.setLang("0");
                    }
                    SharedPreference.getInstance().setLoggedInUserr(this.data);
                    intent.putExtras(bundle);
                    Helper.gotoActivity_finish(intent, this);
                    return;
                }
                RetrofitResponse.GetApiData(this, jsonObject.has("auth_code") ? jsonObject.getString("auth_code") : "", jsonObject.getString("message"), false);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (Intrinsics.areEqual(apitype, API.master_content)) {
            try {
                Intrinsics.checkNotNull(jsonObject);
                if (Intrinsics.areEqual(jsonObject.optString("status"), "true")) {
                    JSONObject jSONObject = jsonObject.getJSONObject("data");
                    Intrinsics.checkNotNullExpressionValue(jSONObject, "getJSONObject(...)");
                    try {
                        UtkashRoom utkashRoom = this.utkashRoom;
                        Intrinsics.checkNotNull(utkashRoom);
                        utkashRoom.getcoursetypemaster().deletedata();
                        UtkashRoom utkashRoom2 = this.utkashRoom;
                        Intrinsics.checkNotNull(utkashRoom2);
                        utkashRoom2.getLaunguages().deletedata();
                        UtkashRoom utkashRoom3 = this.utkashRoom;
                        Intrinsics.checkNotNull(utkashRoom3);
                        utkashRoom3.getMasterAllCatDao().deletedata();
                        UtkashRoom utkashRoom4 = this.utkashRoom;
                        Intrinsics.checkNotNull(utkashRoom4);
                        utkashRoom4.getMastercatDao().deletedata();
                        this.masterAllCatTables.clear();
                        this.mastercatlist.clear();
                        this.selectedsub_all_cat.clear();
                        this.selected_master_cat.clear();
                        if (jSONObject.has("master_cat")) {
                            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("master_cat");
                            Intrinsics.checkNotNullExpressionValue(jSONArrayOptJSONArray2, "optJSONArray(...)");
                            if (jSONArrayOptJSONArray2.length() > 0) {
                                int length = jSONArrayOptJSONArray2.length();
                                for (int i = 0; i < length; i++) {
                                    MasterCat masterCat = (MasterCat) new Gson().fromJson(jSONArrayOptJSONArray2.get(i).toString(), MasterCat.class);
                                    masterCat.setUser_id(MakeMyExam.userId);
                                    this.mastercatlist.add(masterCat);
                                }
                            }
                        }
                        if (jSONObject.has("all_cat") && (jSONArrayOptJSONArray = jSONObject.optJSONArray("all_cat")) != null && jSONArrayOptJSONArray.length() > 0) {
                            int length2 = jSONArrayOptJSONArray.length();
                            for (int i2 = 0; i2 < length2; i2++) {
                                MasteAllCatTable masteAllCatTable = (MasteAllCatTable) new Gson().fromJson(jSONArrayOptJSONArray.get(i2).toString(), MasteAllCatTable.class);
                                masteAllCatTable.setUser_id(MakeMyExam.userId);
                                this.masterAllCatTables.add(masteAllCatTable);
                            }
                        }
                        this.temporaryCatList.clear();
                        this.temporaryCatList = Helper.createPreferencesFromMasterCat(this.mastercatlist, this.masterAllCatTables);
                        if (StringsKt.equals(BuildConfig.FLAVOR, "DishaPublication", true)) {
                            updatePreferenceName();
                        }
                        try {
                            UtkashRoom utkashRoom5 = this.utkashRoom;
                            Intrinsics.checkNotNull(utkashRoom5);
                            if (utkashRoom5.getapidao().is_api_code_exits(MakeMyExam.userId, "ut_009")) {
                                UtkashRoom utkashRoom6 = this.utkashRoom;
                                Intrinsics.checkNotNull(utkashRoom6);
                                utkashRoom6.getapidao().update_api_version("ut_009", MakeMyExam.userId, String.valueOf(jsonObject.optLong("time")), String.valueOf(jsonObject.optLong("interval")), String.valueOf(jsonObject.optLong("cd_time")));
                                Unit unit = Unit.INSTANCE;
                            } else {
                                APITABLE apitable = new APITABLE();
                                apitable.setApicode("ut_009");
                                apitable.setApiname("master_content");
                                apitable.setInterval(String.valueOf(jsonObject.optLong("interval")));
                                apitable.setUser_id(MakeMyExam.userId);
                                apitable.setTimestamp(String.valueOf(jsonObject.optLong("time")));
                                apitable.setCdtimestamp(String.valueOf(jsonObject.optLong("cd_time")));
                                apitable.setVersion("0.000");
                                UtkashRoom utkashRoom7 = this.utkashRoom;
                                Intrinsics.checkNotNull(utkashRoom7);
                                Long.valueOf(utkashRoom7.getapidao().addUser(apitable));
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            Unit unit2 = Unit.INSTANCE;
                        }
                        return;
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        Unit unit3 = Unit.INSTANCE;
                        return;
                    }
                }
                RetrofitResponse.GetApiData(this, jsonObject.has("auth_code") ? jsonObject.getString("auth_code") : "", jsonObject.getString("message"), false);
            } catch (Exception e5) {
                ErrorCallBack(e5.getMessage() + " : " + e5.getLocalizedMessage(), apitype, typeApi);
                e5.printStackTrace();
            }
        }
    }

    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem item) {
        Intrinsics.checkNotNull(item);
        if (!Intrinsics.areEqual(item.getTitle(), this.mastercatname)) {
            Iterator<MasterCat> it = this.temporaryCatList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MasterCat next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                MasterCat masterCat = next;
                if (Intrinsics.areEqual(masterCat.getCat(), item.getTitle())) {
                    this.mastercatname = String.valueOf(item.getTitle());
                    this.mastercatid = masterCat.getId();
                    getBinding().toolbartitleTV.setText(item.getTitle());
                    this.allcatindex = "";
                    this.allcatindex_id = "";
                    this.allsubcatindex = "";
                    this.allsubcatindex_id = "";
                    this.selectedsub_all_cat.clear();
                    this.selected_master_cat.clear();
                    Iterator<MasteAllCatTable> it2 = this.masterAllCatTables.iterator();
                    Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                    while (it2.hasNext()) {
                        MasteAllCatTable next2 = it2.next();
                        Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                        MasteAllCatTable masteAllCatTable = next2;
                        if (Intrinsics.areEqual(masteAllCatTable.getMaster_type(), this.mastercatid) && StringsKt.equals(masteAllCatTable.getParent_id(), "0", true)) {
                            this.selected_master_cat.add(masteAllCatTable);
                        }
                    }
                    if (this.selected_master_cat.size() > 0) {
                        this.allcatindex = this.selected_master_cat.get(0).getName();
                        this.allcatindex_id = this.selected_master_cat.get(0).getId();
                        Iterator<MasteAllCatTable> it3 = this.masterAllCatTables.iterator();
                        Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
                        while (true) {
                            if (!it3.hasNext()) {
                                break;
                            }
                            MasteAllCatTable next3 = it3.next();
                            Intrinsics.checkNotNullExpressionValue(next3, "next(...)");
                            MasteAllCatTable masteAllCatTable2 = next3;
                            if (StringsKt.equals(this.allcatindex_id, masteAllCatTable2.getParent_id(), true)) {
                                this.selectedsub_all_cat.add(masteAllCatTable2);
                                this.prefencelist.clear();
                                Data.Preferences preferences = new Data.Preferences();
                                preferences.setMain_cat(masteAllCatTable2.getParent_id());
                                preferences.setSub_cat(masteAllCatTable2.getId());
                                this.subids = masteAllCatTable2.getId();
                                this.prefencelist.add(preferences);
                                break;
                            }
                        }
                        if (this.selectedsub_all_cat.size() > 0) {
                            this.allsubcatindex = this.selectedsub_all_cat.get(0).getName();
                            this.allsubcatindex_id = this.selectedsub_all_cat.get(0).getId();
                        }
                    } else {
                        this.allcatindex = "";
                        this.allcatindex_id = "";
                    }
                }
            }
        }
        return false;
    }
}
