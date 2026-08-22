package com.appnew.android.Courses.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.Courses.quiz.Questions;
import com.appnew.android.Model.Courses.quiz.QuizModel;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.MainFragment;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class QuizSolutions extends MainFragment implements View.OnClickListener {
    Activity activity;
    LinearLayout answerLL;
    TestSeriesOptionWebView answerTV;
    ImageView correctIV;
    LinearLayout correctLL;
    LinearLayout descriptionTVLL;
    RelativeLayout finishQuizLL;
    CountDownTimer mcountDown;
    LinearLayout mcqItemLL;
    Button nextBtn;
    TextView optionIconTV;
    Button previousBtn;
    ProgressBar quesTimeProgressBar;
    TextView questCountTV;
    JsonObject questionArray;
    CardView questionQuizCV;
    JsonArray question_dump;
    Questions questions;
    Questions questionsResult;
    QuizModel quiz;
    TextView quizTime;
    RelativeLayout quiz_description_containerRL;
    ArrayList<Questions> resultTestSeriesArrayList;
    ImageView resumeBtn;
    TextView resumeQuiz;
    RelativeLayout resumeQuizLL;
    int timeinMillis;
    ArrayList<String> userAnswered;
    ArrayList<View> viewArrayList;
    String frag_type = "";
    String quiz_id = "";
    int currentQues = 0;

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    public static QuizSolutions newInstance(String frag_type, String quiz) {
        QuizSolutions quizSolutions = new QuizSolutions();
        Bundle bundle = new Bundle();
        bundle.putSerializable("test_series", quiz);
        bundle.putSerializable(Const.FRAG_TYPE, frag_type);
        quizSolutions.setArguments(bundle);
        return quizSolutions;
    }

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.frag_type = getArguments().getString(Const.FRAG_TYPE);
            this.quiz_id = getArguments().getString("test_series");
        }
        this.activity = getActivity();
        this.viewArrayList = new ArrayList<>();
        this.resultTestSeriesArrayList = new ArrayList<>();
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals(API.API_GET_SOLUTION_TESTSERIES)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setUser_id(SharedPreference.getInstance().getLoggedInUser().getId());
        encryptionData.setTest_segment_id(this.quiz_id);
        return service.API_GET_SOLUTION_TESTSERIES(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void SuccessCallBack(JSONObject jsonobject, String apitype, String typeApi, boolean showprogress) throws JSONException {
        Gson gson = new Gson();
        apitype.hashCode();
        if (apitype.equals(API.API_GET_SOLUTION_TESTSERIES)) {
            if (jsonobject.optString("status").equals("true")) {
                JSONArray jSONArray = jsonobject.getJSONArray("data");
                for (int i = 0; i < jSONArray.length(); i++) {
                    Questions questions = (Questions) gson.fromJson(jSONArray.get(i).toString(), Questions.class);
                    this.questionsResult = questions;
                    this.resultTestSeriesArrayList.add(questions);
                }
                setQuestionData();
                return;
            }
            RetrofitResponse.GetApiData(this.activity, jsonobject.optString("auth_code"), jsonobject.optString("message"), false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_quiz_solutions, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        NetworkAPICall(API.API_GET_SOLUTION_TESTSERIES, "", true, false, false);
    }

    private void initViews(View view) {
        this.questCountTV = (TextView) view.findViewById(R.id.quesCount);
        this.resumeQuiz = (TextView) view.findViewById(R.id.playTextTV);
        this.resumeBtn = (ImageView) view.findViewById(R.id.playBtn);
        this.quizTime = (TextView) view.findViewById(R.id.time_slot);
        this.resumeQuizLL = (RelativeLayout) view.findViewById(R.id.resumeQuizLL);
        this.finishQuizLL = (RelativeLayout) view.findViewById(R.id.finishQuizLL);
        this.previousBtn = (Button) view.findViewById(R.id.prevQuizBT);
        this.nextBtn = (Button) view.findViewById(R.id.nextQuizBT);
        this.answerLL = (LinearLayout) view.findViewById(R.id.quizQuestionLL);
        this.descriptionTVLL = (LinearLayout) view.findViewById(R.id.descriptionTVLL);
        this.quesTimeProgressBar = (ProgressBar) view.findViewById(R.id.timer_progress);
        this.questionQuizCV = (CardView) view.findViewById(R.id.questionQuizCV);
        this.quiz_description_containerRL = (RelativeLayout) view.findViewById(R.id.quiz_description_containerRL);
        this.previousBtn.setVisibility(4);
        this.previousBtn.setOnClickListener(this);
        this.nextBtn.setOnClickListener(this);
    }

    private void setQuestionData() {
        this.questions = this.resultTestSeriesArrayList.get(this.currentQues);
        if (this.viewArrayList.size() > 0) {
            this.viewArrayList.clear();
        }
        if (this.currentQues == 0) {
            this.previousBtn.setVisibility(4);
        } else {
            this.previousBtn.setVisibility(0);
        }
        if (this.answerLL.getChildCount() > 0) {
            this.answerLL.removeAllViews();
        }
        this.questionQuizCV.removeAllViews();
        TestSeriesOptionWebView testSeriesOptionWebView = (TestSeriesOptionWebView) getLayoutInflater().inflate(R.layout.quiz_solution_description, (ViewGroup) null);
        testSeriesOptionWebView.getSettings().setJavaScriptEnabled(true);
        Helper.TestWebHTMLLoad(testSeriesOptionWebView, this.questions.getQuestion());
        testSeriesOptionWebView.setDisableWebViewTouchListener(true);
        this.questionQuizCV.addView(testSeriesOptionWebView);
        this.questCountTV.setText((this.currentQues + 1) + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.resultTestSeriesArrayList.size());
        if (!TextUtils.isEmpty(this.questions.getDescription())) {
            this.descriptionTVLL.setVisibility(0);
            TestSeriesOptionWebView testSeriesOptionWebView2 = (TestSeriesOptionWebView) getLayoutInflater().inflate(R.layout.quiz_solution_description, (ViewGroup) null);
            testSeriesOptionWebView2.getSettings().setJavaScriptEnabled(true);
            Helper.TestWebHTMLLoad(testSeriesOptionWebView2, this.questions.getQuestion());
            this.quiz_description_containerRL.addView(testSeriesOptionWebView2);
        } else {
            this.descriptionTVLL.setVisibility(8);
            this.quiz_description_containerRL.removeAllViews();
        }
        if (this.questions.getQuestion_type().equals("1") || this.questions.getQuestion_type().equalsIgnoreCase("MC")) {
            if (!TextUtils.isEmpty(this.questions.getOption_1())) {
                this.answerLL.addView(initAnswerMCViews("1", this.questions.getOption_1(), this.questions));
            }
            if (!TextUtils.isEmpty(this.questions.getOption_2())) {
                this.answerLL.addView(initAnswerMCViews("2", this.questions.getOption_2(), this.questions));
            }
            if (!TextUtils.isEmpty(this.questions.getOption_3())) {
                this.answerLL.addView(initAnswerMCViews("3", this.questions.getOption_3(), this.questions));
            }
            if (!TextUtils.isEmpty(this.questions.getOption_4())) {
                this.answerLL.addView(initAnswerMCViews("4", this.questions.getOption_4(), this.questions));
            }
            if (TextUtils.isEmpty(this.questions.getOption_5())) {
                return;
            }
            this.answerLL.addView(initAnswerMCViews("5", this.questions.getOption_5(), this.questions));
            return;
        }
        if (this.questions.getQuestion_type().equalsIgnoreCase("SC") || this.questions.getQuestion_type().equalsIgnoreCase("TF")) {
            if (!TextUtils.isEmpty(this.questions.getOption_1())) {
                this.answerLL.addView(initAnswerSCViews("1", this.questions.getOption_1(), this.questions));
            }
            if (!TextUtils.isEmpty(this.questions.getOption_2())) {
                this.answerLL.addView(initAnswerSCViews("2", this.questions.getOption_2(), this.questions));
            }
            if (!TextUtils.isEmpty(this.questions.getOption_3())) {
                this.answerLL.addView(initAnswerSCViews("3", this.questions.getOption_3(), this.questions));
            }
            if (!TextUtils.isEmpty(this.questions.getOption_4())) {
                this.answerLL.addView(initAnswerSCViews("4", this.questions.getOption_4(), this.questions));
            }
            if (TextUtils.isEmpty(this.questions.getOption_5())) {
                return;
            }
            this.answerLL.addView(initAnswerSCViews("5", this.questions.getOption_5(), this.questions));
        }
    }

    private LinearLayout initAnswerMCViews(String text, String questions, Questions questionsModel) {
        LinearLayout linearLayout = (LinearLayout) View.inflate(this.activity, R.layout.mcq_quiz, null);
        this.answerTV = (TestSeriesOptionWebView) linearLayout.findViewById(R.id.optionTextTV);
        this.optionIconTV = (TextView) linearLayout.findViewById(R.id.optionIconTV);
        this.mcqItemLL = (LinearLayout) linearLayout.findViewById(R.id.mcqlayout_LL);
        this.correctIV = (ImageView) linearLayout.findViewById(R.id.correctIV);
        this.correctLL = (LinearLayout) linearLayout.findViewById(R.id.correctLL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(3, 3, 3, 3);
        this.mcqItemLL.setLayoutParams(layoutParams);
        linearLayout.setBackground(null);
        String[] strArrSplit = questionsModel.getUser_answer().split(Constants.SEPARATOR_COMMA);
        String[] strArrSplit2 = questionsModel.getAnswer().split(Constants.SEPARATOR_COMMA);
        if (Arrays.asList(strArrSplit2).contains(text) && Arrays.asList(strArrSplit).contains(text)) {
            this.correctLL.setVisibility(0);
            this.answerTV.getSettings().setJavaScriptEnabled(true);
            Helper.TestWebHTMLLoad(this.answerTV, questions);
            this.answerTV.setDisableWebViewTouchListener(true);
            this.optionIconTV.setText(text);
            this.correctIV.setVisibility(0);
            linearLayout.getChildAt(1).setBackground(getResources().getDrawable(R.drawable.quiz_options_bg_green));
            this.correctIV.setPadding(10, 10, 10, 10);
            this.correctIV.setBackgroundResource(com.appnew.android.R.drawable.check_on);
        } else if (Arrays.asList(strArrSplit2).contains(text) && !Arrays.asList(strArrSplit).contains(text)) {
            this.correctLL.setVisibility(0);
            this.answerTV.getSettings().setJavaScriptEnabled(true);
            Helper.TestWebHTMLLoad(this.answerTV, questions);
            this.answerTV.setDisableWebViewTouchListener(true);
            this.optionIconTV.setText(text);
            this.correctIV.setVisibility(0);
            linearLayout.getChildAt(1).setBackground(getResources().getDrawable(R.drawable.quiz_options_bg_green));
            this.correctIV.setPadding(10, 10, 10, 10);
        } else if (!Arrays.asList(strArrSplit2).contains(text) && Arrays.asList(strArrSplit).contains(text)) {
            this.correctLL.setVisibility(0);
            this.answerTV.getSettings().setJavaScriptEnabled(true);
            Helper.TestWebHTMLLoad(this.answerTV, questions);
            this.answerTV.setDisableWebViewTouchListener(true);
            this.optionIconTV.setText(text);
            this.correctIV.setVisibility(0);
            linearLayout.getChildAt(1).setBackground(getResources().getDrawable(R.drawable.quiz_options_bg_red));
            this.correctIV.setPadding(10, 10, 10, 10);
            this.correctIV.setBackgroundResource(com.appnew.android.R.drawable.check_off);
        } else {
            this.answerTV.getSettings().setJavaScriptEnabled(true);
            Helper.TestWebHTMLLoad(this.answerTV, questions);
            this.answerTV.setDisableWebViewTouchListener(true);
            this.optionIconTV.setText(text);
            this.correctIV.setVisibility(4);
        }
        this.mcqItemLL.setTag(R.id.questions, this.optionIconTV.getText().toString());
        LinearLayout linearLayout2 = this.mcqItemLL;
        linearLayout2.setTag(R.id.optionsAns, linearLayout2);
        this.viewArrayList.add(this.mcqItemLL);
        return linearLayout;
    }

    private LinearLayout initAnswerSCViews(String text, String questions, Questions questionsModel) {
        LinearLayout linearLayout = (LinearLayout) View.inflate(this.activity, R.layout.mcq_quiz, null);
        this.answerTV = (TestSeriesOptionWebView) linearLayout.findViewById(R.id.optionTextTV);
        this.optionIconTV = (TextView) linearLayout.findViewById(R.id.optionIconTV);
        this.mcqItemLL = (LinearLayout) linearLayout.findViewById(R.id.mcqlayout_LL);
        this.correctIV = (ImageView) linearLayout.findViewById(R.id.correctIV);
        this.correctLL = (LinearLayout) linearLayout.findViewById(R.id.correctLL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(3, 3, 3, 3);
        this.mcqItemLL.setLayoutParams(layoutParams);
        linearLayout.setBackground(null);
        if (questionsModel.getUser_answer().equals(text)) {
            if (questionsModel.getAnswer().equals(questionsModel.getUser_answer())) {
                this.correctLL.setVisibility(0);
                this.answerTV.getSettings().setJavaScriptEnabled(true);
                Helper.TestWebHTMLLoad(this.answerTV, questions);
                this.answerTV.setDisableWebViewTouchListener(true);
                this.optionIconTV.setText(text);
                this.correctIV.setVisibility(0);
                linearLayout.getChildAt(1).setBackground(getResources().getDrawable(R.drawable.quiz_options_bg_green));
                this.correctIV.setPadding(10, 10, 10, 10);
                this.correctIV.setBackgroundResource(com.appnew.android.R.drawable.check_on);
            } else {
                this.correctLL.setVisibility(0);
                this.answerTV.getSettings().setJavaScriptEnabled(true);
                Helper.TestWebHTMLLoad(this.answerTV, questions);
                this.answerTV.setDisableWebViewTouchListener(true);
                this.optionIconTV.setText(text);
                this.correctIV.setVisibility(0);
                linearLayout.getChildAt(1).setBackground(getResources().getDrawable(R.drawable.quiz_options_bg_red));
                this.correctIV.setPadding(10, 10, 10, 10);
                this.correctIV.setBackgroundResource(com.appnew.android.R.drawable.check_off);
            }
        } else if (questionsModel.getAnswer().equals(text)) {
            this.correctLL.setVisibility(0);
            this.answerTV.getSettings().setJavaScriptEnabled(true);
            Helper.TestWebHTMLLoad(this.answerTV, questions);
            this.answerTV.setDisableWebViewTouchListener(true);
            this.optionIconTV.setText(text);
            this.correctIV.setVisibility(0);
            linearLayout.getChildAt(1).setBackground(getResources().getDrawable(R.drawable.quiz_options_bg_green));
            this.correctIV.setPadding(10, 10, 10, 10);
            this.correctIV.setBackgroundResource(com.appnew.android.R.drawable.check_on);
        } else {
            this.answerTV.getSettings().setJavaScriptEnabled(true);
            Helper.TestWebHTMLLoad(this.answerTV, questions);
            this.answerTV.setDisableWebViewTouchListener(true);
            this.optionIconTV.setText(text);
            this.correctLL.setVisibility(8);
            this.correctIV.setVisibility(4);
        }
        this.mcqItemLL.setTag(R.id.questions, this.optionIconTV.getText().toString());
        LinearLayout linearLayout2 = this.mcqItemLL;
        linearLayout2.setTag(R.id.optionsAns, linearLayout2);
        this.viewArrayList.add(this.mcqItemLL);
        return linearLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.nextQuizBT) {
            if (id != R.id.prevQuizBT) {
                return;
            }
            int i = this.currentQues;
            if (i != 0) {
                this.currentQues = i - 1;
            }
            this.nextBtn.setText(this.activity.getResources().getString(R.string.next));
            setQuestionData();
            return;
        }
        if (this.resultTestSeriesArrayList.size() == this.currentQues + 1) {
            this.question_dump = new JsonArray();
            this.activity.finish();
            return;
        }
        int size = this.resultTestSeriesArrayList.size();
        int i2 = this.currentQues;
        if (size == i2 + 2) {
            this.currentQues = i2 + 1;
            this.nextBtn.setText(this.activity.getResources().getString(R.string.finish));
            setQuestionData();
        } else {
            this.currentQues = i2 + 1;
            setQuestionData();
        }
    }
}
