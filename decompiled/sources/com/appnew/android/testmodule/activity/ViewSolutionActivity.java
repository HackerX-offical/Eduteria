package com.appnew.android.testmodule.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.FileProvider;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.MediaFile;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.AmazonUpload.AmazonCallBack;
import com.appnew.android.Utils.AmazonUpload.s3ImageUploading;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.Progress;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.testmodule.adapter.MyRecyclerAdapter;
import com.appnew.android.testmodule.adapter.TestViewPagerAdapter;
import com.appnew.android.testmodule.fragment.LearnFragmentReport;
import com.appnew.android.testmodule.fragment.ViewSolutionFragment;
import com.appnew.android.testmodule.interfaces.NumberPadOnClick;
import com.appnew.android.testmodule.layoutmanager.LinearLayoutManagerWithSmoothScroller;
import com.appnew.android.testmodule.model.Challenge_Report;
import com.appnew.android.testmodule.model.QuesReportOption;
import com.appnew.android.testmodule.model.QuestionDumps;
import com.appnew.android.testmodule.model.Questions2;
import com.appnew.android.testmodule.model.ResultTestSeries_Report;
import com.appnew.android.testmodule.model.TestseriesBase;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes6.dex */
public class ViewSolutionActivity extends AppCompatActivity implements NumberPadOnClick, View.OnClickListener, AmazonCallBack {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int PICK_FILE_REQUEST = 1;
    AppCompatImageView bookmark_icon_deselect;
    AppCompatImageView bookmark_icon_select;
    FrameLayout btnNext;
    FrameLayout btnPrev;
    TextView challenges_txt;
    TextView changelang;
    private ArrayList<Questions2> defaultHindiQuestionsList;
    private ArrayList<Questions2> defaultQuestionsList;
    DrawerLayout drawerLayout;
    ImageView img_fileAttached;
    ImageView img_testback;
    int lang;
    ImageView langimage;
    private LinearLayout layout_fileAttach7;
    private RelativeLayout layout_fileDetail7;
    Progress mProgress;
    private RelativeLayout no_data_found_RL;
    public TestViewPagerAdapter pagerAdapter;
    public ResultTestSeries_Report resultTestSeries;
    public ResultTestSeries_Report resultTestSeries2;
    ConstraintLayout rootConstraint;
    private MyRecyclerAdapter rvNumberPadAdapter;
    private RecyclerView rvNumberpad;
    private s3ImageUploading s3IU;
    private String selectedLangId;
    private RelativeLayout solutionRl;
    ImageView testResultFilter;
    TextView testSeriesName;
    FrameLayout testlayout;
    public TestseriesBase testseriesBase;
    Toolbar toolbar;
    TextView tvQuestionnumber;
    private TextView txt_fileName7;
    private TextView txt_fileSize7;
    private TextView txt_tapAddNote7;
    String type;
    private ViewPager viewPagerSolution;
    public int currentPage = 0;
    String test_segment_id = "";
    String test_series_name = "";
    String frag_type = "";
    String resultType = "all";
    private ArrayList<Fragment> mFragmentList = new ArrayList<>();
    private String selectedFilePath = "";
    private String str_qtype = "";
    private String file_url = "";
    int requestCode = -1;
    private boolean isLanguageTextAttached = false;
    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.testmodule.activity.ViewSolutionActivity$$ExternalSyntheticLambda1
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) throws Throwable {
            this.f$0.lambda$new$3((ActivityResult) obj);
        }
    });

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.activity_view_solution);
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());
        initView();
        showPopupMenu();
    }

    private void showPopupMenu() {
        this.testResultFilter = (ImageView) findViewById(R.id.testResultFilter);
        String str = this.type;
        if (str != null && str.equalsIgnoreCase("learn")) {
            this.testResultFilter.setVisibility(8);
        }
        this.testResultFilter.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.ViewSolutionActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showPopupMenu$1(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPopupMenu$1(View view) {
        PopupMenu popupMenu = new PopupMenu(this, this.testResultFilter);
        popupMenu.getMenuInflater().inflate(R.menu.result_filter, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.testmodule.activity.ViewSolutionActivity$$ExternalSyntheticLambda2
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return this.f$0.lambda$showPopupMenu$0(menuItem);
            }
        });
        popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$showPopupMenu$0(MenuItem menuItem) {
        this.currentPage = 0;
        getBundleData(menuItem.getTitle().toString());
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
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
        this.img_testback.setColorFilter(Color.parseColor(color.split(":")[1]), PorterDuff.Mode.SRC_IN);
        this.testSeriesName.setTextColor(Color.parseColor(color.split(":")[1]));
        this.btnNext.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(color.split(":")[0])));
        Window window = getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.clearFlags(67108864);
        window.setStatusBarColor(Color.parseColor(color.split(":")[0]));
    }

    private void initView() {
        Progress progress = new Progress(this);
        this.mProgress = progress;
        progress.setCancelable(false);
        this.solutionRl = (RelativeLayout) findViewById(R.id.solutionRl);
        this.no_data_found_RL = (RelativeLayout) findViewById(R.id.no_data_found_RL);
        this.rvNumberpad = (RecyclerView) findViewById(R.id.rvnumberpad);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.changelang = (TextView) findViewById(R.id.changelang);
        this.langimage = (ImageView) findViewById(R.id.langimage);
        this.testlayout = (FrameLayout) findViewById(R.id.testlayout);
        this.viewPagerSolution = (ViewPager) findViewById(R.id.view_pager_test);
        this.tvQuestionnumber = (TextView) findViewById(R.id.tv_questionnumber);
        this.challenges_txt = (TextView) findViewById(R.id.challenges_txt);
        this.img_testback = (ImageView) findViewById(R.id.img_testback);
        this.testSeriesName = (TextView) findViewById(R.id.testSeriesName);
        this.btnNext = (FrameLayout) findViewById(R.id.btn_next);
        this.btnPrev = (FrameLayout) findViewById(R.id.btn_prev);
        this.bookmark_icon_select = (AppCompatImageView) findViewById(R.id.bookmark_icon_select);
        this.bookmark_icon_deselect = (AppCompatImageView) findViewById(R.id.bookmark_icon_deselect);
        this.rootConstraint = (ConstraintLayout) findViewById(R.id.rootConstraint);
        this.drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        this.btnNext.setOnClickListener(this);
        this.btnPrev.setOnClickListener(this);
        this.img_testback.setOnClickListener(this);
        this.challenges_txt.setOnClickListener(this);
        getBundleData(this.resultType);
        getReportQuestionData();
    }

    private void getReportQuestionData() {
        if (SharedPreference.getInstance().getString("test_series").equalsIgnoreCase("")) {
            return;
        }
        this.testseriesBase = (TestseriesBase) new Gson().fromJson(SharedPreference.getInstance().getString("test_series"), TestseriesBase.class);
    }

    private void getBundleData(String resultType) {
        this.test_segment_id = getIntent().getStringExtra(Const.TESTSEGMENT_ID);
        this.test_series_name = getIntent().getStringExtra("name");
        this.frag_type = getIntent().getStringExtra(Const.FRAG_TYPE);
        this.type = getIntent().getStringExtra("type");
        this.lang = getIntent().getIntExtra(Const.LANG, 1);
        ResultTestSeries_Report resultTestSeries_Report = (ResultTestSeries_Report) new Gson().fromJson(SharedPreference.getInstance().getString("testresult"), ResultTestSeries_Report.class);
        String lang_id = resultTestSeries_Report.getData().getLang_id();
        if (this.selectedLangId == null) {
            if (lang_id != null && lang_id.contains(Constants.SEPARATOR_COMMA)) {
                this.selectedLangId = lang_id.split(Constants.SEPARATOR_COMMA)[0];
            } else if (lang_id != null) {
                this.selectedLangId = lang_id;
            }
        }
        ResultTestSeries_Report resultTestSeries_ReportFilterQuestion = filterQuestion(resultTestSeries_Report, resultType, this.selectedLangId);
        this.resultTestSeries2 = resultTestSeries_ReportFilterQuestion;
        this.resultTestSeries = resultTestSeries_ReportFilterQuestion;
        String str = this.type;
        if (str != null && str.equalsIgnoreCase("learn")) {
            this.solutionRl.setVisibility(0);
            this.no_data_found_RL.setVisibility(8);
        } else if (this.resultTestSeries.getData().getQuestion_dump() == null || this.resultTestSeries.getData().getQuestion_dump().isEmpty()) {
            this.solutionRl.setVisibility(8);
            this.no_data_found_RL.setVisibility(0);
        } else {
            this.solutionRl.setVisibility(0);
            this.no_data_found_RL.setVisibility(8);
        }
        if (this.selectedLangId.equalsIgnoreCase("1")) {
            this.resultTestSeries2.getData().setQuestions(this.resultTestSeries2.getData().getQuestions());
        } else if (this.selectedLangId.equalsIgnoreCase("2")) {
            this.resultTestSeries2.getData().setQuestions(this.resultTestSeries2.getData().getQuestionsHindi());
        }
        if (this.defaultQuestionsList == null && this.resultTestSeries2.getData().getQuestions() != null && this.resultTestSeries2.getData().getQuestions().size() > 0) {
            this.defaultQuestionsList = this.resultTestSeries2.getData().getQuestions();
        }
        if (this.defaultHindiQuestionsList == null && this.resultTestSeries2.getData().getQuestionsHindi() != null && this.resultTestSeries2.getData().getQuestionsHindi().size() > 0) {
            this.defaultHindiQuestionsList = this.resultTestSeries2.getData().getQuestionsHindi();
        }
        if (this.lang == 2 && this.resultTestSeries2.getData().getQuestionsHindi() != null) {
            this.resultTestSeries2.getData().setQuestions(this.resultTestSeries2.getData().getQuestionsHindi());
        }
        if (this.resultTestSeries2.getData().getLang_id().length() == 3) {
            if (!this.isLanguageTextAttached) {
                this.changelang.setVisibility(8);
                this.langimage.setVisibility(0);
                if (this.lang == 2) {
                    this.changelang.setText(getResources().getString(R.string.e_h));
                } else {
                    this.changelang.setText(getResources().getString(R.string.h_e));
                }
                this.isLanguageTextAttached = true;
            }
        } else {
            this.changelang.setVisibility(8);
            this.langimage.setVisibility(8);
            this.changelang.setText("");
        }
        this.langimage.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.ViewSolutionActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$getBundleData$2(view);
            }
        });
        if (this.resultTestSeries2.getData().getQuestions() == null || this.resultTestSeries2.getData().getQuestions().size() <= 0) {
            return;
        }
        String str2 = this.test_series_name;
        if (str2 != null && !str2.equals("")) {
            this.testSeriesName.setText(this.test_series_name);
        } else {
            this.testSeriesName.setText(getResources().getString(R.string.solution));
        }
        String str3 = this.frag_type;
        if (str3 != null && str3.equalsIgnoreCase(Const.SOLUTIONREPORT)) {
            String str4 = this.type;
            if (str4 != null && str4.equalsIgnoreCase("learn")) {
                this.challenges_txt.setVisibility(8);
            } else {
                this.challenges_txt.setVisibility(0);
            }
        } else {
            this.challenges_txt.setVisibility(8);
        }
        if (this.resultTestSeries2 != null) {
            this.tvQuestionnumber.setText(getResources().getString(R.string.question_) + this.resultTestSeries2.getData().getQuestions().size());
            setViewSolutionData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getBundleData$2(View view) {
        if (this.changelang.getText().equals("H/E")) {
            if (this.resultTestSeries.getData().getQuestionsHindi() != null) {
                this.resultTestSeries2.getData().setQuestions(this.defaultHindiQuestionsList);
            }
            this.selectedLangId = String.valueOf(2);
            this.changelang.setText(getResources().getString(R.string.e_h));
            setViewSolutionData();
            return;
        }
        if (this.changelang.getText().equals("E/H")) {
            if (this.resultTestSeries.getData().getQuestions() != null) {
                this.resultTestSeries2.getData().setQuestions(this.defaultQuestionsList);
            }
            this.selectedLangId = String.valueOf(1);
            this.changelang.setText(getResources().getString(R.string.h_e));
            setViewSolutionData();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public ResultTestSeries_Report filterQuestion(ResultTestSeries_Report testSeriesReport, String resultType, String selectedLangId) {
        ArrayList<Questions2> arrayList = new ArrayList<>();
        ArrayList<QuestionDumps> arrayList2 = new ArrayList<>();
        ArrayList<Questions2> arrayList3 = new ArrayList<>();
        ArrayList<QuestionDumps> arrayList4 = new ArrayList<>();
        ArrayList<Questions2> arrayList5 = new ArrayList<>();
        ArrayList<QuestionDumps> arrayList6 = new ArrayList<>();
        ArrayList<Questions2> questionsHindi = "2".equals(selectedLangId) ? testSeriesReport.getData().getQuestionsHindi() : testSeriesReport.getData().getQuestions();
        ArrayList<QuestionDumps> question_dump = testSeriesReport.getData().getQuestion_dump();
        if (questionsHindi != null && question_dump != null) {
            HashMap map = new HashMap();
            for (QuestionDumps questionDumps : question_dump) {
                map.put(questionDumps.getConfigId(), questionDumps);
            }
            for (Questions2 questions2 : questionsHindi) {
                QuestionDumps questionDumps2 = (QuestionDumps) map.get(questions2.getConfigId());
                if (questionDumps2 != null) {
                    String lowerCase = questionDumps2.getState() != null ? questionDumps2.getState().toLowerCase() : "";
                    if (lowerCase.equals("not_visited") || lowerCase.equals("unanswered")) {
                        arrayList5.add(questions2);
                        arrayList6.add(questionDumps2);
                    } else {
                        List<Object> answers = questionDumps2.getAnswers();
                        if (answers == null || answers.isEmpty()) {
                            arrayList5.add(questions2);
                            arrayList6.add(questionDumps2);
                        } else {
                            try {
                                int i = Integer.parseInt(questions2.getAnswer()) - 1;
                                if ((i < 0 || i >= answers.size()) ? false : "1".equals(String.valueOf(answers.get(i)))) {
                                    arrayList.add(questions2);
                                    arrayList2.add(questionDumps2);
                                } else {
                                    arrayList3.add(questions2);
                                    arrayList4.add(questionDumps2);
                                }
                            } catch (Exception unused) {
                                arrayList5.add(questions2);
                                arrayList6.add(questionDumps2);
                            }
                        }
                    }
                }
            }
            String lowerCase2 = resultType != null ? resultType.toLowerCase() : "all";
            switch (lowerCase2.hashCode()) {
                case -1912206962:
                    lowerCase2.equals(Const.all_questions);
                    break;
                case -1413384283:
                    if (lowerCase2.equals(Const.incorrect)) {
                        if ("2".equals(selectedLangId)) {
                            testSeriesReport.getData().setQuestionsHindi(arrayList3);
                        } else {
                            testSeriesReport.getData().setQuestions(arrayList3);
                        }
                        testSeriesReport.getData().setQuestion_dump(arrayList4);
                    }
                    break;
                case -286544461:
                    if (lowerCase2.equals(Const.unattempted)) {
                        if ("2".equals(selectedLangId)) {
                            testSeriesReport.getData().setQuestionsHindi(arrayList5);
                        } else {
                            testSeriesReport.getData().setQuestions(arrayList5);
                        }
                        testSeriesReport.getData().setQuestion_dump(arrayList6);
                    }
                    break;
                case 955164778:
                    if (lowerCase2.equals(Const.correct)) {
                        if ("2".equals(selectedLangId)) {
                            testSeriesReport.getData().setQuestionsHindi(arrayList);
                        } else {
                            testSeriesReport.getData().setQuestions(arrayList);
                        }
                        testSeriesReport.getData().setQuestion_dump(arrayList2);
                    }
                    break;
            }
        }
        return testSeriesReport;
    }

    private void navigateToViewSolutionFragment() {
        try {
            SharedPreference.getInstance().putString("myResultTestSeries2", new Gson().toJson(this.resultTestSeries2));
            if (this.type == null) {
                int i = this.currentPage;
                ResultTestSeries_Report resultTestSeries_Report = this.resultTestSeries2;
                setFragment(ViewSolutionFragment.newInstance(i, resultTestSeries_Report, resultTestSeries_Report.getData().getQuestions().get(this.currentPage).getQuestionType()), "add", "0");
            } else {
                int i2 = this.currentPage;
                ResultTestSeries_Report resultTestSeries_Report2 = this.resultTestSeries2;
                setFragment(LearnFragmentReport.newInstance(i2, resultTestSeries_Report2, resultTestSeries_Report2.getData().getQuestions().get(this.currentPage).getQuestionType(), this.type), "add", "0");
            }
        } catch (IndexOutOfBoundsException e2) {
            Log.e("IndexOutOfBounds", "Invalid index: " + e2.getMessage());
        }
    }

    protected void setFragment(Fragment fragment, String status, String pos) {
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        if (status.equalsIgnoreCase("add")) {
            fragmentTransactionBeginTransaction.replace(R.id.testlayout, fragment);
            fragmentTransactionBeginTransaction.commit();
        }
        this.rvNumberpad.scrollToPosition(this.currentPage);
        this.rvNumberpad.getLayoutManager().smoothScrollToPosition(this.rvNumberpad, new RecyclerView.State(), this.currentPage);
        this.rvNumberPadAdapter.setSelectePosition(this.currentPage);
        if (this.resultTestSeries2 != null) {
            this.tvQuestionnumber.setText("Question " + (this.currentPage + 1) + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.resultTestSeries2.getData().getQuestions().size());
        }
    }

    private void setViewSolutionData() {
        this.drawerLayout.setVisibility(0);
        MyRecyclerAdapter myRecyclerAdapter = new MyRecyclerAdapter((List<Questions2>) this.resultTestSeries2.getData().getQuestions(), (Activity) this, R.layout.single_row_testpad_no, (NumberPadOnClick) this, true);
        this.rvNumberPadAdapter = myRecyclerAdapter;
        this.rvNumberpad.setAdapter(myRecyclerAdapter);
        this.rvNumberpad.setLayoutManager(new LinearLayoutManagerWithSmoothScroller(this, 0, false));
        navigateToViewSolutionFragment();
        changeTextOnNextAndPrevButton();
    }

    @Override // com.appnew.android.testmodule.interfaces.NumberPadOnClick
    public void sendOnclickInd(int index) {
        this.currentPage = index;
        changeTextOnNextAndPrevButton();
        navigateToViewSolutionFragment();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next /* 2131362374 */:
                this.currentPage++;
                navigateToViewSolutionFragment();
                changeTextOnNextAndPrevButton();
                break;
            case R.id.btn_prev /* 2131362376 */:
                this.currentPage--;
                navigateToViewSolutionFragment();
                changeTextOnNextAndPrevButton();
                break;
            case R.id.challenges_txt /* 2131362521 */:
                challeneg_dialog();
                break;
            case R.id.img_testback /* 2131363712 */:
                onBackPressed();
                break;
        }
    }

    private void challeneg_dialog() {
        final Dialog dialog = new Dialog(this, R.style.CustomAlertDialog);
        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.challenge_dialog);
        dialog.getWindow().setSoftInputMode(16);
        getWindow().setSoftInputMode(3);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        final EditText editText = (EditText) dialog.findViewById(R.id.edit_query);
        this.txt_tapAddNote7 = (TextView) dialog.findViewById(R.id.txt_tapAddNote);
        this.layout_fileAttach7 = (LinearLayout) dialog.findViewById(R.id.layout_fileAttach);
        this.layout_fileDetail7 = (RelativeLayout) dialog.findViewById(R.id.layout_fileDetail);
        this.img_fileAttached = (ImageView) dialog.findViewById(R.id.img_fileAttached);
        this.txt_fileName7 = (TextView) dialog.findViewById(R.id.txt_fileName);
        this.txt_fileSize7 = (TextView) dialog.findViewById(R.id.txt_fileSize);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.img_crossFile);
        Button button = (Button) dialog.findViewById(R.id.btn_submit);
        ImageView imageView2 = (ImageView) dialog.findViewById(R.id.txt_resume);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.ViewSolutionActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewSolutionActivity.this.selectedFilePath = "";
                ViewSolutionActivity.this.str_qtype = "";
                ViewSolutionActivity.this.txt_tapAddNote7.setVisibility(0);
                ViewSolutionActivity.this.layout_fileAttach7.setVisibility(0);
                ViewSolutionActivity.this.layout_fileDetail7.setVisibility(8);
                ViewSolutionActivity.this.txt_fileSize7.setText("");
                ViewSolutionActivity.this.txt_fileName7.setText("");
            }
        });
        this.layout_fileAttach7.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.ViewSolutionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    Uri uriForFile = FileProvider.getUriForFile(ViewSolutionActivity.this, "androidx.multidex.provider", new File(ViewSolutionActivity.this.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "temp_gallery.jpg"));
                    ViewSolutionActivity.this.str_qtype = "type7";
                    intent.putExtra("output", uriForFile);
                    ViewSolutionActivity.this.someActivityResultLauncher.launch(intent);
                    ViewSolutionActivity.this.requestCode = 1;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.ViewSolutionActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    if (TextUtils.isEmpty(editText.getText().toString().trim())) {
                        ViewSolutionActivity viewSolutionActivity = ViewSolutionActivity.this;
                        Toast.makeText(viewSolutionActivity, viewSolutionActivity.getResources().getString(R.string.please_enter_query), 0).show();
                        editText.requestFocus();
                        return;
                    }
                    String string = editText.getText().toString();
                    if (Helper.isNetworkConnected(ViewSolutionActivity.this)) {
                        ViewSolutionActivity viewSolutionActivity2 = ViewSolutionActivity.this;
                        viewSolutionActivity2.uploadChallenge(dialog, viewSolutionActivity2.currentPage, string);
                    } else {
                        ViewSolutionActivity viewSolutionActivity3 = ViewSolutionActivity.this;
                        Toast.makeText(viewSolutionActivity3, viewSolutionActivity3.getResources().getString(R.string.no_internet_connection), 0).show();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.ViewSolutionActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dialog.dismiss();
                dialog.cancel();
            }
        });
        dialog.show();
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.appnew.android.testmodule.activity.ViewSolutionActivity.5
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                dialog.dismiss();
                dialog.cancel();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadChallenge(final Dialog dialog2, final int currentPage, String str_query) {
        if (Helper.isNetworkConnected(this)) {
            this.mProgress.show();
            APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setUser_id(SharedPreference.getInstance().getLoggedInUser().getId());
            encryptionData.setTest_id(this.test_segment_id);
            encryptionData.setCourse_id(SharedPreference.getInstance().getString("id"));
            encryptionData.setChallenge_text(str_query);
            encryptionData.setChallenge_image(this.file_url);
            encryptionData.setQuestion_id(this.resultTestSeries2.getData().getQuestions().get(currentPage).getConfigId());
            encryptionData.setType("1");
            aPIInterface.challenge_submission(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new Callback<String>() { // from class: com.appnew.android.testmodule.activity.ViewSolutionActivity.6
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x00f0 -> B:19:0x00f3). Please report as a decompilation issue!!! */
                @Override // retrofit2.Callback
                public void onResponse(Call<String> call, Response<String> response) {
                    String strBody;
                    ViewSolutionActivity.this.mProgress.dismiss();
                    if (response.body() != null) {
                        try {
                            strBody = AES.decrypt(response.body(), AES.generatekeyAPI(), AES.generateVectorAPI());
                        } catch (Exception unused) {
                            strBody = response.body();
                        }
                        try {
                            JSONObject jSONObject = new JSONObject(strBody);
                            MakeMyExam.setTime_server(Long.parseLong(jSONObject.optString("time")) * 1000);
                            Challenge_Report challenge_Report = (Challenge_Report) new Gson().fromJson(jSONObject.toString(), Challenge_Report.class);
                            if (jSONObject.optString("status").equalsIgnoreCase("true")) {
                                ViewSolutionActivity.this.mProgress.dismiss();
                                dialog2.dismiss();
                                dialog2.cancel();
                                ViewSolutionActivity.this.resultTestSeries2.getData().getQuestion_dump().get(currentPage).setIs_challenge(challenge_Report.getData().get(currentPage).getIs_challenge());
                                Toast.makeText(ViewSolutionActivity.this, challenge_Report.getMessage(), 0).show();
                                ViewSolutionActivity.this.challenges_txt.setText(ViewSolutionActivity.this.getResources().getString(R.string.challenge_done));
                                ViewSolutionActivity.this.challenges_txt.setCompoundDrawablesWithIntrinsicBounds(R.drawable.challenge_done, 0, 0, 0);
                                ViewSolutionActivity.this.challenges_txt.setClickable(false);
                            } else if (ViewSolutionActivity.this.resultTestSeries2.getMessage().equalsIgnoreCase(ViewSolutionActivity.this.getResources().getString(R.string.internet_error_message))) {
                                ViewSolutionActivity.this.resultTestSeries2.getMessage().contains("Something went wrong");
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<String> call, Throwable t) {
                    ViewSolutionActivity.this.mProgress.dismiss();
                }
            });
            return;
        }
        Toast.makeText(this, getResources().getString(R.string.Retry_with_Internet_connection), 1).show();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void changeTextOnNextAndPrevButton() {
        ResultTestSeries_Report resultTestSeries_Report = this.resultTestSeries2;
        if (resultTestSeries_Report != null) {
            if (this.currentPage == resultTestSeries_Report.getData().getQuestions().size() - 1) {
                ((TextView) this.btnNext.getChildAt(0)).setTextColor(getResources().getColor(R.color.white));
                this.btnNext.setBackground(getResources().getDrawable(R.drawable.background_bg_prev));
                this.btnNext.setEnabled(false);
            } else {
                ((TextView) this.btnNext.getChildAt(0)).setTextColor(getResources().getColor(R.color.whiteApp));
                this.btnNext.setBackground(getResources().getDrawable(R.drawable.background_bg_next));
                this.btnNext.setEnabled(true);
            }
            String str = this.frag_type;
            if (str != null && str.equalsIgnoreCase(Const.SOLUTIONREPORT) && this.resultTestSeries2.getData().getQuestion_dump() != null) {
                if (this.resultTestSeries2.getData().getQuestion_dump().get(this.currentPage).getIs_challenge() == 1) {
                    this.challenges_txt.setClickable(false);
                    this.challenges_txt.setText(getResources().getString(R.string.challenge_done));
                    this.challenges_txt.setCompoundDrawablesWithIntrinsicBounds(R.drawable.challenge_done, 0, 0, 0);
                } else {
                    this.challenges_txt.setText(getResources().getString(R.string.challenge));
                    this.challenges_txt.setClickable(true);
                    this.challenges_txt.setCompoundDrawablesWithIntrinsicBounds(R.drawable.challenge, 0, 0, 0);
                }
            }
            if (SharedPreference.getInstance().getString(Const.BOOK_MARK) != null && !TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.BOOK_MARK)) && SharedPreference.getInstance().getString(Const.BOOK_MARK).equalsIgnoreCase("1")) {
                setBookMark();
            } else {
                this.bookmark_icon_select.setVisibility(8);
                this.bookmark_icon_deselect.setVisibility(8);
            }
            if (this.currentPage == 0) {
                ((TextView) this.btnPrev.getChildAt(0)).setTextColor(getResources().getColor(R.color.white));
                this.btnPrev.setBackground(getResources().getDrawable(R.drawable.background_bg_prev));
                this.btnPrev.setEnabled(false);
            } else {
                ((TextView) this.btnPrev.getChildAt(0)).setTextColor(getResources().getColor(R.color.whiteApp));
                this.btnPrev.setBackground(getResources().getDrawable(R.drawable.background_bg_next));
                this.btnPrev.setEnabled(true);
            }
        }
    }

    private void setBookMark() {
        String str = this.type;
        if (str != null && str.equalsIgnoreCase("learn")) {
            this.bookmark_icon_select.setVisibility(8);
            this.bookmark_icon_deselect.setVisibility(8);
        } else if (this.resultTestSeries2.getData().getQuestions().get(this.currentPage).getIs_bookmarked().equalsIgnoreCase("1")) {
            this.bookmark_icon_select.setVisibility(0);
            this.bookmark_icon_deselect.setVisibility(8);
        } else {
            this.bookmark_icon_select.setVisibility(8);
            this.bookmark_icon_deselect.setVisibility(0);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) throws Throwable {
        Exception exc;
        String fullPathFromContentUri;
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1 && requestCode == 1 && data != null) {
            try {
                this.selectedFilePath = "";
                fullPathFromContentUri = getFullPathFromContentUri(this, data.getData());
                this.selectedFilePath = fullPathFromContentUri;
            } catch (Exception e2) {
                e = e2;
            }
            try {
                if (fullPathFromContentUri == null || fullPathFromContentUri.equals("")) {
                    if (this.str_qtype.equalsIgnoreCase("type7")) {
                        this.txt_tapAddNote7.setVisibility(0);
                        this.layout_fileAttach7.setVisibility(0);
                        this.layout_fileDetail7.setVisibility(8);
                        this.txt_fileSize7.setText("");
                        this.txt_fileName7.setText("");
                        return;
                    }
                    return;
                }
                if (this.str_qtype.equalsIgnoreCase("type7")) {
                    if (!this.selectedFilePath.contains(".png")) {
                        try {
                            if (!this.selectedFilePath.contains(".jpeg") && !this.selectedFilePath.contains(".jpg")) {
                                Toast.makeText(this, getResources().getString(R.string.please_attach_only_image), 0).show();
                                return;
                            }
                        } catch (Exception e3) {
                            exc = e3;
                        }
                    }
                    this.txt_tapAddNote7.setVisibility(8);
                    this.layout_fileAttach7.setVisibility(8);
                    this.layout_fileDetail7.setVisibility(0);
                    TextView textView = this.txt_fileName7;
                    String str = this.selectedFilePath;
                    textView.setText(str.substring(str.lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1));
                    MediaFile mediaFile = new MediaFile();
                    ArrayList arrayList = new ArrayList();
                    if (this.selectedFilePath.contains(".png") || this.selectedFilePath.contains(".jpeg") || this.selectedFilePath.contains(".jpg")) {
                        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(this.selectedFilePath);
                        mediaFile.setFile_type("image");
                        mediaFile.setImage(bitmapDecodeFile);
                        this.img_fileAttached.setImageResource(R.drawable.challenge_image_icon);
                        mediaFile.setFile_name(this.txt_fileName7.getText().toString());
                        this.s3IU = new s3ImageUploading("", "vc-10000386-38616500102/EDUTERIA_profile_images", this, this, null);
                        arrayList.add(mediaFile);
                        this.s3IU.execute(arrayList);
                        return;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                exc = e;
            }
            exc = e;
            Log.d("TAGViewSolutionActivity", "error: " + exc.getMessage());
        }
    }

    @Override // com.appnew.android.Utils.AmazonUpload.AmazonCallBack
    public void onS3UploadData(ArrayList<MediaFile> images) {
        if (images != null && images.size() > 0) {
            this.file_url = images.get(0).getFile();
            return;
        }
        if (this.str_qtype.equalsIgnoreCase("type7")) {
            this.txt_tapAddNote7.setVisibility(0);
            this.layout_fileAttach7.setVisibility(0);
            this.layout_fileDetail7.setVisibility(8);
            this.txt_fileSize7.setText("");
            this.txt_fileName7.setText("");
        }
    }

    public static String getFullPathFromContentUri(final Context context, final Uri uri) throws Throwable {
        Throwable th;
        Cursor cursor = null;
        if (DocumentsContract.isDocumentUri(context, uri)) {
            if ("com.android.externalstorage.documents".equals(uri.getAuthority())) {
                String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                    return Environment.getExternalStorageDirectory() + MqttTopic.TOPIC_LEVEL_SEPARATOR + strArrSplit[1];
                }
            } else {
                if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                    return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                }
                if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                    String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(":");
                    String str = strArrSplit2[0];
                    if ("image".equals(str)) {
                        Uri uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str)) {
                        Uri uri3 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str)) {
                        Uri uri4 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    try {
                        Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, "_id=?", new String[]{strArrSplit2[1]}, null);
                        if (cursorQuery != null) {
                            try {
                                if (cursorQuery.moveToFirst()) {
                                    String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                                    if (cursorQuery != null) {
                                        cursorQuery.close();
                                    }
                                    return string;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                cursor = cursorQuery;
                                if (cursor != null) {
                                    cursor.close();
                                    throw th;
                                }
                                throw th;
                            }
                        }
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
            }
        } else {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                return getDataColumn(context, uri, null, null);
            }
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }

    private static String getDataColumn(Context context, Uri uri, String selection, String[] selectionArgs) throws Throwable {
        Throwable th;
        Cursor cursor = null;
        try {
            Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, selection, selectionArgs, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return string;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                        throw th;
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3(ActivityResult activityResult) throws Throwable {
        Exception exc;
        try {
        } catch (Exception e2) {
            e = e2;
        }
        if (activityResult.getResultCode() == -1 && this.requestCode == 1 && activityResult.getData() != null) {
            this.selectedFilePath = "";
            String fullPathFromContentUri = getFullPathFromContentUri(this, activityResult.getData().getData());
            this.selectedFilePath = fullPathFromContentUri;
            try {
                if (fullPathFromContentUri == null || fullPathFromContentUri.equals("")) {
                    if (this.str_qtype.equalsIgnoreCase("type7")) {
                        this.txt_tapAddNote7.setVisibility(0);
                        this.layout_fileAttach7.setVisibility(0);
                        this.layout_fileDetail7.setVisibility(8);
                        this.txt_fileSize7.setText("");
                        this.txt_fileName7.setText("");
                        return;
                    }
                    return;
                }
                if (this.str_qtype.equalsIgnoreCase("type7")) {
                    if (!this.selectedFilePath.contains(".png")) {
                        try {
                            if (!this.selectedFilePath.contains(".jpeg") && !this.selectedFilePath.contains(".jpg")) {
                                Toast.makeText(this, "Please attach only Image ", 0).show();
                                return;
                            }
                        } catch (Exception e3) {
                            exc = e3;
                        }
                    }
                    this.txt_tapAddNote7.setVisibility(8);
                    this.layout_fileAttach7.setVisibility(8);
                    this.layout_fileDetail7.setVisibility(0);
                    TextView textView = this.txt_fileName7;
                    String str = this.selectedFilePath;
                    textView.setText(str.substring(str.lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1));
                    MediaFile mediaFile = new MediaFile();
                    ArrayList arrayList = new ArrayList();
                    if (this.selectedFilePath.contains(".png") || this.selectedFilePath.contains(".jpeg") || this.selectedFilePath.contains(".jpg")) {
                        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(this.selectedFilePath);
                        mediaFile.setFile_type("image");
                        mediaFile.setImage(bitmapDecodeFile);
                        this.img_fileAttached.setImageResource(R.drawable.challenge_image_icon);
                        mediaFile.setFile_name(this.txt_fileName7.getText().toString());
                        this.s3IU = new s3ImageUploading("", "vc-10000386-38616500102/EDUTERIA_profile_images", this, this, null);
                        arrayList.add(mediaFile);
                        this.s3IU.execute(arrayList);
                        return;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                exc = e;
            }
            exc = e;
            Log.d("TAGViewSolutionActivity", "error: " + exc.getMessage());
        }
    }

    public void showPopupErrorTest(final List<QuesReportOption> questionReportOptions) {
        final View viewInflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.dialog_report_error, (ViewGroup) null, false);
        final Dialog dialog = new Dialog(this, R.style.CustomAlertDialog);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(viewInflate);
        dialog.show();
        final RadioGroup radioGroup = (RadioGroup) viewInflate.findViewById(R.id.radioError);
        final EditText editText = (EditText) viewInflate.findViewById(R.id.feedbackTV);
        Button button = (Button) viewInflate.findViewById(R.id.btn_submit);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_close);
        for (QuesReportOption quesReportOption : questionReportOptions) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(quesReportOption.getTitle());
            radioGroup.addView(radioButton);
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.ViewSolutionActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Dialog dialog2 = dialog;
                if (dialog2 != null) {
                    dialog2.dismiss();
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.ViewSolutionActivity.8
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
                    if (ViewSolutionActivity.this.resultTestSeries2 != null && ViewSolutionActivity.this.resultTestSeries2.getData() != null && ViewSolutionActivity.this.resultTestSeries2.getData().getQuestions() != null && ViewSolutionActivity.this.resultTestSeries2.getData().getQuestions().get(ViewSolutionActivity.this.currentPage) != null) {
                        if (!Helper.isNullChek(editText.getText().toString().trim())) {
                            editText.setError(ViewSolutionActivity.this.getResources().getString(R.string.feedback_field_is_required));
                            editText.requestFocus();
                            return;
                        } else {
                            ViewSolutionActivity viewSolutionActivity = ViewSolutionActivity.this;
                            viewSolutionActivity.networkcallForSubmitQuery(quesReportOption2, viewSolutionActivity.resultTestSeries2.getData().getQuestions().get(ViewSolutionActivity.this.currentPage), editText.getText().toString().trim(), dialog);
                            return;
                        }
                    }
                    ViewSolutionActivity viewSolutionActivity2 = ViewSolutionActivity.this;
                    Toast.makeText(viewSolutionActivity2, viewSolutionActivity2.getResources().getString(R.string.please_add_question), 0).show();
                    return;
                }
                ViewSolutionActivity viewSolutionActivity3 = ViewSolutionActivity.this;
                Toast.makeText(viewSolutionActivity3, viewSolutionActivity3.getResources().getString(R.string.please_select_category), 0).show();
            }
        });
    }

    public void networkcallForSubmitQuery(QuesReportOption error, Questions2 question, String feedbackMsg, final Dialog quizBasicInfoDialog) {
        if (Helper.isNetworkConnected(this)) {
            this.mProgress.show();
            APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setOption_id(error.getId());
            encryptionData.setQuestion_id(question.getId());
            encryptionData.setQuestion_config_id(question.getConfigId());
            encryptionData.setQuestion_lang_id(String.valueOf(this.lang));
            encryptionData.setTest_id(this.testseriesBase.getData().getTestBasic().getId());
            encryptionData.setReport_feedback_msg(feedbackMsg);
            aPIInterface.getresponseofsubmitquery(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new Callback<String>() { // from class: com.appnew.android.testmodule.activity.ViewSolutionActivity.9
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0082 -> B:16:0x0085). Please report as a decompilation issue!!! */
                @Override // retrofit2.Callback
                public void onResponse(Call<String> call, Response<String> response) {
                    String strBody;
                    ViewSolutionActivity.this.mProgress.dismiss();
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
                                Toast.makeText(ViewSolutionActivity.this, jSONObject.optString("message"), 0).show();
                            } else {
                                quizBasicInfoDialog.dismiss();
                                Toast.makeText(ViewSolutionActivity.this, jSONObject.optString("message"), 0).show();
                                RetrofitResponse.GetApiData(ViewSolutionActivity.this, jSONObject.optString("auth_code"), jSONObject.optString("message"), false);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<String> call, Throwable t) {
                    ViewSolutionActivity.this.mProgress.dismiss();
                    ViewSolutionActivity viewSolutionActivity = ViewSolutionActivity.this;
                    Toast.makeText(viewSolutionActivity, viewSolutionActivity.getResources().getString(R.string.something_went_wrong), 0).show();
                    quizBasicInfoDialog.dismiss();
                }
            });
            return;
        }
        Toast.makeText(this, getResources().getString(R.string.Retry_with_Internet_connection), 1).show();
    }
}
