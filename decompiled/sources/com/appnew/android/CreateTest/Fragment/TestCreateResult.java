package com.appnew.android.CreateTest.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.appnew.android.CreateTest.Activity.CreateTestSolutionActivity;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.MainFragment;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.testmodule.model.Answers;
import com.appnew.android.testmodule.model.FIBEdit;
import com.appnew.android.testmodule.model.Question;
import com.appnew.android.testmodule.model.TestseriesBase;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class TestCreateResult extends MainFragment {
    TextView not_visited;
    TextView resultAccuracyTV;
    TextView resultAttemptTV;
    TextView resultAttemptedTV;
    TextView resultBookmarkTV;
    TextView resultCorrectTV;
    TextView resultIncorrectTV;
    TextView resultNameTV;
    TextView resultPercentileTV;
    TextView resultScoreTV;
    TextView resultUnAttemptTV;
    LinearLayout resultViewSolution;
    TestseriesBase testseriesBase;
    String frag_type = "";
    String questionlist = "";
    String response = "";
    List<Answers> answersList = new ArrayList();
    List<Question> questionList = new ArrayList();
    List<Question> questionListhindi = new ArrayList();
    int not_visited_count = 0;
    int answer_count = 0;
    int worong_answer = 0;
    int unansweredcount = 0;
    int sectionwisebookmarkcount = 0;

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

    public static Fragment newInstance(String revision_string, String questionlist, TestseriesBase testseriesBase) {
        TestCreateResult testCreateResult = new TestCreateResult();
        Bundle bundle = new Bundle();
        bundle.putSerializable("test_series", revision_string);
        bundle.putSerializable("questionlist", questionlist);
        bundle.putSerializable("testseriesBase", testseriesBase);
        testCreateResult.setArguments(bundle);
        return testCreateResult;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.create_test_result_screen, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        try {
            this.resultNameTV = (TextView) view.findViewById(R.id.resultNameTV);
            this.resultCorrectTV = (TextView) view.findViewById(R.id.resultCorrectTV);
            this.resultIncorrectTV = (TextView) view.findViewById(R.id.resultIncorrectTV);
            this.resultAttemptTV = (TextView) view.findViewById(R.id.resultAttemptTV);
            this.resultAccuracyTV = (TextView) view.findViewById(R.id.resultAccuracyTV);
            this.resultUnAttemptTV = (TextView) view.findViewById(R.id.resultUnAttemptTV);
            this.not_visited = (TextView) view.findViewById(R.id.not_visited);
            this.resultScoreTV = (TextView) view.findViewById(R.id.resultScoreTV);
            this.resultAttemptedTV = (TextView) view.findViewById(R.id.resultAttemptedTV);
            this.resultPercentileTV = (TextView) view.findViewById(R.id.resultPercentileTV);
            this.resultViewSolution = (LinearLayout) view.findViewById(R.id.resultViewSolution);
            this.resultBookmarkTV = (TextView) view.findViewById(R.id.resultBookmarkTV);
            this.resultScoreTV.setText("" + this.answer_count);
            this.resultCorrectTV.setText("" + this.answer_count + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.questionList.size());
            this.resultIncorrectTV.setText("" + this.worong_answer + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.questionList.size());
            this.resultAttemptTV.setText("" + (this.answer_count + this.worong_answer) + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.questionList.size());
            this.resultAttemptedTV.setText("" + (this.answer_count + this.worong_answer) + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.questionList.size());
            this.resultUnAttemptTV.setText("" + this.unansweredcount + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.questionList.size());
            this.not_visited.setText("" + this.not_visited_count + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.questionList.size());
            this.resultBookmarkTV.setText("" + this.sectionwisebookmarkcount + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.questionList.size());
            int size = (this.answer_count * 100) / this.questionList.size();
            this.resultPercentileTV.setText("" + size + "%");
            if (size <= 30) {
                this.resultNameTV.setText(this.activity.getResources().getString(R.string.need_to_do_work_hard) + SharedPreference.getInstance().getLoggedInUser().getName() + "!");
            } else if (size > 30 && size <= 70) {
                this.resultNameTV.setText(this.activity.getResources().getString(R.string.you_can_improve_yourself) + SharedPreference.getInstance().getLoggedInUser().getName() + "!");
            } else if (size <= 70 || size > 90) {
                this.resultNameTV.setText(this.activity.getResources().getString(R.string.excellent_work) + SharedPreference.getInstance().getLoggedInUser().getName() + "!");
            } else {
                this.resultNameTV.setText(this.activity.getResources().getString(R.string.good_work) + SharedPreference.getInstance().getLoggedInUser().getName() + "!");
            }
            int i = this.answer_count;
            if (i == 0 || i + this.worong_answer == 0) {
                this.resultAccuracyTV.setText("0%");
            } else {
                TextView textView = this.resultAccuracyTV;
                StringBuilder sb = new StringBuilder("");
                int i2 = this.answer_count;
                textView.setText(sb.append((i2 * 100) / (i2 + this.worong_answer)).append("%").toString());
            }
            this.resultViewSolution.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.CreateTest.Fragment.TestCreateResult$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$initViews$0(view2);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$0(View view) {
        SharedPreference.getInstance().putString("testseriesBase", new Gson().toJson(this.testseriesBase));
        Intent intent = new Intent(this.activity, (Class<?>) CreateTestSolutionActivity.class);
        intent.putExtra("answerlist", this.frag_type);
        Helper.gotoActivity(intent, this.activity);
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

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        FIBEdit fIBEdit;
        int i;
        int i2;
        FIBEdit fIBEdit2;
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.frag_type = getArguments().getString("test_series");
            this.response = getArguments().getString("questionlist");
            this.testseriesBase = (TestseriesBase) new Gson().fromJson(this.response, new TypeToken<TestseriesBase>() { // from class: com.appnew.android.CreateTest.Fragment.TestCreateResult.1
            }.getType());
            this.answersList = (List) new Gson().fromJson(this.frag_type, new TypeToken<ArrayList<Answers>>() { // from class: com.appnew.android.CreateTest.Fragment.TestCreateResult.2
            }.getType());
            int i3 = 0;
            if (this.testseriesBase.getData().getTestBasic() != null && this.testseriesBase.getData().getTestBasic().getLangId() != null && this.testseriesBase.getData().getTestBasic().getLangId().size() == 2) {
                if (this.testseriesBase.getData().getTestBasic().getLangId().get(0).equalsIgnoreCase("1")) {
                    this.questionList = this.testseriesBase.getData().getQuestions();
                    this.questionListhindi = this.testseriesBase.getData().getQuestionsHindi();
                } else if (this.testseriesBase.getData().getTestBasic().getLangId().get(0).equalsIgnoreCase("2")) {
                    this.questionList = this.testseriesBase.getData().getQuestionsHindi();
                    this.questionListhindi = this.testseriesBase.getData().getQuestions();
                }
                int i4 = 0;
                while (i4 < this.questionList.size()) {
                    int i5 = i3;
                    while (true) {
                        if (i5 >= this.answersList.size()) {
                            i = i4;
                            break;
                        }
                        Question question = this.questionList.get(i4);
                        Question question2 = this.questionListhindi.get(i4);
                        Answers answers = this.answersList.get(i5);
                        if (question.getConfigId().equalsIgnoreCase(answers.getConfig_id())) {
                            if (question.getQuestionType().equalsIgnoreCase("FIB")) {
                                ArrayList arrayList = new ArrayList();
                                int i6 = 0;
                                while (i6 < countFIBWords(question.getQuestion().trim())) {
                                    if (i6 == 0) {
                                        i2 = i4;
                                        fIBEdit2 = (FIBEdit) new Gson().fromJson(question.getOption1().trim(), FIBEdit.class);
                                    } else {
                                        i2 = i4;
                                        if (i6 == 1) {
                                            fIBEdit2 = (FIBEdit) new Gson().fromJson(question.getOption2().trim(), FIBEdit.class);
                                        } else if (i6 == 2) {
                                            fIBEdit2 = (FIBEdit) new Gson().fromJson(question.getOption3().trim(), FIBEdit.class);
                                        } else if (i6 == 3) {
                                            fIBEdit2 = (FIBEdit) new Gson().fromJson(question.getOption4().trim(), FIBEdit.class);
                                        } else if (i6 == 4) {
                                            fIBEdit2 = (FIBEdit) new Gson().fromJson(question.getOption5().trim(), FIBEdit.class);
                                        } else {
                                            fIBEdit2 = i6 == 5 ? (FIBEdit) new Gson().fromJson(question.getOption6().trim(), FIBEdit.class) : null;
                                        }
                                    }
                                    if (fIBEdit2 != null && !fIBEdit2.getType().equalsIgnoreCase("")) {
                                        arrayList.add(fIBEdit2);
                                    }
                                    i6++;
                                    i4 = i2;
                                }
                                i = i4;
                                String str = "";
                                for (int i7 = 0; i7 < arrayList.size(); i7++) {
                                    if (!((FIBEdit) arrayList.get(i7)).getAnswer().toString().equalsIgnoreCase("")) {
                                        str = str + ((FIBEdit) arrayList.get(i7)).getAnswer();
                                    }
                                }
                                String str2 = "";
                                for (int i8 = 0; i8 < answers.getAnswers().size(); i8++) {
                                    if (!answers.getAnswers().get(i8).toString().equalsIgnoreCase("")) {
                                        str2 = str2 + answers.getAnswers().get(i8);
                                    }
                                }
                                if (!TextUtils.isEmpty(str2)) {
                                    if (str.trim().equalsIgnoreCase(str2.trim())) {
                                        question.setIsCorrect("1");
                                        question2.setIsCorrect("1");
                                        this.answer_count++;
                                    } else {
                                        question.setIsCorrect("0");
                                        question2.setIsCorrect("0");
                                        this.worong_answer++;
                                    }
                                } else if (answers.getIs_bookmarked().equalsIgnoreCase("1")) {
                                    question.setIsCorrect("0");
                                    question2.setIsCorrect("0");
                                    this.sectionwisebookmarkcount++;
                                    break;
                                } else if (answers.getState().equalsIgnoreCase("not_visited")) {
                                    question.setIsCorrect("0");
                                    question2.setIsCorrect("0");
                                    this.not_visited_count++;
                                    break;
                                } else if (answers.getAnswers().size() <= 0) {
                                    if (answers.getState().equalsIgnoreCase("unanswered")) {
                                        question.setIsCorrect("0");
                                        question2.setIsCorrect("0");
                                        this.unansweredcount++;
                                    }
                                } else if (answers.getState().equalsIgnoreCase("unanswered")) {
                                    question.setIsCorrect("0");
                                    question2.setIsCorrect("0");
                                    this.unansweredcount++;
                                    break;
                                }
                            } else {
                                i = i4;
                                if (question.getAnswer().equalsIgnoreCase(answers.getUser_answer())) {
                                    question.setIsCorrect("1");
                                    question2.setIsCorrect("1");
                                    this.answer_count++;
                                    break;
                                }
                                if (answers.getIs_bookmarked().equalsIgnoreCase("1")) {
                                    question.setIsCorrect("0");
                                    question2.setIsCorrect("0");
                                    this.sectionwisebookmarkcount++;
                                    break;
                                } else if (answers.getState().equalsIgnoreCase("not_visited")) {
                                    question.setIsCorrect("0");
                                    question2.setIsCorrect("0");
                                    this.not_visited_count++;
                                    break;
                                } else if (answers.getUser_answer().equalsIgnoreCase("")) {
                                    if (answers.getState().equalsIgnoreCase("unanswered")) {
                                        question.setIsCorrect("0");
                                        question2.setIsCorrect("0");
                                        this.unansweredcount++;
                                    }
                                } else if (!question.getAnswer().equalsIgnoreCase(answers.getUser_answer())) {
                                    question.setIsCorrect("0");
                                    question2.setIsCorrect("0");
                                    this.worong_answer++;
                                    break;
                                }
                            }
                        } else {
                            i = i4;
                        }
                        i5++;
                        i4 = i;
                    }
                    i4 = i + 1;
                    i3 = 0;
                }
            } else {
                List<Question> questions = this.testseriesBase.getData().getQuestions();
                this.questionList = questions;
                if (questions != null && questions.size() == this.answersList.size()) {
                    for (Question question3 : this.questionList) {
                        Iterator<Answers> it = this.answersList.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                Answers next = it.next();
                                if (question3.getConfigId().equalsIgnoreCase(next.getConfig_id())) {
                                    if (question3.getQuestionType().equalsIgnoreCase("FIB")) {
                                        ArrayList arrayList2 = new ArrayList();
                                        int i9 = 0;
                                        while (i9 < countFIBWords(question3.getQuestion().trim())) {
                                            if (i9 == 0) {
                                                fIBEdit = (FIBEdit) new Gson().fromJson(question3.getOption1().trim(), FIBEdit.class);
                                            } else if (i9 == 1) {
                                                fIBEdit = (FIBEdit) new Gson().fromJson(question3.getOption2().trim(), FIBEdit.class);
                                            } else if (i9 == 2) {
                                                fIBEdit = (FIBEdit) new Gson().fromJson(question3.getOption3().trim(), FIBEdit.class);
                                            } else if (i9 == 3) {
                                                fIBEdit = (FIBEdit) new Gson().fromJson(question3.getOption4().trim(), FIBEdit.class);
                                            } else if (i9 == 4) {
                                                fIBEdit = (FIBEdit) new Gson().fromJson(question3.getOption5().trim(), FIBEdit.class);
                                            } else {
                                                fIBEdit = i9 == 5 ? (FIBEdit) new Gson().fromJson(question3.getOption6().trim(), FIBEdit.class) : null;
                                            }
                                            if (fIBEdit != null && !fIBEdit.getType().equalsIgnoreCase("")) {
                                                arrayList2.add(fIBEdit);
                                            }
                                            i9++;
                                        }
                                        String str3 = "";
                                        for (int i10 = 0; i10 < arrayList2.size(); i10++) {
                                            if (!((FIBEdit) arrayList2.get(i10)).getAnswer().toString().equalsIgnoreCase("")) {
                                                str3 = str3 + ((FIBEdit) arrayList2.get(i10)).getAnswer();
                                            }
                                        }
                                        String str4 = "";
                                        for (int i11 = 0; i11 < next.getAnswers().size(); i11++) {
                                            if (!next.getAnswers().get(i11).toString().equalsIgnoreCase("")) {
                                                str4 = str4 + next.getAnswers().get(i11);
                                            }
                                        }
                                        if (!TextUtils.isEmpty(str4)) {
                                            if (str3.trim().equalsIgnoreCase(str4.trim())) {
                                                question3.setIsCorrect("1");
                                                this.answer_count++;
                                            } else {
                                                question3.setIsCorrect("0");
                                                this.worong_answer++;
                                            }
                                        } else {
                                            if (next.getIs_bookmarked().equalsIgnoreCase("1")) {
                                                question3.setIsCorrect("0");
                                                this.sectionwisebookmarkcount++;
                                                break;
                                            }
                                            if (next.getState().equalsIgnoreCase("not_visited")) {
                                                question3.setIsCorrect("0");
                                                this.not_visited_count++;
                                                break;
                                            } else if (next.getAnswers().size() <= 0) {
                                                if (next.getState().equalsIgnoreCase("unanswered")) {
                                                    question3.setIsCorrect("0");
                                                    this.unansweredcount++;
                                                }
                                            } else if (next.getState().equalsIgnoreCase("unanswered")) {
                                                question3.setIsCorrect("0");
                                                this.unansweredcount++;
                                                break;
                                            }
                                        }
                                    } else {
                                        if (question3.getAnswer().equalsIgnoreCase(next.getUser_answer())) {
                                            question3.setIsCorrect("1");
                                            this.answer_count++;
                                            break;
                                        }
                                        if (next.getIs_bookmarked().equalsIgnoreCase("1")) {
                                            question3.setIsCorrect("0");
                                            this.sectionwisebookmarkcount++;
                                            break;
                                        }
                                        if (next.getState().equalsIgnoreCase("not_visited")) {
                                            question3.setIsCorrect("0");
                                            this.not_visited_count++;
                                            break;
                                        } else if (next.getUser_answer().equalsIgnoreCase("")) {
                                            if (next.getState().equalsIgnoreCase("unanswered")) {
                                                question3.setIsCorrect("0");
                                                this.unansweredcount++;
                                            }
                                        } else if (!question3.getAnswer().equalsIgnoreCase(next.getUser_answer())) {
                                            question3.setIsCorrect("0");
                                            this.worong_answer++;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        this.activity = getActivity();
    }
}
