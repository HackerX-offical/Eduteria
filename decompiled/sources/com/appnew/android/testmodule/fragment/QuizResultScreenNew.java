package com.appnew.android.testmodule.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.PopupMenu;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.BuildConfig;
import com.appnew.android.Courses.Activity.PdfDetailScreen;
import com.appnew.android.Courses.Activity.QuizActivity;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.Courses.quiz.QuizModel;
import com.appnew.android.Model.Courses.quiz.ResultTestSeries;
import com.appnew.android.Model.PostFile;
import com.appnew.android.Model.TestReportModel.TestReport;
import com.appnew.android.Model.Topper;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.AppPermissionsRunTime;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.GenericUtils;
import com.appnew.android.Utils.GridSpacingItemDecoration;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.MainFragment;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.NonScrollRecyclerView;
import com.appnew.android.Utils.Progress;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.pojo.Userinfo.Data;
import com.appnew.android.testmodule.activity.TestBaseActivity;
import com.appnew.android.testmodule.activity.VideoPlayActivity;
import com.appnew.android.testmodule.activity.ViewSolutionActivity;
import com.appnew.android.testmodule.adapter.AnswerListAdapter;
import com.appnew.android.testmodule.adapter.LeaderBoardAdapter;
import com.appnew.android.testmodule.adapter.RankAdapter;
import com.appnew.android.testmodule.model.InstructionData;
import com.appnew.android.testmodule.model.QuestionDump;
import com.appnew.android.testmodule.model.ResultTestSeries_Report;
import com.appnew.android.testmodule.model.TestBasicInst;
import com.appnew.android.testmodule.model.TestSectionInst;
import com.appnew.android.testmodule.model.TestSeriesResultData;
import com.appnew.android.testmodule.model.TestseriesBase;
import com.appnew.android.testmodule.model.TopTenList;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes6.dex */
public class QuizResultScreenNew extends MainFragment {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    TextView AvgScore;
    LinearLayout OverAllDurationLL;
    LinearLayout RankNewLL;
    LinearLayout RankOldLL;
    LinearLayout SubjectDetailsLL;
    TextView TopperTestAccuracyTV;
    TextView TopperTestAttemptedTV;
    TextView TopperTestScoreTV;
    TextView TopperTestTimeTV;
    TextView accuracyTV;
    LinearLayout accuracy_LL;
    RelativeLayout accuracy_sectionwise;
    Activity activity;
    RankAdapter adapter;
    AnswerListAdapter answerListAdapter;
    NonScrollRecyclerView answerListRV;
    ArrayList<String> arrayList;
    TextView attemptedTV;
    Button btnPartA;
    Button btnPartB;
    Button btnPartC;
    Button btnPartD;
    Button btnPartE;
    Button btnPartF;
    Button btnPartG;
    Button btnPartH;
    Button btnPartI;
    Button btnPartJ;
    Button btnPartK;
    Button btnPartL;
    Button btnPartM;
    Button btnPartN;
    Button btnPartO;
    CardView card_score;
    TextView disqualified;
    LinearLayout downloadPDFLL;
    TextView expectedRankRangeTV;
    TextView guessTV;
    Guideline guideline;
    LinearLayout improvementLL;
    TextView improvementTV;
    int lang;
    LeaderBoardAdapter leaderBoardAdapter;
    LinearLayout leaderboard_ll;
    TextView leaderboard_text;
    LinearLayout llNewTest;
    LinearLayout ll_acuracy;
    LinearLayout ll_main_rank;
    RelativeLayout ll_not_qualified;
    LinearLayout ll_offered_course;
    LinearLayout ll_offered_course2;
    RelativeLayout ll_scholorship_main;
    LinearLayout ll_test_score_LL;
    LinearLayout ll_test_taken_time;
    TextView mandatory;
    LinearLayout mandratoryLinear;
    TextView maxMarks;
    Progress mprogress;
    ArrayList<QuestionDump> newQuestionDump;
    RelativeLayout no_data_found_RL;
    TextView optional;
    LinearLayout optionalLinear;
    LinearLayout overAllDetailsLL;
    TextView percent;
    TextView percentageTV;
    LinearLayout percentileLL;
    TextView percentileTV;
    TextView percentileTV_1;
    Progress progress;
    ProgressBar progressBar;
    LinearLayout questionSkipLL;
    TextView questionSkipTV;
    QuizModel quiz;
    LinearLayout rank;
    LinearLayout rankPredictionNoteLL;
    TextView rankPredictionTV;
    RelativeLayout rankRL;
    LinearLayout rank_score_LL;
    TextView ranks_1;
    TextView reattempts;
    NonScrollRecyclerView recyclerviewrank;
    TextView resultAccuracyTV;
    TextView resultAttemptTV;
    TextView resultAttemptTV_1;
    TextView resultAttemptedTV;
    TextView resultAvgScoreTV;
    TextView resultBestScoreTV;
    TextView resultBookmarkTV;
    TextView resultCorrectTV;
    TextView resultCorrectTV_1;
    LinearLayout resultDeclaredLL;
    LinearLayout resultDownloadCertificate;
    TextView resultGuessTV;
    TextView resultIncorrectTV;
    TextView resultIncorrectTV_1;
    TextView resultNameTV;
    LinearLayout resultOutLL;
    TextView resultPercentileTV;
    TextView resultRankTV;
    TextView resultScoreTV;
    TextView resultSkippedTV;
    ResultTestSeries_Report resultTestSeries2;
    TextView resultTimeDuration;
    TextView resultUnAttemptTV;
    TextView resultUnAttemptTV_1;
    LinearLayout resultViewSolution;
    RecyclerView rv_scholarship_course;
    RecyclerView rv_scholarship_course2;
    LinearLayout scholorshipViewSolution;
    RelativeLayout scholorshipViewSolutionRL;
    LinearLayout scoreLL;
    TextView scoreTV;
    String showCertificate;
    LinearLayout showLess;
    LinearLayout showMore;
    HorizontalScrollView solution_horizontal_scroll;
    TextView ssEnabledText;
    TextView subPercentileTV_1;
    RelativeLayout subjectRankRl;
    LinearLayout subjectScoreTimeLL;
    TestReport testReport;
    ArrayList<TestSeriesResultData> testSeriesResultDataArrayList;
    String testseriesid;
    TextView timeTV;
    ProgressBar topperAccuracyProgressBar;
    ProgressBar topperAttemptedProgressBar;
    ProgressBar topperScoreProgressBar;
    ProgressBar topperTimeProgressBar;
    LinearLayout totalAttemptedLL;
    TextView tvScore;
    TextView tv_how_you_perform;
    TextView tv_max_score_hint;
    TextView tv_not_qualified;
    TextView tv_score_hint;
    TextView tv_test_prize;
    public Data user;
    ProgressBar userAccuracyProgressBar;
    TextView userAttempt;
    ProgressBar userAttemptedProgressBar;
    ProgressBar userScoreProgressBar;
    TextView userTestAccuracyTv;
    TextView userTestAttemptedTv;
    TextView userTestScoreTv;
    TextView userTestTimeTv;
    ProgressBar userTimeProgressBar;
    LinearLayout videosolution;
    LinearLayout videosolution2;
    TextView viewMore;
    LinearLayout viewOMRLl;
    LinearLayout viewOfflineTest;
    RelativeLayout viewSubjectWiseDetailRL;
    View view_test_taken_time;
    View viewaccuracy;
    View viewpercentile;
    int test_type = 1;
    String frag_type = "";
    String status = "";
    String ssEnabled = "0";
    int total_answered = 0;
    String testSeriesName = "";
    String first_attempt = "";
    String show_leader = "";
    ArrayList<QuestionDump> questionDumps = new ArrayList<>();
    List<TopTenList> topTenLists = new ArrayList();
    List<com.appnew.android.Model.TestReportModel.LeaderBoard> leaderBoardsList = new ArrayList();
    List<com.appnew.android.Model.TestReportModel.LeaderBoard> leaderBoardsSubjectList = new ArrayList();
    String mode = "";
    String accuracy = "";
    String score = "";
    String totalQuestion = "";
    String attemptQuestion = "";
    String userTestTime = "";
    String[] langIds = {"1"};

    static /* synthetic */ void lambda$initViews$0(View view) {
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        return null;
    }

    public static Fragment newInstance(String frag_type, ResultTestSeries resultTestSeries2, QuizModel quiz, String testSeriesName, String first_attempt, String mode) {
        QuizResultScreenNew quizResultScreenNew = new QuizResultScreenNew();
        Bundle bundle = new Bundle();
        bundle.putSerializable("test_series", resultTestSeries2);
        bundle.putSerializable(Const.FRAG_TYPE, frag_type);
        bundle.putSerializable(Const.RESULT_SCREEN, quiz);
        bundle.putString("name", testSeriesName);
        bundle.putString("mode", mode);
        bundle.putString("first_attempt", first_attempt);
        quizResultScreenNew.setArguments(bundle);
        return quizResultScreenNew;
    }

