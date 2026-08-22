package com.appnew.android.Theme;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
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
import android.view.ViewTreeObserver;
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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager2.widget.ViewPager2;
import androidx.window.core.layout.WindowSizeClass;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import com.appnew.android.BuildConfig;
import com.appnew.android.Coupon.Activity.CouponActivity;
import com.appnew.android.CourseTransfer.CourseTransferActivity;
import com.appnew.android.Courses.Activity.Concept_newActivity;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.Courses.Activity.QuizActivity;
import com.appnew.android.Courses.Activity.SearchActivity;
import com.appnew.android.Courses.Activity.WebFragActivity;
import com.appnew.android.Courses.Fragment.SingleStudy;
import com.appnew.android.CreateTest.Activity.CreateTestActivity;
import com.appnew.android.CustomPayment.CustomPaymentActivity;
import com.appnew.android.Download.Audio.AudioPlayerService;
import com.appnew.android.Download.AudioPlayerActivty;
import com.appnew.android.Download.DownloadActivity;
import com.appnew.android.Download.DownloadVideoPlayer;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Intro.Activity.CategoryActivity;
import com.appnew.android.LiveClass.Activity.LiveClassActivity;
import com.appnew.android.LiveTest.Activity.LivetestActivity;
import com.appnew.android.Model.BottomMenu;
import com.appnew.android.Model.BottomSetting;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Model.Courses.Cards;
import com.appnew.android.Model.LeftMenu;
import com.appnew.android.Model.PostFile;
import com.appnew.android.Model.Video;
import com.appnew.android.Notification.Notification;
import com.appnew.android.Notification.NotificationDescription;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Payment.PaymentGatewayListener;
import com.appnew.android.Profile.ProfileActivity;
import com.appnew.android.PurchaseHistory.PurchaseHistory;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Theme.Adapter.BottomSliderAdapter;
import com.appnew.android.Theme.Adapter.SliderAdapter;
import com.appnew.android.UserHistory.ContactUsPage;
import com.appnew.android.UserHistory.ConversationReplyActivity;
import com.appnew.android.UserHistory.UserHistoryActivity;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.DialogUtils;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.PreferencesUtil;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.StickyView.ui.StickyScrollView;
import com.appnew.android.Utils.ZoomFeatureHelper;
import com.appnew.android.Webview.WebViewActivty;
import com.appnew.android.WorkManger.WorkTimer;
import com.appnew.android.Zoom.Activity.BookMarkList;
import com.appnew.android.Zoom.Activity.CurrentAffairActivity;
import com.appnew.android.Zoom.Activity.CurrentAffairInfoActivity;
import com.appnew.android.Zoom.Activity.DownloadPDFActivity;
import com.appnew.android.Zoom.Activity.FAQActivity;
import com.appnew.android.Zoom.Activity.Suggestion;
import com.appnew.android.Zoom.Activity.ZoomRecodedPlayer;
import com.appnew.android.cleverTap.AnalyticHelper;
import com.appnew.android.databinding.ActivityHomeTheme2Binding;
import com.appnew.android.databinding.AppBarHomeTheme2Binding;
import com.appnew.android.feeds.activity.FeedDetails;
import com.appnew.android.home.Activity.CourseTypeActivity;
import com.appnew.android.home.Activity.HomeActivity;
import com.appnew.android.home.Activity.MyLibraryActivty;
import com.appnew.android.home.Activity.SettingsActivity;
import com.appnew.android.home.Constants;
import com.appnew.android.home.Fragment.Chatboot;
import com.appnew.android.home.adapters.LeftNavAdapter;
import com.appnew.android.home.adapters.TileDataAdapter;
import com.appnew.android.home.adapters.TileItemsAdapter;
import com.appnew.android.home.interfaces.onButtonClicked;
import com.appnew.android.home.model.FilterData.Data;
import com.appnew.android.home.model.FilterData.Filterdata;
import com.appnew.android.home.model.FilterData.Subject;
import com.appnew.android.home.model.Menu;
import com.appnew.android.player.music_player.Utils;
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
import com.appnew.android.table.ThemeSettings;
import com.appnew.android.table.UserHistroyTable;
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
import com.clevertap.android.sdk.product_config.CTProductConfigConstants;
import com.eduteria.app.app.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.common.base.Ascii;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.razorpay.PaymentResultListener;
import com.tv9news.utils.helpers.AnalyticEvents;
import com.tv9news.utils.helpers.AnalyticsConstants;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
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
import java.util.Timer;
import java.util.concurrent.ExecutionException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import me.leolin.shortcutbadger.ShortcutBadger;
import org.bouncycastle.pqc.crypto.newhope.NewHope;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class DashboardActivityTheme2 extends AppCompatActivity implements SliderAdapter.BannerClick, NetworkCall.MyNetworkCallBack, onButtonClicked, PopupMenu.OnMenuItemClickListener, PaymentGatewayListener, PaymentResultListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static Activity homeactivity;
    public static Activity homeactivitytheme2;
    LinearLayout CourseLL;
    RelativeLayout RL1P;
    private Task<AppUpdateInfo> appUpdateInfoTask;
    LinearLayout attendance_rl;
    private AudioTable audioTable;
    Button backBtn;
    private ActivityHomeTheme2Binding binding;
    LinearLayout bottomLL;
    BottomSetting bottomSetting;
    RelativeLayout bottomViewPagerRL;
    CardView card1;
    LinearLayout cartLL;
    public ImageView chatboat;
    ImageButton chromecast;
    public String contentType;
    RecyclerView courseListRV;
    LinearLayout cvrNotificationCount;
    public ImageView downarrowIV;
    DrawerLayout drawer;
    RelativeLayout filter;
    TextView filterOne;
    TextView filterTwo;
    RelativeLayout filter_one_click;
    RelativeLayout filter_two_click;
    Filterdata filterdata;
    FrameLayout forchatbot;
    public Fragment fragment;
    private FragmentManager fragmentManager;
    ImageView homeBackIV;
    LinearLayout homeLL;
    private int inAppUpdateType;
    private InstallStateUpdatedListener installStateUpdatedListener;
    int lang;
    TextView launguagespinner;
    LeftMenu leftMenu;
    LinearLayout libLL;
    LinearLayout liveclass;
    LinearLayout liveclassLL;
    LinearLayout livetest;
    LinearLayout livetestLL;
    RelativeLayout ll_top;
    private AppUpdateManager mAppUpdateManager;
    String mPhoneNumber;
    LinearLayout my_library;
    public RecyclerView navRV;
    LinearLayout nav_headerLL;
    NavigationView navigationView;
    NetworkCall networkCall;
    RelativeLayout no_data_found_RL;
    TextView notificaionCount;
    int notification_code;
    ProgressBar paginationLoader;
    TextView profileEmail;
    public ImageView profileImage;
    public ImageView profileImageText;
    RelativeLayout profileLL;
    TextView profileName;
    private SwipeRefreshLayout pullToReferesh;
    private Dialog quizBasicInfoDialog;
    private StickyScrollView scrollView;
    ImageView searchIV;
    TextView subjectspinner;
    LinearLayout testLL;
    TileDataAdapter tileDataAdapter;
    RecyclerView tileRv;
    TextView tile_tv;
    RelativeLayout titleinnerRL;
    ActionBarDrawerToggle toggle;
    public Toolbar toolbar;
    TextView toolbartitleTV;
    UtkashRoom utkashRoom;
    TextView versionnameTV;
    private Video videodata;
    RelativeLayout viewPagerRL;
    BottomSheetDialog watchlist;
    long backPressed = 0;
    String greetingTiming = "";
    int currentHour = 0;
    private boolean backstatus = false;
    public String contentType_id = "0";
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
    List<BottomMenuTable> bottomMenuTables = new ArrayList();
    ArrayList<Cards> cardsArrayList = new ArrayList<>();
    ArrayList<MasteAllCatTable> selected_master_cat = new ArrayList<>();
    ArrayList<MasteAllCatTable> selectedsub_all_cat = new ArrayList<>();
    public boolean isfilterchanged = false;
    String launguageindex = "";
    String subjectindex = "";
    String SelectedLaunguageid = "";
    String SelectedSubjectid = "";
    boolean ispaginationavailable = false;
    String time = "";
    String message = "";
    String title = "";
    String url = "";
    String imageUrl = "";
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
    private Timer timer = new Timer();
    List<BannerListTable> bannerListTables = new ArrayList();
    boolean hitMaster = true;
    ArrayList<View> viewArrayList = new ArrayList<>();
    private int STORAGE_PERMISSION_TYPE = 3;
    public final int REQUEST_CODE_MULTIPLE_PIKER = 1203;
    String is_paid = "";
    private String post_id = "";
    private String id = "";
    private String test_series_name = "";
    private String solutions = "";
    private String test_series_date = "";
    private String test_id = "";
    public View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme2.2
        /* JADX WARN: Code restructure failed: missing block: B:212:0x04af, code lost:
        
            continue;
         */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onClick(android.view.View r21) {
            /*
                Method dump skipped, instruction units count: 1396
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Theme.DashboardActivityTheme2.AnonymousClass2.onClick(android.view.View):void");
        }
    };
    ViewPager2.OnPageChangeCallback bannerPageChangeCallback = new ViewPager2.OnPageChangeCallback() { // from class: com.appnew.android.Theme.DashboardActivityTheme2.3
        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            super.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            super.onPageSelected(position);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int state) {
            super.onPageScrollStateChanged(state);
        }
    };
    ViewPager2.OnPageChangeCallback bannerPageChangeCallbackBottom = new ViewPager2.OnPageChangeCallback() { // from class: com.appnew.android.Theme.DashboardActivityTheme2.4
        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            super.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            super.onPageSelected(position);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int state) {
            super.onPageScrollStateChanged(state);
        }
    };
    boolean isAttendanceOutClickable = false;
    BroadcastReceiver workTimer = new BroadcastReceiver() { // from class: com.appnew.android.Theme.DashboardActivityTheme2.5
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.hasExtra("current_time")) {
                double intExtra = intent.getIntExtra("current_time", 0);
                if (intExtra >= 2.16E7d) {
                    DashboardActivityTheme2.this.binding.dashBoardMain.attendanceOut.setBackground(ResourcesCompat.getDrawable(DashboardActivityTheme2.this.getResources(), R.drawable.common_round_corners_button_drawable, DashboardActivityTheme2.this.getTheme()));
                    DashboardActivityTheme2.this.isAttendanceOutClickable = true;
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                DashboardActivityTheme2.this.binding.dashBoardMain.attendanceTimer.setText(simpleDateFormat.format(new Date((long) intExtra)));
            }
        }
    };
    String[] langIds = {"1"};

    private void automateBottomViewPagerSwiping() {
    }

    private void automateViewPagerSwiping() {
    }

    public LinearLayout initBottomView(Menu menu) {
        LinearLayout linearLayout = (LinearLayout) View.inflate(this, R.layout.bottom_item, null);
        TextView textView = (TextView) linearLayout.findViewById(R.id.title);
        final ImageView imageView = (ImageView) linearLayout.findViewById(R.id.icon);
        textView.setText(menu.getName());
        Glide.with((FragmentActivity) this).asBitmap().load(menu.getImageUrl()).into(new CustomTarget<Bitmap>() { // from class: com.appnew.android.Theme.DashboardActivityTheme2.1
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
        linearLayout.setOnClickListener(this.onClickListener);
        return linearLayout;
    }

    public void openWhatsapp() {
        this.mPhoneNumber = this.leftMenu.getMobile_number();
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://wa.me/" + this.mPhoneNumber)));
    }

    private boolean isWorkScheduled(String tag) {
        try {
            Iterator<WorkInfo> it = WorkManager.getInstance().getWorkInfosByTag(tag).get().iterator();
            boolean z = false;
            while (it.hasNext()) {
                WorkInfo.State state = it.next().getState();
                boolean z2 = true;
                boolean z3 = state == WorkInfo.State.RUNNING;
                if (state != WorkInfo.State.ENQUEUED) {
                    z2 = false;
                }
                z = z3 | z2;
            }
            return z;
        } catch (InterruptedException e2) {
            e2.printStackTrace();
            return false;
        } catch (ExecutionException e3) {
            e3.printStackTrace();
            return false;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(final Bundle savedInstanceState) {
        ThemeSettings themeSettingsData;
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        this.utkashRoom = UtkashRoom.getAppDatabase(this);
        ActivityHomeTheme2Binding activityHomeTheme2BindingInflate = ActivityHomeTheme2Binding.inflate(getLayoutInflater());
        this.binding = activityHomeTheme2BindingInflate;
        setContentView(activityHomeTheme2BindingInflate.getRoot());
        Helper.setSystemBarLight(this);
        homeactivitytheme2 = this;
        if (!BuildConfig.FLAVOR.equalsIgnoreCase("onlineSkillIndia")) {
            this.binding.profileEditIv.setImageTintList(null);
        } else {
            this.binding.profileEditIv.setImageResource(R.drawable.edit);
        }
        this.networkCall = new NetworkCall(this, this);
        this.toolbartitleTV = (TextView) findViewById(R.id.toolbartitleTV);
        this.pullToReferesh = (SwipeRefreshLayout) findViewById(R.id.pullto_referesh);
        this.notificaionCount = (TextView) findViewById(R.id.notificaionCount);
        this.cvrNotificationCount = (LinearLayout) findViewById(R.id.cvrNotificationCount);
        this.pullToReferesh.setRefreshing(false);
        this.liveclass = (LinearLayout) findViewById(R.id.liveclass);
        this.libLL = (LinearLayout) findViewById(R.id.libLL);
        this.livetest = (LinearLayout) findViewById(R.id.livetest);
        this.livetestLL = (LinearLayout) findViewById(R.id.livetestLL);
        this.bottomLL = (LinearLayout) findViewById(R.id.bottomLL);
        this.liveclassLL = (LinearLayout) findViewById(R.id.liveclassLL);
        this.CourseLL = (LinearLayout) findViewById(R.id.CourseLL);
        this.filter = (RelativeLayout) findViewById(R.id.filter);
        this.forchatbot = (FrameLayout) findViewById(R.id.forchatbot);
        this.filterOne = (TextView) findViewById(R.id.filterOne);
        this.viewPagerRL = (RelativeLayout) findViewById(R.id.viewPagerRL);
        this.bottomViewPagerRL = (RelativeLayout) findViewById(R.id.bottomViewPagerRL);
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
        this.cartLL = (LinearLayout) findViewById(R.id.cartLL);
        this.card1 = (CardView) findViewById(R.id.card1);
        this.attendance_rl = (LinearLayout) findViewById(R.id.attendance_rl);
        this.courseListRV.setLayoutManager(new LinearLayoutManager(this));
        if (BuildConfig.FLAVOR.equalsIgnoreCase("onlineSkillIndia")) {
            this.card1.setVisibility(8);
            this.attendance_rl.setVisibility(0);
            this.binding.dashBoardMain.searchIV.setVisibility(8);
            this.binding.dashBoardMain.titleinnerRL.setVisibility(8);
            this.binding.dashBoardMain.downarrowIV.setVisibility(8);
            this.binding.dashBoardMain.headerImage.setVisibility(0);
            this.binding.dashBoardMain.greetingMsgLL.setVisibility(0);
        }
        if (!logutuser()) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            this.fragmentManager = supportFragmentManager;
            supportFragmentManager.beginTransaction().setCustomAnimations(R.anim.activity_in, R.anim.activity_out, R.anim.activity_in, R.anim.activity_out);
            this.fragment = this.fragmentManager.findFragmentById(R.id.chatboat);
            AppUpdateManager appUpdateManagerCreate = AppUpdateManagerFactory.create(this);
            this.mAppUpdateManager = appUpdateManagerCreate;
            this.appUpdateInfoTask = appUpdateManagerCreate.getAppUpdateInfo();
            InstallStateUpdatedListener installStateUpdatedListener = new InstallStateUpdatedListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda16
                @Override // com.google.android.play.core.listener.StateUpdatedListener
                public final void onStateUpdate(InstallState installState) {
                    this.f$0.lambda$onCreate$0(installState);
                }
            };
            this.installStateUpdatedListener = installStateUpdatedListener;
            this.mAppUpdateManager.registerListener(installStateUpdatedListener);
            this.inAppUpdateType = 0;
            checkAppUpdate();
            MakeMyExam.userId = SharedPreference.getInstance().getLoggedInUser().getId();
            FirebaseCrashlytics.getInstance().setUserId(MakeMyExam.userId);
            this.courselists.clear();
            this.backBtn.setVisibility(8);
            if (getIntent() != null) {
                int intExtra = getIntent().getIntExtra(Const.NOTIFICATION_CODE, 0);
                this.notification_code = intExtra;
                if (intExtra != 0) {
                    pushEventForPushNotification("" + this.notification_code);
                }
                this.course_id = getIntent().getStringExtra("course_id");
                this.fieldid = getIntent().getStringExtra("file_id");
                if (getIntent().getStringExtra("test_id") != null) {
                    this.test_id = getIntent().getStringExtra("test_id");
                }
                this.coupon_for = getIntent().getStringExtra("coupon_for");
                this.ts = getIntent().getLongExtra(CTProductConfigConstants.KEY_LAST_FETCHED_TIMESTAMP, 0L);
                this.audioTable = (AudioTable) getIntent().getSerializableExtra("audiotable");
                this.topicid = getIntent().getStringExtra(Const.TOPIC_ID);
                this.video_type = getIntent().getStringExtra("type");
                this.tiletype = getIntent().getStringExtra(Const.TILE_TYPE);
                this.tileid = getIntent().getStringExtra("tile_id");
                this.revertapi = getIntent().getStringExtra(Const.REVERT_API);
                this.type = getIntent().getStringExtra("type");
                this.title = getIntent().getStringExtra("title");
                this.message_target = getIntent().getStringExtra(TypedValues.AttributesType.S_TARGET);
                this.url = getIntent().getStringExtra("url");
                this.imageUrl = getIntent().getStringExtra("imageUrl");
                this.message = getIntent().getStringExtra("description");
                this.parentid = getIntent().getStringExtra(Const.shareparentid);
                this.contentType_id = getIntent().getStringExtra(Const.TAB_ID);
                String str = this.parentid;
                if (str == null) {
                    str = "";
                }
                this.parentid = str;
                this.id = getIntent().getStringExtra("id");
                this.post_id = getIntent().getStringExtra("post_id");
                this.test_series_name = getIntent().getStringExtra("test_series_name");
                this.solutions = getIntent().getStringExtra("solutions");
                this.test_series_date = getIntent().getStringExtra("result_date");
                hitApiIfNotInLocal();
            }
            this.homeBackIV.setVisibility(8);
            setHomeDrawer();
            createMenus();
            setClicks();
            int i = SharedPreference.getInstance().getInt(Const.CURRENT_HOUR);
            this.currentHour = i;
            if (i < 12 && i >= 5) {
                this.greetingTiming = "Good Morning,";
            } else if (i < 17 && i >= 12) {
                this.greetingTiming = "Good Afternoon,";
            } else if (i < 20 && i >= 17) {
                this.greetingTiming = "Good Evening,";
            } else if (i <= 24 && i >= 20) {
                this.greetingTiming = "Good Night,";
            } else if (i < 5 && i >= 0) {
                this.greetingTiming = "Good Night,";
            } else {
                this.greetingTiming = "Hello";
            }
            if (BuildConfig.FLAVOR.equalsIgnoreCase("onlineSkillIndia")) {
                SharedPreference.getInstance().putString("user_define_id", SharedPreference.getInstance().getLoggedInUser().getMobile());
                Helper.gotoActivity(new Intent(this, (Class<?>) UserAttendanceActivity.class), this);
            }
            if (SharedPreference.getInstance().getString(Const.SHOW_GREETING).equalsIgnoreCase("1") && BuildConfig.FLAVOR.equalsIgnoreCase("onlineSkillIndia")) {
                this.binding.dashBoardMain.greetingMsgLL.setVisibility(0);
                this.binding.dashBoardMain.cvrHeaderKrantikari.setVisibility(0);
            }
            if (SharedPreference.getInstance().getLoggedInUser().getName() != null && this.greetingTiming != null) {
                SharedPreference.getInstance().getLoggedInUser().getName();
                if (BuildConfig.FLAVOR.equalsIgnoreCase("onlineSkillIndia")) {
                    this.binding.dashBoardMain.greetingMsgTV.setText(getResources().getString(R.string.Skill_india));
                }
            }
            this.chatboat.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onCreate$1(savedInstanceState);
                }
            }));
            LocalBroadcastManager.getInstance(this).registerReceiver(this.workTimer, new IntentFilter("work_timer_data"));
            if (!isWorkScheduled("SomeWork")) {
                WorkManager.getInstance(this).enqueueUniqueWork("SomeWork", ExistingWorkPolicy.KEEP, new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) WorkTimer.class).build());
            }
            this.scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme2.6
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public void onScrollChanged() {
                    try {
                        if (DashboardActivityTheme2.this.scrollView.getChildAt(DashboardActivityTheme2.this.scrollView.getChildCount() - 1).getBottom() - (DashboardActivityTheme2.this.scrollView.getHeight() + DashboardActivityTheme2.this.scrollView.getScrollY()) == 0 && DashboardActivityTheme2.this.notification_code == 0 && DashboardActivityTheme2.this.ispaginationavailable) {
                            if (!DashboardActivityTheme2.this.isfilterapply) {
                                if (DashboardActivityTheme2.this.utkashRoom.getHomeApiStatusdata().isRecordExistsUserId(MakeMyExam.userId, DashboardActivityTheme2.this.mastercatid + "_" + DashboardActivityTheme2.this.allcatindex_id + "_" + DashboardActivityTheme2.this.allsubcatindex_id + "_" + DashboardActivityTheme2.this.contentType_id)) {
                                    HomeApiStatusTable homeApiStatusTable = DashboardActivityTheme2.this.utkashRoom.getHomeApiStatusdata().getcoursedetail(DashboardActivityTheme2.this.mastercatid + "_" + DashboardActivityTheme2.this.allcatindex_id + "_" + DashboardActivityTheme2.this.allsubcatindex_id + "_" + DashboardActivityTheme2.this.contentType_id, MakeMyExam.getUserId());
                                    if (homeApiStatusTable.getStatus().equalsIgnoreCase("true")) {
                                        DashboardActivityTheme2.this.paginationLoader.setVisibility(0);
                                        DashboardActivityTheme2.this.pagecount = Integer.parseInt(homeApiStatusTable.getPage());
                                        DashboardActivityTheme2.this.pagecount++;
                                        DashboardActivityTheme2.this.getCourseData(false);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            DashboardActivityTheme2.this.pagecount++;
                            DashboardActivityTheme2.this.getCourseData(false);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
            this.binding.dashBoardMain.attendanceOut.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onCreate$2();
                }
            }));
            this.pullToReferesh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme2.7
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public void onRefresh() {
                    APITABLE apitable = DashboardActivityTheme2.this.utkashRoom.getapidao().getapidetail("ut_009", MakeMyExam.userId);
                    if (Long.parseLong(apitable.getTimestamp()) + Long.parseLong(apitable.getInterval()) < System.currentTimeMillis() / 1000) {
                        DashboardActivityTheme2.this.utkashRoom.getLaunguages().deletedata();
                        DashboardActivityTheme2.this.utkashRoom.getMasterAllCatDao().deletedata();
                        DashboardActivityTheme2.this.utkashRoom.getMastercatDao().deletedata();
                        DashboardActivityTheme2.this.utkashRoom.getcoursetypemaster().deletedata();
                        DashboardActivityTheme2.this.pullrefresh = true;
                        DashboardActivityTheme2.this.initialState();
                        DashboardActivityTheme2.this.isfilterchanged = false;
                        DashboardActivityTheme2.this.subjectindex = "";
                        DashboardActivityTheme2.this.launguageindex = "";
                        DashboardActivityTheme2.this.SelectedLaunguageid = "";
                        DashboardActivityTheme2.this.SelectedSubjectid = "";
                        DashboardActivityTheme2.this.is_paid = "";
                        DashboardActivityTheme2.this.ispaginationavailable = false;
                        DashboardActivityTheme2.this.isfilterapply = false;
                        DashboardActivityTheme2.this.hit_api_master_data();
                        DashboardActivityTheme2.this.pullToReferesh.setRefreshing(false);
                    } else {
                        DashboardActivityTheme2.this.pullToReferesh.setRefreshing(false);
                    }
                    if (SharedPreference.getInstance().getString(Const.IS_RECENT_WATCH).equalsIgnoreCase("1")) {
                        SharedPreference.getInstance().putString(Const.IS_RECENT_REFRESH, "");
                        new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme2.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                DashboardActivityTheme2.this.hitRecentWatchApi();
                            }
                        }, 500L);
                    }
                }
            });
            this.tileRv.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme2.8
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                    DashboardActivityTheme2.this.toggleRefreshing(newState == 0);
                }
            });
            if (this.hitMaster) {
                this.hitMaster = false;
                this.networkCall.NetworkAPICall(API.master_content, "", true, false);
            }
            if (!Helper.isNetworkConnected(this) && this.utkashRoom.getthemeSettingdao().is_setting_exit() && (themeSettingsData = this.utkashRoom.getthemeSettingdao().data()) != null) {
                LeftMenu leftMenu = (LeftMenu) new Gson().fromJson(themeSettingsData.getLeft_menu(), LeftMenu.class);
                BottomMenu bottomMenu = (BottomMenu) new Gson().fromJson(themeSettingsData.getBottom(), BottomMenu.class);
                if ((leftMenu != null && leftMenu.getDownloads().equalsIgnoreCase("1")) || (bottomMenu != null && bottomMenu.getDownloads() != null && bottomMenu.getDownloads().equalsIgnoreCase("1"))) {
                    Helper.goToDownloadsOfflineMode(this);
                }
            }
        }
        if (SharedPreference.getInstance().getString(Const.IS_RECENT_WATCH).equalsIgnoreCase("1")) {
            SharedPreference.getInstance().putString(Const.IS_RECENT_REFRESH, "");
            hitRecentWatchApi();
        }
        getDeepLinks();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(InstallState installState) {
        if (installState.installStatus() == 11) {
            popupSnackbarForCompleteUpdate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$1(Bundle bundle) {
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
    public /* synthetic */ Unit lambda$onCreate$2() {
        if (this.isAttendanceOutClickable) {
            if (SharedPreference.getInstance().getLoggedInUser().getId() == null || SharedPreference.getInstance().getLoggedInUser().getId().equalsIgnoreCase("0")) {
                Helper.GuestSignOutUser(this);
                return null;
            }
            getLogoutDialog(this, getResources().getString(R.string.logout_title), getResources().getString(R.string.logout_confirmation_message));
            return null;
        }
        Toast.makeText(this, "Not Enough Time!! Must Need Six Hours", 0).show();
        return null;
    }

    private void setClicks() {
        this.homeBackIV.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$3();
            }
        }));
        this.profileLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme2.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (!Helper.isNetworkConnected(DashboardActivityTheme2.this)) {
                    Helper.showInternetToast(DashboardActivityTheme2.this);
                } else {
                    Helper.gotoActivity(DashboardActivityTheme2.this, (Class<?>) Notification.class);
                }
            }
        });
        this.my_library.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$4();
            }
        }));
        this.libLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$5();
            }
        }));
        this.livetest.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda31
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$6();
            }
        }));
        this.liveclassLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda32
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$7();
            }
        }));
        this.livetestLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda34
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$8();
            }
        }));
        this.nav_headerLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda35
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$9();
            }
        }));
        this.liveclass.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda36
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$10();
            }
        }));
        this.homeLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda37
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$11();
            }
        }));
        this.testLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda38
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$12();
            }
        }));
        this.filter.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$15();
            }
        }));
        this.chromecast.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$16();
            }
        }));
        this.searchIV.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$17();
            }
        }));
        this.filter_one_click.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$18();
            }
        }));
        this.downarrowIV.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$19();
            }
        }));
        this.cartLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme2.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Helper.gotoActivity(DashboardActivityTheme2.this, (Class<?>) DownloadActivity.class);
            }
        });
        this.titleinnerRL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$20();
            }
        }));
        this.filter_two_click.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$21();
            }
        }));
        this.binding.dashBoardMain.notificationLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$22();
            }
        }));
        BuildConfig.FLAVOR.equalsIgnoreCase("onlineSkillIndia");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$3() {
        onBackPressed();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$4() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, (Class<?>) MyLibraryActivty.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$5() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, (Class<?>) MyLibraryActivty.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$6() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, (Class<?>) LivetestActivity.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$7() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, (Class<?>) LiveClassActivity.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$8() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, (Class<?>) LivetestActivity.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$9() {
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
    public /* synthetic */ Unit lambda$setClicks$10() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, (Class<?>) LiveClassActivity.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$11() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$12() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, CreateTestActivity.class, "1");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$15() {
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
            AsyncTask.execute(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda44
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setClicks$14(data);
                }
            });
        } else {
            Filterdata filterdata = this.filterdata;
            if (filterdata != null && filterdata.getData() != null && this.filterdata.getData().getLanguages() != null) {
                this.filterdata = new Filterdata();
                Data data2 = new Data();
                data2.setSubjects((List) new Gson().fromJson(this.utkashRoom.getMasterAllCatDao().getfilteddata(this.allsubcatindex_id), new TypeToken<List<Subject>>() { // from class: com.appnew.android.Theme.DashboardActivityTheme2.11
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
    public /* synthetic */ void lambda$setClicks$14(Data data) {
        data.setSubjects((ArrayList) new Gson().fromJson(this.utkashRoom.getMasterAllCatDao().getfilteddata(this.allsubcatindex_id), new TypeToken<ArrayList<Subject>>() { // from class: com.appnew.android.Theme.DashboardActivityTheme2.10
        }.getType()));
        data.setLanguages(this.LanguagesTable);
        this.filterdata.setData(data);
        runOnUiThread(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setClicks$13();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setClicks$13() {
        openwatchlist_dailog_resource(this, this.filterdata.getData().getLanguages(), this.filterdata.getData().getSubjects());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$16() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.startCast(this);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$17() {
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
    public /* synthetic */ Unit lambda$setClicks$18() {
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
    public /* synthetic */ Unit lambda$setClicks$19() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        PopupMenu popupMenu = new PopupMenu(this, this.toolbartitleTV, 3);
        for (int i = 0; i < this.mastercatlist.size(); i++) {
            popupMenu.getMenu().add(this.mastercatlist.get(i).getCat());
        }
        this.clicktype = "1";
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$20() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        PopupMenu popupMenu = new PopupMenu(this, this.toolbartitleTV, 3);
        for (int i = 0; i < this.mastercatlist.size(); i++) {
            popupMenu.getMenu().add(this.mastercatlist.get(i).getCat());
        }
        this.clicktype = "1";
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$21() {
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
    public /* synthetic */ Unit lambda$setClicks$22() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
        }
        Helper.gotoActivity(this, (Class<?>) Notification.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hit_api_master_data() {
        if (this.hitMaster) {
            this.hitMaster = false;
            this.networkCall.NetworkAPICall(API.master_content, "", true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initialState() {
        this.pagecount = 1;
        this.cardsArrayList.clear();
    }

    private void getTileItems(ArrayList<Cards> cardsArrayList, int pos) {
        this.contentType = cardsArrayList.get(pos).getType() + cardsArrayList.get(pos).getId();
        this.contentType_id = cardsArrayList.get(pos).getId();
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
        this.drawer.addDrawerListener(new DrawerLayout.DrawerListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme2.13
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
                Helper.HideKeyboard(DashboardActivityTheme2.this);
            }
        });
        ActionBarDrawerToggle actionBarDrawerToggle2 = new ActionBarDrawerToggle(this, this.drawer, this.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) { // from class: com.appnew.android.Theme.DashboardActivityTheme2.14
            @Override // androidx.appcompat.app.ActionBarDrawerToggle, androidx.drawerlayout.widget.DrawerLayout.DrawerListener
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override // androidx.appcompat.app.ActionBarDrawerToggle, androidx.drawerlayout.widget.DrawerLayout.DrawerListener
            public void onDrawerOpened(View drawerView) {
                String string = SharedPreference.getInstance().getString(Const.SERVER_TIME);
                if (TextUtils.isEmpty(string) || string.equals("0")) {
                    if (SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE).equalsIgnoreCase("") || SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE).equals("0")) {
                        DashboardActivityTheme2.this.networkCall.NetworkAPICall(API.IS_COUPON_AVAILABLE, "", false, false);
                    } else if (Integer.parseInt(SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE)) > 0) {
                        DashboardActivityTheme2.this.createMenus();
                    }
                } else if (Long.parseLong(string) <= System.currentTimeMillis()) {
                    DashboardActivityTheme2.this.networkCall.NetworkAPICall(API.IS_COUPON_AVAILABLE, "", false, false);
                }
                Helper.HideKeyboard(DashboardActivityTheme2.this);
                super.onDrawerOpened(drawerView);
            }
        };
        this.drawer.setDrawerListener(actionBarDrawerToggle2);
        actionBarDrawerToggle2.syncState();
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
            if (this.utkashRoom.getHomeApiStatusdata().isRecordExistsUserId(MakeMyExam.userId, this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_0")) {
                if (this.utkashRoom.getHomeApiStatusdata().getcoursedetail(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_0", MakeMyExam.getUserId()).getStatus().equalsIgnoreCase("false")) {
                    this.pagecount = 1;
                    this.courselists.clear();
                    if (this.contentType_id.equalsIgnoreCase("0")) {
                        list2 = this.utkashRoom.getCoursedata().getcoursedata(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId);
                    } else {
                        list2 = this.utkashRoom.getCoursedata().getcoursedatawithfilter(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId, cards.getId());
                    }
                    for (CourseDataTable courseDataTable : list2) {
                        this.courselists.add(new Courselist(courseDataTable.getCourse_id(), courseDataTable.getTitle(), courseDataTable.getCover_image(), courseDataTable.getMrp(), courseDataTable.getCourse_sp(), courseDataTable.getValidity(), courseDataTable.getSubject_id(), courseDataTable.getLang_id(), courseDataTable.getDesc_header_image(), courseDataTable.getExtra_json(), courseDataTable.getAvg_rating(), courseDataTable.getUser_rated(), courseDataTable.getIs_purchased(), courseDataTable.getCombo_course_ids(), "", courseDataTable.getCat_type(), courseDataTable.getHide_validity(), courseDataTable.getDescription(), courseDataTable.getDiscount(), courseDataTable.getDelivery_charge(), courseDataTable.getBook_redirection_link(), courseDataTable.getPayment_mode()));
                    }
                    if (this.courselists.size() > 0) {
                        this.courseListRV.setVisibility(0);
                        this.no_data_found_RL.setVisibility(8);
                    } else {
                        this.courseListRV.setVisibility(8);
                        this.no_data_found_RL.setVisibility(0);
                    }
                    TileDataAdapter tileDataAdapter = new TileDataAdapter(this, this.courselists, "", this, this);
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
                            this.courselists.add(new Courselist(courseDataTable2.getCourse_id(), courseDataTable2.getTitle(), courseDataTable2.getCover_image(), courseDataTable2.getMrp(), courseDataTable2.getCourse_sp(), courseDataTable2.getValidity(), courseDataTable2.getSubject_id(), courseDataTable2.getLang_id(), courseDataTable2.getDesc_header_image(), courseDataTable2.getExtra_json(), courseDataTable2.getAvg_rating(), courseDataTable2.getUser_rated(), courseDataTable2.getIs_purchased(), courseDataTable2.getCombo_course_ids(), "", courseDataTable2.getCat_type(), courseDataTable2.getHide_validity(), courseDataTable2.getDescription(), courseDataTable2.getDiscount(), courseDataTable2.getDelivery_charge(), courseDataTable2.getBook_redirection_link(), courseDataTable2.getPayment_mode()));
                        }
                        if (this.courselists.size() > 0) {
                            this.courseListRV.setVisibility(0);
                            this.no_data_found_RL.setVisibility(8);
                        } else {
                            this.courseListRV.setVisibility(8);
                            this.no_data_found_RL.setVisibility(0);
                        }
                        TileDataAdapter tileDataAdapter2 = new TileDataAdapter(this, this.courselists, "", this, this);
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

    public void getTileData(Cards cards) {
        this.tile_tv.setText(cards.getTile_name());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.utkashRoom == null) {
            UtkashRoom appDatabase = UtkashRoom.getAppDatabase(this);
            this.utkashRoom = appDatabase;
            appDatabase.getOpenHelper().getWritableDatabase().enableWriteAheadLogging();
        }
        try {
            this.mAppUpdateManager.getAppUpdateInfo().addOnSuccessListener(new OnSuccessListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda13
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    this.f$0.lambda$onResume$23((AppUpdateInfo) obj);
                }
            });
            this.mAppUpdateManager.getAppUpdateInfo().addOnSuccessListener(new OnSuccessListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda14
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    this.f$0.lambda$onResume$24((AppUpdateInfo) obj);
                }
            });
            if (SharedPreference.getInstance().getString(Const.IS_RECENT_WATCH).equalsIgnoreCase("1") && SharedPreference.getInstance().getString(Const.IS_RECENT_REFRESH).equalsIgnoreCase("1")) {
                SharedPreference.getInstance().putString(Const.IS_RECENT_REFRESH, "");
                new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme2.15
                    @Override // java.lang.Runnable
                    public void run() {
                        DashboardActivityTheme2.this.hitRecentWatchApi();
                    }
                }, 800L);
            }
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
    public /* synthetic */ void lambda$onResume$23(AppUpdateInfo appUpdateInfo) {
        if (appUpdateInfo.updateAvailability() == 3) {
            try {
                this.mAppUpdateManager.startUpdateFlowForResult(appUpdateInfo, this.inAppUpdateType, this, this.RC_APP_UPDATE);
            } catch (IntentSender.SendIntentException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$24(AppUpdateInfo appUpdateInfo) {
        if (appUpdateInfo.installStatus() == 11) {
            popupSnackbarForCompleteUpdate();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == this.RC_APP_UPDATE) {
            if (resultCode == -1) {
                Toast.makeText(this, "App download starts...", 1).show();
            } else if (resultCode != 0) {
                Toast.makeText(this, "App download canceled.", 1).show();
            } else if (resultCode == 1) {
                Toast.makeText(this, "App download failed.", 1).show();
            }
        }
        if (requestCode == 1203 && resultCode == -1 && data != null) {
            try {
                String strCopyFileToInternalStorage = copyFileToInternalStorage(data.getData(), "SubjectiveTestPDF");
                String[] strArrSplit = strCopyFileToInternalStorage.split(MqttTopic.TOPIC_LEVEL_SEPARATOR);
                Helper.GoToWebViewPDFActivity(this, Constants.SUB_TEST_ID, strCopyFileToInternalStorage, false, strArrSplit[strArrSplit.length - 1], this.course_id + MqttTopic.MULTI_LEVEL_WILDCARD + Constants.SUB_TEST_ID, true, "CourseActivity", true);
            } catch (Exception e2) {
                Toast.makeText(this, R.string.unable_to_upload_this_file, 0).show();
                e2.printStackTrace();
                return;
            }
        }
        if (requestCode == 1000 && data != null && resultCode == 1000 && data.getBooleanExtra("fromDownloads", false)) {
            refreshApiFromDownloads();
        }
    }

    private String copyFileToInternalStorage(Uri uri, String newDirName) {
        File file;
        Cursor cursorQuery = getContentResolver().query(uri, new String[]{"_display_name", "_size"}, null, null, null);
        int columnIndex = cursorQuery.getColumnIndex("_display_name");
        int columnIndex2 = cursorQuery.getColumnIndex("_size");
        cursorQuery.moveToFirst();
        String string = cursorQuery.getString(columnIndex);
        Long.toString(cursorQuery.getLong(columnIndex2));
        if (!newDirName.equals("")) {
            File file2 = new File(getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + newDirName);
            if (!file2.exists()) {
                file2.mkdir();
            }
            file = new File(getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + newDirName + MqttTopic.TOPIC_LEVEL_SEPARATOR + string);
        } else {
            file = new File(getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + string);
        }
        try {
            if (!file.exists()) {
                InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStreamOpenInputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
                inputStreamOpenInputStream.close();
                fileOutputStream.close();
            }
        } catch (Exception unused) {
        }
        return file.getPath();
    }

    private void popupSnackbarForCompleteUpdate() {
        try {
            Snackbar snackbarMake = Snackbar.make(this.liveclass, getResources().getString(R.string.an_update_has_just_been_downloaded), -2);
            snackbarMake.setAction("RESTART", new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda43
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$popupSnackbarForCompleteUpdate$25(view);
                }
            });
            snackbarMake.show();
        } catch (Resources.NotFoundException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$popupSnackbarForCompleteUpdate$25(View view) {
        this.mAppUpdateManager.completeUpdate();
    }

    private void checkAppUpdate() {
        try {
            this.appUpdateInfoTask.addOnSuccessListener(new OnSuccessListener<AppUpdateInfo>() { // from class: com.appnew.android.Theme.DashboardActivityTheme2.16
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public void onSuccess(AppUpdateInfo appUpdateInfo) {
                    if (appUpdateInfo.updateAvailability() == 2 && appUpdateInfo.isUpdateTypeAllowed(DashboardActivityTheme2.this.inAppUpdateType)) {
                        try {
                            AppUpdateManager appUpdateManager = DashboardActivityTheme2.this.mAppUpdateManager;
                            int i = DashboardActivityTheme2.this.inAppUpdateType;
                            DashboardActivityTheme2 dashboardActivityTheme2 = DashboardActivityTheme2.this;
                            appUpdateManager.startUpdateFlowForResult(appUpdateInfo, i, dashboardActivityTheme2, dashboardActivityTheme2.RC_APP_UPDATE);
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
        this.versionnameTV.setText(Html.fromHtml(getResources().getString(R.string.version) + Helper.getVersionName(this)));
        try {
            if (this.utkashRoom.getthemeSettingdao().is_setting_exit()) {
                LeftMenu leftMenu = (LeftMenu) new Gson().fromJson(this.utkashRoom.getthemeSettingdao().data().getLeft_menu(), LeftMenu.class);
                this.leftMenu = leftMenu;
                Helper.getLeftMenu(leftMenu, this);
            }
            if (this.leftMenu == null) {
                this.leftMenu = (LeftMenu) new Gson().fromJson(this.utkashRoom.getthemeSettingdao().data().getLeft_menu(), LeftMenu.class);
            }
            final LeftNavAdapter leftNavAdapter = new LeftNavAdapter(this, Helper.getLeftMenu(this.leftMenu, this));
            this.navRV.setLayoutManager(new LinearLayoutManager(this));
            this.navRV.setAdapter(leftNavAdapter);
            leftNavAdapter.setLeftNavAdapterListener(new LeftNavAdapter.LeftNavAdapterListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme2.17
                @Override // com.appnew.android.home.adapters.LeftNavAdapter.LeftNavAdapterListener
                public void onItemClick(Menu menu) {
                    if (menu.getHaveChild().equalsIgnoreCase("1")) {
                        menu.setExpanded(!menu.isExpanded());
                    }
                    DashboardActivityTheme2.this.handleLeftMenuClick(menu);
                    leftNavAdapter.notifyDataSetChanged();
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        socialIconsVisibility(this.leftMenu);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void handleLeftMenuClick(Menu menu) {
        if (menu.getType_code() != null) {
            String type_code = menu.getType_code();
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
                case 1599:
                    if (type_code.equals("21")) {
                        b2 = Ascii.DC4;
                    }
                    break;
                case WindowSizeClass.WIDTH_DP_EXTRA_LARGE_LOWER_BOUND /* 1600 */:
                    if (type_code.equals("22")) {
                        b2 = Ascii.NAK;
                    }
                    break;
                case 1601:
                    if (type_code.equals("23")) {
                        b2 = Ascii.SYN;
                    }
                    break;
                case 1602:
                    if (type_code.equals("24")) {
                        b2 = Ascii.ETB;
                    }
                    break;
                case 1603:
                    if (type_code.equals("25")) {
                        b2 = Ascii.CAN;
                    }
                    break;
                case 1604:
                    if (type_code.equals(Constants.LEFT_NAV_KEY.user_support)) {
                        b2 = Ascii.EM;
                    }
                    break;
                case 1605:
                    if (type_code.equals(Constants.LEFT_NAV_KEY.bookmark)) {
                        b2 = Ascii.SUB;
                    }
                    break;
                case 1606:
                    if (type_code.equals(Constants.LEFT_NAV_KEY.pdfDownload)) {
                        b2 = Ascii.ESC;
                    }
                    break;
                case 1631:
                    if (type_code.equals(Constants.LEFT_NAV_KEY.attendance_report)) {
                        b2 = Ascii.FS;
                    }
                    break;
                case 1731:
                    if (type_code.equals(Constants.LEFT_NAV_KEY.change_preference)) {
                        b2 = Ascii.GS;
                    }
                    break;
                case 1822:
                    if (type_code.equals(Constants.LEFT_NAV_KEY.contact_us_query)) {
                        b2 = Ascii.RS;
                    }
                    break;
                case 1823:
                    if (type_code.equals(Constants.LEFT_NAV_KEY.book_store)) {
                        b2 = Ascii.US;
                    }
                    break;
                case NewHope.SENDA_BYTES /* 1824 */:
                    if (type_code.equals(Constants.LEFT_NAV_KEY.custom_payment)) {
                        b2 = 32;
                    }
                    break;
                case 1507423:
                    if (type_code.equals(Constants.LEFT_NAV_KEY.book_history)) {
                        b2 = 33;
                    }
                    break;
            }
            switch (b2) {
                case 0:
                    Helper.gotoActivityForResult(new Intent(this, (Class<?>) DownloadActivity.class), this, 1000);
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 1:
                case 6:
                case 11:
                case 16:
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 2:
                    startActivity(new Intent(this, (Class<?>) UserHistoryActivity.class));
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 3:
                    if (!BuildConfig.FAQ_URL.equalsIgnoreCase(BuildConfig.FAQ_URL)) {
                        if (BuildConfig.FLAVOR.equalsIgnoreCase("mahendra")) {
                            Intent intent = new Intent(this, (Class<?>) FAQActivity.class);
                            intent.putExtra("title_key", "FAQ");
                            startActivity(intent);
                        } else {
                            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(BuildConfig.FAQ_URL)));
                        }
                    } else {
                        Helper.showToast(this, getResources().getString(R.string.still_in_development), 0);
                    }
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 4:
                    DialogUtils.makeCallEmailDialog(this, true);
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 5:
                    try {
                        Intent intent2 = new Intent("android.intent.action.SEND");
                        intent2.setType(HTTP.PLAIN_TEXT_TYPE);
                        intent2.putExtra("android.intent.extra.SUBJECT", getResources().getString(R.string.app_name));
                        intent2.putExtra("android.intent.extra.TEXT", (("\nI recommend you to learn from next-gen Smart courses. Uncover a whole new way of learning with " + getResources().getString(R.string.app_name) + ". Learn, practice & create custom tests and much more. Download ") + "https://play.google.com/store/apps/details?id=com.eduteria.app.app") + " and start learning now");
                        startActivity(Intent.createChooser(intent2, "choose one"));
                        break;
                    } catch (Exception unused) {
                    }
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 7:
                    startActivity(new Intent(this, (Class<?>) SettingsActivity.class));
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 8:
                    if (SharedPreference.getInstance().getLoggedInUser().getId() == null || SharedPreference.getInstance().getLoggedInUser().getId().equalsIgnoreCase("0")) {
                        Helper.GuestSignOutUser(this);
                    } else {
                        getLogoutDialog(this, getResources().getString(R.string.logout_title), getResources().getString(R.string.logout_confirmation_message));
                    }
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 9:
                    Intent intent3 = new Intent(this, (Class<?>) WebViewActivty.class);
                    intent3.putExtra("type", getResources().getString(R.string.terms_of_service));
                    intent3.putExtra("url", API.TERMS_AND_CONDITIONS);
                    Helper.gotoActivity(intent3, this);
                    break;
                case 10:
                    try {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + getPackageName())));
                    } catch (ActivityNotFoundException unused2) {
                        return;
                    }
                    break;
                case 12:
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 13:
                    if (BuildConfig.APPLICATION_ID.equalsIgnoreCase("com.utkarshnew.android")) {
                        Intent intent4 = new Intent(this, (Class<?>) WebViewActivty.class);
                        intent4.putExtra("type", getResources().getString(R.string.offline_batch));
                        intent4.putExtra("url", "https://courses.utkarsh.com/offlineadmission/home.php");
                        startActivity(intent4);
                    } else {
                        Helper.showToast(this, getResources().getString(R.string.still_in_development), 0);
                    }
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 14:
                    Intent intent5 = new Intent(this, (Class<?>) PurchaseHistory.class);
                    intent5.putExtra("type", "1");
                    startActivity(intent5);
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 15:
                    if (BuildConfig.APPLICATION_ID.equalsIgnoreCase("com.utkarshnew.android")) {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.youtube.com/playlist?list=PLoZP2WsNfBSFGsub-jJb_uNW58zQRpDXc")));
                    } else {
                        Helper.showToast(this, "Still in Development.", 0);
                    }
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 17:
                    startActivity(new Intent(this, (Class<?>) CourseTransferActivity.class));
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 18:
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 19:
                    Helper.gotoActivity(new Intent(this, (Class<?>) CouponActivity.class), this);
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 20:
                    Intent intent6 = new Intent(this, (Class<?>) WebViewActivty.class);
                    intent6.putExtra("type", getResources().getString(R.string.privacy_policy));
                    intent6.putExtra("url", API.PRIVACY_POLICY_URL);
                    Helper.gotoActivity(intent6, this);
                    break;
                case 21:
                case 22:
                case 23:
                case 25:
                    Intent intent7 = new Intent(this, (Class<?>) Suggestion.class);
                    if (type_code.equals("22")) {
                        intent7.putExtra("title_key", Const.FEEDBACK);
                    } else if (type_code.equals("23")) {
                        intent7.putExtra("title_key", "Suggestion");
                    } else if (type_code.equals("24")) {
                        intent7.putExtra("title_key", "Complaint");
                    } else if (type_code.equals(Constants.LEFT_NAV_KEY.user_support)) {
                        intent7.putExtra("title_key", "User Support");
                    }
                    startActivity(intent7);
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 24:
                    Intent intent8 = new Intent(this, (Class<?>) CurrentAffairActivity.class);
                    intent8.putExtra("title_key", "Current Affair");
                    startActivity(intent8);
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 26:
                    Intent intent9 = new Intent(this, (Class<?>) BookMarkList.class);
                    intent9.putExtra("title_key", "Bookmark");
                    startActivity(intent9);
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 27:
                    Intent intent10 = new Intent(this, (Class<?>) DownloadPDFActivity.class);
                    intent10.putExtra("title_key", "Download");
                    startActivity(intent10);
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 28:
                    this.networkCall.NetworkAPICall(API.API_ATTENDANCE_REPORT, "", true, false);
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 29:
                    startActivity(new Intent(this, (Class<?>) CategoryActivity.class));
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 30:
                    Intent intent11 = new Intent(this, (Class<?>) ContactUsPage.class);
                    intent11.putExtra("from", Constants.LEFT_NAV_KEY.contact_us_query);
                    startActivity(intent11);
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 31:
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    if (this.leftMenu.getBook_store_link() != null && !this.leftMenu.getBook_store_link().equalsIgnoreCase("")) {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.leftMenu.getBook_store_link())));
                        break;
                    }
                    break;
                case 32:
                    Intent intent12 = new Intent(this, (Class<?>) CustomPaymentActivity.class);
                    intent12.putExtra("type", "Custom Payment");
                    intent12.putExtra("courseid", this.leftMenu.getCustom_course());
                    Helper.gotoActivity(intent12, this);
                    break;
                case 33:
                    Intent intent13 = new Intent(this, (Class<?>) PurchaseHistory.class);
                    intent13.putExtra("type", "2");
                    startActivity(intent13);
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
            }
        }
    }

    private void hit_api_for_filter() {
        this.networkCall.NetworkAPICall(API.get_filter_data, "", true, false);
    }

    public void getLogoutDialog(final Activity ctx, final String title, final String message) {
        DialogUtils.makeDialog(this, title, message, getResources().getString(R.string.yes), getResources().getString(R.string.no), true, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Theme.DashboardActivityTheme2.18
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
            public void onOKClick() {
                if (Helper.isConnected(DashboardActivityTheme2.this)) {
                    DashboardActivityTheme2.this.UserLogout();
                } else {
                    Toast.makeText(DashboardActivityTheme2.this, "No Internet connection", 0).show();
                }
            }
        }, new DialogUtils.onDialogUtilsCancelClick() { // from class: com.appnew.android.Theme.DashboardActivityTheme2.19
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
            case "data_model/users/download_attendance_report":
                return service.setAttendanceReport("");
            case "data_model/users/adddaily_attendance":
                EncryptionData encryptionData8 = new EncryptionData();
                if (this.courselists.size() > 0) {
                    encryptionData8.setCourse_id(this.courselists.get(0).getId());
                }
                return service.setDaillyAttendance(AES.encrypt(new Gson().toJson(encryptionData8)));
            case "https://appapi.videocrypt.in/index.php/data_model/test/get_test_data":
                EncryptionData encryptionData9 = new EncryptionData();
                encryptionData9.setTest_id(this.quiz_id);
                encryptionData9.setCourse_id(this.course_id);
                return service.API_GET_INFO_TEST_SERIES(AES.encrypt(new Gson().toJson(encryptionData9)));
            case "https://appapi.videocrypt.in/index.php/data_model/course/get_courses":
                try {
                    checkdeeplick();
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                EncryptionData encryptionData10 = new EncryptionData();
                encryptionData10.setCourse_type(this.contentType_id);
                encryptionData10.setSub_cat(this.allsubcatindex_id);
                encryptionData10.setLang(this.SelectedLaunguageid);
                encryptionData10.setPage("" + this.pagecount);
                encryptionData10.setIs_paid(this.is_paid);
                return service.get_courses(AES.encrypt(new Gson().toJson(encryptionData10)));
            case "data_model/meta_distributer/get_recent_watch_video":
                EncryptionData encryptionData11 = new EncryptionData();
                encryptionData11.setUser_id(MakeMyExam.getUserId());
                return service.getRecentWatchList(AES.encrypt(new Gson().toJson(encryptionData11)));
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
    /* JADX WARN: Removed duplicated region for block: B:116:0x0424 A[Catch: Exception -> 0x0875, TryCatch #3 {Exception -> 0x0875, blocks: (B:75:0x0166, B:77:0x016a, B:79:0x0170, B:80:0x0175, B:83:0x0181, B:85:0x0192, B:88:0x01ff, B:90:0x0205, B:92:0x020b, B:93:0x0212, B:95:0x022d, B:97:0x024c, B:99:0x0250, B:101:0x025e, B:103:0x0299, B:114:0x0420, B:116:0x0424, B:118:0x042d, B:119:0x0435, B:121:0x043b, B:123:0x047a, B:125:0x0519, B:128:0x0520, B:130:0x0534, B:129:0x052b, B:149:0x0661, B:151:0x0665, B:153:0x06a2, B:155:0x06a7, B:157:0x06c2, B:152:0x0684, B:134:0x0547, B:136:0x0553, B:137:0x055b, B:139:0x0561, B:141:0x05a0, B:143:0x063f, B:146:0x0646, B:148:0x0656, B:147:0x064f, B:104:0x02dc, B:105:0x0332, B:107:0x036d, B:108:0x03af, B:109:0x0404, B:111:0x0412, B:113:0x041d, B:159:0x06cf, B:161:0x06d3, B:163:0x06d8, B:165:0x06dc, B:167:0x0740, B:169:0x074e, B:87:0x01ba, B:171:0x075e, B:173:0x0762, B:175:0x079d, B:176:0x07dc, B:177:0x082d, B:179:0x0836, B:181:0x083c, B:182:0x0843, B:184:0x0847, B:186:0x084c, B:187:0x085c, B:189:0x0862, B:191:0x0868, B:192:0x086c), top: B:518:0x0166 }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0547 A[Catch: Exception -> 0x0875, TryCatch #3 {Exception -> 0x0875, blocks: (B:75:0x0166, B:77:0x016a, B:79:0x0170, B:80:0x0175, B:83:0x0181, B:85:0x0192, B:88:0x01ff, B:90:0x0205, B:92:0x020b, B:93:0x0212, B:95:0x022d, B:97:0x024c, B:99:0x0250, B:101:0x025e, B:103:0x0299, B:114:0x0420, B:116:0x0424, B:118:0x042d, B:119:0x0435, B:121:0x043b, B:123:0x047a, B:125:0x0519, B:128:0x0520, B:130:0x0534, B:129:0x052b, B:149:0x0661, B:151:0x0665, B:153:0x06a2, B:155:0x06a7, B:157:0x06c2, B:152:0x0684, B:134:0x0547, B:136:0x0553, B:137:0x055b, B:139:0x0561, B:141:0x05a0, B:143:0x063f, B:146:0x0646, B:148:0x0656, B:147:0x064f, B:104:0x02dc, B:105:0x0332, B:107:0x036d, B:108:0x03af, B:109:0x0404, B:111:0x0412, B:113:0x041d, B:159:0x06cf, B:161:0x06d3, B:163:0x06d8, B:165:0x06dc, B:167:0x0740, B:169:0x074e, B:87:0x01ba, B:171:0x075e, B:173:0x0762, B:175:0x079d, B:176:0x07dc, B:177:0x082d, B:179:0x0836, B:181:0x083c, B:182:0x0843, B:184:0x0847, B:186:0x084c, B:187:0x085c, B:189:0x0862, B:191:0x0868, B:192:0x086c), top: B:518:0x0166 }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0665 A[Catch: Exception -> 0x0875, TryCatch #3 {Exception -> 0x0875, blocks: (B:75:0x0166, B:77:0x016a, B:79:0x0170, B:80:0x0175, B:83:0x0181, B:85:0x0192, B:88:0x01ff, B:90:0x0205, B:92:0x020b, B:93:0x0212, B:95:0x022d, B:97:0x024c, B:99:0x0250, B:101:0x025e, B:103:0x0299, B:114:0x0420, B:116:0x0424, B:118:0x042d, B:119:0x0435, B:121:0x043b, B:123:0x047a, B:125:0x0519, B:128:0x0520, B:130:0x0534, B:129:0x052b, B:149:0x0661, B:151:0x0665, B:153:0x06a2, B:155:0x06a7, B:157:0x06c2, B:152:0x0684, B:134:0x0547, B:136:0x0553, B:137:0x055b, B:139:0x0561, B:141:0x05a0, B:143:0x063f, B:146:0x0646, B:148:0x0656, B:147:0x064f, B:104:0x02dc, B:105:0x0332, B:107:0x036d, B:108:0x03af, B:109:0x0404, B:111:0x0412, B:113:0x041d, B:159:0x06cf, B:161:0x06d3, B:163:0x06d8, B:165:0x06dc, B:167:0x0740, B:169:0x074e, B:87:0x01ba, B:171:0x075e, B:173:0x0762, B:175:0x079d, B:176:0x07dc, B:177:0x082d, B:179:0x0836, B:181:0x083c, B:182:0x0843, B:184:0x0847, B:186:0x084c, B:187:0x085c, B:189:0x0862, B:191:0x0868, B:192:0x086c), top: B:518:0x0166 }] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0684 A[Catch: Exception -> 0x0875, TryCatch #3 {Exception -> 0x0875, blocks: (B:75:0x0166, B:77:0x016a, B:79:0x0170, B:80:0x0175, B:83:0x0181, B:85:0x0192, B:88:0x01ff, B:90:0x0205, B:92:0x020b, B:93:0x0212, B:95:0x022d, B:97:0x024c, B:99:0x0250, B:101:0x025e, B:103:0x0299, B:114:0x0420, B:116:0x0424, B:118:0x042d, B:119:0x0435, B:121:0x043b, B:123:0x047a, B:125:0x0519, B:128:0x0520, B:130:0x0534, B:129:0x052b, B:149:0x0661, B:151:0x0665, B:153:0x06a2, B:155:0x06a7, B:157:0x06c2, B:152:0x0684, B:134:0x0547, B:136:0x0553, B:137:0x055b, B:139:0x0561, B:141:0x05a0, B:143:0x063f, B:146:0x0646, B:148:0x0656, B:147:0x064f, B:104:0x02dc, B:105:0x0332, B:107:0x036d, B:108:0x03af, B:109:0x0404, B:111:0x0412, B:113:0x041d, B:159:0x06cf, B:161:0x06d3, B:163:0x06d8, B:165:0x06dc, B:167:0x0740, B:169:0x074e, B:87:0x01ba, B:171:0x075e, B:173:0x0762, B:175:0x079d, B:176:0x07dc, B:177:0x082d, B:179:0x0836, B:181:0x083c, B:182:0x0843, B:184:0x0847, B:186:0x084c, B:187:0x085c, B:189:0x0862, B:191:0x0868, B:192:0x086c), top: B:518:0x0166 }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x06a7 A[Catch: Exception -> 0x0875, TryCatch #3 {Exception -> 0x0875, blocks: (B:75:0x0166, B:77:0x016a, B:79:0x0170, B:80:0x0175, B:83:0x0181, B:85:0x0192, B:88:0x01ff, B:90:0x0205, B:92:0x020b, B:93:0x0212, B:95:0x022d, B:97:0x024c, B:99:0x0250, B:101:0x025e, B:103:0x0299, B:114:0x0420, B:116:0x0424, B:118:0x042d, B:119:0x0435, B:121:0x043b, B:123:0x047a, B:125:0x0519, B:128:0x0520, B:130:0x0534, B:129:0x052b, B:149:0x0661, B:151:0x0665, B:153:0x06a2, B:155:0x06a7, B:157:0x06c2, B:152:0x0684, B:134:0x0547, B:136:0x0553, B:137:0x055b, B:139:0x0561, B:141:0x05a0, B:143:0x063f, B:146:0x0646, B:148:0x0656, B:147:0x064f, B:104:0x02dc, B:105:0x0332, B:107:0x036d, B:108:0x03af, B:109:0x0404, B:111:0x0412, B:113:0x041d, B:159:0x06cf, B:161:0x06d3, B:163:0x06d8, B:165:0x06dc, B:167:0x0740, B:169:0x074e, B:87:0x01ba, B:171:0x075e, B:173:0x0762, B:175:0x079d, B:176:0x07dc, B:177:0x082d, B:179:0x0836, B:181:0x083c, B:182:0x0843, B:184:0x0847, B:186:0x084c, B:187:0x085c, B:189:0x0862, B:191:0x0868, B:192:0x086c), top: B:518:0x0166 }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x06c2 A[Catch: Exception -> 0x0875, TryCatch #3 {Exception -> 0x0875, blocks: (B:75:0x0166, B:77:0x016a, B:79:0x0170, B:80:0x0175, B:83:0x0181, B:85:0x0192, B:88:0x01ff, B:90:0x0205, B:92:0x020b, B:93:0x0212, B:95:0x022d, B:97:0x024c, B:99:0x0250, B:101:0x025e, B:103:0x0299, B:114:0x0420, B:116:0x0424, B:118:0x042d, B:119:0x0435, B:121:0x043b, B:123:0x047a, B:125:0x0519, B:128:0x0520, B:130:0x0534, B:129:0x052b, B:149:0x0661, B:151:0x0665, B:153:0x06a2, B:155:0x06a7, B:157:0x06c2, B:152:0x0684, B:134:0x0547, B:136:0x0553, B:137:0x055b, B:139:0x0561, B:141:0x05a0, B:143:0x063f, B:146:0x0646, B:148:0x0656, B:147:0x064f, B:104:0x02dc, B:105:0x0332, B:107:0x036d, B:108:0x03af, B:109:0x0404, B:111:0x0412, B:113:0x041d, B:159:0x06cf, B:161:0x06d3, B:163:0x06d8, B:165:0x06dc, B:167:0x0740, B:169:0x074e, B:87:0x01ba, B:171:0x075e, B:173:0x0762, B:175:0x079d, B:176:0x07dc, B:177:0x082d, B:179:0x0836, B:181:0x083c, B:182:0x0843, B:184:0x0847, B:186:0x084c, B:187:0x085c, B:189:0x0862, B:191:0x0868, B:192:0x086c), top: B:518:0x0166 }] */
    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void SuccessCallBack(org.json.JSONObject r28, java.lang.String r29, java.lang.String r30, boolean r31) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 5056
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Theme.DashboardActivityTheme2.SuccessCallBack(org.json.JSONObject, java.lang.String, java.lang.String, boolean):void");
    }

    private void downloadAttendanceReportUrl(String url) {
        final PostFile postFile = new PostFile();
        postFile.setLink(url);
        postFile.setFile_type(Const.PDF);
        String str = url.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[url.split(MqttTopic.TOPIC_LEVEL_SEPARATOR).length - 1];
        if (!str.contains("")) {
            postFile.setFile_info(url.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[url.split(MqttTopic.TOPIC_LEVEL_SEPARATOR).length - 1]);
        } else {
            postFile.setFile_info(str.replaceAll(" ", "_"));
        }
        try {
            Dexter.withContext(this).withPermissions("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE").withListener(new MultiplePermissionsListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme2.22
                @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
                public void onPermissionsChecked(MultiplePermissionsReport report) {
                    if (Helper.getStorageInstance(DashboardActivityTheme2.this).getRecordObject(Const.PDF) != null) {
                        Helper.DownloadfilefromURL(DashboardActivityTheme2.this, (PostFile) Helper.getStorageInstance(DashboardActivityTheme2.this).getRecordObject(Const.PDF));
                        Helper.getStorageInstance(DashboardActivityTheme2.this).deleteRecord(Const.PDF);
                        return;
                    }
                    Helper.DownloadfilefromURL(DashboardActivityTheme2.this, postFile);
                }

                @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
                public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                    token.continuePermissionRequest();
                }
            }).check();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
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
        final TextView textView8 = (TextView) viewInflate.findViewById(R.id.generalInstrValueTV);
        Button button2 = (Button) viewInflate.findViewById(R.id.startQuizBtn);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.sectionListLL);
        LinearLayout linearLayout2 = (LinearLayout) viewInflate.findViewById(R.id.general_layout);
        LinearLayout linearLayout3 = (LinearLayout) viewInflate.findViewById(R.id.section_time);
        if (TextUtils.isEmpty(testBasic.getLang_id())) {
            checkBox = checkBox2;
        } else {
            checkBox = checkBox2;
            this.langIds = testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA);
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
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme2.23
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DashboardActivityTheme2 dashboardActivityTheme2 = DashboardActivityTheme2.this;
                    TextView textView9 = textView5;
                    TestBasicInst testBasicInst = testBasic;
                    TextView textView10 = textView8;
                    dashboardActivityTheme2.showPopMenuForLangauge(textView9, testBasicInst, textView10, textView10);
                }
            });
        }
        if (testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("1")) {
            textView5.setText(getResources().getStringArray(R.array.dialog_choose_language_array)[0]);
            this.lang = Integer.parseInt(testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
        } else if (testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("2")) {
            textView5.setText(getResources().getStringArray(R.array.dialog_choose_language_array)[1]);
            this.lang = Integer.parseInt(testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
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
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda42
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showPopUp$26(testBasic, checkBox3, dialog, view);
            }
        });
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme2.24
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialog2, int keyCode, KeyEvent event) {
                if (keyCode != 4) {
                    return true;
                }
                DashboardActivityTheme2.this.initialzehomepage();
                dialog.dismiss();
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPopUp$26(TestBasicInst testBasicInst, CheckBox checkBox, Dialog dialog, View view) {
        if (testBasicInst.getTotalQuestions().equalsIgnoreCase("0")) {
            Toast.makeText(this, "Please add Question.", 0).show();
        } else {
            if (checkBox.isChecked()) {
                dialog.dismiss();
                this.quiz_id = testBasicInst.getId();
                new NetworkCall(this, this).NetworkAPICall(API.API_GET_INFO_TEST_SERIES, "", true, false);
                return;
            }
            Toast.makeText(this, "Please check following instructions.", 0).show();
        }
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
        textView3.setText(!TextUtils.isEmpty(testSectionInst.getTotalNumOfAttempts()) ? testSectionInst.getTotalNumOfAttempts() : "");
        textView4.setText(testSectionInst.getSectionTiming());
        textView5.setText(String.valueOf(Float.parseFloat(testSectionInst.getMarksPerQuestion()) * Integer.parseInt(!TextUtils.isEmpty(testSectionInst.getTotalNumOfAttempts()) ? testSectionInst.getTotalNumOfAttempts() : testSectionInst.getTotalQuestions())));
        textView6.setText(testSectionInst.getMarksPerQuestion());
        textView7.setText("" + Float.parseFloat(testSectionInst.getNegativeMarks()));
        linearLayout.setTag(Integer.valueOf(tag));
        arrayList.add(linearLayout);
        return linearLayout;
    }

    public void showPopMenuForLangauge(final View v, final TestBasicInst testBasicInst, final TextView v1, TextView vvv) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme2.25
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem item) {
                ((TextView) v).setText(item.getTitle().toString());
                if (item.getTitle().toString().equals(DashboardActivityTheme2.this.getResources().getString(R.string.hindi))) {
                    DashboardActivityTheme2.this.lang = 2;
                    if (testBasicInst.getMulti_description().get(1).getDescription() != null) {
                        v1.setText(Html.fromHtml(testBasicInst.getMulti_description().get(1).getDescription()));
                    }
                } else if (item.getTitle().toString().equals(DashboardActivityTheme2.this.getResources().getString(R.string.english))) {
                    DashboardActivityTheme2.this.lang = 1;
                    v1.setText(Html.fromHtml(testBasicInst.getMulti_description().get(0).getDescription()));
                }
                return false;
            }
        });
        for (int i = 0; i < testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA).length; i++) {
            if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("1")) {
                popupMenu.getMenu().add(getResources().getStringArray(R.array.dialog_choose_language_array)[0]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("2")) {
                popupMenu.getMenu().add(getResources().getStringArray(R.array.dialog_choose_language_array)[1]);
            }
        }
        popupMenu.show();
    }

    private void inittest(Video video) {
        int i = this.notification_code;
        if (i == 125 || i == 90002) {
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
                    openWebPage(this, video.getFile_url());
                }
                if (video.getFile_type().equalsIgnoreCase("7")) {
                    Intent intent5 = new Intent(this, (Class<?>) Concept_newActivity.class);
                    intent5.putExtra("id", video.getId());
                    intent5.putExtra("name", video.getTitle());
                    if (this.parentid == null) {
                        this.parentid = "";
                    }
                    if (this.parentid.equalsIgnoreCase("")) {
                        intent5.putExtra("course_id", video.getPayloadData().getCourse_id() + MqttTopic.MULTI_LEVEL_WILDCARD);
                    } else {
                        intent5.putExtra("course_id", this.parentid + MqttTopic.MULTI_LEVEL_WILDCARD + video.getPayloadData().getCourse_id());
                    }
                    intent5.putExtra("tile_id", video.getPayloadData().getTile_id());
                    Helper.gotoActivity(intent5, this);
                    return;
                }
                if (video.getFile_type().equalsIgnoreCase("1")) {
                    if (!TextUtils.isEmpty(video.getIs_download_available()) && video.getIs_download_available().equalsIgnoreCase("1")) {
                        z = true;
                    }
                    Helper.GoToWebViewPDFActivity(this, video.getId(), video.getFile_url(), z, video.getTitle(), video.getPayloadData().getCourse_id() + MqttTopic.MULTI_LEVEL_WILDCARD + video.getPayloadData().getCourse_id(), video.getIs_share());
                    return;
                }
                return;
            }
            return;
        }
        if (video.getFile_type().equalsIgnoreCase("3")) {
            if (video.getIs_locked().equalsIgnoreCase("1")) {
                String str3 = this.parentid;
                if (str3 == null || str3.equalsIgnoreCase("")) {
                    Intent intent6 = new Intent(this, (Class<?>) CourseActivity.class);
                    intent6.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent6.putExtra(Const.COURSE_ID_MAIN, video.getPayloadData().getCourse_id());
                    intent6.putExtra(Const.COURSE_PARENT_ID, "");
                    intent6.putExtra(Const.IS_COMBO, false);
                    SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                    startActivity(intent6);
                    return;
                }
                Intent intent7 = new Intent(this, (Class<?>) CourseActivity.class);
                intent7.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                intent7.putExtra(Const.COURSE_ID_MAIN, this.parentid);
                intent7.putExtra(Const.COURSE_PARENT_ID, "");
                intent7.putExtra(Const.IS_COMBO, false);
                SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                startActivity(intent7);
                return;
            }
            if (video.getVideo_type().equalsIgnoreCase("7")) {
                if (video.getIs_drm().equals("0")) {
                    if (video.getId() == null || video.getId().equalsIgnoreCase("")) {
                        Toast.makeText(this, getResources().getString(R.string.url_is_not_found), 0).show();
                        initialzehomepage();
                        return;
                    } else {
                        Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), this, video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "", SingleStudy.parentCourseId, video.getStart_date(), new ArrayList());
                        return;
                    }
                }
                if (video.getIs_drm().equals("1")) {
                    if (video.getId() == null || video.getId().equalsIgnoreCase("")) {
                        Toast.makeText(this, getResources().getString(R.string.url_is_not_found), 0).show();
                        initialzehomepage();
                        return;
                    } else {
                        Helper.GoToVideoCryptActivity(this, video.getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), video.getVideo_type(), video.getChat_node(), video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "", SingleStudy.parentCourseId, video.getStart_date(), video.getIs_bookmarked(), new ArrayList());
                        return;
                    }
                }
                return;
            }
            if (video.getVideo_type().equalsIgnoreCase("8")) {
                if (video.getIs_drm().equals("0")) {
                    if (video.getLive_status().equalsIgnoreCase("1")) {
                        if (video.getId() == null || video.getId().equalsIgnoreCase("")) {
                            Toast.makeText(this, getResources().getString(R.string.url_is_not_found), 0).show();
                            initialzehomepage();
                            return;
                        } else {
                            Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), this, video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "", SingleStudy.parentCourseId, video.getStart_date(), new ArrayList());
                            return;
                        }
                    }
                    if (video.getLive_status().equalsIgnoreCase("0")) {
                        Toast.makeText(this, getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                        initialzehomepage();
                        return;
                    } else if (video.getLive_status().equalsIgnoreCase("2")) {
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
                if (video.getIs_drm().equals("1")) {
                    if (video.getLive_status().equalsIgnoreCase("1")) {
                        if (video.getId() == null || video.getId().equalsIgnoreCase("")) {
                            Toast.makeText(this, getResources().getString(R.string.url_is_not_found), 0).show();
                            initialzehomepage();
                            return;
                        } else {
                            Helper.GoToVideoCryptActivity(this, video.getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), video.getVideo_type(), video.getChat_node(), video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "", SingleStudy.parentCourseId, video.getStart_date(), video.getIs_bookmarked(), new ArrayList());
                            return;
                        }
                    }
                    if (video.getLive_status().equalsIgnoreCase("0")) {
                        Toast.makeText(this, getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                        initialzehomepage();
                        return;
                    } else if (video.getLive_status().equalsIgnoreCase("2")) {
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
                return;
            }
            if (video.getVideo_type().equalsIgnoreCase("9")) {
                if (video.getIs_locked().equalsIgnoreCase("0")) {
                    if (video.getLive_status().equalsIgnoreCase("1")) {
                        if (video.getZoom_meeting_id().equalsIgnoreCase("") || video.getZoom_meeting_passcode().equalsIgnoreCase("")) {
                            return;
                        }
                        if (!SharedPreference.getInstance().getString(Const.ZOOM_ACCESS_KEY).equalsIgnoreCase("")) {
                            ZoomFeatureHelper.launchZoomFeature(this, video.getZoom_meeting_id(), video.getZoom_meeting_passcode(), video.getZoom_sdk_token(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getName(), SharedPreference.getInstance().getLoggedInUser().getEmail(), SharedPreference.getInstance().getLoggedInUser().getMobile());
                            return;
                        } else {
                            Toast.makeText(this, "Zoom SDK key not found!", 0).show();
                            return;
                        }
                    }
                    if (video.getLive_status().equalsIgnoreCase("2")) {
                        if (!video.getFile_url().equalsIgnoreCase("") || !video.getFile_url().isEmpty()) {
                            Intent intent8 = new Intent(this, (Class<?>) ZoomRecodedPlayer.class);
                            intent8.putExtra("videoUrl", video.getFile_url());
                            intent8.putExtra(Const.VIDEO_ID, video.getId());
                            intent8.putExtra("bookmark", video.getIs_bookmarked());
                            startActivity(intent8);
                            return;
                        }
                        Toast.makeText(this, "No Video Found !", 0).show();
                        return;
                    }
                    Toast.makeText(this, "Zoom class is not yet started.", 0).show();
                    return;
                }
                return;
            }
            if (video.getVideo_type().equalsIgnoreCase("5")) {
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
                if (video.getLive_status().equalsIgnoreCase("0")) {
                    Toast.makeText(this, getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                    initialzehomepage();
                    return;
                }
                if (video.getLive_status().equalsIgnoreCase("1")) {
                    Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), this, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "", this.parentid, video.getStart_date(), new ArrayList());
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
                if (video.getIs_locked().equalsIgnoreCase("1")) {
                    String str5 = this.parentid;
                    if (str5 == null || str5.equalsIgnoreCase("")) {
                        Intent intent11 = new Intent(this, (Class<?>) CourseActivity.class);
                        intent11.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                        intent11.putExtra(Const.COURSE_ID_MAIN, video.getPayloadData().getCourse_id());
                        intent11.putExtra(Const.COURSE_PARENT_ID, "");
                        intent11.putExtra(Const.IS_COMBO, false);
                        SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                        startActivity(intent11);
                        return;
                    }
                    Intent intent12 = new Intent(this, (Class<?>) CourseActivity.class);
                    intent12.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent12.putExtra(Const.COURSE_ID_MAIN, this.parentid);
                    intent12.putExtra(Const.COURSE_PARENT_ID, "");
                    intent12.putExtra(Const.IS_COMBO, false);
                    SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                    startActivity(intent12);
                    return;
                }
                Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), this, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "", this.parentid, video.getStart_date(), new ArrayList());
                return;
            }
            if (video.getIs_locked().equalsIgnoreCase("1")) {
                String str6 = this.parentid;
                if (str6 == null || str6.equalsIgnoreCase("")) {
                    Intent intent13 = new Intent(this, (Class<?>) CourseActivity.class);
                    intent13.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent13.putExtra(Const.COURSE_ID_MAIN, video.getPayloadData().getCourse_id());
                    intent13.putExtra(Const.COURSE_PARENT_ID, "");
                    intent13.putExtra(Const.IS_COMBO, false);
                    SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                    startActivity(intent13);
                    return;
                }
                Intent intent14 = new Intent(this, (Class<?>) CourseActivity.class);
                intent14.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                intent14.putExtra(Const.COURSE_ID_MAIN, this.parentid);
                intent14.putExtra(Const.COURSE_PARENT_ID, "");
                intent14.putExtra(Const.IS_COMBO, false);
                SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                startActivity(intent14);
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
                        Helper.GoToLiveVideoActivity(video.getChat_node(), this, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getIs_chat_lock(), video.getPayloadData().getCourse_id(), "", this.parentid, video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), new ArrayList());
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
                if (video.getVideo_type().equalsIgnoreCase("1")) {
                    Helper.GoToLiveVideoActivity(video.getChat_node(), this, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getIs_chat_lock(), video.getPayloadData().getCourse_id(), "", this.parentid, video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), new ArrayList());
                    return;
                }
                return;
            }
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + video.getFile_url())));
            return;
        }
        if (!video.getFile_type().equalsIgnoreCase("7") && TextUtils.isEmpty(video.getFile_url())) {
            Toast.makeText(this, getResources().getString(R.string.no_pdf_found), 0).show();
            initialzehomepage();
            return;
        }
        if (video.getFile_type().equalsIgnoreCase("8")) {
            openWebPage(this, video.getFile_url());
        }
        if (video.getFile_type().equalsIgnoreCase("7")) {
            Intent intent15 = new Intent(this, (Class<?>) Concept_newActivity.class);
            intent15.putExtra("id", video.getId());
            intent15.putExtra("name", video.getTitle());
            if (this.parentid == null) {
                this.parentid = "";
            }
            if (this.parentid.equalsIgnoreCase("")) {
                intent15.putExtra("course_id", video.getPayloadData().getCourse_id() + MqttTopic.MULTI_LEVEL_WILDCARD);
            } else {
                intent15.putExtra("course_id", this.parentid + MqttTopic.MULTI_LEVEL_WILDCARD + video.getPayloadData().getCourse_id());
            }
            intent15.putExtra("tile_id", video.getPayloadData().getTile_id());
            Helper.gotoActivity(intent15, this);
            return;
        }
        if (video.getFile_type().equalsIgnoreCase("1")) {
            if (!TextUtils.isEmpty(video.getIs_download_available()) && video.getIs_download_available().equalsIgnoreCase("1")) {
                z = true;
            }
            Helper.GoToWebViewPDFActivity(this, video.getId(), video.getFile_url(), z, video.getTitle(), video.getPayloadData().getCourse_id(), video.getIs_share());
        }
    }

    private void manageVisibility() {
        this.viewPagerRL.setVisibility(8);
        this.bottomViewPagerRL.setVisibility(8);
        if (this.bottomSetting.getTop_layout() != null && this.bottomSetting.getTop_layout().equalsIgnoreCase("1")) {
            this.ll_top.setVisibility(0);
        } else {
            this.ll_top.setVisibility(8);
        }
        if (this.bottomSetting.getTop_banner() != null && this.bottomSetting.getTop_banner().equalsIgnoreCase("1")) {
            this.viewPagerRL.setVisibility(0);
        } else {
            this.viewPagerRL.setVisibility(8);
        }
        if (this.bottomSetting.getBottom_banner() != null && this.bottomSetting.getBottom_banner().equalsIgnoreCase("1")) {
            this.bottomViewPagerRL.setVisibility(0);
        } else {
            this.bottomViewPagerRL.setVisibility(8);
        }
        manageSliders();
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
        if (apitype.equalsIgnoreCase(API.master_content)) {
            this.hitMaster = true;
        }
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
        List<CourseDataTable> list3;
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
                        this.allsubcatindex_id = next.getId();
                        this.filterTwo.setText(item.getTitle());
                        if (this.cardsArrayList.size() > 0) {
                            getTileItems(this.cardsArrayList, 0);
                        }
                        if (!this.utkashRoom.getHomeApiStatusdata().isRecordExistsUserId(MakeMyExam.userId, this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id) || this.utkashRoom.getHomeApiStatusdata().getcoursedetail(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id, MakeMyExam.getUserId()).getStatus().equalsIgnoreCase("true")) {
                            getCourseData(true);
                        } else {
                            this.courselists.clear();
                            if (this.contentType_id.equalsIgnoreCase("0")) {
                                list3 = this.utkashRoom.getCoursedata().getcoursedata(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId);
                            } else {
                                list3 = this.utkashRoom.getCoursedata().getcoursedatawithfilter(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId, this.contentType_id);
                            }
                            for (CourseDataTable courseDataTable : list3) {
                                this.courselists.add(new Courselist(courseDataTable.getCourse_id(), courseDataTable.getTitle(), courseDataTable.getCover_image(), courseDataTable.getMrp(), courseDataTable.getCourse_sp(), courseDataTable.getValidity(), courseDataTable.getSubject_id(), courseDataTable.getSubject_id(), courseDataTable.getDesc_header_image(), courseDataTable.getExtra_json(), courseDataTable.getAvg_rating(), courseDataTable.getUser_rated(), courseDataTable.getIs_purchased(), courseDataTable.getCombo_course_ids(), "", courseDataTable.getCat_type(), courseDataTable.getHide_validity(), courseDataTable.getDescription(), courseDataTable.getDiscount(), courseDataTable.getDelivery_charge(), courseDataTable.getBook_redirection_link(), courseDataTable.getPayment_mode()));
                            }
                            if (this.courselists.size() > 0) {
                                this.courseListRV.setVisibility(0);
                                this.no_data_found_RL.setVisibility(8);
                            } else {
                                this.courseListRV.setVisibility(8);
                                this.no_data_found_RL.setVisibility(0);
                            }
                            TileDataAdapter tileDataAdapter = new TileDataAdapter(this, this.courselists, "", this, this);
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
                            this.allsubcatindex_id = this.selectedsub_all_cat.get(0).getId();
                            this.filterTwo.setText(this.selectedsub_all_cat.get(0).getName());
                            this.courseListRV.setVisibility(0);
                            this.no_data_found_RL.setVisibility(8);
                            if (!this.utkashRoom.getHomeApiStatusdata().isRecordExistsUserId(MakeMyExam.userId, this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id) || this.utkashRoom.getHomeApiStatusdata().getcoursedetail(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id, MakeMyExam.getUserId()).getStatus().equalsIgnoreCase("true")) {
                                getCourseData(true);
                            } else {
                                this.courselists.clear();
                                if (this.contentType_id.equalsIgnoreCase("0")) {
                                    list2 = this.utkashRoom.getCoursedata().getcoursedata(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId);
                                } else {
                                    list2 = this.utkashRoom.getCoursedata().getcoursedatawithfilter(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId, this.contentType_id);
                                }
                                for (CourseDataTable courseDataTable2 : list2) {
                                    this.courselists.add(new Courselist(courseDataTable2.getCourse_id(), courseDataTable2.getTitle(), courseDataTable2.getCover_image(), courseDataTable2.getMrp(), courseDataTable2.getCourse_sp(), courseDataTable2.getValidity(), courseDataTable2.getSubject_id(), courseDataTable2.getLang_id(), courseDataTable2.getDesc_header_image(), courseDataTable2.getExtra_json(), courseDataTable2.getAvg_rating(), courseDataTable2.getUser_rated(), courseDataTable2.getIs_purchased(), courseDataTable2.getCombo_course_ids(), "", courseDataTable2.getCat_type(), courseDataTable2.getHide_validity(), courseDataTable2.getDescription(), courseDataTable2.getDiscount(), courseDataTable2.getDelivery_charge(), courseDataTable2.getBook_redirection_link(), courseDataTable2.getPayment_mode()));
                                }
                                if (this.courselists.size() > 0) {
                                    this.courseListRV.setVisibility(0);
                                    this.no_data_found_RL.setVisibility(8);
                                } else {
                                    this.courseListRV.setVisibility(8);
                                    this.no_data_found_RL.setVisibility(0);
                                }
                                TileDataAdapter tileDataAdapter2 = new TileDataAdapter(this, this.courselists, "", this, this);
                                this.tileDataAdapter = tileDataAdapter2;
                                this.courseListRV.setAdapter(tileDataAdapter2);
                                this.courseListRV.setNestedScrollingEnabled(false);
                            }
                        } else {
                            this.courseListRV.setVisibility(8);
                            this.no_data_found_RL.setVisibility(0);
                            this.allsubcatindex = "";
                            this.allsubcatindex_id = "";
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
                    this.launguagespinner.setText("Select language");
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
            Iterator<MasterCat> it5 = this.mastercatlist.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                MasterCat next5 = it5.next();
                if (next5.getCat().equals(item.getTitle())) {
                    this.mastercatname = item.getTitle().toString();
                    this.mastercatid = next5.getId();
                    this.toolbartitleTV.setText(item.getTitle());
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
                    this.allsubcatindex_id = "";
                    this.pagecount = 1;
                    this.selectedsub_all_cat.clear();
                    this.selected_master_cat.clear();
                    for (MasteAllCatTable masteAllCatTable2 : this.masterAllCatTables) {
                        if (masteAllCatTable2.getMaster_type().equals(this.mastercatid) && masteAllCatTable2.getParent_id().equalsIgnoreCase("0")) {
                            this.selected_master_cat.add(masteAllCatTable2);
                        }
                    }
                    if (this.selected_master_cat.size() > 0) {
                        this.allcatindex = this.selected_master_cat.get(0).getName();
                        this.allcatindex_id = this.selected_master_cat.get(0).getId();
                        this.filterOne.setText(this.selected_master_cat.get(0).getName());
                        for (MasteAllCatTable masteAllCatTable3 : this.masterAllCatTables) {
                            if (this.allcatindex_id.equalsIgnoreCase(masteAllCatTable3.getParent_id())) {
                                this.selectedsub_all_cat.add(masteAllCatTable3);
                            }
                        }
                        if (this.selectedsub_all_cat.size() > 0) {
                            this.allsubcatindex = this.selectedsub_all_cat.get(0).getName();
                            this.allsubcatindex_id = this.selectedsub_all_cat.get(0).getId();
                            this.filterTwo.setText(this.allsubcatindex);
                            this.courseListRV.setVisibility(0);
                            this.no_data_found_RL.setVisibility(8);
                            this.pagecount = 1;
                            if (!this.utkashRoom.getHomeApiStatusdata().isRecordExistsUserId(MakeMyExam.userId, this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id) || this.utkashRoom.getHomeApiStatusdata().getcoursedetail(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id, MakeMyExam.getUserId()).getStatus().equalsIgnoreCase("true")) {
                                getCourseData(true);
                            } else {
                                this.courselists.clear();
                                if (this.contentType_id.equalsIgnoreCase("0")) {
                                    list = this.utkashRoom.getCoursedata().getcoursedata(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId);
                                } else {
                                    list = this.utkashRoom.getCoursedata().getcoursedatawithfilter(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId, this.contentType_id);
                                }
                                for (CourseDataTable courseDataTable3 : list) {
                                    this.courselists.add(new Courselist(courseDataTable3.getCourse_id(), courseDataTable3.getTitle(), courseDataTable3.getCover_image(), courseDataTable3.getMrp(), courseDataTable3.getCourse_sp(), courseDataTable3.getValidity(), courseDataTable3.getSubject_id(), courseDataTable3.getLang_id(), courseDataTable3.getDesc_header_image(), courseDataTable3.getExtra_json(), courseDataTable3.getAvg_rating(), courseDataTable3.getUser_rated(), courseDataTable3.getIs_purchased(), courseDataTable3.getCombo_course_ids(), "", courseDataTable3.getCat_type(), courseDataTable3.getHide_validity(), courseDataTable3.getDescription(), courseDataTable3.getDiscount(), courseDataTable3.getDelivery_charge(), courseDataTable3.getBook_redirection_link(), courseDataTable3.getPayment_mode()));
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
                                TileDataAdapter tileDataAdapter3 = new TileDataAdapter(this, this.courselists, "", this, this);
                                this.tileDataAdapter = tileDataAdapter3;
                                this.courseListRV.setAdapter(tileDataAdapter3);
                                this.courseListRV.setNestedScrollingEnabled(false);
                            }
                        } else {
                            this.courseListRV.setVisibility(8);
                            this.no_data_found_RL.setVisibility(0);
                            this.allsubcatindex_id = "";
                            this.allsubcatindex = "";
                            this.filterTwo.setText("");
                        }
                    } else {
                        this.allcatindex = "";
                        this.allcatindex_id = "";
                        this.filterOne.setText("");
                    }
                }
            }
        }
        return false;
    }

    private void refreshApiFromDownloads() {
        if (Helper.isConnected(this)) {
            new NetworkCall(this, this).NetworkAPICall(API.master_content, "", true, false);
        }
    }

    private void selecteddata() {
        if (this.mastercatlist.size() > 0) {
            if (!this.pullrefresh) {
                this.mastercatname = this.mastercatlist.get(0).getCat();
                this.mastercatid = this.mastercatlist.get(0).getId();
                this.toolbartitleTV.setText(this.mastercatlist.get(0).getCat());
                this.selected_master_cat.clear();
                this.selectedsub_all_cat.clear();
            }
            for (MasteAllCatTable masteAllCatTable : this.masterAllCatTables) {
                if (masteAllCatTable.getMaster_type().equals(this.mastercatid) && masteAllCatTable.getParent_id().equalsIgnoreCase("0")) {
                    this.selected_master_cat.add(masteAllCatTable);
                }
            }
            if (this.selected_master_cat.size() > 0) {
                if (this.selected_master_cat.get(0).getApp_hide() != null && this.selected_master_cat.get(0).getApp_hide().equals("1")) {
                    this.binding.dashBoardMain.llTopTwo.setVisibility(8);
                    this.binding.dashBoardMain.downarrowIV.setVisibility(8);
                    this.binding.dashBoardMain.filterOneClick.setClickable(false);
                    this.binding.dashBoardMain.downarrowIV.setClickable(false);
                    this.binding.dashBoardMain.titleinnerRL.setClickable(false);
                    List<CourseTypeMasterTable> list = this.courseTypeMasterTables;
                    if (list != null && list.size() > 0 && this.courseTypeMasterTables.get(0).getName() != null) {
                        this.binding.dashBoardMain.toolbartitleTV.setText(this.courseTypeMasterTables.get(0).getName());
                    }
                } else if ("1".equalsIgnoreCase("7")) {
                    this.binding.dashBoardMain.llTopTwo.setVisibility(8);
                    this.binding.dashBoardMain.downarrowIV.setVisibility(8);
                    this.binding.dashBoardMain.filterOneClick.setClickable(false);
                } else {
                    this.binding.dashBoardMain.llTopTwo.setVisibility(0);
                    if (BuildConfig.FLAVOR.equalsIgnoreCase("onlineSkillIndia")) {
                        this.binding.dashBoardMain.downarrowIV.setVisibility(8);
                    } else {
                        this.binding.dashBoardMain.downarrowIV.setVisibility(0);
                    }
                }
                if (!this.pullrefresh) {
                    this.allcatindex = this.selected_master_cat.get(0).getName();
                    this.allcatindex_id = this.selected_master_cat.get(0).getId();
                    this.filterOne.setText(this.selected_master_cat.get(0).getName());
                }
                for (MasteAllCatTable masteAllCatTable2 : this.masterAllCatTables) {
                    if (this.allcatindex_id.equalsIgnoreCase(masteAllCatTable2.getParent_id())) {
                        this.selectedsub_all_cat.add(masteAllCatTable2);
                    }
                }
                if (this.selectedsub_all_cat.size() > 0) {
                    if (!this.pullrefresh) {
                        this.allsubcatindex = this.selectedsub_all_cat.get(0).getName();
                        this.allsubcatindex_id = this.selectedsub_all_cat.get(0).getId();
                    }
                    this.filterTwo.setText(this.allsubcatindex);
                    this.courseListRV.setVisibility(0);
                    this.no_data_found_RL.setVisibility(8);
                    this.subjectindex = "";
                    this.launguageindex = "";
                    this.filterdata = new Filterdata();
                    Data data = new Data();
                    new ArrayList();
                    if (this.utkashRoom == null) {
                        this.utkashRoom = UtkashRoom.getAppDatabase(this);
                    }
                    String str = this.utkashRoom.getMasterAllCatDao().getfilteddata(this.allsubcatindex_id);
                    this.LanguagesTable = this.utkashRoom.getLaunguages().getLaunguagedetail();
                    data.setSubjects((List) new Gson().fromJson(str, new TypeToken<List<Subject>>() { // from class: com.appnew.android.Theme.DashboardActivityTheme2.26
                    }.getType()));
                    data.setLanguages(this.LanguagesTable);
                    this.filterdata.setData(data);
                    if (!this.utkashRoom.getHomeApiStatusdata().isRecordExistsUserId(MakeMyExam.userId, this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id) || this.utkashRoom.getHomeApiStatusdata().getcoursedetail(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id, MakeMyExam.getUserId()).getStatus().equalsIgnoreCase("true")) {
                        getCourseData(true);
                    } else {
                        this.courselists.clear();
                        this.courseDataTables.clear();
                        if (this.contentType_id.equalsIgnoreCase("0")) {
                            try {
                                this.courseDataTables = this.utkashRoom.getCoursedata().getcoursedata(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId);
                                setdata();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        } else {
                            try {
                                this.courseDataTables = this.utkashRoom.getCoursedata().getcoursedatawithfilter(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId, this.contentType_id);
                                setdata();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                } else {
                    this.courseListRV.setVisibility(8);
                    this.no_data_found_RL.setVisibility(0);
                    this.filterTwo.setText("");
                    this.allsubcatindex = "";
                    this.allsubcatindex_id = "";
                }
            } else {
                this.allcatindex = "";
                this.allcatindex_id = "";
                this.filterOne.setText("");
                this.filterTwo.setText("");
                this.allsubcatindex = "";
                this.allsubcatindex_id = "";
            }
        }
        if (this.utkashRoom.getthemeSettingdao().is_setting_exit()) {
            this.bottomSetting = (BottomSetting) new Gson().fromJson(this.utkashRoom.getthemeSettingdao().data().getBottom(), BottomSetting.class);
            this.bottomLL.removeAllViews();
            ArrayList<View> arrayList = this.viewArrayList;
            if (arrayList != null) {
                arrayList.clear();
            }
            for (int i = 0; i < Helper.getBottomMenu(this.bottomMenuTables).size(); i++) {
                this.bottomLL.addView(initBottomView(Helper.getBottomMenu(this.bottomMenuTables).get(i)));
            }
        }
        manageVisibility();
        createMenus();
        this.pullrefresh = false;
    }

    private void setdata() {
        for (CourseDataTable courseDataTable : this.courseDataTables) {
            this.courselists.add(new Courselist(courseDataTable.getCourse_id(), courseDataTable.getTitle(), courseDataTable.getCover_image(), courseDataTable.getMrp(), courseDataTable.getCourse_sp(), courseDataTable.getValidity(), courseDataTable.getSubject_id(), courseDataTable.getLang_id(), courseDataTable.getDesc_header_image(), courseDataTable.getExtra_json(), courseDataTable.getAvg_rating(), courseDataTable.getUser_rated(), courseDataTable.getIs_purchased(), courseDataTable.getCombo_course_ids(), "", courseDataTable.getCat_type(), courseDataTable.getHide_validity(), courseDataTable.getDescription(), courseDataTable.getDiscount(), courseDataTable.getDelivery_charge(), courseDataTable.getBook_redirection_link(), courseDataTable.getPayment_mode()));
        }
        if (this.courselists.size() > 0) {
            this.courseListRV.setVisibility(0);
            this.no_data_found_RL.setVisibility(8);
        } else {
            this.courseListRV.setVisibility(8);
            this.no_data_found_RL.setVisibility(0);
        }
        TileDataAdapter tileDataAdapter = new TileDataAdapter(this, this.courselists, "", this, this);
        this.tileDataAdapter = tileDataAdapter;
        this.courseListRV.setAdapter(tileDataAdapter);
        this.courseListRV.setNestedScrollingEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getCourseData(boolean showProgress) {
        this.networkCall.NetworkAPICall(API.get_courses, "", showProgress, false);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.backstatus) {
            if (this.backPressed + 3000 > System.currentTimeMillis()) {
                getIntent().setData(null);
                finishAndRemoveTask();
            } else {
                this.backPressed = System.currentTimeMillis();
                Helper.showSnackBar(this.drawer, getString(R.string.press_again_to_exit));
            }
        } else if (this.fragment instanceof Chatboot) {
            this.backstatus = true;
            this.forchatbot.setVisibility(8);
        } else if (this.backPressed + 3000 > System.currentTimeMillis()) {
            getIntent().setData(null);
            finishAndRemoveTask();
        } else {
            this.backPressed = System.currentTimeMillis();
            Helper.showSnackBar(this.drawer, getString(R.string.press_again_to_exit));
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
                        gradientDrawable.setColor(Color.parseColor(com.clevertap.android.sdk.Constants.BLACK));
                        gradientDrawable.setCornerRadius(60.0f);
                        linearLayout2.setBackground(gradientDrawable);
                        textView2.setTextColor(-1);
                        linearLayout3.setBackground(context.getResources().getDrawable(R.drawable.bg_tile_unselected));
                        textView5.setTextColor(context.getResources().getColor(R.color.country_code_text_color));
                        linearLayout.setBackground(context.getResources().getDrawable(R.drawable.bg_tile_unselected));
                        textView.setTextColor(context.getResources().getColor(R.color.country_code_text_color));
                    } else if (this.is_paid.equalsIgnoreCase("")) {
                        this.is_paid = "";
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        gradientDrawable2.setColor(Color.parseColor(com.clevertap.android.sdk.Constants.BLACK));
                        gradientDrawable2.setCornerRadius(60.0f);
                        linearLayout3.setBackground(gradientDrawable2);
                        textView5.setTextColor(-1);
                        linearLayout2.setBackground(context.getResources().getDrawable(R.drawable.bg_tile_unselected));
                        textView2.setTextColor(context.getResources().getColor(R.color.country_code_text_color));
                        linearLayout.setBackground(context.getResources().getDrawable(R.drawable.bg_tile_unselected));
                        textView.setTextColor(context.getResources().getColor(R.color.country_code_text_color));
                    }
                } else {
                    GradientDrawable gradientDrawable3 = new GradientDrawable();
                    gradientDrawable3.setColor(Color.parseColor(com.clevertap.android.sdk.Constants.BLACK));
                    gradientDrawable3.setCornerRadius(60.0f);
                    linearLayout.setBackground(gradientDrawable3);
                    textView.setTextColor(-1);
                    linearLayout3.setBackground(context.getResources().getDrawable(R.drawable.bg_tile_unselected));
                    textView5.setTextColor(context.getResources().getColor(R.color.country_code_text_color));
                    linearLayout2.setBackground(context.getResources().getDrawable(R.drawable.bg_tile_unselected));
                    textView2.setTextColor(context.getResources().getColor(R.color.country_code_text_color));
                }
            }
            try {
                linearLayout3.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$openwatchlist_dailog_resource$27(linearLayout3, textView5, linearLayout2, context, textView2, linearLayout, textView);
                    }
                }));
                linearLayout.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda33
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$openwatchlist_dailog_resource$28(linearLayout, textView, linearLayout2, context, textView2, linearLayout3, textView5);
                    }
                }));
                linearLayout2.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda39
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$openwatchlist_dailog_resource$29(linearLayout2, textView2, linearLayout3, context, textView5, linearLayout, textView);
                    }
                }));
                button.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda40
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$openwatchlist_dailog_resource$30(context);
                    }
                }));
                relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme2.27
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        DashboardActivityTheme2.this.clicktype = "4";
                        PopupMenu popupMenu = new PopupMenu(context, DashboardActivityTheme2.this.launguagespinner, 3);
                        popupMenu.getMenu().add("Select language");
                        for (int i = 0; i < languages.size(); i++) {
                            popupMenu.getMenu().add(((LanguagesTable) languages.get(i)).getLanguage());
                        }
                        popupMenu.setOnMenuItemClickListener(DashboardActivityTheme2.this);
                        popupMenu.show();
                    }
                });
                this.launguagespinner.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme2.28
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        DashboardActivityTheme2.this.clicktype = "4";
                        PopupMenu popupMenu = new PopupMenu(context, DashboardActivityTheme2.this.launguagespinner, 3);
                        popupMenu.getMenu().add("Select language");
                        for (int i = 0; i < languages.size(); i++) {
                            popupMenu.getMenu().add(((LanguagesTable) languages.get(i)).getLanguage());
                        }
                        popupMenu.setOnMenuItemClickListener(DashboardActivityTheme2.this);
                        popupMenu.show();
                    }
                });
                relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme2.29
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        DashboardActivityTheme2.this.clicktype = "5";
                        PopupMenu popupMenu = new PopupMenu(context, DashboardActivityTheme2.this.subjectspinner, 3);
                        popupMenu.getMenu().add("Select subject");
                        for (int i = 0; i < subjects.size(); i++) {
                            popupMenu.getMenu().add(((Subject) subjects.get(i)).getTitle());
                        }
                        popupMenu.setOnMenuItemClickListener(DashboardActivityTheme2.this);
                        popupMenu.show();
                    }
                });
                this.subjectspinner.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme2.30
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        DashboardActivityTheme2.this.clicktype = "5";
                        PopupMenu popupMenu = new PopupMenu(context, DashboardActivityTheme2.this.subjectspinner, 3);
                        popupMenu.getMenu().add("Select subject");
                        for (int i = 0; i < subjects.size(); i++) {
                            popupMenu.getMenu().add(((Subject) subjects.get(i)).getTitle());
                        }
                        popupMenu.setOnMenuItemClickListener(DashboardActivityTheme2.this);
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
    public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$27(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, Context context, TextView textView2, LinearLayout linearLayout3, TextView textView3) {
        this.is_paid = "";
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(com.clevertap.android.sdk.Constants.BLACK));
        gradientDrawable.setCornerRadius(60.0f);
        linearLayout.setBackground(gradientDrawable);
        textView.setTextColor(-1);
        linearLayout2.setBackground(context.getResources().getDrawable(R.drawable.bg_tile_unselected));
        textView2.setTextColor(context.getResources().getColor(R.color.country_code_text_color));
        linearLayout3.setBackground(context.getResources().getDrawable(R.drawable.bg_tile_unselected));
        textView3.setTextColor(context.getResources().getColor(R.color.country_code_text_color));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$28(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, Context context, TextView textView2, LinearLayout linearLayout3, TextView textView3) {
        this.is_paid = "0";
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(com.clevertap.android.sdk.Constants.BLACK));
        gradientDrawable.setCornerRadius(60.0f);
        linearLayout.setBackground(gradientDrawable);
        textView.setTextColor(-1);
        linearLayout2.setBackground(context.getResources().getDrawable(R.drawable.bg_tile_unselected));
        textView2.setTextColor(context.getResources().getColor(R.color.country_code_text_color));
        linearLayout3.setBackground(context.getResources().getDrawable(R.drawable.bg_tile_unselected));
        textView3.setTextColor(context.getResources().getColor(R.color.country_code_text_color));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$29(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, Context context, TextView textView2, LinearLayout linearLayout3, TextView textView3) {
        this.is_paid = "1";
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(com.clevertap.android.sdk.Constants.BLACK));
        gradientDrawable.setCornerRadius(60.0f);
        linearLayout.setBackground(gradientDrawable);
        textView.setTextColor(-1);
        linearLayout2.setBackground(context.getResources().getDrawable(R.drawable.bg_tile_unselected));
        textView2.setTextColor(context.getResources().getColor(R.color.country_code_text_color));
        linearLayout3.setBackground(context.getResources().getDrawable(R.drawable.bg_tile_unselected));
        textView3.setTextColor(context.getResources().getColor(R.color.country_code_text_color));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$30(Context context) {
        String str;
        if (this.SelectedSubjectid.equalsIgnoreCase("") && this.SelectedLaunguageid.equalsIgnoreCase("") && this.is_paid == null) {
            Toast.makeText(context, "Please select filter first", 0).show();
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
                    this.courselists.add(new Courselist(courseDataTable.getCourse_id(), courseDataTable.getTitle(), courseDataTable.getCover_image(), courseDataTable.getMrp(), courseDataTable.getCourse_sp(), courseDataTable.getValidity(), courseDataTable.getSubject_id(), courseDataTable.getLang_id(), courseDataTable.getDesc_header_image(), courseDataTable.getExtra_json(), courseDataTable.getAvg_rating(), courseDataTable.getUser_rated(), courseDataTable.getIs_purchased(), courseDataTable.getCombo_course_ids(), "", courseDataTable.getCat_type(), courseDataTable.getHide_validity(), courseDataTable.getDescription(), courseDataTable.getDiscount(), courseDataTable.getDelivery_charge(), courseDataTable.getBook_redirection_link(), courseDataTable.getPayment_mode()));
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
                TileDataAdapter tileDataAdapter = new TileDataAdapter(this, this.courselists, "", this, this);
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

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        try {
            try {
                if (this.notification_code != 0) {
                    Constants.REFRESHPAGE = "";
                    if (Helper.isNetworkConnected(this)) {
                        if (this.utkashRoom.getMasterAllCatDao().isRecordExistsUserId(MakeMyExam.userId)) {
                            this.courseTypeMasterTables.clear();
                            this.masterAllCatTables.clear();
                            this.mastercatlist.clear();
                            this.bannerListTables.clear();
                            this.bottomMenuTables.clear();
                            if (!this.utkashRoom.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread()) {
                                this.courseTypeMasterTables = this.utkashRoom.getcoursetypemaster().getcourse_typemaster(MakeMyExam.userId);
                                this.masterAllCatTables = this.utkashRoom.getMasterAllCatDao().getmaster_allcat(MakeMyExam.userId);
                                this.mastercatlist = this.utkashRoom.getMastercatDao().getmastercat(MakeMyExam.userId);
                                this.bannerListTables = this.utkashRoom.getBannerTableDao().getBanner(MakeMyExam.getUserId());
                                this.bottomMenuTables = this.utkashRoom.getBottomMenuTableDao().getBottomMenu(MakeMyExam.getUserId());
                            }
                            runOnUiThread(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda41
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$onRestart$31();
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
            if (this.utkashRoom.getHomeApiStatusdata().isRecordExistsUserId(MakeMyExam.userId, this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id)) {
                return;
            }
            getCourseData(true);
        } catch (Throwable th) {
            this.notification_code = 0;
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onRestart$31() {
        this.cardsArrayList.clear();
        for (CourseTypeMasterTable courseTypeMasterTable : this.courseTypeMasterTables) {
            this.cardsArrayList.add(new Cards(courseTypeMasterTable.getId(), courseTypeMasterTable.getName(), com.clevertap.android.sdk.Constants.BLACK, courseTypeMasterTable.getName(), "0#0#0#0#0#0", "0"));
        }
        if (this.cardsArrayList.size() > 0) {
            getTileItems(this.cardsArrayList, 0);
        }
        selecteddata();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<BannerListTable> list = this.bannerListTables;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (BannerListTable bannerListTable : this.bannerListTables) {
            if (bannerListTable.getBanner_location().equalsIgnoreCase("0")) {
                arrayList.add(bannerListTable);
            }
            if (bannerListTable.getBanner_location().equalsIgnoreCase("5")) {
                arrayList.add(bannerListTable);
            }
            if (bannerListTable.getBanner_location().equalsIgnoreCase("1")) {
                arrayList2.add(bannerListTable);
            }
        }
        if (arrayList.size() > 0) {
            this.binding.dashBoardMain.bannerSliderLayout.viewPager2.setAdapter(new SliderAdapter(this, arrayList, new DashboardActivityTheme2$$ExternalSyntheticLambda9(this)));
            Utils.INSTANCE.setUpViewPager(this.binding.dashBoardMain.bannerSliderLayout.viewPager2, this.binding.dashBoardMain.bannerSliderLayout.bannerIndicator, arrayList);
        } else {
            this.viewPagerRL.setVisibility(8);
        }
        if (arrayList2.size() > 0) {
            this.binding.dashBoardMain.bottomSliderLayout.viewPager2.setAdapter(new BottomSliderAdapter(this, arrayList2, new DashboardActivityTheme2$$ExternalSyntheticLambda10(this)));
            Utils.INSTANCE.setUpViewPager(this.binding.dashBoardMain.bottomSliderLayout.viewPager2, this.binding.dashBoardMain.bottomSliderLayout.bannerIndicator, arrayList2);
            return;
        }
        this.bottomViewPagerRL.setVisibility(8);
    }

    public void homeAutoRefresh() {
        if (SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT) == 0) {
            ShortcutBadger.applyCount(getApplicationContext(), SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT));
            ((LinearLayout) Objects.requireNonNull(((AppBarHomeTheme2Binding) Objects.requireNonNull(this.binding.dashBoardMain)).cvrNotificationCount1)).setBackgroundResource(R.drawable.uncircle_notification_count);
            runOnUiThread(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme2.31
                @Override // java.lang.Runnable
                public void run() {
                    DashboardActivityTheme2.this.binding.dashBoardMain.notificaionCount1.setText(String.valueOf(SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT)));
                }
            });
            this.binding.dashBoardMain.cvrNotificationCount1.setVisibility(8);
            return;
        }
        runOnUiThread(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme2.32
            @Override // java.lang.Runnable
            public void run() {
                ((AppBarHomeTheme2Binding) Objects.requireNonNull(DashboardActivityTheme2.this.binding.dashBoardMain)).cvrNotificationCount1.setVisibility(0);
                ShortcutBadger.applyCount(DashboardActivityTheme2.this.getApplicationContext(), SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT));
                DashboardActivityTheme2.this.binding.dashBoardMain.cvrNotificationCount1.setBackgroundResource(R.drawable.circle_notification_count);
                if (SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT) > 99) {
                    DashboardActivityTheme2.this.binding.dashBoardMain.notificaionCount1.setText(DashboardActivityTheme2.this.getResources().getString(R.string.nine_nine));
                } else if (SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT) > 0) {
                    DashboardActivityTheme2.this.binding.dashBoardMain.notificaionCount1.setText(String.valueOf(SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT)));
                } else {
                    DashboardActivityTheme2.this.binding.dashBoardMain.cvrNotificationCount1.setVisibility(8);
                }
            }
        });
    }

    public void UserLogout() {
        this.networkCall.NetworkAPICall(API.user_logout, "", true, false);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.utkashRoom = null;
        AppUpdateManager appUpdateManager = this.mAppUpdateManager;
        if (appUpdateManager != null) {
            appUpdateManager.unregisterListener(this.installStateUpdatedListener);
        }
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.workTimer);
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
                    this.bannerListTables.clear();
                    this.bottomMenuTables.clear();
                    try {
                        if (!this.utkashRoom.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread()) {
                            this.courseTypeMasterTables = this.utkashRoom.getcoursetypemaster().getcourse_typemaster(MakeMyExam.userId);
                            this.masterAllCatTables = this.utkashRoom.getMasterAllCatDao().getmaster_allcat(MakeMyExam.userId);
                            this.mastercatlist = this.utkashRoom.getMastercatDao().getmastercat(MakeMyExam.userId);
                            this.bannerListTables = this.utkashRoom.getBannerTableDao().getBanner(MakeMyExam.getUserId());
                            this.bottomMenuTables = this.utkashRoom.getBottomMenuTableDao().getBottomMenu(MakeMyExam.getUserId());
                        }
                        runOnUiThread(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda11
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$initialzehomepage$32();
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
    public /* synthetic */ void lambda$initialzehomepage$32() {
        this.cardsArrayList.clear();
        for (CourseTypeMasterTable courseTypeMasterTable : this.courseTypeMasterTables) {
            this.cardsArrayList.add(new Cards(courseTypeMasterTable.getId(), courseTypeMasterTable.getName(), com.clevertap.android.sdk.Constants.BLACK, courseTypeMasterTable.getName(), "0#0#0#0#0#0", "0"));
        }
        if (this.cardsArrayList.size() > 0) {
            getTileItems(this.cardsArrayList, 0);
        }
        selecteddata();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<BannerListTable> list = this.bannerListTables;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (BannerListTable bannerListTable : this.bannerListTables) {
            if (bannerListTable.getBanner_location().equalsIgnoreCase("0")) {
                arrayList.add(bannerListTable);
            }
            if (bannerListTable.getBanner_location().equalsIgnoreCase("5")) {
                arrayList.add(bannerListTable);
            }
            if (bannerListTable.getBanner_location().equalsIgnoreCase("1")) {
                arrayList2.add(bannerListTable);
            }
        }
        if (arrayList.size() > 0) {
            this.binding.dashBoardMain.bannerSliderLayout.viewPager2.setAdapter(new SliderAdapter(this, arrayList, new DashboardActivityTheme2$$ExternalSyntheticLambda9(this)));
            Utils.INSTANCE.setUpViewPager(this.binding.dashBoardMain.bannerSliderLayout.viewPager2, this.binding.dashBoardMain.bannerSliderLayout.bannerIndicator, arrayList);
        } else {
            this.viewPagerRL.setVisibility(8);
        }
        if (arrayList2.size() > 0) {
            this.binding.dashBoardMain.bottomSliderLayout.viewPager2.setAdapter(new BottomSliderAdapter(this, arrayList2, new DashboardActivityTheme2$$ExternalSyntheticLambda10(this)));
            Utils.INSTANCE.setUpViewPager(this.binding.dashBoardMain.bottomSliderLayout.viewPager2, this.binding.dashBoardMain.bottomSliderLayout.bannerIndicator, arrayList2);
            return;
        }
        this.bottomViewPagerRL.setVisibility(8);
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
            if (videoArrayList.get(0).getResult_date().equalsIgnoreCase("") || videoArrayList.get(0).getResult_date().equalsIgnoreCase("1") || videoArrayList.get(0).getResult_date().equalsIgnoreCase("0")) {
                this.first_attempt = "1";
                Intent intent3 = new Intent(this, (Class<?>) QuizActivity.class);
                intent3.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                intent3.putExtra("status", videoArrayList.get(0).getId());
                intent3.putExtra("name", videoArrayList.get(0).getTest_series_name());
                intent3.putExtra("first_attempt", this.first_attempt);
                Helper.gotoActivity(intent3, this);
                return;
            }
            if (System.currentTimeMillis() <= Long.parseLong(videoArrayList.get(0).getResult_date()) * 1000) {
                initialzehomepage();
                Toast.makeText(this, getResources().getString(R.string.your_result_will_be_declare_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(videoArrayList.get(0).getResult_date()) * 1000)), 0).show();
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
            Intent intent4 = new Intent(this, (Class<?>) QuizActivity.class);
            intent4.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
            intent4.putExtra("status", videoArrayList.get(0).getId());
            intent4.putExtra("name", videoArrayList.get(0).getTest_series_name());
            intent4.putExtra("first_attempt", this.first_attempt);
            Helper.gotoActivity(intent4, this);
            return;
        }
        if (System.currentTimeMillis() < Long.parseLong(videoArrayList.get(0).getEnd_date()) * 1000) {
            if (System.currentTimeMillis() < Long.parseLong(videoArrayList.get(0).getStart_date()) * 1000) {
                Snackbar.make(this.binding.drawerLayout.getRootView(), getResources().getString(R.string.test_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(videoArrayList.get(0).getStart_date()) * 1000)), -1).show();
                initialzehomepage();
                return;
            }
            if (this.utkashRoom == null) {
                this.utkashRoom = UtkashRoom.getAppDatabase(this);
            }
            TestTable testTableTest_data = this.utkashRoom.getTestDao().test_data(videoArrayList.get(0).getId(), MakeMyExam.userId);
            if (testTableTest_data != null && testTableTest_data.getStatus() != null && !testTableTest_data.getStatus().equalsIgnoreCase("")) {
                Snackbar.make(this.binding.drawerLayout.getRootView(), getResources().getString(R.string.you_have_already_attempted_the_test), -1).show();
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
            Snackbar.make(this.binding.drawerLayout.getRootView(), getResources().getString(R.string.your_result_will_be_declare_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(videoArrayList.get(0).getResult_date()) * 1000)), -1).show();
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
            Intent intent5 = new Intent(this, (Class<?>) QuizActivity.class);
            intent5.putExtra(Const.FRAG_TYPE, "leader_board");
            intent5.putExtra("status", videoArrayList.get(0).getId());
            intent5.putExtra("name", videoArrayList.get(0).getTest_series_name());
            Helper.gotoActivity(intent5, this);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    private void manageSliders() {
        if (this.bottomSetting.getTop_layout().equalsIgnoreCase("1")) {
            this.ll_top.setVisibility(0);
        } else {
            this.ll_top.setVisibility(8);
        }
    }

    private void socialIconsVisibility(final LeftMenu leftMenu) {
        if (leftMenu != null) {
            if (Helper.isNullChek(leftMenu.getTelegram_link_data()) && leftMenu.getTelegram_link().equalsIgnoreCase("1")) {
                this.binding.iconTelegram.setVisibility(0);
                this.binding.iconTelegram.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$33(leftMenu);
                    }
                }));
            }
            if (Helper.isNullChek(leftMenu.getInstagram_link_data()) && leftMenu.getInstagram_link().equalsIgnoreCase("1")) {
                this.binding.iconInstagram.setVisibility(0);
                this.binding.iconInstagram.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$34(leftMenu);
                    }
                }));
            }
            if (Helper.isNullChek(leftMenu.getLinkedin_link_data()) && leftMenu.getLinkedin_link().equalsIgnoreCase("1")) {
                this.binding.iconLinkedIn.setVisibility(0);
                this.binding.iconLinkedIn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$35(leftMenu);
                    }
                }));
            }
            if (Helper.isNullChek(leftMenu.getYoutube_link_data()) && leftMenu.getYoutube_link().equalsIgnoreCase("1")) {
                this.binding.iconYoutube.setVisibility(0);
                this.binding.iconYoutube.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$36(leftMenu);
                    }
                }));
            }
            if (Helper.isNullChek(leftMenu.getFacebook_link_data()) && leftMenu.getFacebook_link().equalsIgnoreCase("1")) {
                this.binding.iconFacebook.setVisibility(0);
                this.binding.iconFacebook.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$37(leftMenu);
                    }
                }));
            }
            if (Helper.isNullChek(leftMenu.getTwitter_link_data()) && leftMenu.getTwitter_link().equalsIgnoreCase("1")) {
                this.binding.iconTwitter.setVisibility(0);
                this.binding.iconTwitter.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$38(leftMenu);
                    }
                }));
            }
            if (Helper.isNullChek(leftMenu.getWebsite_url()) && leftMenu.getWebsite().equalsIgnoreCase("1")) {
                this.binding.iconWebsite.setVisibility(0);
                this.binding.iconWebsite.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$39(leftMenu);
                    }
                }));
            }
            if (Helper.isNullChek(leftMenu.getWhatsapp_channel_data()) && leftMenu.getWhatsapp_channel().equalsIgnoreCase("1")) {
                this.binding.iconWhatsapp.setVisibility(0);
                this.binding.iconWhatsapp.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$40();
                    }
                }));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$33(LeftMenu leftMenu) {
        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getTelegram_link_data())));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$34(LeftMenu leftMenu) {
        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getInstagram_link_data())));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$35(LeftMenu leftMenu) {
        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getLinkedin_link_data())));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$36(LeftMenu leftMenu) {
        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getYoutube_link_data())));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$37(LeftMenu leftMenu) {
        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getFacebook_link_data())));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$38(LeftMenu leftMenu) {
        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getTwitter_link_data())));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$39(LeftMenu leftMenu) {
        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getWebsite_url())));
            return null;
        } catch (Exception unused) {
            Helper.showToast(this, "Invalid Url", 0);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$40() {
        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
        if (isAppInstalled("com.whatsapp")) {
            try {
                String string = SharedPreference.getInstance().getString(Const.WHATSAPP_CHANNEL_DATA);
                if (string != null && !string.equalsIgnoreCase("")) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(string));
                    startActivity(intent);
                } else {
                    Toast.makeText(homeactivitytheme2, "Channel URL is not found !", 0).show();
                }
                return null;
            } catch (Exception unused) {
                Helper.showToast(this, "Invalid Url", 0);
                return null;
            }
        }
        Toast.makeText(this, "Whatsapp is not currently installed on your phone", 0).show();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hitRecentWatchApi() {
        this.networkCall.NetworkAPICall(API.API_RECENT_WATCH, "", false, false);
    }

    private void affaircheckdeeplick() {
        String str = this.parentid;
        if (str == null || str.equalsIgnoreCase("")) {
            if (SharedPreference.getInstance().getString("maincourseid").equalsIgnoreCase("")) {
                return;
            }
            Intent intent = new Intent(this, (Class<?>) CurrentAffairActivity.class);
            intent.putExtra(Const.COURSE_ID_MAIN, SharedPreference.getInstance().getString("maincourseid"));
            intent.putExtra(Const.COURSE_PARENT_ID, "");
            intent.putExtra("title_key", "Current Affair");
            startActivity(intent);
            SharedPreference.getInstance().putString("maincourseid", "");
            return;
        }
        if (SharedPreference.getInstance().getString("maincourseid").equalsIgnoreCase("")) {
            return;
        }
        Intent intent2 = new Intent(this, (Class<?>) CurrentAffairActivity.class);
        intent2.putExtra(Const.COURSE_ID_MAIN, this.parentid);
        intent2.putExtra(Const.COURSE_PARENT_ID, "");
        intent2.putExtra("title_key", "Current Affair");
        startActivity(intent2);
        SharedPreference.getInstance().putString("maincourseid", "");
    }

    private void getDeepLinks() {
        try {
            String stringPreference = PreferencesUtil.INSTANCE.getStringPreference(this, "main_course_id");
            if (stringPreference.equalsIgnoreCase("")) {
                return;
            }
            Intent intent = new Intent(this, (Class<?>) CurrentAffairInfoActivity.class);
            intent.putExtra("id", stringPreference);
            intent.putExtra("type", Const.CURRENT_AFFAIR);
            startActivity(intent);
            PreferencesUtil.INSTANCE.removePreference(this, "main_course_id");
        } catch (Exception unused) {
        }
    }

    private void initImage(ArrayList<Video> videoArrayList) {
        if (videoArrayList.size() <= 0 || TextUtils.isEmpty(videoArrayList.get(0).getFile_url()) || TextUtils.isEmpty(videoArrayList.get(0).getId()) || !videoArrayList.get(0).getIs_locked().equalsIgnoreCase("0")) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) WebViewActivty.class);
        intent.putExtra("type", videoArrayList.get(0).getTitle());
        intent.putExtra("url", videoArrayList.get(0).getFile_url());
        intent.putExtra("file_type", "image");
        Helper.gotoActivity(intent, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkStoragePermission() {
        OpenChooser();
    }

    private void OpenChooser() {
        if (this.STORAGE_PERMISSION_TYPE == 3) {
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("application/pdf");
            intent.putExtra("android.provider.extra.INITIAL_URI", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath());
            startActivityForResult(Intent.createChooser(intent, "Select PDF file"), 1203);
        }
    }

    private void hitApiIfNotInLocal() {
        String str;
        DashboardActivityTheme2 dashboardActivityTheme2;
        Intent intent;
        final DashboardActivityTheme2 dashboardActivityTheme22 = this;
        if (dashboardActivityTheme22.leftMenu == null && dashboardActivityTheme22.hitMaster) {
            dashboardActivityTheme22.hitMaster = false;
            dashboardActivityTheme22.networkCall.NetworkAPICall(API.master_content, "", true, false);
        }
        int i = dashboardActivityTheme22.notification_code;
        if (i == 90002) {
            dashboardActivityTheme22.hit_api_for_data();
        } else if (i == 90005) {
            if (Long.parseLong(dashboardActivityTheme22.test_series_date) * 1000 < System.currentTimeMillis()) {
                if (!Helper.isConnected(dashboardActivityTheme22)) {
                    Toast.makeText(dashboardActivityTheme22, R.string.no_internet_connection, 0).show();
                    dashboardActivityTheme22.initialzehomepage();
                } else {
                    String str2 = dashboardActivityTheme22.fieldid;
                    Constants.SUB_TEST_ID = (str2 == null || TextUtils.isEmpty(str2)) ? dashboardActivityTheme22.test_id : dashboardActivityTheme22.fieldid;
                    Constants.Live_TEST_COURSEID = dashboardActivityTheme22.course_id;
                    Helper.GoToSubjectiveResultActivity(dashboardActivityTheme22, dashboardActivityTheme22.solutions, dashboardActivityTheme22.test_series_name, dashboardActivityTheme22.course_id, dashboardActivityTheme22.fieldid, Const.SUBJECTIVE_TEST);
                    dashboardActivityTheme22 = dashboardActivityTheme22;
                }
            } else {
                Toast.makeText(dashboardActivityTheme22, dashboardActivityTheme22.getResources().getString(R.string.result_will_be_available_on) + new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(dashboardActivityTheme22.test_series_date) * 1000)), 0).show();
                dashboardActivityTheme22.initialzehomepage();
            }
        } else if (i == 90006) {
            Intent intent2 = new Intent(dashboardActivityTheme22, (Class<?>) ConversationReplyActivity.class);
            intent2.putExtra(Const.CONTATUS_ID, dashboardActivityTheme22.id);
            intent2.putExtra(Const.APP_ID, "166");
            dashboardActivityTheme22.startActivity(intent2);
        } else if (i == 90001) {
            if (dashboardActivityTheme22.message_target.equalsIgnoreCase("6")) {
                intent = new Intent(dashboardActivityTheme22, (Class<?>) WebFragActivity.class);
                intent.putExtra("title", dashboardActivityTheme22.title);
                intent.putExtra("url", dashboardActivityTheme22.url);
                intent.putExtra("imageUrl", dashboardActivityTheme22.imageUrl);
            } else if (dashboardActivityTheme22.message_target.equalsIgnoreCase("2")) {
                intent = new Intent(dashboardActivityTheme22, (Class<?>) CourseActivity.class);
                intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                intent.putExtra(Const.COURSE_ID_MAIN, dashboardActivityTheme22.course_id);
                intent.putExtra(Const.COURSE_PARENT_ID, "");
                intent.putExtra(Const.IS_COMBO, false);
                SharedPreference.getInstance().putString("id", dashboardActivityTheme22.course_id);
            } else if (dashboardActivityTheme22.message_target.equalsIgnoreCase("5")) {
                intent = new Intent(dashboardActivityTheme22, (Class<?>) NotificationDescription.class);
                intent.putExtra("urlType", "IMAGE");
                intent.putExtra("title", dashboardActivityTheme22.title);
                intent.putExtra("url", dashboardActivityTheme22.url);
                intent.putExtra("imageUrl", dashboardActivityTheme22.imageUrl);
                intent.putExtra("description", dashboardActivityTheme22.message);
            } else if (dashboardActivityTheme22.message_target.equalsIgnoreCase("1")) {
                intent = new Intent(dashboardActivityTheme22, (Class<?>) WebFragActivity.class);
                intent.putExtra("title", dashboardActivityTheme22.title);
                intent.putExtra("url", dashboardActivityTheme22.message);
                intent.putExtra("from", "noti");
            } else if (dashboardActivityTheme22.message_target.equalsIgnoreCase("8")) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j = dashboardActivityTheme22.ts;
                if (jCurrentTimeMillis > j * 1000) {
                    if (dashboardActivityTheme22.coupon_for.equalsIgnoreCase("1")) {
                        Toast.makeText(dashboardActivityTheme22, dashboardActivityTheme22.getResources().getString(R.string.this_coupon_is_available_for_all_courses), 0).show();
                        dashboardActivityTheme22.initialzehomepage();
                    } else if (dashboardActivityTheme22.coupon_for.equalsIgnoreCase("0") || dashboardActivityTheme22.coupon_for.equalsIgnoreCase("2")) {
                        intent = new Intent(dashboardActivityTheme22, (Class<?>) CouponActivity.class);
                    } else {
                        intent = new Intent(dashboardActivityTheme22, (Class<?>) WebFragActivity.class);
                        intent.putExtra("title", dashboardActivityTheme22.title);
                        intent.putExtra("url", dashboardActivityTheme22.message);
                        intent.putExtra("from", "noti");
                    }
                } else {
                    if (j != 0) {
                        Toast.makeText(dashboardActivityTheme22, dashboardActivityTheme22.getResources().getString(R.string.this_coupon_is_available_on) + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.US).format(new Date(dashboardActivityTheme22.ts * 1000))), 0).show();
                    }
                    dashboardActivityTheme22.initialzehomepage();
                }
                intent = null;
            } else {
                intent = new Intent(dashboardActivityTheme22, (Class<?>) WebFragActivity.class);
                intent.putExtra("title", dashboardActivityTheme22.title);
                intent.putExtra("url", dashboardActivityTheme22.message);
                intent.putExtra("from", "noti");
            }
            if (intent != null) {
                Helper.gotoActivity(intent, dashboardActivityTheme22);
            }
        } else if (i == 123 || i == 124 || i == 125) {
            dashboardActivityTheme22.hit_api_for_data();
        } else {
            AudioTable audioTable = dashboardActivityTheme22.audioTable;
            if (audioTable != null && audioTable.getVideo_id() != null && !dashboardActivityTheme22.audioTable.getVideo_id().equalsIgnoreCase("")) {
                dashboardActivityTheme22.notification_code = 109010;
                String str3 = dashboardActivityTheme22.video_type;
                if (str3 != null && str3.equalsIgnoreCase("jw")) {
                    Intent intent3 = new Intent(dashboardActivityTheme22, (Class<?>) AudioPlayerActivty.class);
                    AudioPlayerService.videoid = "";
                    intent3.putExtra("url", dashboardActivityTheme22.audioTable.getAudio_url());
                    intent3.putExtra("videoid", dashboardActivityTheme22.audioTable.getVideo_id());
                    intent3.putExtra("currentpos", dashboardActivityTheme22.audioTable.getAudio_currentpos());
                    intent3.putExtra("video_name", dashboardActivityTheme22.audioTable.getVideo_name());
                    intent3.putExtra("image_url", dashboardActivityTheme22.audioTable.getJw_url() + "/poster.jpg?width=720");
                    intent3.putExtra("course_id", dashboardActivityTheme22.audioTable.getCourse_id());
                    Helper.gotoActivity(intent3, dashboardActivityTheme22);
                }
            } else {
                String str4 = dashboardActivityTheme22.video_type;
                if (str4 != null && str4.contains("youtube_")) {
                    dashboardActivityTheme22.notification_code = 109010;
                    UserHistroyTable userHistroyTableUser_history = dashboardActivityTheme22.utkashRoom.getuserhistorydao().user_history(MakeMyExam.userId, dashboardActivityTheme22.getIntent().getStringExtra("type").split("_")[1]);
                    if (userHistroyTableUser_history != null) {
                        String str5 = "http://img.youtube.com/vi/" + userHistroyTableUser_history.getYoutube_url() + "/0.jpg";
                        if (userHistroyTableUser_history.getTileid() == null || userHistroyTableUser_history.getTileid().equalsIgnoreCase("")) {
                            Helper.GoToLiveVideoActivity("", dashboardActivityTheme22, userHistroyTableUser_history.getYoutube_url(), "1", userHistroyTableUser_history.getVideo_id(), userHistroyTableUser_history.getVideo_name(), "1", str5, "1", userHistroyTableUser_history.getCourse_id(), String.valueOf(1), dashboardActivityTheme22.parentid, dashboardActivityTheme22.tileid, "Video", new ArrayList());
                        } else {
                            Helper.GoToLiveVideoActivity("", dashboardActivityTheme22, userHistroyTableUser_history.getYoutube_url(), "1", userHistroyTableUser_history.getVideo_id(), userHistroyTableUser_history.getVideo_name(), "1", str5, "1", userHistroyTableUser_history.getCourse_id(), String.valueOf(1), dashboardActivityTheme22.parentid, userHistroyTableUser_history.getTileid(), "Video", new ArrayList());
                        }
                    } else {
                        dashboardActivityTheme22.initialzehomepage();
                    }
                } else {
                    String str6 = dashboardActivityTheme22.video_type;
                    if (str6 != null && str6.contains("aws")) {
                        dashboardActivityTheme22.notification_code = 109010;
                        UserHistroyTable userHistroyTableUser_history2 = dashboardActivityTheme22.utkashRoom.getuserhistorydao().user_history(MakeMyExam.userId, dashboardActivityTheme22.getIntent().getStringExtra("type").split("_")[1]);
                        if (userHistroyTableUser_history2 != null) {
                            if (userHistroyTableUser_history2.getYoutube_url().split("ayush").length == 2) {
                                dashboardActivityTheme2 = this;
                                Helper.GoToLiveAwsVideoActivity("0", "", dashboardActivityTheme2, userHistroyTableUser_history2.getYoutube_url().split("ayush")[0], "0", userHistroyTableUser_history2.getVideo_id(), userHistroyTableUser_history2.getVideo_name(), "1", userHistroyTableUser_history2.getYoutube_url().split("ayush")[1], userHistroyTableUser_history2.getCourse_id(), userHistroyTableUser_history2.getTileid(), "Video", "1", "", dashboardActivityTheme22.parentid, "", new ArrayList());
                            } else {
                                dashboardActivityTheme2 = this;
                                Helper.GoToLiveAwsVideoActivity("0", "", dashboardActivityTheme2, userHistroyTableUser_history2.getYoutube_url().split("ayush")[0], "0", userHistroyTableUser_history2.getVideo_id(), userHistroyTableUser_history2.getVideo_name(), "1", "", userHistroyTableUser_history2.getCourse_id(), userHistroyTableUser_history2.getTileid(), "Video", "1", "", dashboardActivityTheme22.parentid, "", new ArrayList());
                            }
                            dashboardActivityTheme22 = dashboardActivityTheme2;
                        } else {
                            dashboardActivityTheme22.initialzehomepage();
                        }
                    } else {
                        int i2 = dashboardActivityTheme22.notification_code;
                        if (i2 == 0) {
                            if (Helper.isNetworkConnected(dashboardActivityTheme22)) {
                                if (dashboardActivityTheme22.utkashRoom.getMasterAllCatDao().isRecordExistsUserId(MakeMyExam.userId)) {
                                    dashboardActivityTheme22.courseTypeMasterTables.clear();
                                    dashboardActivityTheme22.masterAllCatTables.clear();
                                    dashboardActivityTheme22.mastercatlist.clear();
                                    dashboardActivityTheme22.LanguagesTable.clear();
                                    dashboardActivityTheme22.bannerListTables.clear();
                                    dashboardActivityTheme22.bottomMenuTables.clear();
                                    AsyncTask.execute(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda15
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            this.f$0.lambda$hitApiIfNotInLocal$42();
                                        }
                                    });
                                } else {
                                    dashboardActivityTheme22.hit_api_master_data();
                                }
                            }
                        } else if (i2 == 101) {
                            dashboardActivityTheme22.checkdeeplick();
                        } else if (i2 == 201) {
                            dashboardActivityTheme22.affaircheckdeeplick();
                        } else if (i2 == 1001001 && (str = dashboardActivityTheme22.post_id) != null && !TextUtils.isEmpty(str)) {
                            Intent intent4 = new Intent(dashboardActivityTheme22, (Class<?>) FeedDetails.class);
                            intent4.putExtra("postId", dashboardActivityTheme22.post_id);
                            Helper.gotoActivity(intent4, dashboardActivityTheme22);
                        }
                    }
                }
            }
        }
        dashboardActivityTheme22.getDeepLinks();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hitApiIfNotInLocal$42() {
        try {
            if (!this.utkashRoom.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread()) {
                this.courseTypeMasterTables = this.utkashRoom.getcoursetypemaster().getcourse_typemaster(MakeMyExam.userId);
                this.masterAllCatTables = this.utkashRoom.getMasterAllCatDao().getmaster_allcat(MakeMyExam.userId);
                this.mastercatlist = this.utkashRoom.getMastercatDao().getmastercat(MakeMyExam.userId);
                this.LanguagesTable = this.utkashRoom.getLaunguages().getLaunguagedetail();
                this.bannerListTables = this.utkashRoom.getBannerTableDao().getBanner(MakeMyExam.getUserId());
                this.bottomMenuTables = this.utkashRoom.getBottomMenuTableDao().getBottomMenu(MakeMyExam.getUserId());
            }
            runOnUiThread(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme2$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$hitApiIfNotInLocal$41();
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hitApiIfNotInLocal$41() {
        if (this.leftMenu == null && this.hitMaster) {
            this.hitMaster = false;
            this.networkCall.NetworkAPICall(API.master_content, "", true, false);
            return;
        }
        this.cardsArrayList.clear();
        for (CourseTypeMasterTable courseTypeMasterTable : this.courseTypeMasterTables) {
            this.cardsArrayList.add(new Cards(courseTypeMasterTable.getId(), courseTypeMasterTable.getName(), com.clevertap.android.sdk.Constants.BLACK, courseTypeMasterTable.getName(), "0#0#0#0#0#0", "0"));
        }
        if (this.cardsArrayList.size() > 0) {
            getTileItems(this.cardsArrayList, 0);
        }
        selecteddata();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<BannerListTable> list = this.bannerListTables;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (BannerListTable bannerListTable : this.bannerListTables) {
            if (bannerListTable.getBanner_location().equalsIgnoreCase("0")) {
                arrayList.add(bannerListTable);
            }
            if (bannerListTable.getBanner_location().equalsIgnoreCase("5")) {
                arrayList.add(bannerListTable);
            }
            if (bannerListTable.getBanner_location().equalsIgnoreCase("1")) {
                arrayList2.add(bannerListTable);
            }
        }
        if (arrayList.size() > 0) {
            this.binding.dashBoardMain.bannerSliderLayout.viewPager2.setAdapter(new SliderAdapter(this, arrayList, new DashboardActivityTheme2$$ExternalSyntheticLambda9(this)));
            Utils.INSTANCE.setUpViewPager(this.binding.dashBoardMain.bannerSliderLayout.viewPager2, this.binding.dashBoardMain.bannerSliderLayout.bannerIndicator, arrayList);
        } else {
            this.viewPagerRL.setVisibility(8);
        }
        if (arrayList2.size() > 0) {
            this.binding.dashBoardMain.bottomSliderLayout.viewPager2.setAdapter(new BottomSliderAdapter(this, arrayList2, new DashboardActivityTheme2$$ExternalSyntheticLambda10(this)));
            Utils.INSTANCE.setUpViewPager(this.binding.dashBoardMain.bottomSliderLayout.viewPager2, this.binding.dashBoardMain.bottomSliderLayout.bannerIndicator, arrayList2);
            return;
        }
        this.bottomViewPagerRL.setVisibility(8);
    }

    public void openWebPage(Context context, String url) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(url));
            intent.setFlags(1073741824);
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(context, " You don't have any browser to open the file", 1).show();
        }
    }

    private boolean logutuser() {
        if (SharedPreference.getInstance().getLoggedInUser() != null && SharedPreference.getInstance().getLoggedInUser().getId() != null) {
            return false;
        }
        Intent intent = new Intent(this, Helper.setSignInActivity());
        intent.putExtra("type", Const.SIGNIN);
        intent.putExtra(Const.OPEN_WITH, "user");
        intent.putExtra(Const.SOCIAL_TYPE, "1");
        intent.setFlags(335544320);
        startActivity(intent);
        finish();
        return true;
    }

    private boolean isAppInstalled(String packageName) {
        try {
            getPackageManager().getPackageInfo(packageName, 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    @Override // com.appnew.android.Theme.Adapter.SliderAdapter.BannerClick
    public void BannerClickItem(BannerListTable bannerItem) {
        String name;
        String display_type;
        String master_category_id;
        if (bannerItem.getBanner_location().equalsIgnoreCase("7") && bannerItem.getLink_type().equalsIgnoreCase("4")) {
            this.tileid = bannerItem.getExtra().getTile_id();
            this.tiletype = bannerItem.getExtra().getTile_type();
            this.revertapi = bannerItem.getExtra().getRevert_api();
            this.course_id = bannerItem.getExtra().getCourse_id();
            this.fieldid = bannerItem.getExtra().getFile_id();
            this.parentid = "";
            this.topicid = bannerItem.getExtra().getTopic_id();
            this.notification_code = 90002;
            hit_api_for_data();
            return;
        }
        int i = 0;
        while (true) {
            if (i >= this.courseTypeMasterTables.size()) {
                name = "0";
                display_type = name;
                master_category_id = display_type;
                break;
            } else {
                if (this.courseTypeMasterTables.get(i).getId().equalsIgnoreCase(bannerItem.getCourse_id())) {
                    display_type = this.courseTypeMasterTables.get(i).getDisplay_type();
                    master_category_id = this.courseTypeMasterTables.get(i).getMaster_category_id();
                    name = this.courseTypeMasterTables.get(i).getName();
                    break;
                }
                i++;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putInt(Const.NOTIFICATION_CODE, this.notification_code);
        bundle.putString("course_id", this.course_id);
        bundle.putString("file_id", this.fieldid);
        bundle.putString(Const.TOPIC_ID, this.topicid);
        bundle.putString("tile_id", this.tileid);
        bundle.putString(Const.TILE_TYPE, this.tiletype);
        bundle.putString(Const.REVERT_API, this.revertapi);
        bundle.putString("title", name);
        bundle.putString("searchenable", display_type);
        bundle.putString("course_description", "");
        bundle.putString(TypedValues.AttributesType.S_TARGET, this.message_target);
        bundle.putString("url", this.url);
        bundle.putString("image", this.imageUrl);
        bundle.putString("message", this.message);
        bundle.putSerializable("master_cat", (Serializable) this.masterAllCatTables);
        bundle.putString(Const.TAB_ID, bannerItem.getCourse_id());
        bundle.putString(Const.TAB_NAME, bannerItem.getBanner_title());
        bundle.putString(Const.MASTER_CATEGORY_ID, master_category_id);
        bundle.putString(Const.IS_BOOK, "0");
        if (display_type.equalsIgnoreCase("1")) {
            startActivity(new Intent(this, (Class<?>) CourseTypeActivity.class).putExtras(bundle));
        } else {
            startActivity(new Intent(this, (Class<?>) HomeActivity.class).putExtras(bundle));
        }
        overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
    }

    public void hitApiForAttendance() {
        this.networkCall.NetworkAPICall(API.API_ADD_ATTENDANCE, "", false, false);
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
