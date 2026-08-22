package com.appnew.android.Theme;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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
import android.view.WindowManager;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.appnew.android.BuildConfig;
import com.appnew.android.Coupon.Activity.CouponActivity;
import com.appnew.android.CourseTransfer.CourseTransferActivity;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.Courses.Activity.QuizActivity;
import com.appnew.android.Courses.Activity.SearchActivity;
import com.appnew.android.Courses.Activity.WebFragActivity;
import com.appnew.android.Courses.Fragment.QuizWebView;
import com.appnew.android.CreateTest.Activity.CreateTestActivity;
import com.appnew.android.CustomPayment.CustomPaymentActivity;
import com.appnew.android.Download.Audio.AudioPlayerService;
import com.appnew.android.Download.AudioPlayerActivty;
import com.appnew.android.Download.DownloadActivity;
import com.appnew.android.Download.DownloadVideoPlayer;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Intro.Activity.IntroActivity;
import com.appnew.android.LiveClass.Activity.LiveClassActivity;
import com.appnew.android.LiveTest.Activity.LivetestActivity;
import com.appnew.android.Model.BottomMenu;
import com.appnew.android.Model.BottomSetting;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Model.Courses.Cards;
import com.appnew.android.Model.LeftMenu;
import com.appnew.android.Model.Video;
import com.appnew.android.Notification.Notification;
import com.appnew.android.Notification.NotificationDescription;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Profile.ProfileActivity;
import com.appnew.android.PurchaseHistory.PurchaseHistory;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Theme.Adapter.BannerAdapter;
import com.appnew.android.Theme.Adapter.BottomBannerAdapter;
import com.appnew.android.Theme.Adapter.BottomSheetAdapter;
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
import com.appnew.android.Zoom.Activity.BookMarkList;
import com.appnew.android.Zoom.Activity.CurrentAffairActivity;
import com.appnew.android.cleverTap.AnalyticHelper;
import com.appnew.android.databinding.ActivityDashboardTheme7Binding;
import com.appnew.android.databinding.AppBarDashboard7Binding;
import com.appnew.android.feeds.activity.FeedDetails;
import com.appnew.android.feeds.activity.FeedViewPager;
import com.appnew.android.feeds.adapters.FeedViewPagerAdapter;
import com.appnew.android.home.Activity.CourseTypeActivity;
import com.appnew.android.home.Activity.HomeActivity;
import com.appnew.android.home.Activity.MyLibraryActivty;
import com.appnew.android.home.Activity.SettingsActivity;
import com.appnew.android.home.Constants;
import com.appnew.android.home.Fragment.Chatboot;
import com.appnew.android.home.Fragment.ContactBottomSheetFragment;
import com.appnew.android.home.adapters.LeftNavAdapter;
import com.appnew.android.home.adapters.TileDataAdapter2;
import com.appnew.android.home.adapters.TileItemsAdapter;
import com.appnew.android.home.interfaces.onButtonClicked;
import com.appnew.android.home.model.FilterData.Filterdata;
import com.appnew.android.home.model.FilterData.Subject;
import com.appnew.android.home.model.Menu;
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
import com.clevertap.android.sdk.Constants;
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
import com.makeramen.roundedimageview.RoundedImageView;
import com.tv9news.utils.helpers.AnalyticEvents;
import com.tv9news.utils.helpers.AnalyticsConstants;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import me.leolin.shortcutbadger.ShortcutBadger;
import org.bouncycastle.pqc.crypto.newhope.NewHope;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class DashboardActivityTheme7 extends AppCompatActivity implements NetworkCall.MyNetworkCallBack, onButtonClicked, PopupMenu.OnMenuItemClickListener, BottomBannerAdapter.BannerClick {
    public static Activity homeactivity;
    public static Activity homeactivitytheme6;
    LinearLayout CourseLL;
    RelativeLayout RL1P;
    TileDataAdapter2 TileDataAdapter2;
    private Task<AppUpdateInfo> appUpdateInfoTask;
    private AudioTable audioTable;
    Button backBtn;
    private BannerAdapter bannerAdapter;
    RecyclerView bannerSlider;
    private ActivityDashboardTheme7Binding binding;
    private BottomBannerAdapter bottomBannerAdapter;
    LinearLayout bottomLL;
    BottomSetting bottomSetting;
    ViewPager2 bottomSliderViewPager;
    RelativeLayout bottomViewPagerRL;
    LinearLayout cartLL;
    public BottomSheetDialog changeInterface;
    CardView changeInterfaceCV;
    public ImageView chatboat;
    ImageButton chromecast;
    public String contentType;
    RecyclerView courseListRV;
    LinearLayout cvrNotificationCount;
    Data data;
    public ImageView downarrowIV;
    DrawerLayout drawer;
    RelativeLayout feeds_ll;
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
    LinearLayout ll_top_two;
    private AppUpdateManager mAppUpdateManager;
    String mPhoneNumber;
    LinearLayout main_rl;
    CardView myTest;
    CardView my_library;
    public RecyclerView navRV;
    LinearLayout nav_headerLL;
    NavigationView navigationView;
    NetworkCall networkCall;
    RelativeLayout no_data_found_RL;
    RelativeLayout no_data_found_RL_1;
    TextView notificaionCount;
    ImageView notificationIV;
    RelativeLayout notificationLL;
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
    public TextView selectionType;
    ViewPager2 sliderViewPager;
    TextView subjectspinner;
    LinearLayout testLL;
    TileItemsAdapter tileItemsAdapter;
    RecyclerView tileRv;
    TextView tile_tv;
    RelativeLayout titleinnerRL;
    ActionBarDrawerToggle toggle;
    public Toolbar toolbar;
    TextView toolbartitleTV;
    ImageView updateProfileBtn;
    UtkashRoom utkashRoom;
    TextView versionnameTV;
    private Video videodata;
    RelativeLayout viewPagerRL;
    BottomSheetDialog watchlist;
    boolean isAllClicked = false;
    long backPressed = 0;
    private boolean backstatus = false;
    ArrayList<Data.Preferences> preferencesArrayList = new ArrayList<>();
    public String contentType_id = "0";
    List<CourseTypeMasterTable> courseTypeMasterTables = new ArrayList();
    List<MasteAllCatTable> masterAllCatTables = new ArrayList();
    List<MasterCat> mastercatlist = new ArrayList();
    public String mastercatname = "";
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
    String activityType = "";
    String message = "";
    String title = "";
    String url = "";
    String imageUrl = "";
    String message_target = "";
    String type = "";
    String course_id = "";
    String post_id = "";
    String banner_id = "";
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
    ArrayList<View> viewArrayList = new ArrayList<>();
    boolean is_test_series_clicked = false;
    boolean isFeedsClicked = false;
    String catName = "";
    public String id = "";
    private boolean hitMaster = true;
    public View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme7.2
        /* JADX WARN: Code restructure failed: missing block: B:192:0x04c5, code lost:
        
            continue;
         */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onClick(android.view.View r12) {
            /*
                Method dump skipped, instruction units count: 1310
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Theme.DashboardActivityTheme7.AnonymousClass2.onClick(android.view.View):void");
        }
    };
    ViewPager2.OnPageChangeCallback bannerPageChangeCallback = new ViewPager2.OnPageChangeCallback() { // from class: com.appnew.android.Theme.DashboardActivityTheme7.5
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
    String[] langIds = {"1"};
    String is_paid = "";

    public LinearLayout initBottomView(Menu menu) {
        LinearLayout linearLayout = (LinearLayout) View.inflate(this, R.layout.bottom_item, null);
        TextView textView = (TextView) linearLayout.findViewById(R.id.title);
        final ImageView imageView = (ImageView) linearLayout.findViewById(R.id.icon);
        RelativeLayout relativeLayout = (RelativeLayout) linearLayout.findViewById(R.id.viewUnderLine);
        textView.setText(menu.getName());
        if (menu.getId().equalsIgnoreCase("1")) {
            textView.setTextColor(getResources().getColor(R.color.colorPrimary));
            textView.setTypeface(Typeface.defaultFromStyle(1));
            relativeLayout.setVisibility(0);
        }
        Glide.with((FragmentActivity) this).asBitmap().load(menu.getImageUrl()).into(new CustomTarget<Bitmap>() { // from class: com.appnew.android.Theme.DashboardActivityTheme7.1
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

    private void showDialogForChangePrefernceOrIntro() {
        try {
            final Dialog dialog = new Dialog(this);
            dialog.setCancelable(true);
            dialog.requestWindowFeature(1);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
            dialog.setContentView(R.layout.dialog_alert_simple);
            TextView textView = (TextView) dialog.findViewById(R.id.titleDialog);
            TextView textView2 = (TextView) dialog.findViewById(R.id.msgDialog);
            Button button = (Button) dialog.findViewById(R.id.btn_cancel);
            Button button2 = (Button) dialog.findViewById(R.id.btn_submit);
            if (TextUtils.isEmpty(getResources().getString(R.string.update_preference))) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(getResources().getString(R.string.update_preference));
            }
            textView2.setText(getResources().getString(R.string.your_are_not));
            button.setText(getResources().getString(R.string.cancel));
            button2.setText(getResources().getString(R.string.update));
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme7.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    try {
                        Intent intent = new Intent(DashboardActivityTheme7.this, (Class<?>) IntroActivity.class);
                        intent.putExtra("isFromUpdatePreference", "1");
                        Helper.gotoActivity(intent, DashboardActivityTheme7.this);
                        dialog.dismiss();
                    } catch (Exception unused) {
                    }
                }
            });
            button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme7.4
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    try {
                        dialog.dismiss();
                    } catch (Exception unused) {
                    }
                }
            });
            dialog.show();
        } catch (Exception unused) {
        }
    }

    public void openWhatsapp() {
        this.mPhoneNumber = this.leftMenu.getMobile_number();
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://wa.me/" + this.mPhoneNumber)));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(final Bundle savedInstanceState) {
        String str;
        ThemeSettings themeSettingsData;
        String str2;
        String str3;
        DashboardActivityTheme7 dashboardActivityTheme7;
        Intent intent;
        final DashboardActivityTheme7 dashboardActivityTheme72 = this;
        super.onCreate(savedInstanceState);
        Helper.enableScreenShot(dashboardActivityTheme72);
        dashboardActivityTheme72.utkashRoom = UtkashRoom.getAppDatabase(dashboardActivityTheme72);
        ActivityDashboardTheme7Binding activityDashboardTheme7BindingInflate = ActivityDashboardTheme7Binding.inflate(dashboardActivityTheme72.getLayoutInflater());
        dashboardActivityTheme72.binding = activityDashboardTheme7BindingInflate;
        dashboardActivityTheme72.setContentView(activityDashboardTheme7BindingInflate.getRoot());
        Helper.setSystemBarLight(dashboardActivityTheme72);
        homeactivitytheme6 = dashboardActivityTheme72;
        dashboardActivityTheme72.networkCall = new NetworkCall(dashboardActivityTheme72, dashboardActivityTheme72);
        dashboardActivityTheme72.toolbartitleTV = (TextView) dashboardActivityTheme72.findViewById(R.id.toolbartitleTV);
        dashboardActivityTheme72.pullToReferesh = (SwipeRefreshLayout) dashboardActivityTheme72.findViewById(R.id.pullto_referesh);
        dashboardActivityTheme72.notificaionCount = (TextView) dashboardActivityTheme72.findViewById(R.id.notificaionCount);
        dashboardActivityTheme72.cvrNotificationCount = (LinearLayout) dashboardActivityTheme72.findViewById(R.id.cvrNotificationCount);
        dashboardActivityTheme72.pullToReferesh.setRefreshing(false);
        dashboardActivityTheme72.liveclass = (LinearLayout) dashboardActivityTheme72.findViewById(R.id.liveclass);
        dashboardActivityTheme72.selectionType = (TextView) dashboardActivityTheme72.findViewById(R.id.selectionType);
        dashboardActivityTheme72.libLL = (LinearLayout) dashboardActivityTheme72.findViewById(R.id.libLL);
        dashboardActivityTheme72.livetest = (LinearLayout) dashboardActivityTheme72.findViewById(R.id.livetest);
        dashboardActivityTheme72.livetestLL = (LinearLayout) dashboardActivityTheme72.findViewById(R.id.livetestLL);
        dashboardActivityTheme72.bottomLL = (LinearLayout) dashboardActivityTheme72.findViewById(R.id.bottomLL);
        dashboardActivityTheme72.liveclassLL = (LinearLayout) dashboardActivityTheme72.findViewById(R.id.liveclassLL);
        dashboardActivityTheme72.CourseLL = (LinearLayout) dashboardActivityTheme72.findViewById(R.id.CourseLL);
        dashboardActivityTheme72.filter = (RelativeLayout) dashboardActivityTheme72.findViewById(R.id.filter);
        dashboardActivityTheme72.forchatbot = (FrameLayout) dashboardActivityTheme72.findViewById(R.id.forchatbot);
        dashboardActivityTheme72.sliderViewPager = (ViewPager2) dashboardActivityTheme72.findViewById(R.id.sliderViewPager);
        dashboardActivityTheme72.bottomSliderViewPager = (ViewPager2) dashboardActivityTheme72.findViewById(R.id.bottomSliderViewPager);
        dashboardActivityTheme72.filterOne = (TextView) dashboardActivityTheme72.findViewById(R.id.filterOne);
        dashboardActivityTheme72.viewPagerRL = (RelativeLayout) dashboardActivityTheme72.findViewById(R.id.viewPagerRL);
        dashboardActivityTheme72.bottomViewPagerRL = (RelativeLayout) dashboardActivityTheme72.findViewById(R.id.bottomViewPagerRL);
        dashboardActivityTheme72.ll_top = (RelativeLayout) dashboardActivityTheme72.findViewById(R.id.ll_top);
        dashboardActivityTheme72.RL1P = (RelativeLayout) dashboardActivityTheme72.findViewById(R.id.RL1P);
        dashboardActivityTheme72.backBtn = (Button) dashboardActivityTheme72.findViewById(R.id.backBtn);
        dashboardActivityTheme72.profileLL = (RelativeLayout) dashboardActivityTheme72.findViewById(R.id.profileLL);
        dashboardActivityTheme72.ll_top_two = (LinearLayout) dashboardActivityTheme72.findViewById(R.id.ll_top_two);
        dashboardActivityTheme72.filter_one_click = (RelativeLayout) dashboardActivityTheme72.findViewById(R.id.filter_one_click);
        dashboardActivityTheme72.filter_two_click = (RelativeLayout) dashboardActivityTheme72.findViewById(R.id.filter_two_click);
        dashboardActivityTheme72.titleinnerRL = (RelativeLayout) dashboardActivityTheme72.findViewById(R.id.titleinnerRL);
        dashboardActivityTheme72.filterTwo = (TextView) dashboardActivityTheme72.findViewById(R.id.filterTwo);
        dashboardActivityTheme72.downarrowIV = (ImageView) dashboardActivityTheme72.findViewById(R.id.downarrowIV);
        dashboardActivityTheme72.scrollView = (StickyScrollView) dashboardActivityTheme72.findViewById(R.id.scrollView);
        dashboardActivityTheme72.chromecast = (ImageButton) dashboardActivityTheme72.findViewById(R.id.chromecast);
        dashboardActivityTheme72.searchIV = (ImageView) dashboardActivityTheme72.findViewById(R.id.searchIV);
        dashboardActivityTheme72.chatboat = (ImageView) dashboardActivityTheme72.findViewById(R.id.chatboat);
        dashboardActivityTheme72.tileRv = (RecyclerView) dashboardActivityTheme72.findViewById(R.id.tileRv);
        dashboardActivityTheme72.notificationIV = (ImageView) dashboardActivityTheme72.findViewById(R.id.notificationIV);
        dashboardActivityTheme72.testLL = (LinearLayout) dashboardActivityTheme72.findViewById(R.id.testLL);
        dashboardActivityTheme72.homeLL = (LinearLayout) dashboardActivityTheme72.findViewById(R.id.homeLL);
        dashboardActivityTheme72.navigationView = (NavigationView) dashboardActivityTheme72.findViewById(R.id.nav_view);
        dashboardActivityTheme72.drawer = (DrawerLayout) dashboardActivityTheme72.findViewById(R.id.drawer_layout);
        dashboardActivityTheme72.toolbar = (Toolbar) dashboardActivityTheme72.findViewById(R.id.feeds_toolbar);
        dashboardActivityTheme72.my_library = (CardView) dashboardActivityTheme72.findViewById(R.id.my_library);
        dashboardActivityTheme72.notificationLL = (RelativeLayout) dashboardActivityTheme72.findViewById(R.id.notificationLL);
        dashboardActivityTheme72.myTest = (CardView) dashboardActivityTheme72.findViewById(R.id.myTest);
        dashboardActivityTheme72.nav_headerLL = (LinearLayout) dashboardActivityTheme72.findViewById(R.id.nav_headerLL);
        dashboardActivityTheme72.updateProfileBtn = (ImageView) dashboardActivityTheme72.findViewById(R.id.updateProfileBtn);
        dashboardActivityTheme72.courseListRV = (RecyclerView) dashboardActivityTheme72.findViewById(R.id.courseListRV);
        dashboardActivityTheme72.tile_tv = (TextView) dashboardActivityTheme72.findViewById(R.id.tile_tv);
        dashboardActivityTheme72.navRV = (RecyclerView) dashboardActivityTheme72.findViewById(R.id.navRV);
        dashboardActivityTheme72.no_data_found_RL = (RelativeLayout) dashboardActivityTheme72.findViewById(R.id.no_data_found_RL);
        dashboardActivityTheme72.profileImage = (ImageView) dashboardActivityTheme72.findViewById(R.id.profileImage);
        dashboardActivityTheme72.profileImageText = (ImageView) dashboardActivityTheme72.findViewById(R.id.profileImageText);
        dashboardActivityTheme72.profileName = (TextView) dashboardActivityTheme72.findViewById(R.id.profileName);
        dashboardActivityTheme72.profileEmail = (TextView) dashboardActivityTheme72.findViewById(R.id.profileEmail);
        dashboardActivityTheme72.versionnameTV = (TextView) dashboardActivityTheme72.findViewById(R.id.vNameTV);
        dashboardActivityTheme72.main_rl = (LinearLayout) dashboardActivityTheme72.findViewById(R.id.main_rl);
        dashboardActivityTheme72.feeds_ll = (RelativeLayout) dashboardActivityTheme72.findViewById(R.id.feeds_ll);
        dashboardActivityTheme72.bannerSlider = (RecyclerView) dashboardActivityTheme72.findViewById(R.id.bannerSlider);
        dashboardActivityTheme72.paginationLoader = (ProgressBar) dashboardActivityTheme72.findViewById(R.id.progressBar);
        dashboardActivityTheme72.homeBackIV = (ImageView) dashboardActivityTheme72.findViewById(R.id.homeBackIV);
        dashboardActivityTheme72.changeInterfaceCV = (CardView) dashboardActivityTheme72.findViewById(R.id.changeInterfaceCV);
        dashboardActivityTheme72.no_data_found_RL_1 = (RelativeLayout) dashboardActivityTheme72.findViewById(R.id.no_data_found_RL_1);
        dashboardActivityTheme72.courseListRV.setLayoutManager(new LinearLayoutManager(dashboardActivityTheme72));
        new LinearSnapHelper().attachToRecyclerView(dashboardActivityTheme72.bannerSlider);
        FragmentManager supportFragmentManager = dashboardActivityTheme72.getSupportFragmentManager();
        dashboardActivityTheme72.fragmentManager = supportFragmentManager;
        supportFragmentManager.beginTransaction().setCustomAnimations(R.anim.activity_in, R.anim.activity_out, R.anim.activity_in, R.anim.activity_out);
        dashboardActivityTheme72.fragment = dashboardActivityTheme72.fragmentManager.findFragmentById(R.id.chatboat);
        AppUpdateManager appUpdateManagerCreate = AppUpdateManagerFactory.create(dashboardActivityTheme72);
        dashboardActivityTheme72.mAppUpdateManager = appUpdateManagerCreate;
        dashboardActivityTheme72.appUpdateInfoTask = appUpdateManagerCreate.getAppUpdateInfo();
        InstallStateUpdatedListener installStateUpdatedListener = new InstallStateUpdatedListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda4
            @Override // com.google.android.play.core.listener.StateUpdatedListener
            public final void onStateUpdate(InstallState installState) {
                this.f$0.lambda$onCreate$0(installState);
            }
        };
        dashboardActivityTheme72.installStateUpdatedListener = installStateUpdatedListener;
        dashboardActivityTheme72.mAppUpdateManager.registerListener(installStateUpdatedListener);
        dashboardActivityTheme72.inAppUpdateType = 0;
        dashboardActivityTheme72.checkAppUpdate();
        Data loggedInUser = SharedPreference.getInstance().getLoggedInUser();
        dashboardActivityTheme72.data = loggedInUser;
        MakeMyExam.userId = loggedInUser.getId();
        MakeMyExam.username = dashboardActivityTheme72.data.getName();
        FirebaseCrashlytics.getInstance().setUserId(MakeMyExam.userId);
        dashboardActivityTheme72.courselists.clear();
        dashboardActivityTheme72.backBtn.setVisibility(8);
        dashboardActivityTheme72.downarrowIV.setVisibility(8);
        dashboardActivityTheme72.searchIV.setVisibility(8);
        dashboardActivityTheme72.titleinnerRL.setClickable(false);
        dashboardActivityTheme72.toolbartitleTV.setText("Live Class");
        dashboardActivityTheme72.updateProfileBtn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$1();
            }
        }));
        if (dashboardActivityTheme72.getIntent() != null) {
            dashboardActivityTheme72.activityType = dashboardActivityTheme72.getIntent().getStringExtra("ActivityType");
            int intExtra = dashboardActivityTheme72.getIntent().getIntExtra(Const.NOTIFICATION_CODE, 0);
            dashboardActivityTheme72.notification_code = intExtra;
            if (intExtra != 0) {
                dashboardActivityTheme72.pushEventForPushNotification("" + dashboardActivityTheme72.notification_code);
            }
            dashboardActivityTheme72.course_id = dashboardActivityTheme72.getIntent().getStringExtra("course_id");
            dashboardActivityTheme72.post_id = dashboardActivityTheme72.getIntent().getStringExtra("post_id");
            dashboardActivityTheme72.banner_id = dashboardActivityTheme72.getIntent().getStringExtra(Const.BANNER_ID);
            dashboardActivityTheme72.fieldid = dashboardActivityTheme72.getIntent().getStringExtra("file_id");
            dashboardActivityTheme72.coupon_for = dashboardActivityTheme72.getIntent().getStringExtra("coupon_for");
            dashboardActivityTheme72.ts = dashboardActivityTheme72.getIntent().getLongExtra(CTProductConfigConstants.KEY_LAST_FETCHED_TIMESTAMP, 0L);
            dashboardActivityTheme72.audioTable = (AudioTable) dashboardActivityTheme72.getIntent().getSerializableExtra("audiotable");
            dashboardActivityTheme72.topicid = dashboardActivityTheme72.getIntent().getStringExtra(Const.TOPIC_ID);
            dashboardActivityTheme72.video_type = dashboardActivityTheme72.getIntent().getStringExtra("type");
            dashboardActivityTheme72.tiletype = dashboardActivityTheme72.getIntent().getStringExtra(Const.TILE_TYPE);
            dashboardActivityTheme72.tileid = dashboardActivityTheme72.getIntent().getStringExtra("tile_id");
            dashboardActivityTheme72.revertapi = dashboardActivityTheme72.getIntent().getStringExtra(Const.REVERT_API);
            dashboardActivityTheme72.type = dashboardActivityTheme72.getIntent().getStringExtra("type");
            dashboardActivityTheme72.title = dashboardActivityTheme72.getIntent().getStringExtra("title");
            dashboardActivityTheme72.message_target = dashboardActivityTheme72.getIntent().getStringExtra(TypedValues.AttributesType.S_TARGET);
            dashboardActivityTheme72.url = dashboardActivityTheme72.getIntent().getStringExtra("url");
            dashboardActivityTheme72.imageUrl = dashboardActivityTheme72.getIntent().getStringExtra("imageUrl");
            dashboardActivityTheme72.message = dashboardActivityTheme72.getIntent().getStringExtra("description");
            dashboardActivityTheme72.parentid = dashboardActivityTheme72.getIntent().getStringExtra(Const.shareparentid);
            dashboardActivityTheme72.contentType_id = dashboardActivityTheme72.getIntent().getStringExtra(Const.TAB_ID);
            String str4 = dashboardActivityTheme72.parentid;
            if (str4 == null) {
                str4 = "";
            }
            dashboardActivityTheme72.parentid = str4;
            int i = dashboardActivityTheme72.notification_code;
            if (i == 90002) {
                dashboardActivityTheme72.hit_api_for_data();
            } else if (i == 90001) {
                if (dashboardActivityTheme72.message_target.equalsIgnoreCase("6")) {
                    intent = new Intent(dashboardActivityTheme72, (Class<?>) WebFragActivity.class);
                    intent.putExtra("title", dashboardActivityTheme72.title);
                    intent.putExtra("url", dashboardActivityTheme72.url);
                    intent.putExtra("imageUrl", dashboardActivityTheme72.imageUrl);
                } else if (dashboardActivityTheme72.message_target.equalsIgnoreCase("2")) {
                    intent = new Intent(dashboardActivityTheme72, (Class<?>) CourseActivity.class);
                    intent.putExtra(Const.FRAG_TYPE, Const.SHOW_ALL_COURSES);
                    intent.putExtra(Const.COURSE_ID_MAIN, dashboardActivityTheme72.course_id);
                    intent.putExtra(Const.COURSE_PARENT_ID, "");
                    intent.putExtra(Const.IS_COMBO, false);
                    SharedPreference.getInstance().putString("id", dashboardActivityTheme72.course_id);
                } else if (dashboardActivityTheme72.message_target.equalsIgnoreCase("5")) {
                    intent = new Intent(dashboardActivityTheme72, (Class<?>) NotificationDescription.class);
                    intent.putExtra("urlType", "IMAGE");
                    intent.putExtra("title", dashboardActivityTheme72.title);
                    intent.putExtra("url", dashboardActivityTheme72.url);
                    intent.putExtra("imageUrl", dashboardActivityTheme72.imageUrl);
                    intent.putExtra("description", dashboardActivityTheme72.message);
                } else if (dashboardActivityTheme72.message_target.equalsIgnoreCase("1")) {
                    intent = new Intent(dashboardActivityTheme72, (Class<?>) WebFragActivity.class);
                    intent.putExtra("title", dashboardActivityTheme72.title);
                    intent.putExtra("url", dashboardActivityTheme72.message);
                    intent.putExtra("from", "noti");
                } else if (dashboardActivityTheme72.message_target.equalsIgnoreCase("8")) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    long j = dashboardActivityTheme72.ts;
                    if (jCurrentTimeMillis > j * 1000) {
                        if (dashboardActivityTheme72.coupon_for.equalsIgnoreCase("1")) {
                            Toast.makeText(dashboardActivityTheme72, "This coupon is available for all courses", 0).show();
                            dashboardActivityTheme72.initialzehomepage();
                        } else if (dashboardActivityTheme72.coupon_for.equalsIgnoreCase("0") || dashboardActivityTheme72.coupon_for.equalsIgnoreCase("2")) {
                            intent = new Intent(dashboardActivityTheme72, (Class<?>) CouponActivity.class);
                        } else {
                            intent = new Intent(dashboardActivityTheme72, (Class<?>) WebFragActivity.class);
                            intent.putExtra("title", dashboardActivityTheme72.title);
                            intent.putExtra("url", dashboardActivityTheme72.message);
                            intent.putExtra("from", "noti");
                        }
                    } else {
                        if (j != 0) {
                            Toast.makeText(dashboardActivityTheme72, "This coupon is available on " + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.US).format(new Date(dashboardActivityTheme72.ts * 1000))), 0).show();
                        }
                        dashboardActivityTheme72.initialzehomepage();
                    }
                    intent = null;
                } else {
                    intent = new Intent(dashboardActivityTheme72, (Class<?>) WebFragActivity.class);
                    intent.putExtra("title", dashboardActivityTheme72.title);
                    intent.putExtra("url", dashboardActivityTheme72.message);
                    intent.putExtra("from", "noti");
                }
                if (intent != null) {
                    Helper.gotoActivity(intent, dashboardActivityTheme72);
                }
            } else if (i == 123 || i == 124 || i == 125) {
                str = "1";
                dashboardActivityTheme72.hit_api_for_data();
            } else {
                AudioTable audioTable = dashboardActivityTheme72.audioTable;
                if (audioTable != null && audioTable.getVideo_id() != null && !dashboardActivityTheme72.audioTable.getVideo_id().equalsIgnoreCase("")) {
                    dashboardActivityTheme72.notification_code = 109010;
                    String str5 = dashboardActivityTheme72.video_type;
                    if (str5 != null && str5.equalsIgnoreCase("jw")) {
                        Intent intent2 = new Intent(dashboardActivityTheme72, (Class<?>) AudioPlayerActivty.class);
                        AudioPlayerService.videoid = "";
                        intent2.putExtra("url", dashboardActivityTheme72.audioTable.getAudio_url());
                        intent2.putExtra("videoid", dashboardActivityTheme72.audioTable.getVideo_id());
                        intent2.putExtra("currentpos", dashboardActivityTheme72.audioTable.getAudio_currentpos());
                        intent2.putExtra("video_name", dashboardActivityTheme72.audioTable.getVideo_name());
                        intent2.putExtra("image_url", dashboardActivityTheme72.audioTable.getJw_url() + "/poster.jpg?width=720");
                        intent2.putExtra("course_id", dashboardActivityTheme72.audioTable.getCourse_id());
                        Helper.gotoActivity(intent2, dashboardActivityTheme72);
                    }
                } else {
                    String str6 = dashboardActivityTheme72.video_type;
                    if (str6 != null && str6.contains("youtube_")) {
                        dashboardActivityTheme72.notification_code = 109010;
                        UserHistroyTable userHistroyTableUser_history = dashboardActivityTheme72.utkashRoom.getuserhistorydao().user_history(MakeMyExam.userId, dashboardActivityTheme72.getIntent().getStringExtra("type").split("_")[1]);
                        if (userHistroyTableUser_history != null) {
                            String str7 = "http://img.youtube.com/vi/" + userHistroyTableUser_history.getYoutube_url() + "/0.jpg";
                            if (userHistroyTableUser_history.getTileid() == null || userHistroyTableUser_history.getTileid().equalsIgnoreCase("")) {
                                str = "1";
                                Helper.GoToLiveVideoActivity("", dashboardActivityTheme72, userHistroyTableUser_history.getYoutube_url(), "1", userHistroyTableUser_history.getVideo_id(), userHistroyTableUser_history.getVideo_name(), "1", str7, "1", userHistroyTableUser_history.getCourse_id(), String.valueOf(1), dashboardActivityTheme72.parentid, dashboardActivityTheme72.tileid, "Video", new ArrayList());
                            } else {
                                str = "1";
                                Helper.GoToLiveVideoActivity("", dashboardActivityTheme72, userHistroyTableUser_history.getYoutube_url(), "1", userHistroyTableUser_history.getVideo_id(), userHistroyTableUser_history.getVideo_name(), "1", str7, "1", userHistroyTableUser_history.getCourse_id(), String.valueOf(1), dashboardActivityTheme72.parentid, userHistroyTableUser_history.getTileid(), "Video", new ArrayList());
                            }
                        } else {
                            str = "1";
                            dashboardActivityTheme72.initialzehomepage();
                        }
                    } else {
                        str = "1";
                        String str8 = dashboardActivityTheme72.video_type;
                        if (str8 != null && str8.contains("aws")) {
                            dashboardActivityTheme72.notification_code = 109010;
                            UserHistroyTable userHistroyTableUser_history2 = dashboardActivityTheme72.utkashRoom.getuserhistorydao().user_history(MakeMyExam.userId, dashboardActivityTheme72.getIntent().getStringExtra("type").split("_")[1]);
                            if (userHistroyTableUser_history2 != null) {
                                if (userHistroyTableUser_history2.getYoutube_url().split("ayush").length == 2) {
                                    dashboardActivityTheme7 = this;
                                    Helper.GoToLiveAwsVideoActivity("0", "", dashboardActivityTheme7, userHistroyTableUser_history2.getYoutube_url().split("ayush")[0], "0", userHistroyTableUser_history2.getVideo_id(), userHistroyTableUser_history2.getVideo_name(), "1", userHistroyTableUser_history2.getYoutube_url().split("ayush")[1], userHistroyTableUser_history2.getCourse_id(), userHistroyTableUser_history2.getTileid(), "Video", "1", "", dashboardActivityTheme72.parentid, new ArrayList());
                                } else {
                                    dashboardActivityTheme7 = this;
                                    Helper.GoToLiveAwsVideoActivity("0", "", dashboardActivityTheme7, userHistroyTableUser_history2.getYoutube_url().split("ayush")[0], "0", userHistroyTableUser_history2.getVideo_id(), userHistroyTableUser_history2.getVideo_name(), "1", "", userHistroyTableUser_history2.getCourse_id(), userHistroyTableUser_history2.getTileid(), "Video", "1", "", dashboardActivityTheme72.parentid, new ArrayList());
                                }
                                dashboardActivityTheme72 = dashboardActivityTheme7;
                            } else {
                                dashboardActivityTheme72.initialzehomepage();
                            }
                        } else {
                            int i2 = dashboardActivityTheme72.notification_code;
                            if (i2 == 0) {
                                if (Helper.isNetworkConnected(dashboardActivityTheme72)) {
                                    if (dashboardActivityTheme72.utkashRoom.getMasterAllCatDao().isRecordExistsUserId(MakeMyExam.userId)) {
                                        dashboardActivityTheme72.courseTypeMasterTables.clear();
                                        dashboardActivityTheme72.masterAllCatTables.clear();
                                        dashboardActivityTheme72.mastercatlist.clear();
                                        dashboardActivityTheme72.LanguagesTable.clear();
                                        dashboardActivityTheme72.bannerListTables.clear();
                                        dashboardActivityTheme72.bottomMenuTables.clear();
                                        AsyncTask.execute(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda20
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                this.f$0.lambda$onCreate$3();
                                            }
                                        });
                                    } else {
                                        dashboardActivityTheme72.hit_api_master_data();
                                    }
                                }
                            } else if (i2 == 101) {
                                dashboardActivityTheme72.checkdeeplick();
                            } else if (i2 == 1001001) {
                                String str9 = dashboardActivityTheme72.post_id;
                                if (str9 != null && !TextUtils.isEmpty(str9)) {
                                    Intent intent3 = new Intent(dashboardActivityTheme72, (Class<?>) FeedDetails.class);
                                    intent3.putExtra("postId", dashboardActivityTheme72.post_id);
                                    Helper.gotoActivity(intent3, dashboardActivityTheme72);
                                }
                            } else if (i2 == 1001010 && (str3 = dashboardActivityTheme72.banner_id) != null && !TextUtils.isEmpty(str3)) {
                                Intent intent4 = new Intent(dashboardActivityTheme72, (Class<?>) FeedViewPager.class);
                                intent4.putExtra("bannerId", dashboardActivityTheme72.banner_id);
                                Helper.gotoActivity(intent4, dashboardActivityTheme72);
                            }
                        }
                    }
                }
            }
            str = "1";
        } else {
            str = "1";
        }
        dashboardActivityTheme72.homeBackIV.setVisibility(8);
        dashboardActivityTheme72.setHomeDrawer();
        dashboardActivityTheme72.createMenus();
        ((ImageView) Objects.requireNonNull(dashboardActivityTheme72.profileImage)).setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$4();
            }
        }));
        dashboardActivityTheme72.homeBackIV.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$5();
            }
        }));
        dashboardActivityTheme72.chatboat.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$6(savedInstanceState);
            }
        }));
        dashboardActivityTheme72.profileLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme7.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (!Helper.isNetworkConnected(DashboardActivityTheme7.this)) {
                    Helper.showInternetToast(DashboardActivityTheme7.this);
                } else {
                    Helper.gotoActivity(DashboardActivityTheme7.this, (Class<?>) Notification.class);
                }
            }
        });
        dashboardActivityTheme72.my_library.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$7();
            }
        }));
        dashboardActivityTheme72.myTest.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$8();
            }
        }));
        dashboardActivityTheme72.notificationLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$9();
            }
        }));
        dashboardActivityTheme72.libLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$10();
            }
        }));
        dashboardActivityTheme72.livetest.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$11();
            }
        }));
        dashboardActivityTheme72.liveclassLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$12();
            }
        }));
        dashboardActivityTheme72.livetestLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$13();
            }
        }));
        dashboardActivityTheme72.changeInterfaceCV.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$14();
            }
        }));
        dashboardActivityTheme72.liveclass.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$15();
            }
        }));
        dashboardActivityTheme72.homeLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$16();
            }
        }));
        dashboardActivityTheme72.testLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$17();
            }
        }));
        dashboardActivityTheme72.filter.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$20();
            }
        }));
        dashboardActivityTheme72.scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme7.9
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                try {
                    int bottom = DashboardActivityTheme7.this.scrollView.getChildAt(DashboardActivityTheme7.this.scrollView.getChildCount() - 1).getBottom() - (DashboardActivityTheme7.this.scrollView.getHeight() + DashboardActivityTheme7.this.scrollView.getScrollY());
                    if (DashboardActivityTheme7.this.scrollView.getScrollY() == 0) {
                        DashboardActivityTheme7.this.pullToReferesh.setEnabled(true);
                    } else {
                        DashboardActivityTheme7.this.pullToReferesh.setEnabled(false);
                    }
                    if (bottom == 0 && DashboardActivityTheme7.this.notification_code == 0 && DashboardActivityTheme7.this.ispaginationavailable) {
                        if (!DashboardActivityTheme7.this.isfilterapply) {
                            if (DashboardActivityTheme7.this.utkashRoom.getHomeApiStatusdata().isRecordExistsUserId(MakeMyExam.userId, DashboardActivityTheme7.this.mastercatid + "_" + DashboardActivityTheme7.this.allcatindex_id + "_" + DashboardActivityTheme7.this.allsubcatindex_id + "_" + DashboardActivityTheme7.this.contentType_id)) {
                                HomeApiStatusTable homeApiStatusTable = DashboardActivityTheme7.this.utkashRoom.getHomeApiStatusdata().getcoursedetail(DashboardActivityTheme7.this.mastercatid + "_" + DashboardActivityTheme7.this.allcatindex_id + "_" + DashboardActivityTheme7.this.allsubcatindex_id + "_" + DashboardActivityTheme7.this.contentType_id, MakeMyExam.getUserId());
                                if (homeApiStatusTable.getStatus().equalsIgnoreCase("true")) {
                                    DashboardActivityTheme7.this.paginationLoader.setVisibility(0);
                                    DashboardActivityTheme7.this.pagecount = Integer.parseInt(homeApiStatusTable.getPage());
                                    DashboardActivityTheme7.this.pagecount++;
                                    DashboardActivityTheme7.this.getCourseData(false);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        DashboardActivityTheme7.this.pagecount++;
                        DashboardActivityTheme7.this.getCourseData(false);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
        dashboardActivityTheme72.chromecast.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$21();
            }
        }));
        dashboardActivityTheme72.searchIV.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$22();
            }
        }));
        dashboardActivityTheme72.filter_one_click.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$23();
            }
        }));
        LinearLayout linearLayout = (LinearLayout) dashboardActivityTheme72.findViewById(R.id.cartLL);
        dashboardActivityTheme72.cartLL = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme7.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Helper.gotoActivity(DashboardActivityTheme7.this, (Class<?>) DownloadActivity.class);
            }
        });
        dashboardActivityTheme72.downarrowIV.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$24();
            }
        }));
        dashboardActivityTheme72.filter_two_click.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$25();
            }
        }));
        dashboardActivityTheme72.pullToReferesh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme7.11
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                APITABLE apitable = DashboardActivityTheme7.this.utkashRoom.getapidao().getapidetail("ut_009", MakeMyExam.userId);
                if (Long.parseLong(apitable.getTimestamp()) + Long.parseLong(apitable.getInterval()) < System.currentTimeMillis() / 1000) {
                    DashboardActivityTheme7.this.utkashRoom.getLaunguages().deletedata();
                    DashboardActivityTheme7.this.utkashRoom.getMasterAllCatDao().deletedata();
                    DashboardActivityTheme7.this.utkashRoom.getMastercatDao().deletedata();
                    DashboardActivityTheme7.this.utkashRoom.getcoursetypemaster().deletedata();
                    DashboardActivityTheme7.this.pullrefresh = true;
                    DashboardActivityTheme7.this.initialState();
                    DashboardActivityTheme7.this.isfilterchanged = false;
                    DashboardActivityTheme7.this.subjectindex = "";
                    DashboardActivityTheme7.this.launguageindex = "";
                    DashboardActivityTheme7.this.SelectedLaunguageid = "";
                    DashboardActivityTheme7.this.SelectedSubjectid = "";
                    DashboardActivityTheme7.this.is_paid = "";
                    DashboardActivityTheme7.this.ispaginationavailable = false;
                    DashboardActivityTheme7.this.isfilterapply = false;
                    DashboardActivityTheme7.this.hit_api_master_data();
                    DashboardActivityTheme7.this.pullToReferesh.setRefreshing(false);
                    return;
                }
                DashboardActivityTheme7.this.pullToReferesh.setRefreshing(false);
            }
        });
        dashboardActivityTheme72.tileRv.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme7.12
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                DashboardActivityTheme7.this.toggleRefreshing(newState == 0);
            }
        });
        if (Helper.isNetworkConnected(dashboardActivityTheme72) || !dashboardActivityTheme72.utkashRoom.getthemeSettingdao().is_setting_exit() || (themeSettingsData = dashboardActivityTheme72.utkashRoom.getthemeSettingdao().data()) == null) {
            return;
        }
        LeftMenu leftMenu = (LeftMenu) new Gson().fromJson(themeSettingsData.getLeft_menu(), LeftMenu.class);
        BottomMenu bottomMenu = (BottomMenu) new Gson().fromJson(themeSettingsData.getBottom(), BottomMenu.class);
        if (leftMenu != null) {
            str2 = str;
            if (!leftMenu.getDownloads().equalsIgnoreCase(str2)) {
            }
            Helper.goToDownloadsOfflineMode(dashboardActivityTheme72);
        }
        str2 = str;
        if (bottomMenu == null || bottomMenu.getDownloads() == null || !bottomMenu.getDownloads().equalsIgnoreCase(str2)) {
            return;
        }
        Helper.goToDownloadsOfflineMode(dashboardActivityTheme72);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(InstallState installState) {
        if (installState.installStatus() == 11) {
            popupSnackbarForCompleteUpdate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$1() {
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
    public /* synthetic */ void lambda$onCreate$3() {
        try {
            if (!this.utkashRoom.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread()) {
                this.courseTypeMasterTables = this.utkashRoom.getcoursetypemaster().getcourse_typemaster(MakeMyExam.userId);
                this.masterAllCatTables = this.utkashRoom.getMasterAllCatDao().getmaster_allcat(MakeMyExam.userId);
                this.mastercatlist = this.utkashRoom.getMastercatDao().getmastercat(MakeMyExam.userId);
                this.LanguagesTable = this.utkashRoom.getLaunguages().getLaunguagedetail();
                this.bannerListTables = this.utkashRoom.getBannerTableDao().getBanner(MakeMyExam.getUserId());
                this.bottomMenuTables = this.utkashRoom.getBottomMenuTableDao().getBottomMenu(MakeMyExam.getUserId());
            }
            runOnUiThread(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda1
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
        if (this.leftMenu == null && this.hitMaster) {
            this.hitMaster = false;
            this.networkCall.NetworkAPICall(API.master_content, "", true, false);
            return;
        }
        this.cardsArrayList.clear();
        if (this.mastercatlist.size() > 0) {
            if ("1".equalsIgnoreCase("6")) {
                String string = SharedPreference.getInstance().getString("catName");
                for (int i = 0; i < this.mastercatlist.size(); i++) {
                    if (string.equalsIgnoreCase(this.mastercatlist.get(i).getCat())) {
                        this.mastercatname = this.mastercatlist.get(i).getCat();
                        this.mastercatid = this.mastercatlist.get(i).getId();
                    }
                }
            } else {
                this.mastercatid = this.mastercatlist.get(0).getId();
            }
        }
        for (CourseTypeMasterTable courseTypeMasterTable : this.courseTypeMasterTables) {
            if (courseTypeMasterTable.getName().equalsIgnoreCase("all")) {
                this.cardsArrayList.add(new Cards(courseTypeMasterTable.getId(), courseTypeMasterTable.getName(), Constants.BLACK, courseTypeMasterTable.getName(), "0#0#0#0#0#0", "0"));
            } else if (courseTypeMasterTable.getMaster_category_id().equalsIgnoreCase(this.mastercatid)) {
                this.cardsArrayList.add(new Cards(courseTypeMasterTable.getId(), courseTypeMasterTable.getName(), Constants.BLACK, courseTypeMasterTable.getName(), "0#0#0#0#0#0", "0"));
            }
        }
        if (this.cardsArrayList.size() > 0) {
            if (!this.is_test_series_clicked) {
                if (this.cardsArrayList.get(0).getTile_name().equalsIgnoreCase("all")) {
                    this.isAllClicked = true;
                } else {
                    this.isAllClicked = false;
                }
                getTileItems(this.cardsArrayList, 0);
            } else {
                getTileItems(this.cardsArrayList, 0);
            }
        } else {
            this.contentType = "";
            this.contentType_id = "";
            this.cardsArrayList.clear();
            this.tileItemsAdapter.notifyDataSetChanged();
        }
        selecteddata();
        List<BannerListTable> list = this.bannerListTables;
        if (list != null && list.size() > 0) {
            BannerAdapter bannerAdapter = new BannerAdapter(this, this.bannerListTables);
            this.bannerAdapter = bannerAdapter;
            this.sliderViewPager.setAdapter(bannerAdapter);
        }
        automateViewPagerSwiping();
        List<BannerListTable> list2 = this.bannerListTables;
        if (list2 != null && list2.size() > 0) {
            BottomBannerAdapter bottomBannerAdapter = new BottomBannerAdapter(this, this.bannerListTables, this);
            this.bottomBannerAdapter = bottomBannerAdapter;
            this.bottomSliderViewPager.setAdapter(bottomBannerAdapter);
        }
        automateBottomViewPagerSwiping();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$4() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, (Class<?>) ProfileActivity.class);
        if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.binding.drawerLayout.closeDrawer(GravityCompat.START);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$5() {
        onBackPressed();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$6(Bundle bundle) {
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
    public /* synthetic */ Unit lambda$onCreate$7() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Intent intent = new Intent(this, (Class<?>) MyLibraryActivty.class);
        intent.putExtra("toolbarTitle", Const.MYCOURSES);
        intent.putExtra("libraryType", "0");
        startActivity(intent);
        overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$8() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Intent intent = new Intent(this, (Class<?>) MyLibraryActivty.class);
        intent.putExtra("toolbarTitle", "My Purchased Test/Quiz");
        intent.putExtra("libraryType", "5");
        startActivity(intent);
        overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$9() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, (Class<?>) Notification.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$10() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, (Class<?>) MyLibraryActivty.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$11() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, (Class<?>) LivetestActivity.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$12() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, (Class<?>) LiveClassActivity.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$13() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, (Class<?>) LivetestActivity.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$14() {
        openChangeInterFaceDialog(this);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$15() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, (Class<?>) LiveClassActivity.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$16() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$17() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, CreateTestActivity.class, "1");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$20() {
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
            final com.appnew.android.home.model.FilterData.Data data = new com.appnew.android.home.model.FilterData.Data();
            AsyncTask.execute(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onCreate$19(data);
                }
            });
        } else {
            Filterdata filterdata = this.filterdata;
            if (filterdata != null && filterdata.getData() != null && this.filterdata.getData().getLanguages() != null) {
                this.filterdata = new Filterdata();
                com.appnew.android.home.model.FilterData.Data data2 = new com.appnew.android.home.model.FilterData.Data();
                data2.setSubjects((List) new Gson().fromJson(this.utkashRoom.getMasterAllCatDao().getfilteddata(this.allsubcatindex_id), new TypeToken<List<Subject>>() { // from class: com.appnew.android.Theme.DashboardActivityTheme7.8
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
    public /* synthetic */ void lambda$onCreate$19(com.appnew.android.home.model.FilterData.Data data) {
        data.setSubjects((ArrayList) new Gson().fromJson(this.utkashRoom.getMasterAllCatDao().getfilteddata(this.allsubcatindex_id), new TypeToken<ArrayList<Subject>>() { // from class: com.appnew.android.Theme.DashboardActivityTheme7.7
        }.getType()));
        data.setLanguages(this.LanguagesTable);
        this.filterdata.setData(data);
        runOnUiThread(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda35
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCreate$18();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$18() {
        openwatchlist_dailog_resource(this, this.filterdata.getData().getLanguages(), this.filterdata.getData().getSubjects());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$21() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.startCast(this);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$22() {
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
    public /* synthetic */ Unit lambda$onCreate$23() {
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
    public /* synthetic */ Unit lambda$onCreate$24() {
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
    public /* synthetic */ Unit lambda$onCreate$25() {
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

    private void openChangeInterFaceDialog(final Context context) {
        this.drawer.closeDrawer(GravityCompat.START);
        new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme7.13
            @Override // java.lang.Runnable
            public void run() {
                DashboardActivityTheme7.this.changeInterface = new BottomSheetDialog(context, R.style.videosheetDialogTheme);
                DashboardActivityTheme7.this.changeInterface.setContentView(R.layout.bottom_sheet);
                DashboardActivityTheme7.this.changeInterface.setCancelable(false);
                DashboardActivityTheme7.this.changeInterface.setCanceledOnTouchOutside(true);
                RecyclerView recyclerView = (RecyclerView) DashboardActivityTheme7.this.changeInterface.findViewById(R.id.streamItems);
                DashboardActivityTheme7 dashboardActivityTheme7 = DashboardActivityTheme7.this;
                BottomSheetAdapter bottomSheetAdapter = new BottomSheetAdapter(dashboardActivityTheme7, dashboardActivityTheme7.mastercatlist);
                recyclerView.setLayoutManager(new LinearLayoutManager(DashboardActivityTheme7.this));
                recyclerView.setAdapter(bottomSheetAdapter);
                DashboardActivityTheme7.this.changeInterface.show();
            }
        }, 200L);
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
        if ("1".equalsIgnoreCase("6")) {
            this.tileRv.setVisibility(cardsArrayList.size() != 0 ? 0 : 8);
        } else {
            this.tileRv.setVisibility(cardsArrayList.size() != 1 ? 0 : 8);
        }
        this.tileItemsAdapter = new TileItemsAdapter(this, this.contentType, cardsArrayList, this);
        this.tileRv.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.tileRv.setAdapter(this.tileItemsAdapter);
        this.tileRv.setNestedScrollingEnabled(false);
        this.tileRv.scrollToPosition(pos);
        this.tileRv.setItemAnimator(null);
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
        this.drawer.addDrawerListener(new DrawerLayout.DrawerListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme7.14
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
                Helper.HideKeyboard(DashboardActivityTheme7.this);
            }
        });
        ActionBarDrawerToggle actionBarDrawerToggle2 = new ActionBarDrawerToggle(this, this.drawer, this.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) { // from class: com.appnew.android.Theme.DashboardActivityTheme7.15
            @Override // androidx.appcompat.app.ActionBarDrawerToggle, androidx.drawerlayout.widget.DrawerLayout.DrawerListener
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override // androidx.appcompat.app.ActionBarDrawerToggle, androidx.drawerlayout.widget.DrawerLayout.DrawerListener
            public void onDrawerOpened(View drawerView) {
                String string = SharedPreference.getInstance().getString(Const.SERVER_TIME);
                if (TextUtils.isEmpty(string) || string.equals("0")) {
                    if (SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE).equalsIgnoreCase("") || SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE).equals("0")) {
                        DashboardActivityTheme7.this.networkCall.NetworkAPICall(API.IS_COUPON_AVAILABLE, "", false, false);
                    } else if (Integer.parseInt(SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE)) > 0) {
                        DashboardActivityTheme7.this.createMenus();
                    }
                } else if (Long.parseLong(string) <= System.currentTimeMillis()) {
                    DashboardActivityTheme7.this.networkCall.NetworkAPICall(API.IS_COUPON_AVAILABLE, "", false, false);
                }
                Helper.HideKeyboard(DashboardActivityTheme7.this);
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
        if (cards.getTile_name().equalsIgnoreCase("all")) {
            this.isAllClicked = true;
        } else {
            this.isAllClicked = false;
        }
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
                        this.courselists.add(new Courselist(courseDataTable.getCourse_id(), courseDataTable.getTitle(), courseDataTable.getCover_image(), courseDataTable.getMrp(), courseDataTable.getCourse_sp(), courseDataTable.getValidity(), courseDataTable.getSubject_id(), courseDataTable.getLang_id(), courseDataTable.getDesc_header_image(), courseDataTable.getExtra_json(), courseDataTable.getViewType(), "6"));
                    }
                    if (this.courselists.size() > 0) {
                        this.courseListRV.setVisibility(0);
                        this.no_data_found_RL.setVisibility(8);
                    } else {
                        this.courseListRV.setVisibility(8);
                        this.no_data_found_RL.setVisibility(0);
                    }
                    setTileDataAdapter(this.courselists, "");
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
                            this.courselists.add(new Courselist(courseDataTable2.getCourse_id(), courseDataTable2.getTitle(), courseDataTable2.getCover_image(), courseDataTable2.getMrp(), courseDataTable2.getCourse_sp(), courseDataTable2.getValidity(), courseDataTable2.getSubject_id(), courseDataTable2.getLang_id(), courseDataTable2.getDesc_header_image(), courseDataTable2.getExtra_json(), courseDataTable2.getViewType(), ""));
                        }
                        if (this.courselists.size() > 0) {
                            this.courseListRV.setVisibility(0);
                            this.no_data_found_RL.setVisibility(8);
                        } else {
                            this.courseListRV.setVisibility(8);
                            this.no_data_found_RL.setVisibility(0);
                        }
                        setTileDataAdapter(this.courselists, "");
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
            this.data = SharedPreference.getInstance().getLoggedInUser();
            this.mAppUpdateManager.getAppUpdateInfo().addOnSuccessListener(new OnSuccessListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda29
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    this.f$0.lambda$onResume$26((AppUpdateInfo) obj);
                }
            });
            this.mAppUpdateManager.getAppUpdateInfo().addOnSuccessListener(new OnSuccessListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda30
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    this.f$0.lambda$onResume$27((AppUpdateInfo) obj);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.utkashRoom.getapidao().getapidetail("ut_009", MakeMyExam.userId);
        this.utkashRoom.getLaunguages().deletedata();
        this.utkashRoom.getMasterAllCatDao().deletedata();
        this.utkashRoom.getMastercatDao().deletedata();
        this.utkashRoom.getcoursetypemaster().deletedata();
        this.pullrefresh = true;
        initialState();
        this.isfilterchanged = false;
        this.subjectindex = "";
        this.launguageindex = "";
        this.SelectedLaunguageid = "";
        this.SelectedSubjectid = "";
        this.is_paid = "";
        this.ispaginationavailable = false;
        this.isfilterapply = false;
        hit_api_master_data();
        homeAutoRefresh();
        try {
            Data loggedInUser = SharedPreference.getInstance().getLoggedInUser();
            if (loggedInUser.getProfilePicture() != null) {
                this.profileImage.setVisibility(0);
                Glide.with((FragmentActivity) this).load(loggedInUser.getProfilePicture()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.course_placeholder)).into(this.profileImage);
            } else {
                this.profileImage.setVisibility(0);
                this.profileImageText.setVisibility(8);
                this.profileImage.setImageResource(R.mipmap.default_pic);
            }
            if (TextUtils.isEmpty(loggedInUser.getName()) || TextUtils.isEmpty(loggedInUser.getMobile())) {
                this.profileName.setText("User");
                this.profileEmail.setText("user@gmail.com");
            } else {
                this.profileName.setText("Welcome, " + loggedInUser.getName());
                this.profileEmail.setText(loggedInUser.getMobile());
            }
            String string = SharedPreference.getInstance().getString("catName");
            if (!this.is_test_series_clicked) {
                if (SharedPreference.getInstance().getString("catName") == null || TextUtils.isEmpty(SharedPreference.getInstance().getString("catName"))) {
                    setMasterCatData(this.mastercatlist.get(0).getCat(), 0);
                    return;
                } else {
                    setMasterCatData(SharedPreference.getInstance().getString("catName"), 0);
                    return;
                }
            }
            if (!TextUtils.isEmpty(string)) {
                setMasterCatData(string, 2);
            } else {
                if (SharedPreference.getInstance().getString("catName") == null || TextUtils.isEmpty(SharedPreference.getInstance().getString("catName"))) {
                    return;
                }
                setMasterCatData(SharedPreference.getInstance().getString("catName"), 2);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$26(AppUpdateInfo appUpdateInfo) {
        if (appUpdateInfo.updateAvailability() == 3) {
            try {
                this.mAppUpdateManager.startUpdateFlowForResult(appUpdateInfo, this.inAppUpdateType, this, this.RC_APP_UPDATE);
            } catch (IntentSender.SendIntentException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$27(AppUpdateInfo appUpdateInfo) {
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
        if (requestCode == 1000 && data != null && resultCode == 1000 && data.getBooleanExtra("fromDownloads", false)) {
            refreshApiFromDownloads();
        }
    }

    private void popupSnackbarForCompleteUpdate() {
        try {
            Snackbar snackbarMake = Snackbar.make(this.liveclass, "An update has just been downloaded.", -2);
            snackbarMake.setAction("RESTART", new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda36
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$popupSnackbarForCompleteUpdate$28(view);
                }
            });
            snackbarMake.show();
        } catch (Resources.NotFoundException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$popupSnackbarForCompleteUpdate$28(View view) {
        this.mAppUpdateManager.completeUpdate();
    }

    private void checkAppUpdate() {
        try {
            this.appUpdateInfoTask.addOnSuccessListener(new OnSuccessListener<AppUpdateInfo>() { // from class: com.appnew.android.Theme.DashboardActivityTheme7.16
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public void onSuccess(AppUpdateInfo appUpdateInfo) {
                    if (appUpdateInfo.updateAvailability() == 2 && appUpdateInfo.isUpdateTypeAllowed(DashboardActivityTheme7.this.inAppUpdateType)) {
                        try {
                            AppUpdateManager appUpdateManager = DashboardActivityTheme7.this.mAppUpdateManager;
                            int i = DashboardActivityTheme7.this.inAppUpdateType;
                            DashboardActivityTheme7 dashboardActivityTheme7 = DashboardActivityTheme7.this;
                            appUpdateManager.startUpdateFlowForResult(appUpdateInfo, i, dashboardActivityTheme7, dashboardActivityTheme7.RC_APP_UPDATE);
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
        Data loggedInUser = SharedPreference.getInstance().getLoggedInUser();
        if (loggedInUser.getProfilePicture() != null) {
            this.profileImage.setVisibility(0);
            Glide.with((FragmentActivity) this).load(loggedInUser.getProfilePicture()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.course_placeholder)).into(this.profileImage);
        } else {
            this.profileImage.setVisibility(0);
            this.profileImageText.setVisibility(8);
            this.profileImage.setImageResource(R.mipmap.default_pic);
        }
        if (!TextUtils.isEmpty(loggedInUser.getName()) && !TextUtils.isEmpty(loggedInUser.getMobile())) {
            this.profileName.setText("Welcome, " + loggedInUser.getName());
            this.profileEmail.setText(loggedInUser.getMobile());
        } else {
            this.profileName.setText("User");
            this.profileEmail.setText("user@gmail.com");
        }
        this.versionnameTV.setText(Html.fromHtml("<b>Version- </b>" + Helper.getVersionName(this)));
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
            leftNavAdapter.setLeftNavAdapterListener(new LeftNavAdapter.LeftNavAdapterListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme7.17
                @Override // com.appnew.android.home.adapters.LeftNavAdapter.LeftNavAdapterListener
                public void onItemClick(Menu menu) {
                    if (menu.getHaveChild().equalsIgnoreCase("1")) {
                        menu.setExpanded(!menu.isExpanded());
                    }
                    DashboardActivityTheme7.this.handleLeftMenuClick(menu);
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
                case 1599:
                    if (type_code.equals("21")) {
                        b2 = Ascii.DC4;
                    }
                    break;
                case 1603:
                    if (type_code.equals("25")) {
                        b2 = Ascii.NAK;
                    }
                    break;
                case 1605:
                    if (type_code.equals(Constants.LEFT_NAV_KEY.bookmark)) {
                        b2 = Ascii.SYN;
                    }
                    break;
                case 1823:
                    if (type_code.equals(Constants.LEFT_NAV_KEY.book_store)) {
                        b2 = Ascii.ETB;
                    }
                    break;
                case NewHope.SENDA_BYTES /* 1824 */:
                    if (type_code.equals(Constants.LEFT_NAV_KEY.custom_payment)) {
                        b2 = Ascii.CAN;
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
                        intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.app_name));
                        intent.putExtra("android.intent.extra.TEXT", (("\nI recommend you to learn from next-gen Smart courses. Uncover a whole new way of learning with " + getString(R.string.app_name) + ". Learn, practice & create custom tests and much more. Download ") + "https://play.google.com/store/apps/details?id=com.eduteria.app.app") + " and start learning now");
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
                        getLogoutDialog(this, getString(R.string.logout_title), getString(R.string.logout_confirmation_message));
                    }
                    if (this.drawer.isDrawerOpen(GravityCompat.START)) {
                        this.drawer.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 9:
                    Intent intent2 = new Intent(this, (Class<?>) WebViewActivty.class);
                    intent2.putExtra("type", "Terms of Service");
                    intent2.putExtra("url", API.TERMS_AND_CONDITIONS);
                    Helper.gotoActivity(intent2, this);
                    break;
                case 10:
                    try {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + getPackageName())));
                    } catch (ActivityNotFoundException unused2) {
                        return;
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
                        Intent intent3 = new Intent(this, (Class<?>) WebViewActivty.class);
                        intent3.putExtra("type", "OFFLINE BATCH");
                        intent3.putExtra("url", "https://courses.utkarsh.com/offlineadmission/home.php");
                        startActivity(intent3);
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
                        Helper.showToast(this, "Still in Development.", 0);
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
                case 20:
                    Intent intent4 = new Intent(this, (Class<?>) WebViewActivty.class);
                    intent4.putExtra("type", Const.PRIVACY);
                    intent4.putExtra("url", API.PRIVACY_POLICY_URL);
                    Helper.gotoActivity(intent4, this);
                    break;
                case 21:
                    Intent intent5 = new Intent(this, (Class<?>) CurrentAffairActivity.class);
                    intent5.putExtra("title_key", "Current Affair");
                    startActivity(intent5);
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 22:
                    Intent intent6 = new Intent(this, (Class<?>) BookMarkList.class);
                    intent6.putExtra("title_key", "Bookmark");
                    startActivity(intent6);
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 23:
                    if (this.drawer.isDrawerOpen(GravityCompat.START)) {
                        this.drawer.closeDrawer(GravityCompat.START);
                    }
                    if (this.leftMenu.getBook_store_link() != null && !this.leftMenu.getBook_store_link().equalsIgnoreCase("")) {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.leftMenu.getBook_store_link())));
                        break;
                    }
                    break;
                case 24:
                    Intent intent7 = new Intent(this, (Class<?>) CustomPaymentActivity.class);
                    intent7.putExtra("type", "Custom Payment");
                    intent7.putExtra("courseid", this.leftMenu.getCustom_course());
                    Helper.gotoActivity(intent7, this);
                    break;
            }
        }
    }

    private void hit_api_for_filter() {
        this.networkCall.NetworkAPICall(API.get_filter_data, "", true, false);
    }

    public void getLogoutDialog(final Activity ctx, final String title, final String message) {
        DialogUtils.makeDialog(this, title, message, getResources().getString(R.string.yes), getResources().getString(R.string.no), true, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Theme.DashboardActivityTheme7.18
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
            public void onOKClick() {
                if (Helper.isConnected(DashboardActivityTheme7.this)) {
                    DashboardActivityTheme7.this.UserLogout();
                } else {
                    Toast.makeText(DashboardActivityTheme7.this, "No Internet connection", 0).show();
                }
            }
        }, new DialogUtils.onDialogUtilsCancelClick() { // from class: com.appnew.android.Theme.DashboardActivityTheme7.19
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
            intent.putExtra(Const.FRAG_TYPE, Const.SHOW_ALL_COURSES);
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
        intent2.putExtra(Const.FRAG_TYPE, Const.SHOW_ALL_COURSES);
        intent2.putExtra(Const.COURSE_ID_MAIN, this.parentid);
        intent2.putExtra(Const.COURSE_PARENT_ID, "");
        intent2.putExtra(Const.IS_COMBO, false);
        startActivity(intent2);
        SharedPreference.getInstance().putString("maincourseid", "");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0554 A[Catch: Exception -> 0x074f, TryCatch #1 {Exception -> 0x074f, blocks: (B:48:0x00a8, B:50:0x00ac, B:52:0x00b2, B:53:0x00b7, B:56:0x00c3, B:58:0x00d4, B:61:0x0141, B:63:0x0147, B:65:0x014d, B:66:0x0154, B:68:0x016f, B:70:0x018e, B:72:0x0192, B:74:0x01a0, B:76:0x01db, B:87:0x0362, B:89:0x0366, B:91:0x036f, B:92:0x0377, B:94:0x037d, B:96:0x03bc, B:106:0x0550, B:108:0x0554, B:110:0x0591, B:112:0x0596, B:114:0x059c, B:109:0x0573, B:98:0x045c, B:100:0x0466, B:101:0x046e, B:103:0x0474, B:105:0x04b3, B:77:0x021e, B:78:0x0274, B:80:0x02af, B:81:0x02f1, B:82:0x0346, B:84:0x0354, B:86:0x035f, B:116:0x05a9, B:118:0x05ad, B:120:0x05b2, B:122:0x05b6, B:124:0x061a, B:126:0x0628, B:60:0x00fc, B:128:0x0638, B:130:0x063c, B:132:0x0677, B:133:0x06b6, B:134:0x0707, B:136:0x0710, B:138:0x0716, B:139:0x071d, B:141:0x0721, B:143:0x0726, B:144:0x0736, B:146:0x073c, B:148:0x0742, B:149:0x0746), top: B:450:0x00a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0573 A[Catch: Exception -> 0x074f, TryCatch #1 {Exception -> 0x074f, blocks: (B:48:0x00a8, B:50:0x00ac, B:52:0x00b2, B:53:0x00b7, B:56:0x00c3, B:58:0x00d4, B:61:0x0141, B:63:0x0147, B:65:0x014d, B:66:0x0154, B:68:0x016f, B:70:0x018e, B:72:0x0192, B:74:0x01a0, B:76:0x01db, B:87:0x0362, B:89:0x0366, B:91:0x036f, B:92:0x0377, B:94:0x037d, B:96:0x03bc, B:106:0x0550, B:108:0x0554, B:110:0x0591, B:112:0x0596, B:114:0x059c, B:109:0x0573, B:98:0x045c, B:100:0x0466, B:101:0x046e, B:103:0x0474, B:105:0x04b3, B:77:0x021e, B:78:0x0274, B:80:0x02af, B:81:0x02f1, B:82:0x0346, B:84:0x0354, B:86:0x035f, B:116:0x05a9, B:118:0x05ad, B:120:0x05b2, B:122:0x05b6, B:124:0x061a, B:126:0x0628, B:60:0x00fc, B:128:0x0638, B:130:0x063c, B:132:0x0677, B:133:0x06b6, B:134:0x0707, B:136:0x0710, B:138:0x0716, B:139:0x071d, B:141:0x0721, B:143:0x0726, B:144:0x0736, B:146:0x073c, B:148:0x0742, B:149:0x0746), top: B:450:0x00a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0596 A[Catch: Exception -> 0x074f, TryCatch #1 {Exception -> 0x074f, blocks: (B:48:0x00a8, B:50:0x00ac, B:52:0x00b2, B:53:0x00b7, B:56:0x00c3, B:58:0x00d4, B:61:0x0141, B:63:0x0147, B:65:0x014d, B:66:0x0154, B:68:0x016f, B:70:0x018e, B:72:0x0192, B:74:0x01a0, B:76:0x01db, B:87:0x0362, B:89:0x0366, B:91:0x036f, B:92:0x0377, B:94:0x037d, B:96:0x03bc, B:106:0x0550, B:108:0x0554, B:110:0x0591, B:112:0x0596, B:114:0x059c, B:109:0x0573, B:98:0x045c, B:100:0x0466, B:101:0x046e, B:103:0x0474, B:105:0x04b3, B:77:0x021e, B:78:0x0274, B:80:0x02af, B:81:0x02f1, B:82:0x0346, B:84:0x0354, B:86:0x035f, B:116:0x05a9, B:118:0x05ad, B:120:0x05b2, B:122:0x05b6, B:124:0x061a, B:126:0x0628, B:60:0x00fc, B:128:0x0638, B:130:0x063c, B:132:0x0677, B:133:0x06b6, B:134:0x0707, B:136:0x0710, B:138:0x0716, B:139:0x071d, B:141:0x0721, B:143:0x0726, B:144:0x0736, B:146:0x073c, B:148:0x0742, B:149:0x0746), top: B:450:0x00a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x059c A[Catch: Exception -> 0x074f, TryCatch #1 {Exception -> 0x074f, blocks: (B:48:0x00a8, B:50:0x00ac, B:52:0x00b2, B:53:0x00b7, B:56:0x00c3, B:58:0x00d4, B:61:0x0141, B:63:0x0147, B:65:0x014d, B:66:0x0154, B:68:0x016f, B:70:0x018e, B:72:0x0192, B:74:0x01a0, B:76:0x01db, B:87:0x0362, B:89:0x0366, B:91:0x036f, B:92:0x0377, B:94:0x037d, B:96:0x03bc, B:106:0x0550, B:108:0x0554, B:110:0x0591, B:112:0x0596, B:114:0x059c, B:109:0x0573, B:98:0x045c, B:100:0x0466, B:101:0x046e, B:103:0x0474, B:105:0x04b3, B:77:0x021e, B:78:0x0274, B:80:0x02af, B:81:0x02f1, B:82:0x0346, B:84:0x0354, B:86:0x035f, B:116:0x05a9, B:118:0x05ad, B:120:0x05b2, B:122:0x05b6, B:124:0x061a, B:126:0x0628, B:60:0x00fc, B:128:0x0638, B:130:0x063c, B:132:0x0677, B:133:0x06b6, B:134:0x0707, B:136:0x0710, B:138:0x0716, B:139:0x071d, B:141:0x0721, B:143:0x0726, B:144:0x0736, B:146:0x073c, B:148:0x0742, B:149:0x0746), top: B:450:0x00a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0366 A[Catch: Exception -> 0x074f, TryCatch #1 {Exception -> 0x074f, blocks: (B:48:0x00a8, B:50:0x00ac, B:52:0x00b2, B:53:0x00b7, B:56:0x00c3, B:58:0x00d4, B:61:0x0141, B:63:0x0147, B:65:0x014d, B:66:0x0154, B:68:0x016f, B:70:0x018e, B:72:0x0192, B:74:0x01a0, B:76:0x01db, B:87:0x0362, B:89:0x0366, B:91:0x036f, B:92:0x0377, B:94:0x037d, B:96:0x03bc, B:106:0x0550, B:108:0x0554, B:110:0x0591, B:112:0x0596, B:114:0x059c, B:109:0x0573, B:98:0x045c, B:100:0x0466, B:101:0x046e, B:103:0x0474, B:105:0x04b3, B:77:0x021e, B:78:0x0274, B:80:0x02af, B:81:0x02f1, B:82:0x0346, B:84:0x0354, B:86:0x035f, B:116:0x05a9, B:118:0x05ad, B:120:0x05b2, B:122:0x05b6, B:124:0x061a, B:126:0x0628, B:60:0x00fc, B:128:0x0638, B:130:0x063c, B:132:0x0677, B:133:0x06b6, B:134:0x0707, B:136:0x0710, B:138:0x0716, B:139:0x071d, B:141:0x0721, B:143:0x0726, B:144:0x0736, B:146:0x073c, B:148:0x0742, B:149:0x0746), top: B:450:0x00a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x045c A[Catch: Exception -> 0x074f, TryCatch #1 {Exception -> 0x074f, blocks: (B:48:0x00a8, B:50:0x00ac, B:52:0x00b2, B:53:0x00b7, B:56:0x00c3, B:58:0x00d4, B:61:0x0141, B:63:0x0147, B:65:0x014d, B:66:0x0154, B:68:0x016f, B:70:0x018e, B:72:0x0192, B:74:0x01a0, B:76:0x01db, B:87:0x0362, B:89:0x0366, B:91:0x036f, B:92:0x0377, B:94:0x037d, B:96:0x03bc, B:106:0x0550, B:108:0x0554, B:110:0x0591, B:112:0x0596, B:114:0x059c, B:109:0x0573, B:98:0x045c, B:100:0x0466, B:101:0x046e, B:103:0x0474, B:105:0x04b3, B:77:0x021e, B:78:0x0274, B:80:0x02af, B:81:0x02f1, B:82:0x0346, B:84:0x0354, B:86:0x035f, B:116:0x05a9, B:118:0x05ad, B:120:0x05b2, B:122:0x05b6, B:124:0x061a, B:126:0x0628, B:60:0x00fc, B:128:0x0638, B:130:0x063c, B:132:0x0677, B:133:0x06b6, B:134:0x0707, B:136:0x0710, B:138:0x0716, B:139:0x071d, B:141:0x0721, B:143:0x0726, B:144:0x0736, B:146:0x073c, B:148:0x0742, B:149:0x0746), top: B:450:0x00a8 }] */
    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void SuccessCallBack(org.json.JSONObject r25, java.lang.String r26, java.lang.String r27, boolean r28) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 4556
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Theme.DashboardActivityTheme7.SuccessCallBack(org.json.JSONObject, java.lang.String, java.lang.String, boolean):void");
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

    private void setTileDataAdapter(ArrayList<Courselist> courselists, String isBook) {
        ArrayList arrayList = new ArrayList();
        if (this.isAllClicked) {
            for (Courselist courselist : courselists) {
                if (!courselist.getViewType().equalsIgnoreCase("5") && !courselist.getMrp().equalsIgnoreCase("0")) {
                    arrayList.add(courselist);
                }
            }
            if (arrayList.size() > 0) {
                TileDataAdapter2 tileDataAdapter2 = new TileDataAdapter2(this, arrayList, "");
                this.TileDataAdapter2 = tileDataAdapter2;
                this.courseListRV.setAdapter(tileDataAdapter2);
                this.courseListRV.setNestedScrollingEnabled(false);
                this.TileDataAdapter2.notifyDataSetChanged();
                return;
            }
            this.courseListRV.setVisibility(8);
            this.no_data_found_RL.setVisibility(0);
            return;
        }
        if (courselists.size() > 0) {
            TileDataAdapter2 tileDataAdapter22 = new TileDataAdapter2(this, courselists, "");
            this.TileDataAdapter2 = tileDataAdapter22;
            this.courseListRV.setAdapter(tileDataAdapter22);
            this.courseListRV.setNestedScrollingEnabled(false);
            this.TileDataAdapter2.notifyDataSetChanged();
            return;
        }
        this.courseListRV.setVisibility(8);
        this.no_data_found_RL.setVisibility(0);
    }

    private void showPopUp(final InstructionData instructionData) {
        Dialog dialog;
        CheckBox checkBox;
        int i;
        View viewInflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.popup_basicinfo_quiz_career, (ViewGroup) null, false);
        Dialog dialog2 = new Dialog(this, R.style.CustomAlertDialog);
        dialog2.requestWindowFeature(1);
        dialog2.setCanceledOnTouchOutside(true);
        dialog2.setContentView(viewInflate);
        dialog2.getWindow().setLayout(-1, -1);
        dialog2.show();
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
        Button button = (Button) viewInflate.findViewById(R.id.startQuizBtn);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.sectionListLL);
        LinearLayout linearLayout2 = (LinearLayout) viewInflate.findViewById(R.id.general_layout);
        LinearLayout linearLayout3 = (LinearLayout) viewInflate.findViewById(R.id.section_time);
        if (TextUtils.isEmpty(testBasic.getLang_id())) {
            dialog = dialog2;
        } else {
            dialog = dialog2;
            this.langIds = testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA);
        }
        if (testBasic.getTest_assets() != null) {
            checkBox = checkBox2;
            if (testBasic.getTest_assets().getHide_inst_time().equalsIgnoreCase("0")) {
                linearLayout3.setVisibility(0);
            } else {
                linearLayout3.setVisibility(4);
            }
        } else {
            checkBox = checkBox2;
        }
        addSectionView(linearLayout, instructionData);
        if (SharedPreference.getInstance().getBoolean(Const.RE_ATTEMPT)) {
            textView7.setVisibility(8);
        } else {
            textView7.setVisibility(8);
        }
        if (testBasic.getLang_id().length() == 3) {
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme7.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DashboardActivityTheme7.this.showPopMenuForLangauge(textView5, testBasic);
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
            i = 0;
        } else {
            i = 0;
            linearLayout2.setVisibility(0);
            textView8.setText(Html.fromHtml(testBasic.getDescription()));
        }
        button.setTag(testBasic);
        final Dialog dialog3 = dialog;
        final CheckBox checkBox3 = checkBox;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showPopUp$29(testBasic, checkBox3, dialog3, view);
            }
        });
        dialog3.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme7.22
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialog4, int keyCode, KeyEvent event) {
                if (keyCode != 4) {
                    return true;
                }
                DashboardActivityTheme7.this.initialzehomepage();
                dialog3.dismiss();
                return true;
            }
        });
        ArrayList arrayList = new ArrayList();
        int i2 = i;
        for (TestSectionInst testSectionInst : instructionData.getTestSections()) {
            if (!arrayList.isEmpty() && ((TestSectionInst) arrayList.get(i - 1)).getSectionId().equalsIgnoreCase(testSectionInst.getSectionId())) {
                arrayList.add(testSectionInst);
            } else {
                i2++;
                arrayList.add(testSectionInst);
            }
            i++;
        }
        textView4.setText("" + i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPopUp$29(TestBasicInst testBasicInst, CheckBox checkBox, Dialog dialog, View view) {
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
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (TestSectionInst testSectionInst : instructionData.getTestSections()) {
            String sectionId = testSectionInst.getSectionId();
            float f2 = Float.parseFloat(testSectionInst.getSectionTiming());
            if (map.containsKey(sectionId)) {
                map.put(sectionId, Float.valueOf(((Float) map.get(sectionId)).floatValue() + f2));
            } else {
                map.put(sectionId, Float.valueOf(f2));
            }
        }
        int i = 0;
        for (TestSectionInst testSectionInst2 : instructionData.getTestSections()) {
            String hide_inst_time = "";
            if (!arrayList.isEmpty() && ((TestSectionInst) arrayList.get(i - 1)).getSectionId().equalsIgnoreCase(testSectionInst2.getSectionId())) {
                testSectionInst2.setName("");
                testSectionInst2.setSectionTiming("");
                arrayList.add(testSectionInst2);
            } else {
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    float fFloatValue = ((Float) entry.getValue()).floatValue();
                    if (str.equalsIgnoreCase(testSectionInst2.getSectionId())) {
                        testSectionInst2.setSectionTiming(String.valueOf(fFloatValue));
                    }
                }
                arrayList.add(testSectionInst2);
            }
            if (instructionData.getTestBasic().getTest_assets() != null) {
                hide_inst_time = instructionData.getTestBasic().getTest_assets().getHide_inst_time();
            }
            sectionListLL.addView(initSectionListView(testSectionInst2, i, hide_inst_time));
            i++;
        }
    }

    public LinearLayout initSectionListView(TestSectionInst testSectionInst, int tag, String hide_inst_time) {
        String string;
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
        if ((BuildConfig.FLAVOR.equalsIgnoreCase("mahendra") || BuildConfig.FLAVOR.equalsIgnoreCase("resodigital")) && !TextUtils.isEmpty(testSectionInst.getSection_aliase())) {
            string = testSectionInst.getSection_aliase().toString();
        } else if (!TextUtils.isEmpty(testSectionInst.getSectionPart())) {
            string = testSectionInst.getName() + "\n(" + testSectionInst.getSectionPart() + ")";
        } else {
            string = testSectionInst.getName();
        }
        textView.setText(string);
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

    public void showPopMenuForLangauge(final View v, TestBasicInst testBasicInst) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme7.23
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem item) {
                ((TextView) v).setText(item.getTitle().toString());
                if (item.getTitle().toString().equals(DashboardActivityTheme7.this.getString(R.string.hindi))) {
                    DashboardActivityTheme7.this.lang = 2;
                    return false;
                }
                if (!item.getTitle().toString().equals(DashboardActivityTheme7.this.getString(R.string.english))) {
                    return false;
                }
                DashboardActivityTheme7.this.lang = 1;
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:117:0x06e2  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x05a4  */
    /* JADX WARN: Type inference failed for: r1v113 */
    /* JADX WARN: Type inference failed for: r1v117 */
    /* JADX WARN: Type inference failed for: r1v118 */
    /* JADX WARN: Type inference failed for: r1v119 */
    /* JADX WARN: Type inference failed for: r1v120 */
    /* JADX WARN: Type inference failed for: r1v121 */
    /* JADX WARN: Type inference failed for: r1v122 */
    /* JADX WARN: Type inference failed for: r1v123 */
    /* JADX WARN: Type inference failed for: r1v64 */
    /* JADX WARN: Type inference failed for: r1v83, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void initLivevideo(com.appnew.android.Model.Video r59) {
        /*
            Method dump skipped, instruction units count: 2947
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Theme.DashboardActivityTheme7.initLivevideo(com.appnew.android.Model.Video):void");
    }

    private void manageVisibility() {
        this.viewPagerRL.setVisibility(8);
        this.bottomViewPagerRL.setVisibility(8);
        if (this.bottomSetting.getMy_library() != null && this.bottomSetting.getMy_library().equalsIgnoreCase("1")) {
            this.ll_top.setVisibility(0);
        } else {
            this.ll_top.setVisibility(8);
        }
        if (this.bottomSetting.getTop_banner() == null || this.bottomSetting.getTop_banner().equalsIgnoreCase("1")) {
            this.viewPagerRL.setVisibility(8);
        } else {
            this.viewPagerRL.setVisibility(8);
        }
        if (this.bottomSetting.getBottom_banner() != null && this.bottomSetting.getBottom_banner().equalsIgnoreCase("1")) {
            this.bottomViewPagerRL.setVisibility(8);
        } else {
            this.bottomViewPagerRL.setVisibility(8);
        }
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
                                this.courselists.add(new Courselist(courseDataTable.getCourse_id(), courseDataTable.getTitle(), courseDataTable.getCover_image(), courseDataTable.getMrp(), courseDataTable.getCourse_sp(), courseDataTable.getValidity(), courseDataTable.getSubject_id(), courseDataTable.getLang_id(), courseDataTable.getDesc_header_image(), courseDataTable.getExtra_json(), courseDataTable.getViewType(), "6"));
                            }
                            if (this.courselists.size() > 0) {
                                this.courseListRV.setVisibility(0);
                                this.no_data_found_RL.setVisibility(8);
                            } else {
                                this.courseListRV.setVisibility(8);
                                this.no_data_found_RL.setVisibility(0);
                            }
                            setTileDataAdapter(this.courselists, "");
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
                                    this.courselists.add(new Courselist(courseDataTable2.getCourse_id(), courseDataTable2.getTitle(), courseDataTable2.getCover_image(), courseDataTable2.getMrp(), courseDataTable2.getCourse_sp(), courseDataTable2.getValidity(), courseDataTable2.getSubject_id(), courseDataTable2.getLang_id(), courseDataTable2.getDesc_header_image(), courseDataTable2.getExtra_json(), courseDataTable2.getViewType(), "6"));
                                }
                                if (this.courselists.size() > 0) {
                                    this.courseListRV.setVisibility(0);
                                    this.no_data_found_RL.setVisibility(8);
                                } else {
                                    this.courseListRV.setVisibility(8);
                                    this.no_data_found_RL.setVisibility(0);
                                }
                                setTileDataAdapter(this.courselists, "");
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
                    this.subjectspinner.setText("Select subject");
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
                            this.cardsArrayList.clear();
                            for (CourseTypeMasterTable courseTypeMasterTable : this.courseTypeMasterTables) {
                                if (courseTypeMasterTable.getName().equalsIgnoreCase("all")) {
                                    this.cardsArrayList.add(new Cards(courseTypeMasterTable.getId(), courseTypeMasterTable.getName(), com.clevertap.android.sdk.Constants.BLACK, courseTypeMasterTable.getName(), "0#0#0#0#0#0", "0"));
                                } else if (courseTypeMasterTable.getMaster_category_id().equalsIgnoreCase(this.mastercatid)) {
                                    this.cardsArrayList.add(new Cards(courseTypeMasterTable.getId(), courseTypeMasterTable.getName(), com.clevertap.android.sdk.Constants.BLACK, courseTypeMasterTable.getName(), "0#0#0#0#0#0", "0"));
                                }
                            }
                            if (this.cardsArrayList.size() > 0) {
                                getTileItems(this.cardsArrayList, 0);
                            }
                            if (this.cardsArrayList.size() > 0) {
                                this.contentType_id = this.cardsArrayList.get(0).getId();
                            }
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
                                    this.courselists.add(new Courselist(courseDataTable3.getCourse_id(), courseDataTable3.getTitle(), courseDataTable3.getCover_image(), courseDataTable3.getMrp(), courseDataTable3.getCourse_sp(), courseDataTable3.getValidity(), courseDataTable3.getSubject_id(), courseDataTable3.getLang_id(), courseDataTable3.getDesc_header_image(), courseDataTable3.getExtra_json(), courseDataTable3.getViewType(), "6"));
                                }
                                if (this.courselists.size() > 0) {
                                    this.courseListRV.setVisibility(0);
                                    this.no_data_found_RL.setVisibility(8);
                                } else {
                                    this.courseListRV.setVisibility(8);
                                    this.no_data_found_RL.setVisibility(0);
                                }
                                setTileDataAdapter(this.courselists, "");
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

    private void selecteddata() {
        if (this.mastercatlist.size() > 0) {
            if (!this.pullrefresh) {
                this.mastercatname = this.mastercatlist.get(0).getCat();
                this.mastercatid = this.mastercatlist.get(0).getId();
                if ("1".equalsIgnoreCase("6")) {
                    String string = SharedPreference.getInstance().getString("catName");
                    for (int i = 0; i < this.mastercatlist.size(); i++) {
                        if (string.equalsIgnoreCase(this.mastercatlist.get(i).getCat())) {
                            this.mastercatname = this.mastercatlist.get(i).getCat();
                            this.mastercatid = this.mastercatlist.get(i).getId();
                        }
                    }
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
                    com.appnew.android.home.model.FilterData.Data data = new com.appnew.android.home.model.FilterData.Data();
                    new ArrayList();
                    if (this.utkashRoom == null) {
                        this.utkashRoom = UtkashRoom.getAppDatabase(this);
                    }
                    String str = this.utkashRoom.getMasterAllCatDao().getfilteddata(this.allsubcatindex_id);
                    this.LanguagesTable = this.utkashRoom.getLaunguages().getLaunguagedetail();
                    data.setSubjects((List) new Gson().fromJson(str, new TypeToken<List<Subject>>() { // from class: com.appnew.android.Theme.DashboardActivityTheme7.24
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
        if (!this.isFeedsClicked && this.utkashRoom.getthemeSettingdao().is_setting_exit()) {
            this.bottomSetting = (BottomSetting) new Gson().fromJson(this.utkashRoom.getthemeSettingdao().data().getBottom(), BottomSetting.class);
            this.bottomLL.removeAllViews();
            ArrayList<View> arrayList = this.viewArrayList;
            if (arrayList != null) {
                arrayList.clear();
            }
            for (int i2 = 0; i2 < Helper.getBottomMenu(this.bottomMenuTables).size(); i2++) {
                this.bottomLL.addView(initBottomView(Helper.getBottomMenu(this.bottomMenuTables).get(i2), "1"));
            }
        }
        manageVisibility();
        createMenus();
        this.pullrefresh = false;
    }

    public LinearLayout initBottomView(Menu menu, String str) {
        LinearLayout linearLayout = (LinearLayout) View.inflate(this, R.layout.bottom_item, null);
        TextView textView = (TextView) linearLayout.findViewById(R.id.title);
        final ImageView imageView = (ImageView) linearLayout.findViewById(R.id.icon);
        RelativeLayout relativeLayout = (RelativeLayout) linearLayout.findViewById(R.id.viewUnderLine);
        textView.setText(menu.getName());
        Glide.with((FragmentActivity) this).asBitmap().load(menu.getImageUrl()).into(new CustomTarget<Bitmap>() { // from class: com.appnew.android.Theme.DashboardActivityTheme7.25
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

    private void setdata() {
        for (CourseDataTable courseDataTable : this.courseDataTables) {
            this.courselists.add(new Courselist(courseDataTable.getCourse_id(), courseDataTable.getTitle(), courseDataTable.getCover_image(), courseDataTable.getMrp(), courseDataTable.getCourse_sp(), courseDataTable.getValidity(), courseDataTable.getSubject_id(), courseDataTable.getLang_id(), courseDataTable.getDesc_header_image(), courseDataTable.getExtra_json(), courseDataTable.getViewType(), "6"));
        }
        if (this.courselists.size() > 0) {
            this.courseListRV.setVisibility(0);
            this.no_data_found_RL.setVisibility(8);
        } else {
            this.courseListRV.setVisibility(8);
            this.no_data_found_RL.setVisibility(0);
        }
        setTileDataAdapter(this.courselists, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getCourseData(boolean showProgress) {
        this.networkCall.NetworkAPICall(API.get_courses, "", showProgress, false);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.homeBackIV.setVisibility(8);
        this.toolbartitleTV.setText("Live Class");
        if (!this.isFeedsClicked) {
            if (this.is_test_series_clicked) {
                this.is_test_series_clicked = false;
                getSupportActionBar().setIcon((Drawable) null);
                this.toggle.setDrawerIndicatorEnabled(true);
                this.notificationLL.setVisibility(0);
                this.my_library.setVisibility(0);
                this.myTest.setVisibility(8);
                this.bottomLL.setVisibility(0);
                if (!TextUtils.isEmpty(this.catName)) {
                    setMasterCatData(this.catName, 1);
                } else if (SharedPreference.getInstance().getString("catName") != null && !TextUtils.isEmpty(SharedPreference.getInstance().getString("catName"))) {
                    setMasterCatData(SharedPreference.getInstance().getString("catName"), 1);
                }
            } else if (this.backstatus) {
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
        } else {
            if (this.utkashRoom.getthemeSettingdao().is_setting_exit()) {
                this.bottomSetting = (BottomSetting) new Gson().fromJson(this.utkashRoom.getthemeSettingdao().data().getBottom(), BottomSetting.class);
                this.bottomLL.removeAllViews();
                ArrayList<View> arrayList = this.viewArrayList;
                if (arrayList != null) {
                    arrayList.clear();
                }
                for (int i = 0; i < Helper.getBottomMenu(this.bottomMenuTables).size(); i++) {
                    this.bottomLL.addView(initBottomView(Helper.getBottomMenu(this.bottomMenuTables).get(i), "1"));
                }
            }
            this.isFeedsClicked = false;
            this.scrollView.setVisibility(0);
            this.feeds_ll.setVisibility(8);
            this.is_test_series_clicked = false;
            this.no_data_found_RL_1.setVisibility(8);
            getSupportActionBar().setIcon((Drawable) null);
            this.toggle.setDrawerIndicatorEnabled(true);
            this.notificationLL.setVisibility(0);
            this.my_library.setVisibility(0);
            this.myTest.setVisibility(8);
            this.bottomLL.setVisibility(0);
            if (!TextUtils.isEmpty(this.catName)) {
                setMasterCatData(this.catName, 1);
            } else if (SharedPreference.getInstance().getString("catName") != null && !TextUtils.isEmpty(SharedPreference.getInstance().getString("catName"))) {
                setMasterCatData(SharedPreference.getInstance().getString("catName"), 1);
            }
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
                this.subjectspinner.setText(this.subjectindex.equalsIgnoreCase("") ? "Select  Subject" : this.subjectindex);
                this.launguagespinner.setText(this.launguageindex.equalsIgnoreCase("") ? "Select  Language" : this.launguageindex);
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
                linearLayout3.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$openwatchlist_dailog_resource$30(linearLayout3, textView5, linearLayout2, context, textView2, linearLayout, textView);
                    }
                }));
                linearLayout.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$openwatchlist_dailog_resource$31(linearLayout, textView, linearLayout2, context, textView2, linearLayout3, textView5);
                    }
                }));
                linearLayout2.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$openwatchlist_dailog_resource$32(linearLayout2, textView2, linearLayout3, context, textView5, linearLayout, textView);
                    }
                }));
                button.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda31
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$openwatchlist_dailog_resource$33(context);
                    }
                }));
                relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme7.26
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        DashboardActivityTheme7.this.clicktype = "4";
                        PopupMenu popupMenu = new PopupMenu(context, DashboardActivityTheme7.this.launguagespinner, 3);
                        popupMenu.getMenu().add("Select language");
                        for (int i = 0; i < languages.size(); i++) {
                            popupMenu.getMenu().add(((LanguagesTable) languages.get(i)).getLanguage());
                        }
                        popupMenu.setOnMenuItemClickListener(DashboardActivityTheme7.this);
                        popupMenu.show();
                    }
                });
                this.launguagespinner.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme7.27
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        DashboardActivityTheme7.this.clicktype = "4";
                        PopupMenu popupMenu = new PopupMenu(context, DashboardActivityTheme7.this.launguagespinner, 3);
                        popupMenu.getMenu().add("Select language");
                        for (int i = 0; i < languages.size(); i++) {
                            popupMenu.getMenu().add(((LanguagesTable) languages.get(i)).getLanguage());
                        }
                        popupMenu.setOnMenuItemClickListener(DashboardActivityTheme7.this);
                        popupMenu.show();
                    }
                });
                relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme7.28
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        DashboardActivityTheme7.this.clicktype = "5";
                        PopupMenu popupMenu = new PopupMenu(context, DashboardActivityTheme7.this.subjectspinner, 3);
                        popupMenu.getMenu().add("Select subject");
                        for (int i = 0; i < subjects.size(); i++) {
                            popupMenu.getMenu().add(((Subject) subjects.get(i)).getTitle());
                        }
                        popupMenu.setOnMenuItemClickListener(DashboardActivityTheme7.this);
                        popupMenu.show();
                    }
                });
                this.subjectspinner.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme7.29
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        DashboardActivityTheme7.this.clicktype = "5";
                        PopupMenu popupMenu = new PopupMenu(context, DashboardActivityTheme7.this.subjectspinner, 3);
                        popupMenu.getMenu().add("Select subject");
                        for (int i = 0; i < subjects.size(); i++) {
                            popupMenu.getMenu().add(((Subject) subjects.get(i)).getTitle());
                        }
                        popupMenu.setOnMenuItemClickListener(DashboardActivityTheme7.this);
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
    public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$30(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, Context context, TextView textView2, LinearLayout linearLayout3, TextView textView3) {
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
    public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$31(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, Context context, TextView textView2, LinearLayout linearLayout3, TextView textView3) {
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
    public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$32(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, Context context, TextView textView2, LinearLayout linearLayout3, TextView textView3) {
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
    public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$33(Context context) {
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
                    this.courselists.add(new Courselist(courseDataTable.getCourse_id(), courseDataTable.getTitle(), courseDataTable.getCover_image(), courseDataTable.getMrp(), courseDataTable.getCourse_sp(), courseDataTable.getValidity(), courseDataTable.getSubject_id(), courseDataTable.getLang_id(), courseDataTable.getDesc_header_image(), courseDataTable.getExtra_json(), courseDataTable.getViewType(), "6"));
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
                setTileDataAdapter(this.courselists, "");
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
                            this.bannerListTables.clear();
                            this.bottomMenuTables.clear();
                            if (!this.utkashRoom.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread()) {
                                this.courseTypeMasterTables = this.utkashRoom.getcoursetypemaster().getcourse_typemaster(MakeMyExam.userId);
                                this.masterAllCatTables = this.utkashRoom.getMasterAllCatDao().getmaster_allcat(MakeMyExam.userId);
                                this.mastercatlist = this.utkashRoom.getMastercatDao().getmastercat(MakeMyExam.userId);
                                this.bannerListTables = this.utkashRoom.getBannerTableDao().getBanner(MakeMyExam.getUserId());
                                this.bottomMenuTables = this.utkashRoom.getBottomMenuTableDao().getBottomMenu(MakeMyExam.getUserId());
                            }
                            if (this.mastercatlist.size() > 0) {
                                this.mastercatid = this.mastercatlist.get(0).getId();
                            }
                            runOnUiThread(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda33
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$onRestart$34();
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
    public /* synthetic */ void lambda$onRestart$34() {
        this.cardsArrayList.clear();
        for (CourseTypeMasterTable courseTypeMasterTable : this.courseTypeMasterTables) {
            if (courseTypeMasterTable.getName().equalsIgnoreCase("all")) {
                this.cardsArrayList.add(new Cards(courseTypeMasterTable.getId(), courseTypeMasterTable.getName(), com.clevertap.android.sdk.Constants.BLACK, courseTypeMasterTable.getName(), "0#0#0#0#0#0", "0"));
            } else if (courseTypeMasterTable.getMaster_category_id().equalsIgnoreCase(this.mastercatid)) {
                this.cardsArrayList.add(new Cards(courseTypeMasterTable.getId(), courseTypeMasterTable.getName(), com.clevertap.android.sdk.Constants.BLACK, courseTypeMasterTable.getName(), "0#0#0#0#0#0", "0"));
            }
        }
        if (this.cardsArrayList.size() > 0) {
            getTileItems(this.cardsArrayList, 0);
        }
        selecteddata();
        List<BannerListTable> list = this.bannerListTables;
        if (list != null && list.size() > 0) {
            BannerAdapter bannerAdapter = new BannerAdapter(this, this.bannerListTables);
            this.bannerAdapter = bannerAdapter;
            this.sliderViewPager.setAdapter(bannerAdapter);
        }
        automateViewPagerSwiping();
        List<BannerListTable> list2 = this.bannerListTables;
        if (list2 != null && list2.size() > 0) {
            BottomBannerAdapter bottomBannerAdapter = new BottomBannerAdapter(this, this.bannerListTables, null);
            this.bottomBannerAdapter = bottomBannerAdapter;
            this.bottomSliderViewPager.setAdapter(bottomBannerAdapter);
        }
        automateBottomViewPagerSwiping();
    }

    public void dialog_latest_popup() {
        final Dialog dialog = new Dialog(homeactivitytheme6);
        dialog.setContentView(R.layout.dialog_latest_popup);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -2;
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        ImageView imageView = (ImageView) dialog.findViewById(R.id.iv_close);
        RoundedImageView roundedImageView = (RoundedImageView) dialog.findViewById(R.id.iv_latest_image);
        try {
            Glide.with((FragmentActivity) this).load("https://images.freeimages.com/images/large-previews/ec6/abstract-blue-photo-files-label-1164737.jpg").into(roundedImageView);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        roundedImageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme7.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ("".equalsIgnoreCase("1")) {
                    dialog.dismiss();
                    Intent intent = new Intent(DashboardActivityTheme7.homeactivitytheme6, (Class<?>) WebViewActivty.class);
                    intent.putExtra("url", "web_link");
                    DashboardActivityTheme7.this.startActivity(intent);
                    return;
                }
                if ("".equalsIgnoreCase("2")) {
                    dialog.dismiss();
                    Intent intent2 = new Intent(DashboardActivityTheme7.homeactivitytheme6, (Class<?>) CourseActivity.class);
                    intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    SharedPreference.getInstance().putString("id", "course_link");
                    intent2.putExtra("COURSE_EXPIRE", "0");
                    DashboardActivityTheme7.this.startActivity(intent2);
                    return;
                }
                if ("".equalsIgnoreCase("3")) {
                    dialog.dismiss();
                    Intent intent3 = new Intent(DashboardActivityTheme7.homeactivitytheme6, (Class<?>) QuizWebView.class);
                    intent3.putExtra(Const.QUIZSTATUS, DashboardActivityTheme7.this.quiz_id);
                    DashboardActivityTheme7.this.startActivity(intent3);
                    return;
                }
                dialog.dismiss();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme7.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        layoutParams.gravity = 17;
        layoutParams.windowAnimations = R.style.videosheetDialogTheme;
        dialog.getWindow().setAttributes(layoutParams);
        dialog.show();
    }

    public void homeAutoRefresh() {
        if (SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT) == 0) {
            ShortcutBadger.applyCount(getApplicationContext(), SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT));
            ((LinearLayout) Objects.requireNonNull(((AppBarDashboard7Binding) Objects.requireNonNull(this.binding.dashBoardMain7)).cvrNotificationCount1)).setBackgroundResource(R.drawable.uncircle_notification_count);
            runOnUiThread(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme7.32
                @Override // java.lang.Runnable
                public void run() {
                    DashboardActivityTheme7.this.binding.dashBoardMain7.notificaionCount1.setText(String.valueOf(SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT)));
                }
            });
            this.binding.dashBoardMain7.cvrNotificationCount1.setVisibility(8);
            return;
        }
        runOnUiThread(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme7.33
            @Override // java.lang.Runnable
            public void run() {
                ((AppBarDashboard7Binding) Objects.requireNonNull(DashboardActivityTheme7.this.binding.dashBoardMain7)).cvrNotificationCount1.setVisibility(0);
                ShortcutBadger.applyCount(DashboardActivityTheme7.this.getApplicationContext(), SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT));
                DashboardActivityTheme7.this.binding.dashBoardMain7.cvrNotificationCount1.setBackgroundResource(R.drawable.circle_notification_count);
                if (SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT) > 99) {
                    DashboardActivityTheme7.this.binding.dashBoardMain7.notificaionCount1.setText("99+");
                } else if (SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT) > 0) {
                    DashboardActivityTheme7.this.binding.dashBoardMain7.notificaionCount1.setText(String.valueOf(SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT)));
                } else {
                    DashboardActivityTheme7.this.binding.dashBoardMain7.cvrNotificationCount1.setVisibility(8);
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
                        if (this.mastercatlist.size() > 0) {
                            this.mastercatid = this.mastercatlist.get(0).getId();
                        }
                        runOnUiThread(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda32
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$initialzehomepage$35();
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
    public /* synthetic */ void lambda$initialzehomepage$35() {
        this.cardsArrayList.clear();
        for (CourseTypeMasterTable courseTypeMasterTable : this.courseTypeMasterTables) {
            if (courseTypeMasterTable.getName().equalsIgnoreCase("all")) {
                this.cardsArrayList.add(new Cards(courseTypeMasterTable.getId(), courseTypeMasterTable.getName(), com.clevertap.android.sdk.Constants.BLACK, courseTypeMasterTable.getName(), "0#0#0#0#0#0", "0"));
            } else if (courseTypeMasterTable.getMaster_category_id().equalsIgnoreCase(this.mastercatid)) {
                this.cardsArrayList.add(new Cards(courseTypeMasterTable.getId(), courseTypeMasterTable.getName(), com.clevertap.android.sdk.Constants.BLACK, courseTypeMasterTable.getName(), "0#0#0#0#0#0", "0"));
            }
        }
        if (this.cardsArrayList.size() > 0) {
            getTileItems(this.cardsArrayList, 0);
        }
        selecteddata();
        List<BannerListTable> list = this.bannerListTables;
        if (list != null && list.size() > 0) {
            BannerAdapter bannerAdapter = new BannerAdapter(this, this.bannerListTables);
            this.bannerAdapter = bannerAdapter;
            this.sliderViewPager.setAdapter(bannerAdapter);
        }
        automateViewPagerSwiping();
        List<BannerListTable> list2 = this.bannerListTables;
        if (list2 != null && list2.size() > 0) {
            BottomBannerAdapter bottomBannerAdapter = new BottomBannerAdapter(this, this.bannerListTables, null);
            this.bottomBannerAdapter = bottomBannerAdapter;
            this.bottomSliderViewPager.setAdapter(bottomBannerAdapter);
        }
        automateBottomViewPagerSwiping();
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
                    Toast.makeText(this, "You have already Attempted the test", 0).show();
                    initialzehomepage();
                    return;
                }
            }
            if (System.currentTimeMillis() <= Long.parseLong(videoArrayList.get(0).getResult_date()) * 1000) {
                initialzehomepage();
                Toast.makeText(this, "You have already Attempted", 0).show();
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
                Snackbar.make(this.filter.getRootView(), "Test will start on " + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(videoArrayList.get(0).getStart_date()) * 1000)), -1).show();
                initialzehomepage();
                return;
            }
            TestTable testTableTest_data = this.utkashRoom.getTestDao().test_data(videoArrayList.get(0).getId(), MakeMyExam.userId);
            if (testTableTest_data != null && testTableTest_data.getStatus() != null && !testTableTest_data.getStatus().equalsIgnoreCase("")) {
                Snackbar.make(this.filter.getRootView(), "You have already Attempted the test", -1).show();
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
            Snackbar.make(this.filter.getRootView(), "Your Result will be declare on " + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(videoArrayList.get(0).getResult_date()) * 1000)), -1).show();
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

    private void automateViewPagerSwiping() {
        if (this.bannerAdapter != null) {
            final Runnable runnable = new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$automateViewPagerSwiping$36();
                }
            };
            this.timer.schedule(new TimerTask() { // from class: com.appnew.android.Theme.DashboardActivityTheme7.34
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    new Handler(Looper.getMainLooper()).post(runnable);
                }
            }, 500L, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$automateViewPagerSwiping$36() {
        if (this.sliderViewPager.getCurrentItem() == this.bannerAdapter.getItemCount() - 1) {
            this.sliderViewPager.setCurrentItem(0);
        } else {
            ViewPager2 viewPager2 = this.sliderViewPager;
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1, true);
        }
    }

    private void automateBottomViewPagerSwiping() {
        if (this.bottomBannerAdapter != null) {
            final Runnable runnable = new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme7$$ExternalSyntheticLambda37
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$automateBottomViewPagerSwiping$37();
                }
            };
            this.timer.schedule(new TimerTask() { // from class: com.appnew.android.Theme.DashboardActivityTheme7.35
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    new Handler(Looper.getMainLooper()).post(runnable);
                }
            }, 500L, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$automateBottomViewPagerSwiping$37() {
        if (this.bottomSliderViewPager.getCurrentItem() == this.bottomBannerAdapter.getItemCount() - 1) {
            this.bottomSliderViewPager.setCurrentItem(0);
        } else {
            ViewPager2 viewPager2 = this.bottomSliderViewPager;
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1, true);
        }
    }

    private void managebottombar(String home, String mylibrary, String livetest, String createtest, String notification, String download, String liveclass, String course) {
        this.homeLL.setVisibility(8);
        this.libLL.setVisibility(8);
        this.livetestLL.setVisibility(8);
        this.testLL.setVisibility(8);
        this.profileLL.setVisibility(8);
        this.cartLL.setVisibility(8);
        this.liveclassLL.setVisibility(8);
        this.CourseLL.setVisibility(8);
        if (this.bottomSetting.getMy_library().equalsIgnoreCase("1")) {
            this.ll_top.setVisibility(0);
        } else {
            this.ll_top.setVisibility(8);
        }
        if (this.bottomSetting.getTop_banner().equalsIgnoreCase("1")) {
            this.viewPagerRL.setVisibility(8);
            this.sliderViewPager.registerOnPageChangeCallback(this.bannerPageChangeCallback);
            this.bottomViewPagerRL.setVisibility(8);
            this.bottomSliderViewPager.registerOnPageChangeCallback(this.bannerPageChangeCallback);
        } else {
            this.viewPagerRL.setVisibility(8);
            this.bottomViewPagerRL.setVisibility(8);
        }
        if (this.bottomSetting.getBottom_banner().equalsIgnoreCase("1")) {
            this.bottomViewPagerRL.setVisibility(8);
            this.bottomSliderViewPager.registerOnPageChangeCallback(this.bannerPageChangeCallback);
            this.viewPagerRL.setVisibility(8);
            this.sliderViewPager.registerOnPageChangeCallback(this.bannerPageChangeCallback);
        } else {
            this.bottomViewPagerRL.setVisibility(8);
            this.viewPagerRL.setVisibility(8);
        }
        if (liveclass.equalsIgnoreCase("1")) {
            this.liveclassLL.setVisibility(0);
        }
        if (home.equalsIgnoreCase("1")) {
            this.homeLL.setVisibility(0);
        }
        if (mylibrary.equalsIgnoreCase("1")) {
            this.libLL.setVisibility(0);
        }
        if (livetest.equalsIgnoreCase("1")) {
            this.livetestLL.setVisibility(0);
        }
        if (createtest.equalsIgnoreCase("1")) {
            this.testLL.setVisibility(0);
        }
        if (notification.equalsIgnoreCase("1")) {
            this.profileLL.setVisibility(0);
        }
        if (download.equalsIgnoreCase("1")) {
            this.cartLL.setVisibility(0);
        }
        if (course.equalsIgnoreCase("1")) {
            this.CourseLL.setVisibility(0);
        }
    }

    public void setMasterCatData(String catName, int type) {
        List<CourseDataTable> list;
        this.catName = catName;
        if (!TextUtils.isEmpty(catName)) {
            this.selectionType.setText(catName);
        }
        ArrayList<BannerListTable> arrayList = new ArrayList();
        ArrayList<BannerListTable> arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (this.utkashRoom.getBannerTableDao() != null && this.utkashRoom.getBannerTableDao().getBanner(MakeMyExam.userId) != null && this.utkashRoom.getBannerTableDao().getBanner(MakeMyExam.userId).size() > 0) {
            arrayList.addAll(this.utkashRoom.getBannerTableDao().getBanner(MakeMyExam.userId));
        }
        for (BannerListTable bannerListTable : arrayList) {
            if (bannerListTable.getBanner_location().equalsIgnoreCase("6")) {
                arrayList2.add(bannerListTable);
            }
        }
        for (BannerListTable bannerListTable2 : arrayList2) {
            for (MasterCat masterCat : this.mastercatlist) {
                if (masterCat.getCat().equalsIgnoreCase(catName) && bannerListTable2.getMaster_cat().equalsIgnoreCase(masterCat.getId())) {
                    arrayList3.add(bannerListTable2);
                }
            }
        }
        this.bannerSlider.setLayoutManager(new LinearLayoutManager(this));
        this.bannerSlider.setAdapter(new FeedViewPagerAdapter(this, this, arrayList3));
        if (this.bannerSlider.getAdapter().getItemCount() > 0) {
            this.no_data_found_RL_1.setVisibility(8);
        } else {
            this.no_data_found_RL_1.setVisibility(0);
        }
        SharedPreference.getInstance().putString("catName", catName);
        for (MasterCat masterCat2 : this.mastercatlist) {
            if (masterCat2.getCat().equalsIgnoreCase(catName)) {
                this.mastercatname = catName;
                this.mastercatid = masterCat2.getId();
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
                for (MasteAllCatTable masteAllCatTable : this.masterAllCatTables) {
                    if (masteAllCatTable.getMaster_type().equals(this.mastercatid) && masteAllCatTable.getParent_id().equalsIgnoreCase("0")) {
                        this.selected_master_cat.add(masteAllCatTable);
                    }
                }
                if (this.selected_master_cat.size() > 0) {
                    this.allcatindex = this.selected_master_cat.get(0).getName();
                    this.allcatindex_id = this.selected_master_cat.get(0).getId();
                    this.filterOne.setText(this.selected_master_cat.get(0).getName());
                    for (MasteAllCatTable masteAllCatTable2 : this.masterAllCatTables) {
                        if (this.allcatindex_id.equalsIgnoreCase(masteAllCatTable2.getParent_id())) {
                            this.selectedsub_all_cat.add(masteAllCatTable2);
                        }
                    }
                    if (this.selectedsub_all_cat.size() > 0) {
                        this.allsubcatindex = this.selectedsub_all_cat.get(0).getName();
                        this.allsubcatindex_id = this.selectedsub_all_cat.get(0).getId();
                        this.filterTwo.setText(this.allsubcatindex);
                        this.courseListRV.setVisibility(0);
                        this.no_data_found_RL.setVisibility(8);
                        this.pagecount = 1;
                        this.cardsArrayList.clear();
                        for (CourseTypeMasterTable courseTypeMasterTable : this.courseTypeMasterTables) {
                            if (!this.is_test_series_clicked && courseTypeMasterTable.getName().equalsIgnoreCase("all")) {
                                this.isAllClicked = true;
                            }
                            try {
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            if ((courseTypeMasterTable.getName().equalsIgnoreCase("all") && type == 1) || (courseTypeMasterTable.getName().equalsIgnoreCase("all") && type == 0)) {
                                this.cardsArrayList.add(new Cards(courseTypeMasterTable.getId(), courseTypeMasterTable.getName(), com.clevertap.android.sdk.Constants.BLACK, courseTypeMasterTable.getName(), "0#0#0#0#0#0", "0"));
                            } else if (courseTypeMasterTable.getMaster_category_id().equalsIgnoreCase(this.mastercatid)) {
                                if (type == 0) {
                                    if (courseTypeMasterTable.getView_type().equalsIgnoreCase("0")) {
                                        this.cardsArrayList.add(new Cards(courseTypeMasterTable.getId(), courseTypeMasterTable.getName(), com.clevertap.android.sdk.Constants.BLACK, courseTypeMasterTable.getName(), "0#0#0#0#0#0", "0"));
                                    }
                                } else if (type == 1) {
                                    if (courseTypeMasterTable.getView_type().equalsIgnoreCase("0")) {
                                        this.cardsArrayList.add(new Cards(courseTypeMasterTable.getId(), courseTypeMasterTable.getName(), com.clevertap.android.sdk.Constants.BLACK, courseTypeMasterTable.getName(), "0#0#0#0#0#0", "0"));
                                    }
                                } else if (type == 2 && courseTypeMasterTable.getView_type().equalsIgnoreCase("5")) {
                                    this.cardsArrayList.add(new Cards(courseTypeMasterTable.getId(), courseTypeMasterTable.getName(), com.clevertap.android.sdk.Constants.BLACK, courseTypeMasterTable.getName(), "0#0#0#0#0#0", "0"));
                                }
                            }
                        }
                        if (this.cardsArrayList.size() > 0) {
                            getTileItems(this.cardsArrayList, 0);
                        } else {
                            this.contentType = "";
                            this.contentType_id = "";
                            this.cardsArrayList.clear();
                            this.tileItemsAdapter.notifyDataSetChanged();
                        }
                        if (this.cardsArrayList.size() > 0) {
                            this.contentType_id = this.cardsArrayList.get(0).getId();
                        }
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
                                this.courselists.add(new Courselist(courseDataTable.getCourse_id(), courseDataTable.getTitle(), courseDataTable.getCover_image(), courseDataTable.getMrp(), courseDataTable.getCourse_sp(), courseDataTable.getValidity(), courseDataTable.getSubject_id(), courseDataTable.getLang_id(), courseDataTable.getDesc_header_image(), courseDataTable.getExtra_json(), courseDataTable.getViewType(), "6"));
                            }
                            if (this.courselists.size() > 0) {
                                this.courseListRV.setVisibility(0);
                                this.no_data_found_RL.setVisibility(8);
                            } else {
                                this.courseListRV.setVisibility(8);
                                this.no_data_found_RL.setVisibility(0);
                            }
                            setTileDataAdapter(this.courselists, "");
                            return;
                        }
                        getCourseData(true);
                        return;
                    }
                    this.courseListRV.setVisibility(8);
                    this.no_data_found_RL.setVisibility(0);
                    this.allsubcatindex_id = "";
                    this.allsubcatindex = "";
                    this.filterTwo.setText("");
                    return;
                }
                this.allcatindex = "";
                this.allcatindex_id = "";
                this.filterOne.setText("");
                return;
            }
        }
    }

    public void refreshApiFromDownloads() {
        if (Helper.isConnected(this)) {
            new NetworkCall(this, this).NetworkAPICall(API.master_content, "", true, false);
        }
    }

    @Override // com.appnew.android.Theme.Adapter.BottomBannerAdapter.BannerClick
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
}
