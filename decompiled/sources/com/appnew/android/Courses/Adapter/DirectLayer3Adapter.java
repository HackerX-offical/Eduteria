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
import com.appnew.android.Courses.Fragment.ExamPrepLayer2;
import com.appnew.android.Courses.Fragment.SingleStudy;
import com.appnew.android.Courses.overview.adapter.OverviewRVAdapter;
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
import com.appnew.android.Model.Video;
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
public class DirectLayer3Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements NetworkCall.MyNetworkCallBack {
    Activity activity;
    onButtonClicked buttonClicked;
    public String contentType;
    ArrayList<Courselist> courseDataArrayList;
    ExamPrepItem examPrepItem;
    ArrayList<FaqData> faqData;
    private String first_attempt;
    boolean isCombo;
    Boolean isLodded = true;
    private boolean isSSCpattern;
    String isSkip;
    String is_purchase;
    int lang;
    String[] langIds;
    OverviewData overviewData;
    String parentCourseId;
    int position_delete;
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
    ArrayList<Video> videoArrayList;
    private Lists videodata;

    public interface onButtonClicked {
        void onTitleClicked(TilesItem cards, List<TilesItem> tiles, int tilePos);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    public DirectLayer3Adapter(Activity activity, CourseDetail singleStudy, ExamPrepItem examPrepItem, OverviewData overviewData, ArrayList<Courselist> courseDataArrayList, ArrayList<FaqData> faqData, onButtonClicked buttonClicked, String parentCourseId, boolean isCombo, String isSkip, int tilePos, String tileIdAPI, String tileTypeAPI, String revertAPI, ArrayList<Video> videoArrayList) {
        this.isCombo = false;
        this.tilePos = 0;
        this.is_purchase = "";
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        this.utkashRoom = appDatabase;
        this.result_date = "";
        this.submission_type = "";
        this.themeSettings = appDatabase.getthemeSettingdao().data();
        this.videoArrayList = new ArrayList<>();
        this.isSSCpattern = false;
        this.langIds = new String[]{"1"};
        this.videoArrayList = videoArrayList;
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
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewInflate;
        View viewInflate2;
        View viewInflate3;
        if (viewType == 0) {
            return new SingleStudyHeaderHolder(LayoutInflater.from(this.activity).inflate(R.layout.exam_prep_header, (ViewGroup) null));
        }
        if (viewType == 1) {
            if ("1".equalsIgnoreCase("5")) {
                viewInflate3 = LayoutInflater.from(this.activity).inflate(R.layout.exam_prep_single_row_item_theme5, (ViewGroup) null);
            } else {
                viewInflate3 = LayoutInflater.from(this.activity).inflate(R.layout.exam_prep_single_row_item, (ViewGroup) null);
            }
            return new SingleStudyListHolder(viewInflate3);
        }
        if (viewType == 7) {
            if ("1".equalsIgnoreCase("5")) {
                viewInflate2 = LayoutInflater.from(this.activity).inflate(R.layout.exam_prep_single_row_item_pdf_theme5, (ViewGroup) null);
            } else {
                viewInflate2 = LayoutInflater.from(this.activity).inflate(R.layout.exam_prep_single_row_item_pdf, (ViewGroup) null);
            }
            return new SingleStudyPdfListHolder(viewInflate2);
        }
        if (viewType == 8) {
            if ("1".equalsIgnoreCase("5")) {
                viewInflate = LayoutInflater.from(this.activity).inflate(R.layout.exam_prep_single_row_item_concept_theme5, (ViewGroup) null);
            } else {
                viewInflate = LayoutInflater.from(this.activity).inflate(R.layout.exam_prep_single_row_item_concept, (ViewGroup) null);
            }
            return new SingleStudyConceptListHolder(viewInflate);
        }
        if (viewType == 4) {
            return new SingleStudyTestListHolder(LayoutInflater.from(this.activity).inflate(R.layout.exam_prep_single_row_item_test, (ViewGroup) null));
        }
        if (viewType == 3) {
            return new OverViewHolder(LayoutInflater.from(this.activity).inflate(R.layout.course_overview_layout, (ViewGroup) null));
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

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == 0) {
            ((SingleStudyHeaderHolder) holder).setDataHeader(this.singleStudy);
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
            case "https://appapi.videocrypt.in/index.php/data_model/test/get_test_data":
                EncryptionData encryptionData3 = new EncryptionData();
                encryptionData3.setTest_id(this.quiz_id);
                encryptionData3.setCourse_id(this.singleStudy.getData().getCourseDetail().getId());
                return service.API_GET_INFO_TEST_SERIES(AES.encrypt(new Gson().toJson(encryptionData3)));
            default:
                return null;
        }
    }

