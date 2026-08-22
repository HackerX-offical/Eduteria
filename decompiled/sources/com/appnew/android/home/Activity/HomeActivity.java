package com.appnew.android.home.Activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.appnew.android.BuildConfig;
import com.appnew.android.Cart.Activity.CartItemsActivity;
import com.appnew.android.Coupon.Activity.CouponActivity;
import com.appnew.android.CourseTransfer.CourseTransferActivity;
import com.appnew.android.Courses.Activity.Concept_newActivity;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.Courses.Activity.QuizActivity;
import com.appnew.android.Courses.Activity.SearchActivity;
import com.appnew.android.Courses.Fragment.SingleStudy;
import com.appnew.android.CreateTest.Activity.CreateTestActivity;
import com.appnew.android.Download.DownloadActivity;
import com.appnew.android.Download.DownloadVideoPlayer;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.LiveClass.Activity.LiveClassActivity;
import com.appnew.android.LiveTest.Activity.LivetestActivity;
import com.appnew.android.Model.BottomSetting;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Model.Courses.Cards;
import com.appnew.android.Model.Video;
import com.appnew.android.Notification.Notification;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Payment.PaymentGatewayListener;
import com.appnew.android.Profile.ProfileActivity;
import com.appnew.android.PurchaseHistory.PurchaseHistory;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Theme.Adapter.SliderAdapter;
import com.appnew.android.UserHistory.UserHistoryActivity;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.DialogUtils;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.StickyView.ui.StickyScrollView;
import com.appnew.android.Webview.WebViewActivty;
import com.appnew.android.cleverTap.AnalyticHelper;
import com.appnew.android.databinding.ActivityHomeBinding;
import com.appnew.android.home.Fragment.Chatboot;
import com.appnew.android.home.Fragment.ContactBottomSheetFragment;
import com.appnew.android.home.adapters.LeftNavAdapter;
import com.appnew.android.home.adapters.TileDataAdapter;
import com.appnew.android.home.adapters.TileItemsAdapter;
import com.appnew.android.home.interfaces.onButtonClicked;
import com.appnew.android.home.model.FilterData.Data;
import com.appnew.android.home.model.FilterData.Filterdata;
import com.appnew.android.home.model.FilterData.Subject;
import com.appnew.android.home.model.Menu;
import com.appnew.android.player.music_player.Utils;
import com.appnew.android.pojo.Userinfo.Data;
import com.appnew.android.table.APITABLE;
import com.appnew.android.table.AudioTable;
import com.appnew.android.table.BannerListTable;
import com.appnew.android.table.BottomMenuTable;
import com.appnew.android.table.CourseDataTable;
import com.appnew.android.table.CourseTypeMasterTable;
import com.appnew.android.table.HomeApiStatusTable;
import com.appnew.android.table.LanguagesTable;
import com.appnew.android.table.MasteAllCatTable;
import com.appnew.android.table.MasterCat;
import com.appnew.android.table.TestTable;
import com.appnew.android.table.VideoTable;
import com.appnew.android.table.VideosDownload;
import com.appnew.android.testmodule.model.InstructionData;
import com.appnew.android.testmodule.model.TestBasicInst;
import com.appnew.android.testmodule.model.TestSectionInst;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.common.base.Ascii;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.razorpay.PaymentResultListener;
import com.tv9news.utils.helpers.AnalyticEvents;
import com.tv9news.utils.helpers.AnalyticsConstants;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import me.leolin.shortcutbadger.ShortcutBadger;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class HomeActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack, onButtonClicked, PopupMenu.OnMenuItemClickListener, PaymentGatewayListener, PaymentResultListener {
    public static Activity homeactivity;
    RelativeLayout RL1P;
    private Task<AppUpdateInfo> appUpdateInfoTask;
    private AudioTable audioTable;
    Button backBtn;
    List<BannerListTable> bannerListTables;
    private ActivityHomeBinding binding;
    LinearLayout bottomLL;
    BottomSetting bottomSetting;
    LinearLayout cartLL;
    TextView cart_count;
    public ImageView chatboat;
    ImageButton chromecast;
    public String contentType;
    RecyclerView courseListRV;
    CardView course_banner;
    LinearLayout cvrNotificationCount;
    public ImageView downarrowIV;
    DrawerLayout drawer;
    RelativeLayout filter;
    TextView filterOne;
    TextView filterTwo;
    RelativeLayout filter_one_click;
    RelativeLayout filter_two_click;
    Filterdata filterdata;
    FloatingActionButton floatGoToTop;
    FrameLayout forchatbot;
    public Fragment fragment;
    private FragmentManager fragmentManager;
    ImageView gotoCart;
    ImageView homeBackIV;
    LinearLayout homeLL;
    private int inAppUpdateType;
    private InstallStateUpdatedListener installStateUpdatedListener;
    public ImageView iv_whatsapp;
    int lang;
    TextView launguagespinner;
    LinearLayout linear_gotoCart;
    LinearLayout liveclass;
    LinearLayout livetest;
    RelativeLayout ll_top;
    LinearLayout ll_top_two;
    private AppUpdateManager mAppUpdateManager;
    LinearLayout my_library;
    public RecyclerView navRV;
    LinearLayout nav_headerLL;
    NavigationView navigationView;
    NetworkCall networkCall;
    RelativeLayout no_data_found_RL;
    TextView notificaionCount;
    RelativeLayout notificationLL;
    int notification_code;
    ImageView notification_def;
    ProgressBar paginationLoader;
    TextView profileEmail;
    public ImageView profileImage;
    public ImageView profileImageText;
    RelativeLayout profileLL;
    TextView profileName;
    private SwipeRefreshLayout pullToReferesh;
    private Dialog quizBasicInfoDialog;
    RelativeLayout relative_gotoCart;
    private StickyScrollView scrollView;
    ImageView searchIV;
    SharedPreferences sharedPreferences;
    String subTitle;
    TextView subjectspinner;
    LinearLayout testLL;
    TileDataAdapter tileDataAdapter;
    RecyclerView tileRv;
    TextView tile_tv;
    RelativeLayout titleinnerRL;
    ActionBarDrawerToggle toggle;
    public Toolbar toolbar;
    TextView toolbartitleTV;
    TextView toolbartitleTV1;
    UtkashRoom utkashRoom;
    TextView versionnameTV;
    private Video videodata;
    RelativeLayout viewPagerRL;
    BottomSheetDialog watchlist;
    public int position = -1;
    long backPressed = 0;
    private boolean backstatus = false;
    public String contentType_id = "0";
    public String tabName = "";
    public String isBook = "0";
    List<CourseTypeMasterTable> courseTypeMasterTables = new ArrayList();
    List<MasteAllCatTable> masterAllCatTables = new ArrayList();
    List<MasterCat> mastercatlist = new ArrayList();
    String mastercatname = "";
    String mastercatid = "";
    String allcatindex = "";
    String allcatindex_id = "";
    String clicktype = "";
    private int pagecount = 1;
    String allsubcatindex = "";
    String allsubcatindex_id = "";
    ArrayList<Courselist> courselists = new ArrayList<>();
    ArrayList<Cards> cardsArrayList = new ArrayList<>();
    ArrayList<MasteAllCatTable> selected_master_cat = new ArrayList<>();
    ArrayList<MasteAllCatTable> selectedsub_all_cat = new ArrayList<>();
    public boolean isfilterchanged = false;
    String launguageindex = "";
    String subjectindex = "";
    boolean isFromDashBoard = false;
    String SelectedLaunguageid = "";
    String SelectedSubjectid = "";
    boolean ispaginationavailable = false;
    String time = "";
    String message = "";
    String title = "";
    String url = "";
    String message_target = "";
    String type = "";
    String course_id = "";
    String fieldid = "";
    long ts = 0;
    String coupon_for = "";
    String topicid = "";
    String testname = "";
    String testquestion = "";
    String tiletype = "";
    String tileid = "";
    String revertapi = "";
    private String quiz_id = "";
    boolean pullrefresh = false;
    boolean isfilterapply = false;
    String selectedpositionid = "0";
    List<CourseDataTable> courseDataTables = new ArrayList();
    List<LanguagesTable> LanguagesTable = new ArrayList();
    String first_attempt = "";
    String result_date = "";
    String submition_type = "";
    String parentid = "";
    String video_type = "";
    private int RC_APP_UPDATE = 999;
    private String tabId = "";
    private String homeScreen_ourCourses = "";
    private String masterCategoryId = "";
    boolean isFromTileActivity = false;
    private String fromWhere = "";
    private String issearchnable = "";
    List<BannerListTable> bannerListTableForTopBanner1 = new ArrayList();
    String themeKey = "currentTheme";
    ArrayList<View> viewArrayList = new ArrayList<>();
    List<BottomMenuTable> bottomMenuTables = new ArrayList();
    public View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.appnew.android.home.Activity.HomeActivity.7
        /* JADX WARN: Code restructure failed: missing block: B:148:0x023d, code lost:
        
            continue;
         */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onClick(android.view.View r12) {
            /*
                Method dump skipped, instruction units count: 650
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.home.Activity.HomeActivity.AnonymousClass7.onClick(android.view.View):void");
        }
    };
    String[] langIds = {"1"};
    String is_paid = "";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0738  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x075c  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x076a  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x07a9  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x07b4  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x07c6  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x07cc  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x07ff  */
    /* JADX WARN: Removed duplicated region for block: B:182:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v15, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r0v35, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r0v36, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r0v37, types: [android.widget.RelativeLayout] */
    /* JADX WARN: Type inference failed for: r3v103 */
    /* JADX WARN: Type inference failed for: r3v104 */
    /* JADX WARN: Type inference failed for: r3v105 */
    /* JADX WARN: Type inference failed for: r3v121 */
    /* JADX WARN: Type inference failed for: r3v130 */
    /* JADX WARN: Type inference failed for: r3v155 */
    /* JADX WARN: Type inference failed for: r3v156 */
    /* JADX WARN: Type inference failed for: r3v157 */
    /* JADX WARN: Type inference failed for: r3v158 */
    /* JADX WARN: Type inference failed for: r3v160 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v97 */
    /* JADX WARN: Type inference failed for: r3v98 */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onCreate(android.os.Bundle r27) {
        /*
            Method dump skipped, instruction units count: 2056
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.home.Activity.HomeActivity.onCreate(android.os.Bundle):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$0() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
        }
        Helper.gotoActivity(this, (Class<?>) Notification.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(InstallState installState) {
        if (installState.installStatus() == 11) {
            popupSnackbarForCompleteUpdate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3() {
        try {
            if (!this.utkashRoom.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread()) {
                this.courseTypeMasterTables = this.utkashRoom.getcoursetypemaster().getcourse_typemaster(MakeMyExam.userId);
                this.masterAllCatTables = this.utkashRoom.getMasterAllCatDao().getmaster_allcat(MakeMyExam.userId);
                this.mastercatlist = this.utkashRoom.getMastercatDao().getmastercat(MakeMyExam.userId);
                this.LanguagesTable = this.utkashRoom.getLaunguages().getLaunguagedetail();
                this.bottomMenuTables = this.utkashRoom.getBottomMenuTableDao().getBottomMenu(MakeMyExam.getUserId());
            }
            runOnUiThread(new Runnable() { // from class: com.appnew.android.home.Activity.HomeActivity$$ExternalSyntheticLambda32
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onCreate$2();
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2() {
        this.cardsArrayList.clear();
        for (CourseTypeMasterTable courseTypeMasterTable : this.courseTypeMasterTables) {
            this.cardsArrayList.add(new Cards(courseTypeMasterTable.getId(), courseTypeMasterTable.getName(), Constants.BLACK, courseTypeMasterTable.getName(), "0#0#0#0#0#0", "0"));
        }
        if (this.cardsArrayList.size() > 0) {
            getTileItems(this.cardsArrayList, 0);
        }
        selecteddata();
        updatePreference();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$4() {
        try {
            if (this.scrollView.getChildAt(r1.getChildCount() - 1).getBottom() - (this.scrollView.getHeight() + this.scrollView.getScrollY()) == 0 && this.notification_code == 0 && this.ispaginationavailable) {
                if (!this.isfilterapply) {
                    if (this.utkashRoom.getHomeApiStatusdata().isRecordExistsUserId(MakeMyExam.userId, this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id)) {
                        HomeApiStatusTable homeApiStatusTable = this.utkashRoom.getHomeApiStatusdata().getcoursedetail(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id, MakeMyExam.getUserId());
                        if (homeApiStatusTable.getStatus().equalsIgnoreCase("true")) {
                            this.paginationLoader.setVisibility(0);
                            this.pagecount = Integer.parseInt(homeApiStatusTable.getPage()) + 1;
                            getCourseData(false);
                        }
                    }
                } else {
                    this.pagecount++;
                    getCourseData(false);
                }
            }
            if (this.scrollView.getScrollY() > 480) {
                if (BuildConfig.FLAVOR.equalsIgnoreCase("mahendra")) {
                    this.floatGoToTop.setVisibility(0);
                    return;
                }
                return;
            }
            this.floatGoToTop.setVisibility(8);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$5() {
        APITABLE apitable = this.utkashRoom.getapidao().getapidetail("ut_009", MakeMyExam.userId);
        if (apitable != null && apitable.getTimestamp() != null && apitable.getInterval() != null && Long.parseLong(apitable.getTimestamp()) + Long.parseLong(apitable.getInterval()) < System.currentTimeMillis() / 1000) {
            this.utkashRoom.getLaunguages().deletedata();
            this.utkashRoom.getMasterAllCatDao().deletedata();
            this.utkashRoom.getMastercatDao().deletedata();
            this.utkashRoom.getcoursetypemaster().deletedata();
            this.pullrefresh = true;
            initialState();
            CartCountRefresh();
            this.isfilterchanged = false;
            this.subjectindex = "";
            this.launguageindex = "";
            this.SelectedLaunguageid = "";
            this.SelectedSubjectid = "";
            this.is_paid = "";
            this.ispaginationavailable = false;
            this.isfilterapply = false;
            hit_api_master_data();
            getCourseData(true);
            this.pullToReferesh.setRefreshing(false);
            return;
        }
        this.pullToReferesh.setRefreshing(false);
    }

    private void setIds() {
        this.toolbartitleTV = (TextView) findViewById(R.id.toolbartitleTV);
        this.pullToReferesh = (SwipeRefreshLayout) findViewById(R.id.pullto_referesh);
        this.notificaionCount = (TextView) findViewById(R.id.notificaionCount);
        this.cvrNotificationCount = (LinearLayout) findViewById(R.id.cvrNotificationCount);
        this.notificationLL = (RelativeLayout) findViewById(R.id.notificationLL);
        this.liveclass = (LinearLayout) findViewById(R.id.liveclass);
        this.bottomLL = (LinearLayout) findViewById(R.id.bottomLL);
        this.livetest = (LinearLayout) findViewById(R.id.livetest);
        this.filter = (RelativeLayout) findViewById(R.id.filter);
        this.forchatbot = (FrameLayout) findViewById(R.id.forchatbot);
        this.filterOne = (TextView) findViewById(R.id.filterOne);
        this.ll_top = (RelativeLayout) findViewById(R.id.ll_top);
        this.RL1P = (RelativeLayout) findViewById(R.id.RL1P);
        this.backBtn = (Button) findViewById(R.id.backBtn);
        this.profileLL = (RelativeLayout) findViewById(R.id.profileLL);
        this.filter_one_click = (RelativeLayout) findViewById(R.id.filter_one_click);
        this.filter_two_click = (RelativeLayout) findViewById(R.id.filter_two_click);
        this.titleinnerRL = (RelativeLayout) findViewById(R.id.titleinnerRL);
        this.filterTwo = (TextView) findViewById(R.id.filterTwo);
        this.downarrowIV = (ImageView) findViewById(R.id.downarrowIV);
        this.scrollView = (StickyScrollView) findViewById(R.id.scrollView);
        this.chromecast = (ImageButton) findViewById(R.id.chromecast);
        this.searchIV = (ImageView) findViewById(R.id.searchIV);
        this.gotoCart = (ImageView) findViewById(R.id.gotoCart);
        this.linear_gotoCart = (LinearLayout) findViewById(R.id.linear_gotoCart);
        this.relative_gotoCart = (RelativeLayout) findViewById(R.id.relative_gotoCart);
        this.cart_count = (TextView) findViewById(R.id.cart_count);
        this.chatboat = (ImageView) findViewById(R.id.chatboat);
        this.tileRv = (RecyclerView) findViewById(R.id.tileRv);
        this.testLL = (LinearLayout) findViewById(R.id.testLL);
        this.homeLL = (LinearLayout) findViewById(R.id.homeLL);
        this.navigationView = (NavigationView) findViewById(R.id.nav_view);
        this.drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        this.toolbar = (Toolbar) findViewById(R.id.feeds_toolbar);
        this.my_library = (LinearLayout) findViewById(R.id.my_library);
        this.nav_headerLL = (LinearLayout) findViewById(R.id.nav_headerLL);
        this.courseListRV = (RecyclerView) findViewById(R.id.courseListRV);
        this.course_banner = (CardView) findViewById(R.id.course_banner);
        this.tile_tv = (TextView) findViewById(R.id.tile_tv);
        this.navRV = (RecyclerView) findViewById(R.id.navRV);
        this.no_data_found_RL = (RelativeLayout) findViewById(R.id.no_data_found_RL);
        this.profileImage = (ImageView) findViewById(R.id.profileImage);
        this.profileImageText = (ImageView) findViewById(R.id.profileImageText);
        this.profileName = (TextView) findViewById(R.id.profileName);
        this.profileEmail = (TextView) findViewById(R.id.profileEmail);
        this.versionnameTV = (TextView) findViewById(R.id.vNameTV);
        this.paginationLoader = (ProgressBar) findViewById(R.id.progressBar);
        this.homeBackIV = (ImageView) findViewById(R.id.homeBackIV);
        this.ll_top_two = (LinearLayout) findViewById(R.id.ll_top_two);
        this.toolbartitleTV1 = (TextView) findViewById(R.id.toolbartitleTV1);
        this.floatGoToTop = (FloatingActionButton) findViewById(R.id.floatGoToTop);
        this.viewPagerRL = (RelativeLayout) findViewById(R.id.viewPagerRL);
        this.iv_whatsapp = (ImageView) findViewById(R.id.iv_whatsapp);
        this.cartLL = (LinearLayout) findViewById(R.id.cartLL);
    }

    private void setClicks(final Bundle savedInstanceState) {
        this.floatGoToTop.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.Activity.HomeActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setClicks$6(view);
            }
        });
        this.homeBackIV.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.home.Activity.HomeActivity$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$7();
            }
        }));
        this.chatboat.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.home.Activity.HomeActivity$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$8(savedInstanceState);
            }
        }));
        this.profileLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.Activity.HomeActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setClicks$9(view);
            }
        });
        this.my_library.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.home.Activity.HomeActivity$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$10();
            }
        }));
        this.livetest.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.home.Activity.HomeActivity$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$11();
            }
        }));
        this.nav_headerLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.home.Activity.HomeActivity$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$12();
            }
        }));
        this.liveclass.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.home.Activity.HomeActivity$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$13();
            }
        }));
        this.homeLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.home.Activity.HomeActivity$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$14();
            }
        }));
        this.testLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.home.Activity.HomeActivity$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$15();
            }
        }));
        this.filter.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.home.Activity.HomeActivity$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$18();
            }
        }));
        this.chromecast.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.home.Activity.HomeActivity$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$19();
            }
        }));
        this.searchIV.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.home.Activity.HomeActivity$$ExternalSyntheticLambda33
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$20();
            }
        }));
        this.cartLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.Activity.HomeActivity$$ExternalSyntheticLambda34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setClicks$21(view);
            }
        });
        this.titleinnerRL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.home.Activity.HomeActivity$$ExternalSyntheticLambda35
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$22();
            }
        }));
        this.filter_two_click.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.home.Activity.HomeActivity$$ExternalSyntheticLambda36
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$23();
            }
        }));
        this.iv_whatsapp.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.Activity.HomeActivity$$ExternalSyntheticLambda37
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setClicks$24(view);
            }
        });
        this.gotoCart.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.home.Activity.HomeActivity$$ExternalSyntheticLambda38
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$25();
            }
        }));
        this.filter_one_click.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.home.Activity.HomeActivity$$ExternalSyntheticLambda39
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$26();
            }
        }));
        this.downarrowIV.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.home.Activity.HomeActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$27();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setClicks$6(View view) {
        this.scrollView.smoothScrollTo(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$7() {
        finish();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$8(Bundle bundle) {
        this.backstatus = false;
        this.forchatbot.setVisibility(0);
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        if (bundle == null && this.fragment == null) {
            this.fragment = new Chatboot();
            getSupportFragmentManager().beginTransaction().add(R.id.forchatbot, this.fragment).commit();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setClicks$9(View view) {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
        } else {
            Helper.gotoActivity(this, (Class<?>) Notification.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$10() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, (Class<?>) MyLibraryActivty.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$11() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, (Class<?>) LivetestActivity.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$12() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, (Class<?>) ProfileActivity.class);
        if (this.drawer.isDrawerOpen(GravityCompat.START)) {
            this.drawer.closeDrawer(GravityCompat.START);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$13() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, (Class<?>) LiveClassActivity.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$14() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$15() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, CreateTestActivity.class, "1");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$18() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        if (this.isfilterchanged) {
            this.subjectindex = "";
            this.launguageindex = "";
            this.SelectedLaunguageid = "";
            this.SelectedSubjectid = "";
            this.is_paid = "";
            this.filterdata = new Filterdata();
            final Data data = new Data();
            AsyncTask.execute(new Runnable() { // from class: com.appnew.android.home.Activity.HomeActivity$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setClicks$17(data);
                }
            });
        } else {
            Filterdata filterdata = this.filterdata;
            if (filterdata != null && filterdata.getData() != null && this.filterdata.getData().getLanguages() != null) {
                this.filterdata = new Filterdata();
                Data data2 = new Data();
                data2.setSubjects((List) new Gson().fromJson(this.utkashRoom.getMasterAllCatDao().getfilteddata(this.allsubcatindex_id), new TypeToken<List<Subject>>() { // from class: com.appnew.android.home.Activity.HomeActivity.3
                }.getType()));
                data2.setLanguages(this.LanguagesTable);
                this.filterdata.setData(data2);
                openwatchlist_dailog_resource(this, this.filterdata.getData().getLanguages(), this.filterdata.getData().getSubjects());
            } else {
                openwatchlist_dailog_resource(this, this.filterdata.getData().getLanguages(), this.filterdata.getData().getSubjects());
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setClicks$17(Data data) {
        data.setSubjects((ArrayList) new Gson().fromJson(this.utkashRoom.getMasterAllCatDao().getfilteddata(this.allsubcatindex_id), new TypeToken<ArrayList<Subject>>() { // from class: com.appnew.android.home.Activity.HomeActivity.2
        }.getType()));
        data.setLanguages(this.LanguagesTable);
        this.filterdata.setData(data);
        runOnUiThread(new Runnable() { // from class: com.appnew.android.home.Activity.HomeActivity$$ExternalSyntheticLambda31
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setClicks$16();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setClicks$16() {
        openwatchlist_dailog_resource(this, this.filterdata.getData().getLanguages(), this.filterdata.getData().getSubjects());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$19() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.startCast(this);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$20() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Intent intent = new Intent(this, (Class<?>) SearchActivity.class);
        intent.putExtra("couse_type", this.contentType_id);
        intent.putExtra("allsubcatindex", this.allsubcatindex_id);
        startActivity(intent);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setClicks$21(View view) {
        Helper.gotoActivity(this, (Class<?>) DownloadActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$22() {
        if (!"1".equalsIgnoreCase("7")) {
            if (!Helper.isNetworkConnected(this)) {
                Helper.showInternetToast(this);
                return null;
            }
            int i = 0;
            if (SharedPreference.getInstance().getString(Const.PREFERENCE_SELECTION_TYPE) != null && SharedPreference.getInstance().getString(Const.PREFERENCE_SELECTION_TYPE).equalsIgnoreCase("1")) {
                ArrayList<Data.Preferences> preferences = SharedPreference.getInstance().getLoggedInUser().getPreferences();
                new ArrayList();
                ArrayList<MasterCat> arrayList = new ArrayList<>();
                ArrayList<MasteAllCatTable> arrayList2 = new ArrayList();
                for (MasteAllCatTable masteAllCatTable : this.masterAllCatTables) {
                    Iterator<Data.Preferences> it = preferences.iterator();
                    while (it.hasNext()) {
                        if (it.next().getSub_cat().equalsIgnoreCase(masteAllCatTable.getId())) {
                            arrayList2.add(masteAllCatTable);
                        }
                    }
                }
                if (arrayList2.size() > 0) {
                    for (MasteAllCatTable masteAllCatTable2 : arrayList2) {
                        for (MasterCat masterCat : this.mastercatlist) {
                            if (masteAllCatTable2.getMaster_type().equalsIgnoreCase(masterCat.getId())) {
                                arrayList.add(masterCat);
                            }
                        }
                    }
                }
                ArrayList<MasterCat> arrayListRemoveDuplicates = removeDuplicates(arrayList, "");
                PopupMenu popupMenu = new PopupMenu(this, this.toolbartitleTV, 3);
                while (i < arrayListRemoveDuplicates.size()) {
                    popupMenu.getMenu().add(arrayListRemoveDuplicates.get(i).getCat());
                    i++;
                }
                this.clicktype = "1";
                popupMenu.setOnMenuItemClickListener(this);
                popupMenu.show();
            } else {
                PopupMenu popupMenu2 = new PopupMenu(this, this.toolbartitleTV, 3);
                while (i < this.mastercatlist.size()) {
                    popupMenu2.getMenu().add(this.mastercatlist.get(i).getCat());
                    i++;
                }
                this.clicktype = "1";
                popupMenu2.setOnMenuItemClickListener(this);
                popupMenu2.show();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$23() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        PopupMenu popupMenu = new PopupMenu(this, this.filterTwo, 3);
        for (int i = 0; i < this.selectedsub_all_cat.size(); i++) {
            if (this.allsubcatindex_id.equalsIgnoreCase(this.selectedsub_all_cat.get(i).getId())) {
                SpannableString spannableString = new SpannableString(this.allsubcatindex);
                spannableString.setSpan(new StyleSpan(((Typeface) Objects.requireNonNull(ResourcesCompat.getFont(this, R.font.amazon_ember_bd))).getStyle()), 0, spannableString.length(), 33);
                spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.country_code_text_color)), 0, spannableString.length(), 33);
                popupMenu.getMenu().add(spannableString);
            } else {
                popupMenu.getMenu().add(this.selectedsub_all_cat.get(i).getName());
            }
        }
        this.clicktype = "3";
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setClicks$24(View view) {
        Helper.openWhatsapp(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$25() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Intent intent = new Intent(this, (Class<?>) CartItemsActivity.class);
        intent.putExtra("courseId", "mainCourseId");
        startActivity(intent);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$26() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        PopupMenu popupMenu = new PopupMenu(this, this.filterOne, 3);
        for (int i = 0; i < this.selected_master_cat.size(); i++) {
            if (this.allcatindex_id.equalsIgnoreCase(this.selected_master_cat.get(i).getId())) {
                SpannableString spannableString = new SpannableString(this.allcatindex);
                spannableString.setSpan(new StyleSpan(((Typeface) Objects.requireNonNull(ResourcesCompat.getFont(this, R.font.amazon_ember_bd))).getStyle()), 0, spannableString.length(), 33);
                spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.country_code_text_color)), 0, spannableString.length(), 33);
                popupMenu.getMenu().add(spannableString);
            } else {
                popupMenu.getMenu().add(this.selected_master_cat.get(i).getName());
            }
        }
        this.clicktype = "2";
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$27() {
        if (!"1".equalsIgnoreCase("7")) {
            if (!Helper.isNetworkConnected(this)) {
                Helper.showInternetToast(this);
                return null;
            }
            int i = 0;
            if (SharedPreference.getInstance().getString(Const.PREFERENCE_SELECTION_TYPE) != null && SharedPreference.getInstance().getString(Const.PREFERENCE_SELECTION_TYPE).equalsIgnoreCase("1")) {
                ArrayList<Data.Preferences> preferences = SharedPreference.getInstance().getLoggedInUser().getPreferences();
                new ArrayList();
                ArrayList<MasterCat> arrayList = new ArrayList<>();
                ArrayList<MasteAllCatTable> arrayList2 = new ArrayList();
                for (MasteAllCatTable masteAllCatTable : this.masterAllCatTables) {
                    Iterator<Data.Preferences> it = preferences.iterator();
                    while (it.hasNext()) {
                        if (it.next().getSub_cat().equalsIgnoreCase(masteAllCatTable.getId())) {
                            arrayList2.add(masteAllCatTable);
                        }
                    }
                }
                if (arrayList2.size() > 0) {
                    for (MasteAllCatTable masteAllCatTable2 : arrayList2) {
                        for (MasterCat masterCat : this.mastercatlist) {
                            if (masteAllCatTable2.getMaster_type().equalsIgnoreCase(masterCat.getId())) {
                                arrayList.add(masterCat);
                            }
                        }
                    }
                }
                ArrayList<MasterCat> arrayListRemoveDuplicates = removeDuplicates(arrayList, "");
                PopupMenu popupMenu = new PopupMenu(this, this.toolbartitleTV, 3);
                while (i < arrayListRemoveDuplicates.size()) {
                    popupMenu.getMenu().add(arrayListRemoveDuplicates.get(i).getCat());
                    i++;
                }
                this.clicktype = "1";
                popupMenu.setOnMenuItemClickListener(this);
                popupMenu.show();
            } else {
                PopupMenu popupMenu2 = new PopupMenu(this, this.toolbartitleTV, 3);
                while (i < this.mastercatlist.size()) {
                    popupMenu2.getMenu().add(this.mastercatlist.get(i).getCat());
                    i++;
                }
                this.clicktype = "1";
                popupMenu2.setOnMenuItemClickListener(this);
                popupMenu2.show();
            }
        }
        return null;
    }

    private void updatePreference() {
        if (SharedPreference.getInstance().getString(Const.PREFERENCE_SELECTION_TYPE) == null || !SharedPreference.getInstance().getString(Const.PREFERENCE_SELECTION_TYPE).equalsIgnoreCase("1")) {
            return;
        }
        ArrayList<Data.Preferences> preferences = SharedPreference.getInstance().getLoggedInUser().getPreferences();
        new ArrayList();
        ArrayList<MasterCat> arrayList = new ArrayList<>();
        ArrayList<MasteAllCatTable> arrayList2 = new ArrayList();
        for (MasteAllCatTable masteAllCatTable : this.masterAllCatTables) {
            Iterator<Data.Preferences> it = preferences.iterator();
            while (it.hasNext()) {
                if (it.next().getSub_cat().equalsIgnoreCase(masteAllCatTable.getId())) {
                    arrayList2.add(masteAllCatTable);
                }
            }
        }
        if (arrayList2.size() > 0) {
            for (MasteAllCatTable masteAllCatTable2 : arrayList2) {
                for (MasterCat masterCat : this.mastercatlist) {
                    if (masteAllCatTable2.getMaster_type().equalsIgnoreCase(masterCat.getId())) {
                        arrayList.add(masterCat);
                    }
                }
            }
            ArrayList<MasterCat> arrayListRemoveDuplicates = removeDuplicates(arrayList, "");
            if (arrayListRemoveDuplicates != null && !arrayListRemoveDuplicates.isEmpty()) {
                this.toolbartitleTV.setText(arrayListRemoveDuplicates.get(0).getCat());
                this.mastercatname = arrayListRemoveDuplicates.get(0).getCat();
                updateMasterCat(arrayListRemoveDuplicates.get(0).getCat());
                this.mastercatid = arrayListRemoveDuplicates.get(0).getId();
                return;
            }
            List<MasterCat> list = this.mastercatlist;
            if (list != null && !list.isEmpty()) {
                this.toolbartitleTV.setText(this.mastercatlist.get(0).getCat());
                this.mastercatname = this.mastercatlist.get(0).getCat();
                updateMasterCat(this.mastercatlist.get(0).getCat());
                this.mastercatid = this.mastercatlist.get(0).getId();
                return;
            }
            this.toolbartitleTV.setText(R.string.courses);
            return;
        }
        this.toolbartitleTV.setText(this.mastercatlist.get(0).getCat());
        this.mastercatname = this.mastercatlist.get(0).getCat();
        updateMasterCat(this.mastercatlist.get(0).getCat());
        this.mastercatid = this.mastercatlist.get(0).getId();
    }

    private void hit_api_master_data() {
        this.networkCall.NetworkAPICall(API.master_content, "", true, false);
    }

    private void initialState() {
        this.pagecount = 1;
        this.cardsArrayList.clear();
    }

    public void CartCountRefresh() {
        if (SharedPreference.getInstance().getInt(Const.CART_COUNT) == 0) {
            ShortcutBadger.applyCount(getApplicationContext(), SharedPreference.getInstance().getInt(Const.CART_COUNT));
            runOnUiThread(new Runnable() { // from class: com.appnew.android.home.Activity.HomeActivity$$ExternalSyntheticLambda28
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$CartCountRefresh$28();
                }
            });
            this.linear_gotoCart.setVisibility(8);
            return;
        }
        runOnUiThread(new Runnable() { // from class: com.appnew.android.home.Activity.HomeActivity$$ExternalSyntheticLambda29
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$CartCountRefresh$29();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$CartCountRefresh$28() {
        this.cart_count.setText(String.valueOf(SharedPreference.getInstance().getInt(Const.CART_COUNT)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$CartCountRefresh$29() {
        this.linear_gotoCart.setVisibility(0);
        ShortcutBadger.applyCount(getApplicationContext(), SharedPreference.getInstance().getInt(Const.CART_COUNT));
        this.linear_gotoCart.setBackgroundResource(R.drawable.circle_notification_count);
        if (SharedPreference.getInstance().getInt(Const.CART_COUNT) > 99) {
            this.cart_count.setText(getResources().getString(R.string.nine_nine));
        } else if (SharedPreference.getInstance().getInt(Const.CART_COUNT) > 0) {
            this.cart_count.setText(String.valueOf(SharedPreference.getInstance().getInt(Const.CART_COUNT)));
        } else {
            this.linear_gotoCart.setVisibility(8);
        }
    }

    public void checkFilter() {
        if (this.utkashRoom.getthemeSettingdao().is_setting_exit()) {
            this.bottomSetting = (BottomSetting) new Gson().fromJson(this.utkashRoom.getthemeSettingdao().data().getBottom(), BottomSetting.class);
        }
        BottomSetting bottomSetting = this.bottomSetting;
        if (bottomSetting != null && bottomSetting.getFilter() != null && this.bottomSetting.getFilter().equals("1")) {
            this.filter.setVisibility(0);
        } else {
            this.filter.setVisibility(8);
        }
    }

    public void checkLayoutType() {
        BottomSetting bottomSetting;
        if (this.utkashRoom.getthemeSettingdao().is_setting_exit()) {
            this.bottomSetting = (BottomSetting) new Gson().fromJson(this.utkashRoom.getthemeSettingdao().data().getBottom(), BottomSetting.class);
            manageVisibility();
        }
        if (SharedPreference.getInstance().getString(Const.IS_HOME_GRID).equalsIgnoreCase("1") || ((bottomSetting = this.bottomSetting) != null && bottomSetting.getLayout_type() != null && this.bottomSetting.getLayout_type().equals("1"))) {
            this.courseListRV.setLayoutManager(new GridLayoutManager((Context) this, 2, 1, false));
            this.courseListRV.setLayoutParams(new RelativeLayout.LayoutParams(-2, -1));
        } else {
            this.courseListRV.setLayoutManager(new LinearLayoutManager(this));
        }
    }

    private void getTileItems(ArrayList<Cards> cardsArrayList, int pos) {
        this.contentType = cardsArrayList.get(pos).getType() + cardsArrayList.get(pos).getId();
        TileItemsAdapter tileItemsAdapter = new TileItemsAdapter(this, this.contentType, cardsArrayList, this);
        this.tileRv.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.tileRv.setAdapter(tileItemsAdapter);
        this.tileRv.setNestedScrollingEnabled(false);
        this.tileRv.scrollToPosition(pos);
        getTileData(cardsArrayList.get(pos));
    }

    private void setHomeDrawer() {
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.menu);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, this.drawer, this.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        this.toggle = actionBarDrawerToggle;
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        this.drawer.setDrawerListener(this.toggle);
        this.toggle.syncState();
        this.drawer.addDrawerListener(new DrawerLayout.DrawerListener() { // from class: com.appnew.android.home.Activity.HomeActivity.4
            @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
            public void onDrawerClosed(View drawerView) {
            }

            @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
            public void onDrawerSlide(View drawerView, float slideOffset) {
            }

            @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
            public void onDrawerStateChanged(int newState) {
            }

            @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
            public void onDrawerOpened(View drawerView) {
                Helper.HideKeyboard(HomeActivity.this);
            }
        });
        ActionBarDrawerToggle actionBarDrawerToggle2 = new ActionBarDrawerToggle(this, this.drawer, this.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) { // from class: com.appnew.android.home.Activity.HomeActivity.5
            @Override // androidx.appcompat.app.ActionBarDrawerToggle, androidx.drawerlayout.widget.DrawerLayout.DrawerListener
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override // androidx.appcompat.app.ActionBarDrawerToggle, androidx.drawerlayout.widget.DrawerLayout.DrawerListener
            public void onDrawerOpened(View drawerView) {
                String string = SharedPreference.getInstance().getString(Const.SERVER_TIME);
                if (TextUtils.isEmpty(string) || string.equals("0")) {
                    if (SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE).equalsIgnoreCase("") || SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE).equals("0")) {
                        HomeActivity.this.networkCall.NetworkAPICall(API.IS_COUPON_AVAILABLE, "", false, false);
                    } else if (Integer.parseInt(SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE)) > 0) {
                        HomeActivity.this.createMenus();
                    }
                } else if (Long.parseLong(string) <= System.currentTimeMillis()) {
                    HomeActivity.this.networkCall.NetworkAPICall(API.IS_COUPON_AVAILABLE, "", false, false);
                }
                Helper.HideKeyboard(HomeActivity.this);
                super.onDrawerOpened(drawerView);
            }
        };
        this.drawer.setDrawerListener(actionBarDrawerToggle2);
        actionBarDrawerToggle2.syncState();
    }

    private boolean ApiToHit() {
        return (SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE) == null || SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE).length() <= 0 || SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE).equalsIgnoreCase("0")) ? false : true;
    }

    public void hideBackbtn() {
        ActionBarDrawerToggle actionBarDrawerToggle = this.toggle;
        if (actionBarDrawerToggle != null) {
            actionBarDrawerToggle.setDrawerIndicatorEnabled(false);
        }
    }

    @Override // com.appnew.android.home.interfaces.onButtonClicked
    public void onTitleClicked(Cards cards, ArrayList<Cards> tiles, String contentType, int tilePos) {
        List<CourseDataTable> list;
        List<CourseDataTable> list2;
        try {
            if (this.contentType_id.equalsIgnoreCase(cards.getId())) {
                return;
            }
            this.isfilterapply = false;
            getTileItems(tiles, tilePos);
            if (this.utkashRoom.getHomeApiStatusdata().isRecordExistsUserId(MakeMyExam.userId, this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id)) {
                if (this.utkashRoom.getHomeApiStatusdata().getcoursedetail(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id, MakeMyExam.getUserId()).getStatus().equalsIgnoreCase("false")) {
                    this.pagecount = 1;
                    this.courselists.clear();
                    if (this.contentType_id.equalsIgnoreCase("0")) {
                        list2 = this.utkashRoom.getCoursedata().getcoursedata(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId);
                    } else {
                        list2 = this.utkashRoom.getCoursedata().getcoursedatawithfilter(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId, cards.getId());
                    }
                    for (CourseDataTable courseDataTable : list2) {
                        Courselist courselist = new Courselist(courseDataTable.getCourse_id(), courseDataTable.getTitle(), courseDataTable.getCover_image(), courseDataTable.getMrp(), courseDataTable.getCourse_sp(), courseDataTable.getValidity(), courseDataTable.getSubject_id(), courseDataTable.getLang_id(), courseDataTable.getDesc_header_image(), courseDataTable.getExtra_json(), courseDataTable.getAvg_rating(), courseDataTable.getUser_rated(), courseDataTable.getIs_purchased(), courseDataTable.getCombo_course_ids(), "", courseDataTable.getCat_type(), courseDataTable.getHide_validity(), courseDataTable.getDescription(), courseDataTable.getDiscount(), courseDataTable.getDelivery_charge(), courseDataTable.getBook_redirection_link(), courseDataTable.getPayment_mode());
                        if ("1".equalsIgnoreCase("5")) {
                            if (courselist.getExtra_json().getHome_screen() == null) {
                                this.courselists.add(courselist);
                            } else if (this.fromWhere.equalsIgnoreCase("ourcourse")) {
                                if (courselist.getExtra_json().getHome_screen().equalsIgnoreCase("1")) {
                                    this.courselists.add(courselist);
                                }
                            } else {
                                this.courselists.add(courselist);
                            }
                        } else {
                            this.courselists.add(courselist);
                        }
                    }
                    if (this.courselists.size() > 0) {
                        this.courseListRV.setVisibility(0);
                        this.no_data_found_RL.setVisibility(8);
                    } else {
                        this.courseListRV.setVisibility(8);
                        this.no_data_found_RL.setVisibility(0);
                    }
                    TileDataAdapter tileDataAdapter = new TileDataAdapter(this, this.courselists, this.isBook, this, this);
                    this.tileDataAdapter = tileDataAdapter;
                    this.courseListRV.setAdapter(tileDataAdapter);
                    this.courseListRV.setNestedScrollingEnabled(false);
                    return;
                }
                if (this.utkashRoom.getHomeApiStatusdata().isRecordExistsUserId(MakeMyExam.userId, this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id)) {
                    if (this.utkashRoom.getHomeApiStatusdata().getcoursedetail(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id, MakeMyExam.getUserId()).getStatus().equalsIgnoreCase("false")) {
                        this.pagecount = 1;
                        this.courselists.clear();
                        if (this.contentType_id.equalsIgnoreCase("0")) {
                            list = this.utkashRoom.getCoursedata().getcoursedata(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId);
                        } else {
                            list = this.utkashRoom.getCoursedata().getcoursedatawithfilter(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId, cards.getId());
                        }
                        for (CourseDataTable courseDataTable2 : list) {
                            Courselist courselist2 = new Courselist(courseDataTable2.getCourse_id(), courseDataTable2.getTitle(), courseDataTable2.getCover_image(), courseDataTable2.getMrp(), courseDataTable2.getCourse_sp(), courseDataTable2.getValidity(), courseDataTable2.getSubject_id(), courseDataTable2.getLang_id(), courseDataTable2.getDesc_header_image(), courseDataTable2.getExtra_json(), courseDataTable2.getAvg_rating(), courseDataTable2.getUser_rated(), courseDataTable2.getIs_purchased(), courseDataTable2.getCombo_course_ids(), "", courseDataTable2.getCat_type(), courseDataTable2.getHide_validity(), courseDataTable2.getDescription(), courseDataTable2.getDiscount(), courseDataTable2.getDelivery_charge(), courseDataTable2.getBook_redirection_link(), courseDataTable2.getPayment_mode());
                            if ("1".equalsIgnoreCase("5")) {
                                if (courselist2.getExtra_json().getHome_screen() == null) {
                                    this.courselists.add(courselist2);
                                } else if (this.fromWhere.equalsIgnoreCase("ourcourse")) {
                                    if (courselist2.getExtra_json().getHome_screen().equalsIgnoreCase("1")) {
                                        this.courselists.add(courselist2);
                                    }
                                } else {
                                    this.courselists.add(courselist2);
                                }
                            } else {
                                this.courselists.add(courselist2);
                            }
                        }
                        if (this.courselists.size() > 0) {
                            this.courseListRV.setVisibility(0);
                            this.no_data_found_RL.setVisibility(8);
                        } else {
                            this.courseListRV.setVisibility(8);
                            this.no_data_found_RL.setVisibility(0);
                        }
                        TileDataAdapter tileDataAdapter2 = new TileDataAdapter(this, this.courselists, this.isBook, this, this);
                        this.tileDataAdapter = tileDataAdapter2;
                        this.courseListRV.setAdapter(tileDataAdapter2);
                        this.courseListRV.setNestedScrollingEnabled(false);
                        return;
                    }
                    this.pagecount = 1;
                    getCourseData(true);
                    return;
                }
                this.pagecount = 1;
                getCourseData(true);
                return;
            }
            this.pagecount = 1;
            getCourseData(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void changeThemeColor(String color) {
        if (!color.contains(":") || color.split(":").length <= 1) {
            return;
        }
        SharedPreference.getInstance().putString("theme_color_hai_bhai", color);
        this.toolbar.setBackgroundColor(Color.parseColor(color.split(":")[0]));
        this.searchIV.setColorFilter(Color.parseColor(color.split(":")[1]), PorterDuff.Mode.SRC_IN);
        this.homeBackIV.setColorFilter(Color.parseColor(color.split(":")[1]), PorterDuff.Mode.SRC_IN);
        this.toolbartitleTV.setTextColor(Color.parseColor(color.split(":")[1]));
        this.toolbartitleTV1.setTextColor(Color.parseColor(color.split(":")[1]));
        Window window = getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.clearFlags(67108864);
        window.setStatusBarColor(Color.parseColor(color.split(":")[0]));
    }

    public void getTileData(Cards cards) {
        this.tile_tv.setText(cards.getTile_name());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        CartCountRefresh();
        SingleStudy.parentCourseId = "";
        if (this.utkashRoom == null) {
            UtkashRoom appDatabase = UtkashRoom.getAppDatabase(this);
            this.utkashRoom = appDatabase;
            appDatabase.getOpenHelper().getWritableDatabase().enableWriteAheadLogging();
        }
        automateViewPagerSwiping();
        if (SharedPreference.getInstance().getString("theme_color_hai_bhai") != null && !TextUtils.isEmpty(SharedPreference.getInstance().getString("theme_color_hai_bhai"))) {
            changeThemeColor(SharedPreference.getInstance().getString("theme_color_hai_bhai"));
        }
        try {
            this.mAppUpdateManager.getAppUpdateInfo().addOnSuccessListener(new OnSuccessListener() { // from class: com.appnew.android.home.Activity.HomeActivity$$ExternalSyntheticLambda19
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    this.f$0.lambda$onResume$30((AppUpdateInfo) obj);
                }
            });
            this.mAppUpdateManager.getAppUpdateInfo().addOnSuccessListener(new OnSuccessListener() { // from class: com.appnew.android.home.Activity.HomeActivity$$ExternalSyntheticLambda20
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    this.f$0.lambda$onResume$31((AppUpdateInfo) obj);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        homeAutoRefresh();
        try {
            com.appnew.android.pojo.Userinfo.Data loggedInUser = SharedPreference.getInstance().getLoggedInUser();
            if (loggedInUser.getProfilePicture() != null) {
                this.profileImage.setVisibility(0);
                Glide.with((FragmentActivity) this).load(loggedInUser.getProfilePicture()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.course_placeholder)).into(this.profileImage);
            } else {
                this.profileImage.setVisibility(0);
                this.profileImageText.setVisibility(8);
                this.profileImage.setImageResource(R.mipmap.default_pic);
            }
            if (!TextUtils.isEmpty(loggedInUser.getName()) && !TextUtils.isEmpty(loggedInUser.getMobile())) {
                this.profileName.setText(loggedInUser.getName());
                this.profileEmail.setText(loggedInUser.getMobile());
            } else {
                this.profileName.setText(getResources().getString(R.string.user));
                this.profileEmail.setText(getResources().getString(R.string.user_mail));
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$30(AppUpdateInfo appUpdateInfo) {
        if (appUpdateInfo.updateAvailability() == 3) {
            try {
                this.mAppUpdateManager.startUpdateFlowForResult(appUpdateInfo, this.inAppUpdateType, this, this.RC_APP_UPDATE);
            } catch (IntentSender.SendIntentException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$31(AppUpdateInfo appUpdateInfo) {
        if (appUpdateInfo.installStatus() == 11) {
            popupSnackbarForCompleteUpdate();
        }
    }

    public LinearLayout initBottomView(Menu menu, String str) {
        LinearLayout linearLayout = (LinearLayout) View.inflate(this, R.layout.bottom_item, null);
        TextView textView = (TextView) linearLayout.findViewById(R.id.title);
        final ImageView imageView = (ImageView) linearLayout.findViewById(R.id.icon);
        RelativeLayout relativeLayout = (RelativeLayout) linearLayout.findViewById(R.id.viewUnderLine);
        textView.setText(menu.getName());
        Glide.with((FragmentActivity) this).asBitmap().load(menu.getImageUrl()).into(new CustomTarget<Bitmap>() { // from class: com.appnew.android.home.Activity.HomeActivity.6
            @Override // com.bumptech.glide.request.target.Target
            public void onLoadCleared(Drawable placeholder) {
            }

            @Override // com.bumptech.glide.request.target.Target
            public /* bridge */ /* synthetic */ void onResourceReady(Object resource, Transition transition) {
                onResourceReady((Bitmap) resource, (Transition<? super Bitmap>) transition);
            }

            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                imageView.setImageBitmap(resource);
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2, 1.0f);
        layoutParams.setMargins(0, 10, 0, 0);
        layoutParams.setLayoutDirection(0);
        linearLayout.setLayoutParams(layoutParams);
        textView.setGravity(17);
        linearLayout.setTag(menu);
        this.viewArrayList.add(linearLayout);
        if (menu.getId().equalsIgnoreCase(str)) {
            relativeLayout.setVisibility(0);
        }
        linearLayout.setOnClickListener(this.onClickListener);
        return linearLayout;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == this.RC_APP_UPDATE) {
            if (resultCode == -1) {
                Toast.makeText(this, getResources().getString(R.string.app_download_starts), 1).show();
            } else if (resultCode != 0) {
                Toast.makeText(this, getResources().getString(R.string.app_download_cancelled), 1).show();
            } else if (resultCode == 1) {
                Toast.makeText(this, getResources().getString(R.string.app_download_failed), 1).show();
            }
        }
    }

    private void popupSnackbarForCompleteUpdate() {
        try {
            Snackbar snackbarMake = Snackbar.make(this.liveclass, getResources().getString(R.string.an_update_has_just_been_downloaded), -2);
            snackbarMake.setAction(getResources().getString(R.string.restart), new View.OnClickListener() { // from class: com.appnew.android.home.Activity.HomeActivity$$ExternalSyntheticLambda27
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$popupSnackbarForCompleteUpdate$32(view);
                }
            });
            snackbarMake.show();
        } catch (Resources.NotFoundException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$popupSnackbarForCompleteUpdate$32(View view) {
        this.mAppUpdateManager.completeUpdate();
    }

    private void checkAppUpdate() {
        try {
            this.appUpdateInfoTask.addOnSuccessListener(new OnSuccessListener<AppUpdateInfo>() { // from class: com.appnew.android.home.Activity.HomeActivity.8
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public void onSuccess(AppUpdateInfo appUpdateInfo) {
                    if (appUpdateInfo.updateAvailability() == 2 && appUpdateInfo.isUpdateTypeAllowed(HomeActivity.this.inAppUpdateType)) {
                        try {
                            AppUpdateManager appUpdateManager = HomeActivity.this.mAppUpdateManager;
                            int i = HomeActivity.this.inAppUpdateType;
                            HomeActivity homeActivity = HomeActivity.this;
                            appUpdateManager.startUpdateFlowForResult(appUpdateInfo, i, homeActivity, homeActivity.RC_APP_UPDATE);
                        } catch (IntentSender.SendIntentException unused) {
                        }
                    }
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createMenus() {
        com.appnew.android.pojo.Userinfo.Data loggedInUser = SharedPreference.getInstance().getLoggedInUser();
        if (loggedInUser.getProfilePicture() != null) {
            this.profileImage.setVisibility(0);
            Glide.with((FragmentActivity) this).load(loggedInUser.getProfilePicture()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.course_placeholder)).into(this.profileImage);
        } else {
            this.profileImage.setVisibility(0);
            this.profileImageText.setVisibility(8);
            this.profileImage.setImageResource(R.mipmap.default_pic);
        }
        if (!TextUtils.isEmpty(loggedInUser.getName()) && !TextUtils.isEmpty(loggedInUser.getMobile())) {
            this.profileName.setText(loggedInUser.getName());
            this.profileEmail.setText(loggedInUser.getMobile());
        } else {
            this.profileName.setText(getResources().getString(R.string.user));
            this.profileEmail.setText(getResources().getString(R.string.user_mail));
        }
        this.versionnameTV.setText(Html.fromHtml("<b>Version- </b>" + Helper.getVersionName(this)));
        try {
            final LeftNavAdapter leftNavAdapter = new LeftNavAdapter(this, Helper.getLeftMenu());
            this.navRV.setLayoutManager(new LinearLayoutManager(this));
            this.navRV.setAdapter(leftNavAdapter);
            leftNavAdapter.setLeftNavAdapterListener(new LeftNavAdapter.LeftNavAdapterListener() { // from class: com.appnew.android.home.Activity.HomeActivity.9
                @Override // com.appnew.android.home.adapters.LeftNavAdapter.LeftNavAdapterListener
                public void onItemClick(Menu menu) {
                    if (menu.getHaveChild().equalsIgnoreCase("1")) {
                        menu.setExpanded(!menu.isExpanded());
                    }
                    HomeActivity.this.handleLeftMenuClick(menu);
                    leftNavAdapter.notifyDataSetChanged();
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void handleLeftMenuClick(Menu menu) {
        if (menu.getType_code() != null) {
            String type_code = menu.getType_code();
            if (!type_code.equalsIgnoreCase("1") && !Helper.isNetworkConnected(this)) {
                Helper.showInternetToast(this);
            }
            type_code.hashCode();
            byte b2 = -1;
            switch (type_code.hashCode()) {
                case 49:
                    if (type_code.equals("1")) {
                        b2 = 0;
                    }
                    break;
                case 50:
                    if (type_code.equals("2")) {
                        b2 = 1;
                    }
                    break;
                case 51:
                    if (type_code.equals("3")) {
                        b2 = 2;
                    }
                    break;
                case 52:
                    if (type_code.equals("4")) {
                        b2 = 3;
                    }
                    break;
                case 53:
                    if (type_code.equals("5")) {
                        b2 = 4;
                    }
                    break;
                case 54:
                    if (type_code.equals("6")) {
                        b2 = 5;
                    }
                    break;
                case 55:
                    if (type_code.equals("7")) {
                        b2 = 6;
                    }
                    break;
                case 56:
                    if (type_code.equals("8")) {
                        b2 = 7;
                    }
                    break;
                case 57:
                    if (type_code.equals("9")) {
                        b2 = 8;
                    }
                    break;
                case 1567:
                    if (type_code.equals("10")) {
                        b2 = 9;
                    }
                    break;
                case 1568:
                    if (type_code.equals("11")) {
                        b2 = 10;
                    }
                    break;
                case 1569:
                    if (type_code.equals("12")) {
                        b2 = 11;
                    }
                    break;
                case 1570:
                    if (type_code.equals("13")) {
                        b2 = 12;
                    }
                    break;
                case 1571:
                    if (type_code.equals("14")) {
                        b2 = 13;
                    }
                    break;
                case 1572:
                    if (type_code.equals("15")) {
                        b2 = 14;
                    }
                    break;
                case 1573:
                    if (type_code.equals("16")) {
                        b2 = Ascii.SI;
                    }
                    break;
                case 1574:
                    if (type_code.equals("17")) {
                        b2 = 16;
                    }
                    break;
                case 1575:
                    if (type_code.equals("18")) {
                        b2 = 17;
                    }
                    break;
                case 1576:
                    if (type_code.equals("19")) {
                        b2 = Ascii.DC2;
                    }
                    break;
                case 1598:
                    if (type_code.equals("20")) {
                        b2 = 19;
                    }
                    break;
            }
            switch (b2) {
                case 0:
                    Helper.gotoActivity(new Intent(this, (Class<?>) DownloadActivity.class), this);
                    if (this.drawer.isDrawerOpen(GravityCompat.START)) {
                        this.drawer.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 1:
                    if (this.drawer.isDrawerOpen(GravityCompat.START)) {
                        this.drawer.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 2:
                    startActivity(new Intent(this, (Class<?>) UserHistoryActivity.class));
                    if (this.drawer.isDrawerOpen(GravityCompat.START)) {
                        this.drawer.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 3:
                    if (!BuildConfig.FAQ_URL.equalsIgnoreCase(BuildConfig.FAQ_URL)) {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(BuildConfig.FAQ_URL)));
                    } else {
                        Helper.showToast(this, "Still in Development.", 0);
                    }
                    if (this.drawer.isDrawerOpen(GravityCompat.START)) {
                        this.drawer.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 4:
                    ContactBottomSheetFragment contactBottomSheetFragment = new ContactBottomSheetFragment();
                    contactBottomSheetFragment.show(getSupportFragmentManager(), contactBottomSheetFragment.getTag());
                    if (this.drawer.isDrawerOpen(GravityCompat.START)) {
                        this.drawer.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 5:
                    try {
                        Intent intent = new Intent("android.intent.action.SEND");
                        intent.setType(HTTP.PLAIN_TEXT_TYPE);
                        intent.putExtra("android.intent.extra.SUBJECT", getResources().getString(R.string.app_name));
                        intent.putExtra("android.intent.extra.TEXT", (("\nI recommend you to learn from next-gen Smart courses. Uncover a whole new way of learning with " + getResources().getString(R.string.app_name) + ". Learn, practice & create custom tests and much more. Download ") + "https://play.google.com/store/apps/details?id=com.eduteria.app.app") + " and start learning now");
                        startActivity(Intent.createChooser(intent, "choose one"));
                        break;
                    } catch (Exception unused) {
                    }
                    if (this.drawer.isDrawerOpen(GravityCompat.START)) {
                        this.drawer.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 6:
                    if (this.drawer.isDrawerOpen(GravityCompat.START)) {
                        this.drawer.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 7:
                    startActivity(new Intent(this, (Class<?>) SettingsActivity.class));
                    if (this.drawer.isDrawerOpen(GravityCompat.START)) {
                        this.drawer.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 8:
                    if (SharedPreference.getInstance().getLoggedInUser().getId().equalsIgnoreCase("0")) {
                        Helper.GuestSignOutUser(this);
                    } else {
                        getLogoutDialog(this, getResources().getString(R.string.logout_title), getResources().getString(R.string.logout_confirmation_message));
                    }
                    if (this.drawer.isDrawerOpen(GravityCompat.START)) {
                        this.drawer.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 9:
                    if (this.drawer.isDrawerOpen(GravityCompat.START)) {
                        this.drawer.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 10:
                    if (this.drawer.isDrawerOpen(GravityCompat.START)) {
                        this.drawer.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 11:
                    if (this.drawer.isDrawerOpen(GravityCompat.START)) {
                        this.drawer.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 12:
                    getmyQuires();
                    if (this.drawer.isDrawerOpen(GravityCompat.START)) {
                        this.drawer.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 13:
                    if (BuildConfig.APPLICATION_ID.equalsIgnoreCase("com.utkarshnew.android")) {
                        Intent intent2 = new Intent(this, (Class<?>) WebViewActivty.class);
                        intent2.putExtra("type", "OFFLINE BATCH");
                        intent2.putExtra("url", "https://courses.utkarsh.com/offlineadmission/home.php");
                        startActivity(intent2);
                    } else {
                        Helper.showToast(this, "Still in Development.", 0);
                    }
                    if (this.drawer.isDrawerOpen(GravityCompat.START)) {
                        this.drawer.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 14:
                    startActivity(new Intent(this, (Class<?>) PurchaseHistory.class));
                    if (this.drawer.isDrawerOpen(GravityCompat.START)) {
                        this.drawer.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 15:
                    if (BuildConfig.APPLICATION_ID.equalsIgnoreCase("com.utkarshnew.android")) {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.youtube.com/playlist?list=PLoZP2WsNfBSFGsub-jJb_uNW58zQRpDXc")));
                    } else {
                        Helper.showToast(this, "Still in Development.", 0);
                    }
                    if (this.drawer.isDrawerOpen(GravityCompat.START)) {
                        this.drawer.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 16:
                    if (this.drawer.isDrawerOpen(GravityCompat.START)) {
                        this.drawer.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 17:
                    startActivity(new Intent(this, (Class<?>) CourseTransferActivity.class));
                    if (this.drawer.isDrawerOpen(GravityCompat.START)) {
                        this.drawer.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 18:
                    if (BuildConfig.APPLICATION_ID.equalsIgnoreCase("com.utkarshnew.android")) {
                        this.backstatus = false;
                        this.forchatbot.setVisibility(0);
                        if (!Helper.isNetworkConnected(this)) {
                            Helper.showInternetToast(this);
                        }
                        if (this.fragment == null) {
                            this.fragment = new Chatboot();
                            getSupportFragmentManager().beginTransaction().add(R.id.forchatbot, this.fragment).commit();
                        }
                    } else {
                        Helper.showToast(this, getResources().getString(R.string.still_in_development), 0);
                    }
                    if (this.drawer.isDrawerOpen(GravityCompat.START)) {
                        this.drawer.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 19:
                    Helper.gotoActivity(new Intent(this, (Class<?>) CouponActivity.class), this);
                    if (this.drawer.isDrawerOpen(GravityCompat.START)) {
                        this.drawer.closeDrawer(GravityCompat.START);
                    }
                    break;
            }
        }
    }

    private void hit_api_for_filter() {
        this.networkCall.NetworkAPICall(API.get_filter_data, "", true, false);
    }

    public void getLogoutDialog(final Activity ctx, final String title, final String message) {
        DialogUtils.makeDialog(this, title, message, getResources().getString(R.string.yes), getResources().getString(R.string.no), true, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.home.Activity.HomeActivity.10
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
            public void onOKClick() {
                if (Helper.isConnected(HomeActivity.this)) {
                    HomeActivity.this.UserLogout();
                } else {
                    HomeActivity homeActivity = HomeActivity.this;
                    Toast.makeText(homeActivity, homeActivity.getResources().getString(R.string.no_internet_connection), 0).show();
                }
            }
        }, new DialogUtils.onDialogUtilsCancelClick() { // from class: com.appnew.android.home.Activity.HomeActivity.11
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsCancelClick
            public void onCancelClick() {
            }
        });
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        switch (apitype) {
            case "https://appapi.videocrypt.in/index.php/data_model/master_hit/content":
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setUser_id(MakeMyExam.getUserId());
                return service.master_content(AES.encrypt(new Gson().toJson(encryptionData)));
            case "https://appapi.videocrypt.in/index.php/data_model/test/get_instructions":
                EncryptionData encryptionData2 = new EncryptionData();
                encryptionData2.setTest_id(this.quiz_id);
                encryptionData2.setCourse_id(this.course_id);
                return service.API_GET_TEST_INSTRUCTION_DATA(AES.encrypt(new Gson().toJson(encryptionData2)));
            case "https://appapi.videocrypt.in/index.php/data_model/notification/mark_as_read":
                EncryptionData encryptionData3 = new EncryptionData();
                encryptionData3.setId(this.selectedpositionid);
                return service.setread(AES.encrypt(new Gson().toJson(encryptionData3)));
            case "https://appapi.videocrypt.in/index.php/data_model/help_desk/get_my_queries":
                EncryptionData encryptionData4 = new EncryptionData();
                encryptionData4.setPage("1");
                encryptionData4.setCourse_id("0");
                return service.getMyHelpQuires(AES.encrypt(new Gson().toJson(encryptionData4)));
            case "https://appapi.videocrypt.in/index.php/data_model/course/get_course_filters":
                EncryptionData encryptionData5 = new EncryptionData();
                encryptionData5.setSub_cat_id(this.allsubcatindex_id);
                return service.getFilterData(AES.encrypt(new Gson().toJson(encryptionData5)));
            case "https://appapi.videocrypt.in/index.php/data_model/course/get_master_data":
                EncryptionData encryptionData6 = new EncryptionData();
                encryptionData6.setTile_id(this.tileid);
                encryptionData6.setType(this.tiletype);
                encryptionData6.setRevert_api(this.revertapi);
                encryptionData6.setCourse_id(this.course_id);
                encryptionData6.setFile_id(this.fieldid);
                encryptionData6.setParent_id(this.parentid);
                encryptionData6.setLayer("3");
                encryptionData6.setPage("1");
                encryptionData6.setSubject_id("");
                encryptionData6.setTopic_id(this.topicid);
                return service.getMasterDataVideoThree(AES.encrypt(new Gson().toJson(encryptionData6)));
            case "https://appapi.videocrypt.in/index.php/data_model/users/logout":
                EncryptionData encryptionData7 = new EncryptionData();
                encryptionData7.setUser_id(SharedPreference.getInstance().getLoggedInUser().getId());
                return service.getUserLogout(AES.encrypt(new Gson().toJson(encryptionData7)));
            case "data_model/coupon/is_coupon_available":
                return service.IS_COUPON_AVAILABLE("");
            case "https://appapi.videocrypt.in/index.php/data_model/test/get_test_data":
                EncryptionData encryptionData8 = new EncryptionData();
                encryptionData8.setTest_id(this.quiz_id);
                encryptionData8.setCourse_id(this.course_id);
                return service.API_GET_INFO_TEST_SERIES(AES.encrypt(new Gson().toJson(encryptionData8)));
            case "https://appapi.videocrypt.in/index.php/data_model/course/get_courses":
                try {
                    checkdeeplick();
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                EncryptionData encryptionData9 = new EncryptionData();
                encryptionData9.setCourse_type(this.contentType_id);
                encryptionData9.setSub_cat(this.allsubcatindex_id);
                encryptionData9.setLang(this.SelectedLaunguageid);
                encryptionData9.setPage("" + this.pagecount);
                encryptionData9.setIs_paid(this.is_paid);
                return service.get_courses(AES.encrypt(new Gson().toJson(encryptionData9)));
            default:
                return null;
        }
    }

    private void checkdeeplick() {
        String str = this.parentid;
        if (str == null || str.equalsIgnoreCase("")) {
            if (SharedPreference.getInstance().getString("maincourseid").equalsIgnoreCase("")) {
                return;
            }
            Intent intent = new Intent(this, (Class<?>) CourseActivity.class);
            intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
            intent.putExtra(Const.COURSE_ID_MAIN, SharedPreference.getInstance().getString("maincourseid"));
            intent.putExtra(Const.COURSE_PARENT_ID, "");
            intent.putExtra(Const.IS_COMBO, false);
            startActivity(intent);
            SharedPreference.getInstance().putString("maincourseid", "");
            return;
        }
        if (SharedPreference.getInstance().getString("maincourseid").equalsIgnoreCase("")) {
            return;
        }
        Intent intent2 = new Intent(this, (Class<?>) CourseActivity.class);
        intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
        intent2.putExtra(Const.COURSE_ID_MAIN, this.parentid);
        intent2.putExtra(Const.COURSE_PARENT_ID, "");
        intent2.putExtra(Const.IS_COMBO, false);
        startActivity(intent2);
        SharedPreference.getInstance().putString("maincourseid", "");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:110:0x04f5 A[Catch: Exception -> 0x09de, TryCatch #1 {Exception -> 0x09de, blocks: (B:48:0x00a7, B:50:0x00ab, B:52:0x00b1, B:53:0x00b6, B:56:0x00c2, B:58:0x00c6, B:60:0x00cc, B:62:0x00dd, B:65:0x014a, B:67:0x0150, B:69:0x0156, B:70:0x015d, B:72:0x0178, B:74:0x0197, B:76:0x019b, B:78:0x01a9, B:80:0x01e4, B:91:0x036b, B:94:0x0371, B:96:0x037a, B:97:0x0382, B:99:0x0388, B:101:0x03c7, B:103:0x0478, B:105:0x0487, B:104:0x0480, B:106:0x04b8, B:108:0x04be, B:125:0x0670, B:127:0x0674, B:128:0x067c, B:130:0x0682, B:132:0x06ed, B:134:0x06f7, B:135:0x06fe, B:137:0x0708, B:139:0x0716, B:140:0x071d, B:141:0x0724, B:142:0x072b, B:159:0x080b, B:161:0x0810, B:163:0x082b, B:143:0x0742, B:144:0x074a, B:146:0x0750, B:148:0x07b9, B:150:0x07c3, B:151:0x07c9, B:153:0x07d3, B:155:0x07e1, B:156:0x07e8, B:157:0x07ef, B:158:0x07f6, B:110:0x04f5, B:112:0x04ff, B:113:0x0507, B:115:0x050d, B:117:0x054c, B:119:0x05f6, B:121:0x0605, B:120:0x05fe, B:122:0x0636, B:124:0x063c, B:81:0x0227, B:82:0x027d, B:84:0x02b8, B:85:0x02fa, B:86:0x034f, B:88:0x035d, B:90:0x0368, B:165:0x0838, B:167:0x083c, B:169:0x0841, B:171:0x0845, B:173:0x08a9, B:175:0x08b7, B:64:0x0105, B:177:0x08c7, B:179:0x08cb, B:181:0x0906, B:182:0x0945, B:183:0x0996, B:185:0x099f, B:187:0x09a5, B:188:0x09ac, B:190:0x09b0, B:192:0x09b5, B:193:0x09c5, B:195:0x09cb, B:197:0x09d1, B:198:0x09d5), top: B:494:0x00a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0674 A[Catch: Exception -> 0x09de, TryCatch #1 {Exception -> 0x09de, blocks: (B:48:0x00a7, B:50:0x00ab, B:52:0x00b1, B:53:0x00b6, B:56:0x00c2, B:58:0x00c6, B:60:0x00cc, B:62:0x00dd, B:65:0x014a, B:67:0x0150, B:69:0x0156, B:70:0x015d, B:72:0x0178, B:74:0x0197, B:76:0x019b, B:78:0x01a9, B:80:0x01e4, B:91:0x036b, B:94:0x0371, B:96:0x037a, B:97:0x0382, B:99:0x0388, B:101:0x03c7, B:103:0x0478, B:105:0x0487, B:104:0x0480, B:106:0x04b8, B:108:0x04be, B:125:0x0670, B:127:0x0674, B:128:0x067c, B:130:0x0682, B:132:0x06ed, B:134:0x06f7, B:135:0x06fe, B:137:0x0708, B:139:0x0716, B:140:0x071d, B:141:0x0724, B:142:0x072b, B:159:0x080b, B:161:0x0810, B:163:0x082b, B:143:0x0742, B:144:0x074a, B:146:0x0750, B:148:0x07b9, B:150:0x07c3, B:151:0x07c9, B:153:0x07d3, B:155:0x07e1, B:156:0x07e8, B:157:0x07ef, B:158:0x07f6, B:110:0x04f5, B:112:0x04ff, B:113:0x0507, B:115:0x050d, B:117:0x054c, B:119:0x05f6, B:121:0x0605, B:120:0x05fe, B:122:0x0636, B:124:0x063c, B:81:0x0227, B:82:0x027d, B:84:0x02b8, B:85:0x02fa, B:86:0x034f, B:88:0x035d, B:90:0x0368, B:165:0x0838, B:167:0x083c, B:169:0x0841, B:171:0x0845, B:173:0x08a9, B:175:0x08b7, B:64:0x0105, B:177:0x08c7, B:179:0x08cb, B:181:0x0906, B:182:0x0945, B:183:0x0996, B:185:0x099f, B:187:0x09a5, B:188:0x09ac, B:190:0x09b0, B:192:0x09b5, B:193:0x09c5, B:195:0x09cb, B:197:0x09d1, B:198:0x09d5), top: B:494:0x00a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0742 A[Catch: Exception -> 0x09de, TryCatch #1 {Exception -> 0x09de, blocks: (B:48:0x00a7, B:50:0x00ab, B:52:0x00b1, B:53:0x00b6, B:56:0x00c2, B:58:0x00c6, B:60:0x00cc, B:62:0x00dd, B:65:0x014a, B:67:0x0150, B:69:0x0156, B:70:0x015d, B:72:0x0178, B:74:0x0197, B:76:0x019b, B:78:0x01a9, B:80:0x01e4, B:91:0x036b, B:94:0x0371, B:96:0x037a, B:97:0x0382, B:99:0x0388, B:101:0x03c7, B:103:0x0478, B:105:0x0487, B:104:0x0480, B:106:0x04b8, B:108:0x04be, B:125:0x0670, B:127:0x0674, B:128:0x067c, B:130:0x0682, B:132:0x06ed, B:134:0x06f7, B:135:0x06fe, B:137:0x0708, B:139:0x0716, B:140:0x071d, B:141:0x0724, B:142:0x072b, B:159:0x080b, B:161:0x0810, B:163:0x082b, B:143:0x0742, B:144:0x074a, B:146:0x0750, B:148:0x07b9, B:150:0x07c3, B:151:0x07c9, B:153:0x07d3, B:155:0x07e1, B:156:0x07e8, B:157:0x07ef, B:158:0x07f6, B:110:0x04f5, B:112:0x04ff, B:113:0x0507, B:115:0x050d, B:117:0x054c, B:119:0x05f6, B:121:0x0605, B:120:0x05fe, B:122:0x0636, B:124:0x063c, B:81:0x0227, B:82:0x027d, B:84:0x02b8, B:85:0x02fa, B:86:0x034f, B:88:0x035d, B:90:0x0368, B:165:0x0838, B:167:0x083c, B:169:0x0841, B:171:0x0845, B:173:0x08a9, B:175:0x08b7, B:64:0x0105, B:177:0x08c7, B:179:0x08cb, B:181:0x0906, B:182:0x0945, B:183:0x0996, B:185:0x099f, B:187:0x09a5, B:188:0x09ac, B:190:0x09b0, B:192:0x09b5, B:193:0x09c5, B:195:0x09cb, B:197:0x09d1, B:198:0x09d5), top: B:494:0x00a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0810 A[Catch: Exception -> 0x09de, TryCatch #1 {Exception -> 0x09de, blocks: (B:48:0x00a7, B:50:0x00ab, B:52:0x00b1, B:53:0x00b6, B:56:0x00c2, B:58:0x00c6, B:60:0x00cc, B:62:0x00dd, B:65:0x014a, B:67:0x0150, B:69:0x0156, B:70:0x015d, B:72:0x0178, B:74:0x0197, B:76:0x019b, B:78:0x01a9, B:80:0x01e4, B:91:0x036b, B:94:0x0371, B:96:0x037a, B:97:0x0382, B:99:0x0388, B:101:0x03c7, B:103:0x0478, B:105:0x0487, B:104:0x0480, B:106:0x04b8, B:108:0x04be, B:125:0x0670, B:127:0x0674, B:128:0x067c, B:130:0x0682, B:132:0x06ed, B:134:0x06f7, B:135:0x06fe, B:137:0x0708, B:139:0x0716, B:140:0x071d, B:141:0x0724, B:142:0x072b, B:159:0x080b, B:161:0x0810, B:163:0x082b, B:143:0x0742, B:144:0x074a, B:146:0x0750, B:148:0x07b9, B:150:0x07c3, B:151:0x07c9, B:153:0x07d3, B:155:0x07e1, B:156:0x07e8, B:157:0x07ef, B:158:0x07f6, B:110:0x04f5, B:112:0x04ff, B:113:0x0507, B:115:0x050d, B:117:0x054c, B:119:0x05f6, B:121:0x0605, B:120:0x05fe, B:122:0x0636, B:124:0x063c, B:81:0x0227, B:82:0x027d, B:84:0x02b8, B:85:0x02fa, B:86:0x034f, B:88:0x035d, B:90:0x0368, B:165:0x0838, B:167:0x083c, B:169:0x0841, B:171:0x0845, B:173:0x08a9, B:175:0x08b7, B:64:0x0105, B:177:0x08c7, B:179:0x08cb, B:181:0x0906, B:182:0x0945, B:183:0x0996, B:185:0x099f, B:187:0x09a5, B:188:0x09ac, B:190:0x09b0, B:192:0x09b5, B:193:0x09c5, B:195:0x09cb, B:197:0x09d1, B:198:0x09d5), top: B:494:0x00a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x082b A[Catch: Exception -> 0x09de, TryCatch #1 {Exception -> 0x09de, blocks: (B:48:0x00a7, B:50:0x00ab, B:52:0x00b1, B:53:0x00b6, B:56:0x00c2, B:58:0x00c6, B:60:0x00cc, B:62:0x00dd, B:65:0x014a, B:67:0x0150, B:69:0x0156, B:70:0x015d, B:72:0x0178, B:74:0x0197, B:76:0x019b, B:78:0x01a9, B:80:0x01e4, B:91:0x036b, B:94:0x0371, B:96:0x037a, B:97:0x0382, B:99:0x0388, B:101:0x03c7, B:103:0x0478, B:105:0x0487, B:104:0x0480, B:106:0x04b8, B:108:0x04be, B:125:0x0670, B:127:0x0674, B:128:0x067c, B:130:0x0682, B:132:0x06ed, B:134:0x06f7, B:135:0x06fe, B:137:0x0708, B:139:0x0716, B:140:0x071d, B:141:0x0724, B:142:0x072b, B:159:0x080b, B:161:0x0810, B:163:0x082b, B:143:0x0742, B:144:0x074a, B:146:0x0750, B:148:0x07b9, B:150:0x07c3, B:151:0x07c9, B:153:0x07d3, B:155:0x07e1, B:156:0x07e8, B:157:0x07ef, B:158:0x07f6, B:110:0x04f5, B:112:0x04ff, B:113:0x0507, B:115:0x050d, B:117:0x054c, B:119:0x05f6, B:121:0x0605, B:120:0x05fe, B:122:0x0636, B:124:0x063c, B:81:0x0227, B:82:0x027d, B:84:0x02b8, B:85:0x02fa, B:86:0x034f, B:88:0x035d, B:90:0x0368, B:165:0x0838, B:167:0x083c, B:169:0x0841, B:171:0x0845, B:173:0x08a9, B:175:0x08b7, B:64:0x0105, B:177:0x08c7, B:179:0x08cb, B:181:0x0906, B:182:0x0945, B:183:0x0996, B:185:0x099f, B:187:0x09a5, B:188:0x09ac, B:190:0x09b0, B:192:0x09b5, B:193:0x09c5, B:195:0x09cb, B:197:0x09d1, B:198:0x09d5), top: B:494:0x00a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0371 A[Catch: Exception -> 0x09de, TRY_ENTER, TryCatch #1 {Exception -> 0x09de, blocks: (B:48:0x00a7, B:50:0x00ab, B:52:0x00b1, B:53:0x00b6, B:56:0x00c2, B:58:0x00c6, B:60:0x00cc, B:62:0x00dd, B:65:0x014a, B:67:0x0150, B:69:0x0156, B:70:0x015d, B:72:0x0178, B:74:0x0197, B:76:0x019b, B:78:0x01a9, B:80:0x01e4, B:91:0x036b, B:94:0x0371, B:96:0x037a, B:97:0x0382, B:99:0x0388, B:101:0x03c7, B:103:0x0478, B:105:0x0487, B:104:0x0480, B:106:0x04b8, B:108:0x04be, B:125:0x0670, B:127:0x0674, B:128:0x067c, B:130:0x0682, B:132:0x06ed, B:134:0x06f7, B:135:0x06fe, B:137:0x0708, B:139:0x0716, B:140:0x071d, B:141:0x0724, B:142:0x072b, B:159:0x080b, B:161:0x0810, B:163:0x082b, B:143:0x0742, B:144:0x074a, B:146:0x0750, B:148:0x07b9, B:150:0x07c3, B:151:0x07c9, B:153:0x07d3, B:155:0x07e1, B:156:0x07e8, B:157:0x07ef, B:158:0x07f6, B:110:0x04f5, B:112:0x04ff, B:113:0x0507, B:115:0x050d, B:117:0x054c, B:119:0x05f6, B:121:0x0605, B:120:0x05fe, B:122:0x0636, B:124:0x063c, B:81:0x0227, B:82:0x027d, B:84:0x02b8, B:85:0x02fa, B:86:0x034f, B:88:0x035d, B:90:0x0368, B:165:0x0838, B:167:0x083c, B:169:0x0841, B:171:0x0845, B:173:0x08a9, B:175:0x08b7, B:64:0x0105, B:177:0x08c7, B:179:0x08cb, B:181:0x0906, B:182:0x0945, B:183:0x0996, B:185:0x099f, B:187:0x09a5, B:188:0x09ac, B:190:0x09b0, B:192:0x09b5, B:193:0x09c5, B:195:0x09cb, B:197:0x09d1, B:198:0x09d5), top: B:494:0x00a7 }] */
    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void SuccessCallBack(org.json.JSONObject r43, java.lang.String r44, java.lang.String r45, boolean r46) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 4830
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.home.Activity.HomeActivity.SuccessCallBack(org.json.JSONObject, java.lang.String, java.lang.String, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$SuccessCallBack$33() {
        UtkashRoom utkashRoom = this.utkashRoom;
        if (utkashRoom == null || utkashRoom.getHomeApiStatusdata() == null || this.utkashRoom.getHomeApiStatusdata().isRecordExistsUserId(MakeMyExam.userId, this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id)) {
            return;
        }
        selecteddata();
    }

    private void pushEvent() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("date", AnalyticHelper.INSTANCE.getCurrentDateTimeForEvent());
        map.put("user_id", AnalyticHelper.INSTANCE.getUserId());
        map.put(AnalyticsConstants.device_type, AnalyticHelper.INSTANCE.getDeviceType());
        map.put(AnalyticsConstants.test_name, this.testname);
        map.put("test_id", this.quiz_id);
        map.put(AnalyticsConstants.content_flag, getContentAccess());
        AnalyticEvents.INSTANCE.pushEvents(this, AnalyticsConstants.TEST_ATTEMPT, map);
    }

    private String getContentAccess() {
        Video video;
        Video video2 = this.videodata;
        return ((video2 == null || TextUtils.isEmpty(video2.getIs_test_purchased()) || !this.videodata.getIs_test_purchased().equals("1")) && (video = this.videodata) != null && !TextUtils.isEmpty(video.getIs_locked()) && this.videodata.getIs_locked().equals("1")) ? "Paid" : "Free";
    }

    private void showPopUp(final InstructionData instructionData) {
        CheckBox checkBox;
        Button button;
        View viewInflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.popup_basicinfo_quiz_career, (ViewGroup) null, false);
        final Dialog dialog = new Dialog(this, R.style.CustomAlertDialog);
        dialog.requestWindowFeature(1);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(viewInflate);
        dialog.getWindow().setLayout(-1, -1);
        dialog.show();
        final TestBasicInst testBasic = instructionData.getTestBasic();
        TextView textView = (TextView) viewInflate.findViewById(R.id.quizTitleTV);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.marksTextValueTV);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.numQuesValueTV);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.sectionValueTV);
        final TextView textView5 = (TextView) viewInflate.findViewById(R.id.languageSpinnerTV);
        TextView textView6 = (TextView) viewInflate.findViewById(R.id.quizTimeValueTV);
        TextView textView7 = (TextView) viewInflate.findViewById(R.id.remarksTV);
        CheckBox checkBox2 = (CheckBox) viewInflate.findViewById(R.id.check_box);
        TextView textView8 = (TextView) viewInflate.findViewById(R.id.generalInstrValueTV);
        Button button2 = (Button) viewInflate.findViewById(R.id.startQuizBtn);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.sectionListLL);
        LinearLayout linearLayout2 = (LinearLayout) viewInflate.findViewById(R.id.general_layout);
        LinearLayout linearLayout3 = (LinearLayout) viewInflate.findViewById(R.id.section_time);
        if (TextUtils.isEmpty(testBasic.getLang_id())) {
            checkBox = checkBox2;
        } else {
            checkBox = checkBox2;
            this.langIds = testBasic.getLang_id().split(Constants.SEPARATOR_COMMA);
        }
        if (testBasic.getTest_assets() != null) {
            button = button2;
            if (testBasic.getTest_assets().getHide_inst_time().equalsIgnoreCase("0")) {
                linearLayout3.setVisibility(0);
            } else {
                linearLayout3.setVisibility(4);
            }
        } else {
            button = button2;
        }
        addSectionView(linearLayout, instructionData);
        if (SharedPreference.getInstance().getBoolean(Const.RE_ATTEMPT)) {
            textView7.setVisibility(8);
        } else {
            textView7.setVisibility(8);
        }
        if (testBasic.getLang_id().length() == 3) {
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.Activity.HomeActivity.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HomeActivity.this.showPopMenuForLangauge(textView5, testBasic);
                }
            });
        }
        if (testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("1")) {
            textView5.setText(getResources().getStringArray(R.array.dialog_choose_language_array)[0]);
            this.lang = Integer.parseInt(testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
        } else if (testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("2")) {
            textView5.setText(getResources().getStringArray(R.array.dialog_choose_language_array)[1]);
            this.lang = Integer.parseInt(testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
        }
        textView.setText(testBasic.getTestSeriesName());
        textView3.setText(testBasic.getTotalQuestions());
        textView6.setText(testBasic.getTimeInMins());
        textView2.setText(testBasic.getTotalMarks());
        if (testBasic.getDescription().isEmpty()) {
            linearLayout2.setVisibility(8);
        } else {
            linearLayout2.setVisibility(0);
            textView8.setText(Html.fromHtml(testBasic.getDescription()));
        }
        textView4.setText("" + instructionData.getTestSections().size());
        Button button3 = button;
        button3.setTag(testBasic);
        final CheckBox checkBox3 = checkBox;
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.Activity.HomeActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (testBasic.getTotalQuestions().equalsIgnoreCase("0")) {
                    HomeActivity homeActivity = HomeActivity.this;
                    Toast.makeText(homeActivity, homeActivity.getResources().getString(R.string.please_add_question), 0).show();
                } else {
                    if (checkBox3.isChecked()) {
                        dialog.dismiss();
                        HomeActivity.this.quiz_id = testBasic.getId();
                        HomeActivity homeActivity2 = HomeActivity.this;
                        new NetworkCall(homeActivity2, homeActivity2).NetworkAPICall(API.API_GET_INFO_TEST_SERIES, "", true, false);
                        return;
                    }
                    HomeActivity homeActivity3 = HomeActivity.this;
                    Toast.makeText(homeActivity3, homeActivity3.getResources().getString(R.string.please_check_following_instructions), 0).show();
                }
            }
        });
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.appnew.android.home.Activity.HomeActivity.15
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialog2, int keyCode, KeyEvent event) {
                if (keyCode != 4) {
                    return true;
                }
                HomeActivity.this.initialzehomepage();
                dialog.dismiss();
                return true;
            }
        });
    }

    private void addSectionView(LinearLayout sectionListLL, InstructionData instructionData) {
        Iterator<TestSectionInst> it = instructionData.getTestSections().iterator();
        int i = 0;
        while (it.hasNext()) {
            sectionListLL.addView(initSectionListView(it.next(), i, instructionData.getTestBasic().getTest_assets() == null ? "" : instructionData.getTestBasic().getTest_assets().getHide_inst_time()));
            i++;
        }
    }

    public LinearLayout initSectionListView(TestSectionInst testSectionInst, int tag, String hide_inst_time) {
        int intSafe;
        ArrayList arrayList = new ArrayList();
        LinearLayout linearLayout = (LinearLayout) View.inflate(this, R.layout.layout_option_section_list_view, null);
        TextView textView = (TextView) linearLayout.findViewById(R.id.secNameTV);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.totQuesTV);
        TextView textView3 = (TextView) linearLayout.findViewById(R.id.totNoAttmtsTV);
        TextView textView4 = (TextView) linearLayout.findViewById(R.id.totTimeTV);
        TextView textView5 = (TextView) linearLayout.findViewById(R.id.maxMarksTV);
        TextView textView6 = (TextView) linearLayout.findViewById(R.id.markPerQuesTV);
        TextView textView7 = (TextView) linearLayout.findViewById(R.id.negMarkPerQuesTV);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        linearLayout.setLayoutParams(layoutParams);
        if (!hide_inst_time.equalsIgnoreCase("")) {
            if (hide_inst_time.equalsIgnoreCase("0")) {
                textView4.setVisibility(0);
            } else {
                textView4.setVisibility(4);
            }
        }
        textView.setText(testSectionInst.getName() + "\n(" + testSectionInst.getSectionPart() + ")");
        textView2.setText(testSectionInst.getTotalQuestions());
        textView3.setText(TextUtils.isEmpty(testSectionInst.getTotalNumOfAttempts()) ? "" : testSectionInst.getTotalNumOfAttempts());
        textView4.setText(testSectionInst.getSectionTiming());
        float floatSafe = Helper.parseFloatSafe(testSectionInst.getMarksPerQuestion());
        if (!TextUtils.isEmpty(testSectionInst.getTotalNumOfAttempts())) {
            intSafe = Helper.parseIntSafe(testSectionInst.getTotalNumOfAttempts());
        } else {
            intSafe = Helper.parseIntSafe(testSectionInst.getTotalQuestions());
        }
        textView5.setText(String.valueOf(floatSafe * intSafe));
        textView6.setText(testSectionInst.getMarksPerQuestion());
        textView7.setText(String.valueOf(Helper.parseFloatSafe(testSectionInst.getNegativeMarks())));
        linearLayout.setTag(Integer.valueOf(tag));
        arrayList.add(linearLayout);
        return linearLayout;
    }

    public void showPopMenuForLangauge(final View v, TestBasicInst testBasicInst) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.home.Activity.HomeActivity.16
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem item) {
                ((TextView) v).setText(item.getTitle().toString());
                if (item.getTitle().toString().equals(HomeActivity.this.getResources().getString(R.string.hindi))) {
                    HomeActivity.this.lang = 2;
                    return false;
                }
                if (!item.getTitle().toString().equals(HomeActivity.this.getResources().getString(R.string.english))) {
                    return false;
                }
                HomeActivity.this.lang = 1;
                return false;
            }
        });
        for (int i = 0; i < testBasicInst.getLang_id().split(Constants.SEPARATOR_COMMA).length; i++) {
            if (testBasicInst.getLang_id().split(Constants.SEPARATOR_COMMA)[i].equals("1")) {
                popupMenu.getMenu().add(getResources().getStringArray(R.array.dialog_choose_language_array)[0]);
            } else if (testBasicInst.getLang_id().split(Constants.SEPARATOR_COMMA)[i].equals("2")) {
                popupMenu.getMenu().add(getResources().getStringArray(R.array.dialog_choose_language_array)[1]);
            }
        }
        popupMenu.show();
    }

    private void inittest(Video video) {
        if (this.notification_code == 125) {
            if (video.getIs_locked().equalsIgnoreCase("1")) {
                String str = this.parentid;
                if (str == null || str.equalsIgnoreCase("")) {
                    Intent intent = new Intent(this, (Class<?>) CourseActivity.class);
                    intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent.putExtra(Const.COURSE_ID_MAIN, video.getPayloadData().getCourse_id());
                    intent.putExtra(Const.COURSE_PARENT_ID, "");
                    intent.putExtra(Const.IS_COMBO, false);
                    SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                    startActivity(intent);
                    return;
                }
                Intent intent2 = new Intent(this, (Class<?>) CourseActivity.class);
                intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                intent2.putExtra(Const.COURSE_ID_MAIN, this.parentid);
                intent2.putExtra(Const.COURSE_PARENT_ID, "");
                intent2.putExtra(Const.IS_COMBO, false);
                SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                startActivity(intent2);
                return;
            }
            this.quiz_id = video.getId();
            this.first_attempt = "1";
            this.result_date = video.getResult_date();
            SharedPreference.getInstance().putString("id", this.course_id);
            this.testname = video.getTest_series_name();
            this.testquestion = video.getTotal_questions();
            this.videodata = video;
            hit_api_for_iniializetest();
        }
    }

    private void hit_api_for_iniializetest() {
        new NetworkCall(this, this).NetworkAPICall(API.API_GET_TEST_INSTRUCTION_DATA, "", true, false);
    }

    private void initLivevideo(Video video) {
        int i = this.notification_code;
        boolean z = false;
        if (i != 90002) {
            if (i == 123) {
                if (video.getIs_locked().equalsIgnoreCase("1")) {
                    String str = this.parentid;
                    if (str == null || str.equalsIgnoreCase("")) {
                        Intent intent = new Intent(this, (Class<?>) CourseActivity.class);
                        intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                        intent.putExtra(Const.COURSE_ID_MAIN, video.getPayloadData().getCourse_id());
                        intent.putExtra(Const.COURSE_PARENT_ID, "");
                        intent.putExtra(Const.IS_COMBO, false);
                        SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                        Helper.gotoActivity(intent, this);
                        return;
                    }
                    Intent intent2 = new Intent(this, (Class<?>) CourseActivity.class);
                    intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent2.putExtra(Const.COURSE_ID_MAIN, this.parentid);
                    intent2.putExtra(Const.COURSE_PARENT_ID, "");
                    intent2.putExtra(Const.IS_COMBO, false);
                    SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                    Helper.gotoActivity(intent2, this);
                    return;
                }
                jwvideo(video);
                return;
            }
            if (i == 124) {
                if (video.getIs_locked().equalsIgnoreCase("1")) {
                    String str2 = this.parentid;
                    if (str2 == null || str2.equalsIgnoreCase("")) {
                        Intent intent3 = new Intent(this, (Class<?>) CourseActivity.class);
                        intent3.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                        intent3.putExtra(Const.COURSE_ID_MAIN, video.getPayloadData().getCourse_id());
                        intent3.putExtra(Const.COURSE_PARENT_ID, "");
                        intent3.putExtra(Const.IS_COMBO, false);
                        SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                        Helper.gotoActivity(intent3, this);
                        return;
                    }
                    Intent intent4 = new Intent(this, (Class<?>) CourseActivity.class);
                    intent4.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent4.putExtra(Const.COURSE_ID_MAIN, this.parentid);
                    intent4.putExtra(Const.COURSE_PARENT_ID, "");
                    intent4.putExtra(Const.IS_COMBO, false);
                    SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                    Helper.gotoActivity(intent4, this);
                    return;
                }
                if (!video.getFile_type().equalsIgnoreCase("7") && TextUtils.isEmpty(video.getFile_url())) {
                    Toast.makeText(this, getResources().getString(R.string.no_pdf_found), 0).show();
                    initialzehomepage();
                    return;
                }
                if (video.getFile_type().equalsIgnoreCase("8")) {
                    Intent intent5 = new Intent(this, (Class<?>) WebViewActivty.class);
                    intent5.putExtra("type", video.getTitle());
                    intent5.putExtra("url", video.getFile_url());
                    intent5.putExtra(Const.VIDEO_ID, video.getId());
                    intent5.putExtra("link", video.getFile_type());
                    intent5.putExtra("course_id", video.getPayloadData().getCourse_id());
                    Helper.gotoActivity(intent5, this);
                }
                if (video.getFile_type().equalsIgnoreCase("7")) {
                    Intent intent6 = new Intent(this, (Class<?>) Concept_newActivity.class);
                    intent6.putExtra("id", video.getId());
                    intent6.putExtra("name", video.getTitle());
                    if (this.parentid == null) {
                        this.parentid = "";
                    }
                    if (this.parentid.equalsIgnoreCase("")) {
                        intent6.putExtra("course_id", video.getPayloadData().getCourse_id() + MqttTopic.MULTI_LEVEL_WILDCARD);
                    } else {
                        intent6.putExtra("course_id", this.parentid + MqttTopic.MULTI_LEVEL_WILDCARD + video.getPayloadData().getCourse_id());
                    }
                    intent6.putExtra("tile_id", video.getPayloadData().getTile_id());
                    Helper.gotoActivity(intent6, this);
                    return;
                }
                if (video.getFile_type().equalsIgnoreCase("1")) {
                    if (!TextUtils.isEmpty(video.getIs_download_available()) && video.getIs_download_available().equalsIgnoreCase("1")) {
                        z = true;
                    }
                    Helper.GoToWebViewPDFActivity(this, video.getId(), video.getFile_url(), z, video.getTitle(), video.getPayloadData().getCourse_id(), video.getIs_share());
                    return;
                }
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(video.getFile_url())) {
            Toast.makeText(this, getResources().getString(R.string.no_video_found), 0).show();
            initialzehomepage();
            return;
        }
        if (video.getVideo_type().equalsIgnoreCase("5")) {
            if (video.getIs_locked().equalsIgnoreCase("1")) {
                String str3 = this.parentid;
                if (str3 == null || str3.equalsIgnoreCase("")) {
                    Intent intent7 = new Intent(this, (Class<?>) CourseActivity.class);
                    intent7.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent7.putExtra(Const.COURSE_ID_MAIN, video.getPayloadData().getCourse_id());
                    intent7.putExtra(Const.COURSE_PARENT_ID, "");
                    intent7.putExtra(Const.IS_COMBO, false);
                    SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                    startActivity(intent7);
                    return;
                }
                Intent intent8 = new Intent(this, (Class<?>) CourseActivity.class);
                intent8.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                intent8.putExtra(Const.COURSE_ID_MAIN, this.parentid);
                intent8.putExtra(Const.COURSE_PARENT_ID, "");
                intent8.putExtra(Const.IS_COMBO, false);
                SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                startActivity(intent8);
                return;
            }
            if (video.getLive_status().equalsIgnoreCase("0")) {
                Toast.makeText(this, getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                initialzehomepage();
                return;
            }
            if (video.getLive_status().equalsIgnoreCase("1")) {
                Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), this, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "0", this.parentid, video.getStart_date(), Helper.addToList(this.videodata));
                return;
            }
            if (video.getLive_status().equalsIgnoreCase("2")) {
                Toast.makeText(this, getResources().getString(R.string.live_class_is_ended), 0).show();
                initialzehomepage();
                return;
            } else {
                if (video.getLive_status().equalsIgnoreCase("3")) {
                    Toast.makeText(this, getResources().getString(R.string.live_class_is_cancelled), 0).show();
                    initialzehomepage();
                    return;
                }
                return;
            }
        }
        if (video.getVideo_type().equalsIgnoreCase("0")) {
            Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), this, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "0", this.parentid, video.getStart_date(), Helper.addToList(this.videodata));
            return;
        }
        if (video.getIs_locked().equalsIgnoreCase("1")) {
            String str4 = this.parentid;
            if (str4 == null || str4.equalsIgnoreCase("")) {
                Intent intent9 = new Intent(this, (Class<?>) CourseActivity.class);
                intent9.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                intent9.putExtra(Const.COURSE_ID_MAIN, video.getPayloadData().getCourse_id());
                intent9.putExtra(Const.COURSE_PARENT_ID, "");
                intent9.putExtra(Const.IS_COMBO, false);
                SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                startActivity(intent9);
                return;
            }
            Intent intent10 = new Intent(this, (Class<?>) CourseActivity.class);
            intent10.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
            intent10.putExtra(Const.COURSE_ID_MAIN, this.parentid);
            intent10.putExtra(Const.COURSE_PARENT_ID, "");
            intent10.putExtra(Const.IS_COMBO, false);
            SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
            startActivity(intent10);
            return;
        }
        if (video.getOpen_in_app() != null && video.getOpen_in_app().equalsIgnoreCase("1")) {
            if (video.getVideo_type().equalsIgnoreCase("4")) {
                if (video.getLive_status().equalsIgnoreCase("0")) {
                    Toast.makeText(this, getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                    initialzehomepage();
                    return;
                }
                if (video.getLive_status().equalsIgnoreCase("1")) {
                    if (SharedPreference.getInstance().getString(Const.Youtube_Player_Control).equalsIgnoreCase("2") || SharedPreference.getInstance().getString(Const.Youtube_Player_Control).equalsIgnoreCase("3")) {
                        Helper.showStreamSelectionBottomSheet(this, video, this.position, MakeMyExam.videoArrayList);
                        return;
                    } else {
                        Helper.GoToLiveVideoActivity(video.getChat_node(), this, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getIs_chat_lock(), video.getPayloadData().getCourse_id(), "", this.parentid, video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), new ArrayList());
                        return;
                    }
                }
                if (video.getLive_status().equalsIgnoreCase("2")) {
                    Toast.makeText(this, getResources().getString(R.string.live_class_is_ended), 0).show();
                    initialzehomepage();
                    return;
                } else {
                    if (video.getLive_status().equalsIgnoreCase("3")) {
                        Toast.makeText(this, getResources().getString(R.string.live_class_is_cancelled), 0).show();
                        initialzehomepage();
                        return;
                    }
                    return;
                }
            }
            if (video.getVideo_type().equalsIgnoreCase("1")) {
                if (SharedPreference.getInstance().getString(Const.Youtube_Player_Control).equalsIgnoreCase("2") || SharedPreference.getInstance().getString(Const.Youtube_Player_Control).equalsIgnoreCase("3")) {
                    Helper.showStreamSelectionBottomSheet(this, video, this.position, MakeMyExam.videoArrayList);
                    return;
                } else {
                    Helper.GoToLiveVideoActivity(video.getChat_node(), this, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getIs_chat_lock(), video.getPayloadData().getCourse_id(), "", this.parentid, video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), new ArrayList());
                    return;
                }
            }
            return;
        }
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + video.getFile_url())));
    }

    private void jwvideo(Video videoData) {
        String str = "https://cdn.jwplayer.com/v2/media/" + videoData.getFile_url().substring(videoData.getFile_url().lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1, videoData.getFile_url().indexOf("-"));
        if (this.utkashRoom.getvideoDownloadao().isvideo_exit(videoData.getId(), MakeMyExam.userId)) {
            VideosDownload videosDownload = this.utkashRoom.getvideoDownloadao().getvideo_byuserid(videoData.getId(), MakeMyExam.userId);
            if (videosDownload.getIs_complete().equalsIgnoreCase("1")) {
                Intent intent = new Intent(this, (Class<?>) DownloadVideoPlayer.class);
                intent.putExtra("video_name", videosDownload.getVideo_name());
                intent.putExtra(Const.VIDEO_ID, videosDownload.getVideo_id());
                intent.putExtra("current_pos", videosDownload.getVideoCurrentPosition());
                intent.putExtra("video", videosDownload.getVideo_history());
                intent.putExtra("video_time", videosDownload.getVideotime());
                intent.putExtra("video_time", videosDownload.getCourse_id());
                Helper.gotoActivity(intent, this);
                return;
            }
            if (this.utkashRoom.getvideoDao().isvideo_exit(videoData.getId(), MakeMyExam.userId)) {
                Helper.GoToJWVideo_Params(this, str, videoData.getId(), videoData.getTitle(), this.utkashRoom.getvideoDao().getuser(videoData.getId(), MakeMyExam.userId).getVideo_currentpos(), videoData.getPayloadData().getCourse_id());
                return;
            }
            VideoTable videoTable = new VideoTable();
            videoTable.setVideo_id(videoData.getId());
            videoTable.setVideo_name(videoData.getTitle());
            videoTable.setJw_url(str);
            videoTable.setVideo_currentpos(0L);
            videoTable.setUser_id(MakeMyExam.userId);
            videoTable.setCourse_id(videoData.getPayloadData().getCourse_id());
            this.utkashRoom.getvideoDao().addUser(videoTable);
            Helper.GoToJWVideo_Params(this, str, videoData.getId(), videoData.getTitle(), 0L, videoData.getPayloadData().getCourse_id());
            return;
        }
        if (this.utkashRoom.getvideoDao().isvideo_exit(videoData.getId(), MakeMyExam.userId)) {
            Helper.GoToJWVideo_Params(this, str, videoData.getId(), videoData.getTitle(), this.utkashRoom.getvideoDao().getuser(videoData.getId(), MakeMyExam.userId).getVideo_currentpos(), videoData.getPayloadData().getCourse_id());
            return;
        }
        VideoTable videoTable2 = new VideoTable();
        videoTable2.setVideo_id(videoData.getId());
        videoTable2.setVideo_name(videoData.getTitle());
        videoTable2.setJw_url(str);
        videoTable2.setVideo_currentpos(0L);
        videoTable2.setUser_id(MakeMyExam.userId);
        videoTable2.setCourse_id(videoData.getPayloadData().getCourse_id());
        this.utkashRoom.getvideoDao().addUser(videoTable2);
        Helper.GoToJWVideo_Params(this, str, videoData.getId(), videoData.getTitle(), 0L, videoData.getPayloadData().getCourse_id());
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        ProgressBar progressBar = this.paginationLoader;
        if (progressBar == null || !progressBar.isShown()) {
            return;
        }
        this.paginationLoader.setVisibility(8);
    }

    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem item) {
        List<CourseDataTable> list;
        List<CourseDataTable> list2;
        if (this.clicktype.equalsIgnoreCase("3")) {
            if (!item.getTitle().equals(this.allsubcatindex)) {
                Iterator<MasteAllCatTable> it = this.selectedsub_all_cat.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MasteAllCatTable next = it.next();
                    if (next.getName().equals(item.getTitle())) {
                        this.isfilterchanged = true;
                        this.isfilterapply = false;
                        this.SelectedLaunguageid = "";
                        this.SelectedSubjectid = "";
                        this.is_paid = "";
                        this.pagecount = 1;
                        this.allsubcatindex = next.getName();
                        if (!this.isFromTileActivity) {
                            this.allsubcatindex_id = next.getId();
                        }
                        this.filterTwo.setText(item.getTitle());
                        if (this.cardsArrayList.size() > 0) {
                            getTileItems(this.cardsArrayList, 0);
                        }
                        if (!this.utkashRoom.getHomeApiStatusdata().isRecordExistsUserId(MakeMyExam.userId, this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id) || this.utkashRoom.getHomeApiStatusdata().getcoursedetail(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id, MakeMyExam.getUserId()).getStatus().equalsIgnoreCase("true")) {
                            getCourseData(true);
                        } else {
                            this.courselists.clear();
                            if (this.contentType_id.equalsIgnoreCase("0")) {
                                list2 = this.utkashRoom.getCoursedata().getcoursedata(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId);
                            } else {
                                list2 = this.utkashRoom.getCoursedata().getcoursedatawithfilter(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId, this.contentType_id);
                            }
                            for (CourseDataTable courseDataTable : list2) {
                                Courselist courselist = new Courselist(courseDataTable.getCourse_id(), courseDataTable.getTitle(), courseDataTable.getCover_image(), courseDataTable.getMrp(), courseDataTable.getCourse_sp(), courseDataTable.getValidity(), courseDataTable.getSubject_id(), courseDataTable.getSubject_id(), courseDataTable.getDesc_header_image(), courseDataTable.getExtra_json(), courseDataTable.getAvg_rating(), courseDataTable.getUser_rated(), courseDataTable.getIs_purchased(), courseDataTable.getCombo_course_ids(), "", courseDataTable.getCat_type(), courseDataTable.getHide_validity(), courseDataTable.getDescription(), courseDataTable.getDiscount(), courseDataTable.getDelivery_charge(), courseDataTable.getBook_redirection_link(), courseDataTable.getPayment_mode());
                                if ("1".equalsIgnoreCase("5")) {
                                    if (courselist.getExtra_json().getHome_screen() == null) {
                                        this.courselists.add(courselist);
                                    } else if (this.fromWhere.equalsIgnoreCase("ourcourse")) {
                                        if (courselist.getExtra_json().getHome_screen().equalsIgnoreCase("1")) {
                                            this.courselists.add(courselist);
                                        }
                                    } else {
                                        this.courselists.add(courselist);
                                    }
                                } else {
                                    this.courselists.add(courselist);
                                }
                            }
                            if (this.courselists.size() > 0) {
                                this.courseListRV.setVisibility(0);
                                this.no_data_found_RL.setVisibility(8);
                            } else {
                                this.courseListRV.setVisibility(8);
                                this.no_data_found_RL.setVisibility(0);
                            }
                            TileDataAdapter tileDataAdapter = new TileDataAdapter(this, this.courselists, this.isBook, this, this);
                            this.tileDataAdapter = tileDataAdapter;
                            this.courseListRV.setAdapter(tileDataAdapter);
                            this.courseListRV.setNestedScrollingEnabled(false);
                        }
                    }
                }
            }
        } else if (this.clicktype.equalsIgnoreCase("2")) {
            if (!item.getTitle().equals(this.allcatindex)) {
                Iterator<MasteAllCatTable> it2 = this.selected_master_cat.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    MasteAllCatTable next2 = it2.next();
                    if (next2.getName().equals(item.getTitle())) {
                        this.isfilterchanged = true;
                        this.SelectedLaunguageid = "";
                        this.SelectedSubjectid = "";
                        this.is_paid = "";
                        this.isfilterapply = false;
                        this.pagecount = 1;
                        this.allcatindex = item.getTitle().toString();
                        this.allcatindex_id = next2.getId();
                        this.filterOne.setText(item.getTitle());
                        this.selectedsub_all_cat.clear();
                        if (this.cardsArrayList.size() > 0) {
                            getTileItems(this.cardsArrayList, 0);
                        }
                        for (MasteAllCatTable masteAllCatTable : this.masterAllCatTables) {
                            if (this.allcatindex_id.equalsIgnoreCase(masteAllCatTable.getParent_id())) {
                                this.selectedsub_all_cat.add(masteAllCatTable);
                            }
                        }
                        if (this.selectedsub_all_cat.size() > 0) {
                            this.allsubcatindex = this.selectedsub_all_cat.get(0).getName();
                            if (!this.isFromTileActivity) {
                                this.allsubcatindex_id = this.selectedsub_all_cat.get(0).getId();
                            }
                            this.filterTwo.setText(this.selectedsub_all_cat.get(0).getName());
                            this.courseListRV.setVisibility(0);
                            this.no_data_found_RL.setVisibility(8);
                            if (!this.utkashRoom.getHomeApiStatusdata().isRecordExistsUserId(MakeMyExam.userId, this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id) || this.utkashRoom.getHomeApiStatusdata().getcoursedetail(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id, MakeMyExam.getUserId()).getStatus().equalsIgnoreCase("true")) {
                                getCourseData(true);
                            } else {
                                this.courselists.clear();
                                if (this.contentType_id.equalsIgnoreCase("0")) {
                                    list = this.utkashRoom.getCoursedata().getcoursedata(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId);
                                } else {
                                    list = this.utkashRoom.getCoursedata().getcoursedatawithfilter(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId, this.contentType_id);
                                }
                                for (CourseDataTable courseDataTable2 : list) {
                                    Courselist courselist2 = new Courselist(courseDataTable2.getCourse_id(), courseDataTable2.getTitle(), courseDataTable2.getCover_image(), courseDataTable2.getMrp(), courseDataTable2.getCourse_sp(), courseDataTable2.getValidity(), courseDataTable2.getSubject_id(), courseDataTable2.getLang_id(), courseDataTable2.getDesc_header_image(), courseDataTable2.getExtra_json(), courseDataTable2.getAvg_rating(), courseDataTable2.getUser_rated(), courseDataTable2.getIs_purchased(), courseDataTable2.getCombo_course_ids(), courseDataTable2.getCat_type(), courseDataTable2.getHide_validity(), courseDataTable2.getPayment_mode(), courseDataTable2.getIs_purchased());
                                    if ("1".equalsIgnoreCase("5")) {
                                        if (courselist2.getExtra_json().getHome_screen() == null) {
                                            this.courselists.add(courselist2);
                                        } else if (this.fromWhere.equalsIgnoreCase("ourcourse")) {
                                            if (courselist2.getExtra_json().getHome_screen().equalsIgnoreCase("1")) {
                                                this.courselists.add(courselist2);
                                            }
                                        } else {
                                            this.courselists.add(courselist2);
                                        }
                                    } else {
                                        this.courselists.add(courselist2);
                                    }
                                }
                                if (this.courselists.size() > 0) {
                                    this.courseListRV.setVisibility(0);
                                    this.no_data_found_RL.setVisibility(8);
                                } else {
                                    this.courseListRV.setVisibility(8);
                                    this.no_data_found_RL.setVisibility(0);
                                }
                                TileDataAdapter tileDataAdapter2 = new TileDataAdapter(this, this.courselists, this.isBook, this, this);
                                this.tileDataAdapter = tileDataAdapter2;
                                this.courseListRV.setAdapter(tileDataAdapter2);
                                this.courseListRV.setNestedScrollingEnabled(false);
                            }
                        } else {
                            this.courseListRV.setVisibility(8);
                            this.no_data_found_RL.setVisibility(0);
                            this.allsubcatindex = "";
                            if (!this.isFromTileActivity) {
                                this.allsubcatindex_id = "";
                            }
                            this.filterTwo.setText("");
                        }
                    }
                }
            }
        } else if (this.clicktype.equalsIgnoreCase("4")) {
            if (!item.getTitle().equals(this.launguageindex)) {
                Iterator<LanguagesTable> it3 = this.filterdata.getData().getLanguages().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    LanguagesTable next3 = it3.next();
                    if (next3.getLanguage().equals(item.getTitle())) {
                        this.launguageindex = item.getTitle().toString();
                        this.SelectedLaunguageid = next3.getId();
                        this.launguagespinner.setText(item.getTitle());
                        break;
                    }
                    this.SelectedLaunguageid = "";
                    this.launguageindex = "";
                    this.launguagespinner.setText(getResources().getString(R.string.select_language));
                }
            }
        } else if (this.clicktype.equalsIgnoreCase("5")) {
            if (!item.getTitle().equals(this.subjectindex)) {
                Iterator<Subject> it4 = this.filterdata.getData().getSubjects().iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        break;
                    }
                    Subject next4 = it4.next();
                    if (next4.getTitle().equals(item.getTitle())) {
                        this.subjectindex = item.getTitle().toString();
                        this.SelectedSubjectid = next4.getId();
                        this.subjectspinner.setText(item.getTitle());
                        break;
                    }
                    this.SelectedSubjectid = "";
                    this.subjectindex = "";
                    this.subjectspinner.setText(getResources().getString(R.string.select_subject));
                }
            }
        } else if (!item.getTitle().equals(this.mastercatname)) {
            updateMasterCat(item.getTitle());
        }
        return false;
    }

    private void updateMasterCat(CharSequence item) {
        List<CourseDataTable> list;
        for (MasterCat masterCat : this.mastercatlist) {
            if (masterCat.getCat().equals(item)) {
                this.mastercatname = item.toString();
                this.mastercatid = masterCat.getId();
                this.toolbartitleTV.setText(item);
                this.isfilterchanged = true;
                this.SelectedLaunguageid = "";
                this.SelectedSubjectid = "";
                this.is_paid = "";
                this.isfilterapply = false;
                this.filterOne.setText("");
                this.filterTwo.setText("");
                this.allcatindex = "";
                this.allcatindex_id = "";
                this.clicktype = "";
                this.allsubcatindex = "";
                if (!this.isFromTileActivity) {
                    this.allsubcatindex_id = "";
                }
                this.pagecount = 1;
                this.selectedsub_all_cat.clear();
                this.selected_master_cat.clear();
                for (MasteAllCatTable masteAllCatTable : this.masterAllCatTables) {
                    if (masteAllCatTable.getMaster_type().equals(this.mastercatid) && masteAllCatTable.getParent_id().equalsIgnoreCase("0")) {
                        this.selected_master_cat.add(masteAllCatTable);
                    }
                }
                if (this.selected_master_cat.size() > 0) {
                    if (this.isFromTileActivity) {
                        this.ll_top_two.setVisibility(8);
                    } else if ((this.selected_master_cat.get(0).getApp_hide() != null && this.selected_master_cat.get(0).getApp_hide().equals("1")) || "1".equalsIgnoreCase("7")) {
                        this.ll_top_two.setVisibility(8);
                    } else {
                        this.ll_top_two.setVisibility(0);
                    }
                    this.allcatindex = this.selected_master_cat.get(0).getName();
                    this.allcatindex_id = this.selected_master_cat.get(0).getId();
                    this.filterOne.setText(this.selected_master_cat.get(0).getName());
                    for (MasteAllCatTable masteAllCatTable2 : this.masterAllCatTables) {
                        if (this.allcatindex_id.equalsIgnoreCase(masteAllCatTable2.getParent_id())) {
                            this.selectedsub_all_cat.add(masteAllCatTable2);
                        }
                    }
                    if ("1".equalsIgnoreCase("7")) {
                        automateViewPagerSwiping();
                    }
                    if (this.selectedsub_all_cat.size() > 0) {
                        this.allsubcatindex = this.selectedsub_all_cat.get(0).getName();
                        if (!this.isFromTileActivity) {
                            this.allsubcatindex_id = this.selectedsub_all_cat.get(0).getId();
                        }
                        this.filterTwo.setText(this.allsubcatindex);
                        this.courseListRV.setVisibility(0);
                        this.no_data_found_RL.setVisibility(8);
                        this.pagecount = 1;
                        if (this.utkashRoom.getHomeApiStatusdata().isRecordExistsUserId(MakeMyExam.userId, this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id)) {
                            if (this.utkashRoom.getHomeApiStatusdata().getcoursedetail(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id, MakeMyExam.getUserId()).getStatus().equalsIgnoreCase("true")) {
                                getCourseData(true);
                                return;
                            }
                            this.courselists.clear();
                            if (this.contentType_id.equalsIgnoreCase("0")) {
                                list = this.utkashRoom.getCoursedata().getcoursedata(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId);
                            } else {
                                list = this.utkashRoom.getCoursedata().getcoursedatawithfilter(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId, this.contentType_id);
                            }
                            for (CourseDataTable courseDataTable : list) {
                                Courselist courselist = new Courselist(courseDataTable.getCourse_id(), courseDataTable.getTitle(), courseDataTable.getCover_image(), courseDataTable.getMrp(), courseDataTable.getCourse_sp(), courseDataTable.getValidity(), courseDataTable.getSubject_id(), courseDataTable.getLang_id(), courseDataTable.getDesc_header_image(), courseDataTable.getExtra_json(), courseDataTable.getAvg_rating(), courseDataTable.getUser_rated(), courseDataTable.getIs_purchased(), courseDataTable.getCombo_course_ids(), "", courseDataTable.getCat_type(), courseDataTable.getHide_validity(), courseDataTable.getDescription(), courseDataTable.getDiscount(), courseDataTable.getDelivery_charge(), courseDataTable.getBook_redirection_link(), courseDataTable.getPayment_mode());
                                if ("1".equalsIgnoreCase("5")) {
                                    if (courselist.getExtra_json().getHome_screen() == null) {
                                        this.courselists.add(courselist);
                                    } else if (this.fromWhere.equalsIgnoreCase("ourcourse")) {
                                        if (courselist.getExtra_json().getHome_screen().equalsIgnoreCase("1")) {
                                            this.courselists.add(courselist);
                                        }
                                    } else {
                                        this.courselists.add(courselist);
                                    }
                                } else {
                                    this.courselists.add(courselist);
                                }
                            }
                            if (this.courselists.size() > 0) {
                                if (this.cardsArrayList.size() > 0) {
                                    getTileItems(this.cardsArrayList, 0);
                                }
                                this.courseListRV.setVisibility(0);
                                this.no_data_found_RL.setVisibility(8);
                            } else {
                                this.courseListRV.setVisibility(8);
                                this.no_data_found_RL.setVisibility(0);
                            }
                            TileDataAdapter tileDataAdapter = new TileDataAdapter(this, this.courselists, this.isBook, this, this);
                            this.tileDataAdapter = tileDataAdapter;
                            this.courseListRV.setAdapter(tileDataAdapter);
                            this.courseListRV.setNestedScrollingEnabled(false);
                            return;
                        }
                        getCourseData(true);
                        return;
                    }
                    this.courseListRV.setVisibility(8);
                    this.no_data_found_RL.setVisibility(0);
                    if (!this.isFromTileActivity) {
                        this.allsubcatindex_id = "";
                    }
                    this.allsubcatindex = "";
                    this.filterTwo.setText("");
                    return;
                }
                this.allcatindex = "";
                this.allcatindex_id = "";
                this.filterOne.setText("");
                this.ll_top_two.setVisibility(8);
                this.courseListRV.setVisibility(8);
                this.no_data_found_RL.setVisibility(0);
                return;
            }
        }
    }

    private void selecteddata() {
        int i;
        List<CourseDataTable> list;
        List<CourseDataTable> list2;
        MasterCat next;
        List<CourseDataTable> list3;
        List<CourseDataTable> list4;
        if (this.isFromTileActivity) {
            this.ll_top_two.setVisibility(8);
            this.filter_one_click.setVisibility(8);
            this.titleinnerRL.setVisibility(8);
            this.downarrowIV.setVisibility(8);
            this.toolbartitleTV1.setVisibility(0);
            this.toolbartitleTV1.setText(this.subTitle);
            UtkashRoom utkashRoom = this.utkashRoom;
            if (utkashRoom != null && utkashRoom.getHomeApiStatusdata() != null && this.utkashRoom.getHomeApiStatusdata().isRecordExistsUserId(MakeMyExam.userId, this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id)) {
                if (this.utkashRoom.getHomeApiStatusdata().getcoursedetail(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id, MakeMyExam.getUserId()).getStatus().equalsIgnoreCase("false")) {
                    this.pagecount = 1;
                    this.courselists.clear();
                    if (this.contentType_id.equalsIgnoreCase("0")) {
                        list4 = this.utkashRoom.getCoursedata().getcoursedata(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId);
                    } else {
                        list4 = this.utkashRoom.getCoursedata().getcoursedatawithfilter(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId, this.contentType_id);
                    }
                    for (CourseDataTable courseDataTable : list4) {
                        Courselist courselist = new Courselist(courseDataTable.getCourse_id(), courseDataTable.getTitle(), courseDataTable.getCover_image(), courseDataTable.getMrp(), courseDataTable.getCourse_sp(), courseDataTable.getValidity(), courseDataTable.getSubject_id(), courseDataTable.getLang_id(), courseDataTable.getDesc_header_image(), courseDataTable.getExtra_json(), courseDataTable.getAvg_rating(), courseDataTable.getUser_rated(), courseDataTable.getIs_purchased(), courseDataTable.getCombo_course_ids(), "", courseDataTable.getCat_type(), courseDataTable.getHide_validity(), courseDataTable.getDescription(), courseDataTable.getDiscount(), courseDataTable.getDelivery_charge(), courseDataTable.getBook_redirection_link(), courseDataTable.getPayment_mode());
                        if ("1".equalsIgnoreCase("5")) {
                            if (courselist.getExtra_json().getHome_screen() == null) {
                                this.courselists.add(courselist);
                            } else if (this.fromWhere.equalsIgnoreCase("ourcourse")) {
                                if (courselist.getExtra_json().getHome_screen().equalsIgnoreCase("1")) {
                                    this.courselists.add(courselist);
                                }
                            } else {
                                this.courselists.add(courselist);
                            }
                        } else {
                            this.courselists.add(courselist);
                        }
                    }
                    if (this.courselists.size() > 0) {
                        this.courseListRV.setVisibility(0);
                        this.no_data_found_RL.setVisibility(8);
                    } else {
                        this.courseListRV.setVisibility(8);
                        this.no_data_found_RL.setVisibility(0);
                    }
                    TileDataAdapter tileDataAdapter = new TileDataAdapter(this, this.courselists, this.isBook, this, this);
                    this.tileDataAdapter = tileDataAdapter;
                    this.courseListRV.setAdapter(tileDataAdapter);
                    this.courseListRV.setNestedScrollingEnabled(false);
                } else if (this.utkashRoom.getHomeApiStatusdata().isRecordExistsUserId(MakeMyExam.userId, this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id) && this.utkashRoom.getHomeApiStatusdata().getcoursedetail(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id, MakeMyExam.getUserId()).getStatus().equalsIgnoreCase("false")) {
                    this.pagecount = 1;
                    this.courselists.clear();
                    if (this.contentType_id.equalsIgnoreCase("0")) {
                        list3 = this.utkashRoom.getCoursedata().getcoursedata(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId);
                    } else {
                        list3 = this.utkashRoom.getCoursedata().getcoursedatawithfilter(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId, this.contentType_id);
                    }
                    for (CourseDataTable courseDataTable2 : list3) {
                        Courselist courselist2 = new Courselist(courseDataTable2.getCourse_id(), courseDataTable2.getTitle(), courseDataTable2.getCover_image(), courseDataTable2.getMrp(), courseDataTable2.getCourse_sp(), courseDataTable2.getValidity(), courseDataTable2.getSubject_id(), courseDataTable2.getLang_id(), courseDataTable2.getDesc_header_image(), courseDataTable2.getExtra_json(), courseDataTable2.getAvg_rating(), courseDataTable2.getUser_rated(), courseDataTable2.getIs_purchased(), courseDataTable2.getCombo_course_ids(), "", courseDataTable2.getCat_type(), courseDataTable2.getHide_validity(), courseDataTable2.getDescription(), courseDataTable2.getDiscount(), courseDataTable2.getDelivery_charge(), courseDataTable2.getBook_redirection_link(), courseDataTable2.getPayment_mode());
                        if ("1".equalsIgnoreCase("5")) {
                            if (courselist2.getExtra_json().getHome_screen() == null) {
                                this.courselists.add(courselist2);
                            } else if (this.fromWhere.equalsIgnoreCase("ourcourse")) {
                                if (courselist2.getExtra_json().getHome_screen().equalsIgnoreCase("1")) {
                                    this.courselists.add(courselist2);
                                }
                            } else {
                                this.courselists.add(courselist2);
                            }
                        } else {
                            this.courselists.add(courselist2);
                        }
                    }
                    if (this.courselists.size() > 0) {
                        this.courseListRV.setVisibility(0);
                        this.no_data_found_RL.setVisibility(8);
                    } else {
                        this.courseListRV.setVisibility(8);
                        this.no_data_found_RL.setVisibility(0);
                    }
                    TileDataAdapter tileDataAdapter2 = new TileDataAdapter(this, this.courselists, this.isBook, this, this);
                    this.tileDataAdapter = tileDataAdapter2;
                    this.courseListRV.setAdapter(tileDataAdapter2);
                    this.courseListRV.setNestedScrollingEnabled(false);
                } else {
                    this.pagecount = 1;
                    getCourseData(true);
                }
            } else {
                this.pagecount = 1;
                getCourseData(true);
            }
        } else if (this.mastercatlist.size() > 0) {
            if ("1".equalsIgnoreCase("7")) {
                this.ll_top_two.setVisibility(8);
            } else {
                this.ll_top_two.setVisibility(0);
            }
            if (this.mastercatlist.get(0).getApp_hide() != null && this.mastercatlist.get(0).getApp_hide().equals("1")) {
                this.titleinnerRL.setVisibility(8);
                this.downarrowIV.setVisibility(8);
                this.toolbartitleTV1.setText(this.tabName);
                this.toolbartitleTV1.setVisibility(0);
            } else if ("1".equalsIgnoreCase("7")) {
                String str = this.fromWhere;
                if (str != null && str.equalsIgnoreCase("freeStuff")) {
                    this.titleinnerRL.setVisibility(0);
                    if (!"1".equalsIgnoreCase("7")) {
                        this.downarrowIV.setVisibility(0);
                    } else {
                        this.downarrowIV.setVisibility(8);
                    }
                    this.toolbartitleTV1.setVisibility(8);
                } else {
                    this.titleinnerRL.setVisibility(8);
                    this.downarrowIV.setVisibility(8);
                    this.toolbartitleTV1.setText(this.tabName);
                    this.toolbartitleTV1.setVisibility(0);
                    this.viewPagerRL.setVisibility(8);
                }
            } else {
                this.titleinnerRL.setVisibility(0);
                if (!"1".equalsIgnoreCase("7")) {
                    this.downarrowIV.setVisibility(0);
                } else {
                    this.downarrowIV.setVisibility(8);
                }
                this.toolbartitleTV1.setVisibility(8);
            }
            this.filter_one_click.setVisibility(0);
            if (!this.isFromTileActivity && !this.pullrefresh) {
                Iterator<MasterCat> it = this.mastercatlist.iterator();
                while (true) {
                    if (it.hasNext()) {
                        next = it.next();
                        if (next.getId().equals(this.masterCategoryId)) {
                            break;
                        }
                    } else {
                        next = null;
                        break;
                    }
                }
                if (next != null) {
                    this.mastercatname = next.getCat();
                    this.mastercatid = next.getId();
                    this.toolbartitleTV.setText(next.getCat());
                } else {
                    this.mastercatname = this.mastercatlist.get(0).getCat();
                    this.mastercatid = this.mastercatlist.get(0).getId();
                    this.toolbartitleTV.setText(this.mastercatlist.get(0).getCat());
                }
                this.selected_master_cat.clear();
                this.selectedsub_all_cat.clear();
            }
            for (MasteAllCatTable masteAllCatTable : this.masterAllCatTables) {
                if (masteAllCatTable.getMaster_type().equals(this.mastercatid) && masteAllCatTable.getParent_id().equalsIgnoreCase("0")) {
                    this.selected_master_cat.add(masteAllCatTable);
                }
            }
            if (this.selected_master_cat.size() > 0) {
                if (this.isFromTileActivity) {
                    this.ll_top_two.setVisibility(8);
                } else if ((this.selected_master_cat.get(0).getApp_hide() != null && this.selected_master_cat.get(0).getApp_hide().equals("1")) || "1".equalsIgnoreCase("7")) {
                    this.ll_top_two.setVisibility(8);
                } else {
                    this.ll_top_two.setVisibility(0);
                }
                if (SharedPreference.getInstance().getString(Const.PREFERENCE_SELECTION_TYPE) != null && SharedPreference.getInstance().getString(Const.PREFERENCE_SELECTION_TYPE).equalsIgnoreCase("1")) {
                    ArrayList<Data.Preferences> preferences = SharedPreference.getInstance().getLoggedInUser().getPreferences();
                    new ArrayList();
                    ArrayList<MasterCat> arrayList = new ArrayList<>();
                    ArrayList<MasteAllCatTable> arrayList2 = new ArrayList<>();
                    for (MasteAllCatTable masteAllCatTable2 : this.masterAllCatTables) {
                        Iterator<Data.Preferences> it2 = preferences.iterator();
                        while (it2.hasNext()) {
                            if (it2.next().getSub_cat().equalsIgnoreCase(masteAllCatTable2.getId())) {
                                arrayList2.add(masteAllCatTable2);
                            }
                        }
                    }
                    if (arrayList2.size() > 0) {
                        Iterator<MasteAllCatTable> it3 = arrayList2.iterator();
                        while (it3.hasNext()) {
                            MasteAllCatTable next2 = it3.next();
                            for (MasterCat masterCat : this.mastercatlist) {
                                Iterator<MasteAllCatTable> it4 = it3;
                                if (next2.getMaster_type().equalsIgnoreCase(masterCat.getId())) {
                                    arrayList.add(masterCat);
                                }
                                it3 = it4;
                            }
                        }
                        removeDuplicates(arrayList, "");
                        this.selectedsub_all_cat = arrayList2;
                    }
                } else {
                    if (!this.pullrefresh && !this.isFromTileActivity) {
                        this.allcatindex = this.selected_master_cat.get(0).getName();
                        this.allcatindex_id = this.selected_master_cat.get(0).getId();
                        this.filterOne.setText(this.selected_master_cat.get(0).getName());
                    }
                    for (MasteAllCatTable masteAllCatTable3 : this.masterAllCatTables) {
                        if (this.allcatindex_id.equalsIgnoreCase(masteAllCatTable3.getParent_id())) {
                            this.selectedsub_all_cat.add(masteAllCatTable3);
                        }
                    }
                }
                if (this.selectedsub_all_cat.size() > 0) {
                    if (this.pullrefresh) {
                        i = 0;
                    } else {
                        i = 0;
                        this.allsubcatindex = this.selectedsub_all_cat.get(0).getName();
                        if (!this.isFromTileActivity) {
                            this.allsubcatindex_id = this.selectedsub_all_cat.get(0).getId();
                        }
                    }
                    this.filterTwo.setText(this.allsubcatindex);
                    this.courseListRV.setVisibility(i);
                    this.no_data_found_RL.setVisibility(8);
                    this.subjectindex = "";
                    this.launguageindex = "";
                    this.filterdata = new Filterdata();
                    com.appnew.android.home.model.FilterData.Data data = new com.appnew.android.home.model.FilterData.Data();
                    new ArrayList();
                    if (this.utkashRoom == null) {
                        this.utkashRoom = UtkashRoom.getAppDatabase(this);
                    }
                    String str2 = this.utkashRoom.getMasterAllCatDao().getfilteddata(this.allsubcatindex_id);
                    this.LanguagesTable = this.utkashRoom.getLaunguages().getLaunguagedetail();
                    data.setSubjects((List) new Gson().fromJson(str2, new TypeToken<List<Subject>>() { // from class: com.appnew.android.home.Activity.HomeActivity.17
                    }.getType()));
                    data.setLanguages(this.LanguagesTable);
                    this.filterdata.setData(data);
                    if (this.utkashRoom.getHomeApiStatusdata().isRecordExistsUserId(MakeMyExam.userId, this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id)) {
                        if (this.utkashRoom.getHomeApiStatusdata().getcoursedetail(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id, MakeMyExam.getUserId()).getStatus().equalsIgnoreCase("false")) {
                            this.pagecount = 1;
                            this.courselists.clear();
                            if (this.contentType_id.equalsIgnoreCase("0")) {
                                list2 = this.utkashRoom.getCoursedata().getcoursedata(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId);
                            } else {
                                list2 = this.utkashRoom.getCoursedata().getcoursedatawithfilter(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId, this.contentType_id);
                            }
                            for (CourseDataTable courseDataTable3 : list2) {
                                Courselist courselist3 = new Courselist(courseDataTable3.getCourse_id(), courseDataTable3.getTitle(), courseDataTable3.getCover_image(), courseDataTable3.getMrp(), courseDataTable3.getCourse_sp(), courseDataTable3.getValidity(), courseDataTable3.getSubject_id(), courseDataTable3.getLang_id(), courseDataTable3.getDesc_header_image(), courseDataTable3.getExtra_json(), courseDataTable3.getAvg_rating(), courseDataTable3.getUser_rated(), courseDataTable3.getIs_purchased(), courseDataTable3.getCombo_course_ids(), "", courseDataTable3.getCat_type(), courseDataTable3.getHide_validity(), courseDataTable3.getDescription(), courseDataTable3.getDiscount(), courseDataTable3.getDelivery_charge(), courseDataTable3.getBook_redirection_link(), courseDataTable3.getPayment_mode());
                                if ("1".equalsIgnoreCase("5")) {
                                    if (courselist3.getExtra_json().getHome_screen() == null) {
                                        this.courselists.add(courselist3);
                                    } else if (this.fromWhere.equalsIgnoreCase("ourcourse")) {
                                        if (courselist3.getExtra_json().getHome_screen().equalsIgnoreCase("1")) {
                                            this.courselists.add(courselist3);
                                        }
                                    } else {
                                        this.courselists.add(courselist3);
                                    }
                                } else {
                                    this.courselists.add(courselist3);
                                }
                            }
                            if (this.courselists.size() > 0) {
                                this.courseListRV.setVisibility(0);
                                this.no_data_found_RL.setVisibility(8);
                            } else {
                                this.courseListRV.setVisibility(8);
                                this.no_data_found_RL.setVisibility(0);
                            }
                            TileDataAdapter tileDataAdapter3 = new TileDataAdapter(this, this.courselists, this.isBook, this, this);
                            this.tileDataAdapter = tileDataAdapter3;
                            this.courseListRV.setAdapter(tileDataAdapter3);
                            this.courseListRV.setNestedScrollingEnabled(false);
                        } else if (this.utkashRoom.getHomeApiStatusdata().isRecordExistsUserId(MakeMyExam.userId, this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id) && this.utkashRoom.getHomeApiStatusdata().getcoursedetail(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id, MakeMyExam.getUserId()).getStatus().equalsIgnoreCase("false")) {
                            this.pagecount = 1;
                            this.courselists.clear();
                            if (this.contentType_id.equalsIgnoreCase("0")) {
                                list = this.utkashRoom.getCoursedata().getcoursedata(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId);
                            } else {
                                list = this.utkashRoom.getCoursedata().getcoursedatawithfilter(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId, this.contentType_id);
                            }
                            for (CourseDataTable courseDataTable4 : list) {
                                Courselist courselist4 = new Courselist(courseDataTable4.getCourse_id(), courseDataTable4.getTitle(), courseDataTable4.getCover_image(), courseDataTable4.getMrp(), courseDataTable4.getCourse_sp(), courseDataTable4.getValidity(), courseDataTable4.getSubject_id(), courseDataTable4.getLang_id(), courseDataTable4.getDesc_header_image(), courseDataTable4.getExtra_json(), courseDataTable4.getAvg_rating(), courseDataTable4.getUser_rated(), courseDataTable4.getIs_purchased(), courseDataTable4.getCombo_course_ids(), "", courseDataTable4.getCat_type(), courseDataTable4.getHide_validity(), courseDataTable4.getDescription(), courseDataTable4.getDiscount(), courseDataTable4.getDelivery_charge(), courseDataTable4.getBook_redirection_link(), courseDataTable4.getPayment_mode());
                                if ("1".equalsIgnoreCase("5")) {
                                    if (courselist4.getExtra_json().getHome_screen() == null) {
                                        this.courselists.add(courselist4);
                                    } else if (this.fromWhere.equalsIgnoreCase("ourcourse")) {
                                        if (courselist4.getExtra_json().getHome_screen().equalsIgnoreCase("1")) {
                                            this.courselists.add(courselist4);
                                        }
                                    } else {
                                        this.courselists.add(courselist4);
                                    }
                                } else {
                                    this.courselists.add(courselist4);
                                }
                            }
                            if (this.courselists.size() > 0) {
                                this.courseListRV.setVisibility(0);
                                this.no_data_found_RL.setVisibility(8);
                            } else {
                                this.courseListRV.setVisibility(8);
                                this.no_data_found_RL.setVisibility(0);
                            }
                            TileDataAdapter tileDataAdapter4 = new TileDataAdapter(this, this.courselists, this.isBook, this, this);
                            this.tileDataAdapter = tileDataAdapter4;
                            this.courseListRV.setAdapter(tileDataAdapter4);
                            this.courseListRV.setNestedScrollingEnabled(false);
                        } else {
                            this.pagecount = 1;
                            getCourseData(true);
                        }
                    } else {
                        this.pagecount = 1;
                        getCourseData(true);
                    }
                } else {
                    this.courseListRV.setVisibility(8);
                    this.no_data_found_RL.setVisibility(0);
                    this.filterTwo.setText("");
                    this.allsubcatindex = "";
                    if (!this.isFromTileActivity) {
                        this.allsubcatindex_id = "";
                    }
                }
            } else {
                this.allcatindex = "";
                this.allcatindex_id = "";
                this.filterOne.setText("");
                this.filterTwo.setText("");
                this.allsubcatindex = "";
                this.ll_top_two.setVisibility(8);
                this.courseListRV.setVisibility(8);
                this.no_data_found_RL.setVisibility(0);
                if (!this.isFromTileActivity) {
                    this.allsubcatindex_id = "";
                }
            }
        }
        if (this.isFromDashBoard && "1".equalsIgnoreCase("7") && BuildConfig.FLAVOR.equalsIgnoreCase("NavinClasses") && this.utkashRoom.getthemeSettingdao().is_setting_exit()) {
            this.bottomLL.setVisibility(0);
            this.bottomSetting = (BottomSetting) new Gson().fromJson(this.utkashRoom.getthemeSettingdao().data().getBottom(), BottomSetting.class);
            this.bottomLL.removeAllViews();
            ArrayList<View> arrayList3 = this.viewArrayList;
            if (arrayList3 != null) {
                arrayList3.clear();
            }
            for (int i2 = 0; i2 < Helper.getBottomMenu(this.bottomMenuTables).size(); i2++) {
                this.bottomLL.addView(initBottomView(Helper.getBottomMenu(this.bottomMenuTables).get(i2), "13"));
            }
        }
        this.pullrefresh = false;
    }

    private void setdata() {
        for (CourseDataTable courseDataTable : this.courseDataTables) {
            Courselist courselist = new Courselist(courseDataTable.getCourse_id(), courseDataTable.getTitle(), courseDataTable.getCover_image(), courseDataTable.getMrp(), courseDataTable.getCourse_sp(), courseDataTable.getValidity(), courseDataTable.getSubject_id(), courseDataTable.getLang_id(), courseDataTable.getDesc_header_image(), courseDataTable.getExtra_json(), courseDataTable.getAvg_rating(), courseDataTable.getUser_rated(), courseDataTable.getIs_purchased(), courseDataTable.getCombo_course_ids(), "", courseDataTable.getHide_validity(), courseDataTable.getPayment_mode(), courseDataTable.getIs_purchased());
            if ("1".equalsIgnoreCase("5")) {
                if (courselist.getExtra_json().getHome_screen() == null) {
                    this.courselists.add(courselist);
                } else if (this.fromWhere.equalsIgnoreCase("ourcourse")) {
                    if (courselist.getExtra_json().getHome_screen().equalsIgnoreCase("1")) {
                        this.courselists.add(courselist);
                    }
                } else {
                    this.courselists.add(courselist);
                }
            } else {
                this.courselists.add(courselist);
            }
        }
        if (this.courselists.size() > 0) {
            this.courseListRV.setVisibility(0);
            this.no_data_found_RL.setVisibility(8);
        } else {
            this.courseListRV.setVisibility(8);
            this.no_data_found_RL.setVisibility(0);
        }
        TileDataAdapter tileDataAdapter = new TileDataAdapter(this, this.courselists, this.isBook, this, this);
        this.tileDataAdapter = tileDataAdapter;
        this.courseListRV.setAdapter(tileDataAdapter);
        this.courseListRV.setNestedScrollingEnabled(false);
    }

    private void getCourseData(boolean showProgress) {
        this.networkCall.NetworkAPICall(API.get_courses, "", showProgress, false);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (BuildConfig.FLAVOR.equalsIgnoreCase("utkarsh")) {
            if (this.isFromDashBoard) {
                if (this.backstatus) {
                    if (this.backPressed + 3000 > System.currentTimeMillis()) {
                        getIntent().setData(null);
                        finishAffinity();
                        return;
                    } else {
                        this.backPressed = System.currentTimeMillis();
                        Helper.showSnackBar(this.drawer, getResources().getString(R.string.press_again_to_exit));
                        return;
                    }
                }
                if (this.fragment instanceof Chatboot) {
                    this.backstatus = true;
                    this.forchatbot.setVisibility(8);
                    return;
                } else if (this.backPressed + 3000 > System.currentTimeMillis()) {
                    getIntent().setData(null);
                    finishAffinity();
                    return;
                } else {
                    this.backPressed = System.currentTimeMillis();
                    Helper.showSnackBar(this.drawer, getResources().getString(R.string.press_again_to_exit));
                    return;
                }
            }
            super.onBackPressed();
            return;
        }
        super.onBackPressed();
    }

    public void openwatchlist_dailog_resource(final Context context, final List<LanguagesTable> languages, final List<Subject> subjects) {
        try {
            this.isfilterchanged = false;
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.videosheetDialogTheme);
            this.watchlist = bottomSheetDialog;
            bottomSheetDialog.setContentView(R.layout.filter);
            ((Window) Objects.requireNonNull(this.watchlist.getWindow())).getAttributes().windowAnimations = R.style.PauseDialogAnimation;
            this.watchlist.setCancelable(false);
            this.watchlist.setCanceledOnTouchOutside(true);
            this.subjectspinner = (TextView) this.watchlist.findViewById(R.id.subjectspinner);
            this.launguagespinner = (TextView) this.watchlist.findViewById(R.id.launguagespinner);
            RelativeLayout relativeLayout = (RelativeLayout) this.watchlist.findViewById(R.id.launguage);
            RelativeLayout relativeLayout2 = (RelativeLayout) this.watchlist.findViewById(R.id.subject);
            RelativeLayout relativeLayout3 = (RelativeLayout) this.watchlist.findViewById(R.id.rl1);
            RelativeLayout relativeLayout4 = (RelativeLayout) this.watchlist.findViewById(R.id.rl2);
            Button button = (Button) this.watchlist.findViewById(R.id.filterdata);
            final LinearLayout linearLayout = (LinearLayout) this.watchlist.findViewById(R.id.free);
            final LinearLayout linearLayout2 = (LinearLayout) this.watchlist.findViewById(R.id.paid_ll);
            final LinearLayout linearLayout3 = (LinearLayout) this.watchlist.findViewById(R.id.both_ll);
            final TextView textView = (TextView) this.watchlist.findViewById(R.id.freeTextTv);
            final TextView textView2 = (TextView) this.watchlist.findViewById(R.id.paidTextTv);
            TextView textView3 = (TextView) this.watchlist.findViewById(R.id.txt2);
            TextView textView4 = (TextView) this.watchlist.findViewById(R.id.txt3);
            final TextView textView5 = (TextView) this.watchlist.findViewById(R.id.bothTextTv);
            if (subjects == null || subjects.size() == 0) {
                textView3.setVisibility(8);
                relativeLayout3.setVisibility(8);
            } else {
                textView3.setVisibility(0);
                relativeLayout3.setVisibility(0);
            }
            if (relativeLayout == null || languages.size() == 0) {
                textView4.setVisibility(8);
                relativeLayout4.setVisibility(8);
            } else {
                textView4.setVisibility(0);
                relativeLayout4.setVisibility(0);
            }
            if (!this.isfilterchanged) {
                this.subjectspinner.setText(this.subjectindex.equalsIgnoreCase("") ? getResources().getString(R.string.select_subject) : this.subjectindex);
                this.launguagespinner.setText(this.launguageindex.equalsIgnoreCase("") ? getResources().getString(R.string.select_language) : this.launguageindex);
                if (!this.is_paid.equalsIgnoreCase("0")) {
                    if (this.is_paid.equalsIgnoreCase("1")) {
                        this.is_paid = "1";
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        gradientDrawable.setColor(Color.parseColor(Constants.BLACK));
                        gradientDrawable.setCornerRadius(0.0f);
                        linearLayout2.setBackground(gradientDrawable);
                        textView2.setTextColor(-1);
                        linearLayout3.setBackground(context.getResources().getDrawable(R.drawable.bg_tile_unselected));
                        textView5.setTextColor(context.getResources().getColor(R.color.country_code_text_color));
                        linearLayout.setBackground(context.getResources().getDrawable(R.drawable.bg_tile_unselected));
                        textView.setTextColor(context.getResources().getColor(R.color.country_code_text_color));
                    } else if (this.is_paid.equalsIgnoreCase("")) {
                        this.is_paid = "";
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        gradientDrawable2.setColor(Color.parseColor(Constants.BLACK));
                        gradientDrawable2.setCornerRadius(0.0f);
                        linearLayout3.setBackground(gradientDrawable2);
                        textView5.setTextColor(-1);
                        linearLayout2.setBackground(context.getResources().getDrawable(R.drawable.bg_tile_unselected));
                        textView2.setTextColor(context.getResources().getColor(R.color.country_code_text_color));
                        linearLayout.setBackground(context.getResources().getDrawable(R.drawable.bg_tile_unselected));
                        textView.setTextColor(context.getResources().getColor(R.color.country_code_text_color));
                    }
                } else {
                    GradientDrawable gradientDrawable3 = new GradientDrawable();
                    gradientDrawable3.setColor(Color.parseColor(Constants.BLACK));
                    gradientDrawable3.setCornerRadius(0.0f);
                    linearLayout.setBackground(gradientDrawable3);
                    textView.setTextColor(-1);
                    linearLayout3.setBackground(context.getResources().getDrawable(R.drawable.bg_tile_unselected));
                    textView5.setTextColor(context.getResources().getColor(R.color.country_code_text_color));
                    linearLayout2.setBackground(context.getResources().getDrawable(R.drawable.bg_tile_unselected));
                    textView2.setTextColor(context.getResources().getColor(R.color.country_code_text_color));
                }
            }
            try {
                linearLayout3.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.home.Activity.HomeActivity$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$openwatchlist_dailog_resource$34(linearLayout3, textView5, linearLayout2, context, textView2, linearLayout, textView);
                    }
                }));
                linearLayout.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.home.Activity.HomeActivity$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$openwatchlist_dailog_resource$35(linearLayout, textView, linearLayout2, context, textView2, linearLayout3, textView5);
                    }
                }));
                linearLayout2.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.home.Activity.HomeActivity$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$openwatchlist_dailog_resource$36(linearLayout2, textView2, linearLayout3, context, textView5, linearLayout, textView);
                    }
                }));
                button.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.home.Activity.HomeActivity$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$openwatchlist_dailog_resource$37(context);
                    }
                }));
                relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.Activity.HomeActivity.18
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        HomeActivity.this.clicktype = "4";
                        PopupMenu popupMenu = new PopupMenu(context, HomeActivity.this.launguagespinner, 3);
                        popupMenu.getMenu().add("Select language");
                        for (int i = 0; i < languages.size(); i++) {
                            popupMenu.getMenu().add(((LanguagesTable) languages.get(i)).getLanguage());
                        }
                        popupMenu.setOnMenuItemClickListener(HomeActivity.this);
                        popupMenu.show();
                    }
                });
                this.launguagespinner.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.Activity.HomeActivity.19
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        HomeActivity.this.clicktype = "4";
                        PopupMenu popupMenu = new PopupMenu(context, HomeActivity.this.launguagespinner, 3);
                        popupMenu.getMenu().add("Select language");
                        for (int i = 0; i < languages.size(); i++) {
                            popupMenu.getMenu().add(((LanguagesTable) languages.get(i)).getLanguage());
                        }
                        popupMenu.setOnMenuItemClickListener(HomeActivity.this);
                        popupMenu.show();
                    }
                });
                relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.Activity.HomeActivity.20
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        HomeActivity.this.clicktype = "5";
                        PopupMenu popupMenu = new PopupMenu(context, HomeActivity.this.subjectspinner, 3);
                        popupMenu.getMenu().add("Select subject");
                        for (int i = 0; i < subjects.size(); i++) {
                            popupMenu.getMenu().add(((Subject) subjects.get(i)).getTitle());
                        }
                        popupMenu.setOnMenuItemClickListener(HomeActivity.this);
                        popupMenu.show();
                    }
                });
                this.subjectspinner.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.Activity.HomeActivity.21
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        HomeActivity.this.clicktype = "5";
                        PopupMenu popupMenu = new PopupMenu(context, HomeActivity.this.subjectspinner, 3);
                        popupMenu.getMenu().add("Select subject");
                        for (int i = 0; i < subjects.size(); i++) {
                            popupMenu.getMenu().add(((Subject) subjects.get(i)).getTitle());
                        }
                        popupMenu.setOnMenuItemClickListener(HomeActivity.this);
                        popupMenu.show();
                    }
                });
                if (this.watchlist.isShowing()) {
                    return;
                }
                this.watchlist.show();
                return;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
        }
        e.printStackTrace();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$34(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, Context context, TextView textView2, LinearLayout linearLayout3, TextView textView3) {
        this.is_paid = "";
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(Constants.BLACK));
        gradientDrawable.setCornerRadius(0.0f);
        linearLayout.setBackground(gradientDrawable);
        textView.setTextColor(-1);
        linearLayout2.setBackground(context.getResources().getDrawable(R.drawable.bg_tile_unselected));
        textView2.setTextColor(context.getResources().getColor(R.color.country_code_text_color));
        linearLayout3.setBackground(context.getResources().getDrawable(R.drawable.bg_tile_unselected));
        textView3.setTextColor(context.getResources().getColor(R.color.country_code_text_color));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$35(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, Context context, TextView textView2, LinearLayout linearLayout3, TextView textView3) {
        this.is_paid = "0";
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(Constants.BLACK));
        gradientDrawable.setCornerRadius(0.0f);
        linearLayout.setBackground(gradientDrawable);
        textView.setTextColor(-1);
        linearLayout2.setBackground(context.getResources().getDrawable(R.drawable.bg_tile_unselected));
        textView2.setTextColor(context.getResources().getColor(R.color.country_code_text_color));
        linearLayout3.setBackground(context.getResources().getDrawable(R.drawable.bg_tile_unselected));
        textView3.setTextColor(context.getResources().getColor(R.color.country_code_text_color));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$36(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, Context context, TextView textView2, LinearLayout linearLayout3, TextView textView3) {
        this.is_paid = "1";
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(Constants.BLACK));
        gradientDrawable.setCornerRadius(0.0f);
        linearLayout.setBackground(gradientDrawable);
        textView.setTextColor(-1);
        linearLayout2.setBackground(context.getResources().getDrawable(R.drawable.bg_tile_unselected));
        textView2.setTextColor(context.getResources().getColor(R.color.country_code_text_color));
        linearLayout3.setBackground(context.getResources().getDrawable(R.drawable.bg_tile_unselected));
        textView3.setTextColor(context.getResources().getColor(R.color.country_code_text_color));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$37(Context context) {
        String str;
        if (this.SelectedSubjectid.equalsIgnoreCase("") && this.SelectedLaunguageid.equalsIgnoreCase("") && this.is_paid == null) {
            Toast.makeText(context, getResources().getString(R.string.please_select_filter_first), 0).show();
            return null;
        }
        if (this.utkashRoom.getHomeApiStatusdata().isRecordExistsUserId(MakeMyExam.userId, this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id)) {
            if (this.utkashRoom.getHomeApiStatusdata().getcoursedetail(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id, MakeMyExam.getUserId()).getStatus().equalsIgnoreCase("true")) {
                this.isfilterapply = true;
                this.pagecount = 1;
                getCourseData(true);
            } else {
                String str2 = new String();
                if (this.contentType_id.equalsIgnoreCase("0")) {
                    str = str2 + "SELECT * FROM CourseDataTable  WHERE mainid = '" + this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "' AND userid ='" + MakeMyExam.userId + "'";
                } else {
                    str = str2 + "SELECT * FROM CourseDataTable  WHERE mainid = '" + this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "' AND userid ='" + MakeMyExam.userId + "' AND type_id='" + this.contentType_id + "'";
                }
                if (!this.SelectedSubjectid.equalsIgnoreCase("")) {
                    str = str + " AND subject_id='" + this.SelectedSubjectid + "'";
                }
                if (!this.SelectedLaunguageid.equalsIgnoreCase("")) {
                    str = str + " AND lang_id='" + this.SelectedLaunguageid + "'";
                }
                if (!this.is_paid.equalsIgnoreCase("")) {
                    if (this.is_paid.equalsIgnoreCase("0")) {
                        str = str + " AND mrp=='0'";
                    } else if (this.is_paid.equalsIgnoreCase("1")) {
                        str = str + " AND mrp>'0'";
                    }
                }
                List<CourseDataTable> list = this.utkashRoom.getCoursedata().getcoursedatafilterforpaid2(new SimpleSQLiteQuery(str + " ORDER BY autoid ;"));
                this.courselists = new ArrayList<>();
                for (CourseDataTable courseDataTable : list) {
                    Courselist courselist = new Courselist(courseDataTable.getCourse_id(), courseDataTable.getTitle(), courseDataTable.getCover_image(), courseDataTable.getMrp(), courseDataTable.getCourse_sp(), courseDataTable.getValidity(), courseDataTable.getSubject_id(), courseDataTable.getLang_id(), courseDataTable.getDesc_header_image(), courseDataTable.getExtra_json(), courseDataTable.getAvg_rating(), courseDataTable.getUser_rated(), courseDataTable.getIs_purchased(), courseDataTable.getCombo_course_ids(), "", courseDataTable.getCat_type(), courseDataTable.getHide_validity(), courseDataTable.getDescription(), courseDataTable.getDiscount(), courseDataTable.getDelivery_charge(), courseDataTable.getBook_redirection_link(), courseDataTable.getPayment_mode());
                    if ("1".equalsIgnoreCase("5")) {
                        if (courselist.getExtra_json().getHome_screen() == null) {
                            this.courselists.add(courselist);
                        } else if (this.fromWhere.equalsIgnoreCase("ourcourse")) {
                            if (courselist.getExtra_json().getHome_screen().equalsIgnoreCase("1")) {
                                this.courselists.add(courselist);
                            }
                        } else {
                            this.courselists.add(courselist);
                        }
                    } else {
                        this.courselists.add(courselist);
                    }
                }
                new ArrayList();
                ArrayList<Courselist> arrayListRemoveDuplicates = removeDuplicates(this.courselists);
                this.courselists.clear();
                this.courselists.addAll(arrayListRemoveDuplicates);
                if (this.courselists.size() > 0) {
                    this.courseListRV.setVisibility(0);
                    this.no_data_found_RL.setVisibility(8);
                } else {
                    this.courseListRV.setVisibility(8);
                    this.no_data_found_RL.setVisibility(0);
                }
                TileDataAdapter tileDataAdapter = new TileDataAdapter(this, this.courselists, this.isBook, this, this);
                this.tileDataAdapter = tileDataAdapter;
                this.courseListRV.setAdapter(tileDataAdapter);
                this.courseListRV.setNestedScrollingEnabled(false);
            }
        }
        BottomSheetDialog bottomSheetDialog = this.watchlist;
        if (bottomSheetDialog == null || !bottomSheetDialog.isShowing()) {
            return null;
        }
        this.watchlist.dismiss();
        return null;
    }

    private void hit_api_for_data() {
        this.networkCall.NetworkAPICall(API.API_GET_MASTER_DATA, this.contentType, true, false);
    }

    private void hit_read_api() {
        this.networkCall.NetworkAPICall(API.mark_as_read, "", false, false);
    }

    private void getmyQuires() {
        this.networkCall.NetworkAPICall(API.GET_MY_QUIRES, "", true, false);
    }

    public void closschatbot() {
        this.forchatbot.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        try {
            try {
                if (this.notification_code != 0) {
                    com.appnew.android.home.Constants.REFRESHPAGE = "";
                    if (Helper.isNetworkConnected(this)) {
                        if (this.utkashRoom.getMasterAllCatDao().isRecordExistsUserId(MakeMyExam.userId)) {
                            this.courseTypeMasterTables.clear();
                            this.masterAllCatTables.clear();
                            this.mastercatlist.clear();
                            if (!this.utkashRoom.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread()) {
                                this.courseTypeMasterTables = this.utkashRoom.getcoursetypemaster().getcourse_typemaster(MakeMyExam.userId);
                                this.masterAllCatTables = this.utkashRoom.getMasterAllCatDao().getmaster_allcat(MakeMyExam.userId);
                                this.mastercatlist = this.utkashRoom.getMastercatDao().getmastercat(MakeMyExam.userId);
                            }
                            runOnUiThread(new Runnable() { // from class: com.appnew.android.home.Activity.HomeActivity$$ExternalSyntheticLambda18
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$onRestart$38();
                                }
                            });
                        } else {
                            hit_api_master_data();
                        }
                    }
                } else if (!this.utkashRoom.getMasterAllCatDao().isRecordExistsUserId(MakeMyExam.userId)) {
                    hit_api_master_data();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.notification_code = 0;
            if (!this.utkashRoom.getHomeApiStatusdata().isRecordExistsUserId(MakeMyExam.userId, this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id)) {
                getCourseData(true);
            } else {
                getCourseData(false);
            }
        } catch (Throwable th) {
            this.notification_code = 0;
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onRestart$38() {
        this.cardsArrayList.clear();
        for (CourseTypeMasterTable courseTypeMasterTable : this.courseTypeMasterTables) {
            this.cardsArrayList.add(new Cards(courseTypeMasterTable.getId(), courseTypeMasterTable.getName(), Constants.BLACK, courseTypeMasterTable.getName(), "0#0#0#0#0#0", "0"));
        }
        if (this.cardsArrayList.size() > 0) {
            getTileItems(this.cardsArrayList, 0);
        }
        selecteddata();
        updatePreference();
    }

    public void homeAutoRefresh() {
        if (SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT) == 0) {
            ShortcutBadger.applyCount(getApplicationContext(), SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT));
            this.cvrNotificationCount.setBackgroundResource(R.drawable.uncircle_notification_count);
            return;
        }
        ShortcutBadger.applyCount(getApplicationContext(), SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT));
        this.cvrNotificationCount.setBackgroundResource(R.drawable.circle_notification_count);
        if (SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT) > 99) {
            this.notificaionCount.setText(getResources().getString(R.string.nine_nine));
        } else {
            this.notificaionCount.setText(String.valueOf(SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT)));
        }
    }

    public void UserLogout() {
        this.networkCall.NetworkAPICall(API.user_logout, "", true, false);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.utkashRoom = null;
        this.mAppUpdateManager.unregisterListener(this.installStateUpdatedListener);
    }

    public String getdate(String timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(14, TimeZone.getDefault().getOffset(calendar.getTimeInMillis()));
        return new SimpleDateFormat("dd MMM, hh:mm a", Locale.getDefault()).format(new Date(Long.parseLong(timestamp)));
    }

    public void initialzehomepage() {
        if (this.utkashRoom == null) {
            this.utkashRoom = UtkashRoom.getAppDatabase(this);
        }
        if (this.notification_code != 0) {
            if (Helper.isNetworkConnected(this)) {
                if (this.utkashRoom.getMasterAllCatDao().isRecordExistsUserId(MakeMyExam.userId)) {
                    this.courseTypeMasterTables.clear();
                    this.masterAllCatTables.clear();
                    this.mastercatlist.clear();
                    try {
                        if (!this.utkashRoom.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread()) {
                            this.courseTypeMasterTables = this.utkashRoom.getcoursetypemaster().getcourse_typemaster(MakeMyExam.userId);
                            this.masterAllCatTables = this.utkashRoom.getMasterAllCatDao().getmaster_allcat(MakeMyExam.userId);
                            this.mastercatlist = this.utkashRoom.getMastercatDao().getmastercat(MakeMyExam.userId);
                        }
                        runOnUiThread(new Runnable() { // from class: com.appnew.android.home.Activity.HomeActivity$$ExternalSyntheticLambda30
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$initialzehomepage$39();
                            }
                        });
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else {
                    hit_api_master_data();
                }
            }
            this.notification_code = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initialzehomepage$39() {
        this.cardsArrayList.clear();
        for (CourseTypeMasterTable courseTypeMasterTable : this.courseTypeMasterTables) {
            this.cardsArrayList.add(new Cards(courseTypeMasterTable.getId(), courseTypeMasterTable.getName(), Constants.BLACK, courseTypeMasterTable.getName(), "0#0#0#0#0#0", "0"));
        }
        if (this.cardsArrayList.size() > 0) {
            getTileItems(this.cardsArrayList, 0);
        }
        selecteddata();
        updatePreference();
    }

    public <Courselist> ArrayList<Courselist> removeDuplicates(ArrayList<Courselist> list) {
        ArrayList<Courselist> arrayList = new ArrayList<>();
        for (Courselist courselist : list) {
            if (!arrayList.isEmpty()) {
                int i = 0;
                while (true) {
                    if (i < arrayList.size()) {
                        if (arrayList.get(i).getId().equalsIgnoreCase(courselist.getId())) {
                            break;
                        }
                        i++;
                    } else {
                        arrayList.add(courselist);
                        break;
                    }
                }
            } else {
                arrayList.add(courselist);
            }
        }
        return arrayList;
    }

    public void toggleRefreshing(boolean enabled) {
        SwipeRefreshLayout swipeRefreshLayout = this.pullToReferesh;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setEnabled(enabled);
        }
    }

    private void inittest(ArrayList<Video> videoArrayList) {
        if (videoArrayList.get(0).getIs_locked().equalsIgnoreCase("1")) {
            String str = this.parentid;
            if (str == null || str.equalsIgnoreCase("")) {
                Intent intent = new Intent(this, (Class<?>) CourseActivity.class);
                intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                intent.putExtra(Const.COURSE_ID_MAIN, videoArrayList.get(0).getPayloadData().getCourse_id());
                intent.putExtra(Const.COURSE_PARENT_ID, "");
                intent.putExtra(Const.IS_COMBO, false);
                SharedPreference.getInstance().putString("id", videoArrayList.get(0).getPayloadData().getCourse_id());
                startActivity(intent);
                return;
            }
            Intent intent2 = new Intent(this, (Class<?>) CourseActivity.class);
            intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
            intent2.putExtra(Const.COURSE_ID_MAIN, this.parentid);
            intent2.putExtra(Const.COURSE_PARENT_ID, "");
            intent2.putExtra(Const.IS_COMBO, false);
            SharedPreference.getInstance().putString("id", videoArrayList.get(0).getPayloadData().getCourse_id());
            startActivity(intent2);
            return;
        }
        if (videoArrayList.get(0).getState().equals("1")) {
            if (System.currentTimeMillis() < Long.parseLong(videoArrayList.get(0).getEnd_date()) * 1000) {
                if (!videoArrayList.get(0).getIs_reattempt().equalsIgnoreCase("0")) {
                    this.submition_type = "1";
                    inittest(videoArrayList.get(0));
                    return;
                } else {
                    Toast.makeText(this, getResources().getString(R.string.you_have_already_attempted_the_test), 0).show();
                    initialzehomepage();
                    return;
                }
            }
            if (System.currentTimeMillis() <= Long.parseLong(videoArrayList.get(0).getResult_date()) * 1000) {
                initialzehomepage();
                Toast.makeText(this, getResources().getString(R.string.you_have_already_attempted), 0).show();
                return;
            }
            if (Long.parseLong(videoArrayList.get(0).getEnd_date()) < 1640066737) {
                this.submition_type = "1";
                this.quiz_id = videoArrayList.get(0).getId();
                this.first_attempt = "0";
                this.result_date = videoArrayList.get(0).getResult_date();
                SharedPreference.getInstance().putString("id", this.course_id);
                this.testname = videoArrayList.get(0).getTest_series_name();
                this.testquestion = videoArrayList.get(0).getTotal_questions();
                this.videodata = videoArrayList.get(0);
                hit_api_for_iniializetest();
                return;
            }
            this.first_attempt = "1";
            Intent intent3 = new Intent(this, (Class<?>) QuizActivity.class);
            intent3.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
            intent3.putExtra("status", videoArrayList.get(0).getId());
            intent3.putExtra("name", videoArrayList.get(0).getTest_series_name());
            intent3.putExtra("first_attempt", this.first_attempt);
            Helper.gotoActivity(intent3, this);
            return;
        }
        if (System.currentTimeMillis() < Long.parseLong(videoArrayList.get(0).getEnd_date()) * 1000) {
            if (System.currentTimeMillis() < Long.parseLong(videoArrayList.get(0).getStart_date()) * 1000) {
                Snackbar.make(this.filter.getRootView(), getResources().getString(R.string.test_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(videoArrayList.get(0).getStart_date()) * 1000)), -1).show();
                initialzehomepage();
                return;
            }
            TestTable testTableTest_data = this.utkashRoom.getTestDao().test_data(videoArrayList.get(0).getId(), MakeMyExam.userId);
            if (testTableTest_data != null && testTableTest_data.getStatus() != null && !testTableTest_data.getStatus().equalsIgnoreCase("")) {
                Snackbar.make(this.filter.getRootView(), getResources().getString(R.string.you_have_already_attempted_the_test), -1).show();
                initialzehomepage();
                return;
            } else {
                this.first_attempt = "1";
                this.submition_type = videoArrayList.get(0).getSubmission_type();
                inittest(videoArrayList.get(0));
                return;
            }
        }
        if (Long.parseLong(videoArrayList.get(0).getResult_date()) * 1000 > System.currentTimeMillis()) {
            Snackbar.make(this.filter.getRootView(), getResources().getString(R.string.your_result_will_be_declare_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(videoArrayList.get(0).getResult_date()) * 1000)), -1).show();
            initialzehomepage();
            return;
        }
        if (System.currentTimeMillis() > Long.parseLong(videoArrayList.get(0).getResult_date()) * 1000) {
            if (Long.parseLong(videoArrayList.get(0).getEnd_date()) < 1640066737) {
                this.submition_type = "1";
                this.quiz_id = videoArrayList.get(0).getId();
                this.first_attempt = "0";
                this.result_date = videoArrayList.get(0).getResult_date();
                SharedPreference.getInstance().putString("id", this.course_id);
                this.testname = videoArrayList.get(0).getTest_series_name();
                this.testquestion = videoArrayList.get(0).getTotal_questions();
                this.videodata = videoArrayList.get(0);
                hit_api_for_iniializetest();
                return;
            }
            Intent intent4 = new Intent(this, (Class<?>) QuizActivity.class);
            intent4.putExtra(Const.FRAG_TYPE, "leader_board");
            intent4.putExtra("status", videoArrayList.get(0).getId());
            intent4.putExtra("name", videoArrayList.get(0).getTest_series_name());
            Helper.gotoActivity(intent4, this);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    private void manageVisibility() {
        this.viewPagerRL.setVisibility(8);
        if ("1".equalsIgnoreCase("7")) {
            if (this.bottomSetting.getTop_banner() != null && this.bottomSetting.getTop_banner().equalsIgnoreCase("1")) {
                if (this.bannerListTableForTopBanner1.size() > 0) {
                    this.viewPagerRL.setVisibility(0);
                    return;
                } else {
                    this.viewPagerRL.setVisibility(8);
                    return;
                }
            }
            this.viewPagerRL.setVisibility(8);
        }
    }

    private void automateViewPagerSwiping() {
        this.bannerListTables = this.utkashRoom.getBannerTableDao().getBanner(MakeMyExam.getUserId());
        if (!"1".equals("7")) {
            List<BannerListTable> list = this.bannerListTables;
            if (list == null || list.size() <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (BannerListTable bannerListTable : this.bannerListTables) {
                if (bannerListTable.getBanner_location().equalsIgnoreCase("5")) {
                    arrayList.add(bannerListTable);
                }
            }
            this.binding.appBarHomeLayout.bannerSliderLayout.viewPager2.setAdapter(new SliderAdapter(this, arrayList));
            Utils.INSTANCE.setUpViewPager(this.binding.appBarHomeLayout.bannerSliderLayout.viewPager2, this.binding.appBarHomeLayout.bannerSliderLayout.bannerIndicator, arrayList);
            return;
        }
        List<BannerListTable> list2 = this.bannerListTables;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        this.bannerListTableForTopBanner1.clear();
        for (BannerListTable bannerListTable2 : this.bannerListTables) {
            if (bannerListTable2.getBanner_location().equalsIgnoreCase("5") && bannerListTable2.getMaster_cat().equalsIgnoreCase(this.mastercatid)) {
                this.bannerListTableForTopBanner1.add(bannerListTable2);
            }
        }
        if (this.bannerListTableForTopBanner1.size() > 0) {
            String str = this.fromWhere;
            if (str != null && str.equalsIgnoreCase("freeStuff")) {
                this.viewPagerRL.setVisibility(0);
            } else {
                this.viewPagerRL.setVisibility(8);
            }
            this.binding.appBarHomeLayout.bannerSliderLayout.viewPager2.setAdapter(new SliderAdapter(this, this.bannerListTableForTopBanner1));
            Utils.INSTANCE.setUpViewPager(this.binding.appBarHomeLayout.bannerSliderLayout.viewPager2, this.binding.appBarHomeLayout.bannerSliderLayout.bannerIndicator, this.bannerListTableForTopBanner1);
            return;
        }
        this.viewPagerRL.setVisibility(8);
    }

    public ArrayList<MasterCat> removeDuplicates(ArrayList<MasterCat> list, String s) {
        ArrayList<MasterCat> arrayList = new ArrayList<>();
        for (MasterCat masterCat : list) {
            if (!arrayList.isEmpty()) {
                int i = 0;
                while (true) {
                    if (i < arrayList.size()) {
                        if (arrayList.get(i).getId().equalsIgnoreCase(masterCat.getId())) {
                            break;
                        }
                        i++;
                    } else {
                        arrayList.add(masterCat);
                        break;
                    }
                }
            } else {
                arrayList.add(masterCat);
            }
        }
        return arrayList;
    }

    private void pushEventForPushNotification(String notification_code) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_id", AnalyticHelper.INSTANCE.getUserId());
        if (TextUtils.isEmpty(notification_code)) {
            notification_code = "NA";
        }
        map.put(AnalyticsConstants.push_preview, notification_code);
        map.put("action_type", "notification_clicked");
        AnalyticEvents.INSTANCE.pushEvents(this, AnalyticsConstants.PUSH_NOTIFICATION, map);
    }

    @Override // com.razorpay.PaymentResultListener
    public void onPaymentSuccess(String s) {
        TileDataAdapter tileDataAdapter = this.tileDataAdapter;
        if (tileDataAdapter != null) {
            tileDataAdapter.onPaymentSuccess(s);
        }
    }

    @Override // com.razorpay.PaymentResultListener
    public void onPaymentError(int i, String s) {
        TileDataAdapter tileDataAdapter = this.tileDataAdapter;
        if (tileDataAdapter != null) {
            tileDataAdapter.onPaymentError(i, s);
        }
    }

    @Override // com.appnew.android.Payment.PaymentGatewayListener
    public void onSuccess(String posTxnId) {
        TileDataAdapter tileDataAdapter = this.tileDataAdapter;
        if (tileDataAdapter != null) {
            tileDataAdapter.onSuccess(posTxnId);
        }
    }

    @Override // com.appnew.android.Payment.PaymentGatewayListener
    public void onSuccessEsewa(String productId, String totalAmount, String referenceId, String scdId) {
        TileDataAdapter tileDataAdapter = this.tileDataAdapter;
        if (tileDataAdapter != null) {
            tileDataAdapter.onSuccessEsewa(productId, totalAmount, referenceId, scdId);
        }
    }

    @Override // com.appnew.android.Payment.PaymentGatewayListener
    public void onFailed(boolean isFailure) {
        TileDataAdapter tileDataAdapter = this.tileDataAdapter;
        if (tileDataAdapter != null) {
            tileDataAdapter.onFailed(isFailure);
        }
    }
}
