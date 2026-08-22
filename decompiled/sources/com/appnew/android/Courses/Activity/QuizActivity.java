package com.appnew.android.Courses.Activity;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import com.appnew.android.Courses.Adapter.NavigationQuizAdapter;
import com.appnew.android.Courses.Fragment.LeaderBoardFragment;
import com.appnew.android.Courses.Fragment.Quiz;
import com.appnew.android.Courses.Fragment.QuizSolutions;
import com.appnew.android.CreateTest.Fragment.TestCreateResult;
import com.appnew.android.LiveClass.interface_.OnDataSendListener;
import com.appnew.android.Model.Courses.quiz.QuizModel;
import com.appnew.android.Model.Courses.quiz.ResultTestSeries;
import com.appnew.android.Utils.AppPermissionsRunTime;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.CustomContextWrapper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Webview.RevisionResult;
import com.appnew.android.home.Activity.BaseABNoNavActivity;
import com.appnew.android.testmodule.fragment.LeaderBoard;
import com.appnew.android.testmodule.fragment.QuizResultScreenNew;
import com.appnew.android.testmodule.model.TestseriesBase;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class QuizActivity extends BaseABNoNavActivity {
    private static OnDataSendListener dataSendListener;
    public ArrayList<AppPermissionsRunTime.MyPermissionConstants> myPermissionConstantsArrayList;
    public NavigationQuizAdapter navigationQuizAdapter;
    private String practiceOrQuiz;
    QuizModel quiz;
    ResultTestSeries resultTestSeries;
    TestseriesBase testseriesBase;
    public int DEFAULT_SPAN_COUNT = 4;
    String frag_type = "";
    String status = "";
    String revision_string = "";
    String questionBankList = "";
    String attemptOrReAttempt = "";
    String live_test_feedback = "";
    String testName = "";
    String first_attempt = "";
    String show_leader = "";
    String response = "";
    String mode = "";
    public final int REQUEST_CODE_PERMISSION_MULTIPLE = 123;
    View.OnClickListener navigatorClickListener = new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.QuizActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (QuizActivity.this.drawer.isDrawerOpen(GravityCompat.END)) {
                QuizActivity.this.drawer.closeDrawer(GravityCompat.END);
            } else {
                QuizActivity.this.drawer.openDrawer(GravityCompat.END);
            }
            ((Quiz) QuizActivity.this.mFragment).initalizeNavigationView();
        }
    };

    @Override // com.appnew.android.home.Activity.BaseABNoNavActivity
    protected boolean addBackButton() {
        return true;
    }

    public static void setOnDataSendListener(OnDataSendListener listener) {
        dataSendListener = listener;
    }

    public void counterCallbackListener(int i) {
        ((Quiz) this.mFragment).controlQuizQuestion(i);
        if (this.drawer.isDrawerOpen(GravityCompat.END)) {
            this.drawer.closeDrawer(GravityCompat.END);
        } else {
            this.drawer.openDrawer(GravityCompat.END);
        }
    }

    public void IBTcounterCallbackListener(int i) {
        ((Quiz) this.mFragment).controlQuizQuestion(i);
    }

    @Override // com.appnew.android.home.Activity.BaseABNoNavActivity
    protected void initViews() {
        if (getIntent().getExtras() != null) {
            this.frag_type = getIntent().getExtras().getString(Const.FRAG_TYPE);
            this.quiz = (QuizModel) getIntent().getExtras().getSerializable("test_series");
            this.resultTestSeries = (ResultTestSeries) getIntent().getExtras().getSerializable(Const.RESULT_SCREEN);
            this.testseriesBase = (TestseriesBase) getIntent().getExtras().getSerializable("testseriesBase");
            this.revision_string = getIntent().getExtras().getString("revision_string");
            this.response = MakeMyExam.object;
            this.questionBankList = MakeMyExam.questionbanklist;
            this.status = getIntent().getExtras().getString("status");
            this.testName = getIntent().getExtras().getString("name");
            this.show_leader = getIntent().getExtras().getString("show_leader");
            this.mode = getIntent().getExtras().getString("mode");
            this.first_attempt = getIntent().getExtras().getString("first_attempt");
            this.attemptOrReAttempt = getIntent().getExtras().getString("attemptOrReAttempt");
            this.live_test_feedback = SharedPreference.getInstance().getString(Const.LIVE_TEST_FEEDBACK);
            Log.d("RESULT_DEBUG_SSC", "status=" + this.status + ", testName=" + this.testName + ", first_attempt=" + this.first_attempt + ", show_leader=" + this.show_leader + ", mode=" + this.mode);
            Log.d("RESULT_DEBUG_SSC", "MakeMyExam.object=" + (MakeMyExam.object != null) + ", questionBank=" + (MakeMyExam.questionbanklist != null));
            if (getIntent().getExtras().containsKey(Const.PRACTICE)) {
                this.practiceOrQuiz = getIntent().getExtras().getString(Const.PRACTICE);
            }
        }
    }

    @Override // com.appnew.android.home.Activity.BaseABNoNavActivity
    protected Fragment getFragment() {
        this.filterIV.setVisibility(8);
        Log.e("RESULT_DEBUG_SSC", "getFragment: " + this.attemptOrReAttempt);
        if (dataSendListener != null && !TextUtils.isEmpty(this.live_test_feedback) && this.live_test_feedback.equalsIgnoreCase("1") && !TextUtils.isEmpty(this.attemptOrReAttempt) && this.attemptOrReAttempt.equalsIgnoreCase(Const.ATTEMPT)) {
            dataSendListener.onDataSent(0L, String.valueOf(this.status), this.attemptOrReAttempt, 2);
        }
        String str = this.frag_type;
        str.hashCode();
        switch (str) {
            case "create_result":
                setToolbarTitle("My Result");
                return TestCreateResult.newInstance(this.revision_string, this.response, this.testseriesBase);
            case "revision_scrren":
                setToolbarTitle("Revision Result");
                return RevisionResult.newInstance(this.revision_string, this.questionBankList, this.testseriesBase);
            case "leader_board":
                setToolbarTitle("Leaderboard");
                return LeaderBoard.newInstance(this.frag_type, this.status, this.testName, this.first_attempt);
            case "SOLUTIONREPORT":
                setToolbarTitle("Solution Report");
                if (!TextUtils.isEmpty(this.status)) {
                    return QuizResultScreenNew.newInstance(this.frag_type, this.status, this.testName, this.first_attempt, this.show_leader, this.mode);
                }
                return QuizResultScreenNew.newInstance(this.frag_type, this.resultTestSeries, this.quiz, this.testName, this.first_attempt, this.mode);
            case "test_series":
                setToolbarTitle("Quiz");
                if (this.filterIV.getVisibility() == 8) {
                    this.filterIV.setVisibility(8);
                }
                this.filterIV.setOnClickListener(this.navigatorClickListener);
                return Quiz.newInstance(this.frag_type, this.quiz, this.practiceOrQuiz);
            case "My Scorecard":
                setToolbarTitle("Leaderboard");
                return LeaderBoardFragment.newInstance(this.frag_type, this.practiceOrQuiz);
            case "resultscreen":
                setToolbarTitle("Result");
                if (!TextUtils.isEmpty(this.status)) {
                    return QuizResultScreenNew.newInstance(this.frag_type, this.status, this.testName, this.first_attempt, this.show_leader, this.mode);
                }
                return QuizResultScreenNew.newInstance(this.frag_type, this.resultTestSeries, this.quiz, this.testName, this.first_attempt, this.mode);
            case "Solution":
                setToolbarTitle("Solutions");
                return QuizSolutions.newInstance(this.frag_type, this.status);
            default:
                return null;
        }
    }

    @Override // com.appnew.android.home.Activity.BaseABNoNavActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context newBase) {
        String str;
        if (SharedPreference.getInstance().getInt(Const.LANGUAGE) == 2) {
            str = Const.HINDI;
        } else {
            str = Const.ENGLISH;
        }
        super.attachBaseContext(CustomContextWrapper.wrap(newBase, str));
    }
}
