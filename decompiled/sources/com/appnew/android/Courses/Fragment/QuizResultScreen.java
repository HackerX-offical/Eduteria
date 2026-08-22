package com.appnew.android.Courses.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import com.appnew.android.Courses.Activity.QuizActivity;
import com.appnew.android.Model.Courses.quiz.QuizModel;
import com.appnew.android.Model.Courses.quiz.ResultTestSeries;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.MainFragment;
import com.appnew.android.Utils.SharedPreference;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class QuizResultScreen extends MainFragment implements View.OnClickListener {
    Activity activity;
    TextView correctTV;
    ImageView leaderboardIV;
    NestedScrollView mainLL;
    TextView name;
    LinearLayout questionDistrLL;
    QuizModel quiz;
    TextView rank;
    LinearLayout rankLL;
    ImageView rankreloadIV;
    ResultTestSeries resultTestSeries;
    TextView rewardsValueTV;
    TextView score;
    LinearLayout shareRank;
    TextView timeSpent;
    TextView titleTestSeries;
    TextView unattemptedTV;
    TextView wrongTV;
    String frag_type = "";
    String status = "";

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    public static QuizResultScreen newInstance(String frag_type, ResultTestSeries resultTestSeries, QuizModel quiz) {
        QuizResultScreen quizResultScreen = new QuizResultScreen();
        Bundle bundle = new Bundle();
        bundle.putSerializable("test_series", resultTestSeries);
        bundle.putSerializable(Const.FRAG_TYPE, frag_type);
        bundle.putSerializable(Const.RESULT_SCREEN, quiz);
        quizResultScreen.setArguments(bundle);
        return quizResultScreen;
    }

    public static Fragment newInstance(String frag_type, String status) {
        QuizResultScreen quizResultScreen = new QuizResultScreen();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Const.FRAG_TYPE, frag_type);
        bundle.putSerializable("status", status);
        quizResultScreen.setArguments(bundle);
        return quizResultScreen;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        if (!TextUtils.isEmpty(this.status)) {
            NetworkAPICall(API.API_GET_USER_LEADERBOARD_RESULT, "", true, false, false);
        } else {
            generateResultData();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_quiz_result_screen, container, false);
    }

    private void generateResultData() {
        if (this.mainLL.getVisibility() == 8) {
            this.mainLL.setVisibility(0);
        }
        String id = this.resultTestSeries.getId();
        this.status = id;
        this.titleTestSeries.setText(TextUtils.isEmpty(id) ? this.quiz.getBasic_info().getTest_series_name() : this.resultTestSeries.getTest_series_name());
        this.score.setText(this.resultTestSeries.getMarks() + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.resultTestSeries.getTest_series_marks());
        this.rank.setText(this.resultTestSeries.getUser_rank() + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.resultTestSeries.getTotal_user_attempt());
        this.timeSpent.setText(String.format("%sm %ss", Integer.valueOf(Integer.parseInt(this.resultTestSeries.getTime_spent()) / 60), Integer.valueOf(Integer.parseInt(this.resultTestSeries.getTime_spent()) % 60)) + MqttTopic.TOPIC_LEVEL_SEPARATOR + String.format("%sm", this.resultTestSeries.getTotal_test_series_time()));
        this.name.setText(SharedPreference.getInstance().getLoggedInUser().getName());
        this.correctTV.setText(String.format("%s Correct", this.resultTestSeries.getCorrect_count()));
        this.wrongTV.setText(String.format("%s Wrong", this.resultTestSeries.getIncorrect_count()));
        this.unattemptedTV.setText(String.format("%s Unattempted", this.resultTestSeries.getNon_attempt()));
        this.rewardsValueTV.setText(String.format("%s Points", this.resultTestSeries.getReward_points()));
        if (this.resultTestSeries.getSkip_rank().equals("1")) {
            this.rankLL.setVisibility(8);
        } else {
            this.rankLL.setVisibility(0);
        }
    }

    private void initViews(View view) {
        this.name = (TextView) view.findViewById(R.id.nameValueTV);
        this.score = (TextView) view.findViewById(R.id.scoreValueTV);
        this.rank = (TextView) view.findViewById(R.id.rankValueTV);
        this.timeSpent = (TextView) view.findViewById(R.id.timeSpentValueTV);
        this.titleTestSeries = (TextView) view.findViewById(R.id.testSeriesnameTV);
        this.shareRank = (LinearLayout) view.findViewById(R.id.shareRankLL);
        this.rankLL = (LinearLayout) view.findViewById(R.id.rankLL);
        this.correctTV = (TextView) view.findViewById(R.id.correctTv);
        this.wrongTV = (TextView) view.findViewById(R.id.wrongTv);
        this.unattemptedTV = (TextView) view.findViewById(R.id.unattemptedTv);
        this.rewardsValueTV = (TextView) view.findViewById(R.id.rewardsValueTV);
        this.rankreloadIV = (ImageView) view.findViewById(R.id.rankreloadIV);
        this.questionDistrLL = (LinearLayout) view.findViewById(R.id.questionDistrLL);
        this.mainLL = (NestedScrollView) view.findViewById(R.id.mainLL);
        this.leaderboardIV = (ImageView) view.findViewById(R.id.leaderboardIV);
        this.rankreloadIV.setOnClickListener(this);
        this.leaderboardIV.setOnClickListener(this);
        this.shareRank.setOnClickListener(this);
    }

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.frag_type = getArguments().getString(Const.FRAG_TYPE);
            this.resultTestSeries = (ResultTestSeries) getArguments().getSerializable("test_series");
            this.quiz = (QuizModel) getArguments().getSerializable(Const.RESULT_SCREEN);
            this.status = getArguments().getString("status");
        }
        this.activity = getActivity();
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (apitype.equals(API.API_GET_USER_LEADERBOARD_RESULT)) {
            return service.getUserLeaderBoardResult(SharedPreference.getInstance().getLoggedInUser().getId(), this.status);
        }
        return null;
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void SuccessCallBack(JSONObject jsonobject, String apitype, String typeApi, boolean showprogress) throws JSONException {
        Gson gson = new Gson();
        apitype.hashCode();
        if (apitype.equals(API.API_GET_USER_LEADERBOARD_RESULT)) {
            if (jsonobject.optBoolean("status")) {
                this.resultTestSeries = (ResultTestSeries) gson.fromJson(jsonobject.getJSONObject("data").toString(), ResultTestSeries.class);
                generateResultData();
            } else {
                ErrorCallBack(jsonobject.optString("message"), apitype, typeApi);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.leaderboardIV) {
            Intent intent = new Intent(this.activity, (Class<?>) QuizActivity.class);
            intent.putExtra(Const.FRAG_TYPE, Const.LEADERBOARD);
            intent.putExtra(Const.RESULT_SCREEN, this.resultTestSeries);
            intent.putExtra(Const.PRACTICE, "");
            this.activity.startActivity(intent);
            return;
        }
        if (id == R.id.rankreloadIV) {
            NetworkAPICall(API.API_GET_USER_LEADERBOARD_RESULT, "", true, false, false);
        } else {
            if (id != R.id.shareRankLL) {
                return;
            }
            Intent intent2 = new Intent(this.activity, (Class<?>) QuizWebView.class);
            intent2.putExtra(Const.RESULT_SCREEN, this.resultTestSeries);
            intent2.putExtra("status", true);
            this.activity.startActivity(intent2);
        }
    }
}
