package com.appnew.android.Courses.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.amulyakhare.textdrawable.TextDrawable;
import com.appnew.android.Courses.Activity.QuizActivity;
import com.appnew.android.Courses.Adapter.IBTNavigationQuizAdapter;
import com.appnew.android.Courses.Adapter.NavigationQuizAdapter;
import com.appnew.android.Model.Courses.quiz.Questions;
import com.appnew.android.Model.Courses.quiz.QuizModel;
import com.appnew.android.Model.Courses.quiz.ResultTestSeries;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.DialogUtils;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.MainFragment;
import com.appnew.android.Utils.OnSwipeTouchListener;
import com.appnew.android.Utils.SharedPreference;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.joda.time.DateTimeConstants;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class Quiz extends MainFragment implements View.OnClickListener {
    Activity activity;
    LinearLayout answerLL;
    TestSeriesOptionWebView answerTV;
    ImageView bookmark_ques;
    RelativeLayout clickBlockView;
    public TextView coins;
    public TextView correctAns;
    private int correctAnsText;
    RelativeLayout finishQuizLL;
    private IBTNavigationQuizAdapter ibtNavigationQuizAdapter;
    public TextView incorrectAns;
    private int incorrectAnsText;
    CountDownTimer mcountDown;
    LinearLayout mcqItemLL;
    Button nextBtn;
    TextView optionIconTV;
    private boolean practiceOrQuiz;
    Button previousBtn;
    TextView quesNum;
    RecyclerView quesRV;
    ProgressBar quesTimeProgressBar;
    private RelativeLayout ques_coontainerRL;
    TextView questCountTV;
    JsonObject questionArray;
    private CardView questionQuizCV;
    TestSeriesOptionWebView questionTV;
    JsonArray question_dump;
    Questions questions;
    public QuizModel quiz;
    LinearLayout quizLL;
    TextView quizTime;
    RelativeLayout quiz_swipe_RL;
    ImageView resumeBtn;
    TextView resumeQuiz;
    RelativeLayout resumeQuizLL;
    LinearLayout shareRankLL;
    int timeinMillis;
    int timeinSeconds;
    ArrayList<String> userAnswered;
    ArrayList<View> viewArrayList;
    public int currentQues = 0;
    String frag_type = "";
    View.OnClickListener optionClickListener = new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.Quiz.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            for (int i = 0; i < Quiz.this.viewArrayList.size(); i++) {
                if (v == Quiz.this.viewArrayList.get(i)) {
                    if (Quiz.this.quiz.getBasic_info().getTest_type().equals("1")) {
                        LinearLayout linearLayout = (LinearLayout) Quiz.this.viewArrayList.get(i).getTag(R.id.optionsAns);
                        if (linearLayout.getChildAt(1).getBackground().getConstantState().equals(Quiz.this.getResources().getDrawable(R.drawable.quiz_options_bg_green).getConstantState())) {
                            linearLayout.getChildAt(1).setBackground(Quiz.this.getResources().getDrawable(R.drawable.quiz_options_bg_transparent));
                            Quiz.this.questions.getUserAnswered().remove(String.valueOf(Quiz.this.viewArrayList.indexOf(linearLayout) + 1));
                            Collections.sort(Quiz.this.questions.getUserAnswered());
                            Quiz.this.questions.setUser_answer(TextUtils.join(Constants.SEPARATOR_COMMA, Quiz.this.questions.getUserAnswered()));
                        } else {
                            linearLayout.getChildAt(1).setBackground(Quiz.this.getResources().getDrawable(R.drawable.quiz_options_bg_green));
                            if (!Quiz.this.questions.getUserAnswered().contains(String.valueOf(Quiz.this.viewArrayList.indexOf(linearLayout) + 1))) {
                                Quiz.this.questions.getUserAnswered().add(String.valueOf(Quiz.this.viewArrayList.indexOf(linearLayout) + 1));
                            }
                            Collections.sort(Quiz.this.questions.getUserAnswered());
                            Quiz.this.questions.setUser_answer(TextUtils.join(Constants.SEPARATOR_COMMA, Quiz.this.questions.getUserAnswered()));
                        }
                    } else {
                        if (Quiz.this.questions.getQuestion_type().equals("SC") || Quiz.this.questions.getQuestion_type().equals("TF")) {
                            LinearLayout linearLayout2 = (LinearLayout) Quiz.this.viewArrayList.get(i).getTag(R.id.optionsAns);
                            if (Quiz.this.questions.getAnswer().equals(String.valueOf(Quiz.this.viewArrayList.indexOf(linearLayout2) + 1))) {
                                linearLayout2.getChildAt(1).setBackground(Quiz.this.getResources().getDrawable(R.drawable.quiz_options_bg_green));
                                Quiz.this.correctAnsText++;
                                Quiz.this.correctAns.setText(String.valueOf(Quiz.this.correctAnsText));
                                new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.Courses.Fragment.Quiz.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Quiz.this.nextBtn.performClick();
                                        Quiz.this.ibtNavigationQuizAdapter.notifyDataSetChanged();
                                    }
                                }, 1500L);
                            } else {
                                linearLayout2.getChildAt(1).setBackground(Quiz.this.getResources().getDrawable(R.drawable.quiz_options_bg_red));
                                final RelativeLayout relativeLayout = (RelativeLayout) ((LinearLayout) Quiz.this.viewArrayList.get(Integer.parseInt(Quiz.this.questions.getAnswer()) - 1).getTag(R.id.optionsAns)).getChildAt(1);
                                new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.Courses.Fragment.Quiz.1.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        relativeLayout.setBackground(Quiz.this.getResources().getDrawable(R.drawable.quiz_options_bg_green));
                                    }
                                }, 750L);
                                Quiz.this.incorrectAnsText++;
                                Quiz.this.incorrectAns.setText(String.valueOf(Quiz.this.incorrectAnsText));
                                new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.Courses.Fragment.Quiz.1.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Quiz.this.nextBtn.performClick();
                                        Quiz.this.ibtNavigationQuizAdapter.notifyDataSetChanged();
                                    }
                                }, 1500L);
                            }
                            Quiz.this.questions.setUser_answer(String.valueOf(Quiz.this.viewArrayList.indexOf(linearLayout2) + 1));
                            Quiz.this.clickBlockView.setVisibility(0);
                            Quiz.this.quizLL.setEnabled(false);
                            Quiz.this.blockTouchonViews();
                        }
                        LinearLayout linearLayout3 = (LinearLayout) Quiz.this.viewArrayList.get(i).getTag(R.id.optionsAns);
                        if (linearLayout3.getChildAt(1).getBackground().getConstantState().equals(Quiz.this.getResources().getDrawable(R.drawable.quiz_options_bg_green).getConstantState())) {
                            linearLayout3.getChildAt(1).setBackground(Quiz.this.getResources().getDrawable(R.drawable.quiz_options_bg_transparent));
                            Quiz.this.questions.getUserAnswered().remove(String.valueOf(Quiz.this.viewArrayList.indexOf(linearLayout3) + 1));
                            Collections.sort(Quiz.this.questions.getUserAnswered());
                            Quiz.this.questions.setUser_answer(TextUtils.join(Constants.SEPARATOR_COMMA, Quiz.this.questions.getUserAnswered()));
                        } else {
                            linearLayout3.getChildAt(1).setBackground(Quiz.this.getResources().getDrawable(R.drawable.quiz_options_bg_green));
                            if (!Quiz.this.questions.getUserAnswered().contains(String.valueOf(Quiz.this.viewArrayList.indexOf(linearLayout3) + 1))) {
                                Quiz.this.questions.getUserAnswered().add(String.valueOf(Quiz.this.viewArrayList.indexOf(linearLayout3) + 1));
                            }
                            Collections.sort(Quiz.this.questions.getUserAnswered());
                            Quiz.this.questions.setUser_answer(TextUtils.join(Constants.SEPARATOR_COMMA, Quiz.this.questions.getUserAnswered()));
                        }
                    }
                } else if (!Quiz.this.quiz.getBasic_info().getTest_type().equals("1") && (Quiz.this.questions.getQuestion_type().equals("SC") || Quiz.this.questions.getQuestion_type().equals("TF"))) {
                    ((LinearLayout) Quiz.this.viewArrayList.get(i).getTag(R.id.optionsAns)).getChildAt(1).setBackground(Quiz.this.getResources().getDrawable(R.drawable.quiz_options_bg_transparent));
                }
            }
            Quiz.this.clickBlockView.setVisibility(0);
            Quiz.this.quizLL.setEnabled(false);
            Quiz.this.blockTouchonViews();
        }
    };

    private void clearQuestionView() {
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    public static Quiz newInstance(String frag_type, QuizModel quiz, String practiceOrQuiz) {
        Quiz quiz2 = new Quiz();
        Bundle bundle = new Bundle();
        bundle.putSerializable("test_series", quiz);
        bundle.putSerializable(Const.FRAG_TYPE, frag_type);
        bundle.putString(Const.PRACTICE, practiceOrQuiz);
        quiz2.setArguments(bundle);
        return quiz2;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_quiz, container, false);
    }

    public void initalizeNavigationView() {
        RecyclerView recyclerView = ((QuizActivity) this.activity).controllerRV;
        Activity activity = this.activity;
        recyclerView.setLayoutManager(new GridLayoutManager((Context) activity, ((QuizActivity) activity).DEFAULT_SPAN_COUNT, 1, false));
        ((QuizActivity) this.activity).navigationQuizAdapter = new NavigationQuizAdapter(this.activity, this.quiz);
        ((QuizActivity) this.activity).controllerRV.setAdapter(((QuizActivity) this.activity).navigationQuizAdapter);
        ((QuizActivity) this.activity).attemptedIV.setImageDrawable(TextDrawable.builder().buildRound(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, this.activity.getResources().getColor(R.color.theme_and_header_color)));
        ((QuizActivity) this.activity).notAttemptedIV.setImageDrawable(TextDrawable.builder().buildRound("NA", this.activity.getResources().getColor(R.color.greayrefcode_dark)));
    }

    public void initalizeHorizontalNavigationView() {
        this.quesRV.setLayoutManager(new LinearLayoutManager(this.activity, 0, false));
        IBTNavigationQuizAdapter iBTNavigationQuizAdapter = new IBTNavigationQuizAdapter(this.activity, this.quiz, this);
        this.ibtNavigationQuizAdapter = iBTNavigationQuizAdapter;
        this.quesRV.setAdapter(iBTNavigationQuizAdapter);
        ((QuizActivity) this.activity).attemptedIV.setImageDrawable(TextDrawable.builder().buildRound(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, this.activity.getResources().getColor(R.color.ibt_green)));
        ((QuizActivity) this.activity).notAttemptedIV.setImageDrawable(TextDrawable.builder().buildRound("NA", this.activity.getResources().getColor(R.color.greayrefcode_dark)));
    }

    public void controlQuizQuestion(int currentQuesCount) {
        clearQuestionView();
        if (!TextUtils.isEmpty(this.quiz.getQuestion_bank().get(this.currentQues).getUser_answer())) {
            this.quiz.getQuestion_bank().get(this.currentQues).setAnswered(true);
            ((QuizActivity) this.activity).navigationQuizAdapter.notifyDataSetChanged();
            this.ibtNavigationQuizAdapter.notifyDataSetChanged();
        }
        if (this.quiz.getQuestion_bank().size() == currentQuesCount + 1) {
            this.currentQues = currentQuesCount;
            this.nextBtn.setText(this.activity.getResources().getString(R.string.submit_rev));
            setQuestionData(this.quiz.getQuestion_bank().get(this.currentQues));
            this.ibtNavigationQuizAdapter.notifyDataSetChanged();
            return;
        }
        this.currentQues = currentQuesCount;
        this.nextBtn.setText(this.activity.getResources().getString(R.string.next));
        setQuestionData(this.quiz.getQuestion_bank().get(this.currentQues));
        this.ibtNavigationQuizAdapter.notifyDataSetChanged();
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.appnew.android.Courses.Fragment.Quiz$2] */
    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        if (((QuizActivity) this.activity).navigationQuizAdapter == null) {
            initalizeNavigationView();
        }
        setQuestionData(this.quiz.getQuestion_bank().get(this.currentQues));
        final int i = Integer.parseInt(this.quiz.getBasic_info().getTime_in_mins()) * DateTimeConstants.MILLIS_PER_MINUTE;
        for (int i2 = 0; i2 < this.quiz.getQuestion_bank().size(); i2++) {
            Questions questions = this.quiz.getQuestion_bank().get(i2);
            if (questions.isAnswered()) {
                if (questions.getAnswer().equalsIgnoreCase(questions.getUser_answer())) {
                    this.correctAnsText++;
                } else {
                    this.incorrectAnsText++;
                }
            }
        }
        this.correctAns.setText(String.valueOf(this.correctAnsText));
        this.incorrectAns.setText(String.valueOf(this.incorrectAnsText));
        initalizeHorizontalNavigationView();
        this.quesTimeProgressBar.setMax(i);
        this.quesTimeProgressBar.getProgressDrawable().setColorFilter(getResources().getColor(R.color.theme_and_header_color), PorterDuff.Mode.SRC_IN);
        this.mcountDown = new CountDownTimer(i, 1000L) { // from class: com.appnew.android.Courses.Fragment.Quiz.2
            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                Quiz.this.quesTimeProgressBar.setMax(i);
                Quiz.this.quesTimeProgressBar.setProgress(i - ((int) millisUntilFinished));
                long j = millisUntilFinished / 1000;
                long j2 = j / 60;
                String.valueOf(j2);
                String.valueOf((millisUntilFinished / 100) / 1000);
                Quiz.this.quizTime.setText(((int) j2) + "mins :" + ((int) (j % 60)) + "secs ");
                Quiz.this.timeinMillis = (int) j;
                Quiz quiz = Quiz.this;
                quiz.timeinSeconds = (quiz.quesTimeProgressBar.getProgress() / 1000) % 60;
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                Quiz.this.quizTime.setText("0:0''");
                Quiz.this.quesTimeProgressBar.setMax(i * 1000);
                Quiz.this.timeinMillis = (i / 1000) % 60;
                Quiz quiz = Quiz.this;
                quiz.timeinSeconds = (quiz.quesTimeProgressBar.getProgress() / 1000) % 60;
                Quiz.this.onTimerFinished();
            }
        }.start();
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.swipeRL);
        OnSwipeTouchListener onSwipeTouchListener = new OnSwipeTouchListener(this.activity) { // from class: com.appnew.android.Courses.Fragment.Quiz.3
            @Override // com.appnew.android.Utils.OnSwipeTouchListener
            public void onSwipeRight() {
                super.onSwipeRight();
                Quiz.this.previousBtn.performClick();
            }

            @Override // com.appnew.android.Utils.OnSwipeTouchListener
            public void onSwipeLeft() {
                super.onSwipeLeft();
                Quiz.this.nextBtn.performClick();
            }
        };
        this.answerLL.setOnTouchListener(onSwipeTouchListener);
        relativeLayout.setOnTouchListener(onSwipeTouchListener);
        ((ScrollView) view.findViewById(R.id.scrollView)).setOnTouchListener(onSwipeTouchListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTimerFinished() {
        this.question_dump = new JsonArray();
        for (Questions questions : this.quiz.getQuestion_bank()) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(Const.QUESTIONID, questions.getId());
            jsonObject.addProperty(Const.ANSWER, TextUtils.isEmpty(questions.getUser_answer()) ? "" : questions.getUser_answer());
            this.question_dump.add(jsonObject);
        }
        this.mcountDown.cancel();
        NetworkAPICall(API.API_COMPLETE_INFO_TESTSERIES, "", true, false, false);
    }

    private void initViews(View view) {
        this.questCountTV = (TextView) view.findViewById(R.id.quesCount);
        this.quesNum = (TextView) view.findViewById(R.id.quiz_question_num);
        this.resumeQuiz = (TextView) view.findViewById(R.id.playTextTV);
        this.resumeBtn = (ImageView) view.findViewById(R.id.playBtn);
        this.quizTime = (TextView) view.findViewById(R.id.time_slot);
        this.resumeQuizLL = (RelativeLayout) view.findViewById(R.id.resumeQuizLL);
        this.finishQuizLL = (RelativeLayout) view.findViewById(R.id.finishQuizLL);
        this.questionTV = (TestSeriesOptionWebView) view.findViewById(R.id.questionQuizTV);
        this.previousBtn = (Button) view.findViewById(R.id.prevQuizBT);
        this.nextBtn = (Button) view.findViewById(R.id.nextQuizBT);
        this.answerLL = (LinearLayout) view.findViewById(R.id.quizQuestionLL);
        this.quesTimeProgressBar = (ProgressBar) view.findViewById(R.id.timer_progress);
        this.quesRV = (RecyclerView) view.findViewById(R.id.quesRV);
        this.bookmark_ques = (ImageView) view.findViewById(R.id.bookmark_ques);
        this.correctAns = (TextView) view.findViewById(R.id.correctAns);
        this.incorrectAns = (TextView) view.findViewById(R.id.incorrectAns);
        this.coins = (TextView) view.findViewById(R.id.coins);
        this.quiz_swipe_RL = (RelativeLayout) view.findViewById(R.id.quiz_swipe_RL);
        this.clickBlockView = (RelativeLayout) view.findViewById(R.id.clickBlockView);
        this.quizLL = (LinearLayout) view.findViewById(R.id.quizLL);
        this.questionQuizCV = (CardView) view.findViewById(R.id.questionQuizCV);
        this.ques_coontainerRL = (RelativeLayout) view.findViewById(R.id.ques_coontainerRL);
        this.previousBtn.setVisibility(4);
        this.previousBtn.setOnClickListener(this);
        this.nextBtn.setOnClickListener(this);
        this.finishQuizLL.setOnClickListener(this);
        this.resumeQuizLL.setOnClickListener(this);
        this.bookmark_ques.setOnClickListener(this);
    }

    private void setQuestionData(Questions questionText) {
        this.questions = this.quiz.getQuestion_bank().get(this.currentQues);
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
        this.ques_coontainerRL.removeAllViews();
        TestSeriesOptionWebView testSeriesOptionWebView = (TestSeriesOptionWebView) getLayoutInflater().inflate(R.layout.quiz_solution_description, (ViewGroup) null);
        Helper.showWebData(this.activity, Helper.getHtmlUpdatedData(this.questions.getQuestion()), testSeriesOptionWebView);
        testSeriesOptionWebView.setDisableWebViewTouchListener(true);
        this.ques_coontainerRL.addView(testSeriesOptionWebView);
        this.questCountTV.setText((this.currentQues + 1) + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.quiz.getQuestion_bank().size());
        this.quesNum.setText("Q." + (this.currentQues + 1));
        if (this.quiz.getBasic_info().getTest_type().equals("1") || questionText.getQuestion_type().equalsIgnoreCase("MC")) {
            if (!TextUtils.isEmpty(questionText.getOption_1())) {
                this.answerLL.addView(initAnswerMCViews("1", questionText.getOption_1(), this.questions));
            }
            if (!TextUtils.isEmpty(questionText.getOption_2())) {
                this.answerLL.addView(initAnswerMCViews("2", questionText.getOption_2(), this.questions));
            }
            if (!TextUtils.isEmpty(questionText.getOption_3())) {
                this.answerLL.addView(initAnswerMCViews("3", questionText.getOption_3(), this.questions));
            }
            if (!TextUtils.isEmpty(questionText.getOption_4())) {
                this.answerLL.addView(initAnswerMCViews("4", questionText.getOption_4(), this.questions));
            }
            if (!TextUtils.isEmpty(questionText.getOption_5())) {
                this.answerLL.addView(initAnswerMCViews("5", questionText.getOption_5(), this.questions));
            }
        } else if (questionText.getQuestion_type().equalsIgnoreCase("SC") || questionText.getQuestion_type().equalsIgnoreCase("TF")) {
            if (!TextUtils.isEmpty(questionText.getOption_1())) {
                this.answerLL.addView(initAnswerSCViews("1", questionText.getOption_1(), this.questions));
            }
            if (!TextUtils.isEmpty(questionText.getOption_2())) {
                this.answerLL.addView(initAnswerSCViews("2", questionText.getOption_2(), this.questions));
            }
            if (!TextUtils.isEmpty(questionText.getOption_3())) {
                this.answerLL.addView(initAnswerSCViews("3", questionText.getOption_3(), this.questions));
            }
            if (!TextUtils.isEmpty(questionText.getOption_4())) {
                this.answerLL.addView(initAnswerSCViews("4", questionText.getOption_4(), this.questions));
            }
            if (!TextUtils.isEmpty(questionText.getOption_5())) {
                this.answerLL.addView(initAnswerSCViews("5", questionText.getOption_5(), this.questions));
            }
        }
        if (questionText.isAnswered()) {
            blockTouchonViews();
            this.clickBlockView.setVisibility(0);
            this.quizLL.setEnabled(false);
        }
    }

    private LinearLayout initAnswerMCViews(String text, String questions, Questions questionsModel) {
        LinearLayout linearLayout = (LinearLayout) View.inflate(this.activity, R.layout.mcq_quiz, null);
        this.answerTV = (TestSeriesOptionWebView) linearLayout.findViewById(R.id.optionTextTV);
        this.optionIconTV = (TextView) linearLayout.findViewById(R.id.optionIconTV);
        this.mcqItemLL = (LinearLayout) linearLayout.findViewById(R.id.mcqlayout_LL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(3, 3, 3, 3);
        this.mcqItemLL.setLayoutParams(layoutParams);
        if (questionsModel.isAnswered()) {
            for (String str : questionsModel.getUser_answer().split(Constants.SEPARATOR_COMMA)) {
                if (str.equals(text)) {
                    Helper.showWebData(this.activity, Helper.getHtmlUpdatedData(questions), this.answerTV);
                    this.answerTV.setDisableWebViewTouchListener(true);
                    this.optionIconTV.setText(text + InstructionFileId.DOT);
                    linearLayout.setBackgroundResource(R.drawable.quiz_options_bg_green);
                } else {
                    Helper.showWebData(this.activity, Helper.getHtmlUpdatedData(questions), this.answerTV);
                    this.answerTV.setDisableWebViewTouchListener(true);
                    this.optionIconTV.setText(text + InstructionFileId.DOT);
                }
            }
        } else {
            Helper.showWebData(this.activity, Helper.getHtmlUpdatedData(questions), this.answerTV);
            this.answerTV.setDisableWebViewTouchListener(true);
            this.optionIconTV.setText(text + InstructionFileId.DOT);
        }
        this.mcqItemLL.setTag(R.id.questions, this.optionIconTV.getText().toString());
        LinearLayout linearLayout2 = this.mcqItemLL;
        linearLayout2.setTag(R.id.optionsAns, linearLayout2);
        this.mcqItemLL.setOnClickListener(this.optionClickListener);
        this.viewArrayList.add(this.mcqItemLL);
        return linearLayout;
    }

    private LinearLayout initAnswerSCViews(String text, String questions, Questions questionsModel) {
        LinearLayout linearLayout = (LinearLayout) View.inflate(this.activity, R.layout.mcq_quiz, null);
        RelativeLayout relativeLayout = (RelativeLayout) linearLayout.getChildAt(1);
        this.answerTV = (TestSeriesOptionWebView) linearLayout.findViewById(R.id.optionTextTV);
        this.optionIconTV = (TextView) linearLayout.findViewById(R.id.optionIconTV);
        this.mcqItemLL = (LinearLayout) linearLayout.findViewById(R.id.mcqlayout_LL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(3, 3, 3, 3);
        this.mcqItemLL.setLayoutParams(layoutParams);
        if (questionsModel.isAnswered() && questionsModel.getUser_answer().equals(text)) {
            Helper.showWebData(this.activity, Helper.getHtmlUpdatedData(questions), this.answerTV);
            this.answerTV.setDisableWebViewTouchListener(true);
            this.optionIconTV.setText(text + InstructionFileId.DOT);
            if (questionsModel.getAnswer().equals(text)) {
                relativeLayout.setBackgroundResource(R.drawable.quiz_options_bg_green);
            }
            if (questionsModel.getUser_answer().equals(text)) {
                if (questionsModel.getUser_answer().equals(questionsModel.getAnswer())) {
                    relativeLayout.setBackgroundResource(R.drawable.quiz_options_bg_green);
                } else {
                    relativeLayout.setBackgroundResource(R.drawable.quiz_options_bg_red);
                }
            }
        } else {
            Helper.showWebData(this.activity, Helper.getHtmlUpdatedData(questions), this.answerTV);
            this.answerTV.setDisableWebViewTouchListener(true);
            this.optionIconTV.setText(text + InstructionFileId.DOT);
        }
        this.mcqItemLL.setTag(R.id.questions, this.optionIconTV.getText().toString());
        LinearLayout linearLayout2 = this.mcqItemLL;
        linearLayout2.setTag(R.id.optionsAns, linearLayout2);
        this.mcqItemLL.setOnClickListener(this.optionClickListener);
        this.viewArrayList.add(this.mcqItemLL);
        return linearLayout;
    }

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.frag_type = getArguments().getString(Const.FRAG_TYPE);
            this.quiz = (QuizModel) getArguments().getSerializable("test_series");
            if (getArguments().containsKey(Const.PRACTICE) && getArguments().getString(Const.PRACTICE).equalsIgnoreCase(Const.QUIZ)) {
                this.practiceOrQuiz = false;
            } else {
                this.practiceOrQuiz = true;
            }
        }
        this.activity = getActivity();
        this.viewArrayList = new ArrayList<>();
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (apitype.equals(API.API_COMPLETE_INFO_TESTSERIES)) {
            return service.completeInfoTestSeries(SharedPreference.getInstance().getLoggedInUser().getId(), this.quiz.getBasic_info().getId(), String.valueOf(this.timeinSeconds), this.question_dump.toString());
        }
        return null;
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void SuccessCallBack(JSONObject jsonobject, String apitype, String typeApi, boolean showprogress) throws JSONException {
        Gson gson = new Gson();
        apitype.hashCode();
        if (apitype.equals(API.API_COMPLETE_INFO_TESTSERIES)) {
            if (jsonobject.optBoolean("status")) {
                ResultTestSeries resultTestSeries = (ResultTestSeries) gson.fromJson(jsonobject.getJSONObject("data").toString(), ResultTestSeries.class);
                SharedPreference.getInstance().putString(Const.QUIZSTATUS, Const.FINISH);
                this.mcountDown.cancel();
                Intent intent = new Intent(this.activity, (Class<?>) QuizActivity.class);
                intent.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                intent.putExtra("test_series", this.quiz);
                intent.putExtra(Const.RESULT_SCREEN, resultTestSeries);
                this.activity.startActivity(intent);
                this.activity.finish();
                return;
            }
            ErrorCallBack(jsonobject.optString("message"), apitype, typeApi);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Quiz quiz;
        switch (v.getId()) {
            case R.id.finishQuizLL /* 2131363333 */:
                showFinishPopup();
                break;
            case R.id.nextQuizBT /* 2131364417 */:
                clearQuestionView();
                if (!TextUtils.isEmpty(this.quiz.getQuestion_bank().get(this.currentQues).getUser_answer())) {
                    this.quiz.getQuestion_bank().get(this.currentQues).setAnswered(true);
                    ((QuizActivity) this.activity).navigationQuizAdapter.notifyDataSetChanged();
                    this.ibtNavigationQuizAdapter.notifyDataSetChanged();
                }
                if (this.quiz.getQuestion_bank().size() == this.currentQues + 1) {
                    this.question_dump = new JsonArray();
                    for (Questions questions : this.quiz.getQuestion_bank()) {
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty(Const.QUESTIONID, questions.getId());
                        jsonObject.addProperty(Const.ANSWER, TextUtils.isEmpty(questions.getUser_answer()) ? "" : questions.getUser_answer());
                        this.question_dump.add(jsonObject);
                    }
                    quiz = this;
                    quiz.NetworkAPICall(API.API_COMPLETE_INFO_TESTSERIES, "", true, false, false);
                } else {
                    quiz = this;
                    int size = quiz.quiz.getQuestion_bank().size();
                    int i = quiz.currentQues;
                    if (size == i + 2) {
                        quiz.currentQues = i + 1;
                        quiz.nextBtn.setText(quiz.activity.getResources().getString(R.string.submit_rev));
                        setQuestionData(quiz.quiz.getQuestion_bank().get(quiz.currentQues));
                    } else {
                        quiz.currentQues = i + 1;
                        setQuestionData(quiz.quiz.getQuestion_bank().get(quiz.currentQues));
                    }
                }
                quiz.ibtNavigationQuizAdapter.notifyDataSetChanged();
                break;
            case R.id.prevQuizBT /* 2131364772 */:
                if (!TextUtils.isEmpty(this.quiz.getQuestion_bank().get(this.currentQues).getUser_answer())) {
                    this.quiz.getQuestion_bank().get(this.currentQues).setAnswered(true);
                    ((QuizActivity) this.activity).navigationQuizAdapter.notifyDataSetChanged();
                    this.ibtNavigationQuizAdapter.notifyDataSetChanged();
                }
                int i2 = this.currentQues;
                if (i2 != 0) {
                    this.currentQues = i2 - 1;
                }
                this.nextBtn.setText(this.activity.getResources().getString(R.string.next));
                setQuestionData(this.quiz.getQuestion_bank().get(this.currentQues));
                this.ibtNavigationQuizAdapter.notifyDataSetChanged();
                break;
            case R.id.resumeQuizLL /* 2131365095 */:
                this.resumeBtn.setImageResource(R.mipmap.download_pause);
                showResumePopup(true);
                break;
        }
    }

    private void showFinishPopup() {
        Activity activity = this.activity;
        DialogUtils.makeDialog(activity, activity.getResources().getString(R.string.app_name), this.activity.getResources().getString(R.string.finishQuiz), this.activity.getResources().getString(R.string.submits), this.activity.getResources().getString(R.string.resume), true, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Courses.Fragment.Quiz.4
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
            public void onOKClick() {
                Quiz.this.question_dump = new JsonArray();
                for (Questions questions : Quiz.this.quiz.getQuestion_bank()) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty(Const.QUESTIONID, questions.getId());
                    jsonObject.addProperty(Const.ANSWER, TextUtils.isEmpty(questions.getUser_answer()) ? "" : questions.getUser_answer());
                    Quiz.this.question_dump.add(jsonObject);
                }
                Quiz.this.mcountDown.cancel();
                Quiz.this.NetworkAPICall(API.API_COMPLETE_INFO_TESTSERIES, "", true, false, false);
            }
        }, new DialogUtils.onDialogUtilsCancelClick() { // from class: com.appnew.android.Courses.Fragment.Quiz.5
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsCancelClick
            public void onCancelClick() {
            }
        });
    }

    public void showResumePopup(boolean callingMethod) {
        if (callingMethod) {
            Activity activity = this.activity;
            DialogUtils.makeDialog(activity, activity.getResources().getString(R.string.app_name), this.activity.getResources().getString(R.string.pauseQuiz), this.activity.getResources().getString(R.string.pause), this.activity.getResources().getString(R.string.cancel), true, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Courses.Fragment.Quiz.6
                @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
                public void onOKClick() {
                    Quiz.this.quiz.getBasic_info().setTime_in_mins(String.valueOf(Quiz.this.timeinMillis));
                    Quiz.this.quiz.setResume(true);
                    Quiz.this.quiz.setQuesCount(Quiz.this.currentQues);
                    Quiz.this.mcountDown.cancel();
                    Quiz.this.activity.finish();
                }
            }, new DialogUtils.onDialogUtilsCancelClick() { // from class: com.appnew.android.Courses.Fragment.Quiz.7
                @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsCancelClick
                public void onCancelClick() {
                }
            });
        } else {
            Activity activity2 = this.activity;
            DialogUtils.makeDialog(activity2, activity2.getResources().getString(R.string.app_name), this.activity.getResources().getString(R.string.quitQuiz), this.activity.getResources().getString(R.string.yes), this.activity.getResources().getString(R.string.no), true, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.Courses.Fragment.Quiz.8
                @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
                public void onOKClick() {
                    Quiz.this.quiz.getBasic_info().setTime_in_mins(String.valueOf(Quiz.this.timeinMillis));
                    Quiz.this.quiz.setResume(true);
                    Quiz.this.quiz.setQuesCount(Quiz.this.currentQues);
                    Quiz.this.mcountDown.cancel();
                    Quiz.this.activity.finish();
                }
            }, new DialogUtils.onDialogUtilsCancelClick() { // from class: com.appnew.android.Courses.Fragment.Quiz.9
                @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsCancelClick
                public void onCancelClick() {
                }
            });
        }
    }

    void blockTouchonViews() {
        Iterator<View> it = this.viewArrayList.iterator();
        while (it.hasNext()) {
            it.next().setOnClickListener(null);
        }
    }
}
