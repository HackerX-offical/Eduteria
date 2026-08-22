package com.appnew.android.Courses.Fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.BuildConfig;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter;
import com.appnew.android.Download.Audio.AudioPlayerService;
import com.appnew.android.DownloadServices.VideoDownloadService;
import com.appnew.android.Model.BottomSetting;
import com.appnew.android.Model.COURSEDETAIL.CourseDetail;
import com.appnew.android.Model.COURSEDETAIL.CourseDetailData;
import com.appnew.android.Model.COURSEDETAIL.TilesItem;
import com.appnew.android.Model.Courses.ExamPrepItem;
import com.appnew.android.Model.Courses.Lists;
import com.appnew.android.Model.Courses.quiz.Quiz_Basic_Info;
import com.appnew.android.Model.DueEmiTable;
import com.appnew.android.Model.Video;
import com.appnew.android.Model.ZoomTitle;
import com.appnew.android.Notification.Notification;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Payment.PurchaseActivity;
import com.appnew.android.PurchaseHistory.activity.InstallmentDetailActivity;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Theme.DashboardActivityTheme1;
import com.appnew.android.Theme.DashboardActivityTheme8;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.GenericUtils;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.MainFragment;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.PreferencesUtil;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Webview.RevisionActivity;
import com.appnew.android.Webview.SearchRevisionVideosActivity;
import com.appnew.android.cleverTap.AnalyticHelper;
import com.appnew.android.helpChat.HelpQueryActivity;
import com.appnew.android.helpChat.HelpSupportActivity;
import com.appnew.android.helpChat.model.HelpSupportChatModel;
import com.appnew.android.home.Constants;
import com.appnew.android.player.music_player.MusicService;
import com.appnew.android.table.VideosDownload;
import com.bumptech.glide.Glide;
import com.eduteria.app.app.R;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tv9news.utils.helpers.AnalyticEvents;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Timer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class ExamPrepLayer2 extends MainFragment implements AdapterView.OnItemSelectedListener {
    public static ArrayList<Video> actual_videolist = new ArrayList<>();
    boolean SHOW_ALL_TILE;
    Activity activity;
    FloatingActionButton addRelatedReferenceBtn;
    FloatingActionButton addRelatedVideoBtn;
    FloatingActionButton addRevisionBtn;
    FloatingActionButton addSupport;
    FloatingActionMenu allResourceAddMenu;
    BottomSetting bottomSetting;
    RelativeLayout buttonLow;
    TextView buyNowBtn;
    ArrayList<TilesItem> cardsArrayList;
    String catType;
    public String contentType;
    public String contentTypeTile;
    RelativeLayout dropDown_filter;
    RelativeLayout dueEmiLayout;
    ExamPrepLayer3Adapter examPrepLayer3Adapter;
    RecyclerView examPrepLayerRV;
    com.google.android.material.floatingactionbutton.FloatingActionButton floatGoToTop;
    LinearLayoutManager linearLayoutManager;
    Lists list;
    Lists listSubject;
    HashMap<String, Boolean> mp;
    TextView mrpCutTV;
    Button myLibBtn;
    Timer myTimer;
    private NestedScrollView nestedScrollView;
    RelativeLayout no_data_found_RL;
    ProgressBar paginationLoader;
    FrameLayout parentLL;
    TextView payEmi;
    ExamPrepItem prevexamPrepItem;
    TextView price;
    LinearLayout priceLL;
    ProgressBar progressBarAll;
    ArrayList<Quiz_Basic_Info> quizBasicInfoArrayList;
    String revertAPI;
    CourseDetail singleStudy;
    Spinner spinner;
    TextView spinnerTitle;
    String tileIdAPI;
    TileItemsAdapter tileItemsAdapter;
    RecyclerView tileRv;
    String tileTypeAPI;
    public String title;
    String total;
    TextView tvGstDesc;
    TextView txtTitle;
    public UtkashRoom utkashRoom;
    ArrayList<Video> videoArrayList;
    public String search_title = "";
    public String tile_id = "";
    String file_type_attributes = "";
    boolean ApiHit = true;
    private String pre_txtid = "";
    ArrayList<ZoomTitle> spinnerList = new ArrayList<>();
    ArrayList<String> spinnerList1 = new ArrayList<>();
    private ArrayList<Video> seleced_tile_list = new ArrayList<>();
    private ArrayList<Video> custom_video_list = new ArrayList<>();
    private ArrayList<Video> custom_link_list = new ArrayList<>();
    boolean isCombo = false;
    String skipType = "0";
    boolean isApiHit = false;
    String is_purchase = "";
    String tabTileVisibility = "";
    boolean isApiHitForUpdatingTheData = false;
    private int mPage = 1;
    boolean paginationStatus = false;
    private boolean isPaginationAvailable = true;
    String revertApiFalse = "";
    boolean isAddToMyLibrary = false;
    public UtkashRoom myDBClass = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
    ArrayList<Video> searchList = new ArrayList<>();
    String searchText = "";
    String newsearchText = "";
    boolean isUserSearchSomething = true;
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.appnew.android.Courses.Fragment.ExamPrepLayer2.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Helper.dismissProgressDialog();
        }
    };
    private BroadcastReceiver videoDownloadReceiver = new BroadcastReceiver() { // from class: com.appnew.android.Courses.Fragment.ExamPrepLayer2.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("result", -1);
            String stringExtra = intent.getStringExtra("video_time");
            String stringExtra2 = intent.getStringExtra("resourceId");
            if (intExtra == 1) {
                for (Video video : ExamPrepLayer2.this.videoArrayList) {
                    if (video.getId().equalsIgnoreCase(stringExtra2)) {
                        video.setVideo_download(true);
                        video.setVideo_status("Downloaded");
                        video.setVideotime(stringExtra);
                        ExamPrepLayer2.this.examPrepLayer3Adapter.notifyDataSetChanged();
                        return;
                    }
                }
            }
        }
    };
    private BroadcastReceiver audioServiceReceiver = new BroadcastReceiver() { // from class: com.appnew.android.Courses.Fragment.ExamPrepLayer2.4
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean booleanExtra = intent.getBooleanExtra("result", false);
            String stringExtra = intent.getStringExtra("resourceId");
            if (booleanExtra) {
                Iterator<Video> it = ExamPrepLayer2.this.videoArrayList.iterator();
                while (it.hasNext()) {
                    if (it.next().getId().equalsIgnoreCase(stringExtra)) {
                        ExamPrepLayer2.this.examPrepLayer3Adapter.notifyDataSetChanged();
                        return;
                    }
                }
            }
        }
    };
    private BroadcastReceiver musicServiceReceiver = new BroadcastReceiver() { // from class: com.appnew.android.Courses.Fragment.ExamPrepLayer2.5
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean booleanExtra = intent.getBooleanExtra("result", false);
            intent.getStringExtra("resourceId");
            if (booleanExtra) {
                ExamPrepLayer2.this.examPrepLayer3Adapter.notifyDataSetChanged();
            }
        }
    };
    ArrayList<Video> videoArrayListPagination = new ArrayList<>();
    int currentIndex = -1;
    String fileType = "0";

    static /* synthetic */ void lambda$initView$9(View view) {
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> parent) {
    }

    public static ExamPrepLayer2 newInstance(ExamPrepItem examPrepItem, Lists main_id, Lists listSubject, String contentType, String title, String totals, CourseDetail singleStudy, boolean isCombo, String tileIdAPI, String tileTypeAPI, String revertAPI, String serach_title, String tabTileVisibility) {
        ExamPrepLayer2 examPrepLayer2 = new ExamPrepLayer2();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Const.SINGLE_STUDY_DATA, singleStudy);
        bundle.putSerializable(Const.EXAMPREP, examPrepItem);
        bundle.putSerializable("list", main_id);
        bundle.putSerializable(Const.LIST_SUBJECT, listSubject);
        bundle.putSerializable(Const.TEST_TYPE, totals);
        bundle.putString("title", title);
        bundle.putString("content_type", contentType);
        bundle.putBoolean(Const.IS_COMBO, isCombo);
        bundle.putString("tile_id", tileIdAPI);
        bundle.putString(Const.TILE_TYPE, tileTypeAPI);
        bundle.putString(Const.REVERT_API, revertAPI);
        bundle.putString("search_title", serach_title);
        bundle.putString(Const.TAB_TILE_VISIBILITY, tabTileVisibility);
        examPrepLayer2.setArguments(bundle);
        return examPrepLayer2;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_exam_prep_layer2, container, false);
    }

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        this.activity = activity;
        this.utkashRoom = UtkashRoom.getAppDatabase(activity);
        Constants.revison_set = false;
        Constants.REFRESHPAGE = "false";
        Constants.pos = "";
        this.quizBasicInfoArrayList = new ArrayList<>();
        this.videoArrayList = new ArrayList<>();
        if (getArguments() != null) {
            this.isCombo = getArguments().getBoolean(Const.IS_COMBO);
            this.list = (Lists) getArguments().getSerializable("list");
            if (getArguments().getSerializable(Const.TEST_TYPE) != null) {
                this.total = getArguments().getString(Const.TEST_TYPE);
            } else {
                this.total = "0";
            }
            this.listSubject = (Lists) getArguments().getSerializable(Const.LIST_SUBJECT);
            this.contentType = getArguments().getString("content_type");
            this.search_title = getArguments().getString("search_title");
            this.title = getArguments().getString("title");
            this.tileIdAPI = getArguments().getString("tile_id");
            this.tileTypeAPI = getArguments().getString(Const.TILE_TYPE);
            String string = getArguments().getString(Const.REVERT_API);
            this.revertAPI = string;
            try {
                this.skipType = string.split("\\#")[1];
            } catch (Exception unused) {
                this.skipType = "0";
            }
            this.prevexamPrepItem = (ExamPrepItem) getArguments().getSerializable(Const.EXAMPREP);
            this.tabTileVisibility = getArguments().getString(Const.TAB_TILE_VISIBILITY);
            CourseDetail courseDetail = (CourseDetail) getArguments().getSerializable(Const.SINGLE_STUDY_DATA);
            this.singleStudy = courseDetail;
            if (courseDetail == null) {
                this.singleStudy = new CourseDetail();
            } else {
                this.is_purchase = courseDetail.getData().getCourseDetail().getIsPurchased();
            }
        }
    }

    public void getDueEmi(String courseId, String is_skip) {
        final DueEmiTable dueEmiData = this.utkashRoom.getDueEmi().getDueEmiData(courseId);
        if (dueEmiData != null) {
            this.buttonLow.setVisibility(8);
            this.dueEmiLayout.setVisibility(0);
            this.txtTitle.setText("Your next EMI due on " + getdate(Long.parseLong(String.valueOf(Long.parseLong(dueEmiData.getExpiry_date()) * 1000))));
            this.payEmi.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.ExamPrepLayer2$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$getDueEmi$0(dueEmiData, view);
                }
            });
            return;
        }
        if ((is_skip != null && is_skip.equalsIgnoreCase("1")) || "1".equalsIgnoreCase("5")) {
            this.buttonLow.setVisibility(8);
        } else {
            CourseDetail courseDetail = this.singleStudy;
            if (courseDetail != null && courseDetail.getData() != null && this.singleStudy.getData().getCourseDetail() != null && this.singleStudy.getData().getCourseDetail().getCat_type().equalsIgnoreCase("3")) {
                this.buttonLow.setVisibility(8);
            } else {
                this.buttonLow.setVisibility(0);
            }
        }
        this.dueEmiLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDueEmi$0(DueEmiTable dueEmiTable, View view) {
        Intent intent = new Intent(this.activity, (Class<?>) InstallmentDetailActivity.class);
        intent.putExtra("order_data", dueEmiTable);
        intent.putExtra("fromWhere", Const.DueEmi);
        intent.putExtra("invoiceUrl", dueEmiTable.getUrl());
        intent.putExtra("description_img", this.singleStudy.getData().getCourseDetail().getDescHeaderImage());
        intent.putExtra("type", Const.Installment);
        this.activity.startActivity(intent);
    }

    private String getdate(long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(14, TimeZone.getDefault().getOffset(calendar.getTimeInMillis()));
        return new SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(new Date(Long.parseLong(String.valueOf(timestamp))));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((CourseActivity) this.activity).setToolbarTitle(TextUtils.isEmpty(this.list.getTitle()) ? this.singleStudy.getData().getCourseDetail().getTitle() : this.list.getTitle());
        ((CourseActivity) this.activity).filterIV.setVisibility(8);
        if (Constants.is_Show_Search.equalsIgnoreCase("1")) {
            ((CourseActivity) this.activity).searchIV.setVisibility(0);
        }
        if (BuildConfig.FLAVOR.equalsIgnoreCase("rankersGurukuls")) {
            ((CourseActivity) this.activity).iv_whatsapp.setVisibility(0);
            ((CourseActivity) this.activity).notificationLL.setVisibility(0);
        } else {
            ((CourseActivity) this.activity).iv_whatsapp.setVisibility(8);
            ((CourseActivity) this.activity).notificationLL.setVisibility(8);
        }
        ((CourseActivity) this.activity).notificationLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Fragment.ExamPrepLayer2$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onViewCreated$1();
            }
        }));
        ((CourseActivity) this.activity).iv_whatsapp.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.ExamPrepLayer2$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$onViewCreated$2(view2);
            }
        });
        initView(view);
        if (BuildConfig.FLAVOR.equalsIgnoreCase("Kalirana") || BuildConfig.FLAVOR.equalsIgnoreCase("Lawlegends")) {
            this.SHOW_ALL_TILE = false;
        } else {
            this.SHOW_ALL_TILE = true;
        }
        if (!this.SHOW_ALL_TILE) {
            if (this.singleStudy.getData().getCourseDetail().getIsPurchased().equalsIgnoreCase("1")) {
                if (TextUtils.isEmpty(this.tile_id)) {
                    Iterator<TilesItem> it = this.singleStudy.getData().getTiles().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TilesItem next = it.next();
                        if (!next.getType().equalsIgnoreCase("content") && !next.getType().equalsIgnoreCase(Const.OVERVIEW)) {
                            this.tile_id = next.getId();
                            this.tileIdAPI = next.getId();
                            this.tileTypeAPI = next.getType();
                            this.ApiHit = false;
                            this.isApiHitForUpdatingTheData = false;
                            String str = next.getType() + next.getId();
                            this.contentTypeTile = str;
                            this.paginationStatus = false;
                            this.mPage = 1;
                            ((CourseActivity) this.activity).contentType = str;
                            break;
                        }
                    }
                }
            } else {
                this.tile_id = this.tileIdAPI;
                this.tileRv.setVisibility(8);
            }
            createTileData(this.tile_id);
        }
        hit_api_for_data(true);
        this.searchText = "";
        this.examPrepLayerRV.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.appnew.android.Courses.Fragment.ExamPrepLayer2.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                linearLayoutManager.getChildCount();
                linearLayoutManager.getItemCount();
                int iFindLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                linearLayoutManager.findLastVisibleItemPosition();
                if (dy > 0) {
                    if (ExamPrepLayer2.this.bottomSetting == null) {
                        if (ExamPrepLayer2.this.utkashRoom.getthemeSettingdao().is_setting_exit()) {
                            ExamPrepLayer2.this.bottomSetting = (BottomSetting) new Gson().fromJson(ExamPrepLayer2.this.utkashRoom.getthemeSettingdao().data().getBottom(), BottomSetting.class);
                        } else {
                            ExamPrepLayer2.this.allResourceAddMenu.setVisibility(8);
                        }
                    } else if (BuildConfig.FLAVOR.equalsIgnoreCase("mahendra")) {
                        if (dy > 460) {
                            ExamPrepLayer2.this.floatGoToTop.setVisibility(0);
                        }
                        ExamPrepLayer2.this.allResourceAddMenu.setVisibility(8);
                    } else if (ExamPrepLayer2.this.bottomSetting.getFloatingActionButtonLayer3().equalsIgnoreCase("1")) {
                        ExamPrepLayer2.this.allResourceAddMenu.setVisibility(0);
                    } else {
                        ExamPrepLayer2.this.allResourceAddMenu.setVisibility(8);
                    }
                } else if (dy < 0 && ExamPrepLayer2.this.singleStudy.getData().getCourseDetail().getIsPurchased().equalsIgnoreCase("1")) {
                    if (ExamPrepLayer2.this.bottomSetting == null) {
                        if (ExamPrepLayer2.this.utkashRoom.getthemeSettingdao().is_setting_exit()) {
                            ExamPrepLayer2.this.bottomSetting = (BottomSetting) new Gson().fromJson(ExamPrepLayer2.this.utkashRoom.getthemeSettingdao().data().getBottom(), BottomSetting.class);
                        } else {
                            ExamPrepLayer2.this.allResourceAddMenu.setVisibility(8);
                        }
                    } else {
                        ExamPrepLayer2.this.floatGoToTop.setVisibility(8);
                        if (!BuildConfig.FLAVOR.equalsIgnoreCase("mahendra") && ExamPrepLayer2.this.bottomSetting.getFloatingActionButtonLayer3().equalsIgnoreCase("1")) {
                            ExamPrepLayer2.this.allResourceAddMenu.setVisibility(0);
                        } else {
                            ExamPrepLayer2.this.allResourceAddMenu.setVisibility(8);
                        }
                    }
                }
                if (dy <= 0 || iFindLastCompletelyVisibleItemPosition != ExamPrepLayer2.this.examPrepLayer3Adapter.getItemCount() - 1 || ExamPrepLayer2.this.paginationLoader == null || ExamPrepLayer2.this.paginationLoader.isShown() || !ExamPrepLayer2.this.isPaginationAvailable) {
                    return;
                }
                ExamPrepLayer2.this.isUserSearchSomething = false;
                if (!ExamPrepLayer2.this.isUserSearchSomething) {
                    ExamPrepLayer2.this.searchText = "";
                }
                ExamPrepLayer2.this.isApiHitForUpdatingTheData = true;
                ExamPrepLayer2.this.paginationLoader.setVisibility(0);
                ExamPrepLayer2.this.mPage++;
                ExamPrepLayer2.this.paginationStatus = true;
                ExamPrepLayer2.this.hit_api_for_data(false);
                Log.d("TAG", "onScrolled:" + ExamPrepLayer2.this.mPage);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onViewCreated$1() {
        if (!Helper.isNetworkConnected(this.activity)) {
            Helper.showInternetToast(this.activity);
        }
        Helper.gotoActivity(this.activity, (Class<?>) Notification.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$2(View view) {
        Helper.openWhatsapp(this.activity);
    }

    private void createTileData(String tile_id) {
        this.tileRv.setVisibility(0);
        ArrayList<TilesItem> arrayList = new ArrayList<>();
        this.cardsArrayList = arrayList;
        if (this.SHOW_ALL_TILE) {
            arrayList.add(new TilesItem("0#0#0#0", "All", "0", "all", "", "", ""));
        }
        new ArrayList();
        for (int i = 0; i < this.singleStudy.getData().getTiles().size(); i++) {
            TilesItem tilesItem = this.singleStudy.getData().getTiles().get(i);
            if (tilesItem.getType().equalsIgnoreCase(Const.PDF) && tilesItem.getIsvisible().equalsIgnoreCase("false")) {
                tilesItem.setIsvisible("true");
            } else if (tilesItem.getType().equalsIgnoreCase(Const.PPT) && tilesItem.getIsvisible().equalsIgnoreCase("false")) {
                tilesItem.setIsvisible("true");
            } else if (tilesItem.getType().equalsIgnoreCase("video") && tilesItem.getIsvisible().equalsIgnoreCase("false")) {
                tilesItem.setIsvisible("true");
            } else if (tilesItem.getType().equalsIgnoreCase(Const.EPUB) && tilesItem.getIsvisible().equalsIgnoreCase("false")) {
                tilesItem.setIsvisible("true");
            } else if (tilesItem.getType().equalsIgnoreCase(Const.DOC) && tilesItem.getIsvisible().equalsIgnoreCase("false")) {
                tilesItem.setIsvisible("true");
            } else if (tilesItem.getType().equalsIgnoreCase("image") && tilesItem.getIsvisible().equalsIgnoreCase("false")) {
                tilesItem.setIsvisible("true");
            } else if (tilesItem.getType().equalsIgnoreCase(Const.CONCEPT) && tilesItem.getIsvisible().equalsIgnoreCase("false")) {
                tilesItem.setIsvisible("true");
            } else if (tilesItem.getType().equalsIgnoreCase("link") && tilesItem.getIsvisible().equalsIgnoreCase("false")) {
                tilesItem.setIsvisible("true");
            } else if (tilesItem.getType().equalsIgnoreCase(Const.TEST) && tilesItem.getIsvisible().equalsIgnoreCase("false")) {
                tilesItem.setIsvisible("true");
            } else if (tilesItem.getType().equalsIgnoreCase(Const.SUBJECTIVE_TEST) && tilesItem.getIsvisible().equalsIgnoreCase("false")) {
                tilesItem.setIsvisible("true");
            } else if (tilesItem.getType().equalsIgnoreCase(Const.Daily_assignment) && tilesItem.getIsvisible().equalsIgnoreCase("false")) {
                tilesItem.setIsvisible("true");
            } else if (tilesItem.getType().equalsIgnoreCase("audio") && tilesItem.getIsvisible().equalsIgnoreCase("false")) {
                tilesItem.setIsvisible("true");
            }
        }
        try {
            for (TilesItem tilesItem2 : this.singleStudy.getData().getTiles()) {
                if (!tilesItem2.getType().equalsIgnoreCase(Const.OVERVIEW) && !tilesItem2.getType().equalsIgnoreCase(Const.FAQ) && !tilesItem2.getType().equalsIgnoreCase("content") && !tilesItem2.getType().equalsIgnoreCase(Const.COMBO)) {
                    if (this.skipType.equalsIgnoreCase("0") || this.skipType.equalsIgnoreCase("1")) {
                        String id = this.list.getId() == null ? "0" : this.list.getId();
                        JSONArray jSONArray = new JSONObject(tilesItem2.getMeta()).getJSONArray("list");
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i2);
                            if (jSONObject.has("list")) {
                                JSONArray jSONArray2 = jSONObject.getJSONArray("list");
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= jSONArray2.length()) {
                                        break;
                                    }
                                    if (id.equals(jSONArray2.getJSONObject(i3).optString("id"))) {
                                        this.cardsArrayList.add(tilesItem2);
                                        break;
                                    }
                                    i3++;
                                }
                            }
                        }
                    } else if (this.skipType.equalsIgnoreCase("2")) {
                        String id2 = this.listSubject.getId() == null ? "0" : this.listSubject.getId();
                        JSONArray jSONArray3 = new JSONObject(tilesItem2.getMeta()).getJSONArray("list");
                        int i4 = 0;
                        while (true) {
                            if (i4 >= jSONArray3.length()) {
                                break;
                            }
                            if (id2.equals(jSONArray3.getJSONObject(i4).optString("id"))) {
                                this.cardsArrayList.add(tilesItem2);
                                break;
                            }
                            i4++;
                        }
                    } else if (tilesItem2.getIsvisible().equalsIgnoreCase("true")) {
                        this.cardsArrayList.add(tilesItem2);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.file_type_attributes = "0";
        if (TextUtils.isEmpty(this.contentTypeTile)) {
            this.contentTypeTile = this.cardsArrayList.get(0).getType() + this.cardsArrayList.get(0).getId();
        }
        this.tile_id = tile_id;
        if (this.tabTileVisibility.equals("1")) {
            this.tileRv.setVisibility(0);
        } else {
            this.tileRv.setVisibility(8);
        }
        TileItemsAdapter tileItemsAdapter = this.tileItemsAdapter;
        if (tileItemsAdapter == null) {
            this.tileItemsAdapter = new TileItemsAdapter(this.activity, this.cardsArrayList, this.tileRv);
            this.tileRv.setLayoutManager(new LinearLayoutManager(this.activity, 0, false));
            this.tileRv.setAdapter(this.tileItemsAdapter);
            this.tileRv.setNestedScrollingEnabled(false);
        } else {
            tileItemsAdapter.notifyDataSetChanged();
        }
        if ("1".equalsIgnoreCase("7")) {
            this.tileRv.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hit_api_for_data(boolean showProgress) {
        ExamPrepLayer2 examPrepLayer2;
        if (!Helper.isNetworkConnected(this.activity) || SharedPreference.getInstance().getHashMapdata(Const.API_UPDATE_VIDEO_VIEW) == null) {
            examPrepLayer2 = this;
        } else {
            examPrepLayer2 = this;
            examPrepLayer2.NetworkAPICall(API.user_video_view_data, this.contentType, false, false, false);
        }
        examPrepLayer2.NetworkAPICall(API.API_GET_MASTER_DATA, examPrepLayer2.contentType, showProgress, false, false);
    }

    private void initView(View view) {
        this.dropDown_filter = (RelativeLayout) view.findViewById(R.id.dropDown_filter);
        this.spinner = (Spinner) view.findViewById(R.id.spinner);
        this.spinnerTitle = (TextView) view.findViewById(R.id.spinnerTitle);
        this.spinner.setOnItemSelectedListener(this);
        this.progressBarAll = (ProgressBar) view.findViewById(R.id.progressBarAll);
        this.parentLL = (FrameLayout) view.findViewById(R.id.parentLL);
        this.tvGstDesc = (TextView) view.findViewById(R.id.tv_gstDesc);
        this.tileRv = (RecyclerView) view.findViewById(R.id.tileRv);
        this.examPrepLayerRV = (RecyclerView) view.findViewById(R.id.examPrepLayerRV);
        this.nestedScrollView = (NestedScrollView) view.findViewById(R.id.nested_scroll);
        this.mrpCutTV = (TextView) view.findViewById(R.id.mrpCutTV);
        this.price = (TextView) view.findViewById(R.id.priceTV);
        this.buyNowBtn = (TextView) view.findViewById(R.id.buyNowBtn);
        this.buttonLow = (RelativeLayout) view.findViewById(R.id.buttonLow);
        this.myLibBtn = (Button) view.findViewById(R.id.myLibBtn);
        this.priceLL = (LinearLayout) view.findViewById(R.id.priceLL);
        this.paginationLoader = (ProgressBar) view.findViewById(R.id.progressBar);
        this.allResourceAddMenu = (FloatingActionMenu) view.findViewById(R.id.allResourceAddMenu);
        this.floatGoToTop = (com.google.android.material.floatingactionbutton.FloatingActionButton) view.findViewById(R.id.floatGoToTop);
        if (this.utkashRoom.getthemeSettingdao().is_setting_exit()) {
            this.bottomSetting = (BottomSetting) new Gson().fromJson(this.utkashRoom.getthemeSettingdao().data().getBottom(), BottomSetting.class);
        }
        this.addRelatedVideoBtn = (FloatingActionButton) view.findViewById(R.id.addRelatedVideoBtn);
        this.addRevisionBtn = (FloatingActionButton) view.findViewById(R.id.addRevisionBtn);
        this.addSupport = (FloatingActionButton) view.findViewById(R.id.addSupport);
        this.addRelatedReferenceBtn = (FloatingActionButton) view.findViewById(R.id.addRelatedReferenceBtn);
        this.allResourceAddMenu.setClosedOnTouchOutside(true);
        this.no_data_found_RL = (RelativeLayout) view.findViewById(R.id.no_data_found_RL);
        this.dueEmiLayout = (RelativeLayout) view.findViewById(R.id.dueEmiLayout);
        this.txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        this.payEmi = (TextView) view.findViewById(R.id.payEmi);
        this.buyNowBtn.setText(SharedPreference.getInstance().getString(Const.ENROLL_NOW).equalsIgnoreCase("1") ? "Enroll Now" : this.activity.getResources().getString(R.string.buy_now));
        if (SharedPreference.getInstance().getBoolean(Const.IS_PAYMENT_DONE)) {
            Constants.IS_PURCHASED = "0";
            this.buttonLow.setVisibility(8);
            SharedPreference.getInstance().putBoolean(Const.SINGLE_STUDY, true);
        } else {
            CourseDetail courseDetail = this.singleStudy;
            if (courseDetail != null && courseDetail.getData().getCourseDetail() != null) {
                initButton(this.singleStudy.getData().getCourseDetail());
            } else {
                this.activity.finish();
            }
        }
        this.floatGoToTop.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.ExamPrepLayer2$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$initView$3(view2);
            }
        });
        this.allResourceAddMenu.setOnMenuButtonClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.ExamPrepLayer2$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$initView$4(view2);
            }
        });
        this.addRelatedReferenceBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.ExamPrepLayer2$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$initView$5(view2);
            }
        });
        this.addRevisionBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.ExamPrepLayer2$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$initView$6(view2);
            }
        });
        this.addSupport.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.ExamPrepLayer2$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$initView$7(view2);
            }
        });
        this.addRelatedVideoBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.ExamPrepLayer2$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$initView$8(view2);
            }
        });
        initButton(this.singleStudy.getData().getCourseDetail());
        if (this.buttonLow.getVisibility() == 0) {
            this.examPrepLayerRV.setPadding(0, 0, 0, Helper.getValueInDP(this.activity, 0));
        } else {
            this.examPrepLayerRV.setPadding(0, 0, 0, 0);
        }
        ((CourseActivity) this.activity).filterIV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.ExamPrepLayer2$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ExamPrepLayer2.lambda$initView$9(view2);
            }
        });
        this.buyNowBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.ExamPrepLayer2$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$initView$10(view2);
            }
        });
        this.myLibBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.ExamPrepLayer2$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$initView$11(view2);
            }
        });
        if (this.bottomSetting == null) {
            if (this.utkashRoom.getthemeSettingdao().is_setting_exit()) {
                this.bottomSetting = (BottomSetting) new Gson().fromJson(this.utkashRoom.getthemeSettingdao().data().getBottom(), BottomSetting.class);
                return;
            } else {
                this.allResourceAddMenu.setVisibility(8);
                return;
            }
        }
        if (BuildConfig.FLAVOR.equalsIgnoreCase("mahendra")) {
            this.allResourceAddMenu.setVisibility(8);
        } else if (this.bottomSetting.getFloatingActionButtonLayer3().equalsIgnoreCase("1")) {
            this.allResourceAddMenu.setVisibility(8);
        } else {
            this.allResourceAddMenu.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$3(View view) {
        this.examPrepLayerRV.smoothScrollBy(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$4(View view) {
        toggleIfInternetPresent(this.allResourceAddMenu, "add_resource");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$5(View view) {
        addRelatedWebRefsDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$6(View view) {
        addRevisionset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$7(View view) {
        getmyQuires();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$8(View view) {
        searchRelatedVideos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$10(View view) {
        if (this.buyNowBtn.getText().toString().equalsIgnoreCase(SharedPreference.getInstance().getString(Const.ENROLL_NOW).equalsIgnoreCase("1") ? "Enroll Now" : this.activity.getResources().getString(R.string.buy_now))) {
            CourseDetail courseDetail = this.singleStudy;
            if (courseDetail != null && courseDetail.getData() != null && this.singleStudy.getData().getCourseDetail() != null && this.singleStudy.getData().getCourseDetail().getCat_type().equalsIgnoreCase("5")) {
                Intent intent = new Intent(this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra("test_data", "");
                intent.putExtra(Const.SINGLE_STUDY, this.singleStudy);
                intent.putExtra("test_id", "0");
                intent.putExtra(Const.IS_BOOK, this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity_finish(intent, this.activity);
                return;
            }
            Intent intent2 = new Intent(this.activity, (Class<?>) PurchaseActivity.class);
            intent2.putExtra(Const.SINGLE_STUDY, this.singleStudy);
            CourseDetail courseDetail2 = this.singleStudy;
            if (courseDetail2 != null && courseDetail2.getData() != null && this.singleStudy.getData().getCourseDetail() != null && this.singleStudy.getData().getCourseDetail().getCat_type() != null) {
                intent2.putExtra(Const.IS_BOOK, this.singleStudy.getData().getCourseDetail().getCat_type());
            } else {
                intent2.putExtra(Const.IS_BOOK, this.catType);
            }
            intent2.putExtra(Const.DELIVERY_CHARGE, this.singleStudy.getData().getCourseDetail().getDelivery_charge());
            Helper.gotoActivity_finish(intent2, this.activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$11(View view) {
        if (this.isAddToMyLibrary) {
            return;
        }
        NetworkAPICall("https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction", "", true, false, false);
    }

    private void addRevisionset() {
        if (this.file_type_attributes.equalsIgnoreCase("0")) {
            if (this.videoArrayList.size() > 0) {
                toggleIfInternetPresent(this.allResourceAddMenu, "add_resource");
                Intent intent = new Intent(this.activity, (Class<?>) RevisionActivity.class);
                intent.putExtra("t_id", this.tile_id);
                intent.putExtra("s_list", this.videoArrayList);
                intent.putExtra("v_list", this.videoArrayList);
                intent.putExtra("f_id", this.videoArrayList.get(0).getId());
                intent.putExtra("c_id", this.singleStudy.getData().getCourseDetail().getId());
                intent.putExtra(Const.VIA, "main");
                Helper.gotoActivity(intent, this.activity);
                return;
            }
            Activity activity = this.activity;
            Toast.makeText(activity, activity.getResources().getString(R.string.atleast_one_item_must_be_available), 0).show();
            return;
        }
        if (this.seleced_tile_list.size() > 0) {
            toggleIfInternetPresent(this.allResourceAddMenu, "add_resource");
            Intent intent2 = new Intent(this.activity, (Class<?>) RevisionActivity.class);
            intent2.putExtra("t_id", this.tile_id);
            intent2.putExtra("s_list", this.seleced_tile_list);
            intent2.putExtra("v_list", this.videoArrayList);
            intent2.putExtra("f_id", this.seleced_tile_list.get(0).getId());
            intent2.putExtra("c_id", this.singleStudy.getData().getCourseDetail().getId());
            intent2.putExtra(Const.VIA, "main");
            Helper.gotoActivity(intent2, this.activity);
            return;
        }
        Activity activity2 = this.activity;
        Toast.makeText(activity2, activity2.getResources().getString(R.string.atleast_one_item_must_be_available), 0).show();
    }

    private void searchRelatedVideos() {
        if (this.file_type_attributes.equalsIgnoreCase("0")) {
            if (this.videoArrayList.size() > 0) {
                this.search_title = ((CourseActivity) this.activity).title;
                toggleIfInternetPresent(this.allResourceAddMenu, "add_resource");
                String str = ("https://www.youtube.com/results?search_query=" + this.search_title) + "&app=mobile";
                Intent intent = new Intent(this.activity, (Class<?>) SearchRevisionVideosActivity.class);
                intent.putExtra(Const.SEARCH_QUERY, str);
                intent.putExtra("resourceContext", "video");
                intent.putExtra(SDKConstants.PARAM_INTENT, "videos");
                intent.putExtra("t_id", this.tile_id);
                intent.putExtra("s_list", this.videoArrayList);
                intent.putExtra("v_list", this.videoArrayList);
                intent.putExtra("f_id", this.videoArrayList.get(0).getId());
                intent.putExtra("c_id", this.singleStudy.getData().getCourseDetail().getId());
                startActivity(intent);
                return;
            }
            Activity activity = this.activity;
            Toast.makeText(activity, activity.getResources().getString(R.string.atleast_one_item_must_be_available), 0).show();
            return;
        }
        if (this.seleced_tile_list.size() > 0) {
            this.search_title = ((CourseActivity) this.activity).title;
            toggleIfInternetPresent(this.allResourceAddMenu, "add_resource");
            String str2 = ("https://www.youtube.com/results?search_query=" + this.search_title) + "&app=mobile";
            Intent intent2 = new Intent(this.activity, (Class<?>) SearchRevisionVideosActivity.class);
            intent2.putExtra(Const.SEARCH_QUERY, str2);
            intent2.putExtra("resourceContext", "video");
            intent2.putExtra(SDKConstants.PARAM_INTENT, "videos");
            intent2.putExtra("t_id", this.tile_id);
            intent2.putExtra("s_list", this.seleced_tile_list);
            intent2.putExtra("v_list", this.videoArrayList);
            intent2.putExtra("f_id", this.seleced_tile_list.get(0).getId());
            intent2.putExtra("c_id", this.singleStudy.getData().getCourseDetail().getId());
            startActivity(intent2);
            return;
        }
        Activity activity2 = this.activity;
        Toast.makeText(activity2, activity2.getResources().getString(R.string.atleast_one_item_must_be_available), 0).show();
    }

    private void addRelatedWebRefsDialog() {
        if (this.file_type_attributes.equalsIgnoreCase("0")) {
            if (this.videoArrayList.size() > 0) {
                this.search_title = ((CourseActivity) this.activity).title;
                toggleIfInternetPresent(this.allResourceAddMenu, "add_resource");
                String str = "https://www.google.com/search?q=" + this.search_title;
                Intent intent = new Intent(this.activity, (Class<?>) SearchRevisionVideosActivity.class);
                intent.putExtra(Const.SEARCH_QUERY, str);
                intent.putExtra("resourceContext", AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB);
                intent.putExtra(SDKConstants.PARAM_INTENT, "webref");
                intent.putExtra("t_id", this.tile_id);
                intent.putExtra("s_list", this.videoArrayList);
                intent.putExtra("v_list", this.videoArrayList);
                intent.putExtra("f_id", this.videoArrayList.get(0).getId());
                intent.putExtra("c_id", this.singleStudy.getData().getCourseDetail().getId());
                startActivity(intent);
                return;
            }
            Activity activity = this.activity;
            Toast.makeText(activity, activity.getResources().getString(R.string.atleast_one_item_must_be_available), 0).show();
            return;
        }
        if (this.seleced_tile_list.size() > 0) {
            this.search_title = ((CourseActivity) this.activity).title;
            toggleIfInternetPresent(this.allResourceAddMenu, "add_resource");
            String str2 = "https://www.google.com/search?q=" + this.search_title;
            Intent intent2 = new Intent(this.activity, (Class<?>) SearchRevisionVideosActivity.class);
            intent2.putExtra(Const.SEARCH_QUERY, str2);
            intent2.putExtra("resourceContext", AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB);
            intent2.putExtra(SDKConstants.PARAM_INTENT, "webref");
            intent2.putExtra("t_id", this.tile_id);
            intent2.putExtra("s_list", this.seleced_tile_list);
            intent2.putExtra("v_list", this.videoArrayList);
            intent2.putExtra("f_id", this.seleced_tile_list.get(0).getId());
            intent2.putExtra("c_id", this.singleStudy.getData().getCourseDetail().getId());
            startActivity(intent2);
            return;
        }
        Activity activity2 = this.activity;
        Toast.makeText(activity2, activity2.getResources().getString(R.string.atleast_one_item_must_be_available), 0).show();
    }

    private void toggleIfInternetPresent(FloatingActionMenu floatingActionMenu, String dialogToShow) {
        if (!floatingActionMenu.isOpened()) {
            if (!Helper.isNetworkConnected(this.activity)) {
                showNoNetDialog(dialogToShow);
                return;
            } else {
                floatingActionMenu.toggle(true);
                return;
            }
        }
        floatingActionMenu.toggle(true);
    }

    public void showNoNetDialog(String action) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.activity, android.R.style.Theme.DeviceDefault.Light.Dialog.Alert);
        if (action != null && action.equalsIgnoreCase("add_resource")) {
            builder.setTitle(this.activity.getResources().getString(R.string.no_internet)).setMessage(this.activity.getResources().getString(R.string.adding_resources_will_work_only_when_you_are_online)).setPositiveButton(this.activity.getResources().getString(R.string.yes), new DialogInterface.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.ExamPrepLayer2$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).setIcon(android.R.drawable.ic_dialog_alert).setCancelable(false).show();
            return;
        }
        if (action != null && action.equalsIgnoreCase("add_revision")) {
            builder.setTitle(this.activity.getResources().getString(R.string.no_internet)).setMessage(this.activity.getResources().getString(R.string.adding_revisions_will_work_only_when_you_are_online)).setPositiveButton(this.activity.getResources().getString(R.string.yes), new DialogInterface.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.ExamPrepLayer2$$ExternalSyntheticLambda3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).setIcon(android.R.drawable.ic_dialog_alert).setCancelable(false).show();
            return;
        }
        if (action != null && action.equalsIgnoreCase("add_video")) {
            builder.setTitle(this.activity.getResources().getString(R.string.no_internet)).setMessage(this.activity.getResources().getString(R.string.adding_videos_will_work_only_when_you_are_online)).setPositiveButton(this.activity.getResources().getString(R.string.yes), new DialogInterface.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.ExamPrepLayer2$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).setIcon(android.R.drawable.ic_dialog_alert).setCancelable(false).show();
            return;
        }
        if (action != null && action.equalsIgnoreCase("add_solution")) {
            builder.setTitle(this.activity.getResources().getString(R.string.no_internet)).setMessage(this.activity.getResources().getString(R.string.adding) + getSolutionsOrWeblinks(false) + this.activity.getResources().getString(R.string.will_work_only_when_you_are_online)).setPositiveButton(this.activity.getResources().getString(R.string.yes), new DialogInterface.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.ExamPrepLayer2$$ExternalSyntheticLambda5
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).setIcon(android.R.drawable.ic_dialog_alert).setCancelable(false).show();
            return;
        }
        if (action != null && action.equalsIgnoreCase("view_video")) {
            builder.setTitle(this.activity.getResources().getString(R.string.no_internet)).setMessage(this.activity.getResources().getString(R.string.adding_videos_will_work_only_when_you_are_online)).setPositiveButton(this.activity.getResources().getString(R.string.yes), new DialogInterface.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.ExamPrepLayer2$$ExternalSyntheticLambda6
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).setIcon(android.R.drawable.ic_dialog_alert).setCancelable(false).show();
        } else {
            if (action == null || !action.equalsIgnoreCase("view_solution")) {
                return;
            }
            builder.setTitle(this.activity.getResources().getString(R.string.no_internet)).setMessage(this.activity.getResources().getString(R.string.adding) + getSolutionsOrWeblinks(false) + this.activity.getResources().getString(R.string.will_work_only_when_you_are_online)).setPositiveButton(this.activity.getResources().getString(R.string.yes), new DialogInterface.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.ExamPrepLayer2$$ExternalSyntheticLambda7
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).setIcon(android.R.drawable.ic_dialog_alert).setCancelable(false).show();
        }
    }

    private String getSolutionsOrWeblinks(boolean camelCase) {
        if (this.activity.getResources().getString(R.string.app_name).equalsIgnoreCase(this.activity.getResources().getString(R.string.app_name))) {
            if (camelCase) {
                return "Weblinks";
            }
            return "weblinks";
        }
        if (camelCase) {
            return "Solutions";
        }
        return "solutions";
    }

    private void initButton(CourseDetailData course) {
        String skip_payment = "";
        try {
            if (this.isCombo) {
                this.buttonLow.setVisibility(8);
                return;
            }
            if (course.getIsPurchased().equalsIgnoreCase("1")) {
                this.buttonLow.setVisibility(8);
                return;
            }
            if ((course == null || course.getSkip_payment() == null || !course.getSkip_payment().equalsIgnoreCase("1")) && !"1".equalsIgnoreCase("5")) {
                CourseDetail courseDetail = this.singleStudy;
                if (courseDetail == null || courseDetail.getData() == null || this.singleStudy.getData().getCourseDetail() == null || !this.singleStudy.getData().getCourseDetail().getCat_type().equalsIgnoreCase("3")) {
                    this.buttonLow.setVisibility(0);
                } else {
                    this.buttonLow.setVisibility(8);
                }
            } else {
                this.buttonLow.setVisibility(8);
            }
            int i = (int) (Float.parseFloat(course.getMrp()) + Float.parseFloat(course.getTax()));
            if (i != 0) {
                this.priceLL.setVisibility(0);
                this.myLibBtn.setVisibility(8);
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
                return;
            }
            this.mrpCutTV.setVisibility(8);
            this.priceLL.setVisibility(8);
            this.buyNowBtn.setVisibility(8);
            this.myLibBtn.setVisibility(0);
            if ("1".equalsIgnoreCase("7")) {
                this.buttonLow.setVisibility(8);
                return;
            }
            if (course != null && course.getSkip_payment() != null && course.getSkip_payment().equalsIgnoreCase("1")) {
                this.buttonLow.setVisibility(8);
                return;
            }
            if ("1".equalsIgnoreCase("5")) {
                this.buttonLow.setVisibility(8);
                return;
            }
            CourseDetail courseDetail2 = this.singleStudy;
            if (courseDetail2 == null || courseDetail2.getData() == null || this.singleStudy.getData().getCourseDetail() == null || !this.singleStudy.getData().getCourseDetail().getCat_type().equalsIgnoreCase("3")) {
                this.buttonLow.setVisibility(0);
            } else {
                this.buttonLow.setVisibility(8);
            }
        } catch (Exception e2) {
            Log.d("TAGINITBTN", "initButton: " + e2.getMessage());
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
        ExamPrepLayer3Adapter examPrepLayer3Adapter;
        ExamPrepLayer3Adapter examPrepLayer3Adapter2;
        super.onResume();
        if (SharedPreference.getInstance().getString("theme_color_hai_bhai") != null && !TextUtils.isEmpty(SharedPreference.getInstance().getString("theme_color_hai_bhai"))) {
            changeThemeColor(SharedPreference.getInstance().getString("theme_color_hai_bhai"));
        }
        if (SharedPreference.getInstance().getBoolean(Const.IS_PAYMENT_DONE)) {
            this.buttonLow.setVisibility(8);
            SharedPreference.getInstance().putBoolean(Const.SINGLE_STUDY, true);
        }
        if (SharedPreference.getInstance().getBoolean(Const.TEST_RESUME_STATE)) {
            this.isApiHitForUpdatingTheData = false;
            this.file_type_attributes = "0";
            this.mPage = 1;
            this.paginationStatus = false;
            hit_api_for_data(true);
            SharedPreference.getInstance().putBoolean(Const.TEST_RESUME_STATE, false);
        } else if (PreferencesUtil.INSTANCE.getStringPreference(this.activity, Const.SUBJECTIVE_TEST_UPLOADED).equalsIgnoreCase("1")) {
            this.file_type_attributes = "0";
            this.mPage = 1;
            this.paginationStatus = false;
            hit_api_for_data(true);
            PreferencesUtil.INSTANCE.removePreference(this.activity, Const.SUBJECTIVE_TEST_UPLOADED);
        } else {
            Activity activity = this.activity;
            if ((activity instanceof CourseActivity) && !TextUtils.isEmpty(String.valueOf(((CourseActivity) activity).rating_type)) && String.valueOf(((CourseActivity) this.activity).rating_type).equalsIgnoreCase("2") && String.valueOf(((CourseActivity) this.activity).rating_type).equalsIgnoreCase("3")) {
                this.file_type_attributes = "0";
                this.mPage = 1;
                this.paginationStatus = false;
                hit_api_for_data(true);
            } else if (SharedPreference.getInstance().getBoolean(Const.MARK_AS_READ)) {
                this.isApiHitForUpdatingTheData = false;
                this.file_type_attributes = "0";
                this.mPage = 1;
                this.paginationStatus = false;
                hit_api_for_data(true);
                SharedPreference.getInstance().putBoolean(Const.MARK_AS_READ, false);
            }
        }
        if (Constants.REFRESHPAGENEW.equals("true")) {
            this.isApiHitForUpdatingTheData = true;
            Constants.REFRESHPAGENEW = "false";
            if (this.cardsArrayList != null) {
                this.file_type_attributes = "0";
                this.mPage = 1;
                this.paginationStatus = false;
                hit_api_for_data(true);
            }
        }
        CourseDetail courseDetail = this.singleStudy;
        if (courseDetail != null && courseDetail.getData().getCourseDetail() != null) {
            initButton(this.singleStudy.getData().getCourseDetail());
        }
        LocalBroadcastManager.getInstance(requireActivity()).registerReceiver(this.videoDownloadReceiver, new IntentFilter(VideoDownloadService.VIDEO_DOWNLOAD_ACTION));
        LocalBroadcastManager.getInstance(requireActivity()).registerReceiver(this.audioServiceReceiver, new IntentFilter(AudioPlayerService.AUDIO_PLAYER_ACTION));
        LocalBroadcastManager.getInstance(requireActivity()).registerReceiver(this.musicServiceReceiver, new IntentFilter(MusicService.INSTANCE.getMUSIC_PLAYER_ACTION()));
        CourseDetail courseDetail2 = this.singleStudy;
        if (courseDetail2 != null && courseDetail2.getData() != null && this.singleStudy.getData().getCourseDetail() != null && this.singleStudy.getData().getCourseDetail().getCat_type().equalsIgnoreCase("3")) {
            SingleStudy.parentCourseId = "";
        }
        if (Constants.revison_set) {
            this.videoArrayList = MakeMyExam.videoArrayList;
            ArrayList<TilesItem> arrayList = this.cardsArrayList;
            if (arrayList != null && arrayList.size() > 0) {
                this.tile_id = this.cardsArrayList.get(0).getId();
                this.contentTypeTile = this.cardsArrayList.get(0).getType() + this.cardsArrayList.get(0).getId();
            }
            this.file_type_attributes = "0";
            this.examPrepLayer3Adapter.sendlist(this.videoArrayList);
            TileItemsAdapter tileItemsAdapter = this.tileItemsAdapter;
            if (tileItemsAdapter != null) {
                tileItemsAdapter.notifyDataSetChanged();
            }
            Constants.revison_set = false;
        }
        if (!Constants.REMAININGTIME.equalsIgnoreCase("")) {
            for (int i = 0; i < this.videoArrayList.size(); i++) {
                if (this.videoArrayList.get(i).getId().equalsIgnoreCase(Constants.REMAININGTIME.split("_")[1])) {
                    this.videoArrayList.get(i).setRemaining_time(Constants.REMAININGTIME.split("_")[0]);
                }
            }
            ArrayList<TilesItem> arrayList2 = this.cardsArrayList;
            if (arrayList2 != null && arrayList2.size() > 0) {
                this.tile_id = this.cardsArrayList.get(0).getId();
                this.contentTypeTile = this.cardsArrayList.get(0).getType() + this.cardsArrayList.get(0).getId();
            }
            this.file_type_attributes = "0";
            this.examPrepLayer3Adapter.notifyDataSetChanged();
            TileItemsAdapter tileItemsAdapter2 = this.tileItemsAdapter;
            if (tileItemsAdapter2 != null) {
                tileItemsAdapter2.notifyDataSetChanged();
            }
            Constants.REMAININGTIME = "";
        }
        if (AudioPlayerService.isAudioPlaying && (examPrepLayer3Adapter2 = this.examPrepLayer3Adapter) != null) {
            examPrepLayer3Adapter2.notifyDataSetChanged();
        }
        if (MusicService.INSTANCE.isAudioPlaying() && (examPrepLayer3Adapter = this.examPrepLayer3Adapter) != null) {
            examPrepLayer3Adapter.notifyDataSetChanged();
        }
        if (getView() == null || (string = SharedPreference.getInstance().getString("DEFERRED_RESULT_MSG")) == null || string.isEmpty()) {
            return;
        }
        Snackbar.make(getView(), string, 0).show();
        SharedPreference.getInstance().remove("DEFERRED_RESULT_MSG");
    }

    public void searchContent(String text, boolean isCross) {
        this.searchText = text;
        this.newsearchText = text;
        if (isCross) {
            this.mPage = 1;
            this.paginationStatus = false;
            this.isUserSearchSomething = false;
        } else {
            this.isUserSearchSomething = true;
        }
        NetworkAPICall(API.API_GET_MASTER_DATA, "", true, false, false);
    }

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.videoDownloadReceiver);
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.audioServiceReceiver);
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.musicServiceReceiver);
        Timer timer = this.myTimer;
        if (timer != null) {
            timer.cancel();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:72:0x014b  */
    @Override // com.appnew.android.Utils.Network.MainFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public retrofit2.Call<java.lang.String> getAPIB(java.lang.String r13, java.lang.String r14, com.appnew.android.Utils.Network.APIInterface r15) {
        /*
            Method dump skipped, instruction units count: 1032
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Courses.Fragment.ExamPrepLayer2.getAPIB(java.lang.String, java.lang.String, com.appnew.android.Utils.Network.APIInterface):retrofit2.Call");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.appnew.android.Utils.Network.MainFragment
    public void SuccessCallBack(JSONObject jsonobject, String apitype, String typeApi, boolean showprogress) throws JSONException {
        Intent intent;
        ArrayList arrayList;
        Gson gson = new Gson();
        apitype.hashCode();
        int i = 0;
        byte b2 = -1;
        switch (apitype.hashCode()) {
            case -1175877907:
                if (apitype.equals(API.user_video_view_data)) {
                    b2 = 0;
                }
                break;
            case -685656370:
                if (apitype.equals(API.update_video_view_time)) {
                    b2 = 1;
                }
                break;
            case -405213177:
                if (apitype.equals(API.GET_MY_QUIRES)) {
                    b2 = 2;
                }
                break;
            case -171058627:
                if (apitype.equals(API.API_GET_MASTER_DATA)) {
                    b2 = 3;
                }
                break;
            case 114126311:
                if (apitype.equals("https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction")) {
                    b2 = 4;
                }
                break;
            case 976912337:
                if (apitype.equals(API.COURSE_CONTENT_SEARCH)) {
                    b2 = 5;
                }
                break;
        }
        switch (b2) {
            case 0:
                try {
                    if (jsonobject.optString("status").equals("true")) {
                        SharedPreference.getInstance().saveHashMap(Const.API_UPDATE_VIDEO_VIEW, null);
                    } else {
                        ErrorCallBack(jsonobject.getString("message"), apitype, typeApi);
                        RetrofitResponse.GetApiData(this.activity, jsonobject.has("auth_code") ? jsonobject.getString("auth_code") : "", jsonobject.getString("message"), false);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
                break;
            case 1:
                try {
                    if (jsonobject.optString("status").equals("true")) {
                        SharedPreference.getInstance().saveHashMap(Const.API_VIDEO_VIEW_TIME, null);
                    } else {
                        ErrorCallBack(jsonobject.getString("message"), apitype, typeApi);
                        RetrofitResponse.GetApiData(this.activity, jsonobject.has("auth_code") ? jsonobject.getString("auth_code") : "", jsonobject.getString("message"), false);
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
                break;
            case 2:
                if (jsonobject.optString("status").equals("true")) {
                    if (((ArrayList) new Gson().fromJson(jsonobject.getJSONArray("data").toString(), new TypeToken<ArrayList<HelpSupportChatModel.DataBean>>() { // from class: com.appnew.android.Courses.Fragment.ExamPrepLayer2.6
                    }.getType())).size() > 0) {
                        Intent intent2 = new Intent(this.activity, (Class<?>) HelpQueryActivity.class);
                        intent2.putExtra("isCourse", true);
                        intent2.putExtra("courseDetail", this.singleStudy);
                        startActivity(intent2);
                    } else {
                        Intent intent3 = new Intent(this.activity, (Class<?>) HelpSupportActivity.class);
                        intent3.putExtra("isCourse", true);
                        intent3.putExtra("courseDetail", this.singleStudy);
                        startActivity(intent3);
                    }
                } else {
                    Intent intent4 = new Intent(this.activity, (Class<?>) HelpSupportActivity.class);
                    intent4.putExtra("isCourse", true);
                    intent4.putExtra("courseDetail", this.singleStudy);
                    startActivity(intent4);
                }
                break;
            case 3:
                if (jsonobject.optString("status").equals("true")) {
                    Log.e("TAG_APP", "onResume:2 BARA ExamPrepLayer2 resume");
                    if (this.isUserSearchSomething) {
                        this.isUserSearchSomething = false;
                    }
                    SharedPreference.getInstance().putString(Const.SERVER_TIME, jsonobject.optString("time"));
                    String str = this.searchText;
                    if (str != null && !TextUtils.isEmpty(str)) {
                        ArrayList arrayList2 = new ArrayList();
                        if (jsonobject.has("data")) {
                            JSONArray jSONArrayOptJSONArray = jsonobject.optJSONObject("data").optJSONArray("list");
                            if (jSONArrayOptJSONArray.length() > 0) {
                                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                                    arrayList2.add((Video) new Gson().fromJson(jSONArrayOptJSONArray.opt(i2).toString(), Video.class));
                                }
                                if (this.examPrepLayer3Adapter != null) {
                                    arrayList = arrayList2;
                                    this.examPrepLayer3Adapter = new ExamPrepLayer3Adapter(this.activity, this.singleStudy, arrayList, this.tileIdAPI, this.tileTypeAPI, this.revertAPI, this.tile_id, this.is_purchase);
                                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.activity, 1, false);
                                    this.linearLayoutManager = linearLayoutManager;
                                    this.examPrepLayerRV.setLayoutManager(linearLayoutManager);
                                    this.examPrepLayerRV.setItemAnimator(new DefaultItemAnimator());
                                    this.examPrepLayerRV.setAdapter(this.examPrepLayer3Adapter);
                                    this.examPrepLayerRV.setVisibility(0);
                                } else {
                                    arrayList = arrayList2;
                                }
                                if (arrayList.isEmpty()) {
                                    this.examPrepLayerRV.setVisibility(8);
                                    this.no_data_found_RL.setVisibility(0);
                                } else {
                                    this.examPrepLayerRV.setVisibility(0);
                                    this.no_data_found_RL.setVisibility(8);
                                }
                            }
                        }
                        break;
                    } else {
                        this.isPaginationAvailable = true;
                        if (this.paginationStatus) {
                            JSONObject jSONObject = jsonobject.getJSONObject("data");
                            if (jSONObject.has("cat_type")) {
                                this.catType = jSONObject.optString("cat_type");
                            } else {
                                this.catType = "";
                            }
                            ArrayList arrayList3 = new ArrayList();
                            while (i < jSONObject.optJSONArray("list").length()) {
                                arrayList3.add((Video) gson.fromJson(jSONObject.optJSONArray("list").get(i).toString(), Video.class));
                                i++;
                            }
                            if (arrayList3.size() > 0) {
                                int size = this.videoArrayList.size();
                                this.videoArrayList.addAll(arrayList3);
                                ArrayList<Video> arrayList4 = this.videoArrayList;
                                actual_videolist = arrayList4;
                                handleDownloadsVideo(arrayList4);
                                try {
                                    ExamPrepLayer3Adapter examPrepLayer3Adapter = this.examPrepLayer3Adapter;
                                    if (examPrepLayer3Adapter != null) {
                                        examPrepLayer3Adapter.notifyItemRangeInserted(this.videoArrayList.size() - 1, this.videoArrayList.size() - size);
                                    }
                                } catch (IndexOutOfBoundsException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            break;
                        } else {
                            ArrayList<Video> arrayList5 = this.videoArrayList;
                            if (arrayList5 != null && arrayList5.size() != 0) {
                                this.videoArrayList.clear();
                            }
                            JSONObject jSONObject2 = jsonobject.getJSONObject("data");
                            ArrayList arrayList6 = new ArrayList();
                            this.spinnerList.clear();
                            this.mp = new HashMap<>();
                            for (int i3 = 0; i3 < jSONObject2.optJSONArray("list").length(); i3++) {
                                Video video = (Video) gson.fromJson(jSONObject2.optJSONArray("list").get(i3).toString(), Video.class);
                                arrayList6.add(video);
                                if (video.getVideo_type() != null && video.getVideo_type().equalsIgnoreCase("9")) {
                                    this.mp.put(video.getTitle(), true);
                                }
                                for (int i4 = 0; i4 < this.singleStudy.getData().getTiles().size(); i4++) {
                                    TilesItem tilesItem = this.singleStudy.getData().getTiles().get(i4);
                                    if (tilesItem.getType().equalsIgnoreCase(Const.PDF) && tilesItem.getIsvisible().equalsIgnoreCase("false")) {
                                        tilesItem.setIsvisible("true");
                                    } else if (tilesItem.getType().equalsIgnoreCase(Const.PPT) && tilesItem.getIsvisible().equalsIgnoreCase("false")) {
                                        tilesItem.setIsvisible("true");
                                    } else if (tilesItem.getType().equalsIgnoreCase("video") && tilesItem.getIsvisible().equalsIgnoreCase("false")) {
                                        tilesItem.setIsvisible("true");
                                    } else if (tilesItem.getType().equalsIgnoreCase(Const.EPUB) && tilesItem.getIsvisible().equalsIgnoreCase("false")) {
                                        tilesItem.setIsvisible("true");
                                    } else if (tilesItem.getType().equalsIgnoreCase(Const.DOC) && tilesItem.getIsvisible().equalsIgnoreCase("false")) {
                                        tilesItem.setIsvisible("true");
                                    } else if (tilesItem.getType().equalsIgnoreCase("image") && tilesItem.getIsvisible().equalsIgnoreCase("false")) {
                                        tilesItem.setIsvisible("true");
                                    } else if (tilesItem.getType().equalsIgnoreCase(Const.CONCEPT) && tilesItem.getIsvisible().equalsIgnoreCase("false")) {
                                        tilesItem.setIsvisible("true");
                                    } else if (tilesItem.getType().equalsIgnoreCase("link") && tilesItem.getIsvisible().equalsIgnoreCase("false")) {
                                        tilesItem.setIsvisible("true");
                                    } else if (tilesItem.getType().equalsIgnoreCase(Const.TEST) && tilesItem.getIsvisible().equalsIgnoreCase("false")) {
                                        tilesItem.setIsvisible("true");
                                    } else if (tilesItem.getType().equalsIgnoreCase(Const.SUBJECTIVE_TEST) && tilesItem.getIsvisible().equalsIgnoreCase("false")) {
                                        tilesItem.setIsvisible("true");
                                    } else if (tilesItem.getType().equalsIgnoreCase(Const.Daily_assignment) && tilesItem.getIsvisible().equalsIgnoreCase("false")) {
                                        tilesItem.setIsvisible("true");
                                    } else if (tilesItem.getType().equalsIgnoreCase("audio") && tilesItem.getIsvisible().equalsIgnoreCase("false")) {
                                        tilesItem.setIsvisible("true");
                                    }
                                }
                            }
                            if (this.mp.size() > 0) {
                                this.dropDown_filter.setVisibility(8);
                                ArrayAdapter arrayAdapter = new ArrayAdapter(this.activity, android.R.layout.simple_spinner_item, (String[]) this.mp.keySet().toArray(new String[1]));
                                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                this.spinner.setAdapter((SpinnerAdapter) arrayAdapter);
                            } else {
                                this.dropDown_filter.setVisibility(8);
                            }
                            if (arrayList6.size() > 0) {
                                this.videoArrayList.addAll(arrayList6);
                                ArrayList<Video> arrayList7 = this.videoArrayList;
                                actual_videolist = arrayList7;
                                handleDownloadsVideo(arrayList7);
                                if (this.singleStudy.getData().getCourseDetail().getIsPurchased().equalsIgnoreCase("1")) {
                                    if (TextUtils.isEmpty(this.tile_id)) {
                                        if (!this.SHOW_ALL_TILE) {
                                            Iterator<TilesItem> it = this.singleStudy.getData().getTiles().iterator();
                                            while (true) {
                                                if (it.hasNext()) {
                                                    TilesItem next = it.next();
                                                    if (!next.getType().equalsIgnoreCase("content")) {
                                                        if (next.getIsvisible().equalsIgnoreCase("true")) {
                                                            this.tile_id = next.getId();
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            Iterator<TilesItem> it2 = this.singleStudy.getData().getTiles().iterator();
                                            while (true) {
                                                if (it2.hasNext()) {
                                                    TilesItem next2 = it2.next();
                                                    if (next2.getType().equalsIgnoreCase("content")) {
                                                        this.tile_id = next2.getId();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (this.SHOW_ALL_TILE) {
                                        createTileData(this.tile_id);
                                    }
                                } else {
                                    this.tile_id = this.tileIdAPI;
                                    this.tileRv.setVisibility(8);
                                }
                                this.no_data_found_RL.setVisibility(8);
                                this.examPrepLayerRV.setVisibility(0);
                                InitTestAdapter(this.videoArrayList, this.tile_id);
                            } else {
                                this.no_data_found_RL.setVisibility(0);
                                this.examPrepLayerRV.setVisibility(8);
                            }
                        }
                        ProgressBar progressBar = this.paginationLoader;
                        if (progressBar != null && progressBar.isShown()) {
                            this.paginationLoader.setVisibility(8);
                            break;
                        }
                    }
                } else {
                    if (!this.paginationStatus) {
                        this.no_data_found_RL.setVisibility(0);
                        this.examPrepLayerRV.setVisibility(8);
                    }
                    ProgressBar progressBar2 = this.paginationLoader;
                    if (progressBar2 != null && progressBar2.isShown()) {
                        this.paginationLoader.setVisibility(8);
                    }
                    this.isPaginationAvailable = false;
                    if (!GenericUtils.isEmpty(jsonobject.optString("auth_code"))) {
                        RetrofitResponse.GetApiData(this.activity, jsonobject.optString("auth_code"), jsonobject.optString("message"), false);
                    }
                    break;
                }
                break;
            case 4:
                try {
                    if (jsonobject.optString("status").equals("true")) {
                        if (!SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                            this.utkashRoom.getCourseDetaildata().deletecoursedetail(SingleStudy.parentCourseId, MakeMyExam.userId);
                        } else if (!this.singleStudy.getData().getCourseDetail().getId().equalsIgnoreCase("")) {
                            this.utkashRoom.getCourseDetaildata().deletecoursedetail(this.singleStudy.getData().getCourseDetail().getId(), MakeMyExam.userId);
                        }
                        Toast.makeText(this.activity, "" + jsonobject.optString("message"), 0).show();
                        pushEventForFreeCourse();
                        if ("1".equalsIgnoreCase("7")) {
                            intent = new Intent(this.activity, (Class<?>) DashboardActivityTheme8.class);
                        } else {
                            intent = new Intent(this.activity, (Class<?>) DashboardActivityTheme1.class);
                        }
                        intent.setFlags(67141632);
                        this.isAddToMyLibrary = true;
                        Intent intent5 = new Intent(this.activity, (Class<?>) CourseActivity.class);
                        intent5.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                        intent5.putExtra(Const.COURSE_ID_MAIN, !SingleStudy.parentCourseId.equalsIgnoreCase("") ? SingleStudy.parentCourseId : this.singleStudy.getData().getCourseDetail().getId());
                        intent5.putExtra(Const.COURSE_PARENT_ID, "");
                        intent5.putExtra(Const.CONTENT_TYPE_1, this.contentType);
                        intent5.putExtra(Const.PAYMENT_DONE, 1);
                        intent5.putExtra(Const.IS_COMBO, false);
                        intent5.putExtra(AnalyticsConstants.course_name, this.singleStudy.getData().getCourseDetail().getTitle());
                        intent5.setFlags(67141632);
                        Helper.gotoActivity_finish(intent5, this.activity);
                    } else {
                        Toast.makeText(this.activity, "" + jsonobject.optString("message"), 0).show();
                        this.isAddToMyLibrary = false;
                        ErrorCallBack(jsonobject.getString("message"), apitype, typeApi);
                        RetrofitResponse.GetApiData(this.activity, jsonobject.has("auth_code") ? jsonobject.getString("auth_code") : "", jsonobject.getString("message"), false);
                    }
                } catch (Exception e5) {
                    this.isAddToMyLibrary = false;
                    e5.printStackTrace();
                    return;
                }
                break;
            case 5:
                if (jsonobject.optString("status").equals("true")) {
                    ArrayList<Video> arrayList8 = new ArrayList<>();
                    if (jsonobject.has("data")) {
                        JSONArray jSONArrayOptJSONArray2 = jsonobject.optJSONArray("data");
                        if (jSONArrayOptJSONArray2.length() > 0) {
                            while (i < jSONArrayOptJSONArray2.length()) {
                                arrayList8.add((Video) new Gson().fromJson(jSONArrayOptJSONArray2.opt(i).toString(), Video.class));
                                i++;
                            }
                            ExamPrepLayer3Adapter examPrepLayer3Adapter2 = this.examPrepLayer3Adapter;
                            if (examPrepLayer3Adapter2 != null) {
                                examPrepLayer3Adapter2.sendlist(arrayList8);
                            }
                        }
                    } else {
                        ExamPrepLayer3Adapter examPrepLayer3Adapter3 = this.examPrepLayer3Adapter;
                        if (examPrepLayer3Adapter3 != null) {
                            examPrepLayer3Adapter3.sendlist(arrayList8);
                        }
                    }
                }
                break;
        }
    }

    private void getFileteredData(ArrayList<Video> videoArrayList, ArrayList<TilesItem> cardsArrayList) {
        this.progressBarAll.setVisibility(0);
        this.examPrepLayerRV.setVisibility(4);
        this.contentTypeTile = cardsArrayList.get(0).getType() + cardsArrayList.get(0).getId();
        this.tile_id = cardsArrayList.get(0).getId();
        if (cardsArrayList.get(0).getType().equalsIgnoreCase(Const.PDF)) {
            this.fileType = "1";
        } else if (cardsArrayList.get(0).getType().equalsIgnoreCase(Const.PPT)) {
            this.fileType = "2";
        } else if (cardsArrayList.get(0).getType().equalsIgnoreCase("video")) {
            this.fileType = "3";
        } else if (cardsArrayList.get(0).getType().equalsIgnoreCase(Const.EPUB)) {
            this.fileType = "4";
        } else if (cardsArrayList.get(0).getType().equalsIgnoreCase(Const.DOC)) {
            this.fileType = "5";
        } else if (cardsArrayList.get(0).getType().equalsIgnoreCase("image")) {
            this.fileType = "6";
        } else if (cardsArrayList.get(0).getType().equalsIgnoreCase(Const.CONCEPT)) {
            this.fileType = "7";
        } else if (cardsArrayList.get(0).getType().equalsIgnoreCase("link")) {
            this.fileType = "8";
        } else if (cardsArrayList.get(0).getType().equalsIgnoreCase(Const.TEST)) {
            this.file_type_attributes = "t";
            this.fileType = "t";
        } else if (cardsArrayList.get(0).getType().equalsIgnoreCase("audio")) {
            this.fileType = "13";
        } else if (cardsArrayList.get(0).getType().equalsIgnoreCase(Const.SUBJECTIVE_TEST)) {
            this.file_type_attributes = "st";
            this.fileType = "st";
        } else if (cardsArrayList.get(0).getType().equalsIgnoreCase(Const.Daily_assignment)) {
            this.file_type_attributes = Const.CONTENT_daily_assign;
            this.fileType = Const.CONTENT_daily_assign;
        } else {
            this.file_type_attributes = "0";
            this.fileType = "0";
        }
        this.seleced_tile_list.clear();
        this.custom_video_list.clear();
        this.custom_link_list.clear();
        for (Video video : videoArrayList) {
            if (this.fileType.equalsIgnoreCase(video.getFile_type()) && cardsArrayList.get(0).getId().equalsIgnoreCase(video.getPayloadData().getTile_id())) {
                video.setIs_deleted(false);
                this.seleced_tile_list.add(video);
            }
            if ("10".equalsIgnoreCase(video.getFile_type()) && cardsArrayList.get(0).getId().equalsIgnoreCase(video.getPayloadData().getTile_id())) {
                video.setIs_deleted(true);
                this.custom_video_list.add(video);
            }
            if ("11".equalsIgnoreCase(video.getFile_type()) && cardsArrayList.get(0).getId().equalsIgnoreCase(video.getPayloadData().getTile_id())) {
                video.setIs_deleted(true);
                this.custom_link_list.add(video);
            }
        }
        if (this.fileType.equalsIgnoreCase("0")) {
            InitTestAdapter(videoArrayList, cardsArrayList.get(0).getId());
        } else if (this.fileType.equalsIgnoreCase("3")) {
            this.seleced_tile_list.addAll(this.custom_video_list);
            InitTestAdapter(this.seleced_tile_list, cardsArrayList.get(0).getId());
        } else if (this.fileType.equalsIgnoreCase("8")) {
            this.seleced_tile_list.addAll(this.custom_link_list);
            InitTestAdapter(this.seleced_tile_list, cardsArrayList.get(0).getId());
        } else {
            InitTestAdapter(this.seleced_tile_list, cardsArrayList.get(0).getId());
        }
        this.progressBarAll.setVisibility(8);
        this.examPrepLayerRV.setVisibility(0);
    }

    private void InitTestAdapter(ArrayList<Video> videoArrayList) {
        ((CourseActivity) this.activity).searchView.setQuery("", false);
        if (videoArrayList != null && videoArrayList.size() > 0) {
            RecyclerView recyclerView = this.examPrepLayerRV;
            if (recyclerView != null && this.no_data_found_RL != null) {
                recyclerView.setVisibility(0);
                this.no_data_found_RL.setVisibility(8);
            }
            if (this.parentLL.getVisibility() == 8) {
                this.parentLL.setVisibility(0);
            }
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.activity, 1, false);
            this.linearLayoutManager = linearLayoutManager;
            this.examPrepLayerRV.setLayoutManager(linearLayoutManager);
            this.examPrepLayerRV.setItemAnimator(new DefaultItemAnimator());
            this.videoArrayListPagination.clear();
            this.videoArrayListPagination = getVideoList(videoArrayList, 0);
            ExamPrepLayer3Adapter examPrepLayer3Adapter = new ExamPrepLayer3Adapter(this.activity, this.singleStudy, videoArrayList, this.tileIdAPI, this.tileTypeAPI, this.revertAPI, this.tile_id, this.is_purchase);
            this.examPrepLayer3Adapter = examPrepLayer3Adapter;
            this.examPrepLayerRV.setAdapter(examPrepLayer3Adapter);
            return;
        }
        RecyclerView recyclerView2 = this.examPrepLayerRV;
        if (recyclerView2 == null || this.no_data_found_RL == null) {
            return;
        }
        recyclerView2.setVisibility(8);
        this.no_data_found_RL.setVisibility(0);
    }

    private ArrayList<Video> getVideoList(ArrayList<Video> videoArrayList, int startIndex) {
        int i = startIndex + 8;
        this.currentIndex = Math.min(i, videoArrayList.size());
        return new ArrayList<>(videoArrayList.subList(startIndex, Math.min(i, videoArrayList.size())));
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        RecyclerView recyclerView;
        ProgressBar progressBar = this.paginationLoader;
        if (progressBar != null && progressBar.isShown()) {
            this.paginationLoader.setVisibility(8);
        }
        if (!apitype.equalsIgnoreCase(API.API_GET_MASTER_DATA) || (recyclerView = this.examPrepLayerRV) == null || this.no_data_found_RL == null) {
            return;
        }
        recyclerView.setVisibility(8);
        this.no_data_found_RL.setVisibility(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        this.spinnerTitle.setText(this.mp.keySet().toArray()[position].toString());
    }

    public class TileItemsAdapter extends RecyclerView.Adapter<MyViewHolder> {
        private List<TilesItem> cards;
        private Context context;
        private RecyclerView tileRv;

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

        public TileItemsAdapter(Context context, ArrayList<TilesItem> cards, RecyclerView tileRv) {
            this.cards = cards;
            this.context = context;
            this.tileRv = tileRv;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_tiles_theme_2, parent, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            final TilesItem tilesItem = this.cards.get(position);
            if (tilesItem != null && !TextUtils.isEmpty(tilesItem.getType()) && tilesItem.getType().equalsIgnoreCase(Const.LIVE_VIDEO)) {
                try {
                    holder.liveIv.setVisibility(0);
                    Glide.with(ExamPrepLayer2.this.activity).asGif().load(Integer.valueOf(R.mipmap.live)).into(holder.liveIv);
                } catch (Exception unused) {
                    holder.liveIv.setVisibility(8);
                }
                holder.tilesText.setPadding(Math.round(Helper.convertDpToPixel(4, this.context)), Math.round(Helper.convertDpToPixel(8, this.context)), Math.round(Helper.convertDpToPixel(4, this.context)), Math.round(Helper.convertDpToPixel(8, this.context)));
            }
            holder.tilesText.setText(tilesItem.getTileName());
            if (ExamPrepLayer2.this.contentTypeTile.equals(tilesItem.getType() + tilesItem.getId())) {
                holder.tilesText.setTextColor(this.context.getResources().getColor(R.color.colorPrimary));
                holder.bg_bottom.setVisibility(0);
            } else {
                holder.tilesText.setTextColor(this.context.getResources().getColor(R.color.black));
                holder.bg_bottom.setVisibility(8);
            }
            holder.parent.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.ExamPrepLayer2.TileItemsAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (Helper.isNetworkConnected(ExamPrepLayer2.this.activity)) {
                        ExamPrepLayer2.this.examPrepLayerRV.setVisibility(4);
                        ExamPrepLayer2.this.no_data_found_RL.setVisibility(8);
                        ExamPrepLayer2.this.isApiHitForUpdatingTheData = false;
                        new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.Courses.Fragment.ExamPrepLayer2.TileItemsAdapter.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ExamPrepLayer2.this.file_type_attributes = "";
                                if (ExamPrepLayer2.this.singleStudy.getData().getCourseDetail().getIsPurchased().equalsIgnoreCase("1")) {
                                    ExamPrepLayer2.this.contentTypeTile = tilesItem.getType() + tilesItem.getId();
                                } else {
                                    ExamPrepLayer2.this.contentTypeTile = tilesItem.getType() + tilesItem.getId();
                                }
                                if (tilesItem.getType().equalsIgnoreCase("all")) {
                                    ((CourseActivity) ExamPrepLayer2.this.activity).contentType = "content0";
                                } else {
                                    ((CourseActivity) ExamPrepLayer2.this.activity).contentType = ExamPrepLayer2.this.contentTypeTile;
                                }
                                ExamPrepLayer2.this.tile_id = tilesItem.getId();
                                if (tilesItem.getType().equalsIgnoreCase(Const.PDF)) {
                                    ExamPrepLayer2.this.fileType = "1";
                                } else if (tilesItem.getType().equalsIgnoreCase(Const.PPT)) {
                                    ExamPrepLayer2.this.fileType = "2";
                                } else if (tilesItem.getType().equalsIgnoreCase("video")) {
                                    ExamPrepLayer2.this.fileType = "3";
                                } else if (tilesItem.getType().equalsIgnoreCase(Const.EPUB)) {
                                    ExamPrepLayer2.this.fileType = "4";
                                } else if (tilesItem.getType().equalsIgnoreCase(Const.DOC)) {
                                    ExamPrepLayer2.this.fileType = "5";
                                } else if (tilesItem.getType().equalsIgnoreCase("image")) {
                                    ExamPrepLayer2.this.fileType = "6";
                                } else if (tilesItem.getType().equalsIgnoreCase(Const.CONCEPT)) {
                                    ExamPrepLayer2.this.fileType = "7";
                                } else if (tilesItem.getType().equalsIgnoreCase("link")) {
                                    ExamPrepLayer2.this.fileType = "8";
                                } else if (tilesItem.getType().equalsIgnoreCase(Const.TEST)) {
                                    ExamPrepLayer2.this.file_type_attributes = "t";
                                    ExamPrepLayer2.this.fileType = "t";
                                } else if (tilesItem.getType().equalsIgnoreCase("audio")) {
                                    ExamPrepLayer2.this.fileType = "13";
                                } else if (tilesItem.getType().equalsIgnoreCase(Const.SUBJECTIVE_TEST)) {
                                    ExamPrepLayer2.this.file_type_attributes = "st";
                                    ExamPrepLayer2.this.fileType = "st";
                                } else if (tilesItem.getType().equalsIgnoreCase(Const.Daily_assignment)) {
                                    ExamPrepLayer2.this.file_type_attributes = Const.CONTENT_daily_assign;
                                    ExamPrepLayer2.this.fileType = Const.CONTENT_daily_assign;
                                } else {
                                    ExamPrepLayer2.this.file_type_attributes = "0";
                                    ExamPrepLayer2.this.fileType = "0";
                                }
                                TileItemsAdapter.this.tileRv.scrollToPosition(position);
                                TileItemsAdapter.this.notifyDataSetChanged();
                                ExamPrepLayer2.this.videoArrayList.clear();
                                ExamPrepLayer2.this.seleced_tile_list.clear();
                                ExamPrepLayer2.this.custom_video_list.clear();
                                ExamPrepLayer2.this.custom_link_list.clear();
                                if (ExamPrepLayer2.this.examPrepLayer3Adapter != null) {
                                    ExamPrepLayer2.this.examPrepLayer3Adapter.notifyDataSetChanged();
                                }
                                for (Video video : ExamPrepLayer2.this.videoArrayList) {
                                    if (ExamPrepLayer2.this.fileType.equalsIgnoreCase(video.getFile_type()) && ExamPrepLayer2.this.tile_id.equalsIgnoreCase(video.getPayloadData().getTile_id())) {
                                        video.setIs_deleted(false);
                                        ExamPrepLayer2.this.seleced_tile_list.add(video);
                                    }
                                    if ("10".equalsIgnoreCase(video.getFile_type()) && ExamPrepLayer2.this.tile_id.equalsIgnoreCase(video.getPayloadData().getTile_id())) {
                                        video.setIs_deleted(true);
                                        ExamPrepLayer2.this.custom_video_list.add(video);
                                    }
                                    if ("11".equalsIgnoreCase(video.getFile_type()) && ExamPrepLayer2.this.tile_id.equalsIgnoreCase(video.getPayloadData().getTile_id())) {
                                        video.setIs_deleted(true);
                                        ExamPrepLayer2.this.custom_link_list.add(video);
                                    }
                                }
                                ExamPrepLayer2.this.progressBarAll.setVisibility(8);
                                if (ExamPrepLayer2.this.fileType.equalsIgnoreCase("0")) {
                                    if (ExamPrepLayer2.this.videoArrayList.size() > 0) {
                                        ExamPrepLayer2.this.isApiHit = false;
                                        ExamPrepLayer2.this.InitTestAdapter(ExamPrepLayer2.this.videoArrayList, tilesItem.getId());
                                        return;
                                    }
                                    String str = ExamPrepLayer2.this.revertAPI.split("\\#")[1];
                                    ExamPrepLayer2.this.tileIdAPI = tilesItem.getId();
                                    ExamPrepLayer2.this.tileTypeAPI = "content";
                                    if (str.equalsIgnoreCase("2")) {
                                        ExamPrepLayer2.this.revertAPI = "1#2#0#0";
                                    } else {
                                        ExamPrepLayer2.this.revertAPI = "1#0#0#0";
                                    }
                                    ExamPrepLayer2.this.paginationStatus = false;
                                    ExamPrepLayer2.this.mPage = 1;
                                    ExamPrepLayer2.this.hit_api_for_data(true);
                                    return;
                                }
                                if (ExamPrepLayer2.this.fileType.equalsIgnoreCase("3")) {
                                    if (ExamPrepLayer2.this.custom_video_list.size() > 0) {
                                        ExamPrepLayer2.this.seleced_tile_list.addAll(ExamPrepLayer2.this.custom_video_list);
                                        ExamPrepLayer2.this.isApiHit = false;
                                        ExamPrepLayer2.this.InitTestAdapter(ExamPrepLayer2.this.seleced_tile_list, tilesItem.getId());
                                        return;
                                    }
                                    ExamPrepLayer2.this.tileIdAPI = tilesItem.getId();
                                    ExamPrepLayer2.this.tileTypeAPI = tilesItem.getType();
                                    ExamPrepLayer2.this.paginationStatus = false;
                                    ExamPrepLayer2.this.mPage = 1;
                                    ExamPrepLayer2.this.hit_api_for_data(true);
                                    return;
                                }
                                if (ExamPrepLayer2.this.fileType.equalsIgnoreCase("8")) {
                                    if (ExamPrepLayer2.this.custom_link_list.size() > 0) {
                                        ExamPrepLayer2.this.seleced_tile_list.addAll(ExamPrepLayer2.this.custom_link_list);
                                        ExamPrepLayer2.this.InitTestAdapter(ExamPrepLayer2.this.seleced_tile_list, tilesItem.getId());
                                        ExamPrepLayer2.this.isApiHit = false;
                                        return;
                                    }
                                    ExamPrepLayer2.this.tileIdAPI = tilesItem.getId();
                                    ExamPrepLayer2.this.tileTypeAPI = tilesItem.getType();
                                    ExamPrepLayer2.this.paginationStatus = false;
                                    ExamPrepLayer2.this.mPage = 1;
                                    ExamPrepLayer2.this.hit_api_for_data(true);
                                    return;
                                }
                                if (ExamPrepLayer2.this.seleced_tile_list.size() > 0) {
                                    ExamPrepLayer2.this.isApiHit = false;
                                    ExamPrepLayer2.this.InitTestAdapter(ExamPrepLayer2.this.seleced_tile_list, tilesItem.getId());
                                    return;
                                }
                                ExamPrepLayer2.this.tileIdAPI = tilesItem.getId();
                                ExamPrepLayer2.this.tileTypeAPI = tilesItem.getType();
                                ExamPrepLayer2.this.paginationStatus = false;
                                ExamPrepLayer2.this.mPage = 1;
                                ExamPrepLayer2.this.hit_api_for_data(true);
                            }
                        }, 100L);
                        return;
                    }
                    Helper.showInternetToast(ExamPrepLayer2.this.activity);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.cards.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void InitTestAdapter(ArrayList<Video> videoArrayList, String tile_id) {
        boolean z;
        ((CourseActivity) this.activity).searchView.setQuery("", false);
        if (tile_id.equalsIgnoreCase("0")) {
            z = true;
            break;
        }
        Iterator<Video> it = videoArrayList.iterator();
        while (it.hasNext()) {
            if (it.next().getPayloadData().getTile_id().equalsIgnoreCase(tile_id)) {
                z = true;
                break;
            }
        }
        z = false;
        if (videoArrayList != null && videoArrayList.size() > 0 && z) {
            RecyclerView recyclerView = this.examPrepLayerRV;
            if (recyclerView != null && this.no_data_found_RL != null) {
                recyclerView.setVisibility(0);
                this.no_data_found_RL.setVisibility(8);
            }
            if (this.parentLL.getVisibility() == 8) {
                this.parentLL.setVisibility(0);
            }
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.activity, 1, false);
            this.linearLayoutManager = linearLayoutManager;
            this.examPrepLayerRV.setLayoutManager(linearLayoutManager);
            this.examPrepLayerRV.setItemAnimator(new DefaultItemAnimator());
            this.videoArrayListPagination.clear();
            this.videoArrayListPagination = getVideoList(videoArrayList, 0);
            ExamPrepLayer3Adapter examPrepLayer3Adapter = new ExamPrepLayer3Adapter(this.activity, this.singleStudy, videoArrayList, this.tileIdAPI, this.tileTypeAPI, this.revertAPI, tile_id, this.is_purchase);
            this.examPrepLayer3Adapter = examPrepLayer3Adapter;
            this.examPrepLayerRV.setAdapter(examPrepLayer3Adapter);
            if (this.isApiHitForUpdatingTheData) {
                return;
            }
            this.examPrepLayerRV.smoothScrollBy(0, 0);
            return;
        }
        RecyclerView recyclerView2 = this.examPrepLayerRV;
        if (recyclerView2 == null || this.no_data_found_RL == null) {
            return;
        }
        recyclerView2.setVisibility(8);
        this.no_data_found_RL.setVisibility(0);
    }

    private void getmyQuires() {
        NetworkAPICall(API.GET_MY_QUIRES, "", true, false, false);
    }

    private void handleDownloadsVideo(ArrayList<Video> videoArrayList) {
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
            if (video.getFile_type() != null && video.getFile_type().equalsIgnoreCase("13") && !this.utkashRoom.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread()) {
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

    private void pushEventForFreeCourse() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_id", AnalyticHelper.INSTANCE.getUserId());
        map.put(AnalyticsConstants.user_name, AnalyticHelper.INSTANCE.getUserName());
        map.put("course_id", this.singleStudy.getData().getCourseDetail().getId());
        map.put(AnalyticsConstants.course_name, this.singleStudy.getData().getCourseDetail().getTitle());
        AnalyticEvents.INSTANCE.pushEvents(this.activity, AnalyticsConstants.FREE_USER, map);
    }
}
