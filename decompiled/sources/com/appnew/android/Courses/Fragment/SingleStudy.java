package com.appnew.android.Courses.Fragment;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.StrikethroughSpan;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.BuildConfig;
import com.appnew.android.Cart.Activity.CartItemsActivity;
import com.appnew.android.Coupon.Models.Available;
import com.appnew.android.Coupon.Models.CouponPojo;
import com.appnew.android.Coupon.Models.CoursesCoupon;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter;
import com.appnew.android.Courses.Adapter.SingleStudyAdapter;
import com.appnew.android.Courses.Adapter.SingleStudyAdapter2;
import com.appnew.android.Courses.Adapter.SingleStudyAdapter4;
import com.appnew.android.Download.Audio.AudioPlayerService;
import com.appnew.android.DownloadServices.VideoDownloadService;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.FacebookEventLogger;
import com.appnew.android.Model.BottomSetting;
import com.appnew.android.Model.COURSEDETAIL.Author;
import com.appnew.android.Model.COURSEDETAIL.CourseDetail;
import com.appnew.android.Model.COURSEDETAIL.CourseDetailData;
import com.appnew.android.Model.COURSEDETAIL.Data;
import com.appnew.android.Model.COURSEDETAIL.TilesItem;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Model.Courses.ExamPrepItem;
import com.appnew.android.Model.Courses.InstallmentResponse;
import com.appnew.android.Model.Courses.Lists;
import com.appnew.android.Model.DueEmiTable;
import com.appnew.android.Model.ExtraJson;
import com.appnew.android.Model.FAQs.FaqData;
import com.appnew.android.Model.LeftMenu;
import com.appnew.android.Model.Overview.OverviewData;
import com.appnew.android.Model.TimeTable.TimeTableModel;
import com.appnew.android.Model.Video;
import com.appnew.android.Model.subscription.SubscriptionAllData;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Payment.PurchaseActivity;
import com.appnew.android.PurchaseHistory.activity.InstallmentDetailActivity;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.GenericUtils;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.MainFragment;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.PreferencesUtil;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.UpdateProfileDialogUtils;
import com.appnew.android.Zoom.Activity.RattingActivity;
import com.appnew.android.cleverTap.AnalyticHelper;
import com.appnew.android.folder.DebouncingOnClickListener;
import com.appnew.android.folder.activity.FolderActivity;
import com.appnew.android.home.Constants;
import com.appnew.android.player.music_player.MusicService;
import com.appnew.android.pojo.Userinfo.StatesCities.StatesCities;
import com.appnew.android.pojo.Userinfo.StatesCities.StatesCitiesData;
import com.appnew.android.socket.models.ChatModel;
import com.appnew.android.table.CourseDetailTable;
import com.appnew.android.table.ThemeSettings;
import com.appnew.android.table.UserWiseCourseTable;
import com.appnew.android.table.VideosDownload;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.eduteria.app.app.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tv9news.utils.helpers.AnalyticEvents;
import com.tv9news.utils.helpers.AnalyticsConstants;
import de.hdodenhof.circleimageview.CircleImageView;
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import me.leolin.shortcutbadger.ShortcutBadger;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes6.dex */
public class SingleStudy extends MainFragment implements SingleStudyAdapter.onButtonClicked, View.OnClickListener, SingleStudyAdapter4.onButtonClicked4, SingleStudyAdapter.onQuantityUpdate {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static String AADHAR_IMAGE = "aadhar_image";
    private static String STUDENT_IMAGE = "student_image";
    private static Context _context = null;
    private static CircleImageView adharImage = null;
    private static String adharImhPath = "";
    private static String imagepath = "";
    public static String parentCourseId = "";
    private static CircleImageView userImage = null;
    public static String valid_to = "";
    RelativeLayout RL_singleStudy;
    Activity activity;
    ArrayList<Video> actual_videolist;
    private TextView authorname;
    Button backBtn;
    BottomSetting bottomSetting;
    RelativeLayout buttonLow;
    Button buyNowBtn;
    Button buyNowBtn_1;
    RelativeLayout buyNowBtn_head;
    TilesItem cardItem;
    private int cardPosition;
    StatesCities cities;
    TextView citySpinner;
    FrameLayout container;
    String content_type;
    private Activity context;
    StatesCities countries;
    TextView countrySpinner;
    private CouponPojo couponPojo;
    ArrayList<Courselist> courseDataArrayList;
    ImageView courseImagebg;
    private TextView coursename;
    CourseDetail cousedetail;
    TilesItem currentTileItem;
    private String dob;
    RelativeLayout dueEmiLayout;
    private String email;
    private Dialog enrollmentDialog;
    EditText etSearch;
    ExamPrepItem examPrepItem;
    ExamPrepLayer3Adapter examPrepLayer3Adapter;
    private String fProfession;
    ArrayList<FaqData> faqData;
    private String fatherMobile;
    private String fatherName;
    GridLayoutManager gridLayoutManager;
    RelativeLayout headerLL;
    ImageView ivClearSearch;
    LeftMenu leftMenu;
    LinearLayoutManager linearLayoutManager;
    LinearLayoutManager linearLayoutManager1;
    LinearLayout linear_addToCart;
    LinearLayoutCompat ll_compat;
    private LinearLayout ll_scholorship_discount;
    String mainCourseId;
    String masterContent;
    private TilesItem masterTileItem;
    private int masterTilePos;
    private List<TilesItem> masterTiles;
    TextView mrpCutTV;
    Button myLibBtn;
    NestedScrollView nestedScrollView;
    RelativeLayout no_data_found_RL;
    RelativeLayout no_data_found_RL_Header;
    OverviewData overviewData;
    private String pageLimit;
    ProgressBar paginationLoader;
    TextView payEmi;
    private String permanentAddress;
    TextView price;
    LinearLayout priceLL;
    String revertAPI;
    RelativeLayout rl_no_data;
    private String sProfession;
    private TextView scholarshipCouponTV;
    ExamPrepItem searchList;
    RecyclerView searchRecyclerview;
    SingleStudyAdapter singleStudyAdapter;
    SingleStudyAdapter2 singleStudyAdapter2;
    SingleStudyAdapter4 singleStudyAdapter4;
    FrameLayout soldOutImg;
    StateCityAdapter stateCityAdapter;
    TextView stateSpinner;
    StatesCities states;
    private String studentMobile;
    private String studentName;
    RecyclerView studyCourseRV;
    RecyclerView studyCourseRVContent;
    RecyclerView studyCourseRVTile;
    String tileIdAPI;
    RecyclerView tileRv;
    String tileTypeAPI;
    Dialog tokenDialog;
    TextView tvGstDesc;
    TextView txtTitle;
    String typeApi;
    private UtkashRoom utkashRoom;
    private TextView validityTV;
    ArrayList<Video> videoArrayList;
    RelativeLayout view_header;
    String is_purchased_course = "0";
    String isSkip = "";
    List<ExamPrepItem> examPrepItemList = new ArrayList();
    int tilePos = 0;
    String contentTYpe = "";
    String content_master = "";
    String contentNew = "";
    String course_name = "";
    boolean isCombo = false;
    boolean isCourseCombo = false;
    String linkType = "";
    private String pre_txtid = "";
    private String pos_txn_id = "";
    private boolean isSkip3 = false;
    private boolean isPaginationAvailable = true;
    private int mPage = 1;
    boolean status = false;
    boolean isGroupChatClicked = false;
    String SelectedCountryid = "";
    String SelectedStateid = "";
    String SelectedCityid = "";
    String stateindex = "";
    String cityindex = "";
    String countryindex = "";
    String clicktype = "";
    private String combo_id = "";
    private String issearchnable = "";
    private String folderContentType = "";
    private boolean is_test_data = false;
    private BroadcastReceiver videoDownloadReceiver = new BroadcastReceiver() { // from class: com.appnew.android.Courses.Fragment.SingleStudy.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("result", -1);
            String stringExtra = intent.getStringExtra("video_time");
            String stringExtra2 = intent.getStringExtra("resourceId");
            if (intExtra != 1 || SingleStudy.this.singleStudyAdapter == null || stringExtra2 == null || stringExtra2.equals("") || SingleStudy.this.examPrepItem == null || SingleStudy.this.examPrepItem.getList() == null || SingleStudy.this.examPrepItem.getList().isEmpty()) {
                return;
            }
            for (Lists lists : SingleStudy.this.examPrepItem.getList()) {
                if (lists.getId().equalsIgnoreCase(stringExtra2)) {
                    lists.setVideo_download(true);
                    lists.setVideo_status("Downloaded");
                    lists.setVideo_time(stringExtra);
                    SingleStudy.this.singleStudyAdapter.notifyDataSetChanged();
                    return;
                }
            }
        }
    };
    private BroadcastReceiver audioServiceReceiver = new BroadcastReceiver() { // from class: com.appnew.android.Courses.Fragment.SingleStudy.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean booleanExtra = intent.getBooleanExtra("result", false);
            intent.getStringExtra("resourceId");
            if (booleanExtra) {
                if (SingleStudy.this.singleStudyAdapter != null) {
                    SingleStudy.this.singleStudyAdapter.notifyDataSetChanged();
                }
                if (SingleStudy.this.examPrepLayer3Adapter != null) {
                    SingleStudy.this.examPrepLayer3Adapter.notifyDataSetChanged();
                }
            }
        }
    };
    private BroadcastReceiver musicServiceReceiver = new BroadcastReceiver() { // from class: com.appnew.android.Courses.Fragment.SingleStudy.4
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean booleanExtra = intent.getBooleanExtra("result", false);
            intent.getStringExtra("resourceId");
            if (booleanExtra) {
                if (SingleStudy.this.singleStudyAdapter != null) {
                    SingleStudy.this.singleStudyAdapter.notifyDataSetChanged();
                }
                if (SingleStudy.this.examPrepLayer3Adapter != null) {
                    SingleStudy.this.examPrepLayer3Adapter.notifyDataSetChanged();
                }
            }
        }
    };
    String actication_key = "";
    int currentCountOfBooks = 1;
    long mLastClickTime = 0;
    ArrayList<StatesCitiesData> statesCitiesArrayList = new ArrayList<>();

    public static SingleStudy newInstance(String mainCourseId, boolean isCombo, String parentCourseId2, String course_name, String valid_to2, String comboid, String content_type, String issearchnable, boolean isCourseCombo, String linkType) {
        SingleStudy singleStudy = new SingleStudy();
        Bundle bundle = new Bundle();
        bundle.putString(Const.COURSE_ID_MAIN, mainCourseId);
        bundle.putString(Const.COURSE_PARENT_ID, parentCourseId2);
        bundle.putString(Const.CONTENT_TYPE_1, content_type);
        bundle.putBoolean(Const.IS_COMBO, isCombo);
        bundle.putString("valid_to", valid_to2);
        bundle.putString(AnalyticsConstants.course_name, course_name);
        bundle.putString(Const.COMBO_ID, comboid);
        bundle.putString("issearchnable", issearchnable);
        bundle.putBoolean(Const.IS_COURSE_COMBO, isCourseCombo);
        bundle.putString(Const.LINK_TYPE, linkType);
        singleStudy.setArguments(bundle);
        return singleStudy;
    }

    public static SingleStudy newInstance1(String mainCourseId, boolean isCombo, String parentCourseId2, String course_name, String valid_to2, String comboid, String content_type, String issearchnable, List<TilesItem> masterTiles, int masterTilePos, String content_master, CourseDetail courseDetail) {
        SingleStudy singleStudy = new SingleStudy();
        Bundle bundle = new Bundle();
        bundle.putString(Const.COURSE_ID_MAIN, mainCourseId);
        bundle.putString(Const.COURSE_PARENT_ID, parentCourseId2);
        bundle.putString(Const.CONTENT_TYPE_1, content_type);
        bundle.putBoolean(Const.IS_COMBO, isCombo);
        bundle.putString("valid_to", valid_to2);
        bundle.putString(AnalyticsConstants.course_name, course_name);
        bundle.putString(Const.COMBO_ID, comboid);
        bundle.putString("issearchnable", issearchnable);
        bundle.putString(Const.CONTENT_MASTER, content_master);
        bundle.putSerializable("masterTiles", (Serializable) masterTiles);
        bundle.putSerializable("coursedetail", courseDetail);
        bundle.putInt("masterPosition", masterTilePos);
        singleStudy.setArguments(bundle);
        return singleStudy;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.context = activity;
        _context = activity;
        this.activity = activity;
    }

    public void checkPaymentMode() {
        if (this.utkashRoom.getthemeSettingdao().is_setting_exit()) {
            this.bottomSetting = (BottomSetting) new Gson().fromJson(this.utkashRoom.getthemeSettingdao().data().getBottom(), BottomSetting.class);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.utkashRoom = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        this.studyCourseRV = (RecyclerView) view.findViewById(R.id.studyCourseRV);
        this.studyCourseRVTile = (RecyclerView) view.findViewById(R.id.studyCourseRVTile);
        this.studyCourseRVContent = (RecyclerView) view.findViewById(R.id.studyCourseRVContent);
        this.paginationLoader = (ProgressBar) view.findViewById(R.id.paginationLoader);
        this.nestedScrollView = (NestedScrollView) view.findViewById(R.id.nestedScrollView);
        this.RL_singleStudy = (RelativeLayout) view.findViewById(R.id.RL_singleStudy);
        this.container = (FrameLayout) view.findViewById(R.id.container);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_no_data);
        this.rl_no_data = relativeLayout;
        relativeLayout.setVisibility(8);
        this.mrpCutTV = (TextView) view.findViewById(R.id.mrpCutTV);
        this.price = (TextView) view.findViewById(R.id.priceTV);
        this.buyNowBtn = (Button) view.findViewById(R.id.buyNowBtn);
        this.myLibBtn = (Button) view.findViewById(R.id.myLibBtn);
        this.buttonLow = (RelativeLayout) view.findViewById(R.id.buttonLow);
        this.priceLL = (LinearLayout) view.findViewById(R.id.priceLL);
        this.linear_addToCart = (LinearLayout) view.findViewById(R.id.linear_addToCart);
        this.no_data_found_RL = (RelativeLayout) view.findViewById(R.id.no_data_found_RL);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.view_header);
        this.view_header = relativeLayout2;
        this.no_data_found_RL_Header = (RelativeLayout) relativeLayout2.findViewById(R.id.no_data_found_RL);
        this.tileRv = (RecyclerView) this.view_header.findViewById(R.id.tileRv);
        this.ll_compat = (LinearLayoutCompat) this.view_header.findViewById(R.id.ll_compat);
        this.courseImagebg = (ImageView) this.view_header.findViewById(R.id.courseImagebg);
        this.coursename = (TextView) this.view_header.findViewById(R.id.course_name);
        this.authorname = (TextView) this.view_header.findViewById(R.id.authorname);
        this.validityTV = (TextView) this.view_header.findViewById(R.id.validityTV);
        this.scholarshipCouponTV = (TextView) this.view_header.findViewById(R.id.scholarshipCouponTV);
        this.ll_scholorship_discount = (LinearLayout) this.view_header.findViewById(R.id.ll_scholorship_discount);
        this.backBtn = (Button) view.findViewById(R.id.backBtn);
        this.tvGstDesc = (TextView) view.findViewById(R.id.tv_gstDesc);
        this.dueEmiLayout = (RelativeLayout) view.findViewById(R.id.dueEmiLayout);
        this.txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        this.payEmi = (TextView) view.findViewById(R.id.payEmi);
        this.soldOutImg = (FrameLayout) this.view_header.findViewById(R.id.soldOutImg);
        this.buyNowBtn.setText(SharedPreference.getInstance().getString(Const.ENROLL_NOW).equalsIgnoreCase("1") ? "Enroll Now" : this.activity.getResources().getString(R.string.buy_now));
        this.linearLayoutManager = new LinearLayoutManager(this.activity, 1, false);
        this.linearLayoutManager1 = new LinearLayoutManager(this.activity, 1, false);
        this.studyCourseRV.setLayoutManager(this.linearLayoutManager);
        this.studyCourseRV.setHasFixedSize(true);
        this.studyCourseRVContent.setLayoutManager(this.linearLayoutManager1);
        SharedPreference.getInstance().remove(Const.SINGLE_STUDY);
        this.buyNowBtn.setOnClickListener(this);
        this.linear_addToCart.setOnClickListener(this);
        this.backBtn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Fragment.SingleStudy$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onViewCreated$0();
            }
        }));
        ((CourseActivity) this.activity).shareIV.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Fragment.SingleStudy$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onViewCreated$1();
            }
        }));
        if (BuildConfig.FLAVOR.equalsIgnoreCase("Narayana")) {
            this.authorname.setVisibility(8);
        }
        this.nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.appnew.android.Courses.Fragment.SingleStudy$$ExternalSyntheticLambda11
            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public final void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                this.f$0.lambda$onViewCreated$2(nestedScrollView, i, i2, i3, i4);
            }
        });
        ((CourseActivity) this.activity).rate.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Fragment.SingleStudy$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onViewCreated$3();
            }
        }));
        ((CourseActivity) this.activity).gotoCart.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Fragment.SingleStudy$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onViewCreated$4();
            }
        }));
        if (this.utkashRoom == null) {
            this.utkashRoom = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        }
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(this.activity);
        this.utkashRoom = appDatabase;
        ThemeSettings themeSettingsData = appDatabase.getthemeSettingdao().data();
        if (themeSettingsData != null && themeSettingsData.getLeft_menu() != null) {
            this.leftMenu = (LeftMenu) new Gson().fromJson(themeSettingsData.getLeft_menu(), LeftMenu.class);
        }
        checkPaymentMode();
        BottomSetting bottomSetting = this.bottomSetting;
        if (bottomSetting != null && bottomSetting.getLayout_type() != null && this.bottomSetting.getLayout_type().equals("1")) {
            ((ConstraintLayout.LayoutParams) this.courseImagebg.getLayoutParams()).dimensionRatio = "1:1";
            ((ConstraintLayout.LayoutParams) this.soldOutImg.getLayoutParams()).dimensionRatio = "1:1";
        }
        if (this.utkashRoom.getCourseDetaildata() != null) {
            String str = this.combo_id;
            if (str != null && str.isEmpty()) {
                parentCourseId = this.mainCourseId;
            }
            if (this.isCombo && this.mainCourseId.equalsIgnoreCase(parentCourseId)) {
                NetworkAPICall(API.CourseDetail_JS, "", true, false, false);
                PreferencesUtil.INSTANCE.setStringPreference(requireContext(), Const.COURSE_DETAIL_JS, "0");
                return;
            }
            String str2 = this.content_master;
            if (str2 != null && str2.equalsIgnoreCase("content_master002")) {
                initButton(this.cousedetail.getData().getCourseDetail());
                List<TilesItem> list = this.masterTiles;
                callAdapterData(list, list.get(this.masterTilePos), this.masterTilePos);
                return;
            }
            if (!this.utkashRoom.getCourseDetaildata().isRecordExistsUserId(MakeMyExam.userId, parentCourseId + "_" + this.mainCourseId)) {
                NetworkAPICall(API.CourseDetail_JS, "", true, false, false);
                PreferencesUtil.INSTANCE.setStringPreference(requireContext(), Const.COURSE_DETAIL_JS, "0");
                return;
            }
            if (PreferencesUtil.INSTANCE.getStringPreference(requireContext(), Const.COURSE_DETAIL_JS).equalsIgnoreCase("1")) {
                this.utkashRoom.getCourseDetaildata().deletecoursedetail(parentCourseId, MakeMyExam.userId);
                NetworkAPICall(API.CourseDetail_JS, "", true, false, false);
                PreferencesUtil.INSTANCE.setStringPreference(requireContext(), Const.COURSE_DETAIL_JS, "0");
                return;
            }
            PreferencesUtil.INSTANCE.setStringPreference(requireContext(), Const.COURSE_DETAIL_JS, "0");
            List<CourseDetailTable> list2 = this.utkashRoom.getCourseDetaildata().getcoursedetail(parentCourseId + "_" + this.mainCourseId, MakeMyExam.userId);
            CourseDetailData courseDetailData = new CourseDetailData();
            Log.e("TAG_APP_DEMO", "onViewCreated: " + this.view_header.getVisibility());
            if (list2.size() > 0) {
                courseDetailData.setTitle(list2.get(0).getCourse_title());
                courseDetailData.setCourseSp(list2.get(0).getCourse_sp());
                Author author = new Author();
                author.setTitle(list2.get(0).getAuthor_title());
                courseDetailData.setAuthor(author);
                courseDetailData.setMrp(list2.get(0).getMrp());
                courseDetailData.setTax(list2.get(0).getTax());
                courseDetailData.setValidity(list2.get(0).getValidity());
                courseDetailData.setId(list2.get(0).getCourse_id().split("_")[1]);
                courseDetailData.setCourseSp(list2.get(0).getCourse_sp());
                courseDetailData.setCover_image(list2.get(0).getCover_image());
                courseDetailData.setDescHeaderImage(list2.get(0).getDesc_header_image());
                courseDetailData.setIs_trial(list2.get(0).getIs_trial());
                courseDetailData.setLast_paid_txn_id(list2.get(0).getLast_paid_txn_id());
                courseDetailData.setIsPurchased(list2.get(0).getIs_purchased());
                courseDetailData.setViewType(list2.get(0).getView_type());
                courseDetailData.setIs_combo(list2.get(0).getIs_combo());
                courseDetailData.setAvg_rating(list2.get(0).getAvg_rating());
                courseDetailData.setUser_rated(list2.get(0).getUser_rated());
                courseDetailData.setStocks(list2.get(0).getStocks());
                courseDetailData.setSkip_payment(list2.get(0).getSkip_payment());
                courseDetailData.setCat_type(list2.get(0).getCat_type());
                courseDetailData.setHide_validity(list2.get(0).getHide_validity());
                courseDetailData.setDelivery_charge(list2.get(0).getDelivery_charge());
                courseDetailData.setIs_activated(list2.get(0).getIs_activated());
                courseDetailData.setToken_activation(list2.get(0).getToken_activation());
                courseDetailData.setTxn_id(list2.get(0).getTxn_id());
                courseDetailData.setInstallment(list2.get(0).getInstallment());
                courseDetailData.setIs_gst(list2.get(0).getIs_gst());
                courseDetailData.setDisplay_locked(list2.get(0).getDisplay_locked());
                courseDetailData.setCombo_has_book(list2.get(0).getCombo_has_book());
                courseDetailData.setExternal_coupon_off(list2.get(0).getExternal_coupon_off());
                if (list2.get(0).getAvg_rating() != null) {
                    courseDetailData.setAvg_rating(list2.get(0).getAvg_rating());
                    courseDetailData.setUser_rated(list2.get(0).getUser_rated());
                    courseDetailData.setStocks(list2.get(0).getStocks());
                }
                courseDetailData.setTax_rate(list2.get(0).getTax_rate());
                if (list2.get(0).getExtra_json() != null && !list2.get(0).getExtra_json().isEmpty()) {
                    courseDetailData.setExtra_json((ExtraJson) new Gson().fromJson(list2.get(0).getExtra_json(), ExtraJson.class));
                }
                this.content_type = list2.get(0).getContent_type();
                this.cousedetail = new CourseDetail();
                Data data = new Data();
                data.setCourseDetail(courseDetailData);
                if (list2.size() > 0 && list2.get(0) != null && list2.get(0).getSubscription_all_data() != null && !list2.get(0).getSubscription_all_data().isEmpty()) {
                    data.setSubscriptionAllData((SubscriptionAllData) new Gson().fromJson(list2.get(0).getSubscription_all_data(), SubscriptionAllData.class));
                }
                ArrayList<TilesItem> arrayList = new ArrayList();
                int i = 0;
                while (i < list2.size()) {
                    list2.get(i).getType().equalsIgnoreCase(Const.COMBO);
                    if (!Const.TIME_TABLE.equals(list2.get(i).getType()) || list2.get(i).getIs_purchased().equalsIgnoreCase("1")) {
                        TilesItem tilesItem = new TilesItem(list2.get(i).getTile_revert(), list2.get(i).getTile_title(), list2.get(i).getTile_id(), list2.get(i).getType(), list2.get(i).getTile_meta(), list2.get(i).getSet_as_demo(), list2.get(i).getThumbnail());
                        if (!list2.get(i).getType().equalsIgnoreCase("content") || list2.get(i).getCat_type() == null || !list2.get(i).getCat_type().equalsIgnoreCase("1")) {
                            arrayList.add(tilesItem);
                        }
                        i++;
                    } else {
                        i++;
                    }
                }
                if (list2.get(0).getCat_type().equalsIgnoreCase("0") && !TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.SAME_CONTENT_VIEW)) && SharedPreference.getInstance().getString(Const.SAME_CONTENT_VIEW).equalsIgnoreCase("1")) {
                    ArrayList arrayList2 = new ArrayList();
                    for (TilesItem tilesItem2 : arrayList) {
                        if (!tilesItem2.getType().equalsIgnoreCase("content")) {
                            arrayList2.add(tilesItem2);
                        }
                    }
                    arrayList.clear();
                    arrayList.addAll(arrayList2);
                }
                if (arrayList.size() == 0) {
                    arrayList.add(new TilesItem("1#0#0#1", Const.NO_DATA, "", Const.NO_DATA, "", "", ""));
                }
                data.setTiles(arrayList);
                this.cousedetail.setData(data);
                if (((CourseActivity) this.activity).is_coupon) {
                    Intent intent = new Intent(this.activity, (Class<?>) PurchaseActivity.class);
                    intent.putExtra(Const.SINGLE_STUDY, this.cousedetail);
                    intent.putExtra(Const.IS_BOOK, this.cousedetail.getData().getCourseDetail().getCat_type());
                    intent.putExtra(Const.DELIVERY_CHARGE, this.cousedetail.getData().getCourseDetail().getDelivery_charge());
                    Helper.gotoActivity(intent, this.activity);
                } else if (courseDetailData.getIsPurchased().equalsIgnoreCase("1") && courseDetailData.getToken_activation().equalsIgnoreCase("1")) {
                    if (courseDetailData.getIsPurchased().equalsIgnoreCase("1") && courseDetailData.getIs_activated().equalsIgnoreCase("0")) {
                        showCustomDialog();
                    } else {
                        initButton(this.cousedetail.getData().getCourseDetail());
                        callForData(this.cousedetail.getData().getTiles(), this.cousedetail.getData().getCourseDetail().getIsPurchased());
                    }
                } else {
                    LeftMenu leftMenu = this.leftMenu;
                    if (leftMenu != null && leftMenu.getKyc_form().equalsIgnoreCase("1")) {
                        if (courseDetailData.getIsPurchased().equalsIgnoreCase("1") && courseDetailData.getIs_activated().equalsIgnoreCase("0")) {
                            showEnrollmentPoppup(this.context);
                        } else {
                            initButton(this.cousedetail.getData().getCourseDetail());
                            callForData(this.cousedetail.getData().getTiles(), this.cousedetail.getData().getCourseDetail().getIsPurchased());
                        }
                    } else {
                        initButton(this.cousedetail.getData().getCourseDetail());
                        List<TilesItem> tiles = this.cousedetail.getData().getTiles();
                        if (tiles == null || (tiles.isEmpty() && !hasValidTiles(this.cousedetail))) {
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(new TilesItem("1#0#0#1", "StaticUI", Constants.LEFT_NAV_KEY.test_scan, "header", "", "", ""));
                            this.cousedetail.getData().setTiles(arrayList3);
                            this.contentNew = "header1001";
                            callForData(this.cousedetail.getData().getTiles(), this.cousedetail.getData().getCourseDetail().getIsPurchased());
                        } else {
                            callForData(this.cousedetail.getData().getTiles(), this.cousedetail.getData().getCourseDetail().getIsPurchased());
                        }
                    }
                }
                CourseDetail courseDetail = this.cousedetail;
                if (courseDetail == null || !isShowAddressUnfill(courseDetail)) {
                    return;
                }
                showUpdateStatePopup(this.cousedetail);
                return;
            }
            this.utkashRoom.getCourseDetaildata().deletecoursedetail(parentCourseId, MakeMyExam.userId);
            NetworkAPICall(API.CourseDetail_JS, "", true, false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onViewCreated$0() {
        this.activity.finish();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onViewCreated$1() {
        Helper.shareCourse(this.activity, this.mainCourseId, String.valueOf(this.isCombo), parentCourseId, this.course_name, this.cousedetail.getData().getCourseDetail().getDescHeaderImage(), this.cousedetail.getData().getCourseDetail().getTitle());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$2(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        ProgressBar progressBar;
        ProgressBar progressBar2;
        String str = this.contentTYpe;
        if (str != null && str.equalsIgnoreCase("content_master002") && (progressBar2 = this.paginationLoader) != null) {
            progressBar2.setVisibility(8);
            return;
        }
        if (nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1) == null || i2 < nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1).getMeasuredHeight() - nestedScrollView.getMeasuredHeight() || i2 <= i4 || (progressBar = this.paginationLoader) == null || progressBar.isShown() || !this.isPaginationAvailable || !this.isSkip.equalsIgnoreCase("3") || (Const.OVERVIEW + this.tileIdAPI).equalsIgnoreCase(this.typeApi)) {
            return;
        }
        this.paginationLoader.setVisibility(0);
        this.mPage++;
        this.status = true;
        NetworkAPICall(API.API_GET_MASTER_DATA, this.typeApi, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onViewCreated$3() {
        Intent intent = new Intent(getActivity(), (Class<?>) RattingActivity.class);
        intent.putExtra("courseId", this.mainCourseId);
        intent.putExtra("is_purchased", this.is_purchased_course);
        startActivity(intent);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onViewCreated$4() {
        Intent intent = new Intent(getActivity(), (Class<?>) CartItemsActivity.class);
        intent.putExtra("courseId", this.mainCourseId);
        startActivity(intent);
        return null;
    }

    public void reloadData() {
        Intent intent = new Intent(this.activity, (Class<?>) CourseActivity.class);
        intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
        intent.putExtra(Const.COURSE_ID_MAIN, this.cousedetail.getData().getCourseDetail().getId());
        intent.putExtra(Const.COURSE_PARENT_ID, parentCourseId);
        intent.putExtra(Const.CONTENT_TYPE_1, this.content_master);
        intent.putExtra(Const.IS_COMBO, false);
        intent.putExtra(Const.COMBO_ID, com.amazonaws.services.s3.internal.Constants.NULL_VERSION_ID);
        intent.putExtra(AnalyticsConstants.course_name, this.cousedetail.getData().getCourseDetail().getTitle());
        Helper.gotoActivity_finish(intent, this.activity);
    }

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        SingleStudy singleStudy;
        String str;
        super.onCreate(savedInstanceState);
        this.activity = getActivity();
        Constants.revison_set = false;
        if (getArguments() != null) {
            this.isCombo = getArguments().getBoolean(Const.IS_COMBO);
            this.isCourseCombo = getArguments().getBoolean(Const.IS_COURSE_COMBO);
            this.linkType = getArguments().getString(Const.LINK_TYPE);
            parentCourseId = getArguments().getString(Const.COURSE_PARENT_ID);
            this.course_name = getArguments().getString(AnalyticsConstants.course_name);
            valid_to = getArguments().getString("valid_to");
            this.combo_id = getArguments().getString(Const.COMBO_ID);
            this.issearchnable = getArguments().getString("issearchnable");
            this.mainCourseId = getArguments().getString(Const.COURSE_ID_MAIN);
            String string = getArguments().getString(Const.CONTENT_TYPE_1);
            this.content_type = string;
            this.contentNew = string;
            this.content_master = getArguments().getString(Const.CONTENT_MASTER);
            if (String.valueOf(getArguments().getInt("masterTilePos")) != null) {
                this.masterTiles = (List) getArguments().getSerializable("masterTiles");
                this.cousedetail = (CourseDetail) getArguments().getSerializable("coursedetail");
                this.masterTilePos = getArguments().getInt("masterPosition");
            }
        }
        if (this.isCourseCombo && (str = this.linkType) != null && str.equalsIgnoreCase("1")) {
            parentCourseId = "";
        }
        if (!Helper.isNetworkConnected(this.activity) || SharedPreference.getInstance().getHashMapdata(Const.API_UPDATE_VIDEO_VIEW) == null) {
            singleStudy = this;
        } else {
            singleStudy = this;
            singleStudy.NetworkAPICall(API.user_video_view_data, "", false, false, false);
        }
        if (SharedPreference.getInstance().getUserCoupon() == null || SharedPreference.getInstance().getUserCoupon().getAvailable() == null) {
            return;
        }
        singleStudy.couponPojo = SharedPreference.getInstance().getUserCoupon();
    }

    public void changeThemeColor(String color) {
        if (!color.contains(":") || color.split(":").length <= 1) {
            return;
        }
        SharedPreference.getInstance().putString("theme_color_hai_bhai", color);
        this.buyNowBtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(color.split(":")[0])));
        this.myLibBtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(color.split(":")[0])));
        this.buyNowBtn.setTextColor(Color.parseColor(color.split(":")[1]));
        this.myLibBtn.setTextColor(Color.parseColor(color.split(":")[1]));
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        String string;
        String str;
        super.onResume();
        if (SharedPreference.getInstance().getString("theme_color_hai_bhai") != null && !TextUtils.isEmpty(SharedPreference.getInstance().getString("theme_color_hai_bhai"))) {
            changeThemeColor(SharedPreference.getInstance().getString("theme_color_hai_bhai"));
        }
        boolean z = SharedPreference.getInstance().getBoolean(Const.TEST_RESUME_STATE);
        boolean z2 = SharedPreference.getInstance().getBoolean(Const.IS_SUBMIT_TEST_S3);
        if (z && !z2) {
            this.mPage = 1;
            this.status = false;
            NetworkAPICall(API.API_GET_MASTER_DATA, this.typeApi, true, false, false);
            SharedPreference.getInstance().putBoolean(Const.TEST_RESUME_STATE, false);
        } else if (z && z2) {
            NetworkAPICall(API.API_GET_MASTER_DATA, this.typeApi, true, false, false);
            SharedPreference.getInstance().putBoolean(Const.IS_SUBMIT_TEST_S3, false);
            SharedPreference.getInstance().putBoolean(Const.TEST_RESUME_STATE, false);
        } else {
            SharedPreference.getInstance().putBoolean(Const.IS_SUBMIT_TEST_S3, false);
            SharedPreference.getInstance().putBoolean(Const.TEST_RESUME_STATE, false);
        }
        if (PreferencesUtil.INSTANCE.getStringPreference(this.activity, Const.SUBJECTIVE_TEST_UPLOADED).equalsIgnoreCase("1")) {
            this.mPage = 1;
            NetworkAPICall(API.API_GET_MASTER_DATA, this.typeApi, true, false, false);
            PreferencesUtil.INSTANCE.removePreference(this.activity, Const.SUBJECTIVE_TEST_UPLOADED);
        }
        CartCountRefresh();
        LocalBroadcastManager.getInstance(requireActivity()).registerReceiver(this.videoDownloadReceiver, new IntentFilter(VideoDownloadService.VIDEO_DOWNLOAD_ACTION));
        LocalBroadcastManager.getInstance(requireActivity()).registerReceiver(this.audioServiceReceiver, new IntentFilter(AudioPlayerService.AUDIO_PLAYER_ACTION));
        LocalBroadcastManager.getInstance(requireActivity()).registerReceiver(this.musicServiceReceiver, new IntentFilter(MusicService.INSTANCE.getMUSIC_PLAYER_ACTION()));
        if (Constants.revison_set) {
            NetworkAPICall(API.API_GET_MASTER_DATA, this.typeApi, true, false, false);
            Constants.revison_set = false;
        }
        CourseDetail courseDetail = this.cousedetail;
        if (courseDetail != null && courseDetail.getData() != null && this.cousedetail.getData().getCourseDetail() != null && this.cousedetail.getData().getCourseDetail().getCat_type() != null && this.cousedetail.getData().getCourseDetail().getCat_type().equalsIgnoreCase("3")) {
            String str2 = this.combo_id;
            if (str2 != null && str2.isEmpty()) {
                parentCourseId = this.mainCourseId;
            } else {
                parentCourseId = "";
            }
        }
        if (!Constants.REMAININGTIME.equalsIgnoreCase("")) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.Courses.Fragment.SingleStudy.1
                @Override // java.lang.Runnable
                public void run() {
                    SingleStudy.this.mPage = 1;
                    SingleStudy singleStudy = SingleStudy.this;
                    singleStudy.NetworkAPICall(API.API_GET_MASTER_DATA, singleStudy.typeApi, true, false, false);
                }
            }, 1000L);
            Constants.REMAININGTIME = "";
        }
        if (Constants.REFRESHPAGENEW.equals("true") && (str = this.typeApi) != null && this.tileIdAPI != null && !str.equalsIgnoreCase(Const.FOLDER + this.tileIdAPI)) {
            Constants.REFRESHPAGENEW = "false";
            this.status = false;
            this.mPage = 1;
            NetworkAPICall(API.API_GET_MASTER_DATA, this.typeApi, true, false, false);
        } else if (SharedPreference.getInstance().getBoolean(Const.MARK_AS_READ)) {
            this.status = false;
            this.mPage = 1;
            NetworkAPICall(API.API_GET_MASTER_DATA, this.typeApi, true, false, false);
            SharedPreference.getInstance().putBoolean(Const.MARK_AS_READ, false);
        }
        if (SharedPreference.getInstance().getString(Const.AUDIO_LISTEN).equalsIgnoreCase("1") && AudioPlayerService.isAudioPlaying) {
            SingleStudyAdapter singleStudyAdapter = this.singleStudyAdapter;
            if (singleStudyAdapter != null) {
                singleStudyAdapter.notifyDataSetChanged();
            }
            ExamPrepLayer3Adapter examPrepLayer3Adapter = this.examPrepLayer3Adapter;
            if (examPrepLayer3Adapter != null) {
                examPrepLayer3Adapter.notifyDataSetChanged();
            }
        }
        if (MusicService.INSTANCE.isAudioPlaying()) {
            SingleStudyAdapter singleStudyAdapter2 = this.singleStudyAdapter;
            if (singleStudyAdapter2 != null) {
                singleStudyAdapter2.notifyDataSetChanged();
            }
            ExamPrepLayer3Adapter examPrepLayer3Adapter2 = this.examPrepLayer3Adapter;
            if (examPrepLayer3Adapter2 != null) {
                examPrepLayer3Adapter2.notifyDataSetChanged();
            }
        }
        if (getView() == null || (string = SharedPreference.getInstance().getString("DEFERRED_RESULT_MSG")) == null || string.isEmpty()) {
            return;
        }
        Snackbar.make(getView(), string, 0).show();
        SharedPreference.getInstance().remove("DEFERRED_RESULT_MSG");
    }

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.videoDownloadReceiver);
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.audioServiceReceiver);
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.musicServiceReceiver);
        Dialog dialog = this.enrollmentDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.videoDownloadReceiver);
        LocalBroadcastManager.getInstance(requireActivity()).unregisterReceiver(this.audioServiceReceiver);
        LocalBroadcastManager.getInstance(requireActivity()).unregisterReceiver(this.musicServiceReceiver);
    }

    private void showCustomDialog() {
        Dialog dialog = new Dialog(this.activity);
        this.tokenDialog = dialog;
        dialog.requestWindowFeature(1);
        this.tokenDialog.setContentView(R.layout.dialog_course_activation);
        this.tokenDialog.setCancelable(false);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(this.tokenDialog.getWindow().getAttributes());
        layoutParams.width = -2;
        layoutParams.height = -2;
        final EditText editText = (EditText) this.tokenDialog.findViewById(R.id.et_post);
        ((Button) this.tokenDialog.findViewById(R.id.btn_cancel)).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.SingleStudy.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SingleStudy.this.tokenDialog.dismiss();
                SingleStudy.this.activity.onBackPressed();
            }
        });
        ((Button) this.tokenDialog.findViewById(R.id.btn_submit)).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.SingleStudy$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showCustomDialog$5(editText, view);
            }
        });
        this.tokenDialog.show();
        this.tokenDialog.getWindow().setAttributes(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showCustomDialog$5(EditText editText, View view) {
        String string = editText.getText().toString();
        this.actication_key = string;
        if (string.isEmpty()) {
            Activity activity = this.activity;
            Toast.makeText(activity, activity.getResources().getString(R.string.please_enter_activation_key), 0).show();
        } else {
            NetworkAPICall(API.API_activate_course, "", true, false, false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_single_study, container, false);
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        switch (apitype) {
            case "https://appapi.videocrypt.in/index.php/data_model/course/user_video_view_data":
                HashMap<String, String> hashMapdata = SharedPreference.getInstance().getHashMapdata(Const.API_UPDATE_VIDEO_VIEW);
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setUser_id(MakeMyExam.getUserId());
                encryptionData.setVideo_id(hashMapdata.get(Const.VIDEO_ID));
                encryptionData.setTile_id(hashMapdata.get("tile_id"));
                encryptionData.setCourse_id(hashMapdata.get("course_id"));
                encryptionData.setType(hashMapdata.get(Const.VIDEO_TYPE));
                encryptionData.setStart_time(hashMapdata.get(Const.StartTime));
                encryptionData.setTotal_time(hashMapdata.get(Const.TOTAL_TIME));
                encryptionData.setPlatform(hashMapdata.get("platform"));
                encryptionData.setRemaining_time(hashMapdata.get(Const.remaining_time));
                encryptionData.setEnd_time(hashMapdata.get(Const.ENDTime));
                encryptionData.setStart_time(hashMapdata.get(Const.StartTime));
                encryptionData.setView_time(hashMapdata.get(Const.VIEW_TIME));
                return service.user_video_view_data(AES.encrypt(new Gson().toJson(encryptionData)));
            case "data_model/course/activate_course":
                EncryptionData encryptionData2 = new EncryptionData();
                encryptionData2.setCourse_id(this.mainCourseId);
                encryptionData2.setActivation_key(this.actication_key);
                return service.API_activate_course(AES.encrypt(new Gson().toJson(encryptionData2)));
            case "https://appapi.videocrypt.in/index.php/data_model/master_hit/get_cities":
                EncryptionData encryptionData3 = new EncryptionData();
                encryptionData3.setState_id(this.SelectedStateid);
                return service.GetCity(AES.encrypt(new Gson().toJson(encryptionData3)));
            case "https://appapi.videocrypt.in/index.php/data_model/course/update_video_view_time":
                HashMap<String, String> hashMapdata2 = SharedPreference.getInstance().getHashMapdata(Const.API_VIDEO_VIEW_TIME);
                EncryptionData encryptionData4 = new EncryptionData();
                encryptionData4.setUser_id(MakeMyExam.getUserId());
                encryptionData4.setVideo_id(hashMapdata2.get(Const.VIDEO_ID));
                encryptionData4.setTile_id(hashMapdata2.get("tile_id"));
                encryptionData4.setType(hashMapdata2.get(Const.VIDEO_TYPE));
                encryptionData4.setStart_time(hashMapdata2.get(Const.StartTime));
                encryptionData4.setCourse_id(hashMapdata2.get("course_id"));
                encryptionData4.setTotal_time(hashMapdata2.get(Const.TOTAL_TIME));
                encryptionData4.setView_time(hashMapdata2.get(Const.VIEW_TIME));
                return service.update_video_view_time(AES.encrypt(new Gson().toJson(encryptionData4)));
            case "https://appapi.videocrypt.in/index.php/data_model/master_hit/get_states":
                return service.GetState(AES.encrypt(new Gson().toJson(new EncryptionData())));
            case "data_model/users/time_table":
                EncryptionData encryptionData5 = new EncryptionData();
                encryptionData5.setCourse_id(this.mainCourseId);
                return service.getTimeTable(AES.encrypt(new Gson().toJson(encryptionData5)));
            case "https://appapi.videocrypt.in/index.php/data_model/course/get_master_data":
                String str = this.revertAPI.split("\\#")[1];
                if (typeApi.equalsIgnoreCase(Const.OVERVIEW + this.tileIdAPI) || typeApi.equalsIgnoreCase(Const.FAQ + this.tileIdAPI) || typeApi.equalsIgnoreCase(Const.COMBO + this.tileIdAPI)) {
                    EncryptionData encryptionData6 = new EncryptionData();
                    encryptionData6.setTile_id(this.tileIdAPI);
                    encryptionData6.setType(this.tileTypeAPI);
                    encryptionData6.setRevert_api(this.cousedetail.getData().getCourseDetail().getCat_type().equalsIgnoreCase("3") ? this.revertAPI + "#1" : this.revertAPI);
                    encryptionData6.setCourse_id(this.mainCourseId);
                    encryptionData6.setParent_id(parentCourseId.equals("") ? this.cousedetail.getData().getCourseDetail().getId() : parentCourseId);
                    return service.getMasterDataOverviewFAQ(AES.encrypt(new Gson().toJson(encryptionData6)));
                }
                if (str.equalsIgnoreCase("1")) {
                    EncryptionData encryptionData7 = new EncryptionData();
                    encryptionData7.setTile_id(this.tileIdAPI);
                    encryptionData7.setType(this.tileTypeAPI);
                    encryptionData7.setRevert_api(this.cousedetail.getData().getCourseDetail().getCat_type().equalsIgnoreCase("3") ? this.revertAPI + "#1" : this.revertAPI);
                    encryptionData7.setCourse_id(this.mainCourseId);
                    encryptionData7.setParent_id(parentCourseId.equals("") ? this.cousedetail.getData().getCourseDetail().getId() : parentCourseId);
                    encryptionData7.setLayer("2");
                    encryptionData7.setSubject_id("0");
                    encryptionData7.setPage("1");
                    return service.getMasterDataVideoTwo(AES.encrypt(new Gson().toJson(encryptionData7)));
                }
                if (str.equalsIgnoreCase("3")) {
                    EncryptionData encryptionData8 = new EncryptionData();
                    encryptionData8.setTile_id(this.tileIdAPI);
                    encryptionData8.setType(this.tileTypeAPI);
                    encryptionData8.setRevert_api(this.cousedetail.getData().getCourseDetail().getCat_type().equalsIgnoreCase("3") ? this.revertAPI + "#1" : this.revertAPI);
                    encryptionData8.setCourse_id(this.mainCourseId);
                    encryptionData8.setParent_id(parentCourseId.equals("") ? this.cousedetail.getData().getCourseDetail().getId() : parentCourseId);
                    encryptionData8.setLayer("3");
                    encryptionData8.setSubject_id("0");
                    encryptionData8.setTopic_id("0");
                    encryptionData8.setPage("" + this.mPage);
                    return service.getMasterDataVideoThree(AES.encrypt(new Gson().toJson(encryptionData8)));
                }
                EncryptionData encryptionData9 = new EncryptionData();
                encryptionData9.setTile_id(this.tileIdAPI);
                encryptionData9.setType(this.tileTypeAPI);
                encryptionData9.setRevert_api(this.cousedetail.getData().getCourseDetail().getCat_type().equalsIgnoreCase("3") ? this.revertAPI + "#1" : this.revertAPI);
                encryptionData9.setCourse_id(this.mainCourseId);
                encryptionData9.setParent_id(parentCourseId.equals("") ? this.cousedetail.getData().getCourseDetail().getId() : parentCourseId);
                encryptionData9.setLayer("1");
                encryptionData9.setPage("1");
                return service.getMasterDataVideo(AES.encrypt(new Gson().toJson(encryptionData9)));
            case "https://appapi.videocrypt.in/index.php/data_model/master_hit/get_countries":
                EncryptionData encryptionData10 = new EncryptionData();
                encryptionData10.setUser_id(MakeMyExam.getUserId());
                return service.GetCountry(AES.encrypt(new Gson().toJson(encryptionData10)));
            case "https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction":
                EncryptionData encryptionData11 = new EncryptionData();
                encryptionData11.setCourse_id(this.cousedetail.getData().getCourseDetail().getId());
                encryptionData11.setCoupon_applied("0");
                encryptionData11.setParent_id(parentCourseId);
                return service.free_transaction(AES.encrypt(new Gson().toJson(encryptionData11)));
            case "https://appapi.videocrypt.in/index.php/data_model/payment/payment_profile":
                EncryptionData encryptedData = getEncryptedData();
                encryptedData.setTxn_id(this.cousedetail.getData().getCourseDetail().getTxn_id());
                return service.completeEnrollment(AES.encrypt(new Gson().toJson(encryptedData)));
            case "https://appapi.videocrypt.in/index.php/data_model/payment/resume_subscription":
                EncryptionData encryptionData12 = new EncryptionData();
                encryptionData12.setTxn_id(this.cousedetail.getData().getCourseDetail().getLast_paid_txn_id());
                return service.resumeSubscription(AES.encrypt(new Gson().toJson(encryptionData12)));
            case "https://appapi.videocrypt.in/index.php/data_model/course_deprecated/get_course_detail":
                EncryptionData encryptionData13 = new EncryptionData();
                encryptionData13.setCourse_id(this.mainCourseId);
                encryptionData13.setParent_id(parentCourseId);
                return service.getCourseData(AES.encrypt(new Gson().toJson(encryptionData13)));
            case "https://appapi.videocrypt.in/index.php/data_model/cart/addToCart":
                EncryptionData encryptionData14 = new EncryptionData();
                encryptionData14.setCourse_id(this.cousedetail.getData().getCourseDetail().getId());
                encryptionData14.setCourse_name(this.course_name);
                encryptionData14.setQuantity("1");
                encryptionData14.setCourse_price(this.cousedetail.getData().getCourseDetail().getMrp());
                return service.addItemInCart(AES.encrypt(new Gson().toJson(encryptionData14)));
            case "https://appapi.videocrypt.in/index.php/data_model/cart/cartcount":
                EncryptionData encryptionData15 = new EncryptionData();
                encryptionData15.setUser_id(SharedPreference.getInstance().getLoggedInUser().getId());
                return service.getCartCount(AES.encrypt(new Gson().toJson(encryptionData15)));
            default:
                return null;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.appnew.android.Utils.Network.MainFragment
    public void SuccessCallBack(final JSONObject jsonobject, String apitype, String typeApi, boolean showprogress) throws JSONException {
        CourseDetail courseDetail;
        CourseDetail courseDetail2;
        CourseDetail courseDetail3;
        String str;
        String str2;
        JSONObject jSONObject;
        String strOptString;
        String str3;
        String str4;
        boolean z;
        int i;
        int i2;
        Iterator<Available> it;
        boolean z2;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        int i3;
        String str19;
        String str20;
        String str21;
        final Gson gson = new Gson();
        apitype.hashCode();
        byte b2 = -1;
        switch (apitype.hashCode()) {
            case -1175877907:
                if (apitype.equals(API.user_video_view_data)) {
                    b2 = 0;
                }
                break;
            case -887421682:
                if (apitype.equals(API.API_activate_course)) {
                    b2 = 1;
                }
                break;
            case -787266248:
                if (apitype.equals(API.API_CITY)) {
                    b2 = 2;
                }
                break;
            case -685656370:
                if (apitype.equals(API.update_video_view_time)) {
                    b2 = 3;
                }
                break;
            case -319596559:
                if (apitype.equals(API.API_STATE)) {
                    b2 = 4;
                }
                break;
            case -236134242:
                if (apitype.equals(API.API_TIME_TABLE)) {
                    b2 = 5;
                }
                break;
            case -171058627:
                if (apitype.equals(API.API_GET_MASTER_DATA)) {
                    b2 = 6;
                }
                break;
            case -15853979:
                if (apitype.equals(API.API_COUNTRY)) {
                    b2 = 7;
                }
                break;
            case 114126311:
                if (apitype.equals("https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction")) {
                    b2 = 8;
                }
                break;
            case 292296852:
                if (apitype.equals(API.API_COMPLETE_ENROLLMENT)) {
                    b2 = 9;
                }
                break;
            case 675272211:
                if (apitype.equals(API.RESUME_SUBSCRIPTION)) {
                    b2 = 10;
                }
                break;
            case 750643905:
                if (apitype.equals(API.CourseDetail_JS)) {
                    b2 = 11;
                }
                break;
            case 1141454656:
                if (apitype.equals(API.COURSE_ADD_TO_CART)) {
                    b2 = 12;
                }
                break;
            case 1334579443:
                if (apitype.equals(API.COURSE_CART_COUNT)) {
                    b2 = 13;
                }
                break;
        }
        String str22 = Const.DELIVERY_CHARGE;
        String str23 = "0";
        String str24 = "1";
        switch (b2) {
            case 0:
                try {
                    if (jsonobject.optString("status").equals("true")) {
                        SharedPreference.getInstance().saveHashMap(Const.API_UPDATE_VIDEO_VIEW, null);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
                break;
            case 1:
                if (jsonobject.optString("status").equals("true")) {
                    this.utkashRoom.getCourseDetaildata().updaterecord(this.mainCourseId, MakeMyExam.userId, "1");
                    initButton(this.cousedetail.getData().getCourseDetail());
                    callForData(this.cousedetail.getData().getTiles(), this.cousedetail.getData().getCourseDetail().getIsPurchased());
                    Toast.makeText(this.activity, jsonobject.optString("message"), 0).show();
                } else {
                    Toast.makeText(this.activity, jsonobject.optString("message"), 0).show();
                    new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.Courses.Fragment.SingleStudy.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (SingleStudy.this.tokenDialog != null) {
                                SingleStudy.this.tokenDialog.dismiss();
                            }
                            SingleStudy.this.activity.onBackPressed();
                        }
                    }, 200L);
                }
                break;
            case 2:
                if (jsonobject.getBoolean("status")) {
                    this.cities = (StatesCities) new Gson().fromJson(jsonobject.toString(), StatesCities.class);
                }
                break;
            case 3:
                try {
                    if (jsonobject.optString("status").equals("true")) {
                        SharedPreference.getInstance().saveHashMap(Const.API_VIDEO_VIEW_TIME, null);
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
                break;
            case 4:
                if (jsonobject.getBoolean("status")) {
                    this.states = (StatesCities) new Gson().fromJson(jsonobject.toString(), StatesCities.class);
                }
                break;
            case 5:
                if (jsonobject.optString("status").equals("true")) {
                    this.no_data_found_RL.setVisibility(8);
                    if (jsonobject.has("data")) {
                        TimeTableModel timeTableModel = (TimeTableModel) new Gson().fromJson(jsonobject.toString(), TimeTableModel.class);
                        if (SharedPreference.getInstance().getString(Const.SAME_CONTENT_VIEW) != null && !TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.SAME_CONTENT_VIEW)) && SharedPreference.getInstance().getString(Const.SAME_CONTENT_VIEW).equalsIgnoreCase("1")) {
                            setTimeTableData(timeTableModel, typeApi);
                        } else if (this.isSkip.equalsIgnoreCase("3")) {
                            ArrayList<Video> arrayList = new ArrayList<>();
                            this.videoArrayList = arrayList;
                            arrayList.clear();
                            Activity activity = this.activity;
                            CourseDetail courseDetail4 = this.cousedetail;
                            ArrayList<Video> arrayList2 = this.videoArrayList;
                            String str25 = this.tileIdAPI;
                            this.examPrepLayer3Adapter = new ExamPrepLayer3Adapter(timeTableModel, activity, courseDetail4, arrayList2, str25, this.tileTypeAPI, this.revertAPI, str25, courseDetail4.getData().getCourseDetail().getIsPurchased());
                            Log.e("TAG_APP", "SuccessCallBack: 1070");
                            this.studyCourseRVContent.setAdapter(this.examPrepLayer3Adapter);
                        } else {
                            setTimeTableData(timeTableModel, typeApi);
                        }
                    }
                } else {
                    ArrayList<Video> arrayList3 = this.videoArrayList;
                    if (arrayList3 != null) {
                        arrayList3.clear();
                    } else {
                        this.videoArrayList = new ArrayList<>();
                    }
                    ExamPrepItem examPrepItem = this.examPrepItem;
                    if (examPrepItem != null && examPrepItem.getList() != null) {
                        this.examPrepItem.getList().clear();
                    } else {
                        this.examPrepItem = new ExamPrepItem();
                    }
                    SingleStudyAdapter singleStudyAdapter = new SingleStudyAdapter(this.activity, this.cousedetail, this.examPrepItem, this.overviewData, this.courseDataArrayList, this.faqData, this, this, parentCourseId, this.isCombo, this.isSkip, this.tilePos, this.tileIdAPI, this.tileTypeAPI, this.revertAPI, typeApi, this.combo_id, this.videoArrayList, this.couponPojo, "");
                    this.singleStudyAdapter = singleStudyAdapter;
                    singleStudyAdapter.contentType = AudioPlayerService.type;
                    this.contentTYpe = AudioPlayerService.type;
                    this.folderContentType = AudioPlayerService.type;
                    Log.e("TAG_APP", "SuccessCallBack: 1097");
                    this.studyCourseRV.setAdapter(this.singleStudyAdapter);
                    this.studyCourseRV.setNestedScrollingEnabled(false);
                }
                break;
            case 6:
                if (this.is_test_data) {
                    this.is_test_data = false;
                    if (jsonobject.optString("status").equals("true")) {
                        SharedPreference.getInstance().putString(Const.SERVER_TIME, jsonobject.optString("time"));
                        JSONObject jSONObjectOptJSONObject = jsonobject.optJSONObject("data");
                        if (jSONObjectOptJSONObject != null) {
                            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.has("list") ? jSONObjectOptJSONObject.optJSONArray("list") : null;
                            JSONArray jSONArray = new JSONArray();
                            if (jSONArrayOptJSONArray != null) {
                                for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i4);
                                    if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.has("file_type") && jSONObjectOptJSONObject2.optString("file_type").equalsIgnoreCase("t")) {
                                        jSONArray.put(jSONObjectOptJSONObject2);
                                    }
                                }
                                if (jSONArray.length() > 0) {
                                    Intent intent = new Intent(this.activity, (Class<?>) PurchaseActivity.class);
                                    intent.putExtra(Const.SINGLE_STUDY, this.cousedetail);
                                    intent.putExtra("test_data", jSONArray.toString());
                                    intent.putExtra(Const.IS_BOOK, this.cousedetail.getData().getCourseDetail().getCat_type());
                                    intent.putExtra(Const.DELIVERY_CHARGE, this.cousedetail.getData().getCourseDetail().getDelivery_charge());
                                    Helper.gotoActivity(intent, this.activity);
                                } else {
                                    Toast.makeText(this.activity, "Scholarship Test is not available", 0).show();
                                }
                            } else {
                                Toast.makeText(this.activity, "Scholarship Test is not available", 0).show();
                            }
                        } else {
                            Toast.makeText(this.activity, "Scholarship Test is not available", 0).show();
                        }
                    } else {
                        Toast.makeText(this.activity, "Scholarship Test is not available", 0).show();
                    }
                } else {
                    String str26 = this.revertAPI.split("\\#")[1];
                    if (str26.equalsIgnoreCase("3")) {
                        this.isSkip = str26;
                    }
                    if (jsonobject.optString("status").equals("true")) {
                        String strOptString2 = jsonobject.optString("time");
                        this.pageLimit = jsonobject.optString(com.clevertap.android.sdk.Constants.KEY_LIMIT);
                        SharedPreference.getInstance().putString(Const.SERVER_TIME, strOptString2);
                        if (!this.isSkip3) {
                            if (typeApi.equalsIgnoreCase(Const.OVERVIEW + this.tileIdAPI)) {
                                com.appnew.android.Model.Overview.Data data = (com.appnew.android.Model.Overview.Data) gson.fromJson(jsonobject.optString("data"), com.appnew.android.Model.Overview.Data.class);
                                OverviewData overviewData = new OverviewData();
                                this.overviewData = overviewData;
                                overviewData.setData(data);
                                this.examPrepItem = new ExamPrepItem();
                                this.courseDataArrayList = new ArrayList<>();
                                ArrayList<FaqData> arrayList4 = new ArrayList<>();
                                this.faqData = arrayList4;
                                InitTestAdapter(this.cousedetail, this.examPrepItem, this.overviewData, this.courseDataArrayList, arrayList4, typeApi, str26);
                            } else if (typeApi.equalsIgnoreCase(Const.FAQ + this.tileIdAPI)) {
                                JSONArray jSONArrayOptJSONArray2 = jsonobject.optJSONArray("data");
                                this.faqData = new ArrayList<>();
                                for (int i5 = 0; i5 < ((JSONArray) Objects.requireNonNull(jSONArrayOptJSONArray2)).length(); i5++) {
                                    this.faqData.add((FaqData) gson.fromJson(jSONArrayOptJSONArray2.opt(i5).toString(), FaqData.class));
                                }
                                this.overviewData = new OverviewData();
                                this.examPrepItem = new ExamPrepItem();
                                ArrayList<Courselist> arrayList5 = new ArrayList<>();
                                this.courseDataArrayList = arrayList5;
                                InitTestAdapter(this.cousedetail, this.examPrepItem, this.overviewData, arrayList5, this.faqData, typeApi, str26);
                            } else if (typeApi.equalsIgnoreCase(Const.COMBO + this.tileIdAPI)) {
                                JSONArray jSONArrayOptJSONArray3 = jsonobject.optJSONArray("data");
                                this.courseDataArrayList = new ArrayList<>();
                                for (int i6 = 0; i6 < ((JSONArray) Objects.requireNonNull(jSONArrayOptJSONArray3)).length(); i6++) {
                                    this.courseDataArrayList.add((Courselist) gson.fromJson(jSONArrayOptJSONArray3.opt(i6).toString(), Courselist.class));
                                }
                                this.faqData = new ArrayList<>();
                                this.examPrepItem = new ExamPrepItem();
                                OverviewData overviewData2 = new OverviewData();
                                this.overviewData = overviewData2;
                                InitTestAdapter(this.cousedetail, this.examPrepItem, overviewData2, this.courseDataArrayList, this.faqData, typeApi, str26);
                            } else {
                                ProgressBar progressBar = this.paginationLoader;
                                if (progressBar != null && progressBar.isShown()) {
                                    this.paginationLoader.setVisibility(8);
                                }
                                this.isPaginationAvailable = true;
                                if (this.status) {
                                    JSONObject jSONObject2 = jsonobject.getJSONObject("data");
                                    ArrayList<Lists> arrayList6 = new ArrayList<>();
                                    for (int i7 = 0; i7 < ((JSONArray) Objects.requireNonNull(jSONObject2.optJSONArray("list"))).length(); i7++) {
                                        arrayList6.add((Lists) gson.fromJson(((JSONArray) Objects.requireNonNull(jSONObject2.optJSONArray("list"))).get(i7).toString(), Lists.class));
                                    }
                                    try {
                                        if (arrayList6.size() > 0) {
                                            ArrayList arrayList7 = new ArrayList();
                                            Iterator<Lists> it2 = arrayList6.iterator();
                                            while (it2.hasNext()) {
                                                arrayList7.add((Video) new Gson().fromJson(new Gson().toJson(it2.next()), Video.class));
                                            }
                                            this.videoArrayList.addAll(arrayList7);
                                        }
                                    } catch (Exception e4) {
                                        e4.printStackTrace();
                                    }
                                    if (str26.equalsIgnoreCase("3")) {
                                        handleDownloadsVideoExamPrep(arrayList6);
                                        this.examPrepItem.getList().addAll(arrayList6);
                                    }
                                    SingleStudyAdapter singleStudyAdapter2 = this.singleStudyAdapter;
                                    if (singleStudyAdapter2 != null) {
                                        singleStudyAdapter2.notifyDataSetChanged();
                                    }
                                } else {
                                    this.examPrepItem = (ExamPrepItem) gson.fromJson(jsonobject.optJSONObject("data").toString(), ExamPrepItem.class);
                                    this.overviewData = new OverviewData();
                                    this.courseDataArrayList = new ArrayList<>();
                                    this.faqData = new ArrayList<>();
                                    if (str26.equalsIgnoreCase("3")) {
                                        handleDownloadsVideoExamPrep(this.examPrepItem.getList());
                                    }
                                    if (Constants.IS_FROM_LIBRARY && (courseDetail3 = this.cousedetail) != null && courseDetail3.getData() != null && this.cousedetail.getData().getCourseDetail() != null && this.cousedetail.getData().getCourseDetail().getIsPurchased().equalsIgnoreCase("1") && this.cousedetail.getData().getCourseDetail().getCat_type().equalsIgnoreCase("3") && this.examPrepItem.getList() != null && this.examPrepItem.getList().size() > 0) {
                                        ArrayList<Lists> arrayList8 = new ArrayList();
                                        arrayList8.addAll(this.examPrepItem.getList());
                                        this.examPrepItem.getList().clear();
                                        ArrayList<Lists> arrayList9 = new ArrayList<>();
                                        for (Lists lists : arrayList8) {
                                            if (lists.getIs_test_purchased() != null && lists.getIs_test_purchased().equalsIgnoreCase("1")) {
                                                arrayList9.add(lists);
                                            }
                                        }
                                        this.examPrepItem.setList(arrayList9);
                                    }
                                    if ("1".equalsIgnoreCase("7")) {
                                        InitTestAdapterTheme8(this.cousedetail, this.examPrepItem, this.overviewData, this.courseDataArrayList, this.faqData, typeApi, str26);
                                    } else {
                                        InitTestAdapter(this.cousedetail, this.examPrepItem, this.overviewData, this.courseDataArrayList, this.faqData, typeApi, str26);
                                    }
                                }
                            }
                        } else {
                            this.isSkip = "3";
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.Courses.Fragment.SingleStudy.7
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((CourseActivity) SingleStudy.this.activity).contentType = "content" + SingleStudy.this.tileIdAPI;
                                    if (SingleStudy.this.paginationLoader != null && SingleStudy.this.paginationLoader.isShown()) {
                                        SingleStudy.this.paginationLoader.setVisibility(8);
                                    }
                                    SingleStudy.this.isPaginationAvailable = true;
                                    SingleStudy.this.studyCourseRVContent.setVisibility(0);
                                    SingleStudy.this.no_data_found_RL.setVisibility(8);
                                    if (SingleStudy.this.status) {
                                        try {
                                            JSONObject jSONObject3 = jsonobject.getJSONObject("data");
                                            ArrayList arrayList10 = new ArrayList();
                                            for (int i8 = 0; i8 < jSONObject3.optJSONArray("list").length(); i8++) {
                                                arrayList10.add((Video) gson.fromJson(jSONObject3.optJSONArray("list").get(i8).toString(), Video.class));
                                            }
                                            if (arrayList10.size() > 0) {
                                                int size = SingleStudy.this.videoArrayList.size();
                                                SingleStudy.this.videoArrayList.addAll(arrayList10);
                                                SingleStudy singleStudy = SingleStudy.this;
                                                singleStudy.actual_videolist = singleStudy.videoArrayList;
                                                SingleStudy singleStudy2 = SingleStudy.this;
                                                singleStudy2.handleDownloadsVideo(singleStudy2.videoArrayList);
                                                if (SingleStudy.this.examPrepLayer3Adapter != null) {
                                                    SingleStudy.this.examPrepLayer3Adapter.notifyItemRangeInserted(SingleStudy.this.videoArrayList.size() - 1, SingleStudy.this.videoArrayList.size() - size);
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        } catch (Exception e5) {
                                            e5.printStackTrace();
                                            return;
                                        }
                                    }
                                    SingleStudy.this.videoArrayList = new ArrayList<>();
                                    if (jsonobject.has("data")) {
                                        JSONObject jSONObjectOptJSONObject3 = jsonobject.optJSONObject("data");
                                        if (jSONObjectOptJSONObject3.has("list")) {
                                            JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject3.optJSONArray("list");
                                            SingleStudy.this.no_data_found_RL.setVisibility(8);
                                            SingleStudy.this.studyCourseRVContent.setVisibility(0);
                                            if (jSONArrayOptJSONArray4.length() > 0) {
                                                for (int i9 = 0; i9 < jSONArrayOptJSONArray4.length(); i9++) {
                                                    SingleStudy.this.videoArrayList.add((Video) new Gson().fromJson(jSONArrayOptJSONArray4.opt(i9).toString(), Video.class));
                                                }
                                                SingleStudy singleStudy3 = SingleStudy.this;
                                                singleStudy3.handleDownloadsVideo(singleStudy3.videoArrayList);
                                                SingleStudy.this.examPrepLayer3Adapter = new ExamPrepLayer3Adapter(SingleStudy.this.activity, SingleStudy.this.cousedetail, SingleStudy.this.videoArrayList, SingleStudy.this.tileIdAPI, SingleStudy.this.tileTypeAPI, SingleStudy.this.revertAPI, SingleStudy.this.tileIdAPI, SingleStudy.this.cousedetail.getData().getCourseDetail().getIsPurchased());
                                                Log.e("TAG_APP", "SuccessCallBack: 2088");
                                                SingleStudy.this.studyCourseRVContent.setAdapter(SingleStudy.this.examPrepLayer3Adapter);
                                                SingleStudy.this.studyCourseRVContent.setNestedScrollingEnabled(false);
                                            }
                                        }
                                    }
                                }
                            }, 500L);
                        }
                    } else {
                        if (str26.equalsIgnoreCase("3") && !this.status && (courseDetail2 = this.cousedetail) != null && courseDetail2.getData() != null && this.cousedetail.getData().getCourseDetail() != null && this.cousedetail.getData().getCourseDetail().getIsPurchased().equalsIgnoreCase("0")) {
                            this.faqData = new ArrayList<>();
                            this.overviewData = new OverviewData();
                            this.examPrepItem = new ExamPrepItem();
                            this.courseDataArrayList = new ArrayList<>();
                            if ("1".equalsIgnoreCase("7")) {
                                InitTestAdapterTheme8(this.cousedetail, this.examPrepItem, this.overviewData, this.courseDataArrayList, this.faqData, typeApi, str26);
                            } else {
                                InitTestAdapter(this.cousedetail, this.examPrepItem, this.overviewData, this.courseDataArrayList, this.faqData, typeApi, str26);
                            }
                        }
                        ProgressBar progressBar2 = this.paginationLoader;
                        if (progressBar2 != null && progressBar2.isShown()) {
                            this.paginationLoader.setVisibility(8);
                        }
                        this.isPaginationAvailable = false;
                        if (!this.status && (courseDetail = this.cousedetail) != null && courseDetail.getData() != null && this.cousedetail.getData().getCourseDetail() != null && this.cousedetail.getData().getCourseDetail().getIsPurchased().equalsIgnoreCase("1")) {
                            this.no_data_found_RL.setVisibility(0);
                            this.studyCourseRVContent.setVisibility(8);
                            Iterator<TilesItem> it3 = this.cousedetail.getData().getTiles().iterator();
                            while (it3.hasNext()) {
                                if (it3.next().getType().equalsIgnoreCase(Const.TIME_TABLE)) {
                                    this.no_data_found_RL.setVisibility(8);
                                    this.studyCourseRVContent.setVisibility(8);
                                    this.faqData = new ArrayList<>();
                                    this.overviewData = new OverviewData();
                                    this.examPrepItem = new ExamPrepItem();
                                    ArrayList<Courselist> arrayList10 = new ArrayList<>();
                                    this.courseDataArrayList = arrayList10;
                                    InitTestAdapter(this.cousedetail, this.examPrepItem, this.overviewData, arrayList10, this.faqData, typeApi, str26);
                                }
                            }
                        }
                        if (!GenericUtils.isEmpty(jsonobject.optString("auth_code"))) {
                            RetrofitResponse.GetApiData(this.activity, jsonobject.optString("auth_code"), jsonobject.optString("message"), false);
                        }
                    }
                }
                break;
            case 7:
                if (jsonobject.getBoolean("status")) {
                    this.countries = (StatesCities) new Gson().fromJson(jsonobject.toString(), StatesCities.class);
                }
                break;
            case 8:
                try {
                    if (jsonobject.optString("status").equals("true")) {
                        this.utkashRoom.getCourseDetaildata().deletecoursedetail(this.cousedetail.getData().getCourseDetail().getId(), MakeMyExam.userId);
                        Toast.makeText(this.activity, "" + jsonobject.optString("message"), 0).show();
                        pushEventForFreeCourse();
                        Intent intent2 = new Intent(this.activity, (Class<?>) CourseActivity.class);
                        intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                        intent2.putExtra(Const.COURSE_ID_MAIN, !parentCourseId.equalsIgnoreCase("") ? parentCourseId : this.cousedetail.getData().getCourseDetail().getId());
                        intent2.putExtra(Const.COURSE_PARENT_ID, "");
                        intent2.putExtra(Const.CONTENT_TYPE_1, this.content_type);
                        intent2.putExtra(Const.IS_COMBO, false);
                        intent2.putExtra(AnalyticsConstants.course_name, this.cousedetail.getData().getCourseDetail().getTitle());
                        Helper.gotoActivity_finish(intent2, this.activity);
                    } else {
                        Toast.makeText(this.activity, "" + jsonobject.optString("message"), 0).show();
                        RetrofitResponse.GetApiData(this.activity, jsonobject.has("auth_code") ? jsonobject.getString("auth_code") : "", jsonobject.getString("message"), false);
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return;
                }
                break;
            case 9:
                if (jsonobject.optString("status").equals("true")) {
                    Activity activity2 = this.context;
                    if (activity2 != null && (activity2 instanceof CourseActivity)) {
                        this.utkashRoom.getCourseDetaildata().updaterecord(this.mainCourseId, MakeMyExam.userId, "1");
                        this.enrollmentDialog.dismiss();
                        initButton(this.cousedetail.getData().getCourseDetail());
                        callForData(this.cousedetail.getData().getTiles(), this.cousedetail.getData().getCourseDetail().getIsPurchased());
                        Helper.showToast(this.context, jsonobject.optString("message"), 0);
                        break;
                    }
                } else {
                    if (!GenericUtils.isEmpty(jsonobject.optString("auth_code"))) {
                        RetrofitResponse.GetApiData(this.activity, jsonobject.optString("auth_code"), jsonobject.optString("message"), false);
                    }
                    break;
                }
                break;
            case 10:
                if (jsonobject.optString("status").equals("true")) {
                    Toast.makeText(this.activity, jsonobject.getString("message"), 0).show();
                    NetworkAPICall(API.CourseDetail_JS, "", true, false, false);
                } else if (!GenericUtils.isEmpty(jsonobject.optString("auth_code"))) {
                    RetrofitResponse.GetApiData(this.activity, jsonobject.optString("auth_code"), jsonobject.optString("message"), false);
                }
                break;
            case 11:
                if (jsonobject.optString("status").equals("true")) {
                    this.studyCourseRV.setVisibility(0);
                    this.no_data_found_RL.setVisibility(8);
                    JSONObject jSONObjectOptJSONObject3 = jsonobject.optJSONObject("data");
                    String str27 = Const.COURSE_DETAIL;
                    if (jSONObjectOptJSONObject3.has(Const.COURSE_DETAIL) && jSONObjectOptJSONObject3.optJSONObject(Const.COURSE_DETAIL).has("content_type")) {
                        this.content_type = jSONObjectOptJSONObject3.optJSONObject(Const.COURSE_DETAIL).optString("content_type");
                    }
                    String strOptString3 = (jSONObjectOptJSONObject3.has(Const.COURSE_DETAIL) && jSONObjectOptJSONObject3.optJSONObject(Const.COURSE_DETAIL).has("is_purchased")) ? jSONObjectOptJSONObject3.optJSONObject(Const.COURSE_DETAIL).optString("is_purchased") : "0";
                    SharedPreference.getInstance().putString(Const.IS_IGST, jSONObjectOptJSONObject3.optString(Const.IS_IGST));
                    String str28 = "id";
                    if (!this.utkashRoom.getuserwisecourse().is_api_code_exits(MakeMyExam.userId, jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("id"))) {
                        UserWiseCourseTable userWiseCourseTable = new UserWiseCourseTable();
                        userWiseCourseTable.setUserid(MakeMyExam.userId);
                        userWiseCourseTable.setCode("ut_011");
                        userWiseCourseTable.setVersion("0.000");
                        userWiseCourseTable.setExp(String.valueOf(MakeMyExam.getTime_server()));
                        userWiseCourseTable.setMeta_id(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("id"));
                        this.utkashRoom.getuserwisecourse().addUser(userWiseCourseTable);
                    }
                    String str29 = "title";
                    String str30 = "external_coupon_off";
                    String str31 = "combo_has_book";
                    String str32 = "stocks";
                    String str33 = strOptString3;
                    String str34 = "user_rated";
                    String str35 = "data";
                    if (this.utkashRoom.getCourseDetaildata().isRecordExistsUserId(MakeMyExam.userId, parentCourseId + "_" + jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("id"))) {
                        str = "tax_rate";
                        str2 = "external_coupon_off";
                    } else {
                        str = "tax_rate";
                        int i8 = 0;
                        while (true) {
                            str2 = str30;
                            if (i8 < jSONObjectOptJSONObject3.getJSONArray("tiles").length()) {
                                if (str24.equalsIgnoreCase("7")) {
                                    str11 = str31;
                                    if (Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject3, i8, "type").equalsIgnoreCase("content")) {
                                        str18 = str22;
                                        str19 = str34;
                                        str10 = str32;
                                        str15 = str23;
                                        str17 = str24;
                                        str14 = str35;
                                        i3 = i8;
                                        i8 = i3 + 1;
                                        str23 = str15;
                                        str22 = str18;
                                        str24 = str17;
                                        str31 = str11;
                                        str30 = str2;
                                        str34 = str19;
                                        str32 = str10;
                                        str35 = str14;
                                    } else {
                                        CourseDetailTable courseDetailTable = new CourseDetailTable();
                                        courseDetailTable.setCourse_title(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("title"));
                                        String str36 = str23;
                                        courseDetailTable.setCourse_id(parentCourseId + "_" + jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("id"));
                                        courseDetailTable.setCover_image(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("cover_image"));
                                        courseDetailTable.setDesc_header_image(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("desc_header_image"));
                                        courseDetailTable.setIs_trial(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("is_trial"));
                                        courseDetailTable.setLast_paid_txn_id(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("last_paid_txn_id"));
                                        courseDetailTable.setMrp(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("mrp"));
                                        courseDetailTable.setCourse_sp(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("course_sp"));
                                        courseDetailTable.setValidity(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("validity"));
                                        courseDetailTable.setIs_purchased(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("is_purchased"));
                                        courseDetailTable.setIs_activated(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("is_activated"));
                                        courseDetailTable.setToken_activation(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("token_activation"));
                                        courseDetailTable.setTax(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("tax"));
                                        courseDetailTable.setView_type(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("view_type"));
                                        courseDetailTable.setIs_combo(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(Const.IS_COMBO));
                                        courseDetailTable.setDisplay_locked(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("display_locked"));
                                        courseDetailTable.setAuthor_title(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getJSONObject("author").getString("title"));
                                        courseDetailTable.setTile_id(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject3, i8, "id"));
                                        courseDetailTable.setTile_meta(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject3, i8, "meta"));
                                        courseDetailTable.setUser_id(MakeMyExam.userId);
                                        courseDetailTable.setContent_type(this.content_type);
                                        courseDetailTable.setTile_revert(jSONObjectOptJSONObject3.getJSONArray("tiles").getJSONObject(i8).getString(Const.REVERT_API));
                                        courseDetailTable.setTile_title(jSONObjectOptJSONObject3.getJSONArray("tiles").getJSONObject(i8).getString("tile_name"));
                                        courseDetailTable.setType(jSONObjectOptJSONObject3.getJSONArray("tiles").getJSONObject(i8).getString("type"));
                                        if (jSONObjectOptJSONObject3.getJSONArray("tiles").getJSONObject(i8).has("set_as_demo")) {
                                            courseDetailTable.setSet_as_demo(jSONObjectOptJSONObject3.getJSONArray("tiles").getJSONObject(i8).getString("set_as_demo"));
                                        }
                                        if (jSONObjectOptJSONObject3.getJSONArray("tiles").getJSONObject(i8).has("thumbnail")) {
                                            courseDetailTable.setThumbnail(jSONObjectOptJSONObject3.getJSONArray("tiles").getJSONObject(i8).getString("thumbnail"));
                                        }
                                        courseDetailTable.setTile_revert(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject3, i8, Const.REVERT_API));
                                        courseDetailTable.setTile_title(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject3, i8, "tile_name"));
                                        courseDetailTable.setType(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject3, i8, "type"));
                                        courseDetailTable.setSet_as_demo(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject3, i8, "set_as_demo"));
                                        courseDetailTable.setInstallment(jSONObjectOptJSONObject3.getJSONObject("instalment").toString());
                                        courseDetailTable.setIs_gst(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("is_gst"));
                                        if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).has("avg_rating") && !TextUtils.isEmpty(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("avg_rating"))) {
                                            courseDetailTable.setAvg_rating(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("avg_rating"));
                                        } else {
                                            courseDetailTable.setAvg_rating("");
                                        }
                                        if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).has(str34) && !TextUtils.isEmpty(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str34))) {
                                            courseDetailTable.setUser_rated(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str34));
                                        } else {
                                            courseDetailTable.setUser_rated("");
                                        }
                                        if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).has(str32) && !TextUtils.isEmpty(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str32))) {
                                            courseDetailTable.setStocks(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str32));
                                        } else {
                                            courseDetailTable.setStocks("");
                                        }
                                        if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("skip_payment") != null) {
                                            courseDetailTable.setSkip_payment(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("skip_payment"));
                                        } else {
                                            courseDetailTable.setSkip_payment(str24);
                                        }
                                        if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("cat_type") != null) {
                                            courseDetailTable.setCat_type(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("cat_type"));
                                        } else {
                                            courseDetailTable.setCat_type("");
                                        }
                                        if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("hide_validity") != null) {
                                            courseDetailTable.setHide_validity(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("hide_validity"));
                                        } else {
                                            courseDetailTable.setHide_validity("");
                                        }
                                        if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str22) != null) {
                                            courseDetailTable.setDelivery_charge(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str22));
                                            str21 = str36;
                                        } else {
                                            str21 = str36;
                                            courseDetailTable.setDelivery_charge(str21);
                                        }
                                        str9 = str22;
                                        if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("book_redirection_link") != null) {
                                            courseDetailTable.setBook_redirection_link(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("book_redirection_link"));
                                        } else {
                                            courseDetailTable.setBook_redirection_link("");
                                        }
                                        courseDetailTable.setTxn_id(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("txn_id"));
                                        if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).has(str11) && !TextUtils.isEmpty(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str11))) {
                                            courseDetailTable.setCombo_has_book(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str11));
                                        } else {
                                            courseDetailTable.setCombo_has_book(str21);
                                        }
                                        str11 = str11;
                                        if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).has(str2) && !TextUtils.isEmpty(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str2))) {
                                            courseDetailTable.setExternal_coupon_off(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str2));
                                        } else {
                                            courseDetailTable.setExternal_coupon_off("");
                                        }
                                        str2 = str2;
                                        String str37 = str;
                                        if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).has(str37) && !TextUtils.isEmpty(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str37))) {
                                            courseDetailTable.setTax_rate(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str37));
                                        } else {
                                            courseDetailTable.setTax_rate(str21);
                                        }
                                        str = str37;
                                        str12 = str35;
                                        str13 = str21;
                                        str10 = str32;
                                        if (jsonobject.optJSONObject(str12).optJSONObject("subscription_all_data") != null) {
                                            courseDetailTable.setSubscription_all_data(new Gson().toJson((SubscriptionAllData) new Gson().fromJson(jsonobject.optJSONObject(str12).optJSONObject("subscription_all_data").toString(), SubscriptionAllData.class)));
                                        }
                                        this.utkashRoom.getCourseDetaildata().addCoursedetail(courseDetailTable);
                                    }
                                } else {
                                    str9 = str22;
                                    str10 = str32;
                                    str11 = str31;
                                    str12 = str35;
                                    str13 = str23;
                                    String str38 = this.content_type;
                                    if (str38 != null && !TextUtils.isEmpty(str38) && this.content_type.equalsIgnoreCase(str24)) {
                                        if (!Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject3, i8, "type").equalsIgnoreCase("content")) {
                                            CourseDetailTable courseDetailTable2 = new CourseDetailTable();
                                            courseDetailTable2.setCourse_title(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("title"));
                                            courseDetailTable2.setCourse_id(parentCourseId + "_" + jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("id"));
                                            courseDetailTable2.setCover_image(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("cover_image"));
                                            courseDetailTable2.setDesc_header_image(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("desc_header_image"));
                                            courseDetailTable2.setIs_trial(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("is_trial"));
                                            courseDetailTable2.setLast_paid_txn_id(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("last_paid_txn_id"));
                                            courseDetailTable2.setMrp(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("mrp"));
                                            courseDetailTable2.setCourse_sp(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("course_sp"));
                                            courseDetailTable2.setValidity(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("validity"));
                                            courseDetailTable2.setIs_purchased(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("is_purchased"));
                                            courseDetailTable2.setIs_activated(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("is_activated"));
                                            courseDetailTable2.setToken_activation(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("token_activation"));
                                            courseDetailTable2.setTax(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("tax"));
                                            courseDetailTable2.setView_type(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("view_type"));
                                            courseDetailTable2.setIs_combo(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(Const.IS_COMBO));
                                            courseDetailTable2.setAuthor_title(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getJSONObject("author").getString("title"));
                                            courseDetailTable2.setTile_id(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject3, i8, "id"));
                                            courseDetailTable2.setTile_meta(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject3, i8, "meta"));
                                            courseDetailTable2.setUser_id(MakeMyExam.userId);
                                            courseDetailTable2.setContent_type(this.content_type);
                                            courseDetailTable2.setTile_revert(jSONObjectOptJSONObject3.getJSONArray("tiles").getJSONObject(i8).getString(Const.REVERT_API));
                                            courseDetailTable2.setTile_title(jSONObjectOptJSONObject3.getJSONArray("tiles").getJSONObject(i8).getString("tile_name"));
                                            courseDetailTable2.setType(jSONObjectOptJSONObject3.getJSONArray("tiles").getJSONObject(i8).getString("type"));
                                            if (jSONObjectOptJSONObject3.getJSONArray("tiles").getJSONObject(i8).has("set_as_demo")) {
                                                courseDetailTable2.setSet_as_demo(jSONObjectOptJSONObject3.getJSONArray("tiles").getJSONObject(i8).getString("set_as_demo"));
                                            }
                                            if (jSONObjectOptJSONObject3.getJSONArray("tiles").getJSONObject(i8).has("thumbnail")) {
                                                courseDetailTable2.setThumbnail(jSONObjectOptJSONObject3.getJSONArray("tiles").getJSONObject(i8).getString("thumbnail"));
                                            }
                                            courseDetailTable2.setTile_revert(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject3, i8, Const.REVERT_API));
                                            courseDetailTable2.setTile_title(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject3, i8, "tile_name"));
                                            courseDetailTable2.setType(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject3, i8, "type"));
                                            courseDetailTable2.setSet_as_demo(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject3, i8, "set_as_demo"));
                                            courseDetailTable2.setInstallment(jSONObjectOptJSONObject3.getJSONObject("instalment").toString());
                                            courseDetailTable2.setIs_gst(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("is_gst"));
                                            if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).has("avg_rating") && !TextUtils.isEmpty(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("avg_rating"))) {
                                                courseDetailTable2.setAvg_rating(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("avg_rating"));
                                            } else {
                                                courseDetailTable2.setAvg_rating("");
                                            }
                                            if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).has(str34) && !TextUtils.isEmpty(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str34))) {
                                                courseDetailTable2.setUser_rated(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str34));
                                            } else {
                                                courseDetailTable2.setUser_rated("");
                                            }
                                            if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).has(str10) && !TextUtils.isEmpty(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str10))) {
                                                courseDetailTable2.setStocks(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str10));
                                            } else {
                                                courseDetailTable2.setStocks("");
                                            }
                                            if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("skip_payment") != null) {
                                                courseDetailTable2.setSkip_payment(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("skip_payment"));
                                            } else {
                                                courseDetailTable2.setSkip_payment(str24);
                                            }
                                            if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("cat_type") != null) {
                                                courseDetailTable2.setCat_type(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("cat_type"));
                                            } else {
                                                courseDetailTable2.setCat_type("");
                                            }
                                            if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("hide_validity") != null) {
                                                courseDetailTable2.setHide_validity(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("hide_validity"));
                                            } else {
                                                courseDetailTable2.setHide_validity("");
                                            }
                                            if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str9) != null) {
                                                courseDetailTable2.setDelivery_charge(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str9));
                                                str15 = str13;
                                            } else {
                                                str15 = str13;
                                                courseDetailTable2.setDelivery_charge(str15);
                                            }
                                            str9 = str9;
                                            str16 = str24;
                                            courseDetailTable2.setTxn_id(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("txn_id"));
                                            if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).has(str11) && !TextUtils.isEmpty(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str11))) {
                                                courseDetailTable2.setCombo_has_book(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str11));
                                            } else {
                                                courseDetailTable2.setCombo_has_book(str15);
                                            }
                                            str11 = str11;
                                            if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).has(str2) && !TextUtils.isEmpty(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str2))) {
                                                courseDetailTable2.setExternal_coupon_off(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str2));
                                            } else {
                                                courseDetailTable2.setExternal_coupon_off("");
                                            }
                                            str2 = str2;
                                            String str39 = str;
                                            if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).has(str39) && !TextUtils.isEmpty(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str39))) {
                                                courseDetailTable2.setTax_rate(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str39));
                                            } else {
                                                courseDetailTable2.setTax_rate(str15);
                                            }
                                            str = str39;
                                            str10 = str10;
                                            if (jsonobject.optJSONObject(str12).optJSONObject("subscription_all_data") != null) {
                                                str14 = str12;
                                                courseDetailTable2.setSubscription_all_data(new Gson().toJson((SubscriptionAllData) new Gson().fromJson(jsonobject.optJSONObject(str12).optJSONObject("subscription_all_data").toString(), SubscriptionAllData.class)));
                                            } else {
                                                str14 = str12;
                                            }
                                            if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).has("extra_json") && jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).optJSONObject("extra_json") != null) {
                                                courseDetailTable2.setExtra_json(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).optJSONObject("extra_json").toString());
                                            } else {
                                                courseDetailTable2.setExtra_json("");
                                            }
                                            this.utkashRoom.getCourseDetaildata().addCoursedetail(courseDetailTable2);
                                        }
                                    } else {
                                        str14 = str12;
                                        str15 = str13;
                                        str16 = str24;
                                        String str40 = str33;
                                        if (str40.equalsIgnoreCase(str15)) {
                                            if (Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject3, i8, "type").equalsIgnoreCase("content")) {
                                                str33 = str40;
                                            } else {
                                                CourseDetailTable courseDetailTable3 = new CourseDetailTable();
                                                courseDetailTable3.setCourse_title(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("title"));
                                                courseDetailTable3.setCourse_id(parentCourseId + "_" + jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("id"));
                                                courseDetailTable3.setCover_image(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("cover_image"));
                                                courseDetailTable3.setDesc_header_image(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("desc_header_image"));
                                                courseDetailTable3.setIs_trial(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("is_trial"));
                                                courseDetailTable3.setLast_paid_txn_id(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("last_paid_txn_id"));
                                                courseDetailTable3.setMrp(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("mrp"));
                                                courseDetailTable3.setCourse_sp(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("course_sp"));
                                                courseDetailTable3.setValidity(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("validity"));
                                                courseDetailTable3.setIs_purchased(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("is_purchased"));
                                                courseDetailTable3.setIs_activated(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("is_activated"));
                                                courseDetailTable3.setToken_activation(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("token_activation"));
                                                courseDetailTable3.setTax(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("tax"));
                                                courseDetailTable3.setView_type(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("view_type"));
                                                courseDetailTable3.setIs_combo(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(Const.IS_COMBO));
                                                courseDetailTable3.setAuthor_title(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getJSONObject("author").getString("title"));
                                                courseDetailTable3.setTile_id(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject3, i8, "id"));
                                                courseDetailTable3.setTile_meta(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject3, i8, "meta"));
                                                courseDetailTable3.setUser_id(MakeMyExam.userId);
                                                courseDetailTable3.setContent_type(this.content_type);
                                                courseDetailTable3.setTile_revert(jSONObjectOptJSONObject3.getJSONArray("tiles").getJSONObject(i8).getString(Const.REVERT_API));
                                                courseDetailTable3.setTile_title(jSONObjectOptJSONObject3.getJSONArray("tiles").getJSONObject(i8).getString("tile_name"));
                                                courseDetailTable3.setType(jSONObjectOptJSONObject3.getJSONArray("tiles").getJSONObject(i8).getString("type"));
                                                if (jSONObjectOptJSONObject3.getJSONArray("tiles").getJSONObject(i8).has("set_as_demo")) {
                                                    courseDetailTable3.setSet_as_demo(jSONObjectOptJSONObject3.getJSONArray("tiles").getJSONObject(i8).getString("set_as_demo"));
                                                }
                                                if (jSONObjectOptJSONObject3.getJSONArray("tiles").getJSONObject(i8).has("thumbnail")) {
                                                    courseDetailTable3.setThumbnail(jSONObjectOptJSONObject3.getJSONArray("tiles").getJSONObject(i8).getString("thumbnail"));
                                                }
                                                courseDetailTable3.setTile_revert(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject3, i8, Const.REVERT_API));
                                                courseDetailTable3.setTile_title(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject3, i8, "tile_name"));
                                                courseDetailTable3.setType(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject3, i8, "type"));
                                                courseDetailTable3.setSet_as_demo(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject3, i8, "set_as_demo"));
                                                courseDetailTable3.setInstallment(jSONObjectOptJSONObject3.getJSONObject("instalment").toString());
                                                courseDetailTable3.setIs_gst(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("is_gst"));
                                                if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).has("avg_rating") && !TextUtils.isEmpty(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("avg_rating"))) {
                                                    courseDetailTable3.setAvg_rating(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("avg_rating"));
                                                } else {
                                                    courseDetailTable3.setAvg_rating("");
                                                }
                                                if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).has(str34) && !TextUtils.isEmpty(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str34))) {
                                                    courseDetailTable3.setUser_rated(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str34));
                                                } else {
                                                    courseDetailTable3.setUser_rated("");
                                                }
                                                if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).has(str10) && !TextUtils.isEmpty(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str10))) {
                                                    courseDetailTable3.setStocks(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str10));
                                                } else {
                                                    courseDetailTable3.setStocks("");
                                                }
                                                str33 = str40;
                                                if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("skip_payment") != null) {
                                                    courseDetailTable3.setSkip_payment(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("skip_payment"));
                                                    str20 = str16;
                                                } else {
                                                    str20 = str16;
                                                    courseDetailTable3.setSkip_payment(str20);
                                                }
                                                String str41 = str20;
                                                if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("cat_type") != null) {
                                                    courseDetailTable3.setCat_type(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("cat_type"));
                                                } else {
                                                    courseDetailTable3.setCat_type("");
                                                }
                                                if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("hide_validity") != null) {
                                                    courseDetailTable3.setHide_validity(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("hide_validity"));
                                                } else {
                                                    courseDetailTable3.setHide_validity("");
                                                }
                                                if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str9) != null) {
                                                    courseDetailTable3.setDelivery_charge(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str9));
                                                } else {
                                                    courseDetailTable3.setDelivery_charge(str15);
                                                }
                                                courseDetailTable3.setTxn_id(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("txn_id"));
                                                if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).has(str11) && !TextUtils.isEmpty(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str11))) {
                                                    courseDetailTable3.setCombo_has_book(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str11));
                                                } else {
                                                    courseDetailTable3.setCombo_has_book(str15);
                                                }
                                                str11 = str11;
                                                if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).has(str2) && !TextUtils.isEmpty(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str2))) {
                                                    courseDetailTable3.setExternal_coupon_off(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str2));
                                                } else {
                                                    courseDetailTable3.setExternal_coupon_off("");
                                                }
                                                str2 = str2;
                                                String str42 = str;
                                                if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).has(str42) && !TextUtils.isEmpty(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str42))) {
                                                    courseDetailTable3.setTax_rate(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str42));
                                                } else {
                                                    courseDetailTable3.setTax_rate(str15);
                                                }
                                                str = str42;
                                                if (jsonobject.optJSONObject(str14).optJSONObject("subscription_all_data") != null) {
                                                    Gson gson2 = new Gson();
                                                    JSONObject jSONObjectOptJSONObject4 = jsonobject.optJSONObject(str14);
                                                    str14 = str14;
                                                    courseDetailTable3.setSubscription_all_data(new Gson().toJson((SubscriptionAllData) gson2.fromJson(jSONObjectOptJSONObject4.optJSONObject("subscription_all_data").toString(), SubscriptionAllData.class)));
                                                } else {
                                                    str14 = str14;
                                                }
                                                if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).has("extra_json") && jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).optJSONObject("extra_json") != null) {
                                                    courseDetailTable3.setExtra_json(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).optJSONObject("extra_json").toString());
                                                } else {
                                                    courseDetailTable3.setExtra_json("");
                                                }
                                                this.utkashRoom.getCourseDetaildata().addCoursedetail(courseDetailTable3);
                                                str17 = str41;
                                                str18 = str9;
                                                str15 = str15;
                                                str19 = str34;
                                                i3 = i8;
                                                str10 = str10;
                                            }
                                        } else {
                                            str33 = str40;
                                            CourseDetailTable courseDetailTable4 = new CourseDetailTable();
                                            courseDetailTable4.setCourse_title(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("title"));
                                            courseDetailTable4.setCourse_id(parentCourseId + "_" + jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("id"));
                                            courseDetailTable4.setCover_image(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("cover_image"));
                                            courseDetailTable4.setDesc_header_image(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("desc_header_image"));
                                            courseDetailTable4.setIs_trial(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("is_trial"));
                                            courseDetailTable4.setLast_paid_txn_id(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("last_paid_txn_id"));
                                            courseDetailTable4.setMrp(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("mrp"));
                                            courseDetailTable4.setCourse_sp(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("course_sp"));
                                            courseDetailTable4.setValidity(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("validity"));
                                            courseDetailTable4.setIs_purchased(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("is_purchased"));
                                            courseDetailTable4.setIs_activated(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("is_activated"));
                                            courseDetailTable4.setToken_activation(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("token_activation"));
                                            courseDetailTable4.setTax(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("tax"));
                                            courseDetailTable4.setView_type(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("view_type"));
                                            courseDetailTable4.setIs_combo(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(Const.IS_COMBO));
                                            courseDetailTable4.setAuthor_title(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getJSONObject("author").getString("title"));
                                            courseDetailTable4.setTile_id(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject3, i8, "id"));
                                            courseDetailTable4.setTile_meta(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject3, i8, "meta"));
                                            courseDetailTable4.setUser_id(MakeMyExam.userId);
                                            courseDetailTable4.setContent_type(this.content_type);
                                            courseDetailTable4.setTile_revert(jSONObjectOptJSONObject3.getJSONArray("tiles").getJSONObject(i8).getString(Const.REVERT_API));
                                            courseDetailTable4.setTile_title(jSONObjectOptJSONObject3.getJSONArray("tiles").getJSONObject(i8).getString("tile_name"));
                                            courseDetailTable4.setType(jSONObjectOptJSONObject3.getJSONArray("tiles").getJSONObject(i8).getString("type"));
                                            if (jSONObjectOptJSONObject3.getJSONArray("tiles").getJSONObject(i8).has("set_as_demo")) {
                                                courseDetailTable4.setSet_as_demo(jSONObjectOptJSONObject3.getJSONArray("tiles").getJSONObject(i8).getString("set_as_demo"));
                                            }
                                            if (jSONObjectOptJSONObject3.getJSONArray("tiles").getJSONObject(i8).has("thumbnail")) {
                                                courseDetailTable4.setThumbnail(jSONObjectOptJSONObject3.getJSONArray("tiles").getJSONObject(i8).getString("thumbnail"));
                                            }
                                            courseDetailTable4.setTile_revert(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject3, i8, Const.REVERT_API));
                                            courseDetailTable4.setTile_title(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject3, i8, "tile_name"));
                                            courseDetailTable4.setType(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject3, i8, "type"));
                                            courseDetailTable4.setSet_as_demo(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject3, i8, "set_as_demo"));
                                            courseDetailTable4.setInstallment(jSONObjectOptJSONObject3.getJSONObject("instalment").toString());
                                            courseDetailTable4.setIs_gst(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("is_gst"));
                                            if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).has("avg_rating") && !TextUtils.isEmpty(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("avg_rating"))) {
                                                courseDetailTable4.setAvg_rating(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("avg_rating"));
                                            } else {
                                                courseDetailTable4.setAvg_rating("");
                                            }
                                            if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).has(str34) && !TextUtils.isEmpty(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str34))) {
                                                courseDetailTable4.setUser_rated(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str34));
                                            } else {
                                                courseDetailTable4.setUser_rated("");
                                            }
                                            if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).has(str10) && !TextUtils.isEmpty(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str10))) {
                                                courseDetailTable4.setStocks(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str10));
                                            } else {
                                                courseDetailTable4.setStocks("");
                                            }
                                            if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("skip_payment") != null) {
                                                courseDetailTable4.setSkip_payment(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("skip_payment"));
                                                str17 = str16;
                                            } else {
                                                str17 = str16;
                                                courseDetailTable4.setSkip_payment(str17);
                                            }
                                            if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("cat_type") != null) {
                                                courseDetailTable4.setCat_type(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("cat_type"));
                                            } else {
                                                courseDetailTable4.setCat_type("");
                                            }
                                            if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("hide_validity") != null) {
                                                courseDetailTable4.setHide_validity(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("hide_validity"));
                                            } else {
                                                courseDetailTable4.setHide_validity("");
                                            }
                                            str18 = str9;
                                            if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str18) != null) {
                                                courseDetailTable4.setDelivery_charge(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str18));
                                                str15 = str15;
                                            } else {
                                                str15 = str15;
                                                courseDetailTable4.setDelivery_charge(str15);
                                            }
                                            i3 = i8;
                                            str10 = str10;
                                            courseDetailTable4.setTxn_id(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString("txn_id"));
                                            if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).has(str11) && !TextUtils.isEmpty(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str11))) {
                                                courseDetailTable4.setCombo_has_book(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str11));
                                            } else {
                                                courseDetailTable4.setCombo_has_book(str15);
                                            }
                                            str11 = str11;
                                            if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).has(str2) && !TextUtils.isEmpty(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str2))) {
                                                courseDetailTable4.setExternal_coupon_off(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str2));
                                            } else {
                                                courseDetailTable4.setExternal_coupon_off("");
                                            }
                                            str2 = str2;
                                            String str43 = str;
                                            if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).has(str43) && !TextUtils.isEmpty(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str43))) {
                                                courseDetailTable4.setTax_rate(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).getString(str43));
                                            } else {
                                                courseDetailTable4.setTax_rate(str15);
                                            }
                                            str = str43;
                                            str19 = str34;
                                            if (jsonobject.optJSONObject(str14).optJSONObject("subscription_all_data") != null) {
                                                Gson gson3 = new Gson();
                                                JSONObject jSONObjectOptJSONObject5 = jsonobject.optJSONObject(str14);
                                                str14 = str14;
                                                courseDetailTable4.setSubscription_all_data(new Gson().toJson((SubscriptionAllData) gson3.fromJson(jSONObjectOptJSONObject5.optJSONObject("subscription_all_data").toString(), SubscriptionAllData.class)));
                                            } else {
                                                str14 = str14;
                                            }
                                            if (jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).has("extra_json") && jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).optJSONObject("extra_json") != null) {
                                                courseDetailTable4.setExtra_json(jSONObjectOptJSONObject3.getJSONObject(Const.COURSE_DETAIL).optJSONObject("extra_json").toString());
                                            } else {
                                                courseDetailTable4.setExtra_json("");
                                            }
                                            this.utkashRoom.getCourseDetaildata().addCoursedetail(courseDetailTable4);
                                        }
                                        i8 = i3 + 1;
                                        str23 = str15;
                                        str22 = str18;
                                        str24 = str17;
                                        str31 = str11;
                                        str30 = str2;
                                        str34 = str19;
                                        str32 = str10;
                                        str35 = str14;
                                    }
                                    str17 = str16;
                                    str18 = str9;
                                    str19 = str34;
                                    i3 = i8;
                                    i8 = i3 + 1;
                                    str23 = str15;
                                    str22 = str18;
                                    str24 = str17;
                                    str31 = str11;
                                    str30 = str2;
                                    str34 = str19;
                                    str32 = str10;
                                    str35 = str14;
                                }
                                str14 = str12;
                                str17 = str24;
                                str15 = str13;
                                str18 = str9;
                                str19 = str34;
                                i3 = i8;
                                i8 = i3 + 1;
                                str23 = str15;
                                str22 = str18;
                                str24 = str17;
                                str31 = str11;
                                str30 = str2;
                                str34 = str19;
                                str32 = str10;
                                str35 = str14;
                            }
                        }
                    }
                    String str44 = str34;
                    String str45 = str32;
                    String str46 = str31;
                    String str47 = str23;
                    String str48 = str24;
                    String str49 = str35;
                    String str50 = str22;
                    List<CourseDetailTable> list = this.utkashRoom.getCourseDetaildata().getcoursedetail(parentCourseId + "_" + this.mainCourseId, MakeMyExam.userId);
                    if (list != null && list.size() > 0) {
                        CourseDetailData courseDetailData = new CourseDetailData();
                        courseDetailData.setTitle(list.get(0).getCourse_title());
                        courseDetailData.setCourseSp(list.get(0).getCourse_sp());
                        Author author = new Author();
                        author.setTitle(list.get(0).getAuthor_title());
                        courseDetailData.setAuthor(author);
                        courseDetailData.setMrp(list.get(0).getMrp());
                        courseDetailData.setTax(list.get(0).getTax());
                        courseDetailData.setValidity(list.get(0).getValidity());
                        courseDetailData.setId(list.get(0).getCourse_id().split("_")[1]);
                        courseDetailData.setCourseSp(list.get(0).getCourse_sp());
                        courseDetailData.setCover_image(list.get(0).getCover_image());
                        courseDetailData.setDescHeaderImage(list.get(0).getDesc_header_image());
                        courseDetailData.setIs_trial(list.get(0).getIs_trial());
                        courseDetailData.setLast_paid_txn_id(list.get(0).getLast_paid_txn_id());
                        courseDetailData.setIsPurchased(list.get(0).getIs_purchased());
                        courseDetailData.setViewType(list.get(0).getView_type());
                        courseDetailData.setIs_combo(list.get(0).getIs_combo());
                        courseDetailData.setAvg_rating(list.get(0).getAvg_rating());
                        courseDetailData.setUser_rated(list.get(0).getUser_rated());
                        courseDetailData.setStocks(list.get(0).getStocks());
                        courseDetailData.setSkip_payment(list.get(0).getSkip_payment());
                        courseDetailData.setCat_type(list.get(0).getCat_type());
                        courseDetailData.setHide_validity(list.get(0).getHide_validity());
                        courseDetailData.setDelivery_charge(list.get(0).getDelivery_charge());
                        courseDetailData.setIs_activated(list.get(0).getIs_activated());
                        courseDetailData.setToken_activation(list.get(0).getToken_activation());
                        courseDetailData.setTxn_id(list.get(0).getTxn_id());
                        courseDetailData.setInstallment(list.get(0).getInstallment());
                        courseDetailData.setIs_gst(list.get(0).getIs_gst());
                        courseDetailData.setDisplay_locked(list.get(0).getDisplay_locked());
                        courseDetailData.setCombo_has_book(list.get(0).getCombo_has_book());
                        courseDetailData.setExternal_coupon_off(list.get(0).getExternal_coupon_off());
                        courseDetailData.setTax_rate(list.get(0).getTax_rate());
                        if (list.get(0).getExtra_json() != null && !list.get(0).getExtra_json().isEmpty()) {
                            courseDetailData.setExtra_json((ExtraJson) new Gson().fromJson(list.get(0).getExtra_json(), ExtraJson.class));
                        }
                        this.cousedetail = new CourseDetail();
                        Data data2 = new Data();
                        data2.setCourseDetail(courseDetailData);
                        if (list.size() > 0 && list.get(0) != null && list.get(0).getSubscription_all_data() != null && !list.get(0).getSubscription_all_data().isEmpty()) {
                            data2.setSubscriptionAllData((SubscriptionAllData) new Gson().fromJson(list.get(0).getSubscription_all_data(), SubscriptionAllData.class));
                        }
                        ArrayList<TilesItem> arrayList11 = new ArrayList();
                        int i9 = 0;
                        while (i9 < list.size()) {
                            list.get(i9).getType().equalsIgnoreCase(Const.COMBO);
                            if (!Const.TIME_TABLE.equals(list.get(i9).getType()) || list.get(i9).getIs_purchased().equalsIgnoreCase(str48)) {
                                TilesItem tilesItem = new TilesItem(list.get(i9).getTile_revert(), list.get(i9).getTile_title(), list.get(i9).getTile_id(), list.get(i9).getType(), list.get(i9).getTile_meta(), list.get(i9).getSet_as_demo(), list.get(i9).getThumbnail());
                                arrayList11.add(tilesItem);
                                i9++;
                            } else {
                                i9++;
                            }
                        }
                        if (!TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.SAME_CONTENT_VIEW)) && SharedPreference.getInstance().getString(Const.SAME_CONTENT_VIEW).equalsIgnoreCase(str48)) {
                            ArrayList arrayList12 = new ArrayList();
                            for (TilesItem tilesItem2 : arrayList11) {
                                if (!tilesItem2.getType().equalsIgnoreCase("content")) {
                                    arrayList12.add(tilesItem2);
                                }
                            }
                            arrayList11.clear();
                            arrayList11.addAll(arrayList12);
                        }
                        data2.setTiles(arrayList11);
                        this.cousedetail.setData(data2);
                        if (((CourseActivity) this.activity).is_coupon) {
                            Intent intent3 = new Intent(this.activity, (Class<?>) PurchaseActivity.class);
                            intent3.putExtra(Const.SINGLE_STUDY, this.cousedetail);
                            intent3.putExtra(Const.IS_BOOK, this.cousedetail.getData().getCourseDetail().getCat_type());
                            intent3.putExtra(str50, this.cousedetail.getData().getCourseDetail().getDelivery_charge());
                            Helper.gotoActivity(intent3, this.activity);
                        } else if (courseDetailData.getIsPurchased().equalsIgnoreCase(str48) && courseDetailData.getToken_activation().equalsIgnoreCase(str48)) {
                            if (courseDetailData.getIsPurchased().equalsIgnoreCase(str48) && courseDetailData.getIs_activated().equalsIgnoreCase(str47)) {
                                showCustomDialog();
                            } else {
                                initButton(this.cousedetail.getData().getCourseDetail());
                                callForData(this.cousedetail.getData().getTiles(), this.cousedetail.getData().getCourseDetail().getIsPurchased());
                            }
                        } else {
                            LeftMenu leftMenu = this.leftMenu;
                            if (leftMenu != null && leftMenu.getKyc_form().equalsIgnoreCase(str48) && courseDetailData.getIsPurchased().equalsIgnoreCase(str48) && courseDetailData.getIs_activated().equalsIgnoreCase(str47)) {
                                showEnrollmentPoppup(this.context);
                            } else {
                                initButton(this.cousedetail.getData().getCourseDetail());
                                callForData(this.cousedetail.getData().getTiles(), this.cousedetail.getData().getCourseDetail().getIsPurchased());
                            }
                        }
                        CourseDetail courseDetail5 = this.cousedetail;
                        if (courseDetail5 != null && isShowAddressUnfill(courseDetail5)) {
                            showUpdateStatePopup(this.cousedetail);
                            break;
                        }
                    } else {
                        Log.e("SOLD_OUT_CHECK", "ENTERED ELSE BLOCK");
                        JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject3.has(Const.COURSE_DETAIL) ? jSONObjectOptJSONObject3.optJSONObject(Const.COURSE_DETAIL) : null;
                        String strOptString4 = (jSONObjectOptJSONObject6 == null || !jSONObjectOptJSONObject6.has("hide_validity")) ? "" : jSONObjectOptJSONObject6.optString("hide_validity");
                        String strOptString5 = (jSONObjectOptJSONObject6 == null || !jSONObjectOptJSONObject6.has("cat_type")) ? null : jSONObjectOptJSONObject6.optString("cat_type");
                        String strOptString6 = (jSONObjectOptJSONObject6 == null || !jSONObjectOptJSONObject6.has("desc_header_image")) ? null : jSONObjectOptJSONObject6.optString("desc_header_image");
                        String strOptString7 = (jSONObjectOptJSONObject6 == null || !jSONObjectOptJSONObject6.has("title")) ? null : jSONObjectOptJSONObject6.optString("title");
                        String str51 = str47;
                        String strOptString8 = (jSONObjectOptJSONObject6 == null || !jSONObjectOptJSONObject6.has("validity")) ? null : jSONObjectOptJSONObject6.optString("validity");
                        String str52 = str50;
                        JSONObject jSONObjectOptJSONObject7 = (jSONObjectOptJSONObject6 == null || !jSONObjectOptJSONObject6.has("desc_header_image")) ? null : jSONObjectOptJSONObject6.optJSONObject("desc_header_image");
                        if (jSONObjectOptJSONObject7 == null || !jSONObjectOptJSONObject7.has("title")) {
                            jSONObject = jSONObjectOptJSONObject6;
                            strOptString = null;
                        } else {
                            strOptString = jSONObjectOptJSONObject7.optString("title");
                            jSONObject = jSONObjectOptJSONObject6;
                        }
                        String str53 = "";
                        this.studyCourseRV.setVisibility(8);
                        this.no_data_found_RL.setVisibility(8);
                        if (strOptString5.equalsIgnoreCase(str48)) {
                            Log.d("HEADER_DEBUG", "view_header GONE from XYZ");
                            this.view_header.setVisibility(8);
                            CourseDetailData courseDetailData2 = (CourseDetailData) new Gson().fromJson(jSONObject.toString(), CourseDetailData.class);
                            CourseDetail courseDetail6 = new CourseDetail();
                            this.cousedetail = courseDetail6;
                            if (courseDetail6.getData() == null) {
                                this.cousedetail.setData(new Data());
                            }
                            this.cousedetail.getData().setCourseDetail(courseDetailData2);
                            new ArrayList();
                            if (!hasValidTiles(this.cousedetail)) {
                                ArrayList arrayList13 = new ArrayList();
                                arrayList13.add(new TilesItem("1#0#0#1", "StaticUI", Constants.LEFT_NAV_KEY.test_scan, "header", "", "", ""));
                                this.cousedetail.getData().setTiles(arrayList13);
                                this.contentNew = "header1001";
                                callForData(this.cousedetail.getData().getTiles(), this.cousedetail.getData().getCourseDetail().getIsPurchased());
                            }
                            str3 = "avg_rating";
                            str4 = "id";
                        } else if (strOptString6 != null) {
                            Log.d("HEADER_DEBUG", "view_header VISIBLE from XYZ");
                            this.view_header.setVisibility(0);
                            BottomSetting bottomSetting = this.bottomSetting;
                            if (bottomSetting != null && bottomSetting.getLayout_type() != null && this.bottomSetting.getLayout_type().equals(str48)) {
                                Activity activity3 = this.activity;
                                str3 = "avg_rating";
                                Helper.setThumbnailImage(activity3, strOptString6, activity3.getResources().getDrawable(R.mipmap.square_placeholder), this.courseImagebg);
                            } else {
                                str3 = "avg_rating";
                                Activity activity4 = this.activity;
                                Helper.setThumbnailImage(activity4, strOptString6, activity4.getResources().getDrawable(R.mipmap.square_placeholder_new), this.courseImagebg);
                            }
                            CouponPojo couponPojo = this.couponPojo;
                            if (couponPojo == null || couponPojo.getAvailable() == null || this.couponPojo.getAvailable().size() <= 0) {
                                str4 = "id";
                                z = false;
                            } else {
                                Iterator<Available> it4 = this.couponPojo.getAvailable().iterator();
                                boolean z3 = false;
                                while (it4.hasNext()) {
                                    Available next = it4.next();
                                    if (next.getCourses().size() > 0) {
                                        Iterator<CoursesCoupon> it5 = next.getCourses().iterator();
                                        while (it5.hasNext()) {
                                            it = it4;
                                            z2 = z3;
                                            if (!this.mainCourseId.equalsIgnoreCase(it5.next().getId()) || Long.parseLong(next.getEnd()) * 1000 <= Calendar.getInstance().getTimeInMillis()) {
                                                it4 = it;
                                                str28 = str28;
                                                z3 = z2;
                                            } else {
                                                String coupon_value = next.getCoupon_value();
                                                String coupon_type = next.getCoupon_type();
                                                if (!TextUtils.isEmpty(coupon_value) && Integer.parseInt(coupon_value) > 0) {
                                                    z2 = true;
                                                }
                                                if (coupon_type.equalsIgnoreCase(str48)) {
                                                    str5 = str28;
                                                    this.scholarshipCouponTV.setText("You will get " + this.activity.getResources().getString(R.string.rupees) + coupon_value + " scholarship if you will enroll this course.");
                                                } else {
                                                    str5 = str28;
                                                    this.scholarshipCouponTV.setText("You will get " + coupon_value + "% scholarship if you will enroll this course.");
                                                }
                                            }
                                        }
                                        it = it4;
                                        z2 = z3;
                                        str5 = str28;
                                    } else {
                                        it = it4;
                                        z2 = z3;
                                        str5 = str28;
                                    }
                                    z3 = z2;
                                    it4 = it;
                                    str28 = str5;
                                }
                                z = z3;
                                str4 = str28;
                            }
                            if (z) {
                                i = 0;
                                this.ll_scholorship_discount.setVisibility(0);
                                i2 = 8;
                            } else {
                                i = 0;
                                i2 = 8;
                                this.ll_scholorship_discount.setVisibility(8);
                            }
                            this.coursename.setText(strOptString7);
                            this.validityTV.setText(strOptString8);
                            this.no_data_found_RL_Header.setVisibility(i);
                            this.ll_compat.setVisibility(i);
                            this.tileRv.setVisibility(i2);
                            this.validityTV.setText(this.activity.getResources().getString(R.string.validity_) + strOptString8);
                            if (!GenericUtils.isEmpty(strOptString8)) {
                                if (strOptString5 != null && strOptString5.equalsIgnoreCase("3")) {
                                    this.validityTV.setVisibility(4);
                                } else if (strOptString4.equalsIgnoreCase(str48)) {
                                    this.validityTV.setVisibility(8);
                                } else {
                                    this.validityTV.setVisibility(0);
                                }
                            } else {
                                this.validityTV.setVisibility(8);
                            }
                            if (!GenericUtils.isEmpty(strOptString)) {
                                this.authorname.setText(this.activity.getResources().getString(R.string.by) + strOptString);
                            } else {
                                this.authorname.setText(this.activity.getResources().getString(R.string.by) + this.activity.getResources().getString(R.string.app_name));
                            }
                        } else {
                            str3 = "avg_rating";
                            str4 = "id";
                            this.no_data_found_RL.setVisibility(0);
                            this.view_header.setVisibility(8);
                        }
                        if (jSONObjectOptJSONObject3.has(Const.COURSE_DETAIL)) {
                            ArrayList arrayList14 = new ArrayList();
                            int i10 = 0;
                            while (i10 < jSONObjectOptJSONObject3.getJSONArray("tiles").length()) {
                                CourseDetailTable courseDetailTable5 = new CourseDetailTable();
                                courseDetailTable5.setCourse_title(jSONObjectOptJSONObject3.getJSONObject(str27).getString(str29));
                                String str54 = str4;
                                courseDetailTable5.setCourse_id(parentCourseId + "_" + jSONObjectOptJSONObject3.getJSONObject(str27).getString(str54));
                                courseDetailTable5.setCover_image(jSONObjectOptJSONObject3.getJSONObject(str27).getString("cover_image"));
                                courseDetailTable5.setDesc_header_image(jSONObjectOptJSONObject3.getJSONObject(str27).getString("desc_header_image"));
                                courseDetailTable5.setIs_trial(jSONObjectOptJSONObject3.getJSONObject(str27).getString("is_trial"));
                                courseDetailTable5.setLast_paid_txn_id(jSONObjectOptJSONObject3.getJSONObject(str27).getString("last_paid_txn_id"));
                                courseDetailTable5.setMrp(jSONObjectOptJSONObject3.getJSONObject(str27).getString("mrp"));
                                courseDetailTable5.setCourse_sp(jSONObjectOptJSONObject3.getJSONObject(str27).getString("course_sp"));
                                courseDetailTable5.setValidity(jSONObjectOptJSONObject3.getJSONObject(str27).getString("validity"));
                                courseDetailTable5.setIs_purchased(jSONObjectOptJSONObject3.getJSONObject(str27).getString("is_purchased"));
                                courseDetailTable5.setIs_activated(jSONObjectOptJSONObject3.getJSONObject(str27).getString("is_activated"));
                                courseDetailTable5.setToken_activation(jSONObjectOptJSONObject3.getJSONObject(str27).getString("token_activation"));
                                courseDetailTable5.setTax(jSONObjectOptJSONObject3.getJSONObject(str27).getString("tax"));
                                courseDetailTable5.setView_type(jSONObjectOptJSONObject3.getJSONObject(str27).getString("view_type"));
                                courseDetailTable5.setIs_combo(jSONObjectOptJSONObject3.getJSONObject(str27).getString(Const.IS_COMBO));
                                courseDetailTable5.setAuthor_title(jSONObjectOptJSONObject3.getJSONObject(str27).getJSONObject("author").getString(str29));
                                courseDetailTable5.setTile_id(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject3, i10, str54));
                                courseDetailTable5.setTile_meta(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject3, i10, "meta"));
                                courseDetailTable5.setUser_id(MakeMyExam.userId);
                                courseDetailTable5.setContent_type(this.content_type);
                                courseDetailTable5.setTile_revert(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject3, i10, Const.REVERT_API));
                                courseDetailTable5.setTile_title(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject3, i10, "tile_name"));
                                courseDetailTable5.setType(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject3, i10, "type"));
                                courseDetailTable5.setInstallment(jSONObjectOptJSONObject3.getJSONObject("instalment").toString());
                                courseDetailTable5.setIs_gst(jSONObjectOptJSONObject3.getJSONObject(str27).getString("is_gst"));
                                String str55 = str3;
                                if (jSONObjectOptJSONObject3.getJSONObject(str27).has(str55) && !TextUtils.isEmpty(jSONObjectOptJSONObject3.getJSONObject(str27).getString(str55))) {
                                    courseDetailTable5.setAvg_rating(jSONObjectOptJSONObject3.getJSONObject(str27).getString(str55));
                                    str6 = str53;
                                } else {
                                    str6 = str53;
                                    courseDetailTable5.setAvg_rating(str6);
                                }
                                String str56 = str44;
                                if (jSONObjectOptJSONObject3.getJSONObject(str27).has(str56) && !TextUtils.isEmpty(jSONObjectOptJSONObject3.getJSONObject(str27).getString(str56))) {
                                    courseDetailTable5.setUser_rated(jSONObjectOptJSONObject3.getJSONObject(str27).getString(str56));
                                } else {
                                    courseDetailTable5.setUser_rated(str6);
                                }
                                String str57 = str45;
                                if (jSONObjectOptJSONObject3.getJSONObject(str27).has(str57) && !TextUtils.isEmpty(jSONObjectOptJSONObject3.getJSONObject(str27).getString(str57))) {
                                    courseDetailTable5.setStocks(jSONObjectOptJSONObject3.getJSONObject(str27).getString(str57));
                                } else {
                                    courseDetailTable5.setStocks(str6);
                                }
                                int i11 = i10;
                                if (jSONObjectOptJSONObject3.getJSONObject(str27).getString("skip_payment") != null) {
                                    courseDetailTable5.setSkip_payment(jSONObjectOptJSONObject3.getJSONObject(str27).getString("skip_payment"));
                                } else {
                                    courseDetailTable5.setSkip_payment(str48);
                                }
                                if (jSONObjectOptJSONObject3.getJSONObject(str27).getString("cat_type") != null) {
                                    courseDetailTable5.setCat_type(jSONObjectOptJSONObject3.getJSONObject(str27).getString("cat_type"));
                                } else {
                                    courseDetailTable5.setCat_type(str6);
                                }
                                if (jSONObjectOptJSONObject3.getJSONObject(str27).getString("hide_validity") != null) {
                                    courseDetailTable5.setHide_validity(jSONObjectOptJSONObject3.getJSONObject(str27).getString("hide_validity"));
                                } else {
                                    courseDetailTable5.setHide_validity(str6);
                                }
                                String str58 = str52;
                                if (jSONObjectOptJSONObject3.getJSONObject(str27).getString(str58) != null) {
                                    courseDetailTable5.setDelivery_charge(jSONObjectOptJSONObject3.getJSONObject(str27).getString(str58));
                                    str7 = str51;
                                } else {
                                    str7 = str51;
                                    courseDetailTable5.setDelivery_charge(str7);
                                }
                                str3 = str55;
                                String str59 = str29;
                                courseDetailTable5.setTxn_id(jSONObjectOptJSONObject3.getJSONObject(str27).getString("txn_id"));
                                String str60 = str46;
                                if (jSONObjectOptJSONObject3.getJSONObject(str27).has(str60) && !TextUtils.isEmpty(jSONObjectOptJSONObject3.getJSONObject(str27).getString(str60))) {
                                    courseDetailTable5.setCombo_has_book(jSONObjectOptJSONObject3.getJSONObject(str27).getString(str60));
                                } else {
                                    courseDetailTable5.setCombo_has_book(str7);
                                }
                                str46 = str60;
                                String str61 = str2;
                                if (jSONObjectOptJSONObject3.getJSONObject(str27).has(str61) && !TextUtils.isEmpty(jSONObjectOptJSONObject3.getJSONObject(str27).getString(str61))) {
                                    courseDetailTable5.setExternal_coupon_off(jSONObjectOptJSONObject3.getJSONObject(str27).getString(str61));
                                } else {
                                    courseDetailTable5.setExternal_coupon_off(str6);
                                }
                                str2 = str61;
                                String str62 = str;
                                if (jSONObjectOptJSONObject3.getJSONObject(str27).has(str62) && !TextUtils.isEmpty(jSONObjectOptJSONObject3.getJSONObject(str27).getString(str62))) {
                                    courseDetailTable5.setTax_rate(jSONObjectOptJSONObject3.getJSONObject(str27).getString(str62));
                                } else {
                                    courseDetailTable5.setTax_rate(str7);
                                }
                                JSONObject jSONObject3 = jSONObjectOptJSONObject3;
                                str4 = str54;
                                String str63 = str49;
                                String str64 = str27;
                                if (jsonobject.optJSONObject(str63).optJSONObject("subscription_all_data") != null) {
                                    str8 = str62;
                                    courseDetailTable5.setSubscription_all_data(new Gson().toJson((SubscriptionAllData) new Gson().fromJson(jsonobject.optJSONObject(str63).optJSONObject("subscription_all_data").toString(), SubscriptionAllData.class)));
                                } else {
                                    str8 = str62;
                                }
                                arrayList14.add(courseDetailTable5);
                                this.utkashRoom.getCourseDetaildata().addCoursedetail(courseDetailTable5);
                                str53 = str6;
                                str49 = str63;
                                str45 = str57;
                                str29 = str59;
                                str27 = str64;
                                str51 = str7;
                                str52 = str58;
                                i10 = i11 + 1;
                                jSONObjectOptJSONObject3 = jSONObject3;
                                str = str8;
                                str44 = str56;
                            }
                            String str65 = str52;
                            String str66 = str51;
                            if (arrayList14.size() > 0) {
                                CourseDetailData courseDetailData3 = new CourseDetailData();
                                courseDetailData3.setTitle(((CourseDetailTable) arrayList14.get(0)).getCourse_title());
                                courseDetailData3.setCourseSp(((CourseDetailTable) arrayList14.get(0)).getCourse_sp());
                                Author author2 = new Author();
                                author2.setTitle(((CourseDetailTable) arrayList14.get(0)).getAuthor_title());
                                courseDetailData3.setAuthor(author2);
                                courseDetailData3.setMrp(((CourseDetailTable) arrayList14.get(0)).getMrp());
                                courseDetailData3.setTax(((CourseDetailTable) arrayList14.get(0)).getTax());
                                courseDetailData3.setValidity(((CourseDetailTable) arrayList14.get(0)).getValidity());
                                courseDetailData3.setId(((CourseDetailTable) arrayList14.get(0)).getCourse_id().split("_")[1]);
                                courseDetailData3.setCourseSp(((CourseDetailTable) arrayList14.get(0)).getCourse_sp());
                                courseDetailData3.setCover_image(((CourseDetailTable) arrayList14.get(0)).getCover_image());
                                courseDetailData3.setDescHeaderImage(((CourseDetailTable) arrayList14.get(0)).getDesc_header_image());
                                courseDetailData3.setIs_trial(((CourseDetailTable) arrayList14.get(0)).getIs_trial());
                                courseDetailData3.setLast_paid_txn_id(((CourseDetailTable) arrayList14.get(0)).getLast_paid_txn_id());
                                courseDetailData3.setIsPurchased(((CourseDetailTable) arrayList14.get(0)).getIs_purchased());
                                courseDetailData3.setViewType(((CourseDetailTable) arrayList14.get(0)).getView_type());
                                courseDetailData3.setIs_combo(((CourseDetailTable) arrayList14.get(0)).getIs_combo());
                                courseDetailData3.setAvg_rating(((CourseDetailTable) arrayList14.get(0)).getAvg_rating());
                                courseDetailData3.setUser_rated(((CourseDetailTable) arrayList14.get(0)).getUser_rated());
                                courseDetailData3.setStocks(((CourseDetailTable) arrayList14.get(0)).getStocks());
                                courseDetailData3.setSkip_payment(((CourseDetailTable) arrayList14.get(0)).getSkip_payment());
                                courseDetailData3.setCat_type(((CourseDetailTable) arrayList14.get(0)).getCat_type());
                                courseDetailData3.setHide_validity(((CourseDetailTable) arrayList14.get(0)).getHide_validity());
                                courseDetailData3.setDelivery_charge(((CourseDetailTable) arrayList14.get(0)).getDelivery_charge());
                                courseDetailData3.setIs_activated(((CourseDetailTable) arrayList14.get(0)).getIs_activated());
                                courseDetailData3.setToken_activation(((CourseDetailTable) arrayList14.get(0)).getToken_activation());
                                courseDetailData3.setTxn_id(((CourseDetailTable) arrayList14.get(0)).getTxn_id());
                                courseDetailData3.setInstallment(((CourseDetailTable) arrayList14.get(0)).getInstallment());
                                courseDetailData3.setIs_gst(((CourseDetailTable) arrayList14.get(0)).getIs_gst());
                                courseDetailData3.setDisplay_locked(((CourseDetailTable) arrayList14.get(0)).getDisplay_locked());
                                courseDetailData3.setCombo_has_book(((CourseDetailTable) arrayList14.get(0)).getCombo_has_book());
                                courseDetailData3.setExternal_coupon_off(((CourseDetailTable) arrayList14.get(0)).getExternal_coupon_off());
                                courseDetailData3.setTax_rate(((CourseDetailTable) arrayList14.get(0)).getTax_rate());
                                if (((CourseDetailTable) arrayList14.get(0)).getExtra_json() != null && !((CourseDetailTable) arrayList14.get(0)).getExtra_json().isEmpty()) {
                                    courseDetailData3.setExtra_json((ExtraJson) new Gson().fromJson(((CourseDetailTable) arrayList14.get(0)).getExtra_json(), ExtraJson.class));
                                }
                                this.cousedetail = new CourseDetail();
                                Data data3 = new Data();
                                data3.setCourseDetail(courseDetailData3);
                                if (arrayList14.size() > 0 && arrayList14.get(0) != null && ((CourseDetailTable) arrayList14.get(0)).getSubscription_all_data() != null && !((CourseDetailTable) arrayList14.get(0)).getSubscription_all_data().isEmpty()) {
                                    data3.setSubscriptionAllData((SubscriptionAllData) new Gson().fromJson(((CourseDetailTable) arrayList14.get(0)).getSubscription_all_data(), SubscriptionAllData.class));
                                }
                                this.cousedetail.setData(data3);
                                if (((CourseActivity) this.activity).is_coupon) {
                                    Intent intent4 = new Intent(this.activity, (Class<?>) PurchaseActivity.class);
                                    intent4.putExtra(Const.SINGLE_STUDY, this.cousedetail);
                                    intent4.putExtra(Const.IS_BOOK, this.cousedetail.getData().getCourseDetail().getCat_type());
                                    intent4.putExtra(str65, this.cousedetail.getData().getCourseDetail().getDelivery_charge());
                                    Helper.gotoActivity(intent4, this.activity);
                                } else if (courseDetailData3.getIsPurchased().equalsIgnoreCase(str48) && courseDetailData3.getToken_activation().equalsIgnoreCase(str48)) {
                                    if (courseDetailData3.getIsPurchased().equalsIgnoreCase(str48) && courseDetailData3.getIs_activated().equalsIgnoreCase(str66)) {
                                        showCustomDialog();
                                    } else {
                                        initButton(this.cousedetail.getData().getCourseDetail());
                                        callForData(this.cousedetail.getData().getTiles(), this.cousedetail.getData().getCourseDetail().getIsPurchased());
                                    }
                                } else {
                                    LeftMenu leftMenu2 = this.leftMenu;
                                    if (leftMenu2 != null && leftMenu2.getKyc_form().equalsIgnoreCase(str48)) {
                                        if (courseDetailData3.getIsPurchased().equalsIgnoreCase(str48) && courseDetailData3.getIs_activated().equalsIgnoreCase(str66)) {
                                            showEnrollmentPoppup(this.context);
                                        } else {
                                            initButton(this.cousedetail.getData().getCourseDetail());
                                            if (strOptString5.equalsIgnoreCase(str48) && !hasValidTiles(this.cousedetail)) {
                                                List<TilesItem> tiles = this.cousedetail.getData().getTiles();
                                                if (tiles == null || tiles.isEmpty()) {
                                                    ArrayList arrayList15 = new ArrayList();
                                                    arrayList15.add(new TilesItem("1#0#0#1", "StaticUI", Constants.LEFT_NAV_KEY.test_scan, "header", "", "", ""));
                                                    this.cousedetail.getData().setTiles(arrayList15);
                                                    this.contentNew = "header1001";
                                                    callForData(this.cousedetail.getData().getTiles(), this.cousedetail.getData().getCourseDetail().getIsPurchased());
                                                }
                                            } else {
                                                callForData(this.cousedetail.getData().getTiles(), this.cousedetail.getData().getCourseDetail().getIsPurchased());
                                            }
                                        }
                                    } else {
                                        initButton(this.cousedetail.getData().getCourseDetail());
                                        if (strOptString5.equalsIgnoreCase(str48) && !hasValidTiles(this.cousedetail)) {
                                            List<TilesItem> tiles2 = this.cousedetail.getData().getTiles();
                                            if (tiles2 == null || tiles2.isEmpty()) {
                                                ArrayList arrayList16 = new ArrayList();
                                                arrayList16.add(new TilesItem("1#0#0#1", "StaticUI", Constants.LEFT_NAV_KEY.test_scan, "header", "", "", ""));
                                                this.cousedetail.getData().setTiles(arrayList16);
                                                this.contentNew = "header1001";
                                                callForData(this.cousedetail.getData().getTiles(), this.cousedetail.getData().getCourseDetail().getIsPurchased());
                                            }
                                        } else {
                                            callForData(this.cousedetail.getData().getTiles(), this.cousedetail.getData().getCourseDetail().getIsPurchased());
                                        }
                                    }
                                }
                                CourseDetail courseDetail7 = this.cousedetail;
                                if (courseDetail7 != null && isShowAddressUnfill(courseDetail7)) {
                                    showUpdateStatePopup(this.cousedetail);
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    this.studyCourseRV.setVisibility(8);
                    this.no_data_found_RL.setVisibility(0);
                    Log.d("HEADER_DEBUG", "view_header GONE from XYZ");
                    this.view_header.setVisibility(8);
                    this.no_data_found_RL_Header.setVisibility(8);
                    RetrofitResponse.GetApiData(this.activity, jsonobject.optString("auth_code"), jsonobject.optString("message"), false);
                    break;
                }
                break;
            case 12:
                try {
                    if (jsonobject.getString("status").equalsIgnoreCase("true")) {
                        Toast.makeText(this.activity, "" + jsonobject.getString("message"), 0).show();
                        NetworkAPICall(API.COURSE_CART_COUNT, "", true, false, false);
                    } else {
                        Toast.makeText(this.activity, jsonobject.getString("message"), 0).show();
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return;
                }
                break;
            case 13:
                if (jsonobject.optString("status").equals("true")) {
                    if (jsonobject.has("data")) {
                        SharedPreference.getInstance().putInt(Const.CART_COUNT, Integer.parseInt(jsonobject.getJSONObject("data").getString("total_count")));
                        CartCountRefresh();
                    }
                } else if (jsonobject.optString("auth_code") != null) {
                    jsonobject.optString("auth_code").equalsIgnoreCase(Const.EXPIRY_AUTH_CODE);
                }
                break;
        }
    }

    private void setGroupChatData(ArrayList<ChatModel> chatModel, String type) {
        this.studyCourseRV.setLayoutManager(new LinearLayoutManager(this.context));
        Activity activity = this.activity;
        CourseDetail courseDetail = this.cousedetail;
        ExamPrepItem examPrepItem = this.examPrepItem;
        if (examPrepItem == null) {
            examPrepItem = new ExamPrepItem();
        }
        SingleStudyAdapter singleStudyAdapter = new SingleStudyAdapter(chatModel, activity, courseDetail, examPrepItem, this.overviewData, this.courseDataArrayList, this.faqData, this, parentCourseId, this.isCombo, this.isSkip, this.tilePos, this.tileIdAPI, this.tileTypeAPI, this.revertAPI, type, this.combo_id, this.videoArrayList, this.couponPojo);
        this.singleStudyAdapter = singleStudyAdapter;
        singleStudyAdapter.contentType = type;
        this.contentTYpe = type;
        this.folderContentType = type;
        Log.e("TAG_APP", "SuccessCallBack: 2213");
        this.studyCourseRV.setAdapter(this.singleStudyAdapter);
        this.studyCourseRV.setNestedScrollingEnabled(false);
    }

    private void setTimeTableData(TimeTableModel timeTableModel, String type) {
        this.studyCourseRV.setLayoutManager(new LinearLayoutManager(this.context));
        SingleStudyAdapter singleStudyAdapter = new SingleStudyAdapter(timeTableModel, this.activity, this.cousedetail, this.examPrepItem, this.overviewData, this.courseDataArrayList, this.faqData, this, parentCourseId, this.isCombo, this.isSkip, this.tilePos, this.tileIdAPI, this.tileTypeAPI, this.revertAPI, type, this.combo_id, this.videoArrayList, this.couponPojo, this);
        this.singleStudyAdapter = singleStudyAdapter;
        singleStudyAdapter.contentType = type;
        this.contentTYpe = type;
        this.folderContentType = type;
        Log.e("TAG_APP", "SuccessCallBack: 2226");
        this.studyCourseRV.setAdapter(this.singleStudyAdapter);
        this.studyCourseRV.setNestedScrollingEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDownloadsVideo(ArrayList<Video> videoArrayList) {
        for (Video video : videoArrayList) {
            if (video.getFile_type() != null && video.getFile_type().equalsIgnoreCase("3") && video.getVideo_type() != null && ((video.getVideo_type().equalsIgnoreCase("6") || video.getVideo_type().equalsIgnoreCase("7")) && !this.utkashRoom.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread())) {
                if (this.utkashRoom.getvideoDownloadao().isvideo_exit(video.getId(), MakeMyExam.userId)) {
                    VideosDownload videosDownload = this.utkashRoom.getvideoDownloadao().getvideo_byuserid(video.getId(), MakeMyExam.userId);
                    if (videosDownload.getToal_downloadlocale() != null) {
                        if (video.getIs_Download().equalsIgnoreCase("1") && videosDownload.getVideo_status().equalsIgnoreCase("")) {
                            video.setVideo_status("Download");
                        } else {
                            video.setVideo_status(videosDownload.getVideo_status());
                        }
                        video.setVideotime(videosDownload.getVideotime());
                        video.setVideo_download(videosDownload.getIs_complete().equalsIgnoreCase("1"));
                        video.setVideo_currentpos(videosDownload.getVideoCurrentPosition());
                    }
                } else if (video.getIs_Download().equalsIgnoreCase("1")) {
                    video.setVideo_status("Download");
                    video.setVideo_download(false);
                    video.setVideo_currentpos(0L);
                } else {
                    video.setVideo_status("");
                    video.setVideo_download(false);
                    video.setVideo_currentpos(0L);
                }
            }
            if (video.getFile_type() != null && video.getFile_type().equalsIgnoreCase("13") && video.getVideo_type().equalsIgnoreCase("15") && !this.utkashRoom.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread()) {
                if (this.utkashRoom.getvideoDownloadao().isvideo_exit_for_audio(video.getId(), MakeMyExam.userId)) {
                    VideosDownload videosDownload2 = this.utkashRoom.getvideoDownloadao().getvideo_byuserid_for_audio(video.getId(), MakeMyExam.userId);
                    if (videosDownload2.getToal_downloadlocale() != null) {
                        if (video.getIs_download_available().equalsIgnoreCase("1") && videosDownload2.getVideo_status().equalsIgnoreCase("")) {
                            video.setVideo_status("Download");
                        } else {
                            video.setVideo_status(videosDownload2.getVideo_status());
                        }
                        video.setVideotime(videosDownload2.getVideotime());
                        video.setVideo_download(videosDownload2.getIs_complete().equalsIgnoreCase("1"));
                        video.setVideo_currentpos(videosDownload2.getVideoCurrentPosition());
                    }
                } else if (video.getIs_download_available().equalsIgnoreCase("1")) {
                    video.setVideo_status("Download");
                    video.setVideo_download(false);
                    video.setVideo_currentpos(0L);
                } else {
                    video.setVideo_status("");
                    video.setVideo_download(false);
                    video.setVideo_currentpos(0L);
                }
            }
            if (video.getFile_type() != null && video.getFile_type().equalsIgnoreCase("3") && video.getVideo_type().equalsIgnoreCase("1") && SharedPreference.getInstance().getString(Const.YOUTUBE_DOWNLOAD).equalsIgnoreCase("1") && !this.utkashRoom.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread()) {
                if (this.utkashRoom.getvideoDownloadao().isvideo_exit_for_youtube(video.getId(), MakeMyExam.userId)) {
                    VideosDownload videosDownload3 = this.utkashRoom.getvideoDownloadao().getvideo_byuserid_for_youtube(video.getId(), MakeMyExam.userId);
                    if (videosDownload3.getToal_downloadlocale() != null) {
                        if (video.getIs_download_available().equalsIgnoreCase("1") && videosDownload3.getVideo_status().equalsIgnoreCase("")) {
                            video.setVideo_status("Download");
                        } else {
                            video.setVideo_status(videosDownload3.getVideo_status());
                        }
                        video.setVideotime(videosDownload3.getVideotime());
                        video.setVideo_download(videosDownload3.getIs_complete().equalsIgnoreCase("1"));
                        video.setVideo_currentpos(videosDownload3.getVideoCurrentPosition());
                    }
                } else if (video.getIs_download_available().equalsIgnoreCase("1")) {
                    video.setVideo_status("Download");
                    video.setVideo_download(false);
                    video.setVideo_currentpos(0L);
                } else {
                    video.setVideo_status("");
                    video.setVideo_download(false);
                    video.setVideo_currentpos(0L);
                }
            }
        }
    }

    private void handleDownloadsVideoExamPrep(ArrayList<Lists> videos_basic_infos) {
        for (Lists lists : videos_basic_infos) {
            if (lists.getFile_type() != null && lists.getFile_type().equalsIgnoreCase("3") && lists.getVideo_type() != null && ((lists.getVideo_type().equalsIgnoreCase("6") || lists.getVideo_type().equalsIgnoreCase("7") || (lists.getVideo_type().equalsIgnoreCase("9") && lists.getFile_url() != null && !lists.getFile_url().equalsIgnoreCase(""))) && !this.utkashRoom.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread())) {
                if (this.utkashRoom.getvideoDownloadao().isvideo_exit(lists.getId(), MakeMyExam.userId)) {
                    VideosDownload videosDownload = this.utkashRoom.getvideoDownloadao().getvideo_byuserid(lists.getId(), MakeMyExam.userId);
                    if (videosDownload.getToal_downloadlocale() != null) {
                        if (lists.getIs_download_available().equalsIgnoreCase("1") && videosDownload.getVideo_status().equalsIgnoreCase("")) {
                            lists.setVideo_status("Download");
                        } else {
                            lists.setVideo_status(videosDownload.getVideo_status());
                        }
                        lists.setVideo_time(videosDownload.getVideotime());
                        lists.setVideo_download(videosDownload.getIs_complete().equalsIgnoreCase("1"));
                        lists.setVideo_currentpos(videosDownload.getVideoCurrentPosition());
                    }
                } else if (lists.getIs_download_available().equalsIgnoreCase("1")) {
                    lists.setVideo_status("Download");
                    lists.setVideo_download(false);
                    lists.setVideo_currentpos(0L);
                } else {
                    lists.setVideo_status("");
                    lists.setVideo_download(false);
                    lists.setVideo_currentpos(0L);
                }
            }
            if (lists.getFile_type() != null && lists.getFile_type().equalsIgnoreCase("13") && lists.getVideo_type().equalsIgnoreCase("15") && !this.utkashRoom.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread()) {
                if (this.utkashRoom.getvideoDownloadao().isvideo_exit_for_audio(lists.getId(), MakeMyExam.userId)) {
                    VideosDownload videosDownload2 = this.utkashRoom.getvideoDownloadao().getvideo_byuserid_for_audio(lists.getId(), MakeMyExam.userId);
                    if (videosDownload2.getToal_downloadlocale() != null) {
                        if (lists.getIs_download_available().equalsIgnoreCase("1") && videosDownload2.getVideo_status().equalsIgnoreCase("")) {
                            lists.setVideo_status("Download");
                        } else {
                            lists.setVideo_status(videosDownload2.getVideo_status());
                        }
                        lists.setVideo_time(videosDownload2.getVideotime());
                        lists.setVideo_download(videosDownload2.getIs_complete().equalsIgnoreCase("1"));
                        lists.setVideo_currentpos(videosDownload2.getVideoCurrentPosition());
                    }
                } else if (lists.getIs_download_available().equalsIgnoreCase("1")) {
                    lists.setVideo_status("Download");
                    lists.setVideo_download(false);
                    lists.setVideo_currentpos(0L);
                } else {
                    lists.setVideo_status("");
                    lists.setVideo_download(false);
                    lists.setVideo_currentpos(0L);
                }
            }
            if (lists.getFile_type() != null && lists.getFile_type().equalsIgnoreCase("3") && lists.getVideo_type().equalsIgnoreCase("1") && SharedPreference.getInstance().getString(Const.YOUTUBE_DOWNLOAD).equalsIgnoreCase("1") && !this.utkashRoom.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread()) {
                if (this.utkashRoom.getvideoDownloadao().isvideo_exit_for_youtube(lists.getId(), MakeMyExam.userId)) {
                    VideosDownload videosDownload3 = this.utkashRoom.getvideoDownloadao().getvideo_byuserid_for_youtube(lists.getId(), MakeMyExam.userId);
                    if (videosDownload3.getToal_downloadlocale() != null) {
                        if (lists.getIs_download_available().equalsIgnoreCase("1") && videosDownload3.getVideo_status().equalsIgnoreCase("")) {
                            lists.setVideo_status("Download");
                        } else {
                            lists.setVideo_status(videosDownload3.getVideo_status());
                        }
                        lists.setVideo_time(videosDownload3.getVideotime());
                        lists.setVideo_download(videosDownload3.getIs_complete().equalsIgnoreCase("1"));
                        lists.setVideo_currentpos(videosDownload3.getVideoCurrentPosition());
                    }
                } else if (lists.getIs_download_available().equalsIgnoreCase("1")) {
                    lists.setVideo_status("Download");
                    lists.setVideo_download(false);
                    lists.setVideo_currentpos(0L);
                } else {
                    lists.setVideo_status("");
                    lists.setVideo_download(false);
                    lists.setVideo_currentpos(0L);
                }
            }
        }
    }

    public void CartCountRefresh() {
        if (SharedPreference.getInstance().getInt(Const.CART_COUNT) == 0) {
            ShortcutBadger.applyCount(this.context, SharedPreference.getInstance().getInt(Const.CART_COUNT));
            this.context.runOnUiThread(new Runnable() { // from class: com.appnew.android.Courses.Fragment.SingleStudy.8
                @Override // java.lang.Runnable
                public void run() {
                    ((CourseActivity) SingleStudy.this.activity).cart_count.setText(String.valueOf(SharedPreference.getInstance().getInt(Const.CART_COUNT)));
                }
            });
            ((CourseActivity) this.activity).linear_gotoCart.setVisibility(8);
            return;
        }
        this.context.runOnUiThread(new Runnable() { // from class: com.appnew.android.Courses.Fragment.SingleStudy.9
            @Override // java.lang.Runnable
            public void run() {
                ((CourseActivity) SingleStudy.this.activity).linear_gotoCart.setVisibility(0);
                ShortcutBadger.applyCount(SingleStudy.this.context, SharedPreference.getInstance().getInt(Const.CART_COUNT));
                ((CourseActivity) SingleStudy.this.activity).linear_gotoCart.setBackgroundResource(R.drawable.circle_notification_count);
                if (SharedPreference.getInstance().getInt(Const.CART_COUNT) > 99) {
                    ((CourseActivity) SingleStudy.this.activity).cart_count.setText(SingleStudy.this.getResources().getString(R.string.nine_nine));
                } else if (SharedPreference.getInstance().getInt(Const.CART_COUNT) > 0) {
                    ((CourseActivity) SingleStudy.this.activity).cart_count.setText(String.valueOf(SharedPreference.getInstance().getInt(Const.CART_COUNT)));
                } else {
                    ((CourseActivity) SingleStudy.this.activity).linear_gotoCart.setVisibility(8);
                }
            }
        });
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        RecyclerView recyclerView;
        if (!apitype.equalsIgnoreCase(API.CourseDetail_JS) || (recyclerView = this.studyCourseRV) == null || this.no_data_found_RL == null) {
            return;
        }
        recyclerView.setVisibility(8);
        this.no_data_found_RL.setVisibility(0);
    }

    public void callForData(List<TilesItem> tiles, String ispurchased) {
        String str;
        String str2;
        String str3;
        if ("1".equalsIgnoreCase("7")) {
            if (ispurchased.equalsIgnoreCase("0")) {
                if (getTileFortheme8(tiles).size() == 0) {
                    this.no_data_found_RL.setVisibility(0);
                    this.rl_no_data.setVisibility(0);
                    return;
                } else {
                    this.no_data_found_RL.setVisibility(8);
                    this.rl_no_data.setVisibility(8);
                    callAdapterDataTheme8(getTileFortheme8(tiles), null, 0);
                    return;
                }
            }
            if (getTileFortheme8(tiles).size() == 0) {
                this.no_data_found_RL.setVisibility(0);
                return;
            }
            this.no_data_found_RL.setVisibility(8);
            List<TilesItem> tileFortheme8 = getTileFortheme8(tiles);
            if (tileFortheme8 != null && tileFortheme8.size() >= 1) {
                int i = 0;
                while (true) {
                    if (i >= tileFortheme8.size()) {
                        str3 = "";
                        i = 0;
                        break;
                    } else if (tileFortheme8.get(i).getType().equals(Const.COMBO)) {
                        str3 = tileFortheme8.get(i).getType() + tileFortheme8.get(i).getId();
                        break;
                    } else {
                        if (tileFortheme8.get(i).getType().equals("content")) {
                            str3 = tileFortheme8.get(i).getType() + tileFortheme8.get(i).getId();
                            break;
                        }
                        i++;
                    }
                }
                if (str3.equalsIgnoreCase("")) {
                    callAdapterDataTheme8(tileFortheme8, null, 0);
                    return;
                } else {
                    callAdapterDataTheme8(tileFortheme8, null, i);
                    return;
                }
            }
            this.faqData = new ArrayList<>();
            this.overviewData = new OverviewData();
            this.examPrepItem = new ExamPrepItem();
            ArrayList<Courselist> arrayList = new ArrayList<>();
            this.courseDataArrayList = arrayList;
            InitTestAdapterTheme8(this.cousedetail, this.examPrepItem, this.overviewData, arrayList, this.faqData, Const.NO_DATA, "0");
            return;
        }
        if (ispurchased.equalsIgnoreCase("0")) {
            if (tiles != null && tiles.size() >= 1) {
                int i2 = 0;
                while (true) {
                    if (i2 >= tiles.size()) {
                        str2 = "";
                        i2 = 0;
                        break;
                    } else {
                        if (tiles.get(i2).getType().equals(Const.OVERVIEW)) {
                            str2 = tiles.get(i2).getType() + tiles.get(i2).getId();
                            break;
                        }
                        i2++;
                    }
                }
                if (str2.equalsIgnoreCase("")) {
                    callAdapterData(tiles, null, 0);
                    return;
                } else {
                    callAdapterData(tiles, null, i2);
                    return;
                }
            }
            this.faqData = new ArrayList<>();
            this.overviewData = new OverviewData();
            this.examPrepItem = new ExamPrepItem();
            ArrayList<Courselist> arrayList2 = new ArrayList<>();
            this.courseDataArrayList = arrayList2;
            InitTestAdapter(this.cousedetail, this.examPrepItem, this.overviewData, arrayList2, this.faqData, Const.NO_DATA, "0");
            return;
        }
        if (tiles != null && tiles.size() >= 1) {
            int i3 = 0;
            while (true) {
                if (i3 >= tiles.size()) {
                    str = "";
                    i3 = 0;
                    break;
                }
                if ("1".equals("5")) {
                    if (tiles.get(i3).getType().equals(Const.OVERVIEW)) {
                        str = tiles.get(i3).getType() + tiles.get(i3).getId();
                        break;
                    }
                    i3++;
                } else if (tiles.get(i3).getType().equals(Const.COMBO)) {
                    str = tiles.get(i3).getType() + tiles.get(i3).getId();
                    break;
                } else {
                    if (tiles.get(i3).getType().equals("content")) {
                        str = tiles.get(i3).getType() + tiles.get(i3).getId();
                        break;
                    }
                    i3++;
                }
            }
            if (str.equalsIgnoreCase("")) {
                callAdapterData(tiles, null, 0);
                return;
            } else {
                callAdapterData(tiles, null, i3);
                return;
            }
        }
        this.faqData = new ArrayList<>();
        this.overviewData = new OverviewData();
        this.examPrepItem = new ExamPrepItem();
        ArrayList<Courselist> arrayList3 = new ArrayList<>();
        this.courseDataArrayList = arrayList3;
        InitTestAdapter(this.cousedetail, this.examPrepItem, this.overviewData, arrayList3, this.faqData, Const.NO_DATA, "0");
    }

    private void callAdapterDataTheme8(List<TilesItem> tiles, TilesItem cards, int pos) {
        if (tiles != null) {
            Gson gson = new Gson();
            this.tilePos = pos;
            if (cards != null) {
                this.tileTypeAPI = cards.getType();
                this.tileIdAPI = cards.getId();
                this.revertAPI = cards.getRevertApi();
                this.typeApi = cards.getType() + cards.getId();
                this.currentTileItem = cards;
            } else {
                this.tileTypeAPI = tiles.get(pos).getType();
                this.tileIdAPI = tiles.get(pos).getId();
                this.revertAPI = tiles.get(pos).getRevertApi();
                this.typeApi = tiles.get(pos).getType() + tiles.get(pos).getId();
                this.currentTileItem = tiles.get(pos);
            }
            String str = this.revertAPI.split("\\#")[1];
            if (this.typeApi.equalsIgnoreCase(Const.OVERVIEW + this.tileIdAPI)) {
                com.appnew.android.Model.Overview.Data data = (com.appnew.android.Model.Overview.Data) gson.fromJson(this.currentTileItem.getMeta(), com.appnew.android.Model.Overview.Data.class);
                OverviewData overviewData = new OverviewData();
                this.overviewData = overviewData;
                overviewData.setData(data);
                this.examPrepItem = new ExamPrepItem();
                this.courseDataArrayList = new ArrayList<>();
                ArrayList<FaqData> arrayList = new ArrayList<>();
                this.faqData = arrayList;
                InitTestAdapterTheme8(this.cousedetail, this.examPrepItem, this.overviewData, this.courseDataArrayList, arrayList, this.typeApi, str);
                return;
            }
            int i = 0;
            if (this.typeApi.equalsIgnoreCase(Const.COMBO + this.tileIdAPI)) {
                try {
                    JSONArray jSONArray = new JSONObject(this.currentTileItem.getMeta()).getJSONArray("list");
                    this.courseDataArrayList = new ArrayList<>();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        this.courseDataArrayList.add((Courselist) gson.fromJson(jSONArray.opt(i2).toString(), Courselist.class));
                    }
                    this.faqData = new ArrayList<>();
                    this.examPrepItem = new ExamPrepItem();
                    try {
                        try {
                            JSONArray jSONArray2 = new JSONObject(this.currentTileItem.getMeta()).getJSONArray("list");
                            ArrayList<Lists> arrayList2 = new ArrayList<>();
                            while (i < jSONArray2.length()) {
                                arrayList2.add((Lists) new Gson().fromJson(jSONArray2.opt(i).toString(), Lists.class));
                                i++;
                            }
                            this.examPrepItem.setList(arrayList2);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    } catch (JsonSyntaxException e3) {
                        e3.printStackTrace();
                    }
                    OverviewData overviewData2 = new OverviewData();
                    this.overviewData = overviewData2;
                    InitTestAdapterTheme8(this.cousedetail, this.examPrepItem, overviewData2, this.courseDataArrayList, this.faqData, this.typeApi, str);
                    return;
                } catch (JSONException e4) {
                    e4.printStackTrace();
                    return;
                }
            }
            if (this.typeApi.equalsIgnoreCase(Const.FAQ + this.tileIdAPI)) {
                try {
                    JSONArray jSONArray3 = new JSONObject(this.currentTileItem.getMeta()).getJSONArray("list");
                    this.faqData = new ArrayList<>();
                    while (i < jSONArray3.length()) {
                        this.faqData.add((FaqData) gson.fromJson(jSONArray3.opt(i).toString(), FaqData.class));
                        i++;
                    }
                    this.overviewData = new OverviewData();
                    this.examPrepItem = new ExamPrepItem();
                    ArrayList<Courselist> arrayList3 = new ArrayList<>();
                    this.courseDataArrayList = arrayList3;
                    InitTestAdapterTheme8(this.cousedetail, this.examPrepItem, this.overviewData, arrayList3, this.faqData, this.typeApi, str);
                    return;
                } catch (JSONException e5) {
                    e5.printStackTrace();
                    return;
                }
            }
            if (str.equalsIgnoreCase("3")) {
                NetworkAPICall(API.API_GET_MASTER_DATA, this.typeApi, true, false, false);
                return;
            }
            this.examPrepItem = new ExamPrepItem();
            this.overviewData = new OverviewData();
            this.courseDataArrayList = new ArrayList<>();
            this.faqData = new ArrayList<>();
            if (str.equalsIgnoreCase("3")) {
                handleDownloadsVideoExamPrep(this.examPrepItem.getList());
            }
            if (str.equalsIgnoreCase("1")) {
                try {
                    JSONObject jSONObject = new JSONObject(this.currentTileItem.getMeta());
                    if (jSONObject.getJSONArray("list").length() > 0) {
                        JSONArray jSONArray4 = jSONObject.getJSONArray("list");
                        ArrayList<Lists> arrayList4 = new ArrayList<>();
                        for (int i3 = 0; i3 < jSONArray4.length(); i3++) {
                            if (jSONArray4.optJSONObject(i3).getJSONArray("list").length() > 0) {
                                for (int i4 = 0; i4 < jSONArray4.optJSONObject(i3).getJSONArray("list").length(); i4++) {
                                    arrayList4.add((Lists) gson.fromJson(jSONArray4.optJSONObject(i3).getJSONArray("list").get(i4).toString(), Lists.class));
                                }
                            }
                        }
                        this.examPrepItem.setList(arrayList4);
                    }
                } catch (JSONException e6) {
                    e6.printStackTrace();
                }
            } else {
                try {
                    JSONArray jSONArray5 = new JSONObject(this.currentTileItem.getMeta()).getJSONArray("list");
                    ArrayList<Lists> arrayList5 = new ArrayList<>();
                    for (int i5 = 0; i5 < jSONArray5.length(); i5++) {
                        arrayList5.add((Lists) gson.fromJson(jSONArray5.opt(i5).toString(), Lists.class));
                    }
                    this.examPrepItem.setList(arrayList5);
                } catch (JSONException e7) {
                    e7.printStackTrace();
                }
                if (str.equalsIgnoreCase("0")) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(this.currentTileItem.getMeta());
                        if (jSONObject2.getJSONArray("list").length() > 0) {
                            JSONArray jSONArray6 = jSONObject2.getJSONArray("list");
                            for (int i6 = 0; i6 < jSONArray6.length(); i6++) {
                                ArrayList<Lists> arrayList6 = new ArrayList<>();
                                if (jSONArray6.optJSONObject(i6).getJSONArray("list").length() > 0) {
                                    for (int i7 = 0; i7 < jSONArray6.optJSONObject(i6).getJSONArray("list").length(); i7++) {
                                        arrayList6.add((Lists) gson.fromJson(jSONArray6.optJSONObject(i6).getJSONArray("list").get(i7).toString(), Lists.class));
                                    }
                                }
                                this.examPrepItem.getList().get(i6).setList(arrayList6);
                            }
                        }
                    } catch (JSONException e8) {
                        e8.printStackTrace();
                    }
                }
            }
            InitTestAdapterTheme8(this.cousedetail, this.examPrepItem, this.overviewData, this.courseDataArrayList, this.faqData, this.typeApi, str);
        }
    }

    private void InitTestAdapterTheme8(CourseDetail cousedetail, ExamPrepItem examPrepItem, OverviewData overviewData, ArrayList<Courselist> courseDataArrayList, ArrayList<FaqData> faqData, String type, String isSkip) {
        int i;
        String str;
        int i2;
        try {
            if (!cousedetail.getData().getCourseDetail().getDisplay_locked().equalsIgnoreCase("1")) {
                i = 8;
                str = "1";
                i2 = 0;
                this.studyCourseRV.setVisibility(8);
                this.no_data_found_RL.setVisibility(0);
                Log.d("HEADER_DEBUG", "view_header GONE from XYZ");
                this.view_header.setVisibility(8);
                this.rl_no_data.setVisibility(0);
                this.no_data_found_RL_Header.setVisibility(8);
            } else {
                this.studyCourseRV.setVisibility(0);
                this.rl_no_data.setVisibility(8);
                this.no_data_found_RL.setVisibility(8);
                i2 = 0;
                SingleStudyAdapter4 singleStudyAdapter4 = new SingleStudyAdapter4(this.activity, cousedetail, examPrepItem, overviewData, courseDataArrayList, faqData, this, parentCourseId, this.isCombo, isSkip, this.tilePos, this.tileIdAPI, this.tileTypeAPI, this.revertAPI);
                this.singleStudyAdapter4 = singleStudyAdapter4;
                singleStudyAdapter4.contentType = type;
                Log.e("TAG_APP", "SuccessCallBack: 2750");
                this.studyCourseRV.setAdapter(this.singleStudyAdapter4);
                this.studyCourseRV.setNestedScrollingEnabled(false);
                ((CourseActivity) this.activity).setToolbarTitle(this.course_name);
                ((CourseActivity) this.activity).setToolbarTitle(this.course_name);
                str = "1";
                if (SharedPreference.getInstance().getString(Const.SHARE_CONTENT).equalsIgnoreCase(str)) {
                    ((CourseActivity) this.activity).shareIV.setVisibility(0);
                    i = 8;
                } else {
                    i = 8;
                    ((CourseActivity) this.activity).shareIV.setVisibility(8);
                }
            }
            if (SharedPreference.getInstance().getString(Const.IS_RATING).equalsIgnoreCase(str)) {
                ((CourseActivity) this.activity).rate.setVisibility(i2);
            } else {
                ((CourseActivity) this.activity).rate.setVisibility(i);
            }
            if (SharedPreference.getInstance().getString(Const.IS_CART).equalsIgnoreCase(str)) {
                ((CourseActivity) this.activity).gotoCart.setVisibility(i2);
            } else {
                ((CourseActivity) this.activity).gotoCart.setVisibility(i);
            }
            Helper.setMargins(((CourseActivity) this.activity).shareIV, i2, i2, 16, i2);
        } catch (Exception unused) {
        }
    }

    @Override // com.appnew.android.Courses.Adapter.SingleStudyAdapter.onButtonClicked
    public void onTitleClicked(TilesItem cards, List<TilesItem> tiles, int tilePos) {
        String str = this.content_type;
        if (str != null && str.equalsIgnoreCase("1")) {
            if (tiles.get(tilePos).getType().equalsIgnoreCase(Const.OVERVIEW)) {
                if ("1".equals("4") || "1".equals("5")) {
                    Intent intent = new Intent(this.activity, (Class<?>) CourseActivity.class);
                    intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY2);
                    intent.putExtra(Const.COURSE_ID_MAIN, !parentCourseId.equalsIgnoreCase("") ? parentCourseId : this.cousedetail.getData().getCourseDetail().getId());
                    intent.putExtra(Const.COURSE_PARENT_ID, "");
                    intent.putExtra(Const.CONTENT_TYPE_1, this.content_type);
                    intent.putExtra(Const.IS_COMBO, false);
                    intent.putExtra("tile_id", cards.getId());
                    intent.putExtra(Const.IS_CONTENT_COMBO, this.cousedetail.getData().getCourseDetail().getIs_combo());
                    intent.putExtra(AnalyticsConstants.course_name, this.cousedetail.getData().getCourseDetail().getTitle());
                    Helper.gotoActivity(intent, this.activity);
                    return;
                }
                callAdapterData(tiles, cards, tilePos);
                return;
            }
            if (tiles.get(tilePos).getType().equalsIgnoreCase(Const.CHAT) || tiles.get(tilePos).getType().equalsIgnoreCase(Const.COMBO) || tiles.get(tilePos).getType().equalsIgnoreCase(Const.LIVE_VIDEO) || tiles.get(tilePos).getType().equalsIgnoreCase(Const.FAQ) || (cards.getType() + "_" + cards.getId()).equalsIgnoreCase("folder_001")) {
                callAdapterData(tiles, cards, tilePos);
                return;
            }
            Intent intent2 = new Intent(this.activity, (Class<?>) FolderActivity.class);
            intent2.putExtra("title", tiles.get(tilePos) != null ? tiles.get(tilePos).getTileName() : "Main Folder");
            intent2.putExtra("firstTime", "1");
            SharedPreference sharedPreference = SharedPreference.getInstance();
            Gson gson = new Gson();
            CourseDetail courseDetail = this.cousedetail;
            if (courseDetail == null) {
                courseDetail = new CourseDetail();
            }
            sharedPreference.putString(Const.SINGLE_STUDY_DATA, gson.toJson(courseDetail));
            SharedPreference sharedPreference2 = SharedPreference.getInstance();
            Gson gson2 = new Gson();
            ExamPrepItem examPrepItem = this.examPrepItem;
            if (examPrepItem == null) {
                examPrepItem = new ExamPrepItem();
            }
            sharedPreference2.putString(Const.EXAMPREP, gson2.toJson(examPrepItem));
            SharedPreference.getInstance().putString("list", new Gson().toJson(new Lists()));
            intent2.putExtra(Const.FRAG_TYPE, Const.EXAMPREPLAST);
            intent2.putExtra(Const.IS_COMBO, this.isCombo);
            intent2.putExtra("content_type", this.content_type);
            if (this.tileTypeAPI.equals(Const.COMBO) || this.tileTypeAPI.equals("content")) {
                intent2.putExtra(Const.TAB_TILE_VISIBILITY, "1");
            } else {
                intent2.putExtra(Const.TAB_TILE_VISIBILITY, "0");
            }
            intent2.putExtra("tile_id", tiles.get(tilePos).getId());
            intent2.putExtra(Const.TILE_TYPE, tiles.get(tilePos).getType());
            StringBuilder sb = new StringBuilder();
            CourseDetail courseDetail2 = this.cousedetail;
            if (courseDetail2 != null && courseDetail2.getData() != null && this.cousedetail.getData().getCourseDetail() != null) {
                sb.append(this.cousedetail.getData().getCourseDetail().getIsPurchased());
            } else {
                sb.append("0");
            }
            String[] strArrSplit = this.revertAPI.split(MqttTopic.MULTI_LEVEL_WILDCARD);
            sb.append(MqttTopic.MULTI_LEVEL_WILDCARD).append(strArrSplit[1]);
            sb.append(MqttTopic.MULTI_LEVEL_WILDCARD).append(strArrSplit[2]);
            sb.append(MqttTopic.MULTI_LEVEL_WILDCARD).append(strArrSplit[3]);
            intent2.putExtra(Const.REVERT_API, sb.toString());
            Helper.gotoActivity(intent2, this.activity);
            return;
        }
        if ("1".equals("4") || "1".equals("5")) {
            Intent intent3 = new Intent(this.activity, (Class<?>) CourseActivity.class);
            intent3.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY2);
            intent3.putExtra(Const.COURSE_ID_MAIN, !parentCourseId.equalsIgnoreCase("") ? parentCourseId : this.cousedetail.getData().getCourseDetail().getId());
            intent3.putExtra(Const.COURSE_PARENT_ID, "");
            intent3.putExtra(Const.CONTENT_TYPE_1, this.content_type);
            intent3.putExtra(Const.IS_COMBO, false);
            intent3.putExtra("tile_id", cards.getId());
            intent3.putExtra(Const.IS_CONTENT_COMBO, this.cousedetail.getData().getCourseDetail().getIs_combo());
            intent3.putExtra(AnalyticsConstants.course_name, this.cousedetail.getData().getCourseDetail().getTitle());
            Helper.gotoActivity(intent3, this.activity);
            return;
        }
        if (this.singleStudyAdapter.masterContent != null && this.singleStudyAdapter.masterContent.equalsIgnoreCase("content_master002")) {
            Intent intent4 = new Intent(this.activity, (Class<?>) CourseActivity.class);
            intent4.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
            intent4.putExtra(Const.COURSE_ID_MAIN, this.cousedetail.getData().getCourseDetail().getId());
            intent4.putExtra(Const.COURSE_PARENT_ID, parentCourseId);
            intent4.putExtra(Const.CONTENT_TYPE_1, this.singleStudyAdapter.contentType);
            intent4.putExtra(Const.IS_COMBO, false);
            intent4.putExtra(AnalyticsConstants.course_name, this.cousedetail.getData().getCourseDetail().getTitle());
            Bundle bundle = new Bundle();
            bundle.putSerializable("masterTileItem", (Serializable) tiles);
            bundle.putSerializable("cousedetail", this.cousedetail);
            intent4.putExtras(bundle);
            intent4.putExtra("masterPosition", tilePos);
            intent4.putExtra(Const.CONTENT_MASTER, this.singleStudyAdapter.masterContent);
            this.activity.overridePendingTransition(0, 0);
            startActivity(intent4);
            this.activity.finish();
            return;
        }
        callAdapterData(tiles, cards, tilePos);
    }

    private void gridView(String isSkip, ExamPrepItem examPrepItem) {
        if (SharedPreference.getInstance().getString(Const.GRIDVIEW_SUBJECT).equalsIgnoreCase("1")) {
            if (this.cousedetail.getData().getCourseDetail().getIsPurchased().equalsIgnoreCase("1") && this.typeApi.equalsIgnoreCase("content" + this.tileIdAPI)) {
                String str = this.combo_id;
                if (str == null || str.equalsIgnoreCase("")) {
                    if (isSkip.equalsIgnoreCase("0") || isSkip.equalsIgnoreCase("2")) {
                        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.context, 3);
                        this.gridLayoutManager = gridLayoutManager;
                        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.appnew.android.Courses.Fragment.SingleStudy.10
                            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                            public int getSpanSize(int position) {
                                return SingleStudy.this.singleStudyAdapter.getItemViewType(position) != 0 ? 1 : 3;
                            }
                        });
                        if (examPrepItem != null && examPrepItem.getList().size() > 0) {
                            this.studyCourseRV.setLayoutManager(this.gridLayoutManager);
                            return;
                        } else {
                            this.studyCourseRV.setLayoutManager(this.linearLayoutManager);
                            return;
                        }
                    }
                    this.studyCourseRV.setLayoutManager(this.linearLayoutManager);
                    return;
                }
                this.studyCourseRV.setLayoutManager(this.linearLayoutManager);
                return;
            }
            this.studyCourseRV.setLayoutManager(this.linearLayoutManager);
            return;
        }
        this.studyCourseRV.setLayoutManager(this.linearLayoutManager);
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0296  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void callAdapterData(java.util.List<com.appnew.android.Model.COURSEDETAIL.TilesItem> r19, com.appnew.android.Model.COURSEDETAIL.TilesItem r20, int r21) {
        /*
            Method dump skipped, instruction units count: 1677
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Courses.Fragment.SingleStudy.callAdapterData(java.util.List, com.appnew.android.Model.COURSEDETAIL.TilesItem, int):void");
    }

    private List tileSorting(List<TilesItem> tiles) {
        ArrayList arrayList = new ArrayList();
        Iterator<TilesItem> it = tiles.iterator();
        while (it.hasNext()) {
            if (it.next().getType().equals(Const.FOLDER)) {
                return shotFolderList(tiles);
            }
        }
        for (int i = 0; i < tiles.size(); i++) {
            if (tiles.get(i).getType().equalsIgnoreCase(Const.OVERVIEW) || tiles.get(i).getType().equalsIgnoreCase(Const.FAQ) || tiles.get(i).getType().equalsIgnoreCase("content") || tiles.get(i).getType().equalsIgnoreCase(Const.COMBO) || tiles.get(i).getType().equalsIgnoreCase(Const.TIME_TABLE) || tiles.get(i).getType().equalsIgnoreCase(Const.LIVE_VIDEO) || tiles.get(i).getType().equalsIgnoreCase(Const.UPCOMING_VIDEO) || tiles.get(i).getType().equalsIgnoreCase(Const.CHAT)) {
                arrayList.add(tiles.get(i));
            } else {
                arrayList.add(new TilesItem("1#0#0#0", "Content", "002", Const.CONTENT_MASTER, "", "1", ""));
            }
        }
        return arrayList;
    }

    public ArrayList shotFolderList(List<TilesItem> cardsArrayList) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (int i = 0; i < cardsArrayList.size(); i++) {
            if (cardsArrayList.get(i).getType().equalsIgnoreCase(Const.FOLDER)) {
                z = true;
            } else {
                arrayList.add(cardsArrayList.get(i));
            }
        }
        if (z) {
            arrayList.add(0, new TilesItem("1#0#0#0", "Content", PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY, Const.FOLDER, "", "1", ""));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ce  */
    /* JADX WARN: Type inference failed for: r0v100, types: [androidx.recyclerview.widget.RecyclerView] */
    /* JADX WARN: Type inference failed for: r0v101, types: [androidx.recyclerview.widget.RecyclerView] */
    /* JADX WARN: Type inference failed for: r0v105, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v106, types: [android.widget.RelativeLayout] */
    /* JADX WARN: Type inference failed for: r0v114, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r0v42, types: [android.widget.RelativeLayout] */
    /* JADX WARN: Type inference failed for: r0v58, types: [androidx.recyclerview.widget.RecyclerView] */
    /* JADX WARN: Type inference failed for: r0v63, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r0v73, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r0v90, types: [androidx.recyclerview.widget.RecyclerView] */
    /* JADX WARN: Type inference failed for: r0v95, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r0v98, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23, types: [int] */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r3v13, types: [androidx.recyclerview.widget.RecyclerView] */
    /* JADX WARN: Type inference failed for: r3v46 */
    /* JADX WARN: Type inference failed for: r3v47, types: [int] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [int] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void InitTestAdapter(final com.appnew.android.Model.COURSEDETAIL.CourseDetail r36, com.appnew.android.Model.Courses.ExamPrepItem r37, com.appnew.android.Model.Overview.OverviewData r38, java.util.ArrayList<com.appnew.android.Model.Courselist> r39, java.util.ArrayList<com.appnew.android.Model.FAQs.FaqData> r40, java.lang.String r41, java.lang.String r42) {
        /*
            Method dump skipped, instruction units count: 1554
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Courses.Fragment.SingleStudy.InitTestAdapter(com.appnew.android.Model.COURSEDETAIL.CourseDetail, com.appnew.android.Model.Courses.ExamPrepItem, com.appnew.android.Model.Overview.OverviewData, java.util.ArrayList, java.util.ArrayList, java.lang.String, java.lang.String):void");
    }

    private ArrayList<Video> createVideoList(ExamPrepItem examPrepItem) {
        try {
            Helper.logPrinter("Before List: ", "e", new Gson().toJson(examPrepItem), "Messgae");
            ArrayList<Video> arrayList = new ArrayList<>();
            Gson gson = new Gson();
            if (examPrepItem.getList() != null) {
                Iterator<Lists> it = examPrepItem.getList().iterator();
                while (it.hasNext()) {
                    arrayList.add((Video) gson.fromJson(gson.toJson(it.next()), Video.class));
                }
            }
            Helper.logPrinter("After List: ", "e", new Gson().toJson(arrayList), "Messgae");
            return arrayList;
        } catch (Exception e2) {
            e2.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override // com.appnew.android.Courses.Adapter.SingleStudyAdapter.onQuantityUpdate
    public void onQuantityIncreased(int currentCount) {
        setMrpData(currentCount);
    }

    @Override // com.appnew.android.Courses.Adapter.SingleStudyAdapter.onQuantityUpdate
    public void onQuantityDecreased(int currentCount) {
        setMrpData(currentCount);
    }

    private void setMrpData(int currentCount) {
        this.currentCountOfBooks = currentCount;
        CourseDetailData courseDetail = this.cousedetail.getData().getCourseDetail();
        SharedPreference.getInstance().putInt(Const.CART_COUNT_BOOK, this.currentCountOfBooks);
        Helper.firebaseAnalytics(getActivity(), this.course_name, courseDetail.getMrp(), courseDetail.getTax(), "NA", courseDetail.getId(), "NA", "Course");
        if (courseDetail.getIs_gst() != null && !TextUtils.isEmpty(courseDetail.getIs_gst()) && courseDetail.getIs_gst().equalsIgnoreCase("1")) {
            this.price.setText(Constants.currencyType + "" + (Integer.parseInt(courseDetail.getMrp()) * currentCount) + "/-", TextView.BufferType.SPANNABLE);
            if (courseDetail.getCourseSp() != null && courseDetail.getCourseSp().equalsIgnoreCase(courseDetail.getMrp())) {
                this.mrpCutTV.setVisibility(8);
                this.validityTV.setText(String.format("%s %s", this.activity.getResources().getString(R.string.validity), courseDetail.getValidity().trim(), Boolean.valueOf(courseDetail.getValidity().equalsIgnoreCase("0"))));
                return;
            } else {
                if (Integer.parseInt(courseDetail.getCourseSp()) > 0) {
                    this.mrpCutTV.setText(String.format("%s %s %s", Constants.currencyType, "" + (Integer.parseInt(courseDetail.getCourseSp().trim()) * currentCount), "/-"), TextView.BufferType.SPANNABLE);
                    StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
                    Spannable spannable = (Spannable) this.mrpCutTV.getText();
                    if (Constants.is_offerPrice.equalsIgnoreCase("0")) {
                        this.mrpCutTV.setVisibility(0);
                    } else {
                        this.mrpCutTV.setVisibility(8);
                    }
                    spannable.setSpan(strikethroughSpan, 2, new String(courseDetail.getCourseSp()).length() + 2, 33);
                    return;
                }
                this.mrpCutTV.setVisibility(8);
                return;
            }
        }
        int i = (int) (Float.parseFloat(courseDetail.getMrp()) + Float.parseFloat(courseDetail.getTax()));
        this.price.setText(String.format("%s %s %s", Constants.currencyType, "" + (i * currentCount), "/-"), TextView.BufferType.SPANNABLE);
        if (courseDetail.getCourseSp() != null && courseDetail.getCourseSp().equalsIgnoreCase(String.valueOf(i))) {
            this.mrpCutTV.setVisibility(8);
            this.validityTV.setText(String.format("%s %s", this.activity.getResources().getString(R.string.validity), courseDetail.getValidity().trim(), Boolean.valueOf(courseDetail.getValidity().equalsIgnoreCase("0"))));
        } else {
            if (Integer.parseInt(courseDetail.getCourseSp()) > 0) {
                this.mrpCutTV.setText(String.format("%s %s %s", Constants.currencyType, "" + (Integer.parseInt(courseDetail.getCourseSp().trim()) * currentCount), "/-"), TextView.BufferType.SPANNABLE);
                StrikethroughSpan strikethroughSpan2 = new StrikethroughSpan();
                Spannable spannable2 = (Spannable) this.mrpCutTV.getText();
                if (Constants.is_offerPrice.equalsIgnoreCase("0")) {
                    this.mrpCutTV.setVisibility(0);
                } else {
                    this.mrpCutTV.setVisibility(8);
                }
                spannable2.setSpan(strikethroughSpan2, 2, new String(courseDetail.getCourseSp()).length() + 2, 33);
                return;
            }
            this.mrpCutTV.setVisibility(8);
        }
    }

    public class TileItemsAdapter extends RecyclerView.Adapter<MyViewHolder> {
        private List<TilesItem> cards;
        private Context context;

        public TileItemsAdapter(Context context, ArrayList<TilesItem> cards) {
            this.cards = cards;
            this.context = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            final TilesItem tilesItem = this.cards.get(position);
            if (!this.cards.isEmpty()) {
                SingleStudy.this.cardPosition = 0;
                SingleStudy.this.cardItem = this.cards.get(0);
            }
            if (tilesItem != null && !TextUtils.isEmpty(tilesItem.getType()) && tilesItem.getType().equalsIgnoreCase(Const.LIVE_VIDEO)) {
                try {
                    holder.liveIv.setVisibility(0);
                    Glide.with(SingleStudy.this.activity).asGif().load(Integer.valueOf(R.mipmap.live)).into(holder.liveIv);
                } catch (Exception unused) {
                    holder.liveIv.setVisibility(8);
                }
                holder.tilesText.setPadding(Math.round(Helper.convertDpToPixel(4, this.context)), Math.round(Helper.convertDpToPixel(8, this.context)), Math.round(Helper.convertDpToPixel(4, this.context)), Math.round(Helper.convertDpToPixel(8, this.context)));
            } else {
                holder.liveIv.setVisibility(8);
                holder.tilesText.setPadding(Math.round(Helper.convertDpToPixel(16, this.context)), Math.round(Helper.convertDpToPixel(8, this.context)), Math.round(Helper.convertDpToPixel(16, this.context)), Math.round(Helper.convertDpToPixel(8, this.context)));
            }
            holder.tilesText.setText(tilesItem.getTileName());
            holder.tilesText.setSelected(true);
            if (SingleStudy.this.contentTYpe.equals(tilesItem.getType() + tilesItem.getId())) {
                holder.tilesText.setTextColor(this.context.getResources().getColor(R.color.colorPrimary));
                holder.bg_bottom.setVisibility(0);
            } else {
                holder.tilesText.setTextColor(this.context.getResources().getColor(R.color.black));
                holder.bg_bottom.setVisibility(8);
                holder.tilesText.setTextColor(this.context.getResources().getColor(R.color.country_code_text_color));
            }
            holder.parent.setOnClickListener(new DebouncingOnClickListener(500L, new Function1() { // from class: com.appnew.android.Courses.Fragment.SingleStudy$TileItemsAdapter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return this.f$0.lambda$onBindViewHolder$0(tilesItem, position, (View) obj);
                }
            }));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$onBindViewHolder$0(TilesItem tilesItem, int i, View view) {
            if (Helper.isNetworkConnected(SingleStudy.this.activity)) {
                if (tilesItem.getType().equalsIgnoreCase(Const.TIME_TABLE)) {
                    SingleStudy.this.contentTYpe = tilesItem.getType() + tilesItem.getId();
                    SingleStudy.this.tilePos = i;
                    SingleStudy.this.tileIdAPI = tilesItem.getId();
                    SingleStudy.this.tileTypeAPI = tilesItem.getType();
                    SingleStudy.this.status = false;
                    SingleStudy.this.mPage = 1;
                    SingleStudy.this.isGroupChatClicked = false;
                    SingleStudy singleStudy = SingleStudy.this;
                    singleStudy.revertAPI = singleStudy.cousedetail.getData().getTiles().get(0).getRevertApi();
                    SingleStudy.this.contentTYpe = SingleStudy.this.tileTypeAPI + SingleStudy.this.tileIdAPI;
                    SingleStudy singleStudy2 = SingleStudy.this;
                    singleStudy2.NetworkAPICall(API.API_TIME_TABLE, singleStudy2.contentTYpe, true, false, false);
                    notifyDataSetChanged();
                    SingleStudy.this.studyCourseRVTile.smoothScrollToPosition(SingleStudy.this.tilePos);
                } else if (tilesItem.getType().equalsIgnoreCase(Const.CHAT)) {
                    SingleStudy.this.contentTYpe = tilesItem.getType() + tilesItem.getId();
                    SingleStudy.this.tilePos = i;
                    SingleStudy.this.tileIdAPI = tilesItem.getId();
                    SingleStudy.this.tileTypeAPI = tilesItem.getType();
                    SingleStudy.this.isGroupChatClicked = true;
                    SingleStudy.this.status = false;
                    SingleStudy.this.mPage = 1;
                    SingleStudy singleStudy3 = SingleStudy.this;
                    singleStudy3.revertAPI = singleStudy3.cousedetail.getData().getTiles().get(0).getRevertApi();
                    SingleStudy.this.contentTYpe = SingleStudy.this.tileTypeAPI + SingleStudy.this.tileIdAPI;
                    try {
                        JSONArray jSONArrayOptJSONArray = new JSONObject(tilesItem.getMeta()).optJSONArray("list");
                        ArrayList arrayList = new ArrayList();
                        if (jSONArrayOptJSONArray != null) {
                            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                                arrayList.add((ChatModel) new Gson().fromJson(jSONArrayOptJSONArray.opt(i2).toString(), ChatModel.class));
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            SingleStudy.this.videoArrayList = new ArrayList<>();
                            SingleStudy.this.videoArrayList.clear();
                            SingleStudy.this.examPrepLayer3Adapter = new ExamPrepLayer3Adapter((ArrayList<ChatModel>) arrayList, SingleStudy.this.requireActivity(), SingleStudy.this.cousedetail, SingleStudy.this.videoArrayList, SingleStudy.this.tileIdAPI, SingleStudy.this.tileTypeAPI, SingleStudy.this.revertAPI, SingleStudy.this.tileIdAPI, SingleStudy.this.cousedetail.getData().getCourseDetail().getIsPurchased());
                            Log.e("TAG_APP", "SuccessCallBack: 3463");
                            SingleStudy.this.studyCourseRVContent.setAdapter(SingleStudy.this.examPrepLayer3Adapter);
                        }
                        notifyDataSetChanged();
                        SingleStudy.this.studyCourseRVTile.smoothScrollToPosition(SingleStudy.this.tilePos);
                    } catch (JSONException e2) {
                        throw new RuntimeException(e2);
                    }
                } else {
                    SingleStudy.this.contentTYpe = tilesItem.getType() + tilesItem.getId();
                    SingleStudy.this.tilePos = i;
                    SingleStudy.this.tileIdAPI = tilesItem.getId();
                    SingleStudy.this.tileTypeAPI = tilesItem.getType();
                    SingleStudy.this.status = false;
                    SingleStudy.this.isGroupChatClicked = false;
                    SingleStudy.this.mPage = 1;
                    SingleStudy singleStudy4 = SingleStudy.this;
                    singleStudy4.revertAPI = singleStudy4.cousedetail.getData().getTiles().get(0).getRevertApi();
                    SingleStudy.this.contentTYpe = SingleStudy.this.tileTypeAPI + SingleStudy.this.tileIdAPI;
                    SingleStudy singleStudy5 = SingleStudy.this;
                    singleStudy5.NetworkAPICall(API.API_GET_MASTER_DATA, singleStudy5.typeApi, true, false, false);
                    notifyDataSetChanged();
                    SingleStudy.this.studyCourseRVTile.smoothScrollToPosition(SingleStudy.this.tilePos);
                }
            } else {
                Helper.showInternetToast(SingleStudy.this.activity);
            }
            SingleStudy.this.cardItem = tilesItem;
            SingleStudy.this.cardPosition = i;
            return null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_tiles_theme_2, parent, false));
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public View bg_bottom;
            public ImageView imageView;
            public ImageView liveIv;
            public LinearLayout parent;
            public TextView tilesText;
            public RelativeLayout tour_ll;

            public MyViewHolder(View view) {
                super(view);
                this.tilesText = (TextView) view.findViewById(R.id.tilesTextTv);
                this.parent = (LinearLayout) view.findViewById(R.id.parentBottom);
                this.liveIv = (ImageView) view.findViewById(R.id.liveIV);
                this.imageView = (ImageView) view.findViewById(R.id.imageView);
                this.tour_ll = (RelativeLayout) view.findViewById(R.id.tour_ll);
                this.bg_bottom = view.findViewById(R.id.bg_bottom);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(6, 0, 6, 0);
                this.parent.setLayoutParams(layoutParams);
                this.tilesText.setPadding(Math.round(Helper.convertDpToPixel(16, TileItemsAdapter.this.context)), Math.round(Helper.convertDpToPixel(8, TileItemsAdapter.this.context)), Math.round(Helper.convertDpToPixel(16, TileItemsAdapter.this.context)), Math.round(Helper.convertDpToPixel(8, TileItemsAdapter.this.context)));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.cards.size();
        }
    }

    private void setTileData() {
        if (this.cardItem != null) {
            if (Helper.isNetworkConnected(this.activity)) {
                this.contentTYpe = this.cardItem.getType() + this.cardItem.getId();
                this.tilePos = this.cardPosition;
                this.tileIdAPI = this.cardItem.getId();
                this.tileTypeAPI = this.cardItem.getType();
                this.status = false;
                this.mPage = 1;
                this.revertAPI = this.cousedetail.getData().getTiles().get(0).getRevertApi();
                this.contentTYpe = this.tileTypeAPI + this.tileIdAPI;
                NetworkAPICall(API.API_GET_MASTER_DATA, this.typeApi, true, false, false);
                this.studyCourseRVTile.smoothScrollToPosition(this.tilePos);
                return;
            }
            Helper.showInternetToast(this.activity);
        }
    }

    private void initButton(CourseDetailData course) {
        RelativeLayout relativeLayout;
        boolean z = course.getExtra_json() != null && "1".equalsIgnoreCase(course.getExtra_json().getSold_out());
        final boolean z2 = course.getIsPurchased() != null && "1".equalsIgnoreCase(course.getIsPurchased());
        if (z && !z2) {
            RelativeLayout relativeLayout2 = this.view_header;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(0);
            }
            if (this.coursename != null && !TextUtils.isEmpty(course.getTitle())) {
                this.coursename.setText(course.getTitle());
            }
            if (this.authorname != null && course.getAuthor() != null && !TextUtils.isEmpty(course.getAuthor().getTitle())) {
                this.authorname.setText(this.activity.getResources().getString(R.string.by) + course.getAuthor().getTitle());
            } else {
                TextView textView = this.authorname;
                if (textView != null) {
                    textView.setText(this.activity.getResources().getString(R.string.by) + this.activity.getResources().getString(R.string.app_name));
                }
            }
            if (this.validityTV != null && !TextUtils.isEmpty(course.getValidity()) && !"0".equals(course.getValidity())) {
                this.validityTV.setVisibility(0);
                this.validityTV.setText(this.activity.getResources().getString(R.string.validity_) + course.getValidity());
            } else {
                TextView textView2 = this.validityTV;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
            }
            if (this.courseImagebg != null) {
                String descHeaderImage = course.getDescHeaderImage();
                if (TextUtils.isEmpty(descHeaderImage)) {
                    descHeaderImage = course.getCover_image();
                }
                if (!TextUtils.isEmpty(descHeaderImage)) {
                    Activity activity = this.activity;
                    Helper.setThumbnailImage(activity, descHeaderImage, activity.getResources().getDrawable(R.mipmap.square_placeholder), this.courseImagebg);
                }
            }
        }
        boolean z3 = z && !z2 && (relativeLayout = this.view_header) != null && relativeLayout.getVisibility() == 0;
        FrameLayout frameLayout = this.soldOutImg;
        if (frameLayout != null) {
            frameLayout.setVisibility(z3 ? 0 : 8);
        }
        if (z && !z2) {
            this.buyNowBtn.setVisibility(0);
            this.buyNowBtn.setBackgroundResource(R.drawable.sold_out_circle);
            this.buyNowBtn.setText(R.string.sold_out);
            this.buyNowBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.SingleStudy$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$initButton$6(view);
                }
            });
        }
        if (this.isCombo || course.getIsPurchased().equalsIgnoreCase("1")) {
            this.buttonLow.setVisibility(8);
        } else {
            if ((course != null && course.getSkip_payment() != null && course.getSkip_payment().equalsIgnoreCase("1")) || "1".equalsIgnoreCase("5")) {
                this.buttonLow.setVisibility(8);
            } else {
                CourseDetail courseDetail = this.cousedetail;
                if (courseDetail != null && courseDetail.getData() != null && this.cousedetail.getData().getCourseDetail() != null && this.cousedetail.getData().getCourseDetail().getCat_type() != null && this.cousedetail.getData().getCourseDetail().getCat_type().equalsIgnoreCase("3")) {
                    this.buttonLow.setVisibility(8);
                } else {
                    this.buttonLow.setVisibility(0);
                }
                this.is_purchased_course = "1";
            }
            int i = (int) (Float.parseFloat(course.getMrp()) + Float.parseFloat(course.getTax()));
            if (i == 0) {
                this.buyNowBtn.setVisibility(8);
                this.mrpCutTV.setVisibility(8);
                this.priceLL.setVisibility(8);
                this.myLibBtn.setVisibility(0);
                this.myLibBtn.setText(SharedPreference.getInstance().getString(Const.ENROLL_NOW).equalsIgnoreCase("1") ? "Enroll Now" : this.activity.getResources().getString(R.string.open_in_my_lib));
                if ("1".equalsIgnoreCase("7") || "1".equalsIgnoreCase("5")) {
                    this.buttonLow.setVisibility(8);
                } else {
                    if (course != null && course.getSkip_payment() != null && course.getSkip_payment().equalsIgnoreCase("1")) {
                        this.buttonLow.setVisibility(8);
                    } else {
                        CourseDetail courseDetail2 = this.cousedetail;
                        if (courseDetail2 != null && courseDetail2.getData() != null && this.cousedetail.getData().getCourseDetail() != null && this.cousedetail.getData().getCourseDetail().getCat_type().equalsIgnoreCase("3")) {
                            this.buttonLow.setVisibility(8);
                        } else {
                            this.buttonLow.setVisibility(0);
                        }
                    }
                    this.is_purchased_course = "1";
                }
                this.myLibBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.SingleStudy$$ExternalSyntheticLambda8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$initButton$7(z2, view);
                    }
                });
            } else {
                if (SharedPreference.getInstance().getString(Const.IS_CART).equalsIgnoreCase("1")) {
                    this.linear_addToCart.setVisibility(0);
                } else {
                    this.linear_addToCart.setVisibility(8);
                }
                CourseDetail courseDetail3 = this.cousedetail;
                if (courseDetail3 != null && courseDetail3.getData() != null) {
                    if (this.cousedetail.getData().getCourseDetail().getInstallment() != null && !TextUtils.isEmpty(this.cousedetail.getData().getCourseDetail().getInstallment())) {
                        InstallmentResponse installmentResponse = (InstallmentResponse) new Gson().fromJson(this.cousedetail.getData().getCourseDetail().getInstallment(), InstallmentResponse.class);
                        if ((installmentResponse.getInstallment() == null || installmentResponse.getInstallment().size() <= 0) && SharedPreference.getInstance().getString(Const.IS_CART).equalsIgnoreCase("1")) {
                            this.linear_addToCart.setVisibility(0);
                        } else {
                            this.linear_addToCart.setVisibility(8);
                        }
                    } else if (SharedPreference.getInstance().getString(Const.IS_CART).equalsIgnoreCase("1")) {
                        this.linear_addToCart.setVisibility(0);
                    } else {
                        this.linear_addToCart.setVisibility(8);
                    }
                } else if (SharedPreference.getInstance().getString(Const.IS_CART).equalsIgnoreCase("1")) {
                    this.linear_addToCart.setVisibility(0);
                } else {
                    this.linear_addToCart.setVisibility(8);
                }
                CourseDetail courseDetail4 = this.cousedetail;
                if (courseDetail4 != null && courseDetail4.getData() != null) {
                    if (this.cousedetail.getData().getCourseDetail().getCat_type() != null && this.cousedetail.getData().getCourseDetail().getCat_type().equalsIgnoreCase("1")) {
                        this.linear_addToCart.setVisibility(8);
                    } else if (this.cousedetail.getData().getCourseDetail().getInstallment() != null && !TextUtils.isEmpty(this.cousedetail.getData().getCourseDetail().getInstallment())) {
                        InstallmentResponse installmentResponse2 = (InstallmentResponse) new Gson().fromJson(this.cousedetail.getData().getCourseDetail().getInstallment(), InstallmentResponse.class);
                        if ((installmentResponse2.getInstallment() == null || installmentResponse2.getInstallment().size() <= 0) && SharedPreference.getInstance().getString(Const.IS_CART).equalsIgnoreCase("1")) {
                            this.linear_addToCart.setVisibility(0);
                        } else {
                            this.linear_addToCart.setVisibility(8);
                        }
                    }
                }
                if (this.cousedetail.getData().getCourseDetail().getIs_trial() != null && !this.cousedetail.getData().getCourseDetail().getIs_trial().equalsIgnoreCase("0")) {
                    if (this.cousedetail.getData().getCourseDetail().getIs_trial().equalsIgnoreCase("2")) {
                        this.buyNowBtn.setText("Resume");
                    }
                    this.priceLL.setVisibility(8);
                } else {
                    this.priceLL.setVisibility(0);
                }
                this.buyNowBtn.setVisibility(0);
                this.myLibBtn.setVisibility(8);
                String skip_payment = "";
                this.price.setText(String.format("%s %s %s", Constants.currencyType, "" + i, "/-"));
                setGstDesc(course);
                if (Integer.parseInt(course.getCourseSp()) > 0) {
                    this.mrpCutTV.setText(String.format("%s %s %s", Constants.currencyType, course.getCourseSp().trim(), "/-"), TextView.BufferType.SPANNABLE);
                    StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
                    Spannable spannable = (Spannable) this.mrpCutTV.getText();
                    if (Constants.is_offerPrice.equalsIgnoreCase("0")) {
                        this.mrpCutTV.setVisibility(0);
                    } else {
                        this.mrpCutTV.setVisibility(8);
                    }
                    spannable.setSpan(strikethroughSpan, 2, new String(course.getCourseSp()).length() + 2, 33);
                } else {
                    this.mrpCutTV.setVisibility(8);
                }
                String id = course.getId();
                if (course != null && course.getSkip_payment() != null) {
                    skip_payment = course.getSkip_payment();
                }
                getDueEmi(id, skip_payment);
            }
        }
        if (isCourseSoldOut() && this.myLibBtn.getVisibility() == 0) {
            this.myLibBtn.setBackgroundResource(R.drawable.sold_out_circle);
            this.myLibBtn.setText(getString(R.string.sold_out));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initButton$6(View view) {
        Toast.makeText(this.activity, R.string.sold_out_msg, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initButton$7(boolean z, View view) {
        if (isCourseSoldOut() && !z) {
            Toast.makeText(this.activity, getString(R.string.sold_out_msg), 0).show();
        } else {
            onClick(view);
        }
    }

    private boolean isCourseSoldOut() {
        try {
            CourseDetail courseDetail = this.cousedetail;
            if (courseDetail == null || courseDetail.getData() == null || this.cousedetail.getData().getCourseDetail() == null || this.cousedetail.getData().getCourseDetail().getExtra_json() == null || this.cousedetail.getData().getCourseDetail().getExtra_json().getSold_out() == null) {
                return false;
            }
            return this.cousedetail.getData().getCourseDetail().getExtra_json().getSold_out().equalsIgnoreCase("1");
        } catch (Exception unused) {
            return false;
        }
    }

    private void setGstDesc(CourseDetailData course) {
        if (course.getIs_gst() != null && !course.getIs_gst().equalsIgnoreCase("")) {
            if (course.getIs_gst().equalsIgnoreCase("0")) {
                this.tvGstDesc.setText(Constants.gstIncludedText);
            } else {
                this.tvGstDesc.setText(Constants.gstExcludedText);
                this.price.setText(String.format("%s %s %s", Constants.currencyType, "" + ((int) Float.parseFloat(course.getMrp())), "/-"));
            }
        } else {
            this.tvGstDesc.setText("N/A");
        }
        if (!TextUtils.isEmpty(course.getTax_rate()) && !course.getTax_rate().equalsIgnoreCase("0")) {
            this.tvGstDesc.setVisibility(0);
        } else {
            this.tvGstDesc.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.buyNowBtn) {
            if (id == R.id.linear_addToCart) {
                if (Helper.isNetworkConnected(this.activity)) {
                    NetworkAPICall(API.COURSE_ADD_TO_CART, "", true, false, false);
                    return;
                } else {
                    Activity activity = this.activity;
                    Toast.makeText(activity, activity.getResources().getString(R.string.Retry_with_Internet_connection), 1).show();
                    return;
                }
            }
            if (id != R.id.myLibBtn) {
                return;
            }
            CourseDetail courseDetail = this.cousedetail;
            if (courseDetail != null && courseDetail.getData() != null && this.cousedetail.getData().getCourseDetail() != null && this.cousedetail.getData().getCourseDetail().getCat_type().equalsIgnoreCase("5")) {
                Intent intent = new Intent(this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra("test_data", "");
                intent.putExtra(Const.SINGLE_STUDY, this.cousedetail);
                intent.putExtra("test_id", "0");
                intent.putExtra(Const.IS_BOOK, this.cousedetail.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, this.cousedetail.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, this.activity);
                return;
            }
            NetworkAPICall("https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction", "", true, false, false);
            return;
        }
        if (!Helper.isConnected(requireContext())) {
            Helper.showInternetToast(requireContext());
            return;
        }
        CourseDetail courseDetail2 = this.cousedetail;
        FacebookEventLogger.logBuyNowClicked(requireContext(), (courseDetail2 == null || courseDetail2.getData() == null || this.cousedetail.getData().getCourseDetail() == null) ? null : this.cousedetail.getData().getCourseDetail().getId(), Helper.getLoggedInUserInfo(requireContext()));
        CourseDetail courseDetail3 = this.cousedetail;
        if (courseDetail3 != null && courseDetail3.getData() != null && this.cousedetail.getData().getCourseDetail() != null && this.cousedetail.getData().getCourseDetail().getCat_type().equalsIgnoreCase("3")) {
            hitApiForTest();
            return;
        }
        CourseDetail courseDetail4 = this.cousedetail;
        if (courseDetail4 != null && courseDetail4.getData() != null && this.cousedetail.getData().getCourseDetail() != null && this.cousedetail.getData().getCourseDetail().getCat_type().equalsIgnoreCase("5")) {
            Intent intent2 = new Intent(this.activity, (Class<?>) PurchaseActivity.class);
            intent2.putExtra("test_data", "");
            SharedPreference.getInstance().putString(Const.SINGLE_STUDY, new Gson().toJson(this.cousedetail));
            intent2.putExtra("test_id", "0");
            intent2.putExtra(Const.IS_BOOK, this.cousedetail.getData().getCourseDetail().getCat_type());
            intent2.putExtra(Const.DELIVERY_CHARGE, this.cousedetail.getData().getCourseDetail().getDelivery_charge());
            Helper.gotoActivity(intent2, this.activity);
            return;
        }
        if (!TextUtils.isEmpty(this.cousedetail.getData().getCourseDetail().getCat_type()) && this.cousedetail.getData().getCourseDetail().getCat_type().equalsIgnoreCase("1") && !TextUtils.isEmpty(this.cousedetail.getData().getCourseDetail().getBook_redirection_link()) && !TextUtils.isEmpty(this.cousedetail.getData().getCourseDetail().getTitle())) {
            Intent intent3 = new Intent("android.intent.action.VIEW", Uri.parse(this.cousedetail.getData().getCourseDetail().getBook_redirection_link()));
            if (!this.context.getPackageManager().queryIntentActivities(intent3, 65536).isEmpty()) {
                this.context.startActivity(intent3);
                return;
            } else {
                Toast.makeText(this.context, "No browser found. Please install one.", 1).show();
                return;
            }
        }
        if (this.cousedetail.getData().getCourseDetail().getIs_trial() != null && this.cousedetail.getData().getCourseDetail().getIs_trial().equalsIgnoreCase("2")) {
            RESUME_SUBSCRIPTION_API();
            return;
        }
        Intent intent4 = new Intent(this.activity, (Class<?>) PurchaseActivity.class);
        SharedPreference.getInstance().putString(Const.SINGLE_STUDY, new Gson().toJson(this.cousedetail));
        intent4.putExtra("test_id", "");
        if (this.cousedetail.getData().getCourseDetail().getIs_trial() != null) {
            intent4.putExtra("is_trial", this.cousedetail.getData().getCourseDetail().getIs_trial());
        }
        if (this.cousedetail.getData().getCourseDetail().getLast_paid_txn_id() != null) {
            intent4.putExtra("last_paid_txn_id", this.cousedetail.getData().getCourseDetail().getLast_paid_txn_id());
        }
        if (this.cousedetail.getData().getSubscriptionAllData() != null) {
            intent4.putExtra("payment_mode", this.cousedetail.getData().getSubscriptionAllData().getPaymentMode());
        }
        if (this.cousedetail.getData().getCourseDetail().getCat_type().equalsIgnoreCase("1")) {
            intent4.putExtra("quantityOfBooks", String.valueOf(this.currentCountOfBooks));
        }
        intent4.putExtra(Const.IS_BOOK, this.cousedetail.getData().getCourseDetail().getCat_type());
        intent4.putExtra(Const.DELIVERY_CHARGE, this.cousedetail.getData().getCourseDetail().getDelivery_charge());
        Helper.gotoActivity(intent4, this.activity);
    }

    private void RESUME_SUBSCRIPTION_API() {
        NetworkAPICall(API.RESUME_SUBSCRIPTION, "", false, false, false);
    }

    public boolean isShowAddressUnfill(CourseDetail courseDetail) {
        String isPurchased = "0";
        String combo_has_book = (courseDetail == null || courseDetail.getData() == null || courseDetail.getData().getCourseDetail() == null || TextUtils.isEmpty(courseDetail.getData().getCourseDetail().getCombo_has_book())) ? "0" : courseDetail.getData().getCourseDetail().getCombo_has_book();
        if (courseDetail != null && courseDetail.getData() != null && courseDetail.getData().getCourseDetail() != null && !TextUtils.isEmpty(courseDetail.getData().getCourseDetail().getIsPurchased())) {
            isPurchased = courseDetail.getData().getCourseDetail().getIsPurchased();
        }
        Log.d("TAGAddressModule", "comboHasBook: " + combo_has_book + " - isPurchase: " + isPurchased);
        return !TextUtils.isEmpty(combo_has_book) && combo_has_book.equals("1") && !TextUtils.isEmpty(isPurchased) && isPurchased.equals("1");
    }

    public boolean isShowAddress(CourseDetail courseDetail) {
        String combo_has_book = (courseDetail == null || courseDetail.getData() == null || courseDetail.getData().getCourseDetail() == null || TextUtils.isEmpty(courseDetail.getData().getCourseDetail().getCombo_has_book())) ? "0" : courseDetail.getData().getCourseDetail().getCombo_has_book();
        Log.d("TAGAddressModule", "comboHasBook: " + combo_has_book);
        return !TextUtils.isEmpty(combo_has_book) && combo_has_book.equals("1");
    }

    public void showUpdateStatePopup(CourseDetail cousedetail) {
        UpdateProfileDialogUtils.makeDialogForStateUpdate(this.context, isShowAddress(cousedetail), new UpdateProfileDialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Courses.Fragment.SingleStudy.12
            /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
            
                if (r9.equals("1") != false) goto L15;
             */
            @Override // com.appnew.android.Utils.UpdateProfileDialogUtils.onDialogUtilsOkClick
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void onOKClick(android.app.Dialog r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12) {
                /*
                    r7 = this;
                    long r0 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Exception -> L5e
                    com.appnew.android.Courses.Fragment.SingleStudy r2 = com.appnew.android.Courses.Fragment.SingleStudy.this     // Catch: java.lang.Exception -> L5e
                    long r2 = r2.mLastClickTime     // Catch: java.lang.Exception -> L5e
                    long r0 = r0 - r2
                    r2 = 1000(0x3e8, double:4.94E-321)
                    int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r0 >= 0) goto L10
                    return
                L10:
                    com.appnew.android.Courses.Fragment.SingleStudy r0 = com.appnew.android.Courses.Fragment.SingleStudy.this     // Catch: java.lang.Exception -> L5e
                    long r1 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Exception -> L5e
                    r0.mLastClickTime = r1     // Catch: java.lang.Exception -> L5e
                    int r0 = r9.hashCode()     // Catch: java.lang.Exception -> L5e
                    r1 = 49
                    if (r0 == r1) goto L2f
                    r1 = 50
                    if (r0 == r1) goto L26
                L24:
                    r2 = r8
                    goto L42
                L26:
                    java.lang.String r0 = "2"
                    boolean r0 = r9.equals(r0)     // Catch: java.lang.Exception -> L5e
                    if (r0 == 0) goto L24
                    goto L37
                L2f:
                    java.lang.String r0 = "1"
                    boolean r0 = r9.equals(r0)     // Catch: java.lang.Exception -> L5e
                    if (r0 == 0) goto L24
                L37:
                    com.appnew.android.Courses.Fragment.SingleStudy r1 = com.appnew.android.Courses.Fragment.SingleStudy.this     // Catch: java.lang.Exception -> L5e
                    r2 = r8
                    r3 = r9
                    r4 = r10
                    r5 = r11
                    r6 = r12
                    r1.submitUpdateStateData(r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L5e
                    return
                L42:
                    com.appnew.android.Courses.Fragment.SingleStudy r8 = com.appnew.android.Courses.Fragment.SingleStudy.this     // Catch: java.lang.Exception -> L5e
                    com.appnew.android.Room.UtkashRoom r8 = com.appnew.android.Courses.Fragment.SingleStudy.m10221$$Nest$fgetutkashRoom(r8)     // Catch: java.lang.Exception -> L5e
                    com.appnew.android.Dao.CourseDetailDao r8 = r8.getCourseDetaildata()     // Catch: java.lang.Exception -> L5e
                    java.lang.String r9 = com.appnew.android.Courses.Fragment.SingleStudy.parentCourseId     // Catch: java.lang.Exception -> L5e
                    java.lang.String r10 = com.appnew.android.Utils.MakeMyExam.userId     // Catch: java.lang.Exception -> L5e
                    r8.deletecoursedetail(r9, r10)     // Catch: java.lang.Exception -> L5e
                    r2.dismiss()     // Catch: java.lang.Exception -> L5e
                    com.appnew.android.Courses.Fragment.SingleStudy r8 = com.appnew.android.Courses.Fragment.SingleStudy.this     // Catch: java.lang.Exception -> L5e
                    android.app.Activity r8 = r8.activity     // Catch: java.lang.Exception -> L5e
                    r8.finish()     // Catch: java.lang.Exception -> L5e
                    return
                L5e:
                    r0 = move-exception
                    r8 = r0
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder
                    java.lang.String r10 = "makeDialog: "
                    r9.<init>(r10)
                    java.lang.String r8 = r8.getMessage()
                    java.lang.StringBuilder r8 = r9.append(r8)
                    java.lang.String r8 = r8.toString()
                    java.lang.String r9 = "Dialog"
                    android.util.Log.d(r9, r8)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Courses.Fragment.SingleStudy.AnonymousClass12.onOKClick(android.app.Dialog, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
            }
        });
    }

    public void submitUpdateStateData(final Dialog dialog, String submitType, final String stateId, final String districtId, String addressJson) {
        if (Helper.isNetworkConnected(this.context)) {
            Helper.showProgressDialog(this.context);
            APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
            EncryptionData encryptionData = new EncryptionData();
            if (submitType.equals("1")) {
                encryptionData.setState(stateId);
            } else {
                encryptionData.setState(stateId);
                encryptionData.setAddress(addressJson);
            }
            aPIInterface.updateprofile(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new Callback<String>() { // from class: com.appnew.android.Courses.Fragment.SingleStudy.13
                @Override // retrofit2.Callback
                public void onResponse(Call<String> call, Response<String> response) {
                    Helper.dismissProgressDialog();
                    try {
                        if (response.body() != null) {
                            JSONObject jSONObject = new JSONObject(AES.decrypt(response.body(), AES.generatekeyAPI(), AES.generateVectorAPI()));
                            com.appnew.android.pojo.Userinfo.Data loggedInUser = SharedPreference.getInstance().getLoggedInUser();
                            loggedInUser.setState(stateId);
                            loggedInUser.setCity(districtId);
                            SharedPreference.getInstance().setLoggedInUserr(loggedInUser);
                            Toast.makeText(SingleStudy.this.context, jSONObject.getString("message"), 1).show();
                            SingleStudy.this.utkashRoom.getCourseDetaildata().deletecoursedetail(SingleStudy.parentCourseId, MakeMyExam.userId);
                            dialog.dismiss();
                            SingleStudy.this.activity.finish();
                        }
                    } catch (Exception e2) {
                        Log.d("Dialog", "onResponse: " + e2.getMessage());
                    }
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<String> call, Throwable t) {
                    Helper.dismissProgressDialog();
                    Toast.makeText(SingleStudy.this.context, SingleStudy.this.getResources().getString(R.string.something_went_wrong), 1).show();
                }
            });
            return;
        }
        Toast.makeText(this.context, getResources().getString(R.string.Retry_with_Internet_connection), 1).show();
    }

    private void showEnrollmentPoppup(Context activity) {
        hit_api_to_get_state();
        View viewInflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.enrollment_form, (ViewGroup) null, false);
        Dialog dialog = new Dialog(activity, R.style.CustomAlertDialog);
        this.enrollmentDialog = dialog;
        dialog.requestWindowFeature(1);
        this.enrollmentDialog.setCanceledOnTouchOutside(false);
        this.enrollmentDialog.setCancelable(false);
        this.enrollmentDialog.setContentView(viewInflate);
        this.enrollmentDialog.getWindow().setLayout(-1, -1);
        this.enrollmentDialog.show();
        findEnrollPopViewIDS(viewInflate);
    }

    private void findEnrollPopViewIDS(View view) {
        userImage = (CircleImageView) view.findViewById(R.id.userImage);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.picUserImgLL);
        adharImage = (CircleImageView) view.findViewById(R.id.adharImage);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.picAadharImgLL);
        final EditText editText = (EditText) view.findViewById(R.id.et_stname);
        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.rg_stProfession);
        final RadioButton radioButton = (RadioButton) view.findViewById(R.id.rb_stProff_student);
        final RadioButton radioButton2 = (RadioButton) view.findViewById(R.id.rb_stProff_pvtJob);
        final RadioButton radioButton3 = (RadioButton) view.findViewById(R.id.rb_stProff_govJob);
        final EditText editText2 = (EditText) view.findViewById(R.id.et_fname);
        RadioGroup radioGroup2 = (RadioGroup) view.findViewById(R.id.rg_ftProfession);
        final RadioButton radioButton4 = (RadioButton) view.findViewById(R.id.rb_ftProff_agri);
        final RadioButton radioButton5 = (RadioButton) view.findViewById(R.id.rb_ftProff_pvtJob);
        final RadioButton radioButton6 = (RadioButton) view.findViewById(R.id.rb_ftProff_govJob);
        RelativeLayout relativeLayout3 = (RelativeLayout) view.findViewById(R.id.dobRl);
        final TextView textView = (TextView) view.findViewById(R.id.dobTV);
        final EditText editText3 = (EditText) view.findViewById(R.id.et_pAddress);
        RelativeLayout relativeLayout4 = (RelativeLayout) view.findViewById(R.id.state);
        this.stateSpinner = (TextView) view.findViewById(R.id.stateSpinner);
        RelativeLayout relativeLayout5 = (RelativeLayout) view.findViewById(R.id.city);
        this.citySpinner = (TextView) view.findViewById(R.id.citySpinner);
        final EditText editText4 = (EditText) view.findViewById(R.id.et_stmobile);
        final EditText editText5 = (EditText) view.findViewById(R.id.et_fmobile);
        final EditText editText6 = (EditText) view.findViewById(R.id.emailTV);
        Button button = (Button) view.findViewById(R.id.submitBtn);
        RelativeLayout relativeLayout6 = (RelativeLayout) view.findViewById(R.id.country);
        this.countrySpinner = (TextView) view.findViewById(R.id.countrySpinner);
        Button button2 = (Button) view.findViewById(R.id.cancelBtn);
        ImageView imageView = (ImageView) view.findViewById(R.id.image_back);
        final Calendar calendar = Calendar.getInstance();
        final TextView textView2 = (TextView) view.findViewById(R.id.tv_stProfessionError);
        final TextView textView3 = (TextView) view.findViewById(R.id.tv_ftProfessionError);
        final TextView textView4 = (TextView) view.findViewById(R.id.dobError);
        final TextView textView5 = (TextView) view.findViewById(R.id.countryError);
        final TextView textView6 = (TextView) view.findViewById(R.id.stateError);
        final TextView textView7 = (TextView) view.findViewById(R.id.cityError);
        final TextView textView8 = (TextView) view.findViewById(R.id.userImageError);
        final TextView textView9 = (TextView) view.findViewById(R.id.adharImageError);
        relativeLayout6.setVisibility(8);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.SingleStudy$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$findEnrollPopViewIDS$8(view2);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.SingleStudy$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$findEnrollPopViewIDS$9(view2);
            }
        });
        relativeLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.SingleStudy.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                SingleStudy.this.openDatePickerDialog(view2.getContext(), textView, calendar, textView4);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.SingleStudy.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                SingleStudy.this.openDatePickerDialog(view2.getContext(), textView, calendar, textView4);
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.appnew.android.Courses.Fragment.SingleStudy.16
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup3, int i) {
                Helper.enableErrorInTextview(textView2, null);
            }
        });
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.appnew.android.Courses.Fragment.SingleStudy.17
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup3, int i) {
                Helper.enableErrorInTextview(textView3, null);
            }
        });
        relativeLayout6.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.SingleStudy.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SingleStudy.this.countries == null || SingleStudy.this.countries.getData().size() == 0) {
                    Toast.makeText(SingleStudy.this.context, SingleStudy.this.activity.getResources().getString(R.string.no_country_available), 0).show();
                    return;
                }
                Helper.enableErrorInTextview(textView5, null);
                SingleStudy.this.clicktype = "3";
                SingleStudy singleStudy = SingleStudy.this;
                singleStudy.filterList(singleStudy.clicktype, SingleStudy.this.countries);
            }
        });
        relativeLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.SingleStudy.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SingleStudy.this.states == null || SingleStudy.this.states.getData().size() == 0) {
                    Toast.makeText(SingleStudy.this.context, SingleStudy.this.activity.getResources().getString(R.string.no_states_available), 0).show();
                    return;
                }
                Helper.enableErrorInTextview(textView6, null);
                SingleStudy.this.clicktype = "1";
                SingleStudy singleStudy = SingleStudy.this;
                singleStudy.filterList(singleStudy.clicktype, SingleStudy.this.states);
            }
        });
        relativeLayout5.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.SingleStudy.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SingleStudy.this.cities == null || SingleStudy.this.cities.getData().size() == 0) {
                    Toast.makeText(SingleStudy.this.context, SingleStudy.this.activity.getResources().getString(R.string.no_city_available), 0).show();
                    return;
                }
                Helper.enableErrorInTextview(textView7, null);
                SingleStudy.this.clicktype = "2";
                SingleStudy singleStudy = SingleStudy.this;
                singleStudy.filterList(singleStudy.clicktype, SingleStudy.this.cities);
            }
        });
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.SingleStudy.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SingleStudy.this.context instanceof CourseActivity) {
                    Helper.enableErrorInTextview(textView8, null);
                    SharedPreference.getInstance().putString(Const.FORWHAT, SingleStudy.STUDENT_IMAGE);
                    ((CourseActivity) SingleStudy.this.context).checkStoragePermission(1);
                }
            }
        });
        relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.SingleStudy.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SingleStudy.this.context instanceof CourseActivity) {
                    Helper.enableErrorInTextview(textView9, null);
                    SharedPreference.getInstance().putString(Const.FORWHAT, SingleStudy.AADHAR_IMAGE);
                    ((CourseActivity) SingleStudy.this.context).checkStoragePermission(2);
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.SingleStudy.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                SingleStudy.this.studentName = Helper.getTextFromEditText(editText);
                SingleStudy.this.fatherName = Helper.getTextFromEditText(editText2);
                SingleStudy.this.permanentAddress = Helper.getTextFromEditText(editText3);
                SingleStudy.this.studentMobile = Helper.getTextFromEditText(editText4);
                SingleStudy.this.fatherMobile = Helper.getTextFromEditText(editText5);
                SingleStudy.this.email = Helper.getTextFromEditText(editText6);
                SingleStudy.this.dob = textView.getText().toString();
                SingleStudy singleStudy = SingleStudy.this;
                singleStudy.sProfession = singleStudy.getProfessioData(radioButton, radioButton3, radioButton2);
                SingleStudy singleStudy2 = SingleStudy.this;
                singleStudy2.fProfession = singleStudy2.getProfessioData(radioButton4, radioButton6, radioButton5);
                if (TextUtils.isEmpty(SingleStudy.imagepath) && SingleStudy.imagepath.equalsIgnoreCase("")) {
                    Helper.enableErrorInTextview(textView8, SingleStudy.this.activity.getResources().getString(R.string.select_student_image));
                    return;
                }
                if (TextUtils.isEmpty(SingleStudy.adharImhPath) && SingleStudy.adharImhPath.equalsIgnoreCase("")) {
                    Helper.enableErrorInTextview(textView9, SingleStudy.this.activity.getResources().getString(R.string.select_aadhar_image));
                    return;
                }
                if (TextUtils.isEmpty(SingleStudy.this.studentName) && SingleStudy.this.studentName.equalsIgnoreCase("")) {
                    editText.setError(SingleStudy.this.activity.getResources().getString(R.string.enter_student_name));
                    editText.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(SingleStudy.this.sProfession) && SingleStudy.this.sProfession.equalsIgnoreCase("")) {
                    Helper.enableErrorInTextview(textView2, SingleStudy.this.activity.getResources().getString(R.string.select_student_profession));
                    return;
                }
                if (TextUtils.isEmpty(SingleStudy.this.fatherName) && SingleStudy.this.fatherName.equalsIgnoreCase("")) {
                    editText2.setError(SingleStudy.this.activity.getResources().getString(R.string.enter_father_name));
                    editText2.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(SingleStudy.this.fProfession) && SingleStudy.this.fProfession.equalsIgnoreCase("")) {
                    Helper.enableErrorInTextview(textView3, SingleStudy.this.activity.getResources().getString(R.string.select_father_s_profession));
                    return;
                }
                if (SingleStudy.this.dob.equalsIgnoreCase("dob")) {
                    Helper.enableErrorInTextview(textView4, SingleStudy.this.activity.getResources().getString(R.string.select_dob));
                    return;
                }
                if (TextUtils.isEmpty(SingleStudy.this.permanentAddress) && SingleStudy.this.permanentAddress.equalsIgnoreCase("")) {
                    editText3.setError(SingleStudy.this.activity.getResources().getString(R.string.enter_permanent_address));
                    editText3.requestFocus();
                    return;
                }
                if (SingleStudy.this.stateSpinner.getText().toString().equalsIgnoreCase("state")) {
                    Helper.enableErrorInTextview(textView6, SingleStudy.this.activity.getResources().getString(R.string.select_state));
                    return;
                }
                if (SingleStudy.this.citySpinner.getText().toString().equalsIgnoreCase("city")) {
                    Helper.enableErrorInTextview(textView7, SingleStudy.this.activity.getResources().getString(R.string.select_city));
                    return;
                }
                if (TextUtils.isEmpty(SingleStudy.this.studentMobile) && SingleStudy.this.studentMobile.equalsIgnoreCase("")) {
                    editText4.setError(SingleStudy.this.activity.getResources().getString(R.string.enter_mobile_number));
                    editText4.requestFocus();
                    return;
                }
                if (!Helper.checkMobileNumber(SingleStudy.this.studentMobile)) {
                    Helper.DataNotValid(editText4, 2, SingleStudy.this.getContext());
                    return;
                }
                if (TextUtils.isEmpty(SingleStudy.this.fatherMobile) && SingleStudy.this.fatherMobile.equalsIgnoreCase("")) {
                    editText5.setError(SingleStudy.this.activity.getResources().getString(R.string.enter_mobile_number));
                    editText5.requestFocus();
                    return;
                }
                if (!Helper.checkMobileNumber(SingleStudy.this.fatherMobile)) {
                    Helper.DataNotValid(editText5, 2, SingleStudy.this.getContext());
                    return;
                }
                if (TextUtils.isEmpty(SingleStudy.this.email) && SingleStudy.this.email.equalsIgnoreCase("")) {
                    editText6.setError(SingleStudy.this.activity.getResources().getString(R.string.enter_email_id));
                    editText6.requestFocus();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(SingleStudy.this.email).matches()) {
                    Helper.DataNotValid(editText6, 1, SingleStudy.this.getContext());
                } else {
                    SingleStudy.this.hitEnrollSubmitAPI();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$findEnrollPopViewIDS$8(View view) {
        imagepath = "";
        adharImhPath = "";
        this.activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$findEnrollPopViewIDS$9(View view) {
        this.activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hitEnrollSubmitAPI() {
        NetworkAPICall(API.API_COMPLETE_ENROLLMENT, "", true, false, false);
    }

    private void hit_api_to_get_country() {
        NetworkAPICall(API.API_COUNTRY, "", true, false, false);
    }

    @Override // com.appnew.android.Courses.Adapter.SingleStudyAdapter4.onButtonClicked4
    public void onTitleClicked4(TilesItem cards, List<TilesItem> tiles, int tilePos) {
        if ("1".equals("4") || "1".equals("5")) {
            Intent intent = new Intent(this.activity, (Class<?>) CourseActivity.class);
            intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY2);
            intent.putExtra(Const.COURSE_ID_MAIN, !parentCourseId.equalsIgnoreCase("") ? parentCourseId : this.cousedetail.getData().getCourseDetail().getId());
            intent.putExtra(Const.COURSE_PARENT_ID, "");
            intent.putExtra(Const.IS_COMBO, false);
            intent.putExtra("tile_id", cards.getId());
            intent.putExtra(Const.IS_CONTENT_COMBO, this.cousedetail.getData().getCourseDetail().getIs_combo());
            intent.putExtra(AnalyticsConstants.course_name, this.cousedetail.getData().getCourseDetail().getTitle());
            Helper.gotoActivity(intent, this.activity);
            return;
        }
        if ("1".equals("7")) {
            callAdapterDataTheme8(tiles, cards, tilePos);
        } else {
            callAdapterData(tiles, cards, tilePos);
        }
    }

    class StateCityAdapter extends RecyclerView.Adapter<MyViewHolder> {
        Context context;
        List<StatesCitiesData> countryArrayList;
        Dialog searchDialog;
        String searchType;

        public StateCityAdapter(Context context, List<StatesCitiesData> countryArrayList, String searchType, Dialog searchDialog) {
            this.context = context;
            this.countryArrayList = countryArrayList;
            this.searchType = searchType;
            this.searchDialog = searchDialog;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new MyViewHolder(LayoutInflater.from(this.context).inflate(R.layout.state_city_dialog_adapter_item, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(MyViewHolder myViewHolder, final int i) {
            final StatesCitiesData statesCitiesData = this.countryArrayList.get(i);
            myViewHolder.tvName.setText(statesCitiesData.getName());
            myViewHolder.tvName.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.SingleStudy$StateCityAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(statesCitiesData, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(StatesCitiesData statesCitiesData, View view) {
            Dialog dialog = this.searchDialog;
            if (dialog != null) {
                dialog.dismiss();
            }
            String str = this.searchType;
            str.hashCode();
            switch (str) {
                case "1":
                    SingleStudy.this.onStateCityClick(this.searchType, statesCitiesData);
                    break;
                case "2":
                    SingleStudy.this.onStateCityClick(this.searchType, statesCitiesData);
                    break;
                case "3":
                    SingleStudy.this.onStateCityClick(this.searchType, statesCitiesData);
                    break;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.countryArrayList.size();
        }

        public void filterCountryList(List<StatesCitiesData> newCountryArrayList) {
            this.countryArrayList = newCountryArrayList;
            notifyDataSetChanged();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tvName;

            public MyViewHolder(View itemView) {
                super(itemView);
                this.tvName = (TextView) itemView.findViewById(R.id.nameTv);
            }
        }
    }

    public void onStateCityClick(String searchType, StatesCitiesData country) {
        if (searchType.equalsIgnoreCase("3")) {
            if (country.getName().equals(this.countryindex)) {
                return;
            }
            for (StatesCitiesData statesCitiesData : this.countries.getData()) {
                if (statesCitiesData.getName().equals(country.getName())) {
                    this.countryindex = country.getName();
                    this.SelectedCountryid = statesCitiesData.getId();
                    this.countrySpinner.setText(country.getName());
                    this.citySpinner.setText(this.activity.getResources().getString(R.string.city));
                    this.stateSpinner.setText(this.activity.getResources().getString(R.string.state));
                    hit_api_to_get_state();
                    return;
                }
            }
            return;
        }
        if (searchType.equalsIgnoreCase("2")) {
            if (country.getName().equals(this.cityindex)) {
                return;
            }
            for (StatesCitiesData statesCitiesData2 : this.cities.getData()) {
                if (statesCitiesData2.getName().equals(country.getName())) {
                    this.cityindex = country.getName();
                    this.SelectedCityid = statesCitiesData2.getId();
                    this.citySpinner.setText(country.getName());
                    return;
                }
            }
            return;
        }
        if (!searchType.equalsIgnoreCase("1") || country.getName().equals(this.stateindex)) {
            return;
        }
        for (StatesCitiesData statesCitiesData3 : this.states.getData()) {
            if (statesCitiesData3.getName().equals(country.getName())) {
                this.stateindex = country.getName();
                this.SelectedStateid = statesCitiesData3.getId();
                this.stateSpinner.setText(country.getName());
                this.citySpinner.setText(this.activity.getResources().getString(R.string.city));
                hit_api_to_get_city();
                return;
            }
        }
    }

    private void hit_api_to_get_city() {
        NetworkAPICall(API.API_CITY, "", true, false, false);
    }

    private void hit_api_to_get_state() {
        NetworkAPICall(API.API_STATE, "", false, false, false);
    }

    public void filterList(String searchType, StatesCities countryArrayList) {
        final Dialog dialog = new Dialog(this.context);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
        dialog.setContentView(R.layout.state_city_dialog);
        dialog.setCancelable(true);
        this.etSearch = (EditText) dialog.findViewById(R.id.et_search);
        if (searchType.equalsIgnoreCase("1")) {
            this.etSearch.setHint("Search State");
        } else if (searchType.equalsIgnoreCase("2")) {
            this.etSearch.setHint("Search City");
        } else if (searchType.equalsIgnoreCase("3")) {
            this.etSearch.setHint("Search Country");
        }
        this.ivClearSearch = (ImageView) dialog.findViewById(R.id.iv_clear_search);
        TextView textView = (TextView) dialog.findViewById(R.id.tv_cancel);
        this.ivClearSearch.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.SingleStudy$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$filterList$10(view);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.SingleStudy$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.cancel();
            }
        });
        RecyclerView recyclerView = (RecyclerView) dialog.findViewById(R.id.search_recyclerview);
        this.searchRecyclerview = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.searchRecyclerview.setLayoutManager(new LinearLayoutManager(this.context));
        this.stateCityAdapter = new StateCityAdapter(this.context, countryArrayList.getData(), searchType, dialog);
        Log.e("TAG_APP", "SuccessCallBack: 4172");
        this.searchRecyclerview.setAdapter(this.stateCityAdapter);
        textWatcher(searchType);
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$filterList$10(View view) {
        this.etSearch.setText("");
    }

    public void textWatcher(final String searchType) {
        this.etSearch.addTextChangedListener(new TextWatcher() { // from class: com.appnew.android.Courses.Fragment.SingleStudy.24
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    SingleStudy.this.ivClearSearch.setVisibility(0);
                } else {
                    SingleStudy.this.ivClearSearch.setVisibility(8);
                }
                SingleStudy.this.filter(editable.toString(), searchType);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void filter(String text, String searchType) {
        this.statesCitiesArrayList.clear();
        if (searchType.equalsIgnoreCase("1")) {
            for (StatesCitiesData statesCitiesData : this.states.getData()) {
                if (statesCitiesData.getName().toLowerCase().contains(text.toLowerCase())) {
                    this.statesCitiesArrayList.add(statesCitiesData);
                }
            }
        } else if (searchType.equalsIgnoreCase("2")) {
            for (StatesCitiesData statesCitiesData2 : this.cities.getData()) {
                if (statesCitiesData2.getName().toLowerCase().contains(text.toLowerCase())) {
                    this.statesCitiesArrayList.add(statesCitiesData2);
                }
            }
        } else if (searchType.equalsIgnoreCase("3")) {
            for (StatesCitiesData statesCitiesData3 : this.countries.getData()) {
                if (statesCitiesData3.getName().toLowerCase().contains(text.toLowerCase())) {
                    this.statesCitiesArrayList.add(statesCitiesData3);
                }
            }
        }
        if (!this.statesCitiesArrayList.isEmpty()) {
            this.searchRecyclerview.setVisibility(0);
            this.stateCityAdapter.filterCountryList(this.statesCitiesArrayList);
        } else {
            this.searchRecyclerview.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getProfessioData(RadioButton rb1, RadioButton rb2, RadioButton rb3) {
        if (rb1.isChecked()) {
            return rb1.getText().toString().trim();
        }
        if (rb2.isChecked()) {
            return rb2.getText().toString().trim();
        }
        if (rb3.isChecked()) {
            return rb3.getText().toString().trim();
        }
        return "";
    }

    private EncryptionData getEncryptedData() {
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setPhoto(imagepath);
        encryptionData.setAdhaar(adharImhPath);
        encryptionData.setName(this.studentName);
        encryptionData.setProfession(this.sProfession);
        encryptionData.setFather_name(this.fatherName);
        encryptionData.setFather_profession(this.fProfession);
        encryptionData.setDob(this.dob);
        encryptionData.setP_address(this.permanentAddress);
        encryptionData.setState(this.stateSpinner.getText().toString().trim());
        encryptionData.setCity(this.citySpinner.getText().toString().trim());
        encryptionData.setPincode("");
        encryptionData.setEmail(this.email);
        encryptionData.setMobile(this.studentMobile);
        encryptionData.setFather_mobile(this.fatherMobile);
        return encryptionData;
    }

    public void openDatePickerDialog(Context context, final TextView dobTV, final Calendar c2, TextView errorText) {
        Helper.enableErrorInTextview(errorText, null);
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() { // from class: com.appnew.android.Courses.Fragment.SingleStudy.25
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                dobTV.setText(new StringBuilder().append(dayOfMonth).append(MqttTopic.TOPIC_LEVEL_SEPARATOR).append(monthOfYear + 1).append(MqttTopic.TOPIC_LEVEL_SEPARATOR).append(year).append(" "));
                c2.set(1, year);
                c2.set(2, monthOfYear);
                c2.set(5, dayOfMonth);
            }
        }, c2.get(1), c2.get(2), c2.get(5));
        datePickerDialog.getDatePicker().setMaxDate(Calendar.getInstance().getTimeInMillis());
        datePickerDialog.show();
    }

    public static void setUserAndAdharImage(String imgpath) {
        if (imgpath != null && !TextUtils.isEmpty(imgpath)) {
            String string = SharedPreference.getInstance().getString(Const.FORWHAT);
            if (!TextUtils.isEmpty(string) && string.equalsIgnoreCase(STUDENT_IMAGE) && userImage != null) {
                imagepath = imgpath;
                Glide.with(_context).load(imgpath).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.course_placeholder)).into(userImage);
                return;
            } else {
                if (TextUtils.isEmpty(string) || !string.equalsIgnoreCase(AADHAR_IMAGE) || adharImage == null) {
                    return;
                }
                adharImhPath = imgpath;
                Glide.with(_context).load(imgpath).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.course_placeholder)).into(adharImage);
                return;
            }
        }
        Helper.showToast(_context, "Image path not found", 0);
    }

    public void getDueEmi(String courseId, String is_skip) {
        final DueEmiTable dueEmiData = this.utkashRoom.getDueEmi().getDueEmiData(courseId);
        Log.d("TAGEMIPAY", "getDueEmi: " + new Gson().toJson(dueEmiData) + "buttonLow: " + this.buttonLow.getVisibility());
        if (dueEmiData != null) {
            this.buttonLow.setVisibility(8);
            this.dueEmiLayout.setVisibility(0);
            this.txtTitle.setText("Your next EMI due on " + Helper.getdate(Long.parseLong(String.valueOf(Long.parseLong(dueEmiData.getExpiry_date()) * 1000))));
            this.payEmi.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.SingleStudy$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$getDueEmi$12(dueEmiData, view);
                }
            });
            return;
        }
        if (is_skip == null || !is_skip.equalsIgnoreCase("1")) {
            if ("1".equalsIgnoreCase("5") || this.cousedetail.getData().getCourseDetail().getCat_type().equalsIgnoreCase("3")) {
                this.buttonLow.setVisibility(8);
            } else {
                this.buttonLow.setVisibility(0);
            }
            this.dueEmiLayout.setVisibility(8);
            return;
        }
        this.buttonLow.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDueEmi$12(DueEmiTable dueEmiTable, View view) {
        Intent intent = new Intent(this.activity, (Class<?>) InstallmentDetailActivity.class);
        intent.putExtra("order_data", dueEmiTable);
        intent.putExtra("fromWhere", Const.DueEmi);
        intent.putExtra("invoiceUrl", dueEmiTable.getUrl());
        intent.putExtra("type", Const.Installment);
        intent.putExtra("description_img", this.cousedetail.getData().getCourseDetail().getDescHeaderImage());
        this.activity.startActivity(intent);
    }

    private List<TilesItem> getTileFortheme8(List<TilesItem> tiles) {
        ArrayList arrayList = new ArrayList();
        if (tiles != null) {
            for (TilesItem tilesItem : tiles) {
                if (!tilesItem.getType().equalsIgnoreCase(Const.OVERVIEW) && !tilesItem.getType().equalsIgnoreCase(Const.COMBO) && !tilesItem.getType().equalsIgnoreCase(Const.FAQ)) {
                    arrayList.add(tilesItem);
                }
            }
        }
        return arrayList;
    }

    private void hitApiForTest() {
        this.is_test_data = true;
        CourseDetail courseDetail = this.cousedetail;
        if (courseDetail != null && courseDetail.getData() != null && this.cousedetail.getData().getTiles() != null && this.cousedetail.getData().getTiles().size() > 0) {
            Iterator<TilesItem> it = this.cousedetail.getData().getTiles().iterator();
            while (true) {
                if (it.hasNext()) {
                    TilesItem next = it.next();
                    if (next.getType().equalsIgnoreCase(Const.TEST)) {
                        this.tileIdAPI = next.getId();
                        this.tileTypeAPI = next.getType();
                        this.typeApi = this.tileTypeAPI + this.tileIdAPI;
                        break;
                    }
                } else {
                    this.tileTypeAPI = "content";
                    this.tileIdAPI = "12";
                    this.typeApi = "content12";
                    break;
                }
            }
            this.revertAPI = "1#3#0#0";
            this.mainCourseId = this.cousedetail.getData().getCourseDetail().getId();
            parentCourseId = "";
            NetworkAPICall(API.API_GET_MASTER_DATA, "", true, false, false);
            return;
        }
        Toast.makeText(this.activity, "Scholarship Test is not available", 0).show();
    }

    private void pushEventForFreeCourse() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_id", AnalyticHelper.INSTANCE.getUserId());
        map.put(AnalyticsConstants.user_name, AnalyticHelper.INSTANCE.getUserName());
        map.put("course_id", this.cousedetail.getData().getCourseDetail().getId());
        map.put(AnalyticsConstants.course_name, this.cousedetail.getData().getCourseDetail().getTitle());
        AnalyticEvents.INSTANCE.pushEvents(this.activity, AnalyticsConstants.FREE_USER, map);
    }

    private void showData(CourseDetailData courseDetails) {
        boolean z;
        this.studyCourseRV.setVisibility(8);
        this.no_data_found_RL.setVisibility(8);
        this.view_header.setVisibility(0);
        String descHeaderImage = courseDetails.getDescHeaderImage();
        String title = courseDetails.getTitle();
        String validity = courseDetails.getValidity();
        String cat_type = courseDetails.getCat_type();
        String hide_validity = courseDetails.getHide_validity();
        String title2 = courseDetails.getAuthor().getTitle();
        if (descHeaderImage != null) {
            BottomSetting bottomSetting = this.bottomSetting;
            if (bottomSetting != null && bottomSetting.getLayout_type() != null && this.bottomSetting.getLayout_type().equals("1")) {
                Activity activity = this.activity;
                Helper.setThumbnailImage(activity, descHeaderImage, activity.getResources().getDrawable(R.mipmap.square_placeholder), this.courseImagebg);
            } else {
                Activity activity2 = this.activity;
                Helper.setThumbnailImage(activity2, descHeaderImage, activity2.getResources().getDrawable(R.mipmap.square_placeholder_new), this.courseImagebg);
            }
            CouponPojo couponPojo = this.couponPojo;
            if (couponPojo == null || couponPojo.getAvailable() == null || this.couponPojo.getAvailable().size() <= 0) {
                z = false;
            } else {
                z = false;
                for (Available available : this.couponPojo.getAvailable()) {
                    if (available.getCourses().size() > 0) {
                        Iterator<CoursesCoupon> it = available.getCourses().iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (this.mainCourseId.equalsIgnoreCase(it.next().getId()) && Long.parseLong(available.getEnd()) * 1000 > Calendar.getInstance().getTimeInMillis()) {
                                    String coupon_value = available.getCoupon_value();
                                    String coupon_type = available.getCoupon_type();
                                    if (!TextUtils.isEmpty(coupon_value) && Integer.parseInt(coupon_value) > 0) {
                                        z = true;
                                    }
                                    if (coupon_type.equalsIgnoreCase("1")) {
                                        this.scholarshipCouponTV.setText("You will get " + this.activity.getResources().getString(R.string.rupees) + coupon_value + " scholarship if you will enroll this course.");
                                    } else {
                                        this.scholarshipCouponTV.setText("You will get " + coupon_value + "% scholarship if you will enroll this course.");
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (z) {
                this.ll_scholorship_discount.setVisibility(0);
            } else {
                this.ll_scholorship_discount.setVisibility(8);
            }
            this.coursename.setText(title);
            this.validityTV.setText(validity);
            this.no_data_found_RL_Header.setVisibility(0);
            this.ll_compat.setVisibility(0);
            this.tileRv.setVisibility(8);
            this.validityTV.setText(this.activity.getResources().getString(R.string.validity_) + validity);
            if (!GenericUtils.isEmpty(validity)) {
                if (cat_type != null && cat_type.equalsIgnoreCase("3")) {
                    this.validityTV.setVisibility(4);
                } else if (hide_validity.equalsIgnoreCase("1")) {
                    this.validityTV.setVisibility(8);
                } else {
                    this.validityTV.setVisibility(0);
                }
            } else {
                this.validityTV.setVisibility(8);
            }
            if (!GenericUtils.isEmpty(title2)) {
                this.authorname.setText(this.activity.getResources().getString(R.string.by) + title2);
                return;
            } else {
                this.authorname.setText(this.activity.getResources().getString(R.string.by) + this.activity.getResources().getString(R.string.app_name));
                return;
            }
        }
        this.no_data_found_RL.setVisibility(0);
        this.view_header.setVisibility(8);
    }

    public static boolean hasValidTiles(CourseDetail courseDetail) {
        return (courseDetail == null || courseDetail.getData() == null || courseDetail.getData().getTiles() == null || courseDetail.getData().getTiles().isEmpty()) ? false : true;
    }
}
