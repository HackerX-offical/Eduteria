package com.appnew.android.testmodule.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.appnew.android.BuildConfig;
import com.appnew.android.Courses.Activity.QuizActivity;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.LiveClass.interface_.OnDataSendListener;
import com.appnew.android.Model.Courses.quiz.ResultTestSeries;
import com.appnew.android.Model.MediaFile;
import com.appnew.android.Model.ResumeNewDump;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.R;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.AmazonUpload.AmazonCallBack;
import com.appnew.android.Utils.AmazonUpload.s3ImageUploading;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.CustomContextWrapper;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.Progress;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.ToastManager;
import com.appnew.android.home.Constants;
import com.appnew.android.table.TestResumeTable;
import com.appnew.android.table.TestTable;
import com.appnew.android.testmodule.adapter.MyRecyclerAdapter;
import com.appnew.android.testmodule.adapter.MyRecyclerAdapterTwo;
import com.appnew.android.testmodule.adapter.PartAdapter;
import com.appnew.android.testmodule.adapter.TestViewPagerAdapter;
import com.appnew.android.testmodule.fragment.FIB_TestSeriesFragment;
import com.appnew.android.testmodule.fragment.Instant_TestSeriesFragment;
import com.appnew.android.testmodule.fragment.SC_TestSeriesFragment;
import com.appnew.android.testmodule.interfaces.NumberPadOnClick;
import com.appnew.android.testmodule.layoutmanager.LinearLayoutManagerWithSmoothScroller;
import com.appnew.android.testmodule.model.Answers;
import com.appnew.android.testmodule.model.Data;
import com.appnew.android.testmodule.model.InstructionData;
import com.appnew.android.testmodule.model.QuesReportOption;
import com.appnew.android.testmodule.model.Question;
import com.appnew.android.testmodule.model.QuestionDump;
import com.appnew.android.testmodule.model.ResumeDump;
import com.appnew.android.testmodule.model.Social;
import com.appnew.android.testmodule.model.TestBasic;
import com.appnew.android.testmodule.model.TestBasicInst;
import com.appnew.android.testmodule.model.TestSection;
import com.appnew.android.testmodule.model.TestSectionInst;
import com.appnew.android.testmodule.model.TestseriesBase;
import com.appnew.android.testmodule.model.TopicModel;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.appevents.UserDataStore;
import com.google.android.material.snackbar.Snackbar;
import com.google.common.base.Ascii;
import com.google.gson.Gson;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.jivesoftware.smack.packet.Session;
import org.joda.time.DateTimeConstants;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes6.dex */
public class TestBaseActivity extends AppCompatActivity implements View.OnClickListener, NumberPadOnClick, AmazonCallBack {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "TestBaseActivity";
    private static Dialog calculator_dialog = null;
    public static String currentSectionIdforTest = "";
    public static int nestbg = 0;
    public static int nestcirclebg = 0;
    public static String resumeSectionIdforTest = "";
    String LANG;
    String PartId;
    public ArrayList<Answers> answerList;
    int attemptCount;
    public TestBasic basicInfo;
    private TextView btnClear;
    private FrameLayout btnNext;
    private FrameLayout btnPrev;
    private Button btn_exam_instructions;
    private FrameLayout btn_finish;
    private Button btn_submit;
    Button buttonRad;
    ImageView calci;
    public TextView changelang;
    private RelativeLayout clSpinner;
    Context context;
    public Data data;
    TextView degreeRad;
    private DrawerLayout drawerLayout;
    ImageView dropdown_icon;
    private Long enddate;
    public String first_attempt;
    TextView gridView;
    private ImageView imgPause;
    private ImageView imgTestBack;
    private ImageView imgTestMenu;
    private List<ViewModel> items;
    int lang;
    ImageView langimage;
    public int language;
    TextView languageSpinnerTV;
    String lastView;
    TextView listView;
    private LinearLayout llDrawerRight;
    private LinearLayout llMarkForReview;
    private LinearLayout llMarkForReviewCount;
    Progress mProgress;
    int markforreviewCount;
    long milliLeft;
    long millisInFuture;
    long min;
    Button move_to_section;
    TextView nextTV;
    private NumberPadOnClick numberPadOnClick;
    TextView outputResult;
    public TestViewPagerAdapter pagerAdapter;
    PartAdapter partAdapter;
    PopupWindow popUp;
    PopupWindow popupWindow;
    int prevSeconds;
    public Handler quesTimeHandler;
    public List<Question> questionBankList;
    public List<QuestionDump> questionDumpList;
    Dialog quizBasicInfoDialog;
    long remainingTime;
    long remainingTime_noSwitch;
    ResultTestSeries resultTestSeries;
    ResumeDump resumeDump;
    String resumeTestId;
    String resume_lastSection;
    public List<Question> resumedumpresponselist;
    private RecyclerView rlQuestionPad;
    private MyRecyclerAdapter rvNumberPadAdapter;
    private RecyclerView rvNumberpad;
    private MyRecyclerAdapterTwo rvQuestionAdapter;
    int savemarkforreviewCount;
    private Fragment sc_testSeriesFragment;
    HorizontalScrollView scrollView;
    long sec;
    TextView shiftDisplay;
    int skipedQuestion;
    String state;
    String testDump;
    String testID;
    TextView testSeriesName;
    public String testSeriesname;
    FrameLayout testlayout;
    public TestseriesBase testseriesBase;
    public String testseriesid;
    private TextView textSpinner;
    private Long time_server;
    Toolbar toolbar;
    private TextView tvQuestionnumber;
    private TextView tvSkipCount;
    private TextView tvTime;
    private TextView tvUnAnswerCount;
    private TextView tv_savemarkforReview_count;
    public TextView tv_timer;
    private TextView tvanswerCount;
    private TextView tvmarkForReviewCount;
    int unattampedcount;
    View viewMarkForReviewCount;
    private ViewPager viewPagerTest;
    public static int[] SAMPLE_BG = {R.drawable.bg_mcq_selected, com.eduteria.app.app.R.drawable.bg_mcq_selected1, com.eduteria.app.app.R.drawable.bg_mcq_selected2, com.eduteria.app.app.R.drawable.bg_mcq_selected3, com.eduteria.app.app.R.drawable.bg_mcq_selected4, com.eduteria.app.app.R.drawable.bg_mcq_selected5, com.eduteria.app.app.R.drawable.bg_mcq_selected6, com.eduteria.app.app.R.drawable.bg_mcq_selected7, com.eduteria.app.app.R.drawable.bg_mcq_selected8, com.eduteria.app.app.R.drawable.bg_mcq_selected9};
    public static int[] SAMPLE_CIRCLE = {com.eduteria.app.app.R.drawable.circle, com.eduteria.app.app.R.drawable.circle1, com.eduteria.app.app.R.drawable.circle2, com.eduteria.app.app.R.drawable.circle3, com.eduteria.app.app.R.drawable.circle4, com.eduteria.app.app.R.drawable.circle5, com.eduteria.app.app.R.drawable.circle6, com.eduteria.app.app.R.drawable.circle7, com.eduteria.app.app.R.drawable.circle8, com.eduteria.app.app.R.drawable.circle9};
    public static int matchingPosition = -1;
    public static int matchingPositiondrag = -1;
    public static boolean nestselected = false;
    public static boolean sameselected = false;
    private static OnDataSendListener dataSendListener = null;
    public String course_id = "";
    public String result_date = "";
    public String test_submission = "";
    public String attemptOrReAttempt = "";
    public String live_test_feedback = "";
    boolean isPracticeOrReAttempt = false;
    boolean sectionSwitch = false;
    boolean StartTime = false;
    public int currentPage = 0;
    int count1 = 1;
    int sectionCount = 1;
    int testPauseCount = 0;
    boolean pauseCount = true;
    boolean isPause = false;
    boolean testTimeFinish = false;
    public ArrayList<TestSection> partList = new ArrayList<>();
    public ArrayList<TestSection> partList1 = new ArrayList<>();
    public ArrayList<TestSection> filteredPartListToDisplay = new ArrayList<>();
    public ArrayList<Question> questionBankList2 = new ArrayList<>();
    boolean status = false;
    long count = 0;
    List<String> questionPart = new ArrayList();
    private ArrayList<Fragment> mFragmentList = new ArrayList<>();
    private boolean isPaused = false;
    private CountDownTimer countDownTimer = null;
    private boolean isForceFinish = true;
    public List<Social> items1 = new ArrayList();
    public List<Social> items2 = new ArrayList();
    boolean testsubmit = false;
    boolean builderShowing = false;
    String PREFS_NAME = "memory";
    String currentDisplayedInput = "";
    String inputToBeParsed = "";
    boolean isInverse = false;
    String lastResultObtain = "";
    public boolean clickedStauts = true;
    int lastSection = 0;
    boolean resume_section_status = false;
    private int noOfQus = 1;
    public int seconds = 0;
    public Runnable runnable = new Runnable() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity.18
        @Override // java.lang.Runnable
        public void run() {
            Log.d("TotalTimeSpentClass", "seconds: " + TestBaseActivity.this.seconds + "\nmilliLeft: " + TestBaseActivity.this.milliLeft);
            if (TestBaseActivity.this.milliLeft > 0) {
                TestBaseActivity.this.seconds++;
                TestBaseActivity.this.tv_timer.setText(String.format(Locale.getDefault(), "%02d:%02d:%02d", Integer.valueOf(TestBaseActivity.this.seconds / 3600), Integer.valueOf((TestBaseActivity.this.seconds % 3600) / 60), Integer.valueOf(TestBaseActivity.this.seconds % 60)));
                TestBaseActivity.this.quesTimeHandler.postDelayed(this, 1000L);
            }
        }
    };
    private List<TextView> topicTextViews = new ArrayList();
    private int selectedTopicIndex = -1;
    private List<TopicModel> validTopics = new ArrayList();
    private boolean nextOrPreButtonClicked = false;
    private int userClickedPositionUpdate = 0;

    private String checkTitle1(String title, int position) {
        return title;
    }

    public static void setOnDataSendListener(OnDataSendListener listener) {
        dataSendListener = listener;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context newBase) {
        String str;
        if (SharedPreference.getInstance().getInt(Const.LANGUAGE) == 2) {
            str = Const.HINDI;
        } else {
            str = Const.ENGLISH;
        }
        super.attachBaseContext(CustomContextWrapper.wrap(newBase, str));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        if (SharedPreference.getInstance().getString(Const.CUSTOM_TESTSERIES_UI).equalsIgnoreCase("1")) {
            setContentView(com.eduteria.app.app.R.layout.activity_test_base_new);
        } else {
            setContentView(com.eduteria.app.app.R.layout.activity_test_base);
        }
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) { // from class: com.appnew.android.testmodule.activity.TestBaseActivity.1
            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                TestBaseActivity.this.handleBackPressed();
            }
        });
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());
        getWindow().addFlags(128);
        int i = SharedPreference.getInstance().getInt(Const.LANGUAGE);
        if (i == 1) {
            Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
        } else if (i == 2) {
            Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.HINDI), this);
        }
        this.context = this;
        SharedPreference.getInstance().putString("VIEW", "0");
        setReference();
        this.language = getIntent().getExtras().getInt(Const.LANG);
        if (getIntent().hasExtra("hideLeaderBoard")) {
            this.isPracticeOrReAttempt = getIntent().getExtras().getString("hideLeaderBoard").equalsIgnoreCase("1");
        }
        if (!SharedPreference.getInstance().getString("test_series").equalsIgnoreCase("")) {
            String string = SharedPreference.getInstance().getString("test_series");
            this.testseriesBase = (TestseriesBase) new Gson().fromJson(string, TestseriesBase.class);
            Log.e("Test Series: ", "onCreate: " + string.toString());
            if (this.testseriesBase.getData().getTestBasic().getTest_assets() == null || this.testseriesBase.getData().getTestBasic().getTest_assets().getDisable_sec_click().equalsIgnoreCase("0")) {
                this.dropdown_icon.setOnClickListener(this);
                this.clSpinner.setOnClickListener(this);
            }
            if (!BuildConfig.FLAVOR.equalsIgnoreCase("mahendra") && !BuildConfig.FLAVOR.equalsIgnoreCase("banglaguru")) {
                if (this.testseriesBase.getData().getTestBasic().getLangId().size() == 2) {
                    this.changelang.setVisibility(8);
                    this.langimage.setVisibility(0);
                    this.data = this.testseriesBase.getData();
                    if (this.language == 2) {
                        this.changelang.setText(getResources().getString(com.eduteria.app.app.R.string.e_h));
                        this.questionBankList = this.data.getQuestionsHindi();
                    } else {
                        this.changelang.setText(getResources().getString(com.eduteria.app.app.R.string.h_e));
                        this.questionBankList = this.data.getQuestions();
                    }
                } else {
                    int i2 = this.language;
                    if (i2 == 1 || i2 == 0) {
                        this.changelang.setVisibility(8);
                        this.langimage.setVisibility(8);
                        this.changelang.setText("");
                        Data data = this.testseriesBase.getData();
                        this.data = data;
                        this.questionBankList = data.getQuestions();
                    } else if (i2 == 2 && this.testseriesBase.getData().getQuestionsHindi() != null && this.testseriesBase.getData().getQuestionsHindi().size() > 0) {
                        this.data = this.testseriesBase.getData();
                        this.testseriesBase.getData().setQuestions(this.testseriesBase.getData().getQuestionsHindi());
                        this.questionBankList = this.data.getQuestions();
                        this.changelang.setVisibility(8);
                        this.langimage.setVisibility(8);
                    }
                }
            } else if (this.testseriesBase.getData().getTestBasic().getLangId().size() > 1) {
                this.changelang.setVisibility(8);
                this.langimage.setVisibility(8);
                this.data = this.testseriesBase.getData();
                int i3 = this.language;
                if (i3 == 1 || i3 == 2) {
                    this.changelang.setText("E/H");
                    this.questionBankList = this.data.getQuestionsHindi();
                } else if (i3 == 3) {
                    this.changelang.setText("E/K");
                    this.questionBankList = this.data.getQuestions_kannada();
                } else if (i3 == 9) {
                    this.changelang.setText("E/U");
                    this.questionBankList = this.data.getQuestions_urdu();
                } else if (i3 == 6) {
                    this.changelang.setText("E/U");
                    this.questionBankList = this.data.getQuestions_uriya();
                } else if (i3 == 10) {
                    this.changelang.setText("E/B");
                    this.questionBankList = this.data.getQuestions_bangauli();
                } else if (i3 == 11) {
                    this.changelang.setText("E/A");
                    this.questionBankList = this.data.getQuestions_assami();
                } else if (i3 == 12) {
                    this.changelang.setText("E/G");
                    this.questionBankList = this.data.getQuestions_gujrati();
                } else if (i3 == 5) {
                    this.changelang.setText("E/M");
                    this.questionBankList = this.data.getQuestions_marathi();
                } else {
                    this.changelang.setText("H/E");
                    this.questionBankList = this.data.getQuestions();
                }
            } else {
                int i4 = this.language;
                if (i4 == 1 || i4 == 0) {
                    this.changelang.setVisibility(8);
                    this.langimage.setVisibility(8);
                    this.changelang.setText("");
                    Data data2 = this.testseriesBase.getData();
                    this.data = data2;
                    this.questionBankList = data2.getQuestions();
                } else if (i4 == 2) {
                    this.changelang.setVisibility(8);
                    this.langimage.setVisibility(8);
                    this.changelang.setText("");
                    Data data3 = this.testseriesBase.getData();
                    this.data = data3;
                    this.questionBankList = data3.getQuestionsHindi();
                } else if (i4 == 3) {
                    this.changelang.setVisibility(8);
                    this.langimage.setVisibility(8);
                    this.changelang.setText("");
                    Data data4 = this.testseriesBase.getData();
                    this.data = data4;
                    this.questionBankList = data4.getQuestions_kannada();
                } else if (i4 == 9) {
                    this.changelang.setVisibility(8);
                    this.langimage.setVisibility(8);
                    this.changelang.setText("");
                    Data data5 = this.testseriesBase.getData();
                    this.data = data5;
                    this.questionBankList = data5.getQuestions_urdu();
                } else if (i4 == 6) {
                    this.changelang.setVisibility(8);
                    this.langimage.setVisibility(8);
                    this.changelang.setText("");
                    Data data6 = this.testseriesBase.getData();
                    this.data = data6;
                    this.questionBankList = data6.getQuestions_uriya();
                } else if (i4 == 10) {
                    this.changelang.setVisibility(8);
                    this.langimage.setVisibility(8);
                    this.changelang.setText("");
                    Data data7 = this.testseriesBase.getData();
                    this.data = data7;
                    this.questionBankList = data7.getQuestions_bangauli();
                } else if (i4 == 11) {
                    this.changelang.setVisibility(8);
                    this.langimage.setVisibility(8);
                    this.changelang.setText("");
                    Data data8 = this.testseriesBase.getData();
                    this.data = data8;
                    this.questionBankList = data8.getQuestions_assami();
                } else if (i4 == 12) {
                    this.changelang.setVisibility(8);
                    this.langimage.setVisibility(8);
                    this.changelang.setText("");
                    Data data9 = this.testseriesBase.getData();
                    this.data = data9;
                    this.questionBankList = data9.getQuestions_gujrati();
                } else if (i4 == 5) {
                    this.changelang.setVisibility(8);
                    this.langimage.setVisibility(8);
                    this.changelang.setText("");
                    Data data10 = this.testseriesBase.getData();
                    this.data = data10;
                    this.questionBankList = data10.getQuestions_marathi();
                } else if (i4 == 2 && this.testseriesBase.getData().getQuestionsHindi() != null && this.testseriesBase.getData().getQuestionsHindi().size() > 0) {
                    this.data = this.testseriesBase.getData();
                    this.testseriesBase.getData().setQuestions(this.testseriesBase.getData().getQuestionsHindi());
                    this.questionBankList = this.data.getQuestions();
                    this.changelang.setVisibility(8);
                    this.langimage.setVisibility(8);
                }
            }
        } else {
            TestseriesBase testseriesBase = (TestseriesBase) ((Bundle) Objects.requireNonNull(getIntent().getExtras())).getSerializable("test_series");
            this.testseriesBase = testseriesBase;
            Data data11 = testseriesBase.getData();
            this.data = data11;
            this.questionBankList = data11.getQuestions();
            this.changelang.setVisibility(8);
            this.langimage.setVisibility(8);
        }
        this.testseriesid = getIntent().getExtras().getString(Const.TEST_SERIES_ID);
        this.first_attempt = getIntent().getExtras().getString("first_attempt");
        this.attemptOrReAttempt = getIntent().getExtras().getString("attemptOrReAttempt");
        this.live_test_feedback = SharedPreference.getInstance().getString(Const.LIVE_TEST_FEEDBACK);
        Log.e("TAG_APP", "onCreate: " + this.attemptOrReAttempt);
        if (this.first_attempt.equalsIgnoreCase("1")) {
            this.time_server = Long.valueOf(getIntent().getExtras().getLong("time", 0L));
            if (getIntent().getExtras().getString("enddate") != null) {
                this.enddate = Long.valueOf(getIntent().getExtras().getString("enddate"));
            }
        }
        this.result_date = getIntent().getExtras().getString("result_date");
        this.course_id = getIntent().getExtras().getString("course_id");
        String string2 = getIntent().getExtras().getString("test_submission");
        this.test_submission = string2;
        if (string2 != null && string2.equalsIgnoreCase("0")) {
            this.test_submission = "0";
        } else {
            this.test_submission = "1";
        }
        this.data = this.testseriesBase.getData();
        TestBasic testBasic = this.testseriesBase.getData().getTestBasic();
        this.basicInfo = testBasic;
        this.testSeriesName.setText(testBasic.getTestSeriesName());
        this.testSeriesName.setSelected(true);
        Progress progress = new Progress(this);
        this.mProgress = progress;
        progress.setCancelable(false);
        setTestData();
        setTimerN();
        CountTotalanswer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleBackPressed() {
        this.isPause = true;
        showPopupSubmitTest();
    }

    public void CountTotalanswer() {
        int i = 0;
        this.unattampedcount = 0;
        this.attemptCount = 0;
        this.skipedQuestion = 0;
        this.markforreviewCount = 0;
        this.savemarkforreviewCount = 0;
        List<QuestionDump> list = this.questionDumpList;
        if (list != null && list.size() > 0) {
            while (i < this.questionBankList2.size()) {
                if (this.questionBankList2.get(i).isMarkForReview() && this.questionBankList2.get(i).getAnswerPosttion() != -1 && this.questionBankList2.get(i).getAnswerPosttion() != 0) {
                    this.savemarkforreviewCount++;
                } else if (this.questionBankList2.get(i).isMarkForReview()) {
                    this.markforreviewCount++;
                } else if (this.questionBankList2.get(i).getAnswerPosttion() == -1) {
                    this.skipedQuestion++;
                } else if (this.questionBankList2.get(i).getAnswerPosttion() == 0) {
                    this.unattampedcount++;
                } else if (this.questionBankList2.get(i).getAnswerPosttion() != -1 && this.questionBankList2.get(i).getAnswerPosttion() != 0) {
                    this.attemptCount++;
                }
                i++;
            }
        } else {
            while (i < this.questionBankList.size()) {
                if (this.questionBankList.get(i).isMarkForReview() && this.questionBankList.get(i).getAnswerPosttion() != -1 && this.questionBankList.get(i).getAnswerPosttion() != 0) {
                    this.savemarkforreviewCount++;
                } else if (this.questionBankList.get(i).isMarkForReview()) {
                    this.markforreviewCount++;
                } else if (this.questionBankList.get(i).getAnswerPosttion() == -1) {
                    this.skipedQuestion++;
                } else if (this.questionBankList.get(i).getAnswerPosttion() == 0) {
                    this.unattampedcount++;
                } else if (this.questionBankList.get(i).getAnswerPosttion() != -1 && this.questionBankList.get(i).getAnswerPosttion() != 0) {
                    this.attemptCount++;
                }
                i++;
            }
        }
        this.rvQuestionAdapter.notifyDataSetChanged();
        this.tvanswerCount.setText(String.valueOf(this.attemptCount));
        this.tvUnAnswerCount.setText(String.valueOf(this.unattampedcount));
        this.tvSkipCount.setText(String.valueOf(this.skipedQuestion));
        this.tvmarkForReviewCount.setText(String.valueOf(this.markforreviewCount));
        this.tv_savemarkforReview_count.setText(String.valueOf(this.savemarkforreviewCount));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v73 */
    /* JADX WARN: Type inference failed for: r11v74, types: [int] */
    /* JADX WARN: Type inference failed for: r11v76 */
    /* JADX WARN: Type inference failed for: r17v0, types: [android.app.Activity, android.content.Context, com.appnew.android.testmodule.activity.TestBaseActivity, com.appnew.android.testmodule.interfaces.NumberPadOnClick] */
    /* JADX WARN: Type inference failed for: r4v14, types: [int] */
    /* JADX WARN: Type inference failed for: r4v50 */
    /* JADX WARN: Type inference failed for: r4v51 */
    /* JADX WARN: Type inference failed for: r5v10, types: [int] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v62 */
    /* JADX WARN: Type inference failed for: r5v63 */
    /* JADX WARN: Type inference failed for: r5v64 */
    /* JADX WARN: Type inference failed for: r5v65 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.lang.StringBuilder] */
    private void setTestData() {
        ArrayList<TestSection> arrayList;
        Boolean bool;
        Boolean bool2;
        TestBasic testBasic = this.testseriesBase.getData().getTestBasic();
        boolean z = false;
        if (!SharedPreference.getInstance().getString(Const.CUSTOM_TESTSERIES_UI).equalsIgnoreCase("1")) {
            if (testBasic.getDisplay_bubble() == null || testBasic.getDisplay_bubble().equalsIgnoreCase("") || testBasic.getDisplay_bubble().equalsIgnoreCase("1")) {
                this.rvNumberpad.setVisibility(0);
            } else {
                this.rvNumberpad.setVisibility(8);
            }
        } else {
            this.rvNumberpad.setVisibility(8);
        }
        if (Helper.isTestResume(this.testseriesBase.getData().getTestBasic().getSetType()) && this.first_attempt.equalsIgnoreCase("1")) {
            if (this.testseriesBase.getData().getResume_dump().getQuestion_dump() != null) {
                String str = "{\"question_dump\":" + this.testseriesBase.getData().getResume_dump().getQuestion_dump() + "}";
                this.testPauseCount = Integer.parseInt(this.testseriesBase.getData().getResume_dump().getLast_view());
                this.resumeTestId = this.testseriesBase.getData().getResume_dump().getTest_series_id();
                this.remainingTime_noSwitch = Long.parseLong(this.testseriesBase.getData().getResume_dump().getTime_remain());
                this.questionDumpList = ((ResumeNewDump) new Gson().fromJson(str, ResumeNewDump.class)).getQuestion_dump();
                resumeSectionIdforTest = this.questionBankList.get(this.testPauseCount).getSubjectId();
                this.partList1 = (ArrayList) this.data.getTestSections();
                for (int i = 0; i < this.partList1.size() && !this.partList1.get(i).getSectionId().equalsIgnoreCase(resumeSectionIdforTest); i++) {
                    int i2 = this.sectionCount + 1;
                    this.sectionCount = i2;
                    this.count1 = i2;
                }
                this.testseriesBase.getData().setLastSection(String.valueOf(this.count1));
            } else {
                resumeSectionIdforTest = this.questionBankList.get(this.testPauseCount).getSubjectId();
                this.testseriesBase.getData().setLastSection("");
            }
            String lastSection = this.testseriesBase.getData().getLastSection();
            this.resume_lastSection = lastSection;
            if (lastSection != null && !lastSection.equals("")) {
                this.lastSection = Integer.parseInt(this.resume_lastSection) - 1;
            } else {
                this.lastSection = 0;
            }
            List<QuestionDump> list = this.questionDumpList;
            if (list != null && list.size() > 0) {
                for (int i3 = 0; i3 < this.questionBankList.size(); i3++) {
                    try {
                        Question question = new Question();
                        question.setAnswerPosition(Integer.parseInt(this.questionDumpList.get(i3).getAnswerPosition()));
                        question.setAnswers(this.questionDumpList.get(i3).getAnswers());
                        question.setSelectedString(this.questionDumpList.get(i3).getSelectedString());
                        question.setSelectedValue(this.questionDumpList.get(i3).getSelectedValue());
                        question.setConfigId(this.questionDumpList.get(i3).getConfigId());
                        question.setSectionId(this.questionDumpList.get(i3).getSectionId());
                        question.setSubjectId(this.questionDumpList.get(i3).getSubjectId());
                        question.setIs_bookmarked(this.questionDumpList.get(i3).getIs_bookmarked());
                        question.setTotalTimeSpent(this.questionDumpList.get(i3).getOn_screen());
                        question.setIsanswer(this.questionDumpList.get(i3).isIsanswer());
                        question.setSection_question_behaviour(this.questionDumpList.get(i3).getSection_question_behaviour());
                        this.questionBankList2.add(question);
                    } catch (Exception unused) {
                    }
                    this.testseriesBase.setLastanswerPosition(i3);
                    boolean z2 = z;
                    boolean z3 = z2;
                    boolean z4 = z3 ? 1 : 0;
                    ?? r4 = z2;
                    ?? r5 = z3;
                    while (r4 < this.questionDumpList.size()) {
                        ArrayList arrayList2 = new ArrayList();
                        boolean z5 = z;
                        if (this.questionDumpList.get(r4).getConfigId().equals(this.questionBankList.get(i3).getConfigId())) {
                            if (this.questionDumpList.get(r4).getAnswers().size() > 0) {
                                r5 = r5;
                                for (?? r11 = z5; r11 < this.questionDumpList.get(r4).getAnswers().size(); r11++) {
                                    if (this.questionDumpList.get(r4).getAnswers().get(r11).equalsIgnoreCase("1")) {
                                        r5 = r11 + 1;
                                        Log.e(Const.ANSWER, "" + r5);
                                        arrayList2.addAll(this.questionDumpList.get(r4).getAnswers());
                                        z4 = true;
                                    }
                                    r5 = r5;
                                }
                            }
                            this.questionBankList.get(i3).setIsanswer(z4, r5 == true ? 1 : 0, arrayList2);
                            List<QuestionDump> list2 = this.questionDumpList;
                            if (list2 != null && list2.size() > 0) {
                                this.questionDumpList.get(i3).setReview((this.questionDumpList.get(r4).getAnswer().equals("0") || this.questionDumpList.get(r4).getAnswer().isEmpty()) ? "0" : "1");
                            } else {
                                this.questionBankList.get(i3).setIsanswer(z4, r5 == true ? 1 : 0);
                                if (this.questionDumpList.get(r4).getOn_screen() == 0) {
                                    this.questionBankList.get(i3).setTotalTimeSpent(this.questionDumpList.get(r4).getOn_screen());
                                }
                                this.questionBankList.get(i3).setIsguess(this.questionDumpList.get(r4).getGuess());
                            }
                            List<QuestionDump> list3 = this.questionDumpList;
                            if (list3 != null && list3.size() > 0) {
                                Boolean.valueOf(z5);
                                if (this.questionDumpList.get(r4).getState().equals("marked_for_review") || this.questionDumpList.get(r4).getAnswerBookmark().equals("marked_for_review")) {
                                    bool2 = true;
                                } else {
                                    bool2 = false;
                                }
                                this.questionBankList.get(i3).setMarkForReview(bool2.booleanValue());
                                if (this.questionBankList2.size() > 0) {
                                    this.questionBankList2.get(i3).setMarkForReview(bool2.booleanValue());
                                }
                            }
                            List<QuestionDump> list4 = this.questionDumpList;
                            if (list4 != null && list4.size() > 0) {
                                Boolean.valueOf(z5);
                                if (this.questionDumpList.get(r4).getState().equals("bookmarked")) {
                                    bool = true;
                                } else {
                                    bool = false;
                                }
                                this.questionBankList.get(i3).setIssaveMarkForReview(bool.booleanValue());
                            }
                        }
                        z = z5;
                        r4++;
                        r5 = r5;
                    }
                }
            }
        }
        boolean z6 = z;
        this.PartId = this.questionBankList.get(this.testPauseCount).getSubjectId();
        currentSectionIdforTest = this.questionBankList.get(this.testPauseCount).getSubjectId();
        this.imgPause.setVisibility(8);
        ArrayList<TestSection> arrayList3 = (ArrayList) this.data.getTestSections();
        this.partList = arrayList3;
        this.filteredPartListToDisplay = getFilteredPartListByUniqueSectionId(arrayList3);
        updateSectionTimingSums(this.partList);
        List<QuestionDump> list5 = this.questionDumpList;
        if (list5 != null && list5.size() > 0) {
            this.rvQuestionAdapter = new MyRecyclerAdapterTwo(this.questionBankList2, this, this.items, com.eduteria.app.app.R.layout.single_row_testpad_no, this, "0");
            this.rvNumberPadAdapter = new MyRecyclerAdapter(this.questionBankList2, (Activity) this, this.items, com.eduteria.app.app.R.layout.single_row_testpad_no, (NumberPadOnClick) this);
        } else {
            this.rvQuestionAdapter = new MyRecyclerAdapterTwo(this.questionBankList, this, this.items, com.eduteria.app.app.R.layout.single_row_testpad_no, this, "0");
            this.rvNumberPadAdapter = new MyRecyclerAdapter(this.questionBankList, (Activity) this, this.items, com.eduteria.app.app.R.layout.single_row_testpad_no, (NumberPadOnClick) this);
        }
        this.rlQuestionPad.setAdapter(this.rvQuestionAdapter);
        this.rlQuestionPad.setLayoutManager(new GridLayoutManager((Context) this, 6, 1, z6));
        this.rlQuestionPad.setItemAnimator(new DefaultItemAnimator());
        this.rvNumberpad.setAdapter(this.rvNumberPadAdapter);
        this.rvNumberpad.setLayoutManager(new LinearLayoutManagerWithSmoothScroller(this, z6 ? 1 : 0, z6));
        this.rvNumberpad.setItemAnimator(new DefaultItemAnimator());
        List<QuestionDump> list6 = this.questionDumpList;
        if (list6 != null && list6.size() > 0) {
            if (this.testseriesBase.getData().getTestBasic().getSetType() != null && this.testseriesBase.getData().getTestBasic().getSetType().equalsIgnoreCase("7")) {
                this.btnClear.setVisibility(8);
                int i4 = this.testPauseCount;
                setFragment(Instant_TestSeriesFragment.newInstance(i4, this.questionBankList.get(i4).getQuestionType()), "add", String.valueOf(this.testPauseCount));
            } else {
                String questionType = this.questionBankList.get(this.testPauseCount).getQuestionType();
                questionType.hashCode();
                if (questionType.equals("MT")) {
                    this.btnClear.setVisibility(0);
                    int i5 = this.testPauseCount;
                    setFragment(SC_TestSeriesFragment.newInstance(i5, this.questionBankList.get(i5).getQuestionType()), "add", String.valueOf(this.testPauseCount));
                } else if (questionType.equals("FIB")) {
                    this.btnClear.setVisibility(0);
                    setFragment(FIB_TestSeriesFragment.newInstance(this.testPauseCount), "add", String.valueOf(this.testPauseCount));
                } else {
                    this.btnClear.setVisibility(0);
                    int i6 = this.testPauseCount;
                    setFragment(SC_TestSeriesFragment.newInstance(i6, this.questionBankList.get(i6).getQuestionType()), "add", String.valueOf(this.testPauseCount));
                }
            }
        } else if (this.testseriesBase.getData().getTestBasic().getSetType() != null && this.testseriesBase.getData().getTestBasic().getSetType().equalsIgnoreCase("7")) {
            this.btnClear.setVisibility(8);
            setFragment(Instant_TestSeriesFragment.newInstance(0, this.questionBankList.get(0).getQuestionType()), "add", "0");
        } else {
            String questionType2 = this.questionBankList.get(0).getQuestionType();
            questionType2.hashCode();
            if (!questionType2.equals("MT") && questionType2.equals("FIB")) {
                this.btnClear.setVisibility(0);
                setFragment(FIB_TestSeriesFragment.newInstance(0), "add", "0");
            } else {
                this.btnClear.setVisibility(0);
                setFragment(SC_TestSeriesFragment.newInstance(0, this.questionBankList.get(0).getQuestionType()), "add", "0");
            }
        }
        changeTextOnNextAndPrevButton();
        if (testBasic.getAllow_user_move() == null) {
            testBasic.setAllow_user_move("1");
        } else if (!testBasic.getAllow_user_move().equalsIgnoreCase("1") && (arrayList = this.partList) != null && arrayList.size() > 1) {
            this.move_to_section.setVisibility(0);
        }
        if (this.partList != null) {
            for (int i7 = 0; i7 < this.partList.size(); i7++) {
                TestSection testSection = this.partList.get(i7);
                String is_topic_enabled = testSection.getIs_topic_enabled();
                testSection.setIndex(getIndexOf(this.questionBankList, testSection.getTopic_id(), testSection.getSectionId(), !TextUtils.isEmpty(is_topic_enabled) && ("1".equals(is_topic_enabled.trim()) || "true".equalsIgnoreCase(is_topic_enabled.trim()))));
                if (!TextUtils.isEmpty(this.partList.get(i7).getSection_aliase())) {
                    this.questionPart.add(this.partList.get(i7).getSection_aliase());
                } else {
                    this.questionPart.add(this.partList.get(i7).getName());
                }
            }
            if (SharedPreference.getInstance().getString(Const.CUSTOM_TESTSERIES_UI).equalsIgnoreCase("1") && this.partList.size() == 1) {
                this.clSpinner.setVisibility(8);
            } else {
                this.clSpinner.setVisibility(0);
            }
        }
        this.popUp = popupWindowPart();
        setPart();
        this.langimage.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setTestData$0(view);
            }
        });
        this.changelang.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setTestData$1(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setTestData$0(View view) {
        if (this.changelang.getText().equals("H/E")) {
            this.questionBankList = this.data.getQuestionsHindi();
            List<QuestionDump> list = this.questionDumpList;
            if (list != null && list.size() > 0) {
                this.rvQuestionAdapter = new MyRecyclerAdapterTwo(this.questionBankList2, this, this.items, com.eduteria.app.app.R.layout.single_row_testpad_no, this, "0");
                this.rvNumberPadAdapter = new MyRecyclerAdapter(this.questionBankList2, this, this.items, com.eduteria.app.app.R.layout.single_row_testpad_no, this);
            } else {
                this.rvQuestionAdapter = new MyRecyclerAdapterTwo(this.questionBankList, this, this.items, com.eduteria.app.app.R.layout.single_row_testpad_no, this, "0");
                this.rvNumberPadAdapter = new MyRecyclerAdapter(this.questionBankList, this, this.items, com.eduteria.app.app.R.layout.single_row_testpad_no, this);
            }
            this.rlQuestionPad.setAdapter(this.rvQuestionAdapter);
            this.rlQuestionPad.setLayoutManager(new GridLayoutManager((Context) this, 6, 1, false));
            this.rlQuestionPad.setItemAnimator(new DefaultItemAnimator());
            this.rvNumberpad.setAdapter(this.rvNumberPadAdapter);
            this.rvNumberpad.setLayoutManager(new LinearLayoutManagerWithSmoothScroller(this, 0, false));
            this.rvNumberpad.setItemAnimator(new DefaultItemAnimator());
            this.changelang.setText(getResources().getString(com.eduteria.app.app.R.string.e_h));
            setFragmentQuestionTypeSelection(this.currentPage);
            return;
        }
        if (this.changelang.getText().equals("E/H")) {
            this.questionBankList = this.data.getQuestions();
            List<QuestionDump> list2 = this.questionDumpList;
            if (list2 != null && list2.size() > 0) {
                this.rvQuestionAdapter = new MyRecyclerAdapterTwo(this.questionBankList2, this, this.items, com.eduteria.app.app.R.layout.single_row_testpad_no, this, "0");
                this.rvNumberPadAdapter = new MyRecyclerAdapter(this.questionBankList2, this, this.items, com.eduteria.app.app.R.layout.single_row_testpad_no, this);
            } else {
                this.rvQuestionAdapter = new MyRecyclerAdapterTwo(this.questionBankList, this, this.items, com.eduteria.app.app.R.layout.single_row_testpad_no, this, "0");
                this.rvNumberPadAdapter = new MyRecyclerAdapter(this.questionBankList, this, this.items, com.eduteria.app.app.R.layout.single_row_testpad_no, this);
            }
            this.rlQuestionPad.setAdapter(this.rvQuestionAdapter);
            this.rlQuestionPad.setLayoutManager(new GridLayoutManager((Context) this, 6, 1, false));
            this.rlQuestionPad.setItemAnimator(new DefaultItemAnimator());
            this.rvNumberpad.setAdapter(this.rvNumberPadAdapter);
            this.rvNumberpad.setLayoutManager(new LinearLayoutManagerWithSmoothScroller(this, 0, false));
            this.rvNumberpad.setItemAnimator(new DefaultItemAnimator());
            this.changelang.setText(getResources().getString(com.eduteria.app.app.R.string.h_e));
            setFragmentQuestionTypeSelection(this.currentPage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setTestData$1(View view) {
        if (this.changelang.getText().equals("H/E")) {
            this.questionBankList = this.data.getQuestionsHindi();
            this.rvQuestionAdapter = new MyRecyclerAdapterTwo(this.questionBankList, this, this.items, com.eduteria.app.app.R.layout.single_row_testpad_no, this, "0");
            this.rvNumberPadAdapter = new MyRecyclerAdapter(this.questionBankList, this, this.items, com.eduteria.app.app.R.layout.single_row_testpad_no, this);
            this.rlQuestionPad.setAdapter(this.rvQuestionAdapter);
            this.rlQuestionPad.setLayoutManager(new GridLayoutManager((Context) this, 6, 1, false));
            this.rlQuestionPad.setItemAnimator(new DefaultItemAnimator());
            this.rvNumberpad.setAdapter(this.rvNumberPadAdapter);
            this.rvNumberpad.setLayoutManager(new LinearLayoutManagerWithSmoothScroller(this, 0, false));
            this.rvNumberpad.setItemAnimator(new DefaultItemAnimator());
            this.changelang.setText(getResources().getString(com.eduteria.app.app.R.string.h_e));
            setFragmentQuestionTypeSelection(this.currentPage);
            return;
        }
        if (this.changelang.getText().equals("E/H")) {
            this.questionBankList = this.data.getQuestions();
            this.rvQuestionAdapter = new MyRecyclerAdapterTwo(this.questionBankList, this, this.items, com.eduteria.app.app.R.layout.single_row_testpad_no, this, "0");
            this.rvNumberPadAdapter = new MyRecyclerAdapter(this.questionBankList, this, this.items, com.eduteria.app.app.R.layout.single_row_testpad_no, this);
            this.rlQuestionPad.setAdapter(this.rvQuestionAdapter);
            this.rlQuestionPad.setLayoutManager(new GridLayoutManager((Context) this, 6, 1, false));
            this.rlQuestionPad.setItemAnimator(new DefaultItemAnimator());
            this.rvNumberpad.setAdapter(this.rvNumberPadAdapter);
            this.rvNumberpad.setLayoutManager(new LinearLayoutManagerWithSmoothScroller(this, 0, false));
            this.rvNumberpad.setItemAnimator(new DefaultItemAnimator());
            this.changelang.setText(getResources().getString(com.eduteria.app.app.R.string.h_e));
            setFragmentQuestionTypeSelection(this.currentPage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPart() {
        if (this.partList != null) {
            int i = 0;
            while (true) {
                if (i < this.partList.size()) {
                    if (i != this.partList.size() - 1) {
                        if (this.testseriesBase.getLastanswerPosition() >= this.partList.get(i).getIndexOf() && this.testseriesBase.getLastanswerPosition() <= this.partList.get(i + 1).getIndexOf() - 1) {
                            this.textSpinner.setText(checkTitle1(this.questionPart.get(i), i));
                            topicViewsAndClick(i, this.partList.get(i).getSectionId());
                            break;
                        }
                        i++;
                    } else {
                        this.textSpinner.setText(checkTitle1(this.questionPart.get(i), i));
                        topicViewsAndClick(i, this.partList.get(i).getSectionId());
                        break;
                    }
                } else {
                    break;
                }
            }
            if (this.partList.size() == 1) {
                this.dropdown_icon.setVisibility(8);
            } else {
                this.dropdown_icon.setVisibility(0);
            }
        }
    }

    protected void setFragment(Fragment fragment, String status, String pos) {
        this.sc_testSeriesFragment = fragment;
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(com.eduteria.app.app.R.id.testlayout, fragment);
        fragmentTransactionBeginTransaction.commit();
        if (status.equalsIgnoreCase("add")) {
            if (pos.equalsIgnoreCase("0")) {
                this.rvNumberpad.scrollToPosition(0);
                this.rvNumberpad.getLayoutManager().smoothScrollToPosition(this.rvNumberpad, new RecyclerView.State(), 0);
                this.rvNumberPadAdapter.setSelectePosition(0);
                if (this.questionBankList.get(0).getAnswerPosttion() == -1) {
                    this.questionBankList.get(0).setIsanswer(false, 0);
                    if (this.changelang.getText().equals("H/E")) {
                        this.testseriesBase.getData().getQuestionsHindi().get(0).setIsanswer(false, 0);
                    } else if (this.changelang.getText().equals("E/H")) {
                        this.testseriesBase.getData().getQuestions().get(0).setIsanswer(false, 0);
                    }
                }
                if (this.data != null) {
                    this.tvQuestionnumber.setText(getResources().getString(com.eduteria.app.app.R.string.question) + (this.currentPage + 1) + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.questionBankList.size());
                }
                this.testseriesBase.setLastanswerPosition(0);
                new Handler(Looper.myLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setFragment$2();
                    }
                }, 1000L);
                return;
            }
            List<QuestionDump> list = this.questionDumpList;
            if (list != null && list.size() > 0) {
                if (this.pauseCount) {
                    int i = this.testPauseCount;
                    if (i == 0) {
                        this.currentPage = this.currentPage + i + 1;
                    } else if (!this.sectionSwitch && this.sectionCount < 1) {
                        this.currentPage += i;
                    } else if (this.resume_section_status) {
                        this.currentPage++;
                    } else {
                        this.currentPage = i;
                    }
                } else {
                    if (this.questionBankList2.size() > 0 && this.questionBankList2.get(this.currentPage).getAnswerPosttion() == -1) {
                        this.questionBankList2.get(this.currentPage).setIsanswer(false, 0);
                    }
                    this.currentPage++;
                }
                this.rvNumberpad.scrollToPosition(this.currentPage);
                this.rvNumberpad.getLayoutManager().smoothScrollToPosition(this.rvNumberpad, new RecyclerView.State(), this.currentPage);
                this.rvNumberPadAdapter.setSelectePosition(this.currentPage);
                if (this.data != null) {
                    this.tvQuestionnumber.setText(getResources().getString(com.eduteria.app.app.R.string.question) + (this.currentPage + 1) + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.questionBankList.size());
                }
                if (this.questionBankList2.size() > 0 && this.questionBankList2.get(this.currentPage).getAnswerPosttion() == -1) {
                    this.questionBankList2.get(this.currentPage).setIsanswer(false, 0);
                }
                if (this.questionBankList.get(this.currentPage).getAnswerPosttion() == -1) {
                    this.questionBankList.get(this.currentPage).setIsanswer(false, 0);
                    if (this.changelang.getText().equals("H/E")) {
                        this.testseriesBase.getData().getQuestionsHindi().get(this.currentPage).setIsanswer(false, 0);
                    } else if (this.changelang.getText().equals("E/H")) {
                        this.testseriesBase.getData().getQuestions().get(this.currentPage).setIsanswer(false, 0);
                    }
                }
                this.testseriesBase.setLastanswerPosition(this.currentPage);
                new Handler(Looper.myLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setFragment$3();
                    }
                }, 1000L);
                return;
            }
            int i2 = this.currentPage + 1;
            this.currentPage = i2;
            this.rvNumberpad.scrollToPosition(i2);
            this.rvNumberpad.getLayoutManager().smoothScrollToPosition(this.rvNumberpad, new RecyclerView.State(), this.currentPage);
            this.rvNumberPadAdapter.setSelectePosition(this.currentPage);
            if (this.data != null) {
                this.tvQuestionnumber.setText(getResources().getString(com.eduteria.app.app.R.string.question) + (this.currentPage + 1) + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.questionBankList.size());
            }
            if (this.questionBankList.get(this.currentPage).getAnswerPosttion() == -1) {
                this.questionBankList.get(this.currentPage).setIsanswer(false, 0);
                if (this.changelang.getText().equals("H/E")) {
                    this.testseriesBase.getData().getQuestionsHindi().get(this.currentPage).setIsanswer(false, 0);
                } else if (this.changelang.getText().equals("E/H")) {
                    this.testseriesBase.getData().getQuestions().get(this.currentPage).setIsanswer(false, 0);
                }
            }
            this.testseriesBase.setLastanswerPosition(this.currentPage);
            new Handler(Looper.myLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setFragment$4();
                }
            }, 1000L);
            return;
        }
        if (status.equalsIgnoreCase("remove")) {
            if (this.questionBankList2.size() > 0 && this.questionBankList2.get(this.currentPage).getAnswerPosttion() == -1) {
                this.questionBankList2.get(this.currentPage).setIsanswer(false, 0);
            }
            int i3 = this.currentPage - 1;
            this.currentPage = i3;
            this.rvNumberpad.scrollToPosition(i3);
            this.rvNumberpad.getLayoutManager().smoothScrollToPosition(this.rvNumberpad, new RecyclerView.State(), this.currentPage);
            this.rvNumberPadAdapter.setSelectePosition(this.currentPage);
            if (this.questionBankList2.size() > 0 && this.questionBankList2.get(this.currentPage).getAnswerPosttion() == -1) {
                this.questionBankList2.get(this.currentPage).setIsanswer(false, 0);
            }
            if (this.questionBankList.get(this.currentPage).getAnswerPosttion() == -1) {
                this.questionBankList.get(this.currentPage).setIsanswer(false, 0);
                if (this.changelang.getText().equals("H/E")) {
                    this.testseriesBase.getData().getQuestionsHindi().get(this.currentPage).setIsanswer(false, 0);
                } else if (this.changelang.getText().equals("E/H")) {
                    this.testseriesBase.getData().getQuestions().get(this.currentPage).setIsanswer(false, 0);
                }
            }
            if (this.data != null) {
                this.tvQuestionnumber.setText(getResources().getString(com.eduteria.app.app.R.string.question) + " " + (this.currentPage + 1) + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.questionBankList.size());
            }
            this.testseriesBase.setLastanswerPosition(this.currentPage);
            new Handler(Looper.myLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setFragment$5();
                }
            }, 1000L);
            return;
        }
        if (status.equalsIgnoreCase("selection")) {
            int i4 = this.currentPage;
            if (i4 == 0) {
                this.rvNumberpad.scrollToPosition(0);
                this.rvNumberpad.getLayoutManager().smoothScrollToPosition(this.rvNumberpad, new RecyclerView.State(), 0);
                this.rvNumberPadAdapter.setSelectePosition(0);
                if (this.questionBankList.get(0).getAnswerPosttion() == -1) {
                    this.questionBankList.get(0).setIsanswer(false, 0);
                    if (this.changelang.getText().equals("H/E")) {
                        this.testseriesBase.getData().getQuestionsHindi().get(0).setIsanswer(false, 0);
                    } else if (this.changelang.getText().equals("E/H")) {
                        this.testseriesBase.getData().getQuestions().get(0).setIsanswer(false, 0);
                    }
                }
                if (this.data != null) {
                    this.tvQuestionnumber.setText(getResources().getString(com.eduteria.app.app.R.string.question) + (this.currentPage + 1) + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.questionBankList.size());
                }
                this.testseriesBase.setLastanswerPosition(this.currentPage);
                new Handler(Looper.myLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity$$ExternalSyntheticLambda8
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setFragment$6();
                    }
                }, 1000L);
                return;
            }
            this.rvNumberpad.scrollToPosition(i4);
            this.rvNumberpad.getLayoutManager().smoothScrollToPosition(this.rvNumberpad, new RecyclerView.State(), this.currentPage);
            this.rvNumberPadAdapter.setSelectePosition(this.currentPage);
            if (this.questionBankList.get(this.currentPage).getAnswerPosttion() == -1) {
                this.questionBankList.get(this.currentPage).setIsanswer(false, 0);
                if (this.changelang.getText().equals("H/E")) {
                    this.testseriesBase.getData().getQuestionsHindi().get(this.currentPage).setIsanswer(false, 0);
                } else if (this.changelang.getText().equals("E/H")) {
                    this.testseriesBase.getData().getQuestions().get(this.currentPage).setIsanswer(false, 0);
                }
            }
            if (this.data != null) {
                this.tvQuestionnumber.setText(getResources().getString(com.eduteria.app.app.R.string.question) + (this.currentPage + 1) + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.questionBankList.size());
            }
            this.testseriesBase.setLastanswerPosition(this.currentPage);
            new Handler(Looper.myLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setFragment$7();
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setFragment$2() {
        this.rvQuestionAdapter.setSelectePosition(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setFragment$3() {
        this.rvQuestionAdapter.setSelectePosition(this.currentPage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setFragment$4() {
        this.rvQuestionAdapter.setSelectePosition(this.currentPage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setFragment$5() {
        this.rvQuestionAdapter.setSelectePosition(this.currentPage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setFragment$6() {
        this.rvQuestionAdapter.setSelectePosition(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setFragment$7() {
        this.rvQuestionAdapter.setSelectePosition(this.currentPage);
    }

    private int getIndexOf(List<Question> list, String topicId, String sectionId, boolean isTopicEnabled) {
        int i = 0;
        for (Question question : list) {
            if ((isTopicEnabled && topicId != null && topicId.equals(question.getTopic_id())) || (!isTopicEnabled && sectionId != null && sectionId.equals(question.getSubjectId()))) {
                return i;
            }
            i++;
        }
        return 0;
    }

    private void setReference() {
        this.calci = (ImageView) findViewById(com.eduteria.app.app.R.id.calci);
        this.toolbar = (Toolbar) findViewById(com.eduteria.app.app.R.id.toolbar);
        this.llDrawerRight = (LinearLayout) findViewById(com.eduteria.app.app.R.id.llDrawerRight);
        this.languageSpinnerTV = (TextView) findViewById(com.eduteria.app.app.R.id.languageSpinnerTV);
        this.changelang = (TextView) findViewById(com.eduteria.app.app.R.id.changelang);
        this.langimage = (ImageView) findViewById(com.eduteria.app.app.R.id.langimage);
        this.drawerLayout = (DrawerLayout) findViewById(com.eduteria.app.app.R.id.drawerLayout);
        this.imgTestBack = (ImageView) findViewById(com.eduteria.app.app.R.id.img_testback);
        this.imgTestMenu = (ImageView) findViewById(com.eduteria.app.app.R.id.img_testmenu);
        this.rlQuestionPad = (RecyclerView) findViewById(com.eduteria.app.app.R.id.rl_questionpad);
        this.rvNumberpad = (RecyclerView) findViewById(com.eduteria.app.app.R.id.rvnumberpad);
        this.viewPagerTest = (ViewPager) findViewById(com.eduteria.app.app.R.id.view_pager_test);
        this.btnNext = (FrameLayout) findViewById(com.eduteria.app.app.R.id.btn_next);
        this.btnPrev = (FrameLayout) findViewById(com.eduteria.app.app.R.id.btn_prev);
        this.btnClear = (TextView) findViewById(com.eduteria.app.app.R.id.btn_clear);
        this.llMarkForReview = (LinearLayout) findViewById(com.eduteria.app.app.R.id.llMarkForReview);
        this.tvTime = (TextView) findViewById(com.eduteria.app.app.R.id.tv_time);
        this.clSpinner = (RelativeLayout) findViewById(com.eduteria.app.app.R.id.cl_part);
        this.btn_finish = (FrameLayout) findViewById(com.eduteria.app.app.R.id.btn_finish);
        this.llMarkForReviewCount = (LinearLayout) findViewById(com.eduteria.app.app.R.id.llMarkForReviewCount);
        this.viewMarkForReviewCount = findViewById(com.eduteria.app.app.R.id.viewMarkForReviewCount);
        this.nextTV = (TextView) findViewById(com.eduteria.app.app.R.id.nextTV);
        this.textSpinner = (TextView) findViewById(com.eduteria.app.app.R.id.text_spinner);
        this.tvQuestionnumber = (TextView) findViewById(com.eduteria.app.app.R.id.tv_questionnumber);
        this.tvanswerCount = (TextView) findViewById(com.eduteria.app.app.R.id.tv_answer_count);
        this.tvUnAnswerCount = (TextView) findViewById(com.eduteria.app.app.R.id.tv_unanswer_count);
        this.testSeriesName = (TextView) findViewById(com.eduteria.app.app.R.id.testSeriesName);
        this.dropdown_icon = (ImageView) findViewById(com.eduteria.app.app.R.id.dropdown_icon);
        this.tvSkipCount = (TextView) findViewById(com.eduteria.app.app.R.id.tv_skip_count);
        this.tvmarkForReviewCount = (TextView) findViewById(com.eduteria.app.app.R.id.tv_markforReview_count);
        this.tv_savemarkforReview_count = (TextView) findViewById(com.eduteria.app.app.R.id.tv_savemarkforReview_count);
        this.btn_exam_instructions = (Button) findViewById(com.eduteria.app.app.R.id.btn_exam_instructions);
        this.btn_submit = (Button) findViewById(com.eduteria.app.app.R.id.btn_submit);
        this.imgPause = (ImageView) findViewById(com.eduteria.app.app.R.id.img_pause);
        this.gridView = (TextView) findViewById(com.eduteria.app.app.R.id.gridView);
        this.move_to_section = (Button) findViewById(com.eduteria.app.app.R.id.move_to_section);
        this.listView = (TextView) findViewById(com.eduteria.app.app.R.id.listView);
        this.testlayout = (FrameLayout) findViewById(com.eduteria.app.app.R.id.testlayout);
        this.tvmarkForReviewCount.setVisibility(0);
        this.tv_savemarkforReview_count.setVisibility(0);
        this.llMarkForReviewCount.setVisibility(0);
        this.viewMarkForReviewCount.setVisibility(0);
        this.llMarkForReview.setVisibility(0);
        this.btn_exam_instructions.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setReference$8();
            }
        }));
        this.btn_submit.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setReference$9();
            }
        }));
        this.btnNext.setOnClickListener(this);
        this.calci.setVisibility(8);
        this.calci.setOnClickListener(this);
        this.btn_finish.setOnClickListener(this);
        this.btnPrev.setOnClickListener(this);
        this.imgPause.setOnClickListener(this);
        this.drawerLayout.setDrawerLockMode(1, GravityCompat.END);
        this.questionBankList = new ArrayList();
        this.questionDumpList = new ArrayList();
        this.imgTestBack.setOnClickListener(this);
        this.imgTestMenu.setOnClickListener(this);
        this.btnClear.setOnClickListener(this);
        this.gridView.setOnClickListener(this);
        this.listView.setOnClickListener(this);
        this.move_to_section.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setReference$8() {
        if (isFinishing()) {
            return null;
        }
        showExamInstruction();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setReference$9() {
        if (isFinishing()) {
            return null;
        }
        this.isPause = false;
        showPopupSubmitTest();
        return null;
    }

    private PopupWindow popupWindowPart() {
        View view;
        TestBaseActivity testBaseActivity;
        View view2;
        TextView textView;
        View view3;
        TextView textView2;
        View view4;
        TextView textView3;
        View view5;
        View view6;
        this.popupWindow = new PopupWindow(this);
        View viewInflate = getLayoutInflater().inflate(com.eduteria.app.app.R.layout.dialog_popup, (ViewGroup) null);
        ArrayList<TestSection> arrayList = this.partList;
        if (arrayList == null || arrayList.size() <= 0) {
            view = viewInflate;
            testBaseActivity = this;
        } else {
            View viewFindViewById = viewInflate.findViewById(com.eduteria.app.app.R.id.view1);
            View viewFindViewById2 = viewInflate.findViewById(com.eduteria.app.app.R.id.view2);
            View viewFindViewById3 = viewInflate.findViewById(com.eduteria.app.app.R.id.view3);
            View viewFindViewById4 = viewInflate.findViewById(com.eduteria.app.app.R.id.view4);
            View viewFindViewById5 = viewInflate.findViewById(com.eduteria.app.app.R.id.view5);
            View viewFindViewById6 = viewInflate.findViewById(com.eduteria.app.app.R.id.view6);
            View viewFindViewById7 = viewInflate.findViewById(com.eduteria.app.app.R.id.view7);
            View viewFindViewById8 = viewInflate.findViewById(com.eduteria.app.app.R.id.view8);
            View viewFindViewById9 = viewInflate.findViewById(com.eduteria.app.app.R.id.view9);
            View viewFindViewById10 = viewInflate.findViewById(com.eduteria.app.app.R.id.view10);
            View viewFindViewById11 = viewInflate.findViewById(com.eduteria.app.app.R.id.view11);
            View viewFindViewById12 = viewInflate.findViewById(com.eduteria.app.app.R.id.view12);
            View viewFindViewById13 = viewInflate.findViewById(com.eduteria.app.app.R.id.view13);
            View viewFindViewById14 = viewInflate.findViewById(com.eduteria.app.app.R.id.view14);
            View viewFindViewById15 = viewInflate.findViewById(com.eduteria.app.app.R.id.view15);
            TextView textView4 = (TextView) viewInflate.findViewById(com.eduteria.app.app.R.id.partATV);
            TextView textView5 = (TextView) viewInflate.findViewById(com.eduteria.app.app.R.id.partBTV);
            TextView textView6 = (TextView) viewInflate.findViewById(com.eduteria.app.app.R.id.partCTV);
            TextView textView7 = (TextView) viewInflate.findViewById(com.eduteria.app.app.R.id.partDTV);
            TextView textView8 = (TextView) viewInflate.findViewById(com.eduteria.app.app.R.id.partETV);
            TextView textView9 = (TextView) viewInflate.findViewById(com.eduteria.app.app.R.id.partFTV);
            TextView textView10 = (TextView) viewInflate.findViewById(com.eduteria.app.app.R.id.partGTV);
            TextView textView11 = (TextView) viewInflate.findViewById(com.eduteria.app.app.R.id.partHTV);
            TextView textView12 = (TextView) viewInflate.findViewById(com.eduteria.app.app.R.id.partITV);
            TextView textView13 = (TextView) viewInflate.findViewById(com.eduteria.app.app.R.id.partJTV);
            TextView textView14 = (TextView) viewInflate.findViewById(com.eduteria.app.app.R.id.partKTV);
            TextView textView15 = (TextView) viewInflate.findViewById(com.eduteria.app.app.R.id.partLTV);
            TextView textView16 = (TextView) viewInflate.findViewById(com.eduteria.app.app.R.id.partMTV);
            TextView textView17 = (TextView) viewInflate.findViewById(com.eduteria.app.app.R.id.partNTV);
            TextView textView18 = (TextView) viewInflate.findViewById(com.eduteria.app.app.R.id.partOTV);
            view = viewInflate;
            textView4.setVisibility(8);
            viewFindViewById.setVisibility(8);
            textView5.setVisibility(8);
            viewFindViewById2.setVisibility(8);
            textView6.setVisibility(8);
            viewFindViewById3.setVisibility(8);
            textView7.setVisibility(8);
            viewFindViewById4.setVisibility(8);
            textView8.setVisibility(8);
            viewFindViewById5.setVisibility(8);
            textView9.setVisibility(8);
            viewFindViewById6.setVisibility(8);
            textView10.setVisibility(8);
            viewFindViewById7.setVisibility(8);
            textView11.setVisibility(8);
            TextView textView19 = textView4;
            viewFindViewById8.setVisibility(8);
            TextView textView20 = textView12;
            textView20.setVisibility(8);
            viewFindViewById9.setVisibility(8);
            TextView textView21 = textView13;
            textView21.setVisibility(8);
            View view7 = viewFindViewById10;
            view7.setVisibility(8);
            textView14.setVisibility(8);
            viewFindViewById11.setVisibility(8);
            textView15.setVisibility(8);
            viewFindViewById12.setVisibility(8);
            textView16.setVisibility(8);
            viewFindViewById13.setVisibility(8);
            textView17.setVisibility(8);
            viewFindViewById14.setVisibility(8);
            textView18.setVisibility(8);
            View view8 = viewFindViewById8;
            View view9 = viewFindViewById15;
            view9.setVisibility(8);
            testBaseActivity = this;
            int i = 0;
            while (i < testBaseActivity.filteredPartListToDisplay.size()) {
                int i2 = i;
                switch (i2) {
                    case 0:
                        view2 = view9;
                        textView = textView20;
                        View view10 = view8;
                        view3 = view7;
                        textView2 = textView19;
                        textView2.setText(testBaseActivity.checkTitle2(testBaseActivity.filteredPartListToDisplay.get(0).getName() + testBaseActivity.getResources().getString(com.eduteria.app.app.R.string.pos_mark) + testBaseActivity.filteredPartListToDisplay.get(0).getMarksPerQuestion() + testBaseActivity.getResources().getString(com.eduteria.app.app.R.string.neg_mark) + testBaseActivity.filteredPartListToDisplay.get(0).getNegativeMarks() + ")", 0));
                        textView2.setVisibility(0);
                        viewFindViewById.setVisibility(0);
                        view4 = view10;
                        textView3 = textView21;
                        testBaseActivity.textSpinner.setText(testBaseActivity.checkTitle2(testBaseActivity.filteredPartListToDisplay.get(0).getName() + testBaseActivity.getResources().getString(com.eduteria.app.app.R.string.pos_mark) + testBaseActivity.filteredPartListToDisplay.get(0).getMarksPerQuestion() + testBaseActivity.getResources().getString(com.eduteria.app.app.R.string.neg_mark) + testBaseActivity.filteredPartListToDisplay.get(0).getNegativeMarks() + ")", 0));
                        testBaseActivity.textSpinner.setSelected(true);
                        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View v) {
                                if (TestBaseActivity.this.basicInfo.getAllow_user_move().equalsIgnoreCase("1")) {
                                    TestBaseActivity.this.nextOrPreButtonClicked = true;
                                    TestBaseActivity testBaseActivity2 = TestBaseActivity.this;
                                    testBaseActivity2.topicViewsAndClick(0, testBaseActivity2.filteredPartListToDisplay.get(0).getSectionId());
                                    TestBaseActivity.this.rvNumberpad.scrollToPosition(TestBaseActivity.this.partList.get(0).getIndexOf());
                                    if (TestBaseActivity.this.testseriesBase.getData().getTestBasic().getSetType() != null && TestBaseActivity.this.testseriesBase.getData().getTestBasic().getSetType().equalsIgnoreCase("7")) {
                                        TestBaseActivity.this.btnClear.setVisibility(8);
                                        TestBaseActivity testBaseActivity3 = TestBaseActivity.this;
                                        testBaseActivity3.setFragment(Instant_TestSeriesFragment.newInstance(0, testBaseActivity3.questionBankList.get(0).getQuestionType()), "selection", "0");
                                    } else {
                                        String questionType = TestBaseActivity.this.questionBankList.get(TestBaseActivity.this.partList.get(0).getIndexOf()).getQuestionType();
                                        questionType.hashCode();
                                        if (questionType.equals("FIB")) {
                                            TestBaseActivity.this.btnClear.setVisibility(0);
                                            TestBaseActivity testBaseActivity4 = TestBaseActivity.this;
                                            testBaseActivity4.currentPage = testBaseActivity4.partList.get(0).getIndexOf();
                                            TestBaseActivity testBaseActivity5 = TestBaseActivity.this;
                                            testBaseActivity5.setFragment(FIB_TestSeriesFragment.newInstance(testBaseActivity5.partList.get(0).getIndexOf()), "selection", "0");
                                        } else {
                                            TestBaseActivity.this.btnClear.setVisibility(0);
                                            TestBaseActivity testBaseActivity6 = TestBaseActivity.this;
                                            testBaseActivity6.currentPage = testBaseActivity6.partList.get(0).getIndexOf();
                                            TestBaseActivity testBaseActivity7 = TestBaseActivity.this;
                                            testBaseActivity7.setFragment(SC_TestSeriesFragment.newInstance(0, testBaseActivity7.questionBankList.get(TestBaseActivity.this.partList.get(0).getIndexOf()).getQuestionType()), "selection", "0");
                                        }
                                    }
                                    TestBaseActivity.this.changeTextOnNextAndPrevButton();
                                    TestBaseActivity.this.textSpinner.setText(TestBaseActivity.this.checkTitle2(TestBaseActivity.this.filteredPartListToDisplay.get(0).getName() + TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.pos_mark) + TestBaseActivity.this.filteredPartListToDisplay.get(0).getMarksPerQuestion() + TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.neg_mark) + TestBaseActivity.this.filteredPartListToDisplay.get(0).getNegativeMarks() + ")", 0));
                                    TestBaseActivity.this.textSpinner.setSelected(true);
                                } else if (!TestBaseActivity.currentSectionIdforTest.equalsIgnoreCase(TestBaseActivity.this.filteredPartListToDisplay.get(0).getSectionId())) {
                                    TestBaseActivity.this.showSectionNotAllowToast();
                                }
                                TestBaseActivity.this.popupWindow.dismiss();
                            }
                        });
                        break;
                    case 1:
                        view2 = view9;
                        textView = textView20;
                        view5 = view8;
                        view3 = view7;
                        textView5.setText(testBaseActivity.checkTitle2(testBaseActivity.filteredPartListToDisplay.get(1).getName() + testBaseActivity.getResources().getString(com.eduteria.app.app.R.string.pos_mark) + testBaseActivity.filteredPartListToDisplay.get(1).getMarksPerQuestion() + testBaseActivity.getResources().getString(com.eduteria.app.app.R.string.neg_mark) + testBaseActivity.filteredPartListToDisplay.get(1).getNegativeMarks() + ")", 1));
                        textView5.setVisibility(0);
                        viewFindViewById2.setVisibility(0);
                        textView5.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View v) {
                                if (TestBaseActivity.this.basicInfo.getAllow_user_move().equalsIgnoreCase("1")) {
                                    TestBaseActivity.this.nextOrPreButtonClicked = true;
                                    TestBaseActivity testBaseActivity2 = TestBaseActivity.this;
                                    testBaseActivity2.topicViewsAndClick(1, testBaseActivity2.filteredPartListToDisplay.get(1).getSectionId());
                                    TestBaseActivity testBaseActivity3 = TestBaseActivity.this;
                                    testBaseActivity3.scrollAndSelectWithFallback(testBaseActivity3.userClickedPositionUpdate, TestBaseActivity.this.filteredPartListToDisplay.get(1).getId());
                                    TestBaseActivity.this.changeTextOnNextAndPrevButton();
                                    TestBaseActivity.this.textSpinner.setText(TestBaseActivity.this.checkTitle2(TestBaseActivity.this.filteredPartListToDisplay.get(1).getName() + TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.pos_mark) + TestBaseActivity.this.filteredPartListToDisplay.get(1).getMarksPerQuestion() + TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.neg_mark) + TestBaseActivity.this.filteredPartListToDisplay.get(1).getNegativeMarks() + ")", 1));
                                    TestBaseActivity.this.textSpinner.setSelected(true);
                                } else if (!TestBaseActivity.currentSectionIdforTest.equalsIgnoreCase(TestBaseActivity.this.filteredPartListToDisplay.get(1).getSectionId())) {
                                    TestBaseActivity.this.showSectionNotAllowToast();
                                }
                                TestBaseActivity.this.popupWindow.dismiss();
                            }
                        });
                        textView3 = textView21;
                        textView2 = textView19;
                        view4 = view5;
                        break;
                    case 2:
                        view2 = view9;
                        textView = textView20;
                        view5 = view8;
                        view3 = view7;
                        textView6.setText(testBaseActivity.checkTitle2(testBaseActivity.filteredPartListToDisplay.get(2).getName() + testBaseActivity.getResources().getString(com.eduteria.app.app.R.string.pos_mark) + testBaseActivity.filteredPartListToDisplay.get(2).getMarksPerQuestion() + testBaseActivity.getResources().getString(com.eduteria.app.app.R.string.neg_mark) + testBaseActivity.filteredPartListToDisplay.get(2).getNegativeMarks() + ")", 2));
                        textView6.setVisibility(0);
                        viewFindViewById3.setVisibility(0);
                        textView6.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View v) {
                                if (TestBaseActivity.this.basicInfo.getAllow_user_move().equalsIgnoreCase("1")) {
                                    TestBaseActivity.this.nextOrPreButtonClicked = true;
                                    TestBaseActivity testBaseActivity2 = TestBaseActivity.this;
                                    testBaseActivity2.topicViewsAndClick(2, testBaseActivity2.filteredPartListToDisplay.get(2).getSectionId());
                                    TestBaseActivity testBaseActivity3 = TestBaseActivity.this;
                                    testBaseActivity3.scrollAndSelectWithFallback(testBaseActivity3.userClickedPositionUpdate, TestBaseActivity.this.filteredPartListToDisplay.get(2).getId());
                                    TestBaseActivity.this.changeTextOnNextAndPrevButton();
                                    TestBaseActivity.this.textSpinner.setText(TestBaseActivity.this.checkTitle2(TestBaseActivity.this.filteredPartListToDisplay.get(2).getName() + TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.pos_mark) + TestBaseActivity.this.filteredPartListToDisplay.get(2).getMarksPerQuestion() + TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.neg_mark) + TestBaseActivity.this.filteredPartListToDisplay.get(2).getNegativeMarks() + ")", 2));
                                    TestBaseActivity.this.textSpinner.setSelected(true);
                                } else if (!TestBaseActivity.currentSectionIdforTest.equalsIgnoreCase(TestBaseActivity.this.filteredPartListToDisplay.get(2).getSectionId())) {
                                    TestBaseActivity.this.showSectionNotAllowToast();
                                }
                                TestBaseActivity.this.popupWindow.dismiss();
                            }
                        });
                        textView3 = textView21;
                        textView2 = textView19;
                        view4 = view5;
                        break;
                    case 3:
                        view2 = view9;
                        textView = textView20;
                        view5 = view8;
                        view3 = view7;
                        textView7.setText(testBaseActivity.checkTitle2(testBaseActivity.filteredPartListToDisplay.get(3).getName() + testBaseActivity.getResources().getString(com.eduteria.app.app.R.string.pos_mark) + testBaseActivity.filteredPartListToDisplay.get(3).getMarksPerQuestion() + testBaseActivity.getResources().getString(com.eduteria.app.app.R.string.neg_mark) + testBaseActivity.filteredPartListToDisplay.get(3).getNegativeMarks() + ")", 3));
                        textView7.setVisibility(0);
                        viewFindViewById4.setVisibility(0);
                        textView7.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity.5
                            @Override // android.view.View.OnClickListener
                            public void onClick(View v) {
                                if (TestBaseActivity.this.basicInfo.getAllow_user_move().equalsIgnoreCase("1")) {
                                    TestBaseActivity.this.nextOrPreButtonClicked = true;
                                    TestBaseActivity testBaseActivity2 = TestBaseActivity.this;
                                    testBaseActivity2.topicViewsAndClick(3, testBaseActivity2.filteredPartListToDisplay.get(3).getSectionId());
                                    TestBaseActivity testBaseActivity3 = TestBaseActivity.this;
                                    testBaseActivity3.scrollAndSelectWithFallback(testBaseActivity3.userClickedPositionUpdate, TestBaseActivity.this.filteredPartListToDisplay.get(3).getId());
                                    TestBaseActivity.this.changeTextOnNextAndPrevButton();
                                    TestBaseActivity.this.textSpinner.setText(TestBaseActivity.this.checkTitle2(TestBaseActivity.this.filteredPartListToDisplay.get(3).getName() + TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.pos_mark) + TestBaseActivity.this.filteredPartListToDisplay.get(3).getMarksPerQuestion() + TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.neg_mark) + TestBaseActivity.this.filteredPartListToDisplay.get(3).getNegativeMarks() + ")", 3));
                                    TestBaseActivity.this.textSpinner.setSelected(true);
                                } else if (!TestBaseActivity.currentSectionIdforTest.equalsIgnoreCase(TestBaseActivity.this.filteredPartListToDisplay.get(3).getSectionId())) {
                                    TestBaseActivity.this.showSectionNotAllowToast();
                                }
                                TestBaseActivity.this.popupWindow.dismiss();
                            }
                        });
                        textView3 = textView21;
                        textView2 = textView19;
                        view4 = view5;
                        break;
                    case 4:
                        view2 = view9;
                        textView = textView20;
                        view5 = view8;
                        view3 = view7;
                        textView8.setText(testBaseActivity.checkTitle2(testBaseActivity.filteredPartListToDisplay.get(4).getName() + testBaseActivity.getResources().getString(com.eduteria.app.app.R.string.pos_mark) + testBaseActivity.filteredPartListToDisplay.get(4).getMarksPerQuestion() + testBaseActivity.getResources().getString(com.eduteria.app.app.R.string.neg_mark) + testBaseActivity.filteredPartListToDisplay.get(4).getNegativeMarks() + ")", 4));
                        textView8.setVisibility(0);
                        viewFindViewById5.setVisibility(0);
                        textView8.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity.6
                            @Override // android.view.View.OnClickListener
                            public void onClick(View v) {
                                if (TestBaseActivity.this.basicInfo.getAllow_user_move().equalsIgnoreCase("1")) {
                                    TestBaseActivity.this.nextOrPreButtonClicked = true;
                                    TestBaseActivity testBaseActivity2 = TestBaseActivity.this;
                                    testBaseActivity2.topicViewsAndClick(4, testBaseActivity2.filteredPartListToDisplay.get(4).getSectionId());
                                    TestBaseActivity testBaseActivity3 = TestBaseActivity.this;
                                    testBaseActivity3.scrollAndSelectWithFallback(testBaseActivity3.userClickedPositionUpdate, TestBaseActivity.this.filteredPartListToDisplay.get(4).getId());
                                    TestBaseActivity.this.changeTextOnNextAndPrevButton();
                                    TestBaseActivity.this.textSpinner.setText(TestBaseActivity.this.checkTitle2(TestBaseActivity.this.filteredPartListToDisplay.get(4).getName() + TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.pos_mark) + TestBaseActivity.this.filteredPartListToDisplay.get(4).getMarksPerQuestion() + TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.neg_mark) + TestBaseActivity.this.filteredPartListToDisplay.get(4).getNegativeMarks() + ")", 4));
                                    TestBaseActivity.this.textSpinner.setSelected(true);
                                } else if (!TestBaseActivity.currentSectionIdforTest.equalsIgnoreCase(TestBaseActivity.this.filteredPartListToDisplay.get(4).getSectionId())) {
                                    TestBaseActivity.this.showSectionNotAllowToast();
                                }
                                TestBaseActivity.this.popupWindow.dismiss();
                            }
                        });
                        textView3 = textView21;
                        textView2 = textView19;
                        view4 = view5;
                        break;
                    case 5:
                        view2 = view9;
                        textView = textView20;
                        view5 = view8;
                        view3 = view7;
                        textView9.setText(testBaseActivity.checkTitle2(testBaseActivity.filteredPartListToDisplay.get(5).getName() + testBaseActivity.getResources().getString(com.eduteria.app.app.R.string.pos_mark) + testBaseActivity.filteredPartListToDisplay.get(5).getMarksPerQuestion() + testBaseActivity.getResources().getString(com.eduteria.app.app.R.string.neg_mark) + testBaseActivity.filteredPartListToDisplay.get(5).getNegativeMarks() + ")", 5));
                        textView9.setVisibility(0);
                        viewFindViewById6.setVisibility(0);
                        textView9.setOnClickListener(testBaseActivity.new AnonymousClass7());
                        textView3 = textView21;
                        textView2 = textView19;
                        view4 = view5;
                        break;
                    case 6:
                        view2 = view9;
                        textView = textView20;
                        view5 = view8;
                        view3 = view7;
                        textView10.setText(testBaseActivity.checkTitle2(testBaseActivity.filteredPartListToDisplay.get(6).getName() + testBaseActivity.getResources().getString(com.eduteria.app.app.R.string.pos_mark) + testBaseActivity.filteredPartListToDisplay.get(6).getMarksPerQuestion() + testBaseActivity.getResources().getString(com.eduteria.app.app.R.string.neg_mark) + testBaseActivity.filteredPartListToDisplay.get(6).getNegativeMarks() + ")", 6));
                        textView10.setVisibility(0);
                        viewFindViewById7.setVisibility(0);
                        textView10.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity.8
                            @Override // android.view.View.OnClickListener
                            public void onClick(View v) {
                                if (TestBaseActivity.this.basicInfo.getAllow_user_move().equalsIgnoreCase("1")) {
                                    TestBaseActivity.this.nextOrPreButtonClicked = true;
                                    TestBaseActivity testBaseActivity2 = TestBaseActivity.this;
                                    testBaseActivity2.topicViewsAndClick(6, testBaseActivity2.filteredPartListToDisplay.get(6).getSectionId());
                                    TestBaseActivity testBaseActivity3 = TestBaseActivity.this;
                                    testBaseActivity3.scrollAndSelectWithFallback(testBaseActivity3.userClickedPositionUpdate, TestBaseActivity.this.filteredPartListToDisplay.get(6).getId());
                                    TestBaseActivity.this.changeTextOnNextAndPrevButton();
                                    TestBaseActivity.this.textSpinner.setText(TestBaseActivity.this.checkTitle2(TestBaseActivity.this.filteredPartListToDisplay.get(6).getName() + TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.pos_mark) + TestBaseActivity.this.filteredPartListToDisplay.get(6).getMarksPerQuestion() + TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.neg_mark) + TestBaseActivity.this.filteredPartListToDisplay.get(6).getNegativeMarks() + ")", 6));
                                } else if (!TestBaseActivity.currentSectionIdforTest.equalsIgnoreCase(TestBaseActivity.this.filteredPartListToDisplay.get(6).getSectionId())) {
                                    TestBaseActivity.this.showSectionNotAllowToast();
                                }
                                TestBaseActivity.this.popupWindow.dismiss();
                            }
                        });
                        textView3 = textView21;
                        textView2 = textView19;
                        view4 = view5;
                        break;
                    case 7:
                        view2 = view9;
                        textView = textView20;
                        textView11.setText(testBaseActivity.checkTitle2(testBaseActivity.filteredPartListToDisplay.get(7).getName() + testBaseActivity.getResources().getString(com.eduteria.app.app.R.string.pos_mark) + testBaseActivity.filteredPartListToDisplay.get(7).getMarksPerQuestion() + testBaseActivity.getResources().getString(com.eduteria.app.app.R.string.neg_mark) + testBaseActivity.filteredPartListToDisplay.get(7).getNegativeMarks() + ")", 7));
                        textView11.setVisibility(0);
                        view5 = view8;
                        view5.setVisibility(0);
                        textView11.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity.9
                            @Override // android.view.View.OnClickListener
                            public void onClick(View v) {
                                if (TestBaseActivity.this.basicInfo.getAllow_user_move().equalsIgnoreCase("1")) {
                                    TestBaseActivity.this.nextOrPreButtonClicked = true;
                                    TestBaseActivity testBaseActivity2 = TestBaseActivity.this;
                                    testBaseActivity2.topicViewsAndClick(7, testBaseActivity2.filteredPartListToDisplay.get(7).getSectionId());
                                    TestBaseActivity testBaseActivity3 = TestBaseActivity.this;
                                    testBaseActivity3.scrollAndSelectWithFallback(testBaseActivity3.userClickedPositionUpdate, TestBaseActivity.this.filteredPartListToDisplay.get(7).getId());
                                    TestBaseActivity.this.changeTextOnNextAndPrevButton();
                                    TestBaseActivity.this.textSpinner.setText(TestBaseActivity.this.checkTitle2(TestBaseActivity.this.filteredPartListToDisplay.get(7).getName() + TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.pos_mark) + TestBaseActivity.this.filteredPartListToDisplay.get(7).getMarksPerQuestion() + TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.neg_mark) + TestBaseActivity.this.filteredPartListToDisplay.get(7).getNegativeMarks() + ")", 7));
                                } else if (!TestBaseActivity.currentSectionIdforTest.equalsIgnoreCase(TestBaseActivity.this.filteredPartListToDisplay.get(7).getSectionId())) {
                                    TestBaseActivity.this.showSectionNotAllowToast();
                                }
                                TestBaseActivity.this.popupWindow.dismiss();
                            }
                        });
                        view3 = view7;
                        textView3 = textView21;
                        textView2 = textView19;
                        view4 = view5;
                        break;
                    case 8:
                        textView = textView20;
                        view2 = view9;
                        textView.setText(testBaseActivity.checkTitle2(testBaseActivity.filteredPartListToDisplay.get(8).getName() + testBaseActivity.getResources().getString(com.eduteria.app.app.R.string.pos_mark) + testBaseActivity.filteredPartListToDisplay.get(8).getMarksPerQuestion() + testBaseActivity.getResources().getString(com.eduteria.app.app.R.string.neg_mark) + testBaseActivity.filteredPartListToDisplay.get(8).getNegativeMarks() + ")", 8));
                        textView.setVisibility(0);
                        viewFindViewById9.setVisibility(0);
                        textView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity.10
                            @Override // android.view.View.OnClickListener
                            public void onClick(View v) {
                                if (TestBaseActivity.this.basicInfo.getAllow_user_move().equalsIgnoreCase("1")) {
                                    TestBaseActivity.this.nextOrPreButtonClicked = true;
                                    TestBaseActivity testBaseActivity2 = TestBaseActivity.this;
                                    testBaseActivity2.topicViewsAndClick(8, testBaseActivity2.filteredPartListToDisplay.get(8).getSectionId());
                                    TestBaseActivity testBaseActivity3 = TestBaseActivity.this;
                                    testBaseActivity3.scrollAndSelectWithFallback(testBaseActivity3.userClickedPositionUpdate, TestBaseActivity.this.filteredPartListToDisplay.get(8).getId());
                                    TestBaseActivity.this.changeTextOnNextAndPrevButton();
                                    TestBaseActivity.this.textSpinner.setText(TestBaseActivity.this.checkTitle2(TestBaseActivity.this.filteredPartListToDisplay.get(8).getName() + TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.pos_mark) + TestBaseActivity.this.filteredPartListToDisplay.get(8).getMarksPerQuestion() + TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.neg_mark) + TestBaseActivity.this.filteredPartListToDisplay.get(8).getNegativeMarks() + ")", 8));
                                } else if (!TestBaseActivity.currentSectionIdforTest.equalsIgnoreCase(TestBaseActivity.this.filteredPartListToDisplay.get(8).getSectionId())) {
                                    TestBaseActivity.this.showSectionNotAllowToast();
                                }
                                TestBaseActivity.this.popupWindow.dismiss();
                            }
                        });
                        textView3 = textView21;
                        textView2 = textView19;
                        view4 = view8;
                        view3 = view7;
                        break;
                    case 9:
                        textView = textView20;
                        textView21.setText(testBaseActivity.checkTitle2(testBaseActivity.filteredPartListToDisplay.get(9).getName() + testBaseActivity.getResources().getString(com.eduteria.app.app.R.string.pos_mark) + testBaseActivity.filteredPartListToDisplay.get(9).getMarksPerQuestion() + testBaseActivity.getResources().getString(com.eduteria.app.app.R.string.neg_mark) + testBaseActivity.filteredPartListToDisplay.get(9).getNegativeMarks() + ")", 9));
                        textView21.setVisibility(0);
                        view7 = view7;
                        view7.setVisibility(0);
                        textView21.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity.11
                            @Override // android.view.View.OnClickListener
                            public void onClick(View v) {
                                if (TestBaseActivity.this.basicInfo.getAllow_user_move().equalsIgnoreCase("1")) {
                                    TestBaseActivity.this.nextOrPreButtonClicked = true;
                                    TestBaseActivity testBaseActivity2 = TestBaseActivity.this;
                                    testBaseActivity2.topicViewsAndClick(9, testBaseActivity2.filteredPartListToDisplay.get(9).getSectionId());
                                    TestBaseActivity testBaseActivity3 = TestBaseActivity.this;
                                    testBaseActivity3.scrollAndSelectWithFallback(testBaseActivity3.userClickedPositionUpdate, TestBaseActivity.this.filteredPartListToDisplay.get(9).getId());
                                    TestBaseActivity.this.changeTextOnNextAndPrevButton();
                                    TestBaseActivity.this.textSpinner.setText(TestBaseActivity.this.checkTitle2(TestBaseActivity.this.filteredPartListToDisplay.get(9).getName() + TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.pos_mark) + TestBaseActivity.this.filteredPartListToDisplay.get(9).getMarksPerQuestion() + TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.neg_mark) + TestBaseActivity.this.filteredPartListToDisplay.get(9).getNegativeMarks() + ")", 9));
                                } else if (!TestBaseActivity.currentSectionIdforTest.equalsIgnoreCase(TestBaseActivity.this.filteredPartListToDisplay.get(9).getSectionId())) {
                                    TestBaseActivity.this.showSectionNotAllowToast();
                                }
                                TestBaseActivity.this.popupWindow.dismiss();
                            }
                        });
                        view2 = view9;
                        textView3 = textView21;
                        textView2 = textView19;
                        view4 = view8;
                        view3 = view7;
                        break;
                    case 10:
                        view6 = view7;
                        textView = textView20;
                        textView14.setText(testBaseActivity.checkTitle2(testBaseActivity.filteredPartListToDisplay.get(10).getName() + testBaseActivity.getResources().getString(com.eduteria.app.app.R.string.pos_mark) + testBaseActivity.filteredPartListToDisplay.get(10).getMarksPerQuestion() + testBaseActivity.getResources().getString(com.eduteria.app.app.R.string.neg_mark) + testBaseActivity.filteredPartListToDisplay.get(10).getNegativeMarks() + ")", 10));
                        textView14.setVisibility(0);
                        viewFindViewById11.setVisibility(0);
                        textView14.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity.12
                            @Override // android.view.View.OnClickListener
                            public void onClick(View v) {
                                if (TestBaseActivity.this.basicInfo.getAllow_user_move().equalsIgnoreCase("1")) {
                                    TestBaseActivity.this.nextOrPreButtonClicked = true;
                                    TestBaseActivity testBaseActivity2 = TestBaseActivity.this;
                                    testBaseActivity2.topicViewsAndClick(10, testBaseActivity2.filteredPartListToDisplay.get(10).getSectionId());
                                    TestBaseActivity testBaseActivity3 = TestBaseActivity.this;
                                    testBaseActivity3.scrollAndSelectWithFallback(testBaseActivity3.userClickedPositionUpdate, TestBaseActivity.this.filteredPartListToDisplay.get(10).getId());
                                    TestBaseActivity.this.changeTextOnNextAndPrevButton();
                                    TestBaseActivity.this.textSpinner.setText(TestBaseActivity.this.checkTitle2(TestBaseActivity.this.filteredPartListToDisplay.get(10).getName() + TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.pos_mark) + TestBaseActivity.this.filteredPartListToDisplay.get(10).getMarksPerQuestion() + TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.neg_mark) + TestBaseActivity.this.filteredPartListToDisplay.get(10).getNegativeMarks() + ")", 10));
                                } else if (!TestBaseActivity.currentSectionIdforTest.equalsIgnoreCase(TestBaseActivity.this.filteredPartListToDisplay.get(10).getSectionId())) {
                                    TestBaseActivity.this.showSectionNotAllowToast();
                                }
                                TestBaseActivity.this.popupWindow.dismiss();
                            }
                        });
                        textView3 = textView21;
                        textView2 = textView19;
                        view4 = view8;
                        view3 = view6;
                        view2 = view9;
                        break;
                    case 11:
                        view6 = view7;
                        textView = textView20;
                        textView15.setText(testBaseActivity.checkTitle2(testBaseActivity.filteredPartListToDisplay.get(11).getName() + testBaseActivity.getResources().getString(com.eduteria.app.app.R.string.pos_mark) + testBaseActivity.filteredPartListToDisplay.get(11).getMarksPerQuestion() + testBaseActivity.getResources().getString(com.eduteria.app.app.R.string.neg_mark) + testBaseActivity.filteredPartListToDisplay.get(11).getNegativeMarks() + ")", 11));
                        textView15.setVisibility(0);
                        viewFindViewById12.setVisibility(0);
                        textView15.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity.13
                            @Override // android.view.View.OnClickListener
                            public void onClick(View v) {
                                if (TestBaseActivity.this.basicInfo.getAllow_user_move().equalsIgnoreCase("1")) {
                                    TestBaseActivity.this.nextOrPreButtonClicked = true;
                                    TestBaseActivity testBaseActivity2 = TestBaseActivity.this;
                                    testBaseActivity2.topicViewsAndClick(11, testBaseActivity2.filteredPartListToDisplay.get(11).getSectionId());
                                    TestBaseActivity testBaseActivity3 = TestBaseActivity.this;
                                    testBaseActivity3.scrollAndSelectWithFallback(testBaseActivity3.userClickedPositionUpdate, TestBaseActivity.this.filteredPartListToDisplay.get(11).getId());
                                    TestBaseActivity.this.changeTextOnNextAndPrevButton();
                                    TestBaseActivity.this.textSpinner.setText(TestBaseActivity.this.checkTitle2(TestBaseActivity.this.filteredPartListToDisplay.get(11).getName() + TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.pos_mark) + TestBaseActivity.this.filteredPartListToDisplay.get(11).getMarksPerQuestion() + TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.neg_mark) + TestBaseActivity.this.filteredPartListToDisplay.get(11).getNegativeMarks() + ")", 11));
                                } else if (!TestBaseActivity.currentSectionIdforTest.equalsIgnoreCase(TestBaseActivity.this.filteredPartListToDisplay.get(11).getSectionId())) {
                                    TestBaseActivity.this.showSectionNotAllowToast();
                                }
                                TestBaseActivity.this.popupWindow.dismiss();
                            }
                        });
                        textView3 = textView21;
                        textView2 = textView19;
                        view4 = view8;
                        view3 = view6;
                        view2 = view9;
                        break;
                    case 12:
                        view6 = view7;
                        textView = textView20;
                        textView16.setText(testBaseActivity.checkTitle2(testBaseActivity.filteredPartListToDisplay.get(12).getName() + testBaseActivity.getResources().getString(com.eduteria.app.app.R.string.pos_mark) + testBaseActivity.filteredPartListToDisplay.get(12).getMarksPerQuestion() + testBaseActivity.getResources().getString(com.eduteria.app.app.R.string.neg_mark) + testBaseActivity.filteredPartListToDisplay.get(12).getNegativeMarks() + ")", 12));
                        textView16.setVisibility(0);
                        viewFindViewById13.setVisibility(0);
                        textView16.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity.14
                            @Override // android.view.View.OnClickListener
                            public void onClick(View v) {
                                if (TestBaseActivity.this.basicInfo.getAllow_user_move().equalsIgnoreCase("1")) {
                                    TestBaseActivity.this.nextOrPreButtonClicked = true;
                                    TestBaseActivity testBaseActivity2 = TestBaseActivity.this;
                                    testBaseActivity2.topicViewsAndClick(12, testBaseActivity2.filteredPartListToDisplay.get(12).getSectionId());
                                    TestBaseActivity testBaseActivity3 = TestBaseActivity.this;
                                    testBaseActivity3.scrollAndSelectWithFallback(testBaseActivity3.userClickedPositionUpdate, TestBaseActivity.this.filteredPartListToDisplay.get(12).getId());
                                    TestBaseActivity.this.changeTextOnNextAndPrevButton();
                                    TestBaseActivity.this.textSpinner.setText(TestBaseActivity.this.checkTitle2(TestBaseActivity.this.filteredPartListToDisplay.get(12).getName() + TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.pos_mark) + TestBaseActivity.this.filteredPartListToDisplay.get(12).getMarksPerQuestion() + TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.neg_mark) + TestBaseActivity.this.filteredPartListToDisplay.get(12).getNegativeMarks() + ")", 12));
                                } else if (!TestBaseActivity.currentSectionIdforTest.equalsIgnoreCase(TestBaseActivity.this.filteredPartListToDisplay.get(12).getSectionId())) {
                                    TestBaseActivity.this.showSectionNotAllowToast();
                                }
                                TestBaseActivity.this.popupWindow.dismiss();
                            }
                        });
                        textView3 = textView21;
                        textView2 = textView19;
                        view4 = view8;
                        view3 = view6;
                        view2 = view9;
                        break;
                    case 13:
                        view6 = view7;
                        textView = textView20;
                        textView17.setText(testBaseActivity.checkTitle2(testBaseActivity.filteredPartListToDisplay.get(13).getName() + testBaseActivity.getResources().getString(com.eduteria.app.app.R.string.pos_mark) + testBaseActivity.filteredPartListToDisplay.get(13).getMarksPerQuestion() + testBaseActivity.getResources().getString(com.eduteria.app.app.R.string.neg_mark) + testBaseActivity.filteredPartListToDisplay.get(13).getNegativeMarks() + ")", 13));
                        textView17.setVisibility(0);
                        viewFindViewById14.setVisibility(0);
                        textView17.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity.15
                            @Override // android.view.View.OnClickListener
                            public void onClick(View v) {
                                if (TestBaseActivity.this.basicInfo.getAllow_user_move().equalsIgnoreCase("1")) {
                                    TestBaseActivity.this.nextOrPreButtonClicked = true;
                                    TestBaseActivity testBaseActivity2 = TestBaseActivity.this;
                                    testBaseActivity2.topicViewsAndClick(13, testBaseActivity2.filteredPartListToDisplay.get(13).getSectionId());
                                    TestBaseActivity testBaseActivity3 = TestBaseActivity.this;
                                    testBaseActivity3.scrollAndSelectWithFallback(testBaseActivity3.userClickedPositionUpdate, TestBaseActivity.this.filteredPartListToDisplay.get(13).getId());
                                    TestBaseActivity.this.changeTextOnNextAndPrevButton();
                                    TestBaseActivity.this.textSpinner.setText(TestBaseActivity.this.checkTitle2(TestBaseActivity.this.filteredPartListToDisplay.get(13).getName() + TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.pos_mark) + TestBaseActivity.this.filteredPartListToDisplay.get(13).getMarksPerQuestion() + TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.neg_mark) + TestBaseActivity.this.filteredPartListToDisplay.get(13).getNegativeMarks() + ")", 13));
                                } else if (!TestBaseActivity.currentSectionIdforTest.equalsIgnoreCase(TestBaseActivity.this.filteredPartListToDisplay.get(13).getSectionId())) {
                                    TestBaseActivity.this.showSectionNotAllowToast();
                                }
                                TestBaseActivity.this.popupWindow.dismiss();
                            }
                        });
                        textView3 = textView21;
                        textView2 = textView19;
                        view4 = view8;
                        view3 = view6;
                        view2 = view9;
                        break;
                    case 14:
                        textView = textView20;
                        view6 = view7;
                        textView18.setText(testBaseActivity.checkTitle2(testBaseActivity.filteredPartListToDisplay.get(14).getName() + testBaseActivity.getResources().getString(com.eduteria.app.app.R.string.pos_mark) + testBaseActivity.filteredPartListToDisplay.get(14).getMarksPerQuestion() + testBaseActivity.getResources().getString(com.eduteria.app.app.R.string.neg_mark) + testBaseActivity.filteredPartListToDisplay.get(14).getNegativeMarks() + ")", 14));
                        textView18.setVisibility(0);
                        view9.setVisibility(0);
                        textView18.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity.16
                            @Override // android.view.View.OnClickListener
                            public void onClick(View v) {
                                if (TestBaseActivity.this.basicInfo.getAllow_user_move().equalsIgnoreCase("1")) {
                                    TestBaseActivity.this.nextOrPreButtonClicked = true;
                                    TestBaseActivity testBaseActivity2 = TestBaseActivity.this;
                                    testBaseActivity2.topicViewsAndClick(14, testBaseActivity2.filteredPartListToDisplay.get(14).getSectionId());
                                    TestBaseActivity testBaseActivity3 = TestBaseActivity.this;
                                    testBaseActivity3.scrollAndSelectWithFallback(testBaseActivity3.userClickedPositionUpdate, TestBaseActivity.this.filteredPartListToDisplay.get(14).getId());
                                    TestBaseActivity.this.changeTextOnNextAndPrevButton();
                                    TestBaseActivity.this.textSpinner.setText(TestBaseActivity.this.checkTitle2(TestBaseActivity.this.filteredPartListToDisplay.get(14).getName() + TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.pos_mark) + TestBaseActivity.this.filteredPartListToDisplay.get(14).getMarksPerQuestion() + TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.neg_mark) + TestBaseActivity.this.filteredPartListToDisplay.get(14).getNegativeMarks() + ")", 14));
                                } else if (!TestBaseActivity.currentSectionIdforTest.equalsIgnoreCase(TestBaseActivity.this.filteredPartListToDisplay.get(14).getSectionId())) {
                                    TestBaseActivity.this.showSectionNotAllowToast();
                                }
                                TestBaseActivity.this.popupWindow.dismiss();
                            }
                        });
                        textView3 = textView21;
                        textView2 = textView19;
                        view4 = view8;
                        view3 = view6;
                        view2 = view9;
                        break;
                    default:
                        view2 = view9;
                        textView = textView20;
                        textView3 = textView21;
                        textView2 = textView19;
                        view4 = view8;
                        view3 = view7;
                        break;
                }
                view7 = view3;
                view8 = view4;
                textView20 = textView;
                textView21 = textView3;
                textView19 = textView2;
                i = i2 + 1;
                view9 = view2;
            }
        }
        testBaseActivity.popupWindow.setFocusable(true);
        testBaseActivity.popupWindow.setBackgroundDrawable(ContextCompat.getDrawable(testBaseActivity, com.eduteria.app.app.R.drawable.background_rectangle));
        testBaseActivity.popupWindow.setWidth(-2);
        View view11 = view;
        testBaseActivity.popupWindow.showAtLocation(view11, 17, 0, 0);
        testBaseActivity.popupWindow.setContentView(view11);
        return testBaseActivity.popupWindow;
    }

    /* JADX INFO: renamed from: com.appnew.android.testmodule.activity.TestBaseActivity$7, reason: invalid class name */
    class AnonymousClass7 implements View.OnClickListener {
        AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (TestBaseActivity.this.basicInfo.getAllow_user_move().equalsIgnoreCase("1")) {
                TestBaseActivity.this.nextOrPreButtonClicked = true;
                TestBaseActivity testBaseActivity = TestBaseActivity.this;
                testBaseActivity.topicViewsAndClick(5, testBaseActivity.filteredPartListToDisplay.get(5).getSectionId());
                IntStream.range(0, TestBaseActivity.this.partList.size()).filter(new IntPredicate() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity$7$$ExternalSyntheticLambda0
                    @Override // java.util.function.IntPredicate
                    public final boolean test(int i) {
                        return this.f$0.lambda$onClick$0(i);
                    }
                }).findFirst().ifPresent(new IntConsumer() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity$7$$ExternalSyntheticLambda1
                    @Override // java.util.function.IntConsumer
                    public final void accept(int i) {
                        this.f$0.lambda$onClick$1(i);
                    }
                });
                TestBaseActivity.this.changeTextOnNextAndPrevButton();
                TestBaseActivity.this.textSpinner.setText(TestBaseActivity.this.checkTitle2(TestBaseActivity.this.filteredPartListToDisplay.get(5).getName() + TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.pos_mark) + TestBaseActivity.this.filteredPartListToDisplay.get(5).getMarksPerQuestion() + TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.neg_mark) + TestBaseActivity.this.filteredPartListToDisplay.get(5).getNegativeMarks() + ")", 5));
                TestBaseActivity.this.textSpinner.setSelected(true);
            } else if (!TestBaseActivity.currentSectionIdforTest.equalsIgnoreCase(TestBaseActivity.this.filteredPartListToDisplay.get(5).getSectionId())) {
                TestBaseActivity.this.showSectionNotAllowToast();
            }
            TestBaseActivity.this.popupWindow.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$onClick$0(int i) {
            return TestBaseActivity.this.filteredPartListToDisplay.get(5).getId() != null && TestBaseActivity.this.filteredPartListToDisplay.get(5).getId().equalsIgnoreCase(TestBaseActivity.this.partList.get(i).getId());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onClick$1(int i) {
            TestBaseActivity.this.rvNumberpad.scrollToPosition(TestBaseActivity.this.partList.get(i).getIndexOf());
            String questionType = TestBaseActivity.this.questionBankList.get(TestBaseActivity.this.partList.get(i).getIndexOf()).getQuestionType();
            questionType.hashCode();
            if (questionType.equals("MT")) {
                TestBaseActivity.this.btnClear.setVisibility(8);
                TestBaseActivity testBaseActivity = TestBaseActivity.this;
                testBaseActivity.currentPage = testBaseActivity.partList.get(i).getIndexOf();
                TestBaseActivity testBaseActivity2 = TestBaseActivity.this;
                testBaseActivity2.setFragment(SC_TestSeriesFragment.newInstance(testBaseActivity2.partList.get(i).getIndexOf(), TestBaseActivity.this.questionBankList.get(TestBaseActivity.this.partList.get(i).getIndexOf()).getQuestionType()), "selection", "1");
                return;
            }
            if (questionType.equals("FIB")) {
                TestBaseActivity.this.btnClear.setVisibility(8);
                TestBaseActivity testBaseActivity3 = TestBaseActivity.this;
                testBaseActivity3.currentPage = testBaseActivity3.partList.get(i).getIndexOf();
                TestBaseActivity testBaseActivity4 = TestBaseActivity.this;
                testBaseActivity4.setFragment(FIB_TestSeriesFragment.newInstance(testBaseActivity4.partList.get(i).getIndexOf()), "selection", "1");
                return;
            }
            TestBaseActivity.this.btnClear.setVisibility(8);
            TestBaseActivity testBaseActivity5 = TestBaseActivity.this;
            testBaseActivity5.currentPage = testBaseActivity5.partList.get(i).getIndexOf();
            TestBaseActivity testBaseActivity6 = TestBaseActivity.this;
            testBaseActivity6.setFragment(SC_TestSeriesFragment.newInstance(testBaseActivity6.partList.get(i).getIndexOf(), TestBaseActivity.this.questionBankList.get(TestBaseActivity.this.partList.get(i).getIndexOf()).getQuestionType()), "add", "1");
        }
    }

    private void setFragmentQuestionTypePartSelection(int position) {
        if (this.testseriesBase.getData().getTestBasic().getSetType() != null && this.testseriesBase.getData().getTestBasic().getSetType().equalsIgnoreCase("7")) {
            this.btnClear.setVisibility(8);
            setFragment(Instant_TestSeriesFragment.newInstance(this.partList.get(position).getIndexOf(), this.questionBankList.get(this.partList.get(position).getIndexOf()).getQuestionType()), "selection", "1");
            return;
        }
        int indexOf = this.partList.get(position).getIndexOf();
        if (indexOf != -1) {
            String questionType = this.questionBankList.get(indexOf).getQuestionType();
            questionType.hashCode();
            if (questionType.equals("MT")) {
                this.btnClear.setVisibility(0);
                this.currentPage = this.partList.get(position).getIndexOf();
                setFragment(SC_TestSeriesFragment.newInstance(this.partList.get(position).getIndexOf(), this.questionBankList.get(this.partList.get(position).getIndexOf()).getQuestionType()), "selection", "1");
                return;
            } else if (questionType.equals("FIB")) {
                this.btnClear.setVisibility(0);
                this.currentPage = this.partList.get(position).getIndexOf();
                setFragment(FIB_TestSeriesFragment.newInstance(this.partList.get(position).getIndexOf()), "selection", "1");
                return;
            } else {
                this.btnClear.setVisibility(0);
                this.currentPage = this.partList.get(position).getIndexOf();
                setFragment(SC_TestSeriesFragment.newInstance(this.partList.get(position).getIndexOf(), this.questionBankList.get(this.partList.get(position).getIndexOf()).getQuestionType()), "selection", "1");
                return;
            }
        }
        Toast.makeText(this, "Questions not available", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String checkTitle2(String title, int position) {
        if (!TextUtils.isEmpty(this.filteredPartListToDisplay.get(position).getSection_aliase())) {
            return this.filteredPartListToDisplay.get(position).getSection_aliase();
        }
        return this.filteredPartListToDisplay.get(position).getName().toString();
    }

    private void dismissPopup() {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Log.e(TAG, "onResume.");
        if (SharedPreference.getInstance().getString("theme_color_hai_bhai") == null || TextUtils.isEmpty(SharedPreference.getInstance().getString("theme_color_hai_bhai"))) {
            return;
        }
        changeThemeColor(SharedPreference.getInstance().getString("theme_color_hai_bhai"));
    }

    public void changeThemeColor(String color) {
        if (!color.contains(":") || color.split(":").length <= 1) {
            return;
        }
        SharedPreference.getInstance().putString("theme_color_hai_bhai", color);
        this.drawerLayout.setBackgroundColor(Color.parseColor(color.split(":")[0]));
        this.toolbar.setBackgroundColor(Color.parseColor(color.split(":")[0]));
        this.imgTestBack.setColorFilter(Color.parseColor(color.split(":")[1]), PorterDuff.Mode.SRC_IN);
        this.imgTestMenu.setColorFilter(Color.parseColor(color.split(":")[1]), PorterDuff.Mode.SRC_IN);
        this.testSeriesName.setTextColor(Color.parseColor(color.split(":")[1]));
        this.btn_submit.setTextColor(Color.parseColor(color.split(":")[1]));
        this.btnNext.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(color.split(":")[0])));
        this.btn_submit.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(color.split(":")[0])));
        Window window = getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.clearFlags(67108864);
        window.setStatusBarColor(Color.parseColor(color.split(":")[0]));
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
        if (!this.test_submission.equalsIgnoreCase("1") || !Helper.isTestResume(this.testseriesBase.getData().getTestBasic().getSetType()) || this.testsubmit || this.builderShowing) {
            return;
        }
        this.isPause = true;
        UtkashRoom.getAppDatabase(this.context).getTestResumeDao().delete_test_data(this.testseriesid);
        finishTestSeries();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
        if (BuildConfig.FLAVOR.equalsIgnoreCase("Clatprep")) {
            if (this.testsubmit) {
                return;
            }
            this.testsubmit = true;
            finishTestSeries();
            return;
        }
        if (this.testTimeFinish) {
            this.testTimeFinish = false;
            finishTestSeries();
        }
    }

    private void setTimer() {
        this.status = true;
        if (this.resumeDump.getTime_remain() != null) {
            if (!TextUtils.isEmpty(this.resumeDump.getTime_remain())) {
                this.millisInFuture = Integer.parseInt(this.resumeDump.getTime_remain()) * 1000;
            }
        } else if (this.questionBankList.get(this.currentPage).isPause()) {
            this.millisInFuture = this.data.getTestBasic().getTimeRemaining();
        } else if (this.first_attempt.equalsIgnoreCase("1")) {
            this.millisInFuture = Integer.parseInt(this.data.getTestBasic().getTimeInMins()) * DateTimeConstants.MILLIS_PER_MINUTE;
            if (this.enddate.longValue() - this.time_server.longValue() < Integer.parseInt(this.data.getTestBasic().getTimeInMins()) * 60) {
                this.millisInFuture = (this.enddate.longValue() - this.time_server.longValue()) * 1000;
                Log.d("prince", "" + this.enddate);
                Log.d("prince", "" + this.time_server);
                Log.d("prince", "" + this.millisInFuture);
            }
        } else {
            this.millisInFuture = Integer.parseInt(this.data.getTestBasic().getTimeInMins()) * DateTimeConstants.MILLIS_PER_MINUTE;
        }
        CountDownTimer countDownTimer = new CountDownTimer(this.millisInFuture, 1000L) { // from class: com.appnew.android.testmodule.activity.TestBaseActivity.17
            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                TestBaseActivity.this.count = millisUntilFinished / 1000;
                TextView textView = TestBaseActivity.this.tvTime;
                TestBaseActivity testBaseActivity = TestBaseActivity.this;
                textView.setText(testBaseActivity.formatSeconds((int) testBaseActivity.count));
                TestBaseActivity.this.data.getTestBasic().setTimeRemaining(millisUntilFinished);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                TestBaseActivity.this.status = false;
                TestBaseActivity.this.tvTime.setText("00:00:00");
                TestBaseActivity.this.questionBankList.get(TestBaseActivity.this.currentPage).setPause(false);
                TestBaseActivity.this.state = "1";
                if (TestBaseActivity.this.isFinishing()) {
                    return;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(TestBaseActivity.this);
                builder.setTitle(TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.time_out));
                builder.setMessage(TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.time_over_message));
                builder.setCancelable(false);
                builder.setNegativeButton(Html.fromHtml("<font color='#000000'>Ok</font>"), new DialogInterface.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity.17.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        TestBaseActivity.this.testsubmit = true;
                        UtkashRoom.getAppDatabase(TestBaseActivity.this.context).getTestResumeDao().delete_test_data(TestBaseActivity.this.testseriesid);
                        Log.e("TAG_APP", "onClick: testseriesid " + TestBaseActivity.this.testseriesid);
                        TestBaseActivity.this.finishTestSeries();
                    }
                });
                AlertDialog alertDialogCreate = builder.create();
                if (TestBaseActivity.this.isFinishing()) {
                    return;
                }
                try {
                    TestBaseActivity.this.builderShowing = true;
                    alertDialogCreate.show();
                } catch (Exception unused) {
                    TestBaseActivity.this.builderShowing = false;
                }
            }
        };
        this.countDownTimer = countDownTimer;
        countDownTimer.start();
    }

    public void perQuestionTimer(TextView tv_timer) {
        Runnable runnable;
        this.tv_timer = tv_timer;
        Log.d("TotalTimeSpentClass", "TotalTimeSpent: " + this.questionBankList.get(this.currentPage).getTotalTimeSpent());
        this.seconds = !TextUtils.isEmpty(String.valueOf(this.questionBankList.get(this.currentPage).getTotalTimeSpent())) ? this.questionBankList.get(this.currentPage).getTotalTimeSpent() : 0;
        Handler handler = this.quesTimeHandler;
        if (handler != null && (runnable = this.runnable) != null) {
            handler.removeCallbacks(runnable);
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.quesTimeHandler = handler2;
        handler2.post(this.runnable);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        Runnable runnable;
        Log.e(TAG, "onDestroy");
        Handler handler = this.quesTimeHandler;
        if (handler != null && (runnable = this.runnable) != null) {
            handler.removeCallbacks(runnable);
        }
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        super.onDestroy();
        if (!this.test_submission.equalsIgnoreCase("1") || !Helper.isTestResume(this.testseriesBase.getData().getTestBasic().getSetType()) || this.testsubmit || this.builderShowing) {
            return;
        }
        this.isPause = true;
        if (this.first_attempt.equalsIgnoreCase("1")) {
            this.state = "0";
            finishTestSeries();
        }
    }

    public void revision() {
        Constants.revison_set = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishTestSeries() {
        this.lastView = String.valueOf(this.currentPage);
        this.answerList = new ArrayList<>();
        List<QuestionDump> list = this.questionDumpList;
        int i = 0;
        if (list != null && list.size() > 0) {
            while (i < this.questionBankList.size()) {
                this.answerList.add(makeAnswerArray2(i));
                i++;
            }
        } else {
            while (i < this.questionBankList.size()) {
                this.answerList.add(makeAnswerArray(i));
                i++;
            }
        }
        String json = new Gson().toJson(this.answerList);
        HashMap<String, String> map = new HashMap<>();
        map.put("user_id", SharedPreference.getInstance().getLoggedInUser().getId());
        map.put("test_id", this.testseriesid);
        if (Helper.isTestResume(this.testseriesBase.getData().getTestBasic().getSetType())) {
            map.put("state", this.state);
        } else {
            map.put("state", "1");
        }
        map.put(Const.LAST_VIEW, this.lastView);
        map.put("first_attempt", this.first_attempt);
        map.put("lastSection", String.valueOf(this.count1));
        if (!this.isPause) {
            map.put(Const.IS_PAUSED, "0");
        }
        map.put(Const.LANG_USED, String.valueOf(this.language));
        String str = this.course_id;
        if (str != null && !str.equalsIgnoreCase("")) {
            map.put("course_id", this.course_id);
        } else {
            String string = SharedPreference.getInstance().getString("id");
            this.course_id = string;
            map.put("course_id", string);
        }
        map.put(Const.TIME_REMAIN, String.valueOf(this.data.getTestBasic().getTimeRemaining() / 1000));
        map.put("question_dump", json);
        if (this.first_attempt.equalsIgnoreCase("1")) {
            if (this.test_submission.equalsIgnoreCase("0")) {
                submit_s3(map);
                return;
            } else {
                netoworkCallSubmitTestseries(map);
                return;
            }
        }
        netoworkCallSubmitTestseries(map);
    }

    private void saveDataDB() {
        HashMap map = new HashMap();
        map.put("question_dump_new", this.answerList);
        TestResumeTable testResumeTable = new TestResumeTable(SharedPreference.getInstance().getLoggedInUser().getId(), this.testseriesid, this.currentPage, String.valueOf(this.data.getTestBasic().getTimeRemaining() / 1000), new Gson().toJson(map));
        if (this.isPause) {
            UtkashRoom.getAppDatabase(this).getTestResumeDao().insert(testResumeTable);
        }
    }

    private void submit_s3(HashMap<String, String> finalResponse) {
        try {
            Helper.showProgressDialog(this);
            String id = SharedPreference.getInstance().getLoggedInUser().getId();
            MakeMyExam.userId = id;
            MakeMyExam.setUserId(id);
            HashMap<String, String> map = new HashMap<>();
            map.put(Const.DEVICE_TYPE, "1");
            map.put(Const.GET_DIVISION, Helper.getDivisionID() != null ? Helper.getDivisionID() : "0");
            map.put(Const.GET_SUB_DIVISION, Helper.getSubDivisionID() != null ? Helper.getSubDivisionID() : "0");
            map.put(Const.MOBILE, Helper.getUserMobile() != null ? Helper.getUserMobile() : "");
            map.put(Const.USERID, id);
            map.put(Const.Jwt, !TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.JWT)) ? SharedPreference.getInstance().getString(Const.JWT) : "");
            map.put(Const.LANG, String.valueOf(SharedPreference.getInstance().getInt(Const.LANGUAGE)));
            map.put("Version", !TextUtils.isEmpty(SharedPreference.getInstance().getString("Version")) ? SharedPreference.getInstance().getString("Version") : "");
            map.put("Authorization", API.Bearer);
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setHeader(map);
            encryptionData.setBody(finalResponse);
            String str = "U" + id + "_T" + this.testseriesid + "_C" + this.course_id + ".json";
            s3ImageUploading.test_file_name = str;
            String strGenerateNoteOnSD = generateNoteOnSD(this, str, new Gson().toJson(encryptionData));
            Log.d("prince", "" + new Gson().toJson(encryptionData));
            if (Helper.isNetworkConnected(this)) {
                s3ImageUploading s3imageuploading = new s3ImageUploading(this.testseriesid, "vc-10000386-38616500102/166/admin_v1/test_management/question_bank/", this, this, null);
                ArrayList arrayList = new ArrayList();
                MediaFile mediaFile = new MediaFile();
                mediaFile.setFile_name(str);
                mediaFile.setFile_type("json");
                mediaFile.setFile(strGenerateNoteOnSD);
                arrayList.add(mediaFile);
                s3imageuploading.execute(arrayList);
                return;
            }
            Snackbar.make(this.drawerLayout.getRootView(), getResources().getString(com.eduteria.app.app.R.string.no_internet_connection), -1).show();
            String str2 = this.result_date;
            if (str2 == null || str2.equalsIgnoreCase("0") || this.result_date.equalsIgnoreCase("1") || this.result_date.equalsIgnoreCase("")) {
                Constants.REFRESHPAGE = "true";
                Constants.REFRESHPAGENEW = "true";
                revision();
                Intent intent = new Intent(this, (Class<?>) TestSubmissionActivity.class);
                intent.putExtra("result_date", this.result_date);
                intent.putExtra(AnalyticsConstants.test_name, this.testSeriesName.getText().toString());
                Helper.gotoActivity_finish(intent, this);
                return;
            }
            Constants.REFRESHPAGE = "true";
            Constants.REFRESHPAGENEW = "true";
            revision();
            Intent intent2 = new Intent(this, (Class<?>) TestSubmissionActivity.class);
            intent2.putExtra("result_date", this.result_date);
            intent2.putExtra(AnalyticsConstants.test_name, this.testSeriesName.getText().toString());
            Helper.gotoActivity_finish(intent2, this);
        } catch (Exception e2) {
            netoworkCallSubmitTestseries(finalResponse);
            e2.printStackTrace();
        }
    }

    public String formatSeconds(int timeInSeconds) {
        Log.d("prince", "" + timeInSeconds);
        int i = timeInSeconds / 3600;
        int i2 = timeInSeconds - (i * 3600);
        int i3 = i2 / 60;
        int i4 = i2 - (i3 * 60);
        if (i4 != this.prevSeconds) {
            this.prevSeconds = i4;
        }
        if (this.testseriesBase.getData().getTestBasic().getLangId().size() == 2) {
            this.questionBankList.get(this.currentPage).setTotalTimeSpent(this.questionBankList.get(this.currentPage).getTotalTimeSpent() + 1);
            if (this.changelang.getText().equals("E/H")) {
                if (this.data.getQuestions() != null && this.data.getQuestions().size() > 0) {
                    this.data.getQuestions().get(this.currentPage).setTotalTimeSpent(this.questionBankList.get(this.currentPage).getTotalTimeSpent());
                }
            } else if (this.changelang.getText().equals("H/E") && this.data.getQuestionsHindi() != null && this.data.getQuestionsHindi().size() > 0) {
                this.data.getQuestionsHindi().get(this.currentPage).setTotalTimeSpent(this.questionBankList.get(this.currentPage).getTotalTimeSpent());
            }
        } else {
            this.questionBankList.get(this.currentPage).setTotalTimeSpent(this.questionBankList.get(this.currentPage).getTotalTimeSpent() + 1);
        }
        String str = (i < 10 ? "0" : "") + i + ":";
        if (i3 < 10) {
            str = str + "0";
        }
        String str2 = str + i3 + ":";
        if (i4 < 10) {
            str2 = str2 + "0";
        }
        return str2 + i4;
    }

    private void setGridData() {
        TestBaseActivity testBaseActivity;
        if (this.changelang.getText().equals("H/E")) {
            this.questionBankList = this.data.getQuestionsHindi();
            List<QuestionDump> list = this.questionDumpList;
            if (list != null && list.size() > 0) {
                testBaseActivity = this;
                testBaseActivity.rvNumberPadAdapter = new MyRecyclerAdapter(this.questionBankList2, this, this.items, com.eduteria.app.app.R.layout.single_row_testpad_no, this);
            } else {
                testBaseActivity = this;
                testBaseActivity.rvNumberPadAdapter = new MyRecyclerAdapter(testBaseActivity.questionBankList, testBaseActivity, testBaseActivity.items, com.eduteria.app.app.R.layout.single_row_testpad_no, this);
            }
            testBaseActivity.rvNumberpad.setAdapter(testBaseActivity.rvNumberPadAdapter);
            testBaseActivity.rvNumberpad.setLayoutManager(new LinearLayoutManagerWithSmoothScroller(this, 0, false));
            testBaseActivity.rvNumberpad.setItemAnimator(new DefaultItemAnimator());
            return;
        }
        if (this.changelang.getText().equals("E/H")) {
            this.questionBankList = this.data.getQuestions();
            List<QuestionDump> list2 = this.questionDumpList;
            if (list2 != null && list2.size() > 0) {
                this.rvNumberPadAdapter = new MyRecyclerAdapter(this.questionBankList2, this, this.items, com.eduteria.app.app.R.layout.single_row_testpad_no, this);
            } else {
                this.rvNumberPadAdapter = new MyRecyclerAdapter(this.questionBankList, this, this.items, com.eduteria.app.app.R.layout.single_row_testpad_no, this);
            }
            this.rvNumberpad.setAdapter(this.rvNumberPadAdapter);
            this.rvNumberpad.setLayoutManager(new LinearLayoutManagerWithSmoothScroller(this, 0, false));
            this.rvNumberpad.setItemAnimator(new DefaultItemAnimator());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ArrayList<Question> arrayList;
        ArrayList<Question> arrayList2;
        switch (view.getId()) {
            case com.eduteria.app.app.R.id.btn_clear /* 2131362363 */:
                this.pauseCount = false;
                this.nextOrPreButtonClicked = false;
                if (this.testseriesBase.getData().getTestBasic().getLangId().size() == 2) {
                    if (this.data.getQuestionsHindi() != null && this.data.getQuestionsHindi().size() > 0 && (this.data.getQuestionsHindi().get(this.currentPage).isIssaveMarkForReview() || this.data.getQuestionsHindi().get(this.currentPage).isMarkForReview())) {
                        this.data.getQuestionsHindi().get(this.currentPage).setIssaveMarkForReview(false);
                        this.data.getQuestionsHindi().get(this.currentPage).setMarkForReview(false);
                    }
                    if (this.data.getQuestions() != null && this.data.getQuestions().size() > 0 && (this.data.getQuestions().get(this.currentPage).isIssaveMarkForReview() || this.data.getQuestions().get(this.currentPage).isMarkForReview())) {
                        this.data.getQuestions().get(this.currentPage).setIssaveMarkForReview(false);
                        this.data.getQuestions().get(this.currentPage).setMarkForReview(false);
                    }
                    if (this.questionBankList2.size() > 0 && (arrayList2 = this.questionBankList2) != null) {
                        arrayList2.get(this.currentPage).setIssaveMarkForReview(false);
                        this.questionBankList2.get(this.currentPage).setMarkForReview(false);
                    }
                    Fragment fragment = this.sc_testSeriesFragment;
                    if (fragment != null && (fragment instanceof SC_TestSeriesFragment)) {
                        ((SC_TestSeriesFragment) fragment).setMarkForReviewStatus();
                    } else if (fragment != null && (fragment instanceof FIB_TestSeriesFragment)) {
                        ((FIB_TestSeriesFragment) fragment).setMarkForReviewStatus();
                    } else if (fragment != null && (fragment instanceof Instant_TestSeriesFragment)) {
                        ((Instant_TestSeriesFragment) fragment).setMarkForReviewStatus();
                    }
                } else {
                    if (this.data.getQuestionsHindi() != null && this.data.getQuestionsHindi().size() > 0 && (this.data.getQuestionsHindi().get(this.currentPage).isIssaveMarkForReview() || this.data.getQuestionsHindi().get(this.currentPage).isMarkForReview())) {
                        this.data.getQuestionsHindi().get(this.currentPage).setIssaveMarkForReview(false);
                        this.data.getQuestionsHindi().get(this.currentPage).setMarkForReview(false);
                    }
                    if (this.data.getQuestions() != null && this.data.getQuestions().size() > 0 && (this.data.getQuestions().get(this.currentPage).isIssaveMarkForReview() || this.data.getQuestions().get(this.currentPage).isMarkForReview())) {
                        this.data.getQuestions().get(this.currentPage).setIssaveMarkForReview(false);
                        this.data.getQuestions().get(this.currentPage).setMarkForReview(false);
                    }
                    if (this.questionBankList2.size() > 0 && (arrayList = this.questionBankList2) != null) {
                        arrayList.get(this.currentPage).setIssaveMarkForReview(false);
                        this.questionBankList2.get(this.currentPage).setMarkForReview(false);
                    }
                }
                if (this.questionBankList.get(this.currentPage).getQuestionType().equalsIgnoreCase("FIB")) {
                    ((FIB_TestSeriesFragment) getSupportFragmentManager().findFragmentById(com.eduteria.app.app.R.id.testlayout)).refereshPage();
                } else {
                    ((SC_TestSeriesFragment) getSupportFragmentManager().findFragmentById(com.eduteria.app.app.R.id.testlayout)).refereshPage();
                }
                Fragment fragment2 = this.sc_testSeriesFragment;
                if (fragment2 != null && (fragment2 instanceof SC_TestSeriesFragment)) {
                    ((SC_TestSeriesFragment) fragment2).setMarkForReviewStatus();
                } else if (fragment2 != null && (fragment2 instanceof FIB_TestSeriesFragment)) {
                    ((FIB_TestSeriesFragment) fragment2).setMarkForReviewStatus();
                } else if (fragment2 != null && (fragment2 instanceof Instant_TestSeriesFragment)) {
                    ((Instant_TestSeriesFragment) fragment2).setMarkForReviewStatus();
                }
                notifynumberApater();
                break;
            case com.eduteria.app.app.R.id.btn_finish /* 2131362371 */:
                if (!isFinishing()) {
                    this.isPause = false;
                }
                showPopupSubmitTest();
                break;
            case com.eduteria.app.app.R.id.btn_next /* 2131362374 */:
                this.pauseCount = false;
                this.nextOrPreButtonClicked = false;
                if (!this.basicInfo.getAllow_user_move().equalsIgnoreCase("1")) {
                    List<QuestionDump> list = this.questionDumpList;
                    if (list != null && list.size() > 0) {
                        if (resumeSectionIdforTest.equalsIgnoreCase(this.questionBankList.get(this.currentPage + 1).getSubjectId())) {
                            this.testseriesBase.setLastanswerPosition(this.currentPage);
                            setFragmentQuestionTypeAdd();
                            setPart();
                            highlightSelectedTopic(this.questionBankList.get(this.currentPage).getTopic_id());
                            changeTextOnNextAndPrevButton();
                        } else {
                            showSectionNotAllowToast();
                        }
                    } else if (currentSectionIdforTest.equalsIgnoreCase(this.questionBankList.get(this.currentPage + 1).getSubjectId())) {
                        this.testseriesBase.setLastanswerPosition(this.currentPage);
                        setFragmentQuestionTypeAdd();
                        setPart();
                        highlightSelectedTopic(this.questionBankList.get(this.currentPage).getTopic_id());
                        changeTextOnNextAndPrevButton();
                    } else {
                        showSectionNotAllowToast();
                    }
                } else {
                    this.testseriesBase.setLastanswerPosition(this.currentPage);
                    setFragmentQuestionTypeAdd();
                    setPart();
                    highlightSelectedTopic(this.questionBankList.get(this.currentPage).getTopic_id());
                    changeTextOnNextAndPrevButton();
                }
                break;
            case com.eduteria.app.app.R.id.btn_prev /* 2131362376 */:
                this.pauseCount = false;
                this.nextOrPreButtonClicked = false;
                if (this.basicInfo.getAllow_user_move().equalsIgnoreCase("1")) {
                    this.testseriesBase.setLastanswerPosition(this.currentPage - 1);
                    setFragmentQuestionTypeRemove();
                    setPart();
                    highlightSelectedTopic(this.questionBankList.get(this.currentPage).getTopic_id());
                    changeTextOnNextAndPrevButton();
                } else {
                    try {
                        List<QuestionDump> list2 = this.questionDumpList;
                        if (list2 != null && list2.size() > 0) {
                            if (resumeSectionIdforTest.equalsIgnoreCase(this.questionBankList.get(this.currentPage - 1).getSubjectId())) {
                                this.testseriesBase.setLastanswerPosition(this.currentPage - 1);
                                setFragmentQuestionTypeRemove();
                                setPart();
                                highlightSelectedTopic(this.questionBankList.get(this.currentPage).getTopic_id());
                                changeTextOnNextAndPrevButton();
                            } else {
                                showSectionNotAllowToast();
                            }
                        } else if (currentSectionIdforTest.equalsIgnoreCase(this.questionBankList.get(this.currentPage - 1).getSubjectId())) {
                            this.testseriesBase.setLastanswerPosition(this.currentPage - 1);
                            setFragmentQuestionTypeRemove();
                            setPart();
                            highlightSelectedTopic(this.questionBankList.get(this.currentPage).getTopic_id());
                            changeTextOnNextAndPrevButton();
                        } else {
                            showSectionNotAllowToast();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                break;
            case com.eduteria.app.app.R.id.calci /* 2131362415 */:
                openCalculator_web(this);
                break;
            case com.eduteria.app.app.R.id.cl_part /* 2131362577 */:
            case com.eduteria.app.app.R.id.dropdown_icon /* 2131363053 */:
                ArrayList<TestSection> arrayList3 = this.partList;
                if (arrayList3 != null && arrayList3.size() > 1) {
                    this.popUp.showAsDropDown(view, 0, 0);
                    break;
                }
                break;
            case com.eduteria.app.app.R.id.gridView /* 2131363455 */:
                SharedPreference.getInstance().putString("VIEW", "0");
                this.rlQuestionPad.setLayoutManager(new GridLayoutManager((Context) this, 6, 1, false));
                this.gridView.setTextColor(getResources().getColor(com.eduteria.app.app.R.color.country_code_text_color));
                this.gridView.setCompoundDrawablesWithIntrinsicBounds(com.eduteria.app.app.R.mipmap.grid_view, 0, 0, 0);
                this.listView.setCompoundDrawablesWithIntrinsicBounds(com.eduteria.app.app.R.mipmap.list_view_gray, 0, 0, 0);
                this.listView.setTextColor(getResources().getColor(com.eduteria.app.app.R.color.colorGray3));
                MyRecyclerAdapterTwo myRecyclerAdapterTwo = new MyRecyclerAdapterTwo(this.questionBankList, this, this.items, com.eduteria.app.app.R.layout.single_row_testpad_no, this, "0");
                this.rvQuestionAdapter = myRecyclerAdapterTwo;
                myRecyclerAdapterTwo.setSelectePosition(this.currentPage);
                this.rlQuestionPad.setAdapter(this.rvQuestionAdapter);
                break;
            case com.eduteria.app.app.R.id.img_pause /* 2131363703 */:
            case com.eduteria.app.app.R.id.img_testback /* 2131363712 */:
                this.isPause = true;
                showPopupSubmitTest();
                break;
            case com.eduteria.app.app.R.id.img_testmenu /* 2131363713 */:
                CountTotalanswer();
                this.drawerLayout.openDrawer(this.llDrawerRight);
                break;
            case com.eduteria.app.app.R.id.listView /* 2131364011 */:
                SharedPreference.getInstance().putString("VIEW", "1");
                this.rlQuestionPad.setLayoutManager(new LinearLayoutManagerWithSmoothScroller(this, 1, false));
                this.listView.setTextColor(getResources().getColor(com.eduteria.app.app.R.color.country_code_text_color));
                this.listView.setCompoundDrawablesWithIntrinsicBounds(com.eduteria.app.app.R.mipmap.list_view, 0, 0, 0);
                this.gridView.setCompoundDrawablesWithIntrinsicBounds(com.eduteria.app.app.R.mipmap.grid_view_gray, 0, 0, 0);
                this.gridView.setTextColor(getResources().getColor(com.eduteria.app.app.R.color.colorGray3));
                MyRecyclerAdapterTwo myRecyclerAdapterTwo2 = new MyRecyclerAdapterTwo(this.questionBankList, this, this.items, com.eduteria.app.app.R.layout.single_row_testpad_no, this, "1");
                this.rvQuestionAdapter = myRecyclerAdapterTwo2;
                myRecyclerAdapterTwo2.setSelectePosition(this.currentPage);
                this.rlQuestionPad.setAdapter(this.rvQuestionAdapter);
                break;
            case com.eduteria.app.app.R.id.move_to_section /* 2131364302 */:
                if (this.drawerLayout.isDrawerOpen(this.llDrawerRight)) {
                    this.drawerLayout.closeDrawer(this.llDrawerRight);
                }
                dialogSwitchSection();
                break;
        }
    }

    private void setFragmentQuestionTypeRemove() {
        if (this.testseriesBase.getData().getTestBasic().getSetType() != null && this.testseriesBase.getData().getTestBasic().getSetType().equalsIgnoreCase("7")) {
            this.btnClear.setVisibility(8);
            int i = this.currentPage;
            setFragment(Instant_TestSeriesFragment.newInstance(i - 1, this.questionBankList.get(i - 1).getQuestionType()), "remove", "1");
            return;
        }
        String questionType = this.questionBankList.get(this.currentPage - 1).getQuestionType();
        questionType.hashCode();
        if (questionType.equals("MT")) {
            this.btnClear.setVisibility(0);
            int i2 = this.currentPage;
            setFragment(SC_TestSeriesFragment.newInstance(i2 - 1, this.questionBankList.get(i2 - 1).getQuestionType()), "remove", "1");
        } else if (questionType.equals("FIB")) {
            this.btnClear.setVisibility(0);
            setFragment(FIB_TestSeriesFragment.newInstance(this.currentPage - 1), "remove", "1");
        } else {
            this.btnClear.setVisibility(0);
            int i3 = this.currentPage;
            setFragment(SC_TestSeriesFragment.newInstance(i3 - 1, this.questionBankList.get(i3 - 1).getQuestionType()), "remove", "1");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFragmentQuestionTypeAdd() {
        if (this.testseriesBase.getData().getTestBasic().getSetType() != null && this.testseriesBase.getData().getTestBasic().getSetType().equalsIgnoreCase("7")) {
            this.btnClear.setVisibility(8);
            int i = this.currentPage;
            setFragment(Instant_TestSeriesFragment.newInstance(i + 1, this.questionBankList.get(i + 1).getQuestionType()), "add", "1");
            return;
        }
        String questionType = this.questionBankList.get(this.currentPage + 1).getQuestionType();
        questionType.hashCode();
        if (questionType.equals("MT")) {
            this.btnClear.setVisibility(0);
            int i2 = this.currentPage;
            setFragment(SC_TestSeriesFragment.newInstance(i2 + 1, this.questionBankList.get(i2 + 1).getQuestionType()), "add", "1");
        } else if (questionType.equals("FIB")) {
            this.btnClear.setVisibility(0);
            setFragment(FIB_TestSeriesFragment.newInstance(this.currentPage + 1), "add", "1");
        } else {
            this.btnClear.setVisibility(0);
            int i3 = this.currentPage;
            setFragment(SC_TestSeriesFragment.newInstance(i3 + 1, this.questionBankList.get(i3 + 1).getQuestionType()), "add", "1");
        }
    }

    private void dialogSwitchSection() {
        String string;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(com.eduteria.app.app.R.string.alert));
        if (this.count1 < this.filteredPartListToDisplay.size()) {
            string = getResources().getString(com.eduteria.app.app.R.string.do_you_want_to_switch_the_next_section_after_this_you_will_not_be_able_to_access_the_previous_one);
        } else {
            string = getResources().getString(com.eduteria.app.app.R.string.this_is_the_last_section_do_you_want_to_submit_the_test);
        }
        builder.setMessage(string).setCancelable(false).setPositiveButton(getResources().getString(com.eduteria.app.app.R.string.yes), new DialogInterface.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity$$ExternalSyntheticLambda26
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$dialogSwitchSection$14(dialogInterface, i);
            }
        }).setNegativeButton(getResources().getString(com.eduteria.app.app.R.string.no), new DialogInterface.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dialogSwitchSection$14(DialogInterface dialogInterface, int i) {
        this.pauseCount = false;
        this.nextOrPreButtonClicked = false;
        if (this.currentPage < 1) {
            this.currentPage = 1;
        }
        List<QuestionDump> list = this.questionDumpList;
        if (list != null && list.size() > 0) {
            if (this.sectionCount < this.filteredPartListToDisplay.size()) {
                this.btnNext.setVisibility(0);
                this.noOfQus = 1;
                IntStream.range(0, this.partList.size()).filter(new IntPredicate() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity$$ExternalSyntheticLambda22
                    @Override // java.util.function.IntPredicate
                    public final boolean test(int i2) {
                        return this.f$0.lambda$dialogSwitchSection$10(i2);
                    }
                }).findFirst().ifPresent(new IntConsumer() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity$$ExternalSyntheticLambda23
                    @Override // java.util.function.IntConsumer
                    public final void accept(int i2) {
                        this.f$0.lambda$dialogSwitchSection$11(i2);
                    }
                });
                this.lastSection = getLastSection(this.questionBankList.get(this.currentPage + 1).getSubjectId());
                setPart();
                changeTextOnNextAndPrevButton();
                this.sectionCount++;
                this.countDownTimer.cancel();
                setTimerN();
                return;
            }
            if (isFinishing()) {
                return;
            }
            showPopupSubmitTest();
            return;
        }
        if (this.count1 < this.filteredPartListToDisplay.size()) {
            this.btnNext.setVisibility(0);
            this.noOfQus = 1;
            IntStream.range(0, this.partList.size()).filter(new IntPredicate() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity$$ExternalSyntheticLambda24
                @Override // java.util.function.IntPredicate
                public final boolean test(int i2) {
                    return this.f$0.lambda$dialogSwitchSection$12(i2);
                }
            }).findFirst().ifPresent(new IntConsumer() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity$$ExternalSyntheticLambda25
                @Override // java.util.function.IntConsumer
                public final void accept(int i2) {
                    this.f$0.lambda$dialogSwitchSection$13(i2);
                }
            });
            this.lastSection = getLastSection(this.questionBankList.get(this.currentPage + 1).getSubjectId());
            setPart();
            changeTextOnNextAndPrevButton();
            this.count1++;
            this.countDownTimer.cancel();
            setTimerN();
            return;
        }
        if (isFinishing()) {
            return;
        }
        showPopupSubmitTest();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$dialogSwitchSection$10(int i) {
        return this.filteredPartListToDisplay.get(this.sectionCount).getId() != null && this.filteredPartListToDisplay.get(this.sectionCount).getId().equalsIgnoreCase(this.partList.get(i).getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dialogSwitchSection$11(int i) {
        this.rvNumberpad.scrollToPosition(this.partList.get(i).getIndexOf());
        this.testseriesBase.setLastanswerPosition(i);
        this.currentPage = this.partList.get(i).getIndexOf() - 1;
        resumeSectionIdforTest = this.partList.get(i).getSectionId();
        currentSectionIdforTest = this.partList.get(i).getSectionId();
        setFragmentQuestionTypeAdd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$dialogSwitchSection$12(int i) {
        return this.filteredPartListToDisplay.get(this.count1).getId() != null && this.filteredPartListToDisplay.get(this.count1).getId().equalsIgnoreCase(this.partList.get(i).getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dialogSwitchSection$13(int i) {
        this.rvNumberpad.scrollToPosition(this.partList.get(i).getIndexOf());
        this.testseriesBase.setLastanswerPosition(i);
        this.currentPage = this.partList.get(i).getIndexOf() - 1;
        resumeSectionIdforTest = this.partList.get(i).getSectionId();
        currentSectionIdforTest = this.partList.get(i).getSectionId();
        setFragmentQuestionTypeAdd();
    }

    public void changeTextOnNextAndPrevButton() {
        if (this.drawerLayout.isDrawerOpen(this.llDrawerRight)) {
            this.drawerLayout.closeDrawer(this.llDrawerRight);
        }
        int i = this.currentPage;
        if (i == this.questionBankList.size() - 1) {
            this.btn_finish.setVisibility(0);
            this.btnNext.setVisibility(8);
        } else {
            this.btn_finish.setVisibility(8);
            this.btnNext.setVisibility(0);
        }
        if (i == this.questionBankList.size() - 1) {
            this.btnNext.setEnabled(false);
        } else {
            this.btnNext.setEnabled(true);
        }
        if (i == 0) {
            ((TextView) this.btnPrev.getChildAt(0)).setTextColor(getResources().getColor(com.eduteria.app.app.R.color.white));
            this.btnPrev.setBackground(ContextCompat.getDrawable(this, com.eduteria.app.app.R.drawable.background_bg_prev));
            this.btnPrev.setEnabled(false);
        } else {
            ((TextView) this.btnPrev.getChildAt(0)).setTextColor(getResources().getColor(com.eduteria.app.app.R.color.whiteApp));
            this.btnPrev.setBackground(ContextCompat.getDrawable(this, com.eduteria.app.app.R.drawable.background_bg_next));
            this.btnPrev.setEnabled(true);
        }
    }

    public Answers makeAnswerArray(int position) {
        String str = this.questionBankList.get(position).getIs_bookmarked().equalsIgnoreCase("0") ? "0" : "1";
        String str2 = "answered";
        String str3 = "";
        if (!this.questionBankList.get(position).isIssaveMarkForReview()) {
            if (this.questionBankList.get(position).isMarkForReview() && this.questionBankList.get(position).getAnswerPosttion() != -1 && this.questionBankList.get(position).getAnswerPosttion() != 0) {
                str3 = "marked_for_review";
            } else if (this.questionBankList.get(position).getAnswerPosttion() == -1 || this.questionBankList.get(position).getAnswerPosttion() == 0) {
                if (this.questionBankList.get(position).isMarkForReview()) {
                    str2 = "marked_for_review";
                } else if (this.questionBankList.get(position).getAnswerPosttion() == -1) {
                    str2 = "not_visited";
                } else {
                    str2 = this.questionBankList.get(position).getAnswerPosttion() == 0 ? "unanswered" : "";
                }
            }
        }
        Answers answers = new Answers();
        answers.setConfig_id(this.questionBankList.get(position).getConfigId());
        answers.setSection_id(this.questionBankList.get(position).getSectionId());
        answers.setSection_question_behaviour(this.questionBankList.get(position).getSection_question_behaviour());
        answers.setSubject_id(this.questionBankList.get(position).getSubjectId());
        answers.setIndex(String.valueOf(position));
        answers.setState(str2);
        answers.setIsanswer(this.questionBankList.get(position).isIsanswer());
        answers.setAnswerBookmark(str3);
        answers.setAnswerPosition(this.questionBankList.get(position).getAnswerPosition());
        answers.setIs_bookmarked(str);
        answers.setAnswers(this.questionBankList.get(position).getAnswers());
        answers.setSelectedString(this.questionBankList.get(position).getSelectedString());
        answers.setSelectedValue(this.questionBankList.get(position).getSelectedValue());
        answers.setOn_screen(String.valueOf(this.questionBankList.get(position).getTotalTimeSpent()));
        answers.setTopic_id(this.questionBankList.get(position).getTopic_id());
        answers.setTopic_name(this.questionBankList.get(position).getTopic_name());
        answers.setIs_topic_enabled(this.questionBankList.get(position).getIs_topic_enabled());
        return answers;
    }

    public Answers makeAnswerArray2(int position) {
        String str = this.questionBankList2.get(position).getIs_bookmarked().equalsIgnoreCase("0") ? "0" : "1";
        String str2 = "answered";
        String str3 = "";
        if (!this.questionBankList2.get(position).isIssaveMarkForReview()) {
            if (this.questionBankList2.get(position).isMarkForReview() && this.questionBankList2.get(position).getAnswerPosttion() != -1 && this.questionBankList.get(position).getAnswerPosttion() != 0) {
                str3 = "marked_for_review";
            } else if (this.questionBankList2.get(position).getAnswerPosttion() == -1 || this.questionBankList2.get(position).getAnswerPosttion() == 0) {
                if (this.questionBankList2.get(position).isMarkForReview()) {
                    str2 = "marked_for_review";
                } else if (this.questionBankList2.get(position).getAnswerPosttion() == -1) {
                    str2 = "not_visited";
                } else {
                    str2 = this.questionBankList2.get(position).getAnswerPosttion() == 0 ? "unanswered" : "";
                }
            }
        }
        Answers answers = new Answers();
        answers.setConfig_id(this.questionBankList2.get(position).getConfigId());
        answers.setSection_id(this.questionBankList2.get(position).getSectionId());
        answers.setSection_question_behaviour(this.questionBankList2.get(position).getSection_question_behaviour());
        answers.setSubject_id(this.questionBankList2.get(position).getSubjectId());
        answers.setIndex(String.valueOf(position));
        answers.setState(str2);
        answers.setIsanswer(this.questionBankList2.get(position).isIsanswer());
        answers.setAnswerBookmark(str3);
        answers.setAnswerPosition(this.questionBankList2.get(position).getAnswerPosition());
        answers.setIs_bookmarked(str);
        answers.setAnswers(this.questionBankList2.get(position).getAnswers());
        answers.setSelectedString(this.questionBankList2.get(position).getSelectedString());
        answers.setSelectedValue(this.questionBankList2.get(position).getSelectedValue());
        answers.setTopic_id(this.questionBankList2.get(position).getTopic_id());
        answers.setTopic_name(this.questionBankList2.get(position).getTopic_name());
        answers.setIs_topic_enabled(this.questionBankList2.get(position).getIs_topic_enabled());
        if (this.questionBankList2.get(position).getTotalTimeSpent() != 0) {
            answers.setOn_screen(String.valueOf(this.questionBankList2.get(position).getTotalTimeSpent() + this.questionBankList.get(position).getTotalTimeSpent()));
            return answers;
        }
        answers.setOn_screen(String.valueOf(this.questionBankList.get(position).getTotalTimeSpent()));
        return answers;
    }

    public String generateNoteOnSD(Context context, String sFileName, String sBody) {
        File file;
        File file2 = null;
        try {
            file = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES) + MqttTopic.TOPIC_LEVEL_SEPARATOR + getResources().getString(com.eduteria.app.app.R.string.test_main_folder_name) + MqttTopic.TOPIC_LEVEL_SEPARATOR, MakeMyExam.userId);
        } catch (IOException e2) {
            e = e2;
        }
        try {
            if (!file.exists()) {
                file.mkdirs();
            }
            FileWriter fileWriter = new FileWriter(new File(file, sFileName));
            fileWriter.append((CharSequence) sBody);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e3) {
            e = e3;
            file2 = file;
            e.printStackTrace();
            file = file2;
        }
        return new File(file + File.separator + sFileName).getAbsolutePath();
    }

    @Override // com.appnew.android.testmodule.interfaces.NumberPadOnClick
    public void sendOnclickInd(int index) {
        if (this.currentPage != index) {
            this.lastSection = getLastSection(currentSectionIdforTest);
            if (this.basicInfo.getAllow_user_move().equalsIgnoreCase("1")) {
                currentSectionIdforTest = this.questionBankList.get(index).getSubjectId();
                this.currentPage = index;
                setFragmentQuestionTypeSelection(index);
                setPart();
                highlightSelectedTopic(this.questionBankList.get(index).getTopic_id());
                return;
            }
            List<QuestionDump> list = this.questionDumpList;
            if (list != null && list.size() > 0) {
                if (resumeSectionIdforTest.equalsIgnoreCase(this.questionBankList.get(index).getSubjectId())) {
                    this.currentPage = index;
                    setFragmentQuestionTypeSelection(index);
                    setPart();
                    highlightSelectedTopic(this.questionBankList.get(index).getTopic_id());
                    return;
                }
                showSectionNotAllowToast();
                return;
            }
            if (currentSectionIdforTest.equalsIgnoreCase(this.questionBankList.get(index).getSubjectId())) {
                this.currentPage = index;
                setFragmentQuestionTypeSelection(index);
                setPart();
                highlightSelectedTopic(this.questionBankList.get(index).getTopic_id());
                return;
            }
            showSectionNotAllowToast();
        }
    }

    public void showSectionNotAllowToast() {
        try {
            if (ToastManager.isToastVisible()) {
                ToastManager.cancelToast();
            }
            ToastManager.showToast(this, getResources().getString(com.eduteria.app.app.R.string.switching_section_is_not_allowed), 0);
        } catch (Resources.NotFoundException e2) {
            e2.printStackTrace();
        }
    }

    private void setFragmentQuestionTypeSelection(int index) {
        if (this.testseriesBase.getData().getTestBasic().getSetType() != null && this.testseriesBase.getData().getTestBasic().getSetType().equalsIgnoreCase("7")) {
            this.btnClear.setVisibility(8);
            setFragment(Instant_TestSeriesFragment.newInstance(index, this.questionBankList.get(index).getQuestionType()), "selection", "1");
            return;
        }
        String questionType = this.questionBankList.get(index).getQuestionType();
        questionType.hashCode();
        if (questionType.equals("MT")) {
            this.btnClear.setVisibility(0);
            setFragment(SC_TestSeriesFragment.newInstance(index, this.questionBankList.get(index).getQuestionType()), "selection", "1");
        } else if (questionType.equals("FIB")) {
            this.btnClear.setVisibility(0);
            setFragment(FIB_TestSeriesFragment.newInstance(index), "selection", "1");
        } else {
            this.btnClear.setVisibility(0);
            setFragment(SC_TestSeriesFragment.newInstance(index, this.questionBankList.get(index).getQuestionType()), "selection", "1");
        }
    }

    private void netoworkCallSubmitTestseries(HashMap<String, String> finalResponse) {
        if (Helper.isNetworkConnected(this)) {
            this.mProgress.show();
            APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
            new EncryptionData().setFinalResponse(finalResponse);
            HashMap map = new HashMap();
            map.putAll(finalResponse);
            aPIInterface.submitTestSeries(AES.encrypt(new Gson().toJson(map))).enqueue(new Callback<String>() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity.19
                @Override // retrofit2.Callback
                public void onResponse(Call<String> call, Response<String> response) {
                    String strBody;
                    TestBaseActivity.this.mProgress.dismiss();
                    if (response.body() != null) {
                        try {
                            strBody = AES.decrypt(response.body(), AES.generatekeyAPI(), AES.generateVectorAPI());
                        } catch (Exception unused) {
                            strBody = response.body();
                        }
                        try {
                            JSONObject jSONObject = new JSONObject(strBody);
                            MakeMyExam.setTime_server(Long.parseLong(jSONObject.optString("time")) * 1000);
                            if (!jSONObject.optString("status").equalsIgnoreCase("true")) {
                                if (jSONObject.optString("status").equalsIgnoreCase("false")) {
                                    RetrofitResponse.GetApiData(TestBaseActivity.this, jSONObject.has("auth_code") ? jSONObject.getString("auth_code") : "", jSONObject.getString("message"), false);
                                    Log.e("TAG_APP", "onResponse: 2722 ");
                                    TestBaseActivity.this.finish();
                                    return;
                                }
                                return;
                            }
                            if (TestBaseActivity.this.countDownTimer != null) {
                                TestBaseActivity.this.countDownTimer.cancel();
                            }
                            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                            if (!jSONObjectOptJSONObject.optString("result_page").equals("1")) {
                                if (!jSONObjectOptJSONObject.optString("result_page").equals("0")) {
                                    if (jSONObjectOptJSONObject.optString("result_page").equals("2")) {
                                        if (TestBaseActivity.this.first_attempt.equalsIgnoreCase("1")) {
                                            Constants.REFRESHPAGE = "true";
                                            Constants.REFRESHPAGENEW = "true";
                                            TestBaseActivity.this.revision();
                                        }
                                        if (TestBaseActivity.this.isPause) {
                                            return;
                                        }
                                        TestBaseActivity testBaseActivity = TestBaseActivity.this;
                                        testBaseActivity.showPopupResult_date(testBaseActivity.result_date);
                                        return;
                                    }
                                    return;
                                }
                                if (TestBaseActivity.this.first_attempt.equalsIgnoreCase("1")) {
                                    Constants.REFRESHPAGE = "true";
                                    Constants.REFRESHPAGENEW = "true";
                                    TestBaseActivity.this.revision();
                                }
                                if (!TestBaseActivity.this.isPause) {
                                    TestBaseActivity testBaseActivity2 = TestBaseActivity.this;
                                    testBaseActivity2.showPopupResult_date(testBaseActivity2.result_date);
                                    return;
                                } else if (!Helper.isTestResume(TestBaseActivity.this.testseriesBase.getData().getTestBasic().getSetType())) {
                                    Log.e("TAG_APP", "onResponse: 2701 ");
                                    TestBaseActivity.this.finish();
                                    return;
                                } else {
                                    SharedPreference.getInstance().putBoolean(Const.TEST_RESUME_STATE, true);
                                    Toast.makeText(TestBaseActivity.this, "Test Resume...", 0).show();
                                    Log.e("TAG_APP", "onResponse: 2698 ");
                                    TestBaseActivity.this.finish();
                                    return;
                                }
                            }
                            if (TestBaseActivity.this.first_attempt.equalsIgnoreCase("1") && TestBaseActivity.this.isPause) {
                                if (!Helper.isTestResume(TestBaseActivity.this.testseriesBase.getData().getTestBasic().getSetType())) {
                                    TestBaseActivity.this.finish();
                                    return;
                                }
                                SharedPreference.getInstance().putBoolean(Const.TEST_RESUME_STATE, true);
                                Toast.makeText(TestBaseActivity.this, "Test Pause...", 0).show();
                                Log.e("TAG_APP", "onResponse: 2639 ");
                                TestBaseActivity.this.finish();
                                return;
                            }
                            if (!TestBaseActivity.this.first_attempt.equalsIgnoreCase("1")) {
                                Intent intent = new Intent(TestBaseActivity.this, (Class<?>) QuizActivity.class);
                                if (TestBaseActivity.this.first_attempt.equalsIgnoreCase("1")) {
                                    Constants.REFRESHPAGE = "true";
                                    Constants.REFRESHPAGENEW = "true";
                                    TestBaseActivity.this.revision();
                                }
                                intent.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                                intent.putExtra("status", TestBaseActivity.this.testseriesid);
                                intent.putExtra("name", TestBaseActivity.this.testSeriesname);
                                intent.putExtra("attemptOrReAttempt", TestBaseActivity.this.attemptOrReAttempt);
                                if (TestBaseActivity.this.isPracticeOrReAttempt) {
                                    intent.putExtra("show_leader", "0");
                                }
                                intent.putExtra("first_attempt", TestBaseActivity.this.first_attempt);
                                Helper.gotoActivity(intent, TestBaseActivity.this);
                                Log.e("TAG_APP", "onResponse: 2682 " + TestBaseActivity.this.testseriesid);
                                TestBaseActivity.this.finish();
                                return;
                            }
                            if (Long.parseLong(TestBaseActivity.this.result_date) > Long.parseLong(jSONObject.optString("time"))) {
                                TestBaseActivity testBaseActivity3 = TestBaseActivity.this;
                                testBaseActivity3.showPopupResult_date(testBaseActivity3.result_date);
                                return;
                            }
                            Intent intent2 = new Intent(TestBaseActivity.this, (Class<?>) QuizActivity.class);
                            if (TestBaseActivity.this.first_attempt.equalsIgnoreCase("1")) {
                                Constants.REFRESHPAGE = "true";
                                Constants.REFRESHPAGENEW = "true";
                                TestBaseActivity.this.revision();
                            }
                            intent2.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                            intent2.putExtra("status", TestBaseActivity.this.testseriesid);
                            intent2.putExtra("name", TestBaseActivity.this.testSeriesname);
                            intent2.putExtra("attemptOrReAttempt", TestBaseActivity.this.attemptOrReAttempt);
                            if (TestBaseActivity.this.isPracticeOrReAttempt) {
                                intent2.putExtra("show_leader", "0");
                            }
                            intent2.putExtra("first_attempt", TestBaseActivity.this.first_attempt);
                            Helper.gotoActivity(intent2, TestBaseActivity.this);
                            Log.e("TAG_APP", "onResponse: 2664");
                            TestBaseActivity.this.finish();
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<String> call, Throwable t) {
                    TestBaseActivity.this.mProgress.dismiss();
                }
            });
            return;
        }
        Toast.makeText(this, getResources().getString(com.eduteria.app.app.R.string.Retry_with_Internet_connection), 1).show();
    }

    private void SubmitTestSeriesURL(String url) {
        if (Helper.isNetworkConnected(this)) {
            this.mProgress.show();
            APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setUrl(url);
            aPIInterface.submitTestSeriesLater(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new Callback<String>() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity.20
                @Override // retrofit2.Callback
                public void onResponse(Call<String> call, Response<String> response) {
                    TestBaseActivity.this.mProgress.dismiss();
                    if (response.body() != null) {
                        try {
                            Toast.makeText(TestBaseActivity.this, new JSONObject(AES.decrypt(response.body(), AES.generatekeyAPI(), AES.generateVectorAPI())).getString("message"), 1).show();
                        } catch (Exception unused) {
                            response.body();
                        }
                    }
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<String> call, Throwable t) {
                    TestBaseActivity.this.mProgress.dismiss();
                }
            });
            return;
        }
        Toast.makeText(this, getResources().getString(com.eduteria.app.app.R.string.Retry_with_Internet_connection), 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPopupResult_date(String result_date) {
        Constants.REFRESHPAGE = "true";
        View viewInflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(com.eduteria.app.app.R.layout.result_date_layout, (ViewGroup) null, false);
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(viewInflate);
        dialog.show();
        Button button = (Button) viewInflate.findViewById(com.eduteria.app.app.R.id.btn_submit);
        ((TextView) viewInflate.findViewById(com.eduteria.app.app.R.id.message)).setText(getResources().getString(com.eduteria.app.app.R.string.your_result_will_be_declared_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(result_date) * 1000)));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showPopupResult_date$16(dialog, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPopupResult_date$16(Dialog dialog, View view) {
        if (dataSendListener != null && !TextUtils.isEmpty(this.live_test_feedback) && this.live_test_feedback.equalsIgnoreCase("1") && !TextUtils.isEmpty(this.attemptOrReAttempt) && this.attemptOrReAttempt.equalsIgnoreCase(Const.ATTEMPT)) {
            dataSendListener.onDataSent(0L, this.testseriesid, this.attemptOrReAttempt, 2);
        }
        dialog.dismiss();
        Log.e("TAG_APP", "showPopupResult_date: " + this.testseriesid + " , " + this.attemptOrReAttempt);
        Log.e("TAG_APP", "onResponse: 2803 ");
        finish();
    }

    private void showPopupSubmitTest() {
        try {
            if (Helper.isNetworkConnected(this)) {
                View viewInflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(com.eduteria.app.app.R.layout.dialogbox_test_submit, (ViewGroup) null, false);
                Dialog dialog = this.quizBasicInfoDialog;
                if (dialog == null) {
                    Dialog dialog2 = new Dialog(this);
                    this.quizBasicInfoDialog = dialog2;
                    dialog2.requestWindowFeature(1);
                    this.quizBasicInfoDialog.setCanceledOnTouchOutside(false);
                    this.quizBasicInfoDialog.setCancelable(false);
                    this.quizBasicInfoDialog.setContentView(viewInflate);
                    if (!isFinishing()) {
                        this.quizBasicInfoDialog.show();
                    }
                    Button button = (Button) viewInflate.findViewById(com.eduteria.app.app.R.id.btn_cancel);
                    TextView textView = (TextView) viewInflate.findViewById(com.eduteria.app.app.R.id.answeredTV);
                    TextView textView2 = (TextView) viewInflate.findViewById(com.eduteria.app.app.R.id.not_visted_value);
                    TextView textView3 = (TextView) viewInflate.findViewById(com.eduteria.app.app.R.id.unansweredTV);
                    TextView textView4 = (TextView) viewInflate.findViewById(com.eduteria.app.app.R.id.save_markedTV);
                    TextView textView5 = (TextView) viewInflate.findViewById(com.eduteria.app.app.R.id.markedTV);
                    TextView textView6 = (TextView) viewInflate.findViewById(com.eduteria.app.app.R.id.marked1);
                    TextView textView7 = (TextView) viewInflate.findViewById(com.eduteria.app.app.R.id.save_marked1);
                    View viewFindViewById = viewInflate.findViewById(com.eduteria.app.app.R.id.markedView1);
                    View viewFindViewById2 = viewInflate.findViewById(com.eduteria.app.app.R.id.markedView2);
                    textView5.setVisibility(0);
                    textView6.setVisibility(0);
                    textView7.setVisibility(0);
                    viewFindViewById.setVisibility(0);
                    viewFindViewById2.setVisibility(0);
                    CountTotalanswer();
                    textView.setText(String.valueOf(this.attemptCount));
                    textView3.setText(String.valueOf(this.unattampedcount));
                    textView4.setText(String.valueOf(this.savemarkforreviewCount));
                    textView5.setText(String.valueOf(this.markforreviewCount));
                    textView2.setText(String.valueOf(this.skipedQuestion));
                    Button button2 = (Button) viewInflate.findViewById(com.eduteria.app.app.R.id.btn_submit);
                    Button button3 = (Button) viewInflate.findViewById(com.eduteria.app.app.R.id.btn_resume);
                    TextView textView8 = (TextView) viewInflate.findViewById(com.eduteria.app.app.R.id.tv_testTitle);
                    TextView textView9 = (TextView) viewInflate.findViewById(com.eduteria.app.app.R.id.tv_testTitleDesc);
                    if (BuildConfig.FLAVOR.equalsIgnoreCase("resodigital") && SharedPreference.getInstance().getString("theme_color_hai_bhai") != null && !TextUtils.isEmpty(SharedPreference.getInstance().getString("theme_color_hai_bhai"))) {
                        button2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(SharedPreference.getInstance().getString("theme_color_hai_bhai").split(":")[0])));
                        button.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(SharedPreference.getInstance().getString("theme_color_hai_bhai").split(":")[0])));
                        button2.setTextColor(Color.parseColor(SharedPreference.getInstance().getString("theme_color_hai_bhai").split(":")[1]));
                        button.setTextColor(Color.parseColor(SharedPreference.getInstance().getString("theme_color_hai_bhai").split(":")[1]));
                    }
                    if (!BuildConfig.FLAVOR.equalsIgnoreCase("springboardAcademy") && Helper.isTestResume(this.testseriesBase.getData().getTestBasic().getSetType()) && this.first_attempt.equalsIgnoreCase("1")) {
                        if (this.isPause) {
                            button2.setVisibility(8);
                            button3.setVisibility(0);
                            textView8.setText(getResources().getString(com.eduteria.app.app.R.string.pause_test));
                            textView9.setText(getResources().getString(com.eduteria.app.app.R.string.do_you_want_to_pause_the_test));
                        } else {
                            button2.setVisibility(0);
                            button3.setVisibility(8);
                            textView8.setText(getResources().getString(com.eduteria.app.app.R.string.submit_test));
                            textView9.setText(getResources().getString(com.eduteria.app.app.R.string.do_you_want_to_submit_the_test));
                        }
                    } else {
                        this.isPause = false;
                        button2.setVisibility(0);
                        button3.setVisibility(8);
                        textView8.setText(getResources().getString(com.eduteria.app.app.R.string.submit_test));
                        textView9.setText(getResources().getString(com.eduteria.app.app.R.string.do_you_want_to_submit_the_test));
                    }
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity$$ExternalSyntheticLambda10
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$showPopupSubmitTest$17(view);
                        }
                    });
                    button2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity$$ExternalSyntheticLambda12
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$showPopupSubmitTest$18(view);
                        }
                    });
                    button3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity$$ExternalSyntheticLambda13
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$showPopupSubmitTest$19(view);
                        }
                    });
                    return;
                }
                dialog.show();
                return;
            }
            Toast.makeText(this.context, getResources().getString(com.eduteria.app.app.R.string.no_internet_connection), 0).show();
        } catch (WindowManager.BadTokenException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPopupSubmitTest$17(View view) {
        this.quizBasicInfoDialog.dismiss();
        this.quizBasicInfoDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPopupSubmitTest$18(View view) {
        if (Helper.isNetworkConnected(this)) {
            this.isForceFinish = false;
            this.quizBasicInfoDialog.dismiss();
            this.state = "1";
            this.testsubmit = true;
            UtkashRoom.getAppDatabase(this.context).getTestResumeDao().delete_test_data(this.testseriesid);
            finishTestSeries();
            return;
        }
        Toast.makeText(this.context, getResources().getString(com.eduteria.app.app.R.string.no_internet_connection), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPopupSubmitTest$19(View view) {
        if (Helper.isNetworkConnected(this)) {
            this.isForceFinish = false;
            this.quizBasicInfoDialog.dismiss();
            this.state = "0";
            this.testsubmit = true;
            UtkashRoom.getAppDatabase(this.context).getTestResumeDao().delete_test_data(this.testseriesid);
            finishTestSeries();
            return;
        }
        Toast.makeText(this.context, getResources().getString(com.eduteria.app.app.R.string.no_internet_connection), 0).show();
    }

    public void notifynumberApater() {
        this.rvQuestionAdapter.notifyDataSetChanged();
        this.rvNumberPadAdapter.notifyDataSetChanged();
    }

    public void openCalculator_web(Context context) {
        try {
            Dialog dialog = new Dialog(context, com.eduteria.app.app.R.style.MyDialogCalculator);
            calculator_dialog = dialog;
            dialog.requestWindowFeature(1);
            calculator_dialog.setContentView(com.eduteria.app.app.R.layout.dialog_calculator_web);
            calculator_dialog.setCancelable(true);
            calculator_dialog.setCanceledOnTouchOutside(true);
            calculator_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            calculator_dialog.getWindow().setSoftInputMode(3);
            calculator_dialog.getWindow().getAttributes().windowAnimations = com.eduteria.app.app.R.style.PauseDialogAnimation;
            WebView webView = (WebView) calculator_dialog.findViewById(com.eduteria.app.app.R.id.calcwebView);
            RelativeLayout relativeLayout = (RelativeLayout) calculator_dialog.findViewById(com.eduteria.app.app.R.id.calcpagerl);
            AppCompatButton appCompatButton = (AppCompatButton) calculator_dialog.findViewById(com.eduteria.app.app.R.id.btn_close);
            webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            webView.setLayerType(2, null);
            webView.getSettings().setCacheMode(2);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setBuiltInZoomControls(true);
            webView.loadUrl(API.MOBILE_CALCULATOR);
            webView.setBackgroundColor(0);
            Dialog dialog2 = calculator_dialog;
            if (dialog2 != null && !dialog2.isShowing()) {
                calculator_dialog.show();
            }
            appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TestBaseActivity.dismissCalculatorDialog();
                }
            });
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity.22
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TestBaseActivity.dismissCalculatorDialog();
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dismissCalculatorDialog() {
        Dialog dialog = calculator_dialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        calculator_dialog.dismiss();
        calculator_dialog.cancel();
        calculator_dialog = null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void obtainInputValues(String input) {
        String str;
        String str2;
        TestBaseActivity testBaseActivity;
        input.hashCode();
        String str3 = "(";
        switch (input.hashCode()) {
            case 37:
                str = ")";
                str2 = "%";
                if (input.equals(str2)) {
                    b = 0;
                }
                break;
            case 40:
                str = ")";
                b = input.equals(str3) ? (byte) 1 : (byte) -1;
                str3 = str3;
                str2 = "%";
                break;
            case 41:
                if (input.equals(")")) {
                    b = 2;
                }
                str = ")";
                str2 = "%";
                break;
            case 43:
                str = ")";
                if (input.equals(MqttTopic.SINGLE_LEVEL_WILDCARD)) {
                    b = 3;
                }
                str2 = "%";
                break;
            case 45:
                str = ")";
                if (input.equals("-")) {
                    b = 4;
                }
                str2 = "%";
                break;
            case 46:
                str = ")";
                if (input.equals(InstructionFileId.DOT)) {
                    b = 5;
                }
                str2 = "%";
                break;
            case 48:
                str = ")";
                if (input.equals("0")) {
                    b = 6;
                }
                str2 = "%";
                break;
            case 49:
                str = ")";
                if (input.equals("1")) {
                    b = 7;
                }
                str2 = "%";
                break;
            case 50:
                str = ")";
                if (input.equals("2")) {
                    b = 8;
                }
                str2 = "%";
                break;
            case 51:
                str = ")";
                if (input.equals("3")) {
                    b = 9;
                }
                str2 = "%";
                break;
            case 52:
                str = ")";
                if (input.equals("4")) {
                    b = 10;
                }
                str2 = "%";
                break;
            case 53:
                str = ")";
                if (input.equals("5")) {
                    b = 11;
                }
                str2 = "%";
                break;
            case 54:
                str = ")";
                if (input.equals("6")) {
                    b = 12;
                }
                str2 = "%";
                break;
            case 55:
                str = ")";
                if (input.equals("7")) {
                    b = 13;
                }
                str2 = "%";
                break;
            case 56:
                str = ")";
                if (input.equals("8")) {
                    b = 14;
                }
                str2 = "%";
                break;
            case 57:
                str = ")";
                if (input.equals("9")) {
                    b = Ascii.SI;
                }
                str2 = "%";
                break;
            case 120:
                str = ")";
                if (input.equals("x")) {
                    b = 16;
                }
                str2 = "%";
                break;
            case 2430:
                str = ")";
                if (input.equals("M+")) {
                    b = 17;
                }
                str2 = "%";
                break;
            case 2469:
                str = ")";
                if (input.equals("MR")) {
                    b = Ascii.DC2;
                }
                str2 = "%";
                break;
            case 2470:
                str = ")";
                if (input.equals("MS")) {
                    b = 19;
                }
                str2 = "%";
                break;
            case 2879:
                str = ")";
                if (input.equals("Yx")) {
                    b = Ascii.DC4;
                }
                str2 = "%";
                break;
            case 3458:
                str = ")";
                if (input.equals(UserDataStore.LAST_NAME)) {
                    b = Ascii.NAK;
                }
                str2 = "%";
                break;
            case 3770:
                str = ")";
                if (input.equals("x2")) {
                    b = Ascii.SYN;
                }
                str2 = "%";
                break;
            case 6228:
                str = ")";
                if (input.equals("Ã·")) {
                    b = Ascii.ETB;
                }
                str2 = "%";
                break;
            case 64594:
                str = ")";
                if (input.equals("ABS")) {
                    b = Ascii.CAN;
                }
                str2 = "%";
                break;
            case 98695:
                str = ")";
                if (input.equals("cos")) {
                    b = Ascii.EM;
                }
                str2 = "%";
                break;
            case 100893:
                str = ")";
                if (input.equals(AuthenticationTokenClaims.JSON_KEY_EXP)) {
                    b = Ascii.SUB;
                }
                str2 = "%";
                break;
            case 107332:
                str = ")";
                if (input.equals("log")) {
                    b = Ascii.ESC;
                }
                str2 = "%";
                break;
            case 113064:
                str = ")";
                if (input.equals("rnd")) {
                    b = Ascii.FS;
                }
                str2 = "%";
                break;
            case 113880:
                str = ")";
                if (input.equals("sin")) {
                    b = Ascii.GS;
                }
                str2 = "%";
                break;
            case 114593:
                str = ")";
                if (input.equals("tan")) {
                    b = Ascii.RS;
                }
                str2 = "%";
                break;
            case 239549:
                str = ")";
                if (input.equals("âˆš")) {
                    b = Ascii.US;
                }
                str2 = "%";
                break;
            default:
                str = ")";
                str2 = "%";
                break;
        }
        switch (b) {
            case 0:
                testBaseActivity = this;
                if (testBaseActivity.isInverse) {
                    testBaseActivity.currentDisplayedInput += "1Ã·";
                    testBaseActivity.inputToBeParsed += "1Ã·";
                } else {
                    testBaseActivity.currentDisplayedInput += str2;
                    testBaseActivity.inputToBeParsed += str2;
                }
                testBaseActivity.toggleInverse();
                testBaseActivity.toggleShiftButton();
                break;
            case 1:
                testBaseActivity = this;
                String str4 = str3;
                testBaseActivity.currentDisplayedInput += str4;
                testBaseActivity.inputToBeParsed += str4;
                break;
            case 2:
                testBaseActivity = this;
                String str5 = str;
                testBaseActivity.currentDisplayedInput += str5;
                testBaseActivity.inputToBeParsed += str5;
                break;
            case 3:
                testBaseActivity = this;
                testBaseActivity.currentDisplayedInput += MqttTopic.SINGLE_LEVEL_WILDCARD;
                testBaseActivity.inputToBeParsed += MqttTopic.SINGLE_LEVEL_WILDCARD;
                break;
            case 4:
                testBaseActivity = this;
                testBaseActivity.currentDisplayedInput += "-";
                testBaseActivity.inputToBeParsed += "-";
                break;
            case 5:
                testBaseActivity = this;
                testBaseActivity.currentDisplayedInput += InstructionFileId.DOT;
                testBaseActivity.inputToBeParsed += InstructionFileId.DOT;
                break;
            case 6:
                testBaseActivity = this;
                testBaseActivity.currentDisplayedInput += "0";
                testBaseActivity.inputToBeParsed += "0";
                break;
            case 7:
                testBaseActivity = this;
                if (testBaseActivity.isInverse) {
                    testBaseActivity.currentDisplayedInput += "Ï€";
                    testBaseActivity.inputToBeParsed += "pi";
                } else {
                    testBaseActivity.currentDisplayedInput += "1";
                    testBaseActivity.inputToBeParsed += "1";
                }
                testBaseActivity.toggleInverse();
                testBaseActivity.toggleShiftButton();
                break;
            case 8:
                testBaseActivity = this;
                if (testBaseActivity.isInverse) {
                    testBaseActivity.currentDisplayedInput += "e";
                    testBaseActivity.inputToBeParsed += "e";
                } else {
                    testBaseActivity.currentDisplayedInput += "2";
                    testBaseActivity.inputToBeParsed += "2";
                }
                testBaseActivity.toggleInverse();
                testBaseActivity.toggleShiftButton();
                break;
            case 9:
                testBaseActivity = this;
                if (testBaseActivity.isInverse) {
                    testBaseActivity.currentDisplayedInput += com.clevertap.android.sdk.Constants.SEPARATOR_COMMA;
                    testBaseActivity.inputToBeParsed += com.clevertap.android.sdk.Constants.SEPARATOR_COMMA;
                } else {
                    testBaseActivity.currentDisplayedInput += "3";
                    testBaseActivity.inputToBeParsed += "3";
                }
                testBaseActivity.toggleInverse();
                testBaseActivity.toggleShiftButton();
                break;
            case 10:
                testBaseActivity = this;
                if (testBaseActivity.isInverse) {
                    testBaseActivity.currentDisplayedInput += "!(";
                    testBaseActivity.inputToBeParsed += "!(";
                } else {
                    testBaseActivity.currentDisplayedInput += "4";
                    testBaseActivity.inputToBeParsed += "4";
                }
                testBaseActivity.toggleInverse();
                testBaseActivity.toggleShiftButton();
                break;
            case 11:
                testBaseActivity = this;
                if (testBaseActivity.isInverse) {
                    testBaseActivity.currentDisplayedInput += "comb(";
                    testBaseActivity.inputToBeParsed += "comb(";
                } else {
                    testBaseActivity.currentDisplayedInput += "5";
                    testBaseActivity.inputToBeParsed += "5";
                }
                testBaseActivity.toggleInverse();
                testBaseActivity.toggleShiftButton();
                break;
            case 12:
                testBaseActivity = this;
                if (testBaseActivity.isInverse) {
                    testBaseActivity.currentDisplayedInput += "permu(";
                    testBaseActivity.inputToBeParsed += "permu(";
                } else {
                    testBaseActivity.currentDisplayedInput += "6";
                    testBaseActivity.inputToBeParsed += "6";
                }
                testBaseActivity.toggleInverse();
                testBaseActivity.toggleShiftButton();
                break;
            case 13:
                testBaseActivity = this;
                testBaseActivity.currentDisplayedInput += "7";
                testBaseActivity.inputToBeParsed += "7";
                break;
            case 14:
                testBaseActivity = this;
                testBaseActivity.currentDisplayedInput += "8";
                testBaseActivity.inputToBeParsed += "8";
                break;
            case 15:
                testBaseActivity = this;
                testBaseActivity.currentDisplayedInput += "9";
                testBaseActivity.inputToBeParsed += "9";
                break;
            case 16:
                testBaseActivity = this;
                testBaseActivity.currentDisplayedInput += "*";
                testBaseActivity.inputToBeParsed += "*";
                break;
            case 17:
                testBaseActivity = this;
                if (testBaseActivity.isInverse) {
                    double dIsANumber = testBaseActivity.isANumber(testBaseActivity.outputResult.getText().toString());
                    if (!Double.isNaN(dIsANumber)) {
                        testBaseActivity.subtractMemoryStorage(testBaseActivity.context, dIsANumber);
                    }
                } else {
                    double dIsANumber2 = testBaseActivity.isANumber(testBaseActivity.outputResult.getText().toString());
                    if (!Double.isNaN(dIsANumber2)) {
                        testBaseActivity.addToMemoryStorage(testBaseActivity.context, dIsANumber2);
                    }
                }
                testBaseActivity.toggleInverse();
                testBaseActivity.toggleShiftButton();
                break;
            case 18:
                testBaseActivity = this;
                String strRemoveTrailingZero = testBaseActivity.removeTrailingZero(testBaseActivity.getStoredPreferenceValue(testBaseActivity.context));
                if (!strRemoveTrailingZero.equals("0")) {
                    testBaseActivity.currentDisplayedInput += strRemoveTrailingZero;
                    testBaseActivity.inputToBeParsed += strRemoveTrailingZero;
                }
                break;
            case 19:
                testBaseActivity = this;
                testBaseActivity.clearMemoryStorage(testBaseActivity.context);
                break;
            case 20:
                testBaseActivity = this;
                testBaseActivity.currentDisplayedInput += "^";
                testBaseActivity.inputToBeParsed += "^";
                break;
            case 21:
                testBaseActivity = this;
                if (testBaseActivity.isInverse) {
                    testBaseActivity.currentDisplayedInput += "e^";
                    testBaseActivity.inputToBeParsed += "e^";
                } else {
                    testBaseActivity.currentDisplayedInput += "ln(";
                    testBaseActivity.inputToBeParsed += "ln(";
                }
                testBaseActivity.toggleInverse();
                testBaseActivity.toggleShiftButton();
                break;
            case 22:
                testBaseActivity = this;
                if (testBaseActivity.isInverse) {
                    testBaseActivity.currentDisplayedInput += "^3";
                    testBaseActivity.inputToBeParsed += "^3";
                } else {
                    testBaseActivity.currentDisplayedInput += "^2";
                    testBaseActivity.inputToBeParsed += "^2";
                }
                testBaseActivity.toggleInverse();
                testBaseActivity.toggleShiftButton();
                break;
            case 23:
                testBaseActivity = this;
                testBaseActivity.currentDisplayedInput += "Ã·";
                testBaseActivity.inputToBeParsed += MqttTopic.TOPIC_LEVEL_SEPARATOR;
                break;
            case 24:
                testBaseActivity = this;
                testBaseActivity.currentDisplayedInput += "abs(";
                testBaseActivity.inputToBeParsed += "abs(";
                break;
            case 25:
                testBaseActivity = this;
                if (testBaseActivity.isInverse) {
                    testBaseActivity.currentDisplayedInput += "acos(";
                    testBaseActivity.inputToBeParsed += "acos(";
                } else {
                    testBaseActivity.currentDisplayedInput += "cos(";
                    testBaseActivity.inputToBeParsed += "cos(";
                }
                testBaseActivity.toggleInverse();
                testBaseActivity.toggleShiftButton();
                break;
            case 26:
                testBaseActivity = this;
                testBaseActivity.currentDisplayedInput += ExifInterface.LONGITUDE_EAST;
                testBaseActivity.inputToBeParsed += "E0";
                break;
            case 27:
                testBaseActivity = this;
                if (testBaseActivity.isInverse) {
                    testBaseActivity.currentDisplayedInput += "10^";
                    testBaseActivity.inputToBeParsed += "10^";
                } else {
                    testBaseActivity.currentDisplayedInput += "log(";
                    testBaseActivity.inputToBeParsed += "log(";
                }
                testBaseActivity.toggleInverse();
                testBaseActivity.toggleShiftButton();
                break;
            case 28:
                testBaseActivity = this;
                double dRandom = Math.random();
                testBaseActivity.currentDisplayedInput += String.valueOf(dRandom);
                testBaseActivity.inputToBeParsed += String.valueOf(dRandom);
                break;
            case 29:
                testBaseActivity = this;
                if (testBaseActivity.isInverse) {
                    testBaseActivity.currentDisplayedInput += "asin(";
                    testBaseActivity.inputToBeParsed += "asin(";
                } else {
                    testBaseActivity.currentDisplayedInput += "sin(";
                    testBaseActivity.inputToBeParsed += "sin(";
                }
                testBaseActivity.toggleInverse();
                testBaseActivity.toggleShiftButton();
                break;
            case 30:
                testBaseActivity = this;
                if (testBaseActivity.isInverse) {
                    testBaseActivity.currentDisplayedInput += "atan(";
                    testBaseActivity.inputToBeParsed += "atan(";
                } else {
                    testBaseActivity.currentDisplayedInput += "tan(";
                    testBaseActivity.inputToBeParsed += "tan(";
                }
                testBaseActivity.toggleInverse();
                testBaseActivity.toggleShiftButton();
                break;
            case 31:
                testBaseActivity = this;
                if (testBaseActivity.isInverse) {
                    testBaseActivity.currentDisplayedInput += "3âˆš(";
                    testBaseActivity.inputToBeParsed += "crt(";
                } else {
                    testBaseActivity.currentDisplayedInput += "âˆš(";
                    testBaseActivity.inputToBeParsed += "sqrt(";
                }
                testBaseActivity.toggleInverse();
                testBaseActivity.toggleShiftButton();
                break;
            default:
                testBaseActivity = this;
                break;
        }
        testBaseActivity.outputResult.setText(testBaseActivity.currentDisplayedInput);
    }

    private String removeTrailingZero(String formattingInput) {
        if (!formattingInput.contains(InstructionFileId.DOT)) {
            return formattingInput;
        }
        int iIndexOf = formattingInput.indexOf(InstructionFileId.DOT);
        return formattingInput.substring(iIndexOf, formattingInput.length()).equals(".0") ? formattingInput.substring(0, iIndexOf) : formattingInput;
    }

    private void toggleInverse() {
        if (this.isInverse) {
            this.isInverse = false;
        }
    }

    private void toggleShiftButton() {
        if (this.isInverse) {
            this.shiftDisplay.setText(getResources().getString(com.eduteria.app.app.R.string.shift));
        } else {
            this.shiftDisplay.setText("");
        }
    }

    private double isANumber(String numberInput) {
        try {
            return Double.parseDouble(numberInput);
        } catch (NumberFormatException unused) {
            return Double.NaN;
        }
    }

    private void addToMemoryStorage(Context context, double inputToStore) {
        setPreference(context, getPreference(context) + ((float) inputToStore));
    }

    private void subtractMemoryStorage(Context context, double inputToStore) {
        setPreference(context, getPreference(context) - ((float) inputToStore));
    }

    private void clearMemoryStorage(Context context) {
        setPreference(context, 0.0f);
    }

    private String getStoredPreferenceValue(Context context) {
        return String.valueOf(getPreference(context));
    }

    public boolean setPreference(Context c2, float value) {
        c2.getSharedPreferences(this.PREFS_NAME, 0);
        SharedPreferences.Editor editorEdit = c2.getSharedPreferences(this.PREFS_NAME, 0).edit();
        editorEdit.putFloat("key", value);
        return editorEdit.commit();
    }

    public float getPreference(Context c2) {
        c2.getSharedPreferences(this.PREFS_NAME, 0);
        return c2.getSharedPreferences(this.PREFS_NAME, 0).getFloat("key", 0.0f);
    }

    public int countFIBWords(String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.substring(i2).startsWith("FIB")) {
                i++;
            }
        }
        return i;
    }

    @Override // com.appnew.android.Utils.AmazonUpload.AmazonCallBack
    public void onS3UploadData(ArrayList<MediaFile> images) {
        Helper.dismissProgressDialog();
        if (images != null && !images.isEmpty()) {
            CountDownTimer countDownTimer = this.countDownTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            String file = images.get(0).getFile();
            String strReplaceAll = file.replaceAll(file.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[0] + MqttTopic.TOPIC_LEVEL_SEPARATOR + file.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[1] + MqttTopic.TOPIC_LEVEL_SEPARATOR + file.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[2] + MqttTopic.TOPIC_LEVEL_SEPARATOR, "https://d1i3vm6evcjhiu.cloudfront.net/");
            SubmitTestSeriesURL(strReplaceAll);
            TestTable testTable = new TestTable();
            testTable.setCourse_id(this.course_id);
            testTable.setStatus("ATTEMPTED");
            testTable.setTest_id(this.testseriesid);
            testTable.setUser_id(SharedPreference.getInstance().getLoggedInUser().getId());
            UtkashRoom.getAppDatabase(this).getTestDao().addUser(testTable);
            Log.d("prince", "" + images.get(0).getFile());
            File file2 = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES) + MqttTopic.TOPIC_LEVEL_SEPARATOR + getResources().getString(com.eduteria.app.app.R.string.test_main_folder_name) + MqttTopic.TOPIC_LEVEL_SEPARATOR + MakeMyExam.userId + MqttTopic.TOPIC_LEVEL_SEPARATOR + ("U" + MakeMyExam.userId + "_T" + this.testseriesid + "_C" + this.course_id + ".json"));
            if (file2.exists()) {
                file2.delete();
            }
            Log.d("SSC_SUBMIT", "onS3UploadData: " + strReplaceAll);
        }
        String str = this.result_date;
        if (str != null && !str.equalsIgnoreCase("0") && !this.result_date.equalsIgnoreCase("1") && !this.result_date.equalsIgnoreCase("")) {
            if (this.first_attempt.equalsIgnoreCase("1")) {
                Constants.REFRESHPAGE = "true";
                Constants.REFRESHPAGENEW = "true";
                revision();
            }
            Intent intent = new Intent(this, (Class<?>) TestSubmissionActivity.class);
            intent.putExtra("result_date", this.result_date);
            intent.putExtra(AnalyticsConstants.test_name, this.testSeriesName.getText().toString());
            Helper.gotoActivity_finish(intent, this);
            return;
        }
        if (this.first_attempt.equalsIgnoreCase("1")) {
            Constants.REFRESHPAGE = "true";
            Constants.REFRESHPAGENEW = "true";
            revision();
        }
        Intent intent2 = new Intent(this, (Class<?>) TestSubmissionActivity.class);
        intent2.putExtra("result_date", this.result_date);
        intent2.putExtra(AnalyticsConstants.test_name, this.testSeriesName.getText().toString());
        Helper.gotoActivity_finish(intent2, this);
    }

    private long convertTimeInLong(String value) {
        try {
            if (TextUtils.isEmpty(value) || !TextUtils.isDigitsOnly(value)) {
                return 0L;
            }
            return (long) Double.parseDouble(value);
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimerN() {
        this.status = true;
        if (this.questionBankList.get(this.currentPage).isPause()) {
            this.millisInFuture = this.data.getTestBasic().getTimeRemaining();
        } else if (this.basicInfo.getAllow_user_move() != null && this.basicInfo.getAllow_user_move().equals("0")) {
            this.millisInFuture = convertTimeInLong(this.data.getTestBasic().getTimeInMins()) * 60000;
            if (!this.first_attempt.equalsIgnoreCase("1")) {
                this.millisInFuture = convertTimeInLong(this.partList.get(this.lastSection).getSectionTiming()) * 60000;
            } else if (this.enddate.longValue() - this.time_server.longValue() < convertTimeInLong(this.data.getTestBasic().getTimeInMins()) * 60) {
                if (this.enddate.longValue() - (Long.valueOf(System.currentTimeMillis()).longValue() / 1000) > convertTimeInLong(this.partList.get(this.lastSection).getSectionTiming()) * 60) {
                    this.millisInFuture = convertTimeInLong(this.partList.get(this.lastSection).getSectionTiming()) * 60000;
                    if (this.testseriesBase.getData().getResume_dump().getQuestion_dump() != null) {
                        this.remainingTime = convertTimeInLong(this.partList.get(this.lastSection).getTime_remain()) * 1000;
                    }
                } else {
                    this.millisInFuture = (this.enddate.longValue() * 1000) - Long.valueOf(System.currentTimeMillis()).longValue();
                    if (this.testseriesBase.getData().getResume_dump().getQuestion_dump() != null && this.enddate.longValue() - Long.valueOf(System.currentTimeMillis() / 1000).longValue() > convertTimeInLong(this.partList.get(this.lastSection).getTime_remain()) * 1000) {
                        this.remainingTime = convertTimeInLong(this.partList.get(this.lastSection).getTime_remain()) * 1000;
                    } else {
                        this.remainingTime = (this.enddate.longValue() * 1000) - Long.valueOf(System.currentTimeMillis()).longValue();
                    }
                    this.StartTime = true;
                }
            } else if (this.enddate.longValue() - (Long.valueOf(System.currentTimeMillis()).longValue() / 1000) > convertTimeInLong(this.partList.get(this.lastSection).getSectionTiming()) * 60) {
                this.millisInFuture = convertTimeInLong(this.partList.get(this.lastSection).getSectionTiming()) * 60000;
                if (this.testseriesBase.getData().getResume_dump().getQuestion_dump() != null) {
                    this.remainingTime = convertTimeInLong(this.partList.get(this.lastSection).getTime_remain()) * 1000;
                }
            } else {
                this.remainingTime = (this.enddate.longValue() * 1000) - Long.valueOf(System.currentTimeMillis()).longValue();
            }
        } else {
            this.data.getTestBasic().setTimeRemaining(convertTimeInLong(this.partList.get(this.lastSection).getSectionTiming()));
            if (this.partList.size() > 1) {
                if (!this.first_attempt.equalsIgnoreCase("1")) {
                    Long l = this.enddate;
                    if (l != null && l.longValue() - (Long.valueOf(System.currentTimeMillis()).longValue() / 1000) < convertTimeInLong(this.data.getTestBasic().getTimeInMins()) * 60) {
                        this.millisInFuture = (this.enddate.longValue() - this.time_server.longValue()) * 1000;
                        this.remainingTime = (this.enddate.longValue() - this.time_server.longValue()) * 1000;
                    } else {
                        this.millisInFuture = convertTimeInLong(this.data.getTestBasic().getTimeInMins()) * 60000;
                        this.remainingTime = this.remainingTime_noSwitch * 1000;
                    }
                } else if (this.enddate.longValue() - this.time_server.longValue() < convertTimeInLong(this.data.getTestBasic().getTimeInMins()) * 60) {
                    this.millisInFuture = (this.enddate.longValue() - this.time_server.longValue()) * 1000;
                    this.remainingTime = (this.enddate.longValue() - this.time_server.longValue()) * 1000;
                } else {
                    this.millisInFuture = convertTimeInLong(this.data.getTestBasic().getTimeInMins()) * 60000;
                    this.remainingTime = this.remainingTime_noSwitch * 1000;
                    this.StartTime = true;
                }
            } else {
                Long l2 = this.enddate;
                if (l2 != null && l2.longValue() - this.time_server.longValue() < convertTimeInLong(this.data.getTestBasic().getTimeInMins()) * 60) {
                    this.millisInFuture = (this.enddate.longValue() - this.time_server.longValue()) * 1000;
                    this.remainingTime = (this.enddate.longValue() - this.time_server.longValue()) * 1000;
                } else {
                    this.millisInFuture = convertTimeInLong(this.data.getTestBasic().getTimeInMins()) * 60000;
                    this.remainingTime = this.remainingTime_noSwitch * 1000;
                }
            }
        }
        if (this.millisInFuture >= 12000000) {
            this.tvTime.setVisibility(8);
        } else {
            this.tvTime.setVisibility(0);
        }
        if (this.testseriesid.equals(this.resumeTestId)) {
            AnonymousClass23 anonymousClass23 = new AnonymousClass23(this.remainingTime, 1000L);
            this.countDownTimer = anonymousClass23;
            anonymousClass23.start();
        } else {
            AnonymousClass24 anonymousClass24 = new AnonymousClass24(this.millisInFuture, 1000L);
            this.countDownTimer = anonymousClass24;
            anonymousClass24.start();
        }
    }

    /* JADX INFO: renamed from: com.appnew.android.testmodule.activity.TestBaseActivity$23, reason: invalid class name */
    class AnonymousClass23 extends CountDownTimer {
        AnonymousClass23(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            TestBaseActivity.this.milliLeft = millisUntilFinished;
            TestBaseActivity.this.count = millisUntilFinished / 1000;
            TextView textView = TestBaseActivity.this.tvTime;
            TestBaseActivity testBaseActivity = TestBaseActivity.this;
            textView.setText(testBaseActivity.formatSeconds((int) testBaseActivity.count));
            TestBaseActivity.this.data.getTestBasic().setTimeRemaining(millisUntilFinished);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (!TestBaseActivity.this.basicInfo.getAllow_user_move().equals("1") && TestBaseActivity.this.count1 < TestBaseActivity.this.filteredPartListToDisplay.size()) {
                TestBaseActivity.this.btnNext.setVisibility(0);
                TestBaseActivity.this.resume_section_status = true;
                TestBaseActivity.this.noOfQus = 1;
                TestBaseActivity.this.rvNumberpad.scrollToPosition(TestBaseActivity.this.partList.get(TestBaseActivity.this.count1).getIndexOf());
                TestBaseActivity.this.testseriesBase.setLastanswerPosition(TestBaseActivity.this.currentPage);
                IntStream.range(0, TestBaseActivity.this.partList.size()).filter(new IntPredicate() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity$23$$ExternalSyntheticLambda0
                    @Override // java.util.function.IntPredicate
                    public final boolean test(int i) {
                        return this.f$0.lambda$onFinish$0(i);
                    }
                }).findFirst().ifPresent(new IntConsumer() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity$23$$ExternalSyntheticLambda1
                    @Override // java.util.function.IntConsumer
                    public final void accept(int i) {
                        this.f$0.lambda$onFinish$1(i);
                    }
                });
                TestBaseActivity.this.setFragmentQuestionTypeAdd();
                TestBaseActivity testBaseActivity = TestBaseActivity.this;
                testBaseActivity.lastSection = testBaseActivity.getLastSection(testBaseActivity.questionBankList.get(TestBaseActivity.this.currentPage + 1).getSubjectId());
                TestBaseActivity.this.setPart();
                TestBaseActivity.this.changeTextOnNextAndPrevButton();
                TestBaseActivity.this.count1++;
                TestBaseActivity.this.countDownTimer.cancel();
                TestBaseActivity.this.sectionSwitch = true;
                TestBaseActivity.this.setTimerN();
                return;
            }
            TestBaseActivity.this.status = false;
            TestBaseActivity.this.tvTime.setText("00:00:00");
            Toast.makeText(TestBaseActivity.this.getApplicationContext(), TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.test_finished), 0).show();
            TestBaseActivity.this.questionBankList.get(TestBaseActivity.this.currentPage).setPause(false);
            TestBaseActivity.this.state = "1";
            if (TestBaseActivity.this.isFinishing()) {
                return;
            }
            if (Helper.isNetworkConnected(TestBaseActivity.this)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(TestBaseActivity.this);
                builder.setTitle(TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.time_out));
                builder.setMessage(TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.time_over_message));
                TestBaseActivity.this.finishTestSeries();
                builder.setCancelable(false);
                builder.setNegativeButton(TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.ok), new DialogInterface.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity.23.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        if (Helper.isNetworkConnected(TestBaseActivity.this)) {
                            TestBaseActivity.this.testTimeFinish = false;
                            dialog.dismiss();
                            TestBaseActivity.this.testsubmit = true;
                            UtkashRoom.getAppDatabase(TestBaseActivity.this.context).getTestResumeDao().delete_test_data(TestBaseActivity.this.testseriesid);
                            return;
                        }
                        dialog.dismiss();
                        TestBaseActivity.this.internetRefresh();
                        Toast.makeText(TestBaseActivity.this, TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.Retry_with_Internet_connection), 1).show();
                    }
                });
                AlertDialog alertDialogCreate = builder.create();
                if (TestBaseActivity.this.isFinishing()) {
                    return;
                }
                try {
                    TestBaseActivity.this.builderShowing = true;
                    alertDialogCreate.show();
                    return;
                } catch (Exception unused) {
                    TestBaseActivity.this.builderShowing = false;
                    return;
                }
            }
            TestBaseActivity testBaseActivity2 = TestBaseActivity.this;
            Toast.makeText(testBaseActivity2, testBaseActivity2.getResources().getString(com.eduteria.app.app.R.string.Retry_with_Internet_connection), 1).show();
            TestBaseActivity.this.internetRefresh();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$onFinish$0(int i) {
            return TestBaseActivity.this.filteredPartListToDisplay.get(TestBaseActivity.this.count1).getId() != null && TestBaseActivity.this.filteredPartListToDisplay.get(TestBaseActivity.this.count1).getId().equalsIgnoreCase(TestBaseActivity.this.partList.get(i).getId());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFinish$1(int i) {
            TestBaseActivity.this.rvNumberpad.scrollToPosition(TestBaseActivity.this.partList.get(i).getIndexOf());
            TestBaseActivity.this.testseriesBase.setLastanswerPosition(i);
            TestBaseActivity.this.currentPage = r0.partList.get(i).getIndexOf() - 1;
            TestBaseActivity.currentSectionIdforTest = TestBaseActivity.this.partList.get(i).getSectionId();
            TestBaseActivity.resumeSectionIdforTest = TestBaseActivity.this.partList.get(i).getSectionId();
            TestBaseActivity.this.setFragmentQuestionTypeAdd();
        }
    }

    /* JADX INFO: renamed from: com.appnew.android.testmodule.activity.TestBaseActivity$24, reason: invalid class name */
    class AnonymousClass24 extends CountDownTimer {
        AnonymousClass24(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            TestBaseActivity.this.milliLeft = millisUntilFinished;
            TestBaseActivity.this.count = millisUntilFinished / 1000;
            TextView textView = TestBaseActivity.this.tvTime;
            TestBaseActivity testBaseActivity = TestBaseActivity.this;
            textView.setText(testBaseActivity.formatSeconds((int) testBaseActivity.count));
            TestBaseActivity.this.data.getTestBasic().setTimeRemaining(millisUntilFinished);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (!TestBaseActivity.this.StartTime) {
                if (TestBaseActivity.this.basicInfo.getAllow_user_move().equals("0") && TestBaseActivity.this.count1 < TestBaseActivity.this.filteredPartListToDisplay.size()) {
                    TestBaseActivity.this.btnNext.setVisibility(0);
                    TestBaseActivity.this.noOfQus = 1;
                    IntStream.range(0, TestBaseActivity.this.partList.size()).filter(new IntPredicate() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity$24$$ExternalSyntheticLambda0
                        @Override // java.util.function.IntPredicate
                        public final boolean test(int i) {
                            return this.f$0.lambda$onFinish$0(i);
                        }
                    }).findFirst().ifPresent(new IntConsumer() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity$24$$ExternalSyntheticLambda1
                        @Override // java.util.function.IntConsumer
                        public final void accept(int i) {
                            this.f$0.lambda$onFinish$1(i);
                        }
                    });
                    TestBaseActivity testBaseActivity = TestBaseActivity.this;
                    testBaseActivity.lastSection = testBaseActivity.getLastSection(testBaseActivity.questionBankList.get(TestBaseActivity.this.currentPage + 1).getSubjectId());
                    TestBaseActivity.this.setPart();
                    TestBaseActivity.this.changeTextOnNextAndPrevButton();
                    TestBaseActivity.this.count1++;
                    TestBaseActivity.this.countDownTimer.cancel();
                    TestBaseActivity.this.setTimerN();
                    return;
                }
                TestBaseActivity.this.status = false;
                TestBaseActivity.this.tvTime.setText("00:00:00");
                Toast.makeText(TestBaseActivity.this.getApplicationContext(), TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.test_finished), 0).show();
                TestBaseActivity.this.questionBankList.get(TestBaseActivity.this.currentPage).setPause(false);
                TestBaseActivity.this.state = "1";
                if (TestBaseActivity.this.isFinishing()) {
                    return;
                }
                if (Helper.isNetworkConnected(TestBaseActivity.this)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(TestBaseActivity.this);
                    View viewInflate = TestBaseActivity.this.getLayoutInflater().inflate(com.eduteria.app.app.R.layout.select_ok_dialog, (ViewGroup) null);
                    builder.setView(viewInflate);
                    builder.setCancelable(false);
                    TextView textView = (TextView) viewInflate.findViewById(com.eduteria.app.app.R.id.tv_title);
                    Button button = (Button) viewInflate.findViewById(com.eduteria.app.app.R.id.tv_ok);
                    textView.setText("Alert !");
                    textView.setText(TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.time_over_message));
                    TestBaseActivity.this.finishTestSeries();
                    final AlertDialog alertDialogCreate = builder.create();
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity.24.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View v) {
                            if (Helper.isNetworkConnected(TestBaseActivity.this)) {
                                TestBaseActivity.this.testTimeFinish = false;
                                alertDialogCreate.dismiss();
                                TestBaseActivity.this.testsubmit = true;
                                UtkashRoom.getAppDatabase(TestBaseActivity.this.context).getTestResumeDao().delete_test_data(TestBaseActivity.this.testseriesid);
                                return;
                            }
                            alertDialogCreate.dismiss();
                            TestBaseActivity.this.internetRefresh();
                            Toast.makeText(TestBaseActivity.this, TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.Retry_with_Internet_connection), 1).show();
                        }
                    });
                    alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                    if (TestBaseActivity.this.isFinishing()) {
                        return;
                    }
                    try {
                        TestBaseActivity.this.builderShowing = true;
                        alertDialogCreate.show();
                        return;
                    } catch (Exception unused) {
                        TestBaseActivity.this.builderShowing = false;
                        return;
                    }
                }
                TestBaseActivity testBaseActivity2 = TestBaseActivity.this;
                Toast.makeText(testBaseActivity2, testBaseActivity2.getResources().getString(com.eduteria.app.app.R.string.Retry_with_Internet_connection), 1).show();
                TestBaseActivity.this.internetRefresh();
                return;
            }
            TestBaseActivity.this.StartTime = false;
            TestBaseActivity.this.status = false;
            TestBaseActivity.this.tvTime.setText("00:00:00");
            Toast.makeText(TestBaseActivity.this.getApplicationContext(), TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.test_finished), 0).show();
            TestBaseActivity.this.questionBankList.get(TestBaseActivity.this.currentPage).setPause(false);
            TestBaseActivity.this.state = "1";
            if (TestBaseActivity.this.isFinishing()) {
                return;
            }
            if (Helper.isNetworkConnected(TestBaseActivity.this)) {
                AlertDialog.Builder builder2 = new AlertDialog.Builder(TestBaseActivity.this);
                View viewInflate2 = TestBaseActivity.this.getLayoutInflater().inflate(com.eduteria.app.app.R.layout.select_ok_dialog, (ViewGroup) null);
                builder2.setView(viewInflate2);
                builder2.setCancelable(false);
                TextView textView2 = (TextView) viewInflate2.findViewById(com.eduteria.app.app.R.id.tv_title);
                Button button2 = (Button) viewInflate2.findViewById(com.eduteria.app.app.R.id.tv_ok);
                textView2.setText("Alert !");
                textView2.setText(TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.time_over_message));
                TestBaseActivity.this.testTimeFinish = true;
                final AlertDialog alertDialogCreate2 = builder2.create();
                button2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity.24.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        if (Helper.isNetworkConnected(TestBaseActivity.this)) {
                            TestBaseActivity.this.testTimeFinish = false;
                            alertDialogCreate2.dismiss();
                            TestBaseActivity.this.testsubmit = true;
                            UtkashRoom.getAppDatabase(TestBaseActivity.this.context).getTestResumeDao().delete_test_data(TestBaseActivity.this.testseriesid);
                            TestBaseActivity.this.finishTestSeries();
                            return;
                        }
                        alertDialogCreate2.dismiss();
                        TestBaseActivity.this.internetRefresh();
                        Toast.makeText(TestBaseActivity.this, TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.Retry_with_Internet_connection), 1).show();
                    }
                });
                alertDialogCreate2.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                if (TestBaseActivity.this.isFinishing()) {
                    return;
                }
                try {
                    TestBaseActivity.this.builderShowing = true;
                    alertDialogCreate2.show();
                    return;
                } catch (Exception unused2) {
                    TestBaseActivity.this.builderShowing = false;
                    return;
                }
            }
            TestBaseActivity testBaseActivity3 = TestBaseActivity.this;
            Toast.makeText(testBaseActivity3, testBaseActivity3.getResources().getString(com.eduteria.app.app.R.string.Retry_with_Internet_connection), 1).show();
            TestBaseActivity.this.internetRefresh();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$onFinish$0(int i) {
            return TestBaseActivity.this.filteredPartListToDisplay.get(TestBaseActivity.this.count1).getId() != null && TestBaseActivity.this.filteredPartListToDisplay.get(TestBaseActivity.this.count1).getId().equalsIgnoreCase(TestBaseActivity.this.partList.get(i).getId());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFinish$1(int i) {
            TestBaseActivity.this.rvNumberpad.scrollToPosition(TestBaseActivity.this.partList.get(i).getIndexOf());
            TestBaseActivity.this.testseriesBase.setLastanswerPosition(i);
            TestBaseActivity.this.currentPage = r0.partList.get(i).getIndexOf() - 1;
            TestBaseActivity.currentSectionIdforTest = TestBaseActivity.this.partList.get(i).getSectionId();
            TestBaseActivity.this.setFragmentQuestionTypeAdd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void internetRefresh() {
        this.testTimeFinish = false;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(com.eduteria.app.app.R.string.no_internet));
        builder.setMessage(getResources().getString(com.eduteria.app.app.R.string.internet_error_message));
        builder.setCancelable(false);
        builder.setNegativeButton(getResources().getString(com.eduteria.app.app.R.string.ok), new DialogInterface.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity.25
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                if (Helper.isNetworkConnected(TestBaseActivity.this)) {
                    dialog.dismiss();
                    TestBaseActivity.this.testsubmit = true;
                    TestBaseActivity.this.finishTestSeries();
                    return;
                }
                TestBaseActivity.this.internetRefresh();
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        if (isFinishing()) {
            return;
        }
        try {
            this.builderShowing = true;
            alertDialogCreate.show();
        } catch (Exception unused) {
            this.builderShowing = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLastSection(String sectionId) {
        this.resume_section_status = false;
        String str = this.resume_lastSection;
        if (str != null && !str.equals("")) {
            int i = Integer.parseInt(this.resume_lastSection);
            this.resume_lastSection = "";
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.partList.size(); i3++) {
            if (sectionId.equalsIgnoreCase(this.partList.get(i3).getSectionId())) {
                Log.e("hghjcghvgh", "getLastSection: " + i3);
                i2 = i3;
            }
        }
        return i2;
    }

    public void timerPause() {
        this.countDownTimer.cancel();
    }

    private void showExamInstruction() {
        if (Helper.isNetworkConnected(this)) {
            this.mProgress.show();
            APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setTest_id(this.testseriesid);
            encryptionData.setCourse_id(this.course_id);
            aPIInterface.API_GET_TEST_INSTRUCTION_DATA(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new Callback<String>() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity.26
                @Override // retrofit2.Callback
                public void onResponse(Call<String> call, Response<String> response) {
                    String strBody;
                    TestBaseActivity.this.mProgress.dismiss();
                    if (response.body() != null) {
                        try {
                            strBody = AES.decrypt(response.body(), AES.generatekeyAPI(), AES.generateVectorAPI());
                        } catch (Exception unused) {
                            strBody = response.body();
                        }
                        try {
                            JSONObject jSONObject = new JSONObject(strBody);
                            if (jSONObject.optString("status").equalsIgnoreCase("true")) {
                                TestBaseActivity.this.showPopUp((InstructionData) new Gson().fromJson(jSONObject.getJSONObject("data").toString(), InstructionData.class));
                                jSONObject.optString("time");
                                return;
                            } else {
                                if (jSONObject.optString("status").equalsIgnoreCase("false")) {
                                    RetrofitResponse.GetApiData(TestBaseActivity.this, jSONObject.has("auth_code") ? jSONObject.getString("auth_code") : "", jSONObject.getString("message"), false);
                                    Log.e("TAG_APP", "onResponse: 3822 ");
                                    TestBaseActivity.this.finish();
                                    return;
                                }
                                return;
                            }
                        } catch (JSONException unused2) {
                            TestBaseActivity testBaseActivity = TestBaseActivity.this;
                            Toast.makeText(testBaseActivity, testBaseActivity.getResources().getString(com.eduteria.app.app.R.string.something_went_wrong), 1).show();
                            return;
                        }
                    }
                    TestBaseActivity testBaseActivity2 = TestBaseActivity.this;
                    Toast.makeText(testBaseActivity2, testBaseActivity2.getResources().getString(com.eduteria.app.app.R.string.something_went_wrong), 1).show();
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<String> call, Throwable t) {
                    TestBaseActivity.this.mProgress.dismiss();
                    TestBaseActivity testBaseActivity = TestBaseActivity.this;
                    Toast.makeText(testBaseActivity, testBaseActivity.getResources().getString(com.eduteria.app.app.R.string.something_went_wrong), 1).show();
                }
            });
            return;
        }
        Toast.makeText(this, getResources().getString(com.eduteria.app.app.R.string.Retry_with_Internet_connection), 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPopUp(final InstructionData instructionData) {
        int i;
        this.lang = this.language;
        View viewInflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(com.eduteria.app.app.R.layout.popup_basicinfo_quiz_career, (ViewGroup) null, false);
        Dialog dialog = new Dialog(this, com.eduteria.app.app.R.style.CustomAlertDialog);
        dialog.requestWindowFeature(1);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(viewInflate);
        dialog.getWindow().setLayout(-1, -1);
        dialog.show();
        final TestBasicInst testBasic = instructionData.getTestBasic();
        ((LinearLayout) viewInflate.findViewById(com.eduteria.app.app.R.id.languageL_layout)).setVisibility(8);
        TextView textView = (TextView) viewInflate.findViewById(com.eduteria.app.app.R.id.quizTitleTV);
        TextView textView2 = (TextView) viewInflate.findViewById(com.eduteria.app.app.R.id.marksTextValueTV);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(com.eduteria.app.app.R.id.section_time);
        TextView textView3 = (TextView) viewInflate.findViewById(com.eduteria.app.app.R.id.numQuesValueTV);
        TextView textView4 = (TextView) viewInflate.findViewById(com.eduteria.app.app.R.id.sectionValueTV);
        final TextView textView5 = (TextView) viewInflate.findViewById(com.eduteria.app.app.R.id.languageSpinnerTV);
        textView5.setEnabled(false);
        TextView textView6 = (TextView) viewInflate.findViewById(com.eduteria.app.app.R.id.quizTimeValueTV);
        TextView textView7 = (TextView) viewInflate.findViewById(com.eduteria.app.app.R.id.remarksTV);
        ((CheckBox) viewInflate.findViewById(com.eduteria.app.app.R.id.check_box)).setEnabled(false);
        final TextView textView8 = (TextView) viewInflate.findViewById(com.eduteria.app.app.R.id.generalInstrValueTV);
        Button button = (Button) viewInflate.findViewById(com.eduteria.app.app.R.id.startQuizBtn);
        LinearLayout linearLayout2 = (LinearLayout) viewInflate.findViewById(com.eduteria.app.app.R.id.sectionListLL);
        LinearLayout linearLayout3 = (LinearLayout) viewInflate.findViewById(com.eduteria.app.app.R.id.general_layout);
        button.setVisibility(4);
        if (testBasic.getTest_assets() != null) {
            if (testBasic.getTest_assets().getHide_inst_time().equalsIgnoreCase("0")) {
                linearLayout.setVisibility(0);
            } else {
                linearLayout.setVisibility(4);
            }
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
                textView8.setText(Html.fromHtml(testBasic.getMulti_description().get(this.lang - 1).getDescription()));
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
                textView5.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity.27
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TestBaseActivity testBaseActivity = TestBaseActivity.this;
                        TextView textView9 = textView5;
                        TestBasicInst testBasicInst = testBasic;
                        TextView textView10 = textView8;
                        testBaseActivity.showPopMenuForLangauge(textView9, testBasicInst, textView10, textView10);
                    }
                });
            }
            if (testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("1")) {
                textView5.setText(getResources().getStringArray(com.eduteria.app.app.R.array.dialog_choose_language_array)[0]);
                this.lang = Integer.parseInt(testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
            } else if (testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("2")) {
                textView5.setText(getResources().getStringArray(com.eduteria.app.app.R.array.dialog_choose_language_array)[1]);
                this.lang = Integer.parseInt(testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
            }
        } else {
            if (testBasic.getLang_id().length() > 2) {
                textView5.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity.28
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TestBaseActivity.this.showPopMenuForLangauge(textView8, textView5, testBasic);
                    }
                });
            }
            if (testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("1")) {
                textView5.setText(getResources().getStringArray(com.eduteria.app.app.R.array.dialog_choose_language_array)[0]);
                this.lang = Integer.parseInt(testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
            } else if (testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("2")) {
                textView5.setText(getResources().getStringArray(com.eduteria.app.app.R.array.dialog_choose_language_array)[1]);
                this.lang = Integer.parseInt(testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
            } else if (testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("3")) {
                textView5.setText(getResources().getStringArray(com.eduteria.app.app.R.array.dialog_choose_language_array)[2]);
                this.lang = Integer.parseInt(testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
            } else if (testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("9")) {
                textView5.setText(getResources().getStringArray(com.eduteria.app.app.R.array.dialog_choose_language_array)[3]);
                this.lang = Integer.parseInt(testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
            } else if (testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("6")) {
                textView5.setText(getResources().getStringArray(com.eduteria.app.app.R.array.dialog_choose_language_array)[4]);
                this.lang = Integer.parseInt(testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
            } else if (testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("10")) {
                textView5.setText(getResources().getStringArray(com.eduteria.app.app.R.array.dialog_choose_language_array)[5]);
                this.lang = Integer.parseInt(testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
            } else if (testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("11")) {
                textView5.setText(getResources().getStringArray(com.eduteria.app.app.R.array.dialog_choose_language_array)[6]);
                this.lang = Integer.parseInt(testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
            } else if (testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("12")) {
                textView5.setText(getResources().getStringArray(com.eduteria.app.app.R.array.dialog_choose_language_array)[7]);
                this.lang = Integer.parseInt(testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
            } else if (testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0].equals("5")) {
                textView5.setText(getResources().getStringArray(com.eduteria.app.app.R.array.dialog_choose_language_array)[8]);
                this.lang = Integer.parseInt(testBasic.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[0]);
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
                map.merge(sectionId, Float.valueOf(floatSafe), new BiFunction() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity$$ExternalSyntheticLambda18
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
        LinearLayout linearLayout = (LinearLayout) View.inflate(this, com.eduteria.app.app.R.layout.layout_option_section_list_view, null);
        TextView textView = (TextView) linearLayout.findViewById(com.eduteria.app.app.R.id.secNameTV);
        TextView textView2 = (TextView) linearLayout.findViewById(com.eduteria.app.app.R.id.totQuesTV);
        TextView textView3 = (TextView) linearLayout.findViewById(com.eduteria.app.app.R.id.totNoAttmtsTV);
        TextView textView4 = (TextView) linearLayout.findViewById(com.eduteria.app.app.R.id.totTimeTV);
        TextView textView5 = (TextView) linearLayout.findViewById(com.eduteria.app.app.R.id.maxMarksTV);
        TextView textView6 = (TextView) linearLayout.findViewById(com.eduteria.app.app.R.id.markPerQuesTV);
        TextView textView7 = (TextView) linearLayout.findViewById(com.eduteria.app.app.R.id.negMarkPerQuesTV);
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
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity$$ExternalSyntheticLambda19
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return this.f$0.lambda$showPopMenuForLangauge$20(v, testBasicInst, textView, menuItem);
            }
        });
        for (int i = 0; i < testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA).length; i++) {
            if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("1")) {
                popupMenu.getMenu().add(getResources().getStringArray(com.eduteria.app.app.R.array.dialog_choose_language_array)[0]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("2")) {
                popupMenu.getMenu().add(getResources().getStringArray(com.eduteria.app.app.R.array.dialog_choose_language_array)[1]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("3")) {
                popupMenu.getMenu().add(getResources().getStringArray(com.eduteria.app.app.R.array.dialog_choose_language_array)[2]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("9")) {
                popupMenu.getMenu().add(getResources().getStringArray(com.eduteria.app.app.R.array.dialog_choose_language_array)[3]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("6")) {
                popupMenu.getMenu().add(getResources().getStringArray(com.eduteria.app.app.R.array.dialog_choose_language_array)[4]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("10")) {
                popupMenu.getMenu().add(getResources().getStringArray(com.eduteria.app.app.R.array.dialog_choose_language_array)[5]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("11")) {
                popupMenu.getMenu().add(getResources().getStringArray(com.eduteria.app.app.R.array.dialog_choose_language_array)[6]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("12")) {
                popupMenu.getMenu().add(getResources().getStringArray(com.eduteria.app.app.R.array.dialog_choose_language_array)[7]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("5")) {
                popupMenu.getMenu().add(getResources().getStringArray(com.eduteria.app.app.R.array.dialog_choose_language_array)[8]);
            }
        }
        popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$showPopMenuForLangauge$20(View view, TestBasicInst testBasicInst, TextView textView, MenuItem menuItem) {
        ((TextView) view).setText(menuItem.getTitle().toString());
        if (menuItem.getTitle().toString().equals(getResources().getString(com.eduteria.app.app.R.string.hindi))) {
            this.lang = 2;
            if (testBasicInst.getDescription().isEmpty() || testBasicInst.getDescription_2().isEmpty()) {
                return false;
            }
            textView.setText(Html.fromHtml(testBasicInst.getDescription_2()));
            return false;
        }
        if (menuItem.getTitle().toString().equals(getResources().getString(com.eduteria.app.app.R.string.english))) {
            this.lang = 1;
            if (testBasicInst.getDescription().isEmpty()) {
                return false;
            }
            textView.setText(Html.fromHtml(testBasicInst.getDescription()));
            return false;
        }
        if (menuItem.getTitle().toString().equals(getResources().getString(com.eduteria.app.app.R.string.kannada))) {
            this.lang = 3;
            return false;
        }
        if (menuItem.getTitle().toString().equals(getResources().getString(com.eduteria.app.app.R.string.urdu))) {
            this.lang = 9;
            return false;
        }
        if (menuItem.getTitle().toString().equals(getResources().getString(com.eduteria.app.app.R.string.oriya))) {
            this.lang = 6;
            return false;
        }
        if (menuItem.getTitle().toString().equals(getResources().getString(com.eduteria.app.app.R.string.bangauli))) {
            this.lang = 10;
            return false;
        }
        if (menuItem.getTitle().toString().equals(getResources().getString(com.eduteria.app.app.R.string.assami))) {
            this.lang = 11;
            return false;
        }
        if (menuItem.getTitle().toString().equals(getResources().getString(com.eduteria.app.app.R.string.gujrati))) {
            this.lang = 12;
            return false;
        }
        if (!menuItem.getTitle().toString().equals(getResources().getString(com.eduteria.app.app.R.string.marathi))) {
            return false;
        }
        this.lang = 5;
        return false;
    }

    public void showPopMenuForLangauge(final View v, final TestBasicInst testBasicInst, final TextView v1, TextView vv) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity$$ExternalSyntheticLambda17
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return this.f$0.lambda$showPopMenuForLangauge$21(v, testBasicInst, v1, menuItem);
            }
        });
        for (int i = 0; i < testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA).length; i++) {
            if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("1")) {
                popupMenu.getMenu().add(getResources().getStringArray(com.eduteria.app.app.R.array.dialog_choose_language_array)[0]);
            } else if (testBasicInst.getLang_id().split(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA)[i].equals("2")) {
                popupMenu.getMenu().add(getResources().getStringArray(com.eduteria.app.app.R.array.dialog_choose_language_array)[1]);
            }
        }
        popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$showPopMenuForLangauge$21(View view, TestBasicInst testBasicInst, TextView textView, MenuItem menuItem) {
        ((TextView) view).setText(menuItem.getTitle().toString());
        if (menuItem.getTitle().toString().equals(getResources().getString(com.eduteria.app.app.R.string.hindi))) {
            this.lang = 2;
            if (testBasicInst.getMulti_description().size() > 0 && testBasicInst.getMulti_description().get(1).getDescription() != null) {
                textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(1).getDescription()));
            }
        } else if (menuItem.getTitle().toString().equals(getResources().getString(com.eduteria.app.app.R.string.english))) {
            this.lang = 1;
            if (testBasicInst.getMulti_description().size() > 0) {
                textView.setText(Html.fromHtml(testBasicInst.getMulti_description().get(0).getDescription()));
            }
        }
        return false;
    }

    public void showPopupErrorTest(final List<QuesReportOption> questionReportOptions) {
        final View viewInflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(com.eduteria.app.app.R.layout.dialog_report_error, (ViewGroup) null, false);
        final Dialog dialog = new Dialog(this, com.eduteria.app.app.R.style.CustomAlertDialog);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(viewInflate);
        dialog.show();
        final RadioGroup radioGroup = (RadioGroup) viewInflate.findViewById(com.eduteria.app.app.R.id.radioError);
        final EditText editText = (EditText) viewInflate.findViewById(com.eduteria.app.app.R.id.feedbackTV);
        Button button = (Button) viewInflate.findViewById(com.eduteria.app.app.R.id.btn_submit);
        ImageView imageView = (ImageView) viewInflate.findViewById(com.eduteria.app.app.R.id.iv_close);
        for (QuesReportOption quesReportOption : questionReportOptions) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(quesReportOption.getTitle());
            radioGroup.addView(radioButton);
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Dialog dialog2 = dialog;
                if (dialog2 != null) {
                    dialog2.dismiss();
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                if (checkedRadioButtonId != -1) {
                    String strTrim = ((RadioButton) viewInflate.findViewById(checkedRadioButtonId)).getText().toString().trim();
                    QuesReportOption quesReportOption2 = null;
                    for (QuesReportOption quesReportOption3 : questionReportOptions) {
                        if (quesReportOption3.getTitle().trim().equalsIgnoreCase(strTrim.trim())) {
                            quesReportOption2 = quesReportOption3;
                        }
                    }
                    if (TestBaseActivity.this.questionBankList != null && TestBaseActivity.this.questionBankList.get(TestBaseActivity.this.currentPage) != null) {
                        if (!Helper.isNullChek(editText.getText().toString().trim())) {
                            editText.setError(TestBaseActivity.this.getResources().getString(com.eduteria.app.app.R.string.feedback_field_is_required));
                            editText.requestFocus();
                            return;
                        } else {
                            TestBaseActivity testBaseActivity = TestBaseActivity.this;
                            testBaseActivity.networkcallForSubmitQuery(quesReportOption2, testBaseActivity.questionBankList.get(TestBaseActivity.this.currentPage), editText.getText().toString().trim(), dialog);
                            return;
                        }
                    }
                    TestBaseActivity testBaseActivity2 = TestBaseActivity.this;
                    Toast.makeText(testBaseActivity2, testBaseActivity2.getResources().getString(com.eduteria.app.app.R.string.please_add_question), 0).show();
                    return;
                }
                TestBaseActivity testBaseActivity3 = TestBaseActivity.this;
                Toast.makeText(testBaseActivity3, testBaseActivity3.getResources().getString(com.eduteria.app.app.R.string.please_select_category), 0).show();
            }
        });
    }

    public void networkcallForSubmitQuery(QuesReportOption error, Question question, String feedbackMsg, final Dialog quizBasicInfoDialog) {
        if (Helper.isNetworkConnected(this)) {
            this.mProgress.show();
            APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setOption_id(error.getId());
            encryptionData.setQuestion_id(question.getId());
            encryptionData.setQuestion_config_id(question.getConfigId());
            encryptionData.setQuestion_lang_id(String.valueOf(this.language));
            encryptionData.setTest_id(this.testseriesid);
            encryptionData.setReport_feedback_msg(feedbackMsg);
            aPIInterface.getresponseofsubmitquery(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new Callback<String>() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity.31
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0082 -> B:16:0x0085). Please report as a decompilation issue!!! */
                @Override // retrofit2.Callback
                public void onResponse(Call<String> call, Response<String> response) {
                    String strBody;
                    TestBaseActivity.this.mProgress.dismiss();
                    if (response.body() != null) {
                        try {
                            strBody = AES.decrypt(response.body(), AES.generatekeyAPI(), AES.generateVectorAPI());
                        } catch (Exception unused) {
                            strBody = response.body();
                        }
                        try {
                            JSONObject jSONObject = new JSONObject(strBody);
                            MakeMyExam.setTime_server(Long.parseLong(jSONObject.optString("time")) * 1000);
                            if (jSONObject.optString("status").equals("true")) {
                                quizBasicInfoDialog.dismiss();
                                Toast.makeText(TestBaseActivity.this, jSONObject.optString("message"), 0).show();
                            } else {
                                quizBasicInfoDialog.dismiss();
                                Toast.makeText(TestBaseActivity.this, jSONObject.optString("message"), 0).show();
                                RetrofitResponse.GetApiData(TestBaseActivity.this, jSONObject.optString("auth_code"), jSONObject.optString("message"), false);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<String> call, Throwable t) {
                    TestBaseActivity.this.mProgress.dismiss();
                    TestBaseActivity testBaseActivity = TestBaseActivity.this;
                    Toast.makeText(testBaseActivity, testBaseActivity.getResources().getString(com.eduteria.app.app.R.string.something_went_wrong), 0).show();
                    quizBasicInfoDialog.dismiss();
                }
            });
            return;
        }
        Toast.makeText(this, getResources().getString(com.eduteria.app.app.R.string.Retry_with_Internet_connection), 1).show();
    }

    public boolean isOptionCountExceed(int position) {
        ArrayList<Answers> arrayList = new ArrayList<>();
        List<QuestionDump> list = this.questionDumpList;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.questionBankList.size(); i++) {
                arrayList.add(makeAnswerArray2(i));
            }
        } else {
            for (int i2 = 0; i2 < this.questionBankList.size(); i2++) {
                arrayList.add(makeAnswerArray(i2));
            }
        }
        if (getSectionOptionalCount(position) <= 0 || getAnsweredOptionalCount(arrayList, position) < getSectionOptionalCount(position)) {
            return false;
        }
        return (!this.questionBankList.get(position).getSection_question_behaviour().equalsIgnoreCase("1") || getAnsweredMandatoryCount(arrayList, position) + getAnsweredOptionalCount(arrayList, position) >= getTotalNumberOfAttemptCount(position)) && !arrayList.get(position).isIsanswer();
    }

    public int getAnsweredMandatoryCount(ArrayList<Answers> answerListCheck, int position) {
        int i = 0;
        for (Answers answers : answerListCheck) {
            if (this.questionBankList.get(position).getSubjectId().equalsIgnoreCase(answers.getSubject_id()) && answers.getSection_question_behaviour().equalsIgnoreCase("1") && answers.isIsanswer()) {
                i++;
            }
        }
        return i;
    }

    public int getAnsweredOptionalCount(ArrayList<Answers> answerListCheck, int position) {
        int i = 0;
        for (Answers answers : answerListCheck) {
            if (!TextUtils.isEmpty(this.questionBankList.get(position).getIs_topic_enabled()) && !TextUtils.isEmpty(this.questionBankList.get(position).getTopic_id()) && this.questionBankList.get(position).getIs_topic_enabled().equalsIgnoreCase("1")) {
                if (this.questionBankList.get(position).getTopic_id().equalsIgnoreCase(answers.getTopic_id()) && answers.getSection_question_behaviour().equalsIgnoreCase("0") && answers.isIsanswer()) {
                    i++;
                }
            } else if (this.questionBankList.get(position).getSectionId().equalsIgnoreCase(answers.getSection_id()) && answers.getSection_question_behaviour().equalsIgnoreCase("0") && answers.isIsanswer()) {
                i++;
            }
        }
        return i;
    }

    public int getTotalNumberOfAttemptCount(int position) {
        while (true) {
            String total_no_of_attempts = "0";
            for (TestSection testSection : this.testseriesBase.getData().getTestSections()) {
                if (this.questionBankList.get(position).getSubjectId().equalsIgnoreCase(testSection.getSectionId())) {
                    if (!TextUtils.isEmpty(testSection.getTotal_no_of_attempts())) {
                        total_no_of_attempts = testSection.getTotal_no_of_attempts();
                    }
                }
            }
            return Integer.parseInt(total_no_of_attempts);
        }
    }

    public int getSectionOptionalCount(int position) {
        String total_no_of_attempts_by_section_type;
        String subjectId = this.questionBankList.get(position).getSubjectId();
        String topic_id = this.questionBankList.get(position).getTopic_id();
        String is_topic_enabled = this.questionBankList.get(position).getIs_topic_enabled();
        if (!TextUtils.isEmpty(is_topic_enabled) && is_topic_enabled.equalsIgnoreCase("1")) {
            Iterator<TopicModel> it = this.validTopics.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (it.next().getTopicId().equalsIgnoreCase(topic_id)) {
                    Iterator<TestSection> it2 = this.testseriesBase.getData().getTestSections().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        TestSection next = it2.next();
                        if (subjectId.equalsIgnoreCase(next.getSectionId()) && topic_id.equalsIgnoreCase(next.getTopic_id())) {
                            if (!TextUtils.isEmpty(next.getTotal_no_of_attempts_by_section_type())) {
                                total_no_of_attempts_by_section_type = next.getTotal_no_of_attempts_by_section_type();
                            }
                        }
                    }
                }
            }
            total_no_of_attempts_by_section_type = "0";
        } else {
            String total_no_of_attempts_by_section_type2 = "0";
            for (TestSection testSection : this.testseriesBase.getData().getTestSections()) {
                if (this.questionBankList.get(position).getSubjectId().equalsIgnoreCase(testSection.getSectionId())) {
                    total_no_of_attempts_by_section_type2 = !TextUtils.isEmpty(testSection.getTotal_no_of_attempts_by_section_type()) ? testSection.getTotal_no_of_attempts_by_section_type() : "";
                }
            }
            total_no_of_attempts_by_section_type = total_no_of_attempts_by_section_type2;
        }
        return getMandatoryOptionalCount(total_no_of_attempts_by_section_type, "0");
    }

    public int getMandatoryOptionalCount(String totalNumOfAttemptsBySectionType, String forCountType) {
        if (!TextUtils.isEmpty(totalNumOfAttemptsBySectionType)) {
            try {
                JSONObject jSONObject = new JSONObject(totalNumOfAttemptsBySectionType);
                int i = jSONObject.has("mandatory") ? jSONObject.getInt("mandatory") : 0;
                int i2 = jSONObject.has(Session.Feature.OPTIONAL_ELEMENT) ? jSONObject.getInt(Session.Feature.OPTIONAL_ELEMENT) : 0;
                if (forCountType.equalsIgnoreCase("1")) {
                    return i;
                }
                if (forCountType.equalsIgnoreCase("0")) {
                    return i2;
                }
            } catch (JSONException unused) {
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void topicViewsAndClick(int subjectIdPosition, String selectedSectionId) {
        int i;
        LinearLayout linearLayout = (LinearLayout) findViewById(com.eduteria.app.app.R.id.topicLinearTextViews);
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) findViewById(com.eduteria.app.app.R.id.topicScrollView);
        this.scrollView = horizontalScrollView;
        horizontalScrollView.setVisibility(8);
        linearLayout.removeAllViews();
        this.topicTextViews.clear();
        this.selectedTopicIndex = -1;
        this.validTopics = getValidTopicsBySectionId(this.data.getTestSections(), selectedSectionId);
        Log.e(TAG, "topicViewsAndClick: " + this.validTopics);
        if (this.validTopics.isEmpty()) {
            return;
        }
        for (final int i2 = 0; i2 < this.validTopics.size(); i2++) {
            final TopicModel topicModel = this.validTopics.get(i2);
            TextView textView = new TextView(this);
            textView.setText(TextUtils.isEmpty(topicModel.getTopic_alias()) ? topicModel.getTopicName() : topicModel.getTopic_alias());
            textView.setPadding(32, 16, 32, 16);
            textView.setTextColor(-16777216);
            textView.setTextSize(16.0f);
            this.topicTextViews.add(textView);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity$$ExternalSyntheticLambda20
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$topicViewsAndClick$22(i2, topicModel, view);
                }
            });
            linearLayout.addView(textView);
        }
        if (this.pauseCount && !this.nextOrPreButtonClicked && (i = this.testPauseCount) != 0) {
            highlightSelectedTopic(this.questionBankList.get(i).getTopic_id());
        } else {
            Log.e(TAG, "topicViewsAndClick: " + this.currentPage);
            List<TopicModel> list = this.validTopics;
            if (list != null && list.size() > 0 && this.nextOrPreButtonClicked) {
                TopicModel topicModel2 = this.validTopics.get(0);
                if (topicModel2 != null && topicModel2.getTopicId() != null && !topicModel2.getTopicId().equals("0")) {
                    highlightSelectedTopic(topicModel2.getTopicId());
                    this.userClickedPositionUpdate = topicModel2.getUserClickPosition();
                }
            } else {
                highlightSelectedTopic(this.questionBankList.get(this.currentPage).getTopic_id());
            }
        }
        this.scrollView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$topicViewsAndClick$22(int i, TopicModel topicModel, View view) {
        if (this.selectedTopicIndex != i) {
            highlightSelectedTopic(this.partList.get(topicModel.getUserClickPosition()).getTopic_id());
            this.selectedTopicIndex = i;
            this.rvNumberpad.scrollToPosition(this.partList.get(topicModel.getUserClickPosition()).getIndexOf());
            setFragmentQuestionTypePartSelection(topicModel.getUserClickPosition());
            changeTextOnNextAndPrevButton();
            Log.e(TAG, "topicViewsAndClick: " + i + " , " + topicModel);
        }
    }

    private void highlightSelectedTopic(String topicId) {
        if (topicId == null || topicId.trim().equals("") || topicId.equals("0")) {
            Log.w(TAG, "Invalid topicId received: " + topicId);
            return;
        }
        Iterator<TopicModel> it = this.validTopics.iterator();
        while (it.hasNext()) {
            if (topicId.equals(it.next().getTopicId())) {
                for (int i = 0; i < this.topicTextViews.size(); i++) {
                    TopicModel topicModel = this.validTopics.get(i);
                    TextView textView = this.topicTextViews.get(i);
                    if (topicModel.getTopicId().equals(topicId)) {
                        textView.setBackgroundResource(com.eduteria.app.app.R.drawable.topic_underline_background);
                        textView.setTextColor(this.context.getColor(com.eduteria.app.app.R.color.colorPrimary));
                        this.selectedTopicIndex = i;
                    } else {
                        textView.setBackground(null);
                        textView.setTextColor(-16777216);
                    }
                }
                int i2 = this.selectedTopicIndex;
                if (i2 < 0 || i2 >= this.topicTextViews.size()) {
                    return;
                }
                ensureVisible(this.scrollView, this.topicTextViews.get(this.selectedTopicIndex));
                return;
            }
        }
        Log.w(TAG, "Topic ID not found in validTopics: " + topicId);
    }

    public List<TopicModel> getValidTopicsBySectionId(List<TestSection> sections, String sectionId) {
        ArrayList arrayList = new ArrayList();
        if (sections != null && sectionId != null && this.partList != null) {
            for (int i = 0; i < this.partList.size(); i++) {
                TestSection testSection = this.partList.get(i);
                if (testSection != null && sectionId.equals(testSection.getSectionId())) {
                    String topic_id = testSection.getTopic_id();
                    String topic_name = testSection.getTopic_name();
                    String is_topic_enabled = testSection.getIs_topic_enabled();
                    String total_no_of_attempts = testSection.getTotal_no_of_attempts();
                    String topic_alias = testSection.getTopic_alias();
                    if (is_topic_enabled != null && (("1".equals(is_topic_enabled) || "true".equalsIgnoreCase(is_topic_enabled)) && topic_id != null && !"0".equals(topic_id) && topic_name != null && !topic_name.isEmpty())) {
                        arrayList.add(new TopicModel(topic_name, topic_id, i, total_no_of_attempts, topic_alias));
                    }
                }
            }
        }
        return arrayList;
    }

    private ArrayList<TestSection> getFilteredPartListByUniqueSectionId(List<TestSection> sourceList) {
        ArrayList<TestSection> arrayList = new ArrayList<>();
        HashSet hashSet = new HashSet();
        if (sourceList != null) {
            for (TestSection testSection : sourceList) {
                if (testSection != null) {
                    String sectionId = testSection.getSectionId() != null ? testSection.getSectionId() : "0";
                    if (!hashSet.contains(sectionId)) {
                        hashSet.add(sectionId);
                        arrayList.add(testSection);
                    }
                }
            }
        }
        return arrayList;
    }

    public void updateSectionTimingSums(List<TestSection> partList) {
        String sectionId;
        if (partList == null || partList.isEmpty()) {
            return;
        }
        HashMap map = new HashMap();
        for (TestSection testSection : partList) {
            if (testSection != null) {
                String sectionId2 = testSection.getSectionId();
                String sectionTiming = testSection.getSectionTiming();
                if (sectionId2 != null && sectionTiming != null && !sectionTiming.isEmpty()) {
                    try {
                        map.put(sectionId2, Integer.valueOf(((Integer) map.getOrDefault(sectionId2, 0)).intValue() + Integer.parseInt(sectionTiming)));
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
        for (TestSection testSection2 : partList) {
            if (testSection2 != null && (sectionId = testSection2.getSectionId()) != null && map.containsKey(sectionId)) {
                testSection2.setSectionTiming(String.valueOf(((Integer) map.get(sectionId)).intValue()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollAndSelectWithFallback(int userClickedPositionUpdate, final String id) {
        if (this.nextOrPreButtonClicked) {
            IntStream.range(0, this.partList.size()).filter(new IntPredicate() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity$$ExternalSyntheticLambda15
                @Override // java.util.function.IntPredicate
                public final boolean test(int i) {
                    return this.f$0.lambda$scrollAndSelectWithFallback$23(id, i);
                }
            }).findFirst().ifPresent(new IntConsumer() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity$$ExternalSyntheticLambda16
                @Override // java.util.function.IntConsumer
                public final void accept(int i) {
                    this.f$0.lambda$scrollAndSelectWithFallback$24(i);
                }
            });
        } else {
            this.rvNumberpad.scrollToPosition(this.partList.get(userClickedPositionUpdate).getIndexOf());
            setFragmentQuestionTypePartSelection(userClickedPositionUpdate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$scrollAndSelectWithFallback$23(String str, int i) {
        return str != null && str.equalsIgnoreCase(this.partList.get(i).getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$scrollAndSelectWithFallback$24(int i) {
        this.rvNumberpad.scrollToPosition(this.partList.get(i).getIndexOf());
        setFragmentQuestionTypePartSelection(i);
    }

    private void ensureVisible(final HorizontalScrollView scrollView, final TextView tv) {
        if (scrollView == null || tv == null) {
            return;
        }
        tv.post(new Runnable() { // from class: com.appnew.android.testmodule.activity.TestBaseActivity$$ExternalSyntheticLambda21
            @Override // java.lang.Runnable
            public final void run() {
                TestBaseActivity.lambda$ensureVisible$25(scrollView, tv);
            }
        });
    }

    static /* synthetic */ void lambda$ensureVisible$25(HorizontalScrollView horizontalScrollView, TextView textView) {
        if (horizontalScrollView.getWidth() <= 0) {
            return;
        }
        int scrollX = horizontalScrollView.getScrollX();
        int width = horizontalScrollView.getWidth();
        int left = textView.getLeft();
        int right = textView.getRight();
        if (left < scrollX || right > scrollX + width) {
            if (left < scrollX) {
                horizontalScrollView.smoothScrollTo(left, 0);
            } else if (right > scrollX + width) {
                horizontalScrollView.smoothScrollTo(right - width, 0);
            }
        }
    }
}
