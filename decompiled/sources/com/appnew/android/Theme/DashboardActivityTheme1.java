package com.appnew.android.Theme;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteFullException;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.PopupMenu;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.window.core.layout.WindowSizeClass;
import com.appnew.android.ApiUpdate;
import com.appnew.android.BuildConfig;
import com.appnew.android.Cart.Activity.CartItemsActivity;
import com.appnew.android.Coupon.Activity.CouponActivity;
import com.appnew.android.CourseChat.CoursesListActivity;
import com.appnew.android.CourseTransfer.CourseTransferActivity;
import com.appnew.android.Courses.Activity.Concept_newActivity;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.Courses.Activity.PdfDetailScreen;
import com.appnew.android.Courses.Activity.QuizActivity;
import com.appnew.android.Courses.Activity.SearchActivity;
import com.appnew.android.Courses.Fragment.SingleStudy;
import com.appnew.android.CreateTest.Activity.CreateTestActivity;
import com.appnew.android.CustomPayment.CustomPaymentActivity;
import com.appnew.android.Download.DownloadActivity;
import com.appnew.android.Download.DownloadVideoPlayer;
import com.appnew.android.Educator.EducatorsActivity;
import com.appnew.android.Educator.adpter.HomeEduAdapter;
import com.appnew.android.Educator.adpter.HomeLCAdapter;
import com.appnew.android.Educator.adpter.HomeStdFeedAdapter;
import com.appnew.android.Educator.adpter.HomeTCAdapter;
import com.appnew.android.Educator.model.HomeLiveClassItem;
import com.appnew.android.Educator.model.HomeTrendingClassItem;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.ExtraClass.Activity.ExtraClassesActivity;
import com.appnew.android.FacebookEventLogger;
import com.appnew.android.Intro.Activity.CategoryActivity;
import com.appnew.android.Intro.Activity.IntroActivity;
import com.appnew.android.LiveClass.Activity.LiveClassActivity;
import com.appnew.android.LiveClass.interface_.OnDataSendListener;
import com.appnew.android.LiveTest.Activity.LivetestActivity;
import com.appnew.android.Model.BottomMenu;
import com.appnew.android.Model.BottomSetting;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Model.DivisionModel.DivisionModel;
import com.appnew.android.Model.Educator.EducatorsModel;
import com.appnew.android.Model.ExpiredEmiModel;
import com.appnew.android.Model.LeftMenu;
import com.appnew.android.Model.SocialIconModel;
import com.appnew.android.Model.Testimonial.TestimonialModel;
import com.appnew.android.Model.Video;
import com.appnew.android.Model.ZoomModel.ReviewData;
import com.appnew.android.Notification.Notification;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Payment.PaymentGatewayListener;
import com.appnew.android.Profile.ProfileActivity;
import com.appnew.android.PurchaseHistory.PurchaseHistory;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.TeacherTimeTable.Activity.Noticeboard;
import com.appnew.android.TeacherTimeTable.TimeTableActivity;
import com.appnew.android.TestRegisteration.TestReportActivity;
import com.appnew.android.Theme.Adapter.BannerAdapter;
import com.appnew.android.Theme.Adapter.BottomSliderAdapter;
import com.appnew.android.Theme.Adapter.DailyPollAdapter;
import com.appnew.android.Theme.Adapter.DashboardRectTileTabAdapter;
import com.appnew.android.Theme.Adapter.DashboardSquareTileTabAdapter;
import com.appnew.android.Theme.Adapter.DashboardTabAdapter;
import com.appnew.android.Theme.Adapter.ReviewSliderAdapter;
import com.appnew.android.Theme.Adapter.SliderAdapter;
import com.appnew.android.Theme.Adapter.SocialIconAdapter;
import com.appnew.android.UserHistory.ContactUsPage;
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
import com.appnew.android.Utils.PreferencesUtil;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.ZoomFeatureHelper;
import com.appnew.android.Webview.WebViewActivty;
import com.appnew.android.Webview.WebViewActivtyNew;
import com.appnew.android.Zoom.Activity.BookMarkList;
import com.appnew.android.Zoom.Activity.CurrentAffairActivity;
import com.appnew.android.Zoom.Activity.CurrentAffairInfoActivity;
import com.appnew.android.Zoom.Activity.DoubtsActivity;
import com.appnew.android.Zoom.Activity.DownloadPDFActivity;
import com.appnew.android.Zoom.Activity.FAQActivity;
import com.appnew.android.Zoom.Activity.Suggestion;
import com.appnew.android.Zoom.Activity.ZoomRecodedPlayer;
import com.appnew.android.Zoom.ScannerActivity;
import com.appnew.android.base.ChangeLanguageActivity;
import com.appnew.android.cleverTap.AnalyticHelper;
import com.appnew.android.databinding.ActivityDashboardBinding;
import com.appnew.android.databinding.AppBarDashboardBinding;
import com.appnew.android.feeds.activity.FeedsActivity;
import com.appnew.android.feeds.adapters.FeedViewPagerAdapter;
import com.appnew.android.home.Activity.CourseTypeActivity;
import com.appnew.android.home.Activity.HomeActivity;
import com.appnew.android.home.Activity.MyLibraryActivty;
import com.appnew.android.home.Activity.SettingsActivity;
import com.appnew.android.home.Constants;
import com.appnew.android.home.adapters.LeftNavAdapter;
import com.appnew.android.home.adapters.TileItemsAdapterSubCat;
import com.appnew.android.home.liveclasses.Datum;
import com.appnew.android.home.liveclasses.LiveClassesData;
import com.appnew.android.home.model.Menu;
import com.appnew.android.loginRevamp.Fragment.SelectDivisionClassFragment;
import com.appnew.android.pendingPurchase.PendingPurchaseBanner;
import com.appnew.android.player.AudioPlayerActivity;
import com.appnew.android.player.LiveStreamingYoutube;
import com.appnew.android.player.Liveawsactivity;
import com.appnew.android.player.VODPlayerActivity;
import com.appnew.android.player.music_player.MusicService;
import com.appnew.android.player.music_player.Utils;
import com.appnew.android.pojo.Userinfo.Data;
import com.appnew.android.table.AudioTable;
import com.appnew.android.table.BannerListTable;
import com.appnew.android.table.BottomMenuTable;
import com.appnew.android.table.CourseTypeMasterTable;
import com.appnew.android.table.LanguagesTable;
import com.appnew.android.table.MasteAllCatTable;
import com.appnew.android.table.MasterCat;
import com.appnew.android.table.TestTable;
import com.appnew.android.table.ThemeSettings;
import com.appnew.android.table.VideoTable;
import com.appnew.android.table.VideosDownload;
import com.appnew.android.testmodule.activity.TestBaseActivity;
import com.appnew.android.testmodule.model.InstructionData;
import com.appnew.android.testmodule.model.TestBasicInst;
import com.appnew.android.testmodule.model.TestSectionInst;
import com.appnew.android.testmodulessc.TestBaseActivitySSCPattern;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.clevertap.android.sdk.product_config.CTProductConfigConstants;
import com.eduteria.app.app.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.snackbar.Snackbar;
import com.google.common.base.Ascii;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.razorpay.PaymentResultListener;
import com.tv9news.utils.helpers.AnalyticEvents;
import com.tv9news.utils.helpers.AnalyticsConstants;
import cz.msebera.android.httpclient.protocol.HTTP;
import de.hdodenhof.circleimageview.CircleImageView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Timer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import me.leolin.shortcutbadger.ShortcutBadger;
import org.bouncycastle.pqc.crypto.newhope.NewHope;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class DashboardActivityTheme1 extends AppCompatActivity implements NetworkCall.MyNetworkCallBack, DashboardTabAdapter.addDashboardItemClicked, SliderAdapter.BannerClick, HomeEduAdapter.onEducatorClickListener, HomeLCAdapter.onCardClickListener, DailyPollAdapter.DailyPollSubmitCallBack, PaymentGatewayListener, PaymentResultListener, OnDataSendListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "com.appnew.android.Theme.DashboardActivityTheme1";
    public static Activity homeactivitytheme1;
    private AudioTable audioTable;
    private BannerAdapter bannerAdapter;
    public ActivityDashboardBinding binding;
    BottomMenu bottomMenu;
    BottomSetting bottomSetting;
    List<ExpiredEmiModel> courseArrayLists;
    String currentLang;
    DashboardRectTileTabAdapter dashboardRectTileTabAdapter;
    DashboardSquareTileTabAdapter dashboardSquareTileTabAdapter;
    DashboardTabAdapter dashboardTabAdapter;
    Data data;
    private DatabaseReference databaseReference;
    LinearLayout educatorListLL;
    private LinearLayout educatorsLiveClassLay;
    RecyclerView emiRecyclerView;
    List<ExpiredEmiModel> filteredArraylist;
    GridLayoutManager gridLayoutManager;
    private HomeEduAdapter homeEduAdapter;
    private HomeLCAdapter homeLCAdapter;
    private HomeStdFeedAdapter homeStdFeedAdapter;
    private HomeTCAdapter homeTCAdapter;
    private ArrayList<HomeTrendingClassItem> homeTrendingClassItemsList;
    int lang;
    LeftMenu leftMenu;
    ChildEventListener liveClassListener;
    LiveClassesData liveClasses;
    private RecyclerView liveClassesRecyclerView;
    List<ExpiredEmiModel> localCancelledEmi;
    Locale myLocale;
    NetworkCall networkCall;
    int notification_code;
    private String optionIndex;
    private RecyclerView ourEducatorsRecyclerView;
    private String poll_id;
    private Dialog quizBasicInfoDialog;
    ReviewData reviewData;
    int sns_notification_code;
    private LinearLayout socialIconLLAM;
    private RecyclerView studentFeedbackRecyclerView;
    LinearLayout testimonialLL;
    ActionBarDrawerToggle toggle;
    private RecyclerView trendingCourseRecyclerView;
    private LinearLayout trending_courseLL;
    EditText updateEmail_edt;
    UtkashRoom utkashRoom;
    Video video;
    private Video videodata;
    TextView viewAllClasses;
    List<CourseTypeMasterTable> courseTypeMasterRecyclerData = new ArrayList();
    List<CourseTypeMasterTable> courseTypeMasterRecyclerData1 = new ArrayList();
    List<BannerListTable> bannerListTables = new ArrayList();
    boolean isUserRewiewed = false;
    List<BottomMenuTable> bottomMenuTables = new ArrayList();
    private List<CourseTypeMasterTable> courseTypeMasterTables = new ArrayList();
    List<MasteAllCatTable> masterAllCatTables = new ArrayList();
    List<LanguagesTable> LanguagesTable = new ArrayList();
    List<MasterCat> mastercatlist = new ArrayList();
    private Timer timer = new Timer();
    String currentLanguage = Const.ENGLISH;
    String course_id = "";
    String rating = "";
    String ratingMessage = "";
    String fieldid = "";
    String id = "";
    long ts = 0;
    String coupon_for = "";
    String topicid = "";
    String video_type = "";
    String tiletype = "";
    String tileid = "";
    String revertapi = "";
    String type = "";
    String title = "";
    String snsTitle = "";
    String snsMessage = "";
    String url = "";
    String imageUrl = "";
    String message_target = "";
    String message = "";
    String parentid = "";
    String folder_id = "";
    String folderContentType = "";
    String combo_id = "";
    private boolean backstatus = false;
    private boolean isFeedsClicked = false;
    long backPressed = 0;
    public String contentType = "0";
    String testname = "";
    String post_id = "";
    String status_free = "";
    String greetingTiming = "";
    String name = "";
    String mPhoneNumber = "";
    String testquestion = "";
    private String quiz_id = "";
    String first_attempt = "";
    String result_date = "";
    String submition_type = "";
    int currentHour = 0;
    int currentHour1 = 0;
    int check = SharedPreference.getInstance().getInt(Const.LANGUAGE);
    ArrayList<View> viewArrayList = new ArrayList<>();
    String currentTime = "";
    String solutions = "";
    String test_series_name = "";
    String test_series_date = "";
    boolean hitMaster = true;
    String book_store_link = "";
    private boolean isBookStore = false;
    private String test_id = "";
    private ArrayList<Datum> liveClassesDataArrayList = new ArrayList<>();
    private ArrayList<EducatorsModel.Datum> educatorsList = new ArrayList<>();
    private ArrayList<TestimonialModel.Data.Testimonial> testimonialList = new ArrayList<>();
    boolean ispaginationavailable = false;
    boolean pullrefresh = false;
    boolean isfilterapply = false;
    private int pagecount = 1;
    ArrayList<Courselist> courselists = new ArrayList<>();
    public String contentType_id = "0";
    String mastercatname = "";
    String mastercatid = "";
    String allcatindex = "";
    String allcatindex_id = "";
    String allsubcatindex_id = "";
    boolean expanded = false;
    final Utils.FeedbackBottomSheetDialog[] feedbackDialog = new Utils.FeedbackBottomSheetDialog[1];
    private boolean isBottomSheetOpen = false;
    private String courseId = "";
    private int rating_type = 0;
    private String live_class_feedback = "";
    private String live_test_feedback = "";
    public View.OnClickListener onClickListener = new AnonymousClass2();
    public boolean isWebViewOpened = false;
    private int STORAGE_PERMISSION_TYPE = 3;
    public final int REQUEST_CODE_MULTIPLE_PIKER = 1203;
    String[] langIds = {"1"};
    private boolean isLiveApiInProgress = false;

    public LinearLayout initBottomView(Menu menu) {
        LinearLayout linearLayout = (LinearLayout) View.inflate(this, R.layout.bottom_item, null);
        TextView textView = (TextView) linearLayout.findViewById(R.id.title);
        final ImageView imageView = (ImageView) linearLayout.findViewById(R.id.icon);
        textView.setText(menu.getName());
        Glide.with((FragmentActivity) this).asBitmap().load(menu.getImageUrl()).into(new CustomTarget<Bitmap>() { // from class: com.appnew.android.Theme.DashboardActivityTheme1.1
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

    /* JADX INFO: renamed from: com.appnew.android.Theme.DashboardActivityTheme1$2, reason: invalid class name */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:233:0x0571, code lost:
        
            continue;
         */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onClick(android.view.View r20) {
            /*
                Method dump skipped, instruction units count: 1608
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Theme.DashboardActivityTheme1.AnonymousClass2.onClick(android.view.View):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onClick$0(View view) {
            DashboardActivityTheme1.this.isFeedsClicked = false;
            DashboardActivityTheme1.this.binding.dashBoardMain.scrollView.setVisibility(0);
            DashboardActivityTheme1.this.binding.dashBoardMain.feedsLl.setVisibility(8);
            DashboardActivityTheme1.this.toggle.setDrawerIndicatorEnabled(true);
            DashboardActivityTheme1.this.binding.dashBoardMain.homeBackIV.setVisibility(8);
            DashboardActivityTheme1.this.binding.dashBoardMain.cvrHeaderKrantikari.setVisibility(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onClick$4(Bundle bundle, CourseTypeMasterTable courseTypeMasterTable) {
            bundle.putString("course_id", courseTypeMasterTable.getCourse_id());
            bundle.putString(Const.TAB_ID, courseTypeMasterTable.getId());
            bundle.putString(Const.TAB_NAME, courseTypeMasterTable.getName());
            bundle.putString(Const.MASTER_CATEGORY_ID, courseTypeMasterTable.getMaster_category_id());
            bundle.putString("searchenable", courseTypeMasterTable.getDisplay_type());
            if (!GenericUtils.isListEmpty(DashboardActivityTheme1.this.courseTypeMasterTables) && !GenericUtils.isEmpty(courseTypeMasterTable.getCat_type())) {
                bundle.putString(Const.IS_BOOK, courseTypeMasterTable.getCat_type());
            } else {
                bundle.putString(Const.IS_BOOK, "0");
            }
            if (!GenericUtils.isListEmpty(DashboardActivityTheme1.this.mastercatlist)) {
                final String master_category_id = courseTypeMasterTable.getMaster_category_id();
                List list = (List) DashboardActivityTheme1.this.masterAllCatTables.stream().filter(new Predicate() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$2$$ExternalSyntheticLambda3
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return ((MasteAllCatTable) obj).getMaster_type().equals(master_category_id);
                    }
                }).filter(new Predicate() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$2$$ExternalSyntheticLambda4
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return ((MasteAllCatTable) obj).getParent_id().equals("0");
                    }
                }).collect(Collectors.toList());
                if (!list.isEmpty()) {
                    MakeMyExam.setTileData(new Gson().toJson(list));
                }
                if (DashboardActivityTheme1.this.masterAllCatTables != null && DashboardActivityTheme1.this.masterAllCatTables.size() > 0) {
                    MakeMyExam.setTileData2(new Gson().toJson(DashboardActivityTheme1.this.masterAllCatTables));
                }
            }
            if (Arrays.asList("1", "2").contains(courseTypeMasterTable.getDisplay_type())) {
                DashboardActivityTheme1.this.startActivity(new Intent(DashboardActivityTheme1.this, (Class<?>) CourseTypeActivity.class).putExtras(bundle));
                Helper.firebaseAnalytics(DashboardActivityTheme1.this, courseTypeMasterTable.getName(), "Book", "NA", "NA", "NA", "NA", "Book");
            } else {
                DashboardActivityTheme1.this.startActivity(new Intent(DashboardActivityTheme1.this, (Class<?>) HomeActivity.class).putExtras(bundle));
            }
            DashboardActivityTheme1.this.overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openLink(Menu menu) {
        if (menu.getType_code() == null || menu.getType_code().equalsIgnoreCase("")) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) WebViewActivty.class);
        intent.putExtra("url", menu.getType_code());
        intent.putExtra("title", menu.getName());
        intent.putExtra("file_type", "");
        startActivity(intent);
    }

    public void addFragment(Fragment fragment) {
        this.binding.dashBoardMain.container.setVisibility(0);
        this.binding.dashBoardMain.cvrHeaderKrantikari.setVisibility(8);
        this.binding.dashBoardMain.dashboardToolbar.setVisibility(8);
        this.binding.dashBoardMain.otherMainLayout.setVisibility(8);
        this.binding.dashBoardMain.scrollView.setFillViewport(true);
        UtkashRoom utkashRoom = this.utkashRoom;
        if (utkashRoom != null && utkashRoom.getthemeSettingdao() != null && this.utkashRoom.getthemeSettingdao().is_setting_exit()) {
            this.bottomSetting = (BottomSetting) new Gson().fromJson(this.utkashRoom.getthemeSettingdao().data().getBottom(), BottomSetting.class);
            List<BottomMenuTable> list = this.bottomMenuTables;
            if (list != null && list.size() > 0) {
                this.binding.dashBoardMain.bottomMenu.bottomLL.removeAllViews();
                ArrayList<View> arrayList = this.viewArrayList;
                if (arrayList != null) {
                    arrayList.clear();
                }
                for (int i = 0; i < Helper.getBottomMenu(this.bottomMenuTables).size(); i++) {
                    this.binding.dashBoardMain.bottomMenu.bottomLL.addView(initBottomView(Helper.getBottomMenu(this.bottomMenuTables).get(i)));
                }
            }
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).addToBackStack(fragment.getClass().getSimpleName()).commit();
    }

    public void replaceFragment(Fragment fragment) {
        this.isWebViewOpened = true;
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).addToBackStack(fragment.getClass().getSimpleName()).commit();
    }

    private void bindControls() {
        this.binding.dashBoardMain.contactUsLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme1.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DashboardActivityTheme1.this.openWhatsapp();
            }
        });
        ((AppBarDashboardBinding) Objects.requireNonNull(this.binding.dashBoardMain)).myLibrary.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$bindControls$0();
            }
        }));
        ((AppBarDashboardBinding) Objects.requireNonNull(this.binding.dashBoardMain)).CourseLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$bindControls$1();
            }
        }));
        ((AppBarDashboardBinding) Objects.requireNonNull(this.binding.dashBoardMain)).libLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$bindControls$2();
            }
        }));
        this.binding.dashBoardMain.cartLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$bindControls$3(view);
            }
        });
        this.binding.dashBoardMain.testLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$bindControls$4();
            }
        }));
        ((LinearLayout) Objects.requireNonNull(this.binding.navHeaderLL)).setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$bindControls$5();
            }
        }));
        this.binding.dashBoardMain.liveclass.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$bindControls$6();
            }
        }));
        this.binding.dashBoardMain.livetest.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$bindControls$7();
            }
        }));
        this.binding.dashBoardMain.profileLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$bindControls$8(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$bindControls$0() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, (Class<?>) MyLibraryActivty.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$bindControls$1() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
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
        if (this.courseTypeMasterTables.size() > 1) {
            bundle.putString(Const.TAB_ID, this.courseTypeMasterTables.get(0).getId());
        } else {
            bundle.putString(Const.TAB_ID, "1");
        }
        if (this.courseTypeMasterTables.size() > 1) {
            bundle.putString(Const.TAB_NAME, this.courseTypeMasterTables.get(0).getName());
        } else {
            bundle.putString(Const.TAB_NAME, "");
        }
        if (!GenericUtils.isListEmpty(this.courseTypeMasterTables) && !GenericUtils.isEmpty(this.courseTypeMasterTables.get(0).getMaster_category_id())) {
            bundle.putString(Const.MASTER_CATEGORY_ID, this.courseTypeMasterTables.get(0).getMaster_category_id());
        } else {
            bundle.putString(Const.MASTER_CATEGORY_ID, "0");
        }
        startActivity(new Intent(this, (Class<?>) HomeActivity.class).putExtras(bundle));
        overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$bindControls$2() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, (Class<?>) MyLibraryActivty.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindControls$3(View view) {
        Helper.gotoActivityForResult(new Intent(this, (Class<?>) DownloadActivity.class), this, 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$bindControls$4() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, CreateTestActivity.class, "1");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$bindControls$5() {
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
    public /* synthetic */ Unit lambda$bindControls$6() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, (Class<?>) LiveClassActivity.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$bindControls$7() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Intent intent = new Intent(this, (Class<?>) LivetestActivity.class);
        intent.putExtra("title", this.binding.dashBoardMain.liveTestTV.getText().toString().trim());
        startActivity(intent);
        overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindControls$8(View view) {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
        } else {
            Helper.gotoActivity(this, (Class<?>) Notification.class);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        ThemeSettings themeSettingsData;
        super.onCreate(savedInstanceState);
        Helper.enableScreenShot(this);
        Helper.setSystemBarLight(this);
        FacebookEventLogger.logFbSdkInitialize(this);
        this.binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        this.utkashRoom = UtkashRoom.getAppDatabase(this);
        homeactivitytheme1 = this;
        setContentView(this.binding.getRoot());
        SharedPreferences sharedPreferences = getSharedPreferences("MyPreferences", 0);
        final SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        Helper.setHeaderImage(this, this.binding.dashBoardMain.headerImg);
        Log.d("TAGNotificationClick", "onCreate");
        SharedPreference.getInstance().putString("theme_color_hai_bhai", null);
        this.data = SharedPreference.getInstance().getLoggedInUser();
        Constants.IS_FROM_LIBRARY = false;
        this.networkCall = new NetworkCall(this, this);
        if (SharedPreference.getInstance().getString(Const.SHOW_APP_REVIEW).equalsIgnoreCase("1")) {
            this.binding.dashBoardMain.reviewBannerSlider.parentCL.setVisibility(0);
            this.binding.dashBoardMain.reviewCard.setVisibility(0);
            this.binding.dashBoardMain.reviewLinear.setVisibility(0);
            this.binding.dashBoardMain.whatsappIcon.setVisibility(0);
            this.binding.dashBoardMain.socialIconLL1.setVisibility(0);
            if (sharedPreferences.getString(Const.RATING_MSG, null) != null && !sharedPreferences.getString(Const.RATING_MSG, null).equalsIgnoreCase("")) {
                this.binding.dashBoardMain.reviewTV.setText("View my Review");
            } else {
                this.binding.dashBoardMain.reviewTV.setText("Write a Review");
            }
            this.binding.dashBoardMain.reviewCard.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme1.4
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(DashboardActivityTheme1.this);
                    View viewInflate = LayoutInflater.from(DashboardActivityTheme1.this.getApplicationContext()).inflate(R.layout.bottom_review, (ViewGroup) null);
                    bottomSheetDialog.setCancelable(false);
                    CircleImageView circleImageView = (CircleImageView) viewInflate.findViewById(R.id.profileImg);
                    ImageView imageView = (ImageView) viewInflate.findViewById(R.id.crossBottomIMG);
                    final EditText editText = (EditText) viewInflate.findViewById(R.id.descriptionTv);
                    final RatingBar ratingBar = (RatingBar) viewInflate.findViewById(R.id.ratingBar);
                    TextView textView = (TextView) viewInflate.findViewById(R.id.titleTv);
                    CardView cardView = (CardView) viewInflate.findViewById(R.id.submitReview);
                    CardView cardView2 = (CardView) viewInflate.findViewById(R.id.cancelReview);
                    textView.setText(SharedPreference.getInstance().getLoggedInUser().getName());
                    Glide.with((FragmentActivity) DashboardActivityTheme1.this).load(SharedPreference.getInstance().getLoggedInUser().getProfilePicture()).into(circleImageView);
                    SharedPreferences sharedPreferences2 = DashboardActivityTheme1.this.getSharedPreferences("MyPreferences", 0);
                    String string = sharedPreferences2.getString(Const.RATING_MSG, null);
                    String string2 = sharedPreferences2.getString(Const.RATING_STAR, null);
                    if (string != null) {
                        editText.setText(string);
                        DashboardActivityTheme1.this.binding.dashBoardMain.reviewTV.setText("View my Review");
                    }
                    if (string2 != null) {
                        ratingBar.setRating(Float.parseFloat(string2));
                        DashboardActivityTheme1.this.binding.dashBoardMain.reviewTV.setText("View my Review");
                    }
                    editText.addTextChangedListener(new TextWatcher() { // from class: com.appnew.android.Theme.DashboardActivityTheme1.4.1
                        CharSequence previous;

                        @Override // android.text.TextWatcher
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        }

                        @Override // android.text.TextWatcher
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                        }

                        @Override // android.text.TextWatcher
                        public void afterTextChanged(Editable s) {
                            if (s.toString().contains("🤣")) {
                                editText.setText("");
                                return;
                            }
                            if (s.toString().contains("&")) {
                                editText.setText(s.toString().replace("&", "and "));
                                EditText editText2 = editText;
                                editText2.setSelection(editText2.getText().length());
                                return;
                            }
                            if (s.toString().contains("^")) {
                                editText.setText(s.toString().replace("^", " "));
                                EditText editText3 = editText;
                                editText3.setSelection(editText3.getText().length());
                                return;
                            }
                            if (s.toString().contains("$")) {
                                editText.setText(s.toString().replace("$", "dollar "));
                                EditText editText4 = editText;
                                editText4.setSelection(editText4.getText().length());
                                return;
                            }
                            if (s.toString().contains(MqttTopic.MULTI_LEVEL_WILDCARD)) {
                                editText.setText(s.toString().replace(MqttTopic.MULTI_LEVEL_WILDCARD, "hash "));
                                EditText editText5 = editText;
                                editText5.setSelection(editText5.getText().length());
                                return;
                            }
                            if (s.toString().contains(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
                                editText.setText(s.toString().replace(MqttTopic.TOPIC_LEVEL_SEPARATOR, " or"));
                                EditText editText6 = editText;
                                editText6.setSelection(editText6.getText().length());
                                return;
                            }
                            if (s.toString().contains("*")) {
                                editText.setText(s.toString().replace("*", "asterick "));
                                EditText editText7 = editText;
                                editText7.setSelection(editText7.getText().length());
                                return;
                            }
                            if (s.toString().contains("(")) {
                                editText.setText(s.toString().replace("(", "'open block' "));
                                EditText editText8 = editText;
                                editText8.setSelection(editText8.getText().length());
                                return;
                            }
                            if (s.toString().contains(")")) {
                                editText.setText(s.toString().replace(")", "'close block' "));
                                EditText editText9 = editText;
                                editText9.setSelection(editText9.getText().length());
                                return;
                            }
                            if (s.toString().contains(com.clevertap.android.sdk.Constants.AES_PREFIX)) {
                                editText.setText(s.toString().replace(com.clevertap.android.sdk.Constants.AES_PREFIX, "'open square block' "));
                                EditText editText10 = editText;
                                editText10.setSelection(editText10.getText().length());
                                return;
                            }
                            if (s.toString().contains(com.clevertap.android.sdk.Constants.AES_SUFFIX)) {
                                editText.setText(s.toString().replace(com.clevertap.android.sdk.Constants.AES_SUFFIX, "'close square block'"));
                                EditText editText11 = editText;
                                editText11.setSelection(editText11.getText().length());
                            }
                        }
                    });
                    cardView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme1.4.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View v2) {
                            DashboardActivityTheme1.this.ratingMessage = editText.getText().toString();
                            DashboardActivityTheme1.this.rating = String.valueOf(ratingBar.getRating());
                            editorEdit.putString(Const.RATING_MSG, DashboardActivityTheme1.this.ratingMessage);
                            editorEdit.putString(Const.RATING_STAR, DashboardActivityTheme1.this.rating);
                            editorEdit.apply();
                            if (!DashboardActivityTheme1.this.rating.equalsIgnoreCase(IdManager.DEFAULT_VERSION_NAME)) {
                                if (!DashboardActivityTheme1.this.ratingMessage.equalsIgnoreCase("")) {
                                    bottomSheetDialog.dismiss();
                                    DashboardActivityTheme1.this.binding.dashBoardMain.reviewTV.setText("View my Review");
                                    DashboardActivityTheme1.this.networkCall.NetworkAPICall(API.POST_COURSE_REVIEW, "", false, false);
                                    return;
                                }
                                Toast.makeText(DashboardActivityTheme1.this, "Please write your review.", 0).show();
                                return;
                            }
                            Toast.makeText(DashboardActivityTheme1.this, "Please insert your rating.", 0).show();
                        }
                    });
                    cardView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme1.4.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View v2) {
                            bottomSheetDialog.dismiss();
                        }
                    });
                    if (DashboardActivityTheme1.this.reviewData != null && DashboardActivityTheme1.this.reviewData.getId().equals(SharedPreference.getInstance().getLoggedInUser().getId())) {
                        DashboardActivityTheme1.this.isUserRewiewed = true;
                        if (DashboardActivityTheme1.this.isUserRewiewed) {
                            textView.setText(DashboardActivityTheme1.this.reviewData.getName());
                            editText.setText(DashboardActivityTheme1.this.reviewData.getMessage());
                            ratingBar.setRating(Float.parseFloat(DashboardActivityTheme1.this.reviewData.getRating()));
                        } else {
                            editText.setText("");
                        }
                    }
                    imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme1.4.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View v2) {
                            bottomSheetDialog.dismiss();
                        }
                    });
                    bottomSheetDialog.setContentView(viewInflate);
                    bottomSheetDialog.show();
                }
            });
            this.binding.dashBoardMain.whatsappIcon.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme1.5
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DashboardActivityTheme1.this.openWhatsapp();
                }
            });
        }
        try {
            if (SharedPreference.getInstance().getTestUser() != null && SharedPreference.getInstance().getTestUser().getMobile() != null && !SharedPreference.getInstance().getTestUser().getMobile().equalsIgnoreCase(SharedPreference.getInstance().getLoggedInUser().getMobile())) {
                SharedPreference.getInstance().ClearTestUser();
            }
        } catch (Exception unused) {
        }
        if (!logutuser()) {
            getBundledData();
            initView();
            this.currentHour1 = Calendar.getInstance().getTime().getHours();
            if (BuildConfig.FLAVOR.equalsIgnoreCase("targetonapp")) {
                int i = this.currentHour1;
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
            } else {
                int i2 = SharedPreference.getInstance().getInt(Const.CURRENT_HOUR);
                this.currentHour = i2;
                if (i2 < 12 && i2 >= 5) {
                    this.greetingTiming = "Good Morning,";
                } else if (i2 < 17 && i2 >= 12) {
                    this.greetingTiming = "Good Afternoon,";
                } else if (i2 < 20 && i2 >= 17) {
                    this.greetingTiming = "Good Evening,";
                } else if (i2 <= 24 && i2 >= 20) {
                    this.greetingTiming = "Good Night,";
                } else if (i2 < 5 && i2 >= 0) {
                    this.greetingTiming = "Good Night,";
                } else {
                    this.greetingTiming = "Hello";
                }
            }
            if (SharedPreference.getInstance().getString(Const.IS_CART).equalsIgnoreCase("1")) {
                this.binding.dashBoardMain.gotoCart.setVisibility(0);
                if (Helper.isTrishulThemeNew() || Helper.isIkipUI()) {
                    this.binding.dashBoardMain.relativeGotoCart.setVisibility(8);
                } else {
                    this.binding.dashBoardMain.relativeGotoCart.setVisibility(0);
                }
            } else if (Helper.isTrishulThemeNew()) {
                this.binding.dashBoardMain.cvrHeaderKrantikari.setBackground(null);
                this.binding.dashBoardMain.dashboardToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary, null));
                this.binding.dashBoardMain.greetingMsgTV.setTextColor(getResources().getColor(R.color.colorPrimary));
                ActionBar supportActionBar = getSupportActionBar();
                if (supportActionBar != null) {
                    Drawable drawable = getResources().getDrawable(R.drawable.toolbar_menu_ic, null);
                    if (drawable != null) {
                        drawable.setTint(getResources().getColor(R.color.white, null));
                        supportActionBar.setHomeAsUpIndicator(drawable);
                    }
                    supportActionBar.setDisplayHomeAsUpEnabled(true);
                }
            } else {
                this.binding.dashBoardMain.gotoCart.setVisibility(8);
                this.binding.dashBoardMain.relativeGotoCart.setVisibility(8);
            }
            if (SharedPreference.getInstance().getString(Const.SHOW_GREETING).equalsIgnoreCase("1")) {
                if (Helper.isTrishulThemeNew()) {
                    this.binding.dashBoardMain.cvrHeaderKrantikari.setBackground(null);
                    this.binding.dashBoardMain.dashboardToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary, null));
                    this.binding.dashBoardMain.greetingMsgTV.setTextColor(getResources().getColor(R.color.colorPrimary));
                    ActionBar supportActionBar2 = getSupportActionBar();
                    if (supportActionBar2 != null) {
                        Drawable drawable2 = getResources().getDrawable(R.drawable.toolbar_menu_ic, null);
                        if (drawable2 != null) {
                            drawable2.setTint(getResources().getColor(R.color.white, null));
                            supportActionBar2.setHomeAsUpIndicator(drawable2);
                        }
                        supportActionBar2.setDisplayHomeAsUpEnabled(true);
                    }
                } else if (Helper.isIkipUI()) {
                    if (SharedPreference.getInstance().getString(Const.SHOW_GREETING).equalsIgnoreCase("1")) {
                        this.binding.dashBoardMain.cvrHeaderKrantikari.setVisibility(0);
                        this.binding.dashBoardMain.greetingMsgLL.setVisibility(0);
                    }
                    if (BuildConfig.FLAVOR.equalsIgnoreCase("pateltutorial")) {
                        this.binding.dashBoardMain.dashboardToolbar.setBackgroundColor(getResources().getColor(R.color.primary_gray, null));
                    } else if (BuildConfig.FLAVOR.equalsIgnoreCase("Lawlegends")) {
                        this.binding.dashBoardMain.dashboardToolbar.setBackgroundResource(R.mipmap.header);
                    } else if (Helper.isToolbarBackgroundTrans()) {
                        this.binding.dashBoardMain.dashboardToolbar.setBackgroundColor(getResources().getColor(R.color.transparent, null));
                    }
                    this.binding.dashBoardMain.greetingMsgTV.setTextColor(getResources().getColor(R.color.colorPrimary));
                    this.binding.dashBoardMain.notificationIV.setImageDrawable(getResources().getDrawable(R.drawable.notification_black_ic, null));
                    if (Helper.isWindowsPrimary()) {
                        this.binding.dashBoardMain.notificationIV.setImageTintList(ContextCompat.getColorStateList(this, R.color.colorPrimary));
                    } else {
                        this.binding.dashBoardMain.notificationIV.setImageTintList(ContextCompat.getColorStateList(this, R.color.black));
                    }
                    ActionBar supportActionBar3 = getSupportActionBar();
                    if (supportActionBar3 != null) {
                        Drawable drawable3 = getResources().getDrawable(R.drawable.toolbar_menu_ic, null);
                        if (drawable3 != null) {
                            if (Helper.isWindowsPrimary()) {
                                drawable3.setTint(getResources().getColor(R.color.colorPrimary, null));
                            }
                            supportActionBar3.setHomeAsUpIndicator(drawable3);
                        }
                        supportActionBar3.setDisplayHomeAsUpEnabled(true);
                    }
                    Window window = getWindow();
                    window.addFlags(Integer.MIN_VALUE);
                    if (Helper.isWindowsPrimary()) {
                        window.clearFlags(67108864);
                    } else {
                        window.setStatusBarColor(ContextCompat.getColor(this, R.color.black));
                    }
                } else {
                    this.binding.dashBoardMain.greetingMsgLL.setVisibility(0);
                    this.binding.dashBoardMain.cvrHeaderKrantikari.setVisibility(0);
                    this.binding.dashBoardMain.dashboardToolbar.setBackgroundColor(getResources().getColor(R.color.transparent));
                    Window window2 = getWindow();
                    window2.addFlags(Integer.MIN_VALUE);
                    window2.clearFlags(67108864);
                    if (BuildConfig.FLAVOR.equalsIgnoreCase("patelsirclasses")) {
                        this.binding.dashBoardMain.dashboardToolbar.setBackgroundColor(getResources().getColor(R.color.rating_inactive, null));
                    } else {
                        this.binding.dashBoardMain.dashboardToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    }
                }
            } else if (Helper.isIkipUI()) {
                if (SharedPreference.getInstance().getString(Const.SHOW_GREETING).equalsIgnoreCase("1")) {
                    this.binding.dashBoardMain.cvrHeaderKrantikari.setVisibility(0);
                    this.binding.dashBoardMain.greetingMsgLL.setVisibility(0);
                }
                if (BuildConfig.FLAVOR.equalsIgnoreCase("pateltutorial")) {
                    this.binding.dashBoardMain.dashboardToolbar.setBackgroundColor(getResources().getColor(R.color.primary_gray, null));
                } else if (BuildConfig.FLAVOR.equalsIgnoreCase("Lawlegends")) {
                    this.binding.dashBoardMain.dashboardToolbar.setBackgroundResource(R.mipmap.header);
                } else if (BuildConfig.FLAVOR.equalsIgnoreCase("patelsirclasses")) {
                    this.binding.dashBoardMain.dashboardToolbar.setBackgroundColor(getResources().getColor(R.color.rating_inactive, null));
                } else if (Helper.isToolbarBackgroundTrans()) {
                    this.binding.dashBoardMain.dashboardToolbar.setBackgroundColor(getResources().getColor(R.color.transparent, null));
                } else {
                    this.binding.dashBoardMain.dashboardToolbar.setBackgroundColor(getResources().getColor(R.color.white, null));
                }
                this.binding.dashBoardMain.greetingMsgTV.setTextColor(getResources().getColor(R.color.colorPrimary));
                this.binding.dashBoardMain.notificationIV.setImageDrawable(getResources().getDrawable(R.drawable.notification_black_ic, null));
                if (Helper.isWindowsPrimary()) {
                    this.binding.dashBoardMain.notificationIV.setImageTintList(ContextCompat.getColorStateList(this, R.color.colorPrimary));
                } else {
                    this.binding.dashBoardMain.notificationIV.setImageTintList(ContextCompat.getColorStateList(this, R.color.black));
                }
                ActionBar supportActionBar4 = getSupportActionBar();
                if (supportActionBar4 != null) {
                    Drawable drawable4 = getResources().getDrawable(R.drawable.toolbar_menu_ic, null);
                    if (drawable4 != null) {
                        if (Helper.isWindowsPrimary()) {
                            drawable4.setTint(getResources().getColor(R.color.colorPrimary, null));
                        }
                        supportActionBar4.setHomeAsUpIndicator(drawable4);
                    }
                    supportActionBar4.setDisplayHomeAsUpEnabled(true);
                }
                Window window3 = getWindow();
                window3.addFlags(Integer.MIN_VALUE);
                if (Helper.isWindowsPrimary()) {
                    window3.clearFlags(67108864);
                } else {
                    window3.setStatusBarColor(ContextCompat.getColor(this, R.color.black));
                }
            } else {
                this.binding.dashBoardMain.dashboardToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
            if (SharedPreference.getInstance().getLoggedInUser().getName() != null && this.greetingTiming != null) {
                this.name = SharedPreference.getInstance().getLoggedInUser().getName();
                if (BuildConfig.FLAVOR.equalsIgnoreCase("Lawlegends")) {
                    this.binding.dashBoardMain.greetingMsgTV.setTextColor(getResources().getColor(R.color.colorPrimary));
                    this.binding.dashBoardMain.greetingMsgTV.setText(this.greetingTiming + "\n" + this.name + " !");
                } else if (BuildConfig.FLAVOR.equalsIgnoreCase("eliteExpertiseLearning")) {
                    this.binding.dashBoardMain.greetingMsgTV.setTextColor(getResources().getColor(R.color.black));
                    this.binding.dashBoardMain.greetingMsgTV.setText(this.greetingTiming + "\n" + this.name + " !");
                } else {
                    this.binding.dashBoardMain.greetingMsgTV.setText(this.greetingTiming + " " + this.name + " !");
                }
            }
            this.binding.dashBoardMain.notificationLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda33
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onCreate$9();
                }
            }));
            this.binding.dashBoardMain.searchIcon.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda34
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onCreate$10();
                }
            }));
            this.binding.dashBoardMain.gotoCart.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda35
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onCreate$11(view);
                }
            });
            hitInstallmentCheckApi();
            if (!Helper.isNetworkConnected(this) && this.utkashRoom.getthemeSettingdao().is_setting_exit() && (themeSettingsData = this.utkashRoom.getthemeSettingdao().data()) != null) {
                LeftMenu leftMenu = (LeftMenu) new Gson().fromJson(themeSettingsData.getLeft_menu(), LeftMenu.class);
                BottomMenu bottomMenu = (BottomMenu) new Gson().fromJson(themeSettingsData.getBottom(), BottomMenu.class);
                if ((leftMenu != null && leftMenu.getDownloads().equalsIgnoreCase("1")) || (bottomMenu != null && bottomMenu.getDownloads() != null && bottomMenu.getDownloads().equalsIgnoreCase("1"))) {
                    Helper.goToDownloadsOfflineMode(this);
                }
            }
            if (SharedPreference.getInstance().getString(Const.IS_RECENT_WATCH).equalsIgnoreCase("1")) {
                SharedPreference.getInstance().putString(Const.IS_RECENT_REFRESH, "");
                hitRecentWatchApi();
            }
        }
        setNewThemeFunction();
        if (BuildConfig.FLAVOR.equalsIgnoreCase("scoreBetter") && SharedPreference.getInstance().getBoolean("show_feeds")) {
            Data loggedInUser = SharedPreference.getInstance().getLoggedInUser();
            if (loggedInUser != null && loggedInUser.getPreferences() != null && loggedInUser.getPreferences().size() > 0) {
                Helper.gotoActivity(new Intent(this, (Class<?>) FeedsActivity.class), this);
            } else {
                Helper.gotoActivity(new Intent(this, (Class<?>) IntroActivity.class), this);
            }
        }
        if (BuildConfig.FLAVOR.equalsIgnoreCase("Narayana")) {
            new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme1.6
                @Override // java.lang.Runnable
                public void run() {
                    DashboardActivityTheme1.this.fetchCouponData();
                }
            }, 500L);
        }
        if (SharedPreference.getInstance().getString(Const.OTP_LOGIN).equalsIgnoreCase("1") && SharedPreference.getInstance().getString(Const.EMAIL_UPDATE_POPUP).equalsIgnoreCase("1") && SharedPreference.getInstance().getLoggedInUser().getEmail() != null && SharedPreference.getInstance().getLoggedInUser().getEmail().equalsIgnoreCase("")) {
            emailVerify();
        }
        if (SharedPreference.getInstance().getString(Const.SEARCH_ON_TOP).equalsIgnoreCase("1")) {
            this.binding.dashBoardMain.searchIcon.setVisibility(0);
        } else {
            this.binding.dashBoardMain.searchIcon.setVisibility(8);
        }
        setRankerGuruData();
        if (SharedPreference.getInstance().getString(Const.WHATSAPP_NOTIFICATION).equalsIgnoreCase("1")) {
            this.binding.dashBoardMain.whatsappIcon.setVisibility(0);
        } else {
            this.binding.dashBoardMain.whatsappIcon.setVisibility(8);
        }
        Helper.clearPollLoacalResultData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$9() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
        }
        Helper.gotoActivity(this, (Class<?>) Notification.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$10() {
        if (!Helper.isNetworkConnected(homeactivitytheme1)) {
            Helper.showInternetToast(homeactivitytheme1);
            return null;
        }
        Intent intent = new Intent(homeactivitytheme1, (Class<?>) SearchActivity.class);
        intent.putExtra("couse_type", "0");
        intent.putExtra("allsubcatindex", "1");
        startActivity(intent);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$11(View view) {
        Intent intent = new Intent(this, (Class<?>) CartItemsActivity.class);
        intent.putExtra("courseId", "mainCourseId");
        startActivity(intent);
    }

    private void mailAndPhone() {
        final String string = SharedPreference.getInstance().getString("contactus_email");
        final String string2 = SharedPreference.getInstance().getString(Const.CONTACTUS_MOBILE1);
        final String string3 = SharedPreference.getInstance().getString(Const.CONTACTUS_MOBILE2);
        if (!TextUtils.isEmpty(string) && !string.equalsIgnoreCase("")) {
            this.binding.dashBoardMain.mailIcon1.setVisibility(0);
            this.binding.dashBoardMain.mailIcon1.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda24
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$mailAndPhone$12(string, view);
                }
            });
        }
        if (TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3)) {
            return;
        }
        this.binding.dashBoardMain.phoneIcon1.setVisibility(0);
        this.binding.dashBoardMain.phoneIcon1.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda25
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$mailAndPhone$16(string3, string2, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$mailAndPhone$12(String str, View view) {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", str, null));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(intent, "Send email..."));
        } else {
            Toast.makeText(this, "No email client installed on your device", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$mailAndPhone$16(String str, String str2, View view) {
        int i = Calendar.getInstance().get(11);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (i >= 6) {
            builder.setTitle(getString(R.string.customer_support_select_title));
            if (!GenericUtils.isEmpty(str)) {
                if (!GenericUtils.isEmpty(str2)) {
                    final String[] strArr = {str2, str};
                    builder.setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda28
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            this.f$0.lambda$mailAndPhone$13(strArr, dialogInterface, i2);
                        }
                    });
                } else {
                    Toast.makeText(this, "First Mobile Number Not Found!", 0).show();
                }
            } else {
                final String[] strArr2 = {str2};
                builder.setItems(strArr2, new DialogInterface.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda29
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$mailAndPhone$14(strArr2, dialogInterface, i2);
                    }
                });
            }
        } else {
            builder.setMessage(getString(R.string.customer_support_message));
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda30
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
        }
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$mailAndPhone$13(String[] strArr, DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + strArr[i]));
        dialogInterface.dismiss();
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$mailAndPhone$14(String[] strArr, DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + strArr[i]));
        dialogInterface.dismiss();
        startActivity(intent);
    }

    private void setNewThemeFunction() {
        if (SharedPreference.getInstance().getString(Const.DASHBOARD_EDUCATORSECTION).equalsIgnoreCase("1")) {
            getEducators();
        }
        if (SharedPreference.getInstance().getString(Const.DASHBOARD_TESTIMONIAL).equalsIgnoreCase("1")) {
            getTestimonials(false);
        }
        if (SharedPreference.getInstance().getString(Const.DASHBOARD_WHATSAPP_BANNER).equalsIgnoreCase("1")) {
            this.binding.dashBoardMain.chatSupportRel.setVisibility(0);
        } else {
            this.binding.dashBoardMain.chatSupportRel.setVisibility(8);
        }
        if (SharedPreference.getInstance().getString(Const.DASHBOARD_SOCIALMEDIA_ICONS).equalsIgnoreCase("1")) {
            this.binding.dashBoardMain.socialIconLL1.setVisibility(0);
        } else {
            this.binding.dashBoardMain.socialIconLL1.setVisibility(8);
        }
        if (SharedPreference.getInstance().getString(Const.dashboard_TrendingCourses).equalsIgnoreCase("1")) {
            getMasterCatDate();
        }
        if (SharedPreference.getInstance().getString(Const.IS_DAILY_QUESTION).equalsIgnoreCase("1")) {
            hit_Api_for_daily_question();
        }
        this.binding.dashBoardMain.viewAllClasses.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme1.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DashboardActivityTheme1.this.startActivity(new Intent(DashboardActivityTheme1.this, (Class<?>) LiveClassActivity.class));
            }
        });
        this.binding.dashBoardMain.chatSupportHere.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme1.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                String[] strArr = new String[1];
                String string = SharedPreference.getInstance().getString(Const.CONTACTUS_MOBILE1);
                if (string != null && !string.equalsIgnoreCase("")) {
                    DashboardActivityTheme1.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://wa.me/" + string)));
                } else {
                    Toast.makeText(DashboardActivityTheme1.this, "Support is not available now...", 0).show();
                }
            }
        });
    }

    private void getMasterCatDate() {
        if (this.mastercatlist.size() > 0) {
            this.mastercatname = this.mastercatlist.get(0).getCat();
            this.mastercatid = this.mastercatlist.get(0).getId();
        }
    }

    private void setRankerGuruData() {
        LeftMenu leftMenu = this.leftMenu;
        if (leftMenu != null) {
            if ((Helper.isNullChek(leftMenu.getYoutube_link_data()) && this.leftMenu.getYoutube_link().equalsIgnoreCase("1")) || ((Helper.isNullChek(this.leftMenu.getLinkedin_link()) && this.leftMenu.getLinkedin_link().equalsIgnoreCase("1")) || ((Helper.isNullChek(this.leftMenu.getInstagram_link()) && this.leftMenu.getInstagram_link().equalsIgnoreCase("1")) || ((Helper.isNullChek(this.leftMenu.getWebsite()) && this.leftMenu.getWebsite().equalsIgnoreCase("1")) || ((Helper.isNullChek(this.leftMenu.getTelegram_link()) && this.leftMenu.getTelegram_link().equalsIgnoreCase("1")) || (Helper.isNullChek(this.leftMenu.getTwitter_link()) && this.leftMenu.getTwitter_link().equalsIgnoreCase("1"))))))) {
                this.binding.dashBoardMain.followLinear.setVisibility(0);
            }
        }
    }

    private void automateReviewPagerSwiping(List<ReviewData> reviewData) {
        this.binding.dashBoardMain.reviewBannerSlider.viewPager2.setAdapter(new ReviewSliderAdapter(this, reviewData));
        Utils.INSTANCE.setUpViewPager(this.binding.dashBoardMain.reviewBannerSlider.viewPager2, this.binding.dashBoardMain.reviewBannerSlider.bannerIndicator, reviewData);
    }

    private void setDefaultGreetingUi() {
        LinearLayout linearLayout = this.binding.dashBoardMain.greetingMsgLL;
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        layoutParams.height = -2;
        layoutParams.width = -2;
        linearLayout.setLayoutParams(layoutParams);
    }

    private void setAsPerGreetingUi() {
        LinearLayout linearLayout = this.binding.dashBoardMain.greetingMsgLL;
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        layoutParams.height = R.dimen.dp110;
        layoutParams.width = -2;
        linearLayout.setLayoutParams(layoutParams);
    }

    public void openWhatsapp() {
        String mobile_number = this.leftMenu.getMobile_number();
        this.mPhoneNumber = mobile_number;
        if (TextUtils.isEmpty(mobile_number) || this.mPhoneNumber.equalsIgnoreCase("0")) {
            return;
        }
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://wa.me/" + this.mPhoneNumber)));
    }

    public void callDialog() {
        if (SharedPreference.getInstance().getBoolean("showpopup")) {
            for (BannerListTable bannerListTable : this.bannerListTables) {
                if (bannerListTable.getBanner_location() != null && bannerListTable.getBanner_location().equalsIgnoreCase("2")) {
                    dialog_latest_popup(bannerListTable);
                    return;
                }
            }
        }
    }

    public void dialog_latest_popup(final BannerListTable bannerListTable) {
        pushEventForInApp("notification_delivered", bannerListTable);
        final Dialog dialog = new Dialog(homeactivitytheme1);
        dialog.setContentView(R.layout.dialog_latest_popup);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -2;
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        RelativeLayout relativeLayout = (RelativeLayout) dialog.findViewById(R.id.rl_dialog_latest_popup);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.iv_close);
        ImageView imageView2 = (ImageView) dialog.findViewById(R.id.iv_latest_image);
        ImageView imageView3 = (ImageView) dialog.findViewById(R.id.popUp_gif);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = (int) (displayMetrics.widthPixels - (displayMetrics.scaledDensity * 40.0f));
        if (bannerListTable != null && bannerListTable.getImage_type() != null && bannerListTable.getImage_type().equalsIgnoreCase("2")) {
            if (i > 600) {
                ViewGroup.LayoutParams layoutParams2 = relativeLayout.getLayoutParams();
                layoutParams2.width = 600;
                layoutParams2.height = (int) (((double) 600) * 1.5d);
                relativeLayout.setLayoutParams(layoutParams2);
            } else {
                ViewGroup.LayoutParams layoutParams3 = relativeLayout.getLayoutParams();
                layoutParams3.height = (int) (((double) i) * 1.5d);
                relativeLayout.setLayoutParams(layoutParams3);
            }
        }
        try {
            if (bannerListTable.getBanner_url().endsWith(".gif")) {
                imageView3.setVisibility(0);
                imageView2.setVisibility(8);
                Glide.with((FragmentActivity) this).load(bannerListTable.getBanner_url()).into(imageView3);
            } else {
                imageView3.setVisibility(8);
                imageView2.setVisibility(0);
                Glide.with((FragmentActivity) this).load(bannerListTable.getBanner_url()).into(imageView2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda26
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$dialog_latest_popup$17(bannerListTable, dialog, view);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda27
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$dialog_latest_popup$18(bannerListTable, dialog, view);
            }
        });
        layoutParams.gravity = 17;
        layoutParams.windowAnimations = R.style.videosheetDialogTheme;
        dialog.getWindow().setAttributes(layoutParams);
        dialog.show();
        SharedPreference.getInstance().putBoolean("showpopup", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dialog_latest_popup$17(BannerListTable bannerListTable, Dialog dialog, View view) {
        pushEventForInApp("notification_dismissed", bannerListTable);
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dialog_latest_popup$18(BannerListTable bannerListTable, Dialog dialog, View view) {
        pushEventForInApp("notification_viewed", bannerListTable);
        if (bannerListTable.getCourse_id() != null) {
            if (!bannerListTable.getLink_type().equalsIgnoreCase("3")) {
                if (!bannerListTable.getCourse_id().equals("0") && !bannerListTable.getBanner_location().equalsIgnoreCase("5")) {
                    if (bannerListTable != null && !TextUtils.isEmpty(bannerListTable.getCourse_id()) && !TextUtils.isEmpty(bannerListTable.getParent_id()) && bannerListTable.getCourse_id().equalsIgnoreCase(bannerListTable.getParent_id())) {
                        bannerListTable.getParent_id();
                    }
                    Intent intent = new Intent(this, (Class<?>) CourseActivity.class);
                    intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent.putExtra(Const.COURSE_ID_MAIN, bannerListTable.getCourse_id());
                    intent.putExtra(Const.IS_COURSE_COMBO, bannerListTable.getIs_combo() == 1);
                    intent.putExtra(Const.LINK_TYPE, bannerListTable.getLink_type());
                    if (bannerListTable.getParent_id() != null && !bannerListTable.getParent_id().equalsIgnoreCase("")) {
                        List listAsList = Arrays.asList(bannerListTable.getParent_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA));
                        if (listAsList.size() == 1) {
                            intent.putExtra(Const.COURSE_PARENT_ID, (String) listAsList.get(0));
                        }
                    }
                    intent.putExtra(Const.IS_COMBO, false);
                    intent.putExtra(AnalyticsConstants.course_name, bannerListTable.getBanner_title() != null ? bannerListTable.getBanner_title() : "Course");
                    Helper.gotoActivity(intent, this);
                } else {
                    String link = bannerListTable.getLink() != null ? bannerListTable.getLink() : "";
                    if (!GenericUtils.isEmpty(link)) {
                        try {
                            Uri uri = Uri.parse(link);
                            Intent intent2 = new Intent("android.intent.action.VIEW", uri);
                            intent2.addCategory("android.intent.category.BROWSABLE");
                            intent2.setFlags(268435456);
                            if (intent2.resolveActivity(getPackageManager()) != null) {
                                startActivity(intent2);
                            } else {
                                Intent intent3 = new Intent("android.intent.action.VIEW", uri);
                                intent3.setFlags(268435456);
                                startActivity(intent3);
                            }
                        } catch (Exception unused) {
                            Toast.makeText(this, "Failed to open the link.", 0).show();
                        }
                    }
                }
            } else if (bannerListTable != null) {
                BannerClickItem(bannerListTable);
            }
        }
        dialog.dismiss();
    }

    private void getBundledData() {
        if (getIntent() != null) {
            this.notification_code = getIntent().getIntExtra(Const.NOTIFICATION_CODE, 0);
            if (getIntent().getIntExtra(Const.SNS_NOTIFICATION_CODE, 0) != 0) {
                int intExtra = getIntent().getIntExtra(Const.SNS_NOTIFICATION_CODE, 0);
                this.notification_code = intExtra;
                this.sns_notification_code = intExtra;
                this.snsTitle = getIntent().getStringExtra(Const.SNS_TITLE);
                this.snsMessage = getIntent().getStringExtra(Const.SNS_MESSAGE);
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
            this.combo_id = getIntent().getStringExtra(Const.COMBO_ID);
            this.folder_id = getIntent().getStringExtra(Const.FOLDER_ID);
            this.folderContentType = getIntent().getStringExtra(Const.FOLDER_CONTENT_TYPE);
            this.test_series_name = getIntent().getStringExtra("test_series_name");
            this.solutions = getIntent().getStringExtra("solutions");
            this.test_series_date = getIntent().getStringExtra("result_date");
            this.id = getIntent().getStringExtra("id");
            this.post_id = getIntent().getStringExtra("post_id");
            this.status_free = getIntent().getStringExtra(Const.status_free);
            if (this.notification_code != 0) {
                pushEventForPushNotification("" + this.notification_code);
            }
            if (getIntent().getStringExtra(Const.COURSE_PARENT_ID) != null) {
                this.parentid = getIntent().getStringExtra(Const.COURSE_PARENT_ID);
            }
        }
    }

    private void initView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.emiRecyclerView);
        this.emiRecyclerView = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.emiRecyclerView.setLayoutManager(new LinearLayoutManager(homeactivitytheme1, 0, false));
        hit_api_for_courseReview();
        this.gridLayoutManager = new GridLayoutManager(this, 2);
        if (this.binding.dashBoardMain != null) {
            this.binding.dashBoardMain.tabsRV.setLayoutManager(this.gridLayoutManager);
        }
        this.binding.dashBoardMain.tabsRV.setNestedScrollingEnabled(false);
        this.binding.dashBoardMain.tabsRV.addItemDecoration(new GridSpacingItemDecoration(2, 15, false));
        this.dashboardTabAdapter = new DashboardTabAdapter(this, this.courseTypeMasterTables, this, "0");
        this.dashboardSquareTileTabAdapter = new DashboardSquareTileTabAdapter(this, this.courseTypeMasterTables, this);
        this.dashboardRectTileTabAdapter = new DashboardRectTileTabAdapter(this, this.courseTypeMasterTables, this);
        createMenus();
        hitApiIfNotInLocal();
        if (this.hitMaster) {
            this.hitMaster = false;
            this.networkCall.NetworkAPICall(API.master_content, "", true, false);
        }
        bindControls();
        setHomeDrawer();
    }

    public void setLocale(String localeName) {
        if (!localeName.equals(this.currentLanguage)) {
            this.myLocale = new Locale(localeName);
            Resources resources = getResources();
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            Configuration configuration = resources.getConfiguration();
            configuration.locale = this.myLocale;
            resources.updateConfiguration(configuration, displayMetrics);
            Intent intent = new Intent(this, (Class<?>) DashboardActivityTheme1.class);
            intent.putExtra(this.currentLang, localeName);
            startActivity(intent);
            return;
        }
        Toast.makeText(this, getResources().getString(R.string.language_already_selected), 0).show();
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:161:0x042f
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:132)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:58)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:50)
        */
    private void hitApiIfNotInLocal() {
        /*
            Method dump skipped, instruction units count: 2028
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Theme.DashboardActivityTheme1.hitApiIfNotInLocal():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hitApiIfNotInLocal$20() {
        try {
            if (!this.utkashRoom.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread()) {
                this.courseTypeMasterTables.addAll(this.utkashRoom.getcoursetypemaster().getcourse_typemaster(MakeMyExam.userId));
                this.masterAllCatTables = this.utkashRoom.getMasterAllCatDao().getmaster_allcat(MakeMyExam.userId);
                this.mastercatlist = this.utkashRoom.getMastercatDao().getmastercat(MakeMyExam.userId);
                this.LanguagesTable = this.utkashRoom.getLaunguages().getLaunguagedetail();
                this.bannerListTables = this.utkashRoom.getBannerTableDao().getBanner(MakeMyExam.getUserId());
                this.bottomMenuTables = this.utkashRoom.getBottomMenuTableDao().getBottomMenu(MakeMyExam.getUserId());
            }
            runOnUiThread(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda19
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$hitApiIfNotInLocal$19();
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hitApiIfNotInLocal$19() {
        if (this.leftMenu == null && this.hitMaster) {
            this.hitMaster = false;
            this.networkCall.NetworkAPICall(API.master_content, "", true, false);
            return;
        }
        this.courseTypeMasterRecyclerData.clear();
        this.courseTypeMasterRecyclerData1.clear();
        for (CourseTypeMasterTable courseTypeMasterTable : this.courseTypeMasterTables) {
            if (courseTypeMasterTable.getView_type() != null && courseTypeMasterTable.getView_type().equalsIgnoreCase("7")) {
                this.courseTypeMasterRecyclerData.add(courseTypeMasterTable);
            } else {
                this.courseTypeMasterRecyclerData1.add(courseTypeMasterTable);
            }
        }
        if (SharedPreference.getInstance().getString(Const.HORIZONTAL_COURSE).equalsIgnoreCase("1")) {
            this.binding.dashBoardMain.tabsRV.setLayoutManager(new LinearLayoutManager(this, 0, false));
            DashboardTabAdapter dashboardTabAdapter = new DashboardTabAdapter(this, this.courseTypeMasterRecyclerData, this, "0");
            this.dashboardTabAdapter = dashboardTabAdapter;
            dashboardTabAdapter.notifyDataSetChanged();
            this.binding.dashBoardMain.tabsRV.setAdapter(this.dashboardTabAdapter);
            this.binding.dashBoardMain.CourseListRV.setVisibility(0);
            this.binding.dashBoardMain.CourseListRV.setNestedScrollingEnabled(false);
            LeftMenu leftMenu = this.leftMenu;
            if (leftMenu != null && leftMenu.getMaster_category_style() != null && this.leftMenu.getMaster_category_style().equalsIgnoreCase("3")) {
                this.gridLayoutManager = new GridLayoutManager(this, 3);
                this.binding.dashBoardMain.CourseListRV.setLayoutManager(this.gridLayoutManager);
                this.binding.dashBoardMain.CourseListRV.addItemDecoration(new GridSpacingItemDecoration(3, 15, false));
                DashboardSquareTileTabAdapter dashboardSquareTileTabAdapter = new DashboardSquareTileTabAdapter(this, this.courseTypeMasterRecyclerData1, this);
                this.dashboardSquareTileTabAdapter = dashboardSquareTileTabAdapter;
                dashboardSquareTileTabAdapter.notifyDataSetChanged();
                this.binding.dashBoardMain.CourseListRV.setAdapter(this.dashboardSquareTileTabAdapter);
            } else if (this.leftMenu.getMaster_category_style() != null && this.leftMenu.getMaster_category_style().equalsIgnoreCase("2")) {
                this.gridLayoutManager = new GridLayoutManager(this, 2);
                this.binding.dashBoardMain.CourseListRV.setLayoutManager(this.gridLayoutManager);
                this.binding.dashBoardMain.CourseListRV.addItemDecoration(new GridSpacingItemDecoration(2, 20, false));
                DashboardSquareTileTabAdapter dashboardSquareTileTabAdapter2 = new DashboardSquareTileTabAdapter(this, this.courseTypeMasterRecyclerData1, this);
                this.dashboardSquareTileTabAdapter = dashboardSquareTileTabAdapter2;
                dashboardSquareTileTabAdapter2.notifyDataSetChanged();
                this.binding.dashBoardMain.CourseListRV.setAdapter(this.dashboardSquareTileTabAdapter);
            } else {
                this.binding.dashBoardMain.CourseListRV.setLayoutManager(new LinearLayoutManager(this));
                this.dashboardTabAdapter = new DashboardTabAdapter(this, this.courseTypeMasterRecyclerData1, this, "1");
                this.binding.dashBoardMain.CourseListRV.setNestedScrollingEnabled(false);
                this.binding.dashBoardMain.CourseListRV.addItemDecoration(new GridSpacingItemDecoration(2, 15, false));
                this.dashboardTabAdapter.notifyDataSetChanged();
                this.binding.dashBoardMain.CourseListRV.setAdapter(this.dashboardTabAdapter);
            }
        } else {
            LeftMenu leftMenu2 = this.leftMenu;
            if (leftMenu2 != null && leftMenu2.getMaster_category_style() != null && this.leftMenu.getMaster_category_style().equalsIgnoreCase("0")) {
                this.binding.dashBoardMain.tabsRV.setNestedScrollingEnabled(false);
                this.binding.dashBoardMain.tabsRV.addItemDecoration(new GridSpacingItemDecoration(2, 15, false));
                this.dashboardSquareTileTabAdapter.notifyDataSetChanged();
                this.binding.dashBoardMain.tabsRV.setAdapter(this.dashboardSquareTileTabAdapter);
            } else {
                LeftMenu leftMenu3 = this.leftMenu;
                if (leftMenu3 != null && leftMenu3.getMaster_category_style() != null && this.leftMenu.getMaster_category_style().equalsIgnoreCase("2")) {
                    this.binding.dashBoardMain.tabsRV.setNestedScrollingEnabled(false);
                    this.binding.dashBoardMain.tabsRV.addItemDecoration(new GridSpacingItemDecoration(2, 20, false));
                    this.dashboardRectTileTabAdapter.notifyDataSetChanged();
                    this.binding.dashBoardMain.tabsRV.setAdapter(this.dashboardRectTileTabAdapter);
                } else {
                    LeftMenu leftMenu4 = this.leftMenu;
                    if (leftMenu4 != null && leftMenu4.getMaster_category_style() != null && this.leftMenu.getMaster_category_style().equalsIgnoreCase("3")) {
                        this.gridLayoutManager = new GridLayoutManager(this, 3);
                        if (this.binding.dashBoardMain != null) {
                            this.binding.dashBoardMain.tabsRV.setLayoutManager(this.gridLayoutManager);
                        }
                        this.binding.dashBoardMain.tabsRV.setNestedScrollingEnabled(false);
                        this.binding.dashBoardMain.tabsRV.addItemDecoration(new GridSpacingItemDecoration(2, 15, false));
                        this.dashboardSquareTileTabAdapter.notifyDataSetChanged();
                        this.binding.dashBoardMain.tabsRV.setAdapter(this.dashboardSquareTileTabAdapter);
                    } else {
                        LeftMenu leftMenu5 = this.leftMenu;
                        if (leftMenu5 != null && leftMenu5.getMaster_category_style() != null && this.leftMenu.getMaster_category_style().equalsIgnoreCase("4")) {
                            this.gridLayoutManager = new GridLayoutManager(this, 4);
                            if (this.binding.dashBoardMain != null) {
                                this.binding.dashBoardMain.tabsRV.setLayoutManager(this.gridLayoutManager);
                            }
                            this.binding.dashBoardMain.tabsRV.setNestedScrollingEnabled(false);
                            this.binding.dashBoardMain.tabsRV.addItemDecoration(new GridSpacingItemDecoration(4, 10, false));
                            TileItemsAdapterSubCat tileItemsAdapterSubCat = new TileItemsAdapterSubCat(this, this.courseTypeMasterRecyclerData1, this);
                            tileItemsAdapterSubCat.notifyDataSetChanged();
                            this.binding.dashBoardMain.tabsRV.setAdapter(tileItemsAdapterSubCat);
                        } else {
                            this.binding.dashBoardMain.tabsRV.setNestedScrollingEnabled(false);
                            this.binding.dashBoardMain.tabsRV.addItemDecoration(new GridSpacingItemDecoration(2, 15, false));
                            this.dashboardTabAdapter.notifyDataSetChanged();
                            this.binding.dashBoardMain.tabsRV.setAdapter(this.dashboardTabAdapter);
                        }
                    }
                }
            }
        }
        selectedData();
        automateViewPagerSwiping();
        automateBottomViewPagerSwiping();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void hit_api_for_live_classes(boolean showProgress) {
        this.networkCall.NetworkAPICall(API.get_liveclasses_data, "", showProgress, false);
    }

    public void getEducators() {
        this.networkCall.NetworkAPICall(API.get_educators_list, "", false, false);
    }

    public void getTestimonials(boolean value) {
        this.networkCall.NetworkAPICall(API.get_testimonials_list, "", value, false);
    }

    private void getCourseData(boolean showProgress) {
        this.networkCall.NetworkAPICall(API.get_courses, "", showProgress, false);
    }

    private void hit_Api_for_daily_question() {
        this.networkCall.NetworkAPICall(API.DAILY_POST, "", true, false);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        byte b2 = -1;
        switch (apitype.hashCode()) {
            case -2088930306:
                if (apitype.equals(API.POST_COURSE_REVIEW)) {
                    b2 = 0;
                }
                break;
            case -1874107053:
                if (apitype.equals(API.master_content)) {
                    b2 = 1;
                }
                break;
            case -1563283144:
                if (apitype.equals(API.API_GET_TEST_INSTRUCTION_DATA)) {
                    b2 = 2;
                }
                break;
            case -1551336595:
                if (apitype.equals(API.get_testimonials_list)) {
                    b2 = 3;
                }
                break;
            case -1394338347:
                if (apitype.equals(API.get_educators_list)) {
                    b2 = 4;
                }
                break;
            case -1363215190:
                if (apitype.equals(API.DAILY_POST)) {
                    b2 = 5;
                }
                break;
            case -171058627:
                if (apitype.equals(API.API_GET_MASTER_DATA)) {
                    b2 = 6;
                }
                break;
            case -105845587:
                if (apitype.equals(API.attempt_mcq)) {
                    b2 = 7;
                }
                break;
            case 17608548:
                if (apitype.equals(API.user_logout)) {
                    b2 = 8;
                }
                break;
            case 44364183:
                if (apitype.equals(API.IS_COUPON_AVAILABLE)) {
                    b2 = 9;
                }
                break;
            case 440338530:
                if (apitype.equals(API.COURSE_REVIEW_LIST)) {
                    b2 = 10;
                }
                break;
            case 739951748:
                if (apitype.equals(API.API_GET_INFO_TEST_SERIES)) {
                    b2 = 11;
                }
                break;
            case 1007299982:
                if (apitype.equals(API.get_courses)) {
                    b2 = 12;
                }
                break;
            case 1185572585:
                if (apitype.equals(API.API_Installment_Course_List)) {
                    b2 = 13;
                }
                break;
            case 1203777933:
                if (apitype.equals(API.API_RECENT_WATCH)) {
                    b2 = 14;
                }
                break;
            case 1325706724:
                if (apitype.equals(API.API_Check_Installment_Status)) {
                    b2 = Ascii.SI;
                }
                break;
            case 1334579443:
                if (apitype.equals(API.COURSE_CART_COUNT)) {
                    b2 = 16;
                }
                break;
            case 1630777357:
                if (apitype.equals(API.update_profile)) {
                    b2 = 17;
                }
                break;
            case 1698256637:
                if (apitype.equals(API.get_folder_list)) {
                    b2 = Ascii.DC2;
                }
                break;
            case 1807711165:
                if (apitype.equals(API.API_GET_COUPON)) {
                    b2 = 19;
                }
                break;
            case 1942705377:
                if (apitype.equals(API.get_liveclasses_data)) {
                    b2 = Ascii.DC4;
                }
                break;
        }
        switch (b2) {
            case 0:
                EncryptionData encryptionData = new EncryptionData();
                int i = this.rating_type;
                if (i != 0 && (i == 2 || i == 3)) {
                    encryptionData.setCourse_id(this.courseId);
                    encryptionData.setRating_type(Integer.valueOf(this.rating_type));
                } else {
                    encryptionData.setCourse_id("0");
                }
                encryptionData.setRating(this.rating);
                encryptionData.setMessage(this.ratingMessage);
                return service.postCourseReview(AES.encrypt(new Gson().toJson(encryptionData)));
            case 1:
                EncryptionData encryptionData2 = new EncryptionData();
                encryptionData2.setUser_id(MakeMyExam.getUserId());
                return service.master_content(AES.encrypt(new Gson().toJson(encryptionData2)));
            case 2:
                EncryptionData encryptionData3 = new EncryptionData();
                encryptionData3.setTest_id(this.quiz_id);
                encryptionData3.setCourse_id(this.course_id);
                return service.API_GET_TEST_INSTRUCTION_DATA(AES.encrypt(new Gson().toJson(encryptionData3)));
            case 3:
                return service.getTestimonialList();
            case 4:
                return service.getEducatorList();
            case 5:
                return service.getDailyPostList(AES.encrypt(new Gson().toJson(new EncryptionData())));
            case 6:
                if (!TextUtils.isEmpty(this.revertapi)) {
                    String[] strArrSplit = this.revertapi.split(MqttTopic.MULTI_LEVEL_WILDCARD);
                    if (strArrSplit.length == 3) {
                        this.revertapi += "#0#0";
                    } else if (strArrSplit.length == 4) {
                        this.revertapi += "#0";
                    }
                }
                EncryptionData encryptionData4 = new EncryptionData();
                encryptionData4.setTile_id(this.tileid);
                encryptionData4.setType(this.tiletype);
                encryptionData4.setRevert_api(this.revertapi);
                encryptionData4.setCourse_id(this.course_id);
                encryptionData4.setFile_id(this.fieldid);
                encryptionData4.setParent_id(this.parentid);
                encryptionData4.setLayer("3");
                encryptionData4.setPage("1");
                encryptionData4.setSubject_id("");
                encryptionData4.setTopic_id(this.topicid);
                return service.getMasterDataVideoThree(AES.encrypt(new Gson().toJson(encryptionData4)));
            case 7:
                EncryptionData encryptionData5 = new EncryptionData();
                encryptionData5.setPost_id(this.poll_id);
                encryptionData5.setIndex(this.optionIndex);
                return service.postDailyPollAnswer(AES.encrypt(new Gson().toJson(encryptionData5)));
            case 8:
                EncryptionData encryptionData6 = new EncryptionData();
                encryptionData6.setUser_id(SharedPreference.getInstance().getLoggedInUser().getId());
                return service.getUserLogout(AES.encrypt(new Gson().toJson(encryptionData6)));
            case 9:
                return service.IS_COUPON_AVAILABLE("");
            case 10:
                EncryptionData encryptionData7 = new EncryptionData();
                encryptionData7.setCourse_id("0");
                return service.getCourseReviewList(AES.encrypt(new Gson().toJson(encryptionData7)));
            case 11:
                EncryptionData encryptionData8 = new EncryptionData();
                encryptionData8.setTest_id(this.quiz_id);
                encryptionData8.setCourse_id(this.course_id);
                return service.API_GET_INFO_TEST_SERIES(AES.encrypt(new Gson().toJson(encryptionData8)));
            case 12:
                EncryptionData encryptionData9 = new EncryptionData();
                encryptionData9.setCourse_type("0");
                encryptionData9.setMain_cat("0");
                encryptionData9.setSub_cat("1");
                encryptionData9.setIs_trending("1");
                encryptionData9.setLang("0");
                encryptionData9.setPage("1");
                encryptionData9.setIs_paid("");
                return service.get_courses(AES.encrypt(new Gson().toJson(encryptionData9)));
            case 13:
                EncryptionData encryptionData10 = new EncryptionData();
                encryptionData10.setUser_id(MakeMyExam.getUserId());
                return service.API_INSTALLMENT_COURSE_LIST(AES.encrypt(new Gson().toJson(encryptionData10)));
            case 14:
                EncryptionData encryptionData11 = new EncryptionData();
                encryptionData11.setUser_id(MakeMyExam.getUserId());
                return service.getRecentWatchList(AES.encrypt(new Gson().toJson(encryptionData11)));
            case 15:
                EncryptionData encryptionData12 = new EncryptionData();
                encryptionData12.setUser_id(MakeMyExam.getUserId());
                return service.API_CHECK_INSTALLMENT_DATA(AES.encrypt(new Gson().toJson(encryptionData12)));
            case 16:
                EncryptionData encryptionData13 = new EncryptionData();
                encryptionData13.setUser_id(SharedPreference.getInstance().getLoggedInUser().getId());
                return service.getCartCount(AES.encrypt(new Gson().toJson(encryptionData13)));
            case 17:
                EncryptionData encryptionData14 = new EncryptionData();
                encryptionData14.setName(this.data.getName());
                encryptionData14.setEmail(this.updateEmail_edt.getText().toString());
                return service.updateprofile(AES.encrypt(new Gson().toJson(encryptionData14)));
            case 18:
                EncryptionData encryptionData15 = new EncryptionData();
                encryptionData15.setCourse_id(this.course_id);
                encryptionData15.setTile_id(this.tileid);
                encryptionData15.setFolder_id(this.folder_id);
                encryptionData15.setPage("1");
                encryptionData15.setType(this.folderContentType);
                encryptionData15.setRevert_api(this.revertapi);
                encryptionData15.setSearch("");
                return service.get_folder_list(AES.encrypt(new Gson().toJson(encryptionData15)));
            case 19:
                return service.API_GET_COUPON("");
            case 20:
                EncryptionData encryptionData16 = new EncryptionData();
                encryptionData16.setPage("1");
                encryptionData16.setType("0");
                return service.getLiveClassesData(AES.encrypt(new Gson().toJson(encryptionData16)));
            default:
                return null;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:261:0x079f A[Catch: Exception -> 0x0b47, TryCatch #5 {Exception -> 0x0b47, blocks: (B:229:0x052e, B:232:0x053a, B:234:0x054b, B:237:0x05c0, B:239:0x05dd, B:241:0x05ef, B:243:0x05f3, B:246:0x0603, B:248:0x0638, B:259:0x079b, B:261:0x079f, B:263:0x07a8, B:264:0x07b0, B:266:0x07b6, B:268:0x07f5, B:270:0x089a, B:272:0x08a9, B:271:0x08a2, B:285:0x0a0e, B:287:0x0a12, B:289:0x0a4f, B:291:0x0a54, B:288:0x0a31, B:273:0x08da, B:275:0x08e3, B:276:0x08eb, B:278:0x08f1, B:280:0x0930, B:282:0x09ce, B:284:0x09dd, B:283:0x09d6, B:249:0x0675, B:250:0x06c5, B:252:0x06fa, B:253:0x0736, B:254:0x0785, B:256:0x0793, B:258:0x0798, B:236:0x0577, B:293:0x0a5a, B:295:0x0a5e, B:297:0x0a99, B:298:0x0ad8, B:299:0x0b29, B:301:0x0b34, B:303:0x0b3a, B:304:0x0b3e), top: B:831:0x052e }] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x08da A[Catch: Exception -> 0x0b47, TryCatch #5 {Exception -> 0x0b47, blocks: (B:229:0x052e, B:232:0x053a, B:234:0x054b, B:237:0x05c0, B:239:0x05dd, B:241:0x05ef, B:243:0x05f3, B:246:0x0603, B:248:0x0638, B:259:0x079b, B:261:0x079f, B:263:0x07a8, B:264:0x07b0, B:266:0x07b6, B:268:0x07f5, B:270:0x089a, B:272:0x08a9, B:271:0x08a2, B:285:0x0a0e, B:287:0x0a12, B:289:0x0a4f, B:291:0x0a54, B:288:0x0a31, B:273:0x08da, B:275:0x08e3, B:276:0x08eb, B:278:0x08f1, B:280:0x0930, B:282:0x09ce, B:284:0x09dd, B:283:0x09d6, B:249:0x0675, B:250:0x06c5, B:252:0x06fa, B:253:0x0736, B:254:0x0785, B:256:0x0793, B:258:0x0798, B:236:0x0577, B:293:0x0a5a, B:295:0x0a5e, B:297:0x0a99, B:298:0x0ad8, B:299:0x0b29, B:301:0x0b34, B:303:0x0b3a, B:304:0x0b3e), top: B:831:0x052e }] */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0a12 A[Catch: Exception -> 0x0b47, TryCatch #5 {Exception -> 0x0b47, blocks: (B:229:0x052e, B:232:0x053a, B:234:0x054b, B:237:0x05c0, B:239:0x05dd, B:241:0x05ef, B:243:0x05f3, B:246:0x0603, B:248:0x0638, B:259:0x079b, B:261:0x079f, B:263:0x07a8, B:264:0x07b0, B:266:0x07b6, B:268:0x07f5, B:270:0x089a, B:272:0x08a9, B:271:0x08a2, B:285:0x0a0e, B:287:0x0a12, B:289:0x0a4f, B:291:0x0a54, B:288:0x0a31, B:273:0x08da, B:275:0x08e3, B:276:0x08eb, B:278:0x08f1, B:280:0x0930, B:282:0x09ce, B:284:0x09dd, B:283:0x09d6, B:249:0x0675, B:250:0x06c5, B:252:0x06fa, B:253:0x0736, B:254:0x0785, B:256:0x0793, B:258:0x0798, B:236:0x0577, B:293:0x0a5a, B:295:0x0a5e, B:297:0x0a99, B:298:0x0ad8, B:299:0x0b29, B:301:0x0b34, B:303:0x0b3a, B:304:0x0b3e), top: B:831:0x052e }] */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0a31 A[Catch: Exception -> 0x0b47, TryCatch #5 {Exception -> 0x0b47, blocks: (B:229:0x052e, B:232:0x053a, B:234:0x054b, B:237:0x05c0, B:239:0x05dd, B:241:0x05ef, B:243:0x05f3, B:246:0x0603, B:248:0x0638, B:259:0x079b, B:261:0x079f, B:263:0x07a8, B:264:0x07b0, B:266:0x07b6, B:268:0x07f5, B:270:0x089a, B:272:0x08a9, B:271:0x08a2, B:285:0x0a0e, B:287:0x0a12, B:289:0x0a4f, B:291:0x0a54, B:288:0x0a31, B:273:0x08da, B:275:0x08e3, B:276:0x08eb, B:278:0x08f1, B:280:0x0930, B:282:0x09ce, B:284:0x09dd, B:283:0x09d6, B:249:0x0675, B:250:0x06c5, B:252:0x06fa, B:253:0x0736, B:254:0x0785, B:256:0x0793, B:258:0x0798, B:236:0x0577, B:293:0x0a5a, B:295:0x0a5e, B:297:0x0a99, B:298:0x0ad8, B:299:0x0b29, B:301:0x0b34, B:303:0x0b3a, B:304:0x0b3e), top: B:831:0x052e }] */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0a54 A[Catch: Exception -> 0x0b47, TryCatch #5 {Exception -> 0x0b47, blocks: (B:229:0x052e, B:232:0x053a, B:234:0x054b, B:237:0x05c0, B:239:0x05dd, B:241:0x05ef, B:243:0x05f3, B:246:0x0603, B:248:0x0638, B:259:0x079b, B:261:0x079f, B:263:0x07a8, B:264:0x07b0, B:266:0x07b6, B:268:0x07f5, B:270:0x089a, B:272:0x08a9, B:271:0x08a2, B:285:0x0a0e, B:287:0x0a12, B:289:0x0a4f, B:291:0x0a54, B:288:0x0a31, B:273:0x08da, B:275:0x08e3, B:276:0x08eb, B:278:0x08f1, B:280:0x0930, B:282:0x09ce, B:284:0x09dd, B:283:0x09d6, B:249:0x0675, B:250:0x06c5, B:252:0x06fa, B:253:0x0736, B:254:0x0785, B:256:0x0793, B:258:0x0798, B:236:0x0577, B:293:0x0a5a, B:295:0x0a5e, B:297:0x0a99, B:298:0x0ad8, B:299:0x0b29, B:301:0x0b34, B:303:0x0b3a, B:304:0x0b3e), top: B:831:0x052e }] */
    /* JADX WARN: Removed duplicated region for block: B:899:? A[RETURN, SYNTHETIC] */
    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void SuccessCallBack(org.json.JSONObject r17, java.lang.String r18, java.lang.String r19, boolean r20) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 7738
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Theme.DashboardActivityTheme1.SuccessCallBack(org.json.JSONObject, java.lang.String, java.lang.String, boolean):void");
    }

    private void setCourseData(ArrayList<Courselist> courselists) {
        ArrayList<Courselist> arrayList = new ArrayList<>();
        ArrayList<Courselist> arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Courselist courselist : courselists) {
            if (SharedPreference.getInstance().getString(Const.IS_USER_WANT_FREE_STUFF).equalsIgnoreCase("1")) {
                if (courselist.getMrp().equalsIgnoreCase("0") || courselist.getMrp().equalsIgnoreCase("")) {
                    if (courselist.getCat_type().equalsIgnoreCase("1")) {
                        arrayList3.add(courselist);
                    } else {
                        arrayList2.add(courselist);
                    }
                }
            } else if (SharedPreference.getInstance().getString(Const.IS_USER_WANT_FREE_STUFF).equalsIgnoreCase("2")) {
                if (courselist.getCat_type().equalsIgnoreCase("1")) {
                    arrayList3.add(courselist);
                } else {
                    arrayList2.add(courselist);
                }
            } else if (courselist.getMrp() != null && !TextUtils.isEmpty(courselist.getMrp()) && Integer.parseInt(courselist.getMrp()) > 0) {
                if (courselist.getCat_type().equalsIgnoreCase("1")) {
                    arrayList3.add(courselist);
                } else {
                    arrayList2.add(courselist);
                }
            }
        }
        for (Courselist courselist2 : arrayList2) {
            if (courselist2.getExtra_json().getIs_trending() != null && courselist2.getExtra_json().getIs_trending().equalsIgnoreCase("1")) {
                arrayList.add(courselist2);
            }
        }
        trendingClassList(arrayList);
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

    private void stdFeedbacksList(TestimonialModel testimonialModel) {
        this.testimonialList.clear();
        if (testimonialModel.getData() != null && testimonialModel.getData().getTestimonial().size() > 0) {
            this.binding.dashBoardMain.testimonialLL.setVisibility(0);
            this.testimonialList.addAll(testimonialModel.getData().getTestimonial());
            this.homeStdFeedAdapter = new HomeStdFeedAdapter(this, this.testimonialList);
            this.binding.dashBoardMain.studentFeedbackRecyclerView.setAdapter(this.homeStdFeedAdapter);
            this.binding.dashBoardMain.studentFeedbackRecyclerView.setLayoutManager(new LinearLayoutManager(this, 0, false));
            this.binding.dashBoardMain.studentFeedbackRecyclerView.setHasFixedSize(true);
            this.homeStdFeedAdapter.notifyDataSetChanged();
            return;
        }
        this.binding.dashBoardMain.testimonialLL.setVisibility(8);
    }

    private void setEducatorsList(EducatorsModel educatorsModel) {
        this.educatorsList.clear();
        if (educatorsModel.getData() != null && educatorsModel.getData().size() > 0) {
            this.binding.dashBoardMain.educatorListLL.setVisibility(0);
            this.educatorsList.addAll(educatorsModel.getData());
            this.homeEduAdapter = new HomeEduAdapter(this, this.educatorsList, this);
            this.binding.dashBoardMain.ourEducatorsRecyclerView.setAdapter(this.homeEduAdapter);
            this.binding.dashBoardMain.ourEducatorsRecyclerView.setLayoutManager(new LinearLayoutManager(this, 0, false));
            this.binding.dashBoardMain.ourEducatorsRecyclerView.setHasFixedSize(true);
            this.homeEduAdapter.notifyDataSetChanged();
            return;
        }
        this.binding.dashBoardMain.educatorListLL.setVisibility(8);
    }

    private void trendingClassList(ArrayList<Courselist> courseListCourse) {
        if (courseListCourse != null && courseListCourse.size() > 0) {
            this.binding.dashBoardMain.trendingCourseLL.setVisibility(0);
            this.homeTCAdapter = new HomeTCAdapter(this, courseListCourse, this, this);
            this.binding.dashBoardMain.trendingCourseRecyclerView.setAdapter(this.homeTCAdapter);
            this.binding.dashBoardMain.trendingCourseRecyclerView.setLayoutManager(new LinearLayoutManager(this, 0, false));
            this.binding.dashBoardMain.trendingCourseRecyclerView.setHasFixedSize(true);
            return;
        }
        this.binding.dashBoardMain.trendingCourseLL.setVisibility(8);
    }

    private void liveClassList(LiveClassesData liveClasses) {
        this.liveClassesDataArrayList.clear();
        if (liveClasses.getData() != null && liveClasses.getData().size() > 0) {
            this.binding.dashBoardMain.educatorsLiveClassLay.setVisibility(0);
            this.liveClassesDataArrayList.addAll(liveClasses.getData());
            this.homeLCAdapter = new HomeLCAdapter(this, this.liveClassesDataArrayList, this);
            this.binding.dashBoardMain.liveClassesRecyclerView.setAdapter(this.homeLCAdapter);
            this.binding.dashBoardMain.liveClassesRecyclerView.setLayoutManager(new LinearLayoutManager(this, 0, false));
            this.binding.dashBoardMain.liveClassesRecyclerView.setHasFixedSize(true);
            this.homeLCAdapter.notifyDataSetChanged();
            return;
        }
        this.binding.dashBoardMain.educatorsLiveClassLay.setVisibility(8);
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

    public void resetDefaultGreetingUi() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = (int) (displayMetrics.scaledDensity * 110.0f);
        LinearLayout linearLayout = this.binding.dashBoardMain.greetingMsgLL;
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = -2;
        linearLayout.setLayoutParams(layoutParams);
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
        if (video.getImage() == null || video.getImage().equalsIgnoreCase("")) {
            imageView.setImageResource(R.mipmap.square_placeholder);
        } else {
            Helper.setThumbnailImage(this, video.getImage(), getDrawable(R.mipmap.square_placeholder), imageView);
        }
        if (video.getAttempt() != null) {
            if (video.getAttempt().equalsIgnoreCase("0")) {
                button4.setText("Upload");
            } else {
                button4.setText("View");
            }
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda39
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showsubjectivepopup$21(view);
            }
        });
        final Video video3 = video;
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showsubjectivepopup$22(video3, this, view);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda41
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showsubjectivepopup$23(button4, this, video3, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme1.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Long.parseLong(video3.getResult_date()) * 1000 < System.currentTimeMillis()) {
                    if (!Helper.isConnected(this)) {
                        Toast.makeText(this, "No Internet Connection", 0).show();
                        return;
                    }
                    if (video3.getIs_locked().equalsIgnoreCase("1")) {
                        if (DashboardActivityTheme1.this.parentid == null || DashboardActivityTheme1.this.parentid.equalsIgnoreCase("")) {
                            Intent intent = new Intent(DashboardActivityTheme1.this, (Class<?>) CourseActivity.class);
                            intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                            intent.putExtra(Const.COURSE_ID_MAIN, video3.getPayloadData().getCourse_id());
                            intent.putExtra(Const.COURSE_PARENT_ID, "");
                            intent.putExtra(Const.IS_COMBO, false);
                            SharedPreference.getInstance().putString("id", video3.getPayloadData().getCourse_id());
                            DashboardActivityTheme1.this.startActivity(intent);
                            return;
                        }
                        Intent intent2 = new Intent(DashboardActivityTheme1.this, (Class<?>) CourseActivity.class);
                        intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                        intent2.putExtra(Const.COURSE_ID_MAIN, DashboardActivityTheme1.this.parentid);
                        intent2.putExtra(Const.COURSE_PARENT_ID, "");
                        intent2.putExtra(Const.IS_COMBO, false);
                        SharedPreference.getInstance().putString("id", video3.getPayloadData().getCourse_id());
                        DashboardActivityTheme1.this.startActivity(intent2);
                        return;
                    }
                    if (!video3.getAnswers().equalsIgnoreCase("")) {
                        Constants.SUB_TEST_ID = video3.getId();
                        Helper.GoToWebViewPDFActivity(this, video3.getId(), video3.getAnswers(), true, video3.getAnswers().split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r11.length - 1].split("\\.")[0], DashboardActivityTheme1.this.course_id, video3.getIs_share());
                        return;
                    }
                    Toast.makeText(this, "File Not found.", 0).show();
                    return;
                }
                Toast.makeText(this, "Result will be available on " + new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video3.getResult_date()) * 1000)), 0).show();
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme1.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Long.parseLong(video3.getResult_date()) * 1000 < System.currentTimeMillis()) {
                    if (!Helper.isConnected(this)) {
                        Toast.makeText(this, "No Internet Connection", 0).show();
                        return;
                    }
                    if (video3.getIs_locked().equalsIgnoreCase("1")) {
                        if (DashboardActivityTheme1.this.parentid == null || DashboardActivityTheme1.this.parentid.equalsIgnoreCase("")) {
                            Intent intent = new Intent(DashboardActivityTheme1.this, (Class<?>) CourseActivity.class);
                            intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                            intent.putExtra(Const.COURSE_ID_MAIN, video3.getPayloadData().getCourse_id());
                            intent.putExtra(Const.COURSE_PARENT_ID, "");
                            intent.putExtra(Const.IS_COMBO, false);
                            SharedPreference.getInstance().putString("id", video3.getPayloadData().getCourse_id());
                            DashboardActivityTheme1.this.startActivity(intent);
                            return;
                        }
                        Intent intent2 = new Intent(DashboardActivityTheme1.this, (Class<?>) CourseActivity.class);
                        intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                        intent2.putExtra(Const.COURSE_ID_MAIN, DashboardActivityTheme1.this.parentid);
                        intent2.putExtra(Const.COURSE_PARENT_ID, "");
                        intent2.putExtra(Const.IS_COMBO, false);
                        SharedPreference.getInstance().putString("id", video3.getPayloadData().getCourse_id());
                        DashboardActivityTheme1.this.startActivity(intent2);
                        return;
                    }
                    Constants.SUB_TEST_ID = video3.getId();
                    Helper.GoToSubjectiveResultActivity(this, video3.getSolutions(), video3.getTest_series_name(), DashboardActivityTheme1.this.course_id, video3.getId(), DashboardActivityTheme1.this.tiletype);
                    return;
                }
                Toast.makeText(this, "Result will be available on " + new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video3.getResult_date()) * 1000)), 0).show();
            }
        });
        this.quizBasicInfoDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme1.12
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialog2, int keyCode, KeyEvent event) {
                if (keyCode != 4) {
                    return true;
                }
                DashboardActivityTheme1.this.initialzehomepage();
                DashboardActivityTheme1.this.quizBasicInfoDialog.dismiss();
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showsubjectivepopup$21(View view) {
        if (this.quizBasicInfoDialog.isShowing()) {
            this.quizBasicInfoDialog.dismiss();
            initialzehomepage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showsubjectivepopup$22(Video video, Activity activity, View view) {
        if (System.currentTimeMillis() < Long.parseLong(video.getStart_date()) * 1000) {
            Toast.makeText(this, "Test will start on " + new SimpleDateFormat("dd/MM/yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
            return;
        }
        if (!Helper.isConnected(activity)) {
            Toast.makeText(activity, "No Internet Connection", 0).show();
            return;
        }
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
        if (!video.getQuestion().equalsIgnoreCase("")) {
            Constants.SUB_TEST_ID = video.getId();
            Helper.GoToWebViewPDFActivity(activity, video.getId(), video.getQuestion(), true, video.getQuestion().split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r11.length - 1].split("\\.")[0], this.course_id, video.getIs_share());
            return;
        }
        Toast.makeText(activity, "File not found.", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showsubjectivepopup$23(Button button, Activity activity, Video video, View view) {
        if (button.getText().toString().equalsIgnoreCase("View")) {
            Intent intent = new Intent(activity, (Class<?>) PdfDetailScreen.class);
            intent.putExtra(Const.THUMBNAIL, video.getThumbnail_url());
            intent.putExtra("url", video.getAnswers_by_student());
            activity.startActivity(intent);
            return;
        }
        if (System.currentTimeMillis() < Long.parseLong(video.getStart_date()) * 1000) {
            Toast.makeText(activity, "Test will start on " + new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
            return;
        }
        if (!Helper.isConnected(activity)) {
            Toast.makeText(activity, "No Internet Connection", 0).show();
            return;
        }
        if (video.getIs_locked().equalsIgnoreCase("1")) {
            String str = this.parentid;
            if (str == null || str.equalsIgnoreCase("")) {
                Intent intent2 = new Intent(this, (Class<?>) CourseActivity.class);
                intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                intent2.putExtra(Const.COURSE_ID_MAIN, video.getPayloadData().getCourse_id());
                intent2.putExtra(Const.COURSE_PARENT_ID, "");
                intent2.putExtra(Const.IS_COMBO, false);
                SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                startActivity(intent2);
                return;
            }
            Intent intent3 = new Intent(this, (Class<?>) CourseActivity.class);
            intent3.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
            intent3.putExtra(Const.COURSE_ID_MAIN, this.parentid);
            intent3.putExtra(Const.COURSE_PARENT_ID, "");
            intent3.putExtra(Const.IS_COMBO, false);
            SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
            startActivity(intent3);
            return;
        }
        Constants.SUB_TEST_ID = video.getId();
        checkStoragePermission();
    }

    private void checkStoragePermission() {
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

    private String getDate11(String currentTime) {
        return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date(Long.parseLong(currentTime) * 1000));
    }

    private String getDate(ExpiredEmiModel expiredEmiModel) {
        return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date(Long.parseLong(expiredEmiModel.getCheck_for_expiry())));
    }

    private String getDate1(ExpiredEmiModel expiredEmiModel) {
        return new SimpleDateFormat("HH:mm:ss").format(new Date(Long.parseLong(expiredEmiModel.getCheck_for_expiry())));
    }

    private void showEmiUIOnTop() {
        this.emiRecyclerView.setVisibility(0);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        if (apitype.equalsIgnoreCase(API.master_content)) {
            this.hitMaster = true;
        }
    }

    private void automateBottomViewPagerSwiping() {
        List<BannerListTable> list = this.bannerListTables;
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        for (BannerListTable bannerListTable : this.bannerListTables) {
            if (bannerListTable.getBanner_location().equalsIgnoreCase("1")) {
                arrayList.add(bannerListTable);
            }
        }
        this.binding.dashBoardMain.bottomSliderLayout.viewPager2.setAdapter(new BottomSliderAdapter(this, arrayList, new BottomSliderAdapter.BannerClick() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda46
            @Override // com.appnew.android.Theme.Adapter.BottomSliderAdapter.BannerClick
            public final void BannerClickItem(BannerListTable bannerListTable2) {
                this.f$0.BannerClickItem(bannerListTable2);
            }
        }));
        Utils.INSTANCE.setUpViewPager(this.binding.dashBoardMain.bottomSliderLayout.viewPager2, this.binding.dashBoardMain.bottomSliderLayout.bannerIndicator, arrayList);
        ViewGroup.LayoutParams layoutParams = this.binding.dashBoardMain.bottomSliderLayout.viewPager2.getLayoutParams();
        layoutParams.height = 300;
        layoutParams.width = -1;
        this.binding.dashBoardMain.bottomSliderLayout.viewPager2.setLayoutParams(layoutParams);
        this.binding.dashBoardMain.bottomSliderLayout.viewPager2.requestLayout();
        if (arrayList.size() > 0) {
            this.binding.dashBoardMain.bottomSliderLayout.parentCL.setVisibility(0);
        } else {
            this.binding.dashBoardMain.bottomSliderLayout.parentCL.setVisibility(8);
        }
    }

    private void hitInstallmentCheckApi() {
        this.networkCall.NetworkAPICall(API.API_Check_Installment_Status, "", true, false);
    }

    private void hitGetInstallmentDataApi() {
        this.networkCall.NetworkAPICall(API.API_Installment_Course_List, "", true, false);
    }

    private void automateViewPagerSwiping() {
        List<BannerListTable> list = this.bannerListTables;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList.clear();
            for (BannerListTable bannerListTable : this.bannerListTables) {
                if (bannerListTable.getBanner_location().equalsIgnoreCase("0")) {
                    arrayList.add(bannerListTable);
                }
                if (bannerListTable.getBanner_location().equalsIgnoreCase("5")) {
                    arrayList.add(bannerListTable);
                }
                if (bannerListTable.getBanner_location().equalsIgnoreCase("7")) {
                    arrayList2.add(bannerListTable);
                }
            }
            if (arrayList.size() > 0) {
                this.binding.dashBoardMain.bannerSliderLayout.viewPager2.setAdapter(new SliderAdapter(this, arrayList, new SliderAdapter.BannerClick() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda10
                    @Override // com.appnew.android.Theme.Adapter.SliderAdapter.BannerClick
                    public final void BannerClickItem(BannerListTable bannerListTable2) {
                        this.f$0.BannerClickItem(bannerListTable2);
                    }
                }));
                Utils.INSTANCE.setUpViewPager(this.binding.dashBoardMain.bannerSliderLayout.viewPager2, this.binding.dashBoardMain.bannerSliderLayout.bannerIndicator, arrayList);
                this.binding.dashBoardMain.bannerSliderLayout.parentCL.setVisibility(0);
            } else {
                this.binding.dashBoardMain.bannerSliderLayout.parentCL.setVisibility(8);
            }
            if (arrayList2.size() > 0) {
                this.binding.dashBoardMain.bannerSliderLayout1.viewPager2.setAdapter(new SliderAdapter(this, arrayList2, new SliderAdapter.BannerClick() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda10
                    @Override // com.appnew.android.Theme.Adapter.SliderAdapter.BannerClick
                    public final void BannerClickItem(BannerListTable bannerListTable2) {
                        this.f$0.BannerClickItem(bannerListTable2);
                    }
                }));
                Utils.INSTANCE.setUpViewPager(this.binding.dashBoardMain.bannerSliderLayout1.viewPager2, this.binding.dashBoardMain.bannerSliderLayout1.bannerIndicator, arrayList2);
                this.binding.dashBoardMain.rlAnnounce.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.binding.dashBoardMain.bannerSliderLayout1.viewPager2.getLayoutParams();
                layoutParams.height = 160;
                layoutParams.width = -2;
                this.binding.dashBoardMain.bannerSliderLayout1.viewPager2.setLayoutParams(layoutParams);
                this.binding.dashBoardMain.bannerSliderLayout1.viewPager2.requestLayout();
                return;
            }
            this.binding.dashBoardMain.rlAnnounce.setVisibility(8);
            return;
        }
        this.binding.dashBoardMain.bannerSliderLayout.parentCL.setVisibility(8);
        this.binding.dashBoardMain.rlAnnounce.setVisibility(8);
    }

    private void manageVisibility() {
        this.binding.dashBoardMain.viewPagerRL.setVisibility(8);
        this.binding.dashBoardMain.bottomViewPagerRL.setVisibility(8);
        this.binding.dashBoardMain.contactUsLL.setVisibility(8);
        if (this.bottomSetting.getContact_us() != null && this.bottomSetting.getContact_us().equalsIgnoreCase("1")) {
            this.binding.dashBoardMain.contactUsLL.setVisibility(0);
        } else {
            this.binding.dashBoardMain.contactUsLL.setVisibility(8);
        }
        if (this.bottomSetting.getTop_layout() != null && this.bottomSetting.getTop_layout().equalsIgnoreCase("1")) {
            this.binding.dashBoardMain.topLayout.setVisibility(0);
        } else {
            this.binding.dashBoardMain.topLayout.setVisibility(8);
        }
        if (this.bottomSetting.getTop_banner() != null && this.bottomSetting.getTop_banner().equalsIgnoreCase("1")) {
            this.binding.dashBoardMain.viewPagerRL.setVisibility(0);
        } else {
            this.binding.dashBoardMain.viewPagerRL.setVisibility(8);
        }
        if (this.bottomSetting.getBottom_banner() != null && this.bottomSetting.getBottom_banner().equalsIgnoreCase("1")) {
            this.binding.dashBoardMain.bottomViewPagerRL.setVisibility(0);
        } else {
            this.binding.dashBoardMain.bottomViewPagerRL.setVisibility(8);
        }
    }

    private void selectedData() {
        UtkashRoom utkashRoom = this.utkashRoom;
        if (utkashRoom != null && utkashRoom.getthemeSettingdao() != null && this.utkashRoom.getthemeSettingdao().is_setting_exit()) {
            this.bottomSetting = (BottomSetting) new Gson().fromJson(this.utkashRoom.getthemeSettingdao().data().getBottom(), BottomSetting.class);
            List<BottomMenuTable> list = this.bottomMenuTables;
            if (list != null && list.size() > 0) {
                this.binding.dashBoardMain.bottomMenu.bottomLL.removeAllViews();
                ArrayList<View> arrayList = this.viewArrayList;
                if (arrayList != null) {
                    arrayList.clear();
                }
                for (int i = 0; i < Helper.getBottomMenu(this.bottomMenuTables).size(); i++) {
                    this.binding.dashBoardMain.bottomMenu.bottomLL.addView(initBottomView(Helper.getBottomMenu(this.bottomMenuTables).get(i)));
                }
            }
            manageVisibility();
            createMenus();
        }
        callDialog();
    }

    private void setHomeDrawer() {
        setSupportActionBar(this.binding.dashBoardMain.dashboardToolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.menu);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, this.binding.drawerLayout, this.binding.dashBoardMain.dashboardToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        this.toggle = actionBarDrawerToggle;
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        this.binding.drawerLayout.setDrawerListener(this.toggle);
        this.toggle.syncState();
        this.binding.drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme1.13
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
                Helper.HideKeyboard(DashboardActivityTheme1.this);
            }
        });
        ActionBarDrawerToggle actionBarDrawerToggle2 = new ActionBarDrawerToggle(this, this.binding.drawerLayout, this.binding.dashBoardMain.dashboardToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) { // from class: com.appnew.android.Theme.DashboardActivityTheme1.14
            @Override // androidx.appcompat.app.ActionBarDrawerToggle, androidx.drawerlayout.widget.DrawerLayout.DrawerListener
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override // androidx.appcompat.app.ActionBarDrawerToggle, androidx.drawerlayout.widget.DrawerLayout.DrawerListener
            public void onDrawerOpened(View drawerView) {
                String string = SharedPreference.getInstance().getString(Const.SERVER_TIME);
                if (TextUtils.isEmpty(string) || string.equals("0")) {
                    if (SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE).equalsIgnoreCase("") || SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE).equals("0")) {
                        DashboardActivityTheme1.this.networkCall.NetworkAPICall(API.IS_COUPON_AVAILABLE, "", false, false);
                    } else if (Integer.parseInt(SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE)) > 0) {
                        DashboardActivityTheme1.this.createMenus();
                    }
                } else if (Long.parseLong(string) <= System.currentTimeMillis()) {
                    DashboardActivityTheme1.this.networkCall.NetworkAPICall(API.IS_COUPON_AVAILABLE, "", false, false);
                }
                Helper.HideKeyboard(DashboardActivityTheme1.this);
                super.onDrawerOpened(drawerView);
            }
        };
        this.binding.drawerLayout.setDrawerListener(actionBarDrawerToggle2);
        actionBarDrawerToggle2.syncState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createMenus() {
        Data loggedInUser = SharedPreference.getInstance().getLoggedInUser();
        if (loggedInUser.getProfilePicture() != null) {
            ((CircleImageView) Objects.requireNonNull(this.binding.profileImage)).setVisibility(0);
            Glide.with((FragmentActivity) this).load(loggedInUser.getProfilePicture()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.course_placeholder)).into(this.binding.profileImage);
        } else {
            ((CircleImageView) Objects.requireNonNull(this.binding.profileImage)).setVisibility(0);
            ((ImageView) Objects.requireNonNull(this.binding.profileImageText)).setVisibility(8);
            this.binding.profileImage.setImageResource(R.mipmap.default_pic);
        }
        if (!TextUtils.isEmpty(loggedInUser.getName()) && !TextUtils.isEmpty(loggedInUser.getMobile())) {
            ((TextView) Objects.requireNonNull(this.binding.profileName)).setText(loggedInUser.getName());
            ((TextView) Objects.requireNonNull(this.binding.profileEmail)).setText(loggedInUser.getMobile());
        } else if (!TextUtils.isEmpty(loggedInUser.getName()) && !TextUtils.isEmpty(loggedInUser.getEmail())) {
            ((TextView) Objects.requireNonNull(this.binding.profileName)).setText(loggedInUser.getName());
            ((TextView) Objects.requireNonNull(this.binding.profileEmail)).setText(loggedInUser.getEmail());
        } else {
            ((TextView) Objects.requireNonNull(this.binding.profileName)).setText(getResources().getString(R.string.user));
            ((TextView) Objects.requireNonNull(this.binding.profileEmail)).setText(getResources().getString(R.string.user_mail));
        }
        ((TextView) Objects.requireNonNull(this.binding.vNameTV)).setText(Html.fromHtml(getResources().getString(R.string.version) + Helper.getVersionName(this)));
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
            ((RecyclerView) Objects.requireNonNull(this.binding.navRV)).setLayoutManager(new LinearLayoutManager(this));
            this.binding.navRV.setAdapter(leftNavAdapter);
            leftNavAdapter.setLeftNavAdapterListener(new LeftNavAdapter.LeftNavAdapterListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda36
                @Override // com.appnew.android.home.adapters.LeftNavAdapter.LeftNavAdapterListener
                public final void onItemClick(Menu menu) {
                    this.f$0.lambda$createMenus$24(leftNavAdapter, menu);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        socialIconsVisibility(this.leftMenu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createMenus$24(LeftNavAdapter leftNavAdapter, Menu menu) {
        if (menu.getHaveChild().equalsIgnoreCase("1")) {
            menu.setExpanded(!menu.isExpanded());
        }
        handleLeftMenuClick(menu);
        leftNavAdapter.notifyDataSetChanged();
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
                case 1607:
                    if (type_code.equals(Constants.LEFT_NAV_KEY.testReport)) {
                        b2 = Ascii.FS;
                    }
                    break;
                case 1630:
                    if (type_code.equals(Constants.LEFT_NAV_KEY.Course_Chat)) {
                        b2 = Ascii.GS;
                    }
                    break;
                case 1631:
                    if (type_code.equals(Constants.LEFT_NAV_KEY.attendance_report)) {
                        b2 = Ascii.RS;
                    }
                    break;
                case 1632:
                    if (type_code.equals(Constants.LEFT_NAV_KEY.LANGUAGE)) {
                        b2 = Ascii.US;
                    }
                    break;
                case 1633:
                    if (type_code.equals(Constants.LEFT_NAV_KEY.TEACHER_TIME_TABLE)) {
                        b2 = 32;
                    }
                    break;
                case 1634:
                    if (type_code.equals(Constants.LEFT_NAV_KEY.STUDENT_RESULT)) {
                        b2 = 33;
                    }
                    break;
                case 1635:
                    if (type_code.equals(Constants.LEFT_NAV_KEY.NOTICE_BOARD)) {
                        b2 = 34;
                    }
                    break;
                case 1636:
                    if (type_code.equals(Constants.LEFT_NAV_KEY.LEFT_DOUBT)) {
                        b2 = 35;
                    }
                    break;
                case 1731:
                    if (type_code.equals(Constants.LEFT_NAV_KEY.change_preference)) {
                        b2 = 36;
                    }
                    break;
                case 1822:
                    if (type_code.equals(Constants.LEFT_NAV_KEY.contact_us_query)) {
                        b2 = 37;
                    }
                    break;
                case 1823:
                    if (type_code.equals(Constants.LEFT_NAV_KEY.book_store)) {
                        b2 = 38;
                    }
                    break;
                case NewHope.SENDA_BYTES /* 1824 */:
                    if (type_code.equals(Constants.LEFT_NAV_KEY.custom_payment)) {
                        b2 = 39;
                    }
                    break;
                case 1507423:
                    if (type_code.equals(Constants.LEFT_NAV_KEY.book_history)) {
                        b2 = 40;
                    }
                    break;
                case 1507424:
                    if (type_code.equals(Constants.LEFT_NAV_KEY.test_scan)) {
                        b2 = 41;
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
                        AES.encrypt("?userId=39&courseId=121&id=123");
                        Intent intent2 = new Intent("android.intent.action.SEND");
                        intent2.setType(HTTP.PLAIN_TEXT_TYPE);
                        intent2.putExtra("android.intent.extra.SUBJECT", getResources().getString(R.string.app_name));
                        if (BuildConfig.FLAVOR.equalsIgnoreCase("Lawlegends")) {
                            intent2.putExtra("android.intent.extra.TEXT", "\nWelcome to Law Legends App. This application provides you Query Solutions with (800+) Video Library, Articles, Recent updates to helps our professional friends like CA's, Tax  Consultants, and  Accountants for doing smart work. It is an eminent app with 100% accuracy. Download the app Now :  https://play.google.com/store/apps/details?id=com.eduteria.app.app");
                            startActivity(Intent.createChooser(intent2, "choose one"));
                        } else {
                            intent2.putExtra("android.intent.extra.TEXT", (("\nI recommend you to learn from next-gen Smart courses. Uncover a whole new way of learning with " + getResources().getString(R.string.app_name) + ". Learn, practice & create custom tests and much more. Download ") + "https://play.google.com/store/apps/details?id=com.eduteria.app.app") + " and start learning now");
                            startActivity(Intent.createChooser(intent2, "choose one"));
                        }
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
                        SharedPreferences.Editor editorEdit = getSharedPreferences("MyPreferences", 0).edit();
                        editorEdit.clear();
                        editorEdit.apply();
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
                    startActivity(new Intent(this, (Class<?>) TestReportActivity.class));
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 29:
                    startActivity(new Intent(this, (Class<?>) CoursesListActivity.class));
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 30:
                    Intent intent11 = new Intent(this, (Class<?>) UserAttendanceActivity.class);
                    intent11.putExtra("title_key", "Download");
                    startActivity(intent11);
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 31:
                    startActivity(new Intent(this, (Class<?>) ChangeLanguageActivity.class));
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 32:
                    startActivity(new Intent(this, (Class<?>) TimeTableActivity.class));
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 33:
                    Intent intent12 = new Intent(this, (Class<?>) WebViewActivtyNew.class);
                    if (Helper.getVersionName(this).equalsIgnoreCase("1.5.3 - Preprod") || Helper.getVersionName(this).equalsIgnoreCase("1.5.3 - Staging")) {
                        intent12.putExtra("url", "https://narayna.videocrypt.in/preprod/web/profile/student_result_android/");
                    } else {
                        intent12.putExtra("url", "https://narayanatalent.com/web/profile/student_result_android/");
                    }
                    intent12.putExtra("file_type", "cumulative_url");
                    intent12.putExtra("title", "Cumulative Test Report");
                    Helper.gotoActivity(intent12, this);
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 34:
                    startActivity(new Intent(this, (Class<?>) Noticeboard.class));
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 35:
                    startActivity(new Intent(this, (Class<?>) DoubtsActivity.class));
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 36:
                    if (SharedPreference.getInstance().getString(Const.PREFERENCE_SELECTION_TYPE) != null && SharedPreference.getInstance().getString(Const.PREFERENCE_SELECTION_TYPE).equalsIgnoreCase("1")) {
                        Intent intent13 = new Intent(this, (Class<?>) IntroActivity.class);
                        intent13.putExtra("is_from_home", Const.HOME);
                        startActivity(intent13);
                    } else if (Helper.isNewLoginFlow()) {
                        if (!getDivisionActualList().isEmpty()) {
                            if (SharedPreference.getInstance().getString(Const.SHOW_STUDENT_CLASS) != null && SharedPreference.getInstance().getString(Const.SHOW_STUDENT_CLASS).equalsIgnoreCase("1")) {
                                SelectDivisionClassFragment selectDivisionClassFragment = new SelectDivisionClassFragment(this, true, false);
                                selectDivisionClassFragment.show(getSupportFragmentManager(), selectDivisionClassFragment.getTag());
                            } else {
                                Toast.makeText(this, "Permission not enabled!", 0).show();
                            }
                        } else {
                            Toast.makeText(this, "Preference data not found!", 0).show();
                        }
                    } else {
                        startActivity(new Intent(this, (Class<?>) CategoryActivity.class));
                    }
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 37:
                    Intent intent14 = new Intent(this, (Class<?>) ContactUsPage.class);
                    intent14.putExtra("from", Constants.LEFT_NAV_KEY.contact_us_query);
                    startActivity(intent14);
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 38:
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    if (this.leftMenu.getBook_store_link() != null && !this.leftMenu.getBook_store_link().equalsIgnoreCase("")) {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.leftMenu.getBook_store_link())));
                        break;
                    }
                    break;
                case 39:
                    Intent intent15 = new Intent(this, (Class<?>) CustomPaymentActivity.class);
                    intent15.putExtra("type", "Custom Payment");
                    intent15.putExtra("courseid", this.leftMenu.getCustom_course());
                    Helper.gotoActivity(intent15, this);
                    break;
                case 40:
                    Intent intent16 = new Intent(this, (Class<?>) PurchaseHistory.class);
                    intent16.putExtra("type", "2");
                    startActivity(intent16);
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 41:
                    Intent intent17 = new Intent(this, (Class<?>) ScannerActivity.class);
                    intent17.putExtra("isIsbn", false);
                    startActivityForResult(intent17, 1232);
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
            }
        }
    }

    public void getLogoutDialog(final Activity ctx, final String title, final String message) {
        DialogUtils.makeDialog(this, title, message, getResources().getString(R.string.yes), getResources().getString(R.string.no), true, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda42
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
            public final void onOKClick() {
                this.f$0.lambda$getLogoutDialog$25();
            }
        }, new DialogUtils.onDialogUtilsCancelClick() { // from class: com.appnew.android.Theme.DashboardActivityTheme1.15
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsCancelClick
            public void onCancelClick() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getLogoutDialog$25() {
        if (Helper.isConnected(this)) {
            UserLogout();
        } else {
            Toast.makeText(this, getResources().getString(R.string.no_internet_connection), 0).show();
        }
    }

    public void UserLogout() {
        this.networkCall.NetworkAPICall(API.user_logout, "", false, false);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.utkashRoom = null;
    }

    @Override // com.appnew.android.Theme.Adapter.DashboardTabAdapter.addDashboardItemClicked
    public void onDashboardItemClicked(int position1, String course_id) {
        Iterator<CourseTypeMasterTable> it = this.courseTypeMasterTables.iterator();
        int i = -1;
        while (it.hasNext()) {
            i++;
            if (it.next().getId().equalsIgnoreCase(course_id)) {
                break;
            }
        }
        if (!Helper.isNetworkConnected(this)) {
            Toast.makeText(homeactivitytheme1, "Internet Not Connected!!!", 0).show();
            return;
        }
        Bundle bundle = new Bundle();
        List<CourseTypeMasterTable> list = this.courseTypeMasterTables;
        if (list != null && list.get(i).getCat_type().equalsIgnoreCase("8") && this.courseTypeMasterTables.get(i).getWeblink_url() != null) {
            Intent intent = new Intent(this, (Class<?>) WebViewActivty.class);
            intent.putExtra("url", this.courseTypeMasterTables.get(i).getWeblink_url());
            intent.putExtra("type", this.courseTypeMasterTables.get(i).getName());
            startActivity(intent);
            return;
        }
        List<CourseTypeMasterTable> list2 = this.courseTypeMasterTables;
        if (list2 != null && list2.get(i).getCat_type().equalsIgnoreCase("3") && this.courseTypeMasterTables.get(i).getName().equalsIgnoreCase("Book Store") && this.isBookStore) {
            Intent intent2 = new Intent(this, (Class<?>) WebViewActivty.class);
            intent2.putExtra("url", this.book_store_link);
            startActivity(intent2);
            return;
        }
        List<CourseTypeMasterTable> list3 = this.courseTypeMasterTables;
        if (list3 != null && list3.get(i).getName().equalsIgnoreCase(Const.FEEDS)) {
            Data loggedInUser = SharedPreference.getInstance().getLoggedInUser();
            if (loggedInUser != null && loggedInUser.getPreferences() != null && loggedInUser.getPreferences().size() > 0) {
                Helper.gotoActivity(new Intent(this, (Class<?>) FeedsActivity.class), this);
                return;
            } else {
                Helper.gotoActivity(new Intent(this, (Class<?>) IntroActivity.class), this);
                return;
            }
        }
        List<CourseTypeMasterTable> list4 = this.courseTypeMasterTables;
        if (list4 != null && list4.get(i).getView_type().equalsIgnoreCase("4")) {
            Intent intent3 = new Intent(this, (Class<?>) CurrentAffairActivity.class);
            intent3.putExtra("title_key", "Current Affairs");
            startActivity(intent3);
            overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
            return;
        }
        if (TextUtils.isEmpty(this.courseTypeMasterTables.get(i).getCourse_id()) || this.courseTypeMasterTables.get(i).getCourse_id().equalsIgnoreCase("0")) {
            bundle.putInt(Const.NOTIFICATION_CODE, this.notification_code);
            bundle.putString("course_id", course_id);
            bundle.putString("file_id", this.fieldid);
            bundle.putString(Const.TOPIC_ID, this.topicid);
            bundle.putString("tile_id", this.tileid);
            bundle.putString(Const.TILE_TYPE, this.tiletype);
            bundle.putString(Const.REVERT_API, this.revertapi);
            if (!GenericUtils.isListEmpty(this.courseTypeMasterTables)) {
                bundle.putString("title", this.courseTypeMasterTables.get(i).getName());
            } else {
                bundle.putString("title", "");
            }
            bundle.putString(TypedValues.AttributesType.S_TARGET, this.message_target);
            bundle.putString("searchenable", this.courseTypeMasterTables.get(i).getDisplay_type());
            bundle.putString("course_description", this.courseTypeMasterTables.get(i).getDescription());
            bundle.putString("cart_text_color", this.courseTypeMasterTables.get(i).getSec_color());
            bundle.putString("cart_bg_color", this.courseTypeMasterTables.get(i).getSec_bg_color());
            bundle.putString("url", this.url);
            bundle.putString("image", this.imageUrl);
            bundle.putString("message", this.message);
            if (!BuildConfig.FLAVOR.equalsIgnoreCase("banglaguru")) {
                bundle.putSerializable("master_cat", (Serializable) this.masterAllCatTables);
            }
            if (!GenericUtils.isListEmpty(this.courseTypeMasterTables) && !GenericUtils.isEmpty(this.courseTypeMasterTables.get(i).getCat_type())) {
                bundle.putString(Const.IS_BOOK, this.courseTypeMasterTables.get(i).getCat_type());
            } else {
                bundle.putString(Const.IS_BOOK, "0");
            }
            if (!GenericUtils.isListEmpty(this.courseTypeMasterTables)) {
                bundle.putString(Const.TAB_ID, this.courseTypeMasterTables.get(i).getId());
            } else {
                bundle.putString(Const.TAB_ID, "1");
            }
            if (this.courseTypeMasterTables.size() > 1) {
                bundle.putString(Const.TAB_NAME, this.courseTypeMasterTables.get(i).getName());
            } else {
                bundle.putString(Const.TAB_NAME, "");
            }
            if (!GenericUtils.isListEmpty(this.courseTypeMasterTables) && !GenericUtils.isEmpty(this.courseTypeMasterTables.get(i).getMaster_category_id())) {
                bundle.putString(Const.MASTER_CATEGORY_ID, this.courseTypeMasterTables.get(i).getMaster_category_id());
            } else {
                bundle.putString(Const.MASTER_CATEGORY_ID, "0");
            }
            if (!GenericUtils.isListEmpty(this.mastercatlist)) {
                String master_category_id = this.courseTypeMasterTables.get(i).getMaster_category_id();
                ArrayList arrayList = new ArrayList();
                new ArrayList();
                if (!GenericUtils.isListEmpty(this.masterAllCatTables)) {
                    for (MasteAllCatTable masteAllCatTable : this.masterAllCatTables) {
                        if (masteAllCatTable.getMaster_type().equals(master_category_id) && masteAllCatTable.getParent_id().equals("0")) {
                            arrayList.add(masteAllCatTable);
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    MakeMyExam.setTileData(new Gson().toJson(arrayList));
                }
                List<MasteAllCatTable> list5 = this.masterAllCatTables;
                if (list5 != null && list5.size() > 0) {
                    MakeMyExam.setTileData2(new Gson().toJson(this.masterAllCatTables));
                }
            }
            if (Arrays.asList("1", "2").contains(this.courseTypeMasterTables.get(i).getDisplay_type())) {
                startActivity(new Intent(this, (Class<?>) CourseTypeActivity.class).putExtras(bundle));
            } else {
                startActivity(new Intent(this, (Class<?>) HomeActivity.class).putExtras(bundle));
            }
        } else if (this.courseTypeMasterTables.get(i).getName().equalsIgnoreCase("Extra Classes")) {
            startActivity(new Intent(this, (Class<?>) ExtraClassesActivity.class).putExtra("title", this.courseTypeMasterTables.get(i).getName()));
        } else {
            Intent intent4 = new Intent(this, (Class<?>) CourseActivity.class);
            intent4.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
            intent4.putExtra(Const.COURSE_ID_MAIN, this.courseTypeMasterTables.get(i).getCourse_id());
            intent4.putExtra(Const.COURSE_PARENT_ID, "");
            intent4.putExtra(Const.IS_COMBO, false);
            intent4.putExtra(AnalyticsConstants.course_name, this.courseTypeMasterTables.get(i).getName());
            Helper.gotoActivity(intent4, this);
            if (this.courseTypeMasterTables != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("AndroidCourseTypeMasterId", this.courseTypeMasterTables.get(i).getCourse_id());
                bundle2.putString("AndroidCourseTypeMasterName", this.courseTypeMasterTables.get(i).getName());
                FacebookEventLogger.logUserLogin(this, Helper.getLoggedInUserInfo(this));
            }
        }
        if (this.courseTypeMasterTables != null) {
            Bundle bundle3 = new Bundle();
            bundle3.putString("AndroidCourseTypeMasterId", this.courseTypeMasterTables.get(i).getCourse_id());
            bundle3.putString("AndroidCourseTypeMasterName", this.courseTypeMasterTables.get(i).getName());
            FacebookEventLogger.logUserLogin(this, Helper.getLoggedInUserInfo(this));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if (requestCode == 1232 && resultCode == -1 && data != null) {
                if (data != null) {
                    if (data.hasExtra("code")) {
                        try {
                            JSONObject jSONObject = new JSONObject(data.getStringExtra("code"));
                            if (jSONObject.has("test_code") && jSONObject.has(Const.TESTSERIES_ID)) {
                                return;
                            }
                            Toast.makeText(homeactivitytheme1, "Scan valid QR code", 0).show();
                            return;
                        } catch (JSONException unused) {
                            Toast.makeText(homeactivitytheme1, "Scan valid QR code", 0).show();
                            return;
                        }
                    }
                    Toast.makeText(homeactivitytheme1, "Scan valid QR code", 0).show();
                    return;
                }
                return;
            }
            if (requestCode == 1203 && resultCode == -1 && data != null) {
                String strCopyFileToInternalStorage = copyFileToInternalStorage(data.getData(), "SubjectiveTestPDF");
                Helper.GoToWebViewPDFActivity(this, Constants.SUB_TEST_ID, strCopyFileToInternalStorage, false, strCopyFileToInternalStorage.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r2.length - 1], this.course_id + MqttTopic.MULTI_LEVEL_WILDCARD + Constants.SUB_TEST_ID, true, "CourseActivity", true);
            }
            if (requestCode == 1000 && data != null && resultCode == 1000 && data.getBooleanExtra("fromDownloads", false)) {
                refreshApiFromDownloads();
            }
        } catch (Exception e2) {
            Toast.makeText(this, R.string.unable_to_upload_this_file, 0).show();
            e2.printStackTrace();
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
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return file.getPath();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (this.isFeedsClicked) {
            this.isFeedsClicked = false;
            this.binding.dashBoardMain.scrollView.setVisibility(0);
            this.binding.dashBoardMain.feedsLl.setVisibility(8);
            this.toggle.setDrawerIndicatorEnabled(true);
            this.binding.dashBoardMain.homeBackIV.setVisibility(8);
            this.binding.dashBoardMain.cvrHeaderKrantikari.setVisibility(0);
            return;
        }
        if (this.backstatus) {
            if (this.backPressed + 3000 > System.currentTimeMillis()) {
                getIntent().setData(null);
                finishAndRemoveTask();
                return;
            } else {
                this.backPressed = System.currentTimeMillis();
                Helper.showSnackBar(this.binding.drawerLayout, getResources().getString(R.string.press_again_to_exit));
                return;
            }
        }
        if (this.backPressed + 3000 > System.currentTimeMillis()) {
            getIntent().setData(null);
            finishAndRemoveTask();
        } else {
            this.backPressed = System.currentTimeMillis();
            Helper.showSnackBar(this.binding.drawerLayout, getResources().getString(R.string.press_again_to_exit));
        }
    }

    public void initialzehomepage() {
        try {
            try {
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
                                    this.courseTypeMasterTables.addAll(this.utkashRoom.getcoursetypemaster().getcourse_typemaster(MakeMyExam.userId));
                                    this.masterAllCatTables = this.utkashRoom.getMasterAllCatDao().getmaster_allcat(MakeMyExam.userId);
                                    this.mastercatlist = this.utkashRoom.getMastercatDao().getmastercat(MakeMyExam.userId);
                                    this.bannerListTables = this.utkashRoom.getBannerTableDao().getBanner(MakeMyExam.getUserId());
                                    this.bottomMenuTables = this.utkashRoom.getBottomMenuTableDao().getBottomMenu(MakeMyExam.getUserId());
                                }
                                runOnUiThread(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda31
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f$0.lambda$initialzehomepage$26();
                                    }
                                });
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        } else if (this.hitMaster) {
                            this.hitMaster = false;
                            this.networkCall.NetworkAPICall(API.master_content, "", true, false);
                        }
                    }
                    this.notification_code = 0;
                }
            } catch (Exception e3) {
                Log.e("DatabaseHelper", "Unhandled Exception: " + e3.getMessage());
            }
        } catch (SQLiteDiskIOException e4) {
            Log.e("DatabaseHelper", "SQLiteDiskIOException during onUpgrade: " + e4.getMessage());
        } catch (SQLiteFullException e5) {
            Log.e("DatabaseHelper", "SQLiteFullException during onUpgrade: " + e5.getMessage());
        } catch (IllegalStateException e6) {
            Log.e("DatabaseHelper", "IllegalStateException (DB closed): " + e6.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initialzehomepage$26() {
        if (this.leftMenu.getMaster_category_style() != null && this.leftMenu.getMaster_category_style().equalsIgnoreCase("0")) {
            this.binding.dashBoardMain.tabsRV.setNestedScrollingEnabled(false);
            this.binding.dashBoardMain.tabsRV.addItemDecoration(new GridSpacingItemDecoration(2, 15, false));
            this.dashboardSquareTileTabAdapter.notifyDataSetChanged();
            this.binding.dashBoardMain.tabsRV.setAdapter(this.dashboardSquareTileTabAdapter);
        } else if (this.leftMenu.getMaster_category_style() != null && this.leftMenu.getMaster_category_style().equalsIgnoreCase("2")) {
            this.binding.dashBoardMain.tabsRV.setNestedScrollingEnabled(false);
            this.binding.dashBoardMain.tabsRV.addItemDecoration(new GridSpacingItemDecoration(2, 20, false));
            this.dashboardRectTileTabAdapter.notifyDataSetChanged();
            this.binding.dashBoardMain.tabsRV.setAdapter(this.dashboardRectTileTabAdapter);
        } else {
            LeftMenu leftMenu = this.leftMenu;
            if (leftMenu != null && leftMenu.getMaster_category_style() != null && this.leftMenu.getMaster_category_style().equalsIgnoreCase("3")) {
                this.gridLayoutManager = new GridLayoutManager(this, 3);
                if (this.binding.dashBoardMain != null) {
                    this.binding.dashBoardMain.tabsRV.setLayoutManager(this.gridLayoutManager);
                }
                this.binding.dashBoardMain.tabsRV.setNestedScrollingEnabled(false);
                this.binding.dashBoardMain.tabsRV.addItemDecoration(new GridSpacingItemDecoration(3, 15, false));
                this.dashboardSquareTileTabAdapter.notifyDataSetChanged();
                this.binding.dashBoardMain.tabsRV.setAdapter(this.dashboardSquareTileTabAdapter);
            } else {
                this.binding.dashBoardMain.tabsRV.setNestedScrollingEnabled(false);
                this.binding.dashBoardMain.tabsRV.addItemDecoration(new GridSpacingItemDecoration(2, 15, false));
                this.dashboardTabAdapter.notifyDataSetChanged();
                this.binding.dashBoardMain.tabsRV.setAdapter(this.dashboardTabAdapter);
            }
        }
        ArrayList<BannerListTable> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        new ArrayList();
        if (this.utkashRoom.getBannerTableDao() != null && this.utkashRoom.getBannerTableDao().getBanner(MakeMyExam.userId) != null && this.utkashRoom.getBannerTableDao().getBanner(MakeMyExam.userId).size() > 0) {
            arrayList.addAll(this.utkashRoom.getBannerTableDao().getBanner(MakeMyExam.userId));
        }
        for (BannerListTable bannerListTable : arrayList) {
            if (bannerListTable.getBanner_location().equalsIgnoreCase("6")) {
                arrayList2.add(bannerListTable);
            }
        }
        this.binding.dashBoardMain.bannerSlider.setLayoutManager(new LinearLayoutManager(this));
        this.binding.dashBoardMain.bannerSlider.setAdapter(new FeedViewPagerAdapter(this, this, arrayList2));
        if (this.binding.dashBoardMain.bannerSlider.getAdapter().getItemCount() > 0) {
            this.binding.dashBoardMain.noDataFoundRL1.setVisibility(8);
        } else {
            this.binding.dashBoardMain.noDataFoundRL1.setVisibility(0);
        }
        selectedData();
        automateViewPagerSwiping();
        automateBottomViewPagerSwiping();
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
        if (BuildConfig.FLAVOR.equalsIgnoreCase("Narayana")) {
            intent2.putExtra(Const.COURSE_PARENT_ID, this.parentid);
        } else {
            intent2.putExtra(Const.COURSE_PARENT_ID, "");
        }
        intent2.putExtra(Const.IS_COMBO, false);
        intent2.putExtra(Const.COMBO_ID, this.combo_id);
        startActivity(intent2);
        SharedPreference.getInstance().putString("maincourseid", "");
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
            if (video.getMode().equalsIgnoreCase("1")) {
                Toast.makeText(homeactivitytheme1, "You can attempt the test offline from your test center", 0).show();
            } else {
                hit_api_for_iniializetest();
            }
        }
    }

    private void initLivevideo(Video video) {
        int i = this.notification_code;
        boolean z = false;
        if (i != 90002 && i != 20009) {
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
            if (i != 124) {
                if (i == 11110) {
                    if (MusicService.INSTANCE.isAudioPlaying()) {
                        Intent intent3 = new Intent(this, (Class<?>) MusicService.class);
                        intent3.setAction("Stop_Service");
                        startService(intent3);
                    }
                    Intent intent4 = new Intent(this, (Class<?>) AudioPlayerActivity.class);
                    intent4.putExtra("video", video);
                    startActivity(intent4);
                    return;
                }
                return;
            }
            if (video.getIs_locked().equalsIgnoreCase("1")) {
                String str2 = this.parentid;
                if (str2 == null || str2.equalsIgnoreCase("")) {
                    Intent intent5 = new Intent(this, (Class<?>) CourseActivity.class);
                    intent5.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent5.putExtra(Const.COURSE_ID_MAIN, video.getPayloadData().getCourse_id());
                    intent5.putExtra(Const.COURSE_PARENT_ID, "");
                    intent5.putExtra(Const.IS_COMBO, false);
                    SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                    Helper.gotoActivity(intent5, this);
                    return;
                }
                Intent intent6 = new Intent(this, (Class<?>) CourseActivity.class);
                intent6.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                intent6.putExtra(Const.COURSE_ID_MAIN, this.parentid);
                intent6.putExtra(Const.COURSE_PARENT_ID, "");
                intent6.putExtra(Const.IS_COMBO, false);
                SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                Helper.gotoActivity(intent6, this);
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
                Intent intent7 = new Intent(this, (Class<?>) Concept_newActivity.class);
                intent7.putExtra("id", video.getId());
                intent7.putExtra("name", video.getTitle());
                if (this.parentid == null) {
                    this.parentid = "";
                }
                if (this.parentid.equalsIgnoreCase("")) {
                    intent7.putExtra("course_id", video.getPayloadData().getCourse_id() + MqttTopic.MULTI_LEVEL_WILDCARD);
                } else {
                    intent7.putExtra("course_id", this.parentid + MqttTopic.MULTI_LEVEL_WILDCARD + video.getPayloadData().getCourse_id());
                }
                intent7.putExtra("tile_id", video.getPayloadData().getTile_id());
                Helper.gotoActivity(intent7, this);
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
        if (video.getFile_type().equalsIgnoreCase("3")) {
            if (video.getIs_locked().equalsIgnoreCase("1")) {
                String str3 = this.parentid;
                if (str3 == null || str3.equalsIgnoreCase("")) {
                    Intent intent8 = new Intent(this, (Class<?>) CourseActivity.class);
                    intent8.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent8.putExtra(Const.COURSE_ID_MAIN, video.getPayloadData().getCourse_id());
                    intent8.putExtra(Const.COURSE_PARENT_ID, "");
                    intent8.putExtra(Const.IS_COMBO, false);
                    SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                    startActivity(intent8);
                    return;
                }
                Intent intent9 = new Intent(this, (Class<?>) CourseActivity.class);
                intent9.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                intent9.putExtra(Const.COURSE_ID_MAIN, this.course_id);
                intent9.putExtra(Const.COURSE_PARENT_ID, this.parentid);
                intent9.putExtra(Const.IS_COMBO, false);
                SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                startActivity(intent9);
                return;
            }
            if (video.getVideo_type().equalsIgnoreCase("7")) {
                if (video.getIs_drm().equals("0")) {
                    if (video.getId() == null || video.getId().equalsIgnoreCase("")) {
                        Toast.makeText(this, getResources().getString(R.string.url_is_not_found), 0).show();
                        initialzehomepage();
                        return;
                    } else {
                        Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), this, video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "0", SingleStudy.parentCourseId, video.getStart_date(), Helper.addToList(video));
                        return;
                    }
                }
                if (video.getIs_drm().equals("1")) {
                    if (video.getId() == null || video.getId().equalsIgnoreCase("")) {
                        Toast.makeText(this, getResources().getString(R.string.url_is_not_found), 0).show();
                        initialzehomepage();
                        return;
                    } else {
                        Helper.GoToVideoCryptActivity(this, video.getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), video.getVideo_type(), video.getChat_node(), video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "0", SingleStudy.parentCourseId, video.getStart_date(), video.getIs_bookmarked(), Helper.addToList(video));
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
                            Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), this, video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "0", SingleStudy.parentCourseId, video.getStart_date(), Helper.addToList(video));
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
                            Helper.GoToVideoCryptActivity(this, video.getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), video.getVideo_type(), video.getChat_node(), video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "0", SingleStudy.parentCourseId, video.getStart_date(), video.getIs_bookmarked(), Helper.addToList(video));
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
                            Intent intent10 = new Intent(this, (Class<?>) ZoomRecodedPlayer.class);
                            intent10.putExtra("videoUrl", video.getFile_url());
                            intent10.putExtra(Const.VIDEO_ID, video.getId());
                            intent10.putExtra("bookmark", video.getIs_bookmarked());
                            startActivity(intent10);
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
                if (video.getLive_status().equalsIgnoreCase("0")) {
                    Toast.makeText(this, getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                    initialzehomepage();
                    return;
                }
                if (video.getLive_status().equalsIgnoreCase("1")) {
                    Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), this, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "0", this.parentid, video.getStart_date(), Helper.addToList(video));
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
                Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), this, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), "0", this.parentid, video.getStart_date(), Helper.addToList(video));
                return;
            }
            if (video.getIs_locked().equalsIgnoreCase("1")) {
                String str6 = this.parentid;
                if (str6 == null || str6.equalsIgnoreCase("")) {
                    Intent intent15 = new Intent(this, (Class<?>) CourseActivity.class);
                    intent15.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent15.putExtra(Const.COURSE_ID_MAIN, video.getPayloadData().getCourse_id());
                    intent15.putExtra(Const.COURSE_PARENT_ID, "");
                    intent15.putExtra(Const.IS_COMBO, false);
                    SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                    startActivity(intent15);
                    return;
                }
                Intent intent16 = new Intent(this, (Class<?>) CourseActivity.class);
                intent16.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                intent16.putExtra(Const.COURSE_ID_MAIN, this.parentid);
                intent16.putExtra(Const.COURSE_PARENT_ID, "");
                intent16.putExtra(Const.IS_COMBO, false);
                SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                startActivity(intent16);
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
                        Helper.GoToLiveVideoActivity(video.getChat_node(), this, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getIs_chat_lock(), video.getPayloadData().getCourse_id(), "0", this.parentid, video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), Helper.addToList(video));
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
                    Helper.GoToLiveVideoActivity(video.getChat_node(), this, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getIs_chat_lock(), video.getPayloadData().getCourse_id(), "0", this.parentid, video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), Helper.addToList(video));
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
            Intent intent17 = new Intent(this, (Class<?>) Concept_newActivity.class);
            intent17.putExtra("id", video.getId());
            intent17.putExtra("name", video.getTitle());
            if (this.parentid == null) {
                this.parentid = "";
            }
            if (this.parentid.equalsIgnoreCase("")) {
                intent17.putExtra("course_id", video.getPayloadData().getCourse_id() + MqttTopic.MULTI_LEVEL_WILDCARD);
            } else {
                intent17.putExtra("course_id", this.parentid + MqttTopic.MULTI_LEVEL_WILDCARD + video.getPayloadData().getCourse_id());
            }
            intent17.putExtra("tile_id", video.getPayloadData().getTile_id());
            Helper.gotoActivity(intent17, this);
            return;
        }
        if (video.getFile_type().equalsIgnoreCase("1")) {
            if (!TextUtils.isEmpty(video.getIs_download_available()) && video.getIs_download_available().equalsIgnoreCase("1")) {
                z = true;
            }
            boolean z2 = z;
            String str7 = this.parentid;
            if (str7 == null || str7.equalsIgnoreCase("")) {
                Helper.GoToWebViewPDFActivity(this, video.getId(), video.getFile_url(), z2, video.getTitle(), video.getPayloadData().getCourse_id() + MqttTopic.MULTI_LEVEL_WILDCARD + video.getPayloadData().getCourse_id(), video.getIs_share());
            } else {
                Helper.GoToWebViewPDFActivity(this, video.getId(), video.getFile_url(), z2, video.getTitle(), this.parentid + MqttTopic.MULTI_LEVEL_WILDCARD + video.getPayloadData().getCourse_id(), video.getIs_share());
            }
        }
    }

    private void hit_api_for_courseReview() {
        if (SharedPreference.getInstance().getString(Const.SHOW_APP_REVIEW).equalsIgnoreCase("1")) {
            this.networkCall.NetworkAPICall(API.COURSE_REVIEW_LIST, "", false, false);
        }
    }

    private void hit_api_for_data() {
        this.networkCall.NetworkAPICall(API.API_GET_MASTER_DATA, this.contentType, true, false);
    }

    private void hit_api_for_iniializetest() {
        this.networkCall.NetworkAPICall(API.API_GET_TEST_INSTRUCTION_DATA, "", true, false);
    }

    private void hit_api_folder_list() {
        this.networkCall.NetworkAPICall(API.get_folder_list, this.contentType, true, false);
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
                if (videoArrayList.get(0).getMode().equalsIgnoreCase("1")) {
                    Toast.makeText(homeactivitytheme1, "You can attempt the test offline from your test center", 0).show();
                    return;
                } else {
                    hit_api_for_iniializetest();
                    return;
                }
            }
            if (videoArrayList.get(0).getState().equalsIgnoreCase("1")) {
                this.first_attempt = "";
            } else {
                this.first_attempt = "1";
            }
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
                if (videoArrayList.get(0).getMode().equalsIgnoreCase("1")) {
                    Toast.makeText(homeactivitytheme1, "You can attempt the test offline from your test center", 0).show();
                    return;
                } else {
                    hit_api_for_iniializetest();
                    return;
                }
            }
            Intent intent5 = new Intent(this, (Class<?>) QuizActivity.class);
            intent5.putExtra(Const.FRAG_TYPE, "leader_board");
            intent5.putExtra("status", videoArrayList.get(0).getId());
            intent5.putExtra("name", videoArrayList.get(0).getTest_series_name());
            Helper.gotoActivity(intent5, this);
        }
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
        if (testBasic.getMulti_description() != null && testBasic.getMulti_description().size() > 0) {
            linearLayout2.setVisibility(0);
            if (testBasic.getMulti_description().size() > 0) {
                textView8.setText(Html.fromHtml(testBasic.getMulti_description().get(0).getDescription()));
            }
        } else if (testBasic.getDescription().isEmpty()) {
            linearLayout2.setVisibility(8);
        } else {
            linearLayout2.setVisibility(0);
            textView8.setVisibility(0);
            textView8.setText(Html.fromHtml(testBasic.getDescription()));
        }
        if (testBasic.getLang_id().length() > 1) {
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda44
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$showPopUp$27(textView5, testBasic, textView8, view);
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
        if (!testBasic.getDescription().isEmpty()) {
            linearLayout2.setVisibility(0);
            textView8.setText(Html.fromHtml(testBasic.getDescription()));
        }
        textView4.setText("" + instructionData.getTestSections().size());
        Button button3 = button;
        button3.setTag(testBasic);
        final CheckBox checkBox3 = checkBox;
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme1.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (testBasic.getTotalQuestions().equalsIgnoreCase("0")) {
                    DashboardActivityTheme1 dashboardActivityTheme1 = DashboardActivityTheme1.this;
                    Toast.makeText(dashboardActivityTheme1, dashboardActivityTheme1.getResources().getString(R.string.please_add_question), 0).show();
                } else {
                    if (checkBox3.isChecked()) {
                        dialog.dismiss();
                        DashboardActivityTheme1.this.quiz_id = testBasic.getId();
                        DashboardActivityTheme1 dashboardActivityTheme12 = DashboardActivityTheme1.this;
                        new NetworkCall(dashboardActivityTheme12, dashboardActivityTheme12).NetworkAPICall(API.API_GET_INFO_TEST_SERIES, "", true, false);
                        return;
                    }
                    DashboardActivityTheme1 dashboardActivityTheme13 = DashboardActivityTheme1.this;
                    Toast.makeText(dashboardActivityTheme13, dashboardActivityTheme13.getResources().getString(R.string.please_check_following_instructions), 0).show();
                }
            }
        });
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda45
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return this.f$0.lambda$showPopUp$28(dialog, dialogInterface, i, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$showPopUp$28(Dialog dialog, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return true;
        }
        initialzehomepage();
        dialog.dismiss();
        return true;
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

    /* JADX INFO: renamed from: showPopMenuForLangauge, reason: merged with bridge method [inline-methods] */
    public void lambda$showPopUp$27(final View v, final TestBasicInst testBasicInst, final TextView v1, TextView vvv) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme1.17
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem item) {
                ((TextView) v).setText(item.getTitle().toString());
                try {
                    if (item.getTitle().toString().equals(DashboardActivityTheme1.this.getResources().getString(R.string.hindi))) {
                        DashboardActivityTheme1.this.lang = 2;
                        if (testBasicInst.getMulti_description() != null && testBasicInst.getMulti_description().get(1).getDescription() != null) {
                            v1.setText(Html.fromHtml(testBasicInst.getMulti_description().get(1).getDescription()));
                        }
                    } else if (item.getTitle().toString().equals(DashboardActivityTheme1.this.getResources().getString(R.string.english))) {
                        DashboardActivityTheme1.this.lang = 1;
                        if (testBasicInst.getMulti_description() != null && testBasicInst.getMulti_description().get(0).getDescription() != null) {
                            v1.setText(Html.fromHtml(testBasicInst.getMulti_description().get(0).getDescription()));
                        }
                    }
                } catch (Exception unused) {
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

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.isLiveApiInProgress = false;
        detachLiveListener();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        this.databaseReference = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/live_class_status/");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        String simpleName = getClass().getSimpleName();
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME, simpleName);
        FacebookEventLogger.logEvent(this, "Screen_Viewed", bundle);
        if (SharedPreference.getInstance().getString(Const.dashboard_TrendingCourses).equalsIgnoreCase("1")) {
            getCourseData(false);
        }
        Constants.IS_FROM_LIBRARY = false;
        CartCountRefresh();
        if (this.utkashRoom == null) {
            UtkashRoom appDatabase = UtkashRoom.getAppDatabase(this);
            this.utkashRoom = appDatabase;
            appDatabase.getOpenHelper().getWritableDatabase().enableWriteAheadLogging();
        }
        homeAutoRefresh();
        try {
            Data loggedInUser = SharedPreference.getInstance().getLoggedInUser();
            if (loggedInUser.getProfilePicture() != null) {
                this.binding.profileImage.setVisibility(0);
                Glide.with((FragmentActivity) this).load(loggedInUser.getProfilePicture()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.course_placeholder)).into(this.binding.profileImage);
            } else {
                this.binding.profileImage.setVisibility(0);
                this.binding.profileImageText.setVisibility(8);
                this.binding.profileImage.setImageResource(R.mipmap.default_pic);
            }
            if (!TextUtils.isEmpty(loggedInUser.getName()) && !TextUtils.isEmpty(loggedInUser.getMobile())) {
                this.binding.profileName.setText(loggedInUser.getName());
                this.binding.profileEmail.setText(loggedInUser.getMobile());
            } else if (!TextUtils.isEmpty(loggedInUser.getName()) && !TextUtils.isEmpty(loggedInUser.getEmail())) {
                ((TextView) Objects.requireNonNull(this.binding.profileName)).setText(loggedInUser.getName());
                ((TextView) Objects.requireNonNull(this.binding.profileEmail)).setText(loggedInUser.getEmail());
            } else {
                this.binding.profileName.setText(getResources().getString(R.string.user));
                this.binding.profileEmail.setText(getResources().getString(R.string.user_mail));
            }
            if (SharedPreference.getInstance().getString(Const.IS_RECENT_WATCH).equalsIgnoreCase("1") && SharedPreference.getInstance().getString(Const.IS_RECENT_REFRESH).equalsIgnoreCase("1")) {
                SharedPreference.getInstance().putString(Const.IS_RECENT_REFRESH, "");
                new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme1.18
                    @Override // java.lang.Runnable
                    public void run() {
                        DashboardActivityTheme1.this.hitRecentWatchApi();
                    }
                }, 800L);
            }
            if (PreferencesUtil.INSTANCE.getStringPreference(this, Const.SUBJECTIVE_TEST_UPLOADED).equalsIgnoreCase("1")) {
                this.quizBasicInfoDialog.dismiss();
                hit_api_for_data();
                PreferencesUtil.INSTANCE.removePreference(this, Const.SUBJECTIVE_TEST_UPLOADED);
            }
        } catch (Exception unused) {
        }
        if (SharedPreference.getInstance().getString(Const.RELOADHOME).equalsIgnoreCase("true")) {
            this.networkCall.NetworkAPICall(API.master_content, "", true, false);
            SharedPreference.getInstance().putString(Const.RELOADHOME, "false");
        }
        initListeners(this);
        if (Helper.isDashboardLiveClass()) {
            getFirebaseData();
        }
        SingleStudy.parentCourseId = "";
    }

    private void refreshApiFromDownloads() {
        if (Helper.isConnected(this)) {
            new NetworkCall(this, this).NetworkAPICall(API.master_content, "", true, false);
        }
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
                                this.courseTypeMasterTables.addAll(this.utkashRoom.getcoursetypemaster().getcourse_typemaster(MakeMyExam.userId));
                                this.masterAllCatTables = this.utkashRoom.getMasterAllCatDao().getmaster_allcat(MakeMyExam.userId);
                                this.mastercatlist = this.utkashRoom.getMastercatDao().getmastercat(MakeMyExam.userId);
                                this.bannerListTables = this.utkashRoom.getBannerTableDao().getBanner(MakeMyExam.getUserId());
                                this.bottomMenuTables = this.utkashRoom.getBottomMenuTableDao().getBottomMenu(MakeMyExam.getUserId());
                            }
                            runOnUiThread(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda20
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$onRestart$29();
                                }
                            });
                        } else if (this.hitMaster) {
                            this.hitMaster = false;
                            this.networkCall.NetworkAPICall(API.master_content, "", true, false);
                        }
                    }
                } else if (!this.utkashRoom.getMasterAllCatDao().isRecordExistsUserId(MakeMyExam.userId) && this.hitMaster) {
                    this.hitMaster = false;
                    this.networkCall.NetworkAPICall(API.master_content, "", true, false);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.notification_code = 0;
            pendingPurchaseBannerUpdateList();
        } catch (Throwable th) {
            this.notification_code = 0;
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onRestart$29() {
        if (SharedPreference.getInstance().getString(Const.HORIZONTAL_COURSE).equalsIgnoreCase("1")) {
            this.binding.dashBoardMain.tabsRV.setLayoutManager(new LinearLayoutManager(this, 0, false));
            DashboardTabAdapter dashboardTabAdapter = new DashboardTabAdapter(this, this.courseTypeMasterRecyclerData, this, "0");
            this.dashboardTabAdapter = dashboardTabAdapter;
            dashboardTabAdapter.notifyDataSetChanged();
            this.binding.dashBoardMain.tabsRV.setAdapter(this.dashboardTabAdapter);
            this.binding.dashBoardMain.CourseListRV.setVisibility(0);
            this.binding.dashBoardMain.CourseListRV.setNestedScrollingEnabled(false);
            LeftMenu leftMenu = this.leftMenu;
            if (leftMenu != null && leftMenu.getMaster_category_style() != null && this.leftMenu.getMaster_category_style().equalsIgnoreCase("3")) {
                this.gridLayoutManager = new GridLayoutManager(this, 3);
                this.binding.dashBoardMain.CourseListRV.setLayoutManager(this.gridLayoutManager);
                this.binding.dashBoardMain.CourseListRV.addItemDecoration(new GridSpacingItemDecoration(3, 15, false));
                DashboardSquareTileTabAdapter dashboardSquareTileTabAdapter = new DashboardSquareTileTabAdapter(this, this.courseTypeMasterRecyclerData1, this);
                this.dashboardSquareTileTabAdapter = dashboardSquareTileTabAdapter;
                dashboardSquareTileTabAdapter.notifyDataSetChanged();
                this.binding.dashBoardMain.CourseListRV.setAdapter(this.dashboardSquareTileTabAdapter);
            } else if (this.leftMenu.getMaster_category_style() != null && this.leftMenu.getMaster_category_style().equalsIgnoreCase("2")) {
                this.gridLayoutManager = new GridLayoutManager(this, 2);
                this.binding.dashBoardMain.CourseListRV.setLayoutManager(this.gridLayoutManager);
                this.binding.dashBoardMain.CourseListRV.addItemDecoration(new GridSpacingItemDecoration(2, 20, false));
                DashboardSquareTileTabAdapter dashboardSquareTileTabAdapter2 = new DashboardSquareTileTabAdapter(this, this.courseTypeMasterRecyclerData1, this);
                this.dashboardSquareTileTabAdapter = dashboardSquareTileTabAdapter2;
                dashboardSquareTileTabAdapter2.notifyDataSetChanged();
                this.binding.dashBoardMain.CourseListRV.setAdapter(this.dashboardSquareTileTabAdapter);
            } else {
                this.gridLayoutManager = new GridLayoutManager(this, 2);
                this.binding.dashBoardMain.CourseListRV.setLayoutManager(this.gridLayoutManager);
                this.dashboardTabAdapter = new DashboardTabAdapter(this, this.courseTypeMasterRecyclerData1, this, "1");
                this.binding.dashBoardMain.CourseListRV.setNestedScrollingEnabled(false);
                this.binding.dashBoardMain.CourseListRV.addItemDecoration(new GridSpacingItemDecoration(2, 15, false));
                this.dashboardTabAdapter.notifyDataSetChanged();
                this.binding.dashBoardMain.CourseListRV.setAdapter(this.dashboardTabAdapter);
            }
        } else if (this.leftMenu.getMaster_category_style() != null && this.leftMenu.getMaster_category_style().equalsIgnoreCase("0")) {
            this.binding.dashBoardMain.tabsRV.setNestedScrollingEnabled(false);
            this.binding.dashBoardMain.tabsRV.addItemDecoration(new GridSpacingItemDecoration(2, 15, false));
            this.dashboardSquareTileTabAdapter.notifyDataSetChanged();
            this.binding.dashBoardMain.tabsRV.setAdapter(this.dashboardSquareTileTabAdapter);
        } else if (this.leftMenu.getMaster_category_style() != null && this.leftMenu.getMaster_category_style().equalsIgnoreCase("2")) {
            this.binding.dashBoardMain.tabsRV.setNestedScrollingEnabled(false);
            this.binding.dashBoardMain.tabsRV.addItemDecoration(new GridSpacingItemDecoration(2, 20, false));
            this.dashboardRectTileTabAdapter.notifyDataSetChanged();
            this.binding.dashBoardMain.tabsRV.setAdapter(this.dashboardRectTileTabAdapter);
        } else {
            LeftMenu leftMenu2 = this.leftMenu;
            if (leftMenu2 != null && leftMenu2.getMaster_category_style() != null && this.leftMenu.getMaster_category_style().equalsIgnoreCase("3")) {
                this.gridLayoutManager = new GridLayoutManager(this, 3);
                if (this.binding.dashBoardMain != null) {
                    this.binding.dashBoardMain.tabsRV.setLayoutManager(this.gridLayoutManager);
                }
                this.binding.dashBoardMain.tabsRV.setNestedScrollingEnabled(false);
                this.binding.dashBoardMain.tabsRV.addItemDecoration(new GridSpacingItemDecoration(3, 15, false));
                this.dashboardSquareTileTabAdapter.notifyDataSetChanged();
                this.binding.dashBoardMain.tabsRV.setAdapter(this.dashboardSquareTileTabAdapter);
            } else {
                LeftMenu leftMenu3 = this.leftMenu;
                if (leftMenu3 != null && leftMenu3.getMaster_category_style() != null && this.leftMenu.getMaster_category_style().equalsIgnoreCase("4")) {
                    this.gridLayoutManager = new GridLayoutManager(this, 4);
                    if (this.binding.dashBoardMain != null) {
                        this.binding.dashBoardMain.tabsRV.setLayoutManager(this.gridLayoutManager);
                    }
                    this.binding.dashBoardMain.tabsRV.setNestedScrollingEnabled(false);
                    this.binding.dashBoardMain.tabsRV.addItemDecoration(new GridSpacingItemDecoration(4, 10, false));
                    TileItemsAdapterSubCat tileItemsAdapterSubCat = new TileItemsAdapterSubCat(this, this.courseTypeMasterRecyclerData1, this);
                    tileItemsAdapterSubCat.notifyDataSetChanged();
                    this.binding.dashBoardMain.tabsRV.setAdapter(tileItemsAdapterSubCat);
                } else {
                    this.binding.dashBoardMain.tabsRV.setNestedScrollingEnabled(false);
                    this.binding.dashBoardMain.tabsRV.addItemDecoration(new GridSpacingItemDecoration(2, 15, false));
                    this.dashboardTabAdapter.notifyDataSetChanged();
                    this.binding.dashBoardMain.tabsRV.setAdapter(this.dashboardTabAdapter);
                }
            }
        }
        selectedData();
        automateViewPagerSwiping();
        automateBottomViewPagerSwiping();
    }

    public void homeAutoRefresh() {
        if (SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT) == 0) {
            ShortcutBadger.applyCount(getApplicationContext(), SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT));
            ((LinearLayout) Objects.requireNonNull(((AppBarDashboardBinding) Objects.requireNonNull(this.binding.dashBoardMain)).cvrNotificationCount1)).setBackgroundResource(R.drawable.uncircle_notification_count);
            runOnUiThread(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda37
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$homeAutoRefresh$30();
                }
            });
            this.binding.dashBoardMain.cvrNotificationCount1.setVisibility(8);
            return;
        }
        runOnUiThread(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda38
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$homeAutoRefresh$31();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$homeAutoRefresh$30() {
        this.binding.dashBoardMain.notificaionCount1.setText(String.valueOf(SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$homeAutoRefresh$31() {
        ((AppBarDashboardBinding) Objects.requireNonNull(this.binding.dashBoardMain)).cvrNotificationCount1.setVisibility(0);
        ShortcutBadger.applyCount(getApplicationContext(), SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT));
        this.binding.dashBoardMain.cvrNotificationCount1.setBackgroundResource(R.drawable.circle_notification_count);
        if (SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT) > 99) {
            this.binding.dashBoardMain.notificaionCount1.setText(getResources().getString(R.string.nine_nine));
        } else if (SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT) > 0) {
            this.binding.dashBoardMain.notificaionCount1.setText(String.valueOf(SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT)));
        } else {
            this.binding.dashBoardMain.cvrNotificationCount1.setVisibility(8);
        }
    }

    public void CartCountRefresh() {
        if (SharedPreference.getInstance().getInt(Const.CART_COUNT) == 0) {
            ShortcutBadger.applyCount(getApplicationContext(), SharedPreference.getInstance().getInt(Const.CART_COUNT));
            ((LinearLayout) Objects.requireNonNull(((AppBarDashboardBinding) Objects.requireNonNull(this.binding.dashBoardMain)).linearGotoCart)).setBackgroundResource(R.drawable.uncircle_notification_count);
            runOnUiThread(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme1.19
                @Override // java.lang.Runnable
                public void run() {
                    DashboardActivityTheme1.this.binding.dashBoardMain.cartCount.setText(String.valueOf(SharedPreference.getInstance().getInt(Const.CART_COUNT)));
                }
            });
            this.binding.dashBoardMain.linearGotoCart.setVisibility(8);
            return;
        }
        runOnUiThread(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme1.20
            @Override // java.lang.Runnable
            public void run() {
                ((AppBarDashboardBinding) Objects.requireNonNull(DashboardActivityTheme1.this.binding.dashBoardMain)).linearGotoCart.setVisibility(0);
                ShortcutBadger.applyCount(DashboardActivityTheme1.this.getApplicationContext(), SharedPreference.getInstance().getInt(Const.CART_COUNT));
                DashboardActivityTheme1.this.binding.dashBoardMain.linearGotoCart.setBackgroundResource(R.drawable.circle_notification_count);
                if (SharedPreference.getInstance().getInt(Const.CART_COUNT) > 99) {
                    DashboardActivityTheme1.this.binding.dashBoardMain.cartCount.setText(DashboardActivityTheme1.this.getResources().getString(R.string.nine_nine));
                } else if (SharedPreference.getInstance().getInt(Const.CART_COUNT) > 0) {
                    DashboardActivityTheme1.this.binding.dashBoardMain.cartCount.setText(String.valueOf(SharedPreference.getInstance().getInt(Const.CART_COUNT)));
                } else {
                    DashboardActivityTheme1.this.binding.dashBoardMain.linearGotoCart.setVisibility(8);
                }
            }
        });
    }

    private void socialIconsVisibility(final LeftMenu leftMenu) {
        if (BuildConfig.FLAVOR.equalsIgnoreCase("krantikariEnglisApp") && leftMenu != null) {
            ArrayList arrayList = new ArrayList();
            if (Helper.isNullChek(leftMenu.getTelegram_link_data()) && leftMenu.getTelegram_link().equalsIgnoreCase("1")) {
                arrayList.add(new SocialIconModel("", R.drawable.telegram_logo_social));
            }
            if (Helper.isNullChek(leftMenu.getInstagram_link_data()) && leftMenu.getInstagram_link().equalsIgnoreCase("1")) {
                arrayList.add(new SocialIconModel("", R.drawable.instagram_logo_social));
            }
            if (Helper.isNullChek(leftMenu.getLinkedin_link_data()) && leftMenu.getLinkedin_link().equalsIgnoreCase("1")) {
                arrayList.add(new SocialIconModel("", R.drawable.linkedin_logo_social));
            }
            if (Helper.isNullChek(leftMenu.getYoutube_link_data()) && leftMenu.getYoutube_link().equalsIgnoreCase("1")) {
                arrayList.add(new SocialIconModel("", R.drawable.youtube_logo_social));
            }
            if (Helper.isNullChek(leftMenu.getFacebook_link_data()) && leftMenu.getFacebook_link().equalsIgnoreCase("1")) {
                arrayList.add(new SocialIconModel("", R.drawable.facebook_logo_social));
            }
            if (Helper.isNullChek(leftMenu.getTwitter_link_data()) && leftMenu.getTwitter_link().equalsIgnoreCase("1")) {
                arrayList.add(new SocialIconModel("", R.drawable.x_logo_social));
            }
            if (Helper.isNullChek(leftMenu.getWebsite_url()) && leftMenu.getWebsite().equalsIgnoreCase("1")) {
                arrayList.add(new SocialIconModel("", R.mipmap.web));
            }
            if (Helper.isNullChek(leftMenu.getWhatsapp_channel_data()) && leftMenu.getWhatsapp_channel().equalsIgnoreCase("1")) {
                arrayList.add(new SocialIconModel("", R.drawable.whatsapp_logo_social));
            }
            this.binding.dashBoardMain.socialIconRecyclerView.setVisibility(0);
            this.binding.dashBoardMain.socialIconRecyclerView.setLayoutManager(new LinearLayoutManager(this, 0, false));
            this.binding.dashBoardMain.socialIconRecyclerView.setAdapter(new SocialIconAdapter(this, arrayList));
        }
        if (leftMenu != null) {
            mailAndPhone();
            if (Helper.isNullChek(leftMenu.getTelegram_link_data()) && leftMenu.getTelegram_link().equalsIgnoreCase("1")) {
                this.binding.iconTelegram.setVisibility(0);
                this.binding.dashBoardMain.iconTelegram1.setVisibility(0);
                this.binding.iconTelegram.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$32(leftMenu);
                    }
                }));
                this.binding.dashBoardMain.iconTelegram1.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda51
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$33(leftMenu);
                    }
                }));
            }
            if (Helper.isNullChek(leftMenu.getInstagram_link_data()) && leftMenu.getInstagram_link().equalsIgnoreCase("1")) {
                this.binding.iconInstagram.setVisibility(0);
                this.binding.dashBoardMain.iconInstagram1.setVisibility(0);
                this.binding.iconInstagram.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$34(leftMenu);
                    }
                }));
                this.binding.dashBoardMain.iconInstagram1.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$35(leftMenu);
                    }
                }));
            }
            if (Helper.isNullChek(leftMenu.getLinkedin_link_data()) && leftMenu.getLinkedin_link().equalsIgnoreCase("1")) {
                this.binding.iconLinkedIn.setVisibility(0);
                this.binding.dashBoardMain.iconLinkedIn1.setVisibility(0);
                this.binding.iconLinkedIn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$36(leftMenu);
                    }
                }));
                this.binding.dashBoardMain.iconLinkedIn1.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$37(leftMenu);
                    }
                }));
            }
            if (Helper.isNullChek(leftMenu.getYoutube_link_data()) && leftMenu.getYoutube_link().equalsIgnoreCase("1")) {
                this.binding.iconYoutube.setVisibility(0);
                this.binding.dashBoardMain.iconYoutube1.setVisibility(0);
                this.binding.iconYoutube.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$38(leftMenu);
                    }
                }));
                this.binding.dashBoardMain.iconYoutube1.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$39(leftMenu);
                    }
                }));
            }
            if (Helper.isNullChek(leftMenu.getFacebook_link_data()) && leftMenu.getFacebook_link().equalsIgnoreCase("1")) {
                this.binding.iconFacebook.setVisibility(0);
                this.binding.dashBoardMain.iconFacebook1.setVisibility(0);
                this.binding.iconFacebook.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$40(leftMenu);
                    }
                }));
                this.binding.dashBoardMain.iconFacebook1.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$41(leftMenu);
                    }
                }));
            }
            if (Helper.isNullChek(leftMenu.getTwitter_link_data()) && leftMenu.getTwitter_link().equalsIgnoreCase("1")) {
                this.binding.iconTwitter.setVisibility(0);
                this.binding.dashBoardMain.iconTwitter1.setVisibility(0);
                this.binding.iconTwitter.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda32
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$42(leftMenu);
                    }
                }));
                this.binding.dashBoardMain.iconTwitter1.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda43
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$43(leftMenu);
                    }
                }));
            }
            if (Helper.isNullChek(leftMenu.getWebsite_url()) && leftMenu.getWebsite().equalsIgnoreCase("1")) {
                this.binding.iconWebsite.setVisibility(0);
                this.binding.dashBoardMain.iconWebsite1.setVisibility(0);
                this.binding.iconWebsite.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda47
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$44(leftMenu);
                    }
                }));
                this.binding.dashBoardMain.iconWebsite1.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda48
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$45(leftMenu);
                    }
                }));
            }
            if (Helper.isNullChek(leftMenu.getWhatsapp_channel_data()) && leftMenu.getWhatsapp_channel().equalsIgnoreCase("1")) {
                this.binding.iconWhatsapp.setVisibility(0);
                this.binding.iconWhatsapp.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda49
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$46();
                    }
                }));
            }
            if (Helper.isNullChek(leftMenu.getWhatsapp_channel_data()) && leftMenu.getWhatsapp_channel().equalsIgnoreCase("1")) {
                this.binding.dashBoardMain.iconWhatsapp1.setVisibility(0);
                this.binding.dashBoardMain.iconWhatsapp1.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda50
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$47();
                    }
                }));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$32(LeftMenu leftMenu) {
        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getTelegram_link_data())));
            return null;
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this, "No application found to open this link.", 0).show();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$33(LeftMenu leftMenu) {
        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getTelegram_link_data())));
            return null;
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this, "No application found to open this link.", 0).show();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$34(LeftMenu leftMenu) {
        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getInstagram_link_data())));
            return null;
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this, "No application found to open this link.", 0).show();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$35(LeftMenu leftMenu) {
        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getInstagram_link_data())));
            return null;
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this, "No application found to open this link.", 0).show();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$36(LeftMenu leftMenu) {
        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getLinkedin_link_data())));
            return null;
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this, "No application found to open this link.", 0).show();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$37(LeftMenu leftMenu) {
        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getLinkedin_link_data())));
            return null;
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this, "No application found to open this link.", 0).show();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$38(LeftMenu leftMenu) {
        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getYoutube_link_data())));
            return null;
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this, "No application found to open this link.", 0).show();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$39(LeftMenu leftMenu) {
        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getYoutube_link_data())));
            return null;
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this, "No application found to open this link.", 0).show();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$40(LeftMenu leftMenu) {
        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getFacebook_link_data())));
            return null;
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this, "No application found to open this link.", 0).show();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$41(LeftMenu leftMenu) {
        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getFacebook_link_data())));
            return null;
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this, "No application found to open this link.", 0).show();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$42(LeftMenu leftMenu) {
        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getTwitter_link_data())));
            return null;
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this, "No application found to open this link.", 0).show();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$43(LeftMenu leftMenu) {
        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getTwitter_link_data())));
            return null;
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this, "No application found to open this link.", 0).show();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$44(LeftMenu leftMenu) {
        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getWebsite_url())));
            return null;
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this, "No application found to open this link.", 0).show();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$45(LeftMenu leftMenu) {
        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getWebsite_url())));
            return null;
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this, "No application found to open this link.", 0).show();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$46() {
        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
        openWhatsappChannel();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$47() {
        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
        openWhatsappChannel();
        return null;
    }

    private void openWhatsappChannel() {
        String string = SharedPreference.getInstance().getString(Const.WHATSAPP_CHANNEL_DATA);
        String str = "com.whatsapp";
        if (!isAppInstalled("com.whatsapp")) {
            str = "com.whatsapp.w4b";
            if (!isAppInstalled("com.whatsapp.w4b")) {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.whatsapp.com/download")));
                return;
            }
        }
        if (string != null && !string.equalsIgnoreCase("")) {
            openWhatsAppChannel(string, str);
        } else {
            Toast.makeText(homeactivitytheme1, "Channel URL is not found.", 0).show();
        }
    }

    private void openWhatsAppChannel(String url, String packageName) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
        intent.setPackage(packageName);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        startActivity(intent);
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
        if (!BuildConfig.FLAVOR.equalsIgnoreCase("banglaguru")) {
            bundle.putSerializable("master_cat", (Serializable) this.masterAllCatTables);
        }
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

    private boolean logutuser() {
        if (MakeMyExam.userId != null && !MakeMyExam.userId.equalsIgnoreCase("") && SharedPreference.getInstance().getLoggedInUser() != null && SharedPreference.getInstance().getLoggedInUser().getId() != null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void hitRecentWatchApi() {
        if (MakeMyExam.userId == null || MakeMyExam.userId.equalsIgnoreCase("")) {
            return;
        }
        this.networkCall.NetworkAPICall(API.API_RECENT_WATCH, "", false, false);
    }

    public void fetchCouponData() {
        this.networkCall.NetworkAPICall(API.API_GET_COUPON, "", false, false);
    }

    private void emailVerify() {
        final Dialog dialog = new Dialog(this, R.style.BottomSheetDialog);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(R.layout.bottom_sheet_email_update);
        dialog.getWindow().setLayout(-1, -2);
        this.updateEmail_edt = (EditText) dialog.findViewById(R.id.updateEmail_edt);
        TextView textView = (TextView) dialog.findViewById(R.id.cancel);
        TextView textView2 = (TextView) dialog.findViewById(R.id.apply);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$emailVerify$48(dialog, view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme1$$ExternalSyntheticLambda23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$emailVerify$49(dialog, view);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$emailVerify$48(Dialog dialog, View view) {
        finish();
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$emailVerify$49(Dialog dialog, View view) {
        if (!TextUtils.isEmpty(this.updateEmail_edt.getText().toString())) {
            this.networkCall.NetworkAPICall(API.update_profile, "", true, false);
            dialog.dismiss();
        } else {
            Toast.makeText(this, "Please Enter Email ID.", 0).show();
        }
    }

    private void pushEventForInApp(String actionType, BannerListTable bannerListTable) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_id", AnalyticHelper.INSTANCE.getUserId());
        map.put("content_type", !TextUtils.isEmpty(bannerListTable.getLink_type()) ? bannerListTable.getLink_type() : "NA");
        map.put("action_type", actionType);
        AnalyticEvents.INSTANCE.pushEvents(this, AnalyticsConstants.IN_APP_PUSH, map);
    }

    @Override // com.appnew.android.Educator.adpter.HomeEduAdapter.onEducatorClickListener
    public void onEducatorItemClick(EducatorsModel.Datum homeEduItem) {
        Intent intent = new Intent(this, (Class<?>) EducatorsActivity.class);
        intent.putExtra("educator_name", homeEduItem.getUsername());
        intent.putExtra("educator_id", homeEduItem.getId());
        intent.putExtra("educator_image", homeEduItem.getProfilePicture());
        intent.putExtra("educator_exp", homeEduItem.getExperience());
        startActivity(intent);
    }

    @Override // com.appnew.android.Educator.adpter.HomeLCAdapter.onCardClickListener
    public void onCardClick(HomeLiveClassItem homeLiveClassItem) {
        Toast.makeText(getApplicationContext(), "This class is not available!", 0).show();
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
        String stringExtra = getIntent().getStringExtra(Const.NOTIFICATION_ID);
        if (stringExtra == null || stringExtra.equalsIgnoreCase("")) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("title", this.snsTitle);
        bundle.putString("message", this.snsMessage);
        bundle.putString(Const.NOTIFICATION_CODE, String.valueOf(this.sns_notification_code));
        bundle.putString(Const.NOTIFICATION_ID, stringExtra);
        bundle.putString(Const.VIDEO_ID, this.fieldid);
        new ApiUpdate(this).callApi(API.mark_as_read, "", true, stringExtra, bundle);
    }

    @Override // com.appnew.android.Theme.Adapter.DailyPollAdapter.DailyPollSubmitCallBack
    public void onSubmitCall(String id, String optionIndex) {
        this.poll_id = id;
        this.optionIndex = optionIndex;
        this.networkCall.NetworkAPICall(API.attempt_mcq, "", true, false);
    }

    @Override // com.razorpay.PaymentResultListener
    public void onPaymentSuccess(String s) {
        HomeTCAdapter homeTCAdapter = this.homeTCAdapter;
        if (homeTCAdapter != null) {
            homeTCAdapter.onPaymentSuccess(s);
        }
    }

    @Override // com.razorpay.PaymentResultListener
    public void onPaymentError(int i, String s) {
        HomeTCAdapter homeTCAdapter = this.homeTCAdapter;
        if (homeTCAdapter != null) {
            homeTCAdapter.onPaymentError(i, s);
        }
    }

    @Override // com.appnew.android.Payment.PaymentGatewayListener
    public void onSuccess(String posTxnId) {
        HomeTCAdapter homeTCAdapter = this.homeTCAdapter;
        if (homeTCAdapter != null) {
            homeTCAdapter.onSuccess(posTxnId);
        }
    }

    @Override // com.appnew.android.Payment.PaymentGatewayListener
    public void onSuccessEsewa(String productId, String totalAmount, String referenceId, String scdId) {
        HomeTCAdapter homeTCAdapter = this.homeTCAdapter;
        if (homeTCAdapter != null) {
            homeTCAdapter.onSuccessEsewa(productId, totalAmount, referenceId, scdId);
        }
    }

    @Override // com.appnew.android.Payment.PaymentGatewayListener
    public void onFailed(boolean isFailure) {
        HomeTCAdapter homeTCAdapter = this.homeTCAdapter;
        if (homeTCAdapter != null) {
            homeTCAdapter.onFailed(isFailure);
        }
    }

    private ArrayList<DivisionModel> getDivisionActualList() {
        ArrayList<DivisionModel> arrayList = new ArrayList<>();
        try {
            String string = SharedPreference.getInstance().getString(Const.DIVISION);
            if (TextUtils.isEmpty(string)) {
                return arrayList;
            }
            return (ArrayList) new Gson().fromJson(string, new TypeToken<ArrayList<DivisionModel>>() { // from class: com.appnew.android.Theme.DashboardActivityTheme1.21
            }.getType());
        } catch (JsonSyntaxException e2) {
            throw new RuntimeException(e2);
        }
    }

    private void initListeners(OnDataSendListener type) {
        this.live_class_feedback = SharedPreference.getInstance().getString(Const.LIVE_CLASS_FEEDBACK);
        this.live_test_feedback = SharedPreference.getInstance().getString(Const.LIVE_TEST_FEEDBACK);
        VODPlayerActivity.setOnDataSendListener(type);
        Liveawsactivity.setOnDataSendListener(type);
        LiveStreamingYoutube.setOnDataSendListener(type);
        QuizActivity.setOnDataSendListener(type);
        TestBaseActivity.setOnDataSendListener(type);
        TestBaseActivitySSCPattern.setOnDataSendListener(type);
    }

    private void openFeedbackBottomSheet() {
        if (this.isBottomSheetOpen) {
            return;
        }
        this.isBottomSheetOpen = true;
        this.feedbackDialog[0] = new Utils.FeedbackBottomSheetDialog(this, new Utils.FeedbackBottomSheetDialog.Listener() { // from class: com.appnew.android.Theme.DashboardActivityTheme1.22
            @Override // com.appnew.android.player.music_player.Utils.FeedbackBottomSheetDialog.Listener
            public void onClose() {
                DashboardActivityTheme1.this.feedbackDialog[0].dismiss();
                DashboardActivityTheme1.this.isBottomSheetOpen = false;
            }

            @Override // com.appnew.android.player.music_player.Utils.FeedbackBottomSheetDialog.Listener
            public void onSubmit() {
                RatingBar ratingBar = (RatingBar) DashboardActivityTheme1.this.feedbackDialog[0].findViewById(R.id.ratingBar);
                EditText editText = (EditText) DashboardActivityTheme1.this.feedbackDialog[0].findViewById(R.id.ratingComment);
                DashboardActivityTheme1.this.rating = String.valueOf(ratingBar != null ? ratingBar.getRating() : 0.0f);
                DashboardActivityTheme1.this.ratingMessage = editText != null ? editText.getText().toString().trim() : "";
                if (ratingBar.getRating() <= 0.0f) {
                    Toast.makeText(DashboardActivityTheme1.this, "Please select rating!", 0).show();
                } else {
                    if (DashboardActivityTheme1.this.ratingMessage.isEmpty()) {
                        Toast.makeText(DashboardActivityTheme1.this, "Please write feedback!", 0).show();
                        return;
                    }
                    DashboardActivityTheme1.this.networkCall.NetworkAPICall(API.POST_COURSE_REVIEW, "", false, false);
                    DashboardActivityTheme1.this.feedbackDialog[0].dismiss();
                    DashboardActivityTheme1.this.isBottomSheetOpen = false;
                }
            }
        });
        Utils.INSTANCE.bottomSheet(new Utils.FeedbackBottomSheetDialog[]{this.feedbackDialog[0]});
        this.feedbackDialog[0].show();
    }

    @Override // com.appnew.android.LiveClass.interface_.OnDataSendListener
    public void onDataSent(long isLive, String particularId, String attemptOrReAttempt, int ratingType) {
        Log.e("TAG_APP", "onDataSent: " + isLive + " particularId " + particularId + "ratingType " + ratingType);
        this.courseId = particularId;
        this.rating_type = ratingType;
        if ((TextUtils.isEmpty(this.live_class_feedback) || !this.live_class_feedback.equalsIgnoreCase("1")) && (TextUtils.isEmpty(this.live_test_feedback) || !this.live_test_feedback.equalsIgnoreCase("1") || TextUtils.isEmpty(attemptOrReAttempt) || !attemptOrReAttempt.equalsIgnoreCase(Const.ATTEMPT))) {
            return;
        }
        openFeedbackBottomSheet();
    }

    public void pendingPurchaseBanner() {
        PendingPurchaseBanner pendingPurchaseBanner = this.binding.dashBoardMain.pendingBanner;
        if (pendingPurchaseBanner == null) {
            return;
        }
        pendingPurchaseBanner.setVisibility((Boolean.TRUE.equals(pendingPurchaseBanner.setUIOfBanner()) && Helper.isPendingPurchaseBanner()) ? 0 : 8);
    }

    private void pendingPurchaseBannerUpdateList() {
        PendingPurchaseBanner pendingPurchaseBanner = this.binding.dashBoardMain.pendingBanner;
        if (pendingPurchaseBanner == null || !Helper.isPendingPurchaseBanner()) {
            return;
        }
        pendingPurchaseBanner.callApiToAddBanner();
    }

    private void getFirebaseData() {
        if (Helper.isDashboardLiveClass()) {
            hit_api_for_live_classes(true);
            this.databaseReference.addListenerForSingleValueEvent(new ValueEventListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme1.23
                @Override // com.google.firebase.database.ValueEventListener
                public void onDataChange(DataSnapshot snapshot) {
                    if (snapshot.exists() && snapshot.getChildrenCount() > 0) {
                        DashboardActivityTheme1.this.hit_api_for_live_classes(true);
                    }
                    DashboardActivityTheme1.this.isLiveApiInProgress = true;
                    Log.d("FirebaseUpdate", "Initial children loaded: " + snapshot.getChildrenCount());
                }

                @Override // com.google.firebase.database.ValueEventListener
                public void onCancelled(DatabaseError error) {
                    Log.e("FirebaseUpdate", "Initial load cancelled: " + error.getMessage());
                }
            });
            ChildEventListener childEventListener = new ChildEventListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme1.24
                @Override // com.google.firebase.database.ChildEventListener
                public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
                    String key = dataSnapshot.getKey();
                    String str = (String) dataSnapshot.child("isLive").getValue(String.class);
                    if (key == null) {
                        return;
                    }
                    if (DashboardActivityTheme1.this.isLiveApiInProgress) {
                        DashboardActivityTheme1.this.hit_api_for_live_classes(true);
                    }
                    Log.d("FirebaseUpdate", "New child added (realtime): " + key + ", isLive=" + str);
                }

                @Override // com.google.firebase.database.ChildEventListener
                public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {
                    Log.d("FirebaseUpdate", "onChildChanged: " + dataSnapshot.getKey());
                }

                @Override // com.google.firebase.database.ChildEventListener
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                    Log.d("FirebaseUpdate", "Child removed: " + dataSnapshot.getKey());
                    DashboardActivityTheme1.this.hit_api_for_live_classes(true);
                }

                @Override // com.google.firebase.database.ChildEventListener
                public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {
                    Log.d("FirebaseUpdate", "onChildMoved: " + dataSnapshot.getKey());
                }

                @Override // com.google.firebase.database.ChildEventListener
                public void onCancelled(DatabaseError databaseError) {
                    Log.d("FirebaseUpdate", "Listener cancelled: " + databaseError.getMessage());
                }
            };
            this.liveClassListener = childEventListener;
            this.databaseReference.addChildEventListener(childEventListener);
        }
    }

    private void detachLiveListener() {
        ChildEventListener childEventListener = this.liveClassListener;
        if (childEventListener == null || this.isLiveApiInProgress) {
            return;
        }
        this.databaseReference.removeEventListener(childEventListener);
        this.liveClassListener = null;
    }
}
