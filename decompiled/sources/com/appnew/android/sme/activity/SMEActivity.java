package com.appnew.android.sme.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.ExtensionFunctions.XtensionFunctionKt;
import com.appnew.android.Model.Sme.ExpertLeftMenu;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Profile.ProfileActivity;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.DialogUtils;
import com.appnew.android.Utils.FileUtils;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.databinding.ActivitySmeactivityBinding;
import com.appnew.android.home.adapters.LeftNavAdapter;
import com.appnew.android.home.model.Menu;
import com.appnew.android.pojo.Userinfo.Data;
import com.appnew.android.table.BannerListTable;
import com.appnew.android.table.BottomMenuTable;
import com.appnew.android.table.CourseTypeMasterTable;
import com.appnew.android.table.LanguagesTable;
import com.appnew.android.table.MasteAllCatTable;
import com.appnew.android.table.MasterCat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: SMEActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?H\u0014J\b\u0010@\u001a\u00020=H\u0002J\u0006\u0010A\u001a\u00020=J0\u0010B\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010D\u0018\u00010C2\b\u0010E\u001a\u0004\u0018\u00010D2\b\u0010F\u001a\u0004\u0018\u00010D2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J,\u0010I\u001a\u00020=2\u0006\u0010J\u001a\u00020K2\b\u0010E\u001a\u0004\u0018\u00010D2\b\u0010F\u001a\u0004\u0018\u00010D2\u0006\u0010L\u001a\u00020MH\u0016J&\u0010N\u001a\u00020=2\b\u0010J\u001a\u0004\u0018\u00010D2\b\u0010E\u001a\u0004\u0018\u00010D2\b\u0010F\u001a\u0004\u0018\u00010DH\u0016J\u000e\u0010O\u001a\u00020=2\u0006\u0010P\u001a\u00020QJ$\u0010R\u001a\u00020=2\b\u0010S\u001a\u0004\u0018\u00010T2\b\u0010U\u001a\u0004\u0018\u00010D2\b\u0010V\u001a\u0004\u0018\u00010DJ\u0006\u0010W\u001a\u00020=J\u0006\u0010X\u001a\u00020=R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R \u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R \u0010*\u001a\b\u0012\u0004\u0012\u00020+0$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010'\"\u0004\b-\u0010)R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020/0$X\u0082\u0004¢\u0006\u0002\n\u0000R \u00100\u001a\b\u0012\u0004\u0012\u0002010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010'\"\u0004\b3\u0010)R \u00104\u001a\b\u0012\u0004\u0012\u0002050$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010'\"\u0004\b7\u0010)R \u00108\u001a\b\u0012\u0004\u0012\u0002090$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010'\"\u0004\b;\u0010)¨\u0006Y"}, d2 = {"Lcom/appnew/android/sme/activity/SMEActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/ActivitySmeactivityBinding;", "getBinding", "()Lcom/appnew/android/databinding/ActivitySmeactivityBinding;", "setBinding", "(Lcom/appnew/android/databinding/ActivitySmeactivityBinding;)V", "toggle", "Landroidx/appcompat/app/ActionBarDrawerToggle;", "getToggle", "()Landroidx/appcompat/app/ActionBarDrawerToggle;", "setToggle", "(Landroidx/appcompat/app/ActionBarDrawerToggle;)V", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", Const.expertLeftMenu, "Lcom/appnew/android/Model/Sme/ExpertLeftMenu;", "getExpertLeftMenu", "()Lcom/appnew/android/Model/Sme/ExpertLeftMenu;", "setExpertLeftMenu", "(Lcom/appnew/android/Model/Sme/ExpertLeftMenu;)V", "utkashRoom", "Lcom/appnew/android/Room/UtkashRoom;", "getUtkashRoom", "()Lcom/appnew/android/Room/UtkashRoom;", "setUtkashRoom", "(Lcom/appnew/android/Room/UtkashRoom;)V", "bannerListTables", "", "Lcom/appnew/android/table/BannerListTable;", "getBannerListTables", "()Ljava/util/List;", "setBannerListTables", "(Ljava/util/List;)V", "bottomMenuTables", "Lcom/appnew/android/table/BottomMenuTable;", "getBottomMenuTables", "setBottomMenuTables", "courseTypeMasterTables", "Lcom/appnew/android/table/CourseTypeMasterTable;", "masterAllCatTables", "Lcom/appnew/android/table/MasteAllCatTable;", "getMasterAllCatTables", "setMasterAllCatTables", "LanguagesTable", "Lcom/appnew/android/table/LanguagesTable;", "getLanguagesTable", "setLanguagesTable", "mastercatlist", "Lcom/appnew/android/table/MasterCat;", "getMastercatlist", "setMastercatlist", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getSMELeftMenu", "createMenus", "getAPIB", "Lretrofit2/Call;", "", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "", "ErrorCallBack", "handleLeftMenuClick", Const.MENU, "Lcom/appnew/android/home/model/Menu;", "getLogoutDialog", "ctx", "Landroid/app/Activity;", "title", "message", "UserLogout", "initialzehomepage", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SMEActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack {
    public static final int $stable = 8;
    public ActivitySmeactivityBinding binding;
    private ExpertLeftMenu expertLeftMenu;
    private NetworkCall networkCall;
    private ActionBarDrawerToggle toggle;
    private UtkashRoom utkashRoom;
    private List<? extends BannerListTable> bannerListTables = new ArrayList();
    private List<? extends BottomMenuTable> bottomMenuTables = new ArrayList();
    private final List<CourseTypeMasterTable> courseTypeMasterTables = new ArrayList();
    private List<? extends MasteAllCatTable> masterAllCatTables = new ArrayList();
    private List<? extends LanguagesTable> LanguagesTable = new ArrayList();
    private List<? extends MasterCat> mastercatlist = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getLogoutDialog$lambda$3() {
    }

    public final ActivitySmeactivityBinding getBinding() {
        ActivitySmeactivityBinding activitySmeactivityBinding = this.binding;
        if (activitySmeactivityBinding != null) {
            return activitySmeactivityBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(ActivitySmeactivityBinding activitySmeactivityBinding) {
        Intrinsics.checkNotNullParameter(activitySmeactivityBinding, "<set-?>");
        this.binding = activitySmeactivityBinding;
    }

    public final ActionBarDrawerToggle getToggle() {
        return this.toggle;
    }

    public final void setToggle(ActionBarDrawerToggle actionBarDrawerToggle) {
        this.toggle = actionBarDrawerToggle;
    }

    public final NetworkCall getNetworkCall() {
        return this.networkCall;
    }

    public final void setNetworkCall(NetworkCall networkCall) {
        this.networkCall = networkCall;
    }

    public final ExpertLeftMenu getExpertLeftMenu() {
        return this.expertLeftMenu;
    }

    public final void setExpertLeftMenu(ExpertLeftMenu expertLeftMenu) {
        this.expertLeftMenu = expertLeftMenu;
    }

    public final UtkashRoom getUtkashRoom() {
        return this.utkashRoom;
    }

    public final void setUtkashRoom(UtkashRoom utkashRoom) {
        this.utkashRoom = utkashRoom;
    }

    public final List<BannerListTable> getBannerListTables() {
        return this.bannerListTables;
    }

    public final void setBannerListTables(List<? extends BannerListTable> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.bannerListTables = list;
    }

    public final List<BottomMenuTable> getBottomMenuTables() {
        return this.bottomMenuTables;
    }

    public final void setBottomMenuTables(List<? extends BottomMenuTable> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.bottomMenuTables = list;
    }

    public final List<MasteAllCatTable> getMasterAllCatTables() {
        return this.masterAllCatTables;
    }

    public final void setMasterAllCatTables(List<? extends MasteAllCatTable> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.masterAllCatTables = list;
    }

    public final List<LanguagesTable> getLanguagesTable() {
        return this.LanguagesTable;
    }

    public final void setLanguagesTable(List<? extends LanguagesTable> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.LanguagesTable = list;
    }

    public final List<MasterCat> getMastercatlist() {
        return this.mastercatlist;
    }

    public final void setMastercatlist(List<? extends MasterCat> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.mastercatlist = list;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBinding(ActivitySmeactivityBinding.inflate(getLayoutInflater()));
        setContentView(getBinding().getRoot());
        this.utkashRoom = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        this.networkCall = new NetworkCall(this, this);
        getSMELeftMenu();
        createMenus();
        setSupportActionBar(getBinding().smeHomeLayout.dashboardToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        Intrinsics.checkNotNull(supportActionBar);
        supportActionBar.setHomeAsUpIndicator(R.mipmap.menu);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, getBinding().smeDrawerLayout, getBinding().smeHomeLayout.dashboardToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        this.toggle = actionBarDrawerToggle;
        Intrinsics.checkNotNull(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        getBinding().smeDrawerLayout.setDrawerListener(this.toggle);
        ActionBarDrawerToggle actionBarDrawerToggle2 = this.toggle;
        Intrinsics.checkNotNull(actionBarDrawerToggle2);
        actionBarDrawerToggle2.syncState();
    }

    private final void getSMELeftMenu() {
        NetworkCall networkCall = this.networkCall;
        if (networkCall != null) {
            networkCall.NetworkAPICall(API.API_GET_EXPERT_SETTING, "", true, false);
        }
    }

    public final void createMenus() {
        Data loggedInUser = SharedPreference.getInstance().getLoggedInUser();
        if (loggedInUser.getProfilePicture() != null) {
            Intrinsics.checkNotNull(Glide.with((FragmentActivity) this).load(loggedInUser.getProfilePicture()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.default_pic)).into(getBinding().profileImage));
        } else {
            getBinding().profileImage.setImageResource(R.mipmap.default_pic);
        }
        if (!TextUtils.isEmpty(loggedInUser.getName()) && !TextUtils.isEmpty(loggedInUser.getMobile())) {
            getBinding().profileName.setText(loggedInUser.getName());
            Objects.requireNonNull(Unit.INSTANCE);
            getBinding().profileEmail.setText(loggedInUser.getMobile());
            Objects.requireNonNull(Unit.INSTANCE);
        } else {
            getBinding().profileName.setText(getResources().getString(R.string.user));
            Objects.requireNonNull(Unit.INSTANCE);
            getBinding().profileEmail.setText(getResources().getString(R.string.user_mail));
            Objects.requireNonNull(Unit.INSTANCE);
        }
        getBinding().vNameTV.setText(Html.fromHtml(getResources().getString(R.string.version) + Helper.getVersionName(this)));
        Objects.requireNonNull(Unit.INSTANCE);
        getBinding().navHeaderLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.sme.activity.SMEActivity$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SMEActivity.createMenus$lambda$0(this.f$0);
            }
        }));
        Objects.requireNonNull(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createMenus$lambda$0(SMEActivity sMEActivity) {
        SMEActivity sMEActivity2 = sMEActivity;
        if (!Helper.isNetworkConnected(sMEActivity2)) {
            Helper.showInternetToast(sMEActivity2);
        }
        Helper.gotoActivity(sMEActivity, (Class<?>) ProfileActivity.class);
        if (sMEActivity.getBinding().smeDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            sMEActivity.getBinding().smeDrawerLayout.closeDrawer(GravityCompat.START);
        }
        return Unit.INSTANCE;
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        if (Intrinsics.areEqual(apitype, API.API_GET_EXPERT_SETTING)) {
            AES.encrypt(new Gson().toJson(new EncryptionData()));
            Intrinsics.checkNotNull(service);
            return service.getExpertSetting();
        }
        if (!Intrinsics.areEqual(apitype, API.user_logout)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setUser_id(SharedPreference.getInstance().getLoggedInUser().getId());
        String strEncrypt = AES.encrypt(new Gson().toJson(encryptionData));
        Intrinsics.checkNotNull(service);
        return service.getUserLogout(strEncrypt);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) {
        Intrinsics.checkNotNullParameter(jsonstring, "jsonstring");
        if (Intrinsics.areEqual(apitype, API.API_GET_EXPERT_SETTING)) {
            try {
                if (jsonstring.getString("status").equals("true")) {
                    JSONObject jSONObjectOptJSONObject = jsonstring.optJSONObject("data");
                    Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject, "optJSONObject(...)");
                    JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("expert_left_menu");
                    Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject2, "optJSONObject(...)");
                    if (jSONObjectOptJSONObject.optJSONObject("expert_left_menu") != null) {
                        this.expertLeftMenu = (ExpertLeftMenu) new Gson().fromJson(jSONObjectOptJSONObject2.toString(), ExpertLeftMenu.class);
                        final LeftNavAdapter leftNavAdapter = new LeftNavAdapter(this, Helper.getSmeLeftMenu(this.expertLeftMenu, this));
                        getBinding().navRV.setLayoutManager(new LinearLayoutManager(this));
                        Objects.requireNonNull(Unit.INSTANCE);
                        getBinding().navRV.setAdapter(leftNavAdapter);
                        leftNavAdapter.setLeftNavAdapterListener(new LeftNavAdapter.LeftNavAdapterListener() { // from class: com.appnew.android.sme.activity.SMEActivity$$ExternalSyntheticLambda2
                            @Override // com.appnew.android.home.adapters.LeftNavAdapter.LeftNavAdapterListener
                            public final void onItemClick(Menu menu) {
                                SMEActivity.SuccessCallBack$lambda$1(this.f$0, leftNavAdapter, menu);
                            }
                        });
                        return;
                    }
                    return;
                }
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (Intrinsics.areEqual(apitype, API.user_logout)) {
            if (Intrinsics.areEqual(jsonstring.optString("status"), "true")) {
                Helper.SignOutUser(this);
            } else {
                if (jsonstring.optString("auth_code") == null || StringsKt.equals(jsonstring.optString("auth_code"), Const.EXPIRY_AUTH_CODE, true)) {
                    return;
                }
                initialzehomepage();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SuccessCallBack$lambda$1(SMEActivity sMEActivity, LeftNavAdapter leftNavAdapter, Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        if (StringsKt.equals(menu.getHaveChild(), "1", true)) {
            menu.setExpanded(!menu.isExpanded());
        }
        sMEActivity.handleLeftMenuClick(menu);
        leftNavAdapter.notifyDataSetChanged();
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        Intrinsics.areEqual(apitype, API.API_GET_EXPERT_SETTING);
    }

    public final void handleLeftMenuClick(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        if (menu.getType_code() != null) {
            String type_code = menu.getType_code();
            Intrinsics.checkNotNull(type_code);
            int i = Integer.parseInt(type_code);
            if (i == 1) {
                System.out.print((Object) "menuCode == 1");
                XtensionFunctionKt.showSmallLengthToast(this, "Under Development. Coming Soon");
                return;
            }
            if (i == 2) {
                System.out.print((Object) "menuCode == 2");
                XtensionFunctionKt.showSmallLengthToast(this, "Under Development. Coming Soon");
                return;
            }
            if (i == 7) {
                System.out.print((Object) "menuCode == 7");
                XtensionFunctionKt.showSmallLengthToast(this, "Under Development. Coming Soon");
                return;
            }
            if (i == 8) {
                System.out.print((Object) "menuCode == 8");
                XtensionFunctionKt.showSmallLengthToast(this, "Under Development. Coming Soon");
                return;
            }
            if (i == 9) {
                if (SharedPreference.getInstance().getLoggedInUser().getId() == null || SharedPreference.getInstance().getLoggedInUser().getId().equals("0")) {
                    Helper.GuestSignOutUser(FileUtils.context);
                    if (getBinding().smeDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                        getBinding().smeDrawerLayout.closeDrawer(GravityCompat.START);
                        return;
                    }
                    return;
                }
                getLogoutDialog(this, getResources().getString(R.string.logout_title), getResources().getString(R.string.logout_confirmation_message));
                if (getBinding().smeDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                    getBinding().smeDrawerLayout.closeDrawer(GravityCompat.START);
                    return;
                }
                return;
            }
            System.out.print((Object) "x is neither 1 nor 2");
        }
    }

    public final void getLogoutDialog(Activity ctx, String title, String message) {
        DialogUtils.makeDialog(this, title, message, getResources().getString(R.string.yes), getResources().getString(R.string.no), true, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.sme.activity.SMEActivity$$ExternalSyntheticLambda0
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
            public final void onOKClick() {
                SMEActivity.getLogoutDialog$lambda$2(this.f$0);
            }
        }, new DialogUtils.onDialogUtilsCancelClick() { // from class: com.appnew.android.sme.activity.SMEActivity$$ExternalSyntheticLambda1
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsCancelClick
            public final void onCancelClick() {
                SMEActivity.getLogoutDialog$lambda$3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getLogoutDialog$lambda$2(SMEActivity sMEActivity) {
        SMEActivity sMEActivity2 = sMEActivity;
        if (Helper.isConnected(sMEActivity2)) {
            sMEActivity.UserLogout();
        } else {
            Toast.makeText(sMEActivity2, sMEActivity.getResources().getString(R.string.no_internet_connection), 0).show();
        }
    }

    public final void UserLogout() {
        NetworkCall networkCall = this.networkCall;
        Intrinsics.checkNotNull(networkCall);
        networkCall.NetworkAPICall(API.user_logout, "", false, false);
    }

    public final void initialzehomepage() {
        if (this.utkashRoom == null) {
            this.utkashRoom = UtkashRoom.getAppDatabase(this);
        }
        if (Helper.isNetworkConnected(this)) {
            UtkashRoom utkashRoom = this.utkashRoom;
            Intrinsics.checkNotNull(utkashRoom);
            if (utkashRoom.getMasterAllCatDao().isRecordExistsUserId(MakeMyExam.userId)) {
                UtkashRoom utkashRoom2 = this.utkashRoom;
                Intrinsics.checkNotNull(utkashRoom2);
                utkashRoom2.getcoursetypemaster().deletedata();
                UtkashRoom utkashRoom3 = this.utkashRoom;
                Intrinsics.checkNotNull(utkashRoom3);
                utkashRoom3.getLaunguages().deletedata();
                UtkashRoom utkashRoom4 = this.utkashRoom;
                Intrinsics.checkNotNull(utkashRoom4);
                utkashRoom4.getMasterAllCatDao().deletedata();
                UtkashRoom utkashRoom5 = this.utkashRoom;
                Intrinsics.checkNotNull(utkashRoom5);
                utkashRoom5.getMastercatDao().deletedata();
                UtkashRoom utkashRoom6 = this.utkashRoom;
                Intrinsics.checkNotNull(utkashRoom6);
                utkashRoom6.getBannerTableDao().deleteBanners();
                UtkashRoom utkashRoom7 = this.utkashRoom;
                Intrinsics.checkNotNull(utkashRoom7);
                utkashRoom7.getBottomMenuTableDao().deleteBottomMenu();
                UtkashRoom utkashRoom8 = this.utkashRoom;
                Intrinsics.checkNotNull(utkashRoom8);
                utkashRoom8.getthemeSettingdao().deletedata();
            }
        }
    }
}
