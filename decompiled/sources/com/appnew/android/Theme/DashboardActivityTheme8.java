package com.appnew.android.Theme;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
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
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.appnew.android.BuildConfig;
import com.appnew.android.Coupon.Activity.CouponActivity;
import com.appnew.android.CourseTransfer.CourseTransferActivity;
import com.appnew.android.Courses.Activity.Concept_newActivity;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.Courses.Activity.PdfDetailScreen;
import com.appnew.android.Courses.Activity.QuizActivity;
import com.appnew.android.Courses.Activity.WebFragActivity;
import com.appnew.android.Courses.Fragment.SingleStudy;
import com.appnew.android.Courses.Interfaces.IOnDailyDoseClickListener;
import com.appnew.android.CreateTest.Activity.CreateTestActivity;
import com.appnew.android.CustomPayment.CustomPaymentActivity;
import com.appnew.android.Download.Audio.AudioPlayerService;
import com.appnew.android.Download.AudioPlayerActivty;
import com.appnew.android.Download.DownloadActivity;
import com.appnew.android.Download.DownloadVideoPlayer;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Intro.Activity.CategoryActivity;
import com.appnew.android.Intro.Activity.IntroActivity;
import com.appnew.android.LiveClass.Activity.LiveClassActivity;
import com.appnew.android.LiveTest.Activity.LivetestActivity;
import com.appnew.android.Login.Activity.SplashScreen;
import com.appnew.android.Model.BottomMenu;
import com.appnew.android.Model.BottomSetting;
import com.appnew.android.Model.COURSEDETAIL.CourseDetail;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Model.Courses.Cards;
import com.appnew.android.Model.LeftMenu;
import com.appnew.android.Model.Video;
import com.appnew.android.Notification.Notification;
import com.appnew.android.Notification.NotificationDescription;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Profile.ProfileActivity;
import com.appnew.android.Profile.ProfileActivityTheme8;
import com.appnew.android.PurchaseHistory.PurchaseHistory;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Theme.Adapter.AdapterDashTile2Theme8;
import com.appnew.android.Theme.Adapter.AdapterDashTileTheme8;
import com.appnew.android.Theme.Adapter.DashboardTabIconAdapter;
import com.appnew.android.Theme.Adapter.IBTPracticeViewPagerAdapter;
import com.appnew.android.Theme.Adapter.SliderAdapter;
import com.appnew.android.Theme.fragment.ViewSliderChildFragment;
import com.appnew.android.UserHistory.ContactUsPage;
import com.appnew.android.UserHistory.ConversationReplyActivity;
import com.appnew.android.UserHistory.UserHistoryActivity;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.DialogUtils;
import com.appnew.android.Utils.EnhancedWrapContentViewPager;
import com.appnew.android.Utils.GenericUtils;
import com.appnew.android.Utils.GridSpacingItemDecoration;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.StickyView.ui.StickyScrollView;
import com.appnew.android.Webview.WebViewActivty;
import com.appnew.android.Zoom.Activity.BookMarkList;
import com.appnew.android.Zoom.Activity.CurrentAffairActivity;
import com.appnew.android.Zoom.Activity.DoubtsActivity;
import com.appnew.android.cleverTap.AnalyticHelper;
import com.appnew.android.dailyDose.adapter.DailyDoseMenuAdapter;
import com.appnew.android.databinding.ActivityHomeTheme8Binding;
import com.appnew.android.feeds.activity.FeedDetails;
import com.appnew.android.feeds.activity.FeedsActivity;
import com.appnew.android.feeds.adapters.FeedViewPagerAdapter;
import com.appnew.android.helpChat.HelpQueryActivity;
import com.appnew.android.helpChat.HelpSupportActivity;
import com.appnew.android.helpChat.model.HelpSupportChatModel;
import com.appnew.android.home.Activity.CourseTypeActivity;
import com.appnew.android.home.Activity.HomeActivity;
import com.appnew.android.home.Activity.MyLibraryActivty;
import com.appnew.android.home.Activity.SettingsActivity;
import com.appnew.android.home.Constants;
import com.appnew.android.home.Fragment.Chatboot;
import com.appnew.android.home.Fragment.ContactBottomSheetFragment;
import com.appnew.android.home.adapters.LeftNavAdapter;
import com.appnew.android.home.adapters.TileDataAdapter;
import com.appnew.android.home.interfaces.IOnCourseClickListener;
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
import com.appnew.android.table.LanguagesTable;
import com.appnew.android.table.MasteAllCatTable;
import com.appnew.android.table.MasterCat;
import com.appnew.android.table.TestTable;
import com.appnew.android.table.ThemeSettings;
import com.appnew.android.table.UserHistroyTable;
import com.appnew.android.table.VideoTable;
import com.appnew.android.table.VideosDownload;
import com.appnew.android.testmodule.activity.TestBaseActivity;
import com.appnew.android.testmodule.model.InstructionData;
import com.appnew.android.testmodule.model.TestBasicInst;
import com.appnew.android.testmodule.model.TestSectionInst;
import com.appnew.android.testmodule.model.TestseriesBase;
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
import com.makeramen.roundedimageview.RoundedImageView;
import com.tv9news.utils.helpers.AnalyticEvents;
import com.tv9news.utils.helpers.AnalyticsConstants;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import me.leolin.shortcutbadger.ShortcutBadger;
import org.bouncycastle.pqc.crypto.newhope.NewHope;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class DashboardActivityTheme8 extends AppCompatActivity implements NetworkCall.MyNetworkCallBack, IOnCourseClickListener, IOnDailyDoseClickListener, AdapterDashTile2Theme8.addDashboardItemClicked, PopupMenu.OnMenuItemClickListener, DashboardTabIconAdapter.addDashboardItemClicked, SliderAdapter.BannerClick {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static Activity homeactivity = null;
    public static Activity homeactivitytheme8 = null;
    public static String mainCatId = "";
    LinearLayout CourseLL;
    RelativeLayout RL1P;
    ImageView TopperreviewIV;
    AdapterDashTileTheme8 adapterDashTileTheme8;
    private Task<AppUpdateInfo> appUpdateInfoTask;
    private AudioTable audioTable;
    Button backBtn;
    RecyclerView bannerSlider;
    private ActivityHomeTheme8Binding binding;
    LinearLayout bottomLL;
    BottomSetting bottomSetting;
    RecyclerView browseByCoursesRecycler;
    RelativeLayout browseByModelayout;
    RelativeLayout browseBySublayout;
    LinearLayout cartLL;
    public ImageView chatboat;
    ImageButton chromecast;
    RelativeLayout containt_layout;
    public String contentType;
    LinearLayout courseLayoutCover;
    LinearLayout cvrNotificationCount;
    RelativeLayout cvrNotificationRL;
    RelativeLayout dailyDoseCover;
    DailyDoseMenuAdapter dailyDoseMenuAdapter;
    RecyclerView dailyDoseRV;
    AdapterDashTile2Theme8 dashboardTabAdapter;
    private ImageView[] dots;
    public ImageView downarrowIV;
    DrawerLayout drawer;
    private RelativeLayout feeds_ll;
    RelativeLayout filter;
    TextView filterOne;
    TextView filterTwo;
    RelativeLayout filter_one_click;
    RelativeLayout filter_two_click;
    Filterdata filterdata;
    FrameLayout forchatbot;
    public Fragment fragment;
    private FragmentManager fragmentManager;
    GridLayoutManager gridLayoutManager1;
    GridLayoutManager gridLayoutManager2;
    ImageView homeBackIV;
    LinearLayout homeLL;
    ImageView iconFacebook;
    ImageView iconInstagram;
    ImageView iconLinkedIn;
    ImageView iconTelegram;
    ImageView iconTwitter;
    ImageView iconWebsite;
    ImageView iconYoutube;
    private int inAppUpdateType;
    private InstallStateUpdatedListener installStateUpdatedListener;
    public ImageView ivWhatsapp;
    int lang;
    TextView launguagespinner;
    private LinearLayout layoutDots_Mode;
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
    RelativeLayout noDataDailyDose;
    RelativeLayout no_data_found_RL;
    private RelativeLayout no_data_found_RL_1;
    TextView notificaionCount;
    int notification_code;
    public IBTPracticeViewPagerAdapter pagerAdapter;
    ProgressBar paginationLoader;
    ImageView parentRL;
    TextView profileEmail;
    public ImageView profileImage;
    public ImageView profileImageText;
    RelativeLayout profileLL;
    TextView profileName;
    private SwipeRefreshLayout pullToReferesh;
    private Dialog quizBasicInfoDialog;
    CoordinatorLayout rootView;
    private StickyScrollView scrollView;
    ImageView searchIV;
    TextView subjectspinner;
    LinearLayout testLL;
    TextView testseries_txt;
    TileDataAdapter tileDataAdapter;
    TextView tile_tv;
    RelativeLayout titleinnerRL;
    ActionBarDrawerToggle toggle;
    public Toolbar toolbar;
    TextView toolbartitleTV;
    Video topper_video;
    UtkashRoom utkashRoom;
    TextView versionnameTV;
    private Video videodata;
    public EnhancedWrapContentViewPager viewPager;
    RelativeLayout viewPagerRL;
    BottomSheetDialog watchlist;
    boolean isDailyDoseClicked = false;
    boolean isFeedsClicked = false;
    ArrayList<CourseTypeMasterTable> courseTypeMasterTables2 = new ArrayList<>();
    long backPressed = 0;
    private boolean backstatus = false;
    public String contentType_id = "0";
    List<BottomMenuTable> bottomMenuTables = new ArrayList();
    List<CourseTypeMasterTable> courseTypeMasterTables = new ArrayList();
    List<MasteAllCatTable> masterAllCatTables = new ArrayList();
    List<MasterCat> mastercatlist = new ArrayList();
    String mastercatname = "";
    String mastercatid = "";
    ArrayList<CourseTypeMasterTable> dailyDoseFiltered = new ArrayList<>();
    String allcatindex = "";
    String allcatindex_id = "";
    String clicktype = "";
    private int pagecount = 1;
    String allsubcatindex = "";
    String allsubcatindex_id = "";
    ArrayList<Courselist> courselists = new ArrayList<>();
    ArrayList<MasteAllCatTable> selected_master_cat = new ArrayList<>();
    ArrayList<MasteAllCatTable> selectedsub_all_cat = new ArrayList<>();
    public boolean isfilterchanged = false;
    String launguageindex = "";
    String subjectindex = "";
    String SelectedLaunguageid = "";
    String SelectedSubjectid = "";
    boolean ispaginationavailable = false;
    Boolean is_seminar = false;
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
    String post_id = "";
    List<CourseDataTable> courseDataTables = new ArrayList();
    List<LanguagesTable> LanguagesTable = new ArrayList();
    String first_attempt = "";
    String result_date = "";
    String submition_type = "";
    String parentid = "";
    String video_type = "";
    private int RC_APP_UPDATE = 999;
    private boolean isDoubtActive = false;
    private String tabId = "";
    private Timer timer = new Timer();
    List<BannerListTable> bannerListTables = new ArrayList();
    List<BannerListTable> bannerListTableForTopBanner = new ArrayList();
    List<BannerListTable> seminarbannerlist = new ArrayList();
    int popupBannerStatus = 0;
    String id = "";
    String test_series_date = "";
    String test_series_name = "";
    String solutions = "";
    List<CourseTypeMasterTable> currentaffair = new ArrayList();
    List<CourseTypeMasterTable> offline = new ArrayList();
    ArrayList<CourseTypeMasterTable> courseByExams = new ArrayList<>();
    ArrayList<CourseTypeMasterTable> dailyDoseList = new ArrayList<>();
    ArrayList<ArrayList<CourseTypeMasterTable>> coursesDataArrayListmain = new ArrayList<>();
    private ArrayList<Fragment> mFragmentList = new ArrayList<>();
    ViewPager2.OnPageChangeCallback bannerPageChangeCallback = new ViewPager2.OnPageChangeCallback() { // from class: com.appnew.android.Theme.DashboardActivityTheme8.1
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
    ArrayList<View> viewArrayList = new ArrayList<>();
    String selectedId = null;
    private boolean hitMaster = true;
    private String batch_id = "";
    public View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme8.4
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v0 */
        /* JADX WARN: Type inference failed for: r10v1 */
        /* JADX WARN: Type inference failed for: r10v10 */
        /* JADX WARN: Type inference failed for: r10v11 */
        /* JADX WARN: Type inference failed for: r10v12 */
        /* JADX WARN: Type inference failed for: r10v13 */
        /* JADX WARN: Type inference failed for: r10v14 */
        /* JADX WARN: Type inference failed for: r10v15 */
        /* JADX WARN: Type inference failed for: r10v16 */
        /* JADX WARN: Type inference failed for: r10v17 */
        /* JADX WARN: Type inference failed for: r10v18 */
        /* JADX WARN: Type inference failed for: r10v19 */
        /* JADX WARN: Type inference failed for: r10v20 */
        /* JADX WARN: Type inference failed for: r10v21 */
        /* JADX WARN: Type inference failed for: r10v22 */
        /* JADX WARN: Type inference failed for: r10v23 */
        /* JADX WARN: Type inference failed for: r10v24 */
        /* JADX WARN: Type inference failed for: r10v25 */
        /* JADX WARN: Type inference failed for: r10v26 */
        /* JADX WARN: Type inference failed for: r10v27 */
        /* JADX WARN: Type inference failed for: r10v28 */
        /* JADX WARN: Type inference failed for: r10v29 */
        /* JADX WARN: Type inference failed for: r10v3 */
        /* JADX WARN: Type inference failed for: r10v30 */
        /* JADX WARN: Type inference failed for: r10v31 */
        /* JADX WARN: Type inference failed for: r10v32 */
        /* JADX WARN: Type inference failed for: r10v33 */
        /* JADX WARN: Type inference failed for: r10v34 */
        /* JADX WARN: Type inference failed for: r10v35 */
        /* JADX WARN: Type inference failed for: r10v36 */
        /* JADX WARN: Type inference failed for: r10v4 */
        /* JADX WARN: Type inference failed for: r10v5 */
        /* JADX WARN: Type inference failed for: r10v6 */
        /* JADX WARN: Type inference failed for: r10v7 */
        /* JADX WARN: Type inference failed for: r10v8 */
        /* JADX WARN: Type inference failed for: r10v9 */
        /* JADX WARN: Type inference failed for: r18v0 */
        /* JADX WARN: Type inference failed for: r18v4 */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            char c2;
            boolean z;
            int i;
            String str2;
            char c3;
            View view2 = view;
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                str = "1";
                c2 = '\b';
                if (i2 >= DashboardActivityTheme8.this.viewArrayList.size()) {
                    break;
                }
                View view3 = DashboardActivityTheme8.this.viewArrayList.get(i2);
                Menu menu = (Menu) DashboardActivityTheme8.this.viewArrayList.get(i2).getTag();
                Menu menu2 = (Menu) view2.getTag();
                if (menu2 == menu) {
                    if (menu2.getId().equalsIgnoreCase("1")) {
                        view2.findViewById(R.id.viewUnderLine).setVisibility(0);
                    }
                    if (menu2.getId().equalsIgnoreCase("20")) {
                        view2.findViewById(R.id.viewUnderLine).setVisibility(0);
                    }
                } else {
                    view3.findViewById(R.id.viewUnderLine).setVisibility(8);
                }
                i2++;
            }
            int i3 = 0;
            while (i3 < DashboardActivityTheme8.this.viewArrayList.size()) {
                if (view2 == DashboardActivityTheme8.this.viewArrayList.get(i3)) {
                    Menu menu3 = (Menu) view2.getTag();
                    String id = menu3.getId();
                    id.hashCode();
                    ?? r10 = -1;
                    r10 = -1;
                    r10 = -1;
                    r10 = -1;
                    r10 = -1;
                    r10 = -1;
                    r10 = -1;
                    r10 = -1;
                    r10 = -1;
                    r10 = -1;
                    r10 = -1;
                    r10 = -1;
                    r10 = -1;
                    r10 = -1;
                    r10 = -1;
                    r10 = -1;
                    r10 = -1;
                    r10 = -1;
                    switch (id.hashCode()) {
                        case 49:
                            if (id.equals(str)) {
                                r10 = z2;
                            }
                            break;
                        case 50:
                            if (id.equals("2")) {
                                r10 = 1;
                            }
                            break;
                        case 51:
                            if (id.equals("3")) {
                                r10 = 2;
                            }
                            break;
                        case 52:
                            if (id.equals("4")) {
                                r10 = 3;
                            }
                            break;
                        case 53:
                            if (id.equals("5")) {
                                r10 = 4;
                            }
                            break;
                        case 54:
                            if (id.equals("6")) {
                                r10 = 5;
                            }
                            break;
                        case 55:
                            if (id.equals("7")) {
                                r10 = 6;
                            }
                            break;
                        case 56:
                            if (id.equals("8")) {
                                r10 = 7;
                            }
                            break;
                        case 57:
                            if (id.equals("9")) {
                                r10 = c2;
                            }
                            break;
                        case 1567:
                            if (id.equals("10")) {
                                r10 = 9;
                            }
                            break;
                        case 1568:
                            if (id.equals("11")) {
                                r10 = 10;
                            }
                            break;
                        case 1569:
                            if (id.equals("12")) {
                                r10 = 11;
                            }
                            break;
                        case 1570:
                            if (id.equals("13")) {
                                r10 = 12;
                            }
                            break;
                        case 1573:
                            if (id.equals("16")) {
                                r10 = 13;
                            }
                            break;
                        case 1574:
                            if (id.equals("17")) {
                                r10 = 14;
                            }
                            break;
                        case 1576:
                            if (id.equals("19")) {
                                r10 = 15;
                            }
                            break;
                        case 1598:
                            if (id.equals("20")) {
                                r10 = 16;
                            }
                            break;
                    }
                    i = i3;
                    switch (r10 == true ? 1 : 0) {
                        case 0:
                            str2 = str;
                            DashboardActivityTheme8.this.isDailyDoseClicked = false;
                            DashboardActivityTheme8.this.isFeedsClicked = false;
                            DashboardActivityTheme8.this.dailyDoseCover.setVisibility(8);
                            DashboardActivityTheme8.this.dailyDoseRV.setVisibility(8);
                            DashboardActivityTheme8.this.noDataDailyDose.setVisibility(8);
                            z = false;
                            DashboardActivityTheme8.this.courseLayoutCover.setVisibility(0);
                            DashboardActivityTheme8.this.cvrNotificationRL.setVisibility(0);
                            DashboardActivityTheme8.this.toggle.setDrawerIndicatorEnabled(true);
                            c3 = '\b';
                            DashboardActivityTheme8.this.homeBackIV.setVisibility(8);
                            break;
                        case 1:
                            str2 = str;
                            DashboardActivityTheme8.this.isDailyDoseClicked = false;
                            Intent intent = new Intent(DashboardActivityTheme8.this, (Class<?>) CourseActivity.class);
                            intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY2);
                            intent.putExtra(Const.FRAG_TYPE, Const.DIRECTLAYER3);
                            intent.putExtra(Const.COURSE_ID_MAIN, menu3.getType_code());
                            intent.putExtra(Const.COURSE_PARENT_ID, "");
                            intent.putExtra(Const.SUB_CAT, "");
                            z = false;
                            intent.putExtra(Const.IS_COMBO, false);
                            intent.putExtra(AnalyticsConstants.course_name, menu3.getName());
                            Helper.gotoActivityTheme7(intent, DashboardActivityTheme8.this);
                            c3 = '\b';
                            break;
                        case 2:
                            str2 = str;
                            if (!Helper.isNetworkConnected(DashboardActivityTheme8.this)) {
                                Helper.showInternetToast(DashboardActivityTheme8.this);
                            } else {
                                z = false;
                                DashboardActivityTheme8.this.isDailyDoseClicked = false;
                                Helper.gotoActivityTheme7(DashboardActivityTheme8.this, (Class<?>) MyLibraryActivty.class);
                                c3 = '\b';
                            }
                            break;
                        case 3:
                            String str3 = str;
                            if (!Helper.isNetworkConnected(DashboardActivityTheme8.this)) {
                                Helper.showInternetToast(DashboardActivityTheme8.this);
                            } else {
                                DashboardActivityTheme8.this.isDailyDoseClicked = false;
                                Bundle bundle = new Bundle();
                                bundle.putInt(Const.NOTIFICATION_CODE, DashboardActivityTheme8.this.notification_code);
                                bundle.putString("course_id", DashboardActivityTheme8.this.course_id);
                                bundle.putString("file_id", DashboardActivityTheme8.this.fieldid);
                                bundle.putString(Const.TOPIC_ID, DashboardActivityTheme8.this.topicid);
                                bundle.putString("tile_id", DashboardActivityTheme8.this.tileid);
                                bundle.putString(Const.TILE_TYPE, DashboardActivityTheme8.this.tiletype);
                                bundle.putString(Const.REVERT_API, DashboardActivityTheme8.this.revertapi);
                                bundle.putString("title", DashboardActivityTheme8.this.title);
                                bundle.putString(TypedValues.AttributesType.S_TARGET, DashboardActivityTheme8.this.message_target);
                                bundle.putString("url", DashboardActivityTheme8.this.url);
                                bundle.putString("image", DashboardActivityTheme8.this.imageUrl);
                                bundle.putString("message", DashboardActivityTheme8.this.message);
                                bundle.putString("isFrom", Const.HOME);
                                if (DashboardActivityTheme8.this.courseTypeMasterTables.size() > 1) {
                                    bundle.putString(Const.TAB_ID, DashboardActivityTheme8.this.courseTypeMasterTables.get(0).getId());
                                    str2 = str3;
                                } else {
                                    str2 = str3;
                                    bundle.putString(Const.TAB_ID, str2);
                                }
                                if (DashboardActivityTheme8.this.courseTypeMasterTables.size() > 1) {
                                    bundle.putString(Const.TAB_NAME, DashboardActivityTheme8.this.courseTypeMasterTables.get(0).getName());
                                } else {
                                    bundle.putString(Const.TAB_NAME, "");
                                }
                                if (!GenericUtils.isListEmpty(DashboardActivityTheme8.this.courseTypeMasterTables) && !GenericUtils.isEmpty(DashboardActivityTheme8.this.courseTypeMasterTables.get(0).getMaster_category_id())) {
                                    bundle.putString(Const.MASTER_CATEGORY_ID, DashboardActivityTheme8.this.courseTypeMasterTables.get(0).getMaster_category_id());
                                } else {
                                    bundle.putString(Const.MASTER_CATEGORY_ID, "0");
                                }
                                Helper.gotoActivityTheme7(DashboardActivityTheme8.this, (Class<?>) HomeActivity.class);
                                c3 = '\b';
                                z = false;
                            }
                            break;
                        case 4:
                            str2 = str;
                            if (!Helper.isNetworkConnected(DashboardActivityTheme8.this)) {
                                Helper.showInternetToast(DashboardActivityTheme8.this);
                            } else {
                                DashboardActivityTheme8.this.isDailyDoseClicked = false;
                                Helper.gotoActivityTheme7(DashboardActivityTheme8.this, (Class<?>) Notification.class);
                                c3 = '\b';
                                z = false;
                            }
                            break;
                        case 5:
                            str2 = str;
                            DashboardActivityTheme8.this.isDailyDoseClicked = false;
                            Helper.gotoActivityTheme7(DashboardActivityTheme8.this, (Class<?>) DownloadActivity.class);
                            c3 = '\b';
                            z = false;
                            break;
                        case 6:
                            str2 = str;
                            if (!Helper.isNetworkConnected(DashboardActivityTheme8.this)) {
                                Helper.showInternetToast(DashboardActivityTheme8.this);
                            } else {
                                z = false;
                                DashboardActivityTheme8.this.isDailyDoseClicked = false;
                                Helper.gotoActivityTheme7(DashboardActivityTheme8.this, CreateTestActivity.class, str2);
                                c3 = '\b';
                            }
                            break;
                        case 7:
                            str2 = str;
                            if (!Helper.isNetworkConnected(DashboardActivityTheme8.this)) {
                                Helper.showInternetToast(DashboardActivityTheme8.this);
                            } else {
                                DashboardActivityTheme8.this.isDailyDoseClicked = false;
                                Helper.gotoActivityTheme7(DashboardActivityTheme8.this, (Class<?>) LivetestActivity.class);
                                c3 = '\b';
                                z = false;
                            }
                            break;
                        case 8:
                            str2 = str;
                            if (!Helper.isNetworkConnected(DashboardActivityTheme8.this)) {
                                Helper.showInternetToast(DashboardActivityTheme8.this);
                            } else {
                                DashboardActivityTheme8.this.isDailyDoseClicked = false;
                                Helper.gotoActivityTheme7(DashboardActivityTheme8.this, (Class<?>) LiveClassActivity.class);
                                c3 = '\b';
                                z = false;
                            }
                            break;
                        case 9:
                            str2 = str;
                            DashboardActivityTheme8.this.isDailyDoseClicked = false;
                            Data loggedInUser = SharedPreference.getInstance().getLoggedInUser();
                            if (loggedInUser != null && loggedInUser.getPreferences() != null && loggedInUser.getPreferences().size() > 0) {
                                Helper.gotoActivityTheme7(new Intent(DashboardActivityTheme8.this, (Class<?>) FeedsActivity.class), DashboardActivityTheme8.this);
                            } else {
                                Helper.gotoActivityTheme7(new Intent(DashboardActivityTheme8.this, (Class<?>) IntroActivity.class), DashboardActivityTheme8.this);
                            }
                            c3 = '\b';
                            z = false;
                            break;
                        case 10:
                            str2 = str;
                            if (!Helper.isNetworkConnected(DashboardActivityTheme8.this)) {
                                Helper.showInternetToast(DashboardActivityTheme8.this);
                            } else {
                                DashboardActivityTheme8.this.isDailyDoseClicked = false;
                                if (BuildConfig.FLAVOR.equalsIgnoreCase("WebShiksha") || BuildConfig.FLAVOR.equalsIgnoreCase("ICSHomework") || BuildConfig.FLAVOR.equalsIgnoreCase("professorofIQ")) {
                                    Helper.gotoActivityTheme7(DashboardActivityTheme8.this, (Class<?>) ProfileActivity.class);
                                } else {
                                    Helper.gotoActivityTheme7(DashboardActivityTheme8.this, (Class<?>) ProfileActivityTheme8.class);
                                }
                                c3 = '\b';
                                z = false;
                            }
                            break;
                        case 11:
                            str2 = str;
                            z = false;
                            DashboardActivityTheme8.this.isDailyDoseClicked = false;
                            DashboardActivityTheme8.this.openWhatsapp();
                            c3 = '\b';
                            break;
                        case 12:
                            DashboardActivityTheme8.this.isDailyDoseClicked = false;
                            if (str.equals("7")) {
                                Bundle bundle2 = new Bundle();
                                bundle2.putInt(Const.NOTIFICATION_CODE, DashboardActivityTheme8.this.notification_code);
                                bundle2.putString("course_id", DashboardActivityTheme8.this.course_id);
                                bundle2.putString("file_id", DashboardActivityTheme8.this.fieldid);
                                bundle2.putString(Const.TOPIC_ID, DashboardActivityTheme8.this.topicid);
                                bundle2.putString("tile_id", DashboardActivityTheme8.this.tileid);
                                bundle2.putString(Const.TILE_TYPE, DashboardActivityTheme8.this.tiletype);
                                bundle2.putString(Const.REVERT_API, DashboardActivityTheme8.this.revertapi);
                                bundle2.putString("title", DashboardActivityTheme8.this.title);
                                bundle2.putString("searchenable", "0");
                                bundle2.putString(TypedValues.AttributesType.S_TARGET, DashboardActivityTheme8.this.message_target);
                                bundle2.putString("url", DashboardActivityTheme8.this.url);
                                bundle2.putString("image", DashboardActivityTheme8.this.imageUrl);
                                bundle2.putString("message", DashboardActivityTheme8.this.message);
                                bundle2.putString(Const.MASTER_CATEGORY_ID, DashboardActivityTheme8.this.mastercatid);
                                bundle2.putString("fromWhere", "freeStuff");
                                bundle2.putString("isFrom", Const.HOME);
                                bundle2.putString(Const.TAB_NAME, menu3.getName());
                                if (menu3.getType_code() != null && !menu3.getType_code().equalsIgnoreCase("")) {
                                    bundle2.putString(Const.TAB_ID, menu3.getType_code());
                                } else {
                                    bundle2.putString(Const.TAB_ID, str);
                                }
                                DashboardActivityTheme8.this.startActivity(new Intent(DashboardActivityTheme8.this, (Class<?>) HomeActivity.class).putExtras(bundle2));
                                str2 = str;
                                c3 = '\b';
                                z = false;
                            } else {
                                String str4 = str;
                                Bundle bundle3 = new Bundle();
                                bundle3.putInt(Const.NOTIFICATION_CODE, DashboardActivityTheme8.this.notification_code);
                                bundle3.putString("course_id", DashboardActivityTheme8.this.course_id);
                                bundle3.putString("file_id", DashboardActivityTheme8.this.fieldid);
                                bundle3.putString(Const.TOPIC_ID, DashboardActivityTheme8.this.topicid);
                                bundle3.putString("tile_id", DashboardActivityTheme8.this.tileid);
                                bundle3.putString(Const.TILE_TYPE, DashboardActivityTheme8.this.tiletype);
                                bundle3.putString(Const.REVERT_API, DashboardActivityTheme8.this.revertapi);
                                bundle3.putString("title", DashboardActivityTheme8.this.title);
                                bundle3.putString("searchenable", "0");
                                bundle3.putString(TypedValues.AttributesType.S_TARGET, DashboardActivityTheme8.this.message_target);
                                bundle3.putString("url", DashboardActivityTheme8.this.url);
                                bundle3.putString("image", DashboardActivityTheme8.this.imageUrl);
                                bundle3.putString("message", DashboardActivityTheme8.this.message);
                                bundle3.putString(Const.TAB_NAME, menu3.getName());
                                bundle3.putString("isFrom", Const.HOME);
                                if (menu3.getType_code() != null && !menu3.getType_code().equalsIgnoreCase("")) {
                                    bundle3.putString(Const.TAB_ID, menu3.getType_code());
                                    str2 = str4;
                                } else {
                                    str2 = str4;
                                    bundle3.putString(Const.TAB_ID, str2);
                                }
                                DashboardActivityTheme8.this.startActivity(new Intent(DashboardActivityTheme8.this, (Class<?>) HomeActivity.class).putExtras(bundle3));
                                c3 = '\b';
                                z = false;
                            }
                            break;
                        case 13:
                            if (!Helper.isNetworkConnected(DashboardActivityTheme8.this)) {
                                Helper.showInternetToast(DashboardActivityTheme8.this);
                            } else {
                                Helper.gotoActivityTheme7(DashboardActivityTheme8.this, (Class<?>) DoubtsActivity.class);
                                str2 = str;
                                c3 = '\b';
                                z = false;
                            }
                            break;
                        case 14:
                            if (!Helper.isNetworkConnected(DashboardActivityTheme8.this)) {
                                Helper.showInternetToast(DashboardActivityTheme8.this);
                            } else {
                                Intent intent2 = new Intent(DashboardActivityTheme8.this, (Class<?>) CurrentAffairActivity.class);
                                intent2.putExtra("title_key", "Current Affair");
                                DashboardActivityTheme8.this.startActivity(intent2);
                                DashboardActivityTheme8.this.overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
                                str2 = str;
                                c3 = '\b';
                                z = false;
                            }
                            break;
                        case 15:
                            DashboardActivityTheme8.this.scrollView.setVisibility(8);
                            DashboardActivityTheme8.this.courseLayoutCover.setVisibility(8);
                            DashboardActivityTheme8.this.cvrNotificationRL.setVisibility(8);
                            DashboardActivityTheme8.this.feeds_ll.setVisibility(0);
                            DashboardActivityTheme8.this.toggle.setDrawerIndicatorEnabled(false);
                            DashboardActivityTheme8.this.homeBackIV.setVisibility(0);
                            DashboardActivityTheme8.this.isDailyDoseClicked = false;
                            DashboardActivityTheme8.this.isFeedsClicked = true;
                            if (DashboardActivityTheme8.this.bannerSlider.getAdapter().getItemCount() > 0) {
                                DashboardActivityTheme8.this.no_data_found_RL_1.setVisibility(8);
                            } else {
                                DashboardActivityTheme8.this.no_data_found_RL_1.setVisibility(0);
                            }
                            if (DashboardActivityTheme8.this.utkashRoom.getthemeSettingdao().is_setting_exit()) {
                                DashboardActivityTheme8.this.bottomSetting = (BottomSetting) new Gson().fromJson(DashboardActivityTheme8.this.utkashRoom.getthemeSettingdao().data().getBottom(), BottomSetting.class);
                                DashboardActivityTheme8.this.bottomLL.removeAllViews();
                                if (DashboardActivityTheme8.this.viewArrayList != null) {
                                    DashboardActivityTheme8.this.viewArrayList.clear();
                                }
                                for (int i4 = 0; i4 < Helper.getBottomMenu(DashboardActivityTheme8.this.bottomMenuTables).size(); i4++) {
                                    LinearLayout linearLayout = DashboardActivityTheme8.this.bottomLL;
                                    DashboardActivityTheme8 dashboardActivityTheme8 = DashboardActivityTheme8.this;
                                    linearLayout.addView(dashboardActivityTheme8.initBottomView(Helper.getBottomMenu(dashboardActivityTheme8.bottomMenuTables).get(i4), "19"));
                                }
                            }
                            str2 = str;
                            c3 = '\b';
                            z = false;
                            break;
                        case 16:
                            if (!Helper.isNetworkConnected(DashboardActivityTheme8.this)) {
                                Helper.showInternetToast(DashboardActivityTheme8.this);
                            } else {
                                DashboardActivityTheme8.this.isDailyDoseClicked = true;
                                DashboardActivityTheme8.this.isFeedsClicked = false;
                                DashboardActivityTheme8.this.toggle.setDrawerIndicatorEnabled(false);
                                DashboardActivityTheme8.this.homeBackIV.setVisibility(0);
                                DashboardActivityTheme8.this.dailyDoseCover.setVisibility(0);
                                if (DashboardActivityTheme8.this.dailyDoseFiltered.size() > 0) {
                                    DashboardActivityTheme8.this.dailyDoseRV.setVisibility(0);
                                } else {
                                    DashboardActivityTheme8.this.noDataDailyDose.setVisibility(0);
                                }
                                DashboardActivityTheme8.this.courseLayoutCover.setVisibility(8);
                                DashboardActivityTheme8.this.cvrNotificationRL.setVisibility(8);
                                c3 = '\b';
                                str2 = str;
                                z = false;
                            }
                            break;
                        default:
                            str2 = str;
                            c3 = '\b';
                            z = false;
                            break;
                    }
                    return;
                }
                z = z2;
                i = i3;
                str2 = str;
                c3 = c2;
                str = str2;
                c2 = c3;
                view2 = view;
                i3 = i + 1;
                z2 = z;
            }
        }
    };
    String[] langIds = {"1"};
    String is_paid = "";
    private int STORAGE_PERMISSION_TYPE = 3;
    public final int REQUEST_CODE_MULTIPLE_PIKER = 1203;

    private void getTileItems(ArrayList<Cards> cardsArrayList, int pos) {
    }

    public LinearLayout initBottomView(Menu menu) {
        LinearLayout linearLayout = (LinearLayout) View.inflate(this, R.layout.bottom_item, null);
        TextView textView = (TextView) linearLayout.findViewById(R.id.title);
        final ImageView imageView = (ImageView) linearLayout.findViewById(R.id.icon);
        RelativeLayout relativeLayout = (RelativeLayout) linearLayout.findViewById(R.id.viewUnderLine);
        textView.setText(menu.getName());
        Glide.with((FragmentActivity) this).asBitmap().load(menu.getImageUrl()).into(new CustomTarget<Bitmap>() { // from class: com.appnew.android.Theme.DashboardActivityTheme8.2
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
        if (menu.getId().equalsIgnoreCase("1")) {
            relativeLayout.setVisibility(0);
        }
        linearLayout.setOnClickListener(this.onClickListener);
        return linearLayout;
    }

    public LinearLayout initBottomView(Menu menu, String str) {
        LinearLayout linearLayout = (LinearLayout) View.inflate(this, R.layout.bottom_item, null);
        TextView textView = (TextView) linearLayout.findViewById(R.id.title);
        final ImageView imageView = (ImageView) linearLayout.findViewById(R.id.icon);
        RelativeLayout relativeLayout = (RelativeLayout) linearLayout.findViewById(R.id.viewUnderLine);
        textView.setText(menu.getName());
        Glide.with((FragmentActivity) this).asBitmap().load(menu.getImageUrl()).into(new CustomTarget<Bitmap>() { // from class: com.appnew.android.Theme.DashboardActivityTheme8.3
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
        DashboardActivityTheme8 dashboardActivityTheme8;
        Intent intent;
        final DashboardActivityTheme8 dashboardActivityTheme82 = this;
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(dashboardActivityTheme82);
        Helper.enableScreenShot(dashboardActivityTheme82);
        dashboardActivityTheme82.utkashRoom = UtkashRoom.getAppDatabase(dashboardActivityTheme82);
        ActivityHomeTheme8Binding activityHomeTheme8BindingInflate = ActivityHomeTheme8Binding.inflate(dashboardActivityTheme82.getLayoutInflater());
        dashboardActivityTheme82.binding = activityHomeTheme8BindingInflate;
        dashboardActivityTheme82.setContentView(activityHomeTheme8BindingInflate.getRoot());
        homeactivitytheme8 = dashboardActivityTheme82;
        Helper.setSystemBarLight(dashboardActivityTheme82);
        homeactivity = dashboardActivityTheme82;
        dashboardActivityTheme82.networkCall = new NetworkCall(dashboardActivityTheme82, dashboardActivityTheme82);
        dashboardActivityTheme82.setIds();
        FragmentManager supportFragmentManager = dashboardActivityTheme82.getSupportFragmentManager();
        dashboardActivityTheme82.fragmentManager = supportFragmentManager;
        supportFragmentManager.beginTransaction().setCustomAnimations(R.anim.activity_in, R.anim.activity_out, R.anim.activity_in, R.anim.activity_out);
        dashboardActivityTheme82.fragment = dashboardActivityTheme82.fragmentManager.findFragmentById(R.id.chatboat);
        AppUpdateManager appUpdateManagerCreate = AppUpdateManagerFactory.create(dashboardActivityTheme82);
        dashboardActivityTheme82.mAppUpdateManager = appUpdateManagerCreate;
        dashboardActivityTheme82.appUpdateInfoTask = appUpdateManagerCreate.getAppUpdateInfo();
        InstallStateUpdatedListener installStateUpdatedListener = new InstallStateUpdatedListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda24
            @Override // com.google.android.play.core.listener.StateUpdatedListener
            public final void onStateUpdate(InstallState installState) {
                this.f$0.lambda$onCreate$0(installState);
            }
        };
        dashboardActivityTheme82.installStateUpdatedListener = installStateUpdatedListener;
        dashboardActivityTheme82.mAppUpdateManager.registerListener(installStateUpdatedListener);
        dashboardActivityTheme82.inAppUpdateType = 0;
        dashboardActivityTheme82.checkAppUpdate();
        MakeMyExam.userId = SharedPreference.getInstance().getLoggedInUser().getId();
        FirebaseCrashlytics.getInstance().setUserId(MakeMyExam.userId);
        dashboardActivityTheme82.courselists.clear();
        dashboardActivityTheme82.backBtn.setVisibility(8);
        AdapterDashTile2Theme8 adapterDashTile2Theme8 = new AdapterDashTile2Theme8(dashboardActivityTheme82, dashboardActivityTheme82);
        dashboardActivityTheme82.dashboardTabAdapter = adapterDashTile2Theme8;
        dashboardActivityTheme82.browseByCoursesRecycler.setAdapter(adapterDashTile2Theme8);
        if (dashboardActivityTheme82.getIntent() != null) {
            int intExtra = dashboardActivityTheme82.getIntent().getIntExtra(Const.NOTIFICATION_CODE, 0);
            dashboardActivityTheme82.notification_code = intExtra;
            if (intExtra != 0) {
                dashboardActivityTheme82.pushEventForPushNotification("" + dashboardActivityTheme82.notification_code);
            }
            dashboardActivityTheme82.course_id = dashboardActivityTheme82.getIntent().getStringExtra("course_id");
            dashboardActivityTheme82.fieldid = dashboardActivityTheme82.getIntent().getStringExtra("file_id");
            dashboardActivityTheme82.coupon_for = dashboardActivityTheme82.getIntent().getStringExtra("coupon_for");
            dashboardActivityTheme82.ts = dashboardActivityTheme82.getIntent().getLongExtra(CTProductConfigConstants.KEY_LAST_FETCHED_TIMESTAMP, 0L);
            dashboardActivityTheme82.post_id = dashboardActivityTheme82.getIntent().getStringExtra("post_id");
            dashboardActivityTheme82.audioTable = (AudioTable) dashboardActivityTheme82.getIntent().getSerializableExtra("audiotable");
            dashboardActivityTheme82.topicid = dashboardActivityTheme82.getIntent().getStringExtra(Const.TOPIC_ID);
            dashboardActivityTheme82.video_type = dashboardActivityTheme82.getIntent().getStringExtra("type");
            dashboardActivityTheme82.tiletype = dashboardActivityTheme82.getIntent().getStringExtra(Const.TILE_TYPE);
            dashboardActivityTheme82.tileid = dashboardActivityTheme82.getIntent().getStringExtra("tile_id");
            dashboardActivityTheme82.revertapi = dashboardActivityTheme82.getIntent().getStringExtra(Const.REVERT_API);
            dashboardActivityTheme82.type = dashboardActivityTheme82.getIntent().getStringExtra("type");
            dashboardActivityTheme82.title = dashboardActivityTheme82.getIntent().getStringExtra("title");
            dashboardActivityTheme82.message_target = dashboardActivityTheme82.getIntent().getStringExtra(TypedValues.AttributesType.S_TARGET);
            dashboardActivityTheme82.url = dashboardActivityTheme82.getIntent().getStringExtra("url");
            dashboardActivityTheme82.imageUrl = dashboardActivityTheme82.getIntent().getStringExtra("imageUrl");
            dashboardActivityTheme82.message = dashboardActivityTheme82.getIntent().getStringExtra("description");
            dashboardActivityTheme82.parentid = dashboardActivityTheme82.getIntent().getStringExtra(Const.shareparentid);
            dashboardActivityTheme82.test_series_name = dashboardActivityTheme82.getIntent().getStringExtra("test_series_name");
            dashboardActivityTheme82.solutions = dashboardActivityTheme82.getIntent().getStringExtra("solutions");
            dashboardActivityTheme82.test_series_date = dashboardActivityTheme82.getIntent().getStringExtra("result_date");
            dashboardActivityTheme82.id = dashboardActivityTheme82.getIntent().getStringExtra("id");
            if (dashboardActivityTheme82.getIntent().hasExtra(Const.BATCH_ID)) {
                dashboardActivityTheme82.batch_id = dashboardActivityTheme82.getIntent().getStringExtra(Const.BATCH_ID);
            }
            if (dashboardActivityTheme82.getIntent().hasExtra("isForDoubt")) {
                dashboardActivityTheme82.isDoubtActive = dashboardActivityTheme82.getIntent().getBooleanExtra("isForDoubt", false);
            }
            String str4 = dashboardActivityTheme82.parentid;
            if (str4 == null) {
                str4 = "";
            }
            dashboardActivityTheme82.parentid = str4;
            if (!SharedPreference.getInstance().getBoolean(Const.IS_USER_LOGGED_IN) && !SharedPreference.getInstance().getBoolean(Const.IS_NOTIFICATION_BLOCKED)) {
                dashboardActivityTheme82.finish();
                dashboardActivityTheme82.startActivity(new Intent(dashboardActivityTheme82, (Class<?>) SplashScreen.class).putExtras(dashboardActivityTheme82.getIntent().getExtras()).setFlags(268468224));
                return;
            }
            int i = dashboardActivityTheme82.notification_code;
            if (i == 90002) {
                dashboardActivityTheme82.hit_api_for_data();
            } else if (i == 90001) {
                if (dashboardActivityTheme82.message_target.equalsIgnoreCase("6")) {
                    intent = new Intent(dashboardActivityTheme82, (Class<?>) WebFragActivity.class);
                    intent.putExtra("title", dashboardActivityTheme82.title);
                    intent.putExtra("url", dashboardActivityTheme82.url);
                    intent.putExtra("imageUrl", dashboardActivityTheme82.imageUrl);
                } else if (dashboardActivityTheme82.message_target.equalsIgnoreCase("2")) {
                    Intent intent2 = new Intent(dashboardActivityTheme82, (Class<?>) CourseActivity.class);
                    intent2.putExtra(Const.FRAG_TYPE, Const.COURSE_DETAILS_FOR_THEME7);
                    intent2.putExtra("isFromDashBoard8", "1");
                    intent2.putExtra(Const.COURSE_ID_MAIN, dashboardActivityTheme82.course_id);
                    intent2.putExtra(Const.COURSE_PARENT_ID, "");
                    intent2.putExtra(Const.IS_COMBO, false);
                    intent2.putExtra(Const.BATCH_ID, dashboardActivityTheme82.batch_id);
                    intent2.putExtra("title", dashboardActivityTheme82.title);
                    SharedPreference.getInstance().putString("id", dashboardActivityTheme82.course_id);
                    intent = intent2;
                } else if (dashboardActivityTheme82.message_target.equalsIgnoreCase("5")) {
                    intent = new Intent(dashboardActivityTheme82, (Class<?>) NotificationDescription.class);
                    intent.putExtra("urlType", "IMAGE");
                    intent.putExtra("title", dashboardActivityTheme82.title);
                    intent.putExtra("url", dashboardActivityTheme82.url);
                    intent.putExtra("imageUrl", dashboardActivityTheme82.imageUrl);
                    intent.putExtra("description", dashboardActivityTheme82.message);
                } else if (dashboardActivityTheme82.message_target.equalsIgnoreCase("1")) {
                    intent = new Intent(dashboardActivityTheme82, (Class<?>) WebFragActivity.class);
                    intent.putExtra("title", dashboardActivityTheme82.title);
                    intent.putExtra("url", dashboardActivityTheme82.message);
                    intent.putExtra("from", "noti");
                } else if (dashboardActivityTheme82.message_target.equalsIgnoreCase("8")) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    long j = dashboardActivityTheme82.ts;
                    if (jCurrentTimeMillis > j * 1000) {
                        if (dashboardActivityTheme82.coupon_for.equalsIgnoreCase("1")) {
                            Toast.makeText(dashboardActivityTheme82, "This coupon is available for all courses", 0).show();
                            dashboardActivityTheme82.initialzehomepage();
                        } else if (dashboardActivityTheme82.coupon_for.equalsIgnoreCase("0") || dashboardActivityTheme82.coupon_for.equalsIgnoreCase("2")) {
                            intent = new Intent(dashboardActivityTheme82, (Class<?>) CouponActivity.class);
                        } else {
                            intent = new Intent(dashboardActivityTheme82, (Class<?>) WebFragActivity.class);
                            intent.putExtra("title", dashboardActivityTheme82.title);
                            intent.putExtra("url", dashboardActivityTheme82.message);
                            intent.putExtra("from", "noti");
                        }
                    } else {
                        if (j != 0) {
                            Toast.makeText(dashboardActivityTheme82, "This coupon is available on " + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.US).format(new Date(dashboardActivityTheme82.ts * 1000))), 0).show();
                        }
                        dashboardActivityTheme82.initialzehomepage();
                    }
                    intent = null;
                } else {
                    intent = new Intent(dashboardActivityTheme82, (Class<?>) WebFragActivity.class);
                    intent.putExtra("title", dashboardActivityTheme82.title);
                    intent.putExtra("url", dashboardActivityTheme82.message);
                    intent.putExtra("from", "noti");
                }
                if (intent != null) {
                    Helper.gotoActivity(intent, dashboardActivityTheme82);
                }
            } else if (i == 90006) {
                Intent intent3 = new Intent(dashboardActivityTheme82, (Class<?>) ConversationReplyActivity.class);
                intent3.putExtra(Const.CONTATUS_ID, dashboardActivityTheme82.id);
                intent3.putExtra(Const.APP_ID, "166");
                dashboardActivityTheme82.startActivity(intent3);
            } else if (i == 90005) {
                if (Long.parseLong(dashboardActivityTheme82.test_series_date) * 1000 < System.currentTimeMillis()) {
                    if (!Helper.isConnected(dashboardActivityTheme82)) {
                        Toast.makeText(dashboardActivityTheme82, R.string.no_internet_connection, 0).show();
                        dashboardActivityTheme82.initialzehomepage();
                    } else {
                        Constants.SUB_TEST_ID = dashboardActivityTheme82.fieldid;
                        Constants.Live_TEST_COURSEID = dashboardActivityTheme82.course_id;
                        Helper.GoToSubjectiveResultActivity(dashboardActivityTheme82, dashboardActivityTheme82.solutions, dashboardActivityTheme82.test_series_name, dashboardActivityTheme82.course_id, dashboardActivityTheme82.fieldid, Const.SUBJECTIVE_TEST);
                        dashboardActivityTheme82 = dashboardActivityTheme82;
                    }
                } else {
                    Toast.makeText(dashboardActivityTheme82, dashboardActivityTheme82.getResources().getString(R.string.result_will_be_available_on) + new SimpleDateFormat("dd/MM/yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(dashboardActivityTheme82.test_series_date) * 1000)), 0).show();
                    dashboardActivityTheme82.initialzehomepage();
                }
            } else if (i == 123 || i == 124 || i == 125) {
                str = "1";
                dashboardActivityTheme82.hit_api_for_data();
            } else {
                AudioTable audioTable = dashboardActivityTheme82.audioTable;
                if (audioTable != null && audioTable.getVideo_id() != null && !dashboardActivityTheme82.audioTable.getVideo_id().equalsIgnoreCase("")) {
                    dashboardActivityTheme82.notification_code = 109010;
                    String str5 = dashboardActivityTheme82.video_type;
                    if (str5 != null && str5.equalsIgnoreCase("jw")) {
                        Intent intent4 = new Intent(dashboardActivityTheme82, (Class<?>) AudioPlayerActivty.class);
                        AudioPlayerService.videoid = "";
                        intent4.putExtra("url", dashboardActivityTheme82.audioTable.getAudio_url());
                        intent4.putExtra("videoid", dashboardActivityTheme82.audioTable.getVideo_id());
                        intent4.putExtra("currentpos", dashboardActivityTheme82.audioTable.getAudio_currentpos());
                        intent4.putExtra("video_name", dashboardActivityTheme82.audioTable.getVideo_name());
                        intent4.putExtra("image_url", dashboardActivityTheme82.audioTable.getJw_url() + "/poster.jpg?width=720");
                        intent4.putExtra("course_id", dashboardActivityTheme82.audioTable.getCourse_id());
                        Helper.gotoActivity(intent4, dashboardActivityTheme82);
                    }
                } else {
                    String str6 = dashboardActivityTheme82.video_type;
                    if (str6 != null && str6.contains("youtube_")) {
                        dashboardActivityTheme82.notification_code = 109010;
                        UserHistroyTable userHistroyTableUser_history = dashboardActivityTheme82.utkashRoom.getuserhistorydao().user_history(MakeMyExam.userId, dashboardActivityTheme82.getIntent().getStringExtra("type").split("_")[1]);
                        if (userHistroyTableUser_history != null) {
                            String str7 = "http://img.youtube.com/vi/" + userHistroyTableUser_history.getYoutube_url() + "/0.jpg";
                            if (userHistroyTableUser_history.getTileid() == null || userHistroyTableUser_history.getTileid().equalsIgnoreCase("")) {
                                str = "1";
                                Helper.GoToLiveVideoActivity("", dashboardActivityTheme82, userHistroyTableUser_history.getYoutube_url(), "1", userHistroyTableUser_history.getVideo_id(), userHistroyTableUser_history.getVideo_name(), "1", str7, "1", userHistroyTableUser_history.getCourse_id(), String.valueOf(1), dashboardActivityTheme82.parentid, dashboardActivityTheme82.tileid, "Video", new ArrayList());
                            } else {
                                str = "1";
                                Helper.GoToLiveVideoActivity("", dashboardActivityTheme82, userHistroyTableUser_history.getYoutube_url(), "1", userHistroyTableUser_history.getVideo_id(), userHistroyTableUser_history.getVideo_name(), "1", str7, "1", userHistroyTableUser_history.getCourse_id(), String.valueOf(1), dashboardActivityTheme82.parentid, userHistroyTableUser_history.getTileid(), "Video", new ArrayList());
                            }
                        } else {
                            str = "1";
                            dashboardActivityTheme82.initialzehomepage();
                        }
                    } else {
                        str = "1";
                        String str8 = dashboardActivityTheme82.video_type;
                        if (str8 != null && str8.contains("aws")) {
                            dashboardActivityTheme82.notification_code = 109010;
                            UserHistroyTable userHistroyTableUser_history2 = dashboardActivityTheme82.utkashRoom.getuserhistorydao().user_history(MakeMyExam.userId, dashboardActivityTheme82.getIntent().getStringExtra("type").split("_")[1]);
                            if (userHistroyTableUser_history2 != null) {
                                if (userHistroyTableUser_history2.getYoutube_url().split("ayush").length == 2) {
                                    dashboardActivityTheme8 = this;
                                    Helper.GoToLiveAwsVideoActivity("0", "", dashboardActivityTheme8, userHistroyTableUser_history2.getYoutube_url().split("ayush")[0], "0", userHistroyTableUser_history2.getVideo_id(), userHistroyTableUser_history2.getVideo_name(), "1", userHistroyTableUser_history2.getYoutube_url().split("ayush")[1], userHistroyTableUser_history2.getCourse_id(), userHistroyTableUser_history2.getTileid(), "Video", "1", "", dashboardActivityTheme82.parentid, "", new ArrayList());
                                } else {
                                    dashboardActivityTheme8 = this;
                                    Helper.GoToLiveAwsVideoActivity("0", "", dashboardActivityTheme8, userHistroyTableUser_history2.getYoutube_url().split("ayush")[0], "0", userHistroyTableUser_history2.getVideo_id(), userHistroyTableUser_history2.getVideo_name(), "1", "", userHistroyTableUser_history2.getCourse_id(), userHistroyTableUser_history2.getTileid(), "Video", "1", "", dashboardActivityTheme82.parentid, "", new ArrayList());
                                }
                                dashboardActivityTheme82 = dashboardActivityTheme8;
                            } else {
                                dashboardActivityTheme82.initialzehomepage();
                            }
                        } else {
                            int i2 = dashboardActivityTheme82.notification_code;
                            if (i2 == 0) {
                                if (Helper.isNetworkConnected(dashboardActivityTheme82)) {
                                    if (dashboardActivityTheme82.utkashRoom.getMasterAllCatDao().isRecordExistsUserId(MakeMyExam.userId)) {
                                        dashboardActivityTheme82.courseTypeMasterTables.clear();
                                        dashboardActivityTheme82.masterAllCatTables.clear();
                                        dashboardActivityTheme82.mastercatlist.clear();
                                        dashboardActivityTheme82.LanguagesTable.clear();
                                        dashboardActivityTheme82.bannerListTables.clear();
                                        dashboardActivityTheme82.bottomMenuTables.clear();
                                        AsyncTask.execute(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda25
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                this.f$0.lambda$onCreate$2();
                                            }
                                        });
                                    } else {
                                        dashboardActivityTheme82.hit_api_master_data();
                                    }
                                }
                            } else if (i2 == 101) {
                                dashboardActivityTheme82.checkdeeplick();
                            } else if (i2 == 1001001 && (str3 = dashboardActivityTheme82.post_id) != null && !TextUtils.isEmpty(str3)) {
                                Intent intent5 = new Intent(dashboardActivityTheme82, (Class<?>) FeedDetails.class);
                                intent5.putExtra("postId", dashboardActivityTheme82.post_id);
                                Helper.gotoActivity(intent5, dashboardActivityTheme82);
                            }
                        }
                    }
                }
            }
            str = "1";
        } else {
            str = "1";
        }
        dashboardActivityTheme82.homeBackIV.setVisibility(8);
        dashboardActivityTheme82.setHomeDrawer();
        dashboardActivityTheme82.createMenus();
        dashboardActivityTheme82.setClicks();
        dashboardActivityTheme82.chatboat.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$3(savedInstanceState);
            }
        }));
        dashboardActivityTheme82.pullToReferesh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme8.5
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                APITABLE apitable = DashboardActivityTheme8.this.utkashRoom.getapidao().getapidetail("ut_009", MakeMyExam.userId);
                if (Long.parseLong(apitable.getTimestamp()) + Long.parseLong(apitable.getInterval()) < System.currentTimeMillis() / 1000) {
                    DashboardActivityTheme8.this.utkashRoom.getLaunguages().deletedata();
                    DashboardActivityTheme8.this.utkashRoom.getMasterAllCatDao().deletedata();
                    DashboardActivityTheme8.this.utkashRoom.getMastercatDao().deletedata();
                    DashboardActivityTheme8.this.utkashRoom.getcoursetypemaster().deletedata();
                    DashboardActivityTheme8.this.pullrefresh = true;
                    DashboardActivityTheme8.this.initialState();
                    DashboardActivityTheme8.this.isfilterchanged = false;
                    DashboardActivityTheme8.this.subjectindex = "";
                    DashboardActivityTheme8.this.launguageindex = "";
                    DashboardActivityTheme8.this.SelectedLaunguageid = "";
                    DashboardActivityTheme8.this.SelectedSubjectid = "";
                    DashboardActivityTheme8.this.is_paid = "";
                    DashboardActivityTheme8.this.ispaginationavailable = false;
                    DashboardActivityTheme8.this.isfilterapply = false;
                    DashboardActivityTheme8.this.hit_api_master_data();
                    DashboardActivityTheme8.this.pullToReferesh.setRefreshing(false);
                    return;
                }
                DashboardActivityTheme8.this.pullToReferesh.setRefreshing(false);
            }
        });
        dashboardActivityTheme82.browseByCoursesRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme8.6
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                DashboardActivityTheme8.this.toggleRefreshing(newState == 0);
            }
        });
        dashboardActivityTheme82.dailyDoseRV.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme8.7
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                DashboardActivityTheme8.this.toggleRefreshing(newState == 0);
            }
        });
        if (Helper.isNetworkConnected(dashboardActivityTheme82) || !dashboardActivityTheme82.utkashRoom.getthemeSettingdao().is_setting_exit() || (themeSettingsData = dashboardActivityTheme82.utkashRoom.getthemeSettingdao().data()) == null) {
            return;
        }
        LeftMenu leftMenu = (LeftMenu) new Gson().fromJson(themeSettingsData.getLeft_menu(), LeftMenu.class);
        BottomMenu bottomMenu = (BottomMenu) new Gson().fromJson(themeSettingsData.getBottom(), BottomMenu.class);
        if (leftMenu != null) {
            str2 = str;
            if (!leftMenu.getDownloads().equalsIgnoreCase(str2)) {
            }
            Helper.goToDownloadsOfflineMode(dashboardActivityTheme82);
        }
        str2 = str;
        if (bottomMenu == null || bottomMenu.getDownloads() == null || !bottomMenu.getDownloads().equalsIgnoreCase(str2)) {
            return;
        }
        Helper.goToDownloadsOfflineMode(dashboardActivityTheme82);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(InstallState installState) {
        if (installState.installStatus() == 11) {
            popupSnackbarForCompleteUpdate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2() {
        try {
            if (!this.utkashRoom.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread()) {
                this.courseTypeMasterTables = this.utkashRoom.getcoursetypemaster().getcourse_typemaster(MakeMyExam.userId);
                this.masterAllCatTables = this.utkashRoom.getMasterAllCatDao().getmaster_allcat(MakeMyExam.userId);
                this.mastercatlist = this.utkashRoom.getMastercatDao().getmastercat(MakeMyExam.userId);
                this.LanguagesTable = this.utkashRoom.getLaunguages().getLaunguagedetail();
                this.bannerListTables = this.utkashRoom.getBannerTableDao().getBanner(MakeMyExam.getUserId());
                this.bottomMenuTables = this.utkashRoom.getBottomMenuTableDao().getBottomMenu(MakeMyExam.getUserId());
            }
            runOnUiThread(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda17
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onCreate$1();
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1() {
        setMasterData();
        selecteddata();
        if (this.isDoubtActive) {
            this.toggle.setDrawerIndicatorEnabled(false);
            this.homeBackIV.setVisibility(0);
            this.dailyDoseCover.setVisibility(0);
            if (this.dailyDoseFiltered.size() > 0) {
                this.dailyDoseRV.setVisibility(0);
            } else {
                this.noDataDailyDose.setVisibility(0);
            }
            this.courseLayoutCover.setVisibility(8);
            this.cvrNotificationRL.setVisibility(8);
            return;
        }
        this.dailyDoseCover.setVisibility(8);
        this.dailyDoseRV.setVisibility(8);
        this.noDataDailyDose.setVisibility(8);
        this.courseLayoutCover.setVisibility(0);
        this.cvrNotificationRL.setVisibility(0);
        this.toggle.setDrawerIndicatorEnabled(true);
        this.homeBackIV.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$3(Bundle bundle) {
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

    private void setIds() {
        this.cartLL = (LinearLayout) findViewById(R.id.cartLL);
        this.rootView = (CoordinatorLayout) findViewById(R.id.rootView);
        this.viewPager = (EnhancedWrapContentViewPager) findViewById(R.id.view_pager_videos_parent);
        this.layoutDots_Mode = (LinearLayout) findViewById(R.id.layoutDots_Mode);
        this.toolbartitleTV = (TextView) findViewById(R.id.toolbartitleTV);
        this.parentRL = (ImageView) findViewById(R.id.parentRL);
        this.courseLayoutCover = (LinearLayout) findViewById(R.id.courseLayoutCover);
        this.cvrNotificationRL = (RelativeLayout) findViewById(R.id.cvrNotificationRL);
        this.iconFacebook = (ImageView) findViewById(R.id.iconFacebook);
        this.iconInstagram = (ImageView) findViewById(R.id.iconInstagram);
        this.iconLinkedIn = (ImageView) findViewById(R.id.iconLinkedIn);
        this.iconTwitter = (ImageView) findViewById(R.id.iconTwitter);
        this.iconWebsite = (ImageView) findViewById(R.id.icon_website);
        this.iconYoutube = (ImageView) findViewById(R.id.iconYoutube);
        this.iconTelegram = (ImageView) findViewById(R.id.iconTelegram);
        this.pullToReferesh = (SwipeRefreshLayout) findViewById(R.id.pullto_referesh);
        this.notificaionCount = (TextView) findViewById(R.id.notificaionCount);
        this.cvrNotificationCount = (LinearLayout) findViewById(R.id.cvrNotificationCount);
        this.pullToReferesh.setRefreshing(false);
        this.liveclass = (LinearLayout) findViewById(R.id.liveclass);
        this.libLL = (LinearLayout) findViewById(R.id.libLL);
        this.livetest = (LinearLayout) findViewById(R.id.livetest);
        this.bottomLL = (LinearLayout) findViewById(R.id.bottomLL);
        this.livetestLL = (LinearLayout) findViewById(R.id.livetestLL);
        this.liveclassLL = (LinearLayout) findViewById(R.id.liveclassLL);
        this.CourseLL = (LinearLayout) findViewById(R.id.CourseLL);
        this.filter = (RelativeLayout) findViewById(R.id.filter);
        this.forchatbot = (FrameLayout) findViewById(R.id.forchatbot);
        this.filterOne = (TextView) findViewById(R.id.filterOne);
        this.viewPagerRL = (RelativeLayout) findViewById(R.id.viewPagerRL);
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
        this.feeds_ll = (RelativeLayout) findViewById(R.id.feeds_ll);
        this.no_data_found_RL_1 = (RelativeLayout) findViewById(R.id.no_data_found_RL_1);
        this.bannerSlider = (RecyclerView) findViewById(R.id.bannerSlider);
        this.chromecast = (ImageButton) findViewById(R.id.chromecast);
        this.searchIV = (ImageView) findViewById(R.id.searchIV);
        this.chatboat = (ImageView) findViewById(R.id.chatboat);
        this.ivWhatsapp = (ImageView) findViewById(R.id.iv_whatsapp);
        this.browseByCoursesRecycler = (RecyclerView) findViewById(R.id.tileRv);
        this.dailyDoseRV = (RecyclerView) findViewById(R.id.dailyDoseRV);
        this.dailyDoseCover = (RelativeLayout) findViewById(R.id.dailyDoseCover);
        this.noDataDailyDose = (RelativeLayout) findViewById(R.id.noDataDailyDose);
        this.testLL = (LinearLayout) findViewById(R.id.testLL);
        this.homeLL = (LinearLayout) findViewById(R.id.homeLL);
        this.navigationView = (NavigationView) findViewById(R.id.nav_view);
        this.drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        this.toolbar = (Toolbar) findViewById(R.id.feeds_toolbar);
        this.my_library = (LinearLayout) findViewById(R.id.my_library);
        this.nav_headerLL = (LinearLayout) findViewById(R.id.nav_headerLL);
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
        this.TopperreviewIV = (ImageView) findViewById(R.id.TopperreviewIV);
        this.testseries_txt = (TextView) findViewById(R.id.testseries_txt);
        this.browseBySublayout = (RelativeLayout) findViewById(R.id.cvr1);
        this.browseByModelayout = (RelativeLayout) findViewById(R.id.browse_by_mode);
        this.containt_layout = (RelativeLayout) findViewById(R.id.containt_layout);
    }

    private void setClicks() {
        this.homeBackIV.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$4();
            }
        }));
        this.profileLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setClicks$5(view);
            }
        });
        this.my_library.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$6();
            }
        }));
        this.libLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$7();
            }
        }));
        this.livetest.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$8();
            }
        }));
        this.liveclassLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$9();
            }
        }));
        this.livetestLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$10();
            }
        }));
        this.nav_headerLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$11();
            }
        }));
        this.liveclass.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$12();
            }
        }));
        this.homeLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$13();
            }
        }));
        this.testLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda33
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$14();
            }
        }));
        this.filter.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda37
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$17();
            }
        }));
        this.chromecast.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda38
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$18();
            }
        }));
        this.searchIV.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda39
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$19();
            }
        }));
        if (BuildConfig.FLAVOR.equalsIgnoreCase("WebShiksha") || BuildConfig.FLAVOR.equalsIgnoreCase("ICSHomework") || BuildConfig.FLAVOR.equalsIgnoreCase("professorofIQ")) {
            this.ivWhatsapp.setVisibility(4);
        }
        this.ivWhatsapp.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda40
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$20();
            }
        }));
        this.filter_one_click.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda41
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$21();
            }
        }));
        this.filter_two_click.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda42
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setClicks$22();
            }
        }));
        this.cartLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setClicks$23(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$4() {
        onBackPressed();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setClicks$5(View view) {
        Intent intent = new Intent(this, (Class<?>) CourseActivity.class);
        intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY2);
        intent.putExtra(Const.COURSE_ID_MAIN, "333");
        intent.putExtra(Const.COURSE_PARENT_ID, "");
        intent.putExtra(Const.SUB_CAT, this.allsubcatindex_id);
        intent.putExtra(Const.IS_COMBO, false);
        intent.putExtra(AnalyticsConstants.course_name, "Demo Videos");
        Helper.gotoActivity(intent, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$6() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, (Class<?>) MyLibraryActivty.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$7() {
        Bundle bundle = new Bundle();
        bundle.putInt(Const.NOTIFICATION_CODE, this.notification_code);
        bundle.putString("course_id", this.course_id);
        bundle.putString("file_id", this.fieldid);
        bundle.putString(Const.TOPIC_ID, this.topicid);
        bundle.putString("tile_id", this.tileid);
        bundle.putString(Const.TILE_TYPE, this.tiletype);
        bundle.putString(Const.REVERT_API, this.revertapi);
        bundle.putString("title", this.title);
        bundle.putString(TypedValues.AttributesType.S_TARGET, this.message_target);
        bundle.putString("url", this.url);
        bundle.putString("image", this.imageUrl);
        bundle.putString("message", this.message);
        if (GenericUtils.isListEmpty(this.offline)) {
            bundle.putString(Const.TAB_ID, "126");
        } else {
            bundle.putString(Const.TAB_ID, "126");
        }
        startActivity(new Intent(this, (Class<?>) HomeActivity.class).putExtras(bundle));
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
        Helper.gotoActivity(this, (Class<?>) LiveClassActivity.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$10() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, (Class<?>) LivetestActivity.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$11() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        if (BuildConfig.FLAVOR.equalsIgnoreCase("WebShiksha") || BuildConfig.FLAVOR.equalsIgnoreCase("ICSHomework") || BuildConfig.FLAVOR.equalsIgnoreCase("professorofIQ")) {
            Helper.gotoActivity(this, (Class<?>) ProfileActivity.class);
        } else {
            Helper.gotoActivity(this, (Class<?>) ProfileActivityTheme8.class);
        }
        if (this.drawer.isDrawerOpen(GravityCompat.START)) {
            this.drawer.closeDrawer(GravityCompat.START);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$12() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, (Class<?>) LiveClassActivity.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$13() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$14() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, CreateTestActivity.class, "1");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$17() {
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
            AsyncTask.execute(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda23
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setClicks$16(data);
                }
            });
        } else {
            Filterdata filterdata = this.filterdata;
            if (filterdata != null && filterdata.getData() != null && this.filterdata.getData().getLanguages() != null) {
                this.filterdata = new Filterdata();
                com.appnew.android.home.model.FilterData.Data data2 = new com.appnew.android.home.model.FilterData.Data();
                data2.setSubjects((List) new Gson().fromJson(this.utkashRoom.getMasterAllCatDao().getfilteddata(this.allsubcatindex_id), new TypeToken<List<Subject>>() { // from class: com.appnew.android.Theme.DashboardActivityTheme8.9
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
    public /* synthetic */ void lambda$setClicks$16(com.appnew.android.home.model.FilterData.Data data) {
        data.setSubjects((ArrayList) new Gson().fromJson(this.utkashRoom.getMasterAllCatDao().getfilteddata(this.allsubcatindex_id), new TypeToken<ArrayList<Subject>>() { // from class: com.appnew.android.Theme.DashboardActivityTheme8.8
        }.getType()));
        data.setLanguages(this.LanguagesTable);
        this.filterdata.setData(data);
        runOnUiThread(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setClicks$15();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setClicks$15() {
        openwatchlist_dailog_resource(this, this.filterdata.getData().getLanguages(), this.filterdata.getData().getSubjects());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$18() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.startCast(this);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$19() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, (Class<?>) Notification.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$20() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        openWhatsapp();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setClicks$21() {
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
    public /* synthetic */ Unit lambda$setClicks$22() {
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
    public /* synthetic */ void lambda$setClicks$23(View view) {
        Intent intent = new Intent(this, (Class<?>) CourseActivity.class);
        intent.putExtra(Const.FRAG_TYPE, Const.DIRECTLAYER3);
        intent.putExtra(Const.COURSE_ID_MAIN, "455");
        intent.putExtra(Const.COURSE_PARENT_ID, "");
        intent.putExtra(Const.SUB_CAT, this.allsubcatindex_id);
        intent.putExtra(Const.IS_COMBO, false);
        intent.putExtra(AnalyticsConstants.course_name, "Free Material");
        Helper.gotoActivity(intent, this);
    }

    public void callDialog() {
        if (SharedPreference.getInstance().getBoolean("showpopup")) {
            for (BannerListTable bannerListTable : this.bannerListTables) {
                if (bannerListTable.getBanner_location().equalsIgnoreCase("2")) {
                    dialog_latest_popup(bannerListTable);
                    return;
                }
            }
        }
    }

    public void dialog_latest_popup(final BannerListTable bannerListTable) {
        pushEventForInApp("notification_delivered", bannerListTable);
        final Dialog dialog = new Dialog(homeactivity);
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
            Glide.with((FragmentActivity) this).load(bannerListTable.getBanner_url()).into(roundedImageView);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        roundedImageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme8.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DashboardActivityTheme8.this.pushEventForInApp("notification_viewed", bannerListTable);
                dialog.dismiss();
                if (bannerListTable.getCourse_id() != null) {
                    if (!bannerListTable.getCourse_id().equals("0")) {
                        Intent intent = new Intent(DashboardActivityTheme8.homeactivitytheme8, (Class<?>) CourseActivity.class);
                        intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                        intent.putExtra(Const.COURSE_ID_MAIN, bannerListTable.getCourse_id());
                        intent.putExtra(Const.COURSE_PARENT_ID, "");
                        intent.putExtra(Const.IS_COMBO, false);
                        intent.putExtra(AnalyticsConstants.course_name, bannerListTable.getBanner_title() != null ? bannerListTable.getBanner_title() : "Course");
                        Helper.gotoActivity(intent, DashboardActivityTheme8.homeactivitytheme8);
                        return;
                    }
                    if (GenericUtils.isEmpty(bannerListTable.getLink())) {
                        return;
                    }
                    DashboardActivityTheme8.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(bannerListTable.getLink())));
                }
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$dialog_latest_popup$24(bannerListTable, dialog, view);
            }
        });
        layoutParams.gravity = 17;
        layoutParams.windowAnimations = R.style.videosheetDialogTheme;
        dialog.getWindow().setAttributes(layoutParams);
        dialog.show();
        SharedPreference.getInstance().putBoolean("showpopup", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dialog_latest_popup$24(BannerListTable bannerListTable, Dialog dialog, View view) {
        pushEventForInApp("notification_dismissed", bannerListTable);
        dialog.dismiss();
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
    }

    private void addFragment(ArrayList<CourseTypeMasterTable> coursesDataArrayList) {
        this.mFragmentList.add(ViewSliderChildFragment.newInstance(coursesDataArrayList, new IOnCourseClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda16
            @Override // com.appnew.android.home.interfaces.IOnCourseClickListener
            public final void onCourseItemClick(CourseTypeMasterTable courseTypeMasterTable, int i) {
                this.f$0.onCourseItemClick(courseTypeMasterTable, i);
            }
        }));
    }

    private void setHomeDrawer() {
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.menu);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, this.drawer, this.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        this.toggle = actionBarDrawerToggle;
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        this.drawer.setDrawerListener(this.toggle);
        this.toggle.syncState();
        this.drawer.addDrawerListener(new DrawerLayout.DrawerListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme8.11
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
                Helper.HideKeyboard(DashboardActivityTheme8.this);
            }
        });
        ActionBarDrawerToggle actionBarDrawerToggle2 = new ActionBarDrawerToggle(this, this.drawer, this.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) { // from class: com.appnew.android.Theme.DashboardActivityTheme8.12
            @Override // androidx.appcompat.app.ActionBarDrawerToggle, androidx.drawerlayout.widget.DrawerLayout.DrawerListener
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override // androidx.appcompat.app.ActionBarDrawerToggle, androidx.drawerlayout.widget.DrawerLayout.DrawerListener
            public void onDrawerOpened(View drawerView) {
                String string = SharedPreference.getInstance().getString(Const.SERVER_TIME);
                if (TextUtils.isEmpty(string) || string.equals("0")) {
                    if (SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE).equalsIgnoreCase("") || SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE).equals("0")) {
                        DashboardActivityTheme8.this.networkCall.NetworkAPICall(API.IS_COUPON_AVAILABLE, "", false, false);
                    } else if (Integer.parseInt(SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE)) > 0) {
                        DashboardActivityTheme8.this.createMenus();
                    }
                } else if (Long.parseLong(string) <= System.currentTimeMillis()) {
                    DashboardActivityTheme8.this.networkCall.NetworkAPICall(API.IS_COUPON_AVAILABLE, "", false, false);
                }
                Helper.HideKeyboard(DashboardActivityTheme8.this);
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
        if (!this.isFeedsClicked) {
            if (this.isDailyDoseClicked) {
                this.dailyDoseCover.setVisibility(0);
                if (this.dailyDoseFiltered.size() > 0) {
                    this.dailyDoseRV.setVisibility(0);
                } else {
                    this.noDataDailyDose.setVisibility(0);
                }
                this.courseLayoutCover.setVisibility(8);
                this.cvrNotificationRL.setVisibility(8);
                this.toggle.setDrawerIndicatorEnabled(false);
                this.homeBackIV.setVisibility(0);
                if (this.utkashRoom.getthemeSettingdao().is_setting_exit()) {
                    this.bottomSetting = (BottomSetting) new Gson().fromJson(this.utkashRoom.getthemeSettingdao().data().getBottom(), BottomSetting.class);
                    this.bottomLL.removeAllViews();
                    ArrayList<View> arrayList = this.viewArrayList;
                    if (arrayList != null) {
                        arrayList.clear();
                    }
                    for (int i = 0; i < Helper.getBottomMenu(this.bottomMenuTables).size(); i++) {
                        this.bottomLL.addView(initBottomView(Helper.getBottomMenu(this.bottomMenuTables).get(i), "20"));
                    }
                }
            } else {
                this.dailyDoseCover.setVisibility(8);
                this.dailyDoseRV.setVisibility(8);
                this.noDataDailyDose.setVisibility(8);
                this.courseLayoutCover.setVisibility(0);
                this.cvrNotificationRL.setVisibility(0);
                this.toggle.setDrawerIndicatorEnabled(true);
                this.homeBackIV.setVisibility(8);
                if (this.utkashRoom.getthemeSettingdao().is_setting_exit()) {
                    this.bottomSetting = (BottomSetting) new Gson().fromJson(this.utkashRoom.getthemeSettingdao().data().getBottom(), BottomSetting.class);
                    this.bottomLL.removeAllViews();
                    ArrayList<View> arrayList2 = this.viewArrayList;
                    if (arrayList2 != null) {
                        arrayList2.clear();
                    }
                    for (int i2 = 0; i2 < Helper.getBottomMenu(this.bottomMenuTables).size(); i2++) {
                        this.bottomLL.addView(initBottomView(Helper.getBottomMenu(this.bottomMenuTables).get(i2), "1"));
                    }
                }
            }
        }
        try {
            this.mAppUpdateManager.getAppUpdateInfo().addOnSuccessListener(new OnSuccessListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda18
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    this.f$0.lambda$onResume$25((AppUpdateInfo) obj);
                }
            });
            this.mAppUpdateManager.getAppUpdateInfo().addOnSuccessListener(new OnSuccessListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda19
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    this.f$0.lambda$onResume$26((AppUpdateInfo) obj);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        homeAutoRefresh();
        if (Constants.REFRESHPAGE.equals("true")) {
            Constants.REFRESHPAGE = "false";
            hit_api_for_data();
        }
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
    public /* synthetic */ void lambda$onResume$25(AppUpdateInfo appUpdateInfo) {
        if (appUpdateInfo.updateAvailability() == 3) {
            try {
                this.mAppUpdateManager.startUpdateFlowForResult(appUpdateInfo, this.inAppUpdateType, this, this.RC_APP_UPDATE);
            } catch (IntentSender.SendIntentException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$26(AppUpdateInfo appUpdateInfo) {
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

    private void popupSnackbarForCompleteUpdate() {
        try {
            Snackbar snackbarMake = Snackbar.make(this.liveclass, "An update has just been downloaded.", -2);
            snackbarMake.setAction("RESTART", new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$popupSnackbarForCompleteUpdate$27(view);
                }
            });
            snackbarMake.show();
        } catch (Resources.NotFoundException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$popupSnackbarForCompleteUpdate$27(View view) {
        this.mAppUpdateManager.completeUpdate();
    }

    private void checkAppUpdate() {
        try {
            this.appUpdateInfoTask.addOnSuccessListener(new OnSuccessListener<AppUpdateInfo>() { // from class: com.appnew.android.Theme.DashboardActivityTheme8.13
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public void onSuccess(AppUpdateInfo appUpdateInfo) {
                    if (appUpdateInfo.updateAvailability() == 2 && appUpdateInfo.isUpdateTypeAllowed(DashboardActivityTheme8.this.inAppUpdateType)) {
                        try {
                            AppUpdateManager appUpdateManager = DashboardActivityTheme8.this.mAppUpdateManager;
                            int i = DashboardActivityTheme8.this.inAppUpdateType;
                            DashboardActivityTheme8 dashboardActivityTheme8 = DashboardActivityTheme8.this;
                            appUpdateManager.startUpdateFlowForResult(appUpdateInfo, i, dashboardActivityTheme8, dashboardActivityTheme8.RC_APP_UPDATE);
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
            leftNavAdapter.setLeftNavAdapterListener(new LeftNavAdapter.LeftNavAdapterListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme8.14
                @Override // com.appnew.android.home.adapters.LeftNavAdapter.LeftNavAdapterListener
                public void onItemClick(Menu menu) {
                    if (menu.getHaveChild().equalsIgnoreCase("1")) {
                        menu.setExpanded(!menu.isExpanded());
                    }
                    DashboardActivityTheme8.this.handleLeftMenuClick(menu);
                    leftNavAdapter.notifyDataSetChanged();
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        socialIconsVisibility(this.leftMenu);
    }

    private void socialIconsVisibility(final LeftMenu leftMenu) {
        if (leftMenu != null) {
            if (Helper.isNullChek(leftMenu.getTelegram_link_data()) && leftMenu.getTelegram_link().equalsIgnoreCase("1")) {
                this.iconTelegram.setVisibility(0);
                this.iconTelegram.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda29
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$28(leftMenu);
                    }
                }));
            }
            if (Helper.isNullChek(leftMenu.getInstagram_link_data()) && leftMenu.getInstagram_link().equalsIgnoreCase("1")) {
                this.iconInstagram.setVisibility(0);
                this.iconInstagram.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda30
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$29(leftMenu);
                    }
                }));
            }
            if (Helper.isNullChek(leftMenu.getLinkedin_link_data()) && leftMenu.getLinkedin_link().equalsIgnoreCase("1")) {
                this.iconLinkedIn.setVisibility(0);
                this.iconLinkedIn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda31
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$30(leftMenu);
                    }
                }));
            }
            if (Helper.isNullChek(leftMenu.getYoutube_link_data()) && leftMenu.getYoutube_link().equalsIgnoreCase("1")) {
                this.iconYoutube.setVisibility(0);
                this.iconYoutube.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda32
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$31(leftMenu);
                    }
                }));
            }
            if (Helper.isNullChek(leftMenu.getFacebook_link_data()) && leftMenu.getFacebook_link().equalsIgnoreCase("1")) {
                this.iconFacebook.setVisibility(0);
                this.iconFacebook.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda34
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$32(leftMenu);
                    }
                }));
            }
            if (Helper.isNullChek(leftMenu.getTwitter_link_data()) && leftMenu.getTwitter_link().equalsIgnoreCase("1")) {
                this.iconTwitter.setVisibility(0);
                this.iconTwitter.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda35
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$33(leftMenu);
                    }
                }));
            }
            if (Helper.isNullChek(leftMenu.getWebsite_url()) && leftMenu.getWebsite().equalsIgnoreCase("1")) {
                this.iconWebsite.setVisibility(0);
                this.iconWebsite.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda36
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$34(leftMenu);
                    }
                }));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$28(LeftMenu leftMenu) {
        this.drawer.closeDrawer(GravityCompat.START);
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getTelegram_link_data())));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$29(LeftMenu leftMenu) {
        this.drawer.closeDrawer(GravityCompat.START);
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getInstagram_link_data())));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$30(LeftMenu leftMenu) {
        this.drawer.closeDrawer(GravityCompat.START);
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getLinkedin_link_data())));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$31(LeftMenu leftMenu) {
        this.drawer.closeDrawer(GravityCompat.START);
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getYoutube_link_data())));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$32(LeftMenu leftMenu) {
        this.drawer.closeDrawer(GravityCompat.START);
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getFacebook_link_data())));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$33(LeftMenu leftMenu) {
        this.drawer.closeDrawer(GravityCompat.START);
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getTwitter_link_data())));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$34(LeftMenu leftMenu) {
        this.drawer.closeDrawer(GravityCompat.START);
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getWebsite_url())));
            return null;
        } catch (Exception unused) {
            Helper.showToast(this, "Invalid Url", 0);
            return null;
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
                case 1731:
                    if (type_code.equals(Constants.LEFT_NAV_KEY.change_preference)) {
                        b2 = Ascii.ETB;
                    }
                    break;
                case 1822:
                    if (type_code.equals(Constants.LEFT_NAV_KEY.contact_us_query)) {
                        b2 = Ascii.CAN;
                    }
                    break;
                case 1823:
                    if (type_code.equals(Constants.LEFT_NAV_KEY.book_store)) {
                        b2 = Ascii.EM;
                    }
                    break;
                case NewHope.SENDA_BYTES /* 1824 */:
                    if (type_code.equals(Constants.LEFT_NAV_KEY.custom_payment)) {
                        b2 = Ascii.SUB;
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
                    Intent intent2 = new Intent(this, (Class<?>) WebViewActivty.class);
                    intent2.putExtra("type", "Terms of Service");
                    intent2.putExtra("url", API.TERMS_AND_CONDITIONS);
                    Helper.gotoActivity(intent2, this);
                    break;
                case 10:
                    try {
                        Intent intent3 = new Intent("android.intent.action.VIEW");
                        intent3.setData(Uri.parse("https://g.co/kgs/JP1mgY"));
                        startActivity(intent3);
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
                        Intent intent4 = new Intent(this, (Class<?>) WebViewActivty.class);
                        intent4.putExtra("type", "OFFLINE BATCH");
                        intent4.putExtra("url", "https://courses.utkarsh.com/offlineadmission/home.php");
                        startActivity(intent4);
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
                    Intent intent5 = new Intent(this, (Class<?>) WebViewActivty.class);
                    intent5.putExtra("type", Const.PRIVACY);
                    intent5.putExtra("url", API.PRIVACY_POLICY_URL);
                    Helper.gotoActivity(intent5, this);
                    break;
                case 21:
                    Intent intent6 = new Intent(this, (Class<?>) CurrentAffairActivity.class);
                    intent6.putExtra("title_key", "Current Affair");
                    startActivity(intent6);
                    if (this.drawer.isDrawerOpen(GravityCompat.START)) {
                        this.drawer.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 22:
                    Intent intent7 = new Intent(this, (Class<?>) BookMarkList.class);
                    intent7.putExtra("title_key", "Bookmark");
                    startActivity(intent7);
                    if (this.drawer.isDrawerOpen(GravityCompat.START)) {
                        this.drawer.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 23:
                    startActivity(new Intent(this, (Class<?>) CategoryActivity.class));
                    if (this.drawer.isDrawerOpen(GravityCompat.START)) {
                        this.drawer.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 24:
                    Intent intent8 = new Intent(this, (Class<?>) ContactUsPage.class);
                    intent8.putExtra("from", Constants.LEFT_NAV_KEY.contact_us_query);
                    startActivity(intent8);
                    if (this.drawer.isDrawerOpen(GravityCompat.START)) {
                        this.drawer.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 25:
                    if (this.drawer.isDrawerOpen(GravityCompat.START)) {
                        this.drawer.closeDrawer(GravityCompat.START);
                    }
                    if (this.leftMenu.getBook_store_link() != null && !this.leftMenu.getBook_store_link().equalsIgnoreCase("")) {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.leftMenu.getBook_store_link())));
                        break;
                    }
                    break;
                case 26:
                    Intent intent9 = new Intent(this, (Class<?>) CustomPaymentActivity.class);
                    intent9.putExtra("type", "Custom Payment");
                    intent9.putExtra("courseid", this.leftMenu.getCustom_course());
                    Helper.gotoActivity(intent9, this);
                    break;
            }
        }
    }

    private void hit_api_for_filter() {
        this.networkCall.NetworkAPICall(API.get_filter_data, "", true, false);
    }

    public void getLogoutDialog(final Activity ctx, final String title, final String message) {
        DialogUtils.makeDialog(this, title, message, getResources().getString(R.string.yes), getResources().getString(R.string.no), true, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Theme.DashboardActivityTheme8.15
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
            public void onOKClick() {
                if (Helper.isConnected(DashboardActivityTheme8.this)) {
                    DashboardActivityTheme8.this.UserLogout();
                } else {
                    Toast.makeText(DashboardActivityTheme8.this, "No Internet connection", 0).show();
                }
            }
        }, new DialogUtils.onDialogUtilsCancelClick() { // from class: com.appnew.android.Theme.DashboardActivityTheme8.16
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
    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonObject, String apitype, String typeApi, boolean showprogress) throws JSONException {
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArrayOptJSONArray2;
        JSONArray jSONArrayOptJSONArray3;
        JSONArray jSONArrayOptJSONArray4;
        JSONArray jSONArrayOptJSONArray5;
        apitype.hashCode();
        byte b2 = -1;
        switch (apitype.hashCode()) {
            case -1874107053:
                if (apitype.equals(API.master_content)) {
                    b2 = 0;
                }
                break;
            case -1563283144:
                if (apitype.equals(API.API_GET_TEST_INSTRUCTION_DATA)) {
                    b2 = 1;
                }
                break;
            case -575387742:
                if (apitype.equals(API.mark_as_read)) {
                    b2 = 2;
                }
                break;
            case -405213177:
                if (apitype.equals(API.GET_MY_QUIRES)) {
                    b2 = 3;
                }
                break;
            case -403097279:
                if (apitype.equals(API.get_filter_data)) {
                    b2 = 4;
                }
                break;
            case -171058627:
                if (apitype.equals(API.API_GET_MASTER_DATA)) {
                    b2 = 5;
                }
                break;
            case 17608548:
                if (apitype.equals(API.user_logout)) {
                    b2 = 6;
                }
                break;
            case 44364183:
                if (apitype.equals(API.IS_COUPON_AVAILABLE)) {
                    b2 = 7;
                }
                break;
            case 739951748:
                if (apitype.equals(API.API_GET_INFO_TEST_SERIES)) {
                    b2 = 8;
                }
                break;
        }
        switch (b2) {
            case 0:
                try {
                    this.hitMaster = true;
                    if (jsonObject.optString("status").equals("true")) {
                        JSONObject jSONObject = jsonObject.getJSONObject("data");
                        try {
                            this.utkashRoom.getcoursetypemaster().deletedata();
                            this.utkashRoom.getLaunguages().deletedata();
                            this.utkashRoom.getMasterAllCatDao().deletedata();
                            this.utkashRoom.getMastercatDao().deletedata();
                            this.utkashRoom.getBannerTableDao().deleteBanners();
                            this.utkashRoom.getBottomMenuTableDao().deleteBottomMenu();
                            this.utkashRoom.getthemeSettingdao().deletedata();
                            this.utkashRoom.getTopperReviewDao().deleteTopperReview();
                            this.courseTypeMasterTables.clear();
                            this.masterAllCatTables.clear();
                            this.mastercatlist.clear();
                            this.selectedsub_all_cat.clear();
                            this.selected_master_cat.clear();
                            this.bannerListTables.clear();
                            this.bottomMenuTables.clear();
                            if (jSONObject.has("settings")) {
                                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("settings");
                                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("bottom");
                                ThemeSettings themeSettings = new ThemeSettings();
                                themeSettings.setTheme(jSONObjectOptJSONObject.optString(Const.THEME));
                                themeSettings.setBottom(jSONObjectOptJSONObject2.toString());
                                if (jSONObjectOptJSONObject.optJSONObject("left_menu") != null) {
                                    themeSettings.setLeft_menu(jSONObjectOptJSONObject.optJSONObject("left_menu").toString());
                                    SharedPreference.getInstance().putString(Const.CONTACTUS_MOBILE1, jSONObjectOptJSONObject.optJSONObject("left_menu").optString(Const.CONTACTUS_MOBILE1));
                                    SharedPreference.getInstance().putString(Const.CONTACTUS_MOBILE2, jSONObjectOptJSONObject.optJSONObject("left_menu").optString("contactus_mobile2"));
                                    SharedPreference.getInstance().putString("contactus_email", jSONObjectOptJSONObject.optJSONObject("left_menu").optString("contactus_email"));
                                    SharedPreference.getInstance().putString(Const.IS_CART, jSONObjectOptJSONObject.optJSONObject("left_menu").optString(Const.IS_CART));
                                    SharedPreference.getInstance().putString(Const.RESUME_TEST, jSONObjectOptJSONObject.optJSONObject("left_menu").optString(Const.RESUME_TEST));
                                    SharedPreference.getInstance().putString(Const.PRACTICE_TEST, jSONObjectOptJSONObject.optJSONObject("left_menu").optString(Const.PRACTICE_TEST));
                                    SharedPreference.getInstance().putString(Const.IS_RATING, jSONObjectOptJSONObject.optJSONObject("left_menu").optString(Const.IS_RATING));
                                    SharedPreference.getInstance().putString(Const.BOOK_MARK, jSONObjectOptJSONObject.optJSONObject("left_menu").optString(Const.BOOK_MARK));
                                    SharedPreference.getInstance().putString(Const.IS_EXOPLAYER, jSONObjectOptJSONObject.optJSONObject("left_menu").optString("exoPlayer"));
                                    SharedPreference.getInstance().putString(Const.DOUBT_TOPIC, jSONObjectOptJSONObject.optJSONObject("left_menu").optString(Const.DOUBT_TOPIC));
                                    SharedPreference.getInstance().putString(Const.DOUBT_ISBN_BASED, jSONObjectOptJSONObject.optJSONObject("left_menu").optString("doubt_isbn_error_report"));
                                    if (jSONObjectOptJSONObject.optJSONObject("left_menu").has("zoom_detail")) {
                                        SharedPreference.getInstance().putString(Const.ZOOM_ACCESS_KEY, jSONObjectOptJSONObject.optJSONObject("left_menu").optJSONObject("zoom_detail").optString(Const.ZOOM_ACCESS_KEY));
                                        SharedPreference.getInstance().putString(Const.ZOOM_SECRET_KEY, jSONObjectOptJSONObject.optJSONObject("left_menu").optJSONObject("zoom_detail").optString(Const.ZOOM_SECRET_KEY));
                                    }
                                    SharedPreference.getInstance().putString(Const.SHARE_CONTENT, jSONObjectOptJSONObject.optJSONObject("left_menu").optString(Const.SHARE_CONTENT));
                                    SharedPreference.getInstance().putString(Const.AUDIO_LISTEN, jSONObjectOptJSONObject.optJSONObject("left_menu").optString(Const.AUDIO_LISTEN));
                                    SharedPreference.getInstance().putString(Const.MY_DOWNLOAD_TABS, jSONObjectOptJSONObject.optJSONObject("left_menu").optString("my_downloads_tab"));
                                    SharedPreference.getInstance().putString(Const.IN_APP_DOWNLOADS, jSONObjectOptJSONObject.optJSONObject("left_menu").optString(Const.IN_APP_DOWNLOADS));
                                    SharedPreference.getInstance().putString(Const.USER_COUPON_TO_APPLY, jSONObjectOptJSONObject.optJSONObject("left_menu").optString("user_coupon"));
                                }
                                this.utkashRoom.getthemeSettingdao().addUser(themeSettings);
                                createMenus();
                            }
                            if (jSONObject.has("languages") && (jSONArrayOptJSONArray5 = jSONObject.optJSONArray("languages")) != null && jSONArrayOptJSONArray5.length() > 0) {
                                for (int i = 0; i < jSONArrayOptJSONArray5.length(); i++) {
                                    LanguagesTable languagesTable = (LanguagesTable) new Gson().fromJson(jSONArrayOptJSONArray5.get(i).toString(), LanguagesTable.class);
                                    this.LanguagesTable.add(languagesTable);
                                    this.utkashRoom.getLaunguages().addLaunguage(languagesTable);
                                }
                            }
                            if (jSONObject.has("all_cat") && (jSONArrayOptJSONArray4 = jSONObject.optJSONArray("all_cat")) != null && jSONArrayOptJSONArray4.length() > 0) {
                                for (int i2 = 0; i2 < jSONArrayOptJSONArray4.length(); i2++) {
                                    MasteAllCatTable masteAllCatTable = (MasteAllCatTable) new Gson().fromJson(jSONArrayOptJSONArray4.get(i2).toString(), MasteAllCatTable.class);
                                    masteAllCatTable.setUser_id(MakeMyExam.userId);
                                    this.utkashRoom.getMasterAllCatDao().addUser(masteAllCatTable);
                                    this.masterAllCatTables.add(masteAllCatTable);
                                }
                            }
                            if (jSONObject.has("master_cat") && (jSONArrayOptJSONArray3 = jSONObject.optJSONArray("master_cat")) != null && jSONArrayOptJSONArray3.length() > 0) {
                                for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                                    MasterCat masterCat = (MasterCat) new Gson().fromJson(jSONArrayOptJSONArray3.get(i3).toString(), MasterCat.class);
                                    masterCat.setUser_id(MakeMyExam.userId);
                                    this.utkashRoom.getMastercatDao().addUser(masterCat);
                                    this.mastercatlist.add(masterCat);
                                }
                            }
                            if (jSONObject.has("course_type_master") && (jSONArrayOptJSONArray2 = jSONObject.optJSONArray("course_type_master")) != null && jSONArrayOptJSONArray2.length() > 0) {
                                for (int i4 = 0; i4 < jSONArrayOptJSONArray2.length(); i4++) {
                                    CourseTypeMasterTable courseTypeMasterTable = (CourseTypeMasterTable) new Gson().fromJson(jSONArrayOptJSONArray2.get(i4).toString(), CourseTypeMasterTable.class);
                                    courseTypeMasterTable.setUser_id(MakeMyExam.userId);
                                    this.utkashRoom.getcoursetypemaster().addUser(courseTypeMasterTable);
                                    this.courseTypeMasterTables.add(courseTypeMasterTable);
                                }
                            }
                            if (jSONObject.has("bottom_bar") && (jSONArrayOptJSONArray = jSONObject.optJSONArray("bottom_bar")) != null && jSONArrayOptJSONArray.length() > 0) {
                                for (int i5 = 0; i5 < jSONArrayOptJSONArray.length(); i5++) {
                                    BottomMenuTable bottomMenuTable = (BottomMenuTable) new Gson().fromJson(jSONArrayOptJSONArray.get(i5).toString(), BottomMenuTable.class);
                                    bottomMenuTable.setUser_id(MakeMyExam.userId);
                                    this.utkashRoom.getBottomMenuTableDao().addBottomMenu(bottomMenuTable);
                                    this.bottomMenuTables.add(bottomMenuTable);
                                }
                            }
                            if (jSONObject.has("banner_list")) {
                                JSONArray jSONArrayOptJSONArray6 = jSONObject.optJSONArray("banner_list");
                                if (jSONArrayOptJSONArray6 != null && jSONArrayOptJSONArray6.length() > 0) {
                                    for (int i6 = 0; i6 < jSONArrayOptJSONArray6.length(); i6++) {
                                        BannerListTable bannerListTable = (BannerListTable) new Gson().fromJson(jSONArrayOptJSONArray6.get(i6).toString(), BannerListTable.class);
                                        bannerListTable.setUser_id(MakeMyExam.userId);
                                        this.utkashRoom.getBannerTableDao().addBanner(bannerListTable);
                                        this.bannerListTables.add(bannerListTable);
                                    }
                                }
                                automateViewPagerSwiping();
                            }
                            if (jSONObject.has("notification")) {
                                SharedPreference.getInstance().putInt(Const.NOTIFICATION_COUNT, Integer.parseInt(jSONObject.getJSONObject("notification").getString("count")));
                                homeAutoRefresh();
                            }
                            try {
                                if (this.utkashRoom.getapidao().is_api_code_exits(MakeMyExam.userId, "ut_009")) {
                                    this.utkashRoom.getapidao().update_api_version("ut_009", MakeMyExam.userId, String.valueOf(jsonObject.optLong("time")), String.valueOf(jsonObject.optLong("interval")), String.valueOf(jsonObject.optLong("cd_time")));
                                } else {
                                    APITABLE apitable = new APITABLE();
                                    apitable.setApicode("ut_009");
                                    apitable.setApiname("master_content");
                                    apitable.setInterval(String.valueOf(jsonObject.optLong("interval")));
                                    apitable.setUser_id(MakeMyExam.userId);
                                    apitable.setTimestamp(String.valueOf(jsonObject.optLong("time")));
                                    apitable.setCdtimestamp(String.valueOf(jsonObject.optLong("cd_time")));
                                    apitable.setVersion("0.000");
                                    this.utkashRoom.getapidao().addUser(apitable);
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            selecteddata();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            return;
                        }
                    } else {
                        RetrofitResponse.GetApiData(this, jsonObject.has("auth_code") ? jsonObject.getString("auth_code") : "", jsonObject.getString("message"), false);
                    }
                } catch (Exception e4) {
                    this.hitMaster = true;
                    ErrorCallBack(e4.getMessage() + " : " + e4.getLocalizedMessage(), apitype, typeApi);
                    e4.printStackTrace();
                    return;
                }
                break;
            case 1:
                if (jsonObject.optString("status").equals("true")) {
                    showPopUp((InstructionData) new Gson().fromJson(jsonObject.getJSONObject("data").toString(), InstructionData.class));
                } else if (jsonObject.optString("status").equals("false")) {
                    if (jsonObject.optString("auth_code") != null) {
                        if (!jsonObject.optString("auth_code").equalsIgnoreCase(Const.EXPIRY_AUTH_CODE)) {
                            initialzehomepage();
                        }
                    }
                    RetrofitResponse.GetApiData(this, jsonObject.has("auth_code") ? jsonObject.getString("auth_code") : "", jsonObject.getString("message"), false);
                }
                break;
            case 2:
                try {
                    jsonObject.getString("status").equalsIgnoreCase("true");
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return;
                }
                break;
            case 3:
                if (jsonObject.optString("status").equals("true")) {
                    if (((ArrayList) new Gson().fromJson(jsonObject.getJSONArray("data").toString(), new TypeToken<ArrayList<HelpSupportChatModel.DataBean>>() { // from class: com.appnew.android.Theme.DashboardActivityTheme8.17
                    }.getType())).size() > 0) {
                        Intent intent = new Intent(this, (Class<?>) HelpQueryActivity.class);
                        intent.putExtra("isCourse", false);
                        intent.putExtra("courseDetail", new CourseDetail());
                        startActivity(intent);
                    } else {
                        Intent intent2 = new Intent(this, (Class<?>) HelpSupportActivity.class);
                        intent2.putExtra("isCourse", false);
                        intent2.putExtra("courseDetail", new CourseDetail());
                        startActivity(intent2);
                    }
                } else {
                    Intent intent3 = new Intent(this, (Class<?>) HelpSupportActivity.class);
                    intent3.putExtra("isCourse", false);
                    intent3.putExtra("courseDetail", new CourseDetail());
                    startActivity(intent3);
                }
                break;
            case 4:
                try {
                    if (jsonObject.optString("status").equals("true")) {
                        Filterdata filterdata = (Filterdata) new Gson().fromJson(jsonObject.toString(), Filterdata.class);
                        this.filterdata = filterdata;
                        if (filterdata.getData().getLanguages() != null && this.filterdata.getData().getSubjects() != null && this.isfilterchanged) {
                            openwatchlist_dailog_resource(this, this.filterdata.getData().getLanguages(), this.filterdata.getData().getSubjects());
                            break;
                        }
                    } else {
                        RetrofitResponse.GetApiData(this, jsonObject.has("auth_code") ? jsonObject.getString("auth_code") : "", jsonObject.getString("message"), false);
                        break;
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return;
                }
                break;
            case 5:
                try {
                    if (jsonObject.optString("status").equals("true")) {
                        Gson gson = new Gson();
                        JSONObject jSONObject2 = jsonObject.getJSONObject("data");
                        ArrayList<Video> arrayList = new ArrayList<>();
                        for (int i7 = 0; i7 < jSONObject2.optJSONArray("list").length(); i7++) {
                            arrayList.add((Video) gson.fromJson(jSONObject2.optJSONArray("list").get(i7).toString(), Video.class));
                        }
                        if (arrayList.size() != 0) {
                            if (this.notification_code == 125) {
                                inittest(arrayList);
                            } else if (this.tiletype.equalsIgnoreCase(Const.TEST)) {
                                inittest(arrayList);
                            } else {
                                if (!this.tiletype.equalsIgnoreCase(Const.SUBJECTIVE_TEST) && !this.tiletype.equalsIgnoreCase(Const.Daily_assignment)) {
                                    if (this.tiletype.equalsIgnoreCase("image")) {
                                        Intent intent4 = new Intent(this, (Class<?>) NotificationDescription.class);
                                        intent4.putExtra("urlType", "IMAGE");
                                        intent4.putExtra("title", arrayList.get(0).getTitle());
                                        intent4.putExtra("url", arrayList.get(0).getFile_url());
                                        intent4.putExtra("description", arrayList.get(0).getDescription());
                                        Helper.gotoActivity(intent4, this);
                                    } else if (this.is_seminar.booleanValue()) {
                                        playseminarvideo(arrayList.get(0));
                                    } else {
                                        initLivevideo(arrayList.get(0));
                                    }
                                }
                                showsubjectivepopup(arrayList);
                            }
                        }
                    } else {
                        if (jsonObject.optString("auth_code") != null) {
                            if (!jsonObject.optString("auth_code").equalsIgnoreCase(Const.EXPIRY_AUTH_CODE)) {
                                initialzehomepage();
                            }
                        }
                        RetrofitResponse.GetApiData(this, jsonObject.optString("auth_code"), jsonObject.optString("message"), false);
                    }
                } catch (JSONException e7) {
                    if (jsonObject.optString("auth_code") != null) {
                        if (jsonObject.optString("auth_code").equalsIgnoreCase(Const.EXPIRY_AUTH_CODE)) {
                            return;
                        } else {
                            initialzehomepage();
                        }
                    }
                    e7.printStackTrace();
                    return;
                }
                break;
            case 6:
                if (jsonObject.optString("status").equals("true")) {
                    Helper.SignOutUser(this);
                }
                break;
            case 7:
                if (jsonObject.optString("status").equals("true")) {
                    String strOptString = ((JSONObject) Objects.requireNonNull(jsonObject.optJSONObject("data"))).optString(Const.TOTAL_ASSIGNED_COUPON);
                    if (strOptString.equalsIgnoreCase("") || Integer.parseInt(strOptString) == 0) {
                        SharedPreference.getInstance().putString(Const.SERVER_TIME, "" + ((Long.parseLong(jsonObject.optString("time")) + 120) * 1000));
                    } else {
                        SharedPreference.getInstance().putString(Const.SERVER_TIME, "");
                        SharedPreference.getInstance().putString(Const.IS_COUPON_AVAILABLE, strOptString);
                    }
                }
                break;
            case 8:
                if (jsonObject.optString("status").equals("true")) {
                    Long lValueOf = Long.valueOf(jsonObject.optLong("time"));
                    try {
                        TestseriesBase testseriesBase = (TestseriesBase) new Gson().fromJson(jsonObject.toString(), TestseriesBase.class);
                        String[] strArr = this.langIds;
                        if (strArr != null && strArr.length > 0) {
                            if (strArr.length == 1 && strArr[0].equalsIgnoreCase("1") && (testseriesBase.getData().getQuestions() == null || testseriesBase.getData().getQuestions().isEmpty())) {
                                Toast.makeText(this, "All questions may not be available in English languages. For assistance, please contact our support team.", 0).show();
                            } else {
                                String[] strArr2 = this.langIds;
                                if (strArr2.length == 1 && strArr2[0].equalsIgnoreCase("2") && (testseriesBase.getData().getQuestionsHindi() == null || testseriesBase.getData().getQuestionsHindi().isEmpty())) {
                                    Toast.makeText(this, "All questions may not be available in Hindi languages. For assistance, please contact our support team.", 0).show();
                                } else if (this.langIds.length > 1 && (testseriesBase.getData().getQuestions() == null || testseriesBase.getData().getQuestions().isEmpty() || testseriesBase.getData().getQuestionsHindi() == null || testseriesBase.getData().getQuestionsHindi().isEmpty())) {
                                    Toast.makeText(this, "All questions may not be available in both languages. For assistance, please contact our support team.", 0).show();
                                } else {
                                    if (testseriesBase.getData().getQuestions() != null && testseriesBase.getData().getQuestions().size() > 0 && this.lang == 1) {
                                        Intent intent5 = new Intent(this, (Class<?>) TestBaseActivity.class);
                                        intent5.putExtra("status", false);
                                        intent5.putExtra(Const.TEST_SERIES_ID, this.quiz_id);
                                        intent5.putExtra(Const.TEST_SERIES_Name, this.testname);
                                        SharedPreference.getInstance().putString("test_series", jsonObject.toString());
                                        intent5.putExtra("course_id", this.course_id);
                                        intent5.putExtra(Const.TOTAL_QUESTIONS, this.testquestion);
                                        intent5.putExtra("first_attempt", this.first_attempt);
                                        intent5.putExtra("result_date", this.result_date);
                                        intent5.putExtra("test_submission", this.submition_type);
                                        intent5.putExtra("time", lValueOf);
                                        intent5.putExtra("enddate", this.videodata.getEnd_date());
                                        intent5.putExtra(Const.LANG, this.lang);
                                        Helper.gotoActivity(intent5, this);
                                    } else if (testseriesBase.getData().getQuestionsHindi() != null && testseriesBase.getData().getQuestionsHindi().size() > 0 && this.lang == 2) {
                                        testseriesBase.getData().setQuestions(testseriesBase.getData().getQuestionsHindi());
                                        Intent intent6 = new Intent(this, (Class<?>) TestBaseActivity.class);
                                        intent6.putExtra("status", false);
                                        intent6.putExtra(Const.TEST_SERIES_ID, this.quiz_id);
                                        intent6.putExtra(Const.TEST_SERIES_Name, this.testname);
                                        SharedPreference.getInstance().putString("test_series", jsonObject.toString());
                                        intent6.putExtra("course_id", this.course_id);
                                        intent6.putExtra(Const.TOTAL_QUESTIONS, this.testquestion);
                                        intent6.putExtra("first_attempt", this.first_attempt);
                                        intent6.putExtra("result_date", this.result_date);
                                        intent6.putExtra("test_submission", this.submition_type);
                                        intent6.putExtra(Const.LANG, this.lang);
                                        intent6.putExtra("time", lValueOf);
                                        intent6.putExtra("enddate", this.videodata.getEnd_date());
                                        Helper.gotoActivity(intent6, this);
                                    } else {
                                        initialzehomepage();
                                        Toast.makeText(this, "No Question Found", 0).show();
                                    }
                                    pushEvent();
                                }
                            }
                        } else {
                            Toast.makeText(this, "Language not found!", 0).show();
                        }
                    } catch (Exception unused) {
                        initialzehomepage();
                        Toast.makeText(this, "Something went wrong.", 0).show();
                        return;
                    }
                } else {
                    if (jsonObject.optString("auth_code") != null) {
                        if (!jsonObject.optString("auth_code").equalsIgnoreCase(Const.EXPIRY_AUTH_CODE)) {
                            initialzehomepage();
                        }
                    }
                    RetrofitResponse.GetApiData(this, jsonObject.has("auth_code") ? jsonObject.getString("auth_code") : "", jsonObject.getString("message"), false);
                }
                break;
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
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme8.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DashboardActivityTheme8.this.showPopMenuForLangauge(textView5, testBasic);
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
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme8.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (testBasic.getTotalQuestions().equalsIgnoreCase("0")) {
                    Toast.makeText(DashboardActivityTheme8.this, "Please add Question.", 0).show();
                    return;
                }
                if (checkBox3.isChecked()) {
                    dialog3.dismiss();
                    DashboardActivityTheme8.this.quiz_id = testBasic.getId();
                    DashboardActivityTheme8 dashboardActivityTheme8 = DashboardActivityTheme8.this;
                    new NetworkCall(dashboardActivityTheme8, dashboardActivityTheme8).NetworkAPICall(API.API_GET_INFO_TEST_SERIES, "", true, false);
                    return;
                }
                Toast.makeText(DashboardActivityTheme8.this, "Please check following instructions.", 0).show();
            }
        });
        dialog3.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme8.20
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialog4, int keyCode, KeyEvent event) {
                if (keyCode != 4) {
                    return true;
                }
                DashboardActivityTheme8.this.initialzehomepage();
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
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme8.21
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem item) {
                ((TextView) v).setText(item.getTitle().toString());
                if (item.getTitle().toString().equals(DashboardActivityTheme8.this.getResources().getString(R.string.hindi))) {
                    DashboardActivityTheme8.this.lang = 2;
                    return false;
                }
                if (!item.getTitle().toString().equals(DashboardActivityTheme8.this.getResources().getString(R.string.english))) {
                    return false;
                }
                DashboardActivityTheme8.this.lang = 1;
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

    private void playseminarvideo(Video video) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        DashboardActivityTheme8 dashboardActivityTheme8 = this;
        if (dashboardActivityTheme8.notification_code == 90002) {
            int i = 0;
            dashboardActivityTheme8.is_seminar = false;
            if (video.getVideo_type().equalsIgnoreCase("7")) {
                if (video.getIs_drm().equals("0")) {
                    if (video.getId() == null || video.getId().equalsIgnoreCase("")) {
                        Toast.makeText(dashboardActivityTheme8, "Url is not found", 0).show();
                        dashboardActivityTheme8.initialzehomepage();
                        str11 = "3";
                        str8 = "2";
                        str9 = "dd MMM yyyy hh:mm a";
                        str10 = "Live Class will start on ";
                        str7 = "0";
                        str12 = "1";
                    } else {
                        Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), dashboardActivityTheme8, video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "", SingleStudy.parentCourseId, video.getStart_date(), new ArrayList());
                        str11 = "3";
                        str8 = "2";
                        str9 = "dd MMM yyyy hh:mm a";
                        str10 = "Live Class will start on ";
                        str7 = "0";
                        str12 = "1";
                        i = 0;
                    }
                } else {
                    str = "3";
                    str2 = "2";
                    str3 = "dd MMM yyyy hh:mm a";
                    str4 = "Live Class will start on ";
                    str5 = "0";
                    if (!video.getIs_drm().equals("1")) {
                        str12 = "1";
                        str11 = str;
                        str8 = str2;
                        str9 = str3;
                        str10 = str4;
                        str7 = str5;
                    } else if (video.getId() == null || video.getId().equalsIgnoreCase("")) {
                        str6 = "1";
                        Toast.makeText(dashboardActivityTheme8, "Url is not found", 0).show();
                        dashboardActivityTheme8.initialzehomepage();
                        str11 = str;
                        str8 = str2;
                        str9 = str3;
                        str10 = str4;
                        str7 = str5;
                        str12 = str6;
                    } else {
                        Helper.GoToVideoCryptActivity(this, video.getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), video.getVideo_type(), video.getChat_node(), video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "", SingleStudy.parentCourseId, video.getStart_date(), video.getIs_bookmarked(), new ArrayList());
                        dashboardActivityTheme8 = this;
                        str11 = str;
                        str8 = str2;
                        str9 = str3;
                        str10 = str4;
                        str7 = str5;
                        str12 = "1";
                        i = 0;
                    }
                }
            } else {
                str = "3";
                str2 = "2";
                str3 = "dd MMM yyyy hh:mm a";
                str4 = "Live Class will start on ";
                str5 = "0";
                str6 = "1";
                if (video.getVideo_type().equalsIgnoreCase("8")) {
                    str7 = str5;
                    if (video.getIs_drm().equals(str7)) {
                        if (video.getLive_status().equalsIgnoreCase(str6)) {
                            if (video.getId() == null || video.getId().equalsIgnoreCase("")) {
                                str13 = str6;
                                Toast.makeText(dashboardActivityTheme8, "Url is not found", 0).show();
                                dashboardActivityTheme8.initialzehomepage();
                                str11 = str;
                                str8 = str2;
                                str9 = str3;
                                str10 = str4;
                                str7 = str7;
                            } else {
                                Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), dashboardActivityTheme8, video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "", SingleStudy.parentCourseId, video.getStart_date(), new ArrayList());
                                str11 = str;
                                str8 = str2;
                                str9 = str3;
                                str10 = str4;
                                str7 = str7;
                                str12 = str6;
                                i = 0;
                            }
                        } else {
                            str13 = str6;
                            if (video.getLive_status().equalsIgnoreCase(str7)) {
                                str10 = str4;
                                str9 = str3;
                                Toast.makeText(dashboardActivityTheme8, str10 + new SimpleDateFormat(str9).format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                                dashboardActivityTheme8.initialzehomepage();
                                str11 = str;
                                str8 = str2;
                            } else {
                                str9 = str3;
                                str10 = str4;
                                str8 = str2;
                                if (video.getLive_status().equalsIgnoreCase(str8)) {
                                    Toast.makeText(dashboardActivityTheme8, "Live class is ended", 0).show();
                                    dashboardActivityTheme8.initialzehomepage();
                                    str11 = str;
                                } else {
                                    if (video.getLive_status().equalsIgnoreCase(str)) {
                                        Toast.makeText(dashboardActivityTheme8, "Live class is cancelled", 0).show();
                                        dashboardActivityTheme8.initialzehomepage();
                                    }
                                    str11 = str;
                                }
                            }
                        }
                        str12 = str13;
                    } else {
                        str8 = str2;
                        str9 = str3;
                        str10 = str4;
                        if (!video.getIs_drm().equals(str6)) {
                            str11 = str;
                            str12 = str6;
                        } else if (video.getLive_status().equalsIgnoreCase(str6)) {
                            if (video.getId() == null || video.getId().equalsIgnoreCase("")) {
                                str12 = str6;
                                Toast.makeText(dashboardActivityTheme8, "Url is not found", 0).show();
                                dashboardActivityTheme8.initialzehomepage();
                                str11 = str;
                                str8 = str8;
                                str9 = str9;
                                str10 = str10;
                                str7 = str7;
                            } else {
                                str12 = str6;
                                Helper.GoToVideoCryptActivity(this, video.getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), video.getVideo_type(), video.getChat_node(), video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "", SingleStudy.parentCourseId, video.getStart_date(), video.getIs_bookmarked(), new ArrayList());
                                dashboardActivityTheme8 = this;
                                str11 = str;
                                str8 = str8;
                                str9 = str9;
                                str10 = str10;
                                str7 = str7;
                                i = 0;
                            }
                        } else {
                            str12 = str6;
                            if (video.getLive_status().equalsIgnoreCase(str7)) {
                                str10 = str10;
                                str9 = str9;
                                Toast.makeText(dashboardActivityTheme8, str10 + new SimpleDateFormat(str9).format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                                dashboardActivityTheme8.initialzehomepage();
                                str11 = str;
                                str8 = str8;
                            } else {
                                str9 = str9;
                                str10 = str10;
                                str8 = str8;
                                if (video.getLive_status().equalsIgnoreCase(str8)) {
                                    Toast.makeText(dashboardActivityTheme8, "Live class is ended", 0).show();
                                    dashboardActivityTheme8.initialzehomepage();
                                    str11 = str;
                                } else {
                                    str11 = str;
                                    if (video.getLive_status().equalsIgnoreCase(str11)) {
                                        Toast.makeText(dashboardActivityTheme8, "Live class is cancelled", 0).show();
                                        dashboardActivityTheme8.initialzehomepage();
                                    }
                                }
                            }
                        }
                    }
                } else {
                    str11 = str;
                    str8 = str2;
                    str9 = str3;
                    str10 = str4;
                    str7 = str5;
                    str12 = str6;
                }
            }
            if (video.getVideo_type().equalsIgnoreCase("5")) {
                if (video.getLive_status().equalsIgnoreCase(str7)) {
                    Toast.makeText(dashboardActivityTheme8, str10 + new SimpleDateFormat(str9).format(new Date(Long.parseLong(video.getStart_date()) * 1000)), i).show();
                    dashboardActivityTheme8.initialzehomepage();
                    return;
                }
                if (video.getLive_status().equalsIgnoreCase(str12)) {
                    Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), dashboardActivityTheme8, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "", dashboardActivityTheme8.parentid, video.getStart_date(), new ArrayList());
                    return;
                }
                if (video.getLive_status().equalsIgnoreCase(str8)) {
                    Toast.makeText(dashboardActivityTheme8, "Live Class is ended", i).show();
                    dashboardActivityTheme8.initialzehomepage();
                    return;
                } else {
                    if (video.getLive_status().equalsIgnoreCase(str11)) {
                        Toast.makeText(dashboardActivityTheme8, "Live Class is cancelled", i).show();
                        dashboardActivityTheme8.initialzehomepage();
                        return;
                    }
                    return;
                }
            }
            String str14 = str12;
            if (video.getVideo_type().equalsIgnoreCase(str7)) {
                Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), dashboardActivityTheme8, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "", dashboardActivityTheme8.parentid, video.getStart_date(), new ArrayList());
                return;
            }
            if (video.getOpen_in_app() != null && video.getOpen_in_app().equalsIgnoreCase(str14)) {
                if (video.getVideo_type().equalsIgnoreCase("4")) {
                    if (video.getLive_status().equalsIgnoreCase(str7)) {
                        Toast.makeText(dashboardActivityTheme8, str10 + new SimpleDateFormat(str9).format(new Date(Long.parseLong(video.getStart_date()) * 1000)), i).show();
                        dashboardActivityTheme8.initialzehomepage();
                        return;
                    }
                    if (video.getLive_status().equalsIgnoreCase(str14)) {
                        Helper.GoToLiveVideoActivity(video.getChat_node(), dashboardActivityTheme8, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getIs_chat_lock(), video.getPayloadData().getCourse_id(), "", dashboardActivityTheme8.parentid, video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), new ArrayList());
                        return;
                    } else if (video.getLive_status().equalsIgnoreCase(str8)) {
                        Toast.makeText(dashboardActivityTheme8, "Live Class is ended", i).show();
                        dashboardActivityTheme8.initialzehomepage();
                        return;
                    } else {
                        if (video.getLive_status().equalsIgnoreCase(str11)) {
                            Toast.makeText(dashboardActivityTheme8, "Live Class is cancelled", i).show();
                            dashboardActivityTheme8.initialzehomepage();
                            return;
                        }
                        return;
                    }
                }
                if (video.getVideo_type().equalsIgnoreCase(str14)) {
                    Helper.GoToLiveVideoActivity(video.getChat_node(), dashboardActivityTheme8, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getIs_chat_lock(), video.getPayloadData().getCourse_id(), "", dashboardActivityTheme8.parentid, video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), new ArrayList());
                    return;
                }
                return;
            }
            dashboardActivityTheme8.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + video.getFile_url())));
        }
    }

    private void initLivevideo(Video video) {
        int i = this.notification_code;
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
                    Helper.GoToWebViewPDFActivity(this, video.getId(), video.getFile_url(), !TextUtils.isEmpty(video.getIs_download_available()) && video.getIs_download_available().equalsIgnoreCase("1"), video.getTitle(), video.getPayloadData().getCourse_id(), video.getIs_share());
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
            Intent intent15 = new Intent(this, (Class<?>) WebViewActivty.class);
            intent15.putExtra("type", video.getTitle());
            intent15.putExtra("url", video.getFile_url());
            intent15.putExtra(Const.VIDEO_ID, video.getId());
            intent15.putExtra("link", video.getFile_type());
            intent15.putExtra("course_id", video.getPayloadData().getCourse_id());
            Helper.gotoActivity(intent15, this);
        }
        if (video.getFile_type().equalsIgnoreCase("7")) {
            Intent intent16 = new Intent(this, (Class<?>) Concept_newActivity.class);
            intent16.putExtra("id", video.getId());
            intent16.putExtra("name", video.getTitle());
            if (this.parentid == null) {
                this.parentid = "";
            }
            if (this.parentid.equalsIgnoreCase("")) {
                intent16.putExtra("course_id", video.getPayloadData().getCourse_id() + MqttTopic.MULTI_LEVEL_WILDCARD);
            } else {
                intent16.putExtra("course_id", this.parentid + MqttTopic.MULTI_LEVEL_WILDCARD + video.getPayloadData().getCourse_id());
            }
            intent16.putExtra("tile_id", video.getPayloadData().getTile_id());
            Helper.gotoActivity(intent16, this);
            return;
        }
        if (video.getFile_type().equalsIgnoreCase("1")) {
            Helper.GoToWebViewPDFActivity(this, video.getId(), video.getFile_url(), !TextUtils.isEmpty(video.getIs_download_available()) && video.getIs_download_available().equalsIgnoreCase("1"), video.getTitle(), video.getPayloadData().getCourse_id(), video.getIs_share());
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
                        setMasterData();
                        break;
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
                        setMasterData();
                        for (MasteAllCatTable masteAllCatTable : this.masterAllCatTables) {
                            if (this.allcatindex_id.equalsIgnoreCase(masteAllCatTable.getParent_id())) {
                                this.selectedsub_all_cat.add(masteAllCatTable);
                            }
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
                            this.no_data_found_RL.setVisibility(8);
                            this.pagecount = 1;
                            setMasterData();
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
            if (SharedPreference.getInstance().getString("sub_cat_ids") != null && !TextUtils.isEmpty(SharedPreference.getInstance().getString("sub_cat_ids"))) {
                this.mastercatid = SharedPreference.getInstance().getString("sub_cat_ids");
                for (MasterCat masterCat : this.mastercatlist) {
                    if (masterCat.getId().equalsIgnoreCase(this.mastercatid) && !this.pullrefresh) {
                        this.mastercatname = masterCat.getCat();
                        this.mastercatid = masterCat.getId();
                        this.toolbartitleTV.setText(masterCat.getCat());
                        this.selected_master_cat.clear();
                        this.selectedsub_all_cat.clear();
                    }
                }
            } else if (SharedPreference.getInstance().getLoggedInUser() != null) {
                ArrayList<Data.Preferences> preferences = SharedPreference.getInstance().getLoggedInUser().getPreferences();
                ArrayList arrayList = new ArrayList();
                if (preferences.size() > 0) {
                    Iterator<MasteAllCatTable> it = this.masterAllCatTables.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MasteAllCatTable next = it.next();
                        if (preferences.get(0).getSub_cat().equalsIgnoreCase(next.getId())) {
                            arrayList.add(next);
                            break;
                        }
                    }
                    for (MasterCat masterCat2 : this.mastercatlist) {
                        if (arrayList.size() > 0 && ((MasteAllCatTable) arrayList.get(0)).getMaster_type().equalsIgnoreCase(masterCat2.getId())) {
                            this.mastercatname = masterCat2.getCat();
                            this.mastercatid = masterCat2.getId();
                            this.toolbartitleTV.setText(masterCat2.getCat());
                            this.selected_master_cat.clear();
                            this.selectedsub_all_cat.clear();
                        }
                    }
                } else if (!this.pullrefresh) {
                    this.mastercatname = this.mastercatlist.get(0).getCat();
                    this.mastercatid = this.mastercatlist.get(0).getId();
                    this.toolbartitleTV.setText(this.mastercatlist.get(0).getCat());
                    this.selected_master_cat.clear();
                    this.selectedsub_all_cat.clear();
                }
            } else if (!this.pullrefresh) {
                this.mastercatname = this.mastercatlist.get(0).getCat();
                this.mastercatid = this.mastercatlist.get(0).getId();
                this.toolbartitleTV.setText(this.mastercatlist.get(0).getCat());
                this.selected_master_cat.clear();
                this.selectedsub_all_cat.clear();
            }
            SharedPreference.getInstance().putString("sub_cat_ids", this.mastercatid);
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
                setMasterData();
            } else {
                this.allcatindex = "";
                this.allcatindex_id = "";
                this.filterOne.setText("");
                this.filterTwo.setText("");
                this.allsubcatindex = "";
                this.allsubcatindex_id = "";
            }
        }
        if (this.isDoubtActive) {
            this.dailyDoseCover.setVisibility(0);
            if (this.dailyDoseFiltered.size() > 0) {
                this.dailyDoseRV.setVisibility(0);
            } else {
                this.noDataDailyDose.setVisibility(0);
            }
            this.courseLayoutCover.setVisibility(8);
            this.cvrNotificationRL.setVisibility(8);
            this.toggle.setDrawerIndicatorEnabled(false);
            this.homeBackIV.setVisibility(0);
            if (this.utkashRoom.getthemeSettingdao().is_setting_exit()) {
                this.bottomSetting = (BottomSetting) new Gson().fromJson(this.utkashRoom.getthemeSettingdao().data().getBottom(), BottomSetting.class);
                this.bottomLL.removeAllViews();
                ArrayList<View> arrayList2 = this.viewArrayList;
                if (arrayList2 != null) {
                    arrayList2.clear();
                }
                for (int i = 0; i < Helper.getBottomMenu(this.bottomMenuTables).size(); i++) {
                    this.bottomLL.addView(initBottomView(Helper.getBottomMenu(this.bottomMenuTables).get(i), "20"));
                }
            }
        } else if (this.utkashRoom.getthemeSettingdao().is_setting_exit()) {
            this.bottomSetting = (BottomSetting) new Gson().fromJson(this.utkashRoom.getthemeSettingdao().data().getBottom(), BottomSetting.class);
            this.bottomLL.removeAllViews();
            ArrayList<View> arrayList3 = this.viewArrayList;
            if (arrayList3 != null) {
                arrayList3.clear();
            }
            for (int i2 = 0; i2 < Helper.getBottomMenu(this.bottomMenuTables).size(); i2++) {
                this.bottomLL.addView(initBottomView(Helper.getBottomMenu(this.bottomMenuTables).get(i2)));
            }
        }
        manageVisibility();
        createMenus();
        callDialog();
        this.pullrefresh = false;
    }

    private void manageVisibility() {
        this.viewPagerRL.setVisibility(8);
        if (this.bottomSetting.getTop_banner() != null && this.bottomSetting.getTop_banner().equalsIgnoreCase("1")) {
            List<BannerListTable> list = this.bannerListTableForTopBanner;
            if (list != null && list.size() > 0) {
                this.viewPagerRL.setVisibility(0);
                return;
            } else {
                this.viewPagerRL.setVisibility(8);
                return;
            }
        }
        this.viewPagerRL.setVisibility(8);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        int i = 0;
        if (!this.isFeedsClicked) {
            if (this.isDailyDoseClicked) {
                this.isDailyDoseClicked = false;
                this.dailyDoseCover.setVisibility(8);
                this.dailyDoseRV.setVisibility(8);
                this.noDataDailyDose.setVisibility(8);
                this.courseLayoutCover.setVisibility(0);
                this.cvrNotificationRL.setVisibility(0);
                this.toggle.setDrawerIndicatorEnabled(true);
                this.homeBackIV.setVisibility(8);
                if (this.utkashRoom.getthemeSettingdao().is_setting_exit()) {
                    this.bottomSetting = (BottomSetting) new Gson().fromJson(this.utkashRoom.getthemeSettingdao().data().getBottom(), BottomSetting.class);
                    this.bottomLL.removeAllViews();
                    ArrayList<View> arrayList = this.viewArrayList;
                    if (arrayList != null) {
                        arrayList.clear();
                    }
                    while (i < Helper.getBottomMenu(this.bottomMenuTables).size()) {
                        this.bottomLL.addView(initBottomView(Helper.getBottomMenu(this.bottomMenuTables).get(i), "1"));
                        i++;
                    }
                    return;
                }
                return;
            }
            if (this.backstatus) {
                if (this.backPressed + 3000 > System.currentTimeMillis()) {
                    getIntent().setData(null);
                    finishAndRemoveTask();
                    return;
                } else {
                    this.backPressed = System.currentTimeMillis();
                    Helper.showSnackBar(this.rootView, getResources().getString(R.string.press_again_to_exit));
                    return;
                }
            }
            if (this.fragment instanceof Chatboot) {
                this.backstatus = true;
                this.forchatbot.setVisibility(8);
                return;
            } else if (this.backPressed + 3000 > System.currentTimeMillis()) {
                getIntent().setData(null);
                finishAndRemoveTask();
                return;
            } else {
                this.backPressed = System.currentTimeMillis();
                Helper.showSnackBar(this.drawer, getResources().getString(R.string.press_again_to_exit));
                return;
            }
        }
        this.isDailyDoseClicked = false;
        this.isFeedsClicked = false;
        this.scrollView.setVisibility(0);
        this.feeds_ll.setVisibility(8);
        this.dailyDoseCover.setVisibility(8);
        this.dailyDoseRV.setVisibility(8);
        this.noDataDailyDose.setVisibility(8);
        this.courseLayoutCover.setVisibility(0);
        this.cvrNotificationRL.setVisibility(0);
        this.toggle.setDrawerIndicatorEnabled(true);
        this.homeBackIV.setVisibility(8);
        if (this.utkashRoom.getthemeSettingdao().is_setting_exit()) {
            this.bottomSetting = (BottomSetting) new Gson().fromJson(this.utkashRoom.getthemeSettingdao().data().getBottom(), BottomSetting.class);
            this.bottomLL.removeAllViews();
            ArrayList<View> arrayList2 = this.viewArrayList;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            while (i < Helper.getBottomMenu(this.bottomMenuTables).size()) {
                this.bottomLL.addView(initBottomView(Helper.getBottomMenu(this.bottomMenuTables).get(i), "1"));
                i++;
            }
        }
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
                        gradientDrawable2.setColor(Color.parseColor(com.clevertap.android.sdk.Constants.BLACK));
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
                    gradientDrawable3.setColor(Color.parseColor(com.clevertap.android.sdk.Constants.BLACK));
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
                linearLayout3.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$openwatchlist_dailog_resource$35(linearLayout3, textView5, linearLayout2, context, textView2, linearLayout, textView);
                    }
                }));
                linearLayout.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$openwatchlist_dailog_resource$36(linearLayout, textView, linearLayout2, context, textView2, linearLayout3, textView5);
                    }
                }));
                linearLayout2.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$openwatchlist_dailog_resource$37(linearLayout2, textView2, linearLayout3, context, textView5, linearLayout, textView);
                    }
                }));
                relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme8.22
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        DashboardActivityTheme8.this.clicktype = "4";
                        PopupMenu popupMenu = new PopupMenu(context, DashboardActivityTheme8.this.launguagespinner, 3);
                        popupMenu.getMenu().add("Select language");
                        for (int i = 0; i < languages.size(); i++) {
                            popupMenu.getMenu().add(((LanguagesTable) languages.get(i)).getLanguage());
                        }
                        popupMenu.setOnMenuItemClickListener(DashboardActivityTheme8.this);
                        popupMenu.show();
                    }
                });
                this.launguagespinner.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme8.23
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        DashboardActivityTheme8.this.clicktype = "4";
                        PopupMenu popupMenu = new PopupMenu(context, DashboardActivityTheme8.this.launguagespinner, 3);
                        popupMenu.getMenu().add("Select language");
                        for (int i = 0; i < languages.size(); i++) {
                            popupMenu.getMenu().add(((LanguagesTable) languages.get(i)).getLanguage());
                        }
                        popupMenu.setOnMenuItemClickListener(DashboardActivityTheme8.this);
                        popupMenu.show();
                    }
                });
                relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme8.24
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        DashboardActivityTheme8.this.clicktype = "5";
                        PopupMenu popupMenu = new PopupMenu(context, DashboardActivityTheme8.this.subjectspinner, 3);
                        popupMenu.getMenu().add("Select subject");
                        for (int i = 0; i < subjects.size(); i++) {
                            popupMenu.getMenu().add(((Subject) subjects.get(i)).getTitle());
                        }
                        popupMenu.setOnMenuItemClickListener(DashboardActivityTheme8.this);
                        popupMenu.show();
                    }
                });
                this.subjectspinner.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme8.25
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        DashboardActivityTheme8.this.clicktype = "5";
                        PopupMenu popupMenu = new PopupMenu(context, DashboardActivityTheme8.this.subjectspinner, 3);
                        popupMenu.getMenu().add("Select subject");
                        for (int i = 0; i < subjects.size(); i++) {
                            popupMenu.getMenu().add(((Subject) subjects.get(i)).getTitle());
                        }
                        popupMenu.setOnMenuItemClickListener(DashboardActivityTheme8.this);
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
    public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$35(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, Context context, TextView textView2, LinearLayout linearLayout3, TextView textView3) {
        this.is_paid = "";
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(com.clevertap.android.sdk.Constants.BLACK));
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
        this.is_paid = "0";
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(com.clevertap.android.sdk.Constants.BLACK));
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
    public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$37(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, Context context, TextView textView2, LinearLayout linearLayout3, TextView textView3) {
        this.is_paid = "1";
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(com.clevertap.android.sdk.Constants.BLACK));
        gradientDrawable.setCornerRadius(0.0f);
        linearLayout.setBackground(gradientDrawable);
        textView.setTextColor(-1);
        linearLayout2.setBackground(context.getResources().getDrawable(R.drawable.bg_tile_unselected));
        textView2.setTextColor(context.getResources().getColor(R.color.country_code_text_color));
        linearLayout3.setBackground(context.getResources().getDrawable(R.drawable.bg_tile_unselected));
        textView3.setTextColor(context.getResources().getColor(R.color.country_code_text_color));
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
                        runOnUiThread(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda20
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
        } finally {
            this.notification_code = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onRestart$38() {
        setMasterData();
        selecteddata();
    }

    public void homeAutoRefresh() {
        if (SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT) == 0) {
            ShortcutBadger.applyCount(getApplicationContext(), SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT));
            this.cvrNotificationCount.setVisibility(8);
            this.cvrNotificationCount.setBackgroundResource(R.drawable.uncircle_notification_count);
            return;
        }
        ShortcutBadger.applyCount(getApplicationContext(), SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT));
        this.cvrNotificationCount.setVisibility(0);
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
                        runOnUiThread(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda27
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
        setMasterData();
        selecteddata();
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
            if (this.utkashRoom == null) {
                this.utkashRoom = UtkashRoom.getAppDatabase(this);
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
        List<BannerListTable> list = this.bannerListTables;
        if (list != null && list.size() > 0) {
            this.bannerListTableForTopBanner.clear();
            for (BannerListTable bannerListTable : this.bannerListTables) {
                if (bannerListTable.getBanner_location().equalsIgnoreCase("0") && bannerListTable.getMaster_cat().equalsIgnoreCase(this.mastercatid)) {
                    this.bannerListTableForTopBanner.add(bannerListTable);
                }
                if (bannerListTable.getBanner_location().equalsIgnoreCase("4")) {
                    this.seminarbannerlist.add(bannerListTable);
                }
            }
            if (this.bannerListTableForTopBanner.size() > 0) {
                this.viewPagerRL.setVisibility(0);
                this.binding.dashBoardMain.bannerSliderLayout.viewPager2.setAdapter(new SliderAdapter(this, this.bannerListTableForTopBanner, new SliderAdapter.BannerClick() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda21
                    @Override // com.appnew.android.Theme.Adapter.SliderAdapter.BannerClick
                    public final void BannerClickItem(BannerListTable bannerListTable2) {
                        this.f$0.BannerClickItem(bannerListTable2);
                    }
                }));
                Utils.INSTANCE.setUpViewPager(this.binding.dashBoardMain.bannerSliderLayout.viewPager2, this.binding.dashBoardMain.bannerSliderLayout.bannerIndicator, this.bannerListTableForTopBanner);
                return;
            }
            this.viewPagerRL.setVisibility(8);
            return;
        }
        this.viewPagerRL.setVisibility(8);
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
        if (this.bottomSetting.getTop_layout().equalsIgnoreCase("1")) {
            this.ll_top.setVisibility(0);
        } else {
            this.ll_top.setVisibility(8);
        }
        if (this.bottomSetting.getTop_banner().equalsIgnoreCase("1")) {
            this.viewPagerRL.setVisibility(0);
        } else {
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

    @Override // com.appnew.android.Theme.Adapter.AdapterDashTile2Theme8.addDashboardItemClicked, com.appnew.android.Theme.Adapter.DashboardTabIconAdapter.addDashboardItemClicked
    public void onDashboardItemClicked(CourseTypeMasterTable courseTypeMasterTable, int position) {
        redirectToHomeActivity(courseTypeMasterTable);
    }

    private void redirectToHomeActivity(CourseTypeMasterTable courseTypeMasterTable) {
        this.contentType_id = courseTypeMasterTable.getId();
        Bundle bundle = new Bundle();
        bundle.putInt(Const.NOTIFICATION_CODE, this.notification_code);
        bundle.putString("course_id", this.course_id);
        bundle.putString("file_id", this.fieldid);
        bundle.putString(Const.ALL_CAT_SUB_ID, this.allsubcatindex_id);
        bundle.putString(Const.TOPIC_ID, this.topicid);
        bundle.putString("tile_id", this.tileid);
        bundle.putString(Const.TILE_TYPE, this.tiletype);
        bundle.putString(Const.REVERT_API, this.revertapi);
        bundle.putString("title", this.title);
        bundle.putString(TypedValues.AttributesType.S_TARGET, this.message_target);
        bundle.putString("url", this.url);
        bundle.putString("image", this.imageUrl);
        bundle.putString("message", this.message);
        bundle.putString(Const.TAB_ID, this.contentType_id);
        bundle.putString(Const.S_ID, this.allcatindex_id);
        bundle.putString(Const.shareparentid, this.parentid);
        bundle.putString(Const.MASTER_CATEGORY_ID, this.mastercatid);
        bundle.putString(Const.FLAG, "homeScreen_ourCourses");
        bundle.putString("fromWhere", "ourcourse");
        bundle.putString(Const.TAB_NAME, courseTypeMasterTable.getName());
        startActivity(new Intent(this, (Class<?>) HomeActivity.class).putExtras(bundle));
    }

    private void setMasterData() {
        this.gridLayoutManager1 = new GridLayoutManager(this, 2);
        this.gridLayoutManager2 = new GridLayoutManager(this, 3);
        RecyclerView recyclerView = this.browseByCoursesRecycler;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(this.gridLayoutManager1);
        }
        this.browseByCoursesRecycler.setNestedScrollingEnabled(false);
        this.browseByCoursesRecycler.addItemDecoration(new GridSpacingItemDecoration(2, 15, false));
        this.courseByExams.clear();
        this.courseTypeMasterTables2.clear();
        this.dailyDoseList.clear();
        for (CourseTypeMasterTable courseTypeMasterTable : this.courseTypeMasterTables) {
            if (courseTypeMasterTable.getView_type().equalsIgnoreCase("3")) {
                this.courseTypeMasterTables2.add(courseTypeMasterTable);
            } else if (courseTypeMasterTable.getView_type().equalsIgnoreCase("0")) {
                this.courseByExams.add(courseTypeMasterTable);
            } else if (courseTypeMasterTable.getView_type().equalsIgnoreCase("6")) {
                this.dailyDoseList.add(courseTypeMasterTable);
            }
        }
        RecyclerView recyclerView2 = this.dailyDoseRV;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(this.gridLayoutManager2);
        }
        this.dailyDoseRV.setNestedScrollingEnabled(false);
        this.dailyDoseRV.addItemDecoration(new GridSpacingItemDecoration(3, 15, false));
        this.dailyDoseFiltered.clear();
        for (CourseTypeMasterTable courseTypeMasterTable2 : this.dailyDoseList) {
            if (this.mastercatid.equalsIgnoreCase(courseTypeMasterTable2.getMaster_category_id())) {
                this.dailyDoseFiltered.add(courseTypeMasterTable2);
            }
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
        if ((SharedPreference.getInstance().getString("sub_cat_ids") != null) & (true ^ TextUtils.isEmpty(SharedPreference.getInstance().getString("sub_cat_ids")))) {
            SharedPreference.getInstance().getString("sub_cat_ids");
        }
        for (BannerListTable bannerListTable2 : arrayList2) {
            for (MasterCat masterCat : this.mastercatlist) {
                if (masterCat.getId().equalsIgnoreCase(SharedPreference.getInstance().getString("sub_cat_ids")) && bannerListTable2.getMaster_cat().equalsIgnoreCase(masterCat.getId())) {
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
        DailyDoseMenuAdapter dailyDoseMenuAdapter = new DailyDoseMenuAdapter(homeactivity, this.dailyDoseFiltered, new IOnDailyDoseClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme8$$ExternalSyntheticLambda28
            @Override // com.appnew.android.Courses.Interfaces.IOnDailyDoseClickListener
            public final void onDailyDoseClick(int i) {
                this.f$0.onDailyDoseClick(i);
            }
        });
        this.dailyDoseMenuAdapter = dailyDoseMenuAdapter;
        this.dailyDoseRV.setAdapter(dailyDoseMenuAdapter);
        if (this.isDailyDoseClicked) {
            this.browseBySublayout.setVisibility(8);
            this.browseByModelayout.setVisibility(8);
            if (this.dailyDoseFiltered.size() > 0) {
                this.dailyDoseRV.setVisibility(0);
                this.noDataDailyDose.setVisibility(8);
            } else {
                this.dailyDoseRV.setVisibility(8);
                this.noDataDailyDose.setVisibility(0);
            }
        } else {
            this.browseBySublayout.setVisibility(0);
            this.browseByModelayout.setVisibility(0);
        }
        ArrayList arrayList4 = new ArrayList();
        for (CourseTypeMasterTable courseTypeMasterTable3 : this.courseTypeMasterTables2) {
            if (this.mastercatid.equalsIgnoreCase(courseTypeMasterTable3.getMaster_category_id())) {
                arrayList4.add(courseTypeMasterTable3);
            }
        }
        if (arrayList4.size() > 0) {
            this.no_data_found_RL.setVisibility(8);
            this.testseries_txt.setVisibility(0);
            this.dashboardTabAdapter.setDataRv(arrayList4);
            this.browseBySublayout.setVisibility(0);
            this.browseByModelayout.setVisibility(0);
            this.no_data_found_RL.setVisibility(8);
        } else {
            AdapterDashTile2Theme8 adapterDashTile2Theme8 = this.dashboardTabAdapter;
            if (adapterDashTile2Theme8 != null) {
                adapterDashTile2Theme8.setDataRv(arrayList4);
            }
            this.browseBySublayout.setVisibility(8);
            this.browseByModelayout.setVisibility(8);
            this.testseries_txt.setVisibility(8);
            this.no_data_found_RL.setVisibility(0);
        }
        ArrayList<CourseTypeMasterTable> arrayList5 = new ArrayList<>();
        for (CourseTypeMasterTable courseTypeMasterTable4 : this.courseByExams) {
            if (this.mastercatid.equalsIgnoreCase(courseTypeMasterTable4.getMaster_category_id())) {
                arrayList5.add(courseTypeMasterTable4);
            }
        }
        if (arrayList5.size() > 0) {
            this.browseBySublayout.setVisibility(0);
            this.no_data_found_RL.setVisibility(8);
            initmodeSlider(arrayList5);
        } else {
            this.browseBySublayout.setVisibility(8);
            if (arrayList4.size() == 0) {
                this.no_data_found_RL.setVisibility(0);
            }
        }
        automateViewPagerSwiping();
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

    private void showsubjectivepopup(ArrayList<Video> videoArrayList) {
        Button button;
        Button button2;
        ImageView imageView;
        Button button3;
        final Video video = videoArrayList.get(0);
        View viewInflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.subjectivepopup, (ViewGroup) null, false);
        final Dialog dialog = new Dialog(this, R.style.CustomAlertDialog);
        dialog.requestWindowFeature(1);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(viewInflate);
        dialog.getWindow().setLayout(-1, -1);
        dialog.show();
        Constants.SUB_TEST_ID = videoArrayList.get(0).getId();
        TextView textView = (TextView) viewInflate.findViewById(R.id.ibt_single_sub_vd_tv_title);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.durationTV);
        Button button4 = (Button) viewInflate.findViewById(R.id.paper);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.ibt_single_sub_vd_iv);
        ImageView imageView3 = (ImageView) viewInflate.findViewById(R.id.backimag);
        AppCompatTextView appCompatTextView = (AppCompatTextView) viewInflate.findViewById(R.id.test_name);
        final Button button5 = (Button) viewInflate.findViewById(R.id.upload);
        Button button6 = (Button) viewInflate.findViewById(R.id.booklet);
        Button button7 = (Button) viewInflate.findViewById(R.id.marks);
        if (!video.getEnd_date().equalsIgnoreCase("0") && !video.getEnd_date().equalsIgnoreCase("")) {
            textView2.setVisibility(0);
            button = button7;
            button2 = button4;
            imageView = imageView2;
            button3 = button6;
            textView2.setText("Test Start: " + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.US).format(new Date(Long.parseLong(video.getStart_date()) * 1000))) + "\nTest End: " + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.US).format(new Date(Long.parseLong(video.getEnd_date()) * 1000))));
        } else {
            button = button7;
            button2 = button4;
            imageView = imageView2;
            button3 = button6;
            textView2.setVisibility(8);
        }
        appCompatTextView.setText(video.getTest_series_name());
        textView.setText(video.getTest_series_name());
        if (video.getAttempt().equalsIgnoreCase("0")) {
            button5.setText("Upload");
        } else {
            button5.setText("View");
        }
        if (video.getImage() == null || video.getImage().equalsIgnoreCase("")) {
            imageView.setImageResource(R.mipmap.square_placeholder);
        } else {
            Helper.setThumbnailImage(this, video.getImage(), getDrawable(R.mipmap.square_placeholder), imageView);
        }
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme8.26
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                    DashboardActivityTheme8.this.initialzehomepage();
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme8.27
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (System.currentTimeMillis() < Long.parseLong(video.getStart_date()) * 1000) {
                    Toast.makeText(DashboardActivityTheme8.this, "Test will start on " + new SimpleDateFormat("dd/MM/yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                    return;
                }
                if (!Helper.isConnected(this)) {
                    Toast.makeText(this, "No Internet Connection", 0).show();
                    return;
                }
                if (video.getIs_locked().equalsIgnoreCase("1")) {
                    if (DashboardActivityTheme8.this.parentid == null || DashboardActivityTheme8.this.parentid.equalsIgnoreCase("")) {
                        Intent intent = new Intent(DashboardActivityTheme8.this, (Class<?>) CourseActivity.class);
                        intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                        intent.putExtra(Const.COURSE_ID_MAIN, video.getPayloadData().getCourse_id());
                        intent.putExtra(Const.COURSE_PARENT_ID, "");
                        intent.putExtra(Const.IS_COMBO, false);
                        SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                        DashboardActivityTheme8.this.startActivity(intent);
                        return;
                    }
                    Intent intent2 = new Intent(DashboardActivityTheme8.this, (Class<?>) CourseActivity.class);
                    intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent2.putExtra(Const.COURSE_ID_MAIN, DashboardActivityTheme8.this.parentid);
                    intent2.putExtra(Const.COURSE_PARENT_ID, "");
                    intent2.putExtra(Const.IS_COMBO, false);
                    SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                    DashboardActivityTheme8.this.startActivity(intent2);
                    return;
                }
                if (!video.getQuestion().equalsIgnoreCase("")) {
                    Constants.SUB_TEST_ID = video.getId();
                    Helper.GoToWebViewPDFActivity(this, video.getId(), video.getQuestion(), true, video.getQuestion().split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r11.length - 1].split("\\.")[0], DashboardActivityTheme8.this.course_id, video.getIs_share());
                    return;
                }
                Toast.makeText(this, "File not found.", 0).show();
            }
        });
        button5.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme8.28
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (button5.getText().toString().equalsIgnoreCase("View")) {
                    Intent intent = new Intent(this, (Class<?>) PdfDetailScreen.class);
                    intent.putExtra("url", video.getAnswers_by_student());
                    this.startActivity(intent);
                    return;
                }
                if (System.currentTimeMillis() < Long.parseLong(video.getStart_date()) * 1000) {
                    Toast.makeText(this, "Test will start on " + new SimpleDateFormat("dd/MM/yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                    return;
                }
                if (!Helper.isConnected(this)) {
                    Toast.makeText(this, "No Internet Connection", 0).show();
                    return;
                }
                if (video.getIs_locked().equalsIgnoreCase("1")) {
                    if (DashboardActivityTheme8.this.parentid == null || DashboardActivityTheme8.this.parentid.equalsIgnoreCase("")) {
                        Intent intent2 = new Intent(DashboardActivityTheme8.this, (Class<?>) CourseActivity.class);
                        intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                        intent2.putExtra(Const.COURSE_ID_MAIN, video.getPayloadData().getCourse_id());
                        intent2.putExtra(Const.COURSE_PARENT_ID, "");
                        intent2.putExtra(Const.IS_COMBO, false);
                        SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                        DashboardActivityTheme8.this.startActivity(intent2);
                        return;
                    }
                    Intent intent3 = new Intent(DashboardActivityTheme8.this, (Class<?>) CourseActivity.class);
                    intent3.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent3.putExtra(Const.COURSE_ID_MAIN, DashboardActivityTheme8.this.parentid);
                    intent3.putExtra(Const.COURSE_PARENT_ID, "");
                    intent3.putExtra(Const.IS_COMBO, false);
                    SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                    DashboardActivityTheme8.this.startActivity(intent3);
                    return;
                }
                Constants.SUB_TEST_ID = video.getId();
                DashboardActivityTheme8.this.checkStoragePermission();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme8.29
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Long.parseLong(video.getResult_date()) * 1000 < System.currentTimeMillis()) {
                    if (!Helper.isConnected(this)) {
                        Toast.makeText(this, "No Internet Connection", 0).show();
                        return;
                    }
                    if (video.getIs_locked().equalsIgnoreCase("1")) {
                        if (DashboardActivityTheme8.this.parentid == null || DashboardActivityTheme8.this.parentid.equalsIgnoreCase("")) {
                            Intent intent = new Intent(DashboardActivityTheme8.this, (Class<?>) CourseActivity.class);
                            intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                            intent.putExtra(Const.COURSE_ID_MAIN, video.getPayloadData().getCourse_id());
                            intent.putExtra(Const.COURSE_PARENT_ID, "");
                            intent.putExtra(Const.IS_COMBO, false);
                            SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                            DashboardActivityTheme8.this.startActivity(intent);
                            return;
                        }
                        Intent intent2 = new Intent(DashboardActivityTheme8.this, (Class<?>) CourseActivity.class);
                        intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                        intent2.putExtra(Const.COURSE_ID_MAIN, DashboardActivityTheme8.this.parentid);
                        intent2.putExtra(Const.COURSE_PARENT_ID, "");
                        intent2.putExtra(Const.IS_COMBO, false);
                        SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                        DashboardActivityTheme8.this.startActivity(intent2);
                        return;
                    }
                    if (!video.getAnswers().equalsIgnoreCase("")) {
                        Constants.SUB_TEST_ID = video.getId();
                        Helper.GoToWebViewPDFActivity(this, video.getId(), video.getAnswers(), true, video.getAnswers().split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r11.length - 1].split("\\.")[0], DashboardActivityTheme8.this.course_id, video.getIs_share());
                        return;
                    }
                    Toast.makeText(this, "File Not found.", 0).show();
                    return;
                }
                Toast.makeText(this, "Result will be available on " + new SimpleDateFormat("dd/MM/yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video.getResult_date()) * 1000)), 0).show();
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme8.30
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Long.parseLong(video.getResult_date()) * 1000 < System.currentTimeMillis()) {
                    if (!Helper.isConnected(this)) {
                        Toast.makeText(this, "No Internet Connection", 0).show();
                        return;
                    }
                    if (video.getIs_locked().equalsIgnoreCase("1")) {
                        if (DashboardActivityTheme8.this.parentid == null || DashboardActivityTheme8.this.parentid.equalsIgnoreCase("")) {
                            Intent intent = new Intent(DashboardActivityTheme8.this, (Class<?>) CourseActivity.class);
                            intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                            intent.putExtra(Const.COURSE_ID_MAIN, video.getPayloadData().getCourse_id());
                            intent.putExtra(Const.COURSE_PARENT_ID, "");
                            intent.putExtra(Const.IS_COMBO, false);
                            SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                            DashboardActivityTheme8.this.startActivity(intent);
                            return;
                        }
                        Intent intent2 = new Intent(DashboardActivityTheme8.this, (Class<?>) CourseActivity.class);
                        intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                        intent2.putExtra(Const.COURSE_ID_MAIN, DashboardActivityTheme8.this.parentid);
                        intent2.putExtra(Const.COURSE_PARENT_ID, "");
                        intent2.putExtra(Const.IS_COMBO, false);
                        SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                        DashboardActivityTheme8.this.startActivity(intent2);
                        return;
                    }
                    Constants.SUB_TEST_ID = video.getId();
                    Helper.GoToSubjectiveResultActivity(this, video.getSolutions(), video.getTest_series_name(), DashboardActivityTheme8.this.course_id, video.getId(), DashboardActivityTheme8.this.tiletype);
                    return;
                }
                Toast.makeText(this, "Result will be available on " + new SimpleDateFormat("dd/MM/yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video.getResult_date()) * 1000)), 0).show();
            }
        });
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme8.31
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialog2, int keyCode, KeyEvent event) {
                if (keyCode != 4) {
                    return true;
                }
                DashboardActivityTheme8.this.initialzehomepage();
                dialog.dismiss();
                return true;
            }
        });
    }

    static <T> ArrayList<ArrayList<T>> chopped(ArrayList<T> list, final int L) {
        ArrayList<ArrayList<T>> arrayList = new ArrayList<>();
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + L;
            arrayList.add(new ArrayList<>(list.subList(i, Math.min(size, i2))));
            i = i2;
        }
        return arrayList;
    }

    private void initmodeSlider(ArrayList<CourseTypeMasterTable> coursesDataArrayList) {
        ArrayList<ArrayList<CourseTypeMasterTable>> arrayList = this.coursesDataArrayListmain;
        if (arrayList != null) {
            arrayList.clear();
        } else {
            this.coursesDataArrayListmain = new ArrayList<>();
        }
        this.coursesDataArrayListmain = chopped(coursesDataArrayList, 6);
        ArrayList<Fragment> arrayList2 = this.mFragmentList;
        if (arrayList2 != null) {
            arrayList2.clear();
        } else {
            this.mFragmentList = new ArrayList<>();
        }
        for (int i = 0; i < this.coursesDataArrayListmain.size(); i++) {
            addFragment(this.coursesDataArrayListmain.get(i));
        }
        this.viewPager.setCurrentItem(0);
        addBottomDots_mode(0);
        IBTPracticeViewPagerAdapter iBTPracticeViewPagerAdapter = new IBTPracticeViewPagerAdapter(getSupportFragmentManager(), this, this.mFragmentList, this.coursesDataArrayListmain.size());
        this.pagerAdapter = iBTPracticeViewPagerAdapter;
        this.viewPager.setAdapter(iBTPracticeViewPagerAdapter);
        this.pagerAdapter.notifyDataSetChanged();
        this.viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme8.32
            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int position) {
                DashboardActivityTheme8.this.viewPager.setCurrentItem(position);
                if ((DashboardActivityTheme8.this.pagerAdapter.getItem(position) instanceof ViewSliderChildFragment) && DashboardActivityTheme8.this.viewPager.getCurrentItem() == position) {
                    DashboardActivityTheme8.this.addBottomDots_mode(position);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addBottomDots_mode(int currentPage) {
        ImageView[] imageViewArr;
        this.layoutDots_Mode.removeAllViews();
        if (this.coursesDataArrayListmain.size() > 1) {
            this.dots = new ImageView[this.coursesDataArrayListmain.size()];
            int i = 0;
            while (true) {
                imageViewArr = this.dots;
                if (i >= imageViewArr.length) {
                    break;
                }
                imageViewArr[i] = new ImageView(this);
                this.dots[i].setImageResource(R.drawable.nonselecteditem_dot);
                this.dots[i].setPadding(5, 5, 5, 0);
                this.layoutDots_Mode.addView(this.dots[i]);
                i++;
            }
            if (imageViewArr.length > 0) {
                imageViewArr[currentPage].setImageResource(R.drawable.selecteditem_dot);
            }
        }
    }

    @Override // com.appnew.android.home.interfaces.IOnCourseClickListener
    public void onCourseItemClick(CourseTypeMasterTable courseTypeMasterTable, int position) {
        redirectToHomeActivity(courseTypeMasterTable);
    }

    @Override // com.appnew.android.Courses.Interfaces.IOnDailyDoseClickListener
    public void onDailyDoseClick(int position) {
        Intent intent = new Intent(this, (Class<?>) CourseActivity.class);
        intent.putExtra(Const.FRAG_TYPE, Const.DIRECTLAYER3);
        intent.putExtra(Const.COURSE_ID_MAIN, this.dailyDoseList.get(position).getCourse_id());
        intent.putExtra(Const.COURSE_PARENT_ID, "");
        intent.putExtra(Const.SUB_CAT, "");
        intent.putExtra(Const.IS_COMBO, false);
        intent.putExtra(AnalyticsConstants.course_name, this.dailyDoseList.get(position).getName());
        Helper.gotoActivity(intent, this);
    }

    @Override // com.appnew.android.Theme.Adapter.SliderAdapter.BannerClick
    public void BannerClickItem(BannerListTable bannerItem) {
        String display_type;
        int i = 0;
        while (true) {
            if (i >= this.courseTypeMasterTables.size()) {
                display_type = "0";
                break;
            } else {
                if (this.courseTypeMasterTables.get(i).getCourse_id().equalsIgnoreCase(bannerItem.getCourse_id())) {
                    display_type = this.courseTypeMasterTables.get(i).getDisplay_type();
                    break;
                }
                i++;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString(Const.TAB_NAME, bannerItem.getBanner_title());
        bundle.putString(Const.TAB_ID, bannerItem.getCourse_id());
        if (display_type.equalsIgnoreCase("1")) {
            startActivity(new Intent(this, (Class<?>) CourseTypeActivity.class).putExtras(bundle));
        } else {
            startActivity(new Intent(this, (Class<?>) HomeActivity.class).putExtras(bundle));
        }
    }

    private void refreshApiFromDownloads() {
        if (Helper.isConnected(this)) {
            new NetworkCall(this, this).NetworkAPICall(API.master_content, "", true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pushEventForInApp(String actionType, BannerListTable bannerListTable) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_id", AnalyticHelper.INSTANCE.getUserId());
        map.put("content_type", !TextUtils.isEmpty(bannerListTable.getLink_type()) ? bannerListTable.getLink_type() : "NA");
        map.put("action_type", actionType);
        AnalyticEvents.INSTANCE.pushEvents(this, AnalyticsConstants.IN_APP_PUSH, map);
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
