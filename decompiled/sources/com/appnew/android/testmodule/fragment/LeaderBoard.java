package com.appnew.android.testmodule.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.Courses.quiz.QuizModel;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.MainFragment;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.NonScrollRecyclerView;
import com.appnew.android.Utils.Progress;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.pojo.Userinfo.Data;
import com.appnew.android.testmodule.adapter.AnswerListAdapter;
import com.appnew.android.testmodule.adapter.RankAdapter;
import com.appnew.android.testmodule.model.QuestionDump;
import com.appnew.android.testmodule.model.ResultTestSeries_Report;
import com.appnew.android.testmodule.model.TestSeriesResultData;
import com.appnew.android.testmodule.model.TopTenList;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes6.dex */
public class LeaderBoard extends MainFragment {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    LinearLayout accuracy_LL;
    Activity activity;
    RankAdapter adapter;
    AnswerListAdapter answerListAdapter;
    NonScrollRecyclerView answerListRV;
    ArrayList<String> arrayList;
    Button backBtn;
    int lang;
    TextView leaderboard_text;
    NestedScrollView mainLL;
    Progress mprogress;
    ArrayList<QuestionDump> newQuestionDump;
    RelativeLayout noDataFound;
    LinearLayout percentileLL;
    Progress progress;
    QuizModel quiz;
    RelativeLayout rankRL;
    NonScrollRecyclerView recyclerviewrank;
    LinearLayout resultDeclaredLL;
    ResultTestSeries_Report resultTestSeries2;
    LinearLayout scoreLL;
    ArrayList<TestSeriesResultData> testSeriesResultDataArrayList;
    String testseriesid;
    public Data user;
    LinearLayout videosolution;
    LinearLayout videosolution2;
    RelativeLayout viewSubjectWiseDetailRL;
    View viewaccuracy;
    View viewpercentile;
    String frag_type = "";
    String status = "";
    String testSeriesName = "";
    String first_attempt = "";
    List<TopTenList> topTenLists = new ArrayList();

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

    public static Fragment newInstance(String frag_type, String status, String testSeriesName, String first_attempt) {
        LeaderBoard leaderBoard = new LeaderBoard();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Const.FRAG_TYPE, frag_type);
        bundle.putSerializable("status", status);
        bundle.putString("name", testSeriesName);
        bundle.putString("first_attempt", first_attempt);
        leaderBoard.setArguments(bundle);
        return leaderBoard;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.leader_board, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.user = SharedPreference.getInstance().getLoggedInUser();
        Progress progress = new Progress(this.activity);
        this.mprogress = progress;
        progress.setCancelable(false);
        initViews(view);
        this.arrayList = new ArrayList<>();
        this.testSeriesResultDataArrayList = new ArrayList<>();
        this.newQuestionDump = new ArrayList<>();
        netoworkCallForQuizResult2();
    }

    public void netoworkCallForQuizResult2() {
        if (Helper.isNetworkConnected(getActivity())) {
            this.mprogress.show();
            APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setTest_id(this.status);
            encryptionData.setCourse_id(SharedPreference.getInstance().getString("id"));
            aPIInterface.get_test_leaderboard(AES.encrypt(new Gson().toJson(encryptionData))).enqueue(new Callback<String>() { // from class: com.appnew.android.testmodule.fragment.LeaderBoard.1
                @Override // retrofit2.Callback
                public void onResponse(Call<String> call, Response<String> response) {
                    JSONObject jSONObject;
                    LeaderBoard.this.mprogress.dismiss();
                    if (response.body() != null) {
                        try {
                            jSONObject = new JSONObject(AES.decrypt(response.body(), AES.generatekeyAPI(), AES.generateVectorAPI()));
                            try {
                                LeaderBoard.this.resultTestSeries2 = (ResultTestSeries_Report) new Gson().fromJson(jSONObject.toString(), ResultTestSeries_Report.class);
                            } catch (Exception unused) {
                                LeaderBoard.this.resultTestSeries2 = null;
                            }
                        } catch (Exception unused2) {
                            jSONObject = null;
                        }
                        if (LeaderBoard.this.resultTestSeries2 == null) {
                            Helper.showToastSecurity(LeaderBoard.this.activity);
                            return;
                        }
                        MakeMyExam.setTime_server(Long.parseLong(jSONObject.optString("time")) * 1000);
                        try {
                            if (LeaderBoard.this.resultTestSeries2.getStatus().equalsIgnoreCase("true")) {
                                LeaderBoard leaderBoard = LeaderBoard.this;
                                leaderBoard.topTenLists = leaderBoard.resultTestSeries2.getData().getTop_ten_list();
                                if (LeaderBoard.this.topTenLists.size() > 0) {
                                    LeaderBoard.this.mainLL.setVisibility(0);
                                    LeaderBoard.this.noDataFound.setVisibility(8);
                                    LeaderBoard.this.adapter = new RankAdapter(LeaderBoard.this.activity, LeaderBoard.this.topTenLists);
                                    LeaderBoard.this.recyclerviewrank.setAdapter(LeaderBoard.this.adapter);
                                    return;
                                }
                                LeaderBoard.this.mainLL.setVisibility(8);
                                LeaderBoard.this.noDataFound.setVisibility(0);
                                return;
                            }
                            if (LeaderBoard.this.topTenLists.size() <= 0) {
                                LeaderBoard.this.mainLL.setVisibility(8);
                                LeaderBoard.this.noDataFound.setVisibility(0);
                            }
                            LeaderBoard.this.mprogress.dismiss();
                            RetrofitResponse.GetApiData(LeaderBoard.this.activity, jSONObject.optString("auth_code"), jSONObject.optString("message"), false);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<String> call, Throwable t) {
                    LeaderBoard.this.mprogress.dismiss();
                }
            });
            return;
        }
        Toast.makeText(getActivity(), getActivity().getResources().getString(R.string.Retry_with_Internet_connection), 1).show();
    }

    private void initViews(View view) {
        this.recyclerviewrank = (NonScrollRecyclerView) view.findViewById(R.id.leaderBoardRV);
        this.leaderboard_text = (TextView) view.findViewById(R.id.leaderboard_text);
        this.resultDeclaredLL = (LinearLayout) view.findViewById(R.id.resultDeclaredLL);
        this.mainLL = (NestedScrollView) view.findViewById(R.id.mainLL);
        this.noDataFound = (RelativeLayout) view.findViewById(R.id.no_data_found_RL);
        Button button = (Button) view.findViewById(R.id.backBtn);
        this.backBtn = button;
        button.setVisibility(8);
        this.recyclerviewrank.setLayoutManager(new LinearLayoutManager(this.activity));
        this.recyclerviewrank.setHasFixedSize(true);
    }

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.frag_type = getArguments().getString(Const.FRAG_TYPE);
            this.quiz = (QuizModel) getArguments().getSerializable(Const.RESULT_SCREEN);
            this.status = getArguments().getString("status");
            this.testSeriesName = getArguments().getString("name");
            this.first_attempt = getArguments().getString("first_attempt");
        }
        this.activity = getActivity();
    }
}
