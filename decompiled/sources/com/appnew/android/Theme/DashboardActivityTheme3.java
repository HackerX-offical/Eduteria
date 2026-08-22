package com.appnew.android.Theme;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.PopupMenu;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import androidx.window.core.layout.WindowSizeClass;
import com.appnew.android.BuildConfig;
import com.appnew.android.Coupon.Activity.CouponActivity;
import com.appnew.android.CourseTransfer.CourseTransferActivity;
import com.appnew.android.Courses.Activity.Concept_newActivity;
import com.appnew.android.Courses.Activity.CourseActivity;
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
import com.appnew.android.ExtraClass.Activity.ExtraClassesActivity;
import com.appnew.android.Intro.Activity.IntroActivity;
import com.appnew.android.LiveClass.Activity.LiveClassActivity;
import com.appnew.android.LiveTest.Activity.LivetestActivity;
import com.appnew.android.Model.BottomMenu;
import com.appnew.android.Model.BottomSetting;
import com.appnew.android.Model.ExpiredEmiModel;
import com.appnew.android.Model.LeftMenu;
import com.appnew.android.Model.Video;
import com.appnew.android.Notification.Notification;
import com.appnew.android.Notification.NotificationDescription;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Profile.ProfileActivity;
import com.appnew.android.PurchaseHistory.PurchaseHistory;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Theme.Adapter.BannerAdapter;
import com.appnew.android.Theme.Adapter.DashboardSquareTileTabAdapter;
import com.appnew.android.Theme.Adapter.DashboardTabAdapter;
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
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Webview.WebViewActivty;
import com.appnew.android.Zoom.Activity.BookMarkList;
import com.appnew.android.Zoom.Activity.CurrentAffairActivity;
import com.appnew.android.Zoom.Activity.DoubtsActivity;
import com.appnew.android.Zoom.Activity.DownloadPDFActivity;
import com.appnew.android.Zoom.Activity.FAQActivity;
import com.appnew.android.Zoom.Activity.Suggestion;
import com.appnew.android.cleverTap.AnalyticHelper;
import com.appnew.android.databinding.ActivityHomeTheme3Binding;
import com.appnew.android.databinding.AppBarHomeTheme3Binding;
import com.appnew.android.feeds.activity.FeedsActivity;
import com.appnew.android.home.Activity.CourseTypeActivity;
import com.appnew.android.home.Activity.HomeActivity;
import com.appnew.android.home.Activity.MyLibraryActivty;
import com.appnew.android.home.Activity.SettingsActivity;
import com.appnew.android.home.Constants;
import com.appnew.android.home.Fragment.ContactBottomSheetFragment;
import com.appnew.android.home.adapters.LeftNavAdapter;
import com.appnew.android.home.model.Menu;
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
import com.google.android.material.snackbar.Snackbar;
import com.google.common.base.Ascii;
import com.google.gson.Gson;
import com.makeramen.roundedimageview.RoundedImageView;
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
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
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
public class DashboardActivityTheme3 extends AppCompatActivity implements NetworkCall.MyNetworkCallBack, DashboardTabAdapter.addDashboardItemClicked {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "com.appnew.android.Theme.DashboardActivityTheme3";
    public static Activity homeactivitytheme3;
    private AudioTable audioTable;
    private BannerAdapter bannerAdapter;
    ActivityHomeTheme3Binding binding;
    BottomSetting bottomSetting;
    List<ExpiredEmiModel> courseArrayLists;
    DashboardSquareTileTabAdapter dashboardSquareTileTabAdapter;
    DashboardTabAdapter dashboardTabAdapter;
    RecyclerView emiRecyclerView;
    List<ExpiredEmiModel> filteredArraylist;
    GridLayoutManager gridLayoutManager;
    int lang;
    LeftMenu leftMenu;
    List<ExpiredEmiModel> localCancelledEmi;
    String mPhoneNumber;
    NetworkCall networkCall;
    int notification_code;
    ActionBarDrawerToggle toggle;
    UtkashRoom utkashRoom;
    private Video videodata;
    List<BottomMenuTable> bottomMenuTables = new ArrayList();
    List<BannerListTable> bannerListTables = new ArrayList();
    private List<CourseTypeMasterTable> courseTypeMasterTables = new ArrayList();
    List<MasteAllCatTable> masterAllCatTables = new ArrayList();
    List<LanguagesTable> LanguagesTable = new ArrayList();
    List<MasterCat> mastercatlist = new ArrayList();
    private Timer timer = new Timer();
    String course_id = "";
    String fieldid = "";
    long ts = 0;
    String coupon_for = "";
    String topicid = "";
    String video_type = "";
    String tiletype = "";
    String tileid = "";
    String revertapi = "";
    String type = "";
    String title = "";
    String url = "";
    String imageUrl = "";
    String message_target = "";
    String message = "";
    String parentid = "";
    private boolean backstatus = false;
    long backPressed = 0;
    public String contentType = "0";
    String testname = "";
    String testquestion = "";
    private String quiz_id = "";
    String first_attempt = "";
    String result_date = "";
    String submition_type = "";
    ArrayList<View> viewArrayList = new ArrayList<>();
    String currentTime = "";
    String solutions = "";
    String test_series_name = "";
    String test_series_date = "";
    private boolean hitMaster = true;
    public View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme3.2
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            String str;
            String str2;
            for (int i2 = 0; i2 < DashboardActivityTheme3.this.viewArrayList.size(); i2 = i + 1) {
                if (view == DashboardActivityTheme3.this.viewArrayList.get(i2)) {
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
                        case 1567:
                            if (id.equals("10")) {
                                b2 = 8;
                            }
                            break;
                        case 1568:
                            if (id.equals("11")) {
                                b2 = 9;
                            }
                            break;
                        case 1569:
                            if (id.equals("12")) {
                                b2 = 10;
                            }
                            break;
                        case 1570:
                            if (id.equals("13")) {
                                b2 = 11;
                            }
                            break;
                        case 1573:
                            if (id.equals("16")) {
                                b2 = 12;
                            }
                            break;
                        case 1574:
                            if (id.equals("17")) {
                                b2 = 13;
                            }
                            break;
                        case 1575:
                            if (id.equals("18")) {
                                b2 = 14;
                            }
                            break;
                    }
                    i = i2;
                    byte b3 = b2;
                    String str3 = Const.MASTER_CATEGORY_ID;
                    switch (b3) {
                        case 0:
                            Intent intent = new Intent(DashboardActivityTheme3.this, (Class<?>) CourseActivity.class);
                            intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                            intent.putExtra(Const.COURSE_ID_MAIN, menu.getType_code());
                            intent.putExtra(Const.COURSE_PARENT_ID, "");
                            intent.putExtra(Const.SUB_CAT, "");
                            intent.putExtra(Const.IS_COMBO, false);
                            intent.putExtra(AnalyticsConstants.course_name, menu.getName());
                            Helper.gotoActivity(intent, DashboardActivityTheme3.this);
                            continue;
                            break;
                        case 1:
                            if (!Helper.isNetworkConnected(DashboardActivityTheme3.this)) {
                                Helper.showInternetToast(DashboardActivityTheme3.this);
                                return;
                            }
                            Helper.gotoActivity(DashboardActivityTheme3.this, (Class<?>) MyLibraryActivty.class);
                            break;
                        case 2:
                            if (!Helper.isNetworkConnected(DashboardActivityTheme3.this)) {
                                Helper.showInternetToast(DashboardActivityTheme3.this);
                                return;
                            }
                            Bundle bundle = new Bundle();
                            bundle.putInt(Const.NOTIFICATION_CODE, DashboardActivityTheme3.this.notification_code);
                            bundle.putString("course_id", DashboardActivityTheme3.this.course_id);
                            bundle.putString("file_id", DashboardActivityTheme3.this.fieldid);
                            bundle.putString(Const.TOPIC_ID, DashboardActivityTheme3.this.topicid);
                            bundle.putString("tile_id", DashboardActivityTheme3.this.tileid);
                            bundle.putString(Const.TILE_TYPE, DashboardActivityTheme3.this.tiletype);
                            bundle.putString(Const.REVERT_API, DashboardActivityTheme3.this.revertapi);
                            bundle.putString("title", DashboardActivityTheme3.this.title);
                            bundle.putString(TypedValues.AttributesType.S_TARGET, DashboardActivityTheme3.this.message_target);
                            bundle.putString("url", DashboardActivityTheme3.this.url);
                            bundle.putString("image", DashboardActivityTheme3.this.imageUrl);
                            bundle.putString("message", DashboardActivityTheme3.this.message);
                            if (DashboardActivityTheme3.this.courseTypeMasterTables.size() > 1) {
                                bundle.putString(Const.TAB_ID, ((CourseTypeMasterTable) DashboardActivityTheme3.this.courseTypeMasterTables.get(0)).getId());
                            } else {
                                bundle.putString(Const.TAB_ID, "1");
                            }
                            if (DashboardActivityTheme3.this.courseTypeMasterTables.size() > 1) {
                                bundle.putString(Const.TAB_NAME, ((CourseTypeMasterTable) DashboardActivityTheme3.this.courseTypeMasterTables.get(0)).getName());
                            } else {
                                bundle.putString(Const.TAB_NAME, "");
                            }
                            if (!GenericUtils.isListEmpty(DashboardActivityTheme3.this.courseTypeMasterTables) && !GenericUtils.isEmpty(((CourseTypeMasterTable) DashboardActivityTheme3.this.courseTypeMasterTables.get(0)).getMaster_category_id())) {
                                bundle.putString(str3, ((CourseTypeMasterTable) DashboardActivityTheme3.this.courseTypeMasterTables.get(0)).getMaster_category_id());
                            } else {
                                bundle.putString(str3, "0");
                            }
                            DashboardActivityTheme3.this.startActivity(new Intent(DashboardActivityTheme3.this, (Class<?>) HomeActivity.class).putExtras(bundle));
                            DashboardActivityTheme3.this.overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
                            break;
                            break;
                        case 3:
                            if (!Helper.isNetworkConnected(DashboardActivityTheme3.this)) {
                                Helper.showInternetToast(DashboardActivityTheme3.this);
                                return;
                            }
                            Helper.gotoActivity(DashboardActivityTheme3.this, (Class<?>) Notification.class);
                            break;
                        case 4:
                            Helper.gotoActivity(DashboardActivityTheme3.this, (Class<?>) DownloadActivity.class);
                            break;
                        case 5:
                            if (!Helper.isNetworkConnected(DashboardActivityTheme3.this)) {
                                Helper.showInternetToast(DashboardActivityTheme3.this);
                                return;
                            }
                            Helper.gotoActivity(DashboardActivityTheme3.this, CreateTestActivity.class, "1");
                            break;
                        case 6:
                            if (!Helper.isNetworkConnected(DashboardActivityTheme3.this)) {
                                Helper.showInternetToast(DashboardActivityTheme3.this);
                                return;
                            }
                            Helper.gotoActivity(DashboardActivityTheme3.this, (Class<?>) LivetestActivity.class);
                            break;
                        case 7:
                            if (!Helper.isNetworkConnected(DashboardActivityTheme3.this)) {
                                Helper.showInternetToast(DashboardActivityTheme3.this);
                                return;
                            }
                            Helper.gotoActivity(DashboardActivityTheme3.this, (Class<?>) LiveClassActivity.class);
                            break;
                        case 8:
                            Data loggedInUser = SharedPreference.getInstance().getLoggedInUser();
                            if (loggedInUser != null && loggedInUser.getPreferences() != null && loggedInUser.getPreferences().size() > 0) {
                                Helper.gotoActivity(new Intent(DashboardActivityTheme3.this, (Class<?>) FeedsActivity.class), DashboardActivityTheme3.this);
                            } else {
                                Helper.gotoActivity(new Intent(DashboardActivityTheme3.this, (Class<?>) IntroActivity.class), DashboardActivityTheme3.this);
                            }
                            break;
                        case 9:
                            if (!Helper.isNetworkConnected(DashboardActivityTheme3.this)) {
                                Helper.showInternetToast(DashboardActivityTheme3.this);
                                return;
                            }
                            Helper.gotoActivity(DashboardActivityTheme3.this, (Class<?>) ProfileActivity.class);
                            if (DashboardActivityTheme3.this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                                DashboardActivityTheme3.this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                            }
                            break;
                            break;
                        case 10:
                            DashboardActivityTheme3.this.openWhatsapp();
                            break;
                        case 11:
                            if (!Helper.isNetworkConnected(DashboardActivityTheme3.this)) {
                                Helper.showInternetToast(DashboardActivityTheme3.this);
                                return;
                            }
                            Bundle bundle2 = new Bundle();
                            String str4 = Const.TAB_NAME;
                            bundle2.putInt(Const.NOTIFICATION_CODE, DashboardActivityTheme3.this.notification_code);
                            bundle2.putString("file_id", DashboardActivityTheme3.this.fieldid);
                            bundle2.putString(Const.TOPIC_ID, DashboardActivityTheme3.this.topicid);
                            bundle2.putString("tile_id", DashboardActivityTheme3.this.tileid);
                            bundle2.putString(Const.TILE_TYPE, DashboardActivityTheme3.this.tiletype);
                            bundle2.putString(Const.REVERT_API, DashboardActivityTheme3.this.revertapi);
                            bundle2.putString("title", DashboardActivityTheme3.this.title);
                            bundle2.putString(TypedValues.AttributesType.S_TARGET, DashboardActivityTheme3.this.message_target);
                            bundle2.putString("url", DashboardActivityTheme3.this.url);
                            bundle2.putString("image", DashboardActivityTheme3.this.imageUrl);
                            bundle2.putString("message", DashboardActivityTheme3.this.message);
                            for (CourseTypeMasterTable courseTypeMasterTable : DashboardActivityTheme3.this.courseTypeMasterTables) {
                                if (courseTypeMasterTable.getId().equalsIgnoreCase(menu.getType_code())) {
                                    bundle2.putString("course_id", courseTypeMasterTable.getCourse_id());
                                    bundle2.putString(Const.TAB_ID, courseTypeMasterTable.getId());
                                    str2 = str4;
                                    bundle2.putString(str2, courseTypeMasterTable.getName());
                                    str = str3;
                                    bundle2.putString(str, courseTypeMasterTable.getMaster_category_id());
                                } else {
                                    str = str3;
                                    str2 = str4;
                                }
                                str3 = str;
                                str4 = str2;
                            }
                            DashboardActivityTheme3.this.startActivity(new Intent(DashboardActivityTheme3.this, (Class<?>) HomeActivity.class).putExtras(bundle2));
                            DashboardActivityTheme3.this.overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
                            break;
                            break;
                        case 12:
                            if (!Helper.isNetworkConnected(DashboardActivityTheme3.this)) {
                                Helper.showInternetToast(DashboardActivityTheme3.this);
                                return;
                            } else {
                                DashboardActivityTheme3.this.startActivity(new Intent(DashboardActivityTheme3.this, (Class<?>) DoubtsActivity.class));
                                DashboardActivityTheme3.this.overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
                            }
                            break;
                        case 13:
                            if (!Helper.isNetworkConnected(DashboardActivityTheme3.this)) {
                                Helper.showInternetToast(DashboardActivityTheme3.this);
                                return;
                            }
                            Intent intent2 = new Intent(DashboardActivityTheme3.this, (Class<?>) CurrentAffairActivity.class);
                            intent2.putExtra("title_key", "Current Affair");
                            DashboardActivityTheme3.this.startActivity(intent2);
                            DashboardActivityTheme3.this.overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
                            break;
                            break;
                        case 14:
                            if (!Helper.isNetworkConnected(DashboardActivityTheme3.this)) {
                                Helper.showInternetToast(DashboardActivityTheme3.this);
                                return;
                            }
                            if (!BuildConfig.FAQ_URL.equalsIgnoreCase(BuildConfig.FAQ_URL)) {
                                if (BuildConfig.FLAVOR.equalsIgnoreCase("mahendra")) {
                                    Intent intent3 = new Intent(DashboardActivityTheme3.this, (Class<?>) FAQActivity.class);
                                    intent3.putExtra("title_key", "FAQ");
                                    DashboardActivityTheme3.this.startActivity(intent3);
                                } else {
                                    DashboardActivityTheme3.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(BuildConfig.FAQ_URL)));
                                }
                            } else {
                                Helper.showToast(DashboardActivityTheme3.this, "Still in ,. Development.", 0);
                            }
                            break;
                            break;
                    }
                } else {
                    i = i2;
                }
            }
        }
    };
    ViewPager2.OnPageChangeCallback bannerPageChangeCallback = new ViewPager2.OnPageChangeCallback() { // from class: com.appnew.android.Theme.DashboardActivityTheme3.3
        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            super.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            DashboardActivityTheme3.this.binding.dashBoardMain.sliderViewPager.setCurrentItem(position);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int state) {
            super.onPageScrollStateChanged(state);
        }
    };
    String[] langIds = {"1"};
    private int STORAGE_PERMISSION_TYPE = 3;
    public final int REQUEST_CODE_MULTIPLE_PIKER = 1203;

    private void automateBottomViewPagerSwiping() {
    }

    static /* synthetic */ void lambda$getLogoutDialog$16() {
    }

    public LinearLayout initBottomView(Menu menu) {
        LinearLayout linearLayout = (LinearLayout) View.inflate(this, R.layout.bottom_item, null);
        TextView textView = (TextView) linearLayout.findViewById(R.id.title);
        final ImageView imageView = (ImageView) linearLayout.findViewById(R.id.icon);
        textView.setText(menu.getName());
        Glide.with((FragmentActivity) this).asBitmap().load(menu.getImageUrl()).into(new CustomTarget<Bitmap>() { // from class: com.appnew.android.Theme.DashboardActivityTheme3.1
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
    protected void onCreate(Bundle savedInstanceState) {
        ThemeSettings themeSettingsData;
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        this.binding = ActivityHomeTheme3Binding.inflate(getLayoutInflater());
        this.utkashRoom = UtkashRoom.getAppDatabase(this);
        setContentView(this.binding.getRoot());
        homeactivitytheme3 = this;
        Helper.enableScreenShot(this);
        getBundledData();
        Helper.setSystemBarLight(this);
        initView();
        if (Helper.isNetworkConnected(this) || !this.utkashRoom.getthemeSettingdao().is_setting_exit() || (themeSettingsData = this.utkashRoom.getthemeSettingdao().data()) == null) {
            return;
        }
        LeftMenu leftMenu = (LeftMenu) new Gson().fromJson(themeSettingsData.getLeft_menu(), LeftMenu.class);
        BottomMenu bottomMenu = (BottomMenu) new Gson().fromJson(themeSettingsData.getBottom(), BottomMenu.class);
        if ((leftMenu == null || !leftMenu.getDownloads().equalsIgnoreCase("1")) && (bottomMenu == null || bottomMenu.getDownloads() == null || !bottomMenu.getDownloads().equalsIgnoreCase("1"))) {
            return;
        }
        Helper.goToDownloadsOfflineMode(this);
    }

    public void dialog_latest_popup(final BannerListTable bannerListTable) {
        pushEventForInApp("notification_delivered", bannerListTable);
        final Dialog dialog = new Dialog(homeactivitytheme3);
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
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme3$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$dialog_latest_popup$0(bannerListTable, dialog, view);
            }
        });
        roundedImageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme3$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$dialog_latest_popup$1(bannerListTable, dialog, view);
            }
        });
        layoutParams.gravity = 17;
        layoutParams.windowAnimations = R.style.videosheetDialogTheme;
        dialog.getWindow().setAttributes(layoutParams);
        dialog.show();
        SharedPreference.getInstance().putBoolean("showpopup", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dialog_latest_popup$0(BannerListTable bannerListTable, Dialog dialog, View view) {
        pushEventForInApp("notification_dismissed", bannerListTable);
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dialog_latest_popup$1(BannerListTable bannerListTable, Dialog dialog, View view) {
        pushEventForInApp("notification_viewed", bannerListTable);
        if (bannerListTable.getCourse_id() != null) {
            if (!bannerListTable.getCourse_id().equals("0")) {
                Intent intent = new Intent(this, (Class<?>) CourseActivity.class);
                intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                intent.putExtra(Const.COURSE_ID_MAIN, bannerListTable.getCourse_id());
                intent.putExtra(Const.COURSE_PARENT_ID, "");
                intent.putExtra(Const.IS_COMBO, false);
                intent.putExtra(AnalyticsConstants.course_name, bannerListTable.getBanner_title() != null ? bannerListTable.getBanner_title() : "Course");
                Helper.gotoActivity(intent, this);
            } else if (!GenericUtils.isEmpty(bannerListTable.getLink())) {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(bannerListTable.getLink())));
            }
        }
        dialog.dismiss();
    }

    private void getBundledData() {
        if (getIntent() != null) {
            int intExtra = getIntent().getIntExtra(Const.NOTIFICATION_CODE, 0);
            this.notification_code = intExtra;
            if (intExtra != 0) {
                pushEventForPushNotification("" + this.notification_code);
            }
            this.course_id = getIntent().getStringExtra("course_id");
            this.fieldid = getIntent().getStringExtra("file_id");
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
        }
    }

    private void initView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.emiRecyclerView);
        this.emiRecyclerView = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.emiRecyclerView.setLayoutManager(new LinearLayoutManager(homeactivitytheme3, 0, false));
        this.networkCall = new NetworkCall(this, this);
        this.gridLayoutManager = new GridLayoutManager(this, 2);
        if (this.binding.dashBoardMain != null) {
            this.binding.dashBoardMain.tabsRV.setLayoutManager(this.gridLayoutManager);
        }
        this.binding.dashBoardMain.tabsRV.setNestedScrollingEnabled(false);
        this.binding.dashBoardMain.tabsRV.addItemDecoration(new GridSpacingItemDecoration(2, 15, false));
        this.dashboardTabAdapter = new DashboardTabAdapter(this, this.courseTypeMasterTables, this, "0");
        this.binding.dashBoardMain.tabsRV.setAdapter(this.dashboardTabAdapter);
        this.binding.dashBoardMain.sliderViewPager.registerOnPageChangeCallback(this.bannerPageChangeCallback);
        List<BannerListTable> list = this.bannerListTables;
        if (list != null && list.size() > 0) {
            this.bannerAdapter = new BannerAdapter(this, this.bannerListTables);
            this.binding.dashBoardMain.sliderViewPager.setAdapter(this.bannerAdapter);
        }
        this.dashboardSquareTileTabAdapter = new DashboardSquareTileTabAdapter(this, this.courseTypeMasterTables, this);
        hitApiIfNotInLocal();
        this.binding.dashBoardMain.notificationLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme3$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$initView$2();
            }
        }));
        bindControls();
        setHomeDrawer();
        createMenus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$initView$2() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
        }
        Helper.gotoActivity(this, (Class<?>) Notification.class);
        return null;
    }

    private void hitApiIfNotInLocal() {
        Intent intent;
        if (this.leftMenu == null && this.hitMaster) {
            this.hitMaster = false;
            this.networkCall.NetworkAPICall(API.master_content, "", true, false);
        }
        int i = this.notification_code;
        if (i == 90002) {
            hit_api_for_data();
            return;
        }
        if (i == 90001) {
            if (this.message_target.equalsIgnoreCase("6")) {
                intent = new Intent(this, (Class<?>) WebFragActivity.class);
                intent.putExtra("title", this.title);
                intent.putExtra("url", this.url);
                intent.putExtra("imageUrl", this.imageUrl);
            } else if (this.message_target.equalsIgnoreCase("2")) {
                intent = new Intent(this, (Class<?>) CourseActivity.class);
                intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                intent.putExtra(Const.COURSE_ID_MAIN, this.course_id);
                intent.putExtra(Const.COURSE_PARENT_ID, "");
                intent.putExtra(Const.IS_COMBO, false);
                SharedPreference.getInstance().putString("id", this.course_id);
            } else if (this.message_target.equalsIgnoreCase("5")) {
                intent = new Intent(this, (Class<?>) NotificationDescription.class);
                intent.putExtra("urlType", "IMAGE");
                intent.putExtra("title", this.title);
                intent.putExtra("url", this.url);
                intent.putExtra("imageUrl", this.imageUrl);
                intent.putExtra("description", this.message);
            } else if (this.message_target.equalsIgnoreCase("1")) {
                intent = new Intent(this, (Class<?>) WebFragActivity.class);
                intent.putExtra("title", this.title);
                intent.putExtra("url", this.message);
                intent.putExtra("from", "noti");
            } else if (this.message_target.equalsIgnoreCase("8")) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j = this.ts;
                if (jCurrentTimeMillis > j * 1000) {
                    if (this.coupon_for.equalsIgnoreCase("1")) {
                        Toast.makeText(this, "This coupon is available for all courses", 0).show();
                        initialzehomepage();
                    } else if (this.coupon_for.equalsIgnoreCase("0") || this.coupon_for.equalsIgnoreCase("2")) {
                        intent = new Intent(this, (Class<?>) CouponActivity.class);
                    } else {
                        intent = new Intent(this, (Class<?>) WebFragActivity.class);
                        intent.putExtra("title", this.title);
                        intent.putExtra("url", this.message);
                        intent.putExtra("from", "noti");
                    }
                } else {
                    if (j != 0) {
                        Toast.makeText(this, "This coupon is available on " + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.US).format(new Date(this.ts * 1000))), 0).show();
                    }
                    initialzehomepage();
                }
                intent = null;
            } else {
                intent = new Intent(this, (Class<?>) WebFragActivity.class);
                intent.putExtra("title", this.title);
                intent.putExtra("url", this.message);
                intent.putExtra("from", "noti");
            }
            if (intent != null) {
                Helper.gotoActivity(intent, this);
                return;
            }
            return;
        }
        if (i == 123 || i == 124 || i == 125) {
            hit_api_for_data();
            return;
        }
        AudioTable audioTable = this.audioTable;
        if (audioTable != null && audioTable.getVideo_id() != null && !this.audioTable.getVideo_id().equalsIgnoreCase("")) {
            this.notification_code = 109010;
            String str = this.video_type;
            if (str == null || !str.equalsIgnoreCase("jw")) {
                return;
            }
            Intent intent2 = new Intent(this, (Class<?>) AudioPlayerActivty.class);
            AudioPlayerService.videoid = "";
            intent2.putExtra("url", this.audioTable.getAudio_url());
            intent2.putExtra("videoid", this.audioTable.getVideo_id());
            intent2.putExtra("currentpos", this.audioTable.getAudio_currentpos());
            intent2.putExtra("video_name", this.audioTable.getVideo_name());
            intent2.putExtra("image_url", this.audioTable.getJw_url() + "/poster.jpg?width=720");
            intent2.putExtra("course_id", this.audioTable.getCourse_id());
            Helper.gotoActivity(intent2, this);
            return;
        }
        String str2 = this.video_type;
        if (str2 != null && str2.contains("youtube_")) {
            this.notification_code = 109010;
            UserHistroyTable userHistroyTableUser_history = this.utkashRoom.getuserhistorydao().user_history(MakeMyExam.userId, getIntent().getStringExtra("type").split("_")[1]);
            if (userHistroyTableUser_history != null) {
                String str3 = "http://img.youtube.com/vi/" + userHistroyTableUser_history.getYoutube_url() + "/0.jpg";
                if (userHistroyTableUser_history.getTileid() == null || userHistroyTableUser_history.getTileid().equalsIgnoreCase("")) {
                    Helper.GoToLiveVideoActivity("", this, userHistroyTableUser_history.getYoutube_url(), "1", userHistroyTableUser_history.getVideo_id(), userHistroyTableUser_history.getVideo_name(), "1", str3, "1", userHistroyTableUser_history.getCourse_id(), String.valueOf(1), this.parentid, this.tileid, "Video", new ArrayList());
                    return;
                } else {
                    Helper.GoToLiveVideoActivity("", this, userHistroyTableUser_history.getYoutube_url(), "1", userHistroyTableUser_history.getVideo_id(), userHistroyTableUser_history.getVideo_name(), "1", str3, "1", userHistroyTableUser_history.getCourse_id(), String.valueOf(1), this.parentid, userHistroyTableUser_history.getTileid(), "Video", new ArrayList());
                    return;
                }
            }
            initialzehomepage();
            return;
        }
        String str4 = this.video_type;
        if (str4 != null && str4.contains("aws")) {
            this.notification_code = 109010;
            UserHistroyTable userHistroyTableUser_history2 = this.utkashRoom.getuserhistorydao().user_history(MakeMyExam.userId, getIntent().getStringExtra("type").split("_")[1]);
            if (userHistroyTableUser_history2 != null) {
                if (userHistroyTableUser_history2.getYoutube_url().split("ayush").length == 2) {
                    Helper.GoToLiveAwsVideoActivity("0", "", this, userHistroyTableUser_history2.getYoutube_url().split("ayush")[0], "0", userHistroyTableUser_history2.getVideo_id(), userHistroyTableUser_history2.getVideo_name(), "1", userHistroyTableUser_history2.getYoutube_url().split("ayush")[1], userHistroyTableUser_history2.getCourse_id(), userHistroyTableUser_history2.getTileid(), "Video", "1", "", this.parentid, "", new ArrayList());
                    return;
                } else {
                    Helper.GoToLiveAwsVideoActivity("0", "", this, userHistroyTableUser_history2.getYoutube_url().split("ayush")[0], "0", userHistroyTableUser_history2.getVideo_id(), userHistroyTableUser_history2.getVideo_name(), "1", "", userHistroyTableUser_history2.getCourse_id(), userHistroyTableUser_history2.getTileid(), "Video", "1", "", this.parentid, "", new ArrayList());
                    return;
                }
            }
            initialzehomepage();
            return;
        }
        int i2 = this.notification_code;
        if (i2 != 0) {
            if (i2 == 101) {
                checkdeeplick();
                return;
            }
            return;
        }
        if (Helper.isNetworkConnected(this)) {
            if (this.utkashRoom.getMasterAllCatDao().isRecordExistsUserId(MakeMyExam.userId)) {
                this.courseTypeMasterTables.clear();
                this.masterAllCatTables.clear();
                this.mastercatlist.clear();
                this.LanguagesTable.clear();
                this.bannerListTables.clear();
                this.bottomMenuTables.clear();
                AsyncTask.execute(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme3$$ExternalSyntheticLambda24
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$hitApiIfNotInLocal$4();
                    }
                });
                return;
            }
            if (this.hitMaster) {
                this.hitMaster = false;
                this.networkCall.NetworkAPICall(API.master_content, "", true, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hitApiIfNotInLocal$4() {
        try {
            if (!this.utkashRoom.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread()) {
                this.courseTypeMasterTables.addAll(this.utkashRoom.getcoursetypemaster().getcourse_typemaster(MakeMyExam.userId));
                this.masterAllCatTables = this.utkashRoom.getMasterAllCatDao().getmaster_allcat(MakeMyExam.userId);
                this.mastercatlist = this.utkashRoom.getMastercatDao().getmastercat(MakeMyExam.userId);
                this.LanguagesTable = this.utkashRoom.getLaunguages().getLaunguagedetail();
                this.bannerListTables = this.utkashRoom.getBannerTableDao().getBanner(MakeMyExam.getUserId());
                this.bottomMenuTables = this.utkashRoom.getBottomMenuTableDao().getBottomMenu(MakeMyExam.getUserId());
            }
            runOnUiThread(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme3$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$hitApiIfNotInLocal$3();
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hitApiIfNotInLocal$3() {
        if (this.leftMenu == null && this.hitMaster) {
            this.hitMaster = false;
            this.networkCall.NetworkAPICall(API.master_content, "", true, false);
            return;
        }
        this.dashboardTabAdapter.notifyDataSetChanged();
        selectedData();
        List<BannerListTable> list = this.bannerListTables;
        if (list != null && list.size() > 0) {
            this.bannerAdapter = new BannerAdapter(this, this.bannerListTables);
            this.binding.dashBoardMain.sliderViewPager.setAdapter(this.bannerAdapter);
        }
        automateViewPagerSwiping();
    }

    private void managebottombar(String home, String mylibrary, String livetest, String createtest, String notification, String download, String liveclass, String courses) {
        this.binding.dashBoardMain.homeLL.setVisibility(8);
        this.binding.dashBoardMain.libLL.setVisibility(8);
        this.binding.dashBoardMain.livetestLL.setVisibility(8);
        this.binding.dashBoardMain.testLL.setVisibility(8);
        this.binding.dashBoardMain.profileLL.setVisibility(8);
        this.binding.dashBoardMain.cartLL.setVisibility(8);
        this.binding.dashBoardMain.liveclassLL.setVisibility(8);
        this.binding.dashBoardMain.CourseLL.setVisibility(8);
        if (this.bottomSetting.getTop_layout().equalsIgnoreCase("1")) {
            this.binding.dashBoardMain.headerRL.setVisibility(0);
        } else {
            this.binding.dashBoardMain.headerRL.setVisibility(8);
        }
        if (this.bottomSetting.getTop_banner().equalsIgnoreCase("1")) {
            this.binding.dashBoardMain.viewPagerRL.setVisibility(0);
            this.binding.dashBoardMain.sliderViewPager.registerOnPageChangeCallback(this.bannerPageChangeCallback);
        } else {
            this.binding.dashBoardMain.viewPagerRL.setVisibility(8);
        }
        if (liveclass.equalsIgnoreCase("1")) {
            this.binding.dashBoardMain.liveclassLL.setVisibility(0);
        }
        if (home.equalsIgnoreCase("1")) {
            this.binding.dashBoardMain.homeLL.setVisibility(0);
        }
        if (mylibrary.equalsIgnoreCase("1")) {
            this.binding.dashBoardMain.libLL.setVisibility(0);
        }
        if (livetest.equalsIgnoreCase("1")) {
            this.binding.dashBoardMain.livetestLL.setVisibility(0);
        }
        if (createtest.equalsIgnoreCase("1")) {
            this.binding.dashBoardMain.testLL.setVisibility(0);
        }
        if (notification.equalsIgnoreCase("1")) {
            this.binding.dashBoardMain.profileLL.setVisibility(0);
        }
        if (download.equalsIgnoreCase("1")) {
            this.binding.dashBoardMain.cartLL.setVisibility(0);
        }
        if (courses.equalsIgnoreCase("1")) {
            this.binding.dashBoardMain.CourseLL.setVisibility(0);
        }
    }

    private void manageVisibility() {
        this.binding.dashBoardMain.viewPagerRL.setVisibility(8);
        if (this.bottomSetting.getTop_layout() != null && this.bottomSetting.getTop_layout().equalsIgnoreCase("1")) {
            this.binding.dashBoardMain.headerRL.setVisibility(0);
        } else {
            this.binding.dashBoardMain.headerRL.setVisibility(8);
        }
        if (this.bottomSetting.getTop_banner() != null && this.bottomSetting.getTop_banner().equalsIgnoreCase("1")) {
            this.binding.dashBoardMain.viewPagerRL.setVisibility(0);
        } else {
            this.binding.dashBoardMain.viewPagerRL.setVisibility(8);
        }
    }

    private void selectedData() {
        if (this.utkashRoom.getthemeSettingdao().is_setting_exit()) {
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

    private void bindControls() {
        ((AppBarHomeTheme3Binding) Objects.requireNonNull(this.binding.dashBoardMain)).myLibrary.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme3$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$bindControls$5();
            }
        }));
        ((AppBarHomeTheme3Binding) Objects.requireNonNull(this.binding.dashBoardMain)).CourseLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme3$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$bindControls$6();
            }
        }));
        ((AppBarHomeTheme3Binding) Objects.requireNonNull(this.binding.dashBoardMain)).libLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme3$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$bindControls$7();
            }
        }));
        this.binding.dashBoardMain.cartLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme3.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Helper.gotoActivity(DashboardActivityTheme3.this, (Class<?>) DownloadActivity.class);
            }
        });
        this.binding.dashBoardMain.testLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme3$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$bindControls$8();
            }
        }));
        ((LinearLayout) Objects.requireNonNull(this.binding.navHeaderLL)).setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme3$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$bindControls$9();
            }
        }));
        this.binding.dashBoardMain.liveclass.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme3$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$bindControls$10();
            }
        }));
        this.binding.dashBoardMain.livetest.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme3$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$bindControls$11();
            }
        }));
        this.binding.dashBoardMain.profileLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme3$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$bindControls$12(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$bindControls$5() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, (Class<?>) MyLibraryActivty.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$bindControls$6() {
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
        startActivity(new Intent(this, (Class<?>) HomeActivity.class).putExtras(bundle));
        overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$bindControls$7() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, (Class<?>) MyLibraryActivty.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$bindControls$8() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, CreateTestActivity.class, "1");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$bindControls$9() {
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
    public /* synthetic */ Unit lambda$bindControls$10() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, (Class<?>) LiveClassActivity.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$bindControls$11() {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
            return null;
        }
        Helper.gotoActivity(this, (Class<?>) LivetestActivity.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindControls$12(View view) {
        if (!Helper.isNetworkConnected(this)) {
            Helper.showInternetToast(this);
        } else {
            Helper.gotoActivity(this, (Class<?>) Notification.class);
        }
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
            case "https://appapi.videocrypt.in/index.php/data_model/course/get_master_data":
                EncryptionData encryptionData3 = new EncryptionData();
                encryptionData3.setTile_id(this.tileid);
                encryptionData3.setType(this.tiletype);
                encryptionData3.setRevert_api(this.revertapi);
                encryptionData3.setCourse_id(this.course_id);
                encryptionData3.setFile_id(this.fieldid);
                encryptionData3.setParent_id(this.parentid);
                encryptionData3.setLayer("3");
                encryptionData3.setPage("1");
                encryptionData3.setSubject_id("");
                encryptionData3.setTopic_id(this.topicid);
                return service.getMasterDataVideoThree(AES.encrypt(new Gson().toJson(encryptionData3)));
            case "https://appapi.videocrypt.in/index.php/data_model/users/logout":
                EncryptionData encryptionData4 = new EncryptionData();
                encryptionData4.setUser_id(SharedPreference.getInstance().getLoggedInUser().getId());
                return service.getUserLogout(AES.encrypt(new Gson().toJson(encryptionData4)));
            case "data_model/coupon/is_coupon_available":
                return service.IS_COUPON_AVAILABLE("");
            case "https://appapi.videocrypt.in/index.php/data_model/test/get_test_data":
                EncryptionData encryptionData5 = new EncryptionData();
                encryptionData5.setTest_id(this.quiz_id);
                encryptionData5.setCourse_id(this.course_id);
                return service.API_GET_INFO_TEST_SERIES(AES.encrypt(new Gson().toJson(encryptionData5)));
            case "data_model/course/get_list_of_my_installmentcourses":
                EncryptionData encryptionData6 = new EncryptionData();
                encryptionData6.setUser_id(MakeMyExam.getUserId());
                return service.API_INSTALLMENT_COURSE_LIST(AES.encrypt(new Gson().toJson(encryptionData6)));
            case "data_model/course/common":
                EncryptionData encryptionData7 = new EncryptionData();
                encryptionData7.setUser_id(MakeMyExam.getUserId());
                return service.API_CHECK_INSTALLMENT_DATA(AES.encrypt(new Gson().toJson(encryptionData7)));
            default:
                return null;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonObject, String apitype, String typeApi, boolean showprogress) throws JSONException {
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArrayOptJSONArray2;
        JSONArray jSONArrayOptJSONArray3;
        JSONArray jSONArrayOptJSONArray4;
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
            case -171058627:
                if (apitype.equals(API.API_GET_MASTER_DATA)) {
                    b2 = 2;
                }
                break;
            case 17608548:
                if (apitype.equals(API.user_logout)) {
                    b2 = 3;
                }
                break;
            case 44364183:
                if (apitype.equals(API.IS_COUPON_AVAILABLE)) {
                    b2 = 4;
                }
                break;
            case 739951748:
                if (apitype.equals(API.API_GET_INFO_TEST_SERIES)) {
                    b2 = 5;
                }
                break;
            case 1185572585:
                if (apitype.equals(API.API_Installment_Course_List)) {
                    b2 = 6;
                }
                break;
            case 1325706724:
                if (apitype.equals(API.API_Check_Installment_Status)) {
                    b2 = 7;
                }
                break;
        }
        switch (b2) {
            case 0:
                try {
                    this.hitMaster = true;
                    if (jsonObject.optString("status").equals("true")) {
                        JSONObject jSONObject = jsonObject.getJSONObject("data");
                        this.utkashRoom.getcoursetypemaster().deletedata();
                        this.utkashRoom.getLaunguages().deletedata();
                        this.utkashRoom.getMasterAllCatDao().deletedata();
                        this.utkashRoom.getMastercatDao().deletedata();
                        this.utkashRoom.getBannerTableDao().deleteBanners();
                        this.utkashRoom.getBottomMenuTableDao().deleteBottomMenu();
                        this.utkashRoom.getthemeSettingdao().deletedata();
                        this.courseTypeMasterTables.clear();
                        this.masterAllCatTables.clear();
                        this.mastercatlist.clear();
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
                        if (jSONObject.has("languages") && (jSONArrayOptJSONArray4 = jSONObject.optJSONArray("languages")) != null && jSONArrayOptJSONArray4.length() > 0) {
                            for (int i = 0; i < jSONArrayOptJSONArray4.length(); i++) {
                                LanguagesTable languagesTable = (LanguagesTable) new Gson().fromJson(jSONArrayOptJSONArray4.get(i).toString(), LanguagesTable.class);
                                this.LanguagesTable.add(languagesTable);
                                this.utkashRoom.getLaunguages().addLaunguage(languagesTable);
                            }
                        }
                        if (jSONObject.has("all_cat") && (jSONArrayOptJSONArray3 = jSONObject.optJSONArray("all_cat")) != null && jSONArrayOptJSONArray3.length() > 0) {
                            for (int i2 = 0; i2 < jSONArrayOptJSONArray3.length(); i2++) {
                                MasteAllCatTable masteAllCatTable = (MasteAllCatTable) new Gson().fromJson(jSONArrayOptJSONArray3.get(i2).toString(), MasteAllCatTable.class);
                                masteAllCatTable.setUser_id(MakeMyExam.userId);
                                this.utkashRoom.getMasterAllCatDao().addUser(masteAllCatTable);
                                this.masterAllCatTables.add(masteAllCatTable);
                            }
                        }
                        if (jSONObject.has("master_cat") && (jSONArrayOptJSONArray2 = jSONObject.optJSONArray("master_cat")) != null && jSONArrayOptJSONArray2.length() > 0) {
                            for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                                MasterCat masterCat = (MasterCat) new Gson().fromJson(jSONArrayOptJSONArray2.get(i3).toString(), MasterCat.class);
                                masterCat.setUser_id(MakeMyExam.userId);
                                this.utkashRoom.getMastercatDao().addUser(masterCat);
                                this.mastercatlist.add(masterCat);
                            }
                        }
                        if (jSONObject.has("bottom_bar") && (jSONArrayOptJSONArray = jSONObject.optJSONArray("bottom_bar")) != null && jSONArrayOptJSONArray.length() > 0) {
                            for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                                BottomMenuTable bottomMenuTable = (BottomMenuTable) new Gson().fromJson(jSONArrayOptJSONArray.get(i4).toString(), BottomMenuTable.class);
                                bottomMenuTable.setUser_id(MakeMyExam.userId);
                                this.utkashRoom.getBottomMenuTableDao().addBottomMenu(bottomMenuTable);
                                this.bottomMenuTables.add(bottomMenuTable);
                            }
                        }
                        if (jSONObject.has("banner_list")) {
                            JSONArray jSONArrayOptJSONArray5 = jSONObject.optJSONArray("banner_list");
                            if (jSONArrayOptJSONArray5 != null && jSONArrayOptJSONArray5.length() > 0) {
                                for (int i5 = 0; i5 < jSONArrayOptJSONArray5.length(); i5++) {
                                    BannerListTable bannerListTable = (BannerListTable) new Gson().fromJson(jSONArrayOptJSONArray5.get(i5).toString(), BannerListTable.class);
                                    bannerListTable.setUser_id(MakeMyExam.userId);
                                    this.utkashRoom.getBannerTableDao().addBanner(bannerListTable);
                                    this.bannerListTables.add(bannerListTable);
                                }
                            }
                            List<BannerListTable> list = this.bannerListTables;
                            if (list != null && list.size() > 0) {
                                this.bannerAdapter = new BannerAdapter(this, this.bannerListTables);
                                this.binding.dashBoardMain.sliderViewPager.setAdapter(this.bannerAdapter);
                            }
                            automateViewPagerSwiping();
                            automateBottomViewPagerSwiping();
                        }
                        if (jSONObject.has("course_type_master")) {
                            JSONArray jSONArrayOptJSONArray6 = jSONObject.optJSONArray("course_type_master");
                            if (jSONArrayOptJSONArray6 != null && jSONArrayOptJSONArray6.length() > 0) {
                                for (int i6 = 0; i6 < jSONArrayOptJSONArray6.length(); i6++) {
                                    CourseTypeMasterTable courseTypeMasterTable = (CourseTypeMasterTable) new Gson().fromJson(jSONArrayOptJSONArray6.get(i6).toString(), CourseTypeMasterTable.class);
                                    courseTypeMasterTable.setUser_id(MakeMyExam.userId);
                                    this.utkashRoom.getcoursetypemaster().addUser(courseTypeMasterTable);
                                    this.courseTypeMasterTables.add(courseTypeMasterTable);
                                }
                            }
                            if (this.leftMenu.getMaster_category_style().equalsIgnoreCase("0")) {
                                this.binding.dashBoardMain.tabsRV.setNestedScrollingEnabled(false);
                                this.binding.dashBoardMain.tabsRV.addItemDecoration(new GridSpacingItemDecoration(2, 15, false));
                                this.dashboardSquareTileTabAdapter.notifyDataSetChanged();
                                this.binding.dashBoardMain.tabsRV.setAdapter(this.dashboardSquareTileTabAdapter);
                            } else {
                                this.binding.dashBoardMain.tabsRV.setNestedScrollingEnabled(false);
                                this.binding.dashBoardMain.tabsRV.addItemDecoration(new GridSpacingItemDecoration(2, 15, false));
                                this.dashboardTabAdapter.notifyDataSetChanged();
                                this.binding.dashBoardMain.tabsRV.setAdapter(this.dashboardTabAdapter);
                            }
                        }
                        if (jSONObject.has("notification")) {
                            SharedPreference.getInstance().putInt(Const.NOTIFICATION_COUNT, Integer.parseInt(jSONObject.getJSONObject("notification").getString("count")));
                            homeAutoRefresh();
                        }
                    }
                    selectedData();
                } catch (Exception e2) {
                    this.hitMaster = true;
                    e2.printStackTrace();
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
                                    initLivevideo(arrayList.get(0));
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
                } catch (JSONException e3) {
                    if (jsonObject.optString("auth_code") != null) {
                        if (jsonObject.optString("auth_code").equalsIgnoreCase(Const.EXPIRY_AUTH_CODE)) {
                            return;
                        } else {
                            initialzehomepage();
                        }
                    }
                    e3.printStackTrace();
                    return;
                }
                break;
            case 3:
                if (jsonObject.optString("status").equals("true")) {
                    Helper.SignOutUser(this);
                    break;
                } else if (jsonObject.optString("auth_code") != null && !jsonObject.optString("auth_code").equalsIgnoreCase(Const.EXPIRY_AUTH_CODE)) {
                    initialzehomepage();
                    break;
                }
                break;
            case 4:
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
            case 5:
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
                                        Intent intent = new Intent(this, (Class<?>) TestBaseActivity.class);
                                        intent.putExtra("status", false);
                                        intent.putExtra(Const.TEST_SERIES_ID, this.quiz_id);
                                        intent.putExtra(Const.TEST_SERIES_Name, this.testname);
                                        SharedPreference.getInstance().putString("test_series", jsonObject.toString());
                                        intent.putExtra("course_id", this.course_id);
                                        intent.putExtra(Const.TOTAL_QUESTIONS, this.testquestion);
                                        intent.putExtra("first_attempt", this.first_attempt);
                                        intent.putExtra("result_date", this.result_date);
                                        intent.putExtra("test_submission", this.submition_type);
                                        intent.putExtra("time", lValueOf);
                                        intent.putExtra("enddate", this.videodata.getEnd_date());
                                        intent.putExtra(Const.LANG, this.lang);
                                        Helper.gotoActivity(intent, this);
                                    } else if (testseriesBase.getData().getQuestionsHindi() != null && testseriesBase.getData().getQuestionsHindi().size() > 0 && this.lang == 2) {
                                        testseriesBase.getData().setQuestions(testseriesBase.getData().getQuestionsHindi());
                                        Intent intent2 = new Intent(this, (Class<?>) TestBaseActivity.class);
                                        intent2.putExtra("status", false);
                                        intent2.putExtra(Const.TEST_SERIES_ID, this.quiz_id);
                                        intent2.putExtra(Const.TEST_SERIES_Name, this.testname);
                                        SharedPreference.getInstance().putString("test_series", jsonObject.toString());
                                        intent2.putExtra("course_id", this.course_id);
                                        intent2.putExtra(Const.TOTAL_QUESTIONS, this.testquestion);
                                        intent2.putExtra("first_attempt", this.first_attempt);
                                        intent2.putExtra("result_date", this.result_date);
                                        intent2.putExtra("test_submission", this.submition_type);
                                        intent2.putExtra(Const.LANG, this.lang);
                                        intent2.putExtra("time", lValueOf);
                                        intent2.putExtra("enddate", this.videodata.getEnd_date());
                                        Helper.gotoActivity(intent2, this);
                                    } else {
                                        initialzehomepage();
                                        Toast.makeText(this, getResources().getString(R.string.no_question_found), 0).show();
                                    }
                                    pushEvent();
                                }
                            }
                        } else {
                            Toast.makeText(this, "Language not found!", 0).show();
                        }
                    } catch (Exception unused) {
                        initialzehomepage();
                        Toast.makeText(this, getResources().getString(R.string.something_went_wrong), 0).show();
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
            case 6:
                if (jsonObject.optString("status").equals("true")) {
                    this.currentTime = jsonObject.getString("time");
                    JSONArray jSONArray = jsonObject.getJSONArray("data");
                    this.courseArrayLists = new ArrayList();
                    this.localCancelledEmi = new ArrayList();
                    this.filteredArraylist = new ArrayList();
                    this.localCancelledEmi = this.utkashRoom.getExpiredCancelledDao().getCancelledData();
                    for (int i8 = 0; i8 < jSONArray.length(); i8++) {
                        this.courseArrayLists.add((ExpiredEmiModel) new Gson().fromJson(jSONArray.getJSONObject(i8).toString(), ExpiredEmiModel.class));
                    }
                    for (int i9 = 0; i9 < this.courseArrayLists.size(); i9++) {
                        boolean z = false;
                        for (int i10 = 0; i10 < this.localCancelledEmi.size(); i10++) {
                            if (this.courseArrayLists.get(i9).getId().equalsIgnoreCase(this.localCancelledEmi.get(i10).getId())) {
                                if (Long.parseLong(this.currentTime) * 1000 > Long.parseLong(this.localCancelledEmi.get(i10).getCheck_for_expiry())) {
                                    this.utkashRoom.getExpiredCancelledDao().deleteRecord(this.localCancelledEmi.get(i10).getId());
                                } else {
                                    z = true;
                                }
                            }
                        }
                        if (!z) {
                            this.filteredArraylist.add(this.courseArrayLists.get(i9));
                        }
                    }
                    this.emiRecyclerView.setAdapter(new SliderAdapterEmi(this.filteredArraylist, homeactivitytheme3, this.emiRecyclerView));
                } else {
                    RetrofitResponse.GetApiData(this, jsonObject.optString("auth_code"), jsonObject.optString("message"), false);
                }
                break;
            case 7:
                if (jsonObject.optString("status").equals("true")) {
                    if (jsonObject.optJSONObject("data").optString("show_emi_due_popup").equalsIgnoreCase("1")) {
                        showEmiDialog();
                        showEmiUIOnTop();
                    }
                } else {
                    RetrofitResponse.GetApiData(this, jsonObject.has("auth_code") ? jsonObject.getString("auth_code") : "", jsonObject.getString("message"), false);
                }
                break;
        }
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

    private void automateViewPagerSwiping() {
        if (this.bannerAdapter != null) {
            final Runnable runnable = new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme3$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$automateViewPagerSwiping$13();
                }
            };
            this.timer.schedule(new TimerTask() { // from class: com.appnew.android.Theme.DashboardActivityTheme3.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    new Handler(Looper.getMainLooper()).post(runnable);
                }
            }, 500L, 10000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$automateViewPagerSwiping$13() {
        if (((AppBarHomeTheme3Binding) Objects.requireNonNull(this.binding.dashBoardMain)).sliderViewPager.getCurrentItem() == this.bannerAdapter.getItemCount() - 1) {
            this.binding.dashBoardMain.sliderViewPager.setCurrentItem(0);
        } else {
            this.binding.dashBoardMain.sliderViewPager.setCurrentItem(this.binding.dashBoardMain.sliderViewPager.getCurrentItem() + 1, true);
        }
    }

    private void setHomeDrawer() {
        setSupportActionBar(this.binding.dashBoardMain.dashboardToolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.menu);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, this.binding.drawerLayout, this.binding.dashBoardMain.dashboardToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        this.toggle = actionBarDrawerToggle;
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        this.binding.drawerLayout.setDrawerListener(this.toggle);
        this.toggle.syncState();
        this.binding.drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme3.6
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
                Helper.HideKeyboard(DashboardActivityTheme3.this);
            }
        });
        ActionBarDrawerToggle actionBarDrawerToggle2 = new ActionBarDrawerToggle(this, this.binding.drawerLayout, this.binding.dashBoardMain.dashboardToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) { // from class: com.appnew.android.Theme.DashboardActivityTheme3.7
            @Override // androidx.appcompat.app.ActionBarDrawerToggle, androidx.drawerlayout.widget.DrawerLayout.DrawerListener
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override // androidx.appcompat.app.ActionBarDrawerToggle, androidx.drawerlayout.widget.DrawerLayout.DrawerListener
            public void onDrawerOpened(View drawerView) {
                String string = SharedPreference.getInstance().getString(Const.SERVER_TIME);
                if (TextUtils.isEmpty(string) || string.equals("0")) {
                    if (SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE).equalsIgnoreCase("") || SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE).equals("0")) {
                        DashboardActivityTheme3.this.networkCall.NetworkAPICall(API.IS_COUPON_AVAILABLE, "", false, false);
                    } else if (Integer.parseInt(SharedPreference.getInstance().getString(Const.IS_COUPON_AVAILABLE)) > 0) {
                        DashboardActivityTheme3.this.createMenus();
                    }
                } else if (Long.parseLong(string) <= System.currentTimeMillis()) {
                    DashboardActivityTheme3.this.networkCall.NetworkAPICall(API.IS_COUPON_AVAILABLE, "", false, false);
                }
                Helper.HideKeyboard(DashboardActivityTheme3.this);
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
            leftNavAdapter.setLeftNavAdapterListener(new LeftNavAdapter.LeftNavAdapterListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme3$$ExternalSyntheticLambda23
                @Override // com.appnew.android.home.adapters.LeftNavAdapter.LeftNavAdapterListener
                public final void onItemClick(Menu menu) {
                    this.f$0.lambda$createMenus$14(leftNavAdapter, menu);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        socialIconsVisibility(this.leftMenu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createMenus$14(LeftNavAdapter leftNavAdapter, Menu menu) {
        if (menu.getHaveChild().equalsIgnoreCase("1")) {
            menu.setExpanded(!menu.isExpanded());
        }
        handleLeftMenuClick(menu);
        leftNavAdapter.notifyDataSetChanged();
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
                case 1822:
                    if (type_code.equals(Constants.LEFT_NAV_KEY.contact_us_query)) {
                        b2 = Ascii.FS;
                    }
                    break;
                case 1823:
                    if (type_code.equals(Constants.LEFT_NAV_KEY.book_store)) {
                        b2 = Ascii.GS;
                    }
                    break;
                case NewHope.SENDA_BYTES /* 1824 */:
                    if (type_code.equals(Constants.LEFT_NAV_KEY.custom_payment)) {
                        b2 = Ascii.RS;
                    }
                    break;
            }
            switch (b2) {
                case 0:
                    Helper.gotoActivity(new Intent(this, (Class<?>) DownloadActivity.class), this);
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
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(BuildConfig.FAQ_URL)));
                    } else {
                        Helper.showToast(this, "Still in Development.", 0);
                    }
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 4:
                    ContactBottomSheetFragment contactBottomSheetFragment = new ContactBottomSheetFragment();
                    contactBottomSheetFragment.show(getSupportFragmentManager(), contactBottomSheetFragment.getTag());
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
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
                    if (SharedPreference.getInstance().getLoggedInUser().getId().equalsIgnoreCase("0")) {
                        Helper.GuestSignOutUser(this);
                    } else {
                        getLogoutDialog(this, getResources().getString(R.string.logout_title), getResources().getString(R.string.logout_confirmation_message));
                    }
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 9:
                    Intent intent2 = new Intent(this, (Class<?>) WebViewActivty.class);
                    intent2.putExtra("type", getResources().getString(R.string.terms_of_service));
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
                case 12:
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
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
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 14:
                    startActivity(new Intent(this, (Class<?>) PurchaseHistory.class));
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
                    Intent intent4 = new Intent(this, (Class<?>) WebViewActivty.class);
                    intent4.putExtra("type", getResources().getString(R.string.privacy_policy));
                    intent4.putExtra("url", API.PRIVACY_POLICY_URL);
                    Helper.gotoActivity(intent4, this);
                    break;
                case 21:
                case 22:
                case 23:
                case 25:
                    Intent intent5 = new Intent(this, (Class<?>) Suggestion.class);
                    if (type_code.equals("22")) {
                        intent5.putExtra("title_key", Const.FEEDBACK);
                    } else if (type_code.equals("23")) {
                        intent5.putExtra("title_key", "Suggestion");
                    } else if (type_code.equals("24")) {
                        intent5.putExtra("title_key", "Complaint");
                    } else if (type_code.equals(Constants.LEFT_NAV_KEY.user_support)) {
                        intent5.putExtra("title_key", "User Support");
                    }
                    startActivity(intent5);
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 24:
                    Intent intent6 = new Intent(this, (Class<?>) CurrentAffairActivity.class);
                    intent6.putExtra("title_key", "Current Affair");
                    startActivity(intent6);
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 26:
                    Intent intent7 = new Intent(this, (Class<?>) BookMarkList.class);
                    intent7.putExtra("title_key", "Bookmark");
                    startActivity(intent7);
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 27:
                    Intent intent8 = new Intent(this, (Class<?>) DownloadPDFActivity.class);
                    intent8.putExtra("title_key", "Download");
                    startActivity(intent8);
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 28:
                    Intent intent9 = new Intent(this, (Class<?>) ContactUsPage.class);
                    intent9.putExtra("from", Constants.LEFT_NAV_KEY.contact_us_query);
                    startActivity(intent9);
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    break;
                case 29:
                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    if (this.leftMenu.getBook_store_link() != null && !this.leftMenu.getBook_store_link().equalsIgnoreCase("")) {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.leftMenu.getBook_store_link())));
                        break;
                    }
                    break;
                case 30:
                    Intent intent10 = new Intent(this, (Class<?>) CustomPaymentActivity.class);
                    intent10.putExtra("type", "Custom Payment");
                    intent10.putExtra("courseid", this.leftMenu.getCustom_course());
                    Helper.gotoActivity(intent10, this);
                    break;
            }
        }
    }

    public void getLogoutDialog(final Activity ctx, final String title, final String message) {
        DialogUtils.makeDialog(this, title, message, getResources().getString(R.string.yes), getResources().getString(R.string.no), true, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Theme.DashboardActivityTheme3$$ExternalSyntheticLambda13
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
            public final void onOKClick() {
                this.f$0.lambda$getLogoutDialog$15();
            }
        }, new DialogUtils.onDialogUtilsCancelClick() { // from class: com.appnew.android.Theme.DashboardActivityTheme3$$ExternalSyntheticLambda14
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsCancelClick
            public final void onCancelClick() {
                DashboardActivityTheme3.lambda$getLogoutDialog$16();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getLogoutDialog$15() {
        if (Helper.isConnected(this)) {
            UserLogout();
        } else {
            Toast.makeText(this, "No Internet connection", 0).show();
        }
    }

    public void UserLogout() {
        this.networkCall.NetworkAPICall(API.user_logout, "", true, false);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.utkashRoom = null;
    }

    @Override // com.appnew.android.Theme.Adapter.DashboardTabAdapter.addDashboardItemClicked
    public void onDashboardItemClicked(int position, String course_id) {
        Bundle bundle = new Bundle();
        if (TextUtils.isEmpty(this.courseTypeMasterTables.get(position).getCourse_id()) || this.courseTypeMasterTables.get(position).getCourse_id().equalsIgnoreCase("0")) {
            bundle.putInt(Const.NOTIFICATION_CODE, this.notification_code);
            bundle.putString("course_id", course_id);
            bundle.putString("file_id", this.fieldid);
            bundle.putString(Const.TOPIC_ID, this.topicid);
            bundle.putString("tile_id", this.tileid);
            bundle.putString(Const.TILE_TYPE, this.tiletype);
            bundle.putString(Const.REVERT_API, this.revertapi);
            if (!GenericUtils.isListEmpty(this.courseTypeMasterTables)) {
                bundle.putString("title", this.courseTypeMasterTables.get(position).getName());
            } else {
                bundle.putString("title", "");
            }
            bundle.putString(TypedValues.AttributesType.S_TARGET, this.message_target);
            bundle.putString("url", this.url);
            bundle.putString("image", this.imageUrl);
            bundle.putString("message", this.message);
            bundle.putSerializable("master_cat", (Serializable) this.masterAllCatTables);
            if (!GenericUtils.isListEmpty(this.courseTypeMasterTables) && !GenericUtils.isEmpty(this.courseTypeMasterTables.get(position).getCat_type())) {
                bundle.putString(Const.IS_BOOK, this.courseTypeMasterTables.get(position).getCat_type());
            } else {
                bundle.putString(Const.IS_BOOK, "0");
            }
            if (!GenericUtils.isListEmpty(this.courseTypeMasterTables)) {
                bundle.putString(Const.TAB_ID, this.courseTypeMasterTables.get(position).getId());
            } else {
                bundle.putString(Const.TAB_ID, "1");
            }
            if (this.courseTypeMasterTables.size() > 1) {
                bundle.putString(Const.TAB_NAME, this.courseTypeMasterTables.get(position).getName());
            } else {
                bundle.putString(Const.TAB_NAME, "");
            }
            if (!GenericUtils.isListEmpty(this.courseTypeMasterTables) && !GenericUtils.isEmpty(this.courseTypeMasterTables.get(position).getMaster_category_id())) {
                bundle.putString(Const.MASTER_CATEGORY_ID, this.courseTypeMasterTables.get(position).getMaster_category_id());
            } else {
                bundle.putString(Const.MASTER_CATEGORY_ID, "0");
            }
            if (!GenericUtils.isListEmpty(this.mastercatlist)) {
                String master_category_id = this.courseTypeMasterTables.get(position).getMaster_category_id();
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
                List<MasteAllCatTable> list = this.masterAllCatTables;
                if (list != null && list.size() > 0) {
                    MakeMyExam.setTileData2(new Gson().toJson(this.masterAllCatTables));
                }
            }
            if (this.courseTypeMasterTables.get(position).getDisplay_type().equalsIgnoreCase("1")) {
                startActivity(new Intent(this, (Class<?>) CourseTypeActivity.class).putExtras(bundle));
                return;
            } else {
                startActivity(new Intent(this, (Class<?>) HomeActivity.class).putExtras(bundle));
                return;
            }
        }
        if (this.courseTypeMasterTables.get(position).getName().equalsIgnoreCase("Extra Classes")) {
            startActivity(new Intent(this, (Class<?>) ExtraClassesActivity.class).putExtra("title", this.courseTypeMasterTables.get(position).getName()));
            return;
        }
        Intent intent = new Intent(this, (Class<?>) CourseActivity.class);
        intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
        intent.putExtra(Const.COURSE_ID_MAIN, this.courseTypeMasterTables.get(position).getCourse_id());
        intent.putExtra(Const.COURSE_PARENT_ID, "");
        intent.putExtra(Const.IS_COMBO, false);
        intent.putExtra(AnalyticsConstants.course_name, this.courseTypeMasterTables.get(position).getName());
        Helper.gotoActivity(intent, this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
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
                        runOnUiThread(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme3$$ExternalSyntheticLambda10
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$initialzehomepage$17();
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initialzehomepage$17() {
        this.dashboardTabAdapter.notifyDataSetChanged();
        selectedData();
        List<BannerListTable> list = this.bannerListTables;
        if (list != null && list.size() > 0) {
            this.bannerAdapter = new BannerAdapter(this, this.bannerListTables);
            this.binding.dashBoardMain.sliderViewPager.setAdapter(this.bannerAdapter);
        }
        automateViewPagerSwiping();
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
                    Helper.GoToLiveVideoActivity(video.getChat_node(), this, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getIs_chat_lock(), video.getPayloadData().getCourse_id(), "", this.parentid, video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_live(), new ArrayList());
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

    private void hit_api_for_data() {
        this.networkCall.NetworkAPICall(API.API_GET_MASTER_DATA, this.contentType, true, false);
    }

    private void hit_api_for_iniializetest() {
        this.networkCall.NetworkAPICall(API.API_GET_TEST_INSTRUCTION_DATA, "", true, false);
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
                Snackbar.make(this.binding.drawerLayout.getRootView(), "Test will start on " + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(videoArrayList.get(0).getStart_date()) * 1000)), -1).show();
                initialzehomepage();
                return;
            }
            TestTable testTableTest_data = this.utkashRoom.getTestDao().test_data(videoArrayList.get(0).getId(), MakeMyExam.userId);
            if (testTableTest_data != null && testTableTest_data.getStatus() != null && !testTableTest_data.getStatus().equalsIgnoreCase("")) {
                Snackbar.make(this.binding.drawerLayout.getRootView(), "You have already Attempted the test", -1).show();
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
            Snackbar.make(this.binding.drawerLayout.getRootView(), "Your Result will be declare on " + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(videoArrayList.get(0).getResult_date()) * 1000)), -1).show();
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
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme3.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DashboardActivityTheme3 dashboardActivityTheme3 = DashboardActivityTheme3.this;
                    TextView textView9 = textView5;
                    TestBasicInst testBasicInst = testBasic;
                    TextView textView10 = textView8;
                    dashboardActivityTheme3.showPopMenuForLangauge(textView9, testBasicInst, textView10, textView10);
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
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme3.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (testBasic.getTotalQuestions().equalsIgnoreCase("0")) {
                    Toast.makeText(DashboardActivityTheme3.this, "Please add Question.", 0).show();
                    return;
                }
                if (checkBox3.isChecked()) {
                    dialog.dismiss();
                    DashboardActivityTheme3.this.quiz_id = testBasic.getId();
                    DashboardActivityTheme3 dashboardActivityTheme3 = DashboardActivityTheme3.this;
                    new NetworkCall(dashboardActivityTheme3, dashboardActivityTheme3).NetworkAPICall(API.API_GET_INFO_TEST_SERIES, "", true, false);
                    return;
                }
                Toast.makeText(DashboardActivityTheme3.this, "Please check following instructions.", 0).show();
            }
        });
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme3.10
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialog2, int keyCode, KeyEvent event) {
                if (keyCode != 4) {
                    return true;
                }
                DashboardActivityTheme3.this.initialzehomepage();
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
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme3.11
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem item) {
                ((TextView) v).setText(item.getTitle().toString());
                if (item.getTitle().toString().equals(DashboardActivityTheme3.this.getResources().getString(R.string.hindi))) {
                    DashboardActivityTheme3.this.lang = 2;
                    if (testBasicInst.getMulti_description().get(1).getDescription() != null) {
                        v1.setText(Html.fromHtml(testBasicInst.getMulti_description().get(1).getDescription()));
                    }
                } else if (item.getTitle().toString().equals(DashboardActivityTheme3.this.getResources().getString(R.string.english))) {
                    DashboardActivityTheme3.this.lang = 1;
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

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
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
            } else {
                this.binding.profileName.setText(getResources().getString(R.string.user));
                this.binding.profileEmail.setText(getResources().getString(R.string.user_mail));
            }
        } catch (Exception unused) {
        }
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
                            this.courseTypeMasterTables.addAll(this.utkashRoom.getcoursetypemaster().getcourse_typemaster(MakeMyExam.userId));
                            this.masterAllCatTables = this.utkashRoom.getMasterAllCatDao().getmaster_allcat(MakeMyExam.userId);
                            this.mastercatlist = this.utkashRoom.getMastercatDao().getmastercat(MakeMyExam.userId);
                            this.bannerListTables = this.utkashRoom.getBannerTableDao().getBanner(MakeMyExam.getUserId());
                            this.bottomMenuTables = this.utkashRoom.getBottomMenuTableDao().getBottomMenu(MakeMyExam.getUserId());
                        }
                        runOnUiThread(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme3$$ExternalSyntheticLambda12
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$onRestart$18();
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
        } finally {
            this.notification_code = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onRestart$18() {
        this.dashboardTabAdapter.notifyDataSetChanged();
        selectedData();
        List<BannerListTable> list = this.bannerListTables;
        if (list != null && list.size() > 0) {
            this.bannerAdapter = new BannerAdapter(this, this.bannerListTables);
            this.binding.dashBoardMain.sliderViewPager.setAdapter(this.bannerAdapter);
        }
        automateViewPagerSwiping();
    }

    public void homeAutoRefresh() {
        if (SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT) == 0) {
            ShortcutBadger.applyCount(getApplicationContext(), SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT));
            ((LinearLayout) Objects.requireNonNull(((AppBarHomeTheme3Binding) Objects.requireNonNull(this.binding.dashBoardMain)).cvrNotificationCount1)).setBackgroundResource(R.drawable.uncircle_notification_count);
            runOnUiThread(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme3.12
                @Override // java.lang.Runnable
                public void run() {
                    DashboardActivityTheme3.this.binding.dashBoardMain.notificaionCount1.setText(String.valueOf(SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT)));
                }
            });
            this.binding.dashBoardMain.cvrNotificationCount1.setVisibility(8);
            return;
        }
        runOnUiThread(new Runnable() { // from class: com.appnew.android.Theme.DashboardActivityTheme3.13
            @Override // java.lang.Runnable
            public void run() {
                ((AppBarHomeTheme3Binding) Objects.requireNonNull(DashboardActivityTheme3.this.binding.dashBoardMain)).cvrNotificationCount1.setVisibility(0);
                ShortcutBadger.applyCount(DashboardActivityTheme3.this.getApplicationContext(), SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT));
                DashboardActivityTheme3.this.binding.dashBoardMain.cvrNotificationCount1.setBackgroundResource(R.drawable.circle_notification_count);
                if (SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT) > 99) {
                    DashboardActivityTheme3.this.binding.dashBoardMain.notificaionCount1.setText(DashboardActivityTheme3.this.getResources().getString(R.string.nine_nine));
                } else if (SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT) > 0) {
                    DashboardActivityTheme3.this.binding.dashBoardMain.notificaionCount1.setText(String.valueOf(SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT)));
                } else {
                    DashboardActivityTheme3.this.binding.dashBoardMain.cvrNotificationCount1.setVisibility(8);
                }
            }
        });
    }

    private void socialIconsVisibility(final LeftMenu leftMenu) {
        if (leftMenu != null) {
            if (Helper.isNullChek(leftMenu.getTelegram_link_data()) && leftMenu.getTelegram_link().equalsIgnoreCase("1")) {
                this.binding.iconTelegram.setVisibility(0);
                this.binding.iconTelegram.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme3$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$19(leftMenu);
                    }
                }));
            }
            if (Helper.isNullChek(leftMenu.getInstagram_link_data()) && leftMenu.getInstagram_link().equalsIgnoreCase("1")) {
                this.binding.iconInstagram.setVisibility(0);
                this.binding.iconInstagram.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme3$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$20(leftMenu);
                    }
                }));
            }
            if (Helper.isNullChek(leftMenu.getLinkedin_link_data()) && leftMenu.getLinkedin_link().equalsIgnoreCase("1")) {
                this.binding.iconLinkedIn.setVisibility(0);
                this.binding.iconLinkedIn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme3$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$21(leftMenu);
                    }
                }));
            }
            if (Helper.isNullChek(leftMenu.getYoutube_link_data()) && leftMenu.getYoutube_link().equalsIgnoreCase("1")) {
                this.binding.iconYoutube.setVisibility(0);
                this.binding.iconYoutube.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme3$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$22(leftMenu);
                    }
                }));
            }
            if (Helper.isNullChek(leftMenu.getFacebook_link_data()) && leftMenu.getFacebook_link().equalsIgnoreCase("1")) {
                this.binding.iconFacebook.setVisibility(0);
                this.binding.iconFacebook.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme3$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$23(leftMenu);
                    }
                }));
            }
            if (Helper.isNullChek(leftMenu.getTwitter_link_data()) && leftMenu.getTwitter_link().equalsIgnoreCase("1")) {
                this.binding.iconTwitter.setVisibility(0);
                this.binding.iconTwitter.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Theme.DashboardActivityTheme3$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$socialIconsVisibility$24(leftMenu);
                    }
                }));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$19(LeftMenu leftMenu) {
        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getTelegram_link_data())));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$20(LeftMenu leftMenu) {
        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getInstagram_link_data())));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$21(LeftMenu leftMenu) {
        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getLinkedin_link_data())));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$22(LeftMenu leftMenu) {
        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getYoutube_link_data())));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$23(LeftMenu leftMenu) {
        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getFacebook_link_data())));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$socialIconsVisibility$24(LeftMenu leftMenu) {
        this.binding.drawerLayout.closeDrawer(GravityCompat.START);
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(leftMenu.getTwitter_link_data())));
        return null;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Exception e2;
        String strCopyFileToInternalStorage;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1203 && resultCode == -1 && data != null) {
            try {
                strCopyFileToInternalStorage = copyFileToInternalStorage(data.getData(), "SubjectiveTestPDF");
            } catch (Exception e3) {
                e2 = e3;
                Exception exc = e2;
                Toast.makeText(this, R.string.unable_to_upload_this_file, 0).show();
                exc.printStackTrace();
                return;
            }
            try {
                Helper.GoToWebViewPDFActivity(this, Constants.SUB_TEST_ID, strCopyFileToInternalStorage, false, strCopyFileToInternalStorage.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r0.length - 1], this.course_id + MqttTopic.MULTI_LEVEL_WILDCARD + Constants.SUB_TEST_ID, true, "CourseActivity", true);
            } catch (Exception e4) {
                e2 = e4;
                Exception exc2 = e2;
                Toast.makeText(this, R.string.unable_to_upload_this_file, 0).show();
                exc2.printStackTrace();
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

    private void showsubjectivepopup(ArrayList<Video> videoArrayList) {
        final Video video;
        Button button;
        Button button2;
        Video video2 = videoArrayList.get(0);
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
        Button button3 = (Button) viewInflate.findViewById(R.id.paper);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.ibt_single_sub_vd_iv);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.backimag);
        AppCompatTextView appCompatTextView = (AppCompatTextView) viewInflate.findViewById(R.id.test_name);
        Button button4 = (Button) viewInflate.findViewById(R.id.upload);
        Button button5 = (Button) viewInflate.findViewById(R.id.booklet);
        Button button6 = (Button) viewInflate.findViewById(R.id.marks);
        if (!video2.getEnd_date().equalsIgnoreCase("0") && !video2.getEnd_date().equalsIgnoreCase("")) {
            textView2.setVisibility(0);
            button = button4;
            button2 = button5;
            video = video2;
            textView2.setText("Test Start: " + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.US).format(new Date(Long.parseLong(video2.getStart_date()) * 1000))) + "\nTest End: " + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.US).format(new Date(Long.parseLong(video2.getEnd_date()) * 1000))));
        } else {
            video = video2;
            button = button4;
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
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme3.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                    DashboardActivityTheme3.this.initialzehomepage();
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme3.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (System.currentTimeMillis() < Long.parseLong(video.getStart_date()) * 1000) {
                    Toast.makeText(DashboardActivityTheme3.this, "Test will start on " + new SimpleDateFormat("dd/MM/yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                    return;
                }
                if (!Helper.isConnected(this)) {
                    Toast.makeText(this, "No Internet Connection", 0).show();
                    return;
                }
                if (video.getIs_locked().equalsIgnoreCase("1")) {
                    if (DashboardActivityTheme3.this.parentid == null || DashboardActivityTheme3.this.parentid.equalsIgnoreCase("")) {
                        Intent intent = new Intent(DashboardActivityTheme3.this, (Class<?>) CourseActivity.class);
                        intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                        intent.putExtra(Const.COURSE_ID_MAIN, video.getPayloadData().getCourse_id());
                        intent.putExtra(Const.COURSE_PARENT_ID, "");
                        intent.putExtra(Const.IS_COMBO, false);
                        SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                        DashboardActivityTheme3.this.startActivity(intent);
                        return;
                    }
                    Intent intent2 = new Intent(DashboardActivityTheme3.this, (Class<?>) CourseActivity.class);
                    intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent2.putExtra(Const.COURSE_ID_MAIN, DashboardActivityTheme3.this.parentid);
                    intent2.putExtra(Const.COURSE_PARENT_ID, "");
                    intent2.putExtra(Const.IS_COMBO, false);
                    SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                    DashboardActivityTheme3.this.startActivity(intent2);
                    return;
                }
                if (!video.getQuestion().equalsIgnoreCase("")) {
                    Constants.SUB_TEST_ID = video.getId();
                    Helper.GoToWebViewPDFActivity(this, video.getId(), video.getQuestion(), true, video.getQuestion().split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r11.length - 1].split("\\.")[0], DashboardActivityTheme3.this.course_id, video.getIs_share());
                    return;
                }
                Toast.makeText(this, "File not found.", 0).show();
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme3.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (System.currentTimeMillis() < Long.parseLong(video.getStart_date()) * 1000) {
                    Toast.makeText(this, "Test will start on " + new SimpleDateFormat("dd/MM/yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                    return;
                }
                if (!Helper.isConnected(this)) {
                    Toast.makeText(this, "No Internet Connection", 0).show();
                    return;
                }
                if (video.getIs_locked().equalsIgnoreCase("1")) {
                    if (DashboardActivityTheme3.this.parentid == null || DashboardActivityTheme3.this.parentid.equalsIgnoreCase("")) {
                        Intent intent = new Intent(DashboardActivityTheme3.this, (Class<?>) CourseActivity.class);
                        intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                        intent.putExtra(Const.COURSE_ID_MAIN, video.getPayloadData().getCourse_id());
                        intent.putExtra(Const.COURSE_PARENT_ID, "");
                        intent.putExtra(Const.IS_COMBO, false);
                        SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                        DashboardActivityTheme3.this.startActivity(intent);
                        return;
                    }
                    Intent intent2 = new Intent(DashboardActivityTheme3.this, (Class<?>) CourseActivity.class);
                    intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent2.putExtra(Const.COURSE_ID_MAIN, DashboardActivityTheme3.this.parentid);
                    intent2.putExtra(Const.COURSE_PARENT_ID, "");
                    intent2.putExtra(Const.IS_COMBO, false);
                    SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                    DashboardActivityTheme3.this.startActivity(intent2);
                    return;
                }
                Constants.SUB_TEST_ID = video.getId();
                DashboardActivityTheme3.this.checkStoragePermission();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme3.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Long.parseLong(video.getResult_date()) * 1000 < System.currentTimeMillis()) {
                    if (!Helper.isConnected(this)) {
                        Toast.makeText(this, "No Internet Connection", 0).show();
                        return;
                    }
                    if (video.getIs_locked().equalsIgnoreCase("1")) {
                        if (DashboardActivityTheme3.this.parentid == null || DashboardActivityTheme3.this.parentid.equalsIgnoreCase("")) {
                            Intent intent = new Intent(DashboardActivityTheme3.this, (Class<?>) CourseActivity.class);
                            intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                            intent.putExtra(Const.COURSE_ID_MAIN, video.getPayloadData().getCourse_id());
                            intent.putExtra(Const.COURSE_PARENT_ID, "");
                            intent.putExtra(Const.IS_COMBO, false);
                            SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                            DashboardActivityTheme3.this.startActivity(intent);
                            return;
                        }
                        Intent intent2 = new Intent(DashboardActivityTheme3.this, (Class<?>) CourseActivity.class);
                        intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                        intent2.putExtra(Const.COURSE_ID_MAIN, DashboardActivityTheme3.this.parentid);
                        intent2.putExtra(Const.COURSE_PARENT_ID, "");
                        intent2.putExtra(Const.IS_COMBO, false);
                        SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                        DashboardActivityTheme3.this.startActivity(intent2);
                        return;
                    }
                    if (!video.getAnswers().equalsIgnoreCase("")) {
                        Constants.SUB_TEST_ID = video.getId();
                        Helper.GoToWebViewPDFActivity(this, video.getId(), video.getAnswers(), true, video.getAnswers().split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r11.length - 1].split("\\.")[0], DashboardActivityTheme3.this.course_id, video.getIs_share());
                        return;
                    }
                    Toast.makeText(this, "File Not found.", 0).show();
                    return;
                }
                Toast.makeText(this, "Result will be available on " + new SimpleDateFormat("dd/MM/yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video.getResult_date()) * 1000)), 0).show();
            }
        });
        button6.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme3.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Long.parseLong(video.getResult_date()) * 1000 < System.currentTimeMillis()) {
                    if (!Helper.isConnected(this)) {
                        Toast.makeText(this, "No Internet Connection", 0).show();
                        return;
                    }
                    if (video.getIs_locked().equalsIgnoreCase("1")) {
                        if (DashboardActivityTheme3.this.parentid == null || DashboardActivityTheme3.this.parentid.equalsIgnoreCase("")) {
                            Intent intent = new Intent(DashboardActivityTheme3.this, (Class<?>) CourseActivity.class);
                            intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                            intent.putExtra(Const.COURSE_ID_MAIN, video.getPayloadData().getCourse_id());
                            intent.putExtra(Const.COURSE_PARENT_ID, "");
                            intent.putExtra(Const.IS_COMBO, false);
                            SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                            DashboardActivityTheme3.this.startActivity(intent);
                            return;
                        }
                        Intent intent2 = new Intent(DashboardActivityTheme3.this, (Class<?>) CourseActivity.class);
                        intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                        intent2.putExtra(Const.COURSE_ID_MAIN, DashboardActivityTheme3.this.parentid);
                        intent2.putExtra(Const.COURSE_PARENT_ID, "");
                        intent2.putExtra(Const.IS_COMBO, false);
                        SharedPreference.getInstance().putString("id", video.getPayloadData().getCourse_id());
                        DashboardActivityTheme3.this.startActivity(intent2);
                        return;
                    }
                    Constants.SUB_TEST_ID = video.getId();
                    Helper.GoToSubjectiveResultActivity(this, video.getSolutions(), video.getTest_series_name(), DashboardActivityTheme3.this.course_id, video.getId(), DashboardActivityTheme3.this.tiletype);
                    return;
                }
                Toast.makeText(this, "Result will be available on " + new SimpleDateFormat("dd/MM/yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video.getResult_date()) * 1000)), 0).show();
            }
        });
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.appnew.android.Theme.DashboardActivityTheme3.19
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialog2, int keyCode, KeyEvent event) {
                if (keyCode != 4) {
                    return true;
                }
                DashboardActivityTheme3.this.initialzehomepage();
                dialog.dismiss();
                return true;
            }
        });
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

    private void showEmiDialog() {
        hitGetInstallmentDataApi();
    }

    private void hitGetInstallmentDataApi() {
        this.networkCall.NetworkAPICall(API.API_Installment_Course_List, "", true, false);
    }

    private void refreshApiFromDownloads() {
        if (Helper.isConnected(this)) {
            new NetworkCall(this, this).NetworkAPICall(API.master_content, "", true, false);
        }
    }

    private void pushEventForInApp(String actionType, BannerListTable bannerListTable) {
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