    public static Fragment newInstance(String frag_type, String status, String testSeriesName, String first_attempt, String show_leader, String mode) {
        QuizResultScreenNew quizResultScreenNew = new QuizResultScreenNew();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Const.FRAG_TYPE, frag_type);
        bundle.putSerializable("status", status);
        bundle.putString("name", testSeriesName);
        bundle.putString("mode", mode);
        bundle.putString("first_attempt", first_attempt);
        bundle.putString("show_leader", show_leader);
        quizResultScreenNew.setArguments(bundle);
        return quizResultScreenNew;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.quiz_result_screen_new, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.user = SharedPreference.getInstance().getLoggedInUser();
        Progress progress = new Progress(this.activity);
        this.mprogress = progress;
        progress.setCancelable(false);
        this.mode = this.activity.getIntent().getExtras().getString("mode");
        initViews(view);
        this.arrayList = new ArrayList<>();
        this.testSeriesResultDataArrayList = new ArrayList<>();
        this.newQuestionDump = new ArrayList<>();
        String str = this.showCertificate;
        if (str != null && str.equalsIgnoreCase("1")) {
            this.resultDownloadCertificate.setVisibility(0);
        }
        if (this.ssEnabled.equalsIgnoreCase("1")) {
            Helper.ResultScreenShot(this.activity);
            this.ssEnabledText.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.status)) {
            String str2 = this.mode;
            if (str2 != null && str2.equalsIgnoreCase("1")) {
                netoworkCallForQuizReport();
            } else {
                netoworkCallForQuizResult2();
            }
        }
        this.rv_scholarship_course.setLayoutManager(new LinearLayoutManager(requireActivity()));
        this.rv_scholarship_course2.setLayoutManager(new LinearLayoutManager(requireActivity()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAndHideDataForScholorship() {
        this.scholorshipViewSolutionRL.setVisibility(8);
        if (this.first_attempt.equalsIgnoreCase("1")) {
            this.ll_scholorship_main.setVisibility(0);
        } else {
            this.ll_scholorship_main.setVisibility(8);
        }
    }

    public void setProgressBarGradient(ProgressBar progressBar) {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{-11027969, -11027969, -11027969});
        gradientDrawable.setCornerRadius(20.0f);
        ClipDrawable clipDrawable = new ClipDrawable(gradientDrawable, 3, 1);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor("#F5F5F5"));
        gradientDrawable2.setCornerRadius(20.0f);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable2, clipDrawable});
        layerDrawable.setId(0, android.R.id.background);
        layerDrawable.setId(1, android.R.id.progress);
        progressBar.setProgressDrawable(layerDrawable);
    }

    public void setRank(ResultTestSeries_Report.DataResult ResultData) {
        String string = SharedPreference.getInstance().getString("rank_compayer");
        boolean z = string != null && string.equalsIgnoreCase("1");
        if (ResultData != null && ResultData.getTopper() != null) {
            Topper topper = ResultData.getTopper();
            if (topper.getHide_topper() != null && topper.getHide_topper().equalsIgnoreCase("0") && z) {
                this.accuracy = String.valueOf(this.resultTestSeries2.getData().getTest_sections().get(0).getAccuracy());
                this.score = this.resultTestSeries2.getData().getMarks();
                this.totalQuestion = this.resultTestSeries2.getData().getTotal_questions();
                this.attemptQuestion = String.valueOf(Helper.parseIntSafe(this.resultTestSeries2.getData().getTotal_questions()) - Helper.parseIntSafe(this.resultTestSeries2.getData().getNon_attempt()));
                this.userTestTime = testTimeCalculate(this.resultTestSeries2.getData());
                float floatSafe = Helper.parseFloatSafe(this.resultTestSeries2.getData().getTotal_marks());
                this.userScoreProgressBar.setProgress(floatSafe > 0.0f ? (int) ((Helper.parseFloatSafe(this.score) / floatSafe) * 100.0f) : 0);
                this.topperScoreProgressBar.setProgress(floatSafe > 0.0f ? (int) ((Helper.parseFloatSafe(topper.getBest_score()) / floatSafe) * 100.0f) : 0);
                this.userAccuracyProgressBar.setProgress((int) Helper.parseFloatSafe(this.accuracy));
                this.topperAccuracyProgressBar.setProgress((int) Helper.parseFloatSafe(topper.getAccuracy()));
                int intSafe = Helper.parseIntSafe(this.resultTestSeries2.getData().getTime_in_mins()) * 60;
                float floatSafe2 = Helper.parseFloatSafe(this.totalQuestion);
                this.userAttemptedProgressBar.setProgress(floatSafe2 > 0.0f ? (int) ((Helper.parseFloatSafe(this.attemptQuestion) / floatSafe2) * 100.0f) : 0);
                this.topperAttemptedProgressBar.setProgress(floatSafe2 > 0.0f ? (int) ((Helper.parseFloatSafe(topper.getTotal_attempted()) / floatSafe2) * 100.0f) : 0);
                this.userTimeProgressBar.setProgress(intSafe > 0 ? (int) ((Helper.parseFloatSafe(this.userTestTime) / intSafe) * 100.0f) : 0);
                this.topperTimeProgressBar.setProgress(CalculateTimePercentage(this.resultTestSeries2.getData(), topper));
                setProgressBarGradient(this.userScoreProgressBar);
                setProgressBarGradient(this.userAccuracyProgressBar);
                setProgressBarGradient(this.userAttemptedProgressBar);
                setProgressBarGradient(this.userTimeProgressBar);
                this.topperScoreProgressBar.setProgressTintList(ColorStateList.valueOf(-7829368));
                this.topperAccuracyProgressBar.setProgressTintList(ColorStateList.valueOf(-7829368));
                this.topperAttemptedProgressBar.setProgressTintList(ColorStateList.valueOf(-7829368));
                this.topperTimeProgressBar.setProgressTintList(ColorStateList.valueOf(-7829368));
                this.userTestScoreTv.setText(Html.fromHtml(setDataInTextView(this.score, this.resultTestSeries2.getData().getTotal_marks(), false), 0));
                this.TopperTestScoreTV.setText(Html.fromHtml(setDataInTextView(topper.getBest_score(), this.resultTestSeries2.getData().getTotal_marks(), true), 0));
                this.userTestAccuracyTv.setText(this.accuracy + " %");
                this.TopperTestAccuracyTV.setText(topper.getAccuracy() + " %");
                this.userTestAttemptedTv.setText(Html.fromHtml(setDataInTextView(this.attemptQuestion, this.totalQuestion, false), 0));
                this.TopperTestAttemptedTV.setText(Html.fromHtml(setDataInTextView(topper.getTotal_attempted(), this.totalQuestion, true), 0));
                this.userTestTimeTv.setText(Html.fromHtml(setDataInTextView(getQuestionTime(this.userTestTime), this.resultTestSeries2.getData().getTime_in_mins() + "m", false), 0));
                this.TopperTestTimeTV.setText(Html.fromHtml(setDataInTextView(getQuestionTime(topper.getTime_taken_seconds()), this.resultTestSeries2.getData().getTime_in_mins() + "m", true), 0));
                this.RankNewLL.setVisibility(0);
                this.RankOldLL.setVisibility(8);
            } else {
                this.RankNewLL.setVisibility(8);
                this.rank.setVisibility(8);
                this.RankOldLL.setVisibility(0);
            }
        }
        if (ResultData != null && ResultData.getExpected_rank() != null && ResultData.getExpected_rank().getHide().equalsIgnoreCase("0")) {
            float floatSafe3 = Helper.parseFloatSafe(ResultData.getExpected_rank().getPercentile());
            this.expectedRankRangeTV.setText(ResultData.getExpected_rank().getRank());
            this.tvScore.setText(String.valueOf(floatSafe3));
            this.progressBar.setProgress(100);
            float fMax = Math.max(0.05f, Math.min(floatSafe3 / 100.0f, 0.95f));
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.guideline.getLayoutParams();
            layoutParams.guidePercent = fMax;
            this.guideline.setLayoutParams(layoutParams);
        } else {
            this.rank.setVisibility(8);
        }
        if (ResultData != null && ResultData.getExpected_rank() != null && ResultData.getExpected_rank().getIncrease_marks() != null && !ResultData.getExpected_rank().getIncrease_marks().equalsIgnoreCase("")) {
            this.improvementLL.setVisibility(0);
            this.improvementTV.setText(ResultData.getExpected_rank().getIncrease_marks());
        }
        if (ResultData == null || ResultData.getExpected_rank() == null || ResultData.getExpected_rank().getNotes() == null || ResultData.getExpected_rank().getNotes().equalsIgnoreCase("")) {
            return;
        }
        this.rankPredictionNoteLL.setVisibility(0);
        this.rankPredictionTV.setText(ResultData.getExpected_rank().getNotes());
    }

    private String testTimeCalculate(ResultTestSeries_Report.DataResult data) {
        return String.valueOf((Integer.parseInt(data.getTime_in_mins()) * 60) - Integer.parseInt(data.getTime_remain()));
    }

    private int CalculateTimePercentage(ResultTestSeries_Report.DataResult data, Topper topper) {
        return (int) ((Helper.parseFloatSafe(topper.getTime_taken_seconds()) / (Float.parseFloat(data.getTime_in_mins()) * 60.0f)) * 100.0f);
    }

    private String getQuestionTime(String questionTime) {
        int intSafe = Helper.parseIntSafe(questionTime);
        int i = intSafe / 60;
        int i2 = intSafe % 60;
        return i == 0 ? i2 + " sec" : i + " min " + i2 + " sec";
    }

    private String setDataInTextView(String value1, String value2, boolean topper) {
        int color = ContextCompat.getColor(this.activity, R.color.rank_color);
        int color2 = ContextCompat.getColor(this.activity, R.color.gray_666666);
        String str = String.format("#%06X", Integer.valueOf(ContextCompat.getColor(this.activity, R.color.black) & 16777215));
        String str2 = String.format("#%06X", Integer.valueOf(color2 & 16777215));
        return topper ? "<b><font color='" + str + "'>" + value1 + "</font> / <font color='" + str2 + "'>" + value2 + "</font>" : "<b><font color='" + String.format("#%06X", Integer.valueOf(color & 16777215)) + "'>" + value1 + "</font> / <font color='" + str2 + "'>" + value2 + "</font>";
    }

    public void netoworkCallForQuizResult2() {
        if (Helper.isNetworkConnected(getActivity())) {
            this.mprogress.show();
            APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setUser_id(SharedPreference.getInstance().getLoggedInUser().getId());
            encryptionData.setTest_id(this.status);
            encryptionData.setCourse_id(SharedPreference.getInstance().getString("id"));
            encryptionData.setFirst_attempt(this.first_attempt);
            aPIInterface.getTestResult(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new AnonymousClass1());
            return;
        }
        Toast.makeText(getActivity(), this.activity.getResources().getString(R.string.Retry_with_Internet_connection), 1).show();
    }

    /* JADX INFO: renamed from: com.appnew.android.testmodule.fragment.QuizResultScreenNew$1, reason: invalid class name */
    class AnonymousClass1 implements Callback<String> {
        AnonymousClass1() {
        }

        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:22:0x00e3
            	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
            	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
            	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
            */
        @Override // retrofit2.Callback
        public void onResponse(retrofit2.Call<java.lang.String> r17, retrofit2.Response<java.lang.String> r18) {
            /*
                Method dump skipped, instruction units count: 12276
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.testmodule.fragment.QuizResultScreenNew.AnonymousClass1.onResponse(retrofit2.Call, retrofit2.Response):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(View view) {
            QuizResultScreenNew.this.btnPartC.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartB.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartA.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_active));
            QuizResultScreenNew.this.btnPartD.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartE.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartF.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartG.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartH.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartI.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartJ.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartK.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartL.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartM.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartN.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartO.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(0) != null) {
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(0).getTotalAttempt() != null) {
                    QuizResultScreenNew.this.attemptedTV.setText(QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(0).getTotalAttempt() + MqttTopic.TOPIC_LEVEL_SEPARATOR + QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(0).getNoOfQuestions());
                }
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(0).getAccuracy() != null) {
                    QuizResultScreenNew.this.accuracyTV.setText(QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(0).getAccuracy() + " %");
                }
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(0).getTimeSpent() != null) {
                    QuizResultScreenNew.this.timeTV.setText(Helper.convertSeconds(QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(0).getTimeSpent().intValue()));
                }
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(0).getNoOfQuestions() == null || QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(0).getMarksPerQuestion() == null) {
                    return;
                }
                QuizResultScreenNew quizResultScreenNew = QuizResultScreenNew.this;
                quizResultScreenNew.setScore(quizResultScreenNew.resultTestSeries2, 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(View view) {
            QuizResultScreenNew.this.btnPartC.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartB.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartH.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_active));
            QuizResultScreenNew.this.btnPartD.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartE.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartF.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartG.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartA.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartI.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartJ.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartK.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartL.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartM.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartN.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartO.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(7) != null) {
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(7).getTotalAttempt() != null) {
                    QuizResultScreenNew.this.attemptedTV.setText(QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(7).getTotalAttempt() + MqttTopic.TOPIC_LEVEL_SEPARATOR + QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(7).getNoOfQuestions());
                }
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(7).getAccuracy() != null) {
                    QuizResultScreenNew.this.accuracyTV.setText(QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(7).getAccuracy() + " %");
                }
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(7).getTimeSpent() != null) {
                    QuizResultScreenNew.this.timeTV.setText(Helper.convertSeconds(QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(7).getTimeSpent().intValue()));
                }
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(7).getNoOfQuestions() == null || QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(7).getMarksPerQuestion() == null) {
                    return;
                }
                QuizResultScreenNew quizResultScreenNew = QuizResultScreenNew.this;
                quizResultScreenNew.setScore(quizResultScreenNew.resultTestSeries2, 7);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(View view) {
            QuizResultScreenNew.this.btnPartC.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartB.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartI.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_active));
            QuizResultScreenNew.this.btnPartD.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartE.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartF.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartG.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartA.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartH.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartJ.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartK.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartL.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartM.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartN.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartO.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(8) != null) {
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(8).getTotalAttempt() != null) {
                    QuizResultScreenNew.this.attemptedTV.setText(QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(8).getTotalAttempt() + MqttTopic.TOPIC_LEVEL_SEPARATOR + QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(8).getNoOfQuestions());
                }
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(8).getAccuracy() != null) {
                    QuizResultScreenNew.this.accuracyTV.setText(QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(8).getAccuracy() + " %");
                }
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(8).getTimeSpent() != null) {
                    QuizResultScreenNew.this.timeTV.setText(Helper.convertSeconds(QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(8).getTimeSpent().intValue()));
                }
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(8).getNoOfQuestions() == null || QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(8).getMarksPerQuestion() == null) {
                    return;
                }
                QuizResultScreenNew quizResultScreenNew = QuizResultScreenNew.this;
                quizResultScreenNew.setScore(quizResultScreenNew.resultTestSeries2, 8);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$3(View view) {
            QuizResultScreenNew.this.btnPartC.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartB.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartJ.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_active));
            QuizResultScreenNew.this.btnPartD.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartE.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartF.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartG.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartA.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartH.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartI.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartK.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartL.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartM.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartN.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartO.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(9) != null) {
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(9).getTotalAttempt() != null) {
                    QuizResultScreenNew.this.attemptedTV.setText(QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(9).getTotalAttempt() + MqttTopic.TOPIC_LEVEL_SEPARATOR + QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(9).getNoOfQuestions());
                }
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(9).getAccuracy() != null) {
                    QuizResultScreenNew.this.accuracyTV.setText(QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(9).getAccuracy() + " %");
                }
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(9).getTimeSpent() != null) {
                    QuizResultScreenNew.this.timeTV.setText(Helper.convertSeconds(QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(9).getTimeSpent().intValue()));
                }
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(9).getNoOfQuestions() == null || QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(9).getMarksPerQuestion() == null) {
                    return;
                }
                QuizResultScreenNew quizResultScreenNew = QuizResultScreenNew.this;
                quizResultScreenNew.setScore(quizResultScreenNew.resultTestSeries2, 9);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$4(View view) {
            QuizResultScreenNew.this.btnPartC.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartB.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartK.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_active));
            QuizResultScreenNew.this.btnPartD.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartE.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartF.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartG.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartA.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartH.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartI.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartJ.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartL.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartM.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartN.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartO.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(10) != null) {
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(10).getTotalAttempt() != null) {
                    QuizResultScreenNew.this.attemptedTV.setText(QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(10).getTotalAttempt() + MqttTopic.TOPIC_LEVEL_SEPARATOR + QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(10).getNoOfQuestions());
                }
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(10).getAccuracy() != null) {
                    QuizResultScreenNew.this.accuracyTV.setText(QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(10).getAccuracy() + " %");
                }
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(10).getTimeSpent() != null) {
                    QuizResultScreenNew.this.timeTV.setText(Helper.convertSeconds(QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(10).getTimeSpent().intValue()));
                }
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(10).getNoOfQuestions() == null || QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(10).getMarksPerQuestion() == null) {
                    return;
                }
                QuizResultScreenNew quizResultScreenNew = QuizResultScreenNew.this;
                quizResultScreenNew.setScore(quizResultScreenNew.resultTestSeries2, 10);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$5(View view) {
            QuizResultScreenNew.this.btnPartC.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartB.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartL.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_active));
            QuizResultScreenNew.this.btnPartD.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartE.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartF.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartG.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartA.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartH.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartI.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartJ.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartK.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartM.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartN.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartO.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(11) != null) {
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(11).getTotalAttempt() != null) {
                    QuizResultScreenNew.this.attemptedTV.setText(QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(11).getTotalAttempt() + MqttTopic.TOPIC_LEVEL_SEPARATOR + QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(11).getNoOfQuestions());
                }
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(11).getAccuracy() != null) {
                    QuizResultScreenNew.this.accuracyTV.setText(QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(11).getAccuracy() + " %");
                }
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(11).getTimeSpent() != null) {
                    QuizResultScreenNew.this.timeTV.setText(Helper.convertSeconds(QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(11).getTimeSpent().intValue()));
                }
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(11).getNoOfQuestions() == null || QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(11).getMarksPerQuestion() == null) {
                    return;
                }
                QuizResultScreenNew quizResultScreenNew = QuizResultScreenNew.this;
                quizResultScreenNew.setScore(quizResultScreenNew.resultTestSeries2, 11);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$6(View view) {
            QuizResultScreenNew.this.btnPartC.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartB.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartM.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_active));
            QuizResultScreenNew.this.btnPartD.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartE.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartF.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartG.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartA.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartH.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartI.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartJ.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartL.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartK.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartN.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartO.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(12) != null) {
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(12).getTotalAttempt() != null) {
                    QuizResultScreenNew.this.attemptedTV.setText(QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(12).getTotalAttempt() + MqttTopic.TOPIC_LEVEL_SEPARATOR + QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(12).getNoOfQuestions());
                }
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(12).getAccuracy() != null) {
                    QuizResultScreenNew.this.accuracyTV.setText(QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(12).getAccuracy() + " %");
                }
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(12).getTimeSpent() != null) {
                    QuizResultScreenNew.this.timeTV.setText(Helper.convertSeconds(QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(12).getTimeSpent().intValue()));
                }
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(12).getNoOfQuestions() == null || QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(12).getMarksPerQuestion() == null) {
                    return;
                }
                QuizResultScreenNew quizResultScreenNew = QuizResultScreenNew.this;
                quizResultScreenNew.setScore(quizResultScreenNew.resultTestSeries2, 12);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$7(View view) {
            QuizResultScreenNew.this.btnPartC.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartB.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartN.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_active));
            QuizResultScreenNew.this.btnPartD.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartE.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartF.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartG.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartA.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartH.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartI.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartJ.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartL.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartK.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartM.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartO.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(13) != null) {
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(13).getTotalAttempt() != null) {
                    QuizResultScreenNew.this.attemptedTV.setText(QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(13).getTotalAttempt() + MqttTopic.TOPIC_LEVEL_SEPARATOR + QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(13).getNoOfQuestions());
                }
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(13).getAccuracy() != null) {
                    QuizResultScreenNew.this.accuracyTV.setText(QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(13).getAccuracy() + " %");
                }
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(13).getTimeSpent() != null) {
                    QuizResultScreenNew.this.timeTV.setText(Helper.convertSeconds(QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(13).getTimeSpent().intValue()));
                }
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(13).getNoOfQuestions() == null || QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(13).getMarksPerQuestion() == null) {
                    return;
                }
                QuizResultScreenNew quizResultScreenNew = QuizResultScreenNew.this;
                quizResultScreenNew.setScore(quizResultScreenNew.resultTestSeries2, 13);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$8(View view) {
            QuizResultScreenNew.this.btnPartC.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartB.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartO.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_active));
            QuizResultScreenNew.this.btnPartD.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartE.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartF.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartG.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartA.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartH.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartI.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartJ.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartL.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartK.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartN.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartM.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(14) != null) {
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(14).getTotalAttempt() != null) {
                    QuizResultScreenNew.this.attemptedTV.setText(QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(14).getTotalAttempt() + MqttTopic.TOPIC_LEVEL_SEPARATOR + QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(14).getNoOfQuestions());
                }
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(14).getAccuracy() != null) {
                    QuizResultScreenNew.this.accuracyTV.setText(QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(14).getAccuracy() + " %");
                }
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(14).getTimeSpent() != null) {
                    QuizResultScreenNew.this.timeTV.setText(Helper.convertSeconds(QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(14).getTimeSpent().intValue()));
                }
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(14).getNoOfQuestions() == null || QuizResultScreenNew.this.resultTestSeries2.getData().getTest_sections().get(14).getMarksPerQuestion() == null) {
                    return;
                }
                QuizResultScreenNew quizResultScreenNew = QuizResultScreenNew.this;
                quizResultScreenNew.setScore(quizResultScreenNew.resultTestSeries2, 14);
            }
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<String> call, Throwable t) {
            QuizResultScreenNew.this.mprogress.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScore(ResultTestSeries_Report resultTestSeries2, int i) {
        if (resultTestSeries2.getData().getTest_sections().get(i).getMandatory_question() != null && !resultTestSeries2.getData().getTest_sections().get(i).getMandatory_question().equalsIgnoreCase("0")) {
            if (resultTestSeries2.getData().getTest_sections().get(i).getOptional_question() != null) {
                this.scoreTV.setText(resultTestSeries2.getData().getTest_sections().get(i).getUserMarks() + MqttTopic.TOPIC_LEVEL_SEPARATOR + String.format("%.2f", Float.valueOf((Float.parseFloat(resultTestSeries2.getData().getTest_sections().get(i).getMandatory_question()) + Float.parseFloat(resultTestSeries2.getData().getTest_sections().get(i).getOptional_question())) * Float.parseFloat(resultTestSeries2.getData().getTest_sections().get(i).getMarksPerQuestion()))));
                return;
            }
            return;
        }
        if (resultTestSeries2.getData().getTest_sections().get(i).getSection_max_mark() != null) {
            this.scoreTV.setText(resultTestSeries2.getData().getTest_sections().get(i).getUserMarks() + MqttTopic.TOPIC_LEVEL_SEPARATOR + String.format("%.2f", Float.valueOf(Float.parseFloat(resultTestSeries2.getData().getTest_sections().get(i).getSection_max_mark()))));
        }
    }

    public void netoworkCallForQuizReport() {
        if (Helper.isNetworkConnected(getActivity())) {
            this.mprogress.show();
            APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setUser_id(SharedPreference.getInstance().getLoggedInUser().getId());
            encryptionData.setTest_series_id(this.status);
            encryptionData.setCourse_id(SharedPreference.getInstance().getString("id"));
            aPIInterface.getTestReport(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new AnonymousClass2());
            return;
        }
        Toast.makeText(getActivity(), this.activity.getResources().getString(R.string.Retry_with_Internet_connection), 1).show();
    }

    /* JADX INFO: renamed from: com.appnew.android.testmodule.fragment.QuizResultScreenNew$2, reason: invalid class name */
    class AnonymousClass2 implements Callback<String> {
        AnonymousClass2() {
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<String> call, Response<String> response) {
            JSONObject jSONObject;
            QuizResultScreenNew.this.mprogress.dismiss();
            if (response.body() != null) {
                try {
                    jSONObject = new JSONObject(AES.decrypt(response.body(), AES.generatekeyAPI(), AES.generateVectorAPI()));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    jSONObject = null;
                }
                if (jSONObject == null) {
                    Log.d("Security_Toast", "due to api response null ");
                    Helper.showToastSecurity(QuizResultScreenNew.this.activity);
                    return;
                }
                if (jSONObject.optBoolean("status")) {
                    QuizResultScreenNew.this.no_data_found_RL.setVisibility(8);
                    QuizResultScreenNew.this.testReport = (TestReport) new Gson().fromJson(jSONObject.toString(), TestReport.class);
                    if (QuizResultScreenNew.this.testReport == null) {
                        Log.d("Security_Toast", "due to testreport null ");
                        Helper.showToastSecurity(QuizResultScreenNew.this.activity);
                        return;
                    }
                    if (!QuizResultScreenNew.this.testReport.getData().getHideRank().equalsIgnoreCase("1")) {
                        QuizResultScreenNew quizResultScreenNew = QuizResultScreenNew.this;
                        quizResultScreenNew.leaderBoardsList = quizResultScreenNew.testReport.getData().getLeaderBoard();
                        if (QuizResultScreenNew.this.leaderBoardsList != null && QuizResultScreenNew.this.leaderBoardsList.size() > 0) {
                            QuizResultScreenNew.this.leaderboard_text.setVisibility(0);
                            QuizResultScreenNew.this.leaderboard_ll.setVisibility(0);
                            QuizResultScreenNew.this.leaderBoardAdapter = new LeaderBoardAdapter(QuizResultScreenNew.this.activity, QuizResultScreenNew.this.leaderBoardsList);
                            QuizResultScreenNew.this.recyclerviewrank.setAdapter(QuizResultScreenNew.this.leaderBoardAdapter);
                        } else {
                            QuizResultScreenNew.this.leaderboard_text.setVisibility(8);
                            QuizResultScreenNew.this.recyclerviewrank.setVisibility(8);
                            QuizResultScreenNew.this.leaderboard_ll.setVisibility(8);
                        }
                    } else {
                        QuizResultScreenNew.this.leaderboard_text.setVisibility(8);
                        QuizResultScreenNew.this.recyclerviewrank.setVisibility(8);
                        QuizResultScreenNew.this.leaderboard_ll.setVisibility(8);
                    }
                    if (QuizResultScreenNew.this.testReport.getData().getHideRank().equalsIgnoreCase("1")) {
                        QuizResultScreenNew.this.rankRL.setVisibility(8);
                        QuizResultScreenNew.this.subjectRankRl.setVisibility(8);
                    }
                    try {
                        MakeMyExam.setTime_server(Long.parseLong(jSONObject.optString("time")) * 1000);
                        if (QuizResultScreenNew.this.testReport.getStatus()) {
                            QuizResultScreenNew.this.resultCorrectTV_1.setText(QuizResultScreenNew.this.testReport.getData().getCorrectCount());
                            QuizResultScreenNew.this.resultIncorrectTV_1.setText(QuizResultScreenNew.this.testReport.getData().getIncorrectCount());
                            QuizResultScreenNew.this.resultAttemptTV_1.setText(QuizResultScreenNew.this.testReport.getData().getAttempted());
                            QuizResultScreenNew.this.resultUnAttemptTV_1.setText(QuizResultScreenNew.this.testReport.getData().getNonAttempt());
                            if (QuizResultScreenNew.this.testReport.getData().getOmrUrl() != null && !QuizResultScreenNew.this.testReport.getData().getOmrUrl().equalsIgnoreCase("")) {
                                QuizResultScreenNew.this.viewOMRLl.setVisibility(0);
                            } else {
                                QuizResultScreenNew.this.viewOMRLl.setVisibility(8);
                            }
                            if (QuizResultScreenNew.this.testReport.getData().getQuestion_pdf() != null && !QuizResultScreenNew.this.testReport.getData().getQuestion_pdf().equalsIgnoreCase("")) {
                                QuizResultScreenNew.this.viewOfflineTest.setVisibility(0);
                            } else {
                                QuizResultScreenNew.this.viewOfflineTest.setVisibility(8);
                            }
                            QuizResultScreenNew.this.viewOMRLl.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.fragment.QuizResultScreenNew.2.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    Intent intent = new Intent(QuizResultScreenNew.this.activity, (Class<?>) PdfDetailScreen.class);
                                    intent.putExtra("title", QuizResultScreenNew.this.testReport.getData().getId());
                                    intent.putExtra("pdf_name", "OMR");
                                    intent.putExtra("course_id", "");
                                    intent.putExtra("download_file", false);
                                    intent.putExtra(Const.IS_DOWNLOAD, true);
                                    intent.putExtra("url", QuizResultScreenNew.this.testReport.getData().getOmrUrl());
                                    QuizResultScreenNew.this.activity.startActivity(intent);
                                }
                            });
                            QuizResultScreenNew.this.viewOfflineTest.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.fragment.QuizResultScreenNew.2.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    Intent intent = new Intent(QuizResultScreenNew.this.activity, (Class<?>) PdfDetailScreen.class);
                                    intent.putExtra("title", QuizResultScreenNew.this.testReport.getData().getId());
                                    intent.putExtra("pdf_name", Const.SOLUTION);
                                    intent.putExtra("course_id", "");
                                    intent.putExtra("download_file", false);
                                    if (QuizResultScreenNew.this.testReport.getData().getDownloadPdf().equalsIgnoreCase("0")) {
                                        intent.putExtra(Const.IS_DOWNLOAD, false);
                                    } else {
                                        intent.putExtra(Const.IS_DOWNLOAD, true);
                                    }
                                    intent.putExtra("url", QuizResultScreenNew.this.testReport.getData().getQuestion_pdf());
                                    QuizResultScreenNew.this.activity.startActivity(intent);
                                }
                            });
                            if (QuizResultScreenNew.this.testReport.getData().getRank() != null && !QuizResultScreenNew.this.testReport.getData().getRank().equalsIgnoreCase("")) {
                                if (QuizResultScreenNew.this.testReport.getData().getAttempted().equalsIgnoreCase("")) {
                                    QuizResultScreenNew.this.resultRankTV.setText(QuizResultScreenNew.this.testReport.getData().getRank());
                                } else {
                                    QuizResultScreenNew.this.resultRankTV.setText(QuizResultScreenNew.this.testReport.getData().getRank());
                                }
                            } else {
                                QuizResultScreenNew.this.resultRankTV.setText(QuizResultScreenNew.this.activity.getResources().getString(R.string.n_a));
                            }
                            QuizResultScreenNew.this.resultScoreTV.setText(QuizResultScreenNew.this.testReport.getData().getMarks() + MqttTopic.TOPIC_LEVEL_SEPARATOR + QuizResultScreenNew.this.testReport.getData().getTestSeriesMarks());
                            if (QuizResultScreenNew.this.testReport.getData().getTotalTestSeriesTime() != null || QuizResultScreenNew.this.testReport.getData().getTimeRemain() != null) {
                                QuizResultScreenNew.this.resultTimeDuration.setText(String.valueOf(Integer.parseInt(QuizResultScreenNew.this.testReport.getData().getTotalTestSeriesTime()) - Integer.parseInt(QuizResultScreenNew.this.testReport.getData().getTimeRemain())) + " Mins");
                            }
                            if (QuizResultScreenNew.this.testReport.getData().getPercentile() != null && !QuizResultScreenNew.this.testReport.getData().getPercentile().equalsIgnoreCase("")) {
                                QuizResultScreenNew.this.resultAccuracyTV.setText(QuizResultScreenNew.this.testReport.getData().getPercentile());
                            }
                            if (QuizResultScreenNew.this.testReport.getData().getResult() != null && !QuizResultScreenNew.this.testReport.getData().getResult().equalsIgnoreCase("")) {
                                QuizResultScreenNew.this.resultPercentileTV.setText(QuizResultScreenNew.this.testReport.getData().getResult());
                            }
                            if (QuizResultScreenNew.this.testReport.getData().getAttempted() != null && QuizResultScreenNew.this.testReport.getData().getAttempted() != null) {
                                QuizResultScreenNew.this.resultAttemptedTV.setText(QuizResultScreenNew.this.testReport.getData().getAttempted());
                            }
                            QuizResultScreenNew.this.tv_max_score_hint.setText("Max. Marks");
                            QuizResultScreenNew.this.tv_score_hint.setText("Avg. Marks");
                            if (QuizResultScreenNew.this.testReport.getData().getTestSeriesMarks() != null) {
                                QuizResultScreenNew.this.resultBestScoreTV.setText(QuizResultScreenNew.this.testReport.getData().getTestSeriesMarks());
                            }
                            if (QuizResultScreenNew.this.testReport.getData().getAvgMark() != null) {
                                QuizResultScreenNew.this.resultAvgScoreTV.setText(QuizResultScreenNew.this.testReport.getData().getAvgMark());
                            }
                            QuizResultScreenNew.this.btnPartA.setVisibility(8);
                            QuizResultScreenNew.this.btnPartB.setVisibility(8);
                            QuizResultScreenNew.this.btnPartC.setVisibility(8);
                            QuizResultScreenNew.this.btnPartD.setVisibility(8);
                            QuizResultScreenNew.this.btnPartE.setVisibility(8);
                            QuizResultScreenNew.this.btnPartF.setVisibility(8);
                            QuizResultScreenNew.this.btnPartG.setVisibility(8);
                            QuizResultScreenNew.this.btnPartH.setVisibility(8);
                            QuizResultScreenNew.this.btnPartI.setVisibility(8);
                            QuizResultScreenNew.this.btnPartJ.setVisibility(8);
                            QuizResultScreenNew.this.btnPartK.setVisibility(8);
                            QuizResultScreenNew.this.btnPartL.setVisibility(8);
                            QuizResultScreenNew.this.btnPartM.setVisibility(8);
                            QuizResultScreenNew.this.btnPartN.setVisibility(8);
                            QuizResultScreenNew.this.btnPartO.setVisibility(8);
                            QuizResultScreenNew.this.SubjectDetailsLL.setVisibility(8);
                            QuizResultScreenNew.this.answerListRV.setVisibility(8);
                            QuizResultScreenNew.this.ll_test_taken_time.setVisibility(8);
                            QuizResultScreenNew.this.ll_acuracy.setVisibility(8);
                            QuizResultScreenNew.this.OverAllDurationLL.setVisibility(8);
                            QuizResultScreenNew.this.scoreLL.setVisibility(0);
                            QuizResultScreenNew.this.resultNameTV.setVisibility(8);
                            QuizResultScreenNew.this.totalAttemptedLL.setVisibility(8);
                            QuizResultScreenNew.this.subjectScoreTimeLL.setVisibility(8);
                            if (QuizResultScreenNew.this.testReport.getData().getSubject().size() == 0) {
                                QuizResultScreenNew.this.llNewTest.setVisibility(8);
                            }
                            for (int i = 0; i < QuizResultScreenNew.this.testReport.getData().getSubject().size() + 1; i++) {
                                switch (i) {
                                    case 0:
                                        QuizResultScreenNew.this.btnPartA.setText("Overall");
                                        QuizResultScreenNew.this.btnPartA.setVisibility(0);
                                        QuizResultScreenNew.this.SubjectDetailsLL.setVisibility(8);
                                        if (QuizResultScreenNew.this.testReport.getData() != null) {
                                            if (QuizResultScreenNew.this.testReport.getData().getAttempted() != null) {
                                                QuizResultScreenNew.this.attemptedTV.setText(QuizResultScreenNew.this.testReport.getData().getAttempted());
                                            }
                                            QuizResultScreenNew.this.resultAttemptTV.setText(QuizResultScreenNew.this.testReport.getData().getAttempted());
                                            if (QuizResultScreenNew.this.testReport.getData().getCorrectCount() != null) {
                                                QuizResultScreenNew.this.resultCorrectTV.setText(QuizResultScreenNew.this.testReport.getData().getCorrectCount());
                                            }
                                            if (QuizResultScreenNew.this.testReport.getData().getIncorrectCount() != null) {
                                                QuizResultScreenNew.this.resultIncorrectTV.setText(QuizResultScreenNew.this.testReport.getData().getIncorrectCount());
                                            }
                                            if (QuizResultScreenNew.this.testReport.getData().getNonAttempt() != null) {
                                                QuizResultScreenNew.this.resultUnAttemptTV.setText(QuizResultScreenNew.this.testReport.getData().getNonAttempt());
                                            }
                                        }
                                        QuizResultScreenNew.this.btnPartA.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.fragment.QuizResultScreenNew$2$$ExternalSyntheticLambda0
                                            @Override // android.view.View.OnClickListener
                                            public final void onClick(View view) {
                                                this.f$0.lambda$onResponse$0(view);
                                            }
                                        });
                                        break;
                                    case 1:
                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(0) != null) {
                                            QuizResultScreenNew.this.btnPartB.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(0).getSubject());
                                            QuizResultScreenNew.this.btnPartB.setVisibility(0);
                                            QuizResultScreenNew.this.btnPartB.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.fragment.QuizResultScreenNew.2.3
                                                @Override // android.view.View.OnClickListener
                                                public void onClick(View v) {
                                                    QuizResultScreenNew.this.btnPartA.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartC.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartB.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_active));
                                                    QuizResultScreenNew.this.btnPartD.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartE.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartF.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartG.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartH.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartI.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartJ.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartK.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartL.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartM.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartN.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartO.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.SubjectDetailsLL.setVisibility(0);
                                                    if (QuizResultScreenNew.this.testReport.getData().getSubject().get(0).getMarks() != null) {
                                                        QuizResultScreenNew.this.scoreTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(0).getMarks());
                                                    }
                                                    if (QuizResultScreenNew.this.testReport.getData().getSubject().get(0) != null) {
                                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(0).getAttempted() != null) {
                                                            QuizResultScreenNew.this.attemptedTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(0).getAttempted());
                                                        }
                                                        QuizResultScreenNew.this.resultAttemptTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(0).getAttempted());
                                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(0).getCorrectCount() != null) {
                                                            QuizResultScreenNew.this.resultCorrectTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(0).getCorrectCount());
                                                        }
                                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(0).getIncorrectCount() != null) {
                                                            QuizResultScreenNew.this.resultIncorrectTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(0).getIncorrectCount());
                                                        }
                                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(0).getNonAttempt() != null) {
                                                            QuizResultScreenNew.this.resultUnAttemptTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(0).getNonAttempt());
                                                        }
                                                        QuizResultScreenNew.this.subPercentileTV_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(0).getMarks());
                                                        QuizResultScreenNew.this.ranks_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(0).getRank());
                                                        QuizResultScreenNew.this.percentileTV_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(0).getPercentile());
                                                        QuizResultScreenNew.this.percent.setText("%: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(0).getPercentage());
                                                        QuizResultScreenNew.this.maxMarks.setText("MM: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(0).getMaxMark());
                                                        QuizResultScreenNew.this.AvgScore.setText("AM: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(0).getAvgMark());
                                                    }
                                                    QuizResultScreenNew.this.leaderBoardsSubjectList = QuizResultScreenNew.this.testReport.getData().getSubject().get(0).getLeaderBoard();
                                                    QuizResultScreenNew.this.setSubjectListAdapter(QuizResultScreenNew.this.leaderBoardsSubjectList);
                                                }
                                            });
                                        }
                                        break;
                                    case 2:
                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(1) != null) {
                                            QuizResultScreenNew.this.btnPartC.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(1).getSubject());
                                            QuizResultScreenNew.this.btnPartC.setVisibility(0);
                                            QuizResultScreenNew.this.btnPartC.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.fragment.QuizResultScreenNew.2.4
                                                @Override // android.view.View.OnClickListener
                                                public void onClick(View v) {
                                                    QuizResultScreenNew.this.btnPartA.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartB.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartC.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_active));
                                                    QuizResultScreenNew.this.btnPartD.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartE.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartF.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartH.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartI.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartJ.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartK.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartL.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartM.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartN.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartO.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartG.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.SubjectDetailsLL.setVisibility(0);
                                                    if (QuizResultScreenNew.this.testReport.getData().getSubject().get(1).getMarks() != null) {
                                                        QuizResultScreenNew.this.scoreTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(1).getMarks());
                                                    }
                                                    if (QuizResultScreenNew.this.testReport.getData().getSubject().get(1) != null) {
                                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(1).getAttempted() != null) {
                                                            QuizResultScreenNew.this.attemptedTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(1).getAttempted());
                                                        }
                                                        QuizResultScreenNew.this.resultAttemptTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(1).getAttempted());
                                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(1).getCorrectCount() != null) {
                                                            QuizResultScreenNew.this.resultCorrectTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(1).getCorrectCount());
                                                        }
                                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(1).getIncorrectCount() != null) {
                                                            QuizResultScreenNew.this.resultIncorrectTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(1).getIncorrectCount());
                                                        }
                                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(1).getNonAttempt() != null) {
                                                            QuizResultScreenNew.this.resultUnAttemptTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(1).getNonAttempt());
                                                        }
                                                        QuizResultScreenNew.this.subPercentileTV_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(1).getMarks());
                                                        QuizResultScreenNew.this.ranks_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(1).getRank());
                                                        QuizResultScreenNew.this.percentileTV_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(1).getPercentile());
                                                        QuizResultScreenNew.this.percent.setText("%: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(1).getPercentage());
                                                        QuizResultScreenNew.this.maxMarks.setText("MM: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(1).getMaxMark());
                                                        QuizResultScreenNew.this.AvgScore.setText("AM: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(1).getAvgMark());
                                                        QuizResultScreenNew.this.leaderBoardsSubjectList = QuizResultScreenNew.this.testReport.getData().getSubject().get(1).getLeaderBoard();
                                                        QuizResultScreenNew.this.setSubjectListAdapter(QuizResultScreenNew.this.leaderBoardsSubjectList);
                                                    }
                                                }
                                            });
                                        }
                                        break;
                                    case 3:
                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(2) != null) {
                                            QuizResultScreenNew.this.btnPartD.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(2).getSubject());
                                            QuizResultScreenNew.this.btnPartD.setVisibility(0);
                                            QuizResultScreenNew.this.btnPartD.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.fragment.QuizResultScreenNew.2.5
                                                @Override // android.view.View.OnClickListener
                                                public void onClick(View v) {
                                                    QuizResultScreenNew.this.btnPartA.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartB.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartC.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartD.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_active));
                                                    QuizResultScreenNew.this.btnPartE.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartF.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartH.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartI.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartJ.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartK.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartL.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartM.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartN.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartO.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartG.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.SubjectDetailsLL.setVisibility(0);
                                                    if (QuizResultScreenNew.this.testReport.getData().getSubject().get(2).getMarks() != null) {
                                                        QuizResultScreenNew.this.scoreTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(2).getMarks());
                                                    }
                                                    if (QuizResultScreenNew.this.testReport.getData().getSubject().get(2) != null) {
                                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(2).getAttempted() != null) {
                                                            QuizResultScreenNew.this.attemptedTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(2).getAttempted());
                                                        }
                                                        QuizResultScreenNew.this.resultAttemptTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(2).getAttempted());
                                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(2).getCorrectCount() != null) {
                                                            QuizResultScreenNew.this.resultCorrectTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(2).getCorrectCount());
                                                        }
                                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(2).getIncorrectCount() != null) {
                                                            QuizResultScreenNew.this.resultIncorrectTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(2).getIncorrectCount());
                                                        }
                                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(2).getNonAttempt() != null) {
                                                            QuizResultScreenNew.this.resultUnAttemptTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(2).getNonAttempt());
                                                        }
                                                        QuizResultScreenNew.this.subPercentileTV_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(2).getMarks());
                                                        QuizResultScreenNew.this.ranks_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(2).getRank());
                                                        QuizResultScreenNew.this.percentileTV_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(2).getPercentile());
                                                        QuizResultScreenNew.this.percent.setText("%: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(2).getPercentage());
                                                        QuizResultScreenNew.this.maxMarks.setText("MM: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(2).getMaxMark());
                                                        QuizResultScreenNew.this.AvgScore.setText("AM: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(2).getAvgMark());
                                                        QuizResultScreenNew.this.leaderBoardsSubjectList = QuizResultScreenNew.this.testReport.getData().getSubject().get(2).getLeaderBoard();
                                                        QuizResultScreenNew.this.setSubjectListAdapter(QuizResultScreenNew.this.leaderBoardsSubjectList);
                                                    }
                                                }
                                            });
                                        }
                                        break;
                                    case 4:
                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(3) != null) {
                                            QuizResultScreenNew.this.btnPartE.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(3).getSubject());
                                            QuizResultScreenNew.this.btnPartE.setVisibility(0);
                                            QuizResultScreenNew.this.btnPartE.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.fragment.QuizResultScreenNew.2.6
                                                @Override // android.view.View.OnClickListener
                                                public void onClick(View v) {
                                                    QuizResultScreenNew.this.btnPartA.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartB.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartC.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartD.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartE.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_active));
                                                    QuizResultScreenNew.this.btnPartF.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartH.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartI.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartJ.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartK.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartL.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartM.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartN.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartO.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartG.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.SubjectDetailsLL.setVisibility(0);
                                                    if (QuizResultScreenNew.this.testReport.getData().getSubject().get(3).getMarks() != null) {
                                                        QuizResultScreenNew.this.scoreTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(3).getMarks());
                                                    }
                                                    if (QuizResultScreenNew.this.testReport.getData().getSubject().get(3) != null) {
                                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(3).getAttempted() != null) {
                                                            QuizResultScreenNew.this.attemptedTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(3).getAttempted());
                                                        }
                                                        QuizResultScreenNew.this.resultAttemptTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(3).getAttempted());
                                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(3).getCorrectCount() != null) {
                                                            QuizResultScreenNew.this.resultCorrectTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(3).getCorrectCount());
                                                        }
                                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(3).getIncorrectCount() != null) {
                                                            QuizResultScreenNew.this.resultIncorrectTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(3).getIncorrectCount());
                                                        }
                                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(3).getNonAttempt() != null) {
                                                            QuizResultScreenNew.this.resultUnAttemptTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(3).getNonAttempt());
                                                        }
                                                        QuizResultScreenNew.this.subPercentileTV_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(3).getMarks());
                                                        QuizResultScreenNew.this.ranks_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(3).getRank());
                                                        QuizResultScreenNew.this.percentileTV_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(3).getPercentile());
                                                        QuizResultScreenNew.this.percent.setText("%: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(3).getPercentage());
                                                        QuizResultScreenNew.this.maxMarks.setText("MM: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(3).getMaxMark());
                                                        QuizResultScreenNew.this.AvgScore.setText("AM: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(3).getAvgMark());
                                                        QuizResultScreenNew.this.leaderBoardsSubjectList = QuizResultScreenNew.this.testReport.getData().getSubject().get(3).getLeaderBoard();
                                                        QuizResultScreenNew.this.setSubjectListAdapter(QuizResultScreenNew.this.leaderBoardsSubjectList);
                                                    }
                                                }
                                            });
                                        }
                                        break;
                                    case 5:
                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(4) != null) {
                                            QuizResultScreenNew.this.btnPartF.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(4).getSubject());
                                            QuizResultScreenNew.this.btnPartF.setVisibility(0);
                                            QuizResultScreenNew.this.btnPartF.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.fragment.QuizResultScreenNew.2.7
                                                @Override // android.view.View.OnClickListener
                                                public void onClick(View v) {
                                                    QuizResultScreenNew.this.btnPartA.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartB.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartC.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartD.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartE.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartF.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_active));
                                                    QuizResultScreenNew.this.btnPartH.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartI.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartJ.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartK.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartL.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartM.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartN.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartO.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartG.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.SubjectDetailsLL.setVisibility(0);
                                                    if (QuizResultScreenNew.this.testReport.getData().getSubject().get(4).getMarks() != null) {
                                                        QuizResultScreenNew.this.scoreTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(4).getMarks());
                                                    }
                                                    if (QuizResultScreenNew.this.testReport.getData().getSubject().get(4) != null) {
                                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(4).getAttempted() != null) {
                                                            QuizResultScreenNew.this.attemptedTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(4).getAttempted());
                                                        }
                                                        QuizResultScreenNew.this.resultAttemptTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(4).getAttempted());
                                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(4).getCorrectCount() != null) {
                                                            QuizResultScreenNew.this.resultCorrectTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(4).getCorrectCount());
                                                        }
                                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(4).getIncorrectCount() != null) {
                                                            QuizResultScreenNew.this.resultIncorrectTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(4).getIncorrectCount());
                                                        }
                                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(4).getNonAttempt() != null) {
                                                            QuizResultScreenNew.this.resultUnAttemptTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(4).getNonAttempt());
                                                        }
                                                        QuizResultScreenNew.this.subPercentileTV_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(4).getMarks());
                                                        QuizResultScreenNew.this.ranks_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(4).getRank());
                                                        QuizResultScreenNew.this.percentileTV_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(4).getPercentile());
                                                        QuizResultScreenNew.this.percent.setText("%: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(4).getPercentage());
                                                        QuizResultScreenNew.this.maxMarks.setText("MM: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(4).getMaxMark());
                                                        QuizResultScreenNew.this.AvgScore.setText("AM: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(4).getAvgMark());
                                                        QuizResultScreenNew.this.leaderBoardsSubjectList = QuizResultScreenNew.this.testReport.getData().getSubject().get(4).getLeaderBoard();
                                                        QuizResultScreenNew.this.setSubjectListAdapter(QuizResultScreenNew.this.leaderBoardsSubjectList);
                                                    }
                                                }
                                            });
                                        }
                                        break;
                                    case 6:
                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(5) != null) {
                                            QuizResultScreenNew.this.btnPartG.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(5).getSubject());
                                            QuizResultScreenNew.this.btnPartG.setVisibility(0);
                                            QuizResultScreenNew.this.btnPartG.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.fragment.QuizResultScreenNew.2.8
                                                @Override // android.view.View.OnClickListener
                                                public void onClick(View v) {
                                                    QuizResultScreenNew.this.btnPartA.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartB.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartC.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartD.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartE.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartF.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartH.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartI.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartJ.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartK.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartL.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartM.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartN.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartO.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
                                                    QuizResultScreenNew.this.btnPartG.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_active));
                                                    QuizResultScreenNew.this.SubjectDetailsLL.setVisibility(0);
                                                    if (QuizResultScreenNew.this.testReport.getData().getSubject().get(5).getMarks() != null) {
                                                        QuizResultScreenNew.this.scoreTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(5).getMarks());
                                                    }
                                                    if (QuizResultScreenNew.this.testReport.getData().getSubject().get(5) != null) {
                                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(5).getAttempted() != null) {
                                                            QuizResultScreenNew.this.attemptedTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(5).getAttempted());
                                                        }
                                                        QuizResultScreenNew.this.resultAttemptTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(5).getAttempted());
                                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(5).getCorrectCount() != null) {
                                                            QuizResultScreenNew.this.resultCorrectTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(5).getCorrectCount());
                                                        }
                                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(5).getIncorrectCount() != null) {
                                                            QuizResultScreenNew.this.resultIncorrectTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(5).getIncorrectCount());
                                                        }
                                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(5).getNonAttempt() != null) {
                                                            QuizResultScreenNew.this.resultUnAttemptTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(5).getNonAttempt());
                                                        }
                                                        QuizResultScreenNew.this.subPercentileTV_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(5).getMarks());
                                                        QuizResultScreenNew.this.ranks_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(5).getRank());
                                                        QuizResultScreenNew.this.percentileTV_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(5).getPercentile());
                                                        QuizResultScreenNew.this.percent.setText("%: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(5).getPercentage());
                                                        QuizResultScreenNew.this.maxMarks.setText("MM: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(5).getMaxMark());
                                                        QuizResultScreenNew.this.AvgScore.setText("AM: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(5).getAvgMark());
                                                        QuizResultScreenNew.this.leaderBoardsSubjectList = QuizResultScreenNew.this.testReport.getData().getSubject().get(5).getLeaderBoard();
                                                        QuizResultScreenNew.this.setSubjectListAdapter(QuizResultScreenNew.this.leaderBoardsSubjectList);
                                                    }
                                                }
                                            });
                                        }
                                        break;
                                    case 7:
                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(6) != null) {
                                            QuizResultScreenNew.this.btnPartH.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(6).getSubject());
                                            QuizResultScreenNew.this.btnPartH.setVisibility(0);
                                            QuizResultScreenNew.this.btnPartH.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.fragment.QuizResultScreenNew$2$$ExternalSyntheticLambda1
                                                @Override // android.view.View.OnClickListener
                                                public final void onClick(View view) {
                                                    this.f$0.lambda$onResponse$1(view);
                                                }
                                            });
                                        }
                                        break;
                                    case 8:
                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(7) != null) {
                                            QuizResultScreenNew.this.btnPartI.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(7).getSubject());
                                            QuizResultScreenNew.this.btnPartI.setVisibility(0);
                                            QuizResultScreenNew.this.btnPartI.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.fragment.QuizResultScreenNew$2$$ExternalSyntheticLambda2
                                                @Override // android.view.View.OnClickListener
                                                public final void onClick(View view) {
                                                    this.f$0.lambda$onResponse$2(view);
                                                }
                                            });
                                        }
                                        break;
                                    case 9:
                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(8) != null) {
                                            QuizResultScreenNew.this.btnPartJ.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(8).getSubject());
                                            QuizResultScreenNew.this.btnPartJ.setVisibility(0);
                                            QuizResultScreenNew.this.btnPartJ.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.fragment.QuizResultScreenNew$2$$ExternalSyntheticLambda3
                                                @Override // android.view.View.OnClickListener
                                                public final void onClick(View view) {
                                                    this.f$0.lambda$onResponse$3(view);
                                                }
                                            });
                                        }
                                        break;
                                    case 10:
                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(9) != null) {
                                            QuizResultScreenNew.this.btnPartK.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(9).getSubject());
                                            QuizResultScreenNew.this.btnPartK.setVisibility(0);
                                            QuizResultScreenNew.this.btnPartK.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.fragment.QuizResultScreenNew$2$$ExternalSyntheticLambda4
                                                @Override // android.view.View.OnClickListener
                                                public final void onClick(View view) {
                                                    this.f$0.lambda$onResponse$4(view);
                                                }
                                            });
                                        }
                                        break;
                                    case 11:
                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(10) != null) {
                                            QuizResultScreenNew.this.btnPartL.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(10).getSubject());
                                            QuizResultScreenNew.this.btnPartL.setVisibility(0);
                                            QuizResultScreenNew.this.btnPartL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.fragment.QuizResultScreenNew$2$$ExternalSyntheticLambda5
                                                @Override // android.view.View.OnClickListener
                                                public final void onClick(View view) {
                                                    this.f$0.lambda$onResponse$5(view);
                                                }
                                            });
                                        }
                                        break;
                                    case 12:
                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(11) != null) {
                                            QuizResultScreenNew.this.btnPartM.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(11).getSubject());
                                            QuizResultScreenNew.this.btnPartM.setVisibility(0);
                                            QuizResultScreenNew.this.btnPartM.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.fragment.QuizResultScreenNew$2$$ExternalSyntheticLambda6
                                                @Override // android.view.View.OnClickListener
                                                public final void onClick(View view) {
                                                    this.f$0.lambda$onResponse$6(view);
                                                }
                                            });
                                        }
                                        break;
                                    case 13:
                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(12) != null) {
                                            QuizResultScreenNew.this.btnPartN.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(12).getSubject());
                                            QuizResultScreenNew.this.btnPartN.setVisibility(0);
                                            QuizResultScreenNew.this.btnPartN.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.fragment.QuizResultScreenNew$2$$ExternalSyntheticLambda7
                                                @Override // android.view.View.OnClickListener
                                                public final void onClick(View view) {
                                                    this.f$0.lambda$onResponse$7(view);
                                                }
                                            });
                                        }
                                        break;
                                    case 14:
                                        if (QuizResultScreenNew.this.testReport.getData().getSubject().get(13) != null) {
                                            QuizResultScreenNew.this.btnPartO.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(13).getSubject());
                                            QuizResultScreenNew.this.btnPartO.setVisibility(0);
                                            QuizResultScreenNew.this.btnPartO.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.fragment.QuizResultScreenNew$2$$ExternalSyntheticLambda8
                                                @Override // android.view.View.OnClickListener
                                                public final void onClick(View view) {
                                                    this.f$0.lambda$onResponse$8(view);
                                                }
                                            });
                                        }
                                        break;
                                }
                            }
                            QuizResultScreenNew.this.ll_not_qualified.setVisibility(8);
                            QuizResultScreenNew.this.resultDeclaredLL.setVisibility(0);
                            return;
                        }
                        QuizResultScreenNew.this.mprogress.dismiss();
                        if (GenericUtils.isEmpty(jSONObject.getString("auth_code"))) {
                            return;
                        }
                        RetrofitResponse.GetApiData(QuizResultScreenNew.this.getContext(), jSONObject.has("auth_code") ? jSONObject.getString("auth_code") : "", jSONObject.getString("message"), false);
                        return;
                    } catch (Exception e3) {
                        QuizResultScreenNew.this.no_data_found_RL.setVisibility(0);
                        Helper.logPrinter("", "e", e3.getLocalizedMessage(), "");
                        e3.printStackTrace();
                        return;
                    }
                }
                QuizResultScreenNew.this.no_data_found_RL.setVisibility(0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(View view) {
            QuizResultScreenNew.this.btnPartC.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartB.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartA.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_active));
            QuizResultScreenNew.this.btnPartD.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartE.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartF.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartG.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartH.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartI.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartJ.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartK.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartL.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartM.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartN.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartO.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.SubjectDetailsLL.setVisibility(8);
            QuizResultScreenNew.this.resultCorrectTV_1.setText(QuizResultScreenNew.this.testReport.getData().getCorrectCount());
            QuizResultScreenNew.this.resultIncorrectTV_1.setText(QuizResultScreenNew.this.testReport.getData().getIncorrectCount());
            QuizResultScreenNew.this.resultAttemptTV_1.setText(QuizResultScreenNew.this.testReport.getData().getAttempted());
            QuizResultScreenNew.this.resultUnAttemptTV_1.setText(QuizResultScreenNew.this.testReport.getData().getNonAttempt());
            if (QuizResultScreenNew.this.leaderBoardsList != null && QuizResultScreenNew.this.leaderBoardsList.size() > 0) {
                QuizResultScreenNew.this.leaderboard_text.setVisibility(0);
                QuizResultScreenNew.this.leaderboard_ll.setVisibility(0);
                QuizResultScreenNew.this.leaderBoardAdapter = new LeaderBoardAdapter(QuizResultScreenNew.this.activity, QuizResultScreenNew.this.leaderBoardsList);
                QuizResultScreenNew.this.recyclerviewrank.setAdapter(QuizResultScreenNew.this.leaderBoardAdapter);
            } else {
                QuizResultScreenNew.this.leaderboard_text.setVisibility(8);
                QuizResultScreenNew.this.leaderboard_ll.setVisibility(8);
                QuizResultScreenNew.this.recyclerviewrank.setVisibility(8);
            }
            if (QuizResultScreenNew.this.testReport.getData() != null) {
                if (QuizResultScreenNew.this.testReport.getData().getAttempted() != null) {
                    QuizResultScreenNew.this.attemptedTV.setText(QuizResultScreenNew.this.testReport.getData().getAttempted());
                }
                QuizResultScreenNew.this.resultAttemptTV.setText(QuizResultScreenNew.this.testReport.getData().getAttempted());
                if (QuizResultScreenNew.this.testReport.getData().getCorrectCount() != null) {
                    QuizResultScreenNew.this.resultCorrectTV.setText(QuizResultScreenNew.this.testReport.getData().getCorrectCount());
                }
                if (QuizResultScreenNew.this.testReport.getData().getIncorrectCount() != null) {
                    QuizResultScreenNew.this.resultIncorrectTV.setText(QuizResultScreenNew.this.testReport.getData().getIncorrectCount());
                }
                if (QuizResultScreenNew.this.testReport.getData().getNonAttempt() != null) {
                    QuizResultScreenNew.this.resultUnAttemptTV.setText(QuizResultScreenNew.this.testReport.getData().getNonAttempt());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(View view) {
            QuizResultScreenNew.this.btnPartC.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartB.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartH.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_active));
            QuizResultScreenNew.this.btnPartD.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartE.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartF.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartG.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartA.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartI.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartJ.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartK.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartL.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartM.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartN.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartO.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.SubjectDetailsLL.setVisibility(0);
            if (QuizResultScreenNew.this.testReport.getData().getSubject().get(6).getMarks() != null) {
                QuizResultScreenNew.this.scoreTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(6).getMarks());
            }
            if (QuizResultScreenNew.this.testReport.getData().getSubject().get(6) != null) {
                if (QuizResultScreenNew.this.testReport.getData().getSubject().get(6).getAttempted() != null) {
                    QuizResultScreenNew.this.attemptedTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(6).getAttempted());
                }
                QuizResultScreenNew.this.resultAttemptTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(6).getAttempted());
                if (QuizResultScreenNew.this.testReport.getData().getSubject().get(6).getCorrectCount() != null) {
                    QuizResultScreenNew.this.resultCorrectTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(6).getCorrectCount());
                }
                if (QuizResultScreenNew.this.testReport.getData().getSubject().get(6).getIncorrectCount() != null) {
                    QuizResultScreenNew.this.resultIncorrectTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(6).getIncorrectCount());
                }
                if (QuizResultScreenNew.this.testReport.getData().getSubject().get(6).getNonAttempt() != null) {
                    QuizResultScreenNew.this.resultUnAttemptTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(6).getNonAttempt());
                }
                QuizResultScreenNew.this.subPercentileTV_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(6).getMarks());
                QuizResultScreenNew.this.ranks_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(6).getRank());
                QuizResultScreenNew.this.percentileTV_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(6).getPercentile());
                QuizResultScreenNew.this.percent.setText("%: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(6).getPercentage());
                QuizResultScreenNew.this.maxMarks.setText("MM: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(6).getMaxMark());
                QuizResultScreenNew.this.AvgScore.setText("AM: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(6).getAvgMark());
                QuizResultScreenNew quizResultScreenNew = QuizResultScreenNew.this;
                quizResultScreenNew.leaderBoardsSubjectList = quizResultScreenNew.testReport.getData().getSubject().get(6).getLeaderBoard();
                QuizResultScreenNew quizResultScreenNew2 = QuizResultScreenNew.this;
                quizResultScreenNew2.setSubjectListAdapter(quizResultScreenNew2.leaderBoardsSubjectList);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$2(View view) {
            QuizResultScreenNew.this.btnPartC.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartB.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartI.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_active));
            QuizResultScreenNew.this.btnPartD.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartE.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartF.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartG.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartA.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartH.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartJ.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartK.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartL.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartM.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartN.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartO.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.SubjectDetailsLL.setVisibility(0);
            if (QuizResultScreenNew.this.testReport.getData().getSubject().get(7).getMarks() != null) {
                QuizResultScreenNew.this.scoreTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(7).getMarks());
            }
            if (QuizResultScreenNew.this.testReport.getData().getSubject().get(7) != null) {
                if (QuizResultScreenNew.this.testReport.getData().getSubject().get(7).getAttempted() != null) {
                    QuizResultScreenNew.this.attemptedTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(7).getAttempted());
                }
                QuizResultScreenNew.this.resultAttemptTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(7).getAttempted());
                if (QuizResultScreenNew.this.testReport.getData().getSubject().get(7).getCorrectCount() != null) {
                    QuizResultScreenNew.this.resultCorrectTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(7).getCorrectCount());
                }
                if (QuizResultScreenNew.this.testReport.getData().getSubject().get(7).getIncorrectCount() != null) {
                    QuizResultScreenNew.this.resultIncorrectTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(7).getIncorrectCount());
                }
                if (QuizResultScreenNew.this.testReport.getData().getSubject().get(7).getNonAttempt() != null) {
                    QuizResultScreenNew.this.resultUnAttemptTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(7).getNonAttempt());
                }
                QuizResultScreenNew.this.subPercentileTV_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(7).getMarks());
                QuizResultScreenNew.this.ranks_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(7).getRank());
                QuizResultScreenNew.this.percentileTV_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(7).getPercentile());
                QuizResultScreenNew.this.percent.setText("%: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(7).getPercentage());
                QuizResultScreenNew.this.maxMarks.setText("MM: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(7).getMaxMark());
                QuizResultScreenNew.this.AvgScore.setText("AM: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(7).getAvgMark());
                QuizResultScreenNew quizResultScreenNew = QuizResultScreenNew.this;
                quizResultScreenNew.leaderBoardsSubjectList = quizResultScreenNew.testReport.getData().getSubject().get(7).getLeaderBoard();
                QuizResultScreenNew quizResultScreenNew2 = QuizResultScreenNew.this;
                quizResultScreenNew2.setSubjectListAdapter(quizResultScreenNew2.leaderBoardsSubjectList);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$3(View view) {
            QuizResultScreenNew.this.btnPartC.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartB.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartJ.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_active));
            QuizResultScreenNew.this.btnPartD.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartE.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartF.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartG.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartA.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartH.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartI.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartK.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartL.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartM.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartN.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartO.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.SubjectDetailsLL.setVisibility(0);
            if (QuizResultScreenNew.this.testReport.getData().getSubject().get(8).getMarks() != null) {
                QuizResultScreenNew.this.scoreTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(8).getMarks());
            }
            if (QuizResultScreenNew.this.testReport.getData().getSubject().get(8) != null) {
                if (QuizResultScreenNew.this.testReport.getData().getSubject().get(8).getAttempted() != null) {
                    QuizResultScreenNew.this.attemptedTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(8).getAttempted());
                }
                QuizResultScreenNew.this.resultAttemptTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(8).getAttempted());
                if (QuizResultScreenNew.this.testReport.getData().getSubject().get(8).getCorrectCount() != null) {
                    QuizResultScreenNew.this.resultCorrectTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(8).getCorrectCount());
                }
                if (QuizResultScreenNew.this.testReport.getData().getSubject().get(8).getIncorrectCount() != null) {
                    QuizResultScreenNew.this.resultIncorrectTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(8).getIncorrectCount());
                }
                if (QuizResultScreenNew.this.testReport.getData().getSubject().get(8).getNonAttempt() != null) {
                    QuizResultScreenNew.this.resultUnAttemptTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(8).getNonAttempt());
                }
                QuizResultScreenNew.this.subPercentileTV_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(8).getMarks());
                QuizResultScreenNew.this.ranks_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(8).getRank());
                QuizResultScreenNew.this.percentileTV_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(8).getPercentile());
                QuizResultScreenNew.this.percent.setText("%: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(8).getPercentage());
                QuizResultScreenNew.this.maxMarks.setText("MM: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(8).getMaxMark());
                QuizResultScreenNew.this.AvgScore.setText("AM: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(8).getAvgMark());
            }
            QuizResultScreenNew quizResultScreenNew = QuizResultScreenNew.this;
            quizResultScreenNew.leaderBoardsSubjectList = quizResultScreenNew.testReport.getData().getSubject().get(8).getLeaderBoard();
            QuizResultScreenNew quizResultScreenNew2 = QuizResultScreenNew.this;
            quizResultScreenNew2.setSubjectListAdapter(quizResultScreenNew2.leaderBoardsSubjectList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$4(View view) {
            QuizResultScreenNew.this.btnPartC.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartB.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartK.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_active));
            QuizResultScreenNew.this.btnPartD.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartE.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartF.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartG.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartA.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartH.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartI.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartJ.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartL.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartM.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartN.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartO.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.SubjectDetailsLL.setVisibility(0);
            if (QuizResultScreenNew.this.testReport.getData().getSubject().get(9).getMarks() != null) {
                QuizResultScreenNew.this.scoreTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(9).getMarks());
            }
            if (QuizResultScreenNew.this.testReport.getData().getSubject().get(9) != null) {
                if (QuizResultScreenNew.this.testReport.getData().getSubject().get(9).getAttempted() != null) {
                    QuizResultScreenNew.this.attemptedTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(9).getAttempted());
                }
                QuizResultScreenNew.this.resultAttemptTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(9).getAttempted());
                if (QuizResultScreenNew.this.testReport.getData().getSubject().get(9).getCorrectCount() != null) {
                    QuizResultScreenNew.this.resultCorrectTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(9).getCorrectCount());
                }
                if (QuizResultScreenNew.this.testReport.getData().getSubject().get(9).getIncorrectCount() != null) {
                    QuizResultScreenNew.this.resultIncorrectTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(9).getIncorrectCount());
                }
                if (QuizResultScreenNew.this.testReport.getData().getSubject().get(9).getNonAttempt() != null) {
                    QuizResultScreenNew.this.resultUnAttemptTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(9).getNonAttempt());
                }
                QuizResultScreenNew.this.subPercentileTV_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(9).getMarks());
                QuizResultScreenNew.this.ranks_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(9).getRank());
                QuizResultScreenNew.this.percentileTV_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(9).getPercentile());
                QuizResultScreenNew.this.percent.setText("%: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(9).getPercentage());
                QuizResultScreenNew.this.maxMarks.setText("MM: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(9).getMaxMark());
                QuizResultScreenNew.this.AvgScore.setText("AM: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(9).getAvgMark());
                QuizResultScreenNew quizResultScreenNew = QuizResultScreenNew.this;
                quizResultScreenNew.leaderBoardsSubjectList = quizResultScreenNew.testReport.getData().getSubject().get(9).getLeaderBoard();
                QuizResultScreenNew quizResultScreenNew2 = QuizResultScreenNew.this;
                quizResultScreenNew2.setSubjectListAdapter(quizResultScreenNew2.leaderBoardsSubjectList);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$5(View view) {
            QuizResultScreenNew.this.btnPartC.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartB.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartL.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_active));
            QuizResultScreenNew.this.btnPartD.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartE.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartF.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartG.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartA.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartH.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartI.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartJ.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartK.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartM.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartN.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartO.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.SubjectDetailsLL.setVisibility(0);
            if (QuizResultScreenNew.this.testReport.getData().getSubject().get(10).getMarks() != null) {
                QuizResultScreenNew.this.scoreTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(10).getMarks());
            }
            if (QuizResultScreenNew.this.testReport.getData().getSubject().get(10) != null) {
                if (QuizResultScreenNew.this.testReport.getData().getSubject().get(10).getAttempted() != null) {
                    QuizResultScreenNew.this.attemptedTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(10).getAttempted());
                }
                QuizResultScreenNew.this.resultAttemptTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(10).getAttempted());
                if (QuizResultScreenNew.this.testReport.getData().getSubject().get(10).getCorrectCount() != null) {
                    QuizResultScreenNew.this.resultCorrectTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(10).getCorrectCount());
                }
                if (QuizResultScreenNew.this.testReport.getData().getSubject().get(10).getIncorrectCount() != null) {
                    QuizResultScreenNew.this.resultIncorrectTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(10).getIncorrectCount());
                }
                if (QuizResultScreenNew.this.testReport.getData().getSubject().get(10).getNonAttempt() != null) {
                    QuizResultScreenNew.this.resultUnAttemptTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(10).getNonAttempt());
                }
                QuizResultScreenNew.this.subPercentileTV_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(10).getMarks());
                QuizResultScreenNew.this.ranks_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(10).getRank());
                QuizResultScreenNew.this.percentileTV_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(10).getPercentile());
                QuizResultScreenNew.this.percent.setText("%: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(10).getPercentage());
                QuizResultScreenNew.this.maxMarks.setText("MM: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(10).getMaxMark());
                QuizResultScreenNew.this.AvgScore.setText("AM: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(10).getAvgMark());
                QuizResultScreenNew quizResultScreenNew = QuizResultScreenNew.this;
                quizResultScreenNew.leaderBoardsSubjectList = quizResultScreenNew.testReport.getData().getSubject().get(10).getLeaderBoard();
                QuizResultScreenNew quizResultScreenNew2 = QuizResultScreenNew.this;
                quizResultScreenNew2.setSubjectListAdapter(quizResultScreenNew2.leaderBoardsSubjectList);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$6(View view) {
            QuizResultScreenNew.this.btnPartC.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartB.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartM.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_active));
            QuizResultScreenNew.this.btnPartD.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartE.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartF.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartG.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartA.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartH.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartI.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartJ.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartL.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartK.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartN.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartO.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            if (QuizResultScreenNew.this.testReport.getData().getSubject().get(11).getMarks() != null) {
                QuizResultScreenNew.this.scoreTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(11).getMarks());
            }
            if (QuizResultScreenNew.this.testReport.getData().getSubject().get(11) != null) {
                if (QuizResultScreenNew.this.testReport.getData().getSubject().get(11).getAttempted() != null) {
                    QuizResultScreenNew.this.attemptedTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(11).getAttempted());
                }
                QuizResultScreenNew.this.resultAttemptTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(11).getAttempted());
                if (QuizResultScreenNew.this.testReport.getData().getSubject().get(11).getCorrectCount() != null) {
                    QuizResultScreenNew.this.resultCorrectTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(11).getCorrectCount());
                }
                if (QuizResultScreenNew.this.testReport.getData().getSubject().get(11).getIncorrectCount() != null) {
                    QuizResultScreenNew.this.resultIncorrectTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(11).getIncorrectCount());
                }
                if (QuizResultScreenNew.this.testReport.getData().getSubject().get(11).getNonAttempt() != null) {
                    QuizResultScreenNew.this.resultUnAttemptTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(11).getNonAttempt());
                }
                QuizResultScreenNew.this.subPercentileTV_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(11).getMarks());
                QuizResultScreenNew.this.ranks_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(11).getRank());
                QuizResultScreenNew.this.percentileTV_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(11).getPercentile());
                QuizResultScreenNew.this.percent.setText("%: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(11).getPercentage());
                QuizResultScreenNew.this.maxMarks.setText("MM: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(11).getMaxMark());
                QuizResultScreenNew.this.AvgScore.setText("AM: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(11).getAvgMark());
                QuizResultScreenNew quizResultScreenNew = QuizResultScreenNew.this;
                quizResultScreenNew.leaderBoardsSubjectList = quizResultScreenNew.testReport.getData().getSubject().get(11).getLeaderBoard();
                QuizResultScreenNew quizResultScreenNew2 = QuizResultScreenNew.this;
                quizResultScreenNew2.setSubjectListAdapter(quizResultScreenNew2.leaderBoardsSubjectList);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$7(View view) {
            QuizResultScreenNew.this.btnPartC.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartB.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartN.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_active));
            QuizResultScreenNew.this.btnPartD.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartE.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartF.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartG.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartA.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartH.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartI.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartJ.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartL.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartK.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartM.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartO.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            if (QuizResultScreenNew.this.testReport.getData().getSubject().get(12).getMarks() != null) {
                QuizResultScreenNew.this.scoreTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(12).getMarks());
            }
            if (QuizResultScreenNew.this.testReport.getData().getSubject().get(12) != null) {
                if (QuizResultScreenNew.this.testReport.getData().getSubject().get(12).getAttempted() != null) {
                    QuizResultScreenNew.this.attemptedTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(12).getAttempted());
                }
                QuizResultScreenNew.this.resultAttemptTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(12).getAttempted());
                if (QuizResultScreenNew.this.testReport.getData().getSubject().get(12).getCorrectCount() != null) {
                    QuizResultScreenNew.this.resultCorrectTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(12).getCorrectCount());
                }
                if (QuizResultScreenNew.this.testReport.getData().getSubject().get(12).getIncorrectCount() != null) {
                    QuizResultScreenNew.this.resultIncorrectTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(12).getIncorrectCount());
                }
                if (QuizResultScreenNew.this.testReport.getData().getSubject().get(12).getNonAttempt() != null) {
                    QuizResultScreenNew.this.resultUnAttemptTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(12).getNonAttempt());
                }
                QuizResultScreenNew.this.subPercentileTV_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(12).getMarks());
                QuizResultScreenNew.this.ranks_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(12).getRank());
                QuizResultScreenNew.this.percentileTV_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(12).getPercentile());
                QuizResultScreenNew.this.percent.setText("%: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(12).getPercentage());
                QuizResultScreenNew.this.maxMarks.setText("MM: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(12).getMaxMark());
                QuizResultScreenNew.this.AvgScore.setText("AM: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(12).getAvgMark());
                QuizResultScreenNew quizResultScreenNew = QuizResultScreenNew.this;
                quizResultScreenNew.leaderBoardsSubjectList = quizResultScreenNew.testReport.getData().getSubject().get(12).getLeaderBoard();
                QuizResultScreenNew quizResultScreenNew2 = QuizResultScreenNew.this;
                quizResultScreenNew2.setSubjectListAdapter(quizResultScreenNew2.leaderBoardsSubjectList);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$8(View view) {
            QuizResultScreenNew.this.btnPartC.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartB.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartO.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_active));
            QuizResultScreenNew.this.btnPartD.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartE.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartF.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartG.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartA.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartH.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartI.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartJ.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartL.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartK.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartN.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            QuizResultScreenNew.this.btnPartM.setBackground(QuizResultScreenNew.this.activity.getResources().getDrawable(R.drawable.result_part_bg_deactive));
            if (QuizResultScreenNew.this.testReport.getData().getSubject().get(13).getMarks() != null) {
                QuizResultScreenNew.this.scoreTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(13).getMarks());
            }
            if (QuizResultScreenNew.this.testReport.getData().getSubject().get(13) != null) {
                if (QuizResultScreenNew.this.testReport.getData().getSubject().get(13).getAttempted() != null) {
                    QuizResultScreenNew.this.attemptedTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(13).getAttempted());
                }
                QuizResultScreenNew.this.resultAttemptTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(13).getAttempted());
                if (QuizResultScreenNew.this.testReport.getData().getSubject().get(13).getCorrectCount() != null) {
                    QuizResultScreenNew.this.resultCorrectTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(13).getCorrectCount());
                }
                if (QuizResultScreenNew.this.testReport.getData().getSubject().get(13).getIncorrectCount() != null) {
                    QuizResultScreenNew.this.resultIncorrectTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(13).getIncorrectCount());
                }
                if (QuizResultScreenNew.this.testReport.getData().getSubject().get(13).getNonAttempt() != null) {
                    QuizResultScreenNew.this.resultUnAttemptTV.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(13).getNonAttempt());
                }
                QuizResultScreenNew.this.subPercentileTV_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(13).getMarks());
                QuizResultScreenNew.this.ranks_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(13).getRank());
                QuizResultScreenNew.this.percentileTV_1.setText(QuizResultScreenNew.this.testReport.getData().getSubject().get(13).getPercentile());
                QuizResultScreenNew.this.percent.setText("%: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(13).getPercentage());
                QuizResultScreenNew.this.maxMarks.setText("MM: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(13).getMaxMark());
                QuizResultScreenNew.this.AvgScore.setText("AM: " + QuizResultScreenNew.this.testReport.getData().getSubject().get(13).getAvgMark());
                QuizResultScreenNew quizResultScreenNew = QuizResultScreenNew.this;
                quizResultScreenNew.leaderBoardsSubjectList = quizResultScreenNew.testReport.getData().getSubject().get(13).getLeaderBoard();
                QuizResultScreenNew quizResultScreenNew2 = QuizResultScreenNew.this;
                quizResultScreenNew2.setSubjectListAdapter(quizResultScreenNew2.leaderBoardsSubjectList);
            }
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<String> call, Throwable t) {
            QuizResultScreenNew.this.mprogress.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSubjectListAdapter(List<com.appnew.android.Model.TestReportModel.LeaderBoard> leaderBoardsSubjectList) {
        TestReport testReport = this.testReport;
        if (testReport != null && testReport.getData() != null && !this.testReport.getData().getHideRank().equalsIgnoreCase("1") && leaderBoardsSubjectList != null && leaderBoardsSubjectList.size() > 0) {
            this.leaderboard_text.setVisibility(0);
            this.leaderboard_ll.setVisibility(0);
            this.recyclerviewrank.setVisibility(0);
            LeaderBoardAdapter leaderBoardAdapter = new LeaderBoardAdapter(this.activity, leaderBoardsSubjectList);
            this.leaderBoardAdapter = leaderBoardAdapter;
            this.recyclerviewrank.setAdapter(leaderBoardAdapter);
            return;
        }
        this.leaderboard_text.setVisibility(8);
        this.leaderboard_ll.setVisibility(8);
        this.recyclerviewrank.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getUserData(String name) {
        return SharedPreference.getInstance().getLoggedInUser().getName();
    }

    private void initViews(View view) {
        this.rank = (LinearLayout) view.findViewById(R.id.rank);
        this.RankOldLL = (LinearLayout) view.findViewById(R.id.RankOldLL);
        this.RankNewLL = (LinearLayout) view.findViewById(R.id.RankNewLL);
        this.rankPredictionNoteLL = (LinearLayout) view.findViewById(R.id.rankPredictionNoteLL);
        this.improvementLL = (LinearLayout) view.findViewById(R.id.improvementLL);
        this.progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        this.tvScore = (TextView) view.findViewById(R.id.tvScore);
        this.guideline = (Guideline) view.findViewById(R.id.scoreGuideline);
        this.expectedRankRangeTV = (TextView) view.findViewById(R.id.expectedRankRangeTV);
        this.improvementTV = (TextView) view.findViewById(R.id.improvementTV);
        this.rankPredictionTV = (TextView) view.findViewById(R.id.rankPredictionTV);
        this.userTestScoreTv = (TextView) view.findViewById(R.id.userTestScoreTv);
        this.TopperTestScoreTV = (TextView) view.findViewById(R.id.TopperTestScoreTV);
        this.userTestAccuracyTv = (TextView) view.findViewById(R.id.userTestAccuracyTv);
        this.TopperTestAccuracyTV = (TextView) view.findViewById(R.id.TopperTestAccuracyTV);
        this.userTestAttemptedTv = (TextView) view.findViewById(R.id.userTestAttemptedTv);
        this.TopperTestAttemptedTV = (TextView) view.findViewById(R.id.TopperTestAttemptedTV);
        this.userTestTimeTv = (TextView) view.findViewById(R.id.userTestTimeTv);
        this.TopperTestTimeTV = (TextView) view.findViewById(R.id.TopperTestTimeTV);
        this.userScoreProgressBar = (ProgressBar) view.findViewById(R.id.userScoreProgressBar);
        this.topperScoreProgressBar = (ProgressBar) view.findViewById(R.id.topperScoreProgressBar);
        this.userAccuracyProgressBar = (ProgressBar) view.findViewById(R.id.userAccuracyProgressBar);
        this.topperAccuracyProgressBar = (ProgressBar) view.findViewById(R.id.topperAccuracyProgressBar);
        this.userAttemptedProgressBar = (ProgressBar) view.findViewById(R.id.userAttemptedProgressBar);
        this.topperAttemptedProgressBar = (ProgressBar) view.findViewById(R.id.topperAttemptedProgressBar);
        this.userTimeProgressBar = (ProgressBar) view.findViewById(R.id.userTimeProgressBar);
        this.topperTimeProgressBar = (ProgressBar) view.findViewById(R.id.topperTimeProgressBar);
        this.card_score = (CardView) view.findViewById(R.id.card_score);
        this.ll_main_rank = (LinearLayout) view.findViewById(R.id.ll_main_rank);
        this.showMore = (LinearLayout) view.findViewById(R.id.showMore);
        this.showLess = (LinearLayout) view.findViewById(R.id.showLess);
        this.answerListRV = (NonScrollRecyclerView) view.findViewById(R.id.answerListRV);
        this.videosolution = (LinearLayout) view.findViewById(R.id.videosolution);
        this.videosolution2 = (LinearLayout) view.findViewById(R.id.videosolution2);
        this.accuracy_sectionwise = (RelativeLayout) view.findViewById(R.id.accuracy_sectionwise);
        this.ssEnabledText = (TextView) view.findViewById(R.id.enableScreenShot);
        this.ll_acuracy = (LinearLayout) view.findViewById(R.id.ll_acuracy);
        this.solution_horizontal_scroll = (HorizontalScrollView) view.findViewById(R.id.solution_horizontal_scroll);
        this.scholorshipViewSolutionRL = (RelativeLayout) view.findViewById(R.id.scholorshipViewSolutionRL);
        this.scholorshipViewSolution = (LinearLayout) view.findViewById(R.id.scholorshipViewSolution);
        this.ll_scholorship_main = (RelativeLayout) view.findViewById(R.id.ll_scholorship_main);
        this.ll_offered_course = (LinearLayout) view.findViewById(R.id.ll_offered_course);
        this.ll_offered_course2 = (LinearLayout) view.findViewById(R.id.ll_offered_course2);
        this.tv_how_you_perform = (TextView) view.findViewById(R.id.tv_how_you_perform);
        this.tv_max_score_hint = (TextView) view.findViewById(R.id.tv_max_score_hint);
        this.tv_score_hint = (TextView) view.findViewById(R.id.tv_score_hint);
        this.view_test_taken_time = view.findViewById(R.id.view_test_taken_time);
        this.ll_test_taken_time = (LinearLayout) view.findViewById(R.id.ll_test_taken_time);
        this.rv_scholarship_course = (RecyclerView) view.findViewById(R.id.rv_scholarship_course);
        this.rv_scholarship_course2 = (RecyclerView) view.findViewById(R.id.rv_scholarship_course2);
        this.tv_test_prize = (TextView) view.findViewById(R.id.tv_test_prize);
        this.disqualified = (TextView) view.findViewById(R.id.disqualified);
        this.rank_score_LL = (LinearLayout) view.findViewById(R.id.rank_score_LL);
        this.resultViewSolution = (LinearLayout) view.findViewById(R.id.resultViewSolution);
        this.rankRL = (RelativeLayout) view.findViewById(R.id.rankRL);
        this.accuracy_LL = (LinearLayout) view.findViewById(R.id.accuracy_LL);
        this.percentileLL = (LinearLayout) view.findViewById(R.id.percentileLL);
        this.scoreLL = (LinearLayout) view.findViewById(R.id.scoreLL);
        this.viewpercentile = view.findViewById(R.id.viewpercentile);
        this.viewaccuracy = view.findViewById(R.id.viewaccuracy);
        this.resultDownloadCertificate = (LinearLayout) view.findViewById(R.id.resultDownloadCertificate);
        this.resultNameTV = (TextView) view.findViewById(R.id.resultNameTV);
        this.resultAccuracyTV = (TextView) view.findViewById(R.id.resultAccuracyTV);
        this.userAttempt = (TextView) view.findViewById(R.id.userAttempt);
        this.resultGuessTV = (TextView) view.findViewById(R.id.resultGuessTV);
        this.llNewTest = (LinearLayout) view.findViewById(R.id.llNewTest);
        this.resultPercentileTV = (TextView) view.findViewById(R.id.resultPercentileTV);
        this.resultAttemptedTV = (TextView) view.findViewById(R.id.resultAttemptedTV);
        this.resultBestScoreTV = (TextView) view.findViewById(R.id.resultBestScoreTv);
        this.resultAvgScoreTV = (TextView) view.findViewById(R.id.resultAvgScoreTV);
        this.resultCorrectTV = (TextView) view.findViewById(R.id.resultCorrectTV);
        this.resultIncorrectTV = (TextView) view.findViewById(R.id.resultIncorrectTV);
        this.resultCorrectTV_1 = (TextView) view.findViewById(R.id.resultCorrectTV_1);
        this.resultIncorrectTV_1 = (TextView) view.findViewById(R.id.resultIncorrectTV_1);
        this.resultAttemptTV_1 = (TextView) view.findViewById(R.id.resultAttemptTV_1);
        this.resultUnAttemptTV_1 = (TextView) view.findViewById(R.id.resultUnAttemptTV_1);
        this.overAllDetailsLL = (LinearLayout) view.findViewById(R.id.overAllDetailsLL);
        this.leaderboard_ll = (LinearLayout) view.findViewById(R.id.leaderboard_ll);
        this.SubjectDetailsLL = (LinearLayout) view.findViewById(R.id.SubjectDetailsLL);
        this.subPercentileTV_1 = (TextView) view.findViewById(R.id.subPercentileTV_1);
        this.ranks_1 = (TextView) view.findViewById(R.id.ranks_1);
        this.subjectRankRl = (RelativeLayout) view.findViewById(R.id.subjectRankRl);
        this.percentileTV_1 = (TextView) view.findViewById(R.id.percentileTV_1);
        this.viewMore = (TextView) view.findViewById(R.id.viewMore);
        this.totalAttemptedLL = (LinearLayout) view.findViewById(R.id.totalAttemptedLL);
        this.ll_test_score_LL = (LinearLayout) view.findViewById(R.id.ll_test_score_LL);
        this.subjectScoreTimeLL = (LinearLayout) view.findViewById(R.id.subjectScoreTimeLL);
        this.viewOMRLl = (LinearLayout) view.findViewById(R.id.viewOMRLl);
        this.viewOfflineTest = (LinearLayout) view.findViewById(R.id.viewOfflineTest);
        this.questionSkipLL = (LinearLayout) view.findViewById(R.id.questionSkipLL);
        this.percent = (TextView) view.findViewById(R.id.percent);
        this.maxMarks = (TextView) view.findViewById(R.id.maxMarks);
        this.AvgScore = (TextView) view.findViewById(R.id.AvgScore);
        this.btnPartA = (Button) view.findViewById(R.id.btnPartA);
        this.btnPartB = (Button) view.findViewById(R.id.btnPartB);
        this.btnPartC = (Button) view.findViewById(R.id.btnPartC);
        this.btnPartD = (Button) view.findViewById(R.id.btnPartD);
        this.btnPartE = (Button) view.findViewById(R.id.btnPartE);
        this.btnPartF = (Button) view.findViewById(R.id.btnPartF);
        this.btnPartG = (Button) view.findViewById(R.id.btnPartG);
        this.btnPartH = (Button) view.findViewById(R.id.btnPartH);
        this.btnPartI = (Button) view.findViewById(R.id.btnPartI);
        this.btnPartJ = (Button) view.findViewById(R.id.btnPartJ);
        this.btnPartK = (Button) view.findViewById(R.id.btnPartK);
        this.btnPartL = (Button) view.findViewById(R.id.btnPartL);
        this.btnPartM = (Button) view.findViewById(R.id.btnPartM);
        this.btnPartN = (Button) view.findViewById(R.id.btnPartN);
        this.btnPartO = (Button) view.findViewById(R.id.btnPartO);
        this.scoreTV = (TextView) view.findViewById(R.id.scoreTV);
        this.percentageTV = (TextView) view.findViewById(R.id.percentageTV);
        this.timeTV = (TextView) view.findViewById(R.id.timeTV);
        this.accuracyTV = (TextView) view.findViewById(R.id.accuracyTV);
        this.percentileTV = (TextView) view.findViewById(R.id.percentileTV);
        this.guessTV = (TextView) view.findViewById(R.id.guessTV);
        this.attemptedTV = (TextView) view.findViewById(R.id.attemptedTV);
        this.resultSkippedTV = (TextView) view.findViewById(R.id.resultSkippedTV);
        this.resultBookmarkTV = (TextView) view.findViewById(R.id.resultBookmarkTV);
        this.resultAttemptTV = (TextView) view.findViewById(R.id.resultAttemptTV);
        this.questionSkipTV = (TextView) view.findViewById(R.id.questionSkipTV);
        this.optional = (TextView) view.findViewById(R.id.optional);
        this.mandatory = (TextView) view.findViewById(R.id.mandatory);
        this.mandratoryLinear = (LinearLayout) view.findViewById(R.id.mandratoryLinear);
        this.optionalLinear = (LinearLayout) view.findViewById(R.id.optionalLinear);
        this.resultUnAttemptTV = (TextView) view.findViewById(R.id.resultUnAttemptTV);
        this.resultTimeDuration = (TextView) view.findViewById(R.id.resultTimeDuration);
        this.viewSubjectWiseDetailRL = (RelativeLayout) view.findViewById(R.id.viewSubjectWiseDetailRL);
        this.resultRankTV = (TextView) view.findViewById(R.id.resultRankTV);
        this.resultScoreTV = (TextView) view.findViewById(R.id.resultScoreTV);
        this.recyclerviewrank = (NonScrollRecyclerView) view.findViewById(R.id.leaderBoardRV);
        this.resultOutLL = (LinearLayout) view.findViewById(R.id.resultOutLL);
        this.leaderboard_text = (TextView) view.findViewById(R.id.leaderboard_text);
        this.resultDeclaredLL = (LinearLayout) view.findViewById(R.id.resultDeclaredLL);
        this.ll_not_qualified = (RelativeLayout) view.findViewById(R.id.ll_not_qualified);
        this.tv_not_qualified = (TextView) view.findViewById(R.id.tv_not_qualified);
        this.downloadPDFLL = (LinearLayout) view.findViewById(R.id.downloadPDFLL);
        this.OverAllDurationLL = (LinearLayout) view.findViewById(R.id.OverAllDurationLL);
        this.no_data_found_RL = (RelativeLayout) view.findViewById(R.id.no_data_found_RL);
        this.recyclerviewrank.setLayoutManager(new LinearLayoutManager(this.activity));
        this.recyclerviewrank.setHasFixedSize(true);
        this.ll_not_qualified.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.fragment.QuizResultScreenNew$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QuizResultScreenNew.lambda$initViews$0(view2);
            }
        });
        if (BuildConfig.FLAVOR.equalsIgnoreCase("DishaPublication")) {
            this.userAttempt.setVisibility(8);
        }
        this.answerListRV.setLayoutManager(new GridLayoutManager(this.activity, 7));
        this.answerListRV.addItemDecoration(new GridSpacingItemDecoration(7, 20, false));
        this.resultViewSolution.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.fragment.QuizResultScreenNew$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$initViews$1(view2);
            }
        });
        this.scholorshipViewSolution.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.fragment.QuizResultScreenNew$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$initViews$2(view2);
            }
        });
        this.resultDownloadCertificate.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.fragment.QuizResultScreenNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    if (QuizResultScreenNew.this.resultTestSeries2.getData().getPercentage() == null || QuizResultScreenNew.this.resultTestSeries2.getData().getPercentage().equalsIgnoreCase("") || QuizResultScreenNew.this.resultTestSeries2.getData().getPassing_cutoff() == null || QuizResultScreenNew.this.resultTestSeries2.getData().getPassing_cutoff().equalsIgnoreCase("")) {
                        return;
                    }
                    if (((int) Double.parseDouble(QuizResultScreenNew.this.resultTestSeries2.getData().getPercentage())) >= Integer.parseInt(QuizResultScreenNew.this.resultTestSeries2.getData().getPassing_cutoff())) {
                        QuizResultScreenNew.this.API_DOWNLOAD_CERTIFICATE();
                    } else {
                        Toast.makeText(QuizResultScreenNew.this.activity, QuizResultScreenNew.this.activity.getResources().getString(R.string.you_are_not_qualified_for_certificate), 0).show();
                    }
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
        });
        this.videosolution.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.fragment.QuizResultScreenNew$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$initViews$3(view2);
            }
        });
        this.videosolution2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.fragment.QuizResultScreenNew.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (QuizResultScreenNew.this.resultTestSeries2.getData().getTest_report_videos() != null && QuizResultScreenNew.this.resultTestSeries2.getData().getTest_report_videos().get(1).getVideo_url().contains(".mp4")) {
                    Intent intent = new Intent(QuizResultScreenNew.this.getActivity(), (Class<?>) VideoPlayActivity.class);
                    intent.putExtra(Const.VIDEODATA, QuizResultScreenNew.this.resultTestSeries2.getData().getTest_report_videos().get(1));
                    QuizResultScreenNew.this.startActivity(intent);
                    return;
                }
                Toast.makeText(QuizResultScreenNew.this.getActivity(), QuizResultScreenNew.this.activity.getResources().getString(R.string.incorrupt_video_url), 0).show();
            }
        });
        this.viewSubjectWiseDetailRL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.fragment.QuizResultScreenNew.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
            }
        });
        this.downloadPDFLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.fragment.QuizResultScreenNew$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$initViews$4(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$1(View view) {
        ResultTestSeries_Report resultTestSeries_Report = this.resultTestSeries2;
        if (resultTestSeries_Report != null && resultTestSeries_Report.getData() != null && this.resultTestSeries2.getData().getQuestion_dump() != null && this.resultTestSeries2.getData().getQuestion_dump().size() > 0) {
            SharedPreference.getInstance().putString("testresult", new Gson().toJson(this.resultTestSeries2));
            Intent intent = new Intent(this.activity, (Class<?>) ViewSolutionActivity.class);
            intent.putExtra(Const.TESTSEGMENT_ID, this.status);
            intent.putExtra("name", this.testSeriesName);
            if (this.resultTestSeries2.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("1") || this.resultTestSeries2.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("2")) {
                this.lang = Integer.parseInt(this.resultTestSeries2.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
            }
            intent.putExtra(Const.LANG, this.lang);
            Helper.gotoActivity(intent, this.activity);
            return;
        }
        Activity activity = this.activity;
        Toast.makeText(activity, activity.getResources().getString(R.string.no_view_solution_found_please_try_again), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$2(View view) {
        ResultTestSeries_Report resultTestSeries_Report = this.resultTestSeries2;
        if (resultTestSeries_Report != null && resultTestSeries_Report.getData() != null && this.resultTestSeries2.getData().getQuestion_dump() != null && this.resultTestSeries2.getData().getQuestion_dump().size() > 0) {
            SharedPreference.getInstance().putString("testresult", new Gson().toJson(this.resultTestSeries2));
            Intent intent = new Intent(this.activity, (Class<?>) ViewSolutionActivity.class);
            intent.putExtra(Const.TESTSEGMENT_ID, this.status);
            intent.putExtra("name", this.testSeriesName);
            if (this.resultTestSeries2.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("1") || this.resultTestSeries2.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("2")) {
                this.lang = Integer.parseInt(this.resultTestSeries2.getData().getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
            }
            intent.putExtra(Const.LANG, this.lang);
            Helper.gotoActivity(intent, this.activity);
            return;
        }
        Activity activity = this.activity;
        Toast.makeText(activity, activity.getResources().getString(R.string.no_view_solution_found_please_try_again), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$3(View view) {
        if (Helper.isNetworkConnected(getActivity())) {
            if (this.resultTestSeries2.getData().getTest_report_videos() != null && this.resultTestSeries2.getData().getTest_report_videos().get(0).getVideo_url().contains(".mp4")) {
                Intent intent = new Intent(getActivity(), (Class<?>) VideoPlayActivity.class);
                intent.putExtra(Const.VIDEODATA, this.resultTestSeries2.getData().getTest_report_videos().get(0));
                startActivity(intent);
                return;
            }
            Toast.makeText(getActivity(), this.activity.getResources().getString(R.string.incorrupt_video_url), 0).show();
            return;
        }
        Toast.makeText(getActivity(), this.activity.getResources().getString(R.string.no_internet_connection), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$4(View view) {
        Intent intent = new Intent(getContext(), (Class<?>) PdfDetailScreen.class);
        intent.putExtra("url", this.resultTestSeries2.getData().getQuestion_pdf());
        if (this.resultTestSeries2.getData().getDownload_pdf() != null && this.resultTestSeries2.getData().getDownload_pdf().equalsIgnoreCase("1")) {
            intent.putExtra(Const.IS_DOWNLOAD, true);
            intent.putExtra("is_share", "1");
        } else {
            intent.putExtra(Const.IS_DOWNLOAD, false);
        }
        intent.putExtra("pdf_name", this.resultTestSeries2.getData().getTest_series_name());
        intent.putExtra("course_id", this.resultTestSeries2.getData().getId());
        intent.putExtra("title", this.resultTestSeries2.getData().getId());
        startActivity(intent);
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
        if (testBasic.getMulti_description().size() > 0) {
            linearLayout3.setVisibility(0);
            if (testBasic.getMulti_description() != null && testBasic.getMulti_description().size() > 0) {
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
                textView5.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.fragment.QuizResultScreenNew.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        QuizResultScreenNew quizResultScreenNew = QuizResultScreenNew.this;
                        TextView textView9 = textView5;
                        TestBasicInst testBasicInst = testBasic;
                        TextView textView10 = textView8;
                        quizResultScreenNew.showPopMenuForLangauge1(textView9, testBasicInst, textView10, textView10);
                    }
                });
            }
            i = 0;
            if (testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("1")) {
                textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[0]);
                this.lang = Integer.parseInt(testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
            } else {
                if (testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("2")) {
                    textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[1]);
                    this.lang = Integer.parseInt(testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                }
                i = 0;
            }
        } else {
            if (testBasic.getLang_id().length() > 2) {
                textView5.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.fragment.QuizResultScreenNew.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        QuizResultScreenNew.this.showPopMenuForLangauge(textView8, textView5, testBasic);
                    }
                });
            }
            i = 0;
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
                i = 0;
                this.lang = Integer.parseInt(testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
            } else {
                i = 0;
                if (testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("6")) {
                    textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[4]);
                    this.lang = Integer.parseInt(testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                } else if (testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("10")) {
                    textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[5]);
                    i = 0;
                    this.lang = Integer.parseInt(testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                } else if (testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("11")) {
                    textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[6]);
                    i = 0;
                    this.lang = Integer.parseInt(testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                } else if (testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("12")) {
                    textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[7]);
                    i = 0;
                    this.lang = Integer.parseInt(testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                } else {
                    i = 0;
                    if (testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0].equals("5")) {
                        textView5.setText(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[8]);
                        this.lang = Integer.parseInt(testBasic.getLang_id().split(Constants.SEPARATOR_COMMA)[0]);
                    }
                }
            }
        }
        textView.setText(testBasic.getTestSeriesName());
        textView3.setText(testBasic.getTotalQuestions());
        textView6.setText(testBasic.getTimeInMins());
        textView2.setText(testBasic.getTotalMarks());
        button.setTag(testBasic);
        final Dialog dialog3 = dialog;
        final CheckBox checkBox3 = checkBox;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.fragment.QuizResultScreenNew.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (testBasic.getTotalQuestions().equalsIgnoreCase("0")) {
                    Toast.makeText(QuizResultScreenNew.this.activity, QuizResultScreenNew.this.activity.getResources().getString(R.string.please_add_question), 0).show();
                } else if (checkBox3.isChecked()) {
                    QuizResultScreenNew.this.API_GET_COMPLETE_INFO_TEST_SERIES2();
                    dialog3.dismiss();
                } else {
                    Toast.makeText(QuizResultScreenNew.this.activity, QuizResultScreenNew.this.activity.getResources().getString(R.string.please_check_following_instructions), 0).show();
                }
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
                map.merge(sectionId, Float.valueOf(floatSafe), new BiFunction() { // from class: com.appnew.android.testmodule.fragment.QuizResultScreenNew$$ExternalSyntheticLambda0
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
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.testmodule.fragment.QuizResultScreenNew.9
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem item) {
                ((TextView) v).setText(item.getTitle().toString());
                if (item.getTitle().toString().equals(QuizResultScreenNew.this.activity.getResources().getString(R.string.english))) {
                    QuizResultScreenNew.this.lang = 1;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(0).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(QuizResultScreenNew.this.activity.getResources().getString(R.string.hindi))) {
                    QuizResultScreenNew.this.lang = 2;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(1).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(QuizResultScreenNew.this.activity.getResources().getString(R.string.kannada))) {
                    QuizResultScreenNew.this.lang = 3;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(2).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(QuizResultScreenNew.this.activity.getResources().getString(R.string.malayalam))) {
                    QuizResultScreenNew.this.lang = 4;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(3).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(QuizResultScreenNew.this.activity.getResources().getString(R.string.marathi))) {
                    QuizResultScreenNew.this.lang = 5;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(4).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(QuizResultScreenNew.this.activity.getResources().getString(R.string.odia))) {
                    QuizResultScreenNew.this.lang = 6;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(5).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(QuizResultScreenNew.this.activity.getResources().getString(R.string.sanskrit))) {
                    QuizResultScreenNew.this.lang = 7;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(6).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(QuizResultScreenNew.this.activity.getResources().getString(R.string.tamil))) {
                    QuizResultScreenNew.this.lang = 8;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(7).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(QuizResultScreenNew.this.activity.getResources().getString(R.string.urdu))) {
                    QuizResultScreenNew.this.lang = 9;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(8).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(QuizResultScreenNew.this.activity.getResources().getString(R.string.bangauli))) {
                    QuizResultScreenNew.this.lang = 10;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(9).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(QuizResultScreenNew.this.activity.getResources().getString(R.string.assami))) {
                    QuizResultScreenNew.this.lang = 11;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(10).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(QuizResultScreenNew.this.activity.getResources().getString(R.string.gujrati))) {
                    QuizResultScreenNew.this.lang = 12;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(11).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
                    }
                } else if (item.getTitle().toString().equals(QuizResultScreenNew.this.activity.getResources().getString(R.string.oriya))) {
                    QuizResultScreenNew.this.lang = 13;
                    if (testBasicInst.getMulti_description().size() > 0) {
                        textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(12).getDescription()));
                    } else if (!testBasicInst.getDescription().isEmpty()) {
                        textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
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
            } else if (testBasicInst.getLang_id().split(Constants.SEPARATOR_COMMA)[i].equals("3")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[2]);
            }
            if (testBasicInst.getLang_id().split(Constants.SEPARATOR_COMMA)[i].equals("4")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[3]);
            } else if (testBasicInst.getLang_id().split(Constants.SEPARATOR_COMMA)[i].equals("5")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[4]);
            } else if (testBasicInst.getLang_id().split(Constants.SEPARATOR_COMMA)[i].equals("6")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[5]);
            } else if (testBasicInst.getLang_id().split(Constants.SEPARATOR_COMMA)[i].equals("7")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[6]);
            } else if (testBasicInst.getLang_id().split(Constants.SEPARATOR_COMMA)[i].equals("8")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[7]);
            } else if (testBasicInst.getLang_id().split(Constants.SEPARATOR_COMMA)[i].equals("9")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[8]);
            } else if (testBasicInst.getLang_id().split(Constants.SEPARATOR_COMMA)[i].equals("10")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[9]);
            } else if (testBasicInst.getLang_id().split(Constants.SEPARATOR_COMMA)[i].equals("11")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[10]);
            } else if (testBasicInst.getLang_id().split(Constants.SEPARATOR_COMMA)[i].equals("12")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[11]);
            } else if (testBasicInst.getLang_id().split(Constants.SEPARATOR_COMMA)[i].equals("13")) {
                popupMenu.getMenu().add(this.activity.getResources().getStringArray(R.array.dialog_choose_language_array)[12]);
            }
        }
        popupMenu.show();
    }

    public void showPopMenuForLangauge1(final View v, final TestBasicInst testBasicInst, final TextView v1, TextView vv) {
        PopupMenu popupMenu = new PopupMenu(this.activity, v);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.testmodule.fragment.QuizResultScreenNew.10
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem item) {
                ((TextView) v).setText(item.getTitle().toString());
                if (item.getTitle().toString().equals(QuizResultScreenNew.this.activity.getResources().getString(R.string.hindi))) {
                    QuizResultScreenNew.this.lang = 2;
                    if (testBasicInst.getMulti_description().size() > 0 && testBasicInst.getMulti_description().get(1).getDescription() != null) {
                        v1.setText(Html.fromHtml(testBasicInst.getMulti_description().get(1).getDescription()));
                    }
                } else if (item.getTitle().toString().equals(QuizResultScreenNew.this.activity.getResources().getString(R.string.english))) {
                    QuizResultScreenNew.this.lang = 1;
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

    public void API_GET_COMPLETE_INFO_TEST_SERIES2() {
        if (Helper.isNetworkConnected(getActivity())) {
            Progress progress = new Progress(this.activity);
            this.progress = progress;
            progress.show();
            APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setUser_id(SharedPreference.getInstance().getLoggedInUser().getId());
            encryptionData.setTest_id(this.status);
            encryptionData.setCourse_id(SharedPreference.getInstance().getString("id"));
            aPIInterface.API_GET_INFO_TEST_SERIES(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new Callback<String>() { // from class: com.appnew.android.testmodule.fragment.QuizResultScreenNew.11
                @Override // retrofit2.Callback
                public void onResponse(Call<String> call, Response<String> response) {
                    JSONObject jSONObject;
                    QuizResultScreenNew.this.mprogress.dismiss();
                    if (response.body() != null) {
                        try {
                            jSONObject = new JSONObject(AES.decrypt(response.body(), AES.generatekeyAPI(), AES.generateVectorAPI()));
                        } catch (Exception unused) {
                            response.body();
                            jSONObject = null;
                        }
                        if (jSONObject == null) {
                            Log.d("Security_Toast", "due to api response null ");
                            Helper.showToastSecurity(QuizResultScreenNew.this.activity);
                            return;
                        }
                        try {
                            MakeMyExam.setTime_server(Long.parseLong(jSONObject.optString("time")) * 1000);
                            if (jSONObject.optString("status").equals("true")) {
                                try {
                                    TestseriesBase testseriesBase = (TestseriesBase) new Gson().fromJson(jSONObject.toString(), TestseriesBase.class);
                                    if (QuizResultScreenNew.this.langIds != null && QuizResultScreenNew.this.langIds.length > 0) {
                                        boolean z = true;
                                        if (QuizResultScreenNew.this.lang == 1) {
                                            if (testseriesBase.getData().getQuestions() == null || testseriesBase.getData().getQuestions().isEmpty()) {
                                                Toast.makeText(QuizResultScreenNew.this.activity, "All questions may not be available in English language.", 0).show();
                                                return;
                                            }
                                        } else if (QuizResultScreenNew.this.lang == 2 && (testseriesBase.getData().getQuestionsHindi() == null || testseriesBase.getData().getQuestionsHindi().isEmpty())) {
                                            Toast.makeText(QuizResultScreenNew.this.activity, "All questions may not be available in Hindi language.", 0).show();
                                            return;
                                        }
                                        if (QuizResultScreenNew.this.langIds.length > 1) {
                                            boolean z2 = testseriesBase.getData().getQuestions() == null || testseriesBase.getData().getQuestions().isEmpty();
                                            if (testseriesBase.getData().getQuestionsHindi() != null && !testseriesBase.getData().getQuestionsHindi().isEmpty()) {
                                                z = false;
                                            }
                                            if (z2 && z) {
                                                Toast.makeText(QuizResultScreenNew.this.activity, "All questions may not be available in both languages.", 0).show();
                                                return;
                                            }
                                        }
                                        Intent intent = new Intent(QuizResultScreenNew.this.activity, (Class<?>) TestBaseActivity.class);
                                        intent.putExtra("status", false);
                                        intent.putExtra(Const.TEST_SERIES_ID, QuizResultScreenNew.this.status);
                                        intent.putExtra(Const.TEST_SERIES_Name, QuizResultScreenNew.this.testSeriesName);
                                        intent.putExtra("test_series", testseriesBase);
                                        intent.putExtra("first_attempt", "0");
                                        intent.putExtra(Const.LANG, QuizResultScreenNew.this.lang);
                                        QuizResultScreenNew.this.activity.startActivity(intent);
                                        QuizResultScreenNew.this.activity.finish();
                                        return;
                                    }
                                    Toast.makeText(QuizResultScreenNew.this.activity, "Language not found!", 0).show();
                                    return;
                                } catch (Exception unused2) {
                                    Toast.makeText(QuizResultScreenNew.this.activity, QuizResultScreenNew.this.activity.getResources().getString(R.string.something_went_wrong), 0).show();
                                    return;
                                }
                            }
                            RetrofitResponse.GetApiData(QuizResultScreenNew.this.activity, jSONObject.optString("auth_code"), jSONObject.optString("message"), false);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<String> call, Throwable t) {
                    QuizResultScreenNew.this.progress.hide();
                    Toast.makeText(QuizResultScreenNew.this.activity, QuizResultScreenNew.this.activity.getResources().getString(R.string.something_went_wrong), 0).show();
                }
            });
            return;
        }
        Toast.makeText(getActivity(), this.activity.getResources().getString(R.string.Retry_with_Internet_connection), 1).show();
    }

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.frag_type = getArguments().getString(Const.FRAG_TYPE);
            this.quiz = (QuizModel) getArguments().getSerializable(Const.RESULT_SCREEN);
            this.status = getArguments().getString("status");
            this.testSeriesName = getArguments().getString("name");
            this.first_attempt = getArguments().getString("first_attempt");
            this.show_leader = getArguments().getString("show_leader");
        }
        this.showCertificate = SharedPreference.getInstance().getString(Const.SHOW_CERTIFICATE);
        this.activity = getActivity();
        this.ssEnabled = SharedPreference.getInstance().getString(Const.ENABLE_TEST_SCREENSHOT);
    }

    private void downloadPDF(String data) {
        PostFile postFile = new PostFile();
        postFile.setLink(data);
        postFile.setFile_type(Const.PDF);
        String str = data.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[data.split(MqttTopic.TOPIC_LEVEL_SEPARATOR).length - 1];
        if (!str.contains("")) {
            postFile.setFile_info(data.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[data.split(MqttTopic.TOPIC_LEVEL_SEPARATOR).length - 1]);
        } else {
            postFile.setFile_info(str.replaceAll(" ", "_"));
        }
        try {
            ((QuizActivity) this.activity).myPermissionConstantsArrayList = new ArrayList<>();
            ((QuizActivity) this.activity).myPermissionConstantsArrayList.add(AppPermissionsRunTime.MyPermissionConstants.PERMISSION_READ_EXTERNAL_STORAGE);
            ((QuizActivity) this.activity).myPermissionConstantsArrayList.add(AppPermissionsRunTime.MyPermissionConstants.PERMISSION_WRITE_EXTERNAL_STORAGE);
            Activity activity = this.activity;
            ArrayList<AppPermissionsRunTime.MyPermissionConstants> arrayList = ((QuizActivity) activity).myPermissionConstantsArrayList;
            Objects.requireNonNull((QuizActivity) this.activity);
            if (AppPermissionsRunTime.checkPermission(activity, arrayList, 123)) {
                if (Helper.getStorageInstance(this.activity).getRecordObject(Const.PDF) != null) {
                    Helper.DownloadfilefromURL(this.activity, (PostFile) Helper.getStorageInstance(this.activity).getRecordObject(Const.PDF));
                    Helper.getStorageInstance(this.activity).deleteRecord(Const.PDF);
                    return;
                }
                Helper.DownloadfilefromURL(this.activity, postFile);
                return;
            }
            Helper.getStorageInstance(this.activity).addRecordStore(Const.PDF, postFile);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void API_DOWNLOAD_CERTIFICATE() {
        if (Helper.isNetworkConnected(getActivity())) {
            Progress progress = new Progress(this.activity);
            this.progress = progress;
            progress.show();
            APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setCourse_id(SharedPreference.getInstance().getString("id"));
            encryptionData.setTest_id(this.status);
            encryptionData.setFirst_attempt(this.first_attempt);
            aPIInterface.API_DOWNLOAD_CERTIFICATE(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new Callback<String>() { // from class: com.appnew.android.testmodule.fragment.QuizResultScreenNew.12
                @Override // retrofit2.Callback
                public void onResponse(Call<String> call, Response<String> response) {
                    JSONObject jSONObject;
                    QuizResultScreenNew.this.progress.dismiss();
                    try {
                        if (response.body() != null) {
                            try {
                                jSONObject = new JSONObject(AES.decrypt(response.body(), AES.generatekeyAPI(), AES.generateVectorAPI()));
                            } catch (Exception unused) {
                                response.body();
                                jSONObject = null;
                            }
                            if (jSONObject == null) {
                                Log.d("Security_Toast", "due to api response null ");
                                Helper.showToastSecurity(QuizResultScreenNew.this.activity);
                                return;
                            }
                            try {
                                MakeMyExam.setTime_server(Long.parseLong(jSONObject.optString("time")) * 1000);
                                if (jSONObject.optString("status").equals("true")) {
                                    QuizResultScreenNew.this.liveAwsActivityInstanceDownload(jSONObject.optJSONObject("data").optString("file_url"));
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<String> call, Throwable t) {
                    QuizResultScreenNew.this.progress.hide();
                    Toast.makeText(QuizResultScreenNew.this.activity, QuizResultScreenNew.this.activity.getResources().getString(R.string.something_went_wrong), 0).show();
                }
            });
            return;
        }
        Toast.makeText(getActivity(), this.activity.getResources().getString(R.string.Retry_with_Internet_connection), 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void liveAwsActivityInstanceDownload(String data) {
        PostFile postFile = new PostFile();
        postFile.setLink(data);
        postFile.setFile_type(Const.COURSE_INVOICE);
        String str = data.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[data.split(MqttTopic.TOPIC_LEVEL_SEPARATOR).length - 1];
        if (!str.contains("")) {
            postFile.setFile_info(data.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[data.split(MqttTopic.TOPIC_LEVEL_SEPARATOR).length - 1]);
        } else {
            postFile.setFile_info(str.replaceAll(" ", "_"));
        }
        try {
            ((QuizActivity) this.activity).myPermissionConstantsArrayList = new ArrayList<>();
            ((QuizActivity) this.activity).myPermissionConstantsArrayList.add(AppPermissionsRunTime.MyPermissionConstants.PERMISSION_READ_EXTERNAL_STORAGE);
            ((QuizActivity) this.activity).myPermissionConstantsArrayList.add(AppPermissionsRunTime.MyPermissionConstants.PERMISSION_WRITE_EXTERNAL_STORAGE);
            Activity activity = this.activity;
            ArrayList<AppPermissionsRunTime.MyPermissionConstants> arrayList = ((QuizActivity) activity).myPermissionConstantsArrayList;
            Objects.requireNonNull((QuizActivity) this.activity);
            if (AppPermissionsRunTime.checkPermission(activity, arrayList, 123)) {
                if (Helper.getStorageInstance(this.activity).getRecordObject(Const.COURSE_INVOICE) != null) {
                    Helper.DownloadfilefromURL(this.activity, (PostFile) Helper.getStorageInstance(this.activity).getRecordObject(Const.COURSE_INVOICE));
                    Helper.getStorageInstance(this.activity).deleteRecord(Const.COURSE_INVOICE);
                    return;
                }
                Helper.DownloadfilefromURL(this.activity, postFile);
                return;
            }
            Helper.DownloadfilefromURL(this.activity, postFile);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
