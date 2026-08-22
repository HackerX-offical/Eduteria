package com.appnew.android.Courses.Adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
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
import com.appnew.android.Courses.Adapter.SingleStudyAdapter3;
import com.appnew.android.Courses.Fragment.ExamPrepLayer2;
import com.appnew.android.Courses.Fragment.SingleStudy;
import com.appnew.android.Courses.overview.adapter.OverviewRVAdapter;
import com.appnew.android.Download.Audio.AudioPlayerService;
import com.appnew.android.Download.AudioPlayerActivty;
import com.appnew.android.Download.DownloadActivity;
import com.appnew.android.Download.DownloadVideoPlayer;
import com.appnew.android.DownloadServices.VideoDownloadService;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.JWextractor.JWPlayerExtractorCallBack;
import com.appnew.android.JWextractor.JWPlayerMediaExtractor;
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
import com.appnew.android.table.AudioTable;
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
import java.util.Iterator;
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
public class SingleStudyAdapter3 extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements NetworkCall.MyNetworkCallBack {
    Activity activity;
    onButtonClicked buttonClicked;
    public String contentType;
    ArrayList<Courselist> courseDataArrayList;
    ExamPrepItem examPrepItem;
    ArrayList<FaqData> faqData;
    private String first_attempt;
    boolean isCombo;
    String isSkip;
    String is_purchase;
    int lang;
    private String mainCourseId;
    OverviewData overviewData;
    String parentCourseId;
    int position_delete;
    private Progress progress;
    private String quiz_id;
    private String quiz_name;
    String revertAPI;
    CourseDetail singleStudy2;
    ThemeSettings themeSettings;
    String tileIdAPI;
    int tilePos;
    String tileTypeAPI;
    private String totalQuestion;
    public UtkashRoom utkashRoom;
    private Lists videodata;
    Boolean isLodded = true;
    private String result_date = "";
    private String submission_type = "";
    int downloadCount = 0;
    private boolean isSSCpattern = false;
    String[] langIds = {"1"};

    public interface onButtonClicked {
        void onTitleClicked(TilesItem cards, List<TilesItem> tiles, int tilePos);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    public SingleStudyAdapter3(Activity activity, CourseDetail singleStudy, ExamPrepItem examPrepItem, OverviewData overviewData, ArrayList<Courselist> courseDataArrayList, ArrayList<FaqData> faqData, onButtonClicked buttonClicked, String parentCourseId, boolean isCombo, String isSkip, int tilePos, String tileIdAPI, String tileTypeAPI, String revertAPI, String mainCourseId) {
        this.isCombo = false;
        this.tilePos = 0;
        this.is_purchase = "";
        this.mainCourseId = "";
        this.singleStudy2 = singleStudy;
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
        this.mainCourseId = mainCourseId;
        this.is_purchase = singleStudy.getData().getCourseDetail().getIsPurchased();
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        this.utkashRoom = appDatabase;
        this.themeSettings = appDatabase.getthemeSettingdao().data();
        this.progress = new Progress(activity);
    }

