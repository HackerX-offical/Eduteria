package com.appnew.android.testmodule.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ahmadnemati.clickablewebview.ClickableWebView;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.MainFragment;
import com.appnew.android.Utils.Progress;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.player.CustommediaPlayerDialog;
import com.appnew.android.testmodule.activity.ViewSolutionActivity;
import com.appnew.android.testmodule.mathview.MathView;
import com.appnew.android.testmodule.model.Data;
import com.appnew.android.testmodule.model.FIBEdit;
import com.appnew.android.testmodule.model.QuestionDumps;
import com.appnew.android.testmodule.model.Questions2;
import com.appnew.android.testmodule.model.ResultTestSeries_Report;
import com.appnew.android.testmodule.model.TestseriesBase;
import com.clevertap.android.sdk.variables.CTVariableUtils;
import com.eduteria.app.app.R;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class ViewSolutionFragment extends MainFragment implements Html.ImageGetter {
    private static final String TAG = "ViewSolutionFragment";
    LinearLayout LLmatchinquestion;
    List<View> LinearLayoutList;
    private Drawable empty;
    private Drawable empty2;
    LinearLayout explanationLL;
    ClickableWebView explanationTV;
    Progress mProgress;
    TextView max_marks;
    LinearLayout mcqoptionsLL;
    TextView min_marks;
    NestedScrollView nestedSV;
    TextView onscreen_value;
    LinearLayout parentLL;
    List<View> parentList;
    int position;
    QuestionDumps questionDump;
    String questionType;
    TextView question_status;
    RelativeLayout questionsol_layout1;
    Questions2 result;
    RecyclerView rvmatchinquestion1;
    RecyclerView rvmatchinquestion2;
    int selectedAnswerposition;
    private boolean status;
    List<View> tvList;
    private ClickableWebView tvQuestion;
    private ClickableWebView tvQuestionFib;
    TextView tvReportError;
    TextView tv_uid;
    TextView userEmailTV;
    TextView videosolution;
    ResultTestSeries_Report viewSolutionData;
    TextView your_ans_text;
    int count = 0;
    ArrayList<WebView> textViews = new ArrayList<>();

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

    public static ViewSolutionFragment newInstance(int position, ResultTestSeries_Report viewSolutionData, String questionType) {
        Bundle bundle = new Bundle();
        bundle.putInt(Const.POSITION, position);
        bundle.putString("questionType", questionType);
        ViewSolutionFragment viewSolutionFragment = new ViewSolutionFragment();
        viewSolutionFragment.setArguments(bundle);
        return viewSolutionFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewInflate = inflater.inflate(R.layout.fragment_view_solution, (ViewGroup) null);
        this.activity = getActivity();
        this.viewSolutionData = (ResultTestSeries_Report) new Gson().fromJson(SharedPreference.getInstance().getString("myResultTestSeries2"), ResultTestSeries_Report.class);
        getBundleData();
        initView(viewInflate);
        this.mProgress = new Progress(this.activity);
        return viewInflate;
    }

    private void getBundleData() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            int i = arguments.getInt(Const.POSITION, 0);
            this.position = i;
            if (i >= this.viewSolutionData.getData().getQuestion_dump().size()) {
                this.position = this.viewSolutionData.getData().getQuestion_dump().size() - 1;
            }
            this.questionDump = this.viewSolutionData.getData().getQuestion_dump().get(this.position);
            this.questionType = arguments.getString("questionType", "");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    private void initView(View view) {
        this.mcqoptionsLL = (LinearLayout) view.findViewById(R.id.mcqoptions);
        this.videosolution = (TextView) view.findViewById(R.id.videosolution);
        this.tvQuestion = (ClickableWebView) view.findViewById(R.id.tv_question);
        this.tvQuestionFib = (ClickableWebView) view.findViewById(R.id.tv_question_fib);
        this.questionsol_layout1 = (RelativeLayout) view.findViewById(R.id.questionsol_layout1);
        this.LLmatchinquestion = (LinearLayout) view.findViewById(R.id.LLmatchinquestion);
        this.rvmatchinquestion1 = (RecyclerView) view.findViewById(R.id.rvmatchinquestion1);
        this.rvmatchinquestion2 = (RecyclerView) view.findViewById(R.id.rvmatchinquestion2);
        this.rvmatchinquestion1.setLayoutManager(new LinearLayoutManager(this.activity));
        this.rvmatchinquestion2.setLayoutManager(new LinearLayoutManager(this.activity));
        this.rvmatchinquestion2.setHasFixedSize(true);
        this.explanationLL = (LinearLayout) view.findViewById(R.id.explanationLL);
        this.explanationTV = (ClickableWebView) view.findViewById(R.id.explanationTV);
        this.tv_uid = (TextView) view.findViewById(R.id.tv_uid);
        this.your_ans_text = (TextView) view.findViewById(R.id.your_ans);
        this.max_marks = (TextView) view.findViewById(R.id.maxmarks);
        this.min_marks = (TextView) view.findViewById(R.id.minmarks);
        this.onscreen_value = (TextView) view.findViewById(R.id.onscreen_value);
        this.question_status = (TextView) view.findViewById(R.id.question_status);
        this.nestedSV = (NestedScrollView) view.findViewById(R.id.nestedSV);
        this.userEmailTV = (TextView) view.findViewById(R.id.userEmailTV);
        this.tvReportError = (TextView) view.findViewById(R.id.tv_report_error);
        this.LinearLayoutList = new ArrayList();
        this.parentList = new ArrayList();
        this.tvList = new ArrayList();
        this.result = this.viewSolutionData.getData().getQuestions().get(this.position);
        setExplanationView();
        if (Helper.isStringValid(this.result.getSolution_url())) {
            this.videosolution.setVisibility(0);
        } else {
            this.videosolution.setVisibility(8);
        }
        this.videosolution.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.testmodule.fragment.ViewSolutionFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$initView$0();
            }
        }));
        displayQuestion();
        displaySolution();
        reportQuestion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$initView$0() {
        Intent intent = new Intent(this.activity, (Class<?>) CustommediaPlayerDialog.class);
        intent.putExtra("videoUrl", this.result.getSolution_url());
        intent.putExtra("id", this.result.getId());
        intent.setFlags(268435456);
        this.activity.startActivity(intent);
        return null;
    }

    private void displayQuestion() {
        String str = this.questionType;
        str.hashCode();
        switch (str) {
            case "MT":
                this.mcqoptionsLL.setVisibility(8);
                this.LLmatchinquestion.setVisibility(0);
                String question = this.viewSolutionData.getData().getQuestions().get(this.position).getQuestion();
                this.tvQuestion.requestFocus();
                this.tvQuestion.getSettings().setLightTouchEnabled(true);
                this.tvQuestion.setBackgroundColor(0);
                this.tvQuestion.getSettings().setJavaScriptEnabled(true);
                this.tvQuestion.getSettings().setGeolocationEnabled(true);
                if (this.viewSolutionData.getData().getQuestions().get(this.position).getFont_type().equalsIgnoreCase("1") || this.viewSolutionData.getData().getQuestions().get(this.position).getFont_type().equalsIgnoreCase("2")) {
                    Helper.testQuestionFont(this.tvQuestion, this.position, question, this.viewSolutionData.getData().getQuestions().get(this.position).getFont_type());
                } else {
                    Helper.TestWebHTMLLoad(this.tvQuestion, Helper.getHTMLWidthForImage("<p style='font-family:sans-serif !important; font-size:16px; margin:0;'>Q-" + (this.position + 1) + ".</p>" + question));
                }
                this.tvQuestion.setLongClickable(false);
                this.tvQuestion.setOnLongClickListener(new WebViewClickListener(this.tvQuestion, this.questionsol_layout1));
                break;
            case "PG":
                ResultTestSeries_Report resultTestSeries_Report = this.viewSolutionData;
                if (resultTestSeries_Report != null) {
                    if (TextUtils.isEmpty(resultTestSeries_Report.getData().getQuestions().get(this.position).getParagraphText())) {
                        this.tvQuestionFib.setVisibility(8);
                    } else {
                        this.tvQuestionFib.setVisibility(0);
                        String strTrim = this.viewSolutionData.getData().getQuestions().get(this.position).getParagraphText().trim();
                        if (this.viewSolutionData.getData().getQuestions().get(this.position).getFont_type().equalsIgnoreCase("1") || this.viewSolutionData.getData().getQuestions().get(this.position).getFont_type().equalsIgnoreCase("2")) {
                            Helper.testQuestionFont(this.tvQuestionFib, this.position, strTrim, this.viewSolutionData.getData().getQuestions().get(this.position).getFont_type());
                        } else {
                            Helper.TestWebHTMLLoad(this.tvQuestionFib, strTrim);
                        }
                    }
                }
                this.mcqoptionsLL.setVisibility(0);
                this.LLmatchinquestion.setVisibility(8);
                String question2 = this.viewSolutionData.getData().getQuestions().get(this.position).getQuestion();
                this.tvQuestion.setBackgroundColor(0);
                this.tvQuestion.setLayerType(2, null);
                this.tvQuestion.getSettings().setJavaScriptEnabled(true);
                this.tvQuestion.getSettings().setGeolocationEnabled(true);
                if (this.viewSolutionData.getData().getQuestions().get(this.position).getFont_type().equalsIgnoreCase("1") || this.viewSolutionData.getData().getQuestions().get(this.position).getFont_type().equalsIgnoreCase("2")) {
                    Helper.testQuestionFont(this.tvQuestion, this.position, question2, this.viewSolutionData.getData().getQuestions().get(this.position).getFont_type());
                } else {
                    Helper.TestWebHTMLLoad(this.tvQuestion, Helper.getHTMLWidthForImage("<p style='font-family:sans-serif !important; font-size:16px; margin:0;'>Q-" + (this.position + 1) + ".</p>" + question2));
                }
                this.tvQuestion.setLongClickable(false);
                this.tvQuestion.setOnLongClickListener(new WebViewClickListener(this.tvQuestion, this.questionsol_layout1));
                addSolutionOption();
                break;
            case "FIB":
                String strReplace = this.viewSolutionData.getData().getQuestions().get(this.position).getQuestion().replace("FIB", ".....");
                this.tvQuestion.requestFocus();
                this.tvQuestion.getSettings().setLightTouchEnabled(true);
                this.tvQuestion.setBackgroundColor(0);
                this.tvQuestion.setLayerType(2, null);
                this.tvQuestion.getSettings().setJavaScriptEnabled(true);
                this.tvQuestion.getSettings().setGeolocationEnabled(true);
                if (this.viewSolutionData.getData().getQuestions().get(this.position).getFont_type().equalsIgnoreCase("1") || this.viewSolutionData.getData().getQuestions().get(this.position).getFont_type().equalsIgnoreCase("2")) {
                    Helper.testQuestionFont(this.tvQuestion, this.position, strReplace, this.viewSolutionData.getData().getQuestions().get(this.position).getFont_type());
                } else {
                    Helper.TestWebHTMLLoad(this.tvQuestion, Helper.getHTMLWidthForImage("<p style='font-family:sans-serif !important; font-size:16px; margin:0;'>Q-" + (this.position + 1) + ".</p>" + strReplace));
                }
                this.tvQuestion.setLongClickable(false);
                this.tvQuestion.setOnLongClickListener(new WebViewClickListener(this.tvQuestion, this.questionsol_layout1));
                addQuestionOptionForFIB();
                break;
            default:
                this.mcqoptionsLL.setVisibility(0);
                this.LLmatchinquestion.setVisibility(8);
                String question3 = this.viewSolutionData.getData().getQuestions().get(this.position).getQuestion();
                this.tvQuestion.setBackgroundColor(0);
                this.tvQuestion.setLayerType(2, null);
                this.tvQuestion.getSettings().setJavaScriptEnabled(true);
                this.tvQuestion.getSettings().setGeolocationEnabled(true);
                if (this.viewSolutionData.getData().getQuestions().get(this.position).getFont_type().equalsIgnoreCase("1") || this.viewSolutionData.getData().getQuestions().get(this.position).getFont_type().equalsIgnoreCase("2")) {
                    Helper.testQuestionFont(this.tvQuestion, this.position, question3, this.viewSolutionData.getData().getQuestions().get(this.position).getFont_type());
                } else {
                    Helper.TestWebHTMLLoad(this.tvQuestion, Helper.getHTMLWidthForImage("<p style='font-family:sans-serif !important; font-size:16px; margin:0;'>Q-" + (this.position + 1) + ".</p>" + question3));
                }
                this.tvQuestion.setLongClickable(false);
                this.tvQuestion.setOnLongClickListener(new WebViewClickListener(this.tvQuestion, this.questionsol_layout1));
                addSolutionOption();
                break;
        }
    }

    private void setExplanationView() {
        if (!this.result.getDescription().isEmpty()) {
            String description = this.result.getDescription();
            this.explanationLL.setVisibility(0);
            this.explanationTV.setBackgroundColor(0);
            this.tvQuestion.setLayerType(2, null);
            this.tvQuestion.getSettings().setJavaScriptEnabled(true);
            this.explanationTV.getSettings().setJavaScriptEnabled(true);
            if (this.viewSolutionData.getData().getQuestions().get(this.position).getFont_type().equalsIgnoreCase("1") || this.viewSolutionData.getData().getQuestions().get(this.position).getFont_type().equalsIgnoreCase("2")) {
                Helper.testQuestionFont(this.explanationTV, this.position, description, this.viewSolutionData.getData().getQuestions().get(this.position).getFont_type());
            } else {
                Helper.TestWebHTMLLoad(this.explanationTV, description);
            }
            this.explanationTV.setLongClickable(false);
            this.explanationTV.setOnLongClickListener(new WebViewClickListener_option(this.explanationTV, this.explanationLL));
            return;
        }
        this.explanationLL.setVisibility(8);
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

    private void addQuestionOptionForFIB() {
        ArrayList<WebView> arrayList = this.textViews;
        if (arrayList != null) {
            arrayList.clear();
        }
        for (int i = 1; i <= countFIBWords(this.result.getQuestion().trim()) && !this.status; i++) {
            switch (i) {
                case 1:
                    if (this.result.getOption1().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("1", this.result.getOption1(), this.result.getFont_type(), false, i - 1));
                    }
                    break;
                case 2:
                    if (this.result.getOption2().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("2", this.result.getOption2(), this.result.getFont_type(), false, i - 1));
                    }
                    break;
                case 3:
                    if (this.result.getOption3().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("3", this.result.getOption3(), this.result.getFont_type(), false, i - 1));
                    }
                    break;
                case 4:
                    if (this.result.getOption4().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("4", this.result.getOption4(), this.result.getFont_type(), false, i - 1));
                    }
                    break;
                case 5:
                    if (this.result.getOption5().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("5", this.result.getOption5(), this.result.getFont_type(), false, i - 1));
                    }
                    break;
                case 6:
                    if (this.result.getOption6() == null || this.result.getOption6().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("6", this.result.getOption6(), this.result.getFont_type(), false, i - 1));
                    }
                    break;
                case 7:
                    if (this.result.getOption7() == null || this.result.getOption7().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("7", this.result.getOption7(), this.result.getFont_type(), false, i - 1));
                    }
                    break;
                case 8:
                    if (this.result.getOption8() == null || this.result.getOption8().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("8", this.result.getOption8(), this.result.getFont_type(), false, i - 1));
                    }
                    break;
                case 9:
                    if (this.result.getOption9() == null || this.result.getOption9().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("9", this.result.getOption9(), this.result.getFont_type(), false, i - 1));
                    }
                    break;
                case 10:
                    if (this.result.getOption10() == null || this.result.getOption10().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("10", this.result.getOption10(), this.result.getFont_type(), false, i - 1));
                    }
                    break;
            }
        }
        this.status = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:259:0x0b01 A[PHI: r7
      0x0b01: PHI (r7v24 java.lang.String) = 
      (r7v6 java.lang.String)
      (r7v6 java.lang.String)
      (r7v7 java.lang.String)
      (r7v7 java.lang.String)
      (r7v9 java.lang.String)
      (r7v9 java.lang.String)
      (r7v11 java.lang.String)
      (r7v11 java.lang.String)
      (r7v13 java.lang.String)
      (r7v13 java.lang.String)
      (r7v15 java.lang.String)
      (r7v15 java.lang.String)
      (r7v17 java.lang.String)
      (r7v17 java.lang.String)
      (r7v19 java.lang.String)
      (r7v19 java.lang.String)
      (r7v21 java.lang.String)
      (r7v21 java.lang.String)
      (r7v23 java.lang.String)
      (r7v23 java.lang.String)
      (r7v28 java.lang.String)
      (r7v28 java.lang.String)
     binds: [B:258:0x0ac8, B:251:0x0aab, B:244:0x0a2c, B:237:0x0a0d, B:230:0x098d, B:223:0x096e, B:216:0x08ec, B:209:0x08cd, B:202:0x084b, B:195:0x082c, B:188:0x07aa, B:181:0x078b, B:174:0x0709, B:167:0x06ea, B:160:0x0668, B:153:0x0649, B:146:0x05c7, B:139:0x05a8, B:132:0x0526, B:125:0x0507, B:118:0x0485, B:111:0x0466] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0b11 A[PHI: r7
      0x0b11: PHI (r7v25 java.lang.String) = 
      (r7v6 java.lang.String)
      (r7v6 java.lang.String)
      (r7v7 java.lang.String)
      (r7v7 java.lang.String)
      (r7v9 java.lang.String)
      (r7v9 java.lang.String)
      (r7v11 java.lang.String)
      (r7v11 java.lang.String)
      (r7v13 java.lang.String)
      (r7v13 java.lang.String)
      (r7v15 java.lang.String)
      (r7v15 java.lang.String)
      (r7v17 java.lang.String)
      (r7v17 java.lang.String)
      (r7v19 java.lang.String)
      (r7v19 java.lang.String)
      (r7v21 java.lang.String)
      (r7v21 java.lang.String)
      (r7v23 java.lang.String)
      (r7v23 java.lang.String)
      (r7v28 java.lang.String)
      (r7v28 java.lang.String)
     binds: [B:261:0x0b0f, B:254:0x0ab9, B:246:0x0a72, B:240:0x0a1c, B:232:0x09d3, B:226:0x097d, B:218:0x0932, B:212:0x08dc, B:204:0x0891, B:198:0x083b, B:190:0x07f0, B:184:0x079a, B:176:0x074f, B:170:0x06f9, B:162:0x06ae, B:156:0x0658, B:148:0x060d, B:142:0x05b7, B:134:0x056c, B:128:0x0516, B:120:0x04cb, B:114:0x0475] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:365:0x1030 A[PHI: r6
      0x1030: PHI (r6v16 java.lang.String) = 
      (r6v7 java.lang.String)
      (r6v8 java.lang.String)
      (r6v9 java.lang.String)
      (r6v10 java.lang.String)
      (r6v11 java.lang.String)
      (r6v12 java.lang.String)
      (r6v13 java.lang.String)
      (r6v14 java.lang.String)
      (r6v15 java.lang.String)
      (r6v19 java.lang.String)
     binds: [B:364:0x102e, B:357:0x0fd5, B:351:0x0f7e, B:345:0x0f26, B:339:0x0ece, B:333:0x0e76, B:327:0x0e1e, B:321:0x0dc6, B:315:0x0d6e, B:309:0x0d16] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:366:0x1034 A[PHI: r6
      0x1034: PHI (r6v17 java.lang.String) = 
      (r6v7 java.lang.String)
      (r6v8 java.lang.String)
      (r6v9 java.lang.String)
      (r6v10 java.lang.String)
      (r6v11 java.lang.String)
      (r6v12 java.lang.String)
      (r6v13 java.lang.String)
      (r6v14 java.lang.String)
      (r6v15 java.lang.String)
      (r6v19 java.lang.String)
     binds: [B:364:0x102e, B:357:0x0fd5, B:351:0x0f7e, B:345:0x0f26, B:339:0x0ece, B:333:0x0e76, B:327:0x0e1e, B:321:0x0dc6, B:315:0x0d6e, B:309:0x0d16] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:367:0x1035 A[PHI: r2 r9
      0x1035: PHI (r2v24 java.lang.String) = 
      (r2v23 java.lang.String)
      (r2v23 java.lang.String)
      (r2v108 java.lang.String)
      (r2v23 java.lang.String)
      (r2v109 java.lang.String)
     binds: [B:302:0x0cbb, B:303:0x0cbd, B:365:0x1030, B:366:0x1034, B:362:0x101f] A[DONT_GENERATE, DONT_INLINE]
      0x1035: PHI (r9v2 java.lang.String) = 
      (r9v1 java.lang.String)
      (r9v1 java.lang.String)
      (r9v6 java.lang.String)
      (r9v7 java.lang.String)
      (r9v8 java.lang.String)
     binds: [B:302:0x0cbb, B:303:0x0cbd, B:365:0x1030, B:366:0x1034, B:362:0x101f] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void displaySolution() {
        /*
            Method dump skipped, instruction units count: 4750
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.testmodule.fragment.ViewSolutionFragment.displaySolution():void");
    }

    private String getQuestionTime(String questionTime) {
        int i = Integer.parseInt(questionTime);
        int i2 = i / 60;
        int i3 = i % 60;
        return i2 == 0 ? i3 + " sec" : i2 + " min " + i3 + " sec";
    }

    private void setMaxAndMinMarks() {
        this.max_marks.setText(this.activity.getResources().getString(R.string.pos_marks) + this.result.getMarksPerQuestion());
        this.min_marks.setText(this.activity.getResources().getString(R.string.neg_marks) + this.result.getNegativeMarks());
    }

    @Override // android.text.Html.ImageGetter
    public Drawable getDrawable(String s) {
        LevelListDrawable levelListDrawable = new LevelListDrawable();
        Drawable drawable = getResources().getDrawable(R.mipmap.course_placeholder);
        this.empty = drawable;
        levelListDrawable.addLevel(0, 0, drawable);
        levelListDrawable.setBounds(0, 0, this.empty.getIntrinsicWidth(), this.empty.getIntrinsicHeight());
        new LoadImage().execute(s, levelListDrawable);
        return levelListDrawable;
    }

    private void addSolutionOption() {
        for (int i = 1; i <= 10 && !this.status; i++) {
            switch (i) {
                case 1:
                    if (this.result.getOption1().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("1", this.result.getOption1(), this.result.getFont_type(), false, i - 1));
                    }
                    break;
                case 2:
                    if (this.result.getOption2().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("2", this.result.getOption2(), this.result.getFont_type(), false, i - 1));
                    }
                    break;
                case 3:
                    if (this.result.getOption3().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("3", this.result.getOption3(), this.result.getFont_type(), false, i - 1));
                    }
                    break;
                case 4:
                    if (this.result.getOption4().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("4", this.result.getOption4(), this.result.getFont_type(), false, i - 1));
                    }
                    break;
                case 5:
                    if (this.result.getOption5().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("5", this.result.getOption5(), this.result.getFont_type(), false, i - 1));
                    }
                    break;
                case 6:
                    if (this.result.getOption6() == null || this.result.getOption6().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("6", this.result.getOption6(), this.result.getFont_type(), false, i - 1));
                    }
                    break;
                case 7:
                    if (this.result.getOption7() == null || this.result.getOption7().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("7", this.result.getOption7(), this.result.getFont_type(), false, i - 1));
                    }
                    break;
                case 8:
                    if (this.result.getOption8() == null || this.result.getOption8().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("8", this.result.getOption8(), this.result.getFont_type(), false, i - 1));
                    }
                    break;
                case 9:
                    if (this.result.getOption9() == null || this.result.getOption9().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("9", this.result.getOption9(), this.result.getFont_type(), false, i - 1));
                    }
                    break;
                case 10:
                    if (this.result.getOption10() == null || this.result.getOption10().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("10", this.result.getOption10(), this.result.getFont_type(), false, i - 1));
                    }
                    break;
            }
        }
        this.status = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public LinearLayout initMCQOptionView(String str, String str2, String str3, boolean z, int i) {
        LinearLayout linearLayout = (LinearLayout) View.inflate(this.activity, R.layout.layout_option_test_view_solution, null);
        TextView textView = (TextView) linearLayout.findViewById(R.id.optionIconTV);
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.viewLL);
        MathView mathView = (MathView) linearLayout.findViewById(R.id.optionTextTV);
        RadioButton radioButton = (RadioButton) linearLayout.findViewById(R.id.radioRB);
        this.parentLL = (LinearLayout) linearLayout.findViewById(R.id.viewLL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 10, 0, 0);
        if (z) {
            radioButton.setVisibility(8);
        }
        linearLayout.setLayoutParams(layoutParams);
        textView.setText(str);
        textView.setGravity(17);
        if (this.questionType.equalsIgnoreCase("FIB")) {
            FIBEdit fIBEdit = (FIBEdit) new Gson().fromJson(str2, FIBEdit.class);
            if (fIBEdit != null) {
                if (fIBEdit.getType().equalsIgnoreCase(CTVariableUtils.NUMBER)) {
                    mathView.getSettings().setJavaScriptEnabled(true);
                    Helper.TestWebHTMLLoad(mathView, "Min value " + fIBEdit.getMin() + " Max value " + fIBEdit.getMax());
                    linearLayout.setSelected(true);
                } else if (fIBEdit.getType().equalsIgnoreCase(FirebaseAnalytics.Param.CHARACTER)) {
                    mathView.getSettings().setJavaScriptEnabled(true);
                    Helper.TestWebHTMLLoad(mathView, "Min text length " + fIBEdit.getMin() + " Max text length " + fIBEdit.getMax());
                    linearLayout.setSelected(true);
                } else {
                    mathView.getSettings().setJavaScriptEnabled(true);
                    Helper.TestWebHTMLLoad(mathView, fIBEdit.getAnswer());
                    linearLayout.setSelected(true);
                }
            }
        } else {
            mathView.getSettings().setJavaScriptEnabled(true);
            if (str3.equalsIgnoreCase("1") || str3.equalsIgnoreCase("2")) {
                Helper.testOptionFont(mathView, str2, str3);
            } else {
                Helper.TestWebHTMLLoad(mathView, str2);
            }
        }
        mathView.setLongClickable(false);
        mathView.setOnLongClickListener(new WebViewClickListener_option(mathView, linearLayout2));
        linearLayout.setTag(Integer.valueOf(i));
        this.textViews.add(mathView);
        this.LinearLayoutList.add(linearLayout);
        this.parentList.add(this.parentLL);
        this.tvList.add(textView);
        return linearLayout;
    }

    class LoadImage extends AsyncTask<Object, Void, Bitmap> {
        private LevelListDrawable mDrawable;

        LoadImage() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public Bitmap doInBackground(Object... params) {
            String str = (String) params[0];
            this.mDrawable = (LevelListDrawable) params[1];
            try {
                return BitmapFactory.decodeStream(new URL(str).openStream());
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                return null;
            } catch (MalformedURLException e3) {
                e3.printStackTrace();
                return null;
            } catch (IOException e4) {
                e4.printStackTrace();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                this.mDrawable.addLevel(1, 1, new BitmapDrawable(bitmap));
                this.mDrawable.setBounds(0, 0, ViewSolutionFragment.this.empty.getIntrinsicWidth(), ViewSolutionFragment.this.empty.getIntrinsicHeight());
                this.mDrawable.setLevel(1);
            }
        }
    }

    class LoadImageExplain extends AsyncTask<Object, Void, Bitmap> {
        private LevelListDrawable mDrawable;

        LoadImageExplain() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public Bitmap doInBackground(Object... params) {
            String str = (String) params[0];
            this.mDrawable = (LevelListDrawable) params[1];
            try {
                return BitmapFactory.decodeStream(new URL(str).openStream());
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                return null;
            } catch (MalformedURLException e3) {
                e3.printStackTrace();
                return null;
            } catch (IOException e4) {
                e4.printStackTrace();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                this.mDrawable.addLevel(1, 1, new BitmapDrawable(bitmap));
                this.mDrawable.setBounds(0, 0, ViewSolutionFragment.this.empty2.getIntrinsicWidth(), ViewSolutionFragment.this.empty2.getIntrinsicHeight());
                this.mDrawable.setLevel(1);
            }
        }
    }

    private static class WebViewClickListener implements View.OnLongClickListener {
        RelativeLayout vgg;
        WebView web;

        WebViewClickListener(WebView option1_webview, RelativeLayout ll_option1) {
            this.web = option1_webview;
            this.vgg = ll_option1;
            option1_webview.setLongClickable(false);
            this.web.setHapticFeedbackEnabled(false);
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View v) {
            v.setLongClickable(false);
            v.setHapticFeedbackEnabled(false);
            return true;
        }
    }

    private static class WebViewClickListener_option implements View.OnLongClickListener {
        LinearLayout vgg;
        WebView web;

        WebViewClickListener_option(WebView option1_webview, LinearLayout ll_option1) {
            this.web = option1_webview;
            this.vgg = ll_option1;
            option1_webview.setLongClickable(false);
            this.web.setHapticFeedbackEnabled(false);
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View v) {
            v.setLongClickable(false);
            v.setHapticFeedbackEnabled(false);
            return true;
        }
    }

    private void reportQuestion() {
        if (Helper.isQuestionReportOption()) {
            FragmentActivity activity = getActivity();
            final List list = activity instanceof ViewSolutionActivity ? (List) Optional.ofNullable(((ViewSolutionActivity) activity).testseriesBase).map(new Function() { // from class: com.appnew.android.testmodule.fragment.ViewSolutionFragment$$ExternalSyntheticLambda0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((TestseriesBase) obj).getData();
                }
            }).map(new Function() { // from class: com.appnew.android.testmodule.fragment.ViewSolutionFragment$$ExternalSyntheticLambda1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((Data) obj).getQuestionReportOptions();
                }
            }).orElse(null) : null;
            if (this.tvReportError != null) {
                if (list != null && !list.isEmpty()) {
                    this.tvReportError.setVisibility(0);
                    this.tvReportError.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.fragment.ViewSolutionFragment$$ExternalSyntheticLambda2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$reportQuestion$3(list, view);
                        }
                    });
                } else {
                    this.tvReportError.setVisibility(8);
                    this.tvReportError.setOnClickListener(null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reportQuestion$3(List list, View view) {
        ((ViewSolutionActivity) requireActivity()).showPopupErrorTest(list);
    }
}
