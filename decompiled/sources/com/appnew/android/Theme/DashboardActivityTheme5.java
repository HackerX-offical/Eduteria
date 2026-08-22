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
import androidx.appcompat.widget.AppCompatTextView;
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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
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
import com.appnew.android.CreateTest.Activity.CreateTestActivity;
import com.appnew.android.CustomPayment.CustomPaymentActivity;
import com.appnew.android.Download.Audio.AudioPlayerService;
import com.appnew.android.Download.AudioPlayerActivty;
import com.appnew.android.Download.DownloadActivity;
import com.appnew.android.Download.DownloadVideoPlayer;
import com.appnew.android.EncryptionModel.EncryptionData;
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
import com.appnew.android.Payment.PaymentGatewayListener;
import com.appnew.android.Profile.ProfileActivity;
import com.appnew.android.PurchaseHistory.PurchaseHistory;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Theme.Adapter.DashboardTabIconAdapter;
import com.appnew.android.Theme.Adapter.SliderAdapter;
import com.appnew.android.UserHistory.ContactUsPage;
import com.appnew.android.UserHistory.ConversationReplyActivity;
import com.appnew.android.UserHistory.UserHistoryActivity;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.DialogUtils;
import com.appnew.android.Utils.GenericUtils;
import com.appnew.android.Utils.GridSpacingItemDecoration;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.StickyView.ui.StickyScrollView;
import com.appnew.android.Webview.WebViewActivty;
import com.appnew.android.Zoom.Activity.BookMarkList;
import com.appnew.android.cleverTap.AnalyticHelper;
import com.appnew.android.databinding.ActivityHomeTheme5Binding;
import com.appnew.android.home.Activity.HomeActivity;
import com.appnew.android.home.Activity.MyLibraryActivty;
import com.appnew.android.home.Activity.SettingsActivity;
import com.appnew.android.home.Constants;
import com.appnew.android.home.Fragment.Chatboot;
import com.appnew.android.home.Fragment.ContactBottomSheetFragment;
import com.appnew.android.home.adapters.LeftNavAdapter;
import com.appnew.android.home.adapters.TileDataAdapter;
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
import com.appnew.android.table.TopperReviewTable;
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
import com.makeramen.roundedimageview.RoundedImageView;
import com.razorpay.PaymentResultListener;
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
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class DashboardActivityTheme5 extends AppCompatActivity implements NetworkCall.MyNetworkCallBack, onButtonClicked, PopupMenu.OnMenuItemClickListener, DashboardTabIconAdapter.addDashboardItemClicked, PaymentGatewayListener, PaymentResultListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static Activity homeactivity;
    public static Activity homeactivitytheme5;
    LinearLayout CourseLL;
    RelativeLayout RL1P;
    LinearLayout Topperreview;
    ImageView TopperreviewIV;
    private Task<AppUpdateInfo> appUpdateInfoTask;
    private AudioTable audioTable;
    Button backBtn;
    private ActivityHomeTheme5Binding binding;
    LinearLayout bottomLL;
    BottomSetting bottomSetting;
    LinearLayout cartLL;
    public ImageView chatboat;
    ImageButton chromecast;
    public String contentType;
    RecyclerView courseListRV;
    ImageView currentaffairimage;
    LinearLayout cvrNotificationCount;
    DashboardTabIconAdapter dashboardTabAdapter;
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
    GridLayoutManager gridLayoutManager;
    ImageView homeBackIV;
    LinearLayout homeLL;
    ImageView iconFacebook;
    ImageView iconInstagram;
    ImageView iconLinkedIn;
    ImageView iconTelegram;
    ImageView iconTwitter;
    ImageView iconYoutube;
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
    CardView offline_classes;
    LinearLayout ourcouselayout;
    ProgressBar paginationLoader;
    ImageView parentRL;
    TextView profileEmail;
    public ImageView profileImage;
    public ImageView profileImageText;
    RelativeLayout profileLL;
    TextView profileName;
    private SwipeRefreshLayout pullToReferesh;
    private Dialog quizBasicInfoDialog;
    private StickyScrollView scrollView;
    ImageView searchIV;
    ImageView seminarbanner;
    LinearLayout seminarlayout;
    TextView subjectspinner;
    LinearLayout testLL;
    TileDataAdapter tileDataAdapter;
    RecyclerView tileRv;
    TextView tile_tv;
    RelativeLayout titleinnerRL;
    ActionBarDrawerToggle toggle;
    public Toolbar toolbar;
    TextView toolbartitleTV;
    Video topper_video;
    UtkashRoom utkashRoom;
    TextView versionnameTV;
    private Video videodata;
    RelativeLayout viewPagerRL;
    BottomSheetDialog watchlist;
    long backPressed = 0;
    private boolean backstatus = false;
    public String contentType_id = "0";
    List<BottomMenuTable> bottomMenuTables = new ArrayList();
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
    String test_id = "";
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
    List<BannerListTable> seminarbannerlist = new ArrayList();
    int popupBannerStatus = 0;
    String id = "";
    String test_series_date = "";
    String test_series_name = "";
    String solutions = "";
    ViewPager2.OnPageChangeCallback bannerPageChangeCallback = new ViewPager2.OnPageChangeCallback() { // from class: com.appnew.android.Theme.DashboardActivityTheme5.1
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
    private boolean hitMaster = true;
    public View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme5.3
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            for (int i2 = 0; i2 < DashboardActivityTheme5.this.viewArrayList.size(); i2 = i + 1) {
                if (view == DashboardActivityTheme5.this.viewArrayList.get(i2)) {
                    Menu menu = (Menu) view.getTag();
                    String id = menu.getId();
                    id.hashCode();
                    byte b2 = -1;
                    switch (id.hashCode()) {
                        case 50:
                            if (id.equals("2")) {
                                b2 = 0;
                            }
                            break;
                        case 51:
                            if (id.equals("3")) {
                                b2 = 1;
                            }
                            break;
                        case 52:
                            if (id.equals("4")) {
                                b2 = 2;
                            }
                            break;
                        case 53:
                            if (id.equals("5")) {
                                b2 = 3;
                            }
                            break;
                        case 54:
                            if (id.equals("6")) {
                                b2 = 4;
                            }
                            break;
                        case 55:
                            if (id.equals("7")) {
                                b2 = 5;
                            }
                            break;
                        case 56:
                            if (id.equals("8")) {
                                b2 = 6;
                            }
                            break;
                        case 57:
                            if (id.equals("9")) {
                                b2 = 7;
                            }
                            break;
                        case 1568:
                            if (id.equals("11")) {
                                b2 = 8;
                            }
                            break;
                        case 1569:
                            if (id.equals("12")) {
                                b2 = 9;
                            }
                            break;
                        case 1570:
                            if (id.equals("13")) {
                                b2 = 10;
                            }
                            break;
                    }
                    i = i2;
                    switch (b2) {
                        case 0:
                            Intent intent = new Intent(DashboardActivityTheme5.this, (Class<?>) CourseActivity.class);
                            intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY2);
                            intent.putExtra(Const.FRAG_TYPE, Const.DIRECTLAYER3);
                            intent.putExtra(Const.COURSE_ID_MAIN, menu.getType_code());
                            intent.putExtra(Const.COURSE_PARENT_ID, "");
                            intent.putExtra(Const.SUB_CAT, "");
                            intent.putExtra(Const.IS_COMBO, false);
                            intent.putExtra(AnalyticsConstants.course_name, menu.getName());
                            Helper.gotoActivity(intent, DashboardActivityTheme5.this);
                            continue;
                            break;
                        case 1:
                            if (!Helper.isNetworkConnected(DashboardActivityTheme5.this)) {
                                Helper.showInternetToast(DashboardActivityTheme5.this);
                                return;
                            }
                            Helper.gotoActivity(DashboardActivityTheme5.this, (Class<?>) MyLibraryActivty.class);
                            break;
                        case 2:
                            if (!Helper.isNetworkConnected(DashboardActivityTheme5.this)) {
                                Helper.showInternetToast(DashboardActivityTheme5.this);
                                return;
                            }
                            Bundle bundle = new Bundle();
                            bundle.putInt(Const.NOTIFICATION_CODE, DashboardActivityTheme5.this.notification_code);
                            bundle.putString("course_id", DashboardActivityTheme5.this.course_id);
                            bundle.putString("file_id", DashboardActivityTheme5.this.fieldid);
                            bundle.putString(Const.TOPIC_ID, DashboardActivityTheme5.this.topicid);
                            bundle.putString("tile_id", DashboardActivityTheme5.this.tileid);
                            bundle.putString(Const.TILE_TYPE, DashboardActivityTheme5.this.tiletype);
                            bundle.putString(Const.REVERT_API, DashboardActivityTheme5.this.revertapi);
                            bundle.putString("title", DashboardActivityTheme5.this.title);
                            bundle.putString(TypedValues.AttributesType.S_TARGET, DashboardActivityTheme5.this.message_target);
                            bundle.putString("url", DashboardActivityTheme5.this.url);
                            bundle.putString("image", DashboardActivityTheme5.this.imageUrl);
                            bundle.putString("message", DashboardActivityTheme5.this.message);
                            if (DashboardActivityTheme5.this.courseTypeMasterTables.size() > 1) {
                                bundle.putString(Const.TAB_ID, DashboardActivityTheme5.this.courseTypeMasterTables.get(0).getId());
                            } else {
                                bundle.putString(Const.TAB_ID, "1");
                            }
                            if (DashboardActivityTheme5.this.courseTypeMasterTables.size() > 1) {
                                bundle.putString(Const.TAB_NAME, DashboardActivityTheme5.this.courseTypeMasterTables.get(0).getName());
                            } else {
                                bundle.putString(Const.TAB_NAME, "");
                            }
                            if (!GenericUtils.isListEmpty(DashboardActivityTheme5.this.courseTypeMasterTables) && !GenericUtils.isEmpty(DashboardActivityTheme5.this.courseTypeMasterTables.get(0).getMaster_category_id())) {
                                bundle.putString(Const.MASTER_CATEGORY_ID, DashboardActivityTheme5.this.courseTypeMasterTables.get(0).getMaster_category_id());
                            } else {
                                bundle.putString(Const.MASTER_CATEGORY_ID, "0");
                            }
                            DashboardActivityTheme5.this.startActivity(new Intent(DashboardActivityTheme5.this, (Class<?>) HomeActivity.class).putExtras(bundle));
                            DashboardActivityTheme5.this.overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
                            break;
                            break;
                        case 3:
                            if (!Helper.isNetworkConnected(DashboardActivityTheme5.this)) {
                                Helper.showInternetToast(DashboardActivityTheme5.this);
                                return;
                            }
                            Helper.gotoActivity(DashboardActivityTheme5.this, (Class<?>) Notification.class);
                            break;
                        case 4:
                            Helper.gotoActivity(DashboardActivityTheme5.this, (Class<?>) DownloadActivity.class);
                            break;
                        case 5:
                            if (!Helper.isNetworkConnected(DashboardActivityTheme5.this)) {
                                Helper.showInternetToast(DashboardActivityTheme5.this);
                                return;
                            }
                            Helper.gotoActivity(DashboardActivityTheme5.this, CreateTestActivity.class, "1");
                            break;
                        case 6:
                            if (!Helper.isNetworkConnected(DashboardActivityTheme5.this)) {
                                Helper.showInternetToast(DashboardActivityTheme5.this);
                                return;
                            }
                            Helper.gotoActivity(DashboardActivityTheme5.this, (Class<?>) LivetestActivity.class);
                            break;
                        case 7:
                            if (!Helper.isNetworkConnected(DashboardActivityTheme5.this)) {
                                Helper.showInternetToast(DashboardActivityTheme5.this);
                                return;
                            }
                            Helper.gotoActivity(DashboardActivityTheme5.this, (Class<?>) LiveClassActivity.class);
                            break;
                        case 8:
                            if (!Helper.isNetworkConnected(DashboardActivityTheme5.this)) {
                                Helper.showInternetToast(DashboardActivityTheme5.this);
                                return;
                            }
                            Helper.gotoActivity(DashboardActivityTheme5.this, (Class<?>) ProfileActivity.class);
                            break;
                        case 9:
                            DashboardActivityTheme5.this.openWhatsapp();
                            break;
                        case 10:
                            Bundle bundle2 = new Bundle();
                            bundle2.putInt(Const.NOTIFICATION_CODE, DashboardActivityTheme5.this.notification_code);
                            bundle2.putString("course_id", DashboardActivityTheme5.this.course_id);
                            bundle2.putString("file_id", DashboardActivityTheme5.this.fieldid);
                            bundle2.putString(Const.TOPIC_ID, DashboardActivityTheme5.this.topicid);
                            bundle2.putString("tile_id", DashboardActivityTheme5.this.tileid);
                            bundle2.putString(Const.TILE_TYPE, DashboardActivityTheme5.this.tiletype);
                            bundle2.putString(Const.REVERT_API, DashboardActivityTheme5.this.revertapi);
                            bundle2.putString("title", DashboardActivityTheme5.this.title);
                            bundle2.putString("searchenable", "0");
                            bundle2.putString(TypedValues.AttributesType.S_TARGET, DashboardActivityTheme5.this.message_target);
                            bundle2.putString("url", DashboardActivityTheme5.this.url);
                            bundle2.putString("image", DashboardActivityTheme5.this.imageUrl);
                            bundle2.putString("message", DashboardActivityTheme5.this.message);
                            bundle2.putString(Const.TAB_NAME, menu.getName());
                            if (menu.getType_code() != null && !menu.getType_code().equalsIgnoreCase("")) {
                                bundle2.putString(Const.TAB_ID, menu.getType_code());
                            } else {
                                bundle2.putString(Const.TAB_ID, "1");
                            }
                            DashboardActivityTheme5.this.startActivity(new Intent(DashboardActivityTheme5.this, (Class<?>) HomeActivity.class).putExtras(bundle2));
                            break;
                    }
                } else {
                    i = i2;
                }
            }
        }
    };
    List<CourseTypeMasterTable> currentaffair = new ArrayList();
    List<CourseTypeMasterTable> offline = new ArrayList();
    String is_paid = "";
    String[] langIds = {"1"};
    private int STORAGE_PERMISSION_TYPE = 3;
    public final int REQUEST_CODE_MULTIPLE_PIKER = 1203;

    public LinearLayout initBottomView(Menu menu) {
        LinearLayout linearLayout = (LinearLayout) View.inflate(this, R.layout.bottom_item, null);
        TextView textView = (TextView) linearLayout.findViewById(R.id.title);
        final ImageView imageView = (ImageView) linearLayout.findViewById(R.id.icon);
        textView.setText(menu.getName());
        Glide.with((FragmentActivity) this).asBitmap().load(menu.getImageUrl()).into(new CustomTarget<Bitmap>() { // from class: com.appnew.android.Theme.DashboardActivityTheme5.2
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

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(final Bundle savedInstanceState) {
        String str;
        ThemeSettings themeSettingsData;
        String str2;
        DashboardActivityTheme5 dashboardActivityTheme5;
        Intent intent;
        final DashboardActivityTheme5 dashboardActivityTheme52 = this;
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(dashboardActivityTheme52);
        Helper.enableScreenShot(dashboardActivityTheme52);
        dashboardActivityTheme52.utkashRoom = UtkashRoom.getAppDatabase(dashboardActivityTheme52);
        ActivityHomeTheme5Binding activityHomeTheme5BindingInflate = ActivityHomeTheme5Binding.inflate(dashboardActivityTheme52.getLayoutInflater());
        dashboardActivityTheme52.binding = activityHomeTheme5BindingInflate;
        dashboardActivityTheme52.setContentView(activityHomeTheme5BindingInflate.getRoot());
        homeactivitytheme5 = dashboardActivityTheme52;
        Helper.setSystemBarLight(dashboardActivityTheme52);
        homeactivity = dashboardActivityTheme52;
        dashboardActivityTheme52.networkCall = new NetworkCall(dashboardActivityTheme52, dashboardActivityTheme52);
        dashboardActivityTheme52.cartLL = (LinearLayout) dashboardActivityTheme52.findViewById(R.id.cartLL);
        dashboardActivityTheme52.toolbartitleTV = (TextView) dashboardActivityTheme52.findViewById(R.id.toolbartitleTV);
        dashboardActivityTheme52.ourcouselayout = (LinearLayout) dashboardActivityTheme52.findViewById(R.id.ourcouselayout);
        dashboardActivityTheme52.currentaffairimage = (ImageView) dashboardActivityTheme52.findViewById(R.id.currentaffair);
        dashboardActivityTheme52.offline_classes = (CardView) dashboardActivityTheme52.findViewById(R.id.offline_classes);
        dashboardActivityTheme52.parentRL = (ImageView) dashboardActivityTheme52.findViewById(R.id.parentRL);
        dashboardActivityTheme52.seminarbanner = (ImageView) dashboardActivityTheme52.findViewById(R.id.seminarbanner);
        dashboardActivityTheme52.seminarlayout = (LinearLayout) dashboardActivityTheme52.findViewById(R.id.seminarlayout);
        dashboardActivityTheme52.iconFacebook = (ImageView) dashboardActivityTheme52.findViewById(R.id.iconFacebook);
        dashboardActivityTheme52.iconInstagram = (ImageView) dashboardActivityTheme52.findViewById(R.id.iconInstagram);
        dashboardActivityTheme52.iconLinkedIn = (ImageView) dashboardActivityTheme52.findViewById(R.id.iconLinkedIn);
        dashboardActivityTheme52.iconTwitter = (ImageView) dashboardActivityTheme52.findViewById(R.id.iconTwitter);
        dashboardActivityTheme52.iconYoutube = (ImageView) dashboardActivityTheme52.findViewById(R.id.iconYoutube);
        dashboardActivityTheme52.iconTelegram = (ImageView) dashboardActivityTheme52.findViewById(R.id.iconTelegram);
        dashboardActivityTheme52.pullToReferesh = (SwipeRefreshLayout) dashboardActivityTheme52.findViewById(R.id.pullto_referesh);
        dashboardActivityTheme52.notificaionCount = (TextView) dashboardActivityTheme52.findViewById(R.id.notificaionCount);
        dashboardActivityTheme52.cvrNotificationCount = (LinearLayout) dashboardActivityTheme52.findViewById(R.id.cvrNotificationCount);
        dashboardActivityTheme52.pullToReferesh.setRefreshing(false);
        dashboardActivityTheme52.liveclass = (LinearLayout) dashboardActivityTheme52.findViewById(R.id.liveclass);
        dashboardActivityTheme52.libLL = (LinearLayout) dashboardActivityTheme52.findViewById(R.id.libLL);
        dashboardActivityTheme52.livetest = (LinearLayout) dashboardActivityTheme52.findViewById(R.id.livetest);
        dashboardActivityTheme52.bottomLL = (LinearLayout) dashboardActivityTheme52.findViewById(R.id.bottomLL);
        dashboardActivityTheme52.livetestLL = (LinearLayout) dashboardActivityTheme52.findViewById(R.id.livetestLL);
        dashboardActivityTheme52.liveclassLL = (LinearLayout) dashboardActivityTheme52.findViewById(R.id.liveclassLL);
        dashboardActivityTheme52.CourseLL = (LinearLayout) dashboardActivityTheme52.findViewById(R.id.CourseLL);
        dashboardActivityTheme52.filter = (RelativeLayout) dashboardActivityTheme52.findViewById(R.id.filter);
        dashboardActivityTheme52.forchatbot = (FrameLayout) dashboardActivityTheme52.findViewById(R.id.forchatbot);
        dashboardActivityTheme52.filterOne = (TextView) dashboardActivityTheme52.findViewById(R.id.filterOne);
        dashboardActivityTheme52.viewPagerRL = (RelativeLayout) dashboardActivityTheme52.findViewById(R.id.viewPagerRL);
        dashboardActivityTheme52.ll_top = (RelativeLayout) dashboardActivityTheme52.findViewById(R.id.ll_top);
        dashboardActivityTheme52.RL1P = (RelativeLayout) dashboardActivityTheme52.findViewById(R.id.RL1P);
        dashboardActivityTheme52.backBtn = (Button) dashboardActivityTheme52.findViewById(R.id.backBtn);
        dashboardActivityTheme52.profileLL = (RelativeLayout) dashboardActivityTheme52.findViewById(R.id.profileLL);
        dashboardActivityTheme52.filter_one_click = (RelativeLayout) dashboardActivityTheme52.findViewById(R.id.filter_one_click);
        dashboardActivityTheme52.filter_two_click = (RelativeLayout) dashboardActivityTheme52.findViewById(R.id.filter_two_click);
        dashboardActivityTheme52.titleinnerRL = (RelativeLayout) dashboardActivityTheme52.findViewById(R.id.titleinnerRL);
        dashboardActivityTheme52.filterTwo = (TextView) dashboardActivityTheme52.findViewById(R.id.filterTwo);
        dashboardActivityTheme52.downarrowIV = (ImageView) dashboardActivityTheme52.findViewById(R.id.downarrowIV);
        dashboardActivityTheme52.scrollView = (StickyScrollView) dashboardActivityTheme52.findViewById(R.id.scrollView);
        dashboardActivityTheme52.chromecast = (ImageButton) dashboardActivityTheme52.findViewById(R.id.chromecast);
        dashboardActivityTheme52.searchIV = (ImageView) dashboardActivityTheme52.findViewById(R.id.searchIV);
        dashboardActivityTheme52.chatboat = (ImageView) dashboardActivityTheme52.findViewById(R.id.chatboat);
        dashboardActivityTheme52.tileRv = (RecyclerView) dashboardActivityTheme52.findViewById(R.id.tileRv);
        dashboardActivityTheme52.testLL = (LinearLayout) dashboardActivityTheme52.findViewById(R.id.testLL);
        dashboardActivityTheme52.homeLL = (LinearLayout) dashboardActivityTheme52.findViewById(R.id.homeLL);
        dashboardActivityTheme52.navigationView = (NavigationView) dashboardActivityTheme52.findViewById(R.id.nav_view);
        dashboardActivityTheme52.drawer = (DrawerLayout) dashboardActivityTheme52.findViewById(R.id.drawer_layout);
        dashboardActivityTheme52.toolbar = (Toolbar) dashboardActivityTheme52.findViewById(R.id.feeds_toolbar);
        dashboardActivityTheme52.my_library = (LinearLayout) dashboardActivityTheme52.findViewById(R.id.my_library);
        dashboardActivityTheme52.nav_headerLL = (LinearLayout) dashboardActivityTheme52.findViewById(R.id.nav_headerLL);
        dashboardActivityTheme52.courseListRV = (RecyclerView) dashboardActivityTheme52.findViewById(R.id.courseListRV);
        dashboardActivityTheme52.tile_tv = (TextView) dashboardActivityTheme52.findViewById(R.id.tile_tv);
        dashboardActivityTheme52.navRV = (RecyclerView) dashboardActivityTheme52.findViewById(R.id.navRV);
        dashboardActivityTheme52.no_data_found_RL = (RelativeLayout) dashboardActivityTheme52.findViewById(R.id.no_data_found_RL);
        dashboardActivityTheme52.profileImage = (ImageView) dashboardActivityTheme52.findViewById(R.id.profileImage);
        dashboardActivityTheme52.profileImageText = (ImageView) dashboardActivityTheme52.findViewById(R.id.profileImageText);
        dashboardActivityTheme52.profileName = (TextView) dashboardActivityTheme52.findViewById(R.id.profileName);
        dashboardActivityTheme52.profileEmail = (TextView) dashboardActivityTheme52.findViewById(R.id.profileEmail);
        dashboardActivityTheme52.versionnameTV = (TextView) dashboardActivityTheme52.findViewById(R.id.vNameTV);
        dashboardActivityTheme52.paginationLoader = (ProgressBar) dashboardActivityTheme52.findViewById(R.id.progressBar);
        dashboardActivityTheme52.homeBackIV = (ImageView) dashboardActivityTheme52.findViewById(R.id.homeBackIV);
        dashboardActivityTheme52.Topperreview = (LinearLayout) dashboardActivityTheme52.findViewById(R.id.Topperreview);
        dashboardActivityTheme52.TopperreviewIV = (ImageView) dashboardActivityTheme52.findViewById(R.id.TopperreviewIV);
        dashboardActivityTheme52.courseListRV.setLayoutManager(new LinearLayoutManager(dashboardActivityTheme52));
        FragmentManager supportFragmentManager = dashboardActivityTheme52.getSupportFragmentManager();
        dashboardActivityTheme52.fragmentManager = supportFragmentManager;
        supportFragmentManager.beginTransaction().setCustomAnimations(R.anim.activity_in, R.anim.activity_out, R.anim.activity_in, R.anim.activity_out);
        dashboardActivityTheme52.fragment = dashboardActivityTheme52.fragmentManager.findFragmentById(R.id.chatboat);
        AppUpdateManager appUpdateManagerCreate = AppUpdateManagerFactory.create(dashboardActivityTheme52);
        dashboardActivityTheme52.mAppUpdateManager = appUpdateManagerCreate;
        dashboardActivityTheme52.appUpdateInfoTask = appUpdateManagerCreate.getAppUpdateInfo();
        InstallStateUpdatedListener installStateUpdatedListener = new InstallStateUpdatedListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda11
            @Override // com.google.android.play.core.listener.StateUpdatedListener
            public final void onStateUpdate(InstallState installState) {
                this.f$0.lambda$onCreate$0(installState);
            }
        };
        dashboardActivityTheme52.installStateUpdatedListener = installStateUpdatedListener;
        dashboardActivityTheme52.mAppUpdateManager.registerListener(installStateUpdatedListener);
        dashboardActivityTheme52.inAppUpdateType = 0;
        dashboardActivityTheme52.checkAppUpdate();
        MakeMyExam.userId = SharedPreference.getInstance().getLoggedInUser().getId();
        FirebaseCrashlytics.getInstance().setUserId(MakeMyExam.userId);
        dashboardActivityTheme52.courselists.clear();
        dashboardActivityTheme52.backBtn.setVisibility(8);
        if (dashboardActivityTheme52.getIntent() != null) {
            int intExtra = dashboardActivityTheme52.getIntent().getIntExtra(Const.NOTIFICATION_CODE, 0);
            dashboardActivityTheme52.notification_code = intExtra;
            if (intExtra != 0) {
                dashboardActivityTheme52.pushEventForPushNotification("" + dashboardActivityTheme52.notification_code);
            }
            dashboardActivityTheme52.course_id = dashboardActivityTheme52.getIntent().getStringExtra("course_id");
            dashboardActivityTheme52.fieldid = dashboardActivityTheme52.getIntent().getStringExtra("file_id");
            dashboardActivityTheme52.test_id = dashboardActivityTheme52.getIntent().getStringExtra("test_id");
            dashboardActivityTheme52.coupon_for = dashboardActivityTheme52.getIntent().getStringExtra("coupon_for");
            dashboardActivityTheme52.ts = dashboardActivityTheme52.getIntent().getLongExtra(CTProductConfigConstants.KEY_LAST_FETCHED_TIMESTAMP, 0L);
            dashboardActivityTheme52.audioTable = (AudioTable) dashboardActivityTheme52.getIntent().getSerializableExtra("audiotable");
            dashboardActivityTheme52.topicid = dashboardActivityTheme52.getIntent().getStringExtra(Const.TOPIC_ID);
            dashboardActivityTheme52.video_type = dashboardActivityTheme52.getIntent().getStringExtra("type");
            dashboardActivityTheme52.tiletype = dashboardActivityTheme52.getIntent().getStringExtra(Const.TILE_TYPE);
            dashboardActivityTheme52.tileid = dashboardActivityTheme52.getIntent().getStringExtra("tile_id");
            dashboardActivityTheme52.revertapi = dashboardActivityTheme52.getIntent().getStringExtra(Const.REVERT_API);
            dashboardActivityTheme52.type = dashboardActivityTheme52.getIntent().getStringExtra("type");
            dashboardActivityTheme52.title = dashboardActivityTheme52.getIntent().getStringExtra("title");
            dashboardActivityTheme52.message_target = dashboardActivityTheme52.getIntent().getStringExtra(TypedValues.AttributesType.S_TARGET);
            dashboardActivityTheme52.url = dashboardActivityTheme52.getIntent().getStringExtra("url");
            dashboardActivityTheme52.imageUrl = dashboardActivityTheme52.getIntent().getStringExtra("imageUrl");
            dashboardActivityTheme52.message = dashboardActivityTheme52.getIntent().getStringExtra("description");
            dashboardActivityTheme52.parentid = dashboardActivityTheme52.getIntent().getStringExtra(Const.shareparentid);
            dashboardActivityTheme52.test_series_name = dashboardActivityTheme52.getIntent().getStringExtra("test_series_name");
            dashboardActivityTheme52.solutions = dashboardActivityTheme52.getIntent().getStringExtra("solutions");
            dashboardActivityTheme52.test_series_date = dashboardActivityTheme52.getIntent().getStringExtra("result_date");
            dashboardActivityTheme52.id = dashboardActivityTheme52.getIntent().getStringExtra("id");
            String str3 = dashboardActivityTheme52.tiletype;
            if (str3 != null && dashboardActivityTheme52.notification_code == 90002 && (str3.equalsIgnoreCase(Const.PDF) || dashboardActivityTheme52.tiletype.equalsIgnoreCase(Const.CONCEPT) || dashboardActivityTheme52.tiletype.equalsIgnoreCase("link"))) {
                dashboardActivityTheme52.notification_code = 124;
            }
            String str4 = dashboardActivityTheme52.parentid;
            if (str4 == null) {
                str4 = "";
            }
            dashboardActivityTheme52.parentid = str4;
            int i = dashboardActivityTheme52.notification_code;
            if (i == 90002) {
                dashboardActivityTheme52.hit_api_for_data();
            } else if (i == 90001) {
                if (dashboardActivityTheme52.message_target.equalsIgnoreCase("6")) {
                    intent = new Intent(dashboardActivityTheme52, (Class<?>) WebFragActivity.class);
                    intent.putExtra("title", dashboardActivityTheme52.title);
                    intent.putExtra("url", dashboardActivityTheme52.url);
                    intent.putExtra("imageUrl", dashboardActivityTheme52.imageUrl);
                } else if (dashboardActivityTheme52.message_target.equalsIgnoreCase("2")) {
                    intent = new Intent(dashboardActivityTheme52, (Class<?>) CourseActivity.class);
                    intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent.putExtra(Const.COURSE_ID_MAIN, dashboardActivityTheme52.course_id);
                    intent.putExtra(Const.COURSE_PARENT_ID, "");
                    intent.putExtra(Const.IS_COMBO, false);
                    SharedPreference.getInstance().putString("id", dashboardActivityTheme52.course_id);
                } else if (dashboardActivityTheme52.message_target.equalsIgnoreCase("5")) {
                    intent = new Intent(dashboardActivityTheme52, (Class<?>) NotificationDescription.class);
                    intent.putExtra("urlType", "IMAGE");
                    intent.putExtra("title", dashboardActivityTheme52.title);
                    intent.putExtra("url", dashboardActivityTheme52.url);
                    intent.putExtra("imageUrl", dashboardActivityTheme52.imageUrl);
                    intent.putExtra("description", dashboardActivityTheme52.message);
                } else if (dashboardActivityTheme52.message_target.equalsIgnoreCase("1")) {
                    intent = new Intent(dashboardActivityTheme52, (Class<?>) WebFragActivity.class);
                    intent.putExtra("title", dashboardActivityTheme52.title);
                    intent.putExtra("url", dashboardActivityTheme52.message);
                    intent.putExtra("from", "noti");
                } else if (dashboardActivityTheme52.message_target.equalsIgnoreCase("8")) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    long j = dashboardActivityTheme52.ts;
                    if (jCurrentTimeMillis > j * 1000) {
                        if (dashboardActivityTheme52.coupon_for.equalsIgnoreCase("1")) {
                            Toast.makeText(dashboardActivityTheme52, "This coupon is available for all courses", 0).show();
                            dashboardActivityTheme52.initialzehomepage();
                        } else if (dashboardActivityTheme52.coupon_for.equalsIgnoreCase("0") || dashboardActivityTheme52.coupon_for.equalsIgnoreCase("2")) {
                            intent = new Intent(dashboardActivityTheme52, (Class<?>) CouponActivity.class);
                        } else {
                            intent = new Intent(dashboardActivityTheme52, (Class<?>) WebFragActivity.class);
                            intent.putExtra("title", dashboardActivityTheme52.title);
                            intent.putExtra("url", dashboardActivityTheme52.message);
                            intent.putExtra("from", "noti");
                        }
                    } else {
                        if (j != 0) {
                            Toast.makeText(dashboardActivityTheme52, "This coupon is available on " + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.US).format(new Date(dashboardActivityTheme52.ts * 1000))), 0).show();
                        }
                        dashboardActivityTheme52.initialzehomepage();
                    }
                    intent = null;
                } else {
                    intent = new Intent(dashboardActivityTheme52, (Class<?>) WebFragActivity.class);
                    intent.putExtra("title", dashboardActivityTheme52.title);
                    intent.putExtra("url", dashboardActivityTheme52.message);
                    intent.putExtra("from", "noti");
                }
                if (intent != null) {
                    Helper.gotoActivity(intent, dashboardActivityTheme52);
                }
            } else if (i == 90006) {
                Intent intent2 = new Intent(dashboardActivityTheme52, (Class<?>) ConversationReplyActivity.class);
                intent2.putExtra(Const.CONTATUS_ID, dashboardActivityTheme52.id);
                intent2.putExtra(Const.APP_ID, "166");
                dashboardActivityTheme52.startActivity(intent2);
            } else if (i == 90005) {
                if (Long.parseLong(dashboardActivityTheme52.test_series_date) * 1000 < System.currentTimeMillis()) {
                    if (!Helper.isConnected(dashboardActivityTheme52)) {
                        Toast.makeText(dashboardActivityTheme52, R.string.no_internet_connection, 0).show();
                        dashboardActivityTheme52.initialzehomepage();
                    } else {
                        String str5 = dashboardActivityTheme52.fieldid;
                        Constants.SUB_TEST_ID = (str5 == null || TextUtils.isEmpty(str5)) ? dashboardActivityTheme52.test_id : dashboardActivityTheme52.fieldid;
                        Constants.Live_TEST_COURSEID = dashboardActivityTheme52.course_id;
                        Helper.GoToSubjectiveResultActivity(dashboardActivityTheme52, dashboardActivityTheme52.solutions, dashboardActivityTheme52.test_series_name, dashboardActivityTheme52.course_id, dashboardActivityTheme52.fieldid, Const.SUBJECTIVE_TEST);
                        dashboardActivityTheme52 = dashboardActivityTheme52;
                    }
                } else {
                    Toast.makeText(dashboardActivityTheme52, dashboardActivityTheme52.getResources().getString(R.string.result_will_be_available_on) + new SimpleDateFormat("dd/MM/yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(dashboardActivityTheme52.test_series_date) * 1000)), 0).show();
                    dashboardActivityTheme52.initialzehomepage();
                }
            } else if (i == 123 || i == 124 || i == 125) {
                str = "1";
                dashboardActivityTheme52.hit_api_for_data();
            } else {
                AudioTable audioTable = dashboardActivityTheme52.audioTable;
                if (audioTable != null && audioTable.getVideo_id() != null && !dashboardActivityTheme52.audioTable.getVideo_id().equalsIgnoreCase("")) {
                    dashboardActivityTheme52.notification_code = 109010;
                    String str6 = dashboardActivityTheme52.video_type;
                    if (str6 != null && str6.equalsIgnoreCase("jw")) {
                        Intent intent3 = new Intent(dashboardActivityTheme52, (Class<?>) AudioPlayerActivty.class);
                        AudioPlayerService.videoid = "";
                        intent3.putExtra("url", dashboardActivityTheme52.audioTable.getAudio_url());
                        intent3.putExtra("videoid", dashboardActivityTheme52.audioTable.getVideo_id());
                        intent3.putExtra("currentpos", dashboardActivityTheme52.audioTable.getAudio_currentpos());
                        intent3.putExtra("video_name", dashboardActivityTheme52.audioTable.getVideo_name());
                        intent3.putExtra("image_url", dashboardActivityTheme52.audioTable.getJw_url() + "/poster.jpg?width=720");
                        intent3.putExtra("course_id", dashboardActivityTheme52.audioTable.getCourse_id());
                        Helper.gotoActivity(intent3, dashboardActivityTheme52);
                    }
                } else {
                    String str7 = dashboardActivityTheme52.video_type;
                    if (str7 != null && str7.contains("youtube_")) {
                        dashboardActivityTheme52.notification_code = 109010;
                        UserHistroyTable userHistroyTableUser_history = dashboardActivityTheme52.utkashRoom.getuserhistorydao().user_history(MakeMyExam.userId, dashboardActivityTheme52.getIntent().getStringExtra("type").split("_")[1]);
                        if (userHistroyTableUser_history != null) {
                            String str8 = "http://img.youtube.com/vi/" + userHistroyTableUser_history.getYoutube_url() + "/0.jpg";
                            if (userHistroyTableUser_history.getTileid() == null || userHistroyTableUser_history.getTileid().equalsIgnoreCase("")) {
                                str = "1";
                                Helper.GoToLiveVideoActivity("", dashboardActivityTheme52, userHistroyTableUser_history.getYoutube_url(), "1", userHistroyTableUser_history.getVideo_id(), userHistroyTableUser_history.getVideo_name(), "1", str8, "1", userHistroyTableUser_history.getCourse_id(), String.valueOf(1), dashboardActivityTheme52.parentid, dashboardActivityTheme52.tileid, "Video", new ArrayList());
                            } else {
                                str = "1";
                                Helper.GoToLiveVideoActivity("", dashboardActivityTheme52, userHistroyTableUser_history.getYoutube_url(), "1", userHistroyTableUser_history.getVideo_id(), userHistroyTableUser_history.getVideo_name(), "1", str8, "1", userHistroyTableUser_history.getCourse_id(), String.valueOf(1), dashboardActivityTheme52.parentid, userHistroyTableUser_history.getTileid(), "Video", new ArrayList());
                            }
                        } else {
                            str = "1";
                            dashboardActivityTheme52.initialzehomepage();
                        }
                    } else {
                        str = "1";
                        String str9 = dashboardActivityTheme52.video_type;
                        if (str9 != null && str9.contains("aws")) {
                            dashboardActivityTheme52.notification_code = 109010;
                            UserHistroyTable userHistroyTableUser_history2 = dashboardActivityTheme52.utkashRoom.getuserhistorydao().user_history(MakeMyExam.userId, dashboardActivityTheme52.getIntent().getStringExtra("type").split("_")[1]);
                            if (userHistroyTableUser_history2 != null) {
                                if (userHistroyTableUser_history2.getYoutube_url().split("ayush").length == 2) {
                                    dashboardActivityTheme5 = this;
                                    Helper.GoToLiveAwsVideoActivity("0", "", dashboardActivityTheme5, userHistroyTableUser_history2.getYoutube_url().split("ayush")[0], "0", userHistroyTableUser_history2.getVideo_id(), userHistroyTableUser_history2.getVideo_name(), "1", userHistroyTableUser_history2.getYoutube_url().split("ayush")[1], userHistroyTableUser_history2.getCourse_id(), userHistroyTableUser_history2.getTileid(), "Video", "1", "", dashboardActivityTheme52.parentid, "", new ArrayList());
                                } else {
                                    dashboardActivityTheme5 = this;
                                    Helper.GoToLiveAwsVideoActivity("0", "", dashboardActivityTheme5, userHistroyTableUser_history2.getYoutube_url().split("ayush")[0], "0", userHistroyTableUser_history2.getVideo_id(), userHistroyTableUser_history2.getVideo_name(), "1", "", userHistroyTableUser_history2.getCourse_id(), userHistroyTableUser_history2.getTileid(), "Video", "1", "", dashboardActivityTheme52.parentid, "", new ArrayList());
                                }
                                dashboardActivityTheme52 = dashboardActivityTheme5;
                            } else {
                                dashboardActivityTheme52.initialzehomepage();
                            }
                        } else {
                            int i2 = dashboardActivityTheme52.notification_code;
                            if (i2 == 0) {
                                if (Helper.isNetworkConnected(dashboardActivityTheme52)) {
                                    if (dashboardActivityTheme52.utkashRoom.getMasterAllCatDao().isRecordExistsUserId(MakeMyExam.userId)) {
                                        dashboardActivityTheme52.courseTypeMasterTables.clear();
                                        dashboardActivityTheme52.masterAllCatTables.clear();
                                        dashboardActivityTheme52.mastercatlist.clear();
                                        dashboardActivityTheme52.LanguagesTable.clear();
                                        dashboardActivityTheme52.bannerListTables.clear();
                                        dashboardActivityTheme52.bottomMenuTables.clear();
                                        AsyncTask.execute(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda3
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                this.f$0.lambda$onCreate$2();
                                            }
                                        });
                                    } else {
                                        dashboardActivityTheme52.hit_api_master_data();
                                    }
                                }
                            } else if (i2 == 101) {
                                dashboardActivityTheme52.checkdeeplick();
                            }
                        }
                    }
                }
            }
            str = "1";
        } else {
            str = "1";
        }
        dashboardActivityTheme52.homeBackIV.setVisibility(8);
        dashboardActivityTheme52.setHomeDrawer();
        dashboardActivityTheme52.createMenus();
        dashboardActivityTheme52.homeBackIV.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$3();
            }
        }));
        dashboardActivityTheme52.chatboat.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$4(savedInstanceState);
            }
        }));
        dashboardActivityTheme52.currentaffairimage.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme5.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Intent intent4 = new Intent(DashboardActivityTheme5.this, (Class<?>) CourseActivity.class);
                intent4.putExtra(Const.FRAG_TYPE, Const.DIRECTLAYER3);
                intent4.putExtra(Const.COURSE_ID_MAIN, DashboardActivityTheme5.this.currentaffair.get(0).getCourse_id());
                intent4.putExtra(Const.COURSE_PARENT_ID, "");
                intent4.putExtra(Const.IS_COMBO, false);
                intent4.putExtra(Const.SUB_CAT, DashboardActivityTheme5.this.allsubcatindex_id);
                intent4.putExtra(AnalyticsConstants.course_name, "Current Affairs");
                Helper.gotoActivity(intent4, DashboardActivityTheme5.this);
            }
        });
        dashboardActivityTheme52.offline_classes.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$5(view);
            }
        });
        dashboardActivityTheme52.profileLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme5.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Intent intent4 = new Intent(DashboardActivityTheme5.this, (Class<?>) CourseActivity.class);
                intent4.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY2);
                intent4.putExtra(Const.COURSE_ID_MAIN, "333");
                intent4.putExtra(Const.COURSE_PARENT_ID, "");
                intent4.putExtra(Const.SUB_CAT, DashboardActivityTheme5.this.allsubcatindex_id);
                intent4.putExtra(Const.IS_COMBO, false);
                intent4.putExtra(AnalyticsConstants.course_name, "Demo Videos");
                Helper.gotoActivity(intent4, DashboardActivityTheme5.this);
            }
        });
        dashboardActivityTheme52.my_library.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$6();
            }
        }));
        dashboardActivityTheme52.libLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$7();
            }
        }));
        dashboardActivityTheme52.livetest.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$8();
            }
        }));
        dashboardActivityTheme52.liveclassLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$9();
            }
        }));
        dashboardActivityTheme52.livetestLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$10();
            }
        }));
        dashboardActivityTheme52.nav_headerLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$11();
            }
        }));
        dashboardActivityTheme52.liveclass.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda33
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$12();
            }
        }));
        dashboardActivityTheme52.homeLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda36
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$13();
            }
        }));
        dashboardActivityTheme52.testLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda37
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$14();
            }
        }));
        dashboardActivityTheme52.filter.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda38
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$17();
            }
        }));
        dashboardActivityTheme52.scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme5.8
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                try {
                    if (DashboardActivityTheme5.this.scrollView.getChildAt(DashboardActivityTheme5.this.scrollView.getChildCount() - 1).getBottom() - (DashboardActivityTheme5.this.scrollView.getHeight() + DashboardActivityTheme5.this.scrollView.getScrollY()) == 0 && DashboardActivityTheme5.this.notification_code == 0 && DashboardActivityTheme5.this.ispaginationavailable) {
                        if (!DashboardActivityTheme5.this.isfilterapply) {
                            if (DashboardActivityTheme5.this.utkashRoom.getHomeApiStatusdata().isRecordExistsUserId(MakeMyExam.userId, DashboardActivityTheme5.this.mastercatid + "_" + DashboardActivityTheme5.this.allcatindex_id + "_" + DashboardActivityTheme5.this.allsubcatindex_id + "_" + DashboardActivityTheme5.this.contentType_id)) {
                                HomeApiStatusTable homeApiStatusTable = DashboardActivityTheme5.this.utkashRoom.getHomeApiStatusdata().getcoursedetail(DashboardActivityTheme5.this.mastercatid + "_" + DashboardActivityTheme5.this.allcatindex_id + "_" + DashboardActivityTheme5.this.allsubcatindex_id + "_" + DashboardActivityTheme5.this.contentType_id, MakeMyExam.getUserId());
                                if (homeApiStatusTable.getStatus().equalsIgnoreCase("true")) {
                                    DashboardActivityTheme5.this.paginationLoader.setVisibility(0);
                                    DashboardActivityTheme5.this.pagecount = Integer.parseInt(homeApiStatusTable.getPage());
                                    DashboardActivityTheme5.this.pagecount++;
                                    DashboardActivityTheme5.this.getCourseData(false);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        DashboardActivityTheme5.this.pagecount++;
                        DashboardActivityTheme5.this.getCourseData(false);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
        dashboardActivityTheme52.seminarlayout.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda39
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$18();
            }
        }));
        dashboardActivityTheme52.ourcouselayout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme5.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt(Const.NOTIFICATION_CODE, DashboardActivityTheme5.this.notification_code);
                bundle.putString("course_id", DashboardActivityTheme5.this.course_id);
                bundle.putString("file_id", DashboardActivityTheme5.this.fieldid);
                bundle.putString(Const.TOPIC_ID, DashboardActivityTheme5.this.topicid);
                bundle.putString("tile_id", DashboardActivityTheme5.this.tileid);
                bundle.putString(Const.TILE_TYPE, DashboardActivityTheme5.this.tiletype);
                bundle.putString(Const.REVERT_API, DashboardActivityTheme5.this.revertapi);
                bundle.putString("title", DashboardActivityTheme5.this.title);
                bundle.putString(TypedValues.AttributesType.S_TARGET, DashboardActivityTheme5.this.message_target);
                bundle.putString("url", DashboardActivityTheme5.this.url);
                bundle.putString("image", DashboardActivityTheme5.this.imageUrl);
                bundle.putString("message", DashboardActivityTheme5.this.message);
                bundle.putString(Const.TAB_ID, "0");
                bundle.putString(Const.FLAG, "homeScreen_ourCourses");
                bundle.putString("fromWhere", "ourcourse");
                bundle.putString(Const.TAB_NAME, "Our Courses");
                DashboardActivityTheme5.this.startActivity(new Intent(DashboardActivityTheme5.this, (Class<?>) HomeActivity.class).putExtras(bundle));
            }
        });
        dashboardActivityTheme52.chromecast.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda40
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$19();
            }
        }));
        dashboardActivityTheme52.searchIV.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda41
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$20();
            }
        }));
        dashboardActivityTheme52.filter_one_click.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$21();
            }
        }));
        dashboardActivityTheme52.downarrowIV.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$22();
            }
        }));
        dashboardActivityTheme52.cartLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme5.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Intent intent4 = new Intent(DashboardActivityTheme5.this, (Class<?>) CourseActivity.class);
                intent4.putExtra(Const.FRAG_TYPE, Const.DIRECTLAYER3);
                intent4.putExtra(Const.COURSE_ID_MAIN, "455");
                intent4.putExtra(Const.COURSE_PARENT_ID, "");
                intent4.putExtra(Const.SUB_CAT, DashboardActivityTheme5.this.allsubcatindex_id);
                intent4.putExtra(Const.IS_COMBO, false);
                intent4.putExtra(AnalyticsConstants.course_name, "Free Material");
                Helper.gotoActivity(intent4, DashboardActivityTheme5.this);
            }
        });
        dashboardActivityTheme52.Topperreview.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme5.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                TopperReviewTable topperReview;
                if (DashboardActivityTheme5.this.utkashRoom.getTopperReviewDao().getTopperReview(MakeMyExam.userId) == null || (topperReview = DashboardActivityTheme5.this.utkashRoom.getTopperReviewDao().getTopperReview(MakeMyExam.userId)) == null) {
                    return;
                }
                Helper.GoToLiveVideoActivity("", DashboardActivityTheme5.this, topperReview.getFile_url(), "1", topperReview.getId(), topperReview.getTitle(), "1", "http://img.youtube.com/vi/" + topperReview.getFile_url() + "/0.jpg", "1", "", String.valueOf(1), "", "", "Video", new ArrayList());
            }
        });
        dashboardActivityTheme52.titleinnerRL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$23();
            }
        }));
        dashboardActivityTheme52.filter_two_click.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$24();
            }
        }));
        dashboardActivityTheme52.pullToReferesh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme5.12
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                APITABLE apitable = DashboardActivityTheme5.this.utkashRoom.getapidao().getapidetail("ut_009", MakeMyExam.userId);
                if (Long.parseLong(apitable.getTimestamp()) + Long.parseLong(apitable.getInterval()) < System.currentTimeMillis() / 1000) {
                    DashboardActivityTheme5.this.utkashRoom.getLaunguages().deletedata();
                    DashboardActivityTheme5.this.utkashRoom.getMasterAllCatDao().deletedata();
                    DashboardActivityTheme5.this.utkashRoom.getMastercatDao().deletedata();
                    DashboardActivityTheme5.this.utkashRoom.getcoursetypemaster().deletedata();
                    DashboardActivityTheme5.this.pullrefresh = true;
                    DashboardActivityTheme5.this.initialState();
                    DashboardActivityTheme5.this.isfilterchanged = false;
                    DashboardActivityTheme5.this.subjectindex = "";
                    DashboardActivityTheme5.this.launguageindex = "";
                    DashboardActivityTheme5.this.SelectedLaunguageid = "";
                    DashboardActivityTheme5.this.SelectedSubjectid = "";
                    DashboardActivityTheme5.this.is_paid = "";
                    DashboardActivityTheme5.this.ispaginationavailable = false;
                    DashboardActivityTheme5.this.isfilterapply = false;
                    DashboardActivityTheme5.this.hit_api_master_data();
                    DashboardActivityTheme5.this.pullToReferesh.setRefreshing(false);
                    return;
                }
                DashboardActivityTheme5.this.pullToReferesh.setRefreshing(false);
            }
        });
        dashboardActivityTheme52.tileRv.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme5.13
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                DashboardActivityTheme5.this.toggleRefreshing(newState == 0);
            }
        });
        if (Helper.isNetworkConnected(dashboardActivityTheme52) || !dashboardActivityTheme52.utkashRoom.getthemeSettingdao().is_setting_exit() || (themeSettingsData = dashboardActivityTheme52.utkashRoom.getthemeSettingdao().data()) == null) {
            return;
        }
        LeftMenu leftMenu = (LeftMenu) new Gson().fromJson(themeSettingsData.getLeft_menu(), LeftMenu.class);
        BottomMenu bottomMenu = (BottomMenu) new Gson().fromJson(themeSettingsData.getBottom(), BottomMenu.class);
        if (leftMenu != null) {
            str2 = str;
            if (!leftMenu.getDownloads().equalsIgnoreCase(str2)) {
            }
            Helper.goToDownloadsOfflineMode(dashboardActivityTheme52);
        }
        str2 = str;
        if (bottomMenu == null || bottomMenu.getDownloads() == null || !bottomMenu.getDownloads().equalsIgnoreCase(str2)) {
            return;
        }
        Helper.goToDownloadsOfflineMode(dashboardActivityTheme52);
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
            runOnUiThread(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda17
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
        this.cardsArrayList.clear();
        for (CourseTypeMasterTable courseTypeMasterTable : this.courseTypeMasterTables) {
            this.cardsArrayList.add(new Cards(courseTypeMasterTable.getId(), courseTypeMasterTable.getName(), com.clevertap.android.sdk.Constants.BLACK, courseTypeMasterTable.getName(), "0#0#0#0#0#0", "0"));
        }
        if (this.cardsArrayList.size() > 0) {
            getTileItems(this.cardsArrayList, 0);
        }
        selecteddata();
        automateViewPagerSwiping();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$3() {
        onBackPressed();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$4(Bundle bundle) {
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
    public /* synthetic */ void lambda$onCreate$5(View view) {
        Toast.makeText(this, "No Batch Found", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$6() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, (Class<?>) MyLibraryActivty.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$7() {
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
        if (!GenericUtils.isListEmpty(this.offline)) {
            bundle.putString(Const.TAB_ID, "126");
        } else {
            bundle.putString(Const.TAB_ID, "126");
        }
        startActivity(new Intent(this, (Class<?>) HomeActivity.class).putExtras(bundle));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$8() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, (Class<?>) LivetestActivity.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$9() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, (Class<?>) LiveClassActivity.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$10() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, (Class<?>) LivetestActivity.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$11() {
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
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$14() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, CreateTestActivity.class, "1");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$17() {
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
            AsyncTask.execute(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda26
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onCreate$16(data);
                }
            });
        } else {
            Filterdata filterdata = this.filterdata;
            if (filterdata != null && filterdata.getData() != null && this.filterdata.getData().getLanguages() != null) {
                this.filterdata = new Filterdata();
                Data data2 = new Data();
                data2.setSubjects((List) new Gson().fromJson(this.utkashRoom.getMasterAllCatDao().getfilteddata(this.allsubcatindex_id), new TypeToken<List<Subject>>() { // from class: com.appnew.android.Theme.DashboardActivityTheme5.7
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
    public /* synthetic */ void lambda$onCreate$16(Data data) {
        data.setSubjects((ArrayList) new Gson().fromJson(this.utkashRoom.getMasterAllCatDao().getfilteddata(this.allsubcatindex_id), new TypeToken<ArrayList<Subject>>() { // from class: com.appnew.android.Theme.DashboardActivityTheme5.6
        }.getType()));
        data.setLanguages(this.LanguagesTable);
        this.filterdata.setData(data);
        runOnUiThread(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda27
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCreate$15();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$15() {
        openwatchlist_dailog_resource(this, this.filterdata.getData().getLanguages(), this.filterdata.getData().getSubjects());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$18() {
        if (this.seminarbannerlist.size() <= 0) {
            return null;
        }
        this.tileid = this.seminarbannerlist.get(0).getExtra().getTile_id();
        this.tiletype = this.seminarbannerlist.get(0).getExtra().getTile_type();
        this.revertapi = this.seminarbannerlist.get(0).getExtra().getRevert_api();
        this.course_id = this.seminarbannerlist.get(0).getExtra().getCourse_id();
        this.fieldid = this.seminarbannerlist.get(0).getExtra().getFile_id();
        this.parentid = "";
        this.topicid = this.seminarbannerlist.get(0).getExtra().getTopic_id();
        this.notification_code = 90002;
        this.is_seminar = true;
        hit_api_for_data();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$19() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.startCast(this);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$20() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, (Class<?>) Notification.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$21() {
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
    public /* synthetic */ Unit lambda$onCreate$22() {
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
    public /* synthetic */ Unit lambda$onCreate$23() {
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
    public /* synthetic */ Unit lambda$onCreate$24() {
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
        roundedImageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme5.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DashboardActivityTheme5.this.pushEventForInApp("notification_viewed", bannerListTable);
                dialog.dismiss();
                if (bannerListTable.getCourse_id() != null) {
                    if (!bannerListTable.getCourse_id().equals("0")) {
                        Intent intent = new Intent(DashboardActivityTheme5.homeactivitytheme5, (Class<?>) CourseActivity.class);
                        intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                        intent.putExtra(Const.COURSE_ID_MAIN, bannerListTable.getCourse_id());
                        intent.putExtra(Const.COURSE_PARENT_ID, "");
                        intent.putExtra(Const.IS_COMBO, false);
                        intent.putExtra(AnalyticsConstants.course_name, bannerListTable.getBanner_title() != null ? bannerListTable.getBanner_title() : "Course");
                        Helper.gotoActivity(intent, DashboardActivityTheme5.homeactivitytheme5);
                        return;
                    }
                    if (GenericUtils.isEmpty(bannerListTable.getLink())) {
                        return;
                    }
                    DashboardActivityTheme5.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(bannerListTable.getLink())));
                }
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$dialog_latest_popup$25(bannerListTable, dialog, view);
            }
        });
        layoutParams.gravity = 17;
        layoutParams.windowAnimations = R.style.videosheetDialogTheme;
        dialog.getWindow().setAttributes(layoutParams);
        dialog.show();
        SharedPreference.getInstance().putBoolean("showpopup", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dialog_latest_popup$25(BannerListTable bannerListTable, Dialog dialog, View view) {
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
        this.cardsArrayList.clear();
    }

    private void getTileItems(ArrayList<Cards> cardsArrayList, int pos) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        this.gridLayoutManager = gridLayoutManager;
        RecyclerView recyclerView = this.tileRv;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(gridLayoutManager);
        }
        this.tileRv.setNestedScrollingEnabled(false);
        this.tileRv.addItemDecoration(new GridSpacingItemDecoration(2, 15, false));
        ArrayList arrayList = new ArrayList();
        for (CourseTypeMasterTable courseTypeMasterTable : this.courseTypeMasterTables) {
            if (courseTypeMasterTable.getView_type().equalsIgnoreCase("5")) {
                arrayList.add(courseTypeMasterTable);
            } else if (courseTypeMasterTable.getView_type().equalsIgnoreCase("3")) {
                this.offline.add(courseTypeMasterTable);
            } else if (courseTypeMasterTable.getView_type().equalsIgnoreCase("4")) {
                this.currentaffair.add(courseTypeMasterTable);
            }
        }
        DashboardTabIconAdapter dashboardTabIconAdapter = new DashboardTabIconAdapter(this, false, arrayList, this);
        this.dashboardTabAdapter = dashboardTabIconAdapter;
        this.tileRv.setAdapter(dashboardTabIconAdapter);
        if (this.offline.size() > 0) {
            this.offline_classes.setVisibility(0);
            Glide.with((FragmentActivity) this).load(this.offline.get(0).getIcon()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.course_placeholder)).into(this.parentRL);
        } else {
            this.offline_classes.setVisibility(8);
        }
        if (this.currentaffair.size() > 0) {
            this.currentaffairimage.setVisibility(0);
            Glide.with((FragmentActivity) this).load(this.currentaffair.get(0).getIcon()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.course_placeholder)).into(this.currentaffairimage);
        } else {
            this.currentaffairimage.setVisibility(8);
        }
    }

    private void setHomeDrawer() {
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.menu);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, this.drawer, this.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        this.toggle = actionBarDrawerToggle;
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        this.drawer.setDrawerListener(this.toggle);
        this.toggle.syncState();
        this.drawer.addDrawerListener(new DrawerLayout.DrawerListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme5.15
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
                Helper.HideKeyboard(DashboardActivityTheme5.this);
            }
        });
        ActionBarDrawerToggle actionBarDrawerToggle2 = new ActionBarDrawerToggle(this, this.drawer, this.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) { // from class: com.appnew.android.Theme.DashboardActivityTheme5.16
            @Override // androidx.appcompat.app.ActionBarDrawerToggle, androidx.drawerlayout.widget.DrawerLayout.DrawerListener
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override // androidx.appcompat.app.ActionBarDrawerToggle, androidx.drawerlayout.widget.DrawerLayout.DrawerListener
            public void onDrawerOpened(View drawerView) {
                String string = SharedPreference.getInstance().getString(Const.SERVER_TIME);
                if (TextUtils.isEmpty(string) || string.equals("0")) {
                    if (SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE).equalsIgnoreCase("") || SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE).equals("0")) {
                        DashboardActivityTheme5.this.networkCall.NetworkAPICall(API.IS_COUPON_AVAILABLE, "", false, false);
                    } else if (Integer.parseInt(SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE)) > 0) {
                        DashboardActivityTheme5.this.createMenus();
                    }
                } else if (Long.parseLong(string) <= System.currentTimeMillis()) {
                    DashboardActivityTheme5.this.networkCall.NetworkAPICall(API.IS_COUPON_AVAILABLE, "", false, false);
                }
                Helper.HideKeyboard(DashboardActivityTheme5.this);
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
        try {
            if (!this.contentType_id.equalsIgnoreCase(cards.getId())) {
                this.isfilterapply = false;
                getTileItems(tiles, tilePos);
                if (this.utkashRoom.getHomeApiStatusdata().isRecordExistsUserId(MakeMyExam.userId, this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_0")) {
                    if (this.utkashRoom.getHomeApiStatusdata().getcoursedetail(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_0", MakeMyExam.getUserId()).getStatus().equalsIgnoreCase("false")) {
                        this.pagecount = 1;
                        this.courselists.clear();
                        if (this.contentType_id.equalsIgnoreCase("0")) {
                            list = this.utkashRoom.getCoursedata().getcoursedata(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId);
                        } else {
                            list = this.utkashRoom.getCoursedata().getcoursedatawithfilter(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id, MakeMyExam.userId, cards.getId());
                        }
                        for (CourseDataTable courseDataTable : list) {
                            Courselist courselist = new Courselist(courseDataTable.getCourse_id(), courseDataTable.getTitle(), courseDataTable.getCover_image(), courseDataTable.getMrp(), courseDataTable.getCourse_sp(), courseDataTable.getValidity(), courseDataTable.getSubject_id(), courseDataTable.getLang_id(), courseDataTable.getExtra_json());
                            if (courselist.getExtra_json().getHome_screen() == null) {
                                this.courselists.add(courselist);
                            } else if (courselist.getExtra_json().getHome_screen().equalsIgnoreCase("1")) {
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
                        TileDataAdapter tileDataAdapter = new TileDataAdapter(this, this.courselists, "", this, this);
                        this.tileDataAdapter = tileDataAdapter;
                        this.courseListRV.setAdapter(tileDataAdapter);
                        this.courseListRV.setNestedScrollingEnabled(false);
                        return;
                    }
                    this.pagecount = 1;
                    getCourseData(true);
                    return;
                }
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
            this.mAppUpdateManager.getAppUpdateInfo().addOnSuccessListener(new OnSuccessListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda34
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    this.f$0.lambda$onResume$26((AppUpdateInfo) obj);
                }
            });
            this.mAppUpdateManager.getAppUpdateInfo().addOnSuccessListener(new OnSuccessListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda35
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    this.f$0.lambda$onResume$27((AppUpdateInfo) obj);
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

    private void refreshApiFromDownloads() {
        if (Helper.isConnected(this)) {
            new NetworkCall(this, this).NetworkAPICall(API.master_content, "", true, false);
        }
    }

    private void popupSnackbarForCompleteUpdate() {
        try {
            Snackbar snackbarMake = Snackbar.make(this.liveclass, "An update has just been downloaded.", -2);
            snackbarMake.setAction("RESTART", new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda15
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
            this.appUpdateInfoTask.addOnSuccessListener(new OnSuccessListener<AppUpdateInfo>() { // from class: com.appnew.android.Theme.DashboardActivityTheme5.17
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public void onSuccess(AppUpdateInfo appUpdateInfo) {
                    if (appUpdateInfo.updateAvailability() == 2 && appUpdateInfo.isUpdateTypeAllowed(DashboardActivityTheme5.this.inAppUpdateType)) {
                        try {
                            AppUpdateManager appUpdateManager = DashboardActivityTheme5.this.mAppUpdateManager;
                            int i = DashboardActivityTheme5.this.inAppUpdateType;
                            DashboardActivityTheme5 dashboardActivityTheme5 = DashboardActivityTheme5.this;
                            appUpdateManager.startUpdateFlowForResult(appUpdateInfo, i, dashboardActivityTheme5, dashboardActivityTheme5.RC_APP_UPDATE);
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
            leftNavAdapter.setLeftNavAdapterListener(new LeftNavAdapter.LeftNavAdapterListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme5.18
                @Override // com.appnew.android.home.adapters.LeftNavAdapter.LeftNavAdapterListener
                public void onItemClick(Menu menu) {
                    if (menu.getHaveChild().equalsIgnoreCase("1")) {
                        menu.setExpanded(!menu.isExpanded());
                    }
                    DashboardActivityTheme5.this.handleLeftMenuClick(menu);
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
                this.iconTelegram.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$29(leftMenu);
                    }
                }));
            }
            if (Helper.isNullChek(leftMenu.getInstagram_link_data()) && leftMenu.getInstagram_link().equalsIgnoreCase("1")) {
                this.iconInstagram.setVisibility(0);
                this.iconInstagram.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$30(leftMenu);
                    }
                }));
            }
            if (Helper.isNullChek(leftMenu.getLinkedin_link_data()) && leftMenu.getLinkedin_link().equalsIgnoreCase("1")) {
                this.iconLinkedIn.setVisibility(0);
                this.iconLinkedIn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$31(leftMenu);
                    }
                }));
            }
            if (Helper.isNullChek(leftMenu.getYoutube_link_data()) && leftMenu.getYoutube_link().equalsIgnoreCase("1")) {
                this.iconYoutube.setVisibility(0);
                this.iconYoutube.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$32(leftMenu);
                    }
                }));
            }
            if (Helper.isNullChek(leftMenu.getFacebook_link_data()) && leftMenu.getFacebook_link().equalsIgnoreCase("1")) {
                this.iconFacebook.setVisibility(0);
                this.iconFacebook.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$33(leftMenu);
                    }
                }));
            }
            if (Helper.isNullChek(leftMenu.getTwitter_link_data()) && leftMenu.getTwitter_link().equalsIgnoreCase("1")) {
                this.iconTwitter.setVisibility(0);
                this.iconTwitter.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$34(leftMenu);
                    }
                }));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$29(LeftMenu leftMenu) {
        this.drawer.closeDrawer(GravityCompat.START);
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getTelegram_link_data())));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$30(LeftMenu leftMenu) {
        this.drawer.closeDrawer(GravityCompat.START);
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getInstagram_link_data())));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$31(LeftMenu leftMenu) {
        this.drawer.closeDrawer(GravityCompat.START);
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getLinkedin_link_data())));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$32(LeftMenu leftMenu) {
        this.drawer.closeDrawer(GravityCompat.START);
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getYoutube_link_data())));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$33(LeftMenu leftMenu) {
        this.drawer.closeDrawer(GravityCompat.START);
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getFacebook_link_data())));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$34(LeftMenu leftMenu) {
        this.drawer.closeDrawer(GravityCompat.START);
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getTwitter_link_data())));
        return null;
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
                case 1605:
                    if (type_code.equals(Constants.LEFT_NAV_KEY.bookmark)) {
                        b2 = Ascii.NAK;
                    }
                    break;
                case 1822:
                    if (type_code.equals(Constants.LEFT_NAV_KEY.contact_us_query)) {
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
                    Intent intent5 = new Intent(this, (Class<?>) BookMarkList.class);
                    intent5.putExtra("title_key", "Bookmark");
                    startActivity(intent5);
                    if (this.drawer.isDrawerOpen(GravityCompat.START)) {
                        this.drawer.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 22:
                    Intent intent6 = new Intent(this, (Class<?>) ContactUsPage.class);
                    intent6.putExtra("from", Constants.LEFT_NAV_KEY.contact_us_query);
                    startActivity(intent6);
                    if (this.drawer.isDrawerOpen(GravityCompat.START)) {
                        this.drawer.closeDrawer(GravityCompat.START);
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
        DialogUtils.makeDialog(this, title, message, getResources().getString(R.string.yes), getResources().getString(R.string.no), true, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Theme.DashboardActivityTheme5.19
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
            public void onOKClick() {
                if (Helper.isConnected(DashboardActivityTheme5.this)) {
                    DashboardActivityTheme5.this.UserLogout();
                } else {
                    Toast.makeText(DashboardActivityTheme5.this, "No Internet connection", 0).show();
                }
            }
        }, new DialogUtils.onDialogUtilsCancelClick() { // from class: com.appnew.android.Theme.DashboardActivityTheme5.20
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
                encryptionData9.setCourse_type("0");
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
    /* JADX WARN: Removed duplicated region for block: B:108:0x054b A[Catch: Exception -> 0x07ab, TryCatch #1 {Exception -> 0x07ab, blocks: (B:48:0x00a6, B:50:0x00aa, B:52:0x00b0, B:53:0x00b5, B:56:0x00c1, B:58:0x00d2, B:61:0x013f, B:63:0x0145, B:65:0x014b, B:66:0x0152, B:68:0x016d, B:70:0x018c, B:72:0x0190, B:74:0x019e, B:76:0x01d9, B:87:0x0360, B:89:0x0364, B:91:0x036d, B:92:0x0375, B:94:0x037b, B:96:0x03ba, B:106:0x0547, B:108:0x054b, B:110:0x0588, B:112:0x058d, B:113:0x0593, B:115:0x059b, B:117:0x05ad, B:121:0x05dc, B:118:0x05b9, B:120:0x05d1, B:122:0x05df, B:124:0x05f8, B:109:0x056a, B:98:0x045a, B:100:0x0464, B:101:0x046c, B:103:0x0472, B:105:0x04b1, B:77:0x021c, B:78:0x0272, B:80:0x02ad, B:81:0x02ef, B:82:0x0344, B:84:0x0352, B:86:0x035d, B:126:0x0605, B:128:0x0609, B:130:0x060e, B:132:0x0612, B:134:0x0676, B:136:0x0684, B:60:0x00fa, B:138:0x0694, B:140:0x0698, B:142:0x06d3, B:143:0x0712, B:144:0x0763, B:146:0x076c, B:148:0x0772, B:149:0x0779, B:151:0x077d, B:153:0x0782, B:154:0x0792, B:156:0x0798, B:158:0x079e, B:159:0x07a2), top: B:472:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x056a A[Catch: Exception -> 0x07ab, TryCatch #1 {Exception -> 0x07ab, blocks: (B:48:0x00a6, B:50:0x00aa, B:52:0x00b0, B:53:0x00b5, B:56:0x00c1, B:58:0x00d2, B:61:0x013f, B:63:0x0145, B:65:0x014b, B:66:0x0152, B:68:0x016d, B:70:0x018c, B:72:0x0190, B:74:0x019e, B:76:0x01d9, B:87:0x0360, B:89:0x0364, B:91:0x036d, B:92:0x0375, B:94:0x037b, B:96:0x03ba, B:106:0x0547, B:108:0x054b, B:110:0x0588, B:112:0x058d, B:113:0x0593, B:115:0x059b, B:117:0x05ad, B:121:0x05dc, B:118:0x05b9, B:120:0x05d1, B:122:0x05df, B:124:0x05f8, B:109:0x056a, B:98:0x045a, B:100:0x0464, B:101:0x046c, B:103:0x0472, B:105:0x04b1, B:77:0x021c, B:78:0x0272, B:80:0x02ad, B:81:0x02ef, B:82:0x0344, B:84:0x0352, B:86:0x035d, B:126:0x0605, B:128:0x0609, B:130:0x060e, B:132:0x0612, B:134:0x0676, B:136:0x0684, B:60:0x00fa, B:138:0x0694, B:140:0x0698, B:142:0x06d3, B:143:0x0712, B:144:0x0763, B:146:0x076c, B:148:0x0772, B:149:0x0779, B:151:0x077d, B:153:0x0782, B:154:0x0792, B:156:0x0798, B:158:0x079e, B:159:0x07a2), top: B:472:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x058d A[Catch: Exception -> 0x07ab, TryCatch #1 {Exception -> 0x07ab, blocks: (B:48:0x00a6, B:50:0x00aa, B:52:0x00b0, B:53:0x00b5, B:56:0x00c1, B:58:0x00d2, B:61:0x013f, B:63:0x0145, B:65:0x014b, B:66:0x0152, B:68:0x016d, B:70:0x018c, B:72:0x0190, B:74:0x019e, B:76:0x01d9, B:87:0x0360, B:89:0x0364, B:91:0x036d, B:92:0x0375, B:94:0x037b, B:96:0x03ba, B:106:0x0547, B:108:0x054b, B:110:0x0588, B:112:0x058d, B:113:0x0593, B:115:0x059b, B:117:0x05ad, B:121:0x05dc, B:118:0x05b9, B:120:0x05d1, B:122:0x05df, B:124:0x05f8, B:109:0x056a, B:98:0x045a, B:100:0x0464, B:101:0x046c, B:103:0x0472, B:105:0x04b1, B:77:0x021c, B:78:0x0272, B:80:0x02ad, B:81:0x02ef, B:82:0x0344, B:84:0x0352, B:86:0x035d, B:126:0x0605, B:128:0x0609, B:130:0x060e, B:132:0x0612, B:134:0x0676, B:136:0x0684, B:60:0x00fa, B:138:0x0694, B:140:0x0698, B:142:0x06d3, B:143:0x0712, B:144:0x0763, B:146:0x076c, B:148:0x0772, B:149:0x0779, B:151:0x077d, B:153:0x0782, B:154:0x0792, B:156:0x0798, B:158:0x079e, B:159:0x07a2), top: B:472:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x05f8 A[Catch: Exception -> 0x07ab, TryCatch #1 {Exception -> 0x07ab, blocks: (B:48:0x00a6, B:50:0x00aa, B:52:0x00b0, B:53:0x00b5, B:56:0x00c1, B:58:0x00d2, B:61:0x013f, B:63:0x0145, B:65:0x014b, B:66:0x0152, B:68:0x016d, B:70:0x018c, B:72:0x0190, B:74:0x019e, B:76:0x01d9, B:87:0x0360, B:89:0x0364, B:91:0x036d, B:92:0x0375, B:94:0x037b, B:96:0x03ba, B:106:0x0547, B:108:0x054b, B:110:0x0588, B:112:0x058d, B:113:0x0593, B:115:0x059b, B:117:0x05ad, B:121:0x05dc, B:118:0x05b9, B:120:0x05d1, B:122:0x05df, B:124:0x05f8, B:109:0x056a, B:98:0x045a, B:100:0x0464, B:101:0x046c, B:103:0x0472, B:105:0x04b1, B:77:0x021c, B:78:0x0272, B:80:0x02ad, B:81:0x02ef, B:82:0x0344, B:84:0x0352, B:86:0x035d, B:126:0x0605, B:128:0x0609, B:130:0x060e, B:132:0x0612, B:134:0x0676, B:136:0x0684, B:60:0x00fa, B:138:0x0694, B:140:0x0698, B:142:0x06d3, B:143:0x0712, B:144:0x0763, B:146:0x076c, B:148:0x0772, B:149:0x0779, B:151:0x077d, B:153:0x0782, B:154:0x0792, B:156:0x0798, B:158:0x079e, B:159:0x07a2), top: B:472:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:441:0x11c4  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0364 A[Catch: Exception -> 0x07ab, TryCatch #1 {Exception -> 0x07ab, blocks: (B:48:0x00a6, B:50:0x00aa, B:52:0x00b0, B:53:0x00b5, B:56:0x00c1, B:58:0x00d2, B:61:0x013f, B:63:0x0145, B:65:0x014b, B:66:0x0152, B:68:0x016d, B:70:0x018c, B:72:0x0190, B:74:0x019e, B:76:0x01d9, B:87:0x0360, B:89:0x0364, B:91:0x036d, B:92:0x0375, B:94:0x037b, B:96:0x03ba, B:106:0x0547, B:108:0x054b, B:110:0x0588, B:112:0x058d, B:113:0x0593, B:115:0x059b, B:117:0x05ad, B:121:0x05dc, B:118:0x05b9, B:120:0x05d1, B:122:0x05df, B:124:0x05f8, B:109:0x056a, B:98:0x045a, B:100:0x0464, B:101:0x046c, B:103:0x0472, B:105:0x04b1, B:77:0x021c, B:78:0x0272, B:80:0x02ad, B:81:0x02ef, B:82:0x0344, B:84:0x0352, B:86:0x035d, B:126:0x0605, B:128:0x0609, B:130:0x060e, B:132:0x0612, B:134:0x0676, B:136:0x0684, B:60:0x00fa, B:138:0x0694, B:140:0x0698, B:142:0x06d3, B:143:0x0712, B:144:0x0763, B:146:0x076c, B:148:0x0772, B:149:0x0779, B:151:0x077d, B:153:0x0782, B:154:0x0792, B:156:0x0798, B:158:0x079e, B:159:0x07a2), top: B:472:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x045a A[Catch: Exception -> 0x07ab, TryCatch #1 {Exception -> 0x07ab, blocks: (B:48:0x00a6, B:50:0x00aa, B:52:0x00b0, B:53:0x00b5, B:56:0x00c1, B:58:0x00d2, B:61:0x013f, B:63:0x0145, B:65:0x014b, B:66:0x0152, B:68:0x016d, B:70:0x018c, B:72:0x0190, B:74:0x019e, B:76:0x01d9, B:87:0x0360, B:89:0x0364, B:91:0x036d, B:92:0x0375, B:94:0x037b, B:96:0x03ba, B:106:0x0547, B:108:0x054b, B:110:0x0588, B:112:0x058d, B:113:0x0593, B:115:0x059b, B:117:0x05ad, B:121:0x05dc, B:118:0x05b9, B:120:0x05d1, B:122:0x05df, B:124:0x05f8, B:109:0x056a, B:98:0x045a, B:100:0x0464, B:101:0x046c, B:103:0x0472, B:105:0x04b1, B:77:0x021c, B:78:0x0272, B:80:0x02ad, B:81:0x02ef, B:82:0x0344, B:84:0x0352, B:86:0x035d, B:126:0x0605, B:128:0x0609, B:130:0x060e, B:132:0x0612, B:134:0x0676, B:136:0x0684, B:60:0x00fa, B:138:0x0694, B:140:0x0698, B:142:0x06d3, B:143:0x0712, B:144:0x0763, B:146:0x076c, B:148:0x0772, B:149:0x0779, B:151:0x077d, B:153:0x0782, B:154:0x0792, B:156:0x0798, B:158:0x079e, B:159:0x07a2), top: B:472:0x00a6 }] */
    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void SuccessCallBack(org.json.JSONObject r29, java.lang.String r30, java.lang.String r31, boolean r32) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 4948
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Theme.DashboardActivityTheme5.SuccessCallBack(org.json.JSONObject, java.lang.String, java.lang.String, boolean):void");
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

    public void showPopMenuForLangauge(final View v, final TestBasicInst testBasicInst, final TextView v1, TextView ddd) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme5.22
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem item) {
                ((TextView) v).setText(item.getTitle().toString());
                if (item.getTitle().toString().equals(DashboardActivityTheme5.this.getResources().getString(R.string.hindi))) {
                    DashboardActivityTheme5.this.lang = 2;
                    if (testBasicInst.getMulti_description().get(1).getDescription() != null) {
                        v1.setText(Html.fromHtml(testBasicInst.getMulti_description().get(1).getDescription()));
                    }
                } else if (item.getTitle().toString().equals(DashboardActivityTheme5.this.getResources().getString(R.string.english))) {
                    DashboardActivityTheme5.this.lang = 1;
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
        DashboardActivityTheme5 dashboardActivityTheme5 = this;
        if (dashboardActivityTheme5.notification_code == 90002) {
            int i = 0;
            dashboardActivityTheme5.is_seminar = false;
            if (video.getVideo_type().equalsIgnoreCase("7")) {
                if (video.getIs_drm().equals("0")) {
                    if (video.getId() == null || video.getId().equalsIgnoreCase("")) {
                        Toast.makeText(dashboardActivityTheme5, "Url is not found", 0).show();
                        dashboardActivityTheme5.initialzehomepage();
                        str11 = "3";
                        str8 = "2";
                        str9 = "dd MMM yyyy hh:mm a";
                        str10 = "Live Class will start on ";
                        str7 = "0";
                        str12 = "1";
                    } else {
                        Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), dashboardActivityTheme5, video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "", SingleStudy.parentCourseId, video.getStart_date(), new ArrayList());
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
                        Toast.makeText(dashboardActivityTheme5, "Url is not found", 0).show();
                        dashboardActivityTheme5.initialzehomepage();
                        str11 = str;
                        str8 = str2;
                        str9 = str3;
                        str10 = str4;
                        str7 = str5;
                        str12 = str6;
                    } else {
                        Helper.GoToVideoCryptActivity(this, video.getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), video.getVideo_type(), video.getChat_node(), video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "", SingleStudy.parentCourseId, video.getStart_date(), video.getIs_bookmarked(), new ArrayList());
                        dashboardActivityTheme5 = this;
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
                                Toast.makeText(dashboardActivityTheme5, "Url is not found", 0).show();
                                dashboardActivityTheme5.initialzehomepage();
                                str11 = str;
                                str8 = str2;
                                str9 = str3;
                                str10 = str4;
                                str7 = str7;
                            } else {
                                Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), dashboardActivityTheme5, video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "", SingleStudy.parentCourseId, video.getStart_date(), new ArrayList());
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
                                Toast.makeText(dashboardActivityTheme5, str10 + new SimpleDateFormat(str9).format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                                dashboardActivityTheme5.initialzehomepage();
                                str11 = str;
                                str8 = str2;
                            } else {
                                str9 = str3;
                                str10 = str4;
                                str8 = str2;
                                if (video.getLive_status().equalsIgnoreCase(str8)) {
                                    Toast.makeText(dashboardActivityTheme5, "Live class is ended", 0).show();
                                    dashboardActivityTheme5.initialzehomepage();
                                    str11 = str;
                                } else {
                                    if (video.getLive_status().equalsIgnoreCase(str)) {
                                        Toast.makeText(dashboardActivityTheme5, "Live class is cancelled", 0).show();
                                        dashboardActivityTheme5.initialzehomepage();
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
                                Toast.makeText(dashboardActivityTheme5, "Url is not found", 0).show();
                                dashboardActivityTheme5.initialzehomepage();
                                str11 = str;
                                str8 = str8;
                                str9 = str9;
                                str10 = str10;
                                str7 = str7;
                            } else {
                                str12 = str6;
                                Helper.GoToVideoCryptActivity(this, video.getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), video.getVideo_type(), video.getChat_node(), video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "", SingleStudy.parentCourseId, video.getStart_date(), video.getIs_bookmarked(), new ArrayList());
                                dashboardActivityTheme5 = this;
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
                                Toast.makeText(dashboardActivityTheme5, str10 + new SimpleDateFormat(str9).format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                                dashboardActivityTheme5.initialzehomepage();
                                str11 = str;
                                str8 = str8;
                            } else {
                                str9 = str9;
                                str10 = str10;
                                str8 = str8;
                                if (video.getLive_status().equalsIgnoreCase(str8)) {
                                    Toast.makeText(dashboardActivityTheme5, "Live class is ended", 0).show();
                                    dashboardActivityTheme5.initialzehomepage();
                                    str11 = str;
                                } else {
                                    str11 = str;
                                    if (video.getLive_status().equalsIgnoreCase(str11)) {
                                        Toast.makeText(dashboardActivityTheme5, "Live class is cancelled", 0).show();
                                        dashboardActivityTheme5.initialzehomepage();
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
                    Toast.makeText(dashboardActivityTheme5, str10 + new SimpleDateFormat(str9).format(new Date(Long.parseLong(video.getStart_date()) * 1000)), i).show();
                    dashboardActivityTheme5.initialzehomepage();
                    return;
                }
                if (video.getLive_status().equalsIgnoreCase(str12)) {
                    Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), dashboardActivityTheme5, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "", dashboardActivityTheme5.parentid, video.getStart_date(), new ArrayList());
                    return;
                }
                if (video.getLive_status().equalsIgnoreCase(str8)) {
                    Toast.makeText(dashboardActivityTheme5, "Live Class is ended", i).show();
                    dashboardActivityTheme5.initialzehomepage();
                    return;
                } else {
                    if (video.getLive_status().equalsIgnoreCase(str11)) {
                        Toast.makeText(dashboardActivityTheme5, "Live Class is cancelled", i).show();
                        dashboardActivityTheme5.initialzehomepage();
                        return;
                    }
                    return;
                }
            }
            String str14 = str12;
            if (video.getVideo_type().equalsIgnoreCase(str7)) {
                Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), dashboardActivityTheme5, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "", dashboardActivityTheme5.parentid, video.getStart_date(), new ArrayList());
                return;
            }
            if (video.getOpen_in_app() != null && video.getOpen_in_app().equalsIgnoreCase(str14)) {
                if (video.getVideo_type().equalsIgnoreCase("4")) {
                    if (video.getLive_status().equalsIgnoreCase(str7)) {
                        Toast.makeText(dashboardActivityTheme5, str10 + new SimpleDateFormat(str9).format(new Date(Long.parseLong(video.getStart_date()) * 1000)), i).show();
                        dashboardActivityTheme5.initialzehomepage();
                        return;
                    }
                    if (video.getLive_status().equalsIgnoreCase(str14)) {
                        Helper.GoToLiveVideoActivity(video.getChat_node(), dashboardActivityTheme5, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getIs_chat_lock(), video.getPayloadData().getCourse_id(), "", dashboardActivityTheme5.parentid, video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), new ArrayList());
                        return;
                    } else if (video.getLive_status().equalsIgnoreCase(str8)) {
                        Toast.makeText(dashboardActivityTheme5, "Live Class is ended", i).show();
                        dashboardActivityTheme5.initialzehomepage();
                        return;
                    } else {
                        if (video.getLive_status().equalsIgnoreCase(str11)) {
                            Toast.makeText(dashboardActivityTheme5, "Live Class is cancelled", i).show();
                            dashboardActivityTheme5.initialzehomepage();
                            return;
                        }
                        return;
                    }
                }
                if (video.getVideo_type().equalsIgnoreCase(str14)) {
                    Helper.GoToLiveVideoActivity(video.getChat_node(), dashboardActivityTheme5, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getIs_chat_lock(), video.getPayloadData().getCourse_id(), "", dashboardActivityTheme5.parentid, video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), new ArrayList());
                    return;
                }
                return;
            }
            dashboardActivityTheme5.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + video.getFile_url())));
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
                    Toast.makeText(this, "No pdf found!", 0).show();
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
                    Toast.makeText(this, "Url is not found", 0).show();
                    initialzehomepage();
                    return;
                } else {
                    Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), this, video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "", SingleStudy.parentCourseId, video.getStart_date(), new ArrayList());
                    return;
                }
            }
            if (video.getIs_drm().equals("1")) {
                if (video.getId() == null || video.getId().equalsIgnoreCase("")) {
                    Toast.makeText(this, "Url is not found", 0).show();
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
                        Toast.makeText(this, "Url is not found", 0).show();
                        initialzehomepage();
                        return;
                    } else {
                        Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), this, video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "", SingleStudy.parentCourseId, video.getStart_date(), new ArrayList());
                        return;
                    }
                }
                if (video.getLive_status().equalsIgnoreCase("0")) {
                    Toast.makeText(this, "Live Class will start on " + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                    initialzehomepage();
                    return;
                } else if (video.getLive_status().equalsIgnoreCase("2")) {
                    Toast.makeText(this, "Live class is ended", 0).show();
                    initialzehomepage();
                    return;
                } else {
                    if (video.getLive_status().equalsIgnoreCase("3")) {
                        Toast.makeText(this, "Live class is cancelled", 0).show();
                        initialzehomepage();
                        return;
                    }
                    return;
                }
            }
            if (video.getIs_drm().equals("1")) {
                if (video.getLive_status().equalsIgnoreCase("1")) {
                    if (video.getId() == null || video.getId().equalsIgnoreCase("")) {
                        Toast.makeText(this, "Url is not found", 0).show();
                        initialzehomepage();
                        return;
                    } else {
                        Helper.GoToVideoCryptActivity(this, video.getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), video.getVideo_type(), video.getChat_node(), video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "", SingleStudy.parentCourseId, video.getStart_date(), video.getIs_bookmarked(), new ArrayList());
                        return;
                    }
                }
                if (video.getLive_status().equalsIgnoreCase("0")) {
                    Toast.makeText(this, "Live Class will start on " + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                    initialzehomepage();
                    return;
                } else if (video.getLive_status().equalsIgnoreCase("2")) {
                    Toast.makeText(this, "Live class is ended", 0).show();
                    initialzehomepage();
                    return;
                } else {
                    if (video.getLive_status().equalsIgnoreCase("3")) {
                        Toast.makeText(this, "Live class is cancelled", 0).show();
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
                Toast.makeText(this, "Live Class will start on " + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                initialzehomepage();
                return;
            }
            if (video.getLive_status().equalsIgnoreCase("1")) {
                Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), this, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "", this.parentid, video.getStart_date(), new ArrayList());
                return;
            }
            if (video.getLive_status().equalsIgnoreCase("2")) {
                Toast.makeText(this, "Live Class is ended", 0).show();
                initialzehomepage();
                return;
            } else {
                if (video.getLive_status().equalsIgnoreCase("3")) {
                    Toast.makeText(this, "Live Class is cancelled", 0).show();
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
                    Toast.makeText(this, "Live Class will start on " + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                    initialzehomepage();
                    return;
                }
                if (video.getLive_status().equalsIgnoreCase("1")) {
                    Helper.GoToLiveVideoActivity(video.getChat_node(), this, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getIs_chat_lock(), video.getPayloadData().getCourse_id(), "", this.parentid, video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), new ArrayList());
                    return;
                }
                if (video.getLive_status().equalsIgnoreCase("2")) {
                    Toast.makeText(this, "Live Class is ended", 0).show();
                    initialzehomepage();
                    return;
                } else {
                    if (video.getLive_status().equalsIgnoreCase("3")) {
                        Toast.makeText(this, "Live Class is cancelled", 0).show();
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
                        if (this.cardsArrayList.size() > 0) {
                            getTileItems(this.cardsArrayList, 0);
                        }
                        getCourseData(true);
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
                            getCourseData(true);
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
                            this.courseListRV.setVisibility(0);
                            this.no_data_found_RL.setVisibility(8);
                            this.pagecount = 1;
                            getCourseData(true);
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
        TopperReviewTable topperReview;
        if (this.utkashRoom.getTopperReviewDao().getTopperReview(MakeMyExam.userId) != null && (topperReview = this.utkashRoom.getTopperReviewDao().getTopperReview(MakeMyExam.userId)) != null) {
            this.Topperreview.setVisibility(0);
            if (!TextUtils.isEmpty(topperReview.getBanner_url())) {
                Helper.setThumbnailImage(this, topperReview.getBanner_url(), getResources().getDrawable(R.mipmap.placeholder), this.TopperreviewIV);
            } else if (!TextUtils.isEmpty(topperReview.getThumbnail_url())) {
                Helper.setThumbnailImage(this, topperReview.getThumbnail_url(), getResources().getDrawable(R.mipmap.placeholder), this.TopperreviewIV);
            } else {
                this.TopperreviewIV.setImageResource(R.mipmap.placeholder);
            }
        }
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
                    data.setSubjects((List) new Gson().fromJson(str, new TypeToken<List<Subject>>() { // from class: com.appnew.android.Theme.DashboardActivityTheme5.23
                    }.getType()));
                    data.setLanguages(this.LanguagesTable);
                    this.filterdata.setData(data);
                    getCourseData(true);
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
        callDialog();
        this.pullrefresh = false;
    }

    private void manageVisibility() {
        this.viewPagerRL.setVisibility(8);
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
    }

    private void setdata() {
        for (CourseDataTable courseDataTable : this.courseDataTables) {
            this.courselists.add(new Courselist(courseDataTable.getCourse_id(), courseDataTable.getTitle(), courseDataTable.getCover_image(), courseDataTable.getMrp(), courseDataTable.getCourse_sp(), courseDataTable.getValidity(), courseDataTable.getSubject_id(), courseDataTable.getLang_id(), courseDataTable.getExtra_json()));
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
        Dialog dialog = this.quizBasicInfoDialog;
        if (dialog != null && dialog.isShowing()) {
            this.quizBasicInfoDialog.dismiss();
            initialzehomepage();
            return;
        }
        if (this.backstatus) {
            if (this.backPressed + 3000 > System.currentTimeMillis()) {
                getIntent().setData(null);
                finishAndRemoveTask();
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
        } else if (this.backPressed + 3000 > System.currentTimeMillis()) {
            getIntent().setData(null);
            finishAndRemoveTask();
        } else {
            this.backPressed = System.currentTimeMillis();
            Helper.showSnackBar(this.drawer, getResources().getString(R.string.press_again_to_exit));
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
                linearLayout3.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda29
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$openwatchlist_dailog_resource$35(linearLayout3, textView5, linearLayout2, context, textView2, linearLayout, textView);
                    }
                }));
                linearLayout.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda30
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$openwatchlist_dailog_resource$36(linearLayout, textView, linearLayout2, context, textView2, linearLayout3, textView5);
                    }
                }));
                linearLayout2.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda31
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$openwatchlist_dailog_resource$37(linearLayout2, textView2, linearLayout3, context, textView5, linearLayout, textView);
                    }
                }));
                button.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda32
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$openwatchlist_dailog_resource$38(context);
                    }
                }));
                relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme5.24
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        DashboardActivityTheme5.this.clicktype = "4";
                        PopupMenu popupMenu = new PopupMenu(context, DashboardActivityTheme5.this.launguagespinner, 3);
                        popupMenu.getMenu().add("Select language");
                        for (int i = 0; i < languages.size(); i++) {
                            popupMenu.getMenu().add(((LanguagesTable) languages.get(i)).getLanguage());
                        }
                        popupMenu.setOnMenuItemClickListener(DashboardActivityTheme5.this);
                        popupMenu.show();
                    }
                });
                this.launguagespinner.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme5.25
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        DashboardActivityTheme5.this.clicktype = "4";
                        PopupMenu popupMenu = new PopupMenu(context, DashboardActivityTheme5.this.launguagespinner, 3);
                        popupMenu.getMenu().add("Select language");
                        for (int i = 0; i < languages.size(); i++) {
                            popupMenu.getMenu().add(((LanguagesTable) languages.get(i)).getLanguage());
                        }
                        popupMenu.setOnMenuItemClickListener(DashboardActivityTheme5.this);
                        popupMenu.show();
                    }
                });
                relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme5.26
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        DashboardActivityTheme5.this.clicktype = "5";
                        PopupMenu popupMenu = new PopupMenu(context, DashboardActivityTheme5.this.subjectspinner, 3);
                        popupMenu.getMenu().add("Select subject");
                        for (int i = 0; i < subjects.size(); i++) {
                            popupMenu.getMenu().add(((Subject) subjects.get(i)).getTitle());
                        }
                        popupMenu.setOnMenuItemClickListener(DashboardActivityTheme5.this);
                        popupMenu.show();
                    }
                });
                this.subjectspinner.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme5.27
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        DashboardActivityTheme5.this.clicktype = "5";
                        PopupMenu popupMenu = new PopupMenu(context, DashboardActivityTheme5.this.subjectspinner, 3);
                        popupMenu.getMenu().add("Select subject");
                        for (int i = 0; i < subjects.size(); i++) {
                            popupMenu.getMenu().add(((Subject) subjects.get(i)).getTitle());
                        }
                        popupMenu.setOnMenuItemClickListener(DashboardActivityTheme5.this);
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

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$38(Context context) {
        DashboardActivityTheme5 dashboardActivityTheme5;
        String str;
        if (this.SelectedSubjectid.equalsIgnoreCase("") && this.SelectedLaunguageid.equalsIgnoreCase("") && this.is_paid == null) {
            Toast.makeText(context, "Please select filter first", 0).show();
            return null;
        }
        if (!this.utkashRoom.getHomeApiStatusdata().isRecordExistsUserId(MakeMyExam.userId, this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id)) {
            dashboardActivityTheme5 = this;
        } else if (this.utkashRoom.getHomeApiStatusdata().getcoursedetail(this.mastercatid + "_" + this.allcatindex_id + "_" + this.allsubcatindex_id + "_" + this.contentType_id, MakeMyExam.getUserId()).getStatus().equalsIgnoreCase("true")) {
            this.isfilterapply = true;
            this.pagecount = 1;
            getCourseData(true);
            dashboardActivityTheme5 = this;
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
                Courselist courselist = new Courselist(courseDataTable.getCourse_id(), courseDataTable.getTitle(), courseDataTable.getCover_image(), courseDataTable.getMrp(), courseDataTable.getCourse_sp(), courseDataTable.getValidity(), courseDataTable.getSubject_id(), courseDataTable.getLang_id(), courseDataTable.getExtra_json());
                if (courselist.getExtra_json().getHome_screen() == null) {
                    this.courselists.add(courselist);
                } else if (courselist.getExtra_json().getHome_screen().equalsIgnoreCase("1")) {
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
            dashboardActivityTheme5 = this;
            TileDataAdapter tileDataAdapter = new TileDataAdapter(dashboardActivityTheme5, this.courselists, "", this, this);
            dashboardActivityTheme5.tileDataAdapter = tileDataAdapter;
            dashboardActivityTheme5.courseListRV.setAdapter(tileDataAdapter);
            dashboardActivityTheme5.courseListRV.setNestedScrollingEnabled(false);
        }
        BottomSheetDialog bottomSheetDialog = dashboardActivityTheme5.watchlist;
        if (bottomSheetDialog == null || !bottomSheetDialog.isShowing()) {
            return null;
        }
        dashboardActivityTheme5.watchlist.dismiss();
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
                            runOnUiThread(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda28
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$onRestart$39();
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
    public /* synthetic */ void lambda$onRestart$39() {
        this.cardsArrayList.clear();
        for (CourseTypeMasterTable courseTypeMasterTable : this.courseTypeMasterTables) {
            this.cardsArrayList.add(new Cards(courseTypeMasterTable.getId(), courseTypeMasterTable.getName(), com.clevertap.android.sdk.Constants.BLACK, courseTypeMasterTable.getName(), "0#0#0#0#0#0", "0"));
        }
        if (this.cardsArrayList.size() > 0) {
            getTileItems(this.cardsArrayList, 0);
        }
        selecteddata();
        automateViewPagerSwiping();
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
                        runOnUiThread(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$initialzehomepage$40();
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
    public /* synthetic */ void lambda$initialzehomepage$40() {
        this.cardsArrayList.clear();
        for (CourseTypeMasterTable courseTypeMasterTable : this.courseTypeMasterTables) {
            this.cardsArrayList.add(new Cards(courseTypeMasterTable.getId(), courseTypeMasterTable.getName(), com.clevertap.android.sdk.Constants.BLACK, courseTypeMasterTable.getName(), "0#0#0#0#0#0", "0"));
        }
        if (this.cardsArrayList.size() > 0) {
            getTileItems(this.cardsArrayList, 0);
        }
        selecteddata();
        automateViewPagerSwiping();
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
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.section_time);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.numQuesValueTV);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.sectionValueTV);
        final TextView textView5 = (TextView) viewInflate.findViewById(R.id.languageSpinnerTV);
        TextView textView6 = (TextView) viewInflate.findViewById(R.id.quizTimeValueTV);
        TextView textView7 = (TextView) viewInflate.findViewById(R.id.remarksTV);
        CheckBox checkBox2 = (CheckBox) viewInflate.findViewById(R.id.check_box);
        final TextView textView8 = (TextView) viewInflate.findViewById(R.id.generalInstrValueTV);
        Button button = (Button) viewInflate.findViewById(R.id.startQuizBtn);
        LinearLayout linearLayout2 = (LinearLayout) viewInflate.findViewById(R.id.sectionListLL);
        LinearLayout linearLayout3 = (LinearLayout) viewInflate.findViewById(R.id.general_layout);
        if (TextUtils.isEmpty(testBasic.getLang_id())) {
            dialog = dialog2;
        } else {
            dialog = dialog2;
            this.langIds = testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA);
        }
        if (testBasic.getTest_assets() != null) {
            checkBox = checkBox2;
            if (testBasic.getTest_assets().getHide_inst_time().equalsIgnoreCase("0")) {
                linearLayout.setVisibility(0);
            } else {
                linearLayout.setVisibility(4);
            }
        } else {
            checkBox = checkBox2;
        }
        addSectionView(linearLayout2, instructionData);
        if (SharedPreference.getInstance().getBoolean(Const.RE_ATTEMPT)) {
            textView7.setVisibility(8);
        } else {
            textView7.setVisibility(8);
        }
        if (testBasic.getMulti_description() != null && testBasic.getMulti_description().size() > 0) {
            linearLayout3.setVisibility(0);
            if (testBasic.getMulti_description().size() > 0) {
                textView8.setText(Html.fromHtml(testBasic.getMulti_description().get(0).getDescription()));
            }
        } else if (testBasic.getDescription().isEmpty()) {
            linearLayout3.setVisibility(8);
        } else {
            linearLayout3.setVisibility(0);
            textView8.setVisibility(0);
            textView8.setText(Html.fromHtml(testBasic.getDescription()));
        }
        if (!BuildConfig.FLAVOR.equalsIgnoreCase("mahendra")) {
            if (testBasic.getLang_id().length() > 1) {
                textView5.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme5.28
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        DashboardActivityTheme5 dashboardActivityTheme5 = DashboardActivityTheme5.this;
                        TextView textView9 = textView5;
                        TestBasicInst testBasicInst = testBasic;
                        TextView textView10 = textView8;
                        dashboardActivityTheme5.showPopMenuForLangauge(textView9, testBasicInst, textView10, textView10);
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
        }
        textView.setText(testBasic.getTestSeriesName());
        textView3.setText(testBasic.getTotalQuestions());
        textView6.setText(testBasic.getTimeInMins());
        textView2.setText(testBasic.getTotalMarks());
        if (testBasic.getDescription().isEmpty()) {
            i = 0;
        } else {
            i = 0;
            linearLayout3.setVisibility(0);
            textView8.setText(Html.fromHtml(testBasic.getDescription()));
        }
        button.setTag(testBasic);
        final Dialog dialog3 = dialog;
        final CheckBox checkBox3 = checkBox;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme5$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showPopUp$41(testBasic, checkBox3, dialog3, view);
            }
        });
        ArrayList arrayList = new ArrayList();
        int i2 = i;
        for (TestSectionInst testSectionInst : instructionData.getTestSections()) {
            if (!arrayList.isEmpty() && ((TestSectionInst) arrayList.get(i2 - 1)).getSectionId().equalsIgnoreCase(testSectionInst.getSectionId())) {
                arrayList.add(testSectionInst);
            } else {
                i++;
                arrayList.add(testSectionInst);
            }
            i2++;
        }
        textView4.setText("" + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPopUp$41(TestBasicInst testBasicInst, CheckBox checkBox, Dialog dialog, View view) {
        if (testBasicInst.getTotalQuestions().equalsIgnoreCase("0")) {
            Toast.makeText(this, getResources().getString(R.string.please_add_question), 0).show();
        } else {
            if (checkBox.isChecked()) {
                dialog.dismiss();
                this.quiz_id = testBasicInst.getId();
                new NetworkCall(this, this).NetworkAPICall(API.API_GET_INFO_TEST_SERIES, "", true, false);
                return;
            }
            Toast.makeText(this, getResources().getString(R.string.please_check_following_instructions), 0).show();
        }
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

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    private void automateViewPagerSwiping() {
        List<BannerListTable> list = this.bannerListTables;
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (BannerListTable bannerListTable : this.bannerListTables) {
            if (bannerListTable.getBanner_location().equalsIgnoreCase("0")) {
                arrayList.add(bannerListTable);
            }
            if (bannerListTable.getBanner_location().equalsIgnoreCase("4")) {
                this.seminarbannerlist.add(bannerListTable);
            }
        }
        if (this.seminarbannerlist.size() > 0) {
            this.seminarlayout.setVisibility(0);
            Glide.with((FragmentActivity) this).load(this.seminarbannerlist.get(0).getBanner_url()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.course_placeholder)).into(this.seminarbanner);
        } else {
            this.seminarlayout.setVisibility(8);
        }
        this.binding.dashBoardMain.bannerSliderLayout.viewPager2.setAdapter(new SliderAdapter(this, arrayList));
        Utils.INSTANCE.setUpViewPager(this.binding.dashBoardMain.bannerSliderLayout.viewPager2, this.binding.dashBoardMain.bannerSliderLayout.bannerIndicator, arrayList);
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

    @Override // com.appnew.android.Theme.Adapter.DashboardTabIconAdapter.addDashboardItemClicked
    public void onDashboardItemClicked(CourseTypeMasterTable courseTypeMasterTable, int position) {
        if (!courseTypeMasterTable.getCourse_id().equalsIgnoreCase("0")) {
            Intent intent = new Intent(this, (Class<?>) CourseActivity.class);
            intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
            intent.putExtra(Const.COURSE_ID_MAIN, courseTypeMasterTable.getCourse_id());
            intent.putExtra(Const.COURSE_PARENT_ID, "");
            intent.putExtra(Const.IS_COMBO, false);
            intent.putExtra(AnalyticsConstants.course_name, courseTypeMasterTable.getName());
            Helper.gotoActivity(intent, this);
            return;
        }
        Toast.makeText(homeactivity, "" + getResources().getString(R.string.course_not_attached), 0).show();
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
        Video video;
        Button button;
        Button button2;
        Video video2 = videoArrayList.get(0);
        View viewInflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.subjectivepopup, (ViewGroup) null, false);
        Dialog dialog = new Dialog(this, R.style.CustomAlertDialog);
        this.quizBasicInfoDialog = dialog;
        dialog.requestWindowFeature(1);
        this.quizBasicInfoDialog.setCanceledOnTouchOutside(true);
        this.quizBasicInfoDialog.setCancelable(true);
        this.quizBasicInfoDialog.setContentView(viewInflate);
        this.quizBasicInfoDialog.getWindow().setLayout(-1, -1);
        this.quizBasicInfoDialog.show();
        Constants.SUB_TEST_ID = videoArrayList.get(0).getId();
        TextView textView = (TextView) viewInflate.findViewById(R.id.ibt_single_sub_vd_tv_title);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.durationTV);
        Button button3 = (Button) viewInflate.findViewById(R.id.paper);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.ibt_single_sub_vd_iv);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.backimag);
        AppCompatTextView appCompatTextView = (AppCompatTextView) viewInflate.findViewById(R.id.test_name);
        final Button button4 = (Button) viewInflate.findViewById(R.id.upload);
        Button button5 = (Button) viewInflate.findViewById(R.id.booklet);
        Button button6 = (Button) viewInflate.findViewById(R.id.marks);
        if (!video2.getEnd_date().equalsIgnoreCase("0") && !video2.getEnd_date().equalsIgnoreCase("")) {
            textView2.setVisibility(0);
            video = video2;
            button = button6;
            button2 = button5;
            textView2.setText("Test Start: " + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.US).format(new Date(Long.parseLong(video2.getStart_date()) * 1000))) + "\nTest End: " + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.US).format(new Date(Long.parseLong(video.getEnd_date()) * 1000))));
        } else {
            video = video2;
            button = button6;
            button2 = button5;
            textView2.setVisibility(8);
        }
        appCompatTextView.setText(video.getTest_series_name());
        textView.setText(video.getTest_series_name());
        if (video.getAttempt().equalsIgnoreCase("0")) {
            button4.setText("Upload");
        } else {
            button4.setText("View");
        }
        if (video.getImage() == null || video.getImage().equalsIgnoreCase("")) {
            imageView.setImageResource(R.mipmap.square_placeholder);
        } else {
            Helper.setThumbnailImage(this, video.getImage(), getDrawable(R.mipmap.square_placeholder), imageView);
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme5.29
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DashboardActivityTheme5.this.quizBasicInfoDialog.isShowing()) {
                    DashboardActivityTheme5.this.quizBasicInfoDialog.dismiss();
                    DashboardActivityTheme5.this.initialzehomepage();
                }
            }
        });
        final Video video3 = video;
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme5.30
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (System.currentTimeMillis() < Long.parseLong(video3.getStart_date()) * 1000) {
                    Toast.makeText(DashboardActivityTheme5.this, "Test will start on " + new SimpleDateFormat("dd/MM/yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video3.getStart_date()) * 1000)), 0).show();
                    return;
                }
                if (!Helper.isConnected(this)) {
                    Toast.makeText(this, "No Internet Connection", 0).show();
                    return;
                }
                if (video3.getIs_locked().equalsIgnoreCase("1")) {
                    if (DashboardActivityTheme5.this.parentid == null || DashboardActivityTheme5.this.parentid.equalsIgnoreCase("")) {
                        Intent intent = new Intent(DashboardActivityTheme5.this, (Class<?>) CourseActivity.class);
                        intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                        intent.putExtra(Const.COURSE_ID_MAIN, video3.getPayloadData().getCourse_id());
                        intent.putExtra(Const.COURSE_PARENT_ID, "");
                        intent.putExtra(Const.IS_COMBO, false);
                        SharedPreference.getInstance().putString("id", video3.getPayloadData().getCourse_id());
                        DashboardActivityTheme5.this.startActivity(intent);
                        return;
                    }
                    Intent intent2 = new Intent(DashboardActivityTheme5.this, (Class<?>) CourseActivity.class);
                    intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent2.putExtra(Const.COURSE_ID_MAIN, DashboardActivityTheme5.this.parentid);
                    intent2.putExtra(Const.COURSE_PARENT_ID, "");
                    intent2.putExtra(Const.IS_COMBO, false);
                    SharedPreference.getInstance().putString("id", video3.getPayloadData().getCourse_id());
                    DashboardActivityTheme5.this.startActivity(intent2);
                    return;
                }
                if (!video3.getQuestion().equalsIgnoreCase("")) {
                    Constants.SUB_TEST_ID = video3.getId();
                    Helper.GoToWebViewPDFActivity(this, video3.getId(), video3.getQuestion(), true, video3.getQuestion().split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r11.length - 1].split("\\.")[0], DashboardActivityTheme5.this.course_id, video3.getIs_share());
                    return;
                }
                Toast.makeText(this, "File not found.", 0).show();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme5.31
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (button4.getText().toString().equalsIgnoreCase("View")) {
                    Intent intent = new Intent(this, (Class<?>) PdfDetailScreen.class);
                    intent.putExtra("url", video3.getAnswers_by_student());
                    this.startActivity(intent);
                    return;
                }
                if (System.currentTimeMillis() < Long.parseLong(video3.getStart_date()) * 1000) {
                    Toast.makeText(this, "Test will start on " + new SimpleDateFormat("dd/MM/yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video3.getStart_date()) * 1000)), 0).show();
                    return;
                }
                if (!Helper.isConnected(this)) {
                    Toast.makeText(this, "No Internet Connection", 0).show();
                    return;
                }
                if (video3.getIs_locked().equalsIgnoreCase("1")) {
                    if (DashboardActivityTheme5.this.parentid == null || DashboardActivityTheme5.this.parentid.equalsIgnoreCase("")) {
                        Intent intent2 = new Intent(DashboardActivityTheme5.this, (Class<?>) CourseActivity.class);
                        intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                        intent2.putExtra(Const.COURSE_ID_MAIN, video3.getPayloadData().getCourse_id());
                        intent2.putExtra(Const.COURSE_PARENT_ID, "");
                        intent2.putExtra(Const.IS_COMBO, false);
                        SharedPreference.getInstance().putString("id", video3.getPayloadData().getCourse_id());
                        DashboardActivityTheme5.this.startActivity(intent2);
                        return;
                    }
                    Intent intent3 = new Intent(DashboardActivityTheme5.this, (Class<?>) CourseActivity.class);
                    intent3.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent3.putExtra(Const.COURSE_ID_MAIN, DashboardActivityTheme5.this.parentid);
                    intent3.putExtra(Const.COURSE_PARENT_ID, "");
                    intent3.putExtra(Const.IS_COMBO, false);
                    SharedPreference.getInstance().putString("id", video3.getPayloadData().getCourse_id());
                    DashboardActivityTheme5.this.startActivity(intent3);
                    return;
                }
                Constants.SUB_TEST_ID = video3.getId();
                DashboardActivityTheme5.this.checkStoragePermission();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme5.32
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Long.parseLong(video3.getResult_date()) * 1000 < System.currentTimeMillis()) {
                    if (!Helper.isConnected(this)) {
                        Toast.makeText(this, "No Internet Connection", 0).show();
                        return;
                    }
                    if (video3.getIs_locked().equalsIgnoreCase("1")) {
                        if (DashboardActivityTheme5.this.parentid == null || DashboardActivityTheme5.this.parentid.equalsIgnoreCase("")) {
                            Intent intent = new Intent(DashboardActivityTheme5.this, (Class<?>) CourseActivity.class);
                            intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                            intent.putExtra(Const.COURSE_ID_MAIN, video3.getPayloadData().getCourse_id());
                            intent.putExtra(Const.COURSE_PARENT_ID, "");
                            intent.putExtra(Const.IS_COMBO, false);
                            SharedPreference.getInstance().putString("id", video3.getPayloadData().getCourse_id());
                            DashboardActivityTheme5.this.startActivity(intent);
                            return;
                        }
                        Intent intent2 = new Intent(DashboardActivityTheme5.this, (Class<?>) CourseActivity.class);
                        intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                        intent2.putExtra(Const.COURSE_ID_MAIN, DashboardActivityTheme5.this.parentid);
                        intent2.putExtra(Const.COURSE_PARENT_ID, "");
                        intent2.putExtra(Const.IS_COMBO, false);
                        SharedPreference.getInstance().putString("id", video3.getPayloadData().getCourse_id());
                        DashboardActivityTheme5.this.startActivity(intent2);
                        return;
                    }
                    if (!video3.getAnswers().equalsIgnoreCase("")) {
                        Constants.SUB_TEST_ID = video3.getId();
                        Helper.GoToWebViewPDFActivity(this, video3.getId(), video3.getAnswers(), true, video3.getAnswers().split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r11.length - 1].split("\\.")[0], DashboardActivityTheme5.this.course_id, video3.getIs_share());
                        return;
                    }
                    Toast.makeText(this, "File Not found.", 0).show();
                    return;
                }
                Toast.makeText(this, "Result will be available on " + new SimpleDateFormat("dd/MM/yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video3.getResult_date()) * 1000)), 0).show();
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme5.33
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Long.parseLong(video3.getResult_date()) * 1000 < System.currentTimeMillis()) {
                    if (!Helper.isConnected(this)) {
                        Toast.makeText(this, "No Internet Connection", 0).show();
                        return;
                    }
                    if (video3.getIs_locked().equalsIgnoreCase("1")) {
                        if (DashboardActivityTheme5.this.parentid == null || DashboardActivityTheme5.this.parentid.equalsIgnoreCase("")) {
                            Intent intent = new Intent(DashboardActivityTheme5.this, (Class<?>) CourseActivity.class);
                            intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                            intent.putExtra(Const.COURSE_ID_MAIN, video3.getPayloadData().getCourse_id());
                            intent.putExtra(Const.COURSE_PARENT_ID, "");
                            intent.putExtra(Const.IS_COMBO, false);
                            SharedPreference.getInstance().putString("id", video3.getPayloadData().getCourse_id());
                            DashboardActivityTheme5.this.startActivity(intent);
                            return;
                        }
                        Intent intent2 = new Intent(DashboardActivityTheme5.this, (Class<?>) CourseActivity.class);
                        intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                        intent2.putExtra(Const.COURSE_ID_MAIN, DashboardActivityTheme5.this.parentid);
                        intent2.putExtra(Const.COURSE_PARENT_ID, "");
                        intent2.putExtra(Const.IS_COMBO, false);
                        SharedPreference.getInstance().putString("id", video3.getPayloadData().getCourse_id());
                        DashboardActivityTheme5.this.startActivity(intent2);
                        return;
                    }
                    Constants.SUB_TEST_ID = video3.getTest_code();
                    Helper.GoToSubjectiveResultActivity(this, video3.getSolutions(), video3.getTest_series_name(), DashboardActivityTheme5.this.course_id, video3.getId(), DashboardActivityTheme5.this.tiletype);
                    return;
                }
                Toast.makeText(this, "Result will be available on " + new SimpleDateFormat("dd/MM/yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video3.getResult_date()) * 1000)), 0).show();
            }
        });
        this.quizBasicInfoDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme5.34
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialog2, int keyCode, KeyEvent event) {
                if (keyCode != 4) {
                    return true;
                }
                DashboardActivityTheme5.this.initialzehomepage();
                DashboardActivityTheme5.this.quizBasicInfoDialog.dismiss();
                return true;
            }
        });
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
