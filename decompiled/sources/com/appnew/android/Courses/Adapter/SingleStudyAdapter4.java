package com.appnew.android.Courses.Adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Environment;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.PopupMenu;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.BuildConfig;
import com.appnew.android.Courses.Activity.ComboListActivity;
import com.appnew.android.Courses.Activity.Concept_newActivity;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.Courses.Activity.PdfDetailScreen;
import com.appnew.android.Courses.Activity.QuizActivity;
import com.appnew.android.Courses.Adapter.ComboListAdapter;
import com.appnew.android.Courses.Adapter.SingleStudyAdapter4;
import com.appnew.android.Courses.Fragment.ExamPrepLayer2;
import com.appnew.android.Courses.Fragment.SingleStudy;
import com.appnew.android.Courses.overview.adapter.OverviewRVAdapter;
import com.appnew.android.Download.DownloadActivity;
import com.appnew.android.Download.DownloadVideoPlayer;
import com.appnew.android.DownloadServices.VideoDownloadService;
import com.appnew.android.EncryptionModel.EncryptionData;
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
import com.appnew.android.Model.UrlObject;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Payment.PurchaseActivity;
import com.appnew.android.Room.UtkashRoom;
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
import com.appnew.android.Webview.RevisionActivity;
import com.appnew.android.Webview.WebViewActivty;
import com.appnew.android.cleverTap.AnalyticHelper;
import com.appnew.android.table.TestTable;
import com.appnew.android.table.ThemeSettings;
import com.appnew.android.table.VideoTable;
import com.appnew.android.table.VideosDownload;
import com.appnew.android.testmodule.activity.ViewSolutionActivity;
import com.appnew.android.testmodule.model.InstructionData;
import com.appnew.android.testmodule.model.ResultTestSeries_Report;
import com.appnew.android.testmodule.model.TestBasicInst;
import com.appnew.android.testmodule.model.TestSectionInst;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.facebook.share.internal.ShareConstants;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.tv9news.utils.helpers.AnalyticEvents;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes6.dex */
public class SingleStudyAdapter4 extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements NetworkCall.MyNetworkCallBack {
    Activity activity;
    private String attemptOrReAttempt;
    onButtonClicked4 buttonClicked;
    public String contentType;
    ArrayList<Courselist> courseDataArrayList;
    int downloadCount;
    ExamPrepItem examPrepItem;
    ArrayList<FaqData> faqData;
    private String first_attempt;
    boolean isCombo;
    boolean isReAttemptOrPractice;
    private boolean isSSCpattern;
    String isSkip;
    String is_purchase;
    int lang;
    String[] langIds;
    LeftMenu leftMenu;
    LinearLayoutManager linearLayoutManager;
    private ListTypeAdapter listTypeAdapter;
    OverviewData overviewData;
    String parentCourseId;
    int position_delete;
    private Progress progress;
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
    private String totalQuestion;
    public UtkashRoom utkashRoom;
    private Lists videodata;
    public String typeState = "";
    ArrayList<View> viewArrayList = new ArrayList<>();
    Boolean isLodded = true;
    int DEFAULT_SPAN_COUNT = 2;

