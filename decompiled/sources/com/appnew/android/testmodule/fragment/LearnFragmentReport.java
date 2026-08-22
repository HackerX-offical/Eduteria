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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ahmadnemati.clickablewebview.ClickableWebView;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.MainFragment;
import com.appnew.android.Utils.Progress;
import com.appnew.android.player.CustommediaPlayerDialog;
import com.appnew.android.testmodule.mathview.MathView;
import com.appnew.android.testmodule.model.FIBEdit;
import com.appnew.android.testmodule.model.Questions2;
import com.appnew.android.testmodule.model.ResultTestSeries_Report;
import com.clevertap.android.sdk.Constants;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class LearnFragmentReport extends MainFragment implements Html.ImageGetter {
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
    TextView on_screen_txt;
    TextView onscreen_value;
    LinearLayout parentLL;
    List<View> parentList;
    int position;
    String questionType;
    TextView question_status;
    RelativeLayout questionsol_layout1;
    Questions2 result;
    RecyclerView rvmatchinquestion1;
    RecyclerView rvmatchinquestion2;
    private boolean status;
    ArrayList<WebView> textViews = new ArrayList<>();
    List<View> tvList;
    private ClickableWebView tvQuestion;
    private ClickableWebView tvQuestionFib;
    private ClickableWebView tv_question_PG;
    TextView tv_uid;
    String type;
    TextView userEmailTV;
    TextView videosolution;
    ResultTestSeries_Report viewSolutionData;
    TextView your_ans_text;
    TextView your_ans_txt;

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

    public static LearnFragmentReport newInstance(int position, ResultTestSeries_Report viewSolutionData, String questionType, String type) {
        Bundle bundle = new Bundle();
        bundle.putInt(Const.POSITION, position);
        bundle.putString("questionType", questionType);
        bundle.putString("type", type);
        bundle.putSerializable("DATA", viewSolutionData);
        LearnFragmentReport learnFragmentReport = new LearnFragmentReport();
        learnFragmentReport.setArguments(bundle);
        return learnFragmentReport;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewInflate = inflater.inflate(R.layout.fragment_view_solution, (ViewGroup) null);
        this.activity = getActivity();
        getBundleData();
        initView(viewInflate);
        this.mProgress = new Progress(this.activity);
        return viewInflate;
    }

    private void getBundleData() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.position = arguments.getInt(Const.POSITION, 0);
            this.viewSolutionData = (ResultTestSeries_Report) arguments.getSerializable("DATA");
            this.questionType = arguments.getString("questionType", "");
            this.type = arguments.getString("type", "");
        }
    }

    private void initView(View view) {
        this.mcqoptionsLL = (LinearLayout) view.findViewById(R.id.mcqoptions);
        this.tv_question_PG = (ClickableWebView) view.findViewById(R.id.tv_question_PG);
        this.tvQuestion = (ClickableWebView) view.findViewById(R.id.tv_question);
        this.tvQuestionFib = (ClickableWebView) view.findViewById(R.id.tv_question_fib);
        this.questionsol_layout1 = (RelativeLayout) view.findViewById(R.id.questionsol_layout1);
        this.LLmatchinquestion = (LinearLayout) view.findViewById(R.id.LLmatchinquestion);
        this.rvmatchinquestion1 = (RecyclerView) view.findViewById(R.id.rvmatchinquestion1);
        this.rvmatchinquestion2 = (RecyclerView) view.findViewById(R.id.rvmatchinquestion2);
        this.videosolution = (TextView) view.findViewById(R.id.videosolution);
        this.rvmatchinquestion1.setLayoutManager(new LinearLayoutManager(this.activity));
        this.rvmatchinquestion2.setLayoutManager(new LinearLayoutManager(this.activity));
        this.rvmatchinquestion2.setHasFixedSize(true);
        this.explanationLL = (LinearLayout) view.findViewById(R.id.explanationLL);
        this.explanationTV = (ClickableWebView) view.findViewById(R.id.explanationTV);
        this.tv_uid = (TextView) view.findViewById(R.id.tv_uid);
        this.your_ans_text = (TextView) view.findViewById(R.id.your_ans);
        this.your_ans_txt = (TextView) view.findViewById(R.id.your_ans_txt);
        this.on_screen_txt = (TextView) view.findViewById(R.id.on_screen_txt);
        this.max_marks = (TextView) view.findViewById(R.id.maxmarks);
        this.min_marks = (TextView) view.findViewById(R.id.minmarks);
        this.onscreen_value = (TextView) view.findViewById(R.id.onscreen_value);
        this.question_status = (TextView) view.findViewById(R.id.question_status);
        this.nestedSV = (NestedScrollView) view.findViewById(R.id.nestedSV);
        this.userEmailTV = (TextView) view.findViewById(R.id.userEmailTV);
        this.LinearLayoutList = new ArrayList();
        this.parentList = new ArrayList();
        this.tvList = new ArrayList();
        this.result = this.viewSolutionData.getData().getQuestions().get(this.position);
        this.your_ans_text.setVisibility(8);
        this.onscreen_value.setVisibility(8);
        this.on_screen_txt.setVisibility(8);
        this.your_ans_txt.setVisibility(8);
        this.explanationLL.setVisibility(0);
        this.explanationTV.setBackgroundColor(0);
        this.tvQuestion.setLayerType(2, null);
        this.explanationTV.getSettings().setJavaScriptEnabled(true);
        this.explanationTV.getSettings().setGeolocationEnabled(true);
        Helper.TestWebHTMLLoad(this.explanationTV, this.result.getDescription());
        this.min_marks.setVisibility(8);
        this.max_marks.setVisibility(8);
        if (Helper.isStringValid(this.result.getSolution_url())) {
            this.videosolution.setVisibility(0);
        } else {
            this.videosolution.setVisibility(8);
        }
        this.videosolution.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.testmodule.fragment.LearnFragmentReport$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$initView$0();
            }
        }));
        setExplanationView();
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
                    Helper.TestWebHTMLLoad(this.tvQuestion, "Q-" + (this.position + 1) + ". " + question);
                }
                this.tvQuestion.setLongClickable(false);
                this.tvQuestion.setOnLongClickListener(new WebViewClickListener(this.tvQuestion, this.questionsol_layout1));
                break;
            case "PG":
                ResultTestSeries_Report resultTestSeries_Report = this.viewSolutionData;
                if (resultTestSeries_Report != null) {
                    if (TextUtils.isEmpty(resultTestSeries_Report.getData().getQuestions().get(this.position).getParagraphText())) {
                        this.tvQuestion.setVisibility(8);
                    } else {
                        this.tvQuestion.setVisibility(0);
                        String question2 = this.viewSolutionData.getData().getQuestions().get(this.position).getQuestion();
                        if (this.viewSolutionData.getData().getQuestions().get(this.position).getFont_type().equalsIgnoreCase("1") || this.viewSolutionData.getData().getQuestions().get(this.position).getFont_type().equalsIgnoreCase("2")) {
                            Helper.testQuestionFont(this.tvQuestion, this.position, question2, this.viewSolutionData.getData().getQuestions().get(this.position).getFont_type());
                        } else {
                            Helper.TestWebHTMLLoad(this.tvQuestion, "Q-" + (this.position + 1) + ". " + question2);
                        }
                    }
                    String paragraphText = this.viewSolutionData.getData().getQuestions().get(this.position).getParagraphText();
                    if (this.viewSolutionData.getData().getQuestions().get(this.position).getFont_type().equalsIgnoreCase("1") || this.viewSolutionData.getData().getQuestions().get(this.position).getFont_type().equalsIgnoreCase("2")) {
                        Helper.testQuestionFont(this.tvQuestionFib, this.position, paragraphText, this.viewSolutionData.getData().getQuestions().get(this.position).getFont_type());
                    } else {
                        Helper.TestWebHTMLLoad(this.tvQuestionFib, "Q-" + (this.position + 1) + ". " + paragraphText);
                    }
                }
                this.mcqoptionsLL.setVisibility(0);
                this.LLmatchinquestion.setVisibility(8);
                this.tvQuestion.setBackgroundColor(0);
                this.tvQuestion.setLayerType(2, null);
                this.tvQuestion.getSettings().setJavaScriptEnabled(true);
                this.tvQuestion.getSettings().setGeolocationEnabled(true);
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
                    Helper.TestWebHTMLLoad(this.tvQuestion, "Q-" + (this.position + 1) + ". " + strReplace);
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
                if (!this.viewSolutionData.getData().getQuestions().get(this.position).getFont_type().equalsIgnoreCase("1") && !this.viewSolutionData.getData().getQuestions().get(this.position).getFont_type().equalsIgnoreCase("2")) {
                    Helper.TestWebHTMLLoad(this.tvQuestion, "Q-" + (this.position + 1) + ". " + question3);
                } else {
                    Helper.testQuestionFont(this.tvQuestion, this.position, question3, this.viewSolutionData.getData().getQuestions().get(this.position).getFont_type());
                }
                this.tvQuestion.setLongClickable(false);
                this.tvQuestion.setOnLongClickListener(new WebViewClickListener(this.tvQuestion, this.questionsol_layout1));
                addSolutionOption();
                break;
        }
        displaySolution();
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

    private void setExplanationView() {
        if (!this.result.getDescription().isEmpty()) {
            String description = this.result.getDescription();
            this.explanationLL.setVisibility(0);
            this.explanationTV.setBackgroundColor(0);
            this.tvQuestion.setLayerType(2, null);
            this.tvQuestion.getSettings().setJavaScriptEnabled(true);
            this.explanationTV.getSettings().setJavaScriptEnabled(true);
            Helper.TestWebHTMLLoad(this.explanationTV, this.result.getDescription());
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
                        this.mcqoptionsLL.addView(initMCQOptionView("1", this.result.getOption1(), "11", false, i - 1));
                    }
                    break;
                case 2:
                    if (this.result.getOption2().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("2", this.result.getOption2(), "11", false, i - 1));
                    }
                    break;
                case 3:
                    if (this.result.getOption3().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("3", this.result.getOption3(), "11", false, i - 1));
                    }
                    break;
                case 4:
                    if (this.result.getOption4().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("4", this.result.getOption4(), "11", false, i - 1));
                    }
                    break;
                case 5:
                    if (this.result.getOption5().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("5", this.result.getOption5(), "11", false, i - 1));
                    }
                    break;
                case 6:
                    if (this.result.getOption6() == null || this.result.getOption6().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("6", this.result.getOption6(), "11", false, i - 1));
                    }
                    break;
                case 7:
                    if (this.result.getOption7() == null || this.result.getOption7().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("7", this.result.getOption7(), "11", false, i - 1));
                    }
                    break;
                case 8:
                    if (this.result.getOption8() == null || this.result.getOption8().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("8", this.result.getOption8(), "11", false, i - 1));
                    }
                    break;
                case 9:
                    if (this.result.getOption9() == null || this.result.getOption9().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("9", this.result.getOption9(), "11", false, i - 1));
                    }
                    break;
                case 10:
                    if (this.result.getOption10() == null || this.result.getOption10().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("10", this.result.getOption10(), "11", false, i - 1));
                    }
                    break;
            }
        }
        this.status = false;
    }

    private void displaySolution() {
        String str = this.questionType;
        str.hashCode();
        switch (str) {
            case "":
            case "PG":
            case "SC":
            case "TF":
                break;
            case "MC":
                for (String str2 : this.result.getAnswer().split(Constants.SEPARATOR_COMMA)) {
                    int i = 0;
                    while (i < this.LinearLayoutList.size()) {
                        int i2 = i + 1;
                        if (Integer.parseInt(str2) == i2) {
                            this.LinearLayoutList.get(i).setSelected(true);
                        }
                        i = i2;
                    }
                }
                return;
            case "FIB":
                String[] strArrSplit = this.result.getAnswer().split(Constants.SEPARATOR_COMMA);
                for (int i3 = 0; i3 < strArrSplit.length; i3++) {
                    if (this.LinearLayoutList.size() > 0 && !strArrSplit[i3].equalsIgnoreCase("")) {
                        this.LinearLayoutList.get(0).setSelected(true);
                        Helper.TestWebHTMLLoad(this.textViews.get(0), strArrSplit[i3]);
                    }
                }
                return;
            default:
                return;
        }
        for (int i4 = 0; i4 < this.LinearLayoutList.size(); i4++) {
            try {
                if (!TextUtils.isEmpty(this.result.getAnswer()) && i4 + 1 == Integer.parseInt(this.result.getAnswer())) {
                    this.LinearLayoutList.get(i4).setSelected(true);
                }
            } catch (Exception unused) {
                return;
            }
        }
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
                        this.mcqoptionsLL.addView(initMCQOptionView("1", this.result.getOption1(), "11", false, i - 1));
                    }
                    break;
                case 2:
                    if (this.result.getOption2().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("2", this.result.getOption2(), "11", false, i - 1));
                    }
                    break;
                case 3:
                    if (this.result.getOption3().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("3", this.result.getOption3(), "11", false, i - 1));
                    }
                    break;
                case 4:
                    if (this.result.getOption4().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("4", this.result.getOption4(), "11", false, i - 1));
                    }
                    break;
                case 5:
                    if (this.result.getOption5().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("5", this.result.getOption5(), "11", false, i - 1));
                    }
                    break;
                case 6:
                    if (this.result.getOption6() == null || this.result.getOption6().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("6", this.result.getOption6(), "11", false, i - 1));
                    }
                    break;
                case 7:
                    if (this.result.getOption7() == null || this.result.getOption7().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("7", this.result.getOption7(), "11", false, i - 1));
                    }
                    break;
                case 8:
                    if (this.result.getOption8() == null || this.result.getOption8().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("8", this.result.getOption8(), "11", false, i - 1));
                    }
                    break;
                case 9:
                    if (this.result.getOption9() == null || this.result.getOption9().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("9", this.result.getOption9(), "11", false, i - 1));
                    }
                    break;
                case 10:
                    if (this.result.getOption10() == null || this.result.getOption10().isEmpty()) {
                        this.status = true;
                    } else {
                        this.mcqoptionsLL.addView(initMCQOptionView("10", this.result.getOption10(), "11", false, i - 1));
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
                    Helper.TestWebHTMLLoad(mathView, "Min value " + fIBEdit.getMin() + " Max value " + fIBEdit.getMax());
                    linearLayout.setSelected(true);
                } else if (fIBEdit.getType().equalsIgnoreCase(FirebaseAnalytics.Param.CHARACTER)) {
                    Helper.TestWebHTMLLoad(mathView, "Min text length " + fIBEdit.getMin() + " Max text length " + fIBEdit.getMax());
                    linearLayout.setSelected(true);
                } else {
                    Helper.TestWebHTMLLoad(mathView, fIBEdit.getAnswer());
                    linearLayout.setSelected(true);
                }
            }
        } else if (this.viewSolutionData.getData().getQuestions().get(this.position).getFont_type().equalsIgnoreCase("1") || this.viewSolutionData.getData().getQuestions().get(this.position).getFont_type().equalsIgnoreCase("2")) {
            Helper.testOptionFont(mathView, str2, this.viewSolutionData.getData().getQuestions().get(this.position).getFont_type());
        } else {
            Helper.TestWebHTMLLoad(mathView, Helper.getHTMLWidthForImage(str2));
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
                this.mDrawable.setBounds(0, 0, LearnFragmentReport.this.empty.getIntrinsicWidth(), LearnFragmentReport.this.empty.getIntrinsicHeight());
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
                this.mDrawable.setBounds(0, 0, LearnFragmentReport.this.empty2.getIntrinsicWidth(), LearnFragmentReport.this.empty2.getIntrinsicHeight());
                this.mDrawable.setLevel(1);
            }
        }
    }
}
