package com.appnew.android.Webview;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.MainFragment;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.testmodule.model.Answers;
import com.appnew.android.testmodule.model.Question;
import com.appnew.android.testmodule.model.TestseriesBase;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class RevisionResult extends MainFragment {
    TextView not_visited;
    TextView resultAccuracyTV;
    TextView resultAttemptTV;
    TextView resultAttemptedTV;
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
    List<Answers> answersList = new ArrayList();
    List<Question> questionList = new ArrayList();
    int not_visited_count = 0;
    int answer_count = 0;
    int worong_answer = 0;
    int unansweredcount = 0;

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
        RevisionResult revisionResult = new RevisionResult();
        Bundle bundle = new Bundle();
        bundle.putSerializable("test_series", revision_string);
        bundle.putSerializable("questionlist", questionlist);
        bundle.putSerializable("testseriesBase", testseriesBase);
        revisionResult.setArguments(bundle);
        return revisionResult;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.revision_result_scrren, container, false);
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
            this.resultScoreTV.setText("" + this.answer_count);
            this.resultCorrectTV.setText("" + this.answer_count + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.questionList.size());
            this.resultIncorrectTV.setText("" + this.worong_answer + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.questionList.size());
            this.resultAttemptTV.setText("" + (this.answer_count + this.worong_answer) + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.questionList.size());
            this.resultAttemptedTV.setText("" + (this.answer_count + this.worong_answer) + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.questionList.size());
            this.resultUnAttemptTV.setText("" + this.unansweredcount + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.questionList.size());
            this.not_visited.setText("" + this.not_visited_count + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.questionList.size());
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
                this.resultAccuracyTV.setText(this.activity.getResources().getString(R.string.percent));
            } else {
                TextView textView = this.resultAccuracyTV;
                StringBuilder sb = new StringBuilder("");
                int i2 = this.answer_count;
                textView.setText(sb.append((i2 * 100) / (i2 + this.worong_answer)).append("%").toString());
            }
            this.resultViewSolution.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Webview.RevisionResult$$ExternalSyntheticLambda0
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
        Intent intent = new Intent(this.activity, (Class<?>) RevisionSolutionActivity.class);
        intent.putExtra("testseriesBase", this.testseriesBase);
        intent.putExtra("answerlist", this.frag_type);
        Helper.gotoActivity(intent, this.activity);
    }

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.frag_type = getArguments().getString("test_series");
            TestseriesBase testseriesBase = (TestseriesBase) ((Bundle) Objects.requireNonNull(getArguments())).getSerializable("testseriesBase");
            this.testseriesBase = testseriesBase;
            this.questionList = testseriesBase.getData().getQuestions();
            this.answersList = (List) new Gson().fromJson(this.frag_type, new TypeToken<ArrayList<Answers>>() { // from class: com.appnew.android.Webview.RevisionResult.1
            }.getType());
            List<Question> list = this.questionList;
            if (list != null && list.size() == this.answersList.size()) {
                for (Question question : this.questionList) {
                    Iterator<Answers> it = this.answersList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Answers next = it.next();
                            if (question.getId().equalsIgnoreCase(next.getConfig_id())) {
                                if (question.getRight_answer().equalsIgnoreCase(next.getUser_answer())) {
                                    question.setIsCorrect("1");
                                    this.answer_count++;
                                    break;
                                }
                                if (next.getState().equalsIgnoreCase("not_visited")) {
                                    question.setIsCorrect("0");
                                    this.not_visited_count++;
                                    break;
                                } else if (next.getUser_answer().equalsIgnoreCase("")) {
                                    if (next.getState().equalsIgnoreCase("unanswered")) {
                                        question.setIsCorrect("0");
                                        this.unansweredcount++;
                                    }
                                } else if (!question.getRight_answer().equalsIgnoreCase(next.getUser_answer())) {
                                    question.setIsCorrect("0");
                                    this.worong_answer++;
                                    break;
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