    public void sendlist(ExamPrepItem examPrepItem) {
        this.examPrepItem = examPrepItem;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewInflate;
        if (viewType == 0) {
            return new SingleStudyHeaderHolder(LayoutInflater.from(this.activity).inflate(R.layout.exam_prep_header, (ViewGroup) null));
        }
        if (viewType == 1) {
            if ("1".equalsIgnoreCase("5")) {
                viewInflate = LayoutInflater.from(this.activity).inflate(R.layout.exam_prep_single_row_item_theme5, (ViewGroup) null);
            } else {
                viewInflate = LayoutInflater.from(this.activity).inflate(R.layout.exam_prep_single_row_item, (ViewGroup) null);
            }
            return new SingleStudyListHolder(viewInflate);
        }
        if (viewType == 7) {
            return new SingleStudyPdfListHolder(LayoutInflater.from(this.activity).inflate(R.layout.exam_prep_single_row_item_pdf_theme5, (ViewGroup) null));
        }
        if (viewType == 8) {
            return new SingleStudyConceptListHolder(LayoutInflater.from(this.activity).inflate(R.layout.exam_prep_single_row_item_concept_theme5, (ViewGroup) null));
        }
        if (viewType == 4) {
            return new SingleStudyTestListHolder(LayoutInflater.from(this.activity).inflate(R.layout.exam_prep_single_row_item_test, (ViewGroup) null));
        }
        if (viewType == 10) {
            return new SingleStudySubjectiveTestListHolder(LayoutInflater.from(this.activity).inflate(R.layout.exam_prep_single_row_item_subjective, (ViewGroup) null));
        }
        if (viewType == 3) {
            return new OverViewHolder(LayoutInflater.from(this.activity).inflate(R.layout.course_overview_layout, (ViewGroup) null));
        }
        if (viewType == 6) {
            return new FAQViewHolder(LayoutInflater.from(this.activity).inflate(R.layout.faq_overview_layout, (ViewGroup) null));
        }
        if (viewType == 5) {
            return new SingleStudyComboHolder(LayoutInflater.from(this.activity).inflate(R.layout.item_combo_tile_main, parent, false));
        }
        if (viewType == 9) {
            return new StudyNoDataViewHolder(LayoutInflater.from(this.activity).inflate(R.layout.no_data_found, (ViewGroup) null));
        }
        return new StudyNoDataViewHolder(LayoutInflater.from(this.activity).inflate(R.layout.no_data_found, (ViewGroup) null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == 0) {
            ((SingleStudyHeaderHolder) holder).setDataHeader(this.singleStudy2);
            return;
        }
        if (getItemViewType(position) == 3) {
            ((OverViewHolder) holder).setData(this.singleStudy2.getData().getCourseDetail(), this.overviewData);
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
        if (getItemViewType(position) == 10) {
            ((SingleStudySubjectiveTestListHolder) holder).setData(this.examPrepItem.getList(), position);
            return;
        }
        if (getItemViewType(position) == 5) {
            ((SingleStudyComboHolder) holder).setData(position);
        } else if (getItemViewType(position) == 6) {
            ((FAQViewHolder) holder).setData(this.faqData);
        } else if (getItemViewType(position) == 9) {
            ((StudyNoDataViewHolder) holder).setData();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
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
        if (this.contentType.equalsIgnoreCase(Const.SUBJECTIVE_TEST + this.tileIdAPI) || this.contentType.equalsIgnoreCase(Const.Daily_assignment + this.tileIdAPI)) {
            return 10;
        }
        return this.contentType.equalsIgnoreCase(Const.NO_DATA) ? 9 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.contentType.equalsIgnoreCase(Const.BOOK + this.tileIdAPI) || this.contentType.equalsIgnoreCase(Const.OVERVIEW + this.tileIdAPI) || this.contentType.equalsIgnoreCase(Const.COMBO + this.tileIdAPI) || this.contentType.equalsIgnoreCase(Const.FAQ + this.tileIdAPI) || this.examPrepItem.getList() == null || this.examPrepItem.getList().size() <= 0) {
            return 1;
        }
        return this.examPrepItem.getList().size();
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        switch (apitype) {
            case "https://appapi.videocrypt.in/index.php/data_model/test/get_instructions":
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setTest_id(this.quiz_id);
                encryptionData.setCourse_id(this.singleStudy2.getData().getCourseDetail().getId());
                return service.API_GET_TEST_INSTRUCTION_DATA(AES.encrypt(new Gson().toJson(encryptionData)));
            case "https://appapi.videocrypt.in/index.php/data_model/revision/delete_revision":
                EncryptionData encryptionData2 = new EncryptionData();
                encryptionData2.setRevision_id(this.videodata.getId());
                encryptionData2.setCourse_id(this.singleStudy2.getData().getCourseDetail().getId());
                return service.delete_revision(AES.encrypt(new Gson().toJson(encryptionData2)));
            case "https://appapi.videocrypt.in/index.php/data_model/test/get_test_data":
                EncryptionData encryptionData3 = new EncryptionData();
                encryptionData3.setTest_id(this.quiz_id);
                encryptionData3.setCourse_id(this.singleStudy2.getData().getCourseDetail().getId());
                return service.API_GET_INFO_TEST_SERIES(AES.encrypt(new Gson().toJson(encryptionData3)));
            default:
                return null;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0273 A[Catch: Exception -> 0x029a, TryCatch #0 {Exception -> 0x029a, blocks: (B:23:0x005f, B:25:0x006f, B:27:0x0072, B:29:0x0076, B:31:0x0080, B:42:0x00c0, B:44:0x00c5, B:46:0x00cf, B:51:0x00e1, B:53:0x00eb, B:60:0x0101, B:62:0x010d, B:65:0x012f, B:67:0x013d, B:69:0x0144, B:71:0x0148, B:73:0x015f, B:75:0x0170, B:77:0x0181, B:95:0x0288, B:76:0x017f, B:72:0x0154, B:79:0x01c6, B:81:0x01d0, B:83:0x01de, B:85:0x01e5, B:87:0x01f8, B:89:0x020f, B:91:0x0220, B:93:0x0231, B:92:0x022f, B:88:0x0204, B:94:0x0273, B:33:0x008e, B:36:0x009c, B:38:0x00a6, B:40:0x00b4, B:96:0x028d), top: B:130:0x005f }] */
    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void SuccessCallBack(org.json.JSONObject r19, java.lang.String r20, java.lang.String r21, boolean r22) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 906
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Courses.Adapter.SingleStudyAdapter3.SuccessCallBack(org.json.JSONObject, java.lang.String, java.lang.String, boolean):void");
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
        CourseDetail courseDetail = this.singleStudy2;
        return ((courseDetail == null || courseDetail.getData() == null || this.singleStudy2.getData().getCourseDetail() == null || TextUtils.isEmpty(this.singleStudy2.getData().getCourseDetail().getIsPurchased()) || !this.singleStudy2.getData().getCourseDetail().getIsPurchased().equals("1")) && (lists = this.videodata) != null && !TextUtils.isEmpty(lists.getIs_locked()) && this.videodata.getIs_locked().equals("1")) ? "Paid" : "Free";
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
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SingleStudyAdapter3 singleStudyAdapter3 = SingleStudyAdapter3.this;
                    TextView textView9 = textView5;
                    TestBasicInst testBasicInst = testBasic;
                    TextView textView10 = textView8;
                    singleStudyAdapter3.showPopMenuForLangauge(textView9, testBasicInst, textView10, textView10);
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
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (testBasic.getTotalQuestions().equalsIgnoreCase("0")) {
                    Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.please_add_question), 0).show();
                    return;
                }
                if (checkBox3.isChecked()) {
                    dialog3.dismiss();
                    SingleStudyAdapter3.this.quiz_id = testBasic.getId();
                    SingleStudyAdapter3 singleStudyAdapter3 = SingleStudyAdapter3.this;
                    new NetworkCall(singleStudyAdapter3, singleStudyAdapter3.activity).NetworkAPICall(API.API_GET_INFO_TEST_SERIES, "", true, false);
                    return;
                }
                Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.please_check_following_instructions), 0).show();
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
                this.parentLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3.FaqListRecyclerAdapter.FaqListHolder.1
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
                this.recyclerView.setLayoutManager(new LinearLayoutManager(SingleStudyAdapter3.this.activity, 1, false));
                this.recyclerView.setAdapter(SingleStudyAdapter3.this.new FaqListRecyclerAdapter(faqData, 0));
                this.recyclerView.setNestedScrollingEnabled(false);
                return;
            }
            this.no_data_found_RL.setVisibility(0);
            this.recyclerView.setVisibility(8);
            this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3.FAQViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    SingleStudyAdapter3.this.activity.finish();
                }
            });
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
                if (SingleStudyAdapter3.this.isLodded.booleanValue()) {
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
                    OverviewRVAdapter overviewRVAdapter = new OverviewRVAdapter(SingleStudyAdapter3.this.activity, basic, overview, this.recyclerView, z, z2);
                    this.recyclerView.setLayoutManager(new LinearLayoutManager(SingleStudyAdapter3.this.activity, 1, false));
                    this.recyclerView.setAdapter(overviewRVAdapter);
                    SingleStudyAdapter3.this.isLodded = false;
                    return;
                }
                return;
            }
            this.recyclerView.setVisibility(8);
            this.no_data_found_RL.setVisibility(0);
            this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3.OverViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    SingleStudyAdapter3.this.activity.finish();
                }
            });
        }
    }

    public class SingleStudyHeaderHolder extends RecyclerView.ViewHolder {
        TextView authorname;
        TextView course_name;
        ImageView coursebg;
        TextView courseid;
        RelativeLayout headerLL;
        LinearLayout imageRL;
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
        }

        public void setDataHeader(CourseDetail singleStudy) {
            if (singleStudy.getData().getCourseDetail().getIsPurchased().equalsIgnoreCase("1")) {
                this.headerLL.setBackgroundColor(SingleStudyAdapter3.this.activity.getResources().getColor(R.color.white));
                this.imageRL.setVisibility(8);
            } else {
                this.headerLL.setBackgroundColor(SingleStudyAdapter3.this.activity.getResources().getColor(R.color.colorPrimaryDark));
                this.imageRL.setVisibility(0);
                if (!TextUtils.isEmpty(singleStudy.getData().getCourseDetail().getDescHeaderImage())) {
                    Helper.setThumbnailImage(SingleStudyAdapter3.this.activity, singleStudy.getData().getCourseDetail().getDescHeaderImage(), SingleStudyAdapter3.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.coursebg);
                } else {
                    this.coursebg.setImageResource(R.mipmap.square_placeholder);
                }
                if (singleStudy.getData().getCourseDetail() != null) {
                    this.course_name.setText(singleStudy.getData().getCourseDetail().getTitle());
                    if (!GenericUtils.isEmpty(singleStudy.getData().getCourseDetail().getAuthor().getTitle()) && !singleStudy.getData().getCourseDetail().getAuthor().getTitle().equalsIgnoreCase("Utkarsh classes")) {
                        this.authorname.setText(SingleStudyAdapter3.this.activity.getResources().getString(R.string.by) + singleStudy.getData().getCourseDetail().getAuthor().getTitle());
                    } else {
                        this.authorname.setText(SingleStudyAdapter3.this.activity.getResources().getString(R.string.by) + SingleStudyAdapter3.this.activity.getResources().getString(R.string.app_name));
                    }
                    this.validityTV.setText(SingleStudyAdapter3.this.activity.getResources().getString(R.string.validity_) + singleStudy.getData().getCourseDetail().getValidity());
                    this.courseid.setText(singleStudy.getData().getCourseDetail().getId());
                    if (singleStudy.getData().getCourseDetail().getViewType().equalsIgnoreCase("0")) {
                        this.type.setText(SingleStudyAdapter3.this.activity.getResources().getString(R.string.online));
                    } else if (singleStudy.getData().getCourseDetail().getViewType().equalsIgnoreCase("1")) {
                        this.type.setText(SingleStudyAdapter3.this.activity.getResources().getString(R.string.offline));
                    } else if (singleStudy.getData().getCourseDetail().getViewType().equalsIgnoreCase("2")) {
                        this.type.setText(SingleStudyAdapter3.this.activity.getResources().getString(R.string.package_));
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            if (singleStudy.getData().getCourseDetail().getIsPurchased().equalsIgnoreCase("1")) {
                for (TilesItem tilesItem : singleStudy.getData().getTiles()) {
                    if (tilesItem.getType().equalsIgnoreCase(Const.OVERVIEW) || tilesItem.getType().equalsIgnoreCase(Const.FAQ) || tilesItem.getType().equalsIgnoreCase("content") || tilesItem.getType().equalsIgnoreCase(Const.COMBO)) {
                        arrayList.add(tilesItem);
                    }
                }
            } else {
                Iterator<TilesItem> it = singleStudy.getData().getTiles().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
            }
            TileItemsAdapter tileItemsAdapter = new TileItemsAdapter(SingleStudyAdapter3.this.activity, arrayList);
            this.tileRv.setLayoutManager(new LinearLayoutManager(SingleStudyAdapter3.this.activity, 0, false));
            this.tileRv.setAdapter(tileItemsAdapter);
            this.tileRv.setNestedScrollingEnabled(false);
            this.tileRv.scrollToPosition(SingleStudyAdapter3.this.tilePos);
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
                        Glide.with(SingleStudyAdapter3.this.activity).asGif().load(Integer.valueOf(R.mipmap.live)).into(holder.liveIv);
                    } catch (Exception unused) {
                        holder.liveIv.setVisibility(8);
                    }
                    holder.tilesText.setPadding(Math.round(Helper.convertDpToPixel(4, this.context)), Math.round(Helper.convertDpToPixel(8, this.context)), Math.round(Helper.convertDpToPixel(4, this.context)), Math.round(Helper.convertDpToPixel(8, this.context)));
                } else {
                    holder.liveIv.setVisibility(8);
                    holder.tilesText.setPadding(Math.round(Helper.convertDpToPixel(16, this.context)), Math.round(Helper.convertDpToPixel(8, this.context)), Math.round(Helper.convertDpToPixel(16, this.context)), Math.round(Helper.convertDpToPixel(8, this.context)));
                }
                holder.tilesText.setText(tilesItem.getTileName());
                if (SingleStudyAdapter3.this.contentType.equals(tilesItem.getType() + tilesItem.getId())) {
                    holder.tilesText.setTextColor(this.context.getResources().getColor(R.color.colorPrimary));
                    holder.bg_bottom.setVisibility(0);
                } else {
                    holder.tilesText.setTextColor(this.context.getResources().getColor(R.color.black));
                    holder.bg_bottom.setVisibility(8);
                    holder.tilesText.setTextColor(this.context.getResources().getColor(R.color.country_code_text_color));
                }
                holder.parent.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3.SingleStudyHeaderHolder.TileItemsAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        if (!tilesItem.getType().equalsIgnoreCase(Const.FOLDER)) {
                            SingleStudyAdapter3.this.contentType = tilesItem.getType() + tilesItem.getId();
                        }
                        SingleStudyAdapter3.this.tilePos = position;
                        SingleStudyAdapter3.this.buttonClicked.onTitleClicked(tilesItem, SingleStudyAdapter3.this.singleStudy2.getData().getTiles(), SingleStudyAdapter3.this.tilePos);
                    }
                });
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
            this.comboRV.setLayoutManager(new LinearLayoutManager(SingleStudyAdapter3.this.activity));
            this.comboRV.setHasFixedSize(true);
            this.comboRV.setNestedScrollingEnabled(false);
            this.networkCall = new NetworkCall(this, SingleStudyAdapter3.this.activity);
            if (SingleStudyAdapter3.this.singleStudy2 != null && SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail() != null && !TextUtils.isEmpty(SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getIsPurchased())) {
                this.isPurchased = SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getIsPurchased();
            }
            hit_api_for_data(true);
            this.view_all.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyComboHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setData$0(view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$0(View view) {
            Intent intent = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) ComboListActivity.class);
            intent.putExtra("title", SingleStudyAdapter3.this.singleStudy2.getData().getTiles().get(SingleStudyAdapter3.this.tilePos) != null ? SingleStudyAdapter3.this.singleStudy2.getData().getTiles().get(SingleStudyAdapter3.this.tilePos).getTileName() : "Combo Course");
            intent.putExtra(Const.SINGLE_STUDY_DATA, SingleStudyAdapter3.this.singleStudy2);
            Helper.gotoActivity(intent, SingleStudyAdapter3.this.activity);
        }

        private void hit_api_for_data(boolean showProgress) {
            this.networkCall.NetworkAPICall(API.get_combo_course_list, "", showProgress, false);
        }

        @Override // com.appnew.android.Courses.Adapter.ComboListAdapter.onButtonClicked
        public void onCourseClicked(int pos) {
            if (this.courseDataArrayList.get(pos).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter3.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter3.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter3.this.singleStudy2);
                intent.putExtra(Const.IS_BOOK, SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, SingleStudyAdapter3.this.activity);
                return;
            }
            if (TextUtils.isEmpty(this.courseDataArrayList.get(pos).getMaintenanceText())) {
                Intent intent2 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) CourseActivity.class);
                intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                intent2.putExtra(Const.COURSE_ID_MAIN, this.courseDataArrayList.get(pos).getId());
                intent2.putExtra(Const.COURSE_PARENT_ID, SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId());
                intent2.putExtra(Const.CONTENT_TYPE_1, this.courseDataArrayList.get(pos).getContent_type());
                intent2.putExtra(Const.IS_COMBO, true);
                intent2.putExtra("valid_to", SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getValid_to());
                intent2.putExtra(AnalyticsConstants.course_name, this.courseDataArrayList.get(pos).getTitle());
                Helper.gotoActivity(intent2, SingleStudyAdapter3.this.activity);
                return;
            }
            Helper.getCourseMaintanaceDialog(SingleStudyAdapter3.this.activity, "", this.courseDataArrayList.get(pos).getMaintenanceText());
        }

        @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
        public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
            apitype.hashCode();
            if (!apitype.equals(API.get_combo_course_list)) {
                return null;
            }
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setCourse_id(SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId());
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
                                ComboListAdapter comboListAdapter = new ComboListAdapter(SingleStudyAdapter3.this.activity, this.courseDataArrayList, this.isPurchased, this);
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
                        Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.data_not_found), 0).show();
                        return;
                    }
                    this.isPaginationAvailable = false;
                    this.no_data_found_RL.setVisibility(0);
                    this.comboRV.setVisibility(8);
                    if (!jsonstring.has("auth_code") || GenericUtils.isEmpty(jsonstring.getString("auth_code"))) {
                        return;
                    }
                    RetrofitResponse.GetApiData(SingleStudyAdapter3.this.activity, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCourseSoldOut() {
        try {
            CourseDetail courseDetail = this.singleStudy2;
            if (courseDetail == null || courseDetail.getData().getCourseDetail() == null || this.singleStudy2.getData().getCourseDetail().getExtra_json() == null || this.singleStudy2.getData().getCourseDetail().getExtra_json().getSold_out() == null) {
                return false;
            }
            return this.singleStudy2.getData().getCourseDetail().getExtra_json().getSold_out().equalsIgnoreCase("1");
        } catch (Exception unused) {
            return false;
        }
    }

    public class SingleStudyTestListHolder extends RecyclerView.ViewHolder {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        LinearLayout attemptLL;
        Button backBtn;
        ImageView forwardIV;
        CardView ibt_single_sub_vd_RL;
        ImageView imageIcon;
        TextView learn;
        LeftMenu leftMenu;
        RelativeLayout lockRL;
        RelativeLayout no_data_found_RL;
        RelativeLayout parentLL;
        TextView practice;
        ImageView share;
        TextView startdate;
        RelativeLayout studyitemLL;
        TextView subItemRV;
        TextView titleCategory;
        TextView view_result;

        public SingleStudyTestListHolder(View itemView) {
            super(itemView);
            this.lockRL = (RelativeLayout) itemView.findViewById(R.id.lockRL);
            this.parentLL = (RelativeLayout) itemView.findViewById(R.id.parentLL);
            this.studyitemLL = (RelativeLayout) itemView.findViewById(R.id.study_single_itemLL);
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
            this.forwardIV = (ImageView) itemView.findViewById(R.id.forwardIV);
            this.view_result = (TextView) itemView.findViewById(R.id.view_result);
        }

        public void setData(final ArrayList<Lists> list, final int position) {
            long j;
            this.leftMenu = (LeftMenu) new Gson().fromJson(SingleStudyAdapter3.this.themeSettings.getLeft_menu(), LeftMenu.class);
            if (list != null && list.size() > 0) {
                this.ibt_single_sub_vd_RL.setVisibility(0);
                this.no_data_found_RL.setVisibility(8);
                if (TextUtils.isEmpty(list.get(position).getIs_locked())) {
                    list.get(position).setIs_locked("0");
                }
                if (SingleStudyAdapter3.this.singleStudy2 != null && SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail() != null && SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getIsPurchased().equals("1")) {
                    list.get(position).setIs_locked("0");
                }
                if (SingleStudyAdapter3.this.isSkip.equalsIgnoreCase("3")) {
                    this.share.setVisibility(0);
                    this.forwardIV.setVisibility(8);
                    this.titleCategory.setText(list.get(position).getTest_series_name());
                    if (Helper.isLiveTest(list.get(position).getTest_series_type()) && !list.get(position).getEnd_date().equalsIgnoreCase("0") && !list.get(position).getEnd_date().equalsIgnoreCase("")) {
                        this.subItemRV.setVisibility(0);
                        j = 1000;
                        new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.US).format(new Date(Long.parseLong(list.get(position).getStart_date()) * 1000));
                        this.subItemRV.setText(SingleStudyAdapter3.this.activity.getResources().getString(R.string.test_end) + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.US).format(new Date(Long.parseLong(list.get(position).getEnd_date()) * 1000))));
                    } else {
                        j = 1000;
                        this.subItemRV.setVisibility(8);
                    }
                    if (Helper.isLiveTest(list.get(position).getTest_series_type()) && !list.get(position).getStart_date().equalsIgnoreCase("0") && !list.get(position).getStart_date().equalsIgnoreCase("")) {
                        this.startdate.setVisibility(0);
                        this.startdate.setText(SingleStudyAdapter3.this.activity.getResources().getString(R.string.test_start) + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(list.get(position).getStart_date()) * j))));
                    } else {
                        this.startdate.setVisibility(8);
                    }
                    this.attemptLL.setVisibility(0);
                    if (list.get(position).getState().equals("1")) {
                        SingleStudyAdapter3.this.utkashRoom.getTestDao().delete_test_data(MakeMyExam.userId, list.get(position).getId());
                        if (MakeMyExam.time_server >= Long.parseLong(list.get(position).getEnd_date()) * j) {
                            this.view_result.setVisibility(0);
                            if (list.get(position).getResult_date().equalsIgnoreCase("0") || list.get(position).getResult_date().equalsIgnoreCase("1") || list.get(position).getResult_date().equalsIgnoreCase("")) {
                                this.attemptLL.setVisibility(8);
                                handleLearnPractice(list.get(position));
                            } else if (System.currentTimeMillis() > Long.parseLong(list.get(position).getResult_date()) * j) {
                                if (Long.parseLong(list.get(position).getEnd_date()) * j > MakeMyExam.time_server) {
                                    this.attemptLL.setVisibility(8);
                                } else {
                                    this.attemptLL.getChildAt(0).setVisibility(0);
                                    if (list.get(position).getState().equalsIgnoreCase("1")) {
                                        ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter3.this.activity.getResources().getString(R.string.view_result1));
                                    } else {
                                        ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter3.this.activity.getResources().getString(R.string.view_rank));
                                    }
                                }
                                this.view_result.setVisibility(8);
                                handleLearnPractice(list.get(position));
                            } else {
                                this.attemptLL.setVisibility(0);
                                ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter3.this.activity.getResources().getString(R.string.attempted_));
                                handleLearnPractice(list.get(position));
                            }
                        } else if (!list.get(position).getIs_reattempt().equalsIgnoreCase("0")) {
                            this.learn.setVisibility(8);
                            this.practice.setVisibility(8);
                            this.attemptLL.setVisibility(0);
                            ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter3.this.activity.getResources().getString(R.string.re_aTTEMPT));
                        } else if (list.get(position).getResult_date() == null || list.get(position).getResult_date().equalsIgnoreCase("1") || list.get(position).getResult_date().equalsIgnoreCase("0") || list.get(position).getResult_date().equalsIgnoreCase("")) {
                            this.learn.setVisibility(8);
                            this.practice.setVisibility(8);
                            this.attemptLL.getChildAt(0).setVisibility(0);
                            ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter3.this.activity.getResources().getString(R.string.view_rank));
                        } else {
                            this.learn.setVisibility(8);
                            this.practice.setVisibility(8);
                            this.attemptLL.getChildAt(0).setVisibility(0);
                            ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter3.this.activity.getResources().getString(R.string.attempted));
                        }
                    } else if (System.currentTimeMillis() >= Long.parseLong(list.get(position).getEnd_date()) * j) {
                        if (list.get(position).getResult_date().equalsIgnoreCase("0") || list.get(position).getResult_date().equalsIgnoreCase("1") || list.get(position).getResult_date().equalsIgnoreCase("")) {
                            this.attemptLL.setVisibility(8);
                            handleLearnPractice(list.get(position));
                        }
                        if (Long.parseLong(list.get(position).getResult_date()) * j <= System.currentTimeMillis() && System.currentTimeMillis() > Long.parseLong(list.get(position).getResult_date()) * j) {
                            if (Long.parseLong(list.get(position).getEnd_date()) < 1640066737) {
                                this.attemptLL.setVisibility(8);
                            } else {
                                this.attemptLL.getChildAt(0).setVisibility(0);
                                ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter3.this.activity.getResources().getString(R.string.view_rank));
                            }
                            handleLearnPractice(list.get(position));
                        } else {
                            this.attemptLL.setVisibility(8);
                            handleLearnPractice(list.get(position));
                        }
                    } else if (System.currentTimeMillis() < Long.parseLong(list.get(position).getStart_date()) * j) {
                        this.attemptLL.getChildAt(0).setVisibility(0);
                        ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter3.this.activity.getResources().getString(R.string.test_is_upcoming));
                        this.learn.setVisibility(8);
                        this.practice.setVisibility(8);
                    } else {
                        TestTable testTableTest_data = SingleStudyAdapter3.this.utkashRoom.getTestDao().test_data(list.get(position).getId(), MakeMyExam.userId);
                        if (testTableTest_data != null && testTableTest_data.getStatus() != null && !testTableTest_data.getStatus().equalsIgnoreCase("")) {
                            this.attemptLL.getChildAt(0).setVisibility(0);
                            ((TextView) this.attemptLL.getChildAt(0)).setText(testTableTest_data.getStatus());
                            this.learn.setVisibility(8);
                            this.practice.setVisibility(8);
                        } else {
                            this.attemptLL.getChildAt(0).setVisibility(0);
                        }
                        ((TextView) this.attemptLL.getChildAt(0)).setText(SingleStudyAdapter3.this.activity.getResources().getString(R.string.attempt_now));
                        this.learn.setVisibility(8);
                        this.practice.setVisibility(8);
                    }
                    if (!TextUtils.isEmpty(list.get(position).getImage())) {
                        Helper.setThumbnailImage(SingleStudyAdapter3.this.activity, list.get(position).getImage(), SingleStudyAdapter3.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.imageIcon);
                    } else {
                        this.imageIcon.setImageResource(R.mipmap.square_placeholder);
                    }
                } else {
                    this.share.setVisibility(8);
                    this.subItemRV.setVisibility(0);
                    this.attemptLL.setVisibility(8);
                    this.learn.setVisibility(8);
                    this.practice.setVisibility(8);
                    if (!TextUtils.isEmpty(list.get(position).getImage_icon())) {
                        Helper.setThumbnailImage(SingleStudyAdapter3.this.activity, list.get(position).getImage_icon(), SingleStudyAdapter3.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.imageIcon);
                    } else {
                        this.imageIcon.setImageResource(R.mipmap.square_placeholder);
                    }
                    this.subItemRV.setVisibility(8);
                    this.subItemRV.setText(SingleStudyAdapter3.this.activity.getResources().getString(R.string.total_) + list.get(position).getCount());
                    this.titleCategory.setText(list.get(position).getTitle());
                }
                if (list.get(position).getIs_locked().equals("0")) {
                    this.lockRL.setVisibility(8);
                } else {
                    this.lockRL.setVisibility(0);
                    this.learn.setVisibility(8);
                    this.practice.setVisibility(8);
                    this.attemptLL.setVisibility(8);
                    this.subItemRV.setVisibility(8);
                }
                if (SingleStudyAdapter3.this.isSkip.equalsIgnoreCase("3")) {
                    this.studyitemLL.setEnabled(false);
                    this.practice.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyTestListHolder$$ExternalSyntheticLambda3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$setData$4(list, position, view);
                        }
                    });
                    this.learn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyTestListHolder$$ExternalSyntheticLambda4
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$setData$5(list, position, view);
                        }
                    });
                    this.attemptLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyTestListHolder$$ExternalSyntheticLambda5
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$setData$14(list, position, view);
                        }
                    });
                    this.share.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyTestListHolder$$ExternalSyntheticLambda6
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$setData$15(position, view);
                        }
                    });
                    this.studyitemLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyTestListHolder$$ExternalSyntheticLambda7
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$setData$24(list, position, view);
                        }
                    });
                } else {
                    this.studyitemLL.setEnabled(true);
                    this.studyitemLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3.SingleStudyTestListHolder.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            String str;
                            Object obj;
                            String str2;
                            String str3;
                            String str4;
                            if (((Lists) list.get(position)).getIs_locked().equalsIgnoreCase("1")) {
                                if (SingleStudyAdapter3.this.isCourseSoldOut()) {
                                    Toast.makeText(SingleStudyAdapter3.this.activity, R.string.sold_out_msg, 0).show();
                                    return;
                                }
                                Intent intent = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) PurchaseActivity.class);
                                intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter3.this.singleStudy2);
                                Helper.gotoActivity(intent, SingleStudyAdapter3.this.activity);
                                return;
                            }
                            if (SingleStudyAdapter3.this.isSkip.equalsIgnoreCase("1")) {
                                str = "0";
                                obj = "content";
                                str2 = "title";
                                str3 = "tile_id";
                                str4 = Const.TILE_TYPE;
                            } else {
                                str4 = Const.TILE_TYPE;
                                if (!SingleStudyAdapter3.this.isSkip.equalsIgnoreCase("2")) {
                                    if (SingleStudyAdapter3.this.isSkip.equalsIgnoreCase("3")) {
                                        return;
                                    }
                                    ExamPrepItem examPrepItem = new ExamPrepItem();
                                    examPrepItem.setList(SingleStudyAdapter3.this.examPrepItem.getList().get(position).getList());
                                    Intent intent2 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) CourseActivity.class);
                                    SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(SingleStudyAdapter3.this.singleStudy2 != null ? SingleStudyAdapter3.this.singleStudy2 : new CourseDetail()));
                                    SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(examPrepItem));
                                    SharedPreference.getInstance().putString("list", new Gson().toJson(list.get(position) != null ? list.get(position) : new Lists()));
                                    intent2.putExtra(Const.FRAG_TYPE, Const.EXAMPREP);
                                    intent2.putExtra(Const.IS_COMBO, SingleStudyAdapter3.this.isCombo);
                                    intent2.putExtra("content_type", SingleStudyAdapter3.this.contentType);
                                    if (SingleStudyAdapter3.this.mainCourseId.equals("455") || SingleStudyAdapter3.this.tileTypeAPI.equals(Const.COMBO) || SingleStudyAdapter3.this.tileTypeAPI.equals("content")) {
                                        intent2.putExtra(Const.TAB_TILE_VISIBILITY, "1");
                                    } else {
                                        intent2.putExtra(Const.TAB_TILE_VISIBILITY, "0");
                                    }
                                    intent2.putExtra("title", SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail() != null ? SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getTitle() : "Course");
                                    intent2.putExtra("tile_id", SingleStudyAdapter3.this.tileIdAPI);
                                    intent2.putExtra(str4, SingleStudyAdapter3.this.tileTypeAPI);
                                    intent2.putExtra(Const.REVERT_API, SingleStudyAdapter3.this.revertAPI);
                                    Helper.gotoActivity(intent2, SingleStudyAdapter3.this.activity);
                                    return;
                                }
                                str = "0";
                                obj = "content";
                                str2 = "title";
                                str3 = "tile_id";
                            }
                            String str5 = str3;
                            String str6 = str;
                            Intent intent3 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) CourseActivity.class);
                            Object obj2 = obj;
                            SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(SingleStudyAdapter3.this.singleStudy2 != null ? SingleStudyAdapter3.this.singleStudy2 : new CourseDetail()));
                            SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(SingleStudyAdapter3.this.examPrepItem != null ? SingleStudyAdapter3.this.examPrepItem : new ExamPrepItem()));
                            SharedPreference.getInstance().putString("list", new Gson().toJson(SingleStudyAdapter3.this.examPrepItem.getList().get(position) != null ? SingleStudyAdapter3.this.examPrepItem.getList().get(position) : new Lists()));
                            intent3.putExtra(Const.FRAG_TYPE, Const.EXAMPREPLAST);
                            intent3.putExtra(Const.IS_COMBO, SingleStudyAdapter3.this.isCombo);
                            intent3.putExtra(str2, SingleStudyAdapter3.this.examPrepItem.getList().get(position).getTitle());
                            intent3.putExtra("content_type", SingleStudyAdapter3.this.contentType);
                            if (SingleStudyAdapter3.this.mainCourseId.equals("455") || SingleStudyAdapter3.this.tileTypeAPI.equals(Const.COMBO) || SingleStudyAdapter3.this.tileTypeAPI.equals(obj2)) {
                                intent3.putExtra(Const.TAB_TILE_VISIBILITY, "1");
                            } else {
                                intent3.putExtra(Const.TAB_TILE_VISIBILITY, str6);
                            }
                            intent3.putExtra(Const.TEST_TYPE, SingleStudyAdapter3.this.examPrepItem.getList().get(position).getCount());
                            intent3.putExtra(str5, SingleStudyAdapter3.this.tileIdAPI);
                            intent3.putExtra(str4, SingleStudyAdapter3.this.tileTypeAPI);
                            intent3.putExtra(Const.LIST_SUBJECT, SingleStudyAdapter3.this.examPrepItem.getList().get(position));
                            intent3.putExtra(Const.REVERT_API, SingleStudyAdapter3.this.revertAPI);
                            Helper.gotoActivity(intent3, SingleStudyAdapter3.this.activity);
                        }
                    });
                }
            } else {
                this.ibt_single_sub_vd_RL.setVisibility(8);
                this.no_data_found_RL.setVisibility(0);
                this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3.SingleStudyTestListHolder.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        SingleStudyAdapter3.this.activity.finish();
                    }
                });
            }
            if (Helper.isShowShareButton(this.leftMenu)) {
                this.share.setVisibility(0);
            } else {
                this.share.setVisibility(8);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$4(ArrayList arrayList, int i, View view) {
            if (!Helper.isConnected(SingleStudyAdapter3.this.activity)) {
                Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                return;
            }
            if (SingleStudyAdapter3.this.is_purchase.equalsIgnoreCase("1")) {
                SharedPreference.getInstance().putString("id", SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId());
                SingleStudyAdapter3.this.quiz_id = ((Lists) arrayList.get(i)).getId();
                SingleStudyAdapter3.this.quiz_name = ((Lists) arrayList.get(i)).getTest_series_name();
                SingleStudyAdapter3.this.totalQuestion = ((Lists) arrayList.get(i)).getTotal_questions();
                SingleStudyAdapter3.this.result_date = ((Lists) arrayList.get(i)).getResult_date();
                SingleStudyAdapter3.this.submission_type = ((Lists) arrayList.get(i)).getSubmission_type();
                SingleStudyAdapter3.this.first_attempt = "0";
                SingleStudyAdapter3.this.videodata = (Lists) arrayList.get(i);
                Helper.resolveTestPattern(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.videodata.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyTestListHolder$$ExternalSyntheticLambda23
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setData$0();
                    }
                }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyTestListHolder$$ExternalSyntheticLambda24
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setData$1();
                    }
                });
                return;
            }
            if (((Lists) arrayList.get(i)).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter3.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter3.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter3.this.singleStudy2);
                Helper.gotoActivity(intent, SingleStudyAdapter3.this.activity);
                return;
            }
            SharedPreference.getInstance().putString("id", SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId());
            SingleStudyAdapter3.this.quiz_id = ((Lists) arrayList.get(i)).getId();
            SingleStudyAdapter3.this.quiz_name = ((Lists) arrayList.get(i)).getTest_series_name();
            SingleStudyAdapter3.this.totalQuestion = ((Lists) arrayList.get(i)).getTotal_questions();
            SingleStudyAdapter3.this.first_attempt = "0";
            SingleStudyAdapter3.this.result_date = ((Lists) arrayList.get(i)).getResult_date();
            SingleStudyAdapter3.this.videodata = (Lists) arrayList.get(i);
            SingleStudyAdapter3.this.submission_type = ((Lists) arrayList.get(i)).getSubmission_type();
            Helper.resolveTestPattern(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.videodata.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyTestListHolder$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setData$2();
                }
            }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyTestListHolder$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setData$3();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$0() {
            SingleStudyAdapter3.this.isSSCpattern = false;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$1() {
            SingleStudyAdapter3.this.isSSCpattern = true;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$2() {
            SingleStudyAdapter3.this.isSSCpattern = false;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$3() {
            SingleStudyAdapter3.this.isSSCpattern = true;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$5(ArrayList arrayList, int i, View view) {
            if (!Helper.isConnected(SingleStudyAdapter3.this.activity)) {
                Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                return;
            }
            if (SingleStudyAdapter3.this.is_purchase.equalsIgnoreCase("1")) {
                SharedPreference.getInstance().putString("id", SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId());
                if (((Lists) arrayList.get(i)).getState().equalsIgnoreCase("1")) {
                    SingleStudyAdapter3.this.quiz_id = ((Lists) arrayList.get(i)).getId();
                    SingleStudyAdapter3.this.quiz_name = ((Lists) arrayList.get(i)).getTest_series_name();
                    SingleStudyAdapter3.this.totalQuestion = ((Lists) arrayList.get(i)).getTotal_questions();
                    result_without_submit(SingleStudyAdapter3.this.quiz_id, SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId(), "1", SingleStudyAdapter3.this.quiz_name);
                    return;
                }
                SingleStudyAdapter3.this.quiz_id = ((Lists) arrayList.get(i)).getId();
                SingleStudyAdapter3.this.quiz_name = ((Lists) arrayList.get(i)).getTest_series_name();
                SingleStudyAdapter3.this.totalQuestion = ((Lists) arrayList.get(i)).getTotal_questions();
                result_without_submit(SingleStudyAdapter3.this.quiz_id, SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId(), "0", SingleStudyAdapter3.this.quiz_name);
                return;
            }
            if (((Lists) arrayList.get(i)).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter3.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter3.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter3.this.singleStudy2);
                Helper.gotoActivity(intent, SingleStudyAdapter3.this.activity);
                return;
            }
            SharedPreference.getInstance().putString("id", SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId());
            if (((Lists) arrayList.get(i)).getState().equalsIgnoreCase("1")) {
                SingleStudyAdapter3.this.quiz_id = ((Lists) arrayList.get(i)).getId();
                SingleStudyAdapter3.this.quiz_name = ((Lists) arrayList.get(i)).getTest_series_name();
                SingleStudyAdapter3.this.totalQuestion = ((Lists) arrayList.get(i)).getTotal_questions();
                result_without_submit(SingleStudyAdapter3.this.quiz_id, SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId(), "1", SingleStudyAdapter3.this.quiz_name);
                return;
            }
            SingleStudyAdapter3.this.quiz_id = ((Lists) arrayList.get(i)).getId();
            SingleStudyAdapter3.this.quiz_name = ((Lists) arrayList.get(i)).getTest_series_name();
            SingleStudyAdapter3.this.totalQuestion = ((Lists) arrayList.get(i)).getTotal_questions();
            result_without_submit(SingleStudyAdapter3.this.quiz_id, SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId(), "0", SingleStudyAdapter3.this.quiz_name);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$14(ArrayList arrayList, int i, View view) {
            if (!Helper.isConnected(SingleStudyAdapter3.this.activity)) {
                Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                return;
            }
            if (SingleStudyAdapter3.this.is_purchase.equalsIgnoreCase("1")) {
                SharedPreference.getInstance().putString("id", SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId());
                if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("RE-ATTEMPT")) {
                    SingleStudyAdapter3.this.quiz_id = ((Lists) arrayList.get(i)).getId();
                    SingleStudyAdapter3.this.quiz_name = ((Lists) arrayList.get(i)).getTest_series_name();
                    SingleStudyAdapter3.this.totalQuestion = ((Lists) arrayList.get(i)).getTotal_questions();
                    SingleStudyAdapter3.this.result_date = ((Lists) arrayList.get(i)).getResult_date();
                    SingleStudyAdapter3.this.submission_type = ((Lists) arrayList.get(i)).getSubmission_type();
                    SingleStudyAdapter3.this.first_attempt = "0";
                    SingleStudyAdapter3.this.videodata = (Lists) arrayList.get(i);
                    Helper.resolveTestPattern(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.videodata.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyTestListHolder$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$setData$6();
                        }
                    }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyTestListHolder$$ExternalSyntheticLambda11
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$setData$7();
                        }
                    });
                    return;
                }
                if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("Attempt Now")) {
                    SingleStudyAdapter3.this.quiz_id = ((Lists) arrayList.get(i)).getId();
                    SingleStudyAdapter3.this.quiz_name = ((Lists) arrayList.get(i)).getTest_series_name();
                    SingleStudyAdapter3.this.totalQuestion = ((Lists) arrayList.get(i)).getTotal_questions();
                    SingleStudyAdapter3.this.first_attempt = "1";
                    SingleStudyAdapter3.this.result_date = ((Lists) arrayList.get(i)).getResult_date();
                    SingleStudyAdapter3.this.submission_type = ((Lists) arrayList.get(i)).getSubmission_type();
                    SingleStudyAdapter3.this.videodata = (Lists) arrayList.get(i);
                    Helper.resolveTestPattern(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.videodata.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyTestListHolder$$ExternalSyntheticLambda17
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$setData$8();
                        }
                    }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyTestListHolder$$ExternalSyntheticLambda18
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$setData$9();
                        }
                    });
                    return;
                }
                if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("ATTEMPTED")) {
                    if (((Lists) arrayList.get(i)).getResult_date() != null && !((Lists) arrayList.get(i)).getResult_date().equalsIgnoreCase("0") && !((Lists) arrayList.get(i)).getResult_date().equalsIgnoreCase("1") && !((Lists) arrayList.get(i)).getResult_date().equalsIgnoreCase("")) {
                        Snackbar.make(view, SingleStudyAdapter3.this.activity.getResources().getString(R.string.your_result_will_be_declare_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(((Lists) arrayList.get(i)).getResult_date()) * 1000)), -1).show();
                        return;
                    } else if (SingleStudyAdapter3.this.utkashRoom.getTestDao().is_test_exit(((Lists) arrayList.get(i)).getId(), MakeMyExam.userId)) {
                        Snackbar.make(view, SingleStudyAdapter3.this.activity.getResources().getString(R.string.your_result_is_getting_ready_please_refresh_your_page), -1).show();
                        return;
                    } else {
                        Snackbar.make(view, SingleStudyAdapter3.this.activity.getResources().getString(R.string.your_test_has_already_been_submitted), -1).show();
                        return;
                    }
                }
                if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("View Rank")) {
                    SingleStudyAdapter3.this.quiz_id = ((Lists) arrayList.get(i)).getId();
                    SingleStudyAdapter3.this.quiz_name = ((Lists) arrayList.get(i)).getTest_series_name();
                    SingleStudyAdapter3.this.totalQuestion = ((Lists) arrayList.get(i)).getTotal_questions();
                    if (((Lists) arrayList.get(i)).getState().equalsIgnoreCase("1")) {
                        if (((Lists) arrayList.get(i)).getResult_date() == null || ((Lists) arrayList.get(i)).getResult_date().equalsIgnoreCase("") || ((Lists) arrayList.get(i)).getResult_date().equalsIgnoreCase("0") || ((Lists) arrayList.get(i)).getResult_date().equalsIgnoreCase("1")) {
                            Intent intent = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) QuizActivity.class);
                            intent.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                            intent.putExtra("status", SingleStudyAdapter3.this.quiz_id);
                            intent.putExtra("name", SingleStudyAdapter3.this.quiz_name);
                            intent.putExtra("first_attempt", "1");
                            Helper.gotoActivity(intent, SingleStudyAdapter3.this.activity);
                            return;
                        }
                        Intent intent2 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) QuizActivity.class);
                        intent2.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                        intent2.putExtra("status", SingleStudyAdapter3.this.quiz_id);
                        intent2.putExtra("name", SingleStudyAdapter3.this.quiz_name);
                        intent2.putExtra("first_attempt", "1");
                        Helper.gotoActivity(intent2, SingleStudyAdapter3.this.activity);
                        return;
                    }
                    Intent intent3 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) QuizActivity.class);
                    intent3.putExtra(Const.FRAG_TYPE, "leader_board");
                    intent3.putExtra("status", SingleStudyAdapter3.this.quiz_id);
                    intent3.putExtra("name", SingleStudyAdapter3.this.quiz_name);
                    SingleStudyAdapter3.this.activity.startActivity(intent3);
                    return;
                }
                if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase(SingleStudyAdapter3.this.activity.getResources().getString(R.string.test_is_upcoming))) {
                    Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.test_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(((Lists) arrayList.get(i)).getStart_date()) * 1000)), 0).show();
                    return;
                }
                return;
            }
            if (((Lists) arrayList.get(i)).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter3.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter3.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent4 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) PurchaseActivity.class);
                intent4.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter3.this.singleStudy2);
                Helper.gotoActivity(intent4, SingleStudyAdapter3.this.activity);
                return;
            }
            SharedPreference.getInstance().putString("id", SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId());
            if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("RE-ATTEMPT")) {
                SingleStudyAdapter3.this.quiz_id = ((Lists) arrayList.get(i)).getId();
                SingleStudyAdapter3.this.quiz_name = ((Lists) arrayList.get(i)).getTest_series_name();
                SingleStudyAdapter3.this.totalQuestion = ((Lists) arrayList.get(i)).getTotal_questions();
                SingleStudyAdapter3.this.first_attempt = "0";
                SingleStudyAdapter3.this.result_date = ((Lists) arrayList.get(i)).getResult_date();
                SingleStudyAdapter3.this.submission_type = ((Lists) arrayList.get(i)).getSubmission_type();
                SingleStudyAdapter3.this.videodata = (Lists) arrayList.get(i);
                Helper.resolveTestPattern(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.videodata.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyTestListHolder$$ExternalSyntheticLambda19
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setData$10();
                    }
                }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyTestListHolder$$ExternalSyntheticLambda20
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setData$11();
                    }
                });
                return;
            }
            if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("Attempt Now")) {
                SingleStudyAdapter3.this.quiz_id = ((Lists) arrayList.get(i)).getId();
                SingleStudyAdapter3.this.quiz_name = ((Lists) arrayList.get(i)).getTest_series_name();
                SingleStudyAdapter3.this.totalQuestion = ((Lists) arrayList.get(i)).getTotal_questions();
                SingleStudyAdapter3.this.first_attempt = "1";
                SingleStudyAdapter3.this.result_date = ((Lists) arrayList.get(i)).getResult_date();
                SingleStudyAdapter3.this.submission_type = ((Lists) arrayList.get(i)).getSubmission_type();
                SingleStudyAdapter3.this.videodata = (Lists) arrayList.get(i);
                Helper.resolveTestPattern(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.videodata.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyTestListHolder$$ExternalSyntheticLambda21
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setData$12();
                    }
                }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyTestListHolder$$ExternalSyntheticLambda22
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setData$13();
                    }
                });
                return;
            }
            if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("ATTEMPTED")) {
                if (((Lists) arrayList.get(i)).getResult_date() != null && !((Lists) arrayList.get(i)).getResult_date().equalsIgnoreCase("0") && !((Lists) arrayList.get(i)).getResult_date().equalsIgnoreCase("1") && !((Lists) arrayList.get(i)).getResult_date().equalsIgnoreCase("")) {
                    Snackbar.make(view, SingleStudyAdapter3.this.activity.getResources().getString(R.string.your_result_will_be_declare_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(((Lists) arrayList.get(i)).getResult_date()) * 1000)), -1).show();
                    return;
                } else if (SingleStudyAdapter3.this.utkashRoom.getTestDao().is_test_exit(((Lists) arrayList.get(i)).getId(), MakeMyExam.userId)) {
                    Snackbar.make(view, SingleStudyAdapter3.this.activity.getResources().getString(R.string.your_result_is_getting_ready_please_refresh_your_page), -1).show();
                    return;
                } else {
                    Snackbar.make(view, SingleStudyAdapter3.this.activity.getResources().getString(R.string.your_test_has_already_been_submitted), -1).show();
                    return;
                }
            }
            if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("View Rank")) {
                SingleStudyAdapter3.this.quiz_id = ((Lists) arrayList.get(i)).getId();
                SingleStudyAdapter3.this.quiz_name = ((Lists) arrayList.get(i)).getTest_series_name();
                SingleStudyAdapter3.this.totalQuestion = ((Lists) arrayList.get(i)).getTotal_questions();
                if (((Lists) arrayList.get(i)).getState().equalsIgnoreCase("1")) {
                    if (((Lists) arrayList.get(i)).getResult_date() == null || ((Lists) arrayList.get(i)).getResult_date().equalsIgnoreCase("") || ((Lists) arrayList.get(i)).getResult_date().equalsIgnoreCase("0") || ((Lists) arrayList.get(i)).getResult_date().equalsIgnoreCase("1")) {
                        Intent intent5 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) QuizActivity.class);
                        intent5.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                        intent5.putExtra("status", SingleStudyAdapter3.this.quiz_id);
                        intent5.putExtra("name", SingleStudyAdapter3.this.quiz_name);
                        intent5.putExtra("first_attempt", "1");
                        Helper.gotoActivity(intent5, SingleStudyAdapter3.this.activity);
                        return;
                    }
                    Intent intent6 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) QuizActivity.class);
                    intent6.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                    intent6.putExtra("status", SingleStudyAdapter3.this.quiz_id);
                    intent6.putExtra("name", SingleStudyAdapter3.this.quiz_name);
                    intent6.putExtra("first_attempt", "1");
                    Helper.gotoActivity(intent6, SingleStudyAdapter3.this.activity);
                    return;
                }
                Intent intent7 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) QuizActivity.class);
                intent7.putExtra(Const.FRAG_TYPE, "leader_board");
                intent7.putExtra("status", SingleStudyAdapter3.this.quiz_id);
                intent7.putExtra("name", SingleStudyAdapter3.this.quiz_name);
                SingleStudyAdapter3.this.activity.startActivity(intent7);
                return;
            }
            if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase(SingleStudyAdapter3.this.activity.getResources().getString(R.string.test_is_upcoming))) {
                Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.test_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(((Lists) arrayList.get(i)).getStart_date()) * 1000)), 0).show();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$6() {
            SingleStudyAdapter3.this.isSSCpattern = false;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$7() {
            SingleStudyAdapter3.this.isSSCpattern = true;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$8() {
            SingleStudyAdapter3.this.isSSCpattern = false;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$9() {
            SingleStudyAdapter3.this.isSSCpattern = true;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$10() {
            SingleStudyAdapter3.this.isSSCpattern = false;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$11() {
            SingleStudyAdapter3.this.isSSCpattern = true;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$12() {
            SingleStudyAdapter3.this.isSSCpattern = false;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$13() {
            SingleStudyAdapter3.this.isSSCpattern = true;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$15(int i, View view) {
            if (SingleStudyAdapter3.this.is_purchase.equalsIgnoreCase("1")) {
                Helper.shareTestg(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getCourse_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTopic_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_type(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getRevert_api(), Const.TEST, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getImage(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getTitle(), SingleStudy.parentCourseId);
                return;
            }
            if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter3.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter3.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter3.this.singleStudy2);
                Helper.gotoActivity(intent, SingleStudyAdapter3.this.activity);
                return;
            }
            Helper.shareTestg(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getCourse_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTopic_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_type(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getRevert_api(), Const.TEST, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getImage(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getTitle(), SingleStudy.parentCourseId);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$24(ArrayList arrayList, int i, View view) {
            this.studyitemLL.setBackgroundDrawable(SingleStudyAdapter3.this.activity.getResources().getDrawable(R.drawable.nav_ripple));
            if (this.attemptLL.getVisibility() == 0) {
                if (!Helper.isConnected(SingleStudyAdapter3.this.activity)) {
                    Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                    return;
                }
                if (SingleStudyAdapter3.this.is_purchase.equalsIgnoreCase("1")) {
                    SharedPreference.getInstance().putString("id", SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId());
                    if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("RE-ATTEMPT")) {
                        SingleStudyAdapter3.this.quiz_id = ((Lists) arrayList.get(i)).getId();
                        SingleStudyAdapter3.this.quiz_name = ((Lists) arrayList.get(i)).getTest_series_name();
                        SingleStudyAdapter3.this.totalQuestion = ((Lists) arrayList.get(i)).getTotal_questions();
                        SingleStudyAdapter3.this.result_date = ((Lists) arrayList.get(i)).getResult_date();
                        SingleStudyAdapter3.this.submission_type = ((Lists) arrayList.get(i)).getSubmission_type();
                        SingleStudyAdapter3.this.first_attempt = "0";
                        SingleStudyAdapter3.this.videodata = (Lists) arrayList.get(i);
                        Helper.resolveTestPattern(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.videodata.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyTestListHolder$$ExternalSyntheticLambda8
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$setData$16();
                            }
                        }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyTestListHolder$$ExternalSyntheticLambda9
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$setData$17();
                            }
                        });
                        return;
                    }
                    if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("Attempt Now")) {
                        SingleStudyAdapter3.this.quiz_id = ((Lists) arrayList.get(i)).getId();
                        SingleStudyAdapter3.this.quiz_name = ((Lists) arrayList.get(i)).getTest_series_name();
                        SingleStudyAdapter3.this.totalQuestion = ((Lists) arrayList.get(i)).getTotal_questions();
                        SingleStudyAdapter3.this.first_attempt = "1";
                        SingleStudyAdapter3.this.result_date = ((Lists) arrayList.get(i)).getResult_date();
                        SingleStudyAdapter3.this.submission_type = ((Lists) arrayList.get(i)).getSubmission_type();
                        SingleStudyAdapter3.this.videodata = (Lists) arrayList.get(i);
                        Helper.resolveTestPattern(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.videodata.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyTestListHolder$$ExternalSyntheticLambda10
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$setData$18();
                            }
                        }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyTestListHolder$$ExternalSyntheticLambda12
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$setData$19();
                            }
                        });
                        return;
                    }
                    if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("ATTEMPTED")) {
                        if (((Lists) arrayList.get(i)).getResult_date() != null && !((Lists) arrayList.get(i)).getResult_date().equalsIgnoreCase("0") && !((Lists) arrayList.get(i)).getResult_date().equalsIgnoreCase("1") && !((Lists) arrayList.get(i)).getResult_date().equalsIgnoreCase("")) {
                            Snackbar.make(view, SingleStudyAdapter3.this.activity.getResources().getString(R.string.your_result_will_be_declare_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(((Lists) arrayList.get(i)).getResult_date()) * 1000)), -1).show();
                            return;
                        } else if (SingleStudyAdapter3.this.utkashRoom.getTestDao().is_test_exit(((Lists) arrayList.get(i)).getId(), MakeMyExam.userId)) {
                            Snackbar.make(view, SingleStudyAdapter3.this.activity.getResources().getString(R.string.your_result_is_getting_ready_please_refresh_your_page), -1).show();
                            return;
                        } else {
                            Snackbar.make(view, SingleStudyAdapter3.this.activity.getResources().getString(R.string.your_test_has_already_been_submitted), -1).show();
                            return;
                        }
                    }
                    if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("View Rank")) {
                        SingleStudyAdapter3.this.quiz_id = ((Lists) arrayList.get(i)).getId();
                        SingleStudyAdapter3.this.quiz_name = ((Lists) arrayList.get(i)).getTest_series_name();
                        SingleStudyAdapter3.this.totalQuestion = ((Lists) arrayList.get(i)).getTotal_questions();
                        if (((Lists) arrayList.get(i)).getState().equalsIgnoreCase("1")) {
                            if (((Lists) arrayList.get(i)).getResult_date() == null || ((Lists) arrayList.get(i)).getResult_date().equalsIgnoreCase("") || ((Lists) arrayList.get(i)).getResult_date().equalsIgnoreCase("0") || ((Lists) arrayList.get(i)).getResult_date().equalsIgnoreCase("1")) {
                                Intent intent = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) QuizActivity.class);
                                intent.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                                intent.putExtra("status", SingleStudyAdapter3.this.quiz_id);
                                intent.putExtra("name", SingleStudyAdapter3.this.quiz_name);
                                intent.putExtra("first_attempt", "1");
                                Helper.gotoActivity(intent, SingleStudyAdapter3.this.activity);
                                return;
                            }
                            Intent intent2 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) QuizActivity.class);
                            intent2.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                            intent2.putExtra("status", SingleStudyAdapter3.this.quiz_id);
                            intent2.putExtra("name", SingleStudyAdapter3.this.quiz_name);
                            intent2.putExtra("first_attempt", "1");
                            Helper.gotoActivity(intent2, SingleStudyAdapter3.this.activity);
                            return;
                        }
                        Intent intent3 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) QuizActivity.class);
                        intent3.putExtra(Const.FRAG_TYPE, "leader_board");
                        intent3.putExtra("status", SingleStudyAdapter3.this.quiz_id);
                        intent3.putExtra("name", SingleStudyAdapter3.this.quiz_name);
                        SingleStudyAdapter3.this.activity.startActivity(intent3);
                        return;
                    }
                    return;
                }
                if (((Lists) arrayList.get(i)).getIs_locked().equalsIgnoreCase("1")) {
                    if (SingleStudyAdapter3.this.isCourseSoldOut()) {
                        Toast.makeText(SingleStudyAdapter3.this.activity, R.string.sold_out_msg, 0).show();
                        return;
                    }
                    Intent intent4 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) PurchaseActivity.class);
                    intent4.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter3.this.singleStudy2);
                    Helper.gotoActivity(intent4, SingleStudyAdapter3.this.activity);
                    return;
                }
                SharedPreference.getInstance().putString("id", SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId());
                if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("RE-ATTEMPT")) {
                    SingleStudyAdapter3.this.quiz_id = ((Lists) arrayList.get(i)).getId();
                    SingleStudyAdapter3.this.quiz_name = ((Lists) arrayList.get(i)).getTest_series_name();
                    SingleStudyAdapter3.this.totalQuestion = ((Lists) arrayList.get(i)).getTotal_questions();
                    SingleStudyAdapter3.this.first_attempt = "0";
                    SingleStudyAdapter3.this.result_date = ((Lists) arrayList.get(i)).getResult_date();
                    SingleStudyAdapter3.this.submission_type = ((Lists) arrayList.get(i)).getSubmission_type();
                    SingleStudyAdapter3.this.videodata = (Lists) arrayList.get(i);
                    Helper.resolveTestPattern(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.videodata.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyTestListHolder$$ExternalSyntheticLambda13
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$setData$20();
                        }
                    }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyTestListHolder$$ExternalSyntheticLambda14
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$setData$21();
                        }
                    });
                    return;
                }
                if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("Attempt Now")) {
                    SingleStudyAdapter3.this.quiz_id = ((Lists) arrayList.get(i)).getId();
                    SingleStudyAdapter3.this.quiz_name = ((Lists) arrayList.get(i)).getTest_series_name();
                    SingleStudyAdapter3.this.totalQuestion = ((Lists) arrayList.get(i)).getTotal_questions();
                    SingleStudyAdapter3.this.first_attempt = "1";
                    SingleStudyAdapter3.this.result_date = ((Lists) arrayList.get(i)).getResult_date();
                    SingleStudyAdapter3.this.submission_type = ((Lists) arrayList.get(i)).getSubmission_type();
                    SingleStudyAdapter3.this.videodata = (Lists) arrayList.get(i);
                    Helper.resolveTestPattern(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.videodata.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyTestListHolder$$ExternalSyntheticLambda15
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$setData$22();
                        }
                    }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyTestListHolder$$ExternalSyntheticLambda16
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$setData$23();
                        }
                    });
                    return;
                }
                if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("ATTEMPTED")) {
                    if (((Lists) arrayList.get(i)).getResult_date() != null && !((Lists) arrayList.get(i)).getResult_date().equalsIgnoreCase("0") && !((Lists) arrayList.get(i)).getResult_date().equalsIgnoreCase("1") && !((Lists) arrayList.get(i)).getResult_date().equalsIgnoreCase("")) {
                        Snackbar.make(view, SingleStudyAdapter3.this.activity.getResources().getString(R.string.your_result_will_be_declare_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(((Lists) arrayList.get(i)).getResult_date()) * 1000)), -1).show();
                        return;
                    } else if (SingleStudyAdapter3.this.utkashRoom.getTestDao().is_test_exit(((Lists) arrayList.get(i)).getId(), MakeMyExam.userId)) {
                        Snackbar.make(view, SingleStudyAdapter3.this.activity.getResources().getString(R.string.your_result_is_getting_ready_please_refresh_your_page), -1).show();
                        return;
                    } else {
                        Snackbar.make(view, SingleStudyAdapter3.this.activity.getResources().getString(R.string.your_test_has_already_been_submitted), -1).show();
                        return;
                    }
                }
                if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("View Rank")) {
                    SingleStudyAdapter3.this.quiz_id = ((Lists) arrayList.get(i)).getId();
                    SingleStudyAdapter3.this.quiz_name = ((Lists) arrayList.get(i)).getTest_series_name();
                    SingleStudyAdapter3.this.totalQuestion = ((Lists) arrayList.get(i)).getTotal_questions();
                    if (((Lists) arrayList.get(i)).getState().equalsIgnoreCase("1")) {
                        if (((Lists) arrayList.get(i)).getResult_date() == null || ((Lists) arrayList.get(i)).getResult_date().equalsIgnoreCase("") || ((Lists) arrayList.get(i)).getResult_date().equalsIgnoreCase("0") || ((Lists) arrayList.get(i)).getResult_date().equalsIgnoreCase("1")) {
                            Intent intent5 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) QuizActivity.class);
                            intent5.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                            intent5.putExtra("status", SingleStudyAdapter3.this.quiz_id);
                            intent5.putExtra("name", SingleStudyAdapter3.this.quiz_name);
                            intent5.putExtra("first_attempt", "1");
                            Helper.gotoActivity(intent5, SingleStudyAdapter3.this.activity);
                            return;
                        }
                        Intent intent6 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) QuizActivity.class);
                        intent6.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                        intent6.putExtra("status", SingleStudyAdapter3.this.quiz_id);
                        intent6.putExtra("name", SingleStudyAdapter3.this.quiz_name);
                        intent6.putExtra("first_attempt", "1");
                        Helper.gotoActivity(intent6, SingleStudyAdapter3.this.activity);
                        return;
                    }
                    Intent intent7 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) QuizActivity.class);
                    intent7.putExtra(Const.FRAG_TYPE, "leader_board");
                    intent7.putExtra("status", SingleStudyAdapter3.this.quiz_id);
                    intent7.putExtra("name", SingleStudyAdapter3.this.quiz_name);
                    SingleStudyAdapter3.this.activity.startActivity(intent7);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$16() {
            SingleStudyAdapter3.this.isSSCpattern = false;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$17() {
            SingleStudyAdapter3.this.isSSCpattern = true;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$18() {
            SingleStudyAdapter3.this.isSSCpattern = false;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$19() {
            SingleStudyAdapter3.this.isSSCpattern = true;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$20() {
            SingleStudyAdapter3.this.isSSCpattern = false;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$21() {
            SingleStudyAdapter3.this.isSSCpattern = true;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$22() {
            SingleStudyAdapter3.this.isSSCpattern = false;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$23() {
            SingleStudyAdapter3.this.isSSCpattern = true;
            startTestAPI();
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

        private void startTestAPI() {
            SingleStudyAdapter3 singleStudyAdapter3 = SingleStudyAdapter3.this;
            new NetworkCall(singleStudyAdapter3, singleStudyAdapter3.activity).NetworkAPICall(API.API_GET_TEST_INSTRUCTION_DATA, "", true, false);
        }

        public void result_without_submit(final String quiz_id, String course_id, String s, final String quiz_name) {
            if (Helper.isNetworkConnected(SingleStudyAdapter3.this.activity)) {
                final Progress progress = new Progress(SingleStudyAdapter3.this.activity);
                progress.show();
                APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setTest_id(quiz_id);
                encryptionData.setCourse_id(course_id);
                encryptionData.setFirst_attempt(s);
                aPIInterface.getTestlearn(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new Callback<String>() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3.SingleStudyTestListHolder.3
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
                                Helper.showToastSecurity(SingleStudyAdapter3.this.activity);
                                return;
                            }
                            try {
                                if (resultTestSeries_Report.getStatus().equalsIgnoreCase("true")) {
                                    SharedPreference.getInstance().putString("testresult", new Gson().toJson(resultTestSeries_Report));
                                    Intent intent = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) ViewSolutionActivity.class);
                                    intent.putExtra(Const.TESTSEGMENT_ID, quiz_id);
                                    intent.putExtra(Const.FRAG_TYPE, Const.SOLUTIONREPORT);
                                    intent.putExtra("name", quiz_name);
                                    intent.putExtra("type", "learn");
                                    if (!resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("1")) {
                                        if (resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("2")) {
                                            SingleStudyAdapter3.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                                        }
                                    } else {
                                        SingleStudyAdapter3.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                                    }
                                    intent.putExtra(Const.LANG, SingleStudyAdapter3.this.lang);
                                    Helper.gotoActivity(intent, SingleStudyAdapter3.this.activity);
                                    return;
                                }
                                progress.dismiss();
                                RetrofitResponse.GetApiData(SingleStudyAdapter3.this.activity, jSONObject.optString("auth_code"), jSONObject.optString("message"), false);
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
            Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.Retry_with_Internet_connection), 1).show();
        }

        public void netoworkCallForQuizResult2(final String quiz_id, String course_id, String s, final String quiz_name) {
            if (Helper.isNetworkConnected(SingleStudyAdapter3.this.activity)) {
                final Progress progress = new Progress(SingleStudyAdapter3.this.activity);
                progress.show();
                APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setTest_id(quiz_id);
                encryptionData.setCourse_id(course_id);
                encryptionData.setFirst_attempt(s);
                aPIInterface.getTestResult(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new Callback<String>() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3.SingleStudyTestListHolder.4
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
                                Helper.showToastSecurity(SingleStudyAdapter3.this.activity);
                                return;
                            }
                            try {
                                if (resultTestSeries_Report.getStatus().equalsIgnoreCase("true")) {
                                    if (resultTestSeries_Report.getData().getQuestions() != null && resultTestSeries_Report.getData().getQuestions().size() > 0) {
                                        SharedPreference.getInstance().putString("testresult", new Gson().toJson(resultTestSeries_Report));
                                        Intent intent = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) ViewSolutionActivity.class);
                                        intent.putExtra(Const.TESTSEGMENT_ID, quiz_id);
                                        intent.putExtra(Const.FRAG_TYPE, Const.SOLUTIONREPORT);
                                        intent.putExtra("name", quiz_name);
                                        intent.putExtra("type", "learn");
                                        if (!resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("1")) {
                                            if (resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("2")) {
                                                SingleStudyAdapter3.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                                            }
                                        } else {
                                            SingleStudyAdapter3.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                                        }
                                        intent.putExtra(Const.LANG, SingleStudyAdapter3.this.lang);
                                        Helper.gotoActivity(intent, SingleStudyAdapter3.this.activity);
                                        return;
                                    }
                                    Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.no_question_found), 0).show();
                                    return;
                                }
                                progress.dismiss();
                                RetrofitResponse.GetApiData(SingleStudyAdapter3.this.activity, jSONObject.optString("auth_code"), jSONObject.optString("message"), false);
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
            Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.Retry_with_Internet_connection), 1).show();
        }
    }

    public class SingleStudySubjectiveTestListHolder extends RecyclerView.ViewHolder {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public final int REQUEST_CODE_MULTIPLE_PIKER;
        private int STORAGE_PERMISSION_TYPE;
        LinearLayout attemptLL;
        Button backBtn;
        Button booklet;
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
            this.forwardIV = (ImageView) itemView.findViewById(R.id.forwardIV);
        }

        public void setData(final ArrayList<Lists> list, final int position) {
            long j;
            if (list != null && list.size() > 0) {
                this.ibt_single_sub_vd_RL.setVisibility(0);
                this.no_data_found_RL.setVisibility(8);
                if (TextUtils.isEmpty(list.get(position).getIs_locked())) {
                    list.get(position).setIs_locked("0");
                }
                if (SingleStudyAdapter3.this.singleStudy2 != null && SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail() != null && SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getIsPurchased().equals("1")) {
                    list.get(position).setIs_locked("0");
                }
                if (SingleStudyAdapter3.this.isSkip.equalsIgnoreCase("3")) {
                    this.share.setVisibility(8);
                    this.forwardIV.setVisibility(8);
                    this.titleCategory.setText(list.get(position).getTest_series_name());
                    if (Helper.isLiveTest(list.get(position).getTest_series_type()) && !list.get(position).getEnd_date().equalsIgnoreCase("0") && !list.get(position).getEnd_date().equalsIgnoreCase("")) {
                        this.subItemRV.setVisibility(0);
                        j = 1000;
                        this.subItemRV.setText(SingleStudyAdapter3.this.activity.getResources().getString(R.string.test_end) + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(list.get(position).getEnd_date()) * 1000))));
                    } else {
                        j = 1000;
                        this.subItemRV.setVisibility(8);
                    }
                    if (Helper.isLiveTest(list.get(position).getTest_series_type()) && !list.get(position).getStart_date().equalsIgnoreCase("0") && !list.get(position).getStart_date().equalsIgnoreCase("")) {
                        this.startdate.setVisibility(0);
                        this.startdate.setText(SingleStudyAdapter3.this.activity.getResources().getString(R.string.test_start) + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(list.get(position).getStart_date()) * j))));
                    } else {
                        this.startdate.setVisibility(8);
                    }
                    this.attemptLL.setVisibility(8);
                    if (!TextUtils.isEmpty(list.get(position).getImage())) {
                        Helper.setThumbnailImage(SingleStudyAdapter3.this.activity, list.get(position).getImage(), SingleStudyAdapter3.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.imageIcon);
                    } else {
                        this.imageIcon.setImageResource(R.mipmap.square_placeholder);
                    }
                    if (SingleStudyAdapter3.this.isSkip.equalsIgnoreCase("3")) {
                        if (list.get(position).getAttempt().equalsIgnoreCase("0")) {
                            this.upload.setText("Upload");
                        } else {
                            this.upload.setText("View");
                        }
                        setSubjectiveTestOnClick(list.get(position));
                    }
                } else {
                    this.share.setVisibility(8);
                    this.subItemRV.setVisibility(0);
                    this.attemptLL.setVisibility(8);
                    this.learn.setVisibility(8);
                    this.practice.setVisibility(8);
                    this.subjectBTNLL.setVisibility(8);
                    if (!TextUtils.isEmpty(list.get(position).getImage_icon())) {
                        Helper.setThumbnailImage(SingleStudyAdapter3.this.activity, list.get(position).getImage_icon(), SingleStudyAdapter3.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.imageIcon);
                    } else {
                        this.imageIcon.setImageResource(R.mipmap.square_placeholder);
                    }
                    this.subItemRV.setVisibility(8);
                    this.subItemRV.setText(SingleStudyAdapter3.this.activity.getResources().getString(R.string.total_) + list.get(position).getCount());
                    this.titleCategory.setText(list.get(position).getTitle());
                    this.studyitemLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3.SingleStudySubjectiveTestListHolder.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            String str;
                            Object obj;
                            String str2;
                            String str3;
                            String str4;
                            if (((Lists) list.get(position)).getIs_locked().equalsIgnoreCase("1")) {
                                if (SingleStudyAdapter3.this.isCourseSoldOut()) {
                                    Toast.makeText(SingleStudyAdapter3.this.activity, R.string.sold_out_msg, 0).show();
                                    return;
                                }
                                Intent intent = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) PurchaseActivity.class);
                                intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter3.this.singleStudy2);
                                Helper.gotoActivity(intent, SingleStudyAdapter3.this.activity);
                                return;
                            }
                            if (SingleStudyAdapter3.this.isSkip.equalsIgnoreCase("1")) {
                                str = "0";
                                obj = "content";
                                str2 = "title";
                                str3 = "tile_id";
                                str4 = Const.TILE_TYPE;
                            } else {
                                str4 = Const.TILE_TYPE;
                                if (!SingleStudyAdapter3.this.isSkip.equalsIgnoreCase("2")) {
                                    if (SingleStudyAdapter3.this.isSkip.equalsIgnoreCase("3")) {
                                        return;
                                    }
                                    ExamPrepItem examPrepItem = new ExamPrepItem();
                                    examPrepItem.setList(SingleStudyAdapter3.this.examPrepItem.getList().get(position).getList());
                                    Intent intent2 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) CourseActivity.class);
                                    SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(SingleStudyAdapter3.this.singleStudy2 != null ? SingleStudyAdapter3.this.singleStudy2 : new CourseDetail()));
                                    SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(examPrepItem));
                                    SharedPreference.getInstance().putString("list", new Gson().toJson(list.get(position) != null ? list.get(position) : new Lists()));
                                    intent2.putExtra(Const.FRAG_TYPE, Const.EXAMPREP);
                                    intent2.putExtra(Const.IS_COMBO, SingleStudyAdapter3.this.isCombo);
                                    intent2.putExtra("content_type", SingleStudyAdapter3.this.contentType);
                                    if (SingleStudyAdapter3.this.mainCourseId.equals("455") || SingleStudyAdapter3.this.tileTypeAPI.equals(Const.COMBO) || SingleStudyAdapter3.this.tileTypeAPI.equals("content")) {
                                        intent2.putExtra(Const.TAB_TILE_VISIBILITY, "1");
                                    } else {
                                        intent2.putExtra(Const.TAB_TILE_VISIBILITY, "0");
                                    }
                                    intent2.putExtra("title", SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail() != null ? SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getTitle() : "Course");
                                    intent2.putExtra("tile_id", SingleStudyAdapter3.this.tileIdAPI);
                                    intent2.putExtra(str4, SingleStudyAdapter3.this.tileTypeAPI);
                                    intent2.putExtra(Const.REVERT_API, SingleStudyAdapter3.this.revertAPI);
                                    Helper.gotoActivity(intent2, SingleStudyAdapter3.this.activity);
                                    return;
                                }
                                str = "0";
                                obj = "content";
                                str2 = "title";
                                str3 = "tile_id";
                            }
                            String str5 = str3;
                            String str6 = str;
                            Intent intent3 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) CourseActivity.class);
                            Object obj2 = obj;
                            SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(SingleStudyAdapter3.this.singleStudy2 != null ? SingleStudyAdapter3.this.singleStudy2 : new CourseDetail()));
                            SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(SingleStudyAdapter3.this.examPrepItem != null ? SingleStudyAdapter3.this.examPrepItem : new ExamPrepItem()));
                            SharedPreference.getInstance().putString("list", new Gson().toJson(SingleStudyAdapter3.this.examPrepItem.getList().get(position) != null ? SingleStudyAdapter3.this.examPrepItem.getList().get(position) : new Lists()));
                            intent3.putExtra(Const.FRAG_TYPE, Const.EXAMPREPLAST);
                            intent3.putExtra(Const.IS_COMBO, SingleStudyAdapter3.this.isCombo);
                            intent3.putExtra(str2, SingleStudyAdapter3.this.examPrepItem.getList().get(position).getTitle());
                            intent3.putExtra("content_type", SingleStudyAdapter3.this.contentType);
                            if (SingleStudyAdapter3.this.mainCourseId.equals("455") || SingleStudyAdapter3.this.tileTypeAPI.equals(Const.COMBO) || SingleStudyAdapter3.this.tileTypeAPI.equals(obj2)) {
                                intent3.putExtra(Const.TAB_TILE_VISIBILITY, "1");
                            } else {
                                intent3.putExtra(Const.TAB_TILE_VISIBILITY, str6);
                            }
                            intent3.putExtra(Const.TEST_TYPE, SingleStudyAdapter3.this.examPrepItem.getList().get(position).getCount());
                            intent3.putExtra(str5, SingleStudyAdapter3.this.tileIdAPI);
                            intent3.putExtra(str4, SingleStudyAdapter3.this.tileTypeAPI);
                            intent3.putExtra(Const.LIST_SUBJECT, SingleStudyAdapter3.this.examPrepItem.getList().get(position));
                            intent3.putExtra(Const.REVERT_API, SingleStudyAdapter3.this.revertAPI);
                            Helper.gotoActivity(intent3, SingleStudyAdapter3.this.activity);
                        }
                    });
                }
                if (list.get(position).getIs_locked().equals("0")) {
                    this.lockRL.setVisibility(8);
                } else {
                    this.lockRL.setVisibility(0);
                    this.share.setVisibility(8);
                    this.subItemRV.setVisibility(8);
                    this.attemptLL.setVisibility(8);
                    this.learn.setVisibility(8);
                    this.practice.setVisibility(8);
                    this.subjectBTNLL.setVisibility(8);
                }
                if (list.get(position).getAttempt() != null) {
                    if (list.get(position).getAttempt().equalsIgnoreCase("0")) {
                        this.upload.setText(SingleStudyAdapter3.this.activity.getResources().getString(R.string.upload));
                        return;
                    } else {
                        if (list.get(position).getAttempt().equalsIgnoreCase("1")) {
                            this.upload.setText(SingleStudyAdapter3.this.activity.getResources().getString(R.string.view));
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            this.ibt_single_sub_vd_RL.setVisibility(8);
            this.no_data_found_RL.setVisibility(0);
            this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3.SingleStudySubjectiveTestListHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    SingleStudyAdapter3.this.activity.finish();
                }
            });
        }

        public void setSubjectiveTestOnClick(final Lists video) {
            com.appnew.android.home.Constants.SUB_TEST_ID = video.getId();
            this.paper.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3.SingleStudySubjectiveTestListHolder.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (System.currentTimeMillis() < Long.parseLong(video.getStart_date()) * 1000) {
                        Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.test_will_start_on) + new SimpleDateFormat("dd/MM/yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                        return;
                    }
                    if (!Helper.isConnected(SingleStudyAdapter3.this.activity)) {
                        Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                        return;
                    }
                    if (video.getIs_locked().equalsIgnoreCase("1")) {
                        if (SingleStudyAdapter3.this.isCourseSoldOut()) {
                            Toast.makeText(SingleStudyAdapter3.this.activity, R.string.sold_out_msg, 0).show();
                            return;
                        }
                        Intent intent = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) PurchaseActivity.class);
                        intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter3.this.singleStudy2);
                        Helper.gotoActivity(intent, SingleStudyAdapter3.this.activity);
                        return;
                    }
                    if (video.getQuestion().equalsIgnoreCase("")) {
                        return;
                    }
                    com.appnew.android.home.Constants.SUB_TEST_ID = video.getId();
                    Helper.GoToWebViewPDFActivity(SingleStudyAdapter3.this.activity, video.getId(), video.getQuestion(), true, video.getQuestion().split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r10.length - 1].split("\\.")[0], SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId(), video.getIs_share());
                }
            });
            this.upload.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudySubjectiveTestListHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setSubjectiveTestOnClick$0(video, view);
                }
            });
            this.booklet.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3.SingleStudySubjectiveTestListHolder.4
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (Long.parseLong(video.getResult_date()) * 1000 < System.currentTimeMillis()) {
                        if (!Helper.isConnected(SingleStudyAdapter3.this.activity)) {
                            Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                            return;
                        }
                        if (SingleStudyAdapter3.this.is_purchase.equalsIgnoreCase("1")) {
                            if (!video.getAnswers().equalsIgnoreCase("")) {
                                com.appnew.android.home.Constants.SUB_TEST_ID = video.getId();
                                Helper.GoToWebViewPDFActivity(SingleStudyAdapter3.this.activity, video.getId(), video.getAnswers(), true, video.getAnswers().split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r11.length - 1].split("\\.")[0], SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId(), video.getIs_share());
                                return;
                            }
                            Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.file_not_found), 0).show();
                            return;
                        }
                        if (video.getIs_locked().equalsIgnoreCase("1")) {
                            if (SingleStudyAdapter3.this.isCourseSoldOut()) {
                                Toast.makeText(SingleStudyAdapter3.this.activity, R.string.sold_out_msg, 0).show();
                                return;
                            }
                            Intent intent = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) PurchaseActivity.class);
                            intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter3.this.singleStudy2);
                            Helper.gotoActivity(intent, SingleStudyAdapter3.this.activity);
                            return;
                        }
                        com.appnew.android.home.Constants.SUB_TEST_ID = video.getId();
                        Helper.GoToWebViewPDFActivity(SingleStudyAdapter3.this.activity, video.getId(), video.getAnswers(), true, video.getAnswers().split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r11.length - 1].split("\\.")[0], SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId(), video.getIs_share());
                        return;
                    }
                    Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.booklet_will_be_available_on) + new SimpleDateFormat("dd/MM/yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video.getResult_date()) * 1000)), 0).show();
                }
            });
            this.marks.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3.SingleStudySubjectiveTestListHolder.5
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (Long.parseLong(video.getResult_date()) * 1000 < System.currentTimeMillis()) {
                        if (!Helper.isConnected(SingleStudyAdapter3.this.activity)) {
                            Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                            return;
                        }
                        if (SingleStudyAdapter3.this.is_purchase.equalsIgnoreCase("1")) {
                            com.appnew.android.home.Constants.SUB_TEST_ID = video.getId();
                            Helper.GoToSubjectiveResultActivity(SingleStudyAdapter3.this.activity, video.getSolutions(), video.getTitle(), SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId(), video.getId(), SingleStudyAdapter3.this.contentType);
                            return;
                        } else {
                            if (video.getIs_locked().equalsIgnoreCase("1")) {
                                if (SingleStudyAdapter3.this.isCourseSoldOut()) {
                                    Toast.makeText(SingleStudyAdapter3.this.activity, R.string.sold_out_msg, 0).show();
                                    return;
                                }
                                Intent intent = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) PurchaseActivity.class);
                                intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter3.this.singleStudy2);
                                Helper.gotoActivity(intent, SingleStudyAdapter3.this.activity);
                                return;
                            }
                            com.appnew.android.home.Constants.SUB_TEST_ID = video.getId();
                            Helper.GoToSubjectiveResultActivity(SingleStudyAdapter3.this.activity, video.getSolutions(), video.getTitle(), SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId(), video.getId(), SingleStudyAdapter3.this.contentType);
                            return;
                        }
                    }
                    Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.result_will_be_available_on) + new SimpleDateFormat("dd/MM/yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video.getResult_date()) * 1000)), 0).show();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setSubjectiveTestOnClick$0(Lists lists, View view) {
            if (this.upload.getText().toString().equalsIgnoreCase("View")) {
                Intent intent = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) PdfDetailScreen.class);
                intent.putExtra(Const.THUMBNAIL, lists.getThumbnail_url());
                intent.putExtra("url", lists.getAnswers_by_student());
                intent.putExtra("file_type", lists.getFile_type());
                SingleStudyAdapter3.this.activity.startActivity(intent);
                return;
            }
            if (System.currentTimeMillis() > Long.parseLong(lists.getEnd_date()) * 1000 || MakeMyExam.time_server > Long.parseLong(lists.getEnd_date()) * 1000) {
                Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.you_cant_upload_message), 0).show();
                return;
            }
            if (System.currentTimeMillis() < Long.parseLong(lists.getStart_date()) * 1000 && MakeMyExam.time_server < Long.parseLong(lists.getStart_date()) * 1000) {
                Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.test_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(lists.getStart_date()) * 1000)), 0).show();
                return;
            }
            if (!Helper.isConnected(SingleStudyAdapter3.this.activity)) {
                Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                return;
            }
            if (SingleStudyAdapter3.this.is_purchase.equalsIgnoreCase("1")) {
                if (lists.getUpload_allowed() != null && lists.getUpload_allowed().equalsIgnoreCase("1")) {
                    com.appnew.android.home.Constants.SUB_TEST_ID = lists.getId();
                    checkStoragePermission();
                    return;
                } else {
                    Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.you_cant_upload_now), 0).show();
                    return;
                }
            }
            if (lists.getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter3.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter3.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent2 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) PurchaseActivity.class);
                intent2.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter3.this.singleStudy2);
                Helper.gotoActivity(intent2, SingleStudyAdapter3.this.activity);
                return;
            }
            if (lists.getUpload_allowed() != null && lists.getUpload_allowed().equalsIgnoreCase("1")) {
                com.appnew.android.home.Constants.SUB_TEST_ID = lists.getId();
                checkStoragePermission();
            } else {
                Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.you_cant_upload_now), 0).show();
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
            }
        }

        private void startTestAPI() {
            SingleStudyAdapter3 singleStudyAdapter3 = SingleStudyAdapter3.this;
            new NetworkCall(singleStudyAdapter3, singleStudyAdapter3.activity).NetworkAPICall(API.API_GET_TEST_INSTRUCTION_DATA, "", true, false);
        }

        public void result_without_submit(final String quiz_id, String course_id, String s, final String quiz_name) {
            if (Helper.isNetworkConnected(SingleStudyAdapter3.this.activity)) {
                final Progress progress = new Progress(SingleStudyAdapter3.this.activity);
                progress.show();
                APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setTest_id(quiz_id);
                encryptionData.setCourse_id(course_id);
                encryptionData.setFirst_attempt(s);
                aPIInterface.getTestlearn(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new Callback<String>() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3.SingleStudySubjectiveTestListHolder.6
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
                                Helper.showToastSecurity(SingleStudyAdapter3.this.activity);
                                return;
                            }
                            try {
                                if (resultTestSeries_Report.getStatus().equalsIgnoreCase("true")) {
                                    SharedPreference.getInstance().putString("testresult", new Gson().toJson(resultTestSeries_Report));
                                    Intent intent = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) ViewSolutionActivity.class);
                                    intent.putExtra(Const.TESTSEGMENT_ID, quiz_id);
                                    intent.putExtra(Const.FRAG_TYPE, Const.SOLUTIONREPORT);
                                    intent.putExtra("name", quiz_name);
                                    intent.putExtra("type", "learn");
                                    if (!resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("1")) {
                                        if (resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("2")) {
                                            SingleStudyAdapter3.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                                        }
                                    } else {
                                        SingleStudyAdapter3.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                                    }
                                    intent.putExtra(Const.LANG, SingleStudyAdapter3.this.lang);
                                    Helper.gotoActivity(intent, SingleStudyAdapter3.this.activity);
                                    return;
                                }
                                progress.dismiss();
                                RetrofitResponse.GetApiData(SingleStudyAdapter3.this.activity, jSONObject.optString("auth_code"), jSONObject.optString("message"), false);
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
            Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.Retry_with_Internet_connection), 1).show();
        }

        public void netoworkCallForQuizResult2(final String quiz_id, String course_id, String s, final String quiz_name) {
            if (Helper.isNetworkConnected(SingleStudyAdapter3.this.activity)) {
                final Progress progress = new Progress(SingleStudyAdapter3.this.activity);
                progress.show();
                APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setTest_id(quiz_id);
                encryptionData.setCourse_id(course_id);
                encryptionData.setFirst_attempt(s);
                aPIInterface.getTestResult(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new Callback<String>() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3.SingleStudySubjectiveTestListHolder.7
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
                                Helper.showToastSecurity(SingleStudyAdapter3.this.activity);
                                return;
                            }
                            try {
                                if (resultTestSeries_Report.getStatus().equalsIgnoreCase("true")) {
                                    if (resultTestSeries_Report.getData().getQuestions() != null && resultTestSeries_Report.getData().getQuestions().size() > 0) {
                                        SharedPreference.getInstance().putString("testresult", new Gson().toJson(resultTestSeries_Report));
                                        Intent intent = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) ViewSolutionActivity.class);
                                        intent.putExtra(Const.TESTSEGMENT_ID, quiz_id);
                                        intent.putExtra(Const.FRAG_TYPE, Const.SOLUTIONREPORT);
                                        intent.putExtra("name", quiz_name);
                                        intent.putExtra("type", "learn");
                                        if (!resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("1")) {
                                            if (resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("2")) {
                                                SingleStudyAdapter3.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                                            }
                                        } else {
                                            SingleStudyAdapter3.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                                        }
                                        intent.putExtra(Const.LANG, SingleStudyAdapter3.this.lang);
                                        Helper.gotoActivity(intent, SingleStudyAdapter3.this.activity);
                                        return;
                                    }
                                    Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.no_question_found), 0).show();
                                    return;
                                }
                                progress.dismiss();
                                RetrofitResponse.GetApiData(SingleStudyAdapter3.this.activity, jSONObject.optString("auth_code"), jSONObject.optString("message"), false);
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
            Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.Retry_with_Internet_connection), 1).show();
        }
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
        LeftMenu leftMenu;
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
            if (list != null && list.size() > 0) {
                this.leftMenu = (LeftMenu) new Gson().fromJson(SingleStudyAdapter3.this.themeSettings.getLeft_menu(), LeftMenu.class);
                this.ibt_single_sub_vd_RL.setVisibility(0);
                this.no_data_found_RL.setVisibility(8);
                if ("1".equalsIgnoreCase("5")) {
                    if (SingleStudyAdapter3.this.contentType.contains("video") && list.get(position).getIs_live() != null && list.get(position).getIs_live().equals("1")) {
                        this.liveIV.setVisibility(0);
                    } else {
                        this.liveIV.setVisibility(8);
                    }
                } else if (list.get(position).getIs_live() != null && list.get(position).getIs_live().equals("1")) {
                    this.liveIV.setVisibility(0);
                } else {
                    this.liveIV.setVisibility(8);
                }
                if (TextUtils.isEmpty(list.get(position).getIs_locked())) {
                    list.get(position).setIs_locked("0");
                }
                if (SingleStudyAdapter3.this.singleStudy2 != null && SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail() != null && SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getIsPurchased().equals("1")) {
                    list.get(position).setIs_locked("0");
                }
                if (SingleStudyAdapter3.this.isSkip.equalsIgnoreCase("3")) {
                    this.studyitemLL.setEnabled(false);
                    this.forwardIV.setVisibility(8);
                    if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getExtra_params() != null) {
                        if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getExtra_params().getIs_limited().equalsIgnoreCase("1")) {
                            this.LogsLL.setVisibility(0);
                            if (BuildConfig.FLAVOR.equalsIgnoreCase("Shrestha")) {
                                setvisibility(1, 0, 1, 0);
                            } else {
                                setvisibility(0, 1, 1, 1);
                            }
                            this.actualduration.setText(Helper.formatSeconds((int) Float.parseFloat(SingleStudyAdapter3.this.examPrepItem.getList().get(position).getVideo_duration())));
                            this.duration.setText(Helper.formatSeconds((int) Float.parseFloat(SingleStudyAdapter3.this.examPrepItem.getList().get(position).getVideo_length())));
                            this.total_view_time.setText(Helper.formatSeconds((int) (Float.parseFloat(SingleStudyAdapter3.this.examPrepItem.getList().get(position).getVideo_length()) - Float.parseFloat(SingleStudyAdapter3.this.examPrepItem.getList().get(position).getRemaining_time()))));
                            this.remaining_time.setText(Helper.formatSeconds((int) Float.parseFloat(SingleStudyAdapter3.this.examPrepItem.getList().get(position).getRemaining_time())));
                        } else {
                            this.LogsLL.setVisibility(8);
                        }
                    }
                    if (!TextUtils.isEmpty(list.get(position).getThumbnail_url())) {
                        Helper.setThumbnailImage(SingleStudyAdapter3.this.activity, list.get(position).getThumbnail_url(), SingleStudyAdapter3.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.imageIcon);
                    } else {
                        this.imageIcon.setImageResource(R.mipmap.square_placeholder);
                    }
                } else {
                    this.LogsLL.setVisibility(8);
                    this.studyitemLL.setEnabled(true);
                    if (!TextUtils.isEmpty(list.get(position).getImage_icon())) {
                        Helper.setThumbnailImage(SingleStudyAdapter3.this.activity, list.get(position).getImage_icon(), SingleStudyAdapter3.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.imageIcon);
                    } else {
                        this.imageIcon.setImageResource(R.mipmap.square_placeholder);
                    }
                }
                this.titleCategory.setText(list.get(position).getTitle());
                if (SingleStudyAdapter3.this.isSkip.equalsIgnoreCase("3")) {
                    if ("1".equalsIgnoreCase("5")) {
                        this.layout_fun.setVisibility(8);
                    } else {
                        this.layout_fun.setVisibility(0);
                    }
                    if (list.get(position).getIs_download_available().equalsIgnoreCase("1")) {
                        this.optionMenuImgView.setVisibility(0);
                        this.optionMenuImgView.setImageResource(R.drawable.download_icon);
                    } else {
                        this.optionMenuImgView.setVisibility(8);
                    }
                    if (list.get(position).getVideo_status() != null) {
                        if (list.get(position).getVideo_status().equalsIgnoreCase("Download Running")) {
                            this.optionMenuImgView.setVisibility(8);
                            this.subItemRV.setVisibility(8);
                        } else if (list.get(position).getVideo_status().equalsIgnoreCase("Downloaded")) {
                            this.optionMenuImgView.setVisibility(0);
                            this.optionMenuImgView.setEnabled(false);
                            this.subItemRV.setVisibility(8);
                            this.optionMenuImgView.setImageResource(R.drawable.ic_downloaded_chapter);
                            this.subItemRV.setText("Duration : " + list.get(position).getVideo_time());
                        } else if (list.get(position).getVideo_status().equalsIgnoreCase("Download")) {
                            this.optionMenuImgView.setEnabled(true);
                            this.subItemRV.setVisibility(8);
                            this.optionMenuImgView.setImageResource(R.drawable.ic_menu_download);
                            this.optionMenuImgView.setVisibility(0);
                        } else {
                            this.subItemRV.setVisibility(8);
                            this.optionMenuImgView.setVisibility(8);
                        }
                    }
                    if (list.get(position).getFile_type().equalsIgnoreCase("3")) {
                        this.watch_now.setVisibility(0);
                        if ((list.get(position).getOpen_in_app() == null || !list.get(position).getOpen_in_app().equalsIgnoreCase("1")) && !list.get(position).getVideo_type().equalsIgnoreCase("0") && !list.get(position).getVideo_type().equalsIgnoreCase("1") && !list.get(position).getVideo_type().equalsIgnoreCase("5") && list.get(position).getVideo_type().equalsIgnoreCase("6")) {
                            this.listen_now.setVisibility(8);
                        } else {
                            this.listen_now.setVisibility(8);
                        }
                    } else {
                        this.watch_now.setVisibility(8);
                    }
                    if (list.get(position).getFile_type().equalsIgnoreCase("6") || list.get(position).getFile_type().equalsIgnoreCase("12") || list.get(position).getFile_type().equalsIgnoreCase("11") || list.get(position).getFile_type().equalsIgnoreCase("8")) {
                        this.read_now.setEnabled(true);
                        this.read_now.setVisibility(0);
                        if (list.get(position).getFile_type().equalsIgnoreCase("6")) {
                            this.read_now.setText(SingleStudyAdapter3.this.activity.getResources().getString(R.string.view_));
                        } else {
                            this.read_now.setText(SingleStudyAdapter3.this.activity.getResources().getString(R.string.read_));
                        }
                    } else {
                        this.studyitemLL.setEnabled(true);
                        this.read_now.setEnabled(false);
                        this.read_now.setVisibility(8);
                    }
                    if (list.get(position).getIs_locked().equals("0")) {
                        this.lockRL.setVisibility(8);
                    } else {
                        this.lockRL.setVisibility(0);
                        this.share.setVisibility(8);
                        this.watch_now.setVisibility(8);
                        this.listen_now.setVisibility(8);
                        this.optionMenuImgView.setVisibility(8);
                        this.read_now.setVisibility(8);
                    }
                } else {
                    this.layout_fun.setVisibility(8);
                    this.watch_now.setVisibility(8);
                    this.listen_now.setVisibility(8);
                    if (TextUtils.isEmpty(list.get(position).getCount())) {
                        this.subItemRV.setVisibility(4);
                    } else {
                        this.subItemRV.setVisibility(8);
                        this.subItemRV.setText(SingleStudyAdapter3.this.activity.getResources().getString(R.string.total_) + list.get(position).getCount());
                    }
                }
                this.share.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyListHolder$$ExternalSyntheticLambda10
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$0(position, view);
                    }
                });
                this.optionMenuImgView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3.SingleStudyListHolder.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        Lists lists = SingleStudyAdapter3.this.examPrepItem.getList().get(position);
                        if (SingleStudyAdapter3.this.is_purchase.equalsIgnoreCase("1")) {
                            if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("10") || SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("12") || SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("11")) {
                                SingleStudyAdapter3.this.videodata = SingleStudyAdapter3.this.examPrepItem.getList().get(position);
                                SingleStudyAdapter3.this.position_delete = position;
                                SingleStudyAdapter3.this.delete_meg(SingleStudyAdapter3.this.videodata);
                                return;
                            }
                            if (!VideoDownloadService.isServiceRunning) {
                                if (lists.getVideo_type().equalsIgnoreCase("6") || lists.getVideo_type().equalsIgnoreCase("7")) {
                                    if (SingleStudyAdapter3.this.downloadCount == 0) {
                                        SingleStudyAdapter3.this.videodata = lists;
                                        SingleStudyListHolder.this.downloadLibMediaVIdeo(lists, position);
                                        return;
                                    } else {
                                        Toast.makeText(SingleStudyAdapter3.this.activity, "Another download is still in progress.", 0).show();
                                        return;
                                    }
                                }
                                Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.only_jw_video_download), 0).show();
                                return;
                            }
                            Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.please_wait_downloading_is_in_progress), 0).show();
                            return;
                        }
                        if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getIs_locked().equalsIgnoreCase("1")) {
                            if (SingleStudyAdapter3.this.isCourseSoldOut()) {
                                Toast.makeText(SingleStudyAdapter3.this.activity, R.string.sold_out_msg, 0).show();
                                return;
                            }
                            Intent intent = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) PurchaseActivity.class);
                            intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter3.this.singleStudy2);
                            Helper.gotoActivity(intent, SingleStudyAdapter3.this.activity);
                            return;
                        }
                        if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("10") || SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("12") || SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("11")) {
                            SingleStudyAdapter3.this.videodata = SingleStudyAdapter3.this.examPrepItem.getList().get(position);
                            SingleStudyAdapter3.this.position_delete = position;
                            SingleStudyAdapter3.this.delete_meg(SingleStudyAdapter3.this.videodata);
                            return;
                        }
                        if (!VideoDownloadService.isServiceRunning) {
                            if (lists.getVideo_type().equalsIgnoreCase("6") || lists.getVideo_type().equalsIgnoreCase("7")) {
                                if (SingleStudyAdapter3.this.downloadCount == 0) {
                                    SingleStudyAdapter3.this.videodata = lists;
                                    SingleStudyListHolder.this.downloadLibMediaVIdeo(lists, position);
                                    return;
                                } else {
                                    Toast.makeText(SingleStudyAdapter3.this.activity, "Another download is still in progress.", 0).show();
                                    return;
                                }
                            }
                            Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.only_jw_video_download), 0).show();
                            return;
                        }
                        Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.please_wait_downloading_is_in_progress), 0).show();
                    }
                });
                this.watch_now.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyListHolder$$ExternalSyntheticLambda11
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$1(position, view);
                    }
                });
                this.listen_now.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyListHolder$$ExternalSyntheticLambda12
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$2(position, view);
                    }
                });
                this.read_now.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3.SingleStudyListHolder.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        if (((Lists) list.get(position)).getIs_locked().equalsIgnoreCase("1")) {
                            if (SingleStudyAdapter3.this.isCourseSoldOut()) {
                                Toast.makeText(SingleStudyAdapter3.this.activity, R.string.sold_out_msg, 0).show();
                                return;
                            }
                            Intent intent = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) PurchaseActivity.class);
                            intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter3.this.singleStudy2);
                            Helper.gotoActivity(intent, SingleStudyAdapter3.this.activity);
                            return;
                        }
                        if (SingleStudyAdapter3.this.is_purchase.equalsIgnoreCase("1")) {
                            if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("12")) {
                                if (SingleStudyAdapter3.this.examPrepItem.getList().size() > 0) {
                                    Intent intent2 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) RevisionActivity.class);
                                    intent2.putExtra("t_id", SingleStudyAdapter3.this.tileIdAPI);
                                    intent2.putExtra("postion", position);
                                    intent2.putExtra(Const.VIDEO_ID, SingleStudyAdapter3.this.examPrepItem.getList().get(position).getId());
                                    intent2.putExtra("v_list", ExamPrepLayer2.actual_videolist);
                                    intent2.putExtra("f_id", SingleStudyAdapter3.this.examPrepItem.getList().get(0).getId());
                                    intent2.putExtra("c_id", SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId());
                                    intent2.putExtra("title", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getTitle());
                                    intent2.putExtra("url", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_url());
                                    intent2.putExtra(Const.VIA, "main");
                                    Helper.gotoActivity(intent2, SingleStudyAdapter3.this.activity);
                                    return;
                                }
                                return;
                            }
                            if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("11")) {
                                Intent intent3 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) WebViewActivty.class);
                                intent3.putExtra("type", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getTitle());
                                intent3.putExtra("url", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_url());
                                Helper.gotoActivity(intent3, SingleStudyAdapter3.this.activity);
                                return;
                            }
                            if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("8")) {
                                Intent intent4 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) WebViewActivty.class);
                                intent4.putExtra("type", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getTitle());
                                intent4.putExtra("url", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_url());
                                if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                                    intent4.putExtra("course_id", SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD);
                                } else {
                                    intent4.putExtra("course_id", SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId());
                                }
                                intent4.putExtra(Const.VIDEO_ID, SingleStudyAdapter3.this.examPrepItem.getList().get(position).getId());
                                intent4.putExtra("link", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type());
                                Helper.gotoActivity(intent4, SingleStudyAdapter3.this.activity);
                                return;
                            }
                            if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("6")) {
                                if (TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(position).getId())) {
                                    Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.no_image_found), 0).show();
                                    return;
                                }
                                Intent intent5 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) WebViewActivty.class);
                                intent5.putExtra("type", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getTitle());
                                intent5.putExtra("url", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_url());
                                intent5.putExtra("file_type", "image");
                                Helper.gotoActivity(intent5, SingleStudyAdapter3.this.activity);
                                return;
                            }
                            return;
                        }
                        if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getIs_locked().equalsIgnoreCase("1")) {
                            if (SingleStudyAdapter3.this.isCourseSoldOut()) {
                                Toast.makeText(SingleStudyAdapter3.this.activity, R.string.sold_out_msg, 0).show();
                                return;
                            }
                            Intent intent6 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) PurchaseActivity.class);
                            intent6.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter3.this.singleStudy2);
                            Helper.gotoActivity(intent6, SingleStudyAdapter3.this.activity);
                            return;
                        }
                        if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("12")) {
                            if (SingleStudyAdapter3.this.examPrepItem.getList().size() > 0) {
                                Intent intent7 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) RevisionActivity.class);
                                intent7.putExtra("t_id", SingleStudyAdapter3.this.tileIdAPI);
                                intent7.putExtra("postion", position);
                                intent7.putExtra(Const.VIDEO_ID, SingleStudyAdapter3.this.examPrepItem.getList().get(position).getId());
                                intent7.putExtra("v_list", ExamPrepLayer2.actual_videolist);
                                intent7.putExtra("f_id", SingleStudyAdapter3.this.examPrepItem.getList().get(0).getId());
                                intent7.putExtra("c_id", SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId());
                                intent7.putExtra("title", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getTitle());
                                intent7.putExtra("url", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_url());
                                intent7.putExtra(Const.VIA, "main");
                                Helper.gotoActivity(intent7, SingleStudyAdapter3.this.activity);
                                return;
                            }
                            return;
                        }
                        if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("11")) {
                            Intent intent8 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) WebViewActivty.class);
                            intent8.putExtra("type", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getTitle());
                            intent8.putExtra("url", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_url());
                            Helper.gotoActivity(intent8, SingleStudyAdapter3.this.activity);
                            return;
                        }
                        if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("8")) {
                            Intent intent9 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) WebViewActivty.class);
                            intent9.putExtra("type", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getTitle());
                            intent9.putExtra("url", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_url());
                            if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                                intent9.putExtra("course_id", SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD);
                            } else {
                                intent9.putExtra("course_id", SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId());
                            }
                            intent9.putExtra(Const.VIDEO_ID, SingleStudyAdapter3.this.examPrepItem.getList().get(position).getId());
                            intent9.putExtra("link", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type());
                            Helper.gotoActivity(intent9, SingleStudyAdapter3.this.activity);
                            return;
                        }
                        if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("6")) {
                            if (TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(position).getId())) {
                                Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.no_image_found), 0).show();
                                return;
                            }
                            Intent intent10 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) WebViewActivty.class);
                            intent10.putExtra("type", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getTitle());
                            intent10.putExtra("url", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_url());
                            intent10.putExtra("file_type", "image");
                            Helper.gotoActivity(intent10, SingleStudyAdapter3.this.activity);
                        }
                    }
                });
                this.studyitemLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyListHolder$$ExternalSyntheticLambda13
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$3(list, position, view);
                    }
                });
                if (Helper.isShowShareButton(this.leftMenu)) {
                    this.share.setVisibility(0);
                    return;
                } else {
                    this.share.setVisibility(8);
                    return;
                }
            }
            this.ibt_single_sub_vd_RL.setVisibility(8);
            this.no_data_found_RL.setVisibility(0);
            this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3.SingleStudyListHolder.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    SingleStudyAdapter3.this.activity.finish();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$0(int i, View view) {
            if (SingleStudyAdapter3.this.is_purchase.equalsIgnoreCase("1")) {
                if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_type().equalsIgnoreCase("8") || SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_type().equalsIgnoreCase("7") || SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_type().equalsIgnoreCase("1")) {
                    Helper.sharePdf(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getCourse_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTopic_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_type(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getRevert_api(), Const.PDF, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getThumbnail_url(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getTitle(), SingleStudy.parentCourseId);
                    return;
                }
                if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVideo_type().equalsIgnoreCase("4") || SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVideo_type().equalsIgnoreCase("1") || SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVideo_type().equalsIgnoreCase("7") || SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVideo_type().equalsIgnoreCase("8")) {
                    Helper.shareLiveClass(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getCourse_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTopic_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_type(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getRevert_api(), "video", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getThumbnail_url(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getTitle(), SingleStudy.parentCourseId, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getIs_locked());
                    return;
                } else {
                    if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVideo_type().equalsIgnoreCase("6")) {
                        Helper.sharejwvideo(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getCourse_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTopic_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_type(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getRevert_api(), "video", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getThumbnail_url(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getTitle(), SingleStudy.parentCourseId);
                        return;
                    }
                    return;
                }
            }
            if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter3.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter3.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter3.this.singleStudy2);
                Helper.gotoActivity(intent, SingleStudyAdapter3.this.activity);
                return;
            }
            if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_type().equalsIgnoreCase("8") || SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_type().equalsIgnoreCase("7") || SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_type().equalsIgnoreCase("1")) {
                Helper.sharePdf(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getCourse_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTopic_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_type(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getRevert_api(), Const.PDF, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getThumbnail_url(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getTitle(), SingleStudy.parentCourseId);
                return;
            }
            if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVideo_type().equalsIgnoreCase("4") || SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVideo_type().equalsIgnoreCase("1") || SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVideo_type().equalsIgnoreCase("7") || SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVideo_type().equalsIgnoreCase("8")) {
                Helper.shareLiveClass(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getCourse_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTopic_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_type(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getRevert_api(), "video", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getThumbnail_url(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getTitle(), SingleStudy.parentCourseId, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getIs_locked());
            } else if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVideo_type().equalsIgnoreCase("6")) {
                Helper.sharejwvideo(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getCourse_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTopic_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_type(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getRevert_api(), "video", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getThumbnail_url(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getTitle(), SingleStudy.parentCourseId);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$1(int i, View view) {
            if (SingleStudyAdapter3.this.is_purchase.equalsIgnoreCase("1")) {
                if (TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId())) {
                    Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.no_video_found), 0).show();
                    return;
                }
                Helper.audio_service_close((CourseActivity) SingleStudyAdapter3.this.activity);
                SingleStudyAdapter3 singleStudyAdapter3 = SingleStudyAdapter3.this;
                singleStudyAdapter3.API_REQUEST_VIDEO_LINK(singleStudyAdapter3.examPrepItem.getList().get(i), i);
                return;
            }
            if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter3.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter3.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter3.this.singleStudy2);
                Helper.gotoActivity(intent, SingleStudyAdapter3.this.activity);
                return;
            }
            if (TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId())) {
                Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.no_video_found), 0).show();
                return;
            }
            Helper.audio_service_close((CourseActivity) SingleStudyAdapter3.this.activity);
            SingleStudyAdapter3 singleStudyAdapter32 = SingleStudyAdapter3.this;
            singleStudyAdapter32.API_REQUEST_VIDEO_LINK(singleStudyAdapter32.examPrepItem.getList().get(i), i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$2(int i, View view) {
            if (Helper.isNetworkConnected(SingleStudyAdapter3.this.activity)) {
                if (SingleStudyAdapter3.this.is_purchase.equalsIgnoreCase("1")) {
                    if (TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId())) {
                        Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.no_video_found), 0).show();
                        return;
                    }
                    Helper.audio_service_close((CourseActivity) SingleStudyAdapter3.this.activity);
                    if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVideo_type().equalsIgnoreCase("6")) {
                        String str = "https://cdn.jwplayer.com/v2/media/" + SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_url().substring(SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_url().lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_url().indexOf("-"));
                        SingleStudyAdapter3 singleStudyAdapter3 = SingleStudyAdapter3.this;
                        singleStudyAdapter3.audio_play(str, singleStudyAdapter3.examPrepItem.getList().get(i));
                        return;
                    }
                    if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVideo_type().equalsIgnoreCase("1")) {
                        Helper.GoToLiveVideoActivity(SingleStudyAdapter3.this.examPrepItem.getList().get(i).getChat_node(), SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_url(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVideo_type(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getTitle(), "1", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getThumbnail_url(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getIs_chat_lock(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getCourse_id(), String.valueOf(i), SingleStudy.parentCourseId, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_type(), new ArrayList());
                        return;
                    }
                    if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVideo_type().equalsIgnoreCase("5")) {
                        if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getLive_status().equalsIgnoreCase("1")) {
                            Helper.GoToLiveAwsVideoActivity(SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVideo_type(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getChat_node(), SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_url(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVideo_type(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getTitle(), "1", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getThumbnail_url(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getCourse_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_type(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getStart_date(), new ArrayList());
                            return;
                        }
                        if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getLive_status().equalsIgnoreCase("0")) {
                            Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(SingleStudyAdapter3.this.examPrepItem.getList().get(i).getStart_date()) * 1000)), 0).show();
                            return;
                        } else if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getLive_status().equalsIgnoreCase("2")) {
                            Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                            return;
                        } else {
                            if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getLive_status().equalsIgnoreCase("3")) {
                                Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                                return;
                            }
                            return;
                        }
                    }
                    if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVideo_type().equalsIgnoreCase("0")) {
                        Helper.GoToLiveAwsVideoActivity(SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVideo_type(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getChat_node(), SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_url(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVideo_type(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getTitle(), "1", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getThumbnail_url(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getCourse_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_type(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getStart_date(), new ArrayList());
                        return;
                    }
                    if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVideo_type().equalsIgnoreCase("7")) {
                        if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getIs_drm().equals("0")) {
                            if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId() == null || SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId().equalsIgnoreCase("")) {
                                Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                                return;
                            } else {
                                Helper.GoToLiveAwsVideoActivity(SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVideo_type(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getChat_node(), SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVideo_type(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getTitle(), "1", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getThumbnail_url(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getCourse_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_type(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getStart_date(), new ArrayList());
                                return;
                            }
                        }
                        if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getIs_drm().equals("1")) {
                            if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId() == null || SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId().equalsIgnoreCase("")) {
                                Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                                return;
                            } else {
                                Helper.GoToVideoCryptActivity(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVideo_type(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getChat_node(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVideo_type(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getTitle(), "1", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getThumbnail_url(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getCourse_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_type(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getStart_date(), "0", new ArrayList());
                                return;
                            }
                        }
                        return;
                    }
                    if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVideo_type().equalsIgnoreCase("8")) {
                        if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getIs_drm().equals("0")) {
                            if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getLive_status().equalsIgnoreCase("1")) {
                                if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId() == null || SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId().equalsIgnoreCase("")) {
                                    Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                                    return;
                                } else {
                                    Helper.GoToLiveAwsVideoActivity(SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVideo_type(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getChat_node(), SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVideo_type(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getTitle(), "1", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getThumbnail_url(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getCourse_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_type(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getStart_date(), new ArrayList());
                                    return;
                                }
                            }
                            if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getLive_status().equalsIgnoreCase("0")) {
                                Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(SingleStudyAdapter3.this.examPrepItem.getList().get(i).getStart_date()) * 1000)), 0).show();
                                return;
                            } else if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getLive_status().equalsIgnoreCase("2")) {
                                Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                                return;
                            } else {
                                if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getLive_status().equalsIgnoreCase("3")) {
                                    Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                                    return;
                                }
                                return;
                            }
                        }
                        if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getIs_drm().equals("1")) {
                            if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getLive_status().equalsIgnoreCase("1")) {
                                if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId() == null || SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId().equalsIgnoreCase("")) {
                                    Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                                    return;
                                } else {
                                    Helper.GoToVideoCryptActivity(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVideo_type(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getChat_node(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVideo_type(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getTitle(), "1", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getThumbnail_url(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getCourse_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_type(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getStart_date(), "0", new ArrayList());
                                    return;
                                }
                            }
                            if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getLive_status().equalsIgnoreCase("0")) {
                                Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(SingleStudyAdapter3.this.examPrepItem.getList().get(i).getStart_date()) * 1000)), 0).show();
                                return;
                            } else if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getLive_status().equalsIgnoreCase("2")) {
                                Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                                return;
                            } else {
                                if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getLive_status().equalsIgnoreCase("3")) {
                                    Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getIs_locked().equalsIgnoreCase("1")) {
                    if (SingleStudyAdapter3.this.isCourseSoldOut()) {
                        Toast.makeText(SingleStudyAdapter3.this.activity, R.string.sold_out_msg, 0).show();
                        return;
                    }
                    Intent intent = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) PurchaseActivity.class);
                    intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter3.this.singleStudy2);
                    Helper.gotoActivity(intent, SingleStudyAdapter3.this.activity);
                    return;
                }
                if (TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId())) {
                    Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.no_video_found), 0).show();
                    return;
                }
                Helper.audio_service_close((CourseActivity) SingleStudyAdapter3.this.activity);
                if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVideo_type().equalsIgnoreCase("6")) {
                    String str2 = "https://cdn.jwplayer.com/v2/media/" + SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_url().substring(SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_url().lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_url().indexOf("-"));
                    SingleStudyAdapter3 singleStudyAdapter32 = SingleStudyAdapter3.this;
                    singleStudyAdapter32.audio_play(str2, singleStudyAdapter32.examPrepItem.getList().get(i));
                    return;
                } else if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVideo_type().equalsIgnoreCase("1")) {
                    Helper.GoToLiveVideoActivity(SingleStudyAdapter3.this.examPrepItem.getList().get(i).getChat_node(), SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_url(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVideo_type(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getTitle(), "1", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getThumbnail_url(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getIs_chat_lock(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getCourse_id(), String.valueOf(i), SingleStudy.parentCourseId, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_type(), new ArrayList());
                    return;
                } else {
                    if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVideo_type().equalsIgnoreCase("5")) {
                        Helper.GoToLiveAwsVideoActivity(SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVideo_type(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getChat_node(), SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_url(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getVideo_type(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getTitle(), "1", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getThumbnail_url(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getCourse_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_type(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getStart_date(), new ArrayList());
                        return;
                    }
                    return;
                }
            }
            Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$3(ArrayList arrayList, int i, View view) {
            this.studyitemLL.setFocusable(true);
            this.studyitemLL.setClickable(true);
            this.studyitemLL.setBackgroundDrawable(SingleStudyAdapter3.this.activity.getResources().getDrawable(R.drawable.nav_ripple));
            if (((Lists) arrayList.get(i)).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter3.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter3.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter3.this.singleStudy2);
                Helper.gotoActivity(intent, SingleStudyAdapter3.this.activity);
                return;
            }
            if (SingleStudyAdapter3.this.isSkip.equalsIgnoreCase("1") || SingleStudyAdapter3.this.isSkip.equalsIgnoreCase("2")) {
                Intent intent2 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) CourseActivity.class);
                SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(SingleStudyAdapter3.this.singleStudy2 != null ? SingleStudyAdapter3.this.singleStudy2 : new CourseDetail()));
                SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(SingleStudyAdapter3.this.examPrepItem != null ? SingleStudyAdapter3.this.examPrepItem : new ExamPrepItem()));
                SharedPreference.getInstance().putString("list", new Gson().toJson(SingleStudyAdapter3.this.examPrepItem.getList().get(i) != null ? SingleStudyAdapter3.this.examPrepItem.getList().get(i) : new Lists()));
                intent2.putExtra(Const.FRAG_TYPE, Const.EXAMPREPLAST);
                intent2.putExtra(Const.IS_COMBO, SingleStudyAdapter3.this.isCombo);
                intent2.putExtra(Const.LIST_SUBJECT, SingleStudyAdapter3.this.examPrepItem.getList().get(i));
                if (SingleStudyAdapter3.this.mainCourseId.equals("455") || SingleStudyAdapter3.this.tileTypeAPI.equals(Const.COMBO) || SingleStudyAdapter3.this.tileTypeAPI.equals("content")) {
                    intent2.putExtra(Const.TAB_TILE_VISIBILITY, "1");
                } else {
                    intent2.putExtra(Const.TAB_TILE_VISIBILITY, "0");
                }
                intent2.putExtra("title", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getTitle());
                intent2.putExtra("content_type", SingleStudyAdapter3.this.contentType);
                intent2.putExtra(Const.TEST_TYPE, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getCount());
                intent2.putExtra("tile_id", SingleStudyAdapter3.this.tileIdAPI);
                intent2.putExtra(Const.TILE_TYPE, SingleStudyAdapter3.this.tileTypeAPI);
                intent2.putExtra(Const.REVERT_API, SingleStudyAdapter3.this.revertAPI);
                Helper.gotoActivity(intent2, SingleStudyAdapter3.this.activity);
                return;
            }
            if (SingleStudyAdapter3.this.isSkip.equalsIgnoreCase("3")) {
                if (SingleStudyAdapter3.this.is_purchase.equalsIgnoreCase("1")) {
                    if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_type().equalsIgnoreCase("12")) {
                        if (SingleStudyAdapter3.this.examPrepItem.getList().size() > 0) {
                            Intent intent3 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) RevisionActivity.class);
                            intent3.putExtra("t_id", SingleStudyAdapter3.this.tileIdAPI);
                            intent3.putExtra("postion", i);
                            intent3.putExtra(Const.VIDEO_ID, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId());
                            intent3.putExtra("v_list", ExamPrepLayer2.actual_videolist);
                            intent3.putExtra("f_id", SingleStudyAdapter3.this.examPrepItem.getList().get(0).getId());
                            intent3.putExtra("c_id", SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId());
                            intent3.putExtra("title", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getTitle());
                            intent3.putExtra("url", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_url());
                            intent3.putExtra(Const.VIA, "main");
                            Helper.gotoActivity(intent3, SingleStudyAdapter3.this.activity);
                            return;
                        }
                        return;
                    }
                    if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_type().equalsIgnoreCase("11")) {
                        Intent intent4 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) WebViewActivty.class);
                        intent4.putExtra("type", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getTitle());
                        intent4.putExtra("url", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_url());
                        Helper.gotoActivity(intent4, SingleStudyAdapter3.this.activity);
                        return;
                    }
                    if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_type().equalsIgnoreCase("8")) {
                        Intent intent5 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) WebViewActivty.class);
                        intent5.putExtra("type", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getTitle());
                        intent5.putExtra("url", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_url());
                        if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                            intent5.putExtra("course_id", SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD);
                        } else {
                            intent5.putExtra("course_id", SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId());
                        }
                        intent5.putExtra(Const.VIDEO_ID, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId());
                        intent5.putExtra("link", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_type());
                        Helper.gotoActivity(intent5, SingleStudyAdapter3.this.activity);
                        return;
                    }
                    if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_type().equalsIgnoreCase("6")) {
                        if (TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId())) {
                            Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.no_image_found), 0).show();
                            return;
                        }
                        Intent intent6 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) WebViewActivty.class);
                        intent6.putExtra("type", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getTitle());
                        intent6.putExtra("url", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_url());
                        intent6.putExtra("file_type", "image");
                        Helper.gotoActivity(intent6, SingleStudyAdapter3.this.activity);
                        return;
                    }
                    return;
                }
                if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getIs_locked().equalsIgnoreCase("1")) {
                    if (SingleStudyAdapter3.this.isCourseSoldOut()) {
                        Toast.makeText(SingleStudyAdapter3.this.activity, R.string.sold_out_msg, 0).show();
                        return;
                    }
                    Intent intent7 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) PurchaseActivity.class);
                    intent7.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter3.this.singleStudy2);
                    Helper.gotoActivity(intent7, SingleStudyAdapter3.this.activity);
                    return;
                }
                if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_type().equalsIgnoreCase("12")) {
                    if (SingleStudyAdapter3.this.examPrepItem.getList().size() > 0) {
                        Intent intent8 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) RevisionActivity.class);
                        intent8.putExtra("t_id", SingleStudyAdapter3.this.tileIdAPI);
                        intent8.putExtra("postion", i);
                        intent8.putExtra(Const.VIDEO_ID, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId());
                        intent8.putExtra("v_list", ExamPrepLayer2.actual_videolist);
                        intent8.putExtra("f_id", SingleStudyAdapter3.this.examPrepItem.getList().get(0).getId());
                        intent8.putExtra("c_id", SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId());
                        intent8.putExtra("title", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getTitle());
                        intent8.putExtra("url", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_url());
                        intent8.putExtra(Const.VIA, "main");
                        Helper.gotoActivity(intent8, SingleStudyAdapter3.this.activity);
                        return;
                    }
                    return;
                }
                if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_type().equalsIgnoreCase("11")) {
                    Intent intent9 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) WebViewActivty.class);
                    intent9.putExtra("type", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getTitle());
                    intent9.putExtra("url", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_url());
                    Helper.gotoActivity(intent9, SingleStudyAdapter3.this.activity);
                    return;
                }
                if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_type().equalsIgnoreCase("8")) {
                    Intent intent10 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) WebViewActivty.class);
                    intent10.putExtra("type", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getTitle());
                    intent10.putExtra("url", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_url());
                    if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                        intent10.putExtra("course_id", SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD);
                    } else {
                        intent10.putExtra("course_id", SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId());
                    }
                    intent10.putExtra(Const.VIDEO_ID, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId());
                    intent10.putExtra("link", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_type());
                    Helper.gotoActivity(intent10, SingleStudyAdapter3.this.activity);
                    return;
                }
                if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_type().equalsIgnoreCase("6")) {
                    if (TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId())) {
                        Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.no_image_found), 0).show();
                        return;
                    }
                    Intent intent11 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) WebViewActivty.class);
                    intent11.putExtra("type", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getTitle());
                    intent11.putExtra("url", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_url());
                    intent11.putExtra("file_type", "image");
                    Helper.gotoActivity(intent11, SingleStudyAdapter3.this.activity);
                    return;
                }
                if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_type().equalsIgnoreCase("3")) {
                    if (SingleStudyAdapter3.this.is_purchase.equalsIgnoreCase("1")) {
                        if (TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId())) {
                            Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.no_video_found), 0).show();
                            return;
                        }
                        Helper.audio_service_close((CourseActivity) SingleStudyAdapter3.this.activity);
                        SingleStudyAdapter3 singleStudyAdapter3 = SingleStudyAdapter3.this;
                        singleStudyAdapter3.API_REQUEST_VIDEO_LINK(singleStudyAdapter3.examPrepItem.getList().get(i), i);
                        return;
                    }
                    if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getIs_locked().equalsIgnoreCase("1")) {
                        if (SingleStudyAdapter3.this.isCourseSoldOut()) {
                            Toast.makeText(SingleStudyAdapter3.this.activity, R.string.sold_out_msg, 0).show();
                            return;
                        }
                        Intent intent12 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) PurchaseActivity.class);
                        intent12.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter3.this.singleStudy2);
                        Helper.gotoActivity(intent12, SingleStudyAdapter3.this.activity);
                        return;
                    }
                    if (TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId())) {
                        Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.no_video_found), 0).show();
                        return;
                    }
                    Helper.audio_service_close((CourseActivity) SingleStudyAdapter3.this.activity);
                    SingleStudyAdapter3 singleStudyAdapter32 = SingleStudyAdapter3.this;
                    singleStudyAdapter32.API_REQUEST_VIDEO_LINK(singleStudyAdapter32.examPrepItem.getList().get(i), i);
                    return;
                }
                return;
            }
            ExamPrepItem examPrepItem = new ExamPrepItem();
            examPrepItem.setList(SingleStudyAdapter3.this.examPrepItem.getList().get(i).getList());
            Intent intent13 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) CourseActivity.class);
            SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(SingleStudyAdapter3.this.singleStudy2 != null ? SingleStudyAdapter3.this.singleStudy2 : new CourseDetail()));
            SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(examPrepItem));
            SharedPreference.getInstance().putString("list", new Gson().toJson(arrayList.get(i) != null ? arrayList.get(i) : new Lists()));
            intent13.putExtra(Const.FRAG_TYPE, Const.EXAMPREP);
            intent13.putExtra(Const.IS_COMBO, SingleStudyAdapter3.this.isCombo);
            intent13.putExtra("content_type", SingleStudyAdapter3.this.contentType);
            if (SingleStudyAdapter3.this.mainCourseId.equals("455") || SingleStudyAdapter3.this.tileTypeAPI.equals(Const.COMBO) || SingleStudyAdapter3.this.tileTypeAPI.equals("content")) {
                intent13.putExtra(Const.TAB_TILE_VISIBILITY, "1");
            } else {
                intent13.putExtra(Const.TAB_TILE_VISIBILITY, "0");
            }
            intent13.putExtra("title", SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail() != null ? SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getTitle() : "Course");
            intent13.putExtra("tile_id", SingleStudyAdapter3.this.tileIdAPI);
            intent13.putExtra(Const.TILE_TYPE, SingleStudyAdapter3.this.tileTypeAPI);
            intent13.putExtra(Const.REVERT_API, SingleStudyAdapter3.this.revertAPI);
            Helper.gotoActivity(intent13, SingleStudyAdapter3.this.activity);
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

        /* JADX INFO: Access modifiers changed from: private */
        public void downloadLibMediaVIdeo(final Lists video, final int position) {
            final Dialog dialog = new Dialog(SingleStudyAdapter3.this.activity);
            dialog.setCancelable(false);
            dialog.requestWindowFeature(1);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
            dialog.setContentView(R.layout.dialog_alert_simple);
            ((TextView) dialog.findViewById(R.id.titleDialog)).setText("Download Video?");
            ((TextView) dialog.findViewById(R.id.msgDialog)).setText(video.getTitle() + ".\nThis video will be downloaded in your My downloads.\n");
            Button button = (Button) dialog.findViewById(R.id.btn_cancel);
            button.setText("CANCEL");
            Button button2 = (Button) dialog.findViewById(R.id.btn_submit);
            button2.setText("DOWNLOAD");
            button2.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyListHolder$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$downloadLibMediaVIdeo$4(video, position, dialog);
                }
            }));
            button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyListHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            dialog.show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$downloadLibMediaVIdeo$4(Lists lists, int i, Dialog dialog) {
            if (SingleStudyAdapter3.this.is_purchase.equalsIgnoreCase("1")) {
                this.optionMenuImgView.setEnabled(false);
                downloadServiceLibMedia(lists, i);
            } else {
                Toast.makeText(SingleStudyAdapter3.this.activity, "This feature is only available for courses in your library ", 0).show();
            }
            dialog.dismiss();
            dialog.cancel();
            return null;
        }

        private void downloadServiceLibMedia(Lists video, int position) {
            String str;
            this.videosDownload = new VideosDownload();
            if (SingleStudyAdapter3.this.utkashRoom.getvideoDownloadao().isvideo_exit(video.getId(), MakeMyExam.userId)) {
                VideosDownload videosDownload = SingleStudyAdapter3.this.utkashRoom.getvideoDownloadao().getvideo_byuserid(video.getId(), MakeMyExam.userId);
                this.videosDownload = videosDownload;
                videosDownload.setVideo_status("Download Running");
                this.videosDownload.setThumbnail_url(video.getThumbnail_url());
            } else {
                this.videosDownload.setVideo_id(video.getId());
                this.videosDownload.setThumbnail_url(video.getThumbnail_url());
                if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                    str = SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD;
                } else {
                    str = SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId();
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
                this.videosDownload.setTile_id(SingleStudyAdapter3.this.tileIdAPI);
            }
            if (SingleStudyAdapter3.this.progress.isShowing()) {
                SingleStudyAdapter3.this.progress.dismiss();
            }
            if (video.getBitrate_urls() != null && video.getBitrate_urls().size() > 0) {
                openwatchlist_dailog_resource(SingleStudyAdapter3.this.activity, video.getBitrate_urls(), this.videosDownload, position);
            } else {
                this.optionMenuImgView.setEnabled(true);
            }
        }

        public void openwatchlist_dailog_resource(Context context, final ArrayList<UrlObject> mediaResponseMap, final VideosDownload videosDownload, final int pos) {
            try {
                if (SingleStudyAdapter3.this.progress.isShowing()) {
                    SingleStudyAdapter3.this.progress.dismiss();
                }
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
                ((TextView) Objects.requireNonNull(textView2)).setText(videosDownload.getVideo_name());
                this.optionMenuImgView.setEnabled(true);
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
                ((TextView) Objects.requireNonNull(textView)).setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyListHolder$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$openwatchlist_dailog_resource$7(pos, bottomSheetDialog, videosDownload, mediaResponseMap);
                    }
                }));
                ((TextView) Objects.requireNonNull(textView3)).setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyListHolder$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$openwatchlist_dailog_resource$9(pos, bottomSheetDialog, videosDownload, mediaResponseMap);
                    }
                }));
                ((TextView) Objects.requireNonNull(textView4)).setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyListHolder$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$openwatchlist_dailog_resource$11(pos, bottomSheetDialog, videosDownload, mediaResponseMap);
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
        public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$7(final int i, BottomSheetDialog bottomSheetDialog, final VideosDownload videosDownload, final ArrayList arrayList) {
            this.optionMenuImgView.setEnabled(false);
            SingleStudyAdapter3.this.examPrepItem.getList().get(i).setVideo_status("Download Running");
            SingleStudyAdapter3.this.dismissCalculatorDialog(bottomSheetDialog);
            AsyncTask.execute(new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyListHolder$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$openwatchlist_dailog_resource$6(videosDownload, arrayList, i);
                }
            });
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$openwatchlist_dailog_resource$6(VideosDownload videosDownload, ArrayList arrayList, int i) {
            if (SingleStudyAdapter3.this.utkashRoom.getvideoDownloadao().isvideo_exit(videosDownload.getVideo_id(), MakeMyExam.userId)) {
                SingleStudyAdapter3.this.utkashRoom.getvideoDownloadao().update_videostatus(videosDownload.getVideo_id(), videosDownload.getVideo_status(), MakeMyExam.userId);
            } else {
                SingleStudyAdapter3.this.utkashRoom.getvideoDownloadao().addUser(videosDownload);
            }
            this.videoDownloadUrl = ((UrlObject) arrayList.get(0)).getUrl();
            Download_dialog(((UrlObject) arrayList.get(0)).getUrl(), videosDownload, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$9(final int i, BottomSheetDialog bottomSheetDialog, final VideosDownload videosDownload, final ArrayList arrayList) {
            this.optionMenuImgView.setEnabled(false);
            SingleStudyAdapter3.this.examPrepItem.getList().get(i).setVideo_status("Download Running");
            SingleStudyAdapter3.this.dismissCalculatorDialog(bottomSheetDialog);
            AsyncTask.execute(new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyListHolder$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$openwatchlist_dailog_resource$8(videosDownload, arrayList, i);
                }
            });
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$openwatchlist_dailog_resource$8(VideosDownload videosDownload, ArrayList arrayList, int i) {
            if (SingleStudyAdapter3.this.utkashRoom.getvideoDownloadao().isvideo_exit(videosDownload.getVideo_id(), MakeMyExam.userId)) {
                SingleStudyAdapter3.this.utkashRoom.getvideoDownloadao().update_videostatus(videosDownload.getVideo_id(), videosDownload.getVideo_status(), MakeMyExam.userId);
            } else {
                SingleStudyAdapter3.this.utkashRoom.getvideoDownloadao().addUser(videosDownload);
            }
            this.videoDownloadUrl = ((UrlObject) arrayList.get(1)).getUrl();
            Download_dialog(((UrlObject) arrayList.get(1)).getUrl(), videosDownload, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$11(final int i, BottomSheetDialog bottomSheetDialog, final VideosDownload videosDownload, final ArrayList arrayList) {
            this.optionMenuImgView.setEnabled(false);
            SingleStudyAdapter3.this.examPrepItem.getList().get(i).setVideo_status("Download Running");
            SingleStudyAdapter3.this.dismissCalculatorDialog(bottomSheetDialog);
            AsyncTask.execute(new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyListHolder$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$openwatchlist_dailog_resource$10(videosDownload, arrayList, i);
                }
            });
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$openwatchlist_dailog_resource$10(VideosDownload videosDownload, ArrayList arrayList, int i) {
            if (SingleStudyAdapter3.this.utkashRoom.getvideoDownloadao().isvideo_exit(videosDownload.getVideo_id(), MakeMyExam.userId)) {
                SingleStudyAdapter3.this.utkashRoom.getvideoDownloadao().update_videostatus(videosDownload.getVideo_id(), videosDownload.getVideo_status(), MakeMyExam.userId);
            } else {
                SingleStudyAdapter3.this.utkashRoom.getvideoDownloadao().addUser(videosDownload);
            }
            this.videoDownloadUrl = ((UrlObject) arrayList.get(2)).getUrl();
            Download_dialog(((UrlObject) arrayList.get(2)).getUrl(), videosDownload, i);
        }

        private void Download_dialog(String url, final VideosDownload videosDownload, int position) {
            if (SingleStudyAdapter3.this.utkashRoom.getvideoDownloadao().getuser(videosDownload.getVideo_id(), videosDownload.getIs_complete()).getToal_downloadlocale() != null && SingleStudyAdapter3.this.utkashRoom.getvideoDownloadao().getuser(videosDownload.getVideo_id(), videosDownload.getIs_complete()).getToal_downloadlocale().longValue() == 0) {
                SingleStudyAdapter3.this.utkashRoom.getvideoDownloadao().update_pos(MakeMyExam.userId, videosDownload.getVideo_id(), SingleStudyAdapter3.this.utkashRoom.getvideoDownloadao().getalldownload_videos(MakeMyExam.userId).size() - 1);
                Intent intent = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) VideoDownloadService.class);
                intent.putExtra(VideoDownloadService.FILEDOWNLOADSTATUS, false);
                intent.putExtra(VideoDownloadService.URL, url);
                intent.putExtra(VideoDownloadService.DOWNLOAD_SERVICE_ID, videosDownload.getVideo_id());
                intent.putExtra(VideoDownloadService.FILEPATH, videosDownload.getVideo_name());
                intent.putExtra("name", videosDownload.getVideo_history());
                intent.putExtra(Constants.INAPP_POSITION, SingleStudyAdapter3.this.utkashRoom.getvideoDownloadao().getalldownload_videos(MakeMyExam.userId).size() - 1);
                intent.putExtra("status", videosDownload.getVideo_status());
                VideoDownloadService.isServiceRunning = true;
                Helper.startVideoDownloadService(SingleStudyAdapter3.this.activity, intent);
                SingleStudyAdapter3.this.pushEventForDownload(videosDownload);
            }
            SingleStudyAdapter3.this.activity.runOnUiThread(new Runnable() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyListHolder$$ExternalSyntheticLambda9
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
            final Dialog dialog = new Dialog(SingleStudyAdapter3.this.activity);
            dialog.setCancelable(false);
            dialog.requestWindowFeature(1);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
            dialog.setContentView(R.layout.dialog_alert_downloads);
            ((TextView) dialog.findViewById(R.id.titleDialog)).setText("Video");
            ((TextView) dialog.findViewById(R.id.msgDialog)).setText(video_name);
            Button button = (Button) dialog.findViewById(R.id.btn_cancel);
            ((Button) dialog.findViewById(R.id.btn_submit)).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyListHolder$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$waiting_dialog$13(dialog, view);
                }
            });
            button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyListHolder$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SingleStudyAdapter3.SingleStudyListHolder.lambda$waiting_dialog$14(dialog, view);
                }
            });
            dialog.show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$waiting_dialog$13(Dialog dialog, View view) {
            Helper.gotoActivity(new Intent(SingleStudyAdapter3.this.activity, (Class<?>) DownloadActivity.class), SingleStudyAdapter3.this.activity);
            SingleStudyAdapter3.this.activity.finish();
            dialog.dismiss();
            dialog.cancel();
        }

        static /* synthetic */ void lambda$waiting_dialog$14(Dialog dialog, View view) {
            dialog.dismiss();
            dialog.cancel();
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
            this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$StudyNoDataViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setData$0(view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$0(View view) {
            SingleStudyAdapter3.this.activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delete_meg(Lists video) {
        final Dialog dialog = new Dialog(this.activity);
        dialog.setCancelable(false);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
        dialog.setContentView(R.layout.dialog_alert_simple);
        ((TextView) dialog.findViewById(R.id.titleDialog)).setVisibility(8);
        ((TextView) dialog.findViewById(R.id.msgDialog)).setText(this.activity.getResources().getString(R.string.do_you_want_to_delete) + video.getTitle());
        Button button = (Button) dialog.findViewById(R.id.btn_cancel);
        button.setText(this.activity.getResources().getString(R.string.no));
        Button button2 = (Button) dialog.findViewById(R.id.btn_submit);
        button2.setText(this.activity.getResources().getString(R.string.yes));
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$delete_meg$0(dialog, view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$delete_meg$0(Dialog dialog, View view) {
        new NetworkCall(this, this.activity).NetworkAPICall(API.delete_revision, "", true, false);
        dialog.dismiss();
        dialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void download_data(final Lists lists, final int position) {
        final Dialog dialog = new Dialog(this.activity);
        dialog.setCancelable(false);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
        dialog.setContentView(R.layout.dialog_alert_simple);
        ((TextView) dialog.findViewById(R.id.titleDialog)).setText(this.activity.getResources().getString(R.string.download_video));
        ((TextView) dialog.findViewById(R.id.msgDialog)).setText(lists.getTitle() + this.activity.getResources().getString(R.string.this_video_will_be_downloaded_in_your_my_downloads));
        Button button = (Button) dialog.findViewById(R.id.btn_cancel);
        button.setText(this.activity.getResources().getString(R.string.cancel));
        Button button2 = (Button) dialog.findViewById(R.id.btn_submit);
        button2.setText(this.activity.getResources().getString(R.string.download_));
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$download_data$2(lists, position, dialog, view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$download_data$2(Lists lists, int i, Dialog dialog, View view) {
        if (this.is_purchase.equalsIgnoreCase("1")) {
            download_service(lists, i);
        } else {
            Activity activity = this.activity;
            Toast.makeText(activity, activity.getResources().getString(R.string.this_feature_is_only_available_for_courses_in_your_library), 0).show();
        }
        dialog.dismiss();
        dialog.cancel();
    }

    private void download_service(Lists video, int position) {
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
                str = this.singleStudy2.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD;
            } else {
                str = SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + this.singleStudy2.getData().getCourseDetail().getId();
            }
            videosDownload.setVideo_name(video.getTitle());
            videosDownload.setToal_downloadlocale(0L);
            videosDownload.setPercentage(0);
            videosDownload.setOriginalFileLengthString("0");
            videosDownload.setLengthInMb("");
            videosDownload.setVideo_history(video.getId() + "_" + MakeMyExam.userId + "_" + video.getFile_url().substring(video.getFile_url().lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1, video.getFile_url().indexOf("-")) + "_" + str);
            videosDownload.setCourse_id(str);
            videosDownload.setIs_complete("0");
            videosDownload.setVideo_status("Download Running");
            videosDownload.setUser_id(MakeMyExam.userId);
            videosDownload.setVideoCurrentPosition(0L);
        }
        if (video.getBitrate_urls() == null || video.getBitrate_urls().size() <= 0) {
            return;
        }
        openwatchlist_dailog_resource(this.activity, video.getBitrate_urls(), videosDownload, position);
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
            ((TextView) Objects.requireNonNull(textView)).setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$openwatchlist_dailog_resource$4(pos, videosDownload, mediaResponseMap, bottomSheetDialog);
                }
            }));
            ((TextView) Objects.requireNonNull(textView3)).setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$openwatchlist_dailog_resource$5(pos, videosDownload, mediaResponseMap, bottomSheetDialog);
                }
            }));
            ((TextView) Objects.requireNonNull(textView4)).setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$openwatchlist_dailog_resource$6(pos, videosDownload, mediaResponseMap, bottomSheetDialog);
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
    public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$4(int i, VideosDownload videosDownload, ArrayList arrayList, BottomSheetDialog bottomSheetDialog) {
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
        Download_dialog(((UrlObject) arrayList.get(0)).getUrl(), videosDownload);
        dismissCalculatorDialog(bottomSheetDialog);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$5(int i, VideosDownload videosDownload, ArrayList arrayList, BottomSheetDialog bottomSheetDialog) {
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
        Download_dialog(((UrlObject) arrayList.get(1)).getUrl(), videosDownload);
        dismissCalculatorDialog(bottomSheetDialog);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$6(int i, VideosDownload videosDownload, ArrayList arrayList, BottomSheetDialog bottomSheetDialog) {
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
        Download_dialog(((UrlObject) arrayList.get(2)).getUrl(), videosDownload);
        dismissCalculatorDialog(bottomSheetDialog);
        return null;
    }

    private void Download_dialog(String url, VideosDownload videosDownload) {
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
    public void audio_play(String mediaId, Lists lists) {
        if (!this.utkashRoom.getaudiodao().isvideo_exit(lists.getId(), MakeMyExam.userId)) {
            AudioTable audioTable = new AudioTable();
            audioTable.setVideo_id(lists.getId());
            if (lists.getFile_url().contains("jwplayer") || lists.getFile_url().contains("jwplatform")) {
                audioTable.setJw_url(mediaId);
            }
            audioTable.setVideo_name(lists.getTitle());
            audioTable.setAudio_currentpos(0L);
            audioTable.setUser_id(MakeMyExam.userId);
            if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                audioTable.setCourse_id(this.singleStudy2.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD);
            } else {
                audioTable.setCourse_id(SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + this.singleStudy2.getData().getCourseDetail().getId());
            }
            this.utkashRoom.getaudiodao().addUser(audioTable);
            extractJWPlayerUrl(mediaId, audioTable);
            return;
        }
        AudioTable audioTable2 = new AudioTable();
        audioTable2.setVideo_id(lists.getId());
        audioTable2.setJw_url(mediaId);
        audioTable2.setVideo_name(lists.getTitle());
        audioTable2.setAudio_currentpos(this.utkashRoom.getaudiodao().getuser(lists.getId(), MakeMyExam.userId).getAudio_currentpos());
        extractJWPlayerUrl(mediaId, audioTable2);
    }

    public void extractJWPlayerUrl(final String mediaUrl, final AudioTable videoData) {
        new JWPlayerMediaExtractor(new JWPlayerExtractorCallBack() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3.3
            @Override // com.appnew.android.JWextractor.JWPlayerExtractorCallBack
            public void onExtractorError(int responseCode, String error) {
            }

            @Override // com.appnew.android.JWextractor.JWPlayerExtractorCallBack
            public void onExtractorSuccess(int responseCode, HashMap<Integer, String> mediaResponseMap, boolean isVideoLive) {
                String str = mediaResponseMap.get(0);
                if (str != null) {
                    Intent intent = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) AudioPlayerActivty.class);
                    AudioPlayerService.videoid = "";
                    AudioPlayerService.media_id = "";
                    intent.putExtra("url", str);
                    intent.putExtra("videoid", videoData.getVideo_id());
                    intent.putExtra("currentpos", videoData.getAudio_currentpos());
                    intent.putExtra("video_name", videoData.getVideo_name());
                    intent.putExtra("image_url", mediaUrl + "/poster.jpg?width=720");
                    if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                        intent.putExtra("course_id", SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD);
                    } else {
                        intent.putExtra("course_id", SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId());
                    }
                    Helper.gotoActivity(intent, SingleStudyAdapter3.this.activity);
                }
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, mediaUrl);
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
                            Helper.GoToJWVideo_Params(this.activity, str, videoData.getId(), videoData.getTitle(), this.utkashRoom.getvideoDao().getuser(videoData.getId(), MakeMyExam.userId).getVideo_currentpos(), this.singleStudy2.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD);
                            return;
                        } else {
                            Helper.GoToJWVideo_Params(this.activity, str, videoData.getId(), videoData.getTitle(), this.utkashRoom.getvideoDao().getuser(videoData.getId(), MakeMyExam.userId).getVideo_currentpos(), SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + this.singleStudy2.getData().getCourseDetail().getId());
                            return;
                        }
                    }
                    VideoTable videoTable = new VideoTable();
                    videoTable.setVideo_id(videoData.getId());
                    videoTable.setVideo_name(videoData.getTitle());
                    videoTable.setJw_url(str);
                    videoTable.setVideo_currentpos(0L);
                    videoTable.setUser_id(MakeMyExam.userId);
                    videoTable.setCourse_id(SingleStudy.parentCourseId.equalsIgnoreCase("") ? this.singleStudy2.getData().getCourseDetail().getId() : SingleStudy.parentCourseId);
                    this.utkashRoom.getvideoDao().addUser(videoTable);
                    Helper.GoToJWVideo_Params(this.activity, str, videoData.getId(), videoData.getTitle(), 0L, (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(this.singleStudy2.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(this.singleStudy2.getData().getCourseDetail().getId())).toString());
                    return;
                }
                if (this.utkashRoom.getvideoDao().isvideo_exit(videoData.getId(), MakeMyExam.userId)) {
                    Helper.GoToJWVideo_Params(this.activity, str, videoData.getId(), videoData.getTitle(), this.utkashRoom.getvideoDao().getuser(videoData.getId(), MakeMyExam.userId).getVideo_currentpos(), (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(this.singleStudy2.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(this.singleStudy2.getData().getCourseDetail().getId())).toString());
                    return;
                }
                VideoTable videoTable2 = new VideoTable();
                videoTable2.setVideo_id(videoData.getId());
                videoTable2.setVideo_name(videoData.getTitle());
                videoTable2.setJw_url(str);
                videoTable2.setVideo_currentpos(0L);
                videoTable2.setUser_id(MakeMyExam.userId);
                videoTable2.setCourse_id((SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(this.singleStudy2.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(this.singleStudy2.getData().getCourseDetail().getId())).toString());
                this.utkashRoom.getvideoDao().addUser(videoTable2);
                Helper.GoToJWVideo_Params(this.activity, str, videoData.getId(), videoData.getTitle(), 0L, (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(this.singleStudy2.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(this.singleStudy2.getData().getCourseDetail().getId())).toString());
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
                        Helper.GoToLiveAwsVideoActivity(videoData.getVideo_type(), videoData.getChat_node(), this.activity, videoData.getId(), videoData.getVideo_type(), videoData.getId(), videoData.getTitle(), "0", videoData.getThumbnail_url(), videoData.getPayload().getCourse_id(), videoData.getPayload().getTile_id(), videoData.getPayload().getTile_type(), videoData.getIs_chat_lock(), String.valueOf(position), SingleStudy.parentCourseId, this.examPrepItem.getList().get(position).getStart_date(), new ArrayList());
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

    public class SingleStudyPdfListHolder extends RecyclerView.ViewHolder {
        Button backBtn;
        CardView ibt_single_sub_vd_RL;
        ImageView imageIcon;
        LeftMenu leftMenu;
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
            this.titleCategory = (TextView) itemView.findViewById(R.id.examPrepTitleTV);
            this.no_data_found_RL = (RelativeLayout) itemView.findViewById(R.id.no_data_found_RL);
            this.backBtn = (Button) itemView.findViewById(R.id.backBtn);
            this.ibt_single_sub_vd_RL = (CardView) itemView.findViewById(R.id.ibt_single_sub_vd_RL);
        }

        public void setData(final ArrayList<Lists> list, final int position) {
            this.leftMenu = (LeftMenu) new Gson().fromJson(SingleStudyAdapter3.this.themeSettings.getLeft_menu(), LeftMenu.class);
            if (list != null && list.size() > 0) {
                this.ibt_single_sub_vd_RL.setVisibility(0);
                this.no_data_found_RL.setVisibility(8);
                if ("1".equalsIgnoreCase("5")) {
                    if (SingleStudyAdapter3.this.contentType.contains("video") && list.get(position).getIs_live() != null && list.get(position).getIs_live().equals("1")) {
                        this.liveIV.setVisibility(0);
                    } else {
                        this.liveIV.setVisibility(8);
                    }
                } else if (list.get(position).getIs_live() != null && list.get(position).getIs_live().equals("1")) {
                    this.liveIV.setVisibility(0);
                } else {
                    this.liveIV.setVisibility(8);
                }
                this.titleCategory.setText(list.get(position).getTitle());
                if (TextUtils.isEmpty(list.get(position).getIs_locked())) {
                    list.get(position).setIs_locked("0");
                }
                if (SingleStudyAdapter3.this.singleStudy2 != null && SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail() != null && SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getIsPurchased().equals("1")) {
                    list.get(position).setIs_locked("0");
                }
                if (list.get(position).getIs_locked().equals("0")) {
                    this.lockRL.setVisibility(8);
                } else {
                    this.lockRL.setVisibility(0);
                }
                if (SingleStudyAdapter3.this.isSkip.equalsIgnoreCase("3")) {
                    this.share.setVisibility(0);
                    this.read_now.setEnabled(true);
                    this.studyitemLL.setEnabled(false);
                    this.read_now.setVisibility(0);
                } else {
                    this.share.setVisibility(8);
                    this.studyitemLL.setEnabled(true);
                    this.read_now.setVisibility(8);
                }
                if (!TextUtils.isEmpty(list.get(position).getThumbnail_url())) {
                    Helper.setThumbnailImage(SingleStudyAdapter3.this.activity, list.get(position).getThumbnail_url(), SingleStudyAdapter3.this.activity.getResources().getDrawable(R.mipmap.pdf), this.imageIcon);
                } else {
                    this.imageIcon.setImageResource(R.mipmap.pdf);
                }
                if (list.get(position).getIs_locked().equals("0")) {
                    this.lockRL.setVisibility(8);
                } else {
                    this.lockRL.setVisibility(0);
                    this.share.setVisibility(8);
                    this.read_now.setVisibility(8);
                }
                this.share.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyPdfListHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$0(position, view);
                    }
                });
                this.read_now.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3.SingleStudyPdfListHolder.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        if (((Lists) list.get(position)).getIs_locked().equalsIgnoreCase("1")) {
                            if (SingleStudyAdapter3.this.isCourseSoldOut()) {
                                Toast.makeText(SingleStudyAdapter3.this.activity, R.string.sold_out_msg, 0).show();
                                return;
                            }
                            Intent intent = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) PurchaseActivity.class);
                            intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter3.this.singleStudy2);
                            Helper.gotoActivity(intent, SingleStudyAdapter3.this.activity);
                            return;
                        }
                        if (SingleStudyAdapter3.this.is_purchase.equalsIgnoreCase("1")) {
                            if (!SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("7") && (TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_url()) || TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(position).getId()))) {
                                Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.no_pdf_found), 0).show();
                                return;
                            }
                            if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("8")) {
                                Intent intent2 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) WebViewActivty.class);
                                intent2.putExtra("type", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getTitle());
                                intent2.putExtra("url", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_url());
                                intent2.putExtra("course_id", (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId())).toString());
                                intent2.putExtra(Const.VIDEO_ID, SingleStudyAdapter3.this.examPrepItem.getList().get(position).getId());
                                intent2.putExtra("link", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type());
                                Helper.gotoActivity(intent2, SingleStudyAdapter3.this.activity);
                                return;
                            }
                            if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("1")) {
                                Helper.GoToWebViewPDFActivity(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.examPrepItem.getList().get(position).getId(), SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_url(), !TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(position).getIs_download_available()) && SingleStudyAdapter3.this.examPrepItem.getList().get(position).getIs_download_available().equalsIgnoreCase("1"), SingleStudyAdapter3.this.examPrepItem.getList().get(position).getTitle(), (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId())).toString(), SingleStudyAdapter3.this.examPrepItem.getList().get(position).getIs_share());
                                return;
                            }
                            return;
                        }
                        if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getIs_locked().equalsIgnoreCase("1")) {
                            if (SingleStudyAdapter3.this.isCourseSoldOut()) {
                                Toast.makeText(SingleStudyAdapter3.this.activity, R.string.sold_out_msg, 0).show();
                                return;
                            }
                            Intent intent3 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) PurchaseActivity.class);
                            intent3.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter3.this.singleStudy2);
                            Helper.gotoActivity(intent3, SingleStudyAdapter3.this.activity);
                            return;
                        }
                        if (!SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("7") && (TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_url()) || TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(position).getId()))) {
                            Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.no_pdf_found), 0).show();
                            return;
                        }
                        if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("8")) {
                            Intent intent4 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) WebViewActivty.class);
                            intent4.putExtra("type", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getTitle());
                            intent4.putExtra("url", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_url());
                            intent4.putExtra("course_id", (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId())).toString());
                            intent4.putExtra(Const.VIDEO_ID, SingleStudyAdapter3.this.examPrepItem.getList().get(position).getId());
                            intent4.putExtra("link", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type());
                            Helper.gotoActivity(intent4, SingleStudyAdapter3.this.activity);
                            return;
                        }
                        if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("1")) {
                            Helper.GoToWebViewPDFActivity(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.examPrepItem.getList().get(position).getId(), SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_url(), !TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(position).getIs_download_available()) && SingleStudyAdapter3.this.examPrepItem.getList().get(position).getIs_download_available().equalsIgnoreCase("1"), SingleStudyAdapter3.this.examPrepItem.getList().get(position).getTitle(), (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId())).toString(), SingleStudyAdapter3.this.examPrepItem.getList().get(position).getIs_share());
                        }
                    }
                });
                this.studyitemLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3.SingleStudyPdfListHolder.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        boolean z = false;
                        if (((Lists) list.get(position)).getIs_locked().equalsIgnoreCase("1")) {
                            if (SingleStudyAdapter3.this.isCourseSoldOut()) {
                                Toast.makeText(SingleStudyAdapter3.this.activity, R.string.sold_out_msg, 0).show();
                                return;
                            }
                            Intent intent = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) PurchaseActivity.class);
                            intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter3.this.singleStudy2);
                            Helper.gotoActivity(intent, SingleStudyAdapter3.this.activity);
                            return;
                        }
                        if (SingleStudyAdapter3.this.isSkip.equalsIgnoreCase("1") || SingleStudyAdapter3.this.isSkip.equalsIgnoreCase("2")) {
                            Intent intent2 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) CourseActivity.class);
                            SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(SingleStudyAdapter3.this.singleStudy2 != null ? SingleStudyAdapter3.this.singleStudy2 : new CourseDetail()));
                            SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(SingleStudyAdapter3.this.examPrepItem != null ? SingleStudyAdapter3.this.examPrepItem : new ExamPrepItem()));
                            SharedPreference.getInstance().putString("list", new Gson().toJson(SingleStudyAdapter3.this.examPrepItem.getList().get(position) != null ? SingleStudyAdapter3.this.examPrepItem.getList().get(position) : new Lists()));
                            intent2.putExtra(Const.FRAG_TYPE, Const.EXAMPREPLAST);
                            intent2.putExtra(Const.LIST_SUBJECT, SingleStudyAdapter3.this.examPrepItem.getList().get(position));
                            if (SingleStudyAdapter3.this.mainCourseId.equals("455") || SingleStudyAdapter3.this.tileTypeAPI.equals(Const.COMBO) || SingleStudyAdapter3.this.tileTypeAPI.equals("content")) {
                                intent2.putExtra(Const.TAB_TILE_VISIBILITY, "1");
                            } else {
                                intent2.putExtra(Const.TAB_TILE_VISIBILITY, "0");
                            }
                            intent2.putExtra(Const.IS_COMBO, SingleStudyAdapter3.this.isCombo);
                            intent2.putExtra("title", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getTitle());
                            intent2.putExtra("content_type", SingleStudyAdapter3.this.contentType);
                            intent2.putExtra(Const.TEST_TYPE, SingleStudyAdapter3.this.examPrepItem.getList().get(position).getCount());
                            intent2.putExtra("tile_id", SingleStudyAdapter3.this.tileIdAPI);
                            intent2.putExtra(Const.TILE_TYPE, SingleStudyAdapter3.this.tileTypeAPI);
                            intent2.putExtra(Const.REVERT_API, SingleStudyAdapter3.this.revertAPI);
                            Helper.gotoActivity(intent2, SingleStudyAdapter3.this.activity);
                            return;
                        }
                        if (SingleStudyAdapter3.this.isSkip.equalsIgnoreCase("3")) {
                            if (SingleStudyAdapter3.this.is_purchase.equalsIgnoreCase("1")) {
                                if (!SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("7") && TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(position).getId())) {
                                    Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.no_pdf_found), 0).show();
                                    return;
                                }
                                if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("8")) {
                                    Intent intent3 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) WebViewActivty.class);
                                    intent3.putExtra("type", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getTitle());
                                    intent3.putExtra("url", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_url());
                                    intent3.putExtra("course_id", (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId())).toString());
                                    intent3.putExtra(Const.VIDEO_ID, SingleStudyAdapter3.this.examPrepItem.getList().get(position).getId());
                                    intent3.putExtra("link", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type());
                                    Helper.gotoActivity(intent3, SingleStudyAdapter3.this.activity);
                                }
                                if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("7")) {
                                    Intent intent4 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) WebViewActivty.class);
                                    intent4.putExtra("type", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getTitle());
                                    intent4.putExtra("url", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getDescription());
                                    Helper.gotoActivity(intent4, SingleStudyAdapter3.this.activity);
                                    return;
                                }
                                if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("1")) {
                                    if (!TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(position).getIs_download_available()) && SingleStudyAdapter3.this.examPrepItem.getList().get(position).getIs_download_available().equalsIgnoreCase("1")) {
                                        z = true;
                                    }
                                    Helper.GoToWebViewPDFActivity(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.examPrepItem.getList().get(position).getId(), SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_url(), z, SingleStudyAdapter3.this.examPrepItem.getList().get(position).getTitle(), (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId())).toString(), SingleStudyAdapter3.this.examPrepItem.getList().get(position).getIs_share());
                                    return;
                                }
                                return;
                            }
                            if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getIs_locked().equalsIgnoreCase("1")) {
                                if (SingleStudyAdapter3.this.isCourseSoldOut()) {
                                    Toast.makeText(SingleStudyAdapter3.this.activity, R.string.sold_out_msg, 0).show();
                                    return;
                                }
                                Intent intent5 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) PurchaseActivity.class);
                                intent5.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter3.this.singleStudy2);
                                Helper.gotoActivity(intent5, SingleStudyAdapter3.this.activity);
                                return;
                            }
                            if (!SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("7") && TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(position).getId())) {
                                Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.no_pdf_found), 0).show();
                                return;
                            }
                            if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("8")) {
                                Intent intent6 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) WebViewActivty.class);
                                intent6.putExtra("type", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getTitle());
                                intent6.putExtra("url", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_url());
                                intent6.putExtra("course_id", (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId())).toString());
                                intent6.putExtra(Const.VIDEO_ID, SingleStudyAdapter3.this.examPrepItem.getList().get(position).getId());
                                intent6.putExtra("link", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type());
                                Helper.gotoActivity(intent6, SingleStudyAdapter3.this.activity);
                            }
                            if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("7")) {
                                Intent intent7 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) WebViewActivty.class);
                                intent7.putExtra("type", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getTitle());
                                intent7.putExtra("url", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getDescription());
                                Helper.gotoActivity(intent7, SingleStudyAdapter3.this.activity);
                                return;
                            }
                            if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("1")) {
                                if (!TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(position).getIs_download_available()) && SingleStudyAdapter3.this.examPrepItem.getList().get(position).getIs_download_available().equalsIgnoreCase("1")) {
                                    z = true;
                                }
                                Helper.GoToWebViewPDFActivity(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.examPrepItem.getList().get(position).getId(), SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_url(), z, SingleStudyAdapter3.this.examPrepItem.getList().get(position).getTitle(), (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId())).toString(), SingleStudyAdapter3.this.examPrepItem.getList().get(position).getIs_share());
                                return;
                            }
                            return;
                        }
                        ExamPrepItem examPrepItem = new ExamPrepItem();
                        examPrepItem.setList(SingleStudyAdapter3.this.examPrepItem.getList().get(position).getList());
                        Intent intent8 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) CourseActivity.class);
                        SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(SingleStudyAdapter3.this.singleStudy2 != null ? SingleStudyAdapter3.this.singleStudy2 : new CourseDetail()));
                        SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(examPrepItem));
                        SharedPreference.getInstance().putString("list", new Gson().toJson(list.get(position) != null ? list.get(position) : new Lists()));
                        intent8.putExtra(Const.FRAG_TYPE, Const.EXAMPREP);
                        intent8.putExtra(Const.IS_COMBO, SingleStudyAdapter3.this.isCombo);
                        intent8.putExtra("content_type", SingleStudyAdapter3.this.contentType);
                        if (SingleStudyAdapter3.this.mainCourseId.equals("455") || SingleStudyAdapter3.this.tileTypeAPI.equals(Const.COMBO) || SingleStudyAdapter3.this.tileTypeAPI.equals("content")) {
                            intent8.putExtra(Const.TAB_TILE_VISIBILITY, "1");
                        } else {
                            intent8.putExtra(Const.TAB_TILE_VISIBILITY, "0");
                        }
                        intent8.putExtra("title", SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail() != null ? SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getTitle() : "Course");
                        intent8.putExtra("tile_id", SingleStudyAdapter3.this.tileIdAPI);
                        intent8.putExtra(Const.TILE_TYPE, SingleStudyAdapter3.this.tileTypeAPI);
                        intent8.putExtra(Const.REVERT_API, SingleStudyAdapter3.this.revertAPI);
                        Helper.gotoActivity(intent8, SingleStudyAdapter3.this.activity);
                    }
                });
            } else {
                this.ibt_single_sub_vd_RL.setVisibility(8);
                this.no_data_found_RL.setVisibility(0);
                this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3.SingleStudyPdfListHolder.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        SingleStudyAdapter3.this.activity.finish();
                    }
                });
            }
            if (Helper.isShowShareButton(this.leftMenu)) {
                this.share.setVisibility(0);
            } else {
                this.share.setVisibility(8);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$0(int i, View view) {
            if (SingleStudyAdapter3.this.is_purchase.equalsIgnoreCase("1")) {
                if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_type().equalsIgnoreCase("8") || SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_type().equalsIgnoreCase("7") || SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_type().equalsIgnoreCase("1")) {
                    Helper.sharePdf(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getCourse_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTopic_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_type(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getRevert_api(), Const.PDF, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getThumbnail_url(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getTitle(), SingleStudy.parentCourseId);
                    return;
                }
                return;
            }
            if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter3.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter3.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter3.this.singleStudy2);
                Helper.gotoActivity(intent, SingleStudyAdapter3.this.activity);
                return;
            }
            if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_type().equalsIgnoreCase("8") || SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_type().equalsIgnoreCase("7") || SingleStudyAdapter3.this.examPrepItem.getList().get(i).getFile_type().equalsIgnoreCase("1")) {
                Helper.sharePdf(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getCourse_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTopic_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_type(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getRevert_api(), Const.PDF, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getThumbnail_url(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getTitle(), SingleStudy.parentCourseId);
            }
        }
    }

    private void addSectionView(LinearLayout sectionListLL, InstructionData instructionData) {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (TestSectionInst testSectionInst : instructionData.getTestSections()) {
            String sectionId = testSectionInst.getSectionId();
            float floatSafe = Helper.parseFloatSafe(testSectionInst.getSectionTiming());
            if (map.containsKey(sectionId)) {
                map.merge(sectionId, Float.valueOf(floatSafe), new BiFunction() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$$ExternalSyntheticLambda7
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

    public class SingleStudyConceptListHolder extends RecyclerView.ViewHolder {
        Button backBtn;
        CardView ibt_single_sub_vd_RL;
        ImageView imageIcon;
        RelativeLayout layout_fun;
        LeftMenu leftMenu;
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
            this.leftMenu = (LeftMenu) new Gson().fromJson(SingleStudyAdapter3.this.themeSettings.getLeft_menu(), LeftMenu.class);
            if (list != null && list.size() > 0) {
                this.ibt_single_sub_vd_RL.setVisibility(0);
                this.no_data_found_RL.setVisibility(8);
                if ("1".equalsIgnoreCase("5")) {
                    if (SingleStudyAdapter3.this.contentType.contains("video") && list.get(position).getIs_live() != null && list.get(position).getIs_live().equals("1")) {
                        this.liveIV.setVisibility(0);
                    } else {
                        this.liveIV.setVisibility(8);
                    }
                } else if (list.get(position).getIs_live() != null && list.get(position).getIs_live().equals("1")) {
                    this.liveIV.setVisibility(0);
                } else {
                    this.liveIV.setVisibility(8);
                }
                this.titleCategory.setText(list.get(position).getTitle());
                if (SingleStudyAdapter3.this.isSkip.equalsIgnoreCase("3")) {
                    this.share.setVisibility(8);
                    if (list.get(position).getFile_type().equalsIgnoreCase("7")) {
                        this.layout_fun.setVisibility(0);
                        this.read_now.setVisibility(0);
                        this.optionMenuImgView.setVisibility(8);
                        this.studyitemLL.setEnabled(false);
                        this.share.setVisibility(0);
                    } else if (list.get(position).getFile_type().equalsIgnoreCase("12") || list.get(position).getFile_type().equalsIgnoreCase("11") || list.get(position).getFile_type().equalsIgnoreCase("8")) {
                        this.layout_fun.setVisibility(0);
                        this.read_now.setVisibility(0);
                        this.optionMenuImgView.setVisibility(0);
                        this.optionMenuImgView.setImageResource(R.drawable.delete);
                        this.subItemRV.setText(SingleStudyAdapter3.this.activity.getResources().getString(R.string.revision_type));
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
                    if (list.get(position).getCount() != null) {
                        this.subItemRV.setText(SingleStudyAdapter3.this.activity.getResources().getString(R.string.total_) + list.get(position).getCount());
                    }
                    this.subItemRV.setVisibility(8);
                }
                if (!TextUtils.isEmpty(list.get(position).getThumbnail_url())) {
                    Helper.setThumbnailImage(SingleStudyAdapter3.this.activity, list.get(position).getThumbnail_url(), SingleStudyAdapter3.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.imageIcon);
                } else {
                    this.imageIcon.setImageResource(R.mipmap.square_placeholder);
                }
                if (TextUtils.isEmpty(list.get(position).getIs_locked())) {
                    list.get(position).setIs_locked("0");
                }
                if (SingleStudyAdapter3.this.singleStudy2 != null && SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail() != null && SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getIsPurchased().equals("1")) {
                    list.get(position).setIs_locked("0");
                }
                if (list.get(position).getIs_locked().equals("0")) {
                    this.lockRL.setVisibility(8);
                } else {
                    this.lockRL.setVisibility(0);
                    this.share.setVisibility(8);
                    this.optionMenuImgView.setVisibility(8);
                    this.read_now.setVisibility(8);
                }
                this.optionMenuImgView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3.SingleStudyConceptListHolder.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        if (SingleStudyAdapter3.this.is_purchase.equalsIgnoreCase("1")) {
                            if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("10") || SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("12") || SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("11")) {
                                SingleStudyAdapter3.this.videodata = SingleStudyAdapter3.this.examPrepItem.getList().get(position);
                                SingleStudyAdapter3.this.position_delete = position;
                                SingleStudyAdapter3.this.delete_meg(SingleStudyAdapter3.this.videodata);
                                return;
                            }
                            if (!VideoDownloadService.isServiceRunning) {
                                if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getVideo_type().equalsIgnoreCase("6")) {
                                    SingleStudyAdapter3.this.download_data(SingleStudyAdapter3.this.examPrepItem.getList().get(position), position);
                                    return;
                                } else {
                                    Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.only_jw_video_download), 0).show();
                                    return;
                                }
                            }
                            Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.please_wait_downloading_is_in_progress), 0).show();
                            return;
                        }
                        if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getIs_locked().equalsIgnoreCase("1")) {
                            if (SingleStudyAdapter3.this.isCourseSoldOut()) {
                                Toast.makeText(SingleStudyAdapter3.this.activity, R.string.sold_out_msg, 0).show();
                                return;
                            }
                            Intent intent = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) PurchaseActivity.class);
                            intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter3.this.singleStudy2);
                            Helper.gotoActivity(intent, SingleStudyAdapter3.this.activity);
                            return;
                        }
                        if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("10") || SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("12") || SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("11")) {
                            SingleStudyAdapter3.this.videodata = SingleStudyAdapter3.this.examPrepItem.getList().get(position);
                            SingleStudyAdapter3.this.position_delete = position;
                            SingleStudyAdapter3.this.delete_meg(SingleStudyAdapter3.this.videodata);
                            return;
                        }
                        if (!VideoDownloadService.isServiceRunning) {
                            if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getVideo_type().equalsIgnoreCase("6")) {
                                SingleStudyAdapter3.this.download_data(SingleStudyAdapter3.this.examPrepItem.getList().get(position), position);
                                return;
                            } else {
                                Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.only_jw_video_download), 0).show();
                                return;
                            }
                        }
                        Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.please_wait_downloading_is_in_progress), 0).show();
                    }
                });
                this.read_now.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3.SingleStudyConceptListHolder.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        if (((Lists) list.get(position)).getIs_locked().equalsIgnoreCase("1")) {
                            if (SingleStudyAdapter3.this.isCourseSoldOut()) {
                                Toast.makeText(SingleStudyAdapter3.this.activity, R.string.sold_out_msg, 0).show();
                                return;
                            }
                            Intent intent = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) PurchaseActivity.class);
                            intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter3.this.singleStudy2);
                            Helper.gotoActivity(intent, SingleStudyAdapter3.this.activity);
                            return;
                        }
                        if (SingleStudyAdapter3.this.isSkip.equalsIgnoreCase("3")) {
                            if (SingleStudyAdapter3.this.is_purchase.equalsIgnoreCase("1")) {
                                if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("12")) {
                                    if (SingleStudyAdapter3.this.examPrepItem.getList().size() > 0) {
                                        Intent intent2 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) RevisionActivity.class);
                                        intent2.putExtra("t_id", SingleStudyAdapter3.this.tileIdAPI);
                                        intent2.putExtra("postion", position);
                                        intent2.putExtra(Const.VIDEO_ID, SingleStudyAdapter3.this.examPrepItem.getList().get(position).getId());
                                        intent2.putExtra("v_list", ExamPrepLayer2.actual_videolist);
                                        intent2.putExtra("f_id", SingleStudyAdapter3.this.examPrepItem.getList().get(0).getId());
                                        intent2.putExtra("c_id", SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId());
                                        intent2.putExtra("title", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getTitle());
                                        intent2.putExtra("url", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_url());
                                        intent2.putExtra(Const.VIA, "main");
                                        Helper.gotoActivity(intent2, SingleStudyAdapter3.this.activity);
                                        return;
                                    }
                                    return;
                                }
                                if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("11")) {
                                    Intent intent3 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) WebViewActivty.class);
                                    intent3.putExtra("type", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getTitle());
                                    intent3.putExtra("url", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_url());
                                    Helper.gotoActivity(intent3, SingleStudyAdapter3.this.activity);
                                    return;
                                }
                                if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("8")) {
                                    Intent intent4 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) WebViewActivty.class);
                                    intent4.putExtra("type", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getTitle());
                                    intent4.putExtra("url", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_url());
                                    intent4.putExtra("course_id", (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId())).toString());
                                    intent4.putExtra(Const.VIDEO_ID, SingleStudyAdapter3.this.examPrepItem.getList().get(position).getId());
                                    intent4.putExtra("link", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type());
                                    Helper.gotoActivity(intent4, SingleStudyAdapter3.this.activity);
                                    return;
                                }
                                if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("6")) {
                                    if (TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(position).getId())) {
                                        Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.no_image_found), 0).show();
                                        return;
                                    }
                                    Intent intent5 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) WebViewActivty.class);
                                    intent5.putExtra("type", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getTitle());
                                    intent5.putExtra("url", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_url());
                                    intent5.putExtra("file_type", "image");
                                    Helper.gotoActivity(intent5, SingleStudyAdapter3.this.activity);
                                    return;
                                }
                                Intent intent6 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) Concept_newActivity.class);
                                intent6.putExtra("id", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getId());
                                intent6.putExtra("name", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getTitle());
                                intent6.putExtra("course_id", (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId())).toString());
                                intent6.putExtra("tile_id", SingleStudyAdapter3.this.tileIdAPI);
                                Helper.gotoActivity(intent6, SingleStudyAdapter3.this.activity);
                                return;
                            }
                            if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getIs_locked().equalsIgnoreCase("1")) {
                                if (SingleStudyAdapter3.this.isCourseSoldOut()) {
                                    Toast.makeText(SingleStudyAdapter3.this.activity, R.string.sold_out_msg, 0).show();
                                    return;
                                }
                                Intent intent7 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) PurchaseActivity.class);
                                intent7.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter3.this.singleStudy2);
                                Helper.gotoActivity(intent7, SingleStudyAdapter3.this.activity);
                                return;
                            }
                            if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("12")) {
                                if (SingleStudyAdapter3.this.examPrepItem.getList().size() > 0) {
                                    Intent intent8 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) RevisionActivity.class);
                                    intent8.putExtra("t_id", SingleStudyAdapter3.this.tileIdAPI);
                                    intent8.putExtra("postion", position);
                                    intent8.putExtra(Const.VIDEO_ID, SingleStudyAdapter3.this.examPrepItem.getList().get(position).getId());
                                    intent8.putExtra("v_list", ExamPrepLayer2.actual_videolist);
                                    intent8.putExtra("f_id", SingleStudyAdapter3.this.examPrepItem.getList().get(0).getId());
                                    intent8.putExtra("c_id", SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId());
                                    intent8.putExtra("title", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getTitle());
                                    intent8.putExtra("url", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_url());
                                    intent8.putExtra(Const.VIA, "main");
                                    Helper.gotoActivity(intent8, SingleStudyAdapter3.this.activity);
                                    return;
                                }
                                return;
                            }
                            if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("11")) {
                                Intent intent9 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) WebViewActivty.class);
                                intent9.putExtra("type", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getTitle());
                                intent9.putExtra("url", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_url());
                                Helper.gotoActivity(intent9, SingleStudyAdapter3.this.activity);
                                return;
                            }
                            if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("8")) {
                                Intent intent10 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) WebViewActivty.class);
                                intent10.putExtra("type", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getTitle());
                                intent10.putExtra("url", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_url());
                                intent10.putExtra("course_id", (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId())).toString());
                                intent10.putExtra(Const.VIDEO_ID, SingleStudyAdapter3.this.examPrepItem.getList().get(position).getId());
                                intent10.putExtra("link", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type());
                                Helper.gotoActivity(intent10, SingleStudyAdapter3.this.activity);
                                return;
                            }
                            if (SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_type().equalsIgnoreCase("6")) {
                                if (TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_url()) && TextUtils.isEmpty(SingleStudyAdapter3.this.examPrepItem.getList().get(position).getId())) {
                                    Toast.makeText(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.activity.getResources().getString(R.string.no_image_found), 0).show();
                                    return;
                                }
                                Intent intent11 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) WebViewActivty.class);
                                intent11.putExtra("type", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getTitle());
                                intent11.putExtra("url", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getFile_url());
                                intent11.putExtra("file_type", "image");
                                Helper.gotoActivity(intent11, SingleStudyAdapter3.this.activity);
                                return;
                            }
                            Intent intent12 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) Concept_newActivity.class);
                            intent12.putExtra("id", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getId());
                            intent12.putExtra("name", SingleStudyAdapter3.this.examPrepItem.getList().get(position).getTitle());
                            intent12.putExtra("course_id", (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId())).toString());
                            intent12.putExtra("tile_id", SingleStudyAdapter3.this.tileIdAPI);
                            Helper.gotoActivity(intent12, SingleStudyAdapter3.this.activity);
                        }
                    }
                });
                this.studyitemLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyConceptListHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$0(list, position, view);
                    }
                });
                this.share.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3$SingleStudyConceptListHolder$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$setData$1(position);
                    }
                }));
            } else {
                this.ibt_single_sub_vd_RL.setVisibility(8);
                this.no_data_found_RL.setVisibility(0);
                this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3.SingleStudyConceptListHolder.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        SingleStudyAdapter3.this.activity.finish();
                    }
                });
            }
            if (Helper.isShowShareButton(this.leftMenu)) {
                this.share.setVisibility(0);
            } else {
                this.share.setVisibility(8);
            }
            if ("1".equalsIgnoreCase("5")) {
                this.layout_fun.setVisibility(8);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$0(ArrayList arrayList, int i, View view) {
            String str;
            Object obj;
            String str2;
            if (((Lists) arrayList.get(i)).getIs_locked().equalsIgnoreCase("1")) {
                if (SingleStudyAdapter3.this.isCourseSoldOut()) {
                    Toast.makeText(SingleStudyAdapter3.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter3.this.singleStudy2);
                Helper.gotoActivity(intent, SingleStudyAdapter3.this.activity);
                return;
            }
            if (SingleStudyAdapter3.this.isSkip.equalsIgnoreCase("1")) {
                str = "tile_id";
                obj = "content";
                str2 = "title";
            } else {
                if (!SingleStudyAdapter3.this.isSkip.equalsIgnoreCase("2")) {
                    if (SingleStudyAdapter3.this.isSkip.equalsIgnoreCase("3")) {
                        if (SingleStudyAdapter3.this.is_purchase.equalsIgnoreCase("1")) {
                            Intent intent2 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) Concept_newActivity.class);
                            intent2.putExtra("id", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId());
                            intent2.putExtra("name", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getTitle());
                            intent2.putExtra("course_id", (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId())).toString());
                            intent2.putExtra("tile_id", SingleStudyAdapter3.this.tileIdAPI);
                            Helper.gotoActivity(intent2, SingleStudyAdapter3.this.activity);
                            return;
                        }
                        if (SingleStudyAdapter3.this.examPrepItem.getList().get(i).getIs_locked().equalsIgnoreCase("1")) {
                            if (SingleStudyAdapter3.this.isCourseSoldOut()) {
                                Toast.makeText(SingleStudyAdapter3.this.activity, R.string.sold_out_msg, 0).show();
                                return;
                            }
                            Intent intent3 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) PurchaseActivity.class);
                            intent3.putExtra(Const.SINGLE_STUDY, SingleStudyAdapter3.this.singleStudy2);
                            Helper.gotoActivity(intent3, SingleStudyAdapter3.this.activity);
                            return;
                        }
                        Intent intent4 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) Concept_newActivity.class);
                        intent4.putExtra("id", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId());
                        intent4.putExtra("name", SingleStudyAdapter3.this.examPrepItem.getList().get(i).getTitle());
                        intent4.putExtra("course_id", (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getId())).toString());
                        intent4.putExtra("tile_id", SingleStudyAdapter3.this.tileIdAPI);
                        Helper.gotoActivity(intent4, SingleStudyAdapter3.this.activity);
                        return;
                    }
                    ExamPrepItem examPrepItem = new ExamPrepItem();
                    examPrepItem.setList(SingleStudyAdapter3.this.examPrepItem.getList().get(i).getList());
                    Intent intent5 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) CourseActivity.class);
                    SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(SingleStudyAdapter3.this.singleStudy2 != null ? SingleStudyAdapter3.this.singleStudy2 : new CourseDetail()));
                    SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(examPrepItem));
                    SharedPreference.getInstance().putString("list", new Gson().toJson(arrayList.get(i) != null ? arrayList.get(i) : new Lists()));
                    intent5.putExtra(Const.FRAG_TYPE, Const.EXAMPREP);
                    intent5.putExtra(Const.IS_COMBO, SingleStudyAdapter3.this.isCombo);
                    intent5.putExtra("content_type", SingleStudyAdapter3.this.contentType);
                    if (SingleStudyAdapter3.this.mainCourseId.equals("455") || SingleStudyAdapter3.this.tileTypeAPI.equals(Const.COMBO) || SingleStudyAdapter3.this.tileTypeAPI.equals("content")) {
                        intent5.putExtra(Const.TAB_TILE_VISIBILITY, "1");
                    } else {
                        intent5.putExtra(Const.TAB_TILE_VISIBILITY, "0");
                    }
                    intent5.putExtra("title", SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail() != null ? SingleStudyAdapter3.this.singleStudy2.getData().getCourseDetail().getTitle() : "Course");
                    intent5.putExtra("tile_id", SingleStudyAdapter3.this.tileIdAPI);
                    intent5.putExtra(Const.TILE_TYPE, SingleStudyAdapter3.this.tileTypeAPI);
                    intent5.putExtra(Const.REVERT_API, SingleStudyAdapter3.this.revertAPI);
                    Helper.gotoActivity(intent5, SingleStudyAdapter3.this.activity);
                    return;
                }
                str = "tile_id";
                str2 = "title";
                obj = "content";
            }
            String str3 = str;
            Intent intent6 = new Intent(SingleStudyAdapter3.this.activity, (Class<?>) CourseActivity.class);
            SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(SingleStudyAdapter3.this.singleStudy2 != null ? SingleStudyAdapter3.this.singleStudy2 : new CourseDetail()));
            SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(SingleStudyAdapter3.this.examPrepItem != null ? SingleStudyAdapter3.this.examPrepItem : new ExamPrepItem()));
            SharedPreference.getInstance().putString("list", new Gson().toJson(SingleStudyAdapter3.this.examPrepItem.getList().get(i) != null ? SingleStudyAdapter3.this.examPrepItem.getList().get(i) : new Lists()));
            intent6.putExtra(Const.FRAG_TYPE, Const.EXAMPREPLAST);
            intent6.putExtra(Const.LIST_SUBJECT, SingleStudyAdapter3.this.examPrepItem.getList().get(i));
            intent6.putExtra(Const.IS_COMBO, SingleStudyAdapter3.this.isCombo);
            if (SingleStudyAdapter3.this.mainCourseId.equals("455") || SingleStudyAdapter3.this.tileTypeAPI.equals(Const.COMBO) || SingleStudyAdapter3.this.tileTypeAPI.equals(obj)) {
                intent6.putExtra(Const.TAB_TILE_VISIBILITY, "1");
            } else {
                intent6.putExtra(Const.TAB_TILE_VISIBILITY, "0");
            }
            intent6.putExtra(str2, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getTitle());
            intent6.putExtra("content_type", SingleStudyAdapter3.this.contentType);
            intent6.putExtra(Const.TEST_TYPE, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getCount());
            intent6.putExtra(str3, SingleStudyAdapter3.this.tileIdAPI);
            intent6.putExtra(Const.TILE_TYPE, SingleStudyAdapter3.this.tileTypeAPI);
            intent6.putExtra(Const.REVERT_API, SingleStudyAdapter3.this.revertAPI);
            Helper.gotoActivity(intent6, SingleStudyAdapter3.this.activity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$setData$1(int i) {
            Helper.sharePdf(SingleStudyAdapter3.this.activity, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getCourse_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getId(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTopic_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_type(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getTile_id(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getPayload().getRevert_api(), Const.PDF, SingleStudyAdapter3.this.examPrepItem.getList().get(i).getThumbnail_url(), SingleStudyAdapter3.this.examPrepItem.getList().get(i).getTitle(), SingleStudy.parentCourseId);
            return null;
        }
    }

    public void showPopMenuForLangauge(final View v, final TestBasicInst testBasicInst, final TextView v1, TextView vvv) {
        PopupMenu popupMenu = new PopupMenu(this.activity, v);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.Courses.Adapter.SingleStudyAdapter3.4
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem item) {
                ((TextView) v).setText(item.getTitle().toString());
                if (item.getTitle().toString().equals(SingleStudyAdapter3.this.activity.getResources().getString(R.string.hindi))) {
                    SingleStudyAdapter3.this.lang = 2;
                    if (testBasicInst.getMulti_description().size() > 0 && testBasicInst.getMulti_description().get(1).getDescription() != null) {
                        v1.setText(Html.fromHtml(testBasicInst.getMulti_description().get(1).getDescription()));
                    }
                } else if (item.getTitle().toString().equals(SingleStudyAdapter3.this.activity.getResources().getString(R.string.english))) {
                    SingleStudyAdapter3.this.lang = 1;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void pushEventForDownload(VideosDownload videosDownload) {
        String id = !TextUtils.isEmpty(SingleStudy.parentCourseId) ? SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + this.singleStudy2.getData().getCourseDetail().getId() : this.singleStudy2.getData().getCourseDetail().getId();
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
