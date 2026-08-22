package com.appnew.android.Courses.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.SystemClock;
import android.text.Html;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.BuildConfig;
import com.appnew.android.Coupon.Models.Available;
import com.appnew.android.Coupon.Models.CouponPojo;
import com.appnew.android.Coupon.Models.CoursesCoupon;
import com.appnew.android.Courses.Activity.ComboListActivity;
import com.appnew.android.Courses.Activity.Concept_newActivity;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.Courses.Activity.PdfDetailScreen;
import com.appnew.android.Courses.Activity.PdfListActivity;
import com.appnew.android.Courses.Activity.QuizActivity;
import com.appnew.android.Courses.Adapter.ComboListAdapter;
import com.appnew.android.Courses.Adapter.SingleStudyAdapter;
import com.appnew.android.Courses.Fragment.ExamPrepLayer2;
import com.appnew.android.Courses.Fragment.SingleStudy;
import com.appnew.android.Courses.overview.adapter.OverviewRVAdapter;
import com.appnew.android.Download.Audio.AudioPlayerService;
import com.appnew.android.Download.DownloadActivity;
import com.appnew.android.Download.DownloadVideoPlayer;
import com.appnew.android.DownloadServices.VideoDownloadService;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.BottomSetting;
import com.appnew.android.Model.COURSEDETAIL.CourseDetail;
import com.appnew.android.Model.COURSEDETAIL.CourseDetailData;
import com.appnew.android.Model.COURSEDETAIL.TilesItem;
import com.appnew.android.Model.ComboCourseModel;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Model.Courses.ExamPrepItem;
import com.appnew.android.Model.Courses.Lists;
import com.appnew.android.Model.FAQs.FaqData;
import com.appnew.android.Model.LeftMenu;
import com.appnew.android.Model.Overview.OverviewData;
import com.appnew.android.Model.TimeTable.Data;
import com.appnew.android.Model.TimeTable.TimeTableModel;
import com.appnew.android.Model.UrlObject;
import com.appnew.android.Model.Video;
import com.appnew.android.Model.YoutubeVideoData;
import com.appnew.android.Model.ZoomModel.CurrentAffairDataModel;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Payment.PurchaseActivity;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Theme.Adapter.DateTableAdapter;
import com.appnew.android.Theme.Adapter.TimeTableDateAdapter;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.GenericUtils;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.Progress;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.ZoomFeatureHelper;
import com.appnew.android.Webview.RevisionActivity;
import com.appnew.android.Webview.WebViewActivty;
import com.appnew.android.Zoom.Activity.ZoomRecodedPlayer;
import com.appnew.android.Zoom.ItemClickListener;
import com.appnew.android.base.bottom_sheets.DownloadYoutubeBottomSheet;
import com.appnew.android.base.dialogs.SimpleAlertDialogsKt;
import com.appnew.android.cleverTap.AnalyticHelper;
import com.appnew.android.folder.activity.FolderActivity;
import com.appnew.android.player.AudioPlayerActivity;
import com.appnew.android.player.music_player.MusicService;
import com.appnew.android.socket.models.ChatModel;
import com.appnew.android.table.TestTable;
import com.appnew.android.table.ThemeSettings;
import com.appnew.android.table.VideoTable;
import com.appnew.android.table.VideosDownload;
import com.appnew.android.testmodule.activity.ViewSolutionActivity;
import com.appnew.android.testmodule.model.InstructionData;
import com.appnew.android.testmodule.model.ResultTestSeries_Report;
import com.appnew.android.testmodule.model.TestBasicInst;
import com.appnew.android.testmodule.model.TestSectionInst;
import com.bumptech.glide.Glide;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.tv9news.utils.helpers.AnalyticEvents;
import com.tv9news.utils.helpers.AnalyticsConstants;
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes6.dex */
public class SingleStudyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements NetworkCall.MyNetworkCallBack {
    Activity activity;
    private String attemptOrReAttempt;
    BottomSetting bottomSetting;
    onButtonClicked buttonClicked;
    ArrayList<ChatModel> chatModel;
    String comboId;
    public String contentType;
    private String content_master;
    String content_type;
    private CouponPojo couponPojo;
    ArrayList<Courselist> courseDataArrayList;
    public ExamPrepItem examPrepItem;
    ArrayList<FaqData> faqData;
    private String first_attempt;
    boolean isCombo;
    private boolean isSSCpattern;
    String isSkip;
    String is_purchase;
    int lang;
    String[] langIds;
    LeftMenu leftMenu;
    long mLastClickTime;
    public String masterContent;
    OverviewData overviewData;
    String parentCourseId;
    int position_delete;
    onQuantityUpdate quantityUpdate;
    private String quiz_id;
    private String quiz_name;
    private String result_date;
    String revertAPI;
    CourseDetail singleStudy;
    private String submission_type;
    ThemeSettings themeSettings;
    String tileIdAPI;
    int tilePos;
    String tileTypeAPI;
    TimeTableModel timeTableModel;
    private String totalQuestion;
    public UtkashRoom utkashRoom;
    private ArrayList<Video> videoArrayList;
    private Lists videodata;
    Boolean isLodded = true;
    int selectedMarkReadPosition = -1;
    boolean isReAttemptOrPractice = false;

    public interface onButtonClicked {
        void onTitleClicked(TilesItem cards, List<TilesItem> tiles, int tilePos);
    }

    public interface onQuantityUpdate {
        void onQuantityDecreased(int currentCount);

        void onQuantityIncreased(int currentCount);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    public SingleStudyAdapter(Activity activity, CourseDetail singleStudy, ExamPrepItem examPrepItem, OverviewData overviewData, ArrayList<Courselist> courseDataArrayList, ArrayList<FaqData> faqData, onButtonClicked buttonClicked, onQuantityUpdate quantityUpdate, String parentCourseId, boolean isCombo, String isSkip, int tilePos, String tileIdAPI, String tileTypeAPI, String revertAPI, String content_type, String comboId, ArrayList<Video> videoArrayList, CouponPojo couponPojo, String content_master) {
        this.isCombo = false;
        this.tilePos = 0;
        this.is_purchase = "";
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        this.utkashRoom = appDatabase;
        this.result_date = "";
        this.submission_type = "";
        this.themeSettings = appDatabase.getthemeSettingdao().data();
        this.videoArrayList = new ArrayList<>();
        this.mLastClickTime = 0L;
        this.isSSCpattern = false;
        this.langIds = new String[]{"1"};
        this.singleStudy = singleStudy;
        this.activity = activity;
        this.examPrepItem = examPrepItem;
        this.overviewData = overviewData;
        this.buttonClicked = buttonClicked;
        this.courseDataArrayList = courseDataArrayList;
        this.faqData = faqData;
        this.parentCourseId = parentCourseId;
        this.isCombo = isCombo;
        this.isSkip = isSkip;
        this.tilePos = tilePos;
        this.tileTypeAPI = tileTypeAPI;
        this.tileIdAPI = tileIdAPI;
        this.revertAPI = revertAPI;
        this.content_type = content_type;
        this.comboId = comboId;
        this.is_purchase = singleStudy.getData().getCourseDetail().getIsPurchased();
        this.videoArrayList = videoArrayList;
        this.couponPojo = couponPojo;
        this.quantityUpdate = quantityUpdate;
        this.content_master = content_master;
    }

    public SingleStudyAdapter(TimeTableModel timeTableModel, Activity activity, CourseDetail singleStudy, ExamPrepItem examPrepItem, OverviewData overviewData, ArrayList<Courselist> courseDataArrayList, ArrayList<FaqData> faqData, onButtonClicked buttonClicked, String parentCourseId, boolean isCombo, String isSkip, int tilePos, String tileIdAPI, String tileTypeAPI, String revertAPI, String content_type, String comboId, ArrayList<Video> videoArrayList, CouponPojo couponPojo, onQuantityUpdate quantityUpdate) {
        this.isCombo = false;
        this.tilePos = 0;
        this.is_purchase = "";
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        this.utkashRoom = appDatabase;
        this.result_date = "";
        this.submission_type = "";
        this.themeSettings = appDatabase.getthemeSettingdao().data();
        this.videoArrayList = new ArrayList<>();
        this.mLastClickTime = 0L;
        this.isSSCpattern = false;
        this.langIds = new String[]{"1"};
        this.singleStudy = singleStudy;
        this.activity = activity;
        this.examPrepItem = examPrepItem;
        this.overviewData = overviewData;
        this.buttonClicked = buttonClicked;
        this.courseDataArrayList = courseDataArrayList;
        this.faqData = faqData;
        this.parentCourseId = parentCourseId;
        this.isCombo = isCombo;
        this.isSkip = isSkip;
        this.tilePos = tilePos;
        this.tileTypeAPI = tileTypeAPI;
        this.tileIdAPI = tileIdAPI;
        this.revertAPI = revertAPI;
        this.content_type = content_type;
        this.comboId = comboId;
        this.is_purchase = singleStudy.getData().getCourseDetail().getIsPurchased();
        this.videoArrayList = videoArrayList;
        this.couponPojo = couponPojo;
        this.timeTableModel = timeTableModel;
        this.quantityUpdate = quantityUpdate;
    }

    public SingleStudyAdapter(ArrayList<ChatModel> chatModel, Activity activity, CourseDetail singleStudy, ExamPrepItem examPrepItem, OverviewData overviewData, ArrayList<Courselist> courseDataArrayList, ArrayList<FaqData> faqData, onButtonClicked buttonClicked, String parentCourseId, boolean isCombo, String isSkip, int tilePos, String tileIdAPI, String tileTypeAPI, String revertAPI, String content_type, String comboId, ArrayList<Video> videoArrayList, CouponPojo couponPojo) {
        this.isCombo = false;
        this.tilePos = 0;
        this.is_purchase = "";
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        this.utkashRoom = appDatabase;
        this.result_date = "";
        this.submission_type = "";
        this.themeSettings = appDatabase.getthemeSettingdao().data();
        this.videoArrayList = new ArrayList<>();
        this.mLastClickTime = 0L;
        this.isSSCpattern = false;
        this.langIds = new String[]{"1"};
        this.singleStudy = singleStudy;
        this.activity = activity;
        this.examPrepItem = examPrepItem;
        this.overviewData = overviewData;
        this.buttonClicked = buttonClicked;
        this.courseDataArrayList = courseDataArrayList;
        this.faqData = faqData;
        this.parentCourseId = parentCourseId;
        this.isCombo = isCombo;
        this.isSkip = isSkip;
        this.tilePos = tilePos;
        this.tileTypeAPI = tileTypeAPI;
        this.tileIdAPI = tileIdAPI;
        this.revertAPI = revertAPI;
        this.content_type = content_type;
        this.comboId = comboId;
        this.is_purchase = singleStudy.getData().getCourseDetail().getIsPurchased();
        this.videoArrayList = videoArrayList;
        this.couponPojo = couponPojo;
        this.chatModel = chatModel;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewInflate;
        ThemeSettings themeSettingsData = this.utkashRoom.getthemeSettingdao().data();
        this.themeSettings = themeSettingsData;
        if (themeSettingsData != null) {
            this.themeSettings = this.utkashRoom.getthemeSettingdao().data();
            this.leftMenu = (LeftMenu) new Gson().fromJson(this.themeSettings.getLeft_menu(), LeftMenu.class);
            this.bottomSetting = (BottomSetting) new Gson().fromJson(this.themeSettings.getBottom(), BottomSetting.class);
        }
        if (viewType == 0) {
            if (this.singleStudy.getData().getCourseDetail().getCat_type().equalsIgnoreCase("1")) {
                return new SingleStudyHeaderHolderBook(LayoutInflater.from(this.activity).inflate(R.layout.exam_prep_header_book, (ViewGroup) null));
            }
            return new SingleStudyHeaderHolder(LayoutInflater.from(this.activity).inflate(R.layout.exam_prep_header, (ViewGroup) null));
        }
        if (viewType == 1) {
            if (SharedPreference.getInstance().getString(Const.GRIDVIEW_SUBJECT).equalsIgnoreCase("1") && this.tileTypeAPI.equalsIgnoreCase("content")) {
                if (this.isSkip.equalsIgnoreCase("0") || (this.isSkip.equalsIgnoreCase("2") && this.singleStudy.getData().getCourseDetail().getIsPurchased().equalsIgnoreCase("1"))) {
                    viewInflate = LayoutInflater.from(this.activity).inflate(R.layout.exam_prep_single_row_item_new, (ViewGroup) null);
                } else {
                    viewInflate = LayoutInflater.from(this.activity).inflate(R.layout.exam_prep_single_row_item, (ViewGroup) null);
                }
            } else {
                viewInflate = LayoutInflater.from(this.activity).inflate(R.layout.exam_prep_single_row_item, (ViewGroup) null);
            }
            return new SingleStudyListHolder(viewInflate);
        }
        if (viewType == 7) {
            return new SingleStudyPdfListHolder(LayoutInflater.from(this.activity).inflate(R.layout.exam_prep_single_row_item_pdf, (ViewGroup) null));
        }
        if (viewType == 8) {
            return new SingleStudyConceptListHolder(LayoutInflater.from(this.activity).inflate(R.layout.exam_prep_single_row_item_concept, (ViewGroup) null));
        }
        if (viewType == 4) {
            return new SingleStudyTestListHolder(LayoutInflater.from(this.activity).inflate(R.layout.exam_prep_single_row_item_test, (ViewGroup) null));
        }
        if (viewType == 3) {
            return new OverViewHolder(LayoutInflater.from(this.activity).inflate(R.layout.course_overview_layout, parent, false));
        }
        if (viewType == 6) {
            return new FAQViewHolder(LayoutInflater.from(this.activity).inflate(R.layout.faq_overview_layout, (ViewGroup) null));
        }
        if (viewType == 10) {
            return new SingleStudySubjectiveTestListHolder(LayoutInflater.from(this.activity).inflate(R.layout.exam_prep_single_row_item_subjective, (ViewGroup) null));
        }
        if (viewType == 5) {
            return new SingleStudyComboHolder(LayoutInflater.from(this.activity).inflate(R.layout.item_combo_tile_main, parent, false));
        }
        if (viewType == 9) {
            return new StudyNoDataViewHolder(LayoutInflater.from(this.activity).inflate(R.layout.no_data_found, (ViewGroup) null));
        }
        if (viewType == 11) {
            return new SingleStudySubjectiveTimeTableListHolder(LayoutInflater.from(this.activity).inflate(R.layout.custom_user_timetable, (ViewGroup) null));
        }
        if (viewType == 12) {
            return new SingleStudyGroupChatAdapter(LayoutInflater.from(this.activity).inflate(R.layout.item_group_chat_tile_main, parent, false));
        }
        if (viewType == 13) {
            return new FolderListView(LayoutInflater.from(this.activity).inflate(R.layout.item_group_chat_tile_main, parent, false));
        }
        if (viewType == 14) {
            return new MasterContentListView(LayoutInflater.from(this.activity).inflate(R.layout.item_group_chat_tile_main, parent, false));
        }
        return new StudyNoDataViewHolder(LayoutInflater.from(this.activity).inflate(R.layout.no_data_found, (ViewGroup) null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == 0) {
            if (this.singleStudy.getData().getCourseDetail().getCat_type().equalsIgnoreCase("1")) {
                ((SingleStudyHeaderHolderBook) holder).setDataHeader(this.singleStudy);
                return;
            } else {
                ((SingleStudyHeaderHolder) holder).setDataHeader(this.singleStudy);
                return;
            }
        }
        if (getItemViewType(position) == 3) {
            ((OverViewHolder) holder).setData(this.singleStudy.getData().getCourseDetail(), this.overviewData);
            return;
        }
        if (getItemViewType(position) == 1) {
            ((SingleStudyListHolder) holder).setData(this.examPrepItem.getList(), position);
            return;
        }
        if (getItemViewType(position) == 7) {
            ((SingleStudyPdfListHolder) holder).setData(this.examPrepItem.getList(), position);
            return;
        }
        if (getItemViewType(position) == 8) {
            ((SingleStudyConceptListHolder) holder).setData(this.examPrepItem.getList(), position);
            return;
        }
        if (getItemViewType(position) == 4) {
            ((SingleStudyTestListHolder) holder).setData(this.examPrepItem.getList(), position);
            return;
        }
        if (getItemViewType(position) == 5) {
            ((SingleStudyComboHolder) holder).setData(position);
            return;
        }
        if (getItemViewType(position) == 6) {
            ((FAQViewHolder) holder).setData(this.faqData);
            return;
        }
        if (getItemViewType(position) == 9) {
            ((StudyNoDataViewHolder) holder).setData();
            return;
        }
        if (getItemViewType(position) == 10) {
            ((SingleStudySubjectiveTestListHolder) holder).setData(this.examPrepItem.getList(), position - 1);
            return;
        }
        if (getItemViewType(position) == 11) {
            TimeTableModel timeTableModel = this.timeTableModel;
            if (timeTableModel == null || timeTableModel.getData().size() <= 0) {
                return;
            }
            ((SingleStudySubjectiveTimeTableListHolder) holder).setData(this.timeTableModel.getData(), position - 1);
            return;
        }
        if (getItemViewType(position) == 12) {
            ArrayList<ChatModel> arrayList = this.chatModel;
            if (arrayList != null) {
                ((SingleStudyGroupChatAdapter) holder).setData(arrayList);
                return;
            }
            return;
        }
        if (getItemViewType(position) == 13) {
            ((FolderListView) holder).setData(this.singleStudy.getData().getTiles());
        } else if (getItemViewType(position) == 14) {
            ((MasterContentListView) holder).setData(this.singleStudy.getData().getTiles());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        }
        if (this.contentType.equalsIgnoreCase(Const.BOOK + this.tileIdAPI)) {
            return 2;
        }
        if (this.contentType.equalsIgnoreCase(Const.OVERVIEW + this.tileIdAPI)) {
            return 3;
        }
        if (this.contentType.equalsIgnoreCase(Const.TEST + this.tileIdAPI)) {
            return 4;
        }
        if (this.contentType.equalsIgnoreCase(Const.COMBO + this.tileIdAPI)) {
            return 5;
        }
        if (this.contentType.equalsIgnoreCase(Const.FAQ + this.tileIdAPI)) {
            return 6;
        }
        if (this.contentType.equalsIgnoreCase(Const.PDF + this.tileIdAPI)) {
            return 7;
        }
        if (this.contentType.equalsIgnoreCase(Const.CONCEPT + this.tileIdAPI)) {
            return 8;
        }
        if (this.contentType.equalsIgnoreCase(Const.NO_DATA)) {
            return 9;
        }
        if (this.contentType.equalsIgnoreCase(Const.SUBJECTIVE_TEST + this.tileIdAPI) || this.contentType.equalsIgnoreCase(Const.Daily_assignment + this.tileIdAPI)) {
            return 10;
        }
        if (this.contentType.equalsIgnoreCase(Const.TIME_TABLE + this.tileIdAPI)) {
            return 11;
        }
        if (this.contentType.equalsIgnoreCase(Const.CHAT + this.tileIdAPI)) {
            return 12;
        }
        if (this.contentType.equalsIgnoreCase(Const.FOLDER + this.tileIdAPI)) {
            return 13;
        }
        if (this.contentType.equalsIgnoreCase(Const.CONTENT_MASTER + this.tileIdAPI)) {
            return 14;
        }
        return this.contentType.equalsIgnoreCase(new StringBuilder("header").append(this.tileIdAPI).toString()) ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.contentType.equalsIgnoreCase(Const.BOOK + this.tileIdAPI) || this.contentType.equalsIgnoreCase(Const.TIME_TABLE + this.tileIdAPI) || this.contentType.equalsIgnoreCase(Const.OVERVIEW + this.tileIdAPI) || this.contentType.equalsIgnoreCase(Const.COMBO + this.tileIdAPI) || this.contentType.equalsIgnoreCase(Const.FAQ + this.tileIdAPI) || this.contentType.equalsIgnoreCase(Const.CHAT + this.tileIdAPI) || this.contentType.equalsIgnoreCase(Const.CONTENT_MASTER + this.tileIdAPI)) {
            return 2;
        }
        if (this.contentType.equalsIgnoreCase("header" + this.tileIdAPI)) {
            return 1;
        }
        if (this.examPrepItem.getList() == null || this.examPrepItem.getList().size() <= 0) {
            return 2;
        }
        return this.examPrepItem.getList().size() + 1;
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        switch (apitype) {
            case "https://appapi.videocrypt.in/index.php/data_model/test/get_instructions":
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setTest_id(this.quiz_id);
                encryptionData.setCourse_id(this.singleStudy.getData().getCourseDetail().getId());
                return service.API_GET_TEST_INSTRUCTION_DATA(AES.encrypt(new Gson().toJson(encryptionData)));
            case "https://appapi.videocrypt.in/index.php/data_model/revision/delete_revision":
                EncryptionData encryptionData2 = new EncryptionData();
                encryptionData2.setRevision_id(this.videodata.getId());
                encryptionData2.setCourse_id(this.singleStudy.getData().getCourseDetail().getId());
                return service.delete_revision(AES.encrypt(new Gson().toJson(encryptionData2)));
            case "https://appapi.videocrypt.in/index.php/data_model/master_hit/video_markread":
                EncryptionData encryptionData3 = new EncryptionData();
                encryptionData3.setVideo_id(this.videodata.getId());
                encryptionData3.setCourse_id(this.videodata.getPayload().getCourse_id());
                return service.markReadVideoType1_7(AES.encrypt(new Gson().toJson(encryptionData3)));
            case "https://appapi.videocrypt.in/index.php/data_model/test/get_test_data":
                EncryptionData encryptionData4 = new EncryptionData();
                encryptionData4.setTest_id(this.quiz_id);
                encryptionData4.setCourse_id(this.singleStudy.getData().getCourseDetail().getId());
                return service.API_GET_INFO_TEST_SERIES(AES.encrypt(new Gson().toJson(encryptionData4)));
            default:
                return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02dd A[Catch: Exception -> 0x030b, TryCatch #0 {Exception -> 0x030b, blocks: (B:69:0x0168, B:71:0x0176, B:73:0x017f, B:75:0x0183, B:77:0x019a, B:79:0x01ab, B:81:0x01bc, B:83:0x01d8, B:84:0x01db, B:106:0x02f2, B:80:0x01ba, B:76:0x018f, B:87:0x021c, B:89:0x0226, B:91:0x0234, B:93:0x023d, B:95:0x0250, B:97:0x0267, B:99:0x0278, B:101:0x0289, B:103:0x02a5, B:104:0x02a8, B:100:0x0287, B:96:0x025c, B:105:0x02dd, B:107:0x02f6), top: B:160:0x00a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:4:0x001a  */
    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void SuccessCallBack(org.json.JSONObject r25, java.lang.String r26, java.lang.String r27, boolean r28) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 1216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Courses.Adapter.SingleStudyAdapter.SuccessCallBack(org.json.JSONObject, java.lang.String, java.lang.String, boolean):void");
    }

    private void pushEvent() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("date", AnalyticHelper.INSTANCE.getCurrentDateTimeForEvent());
        map.put("user_id", AnalyticHelper.INSTANCE.getUserId());
        map.put(AnalyticsConstants.device_type, AnalyticHelper.INSTANCE.getDeviceType());
        map.put(AnalyticsConstants.test_name, this.quiz_name);
        map.put("test_id", this.quiz_id);
        map.put(AnalyticsConstants.content_flag, getContentAccess());
        AnalyticEvents.INSTANCE.pushEvents(this.activity, AnalyticsConstants.TEST_ATTEMPT, map);
    }

    private String getContentAccess() {
        Lists lists;
        CourseDetail courseDetail = this.singleStudy;
        return ((courseDetail == null || courseDetail.getData() == null || this.singleStudy.getData().getCourseDetail() == null || TextUtils.isEmpty(this.singleStudy.getData().getCourseDetail().getIsPurchased()) || !this.singleStudy.getData().getCourseDetail().getIsPurchased().equals("1")) && (lists = this.videodata) != null && !TextUtils.isEmpty(lists.getIs_locked()) && this.videodata.getIs_locked().equals("1")) ? "Paid" : "Free";
    }

    private void showPopUp(final InstructionData instructionData) {
        Dialog dialog;
        CheckBox checkBox;
        int i;
        View viewInflate = ((LayoutInflater) this.activity.getSystemService("layout_inflater")).inflate(R.layout.popup_basicinfo_quiz_career, (ViewGroup) null, false);
        Dialog dialog2 = new Dialog(this.activity, R.style.CustomAlertDialog);
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
            this.langIds = testBasic.getLang_id().split(Constants.SEPARATOR_COMMA);
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
                textView5.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SingleStudyAdapter singleStudyAdapter = SingleStudyAdapter.this;
                        TextView textView9 = textView5;
                        TestBasicInst testBasicInst = testBasic;
                        TextView textView10 = textView8;
                        singleStudyAdapter.showPopMenuForLangauge(textView9, testBasicInst, textView10, textView10);
                    }
                });
            }
            if (testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("1")) {
                textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[0]);
                this.lang = Integer.parseInt(testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
            } else if (testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("2")) {
                textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[1]);
                this.lang = Integer.parseInt(testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
            }
        } else {
            if (testBasic.getLang_id().length() > 2) {
                textView5.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SingleStudyAdapter.this.showPopMenuForLangauge(textView8, textView5, testBasic);
                    }
                });
            }
            if (testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("1")) {
                textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[0]);
                this.lang = Integer.parseInt(testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
            } else if (testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("2")) {
                textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[1]);
                this.lang = Integer.parseInt(testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
            } else if (testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("3")) {
                textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[2]);
                this.lang = Integer.parseInt(testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
            } else if (testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("9")) {
                textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[3]);
                this.lang = Integer.parseInt(testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
            } else if (testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("6")) {
                textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[4]);
                this.lang = Integer.parseInt(testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
            } else if (testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("10")) {
                textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[5]);
                this.lang = Integer.parseInt(testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
            } else if (testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("11")) {
                textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[6]);
                this.lang = Integer.parseInt(testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
            } else if (testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("12")) {
                textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[7]);
                this.lang = Integer.parseInt(testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
            } else if (testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("5")) {
                textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[8]);
                this.lang = Integer.parseInt(testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
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
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showPopUp$0(testBasic, checkBox3, dialog3, view);
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
    public /* synthetic */ void lambda$showPopUp$0(TestBasicInst testBasicInst, CheckBox checkBox, Dialog dialog, View view) {
        if (testBasicInst.getTotalQuestions().equalsIgnoreCase("0")) {
            Activity activity = this.activity;
            Toast.makeText(activity, activity.getResources().getString(R.string.please_add_question), 0).show();
        } else if (checkBox.isChecked()) {
            dialog.dismiss();
            this.quiz_id = testBasicInst.getId();
            new NetworkCall(this, this.activity).NetworkAPICall(API.API_GET_INFO_TEST_SERIES, "", true, false);
        } else {
            Activity activity2 = this.activity;
            Toast.makeText(activity2, activity2.getResources().getString(R.string.please_check_following_instructions), 0).show();
        }
    }

    private void addSectionView(LinearLayout sectionListLL, InstructionData instructionData) {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (TestSectionInst testSectionInst : instructionData.getTestSections()) {
            String sectionId = testSectionInst.getSectionId();
            float floatSafe = Helper.parseFloatSafe(testSectionInst.getSectionTiming());
            if (map.containsKey(sectionId)) {
                map.merge(sectionId, Float.valueOf(floatSafe), new BiFunction() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$$ExternalSyntheticLambda9
                    @Override // java.util.function.BiFunction
                    public final Object apply(Object obj, Object obj2) {
                        return Float.valueOf(Float.sum(((Float) obj).floatValue(), ((Float) obj2).floatValue()));
                    }
                });
            } else {
                map.put(sectionId, Float.valueOf(floatSafe));
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
        int intSafe;
        ArrayList arrayList = new ArrayList();
        LinearLayout linearLayout = (LinearLayout) View.inflate(this.activity, R.layout.layout_option_section_list_view, null);
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

    public void showPopMenuForLangauge(final View v, final TestBasicInst testBasicInst, final TextView v1, TextView vv) {
        PopupMenu popupMenu = new PopupMenu(this.activity, v);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$$ExternalSyntheticLambda10
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return this.f$0.lambda$showPopMenuForLangauge$1(v, testBasicInst, v1, menuItem);
            }
        });
        for (int i = 0; i < testBasicInst.getLang_id().split(Constants.SEPARATOR_COMMA).length; i++) {
            if (testBasicInst.getLang_id().split(Constants.SEPARATOR_COMMA)[i].equals("1")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[0]);
            } else if (testBasicInst.getLang_id().split(Constants.SEPARATOR_COMMA)[i].equals("2")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[1]);
            }
        }
        popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$showPopMenuForLangauge$1(View view, TestBasicInst testBasicInst, TextView textView, MenuItem menuItem) {
        ((TextView) view).setText(menuItem.getTitle().toString());
        if (menuItem.getTitle().toString().equals(this.activity.getResources().getString(R.string.hindi))) {
            this.lang = 2;
            if (testBasicInst.getMulti_description().size() > 0 && testBasicInst.getMulti_description().get(1).getDescription() != null) {
                textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(1).getDescription()));
            }
        } else if (menuItem.getTitle().toString().equals(this.activity.getResources().getString(R.string.english))) {
            this.lang = 1;
            if (testBasicInst.getMulti_description().size() > 0) {
                textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(0).getDescription()));
            }
        }
        return false;
    }

    public void showPopMenuForLangauge(final TextView textView, final View v, final TestBasicInst testBasicInst) {
        PopupMenu popupMenu = new PopupMenu(this.activity, v);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$$ExternalSyntheticLambda8
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return this.f$0.lambda$showPopMenuForLangauge$2(v, testBasicInst, textView, menuItem);
            }
        });
        for (int i = 0; i < testBasicInst.getLang_id().split(Constants.SEPARATOR_COMMA).length; i++) {
            if (testBasicInst.getLang_id().split(Constants.SEPARATOR_COMMA)[i].equals("1")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[0]);
            } else if (testBasicInst.getLang_id().split(Constants.SEPARATOR_COMMA)[i].equals("2")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[1]);
            } else if (testBasicInst.getLang_id().split(Constants.SEPARATOR_COMMA)[i].equals("3")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[2]);
            } else if (testBasicInst.getLang_id().split(Constants.SEPARATOR_COMMA)[i].equals("9")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[3]);
            } else if (testBasicInst.getLang_id().split(Constants.SEPARATOR_COMMA)[i].equals("6")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[4]);
            } else if (testBasicInst.getLang_id().split(Constants.SEPARATOR_COMMA)[i].equals("10")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[5]);
            } else if (testBasicInst.getLang_id().split(Constants.SEPARATOR_COMMA)[i].equals("11")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[6]);
            } else if (testBasicInst.getLang_id().split(Constants.SEPARATOR_COMMA)[i].equals("12")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[7]);
            } else if (testBasicInst.getLang_id().split(Constants.SEPARATOR_COMMA)[i].equals("5")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[8]);
            }
        }
        popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$showPopMenuForLangauge$2(View view, TestBasicInst testBasicInst, TextView textView, MenuItem menuItem) {
        ((TextView) view).setText(menuItem.getTitle().toString());
        if (menuItem.getTitle().toString().equals(this.activity.getResources().getString(R.string.hindi))) {
            this.lang = 2;
            if (testBasicInst.getDescription().isEmpty() || testBasicInst.getDescription_2().isEmpty()) {
                return false;
            }
            textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
            return false;
        }
        if (menuItem.getTitle().toString().equals(this.activity.getResources().getString(R.string.english))) {
            this.lang = 1;
            if (testBasicInst.getDescription().isEmpty()) {
                return false;
            }
            textView.setText(Html.fromHtml(testBasicInst.getDescription()));
            return false;
        }
        if (menuItem.getTitle().toString().equals(this.activity.getResources().getString(R.string.kannada))) {
            this.lang = 3;
            return false;
        }
        if (menuItem.getTitle().toString().equals(this.activity.getResources().getString(R.string.urdu))) {
            this.lang = 9;
            return false;
        }
        if (menuItem.getTitle().toString().equals(this.activity.getResources().getString(R.string.oriya))) {
            this.lang = 6;
            return false;
        }
        if (menuItem.getTitle().toString().equals(this.activity.getResources().getString(R.string.bangauli))) {
            this.lang = 10;
            return false;
        }
        if (menuItem.getTitle().toString().equals(this.activity.getResources().getString(R.string.assami))) {
            this.lang = 11;
            return false;
        }
        if (menuItem.getTitle().toString().equals(this.activity.getResources().getString(R.string.gujrati))) {
            this.lang = 12;
            return false;
        }
        if (!menuItem.getTitle().toString().equals(this.activity.getResources().getString(R.string.marathi))) {
            return false;
        }
        this.lang = 5;
        return false;
    }

    public class SingleStudyHeaderHolder extends RecyclerView.ViewHolder {
        TextView authorname;
        LinearLayout buyNowButton_RL;
        TextView course_name;
        ImageView coursebg;
        TextView courseid;
        LinearLayout demoVideoLL;
        TextView headSyllabus_TV;
        TextView headVideo_TV;
        RelativeLayout headerLL;
        LinearLayout imageRL;
        LinearLayout ll_scholorship_discount;
        LinearLayout rateYouLL;
        TextView ratingCount;
        TextView scholarshipCouponTV;
        LinearLayout syllabusLL;
        RecyclerView tileRv;
        TextView type;
        TextView validityTV;

        public SingleStudyHeaderHolder(View itemView) {
            super(itemView);
            this.headerLL = (RelativeLayout) itemView.findViewById(R.id.headerLL);
            this.tileRv = (RecyclerView) itemView.findViewById(R.id.tileRv);
            this.imageRL = (LinearLayout) itemView.findViewById(R.id.imageRL);
            this.coursebg = (ImageView) itemView.findViewById(R.id.courseImagebg);
            this.course_name = (TextView) itemView.findViewById(R.id.course_name);
            this.authorname = (TextView) itemView.findViewById(R.id.authorname);
            this.courseid = (TextView) itemView.findViewById(R.id.courseid);
            this.type = (TextView) itemView.findViewById(R.id.type);
            this.validityTV = (TextView) itemView.findViewById(R.id.validityTV);
            this.ll_scholorship_discount = (LinearLayout) itemView.findViewById(R.id.ll_scholorship_discount);
            this.scholarshipCouponTV = (TextView) itemView.findViewById(R.id.scholarshipCouponTV);
            this.buyNowButton_RL = (LinearLayout) itemView.findViewById(R.id.buyNowButton_RL);
            this.rateYouLL = (LinearLayout) itemView.findViewById(R.id.rateYouLL);
            this.ratingCount = (TextView) itemView.findViewById(R.id.ratingCount);
            this.demoVideoLL = (LinearLayout) itemView.findViewById(R.id.demoVideoLL);
            this.syllabusLL = (LinearLayout) itemView.findViewById(R.id.syllabusLL);
            this.headSyllabus_TV = (TextView) itemView.findViewById(R.id.headSyllabus_TV);
            this.headVideo_TV = (TextView) itemView.findViewById(R.id.headVideo_TV);
        }

        public void changeThemeColor(String color) {
            if (!color.contains(":") || color.split(":").length <= 1) {
                return;
            }
            SharedPreference.getInstance().putString("theme_color_hai_bhai", color);
            this.headerLL.setBackgroundColor(Color.parseColor(color.split(":")[0]));
            this.course_name.setTextColor(Color.parseColor(color.split(":")[1]));
            this.authorname.setTextColor(Color.parseColor(color.split(":")[1]));
            this.validityTV.setTextColor(Color.parseColor(color.split(":")[1]));
        }

        public void setDataHeader(CourseDetail singleStudy) {
            boolean z;
            if (BuildConfig.FLAVOR.equalsIgnoreCase("abhinayMathsOnline")) {
                setDemoVideo(singleStudy);
            }
            boolean z2 = true;
            if (SingleStudyAdapter.this.couponPojo != null && SingleStudyAdapter.this.couponPojo.getAvailable() != null) {
                if (SingleStudyAdapter.this.couponPojo == null || SingleStudyAdapter.this.couponPojo.getAvailable() == null || SingleStudyAdapter.this.couponPojo.getAvailable().size() <= 0) {
                    z = false;
                } else {
                    z = false;
                    for (Available available : SingleStudyAdapter.this.couponPojo.getAvailable()) {
                        if (available.getCourses().size() > 0) {
                            Iterator<CoursesCoupon> it = available.getCourses().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (singleStudy.getData().getCourseDetail().getId().equalsIgnoreCase(it.next().getId()) && Long.parseLong(available.getEnd()) * 1000 > Calendar.getInstance().getTimeInMillis()) {
                                        String coupon_value = available.getCoupon_value();
                                        String coupon_type = available.getCoupon_type();
                                        if (!TextUtils.isEmpty(coupon_value) && Integer.parseInt(coupon_value) > 0) {
                                            z = true;
                                        }
                                        if (coupon_type.equalsIgnoreCase("1")) {
                                            this.scholarshipCouponTV.setText("You will get " + SingleStudyAdapter.this.activity.getResources().getString(R.string.rupees) + coupon_value + " scholarship if you will enroll this course.");
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
            }
            if (SingleStudyAdapter.this.bottomSetting != null && SingleStudyAdapter.this.bottomSetting.getLayout_type() != null && SingleStudyAdapter.this.bottomSetting.getLayout_type().equals("1")) {
                ((ConstraintLayout.LayoutParams) this.coursebg.getLayoutParams()).dimensionRatio = "1:1";
            }
            if (singleStudy.getData().getCourseDetail().getIsPurchased().equalsIgnoreCase("1")) {
                this.headerLL.setBackgroundColor(SingleStudyAdapter.this.activity.getResources().getColor(R.color.white));
                this.imageRL.setVisibility(8);
                if (SharedPreference.getInstance().getString("theme_color_hai_bhai") != null && !TextUtils.isEmpty(SharedPreference.getInstance().getString("theme_color_hai_bhai"))) {
                    String string = SharedPreference.getInstance().getString("theme_color_hai_bhai");
                    this.course_name.setTextColor(Color.parseColor(string.split(":")[1]));
                    this.authorname.setTextColor(Color.parseColor(string.split(":")[1]));
                    this.validityTV.setTextColor(Color.parseColor(string.split(":")[1]));
                }
            } else {
                if (SingleStudyAdapter.this.content_master != null && SingleStudyAdapter.this.content_master.equalsIgnoreCase("content_master002")) {
                    this.headerLL.setBackgroundColor(SingleStudyAdapter.this.activity.getResources().getColor(R.color.white));
                    this.imageRL.setVisibility(8);
                    if (SharedPreference.getInstance().getString("theme_color_hai_bhai") != null && !TextUtils.isEmpty(SharedPreference.getInstance().getString("theme_color_hai_bhai"))) {
                        String string2 = SharedPreference.getInstance().getString("theme_color_hai_bhai");
                        this.course_name.setTextColor(Color.parseColor(string2.split(":")[1]));
                        this.authorname.setTextColor(Color.parseColor(string2.split(":")[1]));
                        this.validityTV.setTextColor(Color.parseColor(string2.split(":")[1]));
                    }
                } else if (!BuildConfig.FLAVOR.equalsIgnoreCase("resodigital")) {
                    this.headerLL.setBackgroundColor(SingleStudyAdapter.this.activity.getResources().getColor(R.color.colorPrimaryDark));
                } else if (SharedPreference.getInstance().getString("theme_color_hai_bhai") != null && !TextUtils.isEmpty(SharedPreference.getInstance().getString("theme_color_hai_bhai"))) {
                    changeThemeColor(SharedPreference.getInstance().getString("theme_color_hai_bhai"));
                }
                this.imageRL.setVisibility(0);
                if (!TextUtils.isEmpty(singleStudy.getData().getCourseDetail().getDescHeaderImage())) {
                    Helper.setThumbnailImage(SingleStudyAdapter.this.activity, singleStudy.getData().getCourseDetail().getDescHeaderImage(), SingleStudyAdapter.this.activity.getResources().getDrawable(R.mipmap.placeholder_course), this.coursebg);
                } else {
                    this.coursebg.setImageResource(R.mipmap.placeholder_course);
                }
                if (singleStudy.getData().getCourseDetail() != null) {
                    this.course_name.setText(singleStudy.getData().getCourseDetail().getTitle());
                    if (!GenericUtils.isEmpty(singleStudy.getData().getCourseDetail().getAuthor().getTitle()) && !singleStudy.getData().getCourseDetail().getAuthor().getTitle().equalsIgnoreCase("Utkarsh classes")) {
                        this.authorname.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.by) + singleStudy.getData().getCourseDetail().getAuthor().getTitle());
                    } else {
                        this.authorname.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.by) + SingleStudyAdapter.this.activity.getResources().getString(R.string.app_name));
                    }
                    if (singleStudy.getData().getCourseDetail().getValidity().equals("") || singleStudy.getData().getCourseDetail().getValidity().equals("0") || singleStudy.getData().getCourseDetail().getValidity().equalsIgnoreCase("0 Days") || singleStudy.getData().getCourseDetail().getValidity().equals("-1") || singleStudy.getData().getCourseDetail().getValidity().equalsIgnoreCase("-1 Days")) {
                        this.validityTV.setVisibility(8);
                    } else if (singleStudy.getData().getCourseDetail().getCat_type().equalsIgnoreCase("3") || singleStudy.getData().getCourseDetail().getCat_type().equalsIgnoreCase("1")) {
                        this.validityTV.setVisibility(4);
                    } else if (singleStudy.getData().getCourseDetail().getIs_trial() != null && !singleStudy.getData().getCourseDetail().getIs_trial().equalsIgnoreCase("0")) {
                        this.validityTV.setVisibility(4);
                    } else {
                        this.validityTV.setVisibility(0);
                    }
                    this.imageRL.setVisibility(0);
                    if (SingleStudyAdapter.this.bottomSetting != null && SingleStudyAdapter.this.bottomSetting.getLayout_type() != null && SingleStudyAdapter.this.bottomSetting.getLayout_type().equals("1")) {
                        if (!TextUtils.isEmpty(singleStudy.getData().getCourseDetail().getCover_image())) {
                            Helper.setThumbnailImage(SingleStudyAdapter.this.activity, singleStudy.getData().getCourseDetail().getCover_image(), SingleStudyAdapter.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.coursebg);
                        } else {
                            this.coursebg.setImageResource(R.mipmap.square_placeholder);
                        }
                    } else if (!TextUtils.isEmpty(singleStudy.getData().getCourseDetail().getDescHeaderImage())) {
                        Helper.setThumbnailImage(SingleStudyAdapter.this.activity, singleStudy.getData().getCourseDetail().getDescHeaderImage(), SingleStudyAdapter.this.activity.getResources().getDrawable(R.mipmap.placeholder_course), this.coursebg);
                    } else {
                        this.coursebg.setImageResource(R.mipmap.placeholder_course);
                    }
                    this.validityTV.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.validity_) + singleStudy.getData().getCourseDetail().getValidity());
                    this.courseid.setText(singleStudy.getData().getCourseDetail().getId());
                    if (singleStudy.getData().getCourseDetail().getViewType().equalsIgnoreCase("0")) {
                        this.type.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.online));
                    } else if (singleStudy.getData().getCourseDetail().getViewType().equalsIgnoreCase("1")) {
                        this.type.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.offline));
                    } else if (singleStudy.getData().getCourseDetail().getViewType().equalsIgnoreCase("2")) {
                        this.type.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.package_));
                    }
                    if (BuildConfig.FLAVOR.equalsIgnoreCase("DishaPublication")) {
                        this.authorname.setVisibility(4);
                        this.validityTV.setVisibility(4);
                    }
                    if (BuildConfig.FLAVOR.equalsIgnoreCase("Narayana")) {
                        this.authorname.setVisibility(8);
                    }
                    if (singleStudy.getData().getCourseDetail().getHide_validity() != null && singleStudy.getData().getCourseDetail().getHide_validity().equalsIgnoreCase("1")) {
                        this.validityTV.setVisibility(8);
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            new ArrayList();
            if (singleStudy.getData() != null && singleStudy.getData().getTiles() != null) {
                Iterator<TilesItem> it2 = singleStudy.getData().getTiles().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (it2.next().getType().equalsIgnoreCase(Const.COMBO)) {
                            break;
                        }
                    } else {
                        z2 = false;
                        break;
                    }
                }
                for (TilesItem tilesItem : singleStudy.getData().getTiles()) {
                    if (SingleStudyAdapter.this.content_type != null) {
                        if (SingleStudyAdapter.this.content_type.equalsIgnoreCase("1")) {
                            if (!tilesItem.getType().equalsIgnoreCase("content")) {
                                arrayList.add(tilesItem);
                            }
                        } else if (singleStudy.getData().getCourseDetail().getIsPurchased().equalsIgnoreCase("1")) {
                            if (TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.SAME_CONTENT_VIEW)) || !SharedPreference.getInstance().getString(Const.SAME_CONTENT_VIEW).equalsIgnoreCase("1")) {
                                if (SharedPreference.getInstance().getBoolean("Expert_key")) {
                                    if (tilesItem.getType().equalsIgnoreCase(Const.OVERVIEW) || tilesItem.getType().equalsIgnoreCase(Const.FAQ) || tilesItem.getType().equalsIgnoreCase("content") || tilesItem.getType().equalsIgnoreCase(Const.COMBO) || tilesItem.getType().equalsIgnoreCase(Const.PDF)) {
                                        arrayList.add(tilesItem);
                                    }
                                } else if (tilesItem.getType().equalsIgnoreCase(Const.OVERVIEW) || tilesItem.getType().equalsIgnoreCase(Const.FAQ) || tilesItem.getType().equalsIgnoreCase("content") || tilesItem.getType().equalsIgnoreCase(Const.COMBO) || tilesItem.getType().equalsIgnoreCase(Const.TIME_TABLE) || tilesItem.getType().equalsIgnoreCase(Const.FOLDER) || tilesItem.getType().equalsIgnoreCase(Const.CHAT)) {
                                    arrayList.add(tilesItem);
                                }
                            } else if (z2) {
                                if (tilesItem.getType().equalsIgnoreCase(Const.OVERVIEW) || tilesItem.getType().equalsIgnoreCase(Const.FAQ) || tilesItem.getType().equalsIgnoreCase(Const.COMBO) || tilesItem.getType().equalsIgnoreCase(Const.CHAT)) {
                                    arrayList.add(tilesItem);
                                }
                            } else if (!tilesItem.getType().equalsIgnoreCase("content")) {
                                arrayList.add(tilesItem);
                            }
                        } else if (!tilesItem.getType().equalsIgnoreCase(Const.NO_DATA)) {
                            if (SingleStudyAdapter.this.comboId != null && SingleStudyAdapter.this.comboId.equalsIgnoreCase("")) {
                                if (!tilesItem.getType().equalsIgnoreCase("content")) {
                                    arrayList.add(tilesItem);
                                }
                            } else {
                                arrayList.add(tilesItem);
                            }
                        }
                    } else if (singleStudy.getData().getCourseDetail().getIsPurchased().equalsIgnoreCase("1")) {
                        if (TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.SAME_CONTENT_VIEW)) || !SharedPreference.getInstance().getString(Const.SAME_CONTENT_VIEW).equalsIgnoreCase("1")) {
                            if (tilesItem.getType().equalsIgnoreCase(Const.OVERVIEW) || tilesItem.getType().equalsIgnoreCase(Const.FAQ) || tilesItem.getType().equalsIgnoreCase("content") || tilesItem.getType().equalsIgnoreCase(Const.COMBO) || tilesItem.getType().equalsIgnoreCase(Const.FOLDER)) {
                                arrayList.add(tilesItem);
                            }
                        } else if (z2) {
                            if (tilesItem.getType().equalsIgnoreCase(Const.OVERVIEW) || tilesItem.getType().equalsIgnoreCase(Const.FAQ) || tilesItem.getType().equalsIgnoreCase(Const.COMBO) || tilesItem.getType().equalsIgnoreCase(Const.CHAT)) {
                                arrayList.add(tilesItem);
                            }
                        } else if (!tilesItem.getType().equalsIgnoreCase("content")) {
                            arrayList.add(tilesItem);
                        }
                    } else {
                        arrayList.add(tilesItem);
                    }
                }
            }
            if (SingleStudyAdapter.this.content_master == null || !SingleStudyAdapter.this.content_master.equalsIgnoreCase("content_master002")) {
                if (SharedPreference.getInstance().getString(Const.TILE_CONTENT_MANAGE) != null && SharedPreference.getInstance().getString(Const.TILE_CONTENT_MANAGE).equalsIgnoreCase("1")) {
                    ArrayList arrayListShotContentList = shotContentList(arrayList);
                    arrayList.clear();
                    arrayList = arrayListShotContentList;
                }
                TileItemsAdapter tileItemsAdapter = new TileItemsAdapter(SingleStudyAdapter.this.activity, arrayList);
                this.tileRv.setLayoutManager(new LinearLayoutManager(SingleStudyAdapter.this.activity, 0, false));
                this.tileRv.setAdapter(tileItemsAdapter);
                this.tileRv.setNestedScrollingEnabled(false);
                this.tileRv.scrollToPosition(SingleStudyAdapter.this.tilePos);
            }
        }

        public ArrayList shotFolderList(ArrayList<TilesItem> cardsArrayList) {
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
                TilesItem tilesItem = new TilesItem("1#0#0#0", "Content", PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY, Const.FOLDER, "", "1", "");
                int i2 = 0;
                while (true) {
                    if (i2 >= arrayList.size()) {
                        i2 = -1;
                        break;
                    }
                    if (((TilesItem) arrayList.get(i2)).getType().equalsIgnoreCase(Const.OVERVIEW)) {
                        break;
                    }
                    i2++;
                }
                if (i2 != -1) {
                    arrayList.add(i2 + 1, tilesItem);
                    return arrayList;
                }
                arrayList.add(0, tilesItem);
            }
            return arrayList;
        }

        public ArrayList shotContentList(ArrayList<TilesItem> cardsArrayList) {
            ArrayList arrayList = new ArrayList();
            Iterator<TilesItem> it = cardsArrayList.iterator();
            while (it.hasNext()) {
                if (it.next().getType().equals(Const.FOLDER)) {
                    return shotFolderList(cardsArrayList);
                }
            }
            boolean z = false;
            for (int i = 0; i < cardsArrayList.size(); i++) {
                if (cardsArrayList.get(i).getType().equalsIgnoreCase(Const.OVERVIEW) || cardsArrayList.get(i).getType().equalsIgnoreCase(Const.FAQ) || cardsArrayList.get(i).getType().equalsIgnoreCase("content") || cardsArrayList.get(i).getType().equalsIgnoreCase(Const.COMBO) || cardsArrayList.get(i).getType().equalsIgnoreCase(Const.TIME_TABLE) || cardsArrayList.get(i).getType().equalsIgnoreCase(Const.LIVE_VIDEO) || cardsArrayList.get(i).getType().equalsIgnoreCase(Const.UPCOMING_VIDEO) || cardsArrayList.get(i).getType().equalsIgnoreCase(Const.CHAT)) {
                    arrayList.add(cardsArrayList.get(i));
                } else {
                    z = true;
                }
            }
            if (z) {
                arrayList.add(new TilesItem("1#0#0#0", "Content", "002", Const.CONTENT_MASTER, "", "1", ""));
            }
            return arrayList;
        }

        private void setDemoVideo(final CourseDetail singleStudy) {
            for (int i = 0; i < singleStudy.getData().getTiles().size(); i++) {
                if (singleStudy.getData().getTiles().get(i).getSet_as_demo() != null && singleStudy.getData().getTiles().get(i).getSet_as_demo().equalsIgnoreCase("1")) {
                    if (singleStudy.getData().getTiles().get(i).getType().equalsIgnoreCase("video")) {
                        this.demoVideoLL.setVisibility(0);
                        this.headVideo_TV.setText(singleStudy.getData().getTiles().get(i).getTileName());
                    } else if (singleStudy.getData().getTiles().get(i).getType().equalsIgnoreCase(Const.PDF)) {
                        this.syllabusLL.setVisibility(0);
                        this.headSyllabus_TV.setText(singleStudy.getData().getTiles().get(i).getTileName());
                    }
                }
            }
            if (singleStudy.getData().getCourseDetail().getUser_rated() != null && !singleStudy.getData().getCourseDetail().getUser_rated().equalsIgnoreCase("0")) {
                this.ratingCount.setText(singleStudy.getData().getCourseDetail().getUser_rated());
                this.rateYouLL.setVisibility(0);
            } else {
                this.rateYouLL.setVisibility(8);
            }
            this.demoVideoLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter.SingleStudyHeaderHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    for (int i2 = 0; i2 < singleStudy.getData().getTiles().size(); i2++) {
                        if (singleStudy.getData().getTiles().get(i2).getSet_as_demo() != null && singleStudy.getData().getTiles().get(i2).getSet_as_demo().equalsIgnoreCase("1") && singleStudy.getData().getTiles().get(i2).getType().equalsIgnoreCase("video")) {
                            SingleStudyAdapter.this.buttonClicked.onTitleClicked(singleStudy.getData().getTiles().get(i2), singleStudy.getData().getTiles(), i2);
                        }
                    }
                }
            });
            this.syllabusLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter.SingleStudyHeaderHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    for (int i2 = 0; i2 < singleStudy.getData().getTiles().size(); i2++) {
                        if (singleStudy.getData().getTiles().get(i2).getSet_as_demo() != null && singleStudy.getData().getTiles().get(i2).getSet_as_demo().equalsIgnoreCase("1") && singleStudy.getData().getTiles().get(i2).getType().equalsIgnoreCase(Const.PDF)) {
                            SingleStudyAdapter.this.buttonClicked.onTitleClicked(singleStudy.getData().getTiles().get(i2), singleStudy.getData().getTiles(), i2);
                        }
                    }
                }
            });
        }

        public class TileItemsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
            private List<TilesItem> cards;
            private Context context;
            private String viewType;

            public TileItemsAdapter(Context context, ArrayList<TilesItem> cards) {
                this.cards = cards;
                this.context = context;
            }

            public TileItemsAdapter(Context context, ArrayList<TilesItem> cards, String viewType) {
                this.cards = cards;
                this.context = context;
                this.viewType = viewType;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                if (viewType == 1) {
                    return new ListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_folder_type, parent, false));
                }
                return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_tiles_theme_2, parent, false));
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
                if (getItemViewType(position) == 1) {
                    ((ListViewHolder) holder).setData(position);
                } else {
                    ((MyViewHolder) holder).setData(position);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemViewType(int i) {
                String str = this.viewType;
                if (str != null) {
                    return str.equalsIgnoreCase("1") ? 1 : 0;
                }
                return 0;
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

                public void setData(final int position) {
                    final TilesItem tilesItem = (TilesItem) TileItemsAdapter.this.cards.get(position);
                    if (tilesItem != null && !TextUtils.isEmpty(tilesItem.getType()) && tilesItem.getType().equalsIgnoreCase(Const.LIVE_VIDEO)) {
                        try {
                            this.liveIv.setVisibility(0);
                            Glide.with(SingleStudyAdapter.this.activity).asGif().load(Integer.valueOf(R.mipmap.live)).into(this.liveIv);
                        } catch (Exception unused) {
                            this.liveIv.setVisibility(8);
                        }
                        this.tilesText.setPadding(Math.round(Helper.convertDpToPixel(4, TileItemsAdapter.this.context)), Math.round(Helper.convertDpToPixel(8, TileItemsAdapter.this.context)), Math.round(Helper.convertDpToPixel(4, TileItemsAdapter.this.context)), Math.round(Helper.convertDpToPixel(8, TileItemsAdapter.this.context)));
                    } else {
                        this.liveIv.setVisibility(8);
                        this.tilesText.setPadding(Math.round(Helper.convertDpToPixel(16, TileItemsAdapter.this.context)), Math.round(Helper.convertDpToPixel(8, TileItemsAdapter.this.context)), Math.round(Helper.convertDpToPixel(16, TileItemsAdapter.this.context)), Math.round(Helper.convertDpToPixel(8, TileItemsAdapter.this.context)));
                    }
                    this.tilesText.setText(tilesItem.getTileName());
                    this.tilesText.setSelected(true);
                    if (SingleStudyAdapter.this.contentType.equals(tilesItem.getType() + tilesItem.getId())) {
                        this.tilesText.setTextColor(TileItemsAdapter.this.context.getResources().getColor(R.color.colorPrimary));
                        this.bg_bottom.setVisibility(0);
                    } else {
                        this.tilesText.setTextColor(TileItemsAdapter.this.context.getResources().getColor(R.color.black));
                        this.bg_bottom.setVisibility(8);
                    }
                    this.parent.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyHeaderHolder$TileItemsAdapter$MyViewHolder$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$setData$0(tilesItem, position, view);
                        }
                    });
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void lambda$setData$0(TilesItem tilesItem, int i, View view) {
                    if (Helper.isNetworkConnected(SingleStudyAdapter.this.activity)) {
                        if (!tilesItem.getType().equalsIgnoreCase(Const.FOLDER)) {
                            SingleStudyAdapter.this.contentType = tilesItem.getType() + tilesItem.getId();
                        }
                        SingleStudyAdapter.this.tilePos = i;
                        SingleStudyAdapter.this.buttonClicked.onTitleClicked(tilesItem, TileItemsAdapter.this.cards, SingleStudyAdapter.this.tilePos);
                        return;
                    }
                    Helper.showInternetToast(SingleStudyAdapter.this.activity);
                }
            }

            public class ListViewHolder extends RecyclerView.ViewHolder {
                ImageView folderIcon;
                public RelativeLayout mainRl;
                public TextView title;

                public ListViewHolder(View view) {
                    super(view);
                    this.title = (TextView) view.findViewById(R.id.folderTitle);
                    this.mainRl = (RelativeLayout) view.findViewById(R.id.mainRl);
                    this.folderIcon = (ImageView) view.findViewById(R.id.icon);
                }

                public void setData(final int position) {
                    final TilesItem tilesItem = (TilesItem) TileItemsAdapter.this.cards.get(position);
                    this.title.setText(tilesItem.getTileName());
                    Helper.setThumbnailImage(SingleStudyAdapter.this.activity, tilesItem.getThumbnail(), SingleStudyAdapter.this.activity.getResources().getDrawable(R.mipmap.folder), this.folderIcon);
                    this.mainRl.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyHeaderHolder$TileItemsAdapter$ListViewHolder$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$setData$0(tilesItem, position, view);
                        }
                    });
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void lambda$setData$0(TilesItem tilesItem, int i, View view) {
                    if (Helper.isNetworkConnected(SingleStudyAdapter.this.activity)) {
                        if (!tilesItem.getType().equalsIgnoreCase(Const.FOLDER)) {
                            SingleStudyAdapter.this.contentType = tilesItem.getType() + tilesItem.getId();
                        }
                        SingleStudyAdapter.this.tilePos = i;
                        SingleStudyAdapter.this.buttonClicked.onTitleClicked(tilesItem, SingleStudyAdapter.this.singleStudy.getData().getTiles(), SingleStudyAdapter.this.tilePos);
                        return;
                    }
                    Helper.showInternetToast(SingleStudyAdapter.this.activity);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return this.cards.size();
            }
        }
    }

    private void startScrollingMarquee(final TextView marqueeText, final int SCROLL_DELAY) {
        final Handler handler = new Handler();
        handler.post(new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter.3
            @Override // java.lang.Runnable
            public void run() {
                TextView textView = marqueeText;
                textView.scrollTo(textView.getScrollX() + 1, marqueeText.getScrollY());
                handler.postDelayed(this, SCROLL_DELAY);
            }
        });
    }

    public class SingleStudyHeaderHolderBook extends RecyclerView.ViewHolder {
        Button addButton;
        TextView authorname;
        TextView cartCountText;
        TextView cartRating;
        TextView course_name;
        ImageView coursebg;
        TextView courseid;
        RelativeLayout headerLL;
        LinearLayout imageRL;
        RelativeLayout inStockRL;
        TextView mrpCutTV;
        RelativeLayout no_data_found_RL;
        TextView priceTV;
        RelativeLayout quantityCountRL;
        TextView quantityText;
        RelativeLayout ratingRL;
        Button subtractButton;
        RecyclerView tileRv;
        TextView title;
        TextView type;
        TextView userRatedCounts;
        TextView validityTV;

        public SingleStudyHeaderHolderBook(View itemView) {
            super(itemView);
            this.headerLL = (RelativeLayout) itemView.findViewById(R.id.headerLL);
            this.ratingRL = (RelativeLayout) itemView.findViewById(R.id.ratingRL);
            this.quantityCountRL = (RelativeLayout) itemView.findViewById(R.id.quantityCountRL);
            this.inStockRL = (RelativeLayout) itemView.findViewById(R.id.inStockRL);
            this.tileRv = (RecyclerView) itemView.findViewById(R.id.tileRv);
            this.imageRL = (LinearLayout) itemView.findViewById(R.id.imageRL);
            this.coursebg = (ImageView) itemView.findViewById(R.id.courseImagebg);
            this.course_name = (TextView) itemView.findViewById(R.id.course_name);
            this.authorname = (TextView) itemView.findViewById(R.id.authorname);
            this.courseid = (TextView) itemView.findViewById(R.id.courseid);
            this.type = (TextView) itemView.findViewById(R.id.type);
            this.validityTV = (TextView) itemView.findViewById(R.id.validityTV);
            this.mrpCutTV = (TextView) itemView.findViewById(R.id.mrpCutTV);
            this.priceTV = (TextView) itemView.findViewById(R.id.priceTV);
            this.title = (TextView) itemView.findViewById(R.id.title);
            this.cartCountText = (TextView) itemView.findViewById(R.id.cartCountText);
            this.subtractButton = (Button) itemView.findViewById(R.id.subtractButton);
            this.addButton = (Button) itemView.findViewById(R.id.addButton);
            this.cartRating = (TextView) itemView.findViewById(R.id.cartRating);
            this.userRatedCounts = (TextView) itemView.findViewById(R.id.userRatedCounts);
            this.quantityText = (TextView) itemView.findViewById(R.id.quantityText);
            this.no_data_found_RL = (RelativeLayout) itemView.findViewById(R.id.no_data_found_RL);
        }

        /* JADX WARN: Removed duplicated region for block: B:96:0x0501  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void setDataHeader(com.appnew.android.Model.COURSEDETAIL.CourseDetail r17) {
            /*
                Method dump skipped, instruction units count: 2138
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Courses.Adapter.SingleStudyAdapter.SingleStudyHeaderHolderBook.setDataHeader(com.appnew.android.Model.COURSEDETAIL.CourseDetail):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setDataHeader$0(View view) {
            if (Integer.parseInt(this.cartCountText.getText().toString()) <= 0 || Integer.parseInt(this.cartCountText.getText().toString()) >= 9) {
                return;
            }
            this.cartCountText.setText("" + (Integer.parseInt(this.cartCountText.getText().toString()) + 1));
            SingleStudyAdapter.this.quantityUpdate.onQuantityIncreased(Integer.parseInt(this.cartCountText.getText().toString()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setDataHeader$1(View view) {
            if (Integer.parseInt(this.cartCountText.getText().toString()) > 1) {
                this.cartCountText.setText("" + (Integer.parseInt(this.cartCountText.getText().toString()) - 1));
                SingleStudyAdapter.this.quantityUpdate.onQuantityDecreased(Integer.parseInt(this.cartCountText.getText().toString()));
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
                if (tilesItem != null && !TextUtils.isEmpty(tilesItem.getType()) && tilesItem.getType().equalsIgnoreCase(Const.LIVE_VIDEO)) {
                    try {
                        holder.liveIv.setVisibility(0);
                        Glide.with(SingleStudyAdapter.this.activity).asGif().load(Integer.valueOf(R.mipmap.live)).into(holder.liveIv);
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
                if (SingleStudyAdapter.this.contentType.equals(tilesItem.getType() + tilesItem.getId())) {
                    holder.tilesText.setTextColor(this.context.getResources().getColor(R.color.colorPrimary));
                    holder.bg_bottom.setVisibility(0);
                } else {
                    holder.tilesText.setTextColor(this.context.getResources().getColor(R.color.black));
                    holder.bg_bottom.setVisibility(8);
                }
                holder.parent.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyHeaderHolderBook$TileItemsAdapter$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$onBindViewHolder$0(tilesItem, position, view);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onBindViewHolder$0(TilesItem tilesItem, int i, View view) {
                if (Helper.isNetworkConnected(SingleStudyAdapter.this.activity)) {
                    if (!tilesItem.getType().equalsIgnoreCase(Const.FOLDER)) {
                        SingleStudyAdapter.this.contentType = tilesItem.getType() + tilesItem.getId();
                    }
                    SingleStudyAdapter.this.tilePos = i;
                    SingleStudyAdapter.this.buttonClicked.onTitleClicked(tilesItem, SingleStudyAdapter.this.singleStudy.getData().getTiles(), SingleStudyAdapter.this.tilePos);
                    return;
                }
                Helper.showInternetToast(SingleStudyAdapter.this.activity);
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
    }

    public class SingleStudySubjectiveTestListHolder extends RecyclerView.ViewHolder {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public final int REQUEST_CODE_MULTIPLE_PIKER;
        private int STORAGE_PERMISSION_TYPE;
        LinearLayout attemptLL;
        Button backBtn;
        Button booklet;
        TextView examPrepTitleTV_new;
        ImageView forwardIV;
        CardView ibt_single_sub_vd_RL;
        ImageView imageIcon;
        TextView learn;
        RelativeLayout lockRL;
        Button marks;
        RelativeLayout no_data_found_RL;
        Button paper;
        RelativeLayout parentLL;
        TextView practice;
        ImageView share;
        TextView startdate;
        RelativeLayout studyitemLL;
        TextView subItemRV;
        LinearLayout subjectBTNLL;
        RelativeLayout thumbRl;
        TextView titleCategory;
        Button upload;

        public SingleStudySubjectiveTestListHolder(View itemView) {
            super(itemView);
            this.STORAGE_PERMISSION_TYPE = 3;
            this.REQUEST_CODE_MULTIPLE_PIKER = 1203;
            this.lockRL = (RelativeLayout) itemView.findViewById(R.id.lockRL);
            this.forwardIV = (ImageView) itemView.findViewById(R.id.forwardIV);
            this.parentLL = (RelativeLayout) itemView.findViewById(R.id.parentLL);
            this.subjectBTNLL = (LinearLayout) itemView.findViewById(R.id.subjectBTNLL);
            this.studyitemLL = (RelativeLayout) itemView.findViewById(R.id.study_single_itemLL);
            this.imageIcon = (ImageView) itemView.findViewById(R.id.profileImage);
            this.thumbRl = (RelativeLayout) itemView.findViewById(R.id.thumbRl);
            this.titleCategory = (TextView) itemView.findViewById(R.id.examPrepTitleTV);
            this.examPrepTitleTV_new = (TextView) itemView.findViewById(R.id.examPrepTitleTV_new);
            this.subItemRV = (TextView) itemView.findViewById(R.id.subItemRV);
            this.startdate = (TextView) itemView.findViewById(R.id.startdate);
            this.attemptLL = (LinearLayout) itemView.findViewById(R.id.attemptLL);
            this.paper = (Button) itemView.findViewById(R.id.paper);
            this.booklet = (Button) itemView.findViewById(R.id.booklet);
            this.upload = (Button) itemView.findViewById(R.id.upload);
            this.marks = (Button) itemView.findViewById(R.id.marks);
            this.no_data_found_RL = (RelativeLayout) itemView.findViewById(R.id.no_data_found_RL);
            this.backBtn = (Button) itemView.findViewById(R.id.backBtn);
            this.ibt_single_sub_vd_RL = (CardView) itemView.findViewById(R.id.ibt_single_sub_vd_RL);
            this.learn = (TextView) itemView.findViewById(R.id.learn);
            this.share = (ImageView) itemView.findViewById(R.id.share);
            this.practice = (TextView) itemView.findViewById(R.id.practice);
        }

        public void setData(final ArrayList<Lists> list, final int position) {
            long j;
            if (list != null && list.size() > 0) {
                if (BuildConfig.FLAVOR.equalsIgnoreCase("mittalCommerceClasses")) {
                    this.marks.setBackground(SingleStudyAdapter.this.activity.getResources().getDrawable(R.drawable.primary_bg_round));
                }
                SingleStudyAdapter.this.setThumbRatio(this.thumbRl);
                this.ibt_single_sub_vd_RL.setVisibility(0);
                this.no_data_found_RL.setVisibility(8);
                if (SingleStudyAdapter.this.is_purchase.equalsIgnoreCase("0") && SingleStudyAdapter.this.isSkip.equalsIgnoreCase("3")) {
                    this.forwardIV.setVisibility(8);
                }
                if (TextUtils.isEmpty(list.get(position).getIs_locked())) {
                    list.get(position).setIs_locked("0");
                }
                if (SingleStudyAdapter.this.singleStudy != null && SingleStudyAdapter.this.singleStudy.getData().getCourseDetail() != null && SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getIsPurchased().equals("1")) {
                    list.get(position).setIs_locked("0");
                }
                if (list.get(position).getIs_locked().equals("0")) {
                    this.lockRL.setVisibility(8);
                } else {
                    this.lockRL.setVisibility(0);
                }
                if (SingleStudyAdapter.this.isSkip.equalsIgnoreCase("3")) {
                    this.share.setVisibility(8);
                    this.titleCategory.setText(list.get(position).getTest_series_name());
                    if (Helper.isLiveTest(list.get(position).getTest_series_type()) && !list.get(position).getEnd_date().equalsIgnoreCase("0") && !list.get(position).getEnd_date().equalsIgnoreCase("")) {
                        this.subItemRV.setVisibility(0);
                        j = 1000;
                        this.subItemRV.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.test_end) + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(list.get(position).getEnd_date()) * 1000))));
                    } else {
                        j = 1000;
                        this.subItemRV.setVisibility(8);
                    }
                    if (Helper.isLiveTest(list.get(position).getTest_series_type()) && !list.get(position).getStart_date().equalsIgnoreCase("0") && !list.get(position).getStart_date().equalsIgnoreCase("")) {
                        this.startdate.setVisibility(0);
                        this.startdate.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.test_start) + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(list.get(position).getStart_date()) * j))));
                    } else {
                        this.startdate.setVisibility(8);
                    }
                    this.attemptLL.setVisibility(8);
                    if (!TextUtils.isEmpty(list.get(position).getImage())) {
                        SingleStudyAdapter.this.setThumbAccordingRatio(list.get(position).getImage(), this.imageIcon);
                    } else if (SingleStudyAdapter.this.bottomSetting != null && SingleStudyAdapter.this.bottomSetting.getLayout_type() != null && SingleStudyAdapter.this.bottomSetting.getLayout_type().equals("1")) {
                        this.imageIcon.setImageResource(R.mipmap.square_placeholder);
                    } else {
                        this.imageIcon.setImageResource(R.mipmap.square_placeholder_new);
                    }
                    if (SingleStudyAdapter.this.isSkip.equalsIgnoreCase("3")) {
                        if (list.get(position).getAttempt().equalsIgnoreCase("0")) {
                            this.upload.setText("Upload");
                        } else {
                            this.upload.setText("View");
                        }
                        setSubjectiveTestOnClick(list.get(position));
                    }
                    if (list.get(position).getIs_locked().equals("0")) {
                        this.subjectBTNLL.setVisibility(0);
                        this.startdate.setVisibility(0);
                        this.subItemRV.setVisibility(0);
                        return;
                    } else {
                        this.subjectBTNLL.setVisibility(8);
                        this.startdate.setVisibility(8);
                        this.subItemRV.setVisibility(8);
                        return;
                    }
                }
                this.share.setVisibility(8);
                this.subItemRV.setVisibility(0);
                this.attemptLL.setVisibility(8);
                this.learn.setVisibility(8);
                this.practice.setVisibility(8);
                this.subjectBTNLL.setVisibility(8);
                if (!TextUtils.isEmpty(list.get(position).getImage_icon())) {
                    SingleStudyAdapter.this.setThumbAccordingRatio(list.get(position).getImage_icon(), this.imageIcon);
                } else if (SingleStudyAdapter.this.bottomSetting != null && SingleStudyAdapter.this.bottomSetting.getLayout_type() != null && SingleStudyAdapter.this.bottomSetting.getLayout_type().equals("1")) {
                    this.imageIcon.setImageResource(R.mipmap.square_placeholder);
                } else {
                    this.imageIcon.setImageResource(R.mipmap.square_placeholder_new);
                }
                this.subItemRV.setVisibility(8);
                this.subItemRV.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.total_) + list.get(position).getCount());
                this.titleCategory.setText(list.get(position).getTitle());
                this.studyitemLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudySubjectiveTestListHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$0(list, position, view);
                    }
                });
                return;
            }
            SingleStudyAdapter.this.handleVisibilityNoData(this.ibt_single_sub_vd_RL, this.no_data_found_RL, this.backBtn);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$0(ArrayList arrayList, int i, View view) {
            Object obj;
            String str;
            String str2;
            Intent intent;
            String str3;
            Intent intent2;
            if (((Lists) arrayList.get(i)).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent3 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent3.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter.this.singleStudy);
                Helper.gotoActivity(intent3, SingleStudyAdapter.this.activity);
                return;
            }
            boolean zEqualsIgnoreCase = SingleStudyAdapter.this.isSkip.equalsIgnoreCase("1");
            String str4 = Const.TAB_TILE_VISIBILITY;
            if (zEqualsIgnoreCase) {
                obj = "content";
            } else {
                if (!SingleStudyAdapter.this.isSkip.equalsIgnoreCase("2")) {
                    if (SingleStudyAdapter.this.isSkip.equalsIgnoreCase("3")) {
                        return;
                    }
                    ExamPrepItem examPrepItem = new ExamPrepItem();
                    examPrepItem.setList(SingleStudyAdapter.this.examPrepItem.getList().get(i).getList());
                    if (!TextUtils.isEmpty(SingleStudyAdapter.this.content_type) && SingleStudyAdapter.this.content_type.equalsIgnoreCase("1") && !SingleStudyAdapter.this.tileIdAPI.equalsIgnoreCase("0")) {
                        str3 = "0";
                        intent2 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) FolderActivity.class);
                        int i2 = i - 1;
                        intent2.putExtra("title", arrayList.get(i2) != null ? ((Lists) arrayList.get(i2)).getTitle() : "Main Folder");
                        intent2.putExtra("firstTime", "1");
                    } else {
                        str3 = "0";
                        intent2 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) CourseActivity.class);
                        intent2.putExtra("title", SingleStudyAdapter.this.singleStudy.getData().getCourseDetail() != null ? SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getTitle() : "Course");
                    }
                    SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(SingleStudyAdapter.this.singleStudy != null ? SingleStudyAdapter.this.singleStudy : new CourseDetail()));
                    SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(examPrepItem));
                    SharedPreference.getInstance().putString("list", new Gson().toJson(arrayList.get(i) != null ? arrayList.get(i) : new Lists()));
                    intent2.putExtra(Const.FRAG_TYPE, Const.EXAMPREP);
                    intent2.putExtra(Const.IS_COMBO, SingleStudyAdapter.this.isCombo);
                    intent2.putExtra("content_type", SingleStudyAdapter.this.contentType);
                    if (SingleStudyAdapter.this.tileTypeAPI.equals(Const.COMBO) || SingleStudyAdapter.this.tileTypeAPI.equals("content")) {
                        intent2.putExtra(Const.TAB_TILE_VISIBILITY, "1");
                    } else {
                        intent2.putExtra(Const.TAB_TILE_VISIBILITY, str3);
                    }
                    intent2.putExtra("tile_id", SingleStudyAdapter.this.tileIdAPI);
                    intent2.putExtra(Const.TILE_TYPE, SingleStudyAdapter.this.tileTypeAPI);
                    intent2.putExtra(Const.REVERT_API, SingleStudyAdapter.this.revertAPI);
                    Helper.gotoActivity(intent2, SingleStudyAdapter.this.activity);
                    return;
                }
                str4 = Const.TAB_TILE_VISIBILITY;
                obj = "content";
            }
            if (!TextUtils.isEmpty(SingleStudyAdapter.this.content_type) && SingleStudyAdapter.this.content_type.equalsIgnoreCase("1") && !SingleStudyAdapter.this.tileIdAPI.equalsIgnoreCase("0")) {
                str = "content_type";
                Activity activity = SingleStudyAdapter.this.activity;
                str2 = Const.IS_COMBO;
                intent = new Intent(activity, (Class<?>) FolderActivity.class);
                int i3 = i - 1;
                intent.putExtra("title", arrayList.get(i3) != null ? ((Lists) arrayList.get(i3)).getTitle() : "Main Folder");
                intent.putExtra("firstTime", "1");
            } else {
                str = "content_type";
                str2 = Const.IS_COMBO;
                intent = new Intent(SingleStudyAdapter.this.activity, (Class<?>) CourseActivity.class);
                intent.putExtra("title", SingleStudyAdapter.this.singleStudy.getData().getCourseDetail() != null ? SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getTitle() : "Course");
                if (SingleStudyAdapter.this.tileTypeAPI.equals(Const.COMBO) || SingleStudyAdapter.this.tileTypeAPI.equals(obj)) {
                    intent.putExtra(str4, "1");
                } else {
                    intent.putExtra(str4, "0");
                }
            }
            SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(SingleStudyAdapter.this.singleStudy != null ? SingleStudyAdapter.this.singleStudy : new CourseDetail()));
            SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(SingleStudyAdapter.this.examPrepItem != null ? SingleStudyAdapter.this.examPrepItem : new ExamPrepItem()));
            SharedPreference.getInstance().putString("list", new Gson().toJson(SingleStudyAdapter.this.examPrepItem.getList().get(i) != null ? SingleStudyAdapter.this.examPrepItem.getList().get(i) : new Lists()));
            intent.putExtra(Const.FRAG_TYPE, Const.EXAMPREPLAST);
            intent.putExtra(str2, SingleStudyAdapter.this.isCombo);
            intent.putExtra(str, SingleStudyAdapter.this.contentType);
            if (SingleStudyAdapter.this.tileTypeAPI.equals(Const.COMBO) || SingleStudyAdapter.this.tileTypeAPI.equals(obj)) {
                intent.putExtra(str4, "1");
            } else {
                intent.putExtra(str4, "0");
            }
            intent.putExtra(Const.TEST_TYPE, SingleStudyAdapter.this.examPrepItem.getList().get(i).getCount());
            intent.putExtra("tile_id", SingleStudyAdapter.this.tileIdAPI);
            intent.putExtra(Const.TILE_TYPE, SingleStudyAdapter.this.tileTypeAPI);
            intent.putExtra(Const.LIST_SUBJECT, SingleStudyAdapter.this.examPrepItem.getList().get(i));
            intent.putExtra(Const.REVERT_API, SingleStudyAdapter.this.revertAPI);
            Helper.gotoActivity(intent, SingleStudyAdapter.this.activity);
        }

        public void setSubjectiveTestOnClick(final Lists video) {
            com.appnew.android.home.Constants.SUB_TEST_ID = video.getId();
            this.paper.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter.SingleStudySubjectiveTestListHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (video.getStart_date() != null && !video.getStart_date().equalsIgnoreCase("") && Helper.checkStartTime(Long.parseLong(video.getStart_date()))) {
                        Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.test_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                        return;
                    }
                    if (System.currentTimeMillis() < Long.parseLong(video.getStart_date()) * 1000) {
                        Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.test_will_start_on) + new SimpleDateFormat("dd/MM/yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                        return;
                    }
                    if (!Helper.isConnected(SingleStudyAdapter.this.activity)) {
                        Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                    } else {
                        if (video.getQuestion().equalsIgnoreCase("")) {
                            return;
                        }
                        com.appnew.android.home.Constants.SUB_TEST_ID = video.getId();
                        video.getQuestion().split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r11.length - 1].split("\\.");
                        Helper.GoToWebViewPDFActivity(SingleStudyAdapter.this.activity, video.getId(), video.getQuestion(), true, video.getTitle(), SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId(), "", video.getFile_type(), video.getIs_share(), Const.QUESTION);
                    }
                }
            });
            this.upload.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudySubjectiveTestListHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setSubjectiveTestOnClick$1(video, view);
                }
            });
            this.booklet.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter.SingleStudySubjectiveTestListHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (video.getEnd_date() != null && !video.getEnd_date().equalsIgnoreCase("") && Helper.checkStartTime1(Long.parseLong(video.getEnd_date()))) {
                        Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.result_will_be_available_on) + new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video.getResult_date()) * 1000)), 0).show();
                        return;
                    }
                    if (Long.parseLong(video.getResult_date()) * 1000 < System.currentTimeMillis()) {
                        if (!Helper.isConnected(SingleStudyAdapter.this.activity)) {
                            Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                            return;
                        }
                        if (SingleStudyAdapter.this.is_purchase.equalsIgnoreCase("1")) {
                            if (!video.getAnswers().equalsIgnoreCase("")) {
                                com.appnew.android.home.Constants.SUB_TEST_ID = video.getId();
                                Helper.GoToWebViewPDFActivity(SingleStudyAdapter.this.activity, video.getId(), video.getAnswers(), true, video.getAnswers().split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r15.length - 1].split("\\.")[0], SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId(), "", video.getFile_type(), video.getIs_share(), Const.ANSWER);
                                return;
                            }
                            Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.file_not_found), 0).show();
                            return;
                        }
                        if (video.getIs_locked().equalsIgnoreCase("1")) {
                            if (SingleStudyAdapter.this.isCourseSoldOut()) {
                                Toast.makeText(SingleStudyAdapter.this.activity, R.string.sold_out_msg, 0).show();
                                return;
                            }
                            Intent intent = new Intent(SingleStudyAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                            intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter.this.singleStudy);
                            Helper.gotoActivity(intent, SingleStudyAdapter.this.activity);
                            return;
                        }
                        com.appnew.android.home.Constants.SUB_TEST_ID = video.getId();
                        Helper.GoToWebViewPDFActivity(SingleStudyAdapter.this.activity, video.getId(), video.getAnswers(), true, video.getAnswers().split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r15.length - 1].split("\\.")[0], SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId(), "", video.getFile_type(), video.getIs_share(), Const.ANSWER);
                        return;
                    }
                    Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.booklet_will_be_available_on) + new SimpleDateFormat("dd/MM/yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video.getResult_date()) * 1000)), 0).show();
                }
            });
            this.marks.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter.SingleStudySubjectiveTestListHolder.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (video.getEnd_date() != null && !video.getEnd_date().equalsIgnoreCase("") && Helper.checkStartTime1(Long.parseLong(video.getEnd_date()))) {
                        Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.result_will_be_available_on) + new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video.getResult_date()) * 1000)), 0).show();
                        return;
                    }
                    if (Long.parseLong(video.getResult_date()) * 1000 < System.currentTimeMillis()) {
                        if (!Helper.isConnected(SingleStudyAdapter.this.activity)) {
                            Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                            return;
                        }
                        if (SingleStudyAdapter.this.is_purchase.equalsIgnoreCase("1")) {
                            com.appnew.android.home.Constants.SUB_TEST_ID = video.getId();
                            Helper.GoToSubjectiveResultActivity(SingleStudyAdapter.this.activity, video.getSolutions(), video.getTitle(), SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId(), video.getId(), SingleStudyAdapter.this.contentType);
                            return;
                        } else {
                            if (video.getIs_locked().equalsIgnoreCase("1")) {
                                if (SingleStudyAdapter.this.isCourseSoldOut()) {
                                    Toast.makeText(SingleStudyAdapter.this.activity, R.string.sold_out_msg, 0).show();
                                    return;
                                }
                                Intent intent = new Intent(SingleStudyAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                                intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter.this.singleStudy);
                                Helper.gotoActivity(intent, SingleStudyAdapter.this.activity);
                                return;
                            }
                            com.appnew.android.home.Constants.SUB_TEST_ID = video.getId();
                            Helper.GoToSubjectiveResultActivity(SingleStudyAdapter.this.activity, video.getSolutions(), video.getTitle(), SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId(), video.getId(), SingleStudyAdapter.this.contentType);
                            return;
                        }
                    }
                    Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.result_will_be_available_on) + new SimpleDateFormat("dd/MM/yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video.getResult_date()) * 1000)), 0).show();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setSubjectiveTestOnClick$1(Lists lists, View view) {
            if (this.upload.getText().toString().equalsIgnoreCase("View")) {
                Intent intent = new Intent(SingleStudyAdapter.this.activity, (Class<?>) PdfDetailScreen.class);
                intent.putExtra(Const.THUMBNAIL, lists.getThumbnail_url());
                intent.putExtra("url", lists.getAnswers_by_student());
                intent.putExtra("file_type", lists.getFile_type());
                SingleStudyAdapter.this.activity.startActivity(intent);
                return;
            }
            if (System.currentTimeMillis() > Long.parseLong(lists.getEnd_date()) * 1000 || MakeMyExam.time_server > Long.parseLong(lists.getEnd_date()) * 1000) {
                Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.you_cant_upload_message), 0).show();
                return;
            }
            if (System.currentTimeMillis() < Long.parseLong(lists.getStart_date()) * 1000 && MakeMyExam.time_server < Long.parseLong(lists.getStart_date()) * 1000) {
                Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.test_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(lists.getStart_date()) * 1000)), 0).show();
                return;
            }
            if (!Helper.isConnected(SingleStudyAdapter.this.activity)) {
                Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                return;
            }
            if (SingleStudyAdapter.this.is_purchase.equalsIgnoreCase("1")) {
                if (lists.getUpload_allowed() != null && lists.getUpload_allowed().equalsIgnoreCase("1")) {
                    com.appnew.android.home.Constants.SUB_TEST_ID = lists.getId();
                    checkStoragePermission();
                    return;
                } else {
                    Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.you_cant_upload_now), 0).show();
                    return;
                }
            }
            if (lists.getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent2 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent2.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter.this.singleStudy);
                Helper.gotoActivity(intent2, SingleStudyAdapter.this.activity);
                return;
            }
            if (lists.getUpload_allowed() != null && lists.getUpload_allowed().equalsIgnoreCase("1")) {
                com.appnew.android.home.Constants.SUB_TEST_ID = lists.getId();
                checkStoragePermission();
            } else {
                Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.you_cant_upload_now), 0).show();
            }
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
                if (SingleStudyAdapter.this.activity instanceof CourseActivity) {
                    ((CourseActivity) SingleStudyAdapter.this.activity).requestCode = 1203;
                    ((CourseActivity) SingleStudyAdapter.this.activity).someActivityResultLauncher.launch(Intent.createChooser(intent, "Select PDF file"));
                } else {
                    ((FolderActivity) SingleStudyAdapter.this.activity).setRequestCode(1203);
                    ((FolderActivity) SingleStudyAdapter.this.activity).getSomeActivityResultLauncher().launch(Intent.createChooser(intent, "Select PDF file"));
                }
            }
        }

        private void startTestAPI() {
            SingleStudyAdapter singleStudyAdapter = SingleStudyAdapter.this;
            new NetworkCall(singleStudyAdapter, singleStudyAdapter.activity).NetworkAPICall(API.API_GET_TEST_INSTRUCTION_DATA, "", true, false);
        }

        public void result_without_submit(final String quiz_id, String course_id, String s, final String quiz_name) {
            if (Helper.isNetworkConnected(SingleStudyAdapter.this.activity)) {
                final Progress progress = new Progress(SingleStudyAdapter.this.activity);
                progress.show();
                APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setTest_id(quiz_id);
                encryptionData.setCourse_id(course_id);
                encryptionData.setFirst_attempt(s);
                aPIInterface.getTestlearn(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new Callback<String>() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter.SingleStudySubjectiveTestListHolder.4
                    @Override // retrofit2.Callback
                    public void onResponse(Call<String> call, Response<String> response) {
                        JSONObject jSONObject;
                        progress.dismiss();
                        if (response.body() != null) {
                            ResultTestSeries_Report resultTestSeries_Report = null;
                            try {
                                jSONObject = new JSONObject(AES.decrypt(response.body(), AES.generatekeyAPI(), AES.generateVectorAPI()));
                                try {
                                    resultTestSeries_Report = (ResultTestSeries_Report) new Gson().fromJson(jSONObject.toString(), ResultTestSeries_Report.class);
                                } catch (Exception unused) {
                                }
                            } catch (Exception unused2) {
                                jSONObject = null;
                            }
                            if (resultTestSeries_Report == null) {
                                Helper.showToastSecurity(SingleStudyAdapter.this.activity);
                                return;
                            }
                            try {
                                if (resultTestSeries_Report.getStatus().equalsIgnoreCase("true")) {
                                    SharedPreference.getInstance().putString("testresult", new Gson().toJson(resultTestSeries_Report));
                                    Intent intent = new Intent(SingleStudyAdapter.this.activity, (Class<?>) ViewSolutionActivity.class);
                                    intent.putExtra(Const.TESTSEGMENT_ID, quiz_id);
                                    intent.putExtra(Const.FRAG_TYPE, Const.SOLUTIONREPORT);
                                    intent.putExtra("name", quiz_name);
                                    intent.putExtra("type", "learn");
                                    if (!resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("1")) {
                                        if (resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("2")) {
                                            SingleStudyAdapter.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                                        }
                                    } else {
                                        SingleStudyAdapter.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                                    }
                                    intent.putExtra(Const.LANG, SingleStudyAdapter.this.lang);
                                    Helper.gotoActivity(intent, SingleStudyAdapter.this.activity);
                                    return;
                                }
                                progress.dismiss();
                                RetrofitResponse.GetApiData(SingleStudyAdapter.this.activity, jSONObject.optString("auth_code"), jSONObject.optString("message"), false);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }

                    @Override // retrofit2.Callback
                    public void onFailure(Call<String> call, Throwable t) {
                        progress.dismiss();
                    }
                });
                return;
            }
            Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.Retry_with_Internet_connection), 1).show();
        }

        public void netoworkCallForQuizResult2(final String quiz_id, String course_id, String s, final String quiz_name) {
            if (Helper.isNetworkConnected(SingleStudyAdapter.this.activity)) {
                final Progress progress = new Progress(SingleStudyAdapter.this.activity);
                progress.show();
                APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setTest_id(quiz_id);
                encryptionData.setCourse_id(course_id);
                encryptionData.setFirst_attempt(s);
                aPIInterface.getTestResult(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new Callback<String>() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter.SingleStudySubjectiveTestListHolder.5
                    @Override // retrofit2.Callback
                    public void onResponse(Call<String> call, Response<String> response) {
                        JSONObject jSONObject;
                        progress.dismiss();
                        if (response.body() != null) {
                            ResultTestSeries_Report resultTestSeries_Report = null;
                            try {
                                jSONObject = new JSONObject(AES.decrypt(response.body(), AES.generatekeyAPI(), AES.generateVectorAPI()));
                                try {
                                    resultTestSeries_Report = (ResultTestSeries_Report) new Gson().fromJson(jSONObject.toString(), ResultTestSeries_Report.class);
                                } catch (Exception unused) {
                                }
                            } catch (Exception unused2) {
                                jSONObject = null;
                            }
                            if (resultTestSeries_Report == null) {
                                Helper.showToastSecurity(SingleStudyAdapter.this.activity);
                                return;
                            }
                            try {
                                if (resultTestSeries_Report.getStatus().equalsIgnoreCase("true")) {
                                    if (resultTestSeries_Report.getData().getQuestions() != null && resultTestSeries_Report.getData().getQuestions().size() > 0) {
                                        SharedPreference.getInstance().putString("testresult", new Gson().toJson(resultTestSeries_Report));
                                        Intent intent = new Intent(SingleStudyAdapter.this.activity, (Class<?>) ViewSolutionActivity.class);
                                        intent.putExtra(Const.TESTSEGMENT_ID, quiz_id);
                                        intent.putExtra(Const.FRAG_TYPE, Const.SOLUTIONREPORT);
                                        intent.putExtra("name", quiz_name);
                                        intent.putExtra("type", "learn");
                                        if (!resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("1")) {
                                            if (resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("2")) {
                                                SingleStudyAdapter.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                                            }
                                        } else {
                                            SingleStudyAdapter.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                                        }
                                        intent.putExtra(Const.LANG, SingleStudyAdapter.this.lang);
                                        Helper.gotoActivity(intent, SingleStudyAdapter.this.activity);
                                        return;
                                    }
                                    Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.no_question_found), 0).show();
                                    return;
                                }
                                progress.dismiss();
                                RetrofitResponse.GetApiData(SingleStudyAdapter.this.activity, jSONObject.optString("auth_code"), jSONObject.optString("message"), false);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }

                    @Override // retrofit2.Callback
                    public void onFailure(Call<String> call, Throwable t) {
                        progress.dismiss();
                    }
                });
                return;
            }
            Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.Retry_with_Internet_connection), 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCourseSoldOut() {
        try {
            CourseDetail courseDetail = this.singleStudy;
            if (courseDetail == null || courseDetail.getData().getCourseDetail() == null || this.singleStudy.getData().getCourseDetail().getExtra_json() == null || this.singleStudy.getData().getCourseDetail().getExtra_json().getSold_out() == null) {
                return false;
            }
            return this.singleStudy.getData().getCourseDetail().getExtra_json().getSold_out().equalsIgnoreCase("1");
        } catch (Exception unused) {
            return false;
        }
    }

    public class MasterContentListView extends RecyclerView.ViewHolder {
        RecyclerView tileItemRecycler;

        public MasterContentListView(View itemView) {
            super(itemView);
            this.tileItemRecycler = (RecyclerView) itemView.findViewById(R.id.groupChatRecycler);
        }

        public void setData(List<TilesItem> TilesItem) {
            ArrayList arrayList = new ArrayList();
            if (SingleStudyAdapter.this.contentType.equalsIgnoreCase(Const.CONTENT_MASTER + SingleStudyAdapter.this.tileIdAPI)) {
                for (int i = 0; i < TilesItem.size(); i++) {
                    if (!TilesItem.get(i).getType().equalsIgnoreCase(Const.OVERVIEW) && !TilesItem.get(i).getType().equalsIgnoreCase(Const.FAQ) && !TilesItem.get(i).getType().equalsIgnoreCase("content") && !TilesItem.get(i).getType().equalsIgnoreCase(Const.COMBO) && !TilesItem.get(i).getType().equalsIgnoreCase(Const.TIME_TABLE) && !TilesItem.get(i).getType().equalsIgnoreCase(Const.FOLDER) && !TilesItem.get(i).getType().equalsIgnoreCase(Const.LIVE_VIDEO) && !TilesItem.get(i).getType().equalsIgnoreCase(Const.UPCOMING_VIDEO) && !TilesItem.get(i).getType().equalsIgnoreCase(Const.CHAT)) {
                        arrayList.add(TilesItem.get(i));
                    }
                }
            }
            TileItemsAdapter tileItemsAdapter = new TileItemsAdapter(SingleStudyAdapter.this.activity, arrayList);
            this.tileItemRecycler.setLayoutManager(new LinearLayoutManager(SingleStudyAdapter.this.activity, 1, false));
            this.tileItemRecycler.setAdapter(tileItemsAdapter);
            this.tileItemRecycler.setNestedScrollingEnabled(false);
            this.tileItemRecycler.scrollToPosition(SingleStudyAdapter.this.tilePos);
        }

        public class TileItemsAdapter extends RecyclerView.Adapter<MyViewHolder> {
            private Context context;
            private List<TilesItem> folderTileList;

            public TileItemsAdapter(Context context, List<TilesItem> cards) {
                this.folderTileList = cards;
                this.context = context;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public void onBindViewHolder(final MyViewHolder holder, final int position) {
                final TilesItem tilesItem = this.folderTileList.get(position);
                holder.folderTitle.setText(tilesItem.getTileName());
                setContentIcons(tilesItem, holder.folderIcon);
                holder.mainRl.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$MasterContentListView$TileItemsAdapter$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$onBindViewHolder$0(tilesItem, position, view);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onBindViewHolder$0(TilesItem tilesItem, int i, View view) {
                if (Helper.isNetworkConnected(SingleStudyAdapter.this.activity)) {
                    SingleStudyAdapter.this.masterContent = SingleStudyAdapter.this.contentType;
                    if (SingleStudyAdapter.this.contentType.equalsIgnoreCase(Const.CONTENT_MASTER + SingleStudyAdapter.this.tileIdAPI)) {
                        SingleStudyAdapter.this.contentType = tilesItem.getType() + tilesItem.getId();
                    }
                    SingleStudyAdapter.this.tilePos = i;
                    SingleStudyAdapter.this.buttonClicked.onTitleClicked(tilesItem, this.folderTileList, SingleStudyAdapter.this.tilePos);
                    return;
                }
                Helper.showInternetToast(SingleStudyAdapter.this.activity);
            }

            private void setContentIcons(TilesItem tilesItem, ImageView imageView) {
                if (tilesItem.getType().equalsIgnoreCase("image")) {
                    Helper.setThumbnailImage(SingleStudyAdapter.this.activity, tilesItem.getThumbnail(), SingleStudyAdapter.this.activity.getResources().getDrawable(R.drawable.content_image), imageView);
                    return;
                }
                if (tilesItem.getType().equalsIgnoreCase(Const.PDF)) {
                    Helper.setThumbnailImage(SingleStudyAdapter.this.activity, tilesItem.getThumbnail(), SingleStudyAdapter.this.activity.getResources().getDrawable(R.drawable.content_pdf), imageView);
                    return;
                }
                if (tilesItem.getType().equalsIgnoreCase("audio")) {
                    Helper.setThumbnailImage(SingleStudyAdapter.this.activity, tilesItem.getThumbnail(), SingleStudyAdapter.this.activity.getResources().getDrawable(R.drawable.content_recorded_classes), imageView);
                    return;
                }
                if (tilesItem.getType().equalsIgnoreCase("video")) {
                    Helper.setThumbnailImage(SingleStudyAdapter.this.activity, tilesItem.getThumbnail(), SingleStudyAdapter.this.activity.getResources().getDrawable(R.drawable.content_recorded_classes), imageView);
                    return;
                }
                if (tilesItem.getType().equalsIgnoreCase("link")) {
                    Helper.setThumbnailImage(SingleStudyAdapter.this.activity, tilesItem.getThumbnail(), SingleStudyAdapter.this.activity.getResources().getDrawable(R.drawable.content_link), imageView);
                    return;
                }
                if (tilesItem.getType().equalsIgnoreCase(Const.CONCEPT)) {
                    Helper.setThumbnailImage(SingleStudyAdapter.this.activity, tilesItem.getThumbnail(), SingleStudyAdapter.this.activity.getResources().getDrawable(R.drawable.content_notes), imageView);
                    return;
                }
                if (tilesItem.getType().equalsIgnoreCase(Const.SUBJECTIVE_TEST)) {
                    Helper.setThumbnailImage(SingleStudyAdapter.this.activity, tilesItem.getThumbnail(), SingleStudyAdapter.this.activity.getResources().getDrawable(R.drawable.content_doubt_sessions), imageView);
                } else if (tilesItem.getType().equalsIgnoreCase(Const.TEST)) {
                    Helper.setThumbnailImage(SingleStudyAdapter.this.activity, tilesItem.getThumbnail(), SingleStudyAdapter.this.activity.getResources().getDrawable(R.drawable.content_test), imageView);
                } else if (tilesItem.getType().equalsIgnoreCase(Const.Daily_assignment)) {
                    Helper.setThumbnailImage(SingleStudyAdapter.this.activity, tilesItem.getThumbnail(), SingleStudyAdapter.this.activity.getResources().getDrawable(R.drawable.content_daily_asssignment), imageView);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_folder_type, parent, false));
            }

            public class MyViewHolder extends RecyclerView.ViewHolder {
                ImageView folderIcon;
                public TextView folderTitle;
                public RelativeLayout mainRl;

                public MyViewHolder(View view) {
                    super(view);
                    this.folderTitle = (TextView) view.findViewById(R.id.folderTitle);
                    this.mainRl = (RelativeLayout) view.findViewById(R.id.mainRl);
                    this.folderIcon = (ImageView) view.findViewById(R.id.icon);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return this.folderTileList.size();
            }
        }
    }

    public class FolderListView extends RecyclerView.ViewHolder {
        RecyclerView tileItemRecycler;

        public FolderListView(View itemView) {
            super(itemView);
            this.tileItemRecycler = (RecyclerView) itemView.findViewById(R.id.groupChatRecycler);
        }

        public void setData(List<TilesItem> TilesItem) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < TilesItem.size(); i++) {
                if (SingleStudyAdapter.this.contentType.equalsIgnoreCase(Const.FOLDER + SingleStudyAdapter.this.tileIdAPI) && TilesItem.get(i).getType().equalsIgnoreCase(Const.FOLDER)) {
                    arrayList.add(TilesItem.get(i));
                }
            }
            TileItemsAdapter tileItemsAdapter = new TileItemsAdapter(SingleStudyAdapter.this.activity, arrayList);
            this.tileItemRecycler.setLayoutManager(new LinearLayoutManager(SingleStudyAdapter.this.activity, 1, false));
            this.tileItemRecycler.setAdapter(tileItemsAdapter);
            this.tileItemRecycler.setNestedScrollingEnabled(false);
            this.tileItemRecycler.scrollToPosition(SingleStudyAdapter.this.tilePos);
        }

        public class TileItemsAdapter extends RecyclerView.Adapter<MyViewHolder> {
            private Context context;
            private List<TilesItem> folderTileList;

            public TileItemsAdapter(Context context, List<TilesItem> cards) {
                this.folderTileList = cards;
                this.context = context;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public void onBindViewHolder(final MyViewHolder holder, final int position) {
                final TilesItem tilesItem = this.folderTileList.get(position);
                holder.folderTitle.setText(tilesItem.getTileName());
                Helper.setThumbnailImage(SingleStudyAdapter.this.activity, tilesItem.getThumbnail(), SingleStudyAdapter.this.activity.getResources().getDrawable(R.mipmap.folder), holder.folderIcon);
                holder.mainRl.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$FolderListView$TileItemsAdapter$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$onBindViewHolder$0(tilesItem, position, view);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onBindViewHolder$0(TilesItem tilesItem, int i, View view) {
                if (Helper.isNetworkConnected(SingleStudyAdapter.this.activity)) {
                    if (!tilesItem.getType().equalsIgnoreCase(Const.FOLDER)) {
                        SingleStudyAdapter.this.contentType = tilesItem.getType() + tilesItem.getId();
                    }
                    SingleStudyAdapter.this.tilePos = i;
                    SingleStudyAdapter.this.buttonClicked.onTitleClicked(tilesItem, this.folderTileList, SingleStudyAdapter.this.tilePos);
                    return;
                }
                Helper.showInternetToast(SingleStudyAdapter.this.activity);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_folder_type, parent, false));
            }

            public class MyViewHolder extends RecyclerView.ViewHolder {
                ImageView folderIcon;
                public TextView folderTitle;
                public RelativeLayout mainRl;

                public MyViewHolder(View view) {
                    super(view);
                    this.folderTitle = (TextView) view.findViewById(R.id.folderTitle);
                    this.mainRl = (RelativeLayout) view.findViewById(R.id.mainRl);
                    this.folderIcon = (ImageView) view.findViewById(R.id.icon);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return this.folderTileList.size();
            }
        }
    }

    public class SingleStudyGroupChatAdapter extends RecyclerView.ViewHolder {
        RecyclerView groupChatRecycler;

        public SingleStudyGroupChatAdapter(View itemView) {
            super(itemView);
            this.groupChatRecycler = (RecyclerView) itemView.findViewById(R.id.groupChatRecycler);
        }

        public void setData(ArrayList<ChatModel> chatModels) {
            this.groupChatRecycler.setLayoutManager(new LinearLayoutManager(SingleStudyAdapter.this.activity));
            this.groupChatRecycler.setAdapter(new com.appnew.android.socket.adapter.SingleStudyGroupChatAdapter(SingleStudyAdapter.this.activity, chatModels, SingleStudyAdapter.this.singleStudy));
        }
    }

    public class SingleStudySubjectiveTimeTableListHolder extends RecyclerView.ViewHolder implements ItemClickListener {
        RecyclerView DateTableRecycler;
        TextView batchId;
        RelativeLayout batchRL;
        ItemClickListener itemClickListener;
        RecyclerView timeTableRecycler;

        @Override // com.appnew.android.Zoom.ItemClickListener
        public void getPosition(int pos) {
        }

        @Override // com.appnew.android.Zoom.ItemClickListener
        public void onClick(String position) {
        }

        @Override // com.appnew.android.Zoom.ItemClickListener
        public void onClickCurrentAffair(List<CurrentAffairDataModel> position) {
        }

        public SingleStudySubjectiveTimeTableListHolder(View itemView) {
            super(itemView);
            this.batchId = (TextView) itemView.findViewById(R.id.batchId);
            this.batchRL = (RelativeLayout) itemView.findViewById(R.id.batchRL);
            this.timeTableRecycler = (RecyclerView) itemView.findViewById(R.id.timeTableRecycler);
            this.DateTableRecycler = (RecyclerView) itemView.findViewById(R.id.DateTableRecycler);
        }

        public void setData(final ArrayList<Data> list, final int position) {
            ArrayList arrayList = new ArrayList();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(list.get(i).getDate());
            }
            linkedHashSet.addAll(arrayList);
            arrayList.clear();
            arrayList.addAll(linkedHashSet);
            DateTableAdapter dateTableAdapter = new DateTableAdapter(arrayList, list, SingleStudyAdapter.this.activity, this);
            this.DateTableRecycler.setLayoutManager(new LinearLayoutManager(SingleStudyAdapter.this.activity, 0, false));
            this.DateTableRecycler.setAdapter(dateTableAdapter);
            this.DateTableRecycler.setNestedScrollingEnabled(false);
            ArrayList arrayList2 = new ArrayList();
            new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (list.get(0).getDate().equals(list.get(i2).getDate())) {
                    arrayList2.add(list.get(i2));
                }
            }
            TimeTableDateAdapter timeTableDateAdapter = new TimeTableDateAdapter(arrayList2, SingleStudyAdapter.this.activity);
            this.timeTableRecycler.setLayoutManager(new LinearLayoutManager(SingleStudyAdapter.this.activity));
            this.timeTableRecycler.setAdapter(timeTableDateAdapter);
            this.timeTableRecycler.setNestedScrollingEnabled(false);
        }

        @Override // com.appnew.android.Zoom.ItemClickListener
        public void onClickTimeTableDate(ArrayList<Data> data, int position) {
            TimeTableDateAdapter timeTableDateAdapter = new TimeTableDateAdapter(data, SingleStudyAdapter.this.activity);
            this.timeTableRecycler.setLayoutManager(new LinearLayoutManager(SingleStudyAdapter.this.activity));
            this.timeTableRecycler.setAdapter(timeTableDateAdapter);
            this.timeTableRecycler.setNestedScrollingEnabled(false);
        }
    }

    public class FAQViewHolder extends RecyclerView.ViewHolder {
        Button backBtn;
        RelativeLayout no_data_found_RL;
        RecyclerView recyclerView;

        FAQViewHolder(View itemView) {
            super(itemView);
            this.recyclerView = (RecyclerView) itemView.findViewById(R.id.faqRV);
            this.no_data_found_RL = (RelativeLayout) itemView.findViewById(R.id.no_data_found_RL);
            this.backBtn = (Button) itemView.findViewById(R.id.backBtn);
        }

        public void setData(ArrayList<FaqData> faqData) {
            if (faqData != null && faqData.size() > 0) {
                this.no_data_found_RL.setVisibility(8);
                this.recyclerView.setVisibility(0);
                this.recyclerView.setLayoutManager(new LinearLayoutManager(SingleStudyAdapter.this.activity, 1, false));
                this.recyclerView.setAdapter(new FaqListRecyclerAdapter(faqData, 0));
                this.recyclerView.setNestedScrollingEnabled(false);
                return;
            }
            this.no_data_found_RL.setVisibility(0);
            this.recyclerView.setVisibility(8);
            this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$FAQViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setData$0(view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$0(View view) {
            SingleStudyAdapter.this.activity.finish();
        }
    }

    public class OverViewHolder extends RecyclerView.ViewHolder {
        Button backBtn;
        RelativeLayout no_data_found_RL;
        RecyclerView recyclerView;

        OverViewHolder(View itemView) {
            super(itemView);
            this.recyclerView = (RecyclerView) itemView.findViewById(R.id.overviewRV);
            this.no_data_found_RL = (RelativeLayout) itemView.findViewById(R.id.no_data_found_RL);
            this.backBtn = (Button) itemView.findViewById(R.id.backBtn);
        }

        public void setData(CourseDetailData basic, OverviewData overview) {
            boolean z;
            boolean z2;
            if (overview != null) {
                this.recyclerView.setVisibility(0);
                this.no_data_found_RL.setVisibility(8);
                if (SingleStudyAdapter.this.isLodded.booleanValue()) {
                    if (overview.getData().getVisibility().equalsIgnoreCase("1")) {
                        z = false;
                        z2 = false;
                    } else if (overview.getData().getVisibility().equalsIgnoreCase("2")) {
                        z2 = false;
                        z = true;
                    } else {
                        z = false;
                        z2 = true;
                    }
                    OverviewRVAdapter overviewRVAdapter = new OverviewRVAdapter(SingleStudyAdapter.this.activity, basic, overview, this.recyclerView, z, z2);
                    this.recyclerView.setLayoutManager(new LinearLayoutManager(SingleStudyAdapter.this.activity, 1, false));
                    this.recyclerView.setAdapter(overviewRVAdapter);
                    SingleStudyAdapter.this.isLodded = false;
                    return;
                }
                return;
            }
            this.recyclerView.setVisibility(8);
            this.no_data_found_RL.setVisibility(0);
            this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter.OverViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    SingleStudyAdapter.this.activity.finish();
                }
            });
        }
    }

    public class SingleStudyComboHolder extends RecyclerView.ViewHolder implements NetworkCall.MyNetworkCallBack, ComboListAdapter.onButtonClicked {
        ComboCourseModel comboCourseModel;
        ComboListAdapter comboListAdapter;
        RecyclerView comboRV;
        ArrayList<Courselist> courseDataArrayList;
        boolean isPaginationAvailable;
        public String isPurchased;
        int mPage;
        NetworkCall networkCall;
        RelativeLayout no_data_found_RL;
        int pageItemLimit;
        TextView view_all;

        public SingleStudyComboHolder(View itemView) {
            super(itemView);
            this.courseDataArrayList = new ArrayList<>();
            this.pageItemLimit = 20;
            this.mPage = 1;
            this.isPaginationAvailable = false;
            this.isPurchased = "";
            this.no_data_found_RL = (RelativeLayout) itemView.findViewById(R.id.no_data_found_RL);
            this.view_all = (TextView) itemView.findViewById(R.id.view_all);
            this.comboRV = (RecyclerView) itemView.findViewById(R.id.comboRV);
        }

        public void setData(int position) {
            this.comboRV.setLayoutManager(new LinearLayoutManager(SingleStudyAdapter.this.activity));
            this.comboRV.setHasFixedSize(true);
            this.comboRV.setNestedScrollingEnabled(false);
            this.networkCall = new NetworkCall(this, SingleStudyAdapter.this.activity);
            if (SingleStudyAdapter.this.singleStudy != null && SingleStudyAdapter.this.singleStudy.getData().getCourseDetail() != null && !TextUtils.isEmpty(SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getIsPurchased())) {
                this.isPurchased = SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getIsPurchased();
            }
            hit_api_for_data(true);
            this.view_all.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyComboHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setData$0(view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$0(View view) {
            Intent intent = new Intent(SingleStudyAdapter.this.activity, (Class<?>) ComboListActivity.class);
            intent.putExtra("title", SingleStudyAdapter.this.singleStudy.getData().getTiles().get(SingleStudyAdapter.this.tilePos) != null ? SingleStudyAdapter.this.singleStudy.getData().getTiles().get(SingleStudyAdapter.this.tilePos).getTileName() : "Combo Course");
            intent.putExtra(Const.SINGLE_STUDY_DATA, SingleStudyAdapter.this.singleStudy);
            Helper.gotoActivity(intent, SingleStudyAdapter.this.activity);
        }

        private void hit_api_for_data(boolean showProgress) {
            this.networkCall.NetworkAPICall(API.get_combo_course_list, "", showProgress, false);
        }

        @Override // com.appnew.android.Courses.Adapter.ComboListAdapter.onButtonClicked
        public void onCourseClicked(int pos) {
            if (this.courseDataArrayList.get(pos).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(SingleStudyAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                SharedPreference.getInstance().putString(Const.SINGLE_STUDY, new Gson().toJson(SingleStudyAdapter.this.singleStudy));
                intent.putExtra(Const.IS_BOOK, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, SingleStudyAdapter.this.activity);
                return;
            }
            if (TextUtils.isEmpty(this.courseDataArrayList.get(pos).getMaintenanceText())) {
                Intent intent2 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) CourseActivity.class);
                intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                intent2.putExtra(Const.COURSE_ID_MAIN, this.courseDataArrayList.get(pos).getId());
                intent2.putExtra(Const.COURSE_PARENT_ID, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId());
                intent2.putExtra(Const.CONTENT_TYPE_1, this.courseDataArrayList.get(pos).getContent_type());
                intent2.putExtra(Const.IS_COMBO, true);
                intent2.putExtra("valid_to", SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getValid_to());
                intent2.putExtra(AnalyticsConstants.course_name, this.courseDataArrayList.get(pos).getTitle());
                Helper.gotoActivity(intent2, SingleStudyAdapter.this.activity);
                return;
            }
            Helper.getCourseMaintanaceDialog(SingleStudyAdapter.this.activity, "", this.courseDataArrayList.get(pos).getMaintenanceText());
        }

        @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
        public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
            apitype.hashCode();
            if (!apitype.equals(API.get_combo_course_list)) {
                return null;
            }
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setCourse_id(SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId());
            encryptionData.setSearch("");
            encryptionData.setPage("" + this.mPage);
            return service.get_combo_course_list(AES.encrypt(new Gson().toJson(encryptionData)));
        }

        @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
        public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
            apitype.hashCode();
            if (apitype.equals(API.get_combo_course_list)) {
                try {
                    if (jsonstring.getString("status").equalsIgnoreCase("true")) {
                        ComboCourseModel comboCourseModel = (ComboCourseModel) new Gson().fromJson(jsonstring.toString(), ComboCourseModel.class);
                        this.comboCourseModel = comboCourseModel;
                        this.isPaginationAvailable = (comboCourseModel == null || comboCourseModel.getData() == null || this.comboCourseModel.getData().size() < this.pageItemLimit) ? false : true;
                        ArrayList<Courselist> arrayList = this.courseDataArrayList;
                        if (arrayList != null && !arrayList.isEmpty()) {
                            this.courseDataArrayList.clear();
                        }
                        if (this.comboCourseModel.getData() != null) {
                            this.courseDataArrayList.addAll(this.comboCourseModel.getData());
                            if (!this.courseDataArrayList.isEmpty()) {
                                this.no_data_found_RL.setVisibility(8);
                                this.comboRV.setVisibility(0);
                                ComboListAdapter comboListAdapter = new ComboListAdapter(SingleStudyAdapter.this.activity, this.courseDataArrayList, this.isPurchased, this);
                                this.comboListAdapter = comboListAdapter;
                                this.comboRV.setAdapter(comboListAdapter);
                                this.comboListAdapter.notifyDataSetChanged();
                                if (this.isPaginationAvailable) {
                                    this.view_all.setVisibility(0);
                                    return;
                                }
                                return;
                            }
                            this.no_data_found_RL.setVisibility(0);
                            this.comboRV.setVisibility(8);
                            return;
                        }
                        Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.data_not_found), 0).show();
                        return;
                    }
                    this.isPaginationAvailable = false;
                    this.no_data_found_RL.setVisibility(0);
                    this.comboRV.setVisibility(8);
                    if (!jsonstring.has("auth_code") || GenericUtils.isEmpty(jsonstring.getString("auth_code"))) {
                        return;
                    }
                    RetrofitResponse.GetApiData(SingleStudyAdapter.this.activity, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
                } catch (Exception e2) {
                    this.isPaginationAvailable = false;
                    Log.d("TAGCOMBOCOURSE", "SuccessCallBack: " + e2.getMessage());
                }
            }
        }

        @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
        public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
            this.isPaginationAvailable = false;
        }
    }

    public class SingleStudyTestListHolder extends RecyclerView.ViewHolder {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        LinearLayout attemptLL;
        TextView attemptNow;
        Button backBtn;
        RelativeLayout contantRL;
        ImageView forwardIV;
        CardView ibt_single_sub_vd_RL;
        ImageView imageIcon;
        TextView learn;
        RelativeLayout lockRL;
        RelativeLayout no_data_found_RL;
        RelativeLayout parentLL;
        TextView practice;
        TextView registerText;
        ImageView share;
        TextView startdate;
        RelativeLayout studyitemLL;
        TextView subItemRV;
        TextView testResume;
        TextView test_mode_tv;
        TextView test_price_tv;
        TextView test_price_tv1;
        RelativeLayout thumbRl;
        TextView titleCategory;
        TextView view_result;

        public SingleStudyTestListHolder(View itemView) {
            super(itemView);
            this.forwardIV = (ImageView) itemView.findViewById(R.id.forwardIV);
            this.lockRL = (RelativeLayout) itemView.findViewById(R.id.lockRL);
            this.parentLL = (RelativeLayout) itemView.findViewById(R.id.parentLL);
            this.studyitemLL = (RelativeLayout) itemView.findViewById(R.id.study_single_itemLL);
            this.imageIcon = (ImageView) itemView.findViewById(R.id.profileImage);
            this.thumbRl = (RelativeLayout) itemView.findViewById(R.id.thumbRl);
            this.titleCategory = (TextView) itemView.findViewById(R.id.examPrepTitleTV);
            this.subItemRV = (TextView) itemView.findViewById(R.id.subItemRV);
            this.test_mode_tv = (TextView) itemView.findViewById(R.id.test_mode_tv);
            this.test_price_tv = (TextView) itemView.findViewById(R.id.test_price_tv);
            this.test_price_tv1 = (TextView) itemView.findViewById(R.id.test_price_tv1);
            this.startdate = (TextView) itemView.findViewById(R.id.startdate);
            this.attemptLL = (LinearLayout) itemView.findViewById(R.id.attemptLL);
            this.view_result = (TextView) itemView.findViewById(R.id.view_result);
            this.no_data_found_RL = (RelativeLayout) itemView.findViewById(R.id.no_data_found_RL);
            this.backBtn = (Button) itemView.findViewById(R.id.backBtn);
            this.ibt_single_sub_vd_RL = (CardView) itemView.findViewById(R.id.ibt_single_sub_vd_RL);
            this.learn = (TextView) itemView.findViewById(R.id.learn);
            this.share = (ImageView) itemView.findViewById(R.id.share);
            this.practice = (TextView) itemView.findViewById(R.id.practice);
            this.contantRL = (RelativeLayout) itemView.findViewById(R.id.contantLL);
            this.testResume = (TextView) itemView.findViewById(R.id.testResume);
            this.registerText = (TextView) itemView.findViewById(R.id.registerText);
        }

        public void setData(final ArrayList<Lists> list, final int position) {
            ImageView imageView;
            int i;
            ImageView imageView2;
            String str;
            int i2;
            int i3;
            int i4;
            ImageView imageView3;
            this.view_result.setVisibility(8);
            String str2 = "3";
            if (list != null && list.size() > 0) {
                SingleStudyAdapter.this.setThumbRatio(this.thumbRl);
                this.ibt_single_sub_vd_RL.setVisibility(0);
                this.no_data_found_RL.setVisibility(8);
                if (SingleStudyAdapter.this.is_purchase.equalsIgnoreCase("0") && SingleStudyAdapter.this.isSkip.equalsIgnoreCase("3") && (imageView3 = this.forwardIV) != null) {
                    imageView3.setVisibility(8);
                }
                int i5 = position - 1;
                if (TextUtils.isEmpty(list.get(i5).getIs_locked())) {
                    list.get(i5).setIs_locked("0");
                }
                if (SingleStudyAdapter.this.singleStudy != null && SingleStudyAdapter.this.singleStudy.getData().getCourseDetail() != null && SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getIsPurchased().equals("1")) {
                    list.get(i5).setIs_locked("0");
                }
                if (list.get(i5).getIs_locked().equals("0")) {
                    this.lockRL.setVisibility(8);
                } else {
                    this.lockRL.setVisibility(0);
                }
                if (!SingleStudyAdapter.this.isSkip.equalsIgnoreCase("3") || !SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type().equalsIgnoreCase("3")) {
                    if (SingleStudyAdapter.this.isSkip.equalsIgnoreCase("3")) {
                        if (Helper.isShowShareButton(SingleStudyAdapter.this.leftMenu)) {
                            this.share.setVisibility(0);
                        } else {
                            this.share.setVisibility(8);
                        }
                        this.titleCategory.setText(list.get(i5).getTest_series_name());
                        if (!Helper.isLiveTest(list.get(i5).getTest_series_type()) || list.get(i5).getEnd_date().equalsIgnoreCase("0") || list.get(i5).getEnd_date().equalsIgnoreCase("")) {
                            str = "3";
                            this.subItemRV.setVisibility(8);
                        } else {
                            this.subItemRV.setVisibility(0);
                            str = "3";
                            this.subItemRV.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.test_end) + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(list.get(i5).getEnd_date()) * 1000))));
                        }
                        if (Helper.isLiveTest(list.get(i5).getTest_series_type()) && !list.get(i5).getStart_date().equalsIgnoreCase("0") && !list.get(i5).getStart_date().equalsIgnoreCase("")) {
                            this.startdate.setVisibility(0);
                            this.startdate.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.test_start) + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(list.get(i5).getStart_date()) * 1000))));
                        } else {
                            this.startdate.setVisibility(8);
                        }
                        this.attemptLL.setVisibility(0);
                        if (list.get(i5).getState().equals("1")) {
                            SingleStudyAdapter.this.utkashRoom.getTestDao().delete_test_data(MakeMyExam.userId, list.get(i5).getId());
                            if (MakeMyExam.time_server >= Long.parseLong(list.get(i5).getEnd_date()) * 1000) {
                                this.view_result.setVisibility(0);
                                if (list.get(i5).getResult_date().equalsIgnoreCase("0") || list.get(i5).getResult_date().equalsIgnoreCase("1") || list.get(i5).getResult_date().equalsIgnoreCase("")) {
                                    this.attemptLL.setVisibility(8);
                                    handleLearnPractice(list.get(i5));
                                } else if (MakeMyExam.time_server > Long.parseLong(list.get(i5).getResult_date()) * 1000) {
                                    if (Long.parseLong(list.get(i5).getEnd_date()) < 1640066737) {
                                        this.attemptLL.setVisibility(8);
                                    } else {
                                        this.attemptLL.setVisibility(8);
                                        if (list.get(i5).getState().equalsIgnoreCase("1")) {
                                            ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.view_result1));
                                        } else {
                                            ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.view_rank));
                                        }
                                    }
                                    handleLearnPractice(list.get(i5));
                                } else {
                                    this.view_result.setVisibility(0);
                                    this.attemptLL.setVisibility(8);
                                    ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.attempted_));
                                    handleLearnPractice(list.get(i5));
                                }
                            } else {
                                if (list.get(i5).getResult_date().equalsIgnoreCase("0") || list.get(i5).getResult_date().equalsIgnoreCase("1") || list.get(i5).getResult_date().equalsIgnoreCase("")) {
                                    this.view_result.setVisibility(0);
                                } else {
                                    this.view_result.setVisibility(0);
                                }
                                if (!list.get(i5).getIs_reattempt().equalsIgnoreCase("0")) {
                                    this.learn.setVisibility(8);
                                    this.practice.setVisibility(8);
                                    this.attemptLL.setVisibility(0);
                                    this.attemptLL.getChildAt(0).setVisibility(0);
                                    ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.re_aTTEMPT));
                                } else if (list.get(i5).getResult_date() == null || list.get(i5).getResult_date().equalsIgnoreCase("1") || list.get(i5).getResult_date().equalsIgnoreCase("0") || list.get(i5).getResult_date().equalsIgnoreCase("")) {
                                    if (Helper.isLearnPracticeAfterSubmit()) {
                                        handleLearnPractice(list.get(i5));
                                        this.attemptLL.setVisibility(8);
                                        this.testResume.setVisibility(8);
                                    } else {
                                        this.learn.setVisibility(8);
                                        this.practice.setVisibility(8);
                                        this.attemptLL.getChildAt(0).setVisibility(0);
                                        if (list.get(i5).getState().equalsIgnoreCase("1")) {
                                            ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.attempted_));
                                        } else {
                                            ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.attempted_));
                                        }
                                    }
                                } else {
                                    this.learn.setVisibility(8);
                                    this.practice.setVisibility(8);
                                    this.attemptLL.getChildAt(0).setVisibility(0);
                                    ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.attempted));
                                }
                            }
                        } else if (MakeMyExam.time_server >= Long.parseLong(list.get(i5).getEnd_date()) * 1000) {
                            if (list.get(i5).getResult_date().equalsIgnoreCase("0") || list.get(i5).getResult_date().equalsIgnoreCase("1") || list.get(i5).getResult_date().equalsIgnoreCase("")) {
                                this.attemptLL.setVisibility(8);
                                handleLearnPractice(list.get(i5));
                                this.view_result.setVisibility(0);
                                this.view_result.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.view_rank));
                            }
                            if (Long.parseLong(list.get(i5).getResult_date()) * 1000 > System.currentTimeMillis()) {
                                this.attemptLL.setVisibility(8);
                                handleLearnPractice(list.get(i5));
                                this.view_result.setVisibility(8);
                                this.view_result.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.view_rank));
                            } else if (MakeMyExam.time_server > Long.parseLong(list.get(i5).getResult_date()) * 1000) {
                                this.view_result.setVisibility(0);
                                if (Long.parseLong(list.get(i5).getEnd_date()) < 1640066737) {
                                    this.attemptLL.setVisibility(8);
                                } else {
                                    this.attemptLL.setVisibility(8);
                                    this.attemptLL.getChildAt(0).setVisibility(8);
                                    if (list.get(i5).getState().equalsIgnoreCase("1")) {
                                        this.view_result.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.view_result1));
                                        ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.view_result1));
                                    } else {
                                        this.view_result.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.view_rank));
                                        ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.view_rank));
                                    }
                                }
                                handleLearnPractice(list.get(i5));
                            } else {
                                this.attemptLL.setVisibility(8);
                                handleLearnPractice(list.get(i5));
                            }
                        } else if (Long.parseLong(SharedPreference.getInstance().getString(Const.SERVER_TIME)) < Long.parseLong(list.get(i5).getStart_date())) {
                            this.attemptLL.getChildAt(0).setVisibility(0);
                            ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.upcoming_test));
                            this.learn.setVisibility(8);
                            this.practice.setVisibility(8);
                        } else {
                            TestTable testTableTest_data = SingleStudyAdapter.this.utkashRoom.getTestDao().test_data(list.get(i5).getId(), MakeMyExam.userId);
                            if (testTableTest_data != null && testTableTest_data.getStatus() != null && !testTableTest_data.getStatus().equalsIgnoreCase("")) {
                                this.attemptLL.getChildAt(0).setVisibility(0);
                                ((TextView) this.attemptLL.getChildAt(0)).setText(testTableTest_data.getStatus());
                                this.learn.setVisibility(8);
                                this.practice.setVisibility(8);
                                i2 = 0;
                            } else {
                                i2 = 0;
                                this.attemptLL.getChildAt(0).setVisibility(0);
                            }
                            ((TextView) this.attemptLL.getChildAt(i2)).setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.attempt_now));
                            this.learn.setVisibility(8);
                            this.practice.setVisibility(8);
                            if (Helper.isTestResume(list.get(i5).getSet_type()) && list.get(i5).getAttempt().equalsIgnoreCase("0") && list.get(i5).getState() != null && list.get(i5).getState().equalsIgnoreCase("0")) {
                                this.testResume.setVisibility(0);
                                this.attemptLL.getChildAt(0).setVisibility(8);
                                this.attemptLL.setVisibility(8);
                                ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.attempt_now));
                            } else {
                                this.attemptLL.getChildAt(0).setVisibility(0);
                                this.attemptLL.setVisibility(0);
                                ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.attempt_now));
                                this.testResume.setVisibility(8);
                            }
                        }
                        if (!TextUtils.isEmpty(list.get(i5).getImage())) {
                            SingleStudyAdapter.this.setThumbAccordingRatio(list.get(i5).getImage(), this.imageIcon);
                        } else if (SingleStudyAdapter.this.bottomSetting != null && SingleStudyAdapter.this.bottomSetting.getLayout_type() != null && SingleStudyAdapter.this.bottomSetting.getLayout_type().equals("1")) {
                            this.imageIcon.setImageResource(R.mipmap.square_placeholder);
                        } else {
                            this.imageIcon.setImageResource(R.mipmap.square_placeholder_new);
                        }
                        if (list.get(i5).getIs_locked().equals("0")) {
                            this.contantRL.setVisibility(0);
                            this.startdate.setVisibility(0);
                            this.subItemRV.setVisibility(0);
                        } else {
                            this.contantRL.setVisibility(8);
                            this.startdate.setVisibility(8);
                            this.subItemRV.setVisibility(8);
                        }
                        str2 = str;
                    } else {
                        this.share.setVisibility(8);
                        this.subItemRV.setVisibility(0);
                        this.attemptLL.setVisibility(8);
                        this.learn.setVisibility(8);
                        this.practice.setVisibility(8);
                        if (!TextUtils.isEmpty(list.get(i5).getImage_icon())) {
                            SingleStudyAdapter.this.setThumbAccordingRatio(list.get(i5).getImage_icon(), this.imageIcon);
                        } else if (SingleStudyAdapter.this.bottomSetting != null && SingleStudyAdapter.this.bottomSetting.getLayout_type() != null && SingleStudyAdapter.this.bottomSetting.getLayout_type().equals("1")) {
                            this.imageIcon.setImageResource(R.mipmap.square_placeholder);
                        } else {
                            this.imageIcon.setImageResource(R.mipmap.square_placeholder_new);
                        }
                        this.subItemRV.setVisibility(8);
                        this.subItemRV.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.total_) + list.get(i5).getCount());
                        this.titleCategory.setText(list.get(i5).getTitle());
                        str2 = "3";
                        if (SingleStudyAdapter.this.isSkip.equalsIgnoreCase(str2)) {
                            if (Helper.isLiveTest(list.get(i5).getTest_series_type()) && !list.get(i5).getEnd_date().equalsIgnoreCase("0") && !list.get(i5).getEnd_date().equalsIgnoreCase("")) {
                                this.subItemRV.setVisibility(0);
                                this.subItemRV.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.test_end) + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(list.get(i5).getEnd_date()) * 1000))));
                            } else {
                                this.subItemRV.setVisibility(8);
                            }
                            if (Helper.isLiveTest(list.get(i5).getTest_series_type()) && !list.get(i5).getStart_date().equalsIgnoreCase("0") && !list.get(i5).getStart_date().equalsIgnoreCase("")) {
                                this.startdate.setVisibility(0);
                                this.startdate.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.test_start) + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(list.get(i5).getStart_date()) * 1000))));
                            } else {
                                this.startdate.setVisibility(8);
                            }
                        }
                    }
                } else {
                    if (Helper.isShowShareButton(SingleStudyAdapter.this.leftMenu)) {
                        this.share.setVisibility(0);
                    } else {
                        this.share.setVisibility(8);
                    }
                    this.titleCategory.setText(list.get(i5).getTest_series_name());
                    if (Helper.isLiveTest(list.get(i5).getTest_series_type()) && !list.get(i5).getEnd_date().equalsIgnoreCase("0") && !list.get(i5).getEnd_date().equalsIgnoreCase("")) {
                        this.subItemRV.setVisibility(0);
                        i3 = i5;
                        this.subItemRV.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.test_end) + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(list.get(i5).getEnd_date()) * 1000))));
                    } else {
                        i3 = i5;
                        this.subItemRV.setVisibility(8);
                    }
                    int i6 = i3;
                    if (Helper.isLiveTest(list.get(i6).getTest_series_type()) && !list.get(i6).getStart_date().equalsIgnoreCase("0") && !list.get(i6).getStart_date().equalsIgnoreCase("")) {
                        this.startdate.setVisibility(0);
                        this.startdate.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.test_start) + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(list.get(i6).getStart_date()) * 1000))));
                    } else {
                        this.startdate.setVisibility(8);
                    }
                    this.attemptLL.setVisibility(0);
                    if (list.get(i6).getState().equals("1")) {
                        SingleStudyAdapter.this.utkashRoom.getTestDao().delete_test_data(MakeMyExam.userId, list.get(i6).getId());
                        if (MakeMyExam.time_server >= Long.parseLong(list.get(i6).getEnd_date()) * 1000) {
                            this.view_result.setVisibility(0);
                            if (list.get(i6).getResult_date().equalsIgnoreCase("0") || list.get(i6).getResult_date().equalsIgnoreCase("1") || list.get(i6).getResult_date().equalsIgnoreCase("")) {
                                this.attemptLL.setVisibility(8);
                                handleLearnPractice(list.get(i6));
                            } else if (MakeMyExam.time_server > Long.parseLong(list.get(i6).getResult_date()) * 1000) {
                                if (Long.parseLong(list.get(i6).getEnd_date()) < 1640066737) {
                                    this.attemptLL.setVisibility(8);
                                } else {
                                    this.attemptLL.setVisibility(8);
                                    if (list.get(i6).getState().equalsIgnoreCase("1")) {
                                        ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.view_result1));
                                    } else {
                                        ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.view_rank));
                                    }
                                }
                                handleLearnPractice(list.get(i6));
                            } else {
                                this.view_result.setVisibility(0);
                                this.attemptLL.setVisibility(8);
                                ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.attempted_));
                                handleLearnPractice(list.get(i6));
                            }
                        } else {
                            if (list.get(i6).getResult_date().equalsIgnoreCase("0") || list.get(i6).getResult_date().equalsIgnoreCase("1") || list.get(i6).getResult_date().equalsIgnoreCase("")) {
                                this.view_result.setVisibility(0);
                            } else {
                                this.view_result.setVisibility(0);
                            }
                            if (!list.get(i6).getIs_reattempt().equalsIgnoreCase("0")) {
                                this.learn.setVisibility(8);
                                this.practice.setVisibility(8);
                                this.attemptLL.setVisibility(0);
                                this.attemptLL.getChildAt(0).setVisibility(0);
                                ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.re_aTTEMPT));
                            } else if (list.get(i6).getResult_date() == null || list.get(i6).getResult_date().equalsIgnoreCase("1") || list.get(i6).getResult_date().equalsIgnoreCase("0") || list.get(i6).getResult_date().equalsIgnoreCase("")) {
                                this.learn.setVisibility(8);
                                this.practice.setVisibility(8);
                                this.attemptLL.getChildAt(0).setVisibility(0);
                                if (list.get(i6).getState().equalsIgnoreCase("1")) {
                                    ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.attempted_));
                                } else {
                                    ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.attempted_));
                                }
                            } else {
                                this.learn.setVisibility(8);
                                this.practice.setVisibility(8);
                                this.attemptLL.getChildAt(0).setVisibility(0);
                                ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.attempted));
                            }
                        }
                    } else if (MakeMyExam.time_server >= Long.parseLong(list.get(i6).getEnd_date()) * 1000) {
                        if (list.get(i6).getResult_date().equalsIgnoreCase("0") || list.get(i6).getResult_date().equalsIgnoreCase("1") || list.get(i6).getResult_date().equalsIgnoreCase("")) {
                            this.attemptLL.setVisibility(8);
                            handleLearnPractice(list.get(i6));
                            this.view_result.setVisibility(0);
                            this.view_result.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.view_rank));
                        }
                        if (Long.parseLong(list.get(i6).getResult_date()) * 1000 > System.currentTimeMillis()) {
                            this.attemptLL.setVisibility(8);
                            handleLearnPractice(list.get(i6));
                            this.view_result.setVisibility(8);
                            this.view_result.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.view_rank));
                        } else if (MakeMyExam.time_server > Long.parseLong(list.get(i6).getResult_date()) * 1000) {
                            this.view_result.setVisibility(0);
                            if (Long.parseLong(list.get(i6).getEnd_date()) < 1640066737) {
                                this.attemptLL.setVisibility(8);
                            } else {
                                this.attemptLL.setVisibility(8);
                                this.attemptLL.getChildAt(0).setVisibility(8);
                                if (list.get(i6).getState().equalsIgnoreCase("1")) {
                                    this.view_result.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.view_result1));
                                    ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.view_result1));
                                } else {
                                    this.view_result.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.view_rank));
                                    ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.view_rank));
                                }
                            }
                            handleLearnPractice(list.get(i6));
                        } else {
                            this.attemptLL.setVisibility(8);
                            handleLearnPractice(list.get(i6));
                        }
                    } else if (System.currentTimeMillis() < Long.parseLong(list.get(i6).getStart_date()) * 1000) {
                        this.attemptLL.getChildAt(0).setVisibility(0);
                        ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.upcoming_test));
                        this.learn.setVisibility(8);
                        this.practice.setVisibility(8);
                    } else {
                        TestTable testTableTest_data2 = SingleStudyAdapter.this.utkashRoom.getTestDao().test_data(list.get(i6).getId(), MakeMyExam.userId);
                        if (testTableTest_data2 != null && testTableTest_data2.getStatus() != null && !testTableTest_data2.getStatus().equalsIgnoreCase("")) {
                            this.attemptLL.getChildAt(0).setVisibility(0);
                            ((TextView) this.attemptLL.getChildAt(0)).setText(testTableTest_data2.getStatus());
                            this.learn.setVisibility(8);
                            this.practice.setVisibility(8);
                            i4 = 0;
                        } else {
                            i4 = 0;
                            this.attemptLL.getChildAt(0).setVisibility(0);
                        }
                        ((TextView) this.attemptLL.getChildAt(i4)).setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.attempt_now));
                        this.learn.setVisibility(8);
                        this.practice.setVisibility(8);
                        if (Helper.isTestResume(list.get(i6).getSet_type()) && list.get(i6).getAttempt().equalsIgnoreCase("0") && list.get(i6).getState() != null && list.get(i6).getState().equalsIgnoreCase("0")) {
                            this.testResume.setVisibility(0);
                            this.attemptLL.getChildAt(0).setVisibility(8);
                            ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.attempt_now));
                        } else {
                            this.attemptLL.getChildAt(0).setVisibility(0);
                            ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.attempt_now));
                            this.testResume.setVisibility(8);
                        }
                    }
                    if (!TextUtils.isEmpty(list.get(i6).getImage())) {
                        SingleStudyAdapter.this.setThumbAccordingRatio(list.get(i6).getImage(), this.imageIcon);
                    } else if (SingleStudyAdapter.this.bottomSetting != null && SingleStudyAdapter.this.bottomSetting.getLayout_type() != null && SingleStudyAdapter.this.bottomSetting.getLayout_type().equals("1")) {
                        this.imageIcon.setImageResource(R.mipmap.square_placeholder);
                    } else {
                        this.imageIcon.setImageResource(R.mipmap.square_placeholder_new);
                    }
                    if (SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type().equalsIgnoreCase("3")) {
                        if (list.get(i6).getIs_locked().equals("0")) {
                            if (list.get(i6).getMode().equalsIgnoreCase("0")) {
                                this.contantRL.setVisibility(0);
                                this.startdate.setVisibility(0);
                                this.subItemRV.setVisibility(0);
                            } else {
                                this.contantRL.setVisibility(8);
                            }
                        } else {
                            this.contantRL.setVisibility(8);
                            this.startdate.setVisibility(8);
                            this.subItemRV.setVisibility(8);
                        }
                    } else if (list.get(i6).getIs_locked().equals("0")) {
                        this.contantRL.setVisibility(0);
                        this.startdate.setVisibility(0);
                        this.subItemRV.setVisibility(0);
                    } else {
                        this.contantRL.setVisibility(8);
                        this.startdate.setVisibility(8);
                        this.subItemRV.setVisibility(8);
                    }
                    if (SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type().equalsIgnoreCase("3")) {
                        if (list != null && list.get(i6).getIs_locked().equals("0") && !list.get(i6).getIs_test_purchased().equalsIgnoreCase("1")) {
                            this.test_price_tv.setVisibility(0);
                            this.test_price_tv1.setVisibility(0);
                            if (list.get(i6).getTax_rate() != null) {
                                String str3 = String.format("%.2f", Double.valueOf(Double.parseDouble(list.get(i6).getPrice()) + Double.parseDouble(list.get(i6).getTax_rate())));
                                if (str3.equalsIgnoreCase("0.00")) {
                                    this.test_price_tv.setText(SingleStudyAdapter.this.activity.getResources().getText(R.string.free_));
                                    this.test_price_tv1.setVisibility(8);
                                } else {
                                    this.test_price_tv1.setVisibility(0);
                                    this.test_price_tv.setText(" " + SingleStudyAdapter.this.activity.getResources().getString(R.string.rupees) + str3 + "/-");
                                }
                            } else {
                                String str4 = String.format("%.2f", Double.valueOf(Double.parseDouble(list.get(i6).getPrice())));
                                if (str4.equalsIgnoreCase("0.00")) {
                                    this.test_price_tv.setText(SingleStudyAdapter.this.activity.getResources().getText(R.string.free_));
                                    this.test_price_tv1.setVisibility(8);
                                } else {
                                    this.test_price_tv1.setVisibility(0);
                                    this.test_price_tv.setText(" " + SingleStudyAdapter.this.activity.getResources().getString(R.string.rupees) + str4 + "/-");
                                }
                            }
                        } else {
                            this.test_price_tv.setVisibility(8);
                            this.test_price_tv1.setVisibility(8);
                        }
                        this.test_mode_tv.setVisibility(0);
                        this.test_mode_tv.setText(list.get(i6).getMode().equalsIgnoreCase("1") ? "Offline" : "Online");
                        this.titleCategory.setPadding(-1, 0, 84, 0);
                    }
                    ImageView imageView4 = this.forwardIV;
                    if (imageView4 != null) {
                        imageView4.setVisibility(8);
                    }
                }
                if (SingleStudyAdapter.this.isSkip.equalsIgnoreCase(str2)) {
                    this.practice.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyTestListHolder$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$setData$4(list, position, view);
                        }
                    });
                    this.testResume.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyTestListHolder$$ExternalSyntheticLambda11
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$setData$5(list, position, view);
                        }
                    });
                    this.learn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyTestListHolder$$ExternalSyntheticLambda16
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$setData$6(list, position, view);
                        }
                    });
                    this.view_result.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyTestListHolder$$ExternalSyntheticLambda17
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$setData$7(list, position, view);
                        }
                    });
                    this.attemptLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyTestListHolder$$ExternalSyntheticLambda18
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$setData$20(list, position, view);
                        }
                    });
                    this.share.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyTestListHolder$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return this.f$0.lambda$setData$21(position);
                        }
                    }));
                    this.studyitemLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyTestListHolder$$ExternalSyntheticLambda20
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$setData$22(list, position, view);
                        }
                    });
                } else {
                    this.studyitemLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyTestListHolder$$ExternalSyntheticLambda21
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$setData$23(list, position, view);
                        }
                    });
                }
            } else {
                SingleStudyAdapter.this.handleVisibilityNoData(this.ibt_single_sub_vd_RL, this.no_data_found_RL, this.backBtn);
            }
            if (SharedPreference.getInstance().getString(Const.SAME_CONTENT_VIEW) != null && !TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.SAME_CONTENT_VIEW)) && SharedPreference.getInstance().getString(Const.SAME_CONTENT_VIEW).equalsIgnoreCase("1")) {
                if (SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type().equalsIgnoreCase("0")) {
                    this.contantRL.setPadding(0, 12, 0, 0);
                } else if (SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type().equalsIgnoreCase(str2)) {
                    this.contantRL.setPadding(0, 0, 0, 0);
                }
            } else if (BuildConfig.FLAVOR.equalsIgnoreCase("DevalayaELearn") || BuildConfig.FLAVOR.equalsIgnoreCase("Narayana")) {
                this.contantRL.setPadding(0, 0, 0, 0);
            }
            if (list != null && list.size() > 0) {
                int i7 = position - 1;
                if (list.get(i7).getState() != null && list.get(i7).getState().equalsIgnoreCase("1")) {
                    if (list.get(i7).getIs_locked().equalsIgnoreCase("0")) {
                        this.contantRL.setVisibility(0);
                        ImageView imageView5 = this.forwardIV;
                        if (imageView5 != null) {
                            imageView5.setVisibility(8);
                        }
                        this.view_result.setVisibility(0);
                        if (list.get(i7).getSet_type().equalsIgnoreCase("8")) {
                            this.learn.setVisibility(8);
                            this.practice.setVisibility(8);
                            if (list.get(i7).getState().equalsIgnoreCase("1")) {
                                this.attemptLL.getChildAt(0).setVisibility(0);
                                if (!list.get(i7).getIs_reattempt().equalsIgnoreCase("0")) {
                                    ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.re_attempt_));
                                    return;
                                } else {
                                    ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.attempted));
                                    return;
                                }
                            }
                            this.attemptLL.setVisibility(8);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            if (list != null && list.size() > 0 && !list.get(position - 1).getIs_test_purchased().equalsIgnoreCase("1")) {
                if (BuildConfig.FLAVOR.equalsIgnoreCase("Narayana")) {
                    i = 8;
                    this.contantRL.setVisibility(8);
                    this.view_result.setVisibility(8);
                } else {
                    i = 8;
                }
                if (!SingleStudyAdapter.this.isSkip.equalsIgnoreCase(str2) || (imageView2 = this.forwardIV) == null) {
                    return;
                }
                imageView2.setVisibility(i);
                return;
            }
            if (list == null || list.size() <= 0) {
                return;
            }
            int i8 = position - 1;
            if (list.get(i8).getIs_test_purchased().equalsIgnoreCase("1")) {
                if (list.get(i8).getIs_locked().equalsIgnoreCase("0") && list.get(i8).getMode().equalsIgnoreCase("1")) {
                    this.contantRL.setVisibility(8);
                    this.registerText.setVisibility(0);
                    this.registerText.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.registered));
                    if (!SingleStudyAdapter.this.isSkip.equalsIgnoreCase(str2) || (imageView = this.forwardIV) == null) {
                        return;
                    }
                    imageView.setVisibility(8);
                    return;
                }
                if (list.get(i8).getIs_locked().equalsIgnoreCase("0") && list.get(i8).getMode().equalsIgnoreCase("0")) {
                    this.contantRL.setVisibility(0);
                    this.registerText.setVisibility(8);
                } else {
                    this.contantRL.setVisibility(8);
                    this.registerText.setVisibility(8);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$4(ArrayList arrayList, int i, View view) {
            if (!Helper.isConnected(SingleStudyAdapter.this.activity)) {
                Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                return;
            }
            if (SingleStudyAdapter.this.is_purchase.equalsIgnoreCase("1")) {
                SharedPreference.getInstance().putString("id", SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId());
                int i2 = i - 1;
                SingleStudyAdapter.this.quiz_id = ((Lists) arrayList.get(i2)).getId();
                SingleStudyAdapter.this.quiz_name = ((Lists) arrayList.get(i2)).getTest_series_name();
                SingleStudyAdapter.this.totalQuestion = ((Lists) arrayList.get(i2)).getTotal_questions();
                SingleStudyAdapter.this.result_date = ((Lists) arrayList.get(i2)).getResult_date();
                SingleStudyAdapter.this.submission_type = ((Lists) arrayList.get(i2)).getSubmission_type();
                SingleStudyAdapter.this.first_attempt = "0";
                SingleStudyAdapter.this.videodata = (Lists) arrayList.get(i2);
                Helper.resolveTestPattern(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.videodata.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyTestListHolder$$ExternalSyntheticLambda12
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setData$0();
                    }
                }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyTestListHolder$$ExternalSyntheticLambda13
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setData$1();
                    }
                });
                return;
            }
            int i3 = i - 1;
            if (((Lists) arrayList.get(i3)).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(SingleStudyAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, SingleStudyAdapter.this.activity);
                return;
            }
            SharedPreference.getInstance().putString("id", SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId());
            SingleStudyAdapter.this.quiz_id = ((Lists) arrayList.get(i3)).getId();
            SingleStudyAdapter.this.quiz_name = ((Lists) arrayList.get(i3)).getTest_series_name();
            SingleStudyAdapter.this.totalQuestion = ((Lists) arrayList.get(i3)).getTotal_questions();
            SingleStudyAdapter.this.first_attempt = "0";
            SingleStudyAdapter.this.result_date = ((Lists) arrayList.get(i3)).getResult_date();
            SingleStudyAdapter.this.videodata = (Lists) arrayList.get(i3);
            SingleStudyAdapter.this.submission_type = ((Lists) arrayList.get(i3)).getSubmission_type();
            Helper.resolveTestPattern(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.videodata.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyTestListHolder$$ExternalSyntheticLambda14
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setData$2();
                }
            }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyTestListHolder$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setData$3();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$0() {
            SingleStudyAdapter.this.isSSCpattern = false;
            startTestAPI("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$1() {
            SingleStudyAdapter.this.isSSCpattern = true;
            startTestAPI("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$2() {
            SingleStudyAdapter.this.isSSCpattern = false;
            startTestAPI("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$3() {
            SingleStudyAdapter.this.isSSCpattern = true;
            startTestAPI("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$5(ArrayList arrayList, int i, View view) {
            if (!Helper.isConnected(SingleStudyAdapter.this.activity)) {
                Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                return;
            }
            if (SingleStudyAdapter.this.is_purchase.equalsIgnoreCase("1")) {
                SharedPreference.getInstance().putString("id", SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId());
                int i2 = i - 1;
                SingleStudyAdapter.this.quiz_id = ((Lists) arrayList.get(i2)).getId();
                if (((Lists) arrayList.get(i2)).getLang_used().equalsIgnoreCase("")) {
                    SingleStudyAdapter.this.lang = Integer.parseInt(String.valueOf(((Lists) arrayList.get(i2)).getLang_id().charAt(0)));
                } else {
                    SingleStudyAdapter.this.lang = Integer.parseInt(((Lists) arrayList.get(i2)).getLang_used());
                }
                SingleStudyAdapter.this.quiz_name = ((Lists) arrayList.get(i2)).getTest_series_name();
                SingleStudyAdapter.this.totalQuestion = ((Lists) arrayList.get(i2)).getTotal_questions();
                SingleStudyAdapter.this.first_attempt = "0";
                SingleStudyAdapter.this.result_date = ((Lists) arrayList.get(i2)).getResult_date();
                SingleStudyAdapter.this.videodata = (Lists) arrayList.get(i2);
                startResumeTestAPI();
                return;
            }
            int i3 = i - 1;
            if (((Lists) arrayList.get(i3)).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(SingleStudyAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, SingleStudyAdapter.this.activity);
                return;
            }
            SharedPreference.getInstance().putString("id", SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId());
            SingleStudyAdapter.this.quiz_id = ((Lists) arrayList.get(i3)).getId();
            SingleStudyAdapter.this.lang = Integer.parseInt(((Lists) arrayList.get(i3)).getLang_used());
            SingleStudyAdapter.this.quiz_name = ((Lists) arrayList.get(i3)).getTest_series_name();
            SingleStudyAdapter.this.totalQuestion = ((Lists) arrayList.get(i3)).getTotal_questions();
            SingleStudyAdapter.this.first_attempt = "0";
            SingleStudyAdapter.this.result_date = ((Lists) arrayList.get(i3)).getResult_date();
            SingleStudyAdapter.this.videodata = (Lists) arrayList.get(i3);
            startResumeTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$6(ArrayList arrayList, int i, View view) {
            if (!Helper.isConnected(SingleStudyAdapter.this.activity)) {
                Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                return;
            }
            if (SingleStudyAdapter.this.is_purchase.equalsIgnoreCase("1")) {
                SharedPreference.getInstance().putString("id", SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId());
                int i2 = i - 1;
                if (((Lists) arrayList.get(i2)).getState().equalsIgnoreCase("1")) {
                    SingleStudyAdapter.this.quiz_id = ((Lists) arrayList.get(i2)).getId();
                    SingleStudyAdapter.this.quiz_name = ((Lists) arrayList.get(i2)).getTest_series_name();
                    SingleStudyAdapter.this.totalQuestion = ((Lists) arrayList.get(i2)).getTotal_questions();
                    result_without_submit(SingleStudyAdapter.this.quiz_id, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId(), "1", SingleStudyAdapter.this.quiz_name);
                    return;
                }
                SingleStudyAdapter.this.quiz_id = ((Lists) arrayList.get(i2)).getId();
                SingleStudyAdapter.this.quiz_name = ((Lists) arrayList.get(i2)).getTest_series_name();
                SingleStudyAdapter.this.totalQuestion = ((Lists) arrayList.get(i2)).getTotal_questions();
                result_without_submit(SingleStudyAdapter.this.quiz_id, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId(), "0", SingleStudyAdapter.this.quiz_name);
                return;
            }
            int i3 = i - 1;
            if (((Lists) arrayList.get(i3)).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(SingleStudyAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, SingleStudyAdapter.this.activity);
                return;
            }
            SharedPreference.getInstance().putString("id", SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId());
            if (((Lists) arrayList.get(i3)).getState().equalsIgnoreCase("1")) {
                SingleStudyAdapter.this.quiz_id = ((Lists) arrayList.get(i3)).getId();
                SingleStudyAdapter.this.quiz_name = ((Lists) arrayList.get(i3)).getTest_series_name();
                SingleStudyAdapter.this.totalQuestion = ((Lists) arrayList.get(i3)).getTotal_questions();
                result_without_submit(SingleStudyAdapter.this.quiz_id, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId(), "1", SingleStudyAdapter.this.quiz_name);
                return;
            }
            SingleStudyAdapter.this.quiz_id = ((Lists) arrayList.get(i3)).getId();
            SingleStudyAdapter.this.quiz_name = ((Lists) arrayList.get(i3)).getTest_series_name();
            SingleStudyAdapter.this.totalQuestion = ((Lists) arrayList.get(i3)).getTotal_questions();
            result_without_submit(SingleStudyAdapter.this.quiz_id, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId(), "0", SingleStudyAdapter.this.quiz_name);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$7(ArrayList arrayList, int i, View view) {
            if (!Helper.isConnected(SingleStudyAdapter.this.activity)) {
                Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                return;
            }
            if (SingleStudyAdapter.this.is_purchase.equalsIgnoreCase("1")) {
                SharedPreference.getInstance().putString("id", SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId());
                int i2 = i - 1;
                SingleStudyAdapter.this.quiz_id = ((Lists) arrayList.get(i2)).getId();
                SingleStudyAdapter.this.quiz_name = ((Lists) arrayList.get(i2)).getTest_series_name();
                SingleStudyAdapter.this.totalQuestion = ((Lists) arrayList.get(i2)).getTotal_questions();
                if (((Lists) arrayList.get(i2)).getState().equalsIgnoreCase("1")) {
                    if (((Lists) arrayList.get(i2)).getResult_date() == null || ((Lists) arrayList.get(i2)).getResult_date().equalsIgnoreCase("") || ((Lists) arrayList.get(i2)).getResult_date().equalsIgnoreCase("0") || ((Lists) arrayList.get(i2)).getResult_date().equalsIgnoreCase("1")) {
                        Intent intent = new Intent(SingleStudyAdapter.this.activity, (Class<?>) QuizActivity.class);
                        intent.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                        intent.putExtra("status", SingleStudyAdapter.this.quiz_id);
                        intent.putExtra("name", SingleStudyAdapter.this.quiz_name);
                        intent.putExtra("first_attempt", "1");
                        intent.putExtra("mode", ((Lists) arrayList.get(i2)).getSet_type().equalsIgnoreCase("8") ? "0" : ((Lists) arrayList.get(i2)).getMode());
                        Helper.gotoActivity(intent, SingleStudyAdapter.this.activity);
                        return;
                    }
                    if (MakeMyExam.time_server >= Long.parseLong(((Lists) arrayList.get(i2)).getResult_date()) * 1000) {
                        Intent intent2 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) QuizActivity.class);
                        intent2.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                        intent2.putExtra("status", SingleStudyAdapter.this.quiz_id);
                        intent2.putExtra("name", SingleStudyAdapter.this.quiz_name);
                        intent2.putExtra("first_attempt", "1");
                        intent2.putExtra("mode", ((Lists) arrayList.get(i2)).getSet_type().equalsIgnoreCase("8") ? "0" : ((Lists) arrayList.get(i2)).getMode());
                        Helper.gotoActivity(intent2, SingleStudyAdapter.this.activity);
                        return;
                    }
                    Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.your_result_will_be_declare_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(((Lists) arrayList.get(i2)).getResult_date()) * 1000)), 0).show();
                    return;
                }
                if (((Lists) arrayList.get(i2)).getResult_date() == null || ((Lists) arrayList.get(i2)).getResult_date().equalsIgnoreCase("") || ((Lists) arrayList.get(i2)).getResult_date().equalsIgnoreCase("0") || ((Lists) arrayList.get(i2)).getResult_date().equalsIgnoreCase("1")) {
                    Intent intent3 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) QuizActivity.class);
                    intent3.putExtra(Const.FRAG_TYPE, "leader_board");
                    intent3.putExtra("status", SingleStudyAdapter.this.quiz_id);
                    intent3.putExtra("name", SingleStudyAdapter.this.quiz_name);
                    SingleStudyAdapter.this.activity.startActivity(intent3);
                    return;
                }
                if (MakeMyExam.time_server >= Long.parseLong(((Lists) arrayList.get(i2)).getResult_date()) * 1000) {
                    Intent intent4 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) QuizActivity.class);
                    intent4.putExtra(Const.FRAG_TYPE, "leader_board");
                    intent4.putExtra("status", SingleStudyAdapter.this.quiz_id);
                    intent4.putExtra("name", SingleStudyAdapter.this.quiz_name);
                    SingleStudyAdapter.this.activity.startActivity(intent4);
                    return;
                }
                Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.your_result_will_be_declare_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(((Lists) arrayList.get(i2)).getResult_date()) * 1000)), 0).show();
                return;
            }
            int i3 = i - 1;
            if (((Lists) arrayList.get(i3)).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent5 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent5.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter.this.singleStudy);
                intent5.putExtra(Const.IS_BOOK, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent5.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent5, SingleStudyAdapter.this.activity);
                return;
            }
            if (((Lists) arrayList.get(i3)).getResult_date() == null || ((Lists) arrayList.get(i3)).getResult_date().equalsIgnoreCase("") || ((Lists) arrayList.get(i3)).getResult_date().equalsIgnoreCase("0") || ((Lists) arrayList.get(i3)).getResult_date().equalsIgnoreCase("1")) {
                SharedPreference.getInstance().putString("id", SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId());
                SingleStudyAdapter.this.quiz_id = ((Lists) arrayList.get(i3)).getId();
                SingleStudyAdapter.this.quiz_name = ((Lists) arrayList.get(i3)).getTest_series_name();
                SingleStudyAdapter.this.totalQuestion = ((Lists) arrayList.get(i3)).getTotal_questions();
                if (((Lists) arrayList.get(i3)).getState().equalsIgnoreCase("1")) {
                    if (((Lists) arrayList.get(i3)).getResult_date() == null || ((Lists) arrayList.get(i3)).getResult_date().equalsIgnoreCase("") || ((Lists) arrayList.get(i3)).getResult_date().equalsIgnoreCase("0") || ((Lists) arrayList.get(i3)).getResult_date().equalsIgnoreCase("1")) {
                        Intent intent6 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) QuizActivity.class);
                        intent6.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                        intent6.putExtra("status", SingleStudyAdapter.this.quiz_id);
                        intent6.putExtra("name", SingleStudyAdapter.this.quiz_name);
                        intent6.putExtra("first_attempt", "1");
                        intent6.putExtra("mode", ((Lists) arrayList.get(i3)).getSet_type().equalsIgnoreCase("8") ? "0" : ((Lists) arrayList.get(i3)).getMode());
                        Helper.gotoActivity(intent6, SingleStudyAdapter.this.activity);
                        return;
                    }
                    Intent intent7 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) QuizActivity.class);
                    intent7.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                    intent7.putExtra("status", SingleStudyAdapter.this.quiz_id);
                    intent7.putExtra("name", SingleStudyAdapter.this.quiz_name);
                    intent7.putExtra("first_attempt", "1");
                    intent7.putExtra("mode", ((Lists) arrayList.get(i3)).getSet_type().equalsIgnoreCase("8") ? "0" : ((Lists) arrayList.get(i3)).getMode());
                    Helper.gotoActivity(intent7, SingleStudyAdapter.this.activity);
                    return;
                }
                Intent intent8 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) QuizActivity.class);
                intent8.putExtra(Const.FRAG_TYPE, "leader_board");
                intent8.putExtra("status", SingleStudyAdapter.this.quiz_id);
                intent8.putExtra("name", SingleStudyAdapter.this.quiz_name);
                SingleStudyAdapter.this.activity.startActivity(intent8);
                return;
            }
            if (MakeMyExam.time_server >= Long.parseLong(((Lists) arrayList.get(i3)).getResult_date()) * 1000) {
                SharedPreference.getInstance().putString("id", SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId());
                SingleStudyAdapter.this.quiz_id = ((Lists) arrayList.get(i3)).getId();
                SingleStudyAdapter.this.quiz_name = ((Lists) arrayList.get(i3)).getTest_series_name();
                SingleStudyAdapter.this.totalQuestion = ((Lists) arrayList.get(i3)).getTotal_questions();
                if (((Lists) arrayList.get(i3)).getState().equalsIgnoreCase("1")) {
                    if (((Lists) arrayList.get(i3)).getResult_date() == null || ((Lists) arrayList.get(i3)).getResult_date().equalsIgnoreCase("") || ((Lists) arrayList.get(i3)).getResult_date().equalsIgnoreCase("0") || ((Lists) arrayList.get(i3)).getResult_date().equalsIgnoreCase("1")) {
                        Intent intent9 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) QuizActivity.class);
                        intent9.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                        intent9.putExtra("status", SingleStudyAdapter.this.quiz_id);
                        intent9.putExtra("name", SingleStudyAdapter.this.quiz_name);
                        intent9.putExtra("first_attempt", "1");
                        intent9.putExtra("mode", ((Lists) arrayList.get(i3)).getSet_type().equalsIgnoreCase("8") ? "0" : ((Lists) arrayList.get(i3)).getMode());
                        Helper.gotoActivity(intent9, SingleStudyAdapter.this.activity);
                        return;
                    }
                    Intent intent10 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) QuizActivity.class);
                    intent10.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                    intent10.putExtra("status", SingleStudyAdapter.this.quiz_id);
                    intent10.putExtra("name", SingleStudyAdapter.this.quiz_name);
                    intent10.putExtra("first_attempt", "1");
                    intent10.putExtra("mode", ((Lists) arrayList.get(i3)).getSet_type().equalsIgnoreCase("8") ? "0" : ((Lists) arrayList.get(i3)).getMode());
                    Helper.gotoActivity(intent10, SingleStudyAdapter.this.activity);
                    return;
                }
                Intent intent11 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) QuizActivity.class);
                intent11.putExtra(Const.FRAG_TYPE, "leader_board");
                intent11.putExtra("status", SingleStudyAdapter.this.quiz_id);
                intent11.putExtra("name", SingleStudyAdapter.this.quiz_name);
                SingleStudyAdapter.this.activity.startActivity(intent11);
                return;
            }
            Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.your_result_will_be_declare_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(((Lists) arrayList.get(i3)).getResult_date()) * 1000)), 0).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$20(ArrayList arrayList, int i, View view) {
            if (!Helper.isConnected(SingleStudyAdapter.this.activity)) {
                Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                return;
            }
            int i2 = i - 1;
            if (Helper.checkStartTime(Long.parseLong(((Lists) arrayList.get(i2)).getStart_date()))) {
                Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.test_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(((Lists) arrayList.get(i2)).getStart_date()) * 1000)), 0).show();
                return;
            }
            Log.e("TAG_APP", "setData: catType " + SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type());
            if (SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type().equalsIgnoreCase("3")) {
                SharedPreference.getInstance().putString("id", SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId());
                if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("RE-ATTEMPT")) {
                    SingleStudyAdapter.this.attemptOrReAttempt = "Re-attempt";
                    SingleStudyAdapter.this.quiz_id = ((Lists) arrayList.get(i2)).getId();
                    SingleStudyAdapter.this.quiz_name = ((Lists) arrayList.get(i2)).getTest_series_name();
                    SingleStudyAdapter.this.totalQuestion = ((Lists) arrayList.get(i2)).getTotal_questions();
                    SingleStudyAdapter.this.result_date = ((Lists) arrayList.get(i2)).getResult_date();
                    SingleStudyAdapter.this.submission_type = ((Lists) arrayList.get(i2)).getSubmission_type();
                    SingleStudyAdapter.this.first_attempt = "0";
                    SingleStudyAdapter.this.videodata = (Lists) arrayList.get(i2);
                    Helper.resolveTestPattern(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.videodata.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyTestListHolder$$ExternalSyntheticLambda22
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$setData$8();
                        }
                    }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyTestListHolder$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$setData$9();
                        }
                    });
                    return;
                }
                if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("Attempt Now")) {
                    SingleStudyAdapter.this.attemptOrReAttempt = Const.ATTEMPT;
                    SingleStudyAdapter.this.quiz_id = ((Lists) arrayList.get(i2)).getId();
                    SingleStudyAdapter.this.quiz_name = ((Lists) arrayList.get(i2)).getTest_series_name();
                    SingleStudyAdapter.this.totalQuestion = ((Lists) arrayList.get(i2)).getTotal_questions();
                    SingleStudyAdapter.this.first_attempt = "1";
                    SingleStudyAdapter.this.result_date = ((Lists) arrayList.get(i2)).getResult_date();
                    SingleStudyAdapter.this.submission_type = ((Lists) arrayList.get(i2)).getSubmission_type();
                    SingleStudyAdapter.this.videodata = (Lists) arrayList.get(i2);
                    Helper.resolveTestPattern(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.videodata.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyTestListHolder$$ExternalSyntheticLambda3
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$setData$10();
                        }
                    }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyTestListHolder$$ExternalSyntheticLambda4
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$setData$11();
                        }
                    });
                    return;
                }
                if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("ATTEMPTED")) {
                    if (((Lists) arrayList.get(i2)).getResult_date() != null && !((Lists) arrayList.get(i2)).getResult_date().equalsIgnoreCase("0") && !((Lists) arrayList.get(i2)).getResult_date().equalsIgnoreCase("1") && !((Lists) arrayList.get(i2)).getResult_date().equalsIgnoreCase("")) {
                        Snackbar.make(view, SingleStudyAdapter.this.activity.getResources().getString(R.string.your_result_will_be_declared_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(((Lists) arrayList.get(i2)).getResult_date()) * 1000)), -1).show();
                        return;
                    } else if (SingleStudyAdapter.this.utkashRoom.getTestDao().is_test_exit(((Lists) arrayList.get(i2)).getId(), MakeMyExam.userId)) {
                        Snackbar.make(view, SingleStudyAdapter.this.activity.getResources().getString(R.string.your_result_is_getting_ready_please_refresh_your_page), -1).show();
                        return;
                    } else {
                        Snackbar.make(view, SingleStudyAdapter.this.activity.getResources().getString(R.string.your_test_has_already_been_submitted), -1).show();
                        return;
                    }
                }
                if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("View Rank") || ((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("VIEW RESULT")) {
                    SingleStudyAdapter.this.quiz_id = ((Lists) arrayList.get(i2)).getId();
                    SingleStudyAdapter.this.quiz_name = ((Lists) arrayList.get(i2)).getTest_series_name();
                    SingleStudyAdapter.this.totalQuestion = ((Lists) arrayList.get(i2)).getTotal_questions();
                    if (((Lists) arrayList.get(i2)).getState().equalsIgnoreCase("1")) {
                        if (((Lists) arrayList.get(i2)).getResult_date() == null || ((Lists) arrayList.get(i2)).getResult_date().equalsIgnoreCase("") || ((Lists) arrayList.get(i2)).getResult_date().equalsIgnoreCase("0") || ((Lists) arrayList.get(i2)).getResult_date().equalsIgnoreCase("1")) {
                            Intent intent = new Intent(SingleStudyAdapter.this.activity, (Class<?>) QuizActivity.class);
                            intent.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                            intent.putExtra("status", SingleStudyAdapter.this.quiz_id);
                            intent.putExtra("name", SingleStudyAdapter.this.quiz_name);
                            intent.putExtra("first_attempt", "1");
                            intent.putExtra("mode", ((Lists) arrayList.get(i2)).getSet_type().equalsIgnoreCase("8") ? "0" : ((Lists) arrayList.get(i2)).getMode());
                            Helper.gotoActivity(intent, SingleStudyAdapter.this.activity);
                            return;
                        }
                        Intent intent2 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) QuizActivity.class);
                        intent2.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                        intent2.putExtra("status", SingleStudyAdapter.this.quiz_id);
                        intent2.putExtra("name", SingleStudyAdapter.this.quiz_name);
                        intent2.putExtra("first_attempt", "1");
                        intent2.putExtra("mode", ((Lists) arrayList.get(i2)).getSet_type().equalsIgnoreCase("8") ? "0" : ((Lists) arrayList.get(i2)).getMode());
                        Helper.gotoActivity(intent2, SingleStudyAdapter.this.activity);
                        return;
                    }
                    Intent intent3 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) QuizActivity.class);
                    intent3.putExtra(Const.FRAG_TYPE, "leader_board");
                    intent3.putExtra("status", SingleStudyAdapter.this.quiz_id);
                    intent3.putExtra("name", SingleStudyAdapter.this.quiz_name);
                    SingleStudyAdapter.this.activity.startActivity(intent3);
                    return;
                }
                if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase(SingleStudyAdapter.this.activity.getResources().getString(R.string.upcoming_test))) {
                    Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.test_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(((Lists) arrayList.get(i2)).getStart_date()) * 1000)), 0).show();
                    return;
                }
                return;
            }
            if (SingleStudyAdapter.this.is_purchase.equalsIgnoreCase("1")) {
                SharedPreference.getInstance().putString("id", SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId());
                if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("RE-ATTEMPT")) {
                    SingleStudyAdapter.this.attemptOrReAttempt = "Re-attempt";
                    SingleStudyAdapter.this.quiz_id = ((Lists) arrayList.get(i2)).getId();
                    SingleStudyAdapter.this.quiz_name = ((Lists) arrayList.get(i2)).getTest_series_name();
                    SingleStudyAdapter.this.totalQuestion = ((Lists) arrayList.get(i2)).getTotal_questions();
                    SingleStudyAdapter.this.result_date = ((Lists) arrayList.get(i2)).getResult_date();
                    SingleStudyAdapter.this.submission_type = ((Lists) arrayList.get(i2)).getSubmission_type();
                    SingleStudyAdapter.this.first_attempt = "0";
                    SingleStudyAdapter.this.videodata = (Lists) arrayList.get(i2);
                    Helper.resolveTestPattern(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.videodata.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyTestListHolder$$ExternalSyntheticLambda5
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$setData$12();
                        }
                    }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyTestListHolder$$ExternalSyntheticLambda6
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$setData$13();
                        }
                    });
                    return;
                }
                if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("Attempt Now")) {
                    SingleStudyAdapter.this.attemptOrReAttempt = Const.ATTEMPT;
                    SingleStudyAdapter.this.quiz_id = ((Lists) arrayList.get(i2)).getId();
                    SingleStudyAdapter.this.quiz_name = ((Lists) arrayList.get(i2)).getTest_series_name();
                    SingleStudyAdapter.this.totalQuestion = ((Lists) arrayList.get(i2)).getTotal_questions();
                    SingleStudyAdapter.this.first_attempt = "1";
                    SingleStudyAdapter.this.result_date = ((Lists) arrayList.get(i2)).getResult_date();
                    SingleStudyAdapter.this.submission_type = ((Lists) arrayList.get(i2)).getSubmission_type();
                    SingleStudyAdapter.this.videodata = (Lists) arrayList.get(i2);
                    Helper.resolveTestPattern(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.videodata.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyTestListHolder$$ExternalSyntheticLambda7
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$setData$14();
                        }
                    }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyTestListHolder$$ExternalSyntheticLambda8
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$setData$15();
                        }
                    });
                    return;
                }
                if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("ATTEMPTED")) {
                    if (((Lists) arrayList.get(i2)).getResult_date() != null && !((Lists) arrayList.get(i2)).getResult_date().equalsIgnoreCase("0") && !((Lists) arrayList.get(i2)).getResult_date().equalsIgnoreCase("1") && !((Lists) arrayList.get(i2)).getResult_date().equalsIgnoreCase("")) {
                        Snackbar.make(view, SingleStudyAdapter.this.activity.getResources().getString(R.string.your_result_will_be_declared_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(((Lists) arrayList.get(i2)).getResult_date()) * 1000)), -1).show();
                        return;
                    } else if (SingleStudyAdapter.this.utkashRoom.getTestDao().is_test_exit(((Lists) arrayList.get(i2)).getId(), MakeMyExam.userId)) {
                        Snackbar.make(view, SingleStudyAdapter.this.activity.getResources().getString(R.string.your_result_is_getting_ready_please_refresh_your_page), -1).show();
                        return;
                    } else {
                        Snackbar.make(view, SingleStudyAdapter.this.activity.getResources().getString(R.string.your_test_has_already_been_submitted), -1).show();
                        return;
                    }
                }
                if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("View Rank") || ((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("VIEW RESULT")) {
                    SingleStudyAdapter.this.quiz_id = ((Lists) arrayList.get(i2)).getId();
                    SingleStudyAdapter.this.quiz_name = ((Lists) arrayList.get(i2)).getTest_series_name();
                    SingleStudyAdapter.this.totalQuestion = ((Lists) arrayList.get(i2)).getTotal_questions();
                    if (((Lists) arrayList.get(i2)).getState().equalsIgnoreCase("1")) {
                        if (((Lists) arrayList.get(i2)).getResult_date() == null || ((Lists) arrayList.get(i2)).getResult_date().equalsIgnoreCase("") || ((Lists) arrayList.get(i2)).getResult_date().equalsIgnoreCase("0") || ((Lists) arrayList.get(i2)).getResult_date().equalsIgnoreCase("1")) {
                            Intent intent4 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) QuizActivity.class);
                            intent4.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                            intent4.putExtra("status", SingleStudyAdapter.this.quiz_id);
                            intent4.putExtra("name", SingleStudyAdapter.this.quiz_name);
                            intent4.putExtra("first_attempt", "1");
                            intent4.putExtra("mode", ((Lists) arrayList.get(i2)).getSet_type().equalsIgnoreCase("8") ? "0" : ((Lists) arrayList.get(i2)).getMode());
                            Helper.gotoActivity(intent4, SingleStudyAdapter.this.activity);
                            return;
                        }
                        Intent intent5 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) QuizActivity.class);
                        intent5.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                        intent5.putExtra("status", SingleStudyAdapter.this.quiz_id);
                        intent5.putExtra("name", SingleStudyAdapter.this.quiz_name);
                        intent5.putExtra("first_attempt", "1");
                        intent5.putExtra("mode", ((Lists) arrayList.get(i2)).getSet_type().equalsIgnoreCase("8") ? "0" : ((Lists) arrayList.get(i2)).getMode());
                        Helper.gotoActivity(intent5, SingleStudyAdapter.this.activity);
                        return;
                    }
                    Intent intent6 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) QuizActivity.class);
                    intent6.putExtra(Const.FRAG_TYPE, "leader_board");
                    intent6.putExtra("status", SingleStudyAdapter.this.quiz_id);
                    intent6.putExtra("name", SingleStudyAdapter.this.quiz_name);
                    SingleStudyAdapter.this.activity.startActivity(intent6);
                    return;
                }
                if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase(SingleStudyAdapter.this.activity.getResources().getString(R.string.upcoming_test))) {
                    Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.test_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(((Lists) arrayList.get(i2)).getStart_date()) * 1000)), 0).show();
                    return;
                }
                return;
            }
            if (((Lists) arrayList.get(i2)).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent7 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent7.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter.this.singleStudy);
                intent7.putExtra(Const.IS_BOOK, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent7.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent7, SingleStudyAdapter.this.activity);
                return;
            }
            SharedPreference.getInstance().putString("id", SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId());
            if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("RE-ATTEMPT")) {
                SingleStudyAdapter.this.quiz_id = ((Lists) arrayList.get(i2)).getId();
                SingleStudyAdapter.this.quiz_name = ((Lists) arrayList.get(i2)).getTest_series_name();
                SingleStudyAdapter.this.totalQuestion = ((Lists) arrayList.get(i2)).getTotal_questions();
                SingleStudyAdapter.this.first_attempt = "0";
                SingleStudyAdapter.this.result_date = ((Lists) arrayList.get(i2)).getResult_date();
                SingleStudyAdapter.this.submission_type = ((Lists) arrayList.get(i2)).getSubmission_type();
                SingleStudyAdapter.this.videodata = (Lists) arrayList.get(i2);
                Helper.resolveTestPattern(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.videodata.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyTestListHolder$$ExternalSyntheticLambda9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setData$16();
                    }
                }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyTestListHolder$$ExternalSyntheticLambda10
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setData$17();
                    }
                });
                return;
            }
            if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("Attempt Now")) {
                SingleStudyAdapter.this.quiz_id = ((Lists) arrayList.get(i2)).getId();
                SingleStudyAdapter.this.quiz_name = ((Lists) arrayList.get(i2)).getTest_series_name();
                SingleStudyAdapter.this.totalQuestion = ((Lists) arrayList.get(i2)).getTotal_questions();
                SingleStudyAdapter.this.first_attempt = "1";
                SingleStudyAdapter.this.result_date = ((Lists) arrayList.get(i2)).getResult_date();
                SingleStudyAdapter.this.submission_type = ((Lists) arrayList.get(i2)).getSubmission_type();
                SingleStudyAdapter.this.videodata = (Lists) arrayList.get(i2);
                SingleStudyAdapter.this.attemptOrReAttempt = ((Lists) arrayList.get(i2)).getState().equalsIgnoreCase("") ? Const.ATTEMPT : "Re-attempt";
                Helper.resolveTestPattern(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.videodata.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyTestListHolder$$ExternalSyntheticLambda23
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setData$18();
                    }
                }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyTestListHolder$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setData$19();
                    }
                });
                return;
            }
            if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("ATTEMPTED")) {
                if (((Lists) arrayList.get(i2)).getResult_date() != null && !((Lists) arrayList.get(i2)).getResult_date().equalsIgnoreCase("0") && !((Lists) arrayList.get(i2)).getResult_date().equalsIgnoreCase("1") && !((Lists) arrayList.get(i2)).getResult_date().equalsIgnoreCase("")) {
                    Snackbar.make(view, SingleStudyAdapter.this.activity.getResources().getString(R.string.your_result_will_be_declared_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(((Lists) arrayList.get(i2)).getResult_date()) * 1000)), -1).show();
                    return;
                } else if (SingleStudyAdapter.this.utkashRoom.getTestDao().is_test_exit(((Lists) arrayList.get(i2)).getId(), MakeMyExam.userId)) {
                    Snackbar.make(view, SingleStudyAdapter.this.activity.getResources().getString(R.string.your_result_is_getting_ready_please_refresh_your_page), -1).show();
                    return;
                } else {
                    Snackbar.make(view, SingleStudyAdapter.this.activity.getResources().getString(R.string.your_result_has_already_been_submitted), -1).show();
                    return;
                }
            }
            if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("View Rank") || ((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("VIEW RESULT")) {
                SingleStudyAdapter.this.quiz_id = ((Lists) arrayList.get(i2)).getId();
                SingleStudyAdapter.this.quiz_name = ((Lists) arrayList.get(i2)).getTest_series_name();
                SingleStudyAdapter.this.totalQuestion = ((Lists) arrayList.get(i2)).getTotal_questions();
                if (((Lists) arrayList.get(i2)).getState().equalsIgnoreCase("1")) {
                    if (((Lists) arrayList.get(i2)).getResult_date() == null || ((Lists) arrayList.get(i2)).getResult_date().equalsIgnoreCase("") || ((Lists) arrayList.get(i2)).getResult_date().equalsIgnoreCase("0") || ((Lists) arrayList.get(i2)).getResult_date().equalsIgnoreCase("1")) {
                        Intent intent8 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) QuizActivity.class);
                        intent8.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                        intent8.putExtra("status", SingleStudyAdapter.this.quiz_id);
                        intent8.putExtra("name", SingleStudyAdapter.this.quiz_name);
                        intent8.putExtra("first_attempt", "1");
                        intent8.putExtra("mode", ((Lists) arrayList.get(i2)).getSet_type().equalsIgnoreCase("8") ? "0" : ((Lists) arrayList.get(i2)).getMode());
                        Helper.gotoActivity(intent8, SingleStudyAdapter.this.activity);
                        return;
                    }
                    Intent intent9 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) QuizActivity.class);
                    intent9.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                    intent9.putExtra("status", SingleStudyAdapter.this.quiz_id);
                    intent9.putExtra("name", SingleStudyAdapter.this.quiz_name);
                    intent9.putExtra("first_attempt", "1");
                    intent9.putExtra("mode", ((Lists) arrayList.get(i2)).getSet_type().equalsIgnoreCase("8") ? "0" : ((Lists) arrayList.get(i2)).getMode());
                    Helper.gotoActivity(intent9, SingleStudyAdapter.this.activity);
                    return;
                }
                Intent intent10 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) QuizActivity.class);
                intent10.putExtra(Const.FRAG_TYPE, "leader_board");
                intent10.putExtra("status", SingleStudyAdapter.this.quiz_id);
                intent10.putExtra("name", SingleStudyAdapter.this.quiz_name);
                SingleStudyAdapter.this.activity.startActivity(intent10);
                return;
            }
            if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase(SingleStudyAdapter.this.activity.getResources().getString(R.string.upcoming_test))) {
                Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.test_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(((Lists) arrayList.get(i2)).getStart_date()) * 1000)), 0).show();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$8() {
            SingleStudyAdapter.this.isSSCpattern = false;
            startTestAPI("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$9() {
            SingleStudyAdapter.this.isSSCpattern = true;
            startTestAPI("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$10() {
            SingleStudyAdapter.this.isSSCpattern = false;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$11() {
            SingleStudyAdapter.this.isSSCpattern = true;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$12() {
            SingleStudyAdapter.this.isSSCpattern = false;
            startTestAPI("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$13() {
            SingleStudyAdapter.this.isSSCpattern = true;
            startTestAPI("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$14() {
            SingleStudyAdapter.this.isSSCpattern = false;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$15() {
            SingleStudyAdapter.this.isSSCpattern = true;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$16() {
            SingleStudyAdapter.this.isSSCpattern = false;
            startTestAPI("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$17() {
            SingleStudyAdapter.this.isSSCpattern = true;
            startTestAPI("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$18() {
            SingleStudyAdapter.this.isSSCpattern = false;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$19() {
            SingleStudyAdapter.this.isSSCpattern = true;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$setData$21(int i) {
            if (SingleStudyAdapter.this.is_purchase.equalsIgnoreCase("1")) {
                int i2 = i - 1;
                Helper.shareTestg(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getTopic_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getRevert_api(), Const.TEST, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getImage(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle(), SingleStudy.parentCourseId);
            } else {
                int i3 = i - 1;
                if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getIs_locked().equalsIgnoreCase("1")) {
                    if (SingleStudyAdapter.this.isCourseSoldOut()) {
                        Toast.makeText(SingleStudyAdapter.this.activity, R.string.sold_out_msg, 0).show();
                        return null;
                    }
                    Intent intent = new Intent(SingleStudyAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                    intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter.this.singleStudy);
                    intent.putExtra(Const.IS_BOOK, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                    intent.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                    Helper.gotoActivity(intent, SingleStudyAdapter.this.activity);
                } else {
                    Helper.shareTestg(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getCourse_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getTopic_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getTile_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getTile_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getRevert_api(), Const.TEST, SingleStudyAdapter.this.examPrepItem.getList().get(i3).getImage(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getTitle(), SingleStudy.parentCourseId);
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$22(ArrayList arrayList, int i, View view) {
            int i2 = i - 1;
            if (((Lists) arrayList.get(i2)).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(SingleStudyAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, SingleStudyAdapter.this.activity);
                return;
            }
            if (arrayList == null || ((Lists) arrayList.get(i2)).getIs_test_purchased().equalsIgnoreCase("1") || !SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type().equalsIgnoreCase("3")) {
                return;
            }
            JSONArray jSONArray = new JSONArray();
            try {
                Lists lists = (Lists) arrayList.get(i2);
                if (!((Lists) arrayList.get(i2)).getIs_test_purchased().equalsIgnoreCase("1")) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("id", ((Lists) arrayList.get(i2)).getId());
                    jSONObject.put("test_series_name", ((Lists) arrayList.get(i2)).getTest_series_name());
                    jSONObject.put("title", ((Lists) arrayList.get(i2)).getTitle());
                    jSONObject.put(FirebaseAnalytics.Param.PRICE, ((Lists) arrayList.get(i2)).getPrice());
                    jSONObject.put(Const.TEST_TYPE, ((Lists) arrayList.get(i2)).getMode());
                    jSONObject.put(FirebaseAnalytics.Param.START_DATE, ((Lists) arrayList.get(i2)).getStart_date());
                    jSONObject.put(FirebaseAnalytics.Param.END_DATE, ((Lists) arrayList.get(i2)).getEnd_date());
                    jSONObject.put("result_date", ((Lists) arrayList.get(i2)).getResult_date());
                    jSONObject.put("time_in_mins", ((Lists) arrayList.get(i2)).getTime_in_mins());
                    jSONObject.put("is_gst", ((Lists) arrayList.get(i2)).getIs_gst());
                    jSONObject.put("tax_rate", ((Lists) arrayList.get(i2)).getTax_rate());
                    jSONArray.put(jSONObject);
                    if (jSONArray.length() > 0) {
                        if (SingleStudyAdapter.this.isCourseSoldOut() && ((Lists) arrayList.get(i2)).getIs_locked().equalsIgnoreCase("1")) {
                            Toast.makeText(SingleStudyAdapter.this.activity, R.string.sold_out_msg, 0).show();
                            return;
                        }
                        Intent intent2 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                        intent2.putExtra("test_data", jSONArray.toString());
                        intent2.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter.this.singleStudy);
                        intent2.putExtra("test_id", lists.getId());
                        intent2.putExtra(Const.IS_BOOK, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                        intent2.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                        Helper.gotoActivity(intent2, SingleStudyAdapter.this.activity);
                        return;
                    }
                    Toast.makeText(SingleStudyAdapter.this.activity, "Scholarship Test is not available", 0).show();
                    return;
                }
                Toast.makeText(SingleStudyAdapter.this.activity, "Already Enrolled", 0).show();
            } catch (JSONException e2) {
                throw new RuntimeException(e2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$23(ArrayList arrayList, int i, View view) {
            String str;
            String str2;
            Intent intent;
            String str3;
            String str4;
            Intent intent2;
            int i2 = i - 1;
            if (((Lists) arrayList.get(i2)).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent3 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent3.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter.this.singleStudy);
                intent3.putExtra(Const.IS_BOOK, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent3.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent3, SingleStudyAdapter.this.activity);
                return;
            }
            if (SingleStudyAdapter.this.isSkip.equalsIgnoreCase("1")) {
                str = Const.IS_COMBO;
                str2 = "content_type";
            } else {
                str2 = "content_type";
                if (!SingleStudyAdapter.this.isSkip.equalsIgnoreCase("2")) {
                    if (SingleStudyAdapter.this.isSkip.equalsIgnoreCase("3")) {
                        return;
                    }
                    ExamPrepItem examPrepItem = new ExamPrepItem();
                    examPrepItem.setList(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getList());
                    if (!TextUtils.isEmpty(SingleStudyAdapter.this.content_type) && SingleStudyAdapter.this.content_type.equalsIgnoreCase("1") && !SingleStudyAdapter.this.tileIdAPI.equalsIgnoreCase("0")) {
                        str3 = Const.TAB_TILE_VISIBILITY;
                        str4 = "0";
                        intent2 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) FolderActivity.class);
                        intent2.putExtra("title", arrayList.get(i2) != null ? ((Lists) arrayList.get(i2)).getTitle() : "Main Folder");
                        intent2.putExtra("firstTime", "1");
                    } else {
                        str3 = Const.TAB_TILE_VISIBILITY;
                        str4 = "0";
                        intent2 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) CourseActivity.class);
                        intent2.putExtra("title", SingleStudyAdapter.this.singleStudy.getData().getCourseDetail() != null ? SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getTitle() : "Course");
                    }
                    SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(SingleStudyAdapter.this.singleStudy != null ? SingleStudyAdapter.this.singleStudy : new CourseDetail()));
                    SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(examPrepItem));
                    SharedPreference.getInstance().putString("list", new Gson().toJson(arrayList.get(i2) != null ? arrayList.get(i2) : new Lists()));
                    intent2.putExtra(Const.FRAG_TYPE, Const.EXAMPREP);
                    if (SingleStudyAdapter.this.tileTypeAPI.equals(Const.COMBO) || SingleStudyAdapter.this.tileTypeAPI.equals("content")) {
                        intent2.putExtra(str3, "1");
                    } else {
                        intent2.putExtra(str3, str4);
                    }
                    intent2.putExtra(Const.IS_COMBO, SingleStudyAdapter.this.isCombo);
                    intent2.putExtra(str2, SingleStudyAdapter.this.contentType);
                    intent2.putExtra("tile_id", SingleStudyAdapter.this.tileIdAPI);
                    intent2.putExtra(Const.TILE_TYPE, SingleStudyAdapter.this.tileTypeAPI);
                    intent2.putExtra(Const.REVERT_API, SingleStudyAdapter.this.revertAPI);
                    Helper.gotoActivity(intent2, SingleStudyAdapter.this.activity);
                    return;
                }
                str = Const.IS_COMBO;
            }
            if (!TextUtils.isEmpty(SingleStudyAdapter.this.content_type) && SingleStudyAdapter.this.content_type.equalsIgnoreCase("1") && !SingleStudyAdapter.this.tileIdAPI.equalsIgnoreCase("0")) {
                intent = new Intent(SingleStudyAdapter.this.activity, (Class<?>) FolderActivity.class);
                intent.putExtra("title", arrayList.get(i2) != null ? ((Lists) arrayList.get(i2)).getTitle() : "Main Folder");
                intent.putExtra("firstTime", "1");
            } else {
                Intent intent4 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) CourseActivity.class);
                intent4.putExtra("title", SingleStudyAdapter.this.singleStudy.getData().getCourseDetail() != null ? SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getTitle() : "Course");
                if (SingleStudyAdapter.this.tileTypeAPI.equals(Const.COMBO) || SingleStudyAdapter.this.tileTypeAPI.equals("content")) {
                    intent4.putExtra(Const.TAB_TILE_VISIBILITY, "1");
                } else {
                    intent4.putExtra(Const.TAB_TILE_VISIBILITY, "0");
                }
                intent = intent4;
            }
            SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(SingleStudyAdapter.this.singleStudy != null ? SingleStudyAdapter.this.singleStudy : new CourseDetail()));
            SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(SingleStudyAdapter.this.examPrepItem != null ? SingleStudyAdapter.this.examPrepItem : new ExamPrepItem()));
            SharedPreference.getInstance().putString("list", new Gson().toJson(SingleStudyAdapter.this.examPrepItem.getList().get(i2) != null ? SingleStudyAdapter.this.examPrepItem.getList().get(i2) : new Lists()));
            intent.putExtra(Const.FRAG_TYPE, Const.EXAMPREPLAST);
            intent.putExtra(str, SingleStudyAdapter.this.isCombo);
            intent.putExtra(str2, SingleStudyAdapter.this.contentType);
            intent.putExtra(Const.TEST_TYPE, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getCount());
            intent.putExtra("tile_id", SingleStudyAdapter.this.tileIdAPI);
            intent.putExtra(Const.TILE_TYPE, SingleStudyAdapter.this.tileTypeAPI);
            intent.putExtra(Const.LIST_SUBJECT, SingleStudyAdapter.this.examPrepItem.getList().get(i2));
            intent.putExtra(Const.REVERT_API, SingleStudyAdapter.this.revertAPI);
            Helper.gotoActivity(intent, SingleStudyAdapter.this.activity);
        }

        private void handleLearnPractice(Lists lists) {
            boolean zIsLearnPracticeHide = Helper.isLearnPracticeHide();
            boolean z = (lists == null || Helper.isLiveTest(lists.getTest_series_type())) ? false : true;
            if (zIsLearnPracticeHide || z) {
                this.learn.setVisibility(8);
                this.practice.setVisibility(8);
            } else {
                this.learn.setVisibility(0);
                this.practice.setVisibility(0);
            }
        }

        private void startResumeTestAPI() {
            SingleStudyAdapter.this.first_attempt = "1";
            SingleStudyAdapter.this.isSSCpattern = false;
            SingleStudyAdapter singleStudyAdapter = SingleStudyAdapter.this;
            new NetworkCall(singleStudyAdapter, singleStudyAdapter.activity).NetworkAPICall(API.API_GET_INFO_TEST_SERIES, "", true, false);
        }

        private void startTestAPI() {
            SingleStudyAdapter.this.isReAttemptOrPractice = false;
            SingleStudyAdapter singleStudyAdapter = SingleStudyAdapter.this;
            new NetworkCall(singleStudyAdapter, singleStudyAdapter.activity).NetworkAPICall(API.API_GET_TEST_INSTRUCTION_DATA, "", true, false);
        }

        private void startTestAPI(String s) {
            SingleStudyAdapter.this.isReAttemptOrPractice = true;
            SingleStudyAdapter singleStudyAdapter = SingleStudyAdapter.this;
            new NetworkCall(singleStudyAdapter, singleStudyAdapter.activity).NetworkAPICall(API.API_GET_TEST_INSTRUCTION_DATA, "", true, false);
        }

        public void result_without_submit(final String quiz_id, String course_id, String s, final String quiz_name) {
            if (Helper.isNetworkConnected(SingleStudyAdapter.this.activity)) {
                final Progress progress = new Progress(SingleStudyAdapter.this.activity);
                progress.show();
                APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setTest_id(quiz_id);
                encryptionData.setCourse_id(course_id);
                encryptionData.setFirst_attempt(s);
                aPIInterface.getTestlearn(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new Callback<String>() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter.SingleStudyTestListHolder.1
                    @Override // retrofit2.Callback
                    public void onResponse(Call<String> call, Response<String> response) {
                        JSONObject jSONObject;
                        progress.dismiss();
                        if (response.body() != null) {
                            ResultTestSeries_Report resultTestSeries_Report = null;
                            try {
                                jSONObject = new JSONObject(AES.decrypt(response.body(), AES.generatekeyAPI(), AES.generateVectorAPI()));
                                try {
                                    resultTestSeries_Report = (ResultTestSeries_Report) new Gson().fromJson(jSONObject.toString(), ResultTestSeries_Report.class);
                                } catch (Exception unused) {
                                }
                            } catch (Exception unused2) {
                                jSONObject = null;
                            }
                            if (resultTestSeries_Report == null) {
                                Helper.showToastSecurity(SingleStudyAdapter.this.activity);
                                return;
                            }
                            try {
                                if (resultTestSeries_Report.getStatus().equalsIgnoreCase("true")) {
                                    SharedPreference.getInstance().putString("testresult", new Gson().toJson(resultTestSeries_Report));
                                    Intent intent = new Intent(SingleStudyAdapter.this.activity, (Class<?>) ViewSolutionActivity.class);
                                    intent.putExtra(Const.TESTSEGMENT_ID, quiz_id);
                                    intent.putExtra(Const.FRAG_TYPE, Const.SOLUTIONREPORT);
                                    intent.putExtra("name", quiz_name);
                                    intent.putExtra("type", "learn");
                                    if (!resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("1")) {
                                        if (resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("2")) {
                                            SingleStudyAdapter.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                                        }
                                    } else {
                                        SingleStudyAdapter.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                                    }
                                    intent.putExtra(Const.LANG, SingleStudyAdapter.this.lang);
                                    Helper.gotoActivity(intent, SingleStudyAdapter.this.activity);
                                    return;
                                }
                                progress.dismiss();
                                RetrofitResponse.GetApiData(SingleStudyAdapter.this.activity, jSONObject.optString("auth_code"), jSONObject.optString("message"), false);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }

                    @Override // retrofit2.Callback
                    public void onFailure(Call<String> call, Throwable t) {
                        progress.dismiss();
                    }
                });
                return;
            }
            Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.Retry_with_Internet_connection), 1).show();
        }

        public void netoworkCallForQuizResult2(final String quiz_id, String course_id, String s, final String quiz_name) {
            if (Helper.isNetworkConnected(SingleStudyAdapter.this.activity)) {
                final Progress progress = new Progress(SingleStudyAdapter.this.activity);
                progress.show();
                APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setTest_id(quiz_id);
                encryptionData.setCourse_id(course_id);
                encryptionData.setFirst_attempt(s);
                aPIInterface.getTestResult(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new Callback<String>() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter.SingleStudyTestListHolder.2
                    @Override // retrofit2.Callback
                    public void onResponse(Call<String> call, Response<String> response) {
                        JSONObject jSONObject;
                        progress.dismiss();
                        if (response.body() != null) {
                            ResultTestSeries_Report resultTestSeries_Report = null;
                            try {
                                jSONObject = new JSONObject(AES.decrypt(response.body(), AES.generatekeyAPI(), AES.generateVectorAPI()));
                                try {
                                    resultTestSeries_Report = (ResultTestSeries_Report) new Gson().fromJson(jSONObject.toString(), ResultTestSeries_Report.class);
                                } catch (Exception unused) {
                                }
                            } catch (Exception unused2) {
                                jSONObject = null;
                            }
                            if (resultTestSeries_Report == null) {
                                Helper.showToastSecurity(SingleStudyAdapter.this.activity);
                                return;
                            }
                            try {
                                if (resultTestSeries_Report.getStatus().equalsIgnoreCase("true")) {
                                    if (resultTestSeries_Report.getData().getQuestions() != null && resultTestSeries_Report.getData().getQuestions().size() > 0) {
                                        SharedPreference.getInstance().putString("testresult", new Gson().toJson(resultTestSeries_Report));
                                        Intent intent = new Intent(SingleStudyAdapter.this.activity, (Class<?>) ViewSolutionActivity.class);
                                        intent.putExtra(Const.TESTSEGMENT_ID, quiz_id);
                                        intent.putExtra(Const.FRAG_TYPE, Const.SOLUTIONREPORT);
                                        intent.putExtra("name", quiz_name);
                                        intent.putExtra("type", "learn");
                                        if (!resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("1")) {
                                            if (resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("2")) {
                                                SingleStudyAdapter.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                                            }
                                        } else {
                                            SingleStudyAdapter.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                                        }
                                        intent.putExtra(Const.LANG, SingleStudyAdapter.this.lang);
                                        Helper.gotoActivity(intent, SingleStudyAdapter.this.activity);
                                        return;
                                    }
                                    Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.no_question_found), 0).show();
                                    return;
                                }
                                progress.dismiss();
                                RetrofitResponse.GetApiData(SingleStudyAdapter.this.activity, jSONObject.optString("auth_code"), jSONObject.optString("message"), false);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }

                    @Override // retrofit2.Callback
                    public void onFailure(Call<String> call, Throwable t) {
                        progress.dismiss();
                    }
                });
                return;
            }
            Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.Retry_with_Internet_connection), 1).show();
        }
    }

    public class SingleStudyListHolder extends RecyclerView.ViewHolder {
        LinearLayout LogsLL;
        LinearLayout actalll;
        TextView actualduration;
        Button backBtn;
        CheckBox checkMark;
        LinearLayout classTimingRow;
        LinearLayout classdurationll;
        TextView duration;
        TextView endDate;
        TextView examPrepTitleTV_new;
        ImageView forwardIV;
        CardView ibt_single_sub_vd_RL;
        ImageView imageIcon;
        RelativeLayout imageRL;
        RelativeLayout layout_fun;
        TextView listen_now;
        ImageView liveIV;
        LinearLayout llEnableMarkAsRead;
        RelativeLayout lockRL;
        RelativeLayout no_data_found_RL;
        ImageView optionMenuImgView;
        RelativeLayout parentLL;
        TextView pdf_TV;
        TextView play_now;
        TextView read_now;
        TextView remaining_time;
        LinearLayout remainingtimell;
        ImageView share;
        TextView startDate;
        RelativeLayout studyitemLL;
        TextView subItemRV;
        TextView titleCategory;
        TextView total_view_time;
        LinearLayout totalviewtimell;
        TextView tvMark;
        View view1;
        TextView watch_now;

        public SingleStudyListHolder(View itemView) {
            super(itemView);
            this.examPrepTitleTV_new = (TextView) itemView.findViewById(R.id.examPrepTitleTV_new);
            this.lockRL = (RelativeLayout) itemView.findViewById(R.id.lockRL);
            this.forwardIV = (ImageView) itemView.findViewById(R.id.forwardIV);
            this.liveIV = (ImageView) itemView.findViewById(R.id.liveIV);
            this.imageRL = (RelativeLayout) itemView.findViewById(R.id.imageRL);
            this.parentLL = (RelativeLayout) itemView.findViewById(R.id.parentLL);
            this.listen_now = (TextView) itemView.findViewById(R.id.listne_now);
            this.pdf_TV = (TextView) itemView.findViewById(R.id.pdf_TV);
            this.play_now = (TextView) itemView.findViewById(R.id.play_now);
            this.studyitemLL = (RelativeLayout) itemView.findViewById(R.id.study_single_itemLL);
            this.imageIcon = (ImageView) itemView.findViewById(R.id.profileImage);
            this.watch_now = (TextView) itemView.findViewById(R.id.watch_now);
            this.read_now = (TextView) itemView.findViewById(R.id.read_now);
            this.share = (ImageView) itemView.findViewById(R.id.share);
            this.titleCategory = (TextView) itemView.findViewById(R.id.examPrepTitleTV);
            this.subItemRV = (TextView) itemView.findViewById(R.id.subItemRV);
            this.layout_fun = (RelativeLayout) itemView.findViewById(R.id.layout_fun);
            this.optionMenuImgView = (ImageView) itemView.findViewById(R.id.optionMenuImgView);
            this.ibt_single_sub_vd_RL = (CardView) itemView.findViewById(R.id.ibt_single_sub_vd_RL);
            this.no_data_found_RL = (RelativeLayout) itemView.findViewById(R.id.no_data_found_RL);
            this.backBtn = (Button) itemView.findViewById(R.id.backBtn);
            this.examPrepTitleTV_new = (TextView) itemView.findViewById(R.id.examPrepTitleTV_new);
            this.LogsLL = (LinearLayout) itemView.findViewById(R.id.LogsLL);
            this.duration = (TextView) itemView.findViewById(R.id.duration);
            this.total_view_time = (TextView) itemView.findViewById(R.id.total_view_time);
            this.remaining_time = (TextView) itemView.findViewById(R.id.remaining_time);
            this.actalll = (LinearLayout) itemView.findViewById(R.id.actalll);
            this.classdurationll = (LinearLayout) itemView.findViewById(R.id.classdurationll);
            this.totalviewtimell = (LinearLayout) itemView.findViewById(R.id.totalviewtimell);
            this.remainingtimell = (LinearLayout) itemView.findViewById(R.id.remainingtimell);
            this.actualduration = (TextView) itemView.findViewById(R.id.actualduration);
            this.classTimingRow = (LinearLayout) itemView.findViewById(R.id.classTimingRow);
            this.startDate = (TextView) itemView.findViewById(R.id.startDate);
            this.endDate = (TextView) itemView.findViewById(R.id.endDate);
            this.llEnableMarkAsRead = (LinearLayout) itemView.findViewById(R.id.llMarkRead);
            this.checkMark = (CheckBox) itemView.findViewById(R.id.checkMark);
            this.tvMark = (TextView) itemView.findViewById(R.id.tvMark);
        }

        public void setData(final ArrayList<Lists> list, final int position) {
            if (list != null && list.size() > 0) {
                if (SharedPreference.getInstance().getString(Const.GRIDVIEW_SUBJECT).equalsIgnoreCase("1") && SingleStudyAdapter.this.tileTypeAPI.equalsIgnoreCase("content")) {
                    if (!SingleStudyAdapter.this.isSkip.equalsIgnoreCase("0") && (!SingleStudyAdapter.this.isSkip.equalsIgnoreCase("2") || !SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getIsPurchased().equalsIgnoreCase("1"))) {
                        SingleStudyAdapter.this.setThumbRatio(this.imageRL);
                    }
                } else {
                    SingleStudyAdapter.this.setThumbRatio(this.imageRL);
                }
                int i = position - 1;
                this.titleCategory.setText(list.get(i).getTitle());
                TextView textView = this.examPrepTitleTV_new;
                if (textView != null) {
                    textView.setText(list.get(i).getTitle());
                }
                this.titleCategory.setText(list.get(i).getTitle());
                TextView textView2 = this.examPrepTitleTV_new;
                if (textView2 != null) {
                    textView2.setText(list.get(i).getTitle());
                }
                SingleStudyAdapter.this.handleVisibilityMain(this.ibt_single_sub_vd_RL, this.no_data_found_RL);
                SingleStudyAdapter.this.handleVisibilityBasedContentType(i, list, this.liveIV);
                SingleStudyAdapter.this.handleVisibilityLock(position, list, this.lockRL);
                handleVisibilitySkipLayerThree(position, list);
                this.share.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyListHolder$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$setData$0(position);
                    }
                }));
                this.optionMenuImgView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyListHolder$$ExternalSyntheticLambda7
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$1(position, view);
                    }
                });
                this.watch_now.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyListHolder$$ExternalSyntheticLambda8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$2(position, view);
                    }
                });
                this.listen_now.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyListHolder$$ExternalSyntheticLambda9
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$3(position, view);
                    }
                });
                if (SharedPreference.getInstance().getString(Const.PDFVIEW_ON_VIDEOLIST).equalsIgnoreCase("1") && !TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i).getHad_pdf()) && SingleStudyAdapter.this.examPrepItem.getList().get(i).getHad_pdf().equalsIgnoreCase("1")) {
                    this.pdf_TV.setVisibility(0);
                    this.pdf_TV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter.SingleStudyListHolder.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View v) {
                            if (!Helper.isConnected(SingleStudyAdapter.this.activity)) {
                                Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                                return;
                            }
                            Intent intent = new Intent(SingleStudyAdapter.this.activity, (Class<?>) PdfListActivity.class);
                            intent.putExtra(Const.VIDEO_ID, SingleStudyAdapter.this.examPrepItem.getList().get(position - 1).getId());
                            intent.putExtra("course_id", SingleStudyAdapter.this.examPrepItem.getList().get(position - 1).getPayload().getCourse_id());
                            Helper.gotoActivity(intent, SingleStudyAdapter.this.activity);
                        }
                    });
                }
                this.read_now.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyListHolder$$ExternalSyntheticLambda10
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$4(list, position, view);
                    }
                });
                this.studyitemLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyListHolder$$ExternalSyntheticLambda11
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$5(list, position, view);
                    }
                });
                this.play_now.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyListHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$6(list, position, view);
                    }
                });
                this.lockRL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyListHolder$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$7(view);
                    }
                });
                return;
            }
            SingleStudyAdapter.this.handleVisibilityNoData(this.ibt_single_sub_vd_RL, this.no_data_found_RL, this.backBtn);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$setData$0(int i) {
            if (SingleStudyAdapter.this.is_purchase.equalsIgnoreCase("1")) {
                int i2 = i - 1;
                if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("8") || SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("7") || SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("1")) {
                    Helper.sharePdf(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getTopic_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getRevert_api(), Const.PDF, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getThumbnail_url(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle(), SingleStudy.parentCourseId);
                } else if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getVideo_type().equalsIgnoreCase("4") || SingleStudyAdapter.this.examPrepItem.getList().get(i2).getVideo_type().equalsIgnoreCase("1") || SingleStudyAdapter.this.examPrepItem.getList().get(i2).getVideo_type().equalsIgnoreCase("7") || SingleStudyAdapter.this.examPrepItem.getList().get(i2).getVideo_type().equalsIgnoreCase("8")) {
                    Helper.shareLiveClass(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getTopic_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getRevert_api(), "video", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getThumbnail_url(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle(), SingleStudy.parentCourseId, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getIs_locked());
                } else if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getVideo_type().equalsIgnoreCase("6")) {
                    Helper.sharejwvideo(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getTopic_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getRevert_api(), "video", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getThumbnail_url(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle(), SingleStudy.parentCourseId);
                }
            } else {
                int i3 = i - 1;
                if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getIs_locked().equalsIgnoreCase("1")) {
                    if (SingleStudyAdapter.this.isCourseSoldOut()) {
                        Toast.makeText(SingleStudyAdapter.this.activity, R.string.sold_out_msg, 0).show();
                        return null;
                    }
                    Intent intent = new Intent(SingleStudyAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                    intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter.this.singleStudy);
                    intent.putExtra(Const.IS_BOOK, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                    intent.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                    Helper.gotoActivity(intent, SingleStudyAdapter.this.activity);
                } else if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getFile_type().equalsIgnoreCase("8") || SingleStudyAdapter.this.examPrepItem.getList().get(i3).getFile_type().equalsIgnoreCase("7") || SingleStudyAdapter.this.examPrepItem.getList().get(i3).getFile_type().equalsIgnoreCase("1")) {
                    Helper.sharePdf(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getCourse_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getTopic_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getTile_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getTile_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getRevert_api(), Const.PDF, SingleStudyAdapter.this.examPrepItem.getList().get(i3).getThumbnail_url(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getTitle(), SingleStudy.parentCourseId);
                } else if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getVideo_type().equalsIgnoreCase("4") || SingleStudyAdapter.this.examPrepItem.getList().get(i3).getVideo_type().equalsIgnoreCase("1") || SingleStudyAdapter.this.examPrepItem.getList().get(i3).getVideo_type().equalsIgnoreCase("7") || SingleStudyAdapter.this.examPrepItem.getList().get(i3).getVideo_type().equalsIgnoreCase("8")) {
                    Helper.shareLiveClass(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getCourse_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getTopic_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getTile_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getTile_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getRevert_api(), "video", SingleStudyAdapter.this.examPrepItem.getList().get(i3).getThumbnail_url(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getTitle(), SingleStudy.parentCourseId, SingleStudyAdapter.this.examPrepItem.getList().get(i3).getIs_locked());
                } else if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getVideo_type().equalsIgnoreCase("6")) {
                    Helper.sharejwvideo(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getCourse_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getTopic_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getTile_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getTile_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getRevert_api(), "video", SingleStudyAdapter.this.examPrepItem.getList().get(i3).getThumbnail_url(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getTitle(), SingleStudy.parentCourseId);
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$1(int i, View view) {
            if (SystemClock.elapsedRealtime() - SingleStudyAdapter.this.mLastClickTime < 1000) {
                return;
            }
            SingleStudyAdapter.this.mLastClickTime = SystemClock.elapsedRealtime();
            try {
                if (!SingleStudyAdapter.this.is_purchase.equalsIgnoreCase("1")) {
                    if (SingleStudyAdapter.this.examPrepItem.getList().get(i - 1).getIs_locked().equalsIgnoreCase("1")) {
                        if (SingleStudyAdapter.this.isCourseSoldOut()) {
                            Toast.makeText(SingleStudyAdapter.this.activity, R.string.sold_out_msg, 0).show();
                            return;
                        }
                        Intent intent = new Intent(SingleStudyAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                        intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter.this.singleStudy);
                        intent.putExtra(Const.IS_BOOK, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                        intent.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                        Helper.gotoActivity(intent, SingleStudyAdapter.this.activity);
                        return;
                    }
                    OnDownloadClick(i);
                    return;
                }
                OnDownloadClick(i);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$2(int i, View view) {
            if (SingleStudyAdapter.this.is_purchase.equalsIgnoreCase("1")) {
                int i2 = i - 1;
                if (TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId())) {
                    Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.no_video_found), 0).show();
                    return;
                }
                Helper.audio_service_close((CourseActivity) SingleStudyAdapter.this.activity);
                SingleStudyAdapter singleStudyAdapter = SingleStudyAdapter.this;
                singleStudyAdapter.API_REQUEST_VIDEO_LINK(singleStudyAdapter.examPrepItem.getList().get(i2), i2);
                return;
            }
            int i3 = i - 1;
            if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(SingleStudyAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, SingleStudyAdapter.this.activity);
                return;
            }
            if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getVideo_type().equalsIgnoreCase("9")) {
                if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getLive_status().equalsIgnoreCase("1")) {
                    if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getZoom_meeting_id().equalsIgnoreCase("") || SingleStudyAdapter.this.examPrepItem.getList().get(i3).getZoom_meeting_passcode().equalsIgnoreCase("")) {
                        return;
                    }
                    if (!SharedPreference.getInstance().getString(Const.ZOOM_ACCESS_KEY).equalsIgnoreCase("")) {
                        ZoomFeatureHelper.launchZoomFeature(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i3).getZoom_meeting_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getZoom_meeting_passcode(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getZoom_sdk_token(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getName(), SharedPreference.getInstance().getLoggedInUser().getEmail(), SharedPreference.getInstance().getLoggedInUser().getMobile());
                        return;
                    }
                    Toast.makeText(SingleStudyAdapter.this.activity, "Zoom SDK key not found!", 0).show();
                    return;
                }
                if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getLive_status().equalsIgnoreCase("2")) {
                    if (!SingleStudyAdapter.this.examPrepItem.getList().get(i3).getFile_url().equalsIgnoreCase("") || !SingleStudyAdapter.this.examPrepItem.getList().get(i3).getFile_url().isEmpty()) {
                        Intent intent2 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) ZoomRecodedPlayer.class);
                        intent2.putExtra("videoUrl", SingleStudyAdapter.this.examPrepItem.getList().get(i3).getFile_url());
                        SingleStudyAdapter.this.activity.startActivity(intent2);
                        return;
                    }
                    Toast.makeText(SingleStudyAdapter.this.activity, "No Video Found !", 0).show();
                    return;
                }
                Toast.makeText(SingleStudyAdapter.this.activity, "Zoom class is not yet started.", 0).show();
                return;
            }
            if (TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i3).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i3).getId())) {
                Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.no_video_found), 0).show();
                return;
            }
            Helper.audio_service_close((CourseActivity) SingleStudyAdapter.this.activity);
            SingleStudyAdapter singleStudyAdapter2 = SingleStudyAdapter.this;
            singleStudyAdapter2.API_REQUEST_VIDEO_LINK(singleStudyAdapter2.examPrepItem.getList().get(i3), i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$3(int i, View view) {
            if (Helper.isNetworkConnected(SingleStudyAdapter.this.activity)) {
                if (SingleStudyAdapter.this.is_purchase.equalsIgnoreCase("1")) {
                    int i2 = i - 1;
                    if (TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId())) {
                        Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.no_video_found), 0).show();
                        return;
                    }
                    if (this.listen_now.getText().toString().equalsIgnoreCase("STOP")) {
                        try {
                            Helper.audio_service_close((CourseActivity) SingleStudyAdapter.this.activity);
                            SingleStudyAdapter.this.notifyDataSetChanged();
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    try {
                        Helper.audio_service_close((CourseActivity) SingleStudyAdapter.this.activity);
                        SingleStudyAdapter.this.notifyDataSetChanged();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getVideo_type().equalsIgnoreCase("6")) {
                        String str = "https://cdn.jwplayer.com/v2/media/" + SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url().substring(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url().lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url().indexOf("-"));
                        return;
                    }
                    if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getVideo_type().equalsIgnoreCase("1")) {
                        Helper.GoToLiveVideoActivity(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getChat_node(), SingleStudyAdapter.this.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getVideo_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle(), "1", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getThumbnail_url(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getIs_chat_lock(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), String.valueOf(i2), SingleStudy.parentCourseId, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getIs_live(), SingleStudyAdapter.this.videoArrayList);
                        return;
                    }
                    if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getVideo_type().equalsIgnoreCase("5")) {
                        if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("1")) {
                            Helper.GoToLiveAwsVideoActivity(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getVideo_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getChat_node(), SingleStudyAdapter.this.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getVideo_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle(), "1", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getThumbnail_url(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getIs_chat_lock(), String.valueOf(i2), SingleStudy.parentCourseId, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getStart_date(), SingleStudyAdapter.this.videoArrayList);
                            return;
                        }
                        if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("0")) {
                            Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getStart_date()) * 1000)), 0).show();
                            return;
                        } else if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("2")) {
                            Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                            return;
                        } else {
                            if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("3")) {
                                Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                                return;
                            }
                            return;
                        }
                    }
                    if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getVideo_type().equalsIgnoreCase("0")) {
                        Helper.GoToLiveAwsVideoActivity(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getVideo_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getChat_node(), SingleStudyAdapter.this.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getVideo_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle(), "1", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getThumbnail_url(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getIs_chat_lock(), String.valueOf(i2), SingleStudy.parentCourseId, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getStart_date(), SingleStudyAdapter.this.videoArrayList);
                        return;
                    }
                    if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getVideo_type().equalsIgnoreCase("7")) {
                        if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getIs_drm().equals("0")) {
                            if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId() == null || SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId().equalsIgnoreCase("")) {
                                Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                                return;
                            } else {
                                Helper.GoToLiveAwsVideoActivity(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getVideo_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getChat_node(), SingleStudyAdapter.this.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getVideo_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle(), "1", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getThumbnail_url(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getStart_date(), SingleStudyAdapter.this.videoArrayList);
                                return;
                            }
                        }
                        if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getIs_drm().equals("1")) {
                            if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId() == null || SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId().equalsIgnoreCase("")) {
                                Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                                return;
                            } else {
                                Helper.GoToVideoCryptActivity(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getVideo_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getChat_node(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getVideo_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle(), "1", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getThumbnail_url(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getStart_date(), "0", SingleStudyAdapter.this.videoArrayList);
                                return;
                            }
                        }
                        return;
                    }
                    if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getVideo_type().equalsIgnoreCase("8")) {
                        if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getIs_drm().equals("0")) {
                            if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("1")) {
                                if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId() == null || SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId().equalsIgnoreCase("")) {
                                    Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                                    return;
                                } else {
                                    Helper.GoToLiveAwsVideoActivity(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getVideo_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getChat_node(), SingleStudyAdapter.this.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getVideo_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle(), "1", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getThumbnail_url(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getStart_date(), SingleStudyAdapter.this.videoArrayList);
                                    return;
                                }
                            }
                            if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("0")) {
                                Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getStart_date()) * 1000)), 0).show();
                                return;
                            } else if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("2")) {
                                Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                                return;
                            } else {
                                if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("3")) {
                                    Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                                    return;
                                }
                                return;
                            }
                        }
                        if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getIs_drm().equals("1")) {
                            if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("1")) {
                                if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId() == null || SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId().equalsIgnoreCase("")) {
                                    Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                                    return;
                                } else {
                                    Helper.GoToVideoCryptActivity(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getVideo_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getChat_node(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getVideo_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle(), "1", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getThumbnail_url(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getStart_date(), "0", SingleStudyAdapter.this.videoArrayList);
                                    return;
                                }
                            }
                            if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("0")) {
                                Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getStart_date()) * 1000)), 0).show();
                                return;
                            } else if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("2")) {
                                Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                                return;
                            } else {
                                if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("3")) {
                                    Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                int i3 = i - 1;
                if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getIs_locked().equalsIgnoreCase("1")) {
                    if (SingleStudyAdapter.this.isCourseSoldOut()) {
                        Toast.makeText(SingleStudyAdapter.this.activity, R.string.sold_out_msg, 0).show();
                        return;
                    }
                    Intent intent = new Intent(SingleStudyAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                    intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter.this.singleStudy);
                    intent.putExtra(Const.IS_BOOK, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                    intent.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                    Helper.gotoActivity(intent, SingleStudyAdapter.this.activity);
                    return;
                }
                if (TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i3).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i3).getId())) {
                    Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.no_video_found), 0).show();
                    return;
                }
                if (this.listen_now.getText().toString().equalsIgnoreCase("STOP")) {
                    try {
                        Helper.audio_service_close((CourseActivity) SingleStudyAdapter.this.activity);
                        SingleStudyAdapter.this.notifyDataSetChanged();
                        return;
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        return;
                    }
                }
                if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getVideo_type().equalsIgnoreCase("6")) {
                    String str2 = "https://cdn.jwplayer.com/v2/media/" + SingleStudyAdapter.this.examPrepItem.getList().get(i3).getFile_url().substring(SingleStudyAdapter.this.examPrepItem.getList().get(i3).getFile_url().lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1, SingleStudyAdapter.this.examPrepItem.getList().get(i3).getFile_url().indexOf("-"));
                    return;
                }
                if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getVideo_type().equalsIgnoreCase("1")) {
                    Helper.GoToLiveVideoActivity(SingleStudyAdapter.this.examPrepItem.getList().get(i3).getChat_node(), SingleStudyAdapter.this.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i3).getFile_url(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getVideo_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getTitle(), "1", SingleStudyAdapter.this.examPrepItem.getList().get(i3).getThumbnail_url(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getIs_chat_lock(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getCourse_id(), String.valueOf(i3), SingleStudy.parentCourseId, SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getTile_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getTile_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getIs_live(), SingleStudyAdapter.this.videoArrayList);
                    return;
                }
                if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getVideo_type().equalsIgnoreCase("5")) {
                    if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getLive_status().equalsIgnoreCase("1")) {
                        Helper.GoToLiveAwsVideoActivity(SingleStudyAdapter.this.examPrepItem.getList().get(i3).getVideo_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getChat_node(), SingleStudyAdapter.this.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i3).getFile_url(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getVideo_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getTitle(), "1", SingleStudyAdapter.this.examPrepItem.getList().get(i3).getThumbnail_url(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getCourse_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getTile_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getTile_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getIs_chat_lock(), String.valueOf(i3), SingleStudy.parentCourseId, SingleStudyAdapter.this.examPrepItem.getList().get(i3).getStart_date(), SingleStudyAdapter.this.videoArrayList);
                        return;
                    }
                    if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getLive_status().equalsIgnoreCase("0")) {
                        Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(SingleStudyAdapter.this.examPrepItem.getList().get(i3).getStart_date()) * 1000)), 0).show();
                        return;
                    } else if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getLive_status().equalsIgnoreCase("2")) {
                        Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                        return;
                    } else {
                        if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getLive_status().equalsIgnoreCase("3")) {
                            Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                            return;
                        }
                        return;
                    }
                }
                if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getVideo_type().equalsIgnoreCase("0")) {
                    Helper.GoToLiveAwsVideoActivity(SingleStudyAdapter.this.examPrepItem.getList().get(i3).getVideo_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getChat_node(), SingleStudyAdapter.this.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i3).getFile_url(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getVideo_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getTitle(), "1", SingleStudyAdapter.this.examPrepItem.getList().get(i3).getThumbnail_url(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getCourse_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getTile_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getTile_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getIs_chat_lock(), String.valueOf(i3), SingleStudy.parentCourseId, SingleStudyAdapter.this.examPrepItem.getList().get(i3).getStart_date(), SingleStudyAdapter.this.videoArrayList);
                    return;
                }
                if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getVideo_type().equalsIgnoreCase("7")) {
                    if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getIs_drm().equals("0")) {
                        if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getId() == null || SingleStudyAdapter.this.examPrepItem.getList().get(i3).getId().equalsIgnoreCase("")) {
                            Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                            return;
                        } else {
                            Helper.GoToLiveAwsVideoActivity(SingleStudyAdapter.this.examPrepItem.getList().get(i3).getVideo_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getChat_node(), SingleStudyAdapter.this.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i3).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getVideo_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getTitle(), "1", SingleStudyAdapter.this.examPrepItem.getList().get(i3).getThumbnail_url(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getCourse_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getTile_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getTile_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, SingleStudyAdapter.this.examPrepItem.getList().get(i3).getStart_date(), SingleStudyAdapter.this.videoArrayList);
                            return;
                        }
                    }
                    if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getIs_drm().equals("1")) {
                        if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getId() == null || SingleStudyAdapter.this.examPrepItem.getList().get(i3).getId().equalsIgnoreCase("")) {
                            Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                            return;
                        } else {
                            Helper.GoToVideoCryptActivity(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i3).getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getVideo_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getChat_node(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getVideo_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getTitle(), "1", SingleStudyAdapter.this.examPrepItem.getList().get(i3).getThumbnail_url(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getCourse_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getTile_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getTile_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, SingleStudyAdapter.this.examPrepItem.getList().get(i3).getStart_date(), "0", SingleStudyAdapter.this.videoArrayList);
                            return;
                        }
                    }
                    return;
                }
                if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getVideo_type().equalsIgnoreCase("8")) {
                    if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getIs_drm().equals("0")) {
                        if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getLive_status().equalsIgnoreCase("1")) {
                            if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getId() == null || SingleStudyAdapter.this.examPrepItem.getList().get(i3).getId().equalsIgnoreCase("")) {
                                Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                                return;
                            } else {
                                Helper.GoToLiveAwsVideoActivity(SingleStudyAdapter.this.examPrepItem.getList().get(i3).getVideo_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getChat_node(), SingleStudyAdapter.this.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i3).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getVideo_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getTitle(), "1", SingleStudyAdapter.this.examPrepItem.getList().get(i3).getThumbnail_url(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getCourse_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getTile_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getTile_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, SingleStudyAdapter.this.examPrepItem.getList().get(i3).getStart_date(), SingleStudyAdapter.this.videoArrayList);
                                return;
                            }
                        }
                        if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getLive_status().equalsIgnoreCase("0")) {
                            Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(SingleStudyAdapter.this.examPrepItem.getList().get(i3).getStart_date()) * 1000)), 0).show();
                            return;
                        } else if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getLive_status().equalsIgnoreCase("2")) {
                            Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                            return;
                        } else {
                            if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getLive_status().equalsIgnoreCase("3")) {
                                Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                                return;
                            }
                            return;
                        }
                    }
                    if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getIs_drm().equals("1")) {
                        if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getLive_status().equalsIgnoreCase("1")) {
                            if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getId() == null || SingleStudyAdapter.this.examPrepItem.getList().get(i3).getId().equalsIgnoreCase("")) {
                                Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                                return;
                            } else {
                                Helper.GoToVideoCryptActivity(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i3).getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getVideo_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getChat_node(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getVideo_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getTitle(), "1", SingleStudyAdapter.this.examPrepItem.getList().get(i3).getThumbnail_url(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getCourse_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getTile_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getTile_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, SingleStudyAdapter.this.examPrepItem.getList().get(i3).getStart_date(), "0", SingleStudyAdapter.this.videoArrayList);
                                return;
                            }
                        }
                        if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getLive_status().equalsIgnoreCase("0")) {
                            Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(SingleStudyAdapter.this.examPrepItem.getList().get(i3).getStart_date()) * 1000)), 0).show();
                            return;
                        } else if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getLive_status().equalsIgnoreCase("2")) {
                            Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                            return;
                        } else {
                            if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getLive_status().equalsIgnoreCase("3")) {
                                Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$4(ArrayList arrayList, int i, View view) {
            int i2 = i - 1;
            if (((Lists) arrayList.get(i2)).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(SingleStudyAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, SingleStudyAdapter.this.activity);
                return;
            }
            if (SingleStudyAdapter.this.is_purchase.equalsIgnoreCase("1")) {
                if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("12")) {
                    if (SingleStudyAdapter.this.examPrepItem.getList().size() > 0) {
                        Intent intent2 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) RevisionActivity.class);
                        intent2.putExtra("t_id", SingleStudyAdapter.this.tileIdAPI);
                        intent2.putExtra("postion", i);
                        intent2.putExtra(Const.VIDEO_ID, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId());
                        intent2.putExtra("v_list", ExamPrepLayer2.actual_videolist);
                        intent2.putExtra("f_id", SingleStudyAdapter.this.examPrepItem.getList().get(0).getId());
                        intent2.putExtra("c_id", SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId());
                        intent2.putExtra("title", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle());
                        intent2.putExtra("url", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url());
                        intent2.putExtra(Const.VIA, "main");
                        Helper.gotoActivity(intent2, SingleStudyAdapter.this.activity);
                        return;
                    }
                    return;
                }
                if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("11")) {
                    Intent intent3 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) WebViewActivty.class);
                    intent3.putExtra("type", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle());
                    intent3.putExtra("url", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url());
                    Helper.gotoActivity(intent3, SingleStudyAdapter.this.activity);
                    return;
                }
                if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("8")) {
                    SingleStudyAdapter singleStudyAdapter = SingleStudyAdapter.this;
                    singleStudyAdapter.openWebPage(singleStudyAdapter.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url());
                    return;
                }
                if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("6")) {
                    if (TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId())) {
                        Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.no_image_found), 0).show();
                        return;
                    }
                    Intent intent4 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) WebViewActivty.class);
                    intent4.putExtra("type", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle());
                    intent4.putExtra("url", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url());
                    intent4.putExtra("file_type", "image");
                    Helper.gotoActivity(intent4, SingleStudyAdapter.this.activity);
                    return;
                }
                return;
            }
            if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent5 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent5.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter.this.singleStudy);
                intent5.putExtra(Const.IS_BOOK, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent5.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent5, SingleStudyAdapter.this.activity);
                return;
            }
            if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("12")) {
                if (SingleStudyAdapter.this.examPrepItem.getList().size() > 0) {
                    Intent intent6 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) RevisionActivity.class);
                    intent6.putExtra("t_id", SingleStudyAdapter.this.tileIdAPI);
                    intent6.putExtra("postion", i);
                    intent6.putExtra(Const.VIDEO_ID, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId());
                    intent6.putExtra("v_list", ExamPrepLayer2.actual_videolist);
                    intent6.putExtra("f_id", SingleStudyAdapter.this.examPrepItem.getList().get(0).getId());
                    intent6.putExtra("c_id", SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId());
                    intent6.putExtra("title", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle());
                    intent6.putExtra("url", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url());
                    intent6.putExtra(Const.VIA, "main");
                    Helper.gotoActivity(intent6, SingleStudyAdapter.this.activity);
                    return;
                }
                return;
            }
            if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("11")) {
                Intent intent7 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) WebViewActivty.class);
                intent7.putExtra("type", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle());
                intent7.putExtra("url", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url());
                Helper.gotoActivity(intent7, SingleStudyAdapter.this.activity);
                return;
            }
            if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("8")) {
                SingleStudyAdapter singleStudyAdapter2 = SingleStudyAdapter.this;
                singleStudyAdapter2.openWebPage(singleStudyAdapter2.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url());
                return;
            }
            if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("6")) {
                if (TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId())) {
                    Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.no_image_found), 0).show();
                    return;
                }
                Intent intent8 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) WebViewActivty.class);
                intent8.putExtra("type", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle());
                intent8.putExtra("url", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url());
                intent8.putExtra("file_type", "image");
                Helper.gotoActivity(intent8, SingleStudyAdapter.this.activity);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$5(ArrayList arrayList, int i, View view) {
            String str;
            Intent intent;
            Intent intent2;
            this.studyitemLL.setFocusable(true);
            this.studyitemLL.setClickable(true);
            this.studyitemLL.setBackgroundDrawable(SingleStudyAdapter.this.activity.getResources().getDrawable(R.drawable.nav_ripple));
            if (!SingleStudyAdapter.this.isSkip.equalsIgnoreCase("3") && ((Lists) arrayList.get(i - 1)).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent3 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent3.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter.this.singleStudy);
                intent3.putExtra(Const.IS_BOOK, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent3.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent3, SingleStudyAdapter.this.activity);
                return;
            }
            boolean zEqualsIgnoreCase = SingleStudyAdapter.this.isSkip.equalsIgnoreCase("1");
            String str2 = Const.EXAMPREP;
            if (zEqualsIgnoreCase) {
                str = Const.SINGLE_STUDY_DATA;
            } else {
                if (!SingleStudyAdapter.this.isSkip.equalsIgnoreCase("2")) {
                    if (SingleStudyAdapter.this.isSkip.equalsIgnoreCase("3")) {
                        if (SingleStudyAdapter.this.is_purchase.equalsIgnoreCase("1")) {
                            int i2 = i - 1;
                            if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("12")) {
                                if (SingleStudyAdapter.this.examPrepItem.getList().size() > 0) {
                                    Intent intent4 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) RevisionActivity.class);
                                    intent4.putExtra("t_id", SingleStudyAdapter.this.tileIdAPI);
                                    intent4.putExtra("postion", i);
                                    intent4.putExtra(Const.VIDEO_ID, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId());
                                    intent4.putExtra("v_list", ExamPrepLayer2.actual_videolist);
                                    intent4.putExtra("f_id", SingleStudyAdapter.this.examPrepItem.getList().get(0).getId());
                                    intent4.putExtra("c_id", SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId());
                                    intent4.putExtra("title", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle());
                                    intent4.putExtra("url", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url());
                                    intent4.putExtra(Const.VIA, "main");
                                    Helper.gotoActivity(intent4, SingleStudyAdapter.this.activity);
                                    return;
                                }
                                return;
                            }
                            if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("11")) {
                                Intent intent5 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) WebViewActivty.class);
                                intent5.putExtra("type", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle());
                                intent5.putExtra("url", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url());
                                Helper.gotoActivity(intent5, SingleStudyAdapter.this.activity);
                                return;
                            }
                            if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("8")) {
                                SingleStudyAdapter singleStudyAdapter = SingleStudyAdapter.this;
                                singleStudyAdapter.openWebPage(singleStudyAdapter.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url());
                                return;
                            }
                            if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("6")) {
                                if (TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId())) {
                                    Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.no_image_found), 0).show();
                                    return;
                                }
                                Intent intent6 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) WebViewActivty.class);
                                intent6.putExtra("type", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle());
                                intent6.putExtra("url", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url());
                                intent6.putExtra("file_type", "image");
                                Helper.gotoActivity(intent6, SingleStudyAdapter.this.activity);
                                return;
                            }
                            return;
                        }
                        int i3 = i - 1;
                        if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getIs_locked().equalsIgnoreCase("1")) {
                            if (SingleStudyAdapter.this.isCourseSoldOut()) {
                                Toast.makeText(SingleStudyAdapter.this.activity, R.string.sold_out_msg, 0).show();
                                return;
                            }
                            Intent intent7 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                            intent7.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter.this.singleStudy);
                            intent7.putExtra(Const.IS_BOOK, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                            intent7.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                            Helper.gotoActivity(intent7, SingleStudyAdapter.this.activity);
                            return;
                        }
                        if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getFile_type().equalsIgnoreCase("12")) {
                            if (SingleStudyAdapter.this.examPrepItem.getList().size() > 0) {
                                Intent intent8 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) RevisionActivity.class);
                                intent8.putExtra("t_id", SingleStudyAdapter.this.tileIdAPI);
                                intent8.putExtra("postion", i);
                                intent8.putExtra(Const.VIDEO_ID, SingleStudyAdapter.this.examPrepItem.getList().get(i3).getId());
                                intent8.putExtra("v_list", ExamPrepLayer2.actual_videolist);
                                intent8.putExtra("f_id", SingleStudyAdapter.this.examPrepItem.getList().get(0).getId());
                                intent8.putExtra("c_id", SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId());
                                intent8.putExtra("title", SingleStudyAdapter.this.examPrepItem.getList().get(i3).getTitle());
                                intent8.putExtra("url", SingleStudyAdapter.this.examPrepItem.getList().get(i3).getFile_url());
                                intent8.putExtra(Const.VIA, "main");
                                Helper.gotoActivity(intent8, SingleStudyAdapter.this.activity);
                                return;
                            }
                            return;
                        }
                        if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getFile_type().equalsIgnoreCase("11")) {
                            Intent intent9 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) WebViewActivty.class);
                            intent9.putExtra("type", SingleStudyAdapter.this.examPrepItem.getList().get(i3).getTitle());
                            intent9.putExtra("url", SingleStudyAdapter.this.examPrepItem.getList().get(i3).getFile_url());
                            Helper.gotoActivity(intent9, SingleStudyAdapter.this.activity);
                            return;
                        }
                        if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getFile_type().equalsIgnoreCase("8")) {
                            SingleStudyAdapter singleStudyAdapter2 = SingleStudyAdapter.this;
                            singleStudyAdapter2.openWebPage(singleStudyAdapter2.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i3).getFile_url());
                            return;
                        }
                        if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getFile_type().equalsIgnoreCase("6")) {
                            if (TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i3).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i3).getId())) {
                                Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.no_image_found), 0).show();
                                return;
                            }
                            Intent intent10 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) WebViewActivty.class);
                            intent10.putExtra("type", SingleStudyAdapter.this.examPrepItem.getList().get(i3).getTitle());
                            intent10.putExtra("url", SingleStudyAdapter.this.examPrepItem.getList().get(i3).getFile_url());
                            intent10.putExtra("file_type", "image");
                            Helper.gotoActivity(intent10, SingleStudyAdapter.this.activity);
                            return;
                        }
                        if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getFile_type().equalsIgnoreCase("3")) {
                            if (SingleStudyAdapter.this.is_purchase.equalsIgnoreCase("1")) {
                                if (TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i3).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i3).getId())) {
                                    Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.no_video_found), 0).show();
                                    return;
                                }
                                Helper.audio_service_close((CourseActivity) SingleStudyAdapter.this.activity);
                                SingleStudyAdapter singleStudyAdapter3 = SingleStudyAdapter.this;
                                singleStudyAdapter3.API_REQUEST_VIDEO_LINK(singleStudyAdapter3.examPrepItem.getList().get(i3), i3);
                                return;
                            }
                            if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getIs_locked().equalsIgnoreCase("1")) {
                                if (SingleStudyAdapter.this.isCourseSoldOut()) {
                                    Toast.makeText(SingleStudyAdapter.this.activity, R.string.sold_out_msg, 0).show();
                                    return;
                                }
                                Intent intent11 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                                intent11.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter.this.singleStudy);
                                intent11.putExtra(Const.IS_BOOK, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                                intent11.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                                Helper.gotoActivity(intent11, SingleStudyAdapter.this.activity);
                                return;
                            }
                            if (TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i3).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i3).getId())) {
                                Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.no_video_found), 0).show();
                                return;
                            }
                            Helper.audio_service_close((CourseActivity) SingleStudyAdapter.this.activity);
                            SingleStudyAdapter singleStudyAdapter4 = SingleStudyAdapter.this;
                            singleStudyAdapter4.API_REQUEST_VIDEO_LINK(singleStudyAdapter4.examPrepItem.getList().get(i3), i3);
                            return;
                        }
                        return;
                    }
                    ExamPrepItem examPrepItem = new ExamPrepItem();
                    int i4 = i - 1;
                    examPrepItem.setList(SingleStudyAdapter.this.examPrepItem.getList().get(i4).getList());
                    if (!TextUtils.isEmpty(SingleStudyAdapter.this.content_type) && SingleStudyAdapter.this.content_type.equalsIgnoreCase("1") && !SingleStudyAdapter.this.tileIdAPI.equalsIgnoreCase("0")) {
                        intent2 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) FolderActivity.class);
                        intent2.putExtra("title", arrayList.get(i4) != null ? ((Lists) arrayList.get(i4)).getTitle() : "Main Folder");
                        intent2.putExtra("firstTime", "1");
                    } else {
                        Intent intent12 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) CourseActivity.class);
                        intent12.putExtra("title", SingleStudyAdapter.this.singleStudy.getData().getCourseDetail() != null ? SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getTitle() : "Course");
                        if (SingleStudyAdapter.this.tileTypeAPI.equals(Const.COMBO) || SingleStudyAdapter.this.tileTypeAPI.equals("content")) {
                            intent12.putExtra(Const.TAB_TILE_VISIBILITY, "1");
                        } else {
                            intent12.putExtra(Const.TAB_TILE_VISIBILITY, "0");
                        }
                        intent2 = intent12;
                    }
                    SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(SingleStudyAdapter.this.singleStudy != null ? SingleStudyAdapter.this.singleStudy : new CourseDetail()));
                    SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(examPrepItem));
                    SharedPreference.getInstance().putString("list", new Gson().toJson(arrayList.get(i4) != null ? arrayList.get(i4) : new Lists()));
                    intent2.putExtra(Const.FRAG_TYPE, Const.EXAMPREP);
                    intent2.putExtra(Const.IS_COMBO, SingleStudyAdapter.this.isCombo);
                    intent2.putExtra("content_type", SingleStudyAdapter.this.contentType);
                    intent2.putExtra("tile_id", SingleStudyAdapter.this.tileIdAPI);
                    intent2.putExtra(Const.TILE_TYPE, SingleStudyAdapter.this.tileTypeAPI);
                    intent2.putExtra(Const.REVERT_API, SingleStudyAdapter.this.revertAPI);
                    Helper.gotoActivity(intent2, SingleStudyAdapter.this.activity);
                    return;
                }
                str2 = Const.EXAMPREP;
                str = Const.SINGLE_STUDY_DATA;
            }
            if (!TextUtils.isEmpty(SingleStudyAdapter.this.content_type) && SingleStudyAdapter.this.content_type.equalsIgnoreCase("1") && !SingleStudyAdapter.this.tileIdAPI.equalsIgnoreCase("0")) {
                intent = new Intent(SingleStudyAdapter.this.activity, (Class<?>) FolderActivity.class);
                intent.putExtra("firstTime", "1");
            } else {
                Intent intent13 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) CourseActivity.class);
                if (SingleStudyAdapter.this.tileTypeAPI.equals(Const.COMBO) || SingleStudyAdapter.this.tileTypeAPI.equals("content")) {
                    intent13.putExtra(Const.TAB_TILE_VISIBILITY, "1");
                } else {
                    intent13.putExtra(Const.TAB_TILE_VISIBILITY, "0");
                }
                intent = intent13;
            }
            intent.putExtra(Const.FRAG_TYPE, Const.EXAMPREPLAST);
            SharedPreference.getInstance().putString(str, new Gson().toJson(SingleStudyAdapter.this.singleStudy != null ? SingleStudyAdapter.this.singleStudy : new CourseDetail()));
            SharedPreference.getInstance().putString(str2, new Gson().toJson(SingleStudyAdapter.this.examPrepItem != null ? SingleStudyAdapter.this.examPrepItem : new ExamPrepItem()));
            int i5 = i - 1;
            SharedPreference.getInstance().putString("list", new Gson().toJson(SingleStudyAdapter.this.examPrepItem.getList().get(i5) != null ? SingleStudyAdapter.this.examPrepItem.getList().get(i5) : new Lists()));
            intent.putExtra(Const.IS_COMBO, SingleStudyAdapter.this.isCombo);
            intent.putExtra(Const.LIST_SUBJECT, SingleStudyAdapter.this.examPrepItem.getList().get(i5));
            intent.putExtra("title", SingleStudyAdapter.this.examPrepItem.getList().get(i5).getTitle());
            intent.putExtra("content_type", SingleStudyAdapter.this.contentType);
            intent.putExtra(Const.TEST_TYPE, SingleStudyAdapter.this.examPrepItem.getList().get(i5).getCount());
            intent.putExtra("tile_id", SingleStudyAdapter.this.tileIdAPI);
            intent.putExtra(Const.TILE_TYPE, SingleStudyAdapter.this.tileTypeAPI);
            intent.putExtra(Const.REVERT_API, SingleStudyAdapter.this.revertAPI);
            Helper.gotoActivity(intent, SingleStudyAdapter.this.activity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$6(ArrayList arrayList, int i, View view) {
            if (!Helper.isConnected(SingleStudyAdapter.this.activity)) {
                Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                return;
            }
            if (SingleStudyAdapter.this.is_purchase.equalsIgnoreCase("1") || ((Lists) arrayList.get(i - 1)).getIs_locked().equalsIgnoreCase("0")) {
                int i2 = i - 1;
                if (((Lists) arrayList.get(i2)).getFile_type().equalsIgnoreCase("13")) {
                    if (this.play_now.getText().equals(SingleStudyAdapter.this.activity.getResources().getString(R.string.play))) {
                        if (MusicService.INSTANCE.isAudioPlaying()) {
                            Intent intent = new Intent(SingleStudyAdapter.this.activity, (Class<?>) MusicService.class);
                            intent.setAction("Stop_Service");
                            SingleStudyAdapter.this.activity.startService(intent);
                        }
                        Intent intent2 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) AudioPlayerActivity.class);
                        Video video = new Video();
                        video.setId(((Lists) arrayList.get(i2)).getId());
                        video.setTitle(((Lists) arrayList.get(i2)).getTitle());
                        video.setVideo_title(((Lists) arrayList.get(i2)).getTitle());
                        video.setThumbnail_url(((Lists) arrayList.get(i2)).getThumbnail_url());
                        video.setFile_url(((Lists) arrayList.get(i2)).getFile_url());
                        intent2.putExtra("video", video);
                        SingleStudyAdapter.this.activity.startActivity(intent2);
                        this.play_now.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.stop));
                    } else {
                        if (MusicService.INSTANCE.isAudioPlaying()) {
                            Intent intent3 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) MusicService.class);
                            intent3.setAction("Stop_Service");
                            SingleStudyAdapter.this.activity.startService(intent3);
                        }
                        this.play_now.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.play));
                    }
                    SingleStudyAdapter.this.notifyDataSetChanged();
                    return;
                }
                Toast.makeText(SingleStudyAdapter.this.activity, "No Audio Found yet please some time !", 0).show();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$7(View view) {
            Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getString(R.string.contentislock), 0).show();
        }

        private void OnDownloadClick(final int position) {
            int i = position - 1;
            if (SingleStudyAdapter.this.examPrepItem.getList().get(i) == null || SingleStudyAdapter.this.examPrepItem.getList().get(i).getFile_type() == null) {
                return;
            }
            if (SingleStudyAdapter.this.examPrepItem.getList().get(i).getFile_type().equalsIgnoreCase("10") || SingleStudyAdapter.this.examPrepItem.getList().get(i).getFile_type().equalsIgnoreCase("12") || SingleStudyAdapter.this.examPrepItem.getList().get(i).getFile_type().equalsIgnoreCase("11")) {
                SingleStudyAdapter singleStudyAdapter = SingleStudyAdapter.this;
                singleStudyAdapter.videodata = singleStudyAdapter.examPrepItem.getList().get(i);
                SingleStudyAdapter.this.position_delete = i;
                SimpleAlertDialogsKt.deleteVideoDialog(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.videodata, new Function1() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyListHolder$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return this.f$0.lambda$OnDownloadClick$8((View) obj);
                    }
                });
                return;
            }
            if (SingleStudyAdapter.this.examPrepItem.getList().get(i).getVideo_type().equalsIgnoreCase("6") || SingleStudyAdapter.this.examPrepItem.getList().get(i).getVideo_type().equalsIgnoreCase("7")) {
                SimpleAlertDialogsKt.downloadVideoDialog(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i), new Function1() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyListHolder$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return this.f$0.lambda$OnDownloadClick$9(position, (View) obj);
                    }
                });
                return;
            }
            if (SingleStudyAdapter.this.examPrepItem.getList().get(i).getFile_type().equalsIgnoreCase("13")) {
                if (Helper.isNetworkConnected(SingleStudyAdapter.this.activity)) {
                    if (SingleStudyAdapter.this.is_purchase.equalsIgnoreCase("1")) {
                        this.optionMenuImgView.setEnabled(false);
                        SingleStudyAdapter singleStudyAdapter2 = SingleStudyAdapter.this;
                        singleStudyAdapter2.download_service_audio(singleStudyAdapter2.examPrepItem.getList().get(i), position);
                        return;
                    }
                    Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.this_feature_is_only_available_for_courses_in_your_library), 0).show();
                    return;
                }
                Helper.showInternetToast(SingleStudyAdapter.this.activity);
                return;
            }
            if (SingleStudyAdapter.this.examPrepItem.getList().get(i).getFile_type().equalsIgnoreCase("3") && SingleStudyAdapter.this.examPrepItem.getList().get(i).getVideo_type().equalsIgnoreCase("1")) {
                if (Helper.isNetworkConnected(SingleStudyAdapter.this.activity)) {
                    if (SingleStudyAdapter.this.is_purchase.equalsIgnoreCase("1")) {
                        this.optionMenuImgView.setEnabled(false);
                        SingleStudyAdapter singleStudyAdapter3 = SingleStudyAdapter.this;
                        singleStudyAdapter3.downloadYoutubeVideo(singleStudyAdapter3.examPrepItem.getList().get(i), position, this.optionMenuImgView);
                        return;
                    }
                    Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.this_feature_is_only_available_for_courses_in_your_library), 0).show();
                    return;
                }
                Helper.showInternetToast(SingleStudyAdapter.this.activity);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$OnDownloadClick$8(View view) {
            SingleStudyAdapter singleStudyAdapter = SingleStudyAdapter.this;
            new NetworkCall(singleStudyAdapter, singleStudyAdapter.activity).NetworkAPICall(API.delete_revision, "", true, false);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$OnDownloadClick$9(int i, View view) {
            if (SingleStudyAdapter.this.is_purchase.equalsIgnoreCase("1")) {
                SingleStudyAdapter singleStudyAdapter = SingleStudyAdapter.this;
                singleStudyAdapter.download_service(singleStudyAdapter.examPrepItem.getList().get(i - 1), i, this.optionMenuImgView);
                return null;
            }
            Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.this_feature_is_only_available_for_courses_in_your_library), 0).show();
            return null;
        }

        private void handleVisibilityBasedFileType(ArrayList<Lists> list, int position) {
            String file_type = list.get(position - 1).getFile_type();
            file_type.hashCode();
            switch (file_type) {
                case "3":
                    this.watch_now.setVisibility(0);
                    this.studyitemLL.setEnabled(true);
                    this.read_now.setEnabled(false);
                    this.read_now.setVisibility(8);
                    break;
                case "6":
                    this.studyitemLL.setEnabled(true);
                    this.read_now.setEnabled(true);
                    this.read_now.setVisibility(0);
                    this.share.setVisibility(8);
                    this.read_now.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.view));
                    break;
                case "8":
                case "11":
                case "12":
                    this.studyitemLL.setEnabled(true);
                    this.read_now.setEnabled(true);
                    this.read_now.setVisibility(0);
                    this.share.setVisibility(8);
                    this.read_now.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.read));
                    break;
                default:
                    this.watch_now.setVisibility(8);
                    this.studyitemLL.setEnabled(true);
                    this.read_now.setEnabled(false);
                    this.read_now.setVisibility(8);
                    break;
            }
            handleVisibilityShare();
        }

        private void handleVisibilityShare() {
            if (Helper.isShowShareButton(SingleStudyAdapter.this.leftMenu)) {
                this.share.setVisibility(0);
            } else {
                this.share.setVisibility(8);
            }
        }

        private void handleVisibilitySkipLayerThree(int position, ArrayList<Lists> list) {
            if (SingleStudyAdapter.this.isSkip.equalsIgnoreCase("3")) {
                this.forwardIV.setVisibility(8);
                int i = position - 1;
                if (SingleStudyAdapter.this.examPrepItem.getList().get(i).getExtra_params() != null) {
                    if (SingleStudyAdapter.this.examPrepItem.getList().get(i).getExtra_params().getIs_limited().equalsIgnoreCase("1")) {
                        if (SingleStudyAdapter.this.examPrepItem.getList().get(i).getIs_locked().equalsIgnoreCase("1")) {
                            this.LogsLL.setVisibility(8);
                        } else {
                            this.LogsLL.setVisibility(0);
                        }
                        if (BuildConfig.FLAVOR.equalsIgnoreCase("Shrestha")) {
                            setvisibility(1, 0, 1, 0);
                        } else {
                            setvisibility(0, 1, 1, 1);
                        }
                        Lists lists = SingleStudyAdapter.this.examPrepItem.getList().get(i);
                        if (lists.getRemaining_time() != null) {
                            String strValueOf = lists.getRemaining_time().split("_")[0];
                            if (SingleStudyAdapter.this.utkashRoom.getvideoDownloadao().isvideo_exit(lists.getId(), MakeMyExam.userId)) {
                                VideosDownload videosDownload = SingleStudyAdapter.this.utkashRoom.getvideoDownloadao().getvideo_byuserid(lists.getId(), "1", MakeMyExam.userId);
                                if (videosDownload != null && videosDownload.getVideo_length().equalsIgnoreCase(lists.getVideo_length()) && videosDownload.getRemaining_time() != null) {
                                    long jMin = Math.min(Long.parseLong(strValueOf) * 1000, Long.parseLong(videosDownload.getRemaining_time()) * 1000);
                                    strValueOf = String.valueOf((jMin > 0 ? jMin : 0L) / 1000);
                                } else if (videosDownload != null && videosDownload.getRemaining_time() != null) {
                                    videosDownload.setRemaining_time(String.valueOf(Long.parseLong(videosDownload.getRemaining_time() + (Long.parseLong(lists.getVideo_length()) - Long.parseLong(videosDownload.getVideo_length())))));
                                    long jMin2 = Math.min(Long.parseLong(strValueOf) * 1000, Long.parseLong(videosDownload.getRemaining_time()) * 1000);
                                    strValueOf = String.valueOf((jMin2 > 0 ? jMin2 : 0L) / 1000);
                                    SingleStudyAdapter.this.utkashRoom.getvideoDownloadao().update_videoRemainingtime(lists.getId(), MakeMyExam.userId, strValueOf);
                                    SingleStudyAdapter.this.utkashRoom.getvideoDownloadao().update_videoTotleTime(lists.getId(), MakeMyExam.userId, lists.getVideo_length());
                                }
                            }
                            if (strValueOf.contains("-")) {
                                strValueOf = "0";
                            }
                            this.duration.setText(Helper.formatSeconds((int) Float.parseFloat(lists.getVideo_length())));
                            this.actualduration.setText(Helper.formatSeconds((int) Float.parseFloat(lists.getVideo_duration())));
                            this.total_view_time.setText(Helper.formatSeconds((int) (Float.parseFloat(lists.getVideo_length()) - Float.parseFloat(strValueOf))));
                            this.remaining_time.setText(Helper.formatSeconds((int) Float.parseFloat(strValueOf)));
                        }
                    } else {
                        this.LogsLL.setVisibility(8);
                    }
                }
                if (!TextUtils.isEmpty(list.get(i).getThumbnail_url())) {
                    SingleStudyAdapter.this.setThumbAccordingRatio(list.get(i).getThumbnail_url(), this.imageIcon);
                } else if (SingleStudyAdapter.this.bottomSetting != null && SingleStudyAdapter.this.bottomSetting.getLayout_type() != null && SingleStudyAdapter.this.bottomSetting.getLayout_type().equals("1")) {
                    this.imageIcon.setImageResource(R.mipmap.square_placeholder);
                } else {
                    this.imageIcon.setImageResource(R.mipmap.square_placeholder_new);
                }
                if (list.get(i).getIs_locked().equals("0")) {
                    this.layout_fun.setVisibility(0);
                } else {
                    this.layout_fun.setVisibility(8);
                }
                SingleStudyAdapter.this.handleDownloadIcons(list, position, this.optionMenuImgView, this.subItemRV);
                handleVisibilityBasedFileType(list, position);
                setListenVisibilty(list.get(i));
                setDateTimeByVideoTypes(list.get(i), this.classTimingRow, this.startDate, this.endDate);
                this.studyitemLL.setEnabled(true);
                markAsReadVideoType1_7(list.get(i), this.llEnableMarkAsRead, this.checkMark, this.tvMark, position);
                if (list.get(i).getFile_type() != null && list.get(i).getFile_type().equalsIgnoreCase("13")) {
                    if (SingleStudyAdapter.this.is_purchase.equalsIgnoreCase("1")) {
                        this.play_now.setVisibility(0);
                        updatePlayForAudio(this.play_now, list.get(i));
                        return;
                    } else if (list.get(i).getIs_locked().equalsIgnoreCase("0")) {
                        this.play_now.setVisibility(0);
                        updatePlayForAudio(this.play_now, list.get(i));
                        return;
                    } else {
                        this.play_now.setVisibility(8);
                        return;
                    }
                }
                this.play_now.setVisibility(8);
                return;
            }
            int i2 = position - 1;
            if (!TextUtils.isEmpty(list.get(i2).getImage_icon())) {
                SingleStudyAdapter.this.setThumbAccordingRatio(list.get(i2).getImage_icon(), this.imageIcon);
            } else if (SingleStudyAdapter.this.bottomSetting != null && SingleStudyAdapter.this.bottomSetting.getLayout_type() != null && SingleStudyAdapter.this.bottomSetting.getLayout_type().equals("1")) {
                this.imageIcon.setImageResource(R.mipmap.square_placeholder);
            } else {
                this.imageIcon.setImageResource(R.mipmap.square_placeholder_new);
            }
            if (TextUtils.isEmpty(list.get(i2).getCount())) {
                this.subItemRV.setVisibility(4);
            } else {
                this.subItemRV.setVisibility(8);
                this.subItemRV.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.total_) + list.get(i2).getCount());
            }
            SingleStudyAdapter.this.handleDownloadIcons(list, position, this.optionMenuImgView, this.subItemRV);
            this.layout_fun.setVisibility(8);
            this.watch_now.setVisibility(8);
            setListenVisibilty(list.get(i2));
            this.studyitemLL.setEnabled(true);
            if (list.get(i2).getFile_type() != null && list.get(i2).getFile_type().equalsIgnoreCase("13")) {
                if (SingleStudyAdapter.this.is_purchase.equalsIgnoreCase("1")) {
                    this.play_now.setVisibility(0);
                    updatePlayForAudio(this.play_now, list.get(i2));
                    return;
                } else if (list.get(i2).getIs_locked().equalsIgnoreCase("0")) {
                    this.play_now.setVisibility(0);
                    updatePlayForAudio(this.play_now, list.get(i2));
                    return;
                } else {
                    this.play_now.setVisibility(8);
                    return;
                }
            }
            this.play_now.setVisibility(8);
        }

        private void setDateTimeByVideoTypes(Lists lists, LinearLayout classTimingRow, TextView startDate, TextView endDate) {
            try {
                if ("1".equalsIgnoreCase("1") || "1".equalsIgnoreCase("2")) {
                    if (SharedPreference.getInstance().getString(Const.HARVEST_CLASS_TIME_HIDE).equalsIgnoreCase("1") && !lists.getIs_live().equalsIgnoreCase("1") && (lists.getVideo_type().equalsIgnoreCase("1") || lists.getVideo_type().equalsIgnoreCase("4") || lists.getVideo_type().equalsIgnoreCase("7"))) {
                        classTimingRow.setVisibility(8);
                        return;
                    }
                    if (!lists.getVideo_type().equalsIgnoreCase("4") && !lists.getVideo_type().equalsIgnoreCase("1") && !lists.getVideo_type().equalsIgnoreCase("8") && !lists.getVideo_type().equalsIgnoreCase("7") && !lists.getVideo_type().equalsIgnoreCase("9")) {
                        return;
                    }
                    classTimingRow.setVisibility(0);
                    startDate.setTypeface(startDate.getTypeface(), 0);
                    Helper.formatSeconds(Integer.parseInt(lists.getVideo_duration()));
                    if (lists.getStart_date() == null || lists.getStart_date().equalsIgnoreCase("0")) {
                        startDate.setVisibility(8);
                    } else {
                        startDate.setText("Class Timing: " + new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.US).format(new Date(Long.parseLong(lists.getStart_date()) * 1000)));
                        startDate.setVisibility(0);
                    }
                    endDate.setVisibility(8);
                }
            } catch (Exception e2) {
                Helper.logPrinter("setDateTimeByVideoTypes", "e", e2.getLocalizedMessage(), e2.getMessage());
            }
        }

        private void updatePlayForAudio(TextView play_now, Lists video) {
            if (MusicService.INSTANCE.isAudioPlaying() && MusicService.INSTANCE.getVideoid().equalsIgnoreCase(video.getId())) {
                play_now.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.stop));
            } else {
                play_now.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.play));
            }
        }

        private void setListenVisibilty(Lists list) {
            if (list.getIs_locked() == null || !list.getIs_locked().equalsIgnoreCase("0") || !SharedPreference.getInstance().getString(Const.AUDIO_LISTEN).equalsIgnoreCase("1") || list.getVideo_type() == null || list.getVideo_type().equalsIgnoreCase("1") || list.getVideo_type() == null || list.getVideo_type().equalsIgnoreCase("4") || list.getVideo_type() == null || list.getVideo_type().equalsIgnoreCase("8") || list.getIs_drm() == null || list.getIs_drm().equals("1")) {
                return;
            }
            if (SingleStudyAdapter.this.is_purchase.equalsIgnoreCase("1")) {
                this.listen_now.setVisibility(0);
            } else if (list.getIs_locked() != null && list.getIs_locked().equalsIgnoreCase("0")) {
                this.listen_now.setVisibility(0);
            } else {
                this.listen_now.setVisibility(8);
            }
            if (AudioPlayerService.isAudioPlaying && AudioPlayerService.videoid.equalsIgnoreCase(list.getId())) {
                this.listen_now.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.stop));
            } else {
                this.listen_now.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.listen_));
            }
        }

        public void setvisibility(int actualvideo, int classduration, int remainingtime, int timeview) {
            if (actualvideo == 1) {
                this.actalll.setVisibility(0);
            } else {
                this.actalll.setVisibility(8);
            }
            if (classduration == 1) {
                this.classdurationll.setVisibility(0);
            } else {
                this.classdurationll.setVisibility(8);
            }
            if (remainingtime == 1) {
                this.remainingtimell.setVisibility(0);
            } else {
                this.remainingtimell.setVisibility(8);
            }
            if (timeview == 1) {
                this.totalviewtimell.setVisibility(0);
            } else {
                this.totalviewtimell.setVisibility(8);
            }
        }

        private void markAsReadVideoType1_7(final Lists lists, LinearLayout llEnableMarkAsRead, final CheckBox checkMark, TextView tvMark, final int positon) {
            boolean z = false;
            if (Helper.isShowMarkAsDone(lists.getVideo_type())) {
                llEnableMarkAsRead.setVisibility(0);
            } else {
                llEnableMarkAsRead.setVisibility(8);
            }
            if (!TextUtils.isEmpty(lists.getMark_as_complete()) && lists.getMark_as_complete().equalsIgnoreCase("1")) {
                z = true;
            }
            final boolean z2 = z;
            checkMarkUnmark(llEnableMarkAsRead, checkMark, tvMark, z2);
            checkMark.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter.SingleStudyListHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    boolean zIsChecked = ((CheckBox) v).isChecked();
                    if (zIsChecked) {
                        SingleStudyListHolder.this.markCheckAlertDialog(zIsChecked, lists, checkMark, z2, positon);
                    }
                }
            });
        }

        private void checkMarkUnmark(LinearLayout llEnableMarkAsRead, CheckBox checkMark, TextView tvMark, boolean isVideoReadMarked) {
            if (llEnableMarkAsRead.getVisibility() == 0 && isVideoReadMarked) {
                checkMark.setChecked(true);
                tvMark.setText(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED);
                checkMark.setButtonTintList(ColorStateList.valueOf(SingleStudyAdapter.this.activity.getResources().getColor(R.color.colorPrimary)));
                checkMark.setEnabled(false);
                return;
            }
            checkMark.setChecked(false);
            tvMark.setText("Mark Complete");
            checkMark.setButtonTintList(ColorStateList.valueOf(SingleStudyAdapter.this.activity.getResources().getColor(R.color.grey_new_mark_read)));
            checkMark.setEnabled(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void markCheckAlertDialog(final boolean isChecked, final Lists lists, final CheckBox checkMark, final boolean finalIsVideoReadMarked, final int positon) {
            AlertDialog.Builder builder = new AlertDialog.Builder(SingleStudyAdapter.this.activity);
            builder.setTitle(SingleStudyAdapter.this.activity.getResources().getString(R.string.mark_read));
            builder.setCancelable(false);
            builder.setMessage(SingleStudyAdapter.this.activity.getResources().getString(R.string.are_you_sure_you_want_to_mark_video_completed));
            builder.setNegativeButton(SingleStudyAdapter.this.activity.getResources().getString(R.string.no), new DialogInterface.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyListHolder$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    SingleStudyAdapter.SingleStudyListHolder.lambda$markCheckAlertDialog$10(checkMark, dialogInterface, i);
                }
            });
            builder.setPositiveButton(SingleStudyAdapter.this.activity.getResources().getString(R.string.yes), new DialogInterface.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyListHolder$$ExternalSyntheticLambda3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$markCheckAlertDialog$11(finalIsVideoReadMarked, isChecked, lists, positon, checkMark, dialogInterface, i);
                }
            });
            builder.create().show();
        }

        static /* synthetic */ void lambda$markCheckAlertDialog$10(CheckBox checkBox, DialogInterface dialogInterface, int i) {
            checkBox.setChecked(false);
            dialogInterface.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$markCheckAlertDialog$11(boolean z, boolean z2, Lists lists, int i, CheckBox checkBox, DialogInterface dialogInterface, int i2) {
            if (!Helper.isNetworkConnected(SingleStudyAdapter.this.activity)) {
                checkBox.setChecked(false);
                Toast.makeText(SingleStudyAdapter.this.activity, "No internet connection", 0).show();
            } else if (!z && z2) {
                SingleStudyAdapter.this.videodata = lists;
                SingleStudyAdapter.this.selectedMarkReadPosition = i;
                SingleStudyAdapter singleStudyAdapter = SingleStudyAdapter.this;
                new NetworkCall(singleStudyAdapter, singleStudyAdapter.activity).NetworkAPICall(API.MARK_READ_VIDEO_TYPE_1_7, "", true, false);
            }
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDownloadIcons(ArrayList<Lists> list, int position, ImageView optionMenuImgView, TextView subItemRV) {
        int i = position - 1;
        if (list.get(i).getIs_locked() != null && list.get(i).getIs_locked().equalsIgnoreCase("1")) {
            optionMenuImgView.setVisibility(8);
            return;
        }
        optionMenuImgView.setImageResource(R.drawable.ic_menu_download);
        if (list.get(i).getVideo_type() != null && list.get(i).getVideo_type().equalsIgnoreCase("7")) {
            if (list.get(i).getIs_download_available() != null && list.get(i).getIs_download_available().equalsIgnoreCase("1") && list.get(i).getVideo_type().equalsIgnoreCase("7")) {
                optionMenuImgView.setVisibility(0);
            } else {
                optionMenuImgView.setVisibility(8);
            }
        } else if (list.get(i).getVideo_type() != null && list.get(i).getVideo_type().equalsIgnoreCase("1") && SharedPreference.getInstance().getString(Const.YOUTUBE_DOWNLOAD).equalsIgnoreCase("1")) {
            if (SharedPreference.getInstance().getString(Const.YOUTUBE_DOWNLOAD).equalsIgnoreCase("1") && list.get(i).getVideo_type() != null && list.get(i).getVideo_type().equalsIgnoreCase("1") && list.get(i).getFile_type() != null && list.get(i).getFile_type().equalsIgnoreCase("3") && list.get(i).getIs_download_available() != null && list.get(i).getIs_download_available().equalsIgnoreCase("1")) {
                optionMenuImgView.setVisibility(0);
            } else {
                optionMenuImgView.setVisibility(8);
            }
        }
        if (list.get(i).getVideo_status() != null) {
            if (list.get(i).getVideo_status().equalsIgnoreCase("Download Running")) {
                optionMenuImgView.setVisibility(8);
                subItemRV.setVisibility(8);
                return;
            }
            if (list.get(i).getVideo_status().equalsIgnoreCase("Downloaded")) {
                optionMenuImgView.setVisibility(0);
                optionMenuImgView.setEnabled(false);
                subItemRV.setVisibility(8);
                optionMenuImgView.setImageResource(R.drawable.ic_downloaded_chapter);
                subItemRV.setText(this.activity.getResources().getString(R.string.duration) + list.get(i).getVideo_time());
                return;
            }
            if (list.get(i).getVideo_status().equalsIgnoreCase("Download")) {
                optionMenuImgView.setEnabled(true);
                subItemRV.setVisibility(8);
                optionMenuImgView.setImageResource(R.drawable.ic_menu_download);
                optionMenuImgView.setVisibility(0);
                return;
            }
            subItemRV.setVisibility(8);
            optionMenuImgView.setVisibility(8);
        }
    }

    public class StudyNoDataViewHolder extends RecyclerView.ViewHolder {
        Button backBtn;
        RelativeLayout no_data_found_RL;

        public void setData() {
        }

        public StudyNoDataViewHolder(View itemView) {
            super(itemView);
            this.no_data_found_RL = (RelativeLayout) itemView.findViewById(R.id.no_data_found_RL);
            this.backBtn = (Button) itemView.findViewById(R.id.backBtn);
        }
    }

    public class SingleStudyPdfListHolder extends RecyclerView.ViewHolder {
        ImageView arrowIV;
        Button backBtn;
        CardView ibt_single_sub_vd_RL;
        ImageView imageIcon;
        ImageView liveIV;
        RelativeLayout lockRL;
        RelativeLayout no_data_found_RL;
        TextView read_now;
        ImageView share;
        RelativeLayout studyitemLL;
        RelativeLayout thumbRl;
        TextView titleCategory;

        public SingleStudyPdfListHolder(View itemView) {
            super(itemView);
            this.lockRL = (RelativeLayout) itemView.findViewById(R.id.lockRL);
            this.arrowIV = (ImageView) itemView.findViewById(R.id.arrowIV);
            this.read_now = (TextView) itemView.findViewById(R.id.read_now);
            this.share = (ImageView) itemView.findViewById(R.id.share);
            this.liveIV = (ImageView) itemView.findViewById(R.id.liveIV);
            this.studyitemLL = (RelativeLayout) itemView.findViewById(R.id.study_single_itemLL);
            this.imageIcon = (ImageView) itemView.findViewById(R.id.imageIV);
            this.thumbRl = (RelativeLayout) itemView.findViewById(R.id.thumbRl);
            this.titleCategory = (TextView) itemView.findViewById(R.id.examPrepTitleTV);
            this.no_data_found_RL = (RelativeLayout) itemView.findViewById(R.id.no_data_found_RL);
            this.backBtn = (Button) itemView.findViewById(R.id.backBtn);
            this.ibt_single_sub_vd_RL = (CardView) itemView.findViewById(R.id.ibt_single_sub_vd_RL);
        }

        public void setData(final ArrayList<Lists> list, final int position) {
            if (list != null && list.size() > 0) {
                SingleStudyAdapter.this.setThumbRatio(this.thumbRl);
                this.titleCategory.setText(list.get(position - 1).getTitle());
                SingleStudyAdapter.this.handleVisibilityMain(this.ibt_single_sub_vd_RL, this.no_data_found_RL);
                SingleStudyAdapter.this.handleVisibilityLock(position, list, this.lockRL);
                this.liveIV.setVisibility(8);
                handleVisibilitySkipLayerThree(list, position);
                this.share.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyPdfListHolder$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$setData$0(position);
                    }
                }));
                this.read_now.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyPdfListHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$1(list, position, view);
                    }
                });
                this.studyitemLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyPdfListHolder$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$2(list, position, view);
                    }
                });
                return;
            }
            SingleStudyAdapter.this.handleVisibilityNoData(this.ibt_single_sub_vd_RL, this.no_data_found_RL, this.backBtn);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$setData$0(int i) {
            if (SingleStudyAdapter.this.is_purchase.equalsIgnoreCase("1")) {
                int i2 = i - 1;
                if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("8") || SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("7") || SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("1")) {
                    Helper.sharePdf(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getTopic_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getRevert_api(), Const.PDF, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getThumbnail_url(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle(), SingleStudy.parentCourseId);
                }
            } else {
                int i3 = i - 1;
                if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getIs_locked().equalsIgnoreCase("1")) {
                    if (SingleStudyAdapter.this.isCourseSoldOut()) {
                        Toast.makeText(SingleStudyAdapter.this.activity, R.string.sold_out_msg, 0).show();
                        return null;
                    }
                    Intent intent = new Intent(SingleStudyAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                    intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter.this.singleStudy);
                    intent.putExtra(Const.IS_BOOK, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                    intent.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                    Helper.gotoActivity(intent, SingleStudyAdapter.this.activity);
                } else if (SingleStudyAdapter.this.examPrepItem.getList().get(i3).getFile_type().equalsIgnoreCase("8") || SingleStudyAdapter.this.examPrepItem.getList().get(i3).getFile_type().equalsIgnoreCase("7") || SingleStudyAdapter.this.examPrepItem.getList().get(i3).getFile_type().equalsIgnoreCase("1")) {
                    Helper.sharePdf(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getCourse_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getTopic_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getTile_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getTile_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getPayload().getRevert_api(), Const.PDF, SingleStudyAdapter.this.examPrepItem.getList().get(i3).getThumbnail_url(), SingleStudyAdapter.this.examPrepItem.getList().get(i3).getTitle(), SingleStudy.parentCourseId);
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$1(ArrayList arrayList, int i, View view) {
            int i2 = i - 1;
            if (((Lists) arrayList.get(i2)).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(SingleStudyAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, SingleStudyAdapter.this.activity);
                return;
            }
            if (SingleStudyAdapter.this.is_purchase.equalsIgnoreCase("1")) {
                if (!SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("7") && (TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url()) || TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId()))) {
                    Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.no_pdf_found), 0).show();
                    return;
                }
                if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("8")) {
                    SingleStudyAdapter singleStudyAdapter = SingleStudyAdapter.this;
                    singleStudyAdapter.openWebPage(singleStudyAdapter.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url());
                    return;
                } else {
                    if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("1")) {
                        Helper.GoToWebViewPDFActivity(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url(), !TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getIs_download_available()) && SingleStudyAdapter.this.examPrepItem.getList().get(i2).getIs_download_available().equalsIgnoreCase("1"), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle(), (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId())).toString(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getIs_share());
                        return;
                    }
                    return;
                }
            }
            if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent2 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent2.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter.this.singleStudy);
                intent2.putExtra(Const.IS_BOOK, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent2.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent2, SingleStudyAdapter.this.activity);
                return;
            }
            if (!SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("7") && (TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url()) || TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId()))) {
                Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.no_pdf_found), 0).show();
                return;
            }
            if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("8")) {
                SingleStudyAdapter singleStudyAdapter2 = SingleStudyAdapter.this;
                singleStudyAdapter2.openWebPage(singleStudyAdapter2.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url());
            } else if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("1")) {
                Helper.GoToWebViewPDFActivity(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url(), !TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getIs_download_available()) && SingleStudyAdapter.this.examPrepItem.getList().get(i2).getIs_download_available().equalsIgnoreCase("1"), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle(), (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId())).toString(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getIs_share());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$2(ArrayList arrayList, int i, View view) {
            String str;
            String str2;
            Intent intent;
            Intent intent2;
            int i2 = i - 1;
            if (((Lists) arrayList.get(i2)).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent3 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent3.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter.this.singleStudy);
                intent3.putExtra(Const.IS_BOOK, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent3.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent3, SingleStudyAdapter.this.activity);
                return;
            }
            if (SingleStudyAdapter.this.isSkip.equalsIgnoreCase("1")) {
                str = Const.EXAMPREP;
                str2 = "Main Folder";
            } else {
                str2 = "Main Folder";
                if (!SingleStudyAdapter.this.isSkip.equalsIgnoreCase("2")) {
                    if (SingleStudyAdapter.this.isSkip.equalsIgnoreCase("3")) {
                        if (SingleStudyAdapter.this.is_purchase.equalsIgnoreCase("1")) {
                            if (!SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("7") && TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId())) {
                                Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.no_pdf_found), 0).show();
                                return;
                            }
                            if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("8")) {
                                SingleStudyAdapter singleStudyAdapter = SingleStudyAdapter.this;
                                singleStudyAdapter.openWebPage(singleStudyAdapter.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url());
                            }
                            if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("7")) {
                                Intent intent4 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) WebViewActivty.class);
                                intent4.putExtra("type", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle());
                                intent4.putExtra("url", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getDescription());
                                Helper.gotoActivity(intent4, SingleStudyAdapter.this.activity);
                                return;
                            }
                            if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("1")) {
                                Helper.GoToWebViewPDFActivity(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url(), !TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getIs_download_available()) && SingleStudyAdapter.this.examPrepItem.getList().get(i2).getIs_download_available().equalsIgnoreCase("1"), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle(), (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId())).toString(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getIs_share());
                                return;
                            }
                            return;
                        }
                        if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getIs_locked().equalsIgnoreCase("1")) {
                            if (SingleStudyAdapter.this.isCourseSoldOut()) {
                                Toast.makeText(SingleStudyAdapter.this.activity, R.string.sold_out_msg, 0).show();
                                return;
                            }
                            Intent intent5 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                            intent5.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter.this.singleStudy);
                            intent5.putExtra(Const.IS_BOOK, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                            intent5.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                            Helper.gotoActivity(intent5, SingleStudyAdapter.this.activity);
                            return;
                        }
                        if (!SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("7") && TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId())) {
                            Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.no_pdf_found), 0).show();
                            return;
                        }
                        if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("8")) {
                            SingleStudyAdapter singleStudyAdapter2 = SingleStudyAdapter.this;
                            singleStudyAdapter2.openWebPage(singleStudyAdapter2.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url());
                        }
                        if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("7")) {
                            Intent intent6 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) WebViewActivty.class);
                            intent6.putExtra("type", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle());
                            intent6.putExtra("url", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getDescription());
                            Helper.gotoActivity(intent6, SingleStudyAdapter.this.activity);
                            return;
                        }
                        if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("1")) {
                            Helper.GoToWebViewPDFActivity(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url(), !TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getIs_download_available()) && SingleStudyAdapter.this.examPrepItem.getList().get(i2).getIs_download_available().equalsIgnoreCase("1"), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle(), (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId())).toString(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getIs_share());
                            return;
                        }
                        return;
                    }
                    ExamPrepItem examPrepItem = new ExamPrepItem();
                    examPrepItem.setList(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getList());
                    if (!TextUtils.isEmpty(SingleStudyAdapter.this.content_type) && SingleStudyAdapter.this.content_type.equalsIgnoreCase("1") && !SingleStudyAdapter.this.tileIdAPI.equalsIgnoreCase("0")) {
                        intent2 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) FolderActivity.class);
                        intent2.putExtra("title", arrayList.get(i2) != null ? ((Lists) arrayList.get(i2)).getTitle() : str2);
                        intent2.putExtra("firstTime", "1");
                    } else {
                        Intent intent7 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) CourseActivity.class);
                        intent7.putExtra("title", SingleStudyAdapter.this.singleStudy.getData().getCourseDetail() != null ? SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getTitle() : "Course");
                        if (SingleStudyAdapter.this.tileTypeAPI.equals(Const.COMBO) || SingleStudyAdapter.this.tileTypeAPI.equals("content")) {
                            intent7.putExtra(Const.TAB_TILE_VISIBILITY, "1");
                        } else {
                            intent7.putExtra(Const.TAB_TILE_VISIBILITY, "0");
                        }
                        intent2 = intent7;
                    }
                    SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(SingleStudyAdapter.this.singleStudy != null ? SingleStudyAdapter.this.singleStudy : new CourseDetail()));
                    SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(examPrepItem));
                    SharedPreference.getInstance().putString("list", new Gson().toJson(arrayList.get(i2) != null ? arrayList.get(i2) : new Lists()));
                    intent2.putExtra(Const.FRAG_TYPE, Const.EXAMPREP);
                    intent2.putExtra(Const.IS_COMBO, SingleStudyAdapter.this.isCombo);
                    intent2.putExtra("content_type", SingleStudyAdapter.this.contentType);
                    intent2.putExtra("tile_id", SingleStudyAdapter.this.tileIdAPI);
                    intent2.putExtra(Const.TILE_TYPE, SingleStudyAdapter.this.tileTypeAPI);
                    intent2.putExtra(Const.REVERT_API, SingleStudyAdapter.this.revertAPI);
                    Helper.gotoActivity(intent2, SingleStudyAdapter.this.activity);
                    return;
                }
                str = Const.EXAMPREP;
            }
            if (!TextUtils.isEmpty(SingleStudyAdapter.this.content_type) && SingleStudyAdapter.this.content_type.equalsIgnoreCase("1") && !SingleStudyAdapter.this.tileIdAPI.equalsIgnoreCase("0")) {
                intent = new Intent(SingleStudyAdapter.this.activity, (Class<?>) FolderActivity.class);
                intent.putExtra("title", arrayList.get(i2) != null ? ((Lists) arrayList.get(i2)).getTitle() : str2);
                intent.putExtra("firstTime", "1");
            } else {
                intent = new Intent(SingleStudyAdapter.this.activity, (Class<?>) CourseActivity.class);
                intent.putExtra("title", SingleStudyAdapter.this.singleStudy.getData().getCourseDetail() != null ? SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getTitle() : "Course");
                if (SingleStudyAdapter.this.tileTypeAPI.equals(Const.COMBO) || SingleStudyAdapter.this.tileTypeAPI.equals("content")) {
                    intent.putExtra(Const.TAB_TILE_VISIBILITY, "1");
                } else {
                    intent.putExtra(Const.TAB_TILE_VISIBILITY, "0");
                }
            }
            SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(SingleStudyAdapter.this.singleStudy != null ? SingleStudyAdapter.this.singleStudy : new CourseDetail()));
            SharedPreference.getInstance().putString(str, new Gson().toJson(SingleStudyAdapter.this.examPrepItem != null ? SingleStudyAdapter.this.examPrepItem : new ExamPrepItem()));
            SharedPreference.getInstance().putString("list", new Gson().toJson(SingleStudyAdapter.this.examPrepItem.getList().get(i2) != null ? SingleStudyAdapter.this.examPrepItem.getList().get(i2) : new Lists()));
            intent.putExtra(Const.FRAG_TYPE, Const.EXAMPREPLAST);
            intent.putExtra(Const.LIST_SUBJECT, SingleStudyAdapter.this.examPrepItem.getList().get(i2));
            intent.putExtra(Const.IS_COMBO, SingleStudyAdapter.this.isCombo);
            intent.putExtra("content_type", SingleStudyAdapter.this.contentType);
            intent.putExtra(Const.TEST_TYPE, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getCount());
            intent.putExtra("tile_id", SingleStudyAdapter.this.tileIdAPI);
            intent.putExtra(Const.TILE_TYPE, SingleStudyAdapter.this.tileTypeAPI);
            intent.putExtra(Const.REVERT_API, SingleStudyAdapter.this.revertAPI);
            Helper.gotoActivity(intent, SingleStudyAdapter.this.activity);
        }

        private void handleVisibilitySkipLayerThree(ArrayList<Lists> list, int position) {
            if (SingleStudyAdapter.this.isSkip.equalsIgnoreCase("3")) {
                if (SingleStudyAdapter.this.is_purchase.equalsIgnoreCase("0")) {
                    this.arrowIV.setVisibility(8);
                }
                int i = position - 1;
                if (!TextUtils.isEmpty(list.get(i).getThumbnail_url())) {
                    SingleStudyAdapter.this.setThumbAccordingRatio(list.get(i).getThumbnail_url(), this.imageIcon);
                } else if (SingleStudyAdapter.this.bottomSetting != null && SingleStudyAdapter.this.bottomSetting.getLayout_type() != null && SingleStudyAdapter.this.bottomSetting.getLayout_type().equals("1")) {
                    this.imageIcon.setImageResource(R.mipmap.square_placeholder);
                } else {
                    this.imageIcon.setImageResource(R.mipmap.square_placeholder_new);
                }
                this.read_now.setEnabled(true);
                this.studyitemLL.setEnabled(true);
                if (list.get(i).getIs_locked().equals("0")) {
                    this.read_now.setVisibility(0);
                    this.arrowIV.setVisibility(8);
                    if (Helper.isShowShareButton(SingleStudyAdapter.this.leftMenu)) {
                        this.share.setVisibility(0);
                        return;
                    } else {
                        this.share.setVisibility(8);
                        return;
                    }
                }
                this.read_now.setVisibility(8);
                this.share.setVisibility(8);
                return;
            }
            int i2 = position - 1;
            if (!TextUtils.isEmpty(list.get(i2).getImage_icon())) {
                SingleStudyAdapter.this.setThumbAccordingRatio(list.get(i2).getImage_icon(), this.imageIcon);
            } else if (SingleStudyAdapter.this.bottomSetting != null && SingleStudyAdapter.this.bottomSetting.getLayout_type() != null && SingleStudyAdapter.this.bottomSetting.getLayout_type().equals("1")) {
                this.imageIcon.setImageResource(R.mipmap.square_placeholder);
            } else {
                this.imageIcon.setImageResource(R.mipmap.square_placeholder_new);
            }
            this.share.setVisibility(8);
            this.studyitemLL.setEnabled(true);
            this.read_now.setVisibility(8);
        }
    }

    public class SingleStudyConceptListHolder extends RecyclerView.ViewHolder {
        ImageView arrowIV;
        Button backBtn;
        CardView ibt_single_sub_vd_RL;
        ImageView imageIcon;
        RelativeLayout layout_fun;
        ImageView liveIV;
        RelativeLayout lockRL;
        RelativeLayout no_data_found_RL;
        ImageView optionMenuImgView;
        TextView read_now;
        ImageView share;
        RelativeLayout studyitemLL;
        TextView subItemRV;
        RelativeLayout thumbRl;
        TextView titleCategory;

        public SingleStudyConceptListHolder(View itemView) {
            super(itemView);
            this.lockRL = (RelativeLayout) itemView.findViewById(R.id.lockRL);
            this.arrowIV = (ImageView) itemView.findViewById(R.id.arrowIV);
            this.share = (ImageView) itemView.findViewById(R.id.share);
            this.liveIV = (ImageView) itemView.findViewById(R.id.liveIV);
            this.studyitemLL = (RelativeLayout) itemView.findViewById(R.id.study_single_itemLL);
            this.imageIcon = (ImageView) itemView.findViewById(R.id.profileImage);
            this.thumbRl = (RelativeLayout) itemView.findViewById(R.id.thumbRl);
            this.titleCategory = (TextView) itemView.findViewById(R.id.examPrepTitleTV);
            this.subItemRV = (TextView) itemView.findViewById(R.id.subItemRV);
            this.read_now = (TextView) itemView.findViewById(R.id.read_now);
            this.layout_fun = (RelativeLayout) itemView.findViewById(R.id.layout_fun);
            this.no_data_found_RL = (RelativeLayout) itemView.findViewById(R.id.no_data_found_RL);
            this.backBtn = (Button) itemView.findViewById(R.id.backBtn);
            this.ibt_single_sub_vd_RL = (CardView) itemView.findViewById(R.id.ibt_single_sub_vd_RL);
            this.optionMenuImgView = (ImageView) itemView.findViewById(R.id.optionMenuImgView);
        }

        public void setData(final ArrayList<Lists> list, final int position) {
            if (list != null && list.size() > 0) {
                SingleStudyAdapter.this.setThumbRatio(this.thumbRl);
                int i = position - 1;
                this.titleCategory.setText(list.get(i).getTitle());
                SingleStudyAdapter.this.handleVisibilityMain(this.ibt_single_sub_vd_RL, this.no_data_found_RL);
                this.liveIV.setVisibility(8);
                if (SingleStudyAdapter.this.is_purchase.equalsIgnoreCase("0") && SingleStudyAdapter.this.isSkip.equalsIgnoreCase("3")) {
                    this.arrowIV.setVisibility(8);
                }
                if (SingleStudyAdapter.this.isSkip.equalsIgnoreCase("3")) {
                    this.share.setVisibility(8);
                    if (list.get(i).getFile_type().equalsIgnoreCase("7")) {
                        if (list.get(i).getIs_locked().equals("0")) {
                            this.layout_fun.setVisibility(0);
                        } else {
                            this.layout_fun.setVisibility(8);
                        }
                        this.read_now.setVisibility(0);
                        this.optionMenuImgView.setVisibility(8);
                        this.studyitemLL.setEnabled(true);
                        if (Helper.isShowShareButton(SingleStudyAdapter.this.leftMenu)) {
                            this.share.setVisibility(0);
                        } else {
                            this.share.setVisibility(8);
                        }
                    } else if (list.get(i).getFile_type().equalsIgnoreCase("12") || list.get(i).getFile_type().equalsIgnoreCase("11") || list.get(i).getFile_type().equalsIgnoreCase("8")) {
                        if (list.get(i).getIs_locked().equals("0")) {
                            this.layout_fun.setVisibility(0);
                        } else {
                            this.layout_fun.setVisibility(8);
                        }
                        this.read_now.setVisibility(0);
                        this.optionMenuImgView.setVisibility(0);
                        this.optionMenuImgView.setImageResource(R.drawable.delete);
                        this.subItemRV.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.revision_type));
                        this.studyitemLL.setEnabled(true);
                    } else {
                        this.layout_fun.setVisibility(8);
                        this.read_now.setVisibility(8);
                        this.optionMenuImgView.setVisibility(8);
                    }
                } else {
                    this.studyitemLL.setEnabled(true);
                    this.layout_fun.setVisibility(8);
                    this.read_now.setVisibility(8);
                    if (list.get(i).getCount() != null) {
                        this.subItemRV.setText(SingleStudyAdapter.this.activity.getResources().getString(R.string.total_) + list.get(i).getCount());
                    }
                    this.subItemRV.setVisibility(8);
                }
                if (!TextUtils.isEmpty(list.get(i).getImage_icon())) {
                    SingleStudyAdapter.this.setThumbAccordingRatio(list.get(i).getImage_icon(), this.imageIcon);
                } else if (SingleStudyAdapter.this.bottomSetting != null && SingleStudyAdapter.this.bottomSetting.getLayout_type() != null && SingleStudyAdapter.this.bottomSetting.getLayout_type().equals("1")) {
                    this.imageIcon.setImageResource(R.mipmap.square_placeholder);
                } else {
                    this.imageIcon.setImageResource(R.mipmap.square_placeholder_new);
                }
                SingleStudyAdapter.this.handleVisibilityLock(position, list, this.lockRL);
                this.read_now.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyConceptListHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$0(list, position, view);
                    }
                });
                this.studyitemLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyConceptListHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$1(list, position, view);
                    }
                });
                this.share.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$SingleStudyConceptListHolder$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$setData$2(position);
                    }
                }));
                return;
            }
            SingleStudyAdapter.this.handleVisibilityNoData(this.ibt_single_sub_vd_RL, this.no_data_found_RL, this.backBtn);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$0(ArrayList arrayList, int i, View view) {
            StringBuilder sbAppend;
            String id;
            StringBuilder sbAppend2;
            String id2;
            int i2 = i - 1;
            if (((Lists) arrayList.get(i2)).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(SingleStudyAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, SingleStudyAdapter.this.activity);
                return;
            }
            if (SingleStudyAdapter.this.isSkip.equalsIgnoreCase("3")) {
                if (SingleStudyAdapter.this.is_purchase.equalsIgnoreCase("1")) {
                    if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("12")) {
                        if (SingleStudyAdapter.this.examPrepItem.getList().size() > 0) {
                            Intent intent2 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) RevisionActivity.class);
                            intent2.putExtra("t_id", SingleStudyAdapter.this.tileIdAPI);
                            intent2.putExtra("postion", i);
                            intent2.putExtra(Const.VIDEO_ID, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId());
                            intent2.putExtra("v_list", ExamPrepLayer2.actual_videolist);
                            intent2.putExtra("f_id", SingleStudyAdapter.this.examPrepItem.getList().get(0).getId());
                            intent2.putExtra("c_id", SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId());
                            intent2.putExtra("title", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle());
                            intent2.putExtra("url", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url());
                            intent2.putExtra(Const.VIA, "main");
                            Helper.gotoActivity(intent2, SingleStudyAdapter.this.activity);
                            return;
                        }
                        return;
                    }
                    if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("11")) {
                        Intent intent3 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) WebViewActivty.class);
                        intent3.putExtra("type", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle());
                        intent3.putExtra("url", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url());
                        Helper.gotoActivity(intent3, SingleStudyAdapter.this.activity);
                        return;
                    }
                    if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("8")) {
                        SingleStudyAdapter singleStudyAdapter = SingleStudyAdapter.this;
                        singleStudyAdapter.openWebPage(singleStudyAdapter.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url());
                        return;
                    }
                    if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("6")) {
                        if (TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId())) {
                            Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.no_image_found), 0).show();
                            return;
                        }
                        Intent intent4 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) WebViewActivty.class);
                        intent4.putExtra("type", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle());
                        intent4.putExtra("url", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url());
                        intent4.putExtra("file_type", "image");
                        Helper.gotoActivity(intent4, SingleStudyAdapter.this.activity);
                        return;
                    }
                    Intent intent5 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) Concept_newActivity.class);
                    intent5.putExtra("id", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId());
                    intent5.putExtra("name", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle());
                    if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                        sbAppend2 = new StringBuilder().append(SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId());
                        id2 = MqttTopic.MULTI_LEVEL_WILDCARD;
                    } else {
                        sbAppend2 = new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD);
                        id2 = SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId();
                    }
                    intent5.putExtra("course_id", sbAppend2.append(id2).toString());
                    intent5.putExtra("tile_id", SingleStudyAdapter.this.tileIdAPI);
                    Helper.gotoActivity(intent5, SingleStudyAdapter.this.activity);
                    return;
                }
                if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getIs_locked().equalsIgnoreCase("1")) {
                    if (SingleStudyAdapter.this.isCourseSoldOut()) {
                        Toast.makeText(SingleStudyAdapter.this.activity, R.string.sold_out_msg, 0).show();
                        return;
                    }
                    Intent intent6 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                    intent6.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter.this.singleStudy);
                    intent6.putExtra(Const.IS_BOOK, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                    intent6.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                    Helper.gotoActivity(intent6, SingleStudyAdapter.this.activity);
                    return;
                }
                if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("12")) {
                    if (SingleStudyAdapter.this.examPrepItem.getList().size() > 0) {
                        Intent intent7 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) RevisionActivity.class);
                        intent7.putExtra("t_id", SingleStudyAdapter.this.tileIdAPI);
                        intent7.putExtra("postion", i);
                        intent7.putExtra(Const.VIDEO_ID, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId());
                        intent7.putExtra("v_list", ExamPrepLayer2.actual_videolist);
                        intent7.putExtra("f_id", SingleStudyAdapter.this.examPrepItem.getList().get(0).getId());
                        intent7.putExtra("c_id", SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId());
                        intent7.putExtra("title", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle());
                        intent7.putExtra("url", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url());
                        intent7.putExtra(Const.VIA, "main");
                        Helper.gotoActivity(intent7, SingleStudyAdapter.this.activity);
                        return;
                    }
                    return;
                }
                if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("11")) {
                    Intent intent8 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) WebViewActivty.class);
                    intent8.putExtra("type", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle());
                    intent8.putExtra("url", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url());
                    Helper.gotoActivity(intent8, SingleStudyAdapter.this.activity);
                    return;
                }
                if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("8")) {
                    SingleStudyAdapter singleStudyAdapter2 = SingleStudyAdapter.this;
                    singleStudyAdapter2.openWebPage(singleStudyAdapter2.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url());
                    return;
                }
                if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("6")) {
                    if (TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId())) {
                        Toast.makeText(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.activity.getResources().getString(R.string.no_image_found), 0).show();
                        return;
                    }
                    Intent intent9 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) WebViewActivty.class);
                    intent9.putExtra("type", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle());
                    intent9.putExtra("url", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getFile_url());
                    intent9.putExtra("file_type", "image");
                    Helper.gotoActivity(intent9, SingleStudyAdapter.this.activity);
                    return;
                }
                Intent intent10 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) Concept_newActivity.class);
                intent10.putExtra("id", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId());
                intent10.putExtra("name", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle());
                if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                    sbAppend = new StringBuilder().append(SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId());
                    id = MqttTopic.MULTI_LEVEL_WILDCARD;
                } else {
                    sbAppend = new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD);
                    id = SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId();
                }
                intent10.putExtra("course_id", sbAppend.append(id).toString());
                intent10.putExtra("tile_id", SingleStudyAdapter.this.tileIdAPI);
                Helper.gotoActivity(intent10, SingleStudyAdapter.this.activity);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$1(ArrayList arrayList, int i, View view) {
            Intent intent;
            Intent intent2;
            int i2 = i - 1;
            if (((Lists) arrayList.get(i2)).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent3 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent3.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter.this.singleStudy);
                intent3.putExtra(Const.IS_BOOK, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent3.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent3, SingleStudyAdapter.this.activity);
                return;
            }
            if (SingleStudyAdapter.this.isSkip.equalsIgnoreCase("1") || SingleStudyAdapter.this.isSkip.equalsIgnoreCase("2")) {
                String str = Const.EXAMPREP;
                String str2 = Const.SINGLE_STUDY_DATA;
                if (!TextUtils.isEmpty(SingleStudyAdapter.this.content_type) && SingleStudyAdapter.this.content_type.equalsIgnoreCase("1") && !SingleStudyAdapter.this.tileIdAPI.equalsIgnoreCase("0")) {
                    intent = new Intent(SingleStudyAdapter.this.activity, (Class<?>) FolderActivity.class);
                    intent.putExtra("title", arrayList.get(i2) != null ? ((Lists) arrayList.get(i2)).getTitle() : "Main Folder");
                    intent.putExtra("firstTime", "1");
                } else {
                    Intent intent4 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) CourseActivity.class);
                    intent4.putExtra("title", SingleStudyAdapter.this.singleStudy.getData().getCourseDetail() != null ? SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getTitle() : "Course");
                    if (SingleStudyAdapter.this.tileTypeAPI.equals(Const.COMBO) || SingleStudyAdapter.this.tileTypeAPI.equals("content")) {
                        intent4.putExtra(Const.TAB_TILE_VISIBILITY, "1");
                    } else {
                        intent4.putExtra(Const.TAB_TILE_VISIBILITY, "0");
                    }
                    intent = intent4;
                }
                SharedPreference.getInstance().putString(str2, new Gson().toJson(SingleStudyAdapter.this.singleStudy != null ? SingleStudyAdapter.this.singleStudy : new CourseDetail()));
                SharedPreference.getInstance().putString(str, new Gson().toJson(SingleStudyAdapter.this.examPrepItem != null ? SingleStudyAdapter.this.examPrepItem : new ExamPrepItem()));
                SharedPreference.getInstance().putString("list", new Gson().toJson(SingleStudyAdapter.this.examPrepItem.getList().get(i2) != null ? SingleStudyAdapter.this.examPrepItem.getList().get(i2) : new Lists()));
                intent.putExtra(Const.FRAG_TYPE, Const.EXAMPREPLAST);
                intent.putExtra(Const.LIST_SUBJECT, SingleStudyAdapter.this.examPrepItem.getList().get(i2));
                intent.putExtra(Const.IS_COMBO, SingleStudyAdapter.this.isCombo);
                intent.putExtra("content_type", SingleStudyAdapter.this.contentType);
                intent.putExtra(Const.TEST_TYPE, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getCount());
                intent.putExtra("tile_id", SingleStudyAdapter.this.tileIdAPI);
                intent.putExtra(Const.TILE_TYPE, SingleStudyAdapter.this.tileTypeAPI);
                intent.putExtra(Const.REVERT_API, SingleStudyAdapter.this.revertAPI);
                Helper.gotoActivity(intent, SingleStudyAdapter.this.activity);
                return;
            }
            if (SingleStudyAdapter.this.isSkip.equalsIgnoreCase("3")) {
                if (SingleStudyAdapter.this.is_purchase.equalsIgnoreCase("1")) {
                    Intent intent5 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) Concept_newActivity.class);
                    intent5.putExtra("id", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId());
                    intent5.putExtra("name", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle());
                    intent5.putExtra("course_id", (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId())).toString());
                    intent5.putExtra("tile_id", SingleStudyAdapter.this.tileIdAPI);
                    Helper.gotoActivity(intent5, SingleStudyAdapter.this.activity);
                    return;
                }
                if (SingleStudyAdapter.this.examPrepItem.getList().get(i2).getIs_locked().equalsIgnoreCase("1")) {
                    if (SingleStudyAdapter.this.isCourseSoldOut()) {
                        Toast.makeText(SingleStudyAdapter.this.activity, R.string.sold_out_msg, 0).show();
                        return;
                    }
                    Intent intent6 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                    intent6.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter.this.singleStudy);
                    intent6.putExtra(Const.IS_BOOK, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                    intent6.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                    Helper.gotoActivity(intent6, SingleStudyAdapter.this.activity);
                    return;
                }
                Intent intent7 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) Concept_newActivity.class);
                intent7.putExtra("id", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId());
                intent7.putExtra("name", SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle());
                intent7.putExtra("course_id", (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getId())).toString());
                intent7.putExtra("tile_id", SingleStudyAdapter.this.tileIdAPI);
                Helper.gotoActivity(intent7, SingleStudyAdapter.this.activity);
                return;
            }
            ExamPrepItem examPrepItem = new ExamPrepItem();
            examPrepItem.setList(SingleStudyAdapter.this.examPrepItem.getList().get(i2).getList());
            if (!TextUtils.isEmpty(SingleStudyAdapter.this.content_type) && SingleStudyAdapter.this.content_type.equalsIgnoreCase("1") && !SingleStudyAdapter.this.tileIdAPI.equalsIgnoreCase("0")) {
                intent2 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) FolderActivity.class);
                intent2.putExtra("title", arrayList.get(i2) != null ? ((Lists) arrayList.get(i2)).getTitle() : "Main Folder");
                intent2.putExtra("firstTime", "1");
            } else {
                Intent intent8 = new Intent(SingleStudyAdapter.this.activity, (Class<?>) CourseActivity.class);
                if (SingleStudyAdapter.this.tileTypeAPI.equals(Const.COMBO) || SingleStudyAdapter.this.tileTypeAPI.equals("content")) {
                    intent8.putExtra(Const.TAB_TILE_VISIBILITY, "1");
                } else {
                    intent8.putExtra(Const.TAB_TILE_VISIBILITY, "0");
                }
                intent8.putExtra("title", SingleStudyAdapter.this.singleStudy.getData().getCourseDetail() != null ? SingleStudyAdapter.this.singleStudy.getData().getCourseDetail().getTitle() : "Course");
                intent2 = intent8;
            }
            SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(SingleStudyAdapter.this.singleStudy != null ? SingleStudyAdapter.this.singleStudy : new CourseDetail()));
            SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(examPrepItem));
            SharedPreference.getInstance().putString("list", new Gson().toJson(arrayList.get(i2) != null ? arrayList.get(i2) : new Lists()));
            intent2.putExtra(Const.FRAG_TYPE, Const.EXAMPREP);
            intent2.putExtra(Const.IS_COMBO, SingleStudyAdapter.this.isCombo);
            intent2.putExtra("content_type", SingleStudyAdapter.this.contentType);
            intent2.putExtra("tile_id", SingleStudyAdapter.this.tileIdAPI);
            intent2.putExtra(Const.TILE_TYPE, SingleStudyAdapter.this.tileTypeAPI);
            intent2.putExtra(Const.REVERT_API, SingleStudyAdapter.this.revertAPI);
            Helper.gotoActivity(intent2, SingleStudyAdapter.this.activity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$setData$2(int i) {
            int i2 = i - 1;
            Helper.sharePdf(SingleStudyAdapter.this.activity, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getTopic_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getPayload().getRevert_api(), Const.PDF, SingleStudyAdapter.this.examPrepItem.getList().get(i2).getThumbnail_url(), SingleStudyAdapter.this.examPrepItem.getList().get(i2).getTitle(), SingleStudy.parentCourseId);
            return null;
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void handleVisibilityLock(int position, ArrayList<Lists> list, RelativeLayout lockRL) {
        int i = position - 1;
        if (list.get(i).getIs_locked() == null) {
            return;
        }
        try {
            CourseDetail courseDetail = this.singleStudy;
            if (courseDetail != null && courseDetail.getData().getCourseDetail() != null && this.singleStudy.getData().getCourseDetail().getIsPurchased().equals("1")) {
                list.get(i).setIs_locked("0");
            }
        } catch (Exception unused) {
        }
        if (list.get(i).getIs_locked().equals("0")) {
            lockRL.setVisibility(8);
        } else {
            lockRL.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleVisibilityMain(CardView ibt_single_sub_vd_RL, RelativeLayout no_data_found_RL) {
        ibt_single_sub_vd_RL.setVisibility(0);
        no_data_found_RL.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setThumbRatio(RelativeLayout rlThum) {
        Display defaultDisplay = ((WindowManager) this.activity.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        ViewGroup.LayoutParams layoutParams = rlThum.getLayoutParams();
        BottomSetting bottomSetting = this.bottomSetting;
        if (bottomSetting == null || bottomSetting.getLayout_type() == null || !this.bottomSetting.getLayout_type().equals("1")) {
            return;
        }
        layoutParams.height = (int) (Helper.grideHeight * displayMetrics.scaledDensity);
        layoutParams.width = (int) (Helper.grideWidth * displayMetrics.scaledDensity);
        rlThum.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setThumbAccordingRatio(String url, ImageView thumb) {
        BottomSetting bottomSetting = this.bottomSetting;
        if (bottomSetting != null && bottomSetting.getLayout_type() != null && this.bottomSetting.getLayout_type().equals("1")) {
            Activity activity = this.activity;
            Helper.setThumbnailImage(activity, url, activity.getDrawable(R.mipmap.square_placeholder), thumb);
        } else {
            Activity activity2 = this.activity;
            Helper.setThumbnailImage(activity2, url, activity2.getDrawable(R.mipmap.square_placeholder_new), thumb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleVisibilityBasedContentType(int position, ArrayList<Lists> list, ImageView liveIV) {
        String str = this.contentType;
        if (str != null) {
            if (str.equalsIgnoreCase("video" + this.tileIdAPI)) {
                handleLiveVideo(liveIV, list.get(position));
            }
            if (this.contentType.equalsIgnoreCase("content" + this.tileIdAPI)) {
                handleLiveVideo(liveIV, list.get(position));
                return;
            }
            liveIV.setVisibility(8);
            if (this.contentType.contains("video")) {
                if (list.get(position).getIs_live() != null) {
                    if (list.get(position).getIs_live().equals("1")) {
                        liveIV.setVisibility(0);
                        return;
                    } else {
                        liveIV.setVisibility(8);
                        return;
                    }
                }
                liveIV.setVisibility(8);
                return;
            }
            liveIV.setVisibility(8);
            return;
        }
        liveIV.setVisibility(8);
    }

    private void handleLiveVideo(ImageView liveIv, Lists video) {
        if (this.is_purchase.equalsIgnoreCase("0")) {
            if (video.getIs_live() != null) {
                if (video.getIs_live().equals("1")) {
                    liveIv.setVisibility(0);
                    return;
                } else {
                    liveIv.setVisibility(8);
                    return;
                }
            }
            liveIv.setVisibility(8);
            return;
        }
        if (video.getIs_live() != null) {
            if (video.getIs_live().equals("1")) {
                liveIv.setVisibility(0);
                return;
            } else {
                liveIv.setVisibility(8);
                return;
            }
        }
        liveIv.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void download_service(Lists video, int position, ImageView optionMenuImgView) {
        String str;
        VideosDownload videosDownload = new VideosDownload();
        if (this.utkashRoom.getvideoDownloadao().isvideo_exit(video.getId(), MakeMyExam.userId)) {
            videosDownload = this.utkashRoom.getvideoDownloadao().getvideo_byuserid(video.getId(), MakeMyExam.userId);
            videosDownload.setJw_url("https://cdn.jwplayer.com/v2/media/" + video.getFile_url().substring(video.getFile_url().lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1, video.getFile_url().indexOf("-")));
            videosDownload.setVideo_status("Download Running");
            videosDownload.setThumbnail_url("https://cdn.jwplayer.com/v2/media/" + video.getFile_url().substring(video.getFile_url().lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1, video.getFile_url().indexOf("-")) + "/poster.jpg?width=720");
        } else {
            videosDownload.setVideo_id(video.getId());
            if (video.getFile_url().contains("jwplayer") || video.getFile_url().contains("jwplatform")) {
                videosDownload.setJw_url("https://cdn.jwplayer.com/v2/media/" + video.getFile_url().substring(video.getFile_url().lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1, video.getFile_url().indexOf("-")));
                videosDownload.setThumbnail_url("https://cdn.jwplayer.com/v2/media/" + video.getFile_url().substring(video.getFile_url().lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1, video.getFile_url().indexOf("-")) + "/poster.jpg?width=720");
            }
            if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                str = this.singleStudy.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD;
            } else {
                str = SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + this.singleStudy.getData().getCourseDetail().getId();
            }
            videosDownload.setVideo_name(video.getTitle());
            videosDownload.setVideo_history(video.getId() + "_Videos_" + video.getId());
            videosDownload.setVdcId(video.getVdc_id().split("_")[2]);
            videosDownload.setVideo_type(video.getVideo_type());
            videosDownload.setToal_downloadlocale(0L);
            videosDownload.setPercentage(0);
            videosDownload.setOriginalFileLengthString("0");
            videosDownload.setCourse_id(str);
            videosDownload.setLengthInMb("");
            videosDownload.setIs_complete("0");
            videosDownload.setVideo_status("Download Running");
            videosDownload.setUser_id(MakeMyExam.userId);
            videosDownload.setVideoCurrentPosition(0L);
            if (video.getExtra_params() != null) {
                videosDownload.setIs_limited(video.getExtra_params().getIs_limited());
            }
            videosDownload.setMultiplayer(video.getMultiplayer());
            if (video.getRemaining_time() != null) {
                videosDownload.setRemaining_time(video.getRemaining_time());
            } else {
                videosDownload.setRemaining_time("");
            }
            videosDownload.setVideo_length(video.getVideo_length());
            videosDownload.setTile_id(this.tileIdAPI);
        }
        VideosDownload videosDownload2 = videosDownload;
        if (video.getBitrate_urls() == null || video.getBitrate_urls().size() <= 0) {
            return;
        }
        openwatchlist_dailog_resource(this.activity, video.getBitrate_urls(), videosDownload2, position, optionMenuImgView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void download_service_audio(Lists video, int position) {
        String str;
        VideosDownload videosDownload = new VideosDownload();
        if (this.utkashRoom.getvideoDownloadao().isvideo_exit_for_audio(video.getId(), MakeMyExam.userId)) {
            videosDownload = this.utkashRoom.getvideoDownloadao().getvideo_byuserid_for_audio(video.getId(), MakeMyExam.userId);
            videosDownload.setJw_url("https://cdn.jwplayer.com/v2/media/" + video.getFile_url().substring(video.getFile_url().lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1, video.getFile_url().indexOf("-")));
            videosDownload.setVideo_status("Download Running");
            videosDownload.setThumbnail_url("https://cdn.jwplayer.com/v2/media/" + video.getFile_url().substring(video.getFile_url().lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1, video.getFile_url().indexOf("-")) + "/poster.jpg?width=720");
        } else {
            videosDownload.setVideo_id(video.getId());
            if (video.getFile_url().contains("jwplayer") || video.getFile_url().contains("jwplatform")) {
                videosDownload.setJw_url("https://cdn.jwplayer.com/v2/media/" + video.getFile_url().substring(video.getFile_url().lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1, video.getFile_url().indexOf("-")));
                videosDownload.setThumbnail_url("https://cdn.jwplayer.com/v2/media/" + video.getFile_url().substring(video.getFile_url().lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1, video.getFile_url().indexOf("-")) + "/poster.jpg?width=720");
            }
            if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                str = this.singleStudy.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD;
            } else {
                str = SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + this.singleStudy.getData().getCourseDetail().getId();
            }
            videosDownload.setVideo_name(video.getTitle());
            videosDownload.setVideo_history(video.getId() + "_Videos_" + video.getId());
            videosDownload.setVideo_type("15");
            videosDownload.setToal_downloadlocale(0L);
            videosDownload.setPercentage(0);
            videosDownload.setOriginalFileLengthString("0");
            videosDownload.setCourse_id(str);
            videosDownload.setLengthInMb("");
            videosDownload.setIs_complete("0");
            videosDownload.setVideo_status("Download Running");
            videosDownload.setUser_id(MakeMyExam.userId);
            videosDownload.setVideoCurrentPosition(0L);
            if (video.getExtra_params() != null) {
                videosDownload.setIs_limited(video.getExtra_params().getIs_limited());
            }
            videosDownload.setMultiplayer(video.getMultiplayer());
            if (video.getRemaining_time() != null) {
                videosDownload.setRemaining_time(video.getRemaining_time());
            } else {
                videosDownload.setRemaining_time("");
            }
            videosDownload.setVideo_length(video.getVideo_length());
            videosDownload.setTile_id(this.tileIdAPI);
        }
        if (this.utkashRoom.getvideoDownloadao().getuser_for_audio(videosDownload.getVideo_id(), videosDownload.getIs_complete()).getToal_downloadlocale() == null || this.utkashRoom.getvideoDownloadao().getuser_for_audio(videosDownload.getVideo_id(), videosDownload.getIs_complete()).getToal_downloadlocale().longValue() != 0) {
            return;
        }
        this.utkashRoom.getvideoDownloadao().update_pos_for_audio(MakeMyExam.userId, videosDownload.getVideo_id(), this.utkashRoom.getvideoDownloadao().getalldownload_videos_for_audio(MakeMyExam.userId).size() - 1);
        Intent intent = new Intent(this.activity, (Class<?>) VideoDownloadService.class);
        intent.putExtra(VideoDownloadService.FILEDOWNLOADSTATUS, false);
        intent.putExtra(VideoDownloadService.URL, video.getFile_url());
        intent.putExtra(VideoDownloadService.DOWNLOAD_SERVICE_ID, videosDownload.getVideo_id());
        intent.putExtra(VideoDownloadService.FILEPATH, videosDownload.getVideo_name());
        intent.putExtra("name", videosDownload.getVideo_history());
        intent.putExtra(Constants.INAPP_POSITION, this.utkashRoom.getvideoDownloadao().getalldownload_videos_for_audio(MakeMyExam.userId).size() - 1);
        intent.putExtra("status", videosDownload.getVideo_status());
        intent.putExtra("downloadType", "1");
        VideoDownloadService.isServiceRunning = true;
        Helper.startVideoDownloadService(this.activity, intent);
        pushEventForDownload(videosDownload);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadYoutubeVideo(final Lists video, int position, final ImageView optionMenuImgView) {
        optionMenuImgView.setEnabled(true);
        new DownloadYoutubeBottomSheet(this.videoArrayList.get(position - 1), new Function1() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$downloadYoutubeVideo$3(video, optionMenuImgView, (YoutubeVideoData) obj);
            }
        }).show(((AppCompatActivity) this.activity).getSupportFragmentManager(), "DownloadYoutubeBottomSheet");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$downloadYoutubeVideo$3(Lists lists, ImageView imageView, YoutubeVideoData youtubeVideoData) {
        downloadServiceLibMediaYoutube(lists, "https://www.youtube.com/watch?v=" + lists.getFile_url(), youtubeVideoData);
        imageView.setEnabled(false);
        return null;
    }

    public void downloadServiceLibMediaYoutube(Lists video, String downloadUrl, YoutubeVideoData videoFormat) {
        String str;
        if (TextUtils.isEmpty(video.getFile_url())) {
            Activity activity = this.activity;
            Helper.showToast(activity, activity.getString(R.string.no_video_found), 1);
            return;
        }
        VideosDownload videosDownload = new VideosDownload();
        if (this.utkashRoom.getvideoDownloadao().isvideo_exit_for_youtube(video.getId(), MakeMyExam.userId)) {
            videosDownload = this.utkashRoom.getvideoDownloadao().getvideo_byuserid_for_youtube(video.getId(), MakeMyExam.userId);
            videosDownload.setVideo_status("Download Running");
            videosDownload.setThumbnail_url(video.getThumbnail_url());
        } else {
            videosDownload.setVideo_id(video.getId());
            videosDownload.setThumbnail_url(video.getThumbnail_url());
            if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                str = this.singleStudy.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD;
            } else {
                str = SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + this.singleStudy.getData().getCourseDetail().getId();
            }
            videosDownload.setVideo_name(video.getTitle());
            videosDownload.setVideo_history(video.getId() + "_Videos_" + video.getId());
            videosDownload.setVideo_type("1");
            videosDownload.setToal_downloadlocale(0L);
            videosDownload.setPercentage(0);
            videosDownload.setOriginalFileLengthString("0");
            videosDownload.setCourse_id(str);
            videosDownload.setLengthInMb("");
            videosDownload.setIs_complete("0");
            videosDownload.setVideo_status("Download Running");
            videosDownload.setUser_id(MakeMyExam.userId);
            videosDownload.setVideoCurrentPosition(0L);
            if (video.getExtra_params() != null) {
                videosDownload.setIs_limited(video.getExtra_params().getIs_limited());
            }
            videosDownload.setMultiplayer(video.getMultiplayer());
            if (video.getRemaining_time() != null) {
                videosDownload.setRemaining_time(video.getRemaining_time());
            } else {
                videosDownload.setRemaining_time("");
            }
            videosDownload.setVideo_length(video.getVideo_length());
            videosDownload.setTile_id(this.tileIdAPI);
        }
        if (this.utkashRoom.getvideoDownloadao().isvideo_exit_for_youtube(videosDownload.getVideo_id(), MakeMyExam.userId)) {
            this.utkashRoom.getvideoDownloadao().update_videostatus_for_youtube(videosDownload.getVideo_id(), videosDownload.getVideo_status(), MakeMyExam.userId);
        } else {
            this.utkashRoom.getvideoDownloadao().addUser(videosDownload);
        }
        if (this.utkashRoom.getvideoDownloadao().getuser_for_youtube(videosDownload.getVideo_id(), videosDownload.getIs_complete()).getToal_downloadlocale() != null && this.utkashRoom.getvideoDownloadao().getuser_for_youtube(videosDownload.getVideo_id(), videosDownload.getIs_complete()).getToal_downloadlocale().longValue() == 0) {
            this.utkashRoom.getvideoDownloadao().update_pos_for_youtube(MakeMyExam.userId, videosDownload.getVideo_id(), this.utkashRoom.getvideoDownloadao().getalldownload_videos_for_youtube(MakeMyExam.userId).size() - 1);
            Intent intent = new Intent(this.activity, (Class<?>) VideoDownloadService.class);
            intent.putExtra(VideoDownloadService.FILEDOWNLOADSTATUS, false);
            intent.putExtra(VideoDownloadService.URL, videoFormat.getUrl());
            intent.putExtra(VideoDownloadService.DOWNLOAD_SERVICE_ID, videosDownload.getVideo_id());
            intent.putExtra(VideoDownloadService.FILEPATH, videosDownload.getVideo_name());
            intent.putExtra("name", videosDownload.getVideo_history());
            intent.putExtra(Constants.INAPP_POSITION, this.utkashRoom.getvideoDownloadao().getalldownload_videos_for_youtube(MakeMyExam.userId).size() - 1);
            intent.putExtra("status", videosDownload.getVideo_status());
            intent.putExtra("downloadType", "2");
            VideoDownloadService.isServiceRunning = true;
            Helper.startVideoDownloadService(this.activity, intent);
            pushEventForDownload(videosDownload);
        }
        notifyDataSetChanged();
    }

    public void openwatchlist_dailog_resource(Context context, final ArrayList<UrlObject> mediaResponseMap, final VideosDownload videosDownload, final int pos, final ImageView myButton) {
        try {
            final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.videosheetDialogTheme);
            bottomSheetDialog.setContentView(R.layout.quality_download_view);
            ((Window) Objects.requireNonNull(bottomSheetDialog.getWindow())).getAttributes().windowAnimations = R.style.PauseDialogAnimation;
            bottomSheetDialog.setCancelable(false);
            bottomSheetDialog.setCanceledOnTouchOutside(true);
            LinearLayout linearLayout = (LinearLayout) bottomSheetDialog.findViewById(R.id.lnPreparing);
            TextView textView = (TextView) bottomSheetDialog.findViewById(R.id.btnLow);
            TextView textView2 = (TextView) bottomSheetDialog.findViewById(R.id.tvResName);
            TextView textView3 = (TextView) bottomSheetDialog.findViewById(R.id.btnMedium);
            TextView textView4 = (TextView) bottomSheetDialog.findViewById(R.id.btnHigh);
            RecyclerView recyclerView = (RecyclerView) bottomSheetDialog.findViewById(R.id.bitrate_recyclerView);
            textView2.setText(videosDownload.getVideo_name());
            setUiRecycler(mediaResponseMap, recyclerView, videosDownload, myButton, bottomSheetDialog, this.examPrepItem, pos);
            ((LinearLayout) Objects.requireNonNull(linearLayout)).setVisibility(8);
            ((TextView) Objects.requireNonNull(textView)).setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$openwatchlist_dailog_resource$4(pos, videosDownload, mediaResponseMap, myButton, bottomSheetDialog);
                }
            }));
            ((TextView) Objects.requireNonNull(textView3)).setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$openwatchlist_dailog_resource$5(pos, videosDownload, mediaResponseMap, myButton, bottomSheetDialog);
                }
            }));
            ((TextView) Objects.requireNonNull(textView4)).setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$openwatchlist_dailog_resource$6(pos, videosDownload, mediaResponseMap, myButton, bottomSheetDialog);
                }
            }));
            if (bottomSheetDialog.isShowing()) {
                return;
            }
            bottomSheetDialog.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$4(int i, VideosDownload videosDownload, ArrayList arrayList, ImageView imageView, BottomSheetDialog bottomSheetDialog) {
        if (this.utkashRoom.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread() || !Helper.isNetworkConnected(this.activity)) {
            return null;
        }
        this.examPrepItem.getList().get(i - 1).setVideo_status("Download Running");
        if (this.utkashRoom.getvideoDownloadao().isvideo_exit(videosDownload.getVideo_id(), MakeMyExam.userId)) {
            this.utkashRoom.getvideoDownloadao().update_videostatus(videosDownload.getVideo_id(), videosDownload.getVideo_status(), MakeMyExam.userId);
        } else {
            this.utkashRoom.getvideoDownloadao().addUser(videosDownload);
        }
        notifyItemChanged(i);
        Download_dialog(((UrlObject) arrayList.get(0)).getUrl(), videosDownload, imageView);
        dismissCalculatorDialog(bottomSheetDialog);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$5(int i, VideosDownload videosDownload, ArrayList arrayList, ImageView imageView, BottomSheetDialog bottomSheetDialog) {
        if (this.utkashRoom.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread() || !Helper.isNetworkConnected(this.activity)) {
            return null;
        }
        this.examPrepItem.getList().get(i - 1).setVideo_status("Download Running");
        if (this.utkashRoom.getvideoDownloadao().isvideo_exit(videosDownload.getVideo_id(), MakeMyExam.userId)) {
            this.utkashRoom.getvideoDownloadao().update_videostatus(videosDownload.getVideo_id(), videosDownload.getVideo_status(), MakeMyExam.userId);
        } else {
            this.utkashRoom.getvideoDownloadao().addUser(videosDownload);
        }
        notifyItemChanged(i);
        Download_dialog(((UrlObject) arrayList.get(1)).getUrl(), videosDownload, imageView);
        dismissCalculatorDialog(bottomSheetDialog);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$6(int i, VideosDownload videosDownload, ArrayList arrayList, ImageView imageView, BottomSheetDialog bottomSheetDialog) {
        if (this.utkashRoom.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread() || !Helper.isNetworkConnected(this.activity)) {
            return null;
        }
        this.examPrepItem.getList().get(i - 1).setVideo_status("Download Running");
        if (this.utkashRoom.getvideoDownloadao().isvideo_exit(videosDownload.getVideo_id(), MakeMyExam.userId)) {
            this.utkashRoom.getvideoDownloadao().update_videostatus(videosDownload.getVideo_id(), videosDownload.getVideo_status(), MakeMyExam.userId);
        } else {
            this.utkashRoom.getvideoDownloadao().addUser(videosDownload);
        }
        notifyItemChanged(i);
        Download_dialog(((UrlObject) arrayList.get(2)).getUrl(), videosDownload, imageView);
        dismissCalculatorDialog(bottomSheetDialog);
        return null;
    }

    private void setUiRecycler(ArrayList<UrlObject> mediaResponseMap, RecyclerView bitrate_recyclerView, VideosDownload videosDownload, ImageView myButton, BottomSheetDialog bottomSheetDialog, ExamPrepItem examPrepItem, int selectedVideoPosition) {
        BitrateAdapter bitrateAdapter = new BitrateAdapter(this.activity, mediaResponseMap, videosDownload, myButton, bottomSheetDialog, examPrepItem, selectedVideoPosition);
        bitrate_recyclerView.setLayoutManager(new LinearLayoutManager(this.activity));
        bitrate_recyclerView.setAdapter(bitrateAdapter);
        bitrate_recyclerView.setNestedScrollingEnabled(false);
        bitrate_recyclerView.scrollToPosition(this.tilePos);
    }

    public class BitrateAdapter extends RecyclerView.Adapter<MyViewHolder> {
        private BottomSheetDialog bottomSheetDialog;
        private Context context;
        private ExamPrepItem examPrepItem;
        private ArrayList<UrlObject> mediaResponseMap;
        private ImageView myButton;
        private int pos;
        private VideosDownload videosDownload;

        public BitrateAdapter(Context context, ArrayList<UrlObject> mediaResponseMap, VideosDownload videosDownload, ImageView myButton, BottomSheetDialog bottomSheetDialog, ExamPrepItem examPrepItem, int selectedVideoPosition) {
            this.mediaResponseMap = mediaResponseMap;
            this.context = context;
            this.videosDownload = videosDownload;
            this.myButton = myButton;
            this.bottomSheetDialog = bottomSheetDialog;
            this.examPrepItem = examPrepItem;
            this.pos = selectedVideoPosition;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            final UrlObject urlObject = this.mediaResponseMap.get(position);
            holder.bitrateButton.setText(urlObject.getTitle());
            holder.bitrateButton.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter.BitrateAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (Helper.isNetworkConnected(SingleStudyAdapter.this.activity)) {
                        BitrateAdapter.this.examPrepItem.getList().get(BitrateAdapter.this.pos - 1).setVideo_status("Download Running");
                        if (SingleStudyAdapter.this.utkashRoom.getvideoDownloadao().isvideo_exit(BitrateAdapter.this.videosDownload.getVideo_id(), MakeMyExam.userId)) {
                            SingleStudyAdapter.this.utkashRoom.getvideoDownloadao().update_videostatus(BitrateAdapter.this.videosDownload.getVideo_id(), BitrateAdapter.this.videosDownload.getVideo_status(), MakeMyExam.userId);
                        } else {
                            SingleStudyAdapter.this.utkashRoom.getvideoDownloadao().addUser(BitrateAdapter.this.videosDownload);
                        }
                        BitrateAdapter.this.notifyItemChanged(position);
                        SingleStudyAdapter.this.Download_dialog(urlObject.getUrl(), BitrateAdapter.this.videosDownload, BitrateAdapter.this.myButton);
                        SingleStudyAdapter.this.dismissCalculatorDialog(BitrateAdapter.this.bottomSheetDialog);
                    }
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.new_item_shap, parent, false));
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public Button bitrateButton;

            public MyViewHolder(View view) {
                super(view);
                this.bitrateButton = (Button) view.findViewById(R.id.bitrateButton);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.mediaResponseMap.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Download_dialog(String url, final VideosDownload videosDownload, final ImageView myButton) {
        if (this.utkashRoom.getvideoDownloadao().getuser(videosDownload.getVideo_id(), videosDownload.getIs_complete()).getToal_downloadlocale() == null || this.utkashRoom.getvideoDownloadao().getuser(videosDownload.getVideo_id(), videosDownload.getIs_complete()).getToal_downloadlocale().longValue() != 0) {
            return;
        }
        this.utkashRoom.getvideoDownloadao().update_pos(MakeMyExam.userId, videosDownload.getVideo_id(), this.utkashRoom.getvideoDownloadao().getalldownload_videos(MakeMyExam.userId).size() - 1);
        Intent intent = new Intent(this.activity, (Class<?>) VideoDownloadService.class);
        intent.putExtra(VideoDownloadService.FILEDOWNLOADSTATUS, false);
        intent.putExtra(VideoDownloadService.URL, url);
        intent.putExtra(VideoDownloadService.DOWNLOAD_SERVICE_ID, videosDownload.getVideo_id());
        intent.putExtra(VideoDownloadService.FILEPATH, videosDownload.getVideo_name());
        intent.putExtra("name", videosDownload.getVideo_history());
        intent.putExtra(Constants.INAPP_POSITION, this.utkashRoom.getvideoDownloadao().getalldownload_videos(MakeMyExam.userId).size() - 1);
        intent.putExtra("status", videosDownload.getVideo_status());
        VideoDownloadService.isServiceRunning = true;
        Helper.startVideoDownloadService(this.activity, intent);
        pushEventForDownload(videosDownload);
        this.activity.runOnUiThread(new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$Download_dialog$7(videosDownload, myButton);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$Download_dialog$7(VideosDownload videosDownload, ImageView imageView) {
        waiting_dialog(videosDownload.getVideo_name(), imageView);
    }

    private void waiting_dialog(String video_name, final ImageView myButton) {
        final Dialog dialog = new Dialog(this.activity);
        dialog.setCancelable(false);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
        dialog.setContentView(R.layout.dialog_alert_downloads);
        ((TextView) dialog.findViewById(R.id.titleDialog)).setText("Video");
        ((TextView) dialog.findViewById(R.id.msgDialog)).setText(video_name);
        Button button = (Button) dialog.findViewById(R.id.btn_cancel);
        ((Button) dialog.findViewById(R.id.btn_submit)).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$waiting_dialog$8(dialog, myButton, view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SingleStudyAdapter.lambda$waiting_dialog$9(dialog, myButton, view);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$waiting_dialog$8(Dialog dialog, ImageView imageView, View view) {
        Helper.gotoActivity(new Intent(this.activity, (Class<?>) DownloadActivity.class), this.activity);
        this.activity.finish();
        dialog.dismiss();
        dialog.cancel();
        imageView.setVisibility(8);
    }

    static /* synthetic */ void lambda$waiting_dialog$9(Dialog dialog, ImageView imageView, View view) {
        dialog.dismiss();
        dialog.cancel();
        imageView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissCalculatorDialog(BottomSheetDialog watchlist) {
        if (watchlist == null || !watchlist.isShowing()) {
            return;
        }
        watchlist.dismiss();
        watchlist.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void API_REQUEST_VIDEO_LINK(final Lists videoData, int position) {
        if (videoData.getFile_type().equalsIgnoreCase("10")) {
            this.activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + videoData.getFile_url())));
            return;
        }
        if (videoData.getVideo_type().equalsIgnoreCase("5")) {
            if (videoData.getLive_status().equalsIgnoreCase("1")) {
                if (videoData.getId() == null || videoData.getId().equalsIgnoreCase("")) {
                    Activity activity = this.activity;
                    Toast.makeText(activity, activity.getResources().getString(R.string.url_is_not_found), 0).show();
                    return;
                } else {
                    Helper.GoToLiveAwsVideoActivity(videoData.getVideo_type(), videoData.getChat_node(), this.activity, videoData.getId(), videoData.getVideo_type(), videoData.getId(), videoData.getTitle(), "0", videoData.getThumbnail_url(), videoData.getPayload().getCourse_id(), videoData.getPayload().getTile_id(), videoData.getPayload().getTile_type(), videoData.getIs_chat_lock(), String.valueOf(position), SingleStudy.parentCourseId, this.examPrepItem.getList().get(position).getStart_date(), this.videoArrayList);
                    return;
                }
            }
            if (videoData.getLive_status().equalsIgnoreCase("0")) {
                Toast.makeText(this.activity, this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(videoData.getStart_date()) * 1000)), 0).show();
                return;
            }
            if (videoData.getLive_status().equalsIgnoreCase("2")) {
                Activity activity2 = this.activity;
                Toast.makeText(activity2, activity2.getResources().getString(R.string.live_class_is_ended), 0).show();
                return;
            } else {
                if (videoData.getLive_status().equalsIgnoreCase("3")) {
                    Activity activity3 = this.activity;
                    Toast.makeText(activity3, activity3.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                    return;
                }
                return;
            }
        }
        if (videoData.getVideo_type().equalsIgnoreCase("0")) {
            Helper.GoToLiveAwsVideoActivity(videoData.getVideo_type(), videoData.getChat_node(), this.activity, videoData.getId(), videoData.getVideo_type(), videoData.getId(), videoData.getTitle(), "0", videoData.getThumbnail_url(), videoData.getPayload().getCourse_id(), videoData.getPayload().getTile_id(), videoData.getPayload().getTile_type(), videoData.getIs_chat_lock(), String.valueOf(position), SingleStudy.parentCourseId, this.examPrepItem.getList().get(position).getStart_date(), this.videoArrayList);
            return;
        }
        if (videoData.getVideo_type().equalsIgnoreCase("6")) {
            try {
                String str = "https://cdn.jwplayer.com/v2/media/" + videoData.getFile_url().substring(videoData.getFile_url().lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1, videoData.getFile_url().indexOf("-"));
                if (this.utkashRoom.getvideoDownloadao().isvideo_exit(videoData.getId(), MakeMyExam.userId)) {
                    VideosDownload videosDownload = this.utkashRoom.getvideoDownloadao().getvideo_byuserid(videoData.getId(), MakeMyExam.userId);
                    if (videosDownload.getIs_complete().equalsIgnoreCase("1")) {
                        Intent intent = new Intent(this.activity, (Class<?>) DownloadVideoPlayer.class);
                        intent.putExtra("video_name", videosDownload.getVideo_name());
                        intent.putExtra(Const.VIDEO_ID, videosDownload.getVideo_id());
                        intent.putExtra("current_pos", videosDownload.getVideoCurrentPosition());
                        intent.putExtra("video", videosDownload.getVideo_history());
                        intent.putExtra("video_time", videosDownload.getVideotime());
                        intent.putExtra("course_id", videosDownload.getCourse_id());
                        this.activity.startActivity(intent);
                        return;
                    }
                    if (this.utkashRoom.getvideoDao().isvideo_exit(videoData.getId(), MakeMyExam.userId)) {
                        if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                            Helper.GoToJWVideo_Params(this.activity, str, videoData.getId(), videoData.getTitle(), this.utkashRoom.getvideoDao().getuser(videoData.getId(), MakeMyExam.userId).getVideo_currentpos(), this.singleStudy.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD);
                            return;
                        } else {
                            Helper.GoToJWVideo_Params(this.activity, str, videoData.getId(), videoData.getTitle(), this.utkashRoom.getvideoDao().getuser(videoData.getId(), MakeMyExam.userId).getVideo_currentpos(), SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + this.singleStudy.getData().getCourseDetail().getId());
                            return;
                        }
                    }
                    VideoTable videoTable = new VideoTable();
                    videoTable.setVideo_id(videoData.getId());
                    videoTable.setVideo_name(videoData.getTitle());
                    videoTable.setJw_url(str);
                    videoTable.setVideo_currentpos(0L);
                    videoTable.setUser_id(MakeMyExam.userId);
                    videoTable.setCourse_id(SingleStudy.parentCourseId.equalsIgnoreCase("") ? this.singleStudy.getData().getCourseDetail().getId() : SingleStudy.parentCourseId);
                    this.utkashRoom.getvideoDao().addUser(videoTable);
                    Helper.GoToJWVideo_Params(this.activity, str, videoData.getId(), videoData.getTitle(), 0L, (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(this.singleStudy.getData().getCourseDetail().getId())).toString());
                    return;
                }
                if (this.utkashRoom.getvideoDao().isvideo_exit(videoData.getId(), MakeMyExam.userId)) {
                    Helper.GoToJWVideo_Params(this.activity, str, videoData.getId(), videoData.getTitle(), this.utkashRoom.getvideoDao().getuser(videoData.getId(), MakeMyExam.userId).getVideo_currentpos(), (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(this.singleStudy.getData().getCourseDetail().getId())).toString());
                    return;
                }
                VideoTable videoTable2 = new VideoTable();
                videoTable2.setVideo_id(videoData.getId());
                videoTable2.setVideo_name(videoData.getTitle());
                videoTable2.setJw_url(str);
                videoTable2.setVideo_currentpos(0L);
                videoTable2.setUser_id(MakeMyExam.userId);
                videoTable2.setCourse_id((SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(this.singleStudy.getData().getCourseDetail().getId())).toString());
                this.utkashRoom.getvideoDao().addUser(videoTable2);
                Helper.GoToJWVideo_Params(this.activity, str, videoData.getId(), videoData.getTitle(), 0L, (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(this.singleStudy.getData().getCourseDetail().getId())).toString());
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (videoData.getVideo_type().equalsIgnoreCase("1")) {
            Helper.audio_service_close((CourseActivity) this.activity);
            if (videoData.getOpen_in_app() != null && videoData.getOpen_in_app().equalsIgnoreCase("1")) {
                if (SharedPreference.getInstance().getString(Const.Youtube_Player_Control).equalsIgnoreCase("2") || SharedPreference.getInstance().getString(Const.Youtube_Player_Control).equalsIgnoreCase("3")) {
                    Helper.showStreamSelectionBottomSheet(this.activity, videoData, position, this.videoArrayList);
                    return;
                } else {
                    Helper.GoToLiveVideoActivity(videoData.getChat_node(), this.activity, videoData.getFile_url(), videoData.getVideo_type(), videoData.getId(), videoData.getTitle(), "0", videoData.getThumbnail_url(), videoData.getIs_chat_lock(), videoData.getPayload().getCourse_id(), String.valueOf(position), SingleStudy.parentCourseId, videoData.getPayload().getTile_id(), videoData.getPayload().getTile_type(), videoData.getIs_live(), this.videoArrayList);
                    return;
                }
            }
            this.activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + videoData.getFile_url())));
            return;
        }
        if (videoData.getVideo_type().equalsIgnoreCase("4")) {
            Helper.audio_service_close((CourseActivity) this.activity);
            if (videoData.getLive_status().equalsIgnoreCase("1")) {
                if (videoData.getFile_url() == null || videoData.getFile_url().equalsIgnoreCase("")) {
                    Activity activity4 = this.activity;
                    Toast.makeText(activity4, activity4.getResources().getString(R.string.url_is_not_found), 0).show();
                    return;
                } else {
                    if (videoData.getOpen_in_app() != null && videoData.getOpen_in_app().equalsIgnoreCase("1")) {
                        if (SharedPreference.getInstance().getString(Const.Youtube_Player_Control).equalsIgnoreCase("2") || SharedPreference.getInstance().getString(Const.Youtube_Player_Control).equalsIgnoreCase("3")) {
                            Helper.showStreamSelectionBottomSheet(this.activity, videoData, position, this.videoArrayList);
                            return;
                        } else {
                            Helper.GoToLiveVideoActivity(videoData.getChat_node(), this.activity, videoData.getFile_url(), videoData.getVideo_type(), videoData.getId(), videoData.getTitle(), "0", videoData.getThumbnail_url(), videoData.getIs_chat_lock(), videoData.getPayload().getCourse_id(), String.valueOf(position), SingleStudy.parentCourseId, videoData.getPayload().getTile_id(), videoData.getPayload().getTile_type(), this.videoArrayList);
                            return;
                        }
                    }
                    this.activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + videoData.getFile_url())));
                    return;
                }
            }
            if (videoData.getLive_status().equalsIgnoreCase("0")) {
                Toast.makeText(this.activity, this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(videoData.getStart_date()) * 1000)), 0).show();
                return;
            }
            if (videoData.getLive_status().equalsIgnoreCase("2")) {
                Activity activity5 = this.activity;
                Toast.makeText(activity5, activity5.getResources().getString(R.string.live_class_is_ended), 0).show();
                return;
            } else {
                if (videoData.getLive_status().equalsIgnoreCase("3")) {
                    Activity activity6 = this.activity;
                    Toast.makeText(activity6, activity6.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                    return;
                }
                return;
            }
        }
        if (videoData.getVideo_type().equalsIgnoreCase("7")) {
            if (videoData.getIs_drm().equals("0")) {
                if (videoData.getId() == null || videoData.getId().equalsIgnoreCase("")) {
                    Activity activity7 = this.activity;
                    Toast.makeText(activity7, activity7.getResources().getString(R.string.url_is_not_found), 0).show();
                    return;
                } else {
                    Helper.GoToLiveAwsVideoActivity1(videoData.getVideo_type(), videoData.getChat_node(), this.activity, videoData.getFile_url(), videoData.getVideo_type(), videoData.getId(), videoData.getTitle(), "0", videoData.getThumbnail_url(), videoData.getPayload().getCourse_id(), videoData.getPayload().getTile_id(), videoData.getPayload().getTile_type(), videoData.getIs_chat_lock(), String.valueOf(position), SingleStudy.parentCourseId, "", this.videoArrayList);
                    return;
                }
            }
            if (videoData.getIs_drm().equals("1")) {
                if (videoData.getId() == null || videoData.getId().equalsIgnoreCase("")) {
                    Activity activity8 = this.activity;
                    Toast.makeText(activity8, activity8.getResources().getString(R.string.url_is_not_found), 0).show();
                    return;
                } else {
                    Helper.GoToVideoCryptActivity(this.activity, videoData.getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), videoData.getVideo_type(), videoData.getChat_node(), videoData.getId(), videoData.getVideo_type(), videoData.getId(), videoData.getTitle(), "0", videoData.getThumbnail_url(), videoData.getPayload().getCourse_id(), videoData.getPayload().getTile_id(), videoData.getPayload().getTile_type(), videoData.getIs_chat_lock(), String.valueOf(position), SingleStudy.parentCourseId, videoData.getStart_date(), "0", this.videoArrayList);
                    return;
                }
            }
            return;
        }
        if (videoData.getVideo_type().equalsIgnoreCase("8")) {
            if (videoData.getIs_drm().equals("0")) {
                if (videoData.getLive_status().equalsIgnoreCase("1")) {
                    if (videoData.getId() == null || videoData.getId().equalsIgnoreCase("")) {
                        Activity activity9 = this.activity;
                        Toast.makeText(activity9, activity9.getResources().getString(R.string.url_is_not_found), 0).show();
                        return;
                    } else {
                        Helper.GoToLiveAwsVideoActivity(videoData.getVideo_type(), videoData.getChat_node(), this.activity, videoData.getId(), videoData.getVideo_type(), videoData.getId(), videoData.getTitle(), "0", videoData.getThumbnail_url(), videoData.getPayload().getCourse_id(), videoData.getPayload().getTile_id(), videoData.getPayload().getTile_type(), videoData.getIs_chat_lock(), String.valueOf(position), SingleStudy.parentCourseId, videoData.getStart_date(), this.videoArrayList);
                        return;
                    }
                }
                if (videoData.getLive_status().equalsIgnoreCase("0")) {
                    Toast.makeText(this.activity, this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(videoData.getStart_date()) * 1000)), 0).show();
                    return;
                }
                if (videoData.getLive_status().equalsIgnoreCase("2")) {
                    Activity activity10 = this.activity;
                    Toast.makeText(activity10, activity10.getResources().getString(R.string.live_class_is_ended), 0).show();
                    return;
                } else {
                    if (videoData.getLive_status().equalsIgnoreCase("3")) {
                        Activity activity11 = this.activity;
                        Toast.makeText(activity11, activity11.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                        return;
                    }
                    return;
                }
            }
            if (videoData.getIs_drm().equals("1")) {
                if (videoData.getLive_status().equalsIgnoreCase("1")) {
                    if (videoData.getId() == null || videoData.getId().equalsIgnoreCase("")) {
                        Activity activity12 = this.activity;
                        Toast.makeText(activity12, activity12.getResources().getString(R.string.url_is_not_found), 0).show();
                        return;
                    } else {
                        Helper.GoToVideoCryptActivity(this.activity, videoData.getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), videoData.getVideo_type(), videoData.getChat_node(), videoData.getId(), videoData.getVideo_type(), videoData.getId(), videoData.getTitle(), "0", videoData.getThumbnail_url(), videoData.getPayload().getCourse_id(), videoData.getPayload().getTile_id(), videoData.getPayload().getTile_type(), videoData.getIs_chat_lock(), String.valueOf(position), SingleStudy.parentCourseId, videoData.getStart_date(), "0", this.videoArrayList);
                        return;
                    }
                }
                if (videoData.getLive_status().equalsIgnoreCase("0")) {
                    Toast.makeText(this.activity, this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(videoData.getStart_date()) * 1000)), 0).show();
                    return;
                }
                if (videoData.getLive_status().equalsIgnoreCase("2")) {
                    Activity activity13 = this.activity;
                    Toast.makeText(activity13, activity13.getResources().getString(R.string.live_class_is_ended), 0).show();
                } else if (videoData.getLive_status().equalsIgnoreCase("3")) {
                    Activity activity14 = this.activity;
                    Toast.makeText(activity14, activity14.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleVisibilityNoData(CardView ibt_single_sub_vd_RL, RelativeLayout no_data_found_RL, Button backBtn) {
        ibt_single_sub_vd_RL.setVisibility(8);
        no_data_found_RL.setVisibility(0);
        backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleVisibilityNoData$10(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleVisibilityNoData$10(View view) {
        this.activity.finish();
    }

    public void sendlist(ArrayList<Courselist> courseDataArrayList) {
        this.courseDataArrayList = courseDataArrayList;
        notifyDataSetChanged();
    }

    private void pushEventForDownload(VideosDownload videosDownload) {
        String id = !TextUtils.isEmpty(SingleStudy.parentCourseId) ? SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + this.singleStudy.getData().getCourseDetail().getId() : this.singleStudy.getData().getCourseDetail().getId();
        HashMap<String, Object> map = new HashMap<>();
        map.put("date", AnalyticHelper.INSTANCE.getCurrentDateTimeForEvent());
        map.put("user_id", AnalyticHelper.INSTANCE.getUserId());
        map.put("content_id", videosDownload.getVideo_id());
        map.put(AnalyticsConstants.content_name, videosDownload.getVideo_name());
        map.put("content_type", ShareConstants.VIDEO_URL);
        map.put("course_id", id);
        AnalyticEvents.INSTANCE.pushEvents(this.activity, AnalyticsConstants.CONTENT_DOWNLOAD, map);
    }

    private boolean hasValidStocks(CourseDetail singleStudy) {
        return (singleStudy == null || singleStudy.getData() == null || singleStudy.getData().getCourseDetail() == null || TextUtils.isEmpty(singleStudy.getData().getCourseDetail().getStocks()) || singleStudy.getData().getCourseDetail().getStocks().equals("0")) ? false : true;
    }
}