    public void sendlist(ExamPrepItem examPrepItem) {
        this.examPrepItem = examPrepItem;
        notifyDataSetChanged();
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
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Courses.Adapter.DirectLayer3Adapter.SuccessCallBack(org.json.JSONObject, java.lang.String, java.lang.String, boolean):void");
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
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DirectLayer3Adapter directLayer3Adapter = DirectLayer3Adapter.this;
                    TextView textView9 = textView5;
                    TestBasicInst testBasicInst = testBasic;
                    TextView textView10 = textView8;
                    directLayer3Adapter.showPopMenuForLangauge(textView9, testBasicInst, textView10, textView10);
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
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (testBasic.getTotalQuestions().equalsIgnoreCase("0")) {
                    Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.please_add_question), 0).show();
                    return;
                }
                if (checkBox3.isChecked()) {
                    dialog3.dismiss();
                    DirectLayer3Adapter.this.quiz_id = testBasic.getId();
                    DirectLayer3Adapter directLayer3Adapter = DirectLayer3Adapter.this;
                    new NetworkCall(directLayer3Adapter, directLayer3Adapter.activity).NetworkAPICall(API.API_GET_INFO_TEST_SERIES, "", true, false);
                    return;
                }
                Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.please_check_following_instructions), 0).show();
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
                this.parentLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter.FaqListRecyclerAdapter.FaqListHolder.1
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
        LeftMenu leftMenu;
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
            long j;
            if (list != null && list.size() > 0) {
                LeftMenu leftMenu = (LeftMenu) new Gson().fromJson(DirectLayer3Adapter.this.themeSettings.getLeft_menu(), LeftMenu.class);
                this.leftMenu = leftMenu;
                if (Helper.isShowShareButton(leftMenu)) {
                    this.share.setVisibility(0);
                } else {
                    this.share.setVisibility(8);
                }
                this.ibt_single_sub_vd_RL.setVisibility(0);
                this.no_data_found_RL.setVisibility(8);
                if (list.get(position).getIs_locked().equals("0")) {
                    this.lockRL.setVisibility(8);
                } else {
                    this.lockRL.setVisibility(0);
                }
                if (DirectLayer3Adapter.this.isSkip.equalsIgnoreCase("3")) {
                    this.share.setVisibility(8);
                    this.titleCategory.setText(list.get(position).getTest_series_name());
                    if (Helper.isLiveTest(list.get(position).getTest_series_type()) && !list.get(position).getEnd_date().equalsIgnoreCase("0") && !list.get(position).getEnd_date().equalsIgnoreCase("")) {
                        this.subItemRV.setVisibility(0);
                        j = 1000;
                        this.subItemRV.setText(DirectLayer3Adapter.this.activity.getResources().getString(R.string.test_end) + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(list.get(position).getEnd_date()) * 1000))));
                    } else {
                        j = 1000;
                        this.subItemRV.setVisibility(8);
                    }
                    if (Helper.isLiveTest(list.get(position).getTest_series_type()) && !list.get(position).getStart_date().equalsIgnoreCase("0") && !list.get(position).getStart_date().equalsIgnoreCase("")) {
                        this.startdate.setVisibility(0);
                        this.startdate.setText(DirectLayer3Adapter.this.activity.getResources().getString(R.string.test_start) + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(list.get(position).getStart_date()) * j))));
                    } else {
                        this.startdate.setVisibility(8);
                    }
                    this.attemptLL.setVisibility(8);
                    if (!TextUtils.isEmpty(list.get(position).getImage())) {
                        Helper.setThumbnailImage(DirectLayer3Adapter.this.activity, list.get(position).getImage(), DirectLayer3Adapter.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.imageIcon);
                    } else {
                        this.imageIcon.setImageResource(R.mipmap.square_placeholder);
                    }
                    if (DirectLayer3Adapter.this.isSkip.equalsIgnoreCase("3")) {
                        setSubjectiveTestOnClick(list.get(position));
                    }
                    if (list.get(position - 1).getIs_locked().equals("1")) {
                        this.learn.setVisibility(8);
                        this.attemptLL.setVisibility(8);
                        this.practice.setVisibility(8);
                        return;
                    }
                    return;
                }
                this.share.setVisibility(8);
                this.subItemRV.setVisibility(0);
                this.attemptLL.setVisibility(8);
                this.learn.setVisibility(8);
                this.practice.setVisibility(8);
                this.subjectBTNLL.setVisibility(8);
                if (!TextUtils.isEmpty(list.get(position).getImage_icon())) {
                    Helper.setThumbnailImage(DirectLayer3Adapter.this.activity, list.get(position).getImage_icon(), DirectLayer3Adapter.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.imageIcon);
                } else {
                    this.imageIcon.setImageResource(R.mipmap.square_placeholder);
                }
                this.subItemRV.setVisibility(8);
                this.subItemRV.setText(DirectLayer3Adapter.this.activity.getResources().getString(R.string.total) + list.get(position).getCount());
                this.titleCategory.setText(list.get(position).getTitle());
                this.studyitemLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter.SingleStudySubjectiveTestListHolder.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str;
                        String str2;
                        String str3;
                        if (((Lists) list.get(position)).getIs_locked().equalsIgnoreCase("1")) {
                            if (DirectLayer3Adapter.this.isCourseSoldOut()) {
                                Toast.makeText(DirectLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                                return;
                            }
                            Intent intent = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                            intent.putExtra(Const.SINGLE_STUDY, DirectLayer3Adapter.this.singleStudy);
                            Helper.gotoActivity(intent, DirectLayer3Adapter.this.activity);
                            return;
                        }
                        if (DirectLayer3Adapter.this.isSkip.equalsIgnoreCase("1")) {
                            str = "title";
                            str2 = Const.TILE_TYPE;
                            str3 = Const.REVERT_API;
                        } else {
                            str3 = Const.REVERT_API;
                            if (!DirectLayer3Adapter.this.isSkip.equalsIgnoreCase("2")) {
                                if (DirectLayer3Adapter.this.isSkip.equalsIgnoreCase("3")) {
                                    return;
                                }
                                ExamPrepItem examPrepItem = new ExamPrepItem();
                                examPrepItem.setList(DirectLayer3Adapter.this.examPrepItem.getList().get(position).getList());
                                Intent intent2 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) CourseActivity.class);
                                SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(DirectLayer3Adapter.this.singleStudy != null ? DirectLayer3Adapter.this.singleStudy : new CourseDetail()));
                                SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(examPrepItem));
                                SharedPreference.getInstance().putString("list", new Gson().toJson(list.get(position) != null ? list.get(position) : new Lists()));
                                intent2.putExtra(Const.FRAG_TYPE, Const.EXAMPREP);
                                intent2.putExtra(Const.IS_COMBO, DirectLayer3Adapter.this.isCombo);
                                intent2.putExtra("content_type", DirectLayer3Adapter.this.contentType);
                                if (DirectLayer3Adapter.this.tileTypeAPI.equals(Const.COMBO) || DirectLayer3Adapter.this.tileTypeAPI.equals("content")) {
                                    intent2.putExtra(Const.TAB_TILE_VISIBILITY, "1");
                                } else {
                                    intent2.putExtra(Const.TAB_TILE_VISIBILITY, "0");
                                }
                                intent2.putExtra("title", DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail() != null ? DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getTitle() : "Course");
                                intent2.putExtra("tile_id", DirectLayer3Adapter.this.tileIdAPI);
                                intent2.putExtra(Const.TILE_TYPE, DirectLayer3Adapter.this.tileTypeAPI);
                                intent2.putExtra(str3, DirectLayer3Adapter.this.revertAPI);
                                Helper.gotoActivity(intent2, DirectLayer3Adapter.this.activity);
                                return;
                            }
                            str = "title";
                            str2 = Const.TILE_TYPE;
                        }
                        String str4 = str2;
                        Intent intent3 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) CourseActivity.class);
                        SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(DirectLayer3Adapter.this.singleStudy != null ? DirectLayer3Adapter.this.singleStudy : new CourseDetail()));
                        SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(DirectLayer3Adapter.this.examPrepItem != null ? DirectLayer3Adapter.this.examPrepItem : new ExamPrepItem()));
                        SharedPreference.getInstance().putString("list", new Gson().toJson(DirectLayer3Adapter.this.examPrepItem.getList().get(position) != null ? DirectLayer3Adapter.this.examPrepItem.getList().get(position) : new Lists()));
                        intent3.putExtra(Const.FRAG_TYPE, Const.EXAMPREPLAST);
                        intent3.putExtra(Const.IS_COMBO, DirectLayer3Adapter.this.isCombo);
                        intent3.putExtra(str, DirectLayer3Adapter.this.examPrepItem.getList().get(position).getTitle());
                        intent3.putExtra("content_type", DirectLayer3Adapter.this.contentType);
                        if (DirectLayer3Adapter.this.tileTypeAPI.equals(Const.COMBO) || DirectLayer3Adapter.this.tileTypeAPI.equals("content")) {
                            intent3.putExtra(Const.TAB_TILE_VISIBILITY, "1");
                        } else {
                            intent3.putExtra(Const.TAB_TILE_VISIBILITY, "0");
                        }
                        intent3.putExtra(Const.TEST_TYPE, DirectLayer3Adapter.this.examPrepItem.getList().get(position).getCount());
                        intent3.putExtra("tile_id", DirectLayer3Adapter.this.tileIdAPI);
                        intent3.putExtra(str4, DirectLayer3Adapter.this.tileTypeAPI);
                        intent3.putExtra(Const.LIST_SUBJECT, DirectLayer3Adapter.this.examPrepItem.getList().get(position));
                        intent3.putExtra(str3, DirectLayer3Adapter.this.revertAPI);
                        Helper.gotoActivity(intent3, DirectLayer3Adapter.this.activity);
                    }
                });
                return;
            }
            this.ibt_single_sub_vd_RL.setVisibility(8);
            this.no_data_found_RL.setVisibility(0);
            this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter.SingleStudySubjectiveTestListHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DirectLayer3Adapter.this.activity.finish();
                }
            });
        }

        public void setSubjectiveTestOnClick(final Lists video) {
            com.appnew.android.home.Constants.SUB_TEST_ID = video.getId();
            this.paper.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter.SingleStudySubjectiveTestListHolder.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    StringBuilder sbAppend;
                    if (System.currentTimeMillis() < Long.parseLong(video.getStart_date()) * 1000) {
                        Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.test_will_start_on) + new SimpleDateFormat("dd/MM/yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video.getStart_date()) * 1000)), 0).show();
                        return;
                    }
                    if (!Helper.isConnected(DirectLayer3Adapter.this.activity)) {
                        Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                        return;
                    }
                    if (video.getQuestion().equalsIgnoreCase("")) {
                        return;
                    }
                    com.appnew.android.home.Constants.SUB_TEST_ID = video.getId();
                    video.getQuestion().split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r9.length - 1].split("\\.");
                    Activity activity = DirectLayer3Adapter.this.activity;
                    String id = video.getId();
                    String question = video.getQuestion();
                    String title = video.getTitle();
                    boolean zEqualsIgnoreCase = SingleStudy.parentCourseId.equalsIgnoreCase("");
                    String id2 = MqttTopic.MULTI_LEVEL_WILDCARD;
                    if (zEqualsIgnoreCase) {
                        sbAppend = new StringBuilder().append(DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
                    } else {
                        sbAppend = new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD);
                        id2 = DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId();
                    }
                    Helper.GoToWebViewPDFActivity(activity, id, question, true, title, sbAppend.append(id2).toString(), video.getIs_share());
                }
            });
            this.upload.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter$SingleStudySubjectiveTestListHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setSubjectiveTestOnClick$0(video, view);
                }
            });
            this.booklet.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter.SingleStudySubjectiveTestListHolder.4
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (Long.parseLong(video.getResult_date()) * 1000 < System.currentTimeMillis()) {
                        if (!Helper.isConnected(DirectLayer3Adapter.this.activity)) {
                            Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                            return;
                        }
                        if (DirectLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                            if (!video.getAnswers().equalsIgnoreCase("")) {
                                com.appnew.android.home.Constants.SUB_TEST_ID = video.getId();
                                Helper.GoToWebViewPDFActivity(DirectLayer3Adapter.this.activity, video.getId(), video.getAnswers(), true, video.getAnswers().split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r11.length - 1].split("\\.")[0], SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId(), video.getIs_share());
                                return;
                            }
                            Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.file_not_found), 0).show();
                            return;
                        }
                        if (video.getIs_locked().equalsIgnoreCase("1")) {
                            if (DirectLayer3Adapter.this.isCourseSoldOut()) {
                                Toast.makeText(DirectLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                                return;
                            }
                            Intent intent = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                            intent.putExtra(Const.SINGLE_STUDY, DirectLayer3Adapter.this.singleStudy);
                            Helper.gotoActivity(intent, DirectLayer3Adapter.this.activity);
                            return;
                        }
                        com.appnew.android.home.Constants.SUB_TEST_ID = video.getId();
                        Helper.GoToWebViewPDFActivity(DirectLayer3Adapter.this.activity, video.getId(), video.getAnswers(), true, video.getAnswers().split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r11.length - 1].split("\\.")[0], SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId(), video.getIs_share());
                        return;
                    }
                    Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.booklet_will_be_available_on) + new SimpleDateFormat("dd/MM/yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video.getResult_date()) * 1000)), 0).show();
                }
            });
            this.marks.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter.SingleStudySubjectiveTestListHolder.5
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (Long.parseLong(video.getResult_date()) * 1000 < System.currentTimeMillis()) {
                        if (!Helper.isConnected(DirectLayer3Adapter.this.activity)) {
                            Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                            return;
                        }
                        if (DirectLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                            com.appnew.android.home.Constants.SUB_TEST_ID = video.getId();
                            Helper.GoToSubjectiveResultActivity(DirectLayer3Adapter.this.activity, video.getSolutions(), video.getTitle(), DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId(), video.getId(), DirectLayer3Adapter.this.contentType);
                            return;
                        } else {
                            if (video.getIs_locked().equalsIgnoreCase("1")) {
                                if (DirectLayer3Adapter.this.isCourseSoldOut()) {
                                    Toast.makeText(DirectLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                                    return;
                                }
                                Intent intent = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                                intent.putExtra(Const.SINGLE_STUDY, DirectLayer3Adapter.this.singleStudy);
                                Helper.gotoActivity(intent, DirectLayer3Adapter.this.activity);
                                return;
                            }
                            com.appnew.android.home.Constants.SUB_TEST_ID = video.getId();
                            Helper.GoToSubjectiveResultActivity(DirectLayer3Adapter.this.activity, video.getSolutions(), video.getTitle(), DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId(), video.getId(), DirectLayer3Adapter.this.contentType);
                            return;
                        }
                    }
                    Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.result_will_be_available_on) + new SimpleDateFormat("dd/MM/yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(video.getResult_date()) * 1000)), 0).show();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setSubjectiveTestOnClick$0(Lists lists, View view) {
            if (this.upload.getText().toString().equalsIgnoreCase("View")) {
                Intent intent = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) PdfDetailScreen.class);
                intent.putExtra(Const.THUMBNAIL, lists.getThumbnail_url());
                intent.putExtra("url", lists.getAnswers_by_student());
                intent.putExtra("file_type", lists.getFile_type());
                DirectLayer3Adapter.this.activity.startActivity(intent);
                return;
            }
            if (System.currentTimeMillis() > Long.parseLong(lists.getEnd_date()) * 1000 || MakeMyExam.time_server > Long.parseLong(lists.getEnd_date()) * 1000) {
                Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.you_cant_upload_message), 0).show();
                return;
            }
            if (System.currentTimeMillis() < Long.parseLong(lists.getStart_date()) * 1000 && MakeMyExam.time_server < Long.parseLong(lists.getStart_date()) * 1000) {
                Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.test_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(lists.getStart_date()) * 1000)), 0).show();
                return;
            }
            if (!Helper.isConnected(DirectLayer3Adapter.this.activity)) {
                Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                return;
            }
            if (DirectLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                if (lists.getUpload_allowed() != null && lists.getUpload_allowed().equalsIgnoreCase("1")) {
                    com.appnew.android.home.Constants.SUB_TEST_ID = lists.getId();
                    checkStoragePermission();
                    return;
                } else {
                    Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.you_cant_upload_now), 0).show();
                    return;
                }
            }
            if (lists.getIs_locked().equalsIgnoreCase("1")) {
                if (DirectLayer3Adapter.this.isCourseSoldOut()) {
                    Toast.makeText(DirectLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent2 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent2.putExtra(Const.SINGLE_STUDY, DirectLayer3Adapter.this.singleStudy);
                Helper.gotoActivity(intent2, DirectLayer3Adapter.this.activity);
                return;
            }
            if (lists.getUpload_allowed() != null && lists.getUpload_allowed().equalsIgnoreCase("1")) {
                com.appnew.android.home.Constants.SUB_TEST_ID = lists.getId();
                checkStoragePermission();
            } else {
                Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.you_cant_upload_now), 0).show();
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
            DirectLayer3Adapter directLayer3Adapter = DirectLayer3Adapter.this;
            new NetworkCall(directLayer3Adapter, directLayer3Adapter.activity).NetworkAPICall(API.API_GET_TEST_INSTRUCTION_DATA, "", true, false);
        }

        public void result_without_submit(final String quiz_id, String course_id, String s, final String quiz_name) {
            if (Helper.isNetworkConnected(DirectLayer3Adapter.this.activity)) {
                final Progress progress = new Progress(DirectLayer3Adapter.this.activity);
                progress.show();
                APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setTest_id(quiz_id);
                encryptionData.setCourse_id(course_id);
                encryptionData.setFirst_attempt(s);
                aPIInterface.getTestlearn(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new Callback<String>() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter.SingleStudySubjectiveTestListHolder.6
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
                                Helper.showToastSecurity(DirectLayer3Adapter.this.activity);
                                return;
                            }
                            try {
                                if (resultTestSeries_Report.getStatus().equalsIgnoreCase("true")) {
                                    SharedPreference.getInstance().putString("testresult", new Gson().toJson(resultTestSeries_Report));
                                    Intent intent = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) ViewSolutionActivity.class);
                                    intent.putExtra(Const.TESTSEGMENT_ID, quiz_id);
                                    intent.putExtra(Const.FRAG_TYPE, Const.SOLUTIONREPORT);
                                    intent.putExtra("name", quiz_name);
                                    intent.putExtra("type", "learn");
                                    if (!resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("1")) {
                                        if (resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("2")) {
                                            DirectLayer3Adapter.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                                        }
                                    } else {
                                        DirectLayer3Adapter.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                                    }
                                    intent.putExtra(Const.LANG, DirectLayer3Adapter.this.lang);
                                    Helper.gotoActivity(intent, DirectLayer3Adapter.this.activity);
                                    return;
                                }
                                progress.dismiss();
                                RetrofitResponse.GetApiData(DirectLayer3Adapter.this.activity, jSONObject.optString("auth_code"), jSONObject.optString("message"), false);
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
            Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.Retry_with_Internet_connection), 1).show();
        }

        public void netoworkCallForQuizResult2(final String quiz_id, String course_id, String s, final String quiz_name) {
            if (Helper.isNetworkConnected(DirectLayer3Adapter.this.activity)) {
                final Progress progress = new Progress(DirectLayer3Adapter.this.activity);
                progress.show();
                APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setTest_id(quiz_id);
                encryptionData.setCourse_id(course_id);
                encryptionData.setFirst_attempt(s);
                aPIInterface.getTestResult(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new Callback<String>() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter.SingleStudySubjectiveTestListHolder.7
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
                                Helper.showToastSecurity(DirectLayer3Adapter.this.activity);
                                return;
                            }
                            try {
                                if (resultTestSeries_Report.getStatus().equalsIgnoreCase("true")) {
                                    if (resultTestSeries_Report.getData().getQuestions() != null && resultTestSeries_Report.getData().getQuestions().size() > 0) {
                                        SharedPreference.getInstance().putString("testresult", new Gson().toJson(resultTestSeries_Report));
                                        Intent intent = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) ViewSolutionActivity.class);
                                        intent.putExtra(Const.TESTSEGMENT_ID, quiz_id);
                                        intent.putExtra(Const.FRAG_TYPE, Const.SOLUTIONREPORT);
                                        intent.putExtra("name", quiz_name);
                                        intent.putExtra("type", "learn");
                                        if (!resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("1")) {
                                            if (resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("2")) {
                                                DirectLayer3Adapter.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                                            }
                                        } else {
                                            DirectLayer3Adapter.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                                        }
                                        intent.putExtra(Const.LANG, DirectLayer3Adapter.this.lang);
                                        Helper.gotoActivity(intent, DirectLayer3Adapter.this.activity);
                                        return;
                                    }
                                    Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.no_question_found), 0).show();
                                    return;
                                }
                                progress.dismiss();
                                RetrofitResponse.GetApiData(DirectLayer3Adapter.this.activity, jSONObject.optString("auth_code"), jSONObject.optString("message"), false);
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
            Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.Retry_with_Internet_connection), 1).show();
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
                this.recyclerView.setLayoutManager(new LinearLayoutManager(DirectLayer3Adapter.this.activity, 1, false));
                this.recyclerView.setAdapter(DirectLayer3Adapter.this.new FaqListRecyclerAdapter(faqData, 0));
                this.recyclerView.setNestedScrollingEnabled(false);
                return;
            }
            this.no_data_found_RL.setVisibility(0);
            this.recyclerView.setVisibility(8);
            this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter.FAQViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DirectLayer3Adapter.this.activity.finish();
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
                if (DirectLayer3Adapter.this.isLodded.booleanValue()) {
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
                    OverviewRVAdapter overviewRVAdapter = new OverviewRVAdapter(DirectLayer3Adapter.this.activity, basic, overview, this.recyclerView, z, z2);
                    this.recyclerView.setLayoutManager(new LinearLayoutManager(DirectLayer3Adapter.this.activity, 1, false));
                    this.recyclerView.setAdapter(overviewRVAdapter);
                    DirectLayer3Adapter.this.isLodded = false;
                    return;
                }
                return;
            }
            this.recyclerView.setVisibility(8);
            this.no_data_found_RL.setVisibility(0);
            this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter.OverViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DirectLayer3Adapter.this.activity.finish();
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
                this.headerLL.setBackgroundColor(DirectLayer3Adapter.this.activity.getResources().getColor(R.color.white));
                this.imageRL.setVisibility(8);
            } else {
                this.headerLL.setBackgroundColor(DirectLayer3Adapter.this.activity.getResources().getColor(R.color.colorPrimaryDark));
                this.imageRL.setVisibility(0);
                if (!TextUtils.isEmpty(singleStudy.getData().getCourseDetail().getDescHeaderImage())) {
                    Helper.setThumbnailImage(DirectLayer3Adapter.this.activity, singleStudy.getData().getCourseDetail().getDescHeaderImage(), DirectLayer3Adapter.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.coursebg);
                } else {
                    this.coursebg.setImageResource(R.mipmap.square_placeholder);
                }
                if (singleStudy.getData().getCourseDetail() != null) {
                    this.course_name.setText(singleStudy.getData().getCourseDetail().getTitle());
                    if (!GenericUtils.isEmpty(singleStudy.getData().getCourseDetail().getAuthor().getTitle()) && !singleStudy.getData().getCourseDetail().getAuthor().getTitle().equalsIgnoreCase("Utkarsh classes")) {
                        this.authorname.setText(DirectLayer3Adapter.this.activity.getResources().getString(R.string.by) + singleStudy.getData().getCourseDetail().getAuthor().getTitle());
                    } else {
                        this.authorname.setText(DirectLayer3Adapter.this.activity.getResources().getString(R.string.by) + DirectLayer3Adapter.this.activity.getResources().getString(R.string.app_name));
                    }
                    if (singleStudy.getData().getCourseDetail().getValidity().equals("") || singleStudy.getData().getCourseDetail().getValidity().equals("0") || singleStudy.getData().getCourseDetail().getValidity().equalsIgnoreCase("0 Days") || singleStudy.getData().getCourseDetail().getValidity().equals("-1") || singleStudy.getData().getCourseDetail().getValidity().equalsIgnoreCase("-1 Days")) {
                        this.validityTV.setVisibility(8);
                    } else {
                        this.validityTV.setVisibility(0);
                    }
                    this.validityTV.setText(DirectLayer3Adapter.this.activity.getResources().getString(R.string.validity_) + singleStudy.getData().getCourseDetail().getValidity());
                    this.courseid.setText(singleStudy.getData().getCourseDetail().getId());
                    if (singleStudy.getData().getCourseDetail().getViewType().equalsIgnoreCase("0")) {
                        this.type.setText(DirectLayer3Adapter.this.activity.getResources().getString(R.string.online));
                    } else if (singleStudy.getData().getCourseDetail().getViewType().equalsIgnoreCase("1")) {
                        this.type.setText(DirectLayer3Adapter.this.activity.getResources().getString(R.string.offline));
                    } else if (singleStudy.getData().getCourseDetail().getViewType().equalsIgnoreCase("2")) {
                        this.type.setText(DirectLayer3Adapter.this.activity.getResources().getString(R.string.package_));
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
            TileItemsAdapter tileItemsAdapter = new TileItemsAdapter(DirectLayer3Adapter.this.activity, arrayList);
            this.tileRv.setLayoutManager(new LinearLayoutManager(DirectLayer3Adapter.this.activity, 0, false));
            this.tileRv.setAdapter(tileItemsAdapter);
            this.tileRv.setNestedScrollingEnabled(false);
            this.tileRv.scrollToPosition(DirectLayer3Adapter.this.tilePos);
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
                        Glide.with(DirectLayer3Adapter.this.activity).asGif().load(Integer.valueOf(R.mipmap.live)).into(holder.liveIv);
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
                if (DirectLayer3Adapter.this.contentType.equals(tilesItem.getType() + tilesItem.getId())) {
                    holder.tilesText.setTextColor(this.context.getResources().getColor(R.color.colorPrimary));
                    holder.bg_bottom.setVisibility(0);
                } else {
                    holder.tilesText.setTextColor(this.context.getResources().getColor(R.color.black));
                    holder.bg_bottom.setVisibility(8);
                    holder.tilesText.setTextColor(this.context.getResources().getColor(R.color.country_code_text_color));
                }
                holder.parent.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter.SingleStudyHeaderHolder.TileItemsAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        DirectLayer3Adapter.this.contentType = tilesItem.getType() + tilesItem.getId();
                        DirectLayer3Adapter.this.tilePos = position;
                        DirectLayer3Adapter.this.buttonClicked.onTitleClicked(tilesItem, DirectLayer3Adapter.this.singleStudy.getData().getTiles(), DirectLayer3Adapter.this.tilePos);
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
            this.comboRV.setLayoutManager(new LinearLayoutManager(DirectLayer3Adapter.this.activity));
            this.comboRV.setHasFixedSize(true);
            this.comboRV.setNestedScrollingEnabled(false);
            this.networkCall = new NetworkCall(this, DirectLayer3Adapter.this.activity);
            if (DirectLayer3Adapter.this.singleStudy != null && DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail() != null && !TextUtils.isEmpty(DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getIsPurchased())) {
                this.isPurchased = DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getIsPurchased();
            }
            hit_api_for_data(true);
            this.view_all.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter$SingleStudyComboHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setData$0(view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$0(View view) {
            Intent intent = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) ComboListActivity.class);
            intent.putExtra("title", DirectLayer3Adapter.this.singleStudy.getData().getTiles().get(DirectLayer3Adapter.this.tilePos) != null ? DirectLayer3Adapter.this.singleStudy.getData().getTiles().get(DirectLayer3Adapter.this.tilePos).getTileName() : "Combo Course");
            intent.putExtra(Const.SINGLE_STUDY_DATA, DirectLayer3Adapter.this.singleStudy);
            Helper.gotoActivity(intent, DirectLayer3Adapter.this.activity);
        }

        private void hit_api_for_data(boolean showProgress) {
            this.networkCall.NetworkAPICall(API.get_combo_course_list, "", showProgress, false);
        }

        @Override // com.appnew.android.Courses.Adapter.ComboListAdapter.onButtonClicked
        public void onCourseClicked(int pos) {
            if (this.courseDataArrayList.get(pos).getIs_locked().equalsIgnoreCase("1")) {
                if (DirectLayer3Adapter.this.isCourseSoldOut()) {
                    Toast.makeText(DirectLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, DirectLayer3Adapter.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, DirectLayer3Adapter.this.activity);
                return;
            }
            if (TextUtils.isEmpty(this.courseDataArrayList.get(pos).getMaintenanceText())) {
                Intent intent2 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) CourseActivity.class);
                intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                intent2.putExtra(Const.COURSE_ID_MAIN, this.courseDataArrayList.get(pos).getId());
                intent2.putExtra(Const.COURSE_PARENT_ID, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
                intent2.putExtra(Const.CONTENT_TYPE_1, this.courseDataArrayList.get(pos).getContent_type());
                intent2.putExtra(Const.IS_COMBO, true);
                intent2.putExtra("valid_to", DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getValid_to());
                intent2.putExtra(AnalyticsConstants.course_name, this.courseDataArrayList.get(pos).getTitle());
                Helper.gotoActivity(intent2, DirectLayer3Adapter.this.activity);
                return;
            }
            Helper.getCourseMaintanaceDialog(DirectLayer3Adapter.this.activity, "", this.courseDataArrayList.get(pos).getMaintenanceText());
        }

        @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
        public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
            apitype.hashCode();
            if (!apitype.equals(API.get_combo_course_list)) {
                return null;
            }
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setCourse_id(DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
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
                                ComboListAdapter comboListAdapter = new ComboListAdapter(DirectLayer3Adapter.this.activity, this.courseDataArrayList, this.isPurchased, this);
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
                        Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.data_not_found), 0).show();
                        return;
                    }
                    this.isPaginationAvailable = false;
                    this.no_data_found_RL.setVisibility(0);
                    this.comboRV.setVisibility(8);
                    if (!jsonstring.has("auth_code") || GenericUtils.isEmpty(jsonstring.getString("auth_code"))) {
                        return;
                    }
                    RetrofitResponse.GetApiData(DirectLayer3Adapter.this.activity, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
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
        Button backBtn;
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

        public SingleStudyTestListHolder(View itemView) {
            super(itemView);
            this.lockRL = (RelativeLayout) itemView.findViewById(R.id.lockRL);
            this.parentLL = (RelativeLayout) itemView.findViewById(R.id.parentLL);
            this.studyitemLL = (RelativeLayout) itemView.findViewById(R.id.study_single_itemLL);
            this.imageIcon = (ImageView) itemView.findViewById(R.id.profileImage);
            this.titleCategory = (TextView) itemView.findViewById(R.id.examPrepTitleTV);
            this.subItemRV = (TextView) itemView.findViewById(R.id.subItemRV);
            this.attemptLL = (LinearLayout) itemView.findViewById(R.id.attemptLL);
            this.no_data_found_RL = (RelativeLayout) itemView.findViewById(R.id.no_data_found_RL);
            this.backBtn = (Button) itemView.findViewById(R.id.backBtn);
            this.ibt_single_sub_vd_RL = (CardView) itemView.findViewById(R.id.ibt_single_sub_vd_RL);
            this.learn = (TextView) itemView.findViewById(R.id.learn);
            this.share = (ImageView) itemView.findViewById(R.id.share);
            this.practice = (TextView) itemView.findViewById(R.id.practice);
            this.startdate = (TextView) itemView.findViewById(R.id.startdate);
        }

        public void setData(final ArrayList<Lists> list, final int position) {
            long j;
            if (list != null && list.size() > 0) {
                this.ibt_single_sub_vd_RL.setVisibility(0);
                this.no_data_found_RL.setVisibility(8);
                int i = position - 1;
                if (list.get(i).getIs_locked().equals("0")) {
                    this.lockRL.setVisibility(8);
                } else {
                    this.lockRL.setVisibility(0);
                }
                if (DirectLayer3Adapter.this.isSkip.equalsIgnoreCase("3")) {
                    this.share.setVisibility(0);
                    this.titleCategory.setText(list.get(i).getTest_series_name());
                    if (Helper.isLiveTest(list.get(i).getTest_series_type()) && !list.get(i).getEnd_date().equalsIgnoreCase("0") && !list.get(i).getEnd_date().equalsIgnoreCase("")) {
                        this.subItemRV.setVisibility(0);
                        j = 1000;
                        this.subItemRV.setText(DirectLayer3Adapter.this.activity.getResources().getString(R.string.test_end) + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(list.get(i).getEnd_date()) * 1000))));
                    } else {
                        j = 1000;
                        this.subItemRV.setVisibility(8);
                    }
                    if ("1".equalsIgnoreCase("7")) {
                        if (Helper.isLiveTest(list.get(i).getTest_series_type()) && !list.get(i).getStart_date().equalsIgnoreCase("0") && !list.get(i).getStart_date().equalsIgnoreCase("")) {
                            this.startdate.setVisibility(0);
                            this.startdate.setText(DirectLayer3Adapter.this.activity.getResources().getString(R.string.test_start) + Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(list.get(i).getStart_date()) * j))));
                        } else {
                            this.startdate.setVisibility(8);
                        }
                    }
                    this.attemptLL.setVisibility(0);
                    if (list.get(i).getState().equals("1")) {
                        DirectLayer3Adapter.this.utkashRoom.getTestDao().delete_test_data(MakeMyExam.userId, list.get(i).getId());
                        if (System.currentTimeMillis() >= Long.parseLong(list.get(i).getEnd_date()) * j) {
                            if (list.get(i).getResult_date().equalsIgnoreCase("0") || list.get(i).getResult_date().equalsIgnoreCase("1") || list.get(i).getResult_date().equalsIgnoreCase("")) {
                                this.attemptLL.setVisibility(8);
                                handleLearnPractice(list.get(i));
                            } else if (System.currentTimeMillis() > Long.parseLong(list.get(i).getResult_date()) * j) {
                                if (Long.parseLong(list.get(i).getEnd_date()) < 1640066737) {
                                    this.attemptLL.setVisibility(8);
                                } else {
                                    this.attemptLL.getChildAt(0).setVisibility(0);
                                    ((TextView) this.attemptLL.getChildAt(0)).setText(DirectLayer3Adapter.this.activity.getResources().getString(R.string.view_rank));
                                }
                                handleLearnPractice(list.get(i));
                            } else {
                                this.attemptLL.setVisibility(0);
                                ((TextView) this.attemptLL.getChildAt(0)).setText(DirectLayer3Adapter.this.activity.getResources().getString(R.string.attempted_));
                                handleLearnPractice(list.get(i));
                            }
                        } else if (!list.get(i).getIs_reattempt().equalsIgnoreCase("0")) {
                            this.learn.setVisibility(8);
                            this.practice.setVisibility(8);
                            this.attemptLL.setVisibility(0);
                            ((TextView) this.attemptLL.getChildAt(0)).setText(DirectLayer3Adapter.this.activity.getResources().getString(R.string.re_aTTEMPT));
                        } else if (list.get(i).getResult_date() == null || list.get(i).getResult_date().equalsIgnoreCase("1") || list.get(i).getResult_date().equalsIgnoreCase("0") || list.get(i).getResult_date().equalsIgnoreCase("")) {
                            this.learn.setVisibility(8);
                            this.practice.setVisibility(8);
                            this.attemptLL.getChildAt(0).setVisibility(0);
                            ((TextView) this.attemptLL.getChildAt(0)).setText(DirectLayer3Adapter.this.activity.getResources().getString(R.string.view_rank));
                        } else {
                            this.learn.setVisibility(8);
                            this.practice.setVisibility(8);
                            this.attemptLL.getChildAt(0).setVisibility(0);
                            ((TextView) this.attemptLL.getChildAt(0)).setText(DirectLayer3Adapter.this.activity.getResources().getString(R.string.attempted));
                        }
                    } else if (System.currentTimeMillis() >= Long.parseLong(list.get(i).getEnd_date()) * j) {
                        if (list.get(i).getResult_date().equalsIgnoreCase("0") || list.get(i).getResult_date().equalsIgnoreCase("1") || list.get(i).getResult_date().equalsIgnoreCase("")) {
                            this.attemptLL.setVisibility(8);
                            handleLearnPractice(list.get(i));
                        }
                        if (Long.parseLong(list.get(i).getResult_date()) * j <= System.currentTimeMillis() && System.currentTimeMillis() > Long.parseLong(list.get(i).getResult_date()) * j) {
                            if (Long.parseLong(list.get(i).getEnd_date()) < 1640066737) {
                                this.attemptLL.setVisibility(8);
                            } else {
                                this.attemptLL.getChildAt(0).setVisibility(0);
                                ((TextView) this.attemptLL.getChildAt(0)).setText(DirectLayer3Adapter.this.activity.getResources().getString(R.string.view_rank));
                            }
                            handleLearnPractice(list.get(i));
                        } else {
                            this.attemptLL.setVisibility(8);
                            handleLearnPractice(list.get(i));
                        }
                    } else if (System.currentTimeMillis() < Long.parseLong(list.get(i).getStart_date()) * j) {
                        this.attemptLL.getChildAt(0).setVisibility(0);
                        ((TextView) this.attemptLL.getChildAt(0)).setText(DirectLayer3Adapter.this.activity.getResources().getString(R.string.test_is_upcoming));
                        this.learn.setVisibility(8);
                        this.practice.setVisibility(8);
                    } else {
                        TestTable testTableTest_data = DirectLayer3Adapter.this.utkashRoom.getTestDao().test_data(list.get(i).getId(), MakeMyExam.userId);
                        if (testTableTest_data != null && testTableTest_data.getStatus() != null && !testTableTest_data.getStatus().equalsIgnoreCase("")) {
                            this.attemptLL.getChildAt(0).setVisibility(0);
                            ((TextView) this.attemptLL.getChildAt(0)).setText(testTableTest_data.getStatus());
                            this.learn.setVisibility(8);
                            this.practice.setVisibility(8);
                        } else {
                            this.attemptLL.getChildAt(0).setVisibility(0);
                        }
                        ((TextView) this.attemptLL.getChildAt(0)).setText(DirectLayer3Adapter.this.activity.getResources().getString(R.string.attempt_now));
                        this.learn.setVisibility(8);
                        this.practice.setVisibility(8);
                    }
                    if (!TextUtils.isEmpty(list.get(i).getThumbnail_url())) {
                        Helper.setThumbnailImage(DirectLayer3Adapter.this.activity, list.get(i).getThumbnail_url(), DirectLayer3Adapter.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.imageIcon);
                    } else {
                        this.imageIcon.setImageResource(R.mipmap.square_placeholder);
                    }
                    if (list.get(i).getIs_locked().equals("1")) {
                        this.learn.setVisibility(8);
                        this.attemptLL.setVisibility(8);
                        this.practice.setVisibility(8);
                    }
                } else {
                    this.share.setVisibility(8);
                    this.subItemRV.setVisibility(0);
                    this.attemptLL.setVisibility(8);
                    this.learn.setVisibility(8);
                    this.practice.setVisibility(8);
                    if (!TextUtils.isEmpty(list.get(i).getImage_icon())) {
                        Helper.setThumbnailImage(DirectLayer3Adapter.this.activity, list.get(i).getImage_icon(), DirectLayer3Adapter.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.imageIcon);
                    } else {
                        this.imageIcon.setImageResource(R.mipmap.square_placeholder);
                    }
                    this.subItemRV.setVisibility(8);
                    this.subItemRV.setText(DirectLayer3Adapter.this.activity.getResources().getString(R.string.total_) + list.get(i).getCount());
                    this.titleCategory.setText(list.get(i).getTitle());
                }
                if (DirectLayer3Adapter.this.isSkip.equalsIgnoreCase("3")) {
                    this.practice.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter$SingleStudyTestListHolder$$ExternalSyntheticLambda3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$setData$4(list, position, view);
                        }
                    });
                    this.learn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter$SingleStudyTestListHolder$$ExternalSyntheticLambda4
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$setData$5(list, position, view);
                        }
                    });
                    this.attemptLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter$SingleStudyTestListHolder$$ExternalSyntheticLambda5
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$setData$14(list, position, view);
                        }
                    });
                    this.share.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter$SingleStudyTestListHolder$$ExternalSyntheticLambda6
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$setData$15(position, view);
                        }
                    });
                } else {
                    this.studyitemLL.setEnabled(true);
                    this.studyitemLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter.SingleStudyTestListHolder.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (((Lists) list.get(position - 1)).getIs_locked().equalsIgnoreCase("1")) {
                                if (DirectLayer3Adapter.this.isCourseSoldOut()) {
                                    Toast.makeText(DirectLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                                    return;
                                }
                                Intent intent = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                                intent.putExtra(Const.SINGLE_STUDY, DirectLayer3Adapter.this.singleStudy);
                                intent.putExtra(Const.IS_BOOK, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                                intent.putExtra(Const.DELIVERY_CHARGE, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                                Helper.gotoActivity(intent, DirectLayer3Adapter.this.activity);
                                return;
                            }
                            if (DirectLayer3Adapter.this.isSkip.equalsIgnoreCase("1") || DirectLayer3Adapter.this.isSkip.equalsIgnoreCase("2")) {
                                Intent intent2 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) CourseActivity.class);
                                SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(DirectLayer3Adapter.this.singleStudy != null ? DirectLayer3Adapter.this.singleStudy : new CourseDetail()));
                                SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(DirectLayer3Adapter.this.examPrepItem != null ? DirectLayer3Adapter.this.examPrepItem : new ExamPrepItem()));
                                SharedPreference.getInstance().putString("list", new Gson().toJson(DirectLayer3Adapter.this.examPrepItem.getList().get(position + (-1)) != null ? DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1) : new Lists()));
                                intent2.putExtra(Const.FRAG_TYPE, Const.EXAMPREPLAST);
                                intent2.putExtra(Const.IS_COMBO, DirectLayer3Adapter.this.isCombo);
                                intent2.putExtra("title", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getTitle());
                                intent2.putExtra("content_type", DirectLayer3Adapter.this.contentType);
                                intent2.putExtra(Const.TEST_TYPE, DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getCount());
                                intent2.putExtra("tile_id", DirectLayer3Adapter.this.tileIdAPI);
                                intent2.putExtra(Const.TILE_TYPE, DirectLayer3Adapter.this.tileTypeAPI);
                                intent2.putExtra(Const.LIST_SUBJECT, DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1));
                                intent2.putExtra(Const.REVERT_API, DirectLayer3Adapter.this.revertAPI);
                                Helper.gotoActivity(intent2, DirectLayer3Adapter.this.activity);
                                return;
                            }
                            if (DirectLayer3Adapter.this.isSkip.equalsIgnoreCase("3")) {
                                return;
                            }
                            ExamPrepItem examPrepItem = new ExamPrepItem();
                            examPrepItem.setList(DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getList());
                            Intent intent3 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) CourseActivity.class);
                            SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(DirectLayer3Adapter.this.singleStudy != null ? DirectLayer3Adapter.this.singleStudy : new CourseDetail()));
                            SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(examPrepItem));
                            SharedPreference.getInstance().putString("list", new Gson().toJson(list.get(position + (-1)) != null ? list.get(position - 1) : new Lists()));
                            intent3.putExtra(Const.FRAG_TYPE, Const.EXAMPREP);
                            intent3.putExtra(Const.IS_COMBO, DirectLayer3Adapter.this.isCombo);
                            intent3.putExtra("content_type", DirectLayer3Adapter.this.contentType);
                            intent3.putExtra("title", DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail() != null ? DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getTitle() : "Course");
                            intent3.putExtra("tile_id", DirectLayer3Adapter.this.tileIdAPI);
                            intent3.putExtra(Const.TILE_TYPE, DirectLayer3Adapter.this.tileTypeAPI);
                            intent3.putExtra(Const.REVERT_API, DirectLayer3Adapter.this.revertAPI);
                            Helper.gotoActivity(intent3, DirectLayer3Adapter.this.activity);
                        }
                    });
                }
                LeftMenu leftMenu = (LeftMenu) new Gson().fromJson(DirectLayer3Adapter.this.themeSettings.getLeft_menu(), LeftMenu.class);
                this.leftMenu = leftMenu;
                if (Helper.isShowShareButton(leftMenu)) {
                    this.share.setVisibility(0);
                    return;
                } else {
                    this.share.setVisibility(8);
                    return;
                }
            }
            this.ibt_single_sub_vd_RL.setVisibility(8);
            this.no_data_found_RL.setVisibility(0);
            this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter.SingleStudyTestListHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DirectLayer3Adapter.this.activity.finish();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$4(ArrayList arrayList, int i, View view) {
            if (!Helper.isConnected(DirectLayer3Adapter.this.activity)) {
                Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                return;
            }
            if (DirectLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                SharedPreference.getInstance().putString("id", DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
                int i2 = i - 1;
                DirectLayer3Adapter.this.quiz_id = ((Lists) arrayList.get(i2)).getId();
                DirectLayer3Adapter.this.quiz_name = ((Lists) arrayList.get(i2)).getTest_series_name();
                DirectLayer3Adapter.this.totalQuestion = ((Lists) arrayList.get(i2)).getTotal_questions();
                DirectLayer3Adapter.this.result_date = ((Lists) arrayList.get(i2)).getResult_date();
                DirectLayer3Adapter.this.submission_type = ((Lists) arrayList.get(i2)).getSubmission_type();
                DirectLayer3Adapter.this.first_attempt = "0";
                DirectLayer3Adapter.this.videodata = (Lists) arrayList.get(i2);
                Helper.resolveTestPattern(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.videodata.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter$SingleStudyTestListHolder$$ExternalSyntheticLambda14
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setData$0();
                    }
                }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter$SingleStudyTestListHolder$$ExternalSyntheticLambda15
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setData$1();
                    }
                });
                return;
            }
            int i3 = i - 1;
            if (((Lists) arrayList.get(i3)).getIs_locked().equalsIgnoreCase("1")) {
                if (DirectLayer3Adapter.this.isCourseSoldOut()) {
                    Toast.makeText(DirectLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, DirectLayer3Adapter.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, DirectLayer3Adapter.this.activity);
                return;
            }
            SharedPreference.getInstance().putString("id", DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
            DirectLayer3Adapter.this.quiz_id = ((Lists) arrayList.get(i3)).getId();
            DirectLayer3Adapter.this.quiz_name = ((Lists) arrayList.get(i3)).getTest_series_name();
            DirectLayer3Adapter.this.totalQuestion = ((Lists) arrayList.get(i3)).getTotal_questions();
            DirectLayer3Adapter.this.first_attempt = "0";
            DirectLayer3Adapter.this.result_date = ((Lists) arrayList.get(i3)).getResult_date();
            DirectLayer3Adapter.this.videodata = (Lists) arrayList.get(i3);
            DirectLayer3Adapter.this.submission_type = ((Lists) arrayList.get(i3)).getSubmission_type();
            Helper.resolveTestPattern(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.videodata.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter$SingleStudyTestListHolder$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setData$2();
                }
            }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter$SingleStudyTestListHolder$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setData$3();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$0() {
            DirectLayer3Adapter.this.isSSCpattern = false;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$1() {
            DirectLayer3Adapter.this.isSSCpattern = true;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$2() {
            DirectLayer3Adapter.this.isSSCpattern = false;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$3() {
            DirectLayer3Adapter.this.isSSCpattern = true;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$5(ArrayList arrayList, int i, View view) {
            if (!Helper.isConnected(DirectLayer3Adapter.this.activity)) {
                Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                return;
            }
            if (DirectLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                SharedPreference.getInstance().putString("id", DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
                int i2 = i - 1;
                if (((Lists) arrayList.get(i2)).getState().equalsIgnoreCase("1")) {
                    DirectLayer3Adapter.this.quiz_id = ((Lists) arrayList.get(i2)).getId();
                    DirectLayer3Adapter.this.quiz_name = ((Lists) arrayList.get(i2)).getTest_series_name();
                    DirectLayer3Adapter.this.totalQuestion = ((Lists) arrayList.get(i2)).getTotal_questions();
                    result_without_submit(DirectLayer3Adapter.this.quiz_id, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId(), "1", DirectLayer3Adapter.this.quiz_name);
                    return;
                }
                DirectLayer3Adapter.this.quiz_id = ((Lists) arrayList.get(i2)).getId();
                DirectLayer3Adapter.this.quiz_name = ((Lists) arrayList.get(i2)).getTest_series_name();
                DirectLayer3Adapter.this.totalQuestion = ((Lists) arrayList.get(i2)).getTotal_questions();
                result_without_submit(DirectLayer3Adapter.this.quiz_id, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId(), "0", DirectLayer3Adapter.this.quiz_name);
                return;
            }
            int i3 = i - 1;
            if (((Lists) arrayList.get(i3)).getIs_locked().equalsIgnoreCase("1")) {
                if (DirectLayer3Adapter.this.isCourseSoldOut()) {
                    Toast.makeText(DirectLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, DirectLayer3Adapter.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, DirectLayer3Adapter.this.activity);
                return;
            }
            SharedPreference.getInstance().putString("id", DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
            if (((Lists) arrayList.get(i3)).getState().equalsIgnoreCase("1")) {
                DirectLayer3Adapter.this.quiz_id = ((Lists) arrayList.get(i3)).getId();
                DirectLayer3Adapter.this.quiz_name = ((Lists) arrayList.get(i3)).getTest_series_name();
                DirectLayer3Adapter.this.totalQuestion = ((Lists) arrayList.get(i3)).getTotal_questions();
                result_without_submit(DirectLayer3Adapter.this.quiz_id, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId(), "1", DirectLayer3Adapter.this.quiz_name);
                return;
            }
            DirectLayer3Adapter.this.quiz_id = ((Lists) arrayList.get(i3)).getId();
            DirectLayer3Adapter.this.quiz_name = ((Lists) arrayList.get(i3)).getTest_series_name();
            DirectLayer3Adapter.this.totalQuestion = ((Lists) arrayList.get(i3)).getTotal_questions();
            result_without_submit(DirectLayer3Adapter.this.quiz_id, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId(), "0", DirectLayer3Adapter.this.quiz_name);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$14(ArrayList arrayList, int i, View view) {
            if (!Helper.isConnected(DirectLayer3Adapter.this.activity)) {
                Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
                return;
            }
            if (DirectLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                SharedPreference.getInstance().putString("id", DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
                if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("RE-ATTEMPT")) {
                    int i2 = i - 1;
                    DirectLayer3Adapter.this.quiz_id = ((Lists) arrayList.get(i2)).getId();
                    DirectLayer3Adapter.this.quiz_name = ((Lists) arrayList.get(i2)).getTest_series_name();
                    DirectLayer3Adapter.this.totalQuestion = ((Lists) arrayList.get(i2)).getTotal_questions();
                    DirectLayer3Adapter.this.result_date = ((Lists) arrayList.get(i2)).getResult_date();
                    DirectLayer3Adapter.this.submission_type = ((Lists) arrayList.get(i2)).getSubmission_type();
                    DirectLayer3Adapter.this.first_attempt = "0";
                    DirectLayer3Adapter.this.videodata = (Lists) arrayList.get(i2);
                    Helper.resolveTestPattern(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.videodata.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter$SingleStudyTestListHolder$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$setData$6();
                        }
                    }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter$SingleStudyTestListHolder$$ExternalSyntheticLambda7
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$setData$7();
                        }
                    });
                    return;
                }
                if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("Attempt Now")) {
                    int i3 = i - 1;
                    DirectLayer3Adapter.this.quiz_id = ((Lists) arrayList.get(i3)).getId();
                    DirectLayer3Adapter.this.quiz_name = ((Lists) arrayList.get(i3)).getTest_series_name();
                    DirectLayer3Adapter.this.totalQuestion = ((Lists) arrayList.get(i3)).getTotal_questions();
                    DirectLayer3Adapter.this.first_attempt = "1";
                    DirectLayer3Adapter.this.result_date = ((Lists) arrayList.get(i3)).getResult_date();
                    DirectLayer3Adapter.this.submission_type = ((Lists) arrayList.get(i3)).getSubmission_type();
                    DirectLayer3Adapter.this.videodata = (Lists) arrayList.get(i3);
                    Helper.resolveTestPattern(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.videodata.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter$SingleStudyTestListHolder$$ExternalSyntheticLambda8
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$setData$8();
                        }
                    }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter$SingleStudyTestListHolder$$ExternalSyntheticLambda9
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$setData$9();
                        }
                    });
                    return;
                }
                if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("ATTEMPTED")) {
                    int i4 = i - 1;
                    if (((Lists) arrayList.get(i4)).getResult_date() != null && !((Lists) arrayList.get(i4)).getResult_date().equalsIgnoreCase("0") && !((Lists) arrayList.get(i4)).getResult_date().equalsIgnoreCase("1") && !((Lists) arrayList.get(i4)).getResult_date().equalsIgnoreCase("")) {
                        Snackbar.make(view, DirectLayer3Adapter.this.activity.getResources().getString(R.string.your_result_will_be_declare_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(((Lists) arrayList.get(i4)).getResult_date()) * 1000)), -1).show();
                        return;
                    } else if (DirectLayer3Adapter.this.utkashRoom.getTestDao().is_test_exit(((Lists) arrayList.get(i4)).getId(), MakeMyExam.userId)) {
                        Snackbar.make(view, DirectLayer3Adapter.this.activity.getResources().getString(R.string.your_result_is_getting_ready_please_refresh_your_page), -1).show();
                        return;
                    } else {
                        Snackbar.make(view, DirectLayer3Adapter.this.activity.getResources().getString(R.string.your_test_has_already_been_submitted), -1).show();
                        return;
                    }
                }
                if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("View Rank")) {
                    int i5 = i - 1;
                    DirectLayer3Adapter.this.quiz_id = ((Lists) arrayList.get(i5)).getId();
                    DirectLayer3Adapter.this.quiz_name = ((Lists) arrayList.get(i5)).getTest_series_name();
                    DirectLayer3Adapter.this.totalQuestion = ((Lists) arrayList.get(i5)).getTotal_questions();
                    if (((Lists) arrayList.get(i5)).getState().equalsIgnoreCase("1")) {
                        if (((Lists) arrayList.get(i5)).getResult_date() == null || ((Lists) arrayList.get(i5)).getResult_date().equalsIgnoreCase("") || ((Lists) arrayList.get(i5)).getResult_date().equalsIgnoreCase("0") || ((Lists) arrayList.get(i5)).getResult_date().equalsIgnoreCase("1")) {
                            Intent intent = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) QuizActivity.class);
                            intent.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                            intent.putExtra("status", DirectLayer3Adapter.this.quiz_id);
                            intent.putExtra("name", DirectLayer3Adapter.this.quiz_name);
                            intent.putExtra("show_leader", "0");
                            intent.putExtra("first_attempt", "1");
                            Helper.gotoActivity(intent, DirectLayer3Adapter.this.activity);
                            return;
                        }
                        Intent intent2 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) QuizActivity.class);
                        intent2.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                        intent2.putExtra("status", DirectLayer3Adapter.this.quiz_id);
                        intent2.putExtra("name", DirectLayer3Adapter.this.quiz_name);
                        intent2.putExtra("first_attempt", "1");
                        Helper.gotoActivity(intent2, DirectLayer3Adapter.this.activity);
                        return;
                    }
                    Intent intent3 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) QuizActivity.class);
                    intent3.putExtra(Const.FRAG_TYPE, "leader_board");
                    intent3.putExtra("status", DirectLayer3Adapter.this.quiz_id);
                    intent3.putExtra("name", DirectLayer3Adapter.this.quiz_name);
                    DirectLayer3Adapter.this.activity.startActivity(intent3);
                    return;
                }
                return;
            }
            int i6 = i - 1;
            if (((Lists) arrayList.get(i6)).getIs_locked().equalsIgnoreCase("1")) {
                if (DirectLayer3Adapter.this.isCourseSoldOut()) {
                    Toast.makeText(DirectLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent4 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent4.putExtra(Const.SINGLE_STUDY, DirectLayer3Adapter.this.singleStudy);
                intent4.putExtra(Const.IS_BOOK, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent4.putExtra(Const.DELIVERY_CHARGE, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent4, DirectLayer3Adapter.this.activity);
                return;
            }
            SharedPreference.getInstance().putString("id", DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
            if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("RE-ATTEMPT")) {
                DirectLayer3Adapter.this.quiz_id = ((Lists) arrayList.get(i6)).getId();
                DirectLayer3Adapter.this.quiz_name = ((Lists) arrayList.get(i6)).getTest_series_name();
                DirectLayer3Adapter.this.totalQuestion = ((Lists) arrayList.get(i6)).getTotal_questions();
                DirectLayer3Adapter.this.first_attempt = "0";
                DirectLayer3Adapter.this.result_date = ((Lists) arrayList.get(i6)).getResult_date();
                DirectLayer3Adapter.this.submission_type = ((Lists) arrayList.get(i6)).getSubmission_type();
                DirectLayer3Adapter.this.videodata = (Lists) arrayList.get(i6);
                Helper.resolveTestPattern(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.videodata.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter$SingleStudyTestListHolder$$ExternalSyntheticLambda10
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setData$10();
                    }
                }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter$SingleStudyTestListHolder$$ExternalSyntheticLambda11
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setData$11();
                    }
                });
                return;
            }
            if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("Attempt Now")) {
                DirectLayer3Adapter.this.quiz_id = ((Lists) arrayList.get(i6)).getId();
                DirectLayer3Adapter.this.quiz_name = ((Lists) arrayList.get(i6)).getTest_series_name();
                DirectLayer3Adapter.this.totalQuestion = ((Lists) arrayList.get(i6)).getTotal_questions();
                DirectLayer3Adapter.this.first_attempt = "1";
                DirectLayer3Adapter.this.result_date = ((Lists) arrayList.get(i6)).getResult_date();
                DirectLayer3Adapter.this.submission_type = ((Lists) arrayList.get(i6)).getSubmission_type();
                DirectLayer3Adapter.this.videodata = (Lists) arrayList.get(i6);
                Helper.resolveTestPattern(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.videodata.getTest_pattern(), new Runnable() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter$SingleStudyTestListHolder$$ExternalSyntheticLambda12
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setData$12();
                    }
                }, new Runnable() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter$SingleStudyTestListHolder$$ExternalSyntheticLambda13
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setData$13();
                    }
                });
                return;
            }
            if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("ATTEMPTED")) {
                if (((Lists) arrayList.get(i6)).getResult_date() != null && !((Lists) arrayList.get(i6)).getResult_date().equalsIgnoreCase("0") && !((Lists) arrayList.get(i6)).getResult_date().equalsIgnoreCase("1") && !((Lists) arrayList.get(i6)).getResult_date().equalsIgnoreCase("")) {
                    Snackbar.make(view, DirectLayer3Adapter.this.activity.getResources().getString(R.string.your_result_will_be_declare_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(((Lists) arrayList.get(i6)).getResult_date()) * 1000)), -1).show();
                    return;
                } else if (DirectLayer3Adapter.this.utkashRoom.getTestDao().is_test_exit(((Lists) arrayList.get(i6)).getId(), MakeMyExam.userId)) {
                    Snackbar.make(view, DirectLayer3Adapter.this.activity.getResources().getString(R.string.your_result_is_getting_ready_please_refresh_your_page), -1).show();
                    return;
                } else {
                    Snackbar.make(view, DirectLayer3Adapter.this.activity.getResources().getString(R.string.your_test_has_already_been_submitted), -1).show();
                    return;
                }
            }
            if (((TextView) this.attemptLL.getChildAt(0)).getText().toString().equalsIgnoreCase("View Rank")) {
                DirectLayer3Adapter.this.quiz_id = ((Lists) arrayList.get(i6)).getId();
                DirectLayer3Adapter.this.quiz_name = ((Lists) arrayList.get(i6)).getTest_series_name();
                DirectLayer3Adapter.this.totalQuestion = ((Lists) arrayList.get(i6)).getTotal_questions();
                if (((Lists) arrayList.get(i6)).getState().equalsIgnoreCase("1")) {
                    if (((Lists) arrayList.get(i6)).getResult_date() == null || ((Lists) arrayList.get(i6)).getResult_date().equalsIgnoreCase("") || ((Lists) arrayList.get(i6)).getResult_date().equalsIgnoreCase("0") || ((Lists) arrayList.get(i6)).getResult_date().equalsIgnoreCase("1")) {
                        Intent intent5 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) QuizActivity.class);
                        intent5.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                        intent5.putExtra("status", DirectLayer3Adapter.this.quiz_id);
                        intent5.putExtra("name", DirectLayer3Adapter.this.quiz_name);
                        intent5.putExtra("show_leader", "0");
                        intent5.putExtra("first_attempt", "1");
                        Helper.gotoActivity(intent5, DirectLayer3Adapter.this.activity);
                        return;
                    }
                    Intent intent6 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) QuizActivity.class);
                    intent6.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                    intent6.putExtra("status", DirectLayer3Adapter.this.quiz_id);
                    intent6.putExtra("name", DirectLayer3Adapter.this.quiz_name);
                    intent6.putExtra("first_attempt", "1");
                    Helper.gotoActivity(intent6, DirectLayer3Adapter.this.activity);
                    return;
                }
                Intent intent7 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) QuizActivity.class);
                intent7.putExtra(Const.FRAG_TYPE, "leader_board");
                intent7.putExtra("status", DirectLayer3Adapter.this.quiz_id);
                intent7.putExtra("name", DirectLayer3Adapter.this.quiz_name);
                DirectLayer3Adapter.this.activity.startActivity(intent7);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$6() {
            DirectLayer3Adapter.this.isSSCpattern = false;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$7() {
            DirectLayer3Adapter.this.isSSCpattern = true;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$8() {
            DirectLayer3Adapter.this.isSSCpattern = false;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$9() {
            DirectLayer3Adapter.this.isSSCpattern = true;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$10() {
            DirectLayer3Adapter.this.isSSCpattern = false;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$11() {
            DirectLayer3Adapter.this.isSSCpattern = true;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$12() {
            DirectLayer3Adapter.this.isSSCpattern = false;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$13() {
            DirectLayer3Adapter.this.isSSCpattern = true;
            startTestAPI();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$15(int i, View view) {
            if (DirectLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                int i2 = i - 1;
                Helper.shareTestg(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getTopic_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getRevert_api(), Const.TEST, DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getImage(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getTitle(), SingleStudy.parentCourseId);
                return;
            }
            int i3 = i - 1;
            if (DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getIs_locked().equalsIgnoreCase("1")) {
                if (DirectLayer3Adapter.this.isCourseSoldOut()) {
                    Toast.makeText(DirectLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, DirectLayer3Adapter.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, DirectLayer3Adapter.this.activity);
                return;
            }
            Helper.shareTestg(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getPayload().getCourse_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getId(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getPayload().getTopic_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getPayload().getTile_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getPayload().getTile_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getPayload().getRevert_api(), Const.TEST, DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getImage(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getTitle(), SingleStudy.parentCourseId);
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
            DirectLayer3Adapter directLayer3Adapter = DirectLayer3Adapter.this;
            new NetworkCall(directLayer3Adapter, directLayer3Adapter.activity).NetworkAPICall(API.API_GET_TEST_INSTRUCTION_DATA, "", true, false);
        }

        public void result_without_submit(final String quiz_id, String course_id, String s, final String quiz_name) {
            if (Helper.isNetworkConnected(DirectLayer3Adapter.this.activity)) {
                final Progress progress = new Progress(DirectLayer3Adapter.this.activity);
                progress.show();
                APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setTest_id(quiz_id);
                encryptionData.setCourse_id(course_id);
                encryptionData.setFirst_attempt(s);
                aPIInterface.getTestlearn(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new Callback<String>() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter.SingleStudyTestListHolder.3
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
                                Helper.showToastSecurity(DirectLayer3Adapter.this.activity);
                                return;
                            }
                            try {
                                if (resultTestSeries_Report.getStatus().equalsIgnoreCase("true")) {
                                    SharedPreference.getInstance().putString("testresult", new Gson().toJson(resultTestSeries_Report));
                                    Intent intent = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) ViewSolutionActivity.class);
                                    intent.putExtra(Const.TESTSEGMENT_ID, quiz_id);
                                    intent.putExtra(Const.FRAG_TYPE, Const.SOLUTIONREPORT);
                                    intent.putExtra("name", quiz_name);
                                    intent.putExtra("type", "learn");
                                    if (!resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("1")) {
                                        if (resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("2")) {
                                            DirectLayer3Adapter.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                                        }
                                    } else {
                                        DirectLayer3Adapter.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                                    }
                                    intent.putExtra(Const.LANG, DirectLayer3Adapter.this.lang);
                                    Helper.gotoActivity(intent, DirectLayer3Adapter.this.activity);
                                    return;
                                }
                                progress.dismiss();
                                RetrofitResponse.GetApiData(DirectLayer3Adapter.this.activity, jSONObject.optString("auth_code"), jSONObject.optString("message"), false);
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
            Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.Retry_with_Internet_connection), 1).show();
        }

        public void netoworkCallForQuizResult2(final String quiz_id, String course_id, String s, final String quiz_name) {
            if (Helper.isNetworkConnected(DirectLayer3Adapter.this.activity)) {
                final Progress progress = new Progress(DirectLayer3Adapter.this.activity);
                progress.show();
                APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setTest_id(quiz_id);
                encryptionData.setCourse_id(course_id);
                encryptionData.setFirst_attempt(s);
                aPIInterface.getTestResult(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new Callback<String>() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter.SingleStudyTestListHolder.4
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
                                Helper.showToastSecurity(DirectLayer3Adapter.this.activity);
                                return;
                            }
                            try {
                                if (resultTestSeries_Report.getStatus().equalsIgnoreCase("true")) {
                                    if (resultTestSeries_Report.getData().getQuestions() != null && resultTestSeries_Report.getData().getQuestions().size() > 0) {
                                        SharedPreference.getInstance().putString("testresult", new Gson().toJson(resultTestSeries_Report));
                                        Intent intent = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) ViewSolutionActivity.class);
                                        intent.putExtra(Const.TESTSEGMENT_ID, quiz_id);
                                        intent.putExtra(Const.FRAG_TYPE, Const.SOLUTIONREPORT);
                                        intent.putExtra("name", quiz_name);
                                        intent.putExtra("type", "learn");
                                        if (!resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("1")) {
                                            if (resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("2")) {
                                                DirectLayer3Adapter.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                                            }
                                        } else {
                                            DirectLayer3Adapter.this.lang = Integer.parseInt(resultTestSeries_Report.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                                        }
                                        intent.putExtra(Const.LANG, DirectLayer3Adapter.this.lang);
                                        Helper.gotoActivity(intent, DirectLayer3Adapter.this.activity);
                                        return;
                                    }
                                    Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.no_question_found), 0).show();
                                    return;
                                }
                                progress.dismiss();
                                RetrofitResponse.GetApiData(DirectLayer3Adapter.this.activity, jSONObject.optString("auth_code"), jSONObject.optString("message"), false);
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
            Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.Retry_with_Internet_connection), 1).show();
        }
    }

    public class SingleStudyListHolder extends RecyclerView.ViewHolder {
        LinearLayout LogsLL;
        LinearLayout actalll;
        TextView actualduration;
        Button backBtn;
        LinearLayout classdurationll;
        TextView duration;
        ImageView forwardIV;
        CardView ibt_single_sub_vd_RL;
        ImageView imageIcon;
        RelativeLayout layout_fun;
        LeftMenu leftMenu;
        TextView listen_now;
        ImageView liveIV;
        RelativeLayout lockRL;
        RelativeLayout no_data_found_RL;
        ImageView optionMenuImgView;
        RelativeLayout parentLL;
        TextView read_now;
        TextView remaining_time;
        LinearLayout remainingtimell;
        ImageView share;
        RelativeLayout studyitemLL;
        TextView subItemRV;
        TextView titleCategory;
        TextView total_view_time;
        LinearLayout totalviewtimell;
        View view1;
        TextView watch_now;

        public SingleStudyListHolder(View itemView) {
            super(itemView);
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
            this.actalll = (LinearLayout) itemView.findViewById(R.id.actalll);
            this.classdurationll = (LinearLayout) itemView.findViewById(R.id.classdurationll);
            this.totalviewtimell = (LinearLayout) itemView.findViewById(R.id.totalviewtimell);
            this.remainingtimell = (LinearLayout) itemView.findViewById(R.id.remainingtimell);
            this.actualduration = (TextView) itemView.findViewById(R.id.actualduration);
        }

        public void setData(final ArrayList<Lists> list, final int position) {
            if (list != null && list.size() > 0) {
                this.leftMenu = (LeftMenu) new Gson().fromJson(DirectLayer3Adapter.this.themeSettings.getLeft_menu(), LeftMenu.class);
                this.ibt_single_sub_vd_RL.setVisibility(0);
                this.no_data_found_RL.setVisibility(8);
                int i = position - 1;
                if (list.get(i).getIs_live() != null && list.get(i).getIs_live().equals("1")) {
                    this.liveIV.setVisibility(0);
                } else {
                    this.liveIV.setVisibility(8);
                }
                if (list.get(i).getIs_locked().equals("0")) {
                    this.lockRL.setVisibility(8);
                } else {
                    this.lockRL.setVisibility(0);
                }
                if (DirectLayer3Adapter.this.isSkip.equalsIgnoreCase("3")) {
                    this.forwardIV.setVisibility(8);
                    if (DirectLayer3Adapter.this.examPrepItem.getList().get(i).getExtra_params() != null) {
                        if (DirectLayer3Adapter.this.examPrepItem.getList().get(i).getExtra_params().getIs_limited().equalsIgnoreCase("1")) {
                            this.LogsLL.setVisibility(0);
                            if (BuildConfig.FLAVOR.equalsIgnoreCase("Shrestha")) {
                                setvisibility(1, 0, 1, 0);
                            } else {
                                setvisibility(0, 1, 1, 1);
                            }
                            this.actualduration.setText(Helper.formatSeconds((int) Float.parseFloat(DirectLayer3Adapter.this.examPrepItem.getList().get(i).getVideo_duration())));
                            this.duration.setText(Helper.formatSeconds((int) Float.parseFloat(DirectLayer3Adapter.this.examPrepItem.getList().get(i).getVideo_length())));
                            this.total_view_time.setText(Helper.formatSeconds((int) (Float.parseFloat(DirectLayer3Adapter.this.examPrepItem.getList().get(i).getVideo_length()) - Float.parseFloat(DirectLayer3Adapter.this.examPrepItem.getList().get(i).getRemaining_time()))));
                            this.remaining_time.setText(Helper.formatSeconds((int) Float.parseFloat(DirectLayer3Adapter.this.examPrepItem.getList().get(i).getRemaining_time())));
                        } else {
                            this.LogsLL.setVisibility(8);
                        }
                    }
                    if (!TextUtils.isEmpty(list.get(i).getThumbnail_url())) {
                        Helper.setThumbnailImage(DirectLayer3Adapter.this.activity, list.get(i).getThumbnail_url(), DirectLayer3Adapter.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.imageIcon);
                    } else {
                        this.imageIcon.setImageResource(R.mipmap.square_placeholder);
                    }
                } else {
                    this.LogsLL.setVisibility(8);
                    if (!TextUtils.isEmpty(list.get(i).getImage_icon())) {
                        Helper.setThumbnailImage(DirectLayer3Adapter.this.activity, list.get(i).getImage_icon(), DirectLayer3Adapter.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.imageIcon);
                    } else {
                        this.imageIcon.setImageResource(R.mipmap.square_placeholder);
                    }
                }
                this.titleCategory.setText(list.get(i).getTitle());
                if (DirectLayer3Adapter.this.isSkip.equalsIgnoreCase("3")) {
                    if ("1".equalsIgnoreCase("5")) {
                        this.layout_fun.setVisibility(8);
                    } else {
                        this.layout_fun.setVisibility(0);
                    }
                    if (list.get(i).getVideo_status() != null) {
                        if (list.get(i).getVideo_status().equalsIgnoreCase("Download Running")) {
                            this.optionMenuImgView.setVisibility(8);
                            this.subItemRV.setVisibility(8);
                        } else if (list.get(i).getVideo_status().equalsIgnoreCase("Downloaded")) {
                            this.optionMenuImgView.setVisibility(0);
                            this.optionMenuImgView.setEnabled(false);
                            this.subItemRV.setVisibility(8);
                            this.optionMenuImgView.setImageResource(R.drawable.ic_downloaded_chapter);
                            this.subItemRV.setText(DirectLayer3Adapter.this.activity.getResources().getString(R.string.duration) + list.get(i).getVideo_time());
                        } else if (list.get(i).getVideo_status().equalsIgnoreCase("Download")) {
                            this.optionMenuImgView.setEnabled(true);
                            this.subItemRV.setVisibility(8);
                            this.optionMenuImgView.setImageResource(R.drawable.ic_menu_download);
                            this.optionMenuImgView.setVisibility(0);
                        } else {
                            this.subItemRV.setVisibility(8);
                            this.optionMenuImgView.setVisibility(8);
                        }
                    }
                    if (list.get(i).getFile_type().equalsIgnoreCase("3")) {
                        this.watch_now.setVisibility(0);
                        if ((list.get(i).getOpen_in_app() == null || !list.get(i).getOpen_in_app().equalsIgnoreCase("1")) && !list.get(i).getVideo_type().equalsIgnoreCase("0") && !list.get(i).getVideo_type().equalsIgnoreCase("1") && !list.get(i).getVideo_type().equalsIgnoreCase("5") && list.get(i).getVideo_type().equalsIgnoreCase("6")) {
                            this.listen_now.setVisibility(8);
                        } else {
                            this.listen_now.setVisibility(8);
                        }
                    } else {
                        this.watch_now.setVisibility(8);
                    }
                    this.share.setVisibility(0);
                    if (list.get(i).getFile_type().equalsIgnoreCase("6") || list.get(i).getFile_type().equalsIgnoreCase("12") || list.get(i).getFile_type().equalsIgnoreCase("11") || list.get(i).getFile_type().equalsIgnoreCase("8")) {
                        this.studyitemLL.setEnabled(true);
                        this.read_now.setEnabled(true);
                        this.read_now.setVisibility(0);
                        if (list.get(i).getFile_type().equalsIgnoreCase("6")) {
                            this.read_now.setText(DirectLayer3Adapter.this.activity.getResources().getString(R.string.view));
                        } else {
                            this.read_now.setText(DirectLayer3Adapter.this.activity.getResources().getString(R.string.read));
                        }
                        this.share.setVisibility(8);
                    } else {
                        this.studyitemLL.setEnabled(true);
                        this.read_now.setEnabled(false);
                        this.read_now.setVisibility(8);
                    }
                    if (list.get(i).getIs_locked().equals("1")) {
                        this.read_now.setVisibility(8);
                        this.watch_now.setVisibility(8);
                        this.listen_now.setVisibility(8);
                    }
                } else {
                    this.layout_fun.setVisibility(8);
                    this.watch_now.setVisibility(8);
                    this.listen_now.setVisibility(8);
                    if (TextUtils.isEmpty(list.get(i).getCount())) {
                        this.subItemRV.setVisibility(4);
                    } else {
                        this.subItemRV.setVisibility(8);
                        this.subItemRV.setText(DirectLayer3Adapter.this.activity.getResources().getString(R.string.total_) + list.get(i).getCount());
                    }
                }
                this.share.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter$SingleStudyListHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$0(position, view);
                    }
                });
                this.optionMenuImgView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter.SingleStudyListHolder.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        if (DirectLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                            if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("10") || DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("12") || DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("11")) {
                                DirectLayer3Adapter.this.videodata = DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1);
                                DirectLayer3Adapter.this.position_delete = position - 1;
                                DirectLayer3Adapter.this.delete_meg(DirectLayer3Adapter.this.videodata);
                                return;
                            }
                            if (!VideoDownloadService.isServiceRunning) {
                                if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getVideo_type().equalsIgnoreCase("6")) {
                                    DirectLayer3Adapter.this.download_data(DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1), position);
                                    return;
                                } else {
                                    Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.only_jw_video_download), 0).show();
                                    return;
                                }
                            }
                            Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.please_wait_downloading_is_in_progress), 0).show();
                            return;
                        }
                        if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getIs_locked().equalsIgnoreCase("1")) {
                            if (DirectLayer3Adapter.this.isCourseSoldOut()) {
                                Toast.makeText(DirectLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                                return;
                            }
                            Intent intent = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                            intent.putExtra(Const.SINGLE_STUDY, DirectLayer3Adapter.this.singleStudy);
                            intent.putExtra(Const.IS_BOOK, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                            intent.putExtra(Const.DELIVERY_CHARGE, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                            Helper.gotoActivity(intent, DirectLayer3Adapter.this.activity);
                            return;
                        }
                        if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("10") || DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("12") || DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("11")) {
                            DirectLayer3Adapter.this.videodata = DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1);
                            DirectLayer3Adapter.this.position_delete = position - 1;
                            DirectLayer3Adapter.this.delete_meg(DirectLayer3Adapter.this.videodata);
                            return;
                        }
                        if (!VideoDownloadService.isServiceRunning) {
                            if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getVideo_type().equalsIgnoreCase("6")) {
                                DirectLayer3Adapter.this.download_data(DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1), position);
                                return;
                            } else {
                                Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.only_jw_video_download), 0).show();
                                return;
                            }
                        }
                        Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.please_wait_downloading_is_in_progress), 0).show();
                    }
                });
                this.watch_now.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter$SingleStudyListHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$1(position, view);
                    }
                });
                this.listen_now.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter$SingleStudyListHolder$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$2(position, view);
                    }
                });
                this.read_now.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter.SingleStudyListHolder.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        if (((Lists) list.get(position - 1)).getIs_locked().equalsIgnoreCase("1")) {
                            if (DirectLayer3Adapter.this.isCourseSoldOut()) {
                                Toast.makeText(DirectLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                                return;
                            }
                            Intent intent = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                            intent.putExtra(Const.SINGLE_STUDY, DirectLayer3Adapter.this.singleStudy);
                            intent.putExtra(Const.IS_BOOK, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                            intent.putExtra(Const.DELIVERY_CHARGE, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                            Helper.gotoActivity(intent, DirectLayer3Adapter.this.activity);
                            return;
                        }
                        if (DirectLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                            if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("12")) {
                                if (DirectLayer3Adapter.this.examPrepItem.getList().size() > 0) {
                                    Intent intent2 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) RevisionActivity.class);
                                    intent2.putExtra("t_id", DirectLayer3Adapter.this.tileIdAPI);
                                    intent2.putExtra("postion", position);
                                    intent2.putExtra(Const.VIDEO_ID, DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getId());
                                    intent2.putExtra("v_list", ExamPrepLayer2.actual_videolist);
                                    intent2.putExtra("f_id", DirectLayer3Adapter.this.examPrepItem.getList().get(0).getId());
                                    intent2.putExtra("c_id", DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
                                    intent2.putExtra("title", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getTitle());
                                    intent2.putExtra("url", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_url());
                                    intent2.putExtra(Const.VIA, "main");
                                    Helper.gotoActivity(intent2, DirectLayer3Adapter.this.activity);
                                    return;
                                }
                                return;
                            }
                            if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("11")) {
                                Intent intent3 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) WebViewActivty.class);
                                intent3.putExtra("type", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getTitle());
                                intent3.putExtra("url", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_url());
                                Helper.gotoActivity(intent3, DirectLayer3Adapter.this.activity);
                                return;
                            }
                            if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("8")) {
                                Intent intent4 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) WebViewActivty.class);
                                intent4.putExtra("type", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getTitle());
                                intent4.putExtra("url", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_url());
                                if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                                    intent4.putExtra("course_id", DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD);
                                } else {
                                    intent4.putExtra("course_id", SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
                                }
                                intent4.putExtra(Const.VIDEO_ID, DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getId());
                                intent4.putExtra("link", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type());
                                Helper.gotoActivity(intent4, DirectLayer3Adapter.this.activity);
                                return;
                            }
                            if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("6")) {
                                if (TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_url()) && TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getId())) {
                                    Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.no_image_found), 0).show();
                                    return;
                                }
                                Intent intent5 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) WebViewActivty.class);
                                intent5.putExtra("type", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getTitle());
                                intent5.putExtra("url", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_url());
                                intent5.putExtra("file_type", "image");
                                Helper.gotoActivity(intent5, DirectLayer3Adapter.this.activity);
                                return;
                            }
                            return;
                        }
                        if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getIs_locked().equalsIgnoreCase("1")) {
                            if (DirectLayer3Adapter.this.isCourseSoldOut()) {
                                Toast.makeText(DirectLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                                return;
                            }
                            Intent intent6 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                            intent6.putExtra(Const.SINGLE_STUDY, DirectLayer3Adapter.this.singleStudy);
                            intent6.putExtra(Const.IS_BOOK, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                            intent6.putExtra(Const.DELIVERY_CHARGE, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                            Helper.gotoActivity(intent6, DirectLayer3Adapter.this.activity);
                            return;
                        }
                        if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("12")) {
                            if (DirectLayer3Adapter.this.examPrepItem.getList().size() > 0) {
                                Intent intent7 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) RevisionActivity.class);
                                intent7.putExtra("t_id", DirectLayer3Adapter.this.tileIdAPI);
                                intent7.putExtra("postion", position);
                                intent7.putExtra(Const.VIDEO_ID, DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getId());
                                intent7.putExtra("v_list", ExamPrepLayer2.actual_videolist);
                                intent7.putExtra("f_id", DirectLayer3Adapter.this.examPrepItem.getList().get(0).getId());
                                intent7.putExtra("c_id", DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
                                intent7.putExtra("title", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getTitle());
                                intent7.putExtra("url", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_url());
                                intent7.putExtra(Const.VIA, "main");
                                Helper.gotoActivity(intent7, DirectLayer3Adapter.this.activity);
                                return;
                            }
                            return;
                        }
                        if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("11")) {
                            Intent intent8 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) WebViewActivty.class);
                            intent8.putExtra("type", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getTitle());
                            intent8.putExtra("url", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_url());
                            Helper.gotoActivity(intent8, DirectLayer3Adapter.this.activity);
                            return;
                        }
                        if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("8")) {
                            Intent intent9 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) WebViewActivty.class);
                            intent9.putExtra("type", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getTitle());
                            intent9.putExtra("url", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_url());
                            if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                                intent9.putExtra("course_id", DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD);
                            } else {
                                intent9.putExtra("course_id", SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
                            }
                            intent9.putExtra(Const.VIDEO_ID, DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getId());
                            intent9.putExtra("link", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type());
                            Helper.gotoActivity(intent9, DirectLayer3Adapter.this.activity);
                            return;
                        }
                        if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("6")) {
                            if (TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_url()) && TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getId())) {
                                Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.no_image_found), 0).show();
                                return;
                            }
                            Intent intent10 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) WebViewActivty.class);
                            intent10.putExtra("type", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getTitle());
                            intent10.putExtra("url", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_url());
                            intent10.putExtra("file_type", "image");
                            Helper.gotoActivity(intent10, DirectLayer3Adapter.this.activity);
                        }
                    }
                });
                if (DirectLayer3Adapter.this.isSkip.equals("3")) {
                    this.studyitemLL.setEnabled(false);
                } else {
                    this.studyitemLL.setEnabled(true);
                }
                if (Helper.isShowShareButton(this.leftMenu)) {
                    this.share.setVisibility(0);
                } else {
                    this.share.setVisibility(8);
                }
                this.studyitemLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter$SingleStudyListHolder$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$3(list, position, view);
                    }
                });
                return;
            }
            this.ibt_single_sub_vd_RL.setVisibility(8);
            this.no_data_found_RL.setVisibility(0);
            this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter.SingleStudyListHolder.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DirectLayer3Adapter.this.activity.finish();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$0(int i, View view) {
            if (DirectLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                int i2 = i - 1;
                if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("8") || DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("7") || DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("1")) {
                    Helper.sharePdf(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getTopic_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getRevert_api(), Const.PDF, DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getThumbnail_url(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getTitle(), SingleStudy.parentCourseId);
                    return;
                }
                if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getVideo_type().equalsIgnoreCase("4") || DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getVideo_type().equalsIgnoreCase("1") || DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getVideo_type().equalsIgnoreCase("7") || DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getVideo_type().equalsIgnoreCase("8")) {
                    Helper.shareLiveClass(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getTopic_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getRevert_api(), "video", DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getThumbnail_url(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getTitle(), SingleStudy.parentCourseId, DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getIs_locked());
                    return;
                } else {
                    if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getVideo_type().equalsIgnoreCase("6")) {
                        Helper.sharejwvideo(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getTopic_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getRevert_api(), "video", DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getThumbnail_url(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getTitle(), SingleStudy.parentCourseId);
                        return;
                    }
                    return;
                }
            }
            int i3 = i - 1;
            if (DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getIs_locked().equalsIgnoreCase("1")) {
                if (DirectLayer3Adapter.this.isCourseSoldOut()) {
                    Toast.makeText(DirectLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, DirectLayer3Adapter.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, DirectLayer3Adapter.this.activity);
                return;
            }
            if (DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getFile_type().equalsIgnoreCase("8") || DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getFile_type().equalsIgnoreCase("7") || DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getFile_type().equalsIgnoreCase("1")) {
                Helper.sharePdf(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getPayload().getCourse_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getId(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getPayload().getTopic_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getPayload().getTile_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getPayload().getTile_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getPayload().getRevert_api(), Const.PDF, DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getThumbnail_url(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getTitle(), SingleStudy.parentCourseId);
                return;
            }
            if (DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getVideo_type().equalsIgnoreCase("4") || DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getVideo_type().equalsIgnoreCase("1") || DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getVideo_type().equalsIgnoreCase("7") || DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getVideo_type().equalsIgnoreCase("8")) {
                Helper.shareLiveClass(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getPayload().getCourse_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getId(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getPayload().getTopic_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getPayload().getTile_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getPayload().getTile_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getPayload().getRevert_api(), "video", DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getThumbnail_url(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getTitle(), SingleStudy.parentCourseId, DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getIs_locked());
            } else if (DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getVideo_type().equalsIgnoreCase("6")) {
                Helper.sharejwvideo(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getPayload().getCourse_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getId(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getPayload().getTopic_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getPayload().getTile_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getPayload().getTile_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getPayload().getRevert_api(), "video", DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getThumbnail_url(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getTitle(), SingleStudy.parentCourseId);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$1(int i, View view) {
            if (DirectLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                int i2 = i - 1;
                if (TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_url()) && TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId())) {
                    Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.no_video_found), 0).show();
                    return;
                }
                Helper.audio_service_close((CourseActivity) DirectLayer3Adapter.this.activity);
                DirectLayer3Adapter directLayer3Adapter = DirectLayer3Adapter.this;
                directLayer3Adapter.API_REQUEST_VIDEO_LINK(directLayer3Adapter.examPrepItem.getList().get(i2), i2);
                return;
            }
            int i3 = i - 1;
            if (DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getIs_locked().equalsIgnoreCase("1")) {
                if (DirectLayer3Adapter.this.isCourseSoldOut()) {
                    Toast.makeText(DirectLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, DirectLayer3Adapter.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, DirectLayer3Adapter.this.activity);
                return;
            }
            if (TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getFile_url()) && TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getId())) {
                Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.no_video_found), 0).show();
                return;
            }
            Helper.audio_service_close((CourseActivity) DirectLayer3Adapter.this.activity);
            DirectLayer3Adapter directLayer3Adapter2 = DirectLayer3Adapter.this;
            directLayer3Adapter2.API_REQUEST_VIDEO_LINK(directLayer3Adapter2.examPrepItem.getList().get(i3), i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$2(int i, View view) {
            if (Helper.isNetworkConnected(DirectLayer3Adapter.this.activity)) {
                if (DirectLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                    int i2 = i - 1;
                    if (TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_url()) && TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId())) {
                        Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.no_video_found), 0).show();
                        return;
                    }
                    Helper.audio_service_close((CourseActivity) DirectLayer3Adapter.this.activity);
                    if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getVideo_type().equalsIgnoreCase("6")) {
                        String str = "https://cdn.jwplayer.com/v2/media/" + DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_url().substring(DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_url().lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1, DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_url().indexOf("-"));
                        return;
                    }
                    if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getVideo_type().equalsIgnoreCase("1")) {
                        Helper.GoToLiveVideoActivity(DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getChat_node(), DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_url(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getVideo_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getTitle(), "1", DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getThumbnail_url(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getIs_chat_lock(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), String.valueOf(i2), SingleStudy.parentCourseId, DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getIs_live(), DirectLayer3Adapter.this.videoArrayList);
                        return;
                    }
                    if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getVideo_type().equalsIgnoreCase("5")) {
                        if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("1")) {
                            Helper.GoToLiveAwsVideoActivity(DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getVideo_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getChat_node(), DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_url(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getVideo_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getTitle(), "1", DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getThumbnail_url(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getIs_chat_lock(), String.valueOf(i2), SingleStudy.parentCourseId, DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getStart_date(), DirectLayer3Adapter.this.videoArrayList);
                            return;
                        }
                        if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("0")) {
                            Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getStart_date()) * 1000)), 0).show();
                            return;
                        } else if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("2")) {
                            Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                            return;
                        } else {
                            if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("3")) {
                                Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                                return;
                            }
                            return;
                        }
                    }
                    if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getVideo_type().equalsIgnoreCase("0")) {
                        Helper.GoToLiveAwsVideoActivity(DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getVideo_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getChat_node(), DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_url(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getVideo_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getTitle(), "1", DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getThumbnail_url(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getIs_chat_lock(), String.valueOf(i2), SingleStudy.parentCourseId, DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getStart_date(), DirectLayer3Adapter.this.videoArrayList);
                        return;
                    }
                    if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getVideo_type().equalsIgnoreCase("7")) {
                        if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getIs_drm().equals("0")) {
                            if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId() == null || DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId().equalsIgnoreCase("")) {
                                Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                                return;
                            } else {
                                Helper.GoToLiveAwsVideoActivity(DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getVideo_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getChat_node(), DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getVideo_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getTitle(), "1", DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getThumbnail_url(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getStart_date(), DirectLayer3Adapter.this.videoArrayList);
                                return;
                            }
                        }
                        if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getIs_drm().equals("1")) {
                            if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId() == null || DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId().equalsIgnoreCase("")) {
                                Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                                return;
                            } else {
                                Helper.GoToVideoCryptActivity(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getVideo_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getChat_node(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getVideo_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getTitle(), "1", DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getThumbnail_url(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getStart_date(), "0", DirectLayer3Adapter.this.videoArrayList);
                                return;
                            }
                        }
                        return;
                    }
                    if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getVideo_type().equalsIgnoreCase("8")) {
                        if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getIs_drm().equals("0")) {
                            if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("1")) {
                                if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId() == null || DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId().equalsIgnoreCase("")) {
                                    Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                                    return;
                                } else {
                                    Helper.GoToLiveAwsVideoActivity(DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getVideo_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getChat_node(), DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getVideo_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getTitle(), "1", DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getThumbnail_url(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getStart_date(), DirectLayer3Adapter.this.videoArrayList);
                                    return;
                                }
                            }
                            if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("0")) {
                                Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getStart_date()) * 1000)), 0).show();
                                return;
                            } else if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("2")) {
                                Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                                return;
                            } else {
                                if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("3")) {
                                    Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                                    return;
                                }
                                return;
                            }
                        }
                        if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getIs_drm().equals("1")) {
                            if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("1")) {
                                if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId() == null || DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId().equalsIgnoreCase("")) {
                                    Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.url_is_not_found), 0).show();
                                    return;
                                } else {
                                    Helper.GoToVideoCryptActivity(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getVideo_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getChat_node(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getVideo_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getTitle(), "1", DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getThumbnail_url(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getStart_date(), "0", DirectLayer3Adapter.this.videoArrayList);
                                    return;
                                }
                            }
                            if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("0")) {
                                Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getStart_date()) * 1000)), 0).show();
                                return;
                            } else if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("2")) {
                                Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.live_class_is_ended), 0).show();
                                return;
                            } else {
                                if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getLive_status().equalsIgnoreCase("3")) {
                                    Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.live_class_is_cancelled), 0).show();
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
                if (DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getIs_locked().equalsIgnoreCase("1")) {
                    if (DirectLayer3Adapter.this.isCourseSoldOut()) {
                        Toast.makeText(DirectLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                        return;
                    }
                    Intent intent = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                    intent.putExtra(Const.SINGLE_STUDY, DirectLayer3Adapter.this.singleStudy);
                    intent.putExtra(Const.IS_BOOK, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                    intent.putExtra(Const.DELIVERY_CHARGE, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                    Helper.gotoActivity(intent, DirectLayer3Adapter.this.activity);
                    return;
                }
                if (TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getFile_url()) && TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getId())) {
                    Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.no_video_found), 0).show();
                    return;
                }
                Helper.audio_service_close((CourseActivity) DirectLayer3Adapter.this.activity);
                if (DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getVideo_type().equalsIgnoreCase("6")) {
                    String str2 = "https://cdn.jwplayer.com/v2/media/" + DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getFile_url().substring(DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getFile_url().lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1, DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getFile_url().indexOf("-"));
                    return;
                } else if (DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getVideo_type().equalsIgnoreCase("1")) {
                    Helper.GoToLiveVideoActivity(DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getChat_node(), DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getFile_url(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getVideo_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getId(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getTitle(), "1", DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getThumbnail_url(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getIs_chat_lock(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getPayload().getCourse_id(), String.valueOf(i3), SingleStudy.parentCourseId, DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getPayload().getTile_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getPayload().getTile_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getIs_live(), DirectLayer3Adapter.this.videoArrayList);
                    return;
                } else {
                    if (DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getVideo_type().equalsIgnoreCase("5")) {
                        Helper.GoToLiveAwsVideoActivity(DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getVideo_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getChat_node(), DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getFile_url(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getVideo_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getId(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getTitle(), "1", DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getThumbnail_url(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getPayload().getCourse_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getPayload().getTile_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getPayload().getTile_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getIs_chat_lock(), String.valueOf(i3), SingleStudy.parentCourseId, DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getStart_date(), DirectLayer3Adapter.this.videoArrayList);
                        return;
                    }
                    return;
                }
            }
            Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$3(ArrayList arrayList, int i, View view) {
            this.studyitemLL.setFocusable(true);
            this.studyitemLL.setClickable(true);
            this.studyitemLL.setBackgroundDrawable(DirectLayer3Adapter.this.activity.getResources().getDrawable(R.drawable.nav_ripple));
            int i2 = i - 1;
            if (((Lists) arrayList.get(i2)).getIs_locked().equalsIgnoreCase("1")) {
                if (DirectLayer3Adapter.this.isCourseSoldOut()) {
                    Toast.makeText(DirectLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, DirectLayer3Adapter.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, DirectLayer3Adapter.this.activity);
                return;
            }
            if (DirectLayer3Adapter.this.isSkip.equalsIgnoreCase("1") || DirectLayer3Adapter.this.isSkip.equalsIgnoreCase("2")) {
                Intent intent2 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) CourseActivity.class);
                SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(DirectLayer3Adapter.this.singleStudy != null ? DirectLayer3Adapter.this.singleStudy : new CourseDetail()));
                SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(DirectLayer3Adapter.this.examPrepItem != null ? DirectLayer3Adapter.this.examPrepItem : new ExamPrepItem()));
                SharedPreference.getInstance().putString("list", new Gson().toJson(DirectLayer3Adapter.this.examPrepItem.getList().get(i2) != null ? DirectLayer3Adapter.this.examPrepItem.getList().get(i2) : new Lists()));
                intent2.putExtra(Const.FRAG_TYPE, Const.EXAMPREPLAST);
                intent2.putExtra(Const.IS_COMBO, DirectLayer3Adapter.this.isCombo);
                intent2.putExtra(Const.LIST_SUBJECT, DirectLayer3Adapter.this.examPrepItem.getList().get(i2));
                intent2.putExtra("title", DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getTitle());
                intent2.putExtra("content_type", DirectLayer3Adapter.this.contentType);
                intent2.putExtra(Const.TEST_TYPE, DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getCount());
                intent2.putExtra("tile_id", DirectLayer3Adapter.this.tileIdAPI);
                intent2.putExtra(Const.TILE_TYPE, DirectLayer3Adapter.this.tileTypeAPI);
                intent2.putExtra(Const.REVERT_API, DirectLayer3Adapter.this.revertAPI);
                Helper.gotoActivity(intent2, DirectLayer3Adapter.this.activity);
                return;
            }
            if (DirectLayer3Adapter.this.isSkip.equalsIgnoreCase("3")) {
                if (DirectLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                    if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("12")) {
                        if (DirectLayer3Adapter.this.examPrepItem.getList().size() > 0) {
                            Intent intent3 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) RevisionActivity.class);
                            intent3.putExtra("t_id", DirectLayer3Adapter.this.tileIdAPI);
                            intent3.putExtra("postion", i);
                            intent3.putExtra(Const.VIDEO_ID, DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId());
                            intent3.putExtra("v_list", ExamPrepLayer2.actual_videolist);
                            intent3.putExtra("f_id", DirectLayer3Adapter.this.examPrepItem.getList().get(0).getId());
                            intent3.putExtra("c_id", DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
                            intent3.putExtra("title", DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getTitle());
                            intent3.putExtra("url", DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_url());
                            intent3.putExtra(Const.VIA, "main");
                            Helper.gotoActivity(intent3, DirectLayer3Adapter.this.activity);
                            return;
                        }
                        return;
                    }
                    if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("11")) {
                        Intent intent4 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) WebViewActivty.class);
                        intent4.putExtra("type", DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getTitle());
                        intent4.putExtra("url", DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_url());
                        Helper.gotoActivity(intent4, DirectLayer3Adapter.this.activity);
                        return;
                    }
                    if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("8")) {
                        Intent intent5 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) WebViewActivty.class);
                        intent5.putExtra("type", DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getTitle());
                        intent5.putExtra("url", DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_url());
                        if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                            intent5.putExtra("course_id", DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD);
                        } else {
                            intent5.putExtra("course_id", SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
                        }
                        intent5.putExtra(Const.VIDEO_ID, DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId());
                        intent5.putExtra("link", DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_type());
                        Helper.gotoActivity(intent5, DirectLayer3Adapter.this.activity);
                        return;
                    }
                    if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("6")) {
                        if (TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_url()) && TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId())) {
                            Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.no_image_found), 0).show();
                            return;
                        }
                        Intent intent6 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) WebViewActivty.class);
                        intent6.putExtra("type", DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getTitle());
                        intent6.putExtra("url", DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_url());
                        intent6.putExtra("file_type", "image");
                        Helper.gotoActivity(intent6, DirectLayer3Adapter.this.activity);
                        return;
                    }
                    return;
                }
                if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getIs_locked().equalsIgnoreCase("1")) {
                    if (DirectLayer3Adapter.this.isCourseSoldOut()) {
                        Toast.makeText(DirectLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                        return;
                    }
                    Intent intent7 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                    intent7.putExtra(Const.SINGLE_STUDY, DirectLayer3Adapter.this.singleStudy);
                    intent7.putExtra(Const.IS_BOOK, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                    intent7.putExtra(Const.DELIVERY_CHARGE, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                    Helper.gotoActivity(intent7, DirectLayer3Adapter.this.activity);
                    return;
                }
                if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("12")) {
                    if (DirectLayer3Adapter.this.examPrepItem.getList().size() > 0) {
                        Intent intent8 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) RevisionActivity.class);
                        intent8.putExtra("t_id", DirectLayer3Adapter.this.tileIdAPI);
                        intent8.putExtra("postion", i);
                        intent8.putExtra(Const.VIDEO_ID, DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId());
                        intent8.putExtra("v_list", ExamPrepLayer2.actual_videolist);
                        intent8.putExtra("f_id", DirectLayer3Adapter.this.examPrepItem.getList().get(0).getId());
                        intent8.putExtra("c_id", DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
                        intent8.putExtra("title", DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getTitle());
                        intent8.putExtra("url", DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_url());
                        intent8.putExtra(Const.VIA, "main");
                        Helper.gotoActivity(intent8, DirectLayer3Adapter.this.activity);
                        return;
                    }
                    return;
                }
                if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("11")) {
                    Intent intent9 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) WebViewActivty.class);
                    intent9.putExtra("type", DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getTitle());
                    intent9.putExtra("url", DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_url());
                    Helper.gotoActivity(intent9, DirectLayer3Adapter.this.activity);
                    return;
                }
                if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("8")) {
                    Intent intent10 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) WebViewActivty.class);
                    intent10.putExtra("type", DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getTitle());
                    intent10.putExtra("url", DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_url());
                    if (SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                        intent10.putExtra("course_id", DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD);
                    } else {
                        intent10.putExtra("course_id", SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
                    }
                    intent10.putExtra(Const.VIDEO_ID, DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId());
                    intent10.putExtra("link", DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_type());
                    Helper.gotoActivity(intent10, DirectLayer3Adapter.this.activity);
                    return;
                }
                if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("6")) {
                    if (TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_url()) && TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId())) {
                        Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.no_image_found), 0).show();
                        return;
                    }
                    Intent intent11 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) WebViewActivty.class);
                    intent11.putExtra("type", DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getTitle());
                    intent11.putExtra("url", DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_url());
                    intent11.putExtra("file_type", "image");
                    Helper.gotoActivity(intent11, DirectLayer3Adapter.this.activity);
                    return;
                }
                if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("3")) {
                    if (DirectLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                        if (TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_url()) && TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId())) {
                            Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.no_video_found), 0).show();
                            return;
                        }
                        Helper.audio_service_close((CourseActivity) DirectLayer3Adapter.this.activity);
                        DirectLayer3Adapter directLayer3Adapter = DirectLayer3Adapter.this;
                        directLayer3Adapter.API_REQUEST_VIDEO_LINK(directLayer3Adapter.examPrepItem.getList().get(i2), i2);
                        return;
                    }
                    if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getIs_locked().equalsIgnoreCase("1")) {
                        if (DirectLayer3Adapter.this.isCourseSoldOut()) {
                            Toast.makeText(DirectLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                            return;
                        }
                        Intent intent12 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                        intent12.putExtra(Const.SINGLE_STUDY, DirectLayer3Adapter.this.singleStudy);
                        intent12.putExtra(Const.IS_BOOK, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                        intent12.putExtra(Const.DELIVERY_CHARGE, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                        Helper.gotoActivity(intent12, DirectLayer3Adapter.this.activity);
                        return;
                    }
                    if (TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_url()) && TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId())) {
                        Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.no_video_found), 0).show();
                        return;
                    }
                    Helper.audio_service_close((CourseActivity) DirectLayer3Adapter.this.activity);
                    DirectLayer3Adapter directLayer3Adapter2 = DirectLayer3Adapter.this;
                    directLayer3Adapter2.API_REQUEST_VIDEO_LINK(directLayer3Adapter2.examPrepItem.getList().get(i2), i2);
                    return;
                }
                return;
            }
            ExamPrepItem examPrepItem = new ExamPrepItem();
            examPrepItem.setList(DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getList());
            Intent intent13 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) CourseActivity.class);
            SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(DirectLayer3Adapter.this.singleStudy != null ? DirectLayer3Adapter.this.singleStudy : new CourseDetail()));
            SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(examPrepItem));
            SharedPreference.getInstance().putString("list", new Gson().toJson(arrayList.get(i2) != null ? arrayList.get(i2) : new Lists()));
            intent13.putExtra(Const.FRAG_TYPE, Const.EXAMPREP);
            intent13.putExtra(Const.IS_COMBO, DirectLayer3Adapter.this.isCombo);
            intent13.putExtra("content_type", DirectLayer3Adapter.this.contentType);
            intent13.putExtra("title", DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail() != null ? DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getTitle() : "Course");
            intent13.putExtra("tile_id", DirectLayer3Adapter.this.tileIdAPI);
            intent13.putExtra(Const.TILE_TYPE, DirectLayer3Adapter.this.tileTypeAPI);
            intent13.putExtra(Const.REVERT_API, DirectLayer3Adapter.this.revertAPI);
            Helper.gotoActivity(intent13, DirectLayer3Adapter.this.activity);
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
            this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter.StudyNoDataViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DirectLayer3Adapter.this.activity.finish();
                }
            });
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
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$delete_meg$0(dialog, view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter$$ExternalSyntheticLambda3
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
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$download_data$2(lists, position, dialog, view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter$$ExternalSyntheticLambda1
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
                str = this.singleStudy.getData().getCourseDetail().getId() + MqttTopic.MULTI_LEVEL_WILDCARD;
            } else {
                str = SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + this.singleStudy.getData().getCourseDetail().getId();
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
            ((TextView) Objects.requireNonNull(textView)).setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$openwatchlist_dailog_resource$4(pos, videosDownload, mediaResponseMap, bottomSheetDialog);
                }
            }));
            ((TextView) Objects.requireNonNull(textView3)).setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$openwatchlist_dailog_resource$5(pos, videosDownload, mediaResponseMap, bottomSheetDialog);
                }
            }));
            ((TextView) Objects.requireNonNull(textView4)).setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter$$ExternalSyntheticLambda6
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

    private void dismissCalculatorDialog(BottomSheetDialog watchlist) {
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
                    Helper.GoToLiveAwsVideoActivity(videoData.getVideo_type(), videoData.getChat_node(), this.activity, videoData.getId(), videoData.getVideo_type(), videoData.getId(), videoData.getTitle(), "0", videoData.getThumbnail_url(), videoData.getPayload().getCourse_id(), videoData.getPayload().getTile_id(), videoData.getPayload().getTile_type(), videoData.getIs_chat_lock(), String.valueOf(position), SingleStudy.parentCourseId, videoData.getStart_date(), this.videoArrayList);
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
            Helper.GoToLiveAwsVideoActivity(videoData.getVideo_type(), videoData.getChat_node(), this.activity, videoData.getId(), videoData.getVideo_type(), videoData.getId(), videoData.getTitle(), "0", videoData.getThumbnail_url(), videoData.getPayload().getCourse_id(), videoData.getPayload().getTile_id(), videoData.getPayload().getTile_type(), videoData.getIs_chat_lock(), String.valueOf(position), SingleStudy.parentCourseId, videoData.getStart_date(), this.videoArrayList);
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
                    Helper.GoToLiveVideoActivity(videoData.getChat_node(), this.activity, videoData.getFile_url(), videoData.getVideo_type(), videoData.getId(), videoData.getTitle(), "0", videoData.getThumbnail_url(), videoData.getIs_chat_lock(), videoData.getPayload().getCourse_id(), String.valueOf(position), SingleStudy.parentCourseId, videoData.getPayload().getTile_id(), videoData.getPayload().getTile_type(), this.videoArrayList);
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
                    Helper.GoToLiveAwsVideoActivity(videoData.getVideo_type(), videoData.getChat_node(), this.activity, videoData.getId(), videoData.getVideo_type(), videoData.getId(), videoData.getTitle(), "0", videoData.getThumbnail_url(), videoData.getPayload().getCourse_id(), videoData.getPayload().getTile_id(), videoData.getPayload().getTile_type(), videoData.getIs_chat_lock(), String.valueOf(position), SingleStudy.parentCourseId, videoData.getStart_date(), this.videoArrayList);
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
            if (list != null && list.size() > 0) {
                this.ibt_single_sub_vd_RL.setVisibility(0);
                this.no_data_found_RL.setVisibility(8);
                int i = position - 1;
                if (list.get(i).getIs_live() != null && list.get(i).getIs_live().equals("1")) {
                    this.liveIV.setVisibility(0);
                } else {
                    this.liveIV.setVisibility(8);
                }
                this.titleCategory.setText(list.get(i).getTitle());
                if (list.get(i).getIs_locked().equals("0")) {
                    this.lockRL.setVisibility(8);
                } else {
                    this.lockRL.setVisibility(0);
                }
                if (DirectLayer3Adapter.this.isSkip.equalsIgnoreCase("3")) {
                    if (!TextUtils.isEmpty(list.get(i).getThumbnail_url())) {
                        Helper.setThumbnailImage(DirectLayer3Adapter.this.activity, list.get(i).getThumbnail_url(), DirectLayer3Adapter.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.imageIcon);
                    } else {
                        this.imageIcon.setImageResource(R.mipmap.square_placeholder);
                    }
                    this.share.setVisibility(0);
                    this.read_now.setEnabled(true);
                    this.studyitemLL.setEnabled(true);
                    this.read_now.setVisibility(0);
                    if (list.get(i).getIs_locked().equals("1")) {
                        this.read_now.setVisibility(8);
                    } else {
                        this.read_now.setVisibility(0);
                    }
                } else {
                    if (!TextUtils.isEmpty(list.get(i).getImage_icon())) {
                        Helper.setThumbnailImage(DirectLayer3Adapter.this.activity, list.get(i).getImage_icon(), DirectLayer3Adapter.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.imageIcon);
                    } else {
                        this.imageIcon.setImageResource(R.mipmap.square_placeholder);
                    }
                    this.share.setVisibility(8);
                    this.studyitemLL.setEnabled(true);
                    this.studyitemLL.setClickable(true);
                    this.read_now.setVisibility(8);
                }
                this.share.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter$SingleStudyPdfListHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$0(position, view);
                    }
                });
                this.read_now.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter.SingleStudyPdfListHolder.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        if (((Lists) list.get(position - 1)).getIs_locked().equalsIgnoreCase("1")) {
                            if (DirectLayer3Adapter.this.isCourseSoldOut()) {
                                Toast.makeText(DirectLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                                return;
                            }
                            Intent intent = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                            intent.putExtra(Const.SINGLE_STUDY, DirectLayer3Adapter.this.singleStudy);
                            intent.putExtra(Const.IS_BOOK, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                            intent.putExtra(Const.DELIVERY_CHARGE, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                            Helper.gotoActivity(intent, DirectLayer3Adapter.this.activity);
                            return;
                        }
                        if (DirectLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                            if (!DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("7") && (TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_url()) || TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getId()))) {
                                Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.no_pdf_found), 0).show();
                                return;
                            }
                            if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("8")) {
                                Intent intent2 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) WebViewActivty.class);
                                intent2.putExtra("type", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getTitle());
                                intent2.putExtra("url", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_url());
                                intent2.putExtra("course_id", (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId())).toString());
                                intent2.putExtra(Const.VIDEO_ID, DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getId());
                                intent2.putExtra("link", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type());
                                Helper.gotoActivity(intent2, DirectLayer3Adapter.this.activity);
                                return;
                            }
                            if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("1")) {
                                Helper.GoToWebViewPDFActivity(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getId(), DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_url(), !TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(position + (-1)).getIs_download_available()) && DirectLayer3Adapter.this.examPrepItem.getList().get(position + (-1)).getIs_download_available().equalsIgnoreCase("1"), DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getTitle(), (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId())).toString(), DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getIs_share());
                                return;
                            }
                            return;
                        }
                        if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getIs_locked().equalsIgnoreCase("1")) {
                            if (DirectLayer3Adapter.this.isCourseSoldOut()) {
                                Toast.makeText(DirectLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                                return;
                            }
                            Intent intent3 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                            intent3.putExtra(Const.SINGLE_STUDY, DirectLayer3Adapter.this.singleStudy);
                            intent3.putExtra(Const.IS_BOOK, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                            intent3.putExtra(Const.DELIVERY_CHARGE, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                            Helper.gotoActivity(intent3, DirectLayer3Adapter.this.activity);
                            return;
                        }
                        if (!DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("7") && (TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_url()) || TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getId()))) {
                            Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.no_pdf_found), 0).show();
                            return;
                        }
                        if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("8")) {
                            Intent intent4 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) WebViewActivty.class);
                            intent4.putExtra("type", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getTitle());
                            intent4.putExtra("url", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_url());
                            intent4.putExtra("course_id", (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId())).toString());
                            intent4.putExtra(Const.VIDEO_ID, DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getId());
                            intent4.putExtra("link", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type());
                            Helper.gotoActivity(intent4, DirectLayer3Adapter.this.activity);
                            return;
                        }
                        if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("1")) {
                            Helper.GoToWebViewPDFActivity(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getId(), DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_url(), !TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(position + (-1)).getIs_download_available()) && DirectLayer3Adapter.this.examPrepItem.getList().get(position + (-1)).getIs_download_available().equalsIgnoreCase("1"), DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getTitle(), (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId())).toString(), DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getIs_share());
                        }
                    }
                });
                this.studyitemLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter.SingleStudyPdfListHolder.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (((Lists) list.get(position - 1)).getIs_locked().equalsIgnoreCase("1")) {
                            if (DirectLayer3Adapter.this.isCourseSoldOut()) {
                                Toast.makeText(DirectLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                                return;
                            }
                            Intent intent = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                            intent.putExtra(Const.SINGLE_STUDY, DirectLayer3Adapter.this.singleStudy);
                            intent.putExtra(Const.IS_BOOK, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                            intent.putExtra(Const.DELIVERY_CHARGE, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                            Helper.gotoActivity(intent, DirectLayer3Adapter.this.activity);
                            return;
                        }
                        if (DirectLayer3Adapter.this.isSkip.equalsIgnoreCase("1") || DirectLayer3Adapter.this.isSkip.equalsIgnoreCase("2")) {
                            Intent intent2 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) CourseActivity.class);
                            SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(DirectLayer3Adapter.this.singleStudy != null ? DirectLayer3Adapter.this.singleStudy : new CourseDetail()));
                            SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(DirectLayer3Adapter.this.examPrepItem != null ? DirectLayer3Adapter.this.examPrepItem : new ExamPrepItem()));
                            SharedPreference.getInstance().putString("list", new Gson().toJson(DirectLayer3Adapter.this.examPrepItem.getList().get(position + (-1)) != null ? DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1) : new Lists()));
                            intent2.putExtra(Const.FRAG_TYPE, Const.EXAMPREPLAST);
                            intent2.putExtra(Const.LIST_SUBJECT, DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1));
                            intent2.putExtra(Const.IS_COMBO, DirectLayer3Adapter.this.isCombo);
                            intent2.putExtra("title", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getTitle());
                            intent2.putExtra("content_type", DirectLayer3Adapter.this.contentType);
                            intent2.putExtra(Const.TEST_TYPE, DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getCount());
                            intent2.putExtra("tile_id", DirectLayer3Adapter.this.tileIdAPI);
                            intent2.putExtra(Const.TILE_TYPE, DirectLayer3Adapter.this.tileTypeAPI);
                            intent2.putExtra(Const.REVERT_API, DirectLayer3Adapter.this.revertAPI);
                            Helper.gotoActivity(intent2, DirectLayer3Adapter.this.activity);
                            return;
                        }
                        if (DirectLayer3Adapter.this.isSkip.equalsIgnoreCase("3")) {
                            if (DirectLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                                if (!DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("7") && TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_url()) && TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getId())) {
                                    Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.no_pdf_found), 0).show();
                                    return;
                                }
                                if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("8")) {
                                    Intent intent3 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) WebViewActivty.class);
                                    intent3.putExtra("type", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getTitle());
                                    intent3.putExtra("url", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_url());
                                    intent3.putExtra("course_id", (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId())).toString());
                                    intent3.putExtra(Const.VIDEO_ID, DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getId());
                                    intent3.putExtra("link", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type());
                                    Helper.gotoActivity(intent3, DirectLayer3Adapter.this.activity);
                                }
                                if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("7")) {
                                    Intent intent4 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) WebViewActivty.class);
                                    intent4.putExtra("type", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getTitle());
                                    intent4.putExtra("url", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getDescription());
                                    Helper.gotoActivity(intent4, DirectLayer3Adapter.this.activity);
                                    return;
                                }
                                if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("1")) {
                                    Helper.GoToWebViewPDFActivity(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getId(), DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_url(), !TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(position + (-1)).getIs_download_available()) && DirectLayer3Adapter.this.examPrepItem.getList().get(position + (-1)).getIs_download_available().equalsIgnoreCase("1"), DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getTitle(), (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId())).toString(), DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getIs_share());
                                    return;
                                }
                                return;
                            }
                            if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getIs_locked().equalsIgnoreCase("1")) {
                                if (DirectLayer3Adapter.this.isCourseSoldOut()) {
                                    Toast.makeText(DirectLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                                    return;
                                }
                                Intent intent5 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                                intent5.putExtra(Const.SINGLE_STUDY, DirectLayer3Adapter.this.singleStudy);
                                intent5.putExtra(Const.IS_BOOK, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                                intent5.putExtra(Const.DELIVERY_CHARGE, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                                Helper.gotoActivity(intent5, DirectLayer3Adapter.this.activity);
                                return;
                            }
                            if (!DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("7") && TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_url()) && TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getId())) {
                                Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.no_pdf_found), 0).show();
                                return;
                            }
                            if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("8")) {
                                Intent intent6 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) WebViewActivty.class);
                                intent6.putExtra("type", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getTitle());
                                intent6.putExtra("url", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_url());
                                intent6.putExtra("course_id", (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId())).toString());
                                intent6.putExtra(Const.VIDEO_ID, DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getId());
                                intent6.putExtra("link", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type());
                                Helper.gotoActivity(intent6, DirectLayer3Adapter.this.activity);
                            }
                            if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("7")) {
                                Intent intent7 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) WebViewActivty.class);
                                intent7.putExtra("type", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getTitle());
                                intent7.putExtra("url", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getDescription());
                                Helper.gotoActivity(intent7, DirectLayer3Adapter.this.activity);
                                return;
                            }
                            if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("1")) {
                                Helper.GoToWebViewPDFActivity(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getId(), DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_url(), !TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(position + (-1)).getIs_download_available()) && DirectLayer3Adapter.this.examPrepItem.getList().get(position + (-1)).getIs_download_available().equalsIgnoreCase("1"), DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getTitle(), (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId())).toString(), DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getIs_share());
                                return;
                            }
                            return;
                        }
                        ExamPrepItem examPrepItem = new ExamPrepItem();
                        examPrepItem.setList(DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getList());
                        Intent intent8 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) CourseActivity.class);
                        SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(DirectLayer3Adapter.this.singleStudy != null ? DirectLayer3Adapter.this.singleStudy : new CourseDetail()));
                        SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(examPrepItem));
                        SharedPreference.getInstance().putString("list", new Gson().toJson(list.get(position + (-1)) != null ? list.get(position - 1) : new Lists()));
                        intent8.putExtra(Const.FRAG_TYPE, Const.EXAMPREP);
                        intent8.putExtra(Const.IS_COMBO, DirectLayer3Adapter.this.isCombo);
                        intent8.putExtra("content_type", DirectLayer3Adapter.this.contentType);
                        intent8.putExtra("title", DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail() != null ? DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getTitle() : "Course");
                        intent8.putExtra("tile_id", DirectLayer3Adapter.this.tileIdAPI);
                        intent8.putExtra(Const.TILE_TYPE, DirectLayer3Adapter.this.tileTypeAPI);
                        intent8.putExtra(Const.REVERT_API, DirectLayer3Adapter.this.revertAPI);
                        Helper.gotoActivity(intent8, DirectLayer3Adapter.this.activity);
                    }
                });
                this.leftMenu = (LeftMenu) new Gson().fromJson(DirectLayer3Adapter.this.themeSettings.getLeft_menu(), LeftMenu.class);
                if (list.get(i).getIs_locked().equals("1") && Helper.isShowShareButton(this.leftMenu)) {
                    this.share.setVisibility(0);
                    return;
                } else {
                    this.share.setVisibility(8);
                    return;
                }
            }
            this.ibt_single_sub_vd_RL.setVisibility(8);
            this.no_data_found_RL.setVisibility(0);
            this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter.SingleStudyPdfListHolder.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DirectLayer3Adapter.this.activity.finish();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$0(int i, View view) {
            if (DirectLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                int i2 = i - 1;
                if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("8") || DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("7") || DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getFile_type().equalsIgnoreCase("1")) {
                    Helper.sharePdf(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getTopic_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getRevert_api(), Const.PDF, DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getThumbnail_url(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getTitle(), SingleStudy.parentCourseId);
                    return;
                }
                return;
            }
            int i3 = i - 1;
            if (DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getIs_locked().equalsIgnoreCase("1")) {
                if (DirectLayer3Adapter.this.isCourseSoldOut()) {
                    Toast.makeText(DirectLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, DirectLayer3Adapter.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, DirectLayer3Adapter.this.activity);
                return;
            }
            if (DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getFile_type().equalsIgnoreCase("8") || DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getFile_type().equalsIgnoreCase("7") || DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getFile_type().equalsIgnoreCase("1")) {
                Helper.sharePdf(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getPayload().getCourse_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getId(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getPayload().getTopic_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getPayload().getTile_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getPayload().getTile_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getPayload().getRevert_api(), Const.PDF, DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getThumbnail_url(), DirectLayer3Adapter.this.examPrepItem.getList().get(i3).getTitle(), SingleStudy.parentCourseId);
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
                map.merge(sectionId, Float.valueOf(floatSafe), new BiFunction() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter$$ExternalSyntheticLambda7
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
            if (list != null && list.size() > 0) {
                this.ibt_single_sub_vd_RL.setVisibility(0);
                this.no_data_found_RL.setVisibility(8);
                int i = position - 1;
                if (list.get(i).getIs_live() != null && list.get(i).getIs_live().equals("1")) {
                    this.liveIV.setVisibility(0);
                } else {
                    this.liveIV.setVisibility(8);
                }
                this.titleCategory.setText(list.get(i).getTitle());
                if (DirectLayer3Adapter.this.isSkip.equalsIgnoreCase("3")) {
                    this.share.setVisibility(8);
                    if (list.get(i).getFile_type().equalsIgnoreCase("7")) {
                        if ("1".equalsIgnoreCase("5")) {
                            this.layout_fun.setVisibility(8);
                        } else {
                            this.layout_fun.setVisibility(0);
                        }
                        this.read_now.setVisibility(0);
                        this.optionMenuImgView.setVisibility(8);
                        this.studyitemLL.setEnabled(true);
                        this.share.setVisibility(0);
                    } else if (list.get(i).getFile_type().equalsIgnoreCase("12") || list.get(i).getFile_type().equalsIgnoreCase("11") || list.get(i).getFile_type().equalsIgnoreCase("8")) {
                        if ("1".equalsIgnoreCase("5")) {
                            this.layout_fun.setVisibility(8);
                        } else {
                            this.layout_fun.setVisibility(0);
                        }
                        this.read_now.setVisibility(0);
                        this.optionMenuImgView.setVisibility(0);
                        this.optionMenuImgView.setImageResource(R.drawable.delete);
                        this.subItemRV.setText(DirectLayer3Adapter.this.activity.getResources().getString(R.string.revision_type));
                        this.studyitemLL.setEnabled(true);
                    } else {
                        this.layout_fun.setVisibility(8);
                        this.read_now.setVisibility(8);
                        this.optionMenuImgView.setVisibility(8);
                    }
                    if (list.get(i).getIs_locked().equals("1")) {
                        this.read_now.setVisibility(8);
                    } else {
                        this.read_now.setVisibility(0);
                    }
                } else {
                    this.studyitemLL.setEnabled(true);
                    this.layout_fun.setVisibility(8);
                    this.read_now.setVisibility(8);
                    if (list.get(i).getCount() != null) {
                        this.subItemRV.setText(DirectLayer3Adapter.this.activity.getResources().getString(R.string.total_) + list.get(i).getCount());
                    }
                    this.subItemRV.setVisibility(8);
                }
                if (!TextUtils.isEmpty(list.get(i).getThumbnail_url())) {
                    Helper.setThumbnailImage(DirectLayer3Adapter.this.activity, list.get(i).getThumbnail_url(), DirectLayer3Adapter.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.imageIcon);
                } else {
                    this.imageIcon.setImageResource(R.mipmap.square_placeholder);
                }
                this.leftMenu = (LeftMenu) new Gson().fromJson(DirectLayer3Adapter.this.themeSettings.getLeft_menu(), LeftMenu.class);
                if (list.get(i).getIs_locked().equals("0")) {
                    this.lockRL.setVisibility(8);
                    if (Helper.isShowShareButton(this.leftMenu)) {
                        this.share.setVisibility(0);
                    } else {
                        this.share.setVisibility(8);
                    }
                } else {
                    this.lockRL.setVisibility(0);
                    this.share.setVisibility(8);
                }
                this.optionMenuImgView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter.SingleStudyConceptListHolder.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        if (DirectLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                            if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("10") || DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("12") || DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("11")) {
                                DirectLayer3Adapter.this.videodata = DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1);
                                DirectLayer3Adapter.this.position_delete = position - 1;
                                DirectLayer3Adapter.this.delete_meg(DirectLayer3Adapter.this.videodata);
                                return;
                            }
                            if (!VideoDownloadService.isServiceRunning) {
                                if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getVideo_type().equalsIgnoreCase("6")) {
                                    DirectLayer3Adapter.this.download_data(DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1), position);
                                    return;
                                } else {
                                    Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.only_jw_video_download), 0).show();
                                    return;
                                }
                            }
                            Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.please_wait_downloading_is_in_progress), 0).show();
                            return;
                        }
                        if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getIs_locked().equalsIgnoreCase("1")) {
                            if (DirectLayer3Adapter.this.isCourseSoldOut()) {
                                Toast.makeText(DirectLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                                return;
                            }
                            Intent intent = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                            intent.putExtra(Const.SINGLE_STUDY, DirectLayer3Adapter.this.singleStudy);
                            intent.putExtra(Const.IS_BOOK, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                            intent.putExtra(Const.DELIVERY_CHARGE, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                            Helper.gotoActivity(intent, DirectLayer3Adapter.this.activity);
                            return;
                        }
                        if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("10") || DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("12") || DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("11")) {
                            DirectLayer3Adapter.this.videodata = DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1);
                            DirectLayer3Adapter.this.position_delete = position - 1;
                            DirectLayer3Adapter.this.delete_meg(DirectLayer3Adapter.this.videodata);
                            return;
                        }
                        if (!VideoDownloadService.isServiceRunning) {
                            if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getVideo_type().equalsIgnoreCase("6")) {
                                DirectLayer3Adapter.this.download_data(DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1), position);
                                return;
                            } else {
                                Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.only_jw_video_download), 0).show();
                                return;
                            }
                        }
                        Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.please_wait_downloading_is_in_progress), 0).show();
                    }
                });
                this.read_now.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter.SingleStudyConceptListHolder.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        if (((Lists) list.get(position - 1)).getIs_locked().equalsIgnoreCase("1")) {
                            if (DirectLayer3Adapter.this.isCourseSoldOut()) {
                                Toast.makeText(DirectLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                                return;
                            }
                            Intent intent = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                            intent.putExtra(Const.SINGLE_STUDY, DirectLayer3Adapter.this.singleStudy);
                            intent.putExtra(Const.IS_BOOK, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                            intent.putExtra(Const.DELIVERY_CHARGE, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                            Helper.gotoActivity(intent, DirectLayer3Adapter.this.activity);
                            return;
                        }
                        if (DirectLayer3Adapter.this.isSkip.equalsIgnoreCase("3")) {
                            if (DirectLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                                if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("12")) {
                                    if (DirectLayer3Adapter.this.examPrepItem.getList().size() > 0) {
                                        Intent intent2 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) RevisionActivity.class);
                                        intent2.putExtra("t_id", DirectLayer3Adapter.this.tileIdAPI);
                                        intent2.putExtra("postion", position);
                                        intent2.putExtra(Const.VIDEO_ID, DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getId());
                                        intent2.putExtra("v_list", ExamPrepLayer2.actual_videolist);
                                        intent2.putExtra("f_id", DirectLayer3Adapter.this.examPrepItem.getList().get(0).getId());
                                        intent2.putExtra("c_id", DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
                                        intent2.putExtra("title", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getTitle());
                                        intent2.putExtra("url", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_url());
                                        intent2.putExtra(Const.VIA, "main");
                                        Helper.gotoActivity(intent2, DirectLayer3Adapter.this.activity);
                                        return;
                                    }
                                    return;
                                }
                                if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("11")) {
                                    Intent intent3 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) WebViewActivty.class);
                                    intent3.putExtra("type", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getTitle());
                                    intent3.putExtra("url", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_url());
                                    Helper.gotoActivity(intent3, DirectLayer3Adapter.this.activity);
                                    return;
                                }
                                if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("8")) {
                                    Intent intent4 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) WebViewActivty.class);
                                    intent4.putExtra("type", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getTitle());
                                    intent4.putExtra("url", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_url());
                                    intent4.putExtra("course_id", (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId())).toString());
                                    intent4.putExtra(Const.VIDEO_ID, DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getId());
                                    intent4.putExtra("link", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type());
                                    Helper.gotoActivity(intent4, DirectLayer3Adapter.this.activity);
                                    return;
                                }
                                if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("6")) {
                                    if (TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_url()) && TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getId())) {
                                        Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.no_image_found), 0).show();
                                        return;
                                    }
                                    Intent intent5 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) WebViewActivty.class);
                                    intent5.putExtra("type", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getTitle());
                                    intent5.putExtra("url", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_url());
                                    intent5.putExtra("file_type", "image");
                                    Helper.gotoActivity(intent5, DirectLayer3Adapter.this.activity);
                                    return;
                                }
                                Intent intent6 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) Concept_newActivity.class);
                                intent6.putExtra("id", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getId());
                                intent6.putExtra("name", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getTitle());
                                intent6.putExtra("course_id", (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId())).toString());
                                intent6.putExtra("tile_id", DirectLayer3Adapter.this.tileIdAPI);
                                Helper.gotoActivity(intent6, DirectLayer3Adapter.this.activity);
                                return;
                            }
                            if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getIs_locked().equalsIgnoreCase("1")) {
                                if (DirectLayer3Adapter.this.isCourseSoldOut()) {
                                    Toast.makeText(DirectLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                                    return;
                                }
                                Intent intent7 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                                intent7.putExtra(Const.SINGLE_STUDY, DirectLayer3Adapter.this.singleStudy);
                                intent7.putExtra(Const.IS_BOOK, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                                intent7.putExtra(Const.DELIVERY_CHARGE, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                                Helper.gotoActivity(intent7, DirectLayer3Adapter.this.activity);
                                return;
                            }
                            if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("12")) {
                                if (DirectLayer3Adapter.this.examPrepItem.getList().size() > 0) {
                                    Intent intent8 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) RevisionActivity.class);
                                    intent8.putExtra("t_id", DirectLayer3Adapter.this.tileIdAPI);
                                    intent8.putExtra("postion", position);
                                    intent8.putExtra(Const.VIDEO_ID, DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getId());
                                    intent8.putExtra("v_list", ExamPrepLayer2.actual_videolist);
                                    intent8.putExtra("f_id", DirectLayer3Adapter.this.examPrepItem.getList().get(0).getId());
                                    intent8.putExtra("c_id", DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId());
                                    intent8.putExtra("title", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getTitle());
                                    intent8.putExtra("url", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_url());
                                    intent8.putExtra(Const.VIA, "main");
                                    Helper.gotoActivity(intent8, DirectLayer3Adapter.this.activity);
                                    return;
                                }
                                return;
                            }
                            if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("11")) {
                                Intent intent9 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) WebViewActivty.class);
                                intent9.putExtra("type", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getTitle());
                                intent9.putExtra("url", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_url());
                                Helper.gotoActivity(intent9, DirectLayer3Adapter.this.activity);
                                return;
                            }
                            if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("8")) {
                                Intent intent10 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) WebViewActivty.class);
                                intent10.putExtra("type", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getTitle());
                                intent10.putExtra("url", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_url());
                                intent10.putExtra("course_id", (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId())).toString());
                                intent10.putExtra(Const.VIDEO_ID, DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getId());
                                intent10.putExtra("link", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type());
                                Helper.gotoActivity(intent10, DirectLayer3Adapter.this.activity);
                                return;
                            }
                            if (DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_type().equalsIgnoreCase("6")) {
                                if (TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_url()) && TextUtils.isEmpty(DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getId())) {
                                    Toast.makeText(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.activity.getResources().getString(R.string.no_image_found), 0).show();
                                    return;
                                }
                                Intent intent11 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) WebViewActivty.class);
                                intent11.putExtra("type", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getTitle());
                                intent11.putExtra("url", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getFile_url());
                                intent11.putExtra("file_type", "image");
                                Helper.gotoActivity(intent11, DirectLayer3Adapter.this.activity);
                                return;
                            }
                            Intent intent12 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) Concept_newActivity.class);
                            intent12.putExtra("id", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getId());
                            intent12.putExtra("name", DirectLayer3Adapter.this.examPrepItem.getList().get(position - 1).getTitle());
                            intent12.putExtra("course_id", (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId())).toString());
                            intent12.putExtra("tile_id", DirectLayer3Adapter.this.tileIdAPI);
                            Helper.gotoActivity(intent12, DirectLayer3Adapter.this.activity);
                        }
                    }
                });
                this.studyitemLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter$SingleStudyConceptListHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$0(list, position, view);
                    }
                });
                this.share.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter$SingleStudyConceptListHolder$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$setData$1(position);
                    }
                }));
                LeftMenu leftMenu = (LeftMenu) new Gson().fromJson(DirectLayer3Adapter.this.themeSettings.getLeft_menu(), LeftMenu.class);
                this.leftMenu = leftMenu;
                if (Helper.isShowShareButton(leftMenu)) {
                    this.share.setVisibility(0);
                    return;
                } else {
                    this.share.setVisibility(8);
                    return;
                }
            }
            this.ibt_single_sub_vd_RL.setVisibility(8);
            this.no_data_found_RL.setVisibility(0);
            this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter$SingleStudyConceptListHolder$$ExternalSyntheticLambda2
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
                if (DirectLayer3Adapter.this.isCourseSoldOut()) {
                    Toast.makeText(DirectLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                Intent intent = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                intent.putExtra(Const.SINGLE_STUDY, DirectLayer3Adapter.this.singleStudy);
                intent.putExtra(Const.IS_BOOK, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent.putExtra(Const.DELIVERY_CHARGE, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                Helper.gotoActivity(intent, DirectLayer3Adapter.this.activity);
                return;
            }
            if (DirectLayer3Adapter.this.isSkip.equalsIgnoreCase("1") || DirectLayer3Adapter.this.isSkip.equalsIgnoreCase("2")) {
                String str = Const.TILE_TYPE;
                String str2 = "title";
                Intent intent2 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) CourseActivity.class);
                SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(DirectLayer3Adapter.this.singleStudy != null ? DirectLayer3Adapter.this.singleStudy : new CourseDetail()));
                SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(DirectLayer3Adapter.this.examPrepItem != null ? DirectLayer3Adapter.this.examPrepItem : new ExamPrepItem()));
                SharedPreference.getInstance().putString("list", new Gson().toJson(DirectLayer3Adapter.this.examPrepItem.getList().get(i2) != null ? DirectLayer3Adapter.this.examPrepItem.getList().get(i2) : new Lists()));
                intent2.putExtra(Const.FRAG_TYPE, Const.EXAMPREPLAST);
                intent2.putExtra(Const.LIST_SUBJECT, DirectLayer3Adapter.this.examPrepItem.getList().get(i2));
                intent2.putExtra(Const.IS_COMBO, DirectLayer3Adapter.this.isCombo);
                intent2.putExtra(str2, DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getTitle());
                intent2.putExtra("content_type", DirectLayer3Adapter.this.contentType);
                intent2.putExtra(Const.TEST_TYPE, DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getCount());
                intent2.putExtra("tile_id", DirectLayer3Adapter.this.tileIdAPI);
                intent2.putExtra(str, DirectLayer3Adapter.this.tileTypeAPI);
                intent2.putExtra(Const.REVERT_API, DirectLayer3Adapter.this.revertAPI);
                Helper.gotoActivity(intent2, DirectLayer3Adapter.this.activity);
                return;
            }
            if (DirectLayer3Adapter.this.isSkip.equalsIgnoreCase("3")) {
                if (DirectLayer3Adapter.this.is_purchase.equalsIgnoreCase("1")) {
                    Intent intent3 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) Concept_newActivity.class);
                    intent3.putExtra("id", DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId());
                    intent3.putExtra("name", DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getTitle());
                    intent3.putExtra("course_id", (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId())).toString());
                    intent3.putExtra("tile_id", DirectLayer3Adapter.this.tileIdAPI);
                    Helper.gotoActivity(intent3, DirectLayer3Adapter.this.activity);
                    return;
                }
                if (DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getIs_locked().equalsIgnoreCase("1")) {
                    if (DirectLayer3Adapter.this.isCourseSoldOut()) {
                        Toast.makeText(DirectLayer3Adapter.this.activity, R.string.sold_out_msg, 0).show();
                        return;
                    }
                    Intent intent4 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) PurchaseActivity.class);
                    intent4.putExtra(Const.SINGLE_STUDY, DirectLayer3Adapter.this.singleStudy);
                    intent4.putExtra(Const.IS_BOOK, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getCat_type());
                    intent4.putExtra(Const.DELIVERY_CHARGE, DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                    Helper.gotoActivity(intent4, DirectLayer3Adapter.this.activity);
                    return;
                }
                Intent intent5 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) Concept_newActivity.class);
                intent5.putExtra("id", DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId());
                intent5.putExtra("name", DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getTitle());
                intent5.putExtra("course_id", (SingleStudy.parentCourseId.equalsIgnoreCase("") ? new StringBuilder().append(DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId()).append(MqttTopic.MULTI_LEVEL_WILDCARD) : new StringBuilder().append(SingleStudy.parentCourseId).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getId())).toString());
                intent5.putExtra("tile_id", DirectLayer3Adapter.this.tileIdAPI);
                Helper.gotoActivity(intent5, DirectLayer3Adapter.this.activity);
                return;
            }
            ExamPrepItem examPrepItem = new ExamPrepItem();
            examPrepItem.setList(DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getList());
            Intent intent6 = new Intent(DirectLayer3Adapter.this.activity, (Class<?>) CourseActivity.class);
            SharedPreference.getInstance().putString(Const.SINGLE_STUDY_DATA, new Gson().toJson(DirectLayer3Adapter.this.singleStudy != null ? DirectLayer3Adapter.this.singleStudy : new CourseDetail()));
            SharedPreference.getInstance().putString(Const.EXAMPREP, new Gson().toJson(examPrepItem));
            SharedPreference.getInstance().putString("list", new Gson().toJson(arrayList.get(i2) != null ? arrayList.get(i2) : new Lists()));
            intent6.putExtra(Const.FRAG_TYPE, Const.EXAMPREP);
            intent6.putExtra(Const.IS_COMBO, DirectLayer3Adapter.this.isCombo);
            intent6.putExtra("content_type", DirectLayer3Adapter.this.contentType);
            intent6.putExtra("title", DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail() != null ? DirectLayer3Adapter.this.singleStudy.getData().getCourseDetail().getTitle() : "Course");
            intent6.putExtra("tile_id", DirectLayer3Adapter.this.tileIdAPI);
            intent6.putExtra(Const.TILE_TYPE, DirectLayer3Adapter.this.tileTypeAPI);
            intent6.putExtra(Const.REVERT_API, DirectLayer3Adapter.this.revertAPI);
            Helper.gotoActivity(intent6, DirectLayer3Adapter.this.activity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$setData$1(int i) {
            int i2 = i - 1;
            Helper.sharePdf(DirectLayer3Adapter.this.activity, DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getCourse_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getId(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getTopic_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getTile_type(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getTile_id(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getPayload().getRevert_api(), Const.PDF, DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getThumbnail_url(), DirectLayer3Adapter.this.examPrepItem.getList().get(i2).getTitle(), SingleStudy.parentCourseId);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$2(View view) {
            DirectLayer3Adapter.this.activity.finish();
        }
    }

    public void showPopMenuForLangauge(final View v, final TestBasicInst testBasicInst, final TextView v1, TextView vvv) {
        PopupMenu popupMenu = new PopupMenu(this.activity, v);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.Courses.Adapter.DirectLayer3Adapter.3
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem item) {
                ((TextView) v).setText(item.getTitle().toString());
                if (item.getTitle().toString().equals(DirectLayer3Adapter.this.activity.getResources().getString(R.string.hindi))) {
                    DirectLayer3Adapter.this.lang = 2;
                    if (testBasicInst.getMulti_description().size() > 0 && testBasicInst.getMulti_description().get(1).getDescription() != null) {
                        v1.setText(Html.fromHtml(testBasicInst.getMulti_description().get(1).getDescription()));
                    }
                } else if (item.getTitle().toString().equals(DirectLayer3Adapter.this.activity.getResources().getString(R.string.english))) {
                    DirectLayer3Adapter.this.lang = 1;
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
}
