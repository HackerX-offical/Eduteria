package com.appnew.android.Courses.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
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
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.BuildConfig;
import com.appnew.android.Courses.Activity.Concept_newActivity;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.Courses.Activity.PdfDetailScreen;
import com.appnew.android.Courses.Activity.PdfListActivity;
import com.appnew.android.Courses.Activity.QuizActivity;
import com.appnew.android.Courses.Fragment.SingleStudy;
import com.appnew.android.Download.Audio.AudioPlayerService;
import com.appnew.android.Download.DownloadActivity;
import com.appnew.android.Download.DownloadVideoPlayer;
import com.appnew.android.DownloadServices.VideoDownloadService;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.BottomSetting;
import com.appnew.android.Model.COURSEDETAIL.CourseDetail;
import com.appnew.android.Model.Courses.ExamPrepItem;
import com.appnew.android.Model.LeftMenu;
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
import com.appnew.android.Utils.AppPermissionsRunTime;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.Progress;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.StoreProvider;
import com.appnew.android.Utils.ZoomFeatureHelper;
import com.appnew.android.Webview.RevisionActivity;
import com.appnew.android.Webview.WebViewActivty;
import com.appnew.android.Zoom.Activity.ZoomRecodedPlayer;
import com.appnew.android.Zoom.ItemClickListener;
import com.appnew.android.base.bottom_sheets.DownloadYoutubeBottomSheet;
import com.appnew.android.base.dialogs.PopUpAlertsKt;
import com.appnew.android.cleverTap.AnalyticHelper;
import com.appnew.android.encVideoPlayer.PlayerActivity;
import com.appnew.android.folder.activity.FolderActivity;
import com.appnew.android.home.Constants;
import com.appnew.android.player.AudioPlayerActivity;
import com.appnew.android.player.music_player.MusicService;
import com.appnew.android.pojo.Userinfo.Data;
import com.appnew.android.socket.models.ChatModel;
import com.appnew.android.table.ThemeSettings;
import com.appnew.android.table.VideoTable;
import com.appnew.android.table.VideosDownload;
import com.appnew.android.testmodule.activity.ViewSolutionActivity;
import com.appnew.android.testmodule.model.InstructionData;
import com.appnew.android.testmodule.model.ResultTestSeries_Report;
import com.appnew.android.testmodule.model.TestBasicInst;
import com.appnew.android.testmodule.model.TestSectionInst;
import com.bumptech.glide.Glide;
import com.eduteria.app.app.R;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.tv9news.utils.helpers.AnalyticEvents;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
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
public class ExamPrepLayer3Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements NetworkCall.MyNetworkCallBack {
    Activity activity;
    private String attemptOrReAttempt;
    BottomSetting bottomSetting;
    ArrayList<ChatModel> chatModel;
    CheckBox checkMark_read_mark;
    String contentType;
    private String first_attempt;
    private String folderContentType;
    private String folder_id;
    private boolean isSSCpattern;
    private String is_purchase;
    int lang;
    String[] langIds;
    LeftMenu leftMenu;
    LinearLayout llEnableMarkAsRead_read_mark;
    long mLastClickTime;
    public ArrayList<AppPermissionsRunTime.MyPermissionConstants> myPermissionConstantsArrayList;
    int position_delete;
    private Progress progress;
    private String quiz_id;
    private String quiz_name;
    private String result_date;
    String revertAPI;
    Data signUpResponse;
    CourseDetail singleStudy;
    private String test_submission;
    ThemeSettings themeSettings;
    String tileIdAPI;
    String tileTypeAPI;
    private String tile_id;
    Long time;
    TimeTableModel timeTableModel;
    private String totalQuestion;
    TextView tvMark_read_mark;
    public UtkashRoom utkashRoom;
    ArrayList<Video> videoArrayList;
    ArrayList<Video> videoArrayListAuto;
    private Video videodata;
    private Video videopositonwise;
    int downloadCount = 0;
    boolean isReAttemptOrPractice = false;
    int testPosition = 0;
    String TAG = "ExamPrepLayer3Adapter";
    public final int REQUEST_CODE_PERMISSION_MULTIPLE = 123;
    private int STORAGE_PERMISSION_TYPE = 3;
    public final int REQUEST_CODE_MULTIPLE_PIKER = 1203;
    private int multiplePermissionCounter = 0;
    private int PERMISSION_TYPE = 0;
    int selectedMarkReadPosition = -1;

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    public ExamPrepLayer3Adapter(Activity activity, CourseDetail singleStudy, ArrayList<Video> videoArrayList, String tileIdAPI, String tileTypeAPI, String revertAPI, String tile_id, String is_purchase) {
        this.videoArrayListAuto = new ArrayList<>();
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        this.utkashRoom = appDatabase;
        this.tile_id = "";
        this.is_purchase = "";
        this.result_date = "";
        this.test_submission = "";
        this.themeSettings = appDatabase.getthemeSettingdao().data();
        this.mLastClickTime = 0L;
        this.isSSCpattern = false;
        this.langIds = new String[]{"1"};
        this.activity = activity;
        this.singleStudy = singleStudy;
        this.videoArrayList = videoArrayList;
        this.signUpResponse = SharedPreference.getInstance().getLoggedInUser();
        this.time = Long.valueOf(System.currentTimeMillis());
        this.tileTypeAPI = tileTypeAPI;
        this.tileIdAPI = tileIdAPI;
        this.revertAPI = revertAPI;
        this.tile_id = tile_id;
        this.is_purchase = is_purchase;
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            this.progress = new Progress(activity);
        }
        ArrayList<Video> arrayList = new ArrayList<>();
        if (Constants.IS_FROM_LIBRARY && singleStudy != null && singleStudy.getData() != null && singleStudy.getData().getCourseDetail().getIsPurchased().equalsIgnoreCase("1") && singleStudy.getData().getCourseDetail().getCat_type().equalsIgnoreCase("3")) {
            for (Video video : videoArrayList) {
                if (video.getIs_test_purchased() != null && video.getIs_test_purchased().equalsIgnoreCase("1")) {
                    arrayList.add(video);
                }
            }
            this.videoArrayList = arrayList;
        }
        ThemeSettings themeSettingsData = this.utkashRoom.getthemeSettingdao().data();
        this.themeSettings = themeSettingsData;
        if (themeSettingsData != null) {
            this.themeSettings = this.utkashRoom.getthemeSettingdao().data();
            this.leftMenu = (LeftMenu) new Gson().fromJson(this.themeSettings.getLeft_menu(), LeftMenu.class);
            this.bottomSetting = (BottomSetting) new Gson().fromJson(this.themeSettings.getBottom(), BottomSetting.class);
        }
        this.videoArrayListAuto = videoArrayList;
    }

    public ExamPrepLayer3Adapter(TimeTableModel timeTableModel, Activity activity, CourseDetail singleStudy, ArrayList<Video> videoArrayList, String tileIdAPI, String tileTypeAPI, String revertAPI, String tile_id, String is_purchase) {
        this.videoArrayListAuto = new ArrayList<>();
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        this.utkashRoom = appDatabase;
        this.tile_id = "";
        this.is_purchase = "";
        this.result_date = "";
        this.test_submission = "";
        this.themeSettings = appDatabase.getthemeSettingdao().data();
        this.mLastClickTime = 0L;
        this.isSSCpattern = false;
        this.langIds = new String[]{"1"};
        this.activity = activity;
        this.singleStudy = singleStudy;
        this.videoArrayList = videoArrayList;
        this.signUpResponse = SharedPreference.getInstance().getLoggedInUser();
        this.time = Long.valueOf(System.currentTimeMillis());
        this.tileTypeAPI = tileTypeAPI;
        this.tileIdAPI = tileIdAPI;
        this.revertAPI = revertAPI;
        this.tile_id = tile_id;
        this.is_purchase = is_purchase;
        this.timeTableModel = timeTableModel;
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            this.progress = new Progress(activity);
        }
        ArrayList<Video> arrayList = new ArrayList<>();
        if (Constants.IS_FROM_LIBRARY && singleStudy != null && singleStudy.getData() != null && singleStudy.getData().getCourseDetail().getIsPurchased().equalsIgnoreCase("1") && singleStudy.getData().getCourseDetail().getCat_type().equalsIgnoreCase("3")) {
            for (Video video : videoArrayList) {
                if (video.getIs_test_purchased() != null && video.getIs_test_purchased().equalsIgnoreCase("1")) {
                    arrayList.add(video);
                }
            }
            this.videoArrayList = arrayList;
        }
        ThemeSettings themeSettingsData = this.utkashRoom.getthemeSettingdao().data();
        this.themeSettings = themeSettingsData;
        if (themeSettingsData != null) {
            this.themeSettings = this.utkashRoom.getthemeSettingdao().data();
            this.leftMenu = (LeftMenu) new Gson().fromJson(this.themeSettings.getLeft_menu(), LeftMenu.class);
            this.bottomSetting = (BottomSetting) new Gson().fromJson(this.themeSettings.getBottom(), BottomSetting.class);
        }
        this.videoArrayListAuto = videoArrayList;
    }

    public ExamPrepLayer3Adapter(ArrayList<ChatModel> chatModel, Activity activity, CourseDetail singleStudy, ArrayList<Video> videoArrayList, String tileIdAPI, String tileTypeAPI, String revertAPI, String tile_id, String is_purchase) {
        this.videoArrayListAuto = new ArrayList<>();
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        this.utkashRoom = appDatabase;
        this.tile_id = "";
        this.is_purchase = "";
        this.result_date = "";
        this.test_submission = "";
        this.themeSettings = appDatabase.getthemeSettingdao().data();
        this.mLastClickTime = 0L;
        this.isSSCpattern = false;
        this.langIds = new String[]{"1"};
        this.activity = activity;
        this.singleStudy = singleStudy;
        this.videoArrayList = videoArrayList;
        this.signUpResponse = SharedPreference.getInstance().getLoggedInUser();
        this.time = Long.valueOf(System.currentTimeMillis());
        this.tileTypeAPI = tileTypeAPI;
        this.tileIdAPI = tileIdAPI;
        this.revertAPI = revertAPI;
        this.tile_id = tile_id;
        this.is_purchase = is_purchase;
        this.chatModel = chatModel;
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            this.progress = new Progress(activity);
        }
        ArrayList<Video> arrayList = new ArrayList<>();
        if (Constants.IS_FROM_LIBRARY && singleStudy != null && singleStudy.getData() != null && singleStudy.getData().getCourseDetail().getIsPurchased().equalsIgnoreCase("1") && singleStudy.getData().getCourseDetail().getCat_type().equalsIgnoreCase("3")) {
            for (Video video : videoArrayList) {
                if (video.getIs_test_purchased() != null && video.getIs_test_purchased().equalsIgnoreCase("1")) {
                    arrayList.add(video);
                }
            }
            this.videoArrayList = arrayList;
        }
        ThemeSettings themeSettingsData = this.utkashRoom.getthemeSettingdao().data();
        this.themeSettings = themeSettingsData;
        if (themeSettingsData != null) {
            this.themeSettings = this.utkashRoom.getthemeSettingdao().data();
            this.leftMenu = (LeftMenu) new Gson().fromJson(this.themeSettings.getLeft_menu(), LeftMenu.class);
            this.bottomSetting = (BottomSetting) new Gson().fromJson(this.themeSettings.getBottom(), BottomSetting.class);
        }
        this.videoArrayListAuto = videoArrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewInflate;
        if (viewType != 0) {
            if (viewType == 11) {
                return new SingleStudySubjectiveTimeTableListHolder(LayoutInflater.from(this.activity).inflate(R.layout.custom_user_timetable, parent, false));
            }
            if (viewType == 12) {
                return new SingleStudyGroupChatAdapter(LayoutInflater.from(this.activity).inflate(R.layout.item_group_chat_tile_main, parent, false));
            }
            return new StudyNoDataViewHolder(LayoutInflater.from(this.activity).inflate(R.layout.no_data_found, parent, false));
        }
        if ("1".equalsIgnoreCase("5")) {
            viewInflate = LayoutInflater.from(this.activity).inflate(R.layout.detail_single_item_springboard, parent, false);
        } else if ("1".equalsIgnoreCase("7")) {
            viewInflate = LayoutInflater.from(this.activity).inflate(R.layout.detail_single_item_theme8, parent, false);
        } else if ("1".equalsIgnoreCase("6")) {
            viewInflate = LayoutInflater.from(this.activity).inflate(R.layout.detail_single_item_theme6, parent, false);
        } else {
            viewInflate = LayoutInflater.from(this.activity).inflate(R.layout.detail_single_item, parent, false);
        }
        return new SubjectVideosHolder(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (this.contentType.equalsIgnoreCase("0")) {
            return 0;
        }
        if (this.contentType.equalsIgnoreCase("11")) {
            return 11;
        }
        return this.contentType.equalsIgnoreCase(Const.CHAT) ? 12 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.videoArrayList.size() > 0) {
            this.contentType = "0";
            return this.videoArrayList.size();
        }
        TimeTableModel timeTableModel = this.timeTableModel;
        if (timeTableModel != null && timeTableModel.getData().size() > 0) {
            this.contentType = "11";
            return 1;
        }
        ArrayList<ChatModel> arrayList = this.chatModel;
        if (arrayList != null && arrayList.size() > 0) {
            this.contentType = Const.CHAT;
            return 1;
        }
        this.contentType = "9";
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        try {
            if (this.contentType.equalsIgnoreCase("0")) {
                if (this.activity instanceof CourseActivity) {
                    ((SubjectVideosHolder) holder).setData(this.videoArrayList.get(position), ((CourseActivity) this.activity).contentType, position);
                    return;
                } else {
                    ((SubjectVideosHolder) holder).setData(this.videoArrayList.get(position), ((FolderActivity) this.activity).getContent_type(), position);
                    return;
                }
            }
            if (this.contentType.equalsIgnoreCase("11")) {
                TimeTableModel timeTableModel = this.timeTableModel;
                if (timeTableModel == null || timeTableModel.getData().size() <= 0) {
                    return;
                }
                ((SingleStudySubjectiveTimeTableListHolder) holder).setData(this.timeTableModel.getData(), position - 1);
                return;
            }
            if (this.contentType.equalsIgnoreCase(Const.CHAT)) {
                ArrayList<ChatModel> arrayList = this.chatModel;
                if (arrayList != null) {
                    ((SingleStudyGroupChatAdapter) holder).setData(arrayList);
                    return;
                }
                return;
            }
            ((StudyNoDataViewHolder) holder).setData();
        } catch (Exception e2) {
            Log.d(this.TAG, "onBindViewHolder: " + e2.getMessage());
        }
    }

    public class StudyNoDataViewHolder extends RecyclerView.ViewHolder {
        Button backBtn;
        RelativeLayout no_data_found_RL;

        public StudyNoDataViewHolder(View itemView) {
            super(itemView);
            this.no_data_found_RL = (RelativeLayout) itemView.findViewById(R.id.no_data_found_RL);
            this.backBtn = (Button) itemView.findViewById(R.id.backBtn);
        }

        public void setData() {
            this.no_data_found_RL.setVisibility(0);
            this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter.StudyNoDataViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    ExamPrepLayer3Adapter.this.activity.finish();
                }
            });
        }
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

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0469 A[Catch: Exception -> 0x050b, TryCatch #0 {Exception -> 0x050b, blocks: (B:27:0x006d, B:29:0x00a3, B:31:0x00a6, B:33:0x00aa, B:35:0x00b4, B:37:0x00c2, B:39:0x00ce, B:41:0x00d2, B:43:0x00dc, B:45:0x00ea, B:47:0x00f6, B:49:0x00fb, B:51:0x0105, B:53:0x0113, B:55:0x011d, B:57:0x012b, B:59:0x0137, B:61:0x0141, B:63:0x014f, B:64:0x015b, B:66:0x0161, B:68:0x0173, B:70:0x0179, B:72:0x0185, B:76:0x01ad, B:78:0x01b9, B:80:0x01c3, B:82:0x01d1, B:84:0x01d6, B:86:0x01da, B:88:0x01f1, B:90:0x0217, B:92:0x0228, B:94:0x0234, B:95:0x0237, B:169:0x04f9, B:91:0x0226, B:87:0x01e6, B:96:0x0268, B:98:0x0276, B:100:0x0284, B:102:0x028d, B:104:0x02a0, B:106:0x02b7, B:108:0x02d8, B:110:0x02e9, B:112:0x0304, B:113:0x0307, B:109:0x02e7, B:105:0x02ac, B:114:0x032e, B:117:0x034b, B:119:0x0357, B:121:0x0365, B:125:0x0373, B:138:0x038c, B:140:0x0396, B:142:0x03a4, B:144:0x03a9, B:146:0x03bc, B:148:0x03d3, B:150:0x03f4, B:152:0x0405, B:154:0x0420, B:155:0x0423, B:151:0x0403, B:147:0x03c8, B:156:0x044a, B:157:0x0461, B:159:0x0469, B:161:0x0484, B:163:0x04a5, B:165:0x04b6, B:167:0x04c7, B:168:0x04ca, B:164:0x04b4, B:160:0x0477, B:170:0x04fe), top: B:226:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0477 A[Catch: Exception -> 0x050b, TryCatch #0 {Exception -> 0x050b, blocks: (B:27:0x006d, B:29:0x00a3, B:31:0x00a6, B:33:0x00aa, B:35:0x00b4, B:37:0x00c2, B:39:0x00ce, B:41:0x00d2, B:43:0x00dc, B:45:0x00ea, B:47:0x00f6, B:49:0x00fb, B:51:0x0105, B:53:0x0113, B:55:0x011d, B:57:0x012b, B:59:0x0137, B:61:0x0141, B:63:0x014f, B:64:0x015b, B:66:0x0161, B:68:0x0173, B:70:0x0179, B:72:0x0185, B:76:0x01ad, B:78:0x01b9, B:80:0x01c3, B:82:0x01d1, B:84:0x01d6, B:86:0x01da, B:88:0x01f1, B:90:0x0217, B:92:0x0228, B:94:0x0234, B:95:0x0237, B:169:0x04f9, B:91:0x0226, B:87:0x01e6, B:96:0x0268, B:98:0x0276, B:100:0x0284, B:102:0x028d, B:104:0x02a0, B:106:0x02b7, B:108:0x02d8, B:110:0x02e9, B:112:0x0304, B:113:0x0307, B:109:0x02e7, B:105:0x02ac, B:114:0x032e, B:117:0x034b, B:119:0x0357, B:121:0x0365, B:125:0x0373, B:138:0x038c, B:140:0x0396, B:142:0x03a4, B:144:0x03a9, B:146:0x03bc, B:148:0x03d3, B:150:0x03f4, B:152:0x0405, B:154:0x0420, B:155:0x0423, B:151:0x0403, B:147:0x03c8, B:156:0x044a, B:157:0x0461, B:159:0x0469, B:161:0x0484, B:163:0x04a5, B:165:0x04b6, B:167:0x04c7, B:168:0x04ca, B:164:0x04b4, B:160:0x0477, B:170:0x04fe), top: B:226:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x04a5 A[Catch: Exception -> 0x050b, TryCatch #0 {Exception -> 0x050b, blocks: (B:27:0x006d, B:29:0x00a3, B:31:0x00a6, B:33:0x00aa, B:35:0x00b4, B:37:0x00c2, B:39:0x00ce, B:41:0x00d2, B:43:0x00dc, B:45:0x00ea, B:47:0x00f6, B:49:0x00fb, B:51:0x0105, B:53:0x0113, B:55:0x011d, B:57:0x012b, B:59:0x0137, B:61:0x0141, B:63:0x014f, B:64:0x015b, B:66:0x0161, B:68:0x0173, B:70:0x0179, B:72:0x0185, B:76:0x01ad, B:78:0x01b9, B:80:0x01c3, B:82:0x01d1, B:84:0x01d6, B:86:0x01da, B:88:0x01f1, B:90:0x0217, B:92:0x0228, B:94:0x0234, B:95:0x0237, B:169:0x04f9, B:91:0x0226, B:87:0x01e6, B:96:0x0268, B:98:0x0276, B:100:0x0284, B:102:0x028d, B:104:0x02a0, B:106:0x02b7, B:108:0x02d8, B:110:0x02e9, B:112:0x0304, B:113:0x0307, B:109:0x02e7, B:105:0x02ac, B:114:0x032e, B:117:0x034b, B:119:0x0357, B:121:0x0365, B:125:0x0373, B:138:0x038c, B:140:0x0396, B:142:0x03a4, B:144:0x03a9, B:146:0x03bc, B:148:0x03d3, B:150:0x03f4, B:152:0x0405, B:154:0x0420, B:155:0x0423, B:151:0x0403, B:147:0x03c8, B:156:0x044a, B:157:0x0461, B:159:0x0469, B:161:0x0484, B:163:0x04a5, B:165:0x04b6, B:167:0x04c7, B:168:0x04ca, B:164:0x04b4, B:160:0x0477, B:170:0x04fe), top: B:226:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x04b4 A[Catch: Exception -> 0x050b, TryCatch #0 {Exception -> 0x050b, blocks: (B:27:0x006d, B:29:0x00a3, B:31:0x00a6, B:33:0x00aa, B:35:0x00b4, B:37:0x00c2, B:39:0x00ce, B:41:0x00d2, B:43:0x00dc, B:45:0x00ea, B:47:0x00f6, B:49:0x00fb, B:51:0x0105, B:53:0x0113, B:55:0x011d, B:57:0x012b, B:59:0x0137, B:61:0x0141, B:63:0x014f, B:64:0x015b, B:66:0x0161, B:68:0x0173, B:70:0x0179, B:72:0x0185, B:76:0x01ad, B:78:0x01b9, B:80:0x01c3, B:82:0x01d1, B:84:0x01d6, B:86:0x01da, B:88:0x01f1, B:90:0x0217, B:92:0x0228, B:94:0x0234, B:95:0x0237, B:169:0x04f9, B:91:0x0226, B:87:0x01e6, B:96:0x0268, B:98:0x0276, B:100:0x0284, B:102:0x028d, B:104:0x02a0, B:106:0x02b7, B:108:0x02d8, B:110:0x02e9, B:112:0x0304, B:113:0x0307, B:109:0x02e7, B:105:0x02ac, B:114:0x032e, B:117:0x034b, B:119:0x0357, B:121:0x0365, B:125:0x0373, B:138:0x038c, B:140:0x0396, B:142:0x03a4, B:144:0x03a9, B:146:0x03bc, B:148:0x03d3, B:150:0x03f4, B:152:0x0405, B:154:0x0420, B:155:0x0423, B:151:0x0403, B:147:0x03c8, B:156:0x044a, B:157:0x0461, B:159:0x0469, B:161:0x0484, B:163:0x04a5, B:165:0x04b6, B:167:0x04c7, B:168:0x04ca, B:164:0x04b4, B:160:0x0477, B:170:0x04fe), top: B:226:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x04c7 A[Catch: Exception -> 0x050b, TryCatch #0 {Exception -> 0x050b, blocks: (B:27:0x006d, B:29:0x00a3, B:31:0x00a6, B:33:0x00aa, B:35:0x00b4, B:37:0x00c2, B:39:0x00ce, B:41:0x00d2, B:43:0x00dc, B:45:0x00ea, B:47:0x00f6, B:49:0x00fb, B:51:0x0105, B:53:0x0113, B:55:0x011d, B:57:0x012b, B:59:0x0137, B:61:0x0141, B:63:0x014f, B:64:0x015b, B:66:0x0161, B:68:0x0173, B:70:0x0179, B:72:0x0185, B:76:0x01ad, B:78:0x01b9, B:80:0x01c3, B:82:0x01d1, B:84:0x01d6, B:86:0x01da, B:88:0x01f1, B:90:0x0217, B:92:0x0228, B:94:0x0234, B:95:0x0237, B:169:0x04f9, B:91:0x0226, B:87:0x01e6, B:96:0x0268, B:98:0x0276, B:100:0x0284, B:102:0x028d, B:104:0x02a0, B:106:0x02b7, B:108:0x02d8, B:110:0x02e9, B:112:0x0304, B:113:0x0307, B:109:0x02e7, B:105:0x02ac, B:114:0x032e, B:117:0x034b, B:119:0x0357, B:121:0x0365, B:125:0x0373, B:138:0x038c, B:140:0x0396, B:142:0x03a4, B:144:0x03a9, B:146:0x03bc, B:148:0x03d3, B:150:0x03f4, B:152:0x0405, B:154:0x0420, B:155:0x0423, B:151:0x0403, B:147:0x03c8, B:156:0x044a, B:157:0x0461, B:159:0x0469, B:161:0x0484, B:163:0x04a5, B:165:0x04b6, B:167:0x04c7, B:168:0x04ca, B:164:0x04b4, B:160:0x0477, B:170:0x04fe), top: B:226:0x006d }] */
    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void SuccessCallBack(org.json.JSONObject r23, java.lang.String r24, java.lang.String r25, boolean r26) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 1694
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter.SuccessCallBack(org.json.JSONObject, java.lang.String, java.lang.String, boolean):void");
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
        Video video;
        CourseDetail courseDetail = this.singleStudy;
        return ((courseDetail == null || courseDetail.getData() == null || this.singleStudy.getData().getCourseDetail() == null || TextUtils.isEmpty(this.singleStudy.getData().getCourseDetail().getIsPurchased()) || !this.singleStudy.getData().getCourseDetail().getIsPurchased().equals("1")) && (video = this.videopositonwise) != null && !TextUtils.isEmpty(video.getIs_locked()) && this.videopositonwise.getIs_locked().equals("1")) ? "Paid" : "Free";
    }

    public void sendlist(ArrayList<Video> videoArrayList) {
        this.videoArrayList = videoArrayList;
        notifyDataSetChanged();
    }

    public void changedata(int parseInt) {
        notifyDataSetChanged();
    }

    protected class SubjectVideosHolder extends RecyclerView.ViewHolder {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        LinearLayout LogsLL;
        LinearLayout actalll;
        TextView actualduration;
        LinearLayout attemptLL;
        Button booklet;
        CheckBox checkMark;
        LinearLayout classdurationll;
        long downloadId;
        ProgressBar downloadprogessPB;
        TextView duration;
        TextView durationTV;
        TextView learn;
        TextView listne_now;
        TextView liveDate;
        ImageView liveIv;
        TextView liveTime;
        LinearLayout llEnableMarkAsRead;
        RelativeLayout lockRL;
        Button marks;
        TextView messageTV;
        final ImageView optionMenuImgView;
        Button paper;
        TextView pdf_TV;
        TextView play_now;
        TextView practice;
        TextView read_now;
        RelativeLayout realte;
        TextView registerText;
        TextView remaining_time;
        LinearLayout remainingtimell;
        TextView resultText;
        RelativeLayout rlThum;
        ImageView share;
        RelativeLayout study_single_itemLL;
        LinearLayout subjectBTNLL;
        TextView testResume;
        TextView test_mode_tv;
        TextView test_price_tv;
        TextView test_price_tv1;
        final ImageView thumb;
        TextView timing;
        TextView title;
        TextView total_view_time;
        LinearLayout totalviewtimell;
        TextView tvMark;
        Button upload;
        private String videoDownloadUrl;
        CardView videoTile;
        VideosDownload videosDownload;
        TextView view_result;
        TextView watch_now;
        LinearLayout zoom_date_time;

        public SubjectVideosHolder(View itemView) {
            super(itemView);
            this.videoDownloadUrl = "";
            this.lockRL = (RelativeLayout) itemView.findViewById(R.id.lockRL);
            this.title = (TextView) itemView.findViewById(R.id.ibt_single_sub_vd_tv_title);
            this.durationTV = (TextView) itemView.findViewById(R.id.durationTV);
            this.read_now = (TextView) itemView.findViewById(R.id.read_now);
            this.liveIv = (ImageView) itemView.findViewById(R.id.liveIV);
            this.thumb = (ImageView) itemView.findViewById(R.id.ibt_single_sub_vd_iv);
            this.rlThum = (RelativeLayout) itemView.findViewById(R.id.rlThum);
            this.videoTile = (CardView) itemView.findViewById(R.id.ibt_single_sub_vd_RL);
            this.study_single_itemLL = (RelativeLayout) itemView.findViewById(R.id.study_single_itemLL);
            this.attemptLL = (LinearLayout) itemView.findViewById(R.id.attemptLL);
            this.subjectBTNLL = (LinearLayout) itemView.findViewById(R.id.subjectBTNLL);
            this.LogsLL = (LinearLayout) itemView.findViewById(R.id.LogsLL);
            this.duration = (TextView) itemView.findViewById(R.id.duration);
            this.total_view_time = (TextView) itemView.findViewById(R.id.total_view_time);
            this.remaining_time = (TextView) itemView.findViewById(R.id.remaining_time);
            this.paper = (Button) itemView.findViewById(R.id.paper);
            this.realte = (RelativeLayout) itemView.findViewById(R.id.realte);
            this.view_result = (TextView) itemView.findViewById(R.id.view_result);
            this.booklet = (Button) itemView.findViewById(R.id.booklet);
            this.upload = (Button) itemView.findViewById(R.id.upload);
            this.marks = (Button) itemView.findViewById(R.id.marks);
            this.learn = (TextView) itemView.findViewById(R.id.learn);
            this.practice = (TextView) itemView.findViewById(R.id.practice);
            this.testResume = (TextView) itemView.findViewById(R.id.testResume);
            this.optionMenuImgView = (ImageView) itemView.findViewById(R.id.optionMenuImgView);
            this.watch_now = (TextView) itemView.findViewById(R.id.watch_now);
            this.pdf_TV = (TextView) itemView.findViewById(R.id.pdf_TV);
            this.play_now = (TextView) itemView.findViewById(R.id.play_now);
            this.listne_now = (TextView) itemView.findViewById(R.id.listne_now);
            this.share = (ImageView) itemView.findViewById(R.id.share);
            this.downloadprogessPB = (ProgressBar) itemView.findViewById(R.id.downloadprogess);
            this.messageTV = (TextView) itemView.findViewById(R.id.messageTV);
            this.zoom_date_time = (LinearLayout) itemView.findViewById(R.id.zoom_date_time);
            this.liveDate = (TextView) itemView.findViewById(R.id.liveDate);
            this.timing = (TextView) itemView.findViewById(R.id.timing);
            this.liveTime = (TextView) itemView.findViewById(R.id.liveTime);
            this.actalll = (LinearLayout) itemView.findViewById(R.id.actalll);
            this.registerText = (TextView) itemView.findViewById(R.id.registerText);
            this.test_mode_tv = (TextView) itemView.findViewById(R.id.test_mode_tv);
            this.resultText = (TextView) itemView.findViewById(R.id.resultText);
            this.classdurationll = (LinearLayout) itemView.findViewById(R.id.classdurationll);
            this.totalviewtimell = (LinearLayout) itemView.findViewById(R.id.totalviewtimell);
            this.remainingtimell = (LinearLayout) itemView.findViewById(R.id.remainingtimell);
            this.actualduration = (TextView) itemView.findViewById(R.id.actualduration);
            this.test_price_tv = (TextView) itemView.findViewById(R.id.test_price_tv);
            this.test_price_tv1 = (TextView) itemView.findViewById(R.id.test_price_tv1);
            this.downloadprogessPB.setScaleY(1.5f);
            this.llEnableMarkAsRead = (LinearLayout) itemView.findViewById(R.id.llMarkRead);
            this.checkMark = (CheckBox) itemView.findViewById(R.id.checkMark);
            this.tvMark = (TextView) itemView.findViewById(R.id.tvMark);
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:130:0x03c6  */
        /* JADX WARN: Removed duplicated region for block: B:133:0x03d8  */
        /* JADX WARN: Removed duplicated region for block: B:134:0x03e0  */
        /* JADX WARN: Removed duplicated region for block: B:1613:0x40c9  */
        /* JADX WARN: Removed duplicated region for block: B:1614:0x40d2  */
        /* JADX WARN: Removed duplicated region for block: B:1617:0x40e9  */
        /* JADX WARN: Removed duplicated region for block: B:1622:0x4101  */
        /* JADX WARN: Removed duplicated region for block: B:2648:0x6aef  */
        /* JADX WARN: Removed duplicated region for block: B:2651:0x6b00  */
        /* JADX WARN: Removed duplicated region for block: B:2652:0x6b09  */
        /* JADX WARN: Removed duplicated region for block: B:2655:0x6b20  */
        /* JADX WARN: Removed duplicated region for block: B:2660:0x6b38  */
        /* JADX WARN: Removed duplicated region for block: B:2751:0x6e7d  */
        /* JADX WARN: Removed duplicated region for block: B:2753:0x6e85  */
        /* JADX WARN: Removed duplicated region for block: B:849:0x22b4  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void setData(com.appnew.android.Model.Video r34, java.lang.String r35, int r36) {
            /*
                Method dump skipped, instruction units count: 28534
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter.SubjectVideosHolder.setData(com.appnew.android.Model.Video, java.lang.String, int):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isCourseSoldOut() {
            try {
                if (ExamPrepLayer3Adapter.this.singleStudy == null || ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail() == null || ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getExtra_json() == null || ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getExtra_json().getSold_out() == null) {
                    return false;
                }
                return ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getExtra_json().getSold_out().equalsIgnoreCase("1");
            } catch (Exception unused) {
                return false;
            }
        }

        private void setTestCLick(final Video video) {
            this.study_single_itemLL.setClickable(true);
            this.study_single_itemLL.setEnabled(true);
            this.study_single_itemLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter.SubjectVideosHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    Video video2 = video;
                    if (video2 == null || video2.getIs_test_purchased().equalsIgnoreCase("1") || !ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type().equalsIgnoreCase("3")) {
                        return;
                    }
                    JSONArray jSONArray = new JSONArray();
                    try {
                        if (!video.getIs_test_purchased().equalsIgnoreCase("1")) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("id", video.getId());
                            jSONObject.put("test_series_name", video.getTest_series_name());
                            jSONObject.put("title", video.getTest_series_name());
                            jSONObject.put(FirebaseAnalytics.Param.PRICE, video.getPrice());
                            jSONObject.put(Const.TEST_TYPE, video.getMode());
                            jSONObject.put(FirebaseAnalytics.Param.START_DATE, video.getStart_date());
                            jSONObject.put(FirebaseAnalytics.Param.END_DATE, video.getEnd_date());
                            jSONObject.put("result_date", video.getResult_date());
                            jSONObject.put("time_in_mins", video.getTime_in_mins());
                            jSONObject.put("is_gst", video.getIs_gst());
                            jSONObject.put("tax_rate", video.getTax_rate());
                            jSONArray.put(jSONObject);
                            if (jSONArray.length() > 0) {
                                if (SubjectVideosHolder.this.isCourseSoldOut() && video.getIs_locked().equalsIgnoreCase("1")) {
                                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                                    return;
                                }
                                Intent intent = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                                intent.putExtra("test_data", jSONArray.toString());
                                intent.putExtra(Const.SINGLE_STUDY, ExamPrepLayer3Adapter.this.singleStudy);
                                intent.putExtra("test_id", video.getId());
                                intent.putExtra(Const.IS_BOOK, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                                intent.putExtra(Const.DELIVERY_CHARGE, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                                Helper.gotoActivity(intent, ExamPrepLayer3Adapter.this.activity);
                                return;
                            }
                            Toast.makeText(ExamPrepLayer3Adapter.this.activity, "Scholarship Test is not available", 0).show();
                            return;
                        }
                        Toast.makeText(ExamPrepLayer3Adapter.this.activity, "Already Enrolled", 0).show();
                    } catch (JSONException e2) {
                        throw new RuntimeException(e2);
                    }
                }
            });
        }

        private void setCONTENT_TEST(Video video) {
            this.title.setText(video.getTitle());
            this.zoom_date_time.setVisibility(8);
            this.read_now.setVisibility(8);
            this.liveIv.setVisibility(8);
            this.watch_now.setVisibility(8);
            this.listne_now.setVisibility(8);
            this.optionMenuImgView.setVisibility(8);
            this.subjectBTNLL.setVisibility(8);
            this.LogsLL.setVisibility(8);
            this.durationTV.setVisibility(0);
        }

        private void handleLearnPractice(Video video) {
            boolean zEqualsIgnoreCase = ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type().equalsIgnoreCase("3");
            boolean zIsLearnPracticeHide = Helper.isLearnPracticeHide();
            boolean z = (video == null || Helper.isLiveTest(video.getTest_series_type())) ? false : true;
            if (zEqualsIgnoreCase || zIsLearnPracticeHide || z) {
                this.learn.setVisibility(8);
                this.practice.setVisibility(8);
            } else {
                this.learn.setVisibility(0);
                this.practice.setVisibility(0);
            }
        }

        private void handleReadNow(Video video) {
            if (ExamPrepLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                this.read_now.setVisibility(0);
            } else if (video.getIs_locked().equalsIgnoreCase("0")) {
                this.read_now.setVisibility(0);
            } else {
                this.read_now.setVisibility(8);
            }
        }

        private void setCONTENT_CONCEPT(Video video) {
            this.title.setText(video.getTitle());
            this.durationTV.setText(ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.concept_type));
            this.attemptLL.setVisibility(8);
            this.optionMenuImgView.setVisibility(8);
            this.watch_now.setVisibility(8);
            this.LogsLL.setVisibility(8);
            this.subjectBTNLL.setVisibility(8);
            this.watch_now.setVisibility(8);
            this.listne_now.setVisibility(8);
            this.learn.setVisibility(8);
            this.practice.setVisibility(8);
            this.liveIv.setVisibility(8);
            this.durationTV.setVisibility(0);
        }

        private void setCONTENT_IMAGE(Video video) {
            this.title.setText(video.getTitle());
            this.durationTV.setText(ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.image_type));
            this.read_now.setText(ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.view_));
            this.attemptLL.setVisibility(8);
            this.optionMenuImgView.setVisibility(8);
            this.watch_now.setVisibility(8);
            this.subjectBTNLL.setVisibility(8);
            this.LogsLL.setVisibility(8);
            this.listne_now.setVisibility(8);
            this.learn.setVisibility(8);
            this.practice.setVisibility(8);
            this.liveIv.setVisibility(8);
            this.durationTV.setVisibility(0);
            if (ExamPrepLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                this.read_now.setVisibility(0);
            } else if (video.getIs_locked().equalsIgnoreCase("0")) {
                this.read_now.setVisibility(0);
            } else {
                this.read_now.setVisibility(8);
            }
        }

        private void setCONTENT_PPT(Video video) {
            this.title.setText(video.getTitle());
            this.subjectBTNLL.setVisibility(8);
            this.LogsLL.setVisibility(8);
            this.durationTV.setVisibility(8);
            this.read_now.setVisibility(8);
            this.learn.setVisibility(8);
            this.practice.setVisibility(8);
            this.share.setVisibility(8);
            this.attemptLL.setVisibility(8);
            this.optionMenuImgView.setVisibility(8);
        }

        private void setCONTENT_PDF(Video video) {
            this.title.setText(video.getTitle());
            this.attemptLL.setVisibility(8);
            this.optionMenuImgView.setVisibility(8);
            this.LogsLL.setVisibility(8);
            this.liveIv.setVisibility(8);
            this.subjectBTNLL.setVisibility(8);
            this.durationTV.setVisibility(8);
            this.watch_now.setVisibility(8);
            this.listne_now.setVisibility(8);
            this.learn.setVisibility(8);
            this.practice.setVisibility(8);
            if (ExamPrepLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                this.read_now.setVisibility(0);
            } else if (video.getIs_locked().equalsIgnoreCase("0")) {
                this.read_now.setVisibility(0);
            } else {
                this.read_now.setVisibility(8);
            }
        }

        private void setCUSTOM_VIDEO(Video video) {
            this.title.setText(video.getTitle());
            this.durationTV.setText(ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.search_videoRef));
            this.optionMenuImgView.setImageResource(R.drawable.delete);
            this.durationTV.setVisibility(0);
            this.optionMenuImgView.setVisibility(0);
            this.watch_now.setVisibility(0);
            this.attemptLL.setVisibility(8);
            this.share.setVisibility(8);
            this.read_now.setVisibility(8);
            this.LogsLL.setVisibility(8);
            this.subjectBTNLL.setVisibility(8);
            this.listne_now.setVisibility(8);
            this.learn.setVisibility(8);
            this.practice.setVisibility(8);
            this.liveIv.setVisibility(8);
        }

        private void setContentAudio(Video video) {
            this.title.setText(video.getTitle());
            this.durationTV.setText(ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.search_videoRef));
            this.optionMenuImgView.setImageResource(R.drawable.ic_menu_download);
            this.durationTV.setVisibility(8);
            this.watch_now.setVisibility(8);
            this.read_now.setVisibility(0);
            this.attemptLL.setVisibility(8);
            this.share.setVisibility(8);
            this.read_now.setVisibility(8);
            this.LogsLL.setVisibility(8);
            this.subjectBTNLL.setVisibility(8);
            this.listne_now.setVisibility(8);
            this.learn.setVisibility(8);
            this.practice.setVisibility(8);
            this.liveIv.setVisibility(8);
            if (ExamPrepLayer3Adapter.this.is_purchase.equalsIgnoreCase("1") || video.getIs_locked().equalsIgnoreCase("0")) {
                this.play_now.setVisibility(0);
                this.share.setVisibility(0);
                ExamPrepLayer3Adapter.this.updatePlayForAudio(this.play_now, video);
            } else {
                this.play_now.setVisibility(8);
                this.share.setVisibility(8);
            }
            if (video.getIs_locked().equalsIgnoreCase("0") && !TextUtils.isEmpty(video.getIs_download_available()) && video.getIs_download_available().equalsIgnoreCase("1")) {
                this.optionMenuImgView.setVisibility(0);
                this.optionMenuImgView.setImageResource(R.drawable.download_icon);
                ExamPrepLayer3Adapter.this.handleVideoStatus(video, this.optionMenuImgView, this.durationTV);
                return;
            }
            this.optionMenuImgView.setVisibility(8);
        }

        private void setCUSTOM_LINK(Video video) {
            this.title.setText(video.getTitle());
            this.durationTV.setText(ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.search_webLink));
            this.optionMenuImgView.setImageResource(R.drawable.delete);
            this.durationTV.setVisibility(0);
            this.read_now.setVisibility(0);
            this.optionMenuImgView.setVisibility(0);
            this.share.setVisibility(8);
            this.attemptLL.setVisibility(8);
            this.learn.setVisibility(8);
            this.LogsLL.setVisibility(8);
            this.practice.setVisibility(8);
            this.watch_now.setVisibility(8);
            this.subjectBTNLL.setVisibility(8);
            this.listne_now.setVisibility(8);
            this.liveIv.setVisibility(8);
        }

        private void setCUSTOM_REVISION(Video video) {
            this.title.setText(video.getTitle());
            this.durationTV.setText(ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.revision_set));
            this.optionMenuImgView.setImageResource(R.drawable.delete);
            this.thumb.setImageResource(R.mipmap.square_placeholder_new);
            this.durationTV.setVisibility(0);
            this.optionMenuImgView.setVisibility(0);
            this.read_now.setVisibility(0);
            this.attemptLL.setVisibility(8);
            this.share.setVisibility(8);
            this.learn.setVisibility(8);
            this.practice.setVisibility(8);
            this.watch_now.setVisibility(8);
            this.liveIv.setVisibility(8);
            this.listne_now.setVisibility(8);
            this.subjectBTNLL.setVisibility(8);
            this.LogsLL.setVisibility(8);
        }

        private void setPdfeOnClick(final Video video) {
            this.share.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$setPdfeOnClick$0(video);
                }
            }));
            this.study_single_itemLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setPdfeOnClick$1(video, view);
                }
            });
            this.read_now.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setPdfeOnClick$2(video, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$setPdfeOnClick$0(Video video) {
            if (ExamPrepLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                if (video.getFile_type().equalsIgnoreCase("8") || video.getFile_type().equalsIgnoreCase("7") || video.getFile_type().equalsIgnoreCase("1") || video.getFile_type().equalsIgnoreCase("6")) {
                    if (ExamPrepLayer3Adapter.this.folder_id != null && !ExamPrepLayer3Adapter.this.folder_id.isEmpty()) {
                        Helper.sharePdf(ExamPrepLayer3Adapter.this.activity, video.getPayloadData().getCourse_id(), video.getId(), video.getPayloadData().getTopic_id(), video.getPayloadData().getTile_type(), video.getPayloadData().getTile_id(), ExamPrepLayer3Adapter.this.revertAPI, Const.PDF, video.getThumbnail_url(), video.getTitle(), SingleStudy.parentCourseId, ExamPrepLayer3Adapter.this.folder_id, ExamPrepLayer3Adapter.this.folderContentType);
                    } else {
                        Helper.sharePdf(ExamPrepLayer3Adapter.this.activity, video.getPayloadData().getCourse_id(), video.getId(), video.getPayloadData().getTopic_id(), video.getPayloadData().getTile_type(), video.getPayloadData().getTile_id(), video.getPayloadData().getRevert_api(), Const.PDF, video.getThumbnail_url(), video.getTitle(), SingleStudy.parentCourseId);
                    }
                }
            } else if (video.getIs_locked().equalsIgnoreCase("1")) {
                if (isCourseSoldOut()) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                    return null;
                }
                Intent intent = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, ExamPrepLayer3Adapter.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, ExamPrepLayer3Adapter.this.activity);
            } else if (video.getFile_type().equalsIgnoreCase("8") || video.getFile_type().equalsIgnoreCase("7") || video.getFile_type().equalsIgnoreCase("1")) {
                if (ExamPrepLayer3Adapter.this.folder_id != null && !ExamPrepLayer3Adapter.this.folder_id.isEmpty()) {
                    Helper.sharePdf(ExamPrepLayer3Adapter.this.activity, video.getPayloadData().getCourse_id(), video.getId(), video.getPayloadData().getTopic_id(), video.getPayloadData().getTile_type(), video.getPayloadData().getTile_id(), ExamPrepLayer3Adapter.this.revertAPI, Const.PDF, video.getThumbnail_url(), video.getTitle(), SingleStudy.parentCourseId, ExamPrepLayer3Adapter.this.folder_id, ExamPrepLayer3Adapter.this.folderContentType);
                } else {
                    Helper.sharePdf(ExamPrepLayer3Adapter.this.activity, video.getPayloadData().getCourse_id(), video.getId(), video.getPayloadData().getTopic_id(), video.getPayloadData().getTile_type(), video.getPayloadData().getTile_id(), video.getPayloadData().getRevert_api(), Const.PDF, video.getThumbnail_url(), video.getTitle(), SingleStudy.parentCourseId);
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setPdfeOnClick$1(Video video, View view) {
            if (ExamPrepLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                if (!video.getFile_type().equalsIgnoreCase("7") && TextUtils.isEmpty(video.getFile_url()) && TextUtils.isEmpty(video.getId())) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.no_pdf_found), 0).show();
                    return;
                }
                if (video.getFile_type().equalsIgnoreCase("8")) {
                    openWebPage(ExamPrepLayer3Adapter.this.activity, video.getFile_url());
                    return;
                }
                if (video.getFile_type().equalsIgnoreCase("1")) {
                    boolean z = !TextUtils.isEmpty(video.getIs_download_available()) && video.getIs_download_available().equalsIgnoreCase("1");
                    if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                        Helper.GoToWebViewPDFActivity(ExamPrepLayer3Adapter.this.activity, video.getId(), video.getFile_url(), z, video.getTitle(), ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD, video.getIs_bookmarked(), video.getFile_type(), video.getIs_share(), "");
                        return;
                    } else {
                        Helper.GoToWebViewPDFActivity(ExamPrepLayer3Adapter.this.activity, video.getId(), video.getFile_url(), z, video.getTitle(), SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId(), video.getIs_bookmarked(), video.getFile_type(), video.getIs_share(), "");
                        return;
                    }
                }
                return;
            }
            if (video.getIs_locked().equalsIgnoreCase("1")) {
                if (isCourseSoldOut()) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, ExamPrepLayer3Adapter.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, ExamPrepLayer3Adapter.this.activity);
                return;
            }
            if (!video.getFile_type().equalsIgnoreCase("7") && TextUtils.isEmpty(video.getFile_url()) && TextUtils.isEmpty(video.getId())) {
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.no_pdf_found), 0).show();
                return;
            }
            if (video.getFile_type().equalsIgnoreCase("8")) {
                openWebPage(ExamPrepLayer3Adapter.this.activity, video.getFile_url());
                return;
            }
            if (video.getFile_type().equalsIgnoreCase("1")) {
                boolean z2 = !TextUtils.isEmpty(video.getIs_download_available()) && video.getIs_download_available().equalsIgnoreCase("1");
                if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                    Helper.GoToWebViewPDFActivity(ExamPrepLayer3Adapter.this.activity, video.getId(), video.getFile_url(), z2, video.getTitle(), ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD, video.getIs_bookmarked(), video.getFile_type(), video.getIs_share(), "");
                } else {
                    Helper.GoToWebViewPDFActivity(ExamPrepLayer3Adapter.this.activity, video.getId(), video.getFile_url(), z2, video.getTitle(), SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId(), video.getIs_bookmarked(), video.getFile_type(), video.getIs_share(), "");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setPdfeOnClick$2(Video video, View view) {
            if (ExamPrepLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                if (!video.getFile_type().equalsIgnoreCase("7") && TextUtils.isEmpty(video.getFile_url()) && TextUtils.isEmpty(video.getId())) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.no_pdf_found), 0).show();
                    return;
                }
                if (video.getFile_type().equalsIgnoreCase("8")) {
                    openWebPage(ExamPrepLayer3Adapter.this.activity, video.getFile_url());
                    return;
                }
                if (video.getFile_type().equalsIgnoreCase("1")) {
                    if (video.getPdf_view_url() != null && !video.getPdf_view_url().equalsIgnoreCase("")) {
                        Intent intent = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) WebViewActivty.class);
                        intent.putExtra("type", video.getTitle());
                        intent.putExtra("url", video.getPdf_view_url());
                        intent.putExtra(Const.VIDEO_ID, video.getId());
                        intent.putExtra("link", video.getFile_type());
                        Helper.gotoActivity(intent, ExamPrepLayer3Adapter.this.activity);
                        return;
                    }
                    boolean z = !TextUtils.isEmpty(video.getIs_download_available()) && video.getIs_download_available().equalsIgnoreCase("1");
                    if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                        Helper.GoToWebViewPDFActivity(ExamPrepLayer3Adapter.this.activity, video.getId(), video.getFile_url(), z, video.getTitle(), ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD, video.getIs_bookmarked(), video.getFile_type(), video.getIs_share(), "");
                        return;
                    } else {
                        Helper.GoToWebViewPDFActivity(ExamPrepLayer3Adapter.this.activity, video.getId(), video.getFile_url(), z, video.getTitle(), SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId(), video.getIs_bookmarked(), video.getFile_type(), video.getIs_share(), "");
                        return;
                    }
                }
                return;
            }
            if (video.getIs_locked().equalsIgnoreCase("1")) {
                if (isCourseSoldOut()) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent2 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent2.putExtra(Const.SINGLE_STUDY, ExamPrepLayer3Adapter.this.singleStudy);
                intent2.putExtra(Const.IS_BOOK, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent2.putExtra(Const.DELIVERY_CHARGE, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent2, ExamPrepLayer3Adapter.this.activity);
                return;
            }
            if (!video.getFile_type().equalsIgnoreCase("7") && TextUtils.isEmpty(video.getFile_url()) && TextUtils.isEmpty(video.getId())) {
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.no_pdf_found), 0).show();
                return;
            }
            if (video.getFile_type().equalsIgnoreCase("8")) {
                openWebPage(ExamPrepLayer3Adapter.this.activity, video.getFile_url());
                return;
            }
            if (video.getFile_type().equalsIgnoreCase("1")) {
                if (video.getPdf_view_url() != null && !video.getPdf_view_url().equalsIgnoreCase("")) {
                    Intent intent3 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) WebViewActivty.class);
                    intent3.putExtra("type", video.getTitle());
                    intent3.putExtra("url", video.getPdf_view_url());
                    intent3.putExtra(Const.VIDEO_ID, video.getId());
                    intent3.putExtra("link", video.getFile_type());
                    Helper.gotoActivity(intent3, ExamPrepLayer3Adapter.this.activity);
                    return;
                }
                boolean z2 = !TextUtils.isEmpty(video.getIs_download_available()) && video.getIs_download_available().equalsIgnoreCase("1");
                if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                    Helper.GoToWebViewPDFActivity(ExamPrepLayer3Adapter.this.activity, video.getId(), video.getFile_url(), z2, video.getTitle(), ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD, video.getIs_bookmarked(), video.getFile_type(), video.getIs_share(), "");
                } else {
                    Helper.GoToWebViewPDFActivity(ExamPrepLayer3Adapter.this.activity, video.getId(), video.getFile_url(), z2, video.getTitle(), SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId(), video.getIs_bookmarked(), video.getFile_type(), video.getIs_share(), "");
                }
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

        public void setOnClick(final Video video, final int position, String click) {
            this.share.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda42
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$setOnClick$3(video);
                }
            }));
            this.study_single_itemLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda43
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setOnClick$4(video, position, view);
                }
            });
            this.watch_now.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda44
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setOnClick$5(video, position, view);
                }
            });
            this.play_now.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda45
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setOnClick$6(video, view);
                }
            });
            this.listne_now.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda46
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setOnClick$7(video, position, view);
                }
            });
            this.pdf_TV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter.SubjectVideosHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (!Helper.isConnected(ExamPrepLayer3Adapter.this.activity)) {
                        Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                        return;
                    }
                    Intent intent = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) PdfListActivity.class);
                    intent.putExtra(Const.VIDEO_ID, video.getId());
                    intent.putExtra("course_id", video.getPayloadData().getCourse_id());
                    Helper.gotoActivity(intent, ExamPrepLayer3Adapter.this.activity);
                }
            });
            this.optionMenuImgView.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda47
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$setOnClick$8(video, position);
                }
            }));
            this.read_now.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setOnClick$9(video, position, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$setOnClick$3(Video video) {
            if (ExamPrepLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                if (video.getFile_type().equalsIgnoreCase("8")) {
                    Helper.sharePdf(ExamPrepLayer3Adapter.this.activity, video.getPayloadData().getCourse_id(), video.getId(), video.getPayloadData().getTopic_id(), video.getPayloadData().getTile_type(), video.getPayloadData().getTile_id(), video.getPayloadData().getRevert_api(), Const.PDF, video.getThumbnail_url(), video.getTitle(), SingleStudy.parentCourseId);
                } else if (video.getFile_type().equalsIgnoreCase("13")) {
                    Helper.shareAudio(ExamPrepLayer3Adapter.this.activity, video.getPayloadData().getCourse_id(), video.getId(), video.getPayloadData().getTopic_id(), video.getPayloadData().getTile_type(), video.getPayloadData().getTile_id(), video.getPayloadData().getRevert_api(), "audio", video.getThumbnail_url(), video.getTitle(), SingleStudy.parentCourseId);
                } else if (video.getVideo_type().equalsIgnoreCase("4") || video.getVideo_type().equalsIgnoreCase("1") || video.getVideo_type().equalsIgnoreCase("7") || video.getVideo_type().equalsIgnoreCase("8") || video.getVideo_type().equalsIgnoreCase("9")) {
                    Helper.shareLiveClass(ExamPrepLayer3Adapter.this.activity, video.getPayloadData().getCourse_id(), video.getId(), video.getPayloadData().getTopic_id(), video.getPayloadData().getTile_type(), video.getPayloadData().getTile_id(), video.getPayloadData().getRevert_api(), "video", video.getThumbnail_url(), video.getTitle(), SingleStudy.parentCourseId, video.getIs_locked());
                } else if (video.getVideo_type().equalsIgnoreCase("6")) {
                    Helper.sharejwvideo(ExamPrepLayer3Adapter.this.activity, video.getPayloadData().getCourse_id(), video.getId(), video.getPayloadData().getTopic_id(), video.getPayloadData().getTile_type(), video.getPayloadData().getTile_id(), video.getPayloadData().getRevert_api(), "video", video.getThumbnail_url(), video.getTitle(), SingleStudy.parentCourseId);
                } else if (video.getVideo_type().equalsIgnoreCase("0") || video.getVideo_type().equalsIgnoreCase("5")) {
                    Helper.shareLiveClass(ExamPrepLayer3Adapter.this.activity, video.getPayloadData().getCourse_id(), video.getId(), video.getPayloadData().getTopic_id(), video.getPayloadData().getTile_type(), video.getPayloadData().getTile_id(), video.getPayloadData().getRevert_api(), "video", video.getThumbnail_url(), video.getTitle(), SingleStudy.parentCourseId, video.getIs_locked());
                }
            } else if (video.getIs_locked().equalsIgnoreCase("1")) {
                if (isCourseSoldOut()) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                    return null;
                }
                Intent intent = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, ExamPrepLayer3Adapter.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, ExamPrepLayer3Adapter.this.activity);
            } else if (video.getFile_type().equalsIgnoreCase("13")) {
                Helper.shareAudio(ExamPrepLayer3Adapter.this.activity, video.getPayloadData().getCourse_id(), video.getId(), video.getPayloadData().getTopic_id(), video.getPayloadData().getTile_type(), video.getPayloadData().getTile_id(), video.getPayloadData().getRevert_api(), "audio", video.getThumbnail_url(), video.getTitle(), SingleStudy.parentCourseId);
            } else if (video.getFile_type().equalsIgnoreCase("8")) {
                Helper.sharePdf(ExamPrepLayer3Adapter.this.activity, video.getPayloadData().getCourse_id(), video.getId(), video.getPayloadData().getTopic_id(), video.getPayloadData().getTile_type(), video.getPayloadData().getTile_id(), video.getPayloadData().getRevert_api(), Const.PDF, video.getThumbnail_url(), video.getTitle(), SingleStudy.parentCourseId);
            } else if (video.getVideo_type().equalsIgnoreCase("4") || video.getVideo_type().equalsIgnoreCase("1") || video.getVideo_type().equalsIgnoreCase("7") || video.getVideo_type().equalsIgnoreCase("8")) {
                Helper.shareLiveClass(ExamPrepLayer3Adapter.this.activity, video.getPayloadData().getCourse_id(), video.getId(), video.getPayloadData().getTopic_id(), video.getPayloadData().getTile_type(), video.getPayloadData().getTile_id(), video.getPayloadData().getRevert_api(), "video", video.getThumbnail_url(), video.getTitle(), SingleStudy.parentCourseId, video.getIs_locked());
            } else if (video.getVideo_type().equalsIgnoreCase("6")) {
                Helper.sharejwvideo(ExamPrepLayer3Adapter.this.activity, video.getPayloadData().getCourse_id(), video.getId(), video.getPayloadData().getTopic_id(), video.getPayloadData().getTile_type(), video.getPayloadData().getTile_id(), video.getPayloadData().getRevert_api(), "video", video.getThumbnail_url(), video.getTitle(), SingleStudy.parentCourseId);
            } else if (video.getVideo_type().equalsIgnoreCase("0") || video.getVideo_type().equalsIgnoreCase("5")) {
                Helper.shareLiveClass(ExamPrepLayer3Adapter.this.activity, video.getPayloadData().getCourse_id(), video.getId(), video.getPayloadData().getTopic_id(), video.getPayloadData().getTile_type(), video.getPayloadData().getTile_id(), video.getPayloadData().getRevert_api(), "video", video.getThumbnail_url(), video.getTitle(), SingleStudy.parentCourseId, video.getIs_locked());
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setOnClick$4(Video video, int i, View view) {
            if (!Helper.isConnected(ExamPrepLayer3Adapter.this.activity)) {
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                return;
            }
            if (ExamPrepLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                stopServiceOnWatch();
                onVideoTileClick(video, i);
                return;
            }
            if (video.getIs_locked().equalsIgnoreCase("1")) {
                if (isCourseSoldOut()) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, ExamPrepLayer3Adapter.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, ExamPrepLayer3Adapter.this.activity);
                return;
            }
            stopServiceOnWatch();
            onVideoTileClick(video, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setOnClick$5(Video video, int i, View view) {
            if (!Helper.isConnected(ExamPrepLayer3Adapter.this.activity)) {
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                return;
            }
            if (ExamPrepLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                stopServiceOnWatch();
                if (video.getVideo_type().equalsIgnoreCase("9")) {
                    if (video.getLive_status().equalsIgnoreCase("1")) {
                        if (video.getZoom_meeting_id().equalsIgnoreCase("") || video.getZoom_meeting_passcode().equalsIgnoreCase("")) {
                            return;
                        }
                        if (!SharedPreference.getInstance().getString(Const.ZOOM_ACCESS_KEY).equalsIgnoreCase("")) {
                            ZoomFeatureHelper.launchZoomFeature(ExamPrepLayer3Adapter.this.activity, video.getZoom_meeting_id(), video.getZoom_meeting_passcode(), video.getZoom_sdk_token(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getName(), SharedPreference.getInstance().getLoggedInUser().getEmail(), SharedPreference.getInstance().getLoggedInUser().getMobile());
                            return;
                        }
                        Toast.makeText(ExamPrepLayer3Adapter.this.activity, "Zoom SDK key not found!", 0).show();
                        return;
                    }
                    if (video.getLive_status().equalsIgnoreCase("2")) {
                        if (!video.getFile_url().equalsIgnoreCase("") || !video.getFile_url().isEmpty()) {
                            Intent intent = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) ZoomRecodedPlayer.class);
                            intent.putExtra("videoUrl", video.getFile_url());
                            ExamPrepLayer3Adapter.this.activity.startActivity(intent);
                            return;
                        }
                        Toast.makeText(ExamPrepLayer3Adapter.this.activity, "No Video Found !", 0).show();
                        return;
                    }
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, "Zoom class is not yet started.", 0).show();
                    return;
                }
                if (TextUtils.isEmpty(video.getFile_url()) && TextUtils.isEmpty(video.getId())) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, "No video found!", 0).show();
                    return;
                }
                if (ExamPrepLayer3Adapter.this.activity instanceof CourseActivity) {
                    Helper.audio_service_close((CourseActivity) ExamPrepLayer3Adapter.this.activity);
                } else {
                    Helper.audio_service_close((FolderActivity) ExamPrepLayer3Adapter.this.activity);
                }
                API_REQUEST_VIDEO_LINK(video, i);
                return;
            }
            if (video.getIs_locked().equalsIgnoreCase("1")) {
                if (isCourseSoldOut()) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent2 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent2.putExtra(Const.SINGLE_STUDY, ExamPrepLayer3Adapter.this.singleStudy);
                intent2.putExtra(Const.IS_BOOK, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent2.putExtra(Const.DELIVERY_CHARGE, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent2, ExamPrepLayer3Adapter.this.activity);
                return;
            }
            stopServiceOnWatch();
            if (video.getVideo_type().equalsIgnoreCase("10")) {
                Intent intent3 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) PlayerActivity.class);
                intent3.putExtra("video", video);
                ExamPrepLayer3Adapter.this.activity.startActivity(intent3);
                return;
            }
            if (video.getVideo_type().equalsIgnoreCase("9")) {
                if (video.getLive_status().equalsIgnoreCase("1")) {
                    if (video.getZoom_meeting_id().equalsIgnoreCase("") || video.getZoom_meeting_passcode().equalsIgnoreCase("")) {
                        return;
                    }
                    if (!SharedPreference.getInstance().getString(Const.ZOOM_ACCESS_KEY).equalsIgnoreCase("")) {
                        ZoomFeatureHelper.launchZoomFeature(ExamPrepLayer3Adapter.this.activity, video.getZoom_meeting_id(), video.getZoom_meeting_passcode(), video.getZoom_sdk_token(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getName(), SharedPreference.getInstance().getLoggedInUser().getEmail(), SharedPreference.getInstance().getLoggedInUser().getMobile());
                        return;
                    }
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, "Zoom SDK key not found!", 0).show();
                    return;
                }
                if (video.getLive_status().equalsIgnoreCase("2")) {
                    if (!video.getFile_url().equalsIgnoreCase("") || !video.getFile_url().isEmpty()) {
                        Intent intent4 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) ZoomRecodedPlayer.class);
                        intent4.putExtra("videoUrl", video.getFile_url());
                        ExamPrepLayer3Adapter.this.activity.startActivity(intent4);
                        return;
                    }
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, "No Video Found !", 0).show();
                    return;
                }
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, "Zoom class is not yet started.", 0).show();
                return;
            }
            if (TextUtils.isEmpty(video.getFile_url()) && TextUtils.isEmpty(video.getId())) {
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.no_video_found), 0).show();
            } else {
                Helper.audio_service_close(ExamPrepLayer3Adapter.this.activity);
                API_REQUEST_VIDEO_LINK(video, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setOnClick$6(Video video, View view) {
            if (!Helper.isConnected(ExamPrepLayer3Adapter.this.activity)) {
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                return;
            }
            if (ExamPrepLayer3Adapter.this.is_purchase.equalsIgnoreCase("1") || video.getIs_locked().equalsIgnoreCase("0")) {
                if (video.getFile_type().equalsIgnoreCase("13")) {
                    if (this.play_now.getText().equals(ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.play))) {
                        this.play_now.setText(ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.stop));
                        if (MusicService.INSTANCE.isAudioPlaying()) {
                            Intent intent = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) MusicService.class);
                            intent.setAction("Stop_Service");
                            ExamPrepLayer3Adapter.this.activity.startService(intent);
                        }
                        Intent intent2 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) AudioPlayerActivity.class);
                        intent2.putExtra("video", video);
                        ExamPrepLayer3Adapter.this.activity.startActivity(intent2);
                    } else {
                        if (MusicService.INSTANCE.isAudioPlaying()) {
                            Intent intent3 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) MusicService.class);
                            intent3.setAction("Stop_Service");
                            ExamPrepLayer3Adapter.this.activity.startService(intent3);
                        }
                        this.play_now.setText(ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.play));
                    }
                    ExamPrepLayer3Adapter.this.notifyDataSetChanged();
                    return;
                }
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, "No audio found yet please wait some time !", 0).show();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setOnClick$7(Video video, int i, View view) {
            if (Helper.isNetworkConnected(ExamPrepLayer3Adapter.this.activity)) {
                if (ExamPrepLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                    if (TextUtils.isEmpty(video.getFile_url()) && TextUtils.isEmpty(video.getId())) {
                        Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.no_audio_found), 0).show();
                        return;
                    }
                    if (this.listne_now.getText().toString().equalsIgnoreCase("STOP")) {
                        try {
                            if (ExamPrepLayer3Adapter.this.activity instanceof CourseActivity) {
                                Helper.audio_service_close((CourseActivity) ExamPrepLayer3Adapter.this.activity);
                            } else {
                                Helper.audio_service_close((FolderActivity) ExamPrepLayer3Adapter.this.activity);
                            }
                            ExamPrepLayer3Adapter.this.notifyDataSetChanged();
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    try {
                        Helper.audio_service_close(ExamPrepLayer3Adapter.this.activity);
                        ExamPrepLayer3Adapter.this.notifyDataSetChanged();
                    } catch (Exception e3) {
                        Log.e("TAG", "onBindViewHolder: " + e3.getLocalizedMessage());
                    }
                    if (video.getVideo_type().equalsIgnoreCase("6")) {
                        ExamPrepLayer3Adapter.this.position_delete = i;
                        String str = "https://cdn.jwplayer.com/v2/media/" + video.getFile_url().substring(video.getFile_url().lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1, video.getFile_url().indexOf("-"));
                        return;
                    }
                    if (video.getVideo_type().equalsIgnoreCase("1")) {
                        Helper.GoToLiveVideoActivity(video.getChat_node(), ExamPrepLayer3Adapter.this.activity, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "1", video.getThumbnail_url(), video.getIs_chat_lock(), video.getPayloadData().getCourse_id(), String.valueOf(i), SingleStudy.parentCourseId, video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_bookmarked(), video.getIs_live(), ExamPrepLayer3Adapter.this.videoArrayListAuto);
                        return;
                    }
                    if (video.getVideo_type().equalsIgnoreCase("0")) {
                        Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), ExamPrepLayer3Adapter.this.activity, video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "1", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, video.getStart_date(), ExamPrepLayer3Adapter.this.videoArrayListAuto);
                        return;
                    }
                    if (video.getVideo_type().equalsIgnoreCase("5")) {
                        if (video.getLive_status().equalsIgnoreCase("1")) {
                            if (video.getFile_url() == null || video.getFile_url().equalsIgnoreCase("")) {
                                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                                return;
                            } else {
                                Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), ExamPrepLayer3Adapter.this.activity, video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "1", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, video.getStart_date(), ExamPrepLayer3Adapter.this.videoArrayListAuto);
                                return;
                            }
                        }
                        if (video.getLive_status().equalsIgnoreCase("0")) {
                            Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                            return;
                        } else if (video.getLive_status().equalsIgnoreCase("2")) {
                            Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                            return;
                        } else {
                            if (video.getLive_status().equalsIgnoreCase("3")) {
                                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                                return;
                            }
                            return;
                        }
                    }
                    if (video.getVideo_type().equalsIgnoreCase("4")) {
                        if (video.getLive_status().equalsIgnoreCase("1")) {
                            if (video.getFile_url() == null || video.getFile_url().equalsIgnoreCase("")) {
                                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                                return;
                            } else if (video.getOpen_in_app() != null && video.getOpen_in_app().equalsIgnoreCase("1")) {
                                Helper.GoToLiveVideoActivity(video.getChat_node(), ExamPrepLayer3Adapter.this.activity, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "1", video.getThumbnail_url(), video.getIs_chat_lock(), video.getPayloadData().getCourse_id(), String.valueOf(i), SingleStudy.parentCourseId, video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_bookmarked(), video.getIs_live(), ExamPrepLayer3Adapter.this.videoArrayListAuto);
                                return;
                            } else {
                                Helper.GoToLiveVideoActivity(video.getChat_node(), ExamPrepLayer3Adapter.this.activity, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "1", video.getThumbnail_url(), video.getIs_chat_lock(), video.getPayloadData().getCourse_id(), String.valueOf(i), SingleStudy.parentCourseId, video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_bookmarked(), video.getIs_live(), ExamPrepLayer3Adapter.this.videoArrayListAuto);
                                return;
                            }
                        }
                        if (video.getLive_status().equalsIgnoreCase("0")) {
                            Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                            return;
                        } else if (video.getLive_status().equalsIgnoreCase("2")) {
                            Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                            return;
                        } else {
                            if (video.getLive_status().equalsIgnoreCase("3")) {
                                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                                return;
                            }
                            return;
                        }
                    }
                    if (video.getVideo_type().equalsIgnoreCase("7")) {
                        if (video.getIs_drm().equals("0")) {
                            if (video.getFile_url() == null || video.getFile_url().equalsIgnoreCase("")) {
                                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                                return;
                            } else {
                                Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), ExamPrepLayer3Adapter.this.activity, video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "1", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, video.getStart_date(), ExamPrepLayer3Adapter.this.videoArrayListAuto);
                                return;
                            }
                        }
                        if (video.getIs_drm().equals("1")) {
                            if (video.getId() == null || video.getId().equalsIgnoreCase("")) {
                                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                                return;
                            } else {
                                Helper.GoToVideoCryptActivity(ExamPrepLayer3Adapter.this.activity, video.getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), video.getVideo_type(), video.getChat_node(), video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "1", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, video.getStart_date(), video.getIs_bookmarked(), ExamPrepLayer3Adapter.this.videoArrayListAuto);
                                return;
                            }
                        }
                        return;
                    }
                    if (video.getVideo_type().equalsIgnoreCase("8")) {
                        if (video.getIs_drm().equals("0")) {
                            if (video.getLive_status().equalsIgnoreCase("1")) {
                                if (video.getFile_url() == null || video.getFile_url().equalsIgnoreCase("")) {
                                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                                    return;
                                } else {
                                    Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), ExamPrepLayer3Adapter.this.activity, video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "1", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, video.getStart_date(), ExamPrepLayer3Adapter.this.videoArrayListAuto);
                                    return;
                                }
                            }
                            if (video.getLive_status().equalsIgnoreCase("0")) {
                                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                                return;
                            } else if (video.getLive_status().equalsIgnoreCase("2")) {
                                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                                return;
                            } else {
                                if (video.getLive_status().equalsIgnoreCase("3")) {
                                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                                    return;
                                }
                                return;
                            }
                        }
                        if (video.getIs_drm().equals("1")) {
                            if (video.getLive_status().equalsIgnoreCase("1")) {
                                if (video.getId() == null || video.getId().equalsIgnoreCase("")) {
                                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                                    return;
                                } else {
                                    Helper.GoToVideoCryptActivity(ExamPrepLayer3Adapter.this.activity, video.getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), video.getVideo_type(), video.getChat_node(), video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "1", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, video.getStart_date(), video.getIs_bookmarked(), ExamPrepLayer3Adapter.this.videoArrayListAuto);
                                    return;
                                }
                            }
                            if (video.getLive_status().equalsIgnoreCase("0")) {
                                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                                return;
                            } else if (video.getLive_status().equalsIgnoreCase("2")) {
                                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                                return;
                            } else {
                                if (video.getLive_status().equalsIgnoreCase("3")) {
                                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                if (video.getIs_locked().equalsIgnoreCase("1")) {
                    if (isCourseSoldOut()) {
                        Toast.makeText(ExamPrepLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                        return;
                    }
                    Intent intent = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                    intent.putExtra(Const.SINGLE_STUDY, ExamPrepLayer3Adapter.this.singleStudy);
                    intent.putExtra(Const.IS_BOOK, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                    intent.putExtra(Const.DELIVERY_CHARGE, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                    Helper.gotoActivity(intent, ExamPrepLayer3Adapter.this.activity);
                    return;
                }
                if (TextUtils.isEmpty(video.getFile_url()) && TextUtils.isEmpty(video.getId())) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.no_video_found), 0).show();
                    return;
                }
                if (this.listne_now.getText().toString().equalsIgnoreCase("STOP")) {
                    try {
                        if (ExamPrepLayer3Adapter.this.activity instanceof CourseActivity) {
                            Helper.audio_service_close((CourseActivity) ExamPrepLayer3Adapter.this.activity);
                        } else {
                            Helper.audio_service_close((FolderActivity) ExamPrepLayer3Adapter.this.activity);
                        }
                        ExamPrepLayer3Adapter.this.notifyDataSetChanged();
                        return;
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        return;
                    }
                }
                if (video.getVideo_type().equalsIgnoreCase("6")) {
                    String str2 = "https://cdn.jwplayer.com/v2/media/" + video.getFile_url().substring(video.getFile_url().lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1, video.getFile_url().indexOf("-"));
                    return;
                }
                if (video.getVideo_type().equalsIgnoreCase("1")) {
                    Helper.GoToLiveVideoActivity(video.getChat_node(), ExamPrepLayer3Adapter.this.activity, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "1", video.getThumbnail_url(), video.getIs_chat_lock(), video.getPayloadData().getCourse_id(), String.valueOf(i), SingleStudy.parentCourseId, video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_bookmarked(), video.getIs_live(), ExamPrepLayer3Adapter.this.videoArrayListAuto);
                    return;
                }
                if (video.getVideo_type().equalsIgnoreCase("0")) {
                    Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), ExamPrepLayer3Adapter.this.activity, video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "1", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, video.getStart_date(), ExamPrepLayer3Adapter.this.videoArrayListAuto);
                    return;
                }
                if (video.getVideo_type().equalsIgnoreCase("5")) {
                    Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), ExamPrepLayer3Adapter.this.activity, video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "1", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, video.getStart_date(), ExamPrepLayer3Adapter.this.videoArrayListAuto);
                    return;
                }
                if (video.getVideo_type().equalsIgnoreCase("4")) {
                    if (video.getLive_status().equalsIgnoreCase("1")) {
                        if (video.getFile_url() == null || video.getFile_url().equalsIgnoreCase("")) {
                            Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                            return;
                        } else if (video.getOpen_in_app() != null && video.getOpen_in_app().equalsIgnoreCase("1")) {
                            Helper.GoToLiveVideoActivity(video.getChat_node(), ExamPrepLayer3Adapter.this.activity, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "1", video.getThumbnail_url(), video.getIs_chat_lock(), video.getPayloadData().getCourse_id(), String.valueOf(i), SingleStudy.parentCourseId, video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_bookmarked(), video.getIs_live(), ExamPrepLayer3Adapter.this.videoArrayListAuto);
                            return;
                        } else {
                            ExamPrepLayer3Adapter.this.activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + video.getFile_url())));
                            return;
                        }
                    }
                    if (video.getLive_status().equalsIgnoreCase("0")) {
                        Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                        return;
                    } else if (video.getLive_status().equalsIgnoreCase("2")) {
                        Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                        return;
                    } else {
                        if (video.getLive_status().equalsIgnoreCase("3")) {
                            Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                            return;
                        }
                        return;
                    }
                }
                if (video.getVideo_type().equalsIgnoreCase("7")) {
                    if (video.getIs_drm().equals("0")) {
                        if (video.getFile_url() == null || video.getFile_url().equalsIgnoreCase("")) {
                            Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                            return;
                        } else {
                            Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), ExamPrepLayer3Adapter.this.activity, video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "1", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, video.getStart_date(), ExamPrepLayer3Adapter.this.videoArrayListAuto);
                            return;
                        }
                    }
                    if (video.getIs_drm().equals("1")) {
                        if (video.getId() == null || video.getId().equalsIgnoreCase("")) {
                            Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                            return;
                        } else {
                            Helper.GoToVideoCryptActivity(ExamPrepLayer3Adapter.this.activity, video.getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), video.getVideo_type(), video.getChat_node(), video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "1", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, video.getStart_date(), video.getIs_bookmarked(), ExamPrepLayer3Adapter.this.videoArrayListAuto);
                            return;
                        }
                    }
                    return;
                }
                if (video.getVideo_type().equalsIgnoreCase("8")) {
                    if (video.getIs_drm().equals("0")) {
                        if (video.getLive_status().equalsIgnoreCase("1")) {
                            if (video.getFile_url() == null || video.getFile_url().equalsIgnoreCase("")) {
                                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                                return;
                            } else {
                                Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), ExamPrepLayer3Adapter.this.activity, video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "1", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, video.getStart_date(), ExamPrepLayer3Adapter.this.videoArrayListAuto);
                                return;
                            }
                        }
                        if (video.getLive_status().equalsIgnoreCase("0")) {
                            Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                            return;
                        } else if (video.getLive_status().equalsIgnoreCase("2")) {
                            Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                            return;
                        } else {
                            if (video.getLive_status().equalsIgnoreCase("3")) {
                                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                                return;
                            }
                            return;
                        }
                    }
                    if (video.getIs_drm().equals("1")) {
                        if (video.getLive_status().equalsIgnoreCase("1")) {
                            if (video.getId() == null || video.getId().equalsIgnoreCase("")) {
                                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                                return;
                            } else {
                                Helper.GoToVideoCryptActivity(ExamPrepLayer3Adapter.this.activity, video.getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), video.getVideo_type(), video.getChat_node(), video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "1", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, video.getStart_date(), video.getIs_bookmarked(), ExamPrepLayer3Adapter.this.videoArrayListAuto);
                                return;
                            }
                        }
                        if (video.getLive_status().equalsIgnoreCase("0")) {
                            Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                            return;
                        } else if (video.getLive_status().equalsIgnoreCase("2")) {
                            Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                            return;
                        } else {
                            if (video.getLive_status().equalsIgnoreCase("3")) {
                                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$setOnClick$8(Video video, int i) {
            if (SystemClock.elapsedRealtime() - ExamPrepLayer3Adapter.this.mLastClickTime < 1000) {
                return null;
            }
            ExamPrepLayer3Adapter.this.mLastClickTime = SystemClock.elapsedRealtime();
            if (video.getVideo_status() != null && video.getVideo_status().equalsIgnoreCase("Downloading Running")) {
                return null;
            }
            if (Helper.isConnected(ExamPrepLayer3Adapter.this.activity)) {
                if (!ExamPrepLayer3Adapter.this.is_purchase.equalsIgnoreCase("1") && video.getIs_locked().equalsIgnoreCase("1")) {
                    if (isCourseSoldOut()) {
                        Toast.makeText(ExamPrepLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                        return null;
                    }
                    Intent intent = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                    intent.putExtra(Const.SINGLE_STUDY, ExamPrepLayer3Adapter.this.singleStudy);
                    intent.putExtra(Const.IS_BOOK, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                    intent.putExtra(Const.DELIVERY_CHARGE, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                    Helper.gotoActivity(intent, ExamPrepLayer3Adapter.this.activity);
                } else {
                    OnDownloadClick(video, i);
                }
            } else {
                Helper.showInternetToast(ExamPrepLayer3Adapter.this.activity);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setOnClick$9(Video video, int i, View view) {
            if (!Helper.isConnected(ExamPrepLayer3Adapter.this.activity)) {
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                return;
            }
            if (ExamPrepLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                if (video.getFile_type().equalsIgnoreCase("12")) {
                    if (ExamPrepLayer3Adapter.this.videoArrayList.size() > 0) {
                        Intent intent = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) RevisionActivity.class);
                        intent.putExtra("t_id", ExamPrepLayer3Adapter.this.tile_id);
                        intent.putExtra("postion", i);
                        intent.putExtra(Const.VIDEO_ID, video.getId());
                        intent.putExtra("v_list", ExamPrepLayer3Adapter.this.videoArrayList);
                        intent.putExtra("f_id", ExamPrepLayer3Adapter.this.videoArrayList.get(0).getId());
                        intent.putExtra("c_id", ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
                        intent.putExtra("title", video.getTitle());
                        intent.putExtra("url", video.getFile_url());
                        intent.putExtra(Const.VIA, "main");
                        Helper.gotoActivity(intent, ExamPrepLayer3Adapter.this.activity);
                        return;
                    }
                    return;
                }
                if (video.getFile_type().equalsIgnoreCase("11")) {
                    Intent intent2 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) WebViewActivty.class);
                    intent2.putExtra("type", video.getTitle());
                    intent2.putExtra("url", video.getFile_url());
                    Helper.gotoActivity(intent2, ExamPrepLayer3Adapter.this.activity);
                    return;
                }
                if (video.getFile_type().equalsIgnoreCase("8")) {
                    openWebPage(ExamPrepLayer3Adapter.this.activity, video.getFile_url());
                    return;
                }
                return;
            }
            if (video.getIs_locked().equalsIgnoreCase("1")) {
                if (isCourseSoldOut()) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent3 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent3.putExtra(Const.SINGLE_STUDY, ExamPrepLayer3Adapter.this.singleStudy);
                intent3.putExtra(Const.IS_BOOK, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent3.putExtra(Const.DELIVERY_CHARGE, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent3, ExamPrepLayer3Adapter.this.activity);
                return;
            }
            if (video.getFile_type().equalsIgnoreCase("12")) {
                if (ExamPrepLayer3Adapter.this.videoArrayList.size() > 0) {
                    Intent intent4 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) RevisionActivity.class);
                    intent4.putExtra("t_id", ExamPrepLayer3Adapter.this.tile_id);
                    intent4.putExtra("postion", i);
                    intent4.putExtra(Const.VIDEO_ID, video.getId());
                    intent4.putExtra("v_list", ExamPrepLayer3Adapter.this.videoArrayList);
                    intent4.putExtra("f_id", ExamPrepLayer3Adapter.this.videoArrayList.get(0).getId());
                    intent4.putExtra("c_id", ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
                    intent4.putExtra("title", video.getTitle());
                    intent4.putExtra("url", video.getFile_url());
                    intent4.putExtra(Const.VIA, "main");
                    Helper.gotoActivity(intent4, ExamPrepLayer3Adapter.this.activity);
                    return;
                }
                return;
            }
            if (video.getFile_type().equalsIgnoreCase("11")) {
                Intent intent5 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) WebViewActivty.class);
                intent5.putExtra("type", video.getTitle());
                intent5.putExtra("url", video.getFile_url());
                Helper.gotoActivity(intent5, ExamPrepLayer3Adapter.this.activity);
                return;
            }
            if (video.getFile_type().equalsIgnoreCase("8")) {
                openWebPage(ExamPrepLayer3Adapter.this.activity, video.getFile_url());
            }
        }

        private void onVideoTileClick(Video video, int position) {
            if (video.getVideo_type().equalsIgnoreCase("10")) {
                Intent intent = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) PlayerActivity.class);
                intent.putExtra("video", video);
                ExamPrepLayer3Adapter.this.activity.startActivity(intent);
                return;
            }
            if (TextUtils.isEmpty(video.getFile_url()) && TextUtils.isEmpty(video.getId())) {
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.no_video_found), 0).show();
                return;
            }
            if (video.getFile_type().equalsIgnoreCase("12")) {
                if (ExamPrepLayer3Adapter.this.videoArrayList.size() > 0) {
                    Intent intent2 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) RevisionActivity.class);
                    intent2.putExtra("t_id", ExamPrepLayer3Adapter.this.tile_id);
                    intent2.putExtra("postion", position);
                    intent2.putExtra(Const.VIDEO_ID, video.getId());
                    intent2.putExtra("v_list", ExamPrepLayer3Adapter.this.videoArrayList);
                    intent2.putExtra("f_id", ExamPrepLayer3Adapter.this.videoArrayList.get(0).getId());
                    intent2.putExtra("c_id", ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
                    intent2.putExtra("title", video.getTitle());
                    intent2.putExtra("url", video.getFile_url());
                    intent2.putExtra(Const.VIA, "main");
                    Helper.gotoActivity(intent2, ExamPrepLayer3Adapter.this.activity);
                    return;
                }
                return;
            }
            if (video.getFile_type().equalsIgnoreCase("11")) {
                Intent intent3 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) WebViewActivty.class);
                intent3.putExtra("type", video.getTitle());
                intent3.putExtra("url", video.getFile_url());
                Helper.gotoActivity(intent3, ExamPrepLayer3Adapter.this.activity);
                return;
            }
            if (video.getFile_type().equalsIgnoreCase("8")) {
                openWebPage(ExamPrepLayer3Adapter.this.activity, video.getFile_url());
                return;
            }
            if (video.getVideo_type().equalsIgnoreCase("9")) {
                if (video.getLive_status().equalsIgnoreCase("1")) {
                    if (video.getZoom_meeting_id().equalsIgnoreCase("") || video.getZoom_meeting_passcode().equalsIgnoreCase("")) {
                        return;
                    }
                    if (!SharedPreference.getInstance().getString(Const.ZOOM_ACCESS_KEY).equalsIgnoreCase("")) {
                        ZoomFeatureHelper.launchZoomFeature(ExamPrepLayer3Adapter.this.activity, video.getZoom_meeting_id(), video.getZoom_meeting_passcode(), video.getZoom_sdk_token(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getName(), SharedPreference.getInstance().getLoggedInUser().getEmail(), SharedPreference.getInstance().getLoggedInUser().getMobile());
                        return;
                    }
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, "Zoom SDK key not found!", 0).show();
                    return;
                }
                if (video.getLive_status().equalsIgnoreCase("2")) {
                    if (!video.getFile_url().equalsIgnoreCase("") || !video.getFile_url().isEmpty()) {
                        Intent intent4 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) ZoomRecodedPlayer.class);
                        intent4.putExtra("videoUrl", video.getFile_url());
                        ExamPrepLayer3Adapter.this.activity.startActivity(intent4);
                        return;
                    }
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, "No Video Found !", 0).show();
                    return;
                }
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, "Zoom class is not yet started.", 0).show();
                return;
            }
            if (video.getFile_type().equalsIgnoreCase("13")) {
                if (this.play_now.getText().equals(ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.play))) {
                    this.play_now.setText(ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.stop));
                    if (MusicService.INSTANCE.isAudioPlaying()) {
                        Intent intent5 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) MusicService.class);
                        intent5.setAction("Stop_Service");
                        ExamPrepLayer3Adapter.this.activity.startService(intent5);
                    }
                    Intent intent6 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) AudioPlayerActivity.class);
                    intent6.putExtra("video", video);
                    ExamPrepLayer3Adapter.this.activity.startActivity(intent6);
                } else {
                    if (MusicService.INSTANCE.isAudioPlaying()) {
                        Intent intent7 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) MusicService.class);
                        intent7.setAction("Stop_Service");
                        ExamPrepLayer3Adapter.this.activity.startService(intent7);
                    }
                    this.play_now.setText(ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.play));
                }
                ExamPrepLayer3Adapter.this.notifyDataSetChanged();
                return;
            }
            if (TextUtils.isEmpty(video.getFile_url()) && TextUtils.isEmpty(video.getId())) {
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, "No video found!", 0).show();
                return;
            }
            if (ExamPrepLayer3Adapter.this.activity instanceof CourseActivity) {
                Helper.audio_service_close((CourseActivity) ExamPrepLayer3Adapter.this.activity);
            } else {
                Helper.audio_service_close((FolderActivity) ExamPrepLayer3Adapter.this.activity);
            }
            API_REQUEST_VIDEO_LINK(video, position);
        }

        private void OnDownloadClick(Video video, int position) {
            if (video.getFile_type().equalsIgnoreCase("10") || video.getFile_type().equalsIgnoreCase("12") || video.getFile_type().equalsIgnoreCase("11")) {
                ExamPrepLayer3Adapter.this.videodata = video;
                ExamPrepLayer3Adapter.this.position_delete = position;
                PopUpAlertsKt.popUpDeleteVideo(ExamPrepLayer3Adapter.this.activity, video, new Function0() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda41
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$OnDownloadClick$10();
                    }
                });
                return;
            }
            if (video.getVideo_type().equalsIgnoreCase("6") || video.getVideo_type().equalsIgnoreCase("7")) {
                if (Helper.isNetworkConnected(ExamPrepLayer3Adapter.this.activity)) {
                    ExamPrepLayer3Adapter.this.videodata = video;
                    if (ExamPrepLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                        this.optionMenuImgView.setEnabled(false);
                        downloadServiceLibMedia(video, position);
                        return;
                    } else {
                        Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.this_feature_is_only_available_for_courses_in_your_library), 0).show();
                        return;
                    }
                }
                Helper.showInternetToast(ExamPrepLayer3Adapter.this.activity);
                return;
            }
            if (video.getFile_type().equalsIgnoreCase("3")) {
                if (video.getVideo_type().equalsIgnoreCase("1")) {
                    if (Helper.isNetworkConnected(ExamPrepLayer3Adapter.this.activity)) {
                        ExamPrepLayer3Adapter.this.videodata = video;
                        if (ExamPrepLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                            this.optionMenuImgView.setEnabled(false);
                            downloadYoutubeVideo(video, position);
                            return;
                        } else {
                            Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.this_feature_is_only_available_for_courses_in_your_library), 0).show();
                            return;
                        }
                    }
                    Helper.showInternetToast(ExamPrepLayer3Adapter.this.activity);
                    return;
                }
                return;
            }
            if (video.getFile_type().equalsIgnoreCase("13")) {
                if (Helper.isNetworkConnected(ExamPrepLayer3Adapter.this.activity)) {
                    ExamPrepLayer3Adapter.this.videodata = video;
                    if (ExamPrepLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                        this.optionMenuImgView.setEnabled(false);
                        downloadServiceLibMediaAudio(video, position);
                        return;
                    } else {
                        Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.this_feature_is_only_available_for_courses_in_your_library), 0).show();
                        return;
                    }
                }
                Helper.showInternetToast(ExamPrepLayer3Adapter.this.activity);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$OnDownloadClick$10() {
            ExamPrepLayer3Adapter examPrepLayer3Adapter = ExamPrepLayer3Adapter.this;
            new NetworkCall(examPrepLayer3Adapter, examPrepLayer3Adapter.activity).NetworkAPICall(API.delete_revision, "", true, false);
            return null;
        }

        private void stopServiceOnWatch() {
            try {
                if (AudioPlayerService.isAudioPlaying) {
                    Helper.audio_service_close(ExamPrepLayer3Adapter.this.activity);
                    ExamPrepLayer3Adapter.this.notifyDataSetChanged();
                }
            } catch (Exception unused) {
            }
        }

        public void download_service(Video video, int position, String link) {
            String str;
            VideosDownload videosDownload = new VideosDownload();
            if (ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().isvideo_exit(video.getId(), MakeMyExam.userId)) {
                videosDownload = ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().getvideo_byuserid(video.getId(), MakeMyExam.userId);
                videosDownload.setJw_url(link);
                videosDownload.setVideo_status("Download Running");
                videosDownload.setThumbnail_url(video.getThumbnail_url());
            } else {
                videosDownload.setVideo_id(video.getId());
                if (video.getVideo_type().equalsIgnoreCase("6")) {
                    videosDownload.setJw_url(link);
                    videosDownload.setThumbnail_url(video.getThumbnail_url());
                }
                if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                    str = ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD;
                } else {
                    str = SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId();
                }
                videosDownload.setVideo_name(video.getTitle());
                videosDownload.setVideo_history(video.getId() + "_" + MakeMyExam.userId + "_" + video.getId() + "_" + str);
                videosDownload.setToal_downloadlocale(0L);
                videosDownload.setPercentage(0);
                videosDownload.setOriginalFileLengthString("0");
                videosDownload.setCourse_id(str);
                videosDownload.setLengthInMb("");
                videosDownload.setIs_complete("0");
                videosDownload.setVideo_status("Download Running");
                videosDownload.setUser_id(MakeMyExam.userId);
                videosDownload.setVideoCurrentPosition(0L);
            }
            VideosDownload videosDownload2 = videosDownload;
            if (ExamPrepLayer3Adapter.this.progress.isShowing()) {
                ExamPrepLayer3Adapter.this.progress.dismiss();
            }
            if (video.getBitrate_urls() == null || video.getBitrate_urls().size() <= 0) {
                return;
            }
            openwatchlist_dailog_resource(ExamPrepLayer3Adapter.this.activity, video.getBitrate_urls(), videosDownload2, position, this.optionMenuImgView);
        }

        private void downloadServiceLibMedia(Video video, int position) {
            String str;
            if (video.getVdc_id() != null && video.getVdc_id().equalsIgnoreCase("")) {
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, "VDC ID is not found...", 0).show();
                return;
            }
            if (video.getBitrate_urls() == null || video.getBitrate_urls().size() == 0) {
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, "Download Url is not found...", 0).show();
                return;
            }
            this.videosDownload = new VideosDownload();
            if (ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().isvideo_exit(video.getId(), MakeMyExam.userId)) {
                VideosDownload videosDownload = ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().getvideo_byuserid(video.getId(), MakeMyExam.userId);
                this.videosDownload = videosDownload;
                videosDownload.setVideo_status("Download Running");
                this.videosDownload.setThumbnail_url(video.getThumbnail_url());
            } else {
                this.videosDownload.setVideo_id(video.getId());
                this.videosDownload.setThumbnail_url(video.getThumbnail_url());
                if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                    str = ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD;
                } else {
                    str = SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId();
                }
                this.videosDownload.setVideo_name(video.getTitle());
                this.videosDownload.setVideo_history(video.getId() + "_Videos_" + video.getId());
                this.videosDownload.setVdcId(video.getVdc_id().split("_")[2]);
                this.videosDownload.setVideo_type(video.getVideo_type());
                this.videosDownload.setToal_downloadlocale(0L);
                this.videosDownload.setPercentage(0);
                this.videosDownload.setOriginalFileLengthString("0");
                this.videosDownload.setCourse_id(str);
                this.videosDownload.setLengthInMb("");
                this.videosDownload.setIs_complete("0");
                this.videosDownload.setVideo_status("Download Running");
                this.videosDownload.setUser_id(MakeMyExam.userId);
                this.videosDownload.setVideoCurrentPosition(0L);
                if (video.getExtra_params() != null) {
                    this.videosDownload.setIs_limited(video.getExtra_params().getIs_limited());
                }
                this.videosDownload.setMultiplayer(video.getMultiplayer());
                if (video.getRemaining_time() != null) {
                    this.videosDownload.setRemaining_time(video.getRemaining_time());
                } else {
                    this.videosDownload.setRemaining_time("");
                }
                this.videosDownload.setVideo_length(video.getVideo_length());
                this.videosDownload.setTile_id(ExamPrepLayer3Adapter.this.tile_id);
            }
            if (ExamPrepLayer3Adapter.this.progress.isShowing()) {
                ExamPrepLayer3Adapter.this.progress.dismiss();
            }
            if (video.getBitrate_urls() != null && video.getBitrate_urls().size() > 0) {
                openwatchlist_dailog_resource(ExamPrepLayer3Adapter.this.activity, video.getBitrate_urls(), this.videosDownload, position, this.optionMenuImgView);
            } else {
                this.optionMenuImgView.setEnabled(true);
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, "No Download Urls Found..", 0).show();
            }
        }

        private void downloadServiceLibMediaAudio(Video video, int position) {
            String str;
            if (TextUtils.isEmpty(video.getFile_url())) {
                Helper.showToast(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getString(R.string.no_audio_found), 1);
                return;
            }
            VideosDownload videosDownload = new VideosDownload();
            if (ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().isvideo_exit_for_audio(video.getId(), MakeMyExam.userId)) {
                videosDownload = ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().getvideo_byuserid_for_audio(video.getId(), MakeMyExam.userId);
                videosDownload.setVideo_status("Download Running");
                videosDownload.setThumbnail_url(video.getThumbnail_url());
            } else {
                videosDownload.setVideo_id(video.getId());
                videosDownload.setThumbnail_url(video.getThumbnail_url());
                if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                    str = ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD;
                } else {
                    str = SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId();
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
                video.setVideo_status("Download Running");
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
                videosDownload.setTile_id(ExamPrepLayer3Adapter.this.tile_id);
            }
            if (ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().isvideo_exit_for_audio(videosDownload.getVideo_id(), MakeMyExam.userId)) {
                ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().update_videostatus_for_audio(videosDownload.getVideo_id(), videosDownload.getVideo_status(), MakeMyExam.userId);
            } else {
                ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().addUser(videosDownload);
            }
            if (ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().getuser_for_audio(videosDownload.getVideo_id(), videosDownload.getIs_complete()).getToal_downloadlocale() != null && ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().getuser_for_audio(videosDownload.getVideo_id(), videosDownload.getIs_complete()).getToal_downloadlocale().longValue() == 0) {
                ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().update_pos_for_audio(MakeMyExam.userId, videosDownload.getVideo_id(), ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().getalldownload_videos_for_audio(MakeMyExam.userId).size() - 1);
                Intent intent = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) VideoDownloadService.class);
                intent.putExtra(VideoDownloadService.FILEDOWNLOADSTATUS, false);
                intent.putExtra(VideoDownloadService.URL, video.getFile_url());
                intent.putExtra(VideoDownloadService.DOWNLOAD_SERVICE_ID, videosDownload.getVideo_id());
                intent.putExtra(VideoDownloadService.FILEPATH, videosDownload.getVideo_name());
                intent.putExtra("name", videosDownload.getVideo_history());
                intent.putExtra(com.clevertap.android.sdk.Constants.INAPP_POSITION, ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().getalldownload_videos_for_audio(MakeMyExam.userId).size() - 1);
                intent.putExtra("status", videosDownload.getVideo_status());
                intent.putExtra("downloadType", "1");
                VideoDownloadService.isServiceRunning = true;
                Helper.startVideoDownloadService(ExamPrepLayer3Adapter.this.activity, intent);
                ExamPrepLayer3Adapter.this.pushEventForDownload(videosDownload);
            }
            ExamPrepLayer3Adapter.this.notifyDataSetChanged();
        }

        private void downloadYoutubeVideo(final Video video, int position) {
            this.optionMenuImgView.setEnabled(true);
            new DownloadYoutubeBottomSheet(video, new Function1() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return this.f$0.lambda$downloadYoutubeVideo$11(video, (YoutubeVideoData) obj);
                }
            }).show(((AppCompatActivity) ExamPrepLayer3Adapter.this.activity).getSupportFragmentManager(), "DownloadYoutubeBottomSheet");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$downloadYoutubeVideo$11(Video video, YoutubeVideoData youtubeVideoData) {
            downloadServiceLibMediaYoutube(video, "https://www.youtube.com/watch?v=" + video.getFile_url(), youtubeVideoData);
            this.optionMenuImgView.setEnabled(false);
            return null;
        }

        public void downloadServiceLibMediaYoutube(Video video, String downloadUrl, YoutubeVideoData videoFormat) {
            String str;
            if (TextUtils.isEmpty(video.getFile_url())) {
                Helper.showToast(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getString(R.string.no_video_found), 1);
                return;
            }
            VideosDownload videosDownload = new VideosDownload();
            if (ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().isvideo_exit_for_youtube(video.getId(), MakeMyExam.userId)) {
                videosDownload = ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().getvideo_byuserid_for_youtube(video.getId(), MakeMyExam.userId);
                videosDownload.setVideo_status("Download Running");
                videosDownload.setThumbnail_url(video.getThumbnail_url());
            } else {
                videosDownload.setVideo_id(video.getId());
                videosDownload.setThumbnail_url(video.getThumbnail_url());
                if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                    str = ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD;
                } else {
                    str = SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId();
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
                video.setVideo_status("Download Running");
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
                videosDownload.setTile_id(ExamPrepLayer3Adapter.this.tile_id);
            }
            if (ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().isvideo_exit_for_youtube(videosDownload.getVideo_id(), MakeMyExam.userId)) {
                ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().update_videostatus_for_youtube(videosDownload.getVideo_id(), videosDownload.getVideo_status(), MakeMyExam.userId);
            } else {
                ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().addUser(videosDownload);
            }
            if (ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().getuser_for_youtube(videosDownload.getVideo_id(), videosDownload.getIs_complete()).getToal_downloadlocale() == null || ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().getuser_for_youtube(videosDownload.getVideo_id(), videosDownload.getIs_complete()).getToal_downloadlocale().longValue() != 0) {
                return;
            }
            ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().update_pos_for_youtube(MakeMyExam.userId, videosDownload.getVideo_id(), ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().getalldownload_videos_for_youtube(MakeMyExam.userId).size() - 1);
            ExamPrepLayer3Adapter.this.handleVideoStatus(video, this.optionMenuImgView, this.durationTV);
            Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getString(R.string.downloading_), 0).show();
            Intent intent = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) VideoDownloadService.class);
            intent.putExtra(VideoDownloadService.FILEDOWNLOADSTATUS, false);
            intent.putExtra(VideoDownloadService.URL, videoFormat.getUrl());
            intent.putExtra(VideoDownloadService.DOWNLOAD_SERVICE_ID, videosDownload.getVideo_id());
            intent.putExtra(VideoDownloadService.FILEPATH, videosDownload.getVideo_name());
            intent.putExtra("name", videosDownload.getVideo_history());
            intent.putExtra(com.clevertap.android.sdk.Constants.INAPP_POSITION, ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().getalldownload_videos_for_youtube(MakeMyExam.userId).size() - 1);
            intent.putExtra("status", videosDownload.getVideo_status());
            intent.putExtra("downloadType", "2");
            VideoDownloadService.isServiceRunning = true;
            Helper.startVideoDownloadService(ExamPrepLayer3Adapter.this.activity, intent);
            ExamPrepLayer3Adapter.this.pushEventForDownload(videosDownload);
        }

        public void openwatchlist_dailog_resource(Context context, final ArrayList<UrlObject> mediaResponseMap, final VideosDownload videosDownload, final int pos, final ImageView optionMenuImgView) {
            try {
                if (ExamPrepLayer3Adapter.this.progress.isShowing()) {
                    ExamPrepLayer3Adapter.this.progress.dismiss();
                }
                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.videosheetDialogTheme);
                bottomSheetDialog.setContentView(R.layout.quality_download_view);
                ((Window) Objects.requireNonNull(bottomSheetDialog.getWindow())).getAttributes().windowAnimations = R.style.PauseDialogAnimation;
                bottomSheetDialog.setCancelable(false);
                bottomSheetDialog.setCanceledOnTouchOutside(true);
                LinearLayout linearLayout = (LinearLayout) bottomSheetDialog.findViewById(R.id.lnPreparing);
                TextView textView = (TextView) bottomSheetDialog.findViewById(R.id.btnLow);
                TextView textView2 = (TextView) bottomSheetDialog.findViewById(R.id.btn240);
                TextView textView3 = (TextView) bottomSheetDialog.findViewById(R.id.tvResName);
                TextView textView4 = (TextView) bottomSheetDialog.findViewById(R.id.btnMedium);
                TextView textView5 = (TextView) bottomSheetDialog.findViewById(R.id.btnHigh);
                RecyclerView recyclerView = (RecyclerView) bottomSheetDialog.findViewById(R.id.bitrate_recyclerView);
                ((TextView) Objects.requireNonNull(textView3)).setText(videosDownload.getVideo_name());
                optionMenuImgView.setEnabled(true);
                setUiRecycler(mediaResponseMap, recyclerView, videosDownload, optionMenuImgView, bottomSheetDialog, new ExamPrepItem());
                ((LinearLayout) Objects.requireNonNull(linearLayout)).setVisibility(8);
                ((TextView) Objects.requireNonNull(textView2)).setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$openwatchlist_dailog_resource$13(optionMenuImgView, pos, bottomSheetDialog, videosDownload, mediaResponseMap);
                    }
                }));
                ((TextView) Objects.requireNonNull(textView)).setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$openwatchlist_dailog_resource$15(optionMenuImgView, pos, bottomSheetDialog, videosDownload, mediaResponseMap);
                    }
                }));
                ((TextView) Objects.requireNonNull(textView4)).setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$openwatchlist_dailog_resource$17(optionMenuImgView, pos, bottomSheetDialog, videosDownload, mediaResponseMap);
                    }
                }));
                ((TextView) Objects.requireNonNull(textView5)).setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$openwatchlist_dailog_resource$19(optionMenuImgView, pos, bottomSheetDialog, videosDownload, mediaResponseMap);
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
        public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$13(final ImageView imageView, final int i, BottomSheetDialog bottomSheetDialog, final VideosDownload videosDownload, final ArrayList arrayList) {
            imageView.setEnabled(false);
            ExamPrepLayer3Adapter.this.videoArrayList.get(i).setVideo_status("Download Running");
            dismissCalculatorDialog(bottomSheetDialog);
            AsyncTask.execute(new Runnable() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda31
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$openwatchlist_dailog_resource$12(videosDownload, arrayList, i, imageView);
                }
            });
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$openwatchlist_dailog_resource$12(VideosDownload videosDownload, ArrayList arrayList, int i, ImageView imageView) {
            if (ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().isvideo_exit(videosDownload.getVideo_id(), MakeMyExam.userId)) {
                ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().update_videostatus(videosDownload.getVideo_id(), videosDownload.getVideo_status(), MakeMyExam.userId);
            } else {
                ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().addUser(videosDownload);
            }
            this.videoDownloadUrl = ((UrlObject) arrayList.get(0)).getUrl();
            ExamPrepLayer3Adapter.this.Download_dialog(((UrlObject) arrayList.get(0)).getUrl(), videosDownload, i, imageView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$15(final ImageView imageView, final int i, BottomSheetDialog bottomSheetDialog, final VideosDownload videosDownload, final ArrayList arrayList) {
            imageView.setEnabled(false);
            ExamPrepLayer3Adapter.this.videoArrayList.get(i).setVideo_status("Download Running");
            dismissCalculatorDialog(bottomSheetDialog);
            AsyncTask.execute(new Runnable() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda32
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$openwatchlist_dailog_resource$14(videosDownload, arrayList, i, imageView);
                }
            });
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$openwatchlist_dailog_resource$14(VideosDownload videosDownload, ArrayList arrayList, int i, ImageView imageView) {
            if (ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().isvideo_exit(videosDownload.getVideo_id(), MakeMyExam.userId)) {
                ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().update_videostatus(videosDownload.getVideo_id(), videosDownload.getVideo_status(), MakeMyExam.userId);
            } else {
                ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().addUser(videosDownload);
            }
            this.videoDownloadUrl = ((UrlObject) arrayList.get(0)).getUrl();
            ExamPrepLayer3Adapter.this.Download_dialog(((UrlObject) arrayList.get(0)).getUrl(), videosDownload, i, imageView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$17(final ImageView imageView, final int i, BottomSheetDialog bottomSheetDialog, final VideosDownload videosDownload, final ArrayList arrayList) {
            imageView.setEnabled(false);
            ExamPrepLayer3Adapter.this.videoArrayList.get(i).setVideo_status("Download Running");
            dismissCalculatorDialog(bottomSheetDialog);
            AsyncTask.execute(new Runnable() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda21
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$openwatchlist_dailog_resource$16(videosDownload, arrayList, i, imageView);
                }
            });
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$openwatchlist_dailog_resource$16(VideosDownload videosDownload, ArrayList arrayList, int i, ImageView imageView) {
            if (ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().isvideo_exit(videosDownload.getVideo_id(), MakeMyExam.userId)) {
                ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().update_videostatus(videosDownload.getVideo_id(), videosDownload.getVideo_status(), MakeMyExam.userId);
            } else {
                ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().addUser(videosDownload);
            }
            this.videoDownloadUrl = ((UrlObject) arrayList.get(1)).getUrl();
            ExamPrepLayer3Adapter.this.Download_dialog(((UrlObject) arrayList.get(1)).getUrl(), videosDownload, i, imageView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$19(final ImageView imageView, final int i, BottomSheetDialog bottomSheetDialog, final VideosDownload videosDownload, final ArrayList arrayList) {
            imageView.setEnabled(false);
            ExamPrepLayer3Adapter.this.videoArrayList.get(i).setVideo_status("Download Running");
            dismissCalculatorDialog(bottomSheetDialog);
            AsyncTask.execute(new Runnable() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$openwatchlist_dailog_resource$18(videosDownload, arrayList, i, imageView);
                }
            });
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$openwatchlist_dailog_resource$18(VideosDownload videosDownload, ArrayList arrayList, int i, ImageView imageView) {
            if (ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().isvideo_exit(videosDownload.getVideo_id(), MakeMyExam.userId)) {
                ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().update_videostatus(videosDownload.getVideo_id(), videosDownload.getVideo_status(), MakeMyExam.userId);
            } else {
                ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().addUser(videosDownload);
            }
            this.videoDownloadUrl = ((UrlObject) arrayList.get(2)).getUrl();
            ExamPrepLayer3Adapter.this.Download_dialog(((UrlObject) arrayList.get(2)).getUrl(), videosDownload, i, imageView);
        }

        private void setUiRecycler(ArrayList<UrlObject> mediaResponseMap, RecyclerView bitrate_recyclerView, VideosDownload videosDownload, ImageView myButton, BottomSheetDialog bottomSheetDialog, ExamPrepItem examPrepItem) {
            BitrateAdapter bitrateAdapter = new BitrateAdapter(ExamPrepLayer3Adapter.this.activity, mediaResponseMap, videosDownload, myButton, bottomSheetDialog, examPrepItem);
            bitrate_recyclerView.setLayoutManager(new LinearLayoutManager(ExamPrepLayer3Adapter.this.activity));
            bitrate_recyclerView.setAdapter(bitrateAdapter);
            bitrate_recyclerView.setNestedScrollingEnabled(false);
        }

        public class BitrateAdapter extends RecyclerView.Adapter<MyViewHolder> {
            private BottomSheetDialog bottomSheetDialog;
            private Context context;
            private ExamPrepItem examPrepItem;
            private ArrayList<UrlObject> mediaResponseMap;
            private ImageView myButton;
            private VideosDownload videosDownload;

            public BitrateAdapter(Context context, ArrayList<UrlObject> mediaResponseMap, VideosDownload videosDownload, ImageView myButton, BottomSheetDialog bottomSheetDialog, ExamPrepItem examPrepItem) {
                this.mediaResponseMap = mediaResponseMap;
                this.context = context;
                this.videosDownload = videosDownload;
                this.myButton = myButton;
                this.bottomSheetDialog = bottomSheetDialog;
                this.examPrepItem = examPrepItem;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public void onBindViewHolder(final MyViewHolder holder, final int position) {
                final UrlObject urlObject = this.mediaResponseMap.get(position);
                holder.bitrateButton.setText(urlObject.getTitle());
                holder.bitrateButton.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter.SubjectVideosHolder.BitrateAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        if (Helper.isNetworkConnected(ExamPrepLayer3Adapter.this.activity)) {
                            if (ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().isvideo_exit(BitrateAdapter.this.videosDownload.getVideo_id(), MakeMyExam.userId)) {
                                ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().update_videostatus(BitrateAdapter.this.videosDownload.getVideo_id(), BitrateAdapter.this.videosDownload.getVideo_status(), MakeMyExam.userId);
                            } else {
                                ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().addUser(BitrateAdapter.this.videosDownload);
                            }
                            BitrateAdapter.this.notifyItemChanged(position);
                            ExamPrepLayer3Adapter.this.Download_dialog(urlObject.getUrl(), BitrateAdapter.this.videosDownload, position, BitrateAdapter.this.myButton);
                            SubjectVideosHolder.this.dismissCalculatorDialog(BitrateAdapter.this.bottomSheetDialog);
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
        public void dismissCalculatorDialog(BottomSheetDialog watchlist) {
            if (watchlist == null || !watchlist.isShowing()) {
                return;
            }
            watchlist.dismiss();
            watchlist.cancel();
        }

        public void setTestOnClick(final Video video, final String fileType) {
            this.practice.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda34
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setTestOnClick$24(video, view);
                }
            });
            TextView textView = this.testResume;
            if (textView != null) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda35
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setTestOnClick$25(video, view);
                    }
                });
            }
            this.learn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda36
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setTestOnClick$26(video, view);
                }
            });
            this.share.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda37
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$setTestOnClick$27(video);
                }
            }));
            this.view_result.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda38
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setTestOnClick$28(video, view);
                }
            });
            this.resultText.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda39
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setTestOnClick$29(video, view);
                }
            });
            this.attemptLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda40
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setTestOnClick$38(video, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setTestOnClick$24(Video video, View view) {
            if (!Helper.isConnected(ExamPrepLayer3Adapter.this.activity)) {
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                return;
            }
            ExamPrepLayer3Adapter.this.attemptOrReAttempt = Const.PRACTICE;
            if (ExamPrepLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                SharedPreference.getInstance().putString("id", ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
                ExamPrepLayer3Adapter.this.quiz_id = video.getId();
                ExamPrepLayer3Adapter.this.quiz_name = video.getTest_series_name();
                ExamPrepLayer3Adapter.this.totalQuestion = video.getTotal_questions();
                ExamPrepLayer3Adapter.this.first_attempt = "0";
                ExamPrepLayer3Adapter.this.result_date = video.getResult_date();
                ExamPrepLayer3Adapter.this.videopositonwise = video;
                Helper.resolveTestPattern(ExamPrepLayer3Adapter.this.activity, video.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda17
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setTestOnClick$20();
                    }
                }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda18
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setTestOnClick$21();
                    }
                });
                return;
            }
            if (video.getIs_locked().equalsIgnoreCase("1")) {
                if (isCourseSoldOut()) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, ExamPrepLayer3Adapter.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, ExamPrepLayer3Adapter.this.activity);
                return;
            }
            SharedPreference.getInstance().putString("id", ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
            ExamPrepLayer3Adapter.this.quiz_id = video.getId();
            ExamPrepLayer3Adapter.this.quiz_name = video.getTest_series_name();
            ExamPrepLayer3Adapter.this.totalQuestion = video.getTotal_questions();
            ExamPrepLayer3Adapter.this.first_attempt = "0";
            ExamPrepLayer3Adapter.this.result_date = video.getResult_date();
            ExamPrepLayer3Adapter.this.videopositonwise = video;
            Helper.resolveTestPattern(ExamPrepLayer3Adapter.this.activity, video.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda19
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setTestOnClick$22();
                }
            }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda20
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setTestOnClick$23();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setTestOnClick$20() {
            ExamPrepLayer3Adapter.this.isSSCpattern = false;
            ExamPrepLayer3Adapter.this.startTestAPI("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setTestOnClick$21() {
            ExamPrepLayer3Adapter.this.isSSCpattern = true;
            ExamPrepLayer3Adapter.this.startTestAPI("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setTestOnClick$22() {
            ExamPrepLayer3Adapter.this.isSSCpattern = false;
            ExamPrepLayer3Adapter.this.startTestAPI("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setTestOnClick$23() {
            ExamPrepLayer3Adapter.this.isSSCpattern = true;
            ExamPrepLayer3Adapter.this.startTestAPI("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setTestOnClick$25(Video video, View view) {
            if (!Helper.isConnected(ExamPrepLayer3Adapter.this.activity)) {
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                return;
            }
            if (ExamPrepLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                SharedPreference.getInstance().putString("id", ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
                ExamPrepLayer3Adapter.this.quiz_id = video.getId();
                if (video.getLang_used().equalsIgnoreCase("")) {
                    ExamPrepLayer3Adapter.this.lang = Integer.parseInt(String.valueOf(video.getLang_id().charAt(0)));
                } else {
                    ExamPrepLayer3Adapter.this.lang = Integer.parseInt(video.getLang_used());
                }
                ExamPrepLayer3Adapter.this.quiz_name = video.getTest_series_name();
                ExamPrepLayer3Adapter.this.totalQuestion = video.getTotal_questions();
                ExamPrepLayer3Adapter.this.first_attempt = "0";
                ExamPrepLayer3Adapter.this.result_date = video.getResult_date();
                ExamPrepLayer3Adapter.this.videopositonwise = video;
                ExamPrepLayer3Adapter.this.startResumeTestAPI();
                return;
            }
            if (video.getIs_locked().equalsIgnoreCase("1")) {
                if (isCourseSoldOut()) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, ExamPrepLayer3Adapter.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, ExamPrepLayer3Adapter.this.activity);
                return;
            }
            SharedPreference.getInstance().putString("id", ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
            ExamPrepLayer3Adapter.this.quiz_id = video.getId();
            ExamPrepLayer3Adapter.this.lang = Integer.parseInt(video.getLang_used());
            ExamPrepLayer3Adapter.this.quiz_name = video.getTest_series_name();
            ExamPrepLayer3Adapter.this.totalQuestion = video.getTotal_questions();
            ExamPrepLayer3Adapter.this.first_attempt = "0";
            ExamPrepLayer3Adapter.this.result_date = video.getResult_date();
            ExamPrepLayer3Adapter.this.videopositonwise = video;
            ExamPrepLayer3Adapter.this.startResumeTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setTestOnClick$26(Video video, View view) {
            if (!Helper.isConnected(ExamPrepLayer3Adapter.this.activity)) {
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                return;
            }
            if (ExamPrepLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                SharedPreference.getInstance().putString("id", ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
                if (video.getState().equalsIgnoreCase("1")) {
                    ExamPrepLayer3Adapter.this.quiz_id = video.getId();
                    ExamPrepLayer3Adapter.this.quiz_name = video.getTest_series_name();
                    ExamPrepLayer3Adapter.this.totalQuestion = video.getTotal_questions();
                    netoworkCallForQuizResult2(ExamPrepLayer3Adapter.this.quiz_id, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId(), "1", ExamPrepLayer3Adapter.this.quiz_name);
                    return;
                }
                ExamPrepLayer3Adapter.this.quiz_id = video.getId();
                ExamPrepLayer3Adapter.this.quiz_name = video.getTest_series_name();
                ExamPrepLayer3Adapter.this.totalQuestion = video.getTotal_questions();
                result_without_submit(ExamPrepLayer3Adapter.this.quiz_id, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId(), "0", ExamPrepLayer3Adapter.this.quiz_name);
                return;
            }
            if (video.getIs_locked().equalsIgnoreCase("1")) {
                if (isCourseSoldOut()) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, ExamPrepLayer3Adapter.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, ExamPrepLayer3Adapter.this.activity);
                return;
            }
            SharedPreference.getInstance().putString("id", ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
            if (video.getState().equalsIgnoreCase("1")) {
                ExamPrepLayer3Adapter.this.quiz_id = video.getId();
                ExamPrepLayer3Adapter.this.quiz_name = video.getTest_series_name();
                ExamPrepLayer3Adapter.this.totalQuestion = video.getTotal_questions();
                netoworkCallForQuizResult2(ExamPrepLayer3Adapter.this.quiz_id, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId(), "1", ExamPrepLayer3Adapter.this.quiz_name);
                return;
            }
            ExamPrepLayer3Adapter.this.quiz_id = video.getId();
            ExamPrepLayer3Adapter.this.quiz_name = video.getTest_series_name();
            ExamPrepLayer3Adapter.this.totalQuestion = video.getTotal_questions();
            result_without_submit(ExamPrepLayer3Adapter.this.quiz_id, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId(), "0", ExamPrepLayer3Adapter.this.quiz_name);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$setTestOnClick$27(Video video) {
            if (!ExamPrepLayer3Adapter.this.is_purchase.equalsIgnoreCase("1") && video.getIs_locked().equalsIgnoreCase("1")) {
                if (isCourseSoldOut()) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                    return null;
                }
                Intent intent = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, ExamPrepLayer3Adapter.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, ExamPrepLayer3Adapter.this.activity);
            } else {
                Helper.shareTestg(ExamPrepLayer3Adapter.this.activity, video.getPayloadData().getCourse_id(), video.getId(), video.getPayloadData().getTopic_id(), video.getPayloadData().getTile_type(), video.getPayloadData().getTile_id(), video.getPayloadData().getRevert_api(), Const.TEST, video.getImage(), video.getTitle(), SingleStudy.parentCourseId);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setTestOnClick$28(Video video, View view) {
            if (!Helper.isConnected(ExamPrepLayer3Adapter.this.activity)) {
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                return;
            }
            if (ExamPrepLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                SharedPreference.getInstance().putString("id", ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
                ExamPrepLayer3Adapter.this.quiz_id = video.getId();
                ExamPrepLayer3Adapter.this.quiz_name = video.getTest_series_name();
                ExamPrepLayer3Adapter.this.totalQuestion = video.getTotal_questions();
                if (video.getState().equalsIgnoreCase("1")) {
                    if (video.getResult_date().equalsIgnoreCase("") || video.getResult_date().equalsIgnoreCase("0") || video.getResult_date().equalsIgnoreCase("1")) {
                        Intent intent = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) QuizActivity.class);
                        intent.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                        intent.putExtra("status", ExamPrepLayer3Adapter.this.quiz_id);
                        intent.putExtra("name", ExamPrepLayer3Adapter.this.quiz_name);
                        intent.putExtra("cat_type", ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                        intent.putExtra("mode", video.getMode());
                        intent.putExtra("first_attempt", "1");
                        Helper.gotoActivity(intent, ExamPrepLayer3Adapter.this.activity);
                        return;
                    }
                    if (MakeMyExam.time_server >= Long.parseLong(video.getResult_date()) * 1000) {
                        Intent intent2 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) QuizActivity.class);
                        intent2.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                        intent2.putExtra("status", ExamPrepLayer3Adapter.this.quiz_id);
                        intent2.putExtra("name", ExamPrepLayer3Adapter.this.quiz_name);
                        intent2.putExtra("cat_type", ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                        intent2.putExtra("mode", video.getMode());
                        intent2.putExtra("first_attempt", "1");
                        Helper.gotoActivity(intent2, ExamPrepLayer3Adapter.this.activity);
                        return;
                    }
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.your_result_will_be_declare_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(video.getResult_date()) * 1000)), 0).show();
                    return;
                }
                if (video.getResult_date().equalsIgnoreCase("") || video.getResult_date().equalsIgnoreCase("0") || video.getResult_date().equalsIgnoreCase("1")) {
                    Intent intent3 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) QuizActivity.class);
                    intent3.putExtra(Const.FRAG_TYPE, "leader_board");
                    intent3.putExtra("cat_type", ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                    intent3.putExtra("status", ExamPrepLayer3Adapter.this.quiz_id);
                    intent3.putExtra("name", ExamPrepLayer3Adapter.this.quiz_name);
                    intent3.putExtra("mode", video.getMode());
                    Helper.gotoActivity(intent3, ExamPrepLayer3Adapter.this.activity);
                    return;
                }
                if (MakeMyExam.time_server >= Long.parseLong(video.getResult_date()) * 1000) {
                    Intent intent4 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) QuizActivity.class);
                    intent4.putExtra(Const.FRAG_TYPE, "leader_board");
                    intent4.putExtra("cat_type", ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                    intent4.putExtra("status", ExamPrepLayer3Adapter.this.quiz_id);
                    intent4.putExtra("name", ExamPrepLayer3Adapter.this.quiz_name);
                    intent4.putExtra("mode", video.getMode());
                    Helper.gotoActivity(intent4, ExamPrepLayer3Adapter.this.activity);
                    return;
                }
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.your_result_will_be_declare_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(video.getResult_date()) * 1000)), 0).show();
                return;
            }
            if (video.getIs_locked().equalsIgnoreCase("1")) {
                if (isCourseSoldOut()) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent5 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent5.putExtra(Const.SINGLE_STUDY, ExamPrepLayer3Adapter.this.singleStudy);
                intent5.putExtra(Const.IS_BOOK, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent5.putExtra(Const.DELIVERY_CHARGE, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent5, ExamPrepLayer3Adapter.this.activity);
                return;
            }
            if (video.getResult_date().equalsIgnoreCase("") || video.getResult_date().equalsIgnoreCase("0") || video.getResult_date().equalsIgnoreCase("1")) {
                ExamPrepLayer3Adapter.this.quiz_id = video.getId();
                ExamPrepLayer3Adapter.this.quiz_name = video.getTest_series_name();
                ExamPrepLayer3Adapter.this.totalQuestion = video.getTotal_questions();
                if (video.getState().equalsIgnoreCase("1")) {
                    Intent intent6 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) QuizActivity.class);
                    intent6.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                    intent6.putExtra("cat_type", ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                    intent6.putExtra("status", ExamPrepLayer3Adapter.this.quiz_id);
                    intent6.putExtra("name", ExamPrepLayer3Adapter.this.quiz_name);
                    intent6.putExtra("mode", video.getMode());
                    intent6.putExtra("first_attempt", "1");
                    ExamPrepLayer3Adapter.this.activity.startActivity(intent6);
                    return;
                }
                Intent intent7 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) QuizActivity.class);
                intent7.putExtra(Const.FRAG_TYPE, "leader_board");
                intent7.putExtra("cat_type", ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent7.putExtra("status", ExamPrepLayer3Adapter.this.quiz_id);
                intent7.putExtra("name", ExamPrepLayer3Adapter.this.quiz_name);
                intent7.putExtra("mode", video.getMode());
                ExamPrepLayer3Adapter.this.activity.startActivity(intent7);
                return;
            }
            if (MakeMyExam.time_server >= Long.parseLong(video.getResult_date()) * 1000) {
                ExamPrepLayer3Adapter.this.quiz_id = video.getId();
                ExamPrepLayer3Adapter.this.quiz_name = video.getTest_series_name();
                ExamPrepLayer3Adapter.this.totalQuestion = video.getTotal_questions();
                if (video.getState().equalsIgnoreCase("1")) {
                    Intent intent8 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) QuizActivity.class);
                    intent8.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                    intent8.putExtra("status", ExamPrepLayer3Adapter.this.quiz_id);
                    intent8.putExtra("name", ExamPrepLayer3Adapter.this.quiz_name);
                    intent8.putExtra("mode", video.getMode());
                    intent8.putExtra("first_attempt", "1");
                    intent8.putExtra("cat_type", ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                    ExamPrepLayer3Adapter.this.activity.startActivity(intent8);
                    return;
                }
                Intent intent9 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) QuizActivity.class);
                intent9.putExtra(Const.FRAG_TYPE, "leader_board");
                intent9.putExtra("cat_type", ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent9.putExtra("status", ExamPrepLayer3Adapter.this.quiz_id);
                intent9.putExtra("name", ExamPrepLayer3Adapter.this.quiz_name);
                intent9.putExtra("mode", video.getMode());
                ExamPrepLayer3Adapter.this.activity.startActivity(intent9);
                return;
            }
            Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.your_result_will_be_declare_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(video.getResult_date()) * 1000)), 0).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setTestOnClick$29(Video video, View view) {
            if (!Helper.isConnected(ExamPrepLayer3Adapter.this.activity)) {
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                return;
            }
            if (ExamPrepLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                SharedPreference.getInstance().putString("id", ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
                ExamPrepLayer3Adapter.this.quiz_id = video.getId();
                ExamPrepLayer3Adapter.this.quiz_name = video.getTest_series_name();
                ExamPrepLayer3Adapter.this.totalQuestion = video.getTotal_questions();
                if (video.getState().equalsIgnoreCase("1")) {
                    if (video.getResult_date().equalsIgnoreCase("") || video.getResult_date().equalsIgnoreCase("0") || video.getResult_date().equalsIgnoreCase("1")) {
                        Intent intent = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) QuizActivity.class);
                        intent.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                        intent.putExtra("status", ExamPrepLayer3Adapter.this.quiz_id);
                        intent.putExtra("name", ExamPrepLayer3Adapter.this.quiz_name);
                        intent.putExtra("first_attempt", "1");
                        Helper.gotoActivity(intent, ExamPrepLayer3Adapter.this.activity);
                        return;
                    }
                    if (MakeMyExam.time_server >= Long.parseLong(video.getResult_date()) * 1000) {
                        Intent intent2 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) QuizActivity.class);
                        intent2.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                        intent2.putExtra("status", ExamPrepLayer3Adapter.this.quiz_id);
                        intent2.putExtra("name", ExamPrepLayer3Adapter.this.quiz_name);
                        intent2.putExtra("first_attempt", "1");
                        Helper.gotoActivity(intent2, ExamPrepLayer3Adapter.this.activity);
                        return;
                    }
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.your_result_will_be_declare_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(video.getResult_date()) * 1000)), 0).show();
                    return;
                }
                if (video.getResult_date().equalsIgnoreCase("") || video.getResult_date().equalsIgnoreCase("0") || video.getResult_date().equalsIgnoreCase("1")) {
                    if (ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type().equalsIgnoreCase("3")) {
                        Toast.makeText(ExamPrepLayer3Adapter.this.activity, "Result not found", 0).show();
                        return;
                    }
                    Intent intent3 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) QuizActivity.class);
                    intent3.putExtra(Const.FRAG_TYPE, "leader_board");
                    intent3.putExtra("status", ExamPrepLayer3Adapter.this.quiz_id);
                    intent3.putExtra("name", ExamPrepLayer3Adapter.this.quiz_name);
                    Helper.gotoActivity(intent3, ExamPrepLayer3Adapter.this.activity);
                    return;
                }
                if (MakeMyExam.time_server >= Long.parseLong(video.getResult_date()) * 1000) {
                    if (ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type().equalsIgnoreCase("3")) {
                        Toast.makeText(ExamPrepLayer3Adapter.this.activity, "Result not found", 0).show();
                        return;
                    }
                    Intent intent4 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) QuizActivity.class);
                    intent4.putExtra(Const.FRAG_TYPE, "leader_board");
                    intent4.putExtra("status", ExamPrepLayer3Adapter.this.quiz_id);
                    intent4.putExtra("name", ExamPrepLayer3Adapter.this.quiz_name);
                    Helper.gotoActivity(intent4, ExamPrepLayer3Adapter.this.activity);
                    return;
                }
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.your_result_will_be_declare_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(video.getResult_date()) * 1000)), 0).show();
                return;
            }
            if (video.getIs_locked().equalsIgnoreCase("1")) {
                if (isCourseSoldOut()) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent5 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent5.putExtra(Const.SINGLE_STUDY, ExamPrepLayer3Adapter.this.singleStudy);
                intent5.putExtra(Const.IS_BOOK, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent5.putExtra(Const.DELIVERY_CHARGE, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent5, ExamPrepLayer3Adapter.this.activity);
                return;
            }
            if (video.getResult_date().equalsIgnoreCase("") || video.getResult_date().equalsIgnoreCase("0") || video.getResult_date().equalsIgnoreCase("1")) {
                ExamPrepLayer3Adapter.this.quiz_id = video.getId();
                ExamPrepLayer3Adapter.this.quiz_name = video.getTest_series_name();
                ExamPrepLayer3Adapter.this.totalQuestion = video.getTotal_questions();
                if (video.getState().equalsIgnoreCase("1")) {
                    Intent intent6 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) QuizActivity.class);
                    intent6.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                    intent6.putExtra("status", ExamPrepLayer3Adapter.this.quiz_id);
                    intent6.putExtra("name", ExamPrepLayer3Adapter.this.quiz_name);
                    intent6.putExtra("first_attempt", "1");
                    ExamPrepLayer3Adapter.this.activity.startActivity(intent6);
                    return;
                }
                Intent intent7 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) QuizActivity.class);
                intent7.putExtra(Const.FRAG_TYPE, "leader_board");
                intent7.putExtra("status", ExamPrepLayer3Adapter.this.quiz_id);
                intent7.putExtra("name", ExamPrepLayer3Adapter.this.quiz_name);
                ExamPrepLayer3Adapter.this.activity.startActivity(intent7);
                return;
            }
            if (MakeMyExam.time_server >= Long.parseLong(video.getResult_date()) * 1000) {
                ExamPrepLayer3Adapter.this.quiz_id = video.getId();
                ExamPrepLayer3Adapter.this.quiz_name = video.getTest_series_name();
                ExamPrepLayer3Adapter.this.totalQuestion = video.getTotal_questions();
                if (video.getState().equalsIgnoreCase("1")) {
                    Intent intent8 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) QuizActivity.class);
                    intent8.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                    intent8.putExtra("status", ExamPrepLayer3Adapter.this.quiz_id);
                    intent8.putExtra("name", ExamPrepLayer3Adapter.this.quiz_name);
                    intent8.putExtra("first_attempt", "1");
                    ExamPrepLayer3Adapter.this.activity.startActivity(intent8);
                    return;
                }
                Intent intent9 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) QuizActivity.class);
                intent9.putExtra(Const.FRAG_TYPE, "leader_board");
                intent9.putExtra("status", ExamPrepLayer3Adapter.this.quiz_id);
                intent9.putExtra("name", ExamPrepLayer3Adapter.this.quiz_name);
                ExamPrepLayer3Adapter.this.activity.startActivity(intent9);
                return;
            }
            Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.your_result_will_be_declare_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(video.getResult_date()) * 1000)), 0).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setTestOnClick$38(Video video, View view) {
            if (!Helper.isConnected(ExamPrepLayer3Adapter.this.activity)) {
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                return;
            }
            if (ExamPrepLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                SharedPreference.getInstance().putString("id", ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
                if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("RE-ATTEMPT")) {
                    ExamPrepLayer3Adapter.this.attemptOrReAttempt = "Re-attempt";
                    ExamPrepLayer3Adapter.this.quiz_id = video.getId();
                    ExamPrepLayer3Adapter.this.quiz_name = video.getTest_series_name();
                    ExamPrepLayer3Adapter.this.totalQuestion = video.getTotal_questions();
                    ExamPrepLayer3Adapter.this.first_attempt = "0";
                    ExamPrepLayer3Adapter.this.result_date = video.getResult_date();
                    ExamPrepLayer3Adapter.this.videopositonwise = video;
                    ExamPrepLayer3Adapter.this.result_date = video.getResult_date();
                    ExamPrepLayer3Adapter.this.result_date = video.getResult_date();
                    Helper.resolveTestPattern(ExamPrepLayer3Adapter.this.activity, video.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda23
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$setTestOnClick$30();
                        }
                    }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda24
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$setTestOnClick$31();
                        }
                    });
                    return;
                }
                if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("ATTEMPT NOW")) {
                    ExamPrepLayer3Adapter.this.attemptOrReAttempt = Const.ATTEMPT;
                    ExamPrepLayer3Adapter.this.quiz_id = video.getId();
                    ExamPrepLayer3Adapter.this.quiz_name = video.getTest_series_name();
                    ExamPrepLayer3Adapter.this.totalQuestion = video.getTotal_questions();
                    ExamPrepLayer3Adapter.this.first_attempt = "1";
                    ExamPrepLayer3Adapter.this.test_submission = video.getSubmission_type();
                    ExamPrepLayer3Adapter.this.result_date = video.getResult_date();
                    ExamPrepLayer3Adapter.this.videopositonwise = video;
                    Helper.resolveTestPattern(ExamPrepLayer3Adapter.this.activity, video.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda25
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$setTestOnClick$32();
                        }
                    }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda26
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$setTestOnClick$33();
                        }
                    });
                    return;
                }
                if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("ATTEMPTED")) {
                    if (video.getResult_date() != null && !video.getResult_date().equalsIgnoreCase("0") && !video.getResult_date().equalsIgnoreCase("1") && !video.getResult_date().equalsIgnoreCase("")) {
                        Snackbar.make(view, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.your_result_will_be_declare_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(video.getResult_date()) * 1000)), -1).show();
                        return;
                    } else if (ExamPrepLayer3Adapter.this.utkashRoom.getTestDao().is_test_exit(video.getId(), MakeMyExam.userId)) {
                        Snackbar.make(view, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.your_result_is_getting_ready_please_refresh_your_page), -1).show();
                        return;
                    } else {
                        Snackbar.make(view, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.your_test_has_already_been_submitted), -1).show();
                        return;
                    }
                }
                if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("VIEW RANK") || ((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("VIEW RESULT")) {
                    if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("VIEW RANK") && ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type().equalsIgnoreCase("3")) {
                        Toast.makeText(ExamPrepLayer3Adapter.this.activity, "No result found.", 0).show();
                        return;
                    }
                    ExamPrepLayer3Adapter.this.quiz_id = video.getId();
                    ExamPrepLayer3Adapter.this.quiz_name = video.getTest_series_name();
                    ExamPrepLayer3Adapter.this.totalQuestion = video.getTotal_questions();
                    if (video.getState().equalsIgnoreCase("1")) {
                        if (video.getResult_date() == null || video.getResult_date().equalsIgnoreCase("") || video.getResult_date().equalsIgnoreCase("0") || video.getResult_date().equalsIgnoreCase("1")) {
                            Intent intent = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) QuizActivity.class);
                            intent.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                            intent.putExtra("status", ExamPrepLayer3Adapter.this.quiz_id);
                            intent.putExtra("name", ExamPrepLayer3Adapter.this.quiz_name);
                            intent.putExtra("cat_type", ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                            intent.putExtra("first_attempt", "1");
                            Helper.gotoActivity(intent, ExamPrepLayer3Adapter.this.activity);
                            return;
                        }
                        Intent intent2 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) QuizActivity.class);
                        intent2.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                        intent2.putExtra("status", ExamPrepLayer3Adapter.this.quiz_id);
                        intent2.putExtra("name", ExamPrepLayer3Adapter.this.quiz_name);
                        intent2.putExtra("cat_type", ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                        intent2.putExtra("first_attempt", "1");
                        Helper.gotoActivity(intent2, ExamPrepLayer3Adapter.this.activity);
                        return;
                    }
                    Intent intent3 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) QuizActivity.class);
                    intent3.putExtra(Const.FRAG_TYPE, "leader_board");
                    intent3.putExtra("status", ExamPrepLayer3Adapter.this.quiz_id);
                    intent3.putExtra("name", ExamPrepLayer3Adapter.this.quiz_name);
                    intent3.putExtra("cat_type", ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                    Helper.gotoActivity(intent3, ExamPrepLayer3Adapter.this.activity);
                    return;
                }
                if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase(ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.upcoming_test))) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.test_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                    return;
                }
                return;
            }
            if (video.getIs_locked().equalsIgnoreCase("1")) {
                if (isCourseSoldOut()) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent4 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent4.putExtra(Const.SINGLE_STUDY, ExamPrepLayer3Adapter.this.singleStudy);
                intent4.putExtra(Const.IS_BOOK, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent4.putExtra(Const.DELIVERY_CHARGE, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent4, ExamPrepLayer3Adapter.this.activity);
                return;
            }
            SharedPreference.getInstance().putString("id", ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
            if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("RE-ATTEMPT")) {
                ExamPrepLayer3Adapter.this.quiz_id = video.getId();
                ExamPrepLayer3Adapter.this.quiz_name = video.getTest_series_name();
                ExamPrepLayer3Adapter.this.totalQuestion = video.getTotal_questions();
                ExamPrepLayer3Adapter.this.first_attempt = "0";
                ExamPrepLayer3Adapter.this.result_date = video.getResult_date();
                ExamPrepLayer3Adapter.this.videopositonwise = video;
                Helper.resolveTestPattern(ExamPrepLayer3Adapter.this.activity, video.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda27
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setTestOnClick$34();
                    }
                }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda28
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setTestOnClick$35();
                    }
                });
                return;
            }
            if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("ATTEMPT NOW")) {
                ExamPrepLayer3Adapter.this.quiz_id = video.getId();
                ExamPrepLayer3Adapter.this.quiz_name = video.getTest_series_name();
                ExamPrepLayer3Adapter.this.totalQuestion = video.getTotal_questions();
                ExamPrepLayer3Adapter.this.first_attempt = "1";
                ExamPrepLayer3Adapter.this.test_submission = video.getSubmission_type();
                ExamPrepLayer3Adapter.this.result_date = video.getResult_date();
                ExamPrepLayer3Adapter.this.videopositonwise = video;
                Helper.resolveTestPattern(ExamPrepLayer3Adapter.this.activity, video.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda29
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setTestOnClick$36();
                    }
                }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda30
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setTestOnClick$37();
                    }
                });
                return;
            }
            if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("VIEW RANK") || ((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("VIEW RESULT")) {
                ExamPrepLayer3Adapter.this.quiz_id = video.getId();
                ExamPrepLayer3Adapter.this.quiz_name = video.getTest_series_name();
                ExamPrepLayer3Adapter.this.totalQuestion = video.getTotal_questions();
                if (video.getState().equalsIgnoreCase("1")) {
                    Intent intent5 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) QuizActivity.class);
                    intent5.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                    intent5.putExtra("status", ExamPrepLayer3Adapter.this.quiz_id);
                    intent5.putExtra("name", ExamPrepLayer3Adapter.this.quiz_name);
                    intent5.putExtra("cat_type", ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                    intent5.putExtra("first_attempt", "1");
                    ExamPrepLayer3Adapter.this.activity.startActivity(intent5);
                    return;
                }
                Intent intent6 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) QuizActivity.class);
                intent6.putExtra(Const.FRAG_TYPE, "leader_board");
                intent6.putExtra("status", ExamPrepLayer3Adapter.this.quiz_id);
                intent6.putExtra("cat_type", ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent6.putExtra("name", ExamPrepLayer3Adapter.this.quiz_name);
                ExamPrepLayer3Adapter.this.activity.startActivity(intent6);
                return;
            }
            if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("ATTEMPTED")) {
                if (video.getResult_date() != null && !video.getResult_date().equalsIgnoreCase("0") && !video.getResult_date().equalsIgnoreCase("1") && !video.getResult_date().equalsIgnoreCase("")) {
                    Snackbar.make(view, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.your_result_will_be_declare_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(video.getResult_date()) * 1000)), -1).show();
                    return;
                } else if (ExamPrepLayer3Adapter.this.utkashRoom.getTestDao().is_test_exit(video.getId(), MakeMyExam.userId)) {
                    Snackbar.make(view, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.your_result_is_getting_ready_please_refresh_your_page), -1).show();
                    return;
                } else {
                    Snackbar.make(view, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.your_test_has_already_been_submitted), -1).show();
                    return;
                }
            }
            if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase(ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.upcoming_test))) {
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.test_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setTestOnClick$30() {
            ExamPrepLayer3Adapter.this.isSSCpattern = false;
            ExamPrepLayer3Adapter.this.startTestAPI("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setTestOnClick$31() {
            ExamPrepLayer3Adapter.this.isSSCpattern = true;
            ExamPrepLayer3Adapter.this.startTestAPI("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setTestOnClick$32() {
            ExamPrepLayer3Adapter.this.isSSCpattern = false;
            ExamPrepLayer3Adapter.this.startTestAPI(getAdapterPosition());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setTestOnClick$33() {
            ExamPrepLayer3Adapter.this.isSSCpattern = true;
            ExamPrepLayer3Adapter.this.startTestAPI(getAdapterPosition());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setTestOnClick$34() {
            ExamPrepLayer3Adapter.this.isSSCpattern = false;
            ExamPrepLayer3Adapter.this.startTestAPI("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setTestOnClick$35() {
            ExamPrepLayer3Adapter.this.isSSCpattern = true;
            ExamPrepLayer3Adapter.this.startTestAPI("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setTestOnClick$36() {
            ExamPrepLayer3Adapter.this.isSSCpattern = false;
            ExamPrepLayer3Adapter.this.startTestAPI(getAdapterPosition());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setTestOnClick$37() {
            ExamPrepLayer3Adapter.this.isSSCpattern = true;
            ExamPrepLayer3Adapter.this.startTestAPI(getAdapterPosition());
        }

        public void setSubjectiveTestOnClick(final Video video, final String fileType) {
            Constants.SUB_TEST_ID = video.getId();
            this.paper.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setSubjectiveTestOnClick$39(video, view);
                }
            });
            this.upload.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setSubjectiveTestOnClick$40(video, view);
                }
            });
            this.booklet.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda22
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setSubjectiveTestOnClick$41(video, view);
                }
            });
            this.marks.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda33
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setSubjectiveTestOnClick$42(video, fileType, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setSubjectiveTestOnClick$39(Video video, View view) {
            if (System.currentTimeMillis() < Long.parseLong(video.getStart_date()) * 1000) {
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.test_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                return;
            }
            if (!Helper.isConnected(ExamPrepLayer3Adapter.this.activity)) {
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                return;
            }
            if (ExamPrepLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                if (!video.getQuestion().equalsIgnoreCase("")) {
                    Constants.SUB_TEST_ID = video.getId();
                    video.getQuestion().split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r15.length - 1].split("\\.");
                    Helper.GoToWebViewPDFActivity(ExamPrepLayer3Adapter.this.activity, video.getId(), video.getQuestion(), true, video.getTitle(), SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId(), video.getIs_bookmarked(), video.getFile_type(), video.getIs_share(), Const.QUESTION);
                    return;
                }
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.file_not_found), 0).show();
                return;
            }
            if (video.getIs_locked().equalsIgnoreCase("1")) {
                if (isCourseSoldOut()) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, ExamPrepLayer3Adapter.this.singleStudy);
                Helper.gotoActivity(intent, ExamPrepLayer3Adapter.this.activity);
                return;
            }
            if (!video.getQuestion().equalsIgnoreCase("")) {
                Constants.SUB_TEST_ID = video.getId();
                video.getQuestion().split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r15.length - 1].split("\\.");
                Helper.GoToWebViewPDFActivity(ExamPrepLayer3Adapter.this.activity, video.getId(), video.getQuestion(), true, video.getTitle(), SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId(), video.getIs_bookmarked(), video.getFile_type(), video.getIs_share(), Const.QUESTION);
                return;
            }
            Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.file_not_found), 0).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setSubjectiveTestOnClick$40(Video video, View view) {
            if (this.upload.getText().toString().equalsIgnoreCase("View")) {
                Intent intent = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) PdfDetailScreen.class);
                intent.putExtra(Const.THUMBNAIL, video.getThumbnail_url());
                intent.putExtra("url", video.getAnswers_by_student());
                intent.putExtra("file_type", video.getFile_type());
                ExamPrepLayer3Adapter.this.activity.startActivity(intent);
                return;
            }
            if (System.currentTimeMillis() > Long.parseLong(video.getEnd_date()) * 1000 || MakeMyExam.time_server > Long.parseLong(video.getEnd_date()) * 1000) {
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.you_cant_upload_message), 0).show();
                return;
            }
            if (System.currentTimeMillis() < Long.parseLong(video.getStart_date()) * 1000 && MakeMyExam.time_server < Long.parseLong(video.getStart_date()) * 1000) {
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.test_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                return;
            }
            if (!Helper.isConnected(ExamPrepLayer3Adapter.this.activity)) {
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                return;
            }
            if (ExamPrepLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                if (video.getUpload_allowed() != null && video.getUpload_allowed().equalsIgnoreCase("1")) {
                    Constants.SUB_TEST_ID = video.getId();
                    checkStoragePermission();
                    return;
                } else {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.you_cant_upload_now), 0).show();
                    return;
                }
            }
            if (video.getIs_locked().equalsIgnoreCase("1")) {
                if (isCourseSoldOut()) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent2 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent2.putExtra(Const.SINGLE_STUDY, ExamPrepLayer3Adapter.this.singleStudy);
                Helper.gotoActivity(intent2, ExamPrepLayer3Adapter.this.activity);
                return;
            }
            if (video.getUpload_allowed() != null && video.getUpload_allowed().equalsIgnoreCase("1")) {
                Constants.SUB_TEST_ID = video.getId();
                checkStoragePermission();
            } else {
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.you_cant_upload_now), 0).show();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setSubjectiveTestOnClick$41(Video video, View view) {
            if (Long.parseLong(video.getResult_date()) * 1000 < Calendar.getInstance().getTimeInMillis()) {
                if (!Helper.isConnected(ExamPrepLayer3Adapter.this.activity)) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                    return;
                }
                if (ExamPrepLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                    if (!video.getAnswers().equalsIgnoreCase("")) {
                        Constants.SUB_TEST_ID = video.getId();
                        Helper.GoToWebViewPDFActivity(ExamPrepLayer3Adapter.this.activity, video.getId(), video.getAnswers(), true, video.getAnswers().split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r15.length - 1].split("\\.")[0], SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId(), video.getIs_bookmarked(), video.getFile_type(), video.getIs_share(), Const.ANSWER);
                        return;
                    }
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.file_not_found), 0).show();
                    return;
                }
                if (video.getIs_locked().equalsIgnoreCase("1")) {
                    if (isCourseSoldOut()) {
                        Toast.makeText(ExamPrepLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                        return;
                    }
                    Intent intent = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                    intent.putExtra(Const.SINGLE_STUDY, ExamPrepLayer3Adapter.this.singleStudy);
                    Helper.gotoActivity(intent, ExamPrepLayer3Adapter.this.activity);
                    return;
                }
                if (!video.getAnswers().equalsIgnoreCase("")) {
                    Constants.SUB_TEST_ID = video.getId();
                    Helper.GoToWebViewPDFActivity(ExamPrepLayer3Adapter.this.activity, video.getId(), video.getAnswers(), true, video.getAnswers().split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r15.length - 1].split("\\.")[0], SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId(), video.getIs_bookmarked(), video.getFile_type(), video.getIs_share(), Const.ANSWER);
                    return;
                }
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.file_not_found), 0).show();
                return;
            }
            Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.result_will_be_available_on) + new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video.getResult_date()) * 1000)), 0).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setSubjectiveTestOnClick$42(Video video, String str, View view) {
            if (Long.parseLong(video.getResult_date()) * 1000 < System.currentTimeMillis()) {
                if (!Helper.isConnected(ExamPrepLayer3Adapter.this.activity)) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                    return;
                }
                if (ExamPrepLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                    Constants.SUB_TEST_ID = video.getId();
                    Helper.GoToSubjectiveResultActivity(ExamPrepLayer3Adapter.this.activity, video.getSolutions(), video.getTest_series_name(), ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId(), video.getId(), video.getFile_type().equalsIgnoreCase("st") ? Const.SUBJECTIVE_TEST : str);
                    return;
                } else {
                    if (video.getIs_locked().equalsIgnoreCase("1")) {
                        if (isCourseSoldOut()) {
                            Toast.makeText(ExamPrepLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                            return;
                        }
                        Intent intent = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                        intent.putExtra(Const.SINGLE_STUDY, ExamPrepLayer3Adapter.this.singleStudy);
                        Helper.gotoActivity(intent, ExamPrepLayer3Adapter.this.activity);
                        return;
                    }
                    Constants.SUB_TEST_ID = video.getId();
                    Helper.GoToSubjectiveResultActivity(ExamPrepLayer3Adapter.this.activity, video.getSolutions(), video.getTest_series_name(), ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId(), video.getId(), video.getFile_type().equalsIgnoreCase("st") ? Const.SUBJECTIVE_TEST : str);
                    return;
                }
            }
            Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.result_will_be_available_on) + new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video.getResult_date()) * 1000)), 0).show();
        }

        private void checkStoragePermission() {
            OpenChooser();
        }

        private void OpenChooser() {
            if (ExamPrepLayer3Adapter.this.STORAGE_PERMISSION_TYPE == 3) {
                Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType("application/pdf");
                intent.putExtra("download_file", true);
                intent.putExtra(Const.IS_DOWNLOAD, true);
                intent.putExtra("android.provider.extra.INITIAL_URI", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath());
                if (ExamPrepLayer3Adapter.this.activity instanceof CourseActivity) {
                    ((CourseActivity) ExamPrepLayer3Adapter.this.activity).requestCode = 1203;
                    ((CourseActivity) ExamPrepLayer3Adapter.this.activity).someActivityResultLauncher.launch(Intent.createChooser(intent, "Select PDF file"));
                } else {
                    ((FolderActivity) ExamPrepLayer3Adapter.this.activity).setRequestCode(1203);
                    ((FolderActivity) ExamPrepLayer3Adapter.this.activity).getSomeActivityResultLauncher().launch(Intent.createChooser(intent, "Select PDF file"));
                }
            }
        }

        public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
            if (requestCode == 123) {
                for (int i : grantResults) {
                    if (i != 0) {
                        ExamPrepLayer3Adapter.this.multiplePermissionCounter++;
                        if (ExamPrepLayer3Adapter.this.multiplePermissionCounter >= 2) {
                            return;
                        }
                        AppPermissionsRunTime.checkPermission(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.myPermissionConstantsArrayList, 123);
                        return;
                    }
                }
                if (ExamPrepLayer3Adapter.this.PERMISSION_TYPE != 1 && ExamPrepLayer3Adapter.this.PERMISSION_TYPE == 2) {
                    OpenChooser();
                }
            }
        }

        public void result_without_submit(final String quiz_id, String course_id, String s, final String quiz_name) {
            if (Helper.isNetworkConnected(ExamPrepLayer3Adapter.this.activity)) {
                Helper.showProgressDialog(ExamPrepLayer3Adapter.this.activity);
                APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setTest_id(quiz_id);
                encryptionData.setCourse_id(course_id);
                encryptionData.setFirst_attempt(s);
                aPIInterface.getTestlearn(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new Callback<String>() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter.SubjectVideosHolder.3
                    @Override // retrofit2.Callback
                    public void onFailure(Call<String> call, Throwable t) {
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<String> call, Response<String> response) {
                        JSONObject jSONObject;
                        Helper.dismissProgressDialog();
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
                                Helper.showToastSecurity(ExamPrepLayer3Adapter.this.activity);
                                return;
                            }
                            try {
                                if (resultTestSeries_Report.getStatus().equalsIgnoreCase("true")) {
                                    SharedPreference.getInstance().putString("testresult", new Gson().toJson(resultTestSeries_Report));
                                    Intent intent = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) ViewSolutionActivity.class);
                                    intent.putExtra(Const.TESTSEGMENT_ID, quiz_id);
                                    intent.putExtra(Const.FRAG_TYPE, Const.SOLUTIONREPORT);
                                    intent.putExtra("name", quiz_name);
                                    intent.putExtra("type", "learn");
                                    if (!resultTestSeries_Report.getData().getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("1")) {
                                        if (resultTestSeries_Report.getData().getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("2")) {
                                            ExamPrepLayer3Adapter.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
                                        }
                                    } else {
                                        ExamPrepLayer3Adapter.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
                                    }
                                    intent.putExtra(Const.LANG, ExamPrepLayer3Adapter.this.lang);
                                    Helper.gotoActivity(intent, ExamPrepLayer3Adapter.this.activity);
                                    return;
                                }
                                RetrofitResponse.GetApiData(ExamPrepLayer3Adapter.this.activity, jSONObject.optString("auth_code"), jSONObject.optString("message"), false);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                });
                return;
            }
            Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.Retry_with_Internet_connection), 1).show();
        }

        public void netoworkCallForQuizResult2(final String quiz_id, String course_id, String s, final String quiz_name) {
            if (Helper.isNetworkConnected(ExamPrepLayer3Adapter.this.activity)) {
                Helper.showProgressDialog(ExamPrepLayer3Adapter.this.activity);
                APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setTest_id(quiz_id);
                encryptionData.setCourse_id(course_id);
                encryptionData.setFirst_attempt(s);
                aPIInterface.getTestResult(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new Callback<String>() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter.SubjectVideosHolder.4
                    @Override // retrofit2.Callback
                    public void onResponse(Call<String> call, Response<String> response) {
                        JSONObject jSONObject;
                        Helper.dismissProgressDialog();
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
                                Helper.showToastSecurity(ExamPrepLayer3Adapter.this.activity);
                                return;
                            }
                            try {
                                if (resultTestSeries_Report.getData().getQuestions() != null && resultTestSeries_Report.getStatus().equalsIgnoreCase("true")) {
                                    if (resultTestSeries_Report.getData().getQuestions().size() <= 0 && resultTestSeries_Report.getData().getQuestionsHindi().size() <= 0) {
                                        Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.no_question_found), 0).show();
                                        return;
                                    }
                                    SharedPreference.getInstance().putString("testresult", new Gson().toJson(resultTestSeries_Report));
                                    Intent intent = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) ViewSolutionActivity.class);
                                    intent.putExtra(Const.TESTSEGMENT_ID, quiz_id);
                                    intent.putExtra(Const.FRAG_TYPE, Const.SOLUTIONREPORT);
                                    intent.putExtra("name", quiz_name);
                                    intent.putExtra("type", "learn");
                                    if (!resultTestSeries_Report.getData().getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("1")) {
                                        if (resultTestSeries_Report.getData().getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("2")) {
                                            ExamPrepLayer3Adapter.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
                                        }
                                    } else {
                                        ExamPrepLayer3Adapter.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
                                    }
                                    intent.putExtra(Const.LANG, ExamPrepLayer3Adapter.this.lang);
                                    Helper.gotoActivity(intent, ExamPrepLayer3Adapter.this.activity);
                                    return;
                                }
                                RetrofitResponse.GetApiData(ExamPrepLayer3Adapter.this.activity, jSONObject.optString("auth_code"), jSONObject.optString("message"), false);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }

                    @Override // retrofit2.Callback
                    public void onFailure(Call<String> call, Throwable t) {
                        Helper.dismissProgressDialog();
                    }
                });
                return;
            }
            Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.Retry_with_Internet_connection), 1).show();
        }

        public void setImageOnClick(final Video video) {
            if (!Helper.isConnected(ExamPrepLayer3Adapter.this.activity)) {
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
            } else {
                this.study_single_itemLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setImageOnClick$43(video, view);
                    }
                });
                this.read_now.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setImageOnClick$44(video, view);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setImageOnClick$43(Video video, View view) {
            if (ExamPrepLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                if (TextUtils.isEmpty(video.getFile_url()) && TextUtils.isEmpty(video.getId())) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.no_image_found), 0).show();
                    return;
                }
                Intent intent = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) WebViewActivty.class);
                intent.putExtra("type", video.getTitle());
                intent.putExtra("url", video.getFile_url());
                intent.putExtra("download_available", video.getIs_download_available());
                intent.putExtra("file_type", "image");
                Helper.gotoActivity(intent, ExamPrepLayer3Adapter.this.activity);
                return;
            }
            if (video.getIs_locked().equalsIgnoreCase("1")) {
                if (isCourseSoldOut()) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent2 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent2.putExtra(Const.SINGLE_STUDY, ExamPrepLayer3Adapter.this.singleStudy);
                intent2.putExtra(Const.IS_BOOK, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent2.putExtra(Const.DELIVERY_CHARGE, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent2, ExamPrepLayer3Adapter.this.activity);
                return;
            }
            if (TextUtils.isEmpty(video.getFile_url()) && TextUtils.isEmpty(video.getId())) {
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.no_image_found), 0).show();
                return;
            }
            Intent intent3 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) WebViewActivty.class);
            intent3.putExtra("type", video.getTitle());
            intent3.putExtra("url", video.getFile_url());
            intent3.putExtra("download_available", video.getIs_download_available());
            intent3.putExtra("file_type", "image");
            Helper.gotoActivity(intent3, ExamPrepLayer3Adapter.this.activity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setImageOnClick$44(Video video, View view) {
            if (ExamPrepLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                if (TextUtils.isEmpty(video.getFile_url()) && TextUtils.isEmpty(video.getId())) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.no_image_found), 0).show();
                    return;
                }
                Intent intent = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) WebViewActivty.class);
                intent.putExtra("type", video.getTitle());
                intent.putExtra("url", video.getFile_url());
                intent.putExtra("download_available", video.getIs_download_available());
                intent.putExtra("file_type", "image");
                Helper.gotoActivity(intent, ExamPrepLayer3Adapter.this.activity);
                return;
            }
            if (video.getIs_locked().equalsIgnoreCase("1")) {
                if (isCourseSoldOut()) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent2 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent2.putExtra(Const.SINGLE_STUDY, ExamPrepLayer3Adapter.this.singleStudy);
                intent2.putExtra(Const.IS_BOOK, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent2.putExtra(Const.DELIVERY_CHARGE, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent2, ExamPrepLayer3Adapter.this.activity);
                return;
            }
            if (TextUtils.isEmpty(video.getFile_url()) && TextUtils.isEmpty(video.getId())) {
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.no_image_found), 0).show();
                return;
            }
            Intent intent3 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) WebViewActivty.class);
            intent3.putExtra("type", video.getTitle());
            intent3.putExtra("url", video.getFile_url());
            intent3.putExtra("download_available", video.getIs_download_available());
            intent3.putExtra("file_type", "image");
            Helper.gotoActivity(intent3, ExamPrepLayer3Adapter.this.activity);
        }

        public void setConceptOnClick(final Video video) {
            if (!Helper.isConnected(ExamPrepLayer3Adapter.this.activity)) {
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                return;
            }
            this.read_now.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setConceptOnClick$45(video, view);
                }
            });
            this.study_single_itemLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setConceptOnClick$46(video, view);
                }
            });
            this.share.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$SubjectVideosHolder$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$setConceptOnClick$47(video);
                }
            }));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setConceptOnClick$45(Video video, View view) {
            if (ExamPrepLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                Intent intent = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) Concept_newActivity.class);
                intent.putExtra("id", video.getId());
                intent.putExtra("name", video.getTitle());
                if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                    intent.putExtra("course_id", ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD);
                } else {
                    intent.putExtra("course_id", SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
                }
                intent.putExtra(StoreProvider.StoreData.MODIFIED_DATE, video.getModified());
                intent.putExtra("tile_id", ExamPrepLayer3Adapter.this.tile_id);
                Helper.gotoActivity(intent, ExamPrepLayer3Adapter.this.activity);
                return;
            }
            if (video.getIs_locked().equalsIgnoreCase("1")) {
                if (isCourseSoldOut()) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent2 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent2.putExtra(Const.SINGLE_STUDY, ExamPrepLayer3Adapter.this.singleStudy);
                intent2.putExtra(Const.IS_BOOK, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent2.putExtra(Const.DELIVERY_CHARGE, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent2, ExamPrepLayer3Adapter.this.activity);
                return;
            }
            Intent intent3 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) Concept_newActivity.class);
            intent3.putExtra("id", video.getId());
            intent3.putExtra("name", video.getTitle());
            if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                intent3.putExtra("course_id", ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD);
            } else {
                intent3.putExtra("course_id", SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
            }
            intent3.putExtra(StoreProvider.StoreData.MODIFIED_DATE, video.getModified());
            intent3.putExtra("tile_id", ExamPrepLayer3Adapter.this.tile_id);
            Helper.gotoActivity(intent3, ExamPrepLayer3Adapter.this.activity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setConceptOnClick$46(Video video, View view) {
            if (ExamPrepLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                Intent intent = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) Concept_newActivity.class);
                intent.putExtra("id", video.getId());
                intent.putExtra("name", video.getTitle());
                if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                    intent.putExtra("course_id", ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD);
                } else {
                    intent.putExtra("course_id", SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
                }
                intent.putExtra(StoreProvider.StoreData.MODIFIED_DATE, video.getModified());
                intent.putExtra("tile_id", ExamPrepLayer3Adapter.this.tile_id);
                Helper.gotoActivity(intent, ExamPrepLayer3Adapter.this.activity);
                return;
            }
            if (video.getIs_locked().equalsIgnoreCase("1")) {
                if (isCourseSoldOut()) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent2 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent2.putExtra(Const.SINGLE_STUDY, ExamPrepLayer3Adapter.this.singleStudy);
                intent2.putExtra(Const.IS_BOOK, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent2.putExtra(Const.DELIVERY_CHARGE, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent2, ExamPrepLayer3Adapter.this.activity);
                return;
            }
            Intent intent3 = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) Concept_newActivity.class);
            intent3.putExtra("id", video.getId());
            intent3.putExtra("name", video.getTitle());
            if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                intent3.putExtra("course_id", ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD);
            } else {
                intent3.putExtra("course_id", SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
            }
            intent3.putExtra(StoreProvider.StoreData.MODIFIED_DATE, video.getModified());
            intent3.putExtra("tile_id", ExamPrepLayer3Adapter.this.tile_id);
            Helper.gotoActivity(intent3, ExamPrepLayer3Adapter.this.activity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$setConceptOnClick$47(Video video) {
            if (ExamPrepLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                if (video.getFile_type().equalsIgnoreCase("8") || video.getFile_type().equalsIgnoreCase("7") || video.getFile_type().equalsIgnoreCase("1")) {
                    Helper.sharePdf(ExamPrepLayer3Adapter.this.activity, video.getPayloadData().getCourse_id(), video.getId(), video.getPayloadData().getTopic_id(), video.getPayloadData().getTile_type(), video.getPayloadData().getTile_id(), video.getPayloadData().getRevert_api(), Const.PDF, video.getThumbnail_url(), video.getTitle(), SingleStudy.parentCourseId);
                }
            } else if (video.getIs_locked().equalsIgnoreCase("1")) {
                if (isCourseSoldOut()) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                    return null;
                }
                Intent intent = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, ExamPrepLayer3Adapter.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, ExamPrepLayer3Adapter.this.activity);
            } else if (video.getFile_type().equalsIgnoreCase("8") || video.getFile_type().equalsIgnoreCase("7") || video.getFile_type().equalsIgnoreCase("1")) {
                Helper.sharePdf(ExamPrepLayer3Adapter.this.activity, video.getPayloadData().getCourse_id(), video.getId(), video.getPayloadData().getTopic_id(), video.getPayloadData().getTile_type(), video.getPayloadData().getTile_id(), video.getPayloadData().getRevert_api(), Const.PDF, video.getThumbnail_url(), video.getTitle(), SingleStudy.parentCourseId);
            }
            return null;
        }

        private void API_REQUEST_VIDEO_LINK(final Video videoData, int position) {
            if (videoData.getFile_type().equalsIgnoreCase("10")) {
                ExamPrepLayer3Adapter.this.activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + videoData.getFile_url())));
                return;
            }
            if (videoData.getVideo_type().equalsIgnoreCase("5")) {
                if (videoData.getLive_status().equalsIgnoreCase("1")) {
                    if (videoData.getId() == null || videoData.getId().equalsIgnoreCase("")) {
                        Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                        return;
                    } else {
                        Helper.GoToLiveAwsVideoActivity(videoData.getVideo_type(), videoData.getChat_node(), ExamPrepLayer3Adapter.this.activity, videoData.getId(), videoData.getVideo_type(), videoData.getId(), videoData.getTitle(), "0", videoData.getThumbnail_url(), videoData.getPayloadData().getCourse_id(), videoData.getPayloadData().getTile_id(), videoData.getPayloadData().getTile_type(), videoData.getIs_chat_lock(), String.valueOf(position), SingleStudy.parentCourseId, videoData.getStart_date(), ExamPrepLayer3Adapter.this.videoArrayListAuto);
                        return;
                    }
                }
                if (videoData.getLive_status().equalsIgnoreCase("0")) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(videoData.getStart_date()) * 1000)), 0).show();
                    return;
                } else if (videoData.getLive_status().equalsIgnoreCase("2")) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                    return;
                } else {
                    if (videoData.getLive_status().equalsIgnoreCase("3")) {
                        Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                        return;
                    }
                    return;
                }
            }
            if (videoData.getVideo_type().equalsIgnoreCase("0")) {
                Helper.GoToLiveAwsVideoActivity(videoData.getVideo_type(), videoData.getChat_node(), ExamPrepLayer3Adapter.this.activity, videoData.getId(), videoData.getVideo_type(), videoData.getId(), videoData.getTitle(), "0", videoData.getThumbnail_url(), videoData.getPayloadData().getCourse_id(), videoData.getPayloadData().getTile_id(), videoData.getPayloadData().getTile_type(), videoData.getIs_chat_lock(), String.valueOf(position), SingleStudy.parentCourseId, videoData.getStart_date(), ExamPrepLayer3Adapter.this.videoArrayListAuto);
                return;
            }
            if (videoData.getVideo_type().equalsIgnoreCase("6")) {
                if (!videoData.getFile_url().equalsIgnoreCase("") && videoData.getFile_url().contains("content.jwplatform.com") && videoData.getFile_url().contains(".mp4")) {
                    String str = "https://cdn.jwplayer.com/v2/media/" + videoData.getFile_url().substring(videoData.getFile_url().lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1, videoData.getFile_url().indexOf("-"));
                    if (ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().isvideo_exit(videoData.getId(), MakeMyExam.userId)) {
                        VideosDownload videosDownload = ExamPrepLayer3Adapter.this.utkashRoom.getvideoDownloadao().getvideo_byuserid(videoData.getId(), MakeMyExam.userId);
                        if (videosDownload.getIs_complete().equalsIgnoreCase("1")) {
                            Intent intent = new Intent(ExamPrepLayer3Adapter.this.activity, (Class<?>) DownloadVideoPlayer.class);
                            intent.putExtra("video_name", videosDownload.getVideo_name());
                            intent.putExtra(Const.VIDEO_ID, videosDownload.getVideo_id());
                            intent.putExtra("current_pos", videosDownload.getVideoCurrentPosition());
                            intent.putExtra("video", videosDownload.getVideo_history());
                            intent.putExtra("video_time", videosDownload.getVideotime());
                            intent.putExtra("course_id", videosDownload.getCourse_id());
                            ExamPrepLayer3Adapter.this.activity.startActivity(intent);
                            return;
                        }
                        if (ExamPrepLayer3Adapter.this.utkashRoom.getvideoDao().isvideo_exit(videoData.getId(), MakeMyExam.userId)) {
                            if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                                Helper.GoToJWVideo_Params(ExamPrepLayer3Adapter.this.activity, str, videoData.getId(), videoData.getTitle(), ExamPrepLayer3Adapter.this.utkashRoom.getvideoDao().getuser(videoData.getId(), MakeMyExam.userId).getVideo_currentpos(), ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD);
                                return;
                            } else {
                                Helper.GoToJWVideo_Params(ExamPrepLayer3Adapter.this.activity, str, videoData.getId(), videoData.getTitle(), ExamPrepLayer3Adapter.this.utkashRoom.getvideoDao().getuser(videoData.getId(), MakeMyExam.userId).getVideo_currentpos(), SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
                                return;
                            }
                        }
                        VideoTable videoTable = new VideoTable();
                        videoTable.setVideo_id(videoData.getId());
                        videoTable.setVideo_name(videoData.getTitle());
                        videoTable.setJw_url(str);
                        videoTable.setVideo_currentpos(0L);
                        videoTable.setUser_id(MakeMyExam.userId);
                        if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                            videoTable.setCourse_id(ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD);
                        } else {
                            videoTable.setCourse_id(SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
                        }
                        ExamPrepLayer3Adapter.this.utkashRoom.getvideoDao().addUser(videoTable);
                        if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                            Helper.GoToJWVideo_Params(ExamPrepLayer3Adapter.this.activity, str, videoData.getId(), videoData.getTitle(), 0L, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD);
                            return;
                        } else {
                            Helper.GoToJWVideo_Params(ExamPrepLayer3Adapter.this.activity, str, videoData.getId(), videoData.getTitle(), 0L, SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
                            return;
                        }
                    }
                    if (ExamPrepLayer3Adapter.this.utkashRoom.getvideoDao().isvideo_exit(videoData.getId(), MakeMyExam.userId)) {
                        if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                            Helper.GoToJWVideo_Params(ExamPrepLayer3Adapter.this.activity, str, videoData.getId(), videoData.getTitle(), ExamPrepLayer3Adapter.this.utkashRoom.getvideoDao().getuser(videoData.getId(), MakeMyExam.userId).getVideo_currentpos(), ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD);
                            return;
                        } else {
                            Helper.GoToJWVideo_Params(ExamPrepLayer3Adapter.this.activity, str, videoData.getId(), videoData.getTitle(), ExamPrepLayer3Adapter.this.utkashRoom.getvideoDao().getuser(videoData.getId(), MakeMyExam.userId).getVideo_currentpos(), SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
                            return;
                        }
                    }
                    VideoTable videoTable2 = new VideoTable();
                    videoTable2.setVideo_id(videoData.getId());
                    videoTable2.setVideo_name(videoData.getTitle());
                    videoTable2.setJw_url(str);
                    videoTable2.setVideo_currentpos(0L);
                    videoTable2.setUser_id(MakeMyExam.userId);
                    if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                        videoTable2.setCourse_id(ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD);
                        Helper.GoToJWVideo_Params(ExamPrepLayer3Adapter.this.activity, str, videoData.getId(), videoData.getTitle(), 0L, ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD);
                        ExamPrepLayer3Adapter.this.utkashRoom.getvideoDao().addUser(videoTable2);
                        return;
                    } else {
                        videoTable2.setCourse_id(SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
                        Helper.GoToJWVideo_Params(ExamPrepLayer3Adapter.this.activity, str, videoData.getId(), videoData.getTitle(), 0L, SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + ExamPrepLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
                        ExamPrepLayer3Adapter.this.utkashRoom.getvideoDao().addUser(videoTable2);
                        return;
                    }
                }
                Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.no_url_found), 0).show();
                return;
            }
            if (videoData.getVideo_type().equalsIgnoreCase("1")) {
                Helper.audio_service_close(ExamPrepLayer3Adapter.this.activity);
                if (videoData.getOpen_in_app() != null && videoData.getOpen_in_app().equalsIgnoreCase("1")) {
                    if (SharedPreference.getInstance().getString(Const.Youtube_Player_Control).equalsIgnoreCase("2") || SharedPreference.getInstance().getString(Const.Youtube_Player_Control).equalsIgnoreCase("3")) {
                        Helper.showStreamSelectionBottomSheet(ExamPrepLayer3Adapter.this.activity, videoData, position, ExamPrepLayer3Adapter.this.videoArrayListAuto);
                        return;
                    } else {
                        Helper.GoToLiveVideoActivity(videoData.getChat_node(), ExamPrepLayer3Adapter.this.activity, videoData.getFile_url(), videoData.getVideo_type(), videoData.getId(), videoData.getTitle(), "0", videoData.getThumbnail_url(), videoData.getIs_chat_lock(), videoData.getPayloadData().getCourse_id(), String.valueOf(position), SingleStudy.parentCourseId, videoData.getPayloadData().getTile_id(), videoData.getPayloadData().getTile_type(), videoData.getIs_bookmarked(), videoData.getIs_live(), ExamPrepLayer3Adapter.this.videoArrayListAuto);
                        return;
                    }
                }
                ExamPrepLayer3Adapter.this.activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + videoData.getFile_url())));
                return;
            }
            if (videoData.getVideo_type().equalsIgnoreCase("4")) {
                Helper.audio_service_close(ExamPrepLayer3Adapter.this.activity);
                if (videoData.getLive_status().equalsIgnoreCase("1")) {
                    if (videoData.getFile_url() == null || videoData.getFile_url().equalsIgnoreCase("")) {
                        Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                        return;
                    }
                    if (videoData.getOpen_in_app() != null && videoData.getOpen_in_app().equalsIgnoreCase("1")) {
                        if (SharedPreference.getInstance().getString(Const.Youtube_Player_Control).equalsIgnoreCase("2") || SharedPreference.getInstance().getString(Const.Youtube_Player_Control).equalsIgnoreCase("3")) {
                            Helper.showStreamSelectionBottomSheet(ExamPrepLayer3Adapter.this.activity, videoData, position, ExamPrepLayer3Adapter.this.videoArrayListAuto);
                            return;
                        } else {
                            Helper.GoToLiveVideoActivity(videoData.getChat_node(), ExamPrepLayer3Adapter.this.activity, videoData.getFile_url(), videoData.getVideo_type(), videoData.getId(), videoData.getTitle(), "0", videoData.getThumbnail_url(), videoData.getIs_chat_lock(), videoData.getPayloadData().getCourse_id(), String.valueOf(position), SingleStudy.parentCourseId, videoData.getPayloadData().getTile_id(), videoData.getPayloadData().getTile_type(), videoData.getIs_bookmarked(), videoData.getIs_live(), ExamPrepLayer3Adapter.this.videoArrayListAuto);
                            return;
                        }
                    }
                    ExamPrepLayer3Adapter.this.activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + videoData.getFile_url())));
                    return;
                }
                if (videoData.getLive_status().equalsIgnoreCase("0")) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(videoData.getStart_date()) * 1000)), 0).show();
                    return;
                } else if (videoData.getLive_status().equalsIgnoreCase("2")) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                    return;
                } else {
                    if (videoData.getLive_status().equalsIgnoreCase("3")) {
                        Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                        return;
                    }
                    return;
                }
            }
            if (videoData.getVideo_type().equalsIgnoreCase("7")) {
                if (videoData.getIs_drm().equals("0")) {
                    if (((videoData.getId() == null || videoData.getId().equalsIgnoreCase("")) && videoData.getFile_url() == null) || videoData.getFile_url().equalsIgnoreCase("")) {
                        Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                        return;
                    } else {
                        Helper.GoToLiveAwsVideoActivity1(videoData.getVideo_type(), videoData.getChat_node(), ExamPrepLayer3Adapter.this.activity, videoData.getFile_url(), videoData.getVideo_type(), videoData.getId(), videoData.getTitle(), "0", videoData.getThumbnail_url(), videoData.getPayloadData().getCourse_id(), videoData.getPayloadData().getTile_id(), videoData.getPayloadData().getTile_type(), videoData.getIs_chat_lock(), String.valueOf(position), SingleStudy.parentCourseId, videoData.getIs_bookmarked(), ExamPrepLayer3Adapter.this.videoArrayListAuto);
                        return;
                    }
                }
                if (videoData.getIs_drm().equals("1")) {
                    if (videoData.getId() == null || videoData.getId().equalsIgnoreCase("")) {
                        Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                        return;
                    } else {
                        Helper.GoToVideoCryptActivity(ExamPrepLayer3Adapter.this.activity, videoData.getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), videoData.getVideo_type(), videoData.getChat_node(), videoData.getId(), videoData.getVideo_type(), videoData.getId(), videoData.getTitle(), "0", videoData.getThumbnail_url(), videoData.getPayloadData().getCourse_id(), videoData.getPayloadData().getTile_id(), videoData.getPayloadData().getTile_type(), videoData.getIs_chat_lock(), String.valueOf(position), SingleStudy.parentCourseId, videoData.getStart_date(), videoData.getIs_bookmarked(), ExamPrepLayer3Adapter.this.videoArrayListAuto);
                        return;
                    }
                }
                return;
            }
            if (videoData.getVideo_type().equalsIgnoreCase("8")) {
                if (videoData.getIs_drm().equals("0")) {
                    if (videoData.getLive_status().equalsIgnoreCase("1")) {
                        if (videoData.getId() == null || videoData.getId().equalsIgnoreCase("")) {
                            Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                            return;
                        } else {
                            Helper.GoToLiveAwsVideoActivity(videoData.getVideo_type(), videoData.getChat_node(), ExamPrepLayer3Adapter.this.activity, videoData.getId(), videoData.getVideo_type(), videoData.getId(), videoData.getTitle(), "0", videoData.getThumbnail_url(), videoData.getPayloadData().getCourse_id(), videoData.getPayloadData().getTile_id(), videoData.getPayloadData().getTile_type(), videoData.getIs_chat_lock(), String.valueOf(position), SingleStudy.parentCourseId, videoData.getStart_date(), ExamPrepLayer3Adapter.this.videoArrayListAuto);
                            return;
                        }
                    }
                    if (videoData.getLive_status().equalsIgnoreCase("0")) {
                        Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(videoData.getStart_date()) * 1000)), 0).show();
                        return;
                    } else if (videoData.getLive_status().equalsIgnoreCase("2")) {
                        Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                        return;
                    } else {
                        if (videoData.getLive_status().equalsIgnoreCase("3")) {
                            Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                            return;
                        }
                        return;
                    }
                }
                if (videoData.getIs_drm().equals("1")) {
                    if (videoData.getLive_status().equalsIgnoreCase("1")) {
                        if (videoData.getId() == null || videoData.getId().equalsIgnoreCase("")) {
                            Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                            return;
                        } else {
                            Helper.GoToVideoCryptActivity(ExamPrepLayer3Adapter.this.activity, videoData.getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), videoData.getVideo_type(), videoData.getChat_node(), videoData.getId(), videoData.getVideo_type(), videoData.getId(), videoData.getTitle(), "0", videoData.getThumbnail_url(), videoData.getPayloadData().getCourse_id(), videoData.getPayloadData().getTile_id(), videoData.getPayloadData().getTile_type(), videoData.getIs_chat_lock(), String.valueOf(position), SingleStudy.parentCourseId, videoData.getStart_date(), videoData.getIs_bookmarked(), ExamPrepLayer3Adapter.this.videoArrayListAuto);
                            return;
                        }
                    }
                    if (videoData.getLive_status().equalsIgnoreCase("0")) {
                        Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(videoData.getStart_date()) * 1000)), 0).show();
                        return;
                    } else if (videoData.getLive_status().equalsIgnoreCase("2")) {
                        Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                        return;
                    } else {
                        if (videoData.getLive_status().equalsIgnoreCase("3")) {
                            Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (videoData.getVideo_type().equalsIgnoreCase("11")) {
                if (videoData.getFile_url() != null && videoData.getFile_url().isEmpty()) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                    return;
                }
                if (videoData.getLive_status().equalsIgnoreCase("0")) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(videoData.getStart_date()) * 1000)), 0).show();
                } else if (videoData.getLive_status().equalsIgnoreCase("2")) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                } else if (videoData.getLive_status().equalsIgnoreCase("3")) {
                    Toast.makeText(ExamPrepLayer3Adapter.this.activity, ExamPrepLayer3Adapter.this.activity.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markAsReadVideoType1_7(final Video videodata, final LinearLayout llEnableMarkAsRead, final CheckBox checkMark, final TextView tvMark, final int positon) {
        boolean z = false;
        if (Helper.isShowMarkAsDone(videodata.getVideo_type())) {
            llEnableMarkAsRead.setVisibility(0);
        } else {
            llEnableMarkAsRead.setVisibility(8);
        }
        if (!TextUtils.isEmpty(videodata.getMark_as_complete()) && videodata.getMark_as_complete().equalsIgnoreCase("1")) {
            z = true;
        }
        final boolean z2 = z;
        checkMarkUnmark(llEnableMarkAsRead, checkMark, tvMark, z2);
        checkMark.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                boolean zIsChecked = ((CheckBox) v).isChecked();
                if (zIsChecked) {
                    ExamPrepLayer3Adapter.this.markCheckAlertDialog(zIsChecked, videodata, llEnableMarkAsRead, checkMark, tvMark, z2, positon);
                }
            }
        });
    }

    private void checkMarkUnmark(LinearLayout llEnableMarkAsRead, CheckBox checkMark, TextView tvMark, boolean isVideoReadMarked) {
        if (llEnableMarkAsRead.getVisibility() == 0 && isVideoReadMarked) {
            checkMark.setChecked(true);
            tvMark.setText(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED);
            checkMark.setButtonTintList(ColorStateList.valueOf(this.activity.getResources().getColor(R.color.colorPrimary)));
            checkMark.setEnabled(false);
            return;
        }
        checkMark.setChecked(false);
        tvMark.setText("Mark Complete");
        checkMark.setButtonTintList(ColorStateList.valueOf(this.activity.getResources().getColor(R.color.grey_new_mark_read)));
        checkMark.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markCheckAlertDialog(final boolean isChecked, final Video videodata, final LinearLayout llEnableMarkAsRead, final CheckBox checkMark, final TextView tvMark, final boolean finalIsVideoReadMarked, final int positon) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.activity);
        builder.setTitle(this.activity.getResources().getString(R.string.mark_read));
        builder.setCancelable(false);
        builder.setMessage(this.activity.getResources().getString(R.string.are_you_sure_you_want_to_mark_video_completed));
        builder.setNegativeButton(this.activity.getResources().getString(R.string.no), new DialogInterface.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ExamPrepLayer3Adapter.lambda$markCheckAlertDialog$0(checkMark, dialogInterface, i);
            }
        });
        builder.setPositiveButton(this.activity.getResources().getString(R.string.yes), new DialogInterface.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$markCheckAlertDialog$1(finalIsVideoReadMarked, isChecked, checkMark, llEnableMarkAsRead, tvMark, videodata, positon, dialogInterface, i);
            }
        });
        builder.create().show();
    }

    static /* synthetic */ void lambda$markCheckAlertDialog$0(CheckBox checkBox, DialogInterface dialogInterface, int i) {
        checkBox.setChecked(false);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$markCheckAlertDialog$1(boolean z, boolean z2, CheckBox checkBox, LinearLayout linearLayout, TextView textView, Video video, int i, DialogInterface dialogInterface, int i2) {
        if (!Helper.isNetworkConnected(this.activity)) {
            checkBox.setChecked(false);
            Toast.makeText(this.activity, "No internet connection", 0).show();
        } else if (!z && z2) {
            checkBox.setEnabled(false);
            this.llEnableMarkAsRead_read_mark = linearLayout;
            this.tvMark_read_mark = textView;
            this.checkMark_read_mark = checkBox;
            this.videodata = video;
            this.selectedMarkReadPosition = i;
            new NetworkCall(this, this.activity).NetworkAPICall(API.MARK_READ_VIDEO_TYPE_1_7, "", true, false);
        }
        dialogInterface.dismiss();
    }

    public class SingleStudyGroupChatAdapter extends RecyclerView.ViewHolder {
        RecyclerView groupChatRecycler;

        public SingleStudyGroupChatAdapter(View itemView) {
            super(itemView);
            this.groupChatRecycler = (RecyclerView) itemView.findViewById(R.id.groupChatRecycler);
        }

        public void setData(ArrayList<ChatModel> chatModels) {
            this.groupChatRecycler.setLayoutManager(new LinearLayoutManager(ExamPrepLayer3Adapter.this.activity));
            this.groupChatRecycler.setAdapter(new com.appnew.android.socket.adapter.SingleStudyGroupChatAdapter(ExamPrepLayer3Adapter.this.activity, chatModels, ExamPrepLayer3Adapter.this.singleStudy));
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

        public void setData(final ArrayList<com.appnew.android.Model.TimeTable.Data> list, final int position) {
            ArrayList arrayList = new ArrayList();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(list.get(i).getDate());
            }
            linkedHashSet.addAll(arrayList);
            arrayList.clear();
            arrayList.addAll(linkedHashSet);
            DateTableAdapter dateTableAdapter = new DateTableAdapter(arrayList, list, ExamPrepLayer3Adapter.this.activity, this);
            this.DateTableRecycler.setLayoutManager(new LinearLayoutManager(ExamPrepLayer3Adapter.this.activity, 0, false));
            this.DateTableRecycler.setAdapter(dateTableAdapter);
            this.DateTableRecycler.setNestedScrollingEnabled(false);
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (list.get(0).getDate().equals(list.get(i2).getDate())) {
                    arrayList2.add(list.get(i2));
                }
            }
            TimeTableDateAdapter timeTableDateAdapter = new TimeTableDateAdapter(arrayList2, ExamPrepLayer3Adapter.this.activity);
            this.timeTableRecycler.setLayoutManager(new LinearLayoutManager(ExamPrepLayer3Adapter.this.activity));
            this.timeTableRecycler.setAdapter(timeTableDateAdapter);
            this.timeTableRecycler.setNestedScrollingEnabled(false);
        }

        @Override // com.appnew.android.Zoom.ItemClickListener
        public void onClickTimeTableDate(ArrayList<com.appnew.android.Model.TimeTable.Data> data, int position) {
            TimeTableDateAdapter timeTableDateAdapter = new TimeTableDateAdapter(data, ExamPrepLayer3Adapter.this.activity);
            this.timeTableRecycler.setLayoutManager(new LinearLayoutManager(ExamPrepLayer3Adapter.this.activity));
            this.timeTableRecycler.setAdapter(timeTableDateAdapter);
            this.timeTableRecycler.setNestedScrollingEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleVideoStatus(Video video, ImageView optionMenuImgView, TextView durationTV) {
        if (video.getVideo_status() != null) {
            durationTV.setVisibility(0);
            if (video.getVideo_status() != null && video.getVideo_status().equalsIgnoreCase("Download Running")) {
                optionMenuImgView.setVisibility(8);
                durationTV.setVisibility(8);
            } else if (video.getVideo_status() != null && video.getVideo_status().equalsIgnoreCase("Downloaded")) {
                durationTV.setVisibility(8);
                optionMenuImgView.setVisibility(0);
                optionMenuImgView.setEnabled(false);
                optionMenuImgView.setImageResource(R.drawable.ic_downloaded_chapter);
                durationTV.setText(this.activity.getResources().getString(R.string.duration) + video.getVideotime());
            } else if (video.getVideo_status() != null && video.getVideo_status().equalsIgnoreCase("Download")) {
                optionMenuImgView.setEnabled(true);
                optionMenuImgView.setImageResource(R.drawable.ic_menu_download);
                optionMenuImgView.setVisibility(0);
                durationTV.setVisibility(8);
            } else {
                optionMenuImgView.setVisibility(8);
                durationTV.setVisibility(8);
            }
        }
        Helper.dismissProgressDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlayForAudio(TextView play_now, Video video) {
        if (MusicService.INSTANCE.isAudioPlaying() && MusicService.INSTANCE.getVideoid().equalsIgnoreCase(video.getId())) {
            play_now.setText(this.activity.getResources().getString(R.string.stop));
        } else {
            play_now.setText(this.activity.getResources().getString(R.string.play));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDownloadIcon(Video video, ImageView optionMenuImgView) {
        if (video.getVideo_type().equalsIgnoreCase("7")) {
            if (!TextUtils.isEmpty(video.getIs_download_available()) && video.getIs_download_available().equalsIgnoreCase("1") && video.getIs_locked().equalsIgnoreCase("0") && video.getBitrate_urls() != null && !video.getBitrate_urls().isEmpty()) {
                optionMenuImgView.setVisibility(0);
                optionMenuImgView.setImageResource(R.drawable.download_icon);
                return;
            } else {
                optionMenuImgView.setVisibility(8);
                return;
            }
        }
        if (video.getVideo_type().equalsIgnoreCase("1")) {
            if (SharedPreference.getInstance().getString(Const.YOUTUBE_DOWNLOAD).equalsIgnoreCase("1") && video.getIs_locked().equalsIgnoreCase("0") && !TextUtils.isEmpty(video.getIs_download_available()) && video.getIs_download_available().equalsIgnoreCase("1")) {
                optionMenuImgView.setVisibility(0);
                optionMenuImgView.setImageResource(R.drawable.download_icon);
            } else {
                optionMenuImgView.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLiveVideo(ImageView liveIv, Video video) {
        Activity activity = this.activity;
        if (activity != null && video != null && liveIv != null) {
            Glide.with(activity).load(Integer.valueOf(R.mipmap.live)).into(liveIv);
            if ("9".equalsIgnoreCase(video.getVideo_type()) && "1".equals(video.getLive_status())) {
                liveIv.setVisibility(0);
            } else {
                liveIv.setVisibility(8);
            }
            if ("1".equals(video.getIs_live())) {
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
    public void setCONTENT_Sub_TEST(Video video, TextView title, ImageView share, ImageView optionMenuImgView, LinearLayout subjectBTNLL, TextView read_now, ImageView liveIv, TextView watch_now, TextView listne_now, LinearLayout attemptLL, RelativeLayout realte, LinearLayout LogsLL) {
        title.setText(video.getTitle());
        share.setVisibility(8);
        optionMenuImgView.setVisibility(8);
        read_now.setVisibility(8);
        liveIv.setVisibility(8);
        watch_now.setVisibility(8);
        listne_now.setVisibility(8);
        attemptLL.setVisibility(8);
        realte.setVisibility(8);
        LogsLL.setVisibility(8);
        subjectBTNLL.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCONTENT_LINK(Video video, LinearLayout attemptLL, TextView title, ImageView optionMenuImgView, TextView watch_now, TextView durationTV, LinearLayout subjectBTNLL, TextView learn, TextView practice, TextView listne_now, LinearLayout LogsLL) {
        title.setText(video.getTitle());
        attemptLL.setVisibility(8);
        optionMenuImgView.setVisibility(8);
        watch_now.setVisibility(8);
        durationTV.setVisibility(8);
        LogsLL.setVisibility(8);
        subjectBTNLL.setVisibility(8);
        learn.setVisibility(8);
        practice.setVisibility(8);
        listne_now.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleVisibilityCONTENT_VIDEO(LinearLayout attemptLL, TextView learn, TextView practice, TextView read_now, TextView durationTV, TextView textView, LinearLayout subjectBTNLL, TextView view) {
        attemptLL.setVisibility(8);
        learn.setVisibility(8);
        practice.setVisibility(8);
        read_now.setVisibility(8);
        durationTV.setVisibility(8);
        subjectBTNLL.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCONTENT_VIDEO(Video video, TextView title, ImageView optionMenuImgView) {
        title.setText(video.getTitle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSharePurchaseAndShareContent(ImageView share, Video video) {
        if (this.is_purchase.equalsIgnoreCase("1")) {
            if (Helper.isShowShareButton(this.leftMenu)) {
                share.setVisibility(0);
                return;
            } else {
                share.setVisibility(8);
                return;
            }
        }
        if (Helper.isShowShareButton(this.leftMenu) && video.getIs_locked().equalsIgnoreCase("0")) {
            share.setVisibility(0);
        } else {
            share.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCONTENT_EPUB(TextView read_now, TextView learn, TextView practice, LinearLayout attemptLL, LinearLayout LogsLL, LinearLayout subjectBTNLL, TextView durationTV) {
        read_now.setVisibility(8);
        learn.setVisibility(8);
        practice.setVisibility(8);
        attemptLL.setVisibility(8);
        LogsLL.setVisibility(8);
        subjectBTNLL.setVisibility(8);
        durationTV.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setThumbUrlImagePDF(Video video, ImageView thumb) {
        if (video.getThumbnail_url().equalsIgnoreCase("")) {
            thumb.setImageResource(R.mipmap.square_placeholder_new);
        } else {
            setThumbAccordingRatio(video.getThumbnail_url(), thumb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setThumbUrlImage(Video video, ImageView thumb) {
        if (video.getThumbnail_url() == null || video.getThumbnail_url().equalsIgnoreCase("")) {
            thumb.setImageResource(R.mipmap.square_placeholder_new);
        } else {
            setThumbAccordingRatio(video.getThumbnail_url(), thumb);
        }
    }

    private void setThumbRatio(RelativeLayout rlThum) {
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
        Activity activity = this.activity;
        Helper.setThumbnailImage(activity, url, activity.getDrawable(R.mipmap.square_placeholder_new), thumb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRealeVisibilty(RelativeLayout realte, Video video) {
        if ("1".equalsIgnoreCase("5") || "1".equalsIgnoreCase("7")) {
            realte.setVisibility(8);
            return;
        }
        if (this.is_purchase.equalsIgnoreCase("1")) {
            realte.setVisibility(0);
        } else if (video.getIs_locked().equalsIgnoreCase("0")) {
            realte.setVisibility(0);
        } else {
            realte.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logsVisibility(LinearLayout logsLL, RelativeLayout lockRL) {
        if (lockRL.getVisibility() == 0) {
            logsLL.setVisibility(8);
        } else {
            logsLL.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void spaceHandling(RelativeLayout lockRL, RelativeLayout realte) {
        if (lockRL.getVisibility() == 0) {
            realte.setVisibility(8);
        } else {
            realte.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDateTimeByVideoTypes(View itemView, Video video) {
        try {
            Helper.logPrinter("setDateTimeByVideoTypes : video: ", "e", new Gson().toJson(video), "");
            if ("1".equalsIgnoreCase("1") || "1".equalsIgnoreCase("2")) {
                LinearLayout linearLayout = (LinearLayout) itemView.findViewById(R.id.zoom_date_time);
                TextView textView = (TextView) itemView.findViewById(R.id.liveDate);
                TextView textView2 = (TextView) itemView.findViewById(R.id.liveTime);
                TextView textView3 = (TextView) itemView.findViewById(R.id.timing);
                if (SharedPreference.getInstance().getString(Const.HARVEST_CLASS_TIME_HIDE).equalsIgnoreCase("1") && !video.getIs_live().equalsIgnoreCase("1") && (video.getVideo_type().equalsIgnoreCase("1") || video.getVideo_type().equalsIgnoreCase("4") || video.getVideo_type().equalsIgnoreCase("7"))) {
                    linearLayout.setVisibility(8);
                    return;
                }
                if (video.getVideo_type().equalsIgnoreCase("4") || video.getVideo_type().equalsIgnoreCase("1") || video.getVideo_type().equalsIgnoreCase("8") || video.getVideo_type().equalsIgnoreCase("7") || video.getVideo_type().equalsIgnoreCase("9")) {
                    linearLayout.setVisibility(0);
                    textView2.setVisibility(0);
                    textView3.setVisibility(8);
                    if (video.getStart_date() == null || video.getStart_date().equalsIgnoreCase("0")) {
                        return;
                    }
                    textView.setText("Class Timing: " + new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.US).format(new Date(Long.parseLong(video.getStart_date()) * 1000)));
                }
            }
        } catch (Exception e2) {
            Helper.logPrinter("setDateTimeByVideoTypes", "e", e2.getLocalizedMessage(), e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Download_dialog(String url, final VideosDownload videosDownload, int position, final ImageView myButton) {
        if (this.utkashRoom.getvideoDownloadao().getuser(videosDownload.getVideo_id(), videosDownload.getIs_complete()) != null && this.utkashRoom.getvideoDownloadao().getuser(videosDownload.getVideo_id(), videosDownload.getIs_complete()).getToal_downloadlocale() != null && this.utkashRoom.getvideoDownloadao().getuser(videosDownload.getVideo_id(), videosDownload.getIs_complete()).getToal_downloadlocale().longValue() == 0) {
            this.utkashRoom.getvideoDownloadao().update_pos(MakeMyExam.userId, videosDownload.getVideo_id(), this.utkashRoom.getvideoDownloadao().getalldownload_videos(MakeMyExam.userId).size() - 1);
            Intent intent = new Intent(this.activity, (Class<?>) VideoDownloadService.class);
            intent.putExtra(VideoDownloadService.FILEDOWNLOADSTATUS, false);
            intent.putExtra(VideoDownloadService.URL, url);
            intent.putExtra(VideoDownloadService.DOWNLOAD_SERVICE_ID, videosDownload.getVideo_id());
            intent.putExtra(VideoDownloadService.FILEPATH, videosDownload.getVideo_name());
            intent.putExtra("name", videosDownload.getVideo_history());
            intent.putExtra(com.clevertap.android.sdk.Constants.INAPP_POSITION, this.utkashRoom.getvideoDownloadao().getalldownload_videos(MakeMyExam.userId).size() - 1);
            intent.putExtra("status", videosDownload.getVideo_status());
            VideoDownloadService.isServiceRunning = true;
            Helper.startVideoDownloadService(this.activity, intent);
            pushEventForDownload(videosDownload);
        }
        this.activity.runOnUiThread(new Runnable() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$Download_dialog$2(videosDownload, myButton);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$Download_dialog$2(VideosDownload videosDownload, ImageView imageView) {
        waiting_dialog(videosDownload.getVideo_name(), imageView);
    }

    private void waiting_dialog(String video_name, final ImageView myButton) {
        try {
            final Dialog dialog = new Dialog(this.activity);
            dialog.setCancelable(false);
            dialog.requestWindowFeature(1);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
            dialog.setContentView(R.layout.dialog_alert_downloads);
            ((TextView) dialog.findViewById(R.id.titleDialog)).setText("Video");
            ((TextView) dialog.findViewById(R.id.msgDialog)).setText(video_name);
            Button button = (Button) dialog.findViewById(R.id.btn_cancel);
            ((Button) dialog.findViewById(R.id.btn_submit)).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$waiting_dialog$3(dialog, myButton, view);
                }
            });
            button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExamPrepLayer3Adapter.lambda$waiting_dialog$4(dialog, myButton, view);
                }
            });
            dialog.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$waiting_dialog$3(Dialog dialog, ImageView imageView, View view) {
        Helper.gotoActivity(new Intent(this.activity, (Class<?>) DownloadActivity.class), this.activity);
        this.activity.finish();
        dialog.dismiss();
        dialog.cancel();
        imageView.setVisibility(8);
    }

    static /* synthetic */ void lambda$waiting_dialog$4(Dialog dialog, ImageView imageView, View view) {
        dialog.dismiss();
        dialog.cancel();
        imageView.setVisibility(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0445 A[PHI: r17
      0x0445: PHI (r17v3 char) = (r17v2 char), (r17v10 char) binds: [B:96:0x040a, B:100:0x0443] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0487 A[PHI: r17
      0x0487: PHI (r17v4 char) = (r17v3 char), (r17v8 char) binds: [B:102:0x044d, B:106:0x0485] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x04c8 A[PHI: r17
      0x04c8: PHI (r17v5 char) = (r17v4 char), (r17v6 char) binds: [B:108:0x048f, B:112:0x04c6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x040c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void showPopUp(final com.appnew.android.testmodule.model.InstructionData r25) {
        /*
            Method dump skipped, instruction units count: 1442
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter.showPopUp(com.appnew.android.testmodule.model.InstructionData):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPopUp$5(TestBasicInst testBasicInst, CheckBox checkBox, Dialog dialog, View view) {
        if (testBasicInst.getTotalQuestions().equalsIgnoreCase("0")) {
            Activity activity = this.activity;
            Toast.makeText(activity, activity.getResources().getString(R.string.please_add_question), 0).show();
        } else {
            if (checkBox.isChecked()) {
                dialog.dismiss();
                this.quiz_id = testBasicInst.getId();
                SharedPreference.getInstance().putInt("test_position", this.testPosition);
                new NetworkCall(this, this.activity).NetworkAPICall(API.API_GET_INFO_TEST_SERIES, "", true, false);
                return;
            }
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
                map.merge(sectionId, Float.valueOf(floatSafe), new BiFunction() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$$ExternalSyntheticLambda8
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

    public void showPopMenuForLangauge(final TextView textView, final View v, final TestBasicInst testBasicInst) {
        PopupMenu popupMenu = new PopupMenu(this.activity, v);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$$ExternalSyntheticLambda5
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return this.f$0.lambda$showPopMenuForLangauge$6(v, testBasicInst, textView, menuItem);
            }
        });
        for (int i = 0; i < testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA).length; i++) {
            if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("1")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[0]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("2")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[1]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("3")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[2]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("9")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[3]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("6")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[4]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("10")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[9]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("11")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[6]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("12")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[7]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("5")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[8]);
            }
        }
        popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$showPopMenuForLangauge$6(View view, TestBasicInst testBasicInst, TextView textView, MenuItem menuItem) {
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

    public void showPopMenuForLangauge(final View v, final TestBasicInst testBasicInst, final TextView v1, TextView vv) {
        PopupMenu popupMenu = new PopupMenu(this.activity, v);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter$$ExternalSyntheticLambda7
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return this.f$0.lambda$showPopMenuForLangauge$7(v, testBasicInst, v1, menuItem);
            }
        });
        for (int i = 0; i < testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA).length; i++) {
            if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("1")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[0]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("2")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[1]);
            }
        }
        popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$showPopMenuForLangauge$7(View view, TestBasicInst testBasicInst, TextView textView, MenuItem menuItem) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void startTestAPI(int position) {
        this.isReAttemptOrPractice = false;
        this.testPosition = position;
        new NetworkCall(this, this.activity).NetworkAPICall(API.API_GET_TEST_INSTRUCTION_DATA, "", true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTestAPI(String s) {
        try {
            ((CourseActivity) this.activity).searchView.setQuery("", false);
        } catch (Exception unused) {
        }
        this.isReAttemptOrPractice = true;
        new NetworkCall(this, this.activity).NetworkAPICall(API.API_GET_TEST_INSTRUCTION_DATA, "", true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startResumeTestAPI() {
        this.first_attempt = "1";
        this.isSSCpattern = false;
        new NetworkCall(this, this.activity).NetworkAPICall(API.API_GET_INFO_TEST_SERIES, "", true, false);
    }

    public void setFolderData(String folder_id, String contentType) {
        this.folder_id = folder_id;
        this.folderContentType = contentType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pushEventForDownload(VideosDownload videosDownload) {
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
}
