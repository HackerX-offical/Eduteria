package com.appnew.android.feeds.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.databinding.ActivityFeedsBinding;
import com.appnew.android.feeds.adapters.FeedAdapter;
import com.appnew.android.feeds.dataclass.BannerData;
import com.appnew.android.feeds.dataclass.Data;
import com.appnew.android.feeds.dataclass.Datum;
import com.appnew.android.feeds.dataclass.NewCourseData;
import com.appnew.android.feeds.dataclass.TestResult;
import com.appnew.android.feeds.viewmodel.FeedViewModel;
import com.appnew.android.feeds.viewmodelfactory.FeedViewModelProviderFactory;
import com.appnew.android.home.livetest.LiveTestData;
import com.appnew.android.table.MasteAllCatTable;
import com.appnew.android.table.MasterCat;
import com.appnew.mvvmwithretrofit.repository.Repository;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PinnedPostActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u008e\u0001\u001a\u00030\u008f\u00012\n\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u0001H\u0014J\b\u0010\u0092\u0001\u001a\u00030\u008f\u0001J\b\u0010\u0093\u0001\u001a\u00030\u008f\u0001J\b\u0010\u0094\u0001\u001a\u00030\u008f\u0001J\b\u0010\u0095\u0001\u001a\u00030\u008f\u0001J\u0015\u0010\u0096\u0001\u001a\u00020\u000e2\n\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0098\u0001H\u0016J\n\u0010\u0099\u0001\u001a\u00030\u008f\u0001H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000f\"\u0004\b&\u0010\u0011R\u001a\u0010'\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u000f\"\u0004\b5\u0010\u0011R\u001c\u00106\u001a\u0004\u0018\u000107X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020=X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010B\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0015\"\u0004\bD\u0010\u0017R\u001c\u0010E\u001a\u0004\u0018\u00010FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010K\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0015\"\u0004\bM\u0010\u0017R\u001a\u0010N\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0015\"\u0004\bP\u0010\u0017R*\u0010Q\u001a\u0012\u0012\u0004\u0012\u00020S0Rj\b\u0012\u0004\u0012\u00020S`TX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR*\u0010Y\u001a\u0012\u0012\u0004\u0012\u00020S0Rj\b\u0012\u0004\u0012\u00020S`TX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010V\"\u0004\b[\u0010XR*\u0010\\\u001a\u0012\u0012\u0004\u0012\u00020]0Rj\b\u0012\u0004\u0012\u00020]`TX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010V\"\u0004\b_\u0010XR*\u0010`\u001a\u0012\u0012\u0004\u0012\u00020]0Rj\b\u0012\u0004\u0012\u00020]`TX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010V\"\u0004\bb\u0010XR\u000e\u0010c\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010d\u001a\u0012\u0012\u0004\u0012\u00020]0Rj\b\u0012\u0004\u0012\u00020]`TX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010V\"\u0004\bf\u0010XR*\u0010g\u001a\u0012\u0012\u0004\u0012\u00020h0Rj\b\u0012\u0004\u0012\u00020h`TX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010V\"\u0004\bj\u0010XR*\u0010k\u001a\u0012\u0012\u0004\u0012\u00020l0Rj\b\u0012\u0004\u0012\u00020l`TX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010V\"\u0004\bn\u0010XR*\u0010o\u001a\u0012\u0012\u0004\u0012\u00020p0Rj\b\u0012\u0004\u0012\u00020p`TX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010V\"\u0004\br\u0010XR*\u0010s\u001a\u0012\u0012\u0004\u0012\u00020t0Rj\b\u0012\u0004\u0012\u00020t`TX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010V\"\u0004\bv\u0010XR*\u0010w\u001a\u0012\u0012\u0004\u0012\u00020x0Rj\b\u0012\u0004\u0012\u00020x`TX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010V\"\u0004\bz\u0010XR!\u0010{\u001a\b\u0012\u0004\u0012\u00020S0|X\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R%\u0010\u0081\u0001\u001a\t\u0012\u0005\u0012\u00030\u0082\u00010|X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0083\u0001\u0010~\"\u0006\b\u0084\u0001\u0010\u0080\u0001R\u001d\u0010\u0085\u0001\u001a\u00020(X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010*\"\u0005\b\u0087\u0001\u0010,R\"\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001¨\u0006\u009a\u0001"}, d2 = {"Lcom/appnew/android/feeds/activity/PinnedPostActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroidx/appcompat/widget/PopupMenu$OnMenuItemClickListener;", "<init>", "()V", "backBtn", "Landroid/widget/Button;", "getBackBtn", "()Landroid/widget/Button;", "setBackBtn", "(Landroid/widget/Button;)V", "feedJsonObject", "Lorg/json/JSONObject;", "isPullToRefresh", "", "()Z", "setPullToRefresh", "(Z)V", "liveClassStatus", "", "getLiveClassStatus", "()Ljava/lang/String;", "setLiveClassStatus", "(Ljava/lang/String;)V", "liveTestStatus", "getLiveTestStatus", "setLiveTestStatus", "section_posiiton", "getSection_posiiton", "setSection_posiiton", "utkashRoom", "Lcom/appnew/android/Room/UtkashRoom;", "getUtkashRoom", "()Lcom/appnew/android/Room/UtkashRoom;", "setUtkashRoom", "(Lcom/appnew/android/Room/UtkashRoom;)V", "response_booelan", "getResponse_booelan", "setResponse_booelan", "limitdata", "", "getLimitdata", "()I", "setLimitdata", "(I)V", "feedAdapter", "Lcom/appnew/android/feeds/adapters/FeedAdapter;", "getFeedAdapter", "()Lcom/appnew/android/feeds/adapters/FeedAdapter;", "setFeedAdapter", "(Lcom/appnew/android/feeds/adapters/FeedAdapter;)V", "loading", "getLoading", "setLoading", "no_data_found_RL", "Landroid/widget/RelativeLayout;", "getNo_data_found_RL", "()Landroid/widget/RelativeLayout;", "setNo_data_found_RL", "(Landroid/widget/RelativeLayout;)V", "feedViewModel", "Lcom/appnew/android/feeds/viewmodel/FeedViewModel;", "getFeedViewModel", "()Lcom/appnew/android/feeds/viewmodel/FeedViewModel;", "setFeedViewModel", "(Lcom/appnew/android/feeds/viewmodel/FeedViewModel;)V", Const.CAT_ID, "getMain_cat", "setMain_cat", "manager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "setManager", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", Const.SUB_CAT, "getSub_cat", "setSub_cat", "master_cat", "getMaster_cat", "setMaster_cat", "selected_master_cat", "Ljava/util/ArrayList;", "Lcom/appnew/android/table/MasteAllCatTable;", "Lkotlin/collections/ArrayList;", "getSelected_master_cat", "()Ljava/util/ArrayList;", "setSelected_master_cat", "(Ljava/util/ArrayList;)V", "selectedsub_all_cat", "getSelectedsub_all_cat", "setSelectedsub_all_cat", "datalist", "Lcom/appnew/android/feeds/dataclass/Data;", "getDatalist", "setDatalist", "pinnedPostList", "getPinnedPostList", "setPinnedPostList", "pinnedPost", "feedlist", "getFeedlist", "setFeedlist", "newCourseData", "Lcom/appnew/android/feeds/dataclass/NewCourseData;", "getNewCourseData", "setNewCourseData", "testResultList", "Lcom/appnew/android/feeds/dataclass/TestResult;", "getTestResultList", "setTestResultList", "liveTestData", "Lcom/appnew/android/home/livetest/LiveTestData;", "getLiveTestData", "setLiveTestData", "liveClassData", "Lcom/appnew/android/feeds/dataclass/Datum;", "getLiveClassData", "setLiveClassData", "bannert_list", "Lcom/appnew/android/feeds/dataclass/BannerData;", "getBannert_list", "setBannert_list", "masterAllCatTables", "", "getMasterAllCatTables", "()Ljava/util/List;", "setMasterAllCatTables", "(Ljava/util/List;)V", "mastercatlist", "Lcom/appnew/android/table/MasterCat;", "getMastercatlist", "setMastercatlist", "page", "getPage", "setPage", "feedsBinding", "Lcom/appnew/android/databinding/ActivityFeedsBinding;", "getFeedsBinding", "()Lcom/appnew/android/databinding/ActivityFeedsBinding;", "setFeedsBinding", "(Lcom/appnew/android/databinding/ActivityFeedsBinding;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "createApiBodyData", "observer", "showProgressView", "hideProgressView", "onMenuItemClick", "item", "Landroid/view/MenuItem;", "onBackPressed", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PinnedPostActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    public static final int $stable = 8;
    private Button backBtn;
    private ArrayList<BannerData> bannert_list;
    private ArrayList<Data> datalist;
    private FeedAdapter feedAdapter;
    private JSONObject feedJsonObject;
    public FeedViewModel feedViewModel;
    private ArrayList<Data> feedlist;
    private ActivityFeedsBinding feedsBinding;
    private boolean isPullToRefresh;
    private int limitdata;
    private ArrayList<Datum> liveClassData;
    private ArrayList<LiveTestData> liveTestData;
    private boolean loading;
    private String main_cat;
    private LinearLayoutManager manager;
    private List<? extends MasteAllCatTable> masterAllCatTables;
    private String master_cat;
    private List<? extends MasterCat> mastercatlist;
    private ArrayList<NewCourseData> newCourseData;
    private RelativeLayout no_data_found_RL;
    private int page;
    private String pinnedPost;
    private ArrayList<Data> pinnedPostList;
    private boolean response_booelan;
    private ArrayList<MasteAllCatTable> selected_master_cat;
    private ArrayList<MasteAllCatTable> selectedsub_all_cat;
    private String sub_cat;
    private ArrayList<TestResult> testResultList;
    private UtkashRoom utkashRoom;
    private String liveClassStatus = "0";
    private String liveTestStatus = "0";
    private String section_posiiton = "0";

    public PinnedPostActivity() {
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        Intrinsics.checkNotNullExpressionValue(appDatabase, "getAppDatabase(...)");
        this.utkashRoom = appDatabase;
        this.loading = true;
        this.main_cat = "";
        this.sub_cat = "";
        this.master_cat = "";
        this.selected_master_cat = new ArrayList<>();
        this.selectedsub_all_cat = new ArrayList<>();
        this.datalist = new ArrayList<>();
        this.pinnedPostList = new ArrayList<>();
        this.pinnedPost = "0";
        this.feedlist = new ArrayList<>();
        this.newCourseData = new ArrayList<>();
        this.testResultList = new ArrayList<>();
        this.liveTestData = new ArrayList<>();
        this.liveClassData = new ArrayList<>();
        this.bannert_list = new ArrayList<>();
        this.masterAllCatTables = new ArrayList();
        this.mastercatlist = new ArrayList();
        this.page = 1;
    }

    public final Button getBackBtn() {
        return this.backBtn;
    }

    public final void setBackBtn(Button button) {
        this.backBtn = button;
    }

    /* JADX INFO: renamed from: isPullToRefresh, reason: from getter */
    public final boolean getIsPullToRefresh() {
        return this.isPullToRefresh;
    }

    public final void setPullToRefresh(boolean z) {
        this.isPullToRefresh = z;
    }

    public final String getLiveClassStatus() {
        return this.liveClassStatus;
    }

    public final void setLiveClassStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.liveClassStatus = str;
    }

    public final String getLiveTestStatus() {
        return this.liveTestStatus;
    }

    public final void setLiveTestStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.liveTestStatus = str;
    }

    public final String getSection_posiiton() {
        return this.section_posiiton;
    }

    public final void setSection_posiiton(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.section_posiiton = str;
    }

    public final UtkashRoom getUtkashRoom() {
        return this.utkashRoom;
    }

    public final void setUtkashRoom(UtkashRoom utkashRoom) {
        Intrinsics.checkNotNullParameter(utkashRoom, "<set-?>");
        this.utkashRoom = utkashRoom;
    }

    public final boolean getResponse_booelan() {
        return this.response_booelan;
    }

    public final void setResponse_booelan(boolean z) {
        this.response_booelan = z;
    }

    public final int getLimitdata() {
        return this.limitdata;
    }

    public final void setLimitdata(int i) {
        this.limitdata = i;
    }

    public final FeedAdapter getFeedAdapter() {
        return this.feedAdapter;
    }

    public final void setFeedAdapter(FeedAdapter feedAdapter) {
        this.feedAdapter = feedAdapter;
    }

    public final boolean getLoading() {
        return this.loading;
    }

    public final void setLoading(boolean z) {
        this.loading = z;
    }

    public final RelativeLayout getNo_data_found_RL() {
        return this.no_data_found_RL;
    }

    public final void setNo_data_found_RL(RelativeLayout relativeLayout) {
        this.no_data_found_RL = relativeLayout;
    }

    public final FeedViewModel getFeedViewModel() {
        FeedViewModel feedViewModel = this.feedViewModel;
        if (feedViewModel != null) {
            return feedViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("feedViewModel");
        return null;
    }

    public final void setFeedViewModel(FeedViewModel feedViewModel) {
        Intrinsics.checkNotNullParameter(feedViewModel, "<set-?>");
        this.feedViewModel = feedViewModel;
    }

    public final String getMain_cat() {
        return this.main_cat;
    }

    public final void setMain_cat(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.main_cat = str;
    }

    public final LinearLayoutManager getManager() {
        return this.manager;
    }

    public final void setManager(LinearLayoutManager linearLayoutManager) {
        this.manager = linearLayoutManager;
    }

    public final String getSub_cat() {
        return this.sub_cat;
    }

    public final void setSub_cat(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sub_cat = str;
    }

    public final String getMaster_cat() {
        return this.master_cat;
    }

    public final void setMaster_cat(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.master_cat = str;
    }

    public final ArrayList<MasteAllCatTable> getSelected_master_cat() {
        return this.selected_master_cat;
    }

    public final void setSelected_master_cat(ArrayList<MasteAllCatTable> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.selected_master_cat = arrayList;
    }

    public final ArrayList<MasteAllCatTable> getSelectedsub_all_cat() {
        return this.selectedsub_all_cat;
    }

    public final void setSelectedsub_all_cat(ArrayList<MasteAllCatTable> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.selectedsub_all_cat = arrayList;
    }

    public final ArrayList<Data> getDatalist() {
        return this.datalist;
    }

    public final void setDatalist(ArrayList<Data> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.datalist = arrayList;
    }

    public final ArrayList<Data> getPinnedPostList() {
        return this.pinnedPostList;
    }

    public final void setPinnedPostList(ArrayList<Data> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.pinnedPostList = arrayList;
    }

    public final ArrayList<Data> getFeedlist() {
        return this.feedlist;
    }

    public final void setFeedlist(ArrayList<Data> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.feedlist = arrayList;
    }

    public final ArrayList<NewCourseData> getNewCourseData() {
        return this.newCourseData;
    }

    public final void setNewCourseData(ArrayList<NewCourseData> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.newCourseData = arrayList;
    }

    public final ArrayList<TestResult> getTestResultList() {
        return this.testResultList;
    }

    public final void setTestResultList(ArrayList<TestResult> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.testResultList = arrayList;
    }

    public final ArrayList<LiveTestData> getLiveTestData() {
        return this.liveTestData;
    }

    public final void setLiveTestData(ArrayList<LiveTestData> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.liveTestData = arrayList;
    }

    public final ArrayList<Datum> getLiveClassData() {
        return this.liveClassData;
    }

    public final void setLiveClassData(ArrayList<Datum> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.liveClassData = arrayList;
    }

    public final ArrayList<BannerData> getBannert_list() {
        return this.bannert_list;
    }

    public final void setBannert_list(ArrayList<BannerData> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.bannert_list = arrayList;
    }

    public final List<MasteAllCatTable> getMasterAllCatTables() {
        return this.masterAllCatTables;
    }

    public final void setMasterAllCatTables(List<? extends MasteAllCatTable> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.masterAllCatTables = list;
    }

    public final List<MasterCat> getMastercatlist() {
        return this.mastercatlist;
    }

    public final void setMastercatlist(List<? extends MasterCat> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.mastercatlist = list;
    }

    public final int getPage() {
        return this.page;
    }

    public final void setPage(int i) {
        this.page = i;
    }

    public final ActivityFeedsBinding getFeedsBinding() {
        return this.feedsBinding;
    }

    public final void setFeedsBinding(ActivityFeedsBinding activityFeedsBinding) {
        this.feedsBinding = activityFeedsBinding;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        ImageView imageView;
        ImageView imageView2;
        super.onCreate(savedInstanceState);
        APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
        Intrinsics.checkNotNull(aPIInterface);
        setFeedViewModel((FeedViewModel) new ViewModelProvider(this, new FeedViewModelProviderFactory(new Repository(aPIInterface), this.utkashRoom)).get(FeedViewModel.class));
        try {
            ActivityFeedsBinding activityFeedsBinding = (ActivityFeedsBinding) DataBindingUtil.setContentView(this, R.layout.activity_feeds);
            this.feedsBinding = activityFeedsBinding;
            if (activityFeedsBinding != null) {
                if (activityFeedsBinding != null) {
                    activityFeedsBinding.setFeedbind(getFeedViewModel());
                }
                activityFeedsBinding.setLifecycleOwner(this);
            }
            Helper.enableScreenShot(this);
            this.no_data_found_RL = (RelativeLayout) findViewById(R.id.no_data_found_RL);
            this.backBtn = (Button) findViewById(R.id.backBtn);
            ActivityFeedsBinding activityFeedsBinding2 = this.feedsBinding;
            Intrinsics.checkNotNull(activityFeedsBinding2);
            activityFeedsBinding2.pulltoReferesh.setRefreshing(false);
            ActivityFeedsBinding activityFeedsBinding3 = this.feedsBinding;
            Intrinsics.checkNotNull(activityFeedsBinding3);
            RelativeLayout titleinnerRL = activityFeedsBinding3.titleinnerRL;
            Intrinsics.checkNotNullExpressionValue(titleinnerRL, "titleinnerRL");
            titleinnerRL.setVisibility(8);
            ActivityFeedsBinding activityFeedsBinding4 = this.feedsBinding;
            Intrinsics.checkNotNull(activityFeedsBinding4);
            ImageView pinedPost = activityFeedsBinding4.pinedPost;
            Intrinsics.checkNotNullExpressionValue(pinedPost, "pinedPost");
            pinedPost.setVisibility(8);
            ActivityFeedsBinding activityFeedsBinding5 = this.feedsBinding;
            Intrinsics.checkNotNull(activityFeedsBinding5);
            ImageView imageView3 = activityFeedsBinding5.filter;
            Intrinsics.checkNotNull(imageView3);
            imageView3.setVisibility(8);
            this.master_cat = String.valueOf(getIntent().getStringExtra("mastercatid"));
            this.main_cat = String.valueOf(getIntent().getStringExtra("maincat"));
            this.sub_cat = String.valueOf(getIntent().getStringExtra("subcatid"));
            getFeedViewModel().getProgressvalue().setValue("1");
            observer();
            this.manager = new LinearLayoutManager(this);
            ActivityFeedsBinding activityFeedsBinding6 = this.feedsBinding;
            Intrinsics.checkNotNull(activityFeedsBinding6);
            RecyclerView recyclerView = activityFeedsBinding6.feedRecyerlview;
            this.feedAdapter = new FeedAdapter(this);
            recyclerView.setLayoutManager(this.manager);
            recyclerView.setAdapter(this.feedAdapter);
            ActivityFeedsBinding activityFeedsBinding7 = this.feedsBinding;
            Intrinsics.checkNotNull(activityFeedsBinding7);
            activityFeedsBinding7.nestedScroll.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.appnew.android.feeds.activity.PinnedPostActivity$$ExternalSyntheticLambda5
                @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
                public final void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                    PinnedPostActivity.onCreate$lambda$2(this.f$0, nestedScrollView, i, i2, i3, i4);
                }
            });
            if (Helper.isTrishulThemeNew()) {
                Button button = this.backBtn;
                if (button != null) {
                    button.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
                }
            } else {
                Button button2 = this.backBtn;
                if (button2 != null) {
                    button2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
                }
            }
            if (Helper.isTrishulThemeNew()) {
                ActivityFeedsBinding activityFeedsBinding8 = this.feedsBinding;
                if (activityFeedsBinding8 != null && (imageView2 = activityFeedsBinding8.imageBack) != null) {
                    imageView2.setColorFilter(ContextCompat.getColor(this, R.color.white));
                }
            } else {
                ActivityFeedsBinding activityFeedsBinding9 = this.feedsBinding;
                if (activityFeedsBinding9 != null && (imageView = activityFeedsBinding9.imageBack) != null) {
                    imageView.setColorFilter(ContextCompat.getColor(this, R.color.colorPrimary));
                }
            }
            ActivityFeedsBinding activityFeedsBinding10 = this.feedsBinding;
            Intrinsics.checkNotNull(activityFeedsBinding10);
            activityFeedsBinding10.imageBack.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.activity.PinnedPostActivity$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.finish();
                }
            });
            Button button3 = this.backBtn;
            Intrinsics.checkNotNull(button3);
            button3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.activity.PinnedPostActivity$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.finish();
                }
            });
            ActivityFeedsBinding activityFeedsBinding11 = this.feedsBinding;
            Intrinsics.checkNotNull(activityFeedsBinding11);
            activityFeedsBinding11.pulltoReferesh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.appnew.android.feeds.activity.PinnedPostActivity$$ExternalSyntheticLambda8
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    PinnedPostActivity.onCreate$lambda$5(this.f$0);
                }
            });
            createApiBodyData();
        } catch (Exception e2) {
            getFeedViewModel().getProgressvalue().setValue("0");
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(PinnedPostActivity pinnedPostActivity, NestedScrollView v, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(v, "v");
        if (i2 == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight() && pinnedPostActivity.loading && pinnedPostActivity.limitdata <= pinnedPostActivity.datalist.size() && Helper.isConnected(pinnedPostActivity)) {
            pinnedPostActivity.showProgressView();
            pinnedPostActivity.page++;
            pinnedPostActivity.createApiBodyData();
            pinnedPostActivity.loading = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$5(PinnedPostActivity pinnedPostActivity) {
        PinnedPostActivity pinnedPostActivity2 = pinnedPostActivity;
        if (Helper.isConnected(pinnedPostActivity2)) {
            if (!pinnedPostActivity.response_booelan) {
                pinnedPostActivity.response_booelan = true;
                FeedAdapter feedAdapter = pinnedPostActivity.feedAdapter;
                Intrinsics.checkNotNull(feedAdapter);
                if (feedAdapter.getTimer() != null) {
                    FeedAdapter feedAdapter2 = pinnedPostActivity.feedAdapter;
                    Intrinsics.checkNotNull(feedAdapter2);
                    Timer timer = feedAdapter2.getTimer();
                    Intrinsics.checkNotNull(timer);
                    timer.cancel();
                    FeedAdapter feedAdapter3 = pinnedPostActivity.feedAdapter;
                    Intrinsics.checkNotNull(feedAdapter3);
                    Timer timer2 = feedAdapter3.getTimer();
                    Intrinsics.checkNotNull(timer2);
                    timer2.purge();
                }
                pinnedPostActivity.isPullToRefresh = true;
                ActivityFeedsBinding activityFeedsBinding = pinnedPostActivity.feedsBinding;
                Intrinsics.checkNotNull(activityFeedsBinding);
                activityFeedsBinding.pulltoReferesh.setRefreshing(false);
                pinnedPostActivity.page = 1;
                pinnedPostActivity.section_posiiton = "0";
                pinnedPostActivity.loading = true;
                pinnedPostActivity.datalist.clear();
                pinnedPostActivity.feedlist.clear();
                pinnedPostActivity.pinnedPostList.clear();
                pinnedPostActivity.createApiBodyData();
                return;
            }
            ActivityFeedsBinding activityFeedsBinding2 = pinnedPostActivity.feedsBinding;
            Intrinsics.checkNotNull(activityFeedsBinding2);
            activityFeedsBinding2.pulltoReferesh.setRefreshing(false);
            return;
        }
        Toast.makeText(pinnedPostActivity2, "No Internet Connection", 0).show();
    }

    public final void createApiBodyData() {
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setPage(String.valueOf(this.page));
        encryptionData.setMaster_cat(this.master_cat);
        encryptionData.setMain_cat(this.main_cat);
        encryptionData.setSub_cat(this.sub_cat);
        encryptionData.setIs_pin("1");
        getFeedViewModel().getBodydata().setValue(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    public final void observer() {
        PinnedPostActivity pinnedPostActivity = this;
        getFeedViewModel().getProgressvalue().observe(pinnedPostActivity, new PinnedPostActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.appnew.android.feeds.activity.PinnedPostActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PinnedPostActivity.observer$lambda$6(this.f$0, (String) obj);
            }
        }));
        getFeedViewModel().getBodydata().observe(pinnedPostActivity, new PinnedPostActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.appnew.android.feeds.activity.PinnedPostActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PinnedPostActivity.observer$lambda$7(this.f$0, (String) obj);
            }
        }));
        getFeedViewModel().getAdapter_bodydata().observe(pinnedPostActivity, new PinnedPostActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.appnew.android.feeds.activity.PinnedPostActivity$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PinnedPostActivity.observer$lambda$8(this.f$0, (String) obj);
            }
        }));
        getFeedViewModel().getAdapter_response().observe(pinnedPostActivity, new PinnedPostActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.appnew.android.feeds.activity.PinnedPostActivity$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PinnedPostActivity.observer$lambda$15(this.f$0, (JSONObject) obj);
            }
        }));
        getFeedViewModel().getJsonObjectmutable().observe(pinnedPostActivity, new PinnedPostActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.appnew.android.feeds.activity.PinnedPostActivity$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PinnedPostActivity.observer$lambda$18(this.f$0, (JSONObject) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observer$lambda$6(PinnedPostActivity pinnedPostActivity, String str) {
        if (str.equals("0")) {
            Helper.dismissProgressDialog();
        } else {
            Helper.showProgressDialog(pinnedPostActivity);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observer$lambda$7(PinnedPostActivity pinnedPostActivity, String str) {
        if (str != null) {
            pinnedPostActivity.getFeedViewModel().getFeedData();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit observer$lambda$8(com.appnew.android.feeds.activity.PinnedPostActivity r1, java.lang.String r2) {
        /*
            if (r2 == 0) goto L77
            com.appnew.android.feeds.viewmodel.FeedViewModel r2 = r1.getFeedViewModel()
            androidx.lifecycle.MutableLiveData r2 = r2.getType()
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L77
            int r0 = r2.hashCode()
            switch(r0) {
                case -314243511: goto L67;
                case -171309688: goto L56;
                case 80245: goto L45;
                case 2368439: goto L34;
                case 81887292: goto L2b;
                case 557130398: goto L1a;
                default: goto L19;
            }
        L19:
            goto L77
        L1a:
            java.lang.String r0 = "AddComment"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L23
            goto L77
        L23:
            com.appnew.android.feeds.viewmodel.FeedViewModel r1 = r1.getFeedViewModel()
            r1.getcourutine_adapter_post()
            goto L77
        L2b:
            java.lang.String r0 = "Unpin"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L4e
            goto L77
        L34:
            java.lang.String r0 = "Like"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L3d
            goto L77
        L3d:
            com.appnew.android.feeds.viewmodel.FeedViewModel r1 = r1.getFeedViewModel()
            r1.getcourutine_adapter_post()
            goto L77
        L45:
            java.lang.String r0 = "Pin"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L4e
            goto L77
        L4e:
            com.appnew.android.feeds.viewmodel.FeedViewModel r1 = r1.getFeedViewModel()
            r1.getcourutine_adapter_post()
            goto L77
        L56:
            java.lang.String r0 = "Attempt Mcq"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L5f
            goto L77
        L5f:
            com.appnew.android.feeds.viewmodel.FeedViewModel r1 = r1.getFeedViewModel()
            r1.getcourutine_adapter_post()
            goto L77
        L67:
            java.lang.String r0 = "GetComment"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L70
            goto L77
        L70:
            com.appnew.android.feeds.viewmodel.FeedViewModel r1 = r1.getFeedViewModel()
            r1.getcourutine_adapter_post()
        L77:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.feeds.activity.PinnedPostActivity.observer$lambda$8(com.appnew.android.feeds.activity.PinnedPostActivity, java.lang.String):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c4 A[Catch: Exception -> 0x00e1, TryCatch #0 {Exception -> 0x00e1, blocks: (B:4:0x0004, B:6:0x0012, B:8:0x0026, B:12:0x0031, B:15:0x003b, B:16:0x004e, B:19:0x0058, B:20:0x006a, B:23:0x0074, B:24:0x007d, B:27:0x0086, B:28:0x0097, B:31:0x00a0, B:32:0x00a9, B:35:0x00b2, B:36:0x00c4, B:38:0x00cf, B:40:0x00d6), top: B:46:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit observer$lambda$15(com.appnew.android.feeds.activity.PinnedPostActivity r3, org.json.JSONObject r4) {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.feeds.activity.PinnedPostActivity.observer$lambda$15(com.appnew.android.feeds.activity.PinnedPostActivity, org.json.JSONObject):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observer$lambda$18(PinnedPostActivity pinnedPostActivity, JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            pinnedPostActivity.hideProgressView();
            int i = 0;
            pinnedPostActivity.response_booelan = false;
            if (Intrinsics.areEqual(jSONObject.optString("status"), "true")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "getJSONObject(...)");
                pinnedPostActivity.feedJsonObject = jSONObject2;
                pinnedPostActivity.limitdata += jSONObject.optInt(Constants.KEY_LIMIT);
                JSONObject jSONObject3 = pinnedPostActivity.feedJsonObject;
                if (jSONObject3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedJsonObject");
                    jSONObject3 = null;
                }
                JSONArray jSONArray = jSONObject3.getJSONArray(Const.posts);
                Intrinsics.checkNotNullExpressionValue(jSONArray, "getJSONArray(...)");
                if (jSONArray.length() > 0) {
                    int i2 = pinnedPostActivity.page;
                    if (i2 == 1) {
                        pinnedPostActivity.datalist.clear();
                        pinnedPostActivity.feedlist.clear();
                        int length = jSONArray.length();
                        while (i < length) {
                            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                            Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject, "optJSONObject(...)");
                            pinnedPostActivity.datalist.add((Data) new Gson().fromJson(jSONObjectOptJSONObject.toString(), Data.class));
                            i++;
                        }
                        FeedAdapter feedAdapter = pinnedPostActivity.feedAdapter;
                        Intrinsics.checkNotNull(feedAdapter);
                        pinnedPostActivity.feedlist.clear();
                        feedAdapter.addFeed(pinnedPostActivity.datalist);
                        feedAdapter.notifyDataSetChanged();
                    } else if (i2 > 1) {
                        pinnedPostActivity.loading = true;
                        int length2 = jSONArray.length();
                        while (i < length2) {
                            JSONObject jSONObjectOptJSONObject2 = jSONArray.optJSONObject(i);
                            Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject2, "optJSONObject(...)");
                            pinnedPostActivity.datalist.add((Data) new Gson().fromJson(jSONObjectOptJSONObject2.toString(), Data.class));
                            i++;
                        }
                        FeedAdapter feedAdapter2 = pinnedPostActivity.feedAdapter;
                        Intrinsics.checkNotNull(feedAdapter2);
                        int itemCount = feedAdapter2.getItemCount();
                        feedAdapter2.addFeed(pinnedPostActivity.datalist);
                        feedAdapter2.notifyItemRangeChanged(itemCount + 1, feedAdapter2.getItemCount());
                    }
                } else if (pinnedPostActivity.datalist.size() == 0) {
                    RelativeLayout relativeLayout = pinnedPostActivity.no_data_found_RL;
                    Intrinsics.checkNotNull(relativeLayout);
                    relativeLayout.setVisibility(0);
                    ActivityFeedsBinding activityFeedsBinding = pinnedPostActivity.feedsBinding;
                    Intrinsics.checkNotNull(activityFeedsBinding);
                    activityFeedsBinding.pulltoReferesh.setVisibility(8);
                } else {
                    Toast.makeText(pinnedPostActivity, "No More Post found", 0).show();
                }
            } else {
                pinnedPostActivity.limitdata = 0;
                if (pinnedPostActivity.datalist.size() == 0) {
                    RelativeLayout relativeLayout2 = pinnedPostActivity.no_data_found_RL;
                    Intrinsics.checkNotNull(relativeLayout2);
                    relativeLayout2.setVisibility(0);
                    ActivityFeedsBinding activityFeedsBinding2 = pinnedPostActivity.feedsBinding;
                    Intrinsics.checkNotNull(activityFeedsBinding2);
                    activityFeedsBinding2.pulltoReferesh.setVisibility(8);
                }
                RetrofitResponse.GetApiData(pinnedPostActivity, jSONObject.has("auth_code") ? jSONObject.getString("auth_code") : "", jSONObject.getString("message"), false);
            }
        }
        return Unit.INSTANCE;
    }

    public final void showProgressView() {
        ActivityFeedsBinding activityFeedsBinding = this.feedsBinding;
        Intrinsics.checkNotNull(activityFeedsBinding);
        activityFeedsBinding.progressBar.setVisibility(0);
    }

    public final void hideProgressView() {
        ActivityFeedsBinding activityFeedsBinding = this.feedsBinding;
        Intrinsics.checkNotNull(activityFeedsBinding);
        if (activityFeedsBinding.progressBar.getVisibility() == 0) {
            ActivityFeedsBinding activityFeedsBinding2 = this.feedsBinding;
            Intrinsics.checkNotNull(activityFeedsBinding2);
            activityFeedsBinding2.progressBar.setVisibility(4);
        }
    }

    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem item) {
        Intrinsics.checkNotNull(item);
        CharSequence title = item.getTitle();
        Intrinsics.checkNotNull(title);
        ActivityFeedsBinding activityFeedsBinding = this.feedsBinding;
        Intrinsics.checkNotNull(activityFeedsBinding);
        if (!title.equals(activityFeedsBinding.toolbartitleTV.getText().toString())) {
            Iterator<MasteAllCatTable> it = this.selected_master_cat.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MasteAllCatTable next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                MasteAllCatTable masteAllCatTable = next;
                if (masteAllCatTable.getName().equals(item.getTitle())) {
                    RelativeLayout relativeLayout = this.no_data_found_RL;
                    Intrinsics.checkNotNull(relativeLayout);
                    if (relativeLayout.getVisibility() == 0) {
                        RelativeLayout relativeLayout2 = this.no_data_found_RL;
                        Intrinsics.checkNotNull(relativeLayout2);
                        relativeLayout2.setVisibility(8);
                        ActivityFeedsBinding activityFeedsBinding2 = this.feedsBinding;
                        Intrinsics.checkNotNull(activityFeedsBinding2);
                        activityFeedsBinding2.pulltoReferesh.setVisibility(0);
                    }
                    this.loading = true;
                    this.main_cat = masteAllCatTable.getId();
                    this.selectedsub_all_cat.clear();
                    for (MasteAllCatTable masteAllCatTable2 : this.masterAllCatTables) {
                        if (StringsKt.equals(this.main_cat, masteAllCatTable2.getParent_id(), true)) {
                            this.selectedsub_all_cat.add(masteAllCatTable2);
                        }
                    }
                    if (this.selectedsub_all_cat.size() > 0) {
                        this.sub_cat = this.selectedsub_all_cat.get(0).getId();
                    }
                    this.datalist.clear();
                    ActivityFeedsBinding activityFeedsBinding3 = this.feedsBinding;
                    Intrinsics.checkNotNull(activityFeedsBinding3);
                    activityFeedsBinding3.toolbartitleTV.setText(item.getTitle());
                    this.page = 1;
                    this.pinnedPostList.clear();
                    FeedAdapter feedAdapter = this.feedAdapter;
                    Intrinsics.checkNotNull(feedAdapter);
                    if (feedAdapter.getTimer() != null) {
                        FeedAdapter feedAdapter2 = this.feedAdapter;
                        Intrinsics.checkNotNull(feedAdapter2);
                        Timer timer = feedAdapter2.getTimer();
                        Intrinsics.checkNotNull(timer);
                        timer.cancel();
                        FeedAdapter feedAdapter3 = this.feedAdapter;
                        Intrinsics.checkNotNull(feedAdapter3);
                        Timer timer2 = feedAdapter3.getTimer();
                        Intrinsics.checkNotNull(timer2);
                        timer2.purge();
                    }
                    getFeedViewModel().getProgressvalue().setValue("1");
                    createApiBodyData();
                }
            }
        }
        return false;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        FeedAdapter feedAdapter = this.feedAdapter;
        Intrinsics.checkNotNull(feedAdapter);
        if (feedAdapter.getTimer() != null) {
            FeedAdapter feedAdapter2 = this.feedAdapter;
            Intrinsics.checkNotNull(feedAdapter2);
            Timer timer = feedAdapter2.getTimer();
            Intrinsics.checkNotNull(timer);
            timer.cancel();
            FeedAdapter feedAdapter3 = this.feedAdapter;
            Intrinsics.checkNotNull(feedAdapter3);
            Timer timer2 = feedAdapter3.getTimer();
            Intrinsics.checkNotNull(timer2);
            timer2.purge();
        }
    }
}