    public interface onButtonClicked4 {
        void onTitleClicked4(TilesItem cards, List<TilesItem> tiles, int tilePos);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    public SingleStudyAdapter4(Activity activity, CourseDetail singleStudy, ExamPrepItem examPrepItem, OverviewData overviewData, ArrayList<Courselist> courseDataArrayList, ArrayList<FaqData> faqData, onButtonClicked4 buttonClicked, String parentCourseId, boolean isCombo, String isSkip, int tilePos, String tileIdAPI, String tileTypeAPI, String revertAPI) {
        this.isCombo = false;
        this.tilePos = 0;
        this.is_purchase = "";
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        this.utkashRoom = appDatabase;
        this.result_date = "";
        this.submission_type = "";
        this.themeSettings = appDatabase.getthemeSettingdao().data();
        this.downloadCount = 0;
        this.isReAttemptOrPractice = false;
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
        this.is_purchase = singleStudy.getData().getCourseDetail().getIsPurchased();
        this.progress = new Progress(activity);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.leftMenu = (LeftMenu) new Gson().fromJson(this.themeSettings.getLeft_menu(), LeftMenu.class);
        if (viewType == 0) {
            return new SingleStudyHeaderHolder(LayoutInflater.from(this.activity).inflate(R.layout.exam_prep_header_theme8, (ViewGroup) null));
        }
        if (viewType == 1) {
            return new SingleStudyListHolder(LayoutInflater.from(this.activity).inflate(R.layout.exam_prep_single_row_item_theme5, (ViewGroup) null));
        }
        if (viewType == 7) {
            return new SingleStudyPdfListHolder(LayoutInflater.from(this.activity).inflate(R.layout.exam_prep_single_row_item_pdf_theme8, (ViewGroup) null));
        }
        if (viewType == 8) {
            return new SingleStudyConceptListHolder(LayoutInflater.from(this.activity).inflate(R.layout.exam_prep_single_row_item_concept_theme5, (ViewGroup) null));
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
        return new StudyNoDataViewHolder(LayoutInflater.from(this.activity).inflate(R.layout.no_data_found, (ViewGroup) null));
    }

    public class SingleStudyTestListHolder extends RecyclerView.ViewHolder {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        LinearLayout attemptLL;
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
        ImageView share;
        TextView startdate;
        RelativeLayout studyitemLL;
        TextView subItemRV;
        TextView testResume;
        TextView titleCategory;
        TextView view_result;

        public SingleStudyTestListHolder(View itemView) {
            super(itemView);
            this.lockRL = (RelativeLayout) itemView.findViewById(R.id.lockRL);
            this.parentLL = (RelativeLayout) itemView.findViewById(R.id.parentLL);
            this.studyitemLL = (RelativeLayout) itemView.findViewById(R.id.study_single_itemLL);
            this.forwardIV = (ImageView) itemView.findViewById(R.id.forwardIV);
            this.imageIcon = (ImageView) itemView.findViewById(R.id.profileImage);
            this.titleCategory = (TextView) itemView.findViewById(R.id.examPrepTitleTV);
            this.subItemRV = (TextView) itemView.findViewById(R.id.subItemRV);
            this.startdate = (TextView) itemView.findViewById(R.id.startdate);
            this.attemptLL = (LinearLayout) itemView.findViewById(R.id.attemptLL);
            this.no_data_found_RL = (RelativeLayout) itemView.findViewById(R.id.no_data_found_RL);
            this.backBtn = (Button) itemView.findViewById(R.id.backBtn);
            this.ibt_single_sub_vd_RL = (CardView) itemView.findViewById(R.id.ibt_single_sub_vd_RL);
            this.learn = (TextView) itemView.findViewById(R.id.learn);
            this.share = (ImageView) itemView.findViewById(R.id.share);
            this.practice = (TextView) itemView.findViewById(R.id.practice);
            this.contantRL = (RelativeLayout) itemView.findViewById(R.id.contantLL);
            this.testResume = (TextView) itemView.findViewById(R.id.testResume);
            this.view_result = (TextView) itemView.findViewById(R.id.view_result);
        }

        public void setData(final ArrayList<Lists> list, final int position) {
            long j;
            this.view_result.setVisibility(8);
            if (list != null && list.size() > 0) {
                this.ibt_single_sub_vd_RL.setVisibility(0);
                this.no_data_found_RL.setVisibility(8);
                if (SingleStudyAdapter4.this.is_purchase.equalsIgnoreCase("0") && SingleStudyAdapter4.this.isSkip.equalsIgnoreCase("3")) {
                    this.forwardIV.setVisibility(8);
                }
                int i = position - 1;
                if (TextUtils.isEmpty(list.get(i).getIs_locked())) {
                    list.get(i).setIs_locked("0");
                }
                if (SingleStudyAdapter4.this.singleStudy != null && SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail() != null && SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getIsPurchased().equals("1")) {
                    list.get(i).setIs_locked("0");
                }
                if (list.get(i).getIs_locked().equals("0")) {
                    this.lockRL.setVisibility(8);
                } else {
                    this.lockRL.setVisibility(0);
                }
                if (SingleStudyAdapter4.this.isSkip.equalsIgnoreCase("3")) {
                    if (Helper.isShowShareButton(SingleStudyAdapter4.this.leftMenu)) {
                        this.share.setVisibility(0);
                    } else {
                        this.share.setVisibility(8);
                    }
                    this.titleCategory.setText(list.get(i).getTest_series_name());
                    if (Helper.isLiveTest(list.get(i).getTest_series_type()) && !list.get(i).getEnd_date().equalsIgnoreCase("0") && !list.get(i).getEnd_date().equalsIgnoreCase("")) {
                        this.subItemRV.setVisibility(0);
                        j = 1000;
                        this.subItemRV.setText(SingleStudyAdapter4.this.activity.getResources().getString(R.string.test_end) + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(list.get(i).getEnd_date()) * 1000))));
                    } else {
                        j = 1000;
                        this.subItemRV.setVisibility(8);
                    }
                    if (Helper.isLiveTest(list.get(i).getTest_series_type()) && !list.get(i).getStart_date().equalsIgnoreCase("0") && !list.get(i).getStart_date().equalsIgnoreCase("")) {
                        this.startdate.setVisibility(0);
                        this.startdate.setText(SingleStudyAdapter4.this.activity.getResources().getString(R.string.test_start) + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(list.get(i).getStart_date()) * j))));
                    } else {
                        this.startdate.setVisibility(8);
                    }
                    this.attemptLL.setVisibility(0);
                    if (list.get(i).getState().equals("1")) {
                        SingleStudyAdapter4.this.utkashRoom.getTestDao().delete_test_data(MakeMyExam.userId, list.get(i).getId());
                        if (MakeMyExam.time_server >= Long.parseLong(list.get(i).getEnd_date()) * j) {
                            this.view_result.setVisibility(0);
                            if (list.get(i).getResult_date().equalsIgnoreCase("0") || list.get(i).getResult_date().equalsIgnoreCase("1") || list.get(i).getResult_date().equalsIgnoreCase("")) {
                                this.attemptLL.setVisibility(8);
                                handleLearnPractice(list.get(i));
                            } else if (MakeMyExam.time_server > Long.parseLong(list.get(i).getResult_date()) * j) {
                                if (Long.parseLong(list.get(i).getEnd_date()) < 1640066737) {
                                    this.attemptLL.setVisibility(8);
                                } else {
                                    this.attemptLL.setVisibility(8);
                                    if (list.get(i).getState().equalsIgnoreCase("1")) {
                                        ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter4.this.activity.getResources().getString(R.string.view_result1));
                                    } else {
                                        ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter4.this.activity.getResources().getString(R.string.view_rank));
                                    }
                                }
                                handleLearnPractice(list.get(i));
                            } else {
                                this.view_result.setVisibility(0);
                                this.attemptLL.setVisibility(8);
                                ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter4.this.activity.getResources().getString(R.string.attempted_));
                                handleLearnPractice(list.get(i));
                            }
                        } else {
                            if (list.get(i).getResult_date().equalsIgnoreCase("0") || list.get(i).getResult_date().equalsIgnoreCase("1") || list.get(i).getResult_date().equalsIgnoreCase("")) {
                                this.view_result.setVisibility(0);
                            } else {
                                this.view_result.setVisibility(0);
                            }
                            if (!list.get(i).getIs_reattempt().equalsIgnoreCase("0")) {
                                this.learn.setVisibility(8);
                                this.practice.setVisibility(8);
                                this.attemptLL.setVisibility(0);
                                this.attemptLL.getChildAt(0).setVisibility(0);
                                ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter4.this.activity.getResources().getString(R.string.re_aTTEMPT));
                            } else if (list.get(i).getResult_date() == null || list.get(i).getResult_date().equalsIgnoreCase("1") || list.get(i).getResult_date().equalsIgnoreCase("0") || list.get(i).getResult_date().equalsIgnoreCase("")) {
                                this.learn.setVisibility(8);
                                this.practice.setVisibility(8);
                                this.attemptLL.getChildAt(0).setVisibility(0);
                                if (list.get(i).getState().equalsIgnoreCase("1")) {
                                    ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter4.this.activity.getResources().getString(R.string.attempted_));
                                } else {
                                    ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter4.this.activity.getResources().getString(R.string.attempted_));
                                }
                            } else {
                                this.learn.setVisibility(8);
                                this.practice.setVisibility(8);
                                this.attemptLL.getChildAt(0).setVisibility(0);
                                ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter4.this.activity.getResources().getString(R.string.attempted));
                            }
                        }
                    } else if (MakeMyExam.time_server >= Long.parseLong(list.get(i).getEnd_date()) * j) {
                        if (list.get(i).getResult_date().equalsIgnoreCase("0") || list.get(i).getResult_date().equalsIgnoreCase("1") || list.get(i).getResult_date().equalsIgnoreCase("")) {
                            this.attemptLL.setVisibility(8);
                            handleLearnPractice(list.get(i));
                            this.view_result.setVisibility(0);
                            this.view_result.setText(SingleStudyAdapter4.this.activity.getResources().getString(R.string.view_rank));
                        }
                        if (Long.parseLong(list.get(i).getResult_date()) * j > System.currentTimeMillis()) {
                            this.attemptLL.setVisibility(8);
                            handleLearnPractice(list.get(i));
                            this.view_result.setVisibility(8);
                            this.view_result.setText(SingleStudyAdapter4.this.activity.getResources().getString(R.string.view_rank));
                        } else if (MakeMyExam.time_server > Long.parseLong(list.get(i).getResult_date()) * j) {
                            this.view_result.setVisibility(0);
                            if (Long.parseLong(list.get(i).getEnd_date()) < 1640066737) {
                                this.attemptLL.setVisibility(8);
                            } else {
                                this.attemptLL.setVisibility(8);
                                this.attemptLL.getChildAt(0).setVisibility(8);
                                if (list.get(i).getState().equalsIgnoreCase("1")) {
                                    this.view_result.setText(SingleStudyAdapter4.this.activity.getResources().getString(R.string.view_result1));
                                    ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter4.this.activity.getResources().getString(R.string.view_result1));
                                } else {
                                    this.view_result.setText(SingleStudyAdapter4.this.activity.getResources().getString(R.string.view_rank));
                                    ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter4.this.activity.getResources().getString(R.string.view_rank));
                                }
                            }
                            handleLearnPractice(list.get(i));
                        } else {
                            this.attemptLL.setVisibility(8);
                            handleLearnPractice(list.get(i));
                        }
                    } else if (System.currentTimeMillis() < Long.parseLong(list.get(i).getStart_date()) * j) {
                        this.attemptLL.getChildAt(0).setVisibility(0);
                        ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter4.this.activity.getResources().getString(R.string.upcoming_test));
                        this.learn.setVisibility(8);
                        this.practice.setVisibility(8);
                    } else {
                        TestTable testTableTest_data = SingleStudyAdapter4.this.utkashRoom.getTestDao().test_data(list.get(i).getId(), MakeMyExam.userId);
                        if (testTableTest_data != null && testTableTest_data.getStatus() != null && !testTableTest_data.getStatus().equalsIgnoreCase("")) {
                            this.attemptLL.getChildAt(0).setVisibility(0);
                            ((TextView) this.attemptLL.getChildAt(0)).setText(testTableTest_data.getStatus());
                            this.learn.setVisibility(8);
                            this.practice.setVisibility(8);
                        } else {
                            this.attemptLL.getChildAt(0).setVisibility(0);
                        }
                        ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter4.this.activity.getResources().getString(R.string.attempt_now));
                        this.learn.setVisibility(8);
                        this.practice.setVisibility(8);
                        if (Helper.isTestResume(list.get(i).getSet_type()) && list.get(i).getAttempt().equalsIgnoreCase("0") && list.get(i).getState() != null && list.get(i).getState().equalsIgnoreCase("0")) {
                            this.testResume.setVisibility(0);
                            this.attemptLL.getChildAt(0).setVisibility(8);
                            ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter4.this.activity.getResources().getString(R.string.attempt_now));
                        } else {
                            this.attemptLL.getChildAt(0).setVisibility(0);
                            ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter4.this.activity.getResources().getString(R.string.attempt_now));
                            this.testResume.setVisibility(8);
                        }
                    }
                    if (!TextUtils.isEmpty(list.get(i).getImage())) {
                        Helper.setThumbnailImage(SingleStudyAdapter4.this.activity, list.get(i).getImage(), SingleStudyAdapter4.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.imageIcon);
                    } else {
                        this.imageIcon.setImageResource(R.mipmap.square_placeholder_new);
                    }
                    if (list.get(i).getIs_locked().equals("0")) {
                        this.contantRL.setVisibility(0);
                        this.startdate.setVisibility(0);
                        this.subItemRV.setVisibility(0);
                    } else {
                        this.contantRL.setVisibility(8);
                        this.startdate.setVisibility(8);
                        this.subItemRV.setVisibility(8);
                    }
                } else {
                    this.share.setVisibility(8);
                    this.subItemRV.setVisibility(0);
                    this.attemptLL.setVisibility(8);
                    this.learn.setVisibility(8);
                    this.practice.setVisibility(8);
                    if (!TextUtils.isEmpty(list.get(i).getImage_icon())) {
                        Helper.setThumbnailImage(SingleStudyAdapter4.this.activity, list.get(i).getImage_icon(), SingleStudyAdapter4.this.activity.getResources().getDrawable(R.mipmap.square_placeholder_new), this.imageIcon);
                    } else {
                        this.imageIcon.setImageResource(R.mipmap.square_placeholder_new);
                    }
                    this.subItemRV.setVisibility(8);
                    this.subItemRV.setText(SingleStudyAdapter4.this.activity.getResources().getString(R.string.total_) + list.get(i).getCount());
                    this.titleCategory.setText(list.get(i).getTitle());
                }
                if (SingleStudyAdapter4.this.isSkip.equalsIgnoreCase("3")) {
                    this.practice.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyTestListHolder$$ExternalSyntheticLambda14
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$setData$4(list, position, view);
                        }
                    });
                    this.testResume.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyTestListHolder$$ExternalSyntheticLambda15
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$setData$5(list, position, view);
                        }
                    });
                    this.learn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyTestListHolder$$ExternalSyntheticLambda16
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$setData$6(list, position, view);
                        }
                    });
                    this.view_result.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyTestListHolder$$ExternalSyntheticLambda17
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$setData$7(list, position, view);
                        }
                    });
                    this.attemptLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyTestListHolder$$ExternalSyntheticLambda18
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$setData$16(list, position, view);
                        }
                    });
                    this.share.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyTestListHolder$$ExternalSyntheticLambda19
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$setData$17(position, view);
                        }
                    });
                } else {
                    this.studyitemLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyTestListHolder$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$setData$18(list, position, view);
                        }
                    });
                }
                this.lockRL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyTestListHolder$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$19(view);
                    }
                });
                return;
            }
            SingleStudyAdapter4.this.handleVisibilityNoData(this.ibt_single_sub_vd_RL, this.no_data_found_RL, this.backBtn);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$4(ArrayList arrayList, int i, View view) {
            if (!Helper.isConnected(SingleStudyAdapter4.this.activity)) {
                Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                return;
            }
            if (SingleStudyAdapter4.this.is_purchase.equalsIgnoreCase("1")) {
                SharedPreference.getInstance().putString("id", SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId());
                int i2 = i - 1;
                SingleStudyAdapter4.this.quiz_id = ((Lists) arrayList.get(i2)).getId();
                SingleStudyAdapter4.this.quiz_name = ((Lists) arrayList.get(i2)).getTest_series_name();
                SingleStudyAdapter4.this.totalQuestion = ((Lists) arrayList.get(i2)).getTotal_questions();
                SingleStudyAdapter4.this.result_date = ((Lists) arrayList.get(i2)).getResult_date();
                SingleStudyAdapter4.this.submission_type = ((Lists) arrayList.get(i2)).getSubmission_type();
                SingleStudyAdapter4.this.first_attempt = "0";
                SingleStudyAdapter4.this.videodata = (Lists) arrayList.get(i2);
                Helper.resolveTestPattern(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.videodata.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyTestListHolder$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setData$0();
                    }
                }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyTestListHolder$$ExternalSyntheticLambda11
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setData$1();
                    }
                });
                return;
            }
            int i3 = i - 1;
            if (((Lists) arrayList.get(i3)).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter4.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter4.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter4.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, SingleStudyAdapter4.this.activity);
                return;
            }
            SharedPreference.getInstance().putString("id", SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId());
            SingleStudyAdapter4.this.quiz_id = ((Lists) arrayList.get(i3)).getId();
            SingleStudyAdapter4.this.quiz_name = ((Lists) arrayList.get(i3)).getTest_series_name();
            SingleStudyAdapter4.this.totalQuestion = ((Lists) arrayList.get(i3)).getTotal_questions();
            SingleStudyAdapter4.this.first_attempt = "0";
            SingleStudyAdapter4.this.result_date = ((Lists) arrayList.get(i3)).getResult_date();
            SingleStudyAdapter4.this.videodata = (Lists) arrayList.get(i3);
            SingleStudyAdapter4.this.submission_type = ((Lists) arrayList.get(i3)).getSubmission_type();
            Helper.resolveTestPattern(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.videodata.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyTestListHolder$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setData$2();
                }
            }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyTestListHolder$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setData$3();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$0() {
            SingleStudyAdapter4.this.isSSCpattern = false;
            startTestAPI("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$1() {
            SingleStudyAdapter4.this.isSSCpattern = true;
            startTestAPI("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$2() {
            SingleStudyAdapter4.this.isSSCpattern = false;
            startTestAPI("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$3() {
            SingleStudyAdapter4.this.isSSCpattern = true;
            startTestAPI("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$5(ArrayList arrayList, int i, View view) {
            if (!Helper.isConnected(SingleStudyAdapter4.this.activity)) {
                Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                return;
            }
            if (SingleStudyAdapter4.this.is_purchase.equalsIgnoreCase("1")) {
                SharedPreference.getInstance().putString("id", SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId());
                int i2 = i - 1;
                SingleStudyAdapter4.this.quiz_id = ((Lists) arrayList.get(i2)).getId();
                if (((Lists) arrayList.get(i2)).getLang_used().equalsIgnoreCase("")) {
                    SingleStudyAdapter4.this.lang = Integer.parseInt(String.valueOf(((Lists) arrayList.get(i2)).getLang_id().charAt(0)));
                } else {
                    SingleStudyAdapter4.this.lang = Integer.parseInt(((Lists) arrayList.get(i2)).getLang_used());
                }
                SingleStudyAdapter4.this.quiz_name = ((Lists) arrayList.get(i2)).getTest_series_name();
                SingleStudyAdapter4.this.totalQuestion = ((Lists) arrayList.get(i2)).getTotal_questions();
                SingleStudyAdapter4.this.first_attempt = "0";
                SingleStudyAdapter4.this.result_date = ((Lists) arrayList.get(i2)).getResult_date();
                SingleStudyAdapter4.this.videodata = (Lists) arrayList.get(i2);
                startResumeTestAPI();
                return;
            }
            int i3 = i - 1;
            if (((Lists) arrayList.get(i3)).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter4.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter4.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter4.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, SingleStudyAdapter4.this.activity);
                return;
            }
            SharedPreference.getInstance().putString("id", SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId());
            SingleStudyAdapter4.this.quiz_id = ((Lists) arrayList.get(i3)).getId();
            SingleStudyAdapter4.this.lang = Integer.parseInt(((Lists) arrayList.get(i3)).getLang_used());
            SingleStudyAdapter4.this.quiz_name = ((Lists) arrayList.get(i3)).getTest_series_name();
            SingleStudyAdapter4.this.totalQuestion = ((Lists) arrayList.get(i3)).getTotal_questions();
            SingleStudyAdapter4.this.first_attempt = "0";
            SingleStudyAdapter4.this.result_date = ((Lists) arrayList.get(i3)).getResult_date();
            SingleStudyAdapter4.this.videodata = (Lists) arrayList.get(i3);
            startResumeTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$6(ArrayList arrayList, int i, View view) {
            if (!Helper.isConnected(SingleStudyAdapter4.this.activity)) {
                Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                return;
            }
            if (SingleStudyAdapter4.this.is_purchase.equalsIgnoreCase("1")) {
                SharedPreference.getInstance().putString("id", SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId());
                int i2 = i - 1;
                if (((Lists) arrayList.get(i2)).getState().equalsIgnoreCase("1")) {
                    SingleStudyAdapter4.this.quiz_id = ((Lists) arrayList.get(i2)).getId();
                    SingleStudyAdapter4.this.quiz_name = ((Lists) arrayList.get(i2)).getTest_series_name();
                    SingleStudyAdapter4.this.totalQuestion = ((Lists) arrayList.get(i2)).getTotal_questions();
                    result_without_submit(SingleStudyAdapter4.this.quiz_id, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId(), "1", SingleStudyAdapter4.this.quiz_name);
                    return;
                }
                SingleStudyAdapter4.this.quiz_id = ((Lists) arrayList.get(i2)).getId();
                SingleStudyAdapter4.this.quiz_name = ((Lists) arrayList.get(i2)).getTest_series_name();
                SingleStudyAdapter4.this.totalQuestion = ((Lists) arrayList.get(i2)).getTotal_questions();
                result_without_submit(SingleStudyAdapter4.this.quiz_id, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId(), "0", SingleStudyAdapter4.this.quiz_name);
                return;
            }
            int i3 = i - 1;
            if (((Lists) arrayList.get(i3)).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter4.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter4.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter4.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, SingleStudyAdapter4.this.activity);
                return;
            }
            SharedPreference.getInstance().putString("id", SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId());
            if (((Lists) arrayList.get(i3)).getState().equalsIgnoreCase("1")) {
                SingleStudyAdapter4.this.quiz_id = ((Lists) arrayList.get(i3)).getId();
                SingleStudyAdapter4.this.quiz_name = ((Lists) arrayList.get(i3)).getTest_series_name();
                SingleStudyAdapter4.this.totalQuestion = ((Lists) arrayList.get(i3)).getTotal_questions();
                result_without_submit(SingleStudyAdapter4.this.quiz_id, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId(), "1", SingleStudyAdapter4.this.quiz_name);
                return;
            }
            SingleStudyAdapter4.this.quiz_id = ((Lists) arrayList.get(i3)).getId();
            SingleStudyAdapter4.this.quiz_name = ((Lists) arrayList.get(i3)).getTest_series_name();
            SingleStudyAdapter4.this.totalQuestion = ((Lists) arrayList.get(i3)).getTotal_questions();
            result_without_submit(SingleStudyAdapter4.this.quiz_id, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId(), "0", SingleStudyAdapter4.this.quiz_name);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$7(ArrayList arrayList, int i, View view) {
            if (!Helper.isConnected(SingleStudyAdapter4.this.activity)) {
                Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                return;
            }
            if (SingleStudyAdapter4.this.is_purchase.equalsIgnoreCase("1")) {
                SharedPreference.getInstance().putString("id", SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId());
                int i2 = i - 1;
                SingleStudyAdapter4.this.quiz_id = ((Lists) arrayList.get(i2)).getId();
                SingleStudyAdapter4.this.quiz_name = ((Lists) arrayList.get(i2)).getTest_series_name();
                SingleStudyAdapter4.this.totalQuestion = ((Lists) arrayList.get(i2)).getTotal_questions();
                if (((Lists) arrayList.get(i2)).getState().equalsIgnoreCase("1")) {
                    if (((Lists) arrayList.get(i2)).getResult_date() == null || ((Lists) arrayList.get(i2)).getResult_date().equalsIgnoreCase("") || ((Lists) arrayList.get(i2)).getResult_date().equalsIgnoreCase("0") || ((Lists) arrayList.get(i2)).getResult_date().equalsIgnoreCase("1")) {
                        Intent intent = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) QuizActivity.class);
                        intent.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                        intent.putExtra("status", SingleStudyAdapter4.this.quiz_id);
                        intent.putExtra("name", SingleStudyAdapter4.this.quiz_name);
                        intent.putExtra("first_attempt", "1");
                        Helper.gotoActivity(intent, SingleStudyAdapter4.this.activity);
                        return;
                    }
                    if (MakeMyExam.time_server >= Long.parseLong(((Lists) arrayList.get(i2)).getResult_date()) * 1000) {
                        Intent intent2 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) QuizActivity.class);
                        intent2.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                        intent2.putExtra("status", SingleStudyAdapter4.this.quiz_id);
                        intent2.putExtra("name", SingleStudyAdapter4.this.quiz_name);
                        intent2.putExtra("first_attempt", "1");
                        Helper.gotoActivity(intent2, SingleStudyAdapter4.this.activity);
                        return;
                    }
                    Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.your_result_will_be_declare_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(((Lists) arrayList.get(i2)).getResult_date()) * 1000)), 0).show();
                    return;
                }
                if (((Lists) arrayList.get(i2)).getResult_date() == null || ((Lists) arrayList.get(i2)).getResult_date().equalsIgnoreCase("") || ((Lists) arrayList.get(i2)).getResult_date().equalsIgnoreCase("0") || ((Lists) arrayList.get(i2)).getResult_date().equalsIgnoreCase("1")) {
                    Intent intent3 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) QuizActivity.class);
                    intent3.putExtra(Const.FRAG_TYPE, "leader_board");
                    intent3.putExtra("status", SingleStudyAdapter4.this.quiz_id);
                    intent3.putExtra("name", SingleStudyAdapter4.this.quiz_name);
                    SingleStudyAdapter4.this.activity.startActivity(intent3);
                    return;
                }
                if (MakeMyExam.time_server >= Long.parseLong(((Lists) arrayList.get(i2)).getResult_date()) * 1000) {
                    Intent intent4 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) QuizActivity.class);
                    intent4.putExtra(Const.FRAG_TYPE, "leader_board");
                    intent4.putExtra("status", SingleStudyAdapter4.this.quiz_id);
                    intent4.putExtra("name", SingleStudyAdapter4.this.quiz_name);
                    SingleStudyAdapter4.this.activity.startActivity(intent4);
                    return;
                }
                Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.your_result_will_be_declare_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(((Lists) arrayList.get(i2)).getResult_date()) * 1000)), 0).show();
                return;
            }
            int i3 = i - 1;
            if (((Lists) arrayList.get(i3)).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter4.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter4.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent5 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) PurchaseActivity.class);
                intent5.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter4.this.singleStudy);
                intent5.putExtra(Const.IS_BOOK, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent5.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent5, SingleStudyAdapter4.this.activity);
                return;
            }
            if (((Lists) arrayList.get(i3)).getResult_date() == null || ((Lists) arrayList.get(i3)).getResult_date().equalsIgnoreCase("") || ((Lists) arrayList.get(i3)).getResult_date().equalsIgnoreCase("0") || ((Lists) arrayList.get(i3)).getResult_date().equalsIgnoreCase("1")) {
                SharedPreference.getInstance().putString("id", SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId());
                SingleStudyAdapter4.this.quiz_id = ((Lists) arrayList.get(i3)).getId();
                SingleStudyAdapter4.this.quiz_name = ((Lists) arrayList.get(i3)).getTest_series_name();
                SingleStudyAdapter4.this.totalQuestion = ((Lists) arrayList.get(i3)).getTotal_questions();
                if (((Lists) arrayList.get(i3)).getState().equalsIgnoreCase("1")) {
                    if (((Lists) arrayList.get(i3)).getResult_date() == null || ((Lists) arrayList.get(i3)).getResult_date().equalsIgnoreCase("") || ((Lists) arrayList.get(i3)).getResult_date().equalsIgnoreCase("0") || ((Lists) arrayList.get(i3)).getResult_date().equalsIgnoreCase("1")) {
                        Intent intent6 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) QuizActivity.class);
                        intent6.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                        intent6.putExtra("status", SingleStudyAdapter4.this.quiz_id);
                        intent6.putExtra("name", SingleStudyAdapter4.this.quiz_name);
                        intent6.putExtra("first_attempt", "1");
                        Helper.gotoActivity(intent6, SingleStudyAdapter4.this.activity);
                        return;
                    }
                    Intent intent7 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) QuizActivity.class);
                    intent7.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                    intent7.putExtra("status", SingleStudyAdapter4.this.quiz_id);
                    intent7.putExtra("name", SingleStudyAdapter4.this.quiz_name);
                    intent7.putExtra("first_attempt", "1");
                    Helper.gotoActivity(intent7, SingleStudyAdapter4.this.activity);
                    return;
                }
                Intent intent8 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) QuizActivity.class);
                intent8.putExtra(Const.FRAG_TYPE, "leader_board");
                intent8.putExtra("status", SingleStudyAdapter4.this.quiz_id);
                intent8.putExtra("name", SingleStudyAdapter4.this.quiz_name);
                SingleStudyAdapter4.this.activity.startActivity(intent8);
                return;
            }
            if (MakeMyExam.time_server >= Long.parseLong(((Lists) arrayList.get(i3)).getResult_date()) * 1000) {
                SharedPreference.getInstance().putString("id", SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId());
                SingleStudyAdapter4.this.quiz_id = ((Lists) arrayList.get(i3)).getId();
                SingleStudyAdapter4.this.quiz_name = ((Lists) arrayList.get(i3)).getTest_series_name();
                SingleStudyAdapter4.this.totalQuestion = ((Lists) arrayList.get(i3)).getTotal_questions();
                if (((Lists) arrayList.get(i3)).getState().equalsIgnoreCase("1")) {
                    if (((Lists) arrayList.get(i3)).getResult_date() == null || ((Lists) arrayList.get(i3)).getResult_date().equalsIgnoreCase("") || ((Lists) arrayList.get(i3)).getResult_date().equalsIgnoreCase("0") || ((Lists) arrayList.get(i3)).getResult_date().equalsIgnoreCase("1")) {
                        Intent intent9 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) QuizActivity.class);
                        intent9.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                        intent9.putExtra("status", SingleStudyAdapter4.this.quiz_id);
                        intent9.putExtra("name", SingleStudyAdapter4.this.quiz_name);
                        intent9.putExtra("first_attempt", "1");
                        Helper.gotoActivity(intent9, SingleStudyAdapter4.this.activity);
                        return;
                    }
                    Intent intent10 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) QuizActivity.class);
                    intent10.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                    intent10.putExtra("status", SingleStudyAdapter4.this.quiz_id);
                    intent10.putExtra("name", SingleStudyAdapter4.this.quiz_name);
                    intent10.putExtra("first_attempt", "1");
                    Helper.gotoActivity(intent10, SingleStudyAdapter4.this.activity);
                    return;
                }
                Intent intent11 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) QuizActivity.class);
                intent11.putExtra(Const.FRAG_TYPE, "leader_board");
                intent11.putExtra("status", SingleStudyAdapter4.this.quiz_id);
                intent11.putExtra("name", SingleStudyAdapter4.this.quiz_name);
                SingleStudyAdapter4.this.activity.startActivity(intent11);
                return;
            }
            Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.your_result_will_be_declare_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(((Lists) arrayList.get(i3)).getResult_date()) * 1000)), 0).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$16(ArrayList arrayList, int i, View view) {
            if (!Helper.isConnected(SingleStudyAdapter4.this.activity)) {
                Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                return;
            }
            if (SingleStudyAdapter4.this.is_purchase.equalsIgnoreCase("1")) {
                SharedPreference.getInstance().putString("id", SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId());
                if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("RE-ATTEMPT")) {
                    SingleStudyAdapter4.this.attemptOrReAttempt = "Re-attempt";
                    int i2 = i - 1;
                    SingleStudyAdapter4.this.quiz_id = ((Lists) arrayList.get(i2)).getId();
                    SingleStudyAdapter4.this.quiz_name = ((Lists) arrayList.get(i2)).getTest_series_name();
                    SingleStudyAdapter4.this.totalQuestion = ((Lists) arrayList.get(i2)).getTotal_questions();
                    SingleStudyAdapter4.this.result_date = ((Lists) arrayList.get(i2)).getResult_date();
                    SingleStudyAdapter4.this.submission_type = ((Lists) arrayList.get(i2)).getSubmission_type();
                    SingleStudyAdapter4.this.first_attempt = "0";
                    SingleStudyAdapter4.this.videodata = (Lists) arrayList.get(i2);
                    Helper.resolveTestPattern(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.videodata.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyTestListHolder$$ExternalSyntheticLambda3
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$setData$8();
                        }
                    }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyTestListHolder$$ExternalSyntheticLambda4
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$setData$9();
                        }
                    });
                    return;
                }
                if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("Attempt Now")) {
                    SingleStudyAdapter4.this.attemptOrReAttempt = Const.ATTEMPT;
                    int i3 = i - 1;
                    SingleStudyAdapter4.this.quiz_id = ((Lists) arrayList.get(i3)).getId();
                    SingleStudyAdapter4.this.quiz_name = ((Lists) arrayList.get(i3)).getTest_series_name();
                    SingleStudyAdapter4.this.totalQuestion = ((Lists) arrayList.get(i3)).getTotal_questions();
                    SingleStudyAdapter4.this.first_attempt = "1";
                    SingleStudyAdapter4.this.result_date = ((Lists) arrayList.get(i3)).getResult_date();
                    SingleStudyAdapter4.this.submission_type = ((Lists) arrayList.get(i3)).getSubmission_type();
                    SingleStudyAdapter4.this.videodata = (Lists) arrayList.get(i3);
                    Helper.resolveTestPattern(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.videodata.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyTestListHolder$$ExternalSyntheticLambda5
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$setData$10();
                        }
                    }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyTestListHolder$$ExternalSyntheticLambda6
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$setData$11();
                        }
                    });
                    return;
                }
                if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("ATTEMPTED")) {
                    int i4 = i - 1;
                    if (((Lists) arrayList.get(i4)).getResult_date() != null && !((Lists) arrayList.get(i4)).getResult_date().equalsIgnoreCase("0") && !((Lists) arrayList.get(i4)).getResult_date().equalsIgnoreCase("1") && !((Lists) arrayList.get(i4)).getResult_date().equalsIgnoreCase("")) {
                        Snackbar.make(view, SingleStudyAdapter4.this.activity.getResources().getString(R.string.your_result_will_be_declared_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(((Lists) arrayList.get(i4)).getResult_date()) * 1000)), -1).show();
                        return;
                    } else if (SingleStudyAdapter4.this.utkashRoom.getTestDao().is_test_exit(((Lists) arrayList.get(i4)).getId(), MakeMyExam.userId)) {
                        Snackbar.make(view, SingleStudyAdapter4.this.activity.getResources().getString(R.string.your_result_is_getting_ready_please_refresh_your_page), -1).show();
                        return;
                    } else {
                        Snackbar.make(view, SingleStudyAdapter4.this.activity.getResources().getString(R.string.your_test_has_already_been_submitted), -1).show();
                        return;
                    }
                }
                if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("View Rank") || ((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("VIEW RESULT")) {
                    int i5 = i - 1;
                    SingleStudyAdapter4.this.quiz_id = ((Lists) arrayList.get(i5)).getId();
                    SingleStudyAdapter4.this.quiz_name = ((Lists) arrayList.get(i5)).getTest_series_name();
                    SingleStudyAdapter4.this.totalQuestion = ((Lists) arrayList.get(i5)).getTotal_questions();
                    if (((Lists) arrayList.get(i5)).getState().equalsIgnoreCase("1")) {
                        if (((Lists) arrayList.get(i5)).getResult_date() == null || ((Lists) arrayList.get(i5)).getResult_date().equalsIgnoreCase("") || ((Lists) arrayList.get(i5)).getResult_date().equalsIgnoreCase("0") || ((Lists) arrayList.get(i5)).getResult_date().equalsIgnoreCase("1")) {
                            Intent intent = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) QuizActivity.class);
                            intent.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                            intent.putExtra("status", SingleStudyAdapter4.this.quiz_id);
                            intent.putExtra("name", SingleStudyAdapter4.this.quiz_name);
                            intent.putExtra("first_attempt", "1");
                            Helper.gotoActivity(intent, SingleStudyAdapter4.this.activity);
                            return;
                        }
                        Intent intent2 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) QuizActivity.class);
                        intent2.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                        intent2.putExtra("status", SingleStudyAdapter4.this.quiz_id);
                        intent2.putExtra("name", SingleStudyAdapter4.this.quiz_name);
                        intent2.putExtra("first_attempt", "1");
                        Helper.gotoActivity(intent2, SingleStudyAdapter4.this.activity);
                        return;
                    }
                    Intent intent3 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) QuizActivity.class);
                    intent3.putExtra(Const.FRAG_TYPE, "leader_board");
                    intent3.putExtra("status", SingleStudyAdapter4.this.quiz_id);
                    intent3.putExtra("name", SingleStudyAdapter4.this.quiz_name);
                    SingleStudyAdapter4.this.activity.startActivity(intent3);
                    return;
                }
                if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase(SingleStudyAdapter4.this.activity.getResources().getString(R.string.upcoming_test))) {
                    Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.test_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(((Lists) arrayList.get(i - 1)).getStart_date()) * 1000)), 0).show();
                    return;
                }
                return;
            }
            int i6 = i - 1;
            if (((Lists) arrayList.get(i6)).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter4.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter4.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent4 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) PurchaseActivity.class);
                intent4.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter4.this.singleStudy);
                intent4.putExtra(Const.IS_BOOK, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent4.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent4, SingleStudyAdapter4.this.activity);
                return;
            }
            SharedPreference.getInstance().putString("id", SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId());
            if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("RE-ATTEMPT")) {
                SingleStudyAdapter4.this.quiz_id = ((Lists) arrayList.get(i6)).getId();
                SingleStudyAdapter4.this.quiz_name = ((Lists) arrayList.get(i6)).getTest_series_name();
                SingleStudyAdapter4.this.totalQuestion = ((Lists) arrayList.get(i6)).getTotal_questions();
                SingleStudyAdapter4.this.first_attempt = "0";
                SingleStudyAdapter4.this.result_date = ((Lists) arrayList.get(i6)).getResult_date();
                SingleStudyAdapter4.this.submission_type = ((Lists) arrayList.get(i6)).getSubmission_type();
                SingleStudyAdapter4.this.videodata = (Lists) arrayList.get(i6);
                Helper.resolveTestPattern(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.videodata.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyTestListHolder$$ExternalSyntheticLambda7
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setData$12();
                    }
                }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyTestListHolder$$ExternalSyntheticLambda8
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setData$13();
                    }
                });
                return;
            }
            if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("Attempt Now")) {
                SingleStudyAdapter4.this.quiz_id = ((Lists) arrayList.get(i6)).getId();
                SingleStudyAdapter4.this.quiz_name = ((Lists) arrayList.get(i6)).getTest_series_name();
                SingleStudyAdapter4.this.totalQuestion = ((Lists) arrayList.get(i6)).getTotal_questions();
                SingleStudyAdapter4.this.first_attempt = "1";
                SingleStudyAdapter4.this.result_date = ((Lists) arrayList.get(i6)).getResult_date();
                SingleStudyAdapter4.this.submission_type = ((Lists) arrayList.get(i6)).getSubmission_type();
                SingleStudyAdapter4.this.videodata = (Lists) arrayList.get(i6);
                Helper.resolveTestPattern(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.videodata.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyTestListHolder$$ExternalSyntheticLambda9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setData$14();
                    }
                }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyTestListHolder$$ExternalSyntheticLambda10
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setData$15();
                    }
                });
                return;
            }
            if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("ATTEMPTED")) {
                if (((Lists) arrayList.get(i6)).getResult_date() != null && !((Lists) arrayList.get(i6)).getResult_date().equalsIgnoreCase("0") && !((Lists) arrayList.get(i6)).getResult_date().equalsIgnoreCase("1") && !((Lists) arrayList.get(i6)).getResult_date().equalsIgnoreCase("")) {
                    Snackbar.make(view, SingleStudyAdapter4.this.activity.getResources().getString(R.string.your_result_will_be_declared_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(((Lists) arrayList.get(i6)).getResult_date()) * 1000)), -1).show();
                    return;
                } else if (SingleStudyAdapter4.this.utkashRoom.getTestDao().is_test_exit(((Lists) arrayList.get(i6)).getId(), MakeMyExam.userId)) {
                    Snackbar.make(view, SingleStudyAdapter4.this.activity.getResources().getString(R.string.your_result_is_getting_ready_please_refresh_your_page), -1).show();
                    return;
                } else {
                    Snackbar.make(view, SingleStudyAdapter4.this.activity.getResources().getString(R.string.your_result_has_already_been_submitted), -1).show();
                    return;
                }
            }
            if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("View Rank") || ((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("VIEW RESULT")) {
                SingleStudyAdapter4.this.quiz_id = ((Lists) arrayList.get(i6)).getId();
                SingleStudyAdapter4.this.quiz_name = ((Lists) arrayList.get(i6)).getTest_series_name();
                SingleStudyAdapter4.this.totalQuestion = ((Lists) arrayList.get(i6)).getTotal_questions();
                if (((Lists) arrayList.get(i6)).getState().equalsIgnoreCase("1")) {
                    if (((Lists) arrayList.get(i6)).getResult_date() == null || ((Lists) arrayList.get(i6)).getResult_date().equalsIgnoreCase("") || ((Lists) arrayList.get(i6)).getResult_date().equalsIgnoreCase("0") || ((Lists) arrayList.get(i6)).getResult_date().equalsIgnoreCase("1")) {
                        Intent intent5 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) QuizActivity.class);
                        intent5.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                        intent5.putExtra("status", SingleStudyAdapter4.this.quiz_id);
                        intent5.putExtra("name", SingleStudyAdapter4.this.quiz_name);
                        intent5.putExtra("first_attempt", "1");
                        Helper.gotoActivity(intent5, SingleStudyAdapter4.this.activity);
                        return;
                    }
                    Intent intent6 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) QuizActivity.class);
                    intent6.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                    intent6.putExtra("status", SingleStudyAdapter4.this.quiz_id);
                    intent6.putExtra("name", SingleStudyAdapter4.this.quiz_name);
                    intent6.putExtra("first_attempt", "1");
                    Helper.gotoActivity(intent6, SingleStudyAdapter4.this.activity);
                    return;
                }
                Intent intent7 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) QuizActivity.class);
                intent7.putExtra(Const.FRAG_TYPE, "leader_board");
                intent7.putExtra("status", SingleStudyAdapter4.this.quiz_id);
                intent7.putExtra("name", SingleStudyAdapter4.this.quiz_name);
                SingleStudyAdapter4.this.activity.startActivity(intent7);
                return;
            }
            if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase(SingleStudyAdapter4.this.activity.getResources().getString(R.string.upcoming_test))) {
                Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.test_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(((Lists) arrayList.get(i6)).getStart_date()) * 1000)), 0).show();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$8() {
            SingleStudyAdapter4.this.isSSCpattern = false;
            startTestAPI("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$9() {
            SingleStudyAdapter4.this.isSSCpattern = true;
            startTestAPI("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$10() {
            SingleStudyAdapter4.this.isSSCpattern = false;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$11() {
            SingleStudyAdapter4.this.isSSCpattern = true;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$12() {
            SingleStudyAdapter4.this.isSSCpattern = false;
            startTestAPI("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$13() {
            SingleStudyAdapter4.this.isSSCpattern = true;
            startTestAPI("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$14() {
            SingleStudyAdapter4.this.isSSCpattern = false;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$15() {
            SingleStudyAdapter4.this.isSSCpattern = true;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$17(int i, View view) {
            if (SingleStudyAdapter4.this.is_purchase.equalsIgnoreCase("1")) {
                int i2 = i - 1;
                Helper.shareTestg(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getTopic_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getRevert_api(), Const.TEST, SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getImage(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getTitle(), SingleStudy.parentCourseId);
                return;
            }
            int i3 = i - 1;
            if (SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter4.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter4.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter4.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, SingleStudyAdapter4.this.activity);
                return;
            }
            Helper.shareTestg(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getPayload().getCourse_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getId(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getPayload().getTopic_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getPayload().getTile_type(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getPayload().getTile_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getPayload().getRevert_api(), Const.TEST, SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getImage(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getTitle(), SingleStudy.parentCourseId);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$18(ArrayList arrayList, int i, View view) {
            int i2 = i - 1;
            if (((Lists) arrayList.get(i2)).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter4.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter4.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter4.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, SingleStudyAdapter4.this.activity);
                return;
            }
            if (SingleStudyAdapter4.this.isSkip.equalsIgnoreCase("1") || SingleStudyAdapter4.this.isSkip.equalsIgnoreCase("2")) {
                Intent intent2 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) CourseActivity.class);
                SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(SingleStudyAdapter4.this.singleStudy != null ? SingleStudyAdapter4.this.singleStudy : new CourseDetail()));
                SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(SingleStudyAdapter4.this.examPrepItem != null ? SingleStudyAdapter4.this.examPrepItem : new ExamPrepItem()));
                SharedPreference.getInstance().putString("list", new Gson().toJson(SingleStudyAdapter4.this.examPrepItem.getList().get(i2) != null ? SingleStudyAdapter4.this.examPrepItem.getList().get(i2) : new Lists()));
                intent2.putExtra(Const.FRAG_TYPE, Const.EXAMPREPLAST);
                intent2.putExtra(Const.IS_COMBO, SingleStudyAdapter4.this.isCombo);
                intent2.putExtra("title", SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getTitle());
                intent2.putExtra("content_type", SingleStudyAdapter4.this.contentType);
                intent2.putExtra(Const.TEST_TYPE, SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getCount());
                intent2.putExtra("tile_id", SingleStudyAdapter4.this.tileIdAPI);
                intent2.putExtra(Const.TILE_TYPE, SingleStudyAdapter4.this.tileTypeAPI);
                intent2.putExtra(Const.LIST_SUBJECT, SingleStudyAdapter4.this.examPrepItem.getList().get(i2));
                intent2.putExtra(Const.REVERT_API, SingleStudyAdapter4.this.revertAPI);
                Helper.gotoActivity(intent2, SingleStudyAdapter4.this.activity);
                return;
            }
            if (SingleStudyAdapter4.this.isSkip.equalsIgnoreCase("3")) {
                return;
            }
            ExamPrepItem examPrepItem = new ExamPrepItem();
            examPrepItem.setList(SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getList());
            Intent intent3 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) CourseActivity.class);
            SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(SingleStudyAdapter4.this.singleStudy != null ? SingleStudyAdapter4.this.singleStudy : new CourseDetail()));
            SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(examPrepItem));
            SharedPreference.getInstance().putString("list", new Gson().toJson(arrayList.get(i2) != null ? arrayList.get(i2) : new Lists()));
            intent3.putExtra(Const.FRAG_TYPE, Const.EXAMPREP);
            intent3.putExtra(Const.IS_COMBO, SingleStudyAdapter4.this.isCombo);
            intent3.putExtra("content_type", SingleStudyAdapter4.this.contentType);
            intent3.putExtra("title", SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail() != null ? SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getTitle() : "Course");
            intent3.putExtra("tile_id", SingleStudyAdapter4.this.tileIdAPI);
            intent3.putExtra(Const.TILE_TYPE, SingleStudyAdapter4.this.tileTypeAPI);
            intent3.putExtra(Const.REVERT_API, SingleStudyAdapter4.this.revertAPI);
            Helper.gotoActivity(intent3, SingleStudyAdapter4.this.activity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$19(View view) {
            Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getString(R.string.contentislock), 0).show();
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

        private void startTestAPI(String s) {
            SingleStudyAdapter4.this.isReAttemptOrPractice = true;
            SingleStudyAdapter4 singleStudyAdapter4 = SingleStudyAdapter4.this;
            new NetworkCall(singleStudyAdapter4, singleStudyAdapter4.activity).NetworkAPICall(API.API_GET_TEST_INSTRUCTION_DATA, "", true, false);
        }

        private void startResumeTestAPI() {
            SingleStudyAdapter4.this.first_attempt = "1";
            SingleStudyAdapter4.this.isSSCpattern = false;
            SingleStudyAdapter4 singleStudyAdapter4 = SingleStudyAdapter4.this;
            new NetworkCall(singleStudyAdapter4, singleStudyAdapter4.activity).NetworkAPICall(API.API_GET_INFO_TEST_SERIES, "", true, false);
        }

        private void startTestAPI() {
            SingleStudyAdapter4.this.isReAttemptOrPractice = false;
            SingleStudyAdapter4 singleStudyAdapter4 = SingleStudyAdapter4.this;
            new NetworkCall(singleStudyAdapter4, singleStudyAdapter4.activity).NetworkAPICall(API.API_GET_TEST_INSTRUCTION_DATA, "", true, false);
        }

        public void result_without_submit(final String quiz_id, String course_id, String s, final String quiz_name) {
            if (Helper.isNetworkConnected(SingleStudyAdapter4.this.activity)) {
                final Progress progress = new Progress(SingleStudyAdapter4.this.activity);
                progress.show();
                APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setTest_id(quiz_id);
                encryptionData.setCourse_id(course_id);
                encryptionData.setFirst_attempt(s);
                aPIInterface.getTestlearn(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new Callback<String>() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4.SingleStudyTestListHolder.1
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
                                Helper.showToastSecurity(SingleStudyAdapter4.this.activity);
                                return;
                            }
                            try {
                                if (resultTestSeries_Report.getStatus().equalsIgnoreCase("true")) {
                                    SharedPreference.getInstance().putString("testresult", new Gson().toJson(resultTestSeries_Report));
                                    Intent intent = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) ViewSolutionActivity.class);
                                    intent.putExtra(Const.TESTSEGMENT_ID, quiz_id);
                                    intent.putExtra(Const.FRAG_TYPE, Const.SOLUTIONREPORT);
                                    intent.putExtra("name", quiz_name);
                                    intent.putExtra("type", "learn");
                                    if (!resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("1")) {
                                        if (resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("2")) {
                                            SingleStudyAdapter4.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                                        }
                                    } else {
                                        SingleStudyAdapter4.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                                    }
                                    intent.putExtra(Const.LANG, SingleStudyAdapter4.this.lang);
                                    Helper.gotoActivity(intent, SingleStudyAdapter4.this.activity);
                                    return;
                                }
                                progress.dismiss();
                                RetrofitResponse.GetApiData(SingleStudyAdapter4.this.activity, jSONObject.optString("auth_code"), jSONObject.optString("message"), false);
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
            Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.Retry_with_Internet_connection), 1).show();
        }

        public void netoworkCallForQuizResult2(final String quiz_id, String course_id, String s, final String quiz_name) {
            if (Helper.isNetworkConnected(SingleStudyAdapter4.this.activity)) {
                final Progress progress = new Progress(SingleStudyAdapter4.this.activity);
                progress.show();
                APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setTest_id(quiz_id);
                encryptionData.setCourse_id(course_id);
                encryptionData.setFirst_attempt(s);
                aPIInterface.getTestResult(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new Callback<String>() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4.SingleStudyTestListHolder.2
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
                                Helper.showToastSecurity(SingleStudyAdapter4.this.activity);
                                return;
                            }
                            try {
                                if (resultTestSeries_Report.getStatus().equalsIgnoreCase("true")) {
                                    if (resultTestSeries_Report.getData().getQuestions() != null && resultTestSeries_Report.getData().getQuestions().size() > 0) {
                                        SharedPreference.getInstance().putString("testresult", new Gson().toJson(resultTestSeries_Report));
                                        Intent intent = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) ViewSolutionActivity.class);
                                        intent.putExtra(Const.TESTSEGMENT_ID, quiz_id);
                                        intent.putExtra(Const.FRAG_TYPE, Const.SOLUTIONREPORT);
                                        intent.putExtra("name", quiz_name);
                                        intent.putExtra("type", "learn");
                                        if (!resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("1")) {
                                            if (resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("2")) {
                                                SingleStudyAdapter4.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                                            }
                                        } else {
                                            SingleStudyAdapter4.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                                        }
                                        intent.putExtra(Const.LANG, SingleStudyAdapter4.this.lang);
                                        Helper.gotoActivity(intent, SingleStudyAdapter4.this.activity);
                                        return;
                                    }
                                    Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.no_question_found), 0).show();
                                    return;
                                }
                                progress.dismiss();
                                RetrofitResponse.GetApiData(SingleStudyAdapter4.this.activity, jSONObject.optString("auth_code"), jSONObject.optString("message"), false);
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
            Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.Retry_with_Internet_connection), 1).show();
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

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == 0) {
            ((SingleStudyHeaderHolder) holder).setData(this.singleStudy);
            return;
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
        } else if (getItemViewType(position) == 9) {
            ((StudyNoDataViewHolder) holder).setData();
        } else if (getItemViewType(position) == 10) {
            ((SingleStudySubjectiveTestListHolder) holder).setData(this.examPrepItem.getList(), position - 1);
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
            this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4.StudyNoDataViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    SingleStudyAdapter4.this.activity.finish();
                }
            });
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
            if (faqData != null && faqData.size() > 0 && SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getDisplay_locked().equalsIgnoreCase("1")) {
                this.no_data_found_RL.setVisibility(8);
                this.recyclerView.setVisibility(0);
                this.recyclerView.setLayoutManager(new LinearLayoutManager(SingleStudyAdapter4.this.activity, 1, false));
                this.recyclerView.setAdapter(SingleStudyAdapter4.this.new FaqListRecyclerAdapter(faqData, 0));
                this.recyclerView.setNestedScrollingEnabled(false);
                return;
            }
            this.no_data_found_RL.setVisibility(0);
            this.recyclerView.setVisibility(8);
            this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4.FAQViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    SingleStudyAdapter4.this.activity.finish();
                }
            });
        }
    }

    public class FaqListRecyclerAdapter extends RecyclerView.Adapter<FaqListHolder> {
        ArrayList<FaqData> faqData;
        int positions;

        public FaqListRecyclerAdapter(ArrayList<FaqData> faqData, int position) {
            this.positions = position;
            this.faqData = faqData;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public FaqListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new FaqListHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_faq_data, parent, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.faqData.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(FaqListHolder holder, int position) {
            holder.setSingleFAQData(this.faqData.get(position).getQuestion(), position, this.faqData.get(position).getDescription());
        }

        public class FaqListHolder extends RecyclerView.ViewHolder {
            private TextView answertextTV;
            private ImageView dropDownIV;
            private LinearLayout mainLL;
            private LinearLayout parentLL;
            private TextView questiontextTV;

            public FaqListHolder(View itemView) {
                super(itemView);
                this.questiontextTV = (TextView) itemView.findViewById(R.id.questiontextTV);
                this.dropDownIV = (ImageView) itemView.findViewById(R.id.dropDownIV);
                this.answertextTV = (TextView) itemView.findViewById(R.id.answertextTV);
                this.mainLL = (LinearLayout) itemView.findViewById(R.id.lowerViewItem);
                this.parentLL = (LinearLayout) itemView.findViewById(R.id.parentLL);
            }

            public void setSingleFAQData(String singlefaqdata, int pos, String answersData) {
                this.parentLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4.FaqListRecyclerAdapter.FaqListHolder.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (FaqListHolder.this.mainLL.getVisibility() == 8) {
                            FaqListHolder.this.mainLL.setVisibility(0);
                            FaqListHolder.this.dropDownIV.setImageResource(R.mipmap.up_black);
                        } else {
                            FaqListHolder.this.mainLL.setVisibility(8);
                            FaqListHolder.this.dropDownIV.setImageResource(R.mipmap.down_black);
                        }
                    }
                });
                this.questiontextTV.setText(singlefaqdata);
                this.answertextTV.setText(answersData);
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
        TextView titleCategory;
        Button upload;

        public SingleStudySubjectiveTestListHolder(View itemView) {
            super(itemView);
            this.STORAGE_PERMISSION_TYPE = 3;
            this.REQUEST_CODE_MULTIPLE_PIKER = 1203;
            this.lockRL = (RelativeLayout) itemView.findViewById(R.id.lockRL);
            this.parentLL = (RelativeLayout) itemView.findViewById(R.id.parentLL);
            this.subjectBTNLL = (LinearLayout) itemView.findViewById(R.id.subjectBTNLL);
            this.studyitemLL = (RelativeLayout) itemView.findViewById(R.id.study_single_itemLL);
            this.imageIcon = (ImageView) itemView.findViewById(R.id.profileImage);
            this.titleCategory = (TextView) itemView.findViewById(R.id.examPrepTitleTV);
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
            if (list != null && list.size() > 0 && SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getDisplay_locked().equalsIgnoreCase("1")) {
                this.ibt_single_sub_vd_RL.setVisibility(0);
                this.no_data_found_RL.setVisibility(8);
                if (TextUtils.isEmpty(list.get(position).getIs_locked())) {
                    list.get(position).setIs_locked("0");
                }
                if (SingleStudyAdapter4.this.singleStudy != null && SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail() != null && SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getIsPurchased().equals("1")) {
                    list.get(position).setIs_locked("0");
                }
                if (list.get(position).getIs_locked().equals("0")) {
                    this.lockRL.setVisibility(8);
                } else {
                    this.lockRL.setVisibility(0);
                }
                if (SingleStudyAdapter4.this.isSkip.equalsIgnoreCase("3")) {
                    if (Helper.isShowShareButton(SingleStudyAdapter4.this.leftMenu)) {
                        this.share.setVisibility(0);
                    } else {
                        this.share.setVisibility(8);
                    }
                    this.titleCategory.setText(list.get(position).getTest_series_name());
                    if (Helper.isLiveTest(list.get(position).getTest_series_type()) && !list.get(position).getEnd_date().equalsIgnoreCase("0") && !list.get(position).getEnd_date().equalsIgnoreCase("")) {
                        this.subItemRV.setVisibility(0);
                        this.subItemRV.setText(SingleStudyAdapter4.this.activity.getResources().getString(R.string.test_end) + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(list.get(position).getEnd_date()) * 1000))));
                    } else {
                        this.subItemRV.setVisibility(8);
                    }
                    if (Helper.isLiveTest(list.get(position).getTest_series_type()) && !list.get(position).getStart_date().equalsIgnoreCase("0") && !list.get(position).getStart_date().equalsIgnoreCase("")) {
                        this.startdate.setVisibility(0);
                        this.startdate.setText(SingleStudyAdapter4.this.activity.getResources().getString(R.string.test_start) + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(list.get(position).getStart_date()) * 1000))));
                    } else {
                        this.startdate.setVisibility(8);
                    }
                    this.attemptLL.setVisibility(8);
                    if (!TextUtils.isEmpty(list.get(position).getImage())) {
                        Helper.setThumbnailImage(SingleStudyAdapter4.this.activity, list.get(position).getImage(), SingleStudyAdapter4.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.imageIcon);
                    } else {
                        this.imageIcon.setImageResource(R.mipmap.square_placeholder);
                    }
                    if (SingleStudyAdapter4.this.isSkip.equalsIgnoreCase("3")) {
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
                    Helper.setThumbnailImage(SingleStudyAdapter4.this.activity, list.get(position).getImage_icon(), SingleStudyAdapter4.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.imageIcon);
                } else {
                    this.imageIcon.setImageResource(R.mipmap.square_placeholder);
                }
                this.subItemRV.setVisibility(8);
                this.subItemRV.setText(SingleStudyAdapter4.this.activity.getResources().getString(R.string.total_) + list.get(position).getCount());
                this.titleCategory.setText(list.get(position).getTitle());
                this.studyitemLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4.SingleStudySubjectiveTestListHolder.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str;
                        String str2;
                        String str3;
                        if (((Lists) list.get(position)).getIs_locked().equalsIgnoreCase("1")) {
                            if (SingleStudyAdapter4.this.isCourseSoldOut()) {
                                Toast.makeText(SingleStudyAdapter4.this.activity, R.string.sold_out_msg, 0).show();
                                return;
                            }
                            Intent intent = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) PurchaseActivity.class);
                            intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter4.this.singleStudy);
                            Helper.gotoActivity(intent, SingleStudyAdapter4.this.activity);
                            return;
                        }
                        if (SingleStudyAdapter4.this.isSkip.equalsIgnoreCase("1")) {
                            str = "title";
                            str2 = Const.TILE_TYPE;
                            str3 = Const.REVERT_API;
                        } else {
                            str3 = Const.REVERT_API;
                            if (!SingleStudyAdapter4.this.isSkip.equalsIgnoreCase("2")) {
                                if (SingleStudyAdapter4.this.isSkip.equalsIgnoreCase("3")) {
                                    return;
                                }
                                ExamPrepItem examPrepItem = new ExamPrepItem();
                                examPrepItem.setList(SingleStudyAdapter4.this.examPrepItem.getList().get(position).getList());
                                Intent intent2 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) CourseActivity.class);
                                SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(SingleStudyAdapter4.this.singleStudy != null ? SingleStudyAdapter4.this.singleStudy : new CourseDetail()));
                                SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(examPrepItem));
                                SharedPreference.getInstance().putString("list", new Gson().toJson(list.get(position) != null ? list.get(position) : new Lists()));
                                intent2.putExtra(Const.FRAG_TYPE, Const.EXAMPREP);
                                intent2.putExtra(Const.IS_COMBO, SingleStudyAdapter4.this.isCombo);
                                intent2.putExtra("content_type", SingleStudyAdapter4.this.contentType);
                                if (SingleStudyAdapter4.this.tileTypeAPI.equals(Const.COMBO) || SingleStudyAdapter4.this.tileTypeAPI.equals("content")) {
                                    intent2.putExtra(Const.TAB_TILE_VISIBILITY, "1");
                                } else {
                                    intent2.putExtra(Const.TAB_TILE_VISIBILITY, "0");
                                }
                                intent2.putExtra("title", SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail() != null ? SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getTitle() : "Course");
                                intent2.putExtra("tile_id", SingleStudyAdapter4.this.tileIdAPI);
                                intent2.putExtra(Const.TILE_TYPE, SingleStudyAdapter4.this.tileTypeAPI);
                                intent2.putExtra(str3, SingleStudyAdapter4.this.revertAPI);
                                Helper.gotoActivity(intent2, SingleStudyAdapter4.this.activity);
                                return;
                            }
                            str = "title";
                            str2 = Const.TILE_TYPE;
                        }
                        String str4 = str2;
                        Intent intent3 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) CourseActivity.class);
                        SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(SingleStudyAdapter4.this.singleStudy != null ? SingleStudyAdapter4.this.singleStudy : new CourseDetail()));
                        SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(SingleStudyAdapter4.this.examPrepItem != null ? SingleStudyAdapter4.this.examPrepItem : new ExamPrepItem()));
                        SharedPreference.getInstance().putString("list", new Gson().toJson(SingleStudyAdapter4.this.examPrepItem.getList().get(position) != null ? SingleStudyAdapter4.this.examPrepItem.getList().get(position) : new Lists()));
                        intent3.putExtra(Const.FRAG_TYPE, Const.EXAMPREPLAST);
                        intent3.putExtra(Const.IS_COMBO, SingleStudyAdapter4.this.isCombo);
                        intent3.putExtra(str, SingleStudyAdapter4.this.examPrepItem.getList().get(position).getTitle());
                        intent3.putExtra("content_type", SingleStudyAdapter4.this.contentType);
                        if (SingleStudyAdapter4.this.tileTypeAPI.equals(Const.COMBO) || SingleStudyAdapter4.this.tileTypeAPI.equals("content")) {
                            intent3.putExtra(Const.TAB_TILE_VISIBILITY, "1");
                        } else {
                            intent3.putExtra(Const.TAB_TILE_VISIBILITY, "0");
                        }
                        intent3.putExtra(Const.TEST_TYPE, SingleStudyAdapter4.this.examPrepItem.getList().get(position).getCount());
                        intent3.putExtra("tile_id", SingleStudyAdapter4.this.tileIdAPI);
                        intent3.putExtra(str4, SingleStudyAdapter4.this.tileTypeAPI);
                        intent3.putExtra(Const.LIST_SUBJECT, SingleStudyAdapter4.this.examPrepItem.getList().get(position));
                        intent3.putExtra(str3, SingleStudyAdapter4.this.revertAPI);
                        Helper.gotoActivity(intent3, SingleStudyAdapter4.this.activity);
                    }
                });
                return;
            }
            this.ibt_single_sub_vd_RL.setVisibility(8);
            this.no_data_found_RL.setVisibility(0);
            this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4.SingleStudySubjectiveTestListHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    SingleStudyAdapter4.this.activity.finish();
                }
            });
        }

        public void setSubjectiveTestOnClick(final Lists video) {
            com.appnew.android.home.Constants.SUB_TEST_ID = video.getId();
            this.paper.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4.SingleStudySubjectiveTestListHolder.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    StringBuilder sbAppend;
                    if (System.currentTimeMillis() < Long.parseLong(video.getStart_date()) * 1000) {
                        Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.test_will_start_on) + new SimpleDateFormat("dd/MM/yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                        return;
                    }
                    if (!Helper.isConnected(SingleStudyAdapter4.this.activity)) {
                        Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                        return;
                    }
                    if (video.getQuestion().equalsIgnoreCase("")) {
                        return;
                    }
                    com.appnew.android.home.Constants.SUB_TEST_ID = video.getId();
                    video.getQuestion().split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r9.length - 1].split("\\.");
                    Activity activity = SingleStudyAdapter4.this.activity;
                    String id = video.getId();
                    String question = video.getQuestion();
                    String title = video.getTitle();
                    boolean zEqualsIgnoreCase = SingleStudy.parentCourseId.equalsIgnoreCase("");
                    String id2 = MqttTopic.MULTI_LEVEL_WILDCARD;
                    if (zEqualsIgnoreCase) {
                        sbAppend = new StringBuilder().append(SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId());
                    } else {
                        sbAppend = new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD);
                        id2 = SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId();
                    }
                    Helper.GoToWebViewPDFActivity(activity, id, question, true, title, sbAppend.append(id2).toString(), video.getIs_share());
                }
            });
            this.upload.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudySubjectiveTestListHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setSubjectiveTestOnClick$0(video, view);
                }
            });
            this.booklet.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4.SingleStudySubjectiveTestListHolder.4
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (Long.parseLong(video.getResult_date()) * 1000 < System.currentTimeMillis()) {
                        if (!Helper.isConnected(SingleStudyAdapter4.this.activity)) {
                            Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                            return;
                        }
                        if (SingleStudyAdapter4.this.is_purchase.equalsIgnoreCase("1")) {
                            if (!video.getAnswers().equalsIgnoreCase("")) {
                                com.appnew.android.home.Constants.SUB_TEST_ID = video.getId();
                                Helper.GoToWebViewPDFActivity(SingleStudyAdapter4.this.activity, video.getId(), video.getAnswers(), true, video.getAnswers().split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r11.length - 1].split("\\.")[0], SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId(), video.getIs_share());
                                return;
                            }
                            Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.file_not_found), 0).show();
                            return;
                        }
                        if (video.getIs_locked().equalsIgnoreCase("1")) {
                            if (SingleStudyAdapter4.this.isCourseSoldOut()) {
                                Toast.makeText(SingleStudyAdapter4.this.activity, R.string.sold_out_msg, 0).show();
                                return;
                            }
                            Intent intent = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) PurchaseActivity.class);
                            intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter4.this.singleStudy);
                            Helper.gotoActivity(intent, SingleStudyAdapter4.this.activity);
                            return;
                        }
                        com.appnew.android.home.Constants.SUB_TEST_ID = video.getId();
                        Helper.GoToWebViewPDFActivity(SingleStudyAdapter4.this.activity, video.getId(), video.getAnswers(), true, video.getAnswers().split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r11.length - 1].split("\\.")[0], SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId(), video.getIs_share());
                        return;
                    }
                    Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.booklet_will_be_available_on) + new SimpleDateFormat("dd/MM/yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video.getResult_date()) * 1000)), 0).show();
                }
            });
            this.marks.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4.SingleStudySubjectiveTestListHolder.5
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (Long.parseLong(video.getResult_date()) * 1000 < System.currentTimeMillis()) {
                        if (!Helper.isConnected(SingleStudyAdapter4.this.activity)) {
                            Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                            return;
                        }
                        if (SingleStudyAdapter4.this.is_purchase.equalsIgnoreCase("1")) {
                            com.appnew.android.home.Constants.SUB_TEST_ID = video.getId();
                            Helper.GoToSubjectiveResultActivity(SingleStudyAdapter4.this.activity, video.getSolutions(), video.getTitle(), SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId(), video.getId(), SingleStudyAdapter4.this.contentType);
                            return;
                        } else {
                            if (video.getIs_locked().equalsIgnoreCase("1")) {
                                if (SingleStudyAdapter4.this.isCourseSoldOut()) {
                                    Toast.makeText(SingleStudyAdapter4.this.activity, R.string.sold_out_msg, 0).show();
                                    return;
                                }
                                Intent intent = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) PurchaseActivity.class);
                                intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter4.this.singleStudy);
                                Helper.gotoActivity(intent, SingleStudyAdapter4.this.activity);
                                return;
                            }
                            com.appnew.android.home.Constants.SUB_TEST_ID = video.getId();
                            Helper.GoToSubjectiveResultActivity(SingleStudyAdapter4.this.activity, video.getSolutions(), video.getTitle(), SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId(), video.getId(), SingleStudyAdapter4.this.contentType);
                            return;
                        }
                    }
                    Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.result_will_be_available_on) + new SimpleDateFormat("dd/MM/yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video.getResult_date()) * 1000)), 0).show();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setSubjectiveTestOnClick$0(Lists lists, View view) {
            if (this.upload.getText().toString().equalsIgnoreCase("View")) {
                Intent intent = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) PdfDetailScreen.class);
                intent.putExtra(Const.THUMBNAIL, lists.getThumbnail_url());
                intent.putExtra("url", lists.getAnswers_by_student());
                intent.putExtra("file_type", lists.getFile_type());
                SingleStudyAdapter4.this.activity.startActivity(intent);
                return;
            }
            if (System.currentTimeMillis() > Long.parseLong(lists.getEnd_date()) * 1000 || MakeMyExam.time_server > Long.parseLong(lists.getEnd_date()) * 1000) {
                Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.you_cant_upload_message), 0).show();
                return;
            }
            if (System.currentTimeMillis() < Long.parseLong(lists.getStart_date()) * 1000 && MakeMyExam.time_server < Long.parseLong(lists.getStart_date()) * 1000) {
                Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.test_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(lists.getStart_date()) * 1000)), 0).show();
                return;
            }
            if (!Helper.isConnected(SingleStudyAdapter4.this.activity)) {
                Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                return;
            }
            if (SingleStudyAdapter4.this.is_purchase.equalsIgnoreCase("1")) {
                if (lists.getUpload_allowed() != null && lists.getUpload_allowed().equalsIgnoreCase("1")) {
                    com.appnew.android.home.Constants.SUB_TEST_ID = lists.getId();
                    checkStoragePermission();
                    return;
                } else {
                    Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.you_cant_upload_now), 0).show();
                    return;
                }
            }
            if (lists.getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter4.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter4.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent2 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) PurchaseActivity.class);
                intent2.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter4.this.singleStudy);
                Helper.gotoActivity(intent2, SingleStudyAdapter4.this.activity);
                return;
            }
            if (lists.getUpload_allowed() != null && lists.getUpload_allowed().equalsIgnoreCase("1")) {
                com.appnew.android.home.Constants.SUB_TEST_ID = lists.getId();
                checkStoragePermission();
            } else {
                Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.you_cant_upload_now), 0).show();
            }
        }

        private void checkStoragePermission() {
            OpenChooser();
        }

        private void OpenChooser() {
            if (this.STORAGE_PERMISSION_TYPE == 3) {
                Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
                intent.setType("*/*");
                intent.setAction("android.intent.action.GET_CONTENT");
                intent.putExtra("android.provider.extra.INITIAL_URI", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath());
                SingleStudyAdapter4.this.activity.startActivity(intent);
            }
        }

        private void startTestAPI() {
            SingleStudyAdapter4 singleStudyAdapter4 = SingleStudyAdapter4.this;
            new NetworkCall(singleStudyAdapter4, singleStudyAdapter4.activity).NetworkAPICall(API.API_GET_TEST_INSTRUCTION_DATA, "", true, false);
        }

        public void result_without_submit(final String quiz_id, String course_id, String s, final String quiz_name) {
            if (Helper.isNetworkConnected(SingleStudyAdapter4.this.activity)) {
                final Progress progress = new Progress(SingleStudyAdapter4.this.activity);
                progress.show();
                APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setTest_id(quiz_id);
                encryptionData.setCourse_id(course_id);
                encryptionData.setFirst_attempt(s);
                aPIInterface.getTestlearn(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new Callback<String>() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4.SingleStudySubjectiveTestListHolder.6
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
                                Helper.showToastSecurity(SingleStudyAdapter4.this.activity);
                                return;
                            }
                            try {
                                if (resultTestSeries_Report.getStatus().equalsIgnoreCase("true")) {
                                    SharedPreference.getInstance().putString("testresult", new Gson().toJson(resultTestSeries_Report));
                                    Intent intent = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) ViewSolutionActivity.class);
                                    intent.putExtra(Const.TESTSEGMENT_ID, quiz_id);
                                    intent.putExtra(Const.FRAG_TYPE, Const.SOLUTIONREPORT);
                                    intent.putExtra("name", quiz_name);
                                    intent.putExtra("type", "learn");
                                    if (!resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("1")) {
                                        if (resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("2")) {
                                            SingleStudyAdapter4.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                                        }
                                    } else {
                                        SingleStudyAdapter4.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                                    }
                                    intent.putExtra(Const.LANG, SingleStudyAdapter4.this.lang);
                                    Helper.gotoActivity(intent, SingleStudyAdapter4.this.activity);
                                    return;
                                }
                                progress.dismiss();
                                RetrofitResponse.GetApiData(SingleStudyAdapter4.this.activity, jSONObject.optString("auth_code"), jSONObject.optString("message"), false);
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
            Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.Retry_with_Internet_connection), 1).show();
        }

        public void netoworkCallForQuizResult2(final String quiz_id, String course_id, String s, final String quiz_name) {
            if (Helper.isNetworkConnected(SingleStudyAdapter4.this.activity)) {
                final Progress progress = new Progress(SingleStudyAdapter4.this.activity);
                progress.show();
                APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setTest_id(quiz_id);
                encryptionData.setCourse_id(course_id);
                encryptionData.setFirst_attempt(s);
                aPIInterface.getTestResult(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new Callback<String>() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4.SingleStudySubjectiveTestListHolder.7
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
                                Helper.showToastSecurity(SingleStudyAdapter4.this.activity);
                                return;
                            }
                            try {
                                if (resultTestSeries_Report.getStatus().equalsIgnoreCase("true")) {
                                    if (resultTestSeries_Report.getData().getQuestions() != null && resultTestSeries_Report.getData().getQuestions().size() > 0) {
                                        SharedPreference.getInstance().putString("testresult", new Gson().toJson(resultTestSeries_Report));
                                        Intent intent = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) ViewSolutionActivity.class);
                                        intent.putExtra(Const.TESTSEGMENT_ID, quiz_id);
                                        intent.putExtra(Const.FRAG_TYPE, Const.SOLUTIONREPORT);
                                        intent.putExtra("name", quiz_name);
                                        intent.putExtra("type", "learn");
                                        if (!resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("1")) {
                                            if (resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("2")) {
                                                SingleStudyAdapter4.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                                            }
                                        } else {
                                            SingleStudyAdapter4.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                                        }
                                        intent.putExtra(Const.LANG, SingleStudyAdapter4.this.lang);
                                        Helper.gotoActivity(intent, SingleStudyAdapter4.this.activity);
                                        return;
                                    }
                                    Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.no_question_found), 0).show();
                                    return;
                                }
                                progress.dismiss();
                                RetrofitResponse.GetApiData(SingleStudyAdapter4.this.activity, jSONObject.optString("auth_code"), jSONObject.optString("message"), false);
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
            Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.Retry_with_Internet_connection), 1).show();
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
            this.comboRV.setLayoutManager(new LinearLayoutManager(SingleStudyAdapter4.this.activity));
            this.comboRV.setHasFixedSize(true);
            this.comboRV.setNestedScrollingEnabled(false);
            this.networkCall = new NetworkCall(this, SingleStudyAdapter4.this.activity);
            if (SingleStudyAdapter4.this.singleStudy != null && SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail() != null && !TextUtils.isEmpty(SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getIsPurchased())) {
                this.isPurchased = SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getIsPurchased();
            }
            hit_api_for_data(true);
            this.view_all.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyComboHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setData$0(view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$0(View view) {
            Intent intent = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) ComboListActivity.class);
            intent.putExtra("title", SingleStudyAdapter4.this.singleStudy.getData().getTiles().get(SingleStudyAdapter4.this.tilePos) != null ? SingleStudyAdapter4.this.singleStudy.getData().getTiles().get(SingleStudyAdapter4.this.tilePos).getTileName() : "Combo Course");
            intent.putExtra(Const.SINGLE_STUDY_DATA, SingleStudyAdapter4.this.singleStudy);
            Helper.gotoActivity(intent, SingleStudyAdapter4.this.activity);
        }

        private void hit_api_for_data(boolean showProgress) {
            this.networkCall.NetworkAPICall(API.get_combo_course_list, "", showProgress, false);
        }

        @Override // com.appnew.android.Courses.Adapter.ComboListAdapter.onButtonClicked
        public void onCourseClicked(int pos) {
            if (this.courseDataArrayList.get(pos).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter4.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter4.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter4.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, SingleStudyAdapter4.this.activity);
                return;
            }
            if (TextUtils.isEmpty(this.courseDataArrayList.get(pos).getMaintenanceText())) {
                Intent intent2 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) CourseActivity.class);
                intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                intent2.putExtra(Const.COURSE_ID_MAIN, this.courseDataArrayList.get(pos).getId());
                intent2.putExtra(Const.COURSE_PARENT_ID, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId());
                intent2.putExtra(Const.CONTENT_TYPE_1, this.courseDataArrayList.get(pos).getContent_type());
                intent2.putExtra(Const.IS_COMBO, true);
                intent2.putExtra("valid_to", SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getValid_to());
                intent2.putExtra(AnalyticsConstants.course_name, this.courseDataArrayList.get(pos).getTitle());
                Helper.gotoActivity(intent2, SingleStudyAdapter4.this.activity);
                return;
            }
            Helper.getCourseMaintanaceDialog(SingleStudyAdapter4.this.activity, "", this.courseDataArrayList.get(pos).getMaintenanceText());
        }

        @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
        public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
            apitype.hashCode();
            if (!apitype.equals(API.get_combo_course_list)) {
                return null;
            }
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setCourse_id(SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId());
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
                                ComboListAdapter comboListAdapter = new ComboListAdapter(SingleStudyAdapter4.this.activity, this.courseDataArrayList, this.isPurchased, this);
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
                        Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.data_not_found), 0).show();
                        return;
                    }
                    this.isPaginationAvailable = false;
                    this.no_data_found_RL.setVisibility(0);
                    this.comboRV.setVisibility(8);
                    if (!jsonstring.has("auth_code") || GenericUtils.isEmpty(jsonstring.getString("auth_code"))) {
                        return;
                    }
                    RetrofitResponse.GetApiData(SingleStudyAdapter4.this.activity, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
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

    public class SingleStudyConceptListHolder extends RecyclerView.ViewHolder {
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
        TextView titleCategory;

        public SingleStudyConceptListHolder(View itemView) {
            super(itemView);
            this.lockRL = (RelativeLayout) itemView.findViewById(R.id.lockRL);
            this.share = (ImageView) itemView.findViewById(R.id.share);
            this.liveIV = (ImageView) itemView.findViewById(R.id.liveIV);
            this.studyitemLL = (RelativeLayout) itemView.findViewById(R.id.study_single_itemLL);
            this.imageIcon = (ImageView) itemView.findViewById(R.id.profileImage);
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
            if (list != null && list.size() > 0 && SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getDisplay_locked().equalsIgnoreCase("1")) {
                this.ibt_single_sub_vd_RL.setVisibility(0);
                this.no_data_found_RL.setVisibility(8);
                this.liveIV.setVisibility(8);
                int i = position - 1;
                this.titleCategory.setText(list.get(i).getTitle());
                if (SingleStudyAdapter4.this.isSkip.equalsIgnoreCase("3")) {
                    if (list.get(i).getFile_type().equalsIgnoreCase("7")) {
                        this.read_now.setVisibility(0);
                        this.optionMenuImgView.setVisibility(8);
                        this.studyitemLL.setEnabled(true);
                        this.share.setVisibility(0);
                        this.layout_fun.setVisibility(8);
                    } else if (list.get(i).getFile_type().equalsIgnoreCase("12") || list.get(i).getFile_type().equalsIgnoreCase("11") || list.get(i).getFile_type().equalsIgnoreCase("8")) {
                        this.read_now.setVisibility(0);
                        this.optionMenuImgView.setVisibility(0);
                        this.optionMenuImgView.setImageResource(R.drawable.delete);
                        this.subItemRV.setText(SingleStudyAdapter4.this.activity.getResources().getString(R.string.revision_type));
                        this.studyitemLL.setEnabled(true);
                        this.layout_fun.setVisibility(8);
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
                        this.subItemRV.setText(SingleStudyAdapter4.this.activity.getResources().getString(R.string.total_) + list.get(i).getCount());
                    }
                    this.subItemRV.setVisibility(8);
                }
                if (!TextUtils.isEmpty(list.get(i).getImage_icon())) {
                    Helper.setThumbnailImage(SingleStudyAdapter4.this.activity, list.get(i).getImage_icon(), SingleStudyAdapter4.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.imageIcon);
                } else {
                    this.imageIcon.setImageResource(R.mipmap.square_placeholder);
                }
                if (TextUtils.isEmpty(list.get(i).getIs_locked())) {
                    list.get(i).setIs_locked("0");
                }
                if (SingleStudyAdapter4.this.singleStudy != null && SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail() != null && SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getIsPurchased().equals("1")) {
                    list.get(i).setIs_locked("0");
                }
                if (list.get(i).getIs_locked().equals("0")) {
                    this.lockRL.setVisibility(8);
                } else {
                    this.lockRL.setVisibility(0);
                }
                this.optionMenuImgView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4.SingleStudyConceptListHolder.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        if (SingleStudyAdapter4.this.is_purchase.equalsIgnoreCase("1")) {
                            if (SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("10") || SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("12") || SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("11")) {
                                SingleStudyAdapter4.this.videodata = SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1);
                                SingleStudyAdapter4.this.position_delete = position - 1;
                                return;
                            }
                            if (!VideoDownloadService.isServiceRunning) {
                                if (SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getVideo_type().equalsIgnoreCase("6")) {
                                    return;
                                }
                                Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.only_jw_video_download), 0).show();
                                return;
                            }
                            Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.please_wait_downloading_is_in_progress), 0).show();
                            return;
                        }
                        if (SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getIs_locked().equalsIgnoreCase("1")) {
                            if (SingleStudyAdapter4.this.isCourseSoldOut()) {
                                Toast.makeText(SingleStudyAdapter4.this.activity, R.string.sold_out_msg, 0).show();
                                return;
                            }
                            Intent intent = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) PurchaseActivity.class);
                            intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter4.this.singleStudy);
                            intent.putExtra(Const.IS_BOOK, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getCat_type());
                            intent.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                            Helper.gotoActivity(intent, SingleStudyAdapter4.this.activity);
                            return;
                        }
                        if (SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("10") || SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("12") || SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("11")) {
                            SingleStudyAdapter4.this.videodata = SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1);
                            SingleStudyAdapter4.this.position_delete = position - 1;
                            return;
                        }
                        if (!VideoDownloadService.isServiceRunning) {
                            if (SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getVideo_type().equalsIgnoreCase("6")) {
                                return;
                            }
                            Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.only_jw_video_download), 0).show();
                            return;
                        }
                        Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.please_wait_downloading_is_in_progress), 0).show();
                    }
                });
                this.read_now.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4.SingleStudyConceptListHolder.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        if (((Lists) list.get(position - 1)).getIs_locked().equalsIgnoreCase("1")) {
                            if (SingleStudyAdapter4.this.isCourseSoldOut()) {
                                Toast.makeText(SingleStudyAdapter4.this.activity, R.string.sold_out_msg, 0).show();
                                return;
                            }
                            Intent intent = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) PurchaseActivity.class);
                            intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter4.this.singleStudy);
                            intent.putExtra(Const.IS_BOOK, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getCat_type());
                            intent.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                            Helper.gotoActivity(intent, SingleStudyAdapter4.this.activity);
                            return;
                        }
                        if (SingleStudyAdapter4.this.isSkip.equalsIgnoreCase("3")) {
                            if (SingleStudyAdapter4.this.is_purchase.equalsIgnoreCase("1")) {
                                if (SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("12")) {
                                    if (SingleStudyAdapter4.this.examPrepItem.getList().size() > 0) {
                                        Intent intent2 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) RevisionActivity.class);
                                        intent2.putExtra("t_id", SingleStudyAdapter4.this.tileIdAPI);
                                        intent2.putExtra("postion", position);
                                        intent2.putExtra(Const.VIDEO_ID, SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getId());
                                        intent2.putExtra("v_list", ExamPrepLayer2.actual_videolist);
                                        intent2.putExtra("f_id", SingleStudyAdapter4.this.examPrepItem.getList().get(0).getId());
                                        intent2.putExtra("c_id", SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId());
                                        intent2.putExtra("title", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getTitle());
                                        intent2.putExtra("url", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_url());
                                        intent2.putExtra(Const.VIA, "main");
                                        Helper.gotoActivity(intent2, SingleStudyAdapter4.this.activity);
                                        return;
                                    }
                                    return;
                                }
                                if (SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("11")) {
                                    Intent intent3 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) WebViewActivty.class);
                                    intent3.putExtra("type", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getTitle());
                                    intent3.putExtra("url", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_url());
                                    Helper.gotoActivity(intent3, SingleStudyAdapter4.this.activity);
                                    return;
                                }
                                if (SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("8")) {
                                    Intent intent4 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) WebViewActivty.class);
                                    intent4.putExtra("type", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getTitle());
                                    intent4.putExtra("url", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_url());
                                    intent4.putExtra("course_id", (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId())).toString());
                                    intent4.putExtra(Const.VIDEO_ID, SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getId());
                                    intent4.putExtra("link", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type());
                                    Helper.gotoActivity(intent4, SingleStudyAdapter4.this.activity);
                                    return;
                                }
                                if (SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("6")) {
                                    if (TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getId())) {
                                        Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.no_image_found), 0).show();
                                        return;
                                    }
                                    Intent intent5 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) WebViewActivty.class);
                                    intent5.putExtra("type", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getTitle());
                                    intent5.putExtra("url", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_url());
                                    intent5.putExtra("file_type", "image");
                                    Helper.gotoActivity(intent5, SingleStudyAdapter4.this.activity);
                                    return;
                                }
                                Intent intent6 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) Concept_newActivity.class);
                                intent6.putExtra("id", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getId());
                                intent6.putExtra("name", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getTitle());
                                intent6.putExtra("course_id", (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId())).toString());
                                intent6.putExtra("tile_id", SingleStudyAdapter4.this.tileIdAPI);
                                Helper.gotoActivity(intent6, SingleStudyAdapter4.this.activity);
                                return;
                            }
                            if (SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getIs_locked().equalsIgnoreCase("1")) {
                                if (SingleStudyAdapter4.this.isCourseSoldOut()) {
                                    Toast.makeText(SingleStudyAdapter4.this.activity, R.string.sold_out_msg, 0).show();
                                    return;
                                }
                                Intent intent7 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) PurchaseActivity.class);
                                intent7.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter4.this.singleStudy);
                                intent7.putExtra(Const.IS_BOOK, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getCat_type());
                                intent7.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                                Helper.gotoActivity(intent7, SingleStudyAdapter4.this.activity);
                                return;
                            }
                            if (SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("12")) {
                                if (SingleStudyAdapter4.this.examPrepItem.getList().size() > 0) {
                                    Intent intent8 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) RevisionActivity.class);
                                    intent8.putExtra("t_id", SingleStudyAdapter4.this.tileIdAPI);
                                    intent8.putExtra("postion", position);
                                    intent8.putExtra(Const.VIDEO_ID, SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getId());
                                    intent8.putExtra("v_list", ExamPrepLayer2.actual_videolist);
                                    intent8.putExtra("f_id", SingleStudyAdapter4.this.examPrepItem.getList().get(0).getId());
                                    intent8.putExtra("c_id", SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId());
                                    intent8.putExtra("title", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getTitle());
                                    intent8.putExtra("url", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_url());
                                    intent8.putExtra(Const.VIA, "main");
                                    Helper.gotoActivity(intent8, SingleStudyAdapter4.this.activity);
                                    return;
                                }
                                return;
                            }
                            if (SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("11")) {
                                Intent intent9 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) WebViewActivty.class);
                                intent9.putExtra("type", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getTitle());
                                intent9.putExtra("url", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_url());
                                Helper.gotoActivity(intent9, SingleStudyAdapter4.this.activity);
                                return;
                            }
                            if (SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("8")) {
                                Intent intent10 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) WebViewActivty.class);
                                intent10.putExtra("type", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getTitle());
                                intent10.putExtra("url", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_url());
                                intent10.putExtra("course_id", (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId())).toString());
                                intent10.putExtra(Const.VIDEO_ID, SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getId());
                                intent10.putExtra("link", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type());
                                Helper.gotoActivity(intent10, SingleStudyAdapter4.this.activity);
                                return;
                            }
                            if (SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("6")) {
                                if (TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getId())) {
                                    Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.no_image_found), 0).show();
                                    return;
                                }
                                Intent intent11 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) WebViewActivty.class);
                                intent11.putExtra("type", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getTitle());
                                intent11.putExtra("url", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_url());
                                intent11.putExtra("file_type", "image");
                                Helper.gotoActivity(intent11, SingleStudyAdapter4.this.activity);
                                return;
                            }
                            Intent intent12 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) Concept_newActivity.class);
                            intent12.putExtra("id", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getId());
                            intent12.putExtra("name", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getTitle());
                            intent12.putExtra("course_id", (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId())).toString());
                            intent12.putExtra("tile_id", SingleStudyAdapter4.this.tileIdAPI);
                            Helper.gotoActivity(intent12, SingleStudyAdapter4.this.activity);
                        }
                    }
                });
                this.studyitemLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyConceptListHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$0(list, position, view);
                    }
                });
                this.share.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyConceptListHolder$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$setData$1(position);
                    }
                }));
                if (list.get(i).getIs_locked().equals("0")) {
                    if (Helper.isShowShareButton(SingleStudyAdapter4.this.leftMenu)) {
                        this.share.setVisibility(0);
                        return;
                    } else {
                        this.share.setVisibility(8);
                        return;
                    }
                }
                this.share.setVisibility(8);
                this.read_now.setVisibility(8);
                this.studyitemLL.setEnabled(false);
                return;
            }
            this.ibt_single_sub_vd_RL.setVisibility(8);
            this.no_data_found_RL.setVisibility(0);
            this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyConceptListHolder$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setData$2(view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$0(ArrayList arrayList, int i, View view) {
            int i2 = i - 1;
            if (((Lists) arrayList.get(i2)).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter4.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter4.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter4.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, SingleStudyAdapter4.this.activity);
                return;
            }
            if (SingleStudyAdapter4.this.isSkip.equalsIgnoreCase("1") || SingleStudyAdapter4.this.isSkip.equalsIgnoreCase("2")) {
                String str = Const.TILE_TYPE;
                String str2 = "title";
                Intent intent2 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) CourseActivity.class);
                SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(SingleStudyAdapter4.this.singleStudy != null ? SingleStudyAdapter4.this.singleStudy : new CourseDetail()));
                SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(SingleStudyAdapter4.this.examPrepItem != null ? SingleStudyAdapter4.this.examPrepItem : new ExamPrepItem()));
                SharedPreference.getInstance().putString("list", new Gson().toJson(SingleStudyAdapter4.this.examPrepItem.getList().get(i2) != null ? SingleStudyAdapter4.this.examPrepItem.getList().get(i2) : new Lists()));
                intent2.putExtra(Const.FRAG_TYPE, Const.EXAMPREPLAST);
                intent2.putExtra(Const.LIST_SUBJECT, SingleStudyAdapter4.this.examPrepItem.getList().get(i2));
                intent2.putExtra(Const.IS_COMBO, SingleStudyAdapter4.this.isCombo);
                intent2.putExtra(str2, SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getTitle());
                intent2.putExtra("content_type", SingleStudyAdapter4.this.contentType);
                intent2.putExtra(Const.TEST_TYPE, SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getCount());
                intent2.putExtra("tile_id", SingleStudyAdapter4.this.tileIdAPI);
                intent2.putExtra(str, SingleStudyAdapter4.this.tileTypeAPI);
                intent2.putExtra(Const.REVERT_API, SingleStudyAdapter4.this.revertAPI);
                Helper.gotoActivity(intent2, SingleStudyAdapter4.this.activity);
                return;
            }
            if (SingleStudyAdapter4.this.isSkip.equalsIgnoreCase("3")) {
                if (SingleStudyAdapter4.this.is_purchase.equalsIgnoreCase("1")) {
                    Intent intent3 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) Concept_newActivity.class);
                    intent3.putExtra("id", SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId());
                    intent3.putExtra("name", SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getTitle());
                    intent3.putExtra("course_id", (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId())).toString());
                    intent3.putExtra("tile_id", SingleStudyAdapter4.this.tileIdAPI);
                    Helper.gotoActivity(intent3, SingleStudyAdapter4.this.activity);
                    return;
                }
                if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getIs_locked().equalsIgnoreCase("1")) {
                    if (SingleStudyAdapter4.this.isCourseSoldOut()) {
                        Toast.makeText(SingleStudyAdapter4.this.activity, R.string.sold_out_msg, 0).show();
                        return;
                    }
                    Intent intent4 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) PurchaseActivity.class);
                    intent4.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter4.this.singleStudy);
                    intent4.putExtra(Const.IS_BOOK, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getCat_type());
                    intent4.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                    Helper.gotoActivity(intent4, SingleStudyAdapter4.this.activity);
                    return;
                }
                Intent intent5 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) Concept_newActivity.class);
                intent5.putExtra("id", SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId());
                intent5.putExtra("name", SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getTitle());
                intent5.putExtra("course_id", (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId())).toString());
                intent5.putExtra("tile_id", SingleStudyAdapter4.this.tileIdAPI);
                Helper.gotoActivity(intent5, SingleStudyAdapter4.this.activity);
                return;
            }
            ExamPrepItem examPrepItem = new ExamPrepItem();
            examPrepItem.setList(SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getList());
            Intent intent6 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) CourseActivity.class);
            SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(SingleStudyAdapter4.this.singleStudy != null ? SingleStudyAdapter4.this.singleStudy : new CourseDetail()));
            SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(examPrepItem));
            SharedPreference.getInstance().putString("list", new Gson().toJson(arrayList.get(i2) != null ? arrayList.get(i2) : new Lists()));
            intent6.putExtra(Const.FRAG_TYPE, Const.EXAMPREP);
            intent6.putExtra(Const.IS_COMBO, SingleStudyAdapter4.this.isCombo);
            intent6.putExtra("content_type", SingleStudyAdapter4.this.contentType);
            intent6.putExtra("title", SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail() != null ? SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getTitle() : "Course");
            intent6.putExtra("tile_id", SingleStudyAdapter4.this.tileIdAPI);
            intent6.putExtra(Const.TILE_TYPE, SingleStudyAdapter4.this.tileTypeAPI);
            intent6.putExtra(Const.REVERT_API, SingleStudyAdapter4.this.revertAPI);
            Helper.gotoActivity(intent6, SingleStudyAdapter4.this.activity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$setData$1(int i) {
            int i2 = i - 1;
            Helper.sharePdf(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getTopic_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getRevert_api(), Const.PDF, SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getThumbnail_url(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getTitle(), SingleStudy.parentCourseId);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$2(View view) {
            SingleStudyAdapter4.this.activity.finish();
        }
    }

    public class SingleStudyPdfListHolder extends RecyclerView.ViewHolder {
        Button backBtn;
        ImageView forwardIV;
        CardView ibt_single_sub_vd_RL;
        ImageView imageIcon;
        ImageView liveIV;
        RelativeLayout lockRL;
        RelativeLayout no_data_found_RL;
        TextView read_now;
        ImageView share;
        RelativeLayout studyitemLL;
        TextView titleCategory;

        public SingleStudyPdfListHolder(View itemView) {
            super(itemView);
            this.lockRL = (RelativeLayout) itemView.findViewById(R.id.lockRL);
            this.read_now = (TextView) itemView.findViewById(R.id.read_now);
            this.share = (ImageView) itemView.findViewById(R.id.share);
            this.liveIV = (ImageView) itemView.findViewById(R.id.liveIV);
            this.studyitemLL = (RelativeLayout) itemView.findViewById(R.id.study_single_itemLL);
            this.imageIcon = (ImageView) itemView.findViewById(R.id.imageIV);
            this.forwardIV = (ImageView) itemView.findViewById(R.id.forwardIV);
            this.titleCategory = (TextView) itemView.findViewById(R.id.examPrepTitleTV);
            this.no_data_found_RL = (RelativeLayout) itemView.findViewById(R.id.no_data_found_RL);
            this.backBtn = (Button) itemView.findViewById(R.id.backBtn);
            this.ibt_single_sub_vd_RL = (CardView) itemView.findViewById(R.id.ibt_single_sub_vd_RL);
        }

        public void setData(final ArrayList<Lists> list, final int position) {
            if (list != null && list.size() > 0 && SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getDisplay_locked().equalsIgnoreCase("1")) {
                this.ibt_single_sub_vd_RL.setVisibility(0);
                this.no_data_found_RL.setVisibility(8);
                this.liveIV.setVisibility(8);
                int i = position - 1;
                this.titleCategory.setText(list.get(i).getTitle());
                if (TextUtils.isEmpty(list.get(i).getIs_locked())) {
                    list.get(i).setIs_locked("0");
                }
                if (SingleStudyAdapter4.this.singleStudy != null && SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail() != null && SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getIsPurchased().equals("1")) {
                    list.get(i).setIs_locked("0");
                }
                if (list.get(i).getIs_locked().equals("0")) {
                    this.lockRL.setVisibility(8);
                } else {
                    this.lockRL.setVisibility(0);
                }
                if (SingleStudyAdapter4.this.isSkip.equalsIgnoreCase("3")) {
                    this.forwardIV.setVisibility(8);
                    if (!TextUtils.isEmpty(list.get(i).getThumbnail_url())) {
                        Helper.setThumbnailImage(SingleStudyAdapter4.this.activity, list.get(i).getThumbnail_url(), SingleStudyAdapter4.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.imageIcon);
                    } else {
                        this.imageIcon.setImageResource(R.mipmap.square_placeholder);
                    }
                    this.read_now.setEnabled(true);
                    this.studyitemLL.setEnabled(false);
                    if (list.get(i).getIs_locked().equals("0")) {
                        this.read_now.setVisibility(0);
                        if (Helper.isShowShareButton(SingleStudyAdapter4.this.leftMenu)) {
                            this.share.setVisibility(0);
                        } else {
                            this.share.setVisibility(8);
                        }
                    } else {
                        this.read_now.setVisibility(8);
                        this.share.setVisibility(8);
                    }
                } else {
                    if (!TextUtils.isEmpty(list.get(i).getImage_icon())) {
                        Helper.setThumbnailImage(SingleStudyAdapter4.this.activity, list.get(i).getImage_icon(), SingleStudyAdapter4.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.imageIcon);
                    } else {
                        this.imageIcon.setImageResource(R.mipmap.square_placeholder);
                    }
                    this.share.setVisibility(8);
                    this.studyitemLL.setEnabled(true);
                    this.read_now.setVisibility(8);
                    if (list.get(i).getIs_locked().equalsIgnoreCase("0")) {
                        this.forwardIV.setVisibility(0);
                    }
                }
                this.share.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyPdfListHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$0(position, view);
                    }
                });
                this.read_now.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4.SingleStudyPdfListHolder.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        if (((Lists) list.get(position - 1)).getIs_locked().equalsIgnoreCase("1")) {
                            if (SingleStudyAdapter4.this.isCourseSoldOut()) {
                                Toast.makeText(SingleStudyAdapter4.this.activity, R.string.sold_out_msg, 0).show();
                                return;
                            }
                            Intent intent = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) PurchaseActivity.class);
                            intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter4.this.singleStudy);
                            intent.putExtra(Const.IS_BOOK, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getCat_type());
                            intent.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                            Helper.gotoActivity(intent, SingleStudyAdapter4.this.activity);
                            return;
                        }
                        if (SingleStudyAdapter4.this.is_purchase.equalsIgnoreCase("1")) {
                            if (!SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("7") && (TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_url()) || TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getId()))) {
                                Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.no_pdf_found), 0).show();
                                return;
                            }
                            if (SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("8")) {
                                Intent intent2 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) WebViewActivty.class);
                                intent2.putExtra("type", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getTitle());
                                intent2.putExtra("url", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_url());
                                intent2.putExtra("course_id", (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId())).toString());
                                intent2.putExtra(Const.VIDEO_ID, SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getId());
                                intent2.putExtra("link", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type());
                                Helper.gotoActivity(intent2, SingleStudyAdapter4.this.activity);
                                return;
                            }
                            if (SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("1")) {
                                Helper.GoToWebViewPDFActivity(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getId(), SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_url(), !TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(position + (-1)).getIs_download_available()) && SingleStudyAdapter4.this.examPrepItem.getList().get(position + (-1)).getIs_download_available().equalsIgnoreCase("1"), SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getTitle(), (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId())).toString(), SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getIs_share());
                                return;
                            }
                            return;
                        }
                        if (SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getIs_locked().equalsIgnoreCase("1")) {
                            if (SingleStudyAdapter4.this.isCourseSoldOut()) {
                                Toast.makeText(SingleStudyAdapter4.this.activity, R.string.sold_out_msg, 0).show();
                                return;
                            }
                            Intent intent3 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) PurchaseActivity.class);
                            intent3.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter4.this.singleStudy);
                            intent3.putExtra(Const.IS_BOOK, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getCat_type());
                            intent3.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                            Helper.gotoActivity(intent3, SingleStudyAdapter4.this.activity);
                            return;
                        }
                        if (!SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("7") && (TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_url()) || TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getId()))) {
                            Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.no_pdf_found), 0).show();
                            return;
                        }
                        if (SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("8")) {
                            Intent intent4 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) WebViewActivty.class);
                            intent4.putExtra("type", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getTitle());
                            intent4.putExtra("url", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_url());
                            intent4.putExtra("course_id", (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId())).toString());
                            intent4.putExtra(Const.VIDEO_ID, SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getId());
                            intent4.putExtra("link", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type());
                            Helper.gotoActivity(intent4, SingleStudyAdapter4.this.activity);
                            return;
                        }
                        if (SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("1")) {
                            Helper.GoToWebViewPDFActivity(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getId(), SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_url(), !TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(position + (-1)).getIs_download_available()) && SingleStudyAdapter4.this.examPrepItem.getList().get(position + (-1)).getIs_download_available().equalsIgnoreCase("1"), SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getTitle(), (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId())).toString(), SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getIs_share());
                        }
                    }
                });
                this.studyitemLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4.SingleStudyPdfListHolder.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (((Lists) list.get(position - 1)).getIs_locked().equalsIgnoreCase("1")) {
                            if (SingleStudyAdapter4.this.isCourseSoldOut()) {
                                Toast.makeText(SingleStudyAdapter4.this.activity, R.string.sold_out_msg, 0).show();
                                return;
                            }
                            Intent intent = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) PurchaseActivity.class);
                            intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter4.this.singleStudy);
                            intent.putExtra(Const.IS_BOOK, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getCat_type());
                            intent.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                            Helper.gotoActivity(intent, SingleStudyAdapter4.this.activity);
                            return;
                        }
                        if (SingleStudyAdapter4.this.isSkip.equalsIgnoreCase("1") || SingleStudyAdapter4.this.isSkip.equalsIgnoreCase("2")) {
                            Intent intent2 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) CourseActivity.class);
                            SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(SingleStudyAdapter4.this.singleStudy != null ? SingleStudyAdapter4.this.singleStudy : new CourseDetail()));
                            SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(SingleStudyAdapter4.this.examPrepItem != null ? SingleStudyAdapter4.this.examPrepItem : new ExamPrepItem()));
                            SharedPreference.getInstance().putString("list", new Gson().toJson(SingleStudyAdapter4.this.examPrepItem.getList().get(position + (-1)) != null ? SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1) : new Lists()));
                            intent2.putExtra(Const.FRAG_TYPE, Const.EXAMPREPLAST);
                            intent2.putExtra(Const.LIST_SUBJECT, SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1));
                            intent2.putExtra(Const.IS_COMBO, SingleStudyAdapter4.this.isCombo);
                            intent2.putExtra("title", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getTitle());
                            intent2.putExtra("content_type", SingleStudyAdapter4.this.contentType);
                            intent2.putExtra(Const.TEST_TYPE, SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getCount());
                            intent2.putExtra("tile_id", SingleStudyAdapter4.this.tileIdAPI);
                            intent2.putExtra(Const.TILE_TYPE, SingleStudyAdapter4.this.tileTypeAPI);
                            intent2.putExtra(Const.REVERT_API, SingleStudyAdapter4.this.revertAPI);
                            Helper.gotoActivity(intent2, SingleStudyAdapter4.this.activity);
                            return;
                        }
                        if (SingleStudyAdapter4.this.isSkip.equalsIgnoreCase("3")) {
                            if (SingleStudyAdapter4.this.is_purchase.equalsIgnoreCase("1")) {
                                if (!SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("7") && TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getId())) {
                                    Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.no_pdf_found), 0).show();
                                    return;
                                }
                                if (SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("8")) {
                                    Intent intent3 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) WebViewActivty.class);
                                    intent3.putExtra("type", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getTitle());
                                    intent3.putExtra("url", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_url());
                                    intent3.putExtra("course_id", (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId())).toString());
                                    intent3.putExtra(Const.VIDEO_ID, SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getId());
                                    intent3.putExtra("link", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type());
                                    Helper.gotoActivity(intent3, SingleStudyAdapter4.this.activity);
                                }
                                if (SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("7")) {
                                    Intent intent4 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) WebViewActivty.class);
                                    intent4.putExtra("type", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getTitle());
                                    intent4.putExtra("url", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getDescription());
                                    Helper.gotoActivity(intent4, SingleStudyAdapter4.this.activity);
                                    return;
                                }
                                if (SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("1")) {
                                    Helper.GoToWebViewPDFActivity(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getId(), SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_url(), !TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(position + (-1)).getIs_download_available()) && SingleStudyAdapter4.this.examPrepItem.getList().get(position + (-1)).getIs_download_available().equalsIgnoreCase("1"), SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getTitle(), (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId())).toString(), SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getIs_share());
                                    return;
                                }
                                return;
                            }
                            if (SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getIs_locked().equalsIgnoreCase("1")) {
                                if (SingleStudyAdapter4.this.isCourseSoldOut()) {
                                    Toast.makeText(SingleStudyAdapter4.this.activity, R.string.sold_out_msg, 0).show();
                                    return;
                                }
                                Intent intent5 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) PurchaseActivity.class);
                                intent5.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter4.this.singleStudy);
                                intent5.putExtra(Const.IS_BOOK, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getCat_type());
                                intent5.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                                Helper.gotoActivity(intent5, SingleStudyAdapter4.this.activity);
                                return;
                            }
                            if (!SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("7") && TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getId())) {
                                Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.no_pdf_found), 0).show();
                                return;
                            }
                            if (SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("8")) {
                                Intent intent6 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) WebViewActivty.class);
                                intent6.putExtra("type", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getTitle());
                                intent6.putExtra("url", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_url());
                                intent6.putExtra("course_id", (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId())).toString());
                                intent6.putExtra(Const.VIDEO_ID, SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getId());
                                intent6.putExtra("link", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type());
                                Helper.gotoActivity(intent6, SingleStudyAdapter4.this.activity);
                            }
                            if (SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("7")) {
                                Intent intent7 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) WebViewActivty.class);
                                intent7.putExtra("type", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getTitle());
                                intent7.putExtra("url", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getDescription());
                                Helper.gotoActivity(intent7, SingleStudyAdapter4.this.activity);
                                return;
                            }
                            if (SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("1")) {
                                Helper.GoToWebViewPDFActivity(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getId(), SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_url(), !TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(position + (-1)).getIs_download_available()) && SingleStudyAdapter4.this.examPrepItem.getList().get(position + (-1)).getIs_download_available().equalsIgnoreCase("1"), SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getTitle(), (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId())).toString(), SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getIs_share());
                                return;
                            }
                            return;
                        }
                        ExamPrepItem examPrepItem = new ExamPrepItem();
                        examPrepItem.setList(SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getList());
                        Intent intent8 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) CourseActivity.class);
                        SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(SingleStudyAdapter4.this.singleStudy != null ? SingleStudyAdapter4.this.singleStudy : new CourseDetail()));
                        SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(examPrepItem));
                        SharedPreference.getInstance().putString("list", new Gson().toJson(list.get(position + (-1)) != null ? list.get(position - 1) : new Lists()));
                        intent8.putExtra(Const.FRAG_TYPE, Const.EXAMPREP);
                        intent8.putExtra(Const.IS_COMBO, SingleStudyAdapter4.this.isCombo);
                        intent8.putExtra("content_type", SingleStudyAdapter4.this.contentType);
                        intent8.putExtra("title", SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail() != null ? SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getTitle() : "Course");
                        intent8.putExtra("tile_id", SingleStudyAdapter4.this.tileIdAPI);
                        intent8.putExtra(Const.TILE_TYPE, SingleStudyAdapter4.this.tileTypeAPI);
                        intent8.putExtra(Const.REVERT_API, SingleStudyAdapter4.this.revertAPI);
                        Helper.gotoActivity(intent8, SingleStudyAdapter4.this.activity);
                    }
                });
                return;
            }
            this.ibt_single_sub_vd_RL.setVisibility(8);
            this.no_data_found_RL.setVisibility(0);
            this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4.SingleStudyPdfListHolder.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    SingleStudyAdapter4.this.activity.finish();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$0(int i, View view) {
            if (SingleStudyAdapter4.this.is_purchase.equalsIgnoreCase("1")) {
                int i2 = i - 1;
                if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("8") || SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("7") || SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("1")) {
                    Helper.sharePdf(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getTopic_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getRevert_api(), Const.PDF, SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getThumbnail_url(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getTitle(), SingleStudy.parentCourseId);
                    return;
                }
                return;
            }
            int i3 = i - 1;
            if (SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter4.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter4.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter4.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, SingleStudyAdapter4.this.activity);
                return;
            }
            if (SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getFile_type().equalsIgnoreCase("8") || SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getFile_type().equalsIgnoreCase("7") || SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getFile_type().equalsIgnoreCase("1")) {
                Helper.sharePdf(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getPayload().getCourse_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getId(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getPayload().getTopic_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getPayload().getTile_type(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getPayload().getTile_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getPayload().getRevert_api(), Const.PDF, SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getThumbnail_url(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getTitle(), SingleStudy.parentCourseId);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        }
        if (this.contentType.equalsIgnoreCase(Const.TEST + this.tileIdAPI)) {
            return 4;
        }
        if (this.contentType.equalsIgnoreCase(Const.BOOK + this.tileIdAPI)) {
            return 2;
        }
        if (this.contentType.equalsIgnoreCase(Const.OVERVIEW + this.tileIdAPI)) {
            return 3;
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
        return (this.contentType.equalsIgnoreCase(new StringBuilder(Const.SUBJECTIVE_TEST).append(this.tileIdAPI).toString()) || this.contentType.equalsIgnoreCase(new StringBuilder(Const.Daily_assignment).append(this.tileIdAPI).toString())) ? 10 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.contentType.equalsIgnoreCase(Const.BOOK + this.tileIdAPI) || this.contentType.equalsIgnoreCase(Const.OVERVIEW + this.tileIdAPI) || this.contentType.equalsIgnoreCase(Const.COMBO + this.tileIdAPI) || this.contentType.equalsIgnoreCase(Const.FAQ + this.tileIdAPI) || this.examPrepItem.getList() == null || this.examPrepItem.getList().size() <= 0) {
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
            case "https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction":
                EncryptionData encryptionData3 = new EncryptionData();
                encryptionData3.setCourse_id(this.singleStudy.getData().getCourseDetail().getId());
                encryptionData3.setCoupon_applied("0");
                encryptionData3.setParent_id(this.parentCourseId);
                return service.free_transaction(AES.encrypt(new Gson().toJson(encryptionData3)));
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
    /* JADX WARN: Removed duplicated region for block: B:98:0x02bc A[Catch: Exception -> 0x02e3, TryCatch #0 {Exception -> 0x02e3, blocks: (B:27:0x0067, B:29:0x00a2, B:31:0x00a5, B:33:0x00a9, B:35:0x00b3, B:46:0x00f3, B:48:0x00f8, B:50:0x0102, B:55:0x0114, B:57:0x011e, B:64:0x0134, B:66:0x0140, B:69:0x0164, B:71:0x0172, B:73:0x017b, B:75:0x017f, B:77:0x0196, B:79:0x01a7, B:81:0x01b8, B:99:0x02d1, B:80:0x01b6, B:76:0x018b, B:83:0x0206, B:85:0x0210, B:87:0x021e, B:89:0x0227, B:91:0x023a, B:93:0x0251, B:95:0x0262, B:97:0x0273, B:96:0x0271, B:92:0x0246, B:98:0x02bc, B:37:0x00c1, B:40:0x00cf, B:42:0x00d9, B:44:0x00e7, B:100:0x02d6), top: B:150:0x0067 }] */
    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void SuccessCallBack(org.json.JSONObject r20, java.lang.String r21, java.lang.String r22, boolean r23) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 1188
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Courses.Adapter.SingleStudyAdapter4.SuccessCallBack(org.json.JSONObject, java.lang.String, java.lang.String, boolean):void");
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
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.numQuesValueTV);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.sectionValueTV);
        final TextView textView5 = (TextView) viewInflate.findViewById(R.id.languageSpinnerTV);
        TextView textView6 = (TextView) viewInflate.findViewById(R.id.quizTimeValueTV);
        TextView textView7 = (TextView) viewInflate.findViewById(R.id.remarksTV);
        CheckBox checkBox2 = (CheckBox) viewInflate.findViewById(R.id.check_box);
        final TextView textView8 = (TextView) viewInflate.findViewById(R.id.generalInstrValueTV);
        Button button = (Button) viewInflate.findViewById(R.id.startQuizBtn);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.sectionListLL);
        LinearLayout linearLayout2 = (LinearLayout) viewInflate.findViewById(R.id.section_time);
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
                linearLayout2.setVisibility(0);
            } else {
                linearLayout2.setVisibility(4);
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
        if (testBasic.getLang_id().length() > 1) {
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SingleStudyAdapter4 singleStudyAdapter4 = SingleStudyAdapter4.this;
                    TextView textView9 = textView5;
                    TestBasicInst testBasicInst = testBasic;
                    TextView textView10 = textView8;
                    singleStudyAdapter4.showPopMenuForLangauge(textView9, testBasicInst, textView10, textView10);
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
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (testBasic.getTotalQuestions().equalsIgnoreCase("0")) {
                    Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.please_add_question), 0).show();
                    return;
                }
                if (checkBox3.isChecked()) {
                    dialog3.dismiss();
                    SingleStudyAdapter4.this.quiz_id = testBasic.getId();
                    SingleStudyAdapter4 singleStudyAdapter4 = SingleStudyAdapter4.this;
                    new NetworkCall(singleStudyAdapter4, singleStudyAdapter4.activity).NetworkAPICall(API.API_GET_INFO_TEST_SERIES, "", true, false);
                    return;
                }
                Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.please_check_following_instructions), 0).show();
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
            float floatSafe = Helper.parseFloatSafe(testSectionInst.getSectionTiming());
            if (map.containsKey(sectionId)) {
                map.merge(sectionId, Float.valueOf(floatSafe), new BiFunction() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$$ExternalSyntheticLambda1
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

    public void showPopMenuForLangauge(final View v, final TestBasicInst testBasicInst, final TextView v1, TextView vvv) {
        PopupMenu popupMenu = new PopupMenu(this.activity, v);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4.3
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem item) {
                ((TextView) v).setText(item.getTitle().toString());
                if (item.getTitle().toString().equals(SingleStudyAdapter4.this.activity.getResources().getString(R.string.hindi))) {
                    SingleStudyAdapter4.this.lang = 2;
                    if (testBasicInst.getMulti_description().size() > 0 && testBasicInst.getMulti_description().get(1).getDescription() != null) {
                        v1.setText(Html.fromHtml(testBasicInst.getMulti_description().get(1).getDescription()));
                    }
                } else if (item.getTitle().toString().equals(SingleStudyAdapter4.this.activity.getResources().getString(R.string.english))) {
                    SingleStudyAdapter4.this.lang = 1;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        v1.setText(Html.fromHtml(testBasicInst.getMulti_description().get(0).getDescription()));
                    }
                }
                return false;
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

    public class SingleStudyListHolder extends RecyclerView.ViewHolder {
        LinearLayout LogsLL;
        LinearLayout actalll;
        TextView actualduration;
        Button backBtn;
        LinearLayout classdurationll;
        long downloadId;
        ProgressBar downloadprogessPB;
        TextView duration;
        ImageView forwardIV;
        CardView ibt_single_sub_vd_RL;
        ImageView imageIcon;
        boolean isdownloaded;
        RelativeLayout layout_fun;
        TextView listen_now;
        ImageView liveIV;
        RelativeLayout lockRL;
        TextView messageTV;
        RelativeLayout no_data_found_RL;
        ImageView optionMenuImgView;
        RelativeLayout parentLL;
        LinearLayout progressLL;
        TextView read_now;
        TextView remaining_time;
        LinearLayout remainingtimell;
        ImageView share;
        RelativeLayout studyitemLL;
        TextView subItemRV;
        TextView titleCategory;
        TextView total_view_time;
        LinearLayout totalviewtimell;
        private String videoDownloadUrl;
        VideosDownload videosDownload;
        View view1;
        TextView watch_now;

        public void checkDownloadedData(Lists video) {
        }

        public SingleStudyListHolder(View itemView) {
            super(itemView);
            this.videoDownloadUrl = "";
            this.isdownloaded = false;
            this.lockRL = (RelativeLayout) itemView.findViewById(R.id.lockRL);
            this.forwardIV = (ImageView) itemView.findViewById(R.id.forwardIV);
            this.liveIV = (ImageView) itemView.findViewById(R.id.liveIV);
            this.parentLL = (RelativeLayout) itemView.findViewById(R.id.parentLL);
            this.listen_now = (TextView) itemView.findViewById(R.id.listne_now);
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
            this.LogsLL = (LinearLayout) itemView.findViewById(R.id.LogsLL);
            this.duration = (TextView) itemView.findViewById(R.id.duration);
            this.total_view_time = (TextView) itemView.findViewById(R.id.total_view_time);
            this.remaining_time = (TextView) itemView.findViewById(R.id.remaining_time);
            this.progressLL = (LinearLayout) itemView.findViewById(R.id.progressLL);
            this.messageTV = (TextView) itemView.findViewById(R.id.messageTV);
            this.downloadprogessPB = (ProgressBar) itemView.findViewById(R.id.downloadprogess);
            this.actalll = (LinearLayout) itemView.findViewById(R.id.actalll);
            this.classdurationll = (LinearLayout) itemView.findViewById(R.id.classdurationll);
            this.totalviewtimell = (LinearLayout) itemView.findViewById(R.id.totalviewtimell);
            this.remainingtimell = (LinearLayout) itemView.findViewById(R.id.remainingtimell);
            this.actualduration = (TextView) itemView.findViewById(R.id.actualduration);
            this.downloadprogessPB.setScaleY(1.5f);
        }

        public void setData(final ArrayList<Lists> list, final int position) {
            if (list != null && list.size() > 0 && SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getDisplay_locked().equalsIgnoreCase("1")) {
                this.ibt_single_sub_vd_RL.setVisibility(0);
                this.no_data_found_RL.setVisibility(8);
                if (SingleStudyAdapter4.this.contentType != null && SingleStudyAdapter4.this.contentType.equalsIgnoreCase("video" + SingleStudyAdapter4.this.tileIdAPI)) {
                    int i = position - 1;
                    if (list.get(i).getIs_live() != null && list.get(i).getIs_live().equals("1")) {
                        this.liveIV.setVisibility(0);
                    } else {
                        this.liveIV.setVisibility(8);
                    }
                } else {
                    this.liveIV.setVisibility(8);
                }
                int i2 = position - 1;
                if (TextUtils.isEmpty(list.get(i2).getIs_locked())) {
                    list.get(i2).setIs_locked("0");
                }
                if (SingleStudyAdapter4.this.singleStudy != null && SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail() != null && SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getIsPurchased().equals("1")) {
                    list.get(i2).setIs_locked("0");
                }
                if (list.get(i2).getIs_locked().equals("0")) {
                    this.lockRL.setVisibility(8);
                } else {
                    this.lockRL.setVisibility(0);
                }
                if (SingleStudyAdapter4.this.isSkip.equalsIgnoreCase("3")) {
                    this.forwardIV.setVisibility(8);
                    if (list.get(i2).getIs_download_available().equalsIgnoreCase("0") || list.get(i2).getVideo_type().equalsIgnoreCase("1") || list.get(i2).getVideo_type().equalsIgnoreCase("4")) {
                        this.optionMenuImgView.setVisibility(8);
                    } else {
                        this.optionMenuImgView.setVisibility(0);
                    }
                    if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getExtra_params() != null) {
                        if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getExtra_params().getIs_limited().equalsIgnoreCase("1")) {
                            this.LogsLL.setVisibility(0);
                            if (BuildConfig.FLAVOR.equalsIgnoreCase("Shrestha")) {
                                setvisibility(1, 0, 1, 0);
                            } else {
                                setvisibility(0, 1, 1, 1);
                            }
                            this.actualduration.setText(Helper.formatSeconds((int) Float.parseFloat(SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getVideo_duration())));
                            this.duration.setText(Helper.formatSeconds((int) Float.parseFloat(SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getVideo_length())));
                            this.total_view_time.setText(Helper.formatSeconds((int) (Float.parseFloat(SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getVideo_length()) - Float.parseFloat(SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getRemaining_time()))));
                            this.remaining_time.setText(Helper.formatSeconds((int) Float.parseFloat(SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getRemaining_time())));
                        } else {
                            this.LogsLL.setVisibility(8);
                        }
                    }
                    if (!TextUtils.isEmpty(list.get(i2).getThumbnail_url())) {
                        Helper.setThumbnailImage(SingleStudyAdapter4.this.activity, list.get(i2).getThumbnail_url(), SingleStudyAdapter4.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.imageIcon);
                    } else {
                        this.imageIcon.setImageResource(R.mipmap.square_placeholder);
                    }
                } else if (!TextUtils.isEmpty(list.get(i2).getImage_icon())) {
                    Helper.setThumbnailImage(SingleStudyAdapter4.this.activity, list.get(i2).getImage_icon(), SingleStudyAdapter4.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.imageIcon);
                } else {
                    this.imageIcon.setImageResource(R.mipmap.square_placeholder);
                }
                this.titleCategory.setText(list.get(i2).getTitle());
                if (SingleStudyAdapter4.this.isSkip.equalsIgnoreCase("3")) {
                    if (list.get(i2).getIs_locked().equals("0")) {
                        this.layout_fun.setVisibility(0);
                    } else {
                        this.layout_fun.setVisibility(8);
                    }
                    if (list.get(i2).getVideo_status() != null) {
                        if (list.get(i2).getVideo_status().equalsIgnoreCase("Download Running")) {
                            this.optionMenuImgView.setVisibility(8);
                            this.subItemRV.setVisibility(8);
                        } else if (list.get(i2).getVideo_status().equalsIgnoreCase("Downloaded")) {
                            this.optionMenuImgView.setVisibility(0);
                            this.optionMenuImgView.setEnabled(false);
                            this.subItemRV.setVisibility(8);
                            this.optionMenuImgView.setImageResource(R.drawable.ic_downloaded_chapter);
                            this.subItemRV.setText(SingleStudyAdapter4.this.activity.getResources().getString(R.string.duration) + list.get(i2).getVideo_time());
                        } else if (list.get(i2).getVideo_status().equalsIgnoreCase("Download")) {
                            this.optionMenuImgView.setEnabled(true);
                            this.subItemRV.setVisibility(8);
                            this.optionMenuImgView.setImageResource(R.drawable.ic_menu_download);
                            this.optionMenuImgView.setVisibility(0);
                        } else {
                            this.subItemRV.setVisibility(8);
                            this.optionMenuImgView.setVisibility(8);
                        }
                    }
                    if (list.get(i2).getFile_type().equalsIgnoreCase("3")) {
                        this.watch_now.setVisibility(0);
                        if ((list.get(i2).getOpen_in_app() == null || !list.get(i2).getOpen_in_app().equalsIgnoreCase("1")) && !list.get(i2).getVideo_type().equalsIgnoreCase("0") && !list.get(i2).getVideo_type().equalsIgnoreCase("1") && !list.get(i2).getVideo_type().equalsIgnoreCase("5") && list.get(i2).getVideo_type().equalsIgnoreCase("6")) {
                            this.listen_now.setVisibility(8);
                        } else {
                            this.listen_now.setVisibility(8);
                        }
                        this.layout_fun.setVisibility(8);
                    } else {
                        this.watch_now.setVisibility(8);
                    }
                    if (list.get(i2).getFile_type().equalsIgnoreCase("6") || list.get(i2).getFile_type().equalsIgnoreCase("12") || list.get(i2).getFile_type().equalsIgnoreCase("11") || list.get(i2).getFile_type().equalsIgnoreCase("8")) {
                        this.studyitemLL.setEnabled(true);
                        this.read_now.setEnabled(true);
                        this.read_now.setVisibility(0);
                        if (list.get(i2).getFile_type().equalsIgnoreCase("6")) {
                            this.read_now.setText(SingleStudyAdapter4.this.activity.getResources().getString(R.string.view));
                        } else {
                            this.read_now.setText(SingleStudyAdapter4.this.activity.getResources().getString(R.string.read));
                        }
                        this.share.setVisibility(8);
                        this.layout_fun.setVisibility(8);
                    } else {
                        this.studyitemLL.setEnabled(true);
                        this.read_now.setEnabled(false);
                        this.read_now.setVisibility(8);
                    }
                    if (list.get(i2).getIs_download_available().equalsIgnoreCase("0") || list.get(i2).getVideo_type().equalsIgnoreCase("1") || list.get(i2).getVideo_type().equalsIgnoreCase("4")) {
                        this.optionMenuImgView.setVisibility(8);
                    } else {
                        this.optionMenuImgView.setVisibility(0);
                    }
                } else {
                    this.layout_fun.setVisibility(8);
                    this.watch_now.setVisibility(8);
                    this.listen_now.setVisibility(8);
                    if (TextUtils.isEmpty(list.get(i2).getCount())) {
                        this.subItemRV.setVisibility(0);
                    } else {
                        this.subItemRV.setVisibility(8);
                        this.subItemRV.setText(list.get(i2).getCount() + " " + SingleStudyAdapter4.this.tileTypeAPI);
                    }
                }
                this.share.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyListHolder$$ExternalSyntheticLambda13
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$0(position, view);
                    }
                });
                this.optionMenuImgView.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyListHolder$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$setData$1(position);
                    }
                }));
                this.watch_now.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyListHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$2(position, view);
                    }
                });
                this.listen_now.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyListHolder$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$3(position, view);
                    }
                });
                this.read_now.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4.SingleStudyListHolder.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        if (((Lists) list.get(position - 1)).getIs_locked().equalsIgnoreCase("1")) {
                            if (SingleStudyAdapter4.this.isCourseSoldOut()) {
                                Toast.makeText(SingleStudyAdapter4.this.activity, R.string.sold_out_msg, 0).show();
                                return;
                            }
                            Intent intent = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) PurchaseActivity.class);
                            intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter4.this.singleStudy);
                            intent.putExtra(Const.IS_BOOK, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getCat_type());
                            intent.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                            Helper.gotoActivity(intent, SingleStudyAdapter4.this.activity);
                            return;
                        }
                        if (SingleStudyAdapter4.this.is_purchase.equalsIgnoreCase("1")) {
                            if (SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("12")) {
                                if (SingleStudyAdapter4.this.examPrepItem.getList().size() > 0) {
                                    Intent intent2 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) RevisionActivity.class);
                                    intent2.putExtra("t_id", SingleStudyAdapter4.this.tileIdAPI);
                                    intent2.putExtra("postion", position);
                                    intent2.putExtra(Const.VIDEO_ID, SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getId());
                                    intent2.putExtra("v_list", ExamPrepLayer2.actual_videolist);
                                    intent2.putExtra("f_id", SingleStudyAdapter4.this.examPrepItem.getList().get(0).getId());
                                    intent2.putExtra("c_id", SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId());
                                    intent2.putExtra("title", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getTitle());
                                    intent2.putExtra("url", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_url());
                                    intent2.putExtra(Const.VIA, "main");
                                    Helper.gotoActivity(intent2, SingleStudyAdapter4.this.activity);
                                    return;
                                }
                                return;
                            }
                            if (SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("11")) {
                                Intent intent3 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) WebViewActivty.class);
                                intent3.putExtra("type", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getTitle());
                                intent3.putExtra("url", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_url());
                                Helper.gotoActivity(intent3, SingleStudyAdapter4.this.activity);
                                return;
                            }
                            if (SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("8")) {
                                Intent intent4 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) WebViewActivty.class);
                                intent4.putExtra("type", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getTitle());
                                intent4.putExtra("url", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_url());
                                if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                                    intent4.putExtra("course_id", SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD);
                                } else {
                                    intent4.putExtra("course_id", SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId());
                                }
                                intent4.putExtra(Const.VIDEO_ID, SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getId());
                                intent4.putExtra("link", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type());
                                Helper.gotoActivity(intent4, SingleStudyAdapter4.this.activity);
                                return;
                            }
                            if (SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("6")) {
                                if (TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getId())) {
                                    Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.no_image_found), 0).show();
                                    return;
                                }
                                Intent intent5 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) WebViewActivty.class);
                                intent5.putExtra("type", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getTitle());
                                intent5.putExtra("url", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_url());
                                intent5.putExtra("file_type", "image");
                                Helper.gotoActivity(intent5, SingleStudyAdapter4.this.activity);
                                return;
                            }
                            return;
                        }
                        if (SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getIs_locked().equalsIgnoreCase("1")) {
                            if (SingleStudyAdapter4.this.isCourseSoldOut()) {
                                Toast.makeText(SingleStudyAdapter4.this.activity, R.string.sold_out_msg, 0).show();
                                return;
                            }
                            Intent intent6 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) PurchaseActivity.class);
                            intent6.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter4.this.singleStudy);
                            intent6.putExtra(Const.IS_BOOK, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getCat_type());
                            intent6.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                            Helper.gotoActivity(intent6, SingleStudyAdapter4.this.activity);
                            return;
                        }
                        if (SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("12")) {
                            if (SingleStudyAdapter4.this.examPrepItem.getList().size() > 0) {
                                Intent intent7 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) RevisionActivity.class);
                                intent7.putExtra("t_id", SingleStudyAdapter4.this.tileIdAPI);
                                intent7.putExtra("postion", position);
                                intent7.putExtra(Const.VIDEO_ID, SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getId());
                                intent7.putExtra("v_list", ExamPrepLayer2.actual_videolist);
                                intent7.putExtra("f_id", SingleStudyAdapter4.this.examPrepItem.getList().get(0).getId());
                                intent7.putExtra("c_id", SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId());
                                intent7.putExtra("title", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getTitle());
                                intent7.putExtra("url", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_url());
                                intent7.putExtra(Const.VIA, "main");
                                Helper.gotoActivity(intent7, SingleStudyAdapter4.this.activity);
                                return;
                            }
                            return;
                        }
                        if (SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("11")) {
                            Intent intent8 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) WebViewActivty.class);
                            intent8.putExtra("type", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getTitle());
                            intent8.putExtra("url", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_url());
                            Helper.gotoActivity(intent8, SingleStudyAdapter4.this.activity);
                            return;
                        }
                        if (SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("8")) {
                            Intent intent9 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) WebViewActivty.class);
                            intent9.putExtra("type", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getTitle());
                            intent9.putExtra("url", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_url());
                            if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                                intent9.putExtra("course_id", SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD);
                            } else {
                                intent9.putExtra("course_id", SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId());
                            }
                            intent9.putExtra(Const.VIDEO_ID, SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getId());
                            intent9.putExtra("link", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type());
                            Helper.gotoActivity(intent9, SingleStudyAdapter4.this.activity);
                            return;
                        }
                        if (SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("6")) {
                            if (TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getId())) {
                                Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.no_image_found), 0).show();
                                return;
                            }
                            Intent intent10 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) WebViewActivty.class);
                            intent10.putExtra("type", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getTitle());
                            intent10.putExtra("url", SingleStudyAdapter4.this.examPrepItem.getList().get(position - 1).getFile_url());
                            intent10.putExtra("file_type", "image");
                            Helper.gotoActivity(intent10, SingleStudyAdapter4.this.activity);
                        }
                    }
                });
                if (list.get(i2).getIs_locked().equals("0")) {
                    if (SingleStudyAdapter4.this.isSkip.equals("3")) {
                        this.studyitemLL.setEnabled(false);
                        if (list.get(i2).getIs_download_available().equalsIgnoreCase("0") || list.get(i2).getVideo_type().equalsIgnoreCase("1") || list.get(i2).getVideo_type().equalsIgnoreCase("4")) {
                            this.optionMenuImgView.setVisibility(8);
                        } else {
                            this.optionMenuImgView.setVisibility(0);
                        }
                    } else {
                        this.studyitemLL.setEnabled(true);
                    }
                } else {
                    this.optionMenuImgView.setVisibility(8);
                }
                this.studyitemLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyListHolder$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$4(list, position, view);
                    }
                });
                if (list.get(i2).getIs_locked().equals("0")) {
                    this.lockRL.setVisibility(8);
                    return;
                }
                this.lockRL.setVisibility(0);
                this.watch_now.setVisibility(8);
                this.read_now.setVisibility(8);
                this.LogsLL.setVisibility(8);
                this.studyitemLL.setEnabled(false);
                return;
            }
            this.ibt_single_sub_vd_RL.setVisibility(8);
            this.no_data_found_RL.setVisibility(0);
            this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4.SingleStudyListHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    SingleStudyAdapter4.this.activity.finish();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$0(int i, View view) {
            if (SingleStudyAdapter4.this.is_purchase.equalsIgnoreCase("1")) {
                int i2 = i - 1;
                if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("8") || SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("7") || SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("1")) {
                    Helper.sharePdf(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getTopic_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getRevert_api(), Const.PDF, SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getThumbnail_url(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getTitle(), SingleStudy.parentCourseId);
                    return;
                }
                if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getVideo_type().equalsIgnoreCase("4") || SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getVideo_type().equalsIgnoreCase("1") || SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getVideo_type().equalsIgnoreCase("7") || SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getVideo_type().equalsIgnoreCase("8")) {
                    Helper.shareLiveClass(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getTopic_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getRevert_api(), "video", SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getThumbnail_url(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getTitle(), SingleStudy.parentCourseId, SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getIs_locked());
                    return;
                } else {
                    if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getVideo_type().equalsIgnoreCase("6")) {
                        Helper.sharejwvideo(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getTopic_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getRevert_api(), "video", SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getThumbnail_url(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getTitle(), SingleStudy.parentCourseId);
                        return;
                    }
                    return;
                }
            }
            int i3 = i - 1;
            if (SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter4.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter4.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter4.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, SingleStudyAdapter4.this.activity);
                return;
            }
            if (SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getFile_type().equalsIgnoreCase("8") || SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getFile_type().equalsIgnoreCase("7") || SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getFile_type().equalsIgnoreCase("1")) {
                Helper.sharePdf(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getPayload().getCourse_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getId(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getPayload().getTopic_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getPayload().getTile_type(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getPayload().getTile_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getPayload().getRevert_api(), Const.PDF, SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getThumbnail_url(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getTitle(), SingleStudy.parentCourseId);
                return;
            }
            if (SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getVideo_type().equalsIgnoreCase("4") || SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getVideo_type().equalsIgnoreCase("1") || SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getVideo_type().equalsIgnoreCase("7") || SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getVideo_type().equalsIgnoreCase("8")) {
                Helper.shareLiveClass(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getPayload().getCourse_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getId(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getPayload().getTopic_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getPayload().getTile_type(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getPayload().getTile_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getPayload().getRevert_api(), "video", SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getThumbnail_url(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getTitle(), SingleStudy.parentCourseId, SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getIs_locked());
            } else if (SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getVideo_type().equalsIgnoreCase("6")) {
                Helper.sharejwvideo(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getPayload().getCourse_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getId(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getPayload().getTopic_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getPayload().getTile_type(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getPayload().getTile_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getPayload().getRevert_api(), "video", SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getThumbnail_url(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getTitle(), SingleStudy.parentCourseId);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$setData$1(int i) {
            if (Helper.isConnected(SingleStudyAdapter4.this.activity)) {
                if (SingleStudyAdapter4.this.is_purchase.equalsIgnoreCase("1")) {
                    int i2 = i - 1;
                    if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("10") || SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("12") || SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("11")) {
                        SingleStudyAdapter4 singleStudyAdapter4 = SingleStudyAdapter4.this;
                        singleStudyAdapter4.videodata = singleStudyAdapter4.examPrepItem.getList().get(i2);
                        SingleStudyAdapter4.this.position_delete = i;
                        delete_meg(SingleStudyAdapter4.this.videodata);
                    } else if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getVideo_type().equalsIgnoreCase("6") || SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getVideo_type().equalsIgnoreCase("7")) {
                        if (SingleStudyAdapter4.this.downloadCount == 0) {
                            SingleStudyAdapter4 singleStudyAdapter42 = SingleStudyAdapter4.this;
                            singleStudyAdapter42.videodata = singleStudyAdapter42.examPrepItem.getList().get(i2);
                            downloadLibMediaVIdeo(SingleStudyAdapter4.this.videodata, i);
                        } else {
                            Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.another_download_is_still_in_progress), 0).show();
                        }
                    } else {
                        Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.only_jw_video_download), 0).show();
                    }
                } else {
                    int i3 = i - 1;
                    if (SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getIs_locked().equalsIgnoreCase("1")) {
                        if (SingleStudyAdapter4.this.isCourseSoldOut()) {
                            Toast.makeText(SingleStudyAdapter4.this.activity, R.string.sold_out_msg, 0).show();
                            return null;
                        }
                        Intent intent = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) PurchaseActivity.class);
                        intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter4.this.singleStudy);
                        intent.putExtra(Const.IS_BOOK, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getCat_type());
                        intent.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                        Helper.gotoActivity(intent, SingleStudyAdapter4.this.activity);
                    } else if (SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getFile_type().equalsIgnoreCase("10") || SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getFile_type().equalsIgnoreCase("12") || SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getFile_type().equalsIgnoreCase("11")) {
                        SingleStudyAdapter4 singleStudyAdapter43 = SingleStudyAdapter4.this;
                        singleStudyAdapter43.videodata = singleStudyAdapter43.examPrepItem.getList().get(i3);
                        SingleStudyAdapter4.this.position_delete = i;
                        delete_meg(SingleStudyAdapter4.this.videodata);
                    } else if (!VideoDownloadService.isServiceRunning) {
                        if (SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getVideo_type().equalsIgnoreCase("6") || SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getVideo_type().equalsIgnoreCase("7")) {
                            if (SingleStudyAdapter4.this.downloadCount == 0) {
                                SingleStudyAdapter4 singleStudyAdapter44 = SingleStudyAdapter4.this;
                                singleStudyAdapter44.videodata = singleStudyAdapter44.examPrepItem.getList().get(i3);
                                downloadLibMediaVIdeo(SingleStudyAdapter4.this.videodata, i);
                            } else {
                                Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.another_download_is_still_in_progress), 0).show();
                            }
                        } else {
                            Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.only_jw_video_download), 0).show();
                        }
                    } else {
                        Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.please_wait_downloading_is_in_progress), 0).show();
                    }
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$2(int i, View view) {
            if (SingleStudyAdapter4.this.is_purchase.equalsIgnoreCase("1")) {
                int i2 = i - 1;
                if (TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId())) {
                    Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.no_video_found), 0).show();
                    return;
                }
                Helper.audio_service_close((CourseActivity) SingleStudyAdapter4.this.activity);
                SingleStudyAdapter4 singleStudyAdapter4 = SingleStudyAdapter4.this;
                singleStudyAdapter4.API_REQUEST_VIDEO_LINK(singleStudyAdapter4.examPrepItem.getList().get(i2), i2);
                return;
            }
            int i3 = i - 1;
            if (SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter4.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter4.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter4.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, SingleStudyAdapter4.this.activity);
                return;
            }
            if (TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getId())) {
                Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.no_video_found), 0).show();
                return;
            }
            Helper.audio_service_close((CourseActivity) SingleStudyAdapter4.this.activity);
            SingleStudyAdapter4 singleStudyAdapter42 = SingleStudyAdapter4.this;
            singleStudyAdapter42.API_REQUEST_VIDEO_LINK(singleStudyAdapter42.examPrepItem.getList().get(i3), i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$3(int i, View view) {
            if (Helper.isNetworkConnected(SingleStudyAdapter4.this.activity)) {
                if (SingleStudyAdapter4.this.is_purchase.equalsIgnoreCase("1")) {
                    int i2 = i - 1;
                    if (TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId())) {
                        Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.no_video_found), 0).show();
                        return;
                    }
                    Helper.audio_service_close((CourseActivity) SingleStudyAdapter4.this.activity);
                    if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getVideo_type().equalsIgnoreCase("6")) {
                        String str = "https://cdn.jwplayer.com/v2/media/" + SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_url().substring(SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_url().lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1, SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_url().indexOf("-"));
                        return;
                    }
                    if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getVideo_type().equalsIgnoreCase("1")) {
                        Helper.GoToLiveVideoActivity(SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getChat_node(), SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_url(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getVideo_type(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getTitle(), "1", SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getThumbnail_url(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getIs_chat_lock(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), String.valueOf(i2), SingleStudy.parentCourseId, SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), new ArrayList());
                        return;
                    }
                    if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getVideo_type().equalsIgnoreCase("5")) {
                        if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("1")) {
                            Helper.GoToLiveAwsVideoActivity(SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getVideo_type(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getChat_node(), SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_url(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getVideo_type(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getTitle(), "1", SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getThumbnail_url(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getIs_chat_lock(), String.valueOf(i2), SingleStudy.parentCourseId, SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getStart_date(), new ArrayList());
                            return;
                        }
                        if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("0")) {
                            Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getStart_date()) * 1000)), 0).show();
                            return;
                        } else if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("2")) {
                            Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                            return;
                        } else {
                            if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("3")) {
                                Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                                return;
                            }
                            return;
                        }
                    }
                    if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getVideo_type().equalsIgnoreCase("0")) {
                        Helper.GoToLiveAwsVideoActivity(SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getVideo_type(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getChat_node(), SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_url(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getVideo_type(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getTitle(), "1", SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getThumbnail_url(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getIs_chat_lock(), String.valueOf(i2), SingleStudy.parentCourseId, SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getStart_date(), new ArrayList());
                        return;
                    }
                    if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getVideo_type().equalsIgnoreCase("7")) {
                        if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getIs_drm().equals("0")) {
                            if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId() == null || SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId().equalsIgnoreCase("")) {
                                Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                                return;
                            } else {
                                Helper.GoToLiveAwsVideoActivity(SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getVideo_type(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getChat_node(), SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getVideo_type(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getTitle(), "1", SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getThumbnail_url(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getStart_date(), new ArrayList());
                                return;
                            }
                        }
                        if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getIs_drm().equals("1")) {
                            if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId() == null || SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId().equalsIgnoreCase("")) {
                                Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                                return;
                            } else {
                                Helper.GoToVideoCryptActivity(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getVideo_type(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getChat_node(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getVideo_type(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getTitle(), "1", SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getThumbnail_url(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getStart_date(), "0", new ArrayList());
                                return;
                            }
                        }
                        return;
                    }
                    if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getVideo_type().equalsIgnoreCase("8")) {
                        if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getIs_drm().equals("0")) {
                            if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("1")) {
                                if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId() == null || SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId().equalsIgnoreCase("")) {
                                    Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                                    return;
                                } else {
                                    Helper.GoToLiveAwsVideoActivity(SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getVideo_type(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getChat_node(), SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getVideo_type(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getTitle(), "1", SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getThumbnail_url(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getStart_date(), new ArrayList());
                                    return;
                                }
                            }
                            if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("0")) {
                                Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getStart_date()) * 1000)), 0).show();
                                return;
                            } else if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("2")) {
                                Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                                return;
                            } else {
                                if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("3")) {
                                    Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                                    return;
                                }
                                return;
                            }
                        }
                        if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getIs_drm().equals("1")) {
                            if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("1")) {
                                if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId() == null || SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId().equalsIgnoreCase("")) {
                                    Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                                    return;
                                } else {
                                    Helper.GoToVideoCryptActivity(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getVideo_type(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getChat_node(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getVideo_type(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getTitle(), "1", SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getThumbnail_url(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getStart_date(), "0", new ArrayList());
                                    return;
                                }
                            }
                            if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("0")) {
                                Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getStart_date()) * 1000)), 0).show();
                                return;
                            } else if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("2")) {
                                Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                                return;
                            } else {
                                if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("3")) {
                                    Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.live_class_is_cancelled), 0).show();
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
                if (SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getIs_locked().equalsIgnoreCase("1")) {
                    if (SingleStudyAdapter4.this.isCourseSoldOut()) {
                        Toast.makeText(SingleStudyAdapter4.this.activity, R.string.sold_out_msg, 0).show();
                        return;
                    }
                    Intent intent = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) PurchaseActivity.class);
                    intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter4.this.singleStudy);
                    intent.putExtra(Const.IS_BOOK, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getCat_type());
                    intent.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                    Helper.gotoActivity(intent, SingleStudyAdapter4.this.activity);
                    return;
                }
                if (TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getId())) {
                    Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.no_video_found), 0).show();
                    return;
                }
                Helper.audio_service_close((CourseActivity) SingleStudyAdapter4.this.activity);
                if (SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getVideo_type().equalsIgnoreCase("6")) {
                    String str2 = "https://cdn.jwplayer.com/v2/media/" + SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getFile_url().substring(SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getFile_url().lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1, SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getFile_url().indexOf("-"));
                    return;
                } else if (SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getVideo_type().equalsIgnoreCase("1")) {
                    Helper.GoToLiveVideoActivity(SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getChat_node(), SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getFile_url(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getVideo_type(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getId(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getTitle(), "1", SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getThumbnail_url(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getIs_chat_lock(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getPayload().getCourse_id(), String.valueOf(i3), SingleStudy.parentCourseId, SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getPayload().getTile_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getPayload().getTile_type(), new ArrayList());
                    return;
                } else {
                    if (SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getVideo_type().equalsIgnoreCase("5")) {
                        Helper.GoToLiveAwsVideoActivity(SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getVideo_type(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getChat_node(), SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getFile_url(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getVideo_type(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getId(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getTitle(), "1", SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getThumbnail_url(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getPayload().getCourse_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getPayload().getTile_id(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getPayload().getTile_type(), SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getIs_chat_lock(), String.valueOf(i3), SingleStudy.parentCourseId, SingleStudyAdapter4.this.examPrepItem.getList().get(i3).getStart_date(), new ArrayList());
                        return;
                    }
                    return;
                }
            }
            Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$4(ArrayList arrayList, int i, View view) {
            this.studyitemLL.setFocusable(true);
            this.studyitemLL.setClickable(true);
            this.studyitemLL.setBackgroundDrawable(SingleStudyAdapter4.this.activity.getResources().getDrawable(R.drawable.nav_ripple));
            int i2 = i - 1;
            if (((Lists) arrayList.get(i2)).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter4.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter4.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter4.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, SingleStudyAdapter4.this.activity);
                return;
            }
            if (SingleStudyAdapter4.this.isSkip.equalsIgnoreCase("1") || SingleStudyAdapter4.this.isSkip.equalsIgnoreCase("2")) {
                Intent intent2 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) CourseActivity.class);
                SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(SingleStudyAdapter4.this.singleStudy != null ? SingleStudyAdapter4.this.singleStudy : new CourseDetail()));
                SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(SingleStudyAdapter4.this.examPrepItem != null ? SingleStudyAdapter4.this.examPrepItem : new ExamPrepItem()));
                SharedPreference.getInstance().putString("list", new Gson().toJson(SingleStudyAdapter4.this.examPrepItem.getList().get(i2) != null ? SingleStudyAdapter4.this.examPrepItem.getList().get(i2) : new Lists()));
                intent2.putExtra(Const.FRAG_TYPE, Const.EXAMPREPLAST);
                intent2.putExtra(Const.IS_COMBO, SingleStudyAdapter4.this.isCombo);
                intent2.putExtra(Const.LIST_SUBJECT, SingleStudyAdapter4.this.examPrepItem.getList().get(i2));
                intent2.putExtra("title", SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getTitle());
                intent2.putExtra("content_type", SingleStudyAdapter4.this.contentType);
                intent2.putExtra(Const.TEST_TYPE, SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getCount());
                intent2.putExtra("tile_id", SingleStudyAdapter4.this.tileIdAPI);
                intent2.putExtra(Const.TILE_TYPE, SingleStudyAdapter4.this.tileTypeAPI);
                intent2.putExtra(Const.REVERT_API, SingleStudyAdapter4.this.revertAPI);
                Helper.gotoActivity(intent2, SingleStudyAdapter4.this.activity);
                return;
            }
            if (SingleStudyAdapter4.this.isSkip.equalsIgnoreCase("3")) {
                if (SingleStudyAdapter4.this.is_purchase.equalsIgnoreCase("1")) {
                    if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("12")) {
                        if (SingleStudyAdapter4.this.examPrepItem.getList().size() > 0) {
                            Intent intent3 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) RevisionActivity.class);
                            intent3.putExtra("t_id", SingleStudyAdapter4.this.tileIdAPI);
                            intent3.putExtra("postion", i);
                            intent3.putExtra(Const.VIDEO_ID, SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId());
                            intent3.putExtra("v_list", ExamPrepLayer2.actual_videolist);
                            intent3.putExtra("f_id", SingleStudyAdapter4.this.examPrepItem.getList().get(0).getId());
                            intent3.putExtra("c_id", SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId());
                            intent3.putExtra("title", SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getTitle());
                            intent3.putExtra("url", SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_url());
                            intent3.putExtra(Const.VIA, "main");
                            Helper.gotoActivity(intent3, SingleStudyAdapter4.this.activity);
                            return;
                        }
                        return;
                    }
                    if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("11")) {
                        Intent intent4 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) WebViewActivty.class);
                        intent4.putExtra("type", SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getTitle());
                        intent4.putExtra("url", SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_url());
                        Helper.gotoActivity(intent4, SingleStudyAdapter4.this.activity);
                        return;
                    }
                    if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("8")) {
                        Intent intent5 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) WebViewActivty.class);
                        intent5.putExtra("type", SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getTitle());
                        intent5.putExtra("url", SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_url());
                        if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                            intent5.putExtra("course_id", SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD);
                        } else {
                            intent5.putExtra("course_id", SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId());
                        }
                        intent5.putExtra(Const.VIDEO_ID, SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId());
                        intent5.putExtra("link", SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_type());
                        Helper.gotoActivity(intent5, SingleStudyAdapter4.this.activity);
                        return;
                    }
                    if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("6")) {
                        if (TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId())) {
                            Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.no_image_found), 0).show();
                            return;
                        }
                        Intent intent6 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) WebViewActivty.class);
                        intent6.putExtra("type", SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getTitle());
                        intent6.putExtra("url", SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_url());
                        intent6.putExtra("file_type", "image");
                        Helper.gotoActivity(intent6, SingleStudyAdapter4.this.activity);
                        return;
                    }
                    return;
                }
                if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getIs_locked().equalsIgnoreCase("1")) {
                    if (SingleStudyAdapter4.this.isCourseSoldOut()) {
                        Toast.makeText(SingleStudyAdapter4.this.activity, R.string.sold_out_msg, 0).show();
                        return;
                    }
                    Intent intent7 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) PurchaseActivity.class);
                    intent7.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter4.this.singleStudy);
                    intent7.putExtra(Const.IS_BOOK, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getCat_type());
                    intent7.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                    Helper.gotoActivity(intent7, SingleStudyAdapter4.this.activity);
                    return;
                }
                if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("12")) {
                    if (SingleStudyAdapter4.this.examPrepItem.getList().size() > 0) {
                        Intent intent8 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) RevisionActivity.class);
                        intent8.putExtra("t_id", SingleStudyAdapter4.this.tileIdAPI);
                        intent8.putExtra("postion", i);
                        intent8.putExtra(Const.VIDEO_ID, SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId());
                        intent8.putExtra("v_list", ExamPrepLayer2.actual_videolist);
                        intent8.putExtra("f_id", SingleStudyAdapter4.this.examPrepItem.getList().get(0).getId());
                        intent8.putExtra("c_id", SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId());
                        intent8.putExtra("title", SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getTitle());
                        intent8.putExtra("url", SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_url());
                        intent8.putExtra(Const.VIA, "main");
                        Helper.gotoActivity(intent8, SingleStudyAdapter4.this.activity);
                        return;
                    }
                    return;
                }
                if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("11")) {
                    Intent intent9 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) WebViewActivty.class);
                    intent9.putExtra("type", SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getTitle());
                    intent9.putExtra("url", SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_url());
                    Helper.gotoActivity(intent9, SingleStudyAdapter4.this.activity);
                    return;
                }
                if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("8")) {
                    Intent intent10 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) WebViewActivty.class);
                    intent10.putExtra("type", SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getTitle());
                    intent10.putExtra("url", SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_url());
                    if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                        intent10.putExtra("course_id", SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD);
                    } else {
                        intent10.putExtra("course_id", SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId());
                    }
                    intent10.putExtra(Const.VIDEO_ID, SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId());
                    intent10.putExtra("link", SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_type());
                    Helper.gotoActivity(intent10, SingleStudyAdapter4.this.activity);
                    return;
                }
                if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("6")) {
                    if (TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId())) {
                        Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.no_image_found), 0).show();
                        return;
                    }
                    Intent intent11 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) WebViewActivty.class);
                    intent11.putExtra("type", SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getTitle());
                    intent11.putExtra("url", SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_url());
                    intent11.putExtra("file_type", "image");
                    Helper.gotoActivity(intent11, SingleStudyAdapter4.this.activity);
                    return;
                }
                if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("3")) {
                    if (SingleStudyAdapter4.this.is_purchase.equalsIgnoreCase("1")) {
                        if (TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId())) {
                            Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.no_video_found), 0).show();
                            return;
                        }
                        Helper.audio_service_close((CourseActivity) SingleStudyAdapter4.this.activity);
                        SingleStudyAdapter4 singleStudyAdapter4 = SingleStudyAdapter4.this;
                        singleStudyAdapter4.API_REQUEST_VIDEO_LINK(singleStudyAdapter4.examPrepItem.getList().get(i2), i2);
                        return;
                    }
                    if (SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getIs_locked().equalsIgnoreCase("1")) {
                        if (SingleStudyAdapter4.this.isCourseSoldOut()) {
                            Toast.makeText(SingleStudyAdapter4.this.activity, R.string.sold_out_msg, 0).show();
                            return;
                        }
                        Intent intent12 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) PurchaseActivity.class);
                        intent12.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter4.this.singleStudy);
                        intent12.putExtra(Const.IS_BOOK, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getCat_type());
                        intent12.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                        Helper.gotoActivity(intent12, SingleStudyAdapter4.this.activity);
                        return;
                    }
                    if (TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getId())) {
                        Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.no_video_found), 0).show();
                        return;
                    }
                    Helper.audio_service_close((CourseActivity) SingleStudyAdapter4.this.activity);
                    SingleStudyAdapter4 singleStudyAdapter42 = SingleStudyAdapter4.this;
                    singleStudyAdapter42.API_REQUEST_VIDEO_LINK(singleStudyAdapter42.examPrepItem.getList().get(i2), i2);
                    return;
                }
                return;
            }
            ExamPrepItem examPrepItem = new ExamPrepItem();
            examPrepItem.setList(SingleStudyAdapter4.this.examPrepItem.getList().get(i2).getList());
            Intent intent13 = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) CourseActivity.class);
            SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(SingleStudyAdapter4.this.singleStudy != null ? SingleStudyAdapter4.this.singleStudy : new CourseDetail()));
            SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(examPrepItem));
            SharedPreference.getInstance().putString("list", new Gson().toJson(arrayList.get(i2) != null ? arrayList.get(i2) : new Lists()));
            intent13.putExtra(Const.FRAG_TYPE, Const.EXAMPREP);
            intent13.putExtra(Const.IS_COMBO, SingleStudyAdapter4.this.isCombo);
            intent13.putExtra("content_type", SingleStudyAdapter4.this.contentType);
            intent13.putExtra("title", SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail() != null ? SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getTitle() : "Course");
            intent13.putExtra("tile_id", SingleStudyAdapter4.this.tileIdAPI);
            intent13.putExtra(Const.TILE_TYPE, SingleStudyAdapter4.this.tileTypeAPI);
            intent13.putExtra(Const.REVERT_API, SingleStudyAdapter4.this.revertAPI);
            Helper.gotoActivity(intent13, SingleStudyAdapter4.this.activity);
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

        private void delete_meg(Lists video) {
            final Dialog dialog = new Dialog(SingleStudyAdapter4.this.activity);
            dialog.setCancelable(false);
            dialog.requestWindowFeature(1);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
            dialog.setContentView(R.layout.dialog_alert_simple);
            ((TextView) dialog.findViewById(R.id.titleDialog)).setVisibility(8);
            ((TextView) dialog.findViewById(R.id.msgDialog)).setText(SingleStudyAdapter4.this.activity.getResources().getString(R.string.do_you_want_to_delete) + video.getTitle());
            Button button = (Button) dialog.findViewById(R.id.btn_cancel);
            button.setText(SingleStudyAdapter4.this.activity.getResources().getString(R.string.no));
            Button button2 = (Button) dialog.findViewById(R.id.btn_submit);
            button2.setText(SingleStudyAdapter4.this.activity.getResources().getString(R.string.yes));
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyListHolder$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$delete_meg$5(dialog, view);
                }
            });
            button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyListHolder$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            dialog.show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$delete_meg$5(Dialog dialog, View view) {
            SingleStudyAdapter4 singleStudyAdapter4 = SingleStudyAdapter4.this;
            new NetworkCall(singleStudyAdapter4, singleStudyAdapter4.activity).NetworkAPICall(API.delete_revision, "", true, false);
            dialog.dismiss();
            dialog.cancel();
        }

        private void downloadLibMediaVIdeo(final Lists video, final int position) {
            final Dialog dialog = new Dialog(SingleStudyAdapter4.this.activity);
            dialog.setCancelable(false);
            dialog.requestWindowFeature(1);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
            dialog.setContentView(R.layout.dialog_alert_simple);
            ((TextView) dialog.findViewById(R.id.titleDialog)).setText(SingleStudyAdapter4.this.activity.getResources().getString(R.string.download_video));
            ((TextView) dialog.findViewById(R.id.msgDialog)).setText(video.getTitle() + SingleStudyAdapter4.this.activity.getResources().getString(R.string.this_video_will_be_downloaded_in_your_my_downloads));
            Button button = (Button) dialog.findViewById(R.id.btn_cancel);
            button.setText(SingleStudyAdapter4.this.activity.getResources().getString(R.string.cancel));
            Button button2 = (Button) dialog.findViewById(R.id.btn_submit);
            button2.setText(SingleStudyAdapter4.this.activity.getResources().getString(R.string.download_));
            button2.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyListHolder$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$downloadLibMediaVIdeo$7(video, position, dialog);
                }
            }));
            button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyListHolder$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            dialog.show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$downloadLibMediaVIdeo$7(Lists lists, int i, Dialog dialog) {
            if (SingleStudyAdapter4.this.is_purchase.equalsIgnoreCase("1")) {
                this.optionMenuImgView.setEnabled(false);
                downloadServiceLibMedia(lists, i);
            } else {
                Toast.makeText(SingleStudyAdapter4.this.activity, SingleStudyAdapter4.this.activity.getResources().getString(R.string.this_feature_is_only_available_for_courses_in_your_library), 0).show();
            }
            dialog.dismiss();
            dialog.cancel();
            return null;
        }

        private void downloadServiceLibMedia(Lists video, int position) {
            String str;
            this.videosDownload = new VideosDownload();
            if (SingleStudyAdapter4.this.utkashRoom.getvideoDownloadao().isvideo_exit(video.getId(), MakeMyExam.userId)) {
                VideosDownload videosDownload = SingleStudyAdapter4.this.utkashRoom.getvideoDownloadao().getvideo_byuserid(video.getId(), MakeMyExam.userId);
                this.videosDownload = videosDownload;
                videosDownload.setVideo_status("Download Running");
                this.videosDownload.setThumbnail_url(video.getThumbnail_url());
            } else {
                this.videosDownload.setVideo_id(video.getId());
                this.videosDownload.setThumbnail_url(video.getThumbnail_url());
                if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                    str = SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD;
                } else {
                    str = SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + SingleStudyAdapter4.this.singleStudy.getData().getCourseDetail().getId();
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
                this.videosDownload.setIs_limited(video.getExtra_params().getIs_limited());
                this.videosDownload.setMultiplayer(video.getMultiplayer());
                this.videosDownload.setRemaining_time(video.getRemaining_time());
                this.videosDownload.setVideo_length(video.getVideo_length());
                this.videosDownload.setTile_id(SingleStudyAdapter4.this.tileIdAPI);
            }
            if (SingleStudyAdapter4.this.progress.isShowing()) {
                SingleStudyAdapter4.this.progress.dismiss();
            }
            if (video.getBitrate_urls() != null && video.getBitrate_urls().size() > 0) {
                openwatchlist_dailog_resource(SingleStudyAdapter4.this.activity, video.getBitrate_urls(), this.videosDownload, position);
            } else {
                this.optionMenuImgView.setEnabled(true);
            }
        }

        public void openwatchlist_dailog_resource(Context context, final ArrayList<UrlObject> mediaResponseMap, final VideosDownload videosDownload, final int pos) {
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
                textView2.setText(videosDownload.getVideo_name());
                if (mediaResponseMap.size() >= 3) {
                    ((TextView) Objects.requireNonNull(textView)).setVisibility(0);
                    ((TextView) Objects.requireNonNull(textView3)).setVisibility(0);
                    ((TextView) Objects.requireNonNull(textView4)).setVisibility(0);
                } else if (mediaResponseMap.size() == 2) {
                    ((TextView) Objects.requireNonNull(textView)).setVisibility(0);
                    ((TextView) Objects.requireNonNull(textView3)).setVisibility(0);
                } else if (mediaResponseMap.size() == 1) {
                    ((TextView) Objects.requireNonNull(textView)).setVisibility(0);
                }
                ((LinearLayout) Objects.requireNonNull(linearLayout)).setVisibility(8);
                ((TextView) Objects.requireNonNull(textView)).setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyListHolder$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$openwatchlist_dailog_resource$9(pos, videosDownload, mediaResponseMap, bottomSheetDialog);
                    }
                }));
                ((TextView) Objects.requireNonNull(textView3)).setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyListHolder$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$openwatchlist_dailog_resource$10(pos, videosDownload, mediaResponseMap, bottomSheetDialog);
                    }
                }));
                ((TextView) Objects.requireNonNull(textView4)).setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyListHolder$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$openwatchlist_dailog_resource$11(pos, videosDownload, mediaResponseMap, bottomSheetDialog);
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
        public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$9(int i, VideosDownload videosDownload, ArrayList arrayList, BottomSheetDialog bottomSheetDialog) {
            if (SingleStudyAdapter4.this.utkashRoom.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread() || !Helper.isNetworkConnected(SingleStudyAdapter4.this.activity)) {
                return null;
            }
            SingleStudyAdapter4.this.examPrepItem.getList().get(i - 1).setVideo_status("Download Running");
            if (SingleStudyAdapter4.this.utkashRoom.getvideoDownloadao().isvideo_exit(videosDownload.getVideo_id(), MakeMyExam.userId)) {
                SingleStudyAdapter4.this.utkashRoom.getvideoDownloadao().update_videostatus(videosDownload.getVideo_id(), videosDownload.getVideo_status(), MakeMyExam.userId);
            } else {
                SingleStudyAdapter4.this.utkashRoom.getvideoDownloadao().addUser(videosDownload);
            }
            SingleStudyAdapter4.this.notifyItemChanged(i);
            Download_dialog(((UrlObject) arrayList.get(0)).getUrl(), videosDownload);
            dismissCalculatorDialog(bottomSheetDialog);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$10(int i, VideosDownload videosDownload, ArrayList arrayList, BottomSheetDialog bottomSheetDialog) {
            if (SingleStudyAdapter4.this.utkashRoom.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread() || !Helper.isNetworkConnected(SingleStudyAdapter4.this.activity)) {
                return null;
            }
            SingleStudyAdapter4.this.examPrepItem.getList().get(i - 1).setVideo_status("Download Running");
            if (SingleStudyAdapter4.this.utkashRoom.getvideoDownloadao().isvideo_exit(videosDownload.getVideo_id(), MakeMyExam.userId)) {
                SingleStudyAdapter4.this.utkashRoom.getvideoDownloadao().update_videostatus(videosDownload.getVideo_id(), videosDownload.getVideo_status(), MakeMyExam.userId);
            } else {
                SingleStudyAdapter4.this.utkashRoom.getvideoDownloadao().addUser(videosDownload);
            }
            SingleStudyAdapter4.this.notifyItemChanged(i);
            Download_dialog(((UrlObject) arrayList.get(1)).getUrl(), videosDownload);
            dismissCalculatorDialog(bottomSheetDialog);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$11(int i, VideosDownload videosDownload, ArrayList arrayList, BottomSheetDialog bottomSheetDialog) {
            if (SingleStudyAdapter4.this.utkashRoom.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread() || !Helper.isNetworkConnected(SingleStudyAdapter4.this.activity)) {
                return null;
            }
            SingleStudyAdapter4.this.examPrepItem.getList().get(i - 1).setVideo_status("Download Running");
            if (SingleStudyAdapter4.this.utkashRoom.getvideoDownloadao().isvideo_exit(videosDownload.getVideo_id(), MakeMyExam.userId)) {
                SingleStudyAdapter4.this.utkashRoom.getvideoDownloadao().update_videostatus(videosDownload.getVideo_id(), videosDownload.getVideo_status(), MakeMyExam.userId);
            } else {
                SingleStudyAdapter4.this.utkashRoom.getvideoDownloadao().addUser(videosDownload);
            }
            SingleStudyAdapter4.this.notifyItemChanged(i);
            Download_dialog(((UrlObject) arrayList.get(2)).getUrl(), videosDownload);
            dismissCalculatorDialog(bottomSheetDialog);
            return null;
        }

        private void Download_dialog(String url, final VideosDownload videosDownload) {
            if (SingleStudyAdapter4.this.utkashRoom.getvideoDownloadao().getuser(videosDownload.getVideo_id(), videosDownload.getIs_complete()).getToal_downloadlocale() == null || SingleStudyAdapter4.this.utkashRoom.getvideoDownloadao().getuser(videosDownload.getVideo_id(), videosDownload.getIs_complete()).getToal_downloadlocale().longValue() != 0) {
                return;
            }
            SingleStudyAdapter4.this.utkashRoom.getvideoDownloadao().update_pos(MakeMyExam.userId, videosDownload.getVideo_id(), SingleStudyAdapter4.this.utkashRoom.getvideoDownloadao().getalldownload_videos(MakeMyExam.userId).size() - 1);
            Intent intent = new Intent(SingleStudyAdapter4.this.activity, (Class<?>) VideoDownloadService.class);
            intent.putExtra(VideoDownloadService.FILEDOWNLOADSTATUS, false);
            intent.putExtra(VideoDownloadService.URL, url);
            intent.putExtra(VideoDownloadService.DOWNLOAD_SERVICE_ID, videosDownload.getVideo_id());
            intent.putExtra(VideoDownloadService.FILEPATH, videosDownload.getVideo_name());
            intent.putExtra("name", videosDownload.getVideo_history());
            intent.putExtra(Constants.INAPP_POSITION, SingleStudyAdapter4.this.utkashRoom.getvideoDownloadao().getalldownload_videos(MakeMyExam.userId).size() - 1);
            intent.putExtra("status", videosDownload.getVideo_status());
            VideoDownloadService.isServiceRunning = true;
            Helper.startVideoDownloadService(SingleStudyAdapter4.this.activity, intent);
            SingleStudyAdapter4.this.pushEventForDownload(videosDownload);
            SingleStudyAdapter4.this.activity.runOnUiThread(new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyListHolder$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$Download_dialog$12(videosDownload);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$Download_dialog$12(VideosDownload videosDownload) {
            waiting_dialog(videosDownload.getVideo_name());
        }

        private void waiting_dialog(String video_name) {
            final Dialog dialog = new Dialog(SingleStudyAdapter4.this.activity);
            dialog.setCancelable(false);
            dialog.requestWindowFeature(1);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
            dialog.setContentView(R.layout.dialog_alert_downloads);
            ((TextView) dialog.findViewById(R.id.titleDialog)).setText("Video");
            ((TextView) dialog.findViewById(R.id.msgDialog)).setText(video_name);
            Button button = (Button) dialog.findViewById(R.id.btn_cancel);
            ((Button) dialog.findViewById(R.id.btn_submit)).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyListHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$waiting_dialog$13(dialog, view);
                }
            });
            button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$SingleStudyListHolder$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SingleStudyAdapter4.SingleStudyListHolder.lambda$waiting_dialog$14(dialog, view);
                }
            });
            dialog.show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$waiting_dialog$13(Dialog dialog, View view) {
            Helper.gotoActivity(new Intent(SingleStudyAdapter4.this.activity, (Class<?>) DownloadActivity.class), SingleStudyAdapter4.this.activity);
            SingleStudyAdapter4.this.activity.finish();
            dialog.dismiss();
            dialog.cancel();
        }

        static /* synthetic */ void lambda$waiting_dialog$14(Dialog dialog, View view) {
            dialog.dismiss();
            dialog.cancel();
        }

        private void dismissCalculatorDialog(BottomSheetDialog watchlist) {
            if (watchlist == null || !watchlist.isShowing()) {
                return;
            }
            watchlist.dismiss();
            watchlist.cancel();
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
                if (SingleStudyAdapter4.this.isLodded.booleanValue()) {
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
                    OverviewRVAdapter overviewRVAdapter = new OverviewRVAdapter(SingleStudyAdapter4.this.activity, basic, overview, this.recyclerView, z, z2);
                    this.recyclerView.setLayoutManager(new LinearLayoutManager(SingleStudyAdapter4.this.activity, 1, false));
                    this.recyclerView.setAdapter(overviewRVAdapter);
                    SingleStudyAdapter4.this.isLodded = false;
                    return;
                }
                return;
            }
            this.recyclerView.setVisibility(8);
            this.no_data_found_RL.setVisibility(0);
            this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4.OverViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    SingleStudyAdapter4.this.activity.finish();
                }
            });
        }
    }

    public class SingleStudyHeaderHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView courseIV;
        LinearLayout coursePanelLL;
        TextView duration_value;
        TextView faculty_name;
        TextView ibt_single_vd_tv_day;
        TextView leftTextTV;
        View.OnClickListener onTileClicklistener;
        TextView rightTextTV;
        TextView stream_name;
        TextView titleTV;

        public SingleStudyHeaderHolder(View itemView) {
            super(itemView);
            this.onTileClicklistener = new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4.SingleStudyHeaderHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    for (int i = 0; i < SingleStudyAdapter4.this.viewArrayList.size(); i++) {
                        if (view == SingleStudyAdapter4.this.viewArrayList.get(i)) {
                            TilesItem tilesItem = (TilesItem) view.getTag();
                            SingleStudyAdapter4.this.buttonClicked.onTitleClicked4(tilesItem, SingleStudyAdapter4.this.singleStudy.getData().getTiles(), SingleStudyAdapter4.this.tilePos);
                            SingleStudyAdapter4.this.contentType = tilesItem.getType() + tilesItem.getId();
                            SingleStudyAdapter4.this.typeState = tilesItem.getType();
                        }
                    }
                }
            };
            this.coursePanelLL = (LinearLayout) itemView.findViewById(R.id.coursePanelLL);
            this.leftTextTV = (TextView) itemView.findViewById(R.id.videosCount);
            this.rightTextTV = (TextView) itemView.findViewById(R.id.testCount);
            this.stream_name = (TextView) itemView.findViewById(R.id.stream_name);
            this.duration_value = (TextView) itemView.findViewById(R.id.duration_value);
            this.ibt_single_vd_tv_day = (TextView) itemView.findViewById(R.id.ibt_single_vd_tv_day);
            this.faculty_name = (TextView) itemView.findViewById(R.id.faculty_name);
            this.titleTV = (TextView) itemView.findViewById(R.id.upperTitle);
            this.courseIV = (ImageView) itemView.findViewById(R.id.courseImageIcon);
        }

        public void setData(CourseDetail singleStudy) {
            this.titleTV.setText(singleStudy.getData().getCourseDetail().getTitle());
            this.coursePanelLL.removeAllViews();
            ArrayList<TilesItem> arrayList = new ArrayList();
            for (TilesItem tilesItem : singleStudy.getData().getTiles()) {
                if (!tilesItem.getType().equalsIgnoreCase(Const.OVERVIEW) && !tilesItem.getType().equalsIgnoreCase(Const.COMBO) && !tilesItem.getType().equalsIgnoreCase(Const.FAQ) && !tilesItem.getType().equalsIgnoreCase("content")) {
                    arrayList.add(tilesItem);
                }
            }
            if (arrayList.size() > 0) {
                if (arrayList.size() == 1) {
                    if (((TilesItem) arrayList.get(0)).getMeta() != null && !TextUtils.isEmpty(((TilesItem) arrayList.get(0)).getMeta()) && SingleStudyAdapter4.this.examPrepItem.getList() != null && SingleStudyAdapter4.this.examPrepItem.getList().size() > 0) {
                        this.coursePanelLL.setWeightSum(arrayList.size());
                        for (TilesItem tilesItem2 : arrayList) {
                            this.coursePanelLL.setGravity(17);
                            this.coursePanelLL.addView(addTiles(tilesItem2));
                        }
                        return;
                    }
                    this.coursePanelLL.setVisibility(4);
                    return;
                }
                this.coursePanelLL.setWeightSum(arrayList.size());
                for (TilesItem tilesItem3 : arrayList) {
                    this.coursePanelLL.setGravity(17);
                    this.coursePanelLL.addView(addTiles(tilesItem3));
                }
            }
        }

        private LinearLayout addTiles(TilesItem cards) {
            LinearLayout linearLayout = (LinearLayout) View.inflate(SingleStudyAdapter4.this.activity, R.layout.single_item_tiles, null);
            TextView textView = (TextView) linearLayout.findViewById(R.id.tilesTextTv);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1, 1.0f);
            textView.setText(cards.getTileName());
            if (SingleStudyAdapter4.this.contentType.equals(cards.getType() + "" + cards.getId())) {
                SingleStudyAdapter4.this.typeState = cards.getType();
                linearLayout.setBackground(SingleStudyAdapter4.this.activity.getResources().getDrawable(R.drawable.background_rectangle_course_content_dark));
                textView.setTextColor(-1);
            }
            linearLayout.setTag(cards);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setGravity(17);
            linearLayout.setPadding(2, 2, 2, 10);
            SingleStudyAdapter4.this.viewArrayList.add(linearLayout);
            linearLayout.setOnClickListener(this.onTileClicklistener);
            return linearLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            v.getId();
        }
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
                    Helper.GoToLiveAwsVideoActivity(videoData.getVideo_type(), videoData.getChat_node(), this.activity, videoData.getId(), videoData.getVideo_type(), videoData.getId(), videoData.getTitle(), "0", videoData.getThumbnail_url(), videoData.getPayload().getCourse_id(), videoData.getPayload().getTile_id(), videoData.getPayload().getTile_type(), videoData.getIs_chat_lock(), String.valueOf(position), SingleStudy.parentCourseId, this.examPrepItem.getList().get(position).getStart_date(), new ArrayList());
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
            Helper.GoToLiveAwsVideoActivity(videoData.getVideo_type(), videoData.getChat_node(), this.activity, videoData.getId(), videoData.getVideo_type(), videoData.getId(), videoData.getTitle(), "0", videoData.getThumbnail_url(), videoData.getPayload().getCourse_id(), videoData.getPayload().getTile_id(), videoData.getPayload().getTile_type(), videoData.getIs_chat_lock(), String.valueOf(position), SingleStudy.parentCourseId, this.examPrepItem.getList().get(position).getStart_date(), new ArrayList());
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
                    Helper.showStreamSelectionBottomSheet(this.activity, videoData, position, MakeMyExam.videoArrayList);
                    return;
                } else {
                    Helper.GoToLiveVideoActivity(videoData.getChat_node(), this.activity, videoData.getFile_url(), videoData.getVideo_type(), videoData.getId(), videoData.getTitle(), "0", videoData.getThumbnail_url(), videoData.getIs_chat_lock(), videoData.getPayload().getCourse_id(), String.valueOf(position), SingleStudy.parentCourseId, videoData.getPayload().getTile_id(), videoData.getPayload().getTile_type(), new ArrayList());
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
                            Helper.showStreamSelectionBottomSheet(this.activity, videoData, position, MakeMyExam.videoArrayList);
                            return;
                        } else {
                            Helper.GoToLiveVideoActivity(videoData.getChat_node(), this.activity, videoData.getFile_url(), videoData.getVideo_type(), videoData.getId(), videoData.getTitle(), "0", videoData.getThumbnail_url(), videoData.getIs_chat_lock(), videoData.getPayload().getCourse_id(), String.valueOf(position), SingleStudy.parentCourseId, videoData.getPayload().getTile_id(), videoData.getPayload().getTile_type(), new ArrayList());
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
                    Helper.GoToLiveAwsVideoActivity(videoData.getVideo_type(), videoData.getChat_node(), this.activity, videoData.getId(), videoData.getVideo_type(), videoData.getId(), videoData.getTitle(), "0", videoData.getThumbnail_url(), videoData.getPayload().getCourse_id(), videoData.getPayload().getTile_id(), videoData.getPayload().getTile_type(), videoData.getIs_chat_lock(), String.valueOf(position), SingleStudy.parentCourseId, this.examPrepItem.getList().get(position).getStart_date(), new ArrayList());
                    return;
                }
            }
            if (videoData.getIs_drm().equals("1")) {
                if (videoData.getId() == null || videoData.getId().equalsIgnoreCase("")) {
                    Activity activity8 = this.activity;
                    Toast.makeText(activity8, activity8.getResources().getString(R.string.url_is_not_found), 0).show();
                    return;
                } else {
                    Helper.GoToVideoCryptActivity(this.activity, videoData.getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), videoData.getVideo_type(), videoData.getChat_node(), videoData.getId(), videoData.getVideo_type(), videoData.getId(), videoData.getTitle(), "0", videoData.getThumbnail_url(), videoData.getPayload().getCourse_id(), videoData.getPayload().getTile_id(), videoData.getPayload().getTile_type(), videoData.getIs_chat_lock(), String.valueOf(position), SingleStudy.parentCourseId, videoData.getStart_date(), "0", new ArrayList());
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
                        Helper.GoToLiveAwsVideoActivity(videoData.getVideo_type(), videoData.getChat_node(), this.activity, videoData.getId(), videoData.getVideo_type(), videoData.getId(), videoData.getTitle(), "0", videoData.getThumbnail_url(), videoData.getPayload().getCourse_id(), videoData.getPayload().getTile_id(), videoData.getPayload().getTile_type(), videoData.getIs_chat_lock(), String.valueOf(position), SingleStudy.parentCourseId, videoData.getStart_date(), new ArrayList());
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
                        Helper.GoToVideoCryptActivity(this.activity, videoData.getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), videoData.getVideo_type(), videoData.getChat_node(), videoData.getId(), videoData.getVideo_type(), videoData.getId(), videoData.getTitle(), "0", videoData.getThumbnail_url(), videoData.getPayload().getCourse_id(), videoData.getPayload().getTile_id(), videoData.getPayload().getTile_type(), videoData.getIs_chat_lock(), String.valueOf(position), SingleStudy.parentCourseId, videoData.getStart_date(), "0", new ArrayList());
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
        backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter4$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$handleVisibilityNoData$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleVisibilityNoData$0(View view) {
        this.activity.finish();
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
