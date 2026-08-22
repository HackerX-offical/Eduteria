package com.appnew.android.CreateTest.Activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.appnew.android.Courses.Activity.QuizActivity;
import com.appnew.android.CreateTest.Fragment.FIB_CreateTestSeriesFragment;
import com.appnew.android.CreateTest.Fragment.SC_CreateTestSeriesFragment;
import com.appnew.android.Model.Courses.quiz.ResultTestSeries;
import com.appnew.android.R;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.CustomContextWrapper;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Progress;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.testmodule.adapter.MyRecyclerAdapter;
import com.appnew.android.testmodule.adapter.MyRecyclerAdapterTwo;
import com.appnew.android.testmodule.adapter.PartAdapter;
import com.appnew.android.testmodule.adapter.TestViewPagerAdapter;
import com.appnew.android.testmodule.interfaces.NumberPadOnClick;
import com.appnew.android.testmodule.layoutmanager.LinearLayoutManagerWithSmoothScroller;
import com.appnew.android.testmodule.model.Answers;
import com.appnew.android.testmodule.model.AnswersResumeResponse;
import com.appnew.android.testmodule.model.Data;
import com.appnew.android.testmodule.model.Question;
import com.appnew.android.testmodule.model.QuestionDump;
import com.appnew.android.testmodule.model.ResumeDump;
import com.appnew.android.testmodule.model.Social;
import com.appnew.android.testmodule.model.TestBasic;
import com.appnew.android.testmodule.model.TestseriesBase;
import com.clevertap.android.sdk.Constants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes6.dex */
public class TestCreateActivity extends AppCompatActivity implements View.OnClickListener, NumberPadOnClick {
    private static final String TAG = "TestBaseActivity";
    public static int nestbg;
    public static int nestcirclebg;
    String LANG;
    String PartId;
    public ArrayList<Answers> answerList;
    public ArrayList<AnswersResumeResponse> answersResumeResponses;
    int attemptCount;
    TestBasic basicInfo;
    private TextView btnClear;
    private FrameLayout btnNext;
    private FrameLayout btnPrev;
    private FrameLayout btn_finish;
    private Button btn_submit;
    Button buttonRad;
    public TextView changelang;
    Context context;
    public Data data;
    TextView degreeRad;
    private DrawerLayout drawerLayout;
    public String first_attempt;
    TextView gridView;
    private ImageView imgPause;
    private ImageView imgTestBack;
    private ImageView imgTestMenu;
    private List<ViewModel> items;
    private ImageView langimage;
    public int language;
    String lastView;
    TextView listView;
    private LinearLayout llDrawerRight;
    private LinearLayout llMarkForReview;
    private LinearLayout llMarkForReviewCount;
    Progress mProgress;
    int markforreviewCount;
    TextView nextTV;
    private NumberPadOnClick numberPadOnClick;
    TextView outputResult;
    public TestViewPagerAdapter pagerAdapter;
    PartAdapter partAdapter;
    int prevSeconds;
    public List<Question> questionBankList;
    public List<QuestionDump> questionDumpList;
    ResultTestSeries resultTestSeries;
    ResumeDump resumeDump;
    public List<Question> resumedumpresponselist;
    private RecyclerView rlQuestionPad;
    private MyRecyclerAdapter rvNumberPadAdapter;
    private RecyclerView rvNumberpad;
    private MyRecyclerAdapterTwo rvQuestionAdapter;
    int savemarkforreviewCount;
    TextView shiftDisplay;
    int skipedQuestion;
    String state;
    TextView testSeriesName;
    public String testSeriesname;
    FrameLayout testlayout;
    TestseriesBase testseriesBase;
    public String testseriesid;
    private TextView tvQuestionnumber;
    private TextView tvSkipCount;
    private TextView tvTime;
    private TextView tvUnAnswerCount;
    private TextView tv_savemarkforReview_count;
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
    public int currentPage = 0;
    boolean status = false;
    long count = 0;
    List<String> questionPart = new ArrayList();
    private ArrayList<Fragment> mFragmentList = new ArrayList<>();
    private boolean isPaused = false;
    private long timeRemaining = 0;
    private boolean isForceFinish = true;
    public List<Social> items1 = new ArrayList();
    public List<Social> items2 = new ArrayList();
    boolean testsubmit = false;
    String PREFS_NAME = "memory";
    String currentDisplayedInput = "";
    String inputToBeParsed = "";
    boolean isInverse = false;
    String lastResultObtain = "";
    public boolean clickedStauts = true;

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
        setContentView(com.eduteria.app.app.R.layout.activity_test_create);
        getWindow().addFlags(128);
        int i = SharedPreference.getInstance().getInt(Const.LANGUAGE);
        if (i == 1) {
            Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
        } else if (i == 2) {
            Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.HINDI), this);
        }
        SharedPreference.getInstance().putString("VIEW", "0");
        setReference();
        this.testseriesBase = (TestseriesBase) new Gson().fromJson(MakeMyExam.object, new TypeToken<TestseriesBase>() { // from class: com.appnew.android.CreateTest.Activity.TestCreateActivity.1
        }.getType());
        this.testseriesid = getIntent().getExtras().getString(Const.TEST_SERIES_ID);
        this.testSeriesname = getIntent().getExtras().getString(Const.TEST_SERIES_Name);
        this.first_attempt = getIntent().getExtras().getString("first_attempt");
        this.language = getIntent().getExtras().getInt(Const.LANG);
        this.data = this.testseriesBase.getData();
        this.basicInfo = this.testseriesBase.getData().getTestBasic();
        this.testSeriesName.setText(getResources().getString(com.eduteria.app.app.R.string.my_test));
        Progress progress = new Progress(this);
        this.mProgress = progress;
        progress.setCancelable(false);
        setTestData();
        setTimer();
        CountTotalanswer();
    }

    public void CountTotalanswer() {
        this.unattampedcount = 0;
        this.attemptCount = 0;
        this.skipedQuestion = 0;
        this.markforreviewCount = 0;
        this.savemarkforreviewCount = 0;
        for (int i = 0; i < this.questionBankList.size(); i++) {
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
        }
        this.tvanswerCount.setText(String.valueOf(this.attemptCount));
        this.tvUnAnswerCount.setText(String.valueOf(this.unattampedcount));
        this.tvSkipCount.setText(String.valueOf(this.skipedQuestion));
        this.tvmarkForReviewCount.setText(String.valueOf(this.markforreviewCount));
        this.tv_savemarkforReview_count.setText(String.valueOf(this.savemarkforreviewCount));
    }

    private void setTestData() {
        TestBasic testBasic = this.testseriesBase.getData().getTestBasic();
        if (testBasic.getDisplay_bubble() == null || testBasic.getDisplay_bubble().equalsIgnoreCase("") || testBasic.getDisplay_bubble().equalsIgnoreCase("1")) {
            this.rvNumberpad.setVisibility(0);
        } else {
            this.rvNumberpad.setVisibility(8);
        }
        this.changelang.setVisibility(8);
        this.langimage.setVisibility(8);
        this.changelang.setText("");
        int i = this.language;
        if (i == 1) {
            List<Question> questions = this.data.getQuestions();
            this.questionBankList = questions;
            this.PartId = questions.get(0).getSectionId();
        } else if (i == 2) {
            List<Question> questions2 = this.data.getQuestions();
            this.questionBankList = questions2;
            this.PartId = questions2.get(0).getSectionId();
        } else if (i == 3) {
            if (this.data.getQuestions().size() == this.data.getQuestionsHindi().size()) {
                this.changelang.setVisibility(8);
                this.langimage.setVisibility(0);
                this.changelang.setText(getResources().getString(com.eduteria.app.app.R.string.e_h));
                this.questionBankList = this.data.getQuestionsHindi();
            } else {
                this.changelang.setVisibility(8);
                this.langimage.setVisibility(8);
                this.questionBankList = this.data.getQuestions();
            }
        }
        this.imgPause.setVisibility(8);
        this.rvQuestionAdapter = new MyRecyclerAdapterTwo(this.questionBankList, this, this.items, com.eduteria.app.app.R.layout.single_row_testpad_no, this, "0");
        this.rvNumberPadAdapter = new MyRecyclerAdapter(this.questionBankList, this, this.items, com.eduteria.app.app.R.layout.single_row_testpad_no, this);
        this.rlQuestionPad.setAdapter(this.rvQuestionAdapter);
        this.rlQuestionPad.setLayoutManager(new GridLayoutManager((Context) this, 6, 1, false));
        this.rlQuestionPad.setItemAnimator(new DefaultItemAnimator());
        this.rvNumberpad.setAdapter(this.rvNumberPadAdapter);
        this.rvNumberpad.setLayoutManager(new LinearLayoutManagerWithSmoothScroller(this, 0, false));
        this.rvNumberpad.setItemAnimator(new DefaultItemAnimator());
        String questionType = this.questionBankList.get(0).getQuestionType();
        questionType.hashCode();
        if (!questionType.equals("MT") && questionType.equals("FIB")) {
            this.btnClear.setVisibility(0);
            setFragment(FIB_CreateTestSeriesFragment.newInstance(0), "add", "0");
        } else {
            this.btnClear.setVisibility(0);
            setFragment(SC_CreateTestSeriesFragment.newInstance(0, this.questionBankList.get(0).getQuestionType()), "add", "0");
        }
        changeTextOnNextAndPrevButton();
        this.langimage.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.CreateTest.Activity.TestCreateActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (TestCreateActivity.this.changelang.getText().equals("H/E")) {
                    TestCreateActivity testCreateActivity = TestCreateActivity.this;
                    testCreateActivity.questionBankList = testCreateActivity.data.getQuestionsHindi();
                    TestCreateActivity testCreateActivity2 = TestCreateActivity.this;
                    List<Question> list = TestCreateActivity.this.questionBankList;
                    TestCreateActivity testCreateActivity3 = TestCreateActivity.this;
                    testCreateActivity2.rvQuestionAdapter = new MyRecyclerAdapterTwo(list, testCreateActivity3, testCreateActivity3.items, com.eduteria.app.app.R.layout.single_row_testpad_no, TestCreateActivity.this, "0");
                    TestCreateActivity testCreateActivity4 = TestCreateActivity.this;
                    List<Question> list2 = TestCreateActivity.this.questionBankList;
                    TestCreateActivity testCreateActivity5 = TestCreateActivity.this;
                    testCreateActivity4.rvNumberPadAdapter = new MyRecyclerAdapter(list2, testCreateActivity5, (List<ViewModel>) testCreateActivity5.items, com.eduteria.app.app.R.layout.single_row_testpad_no, TestCreateActivity.this);
                    TestCreateActivity.this.rlQuestionPad.setAdapter(TestCreateActivity.this.rvQuestionAdapter);
                    TestCreateActivity.this.rlQuestionPad.setLayoutManager(new GridLayoutManager((Context) TestCreateActivity.this, 6, 1, false));
                    TestCreateActivity.this.rlQuestionPad.setItemAnimator(new DefaultItemAnimator());
                    TestCreateActivity.this.rvNumberpad.setAdapter(TestCreateActivity.this.rvNumberPadAdapter);
                    TestCreateActivity.this.rvNumberpad.setLayoutManager(new LinearLayoutManagerWithSmoothScroller(TestCreateActivity.this, 0, false));
                    TestCreateActivity.this.rvNumberpad.setItemAnimator(new DefaultItemAnimator());
                    TestCreateActivity.this.changelang.setText(TestCreateActivity.this.getResources().getString(com.eduteria.app.app.R.string.e_h));
                    String questionType2 = TestCreateActivity.this.questionBankList.get(TestCreateActivity.this.currentPage).getQuestionType();
                    questionType2.hashCode();
                    if (questionType2.equals("MT")) {
                        TestCreateActivity.this.btnClear.setVisibility(0);
                        TestCreateActivity testCreateActivity6 = TestCreateActivity.this;
                        testCreateActivity6.setFragment(SC_CreateTestSeriesFragment.newInstance(testCreateActivity6.currentPage, TestCreateActivity.this.questionBankList.get(TestCreateActivity.this.currentPage).getQuestionType()), "selection", "1");
                        return;
                    } else if (questionType2.equals("FIB")) {
                        TestCreateActivity.this.btnClear.setVisibility(0);
                        TestCreateActivity testCreateActivity7 = TestCreateActivity.this;
                        testCreateActivity7.setFragment(FIB_CreateTestSeriesFragment.newInstance(testCreateActivity7.currentPage), "selection", "1");
                        return;
                    } else {
                        TestCreateActivity.this.btnClear.setVisibility(0);
                        TestCreateActivity testCreateActivity8 = TestCreateActivity.this;
                        testCreateActivity8.setFragment(SC_CreateTestSeriesFragment.newInstance(testCreateActivity8.currentPage, TestCreateActivity.this.questionBankList.get(TestCreateActivity.this.currentPage).getQuestionType()), "selection", "1");
                        return;
                    }
                }
                if (TestCreateActivity.this.changelang.getText().equals("E/H")) {
                    TestCreateActivity testCreateActivity9 = TestCreateActivity.this;
                    testCreateActivity9.questionBankList = testCreateActivity9.data.getQuestions();
                    TestCreateActivity testCreateActivity10 = TestCreateActivity.this;
                    List<Question> list3 = TestCreateActivity.this.questionBankList;
                    TestCreateActivity testCreateActivity11 = TestCreateActivity.this;
                    testCreateActivity10.rvQuestionAdapter = new MyRecyclerAdapterTwo(list3, testCreateActivity11, testCreateActivity11.items, com.eduteria.app.app.R.layout.single_row_testpad_no, TestCreateActivity.this, "0");
                    TestCreateActivity testCreateActivity12 = TestCreateActivity.this;
                    List<Question> list4 = TestCreateActivity.this.questionBankList;
                    TestCreateActivity testCreateActivity13 = TestCreateActivity.this;
                    testCreateActivity12.rvNumberPadAdapter = new MyRecyclerAdapter(list4, testCreateActivity13, (List<ViewModel>) testCreateActivity13.items, com.eduteria.app.app.R.layout.single_row_testpad_no, TestCreateActivity.this);
                    TestCreateActivity.this.rlQuestionPad.setAdapter(TestCreateActivity.this.rvQuestionAdapter);
                    TestCreateActivity.this.rlQuestionPad.setLayoutManager(new GridLayoutManager((Context) TestCreateActivity.this, 6, 1, false));
                    TestCreateActivity.this.rlQuestionPad.setItemAnimator(new DefaultItemAnimator());
                    TestCreateActivity.this.rvNumberpad.setAdapter(TestCreateActivity.this.rvNumberPadAdapter);
                    TestCreateActivity.this.rvNumberpad.setLayoutManager(new LinearLayoutManagerWithSmoothScroller(TestCreateActivity.this, 0, false));
                    TestCreateActivity.this.rvNumberpad.setItemAnimator(new DefaultItemAnimator());
                    TestCreateActivity.this.changelang.setText(TestCreateActivity.this.getResources().getString(com.eduteria.app.app.R.string.h_e));
                    String questionType3 = TestCreateActivity.this.questionBankList.get(TestCreateActivity.this.currentPage).getQuestionType();
                    questionType3.hashCode();
                    if (questionType3.equals("MT")) {
                        TestCreateActivity.this.btnClear.setVisibility(0);
                        TestCreateActivity testCreateActivity14 = TestCreateActivity.this;
                        testCreateActivity14.setFragment(SC_CreateTestSeriesFragment.newInstance(testCreateActivity14.currentPage, TestCreateActivity.this.questionBankList.get(TestCreateActivity.this.currentPage).getQuestionType()), "selection", "1");
                    } else if (questionType3.equals("FIB")) {
                        TestCreateActivity.this.btnClear.setVisibility(0);
                        TestCreateActivity testCreateActivity15 = TestCreateActivity.this;
                        testCreateActivity15.setFragment(FIB_CreateTestSeriesFragment.newInstance(testCreateActivity15.currentPage), "selection", "1");
                    } else {
                        TestCreateActivity.this.btnClear.setVisibility(0);
                        TestCreateActivity testCreateActivity16 = TestCreateActivity.this;
                        testCreateActivity16.setFragment(SC_CreateTestSeriesFragment.newInstance(testCreateActivity16.currentPage, TestCreateActivity.this.questionBankList.get(TestCreateActivity.this.currentPage).getQuestionType()), "selection", "1");
                    }
                }
            }
        });
    }

    public int getIndexOf(List<Question> list, String name) {
        Iterator<Question> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (name.equalsIgnoreCase(it.next().getSectionId())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private void setReference() {
        this.changelang = (TextView) findViewById(com.eduteria.app.app.R.id.changelang);
        this.llDrawerRight = (LinearLayout) findViewById(com.eduteria.app.app.R.id.llDrawerRight);
        this.langimage = (ImageView) findViewById(com.eduteria.app.app.R.id.langimage);
        this.testlayout = (FrameLayout) findViewById(com.eduteria.app.app.R.id.testlayout);
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
        this.btn_finish = (FrameLayout) findViewById(com.eduteria.app.app.R.id.btn_finish);
        this.llMarkForReviewCount = (LinearLayout) findViewById(com.eduteria.app.app.R.id.llMarkForReviewCount);
        this.viewMarkForReviewCount = findViewById(com.eduteria.app.app.R.id.viewMarkForReviewCount);
        this.nextTV = (TextView) findViewById(com.eduteria.app.app.R.id.nextTV);
        this.tvQuestionnumber = (TextView) findViewById(com.eduteria.app.app.R.id.tv_questionnumber);
        this.tvanswerCount = (TextView) findViewById(com.eduteria.app.app.R.id.tv_answer_count);
        this.tvUnAnswerCount = (TextView) findViewById(com.eduteria.app.app.R.id.tv_unanswer_count);
        this.testSeriesName = (TextView) findViewById(com.eduteria.app.app.R.id.testSeriesName);
        this.tvSkipCount = (TextView) findViewById(com.eduteria.app.app.R.id.tv_skip_count);
        this.tvmarkForReviewCount = (TextView) findViewById(com.eduteria.app.app.R.id.tv_markforReview_count);
        this.tv_savemarkforReview_count = (TextView) findViewById(com.eduteria.app.app.R.id.tv_savemarkforReview_count);
        this.btn_submit = (Button) findViewById(com.eduteria.app.app.R.id.btn_submit);
        this.imgPause = (ImageView) findViewById(com.eduteria.app.app.R.id.img_pause);
        this.gridView = (TextView) findViewById(com.eduteria.app.app.R.id.gridView);
        this.listView = (TextView) findViewById(com.eduteria.app.app.R.id.listView);
        this.tvmarkForReviewCount.setVisibility(8);
        this.tv_savemarkforReview_count.setVisibility(8);
        this.llMarkForReviewCount.setVisibility(8);
        this.viewMarkForReviewCount.setVisibility(0);
        this.llMarkForReview.setVisibility(0);
        this.btn_submit.setOnClickListener(this);
        this.btnNext.setOnClickListener(this);
        this.btn_finish.setOnClickListener(this);
        this.btnPrev.setOnClickListener(this);
        this.imgPause.setOnClickListener(this);
        this.drawerLayout.setDrawerLockMode(1, GravityCompat.END);
        this.questionBankList = new ArrayList();
        this.imgTestBack.setOnClickListener(this);
        this.imgTestMenu.setOnClickListener(this);
        this.btnClear.setOnClickListener(this);
        this.viewPagerTest.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.appnew.android.CreateTest.Activity.TestCreateActivity.3
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int state) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                TestCreateActivity.this.changeTextOnNextAndPrevButton();
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(final int position) {
                TestCreateActivity.this.currentPage = position;
                TestCreateActivity.this.rvNumberpad.scrollToPosition(TestCreateActivity.this.currentPage);
                TestCreateActivity.this.rvNumberpad.getLayoutManager().smoothScrollToPosition(TestCreateActivity.this.rvNumberpad, new RecyclerView.State(), TestCreateActivity.this.currentPage);
                TestCreateActivity.this.rvNumberPadAdapter.setSelectePosition(position);
                if (TestCreateActivity.this.questionBankList.get(position).getAnswerPosttion() == -1) {
                    TestCreateActivity.this.questionBankList.get(position).setIsanswer(false, 0);
                }
                if (TestCreateActivity.this.data != null) {
                    TestCreateActivity.this.tvQuestionnumber.setText(TestCreateActivity.this.getResources().getString(com.eduteria.app.app.R.string.question) + (position + 1) + MqttTopic.TOPIC_LEVEL_SEPARATOR + TestCreateActivity.this.questionBankList.size());
                }
                TestCreateActivity.this.testseriesBase.setLastanswerPosition(TestCreateActivity.this.currentPage);
                new Handler(Looper.myLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.CreateTest.Activity.TestCreateActivity.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TestCreateActivity.this.rvQuestionAdapter.setSelectePosition(position);
                    }
                }, 1000L);
            }
        });
        this.gridView.setOnClickListener(this);
        this.listView.setOnClickListener(this);
    }

    protected void setFragment(Fragment fragment, String status, String pos) {
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
                }
                if (this.data != null) {
                    this.tvQuestionnumber.setText(getResources().getString(com.eduteria.app.app.R.string.question) + (this.currentPage + 1) + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.questionBankList.size());
                }
                this.testseriesBase.setLastanswerPosition(0);
                new Handler(Looper.myLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.CreateTest.Activity.TestCreateActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        TestCreateActivity.this.rvQuestionAdapter.setSelectePosition(0);
                    }
                }, 1000L);
                return;
            }
            int i = this.currentPage + 1;
            this.currentPage = i;
            this.rvNumberpad.scrollToPosition(i);
            this.rvNumberpad.getLayoutManager().smoothScrollToPosition(this.rvNumberpad, new RecyclerView.State(), this.currentPage);
            this.rvNumberPadAdapter.setSelectePosition(this.currentPage);
            if (this.data != null) {
                this.tvQuestionnumber.setText(getResources().getString(com.eduteria.app.app.R.string.question) + (this.currentPage + 1) + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.questionBankList.size());
            }
            if (this.questionBankList.get(this.currentPage).getAnswerPosttion() == -1) {
                this.questionBankList.get(this.currentPage).setIsanswer(false, 0);
            }
            this.testseriesBase.setLastanswerPosition(this.currentPage);
            new Handler(Looper.myLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.CreateTest.Activity.TestCreateActivity.5
                @Override // java.lang.Runnable
                public void run() {
                    TestCreateActivity.this.rvQuestionAdapter.setSelectePosition(TestCreateActivity.this.currentPage);
                }
            }, 1000L);
            return;
        }
        if (status.equalsIgnoreCase("remove")) {
            int i2 = this.currentPage - 1;
            this.currentPage = i2;
            this.rvNumberpad.scrollToPosition(i2);
            this.rvNumberpad.getLayoutManager().smoothScrollToPosition(this.rvNumberpad, new RecyclerView.State(), this.currentPage);
            this.rvNumberPadAdapter.setSelectePosition(this.currentPage);
            if (this.questionBankList.get(this.currentPage).getAnswerPosttion() == -1) {
                this.questionBankList.get(this.currentPage).setIsanswer(false, 0);
            }
            if (this.data != null) {
                this.tvQuestionnumber.setText(getResources().getString(com.eduteria.app.app.R.string.question) + (this.currentPage + 1) + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.questionBankList.size());
            }
            this.testseriesBase.setLastanswerPosition(this.currentPage);
            new Handler(Looper.myLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.CreateTest.Activity.TestCreateActivity.6
                @Override // java.lang.Runnable
                public void run() {
                    TestCreateActivity.this.rvQuestionAdapter.setSelectePosition(TestCreateActivity.this.currentPage);
                }
            }, 1000L);
            return;
        }
        if (status.equalsIgnoreCase("selection")) {
            int i3 = this.currentPage;
            if (i3 == 0) {
                this.rvNumberpad.scrollToPosition(0);
                this.rvNumberpad.getLayoutManager().smoothScrollToPosition(this.rvNumberpad, new RecyclerView.State(), 0);
                this.rvNumberPadAdapter.setSelectePosition(0);
                if (this.questionBankList.get(0).getAnswerPosttion() == -1) {
                    this.questionBankList.get(0).setIsanswer(false, 0);
                }
                if (this.data != null) {
                    this.tvQuestionnumber.setText(getResources().getString(com.eduteria.app.app.R.string.question) + (this.currentPage + 1) + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.questionBankList.size());
                }
                this.testseriesBase.setLastanswerPosition(0);
                new Handler(Looper.myLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.CreateTest.Activity.TestCreateActivity.7
                    @Override // java.lang.Runnable
                    public void run() {
                        TestCreateActivity.this.rvQuestionAdapter.setSelectePosition(0);
                    }
                }, 1000L);
                return;
            }
            this.rvNumberpad.scrollToPosition(i3);
            this.rvNumberpad.getLayoutManager().smoothScrollToPosition(this.rvNumberpad, new RecyclerView.State(), this.currentPage);
            this.rvNumberPadAdapter.setSelectePosition(this.currentPage);
            if (this.questionBankList.get(this.currentPage).getAnswerPosttion() == -1) {
                this.questionBankList.get(this.currentPage).setIsanswer(false, 0);
            }
            if (this.data != null) {
                this.tvQuestionnumber.setText(getResources().getString(com.eduteria.app.app.R.string.question) + (this.currentPage + 1) + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.questionBankList.size());
            }
            this.testseriesBase.setLastanswerPosition(this.currentPage);
            new Handler(Looper.myLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.CreateTest.Activity.TestCreateActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    TestCreateActivity.this.rvQuestionAdapter.setSelectePosition(TestCreateActivity.this.currentPage);
                }
            }, 1000L);
        }
    }

    private void addFragment(int i, String questionType) {
        questionType.hashCode();
        if (questionType.equals("MT")) {
            this.btnClear.setVisibility(0);
            this.mFragmentList.add(SC_CreateTestSeriesFragment.newInstance(i, questionType));
        } else if (questionType.equals("FIB")) {
            this.btnClear.setVisibility(0);
            this.mFragmentList.add(FIB_CreateTestSeriesFragment.newInstance(i));
        } else {
            this.btnClear.setVisibility(0);
            this.mFragmentList.add(SC_CreateTestSeriesFragment.newInstance(i, questionType));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    private void setTimer() {
        this.tvTime.setText("00:00:00");
        this.tvTime.setVisibility(4);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishTestSeries() {
        this.lastView = String.valueOf(this.currentPage);
        this.answerList = new ArrayList<>();
        for (int i = 0; i < this.questionBankList.size(); i++) {
            this.answerList.add(makeAnswerArray(i));
        }
        String json = new Gson().toJson(this.answerList);
        Intent intent = new Intent(this, (Class<?>) QuizActivity.class);
        intent.putExtra(Const.FRAG_TYPE, Const.CREATE_RESULT);
        intent.putExtra("name", this.testSeriesname);
        MakeMyExam.questionbanklist = new Gson().toJson(this.questionBankList);
        intent.putExtra("revision_string", json);
        if (this.langimage.getVisibility() == 0) {
            if (this.changelang.getText().equals("E/H")) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < this.questionBankList.size(); i2++) {
                    Question question = this.testseriesBase.getData().getQuestions().get(i2);
                    question.setUser_answer(this.questionBankList.get(i2).getUser_answer());
                    question.setAnswers(this.questionBankList.get(i2).getAnswers());
                    arrayList.add(question);
                }
                this.testseriesBase.getData().setQuestions(arrayList);
                this.testseriesBase.getData().setQuestionsHindi(this.questionBankList);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add("2");
                arrayList2.add("1");
                this.testseriesBase.getData().getTestBasic().setLangId(arrayList2);
            } else if (this.changelang.getText().equals("H/E")) {
                this.testseriesBase.getData().setQuestionsHindi(this.testseriesBase.getData().getQuestionsHindi());
                this.testseriesBase.getData().setQuestions(this.questionBankList);
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add("1");
                arrayList3.add("2");
                this.testseriesBase.getData().getTestBasic().setLangId(arrayList3);
            }
        } else {
            this.testseriesBase.getData().setQuestions(this.questionBankList);
        }
        MakeMyExam.object = new Gson().toJson(this.testseriesBase);
        Helper.gotoActivity(intent, this);
        finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        showPopupSubmitTest();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case com.eduteria.app.app.R.id.btn_clear /* 2131362363 */:
                if (this.questionBankList.get(this.currentPage).isIssaveMarkForReview() || this.questionBankList.get(this.currentPage).isMarkForReview()) {
                    this.questionBankList.get(this.currentPage).setIssaveMarkForReview(false);
                    this.questionBankList.get(this.currentPage).setMarkForReview(false);
                }
                if (this.data.getQuestionsHindi() != null && this.data.getQuestionsHindi().size() > 0 && (this.data.getQuestionsHindi().get(this.currentPage).isIssaveMarkForReview() || this.data.getQuestionsHindi().get(this.currentPage).isMarkForReview())) {
                    this.data.getQuestionsHindi().get(this.currentPage).setIssaveMarkForReview(false);
                    this.data.getQuestionsHindi().get(this.currentPage).setMarkForReview(false);
                }
                if (this.data.getQuestions() != null && this.data.getQuestions().size() > 0 && (this.data.getQuestions().get(this.currentPage).isIssaveMarkForReview() || this.data.getQuestions().get(this.currentPage).isMarkForReview())) {
                    this.data.getQuestions().get(this.currentPage).setIssaveMarkForReview(false);
                    this.data.getQuestions().get(this.currentPage).setMarkForReview(false);
                }
                if (this.questionBankList.get(this.currentPage).getQuestionType().equalsIgnoreCase("FIB")) {
                    ((FIB_CreateTestSeriesFragment) getSupportFragmentManager().findFragmentById(com.eduteria.app.app.R.id.testlayout)).refereshPage();
                } else {
                    ((SC_CreateTestSeriesFragment) getSupportFragmentManager().findFragmentById(com.eduteria.app.app.R.id.testlayout)).refereshPage();
                }
                notifynumberApater();
                break;
            case com.eduteria.app.app.R.id.btn_finish /* 2131362371 */:
                if (!isFinishing()) {
                    showPopupSubmitTest();
                }
                break;
            case com.eduteria.app.app.R.id.btn_next /* 2131362374 */:
                this.testseriesBase.setLastanswerPosition(this.currentPage);
                String questionType = this.questionBankList.get(this.currentPage + 1).getQuestionType();
                questionType.hashCode();
                if (questionType.equals("MT")) {
                    this.btnClear.setVisibility(0);
                    int i = this.currentPage;
                    setFragment(SC_CreateTestSeriesFragment.newInstance(i + 1, this.questionBankList.get(i + 1).getQuestionType()), "add", "1");
                } else if (questionType.equals("FIB")) {
                    this.btnClear.setVisibility(0);
                    setFragment(FIB_CreateTestSeriesFragment.newInstance(this.currentPage + 1), "add", "1");
                } else {
                    this.btnClear.setVisibility(0);
                    int i2 = this.currentPage;
                    setFragment(SC_CreateTestSeriesFragment.newInstance(i2 + 1, this.questionBankList.get(i2 + 1).getQuestionType()), "add", "1");
                }
                changeTextOnNextAndPrevButton();
                break;
            case com.eduteria.app.app.R.id.btn_prev /* 2131362376 */:
                this.testseriesBase.setLastanswerPosition(this.currentPage - 1);
                String questionType2 = this.questionBankList.get(this.currentPage - 1).getQuestionType();
                questionType2.hashCode();
                if (questionType2.equals("MT")) {
                    this.btnClear.setVisibility(0);
                    int i3 = this.currentPage;
                    setFragment(SC_CreateTestSeriesFragment.newInstance(i3 - 1, this.questionBankList.get(i3 - 1).getQuestionType()), "remove", "1");
                } else if (questionType2.equals("FIB")) {
                    this.btnClear.setVisibility(0);
                    setFragment(FIB_CreateTestSeriesFragment.newInstance(this.currentPage - 1), "remove", "1");
                } else {
                    this.btnClear.setVisibility(0);
                    int i4 = this.currentPage;
                    setFragment(SC_CreateTestSeriesFragment.newInstance(i4 - 1, this.questionBankList.get(i4 - 1).getQuestionType()), "remove", "1");
                }
                changeTextOnNextAndPrevButton();
                break;
            case com.eduteria.app.app.R.id.btn_submit /* 2131362380 */:
            case com.eduteria.app.app.R.id.img_pause /* 2131363703 */:
            case com.eduteria.app.app.R.id.img_testback /* 2131363712 */:
                showPopupSubmitTest();
                break;
            case com.eduteria.app.app.R.id.gridView /* 2131363455 */:
                SharedPreference.getInstance().putString("VIEW", "0");
                this.rlQuestionPad.setLayoutManager(new GridLayoutManager((Context) this, 6, 1, false));
                this.gridView.setTextColor(getResources().getColor(com.eduteria.app.app.R.color.black));
                this.gridView.setCompoundDrawablesWithIntrinsicBounds(com.eduteria.app.app.R.mipmap.grid_view, 0, 0, 0);
                this.listView.setCompoundDrawablesWithIntrinsicBounds(com.eduteria.app.app.R.mipmap.list_view_gray, 0, 0, 0);
                this.listView.setTextColor(getResources().getColor(com.eduteria.app.app.R.color.colorGray3));
                MyRecyclerAdapterTwo myRecyclerAdapterTwo = new MyRecyclerAdapterTwo(this.questionBankList, this, this.items, com.eduteria.app.app.R.layout.single_row_testpad_no, this, "0");
                this.rvQuestionAdapter = myRecyclerAdapterTwo;
                this.rlQuestionPad.setAdapter(myRecyclerAdapterTwo);
                break;
            case com.eduteria.app.app.R.id.img_testmenu /* 2131363713 */:
                CountTotalanswer();
                this.drawerLayout.openDrawer(this.llDrawerRight);
                break;
            case com.eduteria.app.app.R.id.listView /* 2131364011 */:
                SharedPreference.getInstance().putString("VIEW", "1");
                this.rlQuestionPad.setLayoutManager(new LinearLayoutManager(this));
                this.listView.setTextColor(getResources().getColor(com.eduteria.app.app.R.color.black));
                this.listView.setCompoundDrawablesWithIntrinsicBounds(com.eduteria.app.app.R.mipmap.list_view, 0, 0, 0);
                this.gridView.setCompoundDrawablesWithIntrinsicBounds(com.eduteria.app.app.R.mipmap.grid_view_gray, 0, 0, 0);
                this.gridView.setTextColor(getResources().getColor(com.eduteria.app.app.R.color.colorGray3));
                MyRecyclerAdapterTwo myRecyclerAdapterTwo2 = new MyRecyclerAdapterTwo(this.questionBankList, this, this.items, com.eduteria.app.app.R.layout.single_row_testpad_no, this, "1");
                this.rvQuestionAdapter = myRecyclerAdapterTwo2;
                this.rlQuestionPad.setAdapter(myRecyclerAdapterTwo2);
                break;
        }
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
            this.btnPrev.setBackground(getResources().getDrawable(com.eduteria.app.app.R.drawable.background_bg_prev));
            this.btnPrev.setEnabled(false);
        } else {
            ((TextView) this.btnPrev.getChildAt(0)).setTextColor(getResources().getColor(com.eduteria.app.app.R.color.white));
            this.btnPrev.setBackground(getResources().getDrawable(com.eduteria.app.app.R.drawable.background_bg_next));
            this.btnPrev.setEnabled(true);
        }
    }

    public Answers makeAnswerArray(int position) {
        if (this.questionBankList.get(position).getAnswer() != null) {
            if (!this.questionBankList.get(position).getAnswer().contains(Constants.SEPARATOR_COMMA) && this.questionBankList.get(position).getAnswerPosttion() != -1 && this.questionBankList.get(position).getAnswerPosttion() != 0) {
                String.valueOf(this.questionBankList.get(position).getAnswerPosttion());
            }
        } else if (this.questionBankList.get(position).getAnswerPosttion() != -1 && this.questionBankList.get(position).getAnswerPosttion() != 0) {
            String.valueOf(this.questionBankList.get(position).getAnswerPosttion());
        }
        String str = this.questionBankList.get(position).getIs_bookmarked().equalsIgnoreCase("0") ? "0" : "1";
        String str2 = "answered";
        String user_answer = "";
        if (!this.questionBankList.get(position).isIssaveMarkForReview() && ((!this.questionBankList.get(position).isMarkForReview() || this.questionBankList.get(position).getAnswerPosttion() == -1 || this.questionBankList.get(position).getAnswerPosttion() == 0) && (this.questionBankList.get(position).getAnswerPosttion() == -1 || this.questionBankList.get(position).getAnswerPosttion() == 0))) {
            if (this.questionBankList.get(position).isMarkForReview()) {
                str2 = "marked_for_review";
            } else if (this.questionBankList.get(position).getAnswerPosttion() == -1) {
                str2 = "not_visited";
            } else {
                str2 = this.questionBankList.get(position).getAnswerPosttion() == 0 ? "unanswered" : "";
            }
        }
        Answers answers = new Answers();
        answers.setConfig_id(this.questionBankList.get(position).getConfigId());
        answers.setSection_id(this.questionBankList.get(position).getId());
        answers.setIndex(String.valueOf(position));
        answers.setState(str2);
        answers.setIs_bookmarked(str);
        answers.setAnswer(this.questionBankList.get(position).getAnswer());
        answers.setAnswers(this.questionBankList.get(position).getAnswers());
        answers.setOn_screen(String.valueOf(this.questionBankList.get(position).getTotalTimeSpent()));
        if (this.questionBankList.get(position).getUser_answer() != null && !this.questionBankList.get(position).getUser_answer().equalsIgnoreCase("")) {
            user_answer = this.questionBankList.get(position).getUser_answer();
        }
        answers.setUser_answer(user_answer);
        return answers;
    }

    @Override // com.appnew.android.testmodule.interfaces.NumberPadOnClick
    public void sendOnclickInd(int index) {
        this.currentPage = index;
        String questionType = this.questionBankList.get(index).getQuestionType();
        questionType.hashCode();
        if (questionType.equals("MT")) {
            this.btnClear.setVisibility(0);
            setFragment(SC_CreateTestSeriesFragment.newInstance(index, this.questionBankList.get(index).getQuestionType()), "selection", "1");
        } else if (questionType.equals("FIB")) {
            this.btnClear.setVisibility(0);
            setFragment(FIB_CreateTestSeriesFragment.newInstance(index), "selection", "1");
        } else {
            this.btnClear.setVisibility(0);
            setFragment(SC_CreateTestSeriesFragment.newInstance(index, this.questionBankList.get(index).getQuestionType()), "selection", "1");
        }
    }

    private void showPopupSubmitTest() {
        try {
            View viewInflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(com.eduteria.app.app.R.layout.dialogbox_test_submit, (ViewGroup) null, false);
            final Dialog dialog = new Dialog(this);
            dialog.requestWindowFeature(1);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setContentView(viewInflate);
            dialog.show();
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
            textView4.setVisibility(8);
            textView5.setVisibility(8);
            textView6.setVisibility(8);
            textView7.setVisibility(8);
            viewFindViewById.setVisibility(0);
            viewFindViewById2.setVisibility(0);
            CountTotalanswer();
            textView.setText(String.valueOf(this.attemptCount));
            textView3.setText(String.valueOf(this.unattampedcount));
            textView4.setText(String.valueOf(this.savemarkforreviewCount));
            textView5.setText(String.valueOf(this.markforreviewCount));
            textView2.setText(String.valueOf(this.skipedQuestion));
            Button button2 = (Button) viewInflate.findViewById(com.eduteria.app.app.R.id.btn_submit);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.CreateTest.Activity.TestCreateActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.CreateTest.Activity.TestCreateActivity.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TestCreateActivity.this.isForceFinish = false;
                    dialog.dismiss();
                    TestCreateActivity.this.state = "1";
                    TestCreateActivity.this.testsubmit = true;
                    TestCreateActivity.this.finishTestSeries();
                }
            });
        } catch (WindowManager.BadTokenException e2) {
            e2.printStackTrace();
        }
    }

    public void notifynumberApater() {
        this.rvQuestionAdapter.notifyDataSetChanged();
        this.rvNumberPadAdapter.notifyDataSetChanged();
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
}
