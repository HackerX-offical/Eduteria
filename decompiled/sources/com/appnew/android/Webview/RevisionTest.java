package com.appnew.android.Webview;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.appnew.android.Courses.Activity.QuizActivity;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.CustomContextWrapper;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Progress;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.testmodule.adapter.MyRecyclerAdapter;
import com.appnew.android.testmodule.adapter.MyRecyclerAdapterTwo;
import com.appnew.android.testmodule.adapter.PartAdapter;
import com.appnew.android.testmodule.adapter.TestViewPagerAdapter;
import com.appnew.android.testmodule.fragment.FIB_TestSeriesFragment;
import com.appnew.android.testmodule.interfaces.NumberPadOnClick;
import com.appnew.android.testmodule.layoutmanager.LinearLayoutManagerWithSmoothScroller;
import com.appnew.android.testmodule.model.Answers;
import com.appnew.android.testmodule.model.AnswersResumeResponse;
import com.appnew.android.testmodule.model.Data;
import com.appnew.android.testmodule.model.Question;
import com.appnew.android.testmodule.model.Social;
import com.appnew.android.testmodule.model.TestBasic;
import com.appnew.android.testmodule.model.TestseriesBase;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes6.dex */
public class RevisionTest extends AppCompatActivity implements View.OnClickListener, NumberPadOnClick {
    private static Dialog calculator_dialog;
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
    ImageView calci;
    public int currentPage;
    public Data data;
    private DrawerLayout drawerLayout;
    public String first_attempt;
    TextView gridView;
    private ImageView imgPause;
    private ImageView imgTestBack;
    private ImageView imgTestMenu;
    private List<ViewModel> items;
    public int language;
    String lastView;
    TextView listView;
    private LinearLayout llDrawerRight;
    private LinearLayout llMarkForReview;
    private LinearLayout llMarkForReviewCount;
    Progress mProgress;
    int markforreviewCount;
    long millisInFuture;
    TextView nextTV;
    public TestViewPagerAdapter pagerAdapter;
    PartAdapter partAdapter;
    PopupWindow popupWindow;
    int prevSeconds;
    public List<Question> questionBankList;
    private RecyclerView rlQuestionPad;
    private MyRecyclerAdapter rvNumberPadAdapter;
    private RecyclerView rvNumberpad;
    private MyRecyclerAdapterTwo rvQuestionAdapter;
    int savemarkforreviewCount;
    int skipedQuestion;
    String state;
    TextView testSeriesName;
    public String testSeriesname;
    TestseriesBase testseriesBase;
    public String testseriesid;
    private TextView textSpinner;
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
    public static int[] SAMPLE_CIRCLE = {R.drawable.circle, R.drawable.circle1, R.drawable.circle2, R.drawable.circle3, R.drawable.circle4, R.drawable.circle5, R.drawable.circle6, R.drawable.circle7, R.drawable.circle8, R.drawable.circle9};
    public static boolean nestselected = false;
    public static boolean sameselected = false;
    boolean status = false;
    long count = 0;
    List<String> questionPart = new ArrayList();
    private ArrayList<Fragment> mFragmentList = new ArrayList<>();
    private CountDownTimer countDownTimer = null;
    public List<Social> items1 = new ArrayList();
    public List<Social> items2 = new ArrayList();
    boolean testsubmit = false;

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
        setContentView(R.layout.activity_revision);
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());
        getWindow().addFlags(128);
        int i = SharedPreference.getInstance().getInt(Const.LANGUAGE);
        if (i == 1) {
            Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.ENGLISH), this);
        } else if (i == 2) {
            Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE, Const.HINDI), this);
        }
        SharedPreference.getInstance().putString("VIEW", "0");
        setReference();
        this.testseriesBase = (TestseriesBase) ((Bundle) Objects.requireNonNull(getIntent().getExtras())).getSerializable("test_series");
        this.testseriesid = getIntent().getExtras().getString(Const.TEST_SERIES_ID);
        this.testSeriesname = getIntent().getExtras().getString(Const.TEST_SERIES_Name);
        this.first_attempt = getIntent().getExtras().getString("first_attempt");
        this.language = getIntent().getExtras().getInt(Const.LANG);
        this.data = this.testseriesBase.getData();
        TestBasic testBasic = this.testseriesBase.getData().getTestBasic();
        this.basicInfo = testBasic;
        this.testSeriesName.setText(testBasic.getTestSeriesName());
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
        this.rvNumberpad.setVisibility(0);
        this.questionBankList = this.data.getQuestions();
        for (int i = 0; i < this.questionBankList.size(); i++) {
            addFragment(i, this.questionBankList.get(i).getQuestionType());
        }
        this.tvQuestionnumber.setText(getResources().getString(R.string.question) + ((this.testseriesBase.getLastanswerPosition() == -1 || this.testseriesBase.getLastanswerPosition() == 0) ? 1 : this.testseriesBase.getLastanswerPosition()) + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.questionBankList.size());
        TestViewPagerAdapter testViewPagerAdapter = new TestViewPagerAdapter(getSupportFragmentManager(), this, this.mFragmentList, this.questionBankList.size());
        this.pagerAdapter = testViewPagerAdapter;
        this.viewPagerTest.setAdapter(testViewPagerAdapter);
        this.rvQuestionAdapter = new MyRecyclerAdapterTwo(this.questionBankList, this, this.items, R.layout.single_row_testpad_no, this, "0");
        this.rvNumberPadAdapter = new MyRecyclerAdapter(this.questionBankList, this, this.items, R.layout.single_row_testpad_no, this);
        this.rlQuestionPad.setAdapter(this.rvQuestionAdapter);
        this.rlQuestionPad.setLayoutManager(new GridLayoutManager((Context) this, 6, 1, false));
        this.rlQuestionPad.setItemAnimator(new DefaultItemAnimator());
        this.rvNumberpad.setAdapter(this.rvNumberPadAdapter);
        this.rvNumberpad.setLayoutManager(new LinearLayoutManagerWithSmoothScroller(this, 0, false));
        this.rvNumberpad.setItemAnimator(new DefaultItemAnimator());
        this.viewPagerTest.setCurrentItem(0);
    }

    private void setReference() {
        this.calci = (ImageView) findViewById(R.id.calci);
        this.llDrawerRight = (LinearLayout) findViewById(R.id.llDrawerRight);
        this.drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        this.imgTestBack = (ImageView) findViewById(R.id.img_testback);
        this.imgTestMenu = (ImageView) findViewById(R.id.img_testmenu);
        this.rlQuestionPad = (RecyclerView) findViewById(R.id.rl_questionpad);
        this.rvNumberpad = (RecyclerView) findViewById(R.id.rvnumberpad);
        this.viewPagerTest = (ViewPager) findViewById(R.id.view_pager_test);
        this.btnNext = (FrameLayout) findViewById(R.id.btn_next);
        this.btnPrev = (FrameLayout) findViewById(R.id.btn_prev);
        this.btnClear = (TextView) findViewById(R.id.btn_clear);
        this.llMarkForReview = (LinearLayout) findViewById(R.id.llMarkForReview);
        this.tvTime = (TextView) findViewById(R.id.tv_time);
        this.btn_finish = (FrameLayout) findViewById(R.id.btn_finish);
        this.llMarkForReviewCount = (LinearLayout) findViewById(R.id.llMarkForReviewCount);
        this.viewMarkForReviewCount = findViewById(R.id.viewMarkForReviewCount);
        this.nextTV = (TextView) findViewById(R.id.nextTV);
        this.textSpinner = (TextView) findViewById(R.id.text_spinner);
        this.tvQuestionnumber = (TextView) findViewById(R.id.tv_questionnumber);
        this.tvanswerCount = (TextView) findViewById(R.id.tv_answer_count);
        this.tvUnAnswerCount = (TextView) findViewById(R.id.tv_unanswer_count);
        this.testSeriesName = (TextView) findViewById(R.id.testSeriesName);
        this.tvSkipCount = (TextView) findViewById(R.id.tv_skip_count);
        this.tvmarkForReviewCount = (TextView) findViewById(R.id.tv_markforReview_count);
        this.tv_savemarkforReview_count = (TextView) findViewById(R.id.tv_savemarkforReview_count);
        this.btn_submit = (Button) findViewById(R.id.btn_submit);
        this.imgPause = (ImageView) findViewById(R.id.img_pause);
        this.gridView = (TextView) findViewById(R.id.gridView);
        this.listView = (TextView) findViewById(R.id.listView);
        this.tvmarkForReviewCount.setVisibility(0);
        this.tv_savemarkforReview_count.setVisibility(0);
        this.llMarkForReviewCount.setVisibility(0);
        this.viewMarkForReviewCount.setVisibility(0);
        this.llMarkForReview.setVisibility(0);
        this.btn_submit.setOnClickListener(this);
        this.btnNext.setOnClickListener(this);
        this.calci.setOnClickListener(this);
        this.btn_finish.setOnClickListener(this);
        this.btnPrev.setOnClickListener(this);
        this.imgPause.setOnClickListener(this);
        this.drawerLayout.setDrawerLockMode(1, GravityCompat.END);
        this.questionBankList = new ArrayList();
        this.imgTestBack.setOnClickListener(this);
        this.imgTestMenu.setOnClickListener(this);
        this.btnClear.setOnClickListener(this);
        this.viewPagerTest.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.appnew.android.Webview.RevisionTest.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int state) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                RevisionTest.this.changeTextOnNextAndPrevButton();
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(final int position) {
                RevisionTest.this.currentPage = position;
                RevisionTest.this.rvNumberpad.scrollToPosition(RevisionTest.this.currentPage);
                RevisionTest.this.rvNumberpad.getLayoutManager().smoothScrollToPosition(RevisionTest.this.rvNumberpad, new RecyclerView.State(), RevisionTest.this.currentPage);
                RevisionTest.this.rvNumberPadAdapter.setSelectePosition(position);
                if (RevisionTest.this.questionBankList.get(position).getAnswerPosttion() == -1) {
                    RevisionTest.this.questionBankList.get(position).setIsanswer(false, 0);
                }
                if (RevisionTest.this.data != null) {
                    RevisionTest.this.tvQuestionnumber.setText(RevisionTest.this.getResources().getString(R.string.question) + (position + 1) + MqttTopic.TOPIC_LEVEL_SEPARATOR + RevisionTest.this.questionBankList.size());
                }
                RevisionTest.this.testseriesBase.setLastanswerPosition(RevisionTest.this.currentPage);
                new Handler(Looper.myLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.Webview.RevisionTest.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RevisionTest.this.rvQuestionAdapter.setSelectePosition(position);
                    }
                }, 1000L);
            }
        });
        this.gridView.setOnClickListener(this);
        this.listView.setOnClickListener(this);
    }

    private void addFragment(int i, String questionType) {
        questionType.hashCode();
        if (questionType.equals("MT")) {
            this.btnClear.setVisibility(0);
            this.mFragmentList.add(RevisionSC_TestSeriesFragment.newInstance(i, questionType));
        } else if (questionType.equals("FIB")) {
            this.btnClear.setVisibility(0);
            this.mFragmentList.add(FIB_TestSeriesFragment.newInstance(i));
        } else {
            this.btnClear.setVisibility(0);
            this.mFragmentList.add(RevisionSC_TestSeriesFragment.newInstance(i, questionType));
        }
    }

    private AdapterView.OnItemClickListener onItemClickListener() {
        return new AdapterView.OnItemClickListener() { // from class: com.appnew.android.Webview.RevisionTest$$ExternalSyntheticLambda0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                this.f$0.lambda$onItemClickListener$0(adapterView, view, i, j);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onItemClickListener$0(AdapterView adapterView, View view, int i, long j) {
        if (i == 0) {
            this.rvNumberpad.scrollToPosition(0);
            this.viewPagerTest.setCurrentItem(0);
            this.textSpinner.setText(this.questionPart.get(0));
        } else if (i == 1) {
            this.rvNumberpad.scrollToPosition(100);
            this.viewPagerTest.setCurrentItem(100);
            this.textSpinner.setText(this.questionPart.get(1));
        } else if (i == 2) {
            this.rvNumberpad.scrollToPosition(200);
            this.viewPagerTest.setCurrentItem(200);
            this.textSpinner.setText(this.questionPart.get(2));
        }
        dismissPopup();
    }

    private void dismissPopup() {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
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
        this.status = true;
        this.millisInFuture = 3600000L;
        CountDownTimer countDownTimer = new CountDownTimer(this.millisInFuture, 1000L) { // from class: com.appnew.android.Webview.RevisionTest.2
            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                RevisionTest.this.count = millisUntilFinished / 1000;
                TextView textView = RevisionTest.this.tvTime;
                RevisionTest revisionTest = RevisionTest.this;
                textView.setText(revisionTest.formatSeconds((int) revisionTest.count));
                RevisionTest.this.data.getTestBasic().setTimeRemaining(millisUntilFinished);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                RevisionTest.this.status = false;
                RevisionTest.this.tvTime.setText("00:00:00");
                if (RevisionTest.this.isFinishing()) {
                    return;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(RevisionTest.this);
                builder.setTitle(RevisionTest.this.getResources().getString(R.string.time_out));
                builder.setMessage(RevisionTest.this.getResources().getString(R.string.time_over_message));
                builder.setCancelable(false);
                builder.setNegativeButton(Html.fromHtml("<font color='#000000'>Ok</font>"), new DialogInterface.OnClickListener() { // from class: com.appnew.android.Webview.RevisionTest.2.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        RevisionTest.this.testsubmit = true;
                        RevisionTest.this.finishTestSeries();
                    }
                });
                builder.create().show();
            }
        };
        this.countDownTimer = countDownTimer;
        countDownTimer.start();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
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
        intent.putExtra(Const.FRAG_TYPE, Const.REVISION_SCRREN);
        intent.putExtra("name", this.testSeriesname);
        intent.putExtra("questionBankList", new Gson().toJson(this.questionBankList));
        intent.putExtra("revision_string", json);
        intent.putExtra("testseriesBase", this.testseriesBase);
        startActivity(intent);
        finish();
    }

    public String formatSeconds(int timeInSeconds) {
        int i = timeInSeconds / 3600;
        int i2 = timeInSeconds - (i * 3600);
        int i3 = i2 / 60;
        int i4 = i2 - (i3 * 60);
        if (i4 != this.prevSeconds) {
            this.questionBankList.get(this.currentPage).setTotalTimeSpent(this.questionBankList.get(this.currentPage).getTotalTimeSpent() + 1);
        }
        this.prevSeconds = i4;
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

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        showPopupSubmitTest();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_clear /* 2131362363 */:
                if (this.questionBankList.get(this.currentPage).isIssaveMarkForReview() || this.questionBankList.get(this.currentPage).isMarkForReview()) {
                    this.questionBankList.get(this.currentPage).setIssaveMarkForReview(false);
                    this.questionBankList.get(this.currentPage).setMarkForReview(false);
                }
                ((RevisionSC_TestSeriesFragment) this.mFragmentList.get(this.currentPage)).refereshPage();
                notifynumberApater();
                break;
            case R.id.btn_finish /* 2131362371 */:
                if (!isFinishing()) {
                    showPopupSubmitTest();
                }
                break;
            case R.id.btn_next /* 2131362374 */:
                this.testseriesBase.setLastanswerPosition(this.currentPage);
                ViewPager viewPager = this.viewPagerTest;
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
                changeTextOnNextAndPrevButton();
                break;
            case R.id.btn_prev /* 2131362376 */:
                this.testseriesBase.setLastanswerPosition(this.currentPage);
                ViewPager viewPager2 = this.viewPagerTest;
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() - 1, true);
                changeTextOnNextAndPrevButton();
                break;
            case R.id.btn_submit /* 2131362380 */:
                if (!isFinishing()) {
                    showPopupSubmitTest();
                }
                break;
            case R.id.calci /* 2131362415 */:
                openCalculator_web(this);
                break;
            case R.id.cl_part /* 2131362577 */:
            case R.id.img_pause /* 2131363703 */:
            case R.id.img_testback /* 2131363712 */:
                showPopupSubmitTest();
                break;
            case R.id.gridView /* 2131363455 */:
                SharedPreference.getInstance().putString("VIEW", "0");
                this.rlQuestionPad.setLayoutManager(new GridLayoutManager((Context) this, 6, 1, false));
                this.gridView.setTextColor(getResources().getColor(R.color.black));
                this.gridView.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.grid_view, 0, 0, 0);
                this.listView.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.list_view_gray, 0, 0, 0);
                this.listView.setTextColor(getResources().getColor(R.color.colorGray3));
                MyRecyclerAdapterTwo myRecyclerAdapterTwo = new MyRecyclerAdapterTwo(this.questionBankList, this, this.items, R.layout.single_row_testpad_no, this, "0");
                this.rvQuestionAdapter = myRecyclerAdapterTwo;
                this.rlQuestionPad.setAdapter(myRecyclerAdapterTwo);
                break;
            case R.id.img_testmenu /* 2131363713 */:
                CountTotalanswer();
                this.drawerLayout.openDrawer(this.llDrawerRight);
                break;
            case R.id.listView /* 2131364011 */:
                SharedPreference.getInstance().putString("VIEW", "1");
                this.rlQuestionPad.setLayoutManager(new LinearLayoutManager(this));
                this.listView.setTextColor(getResources().getColor(R.color.black));
                this.listView.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.list_view, 0, 0, 0);
                this.gridView.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.grid_view_gray, 0, 0, 0);
                this.gridView.setTextColor(getResources().getColor(R.color.colorGray3));
                MyRecyclerAdapterTwo myRecyclerAdapterTwo2 = new MyRecyclerAdapterTwo(this.questionBankList, this, this.items, R.layout.single_row_testpad_no, this, "1");
                this.rvQuestionAdapter = myRecyclerAdapterTwo2;
                this.rlQuestionPad.setAdapter(myRecyclerAdapterTwo2);
                break;
        }
    }

    public void changeTextOnNextAndPrevButton() {
        int currentItem = this.viewPagerTest.getCurrentItem() + 1;
        if (currentItem == this.questionBankList.size()) {
            this.btn_finish.setVisibility(0);
            this.btnNext.setVisibility(8);
        } else {
            this.btn_finish.setVisibility(8);
            this.btnNext.setVisibility(0);
        }
        if (currentItem == 1) {
            ((TextView) this.btnPrev.getChildAt(0)).setTextColor(getResources().getColor(R.color.white));
            this.btnPrev.setBackground(getResources().getDrawable(R.drawable.background_bg_prev));
        } else {
            ((TextView) this.btnPrev.getChildAt(0)).setTextColor(getResources().getColor(R.color.whiteApp));
            this.btnPrev.setBackground(getResources().getDrawable(R.drawable.background_bg_next));
        }
    }

    public Answers makeAnswerArray(int position) {
        this.questionBankList.get(position).getIs_bookmarked().equalsIgnoreCase("0");
        String str = "answered";
        String user_answer = "";
        if (!this.questionBankList.get(position).isIssaveMarkForReview() && ((!this.questionBankList.get(position).isMarkForReview() || this.questionBankList.get(position).getAnswerPosttion() == -1 || this.questionBankList.get(position).getAnswerPosttion() == 0) && (this.questionBankList.get(position).getAnswerPosttion() == -1 || this.questionBankList.get(position).getAnswerPosttion() == 0))) {
            if (this.questionBankList.get(position).isMarkForReview()) {
                str = "marked_for_review";
            } else if (this.questionBankList.get(position).getAnswerPosttion() == -1) {
                str = "not_visited";
            } else {
                str = this.questionBankList.get(position).getAnswerPosttion() == 0 ? "unanswered" : "";
            }
        }
        Answers answers = new Answers();
        answers.setConfig_id(this.questionBankList.get(position).getId());
        answers.setIndex(String.valueOf(position));
        answers.setState(str);
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
        this.viewPagerTest.setCurrentItem(index);
    }

    private void showPopupSubmitTest() {
        try {
            View viewInflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.dialogbox_test_submit, (ViewGroup) null, false);
            final Dialog dialog = new Dialog(this);
            dialog.requestWindowFeature(1);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setContentView(viewInflate);
            dialog.show();
            Button button = (Button) viewInflate.findViewById(R.id.btn_cancel);
            TextView textView = (TextView) viewInflate.findViewById(R.id.answeredTV);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.not_visted_value);
            TextView textView3 = (TextView) viewInflate.findViewById(R.id.unansweredTV);
            TextView textView4 = (TextView) viewInflate.findViewById(R.id.save_markedTV);
            TextView textView5 = (TextView) viewInflate.findViewById(R.id.markedTV);
            TextView textView6 = (TextView) viewInflate.findViewById(R.id.marked1);
            TextView textView7 = (TextView) viewInflate.findViewById(R.id.save_marked1);
            View viewFindViewById = viewInflate.findViewById(R.id.markedView1);
            View viewFindViewById2 = viewInflate.findViewById(R.id.markedView2);
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
            Button button2 = (Button) viewInflate.findViewById(R.id.btn_submit);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Webview.RevisionTest.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Webview.RevisionTest.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    dialog.dismiss();
                    RevisionTest.this.testsubmit = true;
                    RevisionTest.this.finishTestSeries();
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

    public void openCalculator_web(Context context) {
        try {
            Dialog dialog = new Dialog(context, R.style.MyDialogCalculator);
            calculator_dialog = dialog;
            dialog.requestWindowFeature(1);
            calculator_dialog.setContentView(R.layout.dialog_calculator_web);
            calculator_dialog.setCancelable(true);
            calculator_dialog.setCanceledOnTouchOutside(true);
            calculator_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            calculator_dialog.getWindow().setSoftInputMode(3);
            calculator_dialog.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
            WebView webView = (WebView) calculator_dialog.findViewById(R.id.calcwebView);
            RelativeLayout relativeLayout = (RelativeLayout) calculator_dialog.findViewById(R.id.calcpagerl);
            AppCompatButton appCompatButton = (AppCompatButton) calculator_dialog.findViewById(R.id.btn_close);
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
            appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Webview.RevisionTest.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    RevisionTest.dismissCalculatorDialog();
                }
            });
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Webview.RevisionTest.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    RevisionTest.dismissCalculatorDialog();
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

    private String removeTrailingZero(String formattingInput) {
        if (!formattingInput.contains(InstructionFileId.DOT)) {
            return formattingInput;
        }
        int iIndexOf = formattingInput.indexOf(InstructionFileId.DOT);
        return formattingInput.substring(iIndexOf, formattingInput.length()).equals(".0") ? formattingInput.substring(0, iIndexOf) : formattingInput;
    }
}
